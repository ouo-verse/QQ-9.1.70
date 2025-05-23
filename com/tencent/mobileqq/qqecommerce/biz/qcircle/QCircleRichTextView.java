package com.tencent.mobileqq.qqecommerce.biz.qcircle;

import android.content.Context;
import android.text.DynamicLayout;
import android.text.Layout;
import android.util.AttributeSet;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.biz.qqcircle.beans.QCirclePolymerizationBean;
import com.tencent.biz.qqcircle.launcher.c;
import com.tencent.biz.qqcircle.widgets.QFSExpandableAsyncTextView;
import com.tencent.ecommerce.biz.qcircle.api.IECQCircleRichTextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.IQCircleSkinHelperApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.text.rich.RFWAsyncRichTextView;
import com.tencent.widget.immersive.ImmersiveUtils;
import feedcloud.FeedCloudMeta$StTagInfo;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt__MathJVMKt;

/* compiled from: P */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u0000 !2\u00020\u00012\u00020\u0002:\u0001\"B'\b\u0007\u0012\u0006\u0010\u001a\u001a\u00020\u0019\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001b\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u001d\u00a2\u0006\u0004\b\u001f\u0010 J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J4\u0010\r\u001a\u00020\u00052\"\u0010\n\u001a\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\b0\u0007j\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\b`\t2\u0006\u0010\f\u001a\u00020\u000bH\u0016J\b\u0010\u000e\u001a\u00020\u0005H\u0016J\u0010\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u000fH\u0016J\u0010\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u0012H\u0016J\b\u0010\u0015\u001a\u00020\u0012H\u0016R\u0016\u0010\u0018\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017\u00a8\u0006#"}, d2 = {"Lcom/tencent/mobileqq/qqecommerce/biz/qcircle/QCircleRichTextView;", "Lcom/tencent/biz/qqcircle/widgets/QFSExpandableAsyncTextView;", "Lcom/tencent/ecommerce/biz/qcircle/api/IECQCircleRichTextView;", "", "tagName", "", "G", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "propMap", "", "needSetText", "applyViewProp", "resetView", "Lcom/tencent/ecommerce/biz/qcircle/api/IECQCircleRichTextView$IQCircleContentExpandListener;", "listener", "setContentExpandListener", "", "width", "setViewWidth", "calculateViewHeight", "d0", "Ljava/lang/String;", "content", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "", "defStyle", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "e0", "a", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class QCircleRichTextView extends QFSExpandableAsyncTextView implements IECQCircleRichTextView {

    /* renamed from: d0, reason: collision with root package name and from kotlin metadata */
    private String content;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public QCircleRichTextView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void E(QCircleRichTextView this$0, String str) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QCircleInitBean qCircleInitBean = new QCircleInitBean();
        qCircleInitBean.setUin(str);
        c.d0(this$0.getContext(), qCircleInitBean);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void F(QCircleRichTextView this$0, String hashTag) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(hashTag, "hashTag");
        this$0.G(hashTag);
    }

    private final void G(String tagName) {
        QCirclePolymerizationBean qCirclePolymerizationBean = new QCirclePolymerizationBean();
        FeedCloudMeta$StTagInfo feedCloudMeta$StTagInfo = new FeedCloudMeta$StTagInfo();
        feedCloudMeta$StTagInfo.tagName.set(tagName);
        qCirclePolymerizationBean.setTagInfo(feedCloudMeta$StTagInfo);
        qCirclePolymerizationBean.setPolymerizationType(7);
        qCirclePolymerizationBean.setExt1From(3);
        c.j0(getContext(), qCirclePolymerizationBean);
    }

    @Override // com.tencent.ecommerce.biz.qcircle.api.IECQCircleRichTextView
    public void applyViewProp(HashMap<String, Object> propMap, boolean needSetText) {
        Intrinsics.checkNotNullParameter(propMap, "propMap");
        if (propMap.containsKey(NodeProps.NUMBER_OF_LINES)) {
            Object obj = propMap.get(NodeProps.NUMBER_OF_LINES);
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
            int intValue = ((Integer) obj).intValue();
            if (intValue != 0) {
                setExpanded(false);
                setLimitLines(intValue);
            } else {
                setExpanded(true);
            }
        }
        if (propMap.containsKey("content")) {
            Object obj2 = propMap.get("content");
            Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.String");
            String str = (String) obj2;
            this.content = str;
            if (needSetText) {
                setText(str);
            }
        }
        if (propMap.containsKey("fontSize")) {
            Intrinsics.checkNotNull(propMap.get("fontSize"), "null cannot be cast to non-null type kotlin.Number");
            setTextSize(0, ImmersiveUtils.dpToPx(((Number) r4).floatValue()));
        }
    }

    @Override // com.tencent.ecommerce.biz.qcircle.api.IECQCircleRichTextView
    public float calculateViewHeight() {
        if (parserText(this.content) == null) {
            QLog.e("QCircleRichTextView", 1, "error, parsedContent == null, content=" + this.content);
            return 0.0f;
        }
        return new DynamicLayout(r2, getPaint(), l(), Layout.Alignment.ALIGN_NORMAL, getLineSpacingMultiplier(), getLineSpacingExtra(), false).getHeight();
    }

    @Override // com.tencent.ecommerce.biz.qcircle.api.IECQCircleRichTextView
    public void setContentExpandListener(IECQCircleRichTextView.IQCircleContentExpandListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        setCollapseCollapseListener(new b(listener));
    }

    @Override // com.tencent.ecommerce.biz.qcircle.api.IECQCircleRichTextView
    public void setViewWidth(float width) {
        int roundToInt;
        roundToInt = MathKt__MathJVMKt.roundToInt(width);
        setExactWidth(roundToInt);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public QCircleRichTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    @Override // com.tencent.ecommerce.biz.qcircle.api.IECQCircleRichTextView
    public void resetView() {
        setExpanded(false);
        setLimitLines(3);
        setText("");
    }

    public /* synthetic */ QCircleRichTextView(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QCircleRichTextView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        this.content = "";
        setExpanded(false);
        setShowCollapse(false);
        setSpecialClickAreaColor(R.color.qvideo_skin_color_icon_hashtag);
        setTextColor(((IQCircleSkinHelperApi) QRoute.api(IQCircleSkinHelperApi.class)).getColor(R.color.qvideo_skin_color_text_primary));
        setNeedSpecialAreaBold(false);
        setNeedSpecialHashTagAreaBackground(false);
        setOnClickAtTextListener(new RFWAsyncRichTextView.OnClickAtTextListener() { // from class: com.tencent.mobileqq.qqecommerce.biz.qcircle.a
            @Override // com.tencent.richframework.text.rich.RFWAsyncRichTextView.OnClickAtTextListener
            public final void onClick(String str) {
                QCircleRichTextView.E(QCircleRichTextView.this, str);
            }
        });
        setOnClickHashTagTextListener(new RFWAsyncRichTextView.OnClickHashTagTextListener() { // from class: com.tencent.mobileqq.qqecommerce.biz.qcircle.b
            @Override // com.tencent.richframework.text.rich.RFWAsyncRichTextView.OnClickHashTagTextListener
            public final void onClick(String str) {
                QCircleRichTextView.F(QCircleRichTextView.this, str);
            }
        });
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/qqecommerce/biz/qcircle/QCircleRichTextView$b", "Lcom/tencent/biz/qqcircle/widgets/QFSExpandableAsyncTextView$b;", "", "isExpanded", "", "b", NodeProps.ON_CLICK, "", "lineCount", "a", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class b implements QFSExpandableAsyncTextView.b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ IECQCircleRichTextView.IQCircleContentExpandListener f263375a;

        b(IECQCircleRichTextView.IQCircleContentExpandListener iQCircleContentExpandListener) {
            this.f263375a = iQCircleContentExpandListener;
        }

        @Override // com.tencent.biz.qqcircle.widgets.QFSExpandableAsyncTextView.b
        public boolean onClick(boolean isExpanded) {
            this.f263375a.onClick(isExpanded);
            return true;
        }

        @Override // com.tencent.biz.qqcircle.widgets.QFSExpandableAsyncTextView.b
        public void a(int lineCount) {
        }

        @Override // com.tencent.biz.qqcircle.widgets.QFSExpandableAsyncTextView.b
        public void b(boolean isExpanded) {
        }
    }
}
