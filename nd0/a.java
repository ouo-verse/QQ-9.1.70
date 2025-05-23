package nd0;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.support.v4.util.LruCache;
import android.widget.ImageView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread;
import gd0.c;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Map;
import java.util.WeakHashMap;
import nd0.b;

/* compiled from: P */
/* loaded from: classes5.dex */
public abstract class a<T> implements Handler.Callback, b.a {
    public static final int D = 2131374577;

    /* renamed from: d, reason: collision with root package name */
    private HandlerThread f419945d;

    /* renamed from: e, reason: collision with root package name */
    private Handler f419946e;

    /* renamed from: h, reason: collision with root package name */
    private int f419948h = 1;

    /* renamed from: i, reason: collision with root package name */
    private boolean f419949i = false;

    /* renamed from: f, reason: collision with root package name */
    private Handler f419947f = new Handler(Looper.getMainLooper(), this);

    /* renamed from: m, reason: collision with root package name */
    private c f419950m = new c();
    private WeakHashMap<ImageView, Drawable> C = new WeakHashMap<>();

    public a(String str) {
        this.f419945d = new BaseHandlerThread("ImageLoader_" + str);
    }

    private void h(int i3, b bVar) {
        int i16 = this.f419948h;
        if (i16 == 0) {
            Handler handler = this.f419946e;
            handler.sendMessageAtFrontOfQueue(handler.obtainMessage(i3, bVar));
        } else if (i16 == 1) {
            Handler handler2 = this.f419946e;
            handler2.sendMessage(handler2.obtainMessage(i3, bVar));
        }
    }

    @Override // nd0.b.a
    public void a(b bVar) {
        Handler handler = this.f419947f;
        handler.sendMessage(handler.obtainMessage(3, bVar));
    }

    public void b(ImageView imageView, T t16) {
        c(imageView, t16, new ColorDrawable(-3289651), 0);
    }

    public void c(ImageView imageView, T t16, Drawable drawable, int i3) {
        gd0.a.a("Q.qqstory.newImageLoader", "attachView:", t16, " ----hash:", Integer.valueOf(imageView.hashCode()));
        this.C.remove(imageView);
        String obj = t16.toString();
        int i16 = D;
        if (obj.equals(imageView.getTag(i16))) {
            gd0.a.a("Q.qqstory.newImageLoader", "target have been set view,so dont need attach view");
            return;
        }
        b c16 = this.f419950m.c(imageView);
        if (c16 != null) {
            if (t16.equals(c16.f419952b)) {
                gd0.a.a("Q.qqstory.newImageLoader", "task running no need to do again:", c16.f419952b);
                return;
            } else {
                this.f419950m.d(imageView);
                gd0.a.a("Q.qqstory.newImageLoader", "cancel: ", c16.f419952b);
                c16.a();
            }
        }
        Drawable drawable2 = e().get(t16);
        if (drawable2 != null) {
            gd0.a.a("Q.qqstory.newImageLoader", "hit the cache:", t16);
            if (drawable2 instanceof BitmapDrawable) {
                Bitmap bitmap = ((BitmapDrawable) drawable2).getBitmap();
                if (bitmap != null) {
                    gd0.a.a("Q.qqstory.newImageLoader", "cache size=", Integer.valueOf(bitmap.getRowBytes() * bitmap.getHeight()), ",h=", Integer.valueOf(bitmap.getHeight()), ",w=", Integer.valueOf(bitmap.getWidth()), ",key=", t16);
                }
            } else {
                gd0.a.a("Q.qqstory.newImageLoader", "cache size=", 1024, ",key= ", t16);
            }
            if (this.f419949i && i3 == 0) {
                gd0.a.a("Q.qqstory.newImageLoader", "save to waiting queue:", t16);
                imageView.setImageDrawable(drawable);
                gd0.a.a("Q.qqstory.newImageLoader", "postToUI def o= ", imageView.getTag(i16), " and change to: ", t16.toString(), " view hash:" + imageView.hashCode());
                imageView.setTag(i16, null);
                this.C.put(imageView, drawable2);
                return;
            }
            imageView.setImageDrawable(drawable2);
            gd0.a.a("Q.qqstory.newImageLoader", "postToUI cache o= ", imageView.getTag(i16), " and change to: ", t16.toString(), " view hash:" + imageView.hashCode());
            imageView.setTag(i16, t16.toString());
            return;
        }
        imageView.setImageDrawable(drawable);
        gd0.a.a("Q.qqstory.newImageLoader", "postToUI def 2 o= ", imageView.getTag(i16), " and change to: ", t16.toString(), " view hash:" + imageView.hashCode());
        imageView.setTag(i16, null);
        b d16 = d(imageView, t16);
        if (d16 == null) {
            gd0.a.b("Q.qqstory.newImageLoader", "generateTask failed!!");
            return;
        }
        d16.f419951a = this;
        d16.f419956f = drawable;
        d16.f419953c = i3;
        d16.h(this);
        d16.f419952b = t16;
        gd0.a.c("Q.qqstory.newImageLoader", "this need request hash:", Integer.valueOf(imageView.hashCode()));
        this.f419950m.a(imageView, d16);
        if (!this.f419949i) {
            this.f419950m.e(d16);
            h(1, d16);
        }
    }

