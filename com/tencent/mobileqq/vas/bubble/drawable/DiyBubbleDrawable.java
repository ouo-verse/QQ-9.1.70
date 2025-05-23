package com.tencent.mobileqq.vas.bubble.drawable;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.heytap.databaseengine.model.UserInfo;
import com.qq.e.comm.managers.plugin.PM;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.bubble.IBubbleManager;
import com.tencent.mobileqq.vas.image.AbsAsyncDrawable;
import com.tencent.mobileqq.vas.image.ILoaderSucessCallback;
import com.tencent.mobileqq.vas.updatesystem.api.IVasBusinessManager;
import com.tencent.mobileqq.vas.updatesystem.business.BubbleBusiness;
import com.tencent.mobileqq.vas.updatesystem.business.QQVasUpdateBusiness;
import com.tencent.mobileqq.vas.updatesystem.callback.IDownLoadListener;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.vas.update.entity.UpdateListenerParams;
import d03.BubbleDiyData;
import java.io.File;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import l03.c;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0018\u0018\u0000 \u00072\u00020\u0001:\u0001?BK\u0012\u0006\u0010;\u001a\u00020!\u0012\"\u0010<\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u001c0\u001bj\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u001c`\u001d\u0012\u0006\u0010'\u001a\u00020\b\u0012\u0006\u00109\u001a\u00020\u0002\u0012\u0006\u0010:\u001a\u00020\u0002\u00a2\u0006\u0004\b=\u0010>J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\t\u001a\u00020\bH\u0016J\u0010\u0010\f\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u0016\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0005\u001a\u00020\u0004J\u0010\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0010H\u0016R\u0014\u0010\u0016\u001a\u00020\u00138\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0014\u0010\u001a\u001a\u00020\u00178\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R0\u0010 \u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u001c0\u001bj\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u001c`\u001d8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0014\u0010$\u001a\u00020!8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u0016\u0010'\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u0018\u0010+\u001a\u0004\u0018\u00010(8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b)\u0010*R\u0018\u0010-\u001a\u0004\u0018\u00010(8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b,\u0010*R\u0018\u0010/\u001a\u0004\u0018\u00010(8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b.\u0010*R\u0018\u00101\u001a\u0004\u0018\u00010(8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b0\u0010*R\u0016\u00104\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b2\u00103R\u0018\u00107\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b5\u00106R\u0016\u00109\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b8\u00103R\u0016\u0010:\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u00103\u00a8\u0006@"}, d2 = {"Lcom/tencent/mobileqq/vas/bubble/drawable/DiyBubbleDrawable;", "Lcom/tencent/mobileqq/vas/image/AbsAsyncDrawable;", "", "id", "Lcom/tencent/mobileqq/vas/updatesystem/callback/IDownLoadListener;", "listener", "", "J", "", "isLoadSucess", "Lcom/tencent/mobileqq/vas/image/ILoaderSucessCallback;", "callback", "doLoadTask", "Ld03/a;", "bubbleDiyData", "I", "Landroid/graphics/Canvas;", PM.CANVAS, "draw", "Lcom/tencent/mobileqq/vas/updatesystem/business/BubbleBusiness;", "d", "Lcom/tencent/mobileqq/vas/updatesystem/business/BubbleBusiness;", "bubbleBusiness", "Ll03/c;", "e", "Ll03/c;", "mDIYBubbleDataManager", "Ljava/util/HashMap;", "Lg03/a;", "Lkotlin/collections/HashMap;", "f", "Ljava/util/HashMap;", "mDiyBubbleConfigMap", "Landroid/graphics/drawable/Drawable;", h.F, "Landroid/graphics/drawable/Drawable;", "mBackDrawable", "i", "Z", "isMirror", "Landroid/graphics/Bitmap;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/graphics/Bitmap;", "bitmapTL", BdhLogUtil.LogTag.Tag_Conn, "bitmapTR", "D", "bitmapBL", "E", "bitmapBR", UserInfo.SEX_FEMALE, "Ljava/lang/String;", "diyText", "G", "Ld03/a;", "diyBubbleData", "H", "uin", "diyId", "backDrawable", "diyBubbleConfigMap", "<init>", "(Landroid/graphics/drawable/Drawable;Ljava/util/HashMap;ZLjava/lang/String;Ljava/lang/String;)V", "a", "vas_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class DiyBubbleDrawable extends AbsAsyncDrawable {

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final String K = IBubbleManager.INSTANCE.b() + "DiyBubbleDrawable";

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private Bitmap bitmapTR;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private Bitmap bitmapBL;

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private Bitmap bitmapBR;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private String diyText;

    /* renamed from: G, reason: from kotlin metadata */
    @Nullable
    private BubbleDiyData diyBubbleData;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private String uin;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private String diyId;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final BubbleBusiness bubbleBusiness;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final c mDIYBubbleDataManager;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final HashMap<String, g03.a> mDiyBubbleConfigMap;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Drawable mBackDrawable;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private boolean isMirror;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Bitmap bitmapTL;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/vas/bubble/drawable/DiyBubbleDrawable$a;", "", "", "TAG", "Ljava/lang/String;", "a", "()Ljava/lang/String;", "<init>", "()V", "vas_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.vas.bubble.drawable.DiyBubbleDrawable$a, reason: from kotlin metadata */
    /* loaded from: classes20.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final String a() {
            return DiyBubbleDrawable.K;
        }

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/mobileqq/vas/bubble/drawable/DiyBubbleDrawable$b", "Ll03/c$a;", "", "a", "vas_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes20.dex */
    public static final class b implements c.a {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ ILoaderSucessCallback f308867b;

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/mobileqq/vas/bubble/drawable/DiyBubbleDrawable$b$a", "Lcom/tencent/mobileqq/vas/updatesystem/callback/IDownLoadListener;", "Lcom/tencent/vas/update/entity/UpdateListenerParams;", "params", "", "onLoadSuccess", "onLoadFail", "vas_impl_release"}, k = 1, mv = {1, 7, 1})
        /* loaded from: classes20.dex */
        public static final class a implements IDownLoadListener {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ DiyBubbleDrawable f308868a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ ILoaderSucessCallback f308869b;

            a(DiyBubbleDrawable diyBubbleDrawable, ILoaderSucessCallback iLoaderSucessCallback) {
                this.f308868a = diyBubbleDrawable;
                this.f308869b = iLoaderSucessCallback;
            }

            @Override // com.tencent.mobileqq.vas.updatesystem.callback.IDownLoadListener
            public void onLoadFail(@NotNull UpdateListenerParams params) {
                Intrinsics.checkNotNullParameter(params, "params");
                QLog.e(DiyBubbleDrawable.INSTANCE.a(), 1, "startDownLoadDiyBubbleData onLoadFail : Scid = " + params.mBusinessUpdateParams.mScid);
            }

            @Override // com.tencent.mobileqq.vas.updatesystem.callback.IDownLoadListener
            public void onLoadSuccess(@NotNull UpdateListenerParams params) {
                Intrinsics.checkNotNullParameter(params, "params");
                if (this.f308868a.getIsLoadSuccess()) {
                    this.f308869b.onLoadSucceed();
                }
            }
        }

        b(ILoaderSucessCallback iLoaderSucessCallback) {
            this.f308867b = iLoaderSucessCallback;
        }

        @Override // l03.c.a
        public void a() {
            DiyBubbleDrawable diyBubbleDrawable = DiyBubbleDrawable.this;
            diyBubbleDrawable.diyBubbleData = diyBubbleDrawable.mDIYBubbleDataManager.e(DiyBubbleDrawable.this.uin, DiyBubbleDrawable.this.diyId);
            if (!DiyBubbleDrawable.this.getIsLoadSuccess()) {
                BubbleDiyData bubbleDiyData = DiyBubbleDrawable.this.diyBubbleData;
                if (bubbleDiyData != null) {
                    DiyBubbleDrawable diyBubbleDrawable2 = DiyBubbleDrawable.this;
                    diyBubbleDrawable2.I(bubbleDiyData, new a(diyBubbleDrawable2, this.f308867b));
                    return;
                }
                return;
            }
            this.f308867b.onLoadSucceed();
        }
    }

    public DiyBubbleDrawable(@NotNull Drawable backDrawable, @NotNull HashMap<String, g03.a> diyBubbleConfigMap, boolean z16, @NotNull String uin, @NotNull String diyId) {
        Intrinsics.checkNotNullParameter(backDrawable, "backDrawable");
        Intrinsics.checkNotNullParameter(diyBubbleConfigMap, "diyBubbleConfigMap");
        Intrinsics.checkNotNullParameter(uin, "uin");
        Intrinsics.checkNotNullParameter(diyId, "diyId");
        QQVasUpdateBusiness businessInstance = ((IVasBusinessManager) QRoute.api(IVasBusinessManager.class)).getBusinessInstance((Class<QQVasUpdateBusiness>) BubbleBusiness.class);
        Intrinsics.checkNotNullExpressionValue(businessInstance, "api(IVasBusinessManager:\u2026bbleBusiness::class.java)");
        this.bubbleBusiness = (BubbleBusiness) businessInstance;
        c cVar = new c();
        this.mDIYBubbleDataManager = cVar;
        this.isMirror = true;
        this.diyText = "";
        this.diyId = "";
        this.mDiyBubbleConfigMap = diyBubbleConfigMap;
        this.mBackDrawable = backDrawable;
        this.uin = uin;
        this.diyBubbleData = cVar.e(uin, diyId);
        this.diyId = diyId;
        this.isMirror = z16;
        setFailedDrawableBuild(new Function0() { // from class: com.tencent.mobileqq.vas.bubble.drawable.DiyBubbleDrawable.1
            @Override // kotlin.jvm.functions.Function0
            @Nullable
            public final Void invoke() {
                return null;
            }
        });
        setTargetDrawableBuild(new Function0<BitmapDrawable>() { // from class: com.tencent.mobileqq.vas.bubble.drawable.DiyBubbleDrawable.2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final BitmapDrawable invoke() {
                DiyBubbleDrawable diyBubbleDrawable = DiyBubbleDrawable.this;
                BubbleDiyData bubbleDiyData = diyBubbleDrawable.diyBubbleData;
                Intrinsics.checkNotNull(bubbleDiyData);
                diyBubbleDrawable.diyText = bubbleDiyData.getDiyText();
                BubbleDiyData bubbleDiyData2 = DiyBubbleDrawable.this.diyBubbleData;
                Intrinsics.checkNotNull(bubbleDiyData2);
                String topLeftId = bubbleDiyData2.getTopLeftId();
                DiyBubbleDrawable diyBubbleDrawable2 = DiyBubbleDrawable.this;
                if (!(topLeftId.length() == 0)) {
                    e03.a aVar = e03.a.f395321a;
                    String bubbleDiyPath = diyBubbleDrawable2.bubbleBusiness.getBubbleDiyPath(topLeftId);
                    Intrinsics.checkNotNullExpressionValue(bubbleDiyPath, "bubbleBusiness.getBubbleDiyPath(this)");
                    diyBubbleDrawable2.bitmapTL = aVar.b(bubbleDiyPath);
                }
                BubbleDiyData bubbleDiyData3 = DiyBubbleDrawable.this.diyBubbleData;
                Intrinsics.checkNotNull(bubbleDiyData3);
                String topRightId = bubbleDiyData3.getTopRightId();
                DiyBubbleDrawable diyBubbleDrawable3 = DiyBubbleDrawable.this;
                if (!(topRightId.length() == 0)) {
                    e03.a aVar2 = e03.a.f395321a;
                    String bubbleDiyPath2 = diyBubbleDrawable3.bubbleBusiness.getBubbleDiyPath(topRightId);
                    Intrinsics.checkNotNullExpressionValue(bubbleDiyPath2, "bubbleBusiness.getBubbleDiyPath(this)");
                    diyBubbleDrawable3.bitmapTR = aVar2.b(bubbleDiyPath2);
                }
                BubbleDiyData bubbleDiyData4 = DiyBubbleDrawable.this.diyBubbleData;
                Intrinsics.checkNotNull(bubbleDiyData4);
                String bottomLeftId = bubbleDiyData4.getBottomLeftId();
                DiyBubbleDrawable diyBubbleDrawable4 = DiyBubbleDrawable.this;
                if (!(bottomLeftId.length() == 0)) {
                    e03.a aVar3 = e03.a.f395321a;
                    String bubbleDiyPath3 = diyBubbleDrawable4.bubbleBusiness.getBubbleDiyPath(bottomLeftId);
                    Intrinsics.checkNotNullExpressionValue(bubbleDiyPath3, "bubbleBusiness.getBubbleDiyPath(this)");
                    diyBubbleDrawable4.bitmapBL = aVar3.b(bubbleDiyPath3);
                }
                BubbleDiyData bubbleDiyData5 = DiyBubbleDrawable.this.diyBubbleData;
                Intrinsics.checkNotNull(bubbleDiyData5);
                String bottomRightId = bubbleDiyData5.getBottomRightId();
                DiyBubbleDrawable diyBubbleDrawable5 = DiyBubbleDrawable.this;
                if (!(bottomRightId.length() == 0)) {
                    e03.a aVar4 = e03.a.f395321a;
                    String bubbleDiyPath4 = diyBubbleDrawable5.bubbleBusiness.getBubbleDiyPath(bottomRightId);
                    Intrinsics.checkNotNullExpressionValue(bubbleDiyPath4, "bubbleBusiness.getBubbleDiyPath(this)");
                    diyBubbleDrawable5.bitmapBR = aVar4.b(bubbleDiyPath4);
                }
                return new BitmapDrawable();
            }
        });
        AbsAsyncDrawable.load$default(this, false, 1, null);
    }

    private final void J(String id5, IDownLoadListener listener) {
        boolean z16;
        try {
            if (id5.length() > 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                this.bubbleBusiness.startDownloadDiyBubble(Integer.parseInt(id5));
                this.bubbleBusiness.addDownLoadDIYListener(Integer.parseInt(id5), listener);
            }
        } catch (NumberFormatException e16) {
            QLog.e(K, 1, "startDownLoadDiyBubbleData NumberFormatException : e = " + e16);
        }
    }

    public final void I(@NotNull BubbleDiyData bubbleDiyData, @NotNull IDownLoadListener listener) {
        Intrinsics.checkNotNullParameter(bubbleDiyData, "bubbleDiyData");
        Intrinsics.checkNotNullParameter(listener, "listener");
        J(bubbleDiyData.getBottomLeftId(), listener);
        J(bubbleDiyData.getBottomRightId(), listener);
        J(bubbleDiyData.getTopLeftId(), listener);
        J(bubbleDiyData.getTopRightId(), listener);
    }

    @Override // com.tencent.mobileqq.vas.image.AbsAsyncDrawable
    public void doLoadTask(@NotNull ILoaderSucessCallback callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (getIsLoadSuccess()) {
            return;
        }
        this.mDIYBubbleDataManager.b(this.uin, this.diyId, new b(callback));
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x0089 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x001a A[SYNTHETIC] */
    @Override // com.tencent.mobileqq.vas.image.AbsAsyncDrawable, android.graphics.drawable.Drawable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void draw(@NotNull Canvas canvas) {
        Bitmap bitmap;
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        this.mBackDrawable.draw(canvas);
        if (this.diyBubbleData == null) {
            return;
        }
        for (String str : this.mDiyBubbleConfigMap.keySet()) {
            g03.a aVar = this.mDiyBubbleConfigMap.get(str);
            if (aVar instanceof g03.b) {
                Rect l3 = ((g03.b) aVar).l(canvas, this.isMirror);
                if (l3 != null) {
                    int hashCode = str.hashCode();
                    if (hashCode != 2122) {
                        if (hashCode != 2128) {
                            if (hashCode != 2680) {
                                if (hashCode == 2686 && str.equals("TR")) {
                                    bitmap = this.bitmapTR;
                                    if (bitmap == null) {
                                        canvas.drawBitmap(bitmap, new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight()), l3, new Paint());
                                    }
                                }
                                bitmap = null;
                                if (bitmap == null) {
                                }
                            } else {
                                if (str.equals("TL")) {
                                    bitmap = this.bitmapTL;
                                    if (bitmap == null) {
                                    }
                                }
                                bitmap = null;
                                if (bitmap == null) {
                                }
                            }
                        } else {
                            if (str.equals("BR")) {
                                bitmap = this.bitmapBR;
                                if (bitmap == null) {
                                }
                            }
                            bitmap = null;
                            if (bitmap == null) {
                            }
                        }
                    } else {
                        if (str.equals("BL")) {
                            bitmap = this.bitmapBL;
                            if (bitmap == null) {
                            }
                        }
                        bitmap = null;
                        if (bitmap == null) {
                        }
                    }
                } else {
                    return;
                }
            } else if (aVar instanceof g03.c) {
                int save = canvas.save();
                float f16 = BaseApplication.getContext().getResources().getDisplayMetrics().density / 2.0f;
                canvas.scale(f16, f16);
                g03.c cVar = (g03.c) aVar;
                Paint paint = new Paint();
                if (cVar.m(canvas, paint, this.isMirror) != null) {
                    if (cVar.getTextColor() != -1) {
                        paint.setColor(cVar.getTextColor());
                    }
                    canvas.drawText(this.diyText, r4.left, r4.top, paint);
                }
                canvas.restoreToCount(save);
            }
        }
    }

    @Override // com.tencent.mobileqq.vas.image.AbsAsyncDrawable
    /* renamed from: isLoadSucess */
    public boolean getIsLoadSuccess() {
        boolean z16;
        boolean z17;
        boolean z18;
        boolean z19;
        BubbleDiyData bubbleDiyData = this.diyBubbleData;
        if (bubbleDiyData == null) {
            return false;
        }
        Intrinsics.checkNotNull(bubbleDiyData);
        if (bubbleDiyData.getTopLeftId().length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            BubbleBusiness bubbleBusiness = this.bubbleBusiness;
            BubbleDiyData bubbleDiyData2 = this.diyBubbleData;
            Intrinsics.checkNotNull(bubbleDiyData2);
            if (!new File(bubbleBusiness.getBubbleDiyPath(bubbleDiyData2.getTopLeftId())).exists()) {
                return false;
            }
        }
        BubbleDiyData bubbleDiyData3 = this.diyBubbleData;
        Intrinsics.checkNotNull(bubbleDiyData3);
        if (bubbleDiyData3.getTopRightId().length() == 0) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (!z17) {
            BubbleBusiness bubbleBusiness2 = this.bubbleBusiness;
            BubbleDiyData bubbleDiyData4 = this.diyBubbleData;
            Intrinsics.checkNotNull(bubbleDiyData4);
            if (!new File(bubbleBusiness2.getBubbleDiyPath(bubbleDiyData4.getTopRightId())).exists()) {
                return false;
            }
        }
        BubbleDiyData bubbleDiyData5 = this.diyBubbleData;
        Intrinsics.checkNotNull(bubbleDiyData5);
        if (bubbleDiyData5.getBottomLeftId().length() == 0) {
            z18 = true;
        } else {
            z18 = false;
        }
        if (!z18) {
            BubbleBusiness bubbleBusiness3 = this.bubbleBusiness;
            BubbleDiyData bubbleDiyData6 = this.diyBubbleData;
            Intrinsics.checkNotNull(bubbleDiyData6);
            if (!new File(bubbleBusiness3.getBubbleDiyPath(bubbleDiyData6.getBottomLeftId())).exists()) {
                return false;
            }
        }
        BubbleDiyData bubbleDiyData7 = this.diyBubbleData;
        Intrinsics.checkNotNull(bubbleDiyData7);
        if (bubbleDiyData7.getBottomRightId().length() == 0) {
            z19 = true;
        } else {
            z19 = false;
        }
        if (!z19) {
            BubbleBusiness bubbleBusiness4 = this.bubbleBusiness;
            BubbleDiyData bubbleDiyData8 = this.diyBubbleData;
            Intrinsics.checkNotNull(bubbleDiyData8);
            if (!new File(bubbleBusiness4.getBubbleDiyPath(bubbleDiyData8.getBottomRightId())).exists()) {
                return false;
            }
        }
        return true;
    }
}
