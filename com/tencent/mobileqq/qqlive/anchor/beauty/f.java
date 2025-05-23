package com.tencent.mobileqq.qqlive.anchor.beauty;

import com.tencent.aelight.camera.download.api.AEResInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes17.dex */
public class f {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static Map<AEResInfo, Boolean> f270405a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(54878);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        f270405a = null;
        HashMap hashMap = new HashMap();
        f270405a = hashMap;
        AEResInfo aEResInfo = AEResInfo.LIGHT_RES_BUNDLE_FACE;
        Boolean bool = Boolean.FALSE;
        hashMap.put(aEResInfo, bool);
        f270405a.put(AEResInfo.LIGHT_RES_BUNDLE_BG_SEG, bool);
        f270405a.put(AEResInfo.LIGHT_RES_PAG, bool);
        f270405a.put(AEResInfo.LIGHT_RES_BUNDLE_TRACK_AGENT, bool);
        f270405a.put(AEResInfo.LIGHT_RES_BUNDLE_FACE_CLASSIFY, bool);
        f270405a.put(AEResInfo.LIGHT_RES_BUNDLE_HAND, bool);
        f270405a.put(AEResInfo.LIGHT_RES_BUNDLE_FACE_STATIC_FEATURE, bool);
        f270405a.put(AEResInfo.LIGHT_RES_BUNDLE_CAT, bool);
        f270405a.put(AEResInfo.LIGHT_RES_BUNDLE_DEPTH, bool);
        f270405a.put(AEResInfo.LIGHT_RES_BUNDLE_SEG_HAIR, bool);
        f270405a.put(AEResInfo.LIGHT_RES_BUNDLE_SEG_SKY, bool);
        f270405a.put(AEResInfo.LIGHT_RES_BUNDLE_ACE3D, bool);
        f270405a.put(AEResInfo.LIGHT_RES_BUNDLE_3DMM, bool);
        f270405a.put(AEResInfo.LIGHT_RES_BUNDLE_SEG_HEAD, bool);
        f270405a.put(AEResInfo.LIGHT_RES_BUNDLE_SCENE, bool);
        f270405a.put(AEResInfo.LIGHT_RES_BUNDLE_BODY, bool);
        f270405a.put(AEResInfo.LIGHT_RES_BUNDLE_BODY_3D, bool);
        f270405a.put(AEResInfo.LIGHT_RES_BUNDLE_EMOTION, bool);
        f270405a.put(AEResInfo.LIGHT_RES_BUNDLE_PIC_ENHANCE, bool);
        f270405a.put(AEResInfo.LIGHT_RES_BUNDLE_PIC_QUALITY, bool);
        f270405a.put(AEResInfo.LIGHT_RES_BUNDLE_VIDEO_FILTER, bool);
        f270405a.put(AEResInfo.LIGHT_RES_BUNDLE_PIC_ENHANCE_REALTIME, bool);
        f270405a.put(AEResInfo.LIGHT_RES_DEPTH_RELATIVE_AGENT, bool);
        f270405a.put(AEResInfo.LIGHT_RES_SMILE_AGENT, bool);
        f270405a.put(AEResInfo.LIGHT_RES_EMOTION_SCORE_AGENT, bool);
    }

    public static Map<AEResInfo, Boolean> a() {
        if (f270405a == null) {
            QLog.e("[qq-live]Config", 1, "bundleMap is NULL!");
        }
        return f270405a;
    }

    public static void b(AEResInfo aEResInfo, boolean z16) {
        Map<AEResInfo, Boolean> map = f270405a;
        if (map == null) {
            QLog.e("[qq-live]Config", 1, "bundleMap is NULL!");
        } else {
            map.put(aEResInfo, Boolean.valueOf(z16));
        }
    }
}
