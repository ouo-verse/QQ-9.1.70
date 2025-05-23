package com.tencent.mobileqq.springhb.prize;

import android.content.Context;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.springhb.entry.model.GameCenterConfigData;
import com.tencent.mobileqq.springhb.pack.PackInfo;
import com.tencent.mobileqq.springhb.preload.SpringRes;
import com.tencent.mobileqq.vas.pay.api.impl.VasNativePayManagerImpl;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.Arrays;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\b\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001eB\u000f\u0012\u0006\u0010\f\u001a\u00020\t\u00a2\u0006\u0004\b\u001b\u0010\u001cJ \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016R\u0014\u0010\f\u001a\u00020\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0016\u0010\u0010\u001a\u00020\r8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u001b\u0010\u0016\u001a\u00020\u00118BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0014\u0010\u001a\u001a\u00020\u00178VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/mobileqq/springhb/prize/MoneyViewV2;", "Lcom/tencent/mobileqq/springhb/prize/SpringPrizeView;", "Lcom/tencent/mobileqq/springhb/pack/PackInfo;", "packInfo", "Landroid/view/View;", "prizeView", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "", "p", "Landroidx/fragment/app/FragmentActivity;", "i", "Landroidx/fragment/app/FragmentActivity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/widget/ImageView;", "j", "Landroid/widget/ImageView;", "gameIv", "Landroid/graphics/Typeface;", "k", "Lkotlin/Lazy;", "w", "()Landroid/graphics/Typeface;", "cashAmountTypeface", "", "d", "()I", "layoutId", "<init>", "(Landroidx/fragment/app/FragmentActivity;)V", "l", "a", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class MoneyViewV2 extends SpringPrizeView {
    static IPatchRedirector $redirector_;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final FragmentActivity activity;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    private ImageView gameIv;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy cashAmountTypeface;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/springhb/prize/MoneyViewV2$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.springhb.prize.MoneyViewV2$a, reason: from kotlin metadata */
    /* loaded from: classes18.dex */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(61249);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MoneyViewV2(@NotNull FragmentActivity activity) {
        super(activity);
        Lazy lazy;
        Intrinsics.checkNotNullParameter(activity, "activity");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) activity);
            return;
        }
        this.activity = activity;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<Typeface>() { // from class: com.tencent.mobileqq.springhb.prize.MoneyViewV2$cashAmountTypeface$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) MoneyViewV2.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Typeface invoke() {
                FragmentActivity fragmentActivity;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (Typeface) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
                fragmentActivity = MoneyViewV2.this.activity;
                return Typeface.createFromAsset(fragmentActivity.getAssets(), VasNativePayManagerImpl.DINALTERNATE_BOLD_FONT_PATH);
            }
        });
        this.cashAmountTypeface = lazy;
    }

    private final Typeface w() {
        Object value = this.cashAmountTypeface.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-cashAmountTypeface>(...)");
        return (Typeface) value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void x(MoneyViewV2 this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.o(this$0.b().f289575j);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void y(MoneyViewV2 this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QLog.i("SpringHb_Money", 1, "[permission.url]:" + this$0.b().f289577l);
        this$0.o(this$0.b().f289577l);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void z(MoneyViewV2 this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        h.i(this$0.b().f289566a);
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.mobileqq.springhb.prize.SpringPrizeView
    public int d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return R.layout.hqp;
    }

    @Override // com.tencent.mobileqq.springhb.prize.SpringPrizeView
    public void p(@NotNull PackInfo packInfo, @NotNull View prizeView, @NotNull View rootView) {
        Drawable drawable;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, packInfo, prizeView, rootView);
            return;
        }
        Intrinsics.checkNotNullParameter(packInfo, "packInfo");
        Intrinsics.checkNotNullParameter(prizeView, "prizeView");
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.p(packInfo, prizeView, rootView);
        QLog.d("SpringHb_Money", 1, "initprizeView: ");
        View findViewById = prizeView.findViewById(R.id.vqx);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById<ImageView>(R.id.go_to_home_page_iv)");
        this.gameIv = (ImageView) findViewById;
        h c16 = c();
        ImageView imageView = this.gameIv;
        Drawable drawable2 = null;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("gameIv");
            imageView = null;
        }
        c16.p(imageView);
        ImageView imageView2 = (ImageView) prizeView.findViewById(R.id.z4x);
        String str = packInfo.businessLogo;
        if (str == null) {
            str = "";
        } else {
            Intrinsics.checkNotNullExpressionValue(str, "packInfo.businessLogo ?: \"\"");
        }
        imageView2.setImageDrawable(SpringRes.j(com.tencent.mobileqq.springhb.preload.s.b(str), e(), null, 2, null));
        ((ImageView) prizeView.findViewById(R.id.f164563t32)).setImageDrawable(SpringRes.j(com.tencent.mobileqq.springhb.preload.s.a("spring_detail_prize_cash_bg.png"), null, null, 3, null));
        ((TextView) prizeView.findViewById(R.id.z4z)).setText(packInfo.businessName);
        ((ImageView) prizeView.findViewById(R.id.z4y)).setImageDrawable(SpringRes.j(com.tencent.mobileqq.springhb.preload.s.a("spring_detail_logo_golden_border.png"), null, null, 3, null));
        TextView textView = (TextView) prizeView.findViewById(R.id.tos);
        textView.setTypeface(w());
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String format = String.format("%.2f", Arrays.copyOf(new Object[]{Float.valueOf(packInfo.money / 100.0f)}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
        textView.setText(format);
        prizeView.findViewById(R.id.tot);
        View findViewById2 = prizeView.findViewById(R.id.f164563t32);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById<ImageView>(R.id.background_image)");
        ImageView imageView3 = (ImageView) findViewById2;
        GameCenterConfigData h16 = h.h();
        if (h16 != null && !TextUtils.isEmpty(h16.bottomBkgResUrl)) {
            String str2 = h16.bottomBkgResUrl;
            Intrinsics.checkNotNullExpressionValue(str2, "gameConfigData.bottomBkgResUrl");
            SpringRes b16 = com.tencent.mobileqq.springhb.preload.s.b(str2);
            Context context = prizeView.getContext();
            if (context != null) {
                drawable = context.getDrawable(R.drawable.o3o);
            } else {
                drawable = null;
            }
            imageView3.setImageDrawable(SpringRes.j(b16, drawable, null, 2, null));
        } else {
            Context context2 = prizeView.getContext();
            if (context2 != null) {
                drawable2 = context2.getDrawable(R.drawable.o3o);
            }
            imageView3.setImageDrawable(drawable2);
        }
        ((TextView) prizeView.findViewById(R.id.u2o)).setText(b().f289573h);
        ((TextView) prizeView.findViewById(R.id.f116636z_)).setText(b().f289574i);
        ((TextView) prizeView.findViewById(R.id.f27700gy)).setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.springhb.prize.i
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MoneyViewV2.x(MoneyViewV2.this, view);
            }
        });
        ((TextView) prizeView.findViewById(R.id.sqj)).setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.springhb.prize.j
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MoneyViewV2.y(MoneyViewV2.this, view);
            }
        });
        ((TextView) prizeView.findViewById(R.id.f27830ha)).setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.springhb.prize.k
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MoneyViewV2.z(MoneyViewV2.this, view);
            }
        });
        ad.f289558a.a(packInfo.money);
    }
}
