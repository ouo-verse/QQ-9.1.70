package com.tencent.bugly.proguard;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.bugly.BuglyStrategy;
import com.tencent.bugly.common.constants.Constants;
import com.tencent.bugly.crashreport.common.info.PlugInBean;
import com.tencent.bugly.crashreport.common.strategy.StrategyBean;
import com.tencent.bugly.crashreport.crash.CrashDetailBean;
import com.tencent.bugly.crashreport.crash.jni.NativeCrashHandler;
import com.tencent.bugly.proguard.ao;
import com.tencent.bugly.proguard.az;
import com.tencent.intervideo.nowproxy.NowProxyConstants;
import com.tencent.mobileqq.vas.theme.ThemeReporter;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.regex.Pattern;

/* compiled from: P */
/* loaded from: classes5.dex */
public final class bd {

    /* renamed from: a, reason: collision with root package name */
    public static int f98194a;

    /* renamed from: b, reason: collision with root package name */
    protected final Context f98200b;

    /* renamed from: c, reason: collision with root package name */
    protected final aq f98201c;

    /* renamed from: d, reason: collision with root package name */
    protected final ae f98202d;

    /* renamed from: e, reason: collision with root package name */
    protected final ak f98203e;

    /* renamed from: f, reason: collision with root package name */
    protected bm f98204f;

    /* renamed from: g, reason: collision with root package name */
    protected BuglyStrategy.a f98205g;

    /* renamed from: i, reason: collision with root package name */
    private static final Map<Integer, Pair<String, String>> f98196i = new HashMap<Integer, Pair<String, String>>() { // from class: com.tencent.bugly.proguard.bd.1
        {
            put(3, new Pair(ThemeReporter.FROM_WEEKLOOP, "103"));
            put(7, new Pair(ThemeReporter.FROM_UPDATE, "108"));
            put(0, new Pair("200", "100"));
            put(1, new Pair(ThemeReporter.FROM_DIY, "101"));
            put(2, new Pair(ThemeReporter.FROM_NIGHT, "102"));
            put(4, new Pair(ThemeReporter.FROM_AUTH, "104"));
            put(6, new Pair(ThemeReporter.FROM_INIT_THEME, "106"));
            put(5, new Pair(ThemeReporter.FROM_SERVER_SET_THEME, "107"));
        }
    };

    /* renamed from: j, reason: collision with root package name */
    private static final ArrayList<a> f98197j = new ArrayList<a>() { // from class: com.tencent.bugly.proguard.bd.2
        {
            byte b16 = 0;
            add(new b(b16));
            add(new c(b16));
            add(new d(b16));
            add(new e(b16));
            add(new h(b16));
            add(new i(b16));
            add(new f(b16));
            add(new g(b16));
        }
    };

    /* renamed from: k, reason: collision with root package name */
    private static final Map<Integer, Integer> f98198k = new HashMap<Integer, Integer>() { // from class: com.tencent.bugly.proguard.bd.3
        {
            put(3, 4);
            put(7, 7);
            put(2, 1);
            put(0, 0);
            put(1, 2);
            put(4, 3);
            put(5, 5);
            put(6, 6);
        }
    };

    /* renamed from: l, reason: collision with root package name */
    private static final Map<Integer, String> f98199l = new HashMap<Integer, String>() { // from class: com.tencent.bugly.proguard.bd.4
        {
            put(3, "BuglyAnrCrash");
            put(0, "BuglyJavaCrash");
            put(1, "BuglyNativeCrash");
        }
    };

