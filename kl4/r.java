package kl4;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.CompoundButton;
import androidx.exifinterface.media.ExifInterface;
import com.tencent.ecommerce.base.report.api.IECDtReport;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qqlive.room.multichat.report.IMultiAvChatReporter;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqlive.common.api.AegisLogger;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTConstants;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.richframework.thread.RFWThreadManager;
import com.tencent.widget.Switch;
import java.util.HashMap;
import java.util.Map;
import kl4.r;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ug4.a;

/* compiled from: P */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \"2\u00020\u00012\u00020\u0002:\u0001#B\u000f\u0012\u0006\u0010\u001f\u001a\u00020\u001e\u00a2\u0006\u0004\b \u0010!J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0005\u001a\u00020\u0003H\u0002JB\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\r\u001a\u00020\f2\u0014\b\u0002\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u000eH\u0002J\b\u0010\u0011\u001a\u00020\u0003H\u0002J\u0012\u0010\u0014\u001a\u00020\u00032\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0014J\u001a\u0010\u0019\u001a\u00020\u00032\b\u0010\u0016\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0018\u001a\u00020\u0017H\u0016R\u0016\u0010\u001d\u001a\u00020\u001a8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001c\u00a8\u0006$"}, d2 = {"Lkl4/r;", "Landroid/app/Dialog;", "Landroid/widget/CompoundButton$OnCheckedChangeListener;", "", "initView", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Landroid/view/View;", "view", "", DTConstants.TAG.ELEMENT, "Lcom/tencent/qqlive/module/videoreport/constants/ClickPolicy;", IECDtReport.ACTION_CLICK_POLICY, "Lcom/tencent/qqlive/module/videoreport/constants/ExposurePolicy;", "exposurePolicy", "", "businessParams", ExifInterface.LATITUDE_SOUTH, "U", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onCreate", "Landroid/widget/CompoundButton;", "buttonView", "", "isChecked", "onCheckedChanged", "Lcom/tencent/widget/Switch;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/widget/Switch;", "showFloatWindowInBackgroundSwitch", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "D", "a", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class r extends ReportDialog implements CompoundButton.OnCheckedChangeListener {

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: C, reason: from kotlin metadata */
    private Switch showFloatWindowInBackgroundSwitch;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\t\u0010\b\u00a8\u0006\f"}, d2 = {"Lkl4/r$a;", "", "Landroid/content/Context;", "context", "", "b", "", "BTN_BACKGROUND_COLOR", "Ljava/lang/String;", "TAG", "<init>", "()V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: kl4.r$a, reason: from kotlin metadata */
    /* loaded from: classes26.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void c(Context context) {
            Intrinsics.checkNotNullParameter(context, "$context");
            new r(context).show();
        }

        public final void b(@NotNull final Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            RFWThreadManager.getUIHandler().post(new Runnable() { // from class: kl4.q
                @Override // java.lang.Runnable
                public final void run() {
                    r.Companion.c(context);
                }
            });
        }

        Companion() {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public r(@NotNull Context context) {
        super(context, R.style.a0f);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final void Q() {
        View view;
        String str;
        Switch r06 = this.showFloatWindowInBackgroundSwitch;
        Switch r16 = null;
        if (r06 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("showFloatWindowInBackgroundSwitch");
            r06 = null;
        }
        r06.setChecked(ct3.a.e("qqlive_key_audience_show_float_window_in_background", false));
        View view2 = this.showFloatWindowInBackgroundSwitch;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("showFloatWindowInBackgroundSwitch");
            view = null;
        } else {
            view = view2;
        }
        ClickPolicy clickPolicy = ClickPolicy.REPORT_NONE;
        ExposurePolicy exposurePolicy = ExposurePolicy.REPORT_ALL;
        HashMap hashMap = new HashMap();
        Switch r07 = this.showFloatWindowInBackgroundSwitch;
        if (r07 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("showFloatWindowInBackgroundSwitch");
        } else {
            r16 = r07;
        }
        if (r16.isChecked()) {
            str = "open";
        } else {
            str = "close";
        }
        hashMap.put("qqlive_status", str);
        Unit unit = Unit.INSTANCE;
        S(view, "em_qqlive_setting_entrance", clickPolicy, exposurePolicy, hashMap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void R(boolean z16, r this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (z16 && !com.tencent.timi.game.utils.g.c(this$0.getContext())) {
            this$0.U();
        }
    }

    private final void S(View view, String element, ClickPolicy clickPolicy, ExposurePolicy exposurePolicy, Map<String, String> businessParams) {
        VideoReport.setElementId(view, element);
        VideoReport.setElementClickPolicy(view, clickPolicy);
        VideoReport.setElementExposePolicy(view, exposurePolicy);
        VideoReport.setElementParams(view, businessParams);
    }

    private final void U() {
        com.tencent.timi.game.utils.g.d(getContext(), new DialogInterface.OnClickListener() { // from class: kl4.n
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                r.W(dialogInterface, i3);
            }
        }, new DialogInterface.OnClickListener() { // from class: kl4.o
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                r.X(dialogInterface, i3);
            }
        }).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void W(DialogInterface dialogInterface, int i3) {
        dialogInterface.dismiss();
        com.tencent.timi.game.utils.g.g(BaseApplication.getContext());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void X(DialogInterface dialogInterface, int i3) {
        dialogInterface.dismiss();
    }

    private final void initView() {
        Switch r06 = this.showFloatWindowInBackgroundSwitch;
        Switch r16 = null;
        if (r06 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("showFloatWindowInBackgroundSwitch");
            r06 = null;
        }
        r06.setBackgroundColor(Color.parseColor("#FFFFFF"));
        Switch r07 = this.showFloatWindowInBackgroundSwitch;
        if (r07 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("showFloatWindowInBackgroundSwitch");
        } else {
            r16 = r07;
        }
        r16.setOnCheckedChangeListener(this);
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(@Nullable CompoundButton buttonView, final boolean isChecked) {
        String str;
        EventCollector.getInstance().onCompoundButtonCheckedBefore(buttonView, isChecked);
        AegisLogger.INSTANCE.i("Audience|QQLiveAudienceSettingDialog", "onCheckedChanged, isChecked:" + isChecked);
        ct3.a.o("qqlive_key_audience_show_float_window_in_background", isChecked);
        HashMap hashMap = new HashMap();
        if (!isChecked) {
            str = "open";
        } else {
            str = "close";
        }
        hashMap.put("qqlive_status", str);
        Unit unit = Unit.INSTANCE;
        VideoReport.reportEvent("clck", buttonView, hashMap);
        RFWThreadManager.getUIHandler().post(new Runnable() { // from class: kl4.p
            @Override // java.lang.Runnable
            public final void run() {
                r.R(isChecked, this);
            }
        });
        EventCollector.getInstance().onCompoundButtonChecked(buttonView, isChecked);
    }

    @Override // android.app.Dialog
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(1);
        setCanceledOnTouchOutside(true);
        setContentView(R.layout.h9v);
        View findViewById = findViewById(R.id.f635733w);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.qqlive\u2026oat_window_in_background)");
        this.showFloatWindowInBackgroundSwitch = (Switch) findViewById;
        Window window = getWindow();
        if (window != null) {
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.gravity = 80;
            attributes.width = -1;
            attributes.height = -2;
            window.setAttributes(attributes);
        }
        mm4.a b16 = mm4.b.b(ug4.a.class);
        Intrinsics.checkNotNullExpressionValue(b16, "getService(ILiveReportService::class.java)");
        a.C11346a.c((ug4.a) b16, this, IMultiAvChatReporter.PageId.AUDIENCE_PAGE_ID, null, 4, null);
        initView();
        Q();
    }
}
