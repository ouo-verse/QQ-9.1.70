package com.tencent.mobileqq.startup.task;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.activity.framebusiness.controllerinject.TabDataHelper;
import com.tencent.mobileqq.api.IKickProcessorApi;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.cardcontainer.api.ICardContainerApi;
import com.tencent.mobileqq.config.api.IAppSettingApi;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.friend.api.IFriendHandlerService;
import com.tencent.mobileqq.gateway.localphone.ecdh.api.IECDHServiceApi;
import com.tencent.mobileqq.guild.mainframe.api.IGuildMainFrameApi;
import com.tencent.mobileqq.lightquic.ILightQUICApi;
import com.tencent.mobileqq.login.api.IUidService;
import com.tencent.mobileqq.loginregister.ILoginRegisterApi;
import com.tencent.mobileqq.matchfriend.reborn.api.IQQStrangerRuntimeService;
import com.tencent.mobileqq.notification.modularize.ZPlanNTPushCenter;
import com.tencent.mobileqq.ntpush.api.ILoginNTPushService;
import com.tencent.mobileqq.pskey.api.IPskeyManager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.reminder.api.IQQReminderMsgService;
import com.tencent.mobileqq.startup.task.KernelInitTask;
import com.tencent.mobileqq.thirdsig.api.IThirdSigService;
import com.tencent.mobileqq.vas.push.IVasSystemPushApi;
import com.tencent.mobileqq.wifiphoto.api.IExportFileService;
import com.tencent.mobileqq.wifiphoto.api.IWifiPhotoService;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.ITroopInitApi;
import com.tencent.qqnt.chats.api.IChatsDataRepoCreator;
import com.tencent.qqnt.chats.main.vm.datasource.IRecentContactRepo;
import com.tencent.qqnt.contacts.cache.FriendListInfoCache;
import com.tencent.qqnt.freesia_wrapper.FreesiaWrapperImpl;
import com.tencent.qqnt.kernel.api.IKernelService;
import com.tencent.qqnt.kernel.api.IKernelSetter;
import com.tencent.qqnt.kernel.api.IKickApi;
import com.tencent.qqnt.kernel.nativeinterface.CustomWithdrawConfig;
import com.tencent.qqnt.kernel.nativeinterface.DownloadRelateEmojiResultInfo;
import com.tencent.qqnt.kernel.nativeinterface.EmojiNotifyInfo;
import com.tencent.qqnt.kernel.nativeinterface.EmojiResourceInfo;
import com.tencent.qqnt.kernel.nativeinterface.FileTransNotifyInfo;
import com.tencent.qqnt.kernel.nativeinterface.GroupFileListResult;
import com.tencent.qqnt.kernel.nativeinterface.GroupItem;
import com.tencent.qqnt.kernel.nativeinterface.HitRelatedEmojiWordsResult;
import com.tencent.qqnt.kernel.nativeinterface.IFlashTransferTaskInfoListener;
import com.tencent.qqnt.kernel.nativeinterface.IKernelECDHService;
import com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener;
import com.tencent.qqnt.kernel.nativeinterface.IQQNTWrapperSession;
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
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import com.tencent.qqnt.msg.api.ILogPushApi;
import com.tencent.qqnt.msg.api.IMsgService;
import com.tencent.qqnt.ntrelation.friendsinfo.api.IFriendsInfoService;
import com.tencent.qqnt.startup.task.NtTask;
import com.tencent.relation.common.nt.api.IRelationNTPushService;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import mqq.app.AppActivity;
import mqq.app.AppRuntime;
import mqq.app.IAccountCallback;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes18.dex */
public class KernelInitTask extends NtTask {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private final AtomicBoolean f289757d;

    /* renamed from: e, reason: collision with root package name */
    private final AtomicBoolean f289758e;

    /* renamed from: f, reason: collision with root package name */
    private IKernelMsgListener f289759f;

    /* renamed from: h, reason: collision with root package name */
    private CountDownLatch f289760h;

    /* renamed from: i, reason: collision with root package name */
    private final Handler f289761i;

    /* renamed from: m, reason: collision with root package name */
    private IFlashTransferTaskInfoListener f289762m;

