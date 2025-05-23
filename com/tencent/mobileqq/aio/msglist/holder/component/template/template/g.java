package com.tencent.mobileqq.aio.msglist.holder.component.template.template;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import kotlin.Metadata;
import kotlin.text.Regex;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/component/template/template/g;", "", "", "b", "Ljava/lang/String;", "a", "()Ljava/lang/String;", "TEMPLATE_JSON", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class g {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final g f191981a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final String TEMPLATE_JSON;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(63540);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            f191981a = new g();
            TEMPLATE_JSON = new Regex("\\s").replace("\n{\n\t\"version\": 1,\n\t\"templateId\": \"com.tencent.miniapp_01\",\n\t\"layout\": {\n\t\t\"viewId\": \"app\",\n\t\t\"width\": -1,\n\t\t\"height\": -2,\n\t\t\"direction\": \"vertical\",\n\t\t\"layout\": [{\n\t\t\t\"viewId\": \"header\",\n\t\t\t\"direction\": \"horizontal\",\n\t\t\t\"marginLeft\": 12,\n\t\t\t\"marginTop\": 12,\n\t\t\t\"marginRight\": 12,\n\t\t\t\"height\": 16,\n\t\t\t\"width\": -1,\n\t\t\t\"layout\": [{\n\t\t\t\t\"viewId\": \"headerIcon\",\n\t\t\t\t\"viewType\": \"image\",\n\t\t\t\t\"marginRight\": 4,\n\t\t\t\t\"height\": 16,\n\t\t\t\t\"width\": 16\n\t\t\t}, {\n\t\t\t\t\"viewId\": \"headerText\",\n\t\t\t\t\"viewType\": \"text\",\n\t\t\t\t\"width\": -1,\n\t\t\t\t\"height\": -1\n\t\t\t}]\n\t\t}, {\n\t\t\t\"viewId\": \"title\",\n\t\t\t\"viewType\": \"text\",\n\t\t\t\"marginLeft\": 12,\n\t\t\t\"marginTop\": 4,\n\t\t\t\"marginRight\": 12,\n\t\t\t\"height\": -2,\n\t\t\t\"width\": -1\n\t\t}, {\n\t\t\t\"viewId\": \"image\",\n\t\t\t\"viewType\": \"image\",\n\t\t\t\"marginLeft\": 12,\n\t\t\t\"marginRight\": 12,\n\t\t\t\"marginBottom\": 12,\n\t\t\t\"marginTop\": 4,\n\t\t\t\"width\": -1,\n\t\t\t\"height\": -2,\n\t\t\t\"ratio\": 1.25\n\t\t}, {\n\t\t\t\"viewId\": \"divider\",\n\t\t\t\"viewType\": \"image\",\n\t\t\t\"height\": 0.5,\n\t\t\t\"width\": -1\n\t\t}, {\n\t\t\t\"viewId\": \"tail\",\n\t\t\t\"direction\": \"horizontal\",\n\t\t\t\"marginLeft\": 12,\n\t\t\t\"marginRight\": 12,\n\t\t\t\"height\": 22,\n\t\t\t\"width\": -1,\n\t\t\t\"layout\": [{\n\t\t\t\t\"viewId\": \"tailIcon\",\n\t\t\t\t\"viewType\": \"image\",\n\t\t\t\t\"gravity\": \"centerVertical\",\n\t\t\t\t\"marginRight\": 4,\n\t\t\t\t\"height\": 12,\n\t\t\t\t\"width\": 12\n\t\t\t}, {\n\t\t\t\t\"viewId\": \"tailText\",\n\t\t\t\t\"viewType\": \"text\",\n\t\t\t\t\"width\": -1,\n\t\t\t\t\"height\": -1\n\t\t\t}]\n\t\t}]\n\t},\n\t\"attributes\": {\n\t\t\"viewId\": \"app\",\n\t\t\"radius\": 10,\n\t\t\"backgroundColor\": \"bubble_guest\",\n\t\t\"clickable\": true,\n\t\t\"schema\": \"$$url\",\n\t\t\"pcSchema\": \"$$pcJumpUrl\",\n\t\t\"attributes\": [{\n\t\t\t\"viewId\": \"header\",\n\t\t\t\"attributes\": [{\n\t\t\t\t\"viewId\": \"headerIcon\",\n\t\t\t\t\"src\": \"$$icon\",\n\t\t\t\t\"contentMode\": 2,\n\t\t\t\t\"radius\": 4\n\t\t\t}, {\n\t\t\t\t\"viewId\": \"headerText\",\n\t\t\t\t\"text\": \"$$title\",\n\t\t\t\t\"textSize\": 12,\n\t\t\t\t\"textColor\": \"bubble_guest_text_secondary\",\n\t\t\t\t\"maxLine\": 1\n\t\t\t}]\n\t\t}, {\n\t\t\t\"viewId\": \"title\",\n\t\t\t\"text\": \"$$desc\",\n\t\t\t\"textSize\": 17,\n\t\t\t\"textColor\": \"bubble_guest_text_primary\",\n\t\t\t\"maxLine\": 2\n\t\t}, {\n\t\t\t\"viewId\": \"image\",\n\t\t\t\"src\": \"$$preview\",\n\t\t\t\"contentMode\": 2,\n\t\t\t\"radius\": 3\n\t\t}, {\n\t\t\t\"viewId\": \"divider\",\n\t\t\t\"backgroundColor\": \"border_light\",\n\t\t\t\"event\": {\n\t\t\t\t\"init\": {\n\t\t\t\t\t\"visibleCtr\": {\n\t\t\t\t\t\t\"visible\": \"$$tag\",\n\t\t\t\t\t\t\"visibleBehave\": \"GONE\",\n\t\t\t\t\t\t\"src\": \"border_light\"\n\t\t\t\t\t}\n\t\t\t\t}\n\t\t\t}\n\t\t}, {\n\t\t\t\"viewId\": \"tail\",\n\t\t\t\"event\": {\n\t\t\t\t\"init\": {\n\t\t\t\t\t\"visibleCtr\": {\n\t\t\t\t\t\t\"visible\": \"$$tag\",\n\t\t\t\t\t\t\"visibleBehave\": \"GONE\",\n\t\t\t\t\t\t\"src\": \"$$tag\"\n\t\t\t\t\t}\n\t\t\t\t}\n\t\t\t},\n\t\t\t\"attributes\": [{\n\t\t\t\t\"viewId\": \"tailIcon\",\n\t\t\t\t\"src\": \"$$tagIcon\",\n\t\t\t\t\"event\": {\n\t\t\t\t\t\"init\": {\n\t\t\t\t\t\t\"visibleCtr\": {\n\t\t\t\t\t\t\t\"visible\": \"$$tagIcon\",\n\t\t\t\t\t\t\t\"visibleBehave\": \"GONE\",\n\t\t\t\t\t\t\t\"src\": \"$$tagIcon\"\n\t\t\t\t\t\t}\n\t\t\t\t\t}\n\t\t\t\t},\n\t\t\t\t\"contentMode\": 2,\n\t\t\t\t\"radius\": 2\n\t\t\t}, {\n\t\t\t\t\"viewId\": \"tailText\",\n\t\t\t\t\"text\": \"$$tag\",\n\t\t\t\t\"textSize\": 12,\n\t\t\t\t\"maxLine\": 1,\n\t\t\t\t\"textColor\": \"bubble_guest_text_secondary\"\n\t\t\t}]\n\t\t}]\n\t}\n}\n", "");
        }
    }

    g() {
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
