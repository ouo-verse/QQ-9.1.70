package nn;

import android.view.View;
import com.qzone.reborn.qzmoment.bean.QZMPublishCaptureBean;
import com.qzone.reborn.qzmoment.widget.QZMMessagePreview;
import com.tencent.mobileqq.R;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

/* compiled from: P */
/* loaded from: classes38.dex */
public class g extends b {

    /* renamed from: e, reason: collision with root package name */
    private QZMMessagePreview f420517e;

    /* renamed from: f, reason: collision with root package name */
    private View f420518f;

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void x(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        v();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void z() {
        if (((bn.g) this.mData).a().content.images.size() < 2) {
            return;
        }
        this.f420517e.setData(new QZMPublishCaptureBean(((bn.g) this.mData).a().content.images.get(0).picUrl.get(), ((bn.g) this.mData).a().content.images.get(1).picUrl.get()));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public void onInitView(View view) {
        this.f420518f = view;
        this.f420517e = (QZMMessagePreview) view.findViewById(R.id.mky);
        view.setOnClickListener(new View.OnClickListener() { // from class: nn.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                g.this.x(view2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public int[] getViewStubLayoutId() {
        return new int[]{R.id.mkv};
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    /* renamed from: y, reason: merged with bridge method [inline-methods] */
    public void onBindData(bn.g gVar, int i3, List<Object> list) {
        if (gVar == null) {
            return;
        }
        z();
        u(this.f420518f);
    }
}
