package g81;

import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.aio.msg.ae;
import com.tencent.mobileqq.aio.msglist.holder.component.markdown.MarkdownMsgItem;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\u001a\f\u0010\u0002\u001a\u0004\u0018\u00010\u0001*\u00020\u0000\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "", "a", "aio_ext_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class a {
    @Nullable
    public static final String a(@NotNull AIOMsgItem aIOMsgItem) {
        CharSequence u26;
        Intrinsics.checkNotNullParameter(aIOMsgItem, "<this>");
        if (aIOMsgItem instanceof MarkdownMsgItem) {
            String str = ((MarkdownMsgItem) aIOMsgItem).r2().content;
            if (str == null) {
                return null;
            }
            new Regex("[*_-]").replace(str, "");
            new Regex("[`~]").replace(str, "");
            new Regex("\\[([^\\]]+)\\]\\([^)]+\\)").replace(str, "$1");
            new Regex("!\\[([^\\]]+)\\]\\([^)]+\\)").replace(str, "$1");
            return str;
        }
        if (!(aIOMsgItem instanceof ae) || (u26 = ((ae) aIOMsgItem).u2()) == null) {
            return null;
        }
        return u26.toString();
    }
}
