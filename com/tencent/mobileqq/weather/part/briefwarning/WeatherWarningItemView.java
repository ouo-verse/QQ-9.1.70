package com.tencent.mobileqq.weather.part.briefwarning;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.weather.util.g;
import com.tencent.mobileqq.weather.util.report.s;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\b\u0018\u00002\u00020\u0001B)\b\u0016\u0012\u0006\u0010\"\u001a\u00020\t\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010#\u001a\u00020\u001e\u00a2\u0006\u0004\b$\u0010%J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002R\u0016\u0010\u000b\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\nR\u0016\u0010\u000f\u001a\u00020\f8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0015\u001a\u00020\u00108\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0012R\u0016\u0010\u0019\u001a\u00020\u00168\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001b\u001a\u00020\u00168\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u0018R\u0016\u0010\u001d\u001a\u00020\u00168\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u0018R\u0016\u0010!\u001a\u00020\u001e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 \u00a8\u0006&"}, d2 = {"Lcom/tencent/mobileqq/weather/part/briefwarning/WeatherWarningItemView;", "Landroid/widget/FrameLayout;", "", "d", "Lcom/tencent/mobileqq/weather/part/briefwarning/e;", "data", "", "isHideWarningDesc", "b", "Landroid/content/Context;", "Landroid/content/Context;", "mContext", "Landroid/view/View;", "e", "Landroid/view/View;", "mRootView", "Landroid/widget/ImageView;", "f", "Landroid/widget/ImageView;", "mWarningIcon", h.F, "mWarningMoreIcon", "Landroid/widget/TextView;", "i", "Landroid/widget/TextView;", "mWarningText", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "mWarningArea", BdhLogUtil.LogTag.Tag_Conn, "mWarningTime", "", "D", "I", "mIndex", "context", "index", "<init>", "(Landroid/content/Context;Lcom/tencent/mobileqq/weather/part/briefwarning/e;ZI)V", "qq-weather-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class WeatherWarningItemView extends FrameLayout {
    static IPatchRedirector $redirector_;

    /* renamed from: C, reason: from kotlin metadata */
    private TextView mWarningTime;

    /* renamed from: D, reason: from kotlin metadata */
    private int mIndex;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private Context mContext;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private View mRootView;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private ImageView mWarningIcon;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private ImageView mWarningMoreIcon;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private TextView mWarningText;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private TextView mWarningArea;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WeatherWarningItemView(@NotNull Context context, @NotNull e data, boolean z16, int i3) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(data, "data");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, context, data, Boolean.valueOf(z16), Integer.valueOf(i3));
            return;
        }
        Context context2 = getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "context");
        this.mContext = context2;
        this.mIndex = i3;
        d();
        b(data, z16);
    }

    private final void b(final e data, boolean isHideWarningDesc) {
        TextView textView = this.mWarningText;
        View view = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mWarningText");
            textView = null;
        }
        textView.setText(data.f());
        TextView textView2 = this.mWarningText;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mWarningText");
            textView2 = null;
        }
        textView2.setTextColor(Color.parseColor(data.c()));
        TextView textView3 = this.mWarningTime;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mWarningTime");
            textView3 = null;
        }
        textView3.setText(data.g());
        TextView textView4 = this.mWarningArea;
        if (textView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mWarningArea");
            textView4 = null;
        }
        textView4.setText(data.b());
        ImageView imageView = this.mWarningIcon;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mWarningIcon");
            imageView = null;
        }
        imageView.setImageDrawable(com.tencent.mobileqq.weather.util.b.e(data.d()));
        if (isHideWarningDesc) {
            TextView textView5 = this.mWarningTime;
            if (textView5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mWarningTime");
                textView5 = null;
            }
            textView5.setVisibility(8);
            ImageView imageView2 = this.mWarningMoreIcon;
            if (imageView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mWarningMoreIcon");
                imageView2 = null;
            }
            imageView2.setVisibility(8);
        }
        View view2 = this.mRootView;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRootView");
        } else {
            view = view2;
        }
        view.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.weather.part.briefwarning.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view3) {
                WeatherWarningItemView.c(WeatherWarningItemView.this, data, view3);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(WeatherWarningItemView this$0, e data, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(data, "$data");
        g.f313646a.O(this$0.mContext, data.e());
        s.f313696a.c(this$0.mIndex, data.a());
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void d() {
        View inflate = LayoutInflater.from(this.mContext).inflate(R.layout.h7m, (ViewGroup) this, true);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflater.inflate(R.layou\u2026_item_layout, this, true)");
        this.mRootView = inflate;
        View view = null;
        if (inflate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRootView");
            inflate = null;
        }
        View findViewById = inflate.findViewById(R.id.f121997cr);
        Intrinsics.checkNotNullExpressionValue(findViewById, "mRootView.findViewById(R.id.weather_warning_icon)");
        this.mWarningIcon = (ImageView) findViewById;
        View view2 = this.mRootView;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRootView");
            view2 = null;
        }
        View findViewById2 = view2.findViewById(R.id.f122017ct);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "mRootView.findViewById(R.id.weather_warning_text)");
        this.mWarningText = (TextView) findViewById2;
        View view3 = this.mRootView;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRootView");
            view3 = null;
        }
        View findViewById3 = view3.findViewById(R.id.f121967co);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "mRootView.findViewById(R.id.weather_warning_area)");
        this.mWarningArea = (TextView) findViewById3;
        View view4 = this.mRootView;
        if (view4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRootView");
            view4 = null;
        }
        View findViewById4 = view4.findViewById(R.id.f122027cu);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "mRootView.findViewById(R.id.weather_warning_time)");
        this.mWarningTime = (TextView) findViewById4;
        View view5 = this.mRootView;
        if (view5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRootView");
        } else {
            view = view5;
        }
        View findViewById5 = view.findViewById(R.id.f122007cs);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "mRootView.findViewById(R\u2026eather_warning_more_icon)");
        this.mWarningMoreIcon = (ImageView) findViewById5;
    }
}
