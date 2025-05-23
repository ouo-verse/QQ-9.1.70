package com.tencent.mobileqq.activity.aio.photo;

import android.os.Parcel;
import com.tencent.mobileqq.richmediabrowser.AIOBrowserBaseData;
import com.tencent.mtt.hippy.bridge.HippyBridge;
import java.io.File;

/* compiled from: P */
/* loaded from: classes10.dex */
public class AIOLightVideoData extends AIORichMediaData {
    public String F = AIOBrowserBaseData.MEDIA_FILE_NONE;
    public String G = AIOBrowserBaseData.MEDIA_FILE_NONE;
    public int H;
    public int I;
    public int J;
    public int K;
    public long L;

    @Override // com.tencent.mobileqq.activity.aio.photo.AIORichMediaData
    public File a(int i3) {
        String str;
        if (i3 != 0) {
            if (i3 != 1) {
                str = null;
            } else {
                str = this.G;
            }
        } else {
            str = this.F;
        }
        if (str != null && !str.equals(AIOBrowserBaseData.MEDIA_FILE_NONE)) {
            File file = new File(str);
            if (file.exists()) {
                return file;
            }
        }
        return null;
    }

    @Override // com.tencent.mobileqq.activity.aio.photo.AIORichMediaData
    public String b(int i3) {
        String str;
        if (i3 != 0) {
            if (i3 != 1) {
                str = null;
            } else {
                str = this.G;
            }
        } else {
            str = this.F;
        }
        if (str == null || str.equals(AIOBrowserBaseData.MEDIA_FILE_NONE)) {
            return null;
        }
        if (!str.startsWith("/")) {
            return "file:/" + str;
        }
        if (str.startsWith("//")) {
            return HippyBridge.URI_SCHEME_FILE + str;
        }
        return HippyBridge.URI_SCHEME_FILE + str;
    }

    @Override // com.tencent.mobileqq.activity.aio.photo.AIORichMediaData, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.tencent.mobileqq.activity.aio.photo.AIORichMediaData
    public void e(Parcel parcel) {
        super.e(parcel);
        this.F = parcel.readString();
        this.G = parcel.readString();
        this.H = parcel.readInt();
        this.I = parcel.readInt();
        this.J = parcel.readInt();
        this.K = parcel.readInt();
        this.L = parcel.readLong();
    }

    @Override // com.tencent.mobileqq.activity.aio.photo.AIORichMediaData, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        super.writeToParcel(parcel, i3);
        parcel.writeString(this.F);
        parcel.writeString(this.G);
        parcel.writeInt(this.H);
        parcel.writeInt(this.I);
        parcel.writeInt(this.J);
        parcel.writeInt(this.K);
        parcel.writeLong(this.L);
    }
}
