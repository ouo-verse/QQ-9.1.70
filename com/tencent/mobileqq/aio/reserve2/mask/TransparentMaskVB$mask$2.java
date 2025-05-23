package com.tencent.mobileqq.aio.reserve2.mask;

import android.view.View;
import android.widget.FrameLayout;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n\u00a2\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Landroid/widget/FrameLayout;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes11.dex */
final class TransparentMaskVB$mask$2 extends Lambda implements Function0<FrameLayout> {
    static IPatchRedirector $redirector_;
    final /* synthetic */ TransparentMaskVB this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TransparentMaskVB$mask$2(TransparentMaskVB transparentMaskVB) {
        super(0);
        this.this$0 = transparentMaskVB;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) transparentMaskVB);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        QLog.d("TransparentMaskVB", 1, "mask resolve click");
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    @NotNull
    public final FrameLayout invoke() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (FrameLayout) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        FrameLayout frameLayout = new FrameLayout(this.this$0.getMContext());
        frameLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        frameLayout.setVisibility(8);
        frameLayout.setBackgroundColor(0);
        frameLayout.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.aio.reserve2.mask.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TransparentMaskVB$mask$2.b(view);
            }
        });
        return frameLayout;
    }
}
