package com.tencent.mobileqq.redtouch;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.aelight.camera.download.AEResManagerConfigBean;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes17.dex */
public class g {
    static IPatchRedirector $redirector_;

    public static RedAppInfo a(BusinessInfoCheckUpdate.AppInfo appInfo) {
        if (appInfo == null) {
            if (QLog.isColorLevel()) {
                QLog.d("RedTouchUtils BusinessInfo2RedAppInfo", 2, "appInfo is null ");
                return null;
            }
            return null;
        }
        RedAppInfo redAppInfo = new RedAppInfo();
        redAppInfo.l0(appInfo.uiAppId.get());
        redAppInfo.m0(appInfo.iNewFlag.get());
        redAppInfo.k0(appInfo.type.get());
        redAppInfo.V(appInfo.buffer.get());
        redAppInfo.h0(appInfo.path.get());
        redAppInfo.f0(appInfo.modify_ts.get());
        redAppInfo.N(appInfo.appset.get());
        redAppInfo.g0(appInfo.num.get());
        redAppInfo.c0(appInfo.icon_url.get());
        redAppInfo.b0(appInfo.icon_type.get());
        redAppInfo.a0(appInfo.icon_flag.get());
        redAppInfo.i0(appInfo.push_red_ts.get());
        redAppInfo.d0(appInfo.mission_level.get());
        redAppInfo.Z(appInfo.exposure_max.get());
        ArrayList<String> arrayList = new ArrayList<>();
        if (appInfo.missions.get() != null && appInfo.missions.get().size() > 0) {
            for (int i3 = 0; i3 < appInfo.missions.get().size(); i3++) {
                arrayList.add(appInfo.missions.get().get(i3));
            }
        }
        redAppInfo.e0(arrayList);
        RedDisplayInfo redDisplayInfo = new RedDisplayInfo();
        RedTypeInfo redTypeInfo = new RedTypeInfo();
        ArrayList<RedTypeInfo> arrayList2 = new ArrayList<>();
        BusinessInfoCheckUpdate.RedTypeInfo redTypeInfo2 = appInfo.red_display_info.get().tab_display_info.get();
        List<BusinessInfoCheckUpdate.RedTypeInfo> list = appInfo.red_display_info.get().red_type_info.get();
        if (redTypeInfo2 != null) {
            redTypeInfo.setRedContent(redTypeInfo2.red_content.get());
            redTypeInfo.setRedDesc(redTypeInfo2.red_desc.get());
            redTypeInfo.setRedPriority(redTypeInfo2.red_priority.get());
            redTypeInfo.setRedType(redTypeInfo2.red_type.get());
        }
        redDisplayInfo.e(redTypeInfo);
        if (list != null && list.size() > 0) {
            for (int i16 = 0; i16 < list.size(); i16++) {
                RedTypeInfo redTypeInfo3 = new RedTypeInfo();
                redTypeInfo3.setRedContent(list.get(i16).red_content.get());
                redTypeInfo3.setRedDesc(list.get(i16).red_desc.get());
                redTypeInfo3.setRedPriority(list.get(i16).red_priority.get());
                redTypeInfo3.setRedType(list.get(i16).red_type.get());
                arrayList2.add(redTypeInfo3);
            }
        }
        redDisplayInfo.f(arrayList2);
        redAppInfo.j0(redDisplayInfo);
        return redAppInfo;
    }

