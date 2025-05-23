package com.tencent.smtt.sdk;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.widget.FrameLayout;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.smtt.export.external.DexLoader;
import com.tencent.smtt.sdk.TbsReaderView;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes23.dex */
public class f {

    /* renamed from: a, reason: collision with root package name */
    private DexLoader f369353a;

    /* renamed from: b, reason: collision with root package name */
    private TbsReaderView.ReaderCallback f369354b;

    public f(TbsReaderView.ReaderCallback readerCallback) {
        this.f369353a = null;
        this.f369354b = null;
        this.f369353a = b();
        this.f369354b = readerCallback;
    }

    public static boolean a(Context context) {
        DexLoader b16 = b();
        if (b16 == null) {
            return false;
        }
        Object invokeStaticMethod = b16.invokeStaticMethod("com.tencent.tbs.reader.TbsReader", "isSupportCurrentPlatform", new Class[]{Context.class}, context);
        if (invokeStaticMethod instanceof Boolean) {
            return ((Boolean) invokeStaticMethod).booleanValue();
        }
        return false;
    }

    public static String b(int i3) {
        DexLoader b16 = b();
        if (b16 != null) {
            Object invokeStaticMethod = b16.invokeStaticMethod("com.tencent.tbs.reader.TbsReader", "getResString", new Class[]{Integer.class}, Integer.valueOf(i3));
            if (invokeStaticMethod instanceof String) {
                return (String) invokeStaticMethod;
            }
        }
        return "";
    }

    public static boolean a(String str) {
        DexLoader b16 = b();
        if (b16 == null) {
            return false;
        }
        Object invokeStaticMethod = b16.invokeStaticMethod("com.tencent.tbs.reader.TbsReader", "isSupportExt", new Class[]{String.class}, str);
        if (invokeStaticMethod instanceof Boolean) {
            return ((Boolean) invokeStaticMethod).booleanValue();
        }
        return false;
    }

    private static DexLoader b() {
        o c16 = g.a(true).c();
        if (c16 != null) {
            return c16.c();
        }
        return null;
    }

    public static Drawable a(int i3) {
        DexLoader b16 = b();
        if (b16 != null) {
            Object invokeStaticMethod = b16.invokeStaticMethod("com.tencent.tbs.reader.TbsReader", "getResDrawable", new Class[]{Integer.class}, Integer.valueOf(i3));
            if (invokeStaticMethod instanceof Drawable) {
                return (Drawable) invokeStaticMethod;
            }
        }
        return null;
    }

    public Object a() {
        return this.f369353a.newInstance("com.tencent.tbs.reader.TbsReader", new Class[0], new Object[0]);
    }

    public boolean a(Object obj, Context context) {
        DexLoader dexLoader = this.f369353a;
        if (dexLoader != null && obj != null) {
            Object invokeMethod = dexLoader.invokeMethod(obj, "com.tencent.tbs.reader.TbsReader", "init", new Class[]{Context.class, DexLoader.class, Object.class}, context, dexLoader, this);
            if (!(invokeMethod instanceof Boolean)) {
                Log.e("ReaderWizard", "Unexpect return value type of call initTbsReader!");
                return false;
            }
            return ((Boolean) invokeMethod).booleanValue();
        }
        Log.e("ReaderWizard", "initTbsReader:Unexpect null object!");
        return false;
    }

    public boolean a(Object obj, Context context, String str, boolean z16) {
        DexLoader dexLoader = this.f369353a;
        if (dexLoader == null) {
            Log.e("ReaderWizard", "checkPlugin:Unexpect null object!");
            return false;
        }
        Object invokeMethod = dexLoader.invokeMethod(obj, "com.tencent.tbs.reader.TbsReader", "checkPlugin", new Class[]{Context.class, String.class, Boolean.class}, context, str, Boolean.valueOf(z16));
        if (!(invokeMethod instanceof Boolean)) {
            Log.e("ReaderWizard", "Unexpect return value type of call checkPlugin!");
            return false;
        }
        return ((Boolean) invokeMethod).booleanValue();
    }

    public boolean a(Object obj, Context context, Bundle bundle, FrameLayout frameLayout) {
        DexLoader dexLoader = this.f369353a;
        if (dexLoader == null) {
            Log.e("ReaderWizard", "openFile:Unexpect null object!");
            return false;
        }
        Object invokeMethod = dexLoader.invokeMethod(obj, "com.tencent.tbs.reader.TbsReader", "openFile", new Class[]{Context.class, Bundle.class, FrameLayout.class}, context, bundle, frameLayout);
        if (!(invokeMethod instanceof Boolean)) {
            Log.e("ReaderWizard", "Unexpect return value type of call openFile!");
            return false;
        }
        return ((Boolean) invokeMethod).booleanValue();
    }

    public void a(Object obj, int i3, int i16) {
        DexLoader dexLoader = this.f369353a;
        if (dexLoader == null) {
            Log.e("ReaderWizard", "onSizeChanged:Unexpect null object!");
        } else {
            dexLoader.invokeMethod(obj, "com.tencent.tbs.reader.TbsReader", MosaicConstants$JsFunction.FUNC_ON_SIZE_CHANGED, new Class[]{Integer.class, Integer.class}, new Integer(i3), new Integer(i16));
        }
    }

    public void a(Object obj, Integer num, Object obj2, Object obj3) {
        DexLoader dexLoader = this.f369353a;
        if (dexLoader == null) {
            Log.e("ReaderWizard", "doCommand:Unexpect null object!");
        } else {
            dexLoader.invokeMethod(obj, "com.tencent.tbs.reader.TbsReader", "doCommand", new Class[]{Integer.class, Object.class, Object.class}, new Integer(num.intValue()), obj2, obj3);
        }
    }

    public void a(Object obj) {
        this.f369354b = null;
        DexLoader dexLoader = this.f369353a;
        if (dexLoader != null && obj != null) {
            dexLoader.invokeMethod(obj, "com.tencent.tbs.reader.TbsReader", "destroy", new Class[0], new Object[0]);
        } else {
            Log.e("ReaderWizard", "destroy:Unexpect null object!");
        }
    }

    public void a(Object obj, String str) {
        DexLoader dexLoader = this.f369353a;
        if (dexLoader == null) {
            Log.e("ReaderWizard", "userStatistics:Unexpect null object!");
        } else {
            dexLoader.invokeMethod(obj, "com.tencent.tbs.reader.TbsReader", "userStatistics", new Class[]{String.class}, str);
        }
    }
}
