package com.tencent.tbs.reader.external;

/* compiled from: P */
/* loaded from: classes26.dex */
public class TbsReaderTokenAtom implements ITbsReaderAtom {
    private final ITbsReaderAtom mAtomImp;

    public TbsReaderTokenAtom(ITbsReaderAtom iTbsReaderAtom) {
        this.mAtomImp = iTbsReaderAtom;
    }

    @Override // com.tencent.tbs.reader.external.ITbsReaderAtom
    public int getAtomType() {
        return 1;
    }

    @Override // com.tencent.tbs.reader.external.ITbsReaderAtom
    public int init(Object obj) {
        ITbsReaderAtom iTbsReaderAtom = this.mAtomImp;
        if (iTbsReaderAtom != null) {
            return iTbsReaderAtom.init(obj);
        }
        return -1;
    }
}
