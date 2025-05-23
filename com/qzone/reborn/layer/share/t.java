package com.qzone.reborn.layer.share;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.app.AppConstants;
import common.config.service.QZoneConfigHelper;

/* compiled from: P */
/* loaded from: classes37.dex */
public class t extends d {
    public t(Activity activity) {
        super(activity);
    }

    @Override // com.qzone.reborn.layer.share.d
    protected void S(String str) {
        Z(str);
    }

    protected void Z(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        Intent intent = new Intent();
        intent.setClass(n(), ForwardRecentActivity.class);
        intent.putExtra("forward_type", 1);
        intent.putExtra(AppConstants.Key.FORWARD_THUMB, str);
        intent.putExtra(AppConstants.Key.FORWARD_FILEPATH, str);
        intent.putExtra("key_flag_from_plugin", true);
        if (QZoneConfigHelper.v()) {
            intent.putExtra(ForwardRecentActivity.SELECTION_MODE, 2);
            intent.putExtra("isFromShare", true);
            intent.putExtra("sendMultiple", true);
        }
        n().startActivityForResult(intent, 1000);
    }

    @Override // com.qzone.reborn.layer.share.QZoneBaseShareAction
    public int[] s() {
        return new int[]{2};
    }
}
