package com.qzone.reborn.layer.share;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.DirectForwardActivity;
import com.tencent.mobileqq.app.AppConstants;

/* compiled from: P */
/* loaded from: classes37.dex */
public class u extends d {
    public u(Activity activity) {
        super(activity);
    }

    @Override // com.qzone.reborn.layer.share.d
    protected void S(String str) {
        Z(str);
    }

    @Override // com.qzone.reborn.layer.share.d
    public boolean Y() {
        return true;
    }

    protected void Z(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        Intent intent = new Intent();
        intent.setClass(n(), DirectForwardActivity.class);
        intent.putExtra("toUin", String.valueOf(this.f58114i.uin));
        intent.putExtra("uinType", this.f58114i.uinType);
        intent.putExtra("nickName", this.f58114i.label);
        intent.putExtra("forward_type", 1);
        intent.putExtra(AppConstants.Key.FORWARD_THUMB, str);
        intent.putExtra(AppConstants.Key.FORWARD_FILEPATH, str);
        intent.putExtra(AppConstants.Key.FORWARD_URLDRAWABLE_BIG_URL, str);
        intent.putExtra(AppConstants.Key.FORWARD_EXTRA, str);
        intent.putExtra("key_flag_from_plugin", true);
        n().startActivityForResult(intent, 1000);
    }

    @Override // com.qzone.reborn.layer.share.QZoneBaseShareAction
    public int[] s() {
        return new int[]{72};
    }
}
