package mn;

import android.view.View;
import com.qzone.reborn.qzmoment.widget.QZMFeedBlurView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.utils.bl;
import java.util.List;

/* compiled from: P */
/* loaded from: classes38.dex */
public class c extends a {

    /* renamed from: e, reason: collision with root package name */
    private QZMFeedBlurView f417010e;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mn.a, com.tencent.biz.richframework.part.adapter.section.Section
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QZMFeedBlurViewPresenter";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    /* renamed from: v, reason: merged with bridge method [inline-methods] */
    public void onBindData(bn.b bVar, int i3, List<Object> list) {
        if (u()) {
            getStubView(R.id.mke).setVisibility(0);
            if (bVar == null || bl.b(bVar.a().images.get())) {
                return;
            }
            bn.a aVar = new bn.a();
            aVar.b(bVar.a().images.get());
            this.f417010e.setData(aVar);
            return;
        }
        getStubView(R.id.mke).setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public int[] getViewStubLayoutId() {
        return new int[]{R.id.mke};
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public void onInitView(View view) {
        this.f417010e = (QZMFeedBlurView) view.findViewById(R.id.f20638x);
    }
}
