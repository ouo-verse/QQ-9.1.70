package com.tencent.mobileqq.sharepanel.channel;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import androidx.fragment.app.FragmentActivity;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.app.QBaseFragment;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.ocr.data.OcrConfig;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.selectmember.ResultRecord;
import com.tencent.mobileqq.sharepanel.channel.ShareChannelHandlerFragment;
import com.tencent.mobileqq.sharepanel.launcher.SharePanelParam;
import com.tencent.mobileqq.sharepanel.m;
import com.tencent.mobileqq.sharepanel.model.SharePanelContactItem;
import com.tencent.mobileqq.sharepanel.n;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.plugins.UIJsPlugin;
import java.util.ArrayList;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000u\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n*\u0001)\u0018\u0000 :2\u00020\u0001:\u0001;B\u0013\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0012\u00a2\u0006\u0004\b8\u00109J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0002J\b\u0010\n\u001a\u00020\u0004H\u0002J\b\u0010\u000b\u001a\u00020\u0004H\u0002J\b\u0010\f\u001a\u00020\u0004H\u0002J\b\u0010\r\u001a\u00020\u0004H\u0002J\u0012\u0010\u0010\u001a\u00020\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016J\b\u0010\u0011\u001a\u00020\u0004H\u0016R\u0016\u0010\u0015\u001a\u0004\u0018\u00010\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0019\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R*\u0010\u001f\u001a\u0016\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u001aj\n\u0012\u0004\u0012\u00020\u001b\u0018\u0001`\u001c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0018\u0010#\u001a\u0004\u0018\u00010 8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u001e\u0010(\u001a\n\u0012\u0004\u0012\u00020%\u0018\u00010$8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b&\u0010'R\u0014\u0010,\u001a\u00020)8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b*\u0010+R\u001e\u00101\u001a\n\u0012\u0004\u0012\u00020.\u0018\u00010-8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b/\u00100R\u001b\u00107\u001a\u0002028BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b3\u00104\u001a\u0004\b5\u00106\u00a8\u0006<"}, d2 = {"Lcom/tencent/mobileqq/sharepanel/channel/ShareChannelHandlerFragment;", "Lcom/tencent/mobileqq/app/QBaseFragment;", "", OcrConfig.CHINESE, "", "Ch", "Ah", "Landroid/content/Intent;", "forwardIntent", "wh", "Bh", "Dh", UIJsPlugin.EVENT_SHOW_LOADING, "dismissLoading", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onCreate", "onDestroyView", "Lcom/tencent/mobileqq/sharepanel/launcher/SharePanelParam;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/sharepanel/launcher/SharePanelParam;", "sharePanelParam", "", "D", "Ljava/lang/String;", "channelId", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/selectmember/ResultRecord;", "Lkotlin/collections/ArrayList;", "E", "Ljava/util/ArrayList;", "selectedTargets", "Lcom/tencent/mobileqq/sharepanel/model/SharePanelContactItem;", UserInfo.SEX_FEMALE, "Lcom/tencent/mobileqq/sharepanel/model/SharePanelContactItem;", "forwardContact", "Lcom/tencent/mobileqq/sharepanel/channel/handler/e;", "Lcom/tencent/mobileqq/sharepanel/channel/handler/f;", "G", "Lcom/tencent/mobileqq/sharepanel/channel/handler/e;", "shareChannelHandler", "com/tencent/mobileqq/sharepanel/channel/ShareChannelHandlerFragment$b", "H", "Lcom/tencent/mobileqq/sharepanel/channel/ShareChannelHandlerFragment$b;", "forwardHandlerCallback", "Lmqq/util/WeakReference;", "Landroid/app/Dialog;", "I", "Lmqq/util/WeakReference;", "loadingDialogRef", "Landroid/os/Handler;", "J", "Lkotlin/Lazy;", "yh", "()Landroid/os/Handler;", "uiHandler", "<init>", "(Lcom/tencent/mobileqq/sharepanel/launcher/SharePanelParam;)V", "K", "a", "qq-sharepanel-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class ShareChannelHandlerFragment extends QBaseFragment {
    static IPatchRedirector $redirector_;

    /* renamed from: K, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private final SharePanelParam sharePanelParam;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private String channelId;

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private ArrayList<ResultRecord> selectedTargets;

    /* renamed from: F, reason: from kotlin metadata */
    @Nullable
    private SharePanelContactItem forwardContact;

    /* renamed from: G, reason: from kotlin metadata */
    @Nullable
    private com.tencent.mobileqq.sharepanel.channel.handler.e<com.tencent.mobileqq.sharepanel.channel.handler.f> shareChannelHandler;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private final b forwardHandlerCallback;

    /* renamed from: I, reason: from kotlin metadata */
    @Nullable
    private WeakReference<Dialog> loadingDialogRef;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    private final Lazy uiHandler;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00058\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u00058\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0007R\u0014\u0010\t\u001a\u00020\u00058\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0007R\u0014\u0010\n\u001a\u00020\u00058\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0007R\u0014\u0010\f\u001a\u00020\u000b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u00020\u000b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\r\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/sharepanel/channel/ShareChannelHandlerFragment$a;", "", "", "DELAY_SHOW_LOADING", "J", "", "KEY_CHANNEL_ID", "Ljava/lang/String;", "KEY_CONTACT", "KEY_SELECTED_TARGETS", "TAG", "", "WHAT_DISMISS_LOADING", "I", "WHAT_SHOW_LOADING", "<init>", "()V", "qq-sharepanel-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.sharepanel.channel.ShareChannelHandlerFragment$a, reason: from kotlin metadata */
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

    /* compiled from: P */
    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J(\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0016\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/sharepanel/channel/ShareChannelHandlerFragment$b", "Lcom/tencent/mobileqq/sharepanel/channel/handler/c;", "", "success", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/selectmember/ResultRecord;", "Lkotlin/collections/ArrayList;", "targetList", "", "b", "qq-sharepanel-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes18.dex */
    public static final class b extends com.tencent.mobileqq.sharepanel.channel.handler.c {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ShareChannelHandlerFragment.this);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void d(ShareChannelHandlerFragment this$0) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.Dh();
        }

        @Override // com.tencent.mobileqq.sharepanel.channel.handler.c
        public void b(boolean success, @NotNull ArrayList<ResultRecord> targetList) {
            SharePanelParam sharePanelParam;
            com.tencent.mobileqq.sharepanel.b j3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(success), targetList);
                return;
            }
            Intrinsics.checkNotNullParameter(targetList, "targetList");
            QLog.d("ShareChannelHandlerFragment", 1, "forwardResult " + success);
            if (QLog.isDevelopLevel()) {
                QLog.d("ShareChannelHandlerFragment", 1, "forwardResult targetList: " + targetList);
            }
            if (success && (sharePanelParam = ShareChannelHandlerFragment.this.sharePanelParam) != null && (j3 = sharePanelParam.j()) != null) {
                j3.a(true, targetList);
            }
            final ShareChannelHandlerFragment shareChannelHandlerFragment = ShareChannelHandlerFragment.this;
            ThreadManagerV2.checkAndRunOnUIThread(new Runnable() { // from class: com.tencent.mobileqq.sharepanel.channel.d
                @Override // java.lang.Runnable
                public final void run() {
                    ShareChannelHandlerFragment.b.d(ShareChannelHandlerFragment.this);
                }
            });
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/mobileqq/sharepanel/channel/ShareChannelHandlerFragment$c", "Lcom/tencent/mobileqq/sharepanel/m;", "Landroid/content/Intent;", "intent", "", "a", "onFail", "qq-sharepanel-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes18.dex */
    public static final class c implements m {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ShareChannelHandlerFragment.this);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void c(ShareChannelHandlerFragment this$0) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.Dh();
        }

        @Override // com.tencent.mobileqq.sharepanel.m
        public void a(@Nullable Intent intent) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) intent);
            } else if (intent != null) {
                ShareChannelHandlerFragment.this.dismissLoading();
                ShareChannelHandlerFragment.this.wh(intent);
            } else {
                onFail();
            }
        }

        @Override // com.tencent.mobileqq.sharepanel.m
        public void onFail() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this);
                return;
            }
            QLog.e("ShareChannelHandlerFragment", 1, "prepareForwardData onFail");
            ShareChannelHandlerFragment.this.dismissLoading();
            final ShareChannelHandlerFragment shareChannelHandlerFragment = ShareChannelHandlerFragment.this;
            ThreadManagerV2.checkAndRunOnUIThread(new Runnable() { // from class: com.tencent.mobileqq.sharepanel.channel.e
                @Override // java.lang.Runnable
                public final void run() {
                    ShareChannelHandlerFragment.c.c(ShareChannelHandlerFragment.this);
                }
            });
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(32089);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public ShareChannelHandlerFragment() {
        this(null, 1, 0 == true ? 1 : 0);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) {
            return;
        }
        iPatchRedirector.redirect((short) 5, (Object) this);
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0039, code lost:
    
        r0 = kotlin.collections.CollectionsKt__CollectionsKt.arrayListOf(new com.tencent.mobileqq.selectmember.ResultRecord(r0.e(), r0.b(), r0.f(), r0.a()));
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void Ah() {
        n nVar;
        ArrayList<ResultRecord> arrayList;
        n p16;
        Intent f16;
        com.tencent.mobileqq.sharepanel.channel.handler.e<com.tencent.mobileqq.sharepanel.channel.handler.f> eVar = this.shareChannelHandler;
        if (eVar != null) {
            eVar.e(this.forwardHandlerCallback);
        }
        SharePanelParam sharePanelParam = this.sharePanelParam;
        if (sharePanelParam != null && (f16 = sharePanelParam.f()) != null) {
            wh(f16);
            return;
        }
        SharePanelParam sharePanelParam2 = this.sharePanelParam;
        if (sharePanelParam2 != null) {
            nVar = sharePanelParam2.p();
        } else {
            nVar = null;
        }
        if (nVar == null) {
            QLog.e("ShareChannelHandlerFragment", 1, "prepareForwardParam prepareForwardHandler is null");
            Dh();
            return;
        }
        showLoading();
        SharePanelContactItem sharePanelContactItem = this.forwardContact;
        if ((sharePanelContactItem == null || arrayList == null) && (arrayList = this.selectedTargets) == null) {
            arrayList = new ArrayList<>();
        }
        SharePanelParam sharePanelParam3 = this.sharePanelParam;
        if (sharePanelParam3 != null && (p16 = sharePanelParam3.p()) != null) {
            p16.a(arrayList, new c());
        }
    }

    private final void Ch() {
        if (!Intrinsics.areEqual(this.channelId, "qqfriend") && !Intrinsics.areEqual(this.channelId, "directForward")) {
            Bh();
        } else {
            Ah();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Dh() {
        FragmentActivity activity = getActivity();
        if (activity != null && !activity.isFinishing() && !activity.isDestroyed()) {
            try {
                activity.getSupportFragmentManager().beginTransaction().remove(this).commitAllowingStateLoss();
            } catch (Exception e16) {
                QLog.e("ShareChannelHandlerFragment", 1, "removeFragment error ", e16);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void dismissLoading() {
        yh().removeMessages(1);
        yh().sendEmptyMessage(2);
    }

    private final void showLoading() {
        yh().removeMessages(1);
        yh().removeMessages(2);
        yh().sendEmptyMessageDelayed(1, 1000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void wh(Intent forwardIntent) {
        com.tencent.mobileqq.sharepanel.channel.handler.f fVar;
        String str = this.channelId;
        if (Intrinsics.areEqual(str, "qqfriend")) {
            ArrayList<ResultRecord> arrayList = this.selectedTargets;
            SharePanelParam sharePanelParam = this.sharePanelParam;
            boolean z16 = false;
            if (sharePanelParam != null && sharePanelParam.z()) {
                z16 = true;
            }
            fVar = new com.tencent.mobileqq.sharepanel.channel.param.b(forwardIntent, arrayList, z16);
        } else if (Intrinsics.areEqual(str, "directForward")) {
            fVar = new com.tencent.mobileqq.sharepanel.channel.param.a(forwardIntent, this.forwardContact);
        } else {
            fVar = null;
        }
        if (fVar == null) {
            QLog.e("ShareChannelHandlerFragment", 1, "dealForwardChannel channelHandlerParam is null");
            ThreadManagerV2.checkAndRunOnUIThread(new Runnable() { // from class: com.tencent.mobileqq.sharepanel.channel.c
                @Override // java.lang.Runnable
                public final void run() {
                    ShareChannelHandlerFragment.xh(ShareChannelHandlerFragment.this);
                }
            });
        } else {
            com.tencent.mobileqq.sharepanel.channel.handler.e<com.tencent.mobileqq.sharepanel.channel.handler.f> eVar = this.shareChannelHandler;
            if (eVar != null) {
                eVar.c(fVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void xh(ShareChannelHandlerFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.Dh();
    }

    private final Handler yh() {
        return (Handler) this.uiHandler.getValue();
    }

    private final boolean zh() {
        com.tencent.mobileqq.sharepanel.channel.handler.e<com.tencent.mobileqq.sharepanel.channel.handler.f> a16 = com.tencent.mobileqq.sharepanel.channel.b.f287179a.a(this.channelId);
        if (a16 != null) {
            a16.d(new WeakReference<>(getActivity()));
        } else {
            a16 = null;
        }
        this.shareChannelHandler = a16;
        if (a16 != null) {
            return true;
        }
        QLog.e("ShareChannelHandlerFragment", 1, "shareChannelHandler is null, channelId:" + this.channelId);
        Dh();
        return false;
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle savedInstanceState) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) savedInstanceState);
            return;
        }
        super.onCreate(savedInstanceState);
        Bundle arguments = getArguments();
        if (arguments != null) {
            String string = arguments.getString("channelId", "");
            Intrinsics.checkNotNullExpressionValue(string, "getString(KEY_CHANNEL_ID, \"\")");
            this.channelId = string;
            this.selectedTargets = arguments.getParcelableArrayList("selectedTargets");
            this.forwardContact = (SharePanelContactItem) arguments.getParcelable("contact");
        }
        if (this.sharePanelParam == null) {
            Dh();
        } else if (zh()) {
            Ch();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            super.onDestroyView();
            dismissLoading();
        }
    }

    public ShareChannelHandlerFragment(@Nullable SharePanelParam sharePanelParam) {
        Lazy lazy;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) sharePanelParam);
            return;
        }
        this.sharePanelParam = sharePanelParam;
        this.channelId = "";
        this.forwardHandlerCallback = new b();
        lazy = LazyKt__LazyJVMKt.lazy(new ShareChannelHandlerFragment$uiHandler$2(this));
        this.uiHandler = lazy;
    }

    public /* synthetic */ ShareChannelHandlerFragment(SharePanelParam sharePanelParam, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? null : sharePanelParam);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, sharePanelParam, Integer.valueOf(i3), defaultConstructorMarker);
    }

    private final void Bh() {
    }
}
