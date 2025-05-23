package com.tencent.mobileqq.groupvideo.bridgeengine.avsdk;

import com.tencent.mobileqq.groupvideo.bridgeengine.MultiUserInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qav.QavDef$MultiUserInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes12.dex */
public class d {
    static IPatchRedirector $redirector_;

    public static MultiUserInfo a(QavDef$MultiUserInfo qavDef$MultiUserInfo) {
        MultiUserInfo multiUserInfo = new MultiUserInfo();
        multiUserInfo.mMicOn = qavDef$MultiUserInfo.mMicOn;
        multiUserInfo.mUin = qavDef$MultiUserInfo.mUin;
        multiUserInfo.mOpenId = qavDef$MultiUserInfo.mOpenId;
        return multiUserInfo;
    }

    public static List<MultiUserInfo> b(List<QavDef$MultiUserInfo> list) {
        if (list == null) {
            return new ArrayList();
        }
        ArrayList arrayList = new ArrayList();
        Iterator<QavDef$MultiUserInfo> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(a(it.next()));
        }
        return arrayList;
    }
}
