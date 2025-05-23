package com.tencent.mobileqq.app.utils;

import android.content.Context;
import android.content.Intent;
import android.os.Message;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.ChatSettingFragment;
import com.tencent.mobileqq.activity.home.Conversation;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.LogTag;
import com.tencent.mobileqq.app.MessageHandlerUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.profilecard.api.ProfileContants;
import com.tencent.mobileqq.profilesetting.ProfileCardMoreActivity;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.util.az;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.HighFreqLogUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.plugins.ReportPlugin;
import com.tencent.qqnt.chats.biz.hiddenchat.IHiddenChatApi;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;
import tencent.im.oidb.cmd0x5d6.oidb_0x5d6$SnsUpateResult;
import tencent.im.s2c.msgtype0x210.submsgtype0x27.SubMsgType0x27$SnsUpdateItem;

/* compiled from: P */
/* loaded from: classes11.dex */
public class FriendsStatusUtil {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public static HighFreqLogUtil f196577a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(70747);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f196577a = new HighFreqLogUtil(2);
        }
    }

    public static void a(boolean z16, String str, QQAppInterface qQAppInterface) {
        String qqStr;
        if (z16) {
            qqStr = HardCodeUtil.qqStr(R.string.mtw);
        } else {
            qqStr = HardCodeUtil.qqStr(R.string.mtz);
        }
        com.tencent.mobileqq.graytip.g gVar = new com.tencent.mobileqq.graytip.g(str, qQAppInterface.getCurrentAccountUin(), qqStr, 0, MessageRecord.MSG_TYPE_UNITE_TAB_HISTORI_INVI, 655385, 0L);
        MessageForUniteGrayTip messageForUniteGrayTip = new MessageForUniteGrayTip();
        messageForUniteGrayTip.initGrayTipMsg(qQAppInterface, gVar);
        if (!((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("switch_remove_add_do_not_disturb_gray_tips", true)) {
            com.tencent.mobileqq.graytip.f.a(qQAppInterface, messageForUniteGrayTip);
        }
        if (QLog.isColorLevel()) {
            QLog.d("FriendsStatusUtil", 2, "isOpen=", Boolean.valueOf(z16), "friendUin=", str);
        }
    }

    public static void b(Map<String, Boolean> map, QQAppInterface qQAppInterface, boolean z16) {
        f196577a.d(LogTag.TAG_HIDDEN_CHAT, 1, "HiddenChat batchUpdateHiddenChat: " + z16);
        ArrayList<com.tencent.qqnt.chats.data.d> arrayList = new ArrayList<>();
        ArrayList<com.tencent.qqnt.chats.data.d> arrayList2 = new ArrayList<>();
        for (Map.Entry<String, Boolean> entry : map.entrySet()) {
            if (entry.getValue() != null) {
                f196577a.d(LogTag.TAG_HIDDEN_CHAT, 1, "batchUpdateHiddenChat getFriendHidden:  " + entry.getKey());
                com.tencent.qqnt.chats.data.d k3 = com.tencent.mobileqq.app.nthiddenchat.b.k(entry.getKey(), entry.getValue().booleanValue(), 0);
                if (entry.getValue().booleanValue()) {
                    arrayList.add(k3);
                } else {
                    arrayList2.add(k3);
                }
                p(qQAppInterface, entry.getValue().booleanValue(), entry.getKey(), null);
            }
        }
        f196577a.d(LogTag.TAG_HIDDEN_CHAT, 1, "begin To NT Hidden Friend " + arrayList.size() + ", del=" + arrayList2.size());
        if (!arrayList.isEmpty()) {
            ((IHiddenChatApi) QRoute.api(IHiddenChatApi.class)).setHiddenChat(qQAppInterface.getCurrentUin(), arrayList);
        }
        if (!arrayList2.isEmpty()) {
            ((IHiddenChatApi) QRoute.api(IHiddenChatApi.class)).delHiddenChat(qQAppInterface.getCurrentUin(), arrayList2);
        }
    }

    public static boolean c(Context context) {
        return az.b(context);
    }

    public static int d(Context context) {
        int readValueForInt = SettingCloneUtil.readValueForInt(context, null, AppConstants.Preferences.NO_DISTURB_MODE, AppConstants.QQSETTING_NODISTURB_MODE_KEY, 0);
        int serverTime = (int) NetConnInfoCenter.getServerTime();
        if (QLog.isColorLevel()) {
            QLog.d("FriendsStatusUtil", 4, "canDisturb curServerTime = [" + serverTime + "] isNoDisturbMode=" + readValueForInt);
        }
        if (serverTime > readValueForInt) {
            return 0;
        }
        return readValueForInt - serverTime;
    }

    public static boolean e(SubMsgType0x27$SnsUpdateItem subMsgType0x27$SnsUpdateItem, QQAppInterface qQAppInterface, String str) {
        if (subMsgType0x27$SnsUpdateItem.uint32_update_sns_type.get() == 13578) {
            UpdateFriendStatusItem updateFriendStatusItem = new UpdateFriendStatusItem(str, 13578, 18);
            if (!subMsgType0x27$SnsUpdateItem.bytes_value.has()) {
                updateFriendStatusItem.e(null);
            } else {
                updateFriendStatusItem.e(subMsgType0x27$SnsUpdateItem.bytes_value.get().toByteArray());
            }
            h(qQAppInterface, updateFriendStatusItem, null);
            return true;
        }
        if (subMsgType0x27$SnsUpdateItem.uint32_update_sns_type.get() == 13581) {
            UpdateFriendStatusItem updateFriendStatusItem2 = new UpdateFriendStatusItem(str, ProfileContants.FIELD_HIDDEN_CHAT_SWITCH, 21);
            if (subMsgType0x27$SnsUpdateItem.bytes_value.has() && subMsgType0x27$SnsUpdateItem.bytes_value.get().toByteArray().length != 0) {
                updateFriendStatusItem2.e(subMsgType0x27$SnsUpdateItem.bytes_value.get().toByteArray());
            } else {
                updateFriendStatusItem2.e(null);
            }
            f196577a.d(LogTag.TAG_HIDDEN_CHAT, 1, "handelFriendStatusPush gogo push push");
            h(qQAppInterface, updateFriendStatusItem2, null);
            return true;
        }
        if (subMsgType0x27$SnsUpdateItem.uint32_update_sns_type.get() == 13579) {
            if (QLog.isColorLevel()) {
                QLog.d("FriendsStatusUtil", 2, "\u514d\u6253\u6270\u5728\u7ebfpush");
            }
            UpdateFriendStatusItem updateFriendStatusItem3 = new UpdateFriendStatusItem(str, 13579, 19);
            updateFriendStatusItem3.f(subMsgType0x27$SnsUpdateItem.bytes_value.get().toByteArray());
            h(qQAppInterface, updateFriendStatusItem3, null);
            return true;
        }
        if (subMsgType0x27$SnsUpdateItem.uint32_update_sns_type.get() == 13582) {
            if (QLog.isColorLevel()) {
                QLog.i("FriendsStatusUtil", 2, "handelFriendStatusPush: invoked. from online push  snsItem: " + subMsgType0x27$SnsUpdateItem);
            }
            UpdateFriendStatusItem updateFriendStatusItem4 = new UpdateFriendStatusItem(str, ReportPlugin.REPORT_EVENT_JS_EXCEPTION, 21);
            updateFriendStatusItem4.f(subMsgType0x27$SnsUpdateItem.bytes_value.get().toByteArray());
            h(qQAppInterface, updateFriendStatusItem4, null);
            return true;
        }
        if (subMsgType0x27$SnsUpdateItem.uint32_update_sns_type.get() == 13580) {
            QLog.i("FriendsStatusUtil", 2, "handelFriendStatusPush: invoked. from online push  UPDATE_SNS_TYPE_RING_ID");
            UpdateFriendStatusItem updateFriendStatusItem5 = new UpdateFriendStatusItem(str, 13580, 21);
            updateFriendStatusItem5.f(subMsgType0x27$SnsUpdateItem.bytes_value.get().toByteArray());
            h(qQAppInterface, updateFriendStatusItem5, null);
            return true;
        }
        return false;
    }

    public static void f(int i3, boolean z16, List<UpdateFriendStatusItem> list, List<oidb_0x5d6$SnsUpateResult> list2, QQAppInterface qQAppInterface, boolean z17) {
        if (i3 == 18) {
            i(z16, list, list2, qQAppInterface);
        } else if (i3 == 19) {
            g(z16, list, list2, qQAppInterface, z17);
        }
    }

    private static void g(boolean z16, List<UpdateFriendStatusItem> list, List<oidb_0x5d6$SnsUpateResult> list2, QQAppInterface qQAppInterface, boolean z17) {
        boolean z18;
        if (QLog.isColorLevel()) {
            QLog.d("FriendsStatusUtil", 2, "handleDoNotDisturb successFromServer: " + z16);
        }
        if (!z16) {
            for (UpdateFriendStatusItem updateFriendStatusItem : list) {
                u(qQAppInterface, updateFriendStatusItem.f196578d, 0, updateFriendStatusItem.f196582i, false, false, null, z17);
            }
            x(qQAppInterface);
            qQAppInterface.runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.app.utils.FriendsStatusUtil.3
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this);
                    } else {
                        QQToast.makeText(BaseApplication.getContext(), HardCodeUtil.qqStr(R.string.f172028mu0), 0).show(BaseApplication.getContext().getResources().getDimensionPixelSize(R.dimen.title_bar_height));
                    }
                }
            });
            return;
        }
        boolean z19 = false;
        for (oidb_0x5d6$SnsUpateResult oidb_0x5d6_snsupateresult : list2) {
            for (UpdateFriendStatusItem updateFriendStatusItem2 : list) {
                if (oidb_0x5d6_snsupateresult.uint64_uin.get() == Long.parseLong(updateFriendStatusItem2.f196578d)) {
                    if (QLog.isColorLevel()) {
                        QLog.d("FriendsStatusUtil", 2, "handleDoNotDisturb uin: " + updateFriendStatusItem2.f196578d + " result: " + oidb_0x5d6_snsupateresult.uint32_result.get());
                    }
                    if (oidb_0x5d6_snsupateresult.uint32_result.get() != 0) {
                        if (updateFriendStatusItem2.g() > 0) {
                            updateFriendStatusItem2.b(0L);
                        } else {
                            updateFriendStatusItem2.b(updateFriendStatusItem2.f196582i);
                        }
                        u(qQAppInterface, updateFriendStatusItem2.f196578d, 0, updateFriendStatusItem2.g(), false, false, null, z17);
                        z19 = true;
                    } else {
                        if (updateFriendStatusItem2.g() != 0) {
                            z18 = true;
                        } else {
                            z18 = false;
                        }
                        a(z18, updateFriendStatusItem2.f196578d, qQAppInterface);
                    }
                }
            }
        }
        if (z19) {
            x(qQAppInterface);
            qQAppInterface.runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.app.utils.FriendsStatusUtil.4
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this);
                    } else {
                        QQToast.makeText(BaseApplication.getContext(), HardCodeUtil.qqStr(R.string.mtv), 0).show(BaseApplication.getContext().getResources().getDimensionPixelSize(R.dimen.title_bar_height));
                    }
                }
            });
        }
    }

    public static void h(QQAppInterface qQAppInterface, UpdateFriendStatusItem updateFriendStatusItem, @Nullable ExtensionInfo extensionInfo) {
        boolean z16;
        int i3 = updateFriendStatusItem.f196579e;
        if (i3 == 18) {
            if (r(qQAppInterface, updateFriendStatusItem, extensionInfo)) {
                if (QLog.isColorLevel()) {
                    QLog.d("FriendsStatusUtil", 4, "handlePush differ from db");
                }
                w(qQAppInterface, updateFriendStatusItem.f196578d, 0, updateFriendStatusItem.g(), false, true, extensionInfo);
                return;
            }
            return;
        }
        if (i3 == 19) {
            if (n(qQAppInterface, updateFriendStatusItem, extensionInfo)) {
                if (QLog.isColorLevel()) {
                    QLog.d("FriendsStatusUtil", 4, "handlePush differ from db");
                }
                t(qQAppInterface, updateFriendStatusItem.f196578d, 0, updateFriendStatusItem.g(), false, true, extensionInfo);
                return;
            }
            return;
        }
        if (i3 == 21) {
            if (updateFriendStatusItem.f196580f == 13581) {
                f196577a.d(LogTag.TAG_HIDDEN_CHAT, 1, "UPDATE_SNS_TYPE_HIDDEN_SESSION " + updateFriendStatusItem.f196578d);
                if (updateFriendStatusItem.a() != null && updateFriendStatusItem.a().length >= 1 && updateFriendStatusItem.a()[0] > 0) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                o(qQAppInterface, z16, updateFriendStatusItem.f196578d);
            }
            if (updateFriendStatusItem.f196580f == 13582) {
                if (QLog.isColorLevel()) {
                    QLog.d("FriendsStatusUtil", 2, "handleC2COnlinePush: invoked. NotificationSettings switch, inc update NotificationSettings ", " item.update_sns_type: ", Integer.valueOf(updateFriendStatusItem.f196580f));
                }
                q(qQAppInterface, updateFriendStatusItem.a(), updateFriendStatusItem.f196578d, extensionInfo);
            }
            try {
                if (updateFriendStatusItem.f196580f == 13580) {
                    QLog.d("FriendsStatusUtil", 2, "handleC2COnlinePush: invoked. UPDATE_SNS_TYPE_RING_ID", " ringId: ", Integer.valueOf((int) updateFriendStatusItem.g()));
                }
            } catch (Throwable th5) {
                QLog.e("FriendsStatusUtil", 1, "handlePush: failed. ", th5);
            }
        }
    }

    private static void i(boolean z16, List<UpdateFriendStatusItem> list, List<oidb_0x5d6$SnsUpateResult> list2, QQAppInterface qQAppInterface) {
        if (QLog.isColorLevel()) {
            QLog.d("FriendsStatusUtil", 2, "handleTopPosition successFromServer: " + z16);
        }
        if (!z16) {
            Iterator<UpdateFriendStatusItem> it = list.iterator();
            while (it.hasNext()) {
                l(qQAppInterface, it.next().f196578d);
            }
            qQAppInterface.runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.app.utils.FriendsStatusUtil.1
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this);
                    } else {
                        QQToast.makeText(BaseApplication.getContext(), HardCodeUtil.qqStr(R.string.f172029mu1), 0).show(BaseApplication.getContext().getResources().getDimensionPixelSize(R.dimen.title_bar_height));
                    }
                }
            });
            return;
        }
        boolean z17 = false;
        for (oidb_0x5d6$SnsUpateResult oidb_0x5d6_snsupateresult : list2) {
            for (UpdateFriendStatusItem updateFriendStatusItem : list) {
                if (oidb_0x5d6_snsupateresult.uint64_uin.get() == Long.parseLong(updateFriendStatusItem.f196578d)) {
                    if (QLog.isColorLevel()) {
                        QLog.d("FriendsStatusUtil", 2, "handleTopPosition uin: " + updateFriendStatusItem.f196578d + " result: " + oidb_0x5d6_snsupateresult.uint32_result.get());
                    }
                    if (oidb_0x5d6_snsupateresult.uint32_result.get() != 0) {
                        z17 = true;
                    } else {
                        v(qQAppInterface, updateFriendStatusItem.f196578d, 0, updateFriendStatusItem.g(), true, false);
                        l(qQAppInterface, updateFriendStatusItem.f196578d);
                    }
                }
            }
        }
        if (z17) {
            qQAppInterface.runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.app.utils.FriendsStatusUtil.2
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this);
                    } else {
                        QQToast.makeText(BaseApplication.getContext(), HardCodeUtil.qqStr(R.string.mtx), 0).show(BaseApplication.getContext().getResources().getDimensionPixelSize(R.dimen.title_bar_height));
                    }
                }
            });
        }
        x(qQAppInterface);
    }

    public static boolean j(QQAppInterface qQAppInterface, String str, int i3) {
        RecentUserProxy m3 = qQAppInterface.getProxyManager().m();
        if (str != null && str.length() != 0 && m3 != null) {
            RecentUser findRecentUser = m3.findRecentUser(str, i3);
            if (findRecentUser != null) {
                if (QLog.isColorLevel()) {
                    QLog.d("FriendsStatusUtil", 2, "isChatAtTop result is: " + findRecentUser.showUpTime);
                }
                if (findRecentUser.showUpTime <= 0) {
                    return false;
                }
                return true;
            }
            ExtensionInfo H = ((FriendsManager) qQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER)).H(str);
            if (H == null) {
                return false;
            }
            if (QLog.isColorLevel()) {
                QLog.d("FriendsStatusUtil", 2, "isChatAtTop extensionInfo is: " + H.topPositionTime);
            }
            if (H.topPositionTime <= 0) {
                return false;
            }
            return true;
        }
        if (QLog.isColorLevel()) {
            QLog.d("FriendsStatusUtil", 2, "isChatAtTop params error, return false.");
        }
        return false;
    }

    public static boolean k(@NonNull String str, AppInterface appInterface) {
        ExtensionInfo H;
        FriendsManager friendsManager = (FriendsManager) appInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
        if (!friendsManager.c0(str) || (H = friendsManager.H(str)) == null || H.openDoNotDisturbTime <= 0) {
            return false;
        }
        return true;
    }

    public static void l(QQAppInterface qQAppInterface, String str) {
        MqqHandler handler = qQAppInterface.getHandler(ChatSettingFragment.class);
        if (handler != null) {
            Message message = new Message();
            message.what = 35;
            message.obj = str;
            handler.sendMessage(message);
        }
    }

    public static void m(QQAppInterface qQAppInterface, String str, int i3) {
        MqqHandler handler = qQAppInterface.getHandler(ChatSettingFragment.class);
        if (handler != null) {
            Message message = new Message();
            message.what = 36;
            message.obj = str;
            message.arg1 = i3;
            handler.sendMessage(message);
        }
        MqqHandler handler2 = qQAppInterface.getHandler(ProfileCardMoreActivity.class);
        if (handler2 != null) {
            Message message2 = new Message();
            message2.what = 36;
            message2.obj = str;
            message2.arg1 = i3;
            handler2.sendMessage(message2);
        }
    }

    public static boolean n(QQAppInterface qQAppInterface, UpdateFriendStatusItem updateFriendStatusItem, @Nullable ExtensionInfo extensionInfo) {
        FriendsManager friendsManager = (FriendsManager) qQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
        if (extensionInfo == null && (extensionInfo = friendsManager.H(String.valueOf(updateFriendStatusItem.f196578d))) == null) {
            extensionInfo = new ExtensionInfo();
            extensionInfo.uin = String.valueOf(updateFriendStatusItem.f196578d);
            if (QLog.isColorLevel()) {
                QLog.d("FriendsStatusUtil", 4, "saveFriendDoNotDisturbToDataBase new create");
            }
        }
        long g16 = updateFriendStatusItem.g();
        if (QLog.isColorLevel()) {
            QLog.d("FriendsStatusUtil", 4, "saveFriendDoNotDisturbToDataBase DB openDoNotDisturbTime=", Long.valueOf(extensionInfo.openDoNotDisturbTime), " update time=", Long.valueOf(g16), " uin=", updateFriendStatusItem.f196578d);
        }
        if (extensionInfo.openDoNotDisturbTime == g16) {
            return false;
        }
        extensionInfo.openDoNotDisturbTime = g16;
        friendsManager.v0(extensionInfo);
        return true;
    }

    public static void o(QQAppInterface qQAppInterface, boolean z16, String str) {
        f196577a.d(LogTag.TAG_HIDDEN_CHAT, 1, "saveHiddenFlagSwitchToExtensionInfo(), uin:" + MobileQQ.getShortUinStr(str) + " value:" + (z16 ? 1 : 0));
        z(qQAppInterface, str, 0, z16 ? 1 : 0);
    }

    public static boolean p(QQAppInterface qQAppInterface, boolean z16, String str, @Nullable ExtensionInfo extensionInfo) {
        FriendsManager friendsManager = (FriendsManager) qQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
        if (extensionInfo == null && (extensionInfo = friendsManager.H(String.valueOf(str))) == null) {
            extensionInfo = new ExtensionInfo();
            extensionInfo.uin = String.valueOf(str);
            if (QLog.isColorLevel()) {
                f196577a.d(LogTag.TAG_HIDDEN_CHAT, 4, "saveNTHiddenFlagSwitchToExtensionInfo new create ");
            }
        }
        f196577a.d(LogTag.TAG_HIDDEN_CHAT, 1, "saveNTHiddenFlagSwitchToExtensionInfo(), uin:" + MobileQQ.getShortUinStr(str) + " value:" + (z16 ? 1 : 0));
        if (extensionInfo.hiddenChatSwitch != z16) {
            extensionInfo.hiddenChatSwitch = z16 ? 1 : 0;
            friendsManager.v0(extensionInfo);
            return true;
        }
        return false;
    }

    public static boolean q(QQAppInterface qQAppInterface, byte[] bArr, String str, @Nullable ExtensionInfo extensionInfo) {
        ExtensionInfo extensionInfo2;
        int i3;
        int i16;
        int i17;
        FriendsManager friendsManager = (FriendsManager) qQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
        if (extensionInfo == null) {
            extensionInfo2 = friendsManager.H(String.valueOf(str));
            if (extensionInfo2 == null) {
                extensionInfo2 = new ExtensionInfo();
                extensionInfo2.uin = String.valueOf(str);
                if (QLog.isColorLevel()) {
                    QLog.d(LogTag.TAG_MSG_NOTIFICATION, 4, "saveSwitchToExtensionInfo new create ");
                }
            }
        } else {
            extensionInfo2 = extensionInfo;
        }
        if (bArr == null || bArr.length < 2) {
            return false;
        }
        byte b16 = bArr[1];
        if ((b16 & 1) == 0) {
            i3 = 1;
        } else {
            i3 = 0;
        }
        if ((b16 & 2) == 0) {
            i16 = 1;
        } else {
            i16 = 0;
        }
        if ((b16 & 4) == 0) {
            i17 = 1;
        } else {
            i17 = 0;
        }
        if (QLog.isColorLevel()) {
            QLog.d("FriendsStatusUtil", 2, "saveNotificationFlagSwitchToExtensionInfo: invoked. ", " byte1: ", Byte.valueOf(b16), " uin: ", str);
        }
        int i18 = i3 ^ 1;
        int i19 = i16 ^ 1;
        int i26 = i17 ^ 1;
        if (QLog.isColorLevel()) {
            QLog.d("FriendsStatusUtil", 2, "saveNotificationFlagSwitchToExtensionInfo: invoked. ", " messageEnablePreviewValue: ", Integer.valueOf(i18), " messageEnableVibrateValue: ", Integer.valueOf(i19), " messageEnableSoundValue: ", Integer.valueOf(i26));
        }
        if (extensionInfo2.messageEnablePreviewNew == i18 && extensionInfo2.messageEnableVibrateNew == i19 && extensionInfo2.messageEnableSoundNew == i26) {
            return false;
        }
        extensionInfo2.messageEnablePreviewNew = i18;
        extensionInfo2.messageEnableVibrateNew = i19;
        extensionInfo2.messageEnableSoundNew = i26;
        friendsManager.v0(extensionInfo2);
        if (QLog.isColorLevel()) {
            QLog.d("FriendsStatusUtil", 2, "saveNotificationFlagSwitchToExtensionInfo: invoked. switch changed. ", " messageEnableSoundValue: ", Integer.valueOf(i26));
        }
        return true;
    }

    public static boolean r(QQAppInterface qQAppInterface, UpdateFriendStatusItem updateFriendStatusItem, @Nullable ExtensionInfo extensionInfo) {
        FriendsManager friendsManager = (FriendsManager) qQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
        if (extensionInfo == null && (extensionInfo = friendsManager.H(String.valueOf(updateFriendStatusItem.f196578d))) == null) {
            extensionInfo = new ExtensionInfo();
            extensionInfo.uin = String.valueOf(updateFriendStatusItem.f196578d);
            if (QLog.isColorLevel()) {
                QLog.d("FriendsStatusUtil", 4, "saveTopPositionToDataBase new create");
            }
        }
        long g16 = updateFriendStatusItem.g();
        if (QLog.isColorLevel()) {
            QLog.d("FriendsStatusUtil", 4, "saveTopPositionToDataBase DB TOP=" + extensionInfo.topPositionTime + " update top=" + g16 + " uin=" + updateFriendStatusItem.f196578d);
        }
        if (g16 == -1) {
            return false;
        }
        y(qQAppInterface, updateFriendStatusItem.f196578d, 0, g16);
        if (extensionInfo.topPositionTime == g16) {
            return false;
        }
        extensionInfo.topPositionTime = g16;
        friendsManager.v0(extensionInfo);
        return true;
    }

    public static void s(QQAppInterface qQAppInterface, String str, int i3, long j3, boolean z16, boolean z17) {
        t(qQAppInterface, str, i3, j3, z16, z17, null);
    }

    public static void t(QQAppInterface qQAppInterface, String str, int i3, long j3, boolean z16, boolean z17, @Nullable ExtensionInfo extensionInfo) {
        u(qQAppInterface, str, i3, j3, z16, z17, extensionInfo, false);
    }

    public static void u(QQAppInterface qQAppInterface, String str, int i3, long j3, boolean z16, boolean z17, @Nullable ExtensionInfo extensionInfo, boolean z18) {
        ExtensionInfo extensionInfo2;
        long j16;
        boolean z19;
        boolean z26;
        boolean z27;
        if (QLog.isColorLevel()) {
            QLog.d("FriendsStatusUtil", 4, "setTopPosition operateTime: " + j3 + " uin: " + str + " userType: " + i3 + " needSend" + z16);
        }
        FriendsManager friendsManager = (FriendsManager) qQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
        if (!friendsManager.c0(str)) {
            return;
        }
        if (extensionInfo == null) {
            extensionInfo2 = friendsManager.H(str);
        } else {
            extensionInfo2 = extensionInfo;
        }
        if (extensionInfo2 != null) {
            j16 = extensionInfo2.openDoNotDisturbTime;
        } else {
            j16 = 0;
        }
        if (QLog.isColorLevel()) {
            QLog.d("FriendsStatusUtil", 4, "isOpenDoNotDisturb uin=" + str);
        }
        UpdateFriendStatusItem updateFriendStatusItem = new UpdateFriendStatusItem(str, 13579, 19, j16);
        updateFriendStatusItem.b(j3);
        if (!n(qQAppInterface, updateFriendStatusItem, extensionInfo2) && QLog.isColorLevel()) {
            QLog.d("FriendsStatusUtil", 2, "saveFriendDoNotDisturbToDataBase=false");
        }
        int i16 = 0;
        if (!z16 && z18) {
            Intent intent = new Intent("action_donot_disturb_resp");
            intent.putExtra("key_uin", str);
            if (j3 != 0) {
                z27 = true;
            } else {
                z27 = false;
            }
            intent.putExtra("key_swtich", z27);
            BaseApplication.getContext().sendBroadcast(intent);
            z19 = false;
        } else {
            z19 = z18;
        }
        x(qQAppInterface);
        if (z17) {
            if (j3 != 0) {
                z26 = true;
            } else {
                z26 = false;
            }
            a(z26, str, qQAppInterface);
        }
        if (j3 != 0) {
            i16 = 1;
        }
        m(qQAppInterface, str, i16);
        if (z16) {
            ArrayList<UpdateFriendStatusItem> arrayList = new ArrayList<>(1);
            arrayList.add(updateFriendStatusItem);
            ((FriendListHandler) qQAppInterface.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER)).create0x5d6RequestPackage(updateFriendStatusItem.f196579e, arrayList, "OidbSvc.0x5d6_19", z19);
        }
    }

    public static void v(QQAppInterface qQAppInterface, String str, int i3, long j3, boolean z16, boolean z17) {
        w(qQAppInterface, str, i3, j3, z16, z17, null);
    }

    public static void w(QQAppInterface qQAppInterface, String str, int i3, long j3, boolean z16, boolean z17, @Nullable ExtensionInfo extensionInfo) {
        if (QLog.isColorLevel()) {
            QLog.d("FriendsStatusUtil", 4, "setTopPosition top: " + j3 + " uin: " + str + " userType: " + i3 + " needUpdateDataBase" + z16);
        }
        UpdateFriendStatusItem updateFriendStatusItem = new UpdateFriendStatusItem(str, 13578, 18, 0L);
        updateFriendStatusItem.c(j3);
        if (z16) {
            r(qQAppInterface, updateFriendStatusItem, extensionInfo);
        }
        if (z17) {
            x(qQAppInterface);
            l(qQAppInterface, str);
        }
    }

    public static void x(QQAppInterface qQAppInterface) {
        MqqHandler handler = qQAppInterface.getHandler(Conversation.class);
        if (handler != null) {
            handler.sendEmptyMessage(1009);
        }
    }

    public static void y(QQAppInterface qQAppInterface, String str, int i3, long j3) {
        RecentUserProxy m3 = qQAppInterface.getProxyManager().m();
        RecentUser findRecentUser = m3.findRecentUser(str, i3);
        if (findRecentUser == null) {
            if (j3 > 0) {
                RecentUser recentUser = new RecentUser(str, i3);
                recentUser.showUpTime = j3;
                recentUser.opTime = j3;
                m3.saveRecentUser(recentUser);
                return;
            }
            return;
        }
        findRecentUser.showUpTime = j3;
        findRecentUser.opTime = Math.max(findRecentUser.opTime, j3);
        m3.saveRecentUser(findRecentUser);
    }

    public static void z(QQAppInterface qQAppInterface, String str, int i3, int i16) {
        com.tencent.mobileqq.app.hiddenchat.a c16 = com.tencent.mobileqq.app.hiddenchat.a.c(qQAppInterface);
        boolean z16 = true;
        if (i16 != 1) {
            z16 = false;
        }
        c16.g(str, i3, z16);
    }

    /* compiled from: P */
    /* loaded from: classes11.dex */
    public static class UpdateFriendStatusItem implements Parcelable {
        static IPatchRedirector $redirector_;
        public static final Parcelable.Creator<UpdateFriendStatusItem> CREATOR;

        /* renamed from: d, reason: collision with root package name */
        public String f196578d;

        /* renamed from: e, reason: collision with root package name */
        public int f196579e;

        /* renamed from: f, reason: collision with root package name */
        public int f196580f;

        /* renamed from: h, reason: collision with root package name */
        private byte[] f196581h;

        /* renamed from: i, reason: collision with root package name */
        public long f196582i;

        /* compiled from: P */
        /* loaded from: classes11.dex */
        class a implements Parcelable.Creator<UpdateFriendStatusItem> {
            static IPatchRedirector $redirector_;

            a() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this);
                }
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public UpdateFriendStatusItem createFromParcel(Parcel parcel) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return (UpdateFriendStatusItem) iPatchRedirector.redirect((short) 2, (Object) this, (Object) parcel);
                }
                return new UpdateFriendStatusItem(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public UpdateFriendStatusItem[] newArray(int i3) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                    return (UpdateFriendStatusItem[]) iPatchRedirector.redirect((short) 3, (Object) this, i3);
                }
                return new UpdateFriendStatusItem[i3];
            }
        }

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(70746);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 13)) {
                redirector.redirect((short) 13);
            } else {
                CREATOR = new a();
            }
        }

        public UpdateFriendStatusItem(String str, int i3, int i16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, str, Integer.valueOf(i3), Integer.valueOf(i16));
                return;
            }
            this.f196581h = null;
            this.f196582i = -1L;
            this.f196578d = str;
            this.f196580f = i3;
            this.f196579e = i16;
        }

        public byte[] a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return (byte[]) iPatchRedirector.redirect((short) 7, (Object) this);
            }
            return this.f196581h;
        }

        public void b(long j3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, j3);
                return;
            }
            byte[] bArr = new byte[8];
            this.f196581h = bArr;
            if (j3 > 0) {
                bArr[0] = (byte) ((j3 >> 24) & 255);
                bArr[1] = (byte) ((j3 >> 16) & 255);
                bArr[2] = (byte) ((j3 >> 8) & 255);
                bArr[3] = (byte) (j3 & 255);
                bArr[4] = -1;
                bArr[5] = -1;
                bArr[6] = -1;
                bArr[7] = -1;
            }
        }

        public void c(long j3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, j3);
                return;
            }
            if (j3 > 0) {
                this.f196581h = r0;
                byte[] bArr = {(byte) ((j3 >> 24) & 255), (byte) ((j3 >> 16) & 255), (byte) ((j3 >> 8) & 255), (byte) (j3 & 255)};
            } else if (j3 == 0) {
                this.f196581h = new byte[0];
            } else {
                this.f196581h = null;
            }
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
                return ((Integer) iPatchRedirector.redirect((short) 11, (Object) this)).intValue();
            }
            return 0;
        }

        public void e(byte[] bArr) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, (Object) bArr);
            } else {
                this.f196581h = bArr;
            }
        }

        public void f(byte[] bArr) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, (Object) this, (Object) bArr);
                return;
            }
            if (bArr == null) {
                this.f196581h = new byte[8];
            }
            this.f196581h = bArr;
        }

        public long g() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                return ((Long) iPatchRedirector.redirect((short) 8, (Object) this)).longValue();
            }
            byte[] bArr = this.f196581h;
            if (bArr == null) {
                return -1L;
            }
            if (bArr.length == 0) {
                return 0L;
            }
            if (bArr.length == 4) {
                return MessageHandlerUtils.byteArrToLong(bArr);
            }
            if (bArr.length != 8) {
                return -1L;
            }
            return MessageHandlerUtils.byteArrToLong(Arrays.copyOfRange(bArr, 0, 4));
        }

        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
                return (String) iPatchRedirector.redirect((short) 10, (Object) this);
            }
            return "item:serType=" + this.f196579e + " sns_type=" + this.f196580f + " uin=" + this.f196578d + " serviceTime=" + this.f196581h + " identify=" + super.toString();
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
                iPatchRedirector.redirect((short) 12, (Object) this, (Object) parcel, i3);
                return;
            }
            parcel.writeString(this.f196578d);
            parcel.writeInt(this.f196579e);
            parcel.writeInt(this.f196580f);
            byte[] bArr = this.f196581h;
            if (bArr != null) {
                parcel.writeByteArray(bArr);
            }
        }

        public UpdateFriendStatusItem(String str, int i3, int i16, long j3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, str, Integer.valueOf(i3), Integer.valueOf(i16), Long.valueOf(j3));
                return;
            }
            this.f196581h = null;
            this.f196578d = str;
            this.f196580f = i3;
            this.f196579e = i16;
            this.f196582i = j3;
        }

        protected UpdateFriendStatusItem(Parcel parcel) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                iPatchRedirector.redirect((short) 9, (Object) this, (Object) parcel);
                return;
            }
            this.f196578d = null;
            this.f196579e = 0;
            this.f196580f = -1;
            this.f196581h = null;
            this.f196582i = -1L;
            this.f196578d = parcel.readString();
            this.f196579e = parcel.readInt();
            this.f196580f = parcel.readInt();
            byte[] bArr = this.f196581h;
            if (bArr != null) {
                parcel.readByteArray(bArr);
            }
        }
    }
}
