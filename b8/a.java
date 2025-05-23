package b8;

import NS_MOBILE_EXTRA.s_profile_for_get;
import android.content.ContentValues;
import android.database.Cursor;
import com.qzone.lib.wrapper.db.IDBCacheDataWrapper;

/* compiled from: P */
/* loaded from: classes39.dex */
public class a extends com.qzone.component.cache.database.a {
    public static final String AGE = "AGE";
    public static final String BIRTHDAY = "birthday";
    public static final String BIRTHMONTH = "birthmonth";
    public static final String BIRTHYEAR = "birthyear";
    public static final String CITY = "city";
    public static final String CITYCODE = "cityCode";
    public static final String CONSTELLATION = "CONSTELLATION";
    public static final String COUNTRY = "country";
    public static final String COUNTRYCODE = "countryCode";
    public static final IDBCacheDataWrapper.a<a> DB_CREATOR = new C0108a();
    public static final String GENDER = "gender";
    public static final String ISBRANDQZONE = "ISBRANDQZONE";
    public static final String ISLUNAR = "islunar";
    public static final String LIMITSMASK = "LIMITSMASK";
    public static final String LOCAL_TIME = "LOCAL_TIME";
    public static final String NICKNAME = "nickname";
    public static final String PROVINCE = "province";
    public static final String PROVINCECODE = "provinceCode";
    public static final String QZONEDESC = "QZONEDESC";
    public static final String SERVER_TIME = "SERVER_TIME";
    public static final String TYPE_AGE = "INTEGER";
    public static final String TYPE_BIRTHDAY = "INTEGER";
    public static final String TYPE_BIRTHMONTH = "INTEGER";
    public static final String TYPE_BIRTHYEAR = "INTEGER";
    public static final String TYPE_CITY = "TEXT";
    public static final String TYPE_CITYCODE = "TEXT";
    public static final String TYPE_CONSTELLATION = "TEXT";
    public static final String TYPE_COUNTRY = "TEXT";
    public static final String TYPE_COUNTRYCODE = "TEXT";
    public static final String TYPE_GENDER = "INTEGER";
    public static final String TYPE_ISBRANDQZONE = "INTEGER";
    public static final String TYPE_ISLUNAR = "INTEGER";
    public static final String TYPE_LIMITSMASK = "LONG";
    public static final String TYPE_LOCAL_TIME = "LONG";
    public static final String TYPE_NICKNAME = "TEXT";
    public static final String TYPE_PROVINCE = "TEXT";
    public static final String TYPE_PROVINCECODE = "TEXT";
    public static final String TYPE_QZONEDESC = "TEXT";
    public static final String TYPE_SERVER_TIME = "LONG";
    public static final String TYPE_UIN = "TEXT";
    public static final String TYPE_VIP = "INTEGER";
    public static final String TYPE_VIPLEVEL = "INTEGER";
    public static final String TYPE_VIPTYPE = "INTEGER";
    public static final String UIN = "uin";

    /* renamed from: VIP, reason: collision with root package name */
    public static final String f28043VIP = "VIP";
    public static final String VIPLEVEL = "VIPLEVEL";
    public static final String VIPTYPE = "VIPTYPE";
    public int age;
    public int birthday;
    public int birthmonth;
    public int birthyear;
    public String constellation;
    public int isBrandQzone;
    public int islunar;
    public long limitsMask;
    public long localTimestamp;
    public String qzonedesc;
    public long serverTimestamp;
    public String uin;
    public int vip;
    public int viplevel;
    public int viptype;
    public String nickname = "";
    public int gender = -1;
    public String country = "";
    public String province = "";
    public String city = "";
    public String countryCode = "";
    public String provinceCode = "";
    public String cityCode = "";

    /* compiled from: P */
    /* renamed from: b8.a$a, reason: collision with other inner class name */
    /* loaded from: classes39.dex */
    class C0108a implements IDBCacheDataWrapper.a<a> {
        C0108a() {
        }

