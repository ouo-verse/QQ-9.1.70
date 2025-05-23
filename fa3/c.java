package fa3;

import android.database.Cursor;
import androidx.lifecycle.LiveData;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.room.util.StringUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.mini.servlet.MiniAppGetGameTaskTicketServlet;
import cooperation.qzone.api.impl.QZoneIntimateSpaceApiImpl;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;

/* compiled from: P */
/* loaded from: classes21.dex */
public final class c implements fa3.b {

    /* renamed from: a, reason: collision with root package name */
    private final RoomDatabase f398041a;

    /* renamed from: b, reason: collision with root package name */
    private final EntityInsertionAdapter<ha3.b> f398042b;

    /* renamed from: c, reason: collision with root package name */
    private final ea3.e f398043c = new ea3.e();

    /* renamed from: d, reason: collision with root package name */
    private final ea3.b f398044d = new ea3.b();

    /* renamed from: e, reason: collision with root package name */
    private final ea3.c f398045e = new ea3.c();

    /* renamed from: f, reason: collision with root package name */
    private final ea3.d f398046f = new ea3.d();

    /* renamed from: g, reason: collision with root package name */
    private final ea3.f f398047g = new ea3.f();

    /* renamed from: h, reason: collision with root package name */
    private final ea3.a f398048h = new ea3.a();

    /* renamed from: i, reason: collision with root package name */
    private final EntityDeletionOrUpdateAdapter<ha3.b> f398049i;

    /* renamed from: j, reason: collision with root package name */
    private final SharedSQLiteStatement f398050j;

    /* renamed from: k, reason: collision with root package name */
    private final SharedSQLiteStatement f398051k;

    /* renamed from: l, reason: collision with root package name */
    private final SharedSQLiteStatement f398052l;

    /* renamed from: m, reason: collision with root package name */
    private final SharedSQLiteStatement f398053m;

    /* renamed from: n, reason: collision with root package name */
    private final SharedSQLiteStatement f398054n;

    /* renamed from: o, reason: collision with root package name */
    private final SharedSQLiteStatement f398055o;

    /* renamed from: p, reason: collision with root package name */
    private final SharedSQLiteStatement f398056p;

    /* compiled from: P */
    /* loaded from: classes21.dex */
    class a implements Callable<List<ha3.b>> {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ RoomSQLiteQuery f398057d;

