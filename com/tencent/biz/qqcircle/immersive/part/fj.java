package com.tencent.biz.qqcircle.immersive.part;

import android.os.Bundle;
import android.view.View;
import androidx.viewpager2.widget.ViewPager2;
import com.tencent.biz.qqcircle.beans.QCircleShoppingGoodsInfoBean;
import com.tencent.biz.qqcircle.events.QCircleShoppingLayerExitEvent;
import com.tencent.biz.qqcircle.immersive.views.banner.QFSImageBanner;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import java.io.Serializable;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes4.dex */
public class fj extends u {

    /* renamed from: d, reason: collision with root package name */
    private QFSImageBanner f88111d;

    /* renamed from: e, reason: collision with root package name */
    private Bundle f88112e;

    /* renamed from: f, reason: collision with root package name */
    private ArrayList<String> f88113f = new ArrayList<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class a extends ViewPager2.OnPageChangeCallback {
        a() {
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageScrolled(int i3, float f16, int i16) {
            super.onPageScrolled(i3, f16, i16);
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageSelected(int i3) {
            super.onPageSelected(i3);
            fj.this.broadcastMessage("qfs_shopping_goods_layer_index_update", Integer.valueOf(i3));
            SimpleEventBus.getInstance().dispatchEvent(new QCircleShoppingLayerExitEvent(i3));
        }
    }

    public fj(Bundle bundle) {
        this.f88112e = bundle;
    }

    private void initBanner() {
        if (this.f88111d == null) {
            QLog.e("QFSShoppingGoodsLayerPart", 1, "[initBanner] -> mBanner == null ");
            return;
        }
        Bundle bundle = this.f88112e;
        if (bundle == null) {
            QLog.e("QFSShoppingGoodsLayerPart", 1, "[initBanner] -> mInitParams == null ");
            return;
        }
        Serializable serializable = bundle.getSerializable("key_bundle_common_init_bean");
        if (!(serializable instanceof QCircleShoppingGoodsInfoBean)) {
            QLog.e("QFSShoppingGoodsLayerPart", 1, "[initBanner] -> !(serializable instanceof QCircleInitBean) ");
            return;
        }
        QCircleShoppingGoodsInfoBean qCircleShoppingGoodsInfoBean = (QCircleShoppingGoodsInfoBean) serializable;
        ArrayList<String> imageUrls = qCircleShoppingGoodsInfoBean.getImageUrls();
        this.f88113f = imageUrls;
        this.f88111d.setAdapter(new com.tencent.biz.qqcircle.immersive.views.banner.j(imageUrls));
        this.f88111d.X().registerOnPageChangeCallback(new a());
        this.f88111d.setCurrentItem(Math.max(qCircleShoppingGoodsInfoBean.getCurPos() - 1, 0), false);
        this.f88111d.setOnItemClickListener(new QFSImageBanner.c() { // from class: com.tencent.biz.qqcircle.immersive.part.fi
            @Override // com.tencent.biz.qqcircle.immersive.views.banner.QFSImageBanner.c
            public final void onItemClick(int i3) {
                fj.this.z9(i3);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void z9(int i3) {
        QLog.i("QFSShoppingGoodsLayerPart", 1, "[setOnItemClickListener] -> position = " + i3);
        if (getActivity() != null) {
            getActivity().finish();
            getActivity().overridePendingTransition(0, 0);
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QFSShoppingGoodsLayerPart";
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View view) {
        super.onInitView(view);
        this.f88111d = (QFSImageBanner) view.findViewById(R.id.f54572fk);
        initBanner();
    }
}
