package f02;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import java.util.HashSet;
import java.util.Set;

/* compiled from: P */
/* loaded from: classes14.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private final String f397499a;

    /* renamed from: b, reason: collision with root package name */
    private final AppInterface f397500b;

    /* renamed from: c, reason: collision with root package name */
    private final Set<Long> f397501c = new HashSet();

    /* compiled from: P */
    /* loaded from: classes14.dex */
    public interface a {
        int a(IGProGuildInfo iGProGuildInfo);
    }

    public c(String str, AppInterface appInterface) {
        this.f397499a = str;
        this.f397500b = appInterface;
    }

    private int a(a aVar, int i3) {
        IGProGuildInfo guildInfo = ((IGPSService) this.f397500b.getRuntimeService(IGPSService.class, "")).getGuildInfo(this.f397499a);
        if (guildInfo == null) {
            return i3;
        }
        return aVar.a(guildInfo);
    }

    public int b() {
        return a(new a() { // from class: f02.b
            @Override // f02.c.a
            public final int a(IGProGuildInfo iGProGuildInfo) {
                return iGProGuildInfo.getGuildUnNotifyFlag();
            }
        }, 1);
    }
}
