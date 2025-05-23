package com.tencent.qqnt.pluspanel.processor;

import android.app.Activity;
import androidx.fragment.app.FragmentActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qqnt.pluspanel.data.msg.PlusPanelEvent;
import com.tencent.qqnt.pluspanel.processor.util.GroupVideoEntrance;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0016\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J(\u0010\u0010\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000eH\u0004\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/qqnt/pluspanel/processor/GroupVideoChatOnClickProcessor;", "Lcom/tencent/qqnt/pluspanel/logic/b;", "Lcom/tencent/qqnt/pluspanel/data/a;", "data", "Lcom/tencent/aio/api/runtime/a;", "context", "", "a", "Lcom/tencent/mobileqq/app/QQAppInterface;", "app", "Lcom/tencent/mobileqq/activity/aio/SessionInfo;", "sessionInfo", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "", "fromPublicClassEntry", "b", "<init>", "()V", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public class GroupVideoChatOnClickProcessor implements com.tencent.qqnt.pluspanel.logic.b {
    @Override // com.tencent.qqnt.pluspanel.logic.b
    public void a(com.tencent.qqnt.pluspanel.data.a data, final com.tencent.aio.api.runtime.a context) {
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(context, "context");
        context.e().h(PlusPanelEvent.UpdatePlusPanel.f360444d);
        com.tencent.qqnt.pluspanel.processor.util.a.f360544a.a(context, new Function2<Long, QQAppInterface, Unit>() { // from class: com.tencent.qqnt.pluspanel.processor.GroupVideoChatOnClickProcessor$onClick$1
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
                GroupVideoChatOnClickProcessor groupVideoChatOnClickProcessor = GroupVideoChatOnClickProcessor.this;
                SessionInfo n3 = GroupVideoEntrance.f360542a.n(context, j3);
                FragmentActivity requireActivity = context.c().requireActivity();
                Intrinsics.checkNotNullExpressionValue(requireActivity, "context.fragment.requireActivity()");
                groupVideoChatOnClickProcessor.b(app, n3, requireActivity, false);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void b(QQAppInterface app, SessionInfo sessionInfo, Activity activity, boolean fromPublicClassEntry) {
        Intrinsics.checkNotNullParameter(app, "app");
        Intrinsics.checkNotNullParameter(sessionInfo, "sessionInfo");
        Intrinsics.checkNotNullParameter(activity, "activity");
        GroupVideoEntrance.f360542a.t(app, sessionInfo, activity, fromPublicClassEntry);
    }
}
