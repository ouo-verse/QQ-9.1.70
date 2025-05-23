package com.tencent.mobileqq.troop.homework.notice.detail;

import android.content.Intent;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.troop.homework.notice.detail.viewmodel.HWNoticeDetailViewModel;
import com.tencent.mobileqq.troop.homework.notice.detail.viewmodel.i;
import com.tencent.qqmini.minigame.action.OperateCustomButton;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000)\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0004*\u0001\u000b\u001a\u0014\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0000\u001a\u0014\u0010\u0006\u001a\u00020\u0005*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0000\u001a\u0014\u0010\b\u001a\u00020\u0007*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0000\u001a\f\u0010\n\u001a\u00020\u0003*\u00020\tH\u0000\u001a\u0017\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0002\u001a\u00020\u0001H\u0002\u00a2\u0006\u0004\b\f\u0010\r\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/biz/richframework/part/Part;", "Landroid/content/Intent;", "intent", "Lcom/tencent/mobileqq/troop/homework/notice/detail/viewmodel/HWNoticeDetailViewModel;", "c", "Lcom/tencent/mobileqq/troop/homework/notice/detail/viewmodel/i;", "e", "Lcom/tencent/mobileqq/troop/homework/notice/detail/viewmodel/a;", "a", "Lcom/tencent/mobileqq/troop/homework/notice/detail/HWNoticeDetailFragment;", "d", "com/tencent/mobileqq/troop/homework/notice/detail/g$a", "b", "(Landroid/content/Intent;)Lcom/tencent/mobileqq/troop/homework/notice/detail/g$a;", "qqtroop-impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class g {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J'\u0010\u0006\u001a\u00028\u0000\"\b\b\u0000\u0010\u0003*\u00020\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0016\u00a2\u0006\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/troop/homework/notice/detail/g$a", "Landroidx/lifecycle/ViewModelProvider$Factory;", "Landroidx/lifecycle/ViewModel;", "T", "Ljava/lang/Class;", "modelClass", OperateCustomButton.OPERATE_CREATE, "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes19.dex */
    public static final class a implements ViewModelProvider.Factory {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Intent f297193a;

        a(Intent intent) {
            this.f297193a = intent;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) intent);
            }
        }

        @Override // androidx.lifecycle.ViewModelProvider.Factory
        @NotNull
        public <T extends ViewModel> T create(@NotNull Class<T> modelClass) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (T) iPatchRedirector.redirect((short) 2, (Object) this, (Object) modelClass);
            }
            Intrinsics.checkNotNullParameter(modelClass, "modelClass");
            T newInstance = modelClass.getConstructor(Intent.class).newInstance(this.f297193a);
            Intrinsics.checkNotNullExpressionValue(newInstance, "modelClass.getConstructo\u2026java).newInstance(intent)");
            return newInstance;
        }
    }

    @NotNull
    public static final com.tencent.mobileqq.troop.homework.notice.detail.viewmodel.a a(@NotNull Part part, @NotNull Intent intent) {
        Intrinsics.checkNotNullParameter(part, "<this>");
        Intrinsics.checkNotNullParameter(intent, "intent");
        ViewModel viewModel = new ViewModelProvider(part.getPartHost(), b(intent)).get(com.tencent.mobileqq.troop.homework.notice.detail.viewmodel.a.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProvider(partHo\u2026irmViewModel::class.java)");
        return (com.tencent.mobileqq.troop.homework.notice.detail.viewmodel.a) viewModel;
    }

    private static final a b(Intent intent) {
        return new a(intent);
    }

    @NotNull
    public static final HWNoticeDetailViewModel c(@NotNull Part part, @NotNull Intent intent) {
        Intrinsics.checkNotNullParameter(part, "<this>");
        Intrinsics.checkNotNullParameter(intent, "intent");
        ViewModel viewModel = new ViewModelProvider(part.getPartHost(), b(intent)).get(HWNoticeDetailViewModel.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProvider(partHo\u2026ailViewModel::class.java)");
        return (HWNoticeDetailViewModel) viewModel;
    }

    @NotNull
    public static final HWNoticeDetailViewModel d(@NotNull HWNoticeDetailFragment hWNoticeDetailFragment) {
        Intent intent;
        Intrinsics.checkNotNullParameter(hWNoticeDetailFragment, "<this>");
        FragmentActivity activity = hWNoticeDetailFragment.getActivity();
        if (activity != null) {
            intent = activity.getIntent();
        } else {
            intent = null;
        }
        if (intent == null) {
            intent = new Intent();
        }
        ViewModel viewModel = new ViewModelProvider(hWNoticeDetailFragment, b(intent)).get(HWNoticeDetailViewModel.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProvider(\n     \u2026ailViewModel::class.java)");
        return (HWNoticeDetailViewModel) viewModel;
    }

    @NotNull
    public static final i e(@NotNull Part part, @NotNull Intent intent) {
        Intrinsics.checkNotNullParameter(part, "<this>");
        Intrinsics.checkNotNullParameter(intent, "intent");
        ViewModel viewModel = new ViewModelProvider(part.getPartHost(), b(intent)).get(i.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProvider(partHo\u2026indViewModel::class.java)");
        return (i) viewModel;
    }
}
