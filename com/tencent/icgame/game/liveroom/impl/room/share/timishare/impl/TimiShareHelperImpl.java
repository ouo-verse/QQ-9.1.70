package com.tencent.icgame.game.liveroom.impl.room.share.timishare.impl;

import android.content.Intent;
import android.text.TextUtils;
import com.tencent.icgame.game.liveroom.impl.room.share.timishare.ITimiShareHelper;
import com.tencent.icgame.game.liveroom.impl.room.share.timishare.a;
import com.tencent.icgame.game.liveroom.impl.room.share.timishare.c;
import com.tencent.icgame.game.liveroom.impl.room.share.timishare.impl.TimiShareHelperImpl;
import com.tencent.icgame.game.sso.request.ICGameSendArkRequest;
import com.tencent.mobileqq.icgame.api.ILiveNetRequest;
import com.tencent.mobileqq.icgame.api.sso.QQLiveResponse;
import com.tencent.mobileqq.qroute.QRoute;

/* compiled from: P */
/* loaded from: classes7.dex */
public class TimiShareHelperImpl implements ITimiShareHelper {
    private static final String TAG = "ICGameShare|ICGameShareHelperImpl";

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$sendArkMsg$0(a aVar, QQLiveResponse qQLiveResponse) {
        rt0.a.f(TAG, "sendArkMsg ret", "isSuccess=" + qQLiveResponse.isSuccess() + ", errCode=" + qQLiveResponse.getRetCode() + ", errMsg=" + qQLiveResponse.getErrMsg());
        if (qQLiveResponse.isSuccess()) {
            aVar.onSuccess();
        } else {
            aVar.a(qQLiveResponse.getRetCode(), qQLiveResponse.getErrMsg());
        }
    }

    @Override // com.tencent.icgame.game.liveroom.impl.room.share.timishare.ITimiShareHelper
    public Intent getShareArkIntent(c cVar) {
        return zw0.a.c(cVar);
    }

    @Override // com.tencent.icgame.game.liveroom.impl.room.share.timishare.ITimiShareHelper
    public String getShareDetailUrl(c cVar, int i3) {
        return zw0.a.d(cVar, i3);
    }

    @Override // com.tencent.icgame.game.liveroom.impl.room.share.timishare.ITimiShareHelper
    public String getShareSingleTitle(String str) {
        return zw0.a.e(str);
    }

    @Override // com.tencent.icgame.game.liveroom.impl.room.share.timishare.ITimiShareHelper
    public String getShareSummary(String str) {
        return zw0.a.f(str);
    }

    @Override // com.tencent.icgame.game.liveroom.impl.room.share.timishare.ITimiShareHelper
    public void sendArkMsg(int i3, String str, String str2, String str3, final a aVar) {
        rt0.a.f(TAG, "sendArkMsg", "uinType:" + i3 + " uinStr:" + str + " metaData:" + str2 + " prompt:" + str3 + " listener:" + aVar);
        long j3 = 0;
        try {
            if (!TextUtils.isEmpty(str)) {
                j3 = Long.parseLong(str);
            }
        } catch (Exception e16) {
            rt0.a.c(TAG, "sendArkMsg", "parse uin fail! " + e16.getMessage());
        }
        ((ILiveNetRequest) QRoute.api(ILiveNetRequest.class)).sendRequest(new ICGameSendArkRequest(i3, j3, str2, str3), new ILiveNetRequest.Callback() { // from class: ax0.a
            @Override // com.tencent.mobileqq.icgame.api.ILiveNetRequest.Callback
            public final void onResponse(QQLiveResponse qQLiveResponse) {
                TimiShareHelperImpl.lambda$sendArkMsg$0(com.tencent.icgame.game.liveroom.impl.room.share.timishare.a.this, qQLiveResponse);
            }
        });
    }
}
