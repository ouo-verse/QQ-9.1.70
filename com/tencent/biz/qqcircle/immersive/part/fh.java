package com.tencent.biz.qqcircle.immersive.part;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.qqcircle.beans.QCircleShoppingGoodsInfoBean;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.io.Serializable;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes4.dex */
public class fh extends u implements View.OnClickListener {

    /* renamed from: d, reason: collision with root package name */
    private ArrayList<String> f88105d;

    /* renamed from: e, reason: collision with root package name */
    private int f88106e;

    /* renamed from: f, reason: collision with root package name */
    private int f88107f;

    /* renamed from: h, reason: collision with root package name */
    private ImageView f88108h;

    /* renamed from: i, reason: collision with root package name */
    private TextView f88109i;

    public fh(Bundle bundle) {
        this.f88105d = new ArrayList<>();
        Serializable serializable = bundle.getSerializable("key_bundle_common_init_bean");
        if (serializable instanceof QCircleShoppingGoodsInfoBean) {
            QCircleShoppingGoodsInfoBean qCircleShoppingGoodsInfoBean = (QCircleShoppingGoodsInfoBean) serializable;
            this.f88105d = qCircleShoppingGoodsInfoBean.getImageUrls();
            this.f88107f = qCircleShoppingGoodsInfoBean.getCurPos();
            this.f88106e = this.f88105d.size();
        }
    }

    private void x9() {
        this.f88109i.setText(this.f88107f + "/" + this.f88106e);
    }

    private void z9(int i3) {
        String format = String.format(com.tencent.biz.qqcircle.utils.h.a(R.string.f196564hn), Integer.valueOf(i3 + 1), Integer.valueOf(this.f88106e));
        if (this.f88109i == null) {
            QLog.e("QFSShoppingGoodsLayerOperationPart", 1, "[updatePosition] mTvPosition is null");
        } else if (TextUtils.isEmpty(format)) {
            QLog.e("QFSShoppingGoodsLayerOperationPart", 1, "[updatePosition] text is null");
        } else {
            this.f88109i.setText(format);
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QFSShoppingGoodsLayerOperationPart";
    }

    @Override // com.tencent.biz.qqcircle.immersive.part.u, com.tencent.biz.richframework.part.Part
    public void handleBroadcastMessage(String str, Object obj) {
        if (TextUtils.equals(str, "qfs_shopping_goods_layer_index_update") && (obj instanceof Integer)) {
            z9(((Integer) obj).intValue());
        }
        super.handleBroadcastMessage(str, obj);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (view.getId() == R.id.f44171og && getActivity() != null) {
            getActivity().finish();
            getActivity().overridePendingTransition(0, 0);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View view) {
        super.onInitView(view);
        this.f88108h = (ImageView) view.findViewById(R.id.f44171og);
        this.f88109i = (TextView) view.findViewById(R.id.f56552kx);
        this.f88108h.setOnClickListener(this);
        x9();
    }
}
