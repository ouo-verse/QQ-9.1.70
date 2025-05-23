package com.tencent.mobileqq.avatar.api;

import com.tencent.mobileqq.app.face.FaceInfo;
import com.tencent.mobileqq.qroute.annotation.Service;
import mqq.app.api.IRuntimeService;

/* compiled from: P */
@Service(process = {"all"})
/* loaded from: classes11.dex */
public interface IQQAvatarHandlerService extends IRuntimeService {
    boolean checkOutsideDynamicAvatarEnable(int i3);

    void getApolloHead(String str);

    void getApolloHead(String str, byte b16, byte b17, int i3);

    String getChoosedIP();

    String getChoosedStrangerGroupIP();

    void getCustomHead(FaceInfo faceInfo);

    void getCustomHead(String str);

    void getCustomHead(String str, byte b16, byte b17);

    void getMobileQQHead(String str);

    void getMobileQQHead(String str, byte b16);

    void getQCallHead(String str, int i3, byte b16, byte b17);

    void getStrangerHead(String str, int i3, byte b16, byte b17);

    void getTroopHead(String str);

    void getTroopHead(String str, byte b16);

    void notifySyncQQHead();

    void sendBroadCastHeadChanged(int i3, String str);
}
