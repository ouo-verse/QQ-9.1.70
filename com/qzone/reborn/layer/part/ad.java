package com.qzone.reborn.layer.part;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.lifecycle.MutableLiveData;
import com.qzone.common.business.result.QZoneResult;
import com.qzone.misc.network.report.ClickReport;
import com.qzone.preview.business.BasePicureViewController;
import com.qzone.preview.service.QZoneFeedxPictureManager;
import com.qzone.preview.service.QZoneInteractPhotoRequestBuilder;
import com.qzone.preview.service.base.PictureConst;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.richframework.data.base.UIStateData;
import com.tencent.richframework.gallery.bean.RFWLayerItemMediaInfo;
import com.tencent.richframework.gallery.bean.RFWLayerState;
import cooperation.qzone.model.PhotoInfo;
import cooperation.qzone.model.PhotoParam;
import java.util.HashMap;
import java.util.List;

/* compiled from: P */
/* loaded from: classes37.dex */
public class ad extends ap implements View.OnClickListener {
    private TextView G;
    private ImageView H;

    private void M9() {
        PhotoParam photoParam;
        if (com.qzone.reborn.feedx.util.l.b("QZoneFeedxLayerPraisePart", 200L) || this.f57984d == null) {
            return;
        }
        boolean P9 = P9();
        N9(this.f57984d);
        W9(Q9(), !P9);
        V9(A9());
        if (P9 && (photoParam = this.f57988i) != null && photoParam.isFriendPhotoBizFeed) {
            com.qzone.adapter.feedcomponent.i H = com.qzone.adapter.feedcomponent.i.H();
            int i3 = this.f57988i.businessPhotoFeedIndex;
            com.qzone.adapter.feedcomponent.i.H();
            H.U1(i3, "3");
        }
        ClickReport.m(S9(), "1", "");
        if (B9() != null) {
            B9().B7(P9);
        }
    }

    private String O9(PhotoInfo photoInfo) {
        if (this.f57988i != null && TextUtils.isEmpty(photoInfo.curkey)) {
            return this.f57988i.curKey;
        }
        return photoInfo.curkey;
    }

    private String R9(PhotoInfo photoInfo) {
        if (this.f57988i != null && TextUtils.isEmpty(photoInfo.unikey)) {
            return this.f57988i.orgKey;
        }
        return photoInfo.unikey;
    }

    private void W9(int i3, boolean z16) {
        AccessibilityUtil.n(this.G, false);
        if (i3 > 0) {
            this.G.setText(tk.h.p(i3));
        } else {
            this.G.setText(com.qzone.util.l.a(R.string.s3q));
        }
        X9(z16);
    }

