package com.tencent.mobileqq.mutualmark.oldlogic;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.PushMsg0x210C7Info;
import com.tencent.mobileqq.config.business.MutualMarkConfProcessor;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.mobileqq.graytip.g;
import com.tencent.mobileqq.mutualmark.d;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.service.message.e;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.ac;
import com.tencent.mobileqq.vas.config.business.qvip.QVipFriendTag2Config;
import com.tencent.mobileqq.vas.config.business.qvip.QVipFriendTag2Processor;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes15.dex */
public class b {
    static IPatchRedirector $redirector_;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes15.dex */
    public class a implements Comparator<String> {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(String str, String str2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this, (Object) str, (Object) str2)).intValue();
            }
            if (str != null && str2 != null) {
                if (str.length() > str2.length()) {
                    return -1;
                }
                if (str.length() < str2.length()) {
                    return 1;
                }
                return 0;
            }
            if (str != null) {
                return -1;
            }
            if (str2 != null) {
                return 1;
            }
            return 0;
        }
    }

    public static List<String> a(AppInterface appInterface, String str, String str2, int i3) {
        ArrayList arrayList = new ArrayList();
        long j3 = i3;
        String d16 = com.tencent.mobileqq.mutualmark.b.d(appInterface, str, j3, 0L);
        String d17 = com.tencent.mobileqq.mutualmark.b.d(appInterface, str, j3, 1L);
        String d18 = com.tencent.mobileqq.mutualmark.b.d(appInterface, str, j3, 2L);
        if (str2.contains("#intimateshipicon1")) {
            str2 = str2.replace("#intimateshipicon1", d16);
            arrayList.add(d16);
        }
        if (str2.contains("#intimateshipicon2")) {
            str2 = str2.replace("#intimateshipicon2", d17);
            arrayList.add(d17);
        }
        if (str2.contains("#intimateshipicon3")) {
            str2 = str2.replace("#intimateshipicon3", d18);
            arrayList.add(d18);
        }
        arrayList.add(0, str2);
        return arrayList;
    }

    private static List<String> b(AppInterface appInterface, String str, String str2, FriendsManager friendsManager, int i3) {
        ArrayList arrayList = new ArrayList();
        long j3 = i3;
        String f16 = com.tencent.mobileqq.mutualmark.b.f(appInterface, j3, 0L);
        String f17 = com.tencent.mobileqq.mutualmark.b.f(appInterface, j3, 1L);
        String f18 = com.tencent.mobileqq.mutualmark.b.f(appInterface, j3, 2L);
        String valueOf = String.valueOf(friendsManager.V);
        String valueOf2 = String.valueOf(friendsManager.W);
        String valueOf3 = String.valueOf(friendsManager.X);
        if (str.contains("#intimateshipday1")) {
            str = str.replace("#intimateshipday1", valueOf);
        }
        if (str.contains("#intimateshipday2")) {
            str = str.replace("#intimateshipday2", valueOf2);
        }
        if (str.contains("#intimateshipmsgcount")) {
            str = str.replace("#intimateshipmsgcount", valueOf3);
        }
        if (str.contains("#intimateshipname1")) {
            str = str.replace("#intimateshipname1", f16);
            arrayList.add(f16);
        }
        if (str.contains("#intimateshipname2")) {
            str = str.replace("#intimateshipname2", f17);
            arrayList.add(f17);
        }
        if (str.contains("#intimateshipname3")) {
            str = str.replace("#intimateshipname3", f18);
            arrayList.add(f18);
        }
        arrayList.add(0, str.replace(HardCodeUtil.qqStr(R.string.f172020ms3), str2));
        return arrayList;
    }

    public static void c(String str, List<String> list, g gVar, ArrayList<d.b> arrayList) {
        for (int i3 = 0; i3 < list.size(); i3++) {
            Bundle bundle = new Bundle();
            String str2 = list.get(i3);
            if (!TextUtils.isEmpty(str2)) {
                bundle.putString("image_resource", str2);
                int i16 = 0;
                while (true) {
                    int indexOf = str.indexOf(str2, i16);
                    int length = str2.length() + indexOf;
                    if (indexOf >= 0) {
                        gVar.b(indexOf, length, bundle);
                        d.b bVar = new d.b();
                        bVar.f252021a = 2;
                        bVar.f252027g = str2;
                        bVar.f252025e = indexOf;
                        bVar.f252026f = length;
                        arrayList.add(bVar);
                        if (QLog.isColorLevel()) {
                            QLog.d("OldIntimateGrayTipsHelper", 2, "iconPos=" + indexOf + " fromIndex=" + length);
                        }
                    }
                    if (indexOf < 0) {
                        break;
                    } else {
                        i16 = length;
                    }
                }
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:44:0x00be, code lost:
    
        if (r15 == 0) goto L46;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:52:0x013e A[LOOP:1: B:7:0x003a->B:52:0x013e, LOOP_END] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void d(String str, String str2, int i3, List<String> list, List<String> list2, g gVar, ArrayList<d.b> arrayList) {
        int i16;
        int i17;
        int i18;
        Collections.sort(list, new a());
        ArrayList arrayList2 = new ArrayList();
        int i19 = 0;
        int i26 = 0;
        int i27 = 0;
        while (i26 < list.size()) {
            Bundle bundle = new Bundle();
            String str3 = list.get(i26);
            if (!TextUtils.isEmpty(str3)) {
                bundle.putInt("key_action", 11);
                bundle.putString("key_action_DATA", str3);
                int i28 = i19;
                while (true) {
                    int indexOf = str2.indexOf(str3, i28);
                    int length = str3.length() + indexOf;
                    Iterator it = arrayList2.iterator();
                    while (true) {
                        i16 = 1;
                        if (it.hasNext()) {
                            Pair pair = (Pair) it.next();
                            if (indexOf >= ((Integer) pair.first).intValue() && indexOf < ((Integer) pair.second).intValue()) {
                                i17 = 1;
                                break;
                            }
                        } else {
                            i17 = i19;
                            break;
                        }
                    }
                    int length2 = str2.length();
                    if (i17 == 0 && list2.size() > 0 && indexOf >= 0 && indexOf < length2 && length >= 0 && length < length2) {
                        if (str2.indexOf(str3, length) >= 0) {
                            i18 = 1;
                        } else {
                            i18 = i19;
                        }
                        if (list.size() > 1 || i18 != 0 || i27 > 0) {
                            String substring = str2.substring(i19, indexOf);
                            String substring2 = str2.substring(length);
                            int i29 = i19;
                            for (String str4 : list2) {
                                if (substring2.startsWith(str4) || substring.endsWith(str4)) {
                                    i29 = 1;
                                }
                            }
                        }
                    }
                    i16 = i17;
                    if (i16 == 0) {
                        arrayList2.add(new Pair(Integer.valueOf(indexOf), Integer.valueOf(length)));
                        if (indexOf >= 0) {
                            i27++;
                            gVar.b(indexOf, length, bundle);
                            d.b bVar = new d.b();
                            bVar.f252021a = 3;
                            bVar.f252027g = str3;
                            bVar.f252028h = MutualMarkConfProcessor.a().b(str).concat("&mutualmark_id=").concat(String.valueOf(i3));
                            bVar.f252025e = indexOf;
                            bVar.f252026f = length;
                            arrayList.add(bVar);
                            if (QLog.isColorLevel()) {
                                QLog.d("OldIntimateGrayTipsHelper", 2, "spanPos=" + indexOf + " fromIndex=" + length);
                            }
                            if (indexOf >= 0) {
                                break;
                            }
                            i28 = length;
                            i19 = 0;
                        }
                    }
                    if (indexOf >= 0) {
                    }
                }
            }
            i26++;
            i19 = 0;
        }
    }

    public static void e(AppInterface appInterface, String str, String str2, int i3, int i16, g gVar, ArrayList<d.b> arrayList) {
        QVipFriendTag2Config config = QVipFriendTag2Processor.getConfig();
        if (config.mIsShowRecoverLink) {
            Bundle bundle = new Bundle();
            bundle.putInt("key_action", 1);
            int i17 = 26;
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 != 3) {
                        if (i3 != 26) {
                            i17 = 10;
                        } else if (i16 == 0) {
                            i17 = 27;
                        } else {
                            i17 = 28;
                        }
                    } else if (i16 == 0) {
                        i17 = 21;
                    } else {
                        i17 = 22;
                    }
                } else if (i16 == 0) {
                    i17 = 23;
                } else {
                    i17 = 24;
                }
            } else if (i16 == 0) {
                i17 = 25;
            }
            int i18 = i17;
            String format = String.format(config.mRecoverFriendShipUrl, str, Integer.valueOf(i18));
            bundle.putString("key_action_DATA", format);
            int length = str2.length() - config.mRecoverText.length();
            if (length >= 0) {
                gVar.b(length, str2.length(), bundle);
                d.b bVar = new d.b();
                bVar.f252021a = 3;
                bVar.f252027g = config.mRecoverText;
                bVar.f252028h = format;
                bVar.f252025e = length;
                bVar.f252026f = str2.length();
                arrayList.add(bVar);
                ReportController.o(appInterface, "dc00898", "", "", QQPermissionConstants.Business.SCENE.QQ_VIP, "0X8009CA5", i18, 0, "", "", "", "");
            }
        }
    }

    private static void f(AppRuntime appRuntime, g gVar, MessageForUniteGrayTip messageForUniteGrayTip) {
        String account = appRuntime.getAccount();
        String str = gVar.f213681d;
        String str2 = gVar.f213682e;
        String str3 = gVar.f213683f;
        long j3 = gVar.f213686i;
        messageForUniteGrayTip.init(account, str, str2, str3, j3, gVar.f213687j, gVar.f213684g, j3);
        messageForUniteGrayTip.mIsParsed = true;
        messageForUniteGrayTip.isread = true;
        messageForUniteGrayTip.tipParam = gVar;
        messageForUniteGrayTip.msgData = null;
    }

    public static void g(AppInterface appInterface, FriendsManager friendsManager, String str, String str2, int i3, int i16, PushMsg0x210C7Info pushMsg0x210C7Info, int i17, int i18) {
        int i19;
        String str3;
        String str4 = str2;
        QLog.i("OldIntimateGrayTipsHelper", 1, "insertGrayTips uin:" + str + " grayTips:" + str4 + " intimateType:" + i3);
        if (!TextUtils.isEmpty(str2) && !com.tencent.mobileqq.mutualmark.g.k(appInterface)) {
            String H = ac.H(appInterface, str);
            if (i17 == 1019 && i18 == 0) {
                QVipFriendTag2Config config = QVipFriendTag2Processor.getConfig();
                if (config.mIsShowRecoverLink) {
                    str4 = str4 + config.mRecoverText;
                }
            }
            List<String> b16 = b(appInterface, str4, H, friendsManager, i3);
            List<String> a16 = a(appInterface, str, b16.get(0), i3);
            String str5 = a16.get(0);
            a16.remove(0);
            b16.remove(0);
            g gVar = new g(str, str, str5, 0, MessageRecord.MSG_TYPE_UNITE_GRAY_NORMAL, i17, e.K0());
            MessageForUniteGrayTip messageForUniteGrayTip = new MessageForUniteGrayTip();
            messageForUniteGrayTip.hasRead = 0;
            messageForUniteGrayTip.subType = i18;
            f(appInterface, gVar, messageForUniteGrayTip);
            messageForUniteGrayTip.tipParam.f213693p = str + "_intimate_" + String.valueOf(pushMsg0x210C7Info.msgSeq) + "_" + String.valueOf(pushMsg0x210C7Info.msgTime) + "_" + i3;
            ArrayList<d.b> arrayList = new ArrayList<>();
            if (a16.size() > 0) {
                c(str5, a16, gVar, arrayList);
            }
            if (b16.size() > 0) {
                i19 = i17;
                str3 = str;
                d(str, str5, i3, b16, a16, gVar, arrayList);
            } else {
                i19 = i17;
                str3 = str;
            }
            if (i19 == 1019 && i18 == 0) {
                e(appInterface, str, str5, i3, i16, gVar, arrayList);
            }
            if (QLog.isDebugVersion()) {
                QLog.d("OldIntimateGrayTipsHelper", 1, "insertGrayTips_After=" + str5);
            }
            com.tencent.mobileqq.mutualmark.nt.g.INSTANCE.a().f(arrayList).d().c((QQAppInterface) appInterface, str3, i19, gVar.f213683f);
        }
    }
}
