package com.tencent.mobileqq.activity.recent;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.biz.pubaccount.ecshopassit.EcShopAssistantManager;
import com.tencent.biz.pubaccount.serviceAccountFolder.ServiceAccountFolderManager;
import com.tencent.biz.pubaccount.util.api.IPublicAccountConfigUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.bless.BlessManager;
import com.tencent.mobileqq.activity.recent.data.RecentCallItem;
import com.tencent.mobileqq.activity.recent.data.RecentItemConfessMsg;
import com.tencent.mobileqq.activity.recent.data.RecentItemImaxADData;
import com.tencent.mobileqq.activity.recent.gamemsgbox.api.IGameMsgBoxManager;
import com.tencent.mobileqq.activity.recent.gamemsgbox.data.GameBoxRecentUser;
import com.tencent.mobileqq.activity.recent.msgbox.api.ITempChatPluginManager;
import com.tencent.mobileqq.activity.recent.msgbox.api.ITempMsgBoxService;
import com.tencent.mobileqq.activity.recent.msgbox.tempchat.TempChatSource;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.avatar.api.IQQAvatarService;
import com.tencent.mobileqq.avatar.listener.DecodeTaskCompletionListener;
import com.tencent.mobileqq.avatar.utils.ProAvatarComponentUtils;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.gamecenter.api.IGameMsgHelperApi;
import com.tencent.mobileqq.nearby.api.INearbyCardManagerUtils;
import com.tencent.mobileqq.phonecontact.api.IPhoneContactService;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.utils.aw;
import com.tencent.mobileqq.vas.pendant.drawable.PendantConstant;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.theme.SkinnableBitmapDrawable;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/* compiled from: P */
/* loaded from: classes10.dex */
public class i {
    static IPatchRedirector $redirector_;

    /* renamed from: g, reason: collision with root package name */
    private static List<Integer> f185623g;

    /* renamed from: h, reason: collision with root package name */
    private static List<Integer> f185624h;

    /* renamed from: i, reason: collision with root package name */
    private static HashMap<Integer, Integer> f185625i;

    /* renamed from: j, reason: collision with root package name */
    private static HashMap<Integer, Integer> f185626j;

    /* renamed from: a, reason: collision with root package name */
    public IFaceDecoder f185627a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f185628b;

    /* renamed from: c, reason: collision with root package name */
    protected QQAppInterface f185629c;

