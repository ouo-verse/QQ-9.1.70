package com.tencent.av.opengl.effects;

import com.tencent.av.business.manager.pendant.PendantItem;
import com.tencent.mobileqq.richmedia.capture.data.FilterDesc;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes3.dex */
public class ae {
    public static boolean a(FilterDesc filterDesc, FilterDesc filterDesc2) {
        String str;
        String str2;
        if (filterDesc == null && filterDesc2 == null) {
            return true;
        }
        if (filterDesc != null && filterDesc2 != null && ((str = filterDesc.name) == null || (str2 = filterDesc2.name) == null || str.equalsIgnoreCase(str2))) {
            return true;
        }
        return false;
    }

    public static boolean b(PendantItem pendantItem, PendantItem pendantItem2) {
        if (pendantItem == null && pendantItem2 == null) {
            return true;
        }
        if (pendantItem != null && pendantItem2 != null && (pendantItem.getId() == null || pendantItem2.getId() == null || pendantItem.getId().equalsIgnoreCase(pendantItem2.getId()))) {
            return true;
        }
        return false;
    }

    public static void c(boolean z16) {
        com.tencent.av.r.h0().X2(z16);
        if (com.tencent.av.r.h0().j0() == com.tencent.av.r.f74237f) {
            QLog.i("RenderUtils", 1, "setAEDetectInited, init FaceSDK falied.");
        }
    }
}
