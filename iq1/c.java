package iq1;

import com.heytap.databaseengine.model.UserInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\f\u001a\u00020\u000b\u00a2\u0006\u0004\b\r\u0010\u000eJ\b\u0010\u0003\u001a\u00020\u0002H\u0016R\"\u0010\n\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t\u00a8\u0006\u000f"}, d2 = {"Liq1/c;", "Liq1/e;", "", "I", "J", UserInfo.SEX_FEMALE, "getOffsetY", "()F", "setOffsetY", "(F)V", "offsetY", "Lcom/tencent/common/danmaku/inject/b;", "danmakuContext", "<init>", "(Lcom/tencent/common/danmaku/inject/b;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class c extends e {

    /* renamed from: J, reason: from kotlin metadata */
    private float offsetY;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(@NotNull com.tencent.common.danmaku.inject.b danmakuContext) {
        super(danmakuContext, 2);
        Intrinsics.checkNotNullParameter(danmakuContext, "danmakuContext");
    }

    @Override // com.tencent.common.danmaku.data.d, com.tencent.common.danmaku.data.a
    public float I() {
        return super.I() + this.offsetY;
    }
}
