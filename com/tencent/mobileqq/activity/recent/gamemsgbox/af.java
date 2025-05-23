package com.tencent.mobileqq.activity.recent.gamemsgbox;

import android.app.Activity;
import android.view.View;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.quibadge.QUIBadgeDragLayout;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.chats.api.IChatsViewModelCreator;
import com.tencent.qqnt.chats.api.b;
import com.tencent.qqnt.chats.core.ui.ChatsListVB;
import com.tencent.qqnt.chats.core.userintent.a;
import com.tencent.qqnt.chats.core.userintent.b;
import com.tencent.qqnt.kernel.api.IKernelService;
import com.tencent.qqnt.kernel.nativeinterface.IOperateCallback;
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 /2\u00020\u0001:\u00010B\u001f\u0012\u0006\u0010\u0017\u001a\u00020\u0012\u0012\u0006\u0010\u001c\u001a\u00020\u0007\u0012\u0006\u0010 \u001a\u00020\u001d\u00a2\u0006\u0004\b-\u0010.J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0006\u001a\u00020\u0002H\u0002J\u0010\u0010\t\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u0012\u0010\f\u001a\u00020\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016J\u0012\u0010\r\u001a\u00020\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016J\u0012\u0010\u000e\u001a\u00020\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016J\u0006\u0010\u000f\u001a\u00020\u0002J\u0010\u0010\u0011\u001a\u00020\u00022\b\u0010\u0010\u001a\u0004\u0018\u00010\u0007R\u0017\u0010\u0017\u001a\u00020\u00128\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u0017\u0010\u001c\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u0014\u0010 \u001a\u00020\u001d8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\"\u0010&\u001a\u000e\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020#0!8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u0016\u0010*\u001a\u00020'8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b(\u0010)R\u0018\u0010,\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b+\u0010\u0019\u00a8\u00061"}, d2 = {"Lcom/tencent/mobileqq/activity/recent/gamemsgbox/af;", "Lcom/tencent/biz/richframework/part/Part;", "", "z9", "", "A9", "C9", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "onPartResume", "onPartPause", "onPartDestroy", "B9", "view", "E9", "Lcom/tencent/mobileqq/app/QBaseActivity;", "d", "Lcom/tencent/mobileqq/app/QBaseActivity;", "getQBaseActivity", "()Lcom/tencent/mobileqq/app/QBaseActivity;", "qBaseActivity", "e", "Landroid/view/View;", "getMContentView", "()Landroid/view/View;", "mContentView", "", "f", "I", "gameBoxScene", "Lcom/tencent/qqnt/chats/core/mvi/a;", "Lcom/tencent/qqnt/chats/core/uistate/b;", "Lcom/tencent/qqnt/chats/core/userintent/b;", tl.h.F, "Lcom/tencent/qqnt/chats/core/mvi/a;", "mChatsVM", "Lcom/tencent/mobileqq/activity/recent/gamemsgbox/u;", "i", "Lcom/tencent/mobileqq/activity/recent/gamemsgbox/u;", "mChatsVB", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "gameCardView", "<init>", "(Lcom/tencent/mobileqq/app/QBaseActivity;Landroid/view/View;I)V", BdhLogUtil.LogTag.Tag_Conn, "a", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class af extends Part {
    static IPatchRedirector $redirector_;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final QBaseActivity qBaseActivity;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final View mContentView;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final int gameBoxScene;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private com.tencent.qqnt.chats.core.mvi.a<com.tencent.qqnt.chats.core.uistate.b, com.tencent.qqnt.chats.core.userintent.b> mChatsVM;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private u mChatsVB;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private View gameCardView;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/activity/recent/gamemsgbox/af$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.activity.recent.gamemsgbox.af$a, reason: from kotlin metadata */
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

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(52928);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 10)) {
            redirector.redirect((short) 10);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public af(@NotNull QBaseActivity qBaseActivity, @NotNull View mContentView, int i3) {
        Intrinsics.checkNotNullParameter(qBaseActivity, "qBaseActivity");
        Intrinsics.checkNotNullParameter(mContentView, "mContentView");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, qBaseActivity, mContentView, Integer.valueOf(i3));
            return;
        }
        this.qBaseActivity = qBaseActivity;
        this.mContentView = mContentView;
        this.gameBoxScene = i3;
    }

    private final boolean A9() {
        return Intrinsics.areEqual(e.f185509a.a(), "all");
    }

    private final void C9() {
        IKernelService iKernelService;
        com.tencent.qqnt.kernel.api.w msgService;
        AppRuntime waitAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime();
        if (waitAppRuntime != null && (iKernelService = (IKernelService) waitAppRuntime.getRuntimeService(IKernelService.class, "")) != null && (msgService = iKernelService.getMsgService()) != null) {
            msgService.setMsgRead(new Contact(116, v.INSTANCE.a(), ""), new IOperateCallback() { // from class: com.tencent.mobileqq.activity.recent.gamemsgbox.ae
                @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
                public final void onResult(int i3, String str) {
                    af.D9(af.this, i3, str);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void D9(af this$0, int i3, String str) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QLog.i("GameMsgBoxNtPart", 1, "setBoxMsgRead:" + v.INSTANCE.a() + ",code=" + i3 + ",msg=" + str);
    }

    private final void z9() {
        this.mChatsVM = (com.tencent.qqnt.chats.core.mvi.a) ((IChatsViewModelCreator) QRoute.api(IChatsViewModelCreator.class)).createGameBoxViewModel(LifecycleOwnerKt.getLifecycleScope(this.qBaseActivity), this.qBaseActivity, this.gameBoxScene);
        com.tencent.qqnt.chats.core.mvi.a<com.tencent.qqnt.chats.core.uistate.b, com.tencent.qqnt.chats.core.userintent.b> aVar = this.mChatsVM;
        com.tencent.qqnt.chats.core.mvi.a<com.tencent.qqnt.chats.core.uistate.b, com.tencent.qqnt.chats.core.userintent.b> aVar2 = null;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mChatsVM");
            aVar = null;
        }
        u uVar = new u(aVar, new l(this.gameBoxScene));
        this.mChatsVB = uVar;
        View findViewById = this.mContentView.findViewById(R.id.tug);
        Intrinsics.checkNotNullExpressionValue(findViewById, "mContentView.findViewByI\u2026chat_api.R.id.chats_list)");
        RecyclerView recyclerView = (RecyclerView) findViewById;
        View findViewById2 = this.mContentView.findViewById(R.id.evx);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "mContentView.findViewByI\u2026qchat_api.R.id.drag_area)");
        uVar.d0(new ChatsListVB.b(recyclerView, (QUIBadgeDragLayout) findViewById2, null, this.qBaseActivity, null, null, null, null, 240, null));
        com.tencent.qqnt.chats.core.mvi.a<com.tencent.qqnt.chats.core.uistate.b, com.tencent.qqnt.chats.core.userintent.b> aVar3 = this.mChatsVM;
        if (aVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mChatsVM");
            aVar3 = null;
        }
        u uVar2 = this.mChatsVB;
        if (uVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mChatsVB");
            uVar2 = null;
        }
        aVar3.d(uVar2);
        com.tencent.qqnt.chats.core.mvi.a<com.tencent.qqnt.chats.core.uistate.b, com.tencent.qqnt.chats.core.userintent.b> aVar4 = this.mChatsVM;
        if (aVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mChatsVM");
        } else {
            aVar2 = aVar4;
        }
        aVar2.o(b.c.f355083a);
    }

    public final void B9() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        com.tencent.qqnt.chats.core.mvi.a<com.tencent.qqnt.chats.core.uistate.b, com.tencent.qqnt.chats.core.userintent.b> aVar = null;
        if (A9()) {
            u uVar = this.mChatsVB;
            if (uVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mChatsVB");
                uVar = null;
            }
            uVar.A0(this.gameCardView);
        } else {
            u uVar2 = this.mChatsVB;
            if (uVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mChatsVB");
                uVar2 = null;
            }
            uVar2.A0(null);
        }
        com.tencent.qqnt.chats.core.mvi.a<com.tencent.qqnt.chats.core.uistate.b, com.tencent.qqnt.chats.core.userintent.b> aVar2 = this.mChatsVM;
        if (aVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mChatsVM");
        } else {
            aVar = aVar2;
        }
        aVar.o(a.C9592a.f355047a);
    }

    public final void E9(@Nullable View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) view);
            return;
        }
        this.gameCardView = view;
        u uVar = this.mChatsVB;
        com.tencent.qqnt.chats.core.mvi.a<com.tencent.qqnt.chats.core.uistate.b, com.tencent.qqnt.chats.core.userintent.b> aVar = null;
        if (uVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mChatsVB");
            uVar = null;
        }
        uVar.A0(this.gameCardView);
        com.tencent.qqnt.chats.core.mvi.a<com.tencent.qqnt.chats.core.uistate.b, com.tencent.qqnt.chats.core.userintent.b> aVar2 = this.mChatsVM;
        if (aVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mChatsVM");
        } else {
            aVar = aVar2;
        }
        aVar.o(a.C9592a.f355047a);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@NotNull View rootView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) rootView);
            return;
        }
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        z9();
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(@Nullable Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) activity);
            return;
        }
        super.onPartDestroy(activity);
        com.tencent.qqnt.chats.core.mvi.a<com.tencent.qqnt.chats.core.uistate.b, com.tencent.qqnt.chats.core.userintent.b> aVar = this.mChatsVM;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mChatsVM");
            aVar = null;
        }
        aVar.o(b.d.f355084a);
        com.tencent.qqnt.chats.core.mvi.a<com.tencent.qqnt.chats.core.uistate.b, com.tencent.qqnt.chats.core.userintent.b> aVar2 = this.mChatsVM;
        if (aVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mChatsVM");
            aVar2 = null;
        }
        u uVar = this.mChatsVB;
        if (uVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mChatsVB");
            uVar = null;
        }
        aVar2.m(uVar);
        u uVar2 = this.mChatsVB;
        if (uVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mChatsVB");
            uVar2 = null;
        }
        uVar2.e0();
        e.f185509a.b(null);
        C9();
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartPause(@Nullable Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) activity);
            return;
        }
        super.onPartPause(activity);
        com.tencent.qqnt.chats.core.mvi.a<com.tencent.qqnt.chats.core.uistate.b, com.tencent.qqnt.chats.core.userintent.b> aVar = this.mChatsVM;
        u uVar = null;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mChatsVM");
            aVar = null;
        }
        aVar.o(b.h.f355088a);
        u uVar2 = this.mChatsVB;
        if (uVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mChatsVB");
        } else {
            uVar = uVar2;
        }
        com.tencent.qqnt.chats.api.b v3 = uVar.v();
        if (v3 != null) {
            v3.u(this.mContentView);
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartResume(@Nullable Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) activity);
            return;
        }
        super.onPartResume(activity);
        com.tencent.qqnt.chats.core.mvi.a<com.tencent.qqnt.chats.core.uistate.b, com.tencent.qqnt.chats.core.userintent.b> aVar = this.mChatsVM;
        u uVar = null;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mChatsVM");
            aVar = null;
        }
        aVar.o(b.i.f355089a);
        u uVar2 = this.mChatsVB;
        if (uVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mChatsVB");
        } else {
            uVar = uVar2;
        }
        com.tencent.qqnt.chats.api.b v3 = uVar.v();
        if (v3 != null) {
            b.C9561b.a(v3, this.mContentView, null, null, null, 14, null);
        }
    }
}
