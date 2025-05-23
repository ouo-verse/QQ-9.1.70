package com.tencent.tbs.reader.external;

/* compiled from: P */
/* loaded from: classes26.dex */
public interface ITbsReaderAtom {
    public static final int TBS_READER_ATOM_SUCCESS = 0;
    public static final int TBS_READER_ATOM_TYPE_EDIT = 2;
    public static final int TBS_READER_ATOM_TYPE_TOKEN = 1;

    int getAtomType();

    int init(Object obj);
}
