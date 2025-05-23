package ii;

import ci.h;
import com.qzone.reborn.albumx.common.convert.bean.CommonAlbumCommData;
import com.qzone.reborn.groupalbum.bean.init.GroupAlbumAlbumDetailInitBean;
import com.tencent.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import com.tencent.richframework.data.base.UIStateData;
import java.util.ArrayList;
import ki.g;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b*\u0010+J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\u0007\u001a\u00020\u0005H\u0016J\u0006\u0010\b\u001a\u00020\u0002J\u0010\u0010\u000b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tH\u0016R\"\u0010\u0013\u001a\u00020\f8\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R$\u0010\u001b\u001a\u0004\u0018\u00010\u00148\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\"\u0010#\u001a\u00020\u001c8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u0017\u0010)\u001a\u00020$8\u0006\u00a2\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(\u00a8\u0006,"}, d2 = {"Lii/b;", "Lii/a;", "", "e2", "f2", "", "U1", "W1", "removeListener", "Lci/h;", "requestBean", "X1", "Lcom/qzone/reborn/groupalbum/bean/init/GroupAlbumAlbumDetailInitBean;", "J", "Lcom/qzone/reborn/groupalbum/bean/init/GroupAlbumAlbumDetailInitBean;", "d2", "()Lcom/qzone/reborn/groupalbum/bean/init/GroupAlbumAlbumDetailInitBean;", SemanticAttributes.DbSystemValues.H2, "(Lcom/qzone/reborn/groupalbum/bean/init/GroupAlbumAlbumDetailInitBean;)V", "initBean", "Lki/g;", "K", "Lki/g;", "c2", "()Lki/g;", "g2", "(Lki/g;)V", "dataRepo", "", "L", "I", "getRightBoundIndex", "()I", "i2", "(I)V", "rightBoundIndex", "Lki/g$b;", "M", "Lki/g$b;", "getListener", "()Lki/g$b;", "listener", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class b extends ii.a {

    /* renamed from: J, reason: from kotlin metadata */
    public GroupAlbumAlbumDetailInitBean initBean;

    /* renamed from: K, reason: from kotlin metadata */
    private g dataRepo;

    /* renamed from: L, reason: from kotlin metadata */
    private int rightBoundIndex;

    /* renamed from: M, reason: from kotlin metadata */
    private final g.b listener = new a();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"ii/b$a", "Lki/g$b;", "Lcom/qzone/reborn/albumx/common/bean/b;", "repoBean", "", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes38.dex */
    public static final class a implements g.b {
        a() {
        }

        @Override // ki.g.b
        public void a(com.qzone.reborn.albumx.common.bean.b repoBean) {
            ArrayList<Integer> c16;
            Intrinsics.checkNotNullParameter(repoBean, "repoBean");
            if (repoBean instanceof ci.b) {
                b.this.S1().clear();
                CommonAlbumCommData commData = repoBean.getCommData();
                if (commData != null && (c16 = commData.c()) != null) {
                    b.this.S1().addAll(c16);
                }
                b.this.i2(repoBean.getRightBoundIndex());
                b.this.M1().postValue(UIStateData.obtainSuccess(false).setDataList(((ci.b) repoBean).getLayerListBean()));
            }
        }
    }

    private final void e2() {
        g gVar = this.dataRepo;
        if (gVar != null) {
            gVar.j(d2(), this.rightBoundIndex);
        }
        f2();
    }

    private final void f2() {
        g gVar = this.dataRepo;
        if (gVar != null) {
            gVar.p(d2().getAlbumId(), this.listener);
        }
    }

    @Override // ii.a
    public boolean U1() {
        g gVar = this.dataRepo;
        if (gVar != null) {
            return gVar.i();
        }
        return false;
    }

    @Override // ii.a
    public boolean W1() {
        return true;
    }

    @Override // ii.a
    public void X1(h requestBean) {
        Intrinsics.checkNotNullParameter(requestBean, "requestBean");
        if (getLoadInfo().getCurrentState() != 4) {
            return;
        }
        e2();
        g gVar = this.dataRepo;
        if (gVar != null) {
            gVar.x(requestBean);
        }
    }

    /* renamed from: c2, reason: from getter */
    public final g getDataRepo() {
        return this.dataRepo;
    }

    public final GroupAlbumAlbumDetailInitBean d2() {
        GroupAlbumAlbumDetailInitBean groupAlbumAlbumDetailInitBean = this.initBean;
        if (groupAlbumAlbumDetailInitBean != null) {
            return groupAlbumAlbumDetailInitBean;
        }
        Intrinsics.throwUninitializedPropertyAccessException("initBean");
        return null;
    }

    public final void g2(g gVar) {
        this.dataRepo = gVar;
    }

    public final void h2(GroupAlbumAlbumDetailInitBean groupAlbumAlbumDetailInitBean) {
        Intrinsics.checkNotNullParameter(groupAlbumAlbumDetailInitBean, "<set-?>");
        this.initBean = groupAlbumAlbumDetailInitBean;
    }

    public final void i2(int i3) {
        this.rightBoundIndex = i3;
    }

    public final void removeListener() {
        g gVar = this.dataRepo;
        if (gVar != null) {
            gVar.A(d2().getAlbumId(), this.listener);
        }
    }
}
