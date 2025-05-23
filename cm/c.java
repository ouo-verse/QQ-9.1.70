package cm;

import android.view.View;
import android.widget.TextView;
import com.qzone.reborn.base.l;
import com.tencent.mobileqq.R;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import qshadow.QZoneAutoTexting$TextInfo;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u00172\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0018B\u0007\u00a2\u0006\u0004\b\u0015\u0010\u0016J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0014J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0007H\u0014J(\u0010\u0010\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000b2\u000e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rH\u0014R\u0016\u0010\u0014\u001a\u00020\u00118\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0019"}, d2 = {"Lcm/c;", "Lcom/qzone/reborn/base/l;", "Lqshadow/QZoneAutoTexting$TextInfo;", "", "u", "", "getViewStubLayoutId", "Landroid/view/View;", "containerView", "onInitView", "data", "", "position", "", "", "payload", "v", "Landroid/widget/TextView;", "e", "Landroid/widget/TextView;", "tvContentView", "<init>", "()V", "f", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes39.dex */
public final class c extends l<QZoneAutoTexting$TextInfo> {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private TextView tvContentView;

    /* JADX WARN: Multi-variable type inference failed */
    private final void u() {
        TextView textView = this.tvContentView;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvContentView");
            textView = null;
        }
        textView.setText(((QZoneAutoTexting$TextInfo) this.mData).content.get());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public void onInitView(View containerView) {
        Intrinsics.checkNotNullParameter(containerView, "containerView");
        View findViewById = containerView.findViewById(R.id.f110026he);
        Intrinsics.checkNotNullExpressionValue(findViewById, "containerView.findViewBy\u2026d.tv_pic_to_text_content)");
        this.tvContentView = (TextView) findViewById;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    /* renamed from: v, reason: merged with bridge method [inline-methods] */
    public void onBindData(QZoneAutoTexting$TextInfo data, int position, List<Object> payload) {
        Intrinsics.checkNotNullParameter(data, "data");
        u();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public int[] getViewStubLayoutId() {
        return new int[]{R.id.f1196577f};
    }
}
