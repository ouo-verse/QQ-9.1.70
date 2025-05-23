package com.tencent.mobileqq.aio.msglist.holder.component.template.template;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import kotlin.Metadata;
import kotlin.text.Regex;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/component/template/template/d;", "", "", "b", "Ljava/lang/String;", "a", "()Ljava/lang/String;", "TEMPLATE_JSON", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class d {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final d f191975a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final String TEMPLATE_JSON;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(63532);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            f191975a = new d();
            TEMPLATE_JSON = new Regex("\\s").replace("{\n    \"version\": 1,\n    \"templateId\": \"com.tencent.plaintext\",\n    \"layout\": {\n        \"viewId\": \"app\",\n        \"width\": 208,\n        \"height\": -2,\n        \"direction\": \"vertical\",\n        \"layout\": [\n            {\n                \"viewId\": \"content\",\n                \"direction\": \"horizontal\",\n                \"height\": -2,\n                \"width\": -1,\n                \"layout\": [\n                    {\n                        \"viewId\": \"contentText\",\n                        \"gravity\": \"center\",\n                        \"viewType\": \"text\",\n                        \"width\": -1,\n                        \"height\": -2,\n                        \"marginTop\": 32,\n                        \"marginLeft\": 12,\n                        \"marginRight\": 12,\n                        \"marginBottom\": 32\n                    }\n                ]\n            },\n            {\n                \"viewId\": \"detail\",\n                \"direction\": \"vertical\",\n                \"height\": -2,\n                \"width\": -1,\n                \"layout\": [\n                    {\n                        \"viewId\": \"topPadding\",\n                        \"viewType\": \"image\",\n                        \"height\": 8\n                    },\n                    {\n                        \"viewId\": \"forwardMessage\",\n                        \"viewType\": \"text\",\n                        \"width\": -1,\n                        \"height\": -2,\n                        \"marginLeft\": 12,\n                        \"marginRight\": 12,\n                        \"marginBottom\": 5\n                    },\n                    {\n                        \"viewId\": \"desc\",\n                        \"viewType\": \"text\",\n                        \"marginLeft\": 12,\n                        \"marginRight\": 12,\n                        \"marginBottom\": 5,\n                        \"height\": -2,\n                        \"width\": -1\n                    },\n                    {\n                        \"viewId\": \"bottomPadding\",\n                        \"viewType\": \"image\",\n                        \"height\": 3\n                    }\n                ]\n            },\n            {\n                \"viewId\": \"divider\",\n                \"viewType\": \"image\",\n                \"width\": -1,\n                \"height\": 0.5\n            },\n            {\n                \"viewId\": \"tail\",\n                \"direction\": \"horizontal\",\n                \"marginLeft\": 12,\n                \"marginRight\": 12,\n                \"height\": 22,\n                \"width\": -1,\n                \"layout\": [\n                    {\n                        \"viewId\": \"tailIcon\",\n                        \"viewType\": \"image\",\n                        \"gravity\": \"centerVertical\",\n                        \"marginRight\": 4,\n                        \"height\": 12,\n                        \"width\": 12\n                    },\n                    {\n                        \"viewId\": \"tailText\",\n                        \"viewType\": \"text\",\n                        \"gravity\": \"centerVertical\",\n                        \"width\": -2,\n                        \"height\": -2\n                    }\n                ]\n            }\n        ]\n    },\n    \"attributes\": {\n        \"viewId\": \"app\",\n        \"radius\": 8,\n        \"clickable\": true,\n        \"schema\": \"$$jumpUrl\",\n        \"pcSchema\": \"$$pcJumpUrl\",\n        \"backgroundColor\": \"bubble_guest\",\n        \"attributes\": [\n            {\n                \"viewId\": \"content\",\n                \"backgroundColor\": \"#0D808080\",\n                \"attributes\": [\n                    {\n                        \"viewId\": \"contentText\",\n                        \"text\": \"$$content\",\n                        \"maxLine\": 7,\n                        \"textSize\": 18,\n                        \"textColor\": \"bubble_guest_text_primary\",\n                        \"minHeight\": 92\n                    }\n                ]\n            },\n            {\n                \"viewId\": \"detail\",\n                \"event\": {\n                    \"init\": {\n                        \"visibleCtr\": {\n                            \"visible\": \"$$forwardNick%$$forwardMessage%$$title\",\n                            \"visibleBehave\": \"GONE\",\n                            \"src\": \"$$forwardNick%$$forwardMessage%$$title\"\n                        }\n                    }\n                },\n                \"attributes\": [\n                    {\n                        \"viewId\": \"topPadding\"\n                    },\n                    {\n                        \"viewId\": \"forwardMessage\",\n                        \"event\": {\n                            \"init\": {\n                                \"visibleCtr\": {\n                                    \"visible\": \"$$forwardNick%$$forwardMessage\",\n                                    \"visibleBehave\": \"GONE\",\n                                    \"src\": \"$$forwardNick%$$forwardMessage\"\n                                }\n                            }\n                        },\n                        \"text\": \"$$forwardNick%$$forwardMessage\",\n                        \"textColor\": \"bubble_guest_text_secondary\",\n                        \"textSize\": 12,\n                        \"maxLine\": 1\n                    },\n                    {\n                        \"viewId\": \"desc\",\n                        \"event\": {\n                            \"init\": {\n                                \"visibleCtr\": {\n                                    \"visible\": \"$$title\",\n                                    \"visibleBehave\": \"GONE\",\n                                    \"src\": \"$$title\"\n                                }\n                            }\n                        },\n                        \"text\": \"$$title\",\n                        \"textSize\": 14,\n                        \"textColor\": \"bubble_guest_text_primary\",\n                        \"maxLine\": 2\n                    },\n                    {\n                        \"viewId\": \"bottomPadding\"\n                    }\n                ]\n            },\n            {\n                \"viewId\": \"divider\",\n                \"backgroundColor\": \"border_light\"\n            },\n            {\n                \"viewId\": \"tail\",\n                \"attributes\": [\n                    {\n                        \"viewId\": \"tailIcon\",\n                        \"src\": \"$$tagIcon\",\n                        \"contentMode\": 2,\n                        \"radius\": 2\n                    },\n                    {\n                        \"viewId\": \"tailText\",\n                        \"text\": \"$$tagName\",\n                        \"textSize\": 12,\n                        \"maxLine\": 1,\n                        \"textColor\": \"bubble_guest_text_secondary\"\n                    }\n                ]\n            }\n        ]\n    }\n}\n", "");
        }
    }

    d() {
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
