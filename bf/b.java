package bf;

import com.tencent.richframework.data.idata.IDataConverter;

/* compiled from: P */
/* loaded from: classes39.dex */
public class b implements IDataConverter<af.b> {
    @Override // com.tencent.richframework.data.idata.IDataConverter
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public af.b cloneConvertData(af.b bVar) {
        return new af.b(bVar.b(), bVar.a());
    }

    @Override // com.tencent.richframework.data.idata.IDataConverter
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public String getObserverKey(af.b bVar) {
        if (bVar == null) {
            return "";
        }
        return bVar.b();
    }

    @Override // com.tencent.richframework.data.idata.IDataConverter
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public void update(af.b bVar, af.b bVar2) {
        if (bVar == null || bVar2 == null) {
            return;
        }
        bVar.d(bVar2.a());
        bVar.e(bVar2.c());
    }
}
