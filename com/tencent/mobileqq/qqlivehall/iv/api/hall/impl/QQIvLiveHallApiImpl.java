package com.tencent.mobileqq.qqlivehall.iv.api.hall.impl;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.hippy.qq.api.OpenHippyInfo;
import com.tencent.hippy.qq.update.HippyQQConstants;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqlive.config.QQLiveEntrance;
import com.tencent.mobileqq.qqlive.config.c;
import com.tencent.mobileqq.qqlivehall.iv.QQLiveHallHippyFragment;
import com.tencent.mobileqq.qqlivehall.iv.api.hall.IQQIvLiveHallApi;
import com.tencent.mobileqq.qqlivehall.iv.b;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.common.api.IAegisLogApi;
import com.tencent.timi.game.api.cookie.QQLiveCookieConstants;
import com.tencent.timi.game.api.ticket.IQQLiveTicketApi;
import com.tencent.timi.game.api.ticket.PSKey;
import com.tencent.timi.game.api.ticket.PSKeyCallback;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0002\u0017\u0018B\u0007\u00a2\u0006\u0004\b\u0015\u0010\u0016J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\n\u001a\u00020\tH\u0002J\u0018\u0010\b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bH\u0002J\u001a\u0010\r\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u001a\u0010\u0010\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u000f\u001a\u00020\u000eH\u0016J\u0012\u0010\u0011\u001a\u00020\u000e2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016R\u0014\u0010\u0013\u001a\u00020\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/mobileqq/qqlivehall/iv/api/hall/impl/QQIvLiveHallApiImpl;", "Lcom/tencent/mobileqq/qqlivehall/iv/api/hall/IQQIvLiveHallApi;", "", "updatePSKeys", "Landroid/content/Context;", "context", "Lcom/tencent/mobileqq/qqlivehall/iv/api/hall/a;", "params", "openLiveHallInner", "", "getProcessNameFromConfig", "Lcom/tencent/hippy/qq/api/OpenHippyInfo;", "openHippyInfo", "openQQIvLiveHall", "", "testEnv", "setTestEnv", "isTestEnv", "Lcom/tencent/qqlive/common/api/IAegisLogApi;", "aegisLogger", "Lcom/tencent/qqlive/common/api/IAegisLogApi;", "<init>", "()V", "a", "b", "qq-iv-live-hall-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class QQIvLiveHallApiImpl implements IQQIvLiveHallApi {
    static IPatchRedirector $redirector_;

    @NotNull
    private final IAegisLogApi aegisLogger;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0007\b\u00c2\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\bJ\u0006\u0010\u0003\u001a\u00020\u0002R\u001c\u0010\t\u001a\u00020\u00048\u0002@\u0002X\u0083\u000e\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0006\u0012\u0004\b\u0007\u0010\b\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/qqlivehall/iv/api/hall/impl/QQIvLiveHallApiImpl$a;", "", "", "a", "", "b", "J", "getLastClickTime$annotations", "()V", "lastClickTime", "<init>", "qq-iv-live-hall-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes17.dex */
    private static final class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        @NotNull
        public static final a f274097a;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        private static long lastClickTime;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(20995);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 3)) {
                redirector.redirect((short) 3);
            } else {
                f274097a = new a();
            }
        }

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        public final boolean a() {
            boolean z16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
            }
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - lastClickTime <= 500) {
                z16 = true;
            } else {
                z16 = false;
            }
            lastClickTime = currentTimeMillis;
            return z16;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\r\u001a\u00020\u0007\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u0016\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016J\u0012\u0010\t\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J\u0012\u0010\n\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016R\u0014\u0010\r\u001a\u00020\u00078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\f\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/qqlivehall/iv/api/hall/impl/QQIvLiveHallApiImpl$b;", "Lcom/tencent/timi/game/api/ticket/PSKeyCallback;", "", "Lcom/tencent/timi/game/api/ticket/PSKey;", "pSKeys", "", "onSuccess", "", "msg", "onFailed", "onTimeout", "a", "Ljava/lang/String;", "domain", "<init>", "(Ljava/lang/String;)V", "qq-iv-live-hall-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes17.dex */
    public static final class b implements PSKeyCallback {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final String domain;

        public b(@NotNull String domain) {
            Intrinsics.checkNotNullParameter(domain, "domain");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) domain);
            } else {
                this.domain = domain;
            }
        }

        @Override // com.tencent.timi.game.api.ticket.PSKeyCallback
        public void onFailed(@Nullable String msg2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) msg2);
                return;
            }
            QLog.d("QQIvLiveHallApiImpl", 1, "update " + this.domain + " PSKey failed:" + msg2);
        }

        @Override // com.tencent.timi.game.api.ticket.PSKeyCallback
        public void onSuccess(@NotNull List<PSKey> pSKeys) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) pSKeys);
                return;
            }
            Intrinsics.checkNotNullParameter(pSKeys, "pSKeys");
            QLog.d("QQIvLiveHallApiImpl", 1, "update " + this.domain + " PSKey success");
        }

        @Override // com.tencent.timi.game.api.ticket.PSKeyCallback
        public void onTimeout(@Nullable String msg2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) msg2);
                return;
            }
            QLog.d("QQIvLiveHallApiImpl", 1, "update " + this.domain + " PSKey timeout:" + msg2);
        }
    }

    public QQIvLiveHallApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        QRouteApi api = QRoute.api(IAegisLogApi.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IAegisLogApi::class.java)");
        this.aegisLogger = (IAegisLogApi) api;
    }

    private final String getProcessNameFromConfig() {
        return "tool";
    }

    private final void openLiveHallInner(Context context, com.tencent.mobileqq.qqlivehall.iv.api.hall.a params) {
        OpenHippyInfo openHippyInfo = new OpenHippyInfo();
        openHippyInfo.bundleName = HippyQQConstants.ModuleName.QQ_LIVE_HALL;
        openHippyInfo.framework = "react";
        openHippyInfo.processName = getProcessNameFromConfig();
        openHippyInfo.from = String.valueOf(params.a());
        openHippyInfo.domain = QQLiveCookieConstants.QQ_LIVE_DOMAIN;
        openHippyInfo.fragmentClass = QQLiveHallHippyFragment.class;
        openHippyInfo.url = params.c();
        openHippyInfo.updateJsBundleType = params.b();
        Bundle bundle = new Bundle();
        bundle.putInt("userAge", params.d());
        openHippyInfo.businessBundle = bundle;
        openLiveHallInner(context, openHippyInfo);
    }

    private final void updatePSKeys() {
        ((IQQLiveTicketApi) QRoute.api(IQQLiveTicketApi.class)).getPsKeysAsync(new String[]{QQLiveCookieConstants.QQ_LIVE_DOMAIN}, new b(QQLiveCookieConstants.QQ_LIVE_DOMAIN));
        ((IQQLiveTicketApi) QRoute.api(IQQLiveTicketApi.class)).getPsKeysAsync(new String[]{QQLiveCookieConstants.NOW_DOMAIN}, new b(QQLiveCookieConstants.NOW_DOMAIN));
    }

    @Override // com.tencent.mobileqq.qqlivehall.iv.api.hall.IQQIvLiveHallApi
    public boolean isTestEnv(@Nullable Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, (Object) context)).booleanValue();
        }
        return false;
    }

    @Override // com.tencent.mobileqq.qqlivehall.iv.api.hall.IQQIvLiveHallApi
    public void openQQIvLiveHall(@Nullable Context context, @NotNull com.tencent.mobileqq.qqlivehall.iv.api.hall.a params) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) params);
            return;
        }
        Intrinsics.checkNotNullParameter(params, "params");
        if (a.f274097a.a()) {
            this.aegisLogger.i("QQIvLiveHallApiImpl", 1, "double clicked");
            return;
        }
        this.aegisLogger.i("QQIvLiveHallApiImpl", 1, "openQQIvLiveHall: params=" + params);
        com.tencent.mobileqq.qqlivehall.iv.b.f274104a.c(new b.a(String.valueOf(params.a())));
        if (context == null) {
            this.aegisLogger.e("QQIvLiveHallApiImpl", 1, "openQQIvLiveHall: context is null");
        } else {
            updatePSKeys();
            openLiveHallInner(context, params);
        }
    }

    @Override // com.tencent.mobileqq.qqlivehall.iv.api.hall.IQQIvLiveHallApi
    public void setTestEnv(@Nullable Context context, boolean testEnv) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, context, Boolean.valueOf(testEnv));
        }
    }

    private final void openLiveHallInner(Context context, OpenHippyInfo openHippyInfo) {
        Bundle bundle = openHippyInfo.toBundle();
        bundle.putLong(HippyQQConstants.STEP_NAME_OPEN_PAGE_START, System.currentTimeMillis());
        Intent intent = new Intent();
        intent.putExtra("params", bundle);
        if (openHippyInfo.isTransparent) {
            intent.putExtra("public_fragment_window_feature", 1);
        }
        Class<? extends QPublicFragmentActivity> startActivityClass = openHippyInfo.getStartActivityClass();
        Class<? extends QPublicBaseFragment> startFragmentClass = openHippyInfo.getStartFragmentClass();
        if (startActivityClass != null && startFragmentClass != null) {
            intent.setFlags(131072);
            c.f271178a.d(context, QQLiveEntrance.LIVE_HALL);
            QPublicFragmentActivity.b.b(context, intent, startActivityClass, startFragmentClass);
            if (openHippyInfo.isAnimated && (context instanceof Activity)) {
                ((Activity) context).overridePendingTransition(R.anim.f154476ii, R.anim.f154479lu);
                return;
            }
            return;
        }
        this.aegisLogger.e("QQIvLiveHallApiImpl", 1, "openHippyPage cannot find activity class or fragment class");
    }
}
