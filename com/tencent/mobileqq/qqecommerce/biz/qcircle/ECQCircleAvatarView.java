package com.tencent.mobileqq.qqecommerce.biz.qcircle;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Size;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.biz.qqcircle.widgets.QCircleAvatarView;
import com.tencent.ecommerce.biz.qcircle.api.IECQCircleAvatarView;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta$StFeed;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u0000 \u00112\u00020\u00012\u00020\u0002:\u0001\u0012B\u0011\b\u0016\u0012\u0006\u0010\b\u001a\u00020\u0007\u00a2\u0006\u0004\b\t\u0010\nB\u001b\b\u0016\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u000b\u00a2\u0006\u0004\b\t\u0010\rB#\b\u0016\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u00a2\u0006\u0004\b\t\u0010\u0010J\u0014\u0010\u0006\u001a\u00020\u00052\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0003H\u0016\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/qqecommerce/biz/qcircle/ECQCircleAvatarView;", "Lcom/tencent/biz/qqcircle/widgets/QCircleAvatarView;", "Lcom/tencent/ecommerce/biz/qcircle/api/IECQCircleAvatarView;", "Lcom/tencent/mobileqq/pb/MessageMicro;", "feedPb", "", "setFeedPb", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "j0", "a", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class ECQCircleAvatarView extends QCircleAvatarView implements IECQCircleAvatarView {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ECQCircleAvatarView(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    @Override // com.tencent.ecommerce.biz.qcircle.api.IECQCircleAvatarView
    public void setFeedPb(MessageMicro<?> feedPb) {
        Intrinsics.checkNotNullParameter(feedPb, "feedPb");
        if (feedPb instanceof FeedCloudMeta$StFeed) {
            setAvatar(((FeedCloudMeta$StFeed) feedPb).poster, new Size(ViewUtils.dpToPx(34.0f), ViewUtils.dpToPx(34.0f)));
            return;
        }
        QLog.e("ECQCircleApi", 1, "setFeedPb error, feedPb:" + feedPb);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ECQCircleAvatarView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ECQCircleAvatarView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
    }
}