        @Override // com.qzone.lib.wrapper.db.IDBCacheDataWrapper.a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public a createFromCursor(Cursor cursor) {
            a aVar = new a();
            aVar.uin = cursor.getString(cursor.getColumnIndex("uin"));
            aVar.nickname = cursor.getString(cursor.getColumnIndex("nickname"));
            aVar.gender = cursor.getInt(cursor.getColumnIndex("gender"));
            aVar.islunar = cursor.getInt(cursor.getColumnIndex(a.ISLUNAR));
            aVar.birthyear = cursor.getInt(cursor.getColumnIndex(a.BIRTHYEAR));
            aVar.birthmonth = cursor.getInt(cursor.getColumnIndex(a.BIRTHMONTH));
            aVar.birthday = cursor.getInt(cursor.getColumnIndex("birthday"));
            aVar.country = cursor.getString(cursor.getColumnIndex("country"));
            aVar.province = cursor.getString(cursor.getColumnIndex("province"));
            aVar.city = cursor.getString(cursor.getColumnIndex("city"));
            aVar.countryCode = cursor.getString(cursor.getColumnIndex("countryCode"));
            aVar.provinceCode = cursor.getString(cursor.getColumnIndex(a.PROVINCECODE));
            aVar.cityCode = cursor.getString(cursor.getColumnIndex(a.CITYCODE));
            aVar.vip = cursor.getInt(cursor.getColumnIndex(a.f28043VIP));
            aVar.viplevel = cursor.getInt(cursor.getColumnIndex(a.VIPLEVEL));
            aVar.viptype = cursor.getInt(cursor.getColumnIndex(a.VIPTYPE));
            aVar.isBrandQzone = cursor.getInt(cursor.getColumnIndex(a.ISBRANDQZONE));
            aVar.limitsMask = cursor.getLong(cursor.getColumnIndex(a.LIMITSMASK));
            aVar.age = cursor.getInt(cursor.getColumnIndex(a.AGE));
            aVar.constellation = cursor.getString(cursor.getColumnIndex(a.CONSTELLATION));
            aVar.qzonedesc = cursor.getString(cursor.getColumnIndex(a.QZONEDESC));
            aVar.serverTimestamp = cursor.getLong(cursor.getColumnIndex(a.SERVER_TIME));
            aVar.localTimestamp = cursor.getLong(cursor.getColumnIndex(a.LOCAL_TIME));
            return aVar;
        }

        @Override // com.qzone.lib.wrapper.db.IDBCacheDataWrapper.a
        public String sortOrder() {
            return null;
        }

        @Override // com.qzone.lib.wrapper.db.IDBCacheDataWrapper.a
        public IDBCacheDataWrapper.c[] structure() {
            return new IDBCacheDataWrapper.c[]{new IDBCacheDataWrapper.c("uin", "TEXT"), new IDBCacheDataWrapper.c("nickname", "TEXT"), new IDBCacheDataWrapper.c("gender", "INTEGER"), new IDBCacheDataWrapper.c(a.ISLUNAR, "INTEGER"), new IDBCacheDataWrapper.c(a.BIRTHYEAR, "INTEGER"), new IDBCacheDataWrapper.c(a.BIRTHMONTH, "INTEGER"), new IDBCacheDataWrapper.c("birthday", "INTEGER"), new IDBCacheDataWrapper.c("country", "TEXT"), new IDBCacheDataWrapper.c("province", "TEXT"), new IDBCacheDataWrapper.c("city", "TEXT"), new IDBCacheDataWrapper.c("countryCode", "TEXT"), new IDBCacheDataWrapper.c(a.PROVINCECODE, "TEXT"), new IDBCacheDataWrapper.c(a.CITYCODE, "TEXT"), new IDBCacheDataWrapper.c(a.f28043VIP, "INTEGER"), new IDBCacheDataWrapper.c(a.VIPLEVEL, "INTEGER"), new IDBCacheDataWrapper.c(a.VIPTYPE, "INTEGER"), new IDBCacheDataWrapper.c(a.ISBRANDQZONE, "INTEGER"), new IDBCacheDataWrapper.c(a.LIMITSMASK, "LONG"), new IDBCacheDataWrapper.c(a.AGE, "INTEGER"), new IDBCacheDataWrapper.c(a.CONSTELLATION, "TEXT"), new IDBCacheDataWrapper.c(a.QZONEDESC, "TEXT"), new IDBCacheDataWrapper.c(a.SERVER_TIME, "LONG"), new IDBCacheDataWrapper.c(a.LOCAL_TIME, "LONG")};
        }

