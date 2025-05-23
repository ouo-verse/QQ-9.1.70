package bf;

import com.tencent.richframework.data.idata.IDataConverter;

/* compiled from: P */
/* loaded from: classes39.dex */
public class d implements IDataConverter<af.d> {
    @Override // com.tencent.richframework.data.idata.IDataConverter
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public af.d cloneConvertData(af.d dVar) {
        return new af.d(dVar.a(), dVar.b());
    }

    @Override // com.tencent.richframework.data.idata.IDataConverter
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public String getObserverKey(af.d dVar) {
        if (dVar == null) {
            return "";
        }
        return dVar.a();
    }

    @Override // com.tencent.richframework.data.idata.IDataConverter
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public void update(af.d dVar, af.d dVar2) {
        if (dVar == null || dVar2 == null) {
            return;
        }
        dVar.c(dVar2.b());
    }
}
