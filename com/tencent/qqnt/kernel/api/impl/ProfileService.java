package com.tencent.qqnt.kernel.api.impl;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.vas.theme.ThemeReporter;
import com.tencent.qqnt.kernel.api.impl.ProfileService;
import com.tencent.qqnt.kernel.internel.KLog;
import com.tencent.qqnt.kernel.nativeinterface.AiAvatarActionStatus;
import com.tencent.qqnt.kernel.nativeinterface.CoreInfo;
import com.tencent.qqnt.kernel.nativeinterface.GetAiAvatarCategoryInfosReq;
import com.tencent.qqnt.kernel.nativeinterface.IDetailInfoCallback;
import com.tencent.qqnt.kernel.nativeinterface.IGetAiAvatarCategoryInfosCallback;
import com.tencent.qqnt.kernel.nativeinterface.IKernelProfileListener;
import com.tencent.qqnt.kernel.nativeinterface.IKernelProfileService;
import com.tencent.qqnt.kernel.nativeinterface.IOperateCallback;
import com.tencent.qqnt.kernel.nativeinterface.Intimate;
import com.tencent.qqnt.kernel.nativeinterface.OtherFlag;
import com.tencent.qqnt.kernel.nativeinterface.ProfileBizType;
import com.tencent.qqnt.kernel.nativeinterface.RelationFlag;
import com.tencent.qqnt.kernel.nativeinterface.Source;
import com.tencent.qqnt.kernel.nativeinterface.StatusInfo;
import com.tencent.qqnt.kernel.nativeinterface.StockLocalData;
import com.tencent.qqnt.kernel.nativeinterface.UserDetailInfo;
import com.tencent.qqnt.kernel.nativeinterface.UserSimpleInfo;
import com.tencent.qqnt.kernel.nativeinterface.VasInfo;
import com.tencent.xweb.FileReaderHelper;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u00c5\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0001\u0006\u0018\u0000 P2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u0004:\u0001QB\u0019\u0012\b\u0010K\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010M\u001a\u00020L\u00a2\u0006\u0004\bN\u0010OJ\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0002H\u0002\u00a2\u0006\u0004\b\u0007\u0010\bJ\b\u0010\n\u001a\u00020\tH\u0002J\u0010\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u0002H\u0016J\u0010\u0010\r\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u0002H\u0016J\u0010\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u0002H\u0016J\u001a\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\t2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016J2\u0010\u0018\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u00132\u0016\u0010\u0017\u001a\u0012\u0012\u0004\u0012\u00020\t0\u0015j\b\u0012\u0004\u0012\u00020\t`\u00162\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016J\"\u0010\u001b\u001a\u00020\u000b2\u0006\u0010\u0019\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\u00132\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016JH\u0010 \u001a\"\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u001e\u0018\u00010\u001dj\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u001e\u0018\u0001`\u001f2\u0006\u0010\u001c\u001a\u00020\t2\u0016\u0010\u0017\u001a\u0012\u0012\u0004\u0012\u00020\t0\u0015j\b\u0012\u0004\u0012\u00020\t`\u0016H\u0016JH\u0010\"\u001a\"\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020!\u0018\u00010\u001dj\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020!\u0018\u0001`\u001f2\u0006\u0010\u001c\u001a\u00020\t2\u0016\u0010\u0017\u001a\u0012\u0012\u0004\u0012\u00020\t0\u0015j\b\u0012\u0004\u0012\u00020\t`\u0016H\u0016JL\u0010$\u001a\"\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020#\u0018\u00010\u001dj\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020#\u0018\u0001`\u001f2\u0006\u0010\u001c\u001a\u00020\t2\u001a\u0010\u0017\u001a\u0016\u0012\u0004\u0012\u00020\t\u0018\u00010\u0015j\n\u0012\u0004\u0012\u00020\t\u0018\u0001`\u0016H\u0016JL\u0010&\u001a\"\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020%\u0018\u00010\u001dj\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020%\u0018\u0001`\u001f2\u0006\u0010\u001c\u001a\u00020\t2\u001a\u0010\u0017\u001a\u0016\u0012\u0004\u0012\u00020\t\u0018\u00010\u0015j\n\u0012\u0004\u0012\u00020\t\u0018\u0001`\u0016H\u0016JL\u0010(\u001a\"\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020'\u0018\u00010\u001dj\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020'\u0018\u0001`\u001f2\u0006\u0010\u001c\u001a\u00020\t2\u001a\u0010\u0017\u001a\u0016\u0012\u0004\u0012\u00020\t\u0018\u00010\u0015j\n\u0012\u0004\u0012\u00020\t\u0018\u0001`\u0016H\u0016J<\u0010+\u001a\u00020\u00132\u0006\u0010\u001c\u001a\u00020\t2\"\u0010)\u001a\u001e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020'0\u001dj\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020'`\u001f2\u0006\u0010*\u001a\u00020\u0010H\u0016J6\u0010-\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020,\u0018\u00010\u001d2\u0006\u0010\u001c\u001a\u00020\t2\u0016\u0010\u0017\u001a\u0012\u0012\u0004\u0012\u00020\t0\u0015j\b\u0012\u0004\u0012\u00020\t`\u0016H\u0016J2\u0010/\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\t\u0012\u0004\u0012\u00020.\u0018\u00010\u001d2\b\u0010\u001c\u001a\u0004\u0018\u00010\t2\u000e\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u0015H\u0016JD\u00101\u001a\u001e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u0002000\u001dj\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u000200`\u001f2\u0006\u0010\u001c\u001a\u00020\t2\u0016\u0010\u0017\u001a\u0012\u0012\u0004\u0012\u00020\t0\u0015j\b\u0012\u0004\u0012\u00020\t`\u0016H\u0016J4\u00103\u001a\u000e\u0012\u0004\u0012\u000200\u0012\u0004\u0012\u00020\t0\u001d2\u0006\u0010\u001c\u001a\u00020\t2\u0016\u00102\u001a\u0012\u0012\u0004\u0012\u0002000\u0015j\b\u0012\u0004\u0012\u000200`\u0016H\u0016J \u00106\u001a\u00020\u000b2\u0006\u0010\u001c\u001a\u00020\t2\u0006\u00105\u001a\u0002042\u0006\u0010*\u001a\u00020\u0010H\u0016J\u0010\u00108\u001a\u00020\u000b2\u0006\u00107\u001a\u00020\u0013H\u0016JR\u0010?\u001a\u00020\u000b2\u0006\u0010\u001c\u001a\u00020\t2\u0016\u0010\u0019\u001a\u0012\u0012\u0004\u0012\u00020\t0\u0015j\b\u0012\u0004\u0012\u00020\t`\u00162\u0006\u0010:\u001a\u0002092\u0016\u0010<\u001a\u0012\u0012\u0004\u0012\u00020;0\u0015j\b\u0012\u0004\u0012\u00020;`\u00162\b\u0010>\u001a\u0004\u0018\u00010=H\u0016J\"\u0010E\u001a\u00020\u000b2\u0006\u0010A\u001a\u00020@2\u0006\u0010B\u001a\u00020\u00132\b\u0010D\u001a\u0004\u0018\u00010CH\u0016J*\u0010H\u001a\u00020\u000b2\u0016\u0010G\u001a\u0012\u0012\u0004\u0012\u00020F0\u0015j\b\u0012\u0004\u0012\u00020F`\u00162\b\u0010D\u001a\u0004\u0018\u00010\u0010H\u0016JH\u0010J\u001a\"\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020I\u0018\u00010\u001dj\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020I\u0018\u0001`\u001f2\u0006\u0010\u001c\u001a\u00020\t2\u0016\u0010\u0017\u001a\u0012\u0012\u0004\u0012\u00020\t0\u0015j\b\u0012\u0004\u0012\u00020\t`\u0016H\u0016\u00a8\u0006R"}, d2 = {"Lcom/tencent/qqnt/kernel/api/impl/ProfileService;", "Lcom/tencent/qqnt/kernel/api/impl/BaseService;", "Lcom/tencent/qqnt/kernel/nativeinterface/IKernelProfileListener;", "Lcom/tencent/qqnt/kernel/nativeinterface/IKernelProfileService;", "Lcom/tencent/qqnt/kernel/api/y;", "listener", "com/tencent/qqnt/kernel/api/impl/ProfileService$b", "r4", "(Lcom/tencent/qqnt/kernel/nativeinterface/IKernelProfileListener;)Lcom/tencent/qqnt/kernel/api/impl/ProfileService$b;", "", "q4", "", "r0", "D0", "addKernelProfileListenerForUICache", "nick", "Lcom/tencent/qqnt/kernel/nativeinterface/IOperateCallback;", "cb", "l0", "", FileReaderHelper.OPEN_FILE_FROM_FORCE, "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "uids", "getUserSimpleInfo", "uid", "forceRefresh", ThemeReporter.BUNDLE_KEY_TASK_GET_STATUS, "callFrom", "Ljava/util/HashMap;", "Lcom/tencent/qqnt/kernel/nativeinterface/UserSimpleInfo;", "Lkotlin/collections/HashMap;", "getCoreAndBaseInfo", "Lcom/tencent/qqnt/kernel/nativeinterface/RelationFlag;", "getRelationFlag", "Lcom/tencent/qqnt/kernel/nativeinterface/VasInfo;", "getVasInfo", "Lcom/tencent/qqnt/kernel/nativeinterface/Intimate;", "getIntimate", "Lcom/tencent/qqnt/kernel/nativeinterface/StockLocalData;", "getStockLocalData", "data", "callBack", "updateStockLocalData", "Lcom/tencent/qqnt/kernel/nativeinterface/StatusInfo;", "getStatusInfo", "Lcom/tencent/qqnt/kernel/nativeinterface/OtherFlag;", "getOtherFlag", "", "getUinByUid", "uin", "getUidByUin", "", "pb", "updateProfileData", "isForceReset", "startStatusPolling", "Lcom/tencent/qqnt/kernel/nativeinterface/Source;", "source", "Lcom/tencent/qqnt/kernel/nativeinterface/ProfileBizType;", "bizList", "Lcom/tencent/qqnt/kernel/nativeinterface/IDetailInfoCallback;", "result", "fetchUserDetailInfo", "Lcom/tencent/qqnt/kernel/nativeinterface/GetAiAvatarCategoryInfosReq;", "req", "forceFetch", "Lcom/tencent/qqnt/kernel/nativeinterface/IGetAiAvatarCategoryInfosCallback;", "callback", "getAiAvatarCategoryInfos", "Lcom/tencent/qqnt/kernel/nativeinterface/AiAvatarActionStatus;", "actions", "setAiAvatarActionStatus", "Lcom/tencent/qqnt/kernel/nativeinterface/CoreInfo;", "getCoreInfo", "service", "Lcom/tencent/qqnt/kernel/api/impl/py;", "content", "<init>", "(Lcom/tencent/qqnt/kernel/nativeinterface/IKernelProfileService;Lcom/tencent/qqnt/kernel/api/impl/py;)V", "d", "a", "kernel_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class ProfileService extends BaseService<IKernelProfileListener, IKernelProfileService> implements com.tencent.qqnt.kernel.api.y {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: e, reason: collision with root package name */
    private static boolean f357309e;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/qqnt/kernel/api/impl/ProfileService$a;", "", "", "SUB_TAG", "Ljava/lang/String;", "<init>", "()V", "kernel_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.kernel.api.impl.ProfileService$a, reason: from kotlin metadata */
    /* loaded from: classes24.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
                return;
            }
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Metadata(d1 = {"\u00009\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J,\u0010\b\u001a\u00020\u00072\"\u0010\u0006\u001a\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002j\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004`\u0005H\u0016J\u0012\u0010\u000b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016J,\u0010\u000e\u001a\u00020\u00072\"\u0010\r\u001a\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\f0\u0002j\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\f`\u0005H\u0016J\u0012\u0010\u000f\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\fH\u0016J,\u0010\u0012\u001a\u00020\u00072\"\u0010\u0011\u001a\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00100\u0002j\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0010`\u0005H\u0016\u00a8\u0006\u0013"}, d2 = {"com/tencent/qqnt/kernel/api/impl/ProfileService$b", "Lcom/tencent/qqnt/kernel/nativeinterface/IKernelProfileListener;", "Ljava/util/HashMap;", "", "Lcom/tencent/qqnt/kernel/nativeinterface/UserSimpleInfo;", "Lkotlin/collections/HashMap;", "profiles", "", "onProfileSimpleChanged", "Lcom/tencent/qqnt/kernel/nativeinterface/UserDetailInfo;", "info", "onUserDetailInfoChanged", "Lcom/tencent/qqnt/kernel/nativeinterface/StatusInfo;", "statusInfos", "onStatusUpdate", "onSelfStatusChanged", "Lcom/tencent/qqnt/kernel/nativeinterface/CoreInfo;", "remarks", "onStrangerRemarkChanged", "kernel_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes24.dex */
    public static final class b implements IKernelProfileListener {
        static IPatchRedirector $redirector_;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ IKernelProfileListener f357311e;

        b(IKernelProfileListener iKernelProfileListener) {
            this.f357311e = iKernelProfileListener;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ProfileService.this, (Object) iKernelProfileListener);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void f(HashMap profiles, IKernelProfileListener listener) {
            Intrinsics.checkNotNullParameter(profiles, "$profiles");
            Intrinsics.checkNotNullParameter(listener, "$listener");
            KLog.e(KLog.f359087a, "ProfileService", new Object[]{TuplesKt.to("onProfileSimpleChanged profiles", Integer.valueOf(profiles.size()))}, null, 4, null);
            listener.onProfileSimpleChanged(profiles);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void g(StatusInfo statusInfo, IKernelProfileListener listener) {
            Intrinsics.checkNotNullParameter(listener, "$listener");
            KLog.e(KLog.f359087a, "ProfileService", new Object[]{TuplesKt.to("onStatusUpdate statusInfos", statusInfo)}, null, 4, null);
            listener.onSelfStatusChanged(statusInfo);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void h(HashMap statusInfos, IKernelProfileListener listener) {
            Intrinsics.checkNotNullParameter(statusInfos, "$statusInfos");
            Intrinsics.checkNotNullParameter(listener, "$listener");
            KLog.e(KLog.f359087a, "ProfileService", new Object[]{TuplesKt.to("onStatusUpdate statusInfos", Integer.valueOf(statusInfos.size()))}, null, 4, null);
            listener.onStatusUpdate(statusInfos);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void i(HashMap remarks, IKernelProfileListener listener) {
            Intrinsics.checkNotNullParameter(remarks, "$remarks");
            Intrinsics.checkNotNullParameter(listener, "$listener");
            KLog.e(KLog.f359087a, "ProfileService", new Object[]{TuplesKt.to("onStrangerRemarkChanged remarks", Integer.valueOf(remarks.size()))}, null, 4, null);
            listener.onStrangerRemarkChanged(remarks);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void j(UserDetailInfo userDetailInfo, IKernelProfileListener listener) {
            Intrinsics.checkNotNullParameter(listener, "$listener");
            KLog.e(KLog.f359087a, "ProfileService", new Object[]{TuplesKt.to("onStatusUpdate statusInfos", userDetailInfo)}, null, 4, null);
            listener.onUserDetailInfoChanged(userDetailInfo);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelProfileListener
        public void onProfileSimpleChanged(@NotNull final HashMap<String, UserSimpleInfo> profiles) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) profiles);
                return;
            }
            Intrinsics.checkNotNullParameter(profiles, "profiles");
            ProfileService profileService = ProfileService.this;
            final IKernelProfileListener iKernelProfileListener = this.f357311e;
            profileService.postHandle(new Runnable() { // from class: com.tencent.qqnt.kernel.api.impl.le
                @Override // java.lang.Runnable
                public final void run() {
                    ProfileService.b.f(profiles, iKernelProfileListener);
                }
            });
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelProfileListener
        public void onSelfStatusChanged(@Nullable final StatusInfo info) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, (Object) info);
                return;
            }
            ProfileService profileService = ProfileService.this;
            final IKernelProfileListener iKernelProfileListener = this.f357311e;
            profileService.postHandle(new Runnable() { // from class: com.tencent.qqnt.kernel.api.impl.lf
                @Override // java.lang.Runnable
                public final void run() {
                    ProfileService.b.g(StatusInfo.this, iKernelProfileListener);
                }
            });
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelProfileListener
        public /* synthetic */ void onStatusAsyncFieldUpdate(HashMap hashMap) {
            com.tencent.qqnt.kernel.nativeinterface.be.c(this, hashMap);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelProfileListener
        public void onStatusUpdate(@NotNull final HashMap<String, StatusInfo> statusInfos) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) statusInfos);
                return;
            }
            Intrinsics.checkNotNullParameter(statusInfos, "statusInfos");
            ProfileService profileService = ProfileService.this;
            final IKernelProfileListener iKernelProfileListener = this.f357311e;
            profileService.postHandle(new Runnable() { // from class: com.tencent.qqnt.kernel.api.impl.lg
                @Override // java.lang.Runnable
                public final void run() {
                    ProfileService.b.h(statusInfos, iKernelProfileListener);
                }
            });
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelProfileListener
        public void onStrangerRemarkChanged(@NotNull final HashMap<String, CoreInfo> remarks) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, (Object) this, (Object) remarks);
                return;
            }
            Intrinsics.checkNotNullParameter(remarks, "remarks");
            ProfileService profileService = ProfileService.this;
            final IKernelProfileListener iKernelProfileListener = this.f357311e;
            profileService.postHandle(new Runnable() { // from class: com.tencent.qqnt.kernel.api.impl.ld
                @Override // java.lang.Runnable
                public final void run() {
                    ProfileService.b.i(remarks, iKernelProfileListener);
                }
            });
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelProfileListener
        public void onUserDetailInfoChanged(@Nullable final UserDetailInfo info) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) info);
                return;
            }
            ProfileService profileService = ProfileService.this;
            final IKernelProfileListener iKernelProfileListener = this.f357311e;
            profileService.postHandle(new Runnable() { // from class: com.tencent.qqnt.kernel.api.impl.lh
                @Override // java.lang.Runnable
                public final void run() {
                    ProfileService.b.j(UserDetailInfo.this, iKernelProfileListener);
                }
            });
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(51511);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 37)) {
            redirector.redirect((short) 37);
        } else {
            INSTANCE = new Companion(null);
            f357309e = com.tencent.util.l.f383986a.b("103210", true);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ProfileService(@Nullable IKernelProfileService iKernelProfileService, @NotNull py content) {
        super("ProfileService", content, iKernelProfileService);
        Intrinsics.checkNotNullParameter(content, "content");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) iKernelProfileService, (Object) content);
        }
    }

    private final String q4() {
        boolean z16;
        try {
            StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
            boolean z17 = true;
            if (stackTrace != null) {
                if (stackTrace.length == 0) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (!z16) {
                    z17 = false;
                }
            }
            if (z17) {
                return "";
            }
            StringBuilder sb5 = new StringBuilder();
            Intrinsics.checkNotNullExpressionValue(stackTrace, "stackTrace");
            for (StackTraceElement stackTraceElement : stackTrace) {
                sb5.append(stackTraceElement.toString());
                sb5.append("\n");
            }
            String sb6 = sb5.toString();
            Intrinsics.checkNotNullExpressionValue(sb6, "{\n            val stackT\u2026lder.toString()\n        }");
            return sb6;
        } catch (Throwable unused) {
            return "";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final b r4(IKernelProfileListener listener) {
        return new b(listener);
    }

    @Override // com.tencent.qqnt.kernel.api.y
    public void D0(@NotNull IKernelProfileListener listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) listener);
            return;
        }
        Intrinsics.checkNotNullParameter(listener, "listener");
        if (f357309e) {
            KLog.i(KLog.f359087a, "ProfileService", new Object[]{TuplesKt.to("removeProfileListener callFrom", q4())}, null, 4, null);
        }
        BaseService.removeListener$default(this, listener, false, new Function1<Long, Unit>() { // from class: com.tencent.qqnt.kernel.api.impl.ProfileService$removeProfileListener$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) ProfileService.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Long l3) {
                invoke(l3.longValue());
                return Unit.INSTANCE;
            }

            public final void invoke(long j3) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, j3);
                    return;
                }
                IKernelProfileService service = ProfileService.this.getService();
                if (service != null) {
                    service.removeKernelProfileListener(j3);
                }
            }
        }, 2, null);
    }

    @Override // com.tencent.qqnt.kernel.api.y
    public void addKernelProfileListenerForUICache(@NotNull IKernelProfileListener listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) listener);
            return;
        }
        Intrinsics.checkNotNullParameter(listener, "listener");
        if (f357309e) {
            KLog.i(KLog.f359087a, "ProfileService", new Object[]{TuplesKt.to("addKernelProfileListenerForUICache callFrom", q4())}, null, 4, null);
        }
        addListener(listener, new Function1<IKernelProfileListener, Long>() { // from class: com.tencent.qqnt.kernel.api.impl.ProfileService$addKernelProfileListenerForUICache$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) ProfileService.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            @Nullable
            public final Long invoke(@NotNull IKernelProfileListener it) {
                ProfileService.b r46;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (Long) iPatchRedirector2.redirect((short) 2, (Object) this, (Object) it);
                }
                Intrinsics.checkNotNullParameter(it, "it");
                IKernelProfileService service = ProfileService.this.getService();
                if (service == null) {
                    return null;
                }
                r46 = ProfileService.this.r4(it);
                return Long.valueOf(service.addKernelProfileListenerForUICache(r46));
            }
        });
    }

    @Override // com.tencent.qqnt.kernel.api.y
    public void fetchUserDetailInfo(@NotNull final String callFrom, @NotNull final ArrayList<String> uid, @NotNull final Source source, @NotNull final ArrayList<ProfileBizType> bizList, @Nullable IDetailInfoCallback result) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            iPatchRedirector.redirect((short) 28, this, callFrom, uid, source, bizList, result);
            return;
        }
        Intrinsics.checkNotNullParameter(callFrom, "callFrom");
        Intrinsics.checkNotNullParameter(uid, "uid");
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(bizList, "bizList");
        check("fetchUserDetailInfo", result, new Function1<IDetailInfoCallback, Unit>(callFrom, uid, source, bizList) { // from class: com.tencent.qqnt.kernel.api.impl.ProfileService$fetchUserDetailInfo$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ ArrayList<ProfileBizType> $bizList;
            final /* synthetic */ String $callFrom;
            final /* synthetic */ Source $source;
            final /* synthetic */ ArrayList<String> $uid;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.$callFrom = callFrom;
                this.$uid = uid;
                this.$source = source;
                this.$bizList = bizList;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, ProfileService.this, callFrom, uid, source, bizList);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            @Nullable
            public final Unit invoke(@Nullable IDetailInfoCallback iDetailInfoCallback) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (Unit) iPatchRedirector2.redirect((short) 2, (Object) this, (Object) iDetailInfoCallback);
                }
                IKernelProfileService service = ProfileService.this.getService();
                if (service == null) {
                    return null;
                }
                service.fetchUserDetailInfo(this.$callFrom, this.$uid, this.$source, this.$bizList, iDetailInfoCallback);
                return Unit.INSTANCE;
            }
        });
    }

    @Override // com.tencent.qqnt.kernel.api.y
    public void getAiAvatarCategoryInfos(@NotNull final GetAiAvatarCategoryInfosReq req, final boolean forceFetch, @Nullable final IGetAiAvatarCategoryInfosCallback callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            iPatchRedirector.redirect((short) 33, this, req, Boolean.valueOf(forceFetch), callback);
        } else {
            Intrinsics.checkNotNullParameter(req, "req");
            BaseService.checkCommon$default(this, "getAiAvatarCategoryInfos", new Function0<Unit>(req, forceFetch, callback) { // from class: com.tencent.qqnt.kernel.api.impl.ProfileService$getAiAvatarCategoryInfos$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ IGetAiAvatarCategoryInfosCallback $callback;
                final /* synthetic */ boolean $forceFetch;
                final /* synthetic */ GetAiAvatarCategoryInfosReq $req;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    this.$req = req;
                    this.$forceFetch = forceFetch;
                    this.$callback = callback;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, ProfileService.this, req, Boolean.valueOf(forceFetch), callback);
                    }
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    IKernelProfileService service = ProfileService.this.getService();
                    if (service != null) {
                        service.getAiAvatarCategoryInfos(this.$req, this.$forceFetch, this.$callback);
                    }
                }
            }, null, 4, null);
        }
    }

    @Override // com.tencent.qqnt.kernel.api.y
    @Nullable
    public HashMap<String, UserSimpleInfo> getCoreAndBaseInfo(@NotNull String callFrom, @NotNull ArrayList<String> uids) {
        HashMap<String, UserSimpleInfo> coreAndBaseInfo;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return (HashMap) iPatchRedirector.redirect((short) 15, (Object) this, (Object) callFrom, (Object) uids);
        }
        Intrinsics.checkNotNullParameter(callFrom, "callFrom");
        Intrinsics.checkNotNullParameter(uids, "uids");
        IKernelProfileService service = getService();
        if (service != null && (coreAndBaseInfo = service.getCoreAndBaseInfo(callFrom, uids)) != null) {
            return coreAndBaseInfo;
        }
        return null;
    }

    @Override // com.tencent.qqnt.kernel.api.y
    @Nullable
    public HashMap<String, CoreInfo> getCoreInfo(@NotNull String callFrom, @NotNull ArrayList<String> uids) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 35)) {
            return (HashMap) iPatchRedirector.redirect((short) 35, (Object) this, (Object) callFrom, (Object) uids);
        }
        Intrinsics.checkNotNullParameter(callFrom, "callFrom");
        Intrinsics.checkNotNullParameter(uids, "uids");
        IKernelProfileService service = getService();
        if (service != null) {
            return service.getCoreInfo(callFrom, uids);
        }
        return null;
    }

    @Override // com.tencent.qqnt.kernel.api.y
    @Nullable
    public HashMap<String, Intimate> getIntimate(@NotNull String callFrom, @Nullable ArrayList<String> uids) {
        HashMap<String, Intimate> intimate;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return (HashMap) iPatchRedirector.redirect((short) 18, (Object) this, (Object) callFrom, (Object) uids);
        }
        Intrinsics.checkNotNullParameter(callFrom, "callFrom");
        IKernelProfileService service = getService();
        if (service != null && (intimate = service.getIntimate(callFrom, uids)) != null) {
            return intimate;
        }
        return null;
    }

    @Override // com.tencent.qqnt.kernel.api.y
    @Nullable
    public HashMap<String, OtherFlag> getOtherFlag(@Nullable String callFrom, @Nullable ArrayList<String> uids) {
        HashMap<String, OtherFlag> otherFlag;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return (HashMap) iPatchRedirector.redirect((short) 22, (Object) this, (Object) callFrom, (Object) uids);
        }
        IKernelProfileService service = getService();
        if (service != null && (otherFlag = service.getOtherFlag(callFrom, uids)) != null) {
            return otherFlag;
        }
        return null;
    }

    @Override // com.tencent.qqnt.kernel.api.y
    @Nullable
    public HashMap<String, RelationFlag> getRelationFlag(@NotNull String callFrom, @NotNull ArrayList<String> uids) {
        HashMap<String, RelationFlag> relationFlag;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return (HashMap) iPatchRedirector.redirect((short) 16, (Object) this, (Object) callFrom, (Object) uids);
        }
        Intrinsics.checkNotNullParameter(callFrom, "callFrom");
        Intrinsics.checkNotNullParameter(uids, "uids");
        IKernelProfileService service = getService();
        if (service != null && (relationFlag = service.getRelationFlag(callFrom, uids)) != null) {
            return relationFlag;
        }
        return null;
    }

    @Override // com.tencent.qqnt.kernel.api.y
    public void getStatus(@NotNull final String uid, final boolean forceRefresh, @Nullable IOperateCallback cb5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, this, uid, Boolean.valueOf(forceRefresh), cb5);
        } else {
            Intrinsics.checkNotNullParameter(uid, "uid");
            check(ThemeReporter.BUNDLE_KEY_TASK_GET_STATUS, cb5, new Function1<IOperateCallback, Unit>(uid, forceRefresh) { // from class: com.tencent.qqnt.kernel.api.impl.ProfileService$getStatus$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ boolean $forceRefresh;
                final /* synthetic */ String $uid;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                    this.$uid = uid;
                    this.$forceRefresh = forceRefresh;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, ProfileService.this, uid, Boolean.valueOf(forceRefresh));
                    }
                }

                @Override // kotlin.jvm.functions.Function1
                @Nullable
                public final Unit invoke(@Nullable IOperateCallback iOperateCallback) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (Unit) iPatchRedirector2.redirect((short) 2, (Object) this, (Object) iOperateCallback);
                    }
                    IKernelProfileService service = ProfileService.this.getService();
                    if (service == null) {
                        return null;
                    }
                    service.getStatus(this.$uid, this.$forceRefresh, iOperateCallback);
                    return Unit.INSTANCE;
                }
            });
        }
    }

    @Override // com.tencent.qqnt.kernel.api.y
    @Nullable
    public HashMap<String, StatusInfo> getStatusInfo(@NotNull String callFrom, @NotNull ArrayList<String> uids) {
        HashMap<String, StatusInfo> statusInfo;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return (HashMap) iPatchRedirector.redirect((short) 21, (Object) this, (Object) callFrom, (Object) uids);
        }
        Intrinsics.checkNotNullParameter(callFrom, "callFrom");
        Intrinsics.checkNotNullParameter(uids, "uids");
        IKernelProfileService service = getService();
        if (service != null && (statusInfo = service.getStatusInfo(callFrom, uids)) != null) {
            return statusInfo;
        }
        return null;
    }

    @Override // com.tencent.qqnt.kernel.api.y
    @Nullable
    public HashMap<String, StockLocalData> getStockLocalData(@NotNull String callFrom, @Nullable ArrayList<String> uids) {
        HashMap<String, StockLocalData> stockLocalData;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return (HashMap) iPatchRedirector.redirect((short) 19, (Object) this, (Object) callFrom, (Object) uids);
        }
        Intrinsics.checkNotNullParameter(callFrom, "callFrom");
        IKernelProfileService service = getService();
        if (service != null && (stockLocalData = service.getStockLocalData(callFrom, uids)) != null) {
            return stockLocalData;
        }
        return null;
    }

    @Override // com.tencent.qqnt.kernel.api.y
    @NotNull
    public HashMap<Long, String> getUidByUin(@NotNull String callFrom, @NotNull ArrayList<Long> uin) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            return (HashMap) iPatchRedirector.redirect((short) 24, (Object) this, (Object) callFrom, (Object) uin);
        }
        Intrinsics.checkNotNullParameter(callFrom, "callFrom");
        Intrinsics.checkNotNullParameter(uin, "uin");
        IKernelProfileService service = getService();
        if (service != null) {
            HashMap<Long, String> uidByUin = service.getUidByUin(callFrom, uin);
            Intrinsics.checkNotNullExpressionValue(uidByUin, "it.getUidByUin(callFrom, uin)");
            return uidByUin;
        }
        return new HashMap<>();
    }

    @Override // com.tencent.qqnt.kernel.api.y
    @NotNull
    public HashMap<String, Long> getUinByUid(@NotNull String callFrom, @NotNull ArrayList<String> uids) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return (HashMap) iPatchRedirector.redirect((short) 23, (Object) this, (Object) callFrom, (Object) uids);
        }
        Intrinsics.checkNotNullParameter(callFrom, "callFrom");
        Intrinsics.checkNotNullParameter(uids, "uids");
        IKernelProfileService service = getService();
        if (service != null) {
            HashMap<String, Long> uinByUid = service.getUinByUid(callFrom, uids);
            Intrinsics.checkNotNullExpressionValue(uinByUid, "it.getUinByUid(callFrom, uids)");
            return uinByUid;
        }
        return new HashMap<>();
    }

    @Override // com.tencent.qqnt.kernel.api.y
    public void getUserSimpleInfo(final boolean force, @NotNull final ArrayList<String> uids, @Nullable IOperateCallback cb5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, Boolean.valueOf(force), uids, cb5);
        } else {
            Intrinsics.checkNotNullParameter(uids, "uids");
            check("getUserSimpleInfo", cb5, new Function1<IOperateCallback, Unit>(force, uids) { // from class: com.tencent.qqnt.kernel.api.impl.ProfileService$getUserSimpleInfo$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ boolean $force;
                final /* synthetic */ ArrayList<String> $uids;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                    this.$force = force;
                    this.$uids = uids;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, ProfileService.this, Boolean.valueOf(force), uids);
                    }
                }

                @Override // kotlin.jvm.functions.Function1
                @Nullable
                public final Unit invoke(@Nullable IOperateCallback iOperateCallback) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (Unit) iPatchRedirector2.redirect((short) 2, (Object) this, (Object) iOperateCallback);
                    }
                    IKernelProfileService service = ProfileService.this.getService();
                    if (service == null) {
                        return null;
                    }
                    service.getUserSimpleInfo(this.$force, this.$uids, iOperateCallback);
                    return Unit.INSTANCE;
                }
            });
        }
    }

    @Override // com.tencent.qqnt.kernel.api.y
    @Nullable
    public HashMap<String, VasInfo> getVasInfo(@NotNull String callFrom, @Nullable ArrayList<String> uids) {
        HashMap<String, VasInfo> vasInfo;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return (HashMap) iPatchRedirector.redirect((short) 17, (Object) this, (Object) callFrom, (Object) uids);
        }
        Intrinsics.checkNotNullParameter(callFrom, "callFrom");
        IKernelProfileService service = getService();
        if (service != null && (vasInfo = service.getVasInfo(callFrom, uids)) != null) {
            return vasInfo;
        }
        return null;
    }

    @Override // com.tencent.qqnt.kernel.api.y
    public void l0(@NotNull final String nick, @Nullable IOperateCallback cb5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) nick, (Object) cb5);
        } else {
            Intrinsics.checkNotNullParameter(nick, "nick");
            check("setSelfNick", cb5, new Function1<IOperateCallback, Unit>(nick) { // from class: com.tencent.qqnt.kernel.api.impl.ProfileService$setSelfNick$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ String $nick;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                    this.$nick = nick;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) ProfileService.this, (Object) nick);
                    }
                }

                @Override // kotlin.jvm.functions.Function1
                @Nullable
                public final Unit invoke(@Nullable IOperateCallback iOperateCallback) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (Unit) iPatchRedirector2.redirect((short) 2, (Object) this, (Object) iOperateCallback);
                    }
                    IKernelProfileService service = ProfileService.this.getService();
                    if (service == null) {
                        return null;
                    }
                    service.setNickName(this.$nick, iOperateCallback);
                    return Unit.INSTANCE;
                }
            });
        }
    }

    @Override // com.tencent.qqnt.kernel.api.y
    public void r0(@NotNull IKernelProfileListener listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) listener);
            return;
        }
        Intrinsics.checkNotNullParameter(listener, "listener");
        KLog kLog = KLog.f359087a;
        KLog.i(kLog, "ProfileService", new Object[]{TuplesKt.to("isLogSwitch", Boolean.valueOf(f357309e))}, null, 4, null);
        if (f357309e) {
            KLog.i(kLog, "ProfileService", new Object[]{TuplesKt.to("addProfileListener callFrom", q4())}, null, 4, null);
        }
        addListener(listener, new Function1<IKernelProfileListener, Long>() { // from class: com.tencent.qqnt.kernel.api.impl.ProfileService$addProfileListener$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) ProfileService.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            @Nullable
            public final Long invoke(@NotNull IKernelProfileListener it) {
                ProfileService.b r46;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (Long) iPatchRedirector2.redirect((short) 2, (Object) this, (Object) it);
                }
                Intrinsics.checkNotNullParameter(it, "it");
                IKernelProfileService service = ProfileService.this.getService();
                if (service == null) {
                    return null;
                }
                r46 = ProfileService.this.r4(it);
                return Long.valueOf(service.addKernelProfileListener(r46));
            }
        });
    }

    @Override // com.tencent.qqnt.kernel.api.y
    public void setAiAvatarActionStatus(@NotNull final ArrayList<AiAvatarActionStatus> actions, @Nullable final IOperateCallback callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
            iPatchRedirector.redirect((short) 34, (Object) this, (Object) actions, (Object) callback);
        } else {
            Intrinsics.checkNotNullParameter(actions, "actions");
            BaseService.checkCommon$default(this, "setAiAvatarActionStatus", new Function0<Unit>(actions, callback) { // from class: com.tencent.qqnt.kernel.api.impl.ProfileService$setAiAvatarActionStatus$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ ArrayList<AiAvatarActionStatus> $actions;
                final /* synthetic */ IOperateCallback $callback;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    this.$actions = actions;
                    this.$callback = callback;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, ProfileService.this, actions, callback);
                    }
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    IKernelProfileService service = ProfileService.this.getService();
                    if (service != null) {
                        service.setAiAvatarActionStatus(this.$actions, this.$callback);
                    }
                }
            }, null, 4, null);
        }
    }

    @Override // com.tencent.qqnt.kernel.api.y
    public void startStatusPolling(final boolean isForceReset) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            iPatchRedirector.redirect((short) 27, (Object) this, isForceReset);
        } else {
            check("startStatusPolling", new Function0<Unit>(isForceReset) { // from class: com.tencent.qqnt.kernel.api.impl.ProfileService$startStatusPolling$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ boolean $isForceReset;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    this.$isForceReset = isForceReset;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, ProfileService.this, Boolean.valueOf(isForceReset));
                    }
                }

                @Override // kotlin.jvm.functions.Function0
                @Nullable
                public final Unit invoke() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (Unit) iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                    IKernelProfileService service = ProfileService.this.getService();
                    if (service == null) {
                        return null;
                    }
                    service.startStatusPolling(this.$isForceReset);
                    return Unit.INSTANCE;
                }
            });
        }
    }

    @Override // com.tencent.qqnt.kernel.api.y
    public void updateProfileData(@NotNull final String callFrom, @NotNull final byte[] pb5, @NotNull IOperateCallback callBack) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, this, callFrom, pb5, callBack);
            return;
        }
        Intrinsics.checkNotNullParameter(callFrom, "callFrom");
        Intrinsics.checkNotNullParameter(pb5, "pb");
        Intrinsics.checkNotNullParameter(callBack, "callBack");
        check("updateProfileData", callBack, new Function1<IOperateCallback, Unit>(callFrom, pb5) { // from class: com.tencent.qqnt.kernel.api.impl.ProfileService$updateProfileData$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ String $callFrom;
            final /* synthetic */ byte[] $pb;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.$callFrom = callFrom;
                this.$pb = pb5;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, ProfileService.this, callFrom, pb5);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            @Nullable
            public final Unit invoke(@Nullable IOperateCallback iOperateCallback) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (Unit) iPatchRedirector2.redirect((short) 2, (Object) this, (Object) iOperateCallback);
                }
                IKernelProfileService service = ProfileService.this.getService();
                if (service == null) {
                    return null;
                }
                service.updateProfileData(this.$callFrom, this.$pb, iOperateCallback);
                return Unit.INSTANCE;
            }
        });
    }

    @Override // com.tencent.qqnt.kernel.api.y
    public boolean updateStockLocalData(@NotNull final String callFrom, @NotNull final HashMap<String, StockLocalData> data, @NotNull IOperateCallback callBack) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return ((Boolean) iPatchRedirector.redirect((short) 20, this, callFrom, data, callBack)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(callFrom, "callFrom");
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(callBack, "callBack");
        check("getUserDetailInfo", callBack, new Function1<IOperateCallback, Unit>(callFrom, data) { // from class: com.tencent.qqnt.kernel.api.impl.ProfileService$updateStockLocalData$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ String $callFrom;
            final /* synthetic */ HashMap<String, StockLocalData> $data;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.$callFrom = callFrom;
                this.$data = data;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, ProfileService.this, callFrom, data);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            @Nullable
            public final Unit invoke(@Nullable IOperateCallback iOperateCallback) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (Unit) iPatchRedirector2.redirect((short) 2, (Object) this, (Object) iOperateCallback);
                }
                IKernelProfileService service = ProfileService.this.getService();
                if (service == null) {
                    return null;
                }
                service.updateStockLocalData(this.$callFrom, this.$data, iOperateCallback);
                return Unit.INSTANCE;
            }
        });
        return true;
    }
}
