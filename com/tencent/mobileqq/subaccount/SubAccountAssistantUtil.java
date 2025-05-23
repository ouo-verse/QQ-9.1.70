package com.tencent.mobileqq.subaccount;

import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.data.SubAccountInfo;
import com.tencent.mobileqq.data.SubAccountMessage;
import com.tencent.mobileqq.msg.api.IMessageFacade;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qmmkv.MMKVOptionEntity;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.subaccount.api.ISubAccountConfigApi;
import com.tencent.mobileqq.subaccount.api.ISubAccountControlService;
import com.tencent.mobileqq.subaccount.api.ISubAccountService;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.MsgAbstractElementData;
import com.tencent.qqnt.kernel.nativeinterface.MsgBoxNecessaryMsgInfo;
import com.tencent.qqnt.kernel.nativeinterface.RecentContactData;
import com.tencent.qqnt.kernel.nativeinterface.SpecificEventTypeInfoInMsgBox;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b%\u0010&J:\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u0002H\u0002J \u0010\u0012\u001a\u00020\u00112\u0006\u0010\r\u001a\u00020\b2\u000e\u0010\u0010\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u000eH\u0002J \u0010\u0017\u001a\u0012\u0012\u0004\u0012\u00020\u00150\u0014j\b\u0012\u0004\u0012\u00020\u0015`\u00162\u0006\u0010\u0013\u001a\u00020\u0004H\u0002J\u0010\u0010\u0019\u001a\u00020\u00112\u0006\u0010\u0018\u001a\u00020\u000bH\u0002J\b\u0010\u001a\u001a\u00020\u0004H\u0002J\b\u0010\u001b\u001a\u00020\u0002H\u0002J\b\u0010\u001c\u001a\u0004\u0018\u00010\u000bJ\u000e\u0010\u001e\u001a\u00020\u00112\u0006\u0010\u001d\u001a\u00020\u0002J\u0006\u0010 \u001a\u00020\u001fR\u001b\u0010$\u001a\u00020\u001f8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0017\u0010!\u001a\u0004\b\"\u0010#\u00a8\u0006'"}, d2 = {"Lcom/tencent/mobileqq/subaccount/SubAccountAssistantUtil;", "", "", "peerUin", "", "peerName", "unreadCnt", "abstractContent", "", "specialFlag", "lastMsgTime", "Lcom/tencent/qqnt/kernel/nativeinterface/RecentContactData;", "e", "subUnreadNum", "", "Lcom/tencent/mobileqq/data/SubAccountInfo;", "subAccounts", "", "a", "content", "Ljava/util/ArrayList;", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgAbstractElementData;", "Lkotlin/collections/ArrayList;", "b", "recentContactData", "j", "f", "c", "d", "time", "i", "", "g", "Lkotlin/Lazy;", tl.h.F, "()Z", "isRemoveSwitchOn", "<init>", "()V", "qqsubaccount-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class SubAccountAssistantUtil {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final SubAccountAssistantUtil f291050a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy isRemoveSwitchOn;

    static {
        Lazy lazy;
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(20153);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
            return;
        }
        f291050a = new SubAccountAssistantUtil();
        lazy = LazyKt__LazyJVMKt.lazy(SubAccountAssistantUtil$isRemoveSwitchOn$2.INSTANCE);
        isRemoveSwitchOn = lazy;
    }

    SubAccountAssistantUtil() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final void a(int subUnreadNum, List<? extends SubAccountInfo> subAccounts) {
        if (subUnreadNum == 0) {
            return;
        }
        for (SubAccountInfo subAccountInfo : subAccounts) {
            if (subAccountInfo != null && !TextUtils.isEmpty(subAccountInfo.subuin)) {
                IRuntimeService runtimeService = MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IMessageFacade.class, "");
                Intrinsics.checkNotNullExpressionValue(runtimeService, "app.getRuntimeService(IM\u2026va, ProcessConstant.MAIN)");
                ((IMessageFacade) runtimeService).setReaded(subAccountInfo.subuin, 7000, true, false);
                QLog.i("SubAccountAssistantUtil", 1, "some error clean unread subuin=" + subAccountInfo.subuin);
            }
        }
    }

    private final ArrayList<MsgAbstractElementData> b(String content) {
        MsgAbstractElementData msgAbstractElementData = new MsgAbstractElementData(1, content, "", 0, 0);
        ArrayList<MsgAbstractElementData> arrayList = new ArrayList<>();
        arrayList.add(msgAbstractElementData);
        return arrayList;
    }

    private final long c() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            return -1L;
        }
        String str = "sub_account_last_msg_time_" + peekAppRuntime.getCurrentUin();
        MMKVOptionEntity from = QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations");
        Intrinsics.checkNotNullExpressionValue(from, "from(MobileQQ.sMobileQQ, QMMKVFile.FILE_COMMON)");
        return from.decodeLong(str, 0L);
    }

    private final RecentContactData e(long peerUin, String peerName, long unreadCnt, String abstractContent, int specialFlag, long lastMsgTime) {
        ArrayList arrayListOf;
        ArrayList arrayList = new ArrayList();
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(new MsgBoxNecessaryMsgInfo(0L, lastMsgTime, ""));
        arrayList.add(new SpecificEventTypeInfoInMsgBox(specialFlag, arrayListOf));
        RecentContactData recentContactData = new RecentContactData(AppConstants.SUBACCOUNT_ASSISTANT_UIN, peerUin, peerName, 131, unreadCnt, "", "", 2, b(abstractContent), lastMsgTime, arrayList, null, new ArrayList());
        if (TextUtils.equals(f(), recentContactData.toString())) {
            return null;
        }
        QLog.d("SubAccountAssistantUtil", 2, "getRecentContactData peerUin:" + peerUin + ", unreadCnt:" + unreadCnt + ", lastMsgTime:" + lastMsgTime + ", specialFlag:" + specialFlag + "}");
        j(recentContactData);
        return recentContactData;
    }

    private final String f() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            return "";
        }
        String str = "sub_account_contact_" + peekAppRuntime.getCurrentUin();
        MMKVOptionEntity from = QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations");
        Intrinsics.checkNotNullExpressionValue(from, "from(MobileQQ.sMobileQQ, QMMKVFile.FILE_COMMON)");
        String decodeString = from.decodeString(str, "");
        Intrinsics.checkNotNullExpressionValue(decodeString, "entity.decodeString(key, \"\")");
        return decodeString;
    }

    private final boolean h() {
        return ((Boolean) isRemoveSwitchOn.getValue()).booleanValue();
    }

    private final void j(RecentContactData recentContactData) {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null) {
            String str = "sub_account_contact_" + peekAppRuntime.getCurrentUin();
            MMKVOptionEntity from = QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations");
            Intrinsics.checkNotNullExpressionValue(from, "from(MobileQQ.sMobileQQ, QMMKVFile.FILE_COMMON)");
            from.encodeString(str, recentContactData.toString());
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:43:0x010f, code lost:
    
        if (r15.time < r4.time) goto L57;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x0129, code lost:
    
        if (r8.time < r5.time) goto L66;
     */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0120  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x012f  */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final RecentContactData d() {
        AppInterface appInterface;
        SubAccountInfo subAccountInfo;
        String str;
        String str2;
        long j3;
        int i3;
        long parseLong;
        ISubAccountService iSubAccountService;
        Iterator<SubAccountInfo> it;
        String str3;
        SubAccountMessage subAccountMessage;
        SubAccountMessage subAccountMessage2;
        SubAccountMessage subAccountMessage3;
        SubAccountMessage subAccountMessage4;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (RecentContactData) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime instanceof AppInterface) {
            appInterface = (AppInterface) peekAppRuntime;
        } else {
            appInterface = null;
        }
        int i16 = 1;
        if (appInterface == null) {
            QLog.e("SubAccountAssistantUtil", 1, "app is null");
            return null;
        }
        long c16 = c();
        if (c16 == 0) {
            c16 = com.tencent.mobileqq.service.message.e.K0();
            i(c16);
        } else if (c16 == -1) {
            QLog.i("SubAccountAssistantUtil", 1, "is delete");
            return null;
        }
        long j16 = c16;
        IRuntimeService runtimeService = appInterface.getRuntimeService(ISubAccountService.class, "");
        Intrinsics.checkNotNullExpressionValue(runtimeService, "app.getRuntimeService(IS\u2026va, ProcessConstant.MAIN)");
        ISubAccountService iSubAccountService2 = (ISubAccountService) runtimeService;
        ArrayList<SubAccountInfo> allSubAccountInfo = iSubAccountService2.getAllSubAccountInfo();
        Intrinsics.checkNotNullExpressionValue(allSubAccountInfo, "subMgr.allSubAccountInfo");
        String str4 = "";
        int i17 = 0;
        if (allSubAccountInfo.isEmpty()) {
            String qqStr = HardCodeUtil.qqStr(R.string.f229606ww);
            Intrinsics.checkNotNullExpressionValue(qqStr, "qqStr(com.tencent.mobile\u2026account_no_associated_qq)");
            return e(0L, "", 0L, qqStr, 0, j16);
        }
        Iterator<SubAccountInfo> it5 = allSubAccountInfo.iterator();
        SubAccountMessage subAccountMessage5 = null;
        SubAccountMessage subAccountMessage6 = null;
        SubAccountInfo subAccountInfo2 = null;
        SubAccountInfo subAccountInfo3 = null;
        int i18 = 0;
        int i19 = 0;
        while (it5.hasNext()) {
            SubAccountInfo next = it5.next();
            if (next != null && !TextUtils.isEmpty(next.subuin) && iSubAccountService2.getStatus(next.subuin) == i16) {
                List<SubAccountMessage> allMessage = iSubAccountService2.getAllMessage(next.subuin);
                if (allMessage != null && allMessage.size() > 0) {
                    SubAccountMessage subAccountMessage7 = allMessage.get(0);
                    iSubAccountService = iSubAccountService2;
                    it = it5;
                    if (Intrinsics.areEqual(AppConstants.SUBACCOUNT_TROOP_UIN, subAccountMessage7.senderuin)) {
                        if (allMessage.size() > 1) {
                            subAccountMessage = allMessage.get(1);
                        } else {
                            subAccountMessage = null;
                        }
                    } else {
                        subAccountMessage = subAccountMessage7;
                        subAccountMessage7 = null;
                    }
                    if (subAccountMessage6 != null) {
                        if (subAccountMessage7 != null) {
                            str3 = str4;
                            subAccountMessage4 = subAccountMessage6;
                        } else {
                            str3 = str4;
                            subAccountMessage4 = subAccountMessage6;
                        }
                        subAccountMessage2 = subAccountMessage4;
                        if (subAccountMessage5 == null) {
                            if (subAccountMessage != null) {
                                subAccountMessage3 = subAccountMessage2;
                            } else {
                                subAccountMessage3 = subAccountMessage2;
                            }
                            subAccountMessage6 = subAccountMessage3;
                        } else {
                            subAccountMessage3 = subAccountMessage2;
                        }
                        subAccountInfo3 = next;
                        subAccountMessage6 = subAccountMessage3;
                        subAccountMessage5 = subAccountMessage;
                    } else {
                        str3 = str4;
                    }
                    subAccountInfo2 = next;
                    subAccountMessage2 = subAccountMessage7;
                    if (subAccountMessage5 == null) {
                    }
                    subAccountInfo3 = next;
                    subAccountMessage6 = subAccountMessage3;
                    subAccountMessage5 = subAccountMessage;
                } else {
                    iSubAccountService = iSubAccountService2;
                    it = it5;
                    str3 = str4;
                    subAccountMessage6 = subAccountMessage6;
                }
                ISubAccountControlService.a y16 = h.y(appInterface, next.subuin);
                Intrinsics.checkNotNullExpressionValue(y16, "getUnreadCount(app, sa.subuin)");
                if (y16.f291057b) {
                    i19 += y16.f291056a;
                } else {
                    i18 += y16.f291056a;
                }
                iSubAccountService2 = iSubAccountService;
                it5 = it;
                str4 = str3;
            } else {
                iSubAccountService2 = iSubAccountService2;
                it5 = it5;
                str4 = str4;
                subAccountMessage6 = subAccountMessage6;
            }
            i16 = 1;
        }
        String str5 = str4;
        SubAccountMessage subAccountMessage8 = subAccountMessage6;
        QLog.d("SubAccountAssistantUtil", 2, "subUnreadNum = " + i18 + " ,subTroopUnreadNum = " + i19);
        if (i18 <= 0) {
            if (i18 == 0 && i19 > 0) {
                subAccountInfo = subAccountInfo2;
                subAccountMessage5 = subAccountMessage8;
            } else if (i18 != 0 || i19 != 0) {
                subAccountInfo = null;
                subAccountMessage5 = null;
            }
            if (subAccountInfo == null && subAccountMessage5 != null) {
                String qqStr2 = HardCodeUtil.qqStr(R.string.hr8);
                Intrinsics.checkNotNullExpressionValue(qqStr2, "qqStr(com.tencent.mobile\u2026unt_associated_qq_no_msg)");
                QLog.d("SubAccountAssistantUtil", 2, "subUin=" + subAccountInfo.subuin);
                if (i18 <= 0 && i19 != 0) {
                    if (!((ISubAccountConfigApi) QRoute.api(ISubAccountConfigApi.class)).getIsHideSubAccountTroopMsg()) {
                        String qqStr3 = HardCodeUtil.qqStr(R.string.f229636wz);
                        Intrinsics.checkNotNullExpressionValue(qqStr3, "qqStr(R.string.subaccount_troop_new_msg)");
                        long j17 = i19;
                        try {
                            String str6 = subAccountInfo.subuin;
                            Intrinsics.checkNotNullExpressionValue(str6, "lastSub.subuin");
                            j3 = j17;
                            i3 = 0;
                            str2 = str5;
                            str = qqStr3;
                            parseLong = Long.parseLong(str6);
                        } catch (NumberFormatException e16) {
                            QLog.e("SubAccountAssistantUtil", 1, "lastSub:" + subAccountInfo.subuin + " ,error:" + e16 + " ");
                            j3 = j17;
                            i3 = 0;
                            str2 = str5;
                            str = qqStr3;
                            parseLong = 0;
                            return e(parseLong, str2, j3, str, i3, j16);
                        }
                    } else {
                        str = qqStr2;
                        i3 = 0;
                        str2 = str5;
                        parseLong = 0;
                        j3 = 0;
                    }
                } else {
                    String str7 = subAccountMessage5.sendername;
                    Intrinsics.checkNotNullExpressionValue(str7, "lastMsg.sendername");
                    str = subAccountMessage5.f203118msg;
                    Intrinsics.checkNotNullExpressionValue(str, "lastMsg.msg");
                    long j18 = i18;
                    if (!subAccountMessage5.isread) {
                        ArrayList<String> v3 = h.v(appInterface, subAccountInfo.subuin);
                        Intrinsics.checkNotNullExpressionValue(v3, "getSubAccountSpecialCareList(app, lastSub.subuin)");
                        if (v3.contains(subAccountMessage5.senderuin)) {
                            i17 = 1006;
                        }
                    }
                    try {
                        String str8 = subAccountInfo.subuin;
                        Intrinsics.checkNotNullExpressionValue(str8, "lastSub.subuin");
                        parseLong = Long.parseLong(str8);
                        str2 = str7;
                        j3 = j18;
                        i3 = i17;
                    } catch (NumberFormatException e17) {
                        QLog.e("SubAccountAssistantUtil", 1, "lastSub:" + subAccountInfo.subuin + " ,error:" + e17 + " ");
                        str2 = str7;
                        j3 = j18;
                        i3 = i17;
                        parseLong = 0;
                        return e(parseLong, str2, j3, str, i3, j16);
                    }
                }
                return e(parseLong, str2, j3, str, i3, j16);
            }
            a(i18, allSubAccountInfo);
            String qqStr4 = HardCodeUtil.qqStr(R.string.hr8);
            Intrinsics.checkNotNullExpressionValue(qqStr4, "qqStr(com.tencent.mobile\u2026unt_associated_qq_no_msg)");
            return e(0L, "", 0L, qqStr4, 0, j16);
        }
        subAccountInfo = subAccountInfo3;
        if (subAccountInfo == null) {
        }
        a(i18, allSubAccountInfo);
        String qqStr42 = HardCodeUtil.qqStr(R.string.hr8);
        Intrinsics.checkNotNullExpressionValue(qqStr42, "qqStr(com.tencent.mobile\u2026unt_associated_qq_no_msg)");
        return e(0L, "", 0L, qqStr42, 0, j16);
    }

    public final boolean g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        return h();
    }

    public final void i(long time) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, time);
            return;
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null) {
            String str = "sub_account_last_msg_time_" + peekAppRuntime.getCurrentUin();
            MMKVOptionEntity from = QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations");
            Intrinsics.checkNotNullExpressionValue(from, "from(MobileQQ.sMobileQQ, QMMKVFile.FILE_COMMON)");
            from.encodeLong(str, time);
        }
    }
}
