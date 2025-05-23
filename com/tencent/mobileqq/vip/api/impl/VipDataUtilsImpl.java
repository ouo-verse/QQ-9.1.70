package com.tencent.mobileqq.vip.api.impl;

import android.os.SystemClock;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.VasLogNtReporter;
import com.tencent.mobileqq.vas.VasNtMMKV;
import com.tencent.mobileqq.vas.VasNtToggle;
import com.tencent.mobileqq.vas.VipNtMMKV;
import com.tencent.mobileqq.vas.api.IPbProtocol;
import com.tencent.mobileqq.vas.ar;
import com.tencent.mobileqq.vip.api.IVipDataUtils;
import com.tencent.mobileqq.vip.api.VipData;
import com.tencent.pb.vipdata.vipdata$GetUserDataReq;
import com.tencent.pb.vipdata.vipdata$GetUserDataRsp;
import com.tencent.pb.vipdata.vipdata$UserInfo;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 02\u00020\u0001:\u00011B\u0007\u00a2\u0006\u0004\b.\u0010/J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J \u0010\t\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006H\u0002J\b\u0010\n\u001a\u00020\u0007H\u0002J\u0012\u0010\f\u001a\u00020\u000b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0012\u0010\r\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u001a\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u000f\u001a\u00020\u000eH\u0016J\u001a\u0010\u0011\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0010\u001a\u00020\u000eH\u0016J\u0018\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0012H\u0016J\u001a\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0016J \u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006H\u0016R \u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00180\u00178\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001c\u001a\u00020\u001b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR.\u0010 \u001a\u001c\u0012\u0004\u0012\u00020\u0002\u0012\u0012\u0012\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u001f\u0018\u00010\u001e0\u00178\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b \u0010\u001aR$\u0010#\u001a\u0012\u0012\u0004\u0012\u00020\u00020!j\b\u0012\u0004\u0012\u00020\u0002`\"8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b#\u0010$R\u0018\u0010&\u001a\u0004\u0018\u00010%8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b&\u0010'R\u0014\u0010(\u001a\u00020\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b(\u0010)R\u001a\u0010*\u001a\u00020\u00028\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-\u00a8\u00062"}, d2 = {"Lcom/tencent/mobileqq/vip/api/impl/VipDataUtilsImpl;", "Lcom/tencent/mobileqq/vip/api/IVipDataUtils;", "", "uin", "Lcom/tencent/mobileqq/vip/api/VipData;", "getVipData", "Lkotlin/Function0;", "", "callBack", "requestVipData", "batchRequest", "", "checkUinValid", "getVipDataForFriends", "", "vipdataFlag", "vipDataFlag", "updateFlagData", "Lcom/tencent/mobileqq/vip/api/j;", "callback", "registerVipDataChangedCallback", "unRegisterVipDataChangedCallback", "requestAndUpdateData", "Ljava/util/concurrent/ConcurrentHashMap;", "", "timeStamps", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/tencent/mobileqq/vip/api/impl/m;", "impl", "Lcom/tencent/mobileqq/vip/api/impl/m;", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Ljava/lang/ref/WeakReference;", "changedCallbackCache", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "requestUsers", "Ljava/util/ArrayList;", "Ljava/lang/Runnable;", "runnable", "Ljava/lang/Runnable;", "batchEnableSwitch", "Z", "splendidTitle", "Ljava/lang/String;", "getSplendidTitle", "()Ljava/lang/String;", "<init>", "()V", "Companion", "a", "vas_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class VipDataUtilsImpl implements IVipDataUtils {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    @NotNull
    public static final String TAG = "VipDataUtilsImpl";
    private final boolean batchEnableSwitch;

    @NotNull
    private final ConcurrentHashMap<String, CopyOnWriteArrayList<WeakReference<com.tencent.mobileqq.vip.api.j>>> changedCallbackCache;

    @NotNull
    private final m impl;

    @NotNull
    private final ArrayList<String> requestUsers;

    @Nullable
    private volatile Runnable runnable;

    @NotNull
    private final String splendidTitle;

    @NotNull
    private final ConcurrentHashMap<String, Long> timeStamps;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/vip/api/impl/VipDataUtilsImpl$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "vas_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.vip.api.impl.VipDataUtilsImpl$a, reason: from kotlin metadata */
    /* loaded from: classes20.dex */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(44421);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 9)) {
            redirector.redirect((short) 9);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public VipDataUtilsImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.timeStamps = new ConcurrentHashMap<>();
        this.impl = new m();
        this.changedCallbackCache = new ConcurrentHashMap<>();
        this.requestUsers = new ArrayList<>();
        this.batchEnableSwitch = ar.INSTANCE.b("anzaihuang", "2024-06-06", "vas_vipdata_batch_request_switch").isEnable(true);
        String stringDataSet = VasNtToggle.INSTANCE.getVAS_SPLENDID_AVATAR_CONFIG().getStringDataSet("title", "\u9ad8\u80fd");
        Intrinsics.checkNotNull(stringDataSet);
        this.splendidTitle = stringDataSet;
    }

    private final void batchRequest() {
        VasLogNtReporter.INSTANCE.getVipData().reportDebug("requestVipData batch");
        vipdata$GetUserDataReq vipdata_getuserdatareq = new vipdata$GetUserDataReq();
        synchronized (this) {
            Iterator<T> it = this.requestUsers.iterator();
            while (it.hasNext()) {
                vipdata_getuserdatareq.uin.add(Long.valueOf(Long.parseLong((String) it.next())));
            }
            this.runnable = null;
            this.requestUsers.clear();
            Unit unit = Unit.INSTANCE;
        }
        ((IPbProtocol) QRoute.api(IPbProtocol.class)).request("trpc.qqva.vipdata.Vipdata.SsoGetUserData", vipdata_getuserdatareq, vipdata$GetUserDataRsp.class, new BusinessObserver() { // from class: com.tencent.mobileqq.vip.api.impl.q
            @Override // com.tencent.mobileqq.app.BusinessObserver
            public final void onUpdate(int i3, boolean z16, Object obj) {
                VipDataUtilsImpl.batchRequest$lambda$9(VipDataUtilsImpl.this, i3, z16, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void batchRequest$lambda$9(VipDataUtilsImpl this$0, int i3, boolean z16, Object obj) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (QLog.isColorLevel()) {
            VasLogNtReporter.INSTANCE.getVipData().reportLow("receive callback");
        }
        if (z16 && (obj instanceof vipdata$GetUserDataRsp)) {
            List<vipdata$UserInfo> list = ((vipdata$GetUserDataRsp) obj).info.get();
            Intrinsics.checkNotNullExpressionValue(list, "data.info.get()");
            for (vipdata$UserInfo it : list) {
                String valueOf = String.valueOf(it.uin.get());
                String decodeString = VasNtMMKV.INSTANCE.getVipDataRandomKey().decodeString(valueOf, this$0.impl.d(valueOf, 0));
                m mVar = this$0.impl;
                Intrinsics.checkNotNullExpressionValue(it, "it");
                if (decodeString == null) {
                    decodeString = "";
                }
                mVar.f(it, decodeString, this$0.changedCallbackCache.get(valueOf));
            }
        }
    }

    private final boolean checkUinValid(String uin) {
        boolean z16;
        if (uin != null && uin.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            return false;
        }
        try {
            if (Long.parseLong(uin) != 0) {
                return true;
            }
            return false;
        } catch (NumberFormatException unused) {
            if (!com.tencent.qqnt.util.b.f362976b.isDebugVersion()) {
                QLog.e(TAG, 1, "uin is invalid " + uin);
                return false;
            }
            throw new NumberFormatException("uin is invalid");
        }
    }

    private final void requestVipData(String uin, final Function0<Unit> callBack) {
        final String decodeString;
        if (!checkUinValid(uin) || (decodeString = VasNtMMKV.INSTANCE.getVipDataRandomKey().decodeString(uin, this.impl.d(uin, 0))) == null) {
            return;
        }
        long uptimeMillis = SystemClock.uptimeMillis();
        Long l3 = this.timeStamps.get(uin + decodeString);
        if (l3 != null && Math.abs(uptimeMillis - l3.longValue()) < 5000 && callBack == null) {
            return;
        }
        Long valueOf = Long.valueOf(uptimeMillis);
        this.timeStamps.put(uin + decodeString, valueOf);
        if (callBack == null && this.batchEnableSwitch) {
            synchronized (this) {
                if (!this.requestUsers.contains(uin)) {
                    this.requestUsers.add(uin);
                    if (this.runnable == null) {
                        this.runnable = new Runnable() { // from class: com.tencent.mobileqq.vip.api.impl.r
                            @Override // java.lang.Runnable
                            public final void run() {
                                VipDataUtilsImpl.requestVipData$lambda$2$lambda$1(VipDataUtilsImpl.this);
                            }
                        };
                        ThreadManagerV2.executeDelay(this.runnable, 16, null, false, 1000L);
                    }
                }
                Unit unit = Unit.INSTANCE;
            }
            return;
        }
        long parseLong = Long.parseLong(uin);
        VasLogNtReporter.INSTANCE.getVipData().reportDebug("requestVipData " + parseLong);
        vipdata$GetUserDataReq vipdata_getuserdatareq = new vipdata$GetUserDataReq();
        vipdata_getuserdatareq.uin.add(Long.valueOf(parseLong));
        ((IPbProtocol) QRoute.api(IPbProtocol.class)).request("trpc.qqva.vipdata.Vipdata.SsoGetUserData", vipdata_getuserdatareq, vipdata$GetUserDataRsp.class, new BusinessObserver() { // from class: com.tencent.mobileqq.vip.api.impl.s
            @Override // com.tencent.mobileqq.app.BusinessObserver
            public final void onUpdate(int i3, boolean z16, Object obj) {
                VipDataUtilsImpl.requestVipData$lambda$5(Function0.this, this, decodeString, i3, z16, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void requestVipData$lambda$2$lambda$1(VipDataUtilsImpl this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.batchRequest();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void requestVipData$lambda$5(Function0 function0, VipDataUtilsImpl this$0, String key, int i3, boolean z16, Object obj) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(key, "$key");
        if (QLog.isColorLevel()) {
            VasLogNtReporter.INSTANCE.getVipData().reportLow("receive callback");
        }
        if (z16 && (obj instanceof vipdata$GetUserDataRsp)) {
            List<vipdata$UserInfo> list = ((vipdata$GetUserDataRsp) obj).info.get();
            Intrinsics.checkNotNullExpressionValue(list, "data.info.get()");
            for (vipdata$UserInfo it : list) {
                m mVar = this$0.impl;
                Intrinsics.checkNotNullExpressionValue(it, "it");
                ConcurrentHashMap<String, CopyOnWriteArrayList<WeakReference<com.tencent.mobileqq.vip.api.j>>> concurrentHashMap = this$0.changedCallbackCache;
                long j3 = it.uin.get();
                StringBuilder sb5 = new StringBuilder();
                sb5.append(j3);
                mVar.f(it, key, concurrentHashMap.get(sb5.toString()));
            }
            if (function0 != null) {
                function0.invoke();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void updateFlagData$lambda$0(String str, String curDataFlag, int i3, VipDataUtilsImpl this$0) {
        Intrinsics.checkNotNullParameter(curDataFlag, "$curDataFlag");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        VasNtMMKV.INSTANCE.getVipDataRandomKey().encodeString(str, curDataFlag);
        VipNtMMKV.INSTANCE.getVipDataNeedRequest().encodeBool(str, true);
        if (QLog.isColorLevel()) {
            VasLogNtReporter.INSTANCE.getVipData().reportLow("uin[" + str + "]vipdataFlag[" + i3 + "] request update");
        }
        this$0.requestVipData(str, null);
    }

    @Override // com.tencent.mobileqq.vip.api.IVipDataUtils
    @NotNull
    public String getSplendidTitle() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.splendidTitle;
    }

    @Override // com.tencent.mobileqq.vip.api.IVipDataUtils
    @NotNull
    public VipData getVipData(@Nullable String uin, int vipdataFlag) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) ? getVipData(uin) : (VipData) iPatchRedirector.redirect((short) 4, (Object) this, (Object) uin, vipdataFlag);
    }

    @Override // com.tencent.mobileqq.vip.api.IVipDataUtils
    @NotNull
    public VipData getVipDataForFriends(@Nullable String uin) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (VipData) iPatchRedirector.redirect((short) 3, (Object) this, (Object) uin);
        }
        return getVipData(uin);
    }

    @Override // com.tencent.mobileqq.vip.api.IVipDataUtils
    public void registerVipDataChangedCallback(@NotNull String uin, @NotNull com.tencent.mobileqq.vip.api.j callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) uin, (Object) callback);
            return;
        }
        Intrinsics.checkNotNullParameter(uin, "uin");
        Intrinsics.checkNotNullParameter(callback, "callback");
        CopyOnWriteArrayList<WeakReference<com.tencent.mobileqq.vip.api.j>> copyOnWriteArrayList = this.changedCallbackCache.get(uin);
        if (copyOnWriteArrayList == null) {
            copyOnWriteArrayList = new CopyOnWriteArrayList<>();
        }
        Iterator<WeakReference<com.tencent.mobileqq.vip.api.j>> it = copyOnWriteArrayList.iterator();
        Intrinsics.checkNotNullExpressionValue(it, "changedCallbackList.iterator()");
        while (it.hasNext()) {
            if (Intrinsics.areEqual(it.next().get(), callback)) {
                return;
            }
        }
        copyOnWriteArrayList.add(new WeakReference<>(callback));
        this.changedCallbackCache.put(uin, copyOnWriteArrayList);
    }

    @Override // com.tencent.mobileqq.vip.api.IVipDataUtils
    public void requestAndUpdateData(@NotNull String uin, @Nullable Function0<Unit> callBack) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) uin, (Object) callBack);
        } else {
            Intrinsics.checkNotNullParameter(uin, "uin");
            requestVipData(uin, callBack);
        }
    }

    @Override // com.tencent.mobileqq.vip.api.IVipDataUtils
    public void unRegisterVipDataChangedCallback(@NotNull String uin, @Nullable com.tencent.mobileqq.vip.api.j callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) uin, (Object) callback);
            return;
        }
        Intrinsics.checkNotNullParameter(uin, "uin");
        CopyOnWriteArrayList<WeakReference<com.tencent.mobileqq.vip.api.j>> copyOnWriteArrayList = this.changedCallbackCache.get(uin);
        if (copyOnWriteArrayList == null || copyOnWriteArrayList.isEmpty()) {
            return;
        }
        Iterator<WeakReference<com.tencent.mobileqq.vip.api.j>> it = copyOnWriteArrayList.iterator();
        Intrinsics.checkNotNullExpressionValue(it, "changedCallbackList.iterator()");
        while (it.hasNext()) {
            WeakReference<com.tencent.mobileqq.vip.api.j> next = it.next();
            if (Intrinsics.areEqual(next.get(), callback)) {
                copyOnWriteArrayList.remove(next);
                return;
            }
        }
    }

    @Override // com.tencent.mobileqq.vip.api.IVipDataUtils
    public void updateFlagData(@Nullable final String uin, final int vipDataFlag) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) uin, vipDataFlag);
            return;
        }
        if (uin != null && uin.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!z16 && vipDataFlag > 0) {
            String decodeString = VasNtMMKV.INSTANCE.getVipDataRandomKey().decodeString(uin, null);
            final String d16 = this.impl.d(uin, vipDataFlag);
            if (decodeString == null || !Intrinsics.areEqual(decodeString, d16)) {
                y13.d.b(new Runnable() { // from class: com.tencent.mobileqq.vip.api.impl.t
                    @Override // java.lang.Runnable
                    public final void run() {
                        VipDataUtilsImpl.updateFlagData$lambda$0(uin, d16, vipDataFlag, this);
                    }
                });
            }
        }
    }

    private final VipData getVipData(String uin) {
        if (uin == null || uin.length() == 0) {
            return new VipData(false, 0L, false, false, 0, null, 0, 0, 0, 0, 0, 0, null, 0, false, 0L, false, 0, false, 524287, null);
        }
        if (VipNtMMKV.INSTANCE.getVipDataNeedRequest().decodeBool(uin, false)) {
            if (QLog.isDebugVersion()) {
                VasLogNtReporter.INSTANCE.getVipData().reportLow("uin[" + uin + "]vipdataFlagChanged request update");
            }
            requestVipData(uin, null);
        }
        return this.impl.c(uin);
    }
}
