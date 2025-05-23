package com.tencent.mobileqq.vas.pay.api.impl.view;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.aelight.camera.constants.AECameraConstants;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.minigame.publicaccount.hippy.MiniGamePAHippyBaseFragment;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.vas.VasToggle;
import com.tencent.mobileqq.vas.pay.api.impl.VasNativePayManagerImpl;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.lang.reflect.Method;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010L\u001a\u00020K\u00a2\u0006\u0004\bM\u0010NB\u001b\b\u0016\u0012\u0006\u0010L\u001a\u00020K\u0012\b\u0010P\u001a\u0004\u0018\u00010O\u00a2\u0006\u0004\bM\u0010QB#\b\u0016\u0012\u0006\u0010L\u001a\u00020K\u0012\b\u0010P\u001a\u0004\u0018\u00010O\u0012\u0006\u0010R\u001a\u00020\u0007\u00a2\u0006\u0004\bM\u0010SJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0002J\u0014\u0010\t\u001a\u00020\u0002*\u00020\u00062\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0010\u0010\f\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0018\u0010\u0010\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J\b\u0010\u0011\u001a\u00020\u0002H\u0002J\u0010\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0012H\u0002J\b\u0010\u0015\u001a\u00020\u0002H\u0002J\u000e\u0010\u0018\u001a\u00020\u00002\u0006\u0010\u0017\u001a\u00020\u0016J\u000e\u0010\u0019\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\nJ\u0016\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u000eJ\u0006\u0010\u001b\u001a\u00020\u0012J\u000e\u0010\u001d\u001a\u00020\u00022\u0006\u0010\u001c\u001a\u00020\u000eJ\u0006\u0010\u001e\u001a\u00020\u0007R\u0016\u0010!\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u0014\u0010$\u001a\u00020\u00128\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u0016\u0010'\u001a\u00020\u00018\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010+\u001a\u00020(8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b)\u0010*R\u0016\u0010/\u001a\u00020,8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b-\u0010.R\u0016\u00100\u001a\u00020(8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0011\u0010*R\u0016\u00103\u001a\u00020\u00068\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b1\u00102R\u0016\u00104\u001a\u00020(8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001d\u0010*R\u0016\u00108\u001a\u0002058\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b6\u00107R\u0016\u0010:\u001a\u00020(8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b9\u0010*R\u0016\u0010>\u001a\u00020;8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b<\u0010=R\u0016\u0010@\u001a\u00020;8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b?\u0010=R\u0016\u0010B\u001a\u00020\u00018\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bA\u0010&R\u0016\u0010F\u001a\u00020C8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bD\u0010ER\u0016\u0010H\u001a\u00020C8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bG\u0010ER\u0014\u0010J\u001a\u00020\u00078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bI\u0010A\u00a8\u0006T"}, d2 = {"Lcom/tencent/mobileqq/vas/pay/api/impl/view/CustomValueView;", "Landroid/widget/LinearLayout;", "", "u", "l", ReportConstant.COSTREPORT_PREFIX, "Landroid/widget/Button;", "", "input", "w", "Landroid/view/View$OnClickListener;", "clickListener", "t", "backKeyClickListener", "", MiniGamePAHippyBaseFragment.KEY_THEME, "p", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "", "value", "v", HippyTKDListViewAdapter.X, "Lcom/tencent/mobileqq/vas/pay/api/impl/view/a;", "listener", "B", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "setOnBackKeyClickListener", "o", "forceNightMode", "D", DomainData.DOMAIN_NAME, "d", "Z", "mIsNightMode", "e", "Ljava/lang/String;", "TAG", "f", "Landroid/widget/LinearLayout;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "Landroid/widget/TextView;", tl.h.F, "Landroid/widget/TextView;", "tvTitle", "Landroid/widget/EditText;", "i", "Landroid/widget/EditText;", "etValue", "tvPointOut", BdhLogUtil.LogTag.Tag_Conn, "Landroid/widget/Button;", "btnRecharge", "tvAgreement", "Landroid/widget/GridView;", "E", "Landroid/widget/GridView;", "gvDigitKeyboard", UserInfo.SEX_FEMALE, "tvNumZero", "Landroid/widget/ImageView;", "G", "Landroid/widget/ImageView;", "imgDeleteNum", "H", "imgBack", "I", "linNumKey", "Landroid/widget/RelativeLayout;", "J", "Landroid/widget/RelativeLayout;", "relDeleteButtonBg", "K", "relValue", "L", "maxPay", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "vas-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class CustomValueView extends LinearLayout {

    /* renamed from: C, reason: from kotlin metadata */
    private Button btnRecharge;

    /* renamed from: D, reason: from kotlin metadata */
    private TextView tvAgreement;

    /* renamed from: E, reason: from kotlin metadata */
    private GridView gvDigitKeyboard;

    /* renamed from: F, reason: from kotlin metadata */
    private TextView tvNumZero;

    /* renamed from: G, reason: from kotlin metadata */
    private ImageView imgDeleteNum;

    /* renamed from: H, reason: from kotlin metadata */
    private ImageView imgBack;

    /* renamed from: I, reason: from kotlin metadata */
    private LinearLayout linNumKey;

    /* renamed from: J, reason: from kotlin metadata */
    private RelativeLayout relDeleteButtonBg;

    /* renamed from: K, reason: from kotlin metadata */
    private RelativeLayout relValue;

    /* renamed from: L, reason: from kotlin metadata */
    private final int maxPay;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private boolean mIsNightMode;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String TAG;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private LinearLayout rootView;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private TextView tvTitle;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private EditText etValue;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private TextView tvPointOut;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/vas/pay/api/impl/view/CustomValueView$b", "Landroid/text/style/ClickableSpan;", "Landroid/view/View;", AECameraConstants.HOT_ENTRY_TYPE_WIDGET, "", NodeProps.ON_CLICK, "Landroid/text/TextPaint;", "ds", "updateDrawState", "vas-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes20.dex */
    public static final class b extends ClickableSpan {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ View.OnClickListener f310150d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ CustomValueView f310151e;

        b(View.OnClickListener onClickListener, CustomValueView customValueView) {
            this.f310150d = onClickListener;
            this.f310151e = customValueView;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(@NotNull View widget) {
            Intrinsics.checkNotNullParameter(widget, "widget");
            this.f310150d.onClick(widget);
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(@NotNull TextPaint ds5) {
            Intrinsics.checkNotNullParameter(ds5, "ds");
            ds5.setColor(this.f310151e.getContext().getResources().getColor(R.color.bgd));
            ds5.setUnderlineText(false);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Code restructure failed: missing block: B:3:0x0019, code lost:
    
        r2 = kotlin.text.StringsKt__StringNumberConversionsKt.toIntOrNull(r2);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public CustomValueView(@NotNull Context context) {
        super(context);
        Integer intOrNull;
        Intrinsics.checkNotNullParameter(context, "context");
        this.TAG = "CustomValueView";
        String stringData = VasToggle.RECHARGE_MAX_PAY_NUM.getStringData("500000");
        int intValue = (stringData == null || intOrNull == null) ? 500000 : intOrNull.intValue();
        this.maxPay = intValue;
        u();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void C(CustomValueView this$0, com.tencent.mobileqq.vas.pay.api.impl.view.a listener, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(listener, "$listener");
        EditText editText = this$0.etValue;
        EditText editText2 = null;
        if (editText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("etValue");
            editText = null;
        }
        if (TextUtils.isEmpty(editText.getText().toString())) {
            QQToast.makeText(this$0.getContext(), "\u8bf7\u8f93\u5165\u6709\u6548\u6570\u5b57", 0).show();
        } else {
            EditText editText3 = this$0.etValue;
            if (editText3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("etValue");
            } else {
                editText2 = editText3;
            }
            listener.onClick(Integer.parseInt(editText2.getText().toString()));
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void l() {
        View inflate = View.inflate(getContext(), R.layout.f168959hh2, this);
        Intrinsics.checkNotNull(inflate, "null cannot be cast to non-null type android.widget.LinearLayout");
        LinearLayout linearLayout = (LinearLayout) inflate;
        this.rootView = linearLayout;
        TextView textView = null;
        if (linearLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException(MosaicConstants$JsProperty.PROP_ROOT_VIEW);
            linearLayout = null;
        }
        View findViewById = linearLayout.findViewById(R.id.kbs);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.tv_title)");
        this.tvTitle = (TextView) findViewById;
        View findViewById2 = linearLayout.findViewById(R.id.uxn);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.et_value)");
        this.etValue = (EditText) findViewById2;
        View findViewById3 = linearLayout.findViewById(R.id.tg7);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.btn_recharge)");
        this.btnRecharge = (Button) findViewById3;
        View findViewById4 = linearLayout.findViewById(R.id.f1059067_);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(R.id.tv_agreement)");
        this.tvAgreement = (TextView) findViewById4;
        View findViewById5 = linearLayout.findViewById(R.id.x5e);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "findViewById(R.id.gv_digit_keyboard)");
        this.gvDigitKeyboard = (GridView) findViewById5;
        View findViewById6 = linearLayout.findViewById(R.id.f109676gg);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "findViewById(R.id.tv_number_zero)");
        this.tvNumZero = (TextView) findViewById6;
        View findViewById7 = linearLayout.findViewById(R.id.xkc);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "findViewById(R.id.img_num_delete)");
        this.imgDeleteNum = (ImageView) findViewById7;
        View findViewById8 = linearLayout.findViewById(R.id.f110056hh);
        Intrinsics.checkNotNullExpressionValue(findViewById8, "findViewById(R.id.tv_point_out)");
        this.tvPointOut = (TextView) findViewById8;
        View findViewById9 = linearLayout.findViewById(R.id.xj8);
        Intrinsics.checkNotNullExpressionValue(findViewById9, "findViewById(R.id.img_back)");
        this.imgBack = (ImageView) findViewById9;
        View findViewById10 = linearLayout.findViewById(R.id.yid);
        Intrinsics.checkNotNullExpressionValue(findViewById10, "findViewById(R.id.lin_num_key)");
        this.linNumKey = (LinearLayout) findViewById10;
        View findViewById11 = linearLayout.findViewById(R.id.f72613rb);
        Intrinsics.checkNotNullExpressionValue(findViewById11, "findViewById(R.id.rel_num_delete_bg)");
        this.relDeleteButtonBg = (RelativeLayout) findViewById11;
        View findViewById12 = linearLayout.findViewById(R.id.f72633rd);
        Intrinsics.checkNotNullExpressionValue(findViewById12, "findViewById(R.id.rel_value)");
        this.relValue = (RelativeLayout) findViewById12;
        TextView textView2 = this.tvPointOut;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvPointOut");
        } else {
            textView = textView2;
        }
        textView.setVisibility(4);
    }

    private final void m() {
        EditText editText = this.etValue;
        EditText editText2 = null;
        if (editText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("etValue");
            editText = null;
        }
        int selectionStart = editText.getSelectionStart();
        EditText editText3 = this.etValue;
        if (editText3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("etValue");
        } else {
            editText2 = editText3;
        }
        Editable text = editText2.getText();
        Intrinsics.checkNotNullExpressionValue(text, "etValue.text");
        if (selectionStart > 0) {
            text.delete(selectionStart - 1, selectionStart);
        }
    }

    private final void p(View.OnClickListener backKeyClickListener, boolean isNightMode) {
        x();
        AdapterView.OnItemClickListener onItemClickListener = new AdapterView.OnItemClickListener() { // from class: com.tencent.mobileqq.vas.pay.api.impl.view.b
            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView adapterView, View view, int i3, long j3) {
                CustomValueView.q(CustomValueView.this, adapterView, view, i3, j3);
            }
        };
        ImageView imageView = this.imgBack;
        GridView gridView = null;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("imgBack");
            imageView = null;
        }
        imageView.setOnClickListener(backKeyClickListener);
        GridView gridView2 = this.gvDigitKeyboard;
        if (gridView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("gvDigitKeyboard");
            gridView2 = null;
        }
        gridView2.setOnTouchListener(new View.OnTouchListener() { // from class: com.tencent.mobileqq.vas.pay.api.impl.view.c
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                boolean r16;
                r16 = CustomValueView.r(view, motionEvent);
                return r16;
            }
        });
        GridView gridView3 = this.gvDigitKeyboard;
        if (gridView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("gvDigitKeyboard");
        } else {
            gridView = gridView3;
        }
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        gridView.setAdapter((ListAdapter) new h(context, onItemClickListener, isNightMode));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q(CustomValueView this$0, AdapterView adapterView, View view, int i3, long j3) {
        EventCollector.getInstance().onItemClickBefore(adapterView, view, i3, j3);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.v(i.a(i3));
        EventCollector.getInstance().onItemClick(adapterView, view, i3, j3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean r(View view, MotionEvent motionEvent) {
        if (2 == motionEvent.getAction()) {
            return true;
        }
        return false;
    }

    private final void s() {
        EditText editText = this.etValue;
        EditText editText2 = null;
        if (editText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("etValue");
            editText = null;
        }
        editText.setHint("\u5355\u6b21\u6700\u9ad8\u5145\u503c" + this.maxPay + "\u4e2a");
        try {
            Method method = EditText.class.getMethod("setShowSoftInputOnFocus", Boolean.TYPE);
            method.setAccessible(true);
            EditText editText3 = this.etValue;
            if (editText3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("etValue");
                editText3 = null;
            }
            method.invoke(editText3, Boolean.FALSE);
        } catch (Exception e16) {
            QLog.e(this.TAG, 1, e16, new Object[0]);
        }
        EditText editText4 = this.etValue;
        if (editText4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("etValue");
        } else {
            editText2 = editText4;
        }
        editText2.addTextChangedListener(new a());
    }

    private final void t(View.OnClickListener clickListener) {
        TextView textView = this.tvAgreement;
        TextView textView2 = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvAgreement");
            textView = null;
        }
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(getContext().getString(R.string.zpv));
        spannableStringBuilder.setSpan(new b(clickListener, this), 18, 28, 18);
        TextView textView3 = this.tvAgreement;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvAgreement");
        } else {
            textView2 = textView3;
        }
        textView2.setText(spannableStringBuilder);
    }

    private final void u() {
        l();
        D(false);
        s();
    }

    private final void v(String value) {
        EditText editText = this.etValue;
        EditText editText2 = null;
        if (editText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("etValue");
            editText = null;
        }
        int selectionStart = editText.getSelectionStart();
        EditText editText3 = this.etValue;
        if (editText3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("etValue");
        } else {
            editText2 = editText3;
        }
        Editable text = editText2.getText();
        Intrinsics.checkNotNullExpressionValue(text, "etValue.text");
        text.insert(selectionStart, value);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void w(Button button, int i3) {
        boolean z16;
        if (i3 > this.maxPay) {
            return;
        }
        if (i3 > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        button.setClickable(z16);
        button.getContext().getResources().getString(R.string.zpw);
        Button button2 = null;
        if (!button.isClickable()) {
            if (this.mIsNightMode) {
                Button button3 = this.btnRecharge;
                if (button3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("btnRecharge");
                } else {
                    button2 = button3;
                }
                button2.setBackgroundResource(R.drawable.l_p);
                return;
            }
            Button button4 = this.btnRecharge;
            if (button4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("btnRecharge");
            } else {
                button2 = button4;
            }
            button2.setBackgroundResource(R.drawable.l_o);
            return;
        }
        Button button5 = this.btnRecharge;
        if (button5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("btnRecharge");
        } else {
            button2 = button5;
        }
        button2.setBackgroundResource(R.drawable.l_m);
    }

    private final void x() {
        TextView textView = this.tvNumZero;
        RelativeLayout relativeLayout = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvNumZero");
            textView = null;
        }
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.vas.pay.api.impl.view.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CustomValueView.y(CustomValueView.this, view);
            }
        });
        RelativeLayout relativeLayout2 = this.relDeleteButtonBg;
        if (relativeLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("relDeleteButtonBg");
        } else {
            relativeLayout = relativeLayout2;
        }
        relativeLayout.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.vas.pay.api.impl.view.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CustomValueView.z(CustomValueView.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void y(CustomValueView this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.v("0");
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void z(CustomValueView this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.m();
        EventCollector.getInstance().onViewClicked(view);
    }

    @NotNull
    public final CustomValueView A(@NotNull View.OnClickListener clickListener) {
        Intrinsics.checkNotNullParameter(clickListener, "clickListener");
        t(clickListener);
        return this;
    }

    @NotNull
    public final CustomValueView B(@NotNull final com.tencent.mobileqq.vas.pay.api.impl.view.a listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        Button button = this.btnRecharge;
        if (button == null) {
            Intrinsics.throwUninitializedPropertyAccessException("btnRecharge");
            button = null;
        }
        button.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.vas.pay.api.impl.view.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CustomValueView.C(CustomValueView.this, listener, view);
            }
        });
        return this;
    }

    public final void D(boolean forceNightMode) {
        boolean z16;
        LinearLayout linearLayout;
        if (!QQTheme.isNowThemeIsNight() && !forceNightMode) {
            z16 = false;
        } else {
            z16 = true;
        }
        this.mIsNightMode = z16;
        if (z16) {
            LinearLayout linearLayout2 = this.rootView;
            if (linearLayout2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(MosaicConstants$JsProperty.PROP_ROOT_VIEW);
                linearLayout2 = null;
            }
            linearLayout2.setBackgroundColor(Color.parseColor("#2B2B2B"));
            ImageView imageView = this.imgBack;
            if (imageView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("imgBack");
                imageView = null;
            }
            imageView.setImageResource(R.drawable.ln6);
            TextView textView = this.tvTitle;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tvTitle");
                textView = null;
            }
            textView.setTextColor(-1);
            EditText editText = this.etValue;
            if (editText == null) {
                Intrinsics.throwUninitializedPropertyAccessException("etValue");
                editText = null;
            }
            editText.setTextColor(-1);
            RelativeLayout relativeLayout = this.relValue;
            if (relativeLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException("relValue");
                relativeLayout = null;
            }
            relativeLayout.setBackgroundColor(Color.parseColor("#333333"));
            RelativeLayout relativeLayout2 = this.relDeleteButtonBg;
            if (relativeLayout2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("relDeleteButtonBg");
                relativeLayout2 = null;
            }
            relativeLayout2.setBackgroundResource(R.drawable.l_u);
            ImageView imageView2 = this.imgDeleteNum;
            if (imageView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("imgDeleteNum");
                imageView2 = null;
            }
            imageView2.setBackgroundResource(R.drawable.l_s);
            LinearLayout linearLayout3 = this.linNumKey;
            if (linearLayout3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("linNumKey");
                linearLayout3 = null;
            }
            linearLayout3.setBackgroundColor(Color.parseColor("#1E1E1E"));
            Button button = this.btnRecharge;
            if (button == null) {
                Intrinsics.throwUninitializedPropertyAccessException("btnRecharge");
                button = null;
            }
            button.setBackgroundResource(R.drawable.l_p);
            Button button2 = this.btnRecharge;
            if (button2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("btnRecharge");
                button2 = null;
            }
            button2.setTextColor(-1);
            TextView textView2 = this.tvPointOut;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tvPointOut");
                textView2 = null;
            }
            textView2.setBackgroundColor(Color.parseColor("#1E1E1E"));
            TextView textView3 = this.tvNumZero;
            if (textView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tvNumZero");
                textView3 = null;
            }
            textView3.setBackgroundResource(R.drawable.l_u);
            TextView textView4 = this.tvNumZero;
            if (textView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tvNumZero");
                textView4 = null;
            }
            textView4.setTextColor(-1);
            TextView textView5 = this.tvAgreement;
            if (textView5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tvAgreement");
                textView5 = null;
            }
            textView5.setBackgroundColor(Color.parseColor("#1E1E1E"));
        } else {
            LinearLayout linearLayout4 = this.rootView;
            if (linearLayout4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(MosaicConstants$JsProperty.PROP_ROOT_VIEW);
                linearLayout4 = null;
            }
            linearLayout4.setBackgroundColor(-1);
            RelativeLayout relativeLayout3 = this.relValue;
            if (relativeLayout3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("relValue");
                relativeLayout3 = null;
            }
            relativeLayout3.setBackgroundColor(-1);
            ImageView imageView3 = this.imgBack;
            if (imageView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("imgBack");
                imageView3 = null;
            }
            imageView3.setImageResource(R.drawable.ln5);
            TextView textView6 = this.tvTitle;
            if (textView6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tvTitle");
                textView6 = null;
            }
            textView6.setTextColor(-16777216);
            EditText editText2 = this.etValue;
            if (editText2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("etValue");
                editText2 = null;
            }
            editText2.setTextColor(-16777216);
            RelativeLayout relativeLayout4 = this.relDeleteButtonBg;
            if (relativeLayout4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("relDeleteButtonBg");
                relativeLayout4 = null;
            }
            relativeLayout4.setBackgroundResource(R.drawable.l_v);
            ImageView imageView4 = this.imgDeleteNum;
            if (imageView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("imgDeleteNum");
                imageView4 = null;
            }
            imageView4.setBackgroundResource(R.drawable.l_r);
            LinearLayout linearLayout5 = this.linNumKey;
            if (linearLayout5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("linNumKey");
                linearLayout5 = null;
            }
            linearLayout5.setBackgroundColor(Color.parseColor("#F5F5F5"));
            Button button3 = this.btnRecharge;
            if (button3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("btnRecharge");
                button3 = null;
            }
            button3.setBackgroundResource(R.drawable.l_o);
            Button button4 = this.btnRecharge;
            if (button4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("btnRecharge");
                button4 = null;
            }
            button4.setTextColor(-1);
            TextView textView7 = this.tvPointOut;
            if (textView7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tvPointOut");
                textView7 = null;
            }
            textView7.setBackgroundColor(Color.parseColor("#F5F5F5"));
            TextView textView8 = this.tvNumZero;
            if (textView8 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tvNumZero");
                textView8 = null;
            }
            textView8.setBackgroundResource(R.drawable.l_v);
            TextView textView9 = this.tvNumZero;
            if (textView9 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tvNumZero");
                textView9 = null;
            }
            textView9.setTextColor(-16777216);
            TextView textView10 = this.tvAgreement;
            if (textView10 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tvAgreement");
                textView10 = null;
            }
            textView10.setBackgroundColor(Color.parseColor("#F5F5F5"));
        }
        TextView textView11 = this.tvTitle;
        if (textView11 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvTitle");
            textView11 = null;
        }
        LinearLayout linearLayout6 = this.rootView;
        if (linearLayout6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(MosaicConstants$JsProperty.PROP_ROOT_VIEW);
            linearLayout6 = null;
        }
        textView11.setTypeface(Typeface.createFromAsset(linearLayout6.getResources().getAssets(), VasNativePayManagerImpl.DINALTERNATE_BOLD_FONT_PATH));
        LinearLayout linearLayout7 = this.rootView;
        if (linearLayout7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(MosaicConstants$JsProperty.PROP_ROOT_VIEW);
            linearLayout = null;
        } else {
            linearLayout = linearLayout7;
        }
        linearLayout.invalidate();
    }

    /* renamed from: n, reason: from getter */
    public final int getMaxPay() {
        return this.maxPay;
    }

    @NotNull
    public final String o() {
        EditText editText = this.etValue;
        if (editText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("etValue");
            editText = null;
        }
        return editText.getText().toString();
    }

    public final void setOnBackKeyClickListener(@NotNull View.OnClickListener listener, boolean isNightMode) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        p(listener, isNightMode);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Code restructure failed: missing block: B:3:0x0019, code lost:
    
        r2 = kotlin.text.StringsKt__StringNumberConversionsKt.toIntOrNull(r2);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public CustomValueView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Integer intOrNull;
        Intrinsics.checkNotNullParameter(context, "context");
        this.TAG = "CustomValueView";
        String stringData = VasToggle.RECHARGE_MAX_PAY_NUM.getStringData("500000");
        int intValue = (stringData == null || intOrNull == null) ? 500000 : intOrNull.intValue();
        this.maxPay = intValue;
        u();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Code restructure failed: missing block: B:3:0x0019, code lost:
    
        r2 = kotlin.text.StringsKt__StringNumberConversionsKt.toIntOrNull(r2);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public CustomValueView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Integer intOrNull;
        Intrinsics.checkNotNullParameter(context, "context");
        this.TAG = "CustomValueView";
        String stringData = VasToggle.RECHARGE_MAX_PAY_NUM.getStringData("500000");
        int intValue = (stringData == null || intOrNull == null) ? 500000 : intOrNull.intValue();
        this.maxPay = intValue;
        u();
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J*\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004H\u0016J*\u0010\u000b\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0004H\u0016J\u0012\u0010\r\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\fH\u0016\u00a8\u0006\u000e"}, d2 = {"com/tencent/mobileqq/vas/pay/api/impl/view/CustomValueView$a", "Landroid/text/TextWatcher;", "", ReportConstant.COSTREPORT_PREFIX, "", "start", "before", "count", "", "onTextChanged", "after", "beforeTextChanged", "Landroid/text/Editable;", "afterTextChanged", "vas-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes20.dex */
    public static final class a implements TextWatcher {
        a() {
        }

        /* JADX WARN: Code restructure failed: missing block: B:5:0x0009, code lost:
        
            r5 = kotlin.text.StringsKt__StringNumberConversionsKt.toIntOrNull(r5);
         */
        @Override // android.text.TextWatcher
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void afterTextChanged(@Nullable Editable s16) {
            int i3;
            boolean z16;
            Integer intOrNull;
            if (s16 != null && (r5 = s16.toString()) != null && intOrNull != null) {
                i3 = intOrNull.intValue();
            } else {
                i3 = 0;
            }
            if (i3 > CustomValueView.this.maxPay) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                QQToast.makeText(CustomValueView.this.getContext(), "\u5355\u6b21\u6700\u9ad8\u53ef\u5145\u503c" + CustomValueView.this.maxPay + "\u4e2a", 0).show();
                int length = String.valueOf(CustomValueView.this.maxPay).length();
                String valueOf = String.valueOf(CustomValueView.this.maxPay);
                EditText editText = CustomValueView.this.etValue;
                EditText editText2 = null;
                if (editText == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("etValue");
                    editText = null;
                }
                editText.setText(valueOf);
                EditText editText3 = CustomValueView.this.etValue;
                if (editText3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("etValue");
                } else {
                    editText2 = editText3;
                }
                editText2.setSelection(length);
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:15:0x007c  */
        /* JADX WARN: Removed duplicated region for block: B:19:0x0083  */
        /* JADX WARN: Removed duplicated region for block: B:20:0x0064  */
        /* JADX WARN: Removed duplicated region for block: B:6:0x0029  */
        @Override // android.text.TextWatcher
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onTextChanged(@Nullable CharSequence s16, int start, int before, int count) {
            int parseInt;
            Button button;
            if (!TextUtils.isEmpty(s16)) {
                try {
                    Intrinsics.checkNotNull(s16);
                    parseInt = Integer.parseInt(s16.toString());
                } catch (NumberFormatException e16) {
                    QLog.e(CustomValueView.this.TAG, 1, e16, new Object[0]);
                }
                Button button2 = null;
                if (parseInt <= 0) {
                    TextView textView = CustomValueView.this.tvPointOut;
                    if (textView == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("tvPointOut");
                        textView = null;
                    }
                    textView.setVisibility(0);
                    TextView textView2 = CustomValueView.this.tvPointOut;
                    if (textView2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("tvPointOut");
                        textView2 = null;
                    }
                    textView2.setText("\u9700\u652f\u4ed8" + (parseInt / 10.0f) + "\u5143");
                } else {
                    TextView textView3 = CustomValueView.this.tvPointOut;
                    if (textView3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("tvPointOut");
                        textView3 = null;
                    }
                    textView3.setVisibility(4);
                }
                CustomValueView customValueView = CustomValueView.this;
                button = customValueView.btnRecharge;
                if (button != null) {
                    Intrinsics.throwUninitializedPropertyAccessException("btnRecharge");
                } else {
                    button2 = button;
                }
                customValueView.w(button2, parseInt);
            }
            parseInt = 0;
            Button button22 = null;
            if (parseInt <= 0) {
            }
            CustomValueView customValueView2 = CustomValueView.this;
            button = customValueView2.btnRecharge;
            if (button != null) {
            }
            customValueView2.w(button22, parseInt);
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(@Nullable CharSequence s16, int start, int count, int after) {
        }
    }
}
