package com.tencent.mobileqq.troop.teamup.publish.part;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.troop.homework.common.widget.mediaedit.view.HWMediaEditView;
import com.tencent.mobileqq.troop.teamup.publish.part.TroopTeamUpPublishEditPart;
import com.tencent.mobileqq.troop.teamup.publish.view.TroopTeamUpPublishLayout;
import com.tencent.mobileqq.troop.teamup.publish.vm.TroopTeamUpPublishVM;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.listitem.Group;
import com.tencent.mobileqq.widget.listitem.QUIListItemAdapter;
import com.tencent.mobileqq.widget.listitem.QUISettingsRecyclerView;
import com.tencent.mobileqq.widget.listitem.w;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.miniapp.widget.CanvasView;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0001!B\u0007\u00a2\u0006\u0004\b\u001f\u0010 J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0012\u0010\n\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J\u0012\u0010\u000b\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J\u001c\u0010\u000f\u001a\u00020\u00062\b\u0010\f\u001a\u0004\u0018\u00010\u00022\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016R\u001b\u0010\u0015\u001a\u00020\u00108BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u001f\u0010\u001a\u001a\u00060\u0016R\u00020\u00008BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0017\u0010\u0012\u001a\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001e\u001a\u00020\u001b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001d\u00a8\u0006\""}, d2 = {"Lcom/tencent/mobileqq/troop/teamup/publish/part/TroopTeamUpPublishEditPart;", "Lcom/tencent/biz/richframework/part/Part;", "", "getLogTag", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "", "onInitView", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "onPartStart", "onPartDestroy", "action", "", "args", "handleBroadcastMessage", "Lcom/tencent/mobileqq/troop/teamup/publish/vm/TroopTeamUpPublishVM;", "d", "Lkotlin/Lazy;", "z9", "()Lcom/tencent/mobileqq/troop/teamup/publish/vm/TroopTeamUpPublishVM;", "data", "Lcom/tencent/mobileqq/troop/teamup/publish/part/TroopTeamUpPublishEditPart$MediaConfig;", "e", "A9", "()Lcom/tencent/mobileqq/troop/teamup/publish/part/TroopTeamUpPublishEditPart$MediaConfig;", "mediaConfig", "", "f", "Z", "isFirstStart", "<init>", "()V", "MediaConfig", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class TroopTeamUpPublishEditPart extends Part {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy data;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy mediaConfig;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private boolean isFirstStart;

    /* JADX INFO: Access modifiers changed from: private */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0082\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0014J&\u0010\r\u001a\u00020\f2\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00072\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0014R\u001b\u0010\u0013\u001a\u00020\u000e8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/troop/teamup/publish/part/TroopTeamUpPublishEditPart$MediaConfig;", "Lcom/tencent/mobileqq/widget/listitem/w;", "Lcom/tencent/mobileqq/troop/homework/common/widget/mediaedit/view/HWMediaEditView;", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "L", "view", "", "position", "", "", "payloads", "", "K", "Lcom/tencent/mobileqq/troop/teamup/publish/part/e;", "k", "Lkotlin/Lazy;", "J", "()Lcom/tencent/mobileqq/troop/teamup/publish/part/e;", "mediaManager", "<init>", "(Lcom/tencent/mobileqq/troop/teamup/publish/part/TroopTeamUpPublishEditPart;)V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes19.dex */
    public final class MediaConfig extends w<HWMediaEditView> {
        static IPatchRedirector $redirector_;

        /* renamed from: k, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final Lazy mediaManager;

        public MediaConfig() {
            Lazy lazy;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                lazy = LazyKt__LazyJVMKt.lazy(new Function0<e>() { // from class: com.tencent.mobileqq.troop.teamup.publish.part.TroopTeamUpPublishEditPart$MediaConfig$mediaManager$2
                    static IPatchRedirector $redirector_;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(0);
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, (Object) this, (Object) TroopTeamUpPublishEditPart.this);
                        }
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    @NotNull
                    public final e invoke() {
                        TroopTeamUpPublishVM z95;
                        TroopTeamUpPublishVM z96;
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                            return (e) iPatchRedirector2.redirect((short) 2, (Object) this);
                        }
                        z95 = TroopTeamUpPublishEditPart.this.z9();
                        String R1 = z95.R1();
                        LifecycleCoroutineScope b16 = com.tencent.mobileqq.troop.homework.common.b.b(TroopTeamUpPublishEditPart.this);
                        z96 = TroopTeamUpPublishEditPart.this.z9();
                        com.tencent.mobileqq.troop.teamup.publish.vm.a P1 = z96.P1();
                        TroopTeamUpPublishEditPart troopTeamUpPublishEditPart = TroopTeamUpPublishEditPart.this;
                        P1.r().setHintText(troopTeamUpPublishEditPart.getContext().getString(R.string.f236387e8));
                        P1.k().setHintText(troopTeamUpPublishEditPart.getContext().getString(R.string.f236377e7));
                        P1.k().setContentMinHeight(ViewUtils.dip2px(220.0f));
                        P1.k().setShowInputMethodOnce(true);
                        Unit unit = Unit.INSTANCE;
                        return new e(R1, b16, P1);
                    }
                });
                this.mediaManager = lazy;
            } else {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopTeamUpPublishEditPart.this);
            }
        }

        @NotNull
        public final e J() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (e) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return (e) this.mediaManager.getValue();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.widget.listitem.w
        /* renamed from: K, reason: merged with bridge method [inline-methods] */
        public void F(@NotNull HWMediaEditView view, int position, @NotNull List<? extends Object> payloads) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, this, view, Integer.valueOf(position), payloads);
                return;
            }
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(payloads, "payloads");
            J().Q();
            e J = J();
            LifecycleOwner a16 = com.tencent.mobileqq.troop.troopsetting.part.i.a(TroopTeamUpPublishEditPart.this);
            Intrinsics.checkNotNull(a16);
            view.setMediaEditManager(J, a16);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.widget.listitem.w
        @NotNull
        /* renamed from: L, reason: merged with bridge method [inline-methods] */
        public HWMediaEditView H(@NotNull ViewGroup parent) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (HWMediaEditView) iPatchRedirector.redirect((short) 3, (Object) this, (Object) parent);
            }
            Intrinsics.checkNotNullParameter(parent, "parent");
            Context context = parent.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "parent.context");
            HWMediaEditView hWMediaEditView = new HWMediaEditView(context, null, 2, null);
            hWMediaEditView.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
            return hWMediaEditView;
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016R\u0017\u0010\t\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/troop/teamup/publish/part/TroopTeamUpPublishEditPart$a", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "", "onGlobalLayout", "Landroid/graphics/Rect;", "d", "Landroid/graphics/Rect;", "getRect", "()Landroid/graphics/Rect;", CanvasView.ACTION_RECT, "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes19.dex */
    public static final class a implements ViewTreeObserver.OnGlobalLayoutListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final Rect rect;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ View f299125e;

        a(View view) {
            this.f299125e = view;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) view);
            } else {
                this.rect = new Rect();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void b(View rootView) {
            int i3;
            Intrinsics.checkNotNullParameter(rootView, "$rootView");
            TroopTeamUpPublishLayout troopTeamUpPublishLayout = (TroopTeamUpPublishLayout) rootView;
            QUIListItemAdapter adapter = troopTeamUpPublishLayout.e().getAdapter();
            if (adapter != null) {
                i3 = adapter.getNUM_BACKGOURND_ICON();
            } else {
                i3 = 0;
            }
            int i16 = i3 - 1;
            if (i16 >= 0) {
                troopTeamUpPublishLayout.e().scrollToPosition(i16);
            }
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this);
                return;
            }
            this.f299125e.getWindowVisibleDisplayFrame(this.rect);
            if (r0 - this.rect.bottom >= ((TroopTeamUpPublishLayout) this.f299125e).getHeight() * 0.15d) {
                QUISettingsRecyclerView e16 = ((TroopTeamUpPublishLayout) this.f299125e).e();
                final View view = this.f299125e;
                e16.post(new Runnable() { // from class: com.tencent.mobileqq.troop.teamup.publish.part.b
                    @Override // java.lang.Runnable
                    public final void run() {
                        TroopTeamUpPublishEditPart.a.b(view);
                    }
                });
                ((TroopTeamUpPublishLayout) this.f299125e).getViewTreeObserver().removeOnGlobalLayoutListener(this);
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\b*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016R\u0018\u0010\u0006\u001a\u0004\u0018\u00018\u00008\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0004\u0010\u0005R\u0014\u0010\t\u001a\u00028\u00008VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0007\u0010\b\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/troop/teamup/publish/part/TroopTeamUpPublishEditPart$b", "Lkotlin/Lazy;", "", "isInitialized", "d", "Landroidx/lifecycle/ViewModel;", "cached", "a", "()Landroidx/lifecycle/ViewModel;", "value", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes19.dex */
    public static final class b implements Lazy<TroopTeamUpPublishVM> {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private TroopTeamUpPublishVM cached;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ Part f299127e;

        public b(Part part) {
            this.f299127e = part;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) part);
            }
        }

        /* JADX WARN: Type inference failed for: r0v4, types: [androidx.lifecycle.ViewModel, java.lang.Object, com.tencent.mobileqq.troop.teamup.publish.vm.TroopTeamUpPublishVM] */
        /* JADX WARN: Type inference failed for: r0v6, types: [androidx.lifecycle.ViewModel, com.tencent.mobileqq.troop.teamup.publish.vm.TroopTeamUpPublishVM] */
        @Override // kotlin.Lazy
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public TroopTeamUpPublishVM getValue() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (ViewModel) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            TroopTeamUpPublishVM troopTeamUpPublishVM = this.cached;
            Object partHost = this.f299127e.getPartHost();
            Intrinsics.checkNotNull(partHost, "null cannot be cast to non-null type androidx.fragment.app.Fragment");
            Fragment fragment = (Fragment) partHost;
            if (troopTeamUpPublishVM == null) {
                ViewModelProvider.Factory a16 = com.tencent.mobileqq.troop.homework.common.b.a(fragment);
                ViewModelStore viewModelStore = fragment.get_viewModelStore();
                Intrinsics.checkNotNullExpressionValue(viewModelStore, "fragment.viewModelStore");
                ?? r06 = new ViewModelProvider(viewModelStore, a16).get(TroopTeamUpPublishVM.class);
                this.cached = r06;
                Intrinsics.checkNotNullExpressionValue(r06, "{\n                val fa\u2026          }\n            }");
                return r06;
            }
            return troopTeamUpPublishVM;
        }

        @Override // kotlin.Lazy
        public boolean isInitialized() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
            }
            if (this.cached != null) {
                return true;
            }
            return false;
        }
    }

    public TroopTeamUpPublishEditPart() {
        Lazy lazy;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.data = new b(this);
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<MediaConfig>() { // from class: com.tencent.mobileqq.troop.teamup.publish.part.TroopTeamUpPublishEditPart$mediaConfig$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) TroopTeamUpPublishEditPart.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final TroopTeamUpPublishEditPart.MediaConfig invoke() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                return (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) ? new TroopTeamUpPublishEditPart.MediaConfig() : (TroopTeamUpPublishEditPart.MediaConfig) iPatchRedirector2.redirect((short) 2, (Object) this);
            }
        });
        this.mediaConfig = lazy;
        this.isFirstStart = true;
    }

    private final MediaConfig A9() {
        return (MediaConfig) this.mediaConfig.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final TroopTeamUpPublishVM z9() {
        return (TroopTeamUpPublishVM) this.data.getValue();
    }

    @Override // com.tencent.biz.richframework.part.Part
    @NotNull
    /* renamed from: getLogTag */
    public String getTAG() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return "TroopTeamUp.PublishPublishEditPart";
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void handleBroadcastMessage(@Nullable String action, @Nullable Object args) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) action, args);
            return;
        }
        if (Intrinsics.areEqual(action, "select_media_finish")) {
            Intrinsics.checkNotNull(args, "null cannot be cast to non-null type com.tencent.mobileqq.troop.homework.common.widget.mediaedit.part.SelectMediaResult");
            A9().J().r(((com.tencent.mobileqq.troop.homework.common.widget.mediaedit.part.i) args).a());
        } else if (Intrinsics.areEqual(action, "select_capture_finish")) {
            Intrinsics.checkNotNull(args, "null cannot be cast to non-null type com.tencent.mobileqq.troop.homework.common.widget.mediaedit.part.CaptureMediaResult");
            A9().J().a((com.tencent.mobileqq.troop.homework.common.widget.mediaedit.part.b) args);
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@NotNull View rootView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) rootView);
            return;
        }
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        if (rootView instanceof TroopTeamUpPublishLayout) {
            ((TroopTeamUpPublishLayout) rootView).getViewTreeObserver().addOnGlobalLayoutListener(new a(rootView));
        } else {
            QLog.e("TroopTeamUp.PublishPublishEditPart", 1, "TroopTeamUpPublishEditPart: rootView is not TroopTeamUpPublishLayout");
        }
        MutableLiveData<List<Group>> S1 = z9().S1();
        List<Group> value = S1.getValue();
        if (value != null) {
            value.add(new Group(A9()));
        } else {
            value = null;
        }
        S1.postValue(value);
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(@Nullable Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) activity);
            return;
        }
        super.onPartDestroy(activity);
        this.isFirstStart = true;
        A9().J().G();
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartStart(@Nullable Activity activity) {
        View currentFocus;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) activity);
            return;
        }
        super.onPartStart(activity);
        if (this.isFirstStart) {
            this.isFirstStart = false;
        } else if (activity != null && (currentFocus = activity.getCurrentFocus()) != null) {
            currentFocus.clearFocus();
        }
    }
}
