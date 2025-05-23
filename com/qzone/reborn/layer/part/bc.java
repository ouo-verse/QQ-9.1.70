package com.qzone.reborn.layer.part;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.ImageView;
import com.qzone.reborn.albumx.qzonex.bean.layer.QZAlbumxLayerExtraInfoBean;
import com.qzone.reborn.feedx.util.QZoneFeedxViewUtils;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.libra.LoadState;
import com.tencent.libra.listener.IPicLoadStateListener;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.common.picload.QQPicLoader;
import com.tencent.mobileqq.widget.tip.a;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.richframework.gallery.bean.RFWLayerItemMediaInfo;
import com.tencent.richframework.gallery.bean.RFWLayerState;
import com.tencent.richframework.thread.RFWThreadManager;
import cooperation.qzone.model.PhotoInfo;

/* compiled from: P */
/* loaded from: classes37.dex */
public class bc extends o {
    private final int H;
    private View I;
    private ImageView J;
    private String K;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes37.dex */
    public class a implements IPicLoadStateListener {
        a() {
        }

        @Override // com.tencent.libra.listener.IPicLoadStateListener
        public void onStateChange(LoadState loadState, Option option) {
            if (loadState.isFinishSuccess() && (option.getAnimatable() instanceof r01.c)) {
                QLog.d(bc.this.getTAG(), 1, "showRepairEntranceAnim anim load success");
                r01.c cVar = (r01.c) option.getAnimatable();
                cVar.setLoopCount(0);
                cVar.start();
                return;
            }
            QLog.d(bc.this.getTAG(), 1, "showRepairEntranceAnim anim load error");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes37.dex */
    public class b implements a.b {
        b() {
        }

        @Override // com.tencent.mobileqq.widget.tip.a.b
        public void onClick(View view) {
            QLog.d(bc.this.getTAG(), 1, "initShowPhotoRepairBubbleTip onClick");
        }

        @Override // com.tencent.mobileqq.widget.tip.a.b
        public void onDismiss() {
            QLog.d(bc.this.getTAG(), 1, "initShowPhotoRepairBubbleTip onDismiss");
        }

        @Override // com.tencent.mobileqq.widget.tip.a.b
        public void onShow() {
            QLog.d(bc.this.getTAG(), 1, "initShowPhotoRepairBubbleTip onShow");
            com.qzone.reborn.repair.utils.a.f59293a.h();
        }
    }

    public bc() {
        this(50);
    }

    private PhotoInfo S9() {
        PhotoInfo photoInfo = this.f57984d;
        if (photoInfo != null) {
            return photoInfo;
        }
        RFWLayerItemMediaInfo rFWLayerItemMediaInfo = this.mCurrentSelectedItem;
        if (rFWLayerItemMediaInfo == null || !(rFWLayerItemMediaInfo.getExtraData() instanceof QZAlbumxLayerExtraInfoBean)) {
            return null;
        }
        QZAlbumxLayerExtraInfoBean qZAlbumxLayerExtraInfoBean = (QZAlbumxLayerExtraInfoBean) this.mCurrentSelectedItem.getExtraData();
        PhotoInfo photoInfo2 = new PhotoInfo();
        photoInfo2.albumId = qZAlbumxLayerExtraInfoBean.getAlbumId();
        photoInfo2.lloc = qZAlbumxLayerExtraInfoBean.getLLoc();
        photoInfo2.currentUrl = this.mCurrentSelectedItem.getLayerPicInfo().getCurrentPicInfo().getUrl();
        photoInfo2.bigUrl = this.mCurrentSelectedItem.getLayerPicInfo().getCurrentPicInfo().getUrl();
        photoInfo2.isShowRepair = qZAlbumxLayerExtraInfoBean.getIsShowRepair();
        return photoInfo2;
    }

    private void T9() {
        ImageView imageView = this.J;
        if (imageView != null) {
            imageView.setVisibility(8);
        }
        this.K = "";
    }

    private void U9() {
        View view = this.I;
        if (view != null) {
            view.setVisibility(8);
        }
    }

    private void V9() {
        if (this.I == null) {
            View inflate = ((ViewStub) getActivity().findViewById(R.id.mnv)).inflate();
            this.I = inflate.findViewById(R.id.mnx);
            com.tencent.mobileqq.qzone.picload.c.a().m((ImageView) inflate.findViewById(R.id.mnw), getActivity().getColor(R.color.qui_common_text_allwhite_primary));
            fo.c.o(this.I, "em_qz_pic_repair", null);
            this.I.setOnClickListener(new View.OnClickListener() { // from class: com.qzone.reborn.layer.part.az
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    bc.this.X9(view);
                }
            });
            ImageView imageView = (ImageView) inflate.findViewById(R.id.nas);
            this.J = imageView;
            fo.c.o(imageView, "em_qz_pic_repair", null);
            this.J.setOnClickListener(new View.OnClickListener() { // from class: com.qzone.reborn.layer.part.ba
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    bc.this.Y9(view);
                }
            });
            int e16 = com.qzone.util.ar.e(10.0f);
            QZoneFeedxViewUtils.a(this.I, e16, e16, e16, e16);
            QZoneFeedxViewUtils.a(this.J, e16, e16, e16, e16);
            int d16 = com.qzone.util.ar.d(this.H);
            if (inflate.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                ((ViewGroup.MarginLayoutParams) inflate.getLayoutParams()).setMargins(0, 0, d16, 0);
            }
        }
    }

