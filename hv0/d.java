package hv0;

import com.tencent.icgame.game.live.impl.danmuku.DanmakuDataBean;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b&\u0018\u0000 \u000b2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0011B\u0017\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\u0006\u0010\f\u001a\u00020\u0004\u00a2\u0006\u0004\b\u000f\u0010\u0010J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0014R\u0014\u0010\f\u001a\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000b\u00a8\u0006\u0012"}, d2 = {"Lhv0/d;", "Lcom/tencent/common/danmaku/data/d;", "Lcom/tencent/icgame/game/live/impl/danmuku/b;", "", "", "J", "", "currTime", "", "x0", "H", "I", "type", "Lcom/tencent/common/danmaku/inject/b;", "danmakuContext", "<init>", "(Lcom/tencent/common/danmaku/inject/b;I)V", "a", "ic-game-timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes7.dex */
public abstract class d extends com.tencent.common.danmaku.data.d<DanmakuDataBean, Object> {

    /* renamed from: H, reason: from kotlin metadata */
    private final int type;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(@NotNull com.tencent.common.danmaku.inject.b danmakuContext, int i3) {
        super(danmakuContext);
        Intrinsics.checkNotNullParameter(danmakuContext, "danmakuContext");
        this.type = i3;
    }

    @Override // com.tencent.common.danmaku.data.a
    /* renamed from: J, reason: from getter */
    public int getType() {
        return this.type;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.common.danmaku.data.d
    public float x0(long currTime) {
        return super.x0(currTime);
    }
}
