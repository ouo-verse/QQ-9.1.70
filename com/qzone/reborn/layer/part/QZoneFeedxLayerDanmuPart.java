package com.qzone.reborn.layer.part;

import NS_MOBILE_FEEDS.cell_comment;
import NS_MOBILE_FEEDS.cnst.UNIVERSAL_MALL_QUAL;
import NS_MOBILE_FEEDS.s_commment;
import NS_MOBILE_FEEDS.s_user;
import NS_MOBILE_PHOTO.get_photo_comment_rsp;
import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Message;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.qzone.album.base.Service.QzoneAlbumPicDownloadService;
import com.qzone.common.account.LoginData;
import com.qzone.common.business.result.QZoneResult;
import com.qzone.preview.event.QZoneFeedxLayerAddDanmakuEvent;
import com.qzone.preview.photodanmaku.core.PhotoDanmakuDataSource;
import com.qzone.preview.photodanmaku.core.PhotoDanmakuFactory;
import com.qzone.preview.photodanmaku.core.PhotoDanmakuManager;
import com.qzone.preview.photodanmaku.entity.AbsDanmaku;
import com.qzone.preview.photodanmaku.entity.PhotoDanmakuModel;
import com.qzone.preview.service.QZoneAlbumRequestBuilder;
import com.qzone.preview.service.QZoneFeedxPictureManager;
import com.qzone.publish.ui.model.QzoneBarrageEffectData;
import com.qzone.publish.ui.model.QzoneSuperPersonalFontData;
import com.qzone.widget.QzoneGuideBubbleHelper;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.richframework.gallery.bean.RFWLayerState;
import com.tencent.richframework.thread.RFWThreadManager;
import com.tencent.widget.immersive.ImmersiveUtils;
import common.config.service.QzoneConfig;
import cooperation.qzone.LocalMultiProcConfig;
import cooperation.qzone.model.PhotoInfo;
import cooperation.qzone.model.PhotoParam;
import cooperation.qzone.report.retention.RetentionReport;
import cooperation.qzone.thread.QzoneHandlerThreadFactory;
import cooperation.qzone.util.PhotoDanmakuUtil;
import cooperation.qzone.util.QZLog;
import java.util.ArrayList;

/* loaded from: classes37.dex */
public class QZoneFeedxLayerDanmuPart extends ap implements SimpleEventReceiver {
    private ImageView G;
    private WindowManager H;
    private View I;
    private String J;
    private String K;
    private String L;
    private boolean M;
    private boolean N;
    private boolean P;
    private PhotoDanmakuManager Q;
    private PhotoDanmakuDataSource R;
    private PhotoDanmakuFactory S;
    private TextureView T;
    private ArrayList<PhotoDanmakuModel> U;
    private long V;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes37.dex */
    public class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (QZoneFeedxLayerDanmuPart.this.M) {
                QZoneFeedxLayerDanmuPart.this.oa(false);
                QZoneFeedxLayerDanmuPart.this.pa(false);
            } else {
                QZoneFeedxLayerDanmuPart.this.oa(true);
                QZoneFeedxLayerDanmuPart.this.pa(true);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    public QZoneFeedxLayerDanmuPart() {
        this.M = QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.SECONDARY_PICTURE_VIEWER_DANMAKU_DEFAULT_SWITCH, 0) == 1;
        this.N = true;
        this.P = false;
        this.V = 0L;
    }

