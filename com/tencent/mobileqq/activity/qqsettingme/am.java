package com.tencent.mobileqq.activity.qqsettingme;

import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.tianshu.api.IRedTouchManager;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate;
import com.tencent.mobileqq.tianshu.ui.TianshuRedTouch;
import com.tencent.mobileqq.vas.VasApngUtil;
import java.util.HashSet;
import java.util.List;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes10.dex */
public class am {
    static IPatchRedirector $redirector_;

    public static void a(AppRuntime appRuntime, BusinessInfoCheckUpdate.AppInfo appInfo, HashSet<Integer> hashSet) {
        if (!TianshuRedTouch.INSTANCE.j() && appInfo != null && appInfo.iNewFlag.get() != 0) {
            int i3 = appInfo.uiAppId.get();
            if (!hashSet.contains(Integer.valueOf(i3))) {
                hashSet.add(Integer.valueOf(i3));
                ((IRedTouchManager) appRuntime.getRuntimeService(IRedTouchManager.class, "")).reportLevelOneRedInfo(appInfo, 30, (String) null);
            }
        }
    }

    public static void b(BusinessInfoCheckUpdate.AppInfo appInfo) {
        BusinessInfoCheckUpdate.RedDisplayInfo redDisplayInfo;
        PBRepeatMessageField<BusinessInfoCheckUpdate.RedTypeInfo> pBRepeatMessageField;
        if (appInfo != null && (redDisplayInfo = appInfo.red_display_info) != null && (pBRepeatMessageField = redDisplayInfo.red_type_info) != null) {
            List<BusinessInfoCheckUpdate.RedTypeInfo> list = pBRepeatMessageField.get();
            for (int size = list.size() - 1; size >= 0; size--) {
                BusinessInfoCheckUpdate.RedTypeInfo redTypeInfo = list.get(size);
                if (redTypeInfo.red_type.get() == 15) {
                    VasApngUtil.getApngURLDrawable(redTypeInfo.red_content.get(), VasApngUtil.VIP_APNG_TAGS, com.tencent.mobileqq.urldrawable.b.f306350a);
                }
            }
        }
    }
}
