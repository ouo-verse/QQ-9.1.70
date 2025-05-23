package com.tencent.mobileqq.activity.aio.photo;

import android.os.Parcel;
import com.tencent.mobileqq.richmediabrowser.AIOBrowserBaseData;
import com.tencent.mtt.hippy.bridge.HippyBridge;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.net.MalformedURLException;

/* compiled from: P */
/* loaded from: classes10.dex */
public class AIOImageData extends AIORichMediaData {
    public boolean N;
    public int P;
    public boolean Q;
    public boolean R;
    public long S;
    public long T;
    public long V;
    public long W;
    public String X;
    public Object Z;

    /* renamed from: b0, reason: collision with root package name */
    public long f179571b0;

    /* renamed from: c0, reason: collision with root package name */
    public String f179572c0;

    /* renamed from: d0, reason: collision with root package name */
    public String f179573d0;

    /* renamed from: e0, reason: collision with root package name */
    public int f179574e0;

    /* renamed from: f0, reason: collision with root package name */
    public int f179575f0;

    /* renamed from: g0, reason: collision with root package name */
    public String f179576g0;

    /* renamed from: h0, reason: collision with root package name */
    public String f179577h0;

    /* renamed from: i0, reason: collision with root package name */
    public String f179578i0;

    /* renamed from: k0, reason: collision with root package name */
    public int f179580k0;

    /* renamed from: l0, reason: collision with root package name */
    public boolean f179581l0;

    /* renamed from: m0, reason: collision with root package name */
    public String f179582m0;

    /* renamed from: n0, reason: collision with root package name */
    public boolean f179583n0;

    /* renamed from: o0, reason: collision with root package name */
    public String f179584o0;

    /* renamed from: p0, reason: collision with root package name */
    public String f179585p0;

    /* renamed from: q0, reason: collision with root package name */
    public String f179586q0;

    /* renamed from: r0, reason: collision with root package name */
    public String f179587r0;
    public String F = AIOBrowserBaseData.MEDIA_FILE_NONE;
    public String G = AIOBrowserBaseData.MEDIA_FILE_NONE;
    public String H = AIOBrowserBaseData.MEDIA_FILE_NONE;
    public String I = AIOBrowserBaseData.MEDIA_FILE_NONE;
    public boolean J = false;
    public boolean K = false;
    public boolean L = false;
    public boolean M = false;
    public String U = AIOBrowserBaseData.MEDIA_FILE_NONE;
    public int Y = 0;

    /* renamed from: a0, reason: collision with root package name */
    public boolean f179570a0 = false;

    /* renamed from: j0, reason: collision with root package name */
    public boolean f179579j0 = false;

