package kc3;

import android.app.Activity;
import com.huawei.hms.support.feature.result.CommonConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B?\u0012\u0006\u0010\r\u001a\u00020\u0004\u0012\u0006\u0010\u0012\u001a\u00020\u0002\u0012\u0006\u0010\u0014\u001a\u00020\u0002\u0012\u0006\u0010\u0019\u001a\u00020\u0015\u0012\u0006\u0010\u001d\u001a\u00020\u001a\u0012\u0006\u0010\u001f\u001a\u00020\u0004\u0012\u0006\u0010#\u001a\u00020 \u00a2\u0006\u0004\b$\u0010%J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0012\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0014\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\u000f\u001a\u0004\b\t\u0010\u0011R\u0017\u0010\u0019\u001a\u00020\u00158\u0006\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0013\u0010\u0018R\u0017\u0010\u001d\u001a\u00020\u001a8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u001b\u001a\u0004\b\u0016\u0010\u001cR\u0017\u0010\u001f\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\n\u001a\u0004\b\u001e\u0010\fR\u0017\u0010#\u001a\u00020 8\u0006\u00a2\u0006\f\n\u0004\b\u001e\u0010!\u001a\u0004\b\u000e\u0010\"\u00a8\u0006&"}, d2 = {"Lkc3/a;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "I", "e", "()I", "mapId", "b", "Ljava/lang/String;", "f", "()Ljava/lang/String;", "openId", "c", CommonConstant.KEY_ACCESS_TOKEN, "Llc3/b;", "d", "Llc3/b;", "()Llc3/b;", "gameOptHandle", "Llc3/a;", "Llc3/a;", "()Llc3/a;", "judgeNotifier", "g", "source", "Landroid/app/Activity;", "Landroid/app/Activity;", "()Landroid/app/Activity;", "activityContext", "<init>", "(ILjava/lang/String;Ljava/lang/String;Llc3/b;Llc3/a;ILandroid/app/Activity;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: kc3.a, reason: from toString */
/* loaded from: classes38.dex */
public final /* data */ class GameJudgeParams {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final int mapId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final String openId;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final String accessToken;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private final lc3.b gameOptHandle;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    private final lc3.a judgeNotifier;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    private final int source;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata and from toString */
    private final Activity activityContext;

    public GameJudgeParams(int i3, String openId, String accessToken, lc3.b gameOptHandle, lc3.a judgeNotifier, int i16, Activity activityContext) {
        Intrinsics.checkNotNullParameter(openId, "openId");
        Intrinsics.checkNotNullParameter(accessToken, "accessToken");
        Intrinsics.checkNotNullParameter(gameOptHandle, "gameOptHandle");
        Intrinsics.checkNotNullParameter(judgeNotifier, "judgeNotifier");
        Intrinsics.checkNotNullParameter(activityContext, "activityContext");
        this.mapId = i3;
        this.openId = openId;
        this.accessToken = accessToken;
        this.gameOptHandle = gameOptHandle;
        this.judgeNotifier = judgeNotifier;
        this.source = i16;
        this.activityContext = activityContext;
    }

    /* renamed from: a, reason: from getter */
    public final String getAccessToken() {
        return this.accessToken;
    }

    /* renamed from: b, reason: from getter */
    public final Activity getActivityContext() {
        return this.activityContext;
    }

    /* renamed from: c, reason: from getter */
    public final lc3.b getGameOptHandle() {
        return this.gameOptHandle;
    }

    /* renamed from: d, reason: from getter */
    public final lc3.a getJudgeNotifier() {
        return this.judgeNotifier;
    }

    /* renamed from: e, reason: from getter */
    public final int getMapId() {
        return this.mapId;
    }

    /* renamed from: f, reason: from getter */
    public final String getOpenId() {
        return this.openId;
    }

    /* renamed from: g, reason: from getter */
    public final int getSource() {
        return this.source;
    }

    public int hashCode() {
        return (((((((((((this.mapId * 31) + this.openId.hashCode()) * 31) + this.accessToken.hashCode()) * 31) + this.gameOptHandle.hashCode()) * 31) + this.judgeNotifier.hashCode()) * 31) + this.source) * 31) + this.activityContext.hashCode();
    }

    public String toString() {
        return "GameJudgeParams(mapId=" + this.mapId + ", openId=" + this.openId + ", accessToken=" + this.accessToken + ", gameOptHandle=" + this.gameOptHandle + ", judgeNotifier=" + this.judgeNotifier + ", source=" + this.source + ", activityContext=" + this.activityContext + ")";
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GameJudgeParams)) {
            return false;
        }
        GameJudgeParams gameJudgeParams = (GameJudgeParams) other;
        return this.mapId == gameJudgeParams.mapId && Intrinsics.areEqual(this.openId, gameJudgeParams.openId) && Intrinsics.areEqual(this.accessToken, gameJudgeParams.accessToken) && Intrinsics.areEqual(this.gameOptHandle, gameJudgeParams.gameOptHandle) && Intrinsics.areEqual(this.judgeNotifier, gameJudgeParams.judgeNotifier) && this.source == gameJudgeParams.source && Intrinsics.areEqual(this.activityContext, gameJudgeParams.activityContext);
    }
}
