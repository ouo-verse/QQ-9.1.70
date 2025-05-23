package com.qzone.personalize.model;

import NS_QMALL_COVER.QzmallCustomNavi;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import com.qzone.lib.wrapper.db.IDBCacheDataWrapper;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes39.dex */
public class CustomNaviCacheData extends com.qzone.component.cache.database.a implements Parcelable {
    public static final String ACTIVE_FEED_URL = "activeFeedUrl";
    public static final String ARROW_COLOR = "arrowColor";
    public static final String BTN_TEXT_COLOR = "btnTextColor";
    public static final int COSTOM_NAVI_ID_NONE = -1;
    public static final IDBCacheDataWrapper.a<CustomNaviCacheData> DB_CREATOR = new a();
    public static final String ITEM_ID = "itemId";
    public static final String PARAM_CACHE_DATA = "CustomNaviCacheData";
    public static final String PROFILE_CORSS_BAR_SEP_COLOR = "profileCrossBarSeparatorColor";
    public static final String PROFILE_CROSS_BAR_BG_COLOR = "profileCrossBarBgColor";
    public static final String PROFILE_DESC_TEXT_COLOR = "profileDescTextColor";
    public static final String PROFILE_FEED_URL = "profileNaviUrl";
    public static final String SEPARATOR_COLOR = "separatorColor";
    public static final String TYPE_ACTIVE_FEED_URL = "TEXT";
    public static final String TYPE_ARROW_COLOR = "LONG";
    public static final String TYPE_BTN_TEXT_COLOR = "LONG";
    public static final String TYPE_ITEM_ID = "INTEGER";
    public static final String TYPE_PROFILE_CORSS_BAR_SEP_COLOR = "LONG";
    public static final String TYPE_PROFILE_CROSS_BAR_BG_COLOR = "LONG";
    public static final String TYPE_PROFILE_DESC_TEXT_COLOR = "LONG";
    public static final String TYPE_PROFILE_FEED_URL = "TEXT";
    public static final String TYPE_SEPARATOR_COLOR = "LONG";
    public static final String TYPE_UIN = "INTEGER UNIQUE";
    public static final String UIN = "uin";
    public static final int VERSION = 1;
    public long uin;
    public int itemId = -1;
    public String activeFeedNaviUrl = "";
    public String profileNaviUrl = "";
    public long separatorColor = 0;
    public long btnTextColor = 0;
    public long profileDescTextColor = 0;
    public long profileCrossBarBgColor = 0;
    public long profileCrossBarSeparatorColor = 0;
    public long btnMagicTextColor = 0;
    public long profileDescMagicTextColor = 0;
    public long arrowColor = 0;

