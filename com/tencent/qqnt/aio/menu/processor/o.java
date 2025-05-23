package com.tencent.qqnt.aio.menu.processor;

import android.os.Bundle;
import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.text.style.EmoticonSpan;
import com.tencent.qqnt.aio.adapter.api.IQQTextApi;
import com.tencent.qqnt.aio.msg.api.IAIOMsgItemApi;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J \u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\fH\u0016R\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0011\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/qqnt/aio/menu/processor/o;", "Lcom/tencent/qqnt/aio/menu/processor/a;", "Lcom/tencent/qqnt/aio/menu/ui/d;", "menuItem", "", "c", "Lcom/tencent/mobileqq/text/QQText;", "text", "", "b", "Lcom/tencent/qqnt/aio/menu/ui/c;", "menu", "Landroid/os/Bundle;", "bundle", "", "a", "Lnv3/b;", "Lnv3/b;", "selectContent", "<init>", "()V", "aio_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class o implements a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private nv3.b selectContent;

    public o() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final String b(QQText text) {
        StringBuilder sb5 = new StringBuilder(text);
        EmoticonSpan[] emoticonSpanArr = (EmoticonSpan[]) text.getSpans(0, text.length(), EmoticonSpan.class);
        if (emoticonSpanArr == null) {
            return "";
        }
        int length = emoticonSpanArr.length - 1;
        if (length >= 0) {
            while (true) {
                int i3 = length - 1;
                sb5.replace(text.getSpanStart(emoticonSpanArr[length]), text.getSpanEnd(emoticonSpanArr[length]), "");
                if (i3 < 0) {
                    break;
                }
                length = i3;
            }
        }
        String sb6 = sb5.toString();
        Intrinsics.checkNotNullExpressionValue(sb6, "sb.toString()");
        return sb6;
    }

    private final boolean c(com.tencent.qqnt.aio.menu.ui.d menuItem) {
        QQText qQText;
        boolean isBlank;
        IAIOMsgItemApi iAIOMsgItemApi = (IAIOMsgItemApi) QRoute.api(IAIOMsgItemApi.class);
        AIOMsgItem d16 = menuItem.d();
        Intrinsics.checkNotNullExpressionValue(d16, "menuItem.msgItem");
        CharSequence translateText = iAIOMsgItemApi.getTranslateText(d16);
        if (translateText == null) {
            translateText = "";
        }
        nv3.b bVar = this.selectContent;
        if (bVar != null && bVar.l() != bVar.contentLength()) {
            translateText = bVar.m();
            Intrinsics.checkNotNullExpressionValue(translateText, "it.selectContent");
        }
        CharSequence c16 = IQQTextApi.a.c((IQQTextApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IQQTextApi.class), translateText, 5, com.tencent.qqnt.emotion.constant.b.b(), null, null, 24, null);
        if (c16 instanceof QQText) {
            qQText = (QQText) c16;
        } else {
            qQText = null;
        }
        if (qQText != null) {
            qQText.toPurePlainText();
            c16 = b(qQText);
        }
        isBlank = StringsKt__StringsJVMKt.isBlank(c16);
        return !isBlank;
    }

    @Override // com.tencent.qqnt.aio.menu.processor.a
    public void a(@NotNull com.tencent.qqnt.aio.menu.ui.c menu, @NotNull com.tencent.qqnt.aio.menu.ui.d menuItem, @NotNull Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, menu, menuItem, bundle);
            return;
        }
        Intrinsics.checkNotNullParameter(menu, "menu");
        Intrinsics.checkNotNullParameter(menuItem, "menuItem");
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        if (c(menuItem)) {
            menu.a(menuItem);
        }
    }
}
