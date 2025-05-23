package com.tencent.biz.subscribe.comment;

import android.graphics.BitmapFactory;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.face.FaceConstant;
import com.tencent.mobileqq.data.Setting;
import com.tencent.mobileqq.nearby.api.INearbyAppInterfaceUtils;
import com.tencent.mobileqq.perf.block.DBMethodProxy;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.util.cu;
import com.tencent.mobileqq.util.j;
import com.tencent.qphone.base.util.MD5;

/* compiled from: P */
/* loaded from: classes5.dex */
public class k {
    public static j.a a(String str) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inPreferredConfig = FaceConstant.HeadConfig.FACE_BITMAP_CONFIG;
        j.a aVar = new j.a();
        int i3 = 0;
        do {
            com.tencent.mobileqq.util.j.e(str, options, aVar);
            if (aVar.f306779b == 1) {
                ((INearbyAppInterfaceUtils) QRoute.api(INearbyAppInterfaceUtils.class)).freePartBitmapCache();
            }
            i3++;
            if (i3 >= 2) {
                break;
            }
        } while (aVar.f306779b == 1);
        return aVar;
    }

    public static String b(Setting setting, int i3, String str, int i16) {
        if (setting == null && str != null && i3 != 101 && i3 != 1001) {
            setting = (Setting) d(i3, str, i16).second;
        }
        StringBuilder sb5 = new StringBuilder(256);
        if (i3 == 32) {
            if (cu.e()) {
                sb5.append(AppConstants.PATH_HEAD_STRANGER);
            } else {
                sb5.append("/data/data/com.tencent.mobileqq/files/head/_stranger/");
            }
        } else if (cu.e()) {
            sb5.append(AppConstants.PATH_HEAD_HD);
        } else {
            sb5.append("/data/data/com.tencent.mobileqq/files/head/_hd/");
        }
        Object[] c16 = c(setting, str, i3);
        int intValue = ((Integer) c16[0]).intValue();
        if (intValue != -56) {
            if (intValue != -55) {
                if (intValue != 4) {
                    if (intValue != 16) {
                        if (intValue != 32) {
                            if (intValue != 101) {
                                if (intValue != 113) {
                                    if (intValue == 1001) {
                                        sb5.append("dis_pstn_g_");
                                        str = str + str;
                                    }
                                } else {
                                    sb5.append("new_troop_b_");
                                }
                            } else {
                                sb5.append("dis_g_");
                                str = str + str;
                            }
                        } else {
                            sb5.append("stranger_");
                            sb5.append(Integer.toString(i16));
                            sb5.append("_");
                        }
                    } else {
                        sb5.append("qcall_");
                        sb5.append(Integer.toString(i16));
                        sb5.append("_");
                    }
                } else {
                    sb5.append("troop_");
                }
            } else {
                sb5.append("sys_");
                str = (String) c16[1];
            }
        } else {
            sb5.append("troop_sys_b_");
            str = (String) c16[1];
        }
        sb5.append(MD5.toMD5(MD5.toMD5(MD5.toMD5(str) + str) + str));
        sb5.append(".jpg_");
        return sb5.toString();
    }

    private static Object[] c(Setting setting, String str, int i3) {
        if (setting != null && i3 != 101 && i3 != 1001 && str != null && setting.bHeadType == 0) {
            str = String.valueOf((int) setting.systemHeadID);
            if (i3 == 4) {
                i3 = -56;
            } else {
                int i16 = 16;
                if (i3 != 16) {
                    i16 = 116;
                    if (i3 != 116) {
                        i3 = -55;
                    }
                }
                i3 = i16;
            }
        }
        return new Object[]{Integer.valueOf(i3), str};
    }

    public static Pair<Boolean, Setting> d(int i3, String str, int i16) {
        Setting setting;
        String faceSettingKey = QQAppInterface.getFaceSettingKey(i3, str, i16);
        EntityManager createEntityManager = com.tencent.mobileqq.persistence.l.c(str).createEntityManager();
        if (!TextUtils.isEmpty(faceSettingKey) && createEntityManager != null) {
            setting = (Setting) DBMethodProxy.find(createEntityManager, (Class<? extends Entity>) Setting.class, faceSettingKey);
        } else {
            setting = null;
        }
        if (setting == null) {
            return new Pair<>(Boolean.TRUE, setting);
        }
        boolean z16 = true;
        boolean z17 = false;
        if (i3 == 1 || i3 == 4 || i3 == 11 || i3 == 16 || i3 == 32) {
            if (System.currentTimeMillis() - setting.updateTimestamp <= 86400000) {
                z16 = false;
            }
            z17 = z16;
        }
        return new Pair<>(Boolean.valueOf(z17), setting);
    }
}