    /* compiled from: P */
    /* loaded from: classes18.dex */
    class a implements com.tencent.qqnt.kernel.api.u {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) KernelInitTask.this);
            }
        }

        @Override // com.tencent.qqnt.kernel.api.u
        public void a(@NonNull AppRuntime appRuntime) {
            boolean z16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) appRuntime);
                return;
            }
            QLog.d("KernelInitTask", 1, "onKernelInitComplete");
            try {
                QLog.d("KernelInitTask", 2, "onKernelInitComplete set kernel debug");
                IKernelECDHService eCDHService = ((IECDHServiceApi) QRoute.api(IECDHServiceApi.class)).getECDHService();
                if (eCDHService != null) {
                    if (!((IAppSettingApi) QRoute.api(IAppSettingApi.class)).isPublicVersion()) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    eCDHService.setIsDebug(z16);
                }
            } catch (Exception e16) {
                QLog.e("KernelInitTask", 1, "onKernelInitComplete set Debug Mode Fail :" + e16);
            }
        }

        @Override // com.tencent.qqnt.kernel.api.u
        public void b(@NonNull AppRuntime appRuntime) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) appRuntime);
            } else {
                QLog.d("KernelInitTask", 1, "onKernelSessionCreated");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class b implements com.tencent.qqnt.kernel.api.u {
        static IPatchRedirector $redirector_;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: P */
        /* loaded from: classes18.dex */
        public class a implements Function1<IQQNTWrapperSession, Unit> {
            static IPatchRedirector $redirector_;

            a() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) b.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public Unit invoke(IQQNTWrapperSession iQQNTWrapperSession) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return (Unit) iPatchRedirector.redirect((short) 2, (Object) this, (Object) iQQNTWrapperSession);
                }
                gd2.g.f401968a.b(iQQNTWrapperSession);
                return Unit.INSTANCE;
            }
        }

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) KernelInitTask.this);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void f(AppRuntime appRuntime) {
            ((IPskeyManager) appRuntime.getRuntimeService(IPskeyManager.class, "all")).onNTKernelSessionCreated();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void g(AppRuntime appRuntime) {
            ((IThirdSigService) appRuntime.getRuntimeService(IThirdSigService.class, "")).onAppInit();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void h(final AppRuntime appRuntime) {
            QLog.i("KernelInitTask", 1, "onKernelSessionCreated async, " + appRuntime.hashCode());
            long currentTimeMillis = System.currentTimeMillis();
            FreesiaWrapperImpl.INSTANCE.b().f();
            MobileQQ.sMobileQQ.realInvokeDispatchAccountEvent(appRuntime);
            NotificationInitTask notificationInitTask = new NotificationInitTask();
            notificationInitTask.f();
            QQAppInterface qQAppInterface = (QQAppInterface) appRuntime;
            notificationInitTask.g(qQAppInterface);
            com.tencent.qqnt.kernel.api.w msgService = ((IKernelService) appRuntime.getRuntimeService(IKernelService.class, "")).getMsgService();
            ((IMsgService) QRoute.api(IMsgService.class)).init(msgService);
            ((IMsgService) QRoute.api(IMsgService.class)).init(((IKernelService) appRuntime.getRuntimeService(IKernelService.class, "")).getGuildMsgService());
            KernelInitTask.this.n(msgService);
            com.tencent.mobileqq.notification.modularize.r.INSTANCE.a(qQAppInterface).q();
            bb0.b.i().q();
            ZPlanNTPushCenter.f254262a.g();
            ((IKernelService) appRuntime.getRuntimeService(IKernelService.class, "")).setSessionDestroyListener(new a());
            com.tencent.qqnt.chats.utils.b.f355541a.d();
            appRuntime.getRuntimeService(IQQStrangerRuntimeService.class, "all");
            ((ITroopInitApi) QRoute.api(ITroopInitApi.class)).onNTKernelSessionCreated();
            ((ILightQUICApi) QRoute.api(ILightQUICApi.class)).onNTKernelInitComplete();
            KernelInitTask.o();
            ((IRelationNTPushService) QRoute.api(IRelationNTPushService.class)).registerRelationNTPush();
            FriendListInfoCache.INSTANCE.a().t();
            qQAppInterface.getNTFileManageBridger().E0();
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.startup.task.ae
                @Override // java.lang.Runnable
                public final void run() {
                    KernelInitTask.b.f(AppRuntime.this);
                }
            }, 16, null, false);
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.startup.task.af
                @Override // java.lang.Runnable
                public final void run() {
                    KernelInitTask.b.g(AppRuntime.this);
                }
            }, 16, null, false);
            com.tencent.biz.qrcode.logindev.pclock.e.f94954a.i();
            ArrayList<Long> arrayList = new ArrayList<>();
            arrayList.add(365L);
            ((IMsgService) QRoute.api(IMsgService.class)).registerSysMsgNotification(0, 528L, arrayList, null);
            ((IVasSystemPushApi) QRoute.api(IVasSystemPushApi.class)).register();
            appRuntime.getRuntimeService(ILoginNTPushService.class, "");
            qQAppInterface.getQavOfflineMsgCenter().d();
            ((IWifiPhotoService) QRoute.api(IWifiPhotoService.class)).init();
            ((IExportFileService) QRoute.api(IExportFileService.class)).init();
            ((IQQReminderMsgService) appRuntime.getRuntimeService(IQQReminderMsgService.class, "all")).registerNtSysMsgNotification();
            QLog.d("KernelInitTask", 1, "onKernelSessionCreated and biz register cost:", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
        }

        @Override // com.tencent.qqnt.kernel.api.u
        public void a(@NonNull AppRuntime appRuntime) {
            boolean z16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) appRuntime);
                return;
            }
            QLog.i("KernelInitTask", 1, "onKernelInitComplete " + appRuntime.hashCode());
            ArrayList<Long> arrayList = new ArrayList<>();
            arrayList.add(335L);
            ((IMsgService) QRoute.api(IMsgService.class)).registerSysMsgNotification(0, 528L, arrayList, null);
            QLog.i("LogPush", 1, "register qq.");
            KernelInitTask.t();
            ((ILogPushApi) QRoute.api(ILogPushApi.class)).register();
            BaseApplication.getContext().sendBroadcast(new Intent("com.tencent.mobileqq.action.ON_KERNEL_INIT_COMPLETE"));
            FileManagerUtil.initNoMedia();
            try {
                QLog.d("KernelInitTask", 2, "onKernelInitComplete set kernel debug");
                IKernelECDHService eCDHService = ((IECDHServiceApi) QRoute.api(IECDHServiceApi.class)).getECDHService();
                if (eCDHService != null) {
                    if (!((IAppSettingApi) QRoute.api(IAppSettingApi.class)).isPublicVersion()) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    eCDHService.setIsDebug(z16);
                }
            } catch (Exception e16) {
                QLog.e("KernelInitTask", 1, "onKernelInitComplete set Debug Mode Fail :" + e16);
            }
            KernelInitTask.u();
        }

        @Override // com.tencent.qqnt.kernel.api.u
        public void b(@NonNull final AppRuntime appRuntime) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) appRuntime);
            } else {
                QLog.d("KernelInitTask", 1, "onKernelSessionCreated");
                KernelInitTask.this.s(new Runnable() { // from class: com.tencent.mobileqq.startup.task.ad
                    @Override // java.lang.Runnable
                    public final void run() {
                        KernelInitTask.b.this.h(appRuntime);
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class c implements e72.d {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ IAccountCallback f289767a;

        c(IAccountCallback iAccountCallback) {
            this.f289767a = iAccountCallback;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) KernelInitTask.this, (Object) iAccountCallback);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void d(IAccountCallback iAccountCallback) {
            long currentTimeMillis = System.currentTimeMillis();
            com.tencent.qqnt.trace.j jVar = com.tencent.qqnt.trace.j.f362346a;
            jVar.g();
            KernelInitTask.this.f289758e.set(false);
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            KernelInitTask.this.v();
            iAccountCallback.onAccountChanged(peekAppRuntime);
            KernelInitTask.this.f289760h.countDown();
            QLog.d("KernelInitTask", 1, "INIT|nt sdk startSession finish cost:", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
            jVar.f();
            KernelInitTask.this.l();
        }

        @Override // e72.d
        public void a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this);
            } else {
                KernelInitTask.this.f289760h.countDown();
            }
        }

        @Override // e72.d
        public void b(@Nullable String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
                return;
            }
            KernelInitTask kernelInitTask = KernelInitTask.this;
            final IAccountCallback iAccountCallback = this.f289767a;
            kernelInitTask.m(new Runnable() { // from class: com.tencent.mobileqq.startup.task.ag
                @Override // java.lang.Runnable
                public final void run() {
                    KernelInitTask.c.this.d(iAccountCallback);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class d implements IKernelMsgListener {
        static IPatchRedirector $redirector_;

        d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) KernelInitTask.this);
            }
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onAddSendMsg(MsgRecord msgRecord) {
            com.tencent.qqnt.kernel.nativeinterface.ax.a(this, msgRecord);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onContactUnreadCntUpdate(HashMap hashMap) {
            com.tencent.qqnt.kernel.nativeinterface.ax.b(this, hashMap);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onCustomWithdrawConfigUpdate(CustomWithdrawConfig customWithdrawConfig) {
            com.tencent.qqnt.kernel.nativeinterface.ax.c(this, customWithdrawConfig);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onDraftUpdate(Contact contact, ArrayList arrayList, long j3) {
            com.tencent.qqnt.kernel.nativeinterface.ax.d(this, contact, arrayList, j3);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onEmojiDownloadComplete(EmojiNotifyInfo emojiNotifyInfo) {
            com.tencent.qqnt.kernel.nativeinterface.ax.e(this, emojiNotifyInfo);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onEmojiResourceUpdate(EmojiResourceInfo emojiResourceInfo) {
            com.tencent.qqnt.kernel.nativeinterface.ax.f(this, emojiResourceInfo);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onFileMsgCome(ArrayList arrayList) {
            com.tencent.qqnt.kernel.nativeinterface.ax.g(this, arrayList);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onGrabPasswordRedBag(int i3, String str, int i16, RecvdOrder recvdOrder, MsgRecord msgRecord) {
            com.tencent.qqnt.kernel.nativeinterface.ax.h(this, i3, str, i16, recvdOrder, msgRecord);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onGroupFileInfoAdd(GroupItem groupItem) {
            com.tencent.qqnt.kernel.nativeinterface.ax.i(this, groupItem);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onGroupFileInfoUpdate(GroupFileListResult groupFileListResult) {
            com.tencent.qqnt.kernel.nativeinterface.ax.j(this, groupFileListResult);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onGroupTransferInfoAdd(GroupItem groupItem) {
            com.tencent.qqnt.kernel.nativeinterface.ax.k(this, groupItem);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onGroupTransferInfoUpdate(GroupFileListResult groupFileListResult) {
            com.tencent.qqnt.kernel.nativeinterface.ax.l(this, groupFileListResult);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onHitCsRelatedEmojiResult(DownloadRelateEmojiResultInfo downloadRelateEmojiResultInfo) {
            com.tencent.qqnt.kernel.nativeinterface.ax.m(this, downloadRelateEmojiResultInfo);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onHitEmojiKeywordResult(HitRelatedEmojiWordsResult hitRelatedEmojiWordsResult) {
            com.tencent.qqnt.kernel.nativeinterface.ax.n(this, hitRelatedEmojiWordsResult);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onHitRelatedEmojiResult(RelatedWordEmojiInfo relatedWordEmojiInfo) {
            com.tencent.qqnt.kernel.nativeinterface.ax.o(this, relatedWordEmojiInfo);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onImportOldDbProgressUpdate(ImportOldDbMsgNotifyInfo importOldDbMsgNotifyInfo) {
            com.tencent.qqnt.kernel.nativeinterface.ax.p(this, importOldDbMsgNotifyInfo);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onInputStatusPush(InputStatusInfo inputStatusInfo) {
            com.tencent.qqnt.kernel.nativeinterface.ax.q(this, inputStatusInfo);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onKickedOffLine(KickedInfo kickedInfo) {
            com.tencent.qqnt.kernel.nativeinterface.ax.r(this, kickedInfo);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onLineDev(ArrayList arrayList) {
            com.tencent.qqnt.kernel.nativeinterface.ax.s(this, arrayList);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onLogLevelChanged(long j3) {
            com.tencent.qqnt.kernel.nativeinterface.ax.t(this, j3);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onMiscDataChanged(ArrayList arrayList) {
            com.tencent.qqnt.kernel.nativeinterface.ax.u(this, arrayList);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onMsgBoxChanged(ArrayList arrayList) {
            com.tencent.qqnt.kernel.nativeinterface.ax.v(this, arrayList);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onMsgDelete(Contact contact, ArrayList arrayList) {
            com.tencent.qqnt.kernel.nativeinterface.ax.w(this, contact, arrayList);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onMsgInfoListAdd(ArrayList arrayList) {
            com.tencent.qqnt.kernel.nativeinterface.ax.x(this, arrayList);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onMsgInfoListUpdate(ArrayList arrayList) {
            com.tencent.qqnt.kernel.nativeinterface.ax.y(this, arrayList);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onMsgQRCodeStatusChanged(int i3) {
            com.tencent.qqnt.kernel.nativeinterface.ax.z(this, i3);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onMsgRecall(int i3, String str, long j3) {
            com.tencent.qqnt.kernel.nativeinterface.ax.A(this, i3, str, j3);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onMsgSecurityNotify(MsgRecord msgRecord) {
            com.tencent.qqnt.kernel.nativeinterface.ax.B(this, msgRecord);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onMsgSettingUpdate(MsgSetting msgSetting) {
            com.tencent.qqnt.kernel.nativeinterface.ax.C(this, msgSetting);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onMsgWithRichLinkInfoUpdate(ArrayList arrayList) {
            com.tencent.qqnt.kernel.nativeinterface.ax.D(this, arrayList);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public void onNtFirstViewMsgSyncEnd() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this);
            } else {
                com.tencent.mobileqq.startup.monitor.d.f289708a.u();
                com.tencent.qqnt.trace.j.f362346a.m();
            }
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onNtMsgSyncContactUnread() {
            com.tencent.qqnt.kernel.nativeinterface.ax.F(this);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public void onNtMsgSyncEnd() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this);
                return;
            }
            com.tencent.qqnt.kernel.nativeinterface.ax.G(this);
            com.tencent.mobileqq.startup.director.a n3 = com.tencent.mobileqq.startup.director.a.n();
            if (n3 != null) {
                n3.y();
            }
            com.tencent.mobileqq.startup.monitor.a.f289702a.a();
            com.tencent.qqnt.trace.j.f362346a.p();
            ((ILoginRegisterApi) QRoute.api(ILoginRegisterApi.class)).onRegisterProxyEnd();
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public void onNtMsgSyncStart() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else {
                com.tencent.qqnt.trace.j.f362346a.q();
            }
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onRecvMsg(ArrayList arrayList) {
            com.tencent.qqnt.kernel.nativeinterface.ax.I(this, arrayList);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onRecvMsgSvrRspTransInfo(long j3, Contact contact, int i3, int i16, String str, byte[] bArr) {
            com.tencent.qqnt.kernel.nativeinterface.ax.J(this, j3, contact, i3, i16, str, bArr);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onRecvOnlineFileMsg(ArrayList arrayList) {
            com.tencent.qqnt.kernel.nativeinterface.ax.K(this, arrayList);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onRecvSysMsg(ArrayList arrayList) {
            com.tencent.qqnt.kernel.nativeinterface.ax.L(this, arrayList);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onRedTouchChanged() {
            com.tencent.qqnt.kernel.nativeinterface.ax.M(this);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onRichMediaDownloadComplete(FileTransNotifyInfo fileTransNotifyInfo) {
            com.tencent.qqnt.kernel.nativeinterface.ax.N(this, fileTransNotifyInfo);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onRichMediaProgerssUpdate(FileTransNotifyInfo fileTransNotifyInfo) {
            com.tencent.qqnt.kernel.nativeinterface.ax.O(this, fileTransNotifyInfo);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onRichMediaUploadComplete(FileTransNotifyInfo fileTransNotifyInfo) {
            com.tencent.qqnt.kernel.nativeinterface.ax.P(this, fileTransNotifyInfo);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onSearchGroupFileInfoUpdate(SearchGroupFileResult searchGroupFileResult) {
            com.tencent.qqnt.kernel.nativeinterface.ax.Q(this, searchGroupFileResult);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onSendMsgError(long j3, Contact contact, int i3, String str) {
            com.tencent.qqnt.kernel.nativeinterface.ax.R(this, j3, contact, i3, str);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onSysMsgNotification(int i3, long j3, long j16, boolean z16, ArrayList arrayList) {
            com.tencent.qqnt.kernel.nativeinterface.ax.S(this, i3, j3, j16, z16, arrayList);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onTempChatInfoUpdate(TempChatInfo tempChatInfo) {
            com.tencent.qqnt.kernel.nativeinterface.ax.T(this, tempChatInfo);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onUserChannelTabStatusChanged(boolean z16) {
            com.tencent.qqnt.kernel.nativeinterface.ax.U(this, z16);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onUserOnlineStatusChanged(boolean z16) {
            com.tencent.qqnt.kernel.nativeinterface.ax.V(this, z16);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onUserSecQualityChanged(QueryUserSecQualityRsp queryUserSecQualityRsp) {
            com.tencent.qqnt.kernel.nativeinterface.ax.W(this, queryUserSecQualityRsp);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onUserTabStatusChanged(ArrayList arrayList) {
            com.tencent.qqnt.kernel.nativeinterface.ax.X(this, arrayList);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onlineStatusBigIconDownloadPush(int i3, long j3, String str) {
            com.tencent.qqnt.kernel.nativeinterface.ax.Y(this, i3, j3, str);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onlineStatusSmallIconDownloadPush(int i3, long j3, String str) {
            com.tencent.qqnt.kernel.nativeinterface.ax.Z(this, i3, j3, str);
        }
    }

    public KernelInitTask() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f289757d = new AtomicBoolean(false);
        this.f289758e = new AtomicBoolean(false);
        this.f289760h = new CountDownLatch(1);
        this.f289761i = new Handler(ThreadManagerV2.getQQCommonThreadLooper());
        this.f289762m = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l() {
        boolean z16;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime instanceof QQAppInterface) {
            final QQAppInterface qQAppInterface = (QQAppInterface) peekAppRuntime;
            if (qQAppInterface.isAccLoginSuccess() && ce.INSTANCE.d()) {
                z16 = true;
            } else {
                z16 = false;
            }
            com.tencent.mobileqq.startup.director.a n3 = com.tencent.mobileqq.startup.director.a.n();
            QLog.d("KernelInitTask", 1, "P_ALL Automator checkAndExecute result:" + z16 + ", ntDirector:" + n3);
            if (z16 && n3 == null) {
                if (Looper.myLooper() == Looper.getMainLooper()) {
                    this.f289761i.postAtFrontOfQueue(new Runnable() { // from class: com.tencent.mobileqq.startup.task.ac
                        @Override // java.lang.Runnable
                        public final void run() {
                            KernelInitTask.p(QQAppInterface.this);
                        }
                    });
                } else {
                    Automator automator = qQAppInterface.mAutomator;
                    automator.M2(com.tencent.mobileqq.app.automator.h.a(automator, com.tencent.mobileqq.app.automator.h.f195319b));
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m(Runnable runnable) {
        QLog.d("KernelInitTask", 1, "checkAndRun ", com.tencent.mobileqq.startup.director.a.n());
        if (r()) {
            runnable.run();
        } else {
            this.f289761i.postAtFrontOfQueue(runnable);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(com.tencent.qqnt.kernel.api.w wVar) {
        if (wVar == null) {
            QLog.i("KernelInitTask", 1, "initKickListen but msgService is null");
            return;
        }
        d dVar = new d();
        this.f289759f = dVar;
        wVar.addMsgListener(dVar);
        QLog.d("KernelInitTask", 1, "register KickNT Listener Finish");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void o() {
        ((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).initFriendsInfoListener("register", true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void p(QQAppInterface qQAppInterface) {
        Automator automator = qQAppInterface.mAutomator;
        automator.M2(com.tencent.mobileqq.app.automator.h.a(automator, com.tencent.mobileqq.app.automator.h.f195319b));
    }

    private boolean q() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            return false;
        }
        if (((IGuildMainFrameApi) QRoute.api(IGuildMainFrameApi.class)).getGuildMainFrameClass().getName().equals(TabDataHelper.getTabCurrentManualTag(BaseApplication.getContext(), peekAppRuntime.getCurrentUin()))) {
            com.tencent.mobileqq.startup.monitor.d.f289708a.y(true);
            QLog.d("KernelInitTask", 1, "needJumpGuildTab and serial execute startSession!");
            return true;
        }
        com.tencent.mobileqq.startup.monitor.d.f289708a.y(false);
        return false;
    }

    private boolean r() {
        if (com.tencent.mobileqq.startup.director.a.n() == null || com.tencent.mobileqq.startup.a.f289663d == 0) {
            return true;
        }
        return q();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s(Runnable runnable) {
        boolean z16 = false;
        QLog.d("KernelInitTask", 1, "runInSubThread ", runnable);
        if (Looper.getMainLooper() == Looper.myLooper()) {
            z16 = true;
        }
        if (!com.tencent.mobileqq.startup.monitor.d.f289708a.d() && z16) {
            this.f289761i.postAtFrontOfQueue(runnable);
        } else {
            runnable.run();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void t() {
        ((IKickApi) QRoute.api(IKickApi.class)).setupKickListen(MobileQQ.sMobileQQ.peekAppRuntime(), ((IKickProcessorApi) QRoute.api(IKickProcessorApi.class)).getNTKickProcessor());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void u() {
        if (com.tencent.relation.common.utils.h.d().c()) {
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            if (peekAppRuntime == null) {
                QLog.e("KernelInitTask", 1, "null runtime!!!");
                return;
            } else {
                QLog.i("KernelInitTask", 1, "shelf QQ friend\uff0creq friend list");
                ((IFriendHandlerService) peekAppRuntime.getRuntimeService(IFriendHandlerService.class, "all")).requestFriendList(false);
                return;
            }
        }
        QLog.i("KernelInitTask", 1, "not shelf QQ friend");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v() {
        com.tencent.mobileqq.startup.director.a n3 = com.tencent.mobileqq.startup.director.a.n();
        if (n3 == null) {
            return;
        }
        ThreadManagerV2.excute(new Runnable(n3) { // from class: com.tencent.mobileqq.startup.task.KernelInitTask.4
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ com.tencent.mobileqq.startup.director.a f289763d;

            {
                this.f289763d = n3;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) KernelInitTask.this, (Object) n3);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                Runnable runnable;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                ((ICardContainerApi) QRoute.api(ICardContainerApi.class)).preloadCardContainerData();
                IRecentContactRepo mainRepoPreload = ((IChatsDataRepoCreator) QRoute.api(IChatsDataRepoCreator.class)).mainRepoPreload();
                if (mainRepoPreload != null) {
                    mainRepoPreload.h();
                }
                AppActivity o16 = this.f289763d.o();
                if (o16 != null && (runnable = o16.preloadUi(true).get("repo")) != null) {
                    runnable.run();
                }
            }
        }, 16, null, true);
    }

    @Override // com.tencent.qqnt.startup.task.c
    public void run(@NonNull Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context);
            return;
        }
        int i3 = MobileQQ.sProcessId;
        if (i3 != 1 && i3 != 4 && this.f289757d.compareAndSet(false, true)) {
            QLog.i("KernelInitTask", 1, "init kernel");
            ((IKernelSetter) QRoute.api(IKernelSetter.class)).getAccountCallback(new a());
        }
        if (MobileQQ.sProcessId == 1 && this.f289757d.compareAndSet(false, true)) {
            QLog.i("KernelInitTask", 1, "init kernel");
            IAccountCallback accountCallback = ((IKernelSetter) QRoute.api(IKernelSetter.class)).getAccountCallback(new b());
            IUidService iUidService = (IUidService) QRoute.api(IUidService.class);
            iUidService.registerUidCallback(new c(accountCallback));
            if (!iUidService.initUid()) {
                com.tencent.mobileqq.startup.monitor.d dVar = com.tencent.mobileqq.startup.monitor.d.f289708a;
                if (dVar.f()) {
                    QLog.d("KernelInitTask", 1, "Uid is null, but uid block switch close");
                    return;
                }
                QLog.d("KernelInitTask", 1, "Uid is null, wait for complete");
                try {
                    this.f289758e.set(true);
                    if (!this.f289760h.await(com.tencent.mobileqq.startup.a.f289660a * 3, TimeUnit.MILLISECONDS) && this.f289758e.get()) {
                        QLog.d("KernelInitTask", 1, "Uid is null and await timeout, start logout");
                        iUidService.logoutWhenReqUidFail();
                    }
                    dVar.c(false, "waitUid");
                } catch (InterruptedException e16) {
                    e16.printStackTrace();
                }
            }
        }
    }
}
