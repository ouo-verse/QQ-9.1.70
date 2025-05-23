package com.tencent.mobileqq.hotpic;

import android.content.Context;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mvi.base.mvi.MviUIState;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.pluspanel.data.c;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0015\u0018\u0000  2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001!B\u0017\u0012\u0006\u0010\u0014\u001a\u00020\r\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\t\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\bH\u0016J\u0010\u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u0002H\u0016J\b\u0010\f\u001a\u00020\u0006H\u0016R\"\u0010\u0014\u001a\u00020\r8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\"\u0010\u0005\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001d\u001a\u00020\b8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001c\u00a8\u0006\""}, d2 = {"Lcom/tencent/mobileqq/hotpic/o;", "Lcom/tencent/aio/base/mvvm/b;", "Lol3/b;", "Lcom/tencent/mvi/base/mvi/MviUIState;", "Landroid/content/Context;", "context", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/aio/api/runtime/a;", "onCreate", "intent", "handleIntent", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Lcom/tencent/mobileqq/hotpic/NTHotPicMainPanel;", "d", "Lcom/tencent/mobileqq/hotpic/NTHotPicMainPanel;", "getMHotPicPanel", "()Lcom/tencent/mobileqq/hotpic/NTHotPicMainPanel;", "setMHotPicPanel", "(Lcom/tencent/mobileqq/hotpic/NTHotPicMainPanel;)V", "mHotPicPanel", "e", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "setContext", "(Landroid/content/Context;)V", "f", "Lcom/tencent/aio/api/runtime/a;", "mAioContext", "<init>", "(Lcom/tencent/mobileqq/hotpic/NTHotPicMainPanel;Landroid/content/Context;)V", tl.h.F, "a", "qqemoticonpanel-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes9.dex */
public final class o extends com.tencent.aio.base.mvvm.b<ol3.b, MviUIState> {
    static IPatchRedirector $redirector_;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private NTHotPicMainPanel mHotPicPanel;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private Context context;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private com.tencent.aio.api.runtime.a mAioContext;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/hotpic/o$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqemoticonpanel-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.hotpic.o$a, reason: from kotlin metadata */
    /* loaded from: classes9.dex */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(23845);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 9)) {
            redirector.redirect((short) 9);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public o(@NotNull NTHotPicMainPanel mHotPicPanel, @NotNull Context context) {
        Intrinsics.checkNotNullParameter(mHotPicPanel, "mHotPicPanel");
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) mHotPicPanel, (Object) context);
        } else {
            this.mHotPicPanel = mHotPicPanel;
            this.context = context;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l(o this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        NTHotPicMainPanel nTHotPicMainPanel = this$0.mHotPicPanel;
        nTHotPicMainPanel.G.setCurrentItem(nTHotPicMainPanel.I, true);
    }

    private final void m(Context context) {
        BaseQQAppInterface baseQQAppInterface;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        com.tencent.aio.api.runtime.a aVar = null;
        if (peekAppRuntime instanceof BaseQQAppInterface) {
            baseQQAppInterface = (BaseQQAppInterface) peekAppRuntime;
        } else {
            baseQQAppInterface = null;
        }
        NTHotPicMainPanel nTHotPicMainPanel = this.mHotPicPanel;
        com.tencent.aio.api.runtime.a aVar2 = this.mAioContext;
        if (aVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAioContext");
        } else {
            aVar = aVar2;
        }
        nTHotPicMainPanel.k(baseQQAppInterface, context, aVar);
        this.mHotPicPanel.q();
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVM
    public void handleIntent(@NotNull ol3.b intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) intent);
            return;
        }
        Intrinsics.checkNotNullParameter(intent, "intent");
        if (intent instanceof c.a) {
            c.a aVar = (c.a) intent;
            QLog.d("NTHotPicPanelVM", 1, "intent: " + aVar.a());
            if (aVar.a() == 1009) {
                this.mHotPicPanel.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.hotpic.n
                    @Override // java.lang.Runnable
                    public final void run() {
                        o.l(o.this);
                    }
                }, 200L);
            }
        }
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVM
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        QLog.d("NTHotPicPanelVM", 1, "NTHotPicPanelVM onDestroy");
        super.onDestroy();
        this.mHotPicPanel.p();
    }

    @Override // com.tencent.aio.base.mvvm.b, com.tencent.mvi.mvvm.framework.FrameworkVM
    public void onCreate(@NotNull com.tencent.aio.api.runtime.a context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) context);
            return;
        }
        Intrinsics.checkNotNullParameter(context, "context");
        QLog.d("NTHotPicPanelVM", 1, "NTHotPicPanelVM onCreate");
        super.onCreate(context);
        this.mAioContext = context;
        m(this.context);
    }
}
