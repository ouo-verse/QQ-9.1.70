package mn;

import android.view.View;
import com.qzone.reborn.qzmoment.widget.QZMInteractPictureView;
import com.tencent.mobileqq.R;
import java.util.List;

/* compiled from: P */
/* loaded from: classes38.dex */
public class i extends a {

    /* renamed from: e, reason: collision with root package name */
    private QZMInteractPictureView f417025e;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mn.a, com.tencent.biz.richframework.part.adapter.section.Section
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QZMFeedPicPresenter";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    /* renamed from: v, reason: merged with bridge method [inline-methods] */
    public void onBindData(bn.b bVar, int i3, List<Object> list) {
        if (u()) {
            getStubView(R.id.mkh).setVisibility(8);
            return;
        }
        getStubView(R.id.mkh).setVisibility(0);
        if (bVar == null) {
            return;
        }
        bn.e eVar = new bn.e();
        eVar.g(bVar.a().images.get());
        eVar.e(bVar);
        eVar.f(i3);
        this.f417025e.setData(eVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public int[] getViewStubLayoutId() {
        return new int[]{R.id.mkh};
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public void onInitView(View view) {
        this.f417025e = (QZMInteractPictureView) view.findViewById(R.id.km9);
    }
}
