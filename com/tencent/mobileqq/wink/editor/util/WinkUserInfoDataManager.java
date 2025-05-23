package com.tencent.mobileqq.wink.editor.util;

import androidx.annotation.Keep;
import camera.SHADOW_BACKEND_INTERFACE.CircleTemplateInfo;
import camera.SHADOW_BACKEND_INTERFACE.GetCircleTemplateInfoReq;
import camera.SHADOW_BACKEND_INTERFACE.GetCircleTemplateInfoRsp;
import com.qq.jce.wup.UniPacket;
import com.tencent.bugly.common.constants.Constants;
import com.tencent.common.app.AppInterface;
import com.tencent.component.network.downloader.impl.ipc.Const;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.wink.edit.manager.WinkDataServiceHandler;
import com.tencent.mobileqq.wink.editor.model.WinkUserInfo;
import com.tencent.mobileqq.wink.editor.util.WinkUserInfoDataManager;
import com.tencent.mobileqq.wink.listener.ResDownLoadListener;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\b\n\u0018\u0000  2\u00020\u0001:\u0002!\"B\t\b\u0002\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\u001e\u0010\u0006\u001a\u00020\u00042\u0014\u0010\u0005\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u0004\u0012\u00020\u00040\u0002H\u0002J,\u0010\t\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u00072\u0018\b\u0002\u0010\u0005\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0002H\u0002J\u0012\u0010\u000b\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\u0003H\u0002J\u001c\u0010\f\u001a\u00020\u00042\u0014\u0010\u0005\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u0004\u0012\u00020\u00040\u0002J\"\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016R\u001b\u0010\u0018\u001a\u00020\u00148BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0015\u0010\u0017R(\u0010\u001b\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u0004\u0012\u00020\u00040\u00020\u00198\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\u001aR\u0016\u0010\u001d\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u001c\u00a8\u0006#"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/util/WinkUserInfoDataManager;", "Lcom/tencent/mobileqq/app/BusinessObserver;", "Lkotlin/Function1;", "Lcom/tencent/mobileqq/wink/editor/model/c;", "", "callback", "g", "", "logoUrl", "c", "result", "f", "e", "", "type", "", "isSuccess", "", "data", "onUpdate", "Lcom/tencent/mobileqq/wink/editor/util/WinkUserInfoDataManager$UserInfoBusinessHandler;", "d", "Lkotlin/Lazy;", "()Lcom/tencent/mobileqq/wink/editor/util/WinkUserInfoDataManager$UserInfoBusinessHandler;", "serviceHandler", "", "Ljava/util/List;", "list", "Z", "isInRequest", "<init>", "()V", tl.h.F, "a", "UserInfoBusinessHandler", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class WinkUserInfoDataManager implements BusinessObserver {

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: i, reason: collision with root package name */
    @NotNull
    private static final Lazy<WinkUserInfoDataManager> f322620i;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy serviceHandler;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<Function1<WinkUserInfo, Unit>> list;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private boolean isInRequest;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001cB\u0011\b\u0017\u0012\u0006\u0010\u0018\u001a\u00020\u0017\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u001a\u0010\r\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0002J\u0006\u0010\u000e\u001a\u00020\fJ\u0018\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0018\u0010\u0012\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\bH\u0016J\"\u0010\u0013\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016J\u0010\u0010\u0016\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00150\u0014H\u0014\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/util/WinkUserInfoDataManager$UserInfoBusinessHandler;", "Lcom/tencent/mobileqq/wink/edit/manager/WinkDataServiceHandler;", "Lcom/tencent/qphone/base/remote/ToServiceMsg;", Const.BUNDLE_KEY_REQUEST, "Lcom/qq/jce/wup/UniPacket;", "client", "", "r3", "Lcom/tencent/qphone/base/remote/FromServiceMsg;", "res", "", "data", "", ICustomDataEditor.STRING_PARAM_3, "t3", "req", "F2", "resp", Constants.BASE_IN_PLUGIN_VERSION, "onReceive", "Ljava/lang/Class;", "Lcom/tencent/mobileqq/app/BusinessObserver;", "observerClass", "Lcom/tencent/common/app/AppInterface;", "app", "<init>", "(Lcom/tencent/common/app/AppInterface;)V", "e", "a", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class UserInfoBusinessHandler extends WinkDataServiceHandler {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        @Keep
        public UserInfoBusinessHandler(@NotNull AppInterface app) {
            super(app);
            Intrinsics.checkNotNullParameter(app, "app");
        }

        private final boolean r3(ToServiceMsg request, UniPacket client) {
            GetCircleTemplateInfoReq getCircleTemplateInfoReq = new GetCircleTemplateInfoReq(request.getUin());
            client.setServantName("ShadowBackendSvc");
            client.setFuncName("ShadowBackendSvc.GetCircleTemplateInfo");
            client.put("ShadowBackendSvc.GetCircleTemplateInfo", getCircleTemplateInfoReq);
            return true;
        }

        private final void s3(FromServiceMsg res, Object data) {
            GetCircleTemplateInfoRsp getCircleTemplateInfoRsp;
            CircleTemplateInfo circleTemplateInfo;
            if (data instanceof GetCircleTemplateInfoRsp) {
                getCircleTemplateInfoRsp = (GetCircleTemplateInfoRsp) data;
            } else {
                getCircleTemplateInfoRsp = null;
            }
            if (getCircleTemplateInfoRsp != null && getCircleTemplateInfoRsp.Code == 0 && (circleTemplateInfo = getCircleTemplateInfoRsp.TemplateInfo) != null) {
                notifyUI(1000, true, circleTemplateInfo);
            } else {
                notifyUI(1000, false, null);
            }
        }

        @Override // com.tencent.mobileqq.wink.edit.manager.WinkDataServiceHandler, com.tencent.mobileqq.wink.edit.manager.WinkDataBaseServiceHandler
        @NotNull
        public Object D2(@NotNull ToServiceMsg req, @NotNull FromServiceMsg resp) {
            boolean equals;
            Object D2;
            String str;
            Intrinsics.checkNotNullParameter(req, "req");
            Intrinsics.checkNotNullParameter(resp, "resp");
            equals = StringsKt__StringsJVMKt.equals(req.getServiceCmd(), "ShadowBackendSvc.GetCircleTemplateInfo", true);
            if (equals) {
                D2 = E2(resp.getWupBuffer(), "ShadowBackendSvc.GetCircleTemplateInfo", new GetCircleTemplateInfoRsp());
                str = "decodeCompressPacked(res\u2026tCircleTemplateInfoRsp())";
            } else {
                D2 = super.D2(req, resp);
                str = "if (req.serviceCmd.equal\u2026(req, resp)\n            }";
            }
            Intrinsics.checkNotNullExpressionValue(D2, str);
            return D2;
        }

        @Override // com.tencent.mobileqq.wink.edit.manager.WinkDataServiceHandler, com.tencent.mobileqq.wink.edit.manager.WinkDataBaseServiceHandler
        public boolean F2(@NotNull ToServiceMsg req, @NotNull UniPacket client) {
            boolean equals;
            Intrinsics.checkNotNullParameter(req, "req");
            Intrinsics.checkNotNullParameter(client, "client");
            equals = StringsKt__StringsJVMKt.equals(req.getServiceCmd(), "ShadowBackendSvc.GetCircleTemplateInfo", true);
            if (equals) {
                return r3(req, client);
            }
            return super.F2(req, client);
        }

        @Override // com.tencent.mobileqq.wink.edit.manager.WinkDataServiceHandler, com.tencent.mobileqq.app.BusinessHandler
        @NotNull
        protected Class<? extends BusinessObserver> observerClass() {
            return WinkUserInfoDataManager.class;
        }

        @Override // com.tencent.mobileqq.wink.edit.manager.WinkDataServiceHandler, com.tencent.mobileqq.app.BaseBusinessHandler
        public void onReceive(@NotNull ToServiceMsg req, @NotNull FromServiceMsg res, @Nullable Object data) {
            Intrinsics.checkNotNullParameter(req, "req");
            Intrinsics.checkNotNullParameter(res, "res");
            if (Intrinsics.areEqual(req.getServiceCmd(), "ShadowBackendSvc.GetCircleTemplateInfo")) {
                s3(res, data);
            }
        }

        public final void t3() {
            ToServiceMsg toServiceMsg = new ToServiceMsg("ShadowBackendSvc", com.tencent.mobileqq.wink.b.a().getAccount(), "ShadowBackendSvc.GetCircleTemplateInfo");
            toServiceMsg.setTimeout(10000L);
            toServiceMsg.setSendTimeout(10000L);
            x53.c.a(toServiceMsg, UserInfoBusinessHandler.class.getName(), x53.b.class);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010J\b\u0010\u0003\u001a\u00020\u0002H\u0007R\u001b\u0010\b\u001a\u00020\u00028FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\n\u001a\u00020\t8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\r\u001a\u00020\f8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000e\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/util/WinkUserInfoDataManager$a;", "", "Lcom/tencent/mobileqq/wink/editor/util/WinkUserInfoDataManager;", "b", "dataManager$delegate", "Lkotlin/Lazy;", "a", "()Lcom/tencent/mobileqq/wink/editor/util/WinkUserInfoDataManager;", "dataManager", "", "TAG", "Ljava/lang/String;", "", "TYPE_USER_INFO", "I", "<init>", "()V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.wink.editor.util.WinkUserInfoDataManager$a, reason: from kotlin metadata */
    /* loaded from: classes21.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final WinkUserInfoDataManager a() {
            return (WinkUserInfoDataManager) WinkUserInfoDataManager.f322620i.getValue();
        }

        @JvmStatic
        @NotNull
        public final WinkUserInfoDataManager b() {
            return a();
        }

        Companion() {
        }
    }

    static {
        Lazy<WinkUserInfoDataManager> lazy;
        lazy = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, (Function0) new Function0<WinkUserInfoDataManager>() { // from class: com.tencent.mobileqq.wink.editor.util.WinkUserInfoDataManager$Companion$dataManager$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final WinkUserInfoDataManager invoke() {
                return new WinkUserInfoDataManager(null);
            }
        });
        f322620i = lazy;
    }

    public /* synthetic */ WinkUserInfoDataManager(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private final void c(String logoUrl, Function1<? super String, Unit> callback) {
        if (logoUrl != null) {
            String str = u53.b.f438371b + File.separator + com.tencent.mobileqq.wink.b.a().getAccount() + "_template_user_avatar";
            w53.b.f("WinkUserInfoDataManager", "downloadQQLogo path is " + str);
            com.tencent.mobileqq.wink.downloader.b.f318210a.b(logoUrl, str, new b(callback, str));
            return;
        }
        if (callback != null) {
            callback.invoke(null);
        }
    }

    private final UserInfoBusinessHandler d() {
        return (UserInfoBusinessHandler) this.serviceHandler.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void f(WinkUserInfo result) {
        this.isInRequest = false;
        Iterator<T> it = this.list.iterator();
        while (it.hasNext()) {
            ((Function1) it.next()).invoke(result);
        }
        this.list.clear();
    }

    private final void g(Function1<? super WinkUserInfo, Unit> callback) {
        if (!com.tencent.mobileqq.wink.b.a().getBusinessObserver(0).contains(this)) {
            com.tencent.mobileqq.wink.b.a().addDefaultObservers(this);
        }
        this.list.add(callback);
        if (!this.isInRequest) {
            this.isInRequest = true;
            d().t3();
        }
    }

    public final void e(@NotNull Function1<? super WinkUserInfo, Unit> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        g(callback);
    }

    @Override // com.tencent.mobileqq.app.BusinessObserver
    public void onUpdate(int type, boolean isSuccess, @Nullable Object data) {
        CircleTemplateInfo circleTemplateInfo;
        w53.b.c("WinkUserInfoDataManager", "type = " + type + ", isSuccess = " + isSuccess + ", data = " + data);
        com.tencent.mobileqq.wink.b.a().removeObserver(this);
        if (isSuccess && (data instanceof CircleTemplateInfo)) {
            circleTemplateInfo = (CircleTemplateInfo) data;
        } else {
            circleTemplateInfo = null;
        }
        if (circleTemplateInfo == null) {
            f(null);
        } else {
            c(circleTemplateInfo.getQqLogo(), new WinkUserInfoDataManager$onUpdate$1(this, circleTemplateInfo));
        }
    }

    WinkUserInfoDataManager() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<UserInfoBusinessHandler>() { // from class: com.tencent.mobileqq.wink.editor.util.WinkUserInfoDataManager$serviceHandler$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final WinkUserInfoDataManager.UserInfoBusinessHandler invoke() {
                BusinessHandler businessHandler = com.tencent.mobileqq.wink.b.a().getBusinessHandler(WinkUserInfoDataManager.UserInfoBusinessHandler.class.getName());
                Intrinsics.checkNotNull(businessHandler, "null cannot be cast to non-null type com.tencent.mobileqq.wink.editor.util.WinkUserInfoDataManager.UserInfoBusinessHandler");
                return (WinkUserInfoDataManager.UserInfoBusinessHandler) businessHandler;
            }
        });
        this.serviceHandler = lazy;
        this.list = new ArrayList();
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/wink/editor/util/WinkUserInfoDataManager$b", "Lcom/tencent/mobileqq/wink/listener/ResDownLoadListener;", "", "isSuccess", "", "onDownloadFinish", "", "progress", "onProgressUpdate", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class b implements ResDownLoadListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Function1<String, Unit> f322625a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f322626b;

        /* JADX WARN: Multi-variable type inference failed */
        b(Function1<? super String, Unit> function1, String str) {
            this.f322625a = function1;
            this.f322626b = str;
        }

        @Override // com.tencent.mobileqq.wink.listener.ResDownLoadListener
        public void onDownloadFinish(boolean isSuccess) {
            if (isSuccess) {
                Function1<String, Unit> function1 = this.f322625a;
                if (function1 != null) {
                    function1.invoke(this.f322626b);
                    return;
                }
                return;
            }
            Function1<String, Unit> function12 = this.f322625a;
            if (function12 != null) {
                function12.invoke(null);
            }
        }

        @Override // com.tencent.mobileqq.wink.listener.ResDownLoadListener
        public void onProgressUpdate(int progress) {
        }
    }
}
