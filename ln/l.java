package ln;

import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;
import qzonemoment.QZMomentMeta$StComment;

/* compiled from: P */
/* loaded from: classes38.dex */
public class l extends a {

    /* renamed from: h, reason: collision with root package name */
    private TextView f415032h;

    /* renamed from: i, reason: collision with root package name */
    private TextView f415033i;

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void y(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        v();
        EventCollector.getInstance().onViewClicked(view);
    }

    protected void B(long j3) {
        TextView textView = this.f415032h;
        if (textView == null) {
            return;
        }
        textView.setText(rn.a.b(j3 * 1000));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ln.a, com.tencent.biz.richframework.part.adapter.section.Section
    public void onInitView(View view) {
        super.onInitView(view);
        this.f415032h = (TextView) view.findViewById(R.id.f162773mk1);
        TextView textView = (TextView) view.findViewById(R.id.ml_);
        this.f415033i = textView;
        textView.setOnClickListener(new View.OnClickListener() { // from class: ln.k
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                l.this.y(view2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    /* renamed from: z, reason: merged with bridge method [inline-methods] */
    public void onBindData(QZMomentMeta$StComment qZMomentMeta$StComment, int i3, List<Object> list) {
        this.f415010f = qZMomentMeta$StComment;
        A(qZMomentMeta$StComment);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public int[] getViewStubLayoutId() {
        return new int[]{R.id.mk8};
    }

    private void A(QZMomentMeta$StComment qZMomentMeta$StComment) {
        if (qZMomentMeta$StComment == null) {
            return;
        }
        B(qZMomentMeta$StComment.createTime.get());
    }
}
