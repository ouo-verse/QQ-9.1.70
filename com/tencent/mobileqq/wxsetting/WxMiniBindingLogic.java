package com.tencent.mobileqq.wxsetting;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.mini.ui.WechatBindingAndAuthContentView;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.wxmini.api.IWxMiniManager;
import com.tencent.mobileqq.wxmini.api.data.b;
import com.tencent.mobileqq.wxsetting.WxMiniBindingLogic;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.utils.FastClickUtils;
import com.tencent.util.LoadingUtil;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000G\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\b\t*\u0001+\u0018\u0000 12\u00020\u0001:\u00012B\u000f\u0012\u0006\u0010\u0016\u001a\u00020\u0011\u00a2\u0006\u0004\b/\u00100J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\u000e\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005J\u000e\u0010\t\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0005J\u0006\u0010\u000b\u001a\u00020\nJ\b\u0010\f\u001a\u00020\u0002H\u0007J\b\u0010\r\u001a\u00020\u0002H\u0007J\u0006\u0010\u000e\u001a\u00020\u0002J\u0006\u0010\u000f\u001a\u00020\u0002J\u0006\u0010\u0010\u001a\u00020\u0002R\u0017\u0010\u0016\u001a\u00020\u00118\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0016\u0010\u001a\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u001b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0014\u0010\"\u001a\u00020\u001f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b \u0010!R\u0016\u0010%\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010'\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b&\u0010$R\u0016\u0010*\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b(\u0010)R\u0016\u0010.\u001a\u00020+8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b,\u0010-\u00a8\u00063"}, d2 = {"Lcom/tencent/mobileqq/wxsetting/WxMiniBindingLogic;", "Landroidx/lifecycle/LifecycleObserver;", "", "v", "y", "", "authSource", HippyTKDListViewAdapter.X, "authRevokeSource", "w", "", "o", "onCreate", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "u", "B", "p", "Lcom/tencent/mobileqq/mini/ui/WechatBindingAndAuthContentView;", "d", "Lcom/tencent/mobileqq/mini/ui/WechatBindingAndAuthContentView;", DomainData.DOMAIN_NAME, "()Lcom/tencent/mobileqq/mini/ui/WechatBindingAndAuthContentView;", "contentView", "", "e", "Ljava/lang/String;", "currentHandlerCode", "Landroid/app/Dialog;", "f", "Landroid/app/Dialog;", "loadingDialog", "Ljava/util/concurrent/atomic/AtomicBoolean;", h.F, "Ljava/util/concurrent/atomic/AtomicBoolean;", "isInitFinish", "i", "I", "mAuthSource", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "mAuthRevokeSource", BdhLogUtil.LogTag.Tag_Conn, "Z", "mIsUserUnbinded", "com/tencent/mobileqq/wxsetting/WxMiniBindingLogic$c", "D", "Lcom/tencent/mobileqq/wxsetting/WxMiniBindingLogic$c;", "bindingObserver", "<init>", "(Lcom/tencent/mobileqq/mini/ui/WechatBindingAndAuthContentView;)V", "E", "b", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class WxMiniBindingLogic implements LifecycleObserver {

    /* renamed from: C, reason: from kotlin metadata */
    private boolean mIsUserUnbinded;

    /* renamed from: D, reason: from kotlin metadata */
    private c bindingObserver;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final WechatBindingAndAuthContentView contentView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private String currentHandlerCode;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private Dialog loadingDialog;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final AtomicBoolean isInitFinish;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private int mAuthSource;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private int mAuthRevokeSource;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/wxsetting/WxMiniBindingLogic$a", "Lcom/tencent/mobileqq/mini/ui/WechatBindingAndAuthContentView$WxBindOrUnbindOnClickListener;", "Landroid/view/View;", "view", "Lcom/tencent/mobileqq/mini/ui/WechatBindingAndAuthContentView$AccountBindingType;", "accountBindingType", "", NodeProps.ON_CLICK, "qqmini_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class a implements WechatBindingAndAuthContentView.WxBindOrUnbindOnClickListener {

        /* compiled from: P */
        @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
        /* renamed from: com.tencent.mobileqq.wxsetting.WxMiniBindingLogic$a$a, reason: collision with other inner class name */
        /* loaded from: classes35.dex */
        public /* synthetic */ class C9103a {

            /* renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f327835a;

            static {
                int[] iArr = new int[WechatBindingAndAuthContentView.AccountBindingType.values().length];
                try {
                    iArr[WechatBindingAndAuthContentView.AccountBindingType.ACCOUNT_BINDING_TYPE.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[WechatBindingAndAuthContentView.AccountBindingType.ACCOUNT_EMPTY_USER_INFO_TYPE.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[WechatBindingAndAuthContentView.AccountBindingType.ACCOUNT_UNBINDING_TYPE.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                f327835a = iArr;
            }
        }

        a() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void c() {
            QQToast.makeText(MobileQQ.sMobileQQ, 0, "\u52a0\u8f7d\u4e2d\uff0c\u8bf7\u7a0d\u540e\u518d\u8bd5", 0).show();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void d(WxMiniBindingLogic this$0) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Dialog dialog = this$0.loadingDialog;
            if (dialog != null) {
                dialog.dismiss();
            }
        }

        @Override // com.tencent.mobileqq.mini.ui.WechatBindingAndAuthContentView.WxBindOrUnbindOnClickListener
        public void onClick(View view, WechatBindingAndAuthContentView.AccountBindingType accountBindingType) {
            Intrinsics.checkNotNullParameter(accountBindingType, "accountBindingType");
            if (!WxMiniBindingLogic.this.isInitFinish.get()) {
                QLog.i("WxMiniBindingLogic", 1, "Click bind button but init now finish");
                ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: ob3.g
                    @Override // java.lang.Runnable
                    public final void run() {
                        WxMiniBindingLogic.a.c();
                    }
                });
                return;
            }
            int i3 = C9103a.f327835a[accountBindingType.ordinal()];
            if (i3 == 1 || i3 == 2) {
                WxMiniBindingLogic.this.y();
                return;
            }
            if (i3 != 3) {
                return;
            }
            WxMiniBindingLogic wxMiniBindingLogic = WxMiniBindingLogic.this;
            wxMiniBindingLogic.loadingDialog = LoadingUtil.showLoadingDialog(wxMiniBindingLogic.getContentView().getContext(), WxMiniBindingLogic.this.getContentView().getContext().getString(R.string.o7h), false);
            Handler uIHandlerV2 = ThreadManagerV2.getUIHandlerV2();
            final WxMiniBindingLogic wxMiniBindingLogic2 = WxMiniBindingLogic.this;
            uIHandlerV2.postDelayed(new Runnable() { // from class: ob3.h
                @Override // java.lang.Runnable
                public final void run() {
                    WxMiniBindingLogic.a.d(WxMiniBindingLogic.this);
                }
            }, 10000L);
            if (FastClickUtils.isFastDoubleClick("WxMiniBindingLogic", 2000L)) {
                return;
            }
            ((IWxMiniManager) QRoute.api(IWxMiniManager.class)).sendWxAuthEvent(WxMiniBindingLogic.this.getContentView().getContext(), WxMiniBindingLogic.this.mAuthSource);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\"\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/wxsetting/WxMiniBindingLogic$c", "Lcom/tencent/mobileqq/wxmini/api/account/a;", "", "type", "", "isSuccess", "Landroid/os/Bundle;", "bundle", "", "onReceive", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class c extends com.tencent.mobileqq.wxmini.api.account.a {
        c() {
        }

        @Override // com.tencent.mobileqq.wxmini.api.account.a, mqq.observer.BusinessObserver
        public void onReceive(int type, boolean isSuccess, Bundle bundle) {
            QLog.i("WxMiniBindingLogic", 1, "bindingObserver type:" + type + " isSuccess:" + isSuccess);
            String string = bundle != null ? bundle.getString("code") : null;
            if (type != 0) {
                if (type == 1) {
                    WxMiniBindingLogic.this.p();
                    return;
                } else if (type != 2) {
                    return;
                }
            }
            if (string == null || string.length() == 0) {
                QLog.d("WxMiniBindingLogic", 1, "onReceive notify type " + type + " but code is null");
                return;
            }
            if (Intrinsics.areEqual(WxMiniBindingLogic.this.currentHandlerCode, string)) {
                Dialog dialog = WxMiniBindingLogic.this.loadingDialog;
                if (dialog != null) {
                    dialog.dismiss();
                }
                WxMiniBindingLogic.this.p();
                return;
            }
            WxMiniBindingLogic.this.currentHandlerCode = string;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/wxsetting/WxMiniBindingLogic$d", "Lcom/tencent/mobileqq/wxmini/api/data/c;", "Lcom/tencent/mobileqq/wxmini/api/data/d;", "info", "", "a", "", "type", "onFail", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class d implements com.tencent.mobileqq.wxmini.api.data.c {
        d() {
        }

        @Override // com.tencent.mobileqq.wxmini.api.data.c
        public void a(com.tencent.mobileqq.wxmini.api.data.d info) {
            QLog.i("WxMiniBindingLogic", 1, "sendWxAccountUnBindRequest onSuccess info:" + info);
        }

        @Override // com.tencent.mobileqq.wxmini.api.data.c
        public void onFail(int type) {
            QLog.i("WxMiniBindingLogic", 1, "sendWxAccountUnBindRequest onFail type:" + type);
        }
    }

    public WxMiniBindingLogic(WechatBindingAndAuthContentView contentView) {
        Intrinsics.checkNotNullParameter(contentView, "contentView");
        this.contentView = contentView;
        this.currentHandlerCode = "";
        this.isInitFinish = new AtomicBoolean(false);
        this.mAuthSource = 1;
        this.mAuthRevokeSource = 2;
        this.bindingObserver = new c();
        contentView.setWxBindOrUnbindOnClickListener(new a());
        p();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void A(DialogInterface dialogInterface, int i3) {
        dialogInterface.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q(WxMiniBindingLogic this$0, boolean z16, Bundle bundle) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QLog.i("WxMiniBindingLogic", 1, "loadDynamicPackage: " + z16);
        if (z16) {
            this$0.p();
        } else {
            this$0.isInitFinish.set(true);
            this$0.contentView.setUnBindUIInfo();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r(final WxMiniBindingLogic this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ((IWxMiniManager) QRoute.api(IWxMiniManager.class)).checkWxAuthed(new b() { // from class: ob3.c
            @Override // com.tencent.mobileqq.wxmini.api.data.b
            public final void onCallback(boolean z16, Bundle bundle) {
                WxMiniBindingLogic.s(WxMiniBindingLogic.this, z16, bundle);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s(final WxMiniBindingLogic this$0, final boolean z16, Bundle bundle) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        final com.tencent.mobileqq.wxmini.api.data.d bindingWeChatUserInfo = ((IWxMiniManager) QRoute.api(IWxMiniManager.class)).getBindingWeChatUserInfo();
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: ob3.f
            @Override // java.lang.Runnable
            public final void run() {
                WxMiniBindingLogic.t(WxMiniBindingLogic.this, z16, bindingWeChatUserInfo);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void t(WxMiniBindingLogic this$0, boolean z16, com.tencent.mobileqq.wxmini.api.data.d dVar) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.isInitFinish.set(true);
        if (z16 && dVar != null) {
            WechatBindingAndAuthContentView wechatBindingAndAuthContentView = this$0.contentView;
            String d16 = dVar.d();
            Intrinsics.checkNotNullExpressionValue(d16, "thirdAccountInfo.headImageUrl");
            String e16 = dVar.e();
            Intrinsics.checkNotNullExpressionValue(e16, "thirdAccountInfo.nickName");
            wechatBindingAndAuthContentView.setBindUIInfo(d16, e16);
        } else if (z16) {
            this$0.contentView.setEmptyUserInfo();
        } else {
            this$0.contentView.setUnBindUIInfo();
        }
        QLog.i("WxMiniBindingLogic", 1, "initData isSuccess:" + z16 + " thirdAccountInfo:" + dVar);
    }

    private final void v() {
        ((IWxMiniManager) QRoute.api(IWxMiniManager.class)).sendWxAccountUnBindRequest(new d());
        ((IWxMiniManager) QRoute.api(IWxMiniManager.class)).onLogout(this.mAuthRevokeSource);
        p();
        QQToast.makeText(this.contentView.getContext(), 2, MobileQQ.sMobileQQ.getString(R.string.xy6), 1).show();
        this.mIsUserUnbinded = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void y() {
        QQCustomDialog createCustomDialog = DialogUtil.createCustomDialog(this.contentView.getContext(), this.contentView.getContext().getString(R.string.xzr), this.contentView.getContext().getString(R.string.xzs), this.contentView.getContext().getString(R.string.f169855xz3), this.contentView.getContext().getString(R.string.xya), new DialogInterface.OnClickListener() { // from class: ob3.d
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                WxMiniBindingLogic.z(WxMiniBindingLogic.this, dialogInterface, i3);
            }
        }, new DialogInterface.OnClickListener() { // from class: ob3.e
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                WxMiniBindingLogic.A(dialogInterface, i3);
            }
        });
        Intrinsics.checkNotNullExpressionValue(createCustomDialog, "createCustomDialog(\n    \u2026\n            },\n        )");
        createCustomDialog.setCanceledOnTouchOutside(false);
        createCustomDialog.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void z(WxMiniBindingLogic this$0, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.v();
        dialogInterface.dismiss();
    }

    public final void B() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null) {
            peekAppRuntime.unRegistObserver(this.bindingObserver);
        }
    }

    /* renamed from: n, reason: from getter */
    public final WechatBindingAndAuthContentView getContentView() {
        return this.contentView;
    }

    /* renamed from: o, reason: from getter */
    public final boolean getMIsUserUnbinded() {
        return this.mIsUserUnbinded;
    }

    public final void p() {
        if (!((IWxMiniManager) QRoute.api(IWxMiniManager.class)).checkDynamicPackage()) {
            ((IWxMiniManager) QRoute.api(IWxMiniManager.class)).loadDynamicPackage(new b() { // from class: ob3.a
                @Override // com.tencent.mobileqq.wxmini.api.data.b
                public final void onCallback(boolean z16, Bundle bundle) {
                    WxMiniBindingLogic.q(WxMiniBindingLogic.this, z16, bundle);
                }
            });
            QLog.i("WxMiniBindingLogic", 1, "refreshMiniAppNotificationDataInfo checkDynamicPackage false!");
        } else {
            ThreadManagerV2.executeOnSubThread(new Runnable() { // from class: ob3.b
                @Override // java.lang.Runnable
                public final void run() {
                    WxMiniBindingLogic.r(WxMiniBindingLogic.this);
                }
            });
            QLog.i("WxMiniBindingLogic", 1, "refreshMiniAppNotificationDataInfo!");
        }
    }

    public final void u() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null) {
            peekAppRuntime.registObserver(this.bindingObserver);
        }
    }

    public final void w(int authRevokeSource) {
        this.mAuthRevokeSource = authRevokeSource;
    }

    public final void x(int authSource) {
        this.mAuthSource = authSource;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    public final void onCreate() {
        QLog.i("WxMiniBindingLogic", 1, "onCreate");
        u();
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public final void onDestroy() {
        QLog.i("WxMiniBindingLogic", 1, MosaicConstants$JsFunction.FUNC_ON_DESTROY);
        B();
    }
}
