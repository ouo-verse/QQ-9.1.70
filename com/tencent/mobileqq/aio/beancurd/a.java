package com.tencent.mobileqq.aio.beancurd;

import com.tencent.android.androidbypass.richui.e;
import com.tencent.android.androidbypass.richui.utils.c;
import com.tencent.android.androidbypass.richui.viewdata.k;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\b\u0018\u0000 \u000e2\u00020\u0001:\u0001\u0006B\u0007\u00a2\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0002J'\u0010\t\u001a\u0004\u0018\u00010\u00052\u0016\u0010\b\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\u0007\"\u0004\u0018\u00010\u0001\u00a2\u0006\u0004\b\t\u0010\nR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u000bR\u0014\u0010\u0004\u001a\u00020\u00028\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\t\u0010\u000b\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/aio/beancurd/a;", "", "", "templateInfo", "busiInfo", "Lcom/tencent/android/androidbypass/richui/viewdata/k;", "a", "", "args", "b", "([Ljava/lang/Object;)Lcom/tencent/android/androidbypass/richui/viewdata/k;", "Ljava/lang/String;", "<init>", "()V", "c", "aio_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class a {
    static IPatchRedirector $redirector_;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String templateInfo;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String busiInfo;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/aio/beancurd/a$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "aio_api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.aio.beancurd.a$a, reason: collision with other inner class name and from kotlin metadata */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(32883);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.templateInfo = "{\"layout\":{\"width\":-1,\"height\":110,\"viewType\":\"image\",\"viewId\":\"image\",\"radius\":6,\"layout\":[{\"viewType\":\"view\",\"viewId\":\"background\",\"direction\":\"vertical\",\"width\":-1,\"height\":110,\"layout\":[{\"viewType\":\"gradient\",\"direction\":\"horizontal\",\"viewId\":\"1\",\"width\":-1,\"height\":44,\"layout\":[{\"viewId\":\"avatar\",\"viewType\":\"avatar\",\"marginTop\":16,\"marginLeft\":16,\"width\":20,\"radius\":5,\"height\":20},{\"viewId\":\"title\",\"viewType\":\"text\",\"marginTop\":16,\"width\":-1,\"height\":20,\"marginLeft\":6},{\"viewId\":\"icon\",\"marginLeft\":16,\"viewType\":\"image\",\"width\":20,\"height\":20,\"radius\":4,\"marginTop\":16,\"marginRight\":16}]},{\"viewId\":\"content\",\"viewType\":\"text\",\"width\":-1,\"height\":48,\"marginLeft\":16,\"marginTop\":2,\"marginBottom\":16,\"marginRight\":16}]}]},\"attributes\":{\"viewId\":\"image\",\"radius\":8,\"attributes\":[{\"backgroundColor\":\"overlay_dark\",\"viewId\":\"background\",\"attributes\":[{\"viewId\":\"1\",\"bgGradient\":{\"direction\":\"vertical\",\"startColor\":\"#80000000\",\"endColor\":\"#00000000\"},\"attributes\":[{\"viewId\":\"avatar\",\"radius\":5,\"viewType\":\"avatar\"},{\"viewId\":\"title\",\"viewType\":\"text\",\"textSize\":14,\"textColor\":\"text_allwhite_primary\",\"maxLine\":1},{\"viewId\":\"icon\",\"radius\":4,\"viewType\":\"image\"}]},{\"viewId\":\"content\",\"viewType\":\"text\",\"textSize\":17,\"maxLine\":2,\"textColor\":\"text_allwhite_primary\"}]}]}}";
            this.busiInfo = "{\"attributes\":{\"src\":\"%s\",\"attributes\":[{\"attributes\":[{\"attributes\":[{\"uin\":\"%s\"},{\"text\":\"%s\"},{\"src\":\"%s\"}]},{\"text\":\"%s\"}]}]}}";
        }
    }

    private final k a(String templateInfo, String busiInfo) {
        JSONObject jSONObject = new JSONObject(templateInfo);
        c.a(jSONObject, new JSONObject(busiInfo));
        jSONObject.put("version", 0);
        jSONObject.put("templateId", "aio.tofu.picture");
        e eVar = e.f72322a;
        String jSONObject2 = jSONObject.toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject2, "templateJson.toString()");
        return e.d(eVar, jSONObject2, null, null, 6, null);
    }

    @Nullable
    public final k b(@NotNull Object... args) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (k) iPatchRedirector.redirect((short) 2, (Object) this, (Object) args);
        }
        Intrinsics.checkNotNullParameter(args, "args");
        try {
            String str = this.templateInfo;
            String str2 = this.busiInfo;
            Object[] copyOf = Arrays.copyOf(args, args.length);
            String format = String.format(str2, Arrays.copyOf(copyOf, copyOf.length));
            Intrinsics.checkNotNullExpressionValue(format, "format(this, *args)");
            return a(str, format);
        } catch (Exception e16) {
            QLog.e("PicBeancurdMixUIGenerator", 1, "[getMixUIViewData]", e16);
            return null;
        }
    }
}
