package com.tencent.luggage.wxa.qi;

import com.tencent.luggage.wxa.cp.v;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.mobileqq.app.face.FaceConstant;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class c {

    /* renamed from: a, reason: collision with root package name */
    public static final Long f138831a = 259200000L;

    /* renamed from: b, reason: collision with root package name */
    public static final Long f138832b = 86400000L;

    /* renamed from: c, reason: collision with root package name */
    public static final Long f138833c = 43200000L;

    /* renamed from: d, reason: collision with root package name */
    public static final Long f138834d = 240000L;

    /* renamed from: e, reason: collision with root package name */
    public static final Long f138835e = 60000L;

    /* renamed from: f, reason: collision with root package name */
    public static final Long f138836f = 86400000L;

    /* renamed from: g, reason: collision with root package name */
    public static long f138837g = 0;

    /* renamed from: h, reason: collision with root package name */
    public static List f138838h = new ArrayList(10);

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a implements Runnable {
        @Override // java.lang.Runnable
        public void run() {
            c.b();
        }
    }

    public static void b() {
        w.d("MicroMsg.Record.AudioRecordCacheClean", "clean audio record file");
        v vVar = new v(com.tencent.luggage.wxa.db.a.e(), "AudioRecord");
        if (vVar.e() && vVar.p()) {
            String[] t16 = vVar.t();
            if (t16 != null && t16.length != 0) {
                for (String str : t16) {
                    if (a(str)) {
                        w.d("MicroMsg.Record.AudioRecordCacheClean", "file is the block file, don't delete");
                    } else {
                        v vVar2 = new v(vVar + "/" + str);
                        if (!vVar2.e()) {
                            w.d("MicroMsg.Record.AudioRecordCacheClean", FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_IMAGE_NOT_EXIST);
                        } else if (vVar2.p()) {
                            w.d("MicroMsg.Record.AudioRecordCacheClean", "file is directory, don't delete");
                        } else if (System.currentTimeMillis() - vVar2.r() > f138831a.longValue()) {
                            w.b("MicroMsg.Record.AudioRecordCacheClean", "Clean 3 days file in record file name=%s, path:%s", vVar2.i(), vVar2.g());
                            vVar2.d();
                        } else {
                            w.d("MicroMsg.Record.AudioRecordCacheClean", "not delete the file, file is in valid time for 3 day");
                        }
                    }
                }
                return;
            }
            w.d("MicroMsg.Record.AudioRecordCacheClean", "none files exist");
            return;
        }
        w.d("MicroMsg.Record.AudioRecordCacheClean", "AudioRecord is not exist or not Directory");
    }

    public static void c() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - f138837g <= f138836f.longValue()) {
            w.b("MicroMsg.Record.AudioRecordCacheClean", "The last clean time is in AUDIO_RECORD_NO_SCAN_TIME time");
            return;
        }
        w.d("MicroMsg.Record.AudioRecordCacheClean", "start clean audio record file");
        f138837g = currentTimeMillis;
        com.tencent.luggage.wxa.co.a.a(new a(), "AudioRecordCacheClean");
    }

    public static void a(List list) {
        if (list != null && !list.isEmpty()) {
            f138838h.addAll(list);
        }
        c();
    }

    public static boolean a(String str) {
        Iterator it = f138838h.iterator();
        while (it.hasNext()) {
            if (str.contains((String) it.next())) {
                return true;
            }
        }
        return false;
    }
}
