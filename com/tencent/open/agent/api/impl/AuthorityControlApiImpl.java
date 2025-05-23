package com.tencent.open.agent.api.impl;

import android.app.Activity;
import android.view.View;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.listitem.Group;
import com.tencent.mobileqq.widget.listitem.x;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.open.agent.AuthorityControlFragment;
import com.tencent.open.agent.api.IAuthorityControlApi;
import com.tencent.open.agent.api.impl.AuthorityControlApiImpl;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\b\u0010\u0007\u001a\u00020\bH\u0002\u00a8\u0006\t"}, d2 = {"Lcom/tencent/open/agent/api/impl/AuthorityControlApiImpl;", "Lcom/tencent/open/agent/api/IAuthorityControlApi;", "()V", "getSettingListGroup", "Lcom/tencent/mobileqq/widget/listitem/Group;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/app/Activity;", "reportClick", "", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes22.dex */
public final class AuthorityControlApiImpl implements IAuthorityControlApi {
    /* JADX INFO: Access modifiers changed from: private */
    public static final void getSettingListGroup$lambda$0(Activity activity, AuthorityControlApiImpl this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(activity, "$activity");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        AuthorityControlFragment.Ih(activity);
        this$0.reportClick();
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void reportClick() {
        ThreadManagerV2.excute(new Runnable() { // from class: dp3.b
            @Override // java.lang.Runnable
            public final void run() {
                AuthorityControlApiImpl.reportClick$lambda$1();
            }
        }, 16, null, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void reportClick$lambda$1() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            return;
        }
        ReportController.o(peekAppRuntime, "dc00898", "", "", "0X800B85D", "0X800B85D", 0, 0, "", "", "", "");
    }

    @Override // com.tencent.open.agent.api.IAuthorityControlApi
    @NotNull
    public Group getSettingListGroup(@NotNull final Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        String string = activity.getString(R.string.f170503t0);
        Intrinsics.checkNotNullExpressionValue(string, "activity.getString(R.str\u2026uthority_control_setting)");
        x xVar = new x(new x.b.d(string), new x.c.g("", false, false, 6, null));
        xVar.x(new View.OnClickListener() { // from class: dp3.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AuthorityControlApiImpl.getSettingListGroup$lambda$0(activity, this, view);
            }
        });
        return new Group("\u8d26\u53f7\u6388\u6743\u7b2c\u4e09\u65b9\u5e94\u7528", xVar);
    }
}
