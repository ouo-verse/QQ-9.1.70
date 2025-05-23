package com.tencent.mobileqq.aio.msglist.holder.component.template.business;

import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u0000 \t2\u00020\u0001:\u0001\tB\u0007\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/component/template/business/c;", "Lcom/tencent/mobileqq/aio/msglist/holder/component/template/business/a;", "Lorg/json/JSONObject;", "jsonData", "", "b", "Lcom/tencent/mobileqq/aio/msglist/holder/component/template/business/f;", "parseParams", "", "a", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class c implements a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0004\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/component/template/business/c$a;", "", "", "JSON_KEY_FORWARD_NAME", "Ljava/lang/String;", "JSON_KEY_IMAGE_INFO", "JSON_KEY_PIC_NUM", "TAG", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.aio.msglist.holder.component.template.business.c$a, reason: from kotlin metadata */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(63316);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final void b(JSONObject jsonData) {
        JSONObject optJSONObject = jsonData.optJSONObject("imageInfo");
        boolean z16 = true;
        if (optJSONObject == null) {
            QLog.d("TemMsg.FeedPic", 1, "imageInfoJson is null");
            return;
        }
        if (optJSONObject.optInt("width") < optJSONObject.optInt("height")) {
            z16 = false;
        }
        jsonData.put("isWide", z16);
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.component.template.business.a
    public boolean a(@NotNull f parseParams) {
        boolean z16;
        Integer intOrNull;
        boolean z17;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) parseParams)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(parseParams, "parseParams");
        boolean z18 = false;
        if (!Intrinsics.areEqual(parseParams.a(), "com.tencent.feed.lua") && !Intrinsics.areEqual(parseParams.a(), "com.tencent.plaintext.lua")) {
            return false;
        }
        try {
            JSONObject jSONObject = new JSONObject(parseParams.d());
            String forwardNick = jSONObject.optString("forwardNick");
            Intrinsics.checkNotNullExpressionValue(forwardNick, "forwardNick");
            if (forwardNick.length() > 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                jSONObject.put("forwardNick", forwardNick + MsgSummary.STR_COLON);
            }
            String optString = jSONObject.optString("picNum");
            Intrinsics.checkNotNullExpressionValue(optString, "jsonData.optString(JSON_KEY_PIC_NUM)");
            intOrNull = StringsKt__StringNumberConversionsKt.toIntOrNull(optString);
            if (intOrNull != null && intOrNull.intValue() <= 9) {
                jSONObject.put("picNum", "");
            }
            if (intOrNull != null && intOrNull.intValue() > 1) {
                z17 = true;
            } else {
                z17 = false;
            }
            if (!z17) {
                z18 = true;
            }
            jSONObject.put("isMultiPic", z17);
            jSONObject.put("isSinglePic", z18);
            if (z18) {
                b(jSONObject);
            }
            String jSONObject2 = jSONObject.toString();
            Intrinsics.checkNotNullExpressionValue(jSONObject2, "jsonData.toString()");
            parseParams.g(jSONObject2);
        } catch (Exception unused) {
            QLog.e("TemMsg.FeedPic", 1, "parse exception for " + parseParams.d());
        }
        return true;
    }
}
