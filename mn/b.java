package mn;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.HashMap;
import java.util.List;

/* compiled from: P */
/* loaded from: classes38.dex */
public class b extends mn.a {

    /* renamed from: e, reason: collision with root package name */
    private ImageView f417006e;

    /* renamed from: f, reason: collision with root package name */
    private TextView f417007f;

    /* renamed from: h, reason: collision with root package name */
    private TextView f417008h;

    /* compiled from: P */
    /* loaded from: classes38.dex */
    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            rn.d.d(b.this.p(), view);
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void w() {
        HashMap hashMap = new HashMap();
        hashMap.put("operated_feed", ((bn.b) this.mData).a().f430362id.get());
        hashMap.put("author_id", ((bn.b) this.mData).a().poster.f430367id.get());
        fo.c.o(this.f417008h, "em_bas_time_publication", new fo.b().l(hashMap).i(((bn.b) this.mData).a().f430362id.get()));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mn.a, com.tencent.biz.richframework.part.adapter.section.Section
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QZMFeedBlurPublishGuidePresenter";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    /* renamed from: x, reason: merged with bridge method [inline-methods] */
    public void onBindData(bn.b bVar, int i3, List<Object> list) {
        if (u()) {
            getStubView(R.id.mkd).setVisibility(0);
            w();
        } else {
            getStubView(R.id.mkd).setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public int[] getViewStubLayoutId() {
        return new int[]{R.id.mkd};
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public void onInitView(View view) {
        this.f417006e = (ImageView) view.findViewById(R.id.l2o);
        this.f417007f = (TextView) view.findViewById(R.id.njo);
        TextView textView = (TextView) view.findViewById(R.id.njn);
        this.f417008h = textView;
        textView.setOnClickListener(new a());
    }
}
