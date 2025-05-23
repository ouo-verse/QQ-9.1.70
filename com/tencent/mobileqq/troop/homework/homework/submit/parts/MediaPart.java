package com.tencent.mobileqq.troop.homework.homework.submit.parts;

import android.animation.ValueAnimator;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import androidx.core.widget.NestedScrollView;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.troop.homework.common.widget.mediaedit.manager.PublishMediaEditManager;
import com.tencent.mobileqq.troop.homework.common.widget.mediaedit.model.AudioItem;
import com.tencent.mobileqq.troop.homework.common.widget.mediaedit.model.BaseItem;
import com.tencent.mobileqq.troop.homework.common.widget.mediaedit.view.HWMediaEditView;
import com.tencent.mobileqq.troop.homework.homework.submit.media.SubmitHomeworkMediaManager;
import com.tencent.mobileqq.troop.homework.homework.submit.vm.SubmitHomeWorkVM;
import com.tencent.mobileqq.utils.ViewUtils;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 \u00172\u00020\u0001:\u0001\u0018B\u0007\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0012\u0010\t\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J\u0012\u0010\n\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016R\u0016\u0010\u000e\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u001b\u0010\u0014\u001a\u00020\u000f8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/mobileqq/troop/homework/homework/submit/parts/MediaPart;", "Lcom/tencent/mobileqq/troop/homework/common/widget/mediaedit/part/d;", "Landroidx/core/widget/NestedScrollView;", "scrollView", "", "H9", "J9", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "z9", "onInitView", "", "f", "I", "lastAudioItemCount", "Lcom/tencent/mobileqq/troop/homework/homework/submit/vm/SubmitHomeWorkVM;", tl.h.F, "Lkotlin/Lazy;", "G9", "()Lcom/tencent/mobileqq/troop/homework/homework/submit/vm/SubmitHomeWorkVM;", "viewModel", "<init>", "()V", "i", "a", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class MediaPart extends com.tencent.mobileqq.troop.homework.common.widget.mediaedit.part.d {
    static IPatchRedirector $redirector_;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private int lastAudioItemCount;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy viewModel;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/troop/homework/homework/submit/parts/MediaPart$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.troop.homework.homework.submit.parts.MediaPart$a, reason: from kotlin metadata */
    /* loaded from: classes19.dex */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(51964);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public MediaPart() {
        Lazy lazy;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            lazy = LazyKt__LazyJVMKt.lazy(new Function0<SubmitHomeWorkVM>() { // from class: com.tencent.mobileqq.troop.homework.homework.submit.parts.MediaPart$viewModel$2
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) MediaPart.this);
                    }
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final SubmitHomeWorkVM invoke() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    return (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) ? (SubmitHomeWorkVM) new ViewModelProvider(MediaPart.this.getHostFragment()).get(SubmitHomeWorkVM.class) : (SubmitHomeWorkVM) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
            });
            this.viewModel = lazy;
        } else {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final void H9(final NestedScrollView scrollView) {
        LiveData<List<BaseItem>> p16 = G9().T1().p();
        LifecycleOwner lifecycleOwner = getPartHost().getLifecycleOwner();
        final Function1<List<? extends BaseItem>, Unit> function1 = new Function1<List<? extends BaseItem>, Unit>(scrollView) { // from class: com.tencent.mobileqq.troop.homework.homework.submit.parts.MediaPart$observeAudioItem$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ NestedScrollView $scrollView;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.$scrollView = scrollView;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) MediaPart.this, (Object) scrollView);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(List<? extends BaseItem> list) {
                invoke2(list);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(List<? extends BaseItem> baseItemList) {
                int i3;
                NestedScrollView nestedScrollView;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) baseItemList);
                    return;
                }
                Intrinsics.checkNotNullExpressionValue(baseItemList, "baseItemList");
                List<? extends BaseItem> list = baseItemList;
                int i16 = 0;
                if (!(list instanceof Collection) || !list.isEmpty()) {
                    Iterator<T> it = list.iterator();
                    while (it.hasNext()) {
                        if ((((BaseItem) it.next()) instanceof AudioItem) && (i16 = i16 + 1) < 0) {
                            CollectionsKt__CollectionsKt.throwCountOverflow();
                        }
                    }
                }
                i3 = MediaPart.this.lastAudioItemCount;
                if (i16 > i3 && (nestedScrollView = this.$scrollView) != null) {
                    MediaPart.this.J9(nestedScrollView);
                }
                MediaPart.this.lastAudioItemCount = i16;
            }
        };
        p16.observe(lifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.troop.homework.homework.submit.parts.a
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                MediaPart.I9(Function1.this, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void I9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void J9(final NestedScrollView scrollView) {
        if (scrollView.getChildCount() > 0) {
            ValueAnimator ofInt = ValueAnimator.ofInt(scrollView.getScrollY(), scrollView.getChildAt(0).getHeight());
            ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tencent.mobileqq.troop.homework.homework.submit.parts.b
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    MediaPart.K9(NestedScrollView.this, valueAnimator);
                }
            });
            ofInt.setInterpolator(new DecelerateInterpolator());
            ofInt.setDuration(500L);
            ofInt.start();
            return;
        }
        com.tencent.mobileqq.troop.teamup.home.common.a.f298968a.d("SubmitHWMediaPart", "smoothScrollToBottom: NestedScrollView has no child views.");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void K9(NestedScrollView scrollView, ValueAnimator valueAnimator) {
        Intrinsics.checkNotNullParameter(scrollView, "$scrollView");
        Object animatedValue = valueAnimator.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Int");
        scrollView.scrollTo(0, ((Integer) animatedValue).intValue());
    }

    @NotNull
    public final SubmitHomeWorkVM G9() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (SubmitHomeWorkVM) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return (SubmitHomeWorkVM) this.viewModel.getValue();
    }

    @Override // com.tencent.mobileqq.troop.homework.common.widget.mediaedit.part.d, com.tencent.biz.richframework.part.Part
    public void onInitView(@Nullable View rootView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) rootView);
            return;
        }
        super.onInitView(rootView);
        SubmitHomeworkMediaManager T1 = G9().T1();
        PublishMediaEditManager.S(T1, null, null, null, getContext().getString(R.string.f2342179c), Integer.valueOf(ViewUtils.dip2px(88.0f)), null, 39, null);
        T1.e0(G9().U1());
    }

    @Override // com.tencent.mobileqq.troop.homework.common.widget.mediaedit.part.d
    public void z9(@Nullable View rootView) {
        NestedScrollView nestedScrollView;
        HWMediaEditView hWMediaEditView;
        RecyclerView recyclerView;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) rootView);
            return;
        }
        com.tencent.mobileqq.troop.teamup.home.common.a.f298968a.a("SubmitHWMediaPart", "initMediaEditCtrl");
        qs2.b bVar = null;
        if (rootView != null) {
            nestedScrollView = (NestedScrollView) rootView.findViewById(R.id.xc8);
        } else {
            nestedScrollView = null;
        }
        if (rootView != null) {
            hWMediaEditView = (HWMediaEditView) rootView.findViewById(R.id.yzx);
        } else {
            hWMediaEditView = null;
        }
        A9(hWMediaEditView);
        com.tencent.mobileqq.troop.homework.common.widget.mediaedit.a x95 = x9();
        if (x95 != null) {
            x95.B(this, false);
        }
        com.tencent.mobileqq.troop.homework.common.widget.mediaedit.a x96 = x9();
        if (x96 != null) {
            SubmitHomeworkMediaManager T1 = G9().T1();
            LifecycleOwner lifecycleOwner = getPartHost().getLifecycleOwner();
            Intrinsics.checkNotNullExpressionValue(lifecycleOwner, "partHost.hostLifecycleOwner");
            x96.setMediaEditManager(T1, lifecycleOwner);
        }
        H9(nestedScrollView);
        if (rootView != null && (recyclerView = (RecyclerView) rootView.findViewById(R.id.z07)) != null) {
            recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
            com.tencent.mobileqq.troop.homework.common.widget.mediaedit.adapter.f fVar = new com.tencent.mobileqq.troop.homework.common.widget.mediaedit.adapter.f(false);
            com.tencent.mobileqq.troop.homework.common.widget.mediaedit.a x97 = x9();
            if (x97 instanceof qs2.b) {
                bVar = (qs2.b) x97;
            }
            if (bVar != null) {
                fVar.u0(bVar);
            }
            recyclerView.setAdapter(fVar);
        }
    }
}
