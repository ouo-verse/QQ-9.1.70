package com.qzone.proxy.feedcomponent.text;

import android.graphics.Typeface;
import android.text.TextUtils;
import com.tencent.component.media.utils.LruCache;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qzonehub.api.font.IFontManager;
import cooperation.qzone.font.FontInterface;
import cooperation.qzone.thread.QzoneHandlerThreadFactory;
import cooperation.qzone.util.MultiHashMap;
import java.util.HashSet;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes39.dex */
public class QzoneFontManager {

    /* renamed from: d, reason: collision with root package name */
    private static Object f50557d = new Object();

    /* renamed from: e, reason: collision with root package name */
    private static QzoneFontManager f50558e;

    /* renamed from: a, reason: collision with root package name */
    private LruCache<Integer, Typeface> f50559a = new LruCache<>(8);

    /* renamed from: b, reason: collision with root package name */
    private MultiHashMap<Integer, b> f50560b = new MultiHashMap<>();

    /* renamed from: c, reason: collision with root package name */
    private FontInterface.TrueTypeResult f50561c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class a implements FontInterface.TrueTypeResult {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f50564a;

        a(int i3) {
            this.f50564a = i3;
        }

        @Override // cooperation.qzone.font.FontInterface.TrueTypeResult, cooperation.qzone.font.FontInterface.FontResult
        public void result(int i3, String str, String str2) {
            if (TextUtils.isEmpty(str)) {
                synchronized (QzoneFontManager.f50557d) {
                    QzoneFontManager.this.f50560b.remove(Integer.valueOf(this.f50564a));
                }
                QzoneFontManager.this.f50561c = null;
            }
            QzoneFontManager.this.h(i3, str);
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    public interface b {
        void a(Typeface typeface);
    }

    QzoneFontManager() {
    }

    public static QzoneFontManager f() {
        if (f50558e == null) {
            synchronized (f50557d) {
                if (f50558e == null) {
                    f50558e = new QzoneFontManager();
                }
            }
        }
        return f50558e;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(final int i3, final String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.NormalThread).post(new Runnable() { // from class: com.qzone.proxy.feedcomponent.text.QzoneFontManager.2
            @Override // java.lang.Runnable
            public void run() {
                QzoneFontManager.this.f50561c = null;
                try {
                    Typeface createFromFile = Typeface.createFromFile(str);
                    QzoneFontManager.this.f50559a.put(Integer.valueOf(i3), createFromFile);
                    synchronized (QzoneFontManager.f50557d) {
                        HashSet hashSet = QzoneFontManager.this.f50560b.get(Integer.valueOf(i3));
                        if (hashSet != null && !hashSet.isEmpty()) {
                            Iterator it = hashSet.iterator();
                            while (it.hasNext()) {
                                b bVar = (b) it.next();
                                if (bVar != null) {
                                    bVar.a(createFromFile);
                                }
                            }
                            QzoneFontManager.this.f50560b.remove(Integer.valueOf(i3));
                        }
                    }
                } catch (Exception e16) {
                    e16.printStackTrace();
                }
            }
        });
    }

    public Typeface g(int i3, String str, b bVar) {
        Typeface typeface = this.f50559a.get(Integer.valueOf(i3));
        if (typeface != null) {
            return typeface;
        }
        synchronized (f50557d) {
            if (this.f50560b.contains(Integer.valueOf(i3), bVar)) {
                return null;
            }
            if (this.f50560b.containsKey(Integer.valueOf(i3))) {
                this.f50560b.add(Integer.valueOf(i3), bVar);
                return null;
            }
            this.f50560b.add(Integer.valueOf(i3), bVar);
            if (this.f50561c == null) {
                this.f50561c = new a(i3);
            }
            h(i3, ((IFontManager) QRoute.api(IFontManager.class)).getTrueTypeFont(i3, str, null, false, this.f50561c));
            return null;
        }
    }
}
