package com.tencent.mobileqq.newnearby.impl;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.newnearby.INearbyAioHelper;
import com.tencent.mobileqq.newnearby.servlet.ServletObserver;
import com.tencent.mobileqq.protocol.NearbyRelation$SsoSetGreetOriginReq;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes33.dex */
public class NearbyAioHelperImpl implements INearbyAioHelper {
    public static final int SOURCE_DEFAULT = 1;
    public static final int SOURCE_MATCH = 4;
    public static final int SOURCE_MOMENT = 3;
    public static final int SOURCE_MSG_LIST = 8;
    public static final int SOURCE_PEOPLE_LIST = 2;
    public static final int SOURCE_YL_VOICE = 5;
    public static final int SOURCE_YQ_FEICHE = 7;
    public static final int SOURCE_YQ_WANGZHE = 6;
    private static final String TAG = "NearbyAioHelperImpl";

    @Override // com.tencent.mobileqq.newnearby.INearbyAioHelper
    public void notifyServerEnterSource(long j3, int i3) {
        NearbyRelation$SsoSetGreetOriginReq nearbyRelation$SsoSetGreetOriginReq = new NearbyRelation$SsoSetGreetOriginReq();
        nearbyRelation$SsoSetGreetOriginReq.to_tinyid.set(j3);
        nearbyRelation$SsoSetGreetOriginReq.origin_id.set(i3);
        com.tencent.mobileqq.newnearby.servlet.b.a(new a(), nearbyRelation$SsoSetGreetOriginReq.toByteArray(), "trpc.nearby.trpc_nearby_relation.NearbyRelation.SsoSetGreetOrigin");
    }

    @Override // com.tencent.mobileqq.newnearby.INearbyAioHelper
    public void openAioFromYQYL(long j3, int i3, String str, byte[] bArr) {
        notifyServerEnterSource(j3, i3);
        Intent intent = new Intent(QBaseActivity.sTopActivity, (Class<?>) ChatActivity.class);
        intent.putExtra("uin", String.valueOf(j3));
        intent.putExtra("uinname", str);
        intent.putExtra("uintype", 1001);
        intent.addFlags(67108864);
        intent.putExtra("ProfileCard_fromId", i3);
        intent.putExtra(AppConstants.Key.KYE_RICH_ACCOST_SIG, bArr);
        QBaseActivity.sTopActivity.startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes33.dex */
    public class a extends ServletObserver {
        a() {
        }

        @Override // com.tencent.mobileqq.newnearby.servlet.ServletObserver
        public void c(int i3, byte[] bArr, Bundle bundle) {
            if (i3 != 0) {
                QLog.e(NearbyAioHelperImpl.TAG, 2, "notifyServerEnterSource fail");
            }
        }
    }
}
