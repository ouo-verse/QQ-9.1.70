package com.tencent.qqnt.pluspanel.processor;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.pluspanel.data.msg.PlusPanelEvent;
import com.tencent.qqnt.pluspanel.processor.util.GroupVideoEntrance;
import com.tencent.widget.ActionSheet;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u0007\u00a2\u0006\u0004\b\u0013\u0010\u0014J \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J \u0010\u000e\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0002J \u0010\u000f\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0002J\u0018\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/qqnt/pluspanel/processor/GroupPublicClassOnClickProcessor;", "Lcom/tencent/qqnt/pluspanel/processor/GroupVideoChatOnClickProcessor;", "", "uin", "Lcom/tencent/mobileqq/app/QQAppInterface;", "app", "Lcom/tencent/aio/api/runtime/a;", "context", "", "f", "Lcom/tencent/mobileqq/activity/aio/SessionInfo;", "sessionInfo", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, tl.h.F, "e", "Lcom/tencent/qqnt/pluspanel/data/a;", "data", "a", "<init>", "()V", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class GroupPublicClassOnClickProcessor extends GroupVideoChatOnClickProcessor {
    /* JADX INFO: Access modifiers changed from: private */
    public final void f(final long uin, final QQAppInterface app, final com.tencent.aio.api.runtime.a context) {
        final ActionSheet create = ActionSheet.create(context.c().requireActivity());
        Intrinsics.checkNotNullExpressionValue(create, "create(context.fragment.requireActivity())");
        create.addButton(R.string.w3k);
        create.addButton(R.string.w3l);
        create.addButton(R.string.cancel);
        create.setOnButtonClickListener(new ActionSheet.OnButtonClickListener() { // from class: com.tencent.qqnt.pluspanel.processor.i
            @Override // com.tencent.widget.ActionSheet.OnButtonClickListener
            public final void onClick(View view, int i3) {
                GroupPublicClassOnClickProcessor.g(GroupPublicClassOnClickProcessor.this, create, context, uin, app, view, i3);
            }
        });
        create.show();
        ReportController.o(app, "dc00898", "", "", "0X800ABC6", "0X800ABC6", 0, 0, "", "", "", "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(GroupPublicClassOnClickProcessor this$0, ActionSheet actionSheet, com.tencent.aio.api.runtime.a context, long j3, QQAppInterface app, View view, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(actionSheet, "$actionSheet");
        Intrinsics.checkNotNullParameter(context, "$context");
        Intrinsics.checkNotNullParameter(app, "$app");
        actionSheet.dismiss();
        FragmentActivity requireActivity = context.c().requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "context.fragment.requireActivity()");
        SessionInfo n3 = GroupVideoEntrance.f360542a.n(context, j3);
        if (i3 == 0) {
            this$0.h(app, n3, requireActivity);
        } else {
            if (i3 != 1) {
                return;
            }
            this$0.e(app, n3, requireActivity);
        }
    }

    @Override // com.tencent.qqnt.pluspanel.processor.GroupVideoChatOnClickProcessor, com.tencent.qqnt.pluspanel.logic.b
    public void a(com.tencent.qqnt.pluspanel.data.a data, final com.tencent.aio.api.runtime.a context) {
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(context, "context");
        context.e().h(PlusPanelEvent.UpdatePlusPanel.f360444d);
        com.tencent.qqnt.pluspanel.processor.util.a.f360544a.a(context, new Function2<Long, QQAppInterface, Unit>() { // from class: com.tencent.qqnt.pluspanel.processor.GroupPublicClassOnClickProcessor$onClick$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Long l3, QQAppInterface qQAppInterface) {
                invoke(l3.longValue(), qQAppInterface);
                return Unit.INSTANCE;
            }

            public final void invoke(long j3, QQAppInterface app) {
                Intrinsics.checkNotNullParameter(app, "app");
                GroupPublicClassOnClickProcessor.this.f(j3, app, context);
            }
        });
    }

    private final void e(QQAppInterface app, SessionInfo sessionInfo, Activity activity) {
        String str = "https://qun.qq.com/livework/index?gc=" + sessionInfo.f179557e + "&_wv=2";
        Intent intent = new Intent(activity, (Class<?>) QQBrowserActivity.class);
        intent.putExtra("url", str);
        if (QLog.isColorLevel()) {
            QLog.i("GroupPublicClassOnClickProcessor", 2, "showTroopCourseActionSheet replayUrl = " + str);
        }
        activity.startActivity(intent);
        ReportController.o(app, "dc00898", "", "", "0X800ABFD", "0X800ABFD", 0, 0, "", "", "", "");
    }

    private final void h(QQAppInterface app, SessionInfo sessionInfo, Activity activity) {
        try {
            b(app, sessionInfo, activity, true);
        } catch (Exception e16) {
            QLog.d("GroupPublicClassOnClickProcessor", 1, "showTroopCourseActionSheet handleTroopLiveOrTroopCourseClick Exception", e16);
        }
        ReportController.o(app, "dc00898", "", "", "0X800ABFC", "0X800ABFC", 0, 0, "", "", "", "");
    }
}
