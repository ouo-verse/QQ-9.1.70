package com.qzone.reborn.layer.part;

import NS_MOBILE_PHOTO.EditPhoto;
import android.app.Activity;
import android.content.Intent;
import android.os.Message;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.qzone.common.account.LoginData;
import com.qzone.common.business.result.QZoneResult;
import com.qzone.misc.network.report.ClickReport;
import com.qzone.preview.service.QZoneFeedxPictureManager;
import com.qzone.preview.service.QZoneInteractPhotoRequestBuilder;
import com.qzone.proxy.feedcomponent.text.CellTextView;
import com.qzone.reborn.comment.bean.QZoneCommentPanelParams;
import com.qzone.reborn.comment.bean.QZoneCommentPanelResultBean;
import com.qzone.util.ToastUtil;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.biz.richframework.ioc.RFWIocAbilityProvider;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.profilecard.template.ProfileCardTemplate;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vas.theme.ThemeSwitchUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.richframework.gallery.RFWLayerIOCUtil;
import com.tencent.richframework.gallery.bean.RFWLayerItemMediaInfo;
import com.tencent.richframework.gallery.bean.RFWLayerState;
import com.tencent.richframework.gallery.delegate.inner.IVideoPlayerProvider;
import com.tencent.richframework.gallery.event.RFWLayerVideoPlayEvent;
import com.tencent.richframework.thread.RFWThreadManager;
import cooperation.qzone.model.PhotoInfo;
import cooperation.qzone.model.PhotoParam;
import java.util.ArrayList;

/* loaded from: classes37.dex */
public class QZoneAlbumLayerDescPart extends ap implements SimpleEventReceiver<RFWLayerVideoPlayEvent>, pk.d {
    private LinearLayout G;
    private ImageView H;
    private CellTextView I;
    private CellTextView J;
    private View K;

    private void Q9(boolean z16) {
        View view = this.K;
        if (view == null) {
            return;
        }
        view.setVisibility(z16 ? 0 : 8);
        if (!F9()) {
            aa();
        } else {
            Z9();
        }
    }

