package com.tencent.mobileqq.component.qrcode;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.airbnb.lottie.LottieAnimationView;
import com.qq.e.comm.managers.plugin.PM;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.ExceptionsKt__ExceptionsKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0092\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 P2\u00020\u0001:\u0001QB1\b\u0007\u0012\u0006\u0010I\u001a\u00020H\u0012\n\b\u0002\u0010K\u001a\u0004\u0018\u00010J\u0012\b\b\u0002\u0010L\u001a\u00020\u0002\u0012\b\b\u0002\u0010M\u001a\u00020\u0002\u00a2\u0006\u0004\bN\u0010OJ\"\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\n\u001a\u00020\bH\u0002J!\u0010\u000e\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\r\u001a\u0004\u0018\u00010\u0002H\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u0002H\u0002J\u0018\u0010\u0013\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u00122\u0006\u0010\u0010\u001a\u00020\u0002H\u0002J\u0010\u0010\u0014\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000bH\u0002J\u0006\u0010\u0015\u001a\u00020\bJ\u000e\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\u0004J\u000e\u0010\u0019\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\u0004J\u0016\u0010\u001e\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u001cJ\u000e\u0010!\u001a\u00020\b2\u0006\u0010 \u001a\u00020\u001fJ\u000e\u0010#\u001a\u00020\b2\u0006\u0010\u001d\u001a\u00020\"J\u0018\u0010&\u001a\u00020\b2\u0006\u0010%\u001a\u00020$2\b\b\u0002\u0010\u0007\u001a\u00020\u0006J\u0018\u0010'\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0007\u001a\u00020\u0006J\"\u0010,\u001a\u00020\b2\f\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00020(2\f\u0010+\u001a\b\u0012\u0004\u0012\u00020*0(J\u000e\u0010/\u001a\u00020\b2\u0006\u0010.\u001a\u00020-J\b\u00100\u001a\u00020\bH\u0014J\b\u00101\u001a\u00020\bH\u0014J\u0018\u00104\u001a\u00020\b2\u0006\u00102\u001a\u00020\u00122\u0006\u00103\u001a\u00020\u0002H\u0014J\u000e\u00107\u001a\u00020\b2\u0006\u00106\u001a\u000205R\u0016\u00109\u001a\u00020-8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b7\u00108R\u0014\u0010<\u001a\u00020:8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010;R\u0018\u0010>\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010=R\u0018\u0010A\u001a\u0004\u0018\u00010?8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010@R\u0018\u0010C\u001a\u0004\u0018\u00010\"8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010BR\u0016\u0010E\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b&\u0010DR\u0016\u0010\u0005\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bF\u0010DR\u0016\u0010\u0016\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bG\u0010D\u00a8\u0006R"}, d2 = {"Lcom/tencent/mobileqq/component/qrcode/QUIColorfulQRCodeView;", "Landroid/widget/FrameLayout;", "", "color", "", "isLogoThemeDependNotVasNight", "Lcom/tencent/mobileqq/component/qrcode/a;", "changeColorParams", "", "l", "t", "Lcom/airbnb/lottie/LottieAnimationView;", "logoView", "animResId", "r", "(Lcom/airbnb/lottie/LottieAnimationView;Ljava/lang/Integer;)V", "size", tl.h.F, "Landroid/view/View;", "i", ReportConstant.COSTREPORT_PREFIX, QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "isAdjustDarkLogo", "setIsAdjustDarkLogo", "enable", "e", "", "content", "Lcom/tencent/mobileqq/component/qrcode/g;", "callback", "f", "Lcom/tencent/mobileqq/component/qrcode/e;", "generateQRParams", "setTargetGenerateQRCodeParams", "Lcom/tencent/mobileqq/component/qrcode/h;", "setOnFirstTimeDrawnListener", "Landroid/graphics/Bitmap;", MimeHelper.IMAGE_SUBTYPE_BITMAP, QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "k", "", NodeProps.COLORS, "", "positions", DomainData.DOMAIN_NAME, "Lcom/tencent/mobileqq/component/qrcode/i;", "params", "g", NodeProps.ON_ATTACHED_TO_WINDOW, NodeProps.ON_DETACHED_FROM_WINDOW, "changedView", "visibility", "onVisibilityChanged", "Landroid/graphics/Canvas;", PM.CANVAS, "d", "Lcom/tencent/mobileqq/component/qrcode/i;", "logoResourceParams", "Lcom/tencent/mobileqq/component/qrcode/ColorfulQRCodeOnlyView;", "Lcom/tencent/mobileqq/component/qrcode/ColorfulQRCodeOnlyView;", "qrcodeView", "Lcom/airbnb/lottie/LottieAnimationView;", "animLogoView", "Landroid/widget/ImageView;", "Landroid/widget/ImageView;", "staticLogoView", "Lcom/tencent/mobileqq/component/qrcode/h;", "onFirstTimeDrawnCallback", "Z", "isLogoLightTheme", BdhLogUtil.LogTag.Tag_Conn, "D", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "defStyleRes", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "E", "a", "qrcode_component_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes5.dex */
public final class QUIColorfulQRCodeView extends FrameLayout {
    static IPatchRedirector $redirector_;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    private boolean isLogoThemeDependNotVasNight;

    /* renamed from: D, reason: from kotlin metadata */
    private boolean isAdjustDarkLogo;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private i logoResourceParams;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ColorfulQRCodeOnlyView qrcodeView;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private LottieAnimationView animLogoView;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ImageView staticLogoView;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private h onFirstTimeDrawnCallback;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private boolean isLogoLightTheme;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/component/qrcode/QUIColorfulQRCodeView$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qrcode_component_kit_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.component.qrcode.QUIColorfulQRCodeView$a, reason: from kotlin metadata */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(35949);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 22)) {
            redirector.redirect((short) 22);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public QUIColorfulQRCodeView(@NotNull Context context) {
        this(context, null, 0, 0, 14, null);
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 21)) {
            return;
        }
        iPatchRedirector.redirect((short) 21, (Object) this, (Object) context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void h(int size) {
        LottieAnimationView lottieAnimationView = this.animLogoView;
        if (lottieAnimationView != null) {
            i(lottieAnimationView, size);
        }
        ImageView imageView = this.staticLogoView;
        if (imageView != null) {
            i(imageView, size);
        }
    }

    private final void i(View logoView, int size) {
        ViewGroup.LayoutParams layoutParams = logoView.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
        layoutParams2.width = size;
        layoutParams2.height = size;
        logoView.setLayoutParams(layoutParams2);
        logoView.setVisibility(0);
        logoView.requestLayout();
        logoView.post(new Runnable() { // from class: com.tencent.mobileqq.component.qrcode.j
            @Override // java.lang.Runnable
            public final void run() {
                QUIColorfulQRCodeView.j(QUIColorfulQRCodeView.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j(QUIColorfulQRCodeView this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        h hVar = this$0.onFirstTimeDrawnCallback;
        this$0.onFirstTimeDrawnCallback = null;
        if (hVar != null) {
            QLog.d("QUIColorfulQRCodeView", 1, "onDrawn after refreshLogoSize");
            hVar.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void l(int color, boolean isLogoThemeDependNotVasNight, a changeColorParams) {
        List<Float> listOf;
        int collectionSizeOrDefault;
        int collectionSizeOrDefault2;
        float coerceAtLeast;
        float coerceAtMost;
        boolean z16 = false;
        if (changeColorParams.b().size() <= 1) {
            listOf = CollectionsKt__CollectionsJVMKt.listOf(Float.valueOf(1.0f));
        } else {
            List<f> b16 = changeColorParams.b();
            collectionSizeOrDefault2 = CollectionsKt__IterablesKt.collectionSizeOrDefault(b16, 10);
            listOf = new ArrayList<>(collectionSizeOrDefault2);
            int i3 = 0;
            for (Object obj : b16) {
                int i16 = i3 + 1;
                if (i3 < 0) {
                    CollectionsKt__CollectionsKt.throwIndexOverflow();
                }
                coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(i3 / (changeColorParams.b().size() - 1), 0.0f);
                coerceAtMost = RangesKt___RangesKt.coerceAtMost(coerceAtLeast, 1.0f);
                listOf.add(Float.valueOf(coerceAtMost));
                i3 = i16;
            }
        }
        List<Integer> a16 = changeColorParams.a(color);
        this.isLogoThemeDependNotVasNight = isLogoThemeDependNotVasNight;
        Object[] objArr = new Object[2];
        objArr[0] = "refreshQRCodeBgColor color:" + Integer.toHexString(color) + " ";
        List<Integer> list = a16;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(Integer.toHexString(((Number) it.next()).intValue()));
        }
        objArr[1] = "hctTrans:" + arrayList + " positions:" + listOf;
        QLog.d("QUIColorfulQRCodeView", 1, objArr);
        n(a16, listOf);
        if (isLogoThemeDependNotVasNight) {
            com.tencent.mobileqq.component.qrcode.utils.c cVar = com.tencent.mobileqq.component.qrcode.utils.c.f201870a;
            if (!cVar.e()) {
                if (!cVar.d()) {
                    z16 = true;
                }
                this.isLogoLightTheme = z16;
                t();
            }
        }
        z16 = com.tencent.mobileqq.component.qrcode.utils.c.f201870a.c(color);
        this.isLogoLightTheme = z16;
        t();
    }

    public static /* synthetic */ void o(QUIColorfulQRCodeView qUIColorfulQRCodeView, int i3, a aVar, int i16, Object obj) {
        if ((i16 & 2) != 0) {
            aVar = a.INSTANCE.a();
        }
        qUIColorfulQRCodeView.k(i3, aVar);
    }

    public static /* synthetic */ void p(QUIColorfulQRCodeView qUIColorfulQRCodeView, Bitmap bitmap, a aVar, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            aVar = a.INSTANCE.b();
        }
        qUIColorfulQRCodeView.m(bitmap, aVar);
    }

    private final void r(LottieAnimationView logoView, Integer animResId) {
        if (animResId == null) {
            logoView.setTag(null);
        } else {
            if (Intrinsics.areEqual(animResId, logoView.getTag())) {
                return;
            }
            logoView.setTag(animResId);
            logoView.setAnimation(logoView.getContext().getString(animResId.intValue()));
            s(logoView);
        }
    }

    private final void s(LottieAnimationView logoView) {
        i iVar = this.logoResourceParams;
        i iVar2 = null;
        if (iVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("logoResourceParams");
            iVar = null;
        }
        if (iVar.c() == null) {
            return;
        }
        i iVar3 = this.logoResourceParams;
        if (iVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("logoResourceParams");
            iVar3 = null;
        }
        if (iVar3.b() != -1) {
            i iVar4 = this.logoResourceParams;
            if (iVar4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("logoResourceParams");
                iVar4 = null;
            }
            if (iVar4.b() < 0) {
                return;
            }
        }
        i iVar5 = this.logoResourceParams;
        if (iVar5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("logoResourceParams");
        } else {
            iVar2 = iVar5;
        }
        logoView.setRepeatCount(iVar2.b());
        if (!logoView.isAnimating()) {
            logoView.playAnimation();
        }
    }

    private final void t() {
        int i3;
        if (this.logoResourceParams == null) {
            return;
        }
        QLog.d("QUIColorfulQRCodeView", 1, "updateResThemeColor isLogoLightTheme:" + this.isLogoLightTheme + " isAdjustDarkLogo:" + this.isAdjustDarkLogo);
        ImageView imageView = this.staticLogoView;
        if (imageView == null && (imageView = this.animLogoView) == null) {
            return;
        }
        Resources resources = imageView.getResources();
        i iVar = this.logoResourceParams;
        i iVar2 = null;
        if (iVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("logoResourceParams");
            iVar = null;
        }
        Drawable drawable = resources.getDrawable(iVar.d(), null);
        if (drawable != null) {
            if (!this.isLogoLightTheme && this.isAdjustDarkLogo) {
                i3 = -16777216;
            } else {
                i3 = -1;
            }
            drawable.setColorFilter(new PorterDuffColorFilter(i3, PorterDuff.Mode.SRC_IN));
            imageView.setImageDrawable(drawable);
        }
        LottieAnimationView lottieAnimationView = this.animLogoView;
        if (lottieAnimationView == null) {
            return;
        }
        lottieAnimationView.cancelAnimation();
        if (!this.isLogoLightTheme && this.isAdjustDarkLogo) {
            i iVar3 = this.logoResourceParams;
            if (iVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("logoResourceParams");
            } else {
                iVar2 = iVar3;
            }
            r(lottieAnimationView, iVar2.a());
            return;
        }
        i iVar4 = this.logoResourceParams;
        if (iVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("logoResourceParams");
        } else {
            iVar2 = iVar4;
        }
        r(lottieAnimationView, iVar2.c());
    }

    public final void d(@NotNull Canvas canvas) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, (Object) canvas);
        } else {
            Intrinsics.checkNotNullParameter(canvas, "canvas");
            this.qrcodeView.k(canvas);
        }
    }

    public final void e(boolean enable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, enable);
        } else {
            this.qrcodeView.setEnableGyroscopeRotation(enable);
        }
    }

    public final void f(@NotNull String content, @NotNull g callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) content, (Object) callback);
            return;
        }
        Intrinsics.checkNotNullParameter(content, "content");
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.qrcodeView.n(content, callback);
    }

    public final void g(@NotNull i params) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) params);
            return;
        }
        Intrinsics.checkNotNullParameter(params, "params");
        this.logoResourceParams = params;
        t();
        LottieAnimationView lottieAnimationView = this.animLogoView;
        if (lottieAnimationView != null) {
            lottieAnimationView.invalidate();
        }
        ImageView imageView = this.staticLogoView;
        if (imageView != null) {
            imageView.invalidate();
        }
    }

    public final void k(int color, @NotNull a changeColorParams) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, color, (Object) changeColorParams);
        } else {
            Intrinsics.checkNotNullParameter(changeColorParams, "changeColorParams");
            l(color, true, changeColorParams);
        }
    }

    public final void m(@NotNull Bitmap bitmap, @NotNull final a changeColorParams) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) bitmap, (Object) changeColorParams);
            return;
        }
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        Intrinsics.checkNotNullParameter(changeColorParams, "changeColorParams");
        com.tencent.mobileqq.component.qrcode.utils.c.f201870a.f(bitmap, new Function1<Integer, Unit>(changeColorParams) { // from class: com.tencent.mobileqq.component.qrcode.QUIColorfulQRCodeView$refreshQRCodeBgColor$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ a $changeColorParams;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.$changeColorParams = changeColorParams;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QUIColorfulQRCodeView.this, (Object) changeColorParams);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                invoke(num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(int i3) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                    QUIColorfulQRCodeView.this.l(i3, false, this.$changeColorParams);
                } else {
                    iPatchRedirector2.redirect((short) 2, (Object) this, i3);
                }
            }
        });
    }

    public final void n(@NotNull List<Integer> colors, @NotNull List<Float> positions) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) colors, (Object) positions);
            return;
        }
        Intrinsics.checkNotNullParameter(colors, "colors");
        Intrinsics.checkNotNullParameter(positions, "positions");
        this.qrcodeView.o(colors, positions);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this);
            return;
        }
        QLog.d("QUIColorfulQRCodeView", 1, NodeProps.ON_ATTACHED_TO_WINDOW);
        super.onAttachedToWindow();
        LottieAnimationView lottieAnimationView = this.animLogoView;
        if (lottieAnimationView != null) {
            s(lottieAnimationView);
        }
        invalidate();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this);
            return;
        }
        QLog.d("QUIColorfulQRCodeView", 1, NodeProps.ON_DETACHED_FROM_WINDOW);
        super.onDetachedFromWindow();
        LottieAnimationView lottieAnimationView = this.animLogoView;
        if (lottieAnimationView != null) {
            lottieAnimationView.cancelAnimation();
        }
    }

    @Override // android.view.View
    protected void onVisibilityChanged(@NotNull View changedView, int visibility) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, (Object) changedView, visibility);
            return;
        }
        Intrinsics.checkNotNullParameter(changedView, "changedView");
        super.onVisibilityChanged(changedView, visibility);
        QLog.d("QUIColorfulQRCodeView", 1, "onVisibilityChanged changedView:" + changedView + " visibility:" + visibility);
    }

    public final void q() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        this.isAdjustDarkLogo = true;
        this.isLogoThemeDependNotVasNight = true;
        this.isLogoLightTheme = true;
        this.onFirstTimeDrawnCallback = null;
        this.qrcodeView.r();
    }

    public final void setIsAdjustDarkLogo(boolean isAdjustDarkLogo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, isAdjustDarkLogo);
        } else {
            this.isAdjustDarkLogo = isAdjustDarkLogo;
        }
    }

    public final void setOnFirstTimeDrawnListener(@NotNull h callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) callback);
        } else {
            Intrinsics.checkNotNullParameter(callback, "callback");
            this.onFirstTimeDrawnCallback = callback;
        }
    }

    public final void setTargetGenerateQRCodeParams(@NotNull e generateQRParams) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) generateQRParams);
        } else {
            Intrinsics.checkNotNullParameter(generateQRParams, "generateQRParams");
            this.qrcodeView.setTargetGenerateQRCodeParams(generateQRParams);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public QUIColorfulQRCodeView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 0, 12, null);
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 20)) {
            return;
        }
        iPatchRedirector.redirect((short) 20, (Object) this, (Object) context, (Object) attributeSet);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public QUIColorfulQRCodeView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        this(context, attributeSet, i3, 0, 8, null);
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 19)) {
            return;
        }
        iPatchRedirector.redirect((short) 19, this, context, attributeSet, Integer.valueOf(i3));
    }

    public /* synthetic */ QUIColorfulQRCodeView(Context context, AttributeSet attributeSet, int i3, int i16, int i17, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i17 & 2) != 0 ? null : attributeSet, (i17 & 4) != 0 ? 0 : i3, (i17 & 8) != 0 ? 0 : i16);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, context, attributeSet, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), defaultConstructorMarker);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public QUIColorfulQRCodeView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3, int i16) {
        super(context, attributeSet, i3, i16);
        Object m476constructorimpl;
        String stackTraceToString;
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z16 = false;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, context, attributeSet, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        this.isLogoLightTheme = true;
        this.isLogoThemeDependNotVasNight = true;
        this.isAdjustDarkLogo = true;
        try {
            Result.Companion companion = Result.INSTANCE;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, la1.a.f414133h3);
            Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "context.obtainStyledAttr\u2026le.QUIColorfulQRCodeView)");
            z16 = obtainStyledAttributes.getBoolean(la1.a.i3, false);
            m476constructorimpl = Result.m476constructorimpl(Unit.INSTANCE);
        } catch (Throwable th5) {
            Result.Companion companion2 = Result.INSTANCE;
            m476constructorimpl = Result.m476constructorimpl(ResultKt.createFailure(th5));
        }
        Throwable m479exceptionOrNullimpl = Result.m479exceptionOrNullimpl(m476constructorimpl);
        if (m479exceptionOrNullimpl != null) {
            stackTraceToString = ExceptionsKt__ExceptionsKt.stackTraceToString(m479exceptionOrNullimpl);
            QLog.e("QUIColorfulQRCodeView", 1, "needStaticLogo error " + m479exceptionOrNullimpl + " \n " + stackTraceToString);
        }
        QLog.d("QUIColorfulQRCodeView", 1, "needStaticLogo:" + z16);
        ColorfulQRCodeOnlyView colorfulQRCodeOnlyView = new ColorfulQRCodeOnlyView(context);
        colorfulQRCodeOnlyView.setRefreshLogoSize(new QUIColorfulQRCodeView$3$1(this));
        this.qrcodeView = colorfulQRCodeOnlyView;
        addView(colorfulQRCodeOnlyView, -1, -1);
        if (z16) {
            ImageView imageView = new ImageView(context);
            this.staticLogoView = imageView;
            addView(imageView, new FrameLayout.LayoutParams(-2, -2, 17));
            ImageView imageView2 = this.staticLogoView;
            if (imageView2 != null) {
                imageView2.setVisibility(8);
            }
        } else {
            LottieAnimationView lottieAnimationView = new LottieAnimationView(context);
            this.animLogoView = lottieAnimationView;
            addView(lottieAnimationView, new FrameLayout.LayoutParams(-2, -2, 17));
            LottieAnimationView lottieAnimationView2 = this.animLogoView;
            if (lottieAnimationView2 != null) {
                lottieAnimationView2.setVisibility(8);
            }
        }
        g(new i(0, null, null, 0, 15, null));
    }
}
