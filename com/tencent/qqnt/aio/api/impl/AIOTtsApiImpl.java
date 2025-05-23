package com.tencent.qqnt.aio.api.impl;

import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.aio.msglist.holder.component.markdown.MarkdownMsgItem;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqnt.aio.api.IAIOTtsApi;
import com.tencent.qqnt.kernel.nativeinterface.AdelieActionBarElement;
import com.tencent.qqnt.kernel.nativeinterface.InlineKeyboardButton;
import com.tencent.qqnt.kernel.nativeinterface.InlineKeyboardRow;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\t\u0010\nJ\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0006H\u0016\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/qqnt/aio/api/impl/AIOTtsApiImpl;", "Lcom/tencent/qqnt/aio/api/IAIOTtsApi;", "Lcom/tencent/aio/data/msglist/a;", "msgItem", "", "isMsgSupportTts", "Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "", "getTtsContent", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class AIOTtsApiImpl implements IAIOTtsApi {
    static IPatchRedirector $redirector_;

    public AIOTtsApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.qqnt.aio.api.IAIOTtsApi
    @NotNull
    public String getTtsContent(@NotNull AIOMsgItem msgItem) {
        String str;
        CharSequence trim;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this, (Object) msgItem);
        }
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        StringBuilder sb5 = new StringBuilder();
        if (msgItem instanceof com.tencent.mobileqq.aio.msg.ae) {
            sb5.append(String.valueOf(((com.tencent.mobileqq.aio.msg.ae) msgItem).u2()));
        } else if (msgItem instanceof com.tencent.mobileqq.aio.msg.o) {
            Iterator<Map.Entry<Integer, CharSequence>> it = ((com.tencent.mobileqq.aio.msg.o) msgItem).p2().entrySet().iterator();
            while (it.hasNext()) {
                sb5.append(it.next().getValue().toString());
            }
        } else if (msgItem instanceof MarkdownMsgItem) {
            String str2 = ((MarkdownMsgItem) msgItem).r2().content;
            if (str2 != null) {
                trim = StringsKt__StringsKt.trim((CharSequence) new Regex("!\\[([^\\]]+)\\]\\([^)]+\\)").replace(new Regex("\\[([^\\]]+)\\]\\([^)]+\\)").replace(new Regex("[`~]").replace(new Regex("[*_-]").replace(str2, ""), ""), "$1"), "$1"));
                str = trim.toString();
            } else {
                str = null;
            }
            sb5.append(String.valueOf(str));
        }
        String sb6 = sb5.toString();
        Intrinsics.checkNotNullExpressionValue(sb6, "content.toString()");
        return sb6;
    }

    @Override // com.tencent.qqnt.aio.api.IAIOTtsApi
    public boolean isMsgSupportTts(@Nullable com.tencent.aio.data.msglist.a msgItem) {
        AIOMsgItem aIOMsgItem;
        AdelieActionBarElement a16;
        ArrayList<InlineKeyboardRow> arrayList;
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) msgItem)).booleanValue();
        }
        if (msgItem instanceof AIOMsgItem) {
            aIOMsgItem = (AIOMsgItem) msgItem;
        } else {
            aIOMsgItem = null;
        }
        if (aIOMsgItem != null && (a16 = com.tencent.qqnt.aio.msg.d.a(aIOMsgItem)) != null && (arrayList = a16.rows) != null) {
            Iterator<T> it = arrayList.iterator();
            while (it.hasNext()) {
                ArrayList<InlineKeyboardButton> buttons = ((InlineKeyboardRow) it.next()).buttons;
                if (buttons != null) {
                    Intrinsics.checkNotNullExpressionValue(buttons, "buttons");
                    for (InlineKeyboardButton inlineKeyboardButton : buttons) {
                        if (inlineKeyboardButton != null && inlineKeyboardButton.type == 6) {
                            z16 = true;
                        } else {
                            z16 = false;
                        }
                        if (z16) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }
}
