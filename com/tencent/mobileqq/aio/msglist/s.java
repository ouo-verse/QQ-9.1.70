package com.tencent.mobileqq.aio.msglist;

import android.view.View;
import com.tencent.aio.base.mvi.part.MsgListUiState;
import com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vm.MsgListVMWrapper;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.mobileqq.aio.background.FullBackgroundMviIntent;
import com.tencent.mobileqq.aio.event.AIOMsgListEvent;
import com.tencent.mobileqq.aio.msglist.uistate.AIOMsgListViewState;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.mvi.base.route.a;
import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000Q\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0001\u0018\b\u0007\u0018\u0000 $2\u00020\u0001:\u0001%B#\u0012\u0012\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u001e0\u001c\u0012\u0006\u0010!\u001a\u00020 \u00a2\u0006\u0004\b\"\u0010#J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH\u0002J\b\u0010\f\u001a\u00020\u0004H\u0002J\b\u0010\r\u001a\u00020\u0004H\u0016J\b\u0010\u000e\u001a\u00020\u0004H\u0016R\u001a\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\t0\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0010R\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u0013R\u0016\u0010\u0017\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0014\u0010\u001b\u001a\u00020\u00188\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001a\u00a8\u0006&"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/s;", "Lcom/tencent/mobileqq/aio/msglist/childvm/c;", "Lcom/tencent/mvi/base/route/MsgIntent;", "intent", "", tl.h.F, "Landroid/view/View;", "view", "j", "", "height", "i", "k", "e", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "", "Ljava/util/List;", "mViewTypeList", "Lcom/tencent/qqnt/aio/api/b;", "Lcom/tencent/qqnt/aio/api/b;", "mListBackground", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "I", "mInputHeight", "com/tencent/mobileqq/aio/msglist/s$b", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/aio/msglist/s$b;", "mAction", "Lcom/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/vm/MsgListVMWrapper;", "Lat/b;", "Lcom/tencent/aio/base/mvi/part/MsgListUiState;", "mParentVm", "Lcom/tencent/aio/api/runtime/a;", "mAioContext", "<init>", "(Lcom/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/vm/MsgListVMWrapper;Lcom/tencent/aio/api/runtime/a;)V", "D", "a", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class s extends com.tencent.mobileqq.aio.msglist.childvm.c {
    static IPatchRedirector $redirector_;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final b mAction;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<Integer> mViewTypeList;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private com.tencent.qqnt.aio.api.b mListBackground;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private int mInputHeight;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/s$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.aio.msglist.s$a, reason: from kotlin metadata */
    /* loaded from: classes11.dex */
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
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/aio/msglist/s$b", "Lcom/tencent/mvi/base/route/a;", "Lcom/tencent/mvi/base/route/MsgIntent;", "i", "", "call", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes11.dex */
    public static final class b implements com.tencent.mvi.base.route.a {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) s.this);
            }
        }

        @Override // com.tencent.mvi.base.route.a
        public void call(@NotNull MsgIntent i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) i3);
            } else {
                Intrinsics.checkNotNullParameter(i3, "i");
                s.this.h(i3);
            }
        }

        @Override // com.tencent.mvi.base.route.a
        public boolean sticky() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
            }
            return a.C9235a.a(this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(58129);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public s(@NotNull MsgListVMWrapper<at.b, MsgListUiState> mParentVm, @NotNull com.tencent.aio.api.runtime.a mAioContext) {
        super(mAioContext, mParentVm);
        List<Integer> listOf;
        Intrinsics.checkNotNullParameter(mParentVm, "mParentVm");
        Intrinsics.checkNotNullParameter(mAioContext, "mAioContext");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            listOf = CollectionsKt__CollectionsJVMKt.listOf(2);
            this.mViewTypeList = listOf;
            this.mAction = new b();
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this, (Object) mParentVm, (Object) mAioContext);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final void h(MsgIntent intent) {
        if (com.tencent.mobileqq.aio.a.d((com.tencent.aio.api.runtime.a) d().getMContext())) {
            QLog.i("BackgroundListVM", 1, "[handleAction]: isScaleChat return");
            return;
        }
        if (intent instanceof FullBackgroundMviIntent.UpdateAIOBackground) {
            j(((FullBackgroundMviIntent.UpdateAIOBackground) intent).b());
            return;
        }
        if (intent instanceof AIOMsgListEvent.InputLayoutChange) {
            AIOMsgListEvent.InputLayoutChange inputLayoutChange = (AIOMsgListEvent.InputLayoutChange) intent;
            i(inputLayoutChange.a() - inputLayoutChange.d());
        } else if (intent instanceof FullBackgroundMviIntent.NotifyBackgroundChange) {
            k();
        }
    }

    private final void i(int height) {
        if (this.mInputHeight != height) {
            this.mInputHeight = height;
            com.tencent.qqnt.aio.api.b bVar = this.mListBackground;
            if (bVar != null) {
                bVar.notifyInputHeightChange(height);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void j(View view) {
        if (!(view instanceof com.tencent.qqnt.aio.api.b)) {
            QLog.i("BackgroundListVM", 1, "[handleUpdateAIOBackground]: view is not instance of IAIOBackgroudnView");
            return;
        }
        com.tencent.qqnt.aio.api.b bVar = (com.tencent.qqnt.aio.api.b) view;
        int type = bVar.type();
        if (this.mViewTypeList.contains(Integer.valueOf(type))) {
            QLog.i("BackgroundListVM", 1, "[handleUpdateAIOBackground]: update fullbackgroundView, current viewType is " + type + ", inputHeight is " + this.mInputHeight);
            this.mListBackground = bVar;
            bVar.notifyInputHeightChange(this.mInputHeight);
            f(new AIOMsgListViewState.AddAIOBackgroundView(view));
            return;
        }
        QLog.i("BackgroundListVM", 1, "[handleUpdateAIOBackground]: remove fullbackgroundView, current viewType is " + type);
        this.mListBackground = null;
        f(AIOMsgListViewState.RemoveAIOBackgroundView.f192731d);
    }

    private final void k() {
        QLog.i("BackgroundListVM", 1, "[notifyBackgroundChange]");
        com.tencent.qqnt.aio.api.b bVar = this.mListBackground;
        if (bVar != null) {
            bVar.notifyBackgourndUpdate();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mobileqq.aio.msglist.childvm.c
    public void e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        } else {
            ((com.tencent.aio.api.runtime.a) d().getMContext()).e().f(this, this.mAction);
        }
    }

    @Override // com.tencent.mobileqq.aio.msglist.childvm.c, com.tencent.mvi.base.route.g
    public Set<String> getSubscribeEventNames() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (Set) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        HashSet hashSet = new HashSet();
        hashSet.add("com.tencent.mobileqq.aio.background.FullBackgroundMviIntent.UpdateAIOBackground");
        hashSet.add("com.tencent.mobileqq.aio.event.AIOMsgListEvent.InputLayoutChange");
        hashSet.add("com.tencent.mobileqq.aio.background.FullBackgroundMviIntent.NotifyBackgroundChange");
        return hashSet;
    }

    @Override // com.tencent.mobileqq.aio.msglist.childvm.c, com.tencent.mvi.base.route.g
    public Set<String> getSubscribeEventRNames() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (Set) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return new HashSet();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mobileqq.aio.msglist.childvm.c
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        ((com.tencent.aio.api.runtime.a) d().getMContext()).e().i(this, this.mAction);
        this.mListBackground = null;
        this.mInputHeight = 0;
    }
}
