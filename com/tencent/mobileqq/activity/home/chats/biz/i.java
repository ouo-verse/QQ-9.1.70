package com.tencent.mobileqq.activity.home.chats.biz;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.RelativeLayout;
import com.heytap.databaseengine.model.UserInfo;
import com.qqnt.widget.smartrefreshlayout.layout.constant.RefreshState;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.home.view.TitleAreaHeadLayout;
import com.tencent.mobileqq.app.LocaleManager;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.resconfig.MainResourceConfig;
import com.tencent.mobileqq.springhb.entry.SpringFestivalEntryManager;
import com.tencent.mobileqq.util.af;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.chats.config.ChatsListConfig;
import com.tencent.qqnt.chats.view.AnimRefreshHeaderView;
import com.tencent.qqnt.chats.view.MiniOldStyleHeader;
import com.tencent.qqnt.chats.view.MiniOldStyleHeaderNew;
import com.tencent.qqnt.chats.view.QQChatListTwoLevelHeader;
import com.tencent.qqnt.kernel.api.IKernelService;
import com.tencent.qqnt.kernel.nativeinterface.CustomWithdrawConfig;
import com.tencent.qqnt.kernel.nativeinterface.DownloadRelateEmojiResultInfo;
import com.tencent.qqnt.kernel.nativeinterface.EmojiNotifyInfo;
import com.tencent.qqnt.kernel.nativeinterface.EmojiResourceInfo;
import com.tencent.qqnt.kernel.nativeinterface.FileTransNotifyInfo;
import com.tencent.qqnt.kernel.nativeinterface.GroupFileListResult;
import com.tencent.qqnt.kernel.nativeinterface.GroupItem;
import com.tencent.qqnt.kernel.nativeinterface.HitRelatedEmojiWordsResult;
import com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener;
import com.tencent.qqnt.kernel.nativeinterface.ImportOldDbMsgNotifyInfo;
import com.tencent.qqnt.kernel.nativeinterface.InputStatusInfo;
import com.tencent.qqnt.kernel.nativeinterface.KickedInfo;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.qqnt.kernel.nativeinterface.MsgSetting;
import com.tencent.qqnt.kernel.nativeinterface.QueryUserSecQualityRsp;
import com.tencent.qqnt.kernel.nativeinterface.RecvdOrder;
import com.tencent.qqnt.kernel.nativeinterface.RelatedWordEmojiInfo;
import com.tencent.qqnt.kernel.nativeinterface.SearchGroupFileResult;
import com.tencent.qqnt.kernel.nativeinterface.TempChatInfo;
import com.tencent.qqnt.kernel.nativeinterface.ax;
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.manager.Manager;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00ac\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 g2\u00020\u0001:\u0003hijB\u000f\u0012\u0006\u0010d\u001a\u00020c\u00a2\u0006\u0004\be\u0010fJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J0\u0010\u000e\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\tH\u0002J,\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u00102\b\b\u0002\u0010\u0012\u001a\u00020\u00102\b\b\u0002\u0010\u0013\u001a\u00020\u0010H\u0002J,\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u00102\b\b\u0002\u0010\u0012\u001a\u00020\u00102\b\b\u0002\u0010\u0013\u001a\u00020\u0010H\u0002J\u0018\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\u0016H\u0002J\u0010\u0010\u001b\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u0019H\u0002J\u0010\u0010\u001e\u001a\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u001cH\u0002J\b\u0010 \u001a\u00020\u001fH\u0016J\u0006\u0010!\u001a\u00020\u0002J\u0012\u0010#\u001a\u00020\u00022\b\u0010\"\u001a\u0004\u0018\u00010\tH\u0016J\u0010\u0010&\u001a\u00020\u00022\u0006\u0010%\u001a\u00020$H\u0016J\b\u0010'\u001a\u00020\u001fH\u0016J\u000e\u0010*\u001a\u00020\u00022\u0006\u0010)\u001a\u00020(J\b\u0010+\u001a\u00020\u0002H\u0016J\u0010\u0010,\u001a\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u001cH\u0016J\u000e\u0010/\u001a\u00020\u00022\u0006\u0010.\u001a\u00020-J\u000e\u00102\u001a\u00020\u00022\u0006\u00101\u001a\u000200J\b\u00103\u001a\u00020\u0002H\u0016J\u0006\u00104\u001a\u00020\u0002J\u0006\u00105\u001a\u00020\u0002R\"\u0010=\u001a\u0002068\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b7\u00108\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<R\"\u0010D\u001a\u00020\u00048\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b>\u0010?\u001a\u0004\b@\u0010A\"\u0004\bB\u0010CR\"\u0010L\u001a\u00020E8\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\bF\u0010G\u001a\u0004\bH\u0010I\"\u0004\bJ\u0010KR\u001c\u0010P\u001a\b\u0012\u0004\u0012\u00020-0M8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bN\u0010OR\u0016\u0010T\u001a\u00020Q8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bR\u0010SR\u0018\u0010X\u001a\u0004\u0018\u00010U8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bV\u0010WR\u0014\u0010\\\u001a\u00020Y8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bZ\u0010[R\u0018\u0010)\u001a\u0004\u0018\u00010(8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b]\u0010^R\u0018\u0010b\u001a\u0004\u0018\u00010_8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b`\u0010a\u00a8\u0006k"}, d2 = {"Lcom/tencent/mobileqq/activity/home/chats/biz/i;", "Lcom/tencent/mobileqq/activity/home/chats/biz/d;", "", "Fa", "Lcom/tencent/qqnt/chats/view/QQChatListTwoLevelHeader;", "header", "Pa", "Lcom/qqnt/widget/smartrefreshlayout/layout/constant/RefreshState;", "newState", "Landroid/view/View;", "topBar", "headerRoot", "tabContainer", "tabBlur", "Aa", "v", "", "cur", "startHidePos", "endHidePos", "Qa", "Sa", "", "visibility", "La", "", "delayMillis", "Na", "Lmqq/app/AppRuntime;", "app", "Ga", "", "getLogTag", "xa", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "onPartDestroy", "ea", "Lcom/tencent/qqnt/chats/core/ui/listener/b;", "refreshListener", "Ia", "I9", "K9", "Lcom/tencent/mobileqq/activity/home/chats/biz/i$b;", "onStateChange", "ua", "", "enableTwoLevel", "Oa", "onPostThemeChanged", "Ma", "wa", "Lcom/tencent/qqnt/chats/core/ui/refresh/c;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/qqnt/chats/core/ui/refresh/c;", "Ca", "()Lcom/tencent/qqnt/chats/core/ui/refresh/c;", "Ha", "(Lcom/tencent/qqnt/chats/core/ui/refresh/c;)V", "chatListRefreshVB", "D", "Lcom/tencent/qqnt/chats/view/QQChatListTwoLevelHeader;", "Da", "()Lcom/tencent/qqnt/chats/view/QQChatListTwoLevelHeader;", "Ja", "(Lcom/tencent/qqnt/chats/view/QQChatListTwoLevelHeader;)V", "miniProgramHeader", "Lcom/tencent/qqnt/chats/view/AnimRefreshHeaderView;", "E", "Lcom/tencent/qqnt/chats/view/AnimRefreshHeaderView;", "Ea", "()Lcom/tencent/qqnt/chats/view/AnimRefreshHeaderView;", "Ka", "(Lcom/tencent/qqnt/chats/view/AnimRefreshHeaderView;)V", "refresh", "Ljava/util/concurrent/CopyOnWriteArrayList;", UserInfo.SEX_FEMALE, "Ljava/util/concurrent/CopyOnWriteArrayList;", "onStateChangeList", "Landroid/os/Handler;", "G", "Landroid/os/Handler;", "refreshHandler", "Landroid/animation/AnimatorSet;", "H", "Landroid/animation/AnimatorSet;", "curAnimSet", "Ljava/lang/Runnable;", "I", "Ljava/lang/Runnable;", "autoFinishRunnable", "J", "Lcom/tencent/qqnt/chats/core/ui/listener/b;", "Lcom/tencent/mobileqq/activity/home/chats/biz/i$c;", "K", "Lcom/tencent/mobileqq/activity/home/chats/biz/i$c;", "msgListener", "Lcom/tencent/mobileqq/activity/home/chats/callbcak/a;", "para", "<init>", "(Lcom/tencent/mobileqq/activity/home/chats/callbcak/a;)V", "L", "a", "b", "c", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class i extends com.tencent.mobileqq.activity.home.chats.biz.d {
    static IPatchRedirector $redirector_;

    /* renamed from: L, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    public com.tencent.qqnt.chats.core.ui.refresh.c chatListRefreshVB;

    /* renamed from: D, reason: from kotlin metadata */
    public QQChatListTwoLevelHeader miniProgramHeader;

    /* renamed from: E, reason: from kotlin metadata */
    public AnimRefreshHeaderView refresh;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private CopyOnWriteArrayList<b> onStateChangeList;

    /* renamed from: G, reason: from kotlin metadata */
    private Handler refreshHandler;

    /* renamed from: H, reason: from kotlin metadata */
    @Nullable
    private AnimatorSet curAnimSet;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private final Runnable autoFinishRunnable;

    /* renamed from: J, reason: from kotlin metadata */
    @Nullable
    private com.tencent.qqnt.chats.core.ui.listener.b refreshListener;

    /* renamed from: K, reason: from kotlin metadata */
    @Nullable
    private c msgListener;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\t\u0010\bR\u0014\u0010\u000b\u001a\u00020\n8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\n8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\r\u0010\fR\u0014\u0010\u000e\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\bR\u0014\u0010\u000f\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0004R\u0014\u0010\u0010\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\b\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/activity/home/chats/biz/i$a;", "", "", "BASE_OFFSET", "I", "BOTTOM_DUR", "", "REFRESH_TRIGGER_RATE", UserInfo.SEX_FEMALE, "REFRESH_TRIGGER_RATE_FOR_QUI", "", "TIME_OUT_FORBID", "J", "TIME_OUT_MSG_SYNC", "TITLE_BAR_HEIGHT", "TWO_LEVEL_DUR", "TWO_LEVEL_RATE", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.activity.home.chats.biz.i$a, reason: from kotlin metadata */
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

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H&J\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/activity/home/chats/biz/i$b;", "", "Lcom/qqnt/widget/smartrefreshlayout/layout/constant/RefreshState;", "newState", "oldState", "", "a", "", "cur", "onProgress", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes10.dex */
    public interface b {
        void a(@NotNull RefreshState newState, @NotNull RefreshState oldState);

        void onProgress(float cur);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\f\u001a\u00020\u0005\u00a2\u0006\u0004\b\r\u0010\u000eJ\b\u0010\u0003\u001a\u00020\u0002H\u0016R%\u0010\u000b\u001a\u0010\u0012\f\u0012\n \u0006*\u0004\u0018\u00010\u00050\u00050\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/activity/home/chats/biz/i$c;", "Lcom/tencent/qqnt/kernel/nativeinterface/IKernelMsgListener;", "", "onNtMsgSyncEnd", "Lmqq/util/WeakReference;", "Lcom/tencent/mobileqq/activity/home/chats/biz/i;", "kotlin.jvm.PlatformType", "d", "Lmqq/util/WeakReference;", "a", "()Lmqq/util/WeakReference;", "ref", "part", "<init>", "(Lcom/tencent/mobileqq/activity/home/chats/biz/i;)V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes10.dex */
    public static final class c implements IKernelMsgListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final WeakReference<i> ref;

        public c(@NotNull i part) {
            Intrinsics.checkNotNullParameter(part, "part");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) part);
            } else {
                this.ref = new WeakReference<>(part);
            }
        }

        @NotNull
        public final WeakReference<i> a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (WeakReference) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return this.ref;
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onAddSendMsg(MsgRecord msgRecord) {
            ax.a(this, msgRecord);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onContactUnreadCntUpdate(HashMap hashMap) {
            ax.b(this, hashMap);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onCustomWithdrawConfigUpdate(CustomWithdrawConfig customWithdrawConfig) {
            ax.c(this, customWithdrawConfig);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onDraftUpdate(Contact contact, ArrayList arrayList, long j3) {
            ax.d(this, contact, arrayList, j3);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onEmojiDownloadComplete(EmojiNotifyInfo emojiNotifyInfo) {
            ax.e(this, emojiNotifyInfo);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onEmojiResourceUpdate(EmojiResourceInfo emojiResourceInfo) {
            ax.f(this, emojiResourceInfo);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onFileMsgCome(ArrayList arrayList) {
            ax.g(this, arrayList);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onGrabPasswordRedBag(int i3, String str, int i16, RecvdOrder recvdOrder, MsgRecord msgRecord) {
            ax.h(this, i3, str, i16, recvdOrder, msgRecord);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onGroupFileInfoAdd(GroupItem groupItem) {
            ax.i(this, groupItem);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onGroupFileInfoUpdate(GroupFileListResult groupFileListResult) {
            ax.j(this, groupFileListResult);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onGroupTransferInfoAdd(GroupItem groupItem) {
            ax.k(this, groupItem);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onGroupTransferInfoUpdate(GroupFileListResult groupFileListResult) {
            ax.l(this, groupFileListResult);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onHitCsRelatedEmojiResult(DownloadRelateEmojiResultInfo downloadRelateEmojiResultInfo) {
            ax.m(this, downloadRelateEmojiResultInfo);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onHitEmojiKeywordResult(HitRelatedEmojiWordsResult hitRelatedEmojiWordsResult) {
            ax.n(this, hitRelatedEmojiWordsResult);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onHitRelatedEmojiResult(RelatedWordEmojiInfo relatedWordEmojiInfo) {
            ax.o(this, relatedWordEmojiInfo);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onImportOldDbProgressUpdate(ImportOldDbMsgNotifyInfo importOldDbMsgNotifyInfo) {
            ax.p(this, importOldDbMsgNotifyInfo);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onInputStatusPush(InputStatusInfo inputStatusInfo) {
            ax.q(this, inputStatusInfo);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onKickedOffLine(KickedInfo kickedInfo) {
            ax.r(this, kickedInfo);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onLineDev(ArrayList arrayList) {
            ax.s(this, arrayList);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onLogLevelChanged(long j3) {
            ax.t(this, j3);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onMiscDataChanged(ArrayList arrayList) {
            ax.u(this, arrayList);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onMsgBoxChanged(ArrayList arrayList) {
            ax.v(this, arrayList);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onMsgDelete(Contact contact, ArrayList arrayList) {
            ax.w(this, contact, arrayList);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onMsgInfoListAdd(ArrayList arrayList) {
            ax.x(this, arrayList);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onMsgInfoListUpdate(ArrayList arrayList) {
            ax.y(this, arrayList);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onMsgQRCodeStatusChanged(int i3) {
            ax.z(this, i3);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onMsgRecall(int i3, String str, long j3) {
            ax.A(this, i3, str, j3);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onMsgSecurityNotify(MsgRecord msgRecord) {
            ax.B(this, msgRecord);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onMsgSettingUpdate(MsgSetting msgSetting) {
            ax.C(this, msgSetting);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onMsgWithRichLinkInfoUpdate(ArrayList arrayList) {
            ax.D(this, arrayList);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onNtFirstViewMsgSyncEnd() {
            ax.E(this);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onNtMsgSyncContactUnread() {
            ax.F(this);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public void onNtMsgSyncEnd() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this);
                return;
            }
            i iVar = this.ref.get();
            if (iVar != null) {
                iVar.xa();
            }
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onNtMsgSyncStart() {
            ax.H(this);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onRecvMsg(ArrayList arrayList) {
            ax.I(this, arrayList);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onRecvMsgSvrRspTransInfo(long j3, Contact contact, int i3, int i16, String str, byte[] bArr) {
            ax.J(this, j3, contact, i3, i16, str, bArr);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onRecvOnlineFileMsg(ArrayList arrayList) {
            ax.K(this, arrayList);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onRecvSysMsg(ArrayList arrayList) {
            ax.L(this, arrayList);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onRedTouchChanged() {
            ax.M(this);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onRichMediaDownloadComplete(FileTransNotifyInfo fileTransNotifyInfo) {
            ax.N(this, fileTransNotifyInfo);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onRichMediaProgerssUpdate(FileTransNotifyInfo fileTransNotifyInfo) {
            ax.O(this, fileTransNotifyInfo);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onRichMediaUploadComplete(FileTransNotifyInfo fileTransNotifyInfo) {
            ax.P(this, fileTransNotifyInfo);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onSearchGroupFileInfoUpdate(SearchGroupFileResult searchGroupFileResult) {
            ax.Q(this, searchGroupFileResult);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onSendMsgError(long j3, Contact contact, int i3, String str) {
            ax.R(this, j3, contact, i3, str);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onSysMsgNotification(int i3, long j3, long j16, boolean z16, ArrayList arrayList) {
            ax.S(this, i3, j3, j16, z16, arrayList);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onTempChatInfoUpdate(TempChatInfo tempChatInfo) {
            ax.T(this, tempChatInfo);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onUserChannelTabStatusChanged(boolean z16) {
            ax.U(this, z16);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onUserOnlineStatusChanged(boolean z16) {
            ax.V(this, z16);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onUserSecQualityChanged(QueryUserSecQualityRsp queryUserSecQualityRsp) {
            ax.W(this, queryUserSecQualityRsp);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onUserTabStatusChanged(ArrayList arrayList) {
            ax.X(this, arrayList);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onlineStatusBigIconDownloadPush(int i3, long j3, String str) {
            ax.Y(this, i3, j3, str);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onlineStatusSmallIconDownloadPush(int i3, long j3, String str) {
            ax.Z(this, i3, j3, str);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\t\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0016J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0002H\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/mobileqq/activity/home/chats/biz/i$d", "Lcom/tencent/qqnt/chats/view/QQChatListTwoLevelHeader$b;", "", "curProgress", "", "c", "Lcom/qqnt/widget/smartrefreshlayout/layout/constant/RefreshState;", "oldState", "newState", "a", "cur", "b", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes10.dex */
    public static final class d implements QQChatListTwoLevelHeader.b {
        static IPatchRedirector $redirector_;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ View f182959b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ View f182960c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ View f182961d;

        d(View view, View view2, View view3) {
            this.f182959b = view;
            this.f182960c = view2;
            this.f182961d = view3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, i.this, view, view2, view3);
            }
        }

        private final void c(float curProgress) {
            if (ChatsListConfig.f354433a.a()) {
                i iVar = i.this;
                i.Ra(iVar, iVar.G9().g(), curProgress, 0.0f, 0.0f, 12, null);
                i iVar2 = i.this;
                View headerRoot = this.f182959b;
                Intrinsics.checkNotNullExpressionValue(headerRoot, "headerRoot");
                i.Ra(iVar2, headerRoot, curProgress, 0.0f, 0.0f, 12, null);
                i iVar3 = i.this;
                View mQQTabWidget = this.f182960c;
                Intrinsics.checkNotNullExpressionValue(mQQTabWidget, "mQQTabWidget");
                iVar3.Sa(mQQTabWidget, curProgress, 0.4f, 0.7f);
                i iVar4 = i.this;
                View mQQBlurView = this.f182961d;
                Intrinsics.checkNotNullExpressionValue(mQQBlurView, "mQQBlurView");
                iVar4.Sa(mQQBlurView, curProgress, 0.4f, 0.7f);
                i iVar5 = i.this;
                iVar5.Qa(iVar5.G9().a(), curProgress, 0.5f, 1.0f);
            }
        }

        @Override // com.tencent.qqnt.chats.view.QQChatListTwoLevelHeader.b
        public void a(@NotNull RefreshState oldState, @NotNull RefreshState newState) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) oldState, (Object) newState);
                return;
            }
            Intrinsics.checkNotNullParameter(oldState, "oldState");
            Intrinsics.checkNotNullParameter(newState, "newState");
            if (!ChatsListConfig.f354433a.a()) {
                i iVar = i.this;
                ViewGroup g16 = iVar.G9().g();
                View headerRoot = this.f182959b;
                Intrinsics.checkNotNullExpressionValue(headerRoot, "headerRoot");
                View mQQTabWidget = this.f182960c;
                Intrinsics.checkNotNullExpressionValue(mQQTabWidget, "mQQTabWidget");
                View mQQBlurView = this.f182961d;
                Intrinsics.checkNotNullExpressionValue(mQQBlurView, "mQQBlurView");
                iVar.Aa(newState, g16, headerRoot, mQQTabWidget, mQQBlurView);
            }
            Iterator it = i.this.onStateChangeList.iterator();
            while (it.hasNext()) {
                ((b) it.next()).a(newState, oldState);
            }
        }

        @Override // com.tencent.qqnt.chats.view.QQChatListTwoLevelHeader.b
        public void b(float cur) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, Float.valueOf(cur));
                return;
            }
            Iterator it = i.this.onStateChangeList.iterator();
            while (it.hasNext()) {
                ((b) it.next()).onProgress(cur);
            }
            c(cur);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(51591);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 25)) {
            redirector.redirect((short) 25);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(@NotNull com.tencent.mobileqq.activity.home.chats.callbcak.a para) {
        super(para);
        Intrinsics.checkNotNullParameter(para, "para");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) para);
        } else {
            this.onStateChangeList = new CopyOnWriteArrayList<>();
            this.autoFinishRunnable = new Runnable() { // from class: com.tencent.mobileqq.activity.home.chats.biz.g
                @Override // java.lang.Runnable
                public final void run() {
                    i.va(i.this);
                }
            };
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Aa(RefreshState newState, final View topBar, final View headerRoot, final View tabContainer, final View tabBlur) {
        if (newState == RefreshState.TwoLevelReleased) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(topBar, "translationY", -topBar.getHeight());
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(headerRoot, "translationY", 0.0f, -topBar.getHeight());
            ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(tabContainer, "translationY", 0.0f, tabContainer.getHeight());
            ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(tabBlur, "translationY", 0.0f, tabBlur.getHeight());
            AnimatorSet animatorSet = new AnimatorSet();
            this.curAnimSet = animatorSet;
            Intrinsics.checkNotNull(animatorSet);
            animatorSet.setDuration(200L);
            AnimatorSet animatorSet2 = this.curAnimSet;
            Intrinsics.checkNotNull(animatorSet2);
            animatorSet2.setInterpolator(new AccelerateDecelerateInterpolator());
            AnimatorSet animatorSet3 = this.curAnimSet;
            Intrinsics.checkNotNull(animatorSet3);
            animatorSet3.play(ofFloat).with(ofFloat2).with(ofFloat3).with(ofFloat4);
            AnimatorSet animatorSet4 = this.curAnimSet;
            Intrinsics.checkNotNull(animatorSet4);
            animatorSet4.start();
            return;
        }
        if (newState == RefreshState.TwoLevelFinish) {
            ObjectAnimator ofFloat5 = ObjectAnimator.ofFloat(topBar, "translationY", -topBar.getHeight(), 0.0f);
            ObjectAnimator ofFloat6 = ObjectAnimator.ofFloat(headerRoot, "translationY", -topBar.getHeight(), 0.0f);
            ObjectAnimator ofFloat7 = ObjectAnimator.ofFloat(tabContainer, "translationY", tabContainer.getHeight(), 0.0f);
            ObjectAnimator ofFloat8 = ObjectAnimator.ofFloat(tabBlur, "translationY", tabContainer.getHeight(), 0.0f);
            AnimatorSet animatorSet5 = new AnimatorSet();
            this.curAnimSet = animatorSet5;
            Intrinsics.checkNotNull(animatorSet5);
            animatorSet5.setDuration(200L);
            AnimatorSet animatorSet6 = this.curAnimSet;
            Intrinsics.checkNotNull(animatorSet6);
            animatorSet6.setInterpolator(new AccelerateDecelerateInterpolator());
            AnimatorSet animatorSet7 = this.curAnimSet;
            Intrinsics.checkNotNull(animatorSet7);
            animatorSet7.play(ofFloat5).with(ofFloat6).with(ofFloat7).with(ofFloat8);
            AnimatorSet animatorSet8 = this.curAnimSet;
            Intrinsics.checkNotNull(animatorSet8);
            animatorSet8.start();
            return;
        }
        if (newState == RefreshState.None) {
            runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.activity.home.chats.biz.h
                @Override // java.lang.Runnable
                public final void run() {
                    i.Ba(i.this, topBar, headerRoot, tabContainer, tabBlur);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ba(i this$0, View topBar, View headerRoot, View tabContainer, View tabBlur) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(topBar, "$topBar");
        Intrinsics.checkNotNullParameter(headerRoot, "$headerRoot");
        Intrinsics.checkNotNullParameter(tabContainer, "$tabContainer");
        Intrinsics.checkNotNullParameter(tabBlur, "$tabBlur");
        AnimatorSet animatorSet = this$0.curAnimSet;
        if (animatorSet != null) {
            animatorSet.cancel();
        }
        this$0.curAnimSet = null;
        topBar.setTranslationY(0.0f);
        headerRoot.setTranslationY(0.0f);
        tabContainer.setTranslationY(0.0f);
        tabBlur.setTranslationY(0.0f);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void Fa() {
        MiniOldStyleHeader miniOldStyleHeader;
        Context S9 = S9();
        int i3 = S9.getResources().getDisplayMetrics().heightPixels;
        Ka(new AnimRefreshHeaderView(S9, null, QQTheme.isNowThemeIsNight()));
        int q16 = MainResourceConfig.INSTANCE.e().q(S9());
        if (Ea().i()) {
            MiniOldStyleHeaderNew miniOldStyleHeaderNew = new MiniOldStyleHeaderNew(S9);
            miniOldStyleHeaderNew.s(i3);
            AnimRefreshHeaderView Ea = Ea();
            Ea.setTopPadding(q16);
            miniOldStyleHeaderNew.u(Ea);
            miniOldStyleHeaderNew.q(300);
            miniOldStyleHeaderNew.r(1.8f);
            miniOldStyleHeaderNew.setCurRefreshRate(1.4f);
            miniOldStyleHeaderNew.setTitleBarOffset(q16);
            miniOldStyleHeaderNew.setBaseOffset(LocaleManager.MOBILE_COUNTRY_CODE_CN_INT);
            miniOldStyleHeader = miniOldStyleHeaderNew;
        } else {
            MiniOldStyleHeader miniOldStyleHeader2 = new MiniOldStyleHeader(S9);
            miniOldStyleHeader2.s(i3);
            AnimRefreshHeaderView Ea2 = Ea();
            Ea2.setTopPadding(q16);
            miniOldStyleHeader2.u(Ea2);
            miniOldStyleHeader2.q(300);
            miniOldStyleHeader2.r(1.8f);
            miniOldStyleHeader2.setCurRefreshRate(1.4f);
            miniOldStyleHeader2.setTitleBarOffset(q16);
            miniOldStyleHeader2.setBaseOffset(LocaleManager.MOBILE_COUNTRY_CODE_CN_INT);
            miniOldStyleHeader = miniOldStyleHeader2;
        }
        Ja(miniOldStyleHeader);
        Pa(Da());
        if (Ea().i()) {
            G9().c().d(1.125f);
        } else {
            G9().c().d(1.4f);
        }
        G9().c().f(new com.tencent.qqnt.biz.lightbusiness.lightinteraction.view.a(0.2f, 0.0f, 0.3f, 1.0f));
        Ha(new com.tencent.qqnt.chats.core.ui.refresh.c(Ea(), Da(), G9().c(), G9().g(), G9().a(), G9().f(), S9));
        G9().g().bringToFront();
        com.tencent.qqnt.chats.core.ui.listener.b bVar = this.refreshListener;
        if (bVar != null) {
            Ca().f(bVar);
        }
        Ca().g(new d(getActivity().findViewById(R.id.e3u), getActivity().findViewById(af.f()), getActivity().findViewById(R.id.kmr)));
        x9(0, Ca());
    }

    private final void Ga(AppRuntime app) {
        c cVar = this.msgListener;
        if (cVar != null) {
            this.msgListener = null;
            com.tencent.qqnt.kernel.api.w msgService = ((IKernelService) app.getRuntimeService(IKernelService.class, "")).getMsgService();
            if (msgService != null) {
                msgService.removeMsgListener(cVar);
            }
        }
    }

    private final void La(View v3, int visibility) {
        if (v3.getVisibility() == visibility) {
            return;
        }
        if (v3 instanceof TitleAreaHeadLayout) {
            TitleAreaHeadLayout titleAreaHeadLayout = (TitleAreaHeadLayout) v3;
            if (titleAreaHeadLayout.j()) {
                return;
            }
            TitleAreaHeadLayout.setVisibility$default(titleAreaHeadLayout, visibility, "chats_pull_anim", null, 4, null);
            return;
        }
        v3.setVisibility(visibility);
    }

    private final void Na(long delayMillis) {
        Handler handler = this.refreshHandler;
        Handler handler2 = null;
        if (handler == null) {
            Intrinsics.throwUninitializedPropertyAccessException("refreshHandler");
            handler = null;
        }
        handler.removeCallbacks(this.autoFinishRunnable);
        Handler handler3 = this.refreshHandler;
        if (handler3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("refreshHandler");
        } else {
            handler2 = handler3;
        }
        handler2.postDelayed(this.autoFinishRunnable, delayMillis);
    }

    private final void Pa(QQChatListTwoLevelHeader header) {
        Activity activity = getActivity();
        Intrinsics.checkNotNullExpressionValue(activity, "activity");
        RelativeLayout B = header.B();
        MainResourceConfig.Companion companion = MainResourceConfig.INSTANCE;
        B.setBackground(companion.e().l(activity));
        header.h().getView().setBackground(companion.e().l(activity));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Qa(View v3, float cur, float startHidePos, float endHidePos) {
        if (cur < startHidePos) {
            v3.setAlpha(1.0f);
            La(v3, 0);
            return;
        }
        if (cur > startHidePos && cur < endHidePos) {
            v3.setAlpha(1 - ((cur - startHidePos) / (endHidePos - startHidePos)));
            La(v3, 0);
            return;
        }
        if (cur > endHidePos) {
            v3.setAlpha(0.0f);
            La(v3, 8);
        }
    }

    static /* synthetic */ void Ra(i iVar, View view, float f16, float f17, float f18, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            f17 = 0.12f;
        }
        if ((i3 & 8) != 0) {
            f18 = 0.25f;
        }
        iVar.Qa(view, f16, f17, f18);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Sa(View v3, float cur, float startHidePos, float endHidePos) {
        if (cur < startHidePos) {
            v3.setTranslationY(0.0f);
            La(v3, 0);
            return;
        }
        if (cur > startHidePos && cur < endHidePos) {
            v3.setTranslationY(v3.getHeight() * ((cur - startHidePos) / (endHidePos - startHidePos)));
            La(v3, 0);
            return;
        }
        if (cur > endHidePos) {
            v3.setTranslationY(0.0f);
            La(v3, 8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void va(i this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QLog.d(this$0.ea(), 1, "time out auto finish");
        this$0.G9().c().k();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void za(i this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Handler handler = this$0.refreshHandler;
        if (handler == null) {
            Intrinsics.throwUninitializedPropertyAccessException("refreshHandler");
            handler = null;
        }
        handler.removeCallbacks(this$0.autoFinishRunnable);
        if (this$0.G9().c().getState() == RefreshState.Refreshing || this$0.G9().c().getState() == RefreshState.None) {
            this$0.G9().c().k();
        }
    }

    @NotNull
    public final com.tencent.qqnt.chats.core.ui.refresh.c Ca() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (com.tencent.qqnt.chats.core.ui.refresh.c) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        com.tencent.qqnt.chats.core.ui.refresh.c cVar = this.chatListRefreshVB;
        if (cVar != null) {
            return cVar;
        }
        Intrinsics.throwUninitializedPropertyAccessException("chatListRefreshVB");
        return null;
    }

    @NotNull
    public final QQChatListTwoLevelHeader Da() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (QQChatListTwoLevelHeader) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        QQChatListTwoLevelHeader qQChatListTwoLevelHeader = this.miniProgramHeader;
        if (qQChatListTwoLevelHeader != null) {
            return qQChatListTwoLevelHeader;
        }
        Intrinsics.throwUninitializedPropertyAccessException("miniProgramHeader");
        return null;
    }

    @NotNull
    public final AnimRefreshHeaderView Ea() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (AnimRefreshHeaderView) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        AnimRefreshHeaderView animRefreshHeaderView = this.refresh;
        if (animRefreshHeaderView != null) {
            return animRefreshHeaderView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("refresh");
        return null;
    }

    public final void Ha(@NotNull com.tencent.qqnt.chats.core.ui.refresh.c cVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) cVar);
        } else {
            Intrinsics.checkNotNullParameter(cVar, "<set-?>");
            this.chatListRefreshVB = cVar;
        }
    }

    @Override // com.tencent.qqnt.chats.biz.main.part.a
    public void I9() {
        SpringFestivalEntryManager springFestivalEntryManager;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this);
            return;
        }
        super.I9();
        if (X9() == null) {
            QLog.i(ea(), 1, "PullRefresh|But app is null");
            return;
        }
        com.tencent.qqnt.kernel.api.w msgService = ((IKernelService) X9().getRuntimeService(IKernelService.class, "")).getMsgService();
        if (msgService == null) {
            QLog.e(ea(), 1, "PullRefresh|begin handlePullRefresh but service is null");
            return;
        }
        c cVar = this.msgListener;
        if (cVar == null || cVar.a().get() == null) {
            if (cVar != null) {
                msgService.removeMsgListener(cVar);
            }
            c cVar2 = new c(this);
            msgService.addMsgListener(cVar2);
            this.msgListener = cVar2;
        }
        Manager manager = X9().getManager(QQManagerFactory.SPRING_FESTIVAL_ENTRY_MANAGER);
        if (manager instanceof SpringFestivalEntryManager) {
            springFestivalEntryManager = (SpringFestivalEntryManager) manager;
        } else {
            springFestivalEntryManager = null;
        }
        if (springFestivalEntryManager != null && springFestivalEntryManager.S()) {
            Na(1000L);
            QLog.i(ea(), 1, "PullRefresh|forbidRefresh");
        } else {
            Na(10000L);
            msgService.startMsgSync();
        }
        QLog.d(ea(), 1, "PullRefresh|begin handlePullRefresh");
    }

    public final void Ia(@NotNull com.tencent.qqnt.chats.core.ui.listener.b refreshListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) refreshListener);
            return;
        }
        Intrinsics.checkNotNullParameter(refreshListener, "refreshListener");
        this.refreshListener = refreshListener;
        if (this.chatListRefreshVB != null) {
            Ca().f(refreshListener);
        }
    }

    public final void Ja(@NotNull QQChatListTwoLevelHeader qQChatListTwoLevelHeader) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) qQChatListTwoLevelHeader);
        } else {
            Intrinsics.checkNotNullParameter(qQChatListTwoLevelHeader, "<set-?>");
            this.miniProgramHeader = qQChatListTwoLevelHeader;
        }
    }

    @Override // com.tencent.qqnt.chats.biz.main.part.a
    public void K9(@NotNull AppRuntime app) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) app);
        } else {
            Intrinsics.checkNotNullParameter(app, "app");
            Ga(app);
        }
    }

    public final void Ka(@NotNull AnimRefreshHeaderView animRefreshHeaderView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) animRefreshHeaderView);
        } else {
            Intrinsics.checkNotNullParameter(animRefreshHeaderView, "<set-?>");
            this.refresh = animRefreshHeaderView;
        }
    }

    public final void Ma() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, (Object) this);
        } else {
            G9().a().scrollToPosition(0);
            G9().c().h(0, 100, 1.0f, false);
        }
    }

    public final void Oa(boolean enableTwoLevel) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this, enableTwoLevel);
        } else {
            Ca().h(enableTwoLevel);
        }
    }

    @Override // com.tencent.mobileqq.activity.home.chats.biz.d
    @NotNull
    public String ea() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (String) iPatchRedirector.redirect((short) 12, (Object) this);
        }
        return "QQMiniProgramPart";
    }

    @Override // com.tencent.biz.richframework.part.Part
    @NotNull
    /* renamed from: getLogTag */
    public String getTAG() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (String) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return "QQMiniProgramPart";
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@Nullable View rootView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) rootView);
            return;
        }
        super.onInitView(rootView);
        this.refreshHandler = new Handler(Looper.getMainLooper());
        Fa();
    }

    @Override // com.tencent.mobileqq.activity.home.chats.biz.d, com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(@NotNull Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) activity);
            return;
        }
        Intrinsics.checkNotNullParameter(activity, "activity");
        super.onPartDestroy(activity);
        Handler handler = this.refreshHandler;
        if (handler == null) {
            Intrinsics.throwUninitializedPropertyAccessException("refreshHandler");
            handler = null;
        }
        handler.removeCallbacks(this.autoFinishRunnable);
        AppRuntime X9 = X9();
        if (X9 != null) {
            Ga(X9);
        }
    }

    @Override // com.tencent.qqnt.chats.biz.main.part.a
    public void onPostThemeChanged() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this);
        } else if (this.refresh != null) {
            Ea().j(QQTheme.isNowThemeIsNight());
            Pa(Da());
        }
    }

    public final void ua(@NotNull b onStateChange) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, (Object) onStateChange);
        } else {
            Intrinsics.checkNotNullParameter(onStateChange, "onStateChange");
            this.onStateChangeList.add(onStateChange);
        }
    }

    public final void wa() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, (Object) this);
            return;
        }
        RefreshState state = G9().c().getState();
        Intrinsics.checkNotNullExpressionValue(state, "_binding.recyclerScroll.state");
        if (state == RefreshState.TwoLevelReleased || state == RefreshState.TwoLevel || state == RefreshState.ReleaseToTwoLevel) {
            G9().c().k();
        }
    }

    public final void xa() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        QLog.d(getTAG(), 1, "PullRefresh|onNtMsgSyncEnd");
        Handler handler = this.refreshHandler;
        if (handler == null) {
            Intrinsics.throwUninitializedPropertyAccessException("refreshHandler");
            handler = null;
        }
        handler.post(new Runnable() { // from class: com.tencent.mobileqq.activity.home.chats.biz.f
            @Override // java.lang.Runnable
            public final void run() {
                i.za(i.this);
            }
        });
    }
}
