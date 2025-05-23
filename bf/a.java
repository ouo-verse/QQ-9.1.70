package bf;

import com.tencent.richframework.data.idata.IDataConverter;

/* compiled from: P */
/* loaded from: classes39.dex */
public class a implements IDataConverter<af.a> {
    @Override // com.tencent.richframework.data.idata.IDataConverter
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public af.a cloneConvertData(af.a aVar) {
        return new af.a(aVar.getKey(), aVar.getCommInfo());
    }

    @Override // com.tencent.richframework.data.idata.IDataConverter
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public void update(af.a aVar, af.a aVar2) {
        aVar.c(aVar2.getCommInfo());
    }

    @Override // com.tencent.richframework.data.idata.IDataConverter
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public String getObserverKey(af.a aVar) {
        if (aVar == null) {
            return "";
        }
        return aVar.getKey();
    }
}
