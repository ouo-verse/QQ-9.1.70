package com.tencent.mobileqq.richmedia.dc;

import android.content.Context;
import android.os.Environment;
import com.tencent.common.app.AppInterface;
import com.tencent.commonsdk.util.notification.QQNotificationManager;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.filemanager.util.q;
import com.tencent.mobileqq.msf.core.c0.j;
import com.tencent.mobileqq.richmedia.dc.DataReport;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.statistics.i;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.videoplatform.QAReport;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.GroupMsgMask;
import java.io.File;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Locale;

/* compiled from: P */
/* loaded from: classes18.dex */
public class DCShortVideo extends com.tencent.mobileqq.richmedia.dc.b {

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.richmedia.dc.DCShortVideo$1, reason: invalid class name */
    /* loaded from: classes18.dex */
    class AnonymousClass1 implements Runnable {
        final /* synthetic */ String C;
        final /* synthetic */ boolean D;
        final /* synthetic */ int E;
        final /* synthetic */ String F;
        final /* synthetic */ boolean G;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f281496d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ QQAppInterface f281497e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ int f281498f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ int f281499h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ String f281500i;

        /* renamed from: m, reason: collision with root package name */
        final /* synthetic */ long f281501m;
        final /* synthetic */ DCShortVideo this$0;

