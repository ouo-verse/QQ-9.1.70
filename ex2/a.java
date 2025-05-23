package ex2;

import com.tencent.tvideo.protocol.pb.RewardAdSceneType;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u000b\u0018\u0000 \u00142\u00020\u0001:\u0001\u0003B\u0007\u00a2\u0006\u0004\b\u0016\u0010\u0017R$\u0010\b\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005\"\u0004\b\u0006\u0010\u0007R$\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0005\"\u0004\b\u000b\u0010\u0007R\"\u0010\u0013\u001a\u00020\r8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u000e\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\"\u0010\u0015\u001a\u00020\r8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u000f\u001a\u0004\b\t\u0010\u0010\"\u0004\b\u0014\u0010\u0012\u00a8\u0006\u0018"}, d2 = {"Lex2/a;", "", "", "a", "Ljava/lang/String;", "()Ljava/lang/String;", "setCid", "(Ljava/lang/String;)V", "cid", "b", "d", "setVid", "vid", "", "c", "I", "()I", "f", "(I)V", "total", "e", "process", "<init>", "()V", "MiniQAdSdk_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes19.dex */
public final class a {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String cid;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String vid;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private int total;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private int process;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u00a8\u0006\b"}, d2 = {"Lex2/a$a;", "", "Lcom/tencent/tvideo/protocol/pb/RewardAdSceneType;", "sceneType", "", "a", "<init>", "()V", "MiniQAdSdk_debug"}, k = 1, mv = {1, 4, 2})
    /* renamed from: ex2.a$a, reason: collision with other inner class name and from kotlin metadata */
    /* loaded from: classes19.dex */
    public static final class Companion {
        Companion() {
        }

        public final boolean a(@Nullable RewardAdSceneType sceneType) {
            if (RewardAdSceneType.REWARD_AD_SCENE_TYPE_QQ_VIDEO == sceneType) {
                return true;
            }
            return false;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Nullable
    /* renamed from: a, reason: from getter */
    public final String getCid() {
        return this.cid;
    }

    /* renamed from: b, reason: from getter */
    public final int getProcess() {
        return this.process;
    }

    /* renamed from: c, reason: from getter */
    public final int getTotal() {
        return this.total;
    }

    @Nullable
    /* renamed from: d, reason: from getter */
    public final String getVid() {
        return this.vid;
    }

    public final void e(int i3) {
        this.process = i3;
    }

    public final void f(int i3) {
        this.total = i3;
    }
}
