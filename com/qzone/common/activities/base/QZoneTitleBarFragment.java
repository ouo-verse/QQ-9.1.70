package com.qzone.common.activities.base;

import android.content.Intent;
import android.text.TextUtils;
import com.tencent.biz.richframework.part.Part;
import java.util.List;

/* compiled from: P */
/* loaded from: classes39.dex */
public class QZoneTitleBarFragment extends BaseFragment {
    @Override // com.qzone.common.activities.base.BaseFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public List<Part> assembleParts() {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.common.activities.base.BaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return 0;
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, com.tencent.biz.richframework.compat.IFragmentCallbacks
    public boolean onBackEvent() {
        finish();
        return false;
    }

    @Override // com.qzone.common.activities.base.BaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        String stringExtra = intent.getStringExtra("isFromQQ");
        if (TextUtils.isEmpty(stringExtra) || !stringExtra.equalsIgnoreCase("true")) {
            return;
        }
        getHandler().sendEmptyMessage(1);
    }
}
