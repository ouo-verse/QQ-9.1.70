package la;

import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.qzone.util.ar;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 \u001d2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001eB\u0007\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\b\u0010\u0004\u001a\u00020\u0003H\u0014J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0014J*\u0010\u000f\u001a\u00020\u00072\b\u0010\t\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u000b\u001a\u00020\n2\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\fH\u0014J\b\u0010\u0011\u001a\u00020\u0010H\u0014R\u0016\u0010\u0014\u001a\u00020\u00058\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0018\u001a\u00020\u00158\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001a\u001a\u00020\u00158\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u0017\u00a8\u0006\u001f"}, d2 = {"Lla/x;", "Lcom/qzone/reborn/base/l;", "Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;", "", "getViewStubLayoutId", "Landroid/view/View;", "containerView", "", "onInitView", "data", "", "position", "", "", "payload", "u", "", "getLogTag", "e", "Landroid/view/View;", "mDescContainer", "Landroid/widget/TextView;", "f", "Landroid/widget/TextView;", "mNameTv", tl.h.F, "mCountTv", "<init>", "()V", "i", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class x extends com.qzone.reborn.base.l<LocalMediaInfo> {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private View mDescContainer;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private TextView mNameTv;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private TextView mCountTv;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public String getLogTag() {
        return "QZoneAlbumxMediaListItemDescSection";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public void onInitView(View containerView) {
        Intrinsics.checkNotNullParameter(containerView, "containerView");
        View findViewById = containerView.findViewById(R.id.mph);
        Intrinsics.checkNotNullExpressionValue(findViewById, "containerView.findViewBy\u2026lbumx_media_list_desc_ll)");
        this.mDescContainer = findViewById;
        View findViewById2 = containerView.findViewById(R.id.mpm);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "containerView.findViewBy\u2026lbumx_media_list_name_tv)");
        this.mNameTv = (TextView) findViewById2;
        View findViewById3 = containerView.findViewById(R.id.mpg);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "containerView.findViewBy\u2026bumx_media_list_count_tv)");
        this.mCountTv = (TextView) findViewById3;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public int[] getViewStubLayoutId() {
        return new int[]{R.id.mqb};
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    /* renamed from: u, reason: merged with bridge method [inline-methods] */
    public void onBindData(LocalMediaInfo data, int position, List<Object> payload) {
        if (data == null) {
            QLog.e(getLogTag(), 1, "[onBindData] data is null, pos = " + position);
        }
        QLog.d(getLogTag(), 1, "[onBindData] pos = " + position);
        if (data != null) {
            int g16 = ea.a.g(data);
            String str = "";
            if (g16 == 1) {
                TextView textView = this.mNameTv;
                if (textView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mNameTv");
                    textView = null;
                }
                textView.setText(com.qzone.util.l.a(R.string.jfe));
            } else if (g16 != 3) {
                TextView textView2 = this.mNameTv;
                if (textView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mNameTv");
                    textView2 = null;
                }
                textView2.setText("");
            } else {
                TextView textView3 = this.mNameTv;
                if (textView3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mNameTv");
                    textView3 = null;
                }
                textView3.setText(com.qzone.util.l.a(R.string.jfd));
            }
            int f16 = ea.a.f(data);
            TextView textView4 = this.mCountTv;
            if (textView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mCountTv");
                textView4 = null;
            }
            if (f16 > 0) {
                str = f16 + "\u5f20";
            }
            textView4.setText(str);
        }
        View view = this.mDescContainer;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mDescContainer");
            view = null;
        }
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        LinearLayout.LayoutParams layoutParams2 = layoutParams instanceof LinearLayout.LayoutParams ? (LinearLayout.LayoutParams) layoutParams : null;
        if (layoutParams2 != null) {
            layoutParams2.topMargin = position == 0 ? 0 : ar.d(23.0f);
        }
    }
}