    public boolean P9() {
        PhotoInfo photoInfo;
        PhotoParam photoParam = this.f57988i;
        if (photoParam != null && photoParam.appid == 311 && (photoInfo = this.f57984d) != null && photoInfo.isIndependentUgc == 0) {
            return photoParam.isLike;
        }
        PhotoInfo photoInfo2 = this.f57984d;
        return photoInfo2 != null && photoInfo2.hasPraise;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int Q9() {
        PhotoInfo photoInfo;
        PhotoParam photoParam = this.f57988i;
        if (photoParam == null || (photoInfo = this.f57984d) == null) {
            return 0;
        }
        int i3 = photoParam.appid;
        if (i3 != 4 && i3 != 202) {
            return photoParam.likeNum;
        }
        return photoInfo.praiseCount;
    }

    protected String S9() {
        return "582";
    }

    protected void V9(Handler handler) {
        PhotoParam photoParam;
        PhotoInfo photoInfo = this.f57984d;
        if (photoInfo == null || (photoParam = this.f57988i) == null) {
            return;
        }
        int i3 = 1;
        if (photoParam.isVideoPicMix && TextUtils.isEmpty(photoInfo.unikey)) {
            if (photoInfo.isIndependentUgc != 0 && !this.f57988i.isFriendPhotoBizFeed) {
                i3 = (photoInfo.opsynflag & (photoInfo.hasPraise ? 1 : 2)) != 0 ? 1 : 0;
            }
            QZoneFeedxPictureManager.getInstance().praisePhoto(handler, new QZoneInteractPhotoRequestBuilder().setUgcKey(this.f57988i.feedId).setCurKey(this.f57988i.curKey).setUniKey(this.f57988i.orgKey).setIsLike(photoInfo.hasPraise).setAppId(this.f57988i.appid).setExtraInfoMap(photoInfo.busi_param).setSyn(i3).setIndex(this.C));
            return;
        }
        if (!TextUtils.isEmpty(R9(photoInfo))) {
            if (photoInfo.isIndependentUgc != 0 && !this.f57988i.isFriendPhotoBizFeed) {
                i3 = (photoInfo.opsynflag & (photoInfo.hasPraise ? 1 : 2)) != 0 ? 1 : 0;
            }
            QZoneFeedxPictureManager.getInstance().praisePhoto(handler, new QZoneInteractPhotoRequestBuilder().setUgcKey(this.f57988i.feedId).setCurKey(O9(photoInfo)).setUniKey(R9(photoInfo)).setIsLike(photoInfo.hasPraise).setAppId(this.f57988i.appid).setExtraInfoMap(photoInfo.busi_param).setSyn(i3).setIndex(this.C));
            return;
        }
        if (BasePicureViewController.p(photoInfo)) {
            if (photoInfo.busi_param == null) {
                photoInfo.busi_param = new HashMap();
            }
            photoInfo.busi_param.put(12, photoInfo.albumId);
            photoInfo.busi_param.put(2, photoInfo.lloc);
            QZoneFeedxPictureManager.getInstance().praisePhoto(handler, new QZoneInteractPhotoRequestBuilder().setIsLike(photoInfo.hasPraise).setAppId(this.f57988i.appid).setExtraInfoMap(photoInfo.busi_param).setIndex(-1));
        }
    }

    protected void Z9() {
        List<RFWLayerItemMediaInfo> richMediaDataList;
        if (this.mLayerViewModel.mRichMediaInfo.getValue() == null || this.mLayerViewModel.mRichMediaInfo.getValue().getData() == null || (richMediaDataList = this.mLayerViewModel.mRichMediaInfo.getValue().getData().getRichMediaDataList()) == null) {
            return;
        }
        for (RFWLayerItemMediaInfo rFWLayerItemMediaInfo : richMediaDataList) {
            if (rFWLayerItemMediaInfo.getExtraData() instanceof PhotoInfo) {
                PhotoInfo photoInfo = (PhotoInfo) rFWLayerItemMediaInfo.getExtraData();
                boolean z16 = photoInfo.hasPraise;
                if (z16) {
                    photoInfo.praiseCount--;
                } else {
                    photoInfo.praiseCount++;
                }
                photoInfo.hasPraise = !z16;
            }
        }
        MutableLiveData<UIStateData<RFWLayerState>> mutableLiveData = this.mLayerViewModel.mRichMediaInfo;
        mutableLiveData.setValue(mutableLiveData.getValue());
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onActivityResult(int i3, int i16, Intent intent) {
        String stringExtra;
        PhotoInfo photoInfo;
        super.onActivityResult(i3, i16, intent);
        if (i3 != 20230 || intent == null || (stringExtra = intent.getStringExtra("lloc")) == null || (photoInfo = this.f57984d) == null || !stringExtra.equals(photoInfo.lloc)) {
            return;
        }
        boolean booleanExtra = intent.getBooleanExtra(PictureConst.PHOTO_MYLIKE, false);
        int intExtra = intent.getIntExtra(PictureConst.PHOTO_LIKE_NUM, 0);
        PhotoInfo photoInfo2 = this.f57984d;
        photoInfo2.hasPraise = booleanExtra;
        photoInfo2.praiseCount = intExtra;
        W9(intExtra, booleanExtra);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (view.getId() == R.id.n0l || view.getId() == R.id.n0m) {
            M9();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.reborn.layer.part.ap
    public void onHandleMessage(Message message) {
        super.onHandleMessage(message);
        QZoneResult unpack = QZoneResult.unpack(message);
        if (unpack != null && 999906 == unpack.what) {
            if (!unpack.getSucceed()) {
                W9(Q9() - 1, !P9());
            }
            T9();
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View view) {
        super.onInitView(view);
        this.G = (TextView) view.findViewById(R.id.n0m);
        this.H = (ImageView) view.findViewById(R.id.n0l);
        this.G.setOnClickListener(this);
        this.H.setOnClickListener(this);
    }

    @Override // com.qzone.reborn.layer.part.ap
    public void onLayerStateUpdate(RFWLayerState rFWLayerState) {
        if (this.f57984d == null) {
            return;
        }
        W9(Q9(), P9());
    }

    private void X9(boolean z16) {
        if (z16) {
            this.H.setImageResource(R.drawable.qui_like_filled_brand);
            this.H.setContentDescription(com.qzone.util.l.a(R.string.s3u));
        } else {
            this.H.setImageResource(R.drawable.qui_like);
            this.H.setContentDescription(com.qzone.util.l.a(R.string.f172561s45));
            com.tencent.mobileqq.qzone.picload.c.a().m(this.H, -1);
        }
    }

    protected void Y9(PhotoInfo photoInfo) {
        PhotoParam photoParam;
        boolean z16;
        if (photoInfo == null || (photoParam = this.f57988i) == null || (z16 = photoInfo.hasPraise) == photoParam.isLike) {
            return;
        }
        if (z16) {
            photoParam.likeNum++;
        } else {
            photoParam.likeNum--;
        }
        photoParam.isLike = z16;
    }

    protected void N9(PhotoInfo photoInfo) {
        if (photoInfo == null) {
            return;
        }
        if (U9(photoInfo)) {
            Z9();
            Y9(photoInfo);
        } else {
            boolean z16 = photoInfo.hasPraise;
            if (!z16) {
                photoInfo.praiseCount++;
            } else {
                photoInfo.praiseCount--;
            }
            photoInfo.hasPraise = !z16;
        }
        PhotoParam photoParam = this.f57988i;
        if (photoParam == null || photoParam.appid != 311 || !photoInfo.hasPraise || photoParam.isLike) {
            return;
        }
        photoParam.isLike = true;
        photoParam.likeNum++;
    }

    protected boolean U9(PhotoInfo photoInfo) {
        PhotoParam photoParam;
        return photoInfo != null && photoInfo.isIndependentUgc == 0 && (photoParam = this.f57988i) != null && photoParam.appid == 311;
    }

    protected void T9() {
    }
}
