package com.tencent.mobileqq.armap;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v4.util.LruCache;
import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.face.util.AvatarOptimiseConfigUtil;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.state.data.SquareJSConst;
import com.tenpay.sdk.util.QQFaceFileUtil;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes11.dex */
public class g implements f {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    protected Context f199727a;

    /* renamed from: b, reason: collision with root package name */
    public Bitmap f199728b;

    /* renamed from: c, reason: collision with root package name */
    protected int f199729c;

    /* renamed from: d, reason: collision with root package name */
    protected LruCache<String, Bitmap> f199730d;

    /* renamed from: e, reason: collision with root package name */
    protected LruCache<String, String> f199731e;

    /* renamed from: f, reason: collision with root package name */
    protected HashSet<String> f199732f;

    /* renamed from: g, reason: collision with root package name */
    protected ArrayList<String> f199733g;

    /* renamed from: h, reason: collision with root package name */
    final List<e> f199734h;

    /* renamed from: i, reason: collision with root package name */
    private byte f199735i;

    /* renamed from: j, reason: collision with root package name */
    private boolean f199736j;

    /* renamed from: k, reason: collision with root package name */
    private BroadcastReceiver f199737k;

    /* renamed from: l, reason: collision with root package name */
    protected Handler f199738l;

    /* renamed from: m, reason: collision with root package name */
    protected Handler f199739m;

    /* renamed from: n, reason: collision with root package name */
    protected float f199740n;

