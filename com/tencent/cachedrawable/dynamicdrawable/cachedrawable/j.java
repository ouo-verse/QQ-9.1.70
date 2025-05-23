package com.tencent.cachedrawable.dynamicdrawable.cachedrawable;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.NinePatch;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.NinePatchDrawable;
import android.os.Build;
import android.os.SystemClock;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.qq.e.comm.managers.plugin.PM;
import com.tencent.cachedrawable.dynamicdrawable.cachedrawable.CacheDrawable;
import com.tencent.cachedrawable.dynamicdrawable.d;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0094\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u0015\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 i2\u00020\u0001:\u0002;1B\u001f\u0012\u0006\u0010c\u001a\u00020b\u0012\u0006\u0010e\u001a\u00020d\u0012\u0006\u0010f\u001a\u00020\u0016\u00a2\u0006\u0004\bg\u0010hJ(\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002J:\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002J\u0018\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u0004H\u0002J \u0010\u0012\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0004H\u0002J \u0010\u0013\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0004H\u0002J \u0010\u0014\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0004H\u0002J\b\u0010\u0015\u001a\u00020\nH\u0002J\u0010\u0010\u0018\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\u0016H\u0002J\u0010\u0010\u0019\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0016H\u0002J\u0010\u0010\u001a\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0016H\u0002J\b\u0010\u001b\u001a\u00020\nH\u0002J\b\u0010\u001c\u001a\u00020\nH\u0002J\u000e\u0010\u001e\u001a\u00020\n2\u0006\u0010\u001d\u001a\u00020\u0016J\u0016\u0010\"\u001a\u00020\n2\u0006\u0010 \u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\u001fJ\u0006\u0010#\u001a\u00020\u0016J\u000e\u0010%\u001a\u00020\n2\u0006\u0010$\u001a\u00020\u0016J\u000e\u0010(\u001a\u00020\n2\u0006\u0010'\u001a\u00020&J\u000e\u0010+\u001a\u00020\n2\u0006\u0010*\u001a\u00020)J.\u0010.\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010-\u001a\u00020,2\u0006\u0010\u0005\u001a\u00020\u0004J\u0010\u00101\u001a\u00020\u00162\u0006\u00100\u001a\u00020/H\u0016J\u0006\u00102\u001a\u00020,J\u0006\u00103\u001a\u00020,J\u0010\u00106\u001a\u00020\n2\u0006\u00105\u001a\u000204H\u0016J\b\u00108\u001a\u000207H\u0016J\u0006\u00109\u001a\u00020\nJ\u0006\u0010:\u001a\u00020\nJ\b\u0010;\u001a\u00020\nH\u0016J\u000e\u0010>\u001a\u00020\n2\u0006\u0010=\u001a\u00020<J\u0006\u0010?\u001a\u00020,J\u0006\u0010@\u001a\u00020,J\u000e\u0010B\u001a\u00020\n2\u0006\u0010A\u001a\u00020,J\u000e\u0010E\u001a\u00020\n2\u0006\u0010D\u001a\u00020CR\u0018\u0010H\u001a\u0004\u0018\u0001048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bF\u0010GR\u0016\u0010K\u001a\u00020/8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bI\u0010JR\u0016\u0010M\u001a\u00020,8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bE\u0010LR\u0016\u0010N\u001a\u00020,8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b.\u0010LR\u0016\u0010O\u001a\u00020,8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010LR\u0016\u0010Q\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010PR\u0016\u0010R\u001a\u00020,8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\"\u0010LR\u0016\u0010S\u001a\u00020,8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b+\u0010LR\u0016\u0010V\u001a\u00020T8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b>\u0010UR\u0018\u0010X\u001a\u0004\u0018\u00010&8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b9\u0010WR\u0018\u0010Z\u001a\u0004\u0018\u00010C8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010YR\u0018\u0010\\\u001a\u0004\u0018\u00010)8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010[R\u0018\u0010 \u001a\u0004\u0018\u00010\u001f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bL\u0010]R\u0018\u0010!\u001a\u0004\u0018\u00010\u001f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bJ\u0010]R\u0016\u0010_\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b^\u0010PR\u0016\u0010a\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b`\u0010P\u00a8\u0006j"}, d2 = {"Lcom/tencent/cachedrawable/dynamicdrawable/cachedrawable/j;", "Lcom/tencent/cachedrawable/dynamicdrawable/b;", "Landroid/graphics/Bitmap;", "curBitmap", "Landroid/graphics/Rect;", "clipBounds", "Landroid/graphics/Paint;", "paint", "Landroid/graphics/Canvas;", PM.CANVAS, "", "j", "", "ninePatchChunk", "bounds", "i", "k", "srcRect", DomainData.DOMAIN_NAME, QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "l", "t", "", "isHardwareAccelerated", "G", "H", "v", "g", "u", "isUseHardware", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "", "ninePatchXRegions", "ninePatchYRegions", BdhLogUtil.LogTag.Tag_Conn, "w", "isUse2BitmapMode", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "Lcom/tencent/cachedrawable/dynamicdrawable/cachedrawable/CacheDrawable$CacheState;", "cacheState", "y", "Lcom/tencent/cachedrawable/dynamicdrawable/d$b;", "selfDrawHelper", "D", "", "fitStyle", tl.h.F, "", "time", "b", "p", "o", "Lcom/tencent/cachedrawable/dynamicdrawable/cachedrawable/manager/b;", "frameData", "c", "Lcom/tencent/cachedrawable/dynamicdrawable/h;", "r", UserInfo.SEX_FEMALE, HippyTKDListViewAdapter.X, "a", "Lcom/tencent/cachedrawable/dynamicdrawable/a;", "animTimeLine", "E", ReportConstant.COSTREPORT_PREFIX, QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "loopCount", "B", "Lcom/tencent/cachedrawable/dynamicdrawable/d$a;", "listener", "f", "d", "Lcom/tencent/cachedrawable/dynamicdrawable/cachedrawable/manager/b;", "mCurFrameAnimData", "e", "J", "mFirstFrameTime", "I", "mCurFrameIndex", "mFrameCount", "mLoopCount", "Z", "mIsNeedPlay", "mCurLooper", "mShouldFrameIndex", "Lcom/tencent/cachedrawable/dynamicdrawable/cachedrawable/CacheFrameProducer;", "Lcom/tencent/cachedrawable/dynamicdrawable/cachedrawable/CacheFrameProducer;", "mProducer", "Lcom/tencent/cachedrawable/dynamicdrawable/cachedrawable/CacheDrawable$CacheState;", "mCacheState", "Lcom/tencent/cachedrawable/dynamicdrawable/d$a;", "mListener", "Lcom/tencent/cachedrawable/dynamicdrawable/d$b;", "mSelfDrawHelper", "[I", "K", "mIsUseHardware", "L", "mCanvasIsHardwareAccelerated", "", "filePath", "Lcom/tencent/cachedrawable/dynamicdrawable/e;", "fileDecoder", "useFileCache", "<init>", "(Ljava/lang/String;Lcom/tencent/cachedrawable/dynamicdrawable/e;Z)V", "M", "cachedrawable_debug"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes5.dex */
public final class j implements com.tencent.cachedrawable.dynamicdrawable.b {
    static IPatchRedirector $redirector_;

    /* renamed from: M, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    private int mCurLooper;

    /* renamed from: D, reason: from kotlin metadata */
    private int mShouldFrameIndex;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private CacheFrameProducer mProducer;

    /* renamed from: F, reason: from kotlin metadata */
    @Nullable
    private CacheDrawable.CacheState mCacheState;

    /* renamed from: G, reason: from kotlin metadata */
    @Nullable
    private d.a mListener;

    /* renamed from: H, reason: from kotlin metadata */
    @Nullable
    private d.b mSelfDrawHelper;

    /* renamed from: I, reason: from kotlin metadata */
    @Nullable
    private int[] ninePatchXRegions;

    /* renamed from: J, reason: from kotlin metadata */
    @Nullable
    private int[] ninePatchYRegions;

    /* renamed from: K, reason: from kotlin metadata */
    private boolean mIsUseHardware;

    /* renamed from: L, reason: from kotlin metadata */
    private volatile boolean mCanvasIsHardwareAccelerated;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private com.tencent.cachedrawable.dynamicdrawable.cachedrawable.manager.b mCurFrameAnimData;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private long mFirstFrameTime;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private int mCurFrameIndex;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private int mFrameCount;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private int mLoopCount;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private boolean mIsNeedPlay;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/cachedrawable/dynamicdrawable/cachedrawable/j$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "cachedrawable_debug"}, k = 1, mv = {1, 5, 1})
    /* renamed from: com.tencent.cachedrawable.dynamicdrawable.cachedrawable.j$a, reason: from kotlin metadata */
    /* loaded from: classes5.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\u0005\u001a\u00020\u0004H&\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/cachedrawable/dynamicdrawable/cachedrawable/j$b;", "", "", "invalidateSelf", "", "e", "cachedrawable_debug"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes5.dex */
    public interface b {
        boolean e();

        void invalidateSelf();
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(9882);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 26)) {
            redirector.redirect((short) 26);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public j(@NotNull String filePath, @NotNull com.tencent.cachedrawable.dynamicdrawable.e fileDecoder, boolean z16) {
        Intrinsics.checkNotNullParameter(filePath, "filePath");
        Intrinsics.checkNotNullParameter(fileDecoder, "fileDecoder");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, filePath, fileDecoder, Boolean.valueOf(z16));
            return;
        }
        this.mLoopCount = -1;
        this.mIsNeedPlay = true;
        this.mCanvasIsHardwareAccelerated = true;
        CacheFrameProducer cacheFrameProducer = new CacheFrameProducer(filePath, fileDecoder, z16);
        this.mProducer = cacheFrameProducer;
        this.mFrameCount = cacheFrameProducer.q();
        this.mCurFrameAnimData = this.mProducer.o();
        this.mProducer.u(this);
        A(true);
    }

    private final void G(boolean isHardwareAccelerated) {
        if (v(isHardwareAccelerated)) {
            com.tencent.cachedrawable.dynamicdrawable.logcat.a.f99049a.b("CacheImage", Intrinsics.stringPlus("cacheImage.drawable error : canvas.isHardwareAccelerated ", Boolean.valueOf(isHardwareAccelerated)));
            g();
        }
    }

    private final boolean H(boolean isHardwareAccelerated) {
        if (v(isHardwareAccelerated)) {
            com.tencent.cachedrawable.dynamicdrawable.logcat.a.f99049a.b("CacheImage", Intrinsics.stringPlus("Async cacheImage.drawable error : canvas.isHardwareAccelerated ", Boolean.valueOf(isHardwareAccelerated)));
            AbsAsyncDrawable.INSTANCE.a().post(new Runnable() { // from class: com.tencent.cachedrawable.dynamicdrawable.cachedrawable.h
                @Override // java.lang.Runnable
                public final void run() {
                    j.I(j.this);
                }
            });
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void I(final j this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.g();
        AbsAsyncDrawable.INSTANCE.b().post(new Runnable() { // from class: com.tencent.cachedrawable.dynamicdrawable.cachedrawable.i
            @Override // java.lang.Runnable
            public final void run() {
                j.J(j.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void J(j this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.u();
    }

    private final void g() {
        Bitmap bitmap;
        com.tencent.cachedrawable.dynamicdrawable.cachedrawable.manager.b bVar = this.mCurFrameAnimData;
        if (bVar != null) {
            try {
                bitmap = bVar.a().copy(Bitmap.Config.ARGB_8888, true);
            } catch (Exception unused) {
                com.tencent.cachedrawable.dynamicdrawable.logcat.a.f99049a.b("CacheImage", "cacheImage.drawable error : copy bitmap error");
                bitmap = null;
            }
            if (bitmap == null) {
                bitmap = com.tencent.cachedrawable.dynamicdrawable.utils.c.f99061a.b(bVar.a());
            }
            this.mCurFrameAnimData = new com.tencent.cachedrawable.dynamicdrawable.cachedrawable.manager.b(bitmap, bVar.c(), bVar.d(), bVar.h(), bVar.e());
        }
    }

    private final void i(Bitmap curBitmap, byte[] ninePatchChunk, Rect bounds, Rect clipBounds, Paint paint, Canvas canvas) {
        NinePatchDrawable ninePatchDrawable = new NinePatchDrawable(curBitmap, ninePatchChunk, bounds, null);
        ninePatchDrawable.setBounds(clipBounds);
        ninePatchDrawable.getPaint().setXfermode(paint.getXfermode());
        ninePatchDrawable.draw(canvas);
        ninePatchDrawable.getPaint().setXfermode(null);
    }

    private final void j(Bitmap curBitmap, Rect clipBounds, Paint paint, Canvas canvas) {
        int[] iArr = this.ninePatchXRegions;
        Intrinsics.checkNotNull(iArr);
        int[] iArr2 = this.ninePatchYRegions;
        Intrinsics.checkNotNull(iArr2);
        l lVar = new l(curBitmap, iArr, iArr2);
        lVar.setBounds(clipBounds);
        lVar.a().setXfermode(paint.getXfermode());
        lVar.draw(canvas);
        lVar.a().setXfermode(null);
    }

    private final Rect k(Bitmap curBitmap, Rect bounds) {
        float f16;
        if (curBitmap.getWidth() != 0 && curBitmap.getHeight() != 0) {
            f16 = RangesKt___RangesKt.coerceAtLeast(bounds.width() / curBitmap.getWidth(), bounds.height() / curBitmap.getHeight());
        } else {
            f16 = 1.0f;
        }
        int width = (int) (curBitmap.getWidth() * f16);
        int height = (int) (curBitmap.getHeight() * f16);
        int width2 = bounds.left + ((bounds.width() - width) / 2);
        int height2 = bounds.top + ((bounds.height() - height) / 2);
        return new Rect(width2, height2, width + width2, height + height2);
    }

    private final Rect l(Rect bounds, Bitmap curBitmap, Rect srcRect) {
        int width = bounds.left + ((bounds.width() - curBitmap.getWidth()) / 2);
        int height = bounds.top + ((bounds.height() - curBitmap.getHeight()) / 2);
        return new Rect(width, height, srcRect.width() + width, curBitmap.getHeight() + height);
    }

    private final Rect m(Rect bounds, Bitmap curBitmap, Rect srcRect) {
        int width = bounds.left + ((bounds.width() - curBitmap.getWidth()) / 2);
        return new Rect(width, 0, srcRect.width() + width, srcRect.height() + 0);
    }

    private final Rect n(Rect bounds, Bitmap curBitmap, Rect srcRect) {
        int height = bounds.top + ((bounds.height() - curBitmap.getHeight()) / 2);
        return new Rect(0, height, srcRect.width() + 0, srcRect.height() + height);
    }

    private final void t() {
        int i3;
        d.a aVar;
        if (this.mIsNeedPlay && this.mFrameCount > 1) {
            if (Intrinsics.compare(this.mFirstFrameTime, 0L) == 0) {
                this.mFirstFrameTime = SystemClock.uptimeMillis();
                d.a aVar2 = this.mListener;
                if (aVar2 != null) {
                    aVar2.onStart();
                }
            }
            int i16 = this.mLoopCount;
            if (i16 != -1 && this.mShouldFrameIndex < this.mCurFrameIndex) {
                this.mCurLooper++;
            }
            if (i16 != -1 && (i3 = this.mCurLooper) >= i16) {
                if (i3 == i16 && (aVar = this.mListener) != null) {
                    aVar.onEnd();
                    return;
                }
                return;
            }
            int i17 = this.mShouldFrameIndex;
            if (i17 == this.mCurFrameIndex) {
                r().b((this.mCurFrameIndex + 1) % this.mFrameCount);
            } else {
                this.mCurFrameIndex = i17;
                r().b(this.mCurFrameIndex);
            }
        }
    }

    private final void u() {
        CacheDrawable.CacheState cacheState = this.mCacheState;
        if (cacheState != null) {
            cacheState.d();
        }
    }

    private final boolean v(boolean isHardwareAccelerated) {
        Bitmap.Config config;
        Bitmap a16;
        if (Build.VERSION.SDK_INT >= 26) {
            com.tencent.cachedrawable.dynamicdrawable.cachedrawable.manager.b bVar = this.mCurFrameAnimData;
            Bitmap.Config config2 = null;
            if (bVar != null && (a16 = bVar.a()) != null) {
                config2 = a16.getConfig();
            }
            config = Bitmap.Config.HARDWARE;
            if (config2 == config && !isHardwareAccelerated) {
                return true;
            }
        }
        return false;
    }

    public final void A(boolean isUseHardware) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, isUseHardware);
        } else {
            this.mIsUseHardware = isUseHardware;
            this.mProducer.w(isUseHardware);
        }
    }

    public final void B(int loopCount) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this, loopCount);
        } else {
            this.mLoopCount = loopCount;
        }
    }

    public final void C(@NotNull int[] ninePatchXRegions, @NotNull int[] ninePatchYRegions) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) ninePatchXRegions, (Object) ninePatchYRegions);
            return;
        }
        Intrinsics.checkNotNullParameter(ninePatchXRegions, "ninePatchXRegions");
        Intrinsics.checkNotNullParameter(ninePatchYRegions, "ninePatchYRegions");
        this.ninePatchXRegions = ninePatchXRegions;
        this.ninePatchYRegions = ninePatchYRegions;
    }

    public final void D(@NotNull d.b selfDrawHelper) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) selfDrawHelper);
        } else {
            Intrinsics.checkNotNullParameter(selfDrawHelper, "selfDrawHelper");
            this.mSelfDrawHelper = selfDrawHelper;
        }
    }

    public final void E(@NotNull com.tencent.cachedrawable.dynamicdrawable.a animTimeLine) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, (Object) animTimeLine);
        } else {
            Intrinsics.checkNotNullParameter(animTimeLine, "animTimeLine");
            this.mProducer.x(animTimeLine);
        }
    }

    public final void F() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this);
        } else {
            this.mFirstFrameTime = 0L;
            this.mIsNeedPlay = false;
        }
    }

    @Override // com.tencent.cachedrawable.dynamicdrawable.b
    public void a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this);
            return;
        }
        int[] p16 = this.mProducer.p(this.mCurFrameIndex);
        int i3 = this.mCurFrameIndex;
        int i16 = 0;
        if (i3 != 0 && p16 != null) {
            i16 = p16[i3 - 1];
        }
        this.mFirstFrameTime = SystemClock.uptimeMillis() - i16;
    }

    @Override // com.tencent.cachedrawable.dynamicdrawable.b
    public boolean b(long time) {
        boolean z16;
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this, time)).booleanValue();
        }
        if (this.mCurFrameAnimData == null) {
            com.tencent.cachedrawable.dynamicdrawable.logcat.a.f99049a.d("CacheImage", "consumerTime : mCurFrameAnimData = null");
            return false;
        }
        int[] p16 = this.mProducer.p(this.mCurFrameIndex);
        if (p16 == null) {
            return false;
        }
        if (p16.length == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            int i16 = p16[0];
            if (i16 <= 0) {
                com.tencent.cachedrawable.dynamicdrawable.logcat.a.f99049a.d("CacheImage", Intrinsics.stringPlus("consumerTime : maxDelayTime = ", Integer.valueOf(i16)));
                return false;
            }
            long j3 = time - this.mFirstFrameTime;
            if (p16[p16.length - 1] != 0) {
                j3 %= p16[p16.length - 1];
            }
            if (i16 > j3) {
                this.mShouldFrameIndex = 0;
            } else {
                int length = p16.length - 1;
                if (length > 0) {
                    int i17 = 0;
                    while (true) {
                        i3 = i17 + 1;
                        int i18 = p16[i17];
                        if (i18 != 0 && j3 >= i18) {
                            int i19 = p16[i3];
                            if (j3 < i19 || i19 == 0) {
                                break;
                            }
                        }
                        if (i3 >= length) {
                            break;
                        }
                        i17 = i3;
                    }
                    this.mShouldFrameIndex = i3 % this.mFrameCount;
                }
            }
            if (this.mCurFrameIndex != this.mShouldFrameIndex) {
                return true;
            }
        }
        return false;
    }

    @Override // com.tencent.cachedrawable.dynamicdrawable.b
    public void c(@NotNull com.tencent.cachedrawable.dynamicdrawable.cachedrawable.manager.b frameData) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) frameData);
            return;
        }
        Intrinsics.checkNotNullParameter(frameData, "frameData");
        this.mCurFrameAnimData = frameData;
        if (com.tencent.cachedrawable.dynamicdrawable.business.toggle.a.f98868a.b()) {
            G(this.mCanvasIsHardwareAccelerated);
        }
        u();
    }

    public final void f(@NotNull d.a listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, (Object) this, (Object) listener);
        } else {
            Intrinsics.checkNotNullParameter(listener, "listener");
            this.mListener = listener;
        }
    }

    public final void h(@NotNull Canvas canvas, @NotNull Rect bounds, @NotNull Paint paint, int fitStyle, @NotNull Rect clipBounds) {
        Bitmap a16;
        Rect rect;
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, canvas, bounds, paint, Integer.valueOf(fitStyle), clipBounds);
            return;
        }
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        Intrinsics.checkNotNullParameter(bounds, "bounds");
        Intrinsics.checkNotNullParameter(paint, "paint");
        Intrinsics.checkNotNullParameter(clipBounds, "clipBounds");
        if (this.mIsUseHardware) {
            if (Build.VERSION.SDK_INT >= 26 && canvas.isHardwareAccelerated()) {
                z16 = true;
            } else {
                z16 = false;
            }
            A(z16);
        }
        t();
        this.mCanvasIsHardwareAccelerated = canvas.isHardwareAccelerated();
        if (com.tencent.cachedrawable.dynamicdrawable.business.toggle.a.f98868a.d()) {
            if (H(canvas.isHardwareAccelerated())) {
                return;
            }
        } else {
            G(canvas.isHardwareAccelerated());
        }
        com.tencent.cachedrawable.dynamicdrawable.cachedrawable.manager.b bVar = this.mCurFrameAnimData;
        byte[] bArr = null;
        if (bVar == null) {
            a16 = null;
        } else {
            a16 = bVar.a();
        }
        if (a16 == null) {
            return;
        }
        d.b bVar2 = this.mSelfDrawHelper;
        if (bVar2 == null) {
            if (this.ninePatchXRegions != null && this.ninePatchYRegions != null) {
                j(a16, clipBounds, paint, canvas);
                return;
            }
            byte[] ninePatchChunk = a16.getNinePatchChunk();
            if (ninePatchChunk == null) {
                com.tencent.cachedrawable.dynamicdrawable.cachedrawable.manager.b bVar3 = this.mCurFrameAnimData;
                if (bVar3 != null) {
                    bArr = bVar3.f();
                }
            } else {
                bArr = ninePatchChunk;
            }
            if (NinePatch.isNinePatchChunk(bArr)) {
                i(a16, bArr, bounds, clipBounds, paint, canvas);
                return;
            }
            Rect rect2 = new Rect(0, 0, a16.getWidth(), a16.getHeight());
            if (fitStyle != 0) {
                if (fitStyle != 1) {
                    if (fitStyle != 2) {
                        if (fitStyle != 3) {
                            if (fitStyle != 4) {
                                rect = new Rect(0, 0, rect2.width(), rect2.height());
                            } else {
                                rect = k(a16, bounds);
                            }
                        } else {
                            rect = n(bounds, a16, rect2);
                        }
                    } else {
                        rect = m(bounds, a16, rect2);
                    }
                } else {
                    rect = l(bounds, a16, rect2);
                }
            } else {
                rect = bounds;
            }
            canvas.drawBitmap(a16, rect2, rect, paint);
            return;
        }
        bVar2.a(canvas, a16);
    }

    public final int o() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Integer) iPatchRedirector.redirect((short) 11, (Object) this)).intValue();
        }
        return this.mCurFrameIndex;
    }

    public final int p() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Integer) iPatchRedirector.redirect((short) 10, (Object) this)).intValue();
        }
        return this.mFrameCount;
    }

    public final int q() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return ((Integer) iPatchRedirector.redirect((short) 21, (Object) this)).intValue();
        }
        com.tencent.cachedrawable.dynamicdrawable.cachedrawable.manager.b bVar = this.mCurFrameAnimData;
        if (bVar == null) {
            return -1;
        }
        return bVar.e();
    }

    @NotNull
    public com.tencent.cachedrawable.dynamicdrawable.h r() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (com.tencent.cachedrawable.dynamicdrawable.h) iPatchRedirector.redirect((short) 13, (Object) this);
        }
        return this.mProducer;
    }

    public final int s() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return ((Integer) iPatchRedirector.redirect((short) 20, (Object) this)).intValue();
        }
        com.tencent.cachedrawable.dynamicdrawable.cachedrawable.manager.b bVar = this.mCurFrameAnimData;
        if (bVar == null) {
            return -1;
        }
        return bVar.h();
    }

    public final boolean w() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        if (this.mCurFrameAnimData != null) {
            return true;
        }
        return false;
    }

    public final void x() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this);
            return;
        }
        this.mFirstFrameTime = SystemClock.uptimeMillis();
        this.mIsNeedPlay = true;
        this.mCurFrameIndex = 0;
        this.mCurLooper = 0;
        u();
    }

    public final void y(@NotNull CacheDrawable.CacheState cacheState) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) cacheState);
        } else {
            Intrinsics.checkNotNullParameter(cacheState, "cacheState");
            this.mCacheState = cacheState;
        }
    }

    public final void z(boolean isUse2BitmapMode) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, isUse2BitmapMode);
        } else {
            this.mProducer.v(isUse2BitmapMode);
        }
    }
}
