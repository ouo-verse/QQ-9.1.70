package com.tencent.qqnt.pluspanel.processor;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.tencent.adelie.av.api.IAdelieAVActivityApi;
import com.tencent.biz.eqq.CrmUtils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.rebuild.PlusPanelUtils;
import com.tencent.mobileqq.app.LBSHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.cp;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qidian.QidianManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.pluspanel.data.msg.PlusPanelEvent;
import com.tencent.qqnt.robot.api.IRobotServiceApi;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import mqq.manager.Manager;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u0007\u00a2\u0006\u0004\b\u0013\u0010\u0014J \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0018\u0010\f\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J \u0010\u0012\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/qqnt/pluspanel/processor/AudioCallOnClickProcessor;", "Lcom/tencent/qqnt/pluspanel/logic/b;", "", "uin", "Lcom/tencent/mobileqq/app/QQAppInterface;", "app", "Lcom/tencent/aio/api/runtime/a;", "context", "", "f", "Lcom/tencent/qqnt/pluspanel/data/a;", "data", "a", "Landroid/content/Context;", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "", "content", "d", "<init>", "()V", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class AudioCallOnClickProcessor implements com.tencent.qqnt.pluspanel.logic.b {

    /* renamed from: a, reason: collision with root package name */
    private static final a f360461a = new a(null);

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/qqnt/pluspanel/processor/AudioCallOnClickProcessor$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    private static final class a {
        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        a() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void e(Ref.ObjectRef addFriendDialog, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(addFriendDialog, "$addFriendDialog");
        T t16 = addFriendDialog.element;
        if (t16 != 0) {
            Intrinsics.checkNotNull(t16);
            if (((Dialog) t16).isShowing()) {
                T t17 = addFriendDialog.element;
                Intrinsics.checkNotNull(t17);
                ((Dialog) t17).dismiss();
            }
        }
    }

    @Override // com.tencent.qqnt.pluspanel.logic.b
    public void a(com.tencent.qqnt.pluspanel.data.a data, final com.tencent.aio.api.runtime.a context) {
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(context, "context");
        context.e().h(PlusPanelEvent.UpdatePlusPanel.f360444d);
        com.tencent.qqnt.pluspanel.processor.util.a.f360544a.a(context, new Function2<Long, QQAppInterface, Unit>() { // from class: com.tencent.qqnt.pluspanel.processor.AudioCallOnClickProcessor$onClick$1
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
                AudioCallOnClickProcessor.this.f(j3, app, context);
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1, types: [T, android.app.Dialog] */
    public final void d(Context context, Activity activity, String content) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(activity, "activity");
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        ?? N2 = LBSHandler.N2(context, content, new DialogInterface.OnClickListener() { // from class: com.tencent.qqnt.pluspanel.processor.f
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                AudioCallOnClickProcessor.e(Ref.ObjectRef.this, dialogInterface, i3);
            }
        }, null);
        objectRef.element = N2;
        View findViewById = N2.findViewById(R.id.dialogRightBtn);
        Intrinsics.checkNotNull(findViewById, "null cannot be cast to non-null type android.widget.TextView");
        ((TextView) findViewById).setText(context.getString(R.string.f171151ok));
        T t16 = objectRef.element;
        if (t16 == 0 || ((Dialog) t16).isShowing() || activity.isFinishing()) {
            return;
        }
        View findViewById2 = ((Dialog) objectRef.element).findViewById(R.id.dialogText);
        Intrinsics.checkNotNull(findViewById2, "null cannot be cast to non-null type android.widget.TextView");
        ((TextView) findViewById2).setText(content);
        ((Dialog) objectRef.element).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0268  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x02bb  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x02bf  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void f(long uin, QQAppInterface app, com.tencent.aio.api.runtime.a context) {
        String str;
        SessionInfo sessionInfo;
        String str2;
        HashMap hashMap;
        int i3;
        boolean isRobotUin;
        FragmentActivity requireActivity = context.c().requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "context.fragment.requireActivity()");
        SessionInfo sessionInfo2 = new SessionInfo();
        sessionInfo2.f179557e = String.valueOf(uin);
        sessionInfo2.f179559f = String.valueOf(uin);
        sessionInfo2.f179555d = com.tencent.nt.adapter.session.c.c(context.g().r().c().e());
        String g16 = context.g().r().c().g();
        sessionInfo2.f179563i = g16;
        if (TextUtils.isEmpty(g16)) {
            String string = context.g().l().getString("nick_" + sessionInfo2.f179557e);
            sessionInfo2.f179563i = string;
            QLog.i("AudioCallOnClickProcessor", 1, "startAudioCall another way to get nick: " + string);
        }
        if (app.getAVNotifyCenter().g(requireActivity, 1, sessionInfo2.f179555d, sessionInfo2.f179557e)) {
            return;
        }
        int i16 = sessionInfo2.f179555d;
        if (i16 == 1) {
            cp.c.e(false);
            a71.a.a(app, requireActivity, sessionInfo2, 10, false, app.getCurrentUin(), "AIOQAVCheckPermission");
            com.tencent.qqnt.pluspanel.processor.util.a.f360544a.b(context, "AudioCallOnClickProcessor");
            return;
        }
        if (i16 == 1010 && !com.tencent.mobileqq.dating.f.a(app, sessionInfo2.f179557e)) {
            BaseApplication context2 = BaseApplication.getContext();
            Intrinsics.checkNotNullExpressionValue(context2, "getContext()");
            d(context2, requireActivity, BaseApplication.getContext().getString(R.string.cgl));
            ReportController.o(app, "CliOper", "", "", "0X80049C8", "0X80049C8", 0, 0, "", "", "", "");
            return;
        }
        int i17 = sessionInfo2.f179555d;
        if (i17 == 1001 || i17 == 10002) {
            str = "AudioCallOnClickProcessor";
            ReportController.o(app, "CliOper", "", "", "0X8005152", "0X8005152", 0, 0, "", "", "", "");
            if (!LBSHandler.D2(app, sessionInfo2.f179557e)) {
                BaseApplication context3 = BaseApplication.getContext();
                Intrinsics.checkNotNullExpressionValue(context3, "getContext()");
                d(context3, requireActivity, BaseApplication.getContext().getString(R.string.cgl));
                ReportController.o(app, "CliOper", "", "", "0X8005154", "0X8005154", 0, 0, "", "", "", "");
                if (sessionInfo2.f179555d == 1001) {
                    str2 = "0";
                } else {
                    str2 = "1";
                }
                ReportController.o(app, "dc00899", "grp_lbs", "", "c2c_tmp", "tip_annoy", 0, 0, str2, "0", "", "");
                return;
            }
            sessionInfo = sessionInfo2;
        } else {
            str = "AudioCallOnClickProcessor";
            sessionInfo = sessionInfo2;
        }
        HashMap hashMap2 = new HashMap();
        hashMap2.put("should_believe_only_audio_flag", "true");
        if (sessionInfo.f179555d == 1024) {
            Manager manager = app.getManager(QQManagerFactory.QIDIAN_MANAGER);
            Intrinsics.checkNotNull(manager, "null cannot be cast to non-null type com.tencent.qidian.QidianManager");
            if (((QidianManager) manager).B(sessionInfo.f179557e)) {
                PlusPanelUtils.h(app, requireActivity, sessionInfo, true, null, hashMap2);
                return;
            }
            if (CrmUtils.o(app, sessionInfo.f179557e, sessionInfo.f179555d)) {
                CrmUtils.y(app, requireActivity, sessionInfo, "IvrAIOBottomButtonEngineFalse");
                hashMap = hashMap2;
                ReportController.o(app, "CliOper", "", "", "0X8004651", "0X8004651", 0, 0, "", "", "", "");
            } else {
                hashMap = hashMap2;
                i3 = 1;
                QQToast.makeText(BaseApplication.getContext(), R.string.dg5, 1).show(BaseApplication.getContext().getResources().getDimensionPixelSize(R.dimen.title_bar_height));
                if (QLog.isColorLevel()) {
                    QLog.d("AIOAudioPanel", 2, "Don't support ivr");
                }
                isRobotUin = ((IRobotServiceApi) QRoute.api(IRobotServiceApi.class)).isRobotUin(String.valueOf(uin));
                if (isRobotUin) {
                    hashMap.put("from", "2");
                }
                String str3 = str;
                QLog.i(str3, i3, "startAudioCall uin:" + uin + " chatType:" + sessionInfo.f179555d + " nick:" + sessionInfo.f179563i + " isRobot=" + isRobotUin);
                ((IAdelieAVActivityApi) QRoute.api(IAdelieAVActivityApi.class)).setClickTime(System.currentTimeMillis());
                PlusPanelUtils.h(app, requireActivity, sessionInfo, true, !isRobotUin ? "AIO_Adelie_AV" : null, hashMap);
                com.tencent.qqnt.pluspanel.processor.util.a.f360544a.b(context, str3);
                l61.a.b(app, "0X800407B", sessionInfo.f179555d);
            }
        } else {
            hashMap = hashMap2;
        }
        i3 = 1;
        isRobotUin = ((IRobotServiceApi) QRoute.api(IRobotServiceApi.class)).isRobotUin(String.valueOf(uin));
        if (isRobotUin) {
        }
        String str32 = str;
        QLog.i(str32, i3, "startAudioCall uin:" + uin + " chatType:" + sessionInfo.f179555d + " nick:" + sessionInfo.f179563i + " isRobot=" + isRobotUin);
        ((IAdelieAVActivityApi) QRoute.api(IAdelieAVActivityApi.class)).setClickTime(System.currentTimeMillis());
        PlusPanelUtils.h(app, requireActivity, sessionInfo, true, !isRobotUin ? "AIO_Adelie_AV" : null, hashMap);
        com.tencent.qqnt.pluspanel.processor.util.a.f360544a.b(context, str32);
        l61.a.b(app, "0X800407B", sessionInfo.f179555d);
    }
}
