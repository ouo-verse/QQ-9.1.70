package com.tencent.av.utils;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.text.TextUtils;
import com.tencent.av.gaudio.AVPhoneUserInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.DiscussionMemberInfo;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.data.QCallRecent;
import com.tencent.mobileqq.phonecontact.api.IPhoneContactService;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.util.bj;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.oidb.cmd0xa02.cmd0xa02$TinyID2UserAccInfo;

/* compiled from: P */
@Deprecated
/* loaded from: classes3.dex */
public class ae {
    public static String a(ArrayList<AVPhoneUserInfo> arrayList) {
        try {
            JSONArray jSONArray = new JSONArray();
            for (int i3 = 0; i3 < arrayList.size(); i3++) {
                AVPhoneUserInfo aVPhoneUserInfo = arrayList.get(i3);
                JSONObject jSONObject = new JSONObject();
                JSONObject jSONObject2 = new JSONObject();
                jSONObject.put("a", aVPhoneUserInfo.account);
                jSONObject.put("at", aVPhoneUserInfo.accountType);
                jSONObject2.put(QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, aVPhoneUserInfo.telInfo.mobile);
                jSONObject2.put(DomainData.DOMAIN_NAME, aVPhoneUserInfo.telInfo.nation);
                jSONObject2.put("p", aVPhoneUserInfo.telInfo.prefix);
                jSONObject2.put("ns", aVPhoneUserInfo.telInfo.nationState);
                jSONObject.put("ti", jSONObject2);
                jSONArray.mo162put(jSONObject);
            }
            return jSONArray.toString();
        } catch (JSONException e16) {
            e16.printStackTrace();
            return null;
        }
    }

    public static String b(QQAppInterface qQAppInterface, String str, int i3) {
        com.tencent.mobileqq.qcall.f fVar;
        QCallRecent A;
        if (QLog.isColorLevel()) {
            QLog.d("PstnUtils", 2, "getPstnInfoFromQCallRecent --> uin = " + str + " ,uinType = " + i3);
        }
        if (qQAppInterface == null || str == null || (fVar = (com.tencent.mobileqq.qcall.f) qQAppInterface.getManager(QQManagerFactory.RECENT_CALL_FACADE)) == null || (A = fVar.A(str, i3)) == null) {
            return null;
        }
        String str2 = A.pstnInfo;
        if (QLog.isColorLevel()) {
            QLog.d("PstnUtils", 2, "getPstnInfoFromQCallRecent --> value = " + str2);
        }
        return str2;
    }

    private static Bitmap c(QQAppInterface qQAppInterface, String str) {
        String str2;
        Bitmap.Config config;
        PhoneContact queryPhoneContactByMobile = ((IPhoneContactService) qQAppInterface.getRuntimeService(IPhoneContactService.class, "")).queryPhoneContactByMobile(str);
        if (queryPhoneContactByMobile != null) {
            str2 = com.tencent.mobileqq.utils.ac.U(queryPhoneContactByMobile.name);
        } else {
            str2 = null;
        }
        if (str2 == null) {
            str2 = com.tencent.mobileqq.utils.ac.U(str);
        }
        bj bjVar = new bj(qQAppInterface.getApp(), str2);
        int intrinsicWidth = bjVar.getIntrinsicWidth();
        int intrinsicHeight = bjVar.getIntrinsicHeight();
        if (bjVar.getOpacity() != -1) {
            config = Bitmap.Config.ARGB_8888;
        } else {
            config = Bitmap.Config.RGB_565;
        }
        Bitmap createBitmap = Bitmap.createBitmap(intrinsicWidth, intrinsicHeight, config);
        Canvas canvas = new Canvas(createBitmap);
        bjVar.setBounds(0, 0, bjVar.getIntrinsicWidth(), bjVar.getIntrinsicHeight());
        bjVar.draw(canvas);
        return createBitmap;
    }

