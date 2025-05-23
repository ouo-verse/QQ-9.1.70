package com.tencent.mobileqq.vas.bubble;

import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0006\bg\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000fJ \u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H&J\u0012\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\u0002H&J\u0018\u0010\r\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H&\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/vas/bubble/IBubbleTextColorManager;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "", "bubbleId", "", "textColor", "Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "aioMsgItem", "calculateTransparentBubbleTextColor", "chatBgPath", "", "saveNativeAllChatBgMainPixel", "bubbleBgPath", "saveBubbleIsTransparent", "Companion", "a", "aio_api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {"all"})
/* loaded from: classes20.dex */
public interface IBubbleTextColorManager extends QRouteApi {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = Companion.f308855a;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u001a\u0010\u0007\u001a\u00020\u00028\u0006X\u0086D\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/vas/bubble/IBubbleTextColorManager$a;", "", "", "b", "I", "a", "()I", "ERROR_COLOR", "<init>", "()V", "aio_api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.vas.bubble.IBubbleTextColorManager$a, reason: from kotlin metadata */
    /* loaded from: classes20.dex */
    public static final class Companion {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ Companion f308855a = new Companion();

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        private static final int ERROR_COLOR = -2;

        Companion() {
        }

        public final int a() {
            return ERROR_COLOR;
        }
    }

    int calculateTransparentBubbleTextColor(@NotNull String bubbleId, int textColor, @NotNull AIOMsgItem aioMsgItem);

    void saveBubbleIsTransparent(@NotNull String bubbleBgPath, @NotNull String bubbleId);

    void saveNativeAllChatBgMainPixel(@Nullable String chatBgPath);
}
