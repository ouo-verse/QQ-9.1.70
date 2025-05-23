package com.tencent.mobileqq.aio.msglist.holder.component.template.template;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import kotlin.Metadata;
import kotlin.text.Regex;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/component/template/template/h;", "", "", "b", "Ljava/lang/String;", "a", "()Ljava/lang/String;", "TEMPLATE_JSON", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class h {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final h f191983a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final String TEMPLATE_JSON;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(63542);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            f191983a = new h();
            TEMPLATE_JSON = new Regex("\\s").replace("{\n    \"version\": 1,\n    \"templateId\": \"com.tencent.picture\",\n    \"layout\": {\n        \"viewId\": \"app\",\n        \"width\": -2,\n        \"height\": -2,\n        \"direction\": \"vertical\",\n        \"layout\": [\n            {\n                \"viewId\": \"imageContainer\",\n                \"layout\": [\n                    {\n                        \"viewId\": \"image\",\n                        \"viewType\": \"image\",\n                        \"height\": -1,\n                        \"width\": -1\n                    }\n                ]\n            }\n        ]\n    },\n    \"attributes\": {\n        \"viewId\": \"app\",\n        \"schema\": \"$$jumpUrl\",\n        \"clickable\": true,\n        \"event\": {\n            \"init\": {\n                \"resetWidth\": {\n                    \"width\": \"$$width\"\n                }\n            }\n        },\n        \"attributes\": [\n            {\n                \"viewId\": \"imageContainer\",\n                \"radius\": 10,\n                \"attributes\": [\n                    {\n                        \"viewId\": \"image\",\n                        \"contentMode\": 2,\n                        \"src\": \"$$preview\"\n                    }\n                ],\n                \"event\": {\n                    \"init\": {\n                        \"resetWidth\": {\n                            \"width\": \"$$width\"\n                        },\n                        \"resetHeight\": {\n                            \"height\": \"$$height\"\n                        }\n                    }\n                }\n            }\n        ]\n    }\n}\n", "");
        }
    }

    h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @NotNull
    public final String a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return TEMPLATE_JSON;
    }
}