    public static List<Bitmap> d(QQAppInterface qQAppInterface, String str, int i3, int i16) {
        ArrayList<AVPhoneUserInfo> h16;
        com.tencent.mobileqq.app.n nVar;
        String str2;
        String b16 = b(qQAppInterface, str, i3);
        QLog.i("PstnUtils", 2, " ==== getRealAVPhoneBitmap === pstnInfo : " + b16);
        if (b16 == null || b16.length() == 0 || (h16 = h(b16)) == null || h16.size() == 0 || (nVar = (com.tencent.mobileqq.app.n) qQAppInterface.getManager(QQManagerFactory.DISCUSSION_MANAGER)) == null) {
            return null;
        }
        Map<String, DiscussionMemberInfo> n3 = nVar.n(str);
        IPhoneContactService iPhoneContactService = (IPhoneContactService) qQAppInterface.getRuntimeService(IPhoneContactService.class, "");
        ArrayList arrayList = new ArrayList();
        int min = Math.min(i16, h16.size());
        for (int i17 = 0; i17 < min; i17++) {
            AVPhoneUserInfo aVPhoneUserInfo = h16.get(i17);
            String str3 = aVPhoneUserInfo.telInfo.mobile;
            if (str3 != null && str3.length() != 0) {
                PhoneContact queryPhoneContactByMobile = iPhoneContactService.queryPhoneContactByMobile(str3);
                if (queryPhoneContactByMobile != null) {
                    str2 = queryPhoneContactByMobile.uin;
                } else {
                    str2 = null;
                }
                if (str2 != null && str2.length() != 0) {
                    if (n3 == null || !n3.containsKey(str2)) {
                        Bitmap faceBitmap = qQAppInterface.getFaceBitmap(11, aVPhoneUserInfo.telInfo.nation + str3, (byte) 3, true, 0);
                        if (faceBitmap == null) {
                            faceBitmap = c(qQAppInterface, str3);
                        }
                        arrayList.add(faceBitmap);
                    }
                } else {
                    arrayList.add(c(qQAppInterface, str3));
                }
            }
        }
        return arrayList;
    }

    public static List<AVPhoneUserInfo> e(QQAppInterface qQAppInterface, String str, int i3) {
        ArrayList<AVPhoneUserInfo> h16;
        com.tencent.mobileqq.app.n nVar;
        String str2;
        String b16 = b(qQAppInterface, str, i3);
        if (QLog.isColorLevel()) {
            QLog.i("PstnUtils", 2, " ==== getRealAVPhoneUserInfo === pstnInfo : " + b16);
        }
        if (b16 == null || b16.length() == 0 || (h16 = h(b16)) == null || h16.size() == 0 || (nVar = (com.tencent.mobileqq.app.n) qQAppInterface.getManager(QQManagerFactory.DISCUSSION_MANAGER)) == null) {
            return null;
        }
        Map<String, DiscussionMemberInfo> n3 = nVar.n(str);
        IPhoneContactService iPhoneContactService = (IPhoneContactService) qQAppInterface.getRuntimeService(IPhoneContactService.class, "");
        ArrayList arrayList = new ArrayList();
        Iterator<AVPhoneUserInfo> it = h16.iterator();
        while (it.hasNext()) {
            AVPhoneUserInfo next = it.next();
            String str3 = next.telInfo.mobile;
            if (str3 != null && str3.length() != 0) {
                PhoneContact queryPhoneContactByMobile = iPhoneContactService.queryPhoneContactByMobile(str3);
                if (queryPhoneContactByMobile != null) {
                    str2 = queryPhoneContactByMobile.uin;
                } else {
                    str2 = null;
                }
                if (str2 != null && str2.length() != 0) {
                    if (n3 == null || !n3.containsKey(str2)) {
                        arrayList.add(next);
                    }
                } else {
                    arrayList.add(next);
                }
            }
        }
        if (QLog.isColorLevel()) {
            QLog.i("PstnUtils", 2, " ==== getRealAVPhoneUserInfo === list : " + arrayList.toString());
        }
        return arrayList;
    }

