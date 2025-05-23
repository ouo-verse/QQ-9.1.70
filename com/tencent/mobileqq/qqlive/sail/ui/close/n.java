package com.tencent.mobileqq.qqlive.sail.ui.close;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqlive.sail.ui.close.a;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.RoundRectImageView;
import cooperation.qqcircle.picload.QCircleFeedPicLoader;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u001e\u001a\u00020\u001d\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0006\u00a2\u0006\u0004\b\u001f\u0010 J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0016\u0010\t\u001a\u0004\u0018\u00010\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0018\u0010\r\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0014R(\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0018\u001a\u0004\u0018\u00010\u00028\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\u00a8\u0006!"}, d2 = {"Lcom/tencent/mobileqq/qqlive/sail/ui/close/n;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lqr4/b;", "feed", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/qqlive/sail/ui/close/a$b;", "E", "Lcom/tencent/mobileqq/qqlive/sail/ui/close/a$b;", "clickListener", "Lcom/tencent/widget/RoundRectImageView;", UserInfo.SEX_FEMALE, "Lcom/tencent/widget/RoundRectImageView;", "cover", "Landroid/widget/ImageView;", "G", "Landroid/widget/ImageView;", "avatar", "Landroid/widget/TextView;", "H", "Landroid/widget/TextView;", "nickname", "I", "title", "<set-?>", "J", "Lqr4/b;", "getFeed", "()Lqr4/b;", "Landroid/view/View;", "itemView", "<init>", "(Landroid/view/View;Lcom/tencent/mobileqq/qqlive/sail/ui/close/a$b;)V", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class n extends RecyclerView.ViewHolder {
    static IPatchRedirector $redirector_;

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private final a.b clickListener;

    /* renamed from: F, reason: from kotlin metadata */
    @Nullable
    private RoundRectImageView cover;

    /* renamed from: G, reason: from kotlin metadata */
    @Nullable
    private ImageView avatar;

    /* renamed from: H, reason: from kotlin metadata */
    @Nullable
    private TextView nickname;

    /* renamed from: I, reason: from kotlin metadata */
    @Nullable
    private TextView title;

    /* renamed from: J, reason: from kotlin metadata */
    @Nullable
    private qr4.b feed;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n(@NotNull View itemView, @Nullable a.b bVar) {
        super(itemView);
        Intrinsics.checkNotNullParameter(itemView, "itemView");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) itemView, (Object) bVar);
            return;
        }
        this.clickListener = bVar;
        RoundRectImageView roundRectImageView = (RoundRectImageView) itemView.findViewById(R.id.f60052ud);
        this.cover = roundRectImageView;
        if (roundRectImageView != null) {
            roundRectImageView.setCornerRadiusAndMode(wi2.c.b(8), 1);
        }
        this.avatar = (ImageView) itemView.findViewById(R.id.f60042uc);
        this.nickname = (TextView) itemView.findViewById(R.id.f60062ue);
        this.title = (TextView) itemView.findViewById(R.id.f60072uf);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n(n this$0, qr4.b feed, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(feed, "$feed");
        a.b bVar = this$0.clickListener;
        if (bVar != null) {
            bVar.p5(feed);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    public final void m(@NotNull final qr4.b feed) {
        String str;
        String str2;
        String str3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) feed);
            return;
        }
        Intrinsics.checkNotNullParameter(feed, "feed");
        this.feed = feed;
        RoundRectImageView roundRectImageView = this.cover;
        if (roundRectImageView != null) {
            roundRectImageView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.qqlive.sail.ui.close.m
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    n.n(n.this, feed, view);
                }
            });
        }
        Option obtain = Option.obtain();
        qr4.f fVar = feed.f429376a;
        String str4 = null;
        if (fVar != null) {
            str = fVar.f429398b;
        } else {
            str = null;
        }
        QCircleFeedPicLoader.g().loadImage(obtain.setUrl(str).setFailedDrawableId(R.drawable.l2j).setTargetView(this.cover));
        Option obtain2 = Option.obtain();
        qr4.f fVar2 = feed.f429376a;
        if (fVar2 != null) {
            str2 = fVar2.f429407k;
        } else {
            str2 = null;
        }
        QCircleFeedPicLoader.g().loadImage(obtain2.setUrl(str2).setRequestWidth(wi2.c.b(20)).setRequestHeight(wi2.c.b(20)).setFailedDrawableId(R.drawable.nmi).setTargetView(this.avatar));
        TextView textView = this.nickname;
        if (textView != null) {
            qr4.f fVar3 = feed.f429376a;
            if (fVar3 != null) {
                str3 = fVar3.f429406j;
            } else {
                str3 = null;
            }
            textView.setText(str3);
        }
        TextView textView2 = this.title;
        if (textView2 != null) {
            qr4.f fVar4 = feed.f429376a;
            if (fVar4 != null) {
                str4 = fVar4.f429399c;
            }
            textView2.setText(str4);
        }
    }
}
