package com.tencent.mobileqq.springhb.prize;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.Toast;
import androidx.fragment.app.FragmentActivity;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.app.RouterConstants;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.profilecard.api.IProfileProtocolConst;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.springhb.pack.PackInfo;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\b&\u0018\u0000 \u00052\u00020\u0001:\u0001\u0007B\u000f\u0012\u0006\u0010\u001d\u001a\u00020\u001b\u00a2\u0006\u0004\b?\u0010@J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bH\u0016J\u0010\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\bH\u0016J\b\u0010\r\u001a\u00020\u0004H\u0016J\b\u0010\u000e\u001a\u00020\u0004H\u0016J\u0010\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u0006H\u0016J \u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u0011H\u0016J\u0010\u0010\u0016\u001a\u00020\u00042\b\u0010\u0015\u001a\u0004\u0018\u00010\u0006J\u0010\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u0006H\u0004J\u0010\u0010\u001a\u001a\u00020\u00042\b\u0010\u0019\u001a\u0004\u0018\u00010\u0006R\u0014\u0010\u001d\u001a\u00020\u001b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u001cR\"\u0010$\u001a\u00020\u001e8\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b\u001f\u0010!\"\u0004\b\"\u0010#R\"\u0010+\u001a\u00020%8\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b&\u0010'\u001a\u0004\b&\u0010(\"\u0004\b)\u0010*R\"\u0010\u0003\u001a\u00020\u00028\u0004@\u0004X\u0084.\u00a2\u0006\u0012\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\u001a\u00107\u001a\u0002028\u0016X\u0096D\u00a2\u0006\f\n\u0004\b3\u00104\u001a\u0004\b5\u00106R\u001a\u00109\u001a\u0002028\u0016X\u0096D\u00a2\u0006\f\n\u0004\b5\u00104\u001a\u0004\b8\u00106R\u001b\u0010=\u001a\u00020:8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b8\u0010;\u001a\u0004\b3\u0010<R\u0014\u0010>\u001a\u0002028&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b,\u00106\u00a8\u0006A"}, d2 = {"Lcom/tencent/mobileqq/springhb/prize/SpringPrizeView;", "", "Lcom/tencent/mobileqq/springhb/pack/PackInfo;", "packInfo", "", tl.h.F, "", "a", "", "showDelay", DomainData.DOMAIN_NAME, "hideDelay", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "j", "l", "action", "k", "Landroid/view/View;", "prizeView", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "p", "url", "o", "info", "i", "content", "r", "Landroidx/fragment/app/FragmentActivity;", "Landroidx/fragment/app/FragmentActivity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Lcom/tencent/mobileqq/springhb/prize/e;", "b", "Lcom/tencent/mobileqq/springhb/prize/e;", "()Lcom/tencent/mobileqq/springhb/prize/e;", "setGameInfo", "(Lcom/tencent/mobileqq/springhb/prize/e;)V", "gameInfo", "Lcom/tencent/mobileqq/springhb/prize/h;", "c", "Lcom/tencent/mobileqq/springhb/prize/h;", "()Lcom/tencent/mobileqq/springhb/prize/h;", "setGameLauncher", "(Lcom/tencent/mobileqq/springhb/prize/h;)V", "gameLauncher", "d", "Lcom/tencent/mobileqq/springhb/pack/PackInfo;", "getPackInfo", "()Lcom/tencent/mobileqq/springhb/pack/PackInfo;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "(Lcom/tencent/mobileqq/springhb/pack/PackInfo;)V", "", "e", "I", "f", "()I", "toolbarBgColor", "g", "toolbarHideColor", "Landroid/graphics/drawable/Drawable;", "Lkotlin/Lazy;", "()Landroid/graphics/drawable/Drawable;", "loadingLogo", "layoutId", "<init>", "(Landroidx/fragment/app/FragmentActivity;)V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public abstract class SpringPrizeView {
    static IPatchRedirector $redirector_;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final FragmentActivity activity;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private e gameInfo;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private h gameLauncher;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    protected PackInfo packInfo;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final int toolbarBgColor;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final int toolbarHideColor;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy loadingLogo;

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004R\u0014\u0010\t\u001a\u00020\b8\u0004X\u0084T\u00a2\u0006\u0006\n\u0004\b\t\u0010\n\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/springhb/prize/SpringPrizeView$a;", "", "", "type", "Landroidx/fragment/app/FragmentActivity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Lcom/tencent/mobileqq/springhb/prize/SpringPrizeView;", "a", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.springhb.prize.SpringPrizeView$a, reason: from kotlin metadata */
    /* loaded from: classes18.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                return;
            }
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) defaultConstructorMarker);
        }

        @NotNull
        public final SpringPrizeView a(int type, @NotNull FragmentActivity activity) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (SpringPrizeView) iPatchRedirector.redirect((short) 2, (Object) this, type, (Object) activity);
            }
            Intrinsics.checkNotNullParameter(activity, "activity");
            if (type != 1) {
                if (type != 102) {
                    return new d(activity);
                }
                return new d(activity);
            }
            return new MoneyViewV2(activity);
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(61286);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 22)) {
            redirector.redirect((short) 22);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public SpringPrizeView(@NotNull FragmentActivity activity) {
        Lazy lazy;
        Intrinsics.checkNotNullParameter(activity, "activity");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) activity);
            return;
        }
        this.activity = activity;
        this.gameInfo = new e();
        this.gameLauncher = new h();
        lazy = LazyKt__LazyJVMKt.lazy(SpringPrizeView$loadingLogo$2.INSTANCE);
        this.loadingLogo = lazy;
    }

    private final void h(PackInfo packInfo) {
        QLog.i("SpringHb_SpringPrizeView", 1, "[initGameLauncher]");
        try {
            JSONObject optJSONObject = new JSONObject(packInfo.merchantJumpUrl).optJSONObject("android");
            this.gameInfo.f289566a = optJSONObject.optString("gameAppID");
            this.gameInfo.f289567b = optJSONObject.optString("appName");
            this.gameInfo.f289571f = optJSONObject.optString(WadlProxyConsts.CHANNEL);
            this.gameInfo.f289570e = optJSONObject.optString("cloudGameSchema");
            this.gameInfo.f289568c = optJSONObject.optString("packageName");
            this.gameInfo.f289569d = optJSONObject.optString("gameUrl");
            this.gameInfo.f289572g = optJSONObject.optString("sourceId");
            this.gameInfo.f289574i = optJSONObject.optString("version");
            this.gameInfo.f289575j = optJSONObject.optString("privacy_url");
            this.gameInfo.f289573h = optJSONObject.optString(IProfileProtocolConst.KEY_COMPANY);
            this.gameInfo.f289576k = optJSONObject.optString("tickets");
            this.gameInfo.f289577l = optJSONObject.optString(QCircleDaTongConstant.ElementParamValue.PERMISSION);
            this.gameInfo.a();
            this.gameLauncher.q(this.gameInfo);
        } catch (Throwable th5) {
            QLog.e("SpringHb_SpringPrizeView", 1, "[initGameLauncher], th:", th5);
        }
    }

    @NotNull
    public String a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (String) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        String g16 = this.gameLauncher.g();
        Intrinsics.checkNotNullExpressionValue(g16, "gameLauncher.ext3");
        return g16;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public final e b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (e) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.gameInfo;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public final h c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (h) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.gameLauncher;
    }

    public abstract int d();

    @NotNull
    public final Drawable e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (Drawable) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        return (Drawable) this.loadingLogo.getValue();
    }

    public int f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Integer) iPatchRedirector.redirect((short) 8, (Object) this)).intValue();
        }
        return this.toolbarBgColor;
    }

    public int g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Integer) iPatchRedirector.redirect((short) 9, (Object) this)).intValue();
        }
        return this.toolbarHideColor;
    }

    protected final void i(@NotNull String info) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, (Object) info);
            return;
        }
        Intrinsics.checkNotNullParameter(info, "info");
        QLog.d("SpringHb_SpringPrizeView", 1, "log: " + info + " ");
    }

    public void j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this);
            return;
        }
        h hVar = this.gameLauncher;
        if (hVar != null) {
            hVar.m();
        }
    }

    public void k(@NotNull String action) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, (Object) action);
        } else {
            Intrinsics.checkNotNullParameter(action, "action");
        }
    }

    public void l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this);
            return;
        }
        h hVar = this.gameLauncher;
        if (hVar != null) {
            hVar.n();
        }
    }

    public void m(long hideDelay) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, hideDelay);
            return;
        }
        i("onStartHide hideDelay, " + hideDelay);
    }

    public void n(long showDelay) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, showDelay);
            return;
        }
        i("onStartShow showDelay, " + showDelay);
    }

    public final void o(@Nullable String url) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, (Object) url);
            return;
        }
        if (url != null && url.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!z16) {
            Intent intent = new Intent();
            intent.putExtra("url", url);
            RouteUtils.startActivity(this.activity, intent, RouterConstants.UI_ROUTE_BROWSER);
            return;
        }
        r("URL\u4e3a\u7a7a");
    }

    public void p(@NotNull PackInfo packInfo, @NotNull View prizeView, @NotNull View rootView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, this, packInfo, prizeView, rootView);
            return;
        }
        Intrinsics.checkNotNullParameter(packInfo, "packInfo");
        Intrinsics.checkNotNullParameter(prizeView, "prizeView");
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        q(packInfo);
        h(packInfo);
    }

    protected final void q(@NotNull PackInfo packInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) packInfo);
        } else {
            Intrinsics.checkNotNullParameter(packInfo, "<set-?>");
            this.packInfo = packInfo;
        }
    }

    public final void r(@Nullable String content) {
        Toast toast;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this, (Object) content);
            return;
        }
        if (content != null) {
            toast = QQToast.makeText(this.activity, content, 0).show();
        } else {
            toast = null;
        }
        if (toast == null) {
            i("toast content is null");
        }
    }
}
