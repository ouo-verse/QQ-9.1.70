package com.tencent.mobileqq.minorsmode.api;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.fragment.QIphoneTitleBarFragment;
import com.tencent.mobileqq.minorsmode.MinorsModeKnowType;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J'\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00032\b\u0010\u000b\u001a\u0004\u0018\u00010\fH&\u00a2\u0006\u0002\u0010\rJ \u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\n\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\fH&J'\u0010\u0012\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010\u0011\u001a\u0004\u0018\u00010\fH&\u00a2\u0006\u0002\u0010\u0015J \u0010\u0016\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0011\u001a\u00020\fH&J \u0010\u0019\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0011\u001a\u00020\fH&J'\u0010\u001a\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\u00182\b\u0010\u0011\u001a\u0004\u0018\u00010\fH&\u00a2\u0006\u0002\u0010\u001b\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/mobileqq/minorsmode/api/IMinorsModeApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "isStudyPwdVerifyFragment", "", "fragment", "Lcom/tencent/mobileqq/fragment/QIphoneTitleBarFragment;", "startKidModeAdvanceSettingFragment", "", "context", "Landroid/content/Context;", "showCompletedBtn", "src", "", "(Landroid/content/Context;ZLjava/lang/Integer;)V", "startKidModeAdvanceSettingFragmentForResult", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/app/Activity;", "requestCode", "startMinorsModeKnowFragment", "type", "Lcom/tencent/mobileqq/minorsmode/MinorsModeKnowType;", "(Landroid/content/Context;Lcom/tencent/mobileqq/minorsmode/MinorsModeKnowType;Ljava/lang/Integer;)V", "startStudyModeCloseFragmentForResult", "intent", "Landroid/content/Intent;", "startStudyModeOpenFragmentForResult", "startStudyPwdVerifyFragment", "(Landroid/content/Context;Landroid/content/Intent;Ljava/lang/Integer;)V", "base_proj_ext_api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@QAPI(process = {"all"})
/* loaded from: classes15.dex */
public interface IMinorsModeApi extends QRouteApi {
    boolean isStudyPwdVerifyFragment(@NotNull QIphoneTitleBarFragment fragment);

    void startKidModeAdvanceSettingFragment(@NotNull Context context, boolean showCompletedBtn, @Nullable Integer src);

    void startKidModeAdvanceSettingFragmentForResult(@NotNull Activity activity, boolean showCompletedBtn, int requestCode);

    void startMinorsModeKnowFragment(@NotNull Context context, @NotNull MinorsModeKnowType type, @Nullable Integer requestCode);

    void startStudyModeCloseFragmentForResult(@NotNull Activity activity, @NotNull Intent intent, int requestCode);

    void startStudyModeOpenFragmentForResult(@NotNull Activity activity, @NotNull Intent intent, int requestCode);

    void startStudyPwdVerifyFragment(@NotNull Context context, @NotNull Intent intent, @Nullable Integer requestCode);
}