        a(RoomSQLiteQuery roomSQLiteQuery) {
            this.f398057d = roomSQLiteQuery;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public List<ha3.b> call() throws Exception {
            String string;
            String string2;
            String string3;
            boolean z16;
            int i3;
            boolean z17;
            int i16;
            int i17;
            int i18;
            String string4;
            int i19;
            int i26;
            String string5;
            String string6;
            Cursor query = DBUtil.query(c.this.f398041a, this.f398057d, false, null);
            try {
                int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "id");
                int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "uin");
                int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "draftKey");
                int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "content");
                int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "missionId");
                int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, "selectedMedia");
                int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(query, "selectedMediaInfo");
                int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(query, "poiInfo");
                int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(query, WadlProxyConsts.CREATE_TIME);
                int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(query, "hasSelectedCover");
                int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(query, "uploadStatus");
                int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(query, "toastStatus");
                int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(query, "clientKey");
                int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(query, "isSyncQQ");
                int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(query, "goodsId");
                int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(query, "goodsName");
                int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(query, "promotionParams");
                int columnIndexOrThrow18 = CursorUtil.getColumnIndexOrThrow(query, MiniAppGetGameTaskTicketServlet.KEY_TASKID);
                int columnIndexOrThrow19 = CursorUtil.getColumnIndexOrThrow(query, "clientTraceId");
                int columnIndexOrThrow20 = CursorUtil.getColumnIndexOrThrow(query, "extraInfo");
                int columnIndexOrThrow21 = CursorUtil.getColumnIndexOrThrow(query, "declarationParams");
                int i27 = columnIndexOrThrow13;
                ArrayList arrayList = new ArrayList(query.getCount());
                while (query.moveToNext()) {
                    ha3.b bVar = new ha3.b();
                    ArrayList arrayList2 = arrayList;
                    bVar.f404616a = query.getInt(columnIndexOrThrow);
                    int i28 = columnIndexOrThrow11;
                    int i29 = columnIndexOrThrow12;
                    bVar.f404617b = query.getLong(columnIndexOrThrow2);
                    if (query.isNull(columnIndexOrThrow3)) {
                        bVar.f404618c = null;
                    } else {
                        bVar.f404618c = query.getString(columnIndexOrThrow3);
                    }
                    if (query.isNull(columnIndexOrThrow4)) {
                        bVar.f404619d = null;
                    } else {
                        bVar.f404619d = query.getString(columnIndexOrThrow4);
                    }
                    if (query.isNull(columnIndexOrThrow5)) {
                        bVar.f404620e = null;
                    } else {
                        bVar.f404620e = query.getString(columnIndexOrThrow5);
                    }
                    if (query.isNull(columnIndexOrThrow6)) {
                        string = null;
                    } else {
                        string = query.getString(columnIndexOrThrow6);
                    }
                    bVar.f404621f = c.this.f398043c.b(string);
                    if (query.isNull(columnIndexOrThrow7)) {
                        string2 = null;
                    } else {
                        string2 = query.getString(columnIndexOrThrow7);
                    }
                    bVar.f404622g = c.this.f398044d.b(string2);
                    if (query.isNull(columnIndexOrThrow8)) {
                        string3 = null;
                    } else {
                        string3 = query.getString(columnIndexOrThrow8);
                    }
                    bVar.f404623h = c.this.f398045e.b(string3);
                    bVar.f404624i = query.getLong(columnIndexOrThrow9);
                    if (query.getInt(columnIndexOrThrow10) != 0) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    bVar.f404625j = z16;
                    bVar.f404626k = query.getInt(i28);
                    bVar.f404627l = query.getInt(i29);
                    int i36 = i27;
                    if (query.isNull(i36)) {
                        i3 = columnIndexOrThrow;
                        bVar.f404628m = null;
                    } else {
                        i3 = columnIndexOrThrow;
                        bVar.f404628m = query.getString(i36);
                    }
                    int i37 = columnIndexOrThrow14;
                    if (query.getInt(i37) != 0) {
                        columnIndexOrThrow14 = i37;
                        z17 = true;
                    } else {
                        columnIndexOrThrow14 = i37;
                        z17 = false;
                    }
                    bVar.f404629n = z17;
                    int i38 = columnIndexOrThrow15;
                    if (query.isNull(i38)) {
                        i16 = i28;
                        bVar.f404630o = null;
                    } else {
                        i16 = i28;
                        bVar.f404630o = query.getString(i38);
                    }
                    int i39 = columnIndexOrThrow16;
                    if (query.isNull(i39)) {
                        i17 = i38;
                        bVar.f404631p = null;
                    } else {
                        i17 = i38;
                        bVar.f404631p = query.getString(i39);
                    }
                    int i46 = columnIndexOrThrow17;
                    if (query.isNull(i46)) {
                        i18 = i46;
                        i19 = i39;
                        string4 = null;
                    } else {
                        i18 = i46;
                        string4 = query.getString(i46);
                        i19 = i39;
                    }
                    bVar.f404632q = c.this.f398046f.b(string4);
                    int i47 = columnIndexOrThrow18;
                    int i48 = columnIndexOrThrow2;
                    bVar.f404633r = query.getLong(i47);
                    int i49 = columnIndexOrThrow19;
                    if (query.isNull(i49)) {
                        bVar.f404634s = null;
                    } else {
                        bVar.f404634s = query.getString(i49);
                    }
                    int i56 = columnIndexOrThrow20;
                    if (query.isNull(i56)) {
                        i26 = i47;
                        columnIndexOrThrow19 = i49;
                        string5 = null;
                    } else {
                        i26 = i47;
                        string5 = query.getString(i56);
                        columnIndexOrThrow19 = i49;
                    }
                    bVar.f404635t = c.this.f398047g.b(string5);
                    int i57 = columnIndexOrThrow21;
                    if (query.isNull(i57)) {
                        columnIndexOrThrow21 = i57;
                        string6 = null;
                    } else {
                        string6 = query.getString(i57);
                        columnIndexOrThrow21 = i57;
                    }
                    bVar.f404636u = c.this.f398048h.b(string6);
                    arrayList2.add(bVar);
                    arrayList = arrayList2;
                    columnIndexOrThrow = i3;
                    i27 = i36;
                    columnIndexOrThrow12 = i29;
                    columnIndexOrThrow11 = i16;
                    columnIndexOrThrow15 = i17;
                    columnIndexOrThrow16 = i19;
                    columnIndexOrThrow17 = i18;
                    int i58 = i26;
                    columnIndexOrThrow20 = i56;
                    columnIndexOrThrow2 = i48;
                    columnIndexOrThrow18 = i58;
                }
                return arrayList;
            } finally {
                query.close();
            }
        }

        protected void finalize() {
            this.f398057d.release();
        }
    }

    /* compiled from: P */
    /* loaded from: classes21.dex */
    class b implements Callable<List<ha3.b>> {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ RoomSQLiteQuery f398059d;

        b(RoomSQLiteQuery roomSQLiteQuery) {
            this.f398059d = roomSQLiteQuery;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public List<ha3.b> call() throws Exception {
            String string;
            String string2;
            String string3;
            boolean z16;
            int i3;
            boolean z17;
            int i16;
            int i17;
            int i18;
            String string4;
            int i19;
            int i26;
            String string5;
            String string6;
            Cursor query = DBUtil.query(c.this.f398041a, this.f398059d, false, null);
            try {
                int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "id");
                int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "uin");
                int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "draftKey");
                int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "content");
                int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "missionId");
                int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, "selectedMedia");
                int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(query, "selectedMediaInfo");
                int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(query, "poiInfo");
                int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(query, WadlProxyConsts.CREATE_TIME);
                int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(query, "hasSelectedCover");
                int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(query, "uploadStatus");
                int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(query, "toastStatus");
                int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(query, "clientKey");
                int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(query, "isSyncQQ");
                int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(query, "goodsId");
                int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(query, "goodsName");
                int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(query, "promotionParams");
                int columnIndexOrThrow18 = CursorUtil.getColumnIndexOrThrow(query, MiniAppGetGameTaskTicketServlet.KEY_TASKID);
                int columnIndexOrThrow19 = CursorUtil.getColumnIndexOrThrow(query, "clientTraceId");
                int columnIndexOrThrow20 = CursorUtil.getColumnIndexOrThrow(query, "extraInfo");
                int columnIndexOrThrow21 = CursorUtil.getColumnIndexOrThrow(query, "declarationParams");
                int i27 = columnIndexOrThrow13;
                ArrayList arrayList = new ArrayList(query.getCount());
                while (query.moveToNext()) {
                    ha3.b bVar = new ha3.b();
                    ArrayList arrayList2 = arrayList;
                    bVar.f404616a = query.getInt(columnIndexOrThrow);
                    int i28 = columnIndexOrThrow11;
                    int i29 = columnIndexOrThrow12;
                    bVar.f404617b = query.getLong(columnIndexOrThrow2);
                    if (query.isNull(columnIndexOrThrow3)) {
                        bVar.f404618c = null;
                    } else {
                        bVar.f404618c = query.getString(columnIndexOrThrow3);
                    }
                    if (query.isNull(columnIndexOrThrow4)) {
                        bVar.f404619d = null;
                    } else {
                        bVar.f404619d = query.getString(columnIndexOrThrow4);
                    }
                    if (query.isNull(columnIndexOrThrow5)) {
                        bVar.f404620e = null;
                    } else {
                        bVar.f404620e = query.getString(columnIndexOrThrow5);
                    }
                    if (query.isNull(columnIndexOrThrow6)) {
                        string = null;
                    } else {
                        string = query.getString(columnIndexOrThrow6);
                    }
                    bVar.f404621f = c.this.f398043c.b(string);
                    if (query.isNull(columnIndexOrThrow7)) {
                        string2 = null;
                    } else {
                        string2 = query.getString(columnIndexOrThrow7);
                    }
                    bVar.f404622g = c.this.f398044d.b(string2);
                    if (query.isNull(columnIndexOrThrow8)) {
                        string3 = null;
                    } else {
                        string3 = query.getString(columnIndexOrThrow8);
                    }
                    bVar.f404623h = c.this.f398045e.b(string3);
                    bVar.f404624i = query.getLong(columnIndexOrThrow9);
                    if (query.getInt(columnIndexOrThrow10) != 0) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    bVar.f404625j = z16;
                    bVar.f404626k = query.getInt(i28);
                    bVar.f404627l = query.getInt(i29);
                    int i36 = i27;
                    if (query.isNull(i36)) {
                        i3 = columnIndexOrThrow;
                        bVar.f404628m = null;
                    } else {
                        i3 = columnIndexOrThrow;
                        bVar.f404628m = query.getString(i36);
                    }
                    int i37 = columnIndexOrThrow14;
                    if (query.getInt(i37) != 0) {
                        columnIndexOrThrow14 = i37;
                        z17 = true;
                    } else {
                        columnIndexOrThrow14 = i37;
                        z17 = false;
                    }
                    bVar.f404629n = z17;
                    int i38 = columnIndexOrThrow15;
                    if (query.isNull(i38)) {
                        i16 = i28;
                        bVar.f404630o = null;
                    } else {
                        i16 = i28;
                        bVar.f404630o = query.getString(i38);
                    }
                    int i39 = columnIndexOrThrow16;
                    if (query.isNull(i39)) {
                        i17 = i38;
                        bVar.f404631p = null;
                    } else {
                        i17 = i38;
                        bVar.f404631p = query.getString(i39);
                    }
                    int i46 = columnIndexOrThrow17;
                    if (query.isNull(i46)) {
                        i18 = i46;
                        i19 = i39;
                        string4 = null;
                    } else {
                        i18 = i46;
                        string4 = query.getString(i46);
                        i19 = i39;
                    }
                    bVar.f404632q = c.this.f398046f.b(string4);
                    int i47 = columnIndexOrThrow18;
                    int i48 = columnIndexOrThrow2;
                    bVar.f404633r = query.getLong(i47);
                    int i49 = columnIndexOrThrow19;
                    if (query.isNull(i49)) {
                        bVar.f404634s = null;
                    } else {
                        bVar.f404634s = query.getString(i49);
                    }
                    int i56 = columnIndexOrThrow20;
                    if (query.isNull(i56)) {
                        i26 = i47;
                        columnIndexOrThrow19 = i49;
                        string5 = null;
                    } else {
                        i26 = i47;
                        string5 = query.getString(i56);
                        columnIndexOrThrow19 = i49;
                    }
                    bVar.f404635t = c.this.f398047g.b(string5);
                    int i57 = columnIndexOrThrow21;
                    if (query.isNull(i57)) {
                        columnIndexOrThrow21 = i57;
                        string6 = null;
                    } else {
                        string6 = query.getString(i57);
                        columnIndexOrThrow21 = i57;
                    }
                    bVar.f404636u = c.this.f398048h.b(string6);
                    arrayList2.add(bVar);
                    arrayList = arrayList2;
                    columnIndexOrThrow = i3;
                    i27 = i36;
                    columnIndexOrThrow12 = i29;
                    columnIndexOrThrow11 = i16;
                    columnIndexOrThrow15 = i17;
                    columnIndexOrThrow16 = i19;
                    columnIndexOrThrow17 = i18;
                    int i58 = i26;
                    columnIndexOrThrow20 = i56;
                    columnIndexOrThrow2 = i48;
                    columnIndexOrThrow18 = i58;
                }
                return arrayList;
            } finally {
                query.close();
            }
        }

        protected void finalize() {
            this.f398059d.release();
        }
    }

    /* compiled from: P */
    /* renamed from: fa3.c$c, reason: collision with other inner class name */
    /* loaded from: classes21.dex */
    class C10296c extends EntityInsertionAdapter<ha3.b> {
        C10296c(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.EntityInsertionAdapter
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void bind(SupportSQLiteStatement supportSQLiteStatement, ha3.b bVar) {
            supportSQLiteStatement.bindLong(1, bVar.f404616a);
            supportSQLiteStatement.bindLong(2, bVar.f404617b);
            String str = bVar.f404618c;
            if (str == null) {
                supportSQLiteStatement.bindNull(3);
            } else {
                supportSQLiteStatement.bindString(3, str);
            }
            String str2 = bVar.f404619d;
            if (str2 == null) {
                supportSQLiteStatement.bindNull(4);
            } else {
                supportSQLiteStatement.bindString(4, str2);
            }
            String str3 = bVar.f404620e;
            if (str3 == null) {
                supportSQLiteStatement.bindNull(5);
            } else {
                supportSQLiteStatement.bindString(5, str3);
            }
            String a16 = c.this.f398043c.a(bVar.f404621f);
            if (a16 == null) {
                supportSQLiteStatement.bindNull(6);
            } else {
                supportSQLiteStatement.bindString(6, a16);
            }
            String a17 = c.this.f398044d.a(bVar.f404622g);
            if (a17 == null) {
                supportSQLiteStatement.bindNull(7);
            } else {
                supportSQLiteStatement.bindString(7, a17);
            }
            String a18 = c.this.f398045e.a(bVar.f404623h);
            if (a18 == null) {
                supportSQLiteStatement.bindNull(8);
            } else {
                supportSQLiteStatement.bindString(8, a18);
            }
            supportSQLiteStatement.bindLong(9, bVar.f404624i);
            supportSQLiteStatement.bindLong(10, bVar.f404625j ? 1L : 0L);
            supportSQLiteStatement.bindLong(11, bVar.f404626k);
            supportSQLiteStatement.bindLong(12, bVar.f404627l);
            String str4 = bVar.f404628m;
            if (str4 == null) {
                supportSQLiteStatement.bindNull(13);
            } else {
                supportSQLiteStatement.bindString(13, str4);
            }
            supportSQLiteStatement.bindLong(14, bVar.f404629n ? 1L : 0L);
            String str5 = bVar.f404630o;
            if (str5 == null) {
                supportSQLiteStatement.bindNull(15);
            } else {
                supportSQLiteStatement.bindString(15, str5);
            }
            String str6 = bVar.f404631p;
            if (str6 == null) {
                supportSQLiteStatement.bindNull(16);
            } else {
                supportSQLiteStatement.bindString(16, str6);
            }
            String a19 = c.this.f398046f.a(bVar.f404632q);
            if (a19 == null) {
                supportSQLiteStatement.bindNull(17);
            } else {
                supportSQLiteStatement.bindString(17, a19);
            }
            supportSQLiteStatement.bindLong(18, bVar.f404633r);
            String str7 = bVar.f404634s;
            if (str7 == null) {
                supportSQLiteStatement.bindNull(19);
            } else {
                supportSQLiteStatement.bindString(19, str7);
            }
            String a26 = c.this.f398047g.a(bVar.f404635t);
            if (a26 == null) {
                supportSQLiteStatement.bindNull(20);
            } else {
                supportSQLiteStatement.bindString(20, a26);
            }
            String a27 = c.this.f398048h.a(bVar.f404636u);
            if (a27 == null) {
                supportSQLiteStatement.bindNull(21);
            } else {
                supportSQLiteStatement.bindString(21, a27);
            }
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "INSERT OR REPLACE INTO `wink_publish_content_table` (`id`,`uin`,`draftKey`,`content`,`missionId`,`selectedMedia`,`selectedMediaInfo`,`poiInfo`,`createTime`,`hasSelectedCover`,`uploadStatus`,`toastStatus`,`clientKey`,`isSyncQQ`,`goodsId`,`goodsName`,`promotionParams`,`taskId`,`clientTraceId`,`extraInfo`,`declarationParams`) VALUES (nullif(?, 0),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        }
    }

    /* compiled from: P */
    /* loaded from: classes21.dex */
    class d extends EntityDeletionOrUpdateAdapter<ha3.b> {
        d(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.EntityDeletionOrUpdateAdapter
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void bind(SupportSQLiteStatement supportSQLiteStatement, ha3.b bVar) {
            supportSQLiteStatement.bindLong(1, bVar.f404616a);
            supportSQLiteStatement.bindLong(2, bVar.f404617b);
            String str = bVar.f404618c;
            if (str == null) {
                supportSQLiteStatement.bindNull(3);
            } else {
                supportSQLiteStatement.bindString(3, str);
            }
            String str2 = bVar.f404619d;
            if (str2 == null) {
                supportSQLiteStatement.bindNull(4);
            } else {
                supportSQLiteStatement.bindString(4, str2);
            }
            String str3 = bVar.f404620e;
            if (str3 == null) {
                supportSQLiteStatement.bindNull(5);
            } else {
                supportSQLiteStatement.bindString(5, str3);
            }
            String a16 = c.this.f398043c.a(bVar.f404621f);
            if (a16 == null) {
                supportSQLiteStatement.bindNull(6);
            } else {
                supportSQLiteStatement.bindString(6, a16);
            }
            String a17 = c.this.f398044d.a(bVar.f404622g);
            if (a17 == null) {
                supportSQLiteStatement.bindNull(7);
            } else {
                supportSQLiteStatement.bindString(7, a17);
            }
            String a18 = c.this.f398045e.a(bVar.f404623h);
            if (a18 == null) {
                supportSQLiteStatement.bindNull(8);
            } else {
                supportSQLiteStatement.bindString(8, a18);
            }
            supportSQLiteStatement.bindLong(9, bVar.f404624i);
            supportSQLiteStatement.bindLong(10, bVar.f404625j ? 1L : 0L);
            supportSQLiteStatement.bindLong(11, bVar.f404626k);
            supportSQLiteStatement.bindLong(12, bVar.f404627l);
            String str4 = bVar.f404628m;
            if (str4 == null) {
                supportSQLiteStatement.bindNull(13);
            } else {
                supportSQLiteStatement.bindString(13, str4);
            }
            supportSQLiteStatement.bindLong(14, bVar.f404629n ? 1L : 0L);
            String str5 = bVar.f404630o;
            if (str5 == null) {
                supportSQLiteStatement.bindNull(15);
            } else {
                supportSQLiteStatement.bindString(15, str5);
            }
            String str6 = bVar.f404631p;
            if (str6 == null) {
                supportSQLiteStatement.bindNull(16);
            } else {
                supportSQLiteStatement.bindString(16, str6);
            }
            String a19 = c.this.f398046f.a(bVar.f404632q);
            if (a19 == null) {
                supportSQLiteStatement.bindNull(17);
            } else {
                supportSQLiteStatement.bindString(17, a19);
            }
            supportSQLiteStatement.bindLong(18, bVar.f404633r);
            String str7 = bVar.f404634s;
            if (str7 == null) {
                supportSQLiteStatement.bindNull(19);
            } else {
                supportSQLiteStatement.bindString(19, str7);
            }
            String a26 = c.this.f398047g.a(bVar.f404635t);
            if (a26 == null) {
                supportSQLiteStatement.bindNull(20);
            } else {
                supportSQLiteStatement.bindString(20, a26);
            }
            String a27 = c.this.f398048h.a(bVar.f404636u);
            if (a27 == null) {
                supportSQLiteStatement.bindNull(21);
            } else {
                supportSQLiteStatement.bindString(21, a27);
            }
            supportSQLiteStatement.bindLong(22, bVar.f404616a);
        }

        @Override // androidx.room.EntityDeletionOrUpdateAdapter, androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "UPDATE OR ABORT `wink_publish_content_table` SET `id` = ?,`uin` = ?,`draftKey` = ?,`content` = ?,`missionId` = ?,`selectedMedia` = ?,`selectedMediaInfo` = ?,`poiInfo` = ?,`createTime` = ?,`hasSelectedCover` = ?,`uploadStatus` = ?,`toastStatus` = ?,`clientKey` = ?,`isSyncQQ` = ?,`goodsId` = ?,`goodsName` = ?,`promotionParams` = ?,`taskId` = ?,`clientTraceId` = ?,`extraInfo` = ?,`declarationParams` = ? WHERE `id` = ?";
        }
    }

    /* compiled from: P */
    /* loaded from: classes21.dex */
    class e extends SharedSQLiteStatement {
        e(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "DELETE FROM wink_publish_content_table WHERE uin = ? AND missionId = ?";
        }
    }

    /* compiled from: P */
    /* loaded from: classes21.dex */
    class f extends SharedSQLiteStatement {
        f(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "DELETE FROM wink_publish_content_table WHERE uin = ? AND uploadStatus = ?";
        }
    }

    /* compiled from: P */
    /* loaded from: classes21.dex */
    class g extends SharedSQLiteStatement {
        g(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "DELETE FROM wink_publish_content_table WHERE uin = ? AND toastStatus = ?";
        }
    }

    /* compiled from: P */
    /* loaded from: classes21.dex */
    class h extends SharedSQLiteStatement {
        h(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "DELETE FROM wink_publish_content_table";
        }
    }

    /* compiled from: P */
    /* loaded from: classes21.dex */
    class i extends SharedSQLiteStatement {
        i(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "DELETE FROM wink_publish_content_table WHERE uin = ?";
        }
    }

    /* compiled from: P */
    /* loaded from: classes21.dex */
    class j extends SharedSQLiteStatement {
        j(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "UPDATE wink_publish_content_table SET toastStatus = ? WHERE uin = ? AND missionId = ?";
        }
    }

    /* compiled from: P */
    /* loaded from: classes21.dex */
    class k extends SharedSQLiteStatement {
        k(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "UPDATE wink_publish_content_table SET uploadStatus = ? WHERE uin = ? AND missionId = ?";
        }
    }

    public c(RoomDatabase roomDatabase) {
        this.f398041a = roomDatabase;
        this.f398042b = new C10296c(roomDatabase);
        this.f398049i = new d(roomDatabase);
        this.f398050j = new e(roomDatabase);
        this.f398051k = new f(roomDatabase);
        this.f398052l = new g(roomDatabase);
        this.f398053m = new h(roomDatabase);
        this.f398054n = new i(roomDatabase);
        this.f398055o = new j(roomDatabase);
        this.f398056p = new k(roomDatabase);
    }

    public static List<Class<?>> o() {
        return Collections.emptyList();
    }

    @Override // fa3.b
    public ha3.b a(long j3) {
        RoomSQLiteQuery roomSQLiteQuery;
        ha3.b bVar;
        String string;
        String string2;
        String string3;
        boolean z16;
        boolean z17;
        String string4;
        String str;
        String string5;
        String string6;
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT a.* FROM wink_publish_content_table a INNER JOIN (SELECT uin, max(createTime) date FROM wink_publish_content_table WHERE uin=?) b ON a.createTime = b.date AND a.uin = b.uin", 1);
        acquire.bindLong(1, j3);
        this.f398041a.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.f398041a, acquire, false, null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "id");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "uin");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "draftKey");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "content");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "missionId");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, "selectedMedia");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(query, "selectedMediaInfo");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(query, "poiInfo");
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(query, WadlProxyConsts.CREATE_TIME);
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(query, "hasSelectedCover");
            int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(query, "uploadStatus");
            int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(query, "toastStatus");
            int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(query, "clientKey");
            roomSQLiteQuery = acquire;
            try {
                int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(query, "isSyncQQ");
                int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(query, "goodsId");
                int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(query, "goodsName");
                int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(query, "promotionParams");
                int columnIndexOrThrow18 = CursorUtil.getColumnIndexOrThrow(query, MiniAppGetGameTaskTicketServlet.KEY_TASKID);
                int columnIndexOrThrow19 = CursorUtil.getColumnIndexOrThrow(query, "clientTraceId");
                int columnIndexOrThrow20 = CursorUtil.getColumnIndexOrThrow(query, "extraInfo");
                int columnIndexOrThrow21 = CursorUtil.getColumnIndexOrThrow(query, "declarationParams");
                if (query.moveToFirst()) {
                    ha3.b bVar2 = new ha3.b();
                    bVar2.f404616a = query.getInt(columnIndexOrThrow);
                    bVar2.f404617b = query.getLong(columnIndexOrThrow2);
                    if (query.isNull(columnIndexOrThrow3)) {
                        bVar2.f404618c = null;
                    } else {
                        bVar2.f404618c = query.getString(columnIndexOrThrow3);
                    }
                    if (query.isNull(columnIndexOrThrow4)) {
                        bVar2.f404619d = null;
                    } else {
                        bVar2.f404619d = query.getString(columnIndexOrThrow4);
                    }
                    if (query.isNull(columnIndexOrThrow5)) {
                        bVar2.f404620e = null;
                    } else {
                        bVar2.f404620e = query.getString(columnIndexOrThrow5);
                    }
                    if (query.isNull(columnIndexOrThrow6)) {
                        string = null;
                    } else {
                        string = query.getString(columnIndexOrThrow6);
                    }
                    bVar2.f404621f = this.f398043c.b(string);
                    if (query.isNull(columnIndexOrThrow7)) {
                        string2 = null;
                    } else {
                        string2 = query.getString(columnIndexOrThrow7);
                    }
                    bVar2.f404622g = this.f398044d.b(string2);
                    if (query.isNull(columnIndexOrThrow8)) {
                        string3 = null;
                    } else {
                        string3 = query.getString(columnIndexOrThrow8);
                    }
                    bVar2.f404623h = this.f398045e.b(string3);
                    bVar2.f404624i = query.getLong(columnIndexOrThrow9);
                    if (query.getInt(columnIndexOrThrow10) != 0) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    bVar2.f404625j = z16;
                    bVar2.f404626k = query.getInt(columnIndexOrThrow11);
                    bVar2.f404627l = query.getInt(columnIndexOrThrow12);
                    if (query.isNull(columnIndexOrThrow13)) {
                        bVar2.f404628m = null;
                    } else {
                        bVar2.f404628m = query.getString(columnIndexOrThrow13);
                    }
                    if (query.getInt(columnIndexOrThrow14) != 0) {
                        z17 = true;
                    } else {
                        z17 = false;
                    }
                    bVar2.f404629n = z17;
                    if (query.isNull(columnIndexOrThrow15)) {
                        bVar2.f404630o = null;
                    } else {
                        bVar2.f404630o = query.getString(columnIndexOrThrow15);
                    }
                    if (query.isNull(columnIndexOrThrow16)) {
                        bVar2.f404631p = null;
                    } else {
                        bVar2.f404631p = query.getString(columnIndexOrThrow16);
                    }
                    if (query.isNull(columnIndexOrThrow17)) {
                        string4 = null;
                    } else {
                        string4 = query.getString(columnIndexOrThrow17);
                    }
                    bVar2.f404632q = this.f398046f.b(string4);
                    bVar2.f404633r = query.getLong(columnIndexOrThrow18);
                    if (query.isNull(columnIndexOrThrow19)) {
                        str = null;
                        bVar2.f404634s = null;
                    } else {
                        str = null;
                        bVar2.f404634s = query.getString(columnIndexOrThrow19);
                    }
                    if (query.isNull(columnIndexOrThrow20)) {
                        string5 = str;
                    } else {
                        string5 = query.getString(columnIndexOrThrow20);
                    }
                    bVar2.f404635t = this.f398047g.b(string5);
                    if (query.isNull(columnIndexOrThrow21)) {
                        string6 = str;
                    } else {
                        string6 = query.getString(columnIndexOrThrow21);
                    }
                    bVar2.f404636u = this.f398048h.b(string6);
                    bVar = bVar2;
                } else {
                    bVar = null;
                }
                query.close();
                roomSQLiteQuery.release();
                return bVar;
            } catch (Throwable th5) {
                th = th5;
                query.close();
                roomSQLiteQuery.release();
                throw th;
            }
        } catch (Throwable th6) {
            th = th6;
            roomSQLiteQuery = acquire;
        }
    }

    @Override // fa3.b
    public void b(ha3.b bVar) {
        this.f398041a.assertNotSuspendingTransaction();
        this.f398041a.beginTransaction();
        try {
            this.f398042b.insert((EntityInsertionAdapter<ha3.b>) bVar);
            this.f398041a.setTransactionSuccessful();
        } finally {
            this.f398041a.endTransaction();
        }
    }

    @Override // fa3.b
    public LiveData<List<ha3.b>> c(long j3) {
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM wink_publish_content_table WHERE uin = ? ORDER BY createTime DESC", 1);
        acquire.bindLong(1, j3);
        return this.f398041a.getInvalidationTracker().createLiveData(new String[]{"wink_publish_content_table"}, false, new a(acquire));
    }

    @Override // fa3.b
    public List<String> d(long j3) {
        String string;
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT missionId FROM wink_publish_content_table WHERE uin = ? ORDER BY createTime DESC", 1);
        acquire.bindLong(1, j3);
        this.f398041a.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.f398041a, acquire, false, null);
        try {
            ArrayList arrayList = new ArrayList(query.getCount());
            while (query.moveToNext()) {
                if (query.isNull(0)) {
                    string = null;
                } else {
                    string = query.getString(0);
                }
                arrayList.add(string);
            }
            return arrayList;
        } finally {
            query.close();
            acquire.release();
        }
    }

    @Override // fa3.b
    public void delete(long j3, List<String> list) {
        this.f398041a.assertNotSuspendingTransaction();
        StringBuilder newStringBuilder = StringUtil.newStringBuilder();
        newStringBuilder.append("DELETE FROM wink_publish_content_table WHERE uin = ");
        newStringBuilder.append(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER);
        newStringBuilder.append(" AND missionId IN (");
        StringUtil.appendPlaceholders(newStringBuilder, list.size());
        newStringBuilder.append(")");
        SupportSQLiteStatement compileStatement = this.f398041a.compileStatement(newStringBuilder.toString());
        compileStatement.bindLong(1, j3);
        int i3 = 2;
        for (String str : list) {
            if (str == null) {
                compileStatement.bindNull(i3);
            } else {
                compileStatement.bindString(i3, str);
            }
            i3++;
        }
        this.f398041a.beginTransaction();
        try {
            compileStatement.executeUpdateDelete();
            this.f398041a.setTransactionSuccessful();
        } finally {
            this.f398041a.endTransaction();
        }
    }

    @Override // fa3.b
    public void deleteAll() {
        this.f398041a.assertNotSuspendingTransaction();
        SupportSQLiteStatement acquire = this.f398053m.acquire();
        this.f398041a.beginTransaction();
        try {
            acquire.executeUpdateDelete();
            this.f398041a.setTransactionSuccessful();
        } finally {
            this.f398041a.endTransaction();
            this.f398053m.release(acquire);
        }
    }

    @Override // fa3.b
    public void deleteByMissionId(long j3, String str) {
        this.f398041a.assertNotSuspendingTransaction();
        SupportSQLiteStatement acquire = this.f398050j.acquire();
        acquire.bindLong(1, j3);
        if (str == null) {
            acquire.bindNull(2);
        } else {
            acquire.bindString(2, str);
        }
        this.f398041a.beginTransaction();
        try {
            acquire.executeUpdateDelete();
            this.f398041a.setTransactionSuccessful();
        } finally {
            this.f398041a.endTransaction();
            this.f398050j.release(acquire);
        }
    }

    @Override // fa3.b
    public void e(long j3, String[] strArr) {
        this.f398041a.assertNotSuspendingTransaction();
        StringBuilder newStringBuilder = StringUtil.newStringBuilder();
        newStringBuilder.append("DELETE FROM wink_publish_content_table WHERE uin = ");
        newStringBuilder.append(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER);
        newStringBuilder.append(" AND missionId IN (");
        StringUtil.appendPlaceholders(newStringBuilder, strArr.length);
        newStringBuilder.append(")");
        SupportSQLiteStatement compileStatement = this.f398041a.compileStatement(newStringBuilder.toString());
        compileStatement.bindLong(1, j3);
        int i3 = 2;
        for (String str : strArr) {
            if (str == null) {
                compileStatement.bindNull(i3);
            } else {
                compileStatement.bindString(i3, str);
            }
            i3++;
        }
        this.f398041a.beginTransaction();
        try {
            compileStatement.executeUpdateDelete();
            this.f398041a.setTransactionSuccessful();
        } finally {
            this.f398041a.endTransaction();
        }
    }

    @Override // fa3.b
    public List<ha3.b> f(long j3, String str) {
        RoomSQLiteQuery roomSQLiteQuery;
        String string;
        String string2;
        String string3;
        boolean z16;
        int i3;
        boolean z17;
        int i16;
        String string4;
        int i17;
        String string5;
        String string6;
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM wink_publish_content_table WHERE uin = ? AND missionId = ?", 2);
        acquire.bindLong(1, j3);
        if (str == null) {
            acquire.bindNull(2);
        } else {
            acquire.bindString(2, str);
        }
        this.f398041a.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.f398041a, acquire, false, null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "id");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "uin");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "draftKey");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "content");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "missionId");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, "selectedMedia");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(query, "selectedMediaInfo");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(query, "poiInfo");
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(query, WadlProxyConsts.CREATE_TIME);
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(query, "hasSelectedCover");
            int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(query, "uploadStatus");
            int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(query, "toastStatus");
            int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(query, "clientKey");
            roomSQLiteQuery = acquire;
            try {
                int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(query, "isSyncQQ");
                int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(query, "goodsId");
                int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(query, "goodsName");
                int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(query, "promotionParams");
                int columnIndexOrThrow18 = CursorUtil.getColumnIndexOrThrow(query, MiniAppGetGameTaskTicketServlet.KEY_TASKID);
                int columnIndexOrThrow19 = CursorUtil.getColumnIndexOrThrow(query, "clientTraceId");
                int columnIndexOrThrow20 = CursorUtil.getColumnIndexOrThrow(query, "extraInfo");
                int columnIndexOrThrow21 = CursorUtil.getColumnIndexOrThrow(query, "declarationParams");
                int i18 = columnIndexOrThrow13;
                ArrayList arrayList = new ArrayList(query.getCount());
                while (query.moveToNext()) {
                    ha3.b bVar = new ha3.b();
                    ArrayList arrayList2 = arrayList;
                    bVar.f404616a = query.getInt(columnIndexOrThrow);
                    int i19 = columnIndexOrThrow11;
                    bVar.f404617b = query.getLong(columnIndexOrThrow2);
                    if (query.isNull(columnIndexOrThrow3)) {
                        bVar.f404618c = null;
                    } else {
                        bVar.f404618c = query.getString(columnIndexOrThrow3);
                    }
                    if (query.isNull(columnIndexOrThrow4)) {
                        bVar.f404619d = null;
                    } else {
                        bVar.f404619d = query.getString(columnIndexOrThrow4);
                    }
                    if (query.isNull(columnIndexOrThrow5)) {
                        bVar.f404620e = null;
                    } else {
                        bVar.f404620e = query.getString(columnIndexOrThrow5);
                    }
                    if (query.isNull(columnIndexOrThrow6)) {
                        string = null;
                    } else {
                        string = query.getString(columnIndexOrThrow6);
                    }
                    bVar.f404621f = this.f398043c.b(string);
                    if (query.isNull(columnIndexOrThrow7)) {
                        string2 = null;
                    } else {
                        string2 = query.getString(columnIndexOrThrow7);
                    }
                    bVar.f404622g = this.f398044d.b(string2);
                    if (query.isNull(columnIndexOrThrow8)) {
                        string3 = null;
                    } else {
                        string3 = query.getString(columnIndexOrThrow8);
                    }
                    bVar.f404623h = this.f398045e.b(string3);
                    bVar.f404624i = query.getLong(columnIndexOrThrow9);
                    if (query.getInt(columnIndexOrThrow10) != 0) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    bVar.f404625j = z16;
                    bVar.f404626k = query.getInt(i19);
                    bVar.f404627l = query.getInt(columnIndexOrThrow12);
                    int i26 = i18;
                    if (query.isNull(i26)) {
                        i3 = columnIndexOrThrow;
                        bVar.f404628m = null;
                    } else {
                        i3 = columnIndexOrThrow;
                        bVar.f404628m = query.getString(i26);
                    }
                    int i27 = columnIndexOrThrow14;
                    columnIndexOrThrow14 = i27;
                    if (query.getInt(i27) != 0) {
                        z17 = true;
                    } else {
                        z17 = false;
                    }
                    bVar.f404629n = z17;
                    int i28 = columnIndexOrThrow15;
                    if (query.isNull(i28)) {
                        i16 = i19;
                        bVar.f404630o = null;
                    } else {
                        i16 = i19;
                        bVar.f404630o = query.getString(i28);
                    }
                    int i29 = columnIndexOrThrow16;
                    if (query.isNull(i29)) {
                        columnIndexOrThrow15 = i28;
                        bVar.f404631p = null;
                    } else {
                        columnIndexOrThrow15 = i28;
                        bVar.f404631p = query.getString(i29);
                    }
                    int i36 = columnIndexOrThrow17;
                    if (query.isNull(i36)) {
                        columnIndexOrThrow17 = i36;
                        columnIndexOrThrow16 = i29;
                        string4 = null;
                    } else {
                        columnIndexOrThrow17 = i36;
                        string4 = query.getString(i36);
                        columnIndexOrThrow16 = i29;
                    }
                    bVar.f404632q = this.f398046f.b(string4);
                    int i37 = columnIndexOrThrow18;
                    bVar.f404633r = query.getLong(i37);
                    int i38 = columnIndexOrThrow19;
                    if (query.isNull(i38)) {
                        bVar.f404634s = null;
                    } else {
                        bVar.f404634s = query.getString(i38);
                    }
                    int i39 = columnIndexOrThrow20;
                    if (query.isNull(i39)) {
                        i17 = i37;
                        columnIndexOrThrow19 = i38;
                        string5 = null;
                    } else {
                        i17 = i37;
                        string5 = query.getString(i39);
                        columnIndexOrThrow19 = i38;
                    }
                    bVar.f404635t = this.f398047g.b(string5);
                    int i46 = columnIndexOrThrow21;
                    if (query.isNull(i46)) {
                        columnIndexOrThrow21 = i46;
                        string6 = null;
                    } else {
                        string6 = query.getString(i46);
                        columnIndexOrThrow21 = i46;
                    }
                    bVar.f404636u = this.f398048h.b(string6);
                    arrayList2.add(bVar);
                    arrayList = arrayList2;
                    columnIndexOrThrow = i3;
                    i18 = i26;
                    columnIndexOrThrow18 = i17;
                    columnIndexOrThrow20 = i39;
                    columnIndexOrThrow11 = i16;
                }
                ArrayList arrayList3 = arrayList;
                query.close();
                roomSQLiteQuery.release();
                return arrayList3;
            } catch (Throwable th5) {
                th = th5;
                query.close();
                roomSQLiteQuery.release();
                throw th;
            }
        } catch (Throwable th6) {
            th = th6;
            roomSQLiteQuery = acquire;
        }
    }

    @Override // fa3.b
    public LiveData<List<ha3.b>> g(long j3, String str) {
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM wink_publish_content_table WHERE uin = ? AND missionId = ?", 2);
        acquire.bindLong(1, j3);
        if (str == null) {
            acquire.bindNull(2);
        } else {
            acquire.bindString(2, str);
        }
        return this.f398041a.getInvalidationTracker().createLiveData(new String[]{"wink_publish_content_table"}, false, new b(acquire));
    }

    @Override // fa3.b
    public List<ha3.b> getAllDataSync() {
        RoomSQLiteQuery roomSQLiteQuery;
        int columnIndexOrThrow;
        int columnIndexOrThrow2;
        int columnIndexOrThrow3;
        int columnIndexOrThrow4;
        int columnIndexOrThrow5;
        int columnIndexOrThrow6;
        int columnIndexOrThrow7;
        int columnIndexOrThrow8;
        int columnIndexOrThrow9;
        int columnIndexOrThrow10;
        int columnIndexOrThrow11;
        int columnIndexOrThrow12;
        int columnIndexOrThrow13;
        String string;
        String string2;
        String string3;
        boolean z16;
        int i3;
        boolean z17;
        int i16;
        String string4;
        int i17;
        String string5;
        String string6;
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM wink_publish_content_table ORDER BY createTime DESC", 0);
        this.f398041a.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.f398041a, acquire, false, null);
        try {
            columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "id");
            columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "uin");
            columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "draftKey");
            columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "content");
            columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "missionId");
            columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, "selectedMedia");
            columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(query, "selectedMediaInfo");
            columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(query, "poiInfo");
            columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(query, WadlProxyConsts.CREATE_TIME);
            columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(query, "hasSelectedCover");
            columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(query, "uploadStatus");
            columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(query, "toastStatus");
            columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(query, "clientKey");
            roomSQLiteQuery = acquire;
        } catch (Throwable th5) {
            th = th5;
            roomSQLiteQuery = acquire;
        }
        try {
            int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(query, "isSyncQQ");
            int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(query, "goodsId");
            int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(query, "goodsName");
            int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(query, "promotionParams");
            int columnIndexOrThrow18 = CursorUtil.getColumnIndexOrThrow(query, MiniAppGetGameTaskTicketServlet.KEY_TASKID);
            int columnIndexOrThrow19 = CursorUtil.getColumnIndexOrThrow(query, "clientTraceId");
            int columnIndexOrThrow20 = CursorUtil.getColumnIndexOrThrow(query, "extraInfo");
            int columnIndexOrThrow21 = CursorUtil.getColumnIndexOrThrow(query, "declarationParams");
            int i18 = columnIndexOrThrow13;
            ArrayList arrayList = new ArrayList(query.getCount());
            while (query.moveToNext()) {
                ha3.b bVar = new ha3.b();
                ArrayList arrayList2 = arrayList;
                bVar.f404616a = query.getInt(columnIndexOrThrow);
                int i19 = columnIndexOrThrow12;
                bVar.f404617b = query.getLong(columnIndexOrThrow2);
                if (query.isNull(columnIndexOrThrow3)) {
                    bVar.f404618c = null;
                } else {
                    bVar.f404618c = query.getString(columnIndexOrThrow3);
                }
                if (query.isNull(columnIndexOrThrow4)) {
                    bVar.f404619d = null;
                } else {
                    bVar.f404619d = query.getString(columnIndexOrThrow4);
                }
                if (query.isNull(columnIndexOrThrow5)) {
                    bVar.f404620e = null;
                } else {
                    bVar.f404620e = query.getString(columnIndexOrThrow5);
                }
                if (query.isNull(columnIndexOrThrow6)) {
                    string = null;
                } else {
                    string = query.getString(columnIndexOrThrow6);
                }
                bVar.f404621f = this.f398043c.b(string);
                if (query.isNull(columnIndexOrThrow7)) {
                    string2 = null;
                } else {
                    string2 = query.getString(columnIndexOrThrow7);
                }
                bVar.f404622g = this.f398044d.b(string2);
                if (query.isNull(columnIndexOrThrow8)) {
                    string3 = null;
                } else {
                    string3 = query.getString(columnIndexOrThrow8);
                }
                bVar.f404623h = this.f398045e.b(string3);
                bVar.f404624i = query.getLong(columnIndexOrThrow9);
                if (query.getInt(columnIndexOrThrow10) != 0) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                bVar.f404625j = z16;
                bVar.f404626k = query.getInt(columnIndexOrThrow11);
                bVar.f404627l = query.getInt(i19);
                int i26 = i18;
                if (query.isNull(i26)) {
                    i3 = columnIndexOrThrow;
                    bVar.f404628m = null;
                } else {
                    i3 = columnIndexOrThrow;
                    bVar.f404628m = query.getString(i26);
                }
                int i27 = columnIndexOrThrow14;
                if (query.getInt(i27) != 0) {
                    columnIndexOrThrow14 = i27;
                    z17 = true;
                } else {
                    columnIndexOrThrow14 = i27;
                    z17 = false;
                }
                bVar.f404629n = z17;
                int i28 = columnIndexOrThrow15;
                if (query.isNull(i28)) {
                    i16 = i19;
                    bVar.f404630o = null;
                } else {
                    i16 = i19;
                    bVar.f404630o = query.getString(i28);
                }
                int i29 = columnIndexOrThrow16;
                if (query.isNull(i29)) {
                    columnIndexOrThrow15 = i28;
                    bVar.f404631p = null;
                } else {
                    columnIndexOrThrow15 = i28;
                    bVar.f404631p = query.getString(i29);
                }
                int i36 = columnIndexOrThrow17;
                if (query.isNull(i36)) {
                    columnIndexOrThrow17 = i36;
                    columnIndexOrThrow16 = i29;
                    string4 = null;
                } else {
                    columnIndexOrThrow17 = i36;
                    string4 = query.getString(i36);
                    columnIndexOrThrow16 = i29;
                }
                bVar.f404632q = this.f398046f.b(string4);
                int i37 = columnIndexOrThrow18;
                bVar.f404633r = query.getLong(i37);
                int i38 = columnIndexOrThrow19;
                if (query.isNull(i38)) {
                    bVar.f404634s = null;
                } else {
                    bVar.f404634s = query.getString(i38);
                }
                int i39 = columnIndexOrThrow20;
                if (query.isNull(i39)) {
                    i17 = i37;
                    columnIndexOrThrow19 = i38;
                    string5 = null;
                } else {
                    i17 = i37;
                    string5 = query.getString(i39);
                    columnIndexOrThrow19 = i38;
                }
                bVar.f404635t = this.f398047g.b(string5);
                int i46 = columnIndexOrThrow21;
                if (query.isNull(i46)) {
                    columnIndexOrThrow21 = i46;
                    string6 = null;
                } else {
                    string6 = query.getString(i46);
                    columnIndexOrThrow21 = i46;
                }
                bVar.f404636u = this.f398048h.b(string6);
                arrayList2.add(bVar);
                columnIndexOrThrow12 = i16;
                arrayList = arrayList2;
                columnIndexOrThrow = i3;
                i18 = i26;
                columnIndexOrThrow18 = i17;
                columnIndexOrThrow20 = i39;
            }
            ArrayList arrayList3 = arrayList;
            query.close();
            roomSQLiteQuery.release();
            return arrayList3;
        } catch (Throwable th6) {
            th = th6;
            query.close();
            roomSQLiteQuery.release();
            throw th;
        }
    }

    @Override // fa3.b
    public List<ha3.b> getDataByUploadStatusSync(long j3, int[] iArr) {
        RoomSQLiteQuery roomSQLiteQuery;
        int columnIndexOrThrow;
        int columnIndexOrThrow2;
        int columnIndexOrThrow3;
        int columnIndexOrThrow4;
        int columnIndexOrThrow5;
        int columnIndexOrThrow6;
        int columnIndexOrThrow7;
        int columnIndexOrThrow8;
        int columnIndexOrThrow9;
        int columnIndexOrThrow10;
        int columnIndexOrThrow11;
        int columnIndexOrThrow12;
        int columnIndexOrThrow13;
        String string;
        String string2;
        String string3;
        boolean z16;
        int i3;
        boolean z17;
        int i16;
        int i17;
        int i18;
        String string4;
        int i19;
        int i26;
        String string5;
        int i27;
        String string6;
        StringBuilder newStringBuilder = StringUtil.newStringBuilder();
        newStringBuilder.append("SELECT * FROM wink_publish_content_table WHERE uin = ");
        newStringBuilder.append(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER);
        newStringBuilder.append(" AND uploadStatus IN (");
        int length = iArr.length;
        StringUtil.appendPlaceholders(newStringBuilder, length);
        newStringBuilder.append(")");
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire(newStringBuilder.toString(), length + 1);
        acquire.bindLong(1, j3);
        int i28 = 2;
        for (int i29 : iArr) {
            acquire.bindLong(i28, i29);
            i28++;
        }
        this.f398041a.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.f398041a, acquire, false, null);
        try {
            columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "id");
            columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "uin");
            columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "draftKey");
            columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "content");
            columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "missionId");
            columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, "selectedMedia");
            columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(query, "selectedMediaInfo");
            columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(query, "poiInfo");
            columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(query, WadlProxyConsts.CREATE_TIME);
            columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(query, "hasSelectedCover");
            columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(query, "uploadStatus");
            columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(query, "toastStatus");
            columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(query, "clientKey");
            roomSQLiteQuery = acquire;
        } catch (Throwable th5) {
            th = th5;
            roomSQLiteQuery = acquire;
        }
        try {
            int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(query, "isSyncQQ");
            int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(query, "goodsId");
            int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(query, "goodsName");
            int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(query, "promotionParams");
            int columnIndexOrThrow18 = CursorUtil.getColumnIndexOrThrow(query, MiniAppGetGameTaskTicketServlet.KEY_TASKID);
            int columnIndexOrThrow19 = CursorUtil.getColumnIndexOrThrow(query, "clientTraceId");
            int columnIndexOrThrow20 = CursorUtil.getColumnIndexOrThrow(query, "extraInfo");
            int columnIndexOrThrow21 = CursorUtil.getColumnIndexOrThrow(query, "declarationParams");
            int i36 = columnIndexOrThrow13;
            ArrayList arrayList = new ArrayList(query.getCount());
            while (query.moveToNext()) {
                ha3.b bVar = new ha3.b();
                ArrayList arrayList2 = arrayList;
                bVar.f404616a = query.getInt(columnIndexOrThrow);
                int i37 = columnIndexOrThrow9;
                int i38 = columnIndexOrThrow10;
                bVar.f404617b = query.getLong(columnIndexOrThrow2);
                if (query.isNull(columnIndexOrThrow3)) {
                    bVar.f404618c = null;
                } else {
                    bVar.f404618c = query.getString(columnIndexOrThrow3);
                }
                if (query.isNull(columnIndexOrThrow4)) {
                    bVar.f404619d = null;
                } else {
                    bVar.f404619d = query.getString(columnIndexOrThrow4);
                }
                if (query.isNull(columnIndexOrThrow5)) {
                    bVar.f404620e = null;
                } else {
                    bVar.f404620e = query.getString(columnIndexOrThrow5);
                }
                if (query.isNull(columnIndexOrThrow6)) {
                    string = null;
                } else {
                    string = query.getString(columnIndexOrThrow6);
                }
                bVar.f404621f = this.f398043c.b(string);
                if (query.isNull(columnIndexOrThrow7)) {
                    string2 = null;
                } else {
                    string2 = query.getString(columnIndexOrThrow7);
                }
                bVar.f404622g = this.f398044d.b(string2);
                if (query.isNull(columnIndexOrThrow8)) {
                    string3 = null;
                } else {
                    string3 = query.getString(columnIndexOrThrow8);
                }
                bVar.f404623h = this.f398045e.b(string3);
                bVar.f404624i = query.getLong(i37);
                if (query.getInt(i38) != 0) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                bVar.f404625j = z16;
                bVar.f404626k = query.getInt(columnIndexOrThrow11);
                bVar.f404627l = query.getInt(columnIndexOrThrow12);
                int i39 = i36;
                if (query.isNull(i39)) {
                    i3 = columnIndexOrThrow;
                    bVar.f404628m = null;
                } else {
                    i3 = columnIndexOrThrow;
                    bVar.f404628m = query.getString(i39);
                }
                int i46 = columnIndexOrThrow14;
                columnIndexOrThrow14 = i46;
                if (query.getInt(i46) != 0) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                bVar.f404629n = z17;
                int i47 = columnIndexOrThrow15;
                if (query.isNull(i47)) {
                    i16 = i37;
                    bVar.f404630o = null;
                } else {
                    i16 = i37;
                    bVar.f404630o = query.getString(i47);
                }
                int i48 = columnIndexOrThrow16;
                if (query.isNull(i48)) {
                    i17 = i47;
                    bVar.f404631p = null;
                } else {
                    i17 = i47;
                    bVar.f404631p = query.getString(i48);
                }
                int i49 = columnIndexOrThrow17;
                if (query.isNull(i49)) {
                    i18 = i49;
                    i19 = i48;
                    string4 = null;
                } else {
                    i18 = i49;
                    string4 = query.getString(i49);
                    i19 = i48;
                }
                bVar.f404632q = this.f398046f.b(string4);
                int i56 = columnIndexOrThrow2;
                int i57 = columnIndexOrThrow18;
                int i58 = columnIndexOrThrow12;
                bVar.f404633r = query.getLong(i57);
                int i59 = columnIndexOrThrow19;
                if (query.isNull(i59)) {
                    bVar.f404634s = null;
                } else {
                    bVar.f404634s = query.getString(i59);
                }
                int i65 = columnIndexOrThrow20;
                if (query.isNull(i65)) {
                    i26 = i57;
                    i27 = i56;
                    string5 = null;
                } else {
                    i26 = i57;
                    string5 = query.getString(i65);
                    i27 = i56;
                }
                bVar.f404635t = this.f398047g.b(string5);
                int i66 = columnIndexOrThrow21;
                if (query.isNull(i66)) {
                    columnIndexOrThrow21 = i66;
                    string6 = null;
                } else {
                    string6 = query.getString(i66);
                    columnIndexOrThrow21 = i66;
                }
                bVar.f404636u = this.f398048h.b(string6);
                arrayList2.add(bVar);
                arrayList = arrayList2;
                columnIndexOrThrow = i3;
                i36 = i39;
                columnIndexOrThrow10 = i38;
                columnIndexOrThrow9 = i16;
                columnIndexOrThrow15 = i17;
                columnIndexOrThrow16 = i19;
                columnIndexOrThrow17 = i18;
                int i67 = i27;
                columnIndexOrThrow19 = i59;
                columnIndexOrThrow12 = i58;
                columnIndexOrThrow18 = i26;
                columnIndexOrThrow20 = i65;
                columnIndexOrThrow2 = i67;
            }
            ArrayList arrayList3 = arrayList;
            query.close();
            roomSQLiteQuery.release();
            return arrayList3;
        } catch (Throwable th6) {
            th = th6;
            query.close();
            roomSQLiteQuery.release();
            throw th;
        }
    }

    @Override // fa3.b
    public void updateToastStatus(long j3, String str, int i3) {
        this.f398041a.assertNotSuspendingTransaction();
        SupportSQLiteStatement acquire = this.f398055o.acquire();
        acquire.bindLong(1, i3);
        acquire.bindLong(2, j3);
        if (str == null) {
            acquire.bindNull(3);
        } else {
            acquire.bindString(3, str);
        }
        this.f398041a.beginTransaction();
        try {
            acquire.executeUpdateDelete();
            this.f398041a.setTransactionSuccessful();
        } finally {
            this.f398041a.endTransaction();
            this.f398055o.release(acquire);
        }
    }

    @Override // fa3.b
    public void updateUploadStatus(long j3, String str, int i3) {
        this.f398041a.assertNotSuspendingTransaction();
        SupportSQLiteStatement acquire = this.f398056p.acquire();
        acquire.bindLong(1, i3);
        acquire.bindLong(2, j3);
        if (str == null) {
            acquire.bindNull(3);
        } else {
            acquire.bindString(3, str);
        }
        this.f398041a.beginTransaction();
        try {
            acquire.executeUpdateDelete();
            this.f398041a.setTransactionSuccessful();
        } finally {
            this.f398041a.endTransaction();
            this.f398056p.release(acquire);
        }
    }

    @Override // fa3.b
    public void deleteAll(long j3) {
        this.f398041a.assertNotSuspendingTransaction();
        SupportSQLiteStatement acquire = this.f398054n.acquire();
        acquire.bindLong(1, j3);
        this.f398041a.beginTransaction();
        try {
            acquire.executeUpdateDelete();
            this.f398041a.setTransactionSuccessful();
        } finally {
            this.f398041a.endTransaction();
            this.f398054n.release(acquire);
        }
    }
}
