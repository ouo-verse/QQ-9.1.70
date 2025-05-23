package cc;

import android.view.View;
import android.widget.TextView;
import com.qzone.reborn.base.l;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import java.util.Calendar;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u001c\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\t\u001a\u00020\bH\u0002J\b\u0010\u000e\u001a\u00020\rH\u0014J\u0010\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000fH\u0014J(\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u000b2\u000e\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0013H\u0014R\u0014\u0010\u0019\u001a\u00020\u00068\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001d\u001a\u00020\u001a8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001c\u00a8\u0006 "}, d2 = {"Lcc/c;", "Lcom/qzone/reborn/base/l;", "Lcb/b;", "data", "", "u", "", "w", "", "titleTime", "Lkotlin/Pair;", "", "v", "", "getViewStubLayoutId", "Landroid/view/View;", "containerView", "onInitView", "position", "", "", "payload", HippyTKDListViewAdapter.X, "e", "Ljava/lang/String;", "TAG", "Landroid/widget/TextView;", "f", "Landroid/widget/TextView;", "tvTitle", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes39.dex */
public final class c extends l<cb.b> {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final String TAG = "QZAlbumxTitleSection";

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private TextView tvTitle;

    private final void u(cb.b data) {
        TextView textView = this.tvTitle;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvTitle");
            textView = null;
        }
        textView.setText(w(data));
    }

    private final Pair<Integer, Integer> v(long titleTime) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(titleTime * 1000);
        return new Pair<>(Integer.valueOf(calendar.get(1)), Integer.valueOf(calendar.get(2) + 1));
    }

    private final String w(cb.b data) {
        Pair<Integer, Integer> v3 = v(data.getCurTimeStamp());
        return v3.getFirst() + "\u5e74" + v3.getSecond() + "\u6708";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public void onInitView(View containerView) {
        Intrinsics.checkNotNullParameter(containerView, "containerView");
        View findViewById = containerView.findViewById(R.id.ngc);
        Intrinsics.checkNotNullExpressionValue(findViewById, "containerView.findViewById(R.id.tab_media_title)");
        this.tvTitle = (TextView) findViewById;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    /* renamed from: x, reason: merged with bridge method [inline-methods] */
    public void onBindData(cb.b data, int position, List<Object> payload) {
        Intrinsics.checkNotNullParameter(data, "data");
        u(data);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public int[] getViewStubLayoutId() {
        return new int[0];
    }
}
