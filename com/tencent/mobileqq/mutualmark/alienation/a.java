package com.tencent.mobileqq.mutualmark.alienation;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.config.business.MutualMarkConfProcessor;
import com.tencent.mobileqq.config.business.ad;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.ff;
import com.tencent.qqnt.ntrelation.intimateinfo.api.IIntimateInfoService;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;

/* compiled from: P */
/* loaded from: classes15.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.mutualmark.alienation.a$a, reason: collision with other inner class name */
    /* loaded from: classes15.dex */
    public class C8127a implements hx3.c<com.tencent.qqnt.ntrelation.intimateinfo.bean.a> {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ QQAppInterface f251962a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f251963b;

        C8127a(QQAppInterface qQAppInterface, String str) {
            this.f251962a = qQAppInterface;
            this.f251963b = str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) qQAppInterface, (Object) str);
            }
        }

        @Override // hx3.c
        public void onUpdateResult(@Nullable com.tencent.qqnt.ntrelation.friendsinfo.bean.e<com.tencent.qqnt.ntrelation.intimateinfo.bean.a> eVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) eVar);
            } else {
                this.f251962a.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER).notifyUI(3, true, this.f251963b);
                com.tencent.mobileqq.mutualmark.nt.f.f252196a.p(this.f251963b);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes15.dex */
    public class b implements hx3.c<com.tencent.qqnt.ntrelation.intimateinfo.bean.a> {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ QQAppInterface f251964a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f251965b;

        b(QQAppInterface qQAppInterface, String str) {
            this.f251964a = qQAppInterface;
            this.f251965b = str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) qQAppInterface, (Object) str);
            }
        }

        @Override // hx3.c
        public void onUpdateResult(@Nullable com.tencent.qqnt.ntrelation.friendsinfo.bean.e<com.tencent.qqnt.ntrelation.intimateinfo.bean.a> eVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) eVar);
            } else {
                this.f251964a.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER).notifyUI(3, true, this.f251965b);
                com.tencent.mobileqq.mutualmark.nt.f.f252196a.p(this.f251965b);
            }
        }
    }

    public static int a(AppInterface appInterface, String str, long j3, long j16) {
        int i3 = (int) j3;
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    if (i3 != 5) {
                        if (i3 != 12) {
                            if (i3 == 19) {
                                int l3 = ff.l(appInterface, str, 5);
                                if (l3 == 1 && j16 == 1) {
                                    return R.drawable.skin_icon_mentorship_svip;
                                }
                                if (l3 == 2 && j16 == 1) {
                                    return R.drawable.skin_icon_mentorship_unionvip;
                                }
                                if (l3 == 3 && j16 == 1) {
                                    return R.drawable.skin_icon_mentorship_yellowvip;
                                }
                                if (l3 == 4 && j16 == 1) {
                                    return R.drawable.skin_icon_mentorship_newyear;
                                }
                            }
                        } else {
                            int l16 = ff.l(appInterface, str, 1);
                            if (l16 == 1) {
                                if (j16 == 1) {
                                    return R.drawable.skin_icon_small_ship_svip;
                                }
                                if (j16 == 2) {
                                    return R.drawable.skin_icon_big_ship_svip;
                                }
                            } else if (l16 == 2) {
                                if (j16 == 1) {
                                    return R.drawable.skin_icon_small_ship_unionvip;
                                }
                                if (j16 == 2) {
                                    return R.drawable.skin_icon_big_ship_unionvip;
                                }
                            }
                        }
                    } else {
                        int l17 = ff.l(appInterface, str, 0);
                        if (l17 == 1) {
                            if (j16 == 1) {
                                return R.drawable.skin_icon_small_fire_svip;
                            }
                            if (j16 == 2) {
                                return R.drawable.skin_icon_big_fire_svip;
                            }
                        } else if (l17 == 2) {
                            if (j16 == 1) {
                                return R.drawable.skin_icon_small_fire_unionvip;
                            }
                            if (j16 == 2) {
                                return R.drawable.skin_icon_big_fire_unionvip;
                            }
                        }
                    }
                } else {
                    int l18 = ff.l(appInterface, str, 4);
                    if (l18 == 1) {
                        if (j16 == 0) {
                            return R.drawable.hot_reactive_gray_intimate_jiyou_svip_1_icon;
                        }
                        if (j16 == 1) {
                            return R.drawable.hot_reactive_gray_intimate_jiyou_svip_2_icon;
                        }
                        if (j16 == 2) {
                            return R.drawable.hot_reactive_gray_intimate_jiyou_svip_3_icon;
                        }
                    } else if (l18 == 2) {
                        if (j16 == 0) {
                            return R.drawable.hot_reactive_gray_intimate_jiyou_unionvip_1_icon;
                        }
                        if (j16 == 1) {
                            return R.drawable.hot_reactive_gray_intimate_jiyou_unionvip_2_icon;
                        }
                        if (j16 == 2) {
                            return R.drawable.hot_reactive_gray_intimate_jiyou_unionvip_3_icon;
                        }
                    }
                }
            } else {
                int l19 = ff.l(appInterface, str, 3);
                if (l19 == 1) {
                    if (j16 == 0) {
                        return R.drawable.hot_reactive_gray_intimate_guimi_svip_1_icon;
                    }
                    if (j16 == 1) {
                        return R.drawable.hot_reactive_gray_intimate_guimi_svip_2_icon;
                    }
                    if (j16 == 2) {
                        return R.drawable.hot_reactive_gray_intimate_guimi_svip_3_icon;
                    }
                } else if (l19 == 2) {
                    if (j16 == 0) {
                        return R.drawable.hot_reactive_gray_intimate_guimi_unionvip_1_icon;
                    }
                    if (j16 == 1) {
                        return R.drawable.hot_reactive_gray_intimate_guimi_unionvip_2_icon;
                    }
                    if (j16 == 2) {
                        return R.drawable.hot_reactive_gray_intimate_guimi_unionvip_3_icon;
                    }
                }
            }
        } else if (ff.l(appInterface, str, 2) > 0) {
            if (j16 == 0) {
                return R.drawable.skin_icon_intimate_lover_vip_1;
            }
            if (j16 == 1) {
                return R.drawable.skin_icon_intimate_lover_vip_2;
            }
            if (j16 == 2) {
                return R.drawable.skin_icon_intimate_lover_vip_3;
            }
        }
        return 0;
    }

    public static String b(AppInterface appInterface, String str, String str2) {
        int l3;
        if (TextUtils.isEmpty(str2)) {
            return str2;
        }
        String[] split = str2.split("/");
        if (split.length < 2) {
            return str2;
        }
        String str3 = split[split.length - 2];
        ad a16 = MutualMarkConfProcessor.a();
        if (a16 == null) {
            return str2;
        }
        if (a16.h(str3) > 0 && (l3 = ff.l(appInterface, str, 0)) > 0) {
            return f.e(str2, l3, false);
        }
        return str2;
    }

    public static String c(QQAppInterface qQAppInterface, String str, long j3, long j16, long j17, String str2) {
        int l3 = ff.l(qQAppInterface, str, 0);
        if (l3 <= 0) {
            return str2;
        }
        if ((j16 == 6 && j17 > 0) || j3 == 5) {
            str2 = f.e(str2, l3, false);
        }
        if (!TextUtils.isEmpty(str2)) {
            return str2;
        }
        if (j16 > 0 && j3 == 5) {
            return f.d(j3, l3, j16, false);
        }
        return str2;
    }

    public static void d(QQAppInterface qQAppInterface, FriendsManager friendsManager, Friends friends, String str, byte[] bArr, boolean z16) {
        if (bArr != null && bArr.length > 0) {
            com.tencent.qqnt.ntrelation.intimateinfo.bean.a aVar = new com.tencent.qqnt.ntrelation.intimateinfo.bean.a(((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(str), str);
            aVar.q();
            aVar.s(bArr);
            if (z16) {
                ((IIntimateInfoService) QRoute.api(IIntimateInfoService.class)).accurateUpdateIntimateSimpleInfo(aVar, "MutualMarkAlienationHelper_handleRelationIconFlag", new C8127a(qQAppInterface, str));
            }
        }
    }

    public static void e(QQAppInterface qQAppInterface, String str, byte[] bArr, boolean z16) {
        if (bArr != null && bArr.length > 0) {
            com.tencent.qqnt.ntrelation.intimateinfo.bean.a aVar = new com.tencent.qqnt.ntrelation.intimateinfo.bean.a(((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(str), str);
            aVar.q();
            aVar.s(bArr);
            if (z16) {
                ((IIntimateInfoService) QRoute.api(IIntimateInfoService.class)).accurateUpdateIntimateSimpleInfo(aVar, "MutualMarkAlienationHelper", new b(qQAppInterface, str));
            }
        }
    }
}
