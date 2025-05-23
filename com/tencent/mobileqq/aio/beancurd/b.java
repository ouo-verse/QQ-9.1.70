package com.tencent.mobileqq.aio.beancurd;

import com.tencent.android.androidbypass.richui.e;
import com.tencent.android.androidbypass.richui.utils.c;
import com.tencent.android.androidbypass.richui.viewdata.k;
import com.tencent.mobileqq.aio.msg.ah;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.TofuContent;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \n2\u00020\u0001:\u0001\u0007B\u0007\u00a2\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\n\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\bR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u000b\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/aio/beancurd/b;", "", "", "templateInfo", "Lorg/json/JSONObject;", "busiJson", "Lcom/tencent/android/androidbypass/richui/viewdata/k;", "a", "Lcom/tencent/mobileqq/aio/msg/ah;", "tofuMsgItem", "b", "Ljava/lang/String;", "<init>", "()V", "aio_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class b {
    static IPatchRedirector $redirector_;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String templateInfo;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0004R\u0014\u0010\b\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0004R\u0014\u0010\t\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0004R\u0014\u0010\n\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0004\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/aio/beancurd/b$a;", "", "", "KEY_AVTAR_CONTENT", "Ljava/lang/String;", "KEY_BG", "KEY_CONTENT", "KEY_CONTENT_COLOR", "KEY_TITLE", "KEY_TITLE_COLOR", "TAG", "<init>", "()V", "aio_api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.aio.beancurd.b$a, reason: from kotlin metadata */
    /* loaded from: classes10.dex */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(32889);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.templateInfo = "{\"layout\":{\"viewId\":\"root\",\"height\":110,\"direction\":\"vertical\",\"layout\":[{\"viewId\":\"title\",\"viewType\":\"text\",\"height\":20,\"marginLeft\":16,\"marginTop\":10},{\"direction\":\"horizontal\",\"viewId\":\"bottomLayout\",\"height\":90,\"layout\":[{\"viewId\":\"content\",\"viewType\":\"text\",\"height\":50,\"marginTop\":12,\"marginLeft\":16},{\"viewId\":\"avatar\",\"viewType\":\"multiAvatar\",\"width\":86,\"height\":48,\"marginTop\":10,\"marginRight\":25,\"marginLeft\":21}]}]},\"attributes\":{\"viewId\":\"root\",\"src\":\"data_bg\",\"radius\":8,\"attributes\":[{\"viewType\":\"text\",\"viewId\":\"title\",\"textSize\":14,\"textColor\":\"data_titleColor\",\"maxLine\":1,\"text\":\"data_title\"},{\"viewId\":\"bottomLayout\",\"attributes\":[{\"viewId\":\"content\",\"viewType\":\"text\",\"textSize\":17,\"textColor\":\"data_contentColor\",\"maxLine\":2,\"text\":\"data_content\"},{\"viewId\":\"avatar\",\"viewType\":\"multiAvatar\",\"contentList\":\"data_avatarContent\",\"space\":-10}]}]}}";
        }
    }

    private final k a(String templateInfo, JSONObject busiJson) {
        JSONObject jSONObject = new JSONObject(templateInfo);
        c.b(jSONObject, busiJson);
        jSONObject.put("version", 0);
        jSONObject.put("templateId", "aio.tofu.systemnotice");
        e eVar = e.f72322a;
        String jSONObject2 = jSONObject.toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject2, "templateJson.toString()");
        return e.d(eVar, jSONObject2, null, null, 6, null);
    }

    @Nullable
    public final k b(@NotNull ah tofuMsgItem) {
        Object obj;
        Object obj2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (k) iPatchRedirector.redirect((short) 2, (Object) this, (Object) tofuMsgItem);
        }
        Intrinsics.checkNotNullParameter(tofuMsgItem, "tofuMsgItem");
        try {
            JSONObject jSONObject = new JSONObject();
            Object j26 = tofuMsgItem.j2();
            Object obj3 = "";
            if (j26 == null) {
                j26 = "";
            }
            jSONObject.put("data_bg", j26);
            TofuContent p26 = tofuMsgItem.p2();
            if (p26 != null) {
                obj = p26.title;
            } else {
                obj = null;
            }
            if (obj != null) {
                obj3 = obj;
            }
            jSONObject.put("data_title", obj3);
            TofuContent p27 = tofuMsgItem.p2();
            if (p27 != null) {
                obj2 = p27.color;
            } else {
                obj2 = null;
            }
            Object obj4 = "#000000";
            if (obj2 == null) {
                obj2 = "#000000";
            }
            jSONObject.put("data_titleColor", obj2);
            StringBuilder sb5 = new StringBuilder();
            List<TofuContent> o26 = tofuMsgItem.o2();
            if (o26 != null) {
                for (TofuContent tofuContent : o26) {
                    sb5.append(tofuContent.title);
                    obj4 = tofuContent.color;
                    Intrinsics.checkNotNullExpressionValue(obj4, "it.color");
                }
            }
            jSONObject.put("data_content", sb5.toString());
            jSONObject.put("data_contentColor", obj4);
            JSONArray jSONArray = new JSONArray();
            List<String> v26 = tofuMsgItem.v2();
            if (v26 != null) {
                Iterator<T> it = v26.iterator();
                while (it.hasNext()) {
                    jSONArray.mo162put((String) it.next());
                }
            }
            jSONObject.put("data_avatarContent", jSONArray);
            return a(this.templateInfo, jSONObject);
        } catch (Exception e16) {
            QLog.e("SystemNoticeBeancurdUIGenerator", 1, "[getMixUIViewData]", e16);
            return null;
        }
    }
}
