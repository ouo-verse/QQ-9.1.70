package com.tencent.qqnt.chathistory.ui.document.data.model;

import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.qqnt.chathistory.util.ExtensionsKt;
import com.tencent.qqnt.kernel.nativeinterface.ArkElement;
import com.tencent.qqnt.kernel.nativeinterface.LinkInfo;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.qqnt.kernel.nativeinterface.TextElement;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\f\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\t\u001a\u00020\u0002\u00a2\u0006\u0004\b,\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u0017\u0010\u000f\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u0015\u001a\u00020\u00108\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u0019\u0010\u001b\u001a\u0004\u0018\u00010\u00168\u0006\u00a2\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u0017\u0010 \u001a\u00020\u001c8\u0006\u00a2\u0006\f\n\u0004\b\u0019\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u0019\u0010%\u001a\u0004\u0018\u00010!8\u0006\u00a2\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b\u0011\u0010$R\u0014\u0010'\u001a\u00020\n8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b&\u0010\u000eR\u0011\u0010)\u001a\u00020\n8F\u00a2\u0006\u0006\u001a\u0004\b(\u0010\u000eR\u0013\u0010*\u001a\u0004\u0018\u00010!8F\u00a2\u0006\u0006\u001a\u0004\b\"\u0010$R\u0013\u0010+\u001a\u0004\u0018\u00010!8F\u00a2\u0006\u0006\u001a\u0004\b\u0017\u0010$\u00a8\u0006-"}, d2 = {"Lcom/tencent/qqnt/chathistory/ui/document/data/model/b;", "Lcom/tencent/qqnt/chathistory/ui/base/item/b;", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "d", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "l", "()Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", DomainData.DOMAIN_NAME, "(Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;)V", QQPermissionConstants.Permission.AUIDO_GROUP, "", "e", "J", "j", "()J", "msgId", "", "f", "I", "getMsgType", "()I", QQBrowserActivity.KEY_MSG_TYPE, "Lcom/tencent/qqnt/kernel/nativeinterface/LinkInfo;", "g", "Lcom/tencent/qqnt/kernel/nativeinterface/LinkInfo;", h.F, "()Lcom/tencent/qqnt/kernel/nativeinterface/LinkInfo;", "docLinkInfo", "", "Z", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "()Z", "selfSend", "", "i", "Ljava/lang/String;", "()Ljava/lang/String;", "docData", "a", "msgTime", "k", "msgSeq", "docTitle", "docIcon", "<init>", "chathistory_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class b extends com.tencent.qqnt.chathistory.ui.base.item.b {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private MsgRecord record;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final long msgId;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final int msgType;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final LinkInfo docLinkInfo;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final boolean selfSend;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final String docData;

    public b(@NotNull MsgRecord record) {
        Object obj;
        ArkElement arkElement;
        LinkInfo linkInfo;
        String str;
        boolean z16;
        ArkElement arkElement2;
        boolean z17;
        ArkElement arkElement3;
        Object obj2;
        TextElement textElement;
        String str2;
        boolean z18;
        TextElement textElement2;
        boolean z19;
        Intrinsics.checkNotNullParameter(record, "record");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) record);
            return;
        }
        this.record = record;
        this.msgId = record.msgId;
        int i3 = record.msgType;
        this.msgType = i3;
        String str3 = null;
        if (i3 == 2) {
            ArrayList<MsgElement> arrayList = record.elements;
            Intrinsics.checkNotNullExpressionValue(arrayList, "record.elements");
            ArrayList arrayList2 = new ArrayList();
            for (Object obj3 : arrayList) {
                MsgElement msgElement = (MsgElement) obj3;
                if (msgElement != null && msgElement.elementType == 1) {
                    z19 = true;
                } else {
                    z19 = false;
                }
                if (z19) {
                    arrayList2.add(obj3);
                }
            }
            Iterator it = arrayList2.iterator();
            while (true) {
                if (it.hasNext()) {
                    obj2 = it.next();
                    MsgElement msgElement2 = (MsgElement) obj2;
                    if (msgElement2 != null && (textElement2 = msgElement2.textElement) != null) {
                        str2 = textElement2.content;
                    } else {
                        str2 = null;
                    }
                    if (str2 != null && str2.length() != 0) {
                        z18 = false;
                    } else {
                        z18 = true;
                    }
                    if (!z18) {
                        break;
                    }
                } else {
                    obj2 = null;
                    break;
                }
            }
            MsgElement msgElement3 = (MsgElement) obj2;
            if (msgElement3 != null && (textElement = msgElement3.textElement) != null) {
                linkInfo = textElement.linkInfo;
            }
            linkInfo = null;
        } else {
            ArrayList<MsgElement> arrayList3 = record.elements;
            Intrinsics.checkNotNullExpressionValue(arrayList3, "record.elements");
            ArrayList arrayList4 = new ArrayList();
            for (Object obj4 : arrayList3) {
                MsgElement msgElement4 = (MsgElement) obj4;
                if (msgElement4 != null && msgElement4.elementType == 10) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                if (z17) {
                    arrayList4.add(obj4);
                }
            }
            Iterator it5 = arrayList4.iterator();
            while (true) {
                if (it5.hasNext()) {
                    obj = it5.next();
                    MsgElement msgElement5 = (MsgElement) obj;
                    if (msgElement5 != null && (arkElement2 = msgElement5.arkElement) != null) {
                        str = arkElement2.bytesData;
                    } else {
                        str = null;
                    }
                    if (str != null && str.length() != 0) {
                        z16 = false;
                    } else {
                        z16 = true;
                    }
                    if (!z16) {
                        break;
                    }
                } else {
                    obj = null;
                    break;
                }
            }
            MsgElement msgElement6 = (MsgElement) obj;
            if (msgElement6 != null && (arkElement = msgElement6.arkElement) != null) {
                linkInfo = arkElement.linkInfo;
            }
            linkInfo = null;
        }
        this.docLinkInfo = linkInfo;
        this.selfSend = ExtensionsKt.u(this.record);
        MsgRecord msgRecord = this.record;
        if (msgRecord.msgType == 2) {
            str3 = ExtensionsKt.l(msgRecord);
        } else {
            MsgElement n3 = ExtensionsKt.n(msgRecord, 10);
            if (n3 != null && (arkElement3 = n3.arkElement) != null) {
                str3 = arkElement3.bytesData;
            }
        }
        this.docData = str3;
    }

    @Override // com.tencent.qqnt.chathistory.ui.base.i
    /* renamed from: a */
    public long getMsgTime() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Long) iPatchRedirector.redirect((short) 4, (Object) this)).longValue();
        }
        return this.record.msgTime;
    }

    @Nullable
    public final String f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (String) iPatchRedirector.redirect((short) 12, (Object) this);
        }
        return this.docData;
    }

    @Nullable
    public final String g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (String) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        LinkInfo linkInfo = this.docLinkInfo;
        if (linkInfo != null) {
            return linkInfo.icon;
        }
        return null;
    }

    @Nullable
    public final LinkInfo h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (LinkInfo) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return this.docLinkInfo;
    }

    @Nullable
    public final String i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (String) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        LinkInfo linkInfo = this.docLinkInfo;
        if (linkInfo != null) {
            return linkInfo.title;
        }
        return null;
    }

    public final long j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Long) iPatchRedirector.redirect((short) 6, (Object) this)).longValue();
        }
        return this.msgId;
    }

    public final long k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Long) iPatchRedirector.redirect((short) 5, (Object) this)).longValue();
        }
        return this.record.msgSeq;
    }

    @NotNull
    public final MsgRecord l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (MsgRecord) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.record;
    }

    public final boolean m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this)).booleanValue();
        }
        return this.selfSend;
    }

    public final void n(@NotNull MsgRecord msgRecord) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) msgRecord);
        } else {
            Intrinsics.checkNotNullParameter(msgRecord, "<set-?>");
            this.record = msgRecord;
        }
    }
}
