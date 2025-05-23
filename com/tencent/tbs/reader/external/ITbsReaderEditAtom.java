package com.tencent.tbs.reader.external;

/* compiled from: P */
/* loaded from: classes26.dex */
public interface ITbsReaderEditAtom extends ITbsReaderAtom {
    void enterEditMode();

    void enterFindMode();

    void enterFitScreen();

    void enterPlayMode();

    void exitEditMode();

    void exitFindMode();

    void exitFitScreen();

    void exitPlayMode();

    void findNext();

    void findPrev();

    void getOutLineData();

    boolean isDocModified();

    void revertEdit();

    void saveDoc(String str);

    void setDecryptPassWord(String str);

    void setFindText(String str);
}
