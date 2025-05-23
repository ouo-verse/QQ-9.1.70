package com.tencent.mobileqq.leba.entity;

import androidx.exifinterface.media.ExifInterface;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0016\n\u0002\u0010\n\n\u0002\b\f\b\u0086\b\u0018\u0000 +2\u00020\u0001:\u0001\nBo\u0012\u0006\u0010\u000e\u001a\u00020\t\u0012\u0006\u0010\u0013\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010\u001f\u001a\u00020\u0007\u0012\b\b\u0002\u0010#\u001a\u00020 \u0012\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010'\u001a\u00020\u0007\u0012\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\u0002\u00a2\u0006\u0004\b)\u0010*J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0013\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0017\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0014\u0010\u0016R\u0019\u0010\u0019\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0018\u0010\u0010\u001a\u0004\b\u0018\u0010\u0012R\u0019\u0010\u001b\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u0010\u001a\u0004\b\u001a\u0010\u0012R\u0017\u0010\u001f\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\n\u0010\u001eR\u0017\u0010#\u001a\u00020 8\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010!\u001a\u0004\b\u001c\u0010\"R\u0019\u0010&\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b$\u0010\u0010\u001a\u0004\b%\u0010\u0012R\u0017\u0010'\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\u001a\u0010\u001d\u001a\u0004\b$\u0010\u001eR\u0019\u0010(\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b%\u0010\u0010\u001a\u0004\b\u000f\u0010\u0012\u00a8\u0006,"}, d2 = {"Lcom/tencent/mobileqq/leba/entity/o;", "", "", "toString", "", "hashCode", "other", "", "equals", "", "a", "J", "e", "()J", "id", "b", "Ljava/lang/String;", "g", "()Ljava/lang/String;", "name", "c", "I", "()I", "iconResId", "d", "iconResUrl", "i", "simpleIconResUrl", "f", "Z", "()Z", "canChangeState", "", ExifInterface.LATITUDE_SOUTH, "()S", "jumpType", tl.h.F, "j", "strGotoUrl", "showInSimpleMode", "daTongId", "<init>", "(JLjava/lang/String;ILjava/lang/String;Ljava/lang/String;ZSLjava/lang/String;ZLjava/lang/String;)V", "k", "qqleba-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final /* data */ class o {
    static IPatchRedirector $redirector_;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final long id;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String name;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final int iconResId;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final String iconResUrl;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final String simpleIconResUrl;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final boolean canChangeState;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private final short jumpType;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final String strGotoUrl;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final boolean showInSimpleMode;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final String daTongId;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/leba/entity/o$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqleba-api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.leba.entity.o$a, reason: from kotlin metadata */
    /* loaded from: classes15.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(26897);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 27)) {
            redirector.redirect((short) 27);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public o(long j3, @NotNull String name, int i3, @Nullable String str, @Nullable String str2, boolean z16, short s16, @Nullable String str3, boolean z17, @Nullable String str4) {
        Intrinsics.checkNotNullParameter(name, "name");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Long.valueOf(j3), name, Integer.valueOf(i3), str, str2, Boolean.valueOf(z16), Short.valueOf(s16), str3, Boolean.valueOf(z17), str4);
            return;
        }
        this.id = j3;
        this.name = name;
        this.iconResId = i3;
        this.iconResUrl = str;
        this.simpleIconResUrl = str2;
        this.canChangeState = z16;
        this.jumpType = s16;
        this.strGotoUrl = str3;
        this.showInSimpleMode = z17;
        this.daTongId = str4;
    }

    public final boolean a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this)).booleanValue();
        }
        return this.canChangeState;
    }

    @Nullable
    public final String b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (String) iPatchRedirector.redirect((short) 12, (Object) this);
        }
        return this.daTongId;
    }

    public final int c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
        }
        return this.iconResId;
    }

    @Nullable
    public final String d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.iconResUrl;
    }

    public final long e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Long) iPatchRedirector.redirect((short) 3, (Object) this)).longValue();
        }
        return this.id;
    }

    public boolean equals(@Nullable Object other) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            return ((Boolean) iPatchRedirector.redirect((short) 26, (Object) this, other)).booleanValue();
        }
        if (this == other) {
            return true;
        }
        if (!(other instanceof o)) {
            return false;
        }
        o oVar = (o) other;
        if (this.id == oVar.id && Intrinsics.areEqual(this.name, oVar.name) && this.iconResId == oVar.iconResId && Intrinsics.areEqual(this.iconResUrl, oVar.iconResUrl) && Intrinsics.areEqual(this.simpleIconResUrl, oVar.simpleIconResUrl) && this.canChangeState == oVar.canChangeState && this.jumpType == oVar.jumpType && Intrinsics.areEqual(this.strGotoUrl, oVar.strGotoUrl) && this.showInSimpleMode == oVar.showInSimpleMode && Intrinsics.areEqual(this.daTongId, oVar.daTongId)) {
            return true;
        }
        return false;
    }

    public final short f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Short) iPatchRedirector.redirect((short) 9, (Object) this)).shortValue();
        }
        return this.jumpType;
    }

    @NotNull
    public final String g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.name;
    }

    public final boolean h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Boolean) iPatchRedirector.redirect((short) 11, (Object) this)).booleanValue();
        }
        return this.showInSimpleMode;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode;
        int hashCode2;
        int hashCode3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            return ((Integer) iPatchRedirector.redirect((short) 25, (Object) this)).intValue();
        }
        int a16 = ((((androidx.fragment.app.a.a(this.id) * 31) + this.name.hashCode()) * 31) + this.iconResId) * 31;
        String str = this.iconResUrl;
        int i3 = 0;
        if (str == null) {
            hashCode = 0;
        } else {
            hashCode = str.hashCode();
        }
        int i16 = (a16 + hashCode) * 31;
        String str2 = this.simpleIconResUrl;
        if (str2 == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = str2.hashCode();
        }
        int i17 = (i16 + hashCode2) * 31;
        boolean z16 = this.canChangeState;
        int i18 = 1;
        int i19 = z16;
        if (z16 != 0) {
            i19 = 1;
        }
        int i26 = (((i17 + i19) * 31) + this.jumpType) * 31;
        String str3 = this.strGotoUrl;
        if (str3 == null) {
            hashCode3 = 0;
        } else {
            hashCode3 = str3.hashCode();
        }
        int i27 = (i26 + hashCode3) * 31;
        boolean z17 = this.showInSimpleMode;
        if (!z17) {
            i18 = z17 ? 1 : 0;
        }
        int i28 = (i27 + i18) * 31;
        String str4 = this.daTongId;
        if (str4 != null) {
            i3 = str4.hashCode();
        }
        return i28 + i3;
    }

    @Nullable
    public final String i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (String) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return this.simpleIconResUrl;
    }

    @Nullable
    public final String j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (String) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        return this.strGotoUrl;
    }

    @NotNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            return (String) iPatchRedirector.redirect((short) 24, (Object) this);
        }
        long j3 = this.id;
        String str = this.name;
        int i3 = this.iconResId;
        String str2 = this.iconResUrl;
        String str3 = this.simpleIconResUrl;
        boolean z16 = this.canChangeState;
        short s16 = this.jumpType;
        return "LocalPluginData(id=" + j3 + ", name=" + str + ", iconResId=" + i3 + ", iconResUrl=" + str2 + ", simpleIconResUrl=" + str3 + ", canChangeState=" + z16 + ", jumpType=" + ((int) s16) + ", strGotoUrl=" + this.strGotoUrl + ", showInSimpleMode=" + this.showInSimpleMode + ", daTongId=" + this.daTongId + ")";
    }

    public /* synthetic */ o(long j3, String str, int i3, String str2, String str3, boolean z16, short s16, String str4, boolean z17, String str5, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(j3, str, (i16 & 4) != 0 ? 0 : i3, (i16 & 8) != 0 ? null : str2, (i16 & 16) != 0 ? null : str3, (i16 & 32) != 0 ? true : z16, (i16 & 64) != 0 ? (short) 0 : s16, (i16 & 128) != 0 ? null : str4, (i16 & 256) != 0 ? true : z17, (i16 & 512) != 0 ? "" : str5);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, Long.valueOf(j3), str, Integer.valueOf(i3), str2, str3, Boolean.valueOf(z16), Short.valueOf(s16), str4, Boolean.valueOf(z17), str5, Integer.valueOf(i16), defaultConstructorMarker);
    }
}
