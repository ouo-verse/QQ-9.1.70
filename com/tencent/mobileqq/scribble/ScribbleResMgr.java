package com.tencent.mobileqq.scribble;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.common.util.ZipUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.config.splashlogo.ConfigServlet;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqfeatureswitch.IFeatureRuntimeService;
import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.INetEngineListener;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetResp;
import com.tencent.mobileqq.transfile.NetworkCenter;
import com.tencent.mobileqq.transfile.api.IHttpEngineService;
import com.tencent.mobileqq.transfile.predownload.IPreDownloadController;
import com.tencent.mobileqq.transfile.predownload.RunnableTask;
import com.tencent.mobileqq.transfile.predownload.schedule.PreDownloadConstants;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.ea;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.widget.QzoneEmotionUtils;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import mqq.app.AppRuntime;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes18.dex */
public class ScribbleResMgr extends com.tencent.mobileqq.scribble.a {
    static IPatchRedirector $redirector_;

    /* renamed from: v, reason: collision with root package name */
    static ScribbleResMgr f282508v;

    /* renamed from: w, reason: collision with root package name */
    static Object f282509w;

    /* renamed from: g, reason: collision with root package name */
    public boolean f282510g;

    /* renamed from: h, reason: collision with root package name */
    private final Handler f282511h;

    /* renamed from: i, reason: collision with root package name */
    protected Handler f282512i;

    /* renamed from: j, reason: collision with root package name */
    private final ArrayList<c> f282513j;

    /* renamed from: k, reason: collision with root package name */
    private ArrayList<com.tencent.mobileqq.scribble.c> f282514k;

    /* renamed from: l, reason: collision with root package name */
    private ArrayList<com.tencent.mobileqq.scribble.c> f282515l;

    /* renamed from: m, reason: collision with root package name */
    private boolean f282516m;

    /* renamed from: n, reason: collision with root package name */
    private boolean f282517n;

    /* renamed from: o, reason: collision with root package name */
    private String f282518o;

    /* renamed from: p, reason: collision with root package name */
    private String f282519p;

    /* renamed from: q, reason: collision with root package name */
    private String f282520q;

    /* renamed from: r, reason: collision with root package name */
    private String f282521r;

    /* renamed from: s, reason: collision with root package name */
    private boolean f282522s;

    /* renamed from: t, reason: collision with root package name */
    private boolean f282523t;

    /* renamed from: u, reason: collision with root package name */
    private Lock f282524u;

    /* compiled from: P */
    /* loaded from: classes18.dex */
    class a extends Handler {
        static IPatchRedirector $redirector_;

