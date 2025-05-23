package nn;

import android.view.View;
import com.qzone.reborn.widget.QZoneAsyncTextView;
import com.tencent.mobileqq.R;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

/* compiled from: P */
/* loaded from: classes38.dex */
public class e extends b {

    /* renamed from: e, reason: collision with root package name */
    private QZoneAsyncTextView f420514e;

    /* renamed from: f, reason: collision with root package name */
    private View f420515f;

    /* JADX WARN: Multi-variable type inference failed */
    private void B() {
        this.f420514e.setText(((bn.g) this.mData).a().content.message.get());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean y(View view) {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void z(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        v();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public void onInitView(View view) {
        this.f420515f = view;
        QZoneAsyncTextView qZoneAsyncTextView = (QZoneAsyncTextView) view.findViewById(R.id.mk9);
        this.f420514e = qZoneAsyncTextView;
        qZoneAsyncTextView.setOnLongClickListener(new View.OnLongClickListener() { // from class: nn.c
            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(View view2) {
                boolean y16;
                y16 = e.y(view2);
                return y16;
            }
        });
        this.f420514e.setOnClickListener(new View.OnClickListener() { // from class: nn.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                e.this.z(view2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public int[] getViewStubLayoutId() {
        return new int[]{R.id.mku};
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    /* renamed from: A, reason: merged with bridge method [inline-methods] */
    public void onBindData(bn.g gVar, int i3, List<Object> list) {
        if (gVar == null) {
            return;
        }
        B();
        u(this.f420515f);
    }
}
