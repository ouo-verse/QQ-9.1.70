package com.tencent.luggage.scanner.qbar;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Point;
import androidx.annotation.Nullable;
import com.tencent.luggage.scanner.camera.ScanUtil;
import com.tencent.luggage.wxa.b4.b;
import com.tencent.luggage.wxa.tn.d;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.tn.z;
import com.tencent.qbar.QBar;
import com.tencent.qbar.QbarNative;
import com.tencent.thread.monitor.plugin.proxy.ProxyExecutors;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ExecutorService;

/* compiled from: P */
/* loaded from: classes2.dex */
public class LuggageFileDecodeQueue {

    /* renamed from: g, reason: collision with root package name */
    public static LuggageFileDecodeQueue f120034g = new LuggageFileDecodeQueue();

    /* renamed from: a, reason: collision with root package name */
    public Map f120035a = new HashMap();

    /* renamed from: b, reason: collision with root package name */
    public Map f120036b = new HashMap();

    /* renamed from: c, reason: collision with root package name */
    public Map f120037c = new HashMap();

    /* renamed from: d, reason: collision with root package name */
    public final Object f120038d = new Object();

    /* renamed from: e, reason: collision with root package name */
    public final com.tencent.luggage.wxa.b4.a f120039e = new com.tencent.luggage.wxa.b4.a("LuggageFileDecodeQueue");

