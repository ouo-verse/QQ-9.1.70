package com.tencent.ecommerce.biz.hr.adapter;

import android.graphics.Typeface;
import android.util.DisplayMetrics;
import com.tencent.ecommerce.base.QQEcommerceSdk;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0011\u0010\u0012J&\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0014\u0010\u0007\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0012\u0004\u0012\u00020\u00060\u0004H\u0016J\u0010\u0010\u000b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0016J\u001b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016\u00a2\u0006\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/ecommerce/biz/hr/adapter/c;", "Ld01/f;", "", "fontFamily", "Lkotlin/Function1;", "Landroid/graphics/Typeface;", "", "result", "a", "", "fontSize", "b", "", "useHostDisplayMetrics", "Landroid/util/DisplayMetrics;", "c", "(Ljava/lang/Boolean;)Landroid/util/DisplayMetrics;", "<init>", "()V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class c implements d01.f {

    /* renamed from: a, reason: collision with root package name */
    public static final c f102524a = new c();

    c() {
    }

    @Override // d01.f
    public float b(float fontSize) {
        return fontSize * com.tencent.ecommerce.base.device.a.f100685b.b();
    }

    @Override // d01.f
    public DisplayMetrics c(Boolean useHostDisplayMetrics) {
        return com.tencent.ecommerce.base.device.a.f100685b.a();
    }

    @Override // d01.f
    public void a(String fontFamily, Function1<? super Typeface, Unit> result) {
        try {
            if (fontFamily.length() == 0) {
                result.invoke(null);
            } else {
                result.invoke(Typeface.createFromAsset(QQEcommerceSdk.INSTANCE.getGlobalInternalSdk().getRuntime().getExternalApplicationContext().getAssets(), "fonts/" + fontFamily + ".ttf"));
            }
        } catch (Throwable unused) {
            result.invoke(null);
        }
    }
}
