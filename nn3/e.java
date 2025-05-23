package nn3;

import com.tencent.mobileqq.qqlive.api.IQQLiveSDK;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import nn3.a;
import nn3.b;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R\u001c\u0010\u000e\u001a\n \f*\u0004\u0018\u00010\u000b0\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\rR\u0014\u0010\u0012\u001a\u00020\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R0\u0010\u0017\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040\u0013j\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0004`\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R0\u0010\u0019\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040\u0013j\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0004`\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0016\u00a8\u0006\u001c"}, d2 = {"Lnn3/e;", "Lnn3/d;", "", "roomId", "", "f", "Lcom/tencent/mobileqq/qqlive/api/IQQLiveSDK;", "liveSdk", "", "a", "b", "Lorg/slf4j/Logger;", "kotlin.jvm.PlatformType", "Lorg/slf4j/Logger;", "logger", "Lnn3/b;", "c", "Lnn3/b;", "gameDataModel", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "d", "Ljava/util/HashMap;", "preloadingState", "e", "cancelState", "<init>", "()V", "qq-live-od-logic-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes22.dex */
public final class e implements d {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final e f420547a = new e();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final Logger logger = LoggerFactory.getLogger("ODRoomDataPreLoader");

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final b gameDataModel = new b();

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final HashMap<Long, Boolean> preloadingState = new HashMap<>();

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final HashMap<Long, Boolean> cancelState = new HashMap<>();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u001a\u0010\f\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016\u00a8\u0006\r"}, d2 = {"nn3/e$a", "Lnn3/b$a;", "", "gameDetail", "Lnn3/c;", "gameExtraInfo", "", "a", "", "errCode", "", "errMsg", "onFailed", "qq-live-od-logic-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes22.dex */
    public static final class a implements b.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ long f420552a;

        a(long j3) {
            this.f420552a = j3;
        }

        @Override // nn3.b.a
        public void a(@Nullable byte[] gameDetail, @NotNull GameExtraInfo gameExtraInfo) {
            Intrinsics.checkNotNullParameter(gameExtraInfo, "gameExtraInfo");
            e.logger.info("preload gameDetail success");
            e.preloadingState.put(Long.valueOf(this.f420552a), Boolean.FALSE);
            if (e.f420547a.f(this.f420552a)) {
                e.logger.info("preload gameDetail success->canceled");
            } else {
                nn3.a.f420534a.a(this.f420552a, new a.GameData(gameDetail, gameExtraInfo));
            }
        }

        @Override // nn3.b.a
        public void onFailed(int errCode, @Nullable String errMsg) {
            e.logger.warn("preload gameDetail failed");
            e.preloadingState.put(Long.valueOf(this.f420552a), Boolean.FALSE);
            if (e.f420547a.f(this.f420552a)) {
                e.logger.info("preload gameDetail failed->canceled");
            }
        }
    }

    e() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean f(long roomId) {
        return Intrinsics.areEqual(cancelState.get(Long.valueOf(roomId)), Boolean.TRUE);
    }

    @Override // nn3.d
    public void a(@NotNull IQQLiveSDK liveSdk, long roomId) {
        Intrinsics.checkNotNullParameter(liveSdk, "liveSdk");
        Logger logger2 = logger;
        logger2.info("preload gameDetail->roomId:" + roomId);
        if (b(roomId)) {
            logger2.warn("preload gameDetail->is preloading");
            return;
        }
        cancelState.put(Long.valueOf(roomId), Boolean.FALSE);
        preloadingState.put(Long.valueOf(roomId), Boolean.TRUE);
        nn3.a.f420534a.b(roomId);
        gameDataModel.e(roomId, new a(roomId));
    }

    @Override // nn3.d
    public boolean b(long roomId) {
        Boolean bool = preloadingState.get(Long.valueOf(roomId));
        if (bool == null) {
            return false;
        }
        return bool.booleanValue();
    }
}
