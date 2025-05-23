package com.qzone.reborn.layer.part;

import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.qzone.common.account.LoginData;
import com.qzone.common.business.result.QZoneResult;
import com.qzone.preview.event.QZoneFeedxLayerAddDanmakuEvent;
import com.qzone.preview.photodanmaku.entity.PhotoDanmakuModel;
import com.qzone.preview.service.QZoneFeedxPictureManager;
import com.qzone.preview.service.QZoneInteractPhotoRequestBuilder;
import com.qzone.publish.ui.model.QzoneBarrageEffectData;
import com.qzone.publish.ui.model.QzoneSuperPersonalFontData;
import com.qzone.reborn.comment.bean.QZoneCommentPanelParams;
import com.qzone.reborn.comment.bean.QZoneCommentPanelResultBean;
import com.qzone.reborn.event.QZoneFeedxLayerCommentEvent;
import com.qzone.util.ToastUtil;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.ioc.RFWIocAbilityProvider;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.mini.api.QQMiniManager;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmini.sdk.core.utils.WnsConfig;
import com.tencent.richframework.gallery.viewmodel.RFWLayerViewModel;
import com.tencent.util.Pair;
import common.config.service.QzoneConfig;
import cooperation.qzone.font.SimpleFontInfo;
import cooperation.qzone.model.PhotoInfo;
import cooperation.qzone.model.PhotoParam;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes37.dex */
public class w extends ap implements View.OnClickListener, pk.a {
    private TextView G;
    private boolean H = false;
    private boolean I = false;
    protected int J = 1;
    private int K = -1;
    private PhotoDanmakuModel L;

    private Map<Integer, String> O9(PhotoInfo photoInfo) {
        RFWLayerViewModel rFWLayerViewModel = this.mLayerViewModel;
        if (rFWLayerViewModel != null && rFWLayerViewModel.mRichMediaInfo.getValue() != null && this.mLayerViewModel.mRichMediaInfo.getValue().getData() != null) {
            if (tk.h.A(this.mLayerViewModel.mRichMediaInfo.getValue().getData(), this.f57988i)) {
                return this.f57988i.busi_param;
            }
            return photoInfo.busi_param;
        }
        return photoInfo.busi_param;
    }

