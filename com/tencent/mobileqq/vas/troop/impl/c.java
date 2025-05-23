package com.tencent.mobileqq.vas.troop.impl;

import android.text.TextUtils;
import com.tencent.hippy.qq.api.TabPreloadItem;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.VasFeature;
import com.tencent.mobileqq.vas.VasLogNtReporter;
import com.tencent.mobileqq.vas.troop.api.ITroopKeywordService;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.FirstViewGroupGuildInfo;
import com.tencent.qqnt.kernel.nativeinterface.GroupGuildNotifyInfo;
import com.tencent.qqnt.kernel.nativeinterface.GuildMsgAbFlag;
import com.tencent.qqnt.kernel.nativeinterface.IKernelMsgService;
import com.tencent.qqnt.kernel.nativeinterface.IOperateCallback;
import com.tencent.qqnt.kernel.nativeinterface.IQQNTWrapperSession;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.qqnt.kernel.nativeinterface.TextElement;
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import com.tencent.qqnt.msg.api.b;
import com.tencent.qqnt.msg.data.h;
import com.tencent.qqnt.msg.f;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import y13.d;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u000b\u0010\fJ \u0010\u0007\u001a\u00020\u00062\u0016\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u0004H\u0016J\u000e\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0003\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/vas/troop/impl/c;", "Lcom/tencent/qqnt/msg/api/b;", "Ljava/util/ArrayList;", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "Lkotlin/collections/ArrayList;", TabPreloadItem.TAB_NAME_MESSAGE, "", "onRecvMsg", "msg", "", "g", "<init>", "()V", "vas_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class c implements com.tencent.qqnt.msg.api.b {
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:19:0x003d  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0041 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0040 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void e(ArrayList msgList, c this$0) {
        boolean z16;
        String g16;
        IKernelMsgService msgService;
        IKernelMsgService msgService2;
        Intrinsics.checkNotNullParameter(msgList, "$msgList");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        try {
            Iterator it = msgList.iterator();
            while (it.hasNext()) {
                MsgRecord msgRecord = (MsgRecord) it.next();
                String str = msgRecord.guildId;
                boolean z17 = false;
                if (str != null && str.length() != 0) {
                    z16 = false;
                    if (z16 && msgRecord.chatType == 2) {
                        g16 = this$0.g(msgRecord);
                        if (g16.length() == 0) {
                            z17 = true;
                        }
                        if (z17) {
                            String valueOf = String.valueOf(msgRecord.peerUin);
                            if (((ITroopKeywordService) QRoute.api(ITroopKeywordService.class)).containsKeyword(valueOf, g16)) {
                                VasLogNtReporter.INSTANCE.getTroopKeyword().reportLow("onRecvMsg[" + valueOf + "] contains keyword");
                                Contact contact = new Contact(msgRecord.chatType, msgRecord.peerUid, msgRecord.guildId);
                                if (QLog.isColorLevel()) {
                                    IQQNTWrapperSession k3 = f.k();
                                    if (k3 != null && (msgService = k3.getMsgService()) != null) {
                                        msgService.insertMsgToMsgBox(contact, msgRecord.msgId, 2006, new IOperateCallback() { // from class: com.tencent.mobileqq.vas.troop.impl.b
                                            @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
                                            public final void onResult(int i3, String str2) {
                                                c.f(i3, str2);
                                            }
                                        });
                                    }
                                } else {
                                    IQQNTWrapperSession k16 = f.k();
                                    if (k16 != null && (msgService2 = k16.getMsgService()) != null) {
                                        msgService2.insertMsgToMsgBox(contact, msgRecord.msgId, 2006, null);
                                    }
                                }
                            }
                        }
                    }
                }
                z16 = true;
                if (z16) {
                    g16 = this$0.g(msgRecord);
                    if (g16.length() == 0) {
                    }
                    if (z17) {
                    }
                }
            }
        } catch (OutOfMemoryError e16) {
            QLog.e("TroopKeywordWatcher", 1, "for oom: " + e16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(int i3, String str) {
        VasLogNtReporter.INSTANCE.getTroopKeyword().reportLow("result[" + i3 + "] errMsg[" + str + "]");
    }

    @Override // com.tencent.qqnt.msg.api.b
    public void a(@NotNull h hVar) {
        b.a.h(this, hVar);
    }

    @Override // com.tencent.qqnt.msg.api.b
    public void b(@NotNull byte[] bArr) {
        b.a.g(this, bArr);
    }

    @NotNull
    public final String g(@NotNull MsgRecord msg2) {
        String content;
        Intrinsics.checkNotNullParameter(msg2, "msg");
        ArrayList<MsgElement> arrayList = msg2.elements;
        if (arrayList != null) {
            Iterator<T> it = arrayList.iterator();
            while (it.hasNext()) {
                TextElement textElement = ((MsgElement) it.next()).textElement;
                if (textElement != null && (content = textElement.content) != null) {
                    Intrinsics.checkNotNullExpressionValue(content, "content");
                    if (!TextUtils.isEmpty(content)) {
                        return content;
                    }
                }
            }
            return "";
        }
        return "";
    }

    @Override // com.tencent.qqnt.msg.api.b
    public void onFirstViewGroupGuildMapping(@NotNull ArrayList<FirstViewGroupGuildInfo> arrayList) {
        b.a.a(this, arrayList);
    }

    @Override // com.tencent.qqnt.msg.api.b
    public void onGroupGuildUpdate(@NotNull GroupGuildNotifyInfo groupGuildNotifyInfo) {
        b.a.b(this, groupGuildNotifyInfo);
    }

    @Override // com.tencent.qqnt.msg.api.b
    public void onGuildMsgAbFlagChanged(@NotNull GuildMsgAbFlag guildMsgAbFlag) {
        b.a.c(this, guildMsgAbFlag);
    }

    @Override // com.tencent.qqnt.msg.api.b
    public void onRecvGroupGuildFlag(int i3) {
        b.a.d(this, i3);
    }

    @Override // com.tencent.qqnt.msg.api.b
    public void onRecvMsg(@NotNull final ArrayList<MsgRecord> msgList) {
        Intrinsics.checkNotNullParameter(msgList, "msgList");
        if (VasFeature.INSTANCE.getTroopKeyword().isNotEnable()) {
            return;
        }
        try {
            d.b(new Runnable() { // from class: com.tencent.mobileqq.vas.troop.impl.a
                @Override // java.lang.Runnable
                public final void run() {
                    c.e(msgList, this);
                }
            });
        } catch (OutOfMemoryError e16) {
            QLog.e("TroopKeywordWatcher", 1, "oom: " + e16);
        }
    }

    @Override // com.tencent.qqnt.msg.api.b
    public void onRecvUDCFlag(int i3) {
        b.a.f(this, i3);
    }
}
