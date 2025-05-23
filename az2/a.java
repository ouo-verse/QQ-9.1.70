package az2;

import az2.c;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.qroute.annotation.qautoinject.QAutoInitMethod;
import com.tencent.mobileqq.qroute.annotation.qautoinject.QAutoInject;
import com.tencent.qqlive.tvkplayer.tools.config.ITVKConfigRequester;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010J\b\u0010\u0003\u001a\u00020\u0002H\u0007J\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016R$\u0010\u000e\u001a\u0004\u0018\u00010\u00018\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\t\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r\u00a8\u0006\u0011"}, d2 = {"Laz2/a;", "Laz2/c;", "", "b", "", "appId", ITVKConfigRequester.ConfigRequestListener.EXTRA_KEY_EXP_NAME, "Laz2/c$a;", "a", "Laz2/c;", "getInstance", "()Laz2/c;", "setInstance", "(Laz2/c;)V", WadlProxyConsts.LOAD_CONFIG_FROM_INSTANCE, "<init>", "()V", "aio_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class a implements c {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f27386a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @QAutoInject(configPath = "AutoInjectYml/Business/Vas/Inject_ABTest.yml", version = 1)
    @Nullable
    private static c instance;

    /* renamed from: c, reason: collision with root package name */
    private static ArrayList f27388c;

    static {
        ArrayList arrayList = new ArrayList();
        f27388c = arrayList;
        arrayList.add(b.class);
        a aVar = new a();
        f27386a = aVar;
        aVar.b();
    }

    a() {
    }

    @Override // az2.c
    @NotNull
    public c.a a(@NotNull String appId, @NotNull String expName) {
        Intrinsics.checkNotNullParameter(appId, "appId");
        Intrinsics.checkNotNullParameter(expName, "expName");
        c cVar = instance;
        Intrinsics.checkNotNull(cVar);
        return cVar.a(appId, expName);
    }

    @QAutoInitMethod
    public final void b() {
        instance = (c) com.tencent.mobileqq.qroute.utils.b.a(f27388c);
    }
}
