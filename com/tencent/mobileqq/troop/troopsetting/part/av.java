package com.tencent.mobileqq.troop.troopsetting.part;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.view.View;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqfeatureswitch.IFeatureRuntimeService;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.data.TroopInfoData;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.eu;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.h;
import com.tencent.mobileqq.widget.listitem.Group;
import com.tencent.mobileqq.widget.listitem.x;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.kernel.api.IKernelService;
import com.tencent.qqnt.kernel.nativeinterface.IClearMsgRecordsCallback;
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import com.tencent.util.LoadingUtil;
import java.util.ArrayList;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 '2\u00020\u0001:\u0001(B\u0007\u00a2\u0006\u0004\b%\u0010&J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0002H\u0002J\b\u0010\b\u001a\u00020\u0007H\u0002J\u0015\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0016\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0012\u0010\u000f\u001a\u00020\u00022\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016J\u0012\u0010\u0012\u001a\u00020\u00022\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016R,\u0010\u0018\u001a\u001a\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00140\u0013j\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0014`\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u001e\u0010\u001c\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00198\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR$\u0010$\u001a\u0004\u0018\u00010\u001d8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#\u00a8\u0006)"}, d2 = {"Lcom/tencent/mobileqq/troop/troopsetting/part/av;", "Lcom/tencent/mobileqq/troop/troopsetting/part/h;", "", "P9", "S9", "N9", "O9", "", "R9", "", "Lcom/tencent/mobileqq/widget/listitem/Group;", "G9", "()[Lcom/tencent/mobileqq/widget/listitem/Group;", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "onPartDestroy", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/widget/listitem/a;", "Lkotlin/collections/ArrayList;", "e", "Ljava/util/ArrayList;", "configList", "Lcom/tencent/mobileqq/widget/listitem/x;", "f", "Lcom/tencent/mobileqq/widget/listitem/x;", "deleteChatHistoryConfig", "Landroid/app/Dialog;", tl.h.F, "Landroid/app/Dialog;", "getClearChatRecordProgress", "()Landroid/app/Dialog;", "setClearChatRecordProgress", "(Landroid/app/Dialog;)V", "clearChatRecordProgress", "<init>", "()V", "i", "a", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class av extends h {
    static IPatchRedirector $redirector_;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ArrayList<com.tencent.mobileqq.widget.listitem.a<?>> configList;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private com.tencent.mobileqq.widget.listitem.x<?, ?> deleteChatHistoryConfig;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Dialog clearChatRecordProgress;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/troop/troopsetting/part/av$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.troop.troopsetting.part.av$a, reason: from kotlin metadata */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(60682);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public av() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.configList = new ArrayList<>();
        }
    }

    private final void N9() {
        Dialog dialog = this.clearChatRecordProgress;
        if (dialog != null && dialog.isShowing()) {
            dialog.dismiss();
        }
    }

    private final void O9() {
        if (C9()) {
            return;
        }
        QQToast.makeText(getActivity(), 2, getContext().getResources().getString(R.string.a3m), 0).show();
    }

    private final void P9() {
        String string = getContext().getString(R.string.dqj);
        Intrinsics.checkNotNullExpressionValue(string, "context.getString(com.te\u2026tring.qb_group_clear_msg)");
        com.tencent.mobileqq.widget.listitem.x<?, ?> xVar = new com.tencent.mobileqq.widget.listitem.x<>(new x.b.d(string), new x.c.g("", false, false, 4, null));
        xVar.x(new View.OnClickListener() { // from class: com.tencent.mobileqq.troop.troopsetting.part.ap
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                av.Q9(av.this, view);
            }
        });
        this.deleteChatHistoryConfig = xVar;
        this.configList.add(xVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Q9(av this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.S9();
        EventCollector.getInstance().onViewClicked(view);
    }

    private final boolean R9() {
        AppInterface appInterface;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime instanceof AppInterface) {
            appInterface = (AppInterface) peekAppRuntime;
        } else {
            appInterface = null;
        }
        if (appInterface == null) {
            return true;
        }
        IRuntimeService runtimeService = appInterface.getRuntimeService(IFeatureRuntimeService.class, "all");
        Intrinsics.checkNotNullExpressionValue(runtimeService, "app.getRuntimeService(IF\u2026ava, ProcessConstant.ALL)");
        return ((IFeatureRuntimeService) runtimeService).isFeatureSwitchEnable("del_chat_histroy_new_ui_8898");
    }

    private final void S9() {
        Dialog showLoadingDialog = LoadingUtil.showLoadingDialog(getContext(), "\u5220\u9664\u4e2d", true);
        this.clearChatRecordProgress = showLoadingDialog;
        if (showLoadingDialog != null) {
            showLoadingDialog.setCancelable(false);
        }
        final TroopInfoData T2 = B9().T2();
        final h.a aVar = new h.a() { // from class: com.tencent.mobileqq.troop.troopsetting.part.aq
            @Override // com.tencent.mobileqq.widget.h.a
            public final void a(Dialog dialog, View view, boolean z16) {
                av.T9(av.this, T2, dialog, view, z16);
            }
        };
        if (R9()) {
            QQCustomDialog createCustomDialog = DialogUtil.createCustomDialog(getActivity(), 230, (String) null, getContext().getResources().getString(R.string.zqs), getContext().getResources().getString(R.string.cancel), getContext().getResources().getString(R.string.f171151ok), new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.troop.troopsetting.part.ar
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i3) {
                    av.W9(h.a.this, this, dialogInterface, i3);
                }
            }, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.troop.troopsetting.part.as
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i3) {
                    av.X9(av.this, dialogInterface, i3);
                }
            });
            Intrinsics.checkNotNullExpressionValue(createCustomDialog, "createCustomDialog(activ\u2026 )\n                    })");
            com.tencent.mobileqq.simpleui.c.j(createCustomDialog, 1000);
            createCustomDialog.show();
            ReportController.o(z9(), "dc00898", "", "", "0X800A363", "0X800A363", 2, 0, "1", "", "", "");
        } else {
            com.tencent.mobileqq.widget.h hVar = new com.tencent.mobileqq.widget.h(getActivity(), z9(), false);
            hVar.S(aVar);
            hVar.W(2);
        }
        eu.g("Grp_set_new", "grpData_admin", "clk_delRecord", 0, 0, T2.troopUin, eu.c(T2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void T9(final av this$0, TroopInfoData mTroopInfoData, Dialog dialog, View view, boolean z16) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(mTroopInfoData, "$mTroopInfoData");
        com.tencent.qqnt.kernel.api.w msgService = ((IKernelService) this$0.z9().getRuntimeService(IKernelService.class, "")).getMsgService();
        if (msgService != null) {
            Dialog dialog2 = this$0.clearChatRecordProgress;
            if (dialog2 != null) {
                dialog2.show();
            }
            msgService.clearMsgRecords(new Contact(2, mTroopInfoData.troopUin, ""), new IClearMsgRecordsCallback() { // from class: com.tencent.mobileqq.troop.troopsetting.part.at
                @Override // com.tencent.qqnt.kernel.nativeinterface.IClearMsgRecordsCallback
                public final void onResult(int i3, String str, long j3) {
                    av.U9(av.this, i3, str, j3);
                }
            });
        }
        eu.g("Grp_set_new", "grpData_admin", "confirm_delRecord", 0, 0, mTroopInfoData.troopUin, eu.c(mTroopInfoData));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void U9(final av this$0, final int i3, final String errMsg, final long j3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(errMsg, "errMsg");
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.troop.troopsetting.part.au
            @Override // java.lang.Runnable
            public final void run() {
                av.V9(av.this, i3, errMsg, j3);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void V9(av this$0, int i3, String errMsg, long j3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(errMsg, "$errMsg");
        this$0.N9();
        this$0.O9();
        QLog.d("TroopDeleteChatHistoryPart", 1, "clearMsgRecords result=" + i3 + " msg=" + errMsg + " lastSeq=" + j3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void W9(h.a clickListener, av this$0, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(clickListener, "$clickListener");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QLog.i("TroopDeleteChatHistoryPart", 1, "onClick clearMsg confirm btn");
        clickListener.a(null, null, false);
        ReportController.o(this$0.z9(), "dc00898", "", "", "0X800A364", "0X800A364", 3, 0, "1", "", "", "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void X9(av this$0, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QLog.i("TroopDeleteChatHistoryPart", 1, "onClick clearMsg cancel btn");
        ReportController.o(this$0.z9(), "dc00898", "", "", "0X800A365", "0X800A365", 3, 0, "1", "", "", "");
    }

    @Override // com.tencent.mobileqq.troop.troopsetting.part.h
    @NotNull
    public Group[] G9() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (Group[]) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        Object[] array = this.configList.toArray(new com.tencent.mobileqq.widget.listitem.a[0]);
        Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        com.tencent.mobileqq.widget.listitem.a[] aVarArr = (com.tencent.mobileqq.widget.listitem.a[]) array;
        return new Group[]{new Group((com.tencent.mobileqq.widget.listitem.a[]) Arrays.copyOf(aVarArr, aVarArr.length))};
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@Nullable View rootView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) rootView);
        } else {
            super.onInitView(rootView);
            P9();
        }
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(@Nullable Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) activity);
        } else {
            super.onPartDestroy(activity);
            N9();
        }
    }
}
