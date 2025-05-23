package com.tencent.qqnt.biz.lightbusiness.lightinteraction.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.LinearInterpolator;
import com.heytap.databaseengine.model.UserInfo;
import com.qq.e.comm.managers.plugin.PM;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.biz.lightbusiness.lightinteraction.b;
import com.tencent.qqnt.biz.lightbusiness.lightinteraction.view.LIAAnimView;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 j2\u00020\u00012\u00020\u0002:\u0001%B\u0011\b\u0016\u0012\u0006\u0010b\u001a\u00020a\u00a2\u0006\u0004\bc\u0010dB\u001b\b\u0016\u0012\u0006\u0010b\u001a\u00020a\u0012\b\u0010f\u001a\u0004\u0018\u00010e\u00a2\u0006\u0004\bc\u0010gB#\b\u0016\u0012\u0006\u0010b\u001a\u00020a\u0012\b\u0010f\u001a\u0004\u0018\u00010e\u0012\u0006\u0010h\u001a\u00020\u0015\u00a2\u0006\u0004\bc\u0010iJ\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0005\u001a\u00020\u0003H\u0002J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0001H\u0002J(\u0010\u0010\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\rH\u0002J(\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\rH\u0002J\"\u0010\u0019\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\u00072\b\u0010\u0018\u001a\u0004\u0018\u00010\u000bH\u0002J\u0010\u0010\u001a\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u0001H\u0002J(\u0010 \u001a\u00020\u000b2\u0006\u0010\u001b\u001a\u00020\u000b2\u0006\u0010\u001c\u001a\u00020\u00152\u0006\u0010\u001d\u001a\u00020\u00152\u0006\u0010\u001f\u001a\u00020\u001eH\u0002J\b\u0010\"\u001a\u00020!H\u0016J\b\u0010#\u001a\u00020\u0003H\u0016J\b\u0010\u0006\u001a\u00020\u0003H\u0016J\u0012\u0010$\u001a\u00020\u00032\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001H\u0016J\u0012\u0010%\u001a\u00020\u00032\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016J\u0010\u0010&\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u0015H\u0016J\b\u0010'\u001a\u00020\u0003H\u0016J\u0012\u0010*\u001a\u00020\u00032\b\u0010)\u001a\u0004\u0018\u00010(H\u0016J\u0012\u0010+\u001a\u00020\u00032\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0014R\u0018\u0010.\u001a\u0004\u0018\u00010\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b,\u0010-R\u0018\u00101\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b/\u00100R\u0018\u00103\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b2\u00100R\u0016\u00106\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b4\u00105R\u0018\u00108\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u00107R\u0016\u0010:\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b9\u00105R\u0014\u0010<\u001a\u00020\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b;\u00105R\u0016\u0010>\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b=\u00105R\u0016\u0010A\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b?\u0010@R\u0016\u0010C\u001a\u00020!8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b@\u0010BR\u0018\u0010G\u001a\u0004\u0018\u00010D8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bE\u0010FR\u0016\u0010K\u001a\u00020H8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bI\u0010JR\u0016\u0010M\u001a\u00020\u001e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b5\u0010LR\u0016\u0010Q\u001a\u00020N8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bO\u0010PR\u0016\u0010S\u001a\u00020N8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bR\u0010PR\u0016\u0010U\u001a\u00020N8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bT\u0010PR\u0014\u0010Y\u001a\u00020V8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bW\u0010XR\u0014\u0010]\u001a\u00020Z8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b[\u0010\\R\u0018\u0010`\u001a\u0004\u0018\u00010(8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b^\u0010_\u00a8\u0006k"}, d2 = {"Lcom/tencent/qqnt/biz/lightbusiness/lightinteraction/view/LIAAnimView;", "Landroid/view/View;", "Lcom/tencent/qqnt/biz/lightbusiness/lightinteraction/b;", "", "l", ReportConstant.COSTREPORT_PREFIX, "v", "", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Landroid/graphics/Canvas;", PM.CANVAS, "Landroid/graphics/Bitmap;", "icon", "", HippyTKDListViewAdapter.X, "y", "o", "linearTimePos", "opacityPos1", "opacityPos2", "opacityPos3", "", "p", "targetLoc", "cover", DomainData.DOMAIN_NAME, "i", MimeHelper.IMAGE_SUBTYPE_BITMAP, "expectWidth", "expectHeight", "Landroid/graphics/Matrix;", "matrix", "j", "", "r", "t", "b", "a", "setCoverDiffY", "k", "Lcom/tencent/qqnt/biz/lightbusiness/lightinteraction/b$a;", "listener", "setOnAnimActionListener", "onDraw", "d", "Landroid/view/View;", "coverView", "e", "Landroid/graphics/Bitmap;", "coverBitmap", "f", "iconBmp", h.F, "I", "iconResId", "[I", "centerLoc", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "maxRadius", BdhLogUtil.LogTag.Tag_Conn, "iconSize", "D", "diffCoverY", "E", UserInfo.SEX_FEMALE, "curAnimPos", "Z", "isAnim", "Landroid/animation/ValueAnimator;", "G", "Landroid/animation/ValueAnimator;", "valueAnimator", "Landroid/graphics/Paint;", "H", "Landroid/graphics/Paint;", "paint", "Landroid/graphics/Matrix;", "mMatrix", "Lcom/tencent/qqnt/biz/lightbusiness/lightinteraction/view/a;", "J", "Lcom/tencent/qqnt/biz/lightbusiness/lightinteraction/view/a;", "translate1Interpolator", "K", "translate2Interpolator", "L", "scaleInterpolator", "Landroid/os/Handler;", "M", "Landroid/os/Handler;", "asyncHandler", "Ljava/lang/Runnable;", "N", "Ljava/lang/Runnable;", "animTask", "P", "Lcom/tencent/qqnt/biz/lightbusiness/lightinteraction/b$a;", "onAnimActionListener", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attributeSet", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "light_business_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class LIAAnimView extends View implements com.tencent.qqnt.biz.lightbusiness.lightinteraction.b {
    static IPatchRedirector $redirector_;

    /* renamed from: Q, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    private final int iconSize;

    /* renamed from: D, reason: from kotlin metadata */
    private int diffCoverY;

    /* renamed from: E, reason: from kotlin metadata */
    private float curAnimPos;

    /* renamed from: F, reason: from kotlin metadata */
    private volatile boolean isAnim;

    /* renamed from: G, reason: from kotlin metadata */
    @Nullable
    private ValueAnimator valueAnimator;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private Paint paint;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private Matrix mMatrix;

    /* renamed from: J, reason: from kotlin metadata */
    private a translate1Interpolator;

    /* renamed from: K, reason: from kotlin metadata */
    private a translate2Interpolator;

    /* renamed from: L, reason: from kotlin metadata */
    private a scaleInterpolator;

    /* renamed from: M, reason: from kotlin metadata */
    @NotNull
    private final Handler asyncHandler;

    /* renamed from: N, reason: from kotlin metadata */
    @NotNull
    private final Runnable animTask;

    /* renamed from: P, reason: from kotlin metadata */
    @Nullable
    private b.a onAnimActionListener;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private View coverView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Bitmap coverBitmap;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Bitmap iconBmp;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private int iconResId;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private int[] centerLoc;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private int maxRadius;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/qqnt/biz/lightbusiness/lightinteraction/view/LIAAnimView$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "light_business_kit_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.biz.lightbusiness.lightinteraction.view.LIAAnimView$a, reason: from kotlin metadata */
    /* loaded from: classes23.dex */
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
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/qqnt/biz/lightbusiness/lightinteraction/view/LIAAnimView$b", "Landroid/animation/AnimatorListenerAdapter;", "Landroid/animation/Animator;", "animation", "", "onAnimationEnd", "light_business_kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes23.dex */
    public static final class b extends AnimatorListenerAdapter {
        static IPatchRedirector $redirector_;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ ValueAnimator f353178e;

        b(ValueAnimator valueAnimator) {
            this.f353178e = valueAnimator;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) LIAAnimView.this, (Object) valueAnimator);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void b(LIAAnimView this$0, ValueAnimator valueAnimator, b this$1) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(this$1, "this$1");
            this$0.isAnim = false;
            valueAnimator.removeListener(this$1);
            this$0.setVisibility(8);
            b.a aVar = this$0.onAnimActionListener;
            if (aVar != null) {
                aVar.b(this$0);
            }
            QLog.d("QUIInterActionAnimView", 1, "[startAnim] running animator finish");
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(@Nullable Animator animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) animation);
                return;
            }
            final LIAAnimView lIAAnimView = LIAAnimView.this;
            final ValueAnimator valueAnimator = this.f353178e;
            lIAAnimView.post(new Runnable() { // from class: com.tencent.qqnt.biz.lightbusiness.lightinteraction.view.e
                @Override // java.lang.Runnable
                public final void run() {
                    LIAAnimView.b.b(LIAAnimView.this, valueAnimator, this);
                }
            });
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(29963);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 15)) {
            redirector.redirect((short) 15);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LIAAnimView(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            return;
        }
        com.tencent.qqnt.util.view.b bVar = com.tencent.qqnt.util.view.b.f362999a;
        this.maxRadius = bVar.b(60);
        this.iconSize = bVar.b(24);
        this.paint = new Paint();
        this.mMatrix = new Matrix();
        this.asyncHandler = new Handler(ThreadManagerV2.getQQCommonThreadLooper());
        this.animTask = new Runnable() { // from class: com.tencent.qqnt.biz.lightbusiness.lightinteraction.view.b
            @Override // java.lang.Runnable
            public final void run() {
                LIAAnimView.h(LIAAnimView.this);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(LIAAnimView this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.l();
    }

    private final Bitmap i(View v3) {
        Bitmap bitmap = Bitmap.createBitmap(v3.getWidth(), v3.getHeight(), Bitmap.Config.ARGB_4444);
        v3.draw(new Canvas(bitmap));
        Intrinsics.checkNotNullExpressionValue(bitmap, "bitmap");
        return bitmap;
    }

    private final Bitmap j(Bitmap bitmap, int expectWidth, int expectHeight, Matrix matrix) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        if (width != 0 && height != 0) {
            if (width == expectWidth && height == expectHeight) {
                return bitmap;
            }
            matrix.setScale(expectWidth / width, expectHeight / height);
            Bitmap createBitmap = Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true);
            Intrinsics.checkNotNullExpressionValue(createBitmap, "createBitmap(bitmap,0,0,\u2026, bmpHeight, matrix,true)");
            return createBitmap;
        }
        return bitmap;
    }

    private final void l() {
        if (!this.isAnim) {
            return;
        }
        QLog.d("QUIInterActionAnimView", 1, "[startAnim] running animator start");
        b.a aVar = this.onAnimActionListener;
        if (aVar != null) {
            aVar.a(this);
        }
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.valueAnimator = ofFloat;
        ofFloat.setInterpolator(new LinearInterpolator());
        ofFloat.setDuration(1160L);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tencent.qqnt.biz.lightbusiness.lightinteraction.view.d
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                LIAAnimView.m(LIAAnimView.this, valueAnimator);
            }
        });
        s();
        ofFloat.addListener(new b(ofFloat));
        ofFloat.start();
        this.curAnimPos = 0.0f;
        setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m(LIAAnimView this$0, ValueAnimator valueAnimator) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.curAnimPos = valueAnimator.getAnimatedFraction();
        this$0.postInvalidate();
    }

    private final void n(Canvas canvas, int[] targetLoc, Bitmap cover) {
        this.paint.setAlpha(0);
        this.mMatrix.reset();
        if (cover != null) {
            this.paint.setColor(-7829368);
            canvas.drawBitmap(cover, targetLoc[0], targetLoc[1], this.paint);
        }
    }

    private final void o(Canvas canvas, Bitmap icon, float x16, float y16) {
        canvas.save();
        canvas.translate(x16, y16);
        canvas.drawBitmap(icon, this.mMatrix, this.paint);
        canvas.restore();
    }

    private final int p(float linearTimePos, float opacityPos1, float opacityPos2, float opacityPos3) {
        int i3;
        if (linearTimePos < opacityPos1) {
            i3 = (int) ((1 - (linearTimePos / opacityPos1)) * 51.0f);
        } else if (linearTimePos > opacityPos2 && linearTimePos < opacityPos3) {
            i3 = (int) (((linearTimePos - opacityPos2) * 255.0f) / (opacityPos3 - opacityPos2));
        } else {
            if (linearTimePos < opacityPos3) {
                return 255;
            }
            return 0;
        }
        return 255 - i3;
    }

    private final int[] q(View v3) {
        int[] iArr = new int[2];
        v3.getLocationOnScreen(iArr);
        return new int[]{iArr[0], iArr[1] - this.diffCoverY};
    }

    private final void s() {
        this.translate1Interpolator = new a(0.1f, 0.0f, 0.19f, 1.0f);
        this.translate2Interpolator = new a(0.9f, 0.0f, 0.9f, 1.0f);
        this.scaleInterpolator = new a(0.17f, 0.12f, 0.19f, 1.0f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u(LIAAnimView this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Bitmap bitmap = this$0.iconBmp;
        if (bitmap != null) {
            int i3 = this$0.iconSize;
            this$0.iconBmp = this$0.j(bitmap, i3, i3, this$0.mMatrix);
        } else if (this$0.iconResId != 0) {
            Bitmap decodeResource = BitmapFactory.decodeResource(this$0.getResources(), this$0.iconResId, new BitmapFactory.Options());
            Intrinsics.checkNotNullExpressionValue(decodeResource, "decodeResource(resources\u2026 BitmapFactory.Options())");
            int i16 = this$0.iconSize;
            this$0.iconBmp = this$0.j(decodeResource, i16, i16, this$0.mMatrix);
        }
        if (this$0.iconBmp == null) {
            QLog.d("QUIInterActionAnimView", 1, "[startAnim] fail. iconBmp is null");
            this$0.isAnim = false;
        } else {
            this$0.post(this$0.animTask);
        }
    }

    @Override // com.tencent.qqnt.biz.lightbusiness.lightinteraction.b
    public void a(@Nullable Bitmap icon) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) icon);
        } else {
            this.iconBmp = icon;
            this.iconResId = 0;
        }
    }

    @Override // com.tencent.qqnt.biz.lightbusiness.lightinteraction.b
    public void b(@Nullable View cover) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) cover);
            return;
        }
        this.coverView = cover;
        this.coverBitmap = null;
        this.centerLoc = null;
    }

    public void k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
            return;
        }
        this.onAnimActionListener = null;
        ValueAnimator valueAnimator = this.valueAnimator;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        this.asyncHandler.removeCallbacksAndMessages(null);
        removeCallbacks(this.animTask);
        this.iconBmp = null;
        this.iconResId = 0;
        this.centerLoc = null;
        this.coverBitmap = null;
        this.coverView = null;
        this.valueAnimator = null;
        this.isAnim = false;
    }

    @Override // android.view.View
    protected void onDraw(@Nullable Canvas canvas) {
        float f16;
        float f17;
        float f18;
        float f19;
        int i3;
        int i16;
        int i17;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) canvas);
            return;
        }
        super.onDraw(canvas);
        Bitmap bitmap = this.iconBmp;
        if (canvas != null && bitmap != null) {
            View view = this.coverView;
            if (view != null) {
                this.centerLoc = q(view);
            }
            float f26 = this.curAnimPos;
            int[] iArr = this.centerLoc;
            if (iArr == null) {
                iArr = new int[]{0, 0};
            }
            if (f26 < 0.284f) {
                a aVar = this.scaleInterpolator;
                if (aVar == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("scaleInterpolator");
                    aVar = null;
                }
                float interpolation = aVar.getInterpolation(f26 / 0.284f);
                f17 = (interpolation * 0.5f) + 0.5f;
                f16 = (interpolation * 0.792f) + 0.208f;
            } else {
                f16 = 1.0f;
                f17 = 1.0f;
            }
            int p16 = p(f26, 0.147f, 0.431f, 0.716f);
            int i18 = this.maxRadius;
            float f27 = i18;
            if (f26 > 0.43f) {
                a aVar2 = this.translate2Interpolator;
                if (aVar2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("translate2Interpolator");
                    aVar2 = null;
                }
                float interpolation2 = aVar2.getInterpolation((f26 - 0.43f) / (1 - 0.43f));
                int i19 = this.maxRadius;
                f19 = i19 * 0.25f * interpolation2;
                f18 = i19 * 0.583f * interpolation2;
            } else {
                float f28 = i18;
                a aVar3 = this.translate1Interpolator;
                if (aVar3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("translate1Interpolator");
                    aVar3 = null;
                }
                f27 = f28 * aVar3.getInterpolation(f26 / 0.43f);
                f18 = 0.0f;
                f19 = 0.0f;
            }
            float f29 = 0.625f * f27;
            float f36 = f17 * 0.417f;
            Matrix matrix = this.mMatrix;
            int i26 = 0;
            float f37 = 2;
            float width = iArr[0] - ((bitmap.getWidth() * f36) / f37);
            Bitmap bitmap2 = this.coverBitmap;
            if (bitmap2 != null) {
                i3 = bitmap2.getWidth();
            } else {
                i3 = 0;
            }
            float f38 = width + (i3 / 2);
            float height = iArr[1] - ((bitmap.getHeight() * f36) / f37);
            Bitmap bitmap3 = this.coverBitmap;
            if (bitmap3 != null) {
                i16 = bitmap3.getHeight();
            } else {
                i16 = 0;
            }
            matrix.setTranslate(f38, height + (i16 / 2));
            this.mMatrix.preScale(f36, f36);
            this.paint.setAlpha(p16);
            float f39 = f18;
            float f46 = f27;
            double d16 = 2;
            float sqrt = (float) ((f29 * Math.sqrt(3.0d)) / d16);
            float f47 = f19 + 0.0f;
            o(canvas, bitmap, f29, f47);
            float f48 = -f29;
            o(canvas, bitmap, f48, f47);
            float f49 = f29 * 0.5f;
            float f56 = sqrt + f19;
            o(canvas, bitmap, f49, f56);
            float f57 = f48 * 0.5f;
            o(canvas, bitmap, f57, f56);
            float f58 = (-sqrt) + f19;
            o(canvas, bitmap, f49, f58);
            o(canvas, bitmap, f57, f58);
            float f59 = f16 * 1.0f;
            Matrix matrix2 = this.mMatrix;
            float width2 = iArr[0] - ((bitmap.getWidth() * f59) / f37);
            Bitmap bitmap4 = this.coverBitmap;
            if (bitmap4 != null) {
                i17 = bitmap4.getWidth();
            } else {
                i17 = 0;
            }
            float f65 = width2 + (i17 / 2);
            float height2 = iArr[1] - ((bitmap.getHeight() * f59) / f37);
            Bitmap bitmap5 = this.coverBitmap;
            if (bitmap5 != null) {
                i26 = bitmap5.getHeight();
            }
            matrix2.setTranslate(f65, height2 + (i26 / 2));
            this.mMatrix.preScale(f59, f59);
            this.paint.setAlpha(p16);
            float sqrt2 = (float) ((f46 * Math.sqrt(3.0d)) / d16);
            o(canvas, bitmap, 0.0f, f46 + f39);
            float f66 = -f46;
            o(canvas, bitmap, 0.0f, f66 + f39);
            float f67 = (f46 * 0.5f) + f39;
            o(canvas, bitmap, sqrt2, f67);
            float f68 = (f66 * 0.5f) + f39;
            o(canvas, bitmap, sqrt2, f68);
            float f69 = -sqrt2;
            o(canvas, bitmap, f69, f67);
            o(canvas, bitmap, f69, f68);
            if (f26 < 1.0f) {
                n(canvas, iArr, this.coverBitmap);
            }
        }
    }

    public boolean r() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        return this.isAnim;
    }

    public void setCoverDiffY(int y16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, y16);
        } else {
            this.diffCoverY = y16;
        }
    }

    @Override // com.tencent.qqnt.biz.lightbusiness.lightinteraction.b
    public void setOnAnimActionListener(@Nullable b.a listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) listener);
        } else {
            this.onAnimActionListener = listener;
        }
    }

    public void t() {
        View view;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        if (this.isAnim) {
            return;
        }
        this.isAnim = true;
        ValueAnimator valueAnimator = this.valueAnimator;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        if (this.coverBitmap == null && this.centerLoc == null && (view = this.coverView) != null) {
            this.centerLoc = q(view);
            this.coverBitmap = i(view);
        }
        this.asyncHandler.post(new Runnable() { // from class: com.tencent.qqnt.biz.lightbusiness.lightinteraction.view.c
            @Override // java.lang.Runnable
            public final void run() {
                LIAAnimView.u(LIAAnimView.this);
            }
        });
    }

    public void v() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        if (this.isAnim) {
            b.a aVar = this.onAnimActionListener;
            if (aVar != null) {
                aVar.b(this);
            }
            ValueAnimator valueAnimator = this.valueAnimator;
            if (valueAnimator != null) {
                valueAnimator.removeAllListeners();
                valueAnimator.cancel();
            }
        }
        this.asyncHandler.removeCallbacksAndMessages(null);
        setVisibility(8);
        this.valueAnimator = null;
        this.isAnim = false;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LIAAnimView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
            return;
        }
        com.tencent.qqnt.util.view.b bVar = com.tencent.qqnt.util.view.b.f362999a;
        this.maxRadius = bVar.b(60);
        this.iconSize = bVar.b(24);
        this.paint = new Paint();
        this.mMatrix = new Matrix();
        this.asyncHandler = new Handler(ThreadManagerV2.getQQCommonThreadLooper());
        this.animTask = new Runnable() { // from class: com.tencent.qqnt.biz.lightbusiness.lightinteraction.view.b
            @Override // java.lang.Runnable
            public final void run() {
                LIAAnimView.h(LIAAnimView.this);
            }
        };
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LIAAnimView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, context, attributeSet, Integer.valueOf(i3));
            return;
        }
        com.tencent.qqnt.util.view.b bVar = com.tencent.qqnt.util.view.b.f362999a;
        this.maxRadius = bVar.b(60);
        this.iconSize = bVar.b(24);
        this.paint = new Paint();
        this.mMatrix = new Matrix();
        this.asyncHandler = new Handler(ThreadManagerV2.getQQCommonThreadLooper());
        this.animTask = new Runnable() { // from class: com.tencent.qqnt.biz.lightbusiness.lightinteraction.view.b
            @Override // java.lang.Runnable
            public final void run() {
                LIAAnimView.h(LIAAnimView.this);
            }
        };
    }
}