        @Override // java.lang.Runnable
        public void run() {
            f fVar = new f();
            File file = new File(this.f281496d);
            if (!file.exists()) {
                return;
            }
            long length = file.length();
            fVar.f281544p = length;
            if (length <= 0) {
                return;
            }
            this.this$0.i(this.f281497e, this.f281498f, this.f281499h, this.f281500i, fVar);
            fVar.f281546r = this.f281501m;
            fVar.f281545q = this.C;
            try {
                String str = this.f281496d;
                String file2 = Environment.getExternalStorageDirectory().toString();
                if (file2 != null && this.f281496d.contains(file2)) {
                    str = this.f281496d.replace(file2, "");
                }
                int lastIndexOf = str.lastIndexOf("/");
                if (lastIndexOf != -1) {
                    str = str.substring(0, lastIndexOf);
                }
                fVar.f281536h = str.replace("/", "//");
                if (this.this$0.e(fVar, this.f281496d)) {
                    this.this$0.d(this.f281497e, fVar, this.D, this.E, this.F);
                    fVar.f281538j = this.G;
                    int currentTimeMillis = (int) ((System.currentTimeMillis() - new File(this.f281496d).lastModified()) / 60000);
                    fVar.f281542n = currentTimeMillis;
                    if (currentTimeMillis == 0) {
                        fVar.f281542n = 1;
                    }
                    if (QLog.isDevelopLevel()) {
                        QLog.d("DCShortVideo", 4, "[reportSend]url=" + fVar.f281536h + ",shortVideoType=" + fVar.f281533e + ",shortVideoSourceType = " + fVar.f281541m + ",uinType = " + fVar.f281529a + ",groupMemCount = " + fVar.f281530b + ",isForward = " + fVar.f281537i + ",isExsit = " + fVar.f281538j + ",age = " + fVar.f281531c + ",gender = " + fVar.f281532d + ",userType = " + fVar.f281543o + ",reprotHour = " + fVar.f281534f + ",fileInterval = " + fVar.f281542n + ",netType = " + fVar.f281535g + ",forwardSourceGroupMemCount = " + fVar.f281540l + ",forwardSourceUinType = " + fVar.f281539k + ",duration = " + fVar.f281546r + ",fileSize = " + fVar.f281544p + ",md5 = " + fVar.f281545q);
                    }
                    DataReport.a().b(new DataReport.ReportTask("ShortVideo.Send", fVar.a("ShortVideo.Send")));
                }
            } catch (Exception unused) {
            }
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.richmedia.dc.DCShortVideo$2, reason: invalid class name */
    /* loaded from: classes18.dex */
    class AnonymousClass2 implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ QQAppInterface f281502d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f281503e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ int f281504f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ String f281505h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ int f281506i;
        final /* synthetic */ DCShortVideo this$0;

        @Override // java.lang.Runnable
        public void run() {
            c cVar = new c();
            this.this$0.i(this.f281502d, this.f281503e, this.f281504f, this.f281505h, cVar);
            cVar.f281528h = this.f281506i;
            if (QLog.isDevelopLevel()) {
                QLog.d("DCShortVideo", 4, "[reportPreview]shortVideoType=" + cVar.f281533e + ",uinType = " + cVar.f281529a + ",groupMemCount = " + cVar.f281530b + ",age = " + cVar.f281531c + ",gender = " + cVar.f281532d + ",reprotHour = " + cVar.f281534f + ",netType = " + cVar.f281535g + ",playAction = " + cVar.f281528h);
            }
            DataReport.a().b(new DataReport.ReportTask("ShortVideo.Preview", cVar.a("ShortVideo.Preview")));
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.richmedia.dc.DCShortVideo$5, reason: invalid class name */
    /* loaded from: classes18.dex */
    class AnonymousClass5 implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f281517d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ boolean f281518e;
        final /* synthetic */ DCShortVideo this$0;

        @Override // java.lang.Runnable
        public void run() {
            h hVar = new h();
            hVar.f281556a = this.f281517d;
            hVar.f281557b = this.f281518e;
            DataReport.a().b(new DataReport.ReportTask("RealShortVideo.Record", hVar.a("RealShortVideo.Record")));
            if (QLog.isDevelopLevel()) {
                QLog.d("DCShortVideo", 4, "cameraID=" + hVar.f281556a + ",hasMultiSegments=" + hVar.f281557b);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f281525a;

        static {
            int[] iArr = new int[GroupMsgMask.values().length];
            f281525a = iArr;
            try {
                iArr[GroupMsgMask.NOTIFY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f281525a[GroupMsgMask.ASSISTANT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f281525a[GroupMsgMask.SHIELD.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f281525a[GroupMsgMask.RECEIVE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    static class b extends d {

        /* renamed from: h, reason: collision with root package name */
        long f281526h = 0;

        /* renamed from: i, reason: collision with root package name */
        long f281527i = -1;

        b() {
        }

        public HashMap<String, String> a(String str) {
            if ("ShortVideo.FullscreenPreview".equals(str)) {
                HashMap<String, String> hashMap = new HashMap<>();
                hashMap.put(QQNotificationManager.PARAM_UINTYPE, this.f281529a + "");
                hashMap.put("param_GroupMemberCount", this.f281530b + "");
                hashMap.put("param_age", this.f281531c + "");
                hashMap.put("param_gender", this.f281532d + "");
                hashMap.put("param_shortVideoType", this.f281533e + "");
                hashMap.put("param_duration", this.f281526h + "");
                hashMap.put("param_reportHour", this.f281534f + "");
                hashMap.put(j.I0, this.f281535g + "");
                hashMap.put("param_playTimeCost", this.f281527i + "");
                return hashMap;
            }
            return null;
        }
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    static class c extends d {

        /* renamed from: h, reason: collision with root package name */
        int f281528h = -1;

        c() {
        }

        public HashMap<String, String> a(String str) {
            if ("ShortVideo.Preview".equals(str)) {
                HashMap<String, String> hashMap = new HashMap<>();
                hashMap.put(QQNotificationManager.PARAM_UINTYPE, this.f281529a + "");
                hashMap.put("param_GroupMemberCount", this.f281530b + "");
                hashMap.put("param_age", this.f281531c + "");
                hashMap.put("param_gender", this.f281532d + "");
                hashMap.put("param_shortVideoType", this.f281533e + "");
                hashMap.put("param_reportHour", this.f281534f + "");
                hashMap.put(j.I0, this.f281535g + "");
                hashMap.put("param_playAction", this.f281528h + "");
                return hashMap;
            }
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public static abstract class d extends com.tencent.mobileqq.richmedia.dc.a {

        /* renamed from: a, reason: collision with root package name */
        public int f281529a = -1;

        /* renamed from: b, reason: collision with root package name */
        public int f281530b = 0;

        /* renamed from: c, reason: collision with root package name */
        int f281531c = -1;

        /* renamed from: d, reason: collision with root package name */
        int f281532d = -1;

        /* renamed from: e, reason: collision with root package name */
        int f281533e = -1;

        /* renamed from: f, reason: collision with root package name */
        int f281534f = -1;

        /* renamed from: g, reason: collision with root package name */
        int f281535g = -1;

        d() {
        }
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    static class e extends d {
        e() {
        }

        public HashMap<String, String> a(String str) {
            if ("ShortVideo.Save".equals(str)) {
                HashMap<String, String> hashMap = new HashMap<>();
                hashMap.put(QQNotificationManager.PARAM_UINTYPE, this.f281529a + "");
                hashMap.put("param_GroupMemberCount", this.f281530b + "");
                hashMap.put("param_age", this.f281531c + "");
                hashMap.put("param_gender", this.f281532d + "");
                hashMap.put("param_shortVideoType", this.f281533e + "");
                hashMap.put("param_reportHour", this.f281534f + "");
                hashMap.put(j.I0, this.f281535g + "");
                return hashMap;
            }
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public static class f extends d {

        /* renamed from: h, reason: collision with root package name */
        public String f281536h = "";

        /* renamed from: i, reason: collision with root package name */
        boolean f281537i = false;

        /* renamed from: j, reason: collision with root package name */
        boolean f281538j = false;

        /* renamed from: k, reason: collision with root package name */
        public int f281539k = -1;

        /* renamed from: l, reason: collision with root package name */
        public int f281540l = 0;

        /* renamed from: m, reason: collision with root package name */
        int f281541m = -1;

        /* renamed from: n, reason: collision with root package name */
        int f281542n = -1;

        /* renamed from: o, reason: collision with root package name */
        int f281543o = 1001;

        /* renamed from: p, reason: collision with root package name */
        long f281544p = 0;

        /* renamed from: q, reason: collision with root package name */
        String f281545q = "";

        /* renamed from: r, reason: collision with root package name */
        long f281546r = 0;

        f() {
        }

        public HashMap<String, String> a(String str) {
            if ("ShortVideo.Send".equals(str)) {
                HashMap<String, String> hashMap = new HashMap<>();
                hashMap.put("param_DetailUrl", this.f281536h);
                hashMap.put(QQNotificationManager.PARAM_UINTYPE, this.f281529a + "");
                hashMap.put("param_GroupMemberCount", this.f281530b + "");
                hashMap.put("param_isForward", this.f281537i + "");
                hashMap.put("param_isExist", this.f281538j + "");
                hashMap.put("param_forwardSourceUinType", this.f281539k + "");
                hashMap.put("param_forwardSourceGroupMemberCount", this.f281540l + "");
                hashMap.put("param_age", this.f281531c + "");
                hashMap.put("param_gender", this.f281532d + "");
                hashMap.put("param_userType", this.f281543o + "");
                hashMap.put("param_shortVideoType", this.f281533e + "");
                hashMap.put("param_shortVideoSourceType", this.f281541m + "");
                hashMap.put("param_reportHour", this.f281534f + "");
                hashMap.put("param_fileInterval", this.f281542n + "");
                hashMap.put(j.I0, this.f281535g + "");
                hashMap.put("param_md5", this.f281545q);
                hashMap.put(QAReport.REPORT_KEY_FILE_SIZE, this.f281544p + "");
                hashMap.put("param_duration", this.f281546r + "");
                return hashMap;
            }
            return null;
        }
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    static class g extends com.tencent.mobileqq.richmedia.dc.a {

        /* renamed from: a, reason: collision with root package name */
        boolean f281547a;

        /* renamed from: b, reason: collision with root package name */
        int f281548b;

        /* renamed from: c, reason: collision with root package name */
        int f281549c;

        /* renamed from: d, reason: collision with root package name */
        int f281550d;

        /* renamed from: e, reason: collision with root package name */
        int f281551e;

        /* renamed from: f, reason: collision with root package name */
        int f281552f;

        /* renamed from: g, reason: collision with root package name */
        int f281553g;

        /* renamed from: h, reason: collision with root package name */
        int f281554h;

        /* renamed from: i, reason: collision with root package name */
        long f281555i;

        g() {
        }

        public HashMap<String, String> a(String str) {
            if (StatisticCollector.STREAM_VIDEO_PLAY.equalsIgnoreCase(str)) {
                HashMap<String, String> hashMap = new HashMap<>();
                hashMap.put("StreamingVideoSupport", String.valueOf(this.f281547a));
                hashMap.put("FirstBufferTime", String.valueOf(this.f281548b));
                hashMap.put("PlayProgress", String.valueOf(this.f281549c));
                hashMap.put("LoadProgress", String.valueOf(this.f281550d));
                hashMap.put("FileDuration", String.valueOf(this.f281551e));
                hashMap.put("FileLen", String.valueOf(this.f281552f));
                hashMap.put("param_seekTimes", String.valueOf(this.f281553g));
                hashMap.put("PlayResult", String.valueOf(this.f281554h));
                hashMap.put("param_playTimeCost", String.valueOf(this.f281555i));
                return hashMap;
            }
            return null;
        }

        public String toString() {
            return "supportProgressive " + this.f281547a + "playReadyTime " + this.f281548b + "exitPlayProgress " + this.f281549c + "exitCacheProgress " + this.f281550d + "durationTime " + this.f281551e + "fileSize " + this.f281552f + "seekTimes " + this.f281553g + "playResult " + this.f281554h + "playTimeCost" + this.f281555i;
        }
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    static class h extends com.tencent.mobileqq.richmedia.dc.a {

        /* renamed from: a, reason: collision with root package name */
        int f281556a = 0;

        /* renamed from: b, reason: collision with root package name */
        boolean f281557b = false;

        h() {
        }

        public HashMap<String, String> a(String str) {
            if ("RealShortVideo.Record".equals(str)) {
                HashMap<String, String> hashMap = new HashMap<>();
                hashMap.put("param_cameraID", String.valueOf(this.f281556a));
                hashMap.put("param_hasMultiSegments", String.valueOf(this.f281557b));
                return hashMap;
            }
            return null;
        }
    }

    public DCShortVideo(Context context) {
        super(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(QQAppInterface qQAppInterface, f fVar, boolean z16, int i3, String str) {
        TroopInfo B;
        fVar.f281537i = z16;
        if (z16) {
            if (i3 == 0) {
                fVar.f281539k = 0;
                return;
            }
            if (i3 == 3000) {
                fVar.f281539k = 3000;
                return;
            }
            if (i3 == 1) {
                int i16 = a.f281525a[qQAppInterface.getTroopMask(str).ordinal()];
                if (i16 != 1) {
                    if (i16 != 2) {
                        if (i16 != 3) {
                            if (i16 != 4) {
                                fVar.f281539k = 1;
                            } else {
                                fVar.f281539k = 2;
                            }
                        } else {
                            fVar.f281539k = 4;
                        }
                    } else {
                        fVar.f281539k = 3;
                    }
                } else {
                    fVar.f281539k = 1;
                }
                fVar.f281540l = 0;
                TroopManager troopManager = (TroopManager) qQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
                if (troopManager != null && (B = troopManager.B(str)) != null) {
                    fVar.f281540l = B.wMemberNum;
                    return;
                }
                return;
            }
            fVar.f281539k = 9999;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean e(f fVar, String str) {
        String str2;
        File file = new File(str);
        String k3 = q.k(str);
        if (k3 != null) {
            k3 = k3.toLowerCase(Locale.US);
        }
        try {
            str2 = file.getParentFile().getName().toLowerCase(Locale.US);
        } catch (Exception unused) {
            str2 = null;
        }
        if (k3 != null && str2 != null) {
            if (k3.contains("/tencent/")) {
                if (k3.contains("/mobileqq/shortvideo/")) {
                    fVar.f281541m = 1002;
                    return true;
                }
                if (k3.contains("/qq_collection/")) {
                    fVar.f281541m = 1001;
                    return true;
                }
                if (k3.contains("/qqfile_recv/")) {
                    fVar.f281541m = 1003;
                    return true;
                }
                if (!k3.contains("/weixin/") && !k3.contains("/wechat/") && !k3.contains("/micromsg/")) {
                    if (i.a(k3)) {
                        fVar.f281541m = 1005;
                        return true;
                    }
                    fVar.f281541m = 1006;
                    return true;
                }
                fVar.f281541m = 1004;
                return true;
            }
            if (k3.equalsIgnoreCase(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_MOVIES).getAbsolutePath() + File.separator)) {
                fVar.f281541m = 1002;
                return true;
            }
            if (!str2.contains("camera") && !str2.equals("dcim") && !str2.equals("100MEDIA") && !str2.equals("100ANDRO") && !str2.contains(HardCodeUtil.qqStr(R.string.f171838lb3)) && !str2.contains(HardCodeUtil.qqStr(R.string.f171837lb2)) && !str2.contains(HardCodeUtil.qqStr(R.string.f171839lb4))) {
                if (i.a(k3)) {
                    fVar.f281541m = 1005;
                    return true;
                }
                fVar.f281541m = 1006;
                return true;
            }
            fVar.f281541m = 1007;
            return true;
        }
        return false;
    }

    public void f(final AppInterface appInterface, final int i3, final int i16, final int i17, final String str, final long j3) {
        if (appInterface != null) {
            if (i3 == 2001 || i3 == 2002 || i3 == 2003) {
                ThreadManager.getSubThreadHandler().post(new Runnable() { // from class: com.tencent.mobileqq.richmedia.dc.DCShortVideo.3
                    @Override // java.lang.Runnable
                    public void run() {
                        b bVar = new b();
                        DCShortVideo.this.i(appInterface, i3, i17, str, bVar);
                        bVar.f281526h = i16;
                        bVar.f281527i = j3;
                        if (QLog.isDevelopLevel()) {
                            QLog.d("DCShortVideo", 4, "[reportFullscreenPreview]shortVideoType=" + bVar.f281533e + ", duration=" + bVar.f281526h + ",uinType = " + bVar.f281529a + ",groupMemCount = " + bVar.f281530b + ",age = " + bVar.f281531c + ",gender = " + bVar.f281532d + ",reprotHour = " + bVar.f281534f + ",netType = " + bVar.f281535g + ",playTimeCost = " + bVar.f281527i);
                        }
                        DataReport.a().b(new DataReport.ReportTask("ShortVideo.FullscreenPreview", bVar.a("ShortVideo.FullscreenPreview")));
                    }
                });
            }
        }
    }

    public void g(final boolean z16, final int i3, final int i16, final int i17, final int i18, final int i19, int i26, final int i27, final int i28, final long j3) {
        ThreadManager.getSubThreadHandler().post(new Runnable() { // from class: com.tencent.mobileqq.richmedia.dc.DCShortVideo.6
            @Override // java.lang.Runnable
            public void run() {
                g gVar = new g();
                gVar.f281547a = z16;
                gVar.f281548b = i3;
                gVar.f281549c = i16;
                gVar.f281550d = i17;
                gVar.f281551e = i18;
                gVar.f281552f = i19;
                gVar.f281553g = i27;
                gVar.f281554h = i28;
                gVar.f281555i = j3;
                DataReport.a().b(new DataReport.ReportTask(StatisticCollector.STREAM_VIDEO_PLAY, gVar.a(StatisticCollector.STREAM_VIDEO_PLAY)));
                if (QLog.isColorLevel()) {
                    QLog.d("DCShortVideo", 2, "reportProgressivePlayData():" + gVar.toString());
                }
            }
        });
    }

    public void h(final AppInterface appInterface, final int i3, final int i16, final String str) {
        if (appInterface != null) {
            if (i3 == 2001 || i3 == 2002 || i3 == 2003) {
                ThreadManager.getSubThreadHandler().post(new Runnable() { // from class: com.tencent.mobileqq.richmedia.dc.DCShortVideo.4
                    @Override // java.lang.Runnable
                    public void run() {
                        e eVar = new e();
                        DCShortVideo.this.i(appInterface, i3, i16, str, eVar);
                        if (QLog.isDevelopLevel()) {
                            QLog.d("DCShortVideo", 4, "[reportSave]shortVideoType=" + eVar.f281533e + ",uinType = " + eVar.f281529a + ",groupMemCount = " + eVar.f281530b + ",age = " + eVar.f281531c + ",gender = " + eVar.f281532d + ",reprotHour = " + eVar.f281534f + ",netType = " + eVar.f281535g);
                        }
                        DataReport.a().b(new DataReport.ReportTask("ShortVideo.Save", eVar.a("ShortVideo.Save")));
                    }
                });
            }
        }
    }

    void i(AppInterface appInterface, int i3, int i16, String str, d dVar) {
        TroopInfo B;
        dVar.f281533e = i3;
        if (i16 == 0) {
            dVar.f281529a = 0;
        } else if (i16 == 3000) {
            dVar.f281529a = 3000;
        } else if (i16 == 1) {
            if (appInterface instanceof QQAppInterface) {
                int i17 = a.f281525a[((QQAppInterface) appInterface).getTroopMask(str).ordinal()];
                if (i17 != 1) {
                    if (i17 != 2) {
                        if (i17 != 3) {
                            if (i17 != 4) {
                                dVar.f281529a = 1;
                            } else {
                                dVar.f281529a = 2;
                            }
                        } else {
                            dVar.f281529a = 4;
                        }
                    } else {
                        dVar.f281529a = 3;
                    }
                } else {
                    dVar.f281529a = 1;
                }
            } else {
                dVar.f281529a = 1;
            }
            dVar.f281530b = 0;
            TroopManager troopManager = (TroopManager) appInterface.getManager(QQManagerFactory.TROOP_MANAGER);
            if (troopManager != null && (B = troopManager.B(str)) != null) {
                dVar.f281530b = B.wMemberNum;
            }
        } else {
            dVar.f281529a = 9999;
        }
        com.tencent.mobileqq.nearby.b bVar = (com.tencent.mobileqq.nearby.b) appInterface.getManager(QQManagerFactory.NEARBY_CARD_MANAGER);
        if (bVar != null) {
            dVar.f281531c = bVar.b();
            dVar.f281532d = bVar.getSelfGender();
        }
        dVar.f281534f = Calendar.getInstance().get(11);
        dVar.f281535g = NetworkUtil.getSystemNetwork(BaseApplication.getContext());
    }
}
