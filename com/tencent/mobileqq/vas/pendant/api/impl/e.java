package com.tencent.mobileqq.vas.pendant.api.impl;

import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.vas.avatar.g;
import com.tencent.mobileqq.vas.image.AbsAsyncDrawable;
import com.tencent.mobileqq.vas.image.ILoaderSucessCallback;
import kotlin.jvm.functions.Function0;

/* compiled from: P */
/* loaded from: classes20.dex */
public class e extends AbsAsyncDrawable implements g {

    /* renamed from: d, reason: collision with root package name */
    private final Drawable f310445d;

    /* renamed from: e, reason: collision with root package name */
    private final long f310446e;

    public e(final Drawable drawable, long j3) {
        this.f310445d = drawable;
        this.f310446e = j3;
        setTargetDrawableBuild(new Function0() { // from class: com.tencent.mobileqq.vas.pendant.api.impl.d
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Drawable x16;
                x16 = e.x(drawable);
                return x16;
            }
        });
        load();
    }

    @Override // com.tencent.mobileqq.vas.image.AbsAsyncDrawable
    public boolean isLoadSucess() {
        if (this.f310445d != null) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.vas.avatar.g
    @NonNull
    public Drawable getDrawable() {
        return this;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Drawable x(Drawable drawable) {
        return drawable;
    }

    @Override // com.tencent.mobileqq.vas.image.AbsAsyncDrawable
    public void doLoadTask(@NonNull ILoaderSucessCallback iLoaderSucessCallback) {
    }
}
