package com.tencent.mobileqq.aio.msglist.holder.component.msgfollow;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.aio.msglist.holder.component.msgfollow.b;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n\u00a2\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Landroid/widget/ImageView;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes11.dex */
public final class AIOMsgFollowComponent$followIcon$2 extends Lambda implements Function0<ImageView> {
    static IPatchRedirector $redirector_;
    final /* synthetic */ AIOMsgFollowComponent this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AIOMsgFollowComponent$followIcon$2(AIOMsgFollowComponent aIOMsgFollowComponent) {
        super(0);
        this.this$0 = aIOMsgFollowComponent;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) aIOMsgFollowComponent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(AIOMsgFollowComponent this$0, View view) {
        AIOMsgItem aIOMsgItem;
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        aIOMsgItem = this$0.mCurMsgItem;
        if (aIOMsgItem != null) {
            this$0.sendIntent(new b.a(aIOMsgItem));
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    @NotNull
    public final ImageView invoke() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (ImageView) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        ImageView imageView = new ImageView(this.this$0.getContext());
        final AIOMsgFollowComponent aIOMsgFollowComponent = this.this$0;
        imageView.setLayoutParams(new ViewGroup.LayoutParams(ViewUtils.dip2px(25.0f), ViewUtils.dip2px(25.0f)));
        imageView.setVisibility(8);
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.aio.msglist.holder.component.msgfollow.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AIOMsgFollowComponent$followIcon$2.b(AIOMsgFollowComponent.this, view);
            }
        });
        imageView.setContentDescription("+1");
        return imageView;
    }
}
