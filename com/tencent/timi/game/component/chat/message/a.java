package com.tencent.timi.game.component.chat.message;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010%\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\u000e\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002J\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0002R \u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\t\u00a8\u0006\r"}, d2 = {"Lcom/tencent/timi/game/component/chat/message/a;", "", "", "cardType", "a", "height", "", "b", "", "Ljava/util/Map;", "mapHeight", "<init>", "()V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f376607a = new a();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Map<Integer, Integer> mapHeight = new LinkedHashMap();

    a() {
    }

    public final int a(int cardType) {
        Integer num = mapHeight.get(Integer.valueOf(cardType));
        if (num != null) {
            return num.intValue();
        }
        if (cardType != 1) {
            if (cardType != 2) {
                return fh4.b.b(134);
            }
            return fh4.b.b(134);
        }
        return fh4.b.b(194);
    }

    public final void b(int cardType, int height) {
        mapHeight.put(Integer.valueOf(cardType), Integer.valueOf(height));
    }
}
