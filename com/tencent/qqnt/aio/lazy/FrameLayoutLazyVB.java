package com.tencent.qqnt.aio.lazy;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewStub;
import androidx.exifinterface.media.ExifInterface;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mvi.base.mvi.MviUIState;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ol3.b;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\b&\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u0001*\b\b\u0001\u0010\u0004*\u00020\u00032\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0005B\u0007\u00a2\u0006\u0004\b\u001f\u0010 J\u000e\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006J\b\u0010\u000b\u001a\u00020\nH$J\u0010\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\fH\u0004J\b\u0010\u0010\u001a\u00020\u000eH\u0004J\b\u0010\u0011\u001a\u0004\u0018\u00010\fR\u0016\u0010\u0015\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0019\u001a\u00020\u00168\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u001b\u0010\u001e\u001a\u00020\b8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\u00a8\u0006!"}, d2 = {"Lcom/tencent/qqnt/aio/lazy/FrameLayoutLazyVB;", "Lol3/b;", "I", "Lcom/tencent/mvi/base/mvi/MviUIState;", ExifInterface.LATITUDE_SOUTH, "Lcom/tencent/aio/base/mvvm/a;", "Lcom/tencent/mvi/api/help/a;", "createViewParams", "Landroid/view/ViewStub;", "g1", "Landroid/view/ViewGroup$LayoutParams;", "e1", "Landroid/view/View;", "content", "", "i1", "h1", "d1", "", "d", "Z", "layoutInflated", "Landroid/view/ViewGroup;", "e", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "f", "Lkotlin/Lazy;", "f1", "()Landroid/view/ViewStub;", "viewStub", "<init>", "()V", "aio_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public abstract class FrameLayoutLazyVB<I extends ol3.b, S extends MviUIState> extends com.tencent.aio.base.mvvm.a<I, S> {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private boolean layoutInflated;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private ViewGroup container;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy viewStub;

    public FrameLayoutLazyVB() {
        Lazy lazy;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            lazy = LazyKt__LazyJVMKt.lazy(new FrameLayoutLazyVB$viewStub$2(this));
            this.viewStub = lazy;
        } else {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final ViewStub f1() {
        return (ViewStub) this.viewStub.getValue();
    }

    @Nullable
    public final View d1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (View) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        if (!this.layoutInflated) {
            return null;
        }
        ViewGroup viewGroup = this.container;
        if (viewGroup == null) {
            Intrinsics.throwUninitializedPropertyAccessException(ParseCommon.CONTAINER);
            return null;
        }
        return viewGroup;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public abstract ViewGroup.LayoutParams e1();

    @Override // com.tencent.mvi.mvvm.b
    @NotNull
    /* renamed from: g1, reason: merged with bridge method [inline-methods] */
    public final ViewStub onCreateView(@NotNull com.tencent.mvi.api.help.a createViewParams) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (ViewStub) iPatchRedirector.redirect((short) 2, (Object) this, (Object) createViewParams);
        }
        Intrinsics.checkNotNullParameter(createViewParams, "createViewParams");
        return f1();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void h1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        if (!this.layoutInflated) {
            return;
        }
        ViewGroup viewGroup = this.container;
        if (viewGroup == null) {
            Intrinsics.throwUninitializedPropertyAccessException(ParseCommon.CONTAINER);
            viewGroup = null;
        }
        viewGroup.removeAllViews();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void i1(@NotNull View content) {
        ViewGroup viewGroup;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) content);
            return;
        }
        Intrinsics.checkNotNullParameter(content, "content");
        if (!this.layoutInflated) {
            f1().inflate();
        }
        ViewParent parent = content.getParent();
        ViewGroup viewGroup2 = null;
        if (parent instanceof ViewGroup) {
            viewGroup = (ViewGroup) parent;
        } else {
            viewGroup = null;
        }
        if (viewGroup != null) {
            viewGroup.removeView(content);
        }
        ViewGroup viewGroup3 = this.container;
        if (viewGroup3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(ParseCommon.CONTAINER);
            viewGroup3 = null;
        }
        viewGroup3.removeAllViews();
        ViewGroup viewGroup4 = this.container;
        if (viewGroup4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(ParseCommon.CONTAINER);
        } else {
            viewGroup2 = viewGroup4;
        }
        viewGroup2.addView(content);
    }
}
