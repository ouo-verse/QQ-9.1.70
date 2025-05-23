package com.tencent.mobileqq.aio.msglist.holder.component.template.template;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import kotlin.Metadata;
import kotlin.text.Regex;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/component/template/template/k;", "", "", "b", "Ljava/lang/String;", "a", "()Ljava/lang/String;", "TEMPLATE_JSON", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class k {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final k f191987a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final String TEMPLATE_JSON;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(63551);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            f191987a = new k();
            TEMPLATE_JSON = new Regex("\\s").replace("{\n    \"version\": 1,\n    \"templateId\": \"com.tencent.video\",\n    \"layout\": {\n        \"viewId\": \"app\",\n        \"width\": 208,\n        \"height\": -2,\n        \"layout\": [\n            {\n                \"viewId\": \"background\",\n                \"viewType\": \"image\",\n                \"width\": 208,\n                \"height\": 278\n            },\n            {\n                \"viewId\": \"image\",\n                \"viewType\": \"image\",\n                \"gravity\": \"center\",\n                \"height\": 48,\n                \"width\": 48\n            },\n            {\n                \"viewId\": \"tailRow\",\n                \"direction\": \"horizontal\",\n                \"gravity\": \"bottom\",\n                \"width\": -1,\n                \"height\": 278,\n                \"layout\": [\n                    {\n                        \"viewId\": \"maskLayer\",\n                        \"gravity\": \"bottom\",\n                        \"width\": -1,\n                        \"height\": 130,\n                        \"layout\": [\n                            {\n                                \"viewId\": \"maskLayerImage\",\n                                \"viewType\": \"image\",\n                                \"height\": -1,\n                                \"width\": -1\n                            },\n                            {\n                                \"viewId\": \"tail\",\n                                \"gravity\": \"bottom\",\n                                \"direction\": \"horizontal\",\n                                \"marginTop\": 100.5,\n                                \"height\": 28,\n                                \"width\": -1,\n                                \"layout\": [\n                                    {\n                                        \"viewId\": \"tailIcon\",\n                                        \"viewType\": \"image\",\n                                        \"gravity\": \"centerVertical\",\n                                        \"marginRight\": 4,\n                                        \"marginLeft\": 12,\n                                        \"height\": 12,\n                                        \"width\": 12\n                                    },\n                                    {\n                                        \"viewId\": \"tailText\",\n                                        \"viewType\": \"text\",\n                                        \"gravity\": \"centerVertical\",\n                                        \"marginRight\": 12,\n                                        \"width\": -1,\n                                        \"height\": -2\n                                    }\n                                ]\n                            }\n                        ]\n                    }\n                ]\n            }\n        ]\n    },\n    \"attributes\": {\n        \"viewId\": \"app\",\n        \"radius\": 10,\n        \"clickable\": true,\n        \"schema\": \"$$jumpURL\",\n        \"pcSchema\": \"$$pcJumpUrl\",\n        \"event\": {\n            \"init\": {\n                \"resetLayout\": {\n                    \"needReset\": \"$$isHorizontal\",\n                    \"width\": -1,\n                    \"height\": -2\n                }\n            }\n        },\n        \"attributes\": [\n            {\n                \"viewId\": \"background\",\n                \"src\": \"$$preview\",\n                \"event\": {\n                    \"init\": {\n                        \"resetLayout\": {\n                            \"needReset\": \"$$isHorizontal\",\n                            \"height\": -2,\n                            \"width\": -1,\n                            \"ratio\": 1.315\n                        }\n                    }\n                }\n            },\n            {\n                \"viewId\": \"image\",\n                \"src\": \"https://static-res.qq.com/static-res/ark/template/demo/play_icon.png\",\n                \"contentMode\": 2,\n                \"radius\": 24\n            },\n            {\n                \"viewId\": \"tailRow\",\n                \"event\": {\n                    \"init\": {\n                        \"resetLayout\": {\n                            \"needReset\": \"$$isHorizontal\",\n                            \"height\": -2,\n                            \"width\": -1,\n                            \"ratio\": 1.315\n                        }\n                    }\n                },\n                \"attributes\": [\n                    {\n                        \"viewId\": \"maskLayer\",\n                        \"attributes\": [\n                            {\n                                \"viewId\": \"maskLayerImage\",\n                                \"src\": \"https://static-res.qq.com/static-res/ark/template/demo/video_bottom_cover.png\"\n                            },\n                            {\n                                \"viewId\": \"tail\",\n                                \"attributes\": [\n                                    {\n                                        \"viewId\": \"tailIcon\",\n                                        \"src\": \"$$sourcelogo\",\n                                        \"contentMode\": 2,\n                                        \"radius\": 2\n                                    },\n                                    {\n                                        \"viewId\": \"tailText\",\n                                        \"text\": \"$$nickname\",\n                                        \"textSize\": 12,\n                                        \"textColor\": \"text_allwhite_primary\",\n                                        \"maxLine\": 1\n                                    }\n                                ]\n                            }\n                        ]\n                    }\n                ]\n            }\n        ]\n    }\n}\n", "");
        }
    }

    k() {
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
