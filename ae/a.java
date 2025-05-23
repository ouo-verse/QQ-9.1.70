package ae;

import com.tencent.richframework.data.idata.IDataConverter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001B\u0007\u00a2\u0006\u0004\b\f\u0010\rJ\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0016J\u0012\u0010\u000b\u001a\u00020\u00022\b\u0010\n\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u000e"}, d2 = {"Lae/a;", "Lcom/tencent/richframework/data/idata/IDataConverter;", "Lzd/a;", "fromObj", "", "b", "oldObj", "latestObj", "", "c", "preObj", "a", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes39.dex */
public final class a implements IDataConverter<zd.a> {
    @Override // com.tencent.richframework.data.idata.IDataConverter
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public zd.a cloneConvertData(zd.a preObj) {
        return new zd.a(preObj != null ? preObj.getDataCenterPageId() : null, preObj != null ? preObj.getFeedUniKey() : null, preObj != null ? preObj.getCellComment() : null);
    }

    @Override // com.tencent.richframework.data.idata.IDataConverter
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public void update(zd.a oldObj, zd.a latestObj) {
        Intrinsics.checkNotNullParameter(oldObj, "oldObj");
        Intrinsics.checkNotNullParameter(latestObj, "latestObj");
        oldObj.d(latestObj.getCellComment());
    }

    @Override // com.tencent.richframework.data.idata.IDataConverter
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public String getObserverKey(zd.a fromObj) {
        if (fromObj == null) {
            return "";
        }
        return fromObj.getDataCenterPageId() + "_" + fromObj.getFeedUniKey();
    }
}
