package com.tencent.qqnt.aio.lazy;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import androidx.exifinterface.media.ExifInterface;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mvi.base.mvi.MviUIState;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import ol3.b;
import org.jetbrains.annotations.NotNull;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0016\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u0001*\b\b\u0001\u0010\u0004*\u00020\u00032\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0005B\u000f\u0012\u0006\u0010\u0015\u001a\u00020\u0010\u00a2\u0006\u0004\b#\u0010$J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nH\u0004J\u0010\u0010\u000f\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\nH\u0004R\u0017\u0010\u0015\u001a\u00020\u00108\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0019\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001d\u001a\u00020\u001a8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u001b\u0010\"\u001a\u00020\b8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!\u00a8\u0006%"}, d2 = {"Lcom/tencent/qqnt/aio/lazy/AIOLazyVB;", "Lol3/b;", "I", "Lcom/tencent/mvi/base/mvi/MviUIState;", ExifInterface.LATITUDE_SOUTH, "Lcom/tencent/aio/base/mvvm/a;", "Lcom/tencent/mvi/api/help/a;", "createViewParams", "Landroid/view/ViewStub;", "e1", "Landroid/view/View;", "content", "", "h1", "view", "g1", "Lcom/tencent/qqnt/aio/lazy/c;", "d", "Lcom/tencent/qqnt/aio/lazy/c;", "c1", "()Lcom/tencent/qqnt/aio/lazy/c;", "fetcher", "", "e", "Z", "layoutInflated", "Landroid/view/ViewGroup;", "f", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, h.F, "Lkotlin/Lazy;", "d1", "()Landroid/view/ViewStub;", "viewStub", "<init>", "(Lcom/tencent/qqnt/aio/lazy/c;)V", "aio_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public class AIOLazyVB<I extends ol3.b, S extends MviUIState> extends com.tencent.aio.base.mvvm.a<I, S> {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final c fetcher;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private boolean layoutInflated;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private ViewGroup container;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy viewStub;

    public AIOLazyVB(@NotNull c fetcher) {
        Lazy lazy;
        Intrinsics.checkNotNullParameter(fetcher, "fetcher");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) fetcher);
            return;
        }
        this.fetcher = fetcher;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<ViewStub>(this) { // from class: com.tencent.qqnt.aio.lazy.AIOLazyVB$viewStub$2
            static IPatchRedirector $redirector_;
            final /* synthetic */ AIOLazyVB<I, S> this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.this$0 = this;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final ViewStub invoke() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                return (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) ? this.this$0.c1().a() : (ViewStub) iPatchRedirector2.redirect((short) 2, (Object) this);
            }
        });
        this.viewStub = lazy;
    }

    private final ViewStub d1() {
        return (ViewStub) this.viewStub.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f1(AIOLazyVB this$0, ViewStub viewStub, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.layoutInflated = true;
        Intrinsics.checkNotNull(view, "null cannot be cast to non-null type android.view.ViewGroup");
        this$0.container = (ViewGroup) view;
    }

    @NotNull
    public final c c1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (c) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.fetcher;
    }

    @Override // com.tencent.mvi.mvvm.b
    @NotNull
    /* renamed from: e1, reason: merged with bridge method [inline-methods] */
    public ViewStub onCreateView(@NotNull com.tencent.mvi.api.help.a createViewParams) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (ViewStub) iPatchRedirector.redirect((short) 3, (Object) this, (Object) createViewParams);
        }
        Intrinsics.checkNotNullParameter(createViewParams, "createViewParams");
        ViewStub d16 = d1();
        d16.setOnInflateListener(new ViewStub.OnInflateListener() { // from class: com.tencent.qqnt.aio.lazy.a
            @Override // android.view.ViewStub.OnInflateListener
            public final void onInflate(ViewStub viewStub, View view) {
                AIOLazyVB.f1(AIOLazyVB.this, viewStub, view);
            }
        });
        return d16;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void g1(@NotNull View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) view);
            return;
        }
        Intrinsics.checkNotNullParameter(view, "view");
        if (!this.layoutInflated) {
            return;
        }
        ViewGroup viewGroup = this.container;
        if (viewGroup == null) {
            Intrinsics.throwUninitializedPropertyAccessException(ParseCommon.CONTAINER);
            viewGroup = null;
        }
        viewGroup.removeView(view);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void h1(@NotNull View content) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) content);
            return;
        }
        Intrinsics.checkNotNullParameter(content, "content");
        if (!this.layoutInflated) {
            d1().inflate();
        }
        ViewGroup viewGroup = this.container;
        if (viewGroup == null) {
            Intrinsics.throwUninitializedPropertyAccessException(ParseCommon.CONTAINER);
            viewGroup = null;
        }
        viewGroup.addView(content);
    }
}
