package com.tencent.biz.qqcircle.immersive;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.biz.qqcircle.beans.QCircleShoppingGoodsInfoBean;
import com.tencent.biz.qqcircle.immersive.part.fh;
import com.tencent.biz.qqcircle.immersive.part.fj;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.R;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSShoppingGoodsLayerFragment extends QFSBaseFragment {
    private fh E;
    private fj F;
    private QCircleShoppingGoodsInfoBean G;

    private void initIntentData() {
        Intent intent;
        if (getActivity() != null && (intent = getActivity().getIntent()) != null) {
            Serializable serializableExtra = intent.getSerializableExtra("key_bundle_common_init_bean");
            if (serializableExtra instanceof QCircleShoppingGoodsInfoBean) {
                this.G = (QCircleShoppingGoodsInfoBean) serializableExtra;
            }
        }
    }

    private fj rh() {
        Bundle bundle = new Bundle();
        QCircleShoppingGoodsInfoBean qCircleShoppingGoodsInfoBean = this.G;
        if (qCircleShoppingGoodsInfoBean != null) {
            bundle.putSerializable("key_bundle_common_init_bean", qCircleShoppingGoodsInfoBean);
        }
        return new fj(bundle);
    }

    private fh sh() {
        Bundle bundle = new Bundle();
        QCircleShoppingGoodsInfoBean qCircleShoppingGoodsInfoBean = this.G;
        if (qCircleShoppingGoodsInfoBean != null) {
            bundle.putSerializable("key_bundle_common_init_bean", qCircleShoppingGoodsInfoBean);
        }
        return new fh(bundle);
    }

    @Override // com.tencent.biz.richframework.part.interfaces.IPartHost
    public List<Part> assembleParts() {
        initIntentData();
        ArrayList arrayList = new ArrayList();
        fj rh5 = rh();
        this.F = rh5;
        arrayList.add(rh5);
        fh sh5 = sh();
        this.E = sh5;
        arrayList.add(sh5);
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.g5t;
    }

    @Override // com.tencent.biz.qqcircle.fragments.QCircleBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QFSShoppingGoodsLayerFragment";
    }

    @Override // com.tencent.biz.qqcircle.fragments.QCircleBaseFragment
    public int getPageId() {
        return 0;
    }
}
