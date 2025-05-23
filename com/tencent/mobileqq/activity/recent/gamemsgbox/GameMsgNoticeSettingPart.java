package com.tencent.mobileqq.activity.recent.gamemsgbox;

import android.app.Dialog;
import android.content.DialogInterface;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0010\u0018\u0000 \"2\u00020\u0001:\u0002#$B\u0007\u00a2\u0006\u0004\b \u0010!J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J \u0010\t\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J \u0010\n\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J \u0010\u000b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J \u0010\f\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0010\u0010\r\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J \u0010\u0012\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0010H\u0002J\u0016\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u0010J\u000e\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u0015R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001d\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001f\u00a8\u0006%"}, d2 = {"Lcom/tencent/mobileqq/activity/recent/gamemsgbox/GameMsgNoticeSettingPart;", "Lcom/tencent/biz/richframework/part/Part;", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "clickView", "", "position", "", "F9", "K9", "G9", "H9", "L9", "E9", HippyNestedScrollComponent.PRIORITY_PARENT, "subView", "", "elementId", "D9", "appId", "P9", "Lcom/tencent/mobileqq/activity/recent/gamemsgbox/GameMsgNoticeSettingPart$b;", "listener", "O9", "d", "Lcom/tencent/mobileqq/activity/recent/gamemsgbox/GameMsgNoticeSettingPart$b;", "optionSelectListener", "e", "I", "prevPos", "f", "Ljava/lang/String;", "<init>", "()V", tl.h.F, "a", "b", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class GameMsgNoticeSettingPart extends Part {
    static IPatchRedirector $redirector_;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private b optionSelectListener;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private int prevPos;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String appId;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0004R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\t\u0010\n\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/activity/recent/gamemsgbox/GameMsgNoticeSettingPart$a;", "", "", "POSITION0", "I", "POSITION1", "POSITION2", "POSITION3", "", "tag", "Ljava/lang/String;", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.activity.recent.gamemsgbox.GameMsgNoticeSettingPart$a, reason: from kotlin metadata */
    /* loaded from: classes10.dex */
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

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H&\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/activity/recent/gamemsgbox/GameMsgNoticeSettingPart$b;", "", "", "prevPos", "nowPos", "", "appId", "", "a", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes10.dex */
    public interface b {
        void a(int prevPos, int nowPos, @NotNull String appId);
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(52936);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public GameMsgNoticeSettingPart() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.appId = "";
        }
    }

    private final void D9(View parent, View subView, String elementId) {
        HashMap hashMap = new HashMap();
        hashMap.put("pgid", "pg_gb_switch");
        VideoReport.setElementId(subView, elementId);
        VideoReport.setPageId(parent, "pg_gb_switch");
        VideoReport.reportEvent("clck", parent, hashMap);
    }

    private final void E9(int position) {
        b bVar = this.optionSelectListener;
        if (bVar != null) {
            bVar.a(this.prevPos, position, this.appId);
        }
    }

    private final void F9(View rootView, View clickView, int position) {
        if (QLog.isColorLevel()) {
            QLog.i("GameMsgNoticeSettingPart", 2, "onButtonClick,position=" + position);
        }
        if (position != 0) {
            if (position != 1) {
                if (position != 2) {
                    if (position == 3) {
                        L9(rootView, clickView, position);
                        return;
                    }
                    return;
                }
                H9(rootView, clickView, position);
                return;
            }
            G9(rootView, clickView, position);
            return;
        }
        K9(rootView, clickView, position);
    }

    private final void G9(View rootView, View clickView, int position) {
        E9(position);
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            return;
        }
        ReportController.n(peekAppRuntime, "P_CliOper", "dc00898", peekAppRuntime.getCurrentUin(), "0X800BF9F", "0X800BF9F", 0, 1, 0, "", "", "", "");
        com.tencent.mobileqq.activity.recent.gamemsgbox.data.a a16 = com.tencent.mobileqq.activity.recent.gamemsgbox.data.a.a();
        if (a16 != null) {
            a16.c();
        }
    }

    private final void H9(View rootView, View clickView, final int position) {
        D9(rootView, clickView, "em_gb_no_remind");
        QQCustomDialog createCustomDialog = DialogUtil.createCustomDialog(getContext(), 230, (String) null, getContext().getString(R.string.f199424pd), getContext().getString(R.string.f185783pi), getContext().getString(R.string.f185793pj), new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.activity.recent.gamemsgbox.ap
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                GameMsgNoticeSettingPart.I9(GameMsgNoticeSettingPart.this, position, dialogInterface, i3);
            }
        }, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.activity.recent.gamemsgbox.aq
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                GameMsgNoticeSettingPart.J9(dialogInterface, i3);
            }
        });
        Intrinsics.checkNotNullExpressionValue(createCustomDialog, "createCustomDialog(\n    \u2026ckListener { _, _ -> {}})");
        createCustomDialog.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void I9(GameMsgNoticeSettingPart this$0, int i3, DialogInterface dialogInterface, int i16) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.E9(i3);
        dialogInterface.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void J9(DialogInterface dialogInterface, int i3) {
        GameMsgNoticeSettingPart$onSelectAcceptNonRemind$dialog$2$1 gameMsgNoticeSettingPart$onSelectAcceptNonRemind$dialog$2$1 = GameMsgNoticeSettingPart$onSelectAcceptNonRemind$dialog$2$1.INSTANCE;
    }

    private final void K9(View rootView, View clickView, int position) {
        E9(position);
        D9(rootView, clickView, "em_gb_receive");
        com.tencent.mobileqq.activity.recent.gamemsgbox.data.a a16 = com.tencent.mobileqq.activity.recent.gamemsgbox.data.a.a();
        if (a16 != null) {
            a16.c();
        }
    }

    private final void L9(View rootView, View clickView, final int position) {
        D9(rootView, clickView, "em_gb_block");
        QQCustomDialog createCustomDialog = DialogUtil.createCustomDialog(getContext(), 230, (String) null, getContext().getString(R.string.f199434pe), getContext().getString(R.string.f185783pi), getContext().getString(R.string.f185793pj), new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.activity.recent.gamemsgbox.an
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                GameMsgNoticeSettingPart.M9(GameMsgNoticeSettingPart.this, position, dialogInterface, i3);
            }
        }, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.activity.recent.gamemsgbox.ao
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                GameMsgNoticeSettingPart.N9(dialogInterface, i3);
            }
        });
        Intrinsics.checkNotNullExpressionValue(createCustomDialog, "createCustomDialog(\n    \u2026ckListener { _, _ -> {}})");
        createCustomDialog.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void M9(GameMsgNoticeSettingPart this$0, int i3, DialogInterface dialogInterface, int i16) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.E9(i3);
        dialogInterface.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void N9(DialogInterface dialogInterface, int i3) {
        GameMsgNoticeSettingPart$onSelectBlock$dialog$2$1 gameMsgNoticeSettingPart$onSelectBlock$dialog$2$1 = GameMsgNoticeSettingPart$onSelectBlock$dialog$2$1.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Q9(GameMsgNoticeSettingPart this$0, ActionSheet actionSheetWithSelect, View clickView, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(actionSheetWithSelect, "$actionSheetWithSelect");
        ViewGroup rootView = actionSheetWithSelect.getRootView();
        Intrinsics.checkNotNullExpressionValue(rootView, "actionSheetWithSelect.rootView");
        Intrinsics.checkNotNullExpressionValue(clickView, "clickView");
        this$0.F9(rootView, clickView, i3);
        actionSheetWithSelect.dismiss();
    }

    public final void O9(@NotNull b listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) listener);
        } else {
            Intrinsics.checkNotNullParameter(listener, "listener");
            this.optionSelectListener = listener;
        }
    }

    public final void P9(int position, @NotNull String appId) {
        boolean z16;
        boolean z17;
        boolean z18;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, position, (Object) appId);
            return;
        }
        Intrinsics.checkNotNullParameter(appId, "appId");
        this.prevPos = position;
        this.appId = appId;
        Dialog createDialog = ActionSheetHelper.createDialog(getActivity(), null);
        Intrinsics.checkNotNull(createDialog, "null cannot be cast to non-null type com.tencent.widget.ActionSheet");
        final ActionSheet actionSheet = (ActionSheet) createDialog;
        boolean z19 = false;
        if (position == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        actionSheet.addRadioButton(R.string.f199494pk, z16);
        if (position == 1) {
            z17 = true;
        } else {
            z17 = false;
        }
        actionSheet.addRadioButton(R.string.f199484pj, z17);
        if (position == 2) {
            z18 = true;
        } else {
            z18 = false;
        }
        actionSheet.addRadioButton(R.string.f199464ph, z18);
        if (position == 3) {
            z19 = true;
        }
        actionSheet.addRadioButton(R.string.f199274oz, z19);
        actionSheet.setMainTitle(R.string.f199504pl);
        actionSheet.setOnButtonClickListener(new ActionSheet.OnButtonClickListener() { // from class: com.tencent.mobileqq.activity.recent.gamemsgbox.am
            @Override // com.tencent.widget.ActionSheet.OnButtonClickListener
            public final void onClick(View view, int i3) {
                GameMsgNoticeSettingPart.Q9(GameMsgNoticeSettingPart.this, actionSheet, view, i3);
            }
        });
        actionSheet.addCancelButton(R.string.f185563ox);
        actionSheet.show();
    }
}