    private void aa() {
        ArrayList<PhotoDanmakuModel> arrayList = this.U;
        if (arrayList != null && arrayList.size() != 0) {
            ja(this.U);
        } else {
            QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.RealTimeThread).post(new Runnable() { // from class: com.qzone.reborn.layer.part.QZoneFeedxLayerDanmuPart.4
                @Override // java.lang.Runnable
                public void run() {
                    QZoneFeedxLayerDanmuPart qZoneFeedxLayerDanmuPart = QZoneFeedxLayerDanmuPart.this;
                    qZoneFeedxLayerDanmuPart.ca(qZoneFeedxLayerDanmuPart.f57984d);
                }
            });
        }
    }

    private String ba(PhotoInfo photoInfo) {
        return photoInfo.busi_param.get(21);
    }

    private void ea() {
        WindowManager windowManager;
        this.H = (WindowManager) getContext().getSystemService("window");
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.bqi, (ViewGroup) null);
        this.I = inflate;
        this.T = (TextureView) inflate.findViewById(R.id.j8n);
        this.Q = new PhotoDanmakuManager(getContext(), this.T, 1);
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.gravity = 48;
        layoutParams.type = 2;
        layoutParams.format = 1;
        layoutParams.flags = 1080;
        layoutParams.width = -1;
        layoutParams.height = -1;
        if (!getActivity().isFinishing() && (windowManager = this.H) != null) {
            try {
                windowManager.addView(this.I, layoutParams);
            } catch (Exception e16) {
                QLog.e("QZoneFeedxLayerDanmuPart", 1, "exception is " + e16);
            }
        }
        this.R = this.Q.getDanmakuDataSource();
        this.S = this.Q.getDanmakuFactory();
        this.P = true;
    }

    private void ga(View view) {
        boolean ha5 = ha();
        this.N = ha5;
        if (ha5 && PhotoDanmakuUtil.getInstance().isEnablePhotoDanmakuFunc()) {
            na(view);
        }
    }

    private boolean ha() {
        String config = QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.SECONDARY_PICTURE_VIEWER_DANMAKU_GARY_RANGE, QzoneConfig.DEFAULT_PICTURE_VIEWER_DANMAKU_GARY_RANGE);
        int[] iArr = new int[2];
        if (!TextUtils.isEmpty(config)) {
            String[] split = config.split("-");
            if (split.length >= 2) {
                try {
                    iArr[0] = Integer.parseInt(split[0]);
                    iArr[1] = Integer.parseInt(split[1]);
                } catch (Exception e16) {
                    RFWLog.e("QZoneFeedxLayerDanmuPart", RFWLog.USR, "exception is " + e16);
                    return false;
                }
            }
        }
        long uin = LoginData.getInstance().getUin() % 100;
        return uin >= ((long) iArr[0]) && uin < ((long) iArr[1]);
    }

    private boolean ia(PhotoInfo photoInfo) {
        String str;
        String str2 = this.K;
        if (str2 == null && this.L == null) {
            return true;
        }
        return (str2 == null || this.L == null || (str = this.J) == null || str.equals(ba(photoInfo))) ? false : true;
    }

    private void ja(final ArrayList<PhotoDanmakuModel> arrayList) {
        final ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        for (int i3 = 0; i3 < arrayList.size(); i3++) {
            PhotoDanmakuModel photoDanmakuModel = arrayList.get(i3);
            long j3 = photoDanmakuModel.userUin;
            if (j3 > 0) {
                arrayList3.add(Long.valueOf(j3));
            }
            QzoneBarrageEffectData.BarrageEffectInfo barrageEffectInfo = photoDanmakuModel.barrageEffectInfo;
            if (barrageEffectInfo != null && !TextUtils.isEmpty(barrageEffectInfo.strIosBgUrl)) {
                arrayList2.add(photoDanmakuModel.barrageEffectInfo.strIosBgUrl);
            }
        }
        if (arrayList2.size() > 0) {
            QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.NormalThread).post(new Runnable() { // from class: com.qzone.reborn.layer.part.QZoneFeedxLayerDanmuPart.5

                /* renamed from: com.qzone.reborn.layer.part.QZoneFeedxLayerDanmuPart$5$a */
                /* loaded from: classes37.dex */
                class a implements QzoneAlbumPicDownloadService.c {
                    a() {
                    }

                    @Override // com.qzone.album.base.Service.QzoneAlbumPicDownloadService.c
                    public void a(String str, ArrayList<String> arrayList) {
                        AnonymousClass5 anonymousClass5 = AnonymousClass5.this;
                        QZoneFeedxLayerDanmuPart.this.ma(arrayList);
                        QLog.e(QZoneFeedxLayerDanmuPart.this.getTAG(), 1, "onDownloadSucceed danmu");
                    }

                    @Override // com.qzone.album.base.Service.QzoneAlbumPicDownloadService.c
                    public void onDownloadFailed(String str) {
                        QLog.e(QZoneFeedxLayerDanmuPart.this.getTAG(), 1, "onDownloadFailed danmu");
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    QzoneAlbumPicDownloadService.o().n(QZoneFeedxLayerDanmuPart.this.getContext(), System.currentTimeMillis() + "", arrayList2, new a());
                }
            });
        } else {
            ma(arrayList);
        }
    }

    private void la() {
        RFWThreadManager.getInstance().runOnUiThread(new Runnable() { // from class: com.qzone.reborn.layer.part.QZoneFeedxLayerDanmuPart.3
            @Override // java.lang.Runnable
            public void run() {
                if (QZoneFeedxLayerDanmuPart.this.P) {
                    if (QZoneFeedxLayerDanmuPart.this.Q != null && QZoneFeedxLayerDanmuPart.this.Q.isPlaying()) {
                        QZoneFeedxLayerDanmuPart.this.Q.quit();
                        QZoneFeedxLayerDanmuPart.this.Q.clear();
                        QZoneFeedxLayerDanmuPart.this.Q.release();
                        QZoneFeedxLayerDanmuPart qZoneFeedxLayerDanmuPart = QZoneFeedxLayerDanmuPart.this;
                        qZoneFeedxLayerDanmuPart.qa(qZoneFeedxLayerDanmuPart.I, 8);
                        if (QZoneFeedxLayerDanmuPart.this.H != null) {
                            try {
                                QZoneFeedxLayerDanmuPart.this.H.removeViewImmediate(QZoneFeedxLayerDanmuPart.this.I);
                            } catch (Throwable th5) {
                                QLog.e(QZoneFeedxLayerDanmuPart.this.getTAG(), 1, "[releaseDanmakuResAndStop] error: ", th5);
                            }
                        }
                    }
                    QZoneFeedxLayerDanmuPart.this.P = false;
                }
                if (QZoneFeedxLayerDanmuPart.this.Q != null) {
                    QZoneFeedxLayerDanmuPart.this.Q.onDestroy();
                }
            }
        });
    }

    private void na(View view) {
        ImageView imageView = new ImageView(getContext());
        this.G = imageView;
        imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        this.G.setAdjustViewBounds(true);
        this.G.setMaxWidth(ViewUtils.dpToPx(24.0f));
        this.G.setMaxHeight(ViewUtils.dpToPx(24.0f));
        this.G.setId(R.id.fsz);
        Y9((ViewGroup) view, this.G);
        boolean bool = LocalMultiProcConfig.getBool(LocalMultiProcConfig.Constants.KEY_PHOTO_COMMENT_DANMAKU_SWITCH + LoginData.getInstance().getUinString(), this.M);
        this.M = bool;
        oa(bool);
        this.G.setOnClickListener(new a());
        if (!u5.b.D("key_first_time_enter_picture_viewer", true) || this.M || this.f57988i.commentNum <= 0) {
            return;
        }
        u5.b.o0("key_first_time_enter_picture_viewer", false);
        this.G.post(new Runnable() { // from class: com.qzone.reborn.layer.part.QZoneFeedxLayerDanmuPart.2
            @Override // java.lang.Runnable
            public void run() {
                QzoneGuideBubbleHelper.g().n(QZoneFeedxLayerDanmuPart.this.getActivity(), QZoneFeedxLayerDanmuPart.this.G, QZoneFeedxLayerDanmuPart.this.getContext().getString(R.string.gjw), 1, 16.0f, 5.0d, 10.0d, 5000L, -16669697, false, true, 0, null, 0, true, 1.0f, null);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pa(boolean z16) {
        this.M = z16;
        if (z16) {
            aa();
        } else {
            la();
        }
        LocalMultiProcConfig.putBool(LocalMultiProcConfig.Constants.KEY_PHOTO_COMMENT_DANMAKU_SWITCH + LoginData.getInstance().getUinString(), z16);
        if (B9() != null) {
            B9().c4(z16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qa(final View view, final int i3) {
        RFWThreadManager.getUIHandler().post(new Runnable() { // from class: com.qzone.reborn.layer.part.QZoneFeedxLayerDanmuPart.6
            @Override // java.lang.Runnable
            public void run() {
                tk.h.P(view, i3);
            }
        });
    }

    protected void Y9(ViewGroup viewGroup, View view) {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 21;
        layoutParams.rightMargin = ViewUtils.dip2px(16.0f);
        FrameLayout frameLayout = new FrameLayout(getContext());
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, ImmersiveUtils.dpToPx(42.0f));
        layoutParams2.gravity = 48;
        layoutParams2.topMargin = ImmersiveUtils.getStatusBarHeight(getContext());
        viewGroup.addView(frameLayout, layoutParams2);
        frameLayout.addView(view, layoutParams);
    }

    protected void da(QZoneResult qZoneResult) {
        QLog.e(getTAG(), 1, "handlePhotoCommentResult result is Succeed " + qZoneResult.getSucceed() + " returnCode: " + qZoneResult.getReturnCode() + " msg" + qZoneResult.getMessage());
        Bundle bundle = qZoneResult.getBundle();
        if (bundle == null) {
            QLog.e(getTAG(), 1, "handlePhotoCommentResult getBundle is empty");
            return;
        }
        get_photo_comment_rsp get_photo_comment_rspVar = (get_photo_comment_rsp) bundle.getSerializable("response");
        if (get_photo_comment_rspVar == null) {
            QLog.e(getTAG(), 1, "handlePhotoCommentResult photoCommentRsp is empty");
            return;
        }
        cell_comment cell_commentVar = get_photo_comment_rspVar.comment;
        if (cell_commentVar == null) {
            QLog.e(getTAG(), 1, "handlePhotoCommentResult comment is empty");
            return;
        }
        ArrayList<s_commment> arrayList = cell_commentVar.commments;
        if (arrayList != null && arrayList.size() > 0) {
            QLog.e(getTAG(), 1, "handlePhotoCommentResult handle photoCommentList");
            ArrayList<PhotoDanmakuModel> arrayList2 = this.U;
            if (arrayList2 == null) {
                this.U = new ArrayList<>();
            } else {
                arrayList2.clear();
            }
            for (int i3 = 0; i3 < arrayList.size(); i3++) {
                s_commment s_commmentVar = arrayList.get(i3);
                QzoneBarrageEffectData.BarrageEffectInfo fromFeedsJceData = QzoneBarrageEffectData.BarrageEffectInfo.fromFeedsJceData(s_commmentVar.binaryExtInfo.get(UNIVERSAL_MALL_QUAL.value));
                String str = s_commmentVar.content;
                s_user s_userVar = s_commmentVar.user;
                long j3 = s_userVar.uin;
                String str2 = s_userVar.nickname;
                String str3 = s_commmentVar.extendInfo.get("sparkle_json");
                String str4 = s_commmentVar.extendInfo.get("diy_font_id");
                String str5 = s_commmentVar.extendInfo.get("diy_font_type");
                String str6 = s_commmentVar.extendInfo.get("diy_font_url");
                if (!TextUtils.isEmpty(str)) {
                    this.U.add(new PhotoDanmakuModel(str2, j3, str, (str3 == null || TextUtils.isEmpty(str3)) ? null : QzoneSuperPersonalFontData.SuperFontInfo.fromJson(str3), str4, str5, str6, fromFeedsJceData));
                }
            }
        } else {
            QLog.e(getTAG(), 1, "handlePhotoCommentResult comment.commments is emtpy!");
        }
        ArrayList<PhotoDanmakuModel> arrayList3 = this.U;
        if (arrayList3 == null || arrayList3.size() <= 0) {
            return;
        }
        ja(this.U);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class> getEventClass() {
        ArrayList<Class> arrayList = new ArrayList<>();
        arrayList.add(QZoneFeedxLayerAddDanmakuEvent.class);
        return arrayList;
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void handleBroadcastMessage(String str, Object obj) {
        if (TextUtils.equals("FEEDX_LAYER_DANMU_HIDE", str)) {
            la();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.reborn.layer.part.ap
    public void onHandleMessage(Message message) {
        QZoneResult unpack = QZoneResult.unpack(message);
        if (unpack == null) {
            return;
        }
        QLog.i(getTAG(), 1, "handlePhotoCommentResult msg.what:" + message.what);
        if (message.what == 1000199) {
            da(unpack);
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View view) {
        super.onInitView(view);
        ga(view);
    }

    @Override // com.qzone.reborn.layer.part.ap
    public void onLayerStateUpdate(RFWLayerState rFWLayerState) {
        if (this.f57984d == null) {
            la();
            tk.h.P(this.G, 8);
            return;
        }
        tk.h.P(this.G, 0);
        QLog.i(getTAG(), 1, "updateSelectedInfo");
        if (this.M && ia(this.f57984d)) {
            ca(this.f57984d);
        }
        this.J = ba(this.f57984d);
        PhotoInfo photoInfo = this.f57984d;
        this.K = photoInfo.albumId;
        this.L = photoInfo.lloc;
    }

    @Override // com.qzone.reborn.layer.part.ap, com.tencent.richframework.gallery.part.RFWLayerBasePart, com.tencent.biz.richframework.part.Part
    public void onPartCreate(Activity activity, Bundle bundle) {
        super.onPartCreate(activity, bundle);
        SimpleEventBus.getInstance().registerReceiver(this);
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        super.onPartDestroy(activity);
        SimpleEventBus.getInstance().unRegisterReceiver(this);
        la();
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        if (simpleBaseEvent instanceof QZoneFeedxLayerAddDanmakuEvent) {
            QZoneFeedxLayerAddDanmakuEvent qZoneFeedxLayerAddDanmakuEvent = (QZoneFeedxLayerAddDanmakuEvent) simpleBaseEvent;
            if (!this.M || qZoneFeedxLayerAddDanmakuEvent.getDamakuModel() == null) {
                return;
            }
            Z9(qZoneFeedxLayerAddDanmakuEvent.getDamakuModel());
        }
    }

    private void Z9(PhotoDanmakuModel photoDanmakuModel) {
        if (photoDanmakuModel == null || !this.M) {
            return;
        }
        PhotoParam photoParam = this.f57988i;
        if (photoParam.qzoneUserType != 0 || photoParam.appid == 202 || photoParam.isSharedFeeds) {
            return;
        }
        if (!this.P) {
            ea();
        }
        if (this.U == null) {
            this.U = new ArrayList<>();
        }
        this.U.add(0, photoDanmakuModel);
        if (this.Q.isPlaying()) {
            AbsDanmaku createDanmaku = this.S.createDanmaku(1, 0L, photoDanmakuModel.nickName, photoDanmakuModel.content, getContext().getResources().getColor(R.color.a8r), 10.0f, getContext().getResources().getColor(R.color.a8q));
            createDanmaku.isPostImmediatelyDanmaku = true;
            QzoneBarrageEffectData.BarrageEffectInfo barrageEffectInfo = photoDanmakuModel.barrageEffectInfo;
            if (barrageEffectInfo != null) {
                String str = barrageEffectInfo.strAndBgUrl;
                String str2 = barrageEffectInfo.strTextColor;
                createDanmaku.setBackgroundImageUrl(str);
                createDanmaku.setTextColor(Color.parseColor("#" + str2));
            }
            try {
                String str3 = photoDanmakuModel.fontId;
                if (str3 != null && !TextUtils.isEmpty(str3)) {
                    createDanmaku.setFontId(Integer.parseInt(photoDanmakuModel.fontId));
                    createDanmaku.setFontType(Integer.parseInt(photoDanmakuModel.fontType));
                    createDanmaku.setFontUrl(photoDanmakuModel.fontUrl);
                }
                createDanmaku.setSuperFontInfo(photoDanmakuModel.superFontInfo);
                createDanmaku.setTextSize(TypedValue.applyDimension(2, 14.0f, getContext().getResources().getDisplayMetrics()));
                createDanmaku.setUserLogoByUin(photoDanmakuModel.userUin);
                createDanmaku.setLeftImageShape(1);
                createDanmaku.setBorderRadio(60.0f);
                this.S.measureDanmaku(createDanmaku);
                this.R.addNow(createDanmaku);
                return;
            } catch (NumberFormatException unused) {
                QZLog.e(getTAG(), "Integer.parseInt(curDanmakuModel.fontId) - NumberFormatException");
                return;
            }
        }
        ma(this.U);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ma(ArrayList<PhotoDanmakuModel> arrayList) {
        long j3;
        if (!this.f57985e || getActivity() == null) {
            return;
        }
        QLog.e(getTAG(), 1, "showPhotoCommentDanmaku photoDanmakuModelList:" + arrayList.size());
        la();
        ea();
        ArrayList arrayList2 = new ArrayList();
        long j16 = 0;
        for (int i3 = 0; i3 < arrayList.size(); i3++) {
            if (i3 >= 2) {
                AbsDanmaku absDanmaku = (AbsDanmaku) arrayList2.get(i3 - 2);
                float contentWidth = absDanmaku.getContentWidth();
                j16 = absDanmaku.getTime();
                j3 = (int) (((8000.0f * contentWidth) / (ViewUtils.getScreenWidth() + contentWidth)) + 800.0f);
            } else {
                j3 = 800;
            }
            j16 += j3;
            PhotoDanmakuModel photoDanmakuModel = arrayList.get(i3);
            AbsDanmaku createDanmaku = this.S.createDanmaku(1, j16, photoDanmakuModel.nickName, photoDanmakuModel.content, getContext().getResources().getColor(R.color.qui_common_text_allwhite_primary), 10.0f, getContext().getResources().getColor(R.color.f156548dv));
            QzoneBarrageEffectData.BarrageEffectInfo barrageEffectInfo = photoDanmakuModel.barrageEffectInfo;
            if (barrageEffectInfo != null) {
                String str = barrageEffectInfo.strAndBgUrl;
                String str2 = barrageEffectInfo.strTextColor;
                createDanmaku.setBackgroundImageUrl(str);
                createDanmaku.setTextColor(Color.parseColor("#" + str2));
            }
            try {
                if (!TextUtils.isEmpty(photoDanmakuModel.fontId)) {
                    createDanmaku.setFontId(Integer.parseInt(photoDanmakuModel.fontId));
                    createDanmaku.setFontType(Integer.parseInt(photoDanmakuModel.fontType));
                    createDanmaku.setFontUrl(photoDanmakuModel.fontUrl);
                }
                createDanmaku.setSuperFontInfo(photoDanmakuModel.superFontInfo);
                createDanmaku.setTextSize(TypedValue.applyDimension(2, 14.0f, getContext().getResources().getDisplayMetrics()));
                createDanmaku.setUserLogoByUin(photoDanmakuModel.userUin);
                createDanmaku.setLeftImageShape(1);
                createDanmaku.setBorderRadio(60.0f);
                this.S.measureDanmaku(createDanmaku);
                arrayList2.add(createDanmaku);
            } catch (NumberFormatException unused) {
                QLog.e(getTAG(), 1, "Integer.parseInt(curDanmakuModel.fontId) - NumberFormatException");
                return;
            }
        }
        this.R.addLastAll(arrayList2);
        this.Q.start(this.V);
        qa(this.I, 0);
        RetentionReport.report(3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void oa(boolean z16) {
        String str;
        if (z16) {
            this.G.setImageResource(R.drawable.qui_subtitle_on);
        } else {
            this.G.setImageResource(R.drawable.qui_subtitle_off);
        }
        ImageView imageView = this.G;
        if (z16) {
            str = "\u5173\u95ed\u5f39\u5e55";
        } else {
            str = "\u6253\u5f00\u5f39\u5e55";
        }
        imageView.setContentDescription(str);
        com.tencent.mobileqq.qzone.picload.c.a().m(this.G, -1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ca(PhotoInfo photoInfo) {
        if (photoInfo == null) {
            QLog.e(getTAG(), 1, "getPhotoComment but photoInfo is null");
            return;
        }
        if (photoInfo.commentCount > 0 || this.f57988i.commentNum > 0) {
            String str = photoInfo.albumId;
            String str2 = photoInfo.lloc;
            String ba5 = ba(photoInfo);
            QLog.e(getTAG(), 1, "getQzonePhotoComment photoId:" + str2 + " albumId:" + str + " batchId:" + ba5);
            QZoneFeedxPictureManager.getInstance().getQZonePhotoComment(new QZoneAlbumRequestBuilder().setPhotoId(str2).setAlbumId(str).setCellId(ba5).setPhotoParam(this.f57988i), A9());
        }
    }
}
