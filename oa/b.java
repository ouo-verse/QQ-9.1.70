package oa;

import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.qzone.reborn.albumx.common.bean.CommonGridItemData;
import com.qzone.reborn.base.l;
import com.tencent.mobileqq.R;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0014\u0010\u0015J\b\u0010\u0004\u001a\u00020\u0003H\u0014J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0014J(\u0010\u000f\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\n2\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\fH\u0014R\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0016"}, d2 = {"Loa/b;", "Lcom/qzone/reborn/base/l;", "Lcom/qzone/reborn/albumx/common/bean/CommonGridItemData;", "", "getViewStubLayoutId", "Landroid/view/View;", "containerView", "", "onInitView", "data", "", "position", "", "", "payload", "u", "Landroid/widget/TextView;", "e", "Landroid/widget/TextView;", "titleText", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class b extends l<CommonGridItemData> {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private TextView titleText;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public void onInitView(View containerView) {
        Intrinsics.checkNotNullParameter(containerView, "containerView");
        View findViewById = containerView.findViewById(R.id.mvg);
        Intrinsics.checkNotNullExpressionValue(findViewById, "containerView.findViewBy\u2026qzone_expire_album_title)");
        this.titleText = (TextView) findViewById;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    /* renamed from: u, reason: merged with bridge method [inline-methods] */
    public void onBindData(CommonGridItemData data, int position, List<Object> payload) {
        Intrinsics.checkNotNullParameter(data, "data");
        TextView textView = null;
        if (TextUtils.isEmpty(data.getBatchBean().getBatchInfo().getCom.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_SHOW_TIME java.lang.String())) {
            TextView textView2 = this.titleText;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("titleText");
                textView2 = null;
            }
            Object parent = textView2.getParent();
            Intrinsics.checkNotNull(parent, "null cannot be cast to non-null type android.view.View");
            ((View) parent).setVisibility(8);
        } else {
            TextView textView3 = this.titleText;
            if (textView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("titleText");
                textView3 = null;
            }
            Object parent2 = textView3.getParent();
            Intrinsics.checkNotNull(parent2, "null cannot be cast to non-null type android.view.View");
            ((View) parent2).setVisibility(0);
        }
        TextView textView4 = this.titleText;
        if (textView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("titleText");
        } else {
            textView = textView4;
        }
        textView.setText(data.getBatchBean().getBatchInfo().getCom.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_SHOW_TIME java.lang.String());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public int[] getViewStubLayoutId() {
        return new int[]{R.id.mvh};
    }
}
