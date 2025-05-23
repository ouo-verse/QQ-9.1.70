package com.tencent.mobileqq.sharepanel.launcher.ipc;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.mobileqq.app.QBaseFragment;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.ocr.data.OcrConfig;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.selectmember.ResultRecord;
import com.tencent.mobileqq.sharepanel.api.ISharePanelApi;
import com.tencent.mobileqq.sharepanel.launcher.ShareActionDynamicModifier;
import com.tencent.mobileqq.sharepanel.launcher.SharePanelParam;
import com.tencent.mobileqq.sharepanel.launcher.ipc.a;
import com.tencent.mobileqq.sharepanel.model.ShareConfirmAction;
import com.tencent.mobileqq.sharepanel.model.SharePanelContactItem;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u0000 02\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u00011B\u0007\u00a2\u0006\u0004\b.\u0010/J\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0018\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0006H\u0002J\b\u0010\f\u001a\u00020\bH\u0002J\u0010\u0010\u000f\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\rH\u0002J\b\u0010\u0010\u001a\u00020\bH\u0002J\u0012\u0010\u0012\u001a\u00020\b2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0006H\u0016J\b\u0010\u0013\u001a\u00020\bH\u0016J\u000e\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\u0014J\u0006\u0010\u0017\u001a\u00020\bJ\u000e\u0010\u001a\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\u0018J\u0016\u0010\u001f\u001a\u00020\b2\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001e\u001a\u00020\u001dJ \u0010\"\u001a\u00020\b2\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001e\u001a\u00020\u001d2\b\u0010!\u001a\u0004\u0018\u00010 J\u0014\u0010%\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030$0#H\u0016J\u0012\u0010'\u001a\u00020\b2\b\u0010&\u001a\u0004\u0018\u00010\u0003H\u0016R\u0018\u0010*\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b(\u0010)R\u0018\u0010-\u001a\u0004\u0018\u00010\u001b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b+\u0010,\u00a8\u00062"}, d2 = {"Lcom/tencent/mobileqq/sharepanel/launcher/ipc/SharePanelIPCClientFragment;", "Lcom/tencent/mobileqq/app/QBaseFragment;", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "", "action", "Landroid/os/Bundle;", "bundle", "", "Ah", "params", "Gh", "Eh", "Ljava/lang/Runnable;", "runnable", "Ph", "release", Constants.FILE_INSTANCE_STATE, "onCreate", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Lcom/tencent/mobileqq/sharepanel/launcher/SharePanelParam;", "param", "Qh", "dismiss", "Lcom/tencent/mobileqq/sharepanel/launcher/ShareActionDynamicModifier;", "modifier", "Dh", "", "callbackId", "", "success", "Ch", "Landroid/content/Intent;", "intent", OcrConfig.CHINESE, "Ljava/util/ArrayList;", "Ljava/lang/Class;", "getEventClass", "event", "onReceiveEvent", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/sharepanel/launcher/SharePanelParam;", "sharePanelParam", "D", "Ljava/lang/Integer;", "curClientSeq", "<init>", "()V", "E", "a", "qq-sharepanel-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class SharePanelIPCClientFragment extends QBaseFragment implements SimpleEventReceiver<SimpleBaseEvent> {
    static IPatchRedirector $redirector_;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    @NotNull
    private static AtomicInteger F;

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private SharePanelParam sharePanelParam;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private Integer curClientSeq;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0006\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/sharepanel/launcher/ipc/SharePanelIPCClientFragment$a;", "", "", "TAG", "Ljava/lang/String;", "Ljava/util/concurrent/atomic/AtomicInteger;", "clientSeq", "Ljava/util/concurrent/atomic/AtomicInteger;", "<init>", "()V", "qq-sharepanel-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.sharepanel.launcher.ipc.SharePanelIPCClientFragment$a, reason: from kotlin metadata */
    /* loaded from: classes18.dex */
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

    @Metadata(d1 = {"\u0000+\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\b\u0010\t\u001a\u00020\u0004H\u0016J\"\u0010\u000e\u001a\u00020\u00042\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\n2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016J\u0018\u0010\u000f\u001a\u00020\u00042\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\nH\u0016\u00a8\u0006\u0010"}, d2 = {"com/tencent/mobileqq/sharepanel/launcher/ipc/SharePanelIPCClientFragment$b", "Lcom/tencent/mobileqq/sharepanel/launcher/ipc/a$a;", "Landroid/graphics/Bitmap;", "y2", "", "G0", "Lcom/tencent/mobileqq/selectmember/ResultRecord;", "contact", com.tencent.bugly.common.constants.Constants.BASE_IN_HOTFIX, "i0", "", "targetList", "", "leaveMsg", "J", "l", "qq-sharepanel-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes18.dex */
    public static final class b extends a.AbstractBinderC8586a {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ SharePanelParam f287361d;

        b(SharePanelParam sharePanelParam) {
            this.f287361d = sharePanelParam;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) sharePanelParam);
            }
        }

        @Override // com.tencent.mobileqq.sharepanel.launcher.ipc.a
        public boolean D4(@Nullable ResultRecord contact) {
            boolean z16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, (Object) contact)).booleanValue();
            }
            if (contact == null) {
                return false;
            }
            com.tencent.mobileqq.sharepanel.e r16 = this.f287361d.r();
            if (r16 != null && !r16.a(contact)) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                return false;
            }
            return true;
        }

        @Override // com.tencent.mobileqq.sharepanel.launcher.ipc.a
        public boolean G0() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
            }
            if (this.f287361d.r() != null) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.mobileqq.sharepanel.launcher.ipc.a
        public boolean J(@Nullable List<ResultRecord> targetList, @Nullable String leaveMsg) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this, (Object) targetList, (Object) leaveMsg)).booleanValue();
            }
            com.tencent.mobileqq.sharepanel.d g16 = this.f287361d.g();
            if (g16 == null) {
                return false;
            }
            if (targetList == null) {
                targetList = CollectionsKt__CollectionsKt.emptyList();
            }
            if (leaveMsg == null) {
                leaveMsg = "";
            }
            if (!g16.J(targetList, leaveMsg)) {
                return false;
            }
            return true;
        }

        @Override // com.tencent.mobileqq.sharepanel.launcher.ipc.a
        public boolean i0() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
            }
            if (this.f287361d.g() != null) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.mobileqq.sharepanel.launcher.ipc.a
        public boolean l(@Nullable List<ResultRecord> targetList) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this, (Object) targetList)).booleanValue();
            }
            com.tencent.mobileqq.sharepanel.d g16 = this.f287361d.g();
            if (g16 == null) {
                return false;
            }
            if (targetList == null) {
                targetList = CollectionsKt__CollectionsKt.emptyList();
            }
            if (!g16.l(targetList)) {
                return false;
            }
            return true;
        }

        @Override // com.tencent.mobileqq.sharepanel.launcher.ipc.a
        @Nullable
        public Bitmap y2() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (Bitmap) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return this.f287361d.q();
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(37695);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 11)) {
            redirector.redirect((short) 11);
        } else {
            INSTANCE = new Companion(null);
            F = new AtomicInteger(1);
        }
    }

    public SharePanelIPCClientFragment() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final void Ah(final String action, final Bundle bundle) {
        Integer num = this.curClientSeq;
        if (num != null) {
            final int intValue = num.intValue();
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.sharepanel.launcher.ipc.j
                @Override // java.lang.Runnable
                public final void run() {
                    SharePanelIPCClientFragment.Bh(action, intValue, bundle);
                }
            }, 16, null, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Bh(String action, int i3, Bundle bundle) {
        Intrinsics.checkNotNullParameter(action, "$action");
        Intrinsics.checkNotNullParameter(bundle, "$bundle");
        try {
            String str = BaseApplication.processName;
            if (str == null) {
                str = "";
            }
            QLog.i("SharePanelIPCClientFragment", 1, "callServer action: " + action + " process: " + str + " seq: " + i3);
            bundle.putInt("seq", i3);
            bundle.putString("process", str);
            QIPCClientHelper.getInstance().callServer(ISharePanelApi.IPC_MODULE_ID, action, bundle);
        } catch (Exception e16) {
            QLog.e("SharePanelIPCClientFragment", 1, "callServer: ", e16);
        }
    }

    private final void Eh() {
        release();
        Ph(new Runnable() { // from class: com.tencent.mobileqq.sharepanel.launcher.ipc.k
            @Override // java.lang.Runnable
            public final void run() {
                SharePanelIPCClientFragment.Fh(SharePanelIPCClientFragment.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Fh(SharePanelIPCClientFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        FragmentActivity activity = this$0.getActivity();
        if (activity != null && !activity.isFinishing() && !activity.isDestroyed()) {
            try {
                activity.getSupportFragmentManager().beginTransaction().remove(this$0).commitAllowingStateLoss();
            } catch (Exception e16) {
                QLog.e("SharePanelIPCClientFragment", 1, "removeSelf: ", e16);
            }
        }
    }

    private final void Gh(String action, final Bundle params) {
        com.tencent.mobileqq.sharepanel.n p16;
        com.tencent.mobileqq.sharepanel.b j3;
        com.tencent.mobileqq.sharepanel.channel.a v3;
        if (this.sharePanelParam == null) {
            QLog.e("SharePanelIPCClientFragment", 1, "receiveFromServer sharePanelParam is null");
            return;
        }
        int i3 = params.getInt("seq");
        Integer num = this.curClientSeq;
        if (num == null || i3 != num.intValue()) {
            return;
        }
        QLog.i("SharePanelIPCClientFragment", 1, "receiveFromServer action:" + action + " params:" + params);
        switch (action.hashCode()) {
            case -1401315045:
                if (action.equals(MosaicConstants$JsFunction.FUNC_ON_DESTROY)) {
                    Eh();
                    return;
                }
                return;
            case -1287015509:
                if (action.equals("onDismiss")) {
                    Ph(new Runnable() { // from class: com.tencent.mobileqq.sharepanel.launcher.ipc.c
                        @Override // java.lang.Runnable
                        public final void run() {
                            SharePanelIPCClientFragment.Kh(SharePanelIPCClientFragment.this);
                        }
                    });
                    return;
                }
                return;
            case -1184811715:
                if (action.equals("onDisabledAppendActionClick")) {
                    Ph(new Runnable() { // from class: com.tencent.mobileqq.sharepanel.launcher.ipc.h
                        @Override // java.lang.Runnable
                        public final void run() {
                            SharePanelIPCClientFragment.Hh(params, this);
                        }
                    });
                    return;
                }
                return;
            case -1012968068:
                if (action.equals("onShow")) {
                    Ph(new Runnable() { // from class: com.tencent.mobileqq.sharepanel.launcher.ipc.b
                        @Override // java.lang.Runnable
                        public final void run() {
                            SharePanelIPCClientFragment.Jh(SharePanelIPCClientFragment.this);
                        }
                    });
                    return;
                }
                return;
            case 25540542:
                if (action.equals("prepareForward")) {
                    int i16 = params.getInt("callbackId");
                    ArrayList<ResultRecord> parcelableArrayList = params.getParcelableArrayList("selectedTarget");
                    if (parcelableArrayList == null) {
                        parcelableArrayList = new ArrayList<>();
                    }
                    SharePanelParam sharePanelParam = this.sharePanelParam;
                    if (sharePanelParam != null && (p16 = sharePanelParam.p()) != null) {
                        p16.a(parcelableArrayList, new u(this, i16));
                        return;
                    } else {
                        QLog.e("SharePanelIPCClientFragment", 1, "prepareForwardHandler is null");
                        zh(i16, false, null);
                        return;
                    }
                }
                return;
            case 421217187:
                if (action.equals("onForwardResult")) {
                    boolean z16 = params.getBoolean("success", true);
                    List<? extends ResultRecord> parcelableArrayList2 = params.getParcelableArrayList("selectedTarget");
                    if (parcelableArrayList2 == null) {
                        parcelableArrayList2 = CollectionsKt__CollectionsKt.emptyList();
                    }
                    SharePanelParam sharePanelParam2 = this.sharePanelParam;
                    if (sharePanelParam2 != null && (j3 = sharePanelParam2.j()) != null) {
                        j3.a(z16, parcelableArrayList2);
                        return;
                    }
                    return;
                }
                return;
            case 532899297:
                if (action.equals("shareConfirm")) {
                    final int i17 = params.getInt("callbackId");
                    final ShareConfirmAction shareConfirmAction = (ShareConfirmAction) params.getParcelable("shareConfirmAction");
                    if (shareConfirmAction == null) {
                        QLog.e("SharePanelIPCClientFragment", 1, "shareConfirm action is null");
                        Ch(i17, false);
                        return;
                    } else {
                        Ph(new Runnable() { // from class: com.tencent.mobileqq.sharepanel.launcher.ipc.i
                            @Override // java.lang.Runnable
                            public final void run() {
                                SharePanelIPCClientFragment.Ih(SharePanelIPCClientFragment.this, i17, shareConfirmAction);
                            }
                        });
                        return;
                    }
                }
                return;
            case 736402341:
                if (action.equals("onShareChannelClick")) {
                    Ph(new Runnable() { // from class: com.tencent.mobileqq.sharepanel.launcher.ipc.e
                        @Override // java.lang.Runnable
                        public final void run() {
                            SharePanelIPCClientFragment.Mh(params, this);
                        }
                    });
                    return;
                }
                return;
            case 1030686009:
                if (action.equals("onCancel")) {
                    Ph(new Runnable() { // from class: com.tencent.mobileqq.sharepanel.launcher.ipc.d
                        @Override // java.lang.Runnable
                        public final void run() {
                            SharePanelIPCClientFragment.Lh(SharePanelIPCClientFragment.this);
                        }
                    });
                    return;
                }
                return;
            case 1486773163:
                if (action.equals("onShareChannelHandle")) {
                    String string = params.getString("channelId");
                    if (string == null) {
                        string = "";
                    }
                    ArrayList<ResultRecord> parcelableArrayList3 = params.getParcelableArrayList("selectedTarget");
                    SharePanelContactItem sharePanelContactItem = (SharePanelContactItem) params.getParcelable("contact");
                    boolean z17 = params.getBoolean("supportMulti", true);
                    Intent intent = (Intent) params.getParcelable("forwardIntent");
                    SharePanelParam sharePanelParam3 = this.sharePanelParam;
                    if (sharePanelParam3 != null) {
                        sharePanelParam3.n0(z17);
                        sharePanelParam3.F(intent);
                    }
                    SharePanelParam sharePanelParam4 = this.sharePanelParam;
                    if (sharePanelParam4 != null && (v3 = sharePanelParam4.v()) != null) {
                        v3.a(sharePanelParam4, string, sharePanelContactItem, parcelableArrayList3);
                        return;
                    }
                    return;
                }
                return;
            case 1817311113:
                if (action.equals("onDisabledShareChannelClick")) {
                    Ph(new Runnable() { // from class: com.tencent.mobileqq.sharepanel.launcher.ipc.f
                        @Override // java.lang.Runnable
                        public final void run() {
                            SharePanelIPCClientFragment.Nh(params, this);
                        }
                    });
                    return;
                }
                return;
            case 2029246809:
                if (action.equals("onAppendActionClick")) {
                    Ph(new Runnable() { // from class: com.tencent.mobileqq.sharepanel.launcher.ipc.g
                        @Override // java.lang.Runnable
                        public final void run() {
                            SharePanelIPCClientFragment.Oh(params, this);
                        }
                    });
                    return;
                }
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Hh(Bundle params, SharePanelIPCClientFragment this$0) {
        com.tencent.mobileqq.sharepanel.h m3;
        Intrinsics.checkNotNullParameter(params, "$params");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        String string = params.getString("actionId");
        if (string == null) {
            string = "";
        }
        SharePanelParam sharePanelParam = this$0.sharePanelParam;
        if (sharePanelParam != null && (m3 = sharePanelParam.m()) != null) {
            m3.a(string);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ih(SharePanelIPCClientFragment this$0, int i3, ShareConfirmAction shareConfirmAction) {
        com.tencent.mobileqq.sharepanel.p x16;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        SharePanelParam sharePanelParam = this$0.sharePanelParam;
        if (sharePanelParam != null && (x16 = sharePanelParam.x()) != null) {
            x16.a(shareConfirmAction, new v(this$0, i3));
        } else {
            this$0.Ch(i3, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Jh(SharePanelIPCClientFragment this$0) {
        com.tencent.mobileqq.sharepanel.l o16;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        SharePanelParam sharePanelParam = this$0.sharePanelParam;
        if (sharePanelParam != null && (o16 = sharePanelParam.o()) != null) {
            o16.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Kh(SharePanelIPCClientFragment this$0) {
        com.tencent.mobileqq.sharepanel.k n3;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        SharePanelParam sharePanelParam = this$0.sharePanelParam;
        if (sharePanelParam != null && (n3 = sharePanelParam.n()) != null) {
            n3.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Lh(SharePanelIPCClientFragment this$0) {
        com.tencent.mobileqq.sharepanel.i k3;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        SharePanelParam sharePanelParam = this$0.sharePanelParam;
        if (sharePanelParam != null && (k3 = sharePanelParam.k()) != null) {
            k3.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Mh(Bundle params, SharePanelIPCClientFragment this$0) {
        com.tencent.mobileqq.sharepanel.j l3;
        Intrinsics.checkNotNullParameter(params, "$params");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        String string = params.getString("channelId");
        if (string == null) {
            string = "";
        }
        SharePanelParam sharePanelParam = this$0.sharePanelParam;
        if (sharePanelParam != null && (l3 = sharePanelParam.l()) != null) {
            l3.a(string);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Nh(Bundle params, SharePanelIPCClientFragment this$0) {
        com.tencent.mobileqq.sharepanel.h m3;
        Intrinsics.checkNotNullParameter(params, "$params");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        String string = params.getString("channelId");
        if (string == null) {
            string = "";
        }
        SharePanelParam sharePanelParam = this$0.sharePanelParam;
        if (sharePanelParam != null && (m3 = sharePanelParam.m()) != null) {
            m3.b(string);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Oh(Bundle params, SharePanelIPCClientFragment this$0) {
        com.tencent.mobileqq.sharepanel.j l3;
        Intrinsics.checkNotNullParameter(params, "$params");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        String string = params.getString("actionId");
        if (string == null) {
            string = "";
        }
        SharePanelParam sharePanelParam = this$0.sharePanelParam;
        if (sharePanelParam != null && (l3 = sharePanelParam.l()) != null) {
            l3.b(string);
        }
    }

    private final void Ph(Runnable runnable) {
        ThreadManagerV2.checkAndRunOnUIThread(runnable);
    }

    private final void release() {
        this.sharePanelParam = null;
        this.curClientSeq = null;
    }

    public final void Ch(int callbackId, boolean success) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, Integer.valueOf(callbackId), Boolean.valueOf(success));
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putInt("callbackId", callbackId);
        bundle.putBoolean("success", success);
        Unit unit = Unit.INSTANCE;
        Ah("shareConfirmResult", bundle);
    }

    public final void Dh(@NotNull ShareActionDynamicModifier modifier) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) modifier);
            return;
        }
        Intrinsics.checkNotNullParameter(modifier, "modifier");
        Bundle bundle = new Bundle();
        bundle.putParcelable("dynamicModifier", modifier);
        Ah("dynamicModify", bundle);
    }

    public final void Qh(@NotNull SharePanelParam param) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) param);
            return;
        }
        Intrinsics.checkNotNullParameter(param, "param");
        if (this.sharePanelParam != null) {
            dismiss();
            this.sharePanelParam = null;
        }
        this.sharePanelParam = param;
        this.curClientSeq = Integer.valueOf(F.getAndIncrement());
        Bundle bundle = new Bundle();
        bundle.putParcelable("showParam", param);
        if (param.q() != null || param.r() != null || param.g() != null) {
            bundle.putBinder("binderParam", new b(param));
        }
        Ah("showPanel", bundle);
        l.f287393d.b();
    }

    public final void dismiss() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        } else {
            Ah("dismissPanel", new Bundle());
            release();
        }
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    @NotNull
    public ArrayList<Class<SimpleBaseEvent>> getEventClass() {
        ArrayList<Class<SimpleBaseEvent>> arrayListOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 9)) {
            arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(SharePanelIPCClientEvent.class);
            return arrayListOf;
        }
        return (ArrayList) iPatchRedirector.redirect((short) 9, (Object) this);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle savedInstanceState) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) savedInstanceState);
        } else {
            super.onCreate(savedInstanceState);
            SimpleEventBus.getInstance().registerReceiver(this);
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        super.onDestroy();
        release();
        SimpleEventBus.getInstance().unRegisterReceiver(this);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(@Nullable SimpleBaseEvent event) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) event);
        } else if (event instanceof SharePanelIPCClientEvent) {
            SharePanelIPCClientEvent sharePanelIPCClientEvent = (SharePanelIPCClientEvent) event;
            Gh(sharePanelIPCClientEvent.getAction(), sharePanelIPCClientEvent.getParams());
        }
    }

    public final void zh(int callbackId, boolean success, @Nullable Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, Integer.valueOf(callbackId), Boolean.valueOf(success), intent);
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putInt("callbackId", callbackId);
        bundle.putBoolean("success", success);
        if (intent != null) {
            bundle.putParcelable("forwardIntent", intent);
        }
        Unit unit = Unit.INSTANCE;
        Ah("prepareForwardResult", bundle);
    }
}
