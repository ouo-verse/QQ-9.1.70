package com.tencent.qqnt.chathistory.ui.link.data.model;

import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqnt.chathistory.ui.base.j;
import com.tencent.qqnt.chathistory.util.ExtensionsKt;
import com.tencent.qqnt.kernel.nativeinterface.LinkInfo;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.qqnt.kernel.nativeinterface.TextElement;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0080\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0011\u001a\u00020\n\u00a2\u0006\u0004\b*\u0010\u0010J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\"\u0010\u0011\u001a\u00020\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0017\u001a\u00020\u00128\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u0017\u0010\u001c\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u0016\u0010 \u001a\u0004\u0018\u00010\u001d8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001e\u0010\u001fR\u0014\u0010\"\u001a\u00020\u00128VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b!\u0010\u0016R\u0011\u0010$\u001a\u00020\u00128F\u00a2\u0006\u0006\u001a\u0004\b#\u0010\u0016R\u0013\u0010%\u001a\u0004\u0018\u00010\u00028F\u00a2\u0006\u0006\u001a\u0004\b\u0018\u0010\u001bR\u0013\u0010'\u001a\u0004\u0018\u00010\u00028F\u00a2\u0006\u0006\u001a\u0004\b&\u0010\u001bR\u0013\u0010)\u001a\u0004\u0018\u00010\u00028F\u00a2\u0006\u0006\u001a\u0004\b(\u0010\u001b\u00a8\u0006+"}, d2 = {"Lcom/tencent/qqnt/chathistory/ui/link/data/model/a;", "Lcom/tencent/qqnt/chathistory/ui/base/item/b;", "", "toString", "", "hashCode", "", "other", "", "equals", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "d", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "l", "()Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", DomainData.DOMAIN_NAME, "(Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;)V", QQPermissionConstants.Permission.AUIDO_GROUP, "", "e", "J", "j", "()J", "msgId", "f", "Ljava/lang/String;", "g", "()Ljava/lang/String;", "displayDate", "Lcom/tencent/qqnt/kernel/nativeinterface/TextElement;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "()Lcom/tencent/qqnt/kernel/nativeinterface/TextElement;", "textElement", "a", "msgTime", "k", "msgSeq", "displayContent", h.F, "iconUrl", "i", "linkUrl", "<init>", "chathistory_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final /* data */ class a extends com.tencent.qqnt.chathistory.ui.base.item.b {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private MsgRecord record;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final long msgId;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String displayDate;

    public a(@NotNull MsgRecord record) {
        Intrinsics.checkNotNullParameter(record, "record");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) record);
            return;
        }
        this.record = record;
        this.msgId = record.msgId;
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String string = BaseApplication.getContext().getString(R.string.zk_);
        Intrinsics.checkNotNullExpressionValue(string, "getContext().getString(R\u2026history_month_day_format)");
        String format = String.format(string, Arrays.copyOf(new Object[]{Integer.valueOf(j.c(this)), Integer.valueOf(j.b(this))}, 2));
        Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
        this.displayDate = format;
    }

    private final TextElement m() {
        MsgElement n3 = ExtensionsKt.n(this.record, 1);
        if (n3 != null) {
            return n3.textElement;
        }
        return null;
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

    public boolean equals(@Nullable Object other) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Boolean) iPatchRedirector.redirect((short) 15, (Object) this, other)).booleanValue();
        }
        if (this == other) {
            return true;
        }
        if ((other instanceof a) && Intrinsics.areEqual(this.record, ((a) other).record)) {
            return true;
        }
        return false;
    }

    @Nullable
    public final String f() {
        String str;
        boolean z16;
        LinkInfo linkInfo;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (String) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        TextElement m3 = m();
        if (m3 != null && (linkInfo = m3.linkInfo) != null) {
            str = linkInfo.title;
        } else {
            str = null;
        }
        boolean z17 = false;
        if (str != null) {
            if (str.length() > 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                z17 = true;
            }
        }
        if (z17) {
            return str;
        }
        TextElement m16 = m();
        if (m16 == null) {
            return null;
        }
        return m16.content;
    }

    @NotNull
    public final String g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (String) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return this.displayDate;
    }

    @Nullable
    public final String h() {
        TextElement textElement;
        LinkInfo linkInfo;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (String) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        MsgElement n3 = ExtensionsKt.n(this.record, 1);
        if (n3 != null && (textElement = n3.textElement) != null && (linkInfo = textElement.linkInfo) != null) {
            return linkInfo.icon;
        }
        return null;
    }

    public int hashCode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Integer) iPatchRedirector.redirect((short) 14, (Object) this)).intValue();
        }
        return this.record.hashCode();
    }

    @Nullable
    public final String i() {
        TextElement textElement;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (String) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        MsgElement n3 = ExtensionsKt.n(this.record, 1);
        if (n3 != null && (textElement = n3.textElement) != null) {
            return textElement.content;
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

    public final void n(@NotNull MsgRecord msgRecord) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) msgRecord);
        } else {
            Intrinsics.checkNotNullParameter(msgRecord, "<set-?>");
            this.record = msgRecord;
        }
    }

    @NotNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (String) iPatchRedirector.redirect((short) 13, (Object) this);
        }
        return "SearchLinkItemModel(record=" + this.record + ")";
    }
}