    private void W9(final View view) {
        if (ca() && com.qzone.reborn.repair.utils.a.f59293a.d()) {
            RFWThreadManager.getInstance().postMainDelay(new Runnable() { // from class: com.qzone.reborn.layer.part.bb
                @Override // java.lang.Runnable
                public final void run() {
                    bc.this.Z9(view);
                }
            }, 1000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void X9(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        da();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Y9(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        da();
        com.qzone.reborn.repair.utils.a.f59293a.g();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Z9(View view) {
        com.tencent.mobileqq.widget.tip.a.r(view.getContext()).S(view).k0(1).R(0).o0(com.qzone.util.l.a(R.string.wa_)).j0(10.0f, 8.0f, 10.0f, 8.0f).W(view.getResources().getColor(R.color.qui_common_bg_top_light)).p0(view.getResources().getColor(R.color.qui_common_text_primary)).f(new b()).s0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void aa(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        da();
        EventCollector.getInstance().onViewClicked(view);
    }

    private boolean ba() {
        return com.qzone.reborn.repair.utils.a.f59293a.c();
    }

    private boolean ca() {
        RFWLayerItemMediaInfo rFWLayerItemMediaInfo = this.mCurrentSelectedItem;
        if (rFWLayerItemMediaInfo != null && !rFWLayerItemMediaInfo.isVideo()) {
            PhotoInfo S9 = S9();
            boolean z16 = S9 != null && S9.isShowRepair;
            RFWLog.d(getTAG(), RFWLog.USR, "updatePhotoRepairEntrance, isShowRepair: " + z16 + ", photoInfo: " + S9);
            return z16;
        }
        RFWLog.d(getTAG(), RFWLog.USR, "shouldShowRepairIcon no show, isVideo");
        return false;
    }

    private void da() {
        PhotoInfo S9 = S9();
        if (S9 != null) {
            new p018do.i(getActivity(), new wn.b(S9, this.f57988i, 2)).show();
        }
    }

    private void ea() {
        if (this.J == null) {
            return;
        }
        PhotoInfo S9 = S9();
        if (S9 != null) {
            if (TextUtils.equals(this.K, S9.lloc)) {
                QLog.d(getTAG(), 1, "showRepairEntranceAnim mCurrentLloc is equals");
                return;
            }
            this.K = S9.lloc;
        }
        this.J.setVisibility(0);
        QQPicLoader.f201806a.e(Option.obtain().setPreferDecoder(com.tencent.libra.extension.a.class).setNeedShowLoadingDrawable(false).setUrl("https://qzonestyle.gtimg.cn/qzone/client/mqq/photo-album/colorbutton48.zip").setTargetView(this.J), new a());
        W9(this.J);
    }

    private void ga() {
        View view = this.I;
        if (view == null) {
            return;
        }
        view.setVisibility(0);
        fo.c.o(this.I, "em_qz_pic_repair", null);
        this.I.setOnClickListener(new View.OnClickListener() { // from class: com.qzone.reborn.layer.part.ay
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                bc.this.aa(view2);
            }
        });
        W9(this.I);
    }

    private void ha() {
        if (this.I == null) {
            V9();
        }
        if (ca()) {
            if (ba()) {
                ea();
                U9();
                return;
            } else {
                ga();
                T9();
                return;
            }
        }
        U9();
        T9();
    }

    @Override // com.tencent.biz.richframework.part.Part
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QZoneLayerHeaderRepairIconPart";
    }

    @Override // com.qzone.reborn.layer.part.o, com.tencent.biz.richframework.part.Part
    public void onInitView(View view) {
        super.onInitView(view);
        ha();
    }

    @Override // com.qzone.reborn.layer.part.ap
    public void onLayerStateUpdate(RFWLayerState rFWLayerState) {
        ha();
    }

    public bc(int i3) {
        this.K = "";
        this.H = i3;
    }
}
