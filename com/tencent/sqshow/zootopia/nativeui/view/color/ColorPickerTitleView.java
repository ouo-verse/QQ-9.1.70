package com.tencent.sqshow.zootopia.nativeui.view.color;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.sqshow.zootopia.card.report.ZplanViewReportHelper;
import com.tencent.sqshow.zootopia.nativeui.data.j;
import com.tencent.sqshow.zootopia.nativeui.view.color.ColorPickerTitleView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tl.h;
import y94.a;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 '2\u00020\u0001:\u0001(B#\u0012\b\u0010 \u001a\u0004\u0018\u00010\u001f\u0012\b\u0010\"\u001a\u0004\u0018\u00010!\u0012\u0006\u0010#\u001a\u00020\t\u00a2\u0006\u0004\b$\u0010%B\u001f\b\u0017\u0012\b\u0010 \u001a\u0004\u0018\u00010\u001f\u0012\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010!\u00a2\u0006\u0004\b$\u0010&J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0002J\u000e\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006J\u0018\u0010\f\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\tJ\u001a\u0010\u000f\u001a\u00020\u00022\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00020\rJ\u000e\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\tR\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0013R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0017R$\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u0002\u0018\u00010\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001e\u00a8\u0006)"}, d2 = {"Lcom/tencent/sqshow/zootopia/nativeui/view/color/ColorPickerTitleView;", "Landroid/widget/LinearLayout;", "", "f", "c", "g", "Lcom/tencent/sqshow/zootopia/nativeui/data/j;", WadlProxyConsts.CHANNEL, "setChannel", "", "type", "itemIndex", "setShowType", "Lkotlin/Function1;", "callback", "setOnTabSelectedListener", h.F, "Landroid/widget/TextView;", "d", "Landroid/widget/TextView;", "singleText", "Landroid/view/View;", "e", "Landroid/view/View;", "singleLine", "gradientText", "gradientLine", "i", "Lkotlin/jvm/functions/Function1;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/sqshow/zootopia/nativeui/data/j;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", BdhLogUtil.LogTag.Tag_Conn, "a", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class ColorPickerTitleView extends LinearLayout {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private TextView singleText;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private View singleLine;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private TextView gradientText;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private View gradientLine;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private Function1<? super Integer, Unit> callback;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private j channel;

    public ColorPickerTitleView(Context context) {
        this(context, null, 2, 0 == true ? 1 : 0);
    }

    private final void c() {
        TextView textView = this.singleText;
        if (textView != null) {
            textView.setOnClickListener(new View.OnClickListener() { // from class: aa4.b
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ColorPickerTitleView.d(ColorPickerTitleView.this, view);
                }
            });
        }
        TextView textView2 = this.gradientText;
        if (textView2 != null) {
            textView2.setOnClickListener(new View.OnClickListener() { // from class: aa4.c
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ColorPickerTitleView.e(ColorPickerTitleView.this, view);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(ColorPickerTitleView this$0, View it) {
        a reporter;
        ZplanViewReportHelper mReporter;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.h(0);
        Function1<? super Integer, Unit> function1 = this$0.callback;
        if (function1 != null) {
            function1.invoke(0);
        }
        j jVar = this$0.channel;
        if (jVar == null || (reporter = jVar.getReporter()) == null || (mReporter = reporter.getMReporter()) == null) {
            return;
        }
        Intrinsics.checkNotNullExpressionValue(it, "it");
        ZplanViewReportHelper.f(mReporter, it, "em_zplan_makeup_dye_single", null, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(ColorPickerTitleView this$0, View it) {
        a reporter;
        ZplanViewReportHelper mReporter;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.h(1);
        Function1<? super Integer, Unit> function1 = this$0.callback;
        if (function1 != null) {
            function1.invoke(1);
        }
        j jVar = this$0.channel;
        if (jVar == null || (reporter = jVar.getReporter()) == null || (mReporter = reporter.getMReporter()) == null) {
            return;
        }
        Intrinsics.checkNotNullExpressionValue(it, "it");
        ZplanViewReportHelper.f(mReporter, it, "em_zplan_makeup_dye_fade", null, 4, null);
    }

    private final void g() {
        TextView textView = this.gradientText;
        if (textView != null) {
            textView.setVisibility(8);
        }
        View view = this.gradientLine;
        if (view == null) {
            return;
        }
        view.setVisibility(8);
    }

    public final void setChannel(j channel) {
        Intrinsics.checkNotNullParameter(channel, "channel");
        this.channel = channel;
    }

    public final void setOnTabSelectedListener(Function1<? super Integer, Unit> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.callback = callback;
    }

    public ColorPickerTitleView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        View.inflate(context, R.layout.daz, this);
        f();
        c();
    }

    private final void f() {
        this.singleText = (TextView) findViewById(R.id.pl7);
        this.singleLine = findViewById(R.id.pl6);
        this.gradientText = (TextView) findViewById(R.id.pl5);
        this.gradientLine = findViewById(R.id.f163340pl4);
    }

    public ColorPickerTitleView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public static /* synthetic */ void setShowType$default(ColorPickerTitleView colorPickerTitleView, int i3, int i16, int i17, Object obj) {
        if ((i17 & 2) != 0) {
            i16 = 0;
        }
        colorPickerTitleView.setShowType(i3, i16);
    }

    public /* synthetic */ ColorPickerTitleView(Context context, AttributeSet attributeSet, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet);
    }

    public final void h(int itemIndex) {
        if (itemIndex == 0) {
            TextView textView = this.singleText;
            if (textView != null) {
                textView.setTextColor(Color.parseColor("#0099FF"));
            }
            TextView textView2 = this.singleText;
            if (textView2 != null) {
                textView2.setAlpha(1.0f);
            }
            View view = this.singleLine;
            if (view != null) {
                view.setVisibility(0);
            }
            TextView textView3 = this.gradientText;
            if (textView3 != null) {
                textView3.setTextColor(Color.parseColor("#2C3951"));
            }
            TextView textView4 = this.gradientText;
            if (textView4 != null) {
                textView4.setAlpha(0.6f);
            }
            View view2 = this.gradientLine;
            if (view2 == null) {
                return;
            }
            view2.setVisibility(8);
            return;
        }
        if (itemIndex != 1) {
            return;
        }
        TextView textView5 = this.singleText;
        if (textView5 != null) {
            textView5.setTextColor(Color.parseColor("#2C3951"));
        }
        View view3 = this.singleLine;
        if (view3 != null) {
            view3.setVisibility(8);
        }
        TextView textView6 = this.singleText;
        if (textView6 != null) {
            textView6.setAlpha(0.6f);
        }
        TextView textView7 = this.gradientText;
        if (textView7 != null) {
            textView7.setTextColor(Color.parseColor("#0099FF"));
        }
        View view4 = this.gradientLine;
        if (view4 != null) {
            view4.setVisibility(0);
        }
        TextView textView8 = this.gradientText;
        if (textView8 == null) {
            return;
        }
        textView8.setAlpha(1.0f);
    }

    public final void setShowType(int type, int itemIndex) {
        TextView textView;
        j jVar;
        a reporter;
        ZplanViewReportHelper mReporter;
        TextView textView2;
        j jVar2;
        a reporter2;
        ZplanViewReportHelper mReporter2;
        if (type == 1) {
            h(0);
            g();
        } else if (type == 2) {
            h(itemIndex);
        } else if (type == 3) {
            h(0);
            g();
        } else if (type == 4) {
            h(0);
            g();
        }
        TextView textView3 = this.singleText;
        if ((textView3 != null && textView3.getVisibility() == 0) && (textView2 = this.singleText) != null && (jVar2 = this.channel) != null && (reporter2 = jVar2.getReporter()) != null && (mReporter2 = reporter2.getMReporter()) != null) {
            mReporter2.g(textView2, "em_zplan_makeup_dye_single", (r16 & 4) != 0 ? null : null, (r16 & 8) != 0, (r16 & 16) != 0 ? null : null, (r16 & 32) != 0 ? false : false);
        }
        TextView textView4 = this.gradientText;
        if (!(textView4 != null && textView4.getVisibility() == 0) || (textView = this.gradientText) == null || (jVar = this.channel) == null || (reporter = jVar.getReporter()) == null || (mReporter = reporter.getMReporter()) == null) {
            return;
        }
        mReporter.g(textView, "em_zplan_makeup_dye_fade", (r16 & 4) != 0 ? null : null, (r16 & 8) != 0, (r16 & 16) != 0 ? null : null, (r16 & 32) != 0 ? false : false);
    }
}
