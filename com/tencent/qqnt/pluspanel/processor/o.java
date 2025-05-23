package com.tencent.qqnt.pluspanel.processor;

import android.content.Intent;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.tencent.aio.data.AIOSession;
import com.tencent.biz.map.MapUtils;
import com.tencent.biz.map.poi.PoiMapPartFragment;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.activity.aio.rebuild.PlusPanelUtils;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.PageParams;
import com.tencent.qqnt.pluspanel.data.msg.PlusPanelEvent;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import com.tencent.upload.network.session.cache.SessionDbHelper;
import com.tencent.util.QQToastUtil;
import com.tencent.widget.ActionSheet;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.manager.Manager;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\u0007\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J(\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0002J(\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\fH\u0002J \u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0018\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\bH\u0002J\u0018\u0010\u0019\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u0017H\u0016\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/qqnt/pluspanel/processor/o;", "Lcom/tencent/qqnt/pluspanel/logic/b;", "Lcom/tencent/mobileqq/app/QQAppInterface;", "app", "Lcom/tencent/aio/data/AIOSession;", SessionDbHelper.SESSION_ID, "", "d", "Landroidx/fragment/app/FragmentActivity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "", "curType", "", "curUid", "", "j", "curUin", "i", tl.h.F, "event", "g", "Lcom/tencent/qqnt/pluspanel/data/a;", "data", "Lcom/tencent/aio/api/runtime/a;", "context", "a", "<init>", "()V", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class o implements com.tencent.qqnt.pluspanel.logic.b {

    /* renamed from: a, reason: collision with root package name */
    private static final a f360535a = new a(null);

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/qqnt/pluspanel/processor/o$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    private static final class a {
        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        a() {
        }
    }

    private final boolean d(QQAppInterface app, AIOSession session) {
        Manager manager = app.getManager(QQManagerFactory.FRIENDS_MANAGER);
        Intrinsics.checkNotNull(manager, "null cannot be cast to non-null type com.tencent.mobileqq.app.FriendsManager");
        FriendsManager friendsManager = (FriendsManager) manager;
        String uinFromUid = ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUinFromUid(session.c().j());
        if (uinFromUid == null || uinFromUid.length() == 0) {
            QLog.e("LocationOnClickProcessor", 1, "PlusPanel require uin exception");
        }
        QLog.d("LocationOnClickProcessor", 1, "isOneWayFriend getUin " + uinFromUid);
        return session.c().e() == 1 && !friendsManager.c0(uinFromUid.toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(ActionSheet actionSheet, FragmentActivity activity, o this$0, AppRuntime app, AIOSession session, View view, int i3) {
        Intrinsics.checkNotNullParameter(activity, "$activity");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(session, "$session");
        if (i3 == 0) {
            com.tencent.biz.map.a.c(actionSheet.getItemViewById(0).titleTv, "em_location_actionsheet_send");
            if (MapUtils.d(activity) <= 0) {
                QQToastUtil.showQQToastInUiThread(1, activity.getString(R.string.f171143iv2));
            } else {
                QPublicFragmentActivity.startForResult(activity, new Intent(), (Class<? extends QPublicBaseFragment>) PoiMapPartFragment.class, 18);
            }
        } else if (i3 == 1) {
            com.tencent.biz.map.a.c(actionSheet.getItemViewById(1).titleTv, "em_location_actionsheet_share");
            Intrinsics.checkNotNullExpressionValue(app, "app");
            this$0.j((QQAppInterface) app, activity, session.c().e(), session.c().j());
        }
        actionSheet.superDismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(o this$0, AppRuntime app, FragmentActivity activity, AIOSession session, ActionSheet actionSheet, View view, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(activity, "$activity");
        Intrinsics.checkNotNullParameter(session, "$session");
        if (i3 == 0) {
            Intrinsics.checkNotNullExpressionValue(app, "app");
            this$0.h((QQAppInterface) app, activity, session.c().e());
        } else if (i3 == 1) {
            Intrinsics.checkNotNullExpressionValue(app, "app");
            this$0.j((QQAppInterface) app, activity, session.c().e(), session.c().j());
        }
        actionSheet.superDismiss();
    }

    private final void g(String event, FragmentActivity activity) {
        com.tencent.biz.map.c cVar = new com.tencent.biz.map.c(activity);
        cVar.b("pg_location_actionsheet", null);
        if (Intrinsics.areEqual("dt_pgin", event)) {
            cVar.f();
        }
    }

    private final void h(QQAppInterface app, FragmentActivity activity, int curType) {
        PlusPanelUtils.f(app, activity, curType);
        l61.a.b(app, "0X800407F", curType);
    }

    private final void i(QQAppInterface app, FragmentActivity activity, int curType, String curUin) {
        com.tencent.mobileqq.location.e.b(app).launchShareUi(activity, curType, curUin, 1);
        ReportController.o(null, "CliOper", "", "", "0X800A763", "0X800A763", 0, 0, "", "0", "0", "");
    }

    @Override // com.tencent.qqnt.pluspanel.logic.b
    public void a(com.tencent.qqnt.pluspanel.data.a data, com.tencent.aio.api.runtime.a context) {
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(context, "context");
        context.e().h(PlusPanelEvent.UpdatePlusPanel.f360444d);
        final AIOSession r16 = context.g().r();
        final FragmentActivity requireActivity = context.c().requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "context.fragment.requireActivity()");
        final AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (!(peekAppRuntime instanceof QQAppInterface)) {
            QLog.e("FavoriteOnClickProcessor", 1, "need QQAppinterface");
            return;
        }
        QQAppInterface qQAppInterface = (QQAppInterface) peekAppRuntime;
        if (!qQAppInterface.getCurrentUid().equals(r16.c().j()) && !d(qQAppInterface, r16)) {
            final ActionSheet create = ActionSheet.create(requireActivity);
            if (com.tencent.relation.common.config.toggle.c.F.g(true) && !b71.a.a(requireActivity)) {
                create.addButton(R.string.vqt, 0);
                create.addButton(R.string.vrm, 0);
                create.addCancelButton(R.string.cancel);
                create.setOnButtonClickListener(new ActionSheet.OnButtonClickListener() { // from class: com.tencent.qqnt.pluspanel.processor.m
                    @Override // com.tencent.widget.ActionSheet.OnButtonClickListener
                    public final void onClick(View view, int i3) {
                        o.e(ActionSheet.this, requireActivity, this, peekAppRuntime, r16, view, i3);
                    }
                });
            } else {
                create.addButton(R.string.vqt, 0);
                create.addButton(R.string.vrm, 0);
                create.addCancelButton(R.string.cancel);
                create.setOnButtonClickListener(new ActionSheet.OnButtonClickListener() { // from class: com.tencent.qqnt.pluspanel.processor.n
                    @Override // com.tencent.widget.ActionSheet.OnButtonClickListener
                    public final void onClick(View view, int i3) {
                        o.f(o.this, peekAppRuntime, requireActivity, r16, create, view, i3);
                    }
                });
            }
            com.tencent.biz.map.a.b(requireActivity, create.getActionContentView(), "pg_location_actionsheet", new PageParams((Map<String, ?>) null));
            try {
                create.show();
            } catch (Exception e16) {
                QLog.e("LocationOnClickProcessor", 1, "show invoked error: " + e16);
            }
            g("dt_pgin", requireActivity);
            com.tencent.biz.map.a.d(create.getItemViewById(0).titleTv, "em_location_actionsheet_send");
            com.tencent.biz.map.a.d(create.getItemViewById(1).titleTv, "em_location_actionsheet_share");
            return;
        }
        h(qQAppInterface, requireActivity, r16.c().e());
    }

    private final void j(QQAppInterface app, FragmentActivity activity, int curType, String curUid) {
        if (curType == 2) {
            i(app, activity, 1, curUid);
            return;
        }
        String uinFromUid = ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUinFromUid(curUid);
        if (uinFromUid == null || uinFromUid.length() == 0) {
            QLog.e("LocationOnClickProcessor", 1, "PlusPanel require uin exception");
        }
        i(app, activity, 0, uinFromUid.toString());
    }
}
