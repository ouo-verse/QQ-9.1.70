package com.qzone.component.cache.database.table.photo;

import android.content.ContentValues;
import android.database.Cursor;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.lib.wrapper.db.IDBCacheDataWrapper;
import com.tencent.component.annotation.NeedParcel;
import com.tencent.component.app.common.SmartParcelable;

/* loaded from: classes39.dex */
public class USCPerformanceInfo extends com.qzone.component.cache.database.a implements SmartParcelable {
    public static final IDBCacheDataWrapper.a<USCPerformanceInfo> DB_CREATOR = new a();
    public static final int FUNCTION_COUNT = 31;
    public static final String TAG = "USCPerformanceInfo";
    private static final int VERSION = 3;
    public static final String tableName = "USCPerformanceInfoTB";

    @NeedParcel
    public float[] functionCostTime = new float[31];

    /* JADX INFO: Access modifiers changed from: private */
    public static String getColumnName(int i3) {
        return UserInfo.SEX_FEMALE + ((int) Math.pow(2.0d, i3));
    }

    /* loaded from: classes39.dex */
    class a implements IDBCacheDataWrapper.a<USCPerformanceInfo> {
        a() {
        }

        @Override // com.qzone.lib.wrapper.db.IDBCacheDataWrapper.a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public USCPerformanceInfo createFromCursor(Cursor cursor) {
            USCPerformanceInfo uSCPerformanceInfo = new USCPerformanceInfo();
            for (int i3 = 0; i3 < 31; i3++) {
                uSCPerformanceInfo.functionCostTime[i3] = cursor.getFloat(cursor.getColumnIndex(USCPerformanceInfo.getColumnName(i3)));
            }
            return uSCPerformanceInfo;
        }

        @Override // com.qzone.lib.wrapper.db.IDBCacheDataWrapper.a
        public String sortOrder() {
            return null;
        }

        @Override // com.qzone.lib.wrapper.db.IDBCacheDataWrapper.a
        public int version() {
            return 3;
        }

        @Override // com.qzone.lib.wrapper.db.IDBCacheDataWrapper.a
        public IDBCacheDataWrapper.c[] structure() {
            IDBCacheDataWrapper.c[] cVarArr = new IDBCacheDataWrapper.c[31];
            for (int i3 = 0; i3 < 31; i3++) {
                cVarArr[i3] = new IDBCacheDataWrapper.c(USCPerformanceInfo.getColumnName(i3), "REAL");
            }
            return cVarArr;
        }
    }

    @Override // com.qzone.lib.wrapper.db.IDBCacheDataWrapper
    public void writeTo(ContentValues contentValues) {
        for (int i3 = 0; i3 < 31; i3++) {
            contentValues.put(getColumnName(i3), Float.valueOf(this.functionCostTime[i3]));
        }
    }
}
