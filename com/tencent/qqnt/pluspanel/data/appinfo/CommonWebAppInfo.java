package com.tencent.qqnt.pluspanel.data.appinfo;

import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.qqnt.pluspanel.utils.a;
import com.tencent.util.TokenResUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\b\u0018\u0000 \f2\u00020\u0001:\u0001\rB\u000f\u0012\u0006\u0010\t\u001a\u00020\u0006\u00a2\u0006\u0004\b\n\u0010\u000bJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\n\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\b\u001a\u00020\u0006H\u0016\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/qqnt/pluspanel/data/appinfo/CommonWebAppInfo;", "Lcom/tencent/qqnt/pluspanel/data/appinfo/PlusPanelAppInfo;", "", h.F, "", "getTitle", "", "defaultDrawableID", "getAppID", "uinType", "<init>", "(I)V", "Companion", "a", "plus_panel_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes22.dex */
public final class CommonWebAppInfo extends PlusPanelAppInfo {
    static IPatchRedirector $redirector_;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/qqnt/pluspanel/data/appinfo/CommonWebAppInfo$a;", "", "", "COLLECT_MONEY_ACTION_URL", "Ljava/lang/String;", "<init>", "()V", "plus_panel_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.pluspanel.data.appinfo.CommonWebAppInfo$a, reason: from kotlin metadata */
    /* loaded from: classes22.dex */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(39315);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public CommonWebAppInfo(int i3) {
        super(i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, i3);
        }
    }

    private final boolean h() {
        if (!QQTheme.isDefaultTheme() && !QQTheme.isNowThemeDefaultNight()) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.qqnt.pluspanel.data.appinfo.PlusPanelAppInfo
    public int defaultDrawableID() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        int appid = getAppid();
        a.Companion companion = com.tencent.qqnt.pluspanel.utils.a.INSTANCE;
        if (appid == companion.N()) {
            setAction("https://mqq.tenpay.com/mqq/groupreceipts/index.shtml?uin=$GCODE$&type=4&_wv=1027&_wvx=4");
        }
        if (!TokenResUtils.aioPlusIconNewStyle()) {
            return 0;
        }
        if (getAppid() == companion.g0()) {
            return R.drawable.chat_tool_mini_app;
        }
        if (getAppid() == companion.N()) {
            return R.drawable.mqb;
        }
        if (getAppid() == companion.t0()) {
            return R.drawable.chat_tool_send_tencentdoc;
        }
        if (getAppid() == companion.K()) {
            return R.drawable.mq_;
        }
        if (getAppid() != companion.W() && getAppid() != companion.H()) {
            if (getAppid() == companion.b() && h()) {
                return R.drawable.f160456mq2;
            }
            if (getAppid() == companion.T() && h()) {
                return R.drawable.mqf;
            }
            if (getAppid() != companion.U()) {
                return 0;
            }
            if (h()) {
                return R.drawable.mqu;
            }
            return R.drawable.mqt;
        }
        return R.drawable.chat_tool_sing_together;
    }

    @Override // com.tencent.qqnt.pluspanel.data.appinfo.PlusPanelAppInfo
    public int getAppID() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        return getAppid();
    }

    @Override // com.tencent.qqnt.pluspanel.data.appinfo.PlusPanelAppInfo
    @Nullable
    public String getTitle() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return getName();
    }
}
