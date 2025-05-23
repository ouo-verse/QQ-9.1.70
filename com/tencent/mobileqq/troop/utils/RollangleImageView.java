package com.tencent.mobileqq.troop.utils;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.tencent.cache.api.Business;
import com.tencent.cache.api.util.ImageCacheHelper;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.perf.block.LockMethodProxy;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.troop.utils.RollangleImageView;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.LinkedList;

/* compiled from: P */
/* loaded from: classes19.dex */
public class RollangleImageView extends ImageView {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    public String f301850d;

    /* renamed from: e, reason: collision with root package name */
    public String f301851e;

    /* renamed from: f, reason: collision with root package name */
    b f301852f;

    /* renamed from: h, reason: collision with root package name */
    boolean f301853h;

    /* compiled from: P */
    /* loaded from: classes19.dex */
    public static class a {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        private static a f301854d;

        /* renamed from: a, reason: collision with root package name */
        private LinkedList<b> f301855a;

        /* renamed from: b, reason: collision with root package name */
        public boolean f301856b;

        /* renamed from: c, reason: collision with root package name */
        private Handler f301857c;

        /* compiled from: P */
        /* renamed from: com.tencent.mobileqq.troop.utils.RollangleImageView$a$a, reason: collision with other inner class name */
        /* loaded from: classes19.dex */
        class HandlerC8835a extends Handler {
            static IPatchRedirector $redirector_;

