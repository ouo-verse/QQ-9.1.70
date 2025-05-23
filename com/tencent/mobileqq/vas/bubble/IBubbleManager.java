package com.tencent.mobileqq.vas.bubble;

import android.graphics.drawable.Drawable;
import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\bg\u0018\u0000 \u00192\u00020\u0001:\u0002\u001a\u001bJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0012\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0003\u001a\u00020\u0006H&J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0018\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH&J2\u0010\u0013\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0003\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0004H&J*\u0010\u0015\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0003\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0004H&J*\u0010\u0018\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0003\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0004H&\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/mobileqq/vas/bubble/IBubbleManager;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "", "bubbleId", "", "isShootBubble", "", "Lcom/tencent/mobileqq/vas/bubble/IBubbleManager$a;", "getBubbleTextInfo", "checkBubbleFile", "Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "msgItem", "", "startDownload", "diyId", "uin", "messageType", "isMirror", "Landroid/graphics/drawable/Drawable;", "getBackground", "message", "getAnimDrawable", "startX", "startY", "getShootAnimDrawable", "Companion", "a", "b", "aio_api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {"all"})
/* loaded from: classes20.dex */
public interface IBubbleManager extends QRouteApi {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = Companion.f308849a;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\f\u001a\u00020\u0004\u0012\u0006\u0010\u000e\u001a\u00020\u0004\u00a2\u0006\u0004\b\u000f\u0010\u0010J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\f\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\t\u0010\u000bR\u0017\u0010\u000e\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\n\u001a\u0004\b\r\u0010\u000b\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/vas/bubble/IBubbleManager$a;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "I", "()I", "color", "b", "linkColor", "<init>", "(II)V", "aio_api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.vas.bubble.IBubbleManager$a, reason: from toString */
    /* loaded from: classes20.dex */
    public static final /* data */ class BubbleTextInfo {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        private final int color;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        private final int linkColor;

        public BubbleTextInfo(int i3, int i16) {
            this.color = i3;
            this.linkColor = i16;
        }

        /* renamed from: a, reason: from getter */
        public final int getColor() {
            return this.color;
        }

        /* renamed from: b, reason: from getter */
        public final int getLinkColor() {
            return this.linkColor;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof BubbleTextInfo)) {
                return false;
            }
            BubbleTextInfo bubbleTextInfo = (BubbleTextInfo) other;
            if (this.color == bubbleTextInfo.color && this.linkColor == bubbleTextInfo.linkColor) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return (this.color * 31) + this.linkColor;
        }

        @NotNull
        public String toString() {
            return "BubbleTextInfo(color=" + this.color + ", linkColor=" + this.linkColor + ")";
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u000e\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0006\u001a\u00020\u00028\u0006X\u0086D\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005R\u001a\u0010\u000b\u001a\u00020\u00078\u0006X\u0086D\u00a2\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\b\u0010\nR\u001a\u0010\u000e\u001a\u00020\u00078\u0006X\u0086D\u00a2\u0006\f\n\u0004\b\f\u0010\t\u001a\u0004\b\r\u0010\nR\u001a\u0010\u0010\u001a\u00020\u00078\u0006X\u0086D\u00a2\u0006\f\n\u0004\b\u000f\u0010\t\u001a\u0004\b\f\u0010\nR\u001a\u0010\u0012\u001a\u00020\u00078\u0006X\u0086D\u00a2\u0006\f\n\u0004\b\u0011\u0010\t\u001a\u0004\b\u000f\u0010\n\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/vas/bubble/IBubbleManager$b;", "", "", "b", "Ljava/lang/String;", "()Ljava/lang/String;", "TAG", "", "c", "I", "()I", "TEXT_MESSAGE_TYPE", "d", "a", "IMG_MESSAGE_TYPE", "e", "VOICE_MESSAGE_TYPE", "f", "VOICE_PRINT_MESSAGE_TYPE", "<init>", "()V", "aio_api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.vas.bubble.IBubbleManager$b, reason: from kotlin metadata */
    /* loaded from: classes20.dex */
    public static final class Companion {

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        private static final int TEXT_MESSAGE_TYPE = 0;

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ Companion f308849a = new Companion();

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private static final String TAG = "BubbleManager";

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private static final int IMG_MESSAGE_TYPE = 1;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        private static final int VOICE_MESSAGE_TYPE = 2;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        private static final int VOICE_PRINT_MESSAGE_TYPE = 3;

        Companion() {
        }

        public final int a() {
            return IMG_MESSAGE_TYPE;
        }

        @NotNull
        public final String b() {
            return TAG;
        }

        public final int c() {
            return TEXT_MESSAGE_TYPE;
        }

        public final int d() {
            return VOICE_MESSAGE_TYPE;
        }

        public final int e() {
            return VOICE_PRINT_MESSAGE_TYPE;
        }
    }

    boolean checkBubbleFile(int bubbleId);

    @Nullable
    Drawable getAnimDrawable(@NotNull String bubbleId, @NotNull String message, int messageType, boolean isMirror);

    @Nullable
    Drawable getBackground(@NotNull String bubbleId, @NotNull String diyId, @NotNull String uin, int messageType, boolean isMirror);

    @Nullable
    BubbleTextInfo getBubbleTextInfo(@NotNull String bubbleId);

    @Nullable
    Drawable getShootAnimDrawable(@NotNull String bubbleId, int startX, int startY, boolean isMirror);

    boolean isShootBubble(int bubbleId);

    void startDownload(int bubbleId, @NotNull AIOMsgItem msgItem);
}
