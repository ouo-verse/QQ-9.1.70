package oz;

import UserGrowth.stDrama;
import UserGrowth.stDramaInfo;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.biz.pubaccount.weishi.drama.WSDramaPageFragment;
import com.tencent.biz.pubaccount.weishi.image.WSPicLoader;
import com.tencent.biz.pubaccount.weishi.util.ba;
import com.tencent.biz.pubaccount.weishi.util.r;
import com.tencent.biz.pubaccount.weishi.view.RoundCornerImageView;
import com.tencent.mobileqq.R;
import com.tencent.widget.pull2refresh.BaseViewHolder;

/* compiled from: P */
/* loaded from: classes33.dex */
public class e extends BaseViewHolder<c> {
    private c C;

    /* renamed from: d, reason: collision with root package name */
    private RoundCornerImageView f424536d;

    /* renamed from: e, reason: collision with root package name */
    private TextView f424537e;

    /* renamed from: f, reason: collision with root package name */
    private TextView f424538f;

    /* renamed from: h, reason: collision with root package name */
    private TextView f424539h;

    /* renamed from: i, reason: collision with root package name */
    private TextView f424540i;

    /* renamed from: m, reason: collision with root package name */
    private WSDramaPageFragment f424541m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes33.dex */
    public class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (e.this.C == null) {
                return;
            }
            vz.a.n(e.this.f424541m, e.this.C.a(), e.this.C.b(), vz.a.f443765c);
            e.this.h();
        }
    }

    private int f() {
        return ((ba.o() - (ba.f81735j * 2)) - (ba.f81730e * 2)) / 3;
    }

    private void g() {
        this.f424536d = (RoundCornerImageView) this.itemView.findViewById(R.id.f75133y5);
        this.f424537e = (TextView) this.itemView.findViewById(R.id.f107556aq);
        this.f424538f = (TextView) this.itemView.findViewById(R.id.f107486aj);
        this.f424539h = (TextView) this.itemView.findViewById(R.id.f107536ao);
        this.f424540i = (TextView) this.itemView.findViewById(R.id.f107546ap);
        this.f424536d.setCorner(ba.f81748w, 0);
        this.itemView.setOnClickListener(new a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        pz.a Bd = this.f424541m.Bd();
        tz.a.h(vz.a.f(Bd), vz.a.g(Bd), vz.a.d(Bd), vz.a.c(Bd), this.C, this.f424541m.getFrom(), getAdapterPosition());
    }

    private void i(stDramaInfo stdramainfo) {
        StringBuilder sb5 = new StringBuilder();
        if (stdramainfo.isPublishCompleted) {
            sb5.append("\u5168");
            sb5.append(stdramainfo.curPublishedFeedNum);
            sb5.append("\u96c6");
        } else {
            sb5.append("\u66f4\u65b0\u5230");
            sb5.append(stdramainfo.curPublishedFeedNum);
            sb5.append("\u96c6");
        }
        this.f424538f.setText(sb5);
    }

    private void j() {
        ViewGroup.LayoutParams layoutParams = this.f424536d.getLayoutParams();
        layoutParams.width = f();
        layoutParams.height = (int) (f() * 1.3333334f);
        this.f424536d.setLayoutParams(layoutParams);
    }

    @Override // com.tencent.widget.pull2refresh.BaseViewHolder
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public void bindData(c cVar) {
        stDramaInfo stdramainfo;
        super.bindData(cVar);
        if (cVar == null) {
            return;
        }
        this.C = cVar;
        stDrama stdrama = cVar.f424527a;
        if (stdrama == null || (stdramainfo = stdrama.dramaInfo) == null) {
            return;
        }
        WSPicLoader.g().w(this.f424536d, stdramainfo.coverImg, r.i(R.color.f157202bw1));
        this.f424539h.setText(stdramainfo.name);
        if (getAdapterPosition() == 0 && cVar.e()) {
            this.f424537e.setVisibility(0);
        } else {
            this.f424537e.setVisibility(8);
        }
        i(stdramainfo);
        k(stdramainfo.curWatchedFeedNum, stdramainfo);
        j();
    }

    public void k(int i3, stDramaInfo stdramainfo) {
        int i16 = stdramainfo.curWatchedFeedNum;
        if (i3 <= i16) {
            i3 = i16;
        }
        TextView textView = this.f424540i;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("\u89c2\u770b\u5230\u7b2c");
        sb5.append(i3);
        sb5.append("\u96c6");
        textView.setText(sb5);
    }

    public e(ViewGroup viewGroup, WSDramaPageFragment wSDramaPageFragment) {
        super(viewGroup, R.layout.fvw);
        this.f424541m = wSDramaPageFragment;
        g();
    }
}
