package bf;

import com.tencent.richframework.data.idata.IDataConverter;

/* compiled from: P */
/* loaded from: classes39.dex */
public class c implements IDataConverter<af.c> {
    @Override // com.tencent.richframework.data.idata.IDataConverter
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public af.c cloneConvertData(af.c cVar) {
        return new af.c(cVar.a(), cVar.b());
    }

    @Override // com.tencent.richframework.data.idata.IDataConverter
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public String getObserverKey(af.c cVar) {
        if (cVar == null) {
            return "";
        }
        return cVar.a();
    }

    @Override // com.tencent.richframework.data.idata.IDataConverter
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public void update(af.c cVar, af.c cVar2) {
        if (cVar == null || cVar2 == null) {
            return;
        }
        cVar.c(cVar2.b());
    }
}
