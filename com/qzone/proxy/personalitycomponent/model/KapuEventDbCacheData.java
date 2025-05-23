package com.qzone.proxy.personalitycomponent.model;

import android.content.ContentValues;
import android.database.Cursor;
import com.qzone.component.cache.database.a;
import com.qzone.lib.wrapper.db.IDBCacheDataWrapper;

/* compiled from: P */
/* loaded from: classes39.dex */
public class KapuEventDbCacheData extends a {
    public static final String CACHE_TIME = "cache_time";
    public static final String COLUMN_AD_ID = "ad_id";
    public static final String COLUMN_EVENT_PIC = "event_pic";
    public static final String COLUMN_EVENT_TXT = "event_txt";
    public static final String COLUMN_HOST_CUSTOM_MSG_TXT = "host_custom_msg_txt";
    public static final String COLUMN_JUMP_TYPE = "jump_type";
    public static final String COLUMN_JUMP_URL = "jump_url";
    public static final String COLUMN_TRACE_INFO = "trace_info";
    public static final String COLUMN_UIN = "uin";
    public static IDBCacheDataWrapper.a<KapuEventDbCacheData> DB_CREATOR = new IDBCacheDataWrapper.a<KapuEventDbCacheData>() { // from class: com.qzone.proxy.personalitycomponent.model.KapuEventDbCacheData.1
        @Override // com.qzone.lib.wrapper.db.IDBCacheDataWrapper.a
        public String sortOrder() {
            return null;
        }

        @Override // com.qzone.lib.wrapper.db.IDBCacheDataWrapper.a
        public IDBCacheDataWrapper.c[] structure() {
            return new IDBCacheDataWrapper.c[]{new IDBCacheDataWrapper.c("uin", "INTEGER UNIQUE"), new IDBCacheDataWrapper.c(KapuEventDbCacheData.COLUMN_EVENT_PIC, "STRING"), new IDBCacheDataWrapper.c("jump_type", "STRING"), new IDBCacheDataWrapper.c("jump_url", "STRING"), new IDBCacheDataWrapper.c(KapuEventDbCacheData.COLUMN_EVENT_TXT, "STRING"), new IDBCacheDataWrapper.c(KapuEventDbCacheData.COLUMN_HOST_CUSTOM_MSG_TXT, "STRING"), new IDBCacheDataWrapper.c("cache_time", "INTEGER"), new IDBCacheDataWrapper.c("update_time", "INTEGER"), new IDBCacheDataWrapper.c("trace_info", "STRING"), new IDBCacheDataWrapper.c("ad_id", "INTEGER")};
        }

        @Override // com.qzone.lib.wrapper.db.IDBCacheDataWrapper.a
        public int version() {
            return 3;
        }

        @Override // com.qzone.lib.wrapper.db.IDBCacheDataWrapper.a
        public KapuEventDbCacheData createFromCursor(Cursor cursor) {
            KapuEventDbCacheData kapuEventDbCacheData = new KapuEventDbCacheData();
            kapuEventDbCacheData.uin = cursor.getLong(cursor.getColumnIndex("uin"));
            kapuEventDbCacheData.strEventPic = cursor.getString(cursor.getColumnIndex(KapuEventDbCacheData.COLUMN_EVENT_PIC));
            kapuEventDbCacheData.strJumpType = cursor.getString(cursor.getColumnIndex("jump_type"));
            kapuEventDbCacheData.strJumpUrl = cursor.getString(cursor.getColumnIndex("jump_url"));
            kapuEventDbCacheData.strEventTxt = cursor.getString(cursor.getColumnIndex(KapuEventDbCacheData.COLUMN_EVENT_TXT));
            kapuEventDbCacheData.cacheTime = cursor.getInt(cursor.getColumnIndex("cache_time"));
            kapuEventDbCacheData.updateTime = cursor.getInt(cursor.getColumnIndex("update_time"));
            kapuEventDbCacheData.traceinfo = cursor.getString(cursor.getColumnIndex("trace_info"));
            kapuEventDbCacheData.iAdID = cursor.getInt(cursor.getColumnIndex("ad_id"));
            kapuEventDbCacheData.strHostCustomMsgTxt = cursor.getString(cursor.getColumnIndex(KapuEventDbCacheData.COLUMN_HOST_CUSTOM_MSG_TXT));
            return kapuEventDbCacheData;
        }
    };
    public static final int DB_VERSION = 3;
    public static final String TYPE_AD_ID = "INTEGER";
    public static final String TYPE_CACHE_TIME = "INTEGER";
    public static final String TYPE_EVENT_PIC = "STRING";
    public static final String TYPE_EVENT_TXT = "STRING";
    public static final String TYPE_HOST_CUSTOM_MSG_TXT = "STRING";
    public static final String TYPE_JUMP_TYPE = "STRING";
    public static final String TYPE_JUMP_URL = "STRING";
    public static final String TYPE_TRACE_INFO = "STRING";
    public static final String TYPE_UIN = "INTEGER UNIQUE";
    public static final String TYPE_UPDATE_TIME = "INTEGER";
    public static final String UPDATE_TIME = "update_time";
    public long uin = 0;
    public String strEventPic = "";
    public String strJumpType = "";
    public String strJumpUrl = "";
    public String strEventTxt = "";
    public String traceinfo = "";
    public int iAdID = 0;
    public int cacheTime = 0;
    public int updateTime = 0;
    public String strHostCustomMsgTxt = "";

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("KapuEventDbCacheData{");
        stringBuffer.append("uin=");
        stringBuffer.append(this.uin);
        stringBuffer.append(", strEventPic='");
        stringBuffer.append(this.strEventPic);
        stringBuffer.append('\'');
        stringBuffer.append(", strJumpType='");
        stringBuffer.append(this.strJumpType);
        stringBuffer.append('\'');
        stringBuffer.append(", strJumpUrl='");
        stringBuffer.append(this.strJumpUrl);
        stringBuffer.append('\'');
        stringBuffer.append(", strEventTxt='");
        stringBuffer.append(this.strEventTxt);
        stringBuffer.append('\'');
        stringBuffer.append(", strHostCustomMsgTxt='");
        stringBuffer.append(this.strHostCustomMsgTxt);
        stringBuffer.append('\'');
        stringBuffer.append(", traceinfo='");
        stringBuffer.append(this.traceinfo);
        stringBuffer.append('\'');
        stringBuffer.append(", iAdID=");
        stringBuffer.append(this.iAdID);
        stringBuffer.append(", cacheTime=");
        stringBuffer.append(this.cacheTime);
        stringBuffer.append(", updateTime=");
        stringBuffer.append(this.updateTime);
        stringBuffer.append('}');
        return stringBuffer.toString();
    }

    @Override // com.qzone.lib.wrapper.db.IDBCacheDataWrapper
    public void writeTo(ContentValues contentValues) {
        contentValues.put("uin", Long.valueOf(this.uin));
        contentValues.put(COLUMN_EVENT_PIC, this.strEventPic);
        contentValues.put("jump_type", this.strJumpType);
        contentValues.put("jump_url", this.strJumpUrl);
        contentValues.put(COLUMN_EVENT_TXT, this.strEventTxt);
        contentValues.put(COLUMN_HOST_CUSTOM_MSG_TXT, this.strHostCustomMsgTxt);
        contentValues.put("cache_time", Integer.valueOf(this.cacheTime));
        contentValues.put("update_time", Integer.valueOf(this.updateTime));
        contentValues.put("trace_info", this.traceinfo);
        contentValues.put("ad_id", Integer.valueOf(this.iAdID));
    }
}
