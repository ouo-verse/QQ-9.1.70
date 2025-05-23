package com.tencent.cachedrawable.dynamicdrawable.cachedrawable;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import com.heytap.databaseengine.model.UserInfo;
import com.qq.e.comm.managers.plugin.PM;
import com.tencent.ams.mosaic.jsengine.animation.custom.CustomAnimation;
import com.tencent.cachedrawable.dynamicdrawable.cachedrawable.AbsAsyncDrawable;
import com.tencent.cachedrawable.dynamicdrawable.cachedrawable.j;
import com.tencent.cachedrawable.dynamicdrawable.d;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.tianshu.data.RedTouchConst;
import com.tencent.mobileqq.transfile.dns.DomainData;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u0000 _2\u00020\u00012\u00020\u00022\u00020\u0003:\u0002`!B\u000f\u0012\u0006\u0010\\\u001a\u00020 \u00a2\u0006\u0004\b]\u0010^J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0006\u0010\b\u001a\u00020\u0006J\u000e\u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tJ\u0016\u0010\u000f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\fJ\u0016\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0010J\u000e\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\tJ\u0010\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0016H\u0016J\u0012\u0010\u001b\u001a\u00020\u00062\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019H\u0016J\b\u0010\u001c\u001a\u00020\u0016H\u0016J\b\u0010\u001d\u001a\u00020\u0016H\u0016J\b\u0010\u001e\u001a\u00020\u0016H\u0016J\b\u0010\u001f\u001a\u00020\u0016H\u0016J\n\u0010!\u001a\u0004\u0018\u00010 H\u0016J\u0010\u0010#\u001a\u00020\u00062\u0006\u0010\"\u001a\u00020\u0016H\u0016J\u0010\u0010&\u001a\u00020\u00062\u0006\u0010%\u001a\u00020$H\u0016J\u0010\u0010)\u001a\u00020\u00062\u0006\u0010(\u001a\u00020'H\u0016J\u0010\u0010+\u001a\u00020\u00062\u0006\u0010*\u001a\u00020\u0016H\u0016J\u0010\u0010.\u001a\u00020\u00062\u0006\u0010-\u001a\u00020,H\u0016J\u0010\u00101\u001a\u00020\u00062\u0006\u00100\u001a\u00020/H\u0016J\u0010\u00103\u001a\u00020\u00062\u0006\u00102\u001a\u00020\tH\u0016J\b\u00104\u001a\u00020\u0016H\u0016J\b\u00105\u001a\u00020\u0006H\u0016J\b\u00106\u001a\u00020\u0006H\u0016J\u0010\u00109\u001a\u00020\u00062\u0006\u00108\u001a\u000207H\u0016J\u0010\u0010;\u001a\u00020\u00062\u0006\u0010:\u001a\u00020$H\u0016J(\u0010;\u001a\u00020\u00062\u0006\u0010<\u001a\u00020\u00162\u0006\u0010=\u001a\u00020\u00162\u0006\u0010>\u001a\u00020\u00162\u0006\u0010?\u001a\u00020\u0016H\u0016J\b\u0010@\u001a\u00020\u0016H\u0016J\b\u0010A\u001a\u00020\u0016H\u0016J\b\u0010B\u001a\u00020\tH\u0016R\u0016\u0010E\u001a\u00020C8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b.\u0010DR\u0016\u0010G\u001a\u00020'8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bB\u0010FR\u0018\u0010I\u001a\u0004\u0018\u00010$8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\b\u0010HR\u0016\u0010K\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b)\u0010JR\u0016\u0010M\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b+\u0010LR\u0018\u0010N\u001a\u0004\u0018\u00010$8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010HR\u0014\u0010Q\u001a\u00020 8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bO\u0010PR\u0014\u0010U\u001a\u00020R8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bS\u0010TR\u0016\u0010X\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bV\u0010WR\u0016\u0010Y\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bW\u0010WR\u0016\u0010[\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bZ\u0010L\u00a8\u0006a"}, d2 = {"Lcom/tencent/cachedrawable/dynamicdrawable/cachedrawable/CacheDrawable;", "Landroid/graphics/drawable/Drawable;", "Lcom/tencent/cachedrawable/dynamicdrawable/d;", "Lcom/tencent/cachedrawable/dynamicdrawable/cachedrawable/j$b;", "Landroid/graphics/Canvas;", PM.CANVAS, "", "draw", "f", "", "isUse2BitmapMode", "l", "", "ninePatchXRegions", "ninePatchYRegions", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "", "rx", "ry", "o", RedTouchConst.PicDownload.ISCIRCLE, "j", "", com.tencent.luggage.wxa.c8.c.f123400v, "setAlpha", "Landroid/graphics/ColorFilter;", CustomAnimation.KeyPath.COLOR_FILTER, "setColorFilter", "g", "getHeight", "getFrameCount", "c", "Lcom/tencent/cachedrawable/dynamicdrawable/cachedrawable/CacheDrawable$CacheState;", "a", "loopCount", "setLoopCount", "Landroid/graphics/Rect;", "padding", DomainData.DOMAIN_NAME, "", "align", tl.h.F, "fitStyle", "i", "Lcom/tencent/cachedrawable/dynamicdrawable/d$a;", "listener", "d", "Lcom/tencent/cachedrawable/dynamicdrawable/d$b;", "selfDrawHelper", "b", "isMirror", "k", "getOpacity", "stop", "restart", "Lcom/tencent/cachedrawable/dynamicdrawable/a;", "timeLine", "p", "bounds", "setBounds", "left", "top", "right", "bottom", "getIntrinsicWidth", "getIntrinsicHeight", "e", "Landroid/graphics/Paint;", "Landroid/graphics/Paint;", "mPaint", "Ljava/lang/String;", "mAlign", "Landroid/graphics/Rect;", "mPadding", "I", "mFitStyle", "Z", "mIsMirror", "mDrawableBounds", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/cachedrawable/dynamicdrawable/cachedrawable/CacheDrawable$CacheState;", "mCacheState", "Lcom/tencent/cachedrawable/dynamicdrawable/cachedrawable/j;", "D", "Lcom/tencent/cachedrawable/dynamicdrawable/cachedrawable/j;", "mCacheImage", "E", UserInfo.SEX_FEMALE, "mRx", "mRy", "G", "mIsCircle", "cacheState", "<init>", "(Lcom/tencent/cachedrawable/dynamicdrawable/cachedrawable/CacheDrawable$CacheState;)V", "H", "CacheState", "cachedrawable_debug"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes5.dex */
public final class CacheDrawable extends Drawable implements com.tencent.cachedrawable.dynamicdrawable.d, j.b {
    static IPatchRedirector $redirector_;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final CacheState mCacheState;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final j mCacheImage;

    /* renamed from: E, reason: from kotlin metadata */
    private float mRx;

    /* renamed from: F, reason: from kotlin metadata */
    private float mRy;

    /* renamed from: G, reason: from kotlin metadata */
    private boolean mIsCircle;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private Paint mPaint;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String mAlign;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Rect mPadding;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private int mFitStyle;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private boolean mIsMirror;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Rect mDrawableBounds;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u000212B\u001f\u0012\u0006\u0010\u0013\u001a\u00020\u000f\u0012\u0006\u0010,\u001a\u00020+\u0012\u0006\u0010.\u001a\u00020-\u00a2\u0006\u0004\b/\u00100J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u000e\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u0006\u0010\u0007\u001a\u00020\u0002J\b\u0010\t\u001a\u00020\bH\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016J\u0012\u0010\u000e\u001a\u00020\n2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016R\u0017\u0010\u0013\u001a\u00020\u000f8\u0006\u00a2\u0006\f\n\u0004\b\u0006\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\"\u0010\u001a\u001a\u00020\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\"\u0010 \u001a\u00020\u001b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u001c\u001a\u0004\b\u0014\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u0016\u0010#\u001a\u00020!8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\"R \u0010'\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040%0$8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010&R\u0014\u0010*\u001a\u00020(8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010)\u00a8\u00063"}, d2 = {"Lcom/tencent/cachedrawable/dynamicdrawable/cachedrawable/CacheDrawable$CacheState;", "Landroid/graphics/drawable/Drawable$ConstantState;", "", "c", "Lcom/tencent/cachedrawable/dynamicdrawable/cachedrawable/j$b;", "callback", "a", "d", "", "getChangingConfigurations", "Lcom/tencent/cachedrawable/dynamicdrawable/cachedrawable/CacheDrawable;", "e", "Landroid/content/res/Resources;", "res", "f", "", "Ljava/lang/String;", "getFilePath", "()Ljava/lang/String;", "filePath", "b", "I", "getMChangingConfigurations", "()I", "setMChangingConfigurations", "(I)V", "mChangingConfigurations", "Lcom/tencent/cachedrawable/dynamicdrawable/cachedrawable/j;", "Lcom/tencent/cachedrawable/dynamicdrawable/cachedrawable/j;", "()Lcom/tencent/cachedrawable/dynamicdrawable/cachedrawable/j;", "setMCacheImage", "(Lcom/tencent/cachedrawable/dynamicdrawable/cachedrawable/j;)V", "mCacheImage", "Landroid/os/Handler;", "Landroid/os/Handler;", "workHandler", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Ljava/lang/ref/WeakReference;", "Ljava/util/concurrent/CopyOnWriteArrayList;", "callbacks", "Lcom/tencent/cachedrawable/dynamicdrawable/cachedrawable/CacheDrawable$CacheState$PostInvalidateTask;", "Lcom/tencent/cachedrawable/dynamicdrawable/cachedrawable/CacheDrawable$CacheState$PostInvalidateTask;", "postInvalidateTask", "Lcom/tencent/cachedrawable/dynamicdrawable/e;", "fileDecoder", "", "useFileCache", "<init>", "(Ljava/lang/String;Lcom/tencent/cachedrawable/dynamicdrawable/e;Z)V", "InvalidateTask", "PostInvalidateTask", "cachedrawable_debug"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes5.dex */
    public static final class CacheState extends Drawable.ConstantState {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final String filePath;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        private int mChangingConfigurations;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private j mCacheImage;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private Handler workHandler;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final CopyOnWriteArrayList<WeakReference<j.b>> callbacks;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final PostInvalidateTask postInvalidateTask;

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B+\u0012\"\u0010\n\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0004j\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005`\u0007\u00a2\u0006\u0004\b\u000b\u0010\fJ\b\u0010\u0003\u001a\u00020\u0002H\u0016R0\u0010\n\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0004j\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005`\u00078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\t\u00a8\u0006\r"}, d2 = {"Lcom/tencent/cachedrawable/dynamicdrawable/cachedrawable/CacheDrawable$CacheState$InvalidateTask;", "Ljava/lang/Runnable;", "", TencentLocation.RUN_MODE, "Ljava/util/ArrayList;", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/cachedrawable/dynamicdrawable/cachedrawable/j$b;", "Lkotlin/collections/ArrayList;", "d", "Ljava/util/ArrayList;", "callbacks", "<init>", "(Ljava/util/ArrayList;)V", "cachedrawable_debug"}, k = 1, mv = {1, 5, 1})
        /* loaded from: classes5.dex */
        public static final class InvalidateTask implements Runnable {
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name and from kotlin metadata */
            @NotNull
            private final ArrayList<WeakReference<j.b>> callbacks;

            public InvalidateTask(@NotNull ArrayList<WeakReference<j.b>> callbacks) {
                Intrinsics.checkNotNullParameter(callbacks, "callbacks");
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) callbacks);
                } else {
                    this.callbacks = callbacks;
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                synchronized (this.callbacks) {
                    Iterator<T> it = this.callbacks.iterator();
                    while (it.hasNext()) {
                        j.b bVar = (j.b) ((WeakReference) it.next()).get();
                        if (bVar != null) {
                            bVar.invalidateSelf();
                        }
                    }
                    Unit unit = Unit.INSTANCE;
                }
            }
        }

        /* compiled from: P */
        @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B#\u0012\u0012\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u0005\u0012\u0006\u0010\r\u001a\u00020\u000b\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0016R \u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u00058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\tR\u0014\u0010\r\u001a\u00020\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\fR0\u0010\u0012\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u000ej\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0006`\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0016\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0014\u0010\u001a\u001a\u00020\u00178\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/cachedrawable/dynamicdrawable/cachedrawable/CacheDrawable$CacheState$PostInvalidateTask;", "Ljava/lang/Runnable;", "", "e", TencentLocation.RUN_MODE, "Ljava/util/concurrent/CopyOnWriteArrayList;", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/cachedrawable/dynamicdrawable/cachedrawable/j$b;", "d", "Ljava/util/concurrent/CopyOnWriteArrayList;", "callbacks", "", "Ljava/lang/String;", "filePath", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "f", "Ljava/util/ArrayList;", "invalidateCallbacks", "Landroid/os/Handler;", tl.h.F, "Landroid/os/Handler;", "invalidateHandler", "Lcom/tencent/cachedrawable/dynamicdrawable/cachedrawable/CacheDrawable$CacheState$InvalidateTask;", "i", "Lcom/tencent/cachedrawable/dynamicdrawable/cachedrawable/CacheDrawable$CacheState$InvalidateTask;", "invalidateTask", "<init>", "(Ljava/util/concurrent/CopyOnWriteArrayList;Ljava/lang/String;)V", "cachedrawable_debug"}, k = 1, mv = {1, 5, 1})
        /* loaded from: classes5.dex */
        public static final class PostInvalidateTask implements Runnable {
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name and from kotlin metadata */
            @NotNull
            private final CopyOnWriteArrayList<WeakReference<j.b>> callbacks;

            /* renamed from: e, reason: collision with root package name and from kotlin metadata */
            @NotNull
            private final String filePath;

            /* renamed from: f, reason: collision with root package name and from kotlin metadata */
            @NotNull
            private final ArrayList<WeakReference<j.b>> invalidateCallbacks;

            /* renamed from: h, reason: collision with root package name and from kotlin metadata */
            @NotNull
            private Handler invalidateHandler;

            /* renamed from: i, reason: collision with root package name and from kotlin metadata */
            @NotNull
            private final InvalidateTask invalidateTask;

            public PostInvalidateTask(@NotNull CopyOnWriteArrayList<WeakReference<j.b>> callbacks, @NotNull String filePath) {
                Intrinsics.checkNotNullParameter(callbacks, "callbacks");
                Intrinsics.checkNotNullParameter(filePath, "filePath");
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) callbacks, (Object) filePath);
                    return;
                }
                this.callbacks = callbacks;
                this.filePath = filePath;
                ArrayList<WeakReference<j.b>> arrayList = new ArrayList<>();
                this.invalidateCallbacks = arrayList;
                this.invalidateHandler = new Handler(Looper.getMainLooper());
                this.invalidateTask = new InvalidateTask(arrayList);
            }

            private final void e() {
                if (Intrinsics.areEqual(Looper.getMainLooper(), Looper.myLooper())) {
                    this.invalidateHandler.removeCallbacks(this.invalidateTask);
                    this.invalidateTask.run();
                } else {
                    this.invalidateHandler.removeCallbacks(this.invalidateTask);
                    this.invalidateHandler.post(this.invalidateTask);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                synchronized (this.invalidateCallbacks) {
                    this.invalidateCallbacks.clear();
                    for (WeakReference<j.b> weakReference : this.callbacks) {
                        j.b bVar = weakReference.get();
                        if (bVar == null) {
                            this.callbacks.remove(weakReference);
                        } else if (bVar.e()) {
                            this.invalidateCallbacks.add(weakReference);
                        }
                    }
                    if (this.invalidateCallbacks.isEmpty()) {
                        com.tencent.cachedrawable.dynamicdrawable.logcat.a.f99049a.b("CacheDrawable", Intrinsics.stringPlus("invalidateCallbacks isEmpty filePath : ", this.filePath));
                    } else {
                        e();
                        Unit unit = Unit.INSTANCE;
                    }
                }
            }
        }

        public CacheState(@NotNull String filePath, @NotNull com.tencent.cachedrawable.dynamicdrawable.e fileDecoder, boolean z16) {
            Intrinsics.checkNotNullParameter(filePath, "filePath");
            Intrinsics.checkNotNullParameter(fileDecoder, "fileDecoder");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, filePath, fileDecoder, Boolean.valueOf(z16));
                return;
            }
            this.filePath = filePath;
            this.workHandler = new Handler(com.tencent.cachedrawable.dynamicdrawable.cachedrawable.manager.h.f99037a.f().getLooper());
            CopyOnWriteArrayList<WeakReference<j.b>> copyOnWriteArrayList = new CopyOnWriteArrayList<>();
            this.callbacks = copyOnWriteArrayList;
            this.postInvalidateTask = new PostInvalidateTask(copyOnWriteArrayList, filePath);
            this.mCacheImage = new j(filePath, fileDecoder, z16);
            c();
        }

        private final void c() {
            this.mCacheImage.y(this);
        }

        public final void a(@NotNull j.b callback) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                iPatchRedirector.redirect((short) 7, (Object) this, (Object) callback);
            } else {
                Intrinsics.checkNotNullParameter(callback, "callback");
                this.callbacks.add(new WeakReference<>(callback));
            }
        }

        @NotNull
        public final j b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return (j) iPatchRedirector.redirect((short) 5, (Object) this);
            }
            return this.mCacheImage;
        }

        public final void d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                iPatchRedirector.redirect((short) 9, (Object) this);
            } else {
                this.workHandler.removeCallbacks(this.postInvalidateTask);
                this.workHandler.postDelayed(this.postInvalidateTask, 10L);
            }
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        @NotNull
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public CacheDrawable newDrawable() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
                return (CacheDrawable) iPatchRedirector.redirect((short) 11, (Object) this);
            }
            return new CacheDrawable(this);
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        @NotNull
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public CacheDrawable newDrawable(@Nullable Resources res) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
                return (CacheDrawable) iPatchRedirector.redirect((short) 12, (Object) this, (Object) res);
            }
            return new CacheDrawable(this);
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
                return ((Integer) iPatchRedirector.redirect((short) 10, (Object) this)).intValue();
            }
            return this.mChangingConfigurations;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\r\u0010\u000eR\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0004R\u0014\u0010\b\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0004R\u0014\u0010\t\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0004R\u0014\u0010\u000b\u001a\u00020\n8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\f\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/cachedrawable/dynamicdrawable/cachedrawable/CacheDrawable$a;", "", "", "CENTER_CROP", "I", "FIT_CENTER", "FIT_CENTER_X", "FIT_CENTER_Y", "FIT_NONE", "FIT_XY", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "cachedrawable_debug"}, k = 1, mv = {1, 5, 1})
    /* renamed from: com.tencent.cachedrawable.dynamicdrawable.cachedrawable.CacheDrawable$a, reason: from kotlin metadata */
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

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(9260);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 36)) {
            redirector.redirect((short) 36);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public CacheDrawable(@NotNull CacheState cacheState) {
        Intrinsics.checkNotNullParameter(cacheState, "cacheState");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) cacheState);
            return;
        }
        this.mPaint = new Paint();
        this.mAlign = "TL";
        this.mCacheState = cacheState;
        this.mCacheImage = cacheState.b();
        cacheState.a(this);
    }

    @Override // com.tencent.cachedrawable.dynamicdrawable.d
    @Nullable
    public CacheState a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return (CacheState) iPatchRedirector.redirect((short) 15, (Object) this);
        }
        return this.mCacheState;
    }

    @Override // com.tencent.cachedrawable.dynamicdrawable.d
    public void b(@NotNull d.b selfDrawHelper) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, (Object) this, (Object) selfDrawHelper);
        } else {
            Intrinsics.checkNotNullParameter(selfDrawHelper, "selfDrawHelper");
            this.mCacheImage.D(selfDrawHelper);
        }
    }

    @Override // com.tencent.cachedrawable.dynamicdrawable.d
    public int c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Integer) iPatchRedirector.redirect((short) 14, (Object) this)).intValue();
        }
        return this.mCacheImage.o();
    }

    @Override // com.tencent.cachedrawable.dynamicdrawable.d
    public void d(@NotNull d.a listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this, (Object) listener);
        } else {
            Intrinsics.checkNotNullParameter(listener, "listener");
            this.mCacheImage.f(listener);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NotNull Canvas canvas) {
        Rect rect;
        Rect rect2;
        int saveLayer;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) canvas);
            return;
        }
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        Rect clipBounds = canvas.getClipBounds();
        Intrinsics.checkNotNullExpressionValue(clipBounds, "canvas.clipBounds");
        if (this.mDrawableBounds == null) {
            rect2 = clipBounds;
        } else {
            String str = this.mAlign;
            int hashCode = str.hashCode();
            if (hashCode != 2122) {
                if (hashCode != 2128) {
                    if (hashCode != 2680) {
                        if (hashCode == 2686 && str.equals("TR")) {
                            Rect rect3 = this.mDrawableBounds;
                            Intrinsics.checkNotNull(rect3);
                            clipBounds.top = rect3.top;
                            int i3 = clipBounds.right;
                            Rect rect4 = this.mDrawableBounds;
                            Intrinsics.checkNotNull(rect4);
                            clipBounds.left = i3 - rect4.width();
                            int i16 = clipBounds.top;
                            Rect rect5 = this.mDrawableBounds;
                            Intrinsics.checkNotNull(rect5);
                            clipBounds.bottom = i16 + rect5.height();
                        }
                    } else if (str.equals("TL")) {
                        rect = this.mDrawableBounds;
                        Intrinsics.checkNotNull(rect);
                        rect2 = rect;
                    }
                } else if (str.equals("BR")) {
                    int i17 = clipBounds.bottom;
                    Rect rect6 = this.mDrawableBounds;
                    Intrinsics.checkNotNull(rect6);
                    clipBounds.top = i17 - rect6.height();
                    int i18 = clipBounds.right;
                    Rect rect7 = this.mDrawableBounds;
                    Intrinsics.checkNotNull(rect7);
                    clipBounds.left = i18 - rect7.width();
                }
            } else if (str.equals("BL")) {
                Rect rect8 = this.mDrawableBounds;
                Intrinsics.checkNotNull(rect8);
                clipBounds.left = rect8.left;
                int i19 = clipBounds.bottom;
                Rect rect9 = this.mDrawableBounds;
                Intrinsics.checkNotNull(rect9);
                clipBounds.top = i19 - rect9.height();
                Rect rect10 = this.mDrawableBounds;
                Intrinsics.checkNotNull(rect10);
                int i26 = rect10.left;
                Rect rect11 = this.mDrawableBounds;
                Intrinsics.checkNotNull(rect11);
                clipBounds.right = i26 + rect11.width();
            }
            rect = clipBounds;
            rect2 = rect;
        }
        Rect rect12 = this.mPadding;
        if (rect12 != null) {
            int i27 = rect2.left;
            Intrinsics.checkNotNull(rect12);
            rect2.left = i27 + rect12.left;
            int i28 = rect2.top;
            Rect rect13 = this.mPadding;
            Intrinsics.checkNotNull(rect13);
            rect2.top = i28 + rect13.top;
            int i29 = rect2.right;
            Rect rect14 = this.mPadding;
            Intrinsics.checkNotNull(rect14);
            rect2.right = i29 - rect14.right;
            int i36 = rect2.bottom;
            Rect rect15 = this.mPadding;
            Intrinsics.checkNotNull(rect15);
            rect2.bottom = i36 - rect15.bottom;
        }
        if (this.mIsMirror) {
            canvas.save();
            canvas.translate(clipBounds.width(), 0.0f);
            canvas.scale(-1.0f, 1.0f);
        }
        if (this.mIsCircle) {
            this.mRx = rect2.width() / 2.0f;
            this.mRy = rect2.height() / 2.0f;
        }
        if (this.mRx <= 0.0f && this.mRy <= 0.0f) {
            saveLayer = 0;
        } else {
            saveLayer = canvas.saveLayer(clipBounds.left, clipBounds.top, clipBounds.right, clipBounds.bottom, this.mPaint, 31);
            canvas.drawRoundRect(rect2.left, rect2.top, rect2.right, rect2.bottom, this.mRx, this.mRy, this.mPaint);
            this.mPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        }
        this.mCacheImage.h(canvas, rect2, this.mPaint, this.mFitStyle, clipBounds);
        if (this.mRx > 0.0f || this.mRy > 0.0f) {
            this.mPaint.setXfermode(null);
            canvas.restoreToCount(saveLayer);
        }
        if (this.mIsMirror) {
            try {
                canvas.restore();
            } catch (Exception e16) {
                com.tencent.cachedrawable.dynamicdrawable.logcat.a.f99049a.b("CacheDrawable", Intrinsics.stringPlus("canvas.restore() error ", e16));
            }
        }
    }

    @Override // com.tencent.cachedrawable.dynamicdrawable.cachedrawable.j.b
    public boolean e() {
        boolean z16;
        AbsAsyncDrawable.a aVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 35)) {
            return ((Boolean) iPatchRedirector.redirect((short) 35, (Object) this)).booleanValue();
        }
        Drawable.Callback callback = getCallback();
        if (callback != null && ((z16 = callback instanceof AbsAsyncDrawable.a))) {
            if (z16) {
                aVar = (AbsAsyncDrawable.a) callback;
            } else {
                aVar = null;
            }
            if (aVar != null && aVar.d()) {
                return true;
            }
        } else if (callback != null) {
            return true;
        }
        return false;
    }

    public final void f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            this.mCacheImage.A(false);
        }
    }

    public int g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Integer) iPatchRedirector.redirect((short) 10, (Object) this)).intValue();
        }
        return this.mCacheImage.s();
    }

    @Override // com.tencent.cachedrawable.dynamicdrawable.d
    public int getFrameCount() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Integer) iPatchRedirector.redirect((short) 13, (Object) this)).intValue();
        }
        return this.mCacheImage.p();
    }

    @Override // com.tencent.cachedrawable.dynamicdrawable.d
    public int getHeight() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Integer) iPatchRedirector.redirect((short) 11, (Object) this)).intValue();
        }
        return this.mCacheImage.q();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
            return ((Integer) iPatchRedirector.redirect((short) 34, (Object) this)).intValue();
        }
        return getHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            return ((Integer) iPatchRedirector.redirect((short) 33, (Object) this)).intValue();
        }
        return g();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            return ((Integer) iPatchRedirector.redirect((short) 25, (Object) this)).intValue();
        }
        return 0;
    }

    public void h(@NotNull String align) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, (Object) align);
        } else {
            Intrinsics.checkNotNullParameter(align, "align");
            this.mAlign = align;
        }
    }

    public void i(int fitStyle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this, fitStyle);
        } else {
            this.mFitStyle = fitStyle;
        }
    }

    public final void j(boolean isCircle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, isCircle);
        } else {
            this.mIsCircle = isCircle;
        }
    }

    public void k(boolean isMirror) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, (Object) this, isMirror);
        } else {
            this.mIsMirror = isMirror;
        }
    }

    public final void l(boolean isUse2BitmapMode) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, isUse2BitmapMode);
        } else {
            this.mCacheImage.z(isUse2BitmapMode);
        }
    }

    public final void m(@NotNull int[] ninePatchXRegions, @NotNull int[] ninePatchYRegions) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) ninePatchXRegions, (Object) ninePatchYRegions);
            return;
        }
        Intrinsics.checkNotNullParameter(ninePatchXRegions, "ninePatchXRegions");
        Intrinsics.checkNotNullParameter(ninePatchYRegions, "ninePatchYRegions");
        this.mCacheImage.C(ninePatchXRegions, ninePatchYRegions);
    }

    public void n(@NotNull Rect padding) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, (Object) padding);
        } else {
            Intrinsics.checkNotNullParameter(padding, "padding");
            this.mPadding = padding;
        }
    }

    public final void o(float rx5, float ry5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, Float.valueOf(rx5), Float.valueOf(ry5));
        } else {
            this.mRx = rx5;
            this.mRy = ry5;
        }
    }

    public void p(@NotNull com.tencent.cachedrawable.dynamicdrawable.a timeLine) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            iPatchRedirector.redirect((short) 30, (Object) this, (Object) timeLine);
        } else {
            Intrinsics.checkNotNullParameter(timeLine, "timeLine");
            this.mCacheImage.E(timeLine);
        }
    }

    @Override // com.tencent.cachedrawable.dynamicdrawable.d
    public void restart() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            iPatchRedirector.redirect((short) 27, (Object) this);
        } else {
            this.mCacheImage.x();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int alpha) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, alpha);
        } else {
            this.mPaint.setAlpha(alpha);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setBounds(@NotNull Rect bounds) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            iPatchRedirector.redirect((short) 31, (Object) this, (Object) bounds);
            return;
        }
        Intrinsics.checkNotNullParameter(bounds, "bounds");
        super.setBounds(bounds);
        this.mDrawableBounds = bounds;
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(@Nullable ColorFilter colorFilter) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) colorFilter);
        } else {
            this.mPaint.setColorFilter(colorFilter);
        }
    }

    @Override // com.tencent.cachedrawable.dynamicdrawable.d
    public void setLoopCount(int loopCount) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, loopCount);
        } else {
            this.mCacheImage.B(loopCount);
        }
    }

    @Override // com.tencent.cachedrawable.dynamicdrawable.d
    public void stop() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, (Object) this);
        } else {
            this.mCacheImage.F();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setBounds(int left, int top, int right, int bottom) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            iPatchRedirector.redirect((short) 32, this, Integer.valueOf(left), Integer.valueOf(top), Integer.valueOf(right), Integer.valueOf(bottom));
        } else {
            super.setBounds(left, top, right, bottom);
            this.mDrawableBounds = new Rect(left, top, right, bottom);
        }
    }
}
