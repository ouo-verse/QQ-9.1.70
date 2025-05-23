package fn;

import bn.c;
import com.tencent.richframework.data.idata.IDataConverter;

/* compiled from: P */
/* loaded from: classes38.dex */
public class b implements IDataConverter<c> {
    @Override // com.tencent.richframework.data.idata.IDataConverter
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public c cloneConvertData(c cVar) {
        return new c(cVar.a(), cVar.b());
    }

    @Override // com.tencent.richframework.data.idata.IDataConverter
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public String getObserverKey(c cVar) {
        if (cVar != null && cVar.b() != null) {
            return cVar.b().f430362id.get();
        }
        return "";
    }

    @Override // com.tencent.richframework.data.idata.IDataConverter
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public void update(c cVar, c cVar2) {
        if (cVar == null || cVar2 == null) {
            return;
        }
        cVar.c(cVar2.b());
    }
}
