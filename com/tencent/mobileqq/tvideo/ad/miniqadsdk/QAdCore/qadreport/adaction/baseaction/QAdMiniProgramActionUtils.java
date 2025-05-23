package com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.adaction.baseaction;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadcore.wx.OpenSdkManager;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.core.d;
import com.tencent.qqlive.ona.protocol.jce.AdOpenMiniProgramItem;
import com.tencent.qqlive.ona.protocol.jce.AdUrlItem;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import pw2.n;

/* loaded from: classes19.dex */
public class QAdMiniProgramActionUtils {

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes19.dex */
    public @interface MiniProgramValidState {
        public static final int ITEM_DATA_INVALID = 3;
        public static final int VALID = 0;
        public static final int WX_NOT_INSTALL = 1;
        public static final int WX_NOT_SUPPORT = 2;
    }

    private static boolean a(@Nullable AdOpenMiniProgramItem adOpenMiniProgramItem) {
        AdUrlItem adUrlItem;
        if (adOpenMiniProgramItem != null && !TextUtils.isEmpty(adOpenMiniProgramItem.appName) && (adUrlItem = adOpenMiniProgramItem.urlItem) != null && !TextUtils.isEmpty(adUrlItem.url)) {
            return true;
        }
        return false;
    }

    public static int b(@Nullable AdOpenMiniProgramItem adOpenMiniProgramItem) {
        if (!a(adOpenMiniProgramItem)) {
            n.h("QAdMiniProgramActionUtils", "openItem is inValid");
            return 3;
        }
        OpenSdkManager openSdkManager = OpenSdkManager.INSTANCE;
        if (!openSdkManager.isWXInstalled()) {
            n.h("QAdMiniProgramActionUtils", "wx not install");
            return 1;
        }
        if (!openSdkManager.isWXAppSupportAPI()) {
            n.h("QAdMiniProgramActionUtils", "wx is not support api");
            return 2;
        }
        return 0;
    }

    public static int c(@Nullable AdOpenMiniProgramItem adOpenMiniProgramItem, d dVar) {
        if (dVar == null) {
            return 3;
        }
        return b(adOpenMiniProgramItem);
    }
}
