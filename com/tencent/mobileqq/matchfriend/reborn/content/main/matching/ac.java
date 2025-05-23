package com.tencent.mobileqq.matchfriend.reborn.content.main.matching;

import android.app.Activity;
import android.app.Dialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.qui.quibutton.QUIButton;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.FontSettingManager;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qui.QUIImmersiveHelper;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.widget.qus.QUSBaseHalfScreenFloatingView;
import com.tencent.mobileqq.widget.qus.QUSHalfScreenFloatingView;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0011\u0018\u0000 42\u00020\u0001:\u00015B\u0017\u0012\u0006\u0010\u0019\u001a\u00020\u0016\u0012\u0006\u0010\u001d\u001a\u00020\u001a\u00a2\u0006\u0004\b2\u00103J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0004H\u0002J\b\u0010\b\u001a\u00020\u0004H\u0002J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH\u0002J\"\u0010\u0010\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\r2\b\u0010\u000f\u001a\u0004\u0018\u00010\rH\u0002J\b\u0010\u0011\u001a\u00020\u0004H\u0002J\u0010\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0002H\u0002J\b\u0010\u0014\u001a\u00020\u0004H\u0016J\b\u0010\u0015\u001a\u00020\u0004H\u0016R\u0014\u0010\u0019\u001a\u00020\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0014\u0010\u001d\u001a\u00020\u001a8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010!\u001a\u00020\u001e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010#\u001a\u00020\u00028\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\"R\u0016\u0010$\u001a\u00020\u00028\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\"R\u0016\u0010(\u001a\u00020%8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b&\u0010'R\u0016\u0010+\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b)\u0010*R\u0016\u0010-\u001a\u00020\u00028\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b,\u0010\"R\u0016\u0010/\u001a\u00020\u00028\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b.\u0010\"R\u0016\u00101\u001a\u00020\u00028\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b0\u0010\"\u00a8\u00066"}, d2 = {"Lcom/tencent/mobileqq/matchfriend/reborn/content/main/matching/ac;", "Landroid/app/Dialog;", "Landroid/view/View;", "k", "", "p", "i", "r", "l", "", "gender", ReportConstant.COSTREPORT_PREFIX, "itemRoot", "", "text", "iconUrl", tl.h.F, QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "view", "t", "show", "dismiss", "Landroid/app/Activity;", "d", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Ly72/g;", "e", "Ly72/g;", "data", "Lcom/tencent/mobileqq/widget/qus/QUSHalfScreenFloatingView;", "f", "Lcom/tencent/mobileqq/widget/qus/QUSHalfScreenFloatingView;", "floatingView", "Landroid/view/View;", "containerView", "matchSettingContentView", "Landroid/widget/Button;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/widget/Button;", "confirmBtn", BdhLogUtil.LogTag.Tag_Conn, "I", "matchGender", "D", "matchDefaultView", "E", "matchManView", UserInfo.SEX_FEMALE, "matchWomanView", "<init>", "(Landroid/app/Activity;Ly72/g;)V", "G", "b", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class ac extends Dialog {

    /* renamed from: C, reason: from kotlin metadata */
    private int matchGender;

    /* renamed from: D, reason: from kotlin metadata */
    private View matchDefaultView;

    /* renamed from: E, reason: from kotlin metadata */
    private View matchManView;

    /* renamed from: F, reason: from kotlin metadata */
    private View matchWomanView;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final Activity activity;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final y72.g data;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private QUSHalfScreenFloatingView floatingView;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private View containerView;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private View matchSettingContentView;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private Button confirmBtn;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/matchfriend/reborn/content/main/matching/ac$a", "Lcom/tencent/mobileqq/widget/qus/e;", "Landroid/view/View;", "createContentView", "", "showMode", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes33.dex */
    public static final class a extends com.tencent.mobileqq.widget.qus.e {
        a() {
        }

        @Override // com.tencent.mobileqq.widget.qus.d
        /* renamed from: createContentView */
        public View getF57419d() {
            return ac.this.k();
        }

        @Override // com.tencent.mobileqq.widget.qus.e, com.tencent.mobileqq.widget.qus.d
        public int showMode() {
            return 1;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ac(Activity activity, y72.g data) {
        super(activity, R.style.f173448dl);
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(data, "data");
        this.activity = activity;
        this.data = data;
        this.floatingView = new QUSHalfScreenFloatingView(activity);
        q();
        setContentView(this.floatingView, new ViewGroup.LayoutParams(-1, -1));
        this.floatingView.setQUSDragFloatController(new a());
        this.floatingView.setIsHeightWrapContent(true);
        this.floatingView.setOnDismissListener(new QUSBaseHalfScreenFloatingView.l() { // from class: com.tencent.mobileqq.matchfriend.reborn.content.main.matching.ab
            @Override // com.tencent.mobileqq.widget.qus.QUSBaseHalfScreenFloatingView.l
            public final void onDismiss() {
                ac.f(ac.this);
            }
        });
        View findViewById = activity.findViewById(R.id.opc);
        if (findViewById != null) {
            VideoReport.setLogicParent(this.floatingView, findViewById);
        }
        y82.a.b().f(this.floatingView, "em_bas_screening_panel");
        t(this.floatingView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(ac this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.dismiss();
    }

    private final void i() {
        View view = this.matchSettingContentView;
        Button button = null;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("matchSettingContentView");
            view = null;
        }
        View findViewById = view.findViewById(R.id.ojd);
        ((QUIButton) findViewById).setBackgroundResource(com.tencent.mobileqq.matchfriend.reborn.utils.b.f245467a.b());
        Intrinsics.checkNotNullExpressionValue(findViewById, "matchSettingContentView.\u2026electorResId())\n        }");
        this.confirmBtn = (Button) findViewById;
        View findViewById2 = this.activity.findViewById(R.id.opc);
        if (findViewById2 != null) {
            Button button2 = this.confirmBtn;
            if (button2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("confirmBtn");
                button2 = null;
            }
            VideoReport.setLogicParent(button2, findViewById2);
        }
        y82.a b16 = y82.a.b();
        Button button3 = this.confirmBtn;
        if (button3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("confirmBtn");
            button3 = null;
        }
        b16.f(button3, "em_bas_filter_confirm");
        Button button4 = this.confirmBtn;
        if (button4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("confirmBtn");
        } else {
            button = button4;
        }
        button.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.matchfriend.reborn.content.main.matching.aa
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                ac.j(ac.this, view2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j(ac this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.r();
        this$0.floatingView.t();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final View k() {
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        View inflate = LayoutInflater.from(linearLayout.getContext()).inflate(R.layout.cwr, linearLayout);
        Intrinsics.checkNotNullExpressionValue(inflate, "from(context).inflate(R.\u2026ch_setting_content, this)");
        this.matchSettingContentView = inflate;
        l();
        p();
        i();
        this.containerView = linearLayout;
        return linearLayout;
    }

    private final void l() {
        View view = this.matchSettingContentView;
        View view2 = null;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("matchSettingContentView");
            view = null;
        }
        View findViewById = view.findViewById(R.id.ojv);
        Intrinsics.checkNotNullExpressionValue(findViewById, "this");
        h(findViewById, "\u5168\u90e8", "https://static-res.qq.com/static-res/avatar-test-NEW/shaixuan/quanbu.png");
        findViewById.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.matchfriend.reborn.content.main.matching.x
            @Override // android.view.View.OnClickListener
            public final void onClick(View view3) {
                ac.n(ac.this, view3);
            }
        });
        Intrinsics.checkNotNullExpressionValue(findViewById, "matchSettingContentView.\u2026)\n            }\n        }");
        this.matchDefaultView = findViewById;
        View view3 = this.matchSettingContentView;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("matchSettingContentView");
            view3 = null;
        }
        View findViewById2 = view3.findViewById(R.id.f163146ok0);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "this");
        h(findViewById2, "\u7537\u751f", "https://static-res.qq.com/static-res/avatar-test-NEW/shaixuan/nansheng.png");
        findViewById2.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.matchfriend.reborn.content.main.matching.y
            @Override // android.view.View.OnClickListener
            public final void onClick(View view4) {
                ac.o(ac.this, view4);
            }
        });
        Intrinsics.checkNotNullExpressionValue(findViewById2, "matchSettingContentView.\u2026)\n            }\n        }");
        this.matchManView = findViewById2;
        View view4 = this.matchSettingContentView;
        if (view4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("matchSettingContentView");
        } else {
            view2 = view4;
        }
        View findViewById3 = view2.findViewById(R.id.ojy);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "this");
        h(findViewById3, "\u5973\u751f", "https://static-res.qq.com/static-res/avatar-test-NEW/shaixuan/nvsheng.png");
        findViewById3.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.matchfriend.reborn.content.main.matching.z
            @Override // android.view.View.OnClickListener
            public final void onClick(View view5) {
                ac.m(ac.this, view5);
            }
        });
        Intrinsics.checkNotNullExpressionValue(findViewById3, "matchSettingContentView.\u2026)\n            }\n        }");
        this.matchWomanView = findViewById3;
        s(this.data.getMatchGender());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m(ac this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.s(2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n(ac this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.s(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o(ac this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.s(1);
    }

    private final void q() {
        Window window = getWindow();
        if (window == null) {
            return;
        }
        window.requestFeature(1);
        try {
            ImmersiveUtils.clearCoverForStatus(window, true);
        } catch (Exception e16) {
            QLog.e("QQStrangerMatchSettingDialog", 1, "clearCoverForStatus fail:" + e16.getMessage());
        }
    }

    private final void r() {
        Map<String, ?> mutableMapOf;
        ArrayList arrayList = new ArrayList();
        int size = arrayList.size();
        String str = "";
        for (int i3 = 0; i3 < size; i3++) {
            str = str + arrayList.get(i3);
            if (i3 < arrayList.size() - 1) {
                str = str + ",";
            }
        }
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("sex", Integer.valueOf(this.matchGender)), TuplesKt.to("kl_aim", str));
        y82.a b16 = y82.a.b();
        Button button = this.confirmBtn;
        if (button == null) {
            Intrinsics.throwUninitializedPropertyAccessException("confirmBtn");
            button = null;
        }
        b16.e(button, "em_bas_filter_confirm", mutableMapOf);
        y72.f.f449542a.f(new y72.g(this.matchGender, arrayList));
    }

    private final void s(int gender) {
        this.matchGender = gender;
        View view = this.matchDefaultView;
        View view2 = null;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("matchDefaultView");
            view = null;
        }
        view.setSelected(this.matchGender == 0);
        View view3 = this.matchManView;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("matchManView");
            view3 = null;
        }
        view3.setSelected(this.matchGender == 1);
        View view4 = this.matchWomanView;
        if (view4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("matchWomanView");
        } else {
            view2 = view4;
        }
        view2.setSelected(this.matchGender == 2);
    }

    private final void t(View view) {
        if (FontSettingManager.isFontSizeNormal()) {
            return;
        }
        FontSettingManager.resetViewSize2Normal(getContext(), view);
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        super.dismiss();
        QUIImmersiveHelper.u(getWindow(), false, true);
    }

    @Override // android.app.Dialog
    public void show() {
        super.show();
        QUIImmersiveHelper.u(getWindow(), false, true);
    }

    private final void h(View itemRoot, String text, String iconUrl) {
        View findViewById = itemRoot.findViewById(R.id.omg);
        if (findViewById != null) {
            findViewById.setBackgroundResource(QQTheme.isNowThemeIsNight() ? R.drawable.f8h : R.drawable.f8g);
        }
        TextView textView = (TextView) itemRoot.findViewById(R.id.omi);
        if (textView != null) {
            textView.setText(text);
        }
        if (iconUrl == null || iconUrl.length() == 0) {
            return;
        }
        int n3 = Utils.n(66.0f, getContext().getResources());
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        obtain.mRequestWidth = n3;
        obtain.mRequestHeight = n3;
        obtain.mLoadingDrawable = BaseImageUtil.getDefaultFaceDrawable();
        obtain.mFailedDrawable = BaseImageUtil.getDefaultFaceDrawable();
        URLDrawable drawable = URLDrawable.getDrawable(iconUrl, obtain);
        ImageView imageView = (ImageView) itemRoot.findViewById(R.id.omh);
        if (imageView != null) {
            imageView.setImageDrawable(drawable);
        }
    }

    private final void p() {
    }
}
