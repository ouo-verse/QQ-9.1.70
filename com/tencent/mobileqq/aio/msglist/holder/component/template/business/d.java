package com.tencent.mobileqq.aio.msglist.holder.component.template.business;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u0000 \u00052\u00020\u0001:\u0001\u0005B\u0007\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/component/template/business/d;", "Lcom/tencent/mobileqq/aio/msglist/holder/component/template/business/a;", "Lcom/tencent/mobileqq/aio/msglist/holder/component/template/business/f;", "parseParams", "", "a", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class d implements a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/component/template/business/d$a;", "", "", "MULTI_MSG_JUMP_FAKE_URL", "Ljava/lang/String;", "TAG", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.aio.msglist.holder.component.template.business.d$a, reason: from kotlin metadata */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(63319);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.component.template.business.a
    public boolean a(@NotNull f parseParams) {
        String str;
        String str2;
        String str3;
        JSONObject optJSONObject;
        JSONObject optJSONObject2;
        JSONObject optJSONObject3;
        JSONObject optJSONObject4;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) parseParams)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(parseParams, "parseParams");
        if (!com.tencent.mobileqq.aio.msglist.holder.component.template.jump.d.INSTANCE.a(parseParams.a(), parseParams.f())) {
            return false;
        }
        try {
            JSONObject jSONObject = new JSONObject(parseParams.d());
            JSONArray optJSONArray = jSONObject.optJSONArray("news");
            String str4 = null;
            if (optJSONArray != null && (optJSONObject4 = optJSONArray.optJSONObject(0)) != null) {
                str = optJSONObject4.optString("text");
            } else {
                str = null;
            }
            String str5 = "";
            if (str == null) {
                str = "";
            }
            if (optJSONArray != null && (optJSONObject3 = optJSONArray.optJSONObject(1)) != null) {
                str2 = optJSONObject3.optString("text");
            } else {
                str2 = null;
            }
            if (str2 == null) {
                str2 = "";
            }
            if (optJSONArray != null && (optJSONObject2 = optJSONArray.optJSONObject(2)) != null) {
                str3 = optJSONObject2.optString("text");
            } else {
                str3 = null;
            }
            if (str3 == null) {
                str3 = "";
            }
            if (optJSONArray != null && (optJSONObject = optJSONArray.optJSONObject(3)) != null) {
                str4 = optJSONObject.optString("text");
            }
            if (str4 != null) {
                str5 = str4;
            }
            jSONObject.put("text0", str);
            jSONObject.put("text1", str2);
            jSONObject.put("text2", str3);
            jSONObject.put("text3", str5);
            jSONObject.put("jumpURL", "mqqapi://multimsg_fake");
            String jSONObject2 = jSONObject.toString();
            Intrinsics.checkNotNullExpressionValue(jSONObject2, "originData.toString()");
            parseParams.g(jSONObject2);
        } catch (Exception unused) {
            QLog.e("TemMsg.MultiMsg", 1, "parse exception for " + parseParams.d());
        }
        return true;
    }
}
