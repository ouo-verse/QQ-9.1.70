package com.tencent.mobileqq.mutualmark;

import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.config.business.MutualMarkConfProcessor;
import com.tencent.mobileqq.mutualmark.info.b;
import com.tencent.mobileqq.mutualmark.oldlogic.FriendIntimateRelationshipHelper;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes15.dex */
public class b {
    static IPatchRedirector $redirector_;

    public static int a(AppInterface appInterface, String str, long j3, long j16) {
        return b(appInterface, str, j3, j16, false);
    }

    public static int b(AppInterface appInterface, String str, long j3, long j16, boolean z16) {
        int a16;
        if (!TextUtils.isEmpty(str) && (a16 = com.tencent.mobileqq.mutualmark.alienation.a.a(appInterface, str, j3, j16)) != 0) {
            return a16;
        }
        int i3 = (int) j3;
        if (i3 != 12) {
            if (i3 != 17) {
                if (i3 != 26) {
                    if (i3 != 28) {
                        switch (i3) {
                            case 1:
                                if (j16 == 0) {
                                    return R.drawable.skin_icon_intimate_lover_1;
                                }
                                if (j16 == 1) {
                                    return R.drawable.skin_icon_intimate_lover_2;
                                }
                                if (j16 == 2) {
                                    return R.drawable.skin_icon_intimate_lover_3;
                                }
                                return 0;
                            case 2:
                                if (j16 == 0) {
                                    return R.drawable.skin_icon_intimate_guimi_1;
                                }
                                if (j16 == 1) {
                                    return R.drawable.skin_icon_intimate_guimi_2;
                                }
                                if (j16 == 2) {
                                    return R.drawable.skin_icon_intimate_guimi_3;
                                }
                                return 0;
                            case 3:
                                if (j16 == 0) {
                                    return R.drawable.skin_icon_intimate_jiyou_1;
                                }
                                if (j16 == 1) {
                                    return R.drawable.skin_icon_intimate_jiyou_2;
                                }
                                if (j16 == 2) {
                                    return R.drawable.skin_icon_intimate_jiyou_3;
                                }
                                return 0;
                            case 4:
                                if (j16 == 1) {
                                    return R.drawable.skin_icon_frdship_1;
                                }
                                if (j16 == 2) {
                                    return R.drawable.skin_icon_frdship_2;
                                }
                                if (j16 == 3) {
                                    return R.drawable.skin_icon_frdship_3;
                                }
                                return 0;
                            case 5:
                                if (j16 == 1) {
                                    int g16 = g(appInterface, j3, j16);
                                    if (g16 != 0) {
                                        return g16;
                                    }
                                    return R.drawable.skin_icon_small_fire;
                                }
                                if (j16 == 2) {
                                    int g17 = g(appInterface, j3, j16);
                                    if (g17 != 0) {
                                        return g17;
                                    }
                                    return R.drawable.skin_icon_big_fire;
                                }
                                if (j16 == 3) {
                                    return R.drawable.skin_icon_fire_3;
                                }
                                if (j16 == 4) {
                                    return R.drawable.skin_icon_fire_4;
                                }
                                if (j16 == 5) {
                                    return R.drawable.skin_icon_fire_5;
                                }
                                if (j16 == 6) {
                                    return R.drawable.skin_icon_fire_6;
                                }
                                return 0;
                            case 6:
                                if (j16 == 1) {
                                    return R.drawable.skin_icon_small_praise;
                                }
                                if (j16 == 2) {
                                    return R.drawable.skin_icon_big_praise;
                                }
                                return 0;
                            case 7:
                                if (j16 == 1) {
                                    return R.drawable.skin_icon_lover_small;
                                }
                                if (j16 == 2) {
                                    return R.drawable.skin_icon_lover_big;
                                }
                                return 0;
                            case 8:
                                if (j16 == 1) {
                                    return R.drawable.skin_icon_qzone_visit_normal;
                                }
                                if (j16 == 2) {
                                    return R.drawable.skin_icon_qzone_visit_super;
                                }
                                return 0;
                            default:
                                switch (i3) {
                                    case 19:
                                        if (z16 && j16 == 1) {
                                            return R.drawable.skin_icon_mentorship_unionvip;
                                        }
                                        return 0;
                                    case 20:
                                        if (j16 == 1) {
                                            return R.drawable.skin_icon_kapu_1;
                                        }
                                        if (j16 == 2) {
                                            return R.drawable.skin_icon_kapu_2;
                                        }
                                        if (j16 == 3) {
                                            return R.drawable.skin_icon_kapu_3;
                                        }
                                        return 0;
                                    case 21:
                                        if (j16 == 1) {
                                            return R.drawable.skin_icon_forget_me_not_1;
                                        }
                                        if (j16 == 2) {
                                            return R.drawable.skin_icon_forget_me_not_2;
                                        }
                                        if (j16 == 3) {
                                            return R.drawable.skin_icon_forget_me_not_3;
                                        }
                                        return 0;
                                    default:
                                        return 0;
                                }
                        }
                    }
                    if (j16 == 1) {
                        return R.drawable.skin_icon_listen_together_1;
                    }
                    if (j16 == 2) {
                        return R.drawable.skin_icon_listen_together_2;
                    }
                    if (j16 == 3) {
                        return R.drawable.skin_icon_listen_together_3;
                    }
                    return 0;
                }
                if (j16 == 0) {
                    return R.drawable.o2c;
                }
                if (j16 == 1) {
                    return R.drawable.o2d;
                }
                if (j16 == 2) {
                    return R.drawable.o2e;
                }
                return 0;
            }
            if (j16 == 1) {
                return R.drawable.hzt;
            }
            return 0;
        }
        if (j16 == 1) {
            return R.drawable.skin_icon_small_flower;
        }
        if (j16 == 2) {
            return R.drawable.skin_icon_big_flower;
        }
        return 0;
    }

