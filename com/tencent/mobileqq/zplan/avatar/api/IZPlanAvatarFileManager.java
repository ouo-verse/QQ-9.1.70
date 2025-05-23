package com.tencent.mobileqq.zplan.avatar.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import java.util.List;

@QAPI(process = {"all"})
/* loaded from: classes21.dex */
public interface IZPlanAvatarFileManager extends QRouteApi {

    /* loaded from: classes21.dex */
    public interface a {
        void a(boolean z16, List<String> list, int i3);
    }

    void getAllFrameFiles(int i3, String str, int i16, int i17, a aVar);

    String getApngFilePath(int i3);

    void getSingleFrameFile(int i3, String str, a aVar);

    String getVideoFilePath(int i3);

    void putAction2ApngFilePath(int i3, String str);

    void putAction2FrameFilePath(int i3, List<String> list);

    void putAction2VideoFilePath(int i3, String str);

    void recordDynamicAvatar(int i3, String str, int i16, int i17, com.tencent.zplan.meme.a aVar);

    void recordStaticAvatar(int i3, String str, int i16, int i17, com.tencent.zplan.meme.a aVar);

    void reset();
}
