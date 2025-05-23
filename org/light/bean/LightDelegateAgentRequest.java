package org.light.bean;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.SharedMemory;
import android.system.OsConstants;
import android.util.Log;
import androidx.annotation.RequiresApi;
import java.nio.ByteBuffer;
import org.light.device.LightDeviceProperty;

/* compiled from: P */
/* loaded from: classes29.dex */
public class LightDelegateAgentRequest implements Parcelable {
    public static final Parcelable.Creator<LightDelegateAgentRequest> CREATOR = new Parcelable.Creator<LightDelegateAgentRequest>() { // from class: org.light.bean.LightDelegateAgentRequest.1
        @Override // android.os.Parcelable.Creator
        public LightDelegateAgentRequest createFromParcel(Parcel parcel) {
            return new LightDelegateAgentRequest(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public LightDelegateAgentRequest[] newArray(int i3) {
            return new LightDelegateAgentRequest[i3];
        }
    };
    public byte[] camera_frame_data_;
    public int camera_frame_height_;
    public int camera_frame_width_;
    public String json_string_;
    public String key_;
    public long nativeContext;
    public SharedMemory sharedMemory;

    public LightDelegateAgentRequest(String str, byte[] bArr, int i3, int i16, String str2, long j3) {
        this.key_ = str;
        this.camera_frame_data_ = bArr;
        this.camera_frame_width_ = i3;
        this.camera_frame_height_ = i16;
        this.json_string_ = str2;
        this.nativeContext = j3;
    }

    private native void nativeRelease();

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    protected void finalize() throws Throwable {
        super.finalize();
        SharedMemory sharedMemory = this.sharedMemory;
        if (sharedMemory != null) {
            sharedMemory.close();
        }
        nativeRelease();
    }

    public void getDataFromSharedMemory() {
        ByteBuffer mapReadOnly;
        if (LightDeviceProperty.VERSION.SDK_INT >= 27) {
            try {
                SharedMemory sharedMemory = this.sharedMemory;
                if (sharedMemory != null) {
                    mapReadOnly = sharedMemory.mapReadOnly();
                    byte[] bArr = new byte[mapReadOnly.limit() - mapReadOnly.position()];
                    mapReadOnly.get(bArr);
                    this.camera_frame_data_ = bArr;
                    SharedMemory.unmap(mapReadOnly);
                    return;
                }
                Log.e("TAG", "yzm sharedMemory return");
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        }
    }

    public void putDataToSharedMemory() {
        SharedMemory create;
        ByteBuffer mapReadWrite;
        SharedMemory sharedMemory = this.sharedMemory;
        if (sharedMemory != null) {
            sharedMemory.close();
            this.sharedMemory = null;
        }
        if (LightDeviceProperty.VERSION.SDK_INT >= 27) {
            try {
                create = SharedMemory.create("SharedMemory" + System.currentTimeMillis(), this.camera_frame_data_.length);
                this.sharedMemory = create;
                mapReadWrite = create.mapReadWrite();
                mapReadWrite.put(this.camera_frame_data_);
                this.sharedMemory.setProtect(OsConstants.PROT_READ);
                SharedMemory.unmap(mapReadWrite);
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        }
    }

    @Override // android.os.Parcelable
    @RequiresApi(api = 27)
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeString(this.key_);
        parcel.writeByteArray(this.camera_frame_data_);
        parcel.writeInt(this.camera_frame_width_);
        parcel.writeInt(this.camera_frame_height_);
        parcel.writeString(this.json_string_);
        parcel.writeLong(this.nativeContext);
        parcel.writeParcelable(this.sharedMemory, i3);
    }

    @RequiresApi(api = 27)
    protected LightDelegateAgentRequest(Parcel parcel) {
        this.key_ = parcel.readString();
        this.camera_frame_data_ = parcel.createByteArray();
        this.camera_frame_width_ = parcel.readInt();
        this.camera_frame_height_ = parcel.readInt();
        this.json_string_ = parcel.readString();
        this.nativeContext = parcel.readLong();
        this.sharedMemory = (SharedMemory) parcel.readParcelable(SharedMemory.class.getClassLoader());
    }
}
