package kk;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.exifinterface.media.ExifInterface;
import com.qzone.reborn.feedx.widget.QZoneRichTextView;
import com.qzone.util.ar;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002B\u0007\u00a2\u0006\u0004\b)\u0010*J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0005\u001a\u00020\u0003H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0014J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\bH\u0014J*\u0010\u0012\u001a\u00020\u00032\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u000e\u001a\u00020\r2\u000e\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000fH\u0014J\u0012\u0010\u0014\u001a\u00020\u00032\b\u0010\u0013\u001a\u0004\u0018\u00010\bH\u0016R\u0014\u0010\u0018\u001a\u00020\u00158\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001c\u001a\u00020\u00198\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010 \u001a\u00020\u001d8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010$\u001a\u00020!8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u0016\u0010(\u001a\u00020%8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b&\u0010'\u00a8\u0006+"}, d2 = {"Lkk/d;", "Lkk/a;", "Landroid/view/View$OnClickListener;", "", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "", "getViewStubLayoutId", "Landroid/view/View;", "containerView", "onInitView", "Lcom/qzone/reborn/message/data/a;", "data", "", "position", "", "", "payload", "B", "view", NodeProps.ON_CLICK, "", "e", "Ljava/lang/String;", "TAG", "Landroid/widget/ImageView;", "f", "Landroid/widget/ImageView;", "ivMessageIcon", "Lcom/qzone/reborn/feedx/widget/QZoneRichTextView;", h.F, "Lcom/qzone/reborn/feedx/widget/QZoneRichTextView;", "tvMessage", "Landroid/widget/FrameLayout;", "i", "Landroid/widget/FrameLayout;", "ivMsgIconContainer", "Landroid/view/ViewGroup;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/view/ViewGroup;", "rootLayout", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class d extends a implements View.OnClickListener {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final String TAG = "QZoneIntimateMessageTextSection";

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private ImageView ivMessageIcon;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private QZoneRichTextView tvMessage;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private FrameLayout ivMsgIconContainer;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private ViewGroup rootLayout;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v5, types: [android.widget.FrameLayout] */
    private final void A() {
        String str = ((com.qzone.reborn.message.data.a) this.mData).getStNotice().notice_message_icon.get();
        ImageView imageView = null;
        if (!(str == null || str.length() == 0)) {
            FrameLayout frameLayout = this.ivMsgIconContainer;
            if (frameLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException("ivMsgIconContainer");
                frameLayout = null;
            }
            frameLayout.setVisibility(0);
            ImageView imageView2 = this.ivMessageIcon;
            if (imageView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("ivMessageIcon");
            } else {
                imageView = imageView2;
            }
            rn.h.a(imageView, str, R.color.qui_common_icon_primary);
            return;
        }
        ?? r06 = this.ivMsgIconContainer;
        if (r06 == 0) {
            Intrinsics.throwUninitializedPropertyAccessException("ivMsgIconContainer");
        } else {
            imageView = r06;
        }
        imageView.setVisibility(8);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void z() {
        QZoneRichTextView qZoneRichTextView = null;
        String O = oj.a.O(oj.a.f423008a, ((com.qzone.reborn.message.data.a) this.mData).getStNotice().notice_message.get(), null, 2, null);
        QZoneRichTextView qZoneRichTextView2 = this.tvMessage;
        if (qZoneRichTextView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvMessage");
        } else {
            qZoneRichTextView = qZoneRichTextView2;
        }
        qZoneRichTextView.setRichText(O);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Integer valueOf = view != null ? Integer.valueOf(view.getId()) : null;
        if (((valueOf != null && valueOf.intValue() == R.id.n7u) || (valueOf != null && valueOf.intValue() == R.id.n7r)) && ((com.qzone.reborn.message.data.a) this.mData).getStNotice().op_mask.get().contains(1)) {
            x();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public void onInitView(View containerView) {
        Intrinsics.checkNotNullParameter(containerView, "containerView");
        View findViewById = containerView.findViewById(R.id.n7t);
        Intrinsics.checkNotNullExpressionValue(findViewById, "containerView.findViewBy\u2026.qzone_message_text_icon)");
        this.ivMessageIcon = (ImageView) findViewById;
        View findViewById2 = containerView.findViewById(R.id.n7u);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "containerView.findViewBy\u2026sage_text_icon_container)");
        this.ivMsgIconContainer = (FrameLayout) findViewById2;
        View findViewById3 = containerView.findViewById(R.id.n7r);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "containerView.findViewBy\u2026(R.id.qzone_message_text)");
        this.tvMessage = (QZoneRichTextView) findViewById3;
        View findViewById4 = containerView.findViewById(R.id.n7s);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "containerView.findViewBy\u2026sage_text_content_layout)");
        this.rootLayout = (ViewGroup) findViewById4;
        FrameLayout frameLayout = this.ivMsgIconContainer;
        QZoneRichTextView qZoneRichTextView = null;
        if (frameLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("ivMsgIconContainer");
            frameLayout = null;
        }
        frameLayout.setOnClickListener(this);
        QZoneRichTextView qZoneRichTextView2 = this.tvMessage;
        if (qZoneRichTextView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvMessage");
            qZoneRichTextView2 = null;
        }
        qZoneRichTextView2.setOnClickListener(this);
        QZoneRichTextView qZoneRichTextView3 = this.tvMessage;
        if (qZoneRichTextView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvMessage");
            qZoneRichTextView3 = null;
        }
        qZoneRichTextView3.setLineSpace(ar.d(3.0f));
        QZoneRichTextView qZoneRichTextView4 = this.tvMessage;
        if (qZoneRichTextView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvMessage");
        } else {
            qZoneRichTextView = qZoneRichTextView4;
        }
        qZoneRichTextView.setTextColorLink(p().getResources().getColor(R.color.qui_common_text_link));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public int[] getViewStubLayoutId() {
        return new int[]{R.id.nos};
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    /* renamed from: B, reason: merged with bridge method [inline-methods] */
    public void onBindData(com.qzone.reborn.message.data.a data, int position, List<Object> payload) {
        if (data != null) {
            A();
            z();
        }
    }
}
