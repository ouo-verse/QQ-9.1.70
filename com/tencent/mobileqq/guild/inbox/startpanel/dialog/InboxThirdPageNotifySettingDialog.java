package com.tencent.mobileqq.guild.inbox.startpanel.dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.ocr.data.OcrConfig;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.ReportAndroidXDialogFragment;
import com.tencent.qqmini.minigame.action.OperateCustomButton;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import ef1.c;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.time.Duration;
import kotlin.time.TimeSource;
import kotlin.time.TimedValue;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001eB\u000f\u0012\u0006\u0010\u0010\u001a\u00020\r\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\f\u0010\u0007\u001a\u00020\u0006*\u00020\u0005H\u0002J\u0012\u0010\n\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J\u0012\u0010\f\u001a\u00020\u000b2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016R\u0014\u0010\u0010\u001a\u00020\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0013\u001a\u00020\u00058\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0014\u0010\u001a\u001a\u00020\r8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/mobileqq/guild/inbox/startpanel/dialog/InboxThirdPageNotifySettingDialog;", "Landroidx/fragment/app/DialogFragment;", "", "xh", OcrConfig.CHINESE, "Lcom/tencent/widget/ActionSheet;", "", "uh", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onCreate", "Landroid/app/Dialog;", "onCreateDialog", "", BdhLogUtil.LogTag.Tag_Conn, "I", "noticeMsgType", "D", "Lcom/tencent/widget/ActionSheet;", "actionSheet", "Lxp1/d;", "E", "Lxp1/d;", "notificationSettingVM", "yh", "()I", "reqNoticeType", "<init>", "(I)V", UserInfo.SEX_FEMALE, "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class InboxThirdPageNotifySettingDialog extends ReportAndroidXDialogFragment {

    /* renamed from: C, reason: from kotlin metadata */
    private final int noticeMsgType;

    /* renamed from: D, reason: from kotlin metadata */
    private ActionSheet actionSheet;

    /* renamed from: E, reason: from kotlin metadata */
    private xp1.d notificationSettingVM;

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J'\u0010\u0006\u001a\u00028\u0000\"\b\b\u0000\u0010\u0003*\u00020\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0016\u00a2\u0006\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/guild/base/mvvm/SingleViewModelProvider$Companion$factory$1", "Landroidx/lifecycle/ViewModelProvider$Factory;", "Landroidx/lifecycle/ViewModel;", "T", "Ljava/lang/Class;", "p0", OperateCustomButton.OPERATE_CREATE, "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class b implements ViewModelProvider.Factory {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ViewModelStoreOwner f226256a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ InboxThirdPageNotifySettingDialog f226257b;

        public b(ViewModelStoreOwner viewModelStoreOwner, InboxThirdPageNotifySettingDialog inboxThirdPageNotifySettingDialog) {
            this.f226256a = viewModelStoreOwner;
            this.f226257b = inboxThirdPageNotifySettingDialog;
        }

        @Override // androidx.lifecycle.ViewModelProvider.Factory
        @NotNull
        public <T extends ViewModel> T create(@NotNull Class<T> p06) {
            Intrinsics.checkNotNullParameter(p06, "p0");
            long m1963markNowz9LOYto = TimeSource.Monotonic.INSTANCE.m1963markNowz9LOYto();
            int yh5 = this.f226257b.yh();
            Context requireContext = this.f226257b.requireContext();
            Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
            TimedValue timedValue = new TimedValue(new xp1.d(yh5, requireContext), TimeSource.Monotonic.ValueTimeMark.m1966elapsedNowUwyO8pc(m1963markNowz9LOYto), null);
            Logger logger = Logger.f235387a;
            if (QLog.isColorLevel()) {
                logger.d().d("GuildViewModelProvider", 2, "create " + com.tencent.mobileqq.guild.base.extension.m.a(timedValue.getValue()) + " cost " + Duration.m1875toStringimpl(timedValue.m1981getDurationUwyO8pc()));
            }
            return (T) timedValue.getValue();
        }
    }

    public InboxThirdPageNotifySettingDialog(int i3) {
        this.noticeMsgType = i3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ah(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void uh(final ActionSheet actionSheet) {
        actionSheet.addCancelButton(R.string.f140850f3);
        actionSheet.addRadioButton((CharSequence) xh(), false);
        actionSheet.addRadioButton((CharSequence) zh(), false);
        actionSheet.setOnButtonClickListener(new ActionSheet.OnButtonClickListener() { // from class: com.tencent.mobileqq.guild.inbox.startpanel.dialog.n
            @Override // com.tencent.widget.ActionSheet.OnButtonClickListener
            public final void onClick(View view, int i3) {
                InboxThirdPageNotifySettingDialog.vh(InboxThirdPageNotifySettingDialog.this, actionSheet, view, i3);
            }
        });
        actionSheet.setOnPreShowListener(new ActionSheet.onPreShowListener() { // from class: com.tencent.mobileqq.guild.inbox.startpanel.dialog.o
            @Override // com.tencent.widget.ActionSheet.onPreShowListener
            public final void onPreShow() {
                InboxThirdPageNotifySettingDialog.wh(ActionSheet.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void vh(InboxThirdPageNotifySettingDialog this$0, ActionSheet this_build, View view, int i3) {
        boolean z16;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(this_build, "$this_build");
        xp1.d dVar = this$0.notificationSettingVM;
        if (dVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("notificationSettingVM");
            dVar = null;
        }
        if (i3 == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        dVar.S1(z16);
        this_build.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void wh(ActionSheet this_build) {
        Intrinsics.checkNotNullParameter(this_build, "$this_build");
        Button button = (Button) this_build.findViewById(R.id.action_sheet_btnCancel);
        if (button != null) {
            button.setTypeface(null, 0);
            button.setTextSize(2, 17.0f);
        }
    }

    private final String xh() {
        int i3;
        if (this.noticeMsgType == 7) {
            i3 = R.string.f152701a4;
        } else {
            i3 = R.string.f152711a5;
        }
        String string = requireContext().getString(i3);
        Intrinsics.checkNotNullExpressionValue(string, "requireContext().getStri\u2026          resId\n        )");
        return string;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int yh() {
        if (this.noticeMsgType == 7) {
            return 103;
        }
        return 104;
    }

    private final String zh() {
        int i3;
        if (this.noticeMsgType == 7) {
            i3 = R.string.f156781l5;
        } else {
            i3 = R.string.f156791l6;
        }
        String string = requireContext().getString(i3);
        Intrinsics.checkNotNullExpressionValue(string, "requireContext().getStri\u2026          resId\n        )");
        return string;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        c.Companion companion = ef1.c.INSTANCE;
        ViewModel viewModel = new ViewModelProvider(this, new b(this, this)).get(xp1.d.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProvider(this, \u2026k(this) })[T::class.java]");
        this.notificationSettingVM = (xp1.d) viewModel;
    }

    @Override // com.tencent.qqlive.module.videoreport.inject.fragment.ReportAndroidXDialogFragment, androidx.fragment.app.DialogFragment
    @NotNull
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        Dialog createDialog = ActionSheetHelper.createDialog(requireContext(), null);
        Intrinsics.checkNotNull(createDialog, "null cannot be cast to non-null type com.tencent.widget.ActionSheet");
        ActionSheet actionSheet = (ActionSheet) createDialog;
        this.actionSheet = actionSheet;
        if (actionSheet == null) {
            Intrinsics.throwUninitializedPropertyAccessException("actionSheet");
            actionSheet = null;
        }
        uh(actionSheet);
        xp1.d dVar = this.notificationSettingVM;
        if (dVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("notificationSettingVM");
            dVar = null;
        }
        LiveData<Boolean> R1 = dVar.R1();
        final Function1<Boolean, Unit> function1 = new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.guild.inbox.startpanel.dialog.InboxThirdPageNotifySettingDialog$onCreateDialog$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke2(bool);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Boolean it) {
                ActionSheet actionSheet2;
                Intrinsics.checkNotNullExpressionValue(it, "it");
                int i3 = !it.booleanValue() ? 1 : 0;
                actionSheet2 = InboxThirdPageNotifySettingDialog.this.actionSheet;
                if (actionSheet2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("actionSheet");
                    actionSheet2 = null;
                }
                actionSheet2.setRadioButtonChecked(i3);
            }
        };
        R1.observe(this, new Observer() { // from class: com.tencent.mobileqq.guild.inbox.startpanel.dialog.m
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                InboxThirdPageNotifySettingDialog.Ah(Function1.this, obj);
            }
        });
        ActionSheet actionSheet2 = this.actionSheet;
        if (actionSheet2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("actionSheet");
            return null;
        }
        return actionSheet2;
    }
}
