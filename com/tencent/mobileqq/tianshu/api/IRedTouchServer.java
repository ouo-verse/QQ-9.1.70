package com.tencent.mobileqq.tianshu.api;

import com.tencent.mobileqq.qroute.annotation.Service;
import com.tencent.mobileqq.tianshu.data.RedPointHolder;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.api.IRuntimeService;

/* compiled from: P */
@Service(needUin = false, process = {""})
/* loaded from: classes18.dex */
public interface IRedTouchServer extends IRuntimeHandler, IRuntimeService {
    void forceSendReq(int i3);

    List<RedPointHolder> getLebaPlugRedPointIds(AppRuntime appRuntime);

    void notifyRedTouchUpdate(AppRuntime appRuntime);

    void sendRedpointReq(boolean z16, boolean z17, int i3);

    void sendRedpointReq(boolean z16, boolean z17, int i3, List<String> list);
}
