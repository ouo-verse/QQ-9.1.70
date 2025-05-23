package fs3;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.vivo.push.PushClientConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b&\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u0001B\u008d\u0001\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010*\u001a\u00020\u0007\u0012\b\b\u0002\u0010-\u001a\u00020\u0007\u0012\n\b\u0002\u00103\u001a\u0004\u0018\u00010.\u0012\n\b\u0002\u00109\u001a\u0004\u0018\u000104\u0012\b\b\u0002\u0010;\u001a\u00020\u0004\u0012\b\b\u0002\u0010=\u001a\u00020\u0002\u00a2\u0006\u0004\b>\u0010?J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R$\u0010\u000e\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\t\u0010\u000b\"\u0004\b\f\u0010\rR$\u0010\u0012\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000f\u0010\n\u001a\u0004\b\u0010\u0010\u000b\"\u0004\b\u0011\u0010\rR\"\u0010\u0019\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R$\u0010\u001d\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001a\u0010\n\u001a\u0004\b\u001b\u0010\u000b\"\u0004\b\u001c\u0010\rR$\u0010 \u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001e\u0010\n\u001a\u0004\b\u0013\u0010\u000b\"\u0004\b\u001f\u0010\rR$\u0010$\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b!\u0010\n\u001a\u0004\b\"\u0010\u000b\"\u0004\b#\u0010\rR\"\u0010*\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\"\u0010%\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\"\u0010-\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b&\u0010%\u001a\u0004\b+\u0010'\"\u0004\b,\u0010)R$\u00103\u001a\u0004\u0018\u00010.8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u0010/\u001a\u0004\b\u000f\u00100\"\u0004\b1\u00102R$\u00109\u001a\u0004\u0018\u0001048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0015\u00105\u001a\u0004\b\u001a\u00106\"\u0004\b7\u00108R\"\u0010;\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001b\u0010\u0014\u001a\u0004\b\u001e\u0010\u0016\"\u0004\b:\u0010\u0018R\"\u0010=\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b+\u0010\n\u001a\u0004\b!\u0010\u000b\"\u0004\b<\u0010\r\u00a8\u0006@"}, d2 = {"Lfs3/a;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "()Ljava/lang/String;", "setAppName", "(Ljava/lang/String;)V", "appName", "b", "i", DomainData.DOMAIN_NAME, PushClientConstants.TAG_PKG_NAME, "c", "I", "j", "()I", "o", "(I)V", "versionCode", "d", "k", "setVersionName", "versionName", "e", "setIconFilePath", "iconFilePath", "f", "g", "setLoadingIconPath", "loadingIconPath", "Z", h.F, "()Z", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "(Z)V", "needLoading", "l", "setLandScape", "isLandScape", "Landroid/os/Bundle;", "Landroid/os/Bundle;", "()Landroid/os/Bundle;", "setExtendBundle", "(Landroid/os/Bundle;)V", "extendBundle", "Landroid/content/Intent;", "Landroid/content/Intent;", "()Landroid/content/Intent;", "setIntent", "(Landroid/content/Intent;)V", "intent", "setLaunchScene", "launchScene", "setLaunchVia", "launchVia", "<init>", "(Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZLandroid/os/Bundle;Landroid/content/Intent;ILjava/lang/String;)V", "minibox-api_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: fs3.a, reason: from toString */
/* loaded from: classes22.dex */
public final /* data */ class MiniBoxInfo {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private String appName;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private String pkgName;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private int versionCode;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private String versionName;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private String iconFilePath;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private String loadingIconPath;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata and from toString */
    private boolean needLoading;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata and from toString */
    private boolean isLandScape;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private Bundle extendBundle;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private Intent intent;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata and from toString */
    private int launchScene;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private String launchVia;

    public MiniBoxInfo() {
        this(null, null, 0, null, null, null, false, false, null, null, 0, null, 4095, null);
    }

    @Nullable
    /* renamed from: a, reason: from getter */
    public final String getAppName() {
        return this.appName;
    }

    @Nullable
    /* renamed from: b, reason: from getter */
    public final Bundle getExtendBundle() {
        return this.extendBundle;
    }

    @Nullable
    /* renamed from: c, reason: from getter */
    public final String getIconFilePath() {
        return this.iconFilePath;
    }

    @Nullable
    /* renamed from: d, reason: from getter */
    public final Intent getIntent() {
        return this.intent;
    }

    /* renamed from: e, reason: from getter */
    public final int getLaunchScene() {
        return this.launchScene;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MiniBoxInfo)) {
            return false;
        }
        MiniBoxInfo miniBoxInfo = (MiniBoxInfo) other;
        if (Intrinsics.areEqual(this.appName, miniBoxInfo.appName) && Intrinsics.areEqual(this.pkgName, miniBoxInfo.pkgName) && this.versionCode == miniBoxInfo.versionCode && Intrinsics.areEqual(this.versionName, miniBoxInfo.versionName) && Intrinsics.areEqual(this.iconFilePath, miniBoxInfo.iconFilePath) && Intrinsics.areEqual(this.loadingIconPath, miniBoxInfo.loadingIconPath) && this.needLoading == miniBoxInfo.needLoading && this.isLandScape == miniBoxInfo.isLandScape && Intrinsics.areEqual(this.extendBundle, miniBoxInfo.extendBundle) && Intrinsics.areEqual(this.intent, miniBoxInfo.intent) && this.launchScene == miniBoxInfo.launchScene && Intrinsics.areEqual(this.launchVia, miniBoxInfo.launchVia)) {
            return true;
        }
        return false;
    }

    @NotNull
    /* renamed from: f, reason: from getter */
    public final String getLaunchVia() {
        return this.launchVia;
    }

    @Nullable
    /* renamed from: g, reason: from getter */
    public final String getLoadingIconPath() {
        return this.loadingIconPath;
    }

    /* renamed from: h, reason: from getter */
    public final boolean getNeedLoading() {
        return this.needLoading;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode;
        int hashCode2;
        int hashCode3;
        int hashCode4;
        int hashCode5;
        int hashCode6;
        String str = this.appName;
        int i3 = 0;
        if (str == null) {
            hashCode = 0;
        } else {
            hashCode = str.hashCode();
        }
        int i16 = hashCode * 31;
        String str2 = this.pkgName;
        if (str2 == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = str2.hashCode();
        }
        int i17 = (((i16 + hashCode2) * 31) + this.versionCode) * 31;
        String str3 = this.versionName;
        if (str3 == null) {
            hashCode3 = 0;
        } else {
            hashCode3 = str3.hashCode();
        }
        int i18 = (i17 + hashCode3) * 31;
        String str4 = this.iconFilePath;
        if (str4 == null) {
            hashCode4 = 0;
        } else {
            hashCode4 = str4.hashCode();
        }
        int i19 = (i18 + hashCode4) * 31;
        String str5 = this.loadingIconPath;
        if (str5 == null) {
            hashCode5 = 0;
        } else {
            hashCode5 = str5.hashCode();
        }
        int i26 = (i19 + hashCode5) * 31;
        boolean z16 = this.needLoading;
        int i27 = 1;
        int i28 = z16;
        if (z16 != 0) {
            i28 = 1;
        }
        int i29 = (i26 + i28) * 31;
        boolean z17 = this.isLandScape;
        if (!z17) {
            i27 = z17 ? 1 : 0;
        }
        int i36 = (i29 + i27) * 31;
        Bundle bundle = this.extendBundle;
        if (bundle == null) {
            hashCode6 = 0;
        } else {
            hashCode6 = bundle.hashCode();
        }
        int i37 = (i36 + hashCode6) * 31;
        Intent intent = this.intent;
        if (intent != null) {
            i3 = intent.hashCode();
        }
        return ((((i37 + i3) * 31) + this.launchScene) * 31) + this.launchVia.hashCode();
    }

    @Nullable
    /* renamed from: i, reason: from getter */
    public final String getPkgName() {
        return this.pkgName;
    }

    /* renamed from: j, reason: from getter */
    public final int getVersionCode() {
        return this.versionCode;
    }

    @Nullable
    /* renamed from: k, reason: from getter */
    public final String getVersionName() {
        return this.versionName;
    }

    /* renamed from: l, reason: from getter */
    public final boolean getIsLandScape() {
        return this.isLandScape;
    }

    public final void m(boolean z16) {
        this.needLoading = z16;
    }

    public final void n(@Nullable String str) {
        this.pkgName = str;
    }

    public final void o(int i3) {
        this.versionCode = i3;
    }

    @NotNull
    public String toString() {
        return "MiniBoxInfo(appName=" + this.appName + ", pkgName=" + this.pkgName + ", versionCode=" + this.versionCode + ", versionName=" + this.versionName + ", iconFilePath=" + this.iconFilePath + ", loadingIconPath=" + this.loadingIconPath + ", needLoading=" + this.needLoading + ", isLandScape=" + this.isLandScape + ", extendBundle=" + this.extendBundle + ", intent=" + this.intent + ", launchScene=" + this.launchScene + ", launchVia=" + this.launchVia + ')';
    }

    public MiniBoxInfo(@Nullable String str, @Nullable String str2, int i3, @Nullable String str3, @Nullable String str4, @Nullable String str5, boolean z16, boolean z17, @Nullable Bundle bundle, @Nullable Intent intent, int i16, @NotNull String launchVia) {
        Intrinsics.checkNotNullParameter(launchVia, "launchVia");
        this.appName = str;
        this.pkgName = str2;
        this.versionCode = i3;
        this.versionName = str3;
        this.iconFilePath = str4;
        this.loadingIconPath = str5;
        this.needLoading = z16;
        this.isLandScape = z17;
        this.extendBundle = bundle;
        this.intent = intent;
        this.launchScene = i16;
        this.launchVia = launchVia;
    }

    public /* synthetic */ MiniBoxInfo(String str, String str2, int i3, String str3, String str4, String str5, boolean z16, boolean z17, Bundle bundle, Intent intent, int i16, String str6, int i17, DefaultConstructorMarker defaultConstructorMarker) {
        this((i17 & 1) != 0 ? null : str, (i17 & 2) != 0 ? null : str2, (i17 & 4) != 0 ? -1 : i3, (i17 & 8) != 0 ? null : str3, (i17 & 16) != 0 ? null : str4, (i17 & 32) != 0 ? null : str5, (i17 & 64) != 0 ? false : z16, (i17 & 128) != 0 ? false : z17, (i17 & 256) != 0 ? null : bundle, (i17 & 512) == 0 ? intent : null, (i17 & 1024) == 0 ? i16 : 0, (i17 & 2048) != 0 ? "" : str6);
    }
}
