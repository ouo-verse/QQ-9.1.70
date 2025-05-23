package com.tencent.mobileqq.flock.publish;

import android.content.Intent;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.flock.publish.part.FlockPublishKeyboardPart;
import com.tencent.mobileqq.flock.publish.viewmodel.FlockPublishUIStateViewModel;
import com.tencent.mobileqq.flock.publish.viewmodel.b;
import com.tencent.mobileqq.flock.publish.viewmodel.f;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqmini.minigame.action.OperateCustomButton;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000/\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0004*\u0001\r\u001a\u0014\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0000\u001a\u0014\u0010\u0006\u001a\u00020\u0005*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0000\u001a\u0014\u0010\b\u001a\u00020\u0007*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0000\u001a\u000e\u0010\n\u001a\u0004\u0018\u00010\t*\u00020\u0000H\u0000\u001a\u0014\u0010\f\u001a\u00020\u000b*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0000\u001a\u0017\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0002\u001a\u00020\u0001H\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/biz/richframework/part/Part;", "Landroid/content/Intent;", "intent", "Lcom/tencent/mobileqq/flock/publish/viewmodel/FlockPublishUIStateViewModel;", "f", "Lcom/tencent/mobileqq/flock/publish/viewmodel/b;", "b", "Lcom/tencent/mobileqq/flock/publish/viewmodel/f;", "e", "Lcom/tencent/mobileqq/flock/publish/part/FlockPublishKeyboardPart;", "c", "Lcom/tencent/mobileqq/flock/repeat/b;", "d", "com/tencent/mobileqq/flock/publish/a$a", "a", "(Landroid/content/Intent;)Lcom/tencent/mobileqq/flock/publish/a$a;", "qq-flock-impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class a {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J'\u0010\u0006\u001a\u00028\u0000\"\b\b\u0000\u0010\u0003*\u00020\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0016\u00a2\u0006\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/flock/publish/a$a", "Landroidx/lifecycle/ViewModelProvider$Factory;", "Landroidx/lifecycle/ViewModel;", "T", "Ljava/lang/Class;", "modelClass", OperateCustomButton.OPERATE_CREATE, "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "qq-flock-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.flock.publish.a$a, reason: collision with other inner class name */
    /* loaded from: classes12.dex */
    public static final class C7609a implements ViewModelProvider.Factory {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Intent f210252a;

        C7609a(Intent intent) {
            this.f210252a = intent;
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
            T newInstance = modelClass.getConstructor(Intent.class).newInstance(this.f210252a);
            Intrinsics.checkNotNullExpressionValue(newInstance, "modelClass.getConstructo\u2026java).newInstance(intent)");
            return newInstance;
        }
    }

    private static final C7609a a(Intent intent) {
        return new C7609a(intent);
    }

    @NotNull
    public static final b b(@NotNull Part part, @NotNull Intent intent) {
        Intrinsics.checkNotNullParameter(part, "<this>");
        Intrinsics.checkNotNullParameter(intent, "intent");
        ViewModel viewModel = new ViewModelProvider(part.getPartHost(), a(intent)).get(b.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProvider(partHo\u2026eryViewModel::class.java)");
        return (b) viewModel;
    }

    @Nullable
    public static final FlockPublishKeyboardPart c(@NotNull Part part) {
        Intrinsics.checkNotNullParameter(part, "<this>");
        Part part2 = part.getPartManager().getPart(FlockPublishKeyboardPart.class.getName());
        if (part2 instanceof FlockPublishKeyboardPart) {
            return (FlockPublishKeyboardPart) part2;
        }
        return null;
    }

    @NotNull
    public static final com.tencent.mobileqq.flock.repeat.b d(@NotNull Part part, @NotNull Intent intent) {
        Intrinsics.checkNotNullParameter(part, "<this>");
        Intrinsics.checkNotNullParameter(intent, "intent");
        ViewModel viewModel = new ViewModelProvider(part.getPartHost(), a(intent)).get(com.tencent.mobileqq.flock.repeat.b.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProvider(partHo\u2026ectViewModel::class.java)");
        return (com.tencent.mobileqq.flock.repeat.b) viewModel;
    }

    @NotNull
    public static final f e(@NotNull Part part, @NotNull Intent intent) {
        Intrinsics.checkNotNullParameter(part, "<this>");
        Intrinsics.checkNotNullParameter(intent, "intent");
        ViewModel viewModel = new ViewModelProvider(part.getPartHost(), a(intent)).get(f.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProvider(partHo\u2026endViewModel::class.java)");
        return (f) viewModel;
    }

    @NotNull
    public static final FlockPublishUIStateViewModel f(@NotNull Part part, @NotNull Intent intent) {
        Intrinsics.checkNotNullParameter(part, "<this>");
        Intrinsics.checkNotNullParameter(intent, "intent");
        ViewModel viewModel = new ViewModelProvider(part.getPartHost(), a(intent)).get(FlockPublishUIStateViewModel.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProvider(partHo\u2026ateViewModel::class.java)");
        return (FlockPublishUIStateViewModel) viewModel;
    }
}
