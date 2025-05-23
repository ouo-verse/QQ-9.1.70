package com.tencent.mobileqq.aio.input.longshot;

import android.view.View;
import android.widget.TextView;
import com.tencent.biz.qui.quicheckbox.QUICheckBox;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n\u00a2\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Landroid/widget/TextView;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes10.dex */
public final class LongShotBarVB$mBtnMosaic$2 extends Lambda implements Function0<TextView> {
    static IPatchRedirector $redirector_;
    final /* synthetic */ LongShotBarVB this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LongShotBarVB$mBtnMosaic$2(LongShotBarVB longShotBarVB) {
        super(0);
        this.this$0 = longShotBarVB;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) longShotBarVB);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(LongShotBarVB this$0, View view) {
        QUICheckBox i16;
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        i16 = this$0.i1();
        i16.performClick();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    @NotNull
    public final TextView invoke() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (TextView) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        TextView textView = new TextView(this.this$0.getMContext());
        final LongShotBarVB longShotBarVB = this.this$0;
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.aio.input.longshot.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LongShotBarVB$mBtnMosaic$2.b(LongShotBarVB.this, view);
            }
        });
        return textView;
    }
}
