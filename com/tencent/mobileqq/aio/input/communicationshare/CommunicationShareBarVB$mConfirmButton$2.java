package com.tencent.mobileqq.aio.input.communicationshare;

import android.view.View;
import android.widget.LinearLayout;
import com.tencent.biz.qui.quibutton.QUIButton;
import com.tencent.mobileqq.aio.input.communicationshare.a;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.aio.widget.SelectTouchBarView;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n\u00a2\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/tencent/biz/qui/quibutton/QUIButton;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes10.dex */
public final class CommunicationShareBarVB$mConfirmButton$2 extends Lambda implements Function0<QUIButton> {
    static IPatchRedirector $redirector_;
    final /* synthetic */ CommunicationShareBarVB this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CommunicationShareBarVB$mConfirmButton$2(CommunicationShareBarVB communicationShareBarVB) {
        super(0);
        this.this$0 = communicationShareBarVB;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) communicationShareBarVB);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(CommunicationShareBarVB this$0, View view) {
        SelectTouchBarView j16;
        SelectTouchBarView j17;
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        HashMap hashMap = new HashMap();
        j16 = this$0.j1();
        hashMap.put("session_count", Integer.valueOf(j16.C));
        com.tencent.mobileqq.aio.utils.b.l("em_bas_dialog_image_confirm", hashMap);
        j17 = this$0.j1();
        if (j17.C != 0) {
            this$0.sendIntent(a.C7261a.f189360d);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    @NotNull
    public final QUIButton invoke() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (QUIButton) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        QUIButton qUIButton = new QUIButton(this.this$0.getMContext());
        final CommunicationShareBarVB communicationShareBarVB = this.this$0;
        qUIButton.setText("\u786e\u8ba4\u5206\u4eab");
        qUIButton.setTextSize(17.0f);
        qUIButton.setGravity(17);
        qUIButton.setLayoutParams(new LinearLayout.LayoutParams(ViewUtils.dip2px(343.0f), ViewUtils.dip2px(45.0f)));
        qUIButton.setEnabled(true);
        qUIButton.setPadding(ViewUtils.dip2px(16.5f), qUIButton.getPaddingTop(), qUIButton.getPaddingRight(), qUIButton.getPaddingBottom());
        qUIButton.setPadding(qUIButton.getPaddingLeft(), qUIButton.getPaddingTop(), ViewUtils.dip2px(16.5f), qUIButton.getPaddingBottom());
        qUIButton.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.aio.input.communicationshare.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CommunicationShareBarVB$mConfirmButton$2.b(CommunicationShareBarVB.this, view);
            }
        });
        return qUIButton;
    }
}
