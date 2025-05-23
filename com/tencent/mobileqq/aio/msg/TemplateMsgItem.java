package com.tencent.mobileqq.aio.msg;

import android.content.Context;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.aio.msglist.holder.component.template.common.TemplateMsgConfigManager;
import com.tencent.mobileqq.aio.msglist.holder.component.template.template.TemplateMsgTemplateManager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.ArkElement;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import com.tencent.util.QQCustomArkDialogUtil;
import java.util.ArrayList;
import java.util.ListIterator;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0019\u0018\u0000 :2\u00020\u0001:\u0001;B\u000f\u0012\u0006\u00107\u001a\u00020\u0010\u00a2\u0006\u0004\b8\u00109J\u0014\u0010\u0006\u001a\u00020\u0005*\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0012\u0010\t\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J\u0006\u0010\n\u001a\u00020\u0005J\u0006\u0010\u000b\u001a\u00020\u0005J\b\u0010\r\u001a\u00020\fH\u0016J\u0010\u0010\u000f\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\fH\u0016J\u0010\u0010\u0012\u001a\u00020\u00012\u0006\u0010\u0011\u001a\u00020\u0010H\u0016J\u0006\u0010\u0014\u001a\u00020\u0013J\u0006\u0010\u0015\u001a\u00020\u0003R\u001d\u0010\u001b\u001a\u0004\u0018\u00010\u00168BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR$\u0010\"\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R(\u0010(\u001a\u0004\u0018\u00010#2\b\u0010$\u001a\u0004\u0018\u00010#8\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b\t\u0010%\u001a\u0004\b&\u0010'R$\u0010/\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\"\u00106\u001a\u00020\u00138\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b0\u00101\u001a\u0004\b2\u00103\"\u0004\b4\u00105\u00a8\u0006<"}, d2 = {"Lcom/tencent/mobileqq/aio/msg/TemplateMsgItem;", "Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "Lcom/tencent/mobileqq/aio/msg/template/d;", "", "jsonString", "", "r2", "Landroid/content/Context;", "context", "Y0", "p2", "q2", "", "getViewType", "viewType", "getSubViewType", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "targetMsgRecord", "b0", "", "o2", "j2", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgElement;", "W0", "Lkotlin/Lazy;", "i2", "()Lcom/tencent/qqnt/kernel/nativeinterface/MsgElement;", "arkElement", "X0", "Lcom/tencent/mobileqq/aio/msg/template/d;", ICustomDataEditor.NUMBER_PARAM_2, "()Lcom/tencent/mobileqq/aio/msg/template/d;", "setTemplateMsgInfo", "(Lcom/tencent/mobileqq/aio/msg/template/d;)V", "templateMsgInfo", "Lcom/tencent/qqnt/rich/c;", "<set-?>", "Lcom/tencent/qqnt/rich/c;", "l2", "()Lcom/tencent/qqnt/rich/c;", "layoutInfo", "Z0", "Ljava/lang/String;", "m2", "()Ljava/lang/String;", "setParseErrorMsg", "(Ljava/lang/String;)V", "parseErrorMsg", ICustomDataEditor.STRING_ARRAY_PARAM_1, "Z", "k2", "()Z", "setHaveParsedWithConfig", "(Z)V", "haveParsedWithConfig", "msgRecord", "<init>", "(Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;)V", "b1", "a", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class TemplateMsgItem extends AIOMsgItem {
    static IPatchRedirector $redirector_;

    /* renamed from: b1, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: W0, reason: from kotlin metadata */
    @NotNull
    private final Lazy arkElement;

    /* renamed from: X0, reason: from kotlin metadata */
    @Nullable
    private com.tencent.mobileqq.aio.msg.template.d templateMsgInfo;

    /* renamed from: Y0, reason: from kotlin metadata */
    @Nullable
    private com.tencent.qqnt.rich.c layoutInfo;

    /* renamed from: Z0, reason: from kotlin metadata */
    @Nullable
    private String parseErrorMsg;

    /* renamed from: a1, reason: collision with root package name and from kotlin metadata */
    private boolean haveParsedWithConfig;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/aio/msg/TemplateMsgItem$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.aio.msg.TemplateMsgItem$a, reason: from kotlin metadata */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(57496);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 17)) {
            redirector.redirect((short) 17);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TemplateMsgItem(@NotNull final MsgRecord msgRecord) {
        super(msgRecord);
        Lazy lazy;
        Intrinsics.checkNotNullParameter(msgRecord, "msgRecord");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            lazy = LazyKt__LazyJVMKt.lazy(new Function0<MsgElement>() { // from class: com.tencent.mobileqq.aio.msg.TemplateMsgItem$arkElement$2
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) MsgRecord.this);
                    }
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                @Nullable
                public final MsgElement invoke() {
                    MsgElement msgElement;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (MsgElement) iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                    ArrayList<MsgElement> arrayList = MsgRecord.this.elements;
                    Intrinsics.checkNotNullExpressionValue(arrayList, "msgRecord.elements");
                    ListIterator<MsgElement> listIterator = arrayList.listIterator(arrayList.size());
                    while (true) {
                        if (!listIterator.hasPrevious()) {
                            msgElement = null;
                            break;
                        }
                        msgElement = listIterator.previous();
                        if (msgElement.elementType == 10) {
                            break;
                        }
                    }
                    return msgElement;
                }
            });
            this.arkElement = lazy;
        } else {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) msgRecord);
        }
    }

    private final MsgElement i2() {
        return (MsgElement) this.arkElement.getValue();
    }

    private final void r2(com.tencent.mobileqq.aio.msg.template.d dVar, String str) {
        int i3;
        int i16;
        JSONObject jSONObject = new JSONObject(str);
        dVar.g(jSONObject.optString("app"));
        dVar.k(jSONObject.optString("prompt"));
        dVar.l(jSONObject.optString("view"));
        dVar.h(jSONObject.optString(QQCustomArkDialogUtil.BIZ_SRC));
        dVar.j(jSONObject.optJSONObject(PublicAccountMessageUtilImpl.META_NAME));
        JSONObject optJSONObject = jSONObject.optJSONObject(DownloadInfo.spKey_Config);
        com.tencent.mobileqq.aio.msg.template.c cVar = new com.tencent.mobileqq.aio.msg.template.c();
        if (optJSONObject != null) {
            i3 = Integer.valueOf(optJSONObject.optInt("menuMode", -1));
        } else {
            i3 = -1;
        }
        cVar.d(i3);
        if (optJSONObject != null) {
            i16 = optJSONObject.optInt("forward", -1);
        } else {
            i16 = -1;
        }
        if (i16 != -1) {
            cVar.c(Integer.valueOf(i16));
        } else {
            boolean z16 = false;
            if (optJSONObject != null && !optJSONObject.optBoolean("forward")) {
                z16 = true;
            }
            if (!z16) {
                cVar.c(1);
            }
        }
        dVar.i(cVar);
    }

    @Override // com.tencent.mobileqq.aio.msg.AIOMsgItem
    public void Y0(@Nullable Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) context);
            return;
        }
        super.Y0(context);
        p2();
        q2();
    }

    @Override // com.tencent.mobileqq.aio.msg.AIOMsgItem
    @NotNull
    public AIOMsgItem b0(@NotNull MsgRecord targetMsgRecord) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (AIOMsgItem) iPatchRedirector.redirect((short) 14, (Object) this, (Object) targetMsgRecord);
        }
        Intrinsics.checkNotNullParameter(targetMsgRecord, "targetMsgRecord");
        TemplateMsgItem templateMsgItem = new TemplateMsgItem(targetMsgRecord);
        templateMsgItem.p2();
        templateMsgItem.q2();
        return templateMsgItem;
    }

    @Override // com.tencent.aio.data.msglist.a
    public int getSubViewType(int viewType) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Integer) iPatchRedirector.redirect((short) 13, (Object) this, viewType)).intValue();
        }
        return super.getSubViewType(viewType);
    }

    @Override // com.tencent.mobileqq.aio.msg.AIOMsgItem, com.tencent.aio.data.msglist.a
    public int getViewType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Integer) iPatchRedirector.redirect((short) 12, (Object) this)).intValue();
        }
        if (isSelf()) {
            return 100;
        }
        return 101;
    }

    @NotNull
    public final String j2() {
        String str;
        String str2;
        String str3;
        ArkElement arkElement;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return (String) iPatchRedirector.redirect((short) 16, (Object) this);
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append("----template:");
        TemplateMsgTemplateManager templateMsgTemplateManager = TemplateMsgTemplateManager.f191966a;
        com.tencent.mobileqq.aio.msg.template.d dVar = this.templateMsgInfo;
        String str4 = "";
        if (dVar == null || (str = dVar.a()) == null) {
            str = "";
        }
        com.tencent.mobileqq.aio.msg.template.d dVar2 = this.templateMsgInfo;
        if (dVar2 == null || (str2 = dVar2.f()) == null) {
            str2 = "";
        }
        sb5.append(templateMsgTemplateManager.g(str, str2));
        sb5.append("----data:");
        MsgElement i26 = i2();
        if (i26 != null && (arkElement = i26.arkElement) != null) {
            str3 = arkElement.bytesData;
        } else {
            str3 = null;
        }
        if (str3 != null) {
            str4 = str3;
        }
        sb5.append(str4);
        String sb6 = sb5.toString();
        Intrinsics.checkNotNullExpressionValue(sb6, "stringBuilder.toString()");
        return sb6;
    }

    public final boolean k2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this)).booleanValue();
        }
        return this.haveParsedWithConfig;
    }

    @Nullable
    public final com.tencent.qqnt.rich.c l2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (com.tencent.qqnt.rich.c) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.layoutInfo;
    }

    @Nullable
    public final String m2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.parseErrorMsg;
    }

    @Nullable
    public final com.tencent.mobileqq.aio.msg.template.d n2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (com.tencent.mobileqq.aio.msg.template.d) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.templateMsgInfo;
    }

    public final boolean o2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Boolean) iPatchRedirector.redirect((short) 15, (Object) this)).booleanValue();
        }
        return TemplateMsgConfigManager.f191899a.n(this);
    }

    public final void p2() {
        String str;
        ArkElement arkElement;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
            return;
        }
        try {
            MsgElement i26 = i2();
            if (i26 != null && (arkElement = i26.arkElement) != null) {
                str = arkElement.bytesData;
            } else {
                str = null;
            }
            if (str == null) {
                str = "";
            }
            com.tencent.mobileqq.aio.msg.template.d dVar = new com.tencent.mobileqq.aio.msg.template.d();
            r2(dVar, str);
            this.templateMsgInfo = dVar;
            if (dVar.a() == null) {
                QLog.e("TemMsg.TemplateMsgItem", 1, "parse error got appName is null");
                this.parseErrorMsg = "appName is null";
            }
        } catch (Exception e16) {
            QLog.e("TemMsg.TemplateMsgItem", 1, "parse ark bytes data failed for exception:" + e16);
            this.parseErrorMsg = "read_json_exception_" + e16;
        }
    }

    public final void q2() {
        String a16;
        com.tencent.mobileqq.aio.msg.template.d dVar;
        String b16;
        com.tencent.mobileqq.aio.msg.template.d dVar2;
        String f16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
            return;
        }
        com.tencent.mobileqq.aio.msg.template.d dVar3 = this.templateMsgInfo;
        if (dVar3 != null && (a16 = dVar3.a()) != null && (dVar = this.templateMsgInfo) != null && (b16 = dVar.b()) != null && (dVar2 = this.templateMsgInfo) != null && (f16 = dVar2.f()) != null) {
            this.haveParsedWithConfig = TemplateMsgConfigManager.f191899a.m(a16, b16);
            com.tencent.mobileqq.aio.msglist.holder.component.template.common.m mVar = com.tencent.mobileqq.aio.msglist.holder.component.template.common.m.f191935a;
            String e16 = mVar.e(this.templateMsgInfo);
            try {
                com.tencent.mobileqq.aio.msglist.holder.component.template.common.h c16 = mVar.c(new com.tencent.mobileqq.aio.msglist.holder.component.template.business.f(a16, b16, f16, e16, null, this, 16, null));
                this.layoutInfo = c16.a();
                String str = this.parseErrorMsg;
                if (str == null) {
                    str = c16.b();
                }
                this.parseErrorMsg = str;
            } catch (Exception e17) {
                QLog.e("TemMsg.TemplateMsgItem", 1, "prepareViewNodes error:exception:" + e17 + " data:" + a16 + ", " + b16 + ", " + e16);
                String str2 = this.parseErrorMsg;
                if (str2 == null) {
                    str2 = "build_fail_exception_" + e17;
                }
                this.parseErrorMsg = str2;
            }
        }
    }
}
