package com.tencent.mobileqq.vas.bubble.drawable.shoot;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.personalize.music.request.QzoneSetBackgroundMusicPlayModeRequest;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.vas.updatesystem.api.IVasBusinessManager;
import com.tencent.mobileqq.vas.updatesystem.business.BubbleBusiness;
import com.tencent.mobileqq.vas.updatesystem.business.QQVasUpdateBusiness;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QZoneClickReport;
import java.io.File;
import java.util.ArrayList;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jbox2d.dynamics.Body;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 B2\u00020\u0001:\u0001\u0013B7\u0012\u0006\u00103\u001a\u000201\u0012\u0006\u00104\u001a\u000201\u0012\u0006\u0010\u001e\u001a\u00020\u0004\u0012\u0006\u0010\u001f\u001a\u00020\u0004\u0012\u0006\u0010.\u001a\u00020,\u0012\u0006\u00100\u001a\u00020\u0014\u00a2\u0006\u0004\b@\u0010AJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\u000b\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0002J\u0010\u0010\r\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u0004H\u0002J\n\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0002J\b\u0010\u0010\u001a\u00020\u0004H\u0016J\b\u0010\u0011\u001a\u00020\tH\u0016J\u0010\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0013\u001a\u00020\u0002H\u0016J\u0010\u0010\u0015\u001a\u00020\u00142\u0006\u0010\n\u001a\u00020\tH\u0016J\u0010\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u0016H\u0016J\b\u0010\u0019\u001a\u00020\u0002H\u0016R\u0014\u0010\u001c\u001a\u00020\u001a8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u001bR\u0014\u0010\u001e\u001a\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u001dR\u0014\u0010\u001f\u001a\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u001dR\u0018\u0010#\u001a\u0004\u0018\u00010 8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\r\u0010$R\u0018\u0010'\u001a\u0004\u0018\u00010%8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0006\u0010&R\u0016\u0010+\u001a\u00020(8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b)\u0010*R\u0016\u0010\f\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u001dR\u0016\u0010.\u001a\u00020,8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010-R\u0016\u00100\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010/R\u0016\u00103\u001a\u0002018\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0003\u00102R\u0016\u00104\u001a\u0002018\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u00102R\u0014\u00107\u001a\u0002058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u00106R\u0016\u0010\b\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b8\u00109R\u0014\u0010=\u001a\u00020:8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b;\u0010<R\u0016\u0010?\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b>\u0010\u001d\u00a8\u0006C"}, d2 = {"Lcom/tencent/mobileqq/vas/bubble/drawable/shoot/e;", "Lcom/tencent/cachedrawable/dynamicdrawable/h;", "", "k", "", "index", "f", "Lcom/tencent/mobileqq/vas/bubble/drawable/shoot/f;", "waitDrawConfig", "", "time", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "countId", "e", "Landroid/graphics/Bitmap;", "j", h.F, "i", "b", "a", "", "c", "Lcom/tencent/cachedrawable/dynamicdrawable/b;", "consumer", "l", "destroy", "Lcom/tencent/mobileqq/vas/updatesystem/business/BubbleBusiness;", "Lcom/tencent/mobileqq/vas/updatesystem/business/BubbleBusiness;", "bubbleBusiness", "I", "width", "height", "Lcom/tencent/mobileqq/vas/bubble/drawable/shoot/c;", "d", "Lcom/tencent/mobileqq/vas/bubble/drawable/shoot/c;", "world", "Lcom/tencent/cachedrawable/dynamicdrawable/b;", "Lcom/tencent/cachedrawable/dynamicdrawable/a;", "Lcom/tencent/cachedrawable/dynamicdrawable/a;", "timeLine", "", "g", "Ljava/lang/String;", "filePath", "Lf03/d;", "Lf03/d;", "shootAnimationConfig", "Z", "isDirectLeft", "", UserInfo.SEX_FEMALE, "startXPx", "startYPx", "Lcom/tencent/cachedrawable/dynamicdrawable/cachedrawable/framecache/c;", "Lcom/tencent/cachedrawable/dynamicdrawable/cachedrawable/framecache/c;", "frameLruCache", DomainData.DOMAIN_NAME, "Lcom/tencent/mobileqq/vas/bubble/drawable/shoot/f;", "Ljava/util/Random;", "o", "Ljava/util/Random;", QzoneSetBackgroundMusicPlayModeRequest.PLAY_MODE_RANDOM, "p", "idCount", "<init>", "(FFIILf03/d;Z)V", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "vas_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class e implements com.tencent.cachedrawable.dynamicdrawable.h {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final BubbleBusiness bubbleBusiness;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final int width;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final int height;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private c world;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private com.tencent.cachedrawable.dynamicdrawable.b consumer;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private com.tencent.cachedrawable.dynamicdrawable.a timeLine;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String filePath;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private int countId;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private f03.d shootAnimationConfig;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    private boolean isDirectLeft;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    private float startXPx;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    private float startYPx;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.cachedrawable.dynamicdrawable.cachedrawable.framecache.c frameLruCache;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private f waitDrawConfig;

    /* renamed from: o, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Random random;

    /* renamed from: p, reason: collision with root package name and from kotlin metadata */
    private int idCount;

    public e(float f16, float f17, int i3, int i16, @NotNull f03.d shootAnimationConfig, boolean z16) {
        Intrinsics.checkNotNullParameter(shootAnimationConfig, "shootAnimationConfig");
        QQVasUpdateBusiness businessInstance = ((IVasBusinessManager) QRoute.api(IVasBusinessManager.class)).getBusinessInstance((Class<QQVasUpdateBusiness>) BubbleBusiness.class);
        Intrinsics.checkNotNullExpressionValue(businessInstance, "api(IVasBusinessManager:\u2026bbleBusiness::class.java)");
        BubbleBusiness bubbleBusiness = (BubbleBusiness) businessInstance;
        this.bubbleBusiness = bubbleBusiness;
        this.frameLruCache = com.tencent.cachedrawable.dynamicdrawable.cachedrawable.framecache.c.f98952a;
        this.random = new Random();
        this.width = i3;
        this.height = i16;
        String bubbleAnimPath = bubbleBusiness.getBubbleAnimPath(Integer.parseInt(shootAnimationConfig.getBubbleId()));
        Intrinsics.checkNotNullExpressionValue(bubbleAnimPath, "bubbleBusiness.getBubble\u2026nConfig.bubbleId.toInt())");
        this.filePath = bubbleAnimPath;
        this.shootAnimationConfig = shootAnimationConfig;
        this.isDirectLeft = z16;
        this.waitDrawConfig = new f();
        this.startXPx = f16;
        this.startYPx = f17;
        k();
    }

    private final void e(int countId) {
        if (this.world == null) {
            return;
        }
        double radians = Math.toRadians(this.random.nextInt(90));
        double cos = Math.cos(radians);
        Intrinsics.checkNotNullExpressionValue(this.shootAnimationConfig.b().get(countId), "shootAnimationConfig.animasDirXs[countId]");
        float parseFloat = (float) (cos * Float.parseFloat(r6));
        if (!this.isDirectLeft) {
            parseFloat = -parseFloat;
        }
        double sin = Math.sin(radians);
        Intrinsics.checkNotNullExpressionValue(this.shootAnimationConfig.c().get(countId), "shootAnimationConfig.animasDirYs[countId]");
        float parseFloat2 = (float) (sin * Float.parseFloat(r1));
        com.tencent.qqnt.util.view.b bVar = com.tencent.qqnt.util.view.b.f362999a;
        int c16 = (int) bVar.c(this.shootAnimationConfig.getWidth() / 2.0f);
        int c17 = (int) bVar.c(this.shootAnimationConfig.getHeight() / 2.0f);
        float physicalRotate = this.shootAnimationConfig.getPhysicalRotate();
        Bitmap j3 = j();
        if (j3 != null) {
            int i3 = this.idCount + 1;
            this.idCount = i3;
            XARect xARect = new XARect(i3, j3, this.startXPx, this.startYPx, c16, c17, physicalRotate, 0.0f, 128, null);
            c cVar = this.world;
            if (cVar != null) {
                cVar.c(xARect, bVar.c(parseFloat), bVar.c(parseFloat2));
            }
        }
    }

    private final void f(final int index) {
        c cVar = this.world;
        if (cVar != null) {
            cVar.q(new Runnable() { // from class: com.tencent.mobileqq.vas.bubble.drawable.shoot.d
                @Override // java.lang.Runnable
                public final void run() {
                    e.g(e.this, index);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(e this$0, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if ((this$0.consumer instanceof ShootBubbleAnimDrawable) && i3 * this$0.i() >= this$0.shootAnimationConfig.getPhysicalAnimDelay()) {
            int parCount = this$0.shootAnimationConfig.getParCount();
            int i16 = this$0.countId;
            if (parCount > i16) {
                this$0.e(i16);
                this$0.countId++;
            }
            c cVar = this$0.world;
            if (cVar != null) {
                cVar.k(i3);
            }
        }
    }

    private final Bitmap j() {
        String replace$default;
        Bitmap bitmap;
        ArrayList<String> l3 = this.shootAnimationConfig.l();
        if (!l3.isEmpty()) {
            String str = l3.get(this.random.nextInt(l3.size()));
            Intrinsics.checkNotNullExpressionValue(str, "animBitmapPaths[random.n\u2026nt(animBitmapPaths.size)]");
            replace$default = StringsKt__StringsJVMKt.replace$default(str, "./", this.filePath + File.separator, false, 4, (Object) null);
            if (!new File(replace$default).exists()) {
                return null;
            }
            com.tencent.cachedrawable.dynamicdrawable.cachedrawable.manager.b b16 = this.frameLruCache.b(replace$default, null);
            if (b16 != null) {
                bitmap = b16.a();
            } else {
                bitmap = null;
            }
            if (bitmap != null) {
                return b16.a();
            }
            try {
                Bitmap decodeFile = BitmapFactory.decodeFile(replace$default);
                if (decodeFile != null) {
                    this.frameLruCache.a(replace$default, new com.tencent.cachedrawable.dynamicdrawable.cachedrawable.manager.b(decodeFile, 0, 0, 0, 0));
                }
                return decodeFile;
            } catch (Exception e16) {
                QLog.e("ShootBubbleAnimProducer", 1, e16.getMessage());
            }
        }
        return null;
    }

    private final void k() {
        c cVar = new c();
        this.world = cVar;
        Intrinsics.checkNotNull(cVar);
        cVar.e(this.width, this.height);
        this.timeLine = com.tencent.cachedrawable.dynamicdrawable.cachedrawable.e.f98943a.a(QZoneClickReport.ClickReportConfig.SOURCE_FROM_AIO);
    }

    private final void m(f waitDrawConfig, long time) {
        Set<XARect> set;
        ConcurrentHashMap<XARect, Body> m3;
        Intrinsics.checkNotNull(this.consumer, "null cannot be cast to non-null type com.tencent.mobileqq.vas.bubble.drawable.shoot.ShootBubbleAnimDrawable");
        long mFirstFrameTime = time - ((ShootBubbleAnimDrawable) r0).getMFirstFrameTime();
        if (mFirstFrameTime < this.shootAnimationConfig.getShowAlphaDelay()) {
            waitDrawConfig.c(0.0f);
        } else if (mFirstFrameTime >= this.shootAnimationConfig.getShowAlphaDelay() && mFirstFrameTime <= this.shootAnimationConfig.getShowAlphaDelay() + this.shootAnimationConfig.getShowAlphaDur()) {
            waitDrawConfig.c(((float) (mFirstFrameTime - this.shootAnimationConfig.getShowAlphaDelay())) / this.shootAnimationConfig.getShowAlphaDur());
        } else if (mFirstFrameTime >= this.shootAnimationConfig.getHideAlphaDelay() && mFirstFrameTime <= this.shootAnimationConfig.getHideAlphaDelay() + this.shootAnimationConfig.getHideAlphaDur()) {
            waitDrawConfig.c(1.0f - (((float) (mFirstFrameTime - this.shootAnimationConfig.getHideAlphaDelay())) / this.shootAnimationConfig.getHideAlphaDur()));
        } else if (mFirstFrameTime > this.shootAnimationConfig.getHideAlphaDelay() + this.shootAnimationConfig.getHideAlphaDur()) {
            waitDrawConfig.c(0.0f);
        }
        if (waitDrawConfig.getAlpha() > 0.0f) {
            c cVar = this.world;
            if (cVar != null && (m3 = cVar.m()) != null) {
                set = m3.keySet();
            } else {
                set = null;
            }
            waitDrawConfig.d(set);
        }
    }

    @Override // com.tencent.cachedrawable.dynamicdrawable.h
    public void b(int index) {
        f(index);
        com.tencent.cachedrawable.dynamicdrawable.a aVar = this.timeLine;
        if (aVar != null) {
            aVar.a(this);
        }
    }

    @Override // com.tencent.cachedrawable.dynamicdrawable.h
    public boolean c(long time) {
        boolean z16;
        com.tencent.cachedrawable.dynamicdrawable.b bVar = this.consumer;
        if (bVar != null && bVar.b(time)) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16 || !(this.consumer instanceof ShootBubbleAnimDrawable)) {
            return false;
        }
        m(this.waitDrawConfig, time);
        com.tencent.cachedrawable.dynamicdrawable.b bVar2 = this.consumer;
        Intrinsics.checkNotNull(bVar2, "null cannot be cast to non-null type com.tencent.mobileqq.vas.bubble.drawable.shoot.ShootBubbleAnimDrawable");
        ((ShootBubbleAnimDrawable) bVar2).e(this.waitDrawConfig);
        return true;
    }

    @Override // com.tencent.cachedrawable.dynamicdrawable.h
    public void destroy() {
        c cVar = this.world;
        if (cVar != null) {
            cVar.o();
        }
    }

    public int h() {
        return ((int) (this.shootAnimationConfig.getDuration() / i())) + 2;
    }

    public long i() {
        return 60L;
    }

    public void l(@NotNull com.tencent.cachedrawable.dynamicdrawable.b consumer) {
        Intrinsics.checkNotNullParameter(consumer, "consumer");
        this.consumer = consumer;
    }

    @Override // com.tencent.cachedrawable.dynamicdrawable.h
    public void a() {
    }
}
