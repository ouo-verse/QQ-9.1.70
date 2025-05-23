package com.tencent.android.androidbypass.richui;

import android.text.TextUtils;
import android.util.Log;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.tencent.android.androidbypass.richui.viewdata.j;
import com.tencent.android.androidbypass.richui.viewdata.k;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\r\u0010\u000eJ&\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006J&\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\n\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/android/androidbypass/richui/e;", "", "", "templateJsonStr", "Lorg/json/JSONObject;", "dataJson", "Lcom/tencent/android/androidbypass/richui/b;", "processInterface", "Lcom/tencent/android/androidbypass/richui/viewdata/k;", "b", "templateJson", "Lcom/tencent/android/androidbypass/richui/viewdata/j;", "a", "<init>", "()V", "bypass_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes3.dex */
public final class e {
    static IPatchRedirector $redirector_;

    /* renamed from: a */
    public static final e f72322a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(18530);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            f72322a = new e();
        }
    }

    e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        }
    }

    public static /* synthetic */ j c(e eVar, JSONObject jSONObject, JSONObject jSONObject2, b bVar, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            jSONObject2 = new JSONObject();
        }
        if ((i3 & 4) != 0) {
            bVar = null;
        }
        return eVar.a(jSONObject, jSONObject2, bVar);
    }

    public static /* synthetic */ k d(e eVar, String str, JSONObject jSONObject, b bVar, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            jSONObject = new JSONObject();
        }
        if ((i3 & 4) != 0) {
            bVar = null;
        }
        return eVar.b(str, jSONObject, bVar);
    }

    @Nullable
    public final j a(@NotNull JSONObject templateJson, @NotNull JSONObject dataJson, @Nullable b processInterface) {
        int i3;
        Integer valueOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (j) iPatchRedirector.redirect((short) 2, this, templateJson, dataJson, processInterface);
        }
        Intrinsics.checkNotNullParameter(templateJson, "templateJson");
        Intrinsics.checkNotNullParameter(dataJson, "dataJson");
        try {
            int optInt = templateJson.optInt("version", Integer.MAX_VALUE);
            if (optInt > 2) {
                com.tencent.android.androidbypass.config.a.f72049a.e("RichUIGenerator", "[generateViewNode]: engineVersion > local version");
                return null;
            }
            String templateId = templateJson.optString("templateId");
            if (!TextUtils.isEmpty(templateId) && !g.f72342b.a(templateId)) {
                JSONObject layoutJson = templateJson.getJSONObject(TtmlNode.TAG_LAYOUT);
                JSONObject attrJson = templateJson.getJSONObject("attributes");
                int optInt2 = templateJson.optInt("busId");
                String summary = templateJson.optString("summary", "");
                String uuid = templateJson.optString("uuid", "");
                if (!layoutJson.has("direction")) {
                    valueOf = null;
                } else {
                    if (layoutJson.optString("direction").equals("vertical")) {
                        i3 = 1;
                    } else {
                        i3 = 0;
                    }
                    valueOf = Integer.valueOf(i3);
                }
                Intrinsics.checkNotNullExpressionValue(layoutJson, "layoutJson");
                Intrinsics.checkNotNullExpressionValue(attrJson, "attrJson");
                Intrinsics.checkNotNullExpressionValue(templateId, "templateId");
                Intrinsics.checkNotNullExpressionValue(summary, "summary");
                Intrinsics.checkNotNullExpressionValue(uuid, "uuid");
                j jVar = new j(new f(layoutJson, attrJson, valueOf, true, new d(templateId, optInt2, summary, uuid, optInt), processInterface));
                long currentTimeMillis = System.currentTimeMillis();
                jVar.w(dataJson);
                jVar.y();
                com.tencent.android.androidbypass.config.a.f72049a.i("RichUIGenerator", "[generateViewData]: parse costTime=" + (System.currentTimeMillis() - currentTimeMillis) + "ms");
                return jVar;
            }
            com.tencent.android.androidbypass.config.a.f72049a.e("RichUIGenerator", "[generateViewNode]: template must has templateId");
            return null;
        } catch (Exception e16) {
            com.tencent.android.androidbypass.config.a.f72049a.e("RichUIGenerator", "[generateViewData]: " + Log.getStackTraceString(e16));
            return null;
        }
    }

    @Nullable
    public final k b(@NotNull String templateJsonStr, @NotNull JSONObject dataJson, @Nullable b processInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            return (k) iPatchRedirector.redirect((short) 1, this, templateJsonStr, dataJson, processInterface);
        }
        Intrinsics.checkNotNullParameter(templateJsonStr, "templateJsonStr");
        Intrinsics.checkNotNullParameter(dataJson, "dataJson");
        try {
            return a(new JSONObject(templateJsonStr), dataJson, processInterface);
        } catch (Exception e16) {
            com.tencent.android.androidbypass.config.a.f72049a.e("RichUIGenerator", "[generateViewData]: " + Log.getStackTraceString(e16));
            return null;
        }
    }
}