    /* renamed from: h, reason: collision with root package name */
    public static final Map<Integer, String> f98195h = new HashMap<Integer, String>() { // from class: com.tencent.bugly.proguard.bd.5
        {
            put(3, "BuglyAnrCrashReport");
            put(0, "BuglyJavaCrashReport");
            put(1, "BuglyNativeCrashReport");
        }
    };

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public static abstract class a {

        /* renamed from: a, reason: collision with root package name */
        private final int f98206a;

        /* synthetic */ a(int i3, byte b16) {
            this(i3);
        }

        abstract boolean a();

        final boolean a(CrashDetailBean crashDetailBean) {
            if (this.f98206a == crashDetailBean.f97876b) {
                return true;
            }
            return false;
        }

        a(int i3) {
            this.f98206a = i3;
        }
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    static class b extends a {
        /* synthetic */ b(byte b16) {
            this();
        }

        @Override // com.tencent.bugly.proguard.bd.a
        final boolean a() {
            return be.a().n();
        }

        b() {
            super(3, (byte) 0);
        }
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    static class c extends a {
        /* synthetic */ c(byte b16) {
            this();
        }

        @Override // com.tencent.bugly.proguard.bd.a
        final boolean a() {
            return true;
        }

        c() {
            super(7, (byte) 0);
        }
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    static class d extends a {
        /* synthetic */ d(byte b16) {
            this();
        }

        @Override // com.tencent.bugly.proguard.bd.a
        final boolean a() {
            return true;
        }

        d() {
            super(2, (byte) 0);
        }
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    static class e extends a {
        /* synthetic */ e(byte b16) {
            this();
        }

        @Override // com.tencent.bugly.proguard.bd.a
        final boolean a() {
            return be.a().m();
        }

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        e() {
            super(r0, r0);
            byte b16 = 0;
        }
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    static class f extends a {
        /* synthetic */ f(byte b16) {
            this();
        }

        @Override // com.tencent.bugly.proguard.bd.a
        final boolean a() {
            if ((be.a().C & 2) > 0) {
                return true;
            }
            return false;
        }

        f() {
            super(5, (byte) 0);
        }
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    static class g extends a {
        /* synthetic */ g(byte b16) {
            this();
        }

        @Override // com.tencent.bugly.proguard.bd.a
        final boolean a() {
            if ((be.a().C & 1) > 0) {
                return true;
            }
            return false;
        }

        g() {
            super(6, (byte) 0);
        }
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    static class h extends a {
        /* synthetic */ h(byte b16) {
            this();
        }

        @Override // com.tencent.bugly.proguard.bd.a
        final boolean a() {
            return be.a().m();
        }

        h() {
            super(1, (byte) 0);
        }
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    static class i extends a {
        /* synthetic */ i(byte b16) {
            this();
        }

        @Override // com.tencent.bugly.proguard.bd.a
        final boolean a() {
            if ((be.a().C & 4) > 0) {
                return true;
            }
            return false;
        }

        i() {
            super(4, (byte) 0);
        }
    }

    public bd(int i3, Context context, aq aqVar, ae aeVar, ak akVar, BuglyStrategy.a aVar, bm bmVar) {
        f98194a = i3;
        this.f98200b = context;
        this.f98201c = aqVar;
        this.f98202d = aeVar;
        this.f98203e = akVar;
        this.f98205g = aVar;
        this.f98204f = bmVar;
    }

    private static CrashDetailBean a(List<bc> list, CrashDetailBean crashDetailBean) {
        CrashDetailBean crashDetailBean2;
        List<CrashDetailBean> a16;
        if (list.isEmpty()) {
            return crashDetailBean;
        }
        ArrayList arrayList = new ArrayList(10);
        for (bc bcVar : list) {
            if (bcVar.f98192e) {
                arrayList.add(bcVar);
            }
        }
        if (arrayList.isEmpty() || (a16 = a(arrayList)) == null || a16.isEmpty()) {
            crashDetailBean2 = null;
        } else {
            Collections.sort(a16);
            crashDetailBean2 = a16.get(0);
            a(crashDetailBean2, a16);
        }
        if (crashDetailBean2 == null) {
            crashDetailBean.f97892r = true;
            crashDetailBean.B = 0;
            crashDetailBean.A = "";
            crashDetailBean2 = crashDetailBean;
        }
        b(crashDetailBean2, list);
        if (crashDetailBean2.f97900z != crashDetailBean.f97900z) {
            String str = crashDetailBean2.A;
            StringBuilder sb5 = new StringBuilder();
            sb5.append(crashDetailBean.f97900z);
            if (!str.contains(sb5.toString())) {
                crashDetailBean2.B++;
                crashDetailBean2.A += crashDetailBean.f97900z + "\n";
            }
        }
        return crashDetailBean2;
    }

    private static void b(CrashDetailBean crashDetailBean, List<bc> list) {
        StringBuilder sb5 = new StringBuilder(64);
        for (bc bcVar : list) {
            if (!bcVar.f98192e && !bcVar.f98191d) {
                String str = crashDetailBean.A;
                StringBuilder sb6 = new StringBuilder();
                sb6.append(bcVar.f98189b);
                if (!str.contains(sb6.toString())) {
                    crashDetailBean.B++;
                    sb5.append(bcVar.f98189b);
                    sb5.append("\n");
                }
            }
        }
        crashDetailBean.A += sb5.toString();
    }

    private static List<bc> c(List<bc> list) {
        if (list == null || list.size() == 0) {
            return null;
        }
        long currentTimeMillis = System.currentTimeMillis();
        ArrayList arrayList = new ArrayList();
        for (bc bcVar : list) {
            if (bcVar.f98191d && bcVar.f98189b <= currentTimeMillis - 86400000) {
                arrayList.add(bcVar);
            }
        }
        return arrayList;
    }

    private static void d(CrashDetailBean crashDetailBean) {
        String str = f98199l.get(Integer.valueOf(crashDetailBean.f97876b));
        if (TextUtils.isEmpty(str)) {
            return;
        }
        ao.a.a().a(new ao.c(crashDetailBean.f97877c, str, crashDetailBean.f97900z, true, 0L, "realtime", null));
    }

    private static void e(CrashDetailBean crashDetailBean) {
        if (crashDetailBean.f97876b != 2) {
            ag agVar = new ag();
            agVar.f97979b = 1;
            agVar.f97980c = crashDetailBean.I;
            agVar.f97981d = crashDetailBean.J;
            agVar.f97982e = crashDetailBean.f97900z;
            ae.a().b(1);
            ae.a().a(agVar);
            av.b("[crash] a crash occur, handling...", new Object[0]);
            return;
        }
        av.b("[crash] a caught exception occur, handling...", new Object[0]);
    }

    private static bc f(CrashDetailBean crashDetailBean) {
        try {
            bc bcVar = new bc();
            bcVar.f98188a = crashDetailBean.f97859a;
            bcVar.f98189b = crashDetailBean.f97900z;
            bcVar.f98190c = crashDetailBean.C;
            bcVar.f98191d = crashDetailBean.f97880f;
            bcVar.f98192e = crashDetailBean.f97892r;
            bcVar.f98193f = crashDetailBean.f97894t;
            return bcVar;
        } catch (Throwable th5) {
            if (av.a(th5)) {
                return null;
            }
            th5.printStackTrace();
            return null;
        }
    }

    private void g(CrashDetailBean crashDetailBean) {
        boolean z16;
        if (crashDetailBean == null) {
            return;
        }
        if (this.f98205g == null && this.f98204f == null) {
            return;
        }
        if (!j(crashDetailBean)) {
            av.c("Should not call back.", new Object[0]);
            return;
        }
        try {
            Map<Integer, Integer> map = f98198k;
            if (!map.containsKey(Integer.valueOf(crashDetailBean.f97876b))) {
                av.d("Cannot get crash type for crashBean type:" + crashDetailBean.f97876b, new Object[0]);
                return;
            }
            map.get(Integer.valueOf(crashDetailBean.f97876b)).intValue();
            if (crashDetailBean.f97876b == 1) {
                z16 = true;
            } else {
                z16 = false;
            }
            a(crashDetailBean, c(crashDetailBean, z16));
            av.a("[crash callback] start user's callback:onCrashHandleStart2GetExtraDatas()", new Object[0]);
            a(crashDetailBean, d(crashDetailBean, z16));
            e(crashDetailBean, z16);
            crashDetailBean.f97864ae = ai.c().A();
            crashDetailBean.f97865af = ai.c().F;
            crashDetailBean.f97866ag = ai.c().u();
            crashDetailBean.f97867ah = ai.c().z();
        } catch (Throwable th5) {
            av.d("crash handle callback something wrong! %s", th5.getClass().getName());
            if (!av.a(th5)) {
                th5.printStackTrace();
            }
        }
    }

    private static ContentValues h(CrashDetailBean crashDetailBean) {
        int i3;
        if (crashDetailBean == null) {
            return null;
        }
        try {
            ContentValues contentValues = new ContentValues();
            long j3 = crashDetailBean.f97859a;
            if (j3 > 0) {
                contentValues.put("_id", Long.valueOf(j3));
            }
            contentValues.put("_tm", Long.valueOf(crashDetailBean.f97900z));
            contentValues.put("_s1", crashDetailBean.C);
            int i16 = 1;
            if (crashDetailBean.f97880f) {
                i3 = 1;
            } else {
                i3 = 0;
            }
            contentValues.put("_up", Integer.valueOf(i3));
            if (!crashDetailBean.f97892r) {
                i16 = 0;
            }
            contentValues.put("_me", Integer.valueOf(i16));
            contentValues.put("_uc", Integer.valueOf(crashDetailBean.f97894t));
            contentValues.put("_dt", ba.a(crashDetailBean));
            return contentValues;
        } catch (Throwable th5) {
            if (!av.a(th5)) {
                th5.printStackTrace();
            }
            return null;
        }
    }

    private void i(CrashDetailBean crashDetailBean) {
        String absolutePath;
        try {
            av.c("save eup logs", new Object[0]);
            String str = "#--------\npackage:" + ai.c().f() + "\nversion:" + crashDetailBean.f97885k + "\nsdk:" + crashDetailBean.f97884j + "\nprocess:" + crashDetailBean.I + "\ndate:" + ba.b(new Date(crashDetailBean.f97900z)) + "\ntype:" + crashDetailBean.f97896v + "\nmessage:" + crashDetailBean.f97897w + "\nstack:\n" + crashDetailBean.f97899y + "\neupID:" + crashDetailBean.f97877c + "\n";
            if (be.f98220n == null) {
                File externalFilesDir = this.f98200b.getExternalFilesDir("/Tencent/Bugly");
                if (externalFilesDir != null) {
                    absolutePath = externalFilesDir.getAbsolutePath();
                } else {
                    absolutePath = null;
                }
            } else {
                File file = new File(be.f98220n);
                if (file.isFile()) {
                    file = file.getParentFile();
                }
                absolutePath = file.getAbsolutePath();
            }
            aw.a(absolutePath + "/euplog.txt", str, be.f98221o);
        } catch (Throwable th5) {
            av.d("rqdp{  save error} %s", th5.toString());
            if (!av.a(th5)) {
                th5.printStackTrace();
            }
        }
    }

    private static boolean j(CrashDetailBean crashDetailBean) {
        Iterator<a> it = f98197j.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (next.a(crashDetailBean)) {
                return next.a();
            }
        }
        return false;
    }

    private static void d(List<bc> list) {
        List<CrashDetailBean> a16 = a(list);
        if (a16 == null || a16.isEmpty()) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (CrashDetailBean crashDetailBean : a16) {
            String str = f98195h.get(Integer.valueOf(crashDetailBean.f97876b));
            if (!TextUtils.isEmpty(str)) {
                av.c("find expired data,crashId:%s eventType:%s", crashDetailBean.f97877c, str);
                arrayList.add(new ao.c(crashDetailBean.f97877c, str, crashDetailBean.f97900z, false, 0L, "expired", null));
            }
        }
        ao.a.a().a(arrayList);
    }

    private static boolean b(String str) {
        String str2 = be.f98228v;
        if (str2 != null && !str2.isEmpty()) {
            try {
                av.c("Crash regular filter for crash stack is: %s", be.f98228v);
                if (Pattern.compile(be.f98228v).matcher(str).find()) {
                    av.d("This crash matches the regular filter string set. It will not be record and upload.", new Object[0]);
                    return true;
                }
            } catch (Exception e16) {
                av.a(e16);
                av.d("Failed to compile " + be.f98228v, new Object[0]);
            }
        }
        return false;
    }

    private static void c() {
        StringBuilder sb5 = new StringBuilder();
        sb5.append("_id in (");
        sb5.append("SELECT _id FROM t_cr order by _id limit 5");
        sb5.append(")");
        String sb6 = sb5.toString();
        sb5.setLength(0);
        try {
            av.c("deleted first record %s data %d", "t_cr", Integer.valueOf(ae.a().a("t_cr", sb6, (String[]) null)));
        } catch (Throwable th5) {
            if (av.a(th5)) {
                return;
            }
            th5.printStackTrace();
        }
    }

    private static void f(List<CrashDetailBean> list) {
        try {
            if (list.size() == 0) {
                return;
            }
            StringBuilder sb5 = new StringBuilder();
            for (CrashDetailBean crashDetailBean : list) {
                sb5.append(" or _id = ");
                sb5.append(crashDetailBean.f97859a);
            }
            String sb6 = sb5.toString();
            if (sb6.length() > 0) {
                sb6 = sb6.substring(4);
            }
            sb5.setLength(0);
            av.c("deleted %s data %d", "t_cr", Integer.valueOf(ae.a().a("t_cr", sb6, (String[]) null)));
        } catch (Throwable th5) {
            if (av.a(th5)) {
                return;
            }
            th5.printStackTrace();
        }
    }

    private static void e(List<bc> list) {
        if (list == null || list.size() == 0) {
            return;
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append("_id in (");
        Iterator<bc> it = list.iterator();
        while (it.hasNext()) {
            sb5.append(it.next().f98188a);
            sb5.append(",");
        }
        StringBuilder sb6 = new StringBuilder(sb5.substring(0, sb5.lastIndexOf(",")));
        sb6.append(")");
        String sb7 = sb6.toString();
        sb6.setLength(0);
        try {
            av.c("deleted %s data %d", "t_cr", Integer.valueOf(ae.a().a("t_cr", sb7, (String[]) null)));
        } catch (Throwable th5) {
            if (av.a(th5)) {
                return;
            }
            th5.printStackTrace();
        }
    }

    private byte[] d(CrashDetailBean crashDetailBean, boolean z16) {
        if (this.f98204f != null) {
            av.c("Calling 'getCrashExtraData' of RQD crash listener.", new Object[0]);
            return this.f98204f.a(z16, crashDetailBean.f97896v, crashDetailBean.f97898x, crashDetailBean.f97899y, crashDetailBean.f97900z);
        }
        if (this.f98205g == null) {
            return null;
        }
        av.c("Calling 'onCrashHandleStart2GetExtraDatas' of Bugly crash listener.", new Object[0]);
        return this.f98205g.b();
    }

    public final void b(CrashDetailBean crashDetailBean, boolean z16) {
        if (be.f98222p) {
            av.a("try to upload right now", new Object[0]);
            ArrayList arrayList = new ArrayList();
            arrayList.add(crashDetailBean);
            a(arrayList, 3000L, z16, crashDetailBean.f97876b == 7, z16);
            return;
        }
        av.a("do not upload spot crash right now, crash would be uploaded when app next start", new Object[0]);
    }

    private Map<String, String> c(CrashDetailBean crashDetailBean, boolean z16) {
        if (this.f98204f != null) {
            av.c("Calling 'onCrashHandleStart' of RQD crash listener.", new Object[0]);
            this.f98204f.a(z16);
            av.c("Calling 'getCrashExtraMessage' of RQD crash listener.", new Object[0]);
            String b16 = this.f98204f.b(z16, crashDetailBean.f97896v, crashDetailBean.f97898x, crashDetailBean.f97899y, crashDetailBean.f97900z);
            if (b16 == null) {
                return null;
            }
            HashMap hashMap = new HashMap(1);
            hashMap.put("userData", b16);
            return hashMap;
        }
        if (this.f98205g == null) {
            return null;
        }
        av.c("Calling 'onCrashHandleStart' of Bugly crash listener.", new Object[0]);
        return this.f98205g.a();
    }

    private static void a(CrashDetailBean crashDetailBean, List<CrashDetailBean> list) {
        String[] split;
        StringBuilder sb5 = new StringBuilder(128);
        for (int i3 = 1; i3 < list.size(); i3++) {
            String str = list.get(i3).A;
            if (str != null && (split = str.split("\n")) != null) {
                for (String str2 : split) {
                    if (!crashDetailBean.A.contains(str2)) {
                        crashDetailBean.B++;
                        sb5.append(str2);
                        sb5.append("\n");
                    }
                }
            }
        }
        crashDetailBean.A += sb5.toString();
    }

    public final void b(CrashDetailBean crashDetailBean) {
        if (crashDetailBean == null) {
            return;
        }
        ContentValues h16 = h(crashDetailBean);
        if (h16 != null) {
            long a16 = ae.a().a("t_cr", h16, (ad) null);
            if (a16 >= 0) {
                av.c("insert %s success!", "t_cr");
                crashDetailBean.f97859a = a16;
            }
        }
        if (be.f98219m) {
            i(crashDetailBean);
        }
    }

    private void e(CrashDetailBean crashDetailBean, boolean z16) {
        if (this.f98204f != null) {
            av.c("Calling 'onCrashSaving' of RQD crash listener.", new Object[0]);
            if (this.f98204f.a(z16, crashDetailBean.f97896v, crashDetailBean.f97897w, crashDetailBean.f97898x, crashDetailBean.f97899y, crashDetailBean.f97900z, crashDetailBean.f97895u, crashDetailBean.f97882h, crashDetailBean.f97877c, crashDetailBean.I)) {
                return;
            }
            av.d("Crash listener 'onCrashSaving' return 'false' thus will not handle this crash.", new Object[0]);
        }
    }

    private static bc b(Cursor cursor) {
        if (cursor == null) {
            return null;
        }
        try {
            bc bcVar = new bc();
            bcVar.f98188a = cursor.getLong(cursor.getColumnIndex("_id"));
            bcVar.f98189b = cursor.getLong(cursor.getColumnIndex("_tm"));
            bcVar.f98190c = cursor.getString(cursor.getColumnIndex("_s1"));
            bcVar.f98191d = cursor.getInt(cursor.getColumnIndex("_up")) == 1;
            bcVar.f98192e = cursor.getInt(cursor.getColumnIndex("_me")) == 1;
            bcVar.f98193f = cursor.getInt(cursor.getColumnIndex("_uc"));
            return bcVar;
        } catch (Throwable th5) {
            if (!av.a(th5)) {
                th5.printStackTrace();
            }
            return null;
        }
    }

    public static String c(CrashDetailBean crashDetailBean) {
        try {
            Pair<String, String> pair = f98196i.get(Integer.valueOf(crashDetailBean.f97876b));
            if (pair == null) {
                av.e("crash type error! %d", Integer.valueOf(crashDetailBean.f97876b));
                return "";
            }
            if (crashDetailBean.f97892r) {
                return (String) pair.first;
            }
            return (String) pair.second;
        } catch (Exception e16) {
            av.a(e16);
            return "";
        }
    }

    public final boolean a(CrashDetailBean crashDetailBean, boolean z16) {
        return a(crashDetailBean, -123456789, z16);
    }

    public final boolean a(CrashDetailBean crashDetailBean, int i3, boolean z16) {
        if (crashDetailBean == null) {
            av.d("CrashBean is null, won't handle.", new Object[0]);
            return true;
        }
        b(crashDetailBean);
        if (crashDetailBean.f97876b == 0) {
            az.a().a(az.b.f98176h - 1, true, true);
        }
        if (crashDetailBean.f97876b == 3) {
            NativeCrashHandler.getInstance().modifyProcessingState(az.b.f98176h - 1, true);
        }
        if (crashDetailBean.f97876b == 1 && i3 != -123456789) {
            NativeCrashHandler.getInstance().modifyProcessingState(az.b.f98176h - 1, true);
        }
        if (crashDetailBean.f97876b != 1) {
            String a16 = ba.a(be.f98211e, be.f98212f, be.f98218l, crashDetailBean.f97900z, be.f98224r, be.f98213g);
            crashDetailBean.E = a16;
            if (a16 != null && a16.length() >= 50) {
                int i16 = crashDetailBean.f97876b;
                if (i16 == 0) {
                    az.a().a(az.a.f98160c - 1, true);
                } else if (i16 == 3) {
                    NativeCrashHandler.getInstance().modifyAttachmentState(az.a.f98160c - 1);
                }
            }
        }
        if (z16) {
            g(crashDetailBean);
        }
        if (crashDetailBean.f97876b == 0) {
            az.a().a(az.b.f98177i - 1, false, true);
        }
        if (crashDetailBean.f97876b == 3) {
            NativeCrashHandler.getInstance().modifyProcessingState(az.b.f98177i - 1, false);
        }
        if (crashDetailBean.f97876b == 1 && i3 != -123456789) {
            NativeCrashHandler.getInstance().modifyProcessingState(az.b.f98177i - 1, false);
        }
        if (a(crashDetailBean.f97899y) || b(crashDetailBean.f97899y)) {
            return true;
        }
        e(crashDetailBean);
        List<bc> b16 = b();
        List<bc> arrayList = new ArrayList<>(10);
        if (b16 != null && b16.size() > 0) {
            arrayList.addAll(c(b16));
            b16.removeAll(arrayList);
            if (b16.size() > 20) {
                c();
            }
            if (b(crashDetailBean, b16, arrayList)) {
                return true;
            }
        }
        b(crashDetailBean);
        d(crashDetailBean);
        e(arrayList);
        av.b("[crash] save crash success", new Object[0]);
        return false;
    }

    public static List<bc> b() {
        ArrayList arrayList = new ArrayList();
        Cursor cursor = null;
        try {
            Cursor a16 = ae.a().a("t_cr", new String[]{"_id", "_tm", "_s1", "_up", "_me", "_uc"}, (String) null);
            if (a16 == null) {
                if (a16 != null) {
                    a16.close();
                }
                return null;
            }
            try {
                if (a16.getCount() <= 0) {
                    a16.close();
                    return arrayList;
                }
                StringBuilder sb5 = new StringBuilder();
                sb5.append("_id in (");
                int i3 = 0;
                while (a16.moveToNext()) {
                    bc b16 = b(a16);
                    if (b16 != null) {
                        arrayList.add(b16);
                    } else {
                        try {
                            sb5.append(a16.getLong(a16.getColumnIndex("_id")));
                            sb5.append(",");
                            i3++;
                        } catch (Throwable unused) {
                            av.d("unknown id!", new Object[0]);
                        }
                    }
                }
                if (sb5.toString().contains(",")) {
                    sb5 = new StringBuilder(sb5.substring(0, sb5.lastIndexOf(",")));
                }
                sb5.append(")");
                String sb6 = sb5.toString();
                sb5.setLength(0);
                if (i3 > 0) {
                    av.d("deleted %s illegal data %d", "t_cr", Integer.valueOf(ae.a().a("t_cr", sb6, (String[]) null)));
                }
                a16.close();
                return arrayList;
            } catch (Throwable th5) {
                th = th5;
                cursor = a16;
                try {
                    if (!av.a(th)) {
                        th.printStackTrace();
                    }
                    return arrayList;
                } finally {
                    if (cursor != null) {
                        cursor.close();
                    }
                }
            }
        } catch (Throwable th6) {
            th = th6;
        }
    }

    public final byte[] b(List<CrashDetailBean> list) {
        if (list != null && list.size() != 0) {
            try {
                ci a16 = a(this.f98200b, list, ai.c());
                if (a16 == null) {
                    av.d("create eupPkg fail!", new Object[0]);
                    return null;
                }
                byte[] a17 = am.a((m) a16);
                if (a17 == null) {
                    av.d("send encode fail!", new Object[0]);
                    return null;
                }
                byte[] a18 = am.a((Object) am.a(this.f98200b, 630, a17));
                bg.a(true, list);
                return a18;
            } catch (Throwable th5) {
                if (!av.a(th5)) {
                    th5.printStackTrace();
                }
            }
        }
        return null;
    }

    private static boolean a(String str) {
        String str2 = be.f98227u;
        if (str2 != null && !str2.isEmpty()) {
            av.c("Crash filter for crash stack is: %s", be.f98227u);
            if (str.contains(be.f98227u)) {
                av.d("This crash contains the filter string set. It will not be record and upload.", new Object[0]);
                return true;
            }
        }
        return false;
    }

    private static boolean a(CrashDetailBean crashDetailBean, List<bc> list, List<bc> list2) {
        boolean z16 = false;
        for (bc bcVar : list) {
            if (crashDetailBean.C.equals(bcVar.f98190c)) {
                if (bcVar.f98192e) {
                    z16 = true;
                }
                list2.add(bcVar);
            }
        }
        return z16;
    }

    /* JADX WARN: Code restructure failed: missing block: B:42:0x0049, code lost:
    
        if (r0.size() >= com.tencent.bugly.proguard.be.f98209c) goto L30;
     */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0035 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0036  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean b(CrashDetailBean crashDetailBean, List<bc> list, List<bc> list2) {
        boolean z16;
        bc f16;
        int i3 = crashDetailBean.f97876b;
        boolean z17 = i3 == 0 || i3 == 1;
        boolean z18 = i3 == 3;
        if (!p.f98529c) {
            if (!z18 && !z17) {
                z16 = true;
            } else if (!crashDetailBean.f97879e.booleanValue() && !ai.c().b()) {
                z16 = be.f98210d;
            }
            if (z16) {
                return false;
            }
            ArrayList<bc> arrayList = new ArrayList(10);
            if (!a(crashDetailBean, list, arrayList)) {
                try {
                } catch (Exception e16) {
                    av.a(e16);
                    av.d("Failed to merge crash.", new Object[0]);
                }
            }
            av.a("same crash occur too much do merged!", new Object[0]);
            CrashDetailBean a16 = a(arrayList, crashDetailBean);
            for (bc bcVar : arrayList) {
                if (bcVar.f98188a != a16.f97859a) {
                    list2.add(bcVar);
                }
            }
            if (crashDetailBean.f97859a != a16.f97859a && (f16 = f(crashDetailBean)) != null) {
                list2.add(f16);
            }
            b(a16);
            e(list2);
            av.b("[crash] save crash success. For this device crash many times, it will not upload crashes immediately", new Object[0]);
            return true;
        }
        z16 = false;
        if (z16) {
        }
        return false;
    }

    public static List<CrashDetailBean> a() {
        StrategyBean c16 = ak.a().c();
        if (c16 == null) {
            av.d("have not synced remote!", new Object[0]);
            return null;
        }
        if (!c16.f97841f) {
            av.d("Crashreport remote closed, please check your APP ID correct and Version available, then uninstall and reinstall your app.", new Object[0]);
            av.b("[init] WARNING! Crashreport closed by server, please check your APP ID correct and Version available, then uninstall and reinstall your app.", new Object[0]);
            return null;
        }
        long currentTimeMillis = System.currentTimeMillis();
        long b16 = ba.b();
        List<bc> b17 = b();
        av.c("Size of crash list loaded from DB: %s", Integer.valueOf(b17.size()));
        if (b17.size() <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        arrayList.addAll(c(b17));
        b17.removeAll(arrayList);
        Iterator<bc> it = b17.iterator();
        while (it.hasNext()) {
            bc next = it.next();
            long j3 = next.f98189b;
            if (j3 < b16 - be.f98217k) {
                arrayList2.add(next);
                it.remove();
                arrayList.add(next);
            } else if (next.f98191d) {
                if (j3 >= currentTimeMillis - 86400000) {
                    it.remove();
                } else if (!next.f98192e) {
                    it.remove();
                    arrayList.add(next);
                }
            } else if (next.f98193f >= 3 && j3 < currentTimeMillis - 86400000) {
                it.remove();
                arrayList.add(next);
            }
        }
        d(arrayList2);
        if (arrayList.size() > 0) {
            e(arrayList);
        }
        ArrayList arrayList3 = new ArrayList();
        List<CrashDetailBean> a16 = a(b17);
        if (a16 != null && a16.size() > 0) {
            String str = ai.c().f98032t;
            Iterator<CrashDetailBean> it5 = a16.iterator();
            while (it5.hasNext()) {
                CrashDetailBean next2 = it5.next();
                if (!str.equals(next2.f97885k)) {
                    it5.remove();
                    arrayList3.add(next2);
                }
            }
        }
        if (arrayList3.size() > 0) {
            f(arrayList3);
        }
        return a16;
    }

    public final void a(CrashDetailBean crashDetailBean) {
        int i3 = crashDetailBean.f97876b;
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 == 3 && !be.a().n()) {
                    return;
                }
            } else if (!be.a().m()) {
                return;
            }
        } else if (!be.a().m()) {
            return;
        }
        if (this.f98204f != null) {
            av.c("Calling 'onCrashHandleEnd' of RQD crash listener.", new Object[0]);
            this.f98204f.b(crashDetailBean.f97876b == 1);
        }
    }

    public final void a(List<CrashDetailBean> list, long j3, boolean z16, boolean z17, boolean z18) {
        aq aqVar = this.f98201c;
        if (aqVar == null) {
            av.d("warn: upload manager is null", new Object[0]);
            return;
        }
        if (!z18 && !aqVar.b(be.f98207a)) {
            av.d("warn: not crashHappen or not should upload", new Object[0]);
            return;
        }
        if (!this.f98203e.c().f97841f) {
            av.d("[crash] server closed bugly in this app. please check your app id if is correct, and re-install it", new Object[0]);
            return;
        }
        if (list != null && list.size() != 0) {
            if (ai.f97987ae) {
                bg.a(this.f98200b, this.f98201c, list, j3, z16);
                return;
            } else {
                bg.a(this.f98200b, this.f98203e, f98194a, this.f98201c, list, j3, z16, z17);
                return;
            }
        }
        av.d("warn: crashList is null or crashList num is 0", new Object[0]);
    }

    private static CrashDetailBean a(Cursor cursor) {
        if (cursor == null) {
            return null;
        }
        try {
            byte[] blob = cursor.getBlob(cursor.getColumnIndex("_dt"));
            if (blob == null) {
                return null;
            }
            long j3 = cursor.getLong(cursor.getColumnIndex("_id"));
            CrashDetailBean crashDetailBean = (CrashDetailBean) ba.a(blob, CrashDetailBean.CREATOR);
            if (crashDetailBean != null) {
                crashDetailBean.f97859a = j3;
            }
            return crashDetailBean;
        } catch (Throwable th5) {
            if (!av.a(th5)) {
                th5.printStackTrace();
            }
            return null;
        }
    }

    public static List<CrashDetailBean> a(List<bc> list) {
        Cursor cursor;
        if (list == null || list.size() == 0) {
            return null;
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append("_id in (");
        Iterator<bc> it = list.iterator();
        while (it.hasNext()) {
            sb5.append(it.next().f98188a);
            sb5.append(",");
        }
        if (sb5.toString().contains(",")) {
            sb5 = new StringBuilder(sb5.substring(0, sb5.lastIndexOf(",")));
        }
        sb5.append(")");
        String sb6 = sb5.toString();
        sb5.setLength(0);
        try {
            cursor = ae.a().a("t_cr", (String[]) null, sb6);
            if (cursor == null) {
                return null;
            }
            try {
                ArrayList arrayList = new ArrayList();
                sb5.append("_id in (");
                int i3 = 0;
                while (cursor.moveToNext()) {
                    CrashDetailBean a16 = a(cursor);
                    if (a16 != null) {
                        arrayList.add(a16);
                    } else {
                        try {
                            sb5.append(cursor.getLong(cursor.getColumnIndex("_id")));
                            sb5.append(",");
                            i3++;
                        } catch (Throwable unused) {
                            av.d("unknown id!", new Object[0]);
                        }
                    }
                }
                if (sb5.toString().contains(",")) {
                    sb5 = new StringBuilder(sb5.substring(0, sb5.lastIndexOf(",")));
                }
                sb5.append(")");
                String sb7 = sb5.toString();
                if (i3 > 0) {
                    av.d("deleted %s illegal data %d", "t_cr", Integer.valueOf(ae.a().a("t_cr", sb7, (String[]) null)));
                }
                cursor.close();
                return arrayList;
            } catch (Throwable th5) {
                th = th5;
                try {
                    if (!av.a(th)) {
                        th.printStackTrace();
                    }
                    if (cursor != null) {
                        cursor.close();
                    }
                    return null;
                } finally {
                    if (cursor != null) {
                        cursor.close();
                    }
                }
            }
        } catch (Throwable th6) {
            th = th6;
            cursor = null;
        }
    }

    private static ch a(Context context, CrashDetailBean crashDetailBean, ai aiVar) {
        ArrayList<ce> arrayList = null;
        if (context != null && crashDetailBean != null && aiVar != null) {
            ch chVar = new ch();
            chVar.f98402a = c(crashDetailBean);
            chVar.f98403b = crashDetailBean.f97900z;
            chVar.f98404c = crashDetailBean.f97896v;
            chVar.f98405d = crashDetailBean.f97897w;
            chVar.f98406e = crashDetailBean.f97898x;
            chVar.f98408g = crashDetailBean.f97899y;
            chVar.f98409h = crashDetailBean.H;
            chVar.f98410i = crashDetailBean.f97877c;
            chVar.f98411j = null;
            chVar.f98413l = crashDetailBean.f97895u;
            chVar.f98414m = crashDetailBean.f97882h;
            chVar.f98407f = crashDetailBean.J;
            chVar.f98415n = null;
            Map<String, PlugInBean> map = crashDetailBean.f97890p;
            if (map != null && !map.isEmpty()) {
                arrayList = new ArrayList<>(crashDetailBean.f97890p.size());
                for (Map.Entry<String, PlugInBean> entry : crashDetailBean.f97890p.entrySet()) {
                    ce ceVar = new ce();
                    ceVar.f98385a = entry.getValue().f97833a;
                    ceVar.f98387c = entry.getValue().f97835c;
                    ceVar.f98389e = entry.getValue().f97834b;
                    arrayList.add(ceVar);
                }
            }
            chVar.f98417p = arrayList;
            av.c("libInfo %s", chVar.f98416o);
            chVar.f98418q = a(crashDetailBean, context, false);
            if (crashDetailBean.f97892r) {
                chVar.f98412k = crashDetailBean.B;
            }
            chVar.f98419r = a(crashDetailBean, aiVar, true);
            chVar.f98420s = new HashMap();
            Map<String, String> map2 = crashDetailBean.f97862ac;
            if (map2 != null && map2.size() > 0) {
                chVar.f98420s.putAll(crashDetailBean.f97862ac);
                av.a("setted message size %d", Integer.valueOf(chVar.f98420s.size()));
            }
            Map<String, String> map3 = chVar.f98420s;
            av.c("pss:" + crashDetailBean.Q + " vss:" + crashDetailBean.R + " javaHeap:" + crashDetailBean.S + " jvmMaxRam:" + crashDetailBean.T + " jvmAllocRam:" + crashDetailBean.U, new Object[0]);
            StringBuilder sb5 = new StringBuilder();
            sb5.append(crashDetailBean.Q);
            map3.put(Constants.SDK_UPLOAD_PSS, sb5.toString());
            StringBuilder sb6 = new StringBuilder();
            sb6.append(crashDetailBean.R);
            map3.put(Constants.SDK_UPLOAD_VSS, sb6.toString());
            StringBuilder sb7 = new StringBuilder();
            sb7.append(crashDetailBean.S);
            map3.put(Constants.SDK_UPLOAD_JAVA_HEAP, sb7.toString());
            StringBuilder sb8 = new StringBuilder();
            sb8.append(crashDetailBean.T);
            map3.put(Constants.SDK_UPLOAD_JVM_MAX, sb8.toString());
            StringBuilder sb9 = new StringBuilder();
            sb9.append(crashDetailBean.U);
            map3.put(Constants.SDK_UPLOAD_JVM_ALLOC, sb9.toString());
            StringBuilder sb10 = new StringBuilder();
            sb10.append(aiVar.D());
            map3.put(Constants.SDK_UPLOAD_EMULATOR_CONFIDENCE, sb10.toString());
            map3.put(Constants.SDK_UPLOAD_EMULATOR_REASON, aiVar.E());
            av.c("emulator confidence: " + aiVar.f98037y + "\nemulator reason: " + aiVar.f98038z, new Object[0]);
            String n3 = aiVar.n();
            map3.put(Constants.SDK_UPLOAD_CPU_TYPE_DEVICE, String.valueOf(n3));
            av.c("device cpu type: ".concat(String.valueOf(n3)), new Object[0]);
            Object[] objArr = new Object[12];
            objArr[0] = crashDetailBean.f97896v;
            objArr[1] = crashDetailBean.f97877c;
            objArr[2] = aiVar.e();
            objArr[3] = Long.valueOf((crashDetailBean.f97900z - crashDetailBean.f97860aa) / 1000);
            objArr[4] = Boolean.valueOf(crashDetailBean.f97893s);
            objArr[5] = Boolean.valueOf(crashDetailBean.f97861ab);
            objArr[6] = Boolean.valueOf(crashDetailBean.f97892r);
            objArr[7] = Boolean.valueOf(crashDetailBean.f97876b == 1);
            objArr[8] = Integer.valueOf(crashDetailBean.B);
            objArr[9] = crashDetailBean.A;
            objArr[10] = Boolean.valueOf(crashDetailBean.f97880f);
            objArr[11] = Integer.valueOf(chVar.f98419r.size());
            av.c("%s rid:%s sess:%s ls:%ds isR:%b isF:%b isM:%b isN:%b mc:%d ,%s ,isUp:%b ,vm:%d", objArr);
            return chVar;
        }
        av.d("enExp args == null", new Object[0]);
        return null;
    }

    public static ci a(Context context, List<CrashDetailBean> list, ai aiVar) {
        if (context != null && list != null && list.size() != 0 && aiVar != null) {
            ci ciVar = new ci();
            ciVar.f98424a = new ArrayList<>();
            Iterator<CrashDetailBean> it = list.iterator();
            while (it.hasNext()) {
                ciVar.f98424a.add(a(context, it.next(), aiVar));
            }
            return ciVar;
        }
        av.d("enEXPPkg args == null!", new Object[0]);
        return null;
    }

    private static cg a(String str, Context context, String str2) {
        FileInputStream fileInputStream;
        if (str2 != null && context != null) {
            av.c("zip %s", str2);
            File file = new File(str2);
            File file2 = new File(context.getCacheDir(), str);
            if (!ba.a(file, file2)) {
                av.d("zip fail!", new Object[0]);
                return null;
            }
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                fileInputStream = new FileInputStream(file2);
            } catch (Throwable th5) {
                th = th5;
                fileInputStream = null;
            }
            try {
                byte[] bArr = new byte[4096];
                while (true) {
                    int read = fileInputStream.read(bArr);
                    if (read <= 0) {
                        break;
                    }
                    byteArrayOutputStream.write(bArr, 0, read);
                    byteArrayOutputStream.flush();
                }
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                av.c("read bytes :%d", Integer.valueOf(byteArray.length));
                cg cgVar = new cg((byte) 2, file2.getName(), byteArray);
                try {
                    fileInputStream.close();
                } catch (IOException e16) {
                    if (!av.a(e16)) {
                        e16.printStackTrace();
                    }
                }
                if (file2.exists()) {
                    av.c("del tmp", new Object[0]);
                    file2.delete();
                }
                return cgVar;
            } catch (Throwable th6) {
                th = th6;
                try {
                    if (!av.a(th)) {
                        th.printStackTrace();
                    }
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException e17) {
                            if (!av.a(e17)) {
                                e17.printStackTrace();
                            }
                        }
                    }
                    if (file2.exists()) {
                        av.c("del tmp", new Object[0]);
                        file2.delete();
                    }
                    return null;
                } catch (Throwable th7) {
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException e18) {
                            if (!av.a(e18)) {
                                e18.printStackTrace();
                            }
                        }
                    }
                    if (file2.exists()) {
                        av.c("del tmp", new Object[0]);
                        file2.delete();
                    }
                    throw th7;
                }
            }
        }
        av.d("rqdp{  createZipAttachment sourcePath == null || context == null ,pls check}", new Object[0]);
        return null;
    }

    public static void a(String str, String str2, String str3, String str4, String str5, CrashDetailBean crashDetailBean) {
        String str6;
        ai c16 = ai.c();
        if (c16 == null || crashDetailBean == null) {
            return;
        }
        av.e("#++++++++++Record By Bugly++++++++++#", new Object[0]);
        av.e("# You can use Bugly(http:\\\\bugly.qq.com) to get more Crash Detail!", new Object[0]);
        av.e("# PKG NAME: %s", c16.f98015c);
        av.e("# APP VER: %s", crashDetailBean.f97885k);
        av.e("# SDK VER: %s", crashDetailBean.f97884j);
        av.e("# LAUNCH TIME: %s", ba.b(new Date(ai.c().f97991a)));
        av.e("# CRASH TYPE: %s", str);
        av.e("# CRASH TIME: %s", str2);
        av.e("# CRASH PROCESS: %s", str3);
        av.e("# CRASH FOREGROUND: %s", Boolean.valueOf(c16.b()));
        av.e("# CRASH THREAD: %s", str4);
        av.e("# REPORT ID: %s", crashDetailBean.f97877c);
        Object[] objArr = new Object[2];
        objArr[0] = crashDetailBean.f97883i;
        objArr[1] = c16.s().booleanValue() ? "ROOTED" : "UNROOT";
        av.e("# CRASH DEVICE: %s %s", objArr);
        av.e("# RUNTIME AVAIL RAM:%d ROM:%d SD:%d", Long.valueOf(crashDetailBean.K), Long.valueOf(crashDetailBean.L), Long.valueOf(crashDetailBean.M));
        av.e("# RUNTIME TOTAL RAM:%d ROM:%d SD:%d", Long.valueOf(crashDetailBean.N), Long.valueOf(crashDetailBean.O), Long.valueOf(crashDetailBean.P));
        if (!ba.b(crashDetailBean.Y)) {
            av.e("# EXCEPTION FIRED BY %s %s", crashDetailBean.Y, crashDetailBean.X);
        } else if (crashDetailBean.f97876b == 3) {
            Object[] objArr2 = new Object[1];
            if (crashDetailBean.f97863ad == null) {
                str6 = "null";
            } else {
                str6 = crashDetailBean.f97863ad.get("BUGLY_CR_01");
            }
            objArr2[0] = str6;
            av.e("# EXCEPTION ANR MESSAGE:\n %s", objArr2);
        }
        if (!ba.b(str5)) {
            av.e("# CRASH STACK: ", new Object[0]);
            av.e(str5, new Object[0]);
        }
        av.e("#++++++++++++++++++++++++++++++++++++++++++#", new Object[0]);
    }

    private static void a(CrashDetailBean crashDetailBean, byte[] bArr) {
        if (bArr == null) {
            av.d("extra user byte is null. CrashBean won't have userExtraByteDatas.", new Object[0]);
            return;
        }
        if (bArr.length <= 100000) {
            crashDetailBean.f97868ai = bArr;
        } else {
            av.d("extra bytes size %d is over limit %d will drop over part", Integer.valueOf(bArr.length), 100000);
            crashDetailBean.f97868ai = Arrays.copyOf(bArr, 100000);
        }
        av.a("add extra bytes %d ", Integer.valueOf(bArr.length));
    }

    private static void a(CrashDetailBean crashDetailBean, Map<String, String> map) {
        String value;
        if (map != null && !map.isEmpty()) {
            crashDetailBean.f97862ac = new LinkedHashMap(map.size());
            for (Map.Entry<String, String> entry : map.entrySet()) {
                if (!ba.b(entry.getKey())) {
                    String key = entry.getKey();
                    if (key.length() > 100) {
                        key = key.substring(0, 100);
                        av.d("setted key length is over limit %d substring to %s", 100, key);
                    }
                    if (!ba.b(entry.getValue()) && entry.getValue().length() > 100000) {
                        value = entry.getValue().substring(entry.getValue().length() - 100000);
                        av.d("setted %s value length is over limit %d substring", key, 100000);
                    } else {
                        value = entry.getValue();
                    }
                    crashDetailBean.f97862ac.put(key, value);
                    av.a("add setted key %s value size:%d", key, Integer.valueOf(value.length()));
                }
            }
            return;
        }
        av.d("extra map is empty. CrashBean won't have userDatas.", new Object[0]);
    }

    public static ArrayList<cg> a(CrashDetailBean crashDetailBean, Context context, boolean z16) {
        String str;
        cg a16;
        String str2;
        ArrayList<cg> arrayList = new ArrayList<>(20);
        if (crashDetailBean.f97892r && (str2 = crashDetailBean.A) != null && str2.length() > 0) {
            try {
                arrayList.add(new cg((byte) 1, "alltimes.txt", crashDetailBean.A.getBytes("utf-8")));
            } catch (Exception e16) {
                e16.printStackTrace();
                av.a(e16);
            }
        }
        String str3 = crashDetailBean.E;
        if (str3 != null) {
            try {
                arrayList.add(new cg((byte) 1, "log.txt", str3.getBytes("utf-8")));
            } catch (Exception e17) {
                e17.printStackTrace();
                av.a(e17);
            }
        }
        String str4 = crashDetailBean.F;
        if (str4 != null) {
            try {
                arrayList.add(new cg((byte) 1, "jniLog.txt", str4.getBytes("utf-8")));
            } catch (Exception e18) {
                e18.printStackTrace();
                av.a(e18);
            }
        }
        String str5 = crashDetailBean.f97869aj;
        if (!ba.b(str5)) {
            try {
                cg cgVar = new cg((byte) 1, "crashInfos.txt", str5.getBytes("utf-8"));
                av.c("attach crash infos", new Object[0]);
                arrayList.add(cgVar);
            } catch (Exception e19) {
                e19.printStackTrace();
                av.a(e19);
            }
        }
        byte[] bArr = crashDetailBean.G;
        if (bArr != null && bArr.length > 0) {
            try {
                cg cgVar2 = new cg((byte) 2, "buglylog.zip", bArr);
                av.c("attach user log", new Object[0]);
                arrayList.add(cgVar2);
            } catch (Exception e26) {
                av.a(e26);
            }
        }
        if (crashDetailBean.f97876b == 3) {
            av.c("crashBean.anrMessages:%s", crashDetailBean.f97863ad);
            try {
                Map<String, String> map = crashDetailBean.f97863ad;
                if (map != null && map.containsKey("BUGLY_CR_01")) {
                    if (!TextUtils.isEmpty(crashDetailBean.f97863ad.get("BUGLY_CR_01"))) {
                        arrayList.add(new cg((byte) 1, "anrMessage.txt", crashDetailBean.f97863ad.get("BUGLY_CR_01").getBytes("utf-8")));
                        av.c("attach anr message", new Object[0]);
                    }
                    crashDetailBean.f97863ad.remove("BUGLY_CR_01");
                }
                String str6 = crashDetailBean.D;
                if (str6 != null && (a16 = a("trace.zip", context, str6)) != null) {
                    av.c("attach traces", new Object[0]);
                    arrayList.add(a16);
                }
            } catch (Exception e27) {
                e27.printStackTrace();
                av.a(e27);
            }
        }
        if (crashDetailBean.f97876b == 1 && (str = crashDetailBean.D) != null) {
            try {
                cg a17 = a("tomb.zip", context, str);
                if (a17 != null) {
                    av.c("attach tombs", new Object[0]);
                    arrayList.add(a17);
                }
            } catch (Exception e28) {
                av.a(e28);
            }
        }
        a(arrayList, crashDetailBean.f97889o);
        byte[] bArr2 = crashDetailBean.f97868ai;
        if (bArr2 != null && bArr2.length > 0) {
            try {
                arrayList.add(new cg((byte) 1, "userExtraByteData", bArr2));
                av.c("attach extraData", new Object[0]);
            } catch (Exception e29) {
                av.a(e29);
            }
        }
        if (z16) {
            Map<String, String> map2 = crashDetailBean.f97862ac;
            if (map2 != null && map2.size() > 0) {
                a(arrayList, "user_datas.log", crashDetailBean.f97862ac.toString());
            }
            Map<String, String> map3 = crashDetailBean.f97866ag;
            if (map3 != null && map3.size() > 0) {
                StringBuilder sb5 = new StringBuilder();
                for (Map.Entry<String, String> entry : crashDetailBean.f97866ag.entrySet()) {
                    sb5.append("C03_" + entry.getKey());
                    sb5.append(":");
                    sb5.append(entry.getValue());
                    sb5.append(";");
                }
                a(arrayList, "valueMapOthers.txt", sb5.toString());
            }
        }
        return arrayList;
    }

    private static void a(ArrayList<cg> arrayList, String str, String str2) {
        if (str2 != null) {
            try {
                arrayList.add(new cg((byte) 1, str, str2.getBytes("utf-8")));
            } catch (Throwable th5) {
                av.b(th5);
            }
        }
    }

    private static void a(ArrayList<cg> arrayList, List<String> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        StringBuilder sb5 = new StringBuilder();
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            sb5.append(it.next());
        }
        try {
            arrayList.add(new cg((byte) 1, "martianlog.txt", sb5.toString().getBytes("utf-8")));
            av.c("attach pageTracingList", new Object[0]);
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    public static Map<String, String> a(CrashDetailBean crashDetailBean, ai aiVar, boolean z16) {
        HashMap hashMap = new HashMap(30);
        try {
            StringBuilder sb5 = new StringBuilder();
            sb5.append(crashDetailBean.K);
            hashMap.put("A9", sb5.toString());
            StringBuilder sb6 = new StringBuilder();
            sb6.append(crashDetailBean.L);
            hashMap.put("A11", sb6.toString());
            StringBuilder sb7 = new StringBuilder();
            sb7.append(crashDetailBean.M);
            hashMap.put("A10", sb7.toString());
            hashMap.put("A23", crashDetailBean.f97885k);
            StringBuilder sb8 = new StringBuilder();
            aiVar.getClass();
            hashMap.put("A7", sb8.toString());
            hashMap.put("A6", ai.o());
            hashMap.put("A5", aiVar.n());
            hashMap.put("A22", aiVar.h());
            StringBuilder sb9 = new StringBuilder();
            sb9.append(crashDetailBean.O);
            hashMap.put(NowProxyConstants.AccountInfoKey.A2, sb9.toString());
            StringBuilder sb10 = new StringBuilder();
            sb10.append(crashDetailBean.N);
            hashMap.put("A1", sb10.toString());
            hashMap.put("A24", aiVar.f98023k);
            StringBuilder sb11 = new StringBuilder();
            sb11.append(crashDetailBean.P);
            hashMap.put("A17", sb11.toString());
            hashMap.put("A25", aiVar.h());
            hashMap.put("A15", aiVar.r());
            StringBuilder sb12 = new StringBuilder();
            sb12.append(aiVar.s());
            hashMap.put("A13", sb12.toString());
            hashMap.put("A34", crashDetailBean.I);
            boolean z17 = true;
            if (z16) {
                int i3 = crashDetailBean.f97876b;
                if (i3 != 3 && i3 != 0 && i3 != 1) {
                    hashMap.put("crash_identify", UUID.randomUUID().toString());
                } else {
                    hashMap.put("crash_identify", crashDetailBean.f97878d);
                }
            }
            hashMap.put("productIdentify", crashDetailBean.f97886l);
            hashMap.put("A26", URLEncoder.encode(crashDetailBean.V, "utf-8"));
            if (crashDetailBean.f97876b == 1) {
                hashMap.put("A27", crashDetailBean.Y);
                hashMap.put("A28", crashDetailBean.X);
                StringBuilder sb13 = new StringBuilder();
                sb13.append(crashDetailBean.f97893s);
                hashMap.put("A29", sb13.toString());
            }
            hashMap.put("A30", crashDetailBean.Z);
            StringBuilder sb14 = new StringBuilder();
            sb14.append(crashDetailBean.f97860aa);
            hashMap.put("A18", sb14.toString());
            StringBuilder sb15 = new StringBuilder();
            if (crashDetailBean.f97861ab) {
                z17 = false;
            }
            sb15.append(z17);
            hashMap.put("A36", sb15.toString());
            StringBuilder sb16 = new StringBuilder();
            sb16.append(aiVar.H);
            hashMap.put("F02", sb16.toString());
            StringBuilder sb17 = new StringBuilder();
            sb17.append(aiVar.I);
            hashMap.put("F03", sb17.toString());
            hashMap.put("F04", aiVar.e());
            StringBuilder sb18 = new StringBuilder();
            sb18.append(aiVar.J);
            hashMap.put("F05", sb18.toString());
            hashMap.put("F06", aiVar.G);
            hashMap.put("F08", aiVar.M);
            hashMap.put("F09", aiVar.N);
            StringBuilder sb19 = new StringBuilder();
            sb19.append(aiVar.K);
            hashMap.put("F10", sb19.toString());
            a(hashMap, crashDetailBean);
        } catch (Exception e16) {
            e16.printStackTrace();
            av.a(e16);
        }
        return hashMap;
    }

    private static void a(Map<String, String> map, CrashDetailBean crashDetailBean) {
        if (crashDetailBean.f97864ae >= 0) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append(crashDetailBean.f97864ae);
            map.put("C01", sb5.toString());
        }
        if (crashDetailBean.f97865af >= 0) {
            StringBuilder sb6 = new StringBuilder();
            sb6.append(crashDetailBean.f97865af);
            map.put("C02", sb6.toString());
        }
        Map<String, String> map2 = crashDetailBean.f97866ag;
        if (map2 != null && map2.size() > 0) {
            for (Map.Entry<String, String> entry : crashDetailBean.f97866ag.entrySet()) {
                map.put("C03_" + entry.getKey(), entry.getValue());
            }
        }
        Map<String, String> map3 = crashDetailBean.f97867ah;
        if (map3 == null || map3.size() <= 0) {
            return;
        }
        for (Map.Entry<String, String> entry2 : crashDetailBean.f97867ah.entrySet()) {
            map.put("C04_" + entry2.getKey(), entry2.getValue());
        }
    }
}
