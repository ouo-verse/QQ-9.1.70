package com.qzone.reborn.feedx.part;

import android.app.Activity;
import android.view.View;
import com.tencent.mobileqq.activity.miniaio.MiniMsgUser;
import com.tencent.mobileqq.activity.miniaio.MiniMsgUserParam;
import common.config.service.QzoneConfig;

/* compiled from: P */
/* loaded from: classes37.dex */
public class am extends com.qzone.reborn.base.k {

    /* renamed from: d, reason: collision with root package name */
    private MiniMsgUser f55006d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f55007e = false;

    /* renamed from: f, reason: collision with root package name */
    private boolean f55008f = false;

    protected MiniMsgUserParam C9() {
        MiniMsgUserParam miniMsgUserParam = new MiniMsgUserParam();
        miniMsgUserParam.businessName = 1;
        miniMsgUserParam.accessType = 0;
        miniMsgUserParam.entryType = 0;
        miniMsgUserParam.positionX = -1;
        miniMsgUserParam.positionY = -1;
        miniMsgUserParam.colorType = 0;
        miniMsgUserParam.filterMsgType = 0;
        return miniMsgUserParam;
    }

    public boolean D9() {
        return this.f55007e && getActivity() != null;
    }

    @Override // com.tencent.biz.richframework.part.Part
    public String getLogTag() {
        return "QZoneFeedxMiniAioPart";
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View view) {
        super.onInitView(view);
        this.f55007e = QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.SECONDARY_MINI_AIO, true);
        if (D9()) {
            this.f55006d = new MiniMsgUser(getActivity(), C9());
        }
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        MiniMsgUser miniMsgUser;
        super.onPartDestroy(activity);
        if (!D9() || (miniMsgUser = this.f55006d) == null) {
            return;
        }
        miniMsgUser.destroy();
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartPause(Activity activity) {
        MiniMsgUser miniMsgUser;
        super.onPartPause(activity);
        if (!D9() || (miniMsgUser = this.f55006d) == null) {
            return;
        }
        miniMsgUser.onBackground();
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartResume(Activity activity) {
        MiniMsgUser miniMsgUser;
        super.onPartResume(activity);
        if (!D9() || (miniMsgUser = this.f55006d) == null) {
            return;
        }
        miniMsgUser.onForeground();
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onWindowFocusChanged(boolean z16) {
        MiniMsgUser miniMsgUser;
        super.onWindowFocusChanged(z16);
        if (!D9() || !z16 || this.f55008f || (miniMsgUser = this.f55006d) == null) {
            return;
        }
        miniMsgUser.showOnFirst();
        this.f55008f = true;
    }
}
