package com.tencent.timi.game.live.impl.danmuku;

import android.content.Context;
import com.tencent.xweb.FileReaderHelper;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J*\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u0006H&J*\u0010\u000b\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u0006H&\u00a8\u0006\f"}, d2 = {"Lcom/tencent/timi/game/live/impl/danmuku/f;", "", "Landroid/content/Context;", "ctx", "", FileReaderHelper.TXT_EXT, "", "txtColor", "priority", "", "a", "b", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public interface f {

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes26.dex */
    public static final class a {
        public static /* synthetic */ void a(f fVar, Context context, String str, int i3, int i16, int i17, Object obj) {
            if (obj == null) {
                if ((i17 & 8) != 0) {
                    i16 = 10;
                }
                fVar.a(context, str, i3, i16);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: sendTextDanmaku");
        }

        public static /* synthetic */ void b(f fVar, Context context, String str, int i3, int i16, int i17, Object obj) {
            if (obj == null) {
                if ((i17 & 8) != 0) {
                    i16 = 10;
                }
                fVar.b(context, str, i3, i16);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: sendTextDanmakuWithBg");
        }
    }

    void a(@NotNull Context ctx, @NotNull String txt, int txtColor, int priority);

    void b(@NotNull Context ctx, @NotNull String txt, int txtColor, int priority);
}
