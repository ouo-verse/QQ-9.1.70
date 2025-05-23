package la;

import android.view.View;
import android.widget.TextView;
import com.tencent.biz.richframework.localupload.recommend.bean.RFWUploadRecommendInfo;
import com.tencent.mobileqq.R;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u00182\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0019B\u0007\u00a2\u0006\u0004\b\u0016\u0010\u0017J\b\u0010\u0004\u001a\u00020\u0003H\u0014J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0014J*\u0010\u000f\u001a\u00020\u00072\b\u0010\t\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u000b\u001a\u00020\n2\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\fH\u0014J\b\u0010\u0011\u001a\u00020\u0010H\u0014R\u0016\u0010\u0015\u001a\u00020\u00128\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014\u00a8\u0006\u001a"}, d2 = {"Lla/f;", "Lcom/qzone/reborn/base/l;", "Lcom/tencent/biz/richframework/localupload/recommend/bean/RFWUploadRecommendInfo;", "", "getViewStubLayoutId", "Landroid/view/View;", "containerView", "", "onInitView", "data", "", "position", "", "", "payload", "u", "", "getLogTag", "Landroid/widget/TextView;", "e", "Landroid/widget/TextView;", "mReasonTv", "<init>", "()V", "f", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class f extends com.qzone.reborn.base.l<RFWUploadRecommendInfo> {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private TextView mReasonTv;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QZoneAlbumxLocalPhotoRecommendReasonSection";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public void onInitView(View containerView) {
        Intrinsics.checkNotNullParameter(containerView, "containerView");
        View findViewById = containerView.findViewById(R.id.mow);
        Intrinsics.checkNotNullExpressionValue(findViewById, "containerView.findViewBy\u2026hoto_recommend_reason_tv)");
        TextView textView = (TextView) findViewById;
        this.mReasonTv = textView;
        TextView textView2 = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mReasonTv");
            textView = null;
        }
        textView.setText(com.qzone.util.l.a(R.string.jft));
        TextView textView3 = this.mReasonTv;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mReasonTv");
        } else {
            textView2 = textView3;
        }
        fo.c.n(textView2, "em_qz_clustering_module");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public int[] getViewStubLayoutId() {
        return new int[]{R.id.mqd};
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    /* renamed from: u, reason: merged with bridge method [inline-methods] */
    public void onBindData(RFWUploadRecommendInfo data, int position, List<Object> payload) {
        TextView textView = null;
        if (data == null) {
            TextView textView2 = this.mReasonTv;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mReasonTv");
                textView2 = null;
            }
            textView2.setVisibility(8);
        }
        if (data != null) {
            TextView textView3 = this.mReasonTv;
            if (textView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mReasonTv");
            } else {
                textView = textView3;
            }
            textView.setVisibility(ga.b.c(data) ? 0 : 8);
        }
    }
}
