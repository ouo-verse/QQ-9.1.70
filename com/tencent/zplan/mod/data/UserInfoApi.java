package com.tencent.zplan.mod.data;

import com.tencent.qqlive.tvkplayer.api.ITVKPlayerEventListener;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\r\u0018\u0000 \u000e2\u00020\u0001:\u0001\u0005B\u0007\u00a2\u0006\u0004\b\f\u0010\rJ\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0004\u001a\u00020\u0002R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0006R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0004\u0010\u0006R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0006R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0006\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/zplan/mod/data/UserInfoApi;", "", "", "c", "b", "a", "Ljava/lang/String;", ITVKPlayerEventListener.KEY_USER_INFO, "openId", "mapId", "d", "uin", "<init>", "()V", "f", "zplan_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes27.dex */
public final class UserInfoApi {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private String userInfo = "";

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private String openId = "";

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private String mapId = "";

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private String uin = "";

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    private static final Lazy f385956e = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, (Function0) new Function0<UserInfoApi>() { // from class: com.tencent.zplan.mod.data.UserInfoApi$Companion$INSTANCE$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final UserInfoApi invoke() {
            return new UserInfoApi();
        }
    });

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fR\u001b\u0010\u0007\u001a\u00020\u00028FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\t\u0010\n\u00a8\u0006\r"}, d2 = {"Lcom/tencent/zplan/mod/data/UserInfoApi$a;", "", "Lcom/tencent/zplan/mod/data/UserInfoApi;", "INSTANCE$delegate", "Lkotlin/Lazy;", "a", "()Lcom/tencent/zplan/mod/data/UserInfoApi;", "INSTANCE", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "zplan_debug"}, k = 1, mv = {1, 4, 2})
    /* renamed from: com.tencent.zplan.mod.data.UserInfoApi$a, reason: from kotlin metadata */
    /* loaded from: classes27.dex */
    public static final class Companion {
        Companion() {
        }

        @NotNull
        public final UserInfoApi a() {
            return (UserInfoApi) UserInfoApi.f385956e.getValue();
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @NotNull
    public final String b() {
        String str = this.mapId;
        if (str == null) {
            return "";
        }
        return str;
    }

    @NotNull
    public final String c() {
        String str = this.openId;
        if (str == null) {
            return "";
        }
        return str;
    }
}
