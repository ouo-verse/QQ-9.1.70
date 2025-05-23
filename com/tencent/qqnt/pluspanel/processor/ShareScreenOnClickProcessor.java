package com.tencent.qqnt.pluspanel.processor;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.text.SpannableStringBuilder;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.tencent.av.ReqGroupVideo$ReqScreenShareAsk;
import com.tencent.av.ReqGroupVideo$RspScreenShareAsk;
import com.tencent.av.business.handler.MessageHandler;
import com.tencent.av.screenshare.ScreenShareQQCustomDialog;
import com.tencent.av.utils.af;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.rebuild.PlusPanelUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.utils.QQAudioHelper;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.cp;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.pluspanel.data.msg.PlusPanelEvent;
import com.tencent.widget.ActionSheet;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import mqq.util.LogUtil;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB\u0007\u00a2\u0006\u0004\b\u001b\u0010\u001cJ \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J(\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J(\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\u0011H\u0002J(\u0010\u0014\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J(\u0010\u0015\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J(\u0010\u0016\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0018\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\fH\u0002J\u0018\u0010\u001a\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/qqnt/pluspanel/processor/ShareScreenOnClickProcessor;", "Lcom/tencent/qqnt/pluspanel/logic/b;", "", "uin", "Lcom/tencent/mobileqq/app/QQAppInterface;", "app", "Lcom/tencent/aio/api/runtime/a;", "context", "", "u", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Lcom/tencent/mobileqq/activity/aio/SessionInfo;", "sessionInfo", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/av/screenshare/ScreenShareQQCustomDialog;", "screenShareDialog", "", "isFirstShow", "t", "r", "j", "i", ReportConstant.COSTREPORT_PREFIX, "Lcom/tencent/qqnt/pluspanel/data/a;", "data", "a", "<init>", "()V", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class ShareScreenOnClickProcessor implements com.tencent.qqnt.pluspanel.logic.b {

    /* renamed from: a, reason: collision with root package name */
    private static final a f360483a = new a(null);

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004\u00a8\u0006\b"}, d2 = {"Lcom/tencent/qqnt/pluspanel/processor/ShareScreenOnClickProcessor$a;", "", "", "SCREEN_SHARE_NOTICE_DIALOG_IS_SHOWN_KEY", "Ljava/lang/String;", "TAG", "<init>", "()V", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    private static final class a {
        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        a() {
        }
    }

    @Metadata(d1 = {"\u0000-\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001J0\u0010\r\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\nH\u0016\u00a8\u0006\u000e"}, d2 = {"com/tencent/qqnt/pluspanel/processor/ShareScreenOnClickProcessor$b", "Lcom/tencent/av/business/handler/MessageHandler$b;", "Lcom/tencent/av/ReqGroupVideo$ReqScreenShareAsk;", "Lcom/tencent/av/ReqGroupVideo$RspScreenShareAsk;", "", "seq", "", "isSuccess", "msgReq", "msgRsp", "", "data", "", "c", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class b extends MessageHandler.b<ReqGroupVideo$ReqScreenShareAsk, ReqGroupVideo$RspScreenShareAsk> {
        b() {
        }

        @Override // com.tencent.av.business.handler.MessageHandler.b
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public void a(long seq, boolean isSuccess, ReqGroupVideo$ReqScreenShareAsk msgReq, ReqGroupVideo$RspScreenShareAsk msgRsp, Object data) {
            Intrinsics.checkNotNullParameter(msgReq, "msgReq");
            Intrinsics.checkNotNullParameter(msgRsp, "msgRsp");
            Intrinsics.checkNotNullParameter(data, "data");
            QLog.d("ShareScreenOnClickProcessor", 1, "onSendMsgRsp RspScreenShareAsk errCode[" + MessageHandler.F2(msgRsp.result.get()) + "]");
        }
    }

    private final void i(Activity activity, QQAppInterface app, SessionInfo sessionInfo, com.tencent.aio.api.runtime.a context) {
        if (activity.isFinishing()) {
            return;
        }
        com.tencent.qqnt.pluspanel.processor.util.a.f360544a.b(context, "ShareScreenOnClickProcessor");
        HashMap hashMap = new HashMap();
        hashMap.put("should_believe_only_audio_flag", "true");
        PlusPanelUtils.h(app, activity, sessionInfo, true, "AIOShareScreen", hashMap);
    }

    private final void j(final Activity activity, final QQAppInterface app, final SessionInfo sessionInfo, final com.tencent.aio.api.runtime.a context) {
        if (activity.isFinishing()) {
            return;
        }
        final ActionSheet create = ActionSheet.create(activity);
        create.addButton(R.string.f224096i0, 0);
        if (com.tencent.av.utils.af.y()) {
            create.addButton(R.string.f224086hz, 0);
            create.addCancelButton(R.string.cancel);
            create.setOnButtonClickListener(new ActionSheet.OnButtonClickListener() { // from class: com.tencent.qqnt.pluspanel.processor.aa
                @Override // com.tencent.widget.ActionSheet.OnButtonClickListener
                public final void onClick(View view, int i3) {
                    ShareScreenOnClickProcessor.k(ShareScreenOnClickProcessor.this, activity, app, sessionInfo, context, create, view, i3);
                }
            });
            create.setOnBottomCancelListener(new View.OnClickListener() { // from class: com.tencent.qqnt.pluspanel.processor.ab
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ShareScreenOnClickProcessor.l(ActionSheet.this, view);
                }
            });
            create.show();
            return;
        }
        i(activity, app, sessionInfo, context);
        com.tencent.av.screenshare.c.b("0X800AD8E", 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k(ShareScreenOnClickProcessor this$0, Activity activity, QQAppInterface app, SessionInfo sessionInfo, com.tencent.aio.api.runtime.a context, ActionSheet actionSheet, View view, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(activity, "$activity");
        Intrinsics.checkNotNullParameter(app, "$app");
        Intrinsics.checkNotNullParameter(sessionInfo, "$sessionInfo");
        Intrinsics.checkNotNullParameter(context, "$context");
        if (i3 == 0) {
            this$0.i(activity, app, sessionInfo, context);
            com.tencent.av.screenshare.c.b("0X800AD8E", 1);
        } else if (i3 == 1) {
            this$0.s(app, sessionInfo);
            com.tencent.av.screenshare.c.b("0X800B89F", 1);
        }
        actionSheet.superDismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l(ActionSheet actionSheet, View view) {
        com.tencent.av.screenshare.c.b("0X800B8A0", 1);
        actionSheet.superDismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n(DialogInterface dialogInterface, int i3) {
        dialogInterface.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o(ShareScreenOnClickProcessor this$0, Activity activity, QQAppInterface app, SessionInfo sessionInfo, com.tencent.aio.api.runtime.a context, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(activity, "$activity");
        Intrinsics.checkNotNullParameter(app, "$app");
        Intrinsics.checkNotNullParameter(sessionInfo, "$sessionInfo");
        Intrinsics.checkNotNullParameter(context, "$context");
        this$0.r(activity, app, sessionInfo, context);
        if (dialogInterface instanceof ScreenShareQQCustomDialog) {
            ((ScreenShareQQCustomDialog) dialogInterface).o0();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p(DialogInterface dialogInterface, int i3) {
        dialogInterface.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q(ShareScreenOnClickProcessor this$0, Activity activity, QQAppInterface app, SessionInfo sessionInfo, com.tencent.aio.api.runtime.a context, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(activity, "$activity");
        Intrinsics.checkNotNullParameter(app, "$app");
        Intrinsics.checkNotNullParameter(sessionInfo, "$sessionInfo");
        Intrinsics.checkNotNullParameter(context, "$context");
        this$0.r(activity, app, sessionInfo, context);
        if (dialogInterface instanceof ScreenShareQQCustomDialog) {
            ((ScreenShareQQCustomDialog) dialogInterface).o0();
        }
    }

    private final void r(Activity activity, QQAppInterface app, SessionInfo sessionInfo, com.tencent.aio.api.runtime.a context) {
        int i3 = sessionInfo.f179555d;
        if (i3 == 0) {
            j(activity, app, sessionInfo, context);
            com.tencent.av.screenshare.c.b("0X800B89E", 1);
            return;
        }
        if (i3 != 1) {
            if (QLog.isColorLevel()) {
                QLog.i("ShareScreenOnClickProcessor", 2, "clickToolShareScreen, not support chat, [" + sessionInfo.f179555d + "]");
                return;
            }
            return;
        }
        cp.c.e(false);
        a71.a.a(app, activity, sessionInfo, 10, false, app.getCurrentUin(), "AIOShareScreen");
        com.tencent.qqnt.pluspanel.processor.util.a.f360544a.b(context, "ShareScreenOnClickProcessor");
        com.tencent.av.screenshare.c.b("0X800AD8E", 2);
    }

    private final void s(QQAppInterface app, SessionInfo sessionInfo) {
        b bVar = new b();
        ReqGroupVideo$ReqScreenShareAsk reqGroupVideo$ReqScreenShareAsk = new ReqGroupVideo$ReqScreenShareAsk();
        reqGroupVideo$ReqScreenShareAsk.from_uin.set(app.getLongAccountUin());
        PBUInt64Field pBUInt64Field = reqGroupVideo$ReqScreenShareAsk.to_uin;
        String str = sessionInfo.f179557e;
        Intrinsics.checkNotNullExpressionValue(str, "sessionInfo.curFriendUin");
        pBUInt64Field.set(Long.parseLong(str));
        reqGroupVideo$ReqScreenShareAsk.is_online.set(false);
        MessageHandler.I2(QQAudioHelper.b(), app, "QQRTCSvc.screen_share_ask", reqGroupVideo$ReqScreenShareAsk, bVar);
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String format = String.format(Locale.ENGLISH, "shareGAVArkMsg success : from_uin[%s], to_uin[%s], ", Arrays.copyOf(new Object[]{LogUtil.getSafePrintUin(String.valueOf(app.getLongAccountUin())), LogUtil.getSafePrintUin(sessionInfo.f179557e)}, 2));
        Intrinsics.checkNotNullExpressionValue(format, "format(locale, format, *args)");
        QLog.d("ShareScreenOnClickProcessor", 1, format);
    }

    private final void t(ScreenShareQQCustomDialog screenShareDialog, QQAppInterface app, SessionInfo sessionInfo, boolean isFirstShow) {
        int i3 = sessionInfo.f179555d;
        if (i3 == 0) {
            screenShareDialog.r0(app.getCurrentUin(), 3, sessionInfo.f179557e, isFirstShow);
        } else if (i3 == 1) {
            screenShareDialog.r0(app.getCurrentUin(), 1, sessionInfo.f179557e, isFirstShow);
        } else {
            screenShareDialog.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void u(long uin, QQAppInterface app, com.tencent.aio.api.runtime.a context) {
        FragmentActivity requireActivity = context.c().requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "context.fragment.requireActivity()");
        SessionInfo sessionInfo = new SessionInfo();
        sessionInfo.f179557e = String.valueOf(uin);
        sessionInfo.f179559f = String.valueOf(uin);
        sessionInfo.f179555d = com.tencent.nt.adapter.session.c.c(context.g().r().c().e());
        sessionInfo.f179563i = context.g().r().c().g();
        if (app.getAVNotifyCenter().g(requireActivity, 3, sessionInfo.f179555d, sessionInfo.f179557e)) {
            return;
        }
        m(requireActivity, app, sessionInfo, context);
    }

    @Override // com.tencent.qqnt.pluspanel.logic.b
    public void a(com.tencent.qqnt.pluspanel.data.a data, final com.tencent.aio.api.runtime.a context) {
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(context, "context");
        context.e().h(PlusPanelEvent.UpdatePlusPanel.f360444d);
        com.tencent.qqnt.pluspanel.processor.util.a.f360544a.a(context, new Function2<Long, QQAppInterface, Unit>() { // from class: com.tencent.qqnt.pluspanel.processor.ShareScreenOnClickProcessor$onClick$1
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
                ShareScreenOnClickProcessor.this.u(j3, app, context);
            }
        });
    }

    private final void m(final Activity activity, final QQAppInterface app, final SessionInfo sessionInfo, final com.tencent.aio.api.runtime.a context) {
        if (activity.isFinishing()) {
            return;
        }
        String string = activity.getString(R.string.f224236id);
        Intrinsics.checkNotNullExpressionValue(string, "activity.getString(R.str\u2026creen_share_notice_title)");
        String string2 = activity.getString(R.string.f224206ia);
        Intrinsics.checkNotNullExpressionValue(string2, "activity.getString(R.str\u2026een_share_notice_content)");
        String string3 = activity.getString(R.string.f224216ib);
        Intrinsics.checkNotNullExpressionValue(string3, "activity.getString(R.str\u2026n_share_notice_highlight)");
        String string4 = activity.getString(R.string.f224226ic);
        Intrinsics.checkNotNullExpressionValue(string4, "activity.getString(R.str\u2026n_share_notice_safe_link)");
        String string5 = activity.getString(R.string.f17790358);
        Intrinsics.checkNotNullExpressionValue(string5, "activity.getString(R.string.qav_continue_share)");
        String string6 = activity.getString(R.string.f17786354);
        Intrinsics.checkNotNullExpressionValue(string6, "activity.getString(R.string.qav_cancel_share)");
        af.a r16 = com.tencent.av.utils.af.r(string2, string3, string4);
        SpannableStringBuilder b16 = com.tencent.av.screenshare.a.b(activity, r16.f76972a, r16.f76973b, r16.f76974c);
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(app.getApp());
        if (!defaultSharedPreferences.contains("SCREEN_SHARE_NOTICE_DIALOG_IS_SHOWN")) {
            QQCustomDialog a16 = com.tencent.av.screenshare.a.a(activity, string, b16, string6, string5, true, 10, new DialogInterface.OnClickListener() { // from class: com.tencent.qqnt.pluspanel.processor.w
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i3) {
                    ShareScreenOnClickProcessor.n(dialogInterface, i3);
                }
            }, new DialogInterface.OnClickListener() { // from class: com.tencent.qqnt.pluspanel.processor.x
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i3) {
                    ShareScreenOnClickProcessor.o(ShareScreenOnClickProcessor.this, activity, app, sessionInfo, context, dialogInterface, i3);
                }
            });
            if (a16 instanceof ScreenShareQQCustomDialog) {
                t((ScreenShareQQCustomDialog) a16, app, sessionInfo, true);
            }
            defaultSharedPreferences.edit().putBoolean("SCREEN_SHARE_NOTICE_DIALOG_IS_SHOWN", true).apply();
            return;
        }
        QQCustomDialog a17 = com.tencent.av.screenshare.a.a(activity, string, b16, string6, string5, false, 0, new DialogInterface.OnClickListener() { // from class: com.tencent.qqnt.pluspanel.processor.y
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                ShareScreenOnClickProcessor.p(dialogInterface, i3);
            }
        }, new DialogInterface.OnClickListener() { // from class: com.tencent.qqnt.pluspanel.processor.z
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                ShareScreenOnClickProcessor.q(ShareScreenOnClickProcessor.this, activity, app, sessionInfo, context, dialogInterface, i3);
            }
        });
        a17.setMessageWithoutAutoLink(b16);
        if (a17 instanceof ScreenShareQQCustomDialog) {
            t((ScreenShareQQCustomDialog) a17, app, sessionInfo, false);
        }
    }
}
