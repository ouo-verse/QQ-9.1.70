package com.tencent.mobileqq.mutualmark.oldlogic;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Environment;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.util.Xml;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.utils.ea;
import com.tencent.mobileqq.utils.en;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import org.json.JSONObject;
import org.xmlpull.v1.XmlPullParser;

/* compiled from: P */
/* loaded from: classes15.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    static String f252239a;

    /* renamed from: b, reason: collision with root package name */
    static String f252240b;

    /* renamed from: c, reason: collision with root package name */
    static String f252241c;

    /* renamed from: d, reason: collision with root package name */
    static String f252242d;

    /* renamed from: e, reason: collision with root package name */
    static String f252243e;

    /* renamed from: f, reason: collision with root package name */
    static String f252244f;

    /* renamed from: g, reason: collision with root package name */
    static String f252245g;

    /* renamed from: h, reason: collision with root package name */
    private static boolean f252246h;

    /* renamed from: i, reason: collision with root package name */
    private static boolean f252247i;

    /* renamed from: j, reason: collision with root package name */
    private static final HashSet<com.tencent.qqnt.ntrelation.intimateinfo.bean.a> f252248j;

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.mutualmark.oldlogic.a$a, reason: collision with other inner class name */
    /* loaded from: classes15.dex */
    public static class C8130a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public String f252249a;

        /* renamed from: b, reason: collision with root package name */
        public String f252250b;

        /* renamed from: c, reason: collision with root package name */
        public int f252251c;

        public C8130a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(73305);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        f252239a = "HotReactiveHelper";
        f252240b = Environment.getExternalStorageDirectory().getAbsolutePath();
        f252241c = f252240b + "/Tencent/MobileQQ/";
        f252242d = f252241c + "hotimage/";
        f252243e = "friendshipres/";
        f252244f = "friendshipres2/";
        f252245g = "poke/";
        f252246h = false;
        f252247i = false;
        f252248j = new HashSet<>();
    }

    public static void a(com.tencent.qqnt.ntrelation.intimateinfo.bean.a aVar) {
        if (aVar != null) {
            f252248j.add(aVar);
        }
    }

    public static String b() {
        return VFSAssistantUtils.getSDKPrivatePath(f252242d);
    }

    public static List<String> c(AppInterface appInterface, String str, String str2) {
        ArrayList arrayList = new ArrayList();
        if (str.contains("#likepic1")) {
            String d16 = com.tencent.mobileqq.mutualmark.b.d(appInterface, str2, 6L, 1L);
            str = str.replace("#likepic1", d16);
            arrayList.add(d16);
        }
        if (str.contains("#praisepic1")) {
            String d17 = com.tencent.mobileqq.mutualmark.b.d(appInterface, str2, 6L, 1L);
            str = str.replace("#praisepic1", d17);
            arrayList.add(d17);
        }
        if (str.contains("#likepic2")) {
            String d18 = com.tencent.mobileqq.mutualmark.b.d(appInterface, str2, 6L, 2L);
            str = str.replace("#likepic2", d18);
            arrayList.add(d18);
        }
        if (str.contains("#praisepic2")) {
            String d19 = com.tencent.mobileqq.mutualmark.b.d(appInterface, str2, 6L, 2L);
            str = str.replace("#praisepic2", d19);
            arrayList.add(d19);
        }
        if (str.contains("#chatpic1")) {
            String d26 = com.tencent.mobileqq.mutualmark.b.d(appInterface, str2, 5L, 1L);
            str = str.replace("#chatpic1", d26);
            arrayList.add(d26);
        }
        if (str.contains("#chatpic2")) {
            String d27 = com.tencent.mobileqq.mutualmark.b.d(appInterface, str2, 5L, 2L);
            str = str.replace("#chatpic2", d27);
            arrayList.add(d27);
        }
        if (str.contains("#oftenchatpic1")) {
            String d28 = com.tencent.mobileqq.mutualmark.b.d(appInterface, str2, 12L, 1L);
            str = str.replace("#oftenchatpic1", d28);
            arrayList.add(d28);
        }
        if (str.contains("#oftenchatpic2")) {
            String d29 = com.tencent.mobileqq.mutualmark.b.d(appInterface, str2, 12L, 2L);
            str = str.replace("#oftenchatpic2", d29);
            arrayList.add(d29);
        }
        if (str.contains("#loverchatpic1")) {
            String d36 = com.tencent.mobileqq.mutualmark.b.d(appInterface, str2, 7L, 1L);
            str = str.replace("#loverchatpic1", d36);
            arrayList.add(d36);
        }
        if (str.contains("#loverchatpic2")) {
            String d37 = com.tencent.mobileqq.mutualmark.b.d(appInterface, str2, 7L, 2L);
            str = str.replace("#loverchatpic2", d37);
            arrayList.add(d37);
        }
        if (str.contains("#qzonechatpic1")) {
            String d38 = com.tencent.mobileqq.mutualmark.b.d(appInterface, str2, 8L, 1L);
            str = str.replace("#qzonechatpic1", d38);
            arrayList.add(d38);
        }
        if (str.contains("#qzonepic1")) {
            String d39 = com.tencent.mobileqq.mutualmark.b.d(appInterface, str2, 8L, 1L);
            str = str.replace("#qzonepic1", d39);
            arrayList.add(d39);
        }
        if (str.contains("#qzonechatpic2")) {
            String d46 = com.tencent.mobileqq.mutualmark.b.d(appInterface, str2, 8L, 2L);
            str = str.replace("#qzonechatpic2", d46);
            arrayList.add(d46);
        }
        if (str.contains("#qzonepic2")) {
            String d47 = com.tencent.mobileqq.mutualmark.b.d(appInterface, str2, 8L, 2L);
            str = str.replace("#qzonepic2", d47);
            arrayList.add(d47);
        }
        if (str.contains("#friendshipicon1")) {
            String d48 = com.tencent.mobileqq.mutualmark.b.d(appInterface, str2, 4L, 1L);
            str = str.replace("#friendshipicon1", d48);
            arrayList.add(d48);
        }
        if (str.contains("#friendshipicon2")) {
            String d49 = com.tencent.mobileqq.mutualmark.b.d(appInterface, str2, 4L, 2L);
            str = str.replace("#friendshipicon2", d49);
            arrayList.add(d49);
        }
        if (str.contains("#friendshipicon3")) {
            String d56 = com.tencent.mobileqq.mutualmark.b.d(appInterface, str2, 4L, 3L);
            str = str.replace("#friendshipicon3", d56);
            arrayList.add(d56);
        }
        if (str.contains("#loverpic1")) {
            String d57 = com.tencent.mobileqq.mutualmark.b.d(appInterface, str2, 1L, 0L);
            str = str.replace("#loverpic1", d57);
            arrayList.add(d57);
        }
        if (str.contains("#loverpic2")) {
            String d58 = com.tencent.mobileqq.mutualmark.b.d(appInterface, str2, 1L, 1L);
            str = str.replace("#loverpic2", d58);
            arrayList.add(d58);
        }
        if (str.contains("#loverpic3")) {
            String d59 = com.tencent.mobileqq.mutualmark.b.d(appInterface, str2, 1L, 2L);
            str = str.replace("#loverpic3", d59);
            arrayList.add(d59);
        }
        if (str.contains("#sisterpic1")) {
            String d65 = com.tencent.mobileqq.mutualmark.b.d(appInterface, str2, 2L, 0L);
            str = str.replace("#sisterpic1", d65);
            arrayList.add(d65);
        }
        if (str.contains("#sisterpic2")) {
            String d66 = com.tencent.mobileqq.mutualmark.b.d(appInterface, str2, 2L, 1L);
            str = str.replace("#sisterpic2", d66);
            arrayList.add(d66);
        }
        if (str.contains("#sisterpic3")) {
            String d67 = com.tencent.mobileqq.mutualmark.b.d(appInterface, str2, 2L, 2L);
            str = str.replace("#sisterpic3", d67);
            arrayList.add(d67);
        }
        if (str.contains("#brotherpic1")) {
            String d68 = com.tencent.mobileqq.mutualmark.b.d(appInterface, str2, 3L, 0L);
            str = str.replace("#brotherpic1", d68);
            arrayList.add(d68);
        }
        if (str.contains("#brotherpic2")) {
            String d69 = com.tencent.mobileqq.mutualmark.b.d(appInterface, str2, 3L, 1L);
            str = str.replace("#brotherpic2", d69);
            arrayList.add(d69);
        }
        if (str.contains("#brotherpic3")) {
            String d75 = com.tencent.mobileqq.mutualmark.b.d(appInterface, str2, 3L, 2L);
            str = str.replace("#brotherpic3", d75);
            arrayList.add(d75);
        }
        arrayList.add(0, str);
        return arrayList;
    }

    public static String d(Context context, int i3) {
        String string;
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        if (i3 != 97) {
            if (i3 != 134) {
                switch (i3) {
                    case 19:
                        string = defaultSharedPreferences.getString(AppConstants.Preferences.SHOW_HOT_FRIEND_CHAT_NUM_DES, context.getString(R.string.a9g));
                        break;
                    case 20:
                        string = defaultSharedPreferences.getString(AppConstants.Preferences.SHOW_HOT_FRIEND_GRAYTIPS_CHAT_UP, context.getString(R.string.bmh));
                        break;
                    case 21:
                        string = defaultSharedPreferences.getString(AppConstants.Preferences.SHOW_HOT_FRIEND_GRAYTIPS_PRAISE_UP, context.getString(R.string.bmv));
                        break;
                    case 22:
                        string = defaultSharedPreferences.getString(AppConstants.Preferences.SHOW_HOT_FRIEND_GRAYTIPS_CLOSE_UP, context.getString(R.string.f171002bm1));
                        break;
                    case 23:
                        string = defaultSharedPreferences.getString(AppConstants.Preferences.SHOW_HOT_FRIEND_GRAYTIPS_CHAT_DOWN, context.getString(R.string.bmd));
                        break;
                    case 24:
                        string = defaultSharedPreferences.getString(AppConstants.Preferences.SHOW_HOT_FRIEND_GRAYTIPS_PRAISE_DOWN, context.getString(R.string.bmr));
                        break;
                    case 25:
                        string = defaultSharedPreferences.getString(AppConstants.Preferences.SHOW_HOT_FRIEND_GRAYTIPS_CLOSE_DOWN, context.getString(R.string.blz));
                        break;
                    case 26:
                        string = defaultSharedPreferences.getString(AppConstants.Preferences.SHOW_HOT_FRIEND_GRAYTIPS_CHAT_DIS, context.getString(R.string.bmf));
                        break;
                    case 27:
                        string = defaultSharedPreferences.getString(AppConstants.Preferences.SHOW_HOT_FRIEND_GRAYTIPS_PRAISE_DIS, context.getString(R.string.bmt));
                        break;
                    case 28:
                        string = defaultSharedPreferences.getString(AppConstants.Preferences.SHOW_HOT_FRIEND_GRAYTIPS_CLOSE_DIS, context.getString(R.string.f171001bm0));
                        break;
                    default:
                        switch (i3) {
                            case 41:
                                string = defaultSharedPreferences.getString(AppConstants.Preferences.SHOW_HOT_FRIEND_GRAYTIPS_CHAT_UP2, context.getString(R.string.bmi));
                                break;
                            case 42:
                                string = defaultSharedPreferences.getString(AppConstants.Preferences.SHOW_HOT_FRIEND_GRAYTIPS_PRAISE_UP2, context.getString(R.string.bmw));
                                break;
                            case 43:
                                string = defaultSharedPreferences.getString(AppConstants.Preferences.SHOW_HOT_FRIEND_GRAYTIPS_CLOSE_UP2, context.getString(R.string.f171003bm2));
                                break;
                            default:
                                switch (i3) {
                                    case 45:
                                        string = defaultSharedPreferences.getString(AppConstants.Preferences.SHOW_HOT_FRIEND_GRAYTIPS_PRAISE_DOWN_REMIND, context.getString(R.string.bms));
                                        break;
                                    case 46:
                                        string = defaultSharedPreferences.getString(AppConstants.Preferences.SHOW_HOT_FRIEND_GRAYTIPS_PRAISE_DIS_REMIND, context.getString(R.string.bmu));
                                        break;
                                    case 47:
                                        string = defaultSharedPreferences.getString(AppConstants.Preferences.SHOW_HOT_FRIEND_GRAYTIPS_CHAT_DOWN_REMIND, context.getString(R.string.bme));
                                        break;
                                    case 48:
                                        string = defaultSharedPreferences.getString(AppConstants.Preferences.SHOW_HOT_FRIEND_GRAYTIPS_CHAT_DIS_REMIND, context.getString(R.string.bmg));
                                        break;
                                    case 49:
                                        string = defaultSharedPreferences.getString(AppConstants.Preferences.SHOW_HOT_FRIEND_GRAYTIPS_QZONE_DOWN_REMIND, context.getString(R.string.bmx));
                                        break;
                                    case 50:
                                        string = defaultSharedPreferences.getString(AppConstants.Preferences.SHOW_HOT_FRIEND_GRAYTIPS_QZONE_DIS_REMIND, context.getString(R.string.bmy));
                                        break;
                                    case 51:
                                        string = defaultSharedPreferences.getString(AppConstants.Preferences.SHOW_HOT_FRIEND_GRAYTIPS_PRAISE_AND_CHAT_REMIND, context.getString(R.string.bmb));
                                        break;
                                    case 52:
                                        string = defaultSharedPreferences.getString(AppConstants.Preferences.SHOW_HOT_FRIEND_GRAYTIPS_CHAT_AND_QZONE_REMIND, context.getString(R.string.bmc));
                                        break;
                                    case 53:
                                        string = defaultSharedPreferences.getString(AppConstants.Preferences.SHOW_HOT_FRIEND_GRAYTIPS_PRAISE_AND_QZONE_REMIND, context.getString(R.string.bmq));
                                        break;
                                    case 54:
                                        string = defaultSharedPreferences.getString(AppConstants.Preferences.SHOW_HOT_FRIEND_GRAYTIPS_PCQALL_REMIND, context.getString(R.string.bmp));
                                        break;
                                    default:
                                        switch (i3) {
                                            case 65:
                                                string = defaultSharedPreferences.getString(AppConstants.Preferences.SHOW_HOT_FRIEND_GRAYTIPS_QZONE_LOVER_UP, context.getString(R.string.bn7));
                                                break;
                                            case 66:
                                                string = defaultSharedPreferences.getString(AppConstants.Preferences.SHOW_HOT_FRIEND_GRAYTIPS_QZONE_LOVER_DOWN, context.getString(R.string.f171007bn1));
                                                break;
                                            case 67:
                                                string = defaultSharedPreferences.getString(AppConstants.Preferences.SHOW_HOT_FRIEND_GRAYTIPS_QZONE_LOVER_DIS, context.getString(R.string.f171008bn2));
                                                break;
                                            case 68:
                                                string = defaultSharedPreferences.getString(AppConstants.Preferences.SHOW_HOT_FRIEND_GRAYTIPS_QZONE_LOVER_UP2, context.getString(R.string.bn8));
                                                break;
                                            case 69:
                                                string = defaultSharedPreferences.getString(AppConstants.Preferences.SHOW_HOT_FRIEND_GRAYTIPS_QZONE_LOVER_CLOSE, context.getString(R.string.bmz));
                                                break;
                                            case 70:
                                                string = defaultSharedPreferences.getString(AppConstants.Preferences.SHOW_HOT_FRIEND_GRAYTIPS_QZONE_LOVER_CLOSE2, context.getString(R.string.f171006bn0));
                                                break;
                                            case 71:
                                                string = defaultSharedPreferences.getString(AppConstants.Preferences.SHOW_HOT_FRIEND_GRAYTIPS_QZONE_LOVER_OPEN, context.getString(R.string.f171009bn3));
                                                break;
                                            case 72:
                                                string = defaultSharedPreferences.getString(AppConstants.Preferences.SHOW_HOT_FRIEND_GRAYTIPS_QZONE_LOVER_OPEN2, context.getString(R.string.f171010bn4));
                                                break;
                                            case 73:
                                                string = defaultSharedPreferences.getString(AppConstants.Preferences.SHOW_HOT_FRIEND_GRAYTIPS_QZONE_LOVER_UPDATE, context.getString(R.string.bn5));
                                                break;
                                            case 74:
                                                string = defaultSharedPreferences.getString(AppConstants.Preferences.SHOW_HOT_FRIEND_GRAYTIPS_QZONE_LOVER_UPDATE2, context.getString(R.string.bn6));
                                                break;
                                            default:
                                                switch (i3) {
                                                    case 78:
                                                        string = defaultSharedPreferences.getString(AppConstants.Preferences.SHOW_NEW_BOAT_GRAYTIPS_CLOSE_UP, context.getString(R.string.bmm));
                                                        break;
                                                    case 79:
                                                        string = defaultSharedPreferences.getString(AppConstants.Preferences.SHOW_NEW_BOAT_GRAYTIPS_CLOSE_UP2, context.getString(R.string.bmn));
                                                        break;
                                                    case 80:
                                                        string = defaultSharedPreferences.getString(AppConstants.Preferences.SHOW_NEW_BOAT_GRAYTIPS_CLOSE_UP3, context.getString(R.string.bmo));
                                                        break;
                                                    case 81:
                                                        string = defaultSharedPreferences.getString(AppConstants.Preferences.SHOW_NEW_BOAT_GRAYTIPS_CLOSE_DOWN, context.getString(R.string.bmj));
                                                        break;
                                                    case 82:
                                                        string = defaultSharedPreferences.getString(AppConstants.Preferences.SHOW_NEW_BOAT_GRAYTIPS_CLOSE_DOWN2, context.getString(R.string.bmk));
                                                        break;
                                                    case 83:
                                                        string = defaultSharedPreferences.getString(AppConstants.Preferences.SHOW_NEW_BOAT_GRAYTIPS_CLOSE_DOWN3, context.getString(R.string.bml));
                                                        break;
                                                    case 84:
                                                        string = defaultSharedPreferences.getString(AppConstants.Preferences.SHOW_NEW_BOAT_GRAYTIPS_UPCOMING_UPGRADE, context.getString(R.string.blw));
                                                        break;
                                                    case 85:
                                                        string = defaultSharedPreferences.getString(AppConstants.Preferences.SHOW_NEW_BOAT_GRAYTIPS_UPCOMING_UPGRADE2, context.getString(R.string.blx));
                                                        break;
                                                    case 86:
                                                        string = defaultSharedPreferences.getString(AppConstants.Preferences.SHOW_NEW_BOAT_GRAYTIPS_UPCOMING_UPGRADE3, context.getString(R.string.bly));
                                                        break;
                                                    case 87:
                                                        string = defaultSharedPreferences.getString(AppConstants.Preferences.SHOW_NEW_BOAT_GRAYTIPS_UPCOMING_DOWNGRADE, context.getString(R.string.blu));
                                                        break;
                                                    case 88:
                                                        string = defaultSharedPreferences.getString(AppConstants.Preferences.SHOW_NEW_BOAT_GRAYTIPS_UPCOMING_DOWNGRADE2, context.getString(R.string.blv));
                                                        break;
                                                    case 89:
                                                        string = defaultSharedPreferences.getString(AppConstants.Preferences.SHOW_NEW_BOAT_SMALL_CLOSE_SETTING, context.getString(R.string.hhe));
                                                        break;
                                                    case 90:
                                                        string = defaultSharedPreferences.getString(AppConstants.Preferences.SHOW_NEW_BOAT_BIG_CLOSE_SETTING, context.getString(R.string.hhd));
                                                        break;
                                                    default:
                                                        switch (i3) {
                                                            case 99:
                                                                string = defaultSharedPreferences.getString(AppConstants.Preferences.SHOW_HOT_FRIENDSHIP_GRAYTIPS_1_WILL_DOWNGRADE, context.getString(R.string.bm5));
                                                                break;
                                                            case 100:
                                                                string = defaultSharedPreferences.getString(AppConstants.Preferences.SHOW_HOT_FRIENDSHIP_GRAYTIPS_1_DOWNGRADE, context.getString(R.string.f171004bm3));
                                                                break;
                                                            case 101:
                                                                string = defaultSharedPreferences.getString(AppConstants.Preferences.SHOW_HOT_FRIENDSHIP_GRAYTIPS_2_UPGRADE, context.getString(R.string.bm7));
                                                                break;
                                                            default:
                                                                switch (i3) {
                                                                    case 103:
                                                                        string = defaultSharedPreferences.getString(AppConstants.Preferences.SHOW_HOT_FRIENDSHIP_GRAYTIPS_2_WILL_DOWNGRADE, context.getString(R.string.bm8));
                                                                        break;
                                                                    case 104:
                                                                        string = defaultSharedPreferences.getString(AppConstants.Preferences.SHOW_HOT_FRIENDSHIP_GRAYTIPS_2_DOWNGRADE, context.getString(R.string.bm6));
                                                                        break;
                                                                    case 105:
                                                                        string = defaultSharedPreferences.getString(AppConstants.Preferences.SHOW_HOT_FRIENDSHIP_GRAYTIPS_3_UPGRADE, context.getString(R.string.bm_));
                                                                        break;
                                                                    case 106:
                                                                        string = defaultSharedPreferences.getString(AppConstants.Preferences.SHOW_HOT_FRIENDSHIP_GRAYTIPS_3_WILL_DOWNGRADE, context.getString(R.string.bma));
                                                                        break;
                                                                    case 107:
                                                                        string = defaultSharedPreferences.getString(AppConstants.Preferences.SHOW_HOT_FRIENDSHIP_GRAYTIPS_3_DOWNGRADE, context.getString(R.string.bm9));
                                                                        break;
                                                                    default:
                                                                        switch (i3) {
                                                                            case 150:
                                                                                string = defaultSharedPreferences.getString(AppConstants.Preferences.SHOW_HOT_INTIMATE_LOVER1UPGRADE, context.getString(R.string.iqo));
                                                                                break;
                                                                            case 151:
                                                                                string = defaultSharedPreferences.getString(AppConstants.Preferences.SHOW_HOT_INTIMATE_LOVER2UPGRADE, context.getString(R.string.iqq));
                                                                                break;
                                                                            case 152:
                                                                                string = defaultSharedPreferences.getString(AppConstants.Preferences.SHOW_HOT_INTIMATE_LOVER2DOWNGRADE, context.getString(R.string.iqp));
                                                                                break;
                                                                            case 153:
                                                                                string = defaultSharedPreferences.getString(AppConstants.Preferences.SHOW_HOT_INTIMATE_LOVER3DOWNGRADE, context.getString(R.string.iqr));
                                                                                break;
                                                                            case 154:
                                                                                string = defaultSharedPreferences.getString(AppConstants.Preferences.SHOW_HOT_INTIMATE_BUDDY1UPGRADE, context.getString(R.string.iqg));
                                                                                break;
                                                                            case 155:
                                                                                string = defaultSharedPreferences.getString(AppConstants.Preferences.SHOW_HOT_INTIMATE_BUDDY2UPGRADE, context.getString(R.string.iqi));
                                                                                break;
                                                                            case 156:
                                                                                string = defaultSharedPreferences.getString(AppConstants.Preferences.SHOW_HOT_INTIMATE_BUDDY2DOWNGRADE, context.getString(R.string.iqh));
                                                                                break;
                                                                            case 157:
                                                                                string = defaultSharedPreferences.getString(AppConstants.Preferences.SHOW_HOT_INTIMATE_BUDDY3DOWNGRADE, context.getString(R.string.iqj));
                                                                                break;
                                                                            case 158:
                                                                                string = defaultSharedPreferences.getString(AppConstants.Preferences.SHOW_HOT_INTIMATE_LADY_BRO1UPGRADE, context.getString(R.string.iqk));
                                                                                break;
                                                                            case 159:
                                                                                string = defaultSharedPreferences.getString(AppConstants.Preferences.SHOW_HOT_INTIMATE_LADY_BRO2UPGRADE, context.getString(R.string.iqm));
                                                                                break;
                                                                            case 160:
                                                                                string = defaultSharedPreferences.getString(AppConstants.Preferences.SHOW_HOT_INTIMATE_LADY_BRO2DOWNGRADE, context.getString(R.string.iql));
                                                                                break;
                                                                            case 161:
                                                                                string = defaultSharedPreferences.getString(AppConstants.Preferences.SHOW_HOT_INTIMATE_LADY_BRO3DOWNGRADE, context.getString(R.string.iqn));
                                                                                break;
                                                                            case 162:
                                                                                string = defaultSharedPreferences.getString(AppConstants.Preferences.SHOW_HOT_INTIMATE_BIND_TIP, context.getString(R.string.iqf));
                                                                                break;
                                                                            case 163:
                                                                                string = defaultSharedPreferences.getString(AppConstants.Preferences.SHOW_HOT_INTIMATE_UN_BIND1TIP, context.getString(R.string.iqs));
                                                                                break;
                                                                            case 164:
                                                                                string = defaultSharedPreferences.getString(AppConstants.Preferences.SHOW_HOT_INTIMATE_UN_BIND2TIP, context.getString(R.string.iqt));
                                                                                break;
                                                                            case 165:
                                                                                string = defaultSharedPreferences.getString(AppConstants.Preferences.SHOW_HOT_INTIMATE_UN_BIND3TIP, context.getString(R.string.iqu));
                                                                                break;
                                                                            case 166:
                                                                                string = defaultSharedPreferences.getString(AppConstants.Preferences.SHOW_HOT_INTIMATE_BECOME_GRAY_TIP, context.getString(R.string.iqd));
                                                                                break;
                                                                            case 167:
                                                                                string = defaultSharedPreferences.getString(AppConstants.Preferences.SHOW_HOT_INTIMATE_BECOME_LIGHT_TIP, context.getString(R.string.iqe));
                                                                                break;
                                                                            case 168:
                                                                                string = defaultSharedPreferences.getString(AppConstants.Preferences.SHOW_HOT_INTIMATE_BEST_FRIEND1UPGRADE, context.getString(R.string.f159121rg));
                                                                                break;
                                                                            case 169:
                                                                                string = defaultSharedPreferences.getString(AppConstants.Preferences.SHOW_HOT_INTIMATE_BEST_FRIEND2UPGRADE, context.getString(R.string.f159141ri));
                                                                                break;
                                                                            case 170:
                                                                                string = defaultSharedPreferences.getString(AppConstants.Preferences.SHOW_HOT_INTIMATE_BEST_FRIEND2DOWNGRADE, context.getString(R.string.f159131rh));
                                                                                break;
                                                                            case 171:
                                                                                string = defaultSharedPreferences.getString(AppConstants.Preferences.SHOW_HOT_INTIMATE_BEST_FRIEND3DOWNGRADE, context.getString(R.string.f159151rj));
                                                                                break;
                                                                            default:
                                                                                string = "";
                                                                                break;
                                                                        }
                                                                }
                                                        }
                                                }
                                        }
                                }
                        }
                }
            } else {
                string = defaultSharedPreferences.getString(AppConstants.Preferences.SHOW_HOT_FRIEND_REACTIVE_WILL_DOWNGRADE_PUSH_TIP, context.getString(R.string.bqx));
            }
        } else {
            string = defaultSharedPreferences.getString(AppConstants.Preferences.SHOW_HOT_FRIENDSHIP_GRAYTIPS_1_UPGRADE, context.getString(R.string.f171005bm4));
        }
        if (QLog.isColorLevel()) {
            QLog.d("HotFriend_GET_LOCAL_CONFIG", 2, "type=" + i3 + "getHotSmallChatConfig=" + string);
        }
        return string;
    }

    public static List<String> e(AppInterface appInterface, String str, String str2, FriendsManager friendsManager) {
        ArrayList arrayList = new ArrayList();
        if (str.contains("#likelevel1")) {
            str = str.replace("#likelevel1", "" + friendsManager.L);
        }
        if (str.contains("#likelevel2")) {
            str = str.replace("#likelevel2", "" + friendsManager.M);
        }
        if (str.contains("#chatlevel1")) {
            str = str.replace("#chatlevel1", "" + friendsManager.H);
        }
        if (str.contains("#chatlevel2")) {
            str = str.replace("#chatlevel2", "" + friendsManager.I);
        }
        if (str.contains("#oftenchat1")) {
            str = str.replace("#oftenchat1", "" + friendsManager.N);
        }
        if (str.contains("#oftenchat2")) {
            str = str.replace("#oftenchat2", "" + friendsManager.P);
        }
        if (str.contains("#loveroftenchat1")) {
            str = str.replace("#loveroftenchat1", "" + friendsManager.J);
        }
        if (str.contains("#loveroftenchat2")) {
            str = str.replace("#loveroftenchat2", "" + friendsManager.K);
        }
        if (str.contains("#qzonelevel1")) {
            str = str.replace("#qzonelevel1", "" + friendsManager.Q);
        }
        if (str.contains("#qzonelevel2")) {
            str = str.replace("#qzonelevel2", "" + friendsManager.R);
        }
        if (str.contains("#friendshipday1")) {
            str = str.replace("#friendshipday1", "" + friendsManager.T);
        }
        if (str.contains("#friendshipday2")) {
            str = str.replace("#friendshipday2", "" + friendsManager.U);
        }
        if (str.contains("#likename1")) {
            String f16 = com.tencent.mobileqq.mutualmark.b.f(appInterface, 6L, 1L);
            str = str.replace("#likename1", f16);
            arrayList.add(f16);
        }
        if (str.contains("#praisename1")) {
            String f17 = com.tencent.mobileqq.mutualmark.b.f(appInterface, 6L, 1L);
            str = str.replace("#praisename1", f17);
            arrayList.add(f17);
        }
        if (str.contains("#likename2")) {
            String f18 = com.tencent.mobileqq.mutualmark.b.f(appInterface, 6L, 2L);
            str = str.replace("#likename2", f18);
            arrayList.add(f18);
        }
        if (str.contains("#praisename2")) {
            String f19 = com.tencent.mobileqq.mutualmark.b.f(appInterface, 6L, 2L);
            str = str.replace("#praisename2", f19);
            arrayList.add(f19);
        }
        if (str.contains("#chatname1")) {
            String f26 = com.tencent.mobileqq.mutualmark.b.f(appInterface, 5L, 1L);
            str = str.replace("#chatname1", f26);
            arrayList.add(f26);
        }
        if (str.contains("#chatname2")) {
            String f27 = com.tencent.mobileqq.mutualmark.b.f(appInterface, 5L, 2L);
            str = str.replace("#chatname2", f27);
            arrayList.add(f27);
        }
        if (str.contains("#oftenchatname1")) {
            String f28 = com.tencent.mobileqq.mutualmark.b.f(appInterface, 12L, 1L);
            str = str.replace("#oftenchatname1", f28);
            arrayList.add(f28);
        }
        if (str.contains("#oftenchatname2")) {
            String f29 = com.tencent.mobileqq.mutualmark.b.f(appInterface, 12L, 2L);
            str = str.replace("#oftenchatname2", f29);
            arrayList.add(f29);
        }
        if (str.contains("#loverchatname1")) {
            String f36 = com.tencent.mobileqq.mutualmark.b.f(appInterface, 7L, 1L);
            str = str.replace("#loverchatname1", f36);
            arrayList.add(f36);
        }
        if (str.contains("#loverchatname2")) {
            String f37 = com.tencent.mobileqq.mutualmark.b.f(appInterface, 7L, 2L);
            str = str.replace("#loverchatname2", f37);
            arrayList.add(f37);
        }
        if (str.contains("#qzonename1")) {
            String f38 = com.tencent.mobileqq.mutualmark.b.f(appInterface, 8L, 1L);
            str = str.replace("#qzonename1", f38);
            arrayList.add(f38);
        }
        if (str.contains("#qzonename2")) {
            String f39 = com.tencent.mobileqq.mutualmark.b.f(appInterface, 8L, 2L);
            str = str.replace("#qzonename2", f39);
            arrayList.add(f39);
        }
        if (str.contains("#friendshipname1")) {
            String f46 = com.tencent.mobileqq.mutualmark.b.f(appInterface, 4L, 1L);
            str = str.replace("#friendshipname1", f46);
            arrayList.add(f46);
        }
        if (str.contains("#friendshipname2")) {
            String f47 = com.tencent.mobileqq.mutualmark.b.f(appInterface, 4L, 2L);
            str = str.replace("#friendshipname2", f47);
            arrayList.add(f47);
        }
        if (str.contains("#friendshipname3")) {
            String f48 = com.tencent.mobileqq.mutualmark.b.f(appInterface, 4L, 3L);
            str = str.replace("#friendshipname3", f48);
            arrayList.add(f48);
        }
        if (str.contains("#lovername1")) {
            String f49 = com.tencent.mobileqq.mutualmark.b.f(appInterface, 1L, 0L);
            str = str.replace("#lovername1", f49);
            arrayList.add(f49);
        }
        if (str.contains("#lovername2")) {
            String f56 = com.tencent.mobileqq.mutualmark.b.f(appInterface, 1L, 1L);
            str = str.replace("#lovername2", f56);
            arrayList.add(f56);
        }
        if (str.contains("#lovername3")) {
            String f57 = com.tencent.mobileqq.mutualmark.b.f(appInterface, 1L, 2L);
            str = str.replace("#lovername3", f57);
            arrayList.add(f57);
        }
        if (str.contains("#sistername1")) {
            String f58 = com.tencent.mobileqq.mutualmark.b.f(appInterface, 2L, 0L);
            str = str.replace("#sistername1", f58);
            arrayList.add(f58);
        }
        if (str.contains("#sistername2")) {
            String f59 = com.tencent.mobileqq.mutualmark.b.f(appInterface, 2L, 1L);
            str = str.replace("#sistername2", f59);
            arrayList.add(f59);
        }
        if (str.contains("#sistername3")) {
            String f65 = com.tencent.mobileqq.mutualmark.b.f(appInterface, 2L, 2L);
            str = str.replace("#sistername3", f65);
            arrayList.add(f65);
        }
        if (str.contains("#brothername1")) {
            String f66 = com.tencent.mobileqq.mutualmark.b.f(appInterface, 3L, 0L);
            str = str.replace("#brothername1", f66);
            arrayList.add(f66);
        }
        if (str.contains("#brothername2")) {
            String f67 = com.tencent.mobileqq.mutualmark.b.f(appInterface, 3L, 1L);
            str = str.replace("#brothername2", f67);
            arrayList.add(f67);
        }
        if (str.contains("#brothername3")) {
            String f68 = com.tencent.mobileqq.mutualmark.b.f(appInterface, 3L, 2L);
            str = str.replace("#brothername3", f68);
            arrayList.add(f68);
        }
        arrayList.add(0, str.replace(HardCodeUtil.qqStr(R.string.f172096nb0), str2));
        return arrayList;
    }

    public static List<C8130a> f(Context context, String str) {
        int indexOf;
        int indexOf2;
        ArrayList arrayList = new ArrayList();
        int i3 = 0;
        int i16 = 0;
        while (i3 >= 0) {
            i3 = str.indexOf("(", i16);
            if (i3 < 0 || (indexOf = str.indexOf(")[", i3)) < 0 || (indexOf2 = str.indexOf("]", indexOf)) < 0) {
                break;
            }
            C8130a c8130a = new C8130a();
            c8130a.f252249a = str.substring(i3 + 1, indexOf);
            c8130a.f252251c = i3;
            c8130a.f252250b = str.substring(indexOf + 2, indexOf2);
            str = str.replace(str.substring(i3, indexOf2 + 1), c8130a.f252249a);
            i16 = c8130a.f252249a.length() + indexOf2;
            arrayList.add(c8130a);
        }
        C8130a c8130a2 = new C8130a();
        c8130a2.f252249a = str;
        arrayList.add(0, c8130a2);
        return arrayList;
    }

    public static HashSet<com.tencent.qqnt.ntrelation.intimateinfo.bean.a> g() {
        return f252248j;
    }

    public static int h() {
        long serverTimeMillis = NetConnInfoCenter.getServerTimeMillis();
        int k3 = en.k(serverTimeMillis);
        int x16 = 60 - en.x(serverTimeMillis);
        int i3 = (((23 - k3) * 60) + x16) * 60;
        int i16 = (((17 - k3) * 60) + x16) * 60;
        if (QLog.isColorLevel()) {
            QLog.d("FriendReactive", 2, "contact resume  offlast=" + i3 + "off18last=" + i16);
        }
        if (k3 < 18) {
            return i16;
        }
        return i3;
    }

    public static void i(SharedPreferences sharedPreferences, FriendsManager friendsManager) {
        int i3 = sharedPreferences.getInt(AppConstants.Preferences.SHOW_HOT_INTIMATE_MIN_DAYS, friendsManager.V);
        if (i3 > 0) {
            friendsManager.V = i3;
        }
        int i16 = sharedPreferences.getInt(AppConstants.Preferences.SHOW_HOT_INTIMATE_MAX_DAYS, friendsManager.W);
        if (i16 > 0) {
            friendsManager.W = i16;
        }
        int i17 = sharedPreferences.getInt(AppConstants.Preferences.SHOW_HOT_INTIMATE_DAY_MSG_COUNT, friendsManager.X);
        if (i17 > 0) {
            friendsManager.X = i17;
        }
    }

    public static void j(QQAppInterface qQAppInterface, String str) {
        if (QLog.isColorLevel()) {
            QLog.i(f252239a, 2, "parsNewBoatConfig:" + str);
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            boolean z16 = true;
            int optInt = jSONObject.optInt("useBoat", 1);
            String optString = jSONObject.optString("boatSSetting", "");
            String optString2 = jSONObject.optString("boatBSetting", "");
            String optString3 = jSONObject.optString("boatSName", "");
            String optString4 = jSONObject.optString("boatBName", "");
            BaseApplication app = qQAppInterface.getApp();
            if (optInt != 1) {
                z16 = false;
            }
            q(app, z16, optString, optString2, optString3, optString4);
            p(qQAppInterface.getApp(), jSONObject.optString("grayBoatUp", ""), jSONObject.optString("grayBoat2Up", ""), jSONObject.optString("grayBoat3Up", ""), jSONObject.optString("grayBoatDeg", ""), jSONObject.optString("grayBoat2Deg", ""), jSONObject.optString("grayBoat3Deg", ""), jSONObject.optString("grayComingUp", ""), jSONObject.optString("grayComing2Up", ""), jSONObject.optString("grayComing3Up", ""), jSONObject.optString("grayComingDeg", ""), jSONObject.optString("grayComing2Deg", ""));
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.i(f252239a, 2, "parsNewBoatConfig:error->" + e16.toString());
            }
        }
    }

    public static void k(QQAppInterface qQAppInterface, String str, int i3) {
        String str2;
        String str3;
        String str4;
        boolean z16;
        boolean z17;
        int i16;
        String str5;
        int i17;
        int i18;
        Object obj;
        int i19;
        HashMap hashMap;
        int i26;
        Object obj2;
        boolean z18;
        boolean z19;
        int i27;
        String str6 = "|";
        if (QLog.isColorLevel()) {
            QLog.d(f252239a, 2, "parsXMLConfig: {\n" + str + "\n}");
        }
        XmlPullParser newPullParser = Xml.newPullParser();
        try {
            new HashMap();
            HashMap hashMap2 = new HashMap();
            HashMap hashMap3 = new HashMap();
            newPullParser.setInput(new ByteArrayInputStream(str.getBytes()), "UTF-8");
            int eventType = newPullParser.getEventType();
            String str7 = "";
            String str8 = "";
            String str9 = str8;
            String str10 = str9;
            String str11 = str10;
            String str12 = str11;
            String str13 = str12;
            String str14 = str13;
            String str15 = str14;
            String str16 = str15;
            String str17 = str16;
            String str18 = str17;
            String str19 = str18;
            String str20 = str19;
            String str21 = str20;
            String str22 = str21;
            String str23 = str22;
            String str24 = str23;
            String str25 = str24;
            String str26 = str25;
            String str27 = str26;
            String str28 = str27;
            String str29 = str28;
            String str30 = str29;
            String str31 = str30;
            String str32 = str31;
            String str33 = str32;
            String str34 = str33;
            String str35 = str34;
            String str36 = str35;
            String str37 = str36;
            String str38 = str37;
            String str39 = str38;
            String str40 = str39;
            String str41 = str40;
            String str42 = str41;
            int i28 = 6;
            boolean z26 = false;
            int i29 = 3;
            int i36 = 30;
            boolean z27 = false;
            int i37 = 7;
            int i38 = 30;
            int i39 = 3;
            int i46 = 30;
            int i47 = 3;
            int i48 = 30;
            int i49 = 3;
            int i56 = 30;
            int i57 = 7;
            int i58 = 30;
            int i59 = 5;
            int i65 = 7;
            int i66 = 30;
            int i67 = 0;
            String str43 = str42;
            while (true) {
                str2 = str8;
                str3 = str43;
                str4 = str7;
                z16 = z27;
                z17 = z26;
                i16 = i36;
                str5 = str6;
                i17 = i29;
                if (eventType == 1) {
                    break;
                }
                if (eventType == 2) {
                    String name = newPullParser.getName();
                    if (name.equalsIgnoreCase("ShowInContact")) {
                        if (Integer.valueOf(newPullParser.nextText()).intValue() == 1) {
                            z26 = true;
                            z27 = z16;
                            i29 = i17;
                            i36 = i16;
                            str8 = str2;
                            str43 = str3;
                            str7 = str4;
                            eventType = newPullParser.next();
                            str6 = str5;
                        }
                    } else if (name.equalsIgnoreCase("ShowInChat")) {
                        z27 = Integer.valueOf(newPullParser.nextText()).intValue() == 1 ? true : z16;
                        z26 = z17;
                        i29 = i17;
                        i36 = i16;
                        str8 = str2;
                        str43 = str3;
                        str7 = str4;
                        eventType = newPullParser.next();
                        str6 = str5;
                    } else {
                        if (name.equalsIgnoreCase("minInteractiveDays")) {
                            i29 = Integer.valueOf(newPullParser.nextText()).intValue();
                            z26 = z17;
                            z27 = z16;
                            i36 = i16;
                            str8 = str2;
                            str43 = str3;
                            str7 = str4;
                            if (i29 <= 0) {
                                i29 = 3;
                            }
                        } else if (name.equalsIgnoreCase("maxInteractiveDays")) {
                            i36 = Integer.valueOf(newPullParser.nextText()).intValue();
                            z26 = z17;
                            z27 = z16;
                            i29 = i17;
                            str8 = str2;
                            str43 = str3;
                            str7 = str4;
                            if (i36 <= 0) {
                                i36 = 30;
                            }
                        } else {
                            if (name.equalsIgnoreCase("minLoverInteractiveDays")) {
                                i65 = Integer.valueOf(newPullParser.nextText()).intValue();
                                if (i65 <= 0) {
                                    z26 = z17;
                                    z27 = z16;
                                    i29 = i17;
                                    i36 = i16;
                                    str8 = str2;
                                    str43 = str3;
                                    str7 = str4;
                                    i65 = 3;
                                }
                            } else if (name.equalsIgnoreCase("maxLoverInteractiveDays")) {
                                i66 = Integer.valueOf(newPullParser.nextText()).intValue();
                                if (i66 <= 0) {
                                    z26 = z17;
                                    z27 = z16;
                                    i29 = i17;
                                    i36 = i16;
                                    str8 = str2;
                                    str43 = str3;
                                    str7 = str4;
                                    i66 = 30;
                                }
                            } else if (name.equalsIgnoreCase("minLinkDays")) {
                                i39 = Integer.valueOf(newPullParser.nextText()).intValue();
                                if (i39 <= 0) {
                                    z26 = z17;
                                    z27 = z16;
                                    i29 = i17;
                                    i36 = i16;
                                    str8 = str2;
                                    str43 = str3;
                                    str7 = str4;
                                    i39 = 3;
                                }
                            } else if (name.equalsIgnoreCase("maxLinkDays")) {
                                i46 = Integer.valueOf(newPullParser.nextText()).intValue();
                                if (i46 <= 0) {
                                    z26 = z17;
                                    z27 = z16;
                                    i29 = i17;
                                    i36 = i16;
                                    str8 = str2;
                                    str43 = str3;
                                    str7 = str4;
                                    i46 = 30;
                                }
                            } else if (name.equalsIgnoreCase("minIntimacyDays")) {
                                i47 = Integer.valueOf(newPullParser.nextText()).intValue();
                                if (i47 <= 0) {
                                    z26 = z17;
                                    z27 = z16;
                                    i29 = i17;
                                    i36 = i16;
                                    str8 = str2;
                                    str43 = str3;
                                    str7 = str4;
                                    i47 = 3;
                                }
                            } else if (name.equalsIgnoreCase("maxIntimacyDays")) {
                                i48 = Integer.valueOf(newPullParser.nextText()).intValue();
                                if (i48 <= 0) {
                                    z26 = z17;
                                    z27 = z16;
                                    i29 = i17;
                                    i36 = i16;
                                    str8 = str2;
                                    str43 = str3;
                                    str7 = str4;
                                    i48 = 30;
                                }
                            } else if (name.equalsIgnoreCase("minQzoneVisitDays")) {
                                i49 = Integer.valueOf(newPullParser.nextText()).intValue();
                                if (i49 <= 0) {
                                    z26 = z17;
                                    z27 = z16;
                                    i29 = i17;
                                    i36 = i16;
                                    str8 = str2;
                                    str43 = str3;
                                    str7 = str4;
                                    i49 = 3;
                                }
                            } else if (name.equalsIgnoreCase("maxQzoneVisitDays")) {
                                i56 = Integer.valueOf(newPullParser.nextText()).intValue();
                                if (i56 <= 0) {
                                    z26 = z17;
                                    z27 = z16;
                                    i29 = i17;
                                    i36 = i16;
                                    str8 = str2;
                                    str43 = str3;
                                    str7 = str4;
                                    i56 = 30;
                                }
                            } else if (name.equalsIgnoreCase("maxRemindTimes")) {
                                i59 = Integer.valueOf(newPullParser.nextText()).intValue();
                                if (i59 <= 0) {
                                    z26 = z17;
                                    z27 = z16;
                                    i29 = i17;
                                    i36 = i16;
                                    str8 = str2;
                                    str43 = str3;
                                    str7 = str4;
                                    i59 = 5;
                                }
                            } else if (name.equalsIgnoreCase("fireNumDescription")) {
                                str7 = newPullParser.nextText();
                                z26 = z17;
                                z27 = z16;
                                i29 = i17;
                                i36 = i16;
                                str8 = str2;
                                str43 = str3;
                            } else if (name.equalsIgnoreCase("grayPraiseUpgrade")) {
                                hashMap2.put("grayPraiseUp", newPullParser.nextText());
                            } else if (name.equalsIgnoreCase("grayChatUpgrade")) {
                                hashMap2.put("grayChatUp", newPullParser.nextText());
                            } else if (name.equalsIgnoreCase("grayColseUpgrade")) {
                                hashMap2.put("grayCloseUp", newPullParser.nextText());
                            } else if (name.equalsIgnoreCase("grayLoverUpgrade")) {
                                hashMap2.put("grayQzoneLoverUp", newPullParser.nextText());
                            } else if (name.equalsIgnoreCase("grayQzoneVisitUpgrade")) {
                                hashMap2.put("grayQzoneVisitUp", newPullParser.nextText());
                            } else if (name.equalsIgnoreCase("grayPraise2Upgrade")) {
                                hashMap2.put("grayPraiseUp2", newPullParser.nextText());
                            } else if (name.equalsIgnoreCase("grayChat2Upgrade")) {
                                hashMap2.put("grayChatUp2", newPullParser.nextText());
                            } else if (name.equalsIgnoreCase("grayColse2Upgrade")) {
                                hashMap2.put("grayCloseUp2", newPullParser.nextText());
                            } else if (name.equalsIgnoreCase("grayLover2Upgrade")) {
                                hashMap2.put("grayQzoneLoverUp2", newPullParser.nextText());
                            } else if (name.equalsIgnoreCase("grayQzoneVisit2Upgrade")) {
                                hashMap2.put("grayQzoneVisitUp2", newPullParser.nextText());
                            } else if (name.equalsIgnoreCase("grayPraiseDegrade")) {
                                hashMap2.put("grayPriaseDown", newPullParser.nextText());
                            } else if (name.equalsIgnoreCase("grayChatDegrade")) {
                                hashMap2.put("grayChatDown", newPullParser.nextText());
                            } else if (name.equalsIgnoreCase("grayColseDegrade")) {
                                hashMap2.put("grayCloseDown", newPullParser.nextText());
                            } else if (name.equalsIgnoreCase("grayLoverDegrade")) {
                                hashMap2.put("grayQzoneLoverDown", newPullParser.nextText());
                            } else if (name.equalsIgnoreCase("grayLoverOpen")) {
                                hashMap2.put("grayQzoneLoverOpen", newPullParser.nextText());
                            } else if (name.equalsIgnoreCase("grayLoverOpen2")) {
                                hashMap2.put("grayQzoneLoverOpen2", newPullParser.nextText());
                            } else if (name.equalsIgnoreCase("grayLoverUpdate")) {
                                hashMap2.put("grayQzoneLoverUpdate", newPullParser.nextText());
                            } else if (name.equalsIgnoreCase("grayLoverUpdate2")) {
                                hashMap2.put("grayQzoneLoverUpdate2", newPullParser.nextText());
                            } else if (name.equalsIgnoreCase("grayLoverClose")) {
                                hashMap2.put("grayQzoneLoverClose", newPullParser.nextText());
                            } else if (name.equalsIgnoreCase("grayLoverClose2")) {
                                hashMap2.put("grayQzoneLoverClose2", newPullParser.nextText());
                            } else if (name.equalsIgnoreCase("grayQzoneVisitDegrade")) {
                                hashMap2.put("grayQzoneVisitDown", newPullParser.nextText());
                            } else if (name.equalsIgnoreCase("grayPraiseDis")) {
                                hashMap2.put("grayPriaseDis", newPullParser.nextText());
                            } else if (name.equalsIgnoreCase("grayChatDis")) {
                                hashMap2.put("grayChatDis", newPullParser.nextText());
                            } else if (name.equalsIgnoreCase("grayColseDis")) {
                                hashMap2.put("grayCloseDis", newPullParser.nextText());
                            } else if (name.equalsIgnoreCase("grayLoverDis")) {
                                hashMap2.put("grayQzoneLoverDis", newPullParser.nextText());
                            } else if (name.equalsIgnoreCase("grayQzoneVisitDis")) {
                                hashMap2.put("grayQzoneVisitDis", newPullParser.nextText());
                            } else if (name.equalsIgnoreCase("grayPraiseDegradeRemind")) {
                                str29 = newPullParser.nextText();
                            } else if (name.equalsIgnoreCase("grayPraiseDisRemind")) {
                                str30 = newPullParser.nextText();
                            } else if (name.equalsIgnoreCase("grayChatDegradeRemind")) {
                                str31 = newPullParser.nextText();
                            } else if (name.equalsIgnoreCase("grayChatDisRemind")) {
                                str32 = newPullParser.nextText();
                            } else if (name.equalsIgnoreCase("grayQzoneDegradeRemind")) {
                                str33 = newPullParser.nextText();
                            } else if (name.equalsIgnoreCase("grayQzoneDisRemind")) {
                                str34 = newPullParser.nextText();
                            } else if (name.equalsIgnoreCase("grayChatAndPraiseRemind")) {
                                str35 = newPullParser.nextText();
                            } else if (name.equalsIgnoreCase("grayChatAnQzoneRemind")) {
                                str36 = newPullParser.nextText();
                            } else if (name.equalsIgnoreCase("grayPraiseAndQzoneRemind")) {
                                str37 = newPullParser.nextText();
                            } else if (name.equalsIgnoreCase("grayPCQallRemind")) {
                                str38 = newPullParser.nextText();
                            } else if (name.equalsIgnoreCase("graytipFriendship1Upgrade")) {
                                hashMap2.put("graytipFriendship1Upgrade", newPullParser.nextText());
                            } else if (name.equalsIgnoreCase("graytipFriendship1WillDowngrade")) {
                                str39 = newPullParser.nextText();
                            } else if (name.equalsIgnoreCase("graytipFriendship1Downgrade")) {
                                hashMap2.put("graytipFriendship1Downgrade", newPullParser.nextText());
                            } else if (name.equalsIgnoreCase("graytipFriendship2Upgrade")) {
                                hashMap2.put("graytipFriendship2Upgrade", newPullParser.nextText());
                            } else if (name.equalsIgnoreCase("graytipFriendship2WillDowngrade")) {
                                str40 = newPullParser.nextText();
                            } else if (name.equalsIgnoreCase("graytipFriendship2Downgrade")) {
                                hashMap2.put("graytipFriendship2Downgrade", newPullParser.nextText());
                            } else if (name.equalsIgnoreCase("graytipFriendship3Upgrade")) {
                                hashMap2.put("graytipFriendship3Upgrade", newPullParser.nextText());
                            } else if (name.equalsIgnoreCase("graytipFriendship3WillDowngrade")) {
                                str41 = newPullParser.nextText();
                            } else if (name.equalsIgnoreCase("graytipFriendship3Downgrade")) {
                                hashMap2.put("graytipFriendship3Downgrade", newPullParser.nextText());
                            } else if (name.equalsIgnoreCase("friendshipMinDays")) {
                                int parseInt = Integer.parseInt(newPullParser.nextText());
                                if (parseInt > 0) {
                                    i57 = parseInt;
                                }
                            } else if (name.equalsIgnoreCase("friendshipMaxDays")) {
                                int parseInt2 = Integer.parseInt(newPullParser.nextText());
                                if (parseInt2 > 0) {
                                    i58 = parseInt2;
                                }
                            } else if (name.equalsIgnoreCase("friendship")) {
                                i67 = Integer.parseInt(newPullParser.nextText());
                            } else if (name.equalsIgnoreCase("intimateMinDays")) {
                                int parseInt3 = Integer.parseInt(newPullParser.nextText());
                                if (parseInt3 > 0) {
                                    i37 = parseInt3;
                                }
                            } else if (name.equalsIgnoreCase("intimateMaxDays")) {
                                int parseInt4 = Integer.parseInt(newPullParser.nextText());
                                if (parseInt4 > 0) {
                                    i38 = parseInt4;
                                }
                            } else if (name.equalsIgnoreCase("intimateDayMsgCount")) {
                                int parseInt5 = Integer.parseInt(newPullParser.nextText());
                                if (parseInt5 > 0) {
                                    i28 = parseInt5;
                                }
                            } else if (name.equalsIgnoreCase("graytipLover1Upgrade")) {
                                hashMap3.put("graytipLover1Upgrade", newPullParser.nextText());
                            } else if (name.equalsIgnoreCase("graytipLover2Upgrade")) {
                                hashMap3.put("graytipLover2Upgrade", newPullParser.nextText());
                            } else if (name.equalsIgnoreCase("graytipLover2Downgrade")) {
                                hashMap3.put("graytipLover2Downgrade", newPullParser.nextText());
                            } else if (name.equalsIgnoreCase("graytipLover3Downgrade")) {
                                hashMap3.put("graytipLover3Downgrade", newPullParser.nextText());
                            } else if (name.equalsIgnoreCase("graytipBuddy1Upgrade")) {
                                hashMap3.put("graytipBuddy1Upgrade", newPullParser.nextText());
                            } else if (name.equalsIgnoreCase("graytipBuddy2Upgrade")) {
                                hashMap3.put("graytipBuddy2Upgrade", newPullParser.nextText());
                            } else if (name.equalsIgnoreCase("graytipBuddy2Downgrade")) {
                                hashMap3.put("graytipBuddy2Downgrade", newPullParser.nextText());
                            } else if (name.equalsIgnoreCase("graytipBuddy3Downgrade")) {
                                hashMap3.put("graytipBuddy3Downgrade", newPullParser.nextText());
                            } else if (name.equalsIgnoreCase("graytipLadyBro1Upgrade")) {
                                hashMap3.put("graytipLadyBro1Upgrade", newPullParser.nextText());
                            } else if (name.equalsIgnoreCase("graytipLadyBro2Upgrade")) {
                                hashMap3.put("graytipLadyBro2Upgrade", newPullParser.nextText());
                            } else if (name.equalsIgnoreCase("graytipLadyBro2Downgrade")) {
                                hashMap3.put("graytipLadyBro2Downgrade", newPullParser.nextText());
                            } else if (name.equalsIgnoreCase("graytipLadyBro3Downgrade")) {
                                hashMap3.put("graytipLadyBro3Downgrade", newPullParser.nextText());
                            } else if (name.equalsIgnoreCase("graytipBestFriend1Upgrade")) {
                                hashMap3.put("graytipBestFriend1Upgrade", newPullParser.nextText());
                            } else if (name.equalsIgnoreCase("graytipBestFriend2Upgrade")) {
                                hashMap3.put("graytipBestFriend2Upgrade", newPullParser.nextText());
                            } else if (name.equalsIgnoreCase("graytipBestFriend2Downgrade")) {
                                hashMap3.put("graytipBestFriend2Downgrade", newPullParser.nextText());
                            } else if (name.equalsIgnoreCase("graytipBestFriend3Downgrade")) {
                                hashMap3.put("graytipBestFriend3Downgrade", newPullParser.nextText());
                            } else if (name.equalsIgnoreCase("graytipIntimateshipBindTip")) {
                                hashMap3.put("graytipIntimateshipBindTip", newPullParser.nextText());
                            } else if (name.equalsIgnoreCase("graytipIntimateshipUnBind1Tip")) {
                                hashMap3.put("graytipIntimateshipUnBind1Tip", newPullParser.nextText());
                            } else if (name.equalsIgnoreCase("graytipIntimateshipUnBind2Tip")) {
                                hashMap3.put("graytipIntimateshipUnBind2Tip", newPullParser.nextText());
                            } else if (name.equalsIgnoreCase("graytipIntimateshipUnBind3Tip")) {
                                hashMap3.put("graytipIntimateshipUnBind3Tip", newPullParser.nextText());
                            } else if (name.equalsIgnoreCase("graytipIntimateshipBecomeGrayTip")) {
                                hashMap3.put("graytipIntimateshipBecomeGrayTip", newPullParser.nextText());
                            } else if (name.equalsIgnoreCase("graytipIntimateshipBecomeLightTip")) {
                                hashMap3.put("graytipIntimateshipBecomeLightTip", newPullParser.nextText());
                            } else if (name.equalsIgnoreCase("graytipWillDowngradeWording")) {
                                str8 = newPullParser.nextText();
                                z26 = z17;
                                z27 = z16;
                                i29 = i17;
                                i36 = i16;
                                str43 = str3;
                                str7 = str4;
                            } else if (name.equalsIgnoreCase("smallChatSVipKey")) {
                                str43 = newPullParser.nextText();
                                z26 = z17;
                                z27 = z16;
                                i29 = i17;
                                i36 = i16;
                                str8 = str2;
                                str7 = str4;
                            } else if (name.equalsIgnoreCase("smallChatUnionVipKey")) {
                                str9 = newPullParser.nextText();
                            } else if (name.equalsIgnoreCase("bigChatSVipKey")) {
                                str10 = newPullParser.nextText();
                            } else if (name.equalsIgnoreCase("bigChatUnionVipKey")) {
                                str11 = newPullParser.nextText();
                            } else if (name.equalsIgnoreCase("smallCloseSvipKey")) {
                                str12 = newPullParser.nextText();
                            } else if (name.equalsIgnoreCase("smallCloseUnionVipKey")) {
                                str13 = newPullParser.nextText();
                            } else if (name.equalsIgnoreCase("bigCloseSVipKey")) {
                                str14 = newPullParser.nextText();
                            } else if (name.equalsIgnoreCase("bigCloseUnionVipKey")) {
                                str15 = newPullParser.nextText();
                            } else if (name.equalsIgnoreCase("intimateLover1VipKey")) {
                                str24 = newPullParser.nextText();
                            } else if (name.equalsIgnoreCase("intimateLover2VipKey")) {
                                str25 = newPullParser.nextText();
                            } else if (name.equalsIgnoreCase("intimateLover3VipKey")) {
                                str26 = newPullParser.nextText();
                            } else if (name.equalsIgnoreCase("intimateLover1VipSetting")) {
                                str27 = newPullParser.nextText();
                            } else if (name.equalsIgnoreCase("intimateLover2VipSetting")) {
                                str28 = newPullParser.nextText();
                            } else if (name.equalsIgnoreCase("intimateLover3VipSetting")) {
                                str42 = newPullParser.nextText();
                            } else if (name.equalsIgnoreCase("smallChatSVipSetting")) {
                                str16 = newPullParser.nextText();
                            } else if (name.equalsIgnoreCase("smallChatUnionVipSetting")) {
                                str17 = newPullParser.nextText();
                            } else if (name.equalsIgnoreCase("bigChatSVipSetting")) {
                                str18 = newPullParser.nextText();
                            } else if (name.equalsIgnoreCase("bigChatUnionVipSetting")) {
                                str19 = newPullParser.nextText();
                            } else if (name.equalsIgnoreCase("smallCloseSVipSetting")) {
                                str20 = newPullParser.nextText();
                            } else if (name.equalsIgnoreCase("smallCloseUnionSetting")) {
                                str21 = newPullParser.nextText();
                            } else if (name.equalsIgnoreCase("bigCloseSVipSetting")) {
                                str22 = newPullParser.nextText();
                            } else if (name.equalsIgnoreCase("bigCloseUnionSetting")) {
                                str23 = newPullParser.nextText();
                            }
                            z27 = z16;
                            i29 = i17;
                            i36 = i16;
                            str8 = str2;
                            str43 = str3;
                            str7 = str4;
                        }
                        eventType = newPullParser.next();
                        str6 = str5;
                    }
                }
                z26 = z17;
                z27 = z16;
                i29 = i17;
                i36 = i16;
                str8 = str2;
                str43 = str3;
                str7 = str4;
                eventType = newPullParser.next();
                str6 = str5;
            }
            StringBuilder sb5 = new StringBuilder();
            sb5.append(i17);
            sb5.append(str5);
            sb5.append(i16);
            sb5.append(str5);
            int i68 = i39;
            sb5.append(i68);
            sb5.append(str5);
            int i69 = i46;
            sb5.append(i69);
            sb5.append(str5);
            int i75 = i47;
            sb5.append(i75);
            sb5.append(str5);
            int i76 = i48;
            sb5.append(i76);
            sb5.append(str5);
            int i77 = i49;
            sb5.append(i77);
            sb5.append(str5);
            int i78 = i56;
            sb5.append(i78);
            sb5.append(str5);
            int i79 = i59;
            sb5.append(i79);
            sb5.append(str5);
            sb5.append(i65);
            sb5.append(str5);
            sb5.append(i66);
            sb5.append(str5);
            int i85 = i57;
            sb5.append(i85);
            sb5.append(str5);
            int i86 = i58;
            sb5.append(i86);
            String sb6 = sb5.toString();
            if (QLog.isColorLevel()) {
                obj = "grayChatDis";
                String str44 = f252239a;
                hashMap = hashMap2;
                StringBuilder sb7 = new StringBuilder();
                i19 = i86;
                sb7.append("handleRespGetHotDaysConfig success\uff1ashowInContact|ShowInChat|settingdays=");
                z18 = z17;
                sb7.append(z18);
                sb7.append(str5);
                i26 = i85;
                z19 = z16;
                sb7.append(z19);
                sb7.append(str5);
                sb7.append(sb6);
                sb7.append("version=");
                i18 = i3;
                obj2 = "graytipFriendship3Downgrade";
                sb7.append(i18);
                i27 = i78;
                sb7.append("maxRemindTimes=");
                sb7.append(i79);
                QLog.d(str44, 2, sb7.toString());
            } else {
                i18 = i3;
                obj = "grayChatDis";
                i19 = i86;
                hashMap = hashMap2;
                i26 = i85;
                obj2 = "graytipFriendship3Downgrade";
                z18 = z17;
                z19 = z16;
                i27 = i78;
            }
            ea.X3(qQAppInterface.getApp(), i18, qQAppInterface.getCurrentAccountUin());
            ea.W4(qQAppInterface.getApp(), qQAppInterface.getCurrentAccountUin(), z18, z19, sb6);
            ea.Z4(qQAppInterface.getApp(), qQAppInterface.getCurrentUin(), i67);
            FriendsManager friendsManager = (FriendsManager) qQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
            friendsManager.F0(z18, z19, i17, i16, i68, i69, i75, i76, i77, i27, i26, i19, i79);
            s(qQAppInterface.getApp(), str3, str9, str10, str11, str12, str13, str14, str15, str16, str17, str18, str19, str20, str21, str22, str23, str24, str25, str26, str27, str28, str42);
            l(qQAppInterface.getApp(), str4);
            HashMap hashMap4 = hashMap;
            m(qQAppInterface.getApp(), (String) hashMap4.get("grayChatUp"), (String) hashMap4.get("grayPraiseUp"), (String) hashMap4.get("grayCloseUp"), (String) hashMap4.get("grayQzoneLoverUp"), (String) hashMap4.get("grayQzoneVisitUp"), (String) hashMap4.get("grayChatUp2"), (String) hashMap4.get("grayPraiseUp2"), (String) hashMap4.get("grayCloseUp2"), (String) hashMap4.get("grayQzoneLoverUp2"), (String) hashMap4.get("grayQzoneVisitUp2"), (String) hashMap4.get("grayChatDown"), (String) hashMap4.get("grayPriaseDown"), (String) hashMap4.get("grayCloseDown"), (String) hashMap4.get("grayQzoneLoverDown"), (String) hashMap4.get("grayQzoneVisitDown"), (String) hashMap4.get(obj), (String) hashMap4.get("grayPriaseDis"), (String) hashMap4.get("grayCloseDis"), (String) hashMap4.get("grayQzoneLoverDis"), (String) hashMap4.get("grayQzoneVisitDis"), (String) hashMap4.get("grayQzoneLoverClose"), (String) hashMap4.get("grayQzoneLoverClose2"), (String) hashMap4.get("grayQzoneLoverOpen"), (String) hashMap4.get("grayQzoneLoverOpen2"), (String) hashMap4.get("grayQzoneLoverUpdate"), (String) hashMap4.get("grayQzoneLoverUpdate2"), (String) hashMap4.get("graytipFriendship1Upgrade"), (String) hashMap4.get("graytipFriendship1Downgrade"), (String) hashMap4.get("graytipFriendship2Upgrade"), (String) hashMap4.get("graytipFriendship2Downgrade"), (String) hashMap4.get("graytipFriendship3Upgrade"), (String) hashMap4.get(obj2));
            n(qQAppInterface.getApp(), str29, str30, str31, str32, str33, str34, str35, str36, str37, str38, str39, str40, str41);
            o(qQAppInterface.getApp(), friendsManager, i37, i38, i28, new String[]{AppConstants.Preferences.SHOW_HOT_INTIMATE_LOVER1UPGRADE, AppConstants.Preferences.SHOW_HOT_INTIMATE_LOVER2UPGRADE, AppConstants.Preferences.SHOW_HOT_INTIMATE_LOVER2DOWNGRADE, AppConstants.Preferences.SHOW_HOT_INTIMATE_LOVER3DOWNGRADE, AppConstants.Preferences.SHOW_HOT_INTIMATE_BUDDY1UPGRADE, AppConstants.Preferences.SHOW_HOT_INTIMATE_BUDDY2UPGRADE, AppConstants.Preferences.SHOW_HOT_INTIMATE_BUDDY2DOWNGRADE, AppConstants.Preferences.SHOW_HOT_INTIMATE_BUDDY3DOWNGRADE, AppConstants.Preferences.SHOW_HOT_INTIMATE_LADY_BRO1UPGRADE, AppConstants.Preferences.SHOW_HOT_INTIMATE_LADY_BRO2UPGRADE, AppConstants.Preferences.SHOW_HOT_INTIMATE_LADY_BRO2DOWNGRADE, AppConstants.Preferences.SHOW_HOT_INTIMATE_LADY_BRO3DOWNGRADE, AppConstants.Preferences.SHOW_HOT_INTIMATE_BEST_FRIEND1UPGRADE, AppConstants.Preferences.SHOW_HOT_INTIMATE_BEST_FRIEND2UPGRADE, AppConstants.Preferences.SHOW_HOT_INTIMATE_BEST_FRIEND2DOWNGRADE, AppConstants.Preferences.SHOW_HOT_INTIMATE_BEST_FRIEND3DOWNGRADE, AppConstants.Preferences.SHOW_HOT_INTIMATE_BIND_TIP, AppConstants.Preferences.SHOW_HOT_INTIMATE_UN_BIND1TIP, AppConstants.Preferences.SHOW_HOT_INTIMATE_UN_BIND2TIP, AppConstants.Preferences.SHOW_HOT_INTIMATE_UN_BIND3TIP, AppConstants.Preferences.SHOW_HOT_INTIMATE_BECOME_GRAY_TIP, AppConstants.Preferences.SHOW_HOT_INTIMATE_BECOME_LIGHT_TIP}, new String[]{(String) hashMap3.get("graytipLover1Upgrade"), (String) hashMap3.get("graytipLover2Upgrade"), (String) hashMap3.get("graytipLover2Downgrade"), (String) hashMap3.get("graytipLover3Downgrade"), (String) hashMap3.get("graytipBuddy1Upgrade"), (String) hashMap3.get("graytipBuddy2Upgrade"), (String) hashMap3.get("graytipBuddy2Downgrade"), (String) hashMap3.get("graytipBuddy3Downgrade"), (String) hashMap3.get("graytipLadyBro1Upgrade"), (String) hashMap3.get("graytipLadyBro2Upgrade"), (String) hashMap3.get("graytipLadyBro2Downgrade"), (String) hashMap3.get("graytipLadyBro3Downgrade"), (String) hashMap3.get("graytipBestFriend1Upgrade"), (String) hashMap3.get("graytipBestFriend2Upgrade"), (String) hashMap3.get("graytipBestFriend2Downgrade"), (String) hashMap3.get("graytipBestFriend3Downgrade"), (String) hashMap3.get("graytipIntimateshipBindTip"), (String) hashMap3.get("graytipIntimateshipUnBind1Tip"), (String) hashMap3.get("graytipIntimateshipUnBind2Tip"), (String) hashMap3.get("graytipIntimateshipUnBind3Tip"), (String) hashMap3.get("graytipIntimateshipBecomeGrayTip"), (String) hashMap3.get("graytipIntimateshipBecomeLightTip")});
            r(qQAppInterface.getApp(), str2);
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.e(f252239a, 2, str, e16);
            }
        }
    }

    public static void l(Context context, String str) {
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        if (!TextUtils.isEmpty(str)) {
            edit.putString(AppConstants.Preferences.SHOW_HOT_FRIEND_CHAT_NUM_DES, str);
        }
        edit.commit();
    }

    public static void m(Context context, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, String str16, String str17, String str18, String str19, String str20, String str21, String str22, String str23, String str24, String str25, String str26, String str27, String str28, String str29, String str30, String str31, String str32) {
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        if (!TextUtils.isEmpty(str)) {
            edit.putString(AppConstants.Preferences.SHOW_HOT_FRIEND_GRAYTIPS_CHAT_UP, str);
        }
        if (!TextUtils.isEmpty(str2)) {
            edit.putString(AppConstants.Preferences.SHOW_HOT_FRIEND_GRAYTIPS_PRAISE_UP, str2);
        }
        if (!TextUtils.isEmpty(str3)) {
            edit.putString(AppConstants.Preferences.SHOW_HOT_FRIEND_GRAYTIPS_CLOSE_UP, str3);
        }
        if (!TextUtils.isEmpty(str4)) {
            edit.putString(AppConstants.Preferences.SHOW_HOT_FRIEND_GRAYTIPS_QZONE_LOVER_UP, str4);
        }
        if (!TextUtils.isEmpty(str5)) {
            edit.putString(AppConstants.Preferences.SHOW_HOT_FRIEND_GRAYTIPS_QZONE_UP, str5);
        }
        if (!TextUtils.isEmpty(str6)) {
            edit.putString(AppConstants.Preferences.SHOW_HOT_FRIEND_GRAYTIPS_CHAT_UP2, str6);
        }
        if (!TextUtils.isEmpty(str7)) {
            edit.putString(AppConstants.Preferences.SHOW_HOT_FRIEND_GRAYTIPS_PRAISE_UP2, str7);
        }
        if (!TextUtils.isEmpty(str8)) {
            edit.putString(AppConstants.Preferences.SHOW_HOT_FRIEND_GRAYTIPS_CLOSE_UP2, str8);
        }
        if (!TextUtils.isEmpty(str9)) {
            edit.putString(AppConstants.Preferences.SHOW_HOT_FRIEND_GRAYTIPS_QZONE_LOVER_UP2, str9);
        }
        if (!TextUtils.isEmpty(str21)) {
            edit.putString(AppConstants.Preferences.SHOW_HOT_FRIEND_GRAYTIPS_QZONE_LOVER_CLOSE, str21);
        }
        if (!TextUtils.isEmpty(str22)) {
            edit.putString(AppConstants.Preferences.SHOW_HOT_FRIEND_GRAYTIPS_QZONE_LOVER_CLOSE2, str22);
        }
        if (!TextUtils.isEmpty(str23)) {
            edit.putString(AppConstants.Preferences.SHOW_HOT_FRIEND_GRAYTIPS_QZONE_LOVER_OPEN, str23);
        }
        if (!TextUtils.isEmpty(str24)) {
            edit.putString(AppConstants.Preferences.SHOW_HOT_FRIEND_GRAYTIPS_QZONE_LOVER_OPEN2, str24);
        }
        if (!TextUtils.isEmpty(str25)) {
            edit.putString(AppConstants.Preferences.SHOW_HOT_FRIEND_GRAYTIPS_QZONE_LOVER_UPDATE, str25);
        }
        if (!TextUtils.isEmpty(str26)) {
            edit.putString(AppConstants.Preferences.SHOW_HOT_FRIEND_GRAYTIPS_QZONE_LOVER_UPDATE2, str26);
        }
        if (!TextUtils.isEmpty(str10)) {
            edit.putString(AppConstants.Preferences.SHOW_HOT_FRIEND_GRAYTIPS_QZONE_UP2, str10);
        }
        if (!TextUtils.isEmpty(str11)) {
            edit.putString(AppConstants.Preferences.SHOW_HOT_FRIEND_GRAYTIPS_CHAT_DOWN, str11);
        }
        if (!TextUtils.isEmpty(str12)) {
            edit.putString(AppConstants.Preferences.SHOW_HOT_FRIEND_GRAYTIPS_PRAISE_DOWN, str12);
        }
        if (!TextUtils.isEmpty(str13)) {
            edit.putString(AppConstants.Preferences.SHOW_HOT_FRIEND_GRAYTIPS_CLOSE_DOWN, str13);
        }
        if (!TextUtils.isEmpty(str14)) {
            edit.putString(AppConstants.Preferences.SHOW_HOT_FRIEND_GRAYTIPS_QZONE_LOVER_DOWN, str14);
        }
        if (!TextUtils.isEmpty(str15)) {
            edit.putString(AppConstants.Preferences.SHOW_HOT_FRIEND_GRAYTIPS_QZONE_DOWN, str15);
        }
        if (!TextUtils.isEmpty(str16)) {
            edit.putString(AppConstants.Preferences.SHOW_HOT_FRIEND_GRAYTIPS_CHAT_DIS, str16);
        }
        if (!TextUtils.isEmpty(str17)) {
            edit.putString(AppConstants.Preferences.SHOW_HOT_FRIEND_GRAYTIPS_PRAISE_DIS, str17);
        }
        if (!TextUtils.isEmpty(str18)) {
            edit.putString(AppConstants.Preferences.SHOW_HOT_FRIEND_GRAYTIPS_CLOSE_DIS, str18);
        }
        if (!TextUtils.isEmpty(str19)) {
            edit.putString(AppConstants.Preferences.SHOW_HOT_FRIEND_GRAYTIPS_QZONE_LOVER_DIS, str19);
        }
        if (!TextUtils.isEmpty(str20)) {
            edit.putString(AppConstants.Preferences.SHOW_HOT_FRIEND_GRAYTIPS_QZONE_DIS, str20);
        }
        if (!TextUtils.isEmpty(str27)) {
            edit.putString(AppConstants.Preferences.SHOW_HOT_FRIENDSHIP_GRAYTIPS_1_UPGRADE, str27);
        }
        if (!TextUtils.isEmpty(str28)) {
            edit.putString(AppConstants.Preferences.SHOW_HOT_FRIENDSHIP_GRAYTIPS_1_DOWNGRADE, str28);
        }
        if (!TextUtils.isEmpty(str29)) {
            edit.putString(AppConstants.Preferences.SHOW_HOT_FRIENDSHIP_GRAYTIPS_2_UPGRADE, str29);
        }
        if (!TextUtils.isEmpty(str30)) {
            edit.putString(AppConstants.Preferences.SHOW_HOT_FRIENDSHIP_GRAYTIPS_2_DOWNGRADE, str30);
        }
        if (!TextUtils.isEmpty(str31)) {
            edit.putString(AppConstants.Preferences.SHOW_HOT_FRIENDSHIP_GRAYTIPS_3_UPGRADE, str31);
        }
        if (!TextUtils.isEmpty(str32)) {
            edit.putString(AppConstants.Preferences.SHOW_HOT_FRIENDSHIP_GRAYTIPS_3_DOWNGRADE, str32);
        }
        edit.commit();
    }

    public static void n(Context context, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13) {
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        if (!TextUtils.isEmpty(str)) {
            edit.putString(AppConstants.Preferences.SHOW_HOT_FRIEND_GRAYTIPS_PRAISE_DOWN_REMIND, str);
        }
        if (!TextUtils.isEmpty(str2)) {
            edit.putString(AppConstants.Preferences.SHOW_HOT_FRIEND_GRAYTIPS_PRAISE_DIS_REMIND, str2);
        }
        if (!TextUtils.isEmpty(str3)) {
            edit.putString(AppConstants.Preferences.SHOW_HOT_FRIEND_GRAYTIPS_CHAT_DOWN_REMIND, str3);
        }
        if (!TextUtils.isEmpty(str4)) {
            edit.putString(AppConstants.Preferences.SHOW_HOT_FRIEND_GRAYTIPS_CHAT_DIS_REMIND, str4);
        }
        if (!TextUtils.isEmpty(str5)) {
            edit.putString(AppConstants.Preferences.SHOW_HOT_FRIEND_GRAYTIPS_QZONE_DOWN_REMIND, str5);
        }
        if (!TextUtils.isEmpty(str6)) {
            edit.putString(AppConstants.Preferences.SHOW_HOT_FRIEND_GRAYTIPS_QZONE_DIS_REMIND, str6);
        }
        if (!TextUtils.isEmpty(str7)) {
            edit.putString(AppConstants.Preferences.SHOW_HOT_FRIEND_GRAYTIPS_PRAISE_AND_CHAT_REMIND, str7);
        }
        if (!TextUtils.isEmpty(str8)) {
            edit.putString(AppConstants.Preferences.SHOW_HOT_FRIEND_GRAYTIPS_CHAT_AND_QZONE_REMIND, str8);
        }
        if (!TextUtils.isEmpty(str9)) {
            edit.putString(AppConstants.Preferences.SHOW_HOT_FRIEND_GRAYTIPS_PRAISE_AND_QZONE_REMIND, str9);
        }
        if (!TextUtils.isEmpty(str10)) {
            edit.putString(AppConstants.Preferences.SHOW_HOT_FRIEND_GRAYTIPS_PCQALL_REMIND, str10);
        }
        if (!TextUtils.isEmpty(str11)) {
            edit.putString(AppConstants.Preferences.SHOW_HOT_FRIENDSHIP_GRAYTIPS_1_WILL_DOWNGRADE, str11);
        }
        if (!TextUtils.isEmpty(str12)) {
            edit.putString(AppConstants.Preferences.SHOW_HOT_FRIENDSHIP_GRAYTIPS_2_WILL_DOWNGRADE, str12);
        }
        if (!TextUtils.isEmpty(str13)) {
            edit.putString(AppConstants.Preferences.SHOW_HOT_FRIENDSHIP_GRAYTIPS_3_WILL_DOWNGRADE, str13);
        }
        edit.commit();
    }

    public static void o(Context context, FriendsManager friendsManager, int i3, int i16, int i17, String[] strArr, String[] strArr2) {
        if (QLog.isColorLevel()) {
            QLog.i(f252239a, 2, "updateIntimateRelationshipConfig begin  keys.length" + strArr.length + " values.length" + strArr2.length);
        }
        friendsManager.V = i3;
        friendsManager.W = i16;
        friendsManager.X = i17;
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        if (i3 > 0) {
            edit.putInt(AppConstants.Preferences.SHOW_HOT_INTIMATE_MIN_DAYS, i3);
        }
        if (i16 > 0) {
            edit.putInt(AppConstants.Preferences.SHOW_HOT_INTIMATE_MAX_DAYS, i16);
        }
        if (i17 > 0) {
            edit.putInt(AppConstants.Preferences.SHOW_HOT_INTIMATE_DAY_MSG_COUNT, i17);
        }
        if (strArr.length == strArr2.length) {
            int length = strArr.length;
            for (int i18 = 0; i18 < length; i18++) {
                if (!TextUtils.isEmpty(strArr2[i18])) {
                    edit.putString(strArr[i18], strArr2[i18]);
                }
            }
            edit.commit();
            if (QLog.isColorLevel()) {
                QLog.i(f252239a, 2, "updateIntimateRelationshipConfig end");
                return;
            }
            return;
        }
        throw new RuntimeException("updateIntimateRelationshipConfig keys.length != values.length");
    }

    public static void p(Context context, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11) {
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        if (!TextUtils.isEmpty(str)) {
            edit.putString(AppConstants.Preferences.SHOW_NEW_BOAT_GRAYTIPS_CLOSE_UP, str);
        }
        if (!TextUtils.isEmpty(str2)) {
            edit.putString(AppConstants.Preferences.SHOW_NEW_BOAT_GRAYTIPS_CLOSE_UP2, str2);
        }
        if (!TextUtils.isEmpty(str3)) {
            edit.putString(AppConstants.Preferences.SHOW_NEW_BOAT_GRAYTIPS_CLOSE_UP3, str3);
        }
        if (!TextUtils.isEmpty(str4)) {
            edit.putString(AppConstants.Preferences.SHOW_NEW_BOAT_GRAYTIPS_CLOSE_DOWN, str4);
        }
        if (!TextUtils.isEmpty(str5)) {
            edit.putString(AppConstants.Preferences.SHOW_NEW_BOAT_GRAYTIPS_CLOSE_DOWN2, str5);
        }
        if (!TextUtils.isEmpty(str6)) {
            edit.putString(AppConstants.Preferences.SHOW_NEW_BOAT_GRAYTIPS_CLOSE_DOWN3, str6);
        }
        if (!TextUtils.isEmpty(str7)) {
            edit.putString(AppConstants.Preferences.SHOW_NEW_BOAT_GRAYTIPS_UPCOMING_UPGRADE, str7);
        }
        if (!TextUtils.isEmpty(str8)) {
            edit.putString(AppConstants.Preferences.SHOW_NEW_BOAT_GRAYTIPS_UPCOMING_UPGRADE2, str8);
        }
        if (!TextUtils.isEmpty(str9)) {
            edit.putString(AppConstants.Preferences.SHOW_NEW_BOAT_GRAYTIPS_UPCOMING_UPGRADE3, str9);
        }
        if (!TextUtils.isEmpty(str10)) {
            edit.putString(AppConstants.Preferences.SHOW_NEW_BOAT_GRAYTIPS_UPCOMING_DOWNGRADE, str10);
        }
        if (!TextUtils.isEmpty(str11)) {
            edit.putString(AppConstants.Preferences.SHOW_NEW_BOAT_GRAYTIPS_UPCOMING_DOWNGRADE2, str11);
        }
        edit.commit();
    }

    public static void q(Context context, boolean z16, String str, String str2, String str3, String str4) {
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        f252246h = z16;
        f252247i = true;
        edit.putBoolean(AppConstants.Preferences.SHOW_NEW_BOAT_USED_NEW, z16);
        edit.putString(AppConstants.Preferences.SHOW_NEW_BOAT_SMALL_CLOSE_SETTING, str);
        edit.putString(AppConstants.Preferences.SHOW_NEW_BOAT_BIG_CLOSE_SETTING, str2);
        edit.putString(AppConstants.Preferences.SHOW_NEW_BOAT_SMALL_CLOSE_KEY, str3);
        edit.putString(AppConstants.Preferences.SHOW_NEW_BOAT_BIG_CLOSE_KEY, str4);
        edit.commit();
    }

    public static void r(Context context, String str) {
        if (!TextUtils.isEmpty(str)) {
            SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
            edit.putString(AppConstants.Preferences.SHOW_HOT_FRIEND_REACTIVE_WILL_DOWNGRADE_PUSH_TIP, str);
            edit.commit();
        }
    }

    public static void s(Context context, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, String str16, String str17, String str18, String str19, String str20, String str21, String str22) {
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        if (!TextUtils.isEmpty(str)) {
            edit.putString(AppConstants.Preferences.SHOW_HOT_FRIEND_SMALL_CHAT_SVIP_KEY, str);
        }
        if (!TextUtils.isEmpty(str)) {
            edit.putString(AppConstants.Preferences.SHOW_HOT_FRIEND_SMALL_CHAT_UNIONVIP_KEY, str2);
        }
        if (!TextUtils.isEmpty(str)) {
            edit.putString("hot_friend_big_chat_svip_setting", str3);
        }
        if (!TextUtils.isEmpty(str)) {
            edit.putString("hot_friend_big_chat_unionvip_setting", str4);
        }
        if (!TextUtils.isEmpty(str)) {
            edit.putString(AppConstants.Preferences.SHOW_HOT_FRIEND_SMALL_CLOSE_SVIP_KEY, str5);
        }
        if (!TextUtils.isEmpty(str)) {
            edit.putString(AppConstants.Preferences.SHOW_HOT_FRIEND_SMALL_CLOSE_UNIONVIP_KEY, str6);
        }
        if (!TextUtils.isEmpty(str)) {
            edit.putString(AppConstants.Preferences.SHOW_HOT_FRIEND_BIG_CLOSE_SVIP_KEY, str7);
        }
        if (!TextUtils.isEmpty(str)) {
            edit.putString(AppConstants.Preferences.SHOW_HOT_FRIEND_BIG_CLOSE_UNIONVIP_KEY, str8);
        }
        if (!TextUtils.isEmpty(str)) {
            edit.putString(AppConstants.Preferences.SHOW_HOT_FRIEND_SMALL_CHAT_SVIP_SETTING, str9);
        }
        if (!TextUtils.isEmpty(str)) {
            edit.putString(AppConstants.Preferences.SHOW_HOT_FRIEND_SMALL_CHAT_UNIONVIP_SETTING, str10);
        }
        if (!TextUtils.isEmpty(str)) {
            edit.putString("hot_friend_big_chat_svip_setting", str11);
        }
        if (!TextUtils.isEmpty(str)) {
            edit.putString("hot_friend_big_chat_unionvip_setting", str12);
        }
        if (!TextUtils.isEmpty(str)) {
            edit.putString(AppConstants.Preferences.SHOW_HOT_FRIEND_SMALL_CLOSE_SVIP_SETTING, str13);
        }
        if (!TextUtils.isEmpty(str)) {
            edit.putString(AppConstants.Preferences.SHOW_HOT_FRIEND_SMALL_CLOSE_SVIP_SETTING, str14);
        }
        if (!TextUtils.isEmpty(str)) {
            edit.putString(AppConstants.Preferences.SHOW_HOT_FRIEND_BIG_CLOSE_SVIP_SETTING, str15);
        }
        if (!TextUtils.isEmpty(str)) {
            edit.putString(AppConstants.Preferences.SHOW_HOT_FRIEND_BIG_CLOSE_UNIONVIP_SETTING, str16);
        }
        if (!TextUtils.isEmpty(str)) {
            edit.putString(AppConstants.Preferences.SHOW_HOT_INTIMATE_LOVER_1_VIP_TYPE, str17);
        }
        if (!TextUtils.isEmpty(str)) {
            edit.putString(AppConstants.Preferences.SHOW_HOT_INTIMATE_LOVER_2_VIP_TYPE, str18);
        }
        if (!TextUtils.isEmpty(str)) {
            edit.putString(AppConstants.Preferences.SHOW_HOT_INTIMATE_LOVER_3_VIP_TYPE, str19);
        }
        if (!TextUtils.isEmpty(str)) {
            edit.putString(AppConstants.Preferences.SHOW_HOT_INTIMATE_LOVER_1_VIP_SETTING, str20);
        }
        if (!TextUtils.isEmpty(str)) {
            edit.putString(AppConstants.Preferences.SHOW_HOT_INTIMATE_LOVER_2_VIP_SETTING, str21);
        }
        if (!TextUtils.isEmpty(str)) {
            edit.putString(AppConstants.Preferences.SHOW_HOT_INTIMATE_LOVER_3_VIP_SETTING, str22);
        }
        edit.commit();
    }
}
