package com.qzone.reborn.layer.share;

import android.app.Activity;
import com.qzone.misc.network.report.ClickReport;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.mobileqq.vas.theme.ThemeSwitchUtil;

/* compiled from: P */
/* loaded from: classes37.dex */
public class g extends QZoneBaseShareAction {
    public g(Activity activity) {
        super(activity);
    }

    @Override // com.qzone.reborn.layer.share.QZoneBaseShareAction
    void j(f fVar, ShareActionSheetBuilder.ActionSheetItem actionSheetItem) {
        vo.c.D(n(), fVar.f58179c.bigUrl);
        ClickReport.q(ThemeSwitchUtil.FROM_LOGIN_RESULT, "5", "36", true);
    }

    @Override // com.qzone.reborn.layer.share.QZoneBaseShareAction
    public int[] s() {
        return new int[]{107};
    }
}
