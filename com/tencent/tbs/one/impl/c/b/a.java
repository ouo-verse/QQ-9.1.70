package com.tencent.tbs.one.impl.c.b;

import android.content.Context;
import android.util.AttributeSet;
import android.view.InflateException;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewStub;
import com.tencent.tbs.one.impl.a.g;
import java.lang.reflect.Constructor;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes26.dex */
public final class a extends LayoutInflater {

    /* renamed from: b, reason: collision with root package name */
    private static final StackTraceElement[] f374778b = new StackTraceElement[0];

    /* renamed from: c, reason: collision with root package name */
    private static final Class<?>[] f374779c = {Context.class, AttributeSet.class};

    /* renamed from: a, reason: collision with root package name */
    public ClassLoader f374780a;

    /* renamed from: d, reason: collision with root package name */
    private final Object[] f374781d;

    /* renamed from: e, reason: collision with root package name */
    private final HashMap<String, Constructor<? extends View>> f374782e;

    /* renamed from: f, reason: collision with root package name */
    private HashMap<String, Boolean> f374783f;

    /* JADX INFO: Access modifiers changed from: protected */
    public a(Context context) {
        super(context);
        this.f374781d = new Object[2];
        this.f374782e = new HashMap<>();
        a();
    }

    private void a() {
        try {
            setFactory2(new LayoutInflater.Factory2() { // from class: com.tencent.tbs.one.impl.c.b.a.1
                @Override // android.view.LayoutInflater.Factory
                public final View onCreateView(String str, Context context, AttributeSet attributeSet) {
                    return null;
                }

                @Override // android.view.LayoutInflater.Factory2
                public final View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
                    return a.this.a(str, attributeSet);
                }
            });
        } catch (Exception unused) {
            setFactory(new LayoutInflater.Factory() { // from class: com.tencent.tbs.one.impl.c.b.a.2
                @Override // android.view.LayoutInflater.Factory
                public final View onCreateView(String str, Context context, AttributeSet attributeSet) {
                    return a.this.a(str, attributeSet);
                }
            });
        }
    }

    private View b(String str, AttributeSet attributeSet) throws ClassNotFoundException, InflateException {
        String name;
        View newInstance;
        synchronized (this.f374781d) {
            boolean z16 = false;
            this.f374781d[0] = getContext();
            Constructor<? extends View> constructor = this.f374782e.get(str);
            Class<? extends View> cls = null;
            try {
                try {
                    LayoutInflater.Filter filter = getFilter();
                    if (constructor == null) {
                        cls = a(str);
                        if (filter != null && cls != null && !filter.onLoadClass(cls)) {
                            c(str, attributeSet);
                        }
                        constructor = cls.getConstructor(f374779c);
                        constructor.setAccessible(true);
                        this.f374782e.put(str, constructor);
                    } else if (filter != null) {
                        Boolean bool = this.f374783f.get(str);
                        if (bool == null) {
                            cls = a(str);
                            if (cls != null && filter.onLoadClass(cls)) {
                                z16 = true;
                            }
                            this.f374783f.put(str, Boolean.valueOf(z16));
                            if (!z16) {
                                c(str, attributeSet);
                            }
                        } else if (bool.equals(Boolean.FALSE)) {
                            c(str, attributeSet);
                        }
                    }
                    Object[] objArr = this.f374781d;
                    objArr[1] = attributeSet;
                    newInstance = constructor.newInstance(objArr);
                    if (newInstance instanceof ViewStub) {
                        ((ViewStub) newInstance).setLayoutInflater(this);
                    }
                } catch (ClassNotFoundException e16) {
                    throw e16;
                } catch (Exception unused) {
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append(attributeSet.getPositionDescription());
                    sb5.append(": Error inflating class ");
                    if (cls == null) {
                        name = "<unknown>";
                    } else {
                        name = cls.getName();
                    }
                    sb5.append(name);
                    InflateException inflateException = new InflateException(sb5.toString());
                    inflateException.setStackTrace(f374778b);
                    throw inflateException;
                }
            } catch (ClassCastException unused2) {
                InflateException inflateException2 = new InflateException(attributeSet.getPositionDescription() + ": Class is not a View " + str);
                inflateException2.setStackTrace(f374778b);
                throw inflateException2;
            } catch (NoSuchMethodException e17) {
                InflateException inflateException3 = new InflateException(attributeSet.getPositionDescription() + ": Error inflating class " + str, e17);
                inflateException3.setStackTrace(f374778b);
                throw inflateException3;
            }
        }
        return newInstance;
    }

    private static void c(String str, AttributeSet attributeSet) {
        throw new InflateException(attributeSet.getPositionDescription() + ": Class not allowed to be inflated " + str);
    }

    @Override // android.view.LayoutInflater
    public final LayoutInflater cloneInContext(Context context) {
        return new a(this, context);
    }

    @Override // android.view.LayoutInflater
    public final void setFilter(LayoutInflater.Filter filter) {
        super.setFilter(filter);
        if (filter != null) {
            this.f374783f = new HashMap<>();
        }
    }

    private Class<? extends View> a(String str) throws ClassNotFoundException {
        ClassLoader classLoader = this.f374780a;
        if (classLoader != null) {
            try {
                return classLoader.loadClass(str).asSubclass(View.class);
            } catch (ClassNotFoundException unused) {
            }
        }
        return a.class.getClassLoader().loadClass(str).asSubclass(View.class);
    }

    a(LayoutInflater layoutInflater, Context context) {
        super(layoutInflater, context);
        this.f374781d = new Object[2];
        this.f374782e = new HashMap<>();
        a();
    }

    /* JADX WARN: Removed duplicated region for block: B:16:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:5:0x0022 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final View a(String str, AttributeSet attributeSet) {
        View b16;
        View createView;
        if (-1 != str.indexOf(46)) {
            try {
                b16 = b(str, attributeSet);
            } catch (Throwable th5) {
                g.b("Failed to create view %s", str, th5);
            }
            if (b16 == null) {
                return b16;
            }
            try {
                if (-1 == str.indexOf(46)) {
                    createView = onCreateView(str, attributeSet);
                } else {
                    createView = createView(str, null, attributeSet);
                }
                return createView;
            } catch (Throwable th6) {
                g.b("Failed to create view %s", str, th6);
                return b16;
            }
        }
        b16 = null;
        if (b16 == null) {
        }
    }
}
