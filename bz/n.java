package bz;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.widget.pull2refresh.BaseViewHolder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u000b\u001a\u00020\n\u00a2\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R\u0016\u0010\t\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\b\u00a8\u0006\u000e"}, d2 = {"Lbz/n;", "Lcom/tencent/widget/pull2refresh/BaseViewHolder;", "Lyy/c;", "data", "", "b", "Landroid/widget/TextView;", "d", "Landroid/widget/TextView;", "tvMsgStatus", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "<init>", "(Landroid/view/ViewGroup;)V", "qqweishi_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes39.dex */
public final class n extends BaseViewHolder<yy.c> {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private TextView tvMsgStatus;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n(ViewGroup parent) {
        super(parent, R.layout.d17);
        Intrinsics.checkNotNullParameter(parent, "parent");
        View findViewById = this.itemView.findViewById(R.id.p7t);
        Intrinsics.checkNotNullExpressionValue(findViewById, "itemView.findViewById(R.id.tv_msg_status)");
        this.tvMsgStatus = (TextView) findViewById;
    }

    @Override // com.tencent.widget.pull2refresh.BaseViewHolder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public void bindData(yy.c data) {
        Intrinsics.checkNotNullParameter(data, "data");
        super.bindData(data);
        if (data.c().a()) {
            this.tvMsgStatus.setText(getContext().getString(R.string.x9f));
        } else {
            this.tvMsgStatus.setText(getContext().getString(R.string.x9g));
        }
    }
}
