package com.tencent.mobileqq.vas.avatar;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.cachedrawable.dynamicdrawable.cachedrawable.CacheDrawable;
import com.tencent.cachedrawable.dynamicdrawable.cachedrawable.FastDynamicDrawable;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.VasLogNtReporter;
import com.tencent.mobileqq.vas.api.IPendantNumApi;
import com.tencent.mobileqq.vas.ar;
import com.tencent.mobileqq.vas.image.AbsAsyncDrawable;
import com.tencent.mobileqq.vas.image.ILoaderSucessCallback;
import com.tencent.mobileqq.vas.pendant.api.ILoadResultCallback;
import com.tencent.mobileqq.vas.pendant.api.ISpecialShapeAvatarMaskLayer;
import com.tencent.mobileqq.vas.updatesystem.api.IVasBusinessManager;
import com.tencent.mobileqq.vas.updatesystem.callback.IDownLoadListener;
import com.tencent.mobileqq.vip.api.VipData;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.vas.update.entity.UpdateListenerParams;
import cooperation.qzone.QZoneClickReport;
import java.io.File;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import mqq.util.WeakReference;

/* compiled from: P */
/* loaded from: classes20.dex */
public class j extends AbsAsyncDrawable implements g {
    private static final boolean K = ar.b("shouyouye", "2024-06-19", "vas_fix_aio_avatar_screen_shot_list").isEnable(true);
    private static final boolean L = ar.b("shouyouye", "2024-10-05", "vas_fix_aio_avatar_screen_shot_list_2").isEnable(true);
    private final int C;
    private final VipData.VipNumberInfo D;
    private boolean E = true;
    private volatile boolean F;
    private com.tencent.mobileqq.vas.avatar.e G;
    private final Paint H;
    private Bitmap I;
    private int J;

    /* renamed from: d, reason: collision with root package name */
    private Drawable f308800d;

    /* renamed from: e, reason: collision with root package name */
    private FastDynamicDrawable f308801e;

    /* renamed from: f, reason: collision with root package name */
    private final String f308802f;

    /* renamed from: h, reason: collision with root package name */
    private final int f308803h;

    /* renamed from: i, reason: collision with root package name */
    private final int f308804i;

    /* renamed from: m, reason: collision with root package name */
    private final int f308805m;

    /* compiled from: P */
    /* loaded from: classes20.dex */
    class a implements ILoadResultCallback {
        a() {
        }

        @Override // com.tencent.mobileqq.vas.pendant.api.ILoadResultCallback
        public void onFailure(int i3, @NonNull String str) {
            QLog.w("AbsAsyncDrawable", 1, "load file error , code: " + i3 + " msg:" + str);
        }

