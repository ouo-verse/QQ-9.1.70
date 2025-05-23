package com.tencent.mobileqq.aio.msglist.holder.component.template.report;

import android.text.TextUtils;
import com.tencent.ark.Constants;
import com.tencent.ark.Logger;
import com.tencent.ark.aio.report.AioDataReport;
import com.tencent.mobileqq.aio.msg.TemplateMsgItem;
import com.tencent.mobileqq.aio.msg.template.d;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqnt.kernel.nativeinterface.MsgAttributeInfo;
import com.tencent.qqnt.kernel.nativeinterface.QQConnectAttr;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \f2\u00020\u0001:\u0001\tB\u0017\u0012\u0006\u0010\u0011\u001a\u00020\u000f\u0012\u0006\u0010\u0016\u001a\u00020\u0012\u00a2\u0006\u0004\b\u0017\u0010\u0018J,\u0010\u0007\u001a\u00020\u00062\"\u0010\u0005\u001a\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0002j\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003`\u0004H\u0002J$\u0010\b\u001a\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0002j\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003`\u0004H\u0002J,\u0010\t\u001a\u00020\u00062\"\u0010\u0005\u001a\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0002j\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003`\u0004H\u0002J<\u0010\f\u001a\u00020\u00062\"\u0010\u0005\u001a\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0002j\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003`\u00042\u0006\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u0003H\u0002J\u0006\u0010\r\u001a\u00020\u0006J\u0006\u0010\u000e\u001a\u00020\u0006R\u0014\u0010\u0011\u001a\u00020\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0010R\u0017\u0010\u0016\u001a\u00020\u00128\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/component/template/report/c;", "", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "params", "", "d", "b", "a", "key", "args", "c", "f", "e", "Lcom/tencent/mobileqq/aio/msg/TemplateMsgItem;", "Lcom/tencent/mobileqq/aio/msg/TemplateMsgItem;", "templateMsgItem", "Lcom/tencent/mobileqq/aio/msg/template/d;", "Lcom/tencent/mobileqq/aio/msg/template/d;", "getTemplateMsgInfo", "()Lcom/tencent/mobileqq/aio/msg/template/d;", "templateMsgInfo", "<init>", "(Lcom/tencent/mobileqq/aio/msg/TemplateMsgItem;Lcom/tencent/mobileqq/aio/msg/template/d;)V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class c {
    static IPatchRedirector $redirector_;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final TemplateMsgItem templateMsgItem;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final d templateMsgInfo;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0007\u0010\bR\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0004\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/component/template/report/c$a;", "", "", "EVENT_ID_ARK_APP_CLICK", "Ljava/lang/String;", "EVENT_ID_ARK_APP_DISPLAY", "TAG", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.aio.msglist.holder.component.template.report.c$a, reason: from kotlin metadata */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(63507);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public c(@NotNull TemplateMsgItem templateMsgItem, @NotNull d templateMsgInfo) {
        Intrinsics.checkNotNullParameter(templateMsgItem, "templateMsgItem");
        Intrinsics.checkNotNullParameter(templateMsgInfo, "templateMsgInfo");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) templateMsgItem, (Object) templateMsgInfo);
        } else {
            this.templateMsgItem = templateMsgItem;
            this.templateMsgInfo = templateMsgInfo;
        }
    }

    private final void a(HashMap<String, String> params) {
        JSONObject jSONObject;
        String str;
        try {
            JSONObject d16 = this.templateMsgInfo.d();
            if (d16 == null || (str = d16.toString()) == null) {
                str = "";
            }
            jSONObject = new JSONObject(str);
        } catch (Exception e16) {
            Logger.logE("TemplateMsgReporter", "fillReportParams error " + e16);
        }
        if (!jSONObject.keys().hasNext()) {
            return;
        }
        JSONObject jSONObject2 = jSONObject.getJSONObject((String) jSONObject.keys().next());
        String reserved1 = jSONObject2.optString("ark_reserved1");
        String reserved2 = jSONObject2.optString("ark_reserved2");
        String reserved3 = jSONObject2.optString("ark_reserved3");
        Intrinsics.checkNotNullExpressionValue(reserved1, "reserved1");
        c(params, "ark_reserved1", reserved1);
        Intrinsics.checkNotNullExpressionValue(reserved2, "reserved2");
        c(params, "ark_reserved2", reserved2);
        Intrinsics.checkNotNullExpressionValue(reserved3, "reserved3");
        c(params, "ark_reserved3", reserved3);
        int i3 = this.templateMsgItem.getMsgRecord().chatType;
        if (i3 != 0) {
            String convertChatTypeToReportStr = AioDataReport.convertChatTypeToReportStr(i3);
            Intrinsics.checkNotNullExpressionValue(convertChatTypeToReportStr, "convertChatTypeToReportStr(chatType)");
            params.put("ark_aio_type", convertChatTypeToReportStr);
        }
        String valueOf = String.valueOf(this.templateMsgItem.getMsgRecord().peerUin);
        if (!TextUtils.isEmpty(valueOf)) {
            params.put("ark_aio_uin", valueOf);
        }
    }

    private final HashMap<String, String> b() {
        HashMap<String, String> hashMap = new HashMap<>();
        String a16 = this.templateMsgInfo.a();
        String str = "";
        if (a16 == null) {
            a16 = "";
        }
        hashMap.put("ark_id", a16);
        String b16 = this.templateMsgInfo.b();
        if (b16 != null) {
            str = b16;
        }
        hashMap.put("ark_biz_src", str);
        d(hashMap);
        return hashMap;
    }

    private final void c(HashMap<String, String> params, String key, String args) {
        if (!TextUtils.isEmpty(args)) {
            params.put(key, args);
        }
    }

    private final void d(HashMap<String, String> params) {
        QQConnectAttr qQConnectAttr;
        MsgAttributeInfo msgAttributeInfo = this.templateMsgItem.getMsgRecord().msgAttrs.get(12);
        if (msgAttributeInfo != null) {
            qQConnectAttr = msgAttributeInfo.qqConnectAttr;
        } else {
            qQConnectAttr = null;
        }
        if (qQConnectAttr == null) {
            return;
        }
        params.put("qqconnect_appid", String.valueOf(qQConnectAttr.appID));
        params.put("qqconnect_app_type", String.valueOf(qQConnectAttr.appType));
    }

    public final void e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        HashMap<String, String> b16 = b();
        a(b16);
        VideoReport.reportEvent(Constants.Event.EVENT_ID_ARK_APP_CLICK, b16);
    }

    public final void f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        HashMap<String, String> b16 = b();
        a(b16);
        VideoReport.reportEvent(Constants.Event.EVENT_ID_ARK_APP_DISPLAY, b16);
    }
}
