package com.tencent.mobileqq.aio.msg;

import android.content.Context;
import androidx.exifinterface.media.ExifInterface;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0012\u0018\u0000 !2\u00020\u0001:\u0001\"B\u000f\u0012\u0006\u0010\u001e\u001a\u00020\u0004\u00a2\u0006\u0004\b\u001f\u0010 J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\t\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u0016\u0010\r\u001a\u0012\u0012\u0004\u0012\u00020\u000b0\nj\b\u0012\u0004\u0012\u00020\u000b`\fJ\u0006\u0010\u000f\u001a\u00020\u000eJ\b\u0010\u0010\u001a\u00020\u0007H\u0016J\u0012\u0010\u0013\u001a\u00020\u00022\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016J\b\u0010\u0014\u001a\u00020\u0002H\u0016J\u0010\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0001H\u0016J\b\u0010\u0017\u001a\u00020\u0007H\u0016R&\u0010\u001a\u001a\u0012\u0012\u0004\u0012\u00020\u000b0\nj\b\u0012\u0004\u0012\u00020\u000b`\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001c\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u001bR\u0016\u0010\u001d\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u001b\u00a8\u0006#"}, d2 = {"Lcom/tencent/mobileqq/aio/msg/p;", "Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "", "j2", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "targetMsgRecord", "b0", "", "viewType", "getSubViewType", "Ljava/util/ArrayList;", "Lcom/tencent/qqnt/structmsg/element/a;", "Lkotlin/collections/ArrayList;", "i2", "", "getTitle", ExifInterface.LATITUDE_SOUTH, "Landroid/content/Context;", "context", "Y0", "X0", "newMsgItem", "l", "getViewType", "W0", "Ljava/util/ArrayList;", "mElements", "I", "mMsgsum", "mSubViewType", "msgRecord", "<init>", "(Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;)V", "Z0", "a", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class p extends AIOMsgItem {
    static IPatchRedirector $redirector_;

    /* renamed from: Z0, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: W0, reason: from kotlin metadata */
    @NotNull
    private ArrayList<com.tencent.qqnt.structmsg.element.a> mElements;

    /* renamed from: X0, reason: from kotlin metadata */
    private int mMsgsum;

    /* renamed from: Y0, reason: from kotlin metadata */
    private int mSubViewType;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/aio/msg/p$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.aio.msg.p$a, reason: from kotlin metadata */
    /* loaded from: classes11.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(57252);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 11)) {
            redirector.redirect((short) 11);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public p(@NotNull MsgRecord msgRecord) {
        super(msgRecord);
        Intrinsics.checkNotNullParameter(msgRecord, "msgRecord");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) msgRecord);
        } else {
            this.mElements = new ArrayList<>();
        }
    }

    private final void j2() {
        com.tencent.qqnt.structmsg.a b16;
        com.tencent.qqnt.structmsg.c a16;
        MsgElement firstTypeElement = getFirstTypeElement(16);
        if (firstTypeElement != null && (b16 = com.tencent.qqnt.structmsg.b.b(firstTypeElement.multiForwardMsgElement.xmlContent)) != null && (a16 = b16.a()) != null) {
            com.tencent.qqnt.structmsg.c d16 = a16.d(0);
            if (d16 != null) {
                Intrinsics.checkNotNullExpressionValue(d16, "getNode(0)");
                int c16 = d16.c();
                for (int i3 = 0; i3 < c16; i3++) {
                    com.tencent.qqnt.structmsg.c childNode = d16.d(i3);
                    if ("title".equals(childNode.f362295b)) {
                        ArrayList<com.tencent.qqnt.structmsg.element.a> arrayList = this.mElements;
                        Intrinsics.checkNotNullExpressionValue(childNode, "childNode");
                        arrayList.add(new com.tencent.qqnt.structmsg.element.d(new com.tencent.qqnt.structmsg.element.b(childNode)));
                        this.mSubViewType++;
                    } else if ("summary".equals(childNode.f362295b)) {
                        ArrayList<com.tencent.qqnt.structmsg.element.a> arrayList2 = this.mElements;
                        Intrinsics.checkNotNullExpressionValue(childNode, "childNode");
                        arrayList2.add(new com.tencent.qqnt.structmsg.element.c(new com.tencent.qqnt.structmsg.element.b(childNode)));
                    }
                }
            }
            try {
                String b17 = a16.b("tSum");
                Intrinsics.checkNotNullExpressionValue(b17, "getAttribute(StructMsgConstants.XML_NODE_TSUM)");
                this.mMsgsum = Integer.parseInt(b17);
            } catch (NullPointerException e16) {
                QLog.e("MultiforwardMsgItem", 1, "parseXml err, " + e16);
            } catch (NumberFormatException e17) {
                QLog.e("MultiforwardMsgItem", 1, "parseXml err, " + e17);
            }
        }
    }

    @Override // com.tencent.mobileqq.aio.msg.AIOMsgItem
    public int S() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
        }
        return this.mMsgsum + 1;
    }

    @Override // com.tencent.mobileqq.aio.msg.AIOMsgItem
    public void X0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
        } else {
            super.X0();
            Y1(a.a(this));
        }
    }

    @Override // com.tencent.mobileqq.aio.msg.AIOMsgItem
    public void Y0(@Nullable Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) context);
            return;
        }
        super.Y0(context);
        Y1(com.tencent.mobileqq.aio.utils.n.f194168a.f(context, this));
        j2();
    }

    @Override // com.tencent.mobileqq.aio.msg.AIOMsgItem
    @NotNull
    public AIOMsgItem b0(@NotNull MsgRecord targetMsgRecord) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (AIOMsgItem) iPatchRedirector.redirect((short) 2, (Object) this, (Object) targetMsgRecord);
        }
        Intrinsics.checkNotNullParameter(targetMsgRecord, "targetMsgRecord");
        return new p(targetMsgRecord);
    }

    @Override // com.tencent.aio.data.msglist.a
    public int getSubViewType(int viewType) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this, viewType)).intValue();
        }
        return this.mSubViewType;
    }

    @NotNull
    public final String getTitle() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        if (this.mElements.size() > 0) {
            return this.mElements.get(0).c().c();
        }
        return "";
    }

    @Override // com.tencent.mobileqq.aio.msg.AIOMsgItem, com.tencent.aio.data.msglist.a
    public int getViewType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Integer) iPatchRedirector.redirect((short) 10, (Object) this)).intValue();
        }
        if (isSelf()) {
            return 33;
        }
        return 32;
    }

    @NotNull
    public final ArrayList<com.tencent.qqnt.structmsg.element.a> i2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (ArrayList) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.mElements;
    }

    @Override // com.tencent.mobileqq.aio.msg.AIOMsgItem
    public void l(@NotNull AIOMsgItem newMsgItem) {
        p pVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) newMsgItem);
            return;
        }
        Intrinsics.checkNotNullParameter(newMsgItem, "newMsgItem");
        super.l(newMsgItem);
        if (newMsgItem instanceof p) {
            pVar = (p) newMsgItem;
        } else {
            pVar = null;
        }
        if (pVar != null) {
            pVar.mSubViewType = this.mSubViewType;
            pVar.mElements = this.mElements;
            pVar.mMsgsum = this.mMsgsum;
        }
    }
}
