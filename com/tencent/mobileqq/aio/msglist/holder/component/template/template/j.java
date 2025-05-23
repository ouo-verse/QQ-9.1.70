package com.tencent.mobileqq.aio.msglist.holder.component.template.template;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import kotlin.Metadata;
import kotlin.text.Regex;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/component/template/template/j;", "", "", "b", "Ljava/lang/String;", "a", "()Ljava/lang/String;", "TEMPLATE_JSON", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class j {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final j f191985a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final String TEMPLATE_JSON;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(63549);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            f191985a = new j();
            TEMPLATE_JSON = new Regex("\\s").replace("{\n    \"version\": 1,\n    \"templateId\": \"com.tencent.tuwen\",\n    \"layout\": {\n        \"viewId\": \"app\",\n        \"width\": -1,\n        \"height\": -2,\n        \"direction\": \"vertical\",\n        \"layout\": [\n            {\n                \"viewId\": \"titleArea\",\n                \"direction\": \"horizontal\",\n                \"marginLeft\": 12,\n                \"marginTop\": 12,\n                \"marginRight\": 12,\n                \"height\": -2,\n                \"width\": -1,\n                \"layout\": [\n                    {\n                        \"viewId\": \"title\",\n                        \"viewType\": \"text\",\n                        \"height\": -2,\n                        \"width\": -1\n                    }\n                ]\n            },\n            {\n                \"viewId\": \"detail\",\n                \"direction\": \"horizontal\",\n                \"marginLeft\": 12,\n                \"marginTop\": 4,\n                \"marginRight\": 12,\n                \"marginBottom\": 12,\n                \"height\": -2,\n                \"width\": -1,\n                \"layout\": [\n                    {\n                        \"viewId\": \"desc\",\n                        \"viewType\": \"text\",\n                        \"height\": -2,\n                        \"width\": -1\n                    },\n                    {\n                        \"viewId\": \"image\",\n                        \"viewType\": \"image\",\n                        \"marginLeft\": 18,\n                        \"marginTop\": 4,\n                        \"marginBottom\": 4,\n                        \"height\": 52,\n                        \"width\": 52\n                    }\n                ]\n            },\n            {\n                \"viewId\": \"divider\",\n                \"viewType\": \"image\",\n                \"height\": 0.5,\n                \"width\": -1\n            },\n            {\n                \"viewId\": \"tail\",\n                \"direction\": \"horizontal\",\n                \"marginLeft\": 12,\n                \"marginRight\": 12,\n                \"height\": 22,\n                \"width\": -1,\n                \"layout\": [\n                    {\n                        \"viewId\": \"tailIcon\",\n                        \"viewType\": \"image\",\n                        \"gravity\": \"centerVertical\",\n                        \"marginRight\": 4,\n                        \"height\": 12,\n                        \"width\": 12\n                    },\n                    {\n                        \"viewId\": \"tailText\",\n                        \"viewType\": \"text\",\n                        \"width\": -1,\n                        \"height\": -1\n                    }\n                ]\n            }\n        ]\n    },\n    \"attributes\": {\n        \"viewId\": \"app\",\n        \"radius\": 10,\n        \"backgroundColor\": \"bubble_guest\",\n        \"clickable\": true,\n        \"schema\": \"$$jumpUrl\",\n        \"pcSchema\": \"$$pcJumpUrl\",\n        \"attributes\": [\n            {\n                \"viewId\": \"titleArea\",\n                \"attributes\": [\n                    {\n                        \"viewId\": \"title\",\n                        \"text\": \"$$title\",\n                        \"textSize\": 17,\n                        \"textColor\": \"bubble_guest_text_primary\",\n                        \"maxLine\": 2\n                    }\n                ]\n            },\n            {\n                \"viewId\": \"detail\",\n                \"attributes\": [\n                    {\n                        \"viewId\": \"desc\",\n                        \"text\": \"$$desc\",\n                        \"textSize\": 14,\n                        \"textColor\": \"bubble_guest_text_secondary\",\n                        \"maxLine\": 3\n                    },\n                    {\n                        \"viewId\": \"image\",\n                        \"src\": \"$$preview\",\n                        \"contentMode\": 2,\n                        \"radius\": 5.2\n                    }\n                ]\n            },\n            {\n                \"viewId\": \"divider\",\n                \"backgroundColor\": \"border_light\",\n                \"event\": {\n                    \"init\": {\n                        \"visibleCtr\": {\n                            \"visible\": \"$$tag\",\n                            \"visibleBehave\": \"GONE\",\n                            \"src\": \"border_light\"\n                        }\n                    }\n                }\n            },\n            {\n                \"viewId\": \"tail\",\n                \"event\": {\n                    \"init\": {\n                        \"visibleCtr\": {\n                            \"visible\": \"$$tag\",\n                            \"visibleBehave\": \"GONE\",\n                            \"src\": \"$$tag\"\n                        }\n                    }\n                },\n                \"attributes\": [\n                    {\n                        \"viewId\": \"tailIcon\",\n                        \"src\": \"$$tagIcon\",\n                        \"contentMode\": 2,\n                        \"event\": {\n                            \"init\": {\n                                \"visibleCtr\": {\n                                    \"visible\": \"$$tagIcon\",\n                                    \"visibleBehave\": \"GONE\",\n                                    \"src\": \"$$tagIcon\"\n                                }\n                            }\n                        }\n                    },\n                    {\n                        \"viewId\": \"tailText\",\n                        \"text\": \"$$tag\",\n                        \"textSize\": 12,\n                        \"textColor\": \"bubble_guest_text_secondary\",\n                        \"maxLine\": 1\n                    }\n                ]\n            }\n        ]\n    }\n}\n", "");
        }
    }

    j() {
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
