package du0;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00102\u00020\u0001:\u0001\tB\u0007\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u0016\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002R\"\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\b0\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\"\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\f0\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\n\u00a8\u0006\u0011"}, d2 = {"Ldu0/b;", "", "", "chatId", "msgId", "", "b", "", "Lcom/tencent/icgame/game/tim/api/message/b;", "a", "Ljava/util/Map;", "msgListenerMap", "Lcom/tencent/icgame/game/tim/api/message/c;", "msgManagerMap", "<init>", "()V", "c", "ic-game-timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes7.dex */
public final class b {

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    private static final b f394855d = new b();

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    private static Map<String, List<String>> f394856e = new HashMap();

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private Map<String, com.tencent.icgame.game.tim.api.message.b> msgListenerMap = new HashMap();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private Map<String, com.tencent.icgame.game.tim.api.message.c> msgManagerMap = new HashMap();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\t"}, d2 = {"Ldu0/b$a;", "", "Ldu0/b;", "stance", "Ldu0/b;", "a", "()Ldu0/b;", "<init>", "()V", "ic-game-timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: du0.b$a, reason: from kotlin metadata */
    /* loaded from: classes7.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final b a() {
            return b.f394855d;
        }

        Companion() {
        }
    }

    public final void b(@NotNull String chatId, @NotNull String msgId) {
        List<String> list;
        Intrinsics.checkNotNullParameter(chatId, "chatId");
        Intrinsics.checkNotNullParameter(msgId, "msgId");
        if (!TextUtils.isEmpty(msgId)) {
            List<String> list2 = f394856e.get(chatId);
            boolean z16 = false;
            if (list2 != null && list2.contains(msgId)) {
                z16 = true;
            }
            if (z16 && (list = f394856e.get(chatId)) != null) {
                list.remove(msgId);
            }
        }
    }
}
