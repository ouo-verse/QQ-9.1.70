package ln;

import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;
import qzonemoment.QZMomentMeta$StReply;

/* compiled from: P */
/* loaded from: classes38.dex */
public class u extends b {

    /* renamed from: i, reason: collision with root package name */
    private TextView f415043i;

    /* renamed from: m, reason: collision with root package name */
    private TextView f415044m;

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void y(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        v();
        EventCollector.getInstance().onViewClicked(view);
    }

    protected void B(long j3) {
        TextView textView = this.f415043i;
        if (textView == null) {
            return;
        }
        textView.setText(rn.a.b(j3 * 1000));
    }

    @Override // ln.b, com.tencent.biz.richframework.part.adapter.section.Section
    protected void onInitView(View view) {
        super.onInitView(view);
        this.f415043i = (TextView) view.findViewById(R.id.f162773mk1);
        TextView textView = (TextView) view.findViewById(R.id.ml_);
        this.f415044m = textView;
        textView.setOnClickListener(new View.OnClickListener() { // from class: ln.t
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                u.this.y(view2);
            }
        });
        u(this.f415044m);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public int[] getViewStubLayoutId() {
        return new int[]{R.id.mk8};
    }

    private void A(QZMomentMeta$StReply qZMomentMeta$StReply) {
        if (qZMomentMeta$StReply == null) {
            return;
        }
        B(qZMomentMeta$StReply.createTime.get());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    /* renamed from: z, reason: merged with bridge method [inline-methods] */
    public void onBindData(com.qzone.reborn.qzmoment.comment.f fVar, int i3, List<Object> list) {
        if (fVar == null) {
            return;
        }
        QZMomentMeta$StReply qZMomentMeta$StReply = fVar.f58884b;
        this.f415014f = qZMomentMeta$StReply;
        this.f415015h = fVar.f58885c;
        A(qZMomentMeta$StReply);
    }
}
