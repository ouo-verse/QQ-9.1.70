package com.tencent.biz.pubaccount.weishi.push.biz;

import android.content.Intent;
import com.tencent.biz.pubaccount.weishi.push.IWSPushBaseStrategy;
import com.tencent.biz.pubaccount.weishi.push.WSRedDotPushMsg;

/* compiled from: P */
/* loaded from: classes32.dex */
public class g {
    public static a a(WSRedDotPushMsg wSRedDotPushMsg, int i3, Intent intent) {
        if (wSRedDotPushMsg == null) {
            return null;
        }
        IWSPushBaseStrategy iWSPushBaseStrategy = wSRedDotPushMsg.mStrategyInfo;
        int type = iWSPushBaseStrategy != null ? iWSPushBaseStrategy.getType() : 0;
        if (i3 == 2) {
            if (type == 1) {
                return new h(wSRedDotPushMsg);
            }
            if (type == 5) {
                return new c(wSRedDotPushMsg);
            }
            if (type == 6 || type == 7) {
                return new b(wSRedDotPushMsg);
            }
            if (type == 8) {
                return new f(wSRedDotPushMsg);
            }
        }
        if (type == 2) {
            return new i(wSRedDotPushMsg, i3, intent);
        }
        if (type == 3) {
            return new WSWeSeeClientBiz(wSRedDotPushMsg, i3, intent);
        }
        if (type == 4) {
            return new e(wSRedDotPushMsg, i3);
        }
        if (i3 == 2) {
            return new h(wSRedDotPushMsg);
        }
        if (i3 == 6) {
            return new i(wSRedDotPushMsg, i3, intent);
        }
        return null;
    }
}