    /* compiled from: P */
    /* loaded from: classes11.dex */
    class a extends BroadcastReceiver {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) g.this);
            }
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) intent);
                return;
            }
            if (intent == null || !"com.tencent.qqhead.getheadresp".equals(intent.getAction()) || intent.getIntExtra("faceType", -1) != g.this.f199729c) {
                return;
            }
            ArrayList<String> stringArrayListExtra = intent.getStringArrayListExtra(SquareJSConst.Params.PARAMS_UIN_LIST);
            ArrayList<String> stringArrayListExtra2 = intent.getStringArrayListExtra("headPathList");
            if (stringArrayListExtra != null && stringArrayListExtra2 != null) {
                int size = stringArrayListExtra.size();
                if (QLog.isColorLevel()) {
                    QLog.d("NonMainAppHeadLoader", 2, "onReceive, uinListSize:" + size + " reqSize:" + g.this.f199732f.size());
                }
                ArrayList arrayList = new ArrayList(g.this.f199732f.size());
                for (int i3 = 0; i3 < size; i3++) {
                    String str = stringArrayListExtra.get(i3);
                    if (g.this.f199732f.contains(str)) {
                        g.this.f199732f.remove(str);
                        arrayList.add(str);
                    }
                    String str2 = stringArrayListExtra2.get(i3);
                    if (TextUtils.isEmpty(str2)) {
                        QLog.e("NonMainAppHeadLoader", 1, "onReceive, headPath is null. uin: " + MsfSdkUtils.getShortUin(str));
                    } else {
                        g.this.f199731e.put(str, str2);
                    }
                }
                Message obtain = Message.obtain();
                obtain.obj = arrayList;
                obtain.what = 1001;
                g.this.f199739m.sendMessage(obtain);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes11.dex */
    class b extends Handler {
        static IPatchRedirector $redirector_;

        b(Looper looper) {
            super(looper);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) g.this, (Object) looper);
            }
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) message);
                return;
            }
            int i3 = message.what;
            if (i3 == 1000) {
                if (g.this.f199733g.size() > 0) {
                    ArrayList<String> arrayList = new ArrayList<>(g.this.f199733g.size());
                    arrayList.addAll(g.this.f199733g);
                    g.this.j(arrayList);
                    g.this.f199733g.removeAll(arrayList);
                    return;
                }
                return;
            }
            if (i3 == 1002) {
                try {
                    Bundle bundle = (Bundle) message.obj;
                    Bitmap bitmap = (Bitmap) bundle.getParcelable("bmp");
                    String string = bundle.getString("uin");
                    String string2 = bundle.getString("path");
                    if (bitmap != null) {
                        g.this.f199730d.put(string, bitmap);
                    }
                    for (e eVar : g.this.f199734h) {
                        if (eVar != null) {
                            eVar.h(string, string2, bitmap);
                        }
                    }
                    if (QLog.isColorLevel()) {
                        QLog.d("NonMainAppHeadLoader", 2, "refreshImg, uin:" + string + ", path=" + string2);
                    }
                } catch (Exception e16) {
                    if (QLog.isColorLevel()) {
                        QLog.e("NonMainAppHeadLoader", 2, "refreshImg, exception:" + e16.toString());
                    }
                }
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes11.dex */
    class c extends Handler {
        static IPatchRedirector $redirector_;

        c(Looper looper) {
            super(looper);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) g.this, (Object) looper);
            }
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            boolean z16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) message);
                return;
            }
            if (message.what == 1001) {
                try {
                    ArrayList arrayList = (ArrayList) message.obj;
                    if (arrayList != null && arrayList.size() > 0) {
                        Iterator it = arrayList.iterator();
                        while (it.hasNext()) {
                            String str = (String) it.next();
                            String str2 = g.this.f199731e.get(str);
                            Bitmap decodeFile = BitmapFactory.decodeFile(str2);
                            if (QLog.isDevelopLevel()) {
                                StringBuilder sb5 = new StringBuilder();
                                sb5.append("decodeFile, uin:");
                                sb5.append(str);
                                sb5.append(", bitmap null?");
                                if (decodeFile == null) {
                                    z16 = true;
                                } else {
                                    z16 = false;
                                }
                                sb5.append(z16);
                                sb5.append(", path:");
                                sb5.append(str2);
                                QLog.d("NonMainAppHeadLoader", 4, sb5.toString());
                            }
                            if (decodeFile != null) {
                                if (!AvatarOptimiseConfigUtil.b()) {
                                    if (g.this.f199735i == 1) {
                                        decodeFile = com.tencent.mobileqq.avatar.utils.c.m(decodeFile, BaseImageUtil.getFaceSquareRadius(decodeFile.getWidth()), 50, 50);
                                        if (ThemeUtil.isNowThemeIsNight(null, false, null) && g.this.f199736j) {
                                            Paint paint = new Paint();
                                            paint.setAntiAlias(true);
                                            paint.setColor(ThemeUtil.NIGHTMODE_MASKCOLOR);
                                            new Canvas(decodeFile).drawRoundRect(new RectF(0.0f, 0.0f, r7.getWidth(), r7.getHeight()), 10.0f, 10.0f, paint);
                                        }
                                    } else {
                                        decodeFile = g.this.i(decodeFile);
                                        if (ThemeUtil.isNowThemeIsNight(null, false, null) && g.this.f199736j) {
                                            Paint paint2 = new Paint();
                                            paint2.setAntiAlias(true);
                                            paint2.setColor(ThemeUtil.NIGHTMODE_MASKCOLOR);
                                            new Canvas(decodeFile).drawCircle(r7.getWidth() / 2, r7.getHeight() / 2, r7.getWidth() / 2, paint2);
                                        }
                                    }
                                }
                                if (decodeFile != null) {
                                    Message obtain = Message.obtain();
                                    Bundle bundle = new Bundle();
                                    bundle.putParcelable("bmp", decodeFile);
                                    bundle.putString("uin", str);
                                    bundle.putString("path", str2);
                                    obtain.obj = bundle;
                                    obtain.what = 1002;
                                    g.this.f199738l.sendMessage(obtain);
                                    if (QLog.isColorLevel()) {
                                        QLog.d("NonMainAppHeadLoader", 2, "decodeFile, uin:" + str);
                                    }
                                }
                            }
                        }
                    }
                } catch (Exception e16) {
                    if (QLog.isColorLevel()) {
                        QLog.e("NonMainAppHeadLoader", 2, "decodeFile, exception:" + e16.toString());
                    }
                } catch (OutOfMemoryError unused) {
                    if (QLog.isColorLevel()) {
                        QLog.e("NonMainAppHeadLoader", 2, "decodeFile, OutOfMemoryError");
                    }
                }
            }
        }
    }

    public g(Context context, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context, i3);
            return;
        }
        this.f199728b = null;
        this.f199730d = new LruCache<>(60);
        this.f199731e = new LruCache<>(120);
        this.f199732f = new HashSet<>();
        this.f199733g = new ArrayList<>();
        this.f199734h = Collections.synchronizedList(new ArrayList());
        this.f199735i = (byte) 3;
        this.f199736j = true;
        this.f199737k = new a();
        this.f199738l = new b(Looper.getMainLooper());
        this.f199739m = new c(ThreadManagerV2.getSubThreadLooper());
        this.f199740n = 1.0f;
        this.f199727a = context;
        this.f199740n = context.getResources().getDisplayMetrics().density;
        this.f199729c = i3;
        try {
            this.f199728b = BaseImageUtil.getDefaultFaceBitmap();
        } catch (OutOfMemoryError unused) {
        }
    }

    @Override // com.tencent.mobileqq.armap.f
    public void a(e eVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) eVar);
        } else {
            if (eVar == null) {
                return;
            }
            synchronized (this.f199734h) {
                if (!this.f199734h.contains(eVar)) {
                    this.f199734h.add(eVar);
                }
            }
        }
    }

    @Override // com.tencent.mobileqq.armap.f
    public Bitmap b(String str, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (Bitmap) iPatchRedirector.redirect((short) 9, this, str, Boolean.valueOf(z16));
        }
        return d(str, z16, this.f199728b);
    }

    @Override // com.tencent.mobileqq.armap.f
    public void c(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, i3);
        } else {
            this.f199729c = i3;
        }
    }

    @Override // com.tencent.mobileqq.armap.f
    public Bitmap d(String str, boolean z16, Bitmap bitmap) {
        Bitmap bitmap2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (Bitmap) iPatchRedirector.redirect((short) 10, this, str, Boolean.valueOf(z16), bitmap);
        }
        try {
            bitmap2 = this.f199730d.get(str);
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.e("NonMainAppHeadLoader", 2, "getFaceBitmap, exception:" + e16.toString());
            }
        }
        if (bitmap2 != null) {
            return bitmap2;
        }
        if (!TextUtils.isEmpty(this.f199731e.get(str))) {
            ArrayList arrayList = new ArrayList(1);
            Message obtain = Message.obtain();
            arrayList.add(str);
            obtain.obj = arrayList;
            obtain.what = 1001;
            this.f199739m.sendMessage(obtain);
        } else if (z16 && !this.f199733g.contains(str)) {
            this.f199733g.add(str);
            this.f199738l.removeMessages(1000);
            this.f199738l.sendEmptyMessageDelayed(1000, 50L);
        }
        return bitmap;
    }

    @Override // com.tencent.mobileqq.armap.f
    public void destroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("NonMainAppHeadLoader", 2, "destroy");
        }
        try {
            this.f199727a.unregisterReceiver(this.f199737k);
        } catch (Throwable th5) {
            if (QLog.isColorLevel()) {
                QLog.e("NonMainAppHeadLoader", 2, "destroy:" + th5.toString());
            }
        }
        try {
            synchronized (this.f199734h) {
                this.f199734h.clear();
            }
            this.f199732f.clear();
            this.f199738l.removeCallbacksAndMessages(null);
            this.f199739m.removeCallbacksAndMessages(null);
            this.f199731e.evictAll();
            this.f199730d.evictAll();
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.e("NonMainAppHeadLoader", 2, "destroy:" + e16.toString());
            }
        }
    }

    @Override // com.tencent.mobileqq.armap.f
    public void e(byte b16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Byte.valueOf(b16));
        } else {
            this.f199735i = b16;
        }
    }

    @Override // com.tencent.mobileqq.armap.f
    public void f(e eVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) eVar);
        } else {
            if (eVar == null) {
                return;
            }
            synchronized (this.f199734h) {
                this.f199734h.remove(eVar);
            }
        }
    }

    protected Bitmap i(Bitmap bitmap) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (Bitmap) iPatchRedirector.redirect((short) 13, (Object) this, (Object) bitmap);
        }
        float f16 = this.f199740n;
        int width = bitmap.getWidth();
        if (width > 0) {
            float f17 = width;
            float f18 = 50;
            if (f17 < f16 * f18) {
                f16 = f17 / f18;
            }
        }
        int i3 = (int) (50 * f16);
        return BaseImageUtil.getRoundedCornerBitmap(bitmap, i3, i3, i3);
    }

    @Override // com.tencent.mobileqq.armap.f
    public void init() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.tencent.qqhead.getheadresp");
        try {
            this.f199727a.registerReceiver(this.f199737k, intentFilter, QQFaceFileUtil.QQFaceImageGetter.ReceiverQQFacePermission, null);
        } catch (Throwable unused) {
            QLog.d("NonMainAppHeadLoader", 1, "init register receiver fail!");
        }
    }

    protected void j(ArrayList<String> arrayList) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) arrayList);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("NonMainAppHeadLoader", 2, "sendQQHeadRequest, requestedSize:" + this.f199732f.size() + " cacheSize:" + this.f199730d.size() + " " + this.f199731e.size());
        }
        if (arrayList != null && arrayList.size() != 0) {
            ArrayList<String> arrayList2 = new ArrayList<>(arrayList.size());
            Iterator<String> it = arrayList.iterator();
            while (it.hasNext()) {
                String next = it.next();
                if (!this.f199732f.contains(next)) {
                    arrayList2.add(next);
                }
            }
            Intent intent = new Intent("com.tencent.qqhead.getheadreq");
            intent.setPackage(this.f199727a.getPackageName());
            intent.putExtra("faceType", this.f199729c);
            intent.putStringArrayListExtra(SquareJSConst.Params.PARAMS_UIN_LIST, arrayList2);
            this.f199727a.sendBroadcast(intent, QQFaceFileUtil.QQFaceImageGetter.ReceiverQQFacePermission);
            if (QLog.isDevelopLevel()) {
                QLog.d("NonMainAppHeadLoader", 4, "sendQQHeadRequest [" + this.f199729c + "] reqUinList:" + arrayList2);
            }
            this.f199732f.addAll(arrayList2);
        }
    }
}
