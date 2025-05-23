package com.tencent.mobileqq.flock.feeddetail.adapter;

import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.flock.utils.g;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000b\u001a\u00020\n\u00a2\u0006\u0004\b\f\u0010\rJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\t\u001a\u00020\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\b\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/flock/feeddetail/adapter/f;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/tencent/mobileqq/flock/feeddetail/bean/a;", "feedDetailBean", "", "l", "Landroid/widget/TextView;", "E", "Landroid/widget/TextView;", "tvPublishTime", "Landroid/view/View;", "itemView", "<init>", "(Landroid/view/View;)V", "qq-flock-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class f extends RecyclerView.ViewHolder {
    static IPatchRedirector $redirector_;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final TextView tvPublishTime;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(@NotNull View itemView) {
        super(itemView);
        Intrinsics.checkNotNullParameter(itemView, "itemView");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) itemView);
            return;
        }
        View findViewById = itemView.findViewById(R.id.k_f);
        Intrinsics.checkNotNullExpressionValue(findViewById, "itemView.findViewById(R.id.tv_publish_time)");
        this.tvPublishTime = (TextView) findViewById;
    }

    public final void l(@NotNull com.tencent.mobileqq.flock.feeddetail.bean.a feedDetailBean) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) feedDetailBean);
            return;
        }
        Intrinsics.checkNotNullParameter(feedDetailBean, "feedDetailBean");
        g gVar = g.f210486a;
        String b16 = gVar.b(feedDetailBean.a().f449373h);
        y45.d dVar = feedDetailBean.a().f449378m;
        String str = "\u53d1\u5e03\u4e8e %s";
        if (dVar != null) {
            long j3 = dVar.f449388a;
            if (j3 != 0) {
                b16 = gVar.b(j3);
                str = "\u66f4\u65b0\u4e8e %s";
            }
        }
        TextView textView = this.tvPublishTime;
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String format = String.format(str, Arrays.copyOf(new Object[]{b16}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
        textView.setText(format);
    }
}