            HandlerC8835a(Looper looper) {
                super(looper);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) a.this, (Object) looper);
                }
            }

            @Override // android.os.Handler
            public void handleMessage(Message message) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) message);
                    return;
                }
                super.handleMessage(message);
                if (a.this.f301856b) {
                    return;
                }
                Object[] objArr = (Object[]) message.obj;
                RollangleImageView rollangleImageView = (RollangleImageView) objArr[0];
                String str = (String) objArr[1];
                Bitmap bitmap = (Bitmap) objArr[2];
                if (rollangleImageView != null && str != null && bitmap != null && str.equals(rollangleImageView.f301851e)) {
                    rollangleImageView.setImageBitmap(bitmap);
                }
            }
        }

        /* compiled from: P */
        /* loaded from: classes19.dex */
        public static class b {
            static IPatchRedirector $redirector_;

            /* renamed from: a, reason: collision with root package name */
            public String f301859a;

            /* renamed from: b, reason: collision with root package name */
            public RollangleImageView f301860b;

            public b() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this);
                }
            }
        }

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            } else {
                this.f301856b = false;
                this.f301857c = new HandlerC8835a(BaseApplication.getContext().getMainLooper());
            }
        }

        public static a f() {
            if (f301854d == null) {
                f301854d = new a();
            }
            return f301854d;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void g() {
            b bVar = null;
            while (!this.f301856b) {
                try {
                    LockMethodProxy.sleep(100L);
                } catch (InterruptedException unused) {
                }
                synchronized (this) {
                    LinkedList<b> linkedList = this.f301855a;
                    if (linkedList == null) {
                        return;
                    }
                    if (bVar != null) {
                        linkedList.poll();
                    }
                    if (this.f301855a.isEmpty()) {
                        return;
                    } else {
                        bVar = this.f301855a.peek();
                    }
                }
                Bitmap b16 = RollangleImageView.b(bVar.f301859a);
                if (b16 != null) {
                    ImageCacheHelper.f98636a.i("troopfileimage://" + bVar.f301859a, b16, Business.AIO);
                    this.f301857c.obtainMessage(0, new Object[]{bVar.f301860b, bVar.f301859a, b16}).sendToTarget();
                }
            }
        }

        public synchronized void b(boolean z16) {
            LinkedList<b> linkedList;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, z16);
                return;
            }
            if (z16 && (linkedList = this.f301855a) != null) {
                linkedList.clear();
            }
            this.f301856b = z16;
        }

        public synchronized void c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this);
                return;
            }
            LinkedList<b> linkedList = this.f301855a;
            if (linkedList == null) {
                return;
            }
            linkedList.clear();
            this.f301855a = null;
        }

        public synchronized Bitmap d(String str, RollangleImageView rollangleImageView) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (Bitmap) iPatchRedirector.redirect((short) 4, (Object) this, (Object) str, (Object) rollangleImageView);
            }
            return ImageCacheHelper.f98636a.f("troopfileimage://" + str);
        }

        public synchronized Bitmap e(String str, RollangleImageView rollangleImageView) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return (Bitmap) iPatchRedirector.redirect((short) 5, (Object) this, (Object) str, (Object) rollangleImageView);
            }
            Bitmap f16 = ImageCacheHelper.f98636a.f("troopfileimage://" + str);
            if (f16 != null) {
                return f16;
            }
            if (this.f301855a == null) {
                this.f301855a = new LinkedList<>();
            }
            if (this.f301855a.isEmpty()) {
                ThreadManagerV2.post(new Runnable() { // from class: com.tencent.mobileqq.troop.utils.l
                    @Override // java.lang.Runnable
                    public final void run() {
                        RollangleImageView.a.this.g();
                    }
                }, 5, null, true);
            }
            b bVar = new b();
            bVar.f301860b = rollangleImageView;
            bVar.f301859a = str;
            this.f301855a.add(bVar);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes19.dex */
    public static class b extends AsyncTask<Boolean, Void, Bitmap> {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        private WeakReference<RollangleImageView> f301861a;

        public b(RollangleImageView rollangleImageView) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) rollangleImageView);
            } else {
                this.f301861a = new WeakReference<>(rollangleImageView);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Bitmap doInBackground(Boolean... boolArr) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (Bitmap) iPatchRedirector.redirect((short) 2, (Object) this, (Object) boolArr);
            }
            RollangleImageView rollangleImageView = this.f301861a.get();
            if (rollangleImageView != null) {
                return rollangleImageView.c(boolArr[0].booleanValue());
            }
            return null;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(Bitmap bitmap) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) bitmap);
                return;
            }
            RollangleImageView rollangleImageView = this.f301861a.get();
            if (rollangleImageView != null) {
                if (bitmap != null) {
                    rollangleImageView.setImageBitmap(bitmap);
                } else {
                    rollangleImageView.setImageResource(FileManagerUtil.getFileIconResId(rollangleImageView.f301850d));
                }
            }
        }
    }

    public RollangleImageView(Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
        } else {
            this.f301852f = null;
            this.f301853h = false;
        }
    }

    public static Bitmap b(String str) {
        int width;
        int height;
        int max;
        ImageCacheHelper imageCacheHelper = ImageCacheHelper.f98636a;
        Bitmap f16 = imageCacheHelper.f("troopfilerollangleimage://");
        Bitmap f17 = imageCacheHelper.f("troopfilerollangleimageborder://");
        if (f16 == null || f17 == null) {
            Resources resources = BaseApplication.getContext().getResources();
            if (f16 == null) {
                try {
                    f16 = BitmapFactory.decodeResource(resources, R.drawable.bru);
                    imageCacheHelper.i("troopfilerollangleimage://", f16, Business.AIO);
                } catch (OutOfMemoryError unused) {
                    if (QLog.isColorLevel()) {
                        QLog.e("RollangleImageView", 4, "decode maskBmp borderBmp OutOfMemoryError error");
                    }
                    return null;
                }
            }
            if (f17 == null) {
                Bitmap decodeResource = BitmapFactory.decodeResource(resources, R.drawable.brt);
                imageCacheHelper.i("troopfilerollangleimageborder://", decodeResource, Business.AIO);
                f17 = decodeResource;
            }
        }
        try {
            Bitmap decodeFileWithBufferedStream = BaseImageUtil.decodeFileWithBufferedStream(str, BaseImageUtil.calculateInSampleSize(new BitmapFactory.Options(), str, 128));
            if (decodeFileWithBufferedStream == null || (max = Math.max((width = decodeFileWithBufferedStream.getWidth()), (height = decodeFileWithBufferedStream.getHeight()))) <= 0) {
                return null;
            }
            Rect rect = new Rect(0, 0, max, max);
            try {
                Bitmap createBitmap = Bitmap.createBitmap(max, max, Bitmap.Config.ARGB_8888);
                Canvas canvas = new Canvas(createBitmap);
                Paint paint = new Paint();
                paint.setAntiAlias(true);
                canvas.drawBitmap(f16, new Rect(0, 0, f16.getWidth(), f16.getHeight()), rect, paint);
                Rect rect2 = new Rect();
                int i3 = (max - width) / 2;
                rect2.left = i3;
                int i16 = (max - height) / 2;
                rect2.top = i16;
                rect2.right = i3 + width;
                rect2.bottom = i16 + height;
                Rect rect3 = new Rect(0, 0, width, height);
                paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
                canvas.drawBitmap(decodeFileWithBufferedStream, rect3, rect2, paint);
                Rect rect4 = new Rect(0, 0, f17.getWidth(), f17.getHeight());
                paint.setXfermode(null);
                canvas.drawBitmap(f17, rect4, rect, paint);
                decodeFileWithBufferedStream.recycle();
                return createBitmap;
            } catch (OutOfMemoryError unused2) {
                if (QLog.isColorLevel()) {
                    QLog.e("RollangleImageView", 2, "generateRollAngleThumb, rollAngleBmp, OutOfMemoryError");
                }
                return null;
            }
        } catch (OutOfMemoryError unused3) {
            if (QLog.isColorLevel()) {
                QLog.e("RollangleImageView", 4, "decode srcBmp OutOfMemoryError error");
            }
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Bitmap c(boolean z16) {
        if (!TextUtils.isEmpty(this.f301851e)) {
            if (z16) {
                return a.f().e(this.f301851e, this);
            }
            return a.f().d(this.f301851e, this);
        }
        return null;
    }

    public static void setSuspendLoad(boolean z16) {
        a.f().b(z16);
    }

    public void d(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, z16);
            return;
        }
        b bVar = this.f301852f;
        if (bVar != null) {
            bVar.cancel(true);
            this.f301852f = null;
        }
        b bVar2 = new b(this);
        this.f301852f = bVar2;
        bVar2.execute(Boolean.valueOf(z16));
    }

    public void setParams(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) str, (Object) str2);
            return;
        }
        if (TroopFileUtils.x(str, this.f301850d) && TroopFileUtils.x(str2, this.f301851e)) {
            return;
        }
        if (a.f().f301856b) {
            setParamsOnScrolling(str, str2);
            return;
        }
        this.f301850d = str;
        this.f301851e = str2;
        d(true);
    }

    public void setParamsOnScrolling(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) str, (Object) str2);
            return;
        }
        Bitmap d16 = a.f().d(str2, this);
        if (d16 == null) {
            setImageResource(FileManagerUtil.getFileIconResId(str));
            return;
        }
        this.f301850d = str;
        this.f301851e = str2;
        setImageBitmap(d16);
    }

    public RollangleImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
        } else {
            this.f301852f = null;
            this.f301853h = false;
        }
    }

    public RollangleImageView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, context, attributeSet, Integer.valueOf(i3));
        } else {
            this.f301852f = null;
            this.f301853h = false;
        }
    }
}
