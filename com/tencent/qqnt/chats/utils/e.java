package com.tencent.qqnt.chats.utils;

import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.RecentContactInfo;
import com.tencent.qqnt.kernel.nativeinterface.RecentContactListChangedInfo;
import com.tencent.qqnt.kernel.nativeinterface.SpecificEventTypeInfoInMsgBox;
import com.tencent.qqnt.kernelpublic.nativeinterface.MsgAbstractElement;
import com.tenpay.proxy.dlg.location.QbAddrData;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import oicq.wlogin_sdk.tools.util;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\t\u001a\u00020\u00042\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006H\u0002J\u000e\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nJ\u000e\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\n\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/qqnt/chats/utils/e;", "", "Lcom/tencent/qqnt/kernel/nativeinterface/RecentContactInfo;", "info", "", "e", "", "Lcom/tencent/qqnt/kernelpublic/nativeinterface/MsgAbstractElement;", "elementList", "f", "Lcom/tencent/qqnt/kernel/nativeinterface/RecentContactListChangedInfo;", "changeInfo", "", "c", "b", "<init>", "()V", "chats_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class e {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final e f355546a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(46318);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            f355546a = new e();
        }
    }

    e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(RecentContactListChangedInfo changeInfo) {
        Intrinsics.checkNotNullParameter(changeInfo, "$changeInfo");
        try {
            f355546a.b(changeInfo);
        } catch (Throwable th5) {
            QLog.d("MsgExt", 1, "[[assembleData] err: ", th5);
        }
    }

    private final String e(RecentContactInfo info) {
        String str = info.f359204id;
        long j3 = info.contactId;
        int i3 = info.chatType;
        String str2 = info.senderUid;
        String str3 = info.peerUid;
        String simpleUinForPrint = StringUtil.getSimpleUinForPrint(String.valueOf(info.peerUin));
        long j16 = info.msgTime;
        int i16 = info.sendStatus;
        String f16 = f(info.abstractContent);
        ArrayList<SpecificEventTypeInfoInMsgBox> arrayList = info.listOfSpecificEventTypeInfosInMsgBox;
        byte b16 = info.topFlag;
        long j17 = info.topFlagTime;
        byte b17 = info.draftFlag;
        byte b18 = info.specialCareFlag;
        return "{id=" + str + ",contactId=" + j3 + ",chatType=" + i3 + ",senderUid=" + str2 + ",peerUid=" + str3 + ",peerUin=" + simpleUinForPrint + ",msgTime=" + j16 + ",sendStatus=" + i16 + ",content=" + f16 + ",,listOfSpecific=" + arrayList + ",topFlag=" + ((int) b16) + ",topFlagTime=" + j17 + ",draftFlag=" + ((int) b17) + ",specialCareFlag=" + ((int) b18) + ",sessionType=" + info.sessionType + ",atType=" + info.atType + ",hiddenFlag=" + info.hiddenFlag + ",isMsgDisturb=" + info.isMsgDisturb + ",unreadCnt=" + info.unreadCnt + ",msgId=" + info.msgId + ",notifiedType=" + info.notifiedType + ",isBlock=" + info.isBlock + ", liteBusiness=" + info.liteBusiness + ",guildContactInfo=" + info.guildContactInfo + "}";
    }

    private final String f(List<MsgAbstractElement> elementList) {
        boolean z16;
        if (elementList == null) {
            return "null";
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append(elementList.size());
        sb5.append('-');
        for (MsgAbstractElement msgAbstractElement : elementList) {
            String str = msgAbstractElement.content;
            if (str != null && str.length() != 0) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (!z16) {
                sb5.append(msgAbstractElement.content.length());
                sb5.append(util.base64_pad_url);
                sb5.append(msgAbstractElement.content.subSequence(0, 1));
                sb5.append(QbAddrData.DATA_SPLITER);
            }
        }
        String sb6 = sb5.toString();
        Intrinsics.checkNotNullExpressionValue(sb6, "log.toString()");
        return sb6;
    }

    public final void b(@NotNull RecentContactListChangedInfo changeInfo) {
        int i3;
        int i16;
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) changeInfo);
            return;
        }
        Intrinsics.checkNotNullParameter(changeInfo, "changeInfo");
        StringBuilder sb5 = new StringBuilder();
        ArrayList<Long> arrayList = changeInfo.sortedContactList;
        ArrayList<RecentContactInfo> arrayList2 = changeInfo.changedList;
        sb5.append("listType=");
        sb5.append(changeInfo.listType);
        sb5.append("; notifyType=");
        sb5.append(changeInfo.notificationType);
        sb5.append("; ");
        ArrayList<RecentContactInfo> arrayList3 = changeInfo.changedList;
        int i17 = 0;
        if (arrayList3 != null) {
            ArrayList<RecentContactInfo> arrayList4 = new ArrayList();
            Iterator<T> it = arrayList3.iterator();
            i3 = 0;
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Object next = it.next();
                int i18 = i3 + 1;
                if (i3 <= 1) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (!z16) {
                    i3 = i18;
                    break;
                } else {
                    arrayList4.add(next);
                    i3 = i18;
                }
            }
            for (RecentContactInfo it5 : arrayList4) {
                e eVar = f355546a;
                Intrinsics.checkNotNullExpressionValue(it5, "it");
                sb5.append(eVar.e(it5));
                sb5.append(";\n");
            }
        } else {
            i3 = 0;
        }
        if (i3 != 0) {
            QLog.i("PlatformRecentContactsDataSource", 1, "[assembleData-part1] " + ((Object) sb5));
        }
        int i19 = changeInfo.listType;
        int i26 = changeInfo.notificationType;
        long j3 = changeInfo.unreadCnt;
        if (arrayList2 != null) {
            i16 = arrayList2.size();
        } else {
            i16 = 0;
        }
        if (arrayList != null) {
            i17 = arrayList.size();
        }
        QLog.d("PlatformRecentContactsDataSource", 1, "[assembleData-part2] listType=" + i19 + ",notifyType=" + i26 + ",unreadCnt=" + j3 + ",contactSize=" + i16 + ",sortSize=" + i17 + ",sort=" + changeInfo.sortedContactList + "atTop=" + changeInfo.atTheTop + ",atBottom=" + changeInfo.atTheBottom + ",moreAtBottom=" + changeInfo.moreDataAtTheBottom + ",firstContact=" + changeInfo.firstContactPos);
    }

    public final void c(@NotNull final RecentContactListChangedInfo changeInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) changeInfo);
        } else {
            Intrinsics.checkNotNullParameter(changeInfo, "changeInfo");
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.qqnt.chats.utils.d
                @Override // java.lang.Runnable
                public final void run() {
                    e.d(RecentContactListChangedInfo.this);
                }
            }, 64, null, false);
        }
    }
}
