package com.tencent.mobileqq.qqgamepub.manager;

import android.app.Activity;
import android.text.TextUtils;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqgamepub.api.IQQGamePreDownloadService;
import com.tencent.mobileqq.qqgamepub.data.QQGameMsgInfo;
import com.tencent.mobileqq.qqgamepub.utils.a;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.comm.api.IGameCenterUnitedConfigApi;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\t\b\u0002\u00a2\u0006\u0004\b\r\u0010\u000eJ\u0006\u0010\u0003\u001a\u00020\u0002J\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006J\u0010\u0010\f\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\n\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/qqgamepub/manager/QQGameDirectJumpHandler;", "", "", "c", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Lcom/tencent/mobileqq/qqgamepub/data/QQGameMsgInfo;", "msg", "", "b", "Lorg/json/JSONObject;", "directJumpObj", "d", "<init>", "()V", "a", "qqgamepubaccount-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class QQGameDirectJumpHandler {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private static final Lazy<QQGameDirectJumpHandler> f264605b;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0010\u0010\u0011R\u001b\u0010\u0007\u001a\u00020\u00028FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\nR\u0014\u0010\f\u001a\u00020\b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\f\u0010\nR\u0018\u0010\u000e\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/qqgamepub/manager/QQGameDirectJumpHandler$a;", "", "Lcom/tencent/mobileqq/qqgamepub/manager/QQGameDirectJumpHandler;", "instance$delegate", "Lkotlin/Lazy;", "a", "()Lcom/tencent/mobileqq/qqgamepub/manager/QQGameDirectJumpHandler;", WadlProxyConsts.LOAD_CONFIG_FROM_INSTANCE, "", "KEY_BID", "Ljava/lang/String;", "KEY_JUMP_URL", "TAG", "Lcom/tencent/image/ApngDrawable$OnPlayRepeatListener;", "mApngListener", "Lcom/tencent/image/ApngDrawable$OnPlayRepeatListener;", "<init>", "()V", "qqgamepubaccount-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qqgamepub.manager.QQGameDirectJumpHandler$a, reason: from kotlin metadata */
    /* loaded from: classes16.dex */
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
        public final QQGameDirectJumpHandler a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (QQGameDirectJumpHandler) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return (QQGameDirectJumpHandler) QQGameDirectJumpHandler.f264605b.getValue();
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
        Lazy<QQGameDirectJumpHandler> lazy;
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(17918);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
            return;
        }
        INSTANCE = new Companion(null);
        lazy = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, (Function0) QQGameDirectJumpHandler$Companion$instance$2.INSTANCE);
        f264605b = lazy;
    }

    public /* synthetic */ QQGameDirectJumpHandler(DefaultConstructorMarker defaultConstructorMarker) {
        this();
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) {
            return;
        }
        iPatchRedirector.redirect((short) 5, (Object) this, (Object) defaultConstructorMarker);
    }

    public final void b(@NotNull Activity activity, @Nullable QQGameMsgInfo msg2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) activity, (Object) msg2);
            return;
        }
        Intrinsics.checkNotNullParameter(activity, "activity");
        if (c() && !activity.isFinishing() && msg2 != null && !TextUtils.isEmpty(msg2.directJumpConfigs)) {
            try {
                String optString = new JSONObject(msg2.directJumpConfigs).optString("url");
                QLog.i("QQGameDirectJumpHandler", 1, "[handleDirectJump] jumpUrl:" + optString);
                if (!TextUtils.isEmpty(optString)) {
                    a.i(activity, optString);
                }
            } catch (Exception e16) {
                QLog.e("QQGameDirectJumpHandler", 1, e16, new Object[0]);
            }
        }
    }

    public final boolean c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        boolean isSwitchOn = ((IGameCenterUnitedConfigApi) QRoute.api(IGameCenterUnitedConfigApi.class)).isSwitchOn(IGameCenterUnitedConfigApi.GAMEPLAT_DIRECTJUMP_SWITCH, true);
        if (QLog.isColorLevel()) {
            QLog.i("QQGameDirectJumpHandler", 2, "[isSwitchOn] " + isSwitchOn);
        }
        return isSwitchOn;
    }

    public final void d(@Nullable JSONObject directJumpObj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) directJumpObj);
            return;
        }
        if (!c()) {
            return;
        }
        if (directJumpObj == null) {
            QLog.i("QQGameDirectJumpHandler", 2, "[preDownloadDirectJumpRes] directJumpConfigs is null");
            return;
        }
        String optString = directJumpObj.optString("bid");
        if (!TextUtils.isEmpty(optString)) {
            try {
                ((IQQGamePreDownloadService) QRoute.api(IQQGamePreDownloadService.class)).updateOfflineByBids(new JSONArray().mo162put(optString));
            } catch (Exception e16) {
                QLog.e("QQGameDirectJumpHandler", 1, e16, new Object[0]);
            }
        }
    }

    QQGameDirectJumpHandler() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this);
    }
}
