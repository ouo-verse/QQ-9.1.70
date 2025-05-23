package com.tencent.mobileqq.qcircle.api.db;

import android.content.ContentValues;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes16.dex */
public interface IDBManagerWrapper {
    public static final String TAG = "IDBManagerWrapper";

    /* compiled from: P */
    /* loaded from: classes16.dex */
    public interface OnCloseListener {
        void onClosed(IDBManagerWrapper iDBManagerWrapper);
    }

    void addCloseListener(OnCloseListener onCloseListener);

    void close();

    long dbDeleteData(String str);

    boolean dbInsertData(IDBCacheDataWrapper iDBCacheDataWrapper);

    boolean dbInsertData(IDBCacheDataWrapper iDBCacheDataWrapper, int i3);

    boolean dbInsertData(List<? extends IDBCacheDataWrapper> list);

    boolean dbInsertData(List<? extends IDBCacheDataWrapper> list, int i3);

    boolean dbInsertData(List<? extends IDBCacheDataWrapper> list, int i3, String str);

    List<IDBCacheDataWrapper> dbQueryData(String str, String str2);

    List<IDBCacheDataWrapper> dbQueryData(String str, String str2, int i3, int i16);

    IDBCacheDataWrapper dbQueryFirstData(String str, String str2);

    IDBCacheDataWrapper dbQueryFirstData(String str, String str2, String[] strArr);

    boolean dbUpdateData(ContentValues contentValues, String str);

    boolean dbUpdateData(ContentValues contentValues, String str, String[] strArr);

    boolean dbUpdateData(IDBCacheDataWrapper iDBCacheDataWrapper, String str);

    int deleteData(String str, String[] strArr);

    int getCount(String str);

    boolean isClosed();

    ArrayList<? extends IDBCacheDataWrapper> queryData();

    boolean saveData(IDBCacheDataWrapper iDBCacheDataWrapper, int i3);

    int updateData(IDBCacheDataWrapper iDBCacheDataWrapper, String str, String[] strArr);
}
