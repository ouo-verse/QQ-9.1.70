package com.tencent.qqnt.chathistory.bridge.impl;

import android.content.Context;
import android.graphics.drawable.Drawable;
import com.tencent.cachedrawable.dynamicdrawable.api.a;
import com.tencent.cachedrawable.dynamicdrawable.cachedrawable.k;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.tianshu.api.IMobileReportManager;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.utils.ax;
import com.tencent.mobileqq.utils.bi;
import com.tencent.mobileqq.vas.VasDynamicDrawableCache;
import com.tencent.mobileqq.vas.VipMMKV;
import com.tencent.mobileqq.vas.api.IVasHybridRoute;
import com.tencent.mobileqq.vas.perception.api.VipPerceptionRequestResult;
import com.tencent.mobileqq.vas.search.SearchConstants;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.chathistory.bridge.IC2CChatHistoryVasApi;
import gu4.i;
import gu4.n;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u00172\u00020\u0001:\u0001\u0018B\u0007\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0002H\u0016J\u0018\u0010\r\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u0002H\u0016J+\u0010\u0014\u001a\u00020\u00062!\u0010\u0013\u001a\u001d\u0012\u0013\u0012\u00110\u000f\u00a2\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\u00060\u000eH\u0016\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/qqnt/chathistory/bridge/impl/C2CChatHistoryVasApiImpl;", "Lcom/tencent/qqnt/chathistory/bridge/IC2CChatHistoryVasApi;", "", "uin", "", "checkPermission", "", "updateCheckPermissionSp", "url", "Landroid/graphics/drawable/Drawable;", "getTipsDrawable", "Landroid/content/Context;", "context", "jumpToH5", "Lkotlin/Function1;", "Lcom/tencent/qqnt/chathistory/bridge/a;", "Lkotlin/ParameterName;", "name", "data", "successCallback", "requestTipsData", "<init>", "()V", "Companion", "a", "vas-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class C2CChatHistoryVasApiImpl implements IC2CChatHistoryVasApi {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    @NotNull
    private static final String KEY_SHOW_COUNT = "chat_history_tip_count";

    @NotNull
    private static final String KEY_SHOW_TIME = "chat_history_tip_time";

    @NotNull
    private static final String TAG = "VasChatHistoryApiImpl";

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0007\u0010\bR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0004\u00a8\u0006\t"}, d2 = {"Lcom/tencent/qqnt/chathistory/bridge/impl/C2CChatHistoryVasApiImpl$a;", "", "", "KEY_SHOW_COUNT", "Ljava/lang/String;", "KEY_SHOW_TIME", "TAG", "<init>", "()V", "vas-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.chathistory.bridge.impl.C2CChatHistoryVasApiImpl$a, reason: from kotlin metadata */
    /* loaded from: classes23.dex */
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
    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\"\u0010\f\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\r"}, d2 = {"com/tencent/qqnt/chathistory/bridge/impl/C2CChatHistoryVasApiImpl$b", "Lcom/tencent/mobileqq/vas/perception/api/VipPerceptionRequestResult;", "Lgu4/i;", "result", "", "data", "", "b", "", "code", "", "msg", "a", "vas-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes23.dex */
    public static final class b implements VipPerceptionRequestResult<i> {
        static IPatchRedirector $redirector_;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f353312b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ Function1<com.tencent.qqnt.chathistory.bridge.a, Unit> f353313c;

        /* JADX WARN: Multi-variable type inference failed */
        b(String str, Function1<? super com.tencent.qqnt.chathistory.bridge.a, Unit> function1) {
            this.f353312b = str;
            this.f353313c = function1;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, C2CChatHistoryVasApiImpl.this, str, function1);
            }
        }

        @Override // com.tencent.mobileqq.vas.perception.api.VipPerceptionRequestResult
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void failure(int code, @NotNull String msg2, @Nullable i result) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, Integer.valueOf(code), msg2, result);
                return;
            }
            Intrinsics.checkNotNullParameter(msg2, "msg");
            QLog.e(C2CChatHistoryVasApiImpl.TAG, 1, "rsp fail, code: " + code + ", msg: " + msg2);
        }

        @Override // com.tencent.mobileqq.vas.perception.api.VipPerceptionRequestResult
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void success(@NotNull i result, @NotNull Object data) {
            n nVar;
            String imageUrl;
            boolean z16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) result, data);
                return;
            }
            Intrinsics.checkNotNullParameter(result, "result");
            Intrinsics.checkNotNullParameter(data, "data");
            Map<Integer, n> map = result.f403397c;
            if (map != null && (nVar = map.get(3)) != null) {
                if (QQTheme.isNowThemeIsNight()) {
                    imageUrl = nVar.f403406b;
                } else {
                    imageUrl = nVar.f403405a;
                }
                Intrinsics.checkNotNullExpressionValue(imageUrl, "imageUrl");
                boolean z17 = false;
                if (imageUrl.length() == 0) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (!z16) {
                    String str = nVar.f403407c;
                    Intrinsics.checkNotNullExpressionValue(str, "showInfo.barJumpUrl");
                    if (str.length() == 0) {
                        z17 = true;
                    }
                    if (!z17) {
                        C2CChatHistoryVasApiImpl c2CChatHistoryVasApiImpl = C2CChatHistoryVasApiImpl.this;
                        String uin = this.f353312b;
                        Intrinsics.checkNotNullExpressionValue(uin, "uin");
                        c2CChatHistoryVasApiImpl.updateCheckPermissionSp(uin);
                        Function1<com.tencent.qqnt.chathistory.bridge.a, Unit> function1 = this.f353313c;
                        String str2 = nVar.f403407c;
                        Intrinsics.checkNotNullExpressionValue(str2, "showInfo.barJumpUrl");
                        function1.invoke(new com.tencent.qqnt.chathistory.bridge.a(imageUrl, str2));
                        ((IMobileReportManager) QRoute.api(IMobileReportManager.class)).reportAction(SearchConstants.PLATFORM, "chat_record", "chat_record_bar", "", "tips_bar", "4", 101, 0);
                        return;
                    }
                }
                QLog.e(C2CChatHistoryVasApiImpl.TAG, 1, "data is invalid " + imageUrl + " " + nVar + ".barJumpUrl");
                return;
            }
            QLog.e(C2CChatHistoryVasApiImpl.TAG, 1, "MESSAGE_ROAMING, showInfo is null");
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(50243);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public C2CChatHistoryVasApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final boolean checkPermission(String uin) {
        int decodeInt;
        VipMMKV.Companion companion = VipMMKV.INSTANCE;
        if (Math.abs(System.currentTimeMillis() - companion.getCommon(uin).decodeLong(KEY_SHOW_TIME, 0L)) <= 604800000 || (decodeInt = companion.getCommon(uin).decodeInt(KEY_SHOW_COUNT, 0)) >= 5) {
            return false;
        }
        QLog.i(TAG, 2, "show tips because showCount=" + decodeInt);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getTipsDrawable$lambda$0(k it) {
        Intrinsics.checkNotNullParameter(it, "it");
        it.C(ViewUtils.getScreenWidth());
        it.B((int) ((ViewUtils.getScreenWidth() / 375.0f) * 48));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateCheckPermissionSp(String uin) {
        long currentTimeMillis = System.currentTimeMillis();
        VipMMKV.Companion companion = VipMMKV.INSTANCE;
        int decodeInt = companion.getCommon(uin).decodeInt(KEY_SHOW_COUNT, 0);
        companion.getCommon(uin).encodeLong(KEY_SHOW_TIME, currentTimeMillis);
        companion.getCommon(uin).encodeInt(KEY_SHOW_COUNT, decodeInt + 1);
    }

    @Override // com.tencent.qqnt.chathistory.bridge.IC2CChatHistoryVasApi
    @NotNull
    public Drawable getTipsDrawable(@NotNull String url) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Drawable) iPatchRedirector.redirect((short) 2, (Object) this, (Object) url);
        }
        Intrinsics.checkNotNullParameter(url, "url");
        return com.tencent.cachedrawable.dynamicdrawable.api.a.a().k(url).g(new a.c() { // from class: com.tencent.qqnt.chathistory.bridge.impl.a
            @Override // com.tencent.cachedrawable.dynamicdrawable.api.a.c
            public final void a(k kVar) {
                C2CChatHistoryVasApiImpl.getTipsDrawable$lambda$0(kVar);
            }
        }).l(VasDynamicDrawableCache.INSTANCE).a();
    }

    @Override // com.tencent.qqnt.chathistory.bridge.IC2CChatHistoryVasApi
    public void jumpToH5(@NotNull Context context, @NotNull String url) {
        boolean startsWith$default;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) context, (Object) url);
            return;
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(url, "url");
        ((IMobileReportManager) QRoute.api(IMobileReportManager.class)).reportAction(SearchConstants.PLATFORM, "chat_record", "chat_record_bar", "", "tips_bar", "4", 102, 0);
        BaseQQAppInterface baseQQAppInterface = null;
        startsWith$default = StringsKt__StringsJVMKt.startsWith$default(url, "https", false, 2, null);
        if (startsWith$default) {
            ((IVasHybridRoute) QRoute.api(IVasHybridRoute.class)).openTranslucentBrowser(context, url, null, null);
            return;
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime instanceof BaseQQAppInterface) {
            baseQQAppInterface = (BaseQQAppInterface) peekAppRuntime;
        }
        if (baseQQAppInterface == null) {
            return;
        }
        ax c16 = bi.c(baseQQAppInterface, context, url);
        if (c16 == null) {
            QLog.e(TAG, 1, "launchScheme: jumpAction is null");
        }
        c16.b();
    }

    @Override // com.tencent.qqnt.chathistory.bridge.IC2CChatHistoryVasApi
    public void requestTipsData(@NotNull Function1<? super com.tencent.qqnt.chathistory.bridge.a, Unit> successCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) successCallback);
            return;
        }
        Intrinsics.checkNotNullParameter(successCallback, "successCallback");
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            return;
        }
        String uin = peekAppRuntime.getAccount();
        Intrinsics.checkNotNullExpressionValue(uin, "uin");
        if (!checkPermission(uin)) {
            QLog.i(TAG, 2, "can't show tips");
        } else {
            com.tencent.mobileqq.vas.perception.api.impl.n.f310567a.v(3, 1, uin, new b(uin, successCallback));
        }
    }
}
