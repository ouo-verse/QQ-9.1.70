package com.tencent.mobileqq.hermes.share;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.AnimationSet;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.ScaleAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.common.picload.QQPicLoader;
import com.tencent.mobileqq.component.qrcode.QUIColorfulQRCodeView;
import com.tencent.mobileqq.hermes.easteregg.BrandEasterConfigBean;
import com.tencent.mobileqq.proavatar.QQProAvatarView;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.widget.share.ShareActionSheetV2;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.avatar.meta.b;
import com.tencent.richframework.gallery.bean.RFWLayerPicInfo;
import java.lang.ref.WeakReference;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u0000 -2\u00020\u0001:\u0001.B\u000f\u0012\u0006\u0010*\u001a\u00020)\u00a2\u0006\u0004\b+\u0010,J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J$\u0010\n\u001a\u001e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006j\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b`\tH\u0002J\b\u0010\u000b\u001a\u00020\u0004H\u0002J\u0010\u0010\f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\r\u001a\u00020\u0007H\u0014J\u000e\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u0002J\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010R\"\u0010\u0018\u001a\u00020\u00128\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R(\u0010\u001e\u001a\u0004\u0018\u00010\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u00198\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b\f\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR$\u0010%\u001a\u0004\u0018\u00010\u00028\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u0014\u0010(\u001a\u00020\u00078BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b&\u0010'\u00a8\u0006/"}, d2 = {"Lcom/tencent/mobileqq/hermes/share/j;", "Lcom/tencent/mobileqq/widget/share/ShareActionSheetV2;", "Lcom/tencent/mobileqq/hermes/share/k;", "hermesShareContext", "", "v0", "Ljava/util/HashMap;", "", "Lcom/tencent/mobileqq/component/qrcode/d;", "Lkotlin/collections/HashMap;", "E0", "J0", "K0", "I", "shareContext", "B0", "Landroid/graphics/Bitmap;", "G0", "Landroid/view/ViewGroup;", "Landroid/view/ViewGroup;", "H0", "()Landroid/view/ViewGroup;", "I0", "(Landroid/view/ViewGroup;)V", "sharePosterContainer", "Landroid/view/View;", "<set-?>", "Landroid/view/View;", "getSharePosterLayout", "()Landroid/view/View;", "sharePosterLayout", "L0", "Lcom/tencent/mobileqq/hermes/share/k;", "getMShareData", "()Lcom/tencent/mobileqq/hermes/share/k;", "setMShareData", "(Lcom/tencent/mobileqq/hermes/share/k;)V", "mShareData", "F0", "()I", "sharePosterAreaLayoutId", "Lcom/tencent/mobileqq/widget/share/ShareActionSheetV2$Param;", "param", "<init>", "(Lcom/tencent/mobileqq/widget/share/ShareActionSheetV2$Param;)V", "M0", "a", "hermes-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes8.dex */
public class j extends ShareActionSheetV2 {
    static IPatchRedirector $redirector_;

    /* renamed from: M0, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    @NotNull
    private static String N0;

    /* renamed from: J0, reason: from kotlin metadata */
    public ViewGroup sharePosterContainer;

    /* renamed from: K0, reason: from kotlin metadata */
    @Nullable
    private View sharePosterLayout;

    /* renamed from: L0, reason: from kotlin metadata */
    @Nullable
    private k mShareData;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0006\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u00058\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0007\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/hermes/share/j$a;", "", "", "SHARE_POSTER_IN_ANIM_DURATION_IN_MILLIS", "I", "", "SHARE_URL", "Ljava/lang/String;", "TAG", "<init>", "()V", "hermes-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.hermes.share.j$a, reason: from kotlin metadata */
    /* loaded from: classes8.dex */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(25368);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 12)) {
            redirector.redirect((short) 12);
            return;
        }
        INSTANCE = new Companion(null);
        N0 = "https://ti.qq.com/open_qq/index.html?url=" + URLEncoder.encode("mqqapi://about/open?src_type=app&version=1.0&sceneType=3", "UTF-8");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(@NotNull ShareActionSheetV2.Param param) {
        super(param);
        Intrinsics.checkNotNullParameter(param, "param");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) param);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void A0(View view, k hermesShareContext) {
        Intrinsics.checkNotNullParameter(hermesShareContext, "$hermesShareContext");
        ((TextView) view.findViewById(R.id.x_1)).setText("\u7b2c " + com.tencent.mobileqq.hermes.util.a.f236827a.a(hermesShareContext.e()) + " \u4f4d\u63a2\u7d22\u8005");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void C0(j this$0, k shareContext, DialogInterface dialogInterface) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(shareContext, "$shareContext");
        if (QLog.isColorLevel()) {
            QLog.d("HermesShareActionSheet", 2, "onShow ", Integer.valueOf(this$0.N.getHeight()));
        }
        this$0.K0(shareContext);
    }

    private final HashMap<Integer, com.tencent.mobileqq.component.qrcode.d> E0() {
        HashMap<Integer, com.tencent.mobileqq.component.qrcode.d> hashMap = new HashMap<>();
        hashMap.put(3, new com.tencent.mobileqq.component.qrcode.d(7, 6, 12.0f, 3.0f));
        hashMap.put(4, new com.tencent.mobileqq.component.qrcode.d(9, 7, 12.0f, 3.0f));
        hashMap.put(5, new com.tencent.mobileqq.component.qrcode.d(10, 8, 12.0f, 3.0f));
        hashMap.put(6, new com.tencent.mobileqq.component.qrcode.d(11, 9, 12.0f, 3.0f));
        hashMap.put(7, new com.tencent.mobileqq.component.qrcode.d(12, 10, 12.0f, 3.0f));
        hashMap.put(8, new com.tencent.mobileqq.component.qrcode.d(13, 11, 12.0f, 3.0f));
        hashMap.put(9, new com.tencent.mobileqq.component.qrcode.d(14, 12, 12.0f, 3.0f));
        return hashMap;
    }

    private final int F0() {
        return R.layout.f_y;
    }

    private final void J0() {
        View findViewById = this.G.findViewById(R.id.x_0);
        Intrinsics.checkNotNull(findViewById, "null cannot be cast to non-null type android.widget.ImageView");
        QQPicLoader qQPicLoader = QQPicLoader.f201806a;
        Option obtain = Option.obtain();
        k kVar = this.mShareData;
        Intrinsics.checkNotNull(kVar);
        RFWLayerPicInfo layerPicInfo = kVar.d().getLayerPicInfo();
        Intrinsics.checkNotNull(layerPicInfo);
        Option targetView = obtain.setUrl(layerPicInfo.getCurrentPicInfo().getUrl()).setTargetView((ImageView) findViewById);
        Intrinsics.checkNotNullExpressionValue(targetView, "obtain().setUrl(\n       \u2026picContentBackgroundView)");
        qQPicLoader.e(targetView, null);
    }

    private final void K0(k hermesShareContext) {
        v0(hermesShareContext);
        if (this.mShareData == null) {
            QLog.e("HermesShareActionSheet", 1, "bindData error, mOnlineStatusData is null!");
        } else {
            J0();
        }
    }

    private final void v0(final k hermesShareContext) {
        List<Integer> listOf;
        List<Float> listOf2;
        String str;
        WeakReference<Context> weakReference = this.f317430e;
        if (weakReference != null && weakReference.get() != null) {
            this.G.findViewById(R.id.f84204lm).setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.hermes.share.e
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    j.w0(j.this, view);
                }
            });
            View findViewById = this.G.findViewById(R.id.f84444m_);
            Intrinsics.checkNotNullExpressionValue(findViewById, "mShowView.findViewById(R\u2026d.share_poster_container)");
            I0((ViewGroup) findViewById);
            H0().setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.hermes.share.f
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    j.x0(view);
                }
            });
            String str2 = null;
            final View inflate = View.inflate(this.f317430e.get(), F0(), null);
            Context context = this.f317430e.get();
            Intrinsics.checkNotNull(context);
            Resources resources = context.getResources();
            float dimension = resources.getDimension(R.dimen.cj6);
            float dimension2 = resources.getDimension(R.dimen.cj5);
            float width = H0().getWidth() / dimension;
            inflate.setScaleX(width);
            inflate.setScaleY(width);
            inflate.setPivotX(0.0f);
            inflate.setPivotY(0.0f);
            H0().addView(inflate, new FrameLayout.LayoutParams((int) dimension, (int) dimension2));
            this.sharePosterLayout = inflate;
            View findViewById2 = inflate.findViewById(R.id.x9y);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "inflateView.findViewById(R.id.hermes_share_avatar)");
            String currentAccountUin = MobileQQ.sMobileQQ.peekAppRuntime().getCurrentAccountUin();
            Intrinsics.checkNotNullExpressionValue(currentAccountUin, "sMobileQQ.peekAppRuntime().currentAccountUin");
            ((QQProAvatarView) findViewById2).A(new b.a(1, currentAccountUin, 140, true).b());
            View findViewById3 = inflate.findViewById(R.id.f654338x);
            Intrinsics.checkNotNullExpressionValue(findViewById3, "inflateView.findViewById(R.id.qrcode_view)");
            QUIColorfulQRCodeView qUIColorfulQRCodeView = (QUIColorfulQRCodeView) findViewById3;
            listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new Integer[]{-16777216, -16777216, -16777216});
            listOf2 = CollectionsKt__CollectionsKt.listOf((Object[]) new Float[]{Float.valueOf(0.0f), Float.valueOf(0.5f), Float.valueOf(1.0f)});
            qUIColorfulQRCodeView.n(listOf, listOf2);
            qUIColorfulQRCodeView.setTargetGenerateQRCodeParams(new com.tencent.mobileqq.component.qrcode.e(3, 9, E0(), ErrorCorrectionLevel.M));
            qUIColorfulQRCodeView.setOnFirstTimeDrawnListener(new com.tencent.mobileqq.component.qrcode.h() { // from class: com.tencent.mobileqq.hermes.share.g
                @Override // com.tencent.mobileqq.component.qrcode.h
                public final void a() {
                    j.y0();
                }
            });
            BrandEasterConfigBean b16 = hermesShareContext.b();
            if (b16 != null) {
                str = b16.getQrCodeUrl();
            } else {
                str = null;
            }
            if (!TextUtils.isEmpty(str)) {
                BrandEasterConfigBean b17 = hermesShareContext.b();
                if (b17 != null) {
                    str2 = b17.getQrCodeUrl();
                }
                Intrinsics.checkNotNull(str2);
            } else {
                str2 = N0;
            }
            qUIColorfulQRCodeView.f(str2, new com.tencent.mobileqq.component.qrcode.g() { // from class: com.tencent.mobileqq.hermes.share.h
                @Override // com.tencent.mobileqq.component.qrcode.g
                public final void onResult(int i3) {
                    j.z0(i3);
                }
            });
            qUIColorfulQRCodeView.post(new Runnable() { // from class: com.tencent.mobileqq.hermes.share.i
                @Override // java.lang.Runnable
                public final void run() {
                    j.A0(inflate, hermesShareContext);
                }
            });
            AnimationSet animationSet = new AnimationSet(true);
            AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
            alphaAnimation.setInterpolator(new LinearInterpolator());
            animationSet.addAnimation(alphaAnimation);
            ScaleAnimation scaleAnimation = new ScaleAnimation(0.8f, 1.0f, 0.8f, 1.0f, 1, 0.5f, 1, 0.5f);
            scaleAnimation.setInterpolator(new DecelerateInterpolator());
            animationSet.addAnimation(scaleAnimation);
            animationSet.setDuration(450L);
            H0().startAnimation(animationSet);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void w0(j this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.dismiss();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void x0(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void y0() {
        QLog.i("HermesShareActionSheet", 1, "OnFirstTimeDrawn");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void z0(int i3) {
        QLog.i("HermesShareActionSheet", 1, "refreshContent generateQRCode " + i3);
    }

    public final void B0(@NotNull final k shareContext) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) shareContext);
            return;
        }
        Intrinsics.checkNotNullParameter(shareContext, "shareContext");
        this.mShareData = shareContext;
        setOnShowListener(new DialogInterface.OnShowListener() { // from class: com.tencent.mobileqq.hermes.share.c
            @Override // android.content.DialogInterface.OnShowListener
            public final void onShow(DialogInterface dialogInterface) {
                j.C0(j.this, shareContext, dialogInterface);
            }
        });
        setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.tencent.mobileqq.hermes.share.d
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                j.D0(dialogInterface);
            }
        });
    }

    @Nullable
    public final Bitmap G0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (Bitmap) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        View view = this.sharePosterLayout;
        if (view == null) {
            return null;
        }
        com.tencent.mobileqq.hermes.util.a aVar = com.tencent.mobileqq.hermes.util.a.f236827a;
        Intrinsics.checkNotNull(view);
        Bitmap h16 = aVar.h(view, -1);
        if (h16 == null) {
            if (QLog.isColorLevel()) {
                QLog.w("HermesShareActionSheet", 2, "getSharePosterBitmap from sharePosterLayout failed, try use sharePosterContainer!");
            }
            return aVar.h(H0(), -1);
        }
        return h16;
    }

    @NotNull
    public final ViewGroup H0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (ViewGroup) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        ViewGroup viewGroup = this.sharePosterContainer;
        if (viewGroup != null) {
            return viewGroup;
        }
        Intrinsics.throwUninitializedPropertyAccessException("sharePosterContainer");
        return null;
    }

    @Override // com.tencent.mobileqq.widget.share.ShareActionSheetV2
    protected int I() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Integer) iPatchRedirector.redirect((short) 9, (Object) this)).intValue();
        }
        return R.layout.f_x;
    }

    public final void I0(@NotNull ViewGroup viewGroup) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) viewGroup);
        } else {
            Intrinsics.checkNotNullParameter(viewGroup, "<set-?>");
            this.sharePosterContainer = viewGroup;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void D0(DialogInterface dialogInterface) {
    }
}
