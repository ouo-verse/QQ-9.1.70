package com.tencent.qqnt.chats.core.mvi;

import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.Observer;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqnt.base.mvi.a;
import com.tencent.qqnt.base.mvi.b;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\b&\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u0001*\b\b\u0001\u0010\u0004*\u00020\u00032\b\u0012\u0004\u0012\u00028\u00000\u0005B\u001b\u0012\u0012\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0014\u00a2\u0006\u0004\b!\u0010\u001bJ\u0006\u0010\u0007\u001a\u00020\u0006J\u0006\u0010\b\u001a\u00020\u0006J\u0015\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00028\u0001\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\r\u001a\u00020\u00062\u0006\u0010\f\u001a\u00028\u0000H&\u00a2\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u000fH&J\u0017\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00028\u0000H\u0016\u00a2\u0006\u0004\b\u0013\u0010\u000eJ\u001a\u0010\u0016\u001a\u00020\u00062\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0014R.\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00148\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0013\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u0018\u0010\u001f\u001a\u0004\u0018\u00010\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u0010\u001eR\u0018\u0010 \u001a\u0004\u0018\u00010\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u001e\u00a8\u0006\""}, d2 = {"Lcom/tencent/qqnt/chats/core/mvi/BaseFakeVB;", "Lcom/tencent/qqnt/base/mvi/a;", ExifInterface.LATITUDE_SOUTH, "Lcom/tencent/qqnt/base/mvi/b;", "I", "Landroidx/lifecycle/Observer;", "", "f", "g", "intent", "e", "(Lcom/tencent/qqnt/base/mvi/b;)V", "uiState", "c", "(Lcom/tencent/qqnt/base/mvi/a;)V", "Lcom/tencent/qqnt/chats/core/uievent/b;", "uiEvent", "b", "t", "d", "Lcom/tencent/qqnt/chats/core/mvi/a;", "viewModel", h.F, "Lcom/tencent/qqnt/chats/core/mvi/a;", "a", "()Lcom/tencent/qqnt/chats/core/mvi/a;", "setMViewModel", "(Lcom/tencent/qqnt/chats/core/mvi/a;)V", "mViewModel", "Lkotlinx/coroutines/Job;", "Lkotlinx/coroutines/Job;", "eventJob", "stateJob", "<init>", "chats_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public abstract class BaseFakeVB<S extends com.tencent.qqnt.base.mvi.a, I extends b> implements Observer<S> {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private a<S, I> mViewModel;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Job eventJob;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Job stateJob;

    public BaseFakeVB(@NotNull a<S, I> mViewModel) {
        Intrinsics.checkNotNullParameter(mViewModel, "mViewModel");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) mViewModel);
        } else {
            this.mViewModel = mViewModel;
        }
    }

    @NotNull
    public final a<S, I> a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (a) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.mViewModel;
    }

    public abstract void b(@NotNull com.tencent.qqnt.chats.core.uievent.b uiEvent);

    public abstract void c(@NotNull S uiState);

    @Override // androidx.lifecycle.Observer
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public void onChanged(@NotNull S t16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) t16);
        } else {
            Intrinsics.checkNotNullParameter(t16, "t");
            c(t16);
        }
    }

    public final void e(@NotNull I intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) intent);
        } else {
            Intrinsics.checkNotNullParameter(intent, "intent");
            BuildersKt__Builders_commonKt.launch$default(this.mViewModel.h(), null, null, new BaseFakeVB$sendUserIntent$1$1(this, intent, null), 3, null);
        }
    }

    public final void f() {
        Job launch$default;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        a<S, I> aVar = this.mViewModel;
        launch$default = BuildersKt__Builders_commonKt.launch$default(aVar.h(), null, null, new BaseFakeVB$subscribe$1$1(aVar, this, null), 3, null);
        this.eventJob = launch$default;
        aVar.j().observeForever(this);
    }

    public final void g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        Job job = this.eventJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        this.mViewModel.j().removeObserver(this);
        Job job2 = this.stateJob;
        if (job2 != null) {
            Job.DefaultImpls.cancel$default(job2, (CancellationException) null, 1, (Object) null);
        }
    }

    public final void h(@NotNull a<S, I> viewModel) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) viewModel);
            return;
        }
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        g();
        this.mViewModel = viewModel;
        f();
    }
}
