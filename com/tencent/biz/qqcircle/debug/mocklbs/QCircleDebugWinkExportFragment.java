package com.tencent.biz.qqcircle.debug.mocklbs;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.qqcircle.debug.controller.bu;
import com.tencent.biz.qqcircle.debug.controller.bv;
import com.tencent.biz.qqcircle.debug.controller.bw;
import com.tencent.biz.qqcircle.debug.controller.bx;
import com.tencent.biz.qqcircle.debug.controller.bz;
import com.tencent.biz.qqcircle.debug.controller.cb;
import com.tencent.biz.qqcircle.debug.controller.cc;
import com.tencent.biz.qqcircle.debug.controller.y;
import com.tencent.biz.qqcircle.fragments.QCircleBaseFragment;
import com.tencent.biz.richframework.part.Part;
import com.tencent.biz.richframework.part.block.base.SafeLinearLayoutManager;
import com.tencent.mobileqq.R;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QCircleDebugWinkExportFragment extends QCircleBaseFragment {
    private RecyclerView C;
    private ImageView D;
    private com.tencent.biz.qqcircle.debug.c E;
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
            QCircleDebugWinkExportFragment.this.getActivity().finish();
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    private void initData() {
        this.E.addData(new y());
        this.E.addData(new bw());
        this.E.addData(new bx());
        this.E.addData(new bz());
        this.E.addData(new cc());
        this.E.addData(new cb());
        this.E.addData(new bu());
        this.E.addData(new bv());
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
        return "QCircleDebugWinkExportFragment";
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
