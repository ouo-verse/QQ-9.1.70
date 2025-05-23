package gc0;

import com.tencent.biz.qqcircle.tedgers2.bean.QFSEdgeItem;
import com.tencent.biz.qqcircle.tedgers2.datapool.DataPoolConfig;
import java.util.List;

/* compiled from: P */
/* loaded from: classes5.dex */
public class b extends a {

    /* renamed from: g, reason: collision with root package name */
    private final DataPoolConfig.DetailType f401912g;

    public b(dc0.b bVar, DataPoolConfig dataPoolConfig) {
        super(bVar, dataPoolConfig.f92470g, dataPoolConfig.f92467d, dataPoolConfig.f92468e);
        this.f401912g = dataPoolConfig.f92469f;
    }

    @Override // fc0.a
    public void b(List<QFSEdgeItem> list) {
        super.b(list);
        if (this.f401912g == DataPoolConfig.DetailType.DETAIL_UPPER_ENABLE && n()) {
            g(d().size() - this.f401911f);
        }
    }

    @Override // fc0.a
    public void c(List<QFSEdgeItem> list, int i3) {
        super.c(list, i3);
        if (this.f401912g == DataPoolConfig.DetailType.DETAIL_UPPER_ENABLE && n()) {
            g(d().size() - this.f401911f);
        }
    }

    @Override // gc0.a
    protected String k() {
        return "DP-DetailItemPool";
    }
}
