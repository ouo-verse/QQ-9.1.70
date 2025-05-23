package com.qzone.widget;

import NS_MOBILE_USERLOGO_TIMESTAMP.s_rc_tab_info;
import NS_MOBILE_USERLOGO_TIMESTAMP.s_rc_tab_list;
import android.content.ContentValues;
import android.database.Cursor;
import com.qzone.lib.wrapper.db.IDBCacheDataWrapper;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes37.dex */
public class v extends com.qzone.component.cache.database.a {
    public static final String COLUMN_COMMENT_URL = "comment_url";
    public static final String COLUMN_COMMIT_PIC_SIZE = "commit_pic_size";
    public static final String COLUMN_TAB_NUM = "comment_tab_num";
    public static final String COLUMN_ZIP_NAME = "zip_name";
    public static final IDBCacheDataWrapper.a<v> DB_CREATOR = new a();
    public static final String STORE_KEY = "RcTabList";
    public static final String TYPE_COMMENT_URL = "TEXT";
    public static final String TYPE_COMMIT_PIC_SIZE = "INTEGER";
    public static final String TYPE_TAB_NUM = "INTEGER";
    public static final String TYPE_ZIP_NAME = "TEXT";
    public ArrayList<u> rapidCommentTabInfoList;
    public String rapidCommentUrl;
    public long rcCommitPicSize;
    public int rcTabNum;
    public String rcZipName;

    /* compiled from: P */
    /* loaded from: classes37.dex */
    class a implements IDBCacheDataWrapper.a<v> {
        a() {
        }

        @Override // com.qzone.lib.wrapper.db.IDBCacheDataWrapper.a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public v createFromCursor(Cursor cursor) {
            v vVar = new v();
            vVar.rapidCommentUrl = cursor.getString(cursor.getColumnIndex(v.COLUMN_COMMENT_URL));
            vVar.rcCommitPicSize = cursor.getLong(cursor.getColumnIndex(v.COLUMN_COMMIT_PIC_SIZE));
            vVar.rcZipName = cursor.getString(cursor.getColumnIndex(v.COLUMN_ZIP_NAME));
            vVar.rcTabNum = cursor.getInt(cursor.getColumnIndex(v.COLUMN_TAB_NUM));
            return vVar;
        }

        @Override // com.qzone.lib.wrapper.db.IDBCacheDataWrapper.a
        public String sortOrder() {
            return null;
        }

        @Override // com.qzone.lib.wrapper.db.IDBCacheDataWrapper.a
        public IDBCacheDataWrapper.c[] structure() {
            return new IDBCacheDataWrapper.c[]{new IDBCacheDataWrapper.c(v.COLUMN_COMMENT_URL, "TEXT"), new IDBCacheDataWrapper.c(v.COLUMN_COMMIT_PIC_SIZE, "INTEGER"), new IDBCacheDataWrapper.c(v.COLUMN_ZIP_NAME, "TEXT"), new IDBCacheDataWrapper.c(v.COLUMN_TAB_NUM, "INTEGER")};
        }

        @Override // com.qzone.lib.wrapper.db.IDBCacheDataWrapper.a
        public int version() {
            return 4;
        }
    }

    public v() {
    }

    @Override // com.qzone.lib.wrapper.db.IDBCacheDataWrapper
    public void writeTo(ContentValues contentValues) {
        contentValues.put(COLUMN_COMMENT_URL, this.rapidCommentUrl);
        contentValues.put(COLUMN_COMMIT_PIC_SIZE, Long.valueOf(this.rcCommitPicSize));
        contentValues.put(COLUMN_ZIP_NAME, this.rcZipName);
        contentValues.put(COLUMN_TAB_NUM, Integer.valueOf(this.rcTabNum));
    }

    public v(String str, long j3, ArrayList<u> arrayList, String str2) {
        this.rapidCommentUrl = str;
        this.rcCommitPicSize = j3;
        this.rapidCommentTabInfoList = arrayList;
        this.rcZipName = str2;
        this.rcTabNum = arrayList.size();
    }

    public static v createFromResponse(s_rc_tab_list s_rc_tab_listVar) {
        ArrayList<s_rc_tab_info> arrayList;
        if (s_rc_tab_listVar == null || (arrayList = s_rc_tab_listVar.rc_tab_list) == null || arrayList.size() == 0) {
            return null;
        }
        ArrayList arrayList2 = new ArrayList();
        Iterator<s_rc_tab_info> it = s_rc_tab_listVar.rc_tab_list.iterator();
        while (it.hasNext()) {
            arrayList2.add(u.fromSRcTabInfo(it.next()));
        }
        return new v(s_rc_tab_listVar.rapid_comment_url, s_rc_tab_listVar.rc_commit_pic_size, arrayList2, s_rc_tab_listVar.rc_zip_name);
    }
}
