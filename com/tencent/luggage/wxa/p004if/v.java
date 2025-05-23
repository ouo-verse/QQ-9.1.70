package com.tencent.luggage.wxa.p004if;

import android.graphics.BitmapFactory;
import android.graphics.Rect;
import com.tencent.luggage.wxa.ap.j;
import com.tencent.luggage.wxa.ic.l;
import com.tencent.luggage.wxa.mc.k0;
import com.tencent.luggage.wxa.tn.w0;
import com.tencent.mobileqq.app.face.FaceConstant;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Locale;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class v extends com.tencent.luggage.wxa.xd.a {
    private static final int CTRL_INDEX = 120;
    private static final String NAME = "getImageInfo";

    /* renamed from: a, reason: collision with root package name */
    public static final Collection f130243a;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ l f130244a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f130245b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ WeakReference f130246c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ int f130247d;

        public a(l lVar, String str, WeakReference weakReference, int i3) {
            this.f130244a = lVar;
            this.f130245b = str;
            this.f130246c = weakReference;
            this.f130247d = i3;
        }

        @Override // java.lang.Runnable
        public void run() {
            String makeReturnJson;
            Iterator it = v.f130243a.iterator();
            j jVar = null;
            while (it.hasNext() && (jVar = ((d) it.next()).a(this.f130244a.getRuntime(), this.f130245b)) == null) {
            }
            if (this.f130246c.get() != null && ((l) this.f130246c.get()).isRunning()) {
                if (jVar != null) {
                    int i3 = b.f130249a[((g) jVar.a(0)).ordinal()];
                    if (i3 != 1) {
                        if (i3 != 2) {
                            makeReturnJson = v.this.makeReturnJson("fail");
                        } else {
                            HashMap hashMap = new HashMap(2);
                            hashMap.put("width", Integer.valueOf(((e) jVar.a(1)).f130250a));
                            hashMap.put("height", Integer.valueOf(((e) jVar.a(1)).f130251b));
                            hashMap.put("orientation", ((e) jVar.a(1)).f130252c);
                            hashMap.put("type", ((e) jVar.a(1)).f130253d);
                            makeReturnJson = v.this.makeReturnJson(FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS, hashMap);
                        }
                    } else {
                        makeReturnJson = v.this.makeReturnJson("fail:file not found");
                    }
                    ((l) this.f130246c.get()).a(this.f130247d, makeReturnJson);
                    return;
                }
                ((l) this.f130246c.get()).a(this.f130247d, v.this.makeReturnJson("fail:file not found"));
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f130249a;

        static {
            int[] iArr = new int[g.values().length];
            f130249a = iArr;
            try {
                iArr[g.FILE_NOT_FOUND.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f130249a[g.RESOLVED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f130249a[g.UNKNOWN_FAIL.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class c implements d {
        public c() {
        }

        public /* synthetic */ c(a aVar) {
            this();
        }

        @Override // com.tencent.luggage.wxa.if.v.d
        public j a(com.tencent.luggage.wxa.ic.g gVar, String str) {
            String str2;
            com.tencent.luggage.wxa.cp.v absoluteFile = gVar.P().getAbsoluteFile(str);
            a aVar = null;
            if (absoluteFile == null) {
                return null;
            }
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeFile(absoluteFile.g(), options);
            e eVar = new e(aVar);
            eVar.f130250a = options.outWidth;
            eVar.f130251b = options.outHeight;
            eVar.f130253d = com.tencent.luggage.wxa.g2.a.a(options);
            if (com.tencent.luggage.wxa.g2.a.b(options)) {
                str2 = com.tencent.luggage.wxa.g2.a.a(com.tencent.luggage.wxa.g2.a.a(absoluteFile.g()));
            } else {
                str2 = "up";
            }
            eVar.f130252c = str2;
            return j.a(g.RESOLVED, eVar);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public interface d {
        j a(com.tencent.luggage.wxa.ic.g gVar, String str);
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class e {

        /* renamed from: a, reason: collision with root package name */
        public int f130250a;

        /* renamed from: b, reason: collision with root package name */
        public int f130251b;

        /* renamed from: c, reason: collision with root package name */
        public String f130252c;

        /* renamed from: d, reason: collision with root package name */
        public String f130253d;

        public e() {
        }

        public /* synthetic */ e(a aVar) {
            this();
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class f implements d {
        public f() {
        }

        public /* synthetic */ f(a aVar) {
            this();
        }

        @Override // com.tencent.luggage.wxa.if.v.d
        public j a(com.tencent.luggage.wxa.ic.g gVar, String str) {
            String str2;
            InputStream d16 = k0.d(gVar, str);
            if (d16 != null) {
                d16.mark(0);
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inJustDecodeBounds = true;
                BitmapFactory.decodeStream(d16, new Rect(), options);
                e eVar = new e(null);
                eVar.f130250a = options.outWidth;
                eVar.f130251b = options.outHeight;
                eVar.f130253d = com.tencent.luggage.wxa.g2.a.a(options);
                boolean b16 = com.tencent.luggage.wxa.g2.a.b(options);
                try {
                    d16.reset();
                } catch (IOException unused) {
                }
                if (b16) {
                    str2 = com.tencent.luggage.wxa.g2.a.a(com.tencent.luggage.wxa.g2.a.a(d16));
                } else {
                    str2 = "up";
                }
                eVar.f130252c = str2;
                w0.a((Closeable) d16);
                return j.a(g.RESOLVED, eVar);
            }
            return j.a(g.FILE_NOT_FOUND);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public enum g {
        FILE_NOT_FOUND,
        UNKNOWN_FAIL,
        RESOLVED
    }

    static {
        LinkedList linkedList = new LinkedList();
        a aVar = null;
        linkedList.add(new c(aVar));
        linkedList.add(new f(aVar));
        f130243a = Collections.unmodifiableCollection(linkedList);
    }

    @Override // com.tencent.luggage.wxa.xd.a
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void invoke(l lVar, JSONObject jSONObject, int i3) {
        lVar.getAppId();
        String optString = jSONObject.optString("src");
        if (w0.c(optString)) {
            lVar.a(i3, makeReturnJson("fail:invalid data"));
        } else {
            com.tencent.luggage.wxa.co.a.a(new a(lVar, optString, new WeakReference(lVar), i3), String.format(Locale.US, "AppBrandJsApiGetImageInfo[%s]", optString), 10);
        }
    }
}
