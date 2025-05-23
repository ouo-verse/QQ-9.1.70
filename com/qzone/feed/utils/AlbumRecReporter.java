package com.qzone.feed.utils;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;
import com.qzone.common.event.Event;
import com.qzone.common.event.EventCenter;
import com.qzone.common.event.IObserver;
import com.qzone.widget.AlbumRecDirector;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import common.config.service.QzoneConfig;
import cooperation.qzone.report.datong.QZoneDTLoginReporter;
import cooperation.qzone.thread.QzoneHandlerThreadFactory;
import cooperation.qzone.util.QZLog;
import java.lang.reflect.Type;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import okhttp3.HttpUrl;

/* compiled from: P */
/* loaded from: classes39.dex */
public class AlbumRecReporter implements IObserver.background {
    public static final AlbumRecReporter D = new AlbumRecReporter();
    private static final long E = TimeUnit.DAYS.toMillis(1);
    private volatile long C;

    /* renamed from: d, reason: collision with root package name */
    private final Gson f47412d;

    /* renamed from: e, reason: collision with root package name */
    private final SharedPreferences f47413e;

    /* renamed from: f, reason: collision with root package name */
    private final Map<String, c> f47414f;

    /* renamed from: h, reason: collision with root package name */
    private final Map<String, c> f47415h;

    /* renamed from: i, reason: collision with root package name */
    private final Set<String> f47416i;

