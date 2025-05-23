package com.tencent.mobileqq.theme.ListenTogetherTheme;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.View;
import android.widget.ImageView;
import com.tencent.cache.api.Business;
import com.tencent.cache.api.g;
import com.tencent.cache.api.util.ImageCacheHelper;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.theme.BaseConstantState;
import com.tencent.theme.ResourcesFactory;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;

/* compiled from: P */
/* loaded from: classes18.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    protected String f292811a;

    /* renamed from: b, reason: collision with root package name */
    protected volatile boolean f292812b;

    /* renamed from: c, reason: collision with root package name */
    protected volatile boolean f292813c;

    /* renamed from: d, reason: collision with root package name */
    private final Object f292814d;

    /* renamed from: e, reason: collision with root package name */
    private TypedValue f292815e;

    /* renamed from: f, reason: collision with root package name */
    protected WeakReference<InterfaceC8646a> f292816f;

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.theme.ListenTogetherTheme.a$a, reason: collision with other inner class name */
    /* loaded from: classes18.dex */
    public interface InterfaceC8646a {
        void c();
    }

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f292811a = "";
        this.f292812b = false;
        this.f292813c = false;
        this.f292814d = new Object();
        this.f292815e = new TypedValue();
    }

    private Object a(String str) {
        Object g16 = ImageCacheHelper.f98636a.g(str);
        if (g16 instanceof g) {
            return ((g) g16).b();
        }
        return null;
    }

    private TypedValue d() {
        TypedValue typedValue;
        synchronized (this.f292814d) {
            typedValue = this.f292815e;
            if (typedValue != null) {
                this.f292815e = null;
            } else {
                typedValue = null;
            }
        }
        if (typedValue == null) {
            return new TypedValue();
        }
        return typedValue;
    }

    private void e(String str, Drawable drawable) {
        ImageCacheHelper.f98636a.i(str, new g(drawable, drawable.getIntrinsicHeight() * drawable.getIntrinsicWidth() * 4), Business.AIO);
    }

    private void f(TypedValue typedValue) {
        synchronized (this.f292814d) {
            if (this.f292815e == null) {
                this.f292815e = typedValue;
            }
        }
    }

    /* JADX WARN: Not initialized variable reg: 8, insn: 0x00f9: MOVE (r12 I:??[OBJECT, ARRAY]) = (r8 I:??[OBJECT, ARRAY]) (LINE:250), block:B:65:0x00f9 */
    protected Drawable b(Context context, int i3, String str) {
        InputStream inputStream;
        BufferedInputStream bufferedInputStream;
        OutOfMemoryError e16;
        IOException e17;
        BaseConstantState createImageFromResourceStream;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return (Drawable) iPatchRedirector.redirect((short) 17, this, context, Integer.valueOf(i3), str);
        }
        if (c() && !TextUtils.isEmpty(this.f292811a)) {
            Object a16 = a(this.f292811a + i3);
            if (a16 != null && (a16 instanceof Drawable)) {
                return (Drawable) a16;
            }
            TypedValue d16 = d();
            context.getResources().getValue(i3, d16, true);
            String str2 = (String) d16.string;
            f(d16);
            if (str2 != null) {
                File file = new File(this.f292811a + "/" + str);
                if (file.exists()) {
                    Rect rect = new Rect();
                    InputStream inputStream2 = null;
                    try {
                        try {
                            try {
                                bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
                            } catch (IOException e18) {
                                bufferedInputStream = null;
                                e17 = e18;
                            } catch (OutOfMemoryError e19) {
                                bufferedInputStream = null;
                                e16 = e19;
                            } catch (Throwable th5) {
                                th = th5;
                                if (inputStream2 != null) {
                                    try {
                                        inputStream2.close();
                                    } catch (IOException e26) {
                                        e26.printStackTrace();
                                    }
                                }
                                throw th;
                            }
                            try {
                                d16.density = 480;
                                createImageFromResourceStream = ResourcesFactory.createImageFromResourceStream(context.getResources(), d16, bufferedInputStream, str2, null, rect, true);
                            } catch (IOException e27) {
                                e17 = e27;
                                e17.printStackTrace();
                                if (bufferedInputStream != null) {
                                    bufferedInputStream.close();
                                }
                                return context.getResources().getDrawable(i3);
                            } catch (OutOfMemoryError e28) {
                                e16 = e28;
                                e16.printStackTrace();
                                if (bufferedInputStream != null) {
                                    bufferedInputStream.close();
                                }
                                return context.getResources().getDrawable(i3);
                            }
                            if (createImageFromResourceStream != null) {
                                Drawable newDrawable = createImageFromResourceStream.newDrawable(context.getResources());
                                e(this.f292811a + i3, newDrawable);
                                try {
                                    bufferedInputStream.close();
                                } catch (IOException e29) {
                                    e29.printStackTrace();
                                }
                                return newDrawable;
                            }
                            bufferedInputStream.close();
                        } catch (IOException e36) {
                            e36.printStackTrace();
                        }
                    } catch (Throwable th6) {
                        th = th6;
                        inputStream2 = inputStream;
                    }
                }
            }
            return context.getResources().getDrawable(i3);
        }
        return context.getResources().getDrawable(i3);
    }

    public boolean c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Boolean) iPatchRedirector.redirect((short) 13, (Object) this)).booleanValue();
        }
        if (this.f292812b && this.f292813c) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void g(View view, int i3, int i16, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, view, Integer.valueOf(i3), Integer.valueOf(i16), str);
            return;
        }
        View findViewById = view.findViewById(i3);
        if (findViewById != null) {
            findViewById.setBackgroundDrawable(b(findViewById.getContext(), i16, str));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void h(View view, int i3, int i16, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, view, Integer.valueOf(i3), Integer.valueOf(i16), str);
            return;
        }
        View findViewById = view.findViewById(i3);
        if (findViewById instanceof ImageView) {
            ((ImageView) findViewById).setImageDrawable(b(view.getContext(), i16, str));
        }
    }

    public void i(InterfaceC8646a interfaceC8646a) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) interfaceC8646a);
        } else {
            if (interfaceC8646a == null) {
                return;
            }
            this.f292816f = new WeakReference<>(interfaceC8646a);
        }
    }

    public void j(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
        } else {
            this.f292811a = str;
        }
    }
}
