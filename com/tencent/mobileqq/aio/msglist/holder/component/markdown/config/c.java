package com.tencent.mobileqq.aio.msglist.holder.component.markdown.config;

import android.text.TextUtils;
import com.tencent.freesia.IConfigData;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00162\u00020\u0001:\u0001\u000eB\u0007\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u000e\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006J\u0016\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u0006R0\u0010\u0013\u001a\u001e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00040\u000fj\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0004`\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/component/markdown/config/c;", "Lcom/tencent/freesia/IConfigData;", "Lorg/json/JSONObject;", "jsonObject", "Lcom/tencent/mobileqq/aio/msglist/holder/component/markdown/config/e;", "c", "", "content", "", "b", "", "busId", "src", "", "a", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "d", "Ljava/util/HashMap;", "whiteMap", "<init>", "()V", "e", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class c implements IConfigData {
    static IPatchRedirector $redirector_;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final HashMap<Integer, e> whiteMap;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0004\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/component/markdown/config/c$a;", "", "", "FLASH_BUSID", "Ljava/lang/String;", "IMAGE", "NAME", "TAG", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.aio.msglist.holder.component.markdown.config.c$a, reason: from kotlin metadata */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(61351);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.whiteMap = new HashMap<>();
        }
    }

    private final e c(JSONObject jsonObject) {
        if (jsonObject != null) {
            String name = jsonObject.optString("name");
            ArrayList<String> arrayList = new ArrayList<>();
            JSONArray optJSONArray = jsonObject.optJSONArray("image");
            if (optJSONArray != null) {
                Intrinsics.checkNotNullExpressionValue(optJSONArray, "optJSONArray(IMAGE)");
                int length = optJSONArray.length();
                for (int i3 = 0; i3 < length; i3++) {
                    String optString = optJSONArray.optString(i3);
                    if (!TextUtils.isEmpty(optString)) {
                        arrayList.add(optString);
                    }
                }
            }
            if (!arrayList.isEmpty()) {
                e eVar = new e();
                Intrinsics.checkNotNullExpressionValue(name, "name");
                eVar.c(name);
                eVar.b(arrayList);
                return eVar;
            }
            return null;
        }
        return null;
    }

    public final boolean a(int busId, @NotNull String src) {
        boolean startsWith$default;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, busId, (Object) src)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(src, "src");
        if (this.whiteMap.isEmpty()) {
            return true;
        }
        e eVar = this.whiteMap.get(Integer.valueOf(busId));
        if (eVar != null) {
            Iterator<T> it = eVar.a().iterator();
            while (it.hasNext()) {
                startsWith$default = StringsKt__StringsJVMKt.startsWith$default(src, (String) it.next(), false, 2, null);
                if (startsWith$default) {
                    return true;
                }
            }
        }
        return false;
    }

    public final void b(@NotNull String content) {
        e c16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) content);
            return;
        }
        Intrinsics.checkNotNullParameter(content, "content");
        try {
            if (QLog.isDevelopLevel()) {
                QLog.i("RichSourceWhiteConfigData", 4, "content " + content);
            }
            JSONObject jSONObject = new JSONObject(content);
            if (jSONObject.has("1") && (c16 = c(jSONObject.optJSONObject("1"))) != null) {
                this.whiteMap.put(1, c16);
            }
        } catch (Exception e16) {
            QLog.e("RichSourceWhiteConfigData", 1, "parse " + e16);
        }
    }
}