    public static String c(AppInterface appInterface, String str, String str2) {
        return d(appInterface, str, g.i(str2), g.g(str2));
    }

    public static String d(AppInterface appInterface, String str, long j3, long j16) {
        int a16 = a(appInterface, str, j3, j16);
        if (a16 != 0) {
            return g.e(a16);
        }
        return "";
    }

    public static String e(AppInterface appInterface, String str) {
        b.C8128b g16 = MutualMarkConfProcessor.a().g(str);
        if (g16 != null) {
            return g16.f252078b;
        }
        return "";
    }

    public static String f(AppInterface appInterface, long j3, long j16) {
        return e(appInterface, g.d(j3, j16));
    }

    public static int g(AppInterface appInterface, long j3, long j16) {
        ArrayList<b.C8128b> arrayList;
        b.C8128b b16;
        com.tencent.mobileqq.mutualmark.info.b e16 = MutualMarkConfProcessor.a().e(j3);
        if (e16 != null && (arrayList = e16.f252074g) != null && arrayList.size() > 0 && (b16 = e16.b(j16)) != null && !TextUtils.isEmpty(b16.f252082f)) {
            int identifier = appInterface.getApp().getResources().getIdentifier(b16.f252082f, "drawable", appInterface.getApp().getPackageName());
            if (QLog.isColorLevel()) {
                QLog.i("MutualMarkConfigHelper", 2, "MutualMarkConfigIRType.TypeItem.iconPath:" + b16.f252082f + ", imageResourceId:" + identifier);
            }
            if (identifier != 0) {
                return identifier;
            }
            return 0;
        }
        return 0;
    }

    public static boolean h(QQAppInterface qQAppInterface, long j3) {
        if (com.tencent.mobileqq.activity.aio.intimate.e.e(j3) && !FriendIntimateRelationshipHelper.m(qQAppInterface.getCurrentUin())) {
            return false;
        }
        return true;
    }

    public static boolean i(QQAppInterface qQAppInterface, long j3, long j16) {
        if (!h(qQAppInterface, j3)) {
            return false;
        }
        if (com.tencent.mobileqq.activity.aio.intimate.e.e(j3) && j16 > 0 && !FriendIntimateRelationshipHelper.n()) {
            return false;
        }
        return true;
    }
}
