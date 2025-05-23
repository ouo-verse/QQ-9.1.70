package com.tencent.mobileqq.troop.shortcut.actions;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&J\u0012\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0004H\u0016J\b\u0010\u000b\u001a\u00020\tH\u0016\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/troop/shortcut/actions/a;", "", "Lcom/tencent/mobileqq/troop/shortcut/actions/TroopShortcutAction;", "action", "Lcom/tencent/mobileqq/troop/shortcut/actions/b;", "shortcutContext", "", "a", "aioContext", "", "b", "destroy", "qqtroop-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public interface a {
    boolean a(@NotNull TroopShortcutAction action, @NotNull b shortcutContext);

    void b(@Nullable b aioContext);

    void destroy();

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* renamed from: com.tencent.mobileqq.troop.shortcut.actions.a$a, reason: collision with other inner class name */
    /* loaded from: classes19.dex */
    public static final class C8771a {
        public static void a(@NotNull a aVar) {
        }

        public static void b(@NotNull a aVar, @Nullable b bVar) {
        }
    }
}
