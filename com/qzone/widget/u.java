package com.qzone.widget;

import NS_MOBILE_USERLOGO_TIMESTAMP.s_rc_tab_info;
import android.content.ContentValues;
import android.database.Cursor;
import android.os.Parcel;
import com.qzone.lib.wrapper.db.IDBCacheDataWrapper;
import com.tencent.qmethod.pandoraex.monitor.OaidMonitor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes37.dex */
public class u extends com.qzone.component.cache.database.a {
    public static final String COLUMN_EXPRESSION_LIST = "expression_list";
    public static final String COLUMN_EXPRESSION_MAP = "expression_map";
    public static final String COLUMN_NEW_MD5 = "new_md5";
    public static final String COLUMN_OLD_MD5 = "old_md5";
    public static final String COLUMN_TAB_ICON_URL = "tab_icon_url";
    public static final String COLUMN_TAB_ID = "tab_id";
    public static final IDBCacheDataWrapper.a<u> DB_CREATOR = new a();
    public static final String TYPE_EXPRESSION_LIST = "BLOB";
    public static final String TYPE_EXPRESSION_MAP = "BLOB";
    public static final String TYPE_NEW_MD5 = "TEXT";
    public static final String TYPE_OLD_MD5 = "TEXT";
    public static final String TYPE_TAB_ICON_URL = "TEXT";
    public static final String TYPE_TAB_ID = "INTEGER UNIQUE";
    public String newMd5;
    public String oldMd5;
    public int pageBeginIndex;
    public int pageEndIndex;
    public HashMap<Long, RapidCommentExpressionInfo> rcExpressionInfoMap;
    public ArrayList<Long> rcExpressionList;
    public String rcTabIconUrl;
    public long rcTabId;
    public int tabIndex;
    public int tabPageCount;

    /* compiled from: P */
    /* loaded from: classes37.dex */
    class a implements IDBCacheDataWrapper.a<u> {
        a() {
        }

        @Override // com.qzone.lib.wrapper.db.IDBCacheDataWrapper.a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public u createFromCursor(Cursor cursor) {
            u uVar = new u();
            uVar.rcTabId = cursor.getLong(cursor.getColumnIndex(u.COLUMN_TAB_ID));
            uVar.rcTabIconUrl = cursor.getString(cursor.getColumnIndex(u.COLUMN_TAB_ICON_URL));
            uVar.oldMd5 = cursor.getString(cursor.getColumnIndex(u.COLUMN_OLD_MD5));
            uVar.newMd5 = cursor.getString(cursor.getColumnIndex(u.COLUMN_NEW_MD5));
            byte[] blob = cursor.getBlob(cursor.getColumnIndex(u.COLUMN_EXPRESSION_LIST));
            Parcel obtain = Parcel.obtain();
            obtain.unmarshall(blob, 0, blob.length);
            obtain.setDataPosition(0);
            uVar.rcExpressionList = obtain.readArrayList(getClass().getClassLoader());
            OaidMonitor.parcelRecycle(obtain);
            byte[] blob2 = cursor.getBlob(cursor.getColumnIndex(u.COLUMN_EXPRESSION_MAP));
            Parcel obtain2 = Parcel.obtain();
            obtain2.unmarshall(blob2, 0, blob2.length);
            obtain2.setDataPosition(0);
            uVar.rcExpressionInfoMap = obtain2.readHashMap(getClass().getClassLoader());
            OaidMonitor.parcelRecycle(obtain2);
            return uVar;
        }

        @Override // com.qzone.lib.wrapper.db.IDBCacheDataWrapper.a
        public String sortOrder() {
            return null;
        }

        @Override // com.qzone.lib.wrapper.db.IDBCacheDataWrapper.a
        public IDBCacheDataWrapper.c[] structure() {
            return new IDBCacheDataWrapper.c[]{new IDBCacheDataWrapper.c(u.COLUMN_TAB_ID, "INTEGER UNIQUE"), new IDBCacheDataWrapper.c(u.COLUMN_TAB_ICON_URL, "TEXT"), new IDBCacheDataWrapper.c(u.COLUMN_OLD_MD5, "TEXT"), new IDBCacheDataWrapper.c(u.COLUMN_NEW_MD5, "TEXT"), new IDBCacheDataWrapper.c(u.COLUMN_EXPRESSION_LIST, "BLOB"), new IDBCacheDataWrapper.c(u.COLUMN_EXPRESSION_MAP, "BLOB")};
        }

        @Override // com.qzone.lib.wrapper.db.IDBCacheDataWrapper.a
        public int version() {
            return 1;
        }
    }

    public u() {
    }

    private void c(long j3, String str, ArrayList<Long> arrayList, String str2, String str3) {
        this.rcTabId = j3;
        this.rcTabIconUrl = str;
        this.rcExpressionList = arrayList;
        this.newMd5 = str2;
        if (str3 == null) {
            this.oldMd5 = "";
        } else {
            this.oldMd5 = str3;
        }
        if (arrayList != null) {
            this.rcExpressionInfoMap = new HashMap<>();
            Iterator<Long> it = arrayList.iterator();
            while (it.hasNext()) {
                Long next = it.next();
                RapidCommentExpressionInfo rapidCommentExpressionInfo = new RapidCommentExpressionInfo();
                rapidCommentExpressionInfo.f60640e = next.longValue();
                rapidCommentExpressionInfo.D = false;
                this.rcExpressionInfoMap.put(next, rapidCommentExpressionInfo);
            }
        }
    }

    @Override // com.qzone.lib.wrapper.db.IDBCacheDataWrapper
    public void writeTo(ContentValues contentValues) {
        contentValues.put(COLUMN_TAB_ID, Long.valueOf(this.rcTabId));
        contentValues.put(COLUMN_TAB_ICON_URL, this.rcTabIconUrl);
        contentValues.put(COLUMN_OLD_MD5, this.oldMd5);
        contentValues.put(COLUMN_NEW_MD5, this.newMd5);
        Parcel obtain = Parcel.obtain();
        obtain.setDataPosition(0);
        obtain.writeList(this.rcExpressionList);
        byte[] marshall = obtain.marshall();
        OaidMonitor.parcelRecycle(obtain);
        contentValues.put(COLUMN_EXPRESSION_LIST, marshall);
        Parcel obtain2 = Parcel.obtain();
        obtain2.setDataPosition(0);
        obtain2.writeMap(this.rcExpressionInfoMap);
        byte[] marshall2 = obtain2.marshall();
        OaidMonitor.parcelRecycle(obtain2);
        contentValues.put(COLUMN_EXPRESSION_MAP, marshall2);
    }

    public u(long j3, String str, ArrayList<Long> arrayList, String str2, String str3) {
        this();
        c(j3, str, arrayList, str2, str3);
    }

    public static u fromSRcTabInfo(s_rc_tab_info s_rc_tab_infoVar) {
        if (s_rc_tab_infoVar == null) {
            return null;
        }
        return new u(s_rc_tab_infoVar.tab_id, s_rc_tab_infoVar.tab_icon_url, s_rc_tab_infoVar.expression_list, s_rc_tab_infoVar.zip_md5_value, null);
    }
}