    public static boolean b(String str, String str2) {
        boolean z16;
        boolean z17;
        if (str == null && str2 == null) {
            return false;
        }
        String str3 = AppSetting.f99551k;
        int c16 = c(str, str3);
        int c17 = c(str3, str2);
        if (c16 != -1 && c16 != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (c17 != 1 && c17 != 0 && !AEResManagerConfigBean.DEFAULT_VERSION.equals(str2)) {
            z17 = false;
        } else {
            z17 = true;
        }
        if (!z16 || !z17) {
            return false;
        }
        return true;
    }

    public static int c(String str, String str2) {
        if (str == null && str2 == null) {
            return 0;
        }
        if (str != null && str2 == null) {
            return 1;
        }
        if (str == null && str2 != null) {
            return -1;
        }
        String[] split = str.split("\\.");
        String[] split2 = str2.split("\\.");
        int i3 = 0;
        while (i3 < split.length && i3 < split2.length) {
            try {
                int parseInt = Integer.parseInt(split[i3]);
                int parseInt2 = Integer.parseInt(split2[i3]);
                if (parseInt < parseInt2) {
                    return -1;
                }
                if (parseInt > parseInt2) {
                    return 1;
                }
                i3++;
            } catch (NumberFormatException e16) {
                e16.printStackTrace();
                return str.compareTo(str2);
            }
        }
        if (split.length > i3) {
            return 1;
        }
        if (split2.length <= i3) {
            return 0;
        }
        return -1;
    }

    public static String d(@NonNull BusinessInfoCheckUpdate.AppInfo appInfo) {
        String str = appInfo.buffer.get();
        if (!TextUtils.isEmpty(str)) {
            try {
                return new JSONObject(str).getString("ad_id");
            } catch (Exception e16) {
                QLog.e("RedTouchUtilsgetAdIdFromAppInfo error", 1, e16, new Object[0]);
            }
        }
        return "0";
    }

    public static BusinessInfoCheckUpdate.AppInfo e(RedAppInfo redAppInfo) {
        List<RedTypeInfo> c16;
        if (redAppInfo == null) {
            return null;
        }
        BusinessInfoCheckUpdate.AppInfo appInfo = new BusinessInfoCheckUpdate.AppInfo();
        appInfo.uiAppId.set(redAppInfo.G());
        appInfo.iNewFlag.set(redAppInfo.M());
        appInfo.type.set(redAppInfo.getType());
        appInfo.buffer.set(redAppInfo.t());
        appInfo.path.set(redAppInfo.C());
        appInfo.modify_ts.set(redAppInfo.A());
        appInfo.missions.set(redAppInfo.z());
        appInfo.appset.set(redAppInfo.s());
        appInfo.num.set(redAppInfo.B());
        appInfo.icon_url.set(redAppInfo.x());
        appInfo.icon_flag.set(redAppInfo.v());
        appInfo.icon_type.set(redAppInfo.w());
        appInfo.push_red_ts.set(redAppInfo.E());
        appInfo.mission_level.set(redAppInfo.y());
        appInfo.exposure_max.set(redAppInfo.u());
        BusinessInfoCheckUpdate.RedDisplayInfo redDisplayInfo = new BusinessInfoCheckUpdate.RedDisplayInfo();
        RedDisplayInfo F = redAppInfo.F();
        BusinessInfoCheckUpdate.RedTypeInfo redTypeInfo = new BusinessInfoCheckUpdate.RedTypeInfo();
        if (F != null) {
            RedTypeInfo b16 = F.b();
            redTypeInfo.red_content.set(b16.getRedContent());
            redTypeInfo.red_desc.set(b16.getRedDesc());
            redTypeInfo.red_priority.set(b16.getRedPriority());
            redTypeInfo.red_type.set(b16.getRedType());
        }
        redDisplayInfo.tab_display_info.set(redTypeInfo);
        ArrayList arrayList = new ArrayList();
        if (F != null && (c16 = F.c()) != null) {
            for (int i3 = 0; i3 < c16.size(); i3++) {
                RedTypeInfo redTypeInfo2 = c16.get(i3);
                BusinessInfoCheckUpdate.RedTypeInfo redTypeInfo3 = new BusinessInfoCheckUpdate.RedTypeInfo();
                redTypeInfo3.red_content.set(redTypeInfo2.getRedContent());
                redTypeInfo3.red_desc.set(redTypeInfo2.getRedDesc());
                redTypeInfo3.red_priority.set(redTypeInfo2.getRedPriority());
                redTypeInfo3.red_type.set(redTypeInfo2.getRedType());
                arrayList.add(redTypeInfo3);
            }
        }
        redDisplayInfo.red_type_info.set(arrayList);
        appInfo.red_display_info.set(redDisplayInfo);
        return appInfo;
    }
}
