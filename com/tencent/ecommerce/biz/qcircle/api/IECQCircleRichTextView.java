package com.tencent.ecommerce.biz.qcircle.api;

import com.tencent.mtt.hippy.dom.node.NodeProps;
import java.util.HashMap;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001:\u0001\u0012J6\u0010\u0002\u001a\u00020\u00032\"\u0010\u0004\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u0005j\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0001`\u00072\b\b\u0002\u0010\b\u001a\u00020\tH&J\b\u0010\n\u001a\u00020\u000bH&J\b\u0010\f\u001a\u00020\u0003H&J\u0010\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000fH&J\u0010\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u000bH&\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/ecommerce/biz/qcircle/api/IECQCircleRichTextView;", "", "applyViewProp", "", "propMap", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "needSetText", "", "calculateViewHeight", "", "resetView", "setContentExpandListener", "listener", "Lcom/tencent/ecommerce/biz/qcircle/api/IECQCircleRichTextView$IQCircleContentExpandListener;", "setViewWidth", "width", "IQCircleContentExpandListener", "ecommerce_api_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes5.dex */
public interface IECQCircleRichTextView {

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/ecommerce/biz/qcircle/api/IECQCircleRichTextView$IQCircleContentExpandListener;", "", NodeProps.ON_CLICK, "", "isExpanded", "", "ecommerce_api_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes5.dex */
    public interface IQCircleContentExpandListener {
        void onClick(boolean isExpanded);
    }

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes5.dex */
    public static final class a {
        public static /* synthetic */ void a(IECQCircleRichTextView iECQCircleRichTextView, HashMap hashMap, boolean z16, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 2) != 0) {
                    z16 = true;
                }
                iECQCircleRichTextView.applyViewProp(hashMap, z16);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: applyViewProp");
        }
    }

    void applyViewProp(@NotNull HashMap<String, Object> propMap, boolean needSetText);

    float calculateViewHeight();

    void resetView();

    void setContentExpandListener(@NotNull IQCircleContentExpandListener listener);

    void setViewWidth(float width);
}