        @Override // com.qzone.lib.wrapper.db.IDBCacheDataWrapper.a
        public int version() {
            return 8;
        }
    }

    public static a createFromResponse(long j3, s_profile_for_get s_profile_for_getVar) {
        a aVar = new a();
        aVar.uin = Long.toString(j3);
        aVar.nickname = s_profile_for_getVar.nickname;
        aVar.gender = s_profile_for_getVar.gender;
        aVar.islunar = s_profile_for_getVar.islunar;
        aVar.birthyear = s_profile_for_getVar.birthyear;
        aVar.birthmonth = s_profile_for_getVar.birthmonth;
        aVar.birthday = s_profile_for_getVar.birthday;
        aVar.country = s_profile_for_getVar.country;
        aVar.province = s_profile_for_getVar.province;
        aVar.city = s_profile_for_getVar.city;
        aVar.vip = s_profile_for_getVar.vip;
        aVar.viplevel = s_profile_for_getVar.viplevel;
        aVar.viptype = s_profile_for_getVar.viptype;
        aVar.isBrandQzone = s_profile_for_getVar.isBrandQzone;
        aVar.limitsMask = s_profile_for_getVar.limitsMask;
        aVar.age = s_profile_for_getVar.age;
        aVar.constellation = s_profile_for_getVar.constellation;
        aVar.qzonedesc = s_profile_for_getVar.qzonedesc;
        aVar.serverTimestamp = s_profile_for_getVar.systime;
        aVar.localTimestamp = System.currentTimeMillis();
        return aVar;
    }

    @Override // com.qzone.lib.wrapper.db.IDBCacheDataWrapper
    public void writeTo(ContentValues contentValues) {
        contentValues.put("uin", this.uin);
        contentValues.put("nickname", this.nickname);
        contentValues.put("gender", Integer.valueOf(this.gender));
        contentValues.put(ISLUNAR, Integer.valueOf(this.islunar));
        contentValues.put(BIRTHYEAR, Integer.valueOf(this.birthyear));
        contentValues.put(BIRTHMONTH, Integer.valueOf(this.birthmonth));
        contentValues.put("birthday", Integer.valueOf(this.birthday));
        contentValues.put("country", this.country);
        contentValues.put("province", this.province);
        contentValues.put("city", this.city);
        contentValues.put("countryCode", this.countryCode);
        contentValues.put(PROVINCECODE, this.provinceCode);
        contentValues.put(CITYCODE, this.cityCode);
        contentValues.put(f28043VIP, Integer.valueOf(this.vip));
        contentValues.put(VIPLEVEL, Integer.valueOf(this.viplevel));
        contentValues.put(VIPTYPE, Integer.valueOf(this.viptype));
        contentValues.put(ISBRANDQZONE, Integer.valueOf(this.isBrandQzone));
        contentValues.put(LIMITSMASK, Long.valueOf(this.limitsMask));
        contentValues.put(AGE, Integer.valueOf(this.age));
        contentValues.put(CONSTELLATION, this.constellation);
        contentValues.put(QZONEDESC, this.qzonedesc);
        contentValues.put(SERVER_TIME, Long.valueOf(this.serverTimestamp));
        contentValues.put(LOCAL_TIME, Long.valueOf(this.localTimestamp));
    }
}
