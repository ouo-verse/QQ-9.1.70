package com.tencent.mobileqq.newnearby.impl;

import android.content.Context;
import android.os.Bundle;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.newnearby.INearbyFollowHelper;
import com.tencent.mobileqq.newnearby.servlet.ServletObserver;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.nowsummarycard.NowSummaryCard$NearbyUserFollowReq;
import com.tencent.nowsummarycard.NowSummaryCard$NearbyUserFollowRsp;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes33.dex */
public class NearbyFollowHelperImpl implements INearbyFollowHelper {
    private static final String MSG_SYSTEM_ERROR = "system error";
    private static final String TAG = "NearbyFollowHelperImpl";

    @Override // com.tencent.mobileqq.newnearby.INearbyFollowHelper
    public void followByOption(AppInterface appInterface, Context context, String str, String str2, INearbyFollowHelper.a aVar) {
        NowSummaryCard$NearbyUserFollowReq nowSummaryCard$NearbyUserFollowReq = new NowSummaryCard$NearbyUserFollowReq();
        nowSummaryCard$NearbyUserFollowReq.from.set(0);
        nowSummaryCard$NearbyUserFollowReq.id_type.set(0);
        try {
            nowSummaryCard$NearbyUserFollowReq.target_id.set(Long.parseLong(str2));
            nowSummaryCard$NearbyUserFollowReq.operation.set(Integer.parseInt(str));
            com.tencent.mobileqq.newnearby.servlet.b.a(new a(aVar), nowSummaryCard$NearbyUserFollowReq.toByteArray(), "NowSummaryCard.NearbyUserFollow");
        } catch (NumberFormatException e16) {
            QLog.e(TAG, 1, e16.getMessage());
        }
    }

    /* compiled from: P */
    /* loaded from: classes33.dex */
    class a extends ServletObserver {

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ INearbyFollowHelper.a f254222f;

        a(INearbyFollowHelper.a aVar) {
            this.f254222f = aVar;
        }

        @Override // com.tencent.mobileqq.newnearby.servlet.ServletObserver
        public void c(int i3, byte[] bArr, Bundle bundle) {
            if (i3 != 0) {
                this.f254222f.a(i3, NearbyFollowHelperImpl.MSG_SYSTEM_ERROR, 0);
                return;
            }
            NowSummaryCard$NearbyUserFollowRsp nowSummaryCard$NearbyUserFollowRsp = new NowSummaryCard$NearbyUserFollowRsp();
            try {
                nowSummaryCard$NearbyUserFollowRsp.mergeFrom(bArr);
                this.f254222f.a(nowSummaryCard$NearbyUserFollowRsp.ret_code.get(), nowSummaryCard$NearbyUserFollowRsp.err_msg.get().toStringUtf8(), nowSummaryCard$NearbyUserFollowRsp.status.get());
            } catch (InvalidProtocolBufferMicroException e16) {
                QLog.e(NearbyFollowHelperImpl.TAG, 1, "pb parse error: " + e16.getMessage());
            }
        }
    }
}
