package com.tencent.biz.pubaccount.weishi.push.biz;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.weishi.push.WSPushStrategyInfo;
import com.tencent.biz.pubaccount.weishi.push.WSRedDotPushMsg;
import com.tencent.biz.pubaccount.weishi.report.WSReportDc00898;
import com.tencent.biz.pubaccount.weishi.util.bb;
import com.tencent.biz.pubaccount.weishi.z;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* compiled from: P */
/* loaded from: classes32.dex */
public class e extends a<WSRedDotPushMsg, WSPushStrategyInfo> {

    /* renamed from: b, reason: collision with root package name */
    private final int f81349b;

    public e(WSRedDotPushMsg wSRedDotPushMsg, int i3) {
        super(wSRedDotPushMsg);
        this.f81349b = i3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Unit d() {
        bb.Q();
        return null;
    }

    @Override // com.tencent.biz.pubaccount.weishi.push.biz.a
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public boolean a(Context context, WSPushStrategyInfo wSPushStrategyInfo) {
        String str;
        if (wSPushStrategyInfo == null) {
            return false;
        }
        boolean isEmpty = TextUtils.isEmpty(wSPushStrategyInfo.mScheme);
        if (!isEmpty) {
            z.h(context, wSPushStrategyInfo.mScheme);
            ty.g.f437886a.p(new Function0() { // from class: com.tencent.biz.pubaccount.weishi.push.biz.d
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    Unit d16;
                    d16 = e.d();
                    return d16;
                }
            });
        }
        int i3 = this.f81349b;
        if (i3 == 2) {
            int i16 = isEmpty ? 2 : 1;
            MSG msg2 = this.f81348a;
            if (msg2 == 0) {
                str = "";
            } else {
                str = ((WSRedDotPushMsg) msg2).mFeedIds;
            }
            WSReportDc00898.k(i16, 1, str);
        } else if (i3 == 6) {
            WSReportDc00898.y(isEmpty ? 2 : 1);
        }
        return !isEmpty;
    }
}