    public static CustomNaviCacheData createFromJson(Long l3, JSONObject jSONObject) {
        CustomNaviCacheData customNaviCacheData = new CustomNaviCacheData();
        customNaviCacheData.uin = l3.longValue();
        customNaviCacheData.itemId = jSONObject.optInt("itemId", -1);
        customNaviCacheData.activeFeedNaviUrl = jSONObject.optString("activeFeedNaviUrl");
        customNaviCacheData.profileNaviUrl = jSONObject.optString(PROFILE_FEED_URL);
        long optLong = jSONObject.optLong(PROFILE_CROSS_BAR_BG_COLOR);
        customNaviCacheData.profileCrossBarBgColor = optLong;
        int[] c16 = c((int) optLong);
        customNaviCacheData.btnTextColor = c16[0];
        int i3 = c16[1];
        customNaviCacheData.profileDescTextColor = i3;
        customNaviCacheData.arrowColor = i3;
        int i16 = c16[2];
        customNaviCacheData.separatorColor = i16;
        customNaviCacheData.profileCrossBarSeparatorColor = i16;
        return customNaviCacheData;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.qzone.lib.wrapper.db.IDBCacheDataWrapper
    public void writeTo(ContentValues contentValues) {
        contentValues.put("uin", Long.valueOf(this.uin));
        contentValues.put("itemId", Integer.valueOf(this.itemId));
        contentValues.put(ACTIVE_FEED_URL, this.activeFeedNaviUrl);
        contentValues.put(PROFILE_FEED_URL, this.profileNaviUrl);
        contentValues.put(SEPARATOR_COLOR, Long.valueOf(this.separatorColor));
        contentValues.put(BTN_TEXT_COLOR, Long.valueOf(this.btnTextColor));
        contentValues.put(PROFILE_DESC_TEXT_COLOR, Long.valueOf(this.profileDescTextColor));
        contentValues.put(PROFILE_CROSS_BAR_BG_COLOR, Long.valueOf(this.profileCrossBarBgColor));
        contentValues.put(PROFILE_CORSS_BAR_SEP_COLOR, Long.valueOf(this.profileCrossBarSeparatorColor));
        contentValues.put(ARROW_COLOR, Long.valueOf(this.arrowColor));
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeLong(this.uin);
        parcel.writeInt(this.itemId);
        parcel.writeString(this.activeFeedNaviUrl);
        parcel.writeString(this.profileNaviUrl);
        parcel.writeLong(this.separatorColor);
        parcel.writeLong(this.btnTextColor);
        parcel.writeLong(this.profileDescTextColor);
        parcel.writeLong(this.profileCrossBarBgColor);
        parcel.writeLong(this.profileCrossBarSeparatorColor);
        parcel.writeLong(this.arrowColor);
    }

    private static int[] c(int i3) {
        float[] fArr = new float[3];
        float[] fArr2 = new float[3];
        float[] fArr3 = new float[3];
        float[] fArr4 = new float[3];
        int[] iArr = new int[3];
        Color.colorToHSV(i3, fArr);
        fArr2[0] = fArr[0];
        float f16 = fArr[1];
        float f17 = f16 + 0.2f;
        float f18 = f16 - 0.2f;
        if (f18 > 0.0d) {
            fArr2[1] = f18;
        } else {
            fArr2[1] = f17;
        }
        float f19 = fArr[2];
        float f26 = f19 + 0.5f;
        float f27 = f19 - 0.5f;
        if (f26 < 1.0d) {
            fArr2[2] = f26;
        } else {
            fArr2[2] = f27;
        }
        fArr3[0] = fArr[0];
        fArr3[1] = fArr[1];
        float f28 = fArr[2];
        float f29 = f28 + 0.3f;
        float f36 = f28 - 0.3f;
        if (f29 > 1.0d) {
            f29 = 1.0f;
        }
        if (f36 < 0.0d) {
            f36 = 0.0f;
        }
        if (1.0f - f29 > f36) {
            fArr3[2] = f29;
        } else {
            fArr3[2] = f36;
        }
        fArr4[0] = fArr[0];
        fArr4[1] = fArr[1];
        float f37 = fArr[2];
        float f38 = f37 + 0.2f;
        float f39 = f37 - 0.2f;
        if (f38 > 1.0d) {
            f38 = 1.0f;
        }
        float f46 = ((double) f39) >= 0.0d ? f39 : 0.0f;
        if (1.0f - f38 > f46) {
            fArr4[2] = f38;
        } else {
            fArr4[2] = f46;
        }
        iArr[0] = Color.HSVToColor(fArr2);
        iArr[1] = Color.HSVToColor(fArr3);
        iArr[2] = Color.HSVToColor(fArr4);
        return iArr;
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class a implements IDBCacheDataWrapper.b<CustomNaviCacheData> {
        a() {
        }

        @Override // com.qzone.lib.wrapper.db.IDBCacheDataWrapper.a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public CustomNaviCacheData createFromCursor(Cursor cursor) {
            CustomNaviCacheData customNaviCacheData = new CustomNaviCacheData();
            customNaviCacheData.uin = cursor.getLong(cursor.getColumnIndex("uin"));
            customNaviCacheData.itemId = cursor.getInt(cursor.getColumnIndex("itemId"));
            customNaviCacheData.activeFeedNaviUrl = cursor.getString(cursor.getColumnIndex(CustomNaviCacheData.ACTIVE_FEED_URL));
            customNaviCacheData.profileNaviUrl = cursor.getString(cursor.getColumnIndex(CustomNaviCacheData.PROFILE_FEED_URL));
            customNaviCacheData.separatorColor = cursor.getLong(cursor.getColumnIndex(CustomNaviCacheData.SEPARATOR_COLOR));
            customNaviCacheData.btnTextColor = cursor.getLong(cursor.getColumnIndex(CustomNaviCacheData.BTN_TEXT_COLOR));
            customNaviCacheData.profileDescTextColor = cursor.getLong(cursor.getColumnIndex(CustomNaviCacheData.PROFILE_DESC_TEXT_COLOR));
            customNaviCacheData.profileCrossBarBgColor = cursor.getLong(cursor.getColumnIndex(CustomNaviCacheData.PROFILE_CROSS_BAR_BG_COLOR));
            customNaviCacheData.profileCrossBarSeparatorColor = cursor.getLong(cursor.getColumnIndex(CustomNaviCacheData.PROFILE_CORSS_BAR_SEP_COLOR));
            customNaviCacheData.arrowColor = cursor.getLong(cursor.getColumnIndex(CustomNaviCacheData.ARROW_COLOR));
            return customNaviCacheData;
        }

        @Override // com.qzone.lib.wrapper.db.IDBCacheDataWrapper.b
        public String indexRawSql(String str) {
            return null;
        }

        @Override // com.qzone.lib.wrapper.db.IDBCacheDataWrapper.a
        public String sortOrder() {
            return null;
        }

        @Override // com.qzone.lib.wrapper.db.IDBCacheDataWrapper.a
        public IDBCacheDataWrapper.c[] structure() {
            return new IDBCacheDataWrapper.c[]{new IDBCacheDataWrapper.c("uin", "INTEGER UNIQUE"), new IDBCacheDataWrapper.c("itemId", "INTEGER"), new IDBCacheDataWrapper.c(CustomNaviCacheData.ACTIVE_FEED_URL, "TEXT"), new IDBCacheDataWrapper.c(CustomNaviCacheData.PROFILE_FEED_URL, "TEXT"), new IDBCacheDataWrapper.c(CustomNaviCacheData.SEPARATOR_COLOR, "LONG"), new IDBCacheDataWrapper.c(CustomNaviCacheData.BTN_TEXT_COLOR, "LONG"), new IDBCacheDataWrapper.c(CustomNaviCacheData.PROFILE_DESC_TEXT_COLOR, "LONG"), new IDBCacheDataWrapper.c(CustomNaviCacheData.PROFILE_CROSS_BAR_BG_COLOR, "LONG"), new IDBCacheDataWrapper.c(CustomNaviCacheData.PROFILE_CORSS_BAR_SEP_COLOR, "LONG"), new IDBCacheDataWrapper.c(CustomNaviCacheData.ARROW_COLOR, "LONG")};
        }

        @Override // com.qzone.lib.wrapper.db.IDBCacheDataWrapper.a
        public int version() {
            return 1;
        }

        @Override // com.qzone.lib.wrapper.db.IDBCacheDataWrapper.b
        public int delRawSql(SQLiteDatabase sQLiteDatabase, String str, String str2) {
            String[] split;
            if (sQLiteDatabase == null) {
                return 0;
            }
            if (!TextUtils.isEmpty(str2) && str2.contains(ContainerUtils.KEY_VALUE_DELIMITER) && !str2.contains(" and ") && !str2.contains(" AND ") && !str2.contains(" or ") && !str2.contains(" OR ") && (split = str2.split(ContainerUtils.KEY_VALUE_DELIMITER)) != null && split.length > 1 && !TextUtils.isEmpty(split[0]) && !TextUtils.isEmpty(split[1])) {
                String trim = split[0].trim();
                String replace = split[1].trim().replace("'", "");
                if (!TextUtils.isEmpty(trim) && !TextUtils.isEmpty(replace)) {
                    return sQLiteDatabase.delete(str, trim + "=? ", new String[]{replace});
                }
            }
            return sQLiteDatabase.delete(str, str2, null);
        }
    }

    public static CustomNaviCacheData toNaviCacheData(long j3, QzmallCustomNavi qzmallCustomNavi) {
        if (qzmallCustomNavi == null) {
            return null;
        }
        CustomNaviCacheData customNaviCacheData = new CustomNaviCacheData();
        customNaviCacheData.uin = j3;
        customNaviCacheData.itemId = qzmallCustomNavi.iItemId;
        customNaviCacheData.activeFeedNaviUrl = qzmallCustomNavi.strActiveFeedNaviUrl;
        customNaviCacheData.profileNaviUrl = qzmallCustomNavi.strProfileNaviUrl;
        long j16 = qzmallCustomNavi.lProfileCrossBarBgColor;
        customNaviCacheData.profileCrossBarBgColor = j16;
        int[] c16 = c((int) j16);
        customNaviCacheData.btnTextColor = c16[0];
        int i3 = c16[1];
        customNaviCacheData.profileDescTextColor = i3;
        customNaviCacheData.arrowColor = i3;
        int i16 = c16[2];
        customNaviCacheData.separatorColor = i16;
        customNaviCacheData.profileCrossBarSeparatorColor = i16;
        return customNaviCacheData;
    }
}
