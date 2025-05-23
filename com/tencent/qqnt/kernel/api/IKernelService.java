package com.tencent.qqnt.kernel.api;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qfix.redirect.utils.ReflectUtils;
import com.tencent.mobileqq.qroute.annotation.Service;
import com.tencent.qqnt.kernel.nativeinterface.IKernelGroupTabService;
import com.tencent.qqnt.kernel.nativeinterface.IKernelLiteBusinessService;
import com.tencent.qqnt.kernel.nativeinterface.IKernelOnlineStatusService;
import com.tencent.qqnt.kernel.nativeinterface.IKernelQRService;
import com.tencent.qqnt.kernel.nativeinterface.IKernelSettingService;
import com.tencent.qqnt.kernel.nativeinterface.IKernelUnifySearchService;
import com.tencent.qqnt.kernel.nativeinterface.IOperateCallback;
import com.tencent.qqnt.kernel.nativeinterface.IQQNTWrapperSession;
import com.tencent.qqnt.kernel.nativeinterface.MsfChangeReasonType;
import com.tencent.qqnt.kernel.nativeinterface.MsfStatusType;
import com.tencent.qqnt.kernel.nativeinterface.NetStatusType;
import com.tencent.qqnt.kernel.nativeinterface.RegisterInfo;
import com.tencent.qqnt.kernel.nativeinterface.UnregisterInfo;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Service(needUin = false, process = {"all"})
@Metadata(d1 = {"\u0000\u00aa\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bg\u0018\u0000 h2\u00020\u0001:\u0001iJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\u0006\u001a\u00020\u0002H&J\b\u0010\u0007\u001a\u00020\u0002H&J\u0012\u0010\n\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\bH&J\u001e\u0010\r\u001a\u00020\u00042\u0014\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u000bH&J\u001c\u0010\u0011\u001a\u0016\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000ej\n\u0012\u0004\u0012\u00020\u000f\u0018\u0001`\u0010H&J\n\u0010\u0013\u001a\u0004\u0018\u00010\u0012H&J\n\u0010\u0015\u001a\u0004\u0018\u00010\u0014H&J\n\u0010\u0017\u001a\u0004\u0018\u00010\u0016H&J\n\u0010\u0019\u001a\u0004\u0018\u00010\u0018H&J\n\u0010\u001b\u001a\u0004\u0018\u00010\u001aH&J\n\u0010\u001d\u001a\u0004\u0018\u00010\u001cH&J\n\u0010\u001f\u001a\u0004\u0018\u00010\u001eH&J\n\u0010!\u001a\u0004\u0018\u00010 H&J\n\u0010#\u001a\u0004\u0018\u00010\"H&J\n\u0010%\u001a\u0004\u0018\u00010$H&J\n\u0010'\u001a\u0004\u0018\u00010&H&J\n\u0010)\u001a\u0004\u0018\u00010(H&J\n\u0010+\u001a\u0004\u0018\u00010*H&J\n\u0010-\u001a\u0004\u0018\u00010,H&J\"\u00104\u001a\u00020\u00042\u0006\u0010/\u001a\u00020.2\u0006\u00101\u001a\u0002002\b\b\u0002\u00103\u001a\u000202H&J\u0010\u00106\u001a\u00020\u00042\u0006\u0010/\u001a\u000205H&J\u0010\u00109\u001a\u00020\u00042\u0006\u00108\u001a\u000207H&J\u0018\u0010>\u001a\u00020\u00042\u0006\u0010;\u001a\u00020:2\u0006\u0010=\u001a\u00020<H&J\u0010\u0010@\u001a\u00020\u00022\u0006\u0010?\u001a\u00020\u0002H&J\n\u0010A\u001a\u0004\u0018\u00010\fH&J\b\u0010B\u001a\u00020\u0004H&J\n\u0010D\u001a\u0004\u0018\u00010CH&J\n\u0010F\u001a\u0004\u0018\u00010EH&J\n\u0010H\u001a\u0004\u0018\u00010GH&J\n\u0010J\u001a\u0004\u0018\u00010IH&J\n\u0010L\u001a\u0004\u0018\u00010KH&J\n\u0010N\u001a\u0004\u0018\u00010MH&J\n\u0010P\u001a\u0004\u0018\u00010OH&J\n\u0010R\u001a\u0004\u0018\u00010QH&J\n\u0010T\u001a\u0004\u0018\u00010SH&J\n\u0010V\u001a\u0004\u0018\u00010UH&J\n\u0010X\u001a\u0004\u0018\u00010WH&J\n\u0010Z\u001a\u0004\u0018\u00010YH&J\n\u0010\\\u001a\u0004\u0018\u00010[H&J\u0010\u0010_\u001a\u00020\u00042\u0006\u0010^\u001a\u00020]H&J\n\u0010a\u001a\u0004\u0018\u00010`H&J\n\u0010c\u001a\u0004\u0018\u00010bH&J\n\u0010e\u001a\u0004\u0018\u00010dH&J\n\u0010g\u001a\u0004\u0018\u00010fH&\u00a8\u0006j"}, d2 = {"Lcom/tencent/qqnt/kernel/api/IKernelService;", "Lmqq/app/api/IRuntimeService;", "", "useUid", "", "init", "isInit", "isDestroy", "Lcom/tencent/qqnt/kernel/api/u;", "listener", "start", "Lkotlin/Function1;", "Lcom/tencent/qqnt/kernel/nativeinterface/IQQNTWrapperSession;", "setSessionDestroyListener", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "getCacheErrLog", "Lcom/tencent/qqnt/kernel/api/m;", "getBuddyService", "Lcom/tencent/qqnt/kernel/api/f;", "getAddOrDelBuddyService", "Lcom/tencent/qqnt/kernel/api/s;", "getGroupService", "Lcom/tencent/qqnt/kernel/api/w;", "getMsgService", "Lcom/tencent/qqnt/kernel/api/t;", "getGuildMsgService", "Lcom/tencent/qqnt/kernel/api/aa;", "getRecentContactService", "Lcom/tencent/qqnt/kernel/api/y;", "getProfileService", "Lcom/tencent/qqnt/kernel/api/ae;", "getSearchService", "Lcom/tencent/qqnt/kernel/nativeinterface/IKernelSettingService;", "getSettingService", "Lcom/tencent/qqnt/kernel/api/h;", "getAvatarService", "Lcom/tencent/qqnt/kernel/api/ab;", "getRichMediaService", "Lcom/tencent/qqnt/kernel/api/i;", "getBaseEmojiService", "Lcom/tencent/qqnt/kernel/api/ag;", "getUixConvertService", "Lcom/tencent/qqnt/kernel/nativeinterface/IKernelLiteBusinessService;", "getLiteBusinessService", "Lcom/tencent/qqnt/kernel/nativeinterface/MsfStatusType;", "status", "Lcom/tencent/qqnt/kernel/nativeinterface/MsfChangeReasonType;", "reason", "", "connSeq", "setOnMsfStatusChanged", "Lcom/tencent/qqnt/kernel/nativeinterface/NetStatusType;", "setOnNetworkChanged", "Lcom/tencent/qqnt/kernel/nativeinterface/RegisterInfo;", "registerInfo", "onLine", "Lcom/tencent/qqnt/kernel/nativeinterface/UnregisterInfo;", "unregisterInfo", "Lcom/tencent/qqnt/kernel/nativeinterface/IOperateCallback;", "cb", "offLine", "userTrigger", "offLineSync", "getWrapperSession", "initSdkStatusStaticCallback", "Lcom/tencent/qqnt/kernel/api/af;", "getStorageCleanService", "Lcom/tencent/qqnt/kernel/api/ac;", "getRobotService", "Lcom/tencent/qqnt/kernel/api/r;", "getGroupSchoolService", "Lcom/tencent/qqnt/kernel/nativeinterface/IKernelQRService;", "getQRService", "Lcom/tencent/qqnt/kernel/api/x;", "getNearbyProService", "Lcom/tencent/qqnt/kernel/api/g;", "getAlbumService", "Lcom/tencent/qqnt/kernel/api/z;", "getQZAlbumxService", "Lcom/tencent/qqnt/kernel/api/e;", "getAVSDKService", "Lcom/tencent/qqnt/kernel/nativeinterface/IKernelGroupTabService;", "getGroupTabService", "Lcom/tencent/qqnt/kernel/api/n;", "getEmojiService", "Lcom/tencent/qqnt/kernel/api/l;", "getBdhUploadService", "Lcom/tencent/qqnt/kernel/nativeinterface/IKernelOnlineStatusService;", "getOnlineStatusService", "Lcom/tencent/qqnt/kernel/nativeinterface/IKernelUnifySearchService;", "getUnifySearchService", "", "groupUin", "setHighPriorityGroupUin", "Lcom/tencent/qqnt/kernel/api/ah;", "getWifiPhotoHostService", "Lcom/tencent/qqnt/kernel/api/p;", "getFileBridgeService", "Lcom/tencent/qqnt/kernel/api/k;", "getBatchUploadService", "Lcom/tencent/qqnt/kernel/api/q;", "getFlashTransferService", "Companion", "a", "kernel_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public interface IKernelService extends IRuntimeService {
    public static final IPatchRedirector $redirector_ = null;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;
    public static final int NT_DEPEND = 1021;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/qqnt/kernel/api/IKernelService$a;", "", "<init>", "()V", "kernel_api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.kernel.api.IKernelService$a, reason: from kotlin metadata */
    /* loaded from: classes24.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ Companion f357228a;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(40144);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
            } else {
                f357228a = new Companion();
            }
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes24.dex */
    public static final class b {
        public static /* synthetic */ void a(IKernelService iKernelService, MsfStatusType msfStatusType, MsfChangeReasonType msfChangeReasonType, int i3, int i16, Object obj) {
            if (obj == null) {
                if ((i16 & 4) != 0) {
                    i3 = 0;
                }
                iKernelService.setOnMsfStatusChanged(msfStatusType, msfChangeReasonType, i3);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setOnMsfStatusChanged");
        }
    }

    static {
        ReflectUtils.setStaticField(PatchRedirectCenter.getRedirector(40153), (Class<?>) IKernelService.class, "$redirector_");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1);
        } else {
            INSTANCE = Companion.f357228a;
        }
    }

    @Nullable
    e getAVSDKService();

    @Nullable
    f getAddOrDelBuddyService();

    @Nullable
    g getAlbumService();

    @Nullable
    h getAvatarService();

    @Nullable
    i getBaseEmojiService();

    @Nullable
    k getBatchUploadService();

    @Nullable
    l getBdhUploadService();

    @Nullable
    m getBuddyService();

    @Nullable
    ArrayList<String> getCacheErrLog();

    @Nullable
    n getEmojiService();

    @Nullable
    p getFileBridgeService();

    @Nullable
    q getFlashTransferService();

    @Nullable
    r getGroupSchoolService();

    @Nullable
    s getGroupService();

    @Nullable
    IKernelGroupTabService getGroupTabService();

    @Nullable
    t getGuildMsgService();

    @Nullable
    IKernelLiteBusinessService getLiteBusinessService();

    @Nullable
    w getMsgService();

    @Nullable
    x getNearbyProService();

    @Nullable
    IKernelOnlineStatusService getOnlineStatusService();

    @Nullable
    y getProfileService();

    @Nullable
    IKernelQRService getQRService();

    @Nullable
    z getQZAlbumxService();

    @Nullable
    aa getRecentContactService();

    @Nullable
    ab getRichMediaService();

    @Nullable
    ac getRobotService();

    @Nullable
    ae getSearchService();

    @Nullable
    IKernelSettingService getSettingService();

    @Nullable
    af getStorageCleanService();

    @Nullable
    ag getUixConvertService();

    @Nullable
    IKernelUnifySearchService getUnifySearchService();

    @Nullable
    ah getWifiPhotoHostService();

    @Nullable
    IQQNTWrapperSession getWrapperSession();

    void init(boolean useUid);

    void initSdkStatusStaticCallback();

    boolean isDestroy();

    boolean isInit();

    void offLine(@NotNull UnregisterInfo unregisterInfo, @NotNull IOperateCallback cb5);

    boolean offLineSync(boolean userTrigger);

    void onLine(@NotNull RegisterInfo registerInfo);

    void setHighPriorityGroupUin(long groupUin);

    void setOnMsfStatusChanged(@NotNull MsfStatusType status, @NotNull MsfChangeReasonType reason, int connSeq);

    void setOnNetworkChanged(@NotNull NetStatusType status);

    void setSessionDestroyListener(@Nullable Function1<? super IQQNTWrapperSession, Unit> listener);

    void start(@Nullable u listener);
}