    private void V9() {
        ToastUtil.s(QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "ToastCommentSuccess", "\u8bc4\u8bba\u6210\u529f"), 5);
    }

    protected void M9(String str, ArrayList<String> arrayList, boolean z16, String str2, String str3, String str4) {
        String str5;
        PhotoInfo photoInfo = this.f57984d;
        if (photoInfo == null || this.f57988i == null) {
            return;
        }
        P9(photoInfo);
        this.J = 1;
        if (photoInfo.isIndependentUgc != 0 && (photoInfo.opsynflag & 4) == 0) {
            this.J = 0;
        }
        boolean S9 = S9(photoInfo);
        QZoneFeedxPictureManager qZoneFeedxPictureManager = QZoneFeedxPictureManager.getInstance();
        QZoneInteractPhotoRequestBuilder ownerUin = new QZoneInteractPhotoRequestBuilder().setUgcKey(this.f57988i.feedId).setFeedKey("").setLloc(photoInfo.lloc).setAppId(this.f57988i.appid).setOwnerUin(this.f57988i.ownerUin);
        PhotoParam photoParam = this.f57988i;
        if (photoParam.appid == 4) {
            str5 = photoParam.albumid;
        } else {
            str5 = photoParam.cell_id;
        }
        qZoneFeedxPictureManager.commentPhoto(ownerUin.setSrcId(str5).setContent(str).setIsVerified(0).setContentCacheUniKey(N9()).setExtraInfoMap(O9(photoInfo)).setSyn(this.J).setPairPhoto(S9 ? new Pair<>(photoInfo.currentUrl, photoInfo.bigUrl) : null).setIsPrivate(z16).setCommentPics(arrayList).setIndex(this.C).setFontInfo(str2).setSuperFontInfo(str3).setBarrageEffectInfo(str4), A9());
    }

    public String N9() {
        String str = "";
        if (this.f57988i.ownerUin >= 10001) {
            str = "" + this.f57988i.ownerUin;
        }
        if (!TextUtils.isEmpty(this.f57988i.albumid)) {
            str = str + "_" + this.f57988i.albumid;
        }
        PhotoInfo photoInfo = this.f57984d;
        if (photoInfo != null && !TextUtils.isEmpty(photoInfo.lloc)) {
            str = str + "_" + photoInfo.lloc;
        }
        if (this.K <= -1) {
            return str;
        }
        return str + "_" + this.K;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void P9(PhotoInfo photoInfo) {
        if (photoInfo.busi_param == null) {
            photoInfo.busi_param = new HashMap();
        }
        if (photoInfo.lloc != null) {
            photoInfo.busi_param.put(2, photoInfo.lloc);
            photoInfo.busi_param.put(1, photoInfo.sloc);
        }
        photoInfo.busi_param.put(15, photoInfo.bigUrl);
    }

    protected boolean Q9() {
        return true;
    }

    protected boolean R9() {
        return true;
    }

    protected void U9(Intent intent) {
        String str;
        String str2;
        Parcelable parcelableExtra = intent.getParcelableExtra("comment_panel_result_bean");
        if (!(parcelableExtra instanceof QZoneCommentPanelResultBean)) {
            QLog.e("QZoneFeedxLayerCommentInputPart", 1, "[onFinishCommentNew] bean is not instanceof");
            return;
        }
        QZoneCommentPanelResultBean qZoneCommentPanelResultBean = (QZoneCommentPanelResultBean) parcelableExtra;
        String str3 = "";
        if (qZoneCommentPanelResultBean.getFontInfo() == null) {
            str = "";
        } else {
            Integer id5 = qZoneCommentPanelResultBean.getFontInfo().getId();
            Integer fontFormatType = qZoneCommentPanelResultBean.getFontInfo().getFontFormatType();
            SimpleFontInfo simpleFontInfo = new SimpleFontInfo();
            simpleFontInfo.fontId = id5 == null ? 0 : id5.intValue();
            simpleFontInfo.formatType = fontFormatType != null ? fontFormatType.intValue() : 0;
            simpleFontInfo.fontUrl = qZoneCommentPanelResultBean.getFontInfo().getFontUrl();
            str = simpleFontInfo.toString();
        }
        if (qZoneCommentPanelResultBean.getSuperFontInfo() == null) {
            str2 = "";
        } else {
            str2 = qZoneCommentPanelResultBean.getSuperFontInfo().getFontJson();
        }
        if (qZoneCommentPanelResultBean.getBarrageEffectInfo() != null) {
            str3 = qZoneCommentPanelResultBean.getBarrageEffectInfo().getBarrageJson();
        }
        String str4 = str3;
        String inputContent = qZoneCommentPanelResultBean.getInputContent();
        if (!TextUtils.isEmpty(inputContent)) {
            W9(qZoneCommentPanelResultBean);
        }
        M9(inputContent, qZoneCommentPanelResultBean.g(), qZoneCommentPanelResultBean.getIsCheckedPrivateIcon(), str, str2, str4);
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x007a  */
    @Override // pk.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void X0(String str, int i3) {
        int i16;
        this.K = i3;
        if (this.I) {
            String stringExtra = getActivity().getIntent().getStringExtra(QQWinkConstants.KEY_PREVIOUS_ACTIVITY);
            if (this.f57988i.isShareAlbum || (!com.qzone.util.am.h(stringExtra) && (stringExtra.contains(QQBrowserActivity.class.getSimpleName()) || stringExtra.contains(QQMiniManager.getAppBrandUIClass().getSimpleName())))) {
                i16 = -1;
                ho.i.c().l(new QZoneCommentPanelParams.a().y(2).q(QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "SaySomething", "\u8bf4\u70b9\u4ec0\u4e48\u5427...")).d(str).g(N9()).m(R9()).j(this.f57988i.appid == 311).A(i16).getParams(), getActivity());
            }
        }
        i16 = 0;
        ho.i.c().l(new QZoneCommentPanelParams.a().y(2).q(QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "SaySomething", "\u8bf4\u70b9\u4ec0\u4e48\u5427...")).d(str).g(N9()).m(R9()).j(this.f57988i.appid == 311).A(i16).getParams(), getActivity());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.reborn.layer.part.ap
    public void initIntentData(Bundle bundle) {
        super.initIntentData(bundle);
        List<PhotoInfo> list = this.f57989m;
        if (list != null && list.size() > 0) {
            this.I = (this.f57989m.get(0).opMask & 268435456) == 0;
        } else {
            this.I = true;
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onActivityResult(int i3, int i16, Intent intent) {
        super.onActivityResult(i3, i16, intent);
        if (intent == null) {
            QLog.e("QZoneFeedxLayerCommentInputPart", 1, "[onActivityResult] current data should not be null. error: ", new Exception());
        } else if (i3 == 2) {
            this.H = false;
            if (i16 == -1) {
                U9(intent);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (view.getId() == R.id.n0c) {
            T9();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.reborn.layer.part.ap
    public void onHandleMessage(Message message) {
        QZoneResult unpack = QZoneResult.unpack(message);
        if (unpack != null && unpack.what == 999905) {
            if (unpack.getSucceed()) {
                if (Q9()) {
                    V9();
                }
                broadcastMessage("FEEDX_LAYER_COMMENT_SUCCESS", null);
                if (this.L != null) {
                    SimpleEventBus.getInstance().dispatchEvent(new QZoneFeedxLayerAddDanmakuEvent(this.L));
                    this.L = null;
                }
                if (this.f57984d != null) {
                    SimpleEventBus.getInstance().dispatchEvent(new QZoneFeedxLayerCommentEvent(this.f57984d.lloc), true);
                    return;
                }
                return;
            }
            ToastUtil.s(unpack.getMessage(), 4);
            com.qzone.util.o.d(getContext(), unpack.getReturnCode());
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View view) {
        super.onInitView(view);
        TextView textView = (TextView) view.findViewById(R.id.n0c);
        this.G = textView;
        textView.setOnClickListener(this);
        RFWIocAbilityProvider.g().registerIoc(view, this, pk.a.class);
    }

    private void T9() {
        this.H = true;
        X0("", this.K);
        if (B9() != null) {
            B9().H3();
        }
    }

    private boolean S9(PhotoInfo photoInfo) {
        PhotoParam photoParam;
        if (photoInfo == null || (photoParam = this.f57988i) == null) {
            return false;
        }
        int i3 = photoParam.appid;
        if (i3 == 4) {
            if (photoParam.uploadnum <= 1 || (photoInfo.opsynflag & 8) == 0) {
                return false;
            }
        } else {
            if (i3 == 311) {
                return false;
            }
            if ((i3 != 6100 && i3 != 2) || photoParam.uploadnum <= 1) {
                return false;
            }
        }
        return true;
    }

    private void W9(QZoneCommentPanelResultBean qZoneCommentPanelResultBean) {
        String str;
        String str2;
        if (qZoneCommentPanelResultBean == null) {
            return;
        }
        String str3 = "";
        if (qZoneCommentPanelResultBean.getFontInfo() == null) {
            str = "";
            str2 = str;
        } else {
            str = qZoneCommentPanelResultBean.getFontInfo().getId() + "";
            str2 = qZoneCommentPanelResultBean.getFontInfo().getFontFormatType() + "";
        }
        QzoneSuperPersonalFontData.SuperFontInfo fromJson = qZoneCommentPanelResultBean.getSuperFontInfo() != null ? QzoneSuperPersonalFontData.SuperFontInfo.fromJson(qZoneCommentPanelResultBean.getSuperFontInfo().getFontJson()) : null;
        if (qZoneCommentPanelResultBean.getBarrageEffectInfo() != null) {
            str3 = qZoneCommentPanelResultBean.getBarrageEffectInfo().getBarrageJson();
        }
        this.L = new PhotoDanmakuModel(LoginData.getInstance().getNickName(com.qzone.util.l.a(R.string.s3y)), LoginData.getInstance().getUin(), qZoneCommentPanelResultBean.getInputContent(), fromJson, str, str2, "", !TextUtils.isEmpty(str3) ? QzoneBarrageEffectData.BarrageEffectInfo.fromJson(str3) : null);
    }
}