    private void R9() {
        RFWThreadManager.getUIHandler().postDelayed(new Runnable() { // from class: com.qzone.reborn.layer.part.QZoneAlbumLayerDescPart.1
            @Override // java.lang.Runnable
            public void run() {
                IVideoPlayerProvider videoControlProvider = RFWLayerIOCUtil.getVideoControlProvider(QZoneAlbumLayerDescPart.this.K);
                if (videoControlProvider == null || videoControlProvider.isPlaying()) {
                    return;
                }
                videoControlProvider.changeOperationLayoutVisible(IVideoPlayerProvider.ControlLayoutVisibleState.GONE);
            }
        }, 50L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void S9(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        V9();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void T9(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        ba();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void U9(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        ba();
        EventCollector.getInstance().onViewClicked(view);
    }

    private void V9() {
        ho.i.e().k(getActivity(), this.f57988i, this.f57984d);
        ClickReport.q(ThemeSwitchUtil.FROM_LOGIN_RESULT, "4", "", true);
        PhotoParam photoParam = this.f57988i;
        if (photoParam != null && photoParam.isFriendPhotoBizFeed) {
            com.qzone.adapter.feedcomponent.i.H().U1(this.f57988i.businessPhotoFeedIndex, "5");
        }
        ClickReport.m(ProfileCardTemplate.PROFILE_COMMON_VERSION, "3", "");
    }

    private boolean Y9() {
        int i3;
        PhotoInfo photoInfo = this.f57984d;
        return photoInfo != null && ((i3 = photoInfo.appid) == 4 || i3 == 423 || i3 == 422);
    }

    private void Z9() {
        LinearLayout linearLayout = this.G;
        if (linearLayout != null) {
            linearLayout.setVisibility(8);
        }
        PhotoInfo photoInfo = this.f57984d;
        if (photoInfo != null && !TextUtils.isEmpty(photoInfo.desc)) {
            if (B9() != null) {
                B9().k8();
            }
            this.J.setRichText(this.f57984d.desc);
            this.J.setVisibility(0);
            this.J.setOnClickListener(new View.OnClickListener() { // from class: com.qzone.reborn.layer.part.d
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    QZoneAlbumLayerDescPart.this.S9(view);
                }
            });
            return;
        }
        this.J.setVisibility(8);
    }

    private void aa() {
        LinearLayout linearLayout;
        if (this.f57984d == null || (linearLayout = this.G) == null || this.I == null || this.H == null) {
            return;
        }
        linearLayout.setVisibility(0);
        this.J.setVisibility(8);
        this.I.setCellClickable(false);
        this.H.setOnClickListener(new View.OnClickListener() { // from class: com.qzone.reborn.layer.part.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                QZoneAlbumLayerDescPart.this.T9(view);
            }
        });
        this.I.setOnClickListener(new View.OnClickListener() { // from class: com.qzone.reborn.layer.part.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                QZoneAlbumLayerDescPart.this.U9(view);
            }
        });
        if (B9() != null) {
            B9().k9();
        }
        com.qzone.reborn.util.h.i(getContext(), this.H, "https://ctc.qzonestyle.gtimg.cn/qzone/em/e10034.gif", ViewUtils.dip2px(14.0f), ViewUtils.dip2px(14.0f));
        if (TextUtils.isEmpty(this.f57984d.desc)) {
            X9(this.I, com.qzone.util.l.a(R.string.s46));
        } else {
            X9(this.I, this.f57984d.desc);
        }
    }

    private void ba() {
        if (getActivity() != null && this.f57984d != null) {
            if (B9() != null) {
                B9().D2();
            }
            PhotoInfo photoInfo = this.f57984d;
            ho.i.c().l(new QZoneCommentPanelParams.a().y(7).d(photoInfo.desc).g(LoginData.getInstance().getUin() + "_" + photoInfo.albumId + "_" + photoInfo.lloc).i(false).t(200).getParams(), getActivity());
            return;
        }
        RFWLog.e(getTAG(), RFWLog.USR, "showEditDescPanel fail: " + this.f57984d);
    }

    @Override // pk.d
    public void P5(RFWLayerItemMediaInfo rFWLayerItemMediaInfo, boolean z16) {
        RFWLog.d(getTAG(), RFWLog.USR, "onVideoControlVisibleChange, isVisible: " + z16);
        Q9(Y9() && !z16);
    }

    protected void W9(Intent intent) {
        Parcelable parcelableExtra = intent.getParcelableExtra("comment_panel_result_bean");
        if (!(parcelableExtra instanceof QZoneCommentPanelResultBean)) {
            RFWLog.e(getTAG(), RFWLog.USR, "[onFinishEditPhotoDescNew] bean is not instanceof");
            return;
        }
        QZoneCommentPanelResultBean qZoneCommentPanelResultBean = (QZoneCommentPanelResultBean) parcelableExtra;
        String inputContent = qZoneCommentPanelResultBean.getInputContent();
        String cacheUniKey = qZoneCommentPanelResultBean.getCacheUniKey();
        ArrayList<String> arrayList = new ArrayList<>();
        PhotoInfo photoInfo = this.f57984d;
        if (photoInfo == null) {
            return;
        }
        arrayList.add(photoInfo.lloc);
        this.f57984d.desc = inputContent;
        EditPhoto editPhoto = new EditPhoto();
        editPhoto.desc = inputContent;
        Q9(true);
        QZoneFeedxPictureManager.getInstance().editPhotoInfo(new QZoneInteractPhotoRequestBuilder().setAlbumId(this.f57984d.albumId).setPhotoIdList(arrayList).setPhotoInfo(editPhoto).setOperateType(2).setCacheKey(cacheUniKey), A9());
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class<RFWLayerVideoPlayEvent>> getEventClass() {
        ArrayList<Class<RFWLayerVideoPlayEvent>> arrayList = new ArrayList<>();
        arrayList.add(RFWLayerVideoPlayEvent.class);
        return arrayList;
    }

    @Override // com.tencent.biz.richframework.part.Part
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QZoneAlbumLayerDescPart";
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onActivityResult(int i3, int i16, Intent intent) {
        super.onActivityResult(i3, i16, intent);
        if (i3 == 7 && i16 == -1) {
            W9(intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.reborn.layer.part.ap
    public void onHandleMessage(Message message) {
        super.onHandleMessage(message);
        QZoneResult unpack = QZoneResult.unpack(message);
        if (unpack != null && unpack.what == 1000118) {
            if (unpack.getSucceed()) {
                ToastUtil.o(R.string.gjh, 5);
            } else if (!TextUtils.isEmpty(unpack.getMessage())) {
                ToastUtil.r(unpack.getMessage());
            } else {
                ToastUtil.o(R.string.gjg, 4);
            }
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View view) {
        super.onInitView(view);
        this.G = (LinearLayout) view.findViewById(R.id.n0f);
        this.H = (ImageView) view.findViewById(R.id.n0g);
        this.K = view.findViewById(R.id.n0h);
        this.I = (CellTextView) view.findViewById(R.id.n0e);
        this.J = (CellTextView) view.findViewById(R.id.n0i);
        SimpleEventBus.getInstance().registerReceiver(this);
        RFWIocAbilityProvider.g().registerIoc(view, this, pk.d.class);
        AccessibilityUtil.p(this.H, com.qzone.util.l.a(R.string.f133165d));
    }

    @Override // com.qzone.reborn.layer.part.ap
    public void onLayerStateUpdate(RFWLayerState rFWLayerState) {
        Q9(Y9() && !L9());
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        super.onPartDestroy(activity);
        SimpleEventBus.getInstance().unRegisterReceiver(this);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        if (simpleBaseEvent instanceof RFWLayerVideoPlayEvent) {
            RFWLayerVideoPlayEvent rFWLayerVideoPlayEvent = (RFWLayerVideoPlayEvent) simpleBaseEvent;
            RFWLayerItemMediaInfo rFWLayerItemMediaInfo = this.mCurrentSelectedItem;
            if (rFWLayerItemMediaInfo != null && TextUtils.equals(rFWLayerVideoPlayEvent.videoId, rFWLayerItemMediaInfo.getMediaId()) && Y9()) {
                int i3 = rFWLayerVideoPlayEvent.isPlay ? 8 : 0;
                View view = this.K;
                if (view == null) {
                    return;
                }
                view.setVisibility(i3);
                R9();
                RFWLog.d(getTAG(), RFWLog.USR, "onReceiveEvent, RFWLayerVideoPlayEvent: videoId: " + rFWLayerVideoPlayEvent.videoId + ", itemId: " + this.mCurrentSelectedItem.getMediaId() + ", isPlay: " + rFWLayerVideoPlayEvent.isPlay);
            }
        }
    }

    private void X9(CellTextView cellTextView, String str) {
        if (cellTextView == null) {
            return;
        }
        cellTextView.setRichText(str);
    }
}
