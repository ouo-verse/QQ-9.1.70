package com.tencent.mobileqq.nearbypro.part.guide;

import android.app.Activity;
import android.content.DialogInterface;
import android.view.View;
import androidx.lifecycle.LifecycleOwnerKt;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcoroutine.api.coroutine.CorountineFunKt;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.studymode.api.IStudyModeManager;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u00162\u00020\u0001:\u0001\u0017B\u0007\u00a2\u0006\u0004\b\u0014\u0010\u0015J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\u0012\u0010\t\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J\u0010\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nH\u0016R\u0016\u0010\u000f\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/nearbypro/part/guide/NearbyProStudyGuidePart;", "Lcom/tencent/mobileqq/nearbypro/part/e;", "", "K9", "", "J9", "L9", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "onPartDestroy", "f", "Z", "mIsStudyLimit", "Lcom/tencent/mobileqq/utils/QQCustomDialog;", tl.h.F, "Lcom/tencent/mobileqq/utils/QQCustomDialog;", "mStudyLimitDialog", "<init>", "()V", "i", "a", "qq_nearby_pro_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class NearbyProStudyGuidePart extends com.tencent.mobileqq.nearbypro.part.e {

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private boolean mIsStudyLimit;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private QQCustomDialog mStudyLimitDialog;

    private final void J9() {
        CorountineFunKt.e(LifecycleOwnerKt.getLifecycleScope(z9().c9()), "NearbyProStudyGuidePartcheckStudyLimit", Boolean.FALSE, null, null, new NearbyProStudyGuidePart$checkAgeLimit$1(this, null), 12, null);
    }

    private final boolean K9() {
        boolean studyModeSwitch = ((IStudyModeManager) QRoute.api(IStudyModeManager.class)).getStudyModeSwitch();
        this.mIsStudyLimit = studyModeSwitch;
        if (studyModeSwitch) {
            L9();
            broadcastMessage("is_study_limit", Boolean.valueOf(this.mIsStudyLimit));
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void L9() {
        QQCustomDialog qQCustomDialog;
        String str;
        String str2;
        String str3;
        String string;
        String string2;
        String string3;
        if (this.mStudyLimitDialog == null) {
            Activity activity = getActivity();
            if (activity == null || (string3 = activity.getString(R.string.f170562ld)) == null) {
                str = "";
            } else {
                str = string3;
            }
            Activity activity2 = getActivity();
            if (activity2 == null || (string2 = activity2.getString(R.string.f170552lc)) == null) {
                str2 = "";
            } else {
                str2 = string2;
            }
            Activity activity3 = getActivity();
            if (activity3 == null || (string = activity3.getString(R.string.f1380608j)) == null) {
                str3 = "";
            } else {
                str3 = string;
            }
            QQCustomDialog createCustomDialog = DialogUtil.createCustomDialog(getActivity(), 230, str, str2, str3, "", (DialogInterface.OnClickListener) null, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.nearbypro.part.guide.m
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i3) {
                    NearbyProStudyGuidePart.M9(dialogInterface, i3);
                }
            });
            createCustomDialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.tencent.mobileqq.nearbypro.part.guide.n
                @Override // android.content.DialogInterface.OnDismissListener
                public final void onDismiss(DialogInterface dialogInterface) {
                    NearbyProStudyGuidePart.N9(NearbyProStudyGuidePart.this, dialogInterface);
                }
            });
            this.mStudyLimitDialog = createCustomDialog;
        }
        QQCustomDialog qQCustomDialog2 = this.mStudyLimitDialog;
        boolean z16 = false;
        if (qQCustomDialog2 != null && qQCustomDialog2.isShowing()) {
            z16 = true;
        }
        if (!z16 && (qQCustomDialog = this.mStudyLimitDialog) != null) {
            qQCustomDialog.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void M9(DialogInterface dialogInterface, int i3) {
        if (dialogInterface != null) {
            dialogInterface.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void N9(NearbyProStudyGuidePart this$0, DialogInterface dialogInterface) {
        Activity activity;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Activity activity2 = this$0.getActivity();
        boolean z16 = false;
        if (activity2 != null && activity2.isFinishing()) {
            z16 = true;
        }
        if (!z16 && (activity = this$0.getActivity()) != null) {
            activity.finish();
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@Nullable View rootView) {
        super.onInitView(rootView);
        if (K9()) {
            return;
        }
        J9();
    }

    @Override // com.tencent.mobileqq.nearbypro.part.e, com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        super.onPartDestroy(activity);
        QQCustomDialog qQCustomDialog = this.mStudyLimitDialog;
        boolean z16 = false;
        if (qQCustomDialog != null && qQCustomDialog.isShowing()) {
            z16 = true;
        }
        if (z16) {
            QQCustomDialog qQCustomDialog2 = this.mStudyLimitDialog;
            Intrinsics.checkNotNull(qQCustomDialog2);
            qQCustomDialog2.dismiss();
        }
    }
}
