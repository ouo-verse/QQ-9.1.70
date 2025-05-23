package com.tencent.mobileqq.app.friendlist.processor;

import android.text.TextUtils;
import android.util.Pair;
import com.tencent.mobileqq.activity.specialcare.e;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.data.SpecialCareInfo;
import com.tencent.mobileqq.friend.processor.BaseFriendProcessor;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;
import com.tencent.qphone.base.util.QLog;
import friendlist.FriendInfo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;
import mqq.app.AppRuntime;
import tencent.im.oidb.cmd0x5d0.Oidb_0x5d0$SnsUpateBuffer;
import tencent.im.oidb.cmd0x5d0.Oidb_0x5d0$SnsUpdateItem;

@KeepClassConstructor
/* loaded from: classes11.dex */
public class SpecialCareProcessor extends BaseFriendProcessor {
    static IPatchRedirector $redirector_;

    public SpecialCareProcessor(AppRuntime appRuntime) {
        super(appRuntime);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) appRuntime);
        }
    }

    private static void a(QQAppInterface qQAppInterface, int i3, SpecialCareInfo specialCareInfo, String str, String str2, Set<String> set, List<String> list, List<String> list2) {
        if (i3 != 13573) {
            return;
        }
        try {
            if (TextUtils.isEmpty(str2)) {
                specialCareInfo.globalSwitch = 0;
                if (set != null && set.contains(str)) {
                    list.add(str);
                }
                if (list2 != null && e.q(str, qQAppInterface)) {
                    list2.add(str);
                    return;
                }
                return;
            }
            specialCareInfo.globalSwitch = 1;
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.w("IMCore.friend.SpecialCareFriendProces", 2, "updateSpecialCareGlobalSwitch initSpecialCareInfo|exception = ", e16);
            }
        }
    }

    private static void b(QQAppInterface qQAppInterface, int i3, Oidb_0x5d0$SnsUpdateItem oidb_0x5d0$SnsUpdateItem, String str, String str2, Set<String> set, List<String> list, List<String> list2, Map<String, Integer> map, List<String> list3, SpecialCareInfo specialCareInfo) {
        if (i3 != 13568) {
            return;
        }
        String stringUtf8 = oidb_0x5d0$SnsUpdateItem.bytes_value.get().toStringUtf8();
        if (stringUtf8 != null && stringUtf8.length() != 0) {
            try {
                int parseInt = Integer.parseInt(stringUtf8);
                list.add(str);
                map.put(str, Integer.valueOf(parseInt));
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.i("IMCore.friend.SpecialCareFriendProces", 2, "updateSpecialCareSoundBatch dealWithRespSound|exception = " + e16.toString());
                }
            }
        } else {
            if (set != null && set.contains(str)) {
                list2.add(str);
            }
            if (e.q(str, qQAppInterface)) {
                list3.add(str);
            }
            if (QLog.isColorLevel()) {
                QLog.d("IMCore.friend.SpecialCareFriendProces", 2, "updateSpecialCareSoundBatch: invoked. should turn off sound", " uinStr: ", str);
            }
        }
        try {
            if (TextUtils.isEmpty(str2)) {
                specialCareInfo.specialRingSwitch = 0;
            } else if (Pattern.compile("[0-9]*").matcher(str2).matches()) {
                specialCareInfo.friendRingId = Integer.parseInt(str2);
                specialCareInfo.specialRingSwitch = 1;
            }
        } catch (Exception e17) {
            if (QLog.isColorLevel()) {
                QLog.w("IMCore.friend.SpecialCareFriendProces", 2, "updateSpecialCareSoundBatch initSpecialCareInfo|exception = ", e17);
            }
            specialCareInfo.specialRingSwitch = 0;
        }
        if (QLog.isColorLevel()) {
            QLog.d("IMCore.friend.SpecialCareFriendProces", 2, "updateSpecialCareSoundBatch: invoked(\u65e7\u7684\u7279\u522b\u5173\u5fc3\u94c3\u58f0\u548c\u5f00\u5173\uff0c\u4e0d\u9700\u8981\u540c\u6b65\u5230\u65b0\u7684\u5f00\u5173\u4e0a\uff0c\u65b0\u5f00\u5173\u4ec5\u9002\u75280x350e). friendlist::ring switch & id", " info: ", specialCareInfo, " info.friendRingId: ", Integer.valueOf(specialCareInfo.friendRingId), " info.uin: ", specialCareInfo.uin);
        }
    }

    private static void c(QQAppInterface qQAppInterface, int i3, SpecialCareInfo specialCareInfo, Oidb_0x5d0$SnsUpdateItem oidb_0x5d0$SnsUpdateItem, String str, String str2) {
        if (i3 != 13568) {
            return;
        }
        e.a(str2, oidb_0x5d0$SnsUpdateItem.bytes_value.get().toStringUtf8(), qQAppInterface);
        try {
            if (TextUtils.isEmpty(str)) {
                specialCareInfo.specialRingSwitch = 0;
            } else if (Pattern.compile("[0-9]*").matcher(str).matches()) {
                specialCareInfo.friendRingId = Integer.parseInt(str);
                specialCareInfo.specialRingSwitch = 1;
            }
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.w("IMCore.friend.SpecialCareFriendProces", 2, "updateSpecialCareSoundSingle initSpecialCareInfo|exception = ", e16);
            }
            specialCareInfo.specialRingSwitch = 0;
        }
        if (QLog.isColorLevel()) {
            QLog.d("IMCore.friend.SpecialCareFriendProces", 2, "updateSpecialCareSoundSingle: invoked(\u65e7\u7684\u7279\u522b\u5173\u5fc3\u94c3\u58f0\u548c\u5f00\u5173\uff0c\u4e0d\u9700\u8981\u540c\u6b65\u5230\u65b0\u7684\u5f00\u5173\u4e0a\uff0c\u65b0\u5f00\u5173\u4ec5\u9002\u75280x350e). friendlist::ring switch & id", " specialCareInfo: ", specialCareInfo);
        }
    }

    private static void d(int i3, SpecialCareInfo specialCareInfo, String str) {
        if (i3 != 13572) {
            return;
        }
        try {
            if (TextUtils.isEmpty(str)) {
                specialCareInfo.qzoneSwitch = 0;
            } else {
                specialCareInfo.qzoneSwitch = 1;
            }
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.w("IMCore.friend.SpecialCareFriendProces", 2, "updateSpecialCareZoneSwitch initSpecialCareInfo|exception = ", e16);
            }
        }
    }

    @Override // com.tencent.mobileqq.friend.processor.BaseFriendProcessor
    public void onBatchUpdateExtensionInfo(List<Pair<ExtensionInfo, FriendInfo>> list, com.tencent.mobileqq.friend.data.a aVar, long j3, boolean z16) {
        ArrayList arrayList;
        Set<String> set;
        ArrayList arrayList2;
        HashMap hashMap;
        ArrayList arrayList3;
        ArrayList arrayList4;
        ArrayList arrayList5;
        SpecialCareInfo specialCareInfo;
        String str;
        Set<String> set2;
        ArrayList arrayList6;
        HashMap hashMap2;
        ArrayList arrayList7;
        ArrayList arrayList8;
        SpecialCareInfo specialCareInfo2;
        SpecialCareProcessor specialCareProcessor = this;
        long j16 = j3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, specialCareProcessor, list, aVar, Long.valueOf(j3), Boolean.valueOf(z16));
            return;
        }
        AppRuntime appRuntime = specialCareProcessor.mApp;
        if (!(appRuntime instanceof QQAppInterface)) {
            QLog.d("IMCore.friend.SpecialCareFriendProces", 1, "onGetExtensionInfoResp| app is not QQAppInterface");
            return;
        }
        QQAppInterface qQAppInterface = (QQAppInterface) appRuntime;
        ArrayList arrayList9 = new ArrayList();
        ArrayList arrayList10 = new ArrayList();
        ArrayList arrayList11 = new ArrayList();
        HashMap hashMap3 = new HashMap();
        ArrayList arrayList12 = new ArrayList();
        Set<String> n3 = e.n(qQAppInterface);
        for (Pair<ExtensionInfo, FriendInfo> pair : list) {
            FriendInfo friendInfo = (FriendInfo) pair.second;
            String valueOf = String.valueOf(friendInfo.friendUin);
            Oidb_0x5d0$SnsUpateBuffer parseSnsUpdateBuffer = specialCareProcessor.parseSnsUpdateBuffer(friendInfo.vecRing);
            if (parseSnsUpdateBuffer != null && parseSnsUpdateBuffer.rpt_msg_sns_update_item.has()) {
                SpecialCareInfo specialCareInfo3 = new SpecialCareInfo();
                specialCareInfo3.uin = valueOf;
                specialCareInfo3.dateTime = j16;
                for (Oidb_0x5d0$SnsUpdateItem oidb_0x5d0$SnsUpdateItem : parseSnsUpdateBuffer.rpt_msg_sns_update_item.get()) {
                    if (oidb_0x5d0$SnsUpdateItem != null && oidb_0x5d0$SnsUpdateItem.uint32_update_sns_type.has() && oidb_0x5d0$SnsUpdateItem.bytes_value.has()) {
                        int i3 = oidb_0x5d0$SnsUpdateItem.uint32_update_sns_type.get();
                        String stringUtf8 = oidb_0x5d0$SnsUpdateItem.bytes_value.get().toStringUtf8();
                        if (i3 == 13568) {
                            specialCareInfo2 = specialCareInfo3;
                            str = valueOf;
                            set2 = n3;
                            arrayList6 = arrayList12;
                            hashMap2 = hashMap3;
                            arrayList5 = arrayList9;
                            arrayList7 = arrayList11;
                            arrayList8 = arrayList10;
                            b(qQAppInterface, i3, oidb_0x5d0$SnsUpdateItem, valueOf, stringUtf8, n3, arrayList9, arrayList11, hashMap3, arrayList6, specialCareInfo2);
                        } else {
                            arrayList5 = arrayList9;
                            specialCareInfo2 = specialCareInfo3;
                            str = valueOf;
                            set2 = n3;
                            arrayList6 = arrayList12;
                            hashMap2 = hashMap3;
                            arrayList7 = arrayList11;
                            arrayList8 = arrayList10;
                            if (i3 == 13573) {
                                a(qQAppInterface, i3, specialCareInfo2, str, stringUtf8, null, null, null);
                            } else if (i3 == 13572) {
                                specialCareInfo = specialCareInfo2;
                                d(i3, specialCareInfo, stringUtf8);
                            }
                        }
                        specialCareInfo = specialCareInfo2;
                    } else {
                        arrayList5 = arrayList9;
                        specialCareInfo = specialCareInfo3;
                        str = valueOf;
                        set2 = n3;
                        arrayList6 = arrayList12;
                        hashMap2 = hashMap3;
                        arrayList7 = arrayList11;
                        arrayList8 = arrayList10;
                    }
                    arrayList10 = arrayList8;
                    n3 = set2;
                    arrayList12 = arrayList6;
                    arrayList11 = arrayList7;
                    specialCareInfo3 = specialCareInfo;
                    valueOf = str;
                    hashMap3 = hashMap2;
                    arrayList9 = arrayList5;
                }
                arrayList = arrayList9;
                SpecialCareInfo specialCareInfo4 = specialCareInfo3;
                set = n3;
                arrayList2 = arrayList12;
                hashMap = hashMap3;
                arrayList3 = arrayList11;
                arrayList4 = arrayList10;
                if (specialCareInfo4.globalSwitch != 0) {
                    arrayList4.add(specialCareInfo4);
                }
            } else {
                arrayList = arrayList9;
                set = n3;
                arrayList2 = arrayList12;
                hashMap = hashMap3;
                arrayList3 = arrayList11;
                arrayList4 = arrayList10;
                if (set != null && set.contains(valueOf)) {
                    arrayList3.add(valueOf);
                }
                if (e.q(valueOf, qQAppInterface)) {
                    arrayList2.add(valueOf);
                }
            }
            arrayList10 = arrayList4;
            n3 = set;
            arrayList12 = arrayList2;
            arrayList11 = arrayList3;
            hashMap3 = hashMap;
            arrayList9 = arrayList;
            specialCareProcessor = this;
            j16 = j3;
        }
        ((FriendsManager) specialCareProcessor.mApp.getManager(QQManagerFactory.FRIENDS_MANAGER)).D0(arrayList10, j3, z16);
        e.g(arrayList9, qQAppInterface);
        e.c(arrayList11, qQAppInterface);
        e.k(hashMap3, qQAppInterface);
        e.e(arrayList12, qQAppInterface);
    }

    @Override // com.tencent.mobileqq.friend.processor.BaseFriendProcessor
    public void onGetFriendListFinish(boolean z16, ArrayList<String> arrayList, com.tencent.mobileqq.friend.data.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, Boolean.valueOf(z16), arrayList, aVar);
        } else {
            QQAppInterface qQAppInterface = (QQAppInterface) this.mApp;
            ((FriendListHandler) qQAppInterface.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER)).deleteStrangerInfo((FriendsManager) qQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER));
        }
    }

    @Override // com.tencent.mobileqq.friend.processor.BaseFriendProcessor
    public void onUpdateExtensionInfo(ExtensionInfo extensionInfo, FriendInfo friendInfo, com.tencent.mobileqq.friend.data.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, extensionInfo, friendInfo, aVar);
            return;
        }
        AppRuntime appRuntime = this.mApp;
        if (!(appRuntime instanceof QQAppInterface)) {
            QLog.e("IMCore.friend.SpecialCareFriendProces", 1, "onGetExtensionInfoResp| app is not QQAppInterface");
            return;
        }
        QQAppInterface qQAppInterface = (QQAppInterface) appRuntime;
        String valueOf = String.valueOf(friendInfo.friendUin);
        Oidb_0x5d0$SnsUpateBuffer parseSnsUpdateBuffer = parseSnsUpdateBuffer(friendInfo.vecRing);
        if (parseSnsUpdateBuffer != null && parseSnsUpdateBuffer.rpt_msg_sns_update_item.has()) {
            SpecialCareInfo specialCareInfo = new SpecialCareInfo();
            specialCareInfo.uin = valueOf;
            specialCareInfo.dateTime = 0L;
            for (Oidb_0x5d0$SnsUpdateItem oidb_0x5d0$SnsUpdateItem : parseSnsUpdateBuffer.rpt_msg_sns_update_item.get()) {
                if (oidb_0x5d0$SnsUpdateItem != null && oidb_0x5d0$SnsUpdateItem.uint32_update_sns_type.has() && oidb_0x5d0$SnsUpdateItem.bytes_value.has()) {
                    int i3 = oidb_0x5d0$SnsUpdateItem.uint32_update_sns_type.get();
                    String stringUtf8 = oidb_0x5d0$SnsUpdateItem.bytes_value.get().toStringUtf8();
                    if (i3 == 13568) {
                        c(qQAppInterface, i3, specialCareInfo, oidb_0x5d0$SnsUpdateItem, stringUtf8, valueOf);
                    } else if (i3 == 13573) {
                        a(qQAppInterface, i3, specialCareInfo, valueOf, stringUtf8, null, null, null);
                    } else if (i3 == 13572) {
                        d(i3, specialCareInfo, stringUtf8);
                    }
                }
            }
            return;
        }
        if (e.p(valueOf, qQAppInterface)) {
            e.b(valueOf, qQAppInterface);
        }
        if (e.q(valueOf, qQAppInterface)) {
            e.d(valueOf, qQAppInterface);
        }
    }
}
