package com.tencent.mobileqq.vas.kernel;

import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.mobileqq.vas.VasLogNtReporter;
import com.tencent.mobileqq.vas.VasNtCommonReporter;
import com.tencent.mobileqq.vas.updatesystem.api.IVasBusinessManager;
import com.tencent.mobileqq.vas.updatesystem.business.QQVasUpdateBusiness;
import com.tencent.mobileqq.vas.updatesystem.callback.IDownLoadListener;
import com.tencent.mobileqq.vip.api.IVipDataUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.frequencycontrol.pb.FrequencyControlField$ResourceBody;
import com.tencent.qqnt.kernel.frequencycontrol.pb.FrequencyControlField$ResourceItem;
import com.tencent.qqnt.kernel.frequencycontrol.pb.FrequencyControlField$UpdatePersonalVasInfoBody;
import com.tencent.qqnt.kernel.nativeinterface.IQQNTWrapperSession;
import com.tencent.qqnt.msg.f;
import com.tencent.vas.update.entity.UpdateListenerParams;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import tl.h;
import y13.d;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0015\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u001a\u0010\u001bJ \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J8\u0010\u000f\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\rH\u0002J8\u0010\u0011\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\rH\u0002J\u0018\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u0012H\u0002J\u0018\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J \u0010\u0017\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\u0019\u001a\u00020\u0018H\u0016\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/mobileqq/vas/kernel/VasDispatcherAdapterProcess;", "Lcom/tencent/qqnt/kernel/frequencycontrol/b;", "", "itemId", "", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_REQUEST_ID, "", "pbBuffer", "", "i", "bid", "", "id", "Lkotlin/Function0;", "onReply", "g", "scId", h.F, "", "isSuccess", "f", "cmd", "b", "c", "", "a", "<init>", "()V", "vas_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class VasDispatcherAdapterProcess implements com.tencent.qqnt.kernel.frequencycontrol.b {

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/mobileqq/vas/kernel/VasDispatcherAdapterProcess$a", "Lcom/tencent/mobileqq/vas/updatesystem/callback/IDownLoadListener;", "Lcom/tencent/vas/update/entity/UpdateListenerParams;", "params", "", "onLoadSuccess", "onLoadFail", "vas_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes20.dex */
    public static final class a implements IDownLoadListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ QQVasUpdateBusiness<?> f309621a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f309622b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ long f309623c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ VasDispatcherAdapterProcess f309624d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ byte[] f309625e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ Function0<Unit> f309626f;

        a(QQVasUpdateBusiness<?> qQVasUpdateBusiness, int i3, long j3, VasDispatcherAdapterProcess vasDispatcherAdapterProcess, byte[] bArr, Function0<Unit> function0) {
            this.f309621a = qQVasUpdateBusiness;
            this.f309622b = i3;
            this.f309623c = j3;
            this.f309624d = vasDispatcherAdapterProcess;
            this.f309625e = bArr;
            this.f309626f = function0;
        }

        @Override // com.tencent.mobileqq.vas.updatesystem.callback.IDownLoadListener
        public void onLoadFail(@NotNull UpdateListenerParams params) {
            Intrinsics.checkNotNullParameter(params, "params");
            VasLogNtReporter.INSTANCE.getFrequency().reportLow("[download-reply] onLoadFail " + this.f309622b);
            IQQNTWrapperSession k3 = f.k();
            if (k3 != null) {
                k3.onDispatchRequestReply(this.f309623c, 221003, this.f309624d.f(this.f309625e, false));
            }
            Function0<Unit> function0 = this.f309626f;
            if (function0 != null) {
                function0.invoke();
            }
        }

        @Override // com.tencent.mobileqq.vas.updatesystem.callback.IDownLoadListener
        public void onLoadSuccess(@NotNull UpdateListenerParams params) {
            Intrinsics.checkNotNullParameter(params, "params");
            if (this.f309621a.isFileExists(this.f309622b)) {
                if (QLog.isColorLevel()) {
                    VasLogNtReporter.INSTANCE.getFrequency().reportLow("[download-reply] onLoadSuccess " + this.f309622b);
                }
                IQQNTWrapperSession k3 = f.k();
                if (k3 != null) {
                    k3.onDispatchRequestReply(this.f309623c, 221003, this.f309624d.f(this.f309625e, true));
                }
                Function0<Unit> function0 = this.f309626f;
                if (function0 != null) {
                    function0.invoke();
                    return;
                }
                return;
            }
            VasLogNtReporter.INSTANCE.getFrequency().reportLow("[download-reply] onLoadSuccess " + this.f309622b + " not exists");
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/mobileqq/vas/kernel/VasDispatcherAdapterProcess$b", "Lcom/tencent/mobileqq/vas/updatesystem/callback/IDownLoadListener;", "Lcom/tencent/vas/update/entity/UpdateListenerParams;", "params", "", "onLoadSuccess", "onLoadFail", "vas_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes20.dex */
    public static final class b implements IDownLoadListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ QQVasUpdateBusiness<?> f309627a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f309628b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ long f309629c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ VasDispatcherAdapterProcess f309630d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ byte[] f309631e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ Function0<Unit> f309632f;

        b(QQVasUpdateBusiness<?> qQVasUpdateBusiness, String str, long j3, VasDispatcherAdapterProcess vasDispatcherAdapterProcess, byte[] bArr, Function0<Unit> function0) {
            this.f309627a = qQVasUpdateBusiness;
            this.f309628b = str;
            this.f309629c = j3;
            this.f309630d = vasDispatcherAdapterProcess;
            this.f309631e = bArr;
            this.f309632f = function0;
        }

        @Override // com.tencent.mobileqq.vas.updatesystem.callback.IDownLoadListener
        public void onLoadFail(@NotNull UpdateListenerParams params) {
            Intrinsics.checkNotNullParameter(params, "params");
            VasLogNtReporter.INSTANCE.getFrequency().reportLow("[download-reply] onLoadFail " + this.f309628b);
            IQQNTWrapperSession k3 = f.k();
            if (k3 != null) {
                k3.onDispatchRequestReply(this.f309629c, 221003, this.f309630d.f(this.f309631e, false));
            }
            Function0<Unit> function0 = this.f309632f;
            if (function0 != null) {
                function0.invoke();
            }
        }

        @Override // com.tencent.mobileqq.vas.updatesystem.callback.IDownLoadListener
        public void onLoadSuccess(@NotNull UpdateListenerParams params) {
            Intrinsics.checkNotNullParameter(params, "params");
            if (this.f309627a.isFileExist(this.f309628b)) {
                if (QLog.isColorLevel()) {
                    VasLogNtReporter.INSTANCE.getFrequency().reportLow("[download-reply] onLoadSuccess " + this.f309628b);
                }
                IQQNTWrapperSession k3 = f.k();
                if (k3 != null) {
                    k3.onDispatchRequestReply(this.f309629c, 221003, this.f309630d.f(this.f309631e, true));
                }
                Function0<Unit> function0 = this.f309632f;
                if (function0 != null) {
                    function0.invoke();
                    return;
                }
                return;
            }
            VasLogNtReporter.INSTANCE.getFrequency().reportLow("[download-reply] onLoadSuccess " + this.f309628b + " not exists");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final byte[] f(byte[] pbBuffer, boolean isSuccess) {
        int i3;
        FrequencyControlField$ResourceItem frequencyControlField$ResourceItem = new FrequencyControlField$ResourceItem();
        try {
            frequencyControlField$ResourceItem.mergeFrom(pbBuffer);
            FrequencyControlField$ResourceItem frequencyControlField$ResourceItem2 = new FrequencyControlField$ResourceItem();
            frequencyControlField$ResourceItem2.peer_uid.set(frequencyControlField$ResourceItem.peer_uid.get());
            frequencyControlField$ResourceItem2.chat_type.set(frequencyControlField$ResourceItem.chat_type.get());
            frequencyControlField$ResourceItem2.scene_id.set(frequencyControlField$ResourceItem.scene_id.get());
            frequencyControlField$ResourceItem2.update_type.set(frequencyControlField$ResourceItem.update_type.get());
            frequencyControlField$ResourceItem2.resource_body_list.set(frequencyControlField$ResourceItem.resource_body_list.get());
            frequencyControlField$ResourceItem2.need_download.set(frequencyControlField$ResourceItem.need_download.get());
            PBUInt32Field pBUInt32Field = frequencyControlField$ResourceItem2.err_code;
            if (isSuccess) {
                i3 = 0;
            } else {
                i3 = -1;
            }
            pBUInt32Field.set(i3);
            byte[] byteArray = frequencyControlField$ResourceItem2.toByteArray();
            Intrinsics.checkNotNullExpressionValue(byteArray, "ResourceItem().apply {\n \u2026          }.toByteArray()");
            return byteArray;
        } catch (Exception unused) {
            VasLogNtReporter.INSTANCE.getFrequency().reportLow("onDispatchRequest error cmd: 221003");
            return pbBuffer;
        }
    }

    private final void g(long bid, int id5, long requestId, byte[] pbBuffer, Function0<Unit> onReply) {
        QQVasUpdateBusiness businessInstance = ((IVasBusinessManager) QRoute.api(IVasBusinessManager.class)).getBusinessInstance(Long.valueOf(bid));
        Intrinsics.checkNotNullExpressionValue(businessInstance, "api(IVasBusinessManager:\u2026.getBusinessInstance(bid)");
        if (businessInstance.isFileExists(id5)) {
            if (QLog.isColorLevel()) {
                VasLogNtReporter.INSTANCE.getFrequency().reportLow("[download-reply] " + id5 + " already exists");
            }
            IQQNTWrapperSession k3 = f.k();
            if (k3 != null) {
                k3.onDispatchRequestReply(requestId, 221003, f(pbBuffer, true));
            }
            if (onReply != null) {
                onReply.invoke();
                return;
            }
            return;
        }
        businessInstance.addDownLoadListener(id5, new a(businessInstance, id5, requestId, this, pbBuffer, onReply));
        businessInstance.startDownload(id5);
    }

    private final void h(long bid, String scId, long requestId, byte[] pbBuffer, Function0<Unit> onReply) {
        QQVasUpdateBusiness businessInstance = ((IVasBusinessManager) QRoute.api(IVasBusinessManager.class)).getBusinessInstance(Long.valueOf(bid));
        Intrinsics.checkNotNullExpressionValue(businessInstance, "api(IVasBusinessManager:\u2026.getBusinessInstance(bid)");
        if (businessInstance.isFileExist(scId)) {
            if (QLog.isColorLevel()) {
                VasLogNtReporter.INSTANCE.getFrequency().reportLow("[download-reply] " + scId + " already exists");
            }
            IQQNTWrapperSession k3 = f.k();
            if (k3 != null) {
                k3.onDispatchRequestReply(requestId, 221003, f(pbBuffer, true));
            }
            if (onReply != null) {
                onReply.invoke();
                return;
            }
            return;
        }
        businessInstance.addDownLoadListener(scId, new b(businessInstance, scId, requestId, this, pbBuffer, onReply));
        businessInstance.startDownload(scId);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v6, types: [T, java.lang.Integer] */
    /* JADX WARN: Type inference failed for: r6v1, types: [T, java.lang.String] */
    private final void i(final String itemId, long requestId, byte[] pbBuffer) {
        List split$default;
        Function0<Unit> function0;
        split$default = StringsKt__StringsKt.split$default((CharSequence) itemId, new String[]{"!"}, false, 0, 6, (Object) null);
        Object[] array = split$default.toArray(new String[0]);
        Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        String[] strArr = (String[]) array;
        if (strArr.length == 2) {
            final long parseLong = Long.parseLong(strArr[0]);
            final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
            if (QLog.isColorLevel()) {
                function0 = new Function0<Unit>() { // from class: com.tencent.mobileqq.vas.kernel.VasDispatcherAdapterProcess$handlerCmdResponse$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        atomicBoolean.set(true);
                    }
                };
            } else {
                function0 = null;
            }
            final Ref.ObjectRef objectRef = new Ref.ObjectRef();
            try {
                ?? valueOf = Integer.valueOf(Integer.parseInt(strArr[1]));
                objectRef.element = valueOf;
                g(parseLong, ((Number) valueOf).intValue(), requestId, pbBuffer, function0);
            } catch (Exception unused) {
                ?? r65 = strArr[1];
                objectRef.element = r65;
                h(parseLong, r65, requestId, pbBuffer, function0);
            }
            if (function0 != null && VasNtCommonReporter.isHit()) {
                d.a(50000L, new Runnable() { // from class: com.tencent.mobileqq.vas.kernel.a
                    @Override // java.lang.Runnable
                    public final void run() {
                        VasDispatcherAdapterProcess.j(atomicBoolean, parseLong, objectRef, itemId);
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j(AtomicBoolean replySucess, long j3, Ref.ObjectRef id5, String itemId) {
        Intrinsics.checkNotNullParameter(replySucess, "$replySucess");
        Intrinsics.checkNotNullParameter(id5, "$id");
        Intrinsics.checkNotNullParameter(itemId, "$itemId");
        if (!replySucess.get()) {
            VasNtCommonReporter.getFrequency().setValue1(String.valueOf(j3)).setValue2(id5.element.toString()).reportEveryDay(itemId);
        }
    }

    @Override // com.tencent.qqnt.kernel.frequencycontrol.b
    @NotNull
    public int[] a() {
        return new int[]{221003, 221002};
    }

    @Override // com.tencent.qqnt.kernel.frequencycontrol.b
    public void b(int cmd, @NotNull byte[] pbBuffer) {
        Intrinsics.checkNotNullParameter(pbBuffer, "pbBuffer");
        if (cmd == 221002) {
            FrequencyControlField$UpdatePersonalVasInfoBody frequencyControlField$UpdatePersonalVasInfoBody = new FrequencyControlField$UpdatePersonalVasInfoBody();
            try {
                frequencyControlField$UpdatePersonalVasInfoBody.mergeFrom(pbBuffer);
                String valueOf = String.valueOf(frequencyControlField$UpdatePersonalVasInfoBody.uin.get());
                int i3 = frequencyControlField$UpdatePersonalVasInfoBody.qq_va_data_change_rand.get();
                if (QLog.isColorLevel()) {
                    VasLogNtReporter.INSTANCE.getFrequency().reportLow("[vipdate] received uin=" + valueOf + " flag=" + i3);
                }
                ((IVipDataUtils) QRoute.api(IVipDataUtils.class)).updateFlagData(valueOf, i3);
            } catch (Exception unused) {
                VasLogNtReporter.INSTANCE.getFrequency().reportLow("error cmd: 221002");
            }
        }
    }

    @Override // com.tencent.qqnt.kernel.frequencycontrol.b
    public void c(long requestId, int cmd, @NotNull byte[] pbBuffer) {
        Intrinsics.checkNotNullParameter(pbBuffer, "pbBuffer");
        if (cmd == 221003) {
            if (QLog.isColorLevel()) {
                VasLogNtReporter.INSTANCE.getFrequency().reportLow("[download] received");
            }
            FrequencyControlField$ResourceItem frequencyControlField$ResourceItem = new FrequencyControlField$ResourceItem();
            try {
                frequencyControlField$ResourceItem.mergeFrom(pbBuffer);
                List<FrequencyControlField$ResourceBody> list = frequencyControlField$ResourceItem.resource_body_list.get();
                if (list != null) {
                    for (FrequencyControlField$ResourceBody frequencyControlField$ResourceBody : list) {
                        if (frequencyControlField$ResourceBody.item_id.has()) {
                            if (QLog.isColorLevel()) {
                                VasLogNtReporter.INSTANCE.getFrequency().reportLow("[download] request update-system download ,itemid: " + frequencyControlField$ResourceBody.item_id.get() + " , businessid: " + frequencyControlField$ResourceBody.business_id.get() + ", cmd:221003");
                            }
                            String str = frequencyControlField$ResourceBody.item_id.get();
                            Intrinsics.checkNotNullExpressionValue(str, "it.item_id.get()");
                            i(str, requestId, pbBuffer);
                        }
                    }
                }
            } catch (Exception unused) {
                VasLogNtReporter.INSTANCE.getFrequency().reportLow("[download] onDispatchRequest error cmd: 221003");
            }
        }
    }
}
