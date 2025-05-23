package com.tencent.gamecenter.wadl.notification;

import android.os.Build;
import android.view.WindowManager;
import com.tencent.gamecenter.wadl.biz.entity.WadlResult;
import java.util.List;

/* compiled from: P */
/* loaded from: classes6.dex */
public class f {
    public static WindowManager.LayoutParams a() {
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        if (Build.VERSION.SDK_INT >= 26) {
            layoutParams.type = 2038;
        } else {
            layoutParams.type = 2003;
        }
        layoutParams.flags = 16910120;
        layoutParams.systemUiVisibility = 4102;
        layoutParams.format = -3;
        layoutParams.width = -2;
        layoutParams.height = -2;
        return layoutParams;
    }

    public static WadlResult b(List<WadlResult> list, boolean z16) {
        WadlResult wadlResult = null;
        if (list == null) {
            return null;
        }
        for (WadlResult wadlResult2 : list) {
            if (wadlResult2.isDownloadComplete()) {
                if (!z16 || !wadlResult2.wadlParams.isExtFlagEnable(8)) {
                    if (wadlResult != null && wadlResult.isDownloadComplete() && wadlResult2.createTime >= wadlResult.createTime) {
                    }
                    wadlResult = wadlResult2;
                }
            } else if (wadlResult == null || !wadlResult.isDownloadComplete()) {
                if (wadlResult != null) {
                    if (wadlResult2.isRunning()) {
                        if (wadlResult.isRunning() && wadlResult2.createTime >= wadlResult.createTime) {
                        }
                    } else if (!wadlResult.isRunning() && wadlResult2.createTime < wadlResult.createTime) {
                    }
                }
                wadlResult = wadlResult2;
            }
        }
        return wadlResult;
    }
}
