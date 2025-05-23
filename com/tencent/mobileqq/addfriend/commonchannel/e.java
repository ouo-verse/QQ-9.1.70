package com.tencent.mobileqq.addfriend.commonchannel;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.addfriend.api.IAddFriendApi;
import com.tencent.mobileqq.addfriend.config.AddFriendOpenSdkConfigParser;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mobileqq.zplan.scheme.ISchemeApi;
import com.tencent.open.model.AppInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.QQToastUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Foreground;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;
import tl.h;
import zp3.d;

/* compiled from: P */
@Metadata(d1 = {"\u0000G\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\b\b*\u0001\u001c\u0018\u0000 \"2\u00020\u0001:\u0001\u0015B\u0007\u00a2\u0006\u0004\b \u0010!J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J*\u0010\f\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0002J\u0010\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rH\u0002J\"\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0002J \u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0018\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016R\u0016\u0010\u0018\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0017R\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001f\u001a\u00020\u001c8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001e\u00a8\u0006#"}, d2 = {"Lcom/tencent/mobileqq/addfriend/commonchannel/e;", "Lzp3/c;", "", "errorCode", "", "l", "Lzp3/d;", "helper", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "", "errorMsg", "f", "Landroid/content/Context;", "context", h.F, WadlProxyConsts.EXTRA_DATA, "Lcom/tencent/open/model/AppInfo;", "appInfo", "k", "g", "a", "", "Z", "mGetAppConnectCheckResultTimeout", "b", "Lzp3/d;", "mSdkHelper", "com/tencent/mobileqq/addfriend/commonchannel/e$b", "c", "Lcom/tencent/mobileqq/addfriend/commonchannel/e$b;", "mAddFriendCallback", "<init>", "()V", "d", "qqaddfriend-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class e implements zp3.c {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private boolean mGetAppConnectCheckResultTimeout;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private zp3.d mSdkHelper;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final b mAddFriendCallback;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0014\u0010\b\u001a\u00020\u00078\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u00078\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\n\u0010\tR\u0014\u0010\u000b\u001a\u00020\u00078\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\tR\u0014\u0010\r\u001a\u00020\f8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0004R\u0014\u0010\u0010\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0004\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/addfriend/commonchannel/e$a;", "", "", "ATTR_GAME_FRIEND_OPENID", "Ljava/lang/String;", "ATTR_GAME_LABEL", "ATTR_GAME_MESSAGE", "", "E_ALL_USER_UNAUTHORIZED", "I", "E_PART_USER_UNAUTHORIZED", "E_USER_NOT_SAME", "", "checkPermissionTimeout", "J", "isFromOpenSDK", "tag", "<init>", "()V", "qqaddfriend-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.addfriend.commonchannel.e$a, reason: from kotlin metadata */
    /* loaded from: classes10.dex */
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

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/addfriend/commonchannel/e$b", "Lcom/tencent/mobileqq/addfriend/commonchannel/a;", "", "errorCode", "", "errorMsg", "", "onResult", "qqaddfriend-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes10.dex */
    public static final class b implements a {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) e.this);
            }
        }

        @Override // com.tencent.mobileqq.addfriend.commonchannel.a
        public void onResult(int errorCode, @NotNull String errorMsg) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, errorCode, (Object) errorMsg);
                return;
            }
            Intrinsics.checkNotNullParameter(errorMsg, "errorMsg");
            QLog.i("AddFriendOpenSdkCommonChannelActionHandler", 1, "onResult,errorCode=" + errorCode + ",errorMsg=" + errorMsg);
            zp3.d dVar = e.this.mSdkHelper;
            if (dVar != null) {
                e.this.g(dVar, errorCode, errorMsg);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(20876);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        b bVar = new b();
        this.mAddFriendCallback = bVar;
        com.tencent.mobileqq.addfriend.commonchannel.b.f187312a.b(bVar);
    }

    private final void f(zp3.d helper, Activity activity, int errorCode, String errorMsg) {
        Context context = helper.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "helper.context");
        h(context);
        QLog.i("AddFriendOpenSdkCommonChannelActionHandler", 1, "doCallback,errCode=" + errorCode + ",errorMsg=" + errorMsg);
        if (errorMsg == null) {
            errorMsg = "";
        }
        g(helper, errorCode, errorMsg);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void g(zp3.d helper, int errorCode, String errorMsg) {
        int i3;
        if (errorCode == 4) {
            i3 = 1;
        } else {
            i3 = 0;
        }
        helper.c(Foreground.getTopActivity(), i3, errorMsg);
        this.mSdkHelper = null;
    }

    private final void h(Context context) {
        if (context instanceof JumpActivity) {
            ((Activity) context).finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(e this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.mGetAppConnectCheckResultTimeout = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j(e this$0, zp3.d helper, String extraData, int i3, byte[] bArr, Bundle bundle, AppInfo appInfo) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(helper, "$helper");
        Intrinsics.checkNotNullParameter(extraData, "$extraData");
        if (this$0.mGetAppConnectCheckResultTimeout && helper.getContext() != null) {
            QQToastUtil.showQQToastInUiThread(1, "\u8bf7\u6c42\u8d85\u65f6\uff0c\u8bf7\u7a0d\u540e\u518d\u8bd5\u3002");
            Activity topActivity = Foreground.getTopActivity();
            Intrinsics.checkNotNullExpressionValue(topActivity, "getTopActivity()");
            this$0.f(helper, topActivity, i3, "errorCode = " + i3);
            return;
        }
        QLog.i("AddFriendOpenSdkCommonChannelActionHandler", 1, "opensdk addfriend errcode=" + i3);
        if (i3 != 0 && i3 != 25501) {
            this$0.l(i3);
            Activity topActivity2 = Foreground.getTopActivity();
            Intrinsics.checkNotNullExpressionValue(topActivity2, "getTopActivity()");
            this$0.f(helper, topActivity2, i3, "errorCode = " + i3);
            return;
        }
        this$0.k(extraData, helper, appInfo);
        Context context = helper.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "helper.context");
        this$0.h(context);
    }

    private final void k(String extraData, zp3.d helper, AppInfo appInfo) {
        String str;
        String str2;
        String str3;
        try {
            String openId = helper.getOpenId();
            String appId = helper.getAppId();
            Intrinsics.checkNotNullExpressionValue(appId, "helper.appId");
            long parseLong = Long.parseLong(appId);
            AddFriendOpenSdkConfigParser.Companion companion = AddFriendOpenSdkConfigParser.INSTANCE;
            String appId2 = helper.getAppId();
            Intrinsics.checkNotNullExpressionValue(appId2, "helper.appId");
            com.tencent.mobileqq.addfriend.config.b a16 = companion.a(appId2);
            if (a16 == null) {
                QLog.e("AddFriendOpenSdkCommonChannelActionHandler", 1, "action fail, qmcc config not found!");
                Activity topActivity = Foreground.getTopActivity();
                Intrinsics.checkNotNullExpressionValue(topActivity, "getTopActivity()");
                f(helper, topActivity, 2, "qmcc config not found");
                return;
            }
            if (parseLong <= 0) {
                QLog.e("AddFriendOpenSdkCommonChannelActionHandler", 1, "action fail, appid invalid!");
                Activity topActivity2 = Foreground.getTopActivity();
                Intrinsics.checkNotNullExpressionValue(topActivity2, "getTopActivity()");
                f(helper, topActivity2, 2, "appid invalid");
                return;
            }
            JSONObject jSONObject = new JSONObject(extraData);
            Object obj = jSONObject.getJSONArray("open_id_list").get(0);
            String str4 = null;
            if (obj instanceof String) {
                str = (String) obj;
            } else {
                str = null;
            }
            if (str == null) {
                str2 = "";
            } else {
                str2 = str;
            }
            if (TextUtils.isEmpty(str2)) {
                Activity topActivity3 = Foreground.getTopActivity();
                Intrinsics.checkNotNullExpressionValue(topActivity3, "getTopActivity()");
                f(helper, topActivity3, 2, "friend openid invalid");
                return;
            }
            String string = jSONObject.getString("friend_label");
            String string2 = jSONObject.getString("add_msg");
            if (appInfo != null) {
                str4 = appInfo.e();
            }
            if (str4 == null) {
                str3 = "";
            } else {
                str3 = str4;
            }
            if (QLog.isDebugVersion()) {
                QLog.d("AddFriendOpenSdkCommonChannelActionHandler", 1, "handleAction,selfOpenId=" + openId + ",appId=" + parseLong + ",extras=" + jSONObject);
            }
            ((IAddFriendApi) QRoute.api(IAddFriendApi.class)).setsOpenId(openId);
            Activity a17 = com.tencent.relation.common.utils.b.a();
            if (a17 == null && (helper.getContext() instanceof Activity)) {
                Context context = helper.getContext();
                Intrinsics.checkNotNull(context, "null cannot be cast to non-null type android.app.Activity");
                a17 = (Activity) context;
            }
            if (a17 == null) {
                QLog.e("AddFriendOpenSdkCommonChannelActionHandler", 1, "action fail, activity not found!");
                Activity topActivity4 = Foreground.getTopActivity();
                Intrinsics.checkNotNullExpressionValue(topActivity4, "getTopActivity()");
                f(helper, topActivity4, 2, "activity not found");
                return;
            }
            Intent startAddFriend = ((IAddFriendApi) QRoute.api(IAddFriendApi.class)).startAddFriend(a17, 3, str2, "" + parseLong, a16.a(), a16.b(), string, string2, null, "", str3);
            Intrinsics.checkNotNullExpressionValue(startAddFriend, "api(IAddFriendApi::class\u2026gameAppName\n            )");
            startAddFriend.putExtra(ISchemeApi.KEY_IOS_SRC_TYPE, "app");
            startAddFriend.putExtra("pkg_name", helper.getPackageName());
            startAddFriend.putExtra("IS_FROM_OPEN_SDK", true);
            ((IAddFriendApi) QRoute.api(IAddFriendApi.class)).launchAddFriend(a17, startAddFriend);
            QLog.e("AddFriendOpenSdkCommonChannelActionHandler", 1, "action success, add friend invoke!");
        } catch (NumberFormatException e16) {
            QLog.e("AddFriendOpenSdkCommonChannelActionHandler", 1, e16, new Object[0]);
            Activity topActivity5 = Foreground.getTopActivity();
            Intrinsics.checkNotNullExpressionValue(topActivity5, "getTopActivity()");
            f(helper, topActivity5, 2, e16.getMessage());
        } catch (JSONException e17) {
            QLog.e("AddFriendOpenSdkCommonChannelActionHandler", 1, e17, new Object[0]);
            Activity topActivity6 = Foreground.getTopActivity();
            Intrinsics.checkNotNullExpressionValue(topActivity6, "getTopActivity()");
            f(helper, topActivity6, 2, e17.getMessage());
        }
    }

    private final void l(int errorCode) {
        if (errorCode == 25801 || errorCode == 25802) {
            QQToastUtil.showQQToastInUiThread(1, "\u5bf9\u65b9\u672a\u5f00\u901a\u52a0\u597d\u53cb\u6743\u9650\uff0c\u4e0d\u53ef\u53d1\u8d77\u597d\u53cb\u6dfb\u52a0\u3002");
        }
    }

    @Override // zp3.c
    public void a(@NotNull final String extraData, @NotNull final zp3.d helper) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) extraData, (Object) helper);
            return;
        }
        Intrinsics.checkNotNullParameter(extraData, "extraData");
        Intrinsics.checkNotNullParameter(helper, "helper");
        if (!AddFriendOpenSdkConfigParser.INSTANCE.b()) {
            QLog.e("AddFriendOpenSdkCommonChannelActionHandler", 1, "action fail, config forbid!");
            Activity topActivity = Foreground.getTopActivity();
            Intrinsics.checkNotNullExpressionValue(topActivity, "getTopActivity()");
            f(helper, topActivity, 2, "config forbid");
            return;
        }
        this.mSdkHelper = helper;
        ThreadManagerV2.executeDelay(new Runnable() { // from class: com.tencent.mobileqq.addfriend.commonchannel.c
            @Override // java.lang.Runnable
            public final void run() {
                e.i(e.this);
            }
        }, 16, null, true, 20000L);
        helper.a(new d.b() { // from class: com.tencent.mobileqq.addfriend.commonchannel.d
            @Override // zp3.d.b
            public final void a(int i3, byte[] bArr, Bundle bundle, AppInfo appInfo) {
                e.j(e.this, helper, extraData, i3, bArr, bundle, appInfo);
            }
        });
    }
}
