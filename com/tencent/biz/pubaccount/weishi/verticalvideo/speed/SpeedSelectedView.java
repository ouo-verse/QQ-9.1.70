package com.tencent.biz.pubaccount.weishi.verticalvideo.speed;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.biz.pubaccount.weishi.event.WSSpeedChangeEvent;
import com.tencent.biz.pubaccount.weishi.util.ah;
import com.tencent.biz.pubaccount.weishi.util.an;
import com.tencent.biz.pubaccount.weishi.verticalvideo.speed.SpeedSelectedView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import j10.a;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import tl.h;
import wz.b;

/* compiled from: P */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 '2\u00020\u0001:\u0001(B%\u0012\u0006\u0010$\u001a\u00020#\u0012\u0006\u0010\u0010\u001a\u00020\u000e\u0012\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00040\u0011\u00a2\u0006\u0004\b%\u0010&J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0004H\u0002J\u0018\u0010\f\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0010\u0010\r\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002R\u0014\u0010\u0010\u001a\u00020\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000fR\u001d\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00040\u00118\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0018\u001a\u00020\u00168\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0017R\u0016\u0010\u001c\u001a\u00020\u00198\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010\u001e\u001a\u00020\u00198\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001bR\u0016\u0010 \u001a\u00020\u00198\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001f\u0010\u001bR\u0016\u0010\"\u001a\u00020\u00198\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b!\u0010\u001b\u00a8\u0006)"}, d2 = {"Lcom/tencent/biz/pubaccount/weishi/verticalvideo/speed/SpeedSelectedView;", "Landroid/widget/FrameLayout;", "Landroid/view/View;", ParseCommon.CONTAINER, "", "c", "b", "f", "", "tip", "", "ratio", "e", "d", "Lj10/a;", "Lj10/a;", "param", "Lkotlin/Function0;", "Lkotlin/jvm/functions/Function0;", "getCallback", "()Lkotlin/jvm/functions/Function0;", "callback", "Landroid/widget/RadioGroup;", "Landroid/widget/RadioGroup;", "radioGroup", "Landroid/widget/RadioButton;", h.F, "Landroid/widget/RadioButton;", "radioBtnHalf", "i", "radioBtnNormal", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "radioBtnOneHalf", BdhLogUtil.LogTag.Tag_Conn, "radioBtnDouble", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;Lj10/a;Lkotlin/jvm/functions/Function0;)V", "D", "a", "qqweishi_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes32.dex */
public final class SpeedSelectedView extends FrameLayout {

