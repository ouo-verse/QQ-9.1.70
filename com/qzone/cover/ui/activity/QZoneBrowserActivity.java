package com.qzone.cover.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.qzone.common.activities.base.BaseFragment;
import cooperation.qzone.QZoneHelper;
import java.net.URISyntaxException;

/* compiled from: P */
/* loaded from: classes39.dex */
public class QZoneBrowserActivity extends BaseFragment {
    @Override // com.qzone.common.activities.base.BaseFragment
    public void finish() {
        super.finish();
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        Intent intent = getIntent();
        QZoneHelper.forwardToBrowser(getActivity(), intent.getStringExtra("url"), 9999, intent.getExtras(), "");
    }

    @Override // com.qzone.common.activities.base.BaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onActivityResult(int i3, int i16, Intent intent) {
        super.onActivityResult(i3, i16, intent);
        if (9999 == i3) {
            Intent intent2 = getIntent();
            if (intent2.getBooleanExtra("_ext_launch_activity_when_finish", false)) {
                String stringExtra = intent2.getStringExtra("_ext_launch_activity_uri");
                if (!TextUtils.isEmpty(stringExtra)) {
                    try {
                        Intent parseUri = Intent.parseUri(stringExtra, 0);
                        parseUri.addCategory("android.intent.category.BROWSABLE");
                        parseUri.setComponent(null);
                        parseUri.setSelector(null);
                        startActivity(parseUri);
                    } catch (URISyntaxException e16) {
                        e16.printStackTrace();
                    }
                }
            }
            finish();
        }
    }
}
