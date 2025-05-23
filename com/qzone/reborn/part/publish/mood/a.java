package com.qzone.reborn.part.publish.mood;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import com.qzone.common.account.LoginData;
import com.qzone.publish.service.QzoneNewCardSkinService;
import com.qzone.reborn.base.k;
import com.qzone.reborn.route.QZonePublishMoodInitBean;
import com.qzone.reborn.util.l;
import com.tencent.mobileqq.vas.VasLogReporter;
import com.tencent.mobileqq.vas.VasToggle;
import common.config.service.QzoneConfig;
import cooperation.qzone.util.QZLog;
import cooperation.qzone.webviewplugin.QZoneJsConstants;

/* compiled from: P */
/* loaded from: classes37.dex */
public class a extends k {
    private boolean D9() {
        return QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.SECONDARY_KEY_NEW_STYLE_SHUOSHUO_NEW_CARD_SWITCH, 0) == 0;
    }

    public boolean C9() {
        Activity activity = getActivity();
        if (activity == null) {
            return false;
        }
        Intent intent = activity.getIntent();
        if (intent == null) {
            QZLog.i("QZonePublishNewCardPart", "@newcard getIntent is null isShowNewCardEntrance()");
            return false;
        }
        if (VasToggle.BUG_108919712.isEnable(true)) {
            intent.putExtra(QZoneJsConstants.KEY_NEW_CARD_IS_NEED_SHOW, true);
            return true;
        }
        Parcelable parcelableExtra = intent.getParcelableExtra("qzone_route_bean");
        boolean booleanExtra = intent.getBooleanExtra(QZoneJsConstants.KEY_NEW_CARD_IS_NEED_SHOW, false);
        if (parcelableExtra instanceof QZonePublishMoodInitBean) {
            booleanExtra = l.f59550a.Q((QZonePublishMoodInitBean) parcelableExtra, intent);
        }
        if (booleanExtra) {
            VasLogReporter.getQzoneFeedsCard().report("NewCardPart isShowNewCard from intent: true");
        } else {
            if (!D9()) {
                VasLogReporter.getQzoneFeedsCard().report("NewCardPart isShowNewCard from wns config:false");
                intent.putExtra(QZoneJsConstants.KEY_NEW_CARD_IS_NEED_SHOW, false);
                return false;
            }
            intent.putExtra(QZoneJsConstants.KEY_NEW_CARD_IS_NEED_SHOW, true);
        }
        return booleanExtra;
    }

    @Override // com.tencent.biz.richframework.part.Part
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QZonePublishNewCardPart";
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartCreate(Activity activity, Bundle bundle) {
        super.onPartCreate(activity, bundle);
        if (C9()) {
            QzoneNewCardSkinService.F().U(LoginData.getInstance().getUin(), null, VasToggle.QZONE_FEED_SKIN_FORCE_REQ.isEnable(true));
            QzoneNewCardSkinService.F().T(LoginData.getInstance().getUin(), false);
        }
    }
}
