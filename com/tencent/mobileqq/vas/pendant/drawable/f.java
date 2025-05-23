package com.tencent.mobileqq.vas.pendant.drawable;

import android.annotation.Nullable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.cachedrawable.dynamicdrawable.cachedrawable.CacheDrawable;
import com.tencent.cachedrawable.dynamicdrawable.cachedrawable.FastDynamicDrawable;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.vas.image.AbsAsyncDrawable;
import com.tencent.mobileqq.vas.image.ILoaderSucessCallback;
import com.tencent.mobileqq.vas.pendant.drawable.interfaces.IPngPendantDrawable;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QZoneClickReport;
import java.net.MalformedURLException;
import java.net.URL;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* compiled from: P */
/* loaded from: classes20.dex */
public class f extends AbsAsyncDrawable implements IPngPendantDrawable {

    /* renamed from: d, reason: collision with root package name */
    private Drawable f310506d;

    /* renamed from: e, reason: collision with root package name */
    private final long f310507e;

    /* renamed from: f, reason: collision with root package name */
    private final long f310508f;

    public f(long j3, long j16) {
        this.f310507e = j3;
        this.f310508f = j16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Drawable A() {
        return this.f310506d;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit B(String str, com.tencent.cachedrawable.dynamicdrawable.d dVar) {
        CacheStateMap.putCacheState(this.f310507e, str, dVar.a());
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Drawable C() {
        return this.f310506d;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void D(final String str) {
        com.tencent.cachedrawable.dynamicdrawable.cachedrawable.k kVar = new com.tencent.cachedrawable.dynamicdrawable.cachedrawable.k();
        if (this.f310508f == PendantConstant.PENDANT_TARGET_ID_AIO) {
            kVar.F(QZoneClickReport.ClickReportConfig.SOURCE_FROM_AIO);
        }
        kVar.y(PendantDrawable.S(this.f310508f));
        kVar.H(false);
        FastDynamicDrawable fastDynamicDrawable = new FastDynamicDrawable("", str, com.tencent.cachedrawable.dynamicdrawable.decoder.b.f99048a, kVar);
        CacheDrawable.CacheState a16 = fastDynamicDrawable.a();
        if (a16 == null) {
            fastDynamicDrawable.c0(new Function1() { // from class: com.tencent.mobileqq.vas.pendant.drawable.d
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit B;
                    B = f.this.B(str, (com.tencent.cachedrawable.dynamicdrawable.d) obj);
                    return B;
                }
            });
        } else {
            CacheStateMap.putCacheState(this.f310507e, str, a16);
        }
        this.f310506d = fastDynamicDrawable;
        setTargetDrawableBuild(new Function0() { // from class: com.tencent.mobileqq.vas.pendant.drawable.e
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Drawable C;
                C = f.this.C();
                return C;
            }
        });
        load();
    }

    @Override // android.graphics.drawable.Drawable, com.tencent.mobileqq.vas.pendant.drawable.interfaces.Invalidatable
    @Nullable
    public /* bridge */ /* synthetic */ Object getCallback() {
        return super.getCallback();
    }

    @Override // com.tencent.mobileqq.vas.image.AbsAsyncDrawable
    /* renamed from: isLoadSucess */
    public boolean getIsLoadSuccess() {
        if (this.f310506d != null) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.vas.pendant.drawable.interfaces.IPngPendantDrawable
    public void setBigImgPath(String str) {
        try {
            URL url = new URL("file", str, "");
            new ColorDrawable(0);
            this.f310506d = URLDrawable.getDrawable(url);
            setTargetDrawableBuild(new Function0() { // from class: com.tencent.mobileqq.vas.pendant.drawable.b
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    Drawable A;
                    A = f.this.A();
                    return A;
                }
            });
            load();
        } catch (MalformedURLException e16) {
            QLog.e("AbsAsyncDrawable", 1, "setBigImgPath", e16);
        }
    }

    @Override // com.tencent.mobileqq.vas.pendant.drawable.interfaces.IPngPendantDrawable
    public void setPngPaths(final String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.vas.pendant.drawable.c
            @Override // java.lang.Runnable
            public final void run() {
                f.this.D(str);
            }
        }, 16, null, false);
    }

    @Override // com.tencent.mobileqq.vas.pendant.drawable.interfaces.IPendantDrawable
    public void recycle() {
    }

    @Override // com.tencent.mobileqq.vas.image.AbsAsyncDrawable
    public void doLoadTask(@NonNull ILoaderSucessCallback iLoaderSucessCallback) {
    }
}
