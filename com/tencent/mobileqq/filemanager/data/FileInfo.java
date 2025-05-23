package com.tencent.mobileqq.filemanager.data;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.filemanager.util.ah;
import java.io.File;
import java.io.FileNotFoundException;

/* compiled from: P */
/* loaded from: classes12.dex */
public class FileInfo implements Parcelable {
    public static final Parcelable.Creator<FileInfo> CREATOR = new a();
    private int C;
    private String D;
    private String E;
    private boolean F = false;
    private boolean G = false;
    private boolean H = false;

    /* renamed from: d, reason: collision with root package name */
    private String f207678d;

    /* renamed from: e, reason: collision with root package name */
    private int f207679e;

    /* renamed from: f, reason: collision with root package name */
    private String f207680f;

    /* renamed from: h, reason: collision with root package name */
    private long f207681h;

    /* renamed from: i, reason: collision with root package name */
    private long f207682i;

    /* renamed from: m, reason: collision with root package name */
    private String f207683m;

    /* compiled from: P */
    /* loaded from: classes12.dex */
    class a implements Parcelable.Creator<FileInfo> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public FileInfo createFromParcel(Parcel parcel) {
            return new FileInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public FileInfo[] newArray(int i3) {
            return new FileInfo[i3];
        }
    }

    public FileInfo(String str) throws FileNotFoundException {
        if (str != null) {
            B(ah.o0(this.f207680f));
            q("");
            u("");
            File file = new File(str);
            if (file.exists()) {
                t(file.isDirectory());
                z(file.getAbsolutePath());
                y(file.getName());
                A(file.length());
                r(file.lastModified());
                return;
            }
            throw new FileNotFoundException("file not exist!");
        }
        throw new FileNotFoundException("file path is null!");
    }

    private boolean a(FileInfo fileInfo) {
        if (l() == fileInfo.l() && e() == fileInfo.e() && k().equals(fileInfo.k())) {
            return true;
        }
        return false;
    }

    public static FileInfo b(String str) {
        if (str == null || str.length() == 0) {
            return null;
        }
        File file = new File(str);
        if (!file.exists()) {
            return null;
        }
        if (file.length() != 0) {
            try {
            } catch (FileNotFoundException unused) {
                return null;
            }
        }
        return new FileInfo(str);
    }

    public void A(long j3) {
        this.f207681h = j3;
    }

    public void B(int i3) {
        this.C = i3;
    }

    public String c() {
        return this.D;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public long e() {
        return this.f207682i;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && (obj instanceof FileInfo)) {
            return a((FileInfo) obj);
        }
        return false;
    }

    public String f() {
        return this.E;
    }

    public int g() {
        return this.f207679e;
    }

    public int getType() {
        return this.C;
    }

    public int hashCode() {
        return (j() + l() + e()).hashCode();
    }

    public String j() {
        return this.f207680f;
    }

    public String k() {
        return this.f207678d;
    }

    public long l() {
        return this.f207681h;
    }

    public boolean m() {
        return this.H;
    }

    public boolean n() {
        return this.F;
    }

    public boolean o() {
        return this.G;
    }

    public boolean p() {
        return this.f207678d.startsWith(AppConstants.SDCARD_FILE_SAVE_PATH);
    }

    public void q(String str) {
        this.D = str;
    }

    public void r(long j3) {
        this.f207682i = j3;
    }

    public void s(String str) {
        this.f207683m = str;
    }

    public void t(boolean z16) {
        this.H = z16;
    }

    public void u(String str) {
        this.E = str;
    }

    public void v() {
        this.F = true;
    }

    public void w(boolean z16) {
        this.G = z16;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeString(this.f207678d);
        parcel.writeString(this.f207680f);
        parcel.writeLong(this.f207681h);
        parcel.writeLong(this.f207682i);
        parcel.writeString(this.f207683m);
        parcel.writeInt(this.C);
        parcel.writeString(this.D);
        parcel.writeString(this.E);
    }

    public void x(int i3) {
        this.f207679e = i3;
    }

    public void y(String str) {
        this.f207680f = str;
    }

    public void z(String str) {
        this.f207678d = str;
    }

    public FileInfo() {
        z("");
        y("");
        A(0L);
        r(System.currentTimeMillis());
        s("");
        B(-1);
        q("");
        u("");
    }

    FileInfo(Parcel parcel) {
        z(parcel.readString());
        y(parcel.readString());
        A(parcel.readLong());
        r(parcel.readLong());
        s(parcel.readString());
        B(parcel.readInt());
        q(parcel.readString());
        u(parcel.readString());
    }
}
