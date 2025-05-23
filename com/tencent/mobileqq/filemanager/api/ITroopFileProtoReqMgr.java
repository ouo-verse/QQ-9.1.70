package com.tencent.mobileqq.filemanager.api;

import android.content.Intent;
import com.tencent.mobileqq.qroute.annotation.Service;
import com.tencent.qphone.base.remote.FromServiceMsg;
import mqq.app.api.IRuntimeService;
import qb1.g;

@Service(process = {""})
/* loaded from: classes12.dex */
public interface ITroopFileProtoReqMgr extends IRuntimeService {
    void cancelRequest(g gVar);

    g createProtoReq();

    void onReceive(Intent intent, FromServiceMsg fromServiceMsg);

    void sendProtoRequest(g gVar);
}
