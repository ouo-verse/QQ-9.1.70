package com.tencent.mobileqq.vas.push.impl;

import android.text.TextUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.ar;
import com.tencent.mobileqq.vas.push.IVasSystemPushApi;
import com.tencent.mobileqq.vas.toggle.UnitedProxy;
import com.tencent.mobileqq.vas.updatesystem.business.QQVasUpdateBusiness;
import com.tencent.mobileqq.vas.updatesystem.callback.IDownLoadListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.msg.api.IMsgService;
import com.tencent.vas.update.entity.BusinessItemInfo;
import com.tencent.vas.update.entity.BusinessUpdateParams;
import com.tencent.vas.update.entity.UpdateListenerParams;
import java.util.concurrent.CancellationException;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.DelicateCoroutinesApi;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.FlowKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\r\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001eB\u0007\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\b\u001a\u00020\u0006H\u0017R\u0018\u0010\n\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR\u001b\u0010\u0011\u001a\u00020\f8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001b\u0010\u0014\u001a\u00020\u00128BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0013\u0010\u000e\u001a\u0004\b\u0014\u0010\u0015R\u001b\u0010\u0017\u001a\u00020\u00028BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0016\u0010\u000e\u001a\u0004\b\u0017\u0010\u0018R\u001b\u0010\u001a\u001a\u00020\u00028BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0019\u0010\u000e\u001a\u0004\b\u001a\u0010\u0018\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/mobileqq/vas/push/impl/VasSystemPushApiImpl;", "Lcom/tencent/mobileqq/vas/push/IVasSystemPushApi;", "", "bid", "", "scid", "", "handlePush0x16d", "register", "Lkotlinx/coroutines/Job;", "receiveSysMsgNotificationJob", "Lkotlinx/coroutines/Job;", "Lcom/tencent/mobileqq/vas/toggle/UnitedProxy;", "vasPushUpdateResConfig$delegate", "Lkotlin/Lazy;", "getVasPushUpdateResConfig", "()Lcom/tencent/mobileqq/vas/toggle/UnitedProxy;", "vasPushUpdateResConfig", "", "isEnable$delegate", "isEnable", "()Z", "isCanDelete$delegate", "isCanDelete", "()I", "isCanDownload$delegate", "isCanDownload", "<init>", "()V", "Companion", "a", "vas_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class VasSystemPushApiImpl implements IVasSystemPushApi {

    @NotNull
    private static final String TAG = "VasSystemPushApiImpl";

    /* renamed from: isCanDelete$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy isCanDelete;

    /* renamed from: isCanDownload$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy isCanDownload;

    /* renamed from: isEnable$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy isEnable;

    @Nullable
    private Job receiveSysMsgNotificationJob;

    /* renamed from: vasPushUpdateResConfig$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy vasPushUpdateResConfig;

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/mobileqq/vas/push/impl/VasSystemPushApiImpl$b", "Lcom/tencent/mobileqq/vas/updatesystem/callback/IDownLoadListener;", "Lcom/tencent/vas/update/entity/UpdateListenerParams;", "params", "", "onLoadSuccess", "onLoadFail", "vas_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes20.dex */
    public static final class b implements IDownLoadListener {
        b() {
        }

        @Override // com.tencent.mobileqq.vas.updatesystem.callback.IDownLoadListener
        public void onLoadFail(@NotNull UpdateListenerParams params) {
            Intrinsics.checkNotNullParameter(params, "params");
            QLog.i(VasSystemPushApiImpl.TAG, 1, "push onLoadFail scid:" + params.mBusinessUpdateParams.mScid + " ec:" + params.mErrorCode);
        }

        @Override // com.tencent.mobileqq.vas.updatesystem.callback.IDownLoadListener
        public void onLoadSuccess(@NotNull UpdateListenerParams params) {
            Intrinsics.checkNotNullParameter(params, "params");
            QLog.i(VasSystemPushApiImpl.TAG, 1, "push onLoadSuccess scid:" + params.mBusinessUpdateParams.mScid);
        }
    }

    public VasSystemPushApiImpl() {
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        Lazy lazy4;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<UnitedProxy>() { // from class: com.tencent.mobileqq.vas.push.impl.VasSystemPushApiImpl$vasPushUpdateResConfig$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final UnitedProxy invoke() {
                return ar.INSTANCE.b("shouyouye", "2024-03-21", "vas_push_update_res_config");
            }
        });
        this.vasPushUpdateResConfig = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<Boolean>() { // from class: com.tencent.mobileqq.vas.push.impl.VasSystemPushApiImpl$isEnable$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Boolean invoke() {
                UnitedProxy vasPushUpdateResConfig;
                vasPushUpdateResConfig = VasSystemPushApiImpl.this.getVasPushUpdateResConfig();
                return Boolean.valueOf(vasPushUpdateResConfig.isEnable(true));
            }
        });
        this.isEnable = lazy2;
        lazy3 = LazyKt__LazyJVMKt.lazy(new Function0<Integer>() { // from class: com.tencent.mobileqq.vas.push.impl.VasSystemPushApiImpl$isCanDelete$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Integer invoke() {
                UnitedProxy vasPushUpdateResConfig;
                vasPushUpdateResConfig = VasSystemPushApiImpl.this.getVasPushUpdateResConfig();
                return Integer.valueOf(vasPushUpdateResConfig.getJson().optInt("delete", 1));
            }
        });
        this.isCanDelete = lazy3;
        lazy4 = LazyKt__LazyJVMKt.lazy(new Function0<Integer>() { // from class: com.tencent.mobileqq.vas.push.impl.VasSystemPushApiImpl$isCanDownload$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Integer invoke() {
                UnitedProxy vasPushUpdateResConfig;
                vasPushUpdateResConfig = VasSystemPushApiImpl.this.getVasPushUpdateResConfig();
                return Integer.valueOf(vasPushUpdateResConfig.getJson().optInt("download", 0));
            }
        });
        this.isCanDownload = lazy4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final UnitedProxy getVasPushUpdateResConfig() {
        return (UnitedProxy) this.vasPushUpdateResConfig.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void handlePush0x16d(int bid, String scid) {
        if (!isEnable()) {
            return;
        }
        QLog.i(TAG, 1, "handlePush0x16d bid:" + bid + " scid:" + scid);
        long j3 = (long) bid;
        QQVasUpdateBusiness business = QQVasUpdateBusiness.getBusiness(j3);
        if (business == null) {
            QLog.i(TAG, 1, "getBusiness is null bid: " + bid + " ");
            return;
        }
        BusinessItemInfo businessItemInfo = business.getBusinessItemInfo(j3, scid);
        if (businessItemInfo == null) {
            QLog.i(TAG, 1, "itemInfo is null bid: " + bid + " scid: " + scid);
            return;
        }
        if (TextUtils.isEmpty(businessItemInfo.mSavePath)) {
            QLog.i(TAG, 1, "itemInfo.mSavePath is empty bid: " + bid + " scid: " + scid);
            return;
        }
        BusinessUpdateParams businessUpdateParams = new BusinessUpdateParams(j3, scid, "push");
        if (!business.getReadHistory().contains(scid) && isCanDelete() == 1) {
            QLog.i(TAG, 1, "business.readHistory is no contains");
            business.deleteFile(businessUpdateParams, businessItemInfo);
        }
        if (isCanDownload() == 1) {
            business.addDownLoadListener(scid, new b());
            business.startDownload(scid);
        }
    }

    private final int isCanDelete() {
        return ((Number) this.isCanDelete.getValue()).intValue();
    }

    private final int isCanDownload() {
        return ((Number) this.isCanDownload.getValue()).intValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean isEnable() {
        return ((Boolean) this.isEnable.getValue()).booleanValue();
    }

    @Override // com.tencent.mobileqq.vas.push.IVasSystemPushApi
    @DelicateCoroutinesApi
    public void register() {
        try {
            Job job = this.receiveSysMsgNotificationJob;
            if (job != null) {
                QLog.i(TAG, 1, "receiveSysMsgNotificationJob need cancel first");
                Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
            }
            QLog.i(TAG, 1, "register, receiveSysMsgNotificationFlow");
            this.receiveSysMsgNotificationJob = FlowKt.launchIn(FlowKt.onEach(((IMsgService) QRoute.api(IMsgService.class)).receiveSysMsgNotificationFlow(), new VasSystemPushApiImpl$register$2(this, null)), GlobalScope.INSTANCE);
        } catch (Error e16) {
            QLog.e(TAG, 1, "register exception", e16);
        }
    }
}
