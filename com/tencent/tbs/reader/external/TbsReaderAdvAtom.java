package com.tencent.tbs.reader.external;

/* compiled from: P */
/* loaded from: classes26.dex */
public class TbsReaderAdvAtom implements ITbsReaderEditAtom {
    protected ITbsReaderEditAtom mReaderAtom;

    public TbsReaderAdvAtom(ITbsReaderEditAtom iTbsReaderEditAtom) {
        this.mReaderAtom = iTbsReaderEditAtom;
    }

    public void destory() {
        this.mReaderAtom = null;
    }

    @Override // com.tencent.tbs.reader.external.ITbsReaderEditAtom
    public void enterEditMode() {
        ITbsReaderEditAtom iTbsReaderEditAtom = this.mReaderAtom;
        if (iTbsReaderEditAtom != null) {
            iTbsReaderEditAtom.enterEditMode();
        }
    }

    @Override // com.tencent.tbs.reader.external.ITbsReaderEditAtom
    public void enterFindMode() {
        ITbsReaderEditAtom iTbsReaderEditAtom = this.mReaderAtom;
        if (iTbsReaderEditAtom != null) {
            iTbsReaderEditAtom.enterFindMode();
        }
    }

    @Override // com.tencent.tbs.reader.external.ITbsReaderEditAtom
    public void enterFitScreen() {
        ITbsReaderEditAtom iTbsReaderEditAtom = this.mReaderAtom;
        if (iTbsReaderEditAtom != null) {
            iTbsReaderEditAtom.enterFitScreen();
        }
    }

    @Override // com.tencent.tbs.reader.external.ITbsReaderEditAtom
    public void enterPlayMode() {
        ITbsReaderEditAtom iTbsReaderEditAtom = this.mReaderAtom;
        if (iTbsReaderEditAtom != null) {
            iTbsReaderEditAtom.enterPlayMode();
        }
    }

    @Override // com.tencent.tbs.reader.external.ITbsReaderEditAtom
    public void exitEditMode() {
        ITbsReaderEditAtom iTbsReaderEditAtom = this.mReaderAtom;
        if (iTbsReaderEditAtom != null) {
            iTbsReaderEditAtom.exitEditMode();
        }
    }

    @Override // com.tencent.tbs.reader.external.ITbsReaderEditAtom
    public void exitFindMode() {
        ITbsReaderEditAtom iTbsReaderEditAtom = this.mReaderAtom;
        if (iTbsReaderEditAtom != null) {
            iTbsReaderEditAtom.exitFindMode();
        }
    }

    @Override // com.tencent.tbs.reader.external.ITbsReaderEditAtom
    public void exitFitScreen() {
        ITbsReaderEditAtom iTbsReaderEditAtom = this.mReaderAtom;
        if (iTbsReaderEditAtom != null) {
            iTbsReaderEditAtom.exitFitScreen();
        }
    }

    @Override // com.tencent.tbs.reader.external.ITbsReaderEditAtom
    public void exitPlayMode() {
        ITbsReaderEditAtom iTbsReaderEditAtom = this.mReaderAtom;
        if (iTbsReaderEditAtom != null) {
            iTbsReaderEditAtom.exitPlayMode();
        }
    }

    @Override // com.tencent.tbs.reader.external.ITbsReaderEditAtom
    public void findNext() {
        ITbsReaderEditAtom iTbsReaderEditAtom = this.mReaderAtom;
        if (iTbsReaderEditAtom != null) {
            iTbsReaderEditAtom.findNext();
        }
    }

    @Override // com.tencent.tbs.reader.external.ITbsReaderEditAtom
    public void findPrev() {
        ITbsReaderEditAtom iTbsReaderEditAtom = this.mReaderAtom;
        if (iTbsReaderEditAtom != null) {
            iTbsReaderEditAtom.findPrev();
        }
    }

    @Override // com.tencent.tbs.reader.external.ITbsReaderAtom
    public int getAtomType() {
        return 2;
    }

    @Override // com.tencent.tbs.reader.external.ITbsReaderEditAtom
    public void getOutLineData() {
        ITbsReaderEditAtom iTbsReaderEditAtom = this.mReaderAtom;
        if (iTbsReaderEditAtom != null) {
            iTbsReaderEditAtom.getOutLineData();
        }
    }

    @Override // com.tencent.tbs.reader.external.ITbsReaderAtom
    public int init(Object obj) {
        ITbsReaderEditAtom iTbsReaderEditAtom = this.mReaderAtom;
        if (iTbsReaderEditAtom != null) {
            return iTbsReaderEditAtom.init(obj);
        }
        return -1;
    }

    @Override // com.tencent.tbs.reader.external.ITbsReaderEditAtom
    public boolean isDocModified() {
        ITbsReaderEditAtom iTbsReaderEditAtom = this.mReaderAtom;
        if (iTbsReaderEditAtom != null) {
            return iTbsReaderEditAtom.isDocModified();
        }
        return false;
    }

    @Override // com.tencent.tbs.reader.external.ITbsReaderEditAtom
    public void revertEdit() {
        ITbsReaderEditAtom iTbsReaderEditAtom = this.mReaderAtom;
        if (iTbsReaderEditAtom != null) {
            iTbsReaderEditAtom.revertEdit();
        }
    }

    @Override // com.tencent.tbs.reader.external.ITbsReaderEditAtom
    public void saveDoc(String str) {
        ITbsReaderEditAtom iTbsReaderEditAtom = this.mReaderAtom;
        if (iTbsReaderEditAtom != null) {
            iTbsReaderEditAtom.saveDoc(str);
        }
    }

    @Override // com.tencent.tbs.reader.external.ITbsReaderEditAtom
    public void setDecryptPassWord(String str) {
        ITbsReaderEditAtom iTbsReaderEditAtom = this.mReaderAtom;
        if (iTbsReaderEditAtom != null) {
            iTbsReaderEditAtom.setDecryptPassWord(str);
        }
    }

    @Override // com.tencent.tbs.reader.external.ITbsReaderEditAtom
    public void setFindText(String str) {
        ITbsReaderEditAtom iTbsReaderEditAtom = this.mReaderAtom;
        if (iTbsReaderEditAtom != null) {
            iTbsReaderEditAtom.setFindText(str);
        }
    }
}
