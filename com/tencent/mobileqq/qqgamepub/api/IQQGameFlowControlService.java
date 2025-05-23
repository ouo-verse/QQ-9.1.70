package com.tencent.mobileqq.qqgamepub.api;

import com.tencent.gamecenter.wadl.biz.listener.WadlTrpcListener;
import com.tencent.mobileqq.qqgamepub.data.e;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import java.util.List;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes16.dex */
public interface IQQGameFlowControlService extends QRouteApi {
    public static final String CMD_RES_FLOW_CONTROL_BATCH = "/v1/616";
    public static final int SCENE_DSL_FLOW_CONTROL = 2;
    public static final int SCENE_FACE_FLOW_CONTROL = 3;
    public static final int SCENE_RES_FLOW_CONTROL = 1;

    void checkResFlowControl(int i3, List<String> list, WadlTrpcListener wadlTrpcListener);

    void checkResFlowControl(String str, WadlTrpcListener wadlTrpcListener);

    void checkResFlowControl(String str, String str2, WadlTrpcListener wadlTrpcListener);

    e getFlowControlConfig(String str);

    void saveFlowControlConfig(String str, long j3, long j16);
}
