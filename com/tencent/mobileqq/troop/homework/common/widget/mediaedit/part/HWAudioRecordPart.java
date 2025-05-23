package com.tencent.mobileqq.troop.homework.common.widget.mediaedit.part;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.audiopanel.CommonRecordSoundPanel;
import com.tencent.mobileqq.activity.aio.audiopanel.IAudioPanelPresenterCreater;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.troop.api.ITroopHWApi;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.open.base.ToastUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.constants.EventKey;
import com.tencent.util.InputMethodUtil;
import com.tencent.widget.ActionSheet;
import java.io.File;
import java.lang.ref.WeakReference;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppActivity;
import mqq.app.AppRuntime;
import mqq.app.Constants;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 -2\u00020\u0001:\u0001.B\u0007\u00a2\u0006\u0004\b+\u0010,J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u001a\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\n\u001a\u00020\u0002H\u0002J\b\u0010\u000b\u001a\u00020\u0002H\u0002J\u001c\u0010\u000f\u001a\u00020\u00022\b\u0010\f\u001a\u0004\u0018\u00010\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0017J\u0012\u0010\u0010\u001a\u00020\u00022\b\u0010\f\u001a\u0004\u0018\u00010\u0004H\u0016J\u001c\u0010\u0015\u001a\u00020\u00022\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0016J\u0006\u0010\u0016\u001a\u00020\u0002J\u0006\u0010\u0017\u001a\u00020\u0002J\u000e\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u0011R\u0018\u0010\u001c\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0018\u0010 \u001a\u0004\u0018\u00010\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u001b\u0010&\u001a\u00020!8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%R\u0014\u0010*\u001a\u00020'8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b(\u0010)\u00a8\u0006/"}, d2 = {"Lcom/tencent/mobileqq/troop/homework/common/widget/mediaedit/part/HWAudioRecordPart;", "Lcom/tencent/mobileqq/troop/homework/notice/publish/part/a;", "", "G9", "Landroid/app/Activity;", EventKey.ACT, "Landroid/os/Handler;", "notifyHandler", "Lcom/tencent/mobileqq/activity/aio/audiopanel/CommonRecordSoundPanel;", "B9", "I9", "J9", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onPartCreate", "onPartDestroy", "", "action", "", "args", "handleBroadcastMessage", "F9", "D9", "path", "E9", "e", "Lcom/tencent/mobileqq/activity/aio/audiopanel/CommonRecordSoundPanel;", "recordCtrl", "Lcom/tencent/widget/ActionSheet;", "f", "Lcom/tencent/widget/ActionSheet;", "recordActionSheet", "Lcom/tencent/mobileqq/troop/homework/common/widget/mediaedit/part/e;", tl.h.F, "Lkotlin/Lazy;", "C9", "()Lcom/tencent/mobileqq/troop/homework/common/widget/mediaedit/part/e;", "recordHandler", "Landroid/content/BroadcastReceiver;", "i", "Landroid/content/BroadcastReceiver;", "receiver", "<init>", "()V", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "a", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class HWAudioRecordPart extends com.tencent.mobileqq.troop.homework.notice.publish.part.a {
    static IPatchRedirector $redirector_;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private CommonRecordSoundPanel recordCtrl;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ActionSheet recordActionSheet;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy recordHandler;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final BroadcastReceiver receiver;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\b\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/troop/homework/common/widget/mediaedit/part/HWAudioRecordPart$a;", "", "", "MAX_RECORD_TIME", "I", "REC_PANEL_ANIM_TIME", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.troop.homework.common.widget.mediaedit.part.HWAudioRecordPart$a, reason: from kotlin metadata */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(49568);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 8)) {
            redirector.redirect((short) 8);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public HWAudioRecordPart() {
        Lazy lazy;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            lazy = LazyKt__LazyJVMKt.lazy(new Function0<e>() { // from class: com.tencent.mobileqq.troop.homework.common.widget.mediaedit.part.HWAudioRecordPart$recordHandler$2
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) HWAudioRecordPart.this);
                    }
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final e invoke() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    return (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) ? new e(new WeakReference(HWAudioRecordPart.this)) : (e) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
            });
            this.recordHandler = lazy;
            this.receiver = new BroadcastReceiver() { // from class: com.tencent.mobileqq.troop.homework.common.widget.mediaedit.part.HWAudioRecordPart$receiver$1
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) HWAudioRecordPart.this);
                    }
                }

                @Override // android.content.BroadcastReceiver
                public void onReceive(@NotNull Context context, @NotNull Intent intent) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this, (Object) context, (Object) intent);
                        return;
                    }
                    Intrinsics.checkNotNullParameter(context, "context");
                    Intrinsics.checkNotNullParameter(intent, "intent");
                    String action = intent.getAction();
                    if (action == null) {
                        return;
                    }
                    if (Intrinsics.areEqual(action, ITroopHWApi.ACTION_START_VIDEO_CHAT)) {
                        QLog.i("HW.MediaEdit.HWAudioRecordPart", 1, "receive action_start_video_chat");
                        HWAudioRecordPart.this.J9();
                    } else if (Intrinsics.areEqual(action, "android.intent.action.PHONE_STATE")) {
                        QLog.i("HW.MediaEdit.HWAudioRecordPart", 1, "receive action_phone_state_changed");
                        HWAudioRecordPart.this.J9();
                    }
                }
            };
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this);
    }

    private final CommonRecordSoundPanel B9(Activity act, Handler notifyHandler) {
        CommonRecordSoundPanel commonRecordSoundPanel;
        View inflate = act.getLayoutInflater().inflate(R.layout.a18, (ViewGroup) null);
        if (inflate instanceof CommonRecordSoundPanel) {
            commonRecordSoundPanel = (CommonRecordSoundPanel) inflate;
        } else {
            commonRecordSoundPanel = null;
        }
        if (commonRecordSoundPanel == null) {
            return null;
        }
        commonRecordSoundPanel.setPresenter(((IAudioPanelPresenterCreater) QRoute.api(IAudioPanelPresenterCreater.class)).createCommonRecordSoundPanelPresenter(commonRecordSoundPanel));
        commonRecordSoundPanel.setBackground(ContextCompat.getDrawable(getActivity(), R.drawable.qui_common_bg_bottom_light_bg));
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        Intrinsics.checkNotNull(act, "null cannot be cast to non-null type mqq.app.AppActivity");
        commonRecordSoundPanel.k(peekAppRuntime, (AppActivity) act, notifyHandler, 0);
        commonRecordSoundPanel.setTimeOutTime(360000);
        commonRecordSoundPanel.setMinimumHeight((int) (ScreenUtil.SCREEN_HIGHT * 0.3f));
        commonRecordSoundPanel.setPermissionBusinessParams(QQPermissionConstants.Business.ID.QQ_RICH_MEDIA_RECORD_AUDIO, QQPermissionConstants.Business.SCENE.QQ_TROOP_HOMEWORK_NOTICE_RECORD_AUDIO);
        ((TextView) commonRecordSoundPanel.findViewById(R.id.fy8)).setTextColor(getActivity().getColor(R.color.qui_common_text_secondary));
        ((TextView) commonRecordSoundPanel.findViewById(R.id.j1o)).setTextColor(getActivity().getColor(R.color.qui_common_text_secondary));
        ((TextView) commonRecordSoundPanel.findViewById(R.id.i46)).setTextColor(getActivity().getColor(R.color.qui_common_text_secondary));
        return commonRecordSoundPanel;
    }

    private final e C9() {
        return (e) this.recordHandler.getValue();
    }

    private final void G9() {
        Activity activity = getActivity();
        if (activity == null) {
            return;
        }
        if (this.recordActionSheet == null) {
            final CommonRecordSoundPanel B9 = B9(activity, C9());
            if (B9 == null) {
                return;
            }
            ActionSheet create = ActionSheet.create(activity);
            create.addView(B9);
            create.setAnimationTime(100);
            create.getActionContentView().setGravity(17);
            create.registerWatchDisMissActionListener(new ActionSheet.WatchDismissActions() { // from class: com.tencent.mobileqq.troop.homework.common.widget.mediaedit.part.c
                @Override // com.tencent.widget.ActionSheet.WatchDismissActions
                public final void onDismissOperations() {
                    HWAudioRecordPart.H9(CommonRecordSoundPanel.this);
                }
            });
            this.recordActionSheet = create;
            this.recordCtrl = B9;
        }
        CommonRecordSoundPanel commonRecordSoundPanel = this.recordCtrl;
        if (commonRecordSoundPanel != null) {
            commonRecordSoundPanel.reset();
        }
        ActionSheet actionSheet = this.recordActionSheet;
        if (actionSheet != null) {
            actionSheet.setOutsideDismissEnableCompat(true);
            actionSheet.show();
        }
        InputMethodUtil.hide(activity);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void H9(CommonRecordSoundPanel panel) {
        Intrinsics.checkNotNullParameter(panel, "$panel");
        panel.onBackEvent();
    }

    private final void I9() {
        CommonRecordSoundPanel commonRecordSoundPanel = this.recordCtrl;
        if (commonRecordSoundPanel != null) {
            commonRecordSoundPanel.n(101);
        }
        this.recordCtrl = null;
        this.recordActionSheet = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void J9() {
        CommonRecordSoundPanel commonRecordSoundPanel = this.recordCtrl;
        if (commonRecordSoundPanel != null) {
            commonRecordSoundPanel.n(102);
        }
    }

    public final void D9() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        ActionSheet actionSheet = this.recordActionSheet;
        if (actionSheet != null) {
            actionSheet.dismiss();
        }
    }

    public final void E9(@NotNull String path) {
        long j3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) path);
            return;
        }
        Intrinsics.checkNotNullParameter(path, "path");
        CommonRecordSoundPanel commonRecordSoundPanel = this.recordCtrl;
        if (commonRecordSoundPanel == null) {
            return;
        }
        if (commonRecordSoundPanel.i() < 1000.0d) {
            commonRecordSoundPanel.reset();
            ToastUtil.a().b(R.string.po7);
            return;
        }
        ActionSheet actionSheet = this.recordActionSheet;
        if (actionSheet != null) {
            actionSheet.dismiss();
        }
        if (!NetworkUtil.isNetSupport(getActivity())) {
            ToastUtil.a().b(R.string.f171375ei3);
            return;
        }
        File file = new File(path);
        if (file.exists()) {
            j3 = file.length();
        } else {
            j3 = 0;
        }
        long j16 = j3;
        QLog.i("HW.MediaEdit.HWAudioRecordPart", 1, "handleRecordFinish, fileTime:" + commonRecordSoundPanel.i() + ", size:" + j16 + ", path:" + path);
        broadcastMessage("audio_record_finish", new a(path, j16, (long) commonRecordSoundPanel.i()));
    }

    public final void F9() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        ActionSheet actionSheet = this.recordActionSheet;
        if (actionSheet != null) {
            actionSheet.setOutsideDismissEnableCompat(false);
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void handleBroadcastMessage(@Nullable String action, @Nullable Object args) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) action, args);
        } else if (Intrinsics.areEqual(action, "start_audio_record")) {
            G9();
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    @SuppressLint({"UnspecifiedRegisterReceiverFlag"})
    public void onPartCreate(@Nullable Activity activity, @Nullable Bundle savedInstanceState) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) activity, (Object) savedInstanceState);
            return;
        }
        super.onPartCreate(activity, savedInstanceState);
        QLog.i("HW.MediaEdit.HWAudioRecordPart", 2, "onPartCreate.");
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(ITroopHWApi.ACTION_START_VIDEO_CHAT);
        intentFilter.addAction("android.intent.action.PHONE_STATE");
        Activity activity2 = getActivity();
        if (activity2 != null) {
            activity2.registerReceiver(this.receiver, intentFilter);
        }
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(@Nullable Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) activity);
            return;
        }
        super.onPartDestroy(activity);
        QLog.i("HW.MediaEdit.HWAudioRecordPart", 2, "onPartDestroy.");
        I9();
        if (activity != null) {
            activity.unregisterReceiver(this.receiver);
        }
    }
}
