package com.tencent.android.androidbypass;

import com.tencent.android.androidbypass.Element;
import com.tencent.bypass.nativeinterface.CustomElement;
import com.tencent.bypass.nativeinterface.CustomStyleElement;
import com.tencent.mobileqq.data.MessageForBirthdayNotice;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\u001a\n\u0010\u0002\u001a\u00020\u0001*\u00020\u0000\u001a\n\u0010\u0003\u001a\u00020\u0001*\u00020\u0000\u001a\n\u0010\u0004\u001a\u00020\u0001*\u00020\u0000\u00a8\u0006\u0005"}, d2 = {"Lcom/tencent/android/androidbypass/Element;", "", "a", "b", "c", "bypass_release"}, k = 2, mv = {1, 4, 0})
/* loaded from: classes3.dex */
public final class c {
    public static final boolean a(@NotNull Element isReplaceElement) {
        CustomElement customElement;
        Intrinsics.checkNotNullParameter(isReplaceElement, "$this$isReplaceElement");
        if (isReplaceElement.type == Element.Type.CUSTOM_SYNTAX && (customElement = isReplaceElement.getCustomElement()) != null && customElement.getElementType() == 0) {
            return true;
        }
        return false;
    }

    public static final boolean b(@NotNull Element isRichElement) {
        CustomElement customElement;
        String str;
        CustomStyleElement styleElement;
        Intrinsics.checkNotNullParameter(isRichElement, "$this$isRichElement");
        if (isRichElement.type == Element.Type.CUSTOM_SYNTAX && (customElement = isRichElement.getCustomElement()) != null && customElement.getElementType() == 1) {
            CustomElement customElement2 = isRichElement.getCustomElement();
            if (customElement2 != null && (styleElement = customElement2.getStyleElement()) != null) {
                str = styleElement.getNodeType();
            } else {
                str = null;
            }
            if (Intrinsics.areEqual(str, "richui")) {
                return true;
            }
        }
        return false;
    }

    public static final boolean c(@NotNull Element isTemplateLink) {
        boolean startsWith$default;
        boolean startsWith$default2;
        Intrinsics.checkNotNullParameter(isTemplateLink, "$this$isTemplateLink");
        if (isTemplateLink.type == Element.Type.LINK) {
            startsWith$default = StringsKt__StringsJVMKt.startsWith$default(isTemplateLink.getStringAttribute(MessageForBirthdayNotice.MSG_BIRTHDAY_NOTICE_LINK), "mqqapi://markdown/template", false, 2, null);
            if (startsWith$default) {
                startsWith$default2 = StringsKt__StringsJVMKt.startsWith$default(isTemplateLink.getStringAttribute(MessageForBirthdayNotice.MSG_BIRTHDAY_NOTICE_LINK), "mqqapi://markdown/template?id=1", false, 2, null);
                if (startsWith$default2) {
                    return false;
                }
                return true;
            }
            return false;
        }
        return false;
    }
}
