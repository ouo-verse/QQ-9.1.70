package com.tencent.biz.qqcircle.immersive.part;

import com.tencent.biz.qqcircle.QCirclePluginUtil;
import com.tencent.biz.qqcircle.immersive.tab.QFSFolderTabFragment;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;

/* compiled from: P */
/* loaded from: classes4.dex */
public class fk extends u {

    /* renamed from: d, reason: collision with root package name */
    private long f88115d;

    @Override // com.tencent.biz.richframework.part.Part
    public boolean onBackEvent() {
        if (x9()) {
            return z9();
        }
        return false;
    }

    public boolean x9() {
        if (QCirclePluginUtil.isInLocalActivity(getActivity()) && !com.tencent.biz.qqcircle.utils.bz.l()) {
            return ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_enable_double_slide_exit", true);
        }
        return false;
    }

    public boolean z9() {
        QFSFolderTabFragment qFSFolderTabFragment = null;
        Object broadcastGetMessage = broadcastGetMessage("action_get_fragment", null);
        if (broadcastGetMessage instanceof QFSFolderTabFragment) {
            qFSFolderTabFragment = (QFSFolderTabFragment) broadcastGetMessage;
        }
        if (qFSFolderTabFragment == null) {
            return false;
        }
        if (System.currentTimeMillis() - this.f88115d > 3000) {
            qFSFolderTabFragment.Gh();
            this.f88115d = System.currentTimeMillis();
            return true;
        }
        qFSFolderTabFragment.wh();
        return false;
    }
}
