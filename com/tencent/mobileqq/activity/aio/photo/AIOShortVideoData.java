package com.tencent.mobileqq.activity.aio.photo;

import android.os.Parcel;
import com.tencent.mobileqq.richmediabrowser.AIOBrowserBaseData;
import com.tencent.mtt.hippy.bridge.HippyBridge;
import java.io.File;

/* compiled from: P */
/* loaded from: classes10.dex */
public class AIOShortVideoData extends AIORichMediaData {
    public int H;
    public int I;
    public boolean J;
    public boolean K;
    public int L;
    public int M;
    public long N;
    public int V;
    public String Y;
    public String Z;
    public String F = AIOBrowserBaseData.MEDIA_FILE_NONE;
    public String G = AIOBrowserBaseData.MEDIA_FILE_NONE;
    public int P = 0;
    public String Q = "";
    public String R = "";
    public int S = 0;
    public String T = "";
    public int U = 0;
    public int W = 0;
    private String X = null;

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
        this.L = parcel.readInt();
        this.M = parcel.readInt();
        this.N = parcel.readLong();
        this.P = parcel.readInt();
        this.Q = parcel.readString();
        this.R = parcel.readString();
        this.S = parcel.readInt();
        this.T = parcel.readString();
        this.U = parcel.readInt();
        this.W = parcel.readInt();
        this.V = parcel.readInt();
        this.Y = parcel.readString();
        this.Z = parcel.readString();
    }

    @Override // com.tencent.mobileqq.activity.aio.photo.AIORichMediaData, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        super.writeToParcel(parcel, i3);
        parcel.writeString(this.F);
        parcel.writeString(this.G);
        parcel.writeInt(this.H);
        parcel.writeInt(this.I);
        parcel.writeInt(this.L);
        parcel.writeInt(this.M);
        parcel.writeLong(this.N);
        parcel.writeInt(this.P);
        parcel.writeString(this.Q);
        parcel.writeString(this.R);
        parcel.writeInt(this.S);
        parcel.writeString(this.T);
        parcel.writeInt(this.U);
        parcel.writeInt(this.W);
        parcel.writeInt(this.V);
        parcel.writeString(this.Y);
        parcel.writeString(this.Z);
    }
}