    /* renamed from: f, reason: collision with root package name */
    public final ExecutorService f120040f = ProxyExecutors.newSingleThreadExecutor();

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public interface FileDecodeCallBack {
        void afterDecode(long j3, @Nullable List<QBar.QBarResult> list, @Nullable List<QbarNative.QBarReportMsg> list2);
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public String f120041a;

        /* renamed from: b, reason: collision with root package name */
        public QbarNative.QbarAiModelParam f120042b;

        /* renamed from: c, reason: collision with root package name */
        public int[] f120043c;

        public a(String str, QbarNative.QbarAiModelParam qbarAiModelParam, int[] iArr) {
            this.f120043c = new int[]{1, 2, 4, 5};
            this.f120041a = str;
            this.f120042b = qbarAiModelParam;
            if (iArr != null && iArr.length > 0) {
                this.f120043c = iArr;
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            Bitmap bitmap;
            List list;
            int size;
            List list2 = null;
            try {
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inJustDecodeBounds = true;
                d.a(this.f120041a, options);
                BitmapFactory.Options options2 = new BitmapFactory.Options();
                int i3 = options.outWidth;
                if (options.outHeight * i3 * 3 > 10485760) {
                    w.d("LuggageFileDecodeQueue", "bitmap too large %d x %d, sample", Integer.valueOf(i3), Integer.valueOf(options.outHeight));
                    options2.inSampleSize = 2;
                }
                bitmap = d.a(this.f120041a, options2);
            } catch (Exception e16) {
                w.b("LuggageFileDecodeQueue", "decode file to bitmap error! " + e16.getMessage());
                bitmap = null;
            }
            synchronized (LuggageFileDecodeQueue.this.f120039e) {
                System.currentTimeMillis();
                if (!LuggageFileDecodeQueue.this.f120039e.b()) {
                    LuggageFileDecodeQueue.this.f120039e.a(1, this.f120042b);
                }
                if (LuggageFileDecodeQueue.this.f120039e.b()) {
                    LuggageFileDecodeQueue.this.f120039e.a(this.f120043c);
                }
                if (bitmap != null) {
                    if (b.f121841a.contains(z.h()) && bitmap.getWidth() * bitmap.getHeight() * 4 > 104857600) {
                        w.b("LuggageFileDecodeQueue", "bitmap data over malloc limit, width: %d, height: %d, return", Integer.valueOf(bitmap.getWidth()), Integer.valueOf(bitmap.getHeight()));
                        list = null;
                    } else {
                        w.d("LuggageFileDecodeQueue", "width: %d, height: %d", Integer.valueOf(bitmap.getWidth()), Integer.valueOf(bitmap.getHeight()));
                        int[] iArr = new int[bitmap.getWidth() * bitmap.getHeight()];
                        bitmap.getPixels(iArr, 0, bitmap.getWidth(), 0, 0, bitmap.getWidth(), bitmap.getHeight());
                        List arrayList = new ArrayList();
                        List a16 = LuggageFileDecodeQueue.this.f120039e.a(iArr, new Point(bitmap.getWidth(), bitmap.getHeight()), arrayList);
                        Object[] objArr = new Object[1];
                        if (a16 == null) {
                            size = 0;
                        } else {
                            size = a16.size();
                        }
                        objArr[0] = Integer.valueOf(size);
                        w.d("LuggageFileDecodeQueue", "get %d decode results", objArr);
                        System.currentTimeMillis();
                        if (a16 != null && !a16.isEmpty()) {
                            for (QBar.QBarResult qBarResult : a16) {
                                w.d("LuggageFileDecodeQueue", "result " + qBarResult.typeName + "," + qBarResult.data);
                            }
                        }
                        list2 = a16;
                        list = arrayList;
                    }
                    bitmap.recycle();
                } else {
                    list = null;
                }
                synchronized (LuggageFileDecodeQueue.this.f120038d) {
                    if (LuggageFileDecodeQueue.this.f120037c.containsKey(this.f120041a)) {
                        Iterator it = ((List) LuggageFileDecodeQueue.this.f120037c.get(this.f120041a)).iterator();
                        while (it.hasNext()) {
                            long longValue = ((Long) it.next()).longValue();
                            if (LuggageFileDecodeQueue.this.f120036b.containsKey(Long.valueOf(longValue))) {
                                ((FileDecodeCallBack) LuggageFileDecodeQueue.this.f120036b.get(Long.valueOf(longValue))).afterDecode(longValue, list2, list);
                                LuggageFileDecodeQueue.this.f120036b.remove(Long.valueOf(longValue));
                            }
                            LuggageFileDecodeQueue.this.f120035a.remove(Long.valueOf(longValue));
                        }
                        LuggageFileDecodeQueue.this.f120037c.remove(this.f120041a);
                    }
                    if (LuggageFileDecodeQueue.this.f120037c.isEmpty()) {
                        w.d("LuggageFileDecodeQueue", "release QBar");
                        LuggageFileDecodeQueue.this.f120039e.c();
                    }
                }
            }
        }
    }

    public static LuggageFileDecodeQueue getInstance() {
        return f120034g;
    }

    public void addDecodeTask(Context context, long j3, String str, FileDecodeCallBack fileDecodeCallBack, int[] iArr) {
        synchronized (this.f120038d) {
            if (this.f120035a.size() < 5) {
                w.d("LuggageFileDecodeQueue", String.format(Locale.ENGLISH, "submit decode task %d", Long.valueOf(j3)));
                this.f120035a.put(Long.valueOf(j3), str);
                if (fileDecodeCallBack != null) {
                    this.f120036b.put(Long.valueOf(j3), fileDecodeCallBack);
                }
                if (!this.f120037c.containsKey(str)) {
                    this.f120037c.put(str, new ArrayList());
                    this.f120040f.execute(new a(str, ScanUtil.getAiModeParam(context), iArr));
                }
                ((List) this.f120037c.get(str)).add(Long.valueOf(j3));
            } else {
                w.f("LuggageFileDecodeQueue", "too many files are waiting!");
                fileDecodeCallBack.afterDecode(j3, null, null);
            }
        }
    }

    public void cancelDecodeTask(long j3) {
        synchronized (this.f120038d) {
            if (this.f120035a.containsKey(Long.valueOf(j3))) {
                String str = (String) this.f120035a.get(Long.valueOf(j3));
                if (this.f120037c.containsKey(str)) {
                    ((List) this.f120037c.get(str)).remove(Long.valueOf(j3));
                    if (((List) this.f120037c.get(str)).isEmpty()) {
                        this.f120037c.remove(str);
                    }
                }
                this.f120035a.remove(Long.valueOf(j3));
                this.f120036b.remove(Long.valueOf(j3));
            }
        }
    }

    public void addDecodeTask(Context context, long j3, String str, FileDecodeCallBack fileDecodeCallBack) {
        addDecodeTask(context, j3, str, fileDecodeCallBack, new int[]{1, 2, 4, 5});
    }
}
