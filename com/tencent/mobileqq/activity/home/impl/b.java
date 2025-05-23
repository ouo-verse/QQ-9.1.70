package com.tencent.mobileqq.activity.home.impl;

import android.util.Pair;
import android.view.View;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.qqsettingme.api.ILebaDataServicesApi;
import com.tencent.mobileqq.activity.qqsettingme.api.IVasApngUtilApi;
import com.tencent.mobileqq.app.FrameFragment;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.tianshu.api.IRedTouchManager;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate;
import com.tencent.mobileqq.tianshu.ui.TianshuRedTouch;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.theme.SkinEngine;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes10.dex */
public class b extends a {
    static IPatchRedirector $redirector_;
    public static String A;
    public static String B;
    public static String C;
    public static String D;
    public static String E;
    public static String F;
    public static String G;
    public static String H;
    private static HashMap<String, String> I;

    /* renamed from: l, reason: collision with root package name */
    public static final String f183049l;

    /* renamed from: m, reason: collision with root package name */
    public static final String f183050m;

    /* renamed from: n, reason: collision with root package name */
    public static final String f183051n;

    /* renamed from: o, reason: collision with root package name */
    public static final String f183052o;

    /* renamed from: p, reason: collision with root package name */
    public static final String f183053p;

    /* renamed from: q, reason: collision with root package name */
    public static final String f183054q;

    /* renamed from: r, reason: collision with root package name */
    public static final String f183055r;

    /* renamed from: s, reason: collision with root package name */
    public static final String f183056s;

    /* renamed from: t, reason: collision with root package name */
    public static final String f183057t;

    /* renamed from: u, reason: collision with root package name */
    public static Map<Integer, Boolean> f183058u;

    /* renamed from: v, reason: collision with root package name */
    public static Map<Integer, Boolean> f183059v;

    /* renamed from: w, reason: collision with root package name */
    public static Map<Integer, Integer> f183060w;

    /* renamed from: x, reason: collision with root package name */
    public static Map<Integer, String> f183061x;

    /* renamed from: y, reason: collision with root package name */
    public static Map<String, Integer> f183062y;

