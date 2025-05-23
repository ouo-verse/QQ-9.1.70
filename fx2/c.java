package fx2;

import com.tencent.tvideo.protocol.pb.ADVideoInfo;
import com.tencent.tvideo.protocol.pb.RewardAdSceneType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000b\u001a\u00020\n\u00a2\u0006\u0004\b\f\u0010\rR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b\u00a8\u0006\u000e"}, d2 = {"Lfx2/c;", "Lfx2/b;", "Lcom/tencent/tvideo/protocol/pb/ADVideoInfo;", "i", "Lcom/tencent/tvideo/protocol/pb/ADVideoInfo;", "k", "()Lcom/tencent/tvideo/protocol/pb/ADVideoInfo;", "l", "(Lcom/tencent/tvideo/protocol/pb/ADVideoInfo;)V", "mVideoInfo", "Lcom/tencent/tvideo/protocol/pb/RewardAdSceneType;", "mSceneType", "<init>", "(Lcom/tencent/tvideo/protocol/pb/RewardAdSceneType;)V", "MiniQAdSdk_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes19.dex */
public final class c extends b {

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ADVideoInfo mVideoInfo;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(@NotNull RewardAdSceneType mSceneType) {
        super(mSceneType);
        Intrinsics.checkNotNullParameter(mSceneType, "mSceneType");
    }

    @Nullable
    /* renamed from: k, reason: from getter */
    public final ADVideoInfo getMVideoInfo() {
        return this.mVideoInfo;
    }

    public final void l(@Nullable ADVideoInfo aDVideoInfo) {
        this.mVideoInfo = aDVideoInfo;
    }
}
