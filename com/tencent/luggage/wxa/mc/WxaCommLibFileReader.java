package com.tencent.luggage.wxa.mc;

import android.content.res.AssetFileDescriptor;
import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.luggage.wxa.mc.a0;
import java.io.InputStream;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 .2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001/B#\u0012\u0006\u0010\u001c\u001a\u00020\u0006\u0012\u0006\u0010\u001f\u001a\u00020\u000e\u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u0006\u00a2\u0006\u0004\b*\u0010+B\u0011\b\u0016\u0012\u0006\u0010,\u001a\u00020\u0016\u00a2\u0006\u0004\b*\u0010-J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\u0014\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\u0014\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\b\u0010\f\u001a\u00020\u0002H\u0016J\b\u0010\r\u001a\u00020\u0006H\u0016J\b\u0010\u000f\u001a\u00020\u000eH\u0016J\b\u0010\u0011\u001a\u00020\u0010H\u0016J\b\u0010\u0012\u001a\u00020\u0004H\u0004J\b\u0010\u0013\u001a\u00020\u0004H\u0016J\b\u0010\u0014\u001a\u00020\u0006H\u0016J\b\u0010\u0015\u001a\u00020\u000eH\u0016J\u0018\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u000eH\u0016R\u0014\u0010\u001c\u001a\u00020\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0014\u0010\u001f\u001a\u00020\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010!\u001a\u0004\u0018\u00010\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b \u0010\u001bR\u0016\u0010%\u001a\u00020\"8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010)\u001a\u00020&8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b'\u0010(\u00a8\u00060"}, d2 = {"Lcom/tencent/luggage/wxa/mc/v;", "Lcom/tencent/luggage/wxa/mc/a;", "Lcom/tencent/luggage/wxa/mc/j;", "Landroid/os/Parcelable;", "", "init", "", WadlProxyConsts.PARAM_FILENAME, "Ljava/io/InputStream;", "a", "Landroid/content/res/AssetFileDescriptor;", "d", "e", "pkgPath", "", "pkgVersion", "", "lastModified", "finalize", "close", "toString", "describeContents", "Landroid/os/Parcel;", "dest", WadlProxyConsts.FLAGS, "writeToParcel", "f", "Ljava/lang/String;", "pkgFilePath", "g", "I", "pkgAppVersion", tl.h.F, "pkgFileMd5", "Lcom/tencent/luggage/wxa/cp/v;", "i", "Lcom/tencent/luggage/wxa/cp/v;", "vfsFile", "Lcom/tencent/luggage/wxa/mc/a0;", "j", "Lcom/tencent/luggage/wxa/mc/a0;", "wxaPkg", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "source", "(Landroid/os/Parcel;)V", "k", "b", "luggage-standalone-mode-ext_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.luggage.wxa.mc.v, reason: from toString */
/* loaded from: classes8.dex */
public final class WxaCommLibFileReader extends com.tencent.luggage.wxa.mc.a implements j, Parcelable {

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    public final String pkgFilePath;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    public final int pkgAppVersion;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    public final String pkgFileMd5;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    public com.tencent.luggage.wxa.cp.v vfsFile;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    public a0 wxaPkg;

    @JvmField
    @NotNull
    public static final Parcelable.Creator<WxaCommLibFileReader> CREATOR = new a();

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.mc.v$a */
    /* loaded from: classes8.dex */
    public static final class a implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public WxaCommLibFileReader createFromParcel(Parcel source) {
            Intrinsics.checkNotNullParameter(source, "source");
            return new WxaCommLibFileReader(source);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public WxaCommLibFileReader[] newArray(int i3) {
            return new WxaCommLibFileReader[i3];
        }
    }

    public /* synthetic */ WxaCommLibFileReader(String str, int i3, String str2, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, i3, (i16 & 4) != 0 ? com.tencent.mm.plugin.appbrand.appcache.a.a(new com.tencent.luggage.wxa.cp.v(str)) : str2);
    }

    @Override // com.tencent.luggage.wxa.mc.k
    public InputStream a(String fileName) {
        a0 a0Var = this.wxaPkg;
        a0 a0Var2 = null;
        if (a0Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("wxaPkg");
            a0Var = null;
        }
        a0Var.m();
        a0 a0Var3 = this.wxaPkg;
        if (a0Var3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("wxaPkg");
        } else {
            a0Var2 = a0Var3;
        }
        return a0Var2.b(fileName);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        try {
            a0 a0Var = this.wxaPkg;
            if (a0Var != null) {
                a0Var.close();
            }
        } catch (Throwable unused) {
        }
    }

    @Override // com.tencent.luggage.wxa.mc.k
    public AssetFileDescriptor d(String fileName) {
        a0 a0Var = this.wxaPkg;
        if (a0Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("wxaPkg");
            a0Var = null;
        }
        a0Var.m();
        a0 a0Var2 = this.wxaPkg;
        if (a0Var2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("wxaPkg");
            a0Var2 = null;
        }
        a0.a c16 = a0Var2.c(fileName);
        if (c16 == null) {
            return null;
        }
        return new AssetFileDescriptor(com.tencent.luggage.wxa.cp.x.c(c16.f134262a, "r"), c16.f134264c, c16.f134265d);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public final void finalize() {
        close();
    }

    @Override // com.tencent.luggage.wxa.mc.k
    public void init() {
        this.vfsFile = new com.tencent.luggage.wxa.cp.v(this.pkgFilePath);
        com.tencent.luggage.wxa.cp.v vVar = this.vfsFile;
        if (vVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("vfsFile");
            vVar = null;
        }
        a0 a0Var = new a0(vVar);
        this.wxaPkg = a0Var;
        a0Var.m();
    }

    @Override // com.tencent.luggage.wxa.mc.j
    public long lastModified() {
        com.tencent.luggage.wxa.cp.v vVar = this.vfsFile;
        if (vVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("vfsFile");
            vVar = null;
        }
        return vVar.r();
    }

    @Override // com.tencent.luggage.wxa.mc.j
    /* renamed from: pkgPath, reason: from getter */
    public String getPkgFilePath() {
        return this.pkgFilePath;
    }

    @Override // com.tencent.luggage.wxa.mc.j
    /* renamed from: pkgVersion, reason: from getter */
    public int getPkgAppVersion() {
        return this.pkgAppVersion;
    }

    public String toString() {
        return "WxaCommLibFileReader(path:" + this.pkgFilePath + ", version:" + this.pkgAppVersion + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        Intrinsics.checkNotNullParameter(dest, "dest");
        dest.writeString(this.pkgFilePath);
        dest.writeInt(this.pkgAppVersion);
        dest.writeString(this.pkgFileMd5);
    }

    public WxaCommLibFileReader(@NotNull String pkgFilePath, int i3, @Nullable String str) {
        Intrinsics.checkNotNullParameter(pkgFilePath, "pkgFilePath");
        this.pkgFilePath = pkgFilePath;
        this.pkgAppVersion = i3;
        this.pkgFileMd5 = str;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public WxaCommLibFileReader(@NotNull Parcel source) {
        this(r0 == null ? "" : r0, source.readInt(), source.readString());
        Intrinsics.checkNotNullParameter(source, "source");
        String readString = source.readString();
    }

    @Override // com.tencent.luggage.wxa.mc.k
    public j e() {
        return this;
    }
}
