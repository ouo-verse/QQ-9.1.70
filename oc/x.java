package oc;

import com.qzone.reborn.albumx.common.convert.bean.CommonPhotoInfo;
import com.tencent.richframework.data.base.UIStateData;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ub.p;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u0018\u0010\u000b\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0016R.\u0010\u0014\u001a\u0004\u0018\u00010\f2\b\u0010\r\u001a\u0004\u0018\u00010\f8\u0006@FX\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u0017\u0010\u001a\u001a\u00020\u00158\u0006\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\u00a8\u0006\u001d"}, d2 = {"Loc/x;", "Loc/a;", "Lbb/i;", "Lbb/g;", "requestBean", "", "U1", "", "lloc", "", "commentNum", ICustomDataEditor.STRING_ARRAY_PARAM_2, "Lub/p;", "value", "J", "Lub/p;", "b2", "()Lub/p;", "c2", "(Lub/p;)V", "dataRepo", "Lub/p$b;", "K", "Lub/p$b;", "getListener", "()Lub/p$b;", "listener", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class x extends oc.a<bb.i> {

    /* renamed from: J, reason: from kotlin metadata */
    private ub.p dataRepo;

    /* renamed from: K, reason: from kotlin metadata */
    private final p.b listener = new a();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"oc/x$a", "Lub/p$b;", "Lcb/a;", "repoBean", "", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes38.dex */
    public static final class a implements p.b {
        a() {
        }

        @Override // ub.p.b
        public void a(cb.a repoBean) {
            Intrinsics.checkNotNullParameter(repoBean, "repoBean");
            x.this.M1().postValue(UIStateData.obtainSuccess(false).setDataList(repoBean.getLayerListBean()));
        }
    }

    @Override // oc.a
    public void U1(bb.g requestBean) {
        ub.p pVar;
        Intrinsics.checkNotNullParameter(requestBean, "requestBean");
        if (getLoadInfo().getCurrentState() == 4 && (pVar = this.dataRepo) != null) {
            pVar.w(requestBean);
        }
    }

    @Override // oc.a
    public void a2(String lloc, int commentNum) {
        Intrinsics.checkNotNullParameter(lloc, "lloc");
        ub.p pVar = this.dataRepo;
        if (pVar != null) {
            for (CommonPhotoInfo commonPhotoInfo : pVar.h()) {
                if (Intrinsics.areEqual(commonPhotoInfo.getMedia().k(), lloc)) {
                    commonPhotoInfo.getMedia().getComment().b(commentNum);
                }
            }
        }
    }

    /* renamed from: b2, reason: from getter */
    public final ub.p getDataRepo() {
        return this.dataRepo;
    }

    public final void c2(ub.p pVar) {
        List<p.b> g16;
        if (pVar != null && (g16 = pVar.g()) != null) {
            g16.add(this.listener);
        }
        this.dataRepo = pVar;
    }
}
