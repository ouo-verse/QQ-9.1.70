package kk;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import com.qzone.common.account.LoginData;
import com.qzone.reborn.feedx.widget.QZoneUserAvatarView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002B\u0007\u00a2\u0006\u0004\b&\u0010'J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0002J\b\u0010\b\u001a\u00020\u0007H\u0014J\u0010\u0010\u000b\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\tH\u0014J*\u0010\u0013\u001a\u00020\u00052\b\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\u000f\u001a\u00020\u000e2\u000e\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0010H\u0014J\u0012\u0010\u0015\u001a\u00020\u00052\b\u0010\u0014\u001a\u0004\u0018\u00010\tH\u0016R\u0014\u0010\u0019\u001a\u00020\u00168\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001d\u001a\u00020\u001a8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010!\u001a\u00020\u001e8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010%\u001a\u00020\"8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b#\u0010$\u00a8\u0006("}, d2 = {"Lkk/c;", "Lkk/a;", "Landroid/view/View$OnClickListener;", "", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "", "getViewStubLayoutId", "Landroid/view/View;", "containerView", "onInitView", "Lcom/qzone/reborn/message/data/a;", "data", "", "position", "", "", "payload", "B", "view", NodeProps.ON_CLICK, "", "e", "Ljava/lang/String;", "TAG", "Landroid/view/ViewGroup;", "f", "Landroid/view/ViewGroup;", "contentView", "Lcom/qzone/reborn/feedx/widget/QZoneUserAvatarView;", h.F, "Lcom/qzone/reborn/feedx/widget/QZoneUserAvatarView;", "avatarView", "Landroid/widget/TextView;", "i", "Landroid/widget/TextView;", "tvReplyButton", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class c extends a implements View.OnClickListener {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final String TAG = "QZoneIntimateMessageReplyInputSection";

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private ViewGroup contentView;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private QZoneUserAvatarView avatarView;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private TextView tvReplyButton;

    /* JADX WARN: Multi-variable type inference failed */
    private final boolean A() {
        boolean contains = ((com.qzone.reborn.message.data.a) this.mData).getStNotice().op_mask.get().contains(1);
        ViewGroup viewGroup = this.contentView;
        if (viewGroup == null) {
            Intrinsics.throwUninitializedPropertyAccessException("contentView");
            viewGroup = null;
        }
        viewGroup.setVisibility(contains ? 0 : 8);
        return contains;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void z() {
        String uid = LoginData.getInstance().getUid();
        Intrinsics.checkNotNullExpressionValue(uid, "getInstance().uid");
        QZoneUserAvatarView qZoneUserAvatarView = this.avatarView;
        if (qZoneUserAvatarView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("avatarView");
            qZoneUserAvatarView = null;
        }
        qZoneUserAvatarView.setUser(mk.h.f416877a.f(uid, ((com.qzone.reborn.message.data.a) this.mData).getStCommonExt()));
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Integer valueOf = view != null ? Integer.valueOf(view.getId()) : null;
        if (valueOf != null && valueOf.intValue() == R.id.n7l) {
            x();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public void onInitView(View containerView) {
        Intrinsics.checkNotNullParameter(containerView, "containerView");
        View findViewById = containerView.findViewById(R.id.n7k);
        Intrinsics.checkNotNullExpressionValue(findViewById, "containerView.findViewBy\u2026age_reply_content_layout)");
        this.contentView = (ViewGroup) findViewById;
        View findViewById2 = containerView.findViewById(R.id.n7j);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "containerView.findViewBy\u2026one_message_reply_avatar)");
        this.avatarView = (QZoneUserAvatarView) findViewById2;
        View findViewById3 = containerView.findViewById(R.id.n7l);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "containerView.findViewBy\u2026qzone_message_reply_edit)");
        TextView textView = (TextView) findViewById3;
        this.tvReplyButton = textView;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvReplyButton");
            textView = null;
        }
        textView.setOnClickListener(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public int[] getViewStubLayoutId() {
        return new int[]{R.id.nor};
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    /* renamed from: B, reason: merged with bridge method [inline-methods] */
    public void onBindData(com.qzone.reborn.message.data.a data, int position, List<Object> payload) {
        if (data == null || !A()) {
            return;
        }
        z();
        TextView textView = this.tvReplyButton;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvReplyButton");
            textView = null;
        }
        a.v(this, textView, "em_qz_comment_box", false, 4, null);
    }
}
