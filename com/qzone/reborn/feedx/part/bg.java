package com.qzone.reborn.feedx.part;

import android.app.Activity;
import android.os.Message;
import android.view.View;
import com.qzone.common.account.LoginData;
import com.qzone.common.business.result.QZoneResult;
import com.qzone.feed.business.model.QZoneTeenOnlineTimeLimitManager;
import com.tencent.mobileqq.studymode.StudyModeManager;
import cooperation.qzone.util.QZoneTeenOnlineTimeHelper;

/* compiled from: P */
/* loaded from: classes37.dex */
public class bg extends g {

    /* renamed from: d, reason: collision with root package name */
    private QZoneTeenOnlineTimeLimitManager f55045d;

    @Override // com.qzone.reborn.base.k, com.tencent.biz.richframework.part.Part
    public boolean isPartEnable() {
        return super.isPartEnable() && StudyModeManager.t();
    }

    @Override // com.qzone.reborn.feedx.part.g, com.qzone.reborn.feedx.viewmodel.b
    public void onHandleMessage(Message message) {
        QZoneTeenOnlineTimeLimitManager qZoneTeenOnlineTimeLimitManager;
        super.onHandleMessage(message);
        QZoneResult unpack = QZoneResult.unpack(message);
        if (message.what == 1000041 && unpack != null && unpack.getSucceed() && StudyModeManager.t() && QZoneTeenOnlineTimeHelper.isForbidEnterQZone(LoginData.getInstance().getUin()) && (qZoneTeenOnlineTimeLimitManager = this.f55045d) != null) {
            qZoneTeenOnlineTimeLimitManager.l();
        }
    }

    @Override // com.qzone.reborn.feedx.part.g, com.tencent.biz.richframework.part.Part
    public void onInitView(View view) {
        super.onInitView(view);
        this.f55045d = new QZoneTeenOnlineTimeLimitManager(getActivity());
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        super.onPartDestroy(activity);
        QZoneTeenOnlineTimeLimitManager qZoneTeenOnlineTimeLimitManager = this.f55045d;
        if (qZoneTeenOnlineTimeLimitManager != null) {
            qZoneTeenOnlineTimeLimitManager.e();
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartPause(Activity activity) {
        super.onPartPause(activity);
        QZoneTeenOnlineTimeLimitManager qZoneTeenOnlineTimeLimitManager = this.f55045d;
        if (qZoneTeenOnlineTimeLimitManager != null) {
            qZoneTeenOnlineTimeLimitManager.f();
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartResume(Activity activity) {
        QZoneTeenOnlineTimeLimitManager qZoneTeenOnlineTimeLimitManager;
        super.onPartResume(activity);
        QZoneTeenOnlineTimeLimitManager qZoneTeenOnlineTimeLimitManager2 = this.f55045d;
        if (qZoneTeenOnlineTimeLimitManager2 != null) {
            qZoneTeenOnlineTimeLimitManager2.g();
        }
        if (StudyModeManager.t() && QZoneTeenOnlineTimeHelper.isForbidEnterQZone(LoginData.getInstance().getUin()) && (qZoneTeenOnlineTimeLimitManager = this.f55045d) != null) {
            qZoneTeenOnlineTimeLimitManager.l();
        }
    }
}
