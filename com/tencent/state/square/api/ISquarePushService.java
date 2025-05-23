package com.tencent.state.square.api;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bJ\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\b\u0010\b\u001a\u00020\u0003H&J\b\u0010\t\u001a\u00020\u0003H&J\u0018\u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&\u00a8\u0006\f"}, d2 = {"Lcom/tencent/state/square/api/ISquarePushService;", "", "addListener", "", "type", "", "listener", "Lcom/tencent/state/square/api/ISquarePushListener;", "init", "release", "removeListener", "Companion", "square_base_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes26.dex */
public interface ISquarePushService {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = Companion.$$INSTANCE;
    public static final int PUSH_TYPE_FOOT_LABEL_UPDATE = 8;
    public static final int PUSH_TYPE_INTERACTION_UNREAD = 5;
    public static final int PUSH_TYPE_LIBRARY_FLOATING = 6;
    public static final int PUSH_TYPE_LIBRARY_LABEL = 4;
    public static final int PUSH_TYPE_LIKE = 3;
    public static final int PUSH_TYPE_PUBLIC_CHAT = 9;
    public static final int PUSH_TYPE_STATUS_CUSTOM_TEXT_BEAT = 2;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/state/square/api/ISquarePushService$Companion;", "", "()V", "PUSH_TYPE_FOOT_LABEL_UPDATE", "", "PUSH_TYPE_INTERACTION_UNREAD", "PUSH_TYPE_LIBRARY_FLOATING", "PUSH_TYPE_LIBRARY_LABEL", "PUSH_TYPE_LIKE", "PUSH_TYPE_PUBLIC_CHAT", "PUSH_TYPE_STATUS_CUSTOM_TEXT_BEAT", "square_base_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes26.dex */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        public static final int PUSH_TYPE_FOOT_LABEL_UPDATE = 8;
        public static final int PUSH_TYPE_INTERACTION_UNREAD = 5;
        public static final int PUSH_TYPE_LIBRARY_FLOATING = 6;
        public static final int PUSH_TYPE_LIBRARY_LABEL = 4;
        public static final int PUSH_TYPE_LIKE = 3;
        public static final int PUSH_TYPE_PUBLIC_CHAT = 9;
        public static final int PUSH_TYPE_STATUS_CUSTOM_TEXT_BEAT = 2;

        Companion() {
        }
    }

    void addListener(int type, @NotNull ISquarePushListener listener);

    void init();

    void release();

    void removeListener(int type, @NotNull ISquarePushListener listener);
}