        @Override // com.tencent.mobileqq.vas.pendant.api.ILoadResultCallback
        public void onSuccess() {
            j.this.invalidateSelf();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public class b implements Function1<Canvas, Unit> {
        b() {
        }

        @Override // kotlin.jvm.functions.Function1
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Unit invoke(Canvas canvas) {
            j.this.draw(canvas);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public class c implements IPendantNumApi.LoadVipNumInfoCallback {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f308808a;

        c(int i3) {
            this.f308808a = i3;
        }

        @Override // com.tencent.mobileqq.vas.api.IPendantNumApi.LoadVipNumInfoCallback
        public void success(@NonNull VipData.VipNumberInfo vipNumberInfo) {
            if (QLog.isDebugVersion()) {
                VasLogNtReporter.getVipNumber().reportLow(String.format("profilecard[%d] number_id[%d] number[%d] isLong=[%b]", Integer.valueOf(this.f308808a), Integer.valueOf(vipNumberInfo.getNumberItemId()), Integer.valueOf(vipNumberInfo.getNumberIdx()), Boolean.valueOf(vipNumberInfo.isLongNumber())));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public class d implements Function1<com.tencent.cachedrawable.dynamicdrawable.cachedrawable.k, Unit> {
        d() {
        }

        @Override // kotlin.jvm.functions.Function1
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Unit invoke(com.tencent.cachedrawable.dynamicdrawable.cachedrawable.k kVar) {
            kVar.H(false);
            kVar.y(Integer.MAX_VALUE);
            if (j.this.C == 9) {
                kVar.F(QZoneClickReport.ClickReportConfig.SOURCE_FROM_AIO);
            }
            kVar.I(true);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public static class e implements IDownLoadListener {

        /* renamed from: a, reason: collision with root package name */
        private final WeakReference<j> f308811a;

        e(j jVar) {
            this.f308811a = new WeakReference<>(jVar);
        }

        @Override // com.tencent.mobileqq.vas.updatesystem.callback.IDownLoadListener
        public void onLoadFail(@NonNull UpdateListenerParams updateListenerParams) {
            j jVar = this.f308811a.get();
            if (jVar != null) {
                jVar.E(updateListenerParams.mErrorCode, updateListenerParams.mErrorMessage);
            }
        }

        @Override // com.tencent.mobileqq.vas.updatesystem.callback.IDownLoadListener
        public void onLoadSuccess(@NonNull UpdateListenerParams updateListenerParams) {
            j jVar = this.f308811a.get();
            if (jVar != null) {
                jVar.D();
            }
        }
    }

    public j(String str, int i3, int i16, int i17, int i18, VipData.VipNumberInfo vipNumberInfo, int i19) {
        this.f308802f = str;
        this.f308803h = i3;
        this.f308804i = i16;
        this.f308805m = i17;
        this.C = i18;
        this.D = vipNumberInfo;
        this.J = i19;
        Paint paint = new Paint(1);
        this.H = paint;
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
        if (i19 > 0 && !((IVasBusinessManager) QRoute.api(IVasBusinessManager.class)).getBusinessInstance((Long) 333L).isFileExists(i19)) {
            ((ISpecialShapeAvatarMaskLayer) QRoute.api(ISpecialShapeAvatarMaskLayer.class)).startLoadLayer(str, i19, new a());
        }
    }

    @SuppressLint({"DefaultLocale"})
    private Drawable A(String str, int i3, Drawable drawable, int i16, VipData.VipNumberInfo vipNumberInfo) {
        boolean z16;
        boolean z17;
        try {
            c cVar = new c(i3);
            if (vipNumberInfo == null) {
                IPendantNumApi iPendantNumApi = (IPendantNumApi) QRoute.api(IPendantNumApi.class);
                VipData.VipNumberInfo.APPID appid = VipData.VipNumberInfo.APPID.Avatar;
                if (i16 == 1) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                return iPendantNumApi.wrapPendantNum(str, drawable, appid, i3, z17, cVar);
            }
            IPendantNumApi iPendantNumApi2 = (IPendantNumApi) QRoute.api(IPendantNumApi.class);
            if (i16 == 1) {
                z16 = true;
            } else {
                z16 = false;
            }
            return iPendantNumApi2.wrapPendantNum(str, drawable, vipNumberInfo, z16, cVar);
        } catch (Exception e16) {
            QLog.w("AbsAsyncDrawable", 1, "buildPendantNumDrawable exception:" + e16);
            return drawable;
        }
    }

    private Drawable y(String str, int i3, String str2, int i16, VipData.VipNumberInfo vipNumberInfo) {
        return A(str, i3, z(str2), i16, vipNumberInfo);
    }

    private Drawable z(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        FastDynamicDrawable a16 = com.tencent.cachedrawable.dynamicdrawable.api.a.a().d(str).h(new d()).a();
        this.f308801e = a16;
        return a16;
    }

    public void B(boolean z16) {
        this.E = z16;
    }

    public void D() {
        f fVar = (f) ((IVasBusinessManager) QRoute.api(IVasBusinessManager.class)).getBusinessInstance((Long) 23L);
        String a16 = h.a(this.f308803h, h.b(this.f308804i));
        String e16 = fVar.e(a16);
        if (fVar.isFileExist(a16) && new File(e16).exists()) {
            final Drawable y16 = y(this.f308802f, this.f308803h, e16, this.f308805m, this.D);
            this.f308800d = y16;
            setTargetDrawableBuild(new Function0() { // from class: com.tencent.mobileqq.vas.avatar.i
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    Drawable C;
                    C = j.C(y16);
                    return C;
                }
            });
            load(!L);
            com.tencent.mobileqq.vas.avatar.e eVar = this.G;
            if (eVar != null) {
                eVar.a(this);
            }
        } else if (this.E && !this.F) {
            fVar.addDownLoadListener(a16, new e(this));
            fVar.startDownload(a16);
            this.F = true;
        } else {
            return;
        }
        com.tencent.mobileqq.vas.image.i.f309597a.a(new b());
    }

    public void E(int i3, String str) {
        com.tencent.mobileqq.vas.avatar.e eVar = this.G;
        if (eVar != null) {
            eVar.fail(i3, str);
        }
    }

    public void F(com.tencent.mobileqq.vas.avatar.e eVar) {
        this.G = eVar;
    }

    @Override // com.tencent.mobileqq.vas.image.AbsAsyncDrawable
    public void doLoadTask(@NonNull ILoaderSucessCallback iLoaderSucessCallback) {
        if (K && this.f308800d == null) {
            D();
        }
    }

    @Override // com.tencent.mobileqq.vas.image.AbsAsyncDrawable, android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        Drawable o16;
        Rect bounds = getBounds();
        if (this.J > 0) {
            Bitmap bitmap = this.I;
            if (bitmap != null && (bitmap.getWidth() != bounds.width() || this.I.getHeight() != bounds.height())) {
                this.I = null;
            }
            if (this.I == null) {
                this.I = ((ISpecialShapeAvatarMaskLayer) QRoute.api(ISpecialShapeAvatarMaskLayer.class)).getMaskLayer(BaseApplication.context, this.f308802f, this.J, bounds.width(), bounds.height());
            }
            if (this.I != null) {
                int saveLayer = canvas.saveLayer(0.0f, 0.0f, bounds.right, bounds.bottom, null);
                super.draw(canvas);
                canvas.drawBitmap(this.I, 0.0f, 0.0f, this.H);
                canvas.restoreToCount(saveLayer);
                return;
            }
        }
        FastDynamicDrawable fastDynamicDrawable = this.f308801e;
        if (fastDynamicDrawable != null && (o16 = fastDynamicDrawable.o()) != null && (o16 instanceof CacheDrawable)) {
            int i3 = bounds.right - bounds.left;
            int i16 = bounds.bottom - bounds.top;
            if (i3 > 0 && i16 > 0) {
                ((CacheDrawable) o16).o(i3 >> 1, i16 >> 2);
            }
        }
        super.draw(canvas);
    }

    @Override // com.tencent.mobileqq.vas.image.AbsAsyncDrawable
    /* renamed from: isLoadSucess */
    public boolean getIsLoadSuccess() {
        if (this.f308800d != null) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.vas.avatar.g
    @Nullable
    public Drawable getDrawable() {
        return this;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Drawable C(Drawable drawable) {
        return drawable;
    }
}