    /* renamed from: m, reason: collision with root package name */
    private long f47417m;

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class a extends TypeToken<HashMap<String, c>> {
        a() {
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class b extends TypeToken<HashSet<String>> {
        b() {
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    public static class c {

        /* renamed from: a, reason: collision with root package name */
        public static final c f47420a = new c(null, null, null, null, null, null, null, null, Collections.emptyList(), 0, 0, 0, 0, -26215, "");

        @SerializedName(DomainData.DOMAIN_NAME)
        public final int btnColor;

        @SerializedName("f")
        public final String btnText;

        @SerializedName("c")
        public final String content;

        @SerializedName("k")
        public final long duration;

        @SerializedName(tl.h.F)
        public final String emptyPicSchema;

        @SerializedName("a")
        public final String iconUrl;

        @SerializedName("e")
        public final String picContent;

        @SerializedName("d")
        public final String picTitle;

        @SerializedName("i")
        public final List<String> picUrls;

        @SerializedName(QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO)
        public final int reportResClick;

        @SerializedName("l")
        public final int reportResExpose;

        @SerializedName("g")
        public final String schema;

        @SerializedName("j")
        public final long startTime;

        @SerializedName("b")
        public final String title;

        @SerializedName("o")
        public final String type;

        public c(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, List<String> list, long j3, long j16, int i3, int i16, int i17, String str9) {
            this.iconUrl = str;
            this.title = str2;
            this.content = str3;
            this.picTitle = str4;
            this.picContent = str5;
            this.btnText = str6;
            this.schema = str7;
            this.emptyPicSchema = str8;
            this.picUrls = list;
            this.startTime = j3;
            this.duration = j16;
            this.reportResExpose = i3;
            this.reportResClick = i16;
            this.btnColor = i17;
            this.type = str9;
        }
    }

    AlbumRecReporter() {
        Map<String, c> hashMap;
        Map<String, c> hashMap2;
        Set<String> hashSet;
        Gson gson = new Gson();
        this.f47412d = gson;
        this.C = E;
        SharedPreferences sharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences("qzone_album_rec_feed", 0);
        this.f47413e = sharedPreferences;
        EventCenter.getInstance().addObserver(this, 3, "QzoneAlbum", 32);
        String string = sharedPreferences.getString("expose_info_map", "{}");
        String string2 = sharedPreferences.getString("prepare_info_map", "{}");
        String string3 = sharedPreferences.getString("info_expose_type_set", HttpUrl.PATH_SEGMENT_ENCODE_SET_URI);
        synchronized (this) {
            this.f47417m = sharedPreferences.getLong("last_expose_time", 0L);
            Type type = new a().getType();
            try {
                hashMap = (Map) gson.fromJson(string, type);
            } catch (Throwable th5) {
                QZLog.w("AlbumRecReporter", "AlbumRecReporter: failed to parse expose info", th5);
                hashMap = new HashMap<>();
            }
            this.f47414f = hashMap;
            try {
                hashMap2 = (Map) this.f47412d.fromJson(string2, type);
            } catch (Throwable th6) {
                QZLog.w("AlbumRecReporter", "AlbumRecReporter: failed to parse prepare info", th6);
                hashMap2 = new HashMap<>();
            }
            this.f47415h = hashMap2;
            try {
                hashSet = (Set) this.f47412d.fromJson(string3, new b().getType());
            } catch (Throwable th7) {
                QZLog.w("AlbumRecReporter", "AlbumRecReporter: failed to parse expose type set", th7);
                hashSet = new HashSet<>();
            }
            this.f47416i = hashSet;
            QZLog.i("AlbumRecReporter", "AlbumRecReporter: expose->" + this.f47414f.size() + ";prepare->" + this.f47415h.size() + ";" + this.f47417m + ";" + hashSet.size());
        }
        QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.RealTimeThread).post(new Runnable() { // from class: com.qzone.feed.utils.AlbumRecReporter.3
            @Override // java.lang.Runnable
            public void run() {
                AlbumRecReporter.this.C = QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.SECONDARY_ALBUM_REC_FEED_EXPOSE_PERIOD, AlbumRecReporter.E);
                AlbumRecDirector.k();
            }
        });
    }

    public c c(String str) {
        c cVar;
        synchronized (this) {
            cVar = this.f47414f.get(str);
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append("getExposeAlbumRecInfo: ");
        sb5.append(str);
        sb5.append(" ");
        sb5.append(cVar != null);
        QZLog.i("AlbumRecReporter", sb5.toString());
        return cVar;
    }

    public Set<String> d() {
        HashSet hashSet = new HashSet();
        synchronized (this) {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.f47417m < this.C) {
                QZLog.i("AlbumRecReporter", "hasPrepareAlbumRecInfoAndSetExposed: no expose info too often");
                return hashSet;
            }
            for (Map.Entry<String, c> entry : this.f47415h.entrySet()) {
                c value = entry.getValue();
                if (e(value, currentTimeMillis)) {
                    String key = entry.getKey();
                    QZLog.i("AlbumRecReporter", "hasPrepareAlbumRecInfoAndSetExposed: expose new info " + key);
                    this.f47414f.put(key, value);
                    hashSet.add(key);
                    this.f47416i.remove(key);
                }
            }
            if (hashSet.size() > 0) {
                Iterator it = hashSet.iterator();
                while (it.hasNext()) {
                    this.f47415h.remove((String) it.next());
                }
                this.f47413e.edit().putString("expose_info_map", this.f47412d.toJson(this.f47414f)).putString("prepare_info_map", this.f47412d.toJson(this.f47415h)).putString("info_expose_type_set", this.f47412d.toJson(this.f47416i)).apply();
            }
            for (Map.Entry<String, c> entry2 : this.f47414f.entrySet()) {
                String key2 = entry2.getKey();
                c value2 = entry2.getValue();
                if (!hashSet.contains(key2) && !this.f47416i.contains(key2) && e(value2, currentTimeMillis)) {
                    QZLog.i("AlbumRecReporter", "hasPrepareAlbumRecInfoAndSetExposed: expose old info " + key2);
                    hashSet.add(key2);
                }
            }
            if (hashSet.isEmpty()) {
                QZLog.i("AlbumRecReporter", "hasPrepareAlbumRecInfoAndSetExposed: no expose info " + this.f47415h.size() + " " + this.f47414f.size() + " " + this.f47416i.size());
            }
            return hashSet;
        }
    }

    public void f(String str) {
        if (TextUtils.isEmpty(str)) {
            QZLog.i("AlbumRecReporter", "onExpose: on expose empty type");
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        QZLog.i("AlbumRecReporter", "onExpose: on expose " + str + " " + currentTimeMillis);
        synchronized (this) {
            this.f47416i.add(str);
            this.f47417m = currentTimeMillis;
            this.f47413e.edit().putLong("last_expose_time", currentTimeMillis).putString("info_expose_type_set", this.f47412d.toJson(this.f47416i)).apply();
        }
    }

    private static boolean e(c cVar, long j3) {
        if (cVar != null) {
            long j16 = cVar.startTime;
            if (j3 > j16 && j3 < j16 + cVar.duration) {
                return true;
            }
        }
        return false;
    }

    @Override // com.qzone.common.event.IObserver.background
    public void onEventBackgroundThread(Event event) {
        c cVar;
        String str;
        String str2;
        long parseLong;
        long parseLong2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        String str9;
        int parseInt;
        int parseInt2;
        if ("QzoneAlbum".equals(event.source.getName()) && event.what == 32) {
            Object obj = event.params;
            if (obj instanceof Map) {
                Map map = (Map) obj;
                try {
                    str = (String) map.get(QZoneDTLoginReporter.SCHEMA);
                    str2 = (String) map.get(v4.b.UNIKEY);
                    parseLong = Long.parseLong((String) map.get("begintime"));
                    parseLong2 = Long.parseLong((String) map.get("duration"));
                    str3 = (String) map.get("icon");
                    str4 = (String) map.get("icontext");
                    str5 = (String) map.get("title");
                    str6 = (String) map.get("summary");
                    str7 = (String) map.get("subsummary");
                    str8 = (String) map.get("buttontext");
                    str9 = (String) map.get("schema_backup");
                    parseInt = Integer.parseInt((String) map.get("report_reserves_expose"));
                    parseInt2 = Integer.parseInt((String) map.get("report_reserves_click"));
                } catch (Throwable th5) {
                    QZLog.w("AlbumRecReporter", "onEventBackgroundThread: ", th5);
                    cVar = null;
                }
                if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                    String str10 = (String) map.get("buttoncolor");
                    int parseInt3 = TextUtils.isEmpty(str10) ? -26215 : Integer.parseInt(str10);
                    String str11 = (String) map.get("type");
                    if (TextUtils.isEmpty(str11)) {
                        QZLog.i("AlbumRecReporter", "onEventBackgroundThread: empty type");
                        return;
                    }
                    cVar = new c(str3, str4, str5, str6, str7, str8, str, str9, Collections.emptyList(), parseLong, parseLong2, parseInt, parseInt2, parseInt3, str11);
                    if (cVar == null) {
                        return;
                    }
                    synchronized (this) {
                        this.f47415h.put(cVar.type, cVar);
                        String json = this.f47412d.toJson(this.f47415h);
                        QZLog.i("AlbumRecReporter", "onEventBackgroundThread: get new info " + json);
                        this.f47413e.edit().putString("prepare_info_map", json).apply();
                    }
                    return;
                }
                QZLog.i("AlbumRecReporter", "onEventBackgroundThread: empty schema or key");
            }
        }
    }
}