    /* renamed from: z, reason: collision with root package name */
    public static String f183063z;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(35360);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        String qqStr = HardCodeUtil.qqStr(R.string.c76);
        f183049l = qqStr;
        String qqStr2 = HardCodeUtil.qqStr(R.string.c75);
        f183050m = qqStr2;
        f183051n = HardCodeUtil.qqStr(R.string.hvs);
        String qqStr3 = HardCodeUtil.qqStr(R.string.c77);
        f183052o = qqStr3;
        f183053p = HardCodeUtil.qqStr(R.string.fx9);
        String qqStr4 = HardCodeUtil.qqStr(R.string.c08);
        f183054q = qqStr4;
        String qqStr5 = HardCodeUtil.qqStr(R.string.f181523e0);
        f183055r = qqStr5;
        String qqStr6 = HardCodeUtil.qqStr(R.string.f139690by);
        f183056s = qqStr6;
        String qqStr7 = HardCodeUtil.qqStr(R.string.f16525281);
        f183057t = qqStr7;
        HashMap hashMap = new HashMap();
        f183058u = hashMap;
        Boolean bool = Boolean.FALSE;
        hashMap.put(32, bool);
        f183058u.put(33, bool);
        f183058u.put(48, bool);
        f183058u.put(49, bool);
        Map<Integer, Boolean> map = f183058u;
        Boolean bool2 = Boolean.TRUE;
        map.put(34, bool2);
        f183058u.put(40, bool);
        HashMap hashMap2 = new HashMap();
        f183059v = hashMap2;
        hashMap2.put(32, bool);
        f183059v.put(33, bool);
        f183059v.put(48, bool2);
        f183059v.put(49, bool2);
        f183059v.put(34, bool);
        f183059v.put(40, bool2);
        HashMap hashMap3 = new HashMap();
        f183060w = hashMap3;
        hashMap3.put(33, 5);
        f183060w.put(48, 101);
        f183060w.put(49, 103);
        f183060w.put(34, 0);
        f183060w.put(40, 102);
        HashMap hashMap4 = new HashMap();
        f183061x = hashMap4;
        hashMap4.put(32, qqStr);
        f183061x.put(33, qqStr2);
        f183061x.put(48, qqStr6);
        f183061x.put(49, qqStr7);
        f183061x.put(34, qqStr3);
        f183061x.put(40, qqStr5);
        HashMap hashMap5 = new HashMap();
        f183062y = hashMap5;
        hashMap5.put(A, 5);
        f183062y.put(B, 0);
        f183062y.put(D, 7);
        f183062y.put(F, 102);
        f183062y.put(G, 101);
        f183062y.put(H, 103);
        f183063z = "com.tencent.mobileqq.activity.home.Conversation";
        A = "com.tencent.mobileqq.activity.contacts.base.Contacts";
        B = "com.tencent.mobileqq.leba.Leba";
        C = "com.tencent.mobileqq.activity.leba.QzoneFrame";
        D = "com.tencent.mobileqq.kandian.biz.tab.ReadinjoyTabFrame";
        E = "com.tencent.mobileqq.kandian.biz.xtab.RIJXTabFrame";
        F = "com.tencent.mobileqq.activity.qcircle.QCircleFrame";
        G = "com.tencent.mobileqq.guild.mainframe.GuildFragmentDelegateFrame";
        H = "com.tencent.mobileqq.gamecenter.qa.metadream.MetaDreamFrame";
        HashMap<String, String> hashMap6 = new HashMap<>();
        I = hashMap6;
        hashMap6.put(qqStr, f183063z);
        I.put(qqStr2, A);
        I.put(qqStr3, B);
        I.put(qqStr4, D);
        I.put(qqStr5, F);
        I.put(qqStr6, G);
        I.put(qqStr7, H);
        I.put(f183063z, qqStr);
        I.put(A, qqStr2);
        I.put(B, qqStr3);
        I.put(C, qqStr3);
        I.put(D, qqStr4);
        I.put(E, qqStr4);
        I.put(F, qqStr5);
        I.put(G, qqStr6);
        I.put(H, qqStr7);
    }

    private static Pair<Integer, Integer> a(Pair<Integer, Integer> pair) {
        if (SkinEngine.getInstances().checkResExist(((Integer) pair.first).intValue()) && SkinEngine.getInstances().checkResExist(((Integer) pair.second).intValue())) {
            return pair;
        }
        return null;
    }

    public static String b(String str) {
        return I.get(str);
    }

    public static int c(int i3) {
        if (i3 == 0) {
            return 0;
        }
        int i16 = 1;
        if (i3 != 1) {
            i16 = 2;
            if (i3 != 2) {
                i16 = 3;
                if (i3 != 3) {
                    i16 = 4;
                    if (i3 != 4) {
                        i16 = 5;
                        if (i3 != 5) {
                            i16 = 99;
                            if (i3 != 99) {
                                return 0;
                            }
                        }
                    }
                }
            }
        }
        return i16;
    }

    @Nullable
    public static BusinessInfoCheckUpdate.RedTypeInfo d(FrameFragment frameFragment, int i3) {
        BusinessInfoCheckUpdate.RedTypeInfo redTypeInfo;
        List<BusinessInfoCheckUpdate.AppInfo> requestAppInfoListByAppSet;
        BusinessInfoCheckUpdate.RedTypeInfo redTypeInfo2 = null;
        if (frameFragment == null || i3 == 32) {
            return null;
        }
        AppRuntime appRuntime = frameFragment.getBaseActivity().getAppRuntime();
        if (i3 == 34) {
            return ((ILebaDataServicesApi) QRoute.api(ILebaDataServicesApi.class)).getRedTypeInfo(appRuntime);
        }
        StringBuilder sb5 = new StringBuilder(50);
        sb5.append("getNewRedTouchInfoFor");
        sb5.append("tabIndex=");
        sb5.append(i3);
        sb5.append(" ");
        if (f183060w.containsKey(Integer.valueOf(i3))) {
            Integer num = f183060w.get(Integer.valueOf(i3));
            sb5.append("appSet=");
            sb5.append(num);
            sb5.append(" ");
            Integer num2 = f183060w.get(Integer.valueOf(i3));
            IRedTouchManager iRedTouchManager = (IRedTouchManager) frameFragment.app.getRuntimeService(IRedTouchManager.class, "");
            if (iRedTouchManager == null || (requestAppInfoListByAppSet = iRedTouchManager.requestAppInfoListByAppSet(num2.intValue())) == null || requestAppInfoListByAppSet.size() == 0) {
                return null;
            }
            BusinessInfoCheckUpdate.RedTypeInfo redTypeInfo3 = null;
            for (int i16 = 0; i16 < requestAppInfoListByAppSet.size(); i16++) {
                BusinessInfoCheckUpdate.AppInfo appInfo = requestAppInfoListByAppSet.get(i16);
                if (appInfo != null) {
                    BusinessInfoCheckUpdate.RedTypeInfo redTypeInfo4 = appInfo.red_display_info.tab_display_info.get();
                    sb5.append("path=");
                    sb5.append(appInfo.path.get());
                    sb5.append(" ");
                    if (appInfo.mission_level.get() != 0) {
                        sb5.append(" mission_level ");
                        sb5.append(appInfo.mission_level.get());
                    } else {
                        sb5.append("redType=");
                        sb5.append(appInfo.type.get());
                        sb5.append(" ");
                        sb5.append("num=");
                        sb5.append(appInfo.num.get());
                        sb5.append(" ");
                        sb5.append("iNewFlag=");
                        sb5.append(appInfo.iNewFlag.get());
                        sb5.append(" ");
                        if (appInfo.type.get() == 8) {
                            if (!com.tencent.mobileqq.tianshu.ui.b.e(appInfo).booleanValue()) {
                                sb5.append("Invalid red number");
                            } else {
                                if (redTypeInfo3 == null) {
                                    redTypeInfo3 = new BusinessInfoCheckUpdate.RedTypeInfo();
                                    redTypeInfo3.red_type.set(5);
                                    redTypeInfo3.red_content.set(String.valueOf(0));
                                }
                                try {
                                    redTypeInfo3.red_content.set((Integer.parseInt(redTypeInfo3.red_content.get()) + com.tencent.mobileqq.tianshu.ui.b.a(appInfo)) + "");
                                } catch (NumberFormatException e16) {
                                    sb5.append("error getRedTypeInfo");
                                    sb5.append(e16);
                                }
                            }
                        } else if (redTypeInfo2 == null || redTypeInfo2.red_priority.get() < redTypeInfo4.red_priority.get()) {
                            sb5.append("redType=dot ");
                            redTypeInfo2 = redTypeInfo4;
                        }
                    }
                }
            }
            redTypeInfo = redTypeInfo2;
            redTypeInfo2 = redTypeInfo3;
        } else {
            redTypeInfo = null;
        }
        QLog.i("FrameControllerUtil", 1, "getRedTouchInfoFor" + sb5.toString());
        if (redTypeInfo2 != null) {
            return redTypeInfo2;
        }
        return redTypeInfo;
    }

    public static int e(BusinessInfoCheckUpdate.RedTypeInfo redTypeInfo) {
        if (redTypeInfo == null) {
            return 0;
        }
        if (redTypeInfo.red_type.get() == 5) {
            return 2;
        }
        return 1;
    }

    public static int f(String str) {
        AppRuntime peekAppRuntime;
        IRedTouchManager iRedTouchManager;
        if (str == null || (peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime()) == null || (iRedTouchManager = (IRedTouchManager) peekAppRuntime.getRuntimeService(IRedTouchManager.class, "")) == null) {
            return 0;
        }
        BusinessInfoCheckUpdate.AppInfo appInfoByPath = iRedTouchManager.getAppInfoByPath(str);
        if (com.tencent.mobileqq.tianshu.ui.b.e(iRedTouchManager.getAppInfoByPath(str + ".0")).booleanValue()) {
            return 2;
        }
        if (appInfoByPath == null || appInfoByPath.iNewFlag.get() == 0 || appInfoByPath.red_display_info.get() == null) {
            return 0;
        }
        return 1;
    }

    public static int g(Integer num) {
        HashMap hashMap = new HashMap();
        hashMap.put(10000, 1);
        hashMap.put(5, 2);
        hashMap.put(0, 3);
        hashMap.put(101, 4);
        hashMap.put(102, 5);
        hashMap.put(103, 6);
        if (!hashMap.containsKey(num)) {
            return 0;
        }
        return ((Integer) hashMap.get(num)).intValue();
    }

    @Nullable
    public static Pair<Integer, Integer> h(String[] strArr, String str) {
        try {
            if (!f183049l.equals(str) && !str.equals(Integer.valueOf(a.f183038a))) {
                String str2 = f183050m;
                if (!str2.equals(str) && !str.equals(Integer.valueOf(a.f183040c))) {
                    if (!f183052o.equals(str) && !str.equals(Integer.valueOf(a.f183041d))) {
                        if (!QQTheme.isVasTheme()) {
                            if (!str2.equals(str) && !f183055r.equals(str) && !str.equals(Integer.valueOf(a.f183046i))) {
                                if (f183054q.equals(str) || f183056s.equals(str) || str.equals(Integer.valueOf(a.f183044g)) || str.equals(Integer.valueOf(a.f183047j))) {
                                    return a(new Pair(Integer.valueOf(R.drawable.skin_tab_icon_5), Integer.valueOf(R.drawable.skin_tab_icon_5_selected)));
                                }
                            }
                            return a(new Pair(Integer.valueOf(R.drawable.skin_tab_icon_3), Integer.valueOf(R.drawable.skin_tab_icon_3_selected)));
                        }
                        int i3 = 0;
                        for (String str3 : strArr) {
                            if (!str3.equals(f183049l) && !str3.equals(f183050m) && !str3.equals(f183052o) && !str3.equals(Integer.valueOf(a.f183038a)) && !str3.equals(Integer.valueOf(a.f183040c)) && !str3.equals(Integer.valueOf(a.f183041d))) {
                                if (str3.equals(str)) {
                                    break;
                                }
                                i3++;
                            }
                        }
                        if (i3 == 0) {
                            return a(new Pair(Integer.valueOf(R.drawable.skin_tab_icon_5), Integer.valueOf(R.drawable.skin_tab_icon_5_selected)));
                        }
                        if (i3 == 1) {
                            return a(new Pair(Integer.valueOf(R.drawable.skin_tab_icon_3), Integer.valueOf(R.drawable.skin_tab_icon_3_selected)));
                        }
                        return null;
                    }
                    return a(new Pair(Integer.valueOf(R.drawable.skin_tab_icon_4), Integer.valueOf(R.drawable.skin_tab_icon_4_selected)));
                }
                return a(new Pair(Integer.valueOf(R.drawable.skin_tab_icon_2), Integer.valueOf(R.drawable.skin_tab_icon_2_selected)));
            }
            return a(new Pair(Integer.valueOf(R.drawable.skin_tab_icon_1), Integer.valueOf(R.drawable.skin_tab_icon_1_selected)));
        } catch (Exception e16) {
            QLog.e("FrameControllerUtil", 1, e16, new Object[0]);
            return null;
        }
    }

    public static String i(int i3) {
        if (i3 == a.f183038a) {
            return f183049l;
        }
        if (i3 == a.f183040c) {
            return f183050m;
        }
        if (i3 == a.f183041d) {
            return f183052o;
        }
        if (i3 == a.f183045h) {
            return f183052o;
        }
        if (i3 == a.f183044g) {
            return f183054q;
        }
        if (i3 == a.f183046i) {
            return f183055r;
        }
        if (i3 == a.f183047j) {
            return f183056s;
        }
        if (i3 == a.f183048k) {
            return f183057t;
        }
        return "";
    }

    public static void j(View view, int i3, int i16, Boolean bool) {
        if (view == null) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("tab_name", Integer.valueOf(i3));
        hashMap.put("red_point_type", Integer.valueOf(i16));
        if (bool.booleanValue()) {
            VideoReport.reportEvent("ev_bas_bottom_tab_clck", hashMap);
            if (view instanceof TianshuRedTouch) {
                ((TianshuRedTouch) view).x();
                return;
            }
            return;
        }
        VideoReport.reportEvent("ev_bas_bottom_tab_imp", hashMap);
        if (view instanceof TianshuRedTouch) {
            TianshuRedTouch tianshuRedTouch = (TianshuRedTouch) view;
            tianshuRedTouch.F(tianshuRedTouch.M());
        }
    }

    public static String k(String str) {
        return I.get(str);
    }

    public static boolean l() {
        return ((IVasApngUtilApi) QRoute.api(IVasApngUtilApi.class)).updateIsDefaultTheme();
    }
}
