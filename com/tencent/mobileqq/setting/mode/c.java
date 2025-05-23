package com.tencent.mobileqq.setting.mode;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import androidx.fragment.app.FragmentActivity;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.ElderModeFragment;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.studymode.JumpKidModeMgr;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0016\u001a\u00020\u0011\u00a2\u0006\u0004\bA\u0010BJ\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0002J\u0010\u0010\t\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007J\u000e\u0010\u000b\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u0002J\u0016\u0010\f\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002J \u0010\u000e\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u0002H\u0004J\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fR\u0017\u0010\u0016\u001a\u00020\u00118\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0019\u001a\u00020\u00028\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R$\u0010 \u001a\u0004\u0018\u00010\u001a8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001a\u0010%\u001a\u00020!8\u0006X\u0086D\u00a2\u0006\f\n\u0004\b\u000b\u0010\"\u001a\u0004\b#\u0010$R\u001a\u0010'\u001a\u00020!8\u0006X\u0086D\u00a2\u0006\f\n\u0004\b\u000e\u0010\"\u001a\u0004\b&\u0010$R\u001a\u0010)\u001a\u00020!8\u0006X\u0086D\u00a2\u0006\f\n\u0004\b\u0006\u0010\"\u001a\u0004\b(\u0010$R\u001a\u0010+\u001a\u00020!8\u0006X\u0086D\u00a2\u0006\f\n\u0004\b\t\u0010\"\u001a\u0004\b*\u0010$R\u001a\u0010-\u001a\u00020!8\u0006X\u0086D\u00a2\u0006\f\n\u0004\b\u001e\u0010\"\u001a\u0004\b,\u0010$R\u001a\u0010/\u001a\u00020!8\u0006X\u0086D\u00a2\u0006\f\n\u0004\b\f\u0010\"\u001a\u0004\b.\u0010$R\u001a\u00102\u001a\u00020!8\u0006X\u0086D\u00a2\u0006\f\n\u0004\b0\u0010\"\u001a\u0004\b1\u0010$R\u001a\u00105\u001a\u00020!8\u0006X\u0086D\u00a2\u0006\f\n\u0004\b3\u0010\"\u001a\u0004\b4\u0010$R\u001a\u00108\u001a\u00020!8\u0006X\u0086D\u00a2\u0006\f\n\u0004\b6\u0010\"\u001a\u0004\b7\u0010$R$\u0010@\u001a\u0004\u0018\u0001098\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b:\u0010;\u001a\u0004\b<\u0010=\"\u0004\b>\u0010?\u00a8\u0006C"}, d2 = {"Lcom/tencent/mobileqq/setting/mode/c;", "", "", "oldType", "targetType", "", "f", "Landroidx/fragment/app/FragmentActivity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "g", "targetMode", "d", "i", "src", "e", "Lcom/tencent/mobileqq/app/QQAppInterface;", "c", "Landroid/content/Context;", "a", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "context", "b", "I", "mFrom", "Lcom/tencent/mobileqq/setting/mode/d;", "Lcom/tencent/mobileqq/setting/mode/d;", "getModeSwitchImpl", "()Lcom/tencent/mobileqq/setting/mode/d;", tl.h.F, "(Lcom/tencent/mobileqq/setting/mode/d;)V", "modeSwitchImpl", "", "Ljava/lang/String;", "getTAG", "()Ljava/lang/String;", "TAG", "getDEFAULT_MODE_EXPOSURE_ACTION", "DEFAULT_MODE_EXPOSURE_ACTION", "getDEFAULT_MODE_CLICK_ACTION", "DEFAULT_MODE_CLICK_ACTION", "getSIMPLE_MODE_EXPOSURE_ACTION", "SIMPLE_MODE_EXPOSURE_ACTION", "getSIMPLE_MODE_CLICK_ACTION", "SIMPLE_MODE_CLICK_ACTION", "getSTUDY_MODE_EXPOSURE_ACTION", "STUDY_MODE_EXPOSURE_ACTION", "j", "getSTUDY_MODE_CLICK_ACTION", "STUDY_MODE_CLICK_ACTION", "k", "getSTUDY_MODE_ADVANCE_CLICK_ACTION", "STUDY_MODE_ADVANCE_CLICK_ACTION", "l", "getSIMPLE_MODE_COLORFUL_ITEM_CLICK", "SIMPLE_MODE_COLORFUL_ITEM_CLICK", "Landroid/app/Dialog;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/app/Dialog;", "getMFontDialog", "()Landroid/app/Dialog;", "setMFontDialog", "(Landroid/app/Dialog;)V", "mFontDialog", "<init>", "(Landroid/content/Context;)V", "qq_setting_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final Context context;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final int mFrom;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private d modeSwitchImpl;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final String TAG;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final String DEFAULT_MODE_EXPOSURE_ACTION;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final String DEFAULT_MODE_CLICK_ACTION;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private final String SIMPLE_MODE_EXPOSURE_ACTION;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final String SIMPLE_MODE_CLICK_ACTION;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final String STUDY_MODE_EXPOSURE_ACTION;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    private final String STUDY_MODE_CLICK_ACTION;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    private final String STUDY_MODE_ADVANCE_CLICK_ACTION;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    private final String SIMPLE_MODE_COLORFUL_ITEM_CLICK;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private Dialog mFontDialog;

    public c(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
        this.mFrom = 1;
        this.TAG = "ElderModeChoiceHandler";
        this.DEFAULT_MODE_EXPOSURE_ACTION = "0X800B807";
        this.DEFAULT_MODE_CLICK_ACTION = "0X800B86B";
        this.SIMPLE_MODE_EXPOSURE_ACTION = "0X800B808";
        this.SIMPLE_MODE_CLICK_ACTION = "0X800B86C";
        this.STUDY_MODE_EXPOSURE_ACTION = "0X800B809";
        this.STUDY_MODE_CLICK_ACTION = "0X800B86D";
        this.STUDY_MODE_ADVANCE_CLICK_ACTION = "0X800BD9C";
        this.SIMPLE_MODE_COLORFUL_ITEM_CLICK = "0X800BF86";
    }

    private final void f(int oldType, int targetType) {
        Context context = this.context;
        Intrinsics.checkNotNull(context, "null cannot be cast to non-null type com.tencent.mobileqq.app.QBaseActivity");
        QBaseActivity qBaseActivity = (QBaseActivity) context;
        if (targetType == 2) {
            JumpKidModeMgr.b().i(targetType, oldType, qBaseActivity, 2, this.mFrom == 1 ? 1 : 2, false);
            return;
        }
        if (oldType == 2) {
            e(targetType, oldType, 2);
            return;
        }
        d dVar = this.modeSwitchImpl;
        if (dVar != null) {
            dVar.o6(oldType, targetType);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j(c this$0, int i3, int i16, DialogInterface dialogInterface, int i17) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Dialog dialog = this$0.mFontDialog;
        if (dialog != null) {
            dialog.dismiss();
        }
        this$0.f(i3, i16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k(c this$0, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Dialog dialog = this$0.mFontDialog;
        if (dialog != null) {
            dialog.dismiss();
        }
    }

    public final QQAppInterface c() {
        AppRuntime waitAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime();
        Intrinsics.checkNotNullExpressionValue(waitAppRuntime, "sMobileQQ.waitAppRuntime()");
        if (waitAppRuntime instanceof QQAppInterface) {
            return (QQAppInterface) waitAppRuntime;
        }
        return null;
    }

    protected final void e(int targetType, int oldType, int src) {
        Context context = this.context;
        Intrinsics.checkNotNull(context, "null cannot be cast to non-null type com.tencent.mobileqq.app.QBaseActivity");
        if (JumpKidModeMgr.b().f(targetType, oldType, c(), (QBaseActivity) context, src)) {
            return;
        }
        QLog.i(this.TAG, 1, "handleChangeKidModeSwitch failure targetType : " + targetType + ", oldType : " + oldType);
    }

    public final void h(d dVar) {
        this.modeSwitchImpl = dVar;
    }

    public final void i(final int targetType, final int oldType) {
        Dialog dialog = this.mFontDialog;
        if (dialog != null) {
            boolean z16 = false;
            if (dialog != null && dialog.isShowing()) {
                z16 = true;
            }
            if (z16) {
                return;
            }
        }
        Context context = this.context;
        Intrinsics.checkNotNull(context, "null cannot be cast to non-null type com.tencent.mobileqq.app.QBaseActivity");
        QBaseActivity qBaseActivity = (QBaseActivity) context;
        QQCustomDialog createCustomDialog = DialogUtil.createCustomDialog(qBaseActivity, 0, qBaseActivity.getResources().getString(R.string.bbh), qBaseActivity.getResources().getString(R.string.bbf), R.string.bbe, R.string.bbg, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.setting.mode.a
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                c.j(c.this, oldType, targetType, dialogInterface, i3);
            }
        }, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.setting.mode.b
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                c.k(c.this, dialogInterface, i3);
            }
        });
        this.mFontDialog = createCustomDialog;
        if (createCustomDialog != null) {
            createCustomDialog.show();
        }
    }

    public final void d(int targetMode) {
        i(targetMode, 3);
    }

    public final void g(FragmentActivity activity) {
        ElderModeFragment.Dh(activity, 3);
    }
}
