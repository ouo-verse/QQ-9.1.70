package com.tencent.mobileqq.gamecenter.api;

import android.os.Message;
import android.view.View;
import com.tencent.mobileqq.qroute.annotation.Service;
import mqq.app.api.IRuntimeService;

/* compiled from: P */
@Service(needUin = false, process = {""})
/* loaded from: classes12.dex */
public interface IYunGameTipsService extends IRuntimeService {
    void finish();

    void start();

    void updateTips(View view, Message message);
}