    /* renamed from: d, reason: collision with root package name */
    private DecodeTaskCompletionListener f185630d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f185631e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f185632f;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(69154);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 18)) {
            redirector.redirect((short) 18);
            return;
        }
        f185623g = Arrays.asList(0, 1000, 10004, 1020, 1003, 1005, 1004, 1008, 10005, 1009, 1021, 1022, 1023, 1024, 1025, Integer.valueOf(AppConstants.VALUE.UIN_TYPE_DINGDONG_MSG_SESSION), Integer.valueOf(AppConstants.VALUE.UIN_TYPE_CONVERSATION_MAY_KNOW_FRIEND_VERTICAL_ITEM), 10008, 10010);
        f185624h = Arrays.asList(1001, 1010, 10002);
        f185625i = new HashMap<>();
        f185626j = new HashMap<>();
        s();
        t();
    }

    public i(QQAppInterface qQAppInterface, DecodeTaskCompletionListener decodeTaskCompletionListener) {
        this(qQAppInterface, decodeTaskCompletionListener, false);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this, (Object) qQAppInterface, (Object) decodeTaskCompletionListener);
    }

    private static Pair<Integer, Integer> b(String str) {
        int i3;
        boolean equals = String.valueOf(AppConstants.SYSTEM_MSG_UIN).equals(str);
        int i16 = R.drawable.icon_recent_sysmsg;
        int i17 = Integer.MIN_VALUE;
        if (!equals && !String.valueOf(AppConstants.QQBROADCAST_MSG_UIN).equals(str)) {
            if (String.valueOf(AppConstants.SAME_STATE_BOX_UIN).equals(str)) {
                i16 = R.drawable.icon_same_state;
            } else if (AppConstants.VOTE_MSG_UIN.equals(str)) {
                i16 = R.drawable.bqg;
            } else {
                if (AppConstants.NEW_KANDIAN_UIN.equals(str)) {
                    i3 = 110;
                } else {
                    i3 = 1;
                }
                i16 = Integer.MIN_VALUE;
                i17 = i3;
            }
        }
        return Pair.create(Integer.valueOf(i17), Integer.valueOf(i16));
    }

    private Drawable c(String str, int i3) {
        if (i3 == 105) {
            IPublicAccountConfigUtil.a folder = ((IPublicAccountConfigUtil) QRoute.api(IPublicAccountConfigUtil.class)).getFolder(this.f185629c, BaseApplication.getContext(), 1);
            if (folder != null && folder.a() != null) {
                return folder.a();
            }
            return ((IPublicAccountConfigUtil) QRoute.api(IPublicAccountConfigUtil.class)).getDefaultDrawable(BaseApplication.getContext(), 1);
        }
        if (i3 == 106) {
            return EcShopAssistantManager.l(BaseApplication.getContext());
        }
        if (i3 == 108) {
            return ((BlessManager) this.f185629c.getManager(QQManagerFactory.SEND_BLESS_CONFIG_MANAGER)).H();
        }
        if (i3 == 110) {
            IPublicAccountConfigUtil.a folder2 = ((IPublicAccountConfigUtil) QRoute.api(IPublicAccountConfigUtil.class)).getFolder(this.f185629c, BaseApplication.getContext(), 2);
            if (folder2 != null && folder2.a() != null) {
                return folder2.a();
            }
            return ((IPublicAccountConfigUtil) QRoute.api(IPublicAccountConfigUtil.class)).getDefaultDrawable(BaseApplication.getContext(), 2);
        }
        if (i3 == 112) {
            return BaseApplicationImpl.sApplication.getResources().getDrawable(ServiceAccountFolderManager.b());
        }
        if (i3 == 116) {
            return com.tencent.mobileqq.extendfriend.apollo.face.b.d(this.f185629c, str);
        }
        return null;
    }

    private Drawable d(int i3) {
        if (i3 != 1) {
            if (i3 != 4) {
                if (i3 != 11) {
                    if (i3 != 32) {
                        if (i3 != 107) {
                            if (i3 != 113) {
                                if (i3 != 120) {
                                    if (i3 != 1001) {
                                        if (i3 != 115) {
                                            if (i3 != 116) {
                                                switch (i3) {
                                                    case 101:
                                                        break;
                                                    case 102:
                                                        return aw.g(102);
                                                    case 103:
                                                        return BaseImageUtil.getDefaultSubAccountFaceDrawable();
                                                    default:
                                                        return null;
                                                }
                                            } else {
                                                return com.tencent.mobileqq.extendfriend.apollo.face.b.b(6);
                                            }
                                        } else {
                                            return BaseImageUtil.getDefaultFaceDrawable(true);
                                        }
                                    }
                                } else {
                                    return aw.g(120);
                                }
                            }
                            return BaseImageUtil.getDefaultDiscusionFaceDrawable();
                        }
                        return aw.g(107);
                    }
                    return BaseImageUtil.getDefaultFaceDrawable();
                }
                return BaseImageUtil.getDefaultFaceDrawable();
            }
            return BaseImageUtil.getDefaultTroopFaceDrawable();
        }
        return BaseImageUtil.getDefaultFaceDrawable();
    }

    private Drawable h(int i3, String str) {
        com.tencent.mobileqq.activity.recent.msgbox.tempchat.a tempChatPlugin;
        if (((ITempMsgBoxService) QRoute.api(ITempMsgBoxService.class)).getTempUinTypeList().contains(Integer.valueOf(i3)) && (tempChatPlugin = ((ITempChatPluginManager) this.f185629c.getRuntimeService(ITempChatPluginManager.class, "")).getTempChatPlugin(i3)) != null) {
            return tempChatPlugin.a(str, TempChatSource.SOURCE_FROM_MAG_TAB);
        }
        return null;
    }

    private static Pair<Integer, Integer> m(QQAppInterface qQAppInterface, int i3, String str) {
        int i16;
        int i17;
        int i18;
        int i19 = Integer.MIN_VALUE;
        if (i3 != 1) {
            if (i3 != 1032) {
                if (i3 != 7000) {
                    if (i3 != 7120) {
                        if (i3 != 7230) {
                            if (i3 != 9501) {
                                if (i3 != 10015) {
                                    i17 = Integer.MIN_VALUE;
                                } else {
                                    i17 = R.drawable.neb;
                                }
                            } else {
                                i19 = 104;
                                i17 = R.drawable.ck5;
                            }
                        } else {
                            if (TextUtils.isEmpty(((IPublicAccountConfigUtil) QRoute.api(IPublicAccountConfigUtil.class)).getServiceAccountFolderIcon())) {
                                i18 = ServiceAccountFolderManager.b();
                            } else {
                                i18 = Integer.MAX_VALUE;
                            }
                            i19 = i18;
                            i16 = 112;
                        }
                    } else {
                        i19 = 106;
                        i17 = R.drawable.qvip_aio_shop_assist_tab_icon;
                    }
                } else if (AppConstants.SUBACCOUNT_ASSISTANT_UIN.equals(str)) {
                    i17 = R.drawable.icon_recent_subaccount;
                } else {
                    i16 = 103;
                }
            } else if (TextUtils.equals(str, AppConstants.CONFESS_UIN) || !TextUtils.equals(str, AppConstants.CONFESS_FRD_REC_UIN)) {
                i17 = R.drawable.qq_confess_icon_entry;
            } else {
                i17 = R.drawable.qq_confess_icon_frdrec;
            }
            return Pair.create(Integer.valueOf(i19), Integer.valueOf(i17));
        }
        if (TroopUtils.n(str)) {
            i16 = 4;
        } else {
            i16 = 113;
        }
        int i26 = i19;
        i19 = i16;
        i17 = i26;
        return Pair.create(Integer.valueOf(i19), Integer.valueOf(i17));
    }

    public static Pair<Integer, Integer> n(QQAppInterface qQAppInterface, int i3, String str) {
        if (f185625i.containsKey(Integer.valueOf(i3))) {
            return new Pair<>(f185625i.get(Integer.valueOf(i3)), Integer.MIN_VALUE);
        }
        if (f185626j.containsKey(Integer.valueOf(i3))) {
            return new Pair<>(Integer.MIN_VALUE, f185626j.get(Integer.valueOf(i3)));
        }
        if (f185623g.contains(Integer.valueOf(i3))) {
            return b(str);
        }
        if (f185624h.contains(Integer.valueOf(i3))) {
            return o(str);
        }
        return m(qQAppInterface, i3, str);
    }

    private static Pair<Integer, Integer> o(String str) {
        int i3;
        int i16 = Integer.MIN_VALUE;
        if (String.valueOf(AppConstants.LBS_HELLO_UIN).equals(str)) {
            i3 = R.drawable.icon_recent_lbs_hello;
        } else if (AppConstants.MSG_BOX_INTERACT_UIN.equals(str)) {
            i3 = R.drawable.ezi;
        } else if (AppConstants.MSG_BOX_FOLLOW_UIN.equals(str)) {
            i3 = R.drawable.ezh;
        } else if (AppConstants.MSG_BOX_MYMOMMENT_UIN.equals(str)) {
            i3 = R.drawable.f161790mg1;
        } else if (AppConstants.MSG_BOX_DAREN_ASSISTANT_UIN.equals(str)) {
            i3 = R.drawable.ezg;
        } else if (AppConstants.MSG_BOX_YANZHI_UIN.equals(str)) {
            i3 = R.drawable.ezk;
        } else {
            i16 = 32;
            i3 = Integer.MIN_VALUE;
        }
        return Pair.create(Integer.valueOf(i16), Integer.valueOf(i3));
    }

    public static boolean q(int i3, RecentBaseData recentBaseData) {
        if (i3 == 10005 && (recentBaseData instanceof RecentItemImaxADData) && !TextUtils.isEmpty(((RecentItemImaxADData) recentBaseData).mHeaderUrl)) {
            return true;
        }
        return false;
    }

    private static void s() {
        f185625i.put(6002, 104);
        f185625i.put(1006, 11);
        f185625i.put(3000, 101);
        f185625i.put(3002, 1001);
        f185625i.put(Integer.valueOf(AppConstants.VALUE.UIN_TYPE_CONVERSATION_RECOMMEND_TROOP_ITEM), 4);
        f185625i.put(9003, 108);
        f185625i.put(Integer.valueOf(AppConstants.VALUE.UIN_TYPE_TROOP_BAR_ASSIST), 105);
        f185625i.put(Integer.valueOf(AppConstants.VALUE.UIN_TYPE_KANDIAN_MERGE), 111);
        f185625i.put(1033, 1);
        f185625i.put(1044, 1);
        f185625i.put(1045, 1);
    }

    private static void t() {
        f185626j.put(6000, Integer.valueOf(R.drawable.qfile_dataline_pc_recent));
        f185626j.put(6003, Integer.valueOf(R.drawable.qfile_dataline_ipad_recent));
        f185626j.put(6005, Integer.valueOf(R.drawable.qfile_dataline_user_aio));
        f185626j.put(4000, Integer.valueOf(R.drawable.cqe));
        f185626j.put(9002, Integer.valueOf(R.drawable.qq_af_icon));
        f185626j.put(5000, Integer.valueOf(R.drawable.icon_recent_troop_assistant));
        f185626j.put(5001, Integer.valueOf(R.drawable.qb_hc_user_created));
        f185626j.put(7200, Integer.valueOf(R.drawable.icon_recent_public_account));
        f185626j.put(9000, Integer.valueOf(R.drawable.icon_recent_sysmsg));
        f185626j.put(9503, Integer.valueOf(R.drawable.icon_recent_readinjoy));
        f185626j.put(9999, Integer.valueOf(R.drawable.ckk));
        f185626j.put(1031, Integer.valueOf(R.drawable.icon));
        f185626j.put(6004, Integer.valueOf(R.drawable.tencent_docs_assistant_logo));
        f185626j.put(10011, Integer.valueOf(R.drawable.temp_msg_box_icon));
        f185626j.put(10012, Integer.valueOf(R.drawable.filter_msg_box_icon));
    }

    public QQAppInterface a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (QQAppInterface) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.f185629c;
    }

    public Drawable e(int i3, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (Drawable) iPatchRedirector.redirect((short) 7, (Object) this, i3, (Object) str);
        }
        return f(i3, str, true);
    }

    public Drawable f(int i3, String str, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (Drawable) iPatchRedirector.redirect((short) 10, this, Integer.valueOf(i3), str, Boolean.valueOf(z16));
        }
        return j(i3, str, z16, false, 0L, null);
    }

    public Drawable g(RecentBaseData recentBaseData) {
        Drawable l3;
        int i3;
        BitmapDrawable bitmapDrawable;
        PhoneContact phoneContact;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (Drawable) iPatchRedirector.redirect((short) 4, (Object) this, (Object) recentBaseData);
        }
        if (QLog.isColorLevel()) {
            QLog.d("RecentFaceDecoder", 2, "getFaceDrawable start");
        }
        int recentUserType = recentBaseData.getRecentUserType();
        if (recentBaseData.getRecentUserType() == 8) {
            int i16 = recentBaseData.mExtraType;
            if (QLog.isColorLevel()) {
                QLog.i("Q.recent", 2, "getFaceDrawable type = " + i16);
            }
            if (i16 != 0) {
                if (i16 == 25) {
                    IPhoneContactService iPhoneContactService = (IPhoneContactService) this.f185629c.getRuntimeService(IPhoneContactService.class, "");
                    if (iPhoneContactService != null) {
                        phoneContact = iPhoneContactService.queryContactByCodeNumber(recentBaseData.mPhoneNumber);
                    } else {
                        phoneContact = null;
                    }
                    if (phoneContact != null) {
                        l3 = FaceDrawable.getMobileFaceDrawable(this.f185629c, recentBaseData.mPhoneNumber, (byte) 3);
                        if (l3 == null) {
                            l3 = BaseImageUtil.getDefaultFaceDrawable();
                        }
                    } else {
                        Bitmap faceBitmap = this.f185629c.getFaceBitmap(16, recentBaseData.getRecentUserUin(), (byte) 3, true, 16);
                        if (faceBitmap == null) {
                            l3 = BaseImageUtil.getDefaultFaceDrawable();
                        } else {
                            bitmapDrawable = new BitmapDrawable(faceBitmap);
                            l3 = bitmapDrawable;
                        }
                    }
                } else {
                    Bitmap faceBitmap2 = this.f185629c.getFaceBitmap(recentBaseData.getRecentUserUin(), (byte) 3, true);
                    if (faceBitmap2 == null) {
                        l3 = BaseImageUtil.getDefaultFaceDrawable();
                    } else {
                        bitmapDrawable = new BitmapDrawable(faceBitmap2);
                        l3 = bitmapDrawable;
                    }
                }
            } else {
                l3 = e(i16, recentBaseData.getRecentUserUin());
            }
        } else if (recentUserType == 26) {
            l3 = com.tencent.mobileqq.qcall.a.e(this.f185629c, recentBaseData.getRecentUserUin());
        } else if (recentUserType == 1034) {
            if ((recentBaseData instanceof RecentItemConfessMsg) && ((RecentItemConfessMsg) recentBaseData).mConfessInfo.confessorSex == 1) {
                i3 = R.drawable.ep6;
            } else {
                i3 = R.drawable.ep5;
            }
            l3 = BaseApplication.getContext().getResources().getDrawable(i3);
        } else if (q(recentUserType, recentBaseData)) {
            l3 = p(114, ((RecentItemImaxADData) recentBaseData).mHeaderUrl);
        } else if (recentUserType == 10007) {
            GameBoxRecentUser findGameBoxRecentUserInfo = ((IGameMsgBoxManager) this.f185629c.getRuntimeService(IGameMsgBoxManager.class, "")).findGameBoxRecentUserInfo(recentBaseData.getRecentUserUin());
            if (findGameBoxRecentUserInfo != null) {
                l3 = ((IGameMsgHelperApi) QRoute.api(IGameMsgHelperApi.class)).getGameUsrDrawable(BaseApplication.getContext(), this.f185629c, findGameBoxRecentUserInfo.mToRoleId);
            } else {
                l3 = ((IGameMsgHelperApi) QRoute.api(IGameMsgHelperApi.class)).getRecentGameMsgDrawable(this.f185629c, recentBaseData.getRecentUserUin());
            }
        } else {
            String recentUserUin = recentBaseData.getRecentUserUin();
            if ((recentBaseData instanceof RecentCallItem) && ((RecentCallItem) recentBaseData).a()) {
                recentUserType = 3002;
            }
            l3 = l(recentBaseData, recentUserType, recentUserUin);
        }
        if (QLog.isColorLevel()) {
            QLog.d("RecentFaceDecoder", 2, "getFaceDrawable end");
        }
        return l3;
    }

    public Drawable i(int i3, String str, boolean z16, long j3, Drawable drawable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (Drawable) iPatchRedirector.redirect((short) 8, this, Integer.valueOf(i3), str, Boolean.valueOf(z16), Long.valueOf(j3), drawable);
        }
        return j(i3, str, true, z16, j3, drawable);
    }

    public Drawable j(int i3, String str, boolean z16, boolean z17, long j3, Drawable drawable) {
        Drawable drawable2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (Drawable) iPatchRedirector.redirect((short) 11, this, Integer.valueOf(i3), str, Boolean.valueOf(z16), Boolean.valueOf(z17), Long.valueOf(j3), drawable);
        }
        Drawable h16 = h(i3, str);
        if (h16 != null) {
            return h16;
        }
        Pair<Integer, Integer> n3 = n(this.f185629c, i3, str);
        int intValue = ((Integer) n3.first).intValue();
        int intValue2 = ((Integer) n3.second).intValue();
        try {
            if (intValue2 == Integer.MAX_VALUE) {
                drawable2 = p(intValue, str);
            } else if (intValue != Integer.MIN_VALUE) {
                drawable2 = k(str, intValue, z17, j3, drawable);
            } else if (intValue2 != Integer.MIN_VALUE && z16) {
                drawable2 = BaseApplication.getContext().getResources().getDrawable(intValue2);
            } else {
                return h16;
            }
            h16 = drawable2;
            return h16;
        } catch (Exception e16) {
            e16.printStackTrace();
            return h16;
        }
    }

    public Drawable k(String str, int i3, boolean z16, long j3, Drawable drawable) {
        int i16;
        int i17;
        Object valueOf;
        FaceDrawable outboundUserFaceDrawable;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (Drawable) iPatchRedirector.redirect((short) 13, this, str, Integer.valueOf(i3), Boolean.valueOf(z16), Long.valueOf(j3), drawable);
        }
        Drawable c16 = c(str, i3);
        if (c16 != null) {
            return c16;
        }
        Drawable d16 = ProAvatarComponentUtils.d(this.f185629c.getApp(), i3, str, z16, j3, PendantConstant.PENDANT_TARGET_ID_RECENT_MSG, false, 0, drawable);
        if (d16 != null) {
            return d16;
        }
        Bitmap bitmap = null;
        if (this.f185628b) {
            this.f185629c.getFaceBitmap(i3, str, false, 0);
            return null;
        }
        if (this.f185631e && !this.f185632f) {
            if (QLog.isColorLevel()) {
                QLog.d("RecentFaceDecoder", 2, "getFaceDrawable getDefaultFaceDrawable 1");
            }
            return d(i3);
        }
        if (i3 == 1 && (outboundUserFaceDrawable = FaceDrawable.getOutboundUserFaceDrawable(this.f185629c, str, (byte) 3, !ThemeUtil.isNowThemeIsSuperTheme(), 100)) != null) {
            return outboundUserFaceDrawable;
        }
        if (i3 == 103) {
            i16 = 1;
        } else {
            i16 = i3;
        }
        if (((INearbyCardManagerUtils) QRoute.api(INearbyCardManagerUtils.class)).isTinyId(str)) {
            i17 = 202;
        } else {
            i17 = 200;
        }
        IFaceDecoder iFaceDecoder = this.f185627a;
        if (iFaceDecoder != null) {
            if (i3 == 32) {
                bitmap = iFaceDecoder.getBitmapFromCache(i16, str, i17);
            } else {
                bitmap = iFaceDecoder.getBitmapFromCache(i16, str);
            }
        }
        if (QLog.isDevelopLevel()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("requestDecodeFace| [");
            sb5.append(str);
            sb5.append(",");
            sb5.append(i3);
            sb5.append(",");
            sb5.append(bitmap);
            sb5.append("], isPausing=");
            IFaceDecoder iFaceDecoder2 = this.f185627a;
            if (iFaceDecoder2 == null) {
                valueOf = "null";
            } else {
                valueOf = Boolean.valueOf(iFaceDecoder2.isPausing());
            }
            sb5.append(valueOf);
            QLog.i("Q.recent", 4, sb5.toString());
        }
        if (bitmap == null) {
            IFaceDecoder iFaceDecoder3 = this.f185627a;
            if (iFaceDecoder3 != null && !iFaceDecoder3.isPausing()) {
                if (i16 == 32) {
                    this.f185627a.requestDecodeStrangeFace(str, i17, true, false);
                } else {
                    this.f185627a.requestDecodeFace(str, i16, true, (byte) 0);
                    if (i16 == 1001 && this.f185627a.getBitmapFromCache(101, str) == null) {
                        this.f185627a.requestDecodeFace(str, 101, true, (byte) 0);
                    }
                }
            }
            if (QLog.isColorLevel()) {
                QLog.d("RecentFaceDecoder", 2, "getFaceDrawable getDefaultFaceDrawable 2");
            }
            return d(i3);
        }
        if (i3 == 103) {
            Drawable drawable2 = BaseApplication.getContext().getResources().getDrawable(R.drawable.icon_cover_recent_subaccount);
            if (drawable2 instanceof SkinnableBitmapDrawable) {
                ((SkinnableBitmapDrawable) drawable2).setGravity(81);
            }
            if (drawable2 instanceof BitmapDrawable) {
                ((BitmapDrawable) drawable2).setGravity(81);
            }
            drawable2.setBounds(0, 0, drawable2.getIntrinsicWidth(), drawable2.getIntrinsicHeight());
            return new LayerDrawable(new Drawable[]{new BitmapDrawable(BaseApplication.getContext().getResources(), bitmap), drawable2});
        }
        return new BitmapDrawable(BaseApplication.getContext().getResources(), bitmap);
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:28:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Drawable l(RecentBaseData recentBaseData, int i3, String str) {
        Drawable drawable;
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z16 = false;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (Drawable) iPatchRedirector.redirect((short) 5, this, recentBaseData, Integer.valueOf(i3), str);
        }
        QQAppInterface a16 = a();
        if (a16 != null && i3 == 1 && TroopUtils.s()) {
            com.tencent.mobileqq.app.n nVar = (com.tencent.mobileqq.app.n) a16.getManager(QQManagerFactory.DISCUSSION_MANAGER);
            String j3 = nVar.j(recentBaseData.getRecentUserUin());
            if (!TextUtils.isEmpty(j3)) {
                long s16 = nVar.s(j3);
                if (QLog.isColorLevel() && !TextUtils.isEmpty(j3)) {
                    QLog.d("RecentFaceDecoder", 2, "getFaceDrawableWrapper: troopUin = " + StringUtil.getSimpleUinForPrint(recentBaseData.getRecentUserUin()) + ", discUin = " + StringUtil.getSimpleUinForPrint(j3) + ", toTroopTime = " + s16 + ", opTime = " + recentBaseData.getLastMsgTime());
                }
                if ((s16 < 0 && (-s16) >= recentBaseData.getLastMsgTime()) || (s16 > 0 && s16 >= recentBaseData.getLastMsgTime())) {
                    drawable = e(3000, j3);
                    z16 = true;
                    if (z16) {
                        return e(i3, str);
                    }
                    return drawable;
                }
            }
        }
        drawable = null;
        if (z16) {
        }
    }

    public URLDrawable p(int i3, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (URLDrawable) iPatchRedirector.redirect((short) 14, (Object) this, i3, (Object) str);
        }
        if (i3 != 112) {
            if (i3 != 114) {
                return null;
            }
            Drawable defaultFaceDrawable = BaseImageUtil.getDefaultFaceDrawable();
            URLDrawable drawable = URLDrawable.getDrawable(str, defaultFaceDrawable, defaultFaceDrawable);
            drawable.setDecodeHandler(com.tencent.mobileqq.urldrawable.a.f306322b);
            return drawable;
        }
        Drawable drawable2 = BaseApplicationImpl.sApplication.getResources().getDrawable(ServiceAccountFolderManager.b());
        return URLDrawable.getDrawable(((IPublicAccountConfigUtil) QRoute.api(IPublicAccountConfigUtil.class)).getServiceAccountFolderIcon(), drawable2, drawable2);
    }

    public void r() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this);
            return;
        }
        IFaceDecoder iFaceDecoder = this.f185627a;
        if (iFaceDecoder != null) {
            iFaceDecoder.destory();
            this.f185627a = null;
        }
        this.f185630d = null;
        this.f185629c = null;
    }

    public i(QQAppInterface qQAppInterface, DecodeTaskCompletionListener decodeTaskCompletionListener, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, qQAppInterface, decodeTaskCompletionListener, Boolean.valueOf(z16));
            return;
        }
        this.f185631e = false;
        this.f185632f = false;
        IFaceDecoder iQQAvatarService = ((IQQAvatarService) qQAppInterface.getRuntimeService(IQQAvatarService.class, "")).getInstance(qQAppInterface);
        this.f185627a = iQQAvatarService;
        iQQAvatarService.setDecodeTaskCompletionListener(decodeTaskCompletionListener);
        this.f185630d = decodeTaskCompletionListener;
        this.f185629c = qQAppInterface;
        this.f185631e = z16;
    }
}