    public abstract b d(ImageView imageView, T t16);

    public abstract LruCache<T, Drawable> e();

    public void f() {
        this.f419945d.start();
        this.f419946e = new Handler(this.f419945d.getLooper(), this);
    }

    public void g() {
        this.f419946e.removeCallbacksAndMessages(null);
        HandlerThread handlerThread = this.f419945d;
        if (handlerThread != null) {
            try {
                handlerThread.quit();
            } catch (Exception unused) {
            }
        }
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        int i3 = message.what;
        char c16 = 1;
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    if (i3 != 4) {
                        if (i3 == 5 && this.f419950m.f() > 0) {
                            ListIterator<Map.Entry<b, WeakReference<ImageView>>> b16 = this.f419950m.b();
                            for (int i16 = 2; b16.hasPrevious() && i16 > 0; i16--) {
                                Map.Entry<b, WeakReference<ImageView>> previous = b16.previous();
                                b16.remove();
                                if (previous.getValue().get() != null) {
                                    this.f419947f.sendMessage(this.f419946e.obtainMessage(1, previous.getKey()));
                                } else {
                                    previous.getKey().a();
                                }
                            }
                        }
                        return true;
                    }
                    gd0.a.a("Q.qqstory.newImageLoader", "HANDLE_WAITING_UI_TASK");
                    if (this.f419949i) {
                        return true;
                    }
                    Iterator<Map.Entry<ImageView, Drawable>> it = this.C.entrySet().iterator();
                    int i17 = 3;
                    while (it.hasNext()) {
                        Map.Entry<ImageView, Drawable> next = it.next();
                        ImageView key = next.getKey();
                        if (key != null) {
                            key.setImageDrawable(next.getValue());
                            Object[] objArr = new Object[4];
                            objArr[0] = "postToUI o= ";
                            int i18 = D;
                            objArr[c16] = key.getTag(i18);
                            objArr[2] = " and change to: wait";
                            objArr[3] = " view hash:" + key.hashCode();
                            gd0.a.a("Q.qqstory.newImageLoader", objArr);
                            key.setTag(i18, null);
                            it.remove();
                        }
                        i17--;
                        if (i17 <= 0) {
                            break;
                        }
                        c16 = 1;
                    }
                    if (this.C.size() > 0) {
                        Handler handler = this.f419947f;
                        handler.sendMessageDelayed(handler.obtainMessage(4), 16L);
                    }
                } else {
                    b bVar = (b) message.obj;
                    gd0.a.b("Q.qqstory.newImageLoader", "EXECUTE_TASK_COMPLETED:", bVar.d());
                    if (!bVar.c()) {
                        gd0.a.b("Q.qqstory.newImageLoader", "EXECUTE_TASK_COMPLETED post ui:", bVar.d());
                        bVar.e(this.C, this.f419949i);
                        ImageView imageView = bVar.f419954d.get();
                        if (imageView != null) {
                            gd0.a.b("Q.qqstory.newImageLoader", "completed the request,hash: ", Integer.valueOf(imageView.hashCode()));
                            this.f419950m.d(imageView);
                        }
                        if (bVar.f419955e != null) {
                            e().put(bVar.f419952b, bVar.f419955e);
                        }
                    } else {
                        gd0.a.c("Q.qqstory.newImageLoader", "EXECUTE_TASK_COMPLETED have been cancel:", bVar.d());
                    }
                    bVar.f();
                    if (!this.f419949i) {
                        Handler handler2 = this.f419947f;
                        handler2.sendMessage(handler2.obtainMessage(5));
                    }
                }
            } else {
                b bVar2 = (b) message.obj;
                gd0.a.b("Q.qqstory.newImageLoader", "EXECUTE_TASK_ERROR:", bVar2.d());
                ImageView imageView2 = bVar2.f419954d.get();
                if (imageView2 != null) {
                    this.f419950m.d(imageView2);
                    imageView2.setImageDrawable(bVar2.f419956f);
                    int i19 = D;
                    gd0.a.a("Q.qqstory.newImageLoader", "postToUI o= ", imageView2.getTag(i19), " and change to: default", " view hash:" + imageView2.hashCode());
                    imageView2.setTag(i19, null);
                }
                bVar2.f();
            }
        } else {
            b bVar3 = (b) message.obj;
            if (!bVar3.c()) {
                bVar3.g();
            } else {
                gd0.a.c("Q.qqstory.newImageLoader", HardCodeUtil.qqStr(R.string.nec), bVar3.d());
                bVar3.f();
                return true;
            }
        }
        return true;
    }
}