    @Override // com.tencent.mobileqq.activity.aio.photo.AIORichMediaData
    public File a(int i3) {
        String str;
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 4) {
                    if (i3 != 8) {
                        str = null;
                    } else {
                        str = this.I;
                    }
                } else {
                    str = this.H;
                }
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
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 4) {
                    if (i3 != 8) {
                        str = null;
                    } else {
                        str = this.I;
                    }
                } else {
                    str = this.H;
                }
            } else {
                str = this.G;
            }
        } else {
            str = this.F;
        }
        if (str != null && !str.equals(AIOBrowserBaseData.MEDIA_FILE_NONE)) {
            if (this.Y == 3) {
                try {
                    return new File(str).toURI().toURL().toString();
                } catch (MalformedURLException e16) {
                    e16.printStackTrace();
                }
            } else {
                if (!str.startsWith("/")) {
                    return "file:/" + str;
                }
                if (str.startsWith("//")) {
                    return HippyBridge.URI_SCHEME_FILE + str;
                }
                return HippyBridge.URI_SCHEME_FILE + str;
            }
        }
        return null;
    }

    @Override // com.tencent.mobileqq.activity.aio.photo.AIORichMediaData, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.tencent.mobileqq.activity.aio.photo.AIORichMediaData
    public void e(Parcel parcel) {
        boolean z16;
        boolean z17;
        boolean z18;
        boolean z19;
        boolean z26;
        boolean z27;
        super.e(parcel);
        this.F = parcel.readString();
        this.G = parcel.readString();
        this.H = parcel.readString();
        this.I = parcel.readString();
        this.U = parcel.readString();
        this.V = parcel.readLong();
        this.W = parcel.readLong();
        this.S = parcel.readLong();
        this.T = parcel.readLong();
        boolean z28 = false;
        if (parcel.readByte() != 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        this.N = z16;
        if (parcel.readByte() != 0) {
            z17 = true;
        } else {
            z17 = false;
        }
        this.Q = z17;
        if (parcel.readByte() != 0) {
            z18 = true;
        } else {
            z18 = false;
        }
        this.R = z18;
        this.P = parcel.readInt();
        this.Y = parcel.readInt();
        try {
            this.Z = parcel.readValue(null);
        } catch (Exception unused) {
            if (QLog.isColorLevel()) {
                QLog.i("AIOImageData", 2, "readValue exception");
            }
            this.Z = new byte[0];
        }
        if (parcel.readByte() != 0) {
            z19 = true;
        } else {
            z19 = false;
        }
        this.f179570a0 = z19;
        this.f179571b0 = parcel.readLong();
        this.f179572c0 = parcel.readString();
        this.f179573d0 = parcel.readString();
        this.f179574e0 = parcel.readInt();
        this.f179575f0 = parcel.readInt();
        this.f179576g0 = parcel.readString();
        this.X = parcel.readString();
        this.f179577h0 = parcel.readString();
        this.f179578i0 = parcel.readString();
        if (parcel.readInt() == 1) {
            z26 = true;
        } else {
            z26 = false;
        }
        this.f179579j0 = z26;
        this.f179580k0 = parcel.readInt();
        if (parcel.readInt() == 1) {
            z27 = true;
        } else {
            z27 = false;
        }
        this.f179581l0 = z27;
        this.f179582m0 = parcel.readString();
        if (parcel.readInt() == 1) {
            z28 = true;
        }
        this.f179583n0 = z28;
        this.f179584o0 = parcel.readString();
        this.f179585p0 = parcel.readString();
        this.f179586q0 = parcel.readString();
        this.f179587r0 = parcel.readString();
    }

    public boolean f(int i3) {
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 4) {
                    return false;
                }
                if (this.Y == 3) {
                    return true;
                }
                return !this.H.equals(AIOBrowserBaseData.MEDIA_FILE_NONE);
            }
            return !this.G.equals(AIOBrowserBaseData.MEDIA_FILE_NONE);
        }
        return !this.F.equals(AIOBrowserBaseData.MEDIA_FILE_NONE);
    }

    @Override // com.tencent.mobileqq.activity.aio.photo.AIORichMediaData, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        super.writeToParcel(parcel, i3);
        parcel.writeString(this.F);
        parcel.writeString(this.G);
        parcel.writeString(this.H);
        parcel.writeString(this.I);
        parcel.writeString(this.U);
        parcel.writeLong(this.V);
        parcel.writeLong(this.W);
        parcel.writeLong(this.S);
        parcel.writeLong(this.T);
        parcel.writeByte(this.N ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.Q ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.R ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.P);
        parcel.writeInt(this.Y);
        parcel.writeValue(this.Z);
        parcel.writeByte(this.f179570a0 ? (byte) 1 : (byte) 0);
        parcel.writeLong(this.f179571b0);
        parcel.writeString(this.f179572c0);
        parcel.writeString(this.f179573d0);
        parcel.writeInt(this.f179574e0);
        parcel.writeInt(this.f179575f0);
        parcel.writeString(this.f179576g0);
        parcel.writeString(this.X);
        parcel.writeString(this.f179577h0);
        parcel.writeString(this.f179578i0);
        parcel.writeInt(this.f179579j0 ? 1 : 0);
        parcel.writeInt(this.f179580k0);
        parcel.writeInt(this.f179581l0 ? 1 : 0);
        parcel.writeString(this.f179582m0);
        parcel.writeInt(this.f179583n0 ? 1 : 0);
        parcel.writeString(this.f179584o0);
        parcel.writeString(this.f179585p0);
        parcel.writeString(this.f179586q0);
        parcel.writeString(this.f179587r0);
    }
}
