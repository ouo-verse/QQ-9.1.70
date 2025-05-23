package com.tencent.bugly.proguard;

import android.content.ContentValues;
import android.database.Cursor;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Pair;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

/* compiled from: P */
/* loaded from: classes5.dex */
public final class ao {

    /* renamed from: a, reason: collision with root package name */
    private final SimpleDateFormat f98055a;

    /* renamed from: b, reason: collision with root package name */
    private final al f98056b;

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private static final ao f98059a = new ao(0);

        public static /* synthetic */ ao a() {
            return f98059a;
        }
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        String f98060a;

        /* renamed from: b, reason: collision with root package name */
        public long f98061b;

        /* renamed from: c, reason: collision with root package name */
        public String f98062c;

        public final String toString() {
            return "SLAData{uuid='" + this.f98060a + "', time=" + this.f98061b + ", data='" + this.f98062c + "'}";
        }
    }

    /* synthetic */ ao(byte b16) {
        this();
    }

    static void c(List<b> list) {
        if (list != null && !list.isEmpty()) {
            av.c("sla batch report list size:%s", Integer.valueOf(list.size()));
            if (list.size() > 30) {
                list = list.subList(0, 29);
            }
            ArrayList arrayList = new ArrayList();
            Iterator<b> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(it.next().f98062c);
            }
            Pair<Integer, String> a16 = al.a(arrayList);
            av.c("sla batch report result, rspCode:%s rspMsg:%s", a16.first, a16.second);
            if (((Integer) a16.first).intValue() == 200) {
                d(list);
                return;
            }
            return;
        }
        av.c("sla batch report data is empty", new Object[0]);
    }

    public static void d(List<b> list) {
        if (list != null && !list.isEmpty()) {
            av.c("sla batch delete list size:%s", Integer.valueOf(list.size()));
            try {
                String str = "_id in (" + a(",", list) + ")";
                av.c("sla batch delete where:%s", str);
                ae.a().a("t_sla", str, (String[]) null);
                return;
            } catch (Throwable th5) {
                av.b(th5);
                return;
            }
        }
        av.c("sla batch delete list is null", new Object[0]);
    }

    private static void e(List<b> list) {
        for (b bVar : list) {
            av.c("sla save id:%s time:%s msg:%s", bVar.f98060a, Long.valueOf(bVar.f98061b), bVar.f98062c);
            try {
                ContentValues contentValues = new ContentValues();
                contentValues.put("_id", bVar.f98060a);
                contentValues.put("_tm", Long.valueOf(bVar.f98061b));
                contentValues.put("_dt", bVar.f98062c);
                ae.a().a("t_sla", contentValues, (ad) null);
            } catch (Throwable th5) {
                av.b(th5);
            }
        }
    }

    public final void a(List<c> list) {
        if (list != null && !list.isEmpty()) {
            av.c("sla batch report event size:%s", Integer.valueOf(list.size()));
            ArrayList arrayList = new ArrayList();
            Iterator<c> it = list.iterator();
            while (it.hasNext()) {
                b b16 = b(it.next());
                if (b16 != null) {
                    arrayList.add(b16);
                }
            }
            e(arrayList);
            b(arrayList);
            return;
        }
        av.d("sla batch report event is null", new Object[0]);
    }

    public final void b(final List<b> list) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            at.a().a(new Runnable() { // from class: com.tencent.bugly.proguard.ao.1
                @Override // java.lang.Runnable
                public final void run() {
                    ao.c((List<b>) list);
                }
            });
        } else {
            c(list);
        }
    }

    ao() {
        this.f98055a = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS", Locale.US);
        this.f98056b = new al();
    }

    private void b(String str) {
        ai c16 = ai.c();
        String str2 = "&app_version=" + c16.f98032t + "&app_name=" + c16.f98034v + "&app_bundle_id=" + c16.f98015c + "&client_type=android&user_id=" + c16.g() + "&sdk_version=" + c16.f98020h + "&event_time=" + this.f98055a.format(new Date(System.currentTimeMillis())) + "&device_id=" + c16.h() + "&debug=" + (c16.L ? 1 : 0) + "&event_code=BuglyCrashCatchInvalid&param_0=" + str;
        ArrayList arrayList = new ArrayList();
        arrayList.add(str2);
        Pair<Integer, String> a16 = al.a(arrayList);
        av.c("Report an invalid crash processing record, rspCode:%s rspMsg:%s", a16.first, a16.second);
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public static class c {

        /* renamed from: a, reason: collision with root package name */
        String f98063a;

        /* renamed from: b, reason: collision with root package name */
        String f98064b;

        /* renamed from: c, reason: collision with root package name */
        long f98065c;

        /* renamed from: d, reason: collision with root package name */
        boolean f98066d;

        /* renamed from: e, reason: collision with root package name */
        long f98067e;

        /* renamed from: f, reason: collision with root package name */
        String f98068f;

        /* renamed from: g, reason: collision with root package name */
        String f98069g;

        public c(String str, String str2, long j3, boolean z16, long j16, String str3, String str4) {
            this.f98063a = str;
            this.f98064b = str2;
            this.f98065c = j3;
            this.f98066d = z16;
            this.f98067e = j16;
            this.f98068f = str3;
            this.f98069g = str4;
        }

        public c() {
        }
    }

    public final void a(String str) {
        av.a("Crash processing record dir path: %s", str);
        ArrayList arrayList = new ArrayList();
        File[] listFiles = new File(str).listFiles();
        if (listFiles.length > 0) {
            for (File file : listFiles) {
                if (file.isFile() && file.exists()) {
                    av.a("Crash processing record file exist, path: %s", file.toString());
                    ArrayList arrayList2 = new ArrayList();
                    try {
                        InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(file));
                        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                        while (true) {
                            String readLine = bufferedReader.readLine();
                            if (readLine == null) {
                                break;
                            } else {
                                arrayList2.add(readLine);
                            }
                        }
                        bufferedReader.close();
                        inputStreamReader.close();
                    } catch (FileNotFoundException e16) {
                        e16.printStackTrace();
                    } catch (IOException e17) {
                        e17.printStackTrace();
                    }
                    Iterator it = arrayList2.iterator();
                    while (it.hasNext()) {
                        b c16 = c((String) it.next());
                        if (c16 != null) {
                            arrayList.add(c16);
                        }
                    }
                    file.delete();
                    av.a("Delete crash processing record file: %s", file.toString());
                }
            }
        }
        if (arrayList.isEmpty()) {
            return;
        }
        e(arrayList);
        av.a("Success save crash processing info.", new Object[0]);
    }

    private b b(c cVar) {
        if (cVar != null && !TextUtils.isEmpty(cVar.f98064b)) {
            ai c16 = ai.c();
            if (c16 == null) {
                av.d("sla convert failed because ComInfoManager is null", new Object[0]);
                return null;
            }
            StringBuilder sb5 = new StringBuilder("&app_version=");
            sb5.append(c16.f98032t);
            sb5.append("&app_name=");
            sb5.append(c16.f98034v);
            sb5.append("&app_bundle_id=");
            sb5.append(c16.f98015c);
            sb5.append("&client_type=android&user_id=");
            sb5.append(c16.g());
            sb5.append("&sdk_version=");
            sb5.append(c16.f98020h);
            sb5.append("&event_code=");
            sb5.append(cVar.f98064b);
            sb5.append("&event_result=");
            sb5.append(cVar.f98066d ? 1 : 0);
            sb5.append("&event_time=");
            sb5.append(this.f98055a.format(new Date(cVar.f98065c)));
            sb5.append("&event_cost=");
            sb5.append(cVar.f98067e);
            sb5.append("&device_id=");
            sb5.append(c16.h());
            sb5.append("&debug=");
            sb5.append(c16.L ? 1 : 0);
            sb5.append("&param_0=");
            sb5.append(cVar.f98068f);
            sb5.append("&param_1=");
            sb5.append(cVar.f98063a);
            sb5.append("&param_2=");
            sb5.append(c16.T ? "rqd" : "ext");
            sb5.append("&param_4=");
            sb5.append(c16.f());
            String sb6 = sb5.toString();
            if (!TextUtils.isEmpty(cVar.f98069g)) {
                sb6 = sb6 + "&param_3=" + cVar.f98069g;
            }
            av.c("sla convert eventId:%s eventType:%s, eventTime:%s success:%s cost:%s from:%s uploadMsg:", cVar.f98063a, cVar.f98064b, Long.valueOf(cVar.f98065c), Boolean.valueOf(cVar.f98066d), Long.valueOf(cVar.f98067e), cVar.f98068f, cVar.f98069g);
            String str = cVar.f98063a + "-" + cVar.f98064b;
            b bVar = new b();
            bVar.f98060a = str;
            bVar.f98061b = cVar.f98065c;
            bVar.f98062c = sb6;
            return bVar;
        }
        av.d("sla convert event is null", new Object[0]);
        return null;
    }

    private b c(String str) {
        String[] split = str.split("\t");
        if (split.length != 13) {
            av.e("Not a valid crash processing record!", new Object[0]);
            b(str);
            return null;
        }
        if (split[0].length() == 1 && Character.isDigit(split[0].charAt(0)) && split[1].length() == 1 && Character.isDigit(split[1].charAt(0))) {
            ai c16 = ai.c();
            long currentTimeMillis = System.currentTimeMillis();
            b bVar = new b();
            try {
                StringBuilder sb5 = new StringBuilder("&app_version=");
                sb5.append(c16.f98032t);
                sb5.append("&app_name=");
                sb5.append(c16.f98034v);
                sb5.append("&app_bundle_id=");
                sb5.append(c16.f98015c);
                sb5.append("&client_type=android&user_id=");
                sb5.append(c16.g());
                sb5.append("&sdk_version=");
                sb5.append(c16.f98020h);
                sb5.append("&event_time=");
                sb5.append(this.f98055a.format(new Date(currentTimeMillis)));
                sb5.append("&device_id=");
                sb5.append(c16.h());
                sb5.append("&debug=");
                sb5.append(c16.L ? 1 : 0);
                sb5.append("&event_code=BuglyCrashCatchEvent&cpu_arch=");
                sb5.append(c16.n());
                sb5.append("&param_0=");
                sb5.append(split[0]);
                sb5.append("&event_result=");
                sb5.append(split[1]);
                sb5.append("&error_code=");
                sb5.append(split[2]);
                sb5.append("&param_7=");
                sb5.append(split[3]);
                sb5.append("&param_2=");
                sb5.append(split[4]);
                sb5.append("&param_1=");
                sb5.append(split[5]);
                sb5.append("&param_3=");
                sb5.append(split[6]);
                sb5.append("&param_4=");
                sb5.append(split[7]);
                sb5.append("&param_5=");
                sb5.append(split[8]);
                sb5.append("&param_6=");
                sb5.append(split[9]);
                sb5.append("&param_10=");
                sb5.append(split[10]);
                sb5.append("&use_time=");
                sb5.append(split[11]);
                sb5.append("&app_foreground=");
                sb5.append(split[12]);
                String sb6 = sb5.toString();
                av.c("Processing record: %s", sb6);
                bVar.f98060a = split[2];
                bVar.f98061b = currentTimeMillis;
                bVar.f98062c = sb6;
                return bVar;
            } catch (Throwable th5) {
                av.c("Crash processing record is invalid!".concat(String.valueOf(th5)), new Object[0]);
                b(str);
                return null;
            }
        }
        av.e("Not a valid crash processing record!", new Object[0]);
        b(str);
        return null;
    }

    private static String a(String str, Iterable<b> iterable) {
        Iterator<b> it = iterable.iterator();
        if (!it.hasNext()) {
            return "";
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append("'");
        sb5.append(it.next().f98060a);
        sb5.append("'");
        while (it.hasNext()) {
            sb5.append(str);
            sb5.append("'");
            sb5.append(it.next().f98060a);
            sb5.append("'");
        }
        return sb5.toString();
    }

    public static List<b> a() {
        Cursor a16 = ae.a().a(false, "t_sla", new String[]{"_id", "_tm", "_dt"}, null, null, null, "_tm", "30");
        if (a16 == null) {
            return null;
        }
        if (a16.getCount() <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        while (a16.moveToNext()) {
            try {
                b bVar = new b();
                bVar.f98060a = a16.getString(a16.getColumnIndex("_id"));
                bVar.f98061b = a16.getLong(a16.getColumnIndex("_tm"));
                bVar.f98062c = a16.getString(a16.getColumnIndex("_dt"));
                av.c(bVar.toString(), new Object[0]);
                arrayList.add(bVar);
            } finally {
                try {
                    return arrayList;
                } finally {
                }
            }
        }
        return arrayList;
    }

    public final void a(c cVar) {
        if (TextUtils.isEmpty(cVar.f98064b)) {
            av.d("sla report event is null", new Object[0]);
        } else {
            av.c("sla report single event", new Object[0]);
            a(Collections.singletonList(cVar));
        }
    }
}
