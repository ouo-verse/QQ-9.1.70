package com.tencent.mobileqq.aio.msglist.holder.component.template.template;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import kotlin.Metadata;
import kotlin.text.Regex;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/component/template/template/b;", "", "", "b", "Ljava/lang/String;", "a", "()Ljava/lang/String;", "TEMPLATE_JSON", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final b f191971a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final String TEMPLATE_JSON;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(63526);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            f191971a = new b();
            TEMPLATE_JSON = new Regex("\\s").replace("{\n    \"version\": 1,\n    \"templateId\": \"com.tencent.contact\",\n    \"layout\": {\n        \"viewId\": \"app\",\n        \"width\": -1,\n        \"height\": -2,\n        \"direction\": \"vertical\",\n        \"layout\": [\n            {\n                \"viewId\": \"mainRow\",\n                \"direction\": \"horizontal\",\n                \"marginRight\": 12,\n                \"marginLeft\": 12,\n                \"marginTop\": 12,\n                \"marginBottom\": 12,\n                \"width\": -1,\n                \"height\": 52,\n                \"layout\": [\n                    {\n                        \"viewId\": \"avatar\",\n                        \"viewType\": \"image\",\n                        \"width\": 52,\n                        \"height\": 52\n                    },\n                    {\n                        \"viewId\": \"squareAvatar\",\n                        \"viewType\": \"image\",\n                        \"width\": 52,\n                        \"height\": 52\n                    },\n                    {\n                        \"viewId\": \"nickName\",\n                        \"viewType\": \"text\",\n                        \"marginLeft\": 8,\n                        \"gravity\": \"centerVertical\",\n                        \"height\": -2,\n                        \"width\": -1\n                    }\n                ]\n            },\n            {\n                \"viewId\": \"divider\",\n                \"viewType\": \"image\",\n                \"height\": 0.5,\n                \"width\": -1\n            },\n            {\n                \"viewId\": \"tail\",\n                \"direction\": \"horizontal\",\n                \"marginLeft\": 12,\n                \"height\": 22,\n                \"width\": -1,\n                \"layout\": [\n                    {\n                        \"viewId\": \"tailText\",\n                        \"viewType\": \"text\",\n                        \"width\": -1,\n                        \"height\": -1\n                    }\n                ]\n            }\n        ]\n    },\n    \"attributes\": {\n        \"viewId\": \"app\",\n        \"radius\": 10,\n        \"backgroundColor\": \"bubble_guest\",\n        \"clickable\": true,\n        \"schema\": \"$$jumpUrl\",\n        \"pcSchema\": \"$$pcJumpUrl\",\n        \"attributes\": [\n            {\n                \"viewId\": \"mainRow\",\n                \"attributes\": [\n                    {\n                        \"viewId\": \"avatar\",\n                        \"src\": \"$$avatar\",\n                        \"radius\": 26,\n                        \"visibility\": \"GONE\",\n                        \"event\": {\n                            \"init\": {\n                                \"visibleCtr\": {\n                                    \"visible\": \"$$isCircle\",\n                                    \"visibleBehave\": \"GONE\",\n                                    \"src\": \"border_light\"\n                                }\n                            }\n                        }\n                    },\n                    {\n                        \"viewId\": \"squareAvatar\",\n                        \"src\": \"$$avatar\",\n                        \"radius\": 6,\n                        \"visibility\": \"GONE\",\n                        \"event\": {\n                            \"init\": {\n                                \"visibleCtr\": {\n                                    \"visible\": \"$$isSquard\",\n                                    \"visibleBehave\": \"GONE\",\n                                    \"src\": \"border_light\"\n                                }\n                            }\n                        }\n                    },\n                    {\n                        \"viewId\": \"nickName\",\n                        \"text\": \"$$nickname\",\n                        \"textSize\": 17,\n                        \"textColor\": \"bubble_guest_text_primary\",\n                        \"maxLine\": 1\n                    }\n                ]\n            },\n            {\n                \"viewId\": \"divider\",\n                \"backgroundColor\": \"border_light\"\n            },\n            {\n                \"viewId\": \"tail\",\n                \"attributes\": [\n                    {\n                        \"viewId\": \"tailText\",\n                        \"text\": \"$$tag\",\n                        \"textSize\": 12,\n                        \"textColor\": \"bubble_guest_text_secondary\",\n                        \"maxLine\": 1\n                    }\n                ]\n            }\n        ]\n    }\n}\n", "");
        }
    }

    b() {
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
