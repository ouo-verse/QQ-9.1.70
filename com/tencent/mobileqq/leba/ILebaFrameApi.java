package com.tencent.mobileqq.leba;

import com.tencent.mobileqq.app.Frame;
import com.tencent.mobileqq.app.FrameFragment;
import com.tencent.mobileqq.app.be;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes15.dex */
public interface ILebaFrameApi extends QRouteApi {
    Class<? extends Frame> getLebaFrameClass();

    boolean isLeba(String str);

    boolean isLebaFrame(be beVar);

    Frame newLebaFrame(FrameFragment frameFragment);

    void onPostThemeChanged(be beVar);

    void onSwitchToLeba(be beVar, boolean z16, BusinessInfoCheckUpdate.RedTypeInfo redTypeInfo);

    void showLebaFrame();

    void showQzoneFrame();
}
