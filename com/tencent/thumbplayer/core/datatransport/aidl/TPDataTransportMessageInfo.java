package com.tencent.thumbplayer.core.datatransport.aidl;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes26.dex */
public class TPDataTransportMessageInfo implements Parcelable {
    public static final Parcelable.Creator<TPDataTransportMessageInfo> CREATOR = new Parcelable.Creator<TPDataTransportMessageInfo>() { // from class: com.tencent.thumbplayer.core.datatransport.aidl.TPDataTransportMessageInfo.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public TPDataTransportMessageInfo createFromParcel(Parcel parcel) {
            return new TPDataTransportMessageInfo(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public TPDataTransportMessageInfo[] newArray(int i3) {
            return new TPDataTransportMessageInfo[i3];
        }
    };
    private static final int OBJ_FLAG_NON_Parcelable = 2;
    private static final int OBJ_FLAG_NULL = 0;
    private static final int OBJ_FLAG_Parcelable = 1;
    public int messageType;
    public Object obj1;
    public Object obj2;
    public Object obj3;
    public Object obj4;
    public int taskId;

    public TPDataTransportMessageInfo(int i3, int i16) {
        this(i3, i16, null);
    }

    private Object readObj(Parcel parcel) {
        int readInt = parcel.readInt();
        if (readInt == 1) {
            return parcel.readParcelable(getClass().getClassLoader());
        }
        if (readInt == 2) {
            return parcel.readValue(getClass().getClassLoader());
        }
        return null;
    }

    private void writeObj(Parcel parcel, int i3, Object obj) {
        if (obj != null) {
            try {
                parcel.writeInt(1);
                parcel.writeParcelable((Parcelable) obj, i3);
            } catch (ClassCastException unused) {
            } catch (Throwable th5) {
                parcel.writeInt(2);
                parcel.writeValue(obj);
                throw th5;
            }
            parcel.writeInt(2);
            parcel.writeValue(obj);
            return;
        }
        parcel.writeInt(0);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeInt(this.taskId);
        parcel.writeInt(this.messageType);
        writeObj(parcel, i3, this.obj1);
        writeObj(parcel, i3, this.obj2);
        writeObj(parcel, i3, this.obj3);
        writeObj(parcel, i3, this.obj4);
    }

    public TPDataTransportMessageInfo(int i3, int i16, Object obj) {
        this(i3, i16, obj, null);
    }

    public TPDataTransportMessageInfo(int i3, int i16, Object obj, Object obj2) {
        this(i3, i16, obj, obj2, null);
    }

    public TPDataTransportMessageInfo(int i3, int i16, Object obj, Object obj2, Object obj3) {
        this(i3, i16, obj, obj2, obj3, null);
    }

    public TPDataTransportMessageInfo(int i3, int i16, Object obj, Object obj2, Object obj3, Object obj4) {
        this.taskId = i3;
        this.messageType = i16;
        this.obj1 = obj;
        this.obj2 = obj2;
        this.obj3 = obj3;
        this.obj4 = obj4;
    }

    protected TPDataTransportMessageInfo(Parcel parcel) {
        this.taskId = parcel.readInt();
        this.messageType = parcel.readInt();
        this.obj1 = readObj(parcel);
        this.obj2 = readObj(parcel);
        this.obj3 = readObj(parcel);
        this.obj4 = readObj(parcel);
    }
}