    public static boolean f(QQAppInterface qQAppInterface, String str, int i3) {
        List<AVPhoneUserInfo> e16 = e(qQAppInterface, str, i3);
        if (e16 != null && e16.size() > 0) {
            return true;
        }
        return false;
    }

    public static String g(String str, int i3) {
        if (str == null) {
            if (QLog.isColorLevel()) {
                QLog.d("PstnUtils", 2, "hideCharacterInPhoneNumbe--> phoneNumber is null");
                return null;
            }
            return null;
        }
        if (str.length() < i3) {
            if (QLog.isColorLevel()) {
                QLog.d("PstnUtils", 2, "hideCharacterInPhoneNumbe--> phoneNumber less ncount");
            }
            return str;
        }
        if (str.length() < i3 + 3) {
            return str;
        }
        String substring = str.substring(str.length() - 2, str.length());
        return str.substring(0, 3) + "***" + substring;
    }

    public static ArrayList<AVPhoneUserInfo> h(String str) {
        try {
            JSONArray jSONArray = new JSONArray(str);
            ArrayList<AVPhoneUserInfo> arrayList = new ArrayList<>();
            for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i3);
                JSONObject optJSONObject = jSONObject.optJSONObject("ti");
                AVPhoneUserInfo aVPhoneUserInfo = new AVPhoneUserInfo();
                aVPhoneUserInfo.account = jSONObject.optLong("a", 0L);
                aVPhoneUserInfo.accountType = jSONObject.optInt("at", -1);
                aVPhoneUserInfo.telInfo.mobile = optJSONObject.optString(QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "");
                aVPhoneUserInfo.telInfo.nation = optJSONObject.optString(DomainData.DOMAIN_NAME, "");
                aVPhoneUserInfo.telInfo.prefix = optJSONObject.optString("p", "");
                aVPhoneUserInfo.telInfo.nationState = optJSONObject.optInt("ns", 0);
                if (-1 != aVPhoneUserInfo.accountType) {
                    arrayList.add(aVPhoneUserInfo);
                }
            }
            return arrayList;
        } catch (JSONException e16) {
            e16.printStackTrace();
            return null;
        }
    }

    public static ArrayList<AVPhoneUserInfo> i(List<cmd0xa02$TinyID2UserAccInfo> list) {
        String substring;
        String str;
        ArrayList<AVPhoneUserInfo> arrayList = new ArrayList<>();
        if (list != null && list.size() != 0) {
            for (cmd0xa02$TinyID2UserAccInfo cmd0xa02_tinyid2useraccinfo : list) {
                AVPhoneUserInfo aVPhoneUserInfo = new AVPhoneUserInfo();
                aVPhoneUserInfo.account = cmd0xa02_tinyid2useraccinfo.uint64_tinyid.get();
                aVPhoneUserInfo.accountType = cmd0xa02_tinyid2useraccinfo.uint32_useracctype.get();
                String str2 = cmd0xa02_tinyid2useraccinfo.str_useracc_identifier.get();
                if (!TextUtils.isEmpty(str2) && str2.length() >= 5) {
                    if (str2.contains("-")) {
                        String[] split = str2.split("-");
                        str = split[0];
                        substring = split[1];
                    } else {
                        String substring2 = str2.substring(0, 4);
                        substring = str2.substring(4, str2.length());
                        str = substring2;
                    }
                    AVPhoneUserInfo.TelInfo telInfo = aVPhoneUserInfo.telInfo;
                    telInfo.nation = str;
                    telInfo.mobile = substring;
                    if (!TextUtils.isEmpty(str)) {
                        aVPhoneUserInfo.telInfo.nationState = 1;
                    }
                    arrayList.add(aVPhoneUserInfo);
                }
            }
        }
        return arrayList;
    }
}
