package c82;

import com.tencent.trpcprotocol.kuolie.prompt.prompt.Prompt$CardInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\n\"\u0018\u0010\u0004\u001a\u00020\u0001*\u00020\u00008@X\u0080\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0002\u0010\u0003\"\u0018\u0010\b\u001a\u00020\u0005*\u00020\u00008@X\u0080\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007\"\u0018\u0010\n\u001a\u00020\u0001*\u00020\u00008@X\u0080\u0004\u00a2\u0006\u0006\u001a\u0004\b\t\u0010\u0003\"\u0018\u0010\f\u001a\u00020\u0001*\u00020\u00008@X\u0080\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000b\u0010\u0003\"\u0018\u0010\u000e\u001a\u00020\u0001*\u00020\u00008@X\u0080\u0004\u00a2\u0006\u0006\u001a\u0004\b\r\u0010\u0003\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/trpcprotocol/kuolie/prompt/prompt/Prompt$CardInfo;", "", "c", "(Lcom/tencent/trpcprotocol/kuolie/prompt/prompt/Prompt$CardInfo;)Ljava/lang/String;", "openId", "", "d", "(Lcom/tencent/trpcprotocol/kuolie/prompt/prompt/Prompt$CardInfo;)J", "tinyId", "a", "avatar", "b", "nick", "e", "userStatus", "matchfriend_impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes39.dex */
public final class a {
    public static final String a(Prompt$CardInfo prompt$CardInfo) {
        Intrinsics.checkNotNullParameter(prompt$CardInfo, "<this>");
        String str = prompt$CardInfo.mini_info.avatar.get();
        return str == null ? "" : str;
    }

    public static final String b(Prompt$CardInfo prompt$CardInfo) {
        Intrinsics.checkNotNullParameter(prompt$CardInfo, "<this>");
        String str = prompt$CardInfo.mini_info.nick.get();
        return str == null ? "" : str;
    }

    public static final String c(Prompt$CardInfo prompt$CardInfo) {
        Intrinsics.checkNotNullParameter(prompt$CardInfo, "<this>");
        String str = prompt$CardInfo.mini_info.open_id.get();
        return str == null ? "" : str;
    }

    public static final long d(Prompt$CardInfo prompt$CardInfo) {
        Intrinsics.checkNotNullParameter(prompt$CardInfo, "<this>");
        return prompt$CardInfo.mini_info.tiny_id.get();
    }

    public static final String e(Prompt$CardInfo prompt$CardInfo) {
        Intrinsics.checkNotNullParameter(prompt$CardInfo, "<this>");
        String str = prompt$CardInfo.mini_info.user_status.get();
        return str == null ? "" : str;
    }
}
