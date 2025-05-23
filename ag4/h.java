package ag4;

import android.app.Activity;
import java.util.HashMap;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import trpc.yes.common.YesGameInfoOuterClass$GameConfigInfo;

/* compiled from: P */
/* loaded from: classes26.dex */
public interface h extends mm4.a {
    List<Integer> C1();

    boolean D(int i3);

    int J(int i3);

    void N1(int i3, YesGameInfoOuterClass$GameConfigInfo yesGameInfoOuterClass$GameConfigInfo);

    String X0(int i3);

    void e2();

    HashMap<Integer, Integer> h1();

    void initRegisterDatabaseModelClass();

    void j();

    @NotNull
    YesGameInfoOuterClass$GameConfigInfo l1(int i3);

    int o1(int i3);

    boolean v2(Activity activity, int i3, boolean z16, boolean z17, String str, String str2, String str3, f fVar);

    void w1(com.tencent.timi.game.utils.i iVar);
}
