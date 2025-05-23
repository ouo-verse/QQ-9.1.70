package com.tencent.sqshow.zootopia.operation;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.FragmentManager;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.qui.quibutton.QUIButton;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.mobileqq.widget.dialog.AdvertiseDialogFragment;
import com.tencent.mobileqq.widget.dialog.AdvertiseDialogParams;
import com.tencent.mobileqq.zplan.scheme.ISchemeApi;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.sqshow.zootopia.card.report.ZplanViewReportHelper;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 82\u00020\u0001:\u00019B\u0015\u0012\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00040 \u00a2\u0006\u0004\b6\u00107J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0002J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bH\u0002J$\u0010\u000f\u001a\u001e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000bj\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r`\u000eH\u0002J\b\u0010\u0010\u001a\u00020\u0004H\u0002J\b\u0010\u0011\u001a\u00020\u0004H\u0002J\b\u0010\u0012\u001a\u00020\u0004H\u0002J\u0010\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u0013H\u0002J\u0010\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0016\u001a\u00020\fH\u0002J\u000e\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u0019J\u0010\u0010\u001d\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u001cH\u0016J\b\u0010\u001e\u001a\u00020\u0004H\u0016J\b\u0010\u001f\u001a\u00020\u0004H\u0016R\u001d\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00040 8\u0006\u00a2\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$R\u0018\u0010(\u001a\u0004\u0018\u00010\u001c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b&\u0010'R\u0018\u0010,\u001a\u0004\u0018\u00010)8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b*\u0010+R\u0018\u0010/\u001a\u0004\u0018\u00010\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b-\u0010.R\u0016\u0010\u001a\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b0\u00101R\u0014\u00105\u001a\u0002028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b3\u00104\u00a8\u0006:"}, d2 = {"Lcom/tencent/sqshow/zootopia/operation/ZPlanSilverGuideDialog;", "Lcom/tencent/mobileqq/widget/dialog/AdvertiseDialogFragment;", "Landroid/view/View;", "root", "", "initView", "view", "Eh", "Landroid/widget/TextView;", "textView", "Lh", "Ljava/util/HashMap;", "", "", "Lkotlin/collections/HashMap;", "Ih", "Fh", "Gh", "Hh", "Landroid/widget/ImageView;", "imageView", "Jh", "url", "Lcom/tencent/image/URLDrawable;", "Ah", "Lcom/tencent/sqshow/zootopia/operation/b;", "param", "Kh", "Landroid/view/ViewGroup;", "rh", "dismiss", "vh", "Lkotlin/Function0;", UserInfo.SEX_FEMALE, "Lkotlin/jvm/functions/Function0;", "getConfirmCallback", "()Lkotlin/jvm/functions/Function0;", "confirmCallback", "G", "Landroid/view/ViewGroup;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "Lcom/tencent/biz/qui/quibutton/QUIButton;", "H", "Lcom/tencent/biz/qui/quibutton/QUIButton;", "jumpButton", "I", "Lcom/tencent/image/URLDrawable;", "urlDrawable", "J", "Lcom/tencent/sqshow/zootopia/operation/b;", "Lcom/tencent/sqshow/zootopia/card/report/ZplanViewReportHelper;", "K", "Lcom/tencent/sqshow/zootopia/card/report/ZplanViewReportHelper;", "dtViewReporter", "<init>", "(Lkotlin/jvm/functions/Function0;)V", "L", "a", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class ZPlanSilverGuideDialog extends AdvertiseDialogFragment {

    /* renamed from: L, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: F, reason: from kotlin metadata */
    private final Function0<Unit> confirmCallback;

    /* renamed from: G, reason: from kotlin metadata */
    private ViewGroup rootView;

    /* renamed from: H, reason: from kotlin metadata */
    private QUIButton jumpButton;

    /* renamed from: I, reason: from kotlin metadata */
    private URLDrawable urlDrawable;

    /* renamed from: J, reason: from kotlin metadata */
    private SilverDialogParams param;

    /* renamed from: K, reason: from kotlin metadata */
    private final ZplanViewReportHelper dtViewReporter;

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\r\u0010\u000eJ$\u0010\t\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006R\u0014\u0010\u000b\u001a\u00020\n8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\f\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/sqshow/zootopia/operation/ZPlanSilverGuideDialog$a;", "", "Landroidx/fragment/app/FragmentManager;", "fragmentManager", "Lcom/tencent/sqshow/zootopia/operation/b;", "param", "Lkotlin/Function0;", "", "confirmCallback", "a", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.sqshow.zootopia.operation.ZPlanSilverGuideDialog$a, reason: from kotlin metadata */
    /* loaded from: classes34.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(FragmentManager fragmentManager, SilverDialogParams param, Function0<Unit> confirmCallback) {
            Intrinsics.checkNotNullParameter(fragmentManager, "fragmentManager");
            Intrinsics.checkNotNullParameter(param, "param");
            Intrinsics.checkNotNullParameter(confirmCallback, "confirmCallback");
            ZPlanSilverGuideDialog zPlanSilverGuideDialog = new ZPlanSilverGuideDialog(confirmCallback);
            zPlanSilverGuideDialog.Kh(param);
            QLog.i("ZPlanSilverGuideDialog", 1, "do show silverGuideDialog, param: " + param);
            zPlanSilverGuideDialog.show(fragmentManager, "ZPlanSilverGuideDialog");
        }

        Companion() {
        }
    }

    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u001c\u0010\b\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\u0012\u0010\t\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u001a\u0010\f\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0016\u00a8\u0006\r"}, d2 = {"com/tencent/sqshow/zootopia/operation/ZPlanSilverGuideDialog$b", "Lcom/tencent/image/URLDrawable$URLDrawableListener;", "Lcom/tencent/image/URLDrawable;", "drawable", "", "onLoadSuccessed", "", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_CAUSE, "onLoadFialed", "onLoadCanceled", "", "progress", "onLoadProgressed", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class b implements URLDrawable.URLDrawableListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ ImageView f372104d;

        b(ImageView imageView) {
            this.f372104d = imageView;
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadFialed(URLDrawable drawable, Throwable cause) {
            QLog.i("ZPlanSilverGuideDialog", 2, "setGuideImage onLoadFialed=" + cause);
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadProgressed(URLDrawable drawable, int progress) {
            QLog.i("ZPlanSilverGuideDialog", 2, "setGuideImage onLoadProgressed=" + progress);
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadSuccessed(URLDrawable drawable) {
            this.f372104d.setImageDrawable(drawable);
            QLog.i("ZPlanSilverGuideDialog", 2, "setGuideImage download success");
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadCanceled(URLDrawable drawable) {
            QLog.i("ZPlanSilverGuideDialog", 2, "setGuideImage onLoadCanceled");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ZPlanSilverGuideDialog(Function0<Unit> confirmCallback) {
        super(new AdvertiseDialogParams(40, 60, R.drawable.f159858h23));
        Intrinsics.checkNotNullParameter(confirmCallback, "confirmCallback");
        this.confirmCallback = confirmCallback;
        this.param = new SilverDialogParams(0, null, null, null, 15, null);
        this.dtViewReporter = new ZplanViewReportHelper();
    }

    private final URLDrawable Ah(String url) {
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        obtain.mLoadingDrawable = new ColorDrawable(0);
        obtain.mFailedDrawable = new ColorDrawable(0);
        URLDrawable drawable = URLDrawable.getDrawable(url, obtain);
        Intrinsics.checkNotNullExpressionValue(drawable, "getDrawable(url, option)");
        return drawable;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Bh(ZPlanSilverGuideDialog this$0, View it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(it, "it");
        this$0.Eh(it);
        this$0.dtViewReporter.e(it, "em_zplan_silver_coin_reminder_pop", this$0.Ih());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ch(ZPlanSilverGuideDialog this$0, View it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(it, "it");
        this$0.Eh(it);
        this$0.dtViewReporter.e(it, "em_zplan_silver_coin_reminder_pop", this$0.Ih());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Dh(ZPlanSilverGuideDialog this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.Gh();
    }

    private final void Eh(View view) {
        Hh();
        String a16 = this.param.a();
        if (a16 != null) {
            ISchemeApi iSchemeApi = (ISchemeApi) QRoute.api(ISchemeApi.class);
            Context context = view.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "view.context");
            iSchemeApi.launchScheme(context, a16);
        }
        dismiss();
    }

    private final void Fh() {
        VideoReport.setPageId(this.rootView, "pg_zplan_poster");
    }

    private final HashMap<String, Object> Ih() {
        HashMap<String, Object> hashMap = new HashMap<>();
        f fVar = f.f372119a;
        hashMap.put("zplan_silver_coin_balance", Integer.valueOf(fVar.b()));
        hashMap.put("zplan_gold_coin_balance", Integer.valueOf(fVar.a()));
        return hashMap;
    }

    private final void Jh(ImageView imageView) {
        QLog.i("ZPlanSilverGuideDialog", 2, "setGuideImage enter");
        String d16 = this.param.d();
        if (d16 == null || d16.length() == 0) {
            QLog.i("ZPlanSilverGuideDialog", 2, "setGuideImage url is Empty");
            return;
        }
        URLDrawable Ah = Ah(d16);
        this.urlDrawable = Ah;
        if (Ah == null) {
            return;
        }
        if (Ah.getStatus() == 1) {
            imageView.setImageDrawable(Ah);
            QLog.i("ZPlanSilverGuideDialog", 2, "setGuideImage cache success");
        } else {
            Ah.setURLDrawableListener(new b(imageView));
            Ah.startDownload();
        }
    }

    private final void Lh(TextView textView) {
        String f16 = this.param.f();
        if (f16 == null) {
            f16 = "";
        }
        String valueOf = String.valueOf(this.param.getSilver());
        String c16 = this.param.c();
        CharSequence charSequence = f16 + valueOf + (c16 != null ? c16 : "");
        try {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(charSequence);
            spannableStringBuilder.setSpan(new ForegroundColorSpan(ie0.a.f().g(requireContext(), R.color.qui_common_brand_standard, 1001)), f16.length(), f16.length() + valueOf.length(), 33);
            textView.setText(spannableStringBuilder);
        } catch (Exception unused) {
            textView.setText(charSequence);
        }
    }

    private final void initView(View root) {
        Fh();
        qh().setImageDrawable(ie0.a.f().o(requireContext(), R.drawable.qui_close_circle, R.color.qui_common_icon_white, 1001));
        qh().setContentDescription("\u5173\u95ed");
        ImageView imageView = (ImageView) root.findViewById(R.id.qsd);
        if (imageView != null) {
            Jh(imageView);
        }
        TextView textView = (TextView) root.findViewById(R.id.qlw);
        if (textView != null) {
            Lh(textView);
        }
        QUIButton qUIButton = (QUIButton) root.findViewById(R.id.psy);
        if (qUIButton != null) {
            String b16 = this.param.b();
            if (b16 == null) {
                b16 = "";
            }
            qUIButton.setText(b16);
        }
        this.jumpButton = qUIButton;
        if (qUIButton != null) {
            qUIButton.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.sqshow.zootopia.operation.c
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ZPlanSilverGuideDialog.Bh(ZPlanSilverGuideDialog.this, view);
                }
            });
        }
        ViewGroup viewGroup = this.rootView;
        if (viewGroup != null) {
            viewGroup.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.sqshow.zootopia.operation.d
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ZPlanSilverGuideDialog.Ch(ZPlanSilverGuideDialog.this, view);
                }
            });
        }
        root.post(new Runnable() { // from class: com.tencent.sqshow.zootopia.operation.e
            @Override // java.lang.Runnable
            public final void run() {
                ZPlanSilverGuideDialog.Dh(ZPlanSilverGuideDialog.this);
            }
        });
    }

    public final void Kh(SilverDialogParams param) {
        Intrinsics.checkNotNullParameter(param, "param");
        this.param = param;
    }

    @Override // androidx.fragment.app.DialogFragment
    public void dismiss() {
        URLDrawable uRLDrawable = this.urlDrawable;
        if (uRLDrawable != null) {
            uRLDrawable.setURLDrawableListener(null);
        }
        this.urlDrawable = null;
        this.confirmCallback.invoke();
        super.dismiss();
    }

    @Override // com.tencent.mobileqq.widget.dialog.AdvertiseDialogFragment
    public View rh(ViewGroup root) {
        Intrinsics.checkNotNullParameter(root, "root");
        this.rootView = root;
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.dff, root, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "from(context).inflate(R.\u2026uide_dialog, root, false)");
        initView(inflate);
        return inflate;
    }

    @Override // com.tencent.mobileqq.widget.dialog.AdvertiseDialogFragment
    public void vh() {
        this.dtViewReporter.e(qh(), "em_zplan_silver_coin_reminder_pop_close", Ih());
        Hh();
        super.vh();
    }

    private final void Gh() {
        QUIButton qUIButton = this.jumpButton;
        if (qUIButton != null) {
            this.dtViewReporter.g(qUIButton, "em_zplan_silver_coin_reminder_pop", (r16 & 4) != 0 ? null : Ih(), (r16 & 8) != 0, (r16 & 16) != 0 ? null : null, (r16 & 32) != 0 ? false : false);
        }
        this.dtViewReporter.g(qh(), "em_zplan_silver_coin_reminder_pop_close", (r16 & 4) != 0 ? null : Ih(), (r16 & 8) != 0, (r16 & 16) != 0 ? null : null, (r16 & 32) != 0 ? false : false);
    }

    private final void Hh() {
        QUIButton qUIButton = this.jumpButton;
        if (qUIButton != null) {
            ZplanViewReportHelper.j(this.dtViewReporter, qUIButton, "em_zplan_silver_coin_reminder_pop", Ih(), false, null, 16, null);
        }
        ZplanViewReportHelper.j(this.dtViewReporter, qh(), "em_zplan_silver_coin_reminder_pop_close", Ih(), false, null, 16, null);
    }
}
