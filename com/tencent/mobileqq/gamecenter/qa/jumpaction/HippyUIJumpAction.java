package com.tencent.mobileqq.gamecenter.qa.jumpaction;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.QQTranslucentBrowserActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.utils.ax;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.URLUtil;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes12.dex */
public class HippyUIJumpAction extends ax {
    /* JADX INFO: Access modifiers changed from: protected */
    public HippyUIJumpAction(BaseQQAppInterface baseQQAppInterface, Context context) {
        super(baseQQAppInterface, context);
    }

    private void F() {
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.gamecenter.qa.jumpaction.HippyUIJumpAction.1
            @Override // java.lang.Runnable
            public void run() {
                int i3;
                String str;
                try {
                    HashMap<String, String> hashMap = HippyUIJumpAction.this.f307441f;
                    if (hashMap != null) {
                        if (hashMap.containsKey("transparent")) {
                            i3 = Integer.parseInt(HippyUIJumpAction.this.f307441f.get("transparent"));
                        } else {
                            i3 = 0;
                        }
                        if (HippyUIJumpAction.this.f307441f.containsKey("url")) {
                            str = HippyUIJumpAction.this.f307441f.get("url");
                        } else {
                            str = "";
                        }
                        if (TextUtils.isEmpty(str)) {
                            str = URLUtil.decodeUrl(str);
                        }
                        Intent intent = new Intent();
                        if (i3 == 0) {
                            intent.setClass(BaseApplication.getContext(), QQBrowserActivity.class);
                        } else {
                            intent.setClass(BaseApplication.getContext(), QQTranslucentBrowserActivity.class);
                        }
                        intent.putExtra("url", str);
                        HippyUIJumpAction.this.f307437b.startActivity(intent);
                        QLog.i("HippyUIJumpAction", 1, "[openGameStrategyQuestion] attrs:" + HippyUIJumpAction.this.f307441f.toString());
                    }
                } catch (Exception e16) {
                    QLog.e("HippyUIJumpAction", 1, "openGameStrategyQuestion e:", e16);
                }
            }
        });
    }

    @Override // com.tencent.mobileqq.utils.ax
    public boolean b() {
        QLog.i("HippyUIJumpAction", 1, "doAction: action=" + this.f307440e);
        if ("openCustomWebView".equals(this.f307440e)) {
            F();
        }
        return true;
    }
}
