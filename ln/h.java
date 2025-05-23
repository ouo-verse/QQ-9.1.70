package ln;

import android.view.View;
import com.tencent.mobileqq.R;
import java.util.List;
import qzonemoment.QZMomentMeta$StComment;

/* compiled from: P */
/* loaded from: classes38.dex */
public class h extends a {

    /* renamed from: h, reason: collision with root package name */
    private View f415025h;

    private void x(int i3) {
        View view = this.f415025h;
        if (view == null) {
            return;
        }
        if (i3 == 0) {
            view.setVisibility(4);
        } else {
            view.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ln.a, com.tencent.biz.richframework.part.adapter.section.Section
    public void onInitView(View view) {
        super.onInitView(view);
        this.f415025h = view.findViewById(R.id.mjv);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    /* renamed from: y, reason: merged with bridge method [inline-methods] */
    public void onBindData(QZMomentMeta$StComment qZMomentMeta$StComment, int i3, List<Object> list) {
        x(i3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public int[] getViewStubLayoutId() {
        return new int[]{R.id.mk6};
    }
}
