package com.tencent.biz.pubaccount.weishi.push.biz;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.biz.pubaccount.weishi.main.a;
import com.tencent.biz.pubaccount.weishi.push.WSPushStrategyInfo;
import com.tencent.biz.pubaccount.weishi.push.WSRedDotPushMsg;
import com.tencent.biz.pubaccount.weishi.verticalvideo.k;
import com.tencent.biz.pubaccount.weishi.z;

/* compiled from: P */
/* loaded from: classes32.dex */
public class i extends a<WSRedDotPushMsg, WSPushStrategyInfo> {

    /* renamed from: b, reason: collision with root package name */
    private int f81350b;

    /* renamed from: c, reason: collision with root package name */
    private Intent f81351c;

    public i(WSRedDotPushMsg wSRedDotPushMsg, int i3, Intent intent) {
        super(wSRedDotPushMsg);
        this.f81350b = i3;
        this.f81351c = intent;
    }

    @Override // com.tencent.biz.pubaccount.weishi.push.biz.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public boolean a(Context context, WSPushStrategyInfo wSPushStrategyInfo) {
        int i3 = this.f81350b;
        if (i3 == 2) {
            a.b.c(new k(context, "aio_new_msg", "direct"));
            return true;
        }
        if (i3 != 6) {
            return false;
        }
        z.c((Activity) context, this.f81351c, (WSRedDotPushMsg) this.f81348a);
        return true;
    }
}
