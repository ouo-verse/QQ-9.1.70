package com.tencent.biz.qqcircle.debug;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.qqcircle.debug.controller.QFSWnsController;
import com.tencent.biz.qqcircle.debug.controller.aa;
import com.tencent.biz.qqcircle.debug.controller.ab;
import com.tencent.biz.qqcircle.debug.controller.ac;
import com.tencent.biz.qqcircle.debug.controller.ad;
import com.tencent.biz.qqcircle.debug.controller.ae;
import com.tencent.biz.qqcircle.debug.controller.af;
import com.tencent.biz.qqcircle.debug.controller.ag;
import com.tencent.biz.qqcircle.debug.controller.ah;
import com.tencent.biz.qqcircle.debug.controller.ai;
import com.tencent.biz.qqcircle.debug.controller.aj;
import com.tencent.biz.qqcircle.debug.controller.ak;
import com.tencent.biz.qqcircle.debug.controller.al;
import com.tencent.biz.qqcircle.debug.controller.am;
import com.tencent.biz.qqcircle.debug.controller.an;
import com.tencent.biz.qqcircle.debug.controller.ao;
import com.tencent.biz.qqcircle.debug.controller.ap;
import com.tencent.biz.qqcircle.debug.controller.aq;
import com.tencent.biz.qqcircle.debug.controller.ar;
import com.tencent.biz.qqcircle.debug.controller.as;
import com.tencent.biz.qqcircle.debug.controller.at;
import com.tencent.biz.qqcircle.debug.controller.au;
import com.tencent.biz.qqcircle.debug.controller.av;
import com.tencent.biz.qqcircle.debug.controller.aw;
import com.tencent.biz.qqcircle.debug.controller.ax;
import com.tencent.biz.qqcircle.debug.controller.ay;
import com.tencent.biz.qqcircle.debug.controller.ba;
import com.tencent.biz.qqcircle.debug.controller.bb;
import com.tencent.biz.qqcircle.debug.controller.bc;
import com.tencent.biz.qqcircle.debug.controller.bd;
import com.tencent.biz.qqcircle.debug.controller.be;
import com.tencent.biz.qqcircle.debug.controller.bf;
import com.tencent.biz.qqcircle.debug.controller.bg;
import com.tencent.biz.qqcircle.debug.controller.bh;
import com.tencent.biz.qqcircle.debug.controller.bi;
import com.tencent.biz.qqcircle.debug.controller.bl;
import com.tencent.biz.qqcircle.debug.controller.bm;
import com.tencent.biz.qqcircle.debug.controller.bn;
import com.tencent.biz.qqcircle.debug.controller.bo;
import com.tencent.biz.qqcircle.debug.controller.bp;
import com.tencent.biz.qqcircle.debug.controller.bq;
import com.tencent.biz.qqcircle.debug.controller.br;
import com.tencent.biz.qqcircle.debug.controller.bt;
import com.tencent.biz.qqcircle.debug.controller.ca;
import com.tencent.biz.qqcircle.debug.controller.cd;
import com.tencent.biz.qqcircle.debug.controller.ce;
import com.tencent.biz.qqcircle.debug.controller.cf;
import com.tencent.biz.qqcircle.debug.controller.cg;
import com.tencent.biz.qqcircle.debug.controller.ch;
import com.tencent.biz.qqcircle.debug.controller.ci;
import com.tencent.biz.qqcircle.debug.controller.cj;
import com.tencent.biz.qqcircle.debug.controller.ck;
import com.tencent.biz.qqcircle.debug.controller.cl;
import com.tencent.biz.qqcircle.debug.controller.cm;
import com.tencent.biz.qqcircle.debug.controller.h;
import com.tencent.biz.qqcircle.debug.controller.i;
import com.tencent.biz.qqcircle.debug.controller.q;
import com.tencent.biz.qqcircle.debug.controller.r;
import com.tencent.biz.qqcircle.debug.controller.s;
import com.tencent.biz.qqcircle.debug.controller.t;
import com.tencent.biz.qqcircle.debug.controller.u;
import com.tencent.biz.qqcircle.debug.controller.v;
import com.tencent.biz.qqcircle.debug.controller.w;
import com.tencent.biz.qqcircle.debug.controller.x;
import com.tencent.biz.qqcircle.debug.controller.z;
import com.tencent.biz.qqcircle.fragments.QCircleBaseFragment;
import com.tencent.biz.qqcircle.report.check.qfsimpl.api.QFSTestRegisterEvent;
import com.tencent.biz.richframework.part.Part;
import com.tencent.biz.richframework.part.block.base.SafeLinearLayoutManager;
import com.tencent.mobileqq.R;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QCircleDebugFragment extends QCircleBaseFragment {
    private RecyclerView C;
    private ImageView D;
    private c E;
    protected RecyclerView.LayoutManager F;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            QCircleDebugFragment.this.getActivity().finish();
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    private void initData() {
        ph();
        Collection<com.tencent.qcircle.cooperation.config.debug.a> c16 = com.tencent.qcircle.cooperation.config.debug.c.c();
        synchronized (c16) {
            Iterator<com.tencent.qcircle.cooperation.config.debug.a> it = c16.iterator();
            while (it.hasNext()) {
                this.E.addData(it.next());
            }
        }
    }

    private void initView(View view) {
        ImageView imageView = (ImageView) view.findViewById(R.id.f30870pi);
        this.D = imageView;
        imageView.setOnClickListener(new a());
        this.C = (RecyclerView) view.findViewById(R.id.f30890pk);
        SafeLinearLayoutManager safeLinearLayoutManager = new SafeLinearLayoutManager(getContext(), 1, false);
        this.F = safeLinearLayoutManager;
        this.C.setLayoutManager(safeLinearLayoutManager);
        this.E = new c();
        initData();
        this.C.setAdapter(this.E);
    }

    @QFSTestRegisterEvent(id = "EVENT_REGISTER_DEBUG")
    private void ph() {
        com.tencent.qcircle.cooperation.config.debug.c.a(ba.class);
        com.tencent.qcircle.cooperation.config.debug.c.a(bn.class);
        com.tencent.qcircle.cooperation.config.debug.c.a(ax.class);
        com.tencent.qcircle.cooperation.config.debug.c.a(r.class);
        com.tencent.qcircle.cooperation.config.debug.c.a(com.tencent.biz.qqcircle.debug.controller.e.class);
        com.tencent.qcircle.cooperation.config.debug.c.a(bd.class);
        com.tencent.qcircle.cooperation.config.debug.c.a(al.class);
        com.tencent.qcircle.cooperation.config.debug.c.a(ai.class);
        com.tencent.qcircle.cooperation.config.debug.c.a(aj.class);
        com.tencent.qcircle.cooperation.config.debug.c.a(h.class);
        com.tencent.qcircle.cooperation.config.debug.c.a(ak.class);
        com.tencent.qcircle.cooperation.config.debug.c.a(am.class);
        com.tencent.qcircle.cooperation.config.debug.c.a(com.tencent.biz.qqcircle.debug.controller.c.class);
        com.tencent.qcircle.cooperation.config.debug.c.a(u.class);
        com.tencent.qcircle.cooperation.config.debug.c.a(an.class);
        com.tencent.qcircle.cooperation.config.debug.c.a(v.class);
        com.tencent.qcircle.cooperation.config.debug.c.a(bb.class);
        com.tencent.qcircle.cooperation.config.debug.c.a(aw.class);
        com.tencent.qcircle.cooperation.config.debug.c.a(bi.class);
        com.tencent.qcircle.cooperation.config.debug.c.a(ar.class);
        com.tencent.qcircle.cooperation.config.debug.c.a(i.class);
        com.tencent.qcircle.cooperation.config.debug.c.a(aq.class);
        com.tencent.qcircle.cooperation.config.debug.c.a(ap.class);
        com.tencent.qcircle.cooperation.config.debug.c.a(ac.class);
        com.tencent.qcircle.cooperation.config.debug.c.a(aa.class);
        com.tencent.qcircle.cooperation.config.debug.c.a(x.class);
        com.tencent.qcircle.cooperation.config.debug.c.a(com.tencent.biz.qqcircle.debug.controller.d.class);
        com.tencent.qcircle.cooperation.config.debug.c.a(bh.class);
        com.tencent.qcircle.cooperation.config.debug.c.a(bm.class);
        com.tencent.qcircle.cooperation.config.debug.c.a(av.class);
        com.tencent.qcircle.cooperation.config.debug.c.a(QFSWnsController.class);
        com.tencent.qcircle.cooperation.config.debug.c.a(as.class);
        com.tencent.qcircle.cooperation.config.debug.c.a(bq.class);
        com.tencent.qcircle.cooperation.config.debug.c.a(bg.class);
        com.tencent.qcircle.cooperation.config.debug.c.a(au.class);
        com.tencent.qcircle.cooperation.config.debug.c.a(ao.class);
        com.tencent.qcircle.cooperation.config.debug.c.a(bc.class);
        com.tencent.qcircle.cooperation.config.debug.c.a(com.tencent.biz.qqcircle.debug.controller.g.class);
        com.tencent.qcircle.cooperation.config.debug.c.a(ci.class);
        com.tencent.qcircle.cooperation.config.debug.c.a(ck.class);
        com.tencent.qcircle.cooperation.config.debug.c.a(cl.class);
        com.tencent.qcircle.cooperation.config.debug.c.a(be.class);
        com.tencent.qcircle.cooperation.config.debug.c.a(bo.class);
        com.tencent.qcircle.cooperation.config.debug.c.a(cm.class);
        com.tencent.qcircle.cooperation.config.debug.c.a(com.tencent.biz.qqcircle.debug.controller.b.class);
        com.tencent.qcircle.cooperation.config.debug.c.a(br.class);
        com.tencent.qcircle.cooperation.config.debug.c.a(ag.class);
        com.tencent.qcircle.cooperation.config.debug.c.a(ad.class);
        com.tencent.qcircle.cooperation.config.debug.c.a(ah.class);
        com.tencent.qcircle.cooperation.config.debug.c.a(ab.class);
        com.tencent.qcircle.cooperation.config.debug.c.a(w.class);
        com.tencent.qcircle.cooperation.config.debug.c.a(q.class);
        com.tencent.qcircle.cooperation.config.debug.c.a(s.class);
        com.tencent.qcircle.cooperation.config.debug.c.a(t.class);
        com.tencent.qcircle.cooperation.config.debug.c.a(com.tencent.biz.qqcircle.debug.controller.a.class);
        com.tencent.qcircle.cooperation.config.debug.c.a(z.class);
        com.tencent.qcircle.cooperation.config.debug.c.a(bl.class);
        com.tencent.qcircle.cooperation.config.debug.c.a(ca.class);
        com.tencent.qcircle.cooperation.config.debug.c.a(cj.class);
        com.tencent.qcircle.cooperation.config.debug.c.a(cd.class);
        com.tencent.qcircle.cooperation.config.debug.c.a(ae.class);
        com.tencent.qcircle.cooperation.config.debug.c.a(bf.class);
        com.tencent.qcircle.cooperation.config.debug.c.a(at.class);
        com.tencent.qcircle.cooperation.config.debug.c.a(ch.class);
        com.tencent.qcircle.cooperation.config.debug.c.a(bt.class);
        com.tencent.qcircle.cooperation.config.debug.c.a(ce.class);
        com.tencent.qcircle.cooperation.config.debug.c.a(cf.class);
        com.tencent.qcircle.cooperation.config.debug.c.a(cg.class);
        com.tencent.qcircle.cooperation.config.debug.c.a(bp.class);
        com.tencent.qcircle.cooperation.config.debug.c.a(af.class);
        com.tencent.qcircle.cooperation.config.debug.c.a(ay.class);
    }

    @Override // com.tencent.biz.richframework.part.interfaces.IPartHost
    public List<Part> assembleParts() {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.g2s;
    }

    @Override // com.tencent.biz.qqcircle.fragments.QCircleBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QCircleDebugFragment";
    }

    @Override // com.tencent.biz.qqcircle.fragments.QCircleBaseFragment
    public int getPageId() {
        return 0;
    }

    @Override // com.tencent.biz.qqcircle.fragments.QCircleBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        if (getView() == null) {
            return;
        }
        initView(getView());
    }
}
