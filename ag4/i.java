package ag4;

import android.app.Activity;
import androidx.annotation.Nullable;
import androidx.lifecycle.LiveData;
import java.util.List;
import java.util.Map;
import org.jetbrains.annotations.NotNull;
import trpc.yes.common.GameAuthOuterClass$AgreeGameAuthRsp;
import trpc.yes.common.GameAuthOuterClass$CancelGameAuthRsp;
import trpc.yes.common.GameAuthOuterClass$GetGameAuthRsp;
import trpc.yes.common.UserProxyCmdOuterClass$GetTgpaVersionInfoRsp;
import trpc.yes.common.YesGameInfoOuterClass$GetUserGameDefaultRoleRsp;
import trpc.yes.common.YesGameInfoOuterClass$GetUserGameRoleListRsp;
import trpc.yes.common.YesGameInfoOuterClass$SetUserGameDefaultRoleRsp;
import trpc.yes.common.YesGameInfoOuterClass$YesGameRoleAbsInfo;

/* compiled from: P */
/* loaded from: classes26.dex */
public interface i extends mm4.a {

    /* compiled from: P */
    /* loaded from: classes26.dex */
    public interface a extends c {
        void d(int i3, String str);

        void f();

        void g(GameAuthOuterClass$AgreeGameAuthRsp gameAuthOuterClass$AgreeGameAuthRsp);
    }

    /* compiled from: P */
    /* loaded from: classes26.dex */
    public interface b<T> {
        void i(boolean z16, int i3, String str, T t16);
    }

    /* compiled from: P */
    /* loaded from: classes26.dex */
    public interface c {
        void c();
    }

    /* compiled from: P */
    /* loaded from: classes26.dex */
    public interface d extends c {
        void a(YesGameInfoOuterClass$GetUserGameDefaultRoleRsp yesGameInfoOuterClass$GetUserGameDefaultRoleRsp);

        void b();

        void e(int i3, String str);
    }

    void A0(int i3);

    void A1(int i3, Activity activity, d dVar);

    @Nullable
    LiveData<YesGameInfoOuterClass$GetUserGameDefaultRoleRsp> B2(int i3);

    LiveData<YesGameInfoOuterClass$GetUserGameRoleListRsp> D2(int i3);

    void F3(int i3, Activity activity, Boolean bool, a aVar, d dVar);

    LiveData<GameAuthOuterClass$GetGameAuthRsp> G0(int i3);

    void I1(int i3, b<GameAuthOuterClass$GetGameAuthRsp> bVar);

    void I2(int i3, Activity activity, YesGameInfoOuterClass$GetUserGameRoleListRsp yesGameInfoOuterClass$GetUserGameRoleListRsp, d dVar);

    void J1(int i3, Activity activity, d dVar);

    void J2(int i3, b<GameAuthOuterClass$GetGameAuthRsp> bVar);

    boolean L1(int i3, Activity activity, @NotNull e eVar, boolean z16, ag4.d dVar);

    void M1(int i3, b<YesGameInfoOuterClass$GetUserGameRoleListRsp> bVar);

    void N2(int i3, Activity activity, Boolean bool, a aVar, d dVar, Map<String, String> map);

    boolean O2(int i3, Activity activity);

    boolean Q2(int i3);

    void Z(int i3, b<GameAuthOuterClass$CancelGameAuthRsp> bVar);

    void e1(int i3, YesGameInfoOuterClass$YesGameRoleAbsInfo yesGameInfoOuterClass$YesGameRoleAbsInfo, b<YesGameInfoOuterClass$SetUserGameDefaultRoleRsp> bVar);

    void e3(String str, int i3, boolean z16, pl4.d<UserProxyCmdOuterClass$GetTgpaVersionInfoRsp> dVar);

    void initRegisterDatabaseModelClass();

    void m2(int i3, b<YesGameInfoOuterClass$GetUserGameDefaultRoleRsp> bVar);

    void o3(int i3, Activity activity, List<String> list, Boolean bool, a aVar, d dVar);

    void q1(int i3, Activity activity, Boolean bool, a aVar, d dVar, Map<String, String> map);

    void s0(int i3, b<YesGameInfoOuterClass$GetUserGameDefaultRoleRsp> bVar);

    void s3(int i3, b<YesGameInfoOuterClass$GetUserGameRoleListRsp> bVar);
}
