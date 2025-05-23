package com.tencent.mobileqq.mini.out;

import android.os.Bundle;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.proto.lbsshare.LBSShare$LocationResp;
import com.tencent.qphone.base.remote.FromServiceMsg;
import mqq.observer.BusinessObserver;

/* compiled from: P */
/* loaded from: classes15.dex */
public class CommonObserver implements BusinessObserver {
    public static final String KEY_REQ = "req";
    public static final String KEY_RSP = "rsp";

    @Override // mqq.observer.BusinessObserver
    public void onReceive(int i3, boolean z16, Bundle bundle) {
        FromServiceMsg fromServiceMsg = (FromServiceMsg) bundle.getParcelable("rsp");
        String str = null;
        LBSShare$LocationResp mergeFrom = null;
        if (i3 == 1) {
            if (z16) {
                try {
                    mergeFrom = new LBSShare$LocationResp().mergeFrom(fromServiceMsg.getWupBuffer());
                } catch (InvalidProtocolBufferMicroException e16) {
                    e16.printStackTrace();
                    return;
                }
            }
            onGetPoiList(z16, mergeFrom);
            return;
        }
        if (i3 == 2) {
            if (z16) {
                str = new String(fromServiceMsg.getWupBuffer());
            }
            onGetStreetUrl(z16, str);
        }
    }

    public void onGetPoiList(boolean z16, LBSShare$LocationResp lBSShare$LocationResp) {
    }

    public void onGetStreetUrl(boolean z16, String str) {
    }
}
