package ap2;

import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.qqlive.tvkplayer.tools.config.ITVKConfigRequester;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0013\n\u0002\u0010\b\n\u0002\b\n\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b'\u0010(J\u0006\u0010\u0003\u001a\u00020\u0002R\"\u0010\n\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\"\u0010\u0012\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\"\u0010\u0015\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0006\u0010\r\u001a\u0004\b\u0013\u0010\u000f\"\u0004\b\u0014\u0010\u0011R\"\u0010\u0019\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0016\u0010\r\u001a\u0004\b\u0017\u0010\u000f\"\u0004\b\u0018\u0010\u0011R\"\u0010\u001c\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001a\u0010\u0005\u001a\u0004\b\f\u0010\u0007\"\u0004\b\u001b\u0010\tR\"\u0010\u001e\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0013\u0010\r\u001a\u0004\b\u0004\u0010\u000f\"\u0004\b\u001d\u0010\u0011R\"\u0010$\u001a\u00020\u001f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000e\u0010 \u001a\u0004\b\u001a\u0010!\"\u0004\b\"\u0010#R\"\u0010&\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0017\u0010\r\u001a\u0004\b\u0016\u0010\u000f\"\u0004\b%\u0010\u0011\u00a8\u0006)"}, d2 = {"Lap2/g;", "", "", "i", "a", "Z", "c", "()Z", "l", "(Z)V", "enable", "", "b", "Ljava/lang/String;", "g", "()Ljava/lang/String;", "p", "(Ljava/lang/String;)V", "thirdAppUUID", "f", "o", "text", "d", h.F, QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "url", "e", "k", "checkAppInstalled", "j", DKEngine.GlobalKey.APP_PACKAGE_NAME, "", "I", "()I", DomainData.DOMAIN_NAME, "(I)V", "maxDisplayCount", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, ITVKConfigRequester.ConfigRequestListener.EXTRA_KEY_EXP_NAME, "<init>", "()V", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private boolean enable;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private boolean checkAppInstalled;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String thirdAppUUID = "";

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String text = "";

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String url = "";

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String appPackageName = "";

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private int maxDisplayCount = 10;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String expName = "";

    @NotNull
    /* renamed from: a, reason: from getter */
    public final String getAppPackageName() {
        return this.appPackageName;
    }

    /* renamed from: b, reason: from getter */
    public final boolean getCheckAppInstalled() {
        return this.checkAppInstalled;
    }

    /* renamed from: c, reason: from getter */
    public final boolean getEnable() {
        return this.enable;
    }

    @NotNull
    /* renamed from: d, reason: from getter */
    public final String getExpName() {
        return this.expName;
    }

    /* renamed from: e, reason: from getter */
    public final int getMaxDisplayCount() {
        return this.maxDisplayCount;
    }

    @NotNull
    /* renamed from: f, reason: from getter */
    public final String getText() {
        return this.text;
    }

    @NotNull
    /* renamed from: g, reason: from getter */
    public final String getThirdAppUUID() {
        return this.thirdAppUUID;
    }

    @NotNull
    /* renamed from: h, reason: from getter */
    public final String getUrl() {
        return this.url;
    }

    public final boolean i() {
        boolean z16;
        boolean z17;
        boolean z18;
        boolean z19;
        if (this.thirdAppUUID.length() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            if (this.text.length() > 0) {
                z17 = true;
            } else {
                z17 = false;
            }
            if (z17) {
                if (this.url.length() > 0) {
                    z18 = true;
                } else {
                    z18 = false;
                }
                if (z18) {
                    if (this.expName.length() > 0) {
                        z19 = true;
                    } else {
                        z19 = false;
                    }
                    if (z19) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public final void j(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.appPackageName = str;
    }

    public final void k(boolean z16) {
        this.checkAppInstalled = z16;
    }

    public final void l(boolean z16) {
        this.enable = z16;
    }

    public final void m(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.expName = str;
    }

    public final void n(int i3) {
        this.maxDisplayCount = i3;
    }

    public final void o(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.text = str;
    }

    public final void p(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.thirdAppUUID = str;
    }

    public final void q(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.url = str;
    }
}