        a(Looper looper) {
            super(looper);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ScribbleResMgr.this, (Object) looper);
            }
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) message);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("ScribbleResMgr", 2, "handleMessage  status: " + message.what + " type: " + message.arg1);
            }
            int i3 = message.what;
            if (i3 == 1001) {
                ScribbleResMgr.this.C(message.arg1, message.arg2, true);
                return;
            }
            if (i3 == 1002) {
                ScribbleResMgr.this.C(message.arg1, message.arg2, false);
                return;
            }
            Iterator it = ScribbleResMgr.this.f282513j.iterator();
            while (it.hasNext()) {
                c cVar = (c) it.next();
                if (cVar != null) {
                    View b16 = cVar.b();
                    com.tencent.mobileqq.scribble.b a16 = cVar.a();
                    if (b16 != null && a16 != null) {
                        a16.b(b16, message.arg1, (com.tencent.mobileqq.scribble.c) message.obj, message.what);
                    } else {
                        it.remove();
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class b implements Comparator<com.tencent.mobileqq.scribble.c> {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ScribbleResMgr.this);
            }
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(com.tencent.mobileqq.scribble.c cVar, com.tencent.mobileqq.scribble.c cVar2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this, (Object) cVar, (Object) cVar2)).intValue();
            }
            if (cVar != null && cVar2 != null) {
                return cVar.f282555j - cVar2.f282555j;
            }
            return -1;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class c {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        WeakReference<View> f282535a;

        /* renamed from: b, reason: collision with root package name */
        WeakReference<com.tencent.mobileqq.scribble.b> f282536b;

        /* renamed from: c, reason: collision with root package name */
        int f282537c;

        /* renamed from: d, reason: collision with root package name */
        int f282538d;

        public c(int i3, int i16, View view, com.tencent.mobileqq.scribble.b bVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, ScribbleResMgr.this, Integer.valueOf(i3), Integer.valueOf(i16), view, bVar);
                return;
            }
            this.f282535a = new WeakReference<>(view);
            this.f282536b = new WeakReference<>(bVar);
            this.f282538d = i3;
            this.f282537c = i16;
        }

        public com.tencent.mobileqq.scribble.b a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (com.tencent.mobileqq.scribble.b) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            return this.f282536b.get();
        }

        public View b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (View) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return this.f282535a.get();
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(74871);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 8)) {
            redirector.redirect((short) 8);
        } else {
            f282509w = new Object();
        }
    }

    public ScribbleResMgr() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f282510g = false;
        this.f282511h = new a(Looper.getMainLooper());
        this.f282512i = new Handler(ThreadManagerV2.getSubThreadLooper());
        this.f282513j = new ArrayList<>();
        this.f282514k = new ArrayList<>();
        this.f282515l = new ArrayList<>();
        this.f282516m = false;
        this.f282517n = false;
        this.f282518o = "";
        this.f282519p = "";
        this.f282520q = "";
        this.f282521r = "";
        this.f282522s = false;
        this.f282523t = true;
        this.f282524u = new ReentrantLock();
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x0101 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00ec A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean A(QQAppInterface qQAppInterface, String str) {
        String str2;
        boolean z16;
        ArrayList<com.tencent.mobileqq.scribble.c> I;
        AppRuntime runtime;
        Iterator<com.tencent.mobileqq.scribble.c> it;
        com.tencent.mobileqq.scribble.c next;
        JSONObject jSONObject;
        String t16 = ea.t1(qQAppInterface.getApp().getBaseContext());
        JSONArray jSONArray = null;
        try {
            jSONObject = new JSONObject(str);
            if (jSONObject.has("version")) {
                str2 = jSONObject.getString("version");
            } else {
                str2 = null;
            }
        } catch (JSONException e16) {
            e = e16;
            str2 = null;
        }
        try {
            if (jSONObject.has("iconUrl")) {
                this.f282520q = jSONObject.getString("iconUrl");
            }
            if (jSONObject.has("iconMd5")) {
                this.f282521r = jSONObject.getString("iconMd5");
            }
            if (jSONObject.has("content")) {
                jSONArray = jSONObject.getJSONArray("content");
            }
            z16 = true;
        } catch (JSONException e17) {
            e = e17;
            e.printStackTrace();
            QLog.e("ScribbleResMgr", 2, "RESOURCE_CONFIG_TASK_ID_Gif JSON EXCEPT");
            z16 = false;
            I = I(jSONArray, 2);
            R(I);
            runtime = BaseApplicationImpl.getApplication().getRuntime();
            if (runtime != null) {
                if (t16 != null) {
                }
                QLog.i("ScribbleResMgr", 2, "RESOURCE_CONFIG_TASK_ID_GIF newVersion = " + str2);
                ea.R4(qQAppInterface.getApp().getBaseContext(), str2);
                ea.Q4(qQAppInterface.getApp().getBaseContext(), str);
                p(qQAppInterface, 4, com.tencent.mobileqq.scribble.a.f282545f.longValue());
                if (I != null) {
                    it = I.iterator();
                    while (it != null) {
                        next = it.next();
                        if (next.f282552g) {
                        }
                    }
                }
            }
            return z16;
        }
        I = I(jSONArray, 2);
        R(I);
        runtime = BaseApplicationImpl.getApplication().getRuntime();
        if (runtime != null && ((IFeatureRuntimeService) runtime.getRuntimeService(IFeatureRuntimeService.class, "all")).isFeatureSwitchEnable("rich_media_pre_download_sticker_emoji_on_startup", false)) {
            if ((t16 != null || !t16.equalsIgnoreCase(str2)) && z16) {
                QLog.i("ScribbleResMgr", 2, "RESOURCE_CONFIG_TASK_ID_GIF newVersion = " + str2);
                ea.R4(qQAppInterface.getApp().getBaseContext(), str2);
                ea.Q4(qQAppInterface.getApp().getBaseContext(), str);
                p(qQAppInterface, 4, com.tencent.mobileqq.scribble.a.f282545f.longValue());
                if (I != null && !I.isEmpty()) {
                    it = I.iterator();
                    while (it != null && it.hasNext()) {
                        next = it.next();
                        if (next.f282552g) {
                            if (next.f282551f == 1 || this.f282522s) {
                                q(qQAppInterface, next, com.tencent.mobileqq.scribble.a.f282545f.longValue(), true);
                            }
                        } else {
                            QLog.e("ScribbleResMgr", 2, "mArrGifInfo index :" + next.f282547b + " is downloading ");
                        }
                    }
                }
            } else {
                QLog.i("ScribbleResMgr", 2, "RESOURCE_CONFIG_TASK_ID_GIF newVersion = " + str2 + " oldVersion=  " + t16);
            }
        }
        return z16;
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x00df  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean B(QQAppInterface qQAppInterface, String str) {
        String str2;
        boolean z16;
        ArrayList<com.tencent.mobileqq.scribble.c> I;
        AppRuntime runtime;
        Iterator<com.tencent.mobileqq.scribble.c> it;
        JSONObject jSONObject;
        String v16 = ea.v1(qQAppInterface.getApp().getBaseContext());
        JSONArray jSONArray = null;
        try {
            jSONObject = new JSONObject(str);
            if (jSONObject.has("version")) {
                str2 = jSONObject.getString("version");
            } else {
                str2 = null;
            }
        } catch (JSONException e16) {
            e = e16;
            str2 = null;
        }
        try {
            if (jSONObject.has("iconUrl")) {
                this.f282518o = jSONObject.getString("iconUrl");
            }
            if (jSONObject.has("iconMd5")) {
                this.f282519p = jSONObject.getString("iconMd5");
            }
            if (jSONObject.has("content")) {
                jSONArray = jSONObject.getJSONArray("content");
            }
            z16 = true;
        } catch (JSONException e17) {
            e = e17;
            e.printStackTrace();
            QLog.e("ScribbleResMgr", 2, "RESOURCE_CONFIG_TASK_ID_PAINT JSON EXCEPT");
            z16 = false;
            I = I(jSONArray, 1);
            S(I);
            runtime = BaseApplicationImpl.getApplication().getRuntime();
            if (runtime != null) {
                if (v16 != null) {
                }
                QLog.i("ScribbleResMgr", 2, "RESOURCE_CONFIG_TASK_ID_PAINT newVersion = " + str2);
                ea.T4(qQAppInterface.getApp().getBaseContext(), str2);
                ea.S4(qQAppInterface.getApp().getBaseContext(), str);
                p(qQAppInterface, 3, com.tencent.mobileqq.scribble.a.f282545f.longValue());
                if (I != null) {
                    it = I.iterator();
                    while (it.hasNext()) {
                    }
                }
            }
            return z16;
        }
        I = I(jSONArray, 1);
        S(I);
        runtime = BaseApplicationImpl.getApplication().getRuntime();
        if (runtime != null && ((IFeatureRuntimeService) runtime.getRuntimeService(IFeatureRuntimeService.class, "all")).isFeatureSwitchEnable("rich_media_pre_download_sticker_emoji_on_startup", false)) {
            if ((v16 != null || !v16.equalsIgnoreCase(str2)) && z16) {
                QLog.i("ScribbleResMgr", 2, "RESOURCE_CONFIG_TASK_ID_PAINT newVersion = " + str2);
                ea.T4(qQAppInterface.getApp().getBaseContext(), str2);
                ea.S4(qQAppInterface.getApp().getBaseContext(), str);
                p(qQAppInterface, 3, com.tencent.mobileqq.scribble.a.f282545f.longValue());
                if (I != null && !I.isEmpty()) {
                    it = I.iterator();
                    while (it.hasNext()) {
                        com.tencent.mobileqq.scribble.c next = it.next();
                        if (!next.f282552g) {
                            if (next.f282551f == 1 || this.f282522s) {
                                q(qQAppInterface, next, com.tencent.mobileqq.scribble.a.f282545f.longValue(), true);
                            }
                        } else {
                            QLog.e("ScribbleResMgr", 2, "mArrPaintInfo index :" + next.f282547b + " is downloading ");
                        }
                    }
                }
            } else {
                QLog.i("ScribbleResMgr", 2, "RESOURCE_CONFIG_TASK_ID_PAINT newVersion = " + str2 + " oldVersion=  " + v16);
            }
        }
        return z16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void C(int i3, int i16, boolean z16) {
        if (i3 == 3) {
            this.f282517n = z16;
        }
        if (i3 == 4) {
            this.f282516m = z16;
        }
        if (i3 == 2) {
            Iterator<com.tencent.mobileqq.scribble.c> it = this.f282514k.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                com.tencent.mobileqq.scribble.c next = it.next();
                if (next != null && next.f282547b == i16) {
                    next.f282552g = z16;
                    break;
                }
            }
        }
        if (i3 == 1) {
            Iterator<com.tencent.mobileqq.scribble.c> it5 = this.f282515l.iterator();
            while (it5.hasNext()) {
                com.tencent.mobileqq.scribble.c next2 = it5.next();
                if (next2 != null && next2.f282547b == i16) {
                    next2.f282552g = z16;
                    return;
                }
            }
        }
    }

    private void D() {
        Message message = new Message();
        message.what = 3;
        message.obj = null;
        message.arg1 = 0;
        this.f282511h.sendMessageDelayed(message, 0L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void E(int i3, int i16, boolean z16) {
        int i17;
        Message message = new Message();
        if (z16) {
            i17 = 1001;
        } else {
            i17 = 1002;
        }
        message.what = i17;
        message.arg1 = i3;
        message.arg2 = i16;
        this.f282511h.sendMessageDelayed(message, 0L);
    }

    private synchronized void G(int i3, int i16, View view, com.tencent.mobileqq.scribble.b bVar) {
        Iterator<c> it = this.f282513j.iterator();
        while (it.hasNext()) {
            c next = it.next();
            if (next.b() == view) {
                next.f282536b = new WeakReference<>(bVar);
                return;
            }
        }
        this.f282513j.add(new c(i3, i16, view, bVar));
    }

    public static boolean H(Context context, String str) {
        boolean w16 = ea.w1(context, str);
        QLog.d("ScribbleResMgr", 2, "canShowEnter" + w16);
        return w16;
    }

    public static ArrayList<com.tencent.mobileqq.scribble.c> I(JSONArray jSONArray, int i3) {
        if (jSONArray == null) {
            return null;
        }
        try {
            int length = jSONArray.length();
            if (length <= 0) {
                return null;
            }
            ArrayList<com.tencent.mobileqq.scribble.c> arrayList = new ArrayList<>(length);
            for (int i16 = 0; i16 < length; i16++) {
                com.tencent.mobileqq.scribble.c cVar = (com.tencent.mobileqq.scribble.c) com.tencent.mobileqq.jsonconverter.a.f(jSONArray.getJSONObject(i16), com.tencent.mobileqq.scribble.c.class);
                if (cVar != null) {
                    cVar.f282546a = i3;
                    arrayList.add(cVar);
                }
            }
            return arrayList;
        } catch (JSONException e16) {
            if (QLog.isDevelopLevel()) {
                e16.printStackTrace();
                QLog.e("ScribbleResMgr", 2, "convertFromErr: " + e16);
            }
            return null;
        }
    }

    private ArrayList<com.tencent.mobileqq.scribble.c> J() {
        ArrayList<com.tencent.mobileqq.scribble.c> arrayList = new ArrayList<>();
        this.f282524u.lock();
        try {
            ArrayList<com.tencent.mobileqq.scribble.c> arrayList2 = this.f282514k;
            if (arrayList2 != null && arrayList2.size() > 0) {
                Iterator<com.tencent.mobileqq.scribble.c> it = this.f282514k.iterator();
                while (it.hasNext()) {
                    com.tencent.mobileqq.scribble.c next = it.next();
                    if (next != null) {
                        arrayList.add(next.a(next));
                    }
                }
            }
            return arrayList;
        } finally {
            this.f282524u.unlock();
        }
    }

    private ArrayList<com.tencent.mobileqq.scribble.c> K() {
        ArrayList<com.tencent.mobileqq.scribble.c> arrayList = new ArrayList<>();
        this.f282524u.lock();
        try {
            ArrayList<com.tencent.mobileqq.scribble.c> arrayList2 = this.f282515l;
            if (arrayList2 != null && arrayList2.size() > 0) {
                Iterator<com.tencent.mobileqq.scribble.c> it = this.f282515l.iterator();
                while (it.hasNext()) {
                    com.tencent.mobileqq.scribble.c next = it.next();
                    if (next != null) {
                        arrayList.add(next.a(next));
                    }
                }
            }
            return arrayList;
        } finally {
            this.f282524u.unlock();
        }
    }

    public static ScribbleResMgr L() {
        ScribbleResMgr scribbleResMgr = f282508v;
        if (scribbleResMgr != null) {
            return scribbleResMgr;
        }
        synchronized (f282509w) {
            ScribbleResMgr scribbleResMgr2 = f282508v;
            if (scribbleResMgr2 != null) {
                return scribbleResMgr2;
            }
            ScribbleResMgr scribbleResMgr3 = new ScribbleResMgr();
            f282508v = scribbleResMgr3;
            return scribbleResMgr3;
        }
    }

    private void N(QQAppInterface qQAppInterface) {
        if (!this.f282510g) {
            long currentTimeMillis = System.currentTimeMillis();
            QLog.i("ScribbleResMgr", 2, "init=======================timenow:" + currentTimeMillis);
            String u16 = ea.u1(qQAppInterface.getApp().getApplicationContext());
            String s16 = ea.s1(qQAppInterface.getApp().getApplicationContext());
            if (!TextUtils.isEmpty(u16)) {
                P(u16);
            }
            if (!TextUtils.isEmpty(s16)) {
                O(s16);
            }
            this.f282510g = true;
            long currentTimeMillis2 = System.currentTimeMillis();
            QLog.i("ScribbleResMgr", 2, "init=======================timenow:" + currentTimeMillis2);
            QLog.i("ScribbleResMgr", 2, "init==========================timedec:" + (currentTimeMillis2 - currentTimeMillis));
        }
    }

    private boolean O(String str) {
        JSONArray jSONArray = null;
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("iconUrl")) {
                this.f282520q = jSONObject.getString("iconUrl");
            }
            if (jSONObject.has("iconMd5")) {
                this.f282521r = jSONObject.getString("iconMd5");
            }
            if (jSONObject.has("content")) {
                jSONArray = jSONObject.getJSONArray("content");
            }
        } catch (JSONException e16) {
            e16.printStackTrace();
            QLog.e("ScribbleResMgr", 2, "RESOURCE_CONFIG_TASK_ID_Gif JSON EXCEPT");
        }
        R(I(jSONArray, 2));
        return true;
    }

    private boolean P(String str) {
        JSONArray jSONArray = null;
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("iconUrl")) {
                this.f282518o = jSONObject.getString("iconUrl");
            }
            if (jSONObject.has("iconMd5")) {
                this.f282519p = jSONObject.getString("iconMd5");
            }
            if (jSONObject.has("content")) {
                jSONArray = jSONObject.getJSONArray("content");
            }
        } catch (JSONException e16) {
            e16.printStackTrace();
            QLog.e("ScribbleResMgr", 2, "parsePaintConfigInfo JSON EXCEPT");
        }
        S(I(jSONArray, 1));
        return true;
    }

    private void R(ArrayList<com.tencent.mobileqq.scribble.c> arrayList) {
        if (arrayList != null && !arrayList.isEmpty()) {
            this.f282524u.lock();
            try {
                this.f282514k.clear();
                this.f282514k.addAll(arrayList);
                V(this.f282514k);
            } finally {
                this.f282524u.unlock();
            }
        }
    }

    private void S(ArrayList<com.tencent.mobileqq.scribble.c> arrayList) {
        if (arrayList != null && !arrayList.isEmpty()) {
            this.f282524u.lock();
            try {
                this.f282515l.clear();
                this.f282515l.addAll(arrayList);
                V(this.f282515l);
            } finally {
                this.f282524u.unlock();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void U(com.tencent.mobileqq.scribble.c cVar, int i3) {
        Message message = new Message();
        message.what = i3;
        message.obj = cVar;
        message.arg1 = cVar.f282546a;
        this.f282511h.sendMessageDelayed(message, 0L);
        E(cVar.f282546a, cVar.f282547b, false);
    }

    private void V(ArrayList<com.tencent.mobileqq.scribble.c> arrayList) {
        if (arrayList != null && arrayList.size() >= 2) {
            Collections.sort(arrayList, new b());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void W(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            String substring = str.substring(0, str.lastIndexOf(File.separator));
            if (TextUtils.isEmpty(substring)) {
                return;
            }
            File file = new File(substring);
            if (!file.exists()) {
                file.mkdirs();
            }
        } catch (Exception e16) {
            QLog.d("ScribbleResMgrdownloading", 2, "makedir execption: " + e16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0072, code lost:
    
        if (r1 != false) goto L42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x0124, code lost:
    
        if (r4 == false) goto L46;
     */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0078  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x001f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void o(QQAppInterface qQAppInterface, int i3, int i16) {
        boolean z16;
        boolean z17;
        N(qQAppInterface);
        boolean z18 = false;
        if (i3 == 3) {
            if (TextUtils.isEmpty(this.f282518o)) {
                z16 = true;
                if (i3 == 4) {
                    if (TextUtils.isEmpty(this.f282520q)) {
                        z16 = true;
                    } else if (!this.f282516m) {
                        p(qQAppInterface, i3, 50L);
                    }
                }
                if (i3 == 1) {
                    if (!this.f282515l.isEmpty()) {
                        ArrayList<com.tencent.mobileqq.scribble.c> K = K();
                        if (K != null && K.size() > 0) {
                            Iterator<com.tencent.mobileqq.scribble.c> it = K.iterator();
                            while (it != null && it.hasNext()) {
                                com.tencent.mobileqq.scribble.c next = it.next();
                                if (next != null && next.f282547b == i16) {
                                    if (!next.f282552g) {
                                        next.f282552g = true;
                                        q(qQAppInterface, next, 50L, false);
                                    }
                                    z17 = true;
                                }
                            }
                        }
                        z17 = false;
                    }
                    z16 = true;
                }
                if (i3 == 2) {
                    if (!this.f282514k.isEmpty()) {
                        ArrayList<com.tencent.mobileqq.scribble.c> J = J();
                        if (J != null && J.size() > 0) {
                            Iterator<com.tencent.mobileqq.scribble.c> it5 = J.iterator();
                            while (true) {
                                if (it5 == null || !it5.hasNext()) {
                                    break;
                                }
                                com.tencent.mobileqq.scribble.c next2 = it5.next();
                                if (next2 != null && next2.f282547b == i16) {
                                    if (!next2.f282552g) {
                                        next2.f282552g = true;
                                        QLog.i("ScribbleResMgr", 2, "RESOURCE_TYPE_GIF threadId: " + Thread.currentThread().getId() + " inf.resType:  " + next2.f282546a + " resID: " + next2.f282547b + " downloading is false set true");
                                        q(qQAppInterface, next2, 0L, false);
                                    } else {
                                        QLog.i("ScribbleResMgr", 2, "RESOURCE_TYPE_GIF threadId: " + Thread.currentThread().getId() + " inf.resType:  " + next2.f282546a + " resID: " + next2.f282547b + "is downloading  ");
                                    }
                                    z18 = true;
                                }
                            }
                        }
                    }
                    z16 = true;
                }
                if (!z16 && !this.f282522s) {
                    this.f282522s = true;
                    ConfigServlet.s(qQAppInterface, qQAppInterface.getCurrentAccountUin());
                    return;
                }
            }
            if (!this.f282517n) {
                p(qQAppInterface, i3, 50L);
            }
        }
        z16 = false;
        if (i3 == 4) {
        }
        if (i3 == 1) {
        }
        if (i3 == 2) {
        }
        if (!z16) {
        }
    }

    private void p(QQAppInterface qQAppInterface, int i3, long j3) {
        this.f282512i.postDelayed(new Runnable(i3, qQAppInterface) { // from class: com.tencent.mobileqq.scribble.ScribbleResMgr.5
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ int f282530d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ QQAppInterface f282531e;

            /* compiled from: P */
            /* renamed from: com.tencent.mobileqq.scribble.ScribbleResMgr$5$a */
            /* loaded from: classes18.dex */
            class a implements INetEngineListener {
                static IPatchRedirector $redirector_;

                a() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) AnonymousClass5.this);
                    }
                }

                @Override // com.tencent.mobileqq.transfile.INetEngineListener
                public void onResp(NetResp netResp) {
                    String str;
                    String str2;
                    boolean z16;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    int i3 = 2;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this, (Object) netResp);
                        return;
                    }
                    QLog.i("ScribbleResMgr", 2, "DownloadResIcon onResp resp.mResult:  " + netResp.mResult);
                    int i16 = 4;
                    if (netResp.mResult == 0) {
                        AnonymousClass5 anonymousClass5 = AnonymousClass5.this;
                        String str3 = "";
                        if (anonymousClass5.f282530d == 3) {
                            str = ScribbleResMgr.this.z();
                            str2 = ScribbleResMgr.this.f282519p;
                        } else {
                            str = "";
                            str2 = str;
                        }
                        AnonymousClass5 anonymousClass52 = AnonymousClass5.this;
                        if (anonymousClass52.f282530d == 4) {
                            str = ScribbleResMgr.this.y();
                            str2 = ScribbleResMgr.this.f282521r;
                        }
                        String calcMd5 = FileUtils.calcMd5(str);
                        if (!TextUtils.isEmpty(calcMd5) && calcMd5.equalsIgnoreCase(str2)) {
                            String str4 = com.tencent.mobileqq.scribble.a.f282540a;
                            int unZipFolder = ZipUtils.unZipFolder(str, str4);
                            if (unZipFolder != 0) {
                                QLog.e("ScribbleResMgr", 2, "unZipFolder  failed, filepath=" + str + " destDir= " + str4 + " result: " + unZipFolder);
                                z16 = false;
                            } else {
                                z16 = true;
                            }
                            if (z16) {
                                i3 = 1;
                            }
                        } else {
                            if (calcMd5 == null) {
                                calcMd5 = "";
                            }
                            if (str2 != null) {
                                str3 = str2;
                            }
                            QLog.e("ScribbleResMgr", 2, "check wrong md5 =" + calcMd5 + " desMd5 = " + str3);
                        }
                    }
                    if (netResp.mResult != 3) {
                        i16 = i3;
                    }
                    com.tencent.mobileqq.scribble.c cVar = new com.tencent.mobileqq.scribble.c();
                    AnonymousClass5 anonymousClass53 = AnonymousClass5.this;
                    cVar.f282546a = anonymousClass53.f282530d;
                    cVar.f282547b = 0;
                    ScribbleResMgr.this.U(cVar, i16);
                }

                @Override // com.tencent.mobileqq.transfile.INetEngineListener
                public void onUpdateProgeress(NetReq netReq, long j3, long j16) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                        iPatchRedirector.redirect((short) 3, this, netReq, Long.valueOf(j3), Long.valueOf(j16));
                    }
                }
            }

            {
                this.f282530d = i3;
                this.f282531e = qQAppInterface;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, ScribbleResMgr.this, Integer.valueOf(i3), qQAppInterface);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                    ScribbleResMgr.this.E(this.f282530d, 0, true);
                    HttpNetReq httpNetReq = new HttpNetReq();
                    httpNetReq.mCallback = new a();
                    httpNetReq.mReqUrl = "";
                    httpNetReq.mHttpMethod = 0;
                    if (this.f282530d == 3) {
                        httpNetReq.mReqUrl = ScribbleResMgr.this.f282518o;
                        httpNetReq.mOutPath = ScribbleResMgr.this.z();
                    }
                    if (this.f282530d == 4) {
                        httpNetReq.mReqUrl = ScribbleResMgr.this.f282520q;
                        httpNetReq.mOutPath = ScribbleResMgr.this.y();
                    }
                    httpNetReq.mContinuErrorLimit = NetworkUtil.getConnRetryTimes(NetworkCenter.getInstance().getNetType());
                    ((IHttpEngineService) this.f282531e.getRuntimeService(IHttpEngineService.class, "all")).sendReq(httpNetReq);
                    if (QLog.isColorLevel()) {
                        QLog.i("ScribbleResMgrdownloading", 2, "startDownloadhttpscribbleRes, url: " + httpNetReq.mReqUrl);
                        return;
                    }
                    return;
                }
                iPatchRedirector.redirect((short) 2, (Object) this);
            }
        }, j3);
    }

    private void q(QQAppInterface qQAppInterface, com.tencent.mobileqq.scribble.c cVar, long j3, boolean z16) {
        String str;
        if (cVar == null) {
            return;
        }
        Runnable runnable = new Runnable(cVar) { // from class: com.tencent.mobileqq.scribble.ScribbleResMgr.4
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ com.tencent.mobileqq.scribble.c f282528d;

            /* compiled from: P */
            /* renamed from: com.tencent.mobileqq.scribble.ScribbleResMgr$4$a */
            /* loaded from: classes18.dex */
            class a implements INetEngineListener {
                static IPatchRedirector $redirector_;

                a() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) AnonymousClass4.this);
                    }
                }

                @Override // com.tencent.mobileqq.transfile.INetEngineListener
                public void onResp(NetResp netResp) {
                    String str;
                    boolean z16;
                    String v3;
                    int unZipFolder;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    int i3 = 2;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this, (Object) netResp);
                        return;
                    }
                    if (QLog.isColorLevel()) {
                        QLog.i("ScribbleResMgr", 2, "onResp  mResult: " + netResp.mResult + " url:" + AnonymousClass4.this.f282528d.f282548c);
                    }
                    if (netResp.mResult == 0) {
                        com.tencent.mobileqq.scribble.c cVar = AnonymousClass4.this.f282528d;
                        int i16 = cVar.f282546a;
                        String str2 = "";
                        if (i16 != 1) {
                            str = "";
                        } else {
                            str = ScribbleResMgr.u(i16, cVar.f282547b);
                        }
                        com.tencent.mobileqq.scribble.c cVar2 = AnonymousClass4.this.f282528d;
                        if (cVar2.f282546a == 2) {
                            str = ScribbleResMgr.w(cVar2.f282547b);
                        }
                        String str3 = AnonymousClass4.this.f282528d.f282549d;
                        String calcMd5 = FileUtils.calcMd5(str);
                        if (!TextUtils.isEmpty(calcMd5) && calcMd5.equalsIgnoreCase(str3)) {
                            com.tencent.mobileqq.scribble.c cVar3 = AnonymousClass4.this.f282528d;
                            if (cVar3.f282546a == 2 && (unZipFolder = ZipUtils.unZipFolder(str, (v3 = ScribbleResMgr.v(cVar3.f282547b)))) != 0) {
                                QLog.e("ScribbleResMgr", 2, "unzip failed, filepath=" + str + " destDir= " + v3 + " result: " + unZipFolder);
                                z16 = false;
                            } else {
                                z16 = true;
                            }
                            if (z16) {
                                i3 = 1;
                            }
                        } else {
                            if (calcMd5 == null) {
                                calcMd5 = "";
                            }
                            if (str3 != null) {
                                str2 = str3;
                            }
                            QLog.e("ScribbleResMgr", 2, "onResp url: " + AnonymousClass4.this.f282528d.f282548c + "check wrong md5 =" + calcMd5 + " desMd5 = " + str2);
                        }
                        IPreDownloadController iPreDownloadController = (IPreDownloadController) ((QQAppInterface) BaseApplicationImpl.getApplication().getRuntime()).getRuntimeService(IPreDownloadController.class);
                        if (iPreDownloadController.isEnable()) {
                            iPreDownloadController.preDownloadSuccess(AnonymousClass4.this.f282528d.f282548c, netResp.mTotalFileLen);
                        }
                    }
                    if (netResp.mResult == 3) {
                        i3 = 4;
                    }
                    AnonymousClass4 anonymousClass4 = AnonymousClass4.this;
                    ScribbleResMgr.this.U(anonymousClass4.f282528d, i3);
                }

                @Override // com.tencent.mobileqq.transfile.INetEngineListener
                public void onUpdateProgeress(NetReq netReq, long j3, long j16) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                        iPatchRedirector.redirect((short) 3, this, netReq, Long.valueOf(j3), Long.valueOf(j16));
                    }
                }
            }

            {
                this.f282528d = cVar;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) ScribbleResMgr.this, (Object) cVar);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                QQAppInterface qQAppInterface2 = (QQAppInterface) BaseApplicationImpl.getApplication().getRuntime();
                com.tencent.mobileqq.scribble.c cVar2 = this.f282528d;
                String u16 = ScribbleResMgr.u(cVar2.f282546a, cVar2.f282547b);
                if (FileUtils.fileExists(u16)) {
                    if (QLog.isColorLevel()) {
                        QLog.d("ScribbleResMgr", 2, "res exist, return:" + this.f282528d.f282547b + " " + this.f282528d.f282546a + " file:" + u16 + " url:" + this.f282528d.f282548c);
                    }
                    IPreDownloadController iPreDownloadController = (IPreDownloadController) qQAppInterface2.getRuntimeService(IPreDownloadController.class);
                    if (iPreDownloadController.isEnable()) {
                        iPreDownloadController.preDownloadSuccess(this.f282528d.f282548c, FileUtils.getFileOrFolderSize(u16));
                    }
                    ScribbleResMgr.this.U(this.f282528d, 1);
                    return;
                }
                ScribbleResMgr scribbleResMgr = ScribbleResMgr.this;
                com.tencent.mobileqq.scribble.c cVar3 = this.f282528d;
                scribbleResMgr.E(cVar3.f282546a, cVar3.f282547b, true);
                HttpNetReq httpNetReq = new HttpNetReq();
                httpNetReq.mCallback = new a();
                com.tencent.mobileqq.scribble.c cVar4 = this.f282528d;
                httpNetReq.mReqUrl = cVar4.f282548c;
                httpNetReq.mHttpMethod = 0;
                int i3 = cVar4.f282546a;
                if (i3 == 1) {
                    httpNetReq.mOutPath = ScribbleResMgr.u(i3, cVar4.f282547b);
                }
                com.tencent.mobileqq.scribble.c cVar5 = this.f282528d;
                if (cVar5.f282546a == 2) {
                    httpNetReq.mOutPath = ScribbleResMgr.w(cVar5.f282547b);
                }
                ScribbleResMgr.this.W(httpNetReq.mOutPath);
                httpNetReq.mContinuErrorLimit = NetworkUtil.getConnRetryTimes(NetworkCenter.getInstance().getNetType());
                ((IHttpEngineService) qQAppInterface2.getRuntimeService(IHttpEngineService.class, "all")).sendReq(httpNetReq);
                if (QLog.isColorLevel()) {
                    QLog.i("ScribbleResMgrdownloading", 2, "starthttpDownloadscribbleRes, url: " + this.f282528d.f282548c);
                }
            }
        };
        if (z16) {
            IPreDownloadController iPreDownloadController = (IPreDownloadController) qQAppInterface.getRuntimeService(IPreDownloadController.class);
            if (iPreDownloadController.isEnable()) {
                int i3 = cVar.f282546a;
                if (i3 == 1) {
                    str = u(i3, cVar.f282547b);
                } else {
                    str = null;
                }
                if (cVar.f282546a == 2) {
                    str = w(cVar.f282547b);
                }
                String str2 = str;
                if (QLog.isColorLevel()) {
                    QLog.d("ScribbleResMgr", 2, "download res, predownload enable:" + cVar.f282547b + " " + cVar.f282546a + " outpath:" + str2 + " url:" + cVar.f282548c);
                }
                iPreDownloadController.requestPreDownload(10068, PreDownloadConstants.DEPARTMENT_PRD, String.valueOf(cVar.f282547b), 0, cVar.f282548c, str2, 2, 0, true, new RunnableTask(qQAppInterface, "doodle_msg_res", runnable, 4000L));
                return;
            }
        }
        IPreDownloadController iPreDownloadController2 = (IPreDownloadController) qQAppInterface.getRuntimeService(IPreDownloadController.class);
        if (iPreDownloadController2.isEnable()) {
            iPreDownloadController2.cancelPreDownload(cVar.f282548c);
            if (QLog.isColorLevel()) {
                QLog.d("ScribbleResMgr", 2, "download res, cancel predownload reqeust Url:" + cVar.f282548c);
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d("ScribbleResMgr", 2, "download res, normal download:" + cVar.f282547b + " " + cVar.f282546a + " Url:" + cVar.f282548c);
        }
        this.f282512i.postDelayed(runnable, j3);
    }

    public static String t(int i3, int i16) {
        if (i3 == 1) {
            return com.tencent.mobileqq.scribble.a.f282543d + "line_icon_" + String.valueOf(i16) + ".png";
        }
        if (i3 == 2) {
            return com.tencent.mobileqq.scribble.a.f282544e + "gif_icon_" + String.valueOf(i16) + ".png";
        }
        return null;
    }

    public static String u(int i3, int i16) {
        if (i3 == 1) {
            return com.tencent.mobileqq.scribble.a.f282541b + "line_orig_" + String.valueOf(i16) + ".png";
        }
        if (i3 == 2) {
            return x(i16);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String v(int i3) {
        return com.tencent.mobileqq.scribble.a.f282542c + "gif_zip_tmp" + String.valueOf(i3) + "/";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String w(int i3) {
        return v(i3) + "gif_zip_tmp" + String.valueOf(i3);
    }

    private static String x(int i3) {
        return v(i3) + "gif_orig_" + String.valueOf(i3) + QzoneEmotionUtils.SIGN_ICON_URL_END;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String y() {
        return AppConstants.SCRIBBLE_FILE_DIR + "gif_icon";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String z() {
        return AppConstants.SCRIBBLE_FILE_DIR + "paint_icon";
    }

    public void F(QQAppInterface qQAppInterface, int i3, int i16, View view, com.tencent.mobileqq.scribble.b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, qQAppInterface, Integer.valueOf(i3), Integer.valueOf(i16), view, bVar);
        } else {
            G(i3, i16, view, bVar);
            this.f282512i.post(new Runnable(qQAppInterface, i3, i16) { // from class: com.tencent.mobileqq.scribble.ScribbleResMgr.2
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ QQAppInterface f282525d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ int f282526e;

                /* renamed from: f, reason: collision with root package name */
                final /* synthetic */ int f282527f;

                {
                    this.f282525d = qQAppInterface;
                    this.f282526e = i3;
                    this.f282527f = i16;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, ScribbleResMgr.this, qQAppInterface, Integer.valueOf(i3), Integer.valueOf(i16));
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                        ScribbleResMgr.this.o(this.f282525d, this.f282526e, this.f282527f);
                    } else {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                }
            });
        }
    }

    public boolean M(String str, QQAppInterface qQAppInterface, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z16 = true;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, this, str, qQAppInterface, Integer.valueOf(i3))).booleanValue();
        }
        if (i3 == 2598) {
            z16 = B(qQAppInterface, str);
        }
        if (i3 == 2599) {
            z16 = A(qQAppInterface, str);
        }
        if (!z16) {
            D();
        }
        return z16;
    }

    public void Q() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        D();
        T();
        QLog.e("ScribbleResMgr", 2, "onGetConfigFailed");
    }

    public void T() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        } else {
            this.f282522s = false;
            QLog.d("ScribbleResMgr", 2, "setGetConfigFinished");
        }
    }

    public ArrayList<Integer> r(QQAppInterface qQAppInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (ArrayList) iPatchRedirector.redirect((short) 4, (Object) this, (Object) qQAppInterface);
        }
        N(qQAppInterface);
        ArrayList<Integer> arrayList = new ArrayList<>();
        this.f282524u.lock();
        try {
            ArrayList<com.tencent.mobileqq.scribble.c> arrayList2 = this.f282514k;
            if (arrayList2 != null && arrayList2.size() > 0) {
                Iterator<com.tencent.mobileqq.scribble.c> it = this.f282514k.iterator();
                while (it.hasNext()) {
                    com.tencent.mobileqq.scribble.c next = it.next();
                    if (next.f282546a == 2 && next.f282553h == 1 && (next.f282554i & 2) > 0) {
                        arrayList.add(Integer.valueOf(next.f282547b));
                    }
                }
            }
            return arrayList;
        } finally {
            this.f282524u.unlock();
        }
    }

    public ArrayList<Integer> s(QQAppInterface qQAppInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (ArrayList) iPatchRedirector.redirect((short) 3, (Object) this, (Object) qQAppInterface);
        }
        N(qQAppInterface);
        ArrayList<Integer> arrayList = new ArrayList<>();
        this.f282524u.lock();
        try {
            ArrayList<com.tencent.mobileqq.scribble.c> arrayList2 = this.f282515l;
            if (arrayList2 != null && arrayList2.size() > 0) {
                Iterator<com.tencent.mobileqq.scribble.c> it = this.f282515l.iterator();
                while (it.hasNext()) {
                    com.tencent.mobileqq.scribble.c next = it.next();
                    if (next.f282546a == 1 && next.f282553h == 1 && (next.f282554i & 2) > 0) {
                        arrayList.add(Integer.valueOf(next.f282547b));
                    }
                }
            }
            return arrayList;
        } finally {
            this.f282524u.unlock();
        }
    }
}
