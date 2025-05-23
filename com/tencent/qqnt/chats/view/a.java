package com.tencent.qqnt.chats.view;

import android.graphics.Paint;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H&J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH&J\u0012\u0010\u000e\u001a\u00020\u00042\b\u0010\r\u001a\u0004\u0018\u00010\fH&J\b\u0010\u0010\u001a\u00020\u000fH&J\u0010\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0006H\u0016J\u0010\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0006H\u0016J\u0010\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0006H\u0016J\u0019\u0010\u0018\u001a\u00020\u00042\b\u0010\u0017\u001a\u0004\u0018\u00010\tH\u0016\u00a2\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u001aH\u0016\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/qqnt/chats/view/a;", "", "Landroid/graphics/drawable/Drawable;", "drawable", "", "setSummaryStatus", "", "prefix", "setSummaryPrefix", "", "color", "setSummaryTextColor", "Landroid/graphics/Shader;", "shader", "setSummaryContentShader", "Landroid/graphics/Paint;", "a", "allContent", "setSummaryAllContent", "content", "setSummaryContent", "nick", "setSummaryNick", "sendStatus", "setSummarySendStatus", "(Ljava/lang/Integer;)V", "", "resetSummary", "b", "chats_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public interface a {
    @NotNull
    Paint a();

    void b(boolean resetSummary);

    void setSummaryAllContent(@NotNull CharSequence allContent);

    void setSummaryContent(@NotNull CharSequence content);

    void setSummaryContentShader(@Nullable Shader shader);

    void setSummaryNick(@NotNull CharSequence nick);

    void setSummaryPrefix(@NotNull CharSequence prefix);

    void setSummarySendStatus(@Nullable Integer sendStatus);

    void setSummaryStatus(@Nullable Drawable drawable);

    void setSummaryTextColor(int color);

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* renamed from: com.tencent.qqnt.chats.view.a$a, reason: collision with other inner class name */
    /* loaded from: classes24.dex */
    public static final class C9601a {
        public static void b(@NotNull a aVar, @NotNull CharSequence allContent) {
            Intrinsics.checkNotNullParameter(allContent, "allContent");
        }

        public static void c(@NotNull a aVar, @NotNull CharSequence nick) {
            Intrinsics.checkNotNullParameter(nick, "nick");
        }

        public static void a(@NotNull a aVar, boolean z16) {
        }

        public static void d(@NotNull a aVar, @Nullable Integer num) {
        }
    }
}
