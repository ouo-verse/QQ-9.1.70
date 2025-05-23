package com.tencent.qqnt.aio.lazy;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import androidx.exifinterface.media.ExifInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0007\u001a\u00020\u0004\"\b\b\u0000\u0010\u0001*\u00020\u0000\"\b\b\u0001\u0010\u0003*\u00020\u0002H\n\u00a2\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lol3/b;", "I", "Lcom/tencent/mvi/base/mvi/MviUIState;", ExifInterface.LATITUDE_SOUTH, "Landroid/view/ViewStub;", "invoke", "()Landroid/view/ViewStub;", "<anonymous>"}, k = 3, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class FrameLayoutLazyVB$viewStub$2 extends Lambda implements Function0<ViewStub> {
    static IPatchRedirector $redirector_;
    final /* synthetic */ FrameLayoutLazyVB<I, S> this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FrameLayoutLazyVB$viewStub$2(FrameLayoutLazyVB<I, S> frameLayoutLazyVB) {
        super(0);
        this.this$0 = frameLayoutLazyVB;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) frameLayoutLazyVB);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(FrameLayoutLazyVB this$0, ViewStub viewStub, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.layoutInflated = true;
        Intrinsics.checkNotNull(view, "null cannot be cast to non-null type android.view.ViewGroup");
        this$0.com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon.CONTAINER java.lang.String = (ViewGroup) view;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    @NotNull
    public final ViewStub invoke() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (ViewStub) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        ViewStub viewStub = new ViewStub(this.this$0.getMContext());
        final FrameLayoutLazyVB<I, S> frameLayoutLazyVB = this.this$0;
        viewStub.setLayoutResource(R.layout.f169178i42);
        viewStub.setLayoutParams(frameLayoutLazyVB.e1());
        viewStub.setOnInflateListener(new ViewStub.OnInflateListener() { // from class: com.tencent.qqnt.aio.lazy.b
            @Override // android.view.ViewStub.OnInflateListener
            public final void onInflate(ViewStub viewStub2, View view) {
                FrameLayoutLazyVB$viewStub$2.b(FrameLayoutLazyVB.this, viewStub2, view);
            }
        });
        return viewStub;
    }
}
