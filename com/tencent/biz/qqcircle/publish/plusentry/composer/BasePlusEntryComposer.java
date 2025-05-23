package com.tencent.biz.qqcircle.publish.plusentry.composer;

import android.content.Context;
import android.view.View;
import androidx.annotation.CallSuper;
import androidx.lifecycle.Lifecycle;
import com.tencent.biz.qqcircle.immersive.viewmodel.wink.QFSPublishFeedViewModel;
import com.tencent.biz.richframework.part.interfaces.IPartHost;
import com.tencent.qphone.base.util.QLog;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import tl.h;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\b&\u0018\u0000 \u00072\u00020\u0001:\u0001\u0004B\u0017\u0012\u0006\u0010\t\u001a\u00020\u0005\u0012\u0006\u0010\u000e\u001a\u00020\n\u00a2\u0006\u0004\b\"\u0010#J\b\u0010\u0003\u001a\u00020\u0002H\u0017J\b\u0010\u0004\u001a\u00020\u0002H\u0017R\u001a\u0010\t\u001a\u00020\u00058\u0004X\u0084\u0004\u00a2\u0006\f\n\u0004\b\u0004\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u001a\u0010\u000e\u001a\u00020\n8\u0004X\u0084\u0004\u00a2\u0006\f\n\u0004\b\u0003\u0010\u000b\u001a\u0004\b\f\u0010\rR#\u0010\u0015\u001a\n \u0010*\u0004\u0018\u00010\u000f0\u000f8DX\u0084\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u001a\u0010\u001a\u001a\u00020\u00168\u0016X\u0096D\u00a2\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0017\u0010\u0019R\u001c\u0010\u001d\u001a\n \u0010*\u0004\u0018\u00010\u001b0\u001b8DX\u0084\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0011\u0010\u001cR\u0014\u0010!\u001a\u00020\u001e8DX\u0084\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001f\u0010 \u00a8\u0006$"}, d2 = {"Lcom/tencent/biz/qqcircle/publish/plusentry/composer/BasePlusEntryComposer;", "Lcom/tencent/biz/qqcircle/publish/plusentry/composer/a;", "", "b", "a", "Lcom/tencent/biz/richframework/part/interfaces/IPartHost;", "Lcom/tencent/biz/richframework/part/interfaces/IPartHost;", "e", "()Lcom/tencent/biz/richframework/part/interfaces/IPartHost;", "partHost", "Landroid/view/View;", "Landroid/view/View;", "f", "()Landroid/view/View;", "plusEntryLayout", "Lcom/tencent/biz/qqcircle/immersive/viewmodel/wink/QFSPublishFeedViewModel;", "kotlin.jvm.PlatformType", "c", "Lkotlin/Lazy;", "g", "()Lcom/tencent/biz/qqcircle/immersive/viewmodel/wink/QFSPublishFeedViewModel;", "viewModel", "", "d", "Ljava/lang/String;", "()Ljava/lang/String;", "logTag", "Landroid/content/Context;", "()Landroid/content/Context;", "context", "", h.F, "()Z", "isResumed", "<init>", "(Lcom/tencent/biz/richframework/part/interfaces/IPartHost;Landroid/view/View;)V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public abstract class BasePlusEntryComposer implements a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final IPartHost partHost;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final View plusEntryLayout;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy viewModel;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String logTag;

    public BasePlusEntryComposer(@NotNull IPartHost partHost, @NotNull View plusEntryLayout) {
        Lazy lazy;
        Intrinsics.checkNotNullParameter(partHost, "partHost");
        Intrinsics.checkNotNullParameter(plusEntryLayout, "plusEntryLayout");
        this.partHost = partHost;
        this.plusEntryLayout = plusEntryLayout;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<QFSPublishFeedViewModel>() { // from class: com.tencent.biz.qqcircle.publish.plusentry.composer.BasePlusEntryComposer$viewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final QFSPublishFeedViewModel invoke() {
                return (QFSPublishFeedViewModel) BasePlusEntryComposer.this.getPartHost().getViewModel(BasePlusEntryComposer.this.getPartHost(), null, QFSPublishFeedViewModel.class);
            }
        });
        this.viewModel = lazy;
        this.logTag = "PlusEntry-BasePlusEntryComposer";
    }

    @Override // com.tencent.biz.qqcircle.publish.plusentry.composer.a
    @CallSuper
    public void a() {
        QLog.d(d(), 1, "deInit, this:" + hashCode() + " ");
    }

    @Override // com.tencent.biz.qqcircle.publish.plusentry.composer.a
    @CallSuper
    public void b() {
        QLog.d(d(), 1, "startInit, this:" + hashCode() + " ");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final Context c() {
        return this.plusEntryLayout.getContext();
    }

    @NotNull
    public abstract String d();

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    /* renamed from: e, reason: from getter */
    public final IPartHost getPartHost() {
        return this.partHost;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    /* renamed from: f, reason: from getter */
    public final View getPlusEntryLayout() {
        return this.plusEntryLayout;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final QFSPublishFeedViewModel g() {
        return (QFSPublishFeedViewModel) this.viewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean h() {
        try {
            if (this.partHost.getLifecycleOwner().getLifecycle().getCurrentState() != Lifecycle.State.RESUMED) {
                return false;
            }
            return true;
        } catch (Exception unused) {
            return false;
        }
    }
}
