package com.tencent.biz.qqcircle.debug.mocklbs;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.qqcircle.debug.controller.j;
import com.tencent.biz.qqcircle.debug.controller.k;
import com.tencent.biz.qqcircle.debug.controller.l;
import com.tencent.biz.qqcircle.debug.controller.m;
import com.tencent.biz.qqcircle.debug.controller.n;
import com.tencent.biz.qqcircle.debug.controller.o;
import com.tencent.biz.qqcircle.debug.controller.p;
import com.tencent.biz.qqcircle.fragments.QCircleBaseFragment;
import com.tencent.biz.richframework.part.Part;
import com.tencent.biz.richframework.part.block.base.SafeLinearLayoutManager;
import com.tencent.mobileqq.R;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes4.dex */
public class QCircleDebugPublishTipsFragment extends QCircleBaseFragment {
    private RecyclerView C;
    private ImageView D;
    private com.tencent.biz.qqcircle.debug.c E;
    protected RecyclerView.LayoutManager F;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            QCircleDebugPublishTipsFragment.this.getActivity().finish();
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    private void initData() {
        this.E.addData(new k());
        this.E.addData(new l());
        this.E.addData(new m());
        this.E.addData(new n());
        this.E.addData(new o());
        this.E.addData(new p());
        this.E.addData(new j());
    }

    private void initView(View view) {
        ImageView imageView = (ImageView) view.findViewById(R.id.f30870pi);
        this.D = imageView;
        imageView.setOnClickListener(new a());
        this.C = (RecyclerView) view.findViewById(R.id.f30890pk);
        SafeLinearLayoutManager safeLinearLayoutManager = new SafeLinearLayoutManager(getContext(), 1, false);
        this.F = safeLinearLayoutManager;
        this.C.setLayoutManager(safeLinearLayoutManager);
        this.E = new com.tencent.biz.qqcircle.debug.c();
        initData();
        this.C.setAdapter(this.E);
    }

    @Override // com.tencent.biz.richframework.part.interfaces.IPartHost
    public List<Part> assembleParts() {
        return new ArrayList();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.g2u;
    }

    @Override // com.tencent.biz.qqcircle.fragments.QCircleBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QCircleDebugPublishTipsFragment";
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
