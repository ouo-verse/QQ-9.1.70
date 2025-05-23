package com.tencent.mobileqq.troop.flame.detail.view;

import android.content.Context;
import android.graphics.Typeface;
import android.text.Layout;
import android.text.SpannableString;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.api.IChatSettingForTroopApi;
import com.tencent.mobileqq.troop.flame.api.ITroopFlameApi;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 12\u00020\u0001:\u0001\rB'\b\u0007\u0012\u0006\u0010+\u001a\u00020*\u0012\n\b\u0002\u0010-\u001a\u0004\u0018\u00010,\u0012\b\b\u0002\u0010.\u001a\u00020\f\u00a2\u0006\u0004\b/\u00100J\u0012\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0003\u001a\u00020\u0002H\u0002J,\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u0002H\u0002J\f\u0010\u000f\u001a\u00020\u0004*\u00020\u000eH\u0002J\u0018\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\fH\u0014J\u000e\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0013J\u000e\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\fJ\u000e\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\bR\u0016\u0010\u001b\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001e\u001a\u00020\u001c8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u001dR\u0014\u0010\u001f\u001a\u00020\u001c8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u001dR\u0014\u0010\"\u001a\u00020\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b \u0010!R\u0014\u0010$\u001a\u00020\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b#\u0010!R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u0018\u0010)\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010(\u00a8\u00062"}, d2 = {"Lcom/tencent/mobileqq/troop/flame/detail/view/TroopFlameNameView;", "Landroid/widget/LinearLayout;", "", "forceUpdate", "", "c", "Landroid/text/SpannableString;", "troopName", "Lcom/tencent/mobileqq/troop/flame/api/ITroopFlameApi$a;", "flameData", "includeFlameView", "Lkotlin/Pair;", "", "a", "Landroid/widget/RelativeLayout;", "b", "widthMeasureSpec", "heightMeasureSpec", "onMeasure", "", "f", "color", "g", "flameInfo", "e", "d", "Z", "inited", "Landroid/widget/TextView;", "Landroid/widget/TextView;", "nameTextView1", "nameTextView2", h.F, "Landroid/widget/RelativeLayout;", "flameViewGroup1", "i", "flameViewGroup2", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/lang/String;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/troop/flame/api/ITroopFlameApi$a;", "flameViewData", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "D", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class TroopFlameNameView extends LinearLayout {
    static IPatchRedirector $redirector_;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private ITroopFlameApi.a flameViewData;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private boolean inited;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final TextView nameTextView1;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final TextView nameTextView2;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final RelativeLayout flameViewGroup1;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final RelativeLayout flameViewGroup2;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String troopName;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/troop/flame/detail/view/TroopFlameNameView$a;", "", "", "TEXT_SIZE_DP", UserInfo.SEX_FEMALE, "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.troop.flame.detail.view.TroopFlameNameView$a, reason: from kotlin metadata */
    /* loaded from: classes19.dex */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(36207);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 9)) {
            redirector.redirect((short) 9);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public TroopFlameNameView(@NotNull Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 8)) {
            return;
        }
        iPatchRedirector.redirect((short) 8, (Object) this, (Object) context);
    }

    private final Pair<Integer, Integer> a(SpannableString troopName, ITroopFlameApi.a flameData, boolean includeFlameView) {
        int measuredWidth = getMeasuredWidth();
        if (includeFlameView) {
            measuredWidth -= b.f296107a.d(flameData.f296040a, flameData.f296041b, flameData.f296042c);
        }
        TextPaint textPaint = new TextPaint();
        textPaint.setAntiAlias(true);
        textPaint.setTextSize(getContext().getResources().getDisplayMetrics().density * 20.0f);
        textPaint.setTypeface(Typeface.DEFAULT_BOLD);
        StaticLayout staticLayout = new StaticLayout(troopName, textPaint, measuredWidth, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false);
        return new Pair<>(Integer.valueOf(staticLayout.getLineStart(0)), Integer.valueOf(staticLayout.getLineEnd(0)));
    }

    private final void b(RelativeLayout relativeLayout) {
        relativeLayout.setVisibility(0);
        relativeLayout.removeAllViews();
        ITroopFlameApi.a aVar = this.flameViewData;
        if (aVar != null) {
            Context context = relativeLayout.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            TroopFlameStaticView troopFlameStaticView = new TroopFlameStaticView(context, aVar.f296040a, aVar.f296041b, aVar.f296042c);
            relativeLayout.addView(troopFlameStaticView, -2, -2);
            TroopFlameStaticView.e(troopFlameStaticView, null, 1, null);
        }
    }

    private final void c(boolean forceUpdate) {
        SpannableString spannableStringFromColorNickText;
        if (getMeasuredWidth() != 0) {
            if ((!this.inited || forceUpdate) && (spannableStringFromColorNickText = ((IChatSettingForTroopApi) QRoute.api(IChatSettingForTroopApi.class)).getSpannableStringFromColorNickText(this.troopName, 16)) != null) {
                this.inited = true;
                ITroopFlameApi.a aVar = this.flameViewData;
                if (aVar != null && aVar.f296043d) {
                    if (a(spannableStringFromColorNickText, aVar, true).getSecond().intValue() == spannableStringFromColorNickText.length()) {
                        this.nameTextView1.setText(spannableStringFromColorNickText);
                        this.nameTextView2.setVisibility(8);
                        b(this.flameViewGroup1);
                        RelativeLayout relativeLayout = this.flameViewGroup2;
                        relativeLayout.removeAllViews();
                        relativeLayout.setVisibility(8);
                        return;
                    }
                    Pair<Integer, Integer> a16 = a(spannableStringFromColorNickText, aVar, false);
                    this.nameTextView1.setText(spannableStringFromColorNickText.subSequence(a16.getFirst().intValue(), a16.getSecond().intValue()).toString());
                    TextView textView = this.nameTextView2;
                    textView.setText(spannableStringFromColorNickText.subSequence(a16.getSecond().intValue(), spannableStringFromColorNickText.length()).toString());
                    textView.setVisibility(0);
                    RelativeLayout relativeLayout2 = this.flameViewGroup1;
                    relativeLayout2.removeAllViews();
                    relativeLayout2.setVisibility(8);
                    b(this.flameViewGroup2);
                    return;
                }
                this.nameTextView1.setText(spannableStringFromColorNickText);
            }
        }
    }

    static /* synthetic */ void d(TroopFlameNameView troopFlameNameView, boolean z16, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z16 = false;
        }
        troopFlameNameView.c(z16);
    }

    public final void e(@NotNull ITroopFlameApi.a flameInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) flameInfo);
            return;
        }
        Intrinsics.checkNotNullParameter(flameInfo, "flameInfo");
        if (this.flameViewData == null) {
            this.flameViewData = flameInfo;
            c(true);
        }
    }

    public final void f(@NotNull String troopName) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) troopName);
            return;
        }
        Intrinsics.checkNotNullParameter(troopName, "troopName");
        boolean z16 = !Intrinsics.areEqual(this.troopName, troopName);
        this.troopName = troopName;
        c(z16);
    }

    public final void g(int color) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, color);
        } else {
            this.nameTextView1.setTextColor(color);
            this.nameTextView2.setTextColor(color);
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, Integer.valueOf(widthMeasureSpec), Integer.valueOf(heightMeasureSpec));
        } else {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
            d(this, false, 1, null);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public TroopFlameNameView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 7)) {
            return;
        }
        iPatchRedirector.redirect((short) 7, (Object) this, (Object) context, (Object) attributeSet);
    }

    public /* synthetic */ TroopFlameNameView(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, context, attributeSet, Integer.valueOf(i3), Integer.valueOf(i16), defaultConstructorMarker);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public TroopFlameNameView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, context, attributeSet, Integer.valueOf(i3));
            return;
        }
        setOrientation(1);
        LayoutInflater.from(context).inflate(R.layout.fzo, (ViewGroup) this, true);
        View findViewById = findViewById(R.id.f102935z9);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.troop_name_tv_1)");
        this.nameTextView1 = (TextView) findViewById;
        View findViewById2 = findViewById(R.id.f102945z_);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.troop_name_tv_2)");
        this.nameTextView2 = (TextView) findViewById2;
        View findViewById3 = findViewById(R.id.uyv);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.extra_view_group1)");
        this.flameViewGroup1 = (RelativeLayout) findViewById3;
        View findViewById4 = findViewById(R.id.uyw);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(R.id.extra_view_group2)");
        this.flameViewGroup2 = (RelativeLayout) findViewById4;
    }
}
