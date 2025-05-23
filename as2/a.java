package as2;

import com.tencent.qqnt.kernel.nativeinterface.AIVoiceChatType;
import kotlin.Metadata;
import kotlin.collections.ArraysKt___ArraysKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\n\u0010\u0002\u001a\u00020\u0001*\u00020\u0000\u00a8\u0006\u0003"}, d2 = {"", "Lcom/tencent/qqnt/kernel/nativeinterface/AIVoiceChatType;", "a", "base_proj_nt_ext_api_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class a {
    @NotNull
    public static final AIVoiceChatType a(int i3) {
        Object orNull;
        orNull = ArraysKt___ArraysKt.getOrNull(AIVoiceChatType.values(), i3);
        AIVoiceChatType aIVoiceChatType = (AIVoiceChatType) orNull;
        if (aIVoiceChatType == null) {
            return AIVoiceChatType.KAIVOICECHATTYPEUNKNOWN;
        }
        return aIVoiceChatType;
    }
}