    /* renamed from: C, reason: from kotlin metadata */
    private RadioButton radioBtnDouble;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final a param;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final Function0<Unit> callback;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private RadioGroup radioGroup;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private RadioButton radioBtnHalf;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private RadioButton radioBtnNormal;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private RadioButton radioBtnOneHalf;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SpeedSelectedView(Context context, a param, Function0<Unit> callback) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(param, "param");
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.param = param;
        this.callback = callback;
        View container = LayoutInflater.from(context).inflate(R.layout.d1k, (ViewGroup) this, true);
        Intrinsics.checkNotNullExpressionValue(container, "container");
        c(container);
        b();
    }

    private final void b() {
        float f16 = this.param.f409070h;
        RadioButton radioButton = null;
        if (f16 == 0.5f) {
            RadioButton radioButton2 = this.radioBtnHalf;
            if (radioButton2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("radioBtnHalf");
            } else {
                radioButton = radioButton2;
            }
            radioButton.setChecked(true);
        } else {
            if (f16 == 1.0f) {
                RadioButton radioButton3 = this.radioBtnNormal;
                if (radioButton3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("radioBtnNormal");
                } else {
                    radioButton = radioButton3;
                }
                radioButton.setChecked(true);
            } else {
                if (f16 == 1.5f) {
                    RadioButton radioButton4 = this.radioBtnOneHalf;
                    if (radioButton4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("radioBtnOneHalf");
                    } else {
                        radioButton = radioButton4;
                    }
                    radioButton.setChecked(true);
                } else {
                    if (f16 == 2.0f) {
                        RadioButton radioButton5 = this.radioBtnDouble;
                        if (radioButton5 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("radioBtnDouble");
                        } else {
                            radioButton = radioButton5;
                        }
                        radioButton.setChecked(true);
                    }
                }
            }
        }
        f();
    }

    private final void e(String tip, float ratio) {
        an anVar = an.f81707a;
        String string = getResources().getString(R.string.f169718x73, tip);
        Intrinsics.checkNotNullExpressionValue(string, "resources.getString(R.st\u2026ng.speed_change_tip, tip)");
        anVar.f(string);
        this.callback.invoke();
        b.b().a(new WSSpeedChangeEvent(ratio, this.param.f409075m));
        com.tencent.biz.pubaccount.weishi.verticalvideo.report.b.b(this.param, String.valueOf(ratio));
    }

    private final void f() {
        RadioGroup radioGroup = this.radioGroup;
        if (radioGroup == null) {
            Intrinsics.throwUninitializedPropertyAccessException("radioGroup");
            radioGroup = null;
        }
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() { // from class: u10.a
            @Override // android.widget.RadioGroup.OnCheckedChangeListener
            public final void onCheckedChanged(RadioGroup radioGroup2, int i3) {
                SpeedSelectedView.g(SpeedSelectedView.this, radioGroup2, i3);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(SpeedSelectedView this$0, RadioGroup radioGroup, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        RadioButton radioButton = null;
        switch (i3) {
            case R.id.p6a /* 1929773192 */:
                RadioButton radioButton2 = this$0.radioBtnDouble;
                if (radioButton2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("radioBtnDouble");
                } else {
                    radioButton = radioButton2;
                }
                this$0.e(radioButton.getText().toString(), 2.0f);
                return;
            case R.id.p6b /* 1929773193 */:
                RadioButton radioButton3 = this$0.radioBtnHalf;
                if (radioButton3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("radioBtnHalf");
                } else {
                    radioButton = radioButton3;
                }
                this$0.e(radioButton.getText().toString(), 0.5f);
                return;
            case R.id.p6c /* 1929773194 */:
            default:
                return;
            case R.id.p6d /* 1929773195 */:
                RadioButton radioButton4 = this$0.radioBtnNormal;
                if (radioButton4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("radioBtnNormal");
                } else {
                    radioButton = radioButton4;
                }
                this$0.e(radioButton.getText().toString(), 1.0f);
                return;
            case R.id.p6e /* 1929773196 */:
                RadioButton radioButton5 = this$0.radioBtnOneHalf;
                if (radioButton5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("radioBtnOneHalf");
                } else {
                    radioButton = radioButton5;
                }
                this$0.e(radioButton.getText().toString(), 1.5f);
                return;
        }
    }

    private final void d(View container) {
        int b16 = ah.b(16.0f);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, ah.b(58.0f));
        layoutParams.setMarginStart(b16);
        layoutParams.setMarginEnd(b16);
        layoutParams.bottomMargin = b16;
        container.setLayoutParams(layoutParams);
    }

    private final void c(View container) {
        View findViewById = container.findViewById(R.id.p6c);
        Intrinsics.checkNotNullExpressionValue(findViewById, "container.findViewById(R.id.speed_mode_container)");
        this.radioGroup = (RadioGroup) findViewById;
        View findViewById2 = container.findViewById(R.id.p6b);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "container.findViewById(R.id.speed_half)");
        this.radioBtnHalf = (RadioButton) findViewById2;
        View findViewById3 = container.findViewById(R.id.p6d);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "container.findViewById(R.id.speed_normal)");
        this.radioBtnNormal = (RadioButton) findViewById3;
        View findViewById4 = container.findViewById(R.id.p6e);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "container.findViewById(R.id.speed_one_half)");
        this.radioBtnOneHalf = (RadioButton) findViewById4;
        View findViewById5 = container.findViewById(R.id.p6a);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "container.findViewById(R.id.speed_double)");
        this.radioBtnDouble = (RadioButton) findViewById5;
        d(container);
        com.tencent.biz.pubaccount.weishi.verticalvideo.report.b.c(this.param);
    }
}
