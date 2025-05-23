package com.tencent.mobileqq.troop.homework.clockin.detail.model;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.view.View;
import androidx.lifecycle.MutableLiveData;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.troop.homework.clockin.detail.vm.a;
import com.tencent.mobileqq.troop.homework.clockin.list.event.HWClockInListUpdateEvent;
import com.tencent.mobileqq.troop.utils.bg;
import com.tencent.mobileqq.troop.utils.h;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.winkpublish.report.WinkBaseErrorCodeKt;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.api.r;
import com.tencent.qqnt.kernel.nativeinterface.GroupSchoolTaskData;
import com.tencent.qqnt.kernel.nativeinterface.IOperateCallback;
import com.tencent.qqnt.kernel.nativeinterface.ModGroupSchoolTaskStatusReq;
import com.tencent.util.QQToastUtil;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 %2\u00020\u0001:\u0001\u000bB1\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\n\u0012\u0006\u0010\u0015\u001a\u00020\u0010\u0012\b\u0010\u001b\u001a\u0004\u0018\u00010\u0016\u0012\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001c\u00a2\u0006\u0004\b#\u0010$J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0006\u0010\t\u001a\u00020\u0002R\u0019\u0010\u000f\u001a\u0004\u0018\u00010\n8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u0015\u001a\u00020\u00108\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u0019\u0010\u001b\u001a\u0004\u0018\u00010\u00168\u0006\u00a2\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u001d\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001c8\u0006\u00a2\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!\u00a8\u0006&"}, d2 = {"Lcom/tencent/mobileqq/troop/homework/clockin/detail/model/HWClockInDetailMoreActionUseCase;", "", "", "o", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "i", "", "status", "l", DomainData.DOMAIN_NAME, "Landroid/app/Activity;", "a", "Landroid/app/Activity;", "getActivity", "()Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "", "b", "Ljava/lang/String;", "getTroopUin", "()Ljava/lang/String;", "troopUin", "Lcom/tencent/qqnt/kernel/nativeinterface/GroupSchoolTaskData;", "c", "Lcom/tencent/qqnt/kernel/nativeinterface/GroupSchoolTaskData;", "getDetail", "()Lcom/tencent/qqnt/kernel/nativeinterface/GroupSchoolTaskData;", "detail", "Landroidx/lifecycle/MutableLiveData;", "Lcom/tencent/mobileqq/troop/homework/clockin/detail/vm/a;", "d", "Landroidx/lifecycle/MutableLiveData;", "getUiState", "()Landroidx/lifecycle/MutableLiveData;", "uiState", "<init>", "(Landroid/app/Activity;Ljava/lang/String;Lcom/tencent/qqnt/kernel/nativeinterface/GroupSchoolTaskData;Landroidx/lifecycle/MutableLiveData;)V", "e", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class HWClockInDetailMoreActionUseCase {
    static IPatchRedirector $redirector_;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final Activity activity;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String troopUin;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final GroupSchoolTaskData detail;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final MutableLiveData<com.tencent.mobileqq.troop.homework.clockin.detail.vm.a> uiState;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/troop/homework/clockin/detail/model/HWClockInDetailMoreActionUseCase$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.troop.homework.clockin.detail.model.HWClockInDetailMoreActionUseCase$a, reason: from kotlin metadata */
    /* loaded from: classes19.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(41683);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public HWClockInDetailMoreActionUseCase(@Nullable Activity activity, @NotNull String troopUin, @Nullable GroupSchoolTaskData groupSchoolTaskData, @NotNull MutableLiveData<com.tencent.mobileqq.troop.homework.clockin.detail.vm.a> uiState) {
        Intrinsics.checkNotNullParameter(troopUin, "troopUin");
        Intrinsics.checkNotNullParameter(uiState, "uiState");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, activity, troopUin, groupSchoolTaskData, uiState);
            return;
        }
        this.activity = activity;
        this.troopUin = troopUin;
        this.detail = groupSchoolTaskData;
        this.uiState = uiState;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void i() {
        Activity activity = this.activity;
        if (activity == null) {
            return;
        }
        DialogUtil.createCustomDialog(activity, 230, "\u5220\u9664\u8be5\u6253\u5361\u5417\uff1f", "\u5220\u9664\u540e\u8be5\u6253\u5361\u5386\u53f2\u6210\u679c\u5c06\u5f7b\u5e95\u5220\u9664\uff0c\u6240\u6709\u6210\u5458\u90fd\u65e0\u6cd5\u518d\u56de\u987e\u6253\u5361\u5185\u5bb9\u3002", "\u53d6\u6d88", "\u5220\u9664", new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.troop.homework.clockin.detail.model.e
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                HWClockInDetailMoreActionUseCase.j(HWClockInDetailMoreActionUseCase.this, dialogInterface, i3);
            }
        }, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.troop.homework.clockin.detail.model.f
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                HWClockInDetailMoreActionUseCase.k(dialogInterface, i3);
            }
        }).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j(HWClockInDetailMoreActionUseCase this$0, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        h.a.f(com.tencent.mobileqq.troop.homework.clockin.report.a.f296532a, new View(this$0.activity), "em_group_confirm_del_notice", null, this$0.activity.getWindow().getDecorView(), 4, null);
        this$0.l(2);
        dialogInterface.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k(DialogInterface dialogInterface, int i3) {
        dialogInterface.dismiss();
    }

    private final void l(final int status) {
        Long longOrNull;
        long j3;
        if (this.detail != null) {
            longOrNull = StringsKt__StringNumberConversionsKt.toLongOrNull(this.troopUin);
            if (longOrNull != null) {
                j3 = longOrNull.longValue();
            } else {
                j3 = 0;
            }
            ModGroupSchoolTaskStatusReq modGroupSchoolTaskStatusReq = new ModGroupSchoolTaskStatusReq(j3, this.detail.taskId, status, 1);
            QLog.i("HW.ClockIn.DETAIL.HWClockInDetailMoreActionUseCase", 1, "modifyTaskStatus, " + modGroupSchoolTaskStatusReq);
            r g16 = bg.f302144a.g();
            if (g16 != null) {
                g16.modifyGroupSchoolTaskStatus(modGroupSchoolTaskStatusReq, new IOperateCallback() { // from class: com.tencent.mobileqq.troop.homework.clockin.detail.model.g
                    @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
                    public final void onResult(int i3, String str) {
                        HWClockInDetailMoreActionUseCase.m(status, this, i3, str);
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m(int i3, HWClockInDetailMoreActionUseCase this$0, int i16, String str) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QLog.i("HW.ClockIn.DETAIL.HWClockInDetailMoreActionUseCase", 1, "modifyTaskStatus result, " + i16 + "-" + str);
        if (i16 == 0) {
            if (i3 != 2) {
                if (i3 == 3) {
                    QQToastUtil.showQQToastInUiThread(2, WinkBaseErrorCodeKt.ERROR_MSG_OK);
                    return;
                }
                return;
            } else {
                QQToastUtil.showQQToastInUiThread(2, "\u5220\u9664\u6210\u529f");
                SimpleEventBus simpleEventBus = SimpleEventBus.getInstance();
                String str2 = this$0.detail.taskId;
                Intrinsics.checkNotNullExpressionValue(str2, "detail.taskId");
                simpleEventBus.dispatchEvent(new HWClockInListUpdateEvent.ClockInDeleted(str2));
                this$0.uiState.postValue(a.f.f296397a);
                return;
            }
        }
        String a16 = new com.tencent.mobileqq.troop.homework.clockin.a().a(i16);
        if (a16 == null) {
            a16 = "\u64cd\u4f5c\u5931\u8d25";
        }
        QQToastUtil.showQQToastInUiThread(1, a16);
    }

    private final void o() {
        GroupSchoolTaskData groupSchoolTaskData;
        Activity activity = this.activity;
        if (activity == null || (groupSchoolTaskData = this.detail) == null) {
            return;
        }
        boolean z16 = true;
        if (groupSchoolTaskData.status != 1) {
            z16 = false;
        }
        Dialog createDialog = ActionSheetHelper.createDialog(activity, null);
        Intrinsics.checkNotNull(createDialog, "null cannot be cast to non-null type com.tencent.widget.ActionSheet");
        final ActionSheet actionSheet = (ActionSheet) createDialog;
        final ArrayList arrayList = new ArrayList();
        if (z16) {
            actionSheet.addButton("\u7ed3\u675f\u6253\u5361");
            arrayList.add(new Function0<Unit>() { // from class: com.tencent.mobileqq.troop.homework.clockin.detail.model.HWClockInDetailMoreActionUseCase$showActionSheet$1
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) HWClockInDetailMoreActionUseCase.this);
                    }
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                        HWClockInDetailMoreActionUseCase.this.q();
                    } else {
                        iPatchRedirector.redirect((short) 2, (Object) this);
                    }
                }
            });
        }
        actionSheet.addButton("\u5220\u9664");
        arrayList.add(new Function0<Unit>() { // from class: com.tencent.mobileqq.troop.homework.clockin.detail.model.HWClockInDetailMoreActionUseCase$showActionSheet$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) HWClockInDetailMoreActionUseCase.this);
                }
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                    HWClockInDetailMoreActionUseCase.this.i();
                } else {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                }
            }
        });
        actionSheet.setOnButtonClickListener(new ActionSheet.OnButtonClickListener() { // from class: com.tencent.mobileqq.troop.homework.clockin.detail.model.b
            @Override // com.tencent.widget.ActionSheet.OnButtonClickListener
            public final void onClick(View view, int i3) {
                HWClockInDetailMoreActionUseCase.p(ActionSheet.this, arrayList, view, i3);
            }
        });
        actionSheet.addCancelButton("\u53d6\u6d88");
        actionSheet.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p(ActionSheet actionSheet, ArrayList actions, View view, int i3) {
        Intrinsics.checkNotNullParameter(actionSheet, "$actionSheet");
        Intrinsics.checkNotNullParameter(actions, "$actions");
        actionSheet.dismiss();
        if (actions.size() > i3) {
            ((Function0) actions.get(i3)).invoke();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void q() {
        Activity activity = this.activity;
        if (activity == null) {
            return;
        }
        DialogUtil.createCustomDialog(activity, 230, "\u63d0\u524d\u7ed3\u675f\u6253\u5361\u5417\uff1f", "\u672c\u6253\u5361\u5c06\u4e8e\u4eca\u65e524\u70b9\u7ed3\u675f\uff0c\u660e\u5929\u8d77\u4e0d\u80fd\u7ee7\u7eed\u6253\u5361\uff0c\u5e76\u4e14\u4e5f\u4e0d\u4f1a\u81ea\u52a8\u91cd\u65b0\u5e03\u7f6e\u6253\u5361\u3002", "\u53d6\u6d88", "\u7ed3\u675f", new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.troop.homework.clockin.detail.model.c
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                HWClockInDetailMoreActionUseCase.r(HWClockInDetailMoreActionUseCase.this, dialogInterface, i3);
            }
        }, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.troop.homework.clockin.detail.model.d
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                HWClockInDetailMoreActionUseCase.s(dialogInterface, i3);
            }
        }).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r(HWClockInDetailMoreActionUseCase this$0, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        h.a.f(com.tencent.mobileqq.troop.homework.clockin.report.a.f296532a, new View(this$0.activity), "em_group_confirm_end_btn", null, this$0.activity.getWindow().getDecorView(), 4, null);
        this$0.l(3);
        dialogInterface.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s(DialogInterface dialogInterface, int i3) {
        dialogInterface.dismiss();
    }

    public final void n() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        } else {
            o();
        }
    }
}
