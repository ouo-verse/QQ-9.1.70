package com.tencent.mobileqq.zootopia.download.mod.hotpatch.ipc;

import android.os.Looper;
import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.zplan.resource.api.data.mod.ZPlanResHubResultInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.zootopia.utils.CommonExKt;
import com.tencent.zplan.resource.api.ZPlanSceneResourceErrType;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import k74.i;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import tl.h;

@Metadata(d1 = {"\u0000E\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0007*\u0001\u001c\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b \u0010!J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\u0016\u0010\n\u001a\u00020\u00062\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\bH\u0002J\u0010\u0010\f\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u0002H\u0002J\u0010\u0010\r\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u0002H\u0002J6\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u0011\u001a\u00020\u00102\b\b\u0002\u0010\u0012\u001a\u00020\u0010J\u0006\u0010\u0014\u001a\u00020\u0004RX\u0010\u001b\u001aF\u0012\u0004\u0012\u00020\u0002\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0016j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u00170\u0015j\"\u0012\u0004\u0012\u00020\u0002\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0016j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u0017`\u00188\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001f\u001a\u00020\u001c8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001e\u00a8\u0006\""}, d2 = {"Lcom/tencent/mobileqq/zootopia/download/mod/hotpatch/ipc/ZPlanModHotPatchForModProcess;", "", "", "modId", "Lcom/tencent/mobileqq/zootopia/download/mod/hotpatch/a;", "listener", "", "e", "Lkotlin/Function0;", "runner", "j", "logMsg", "i", h.F, "downloadSrc", "resourceCallback", "", "fromEnterMod", "needMobileDownloadTips", "f", "g", "Ljava/util/HashMap;", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "Lkotlin/collections/HashMap;", "b", "Ljava/util/HashMap;", "downloadListenerMap", "com/tencent/mobileqq/zootopia/download/mod/hotpatch/ipc/ZPlanModHotPatchForModProcess$callbackProxy$1", "c", "Lcom/tencent/mobileqq/zootopia/download/mod/hotpatch/ipc/ZPlanModHotPatchForModProcess$callbackProxy$1;", "callbackProxy", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class ZPlanModHotPatchForModProcess {

    /* renamed from: a, reason: collision with root package name */
    public static final ZPlanModHotPatchForModProcess f328100a = new ZPlanModHotPatchForModProcess();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final HashMap<String, ArrayList<com.tencent.mobileqq.zootopia.download.mod.hotpatch.a>> downloadListenerMap = new HashMap<>();

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static final ZPlanModHotPatchForModProcess$callbackProxy$1 callbackProxy = new com.tencent.mobileqq.zootopia.download.mod.hotpatch.a() { // from class: com.tencent.mobileqq.zootopia.download.mod.hotpatch.ipc.ZPlanModHotPatchForModProcess$callbackProxy$1
        private final void a(final String modId, final boolean needRemove, final Function1<? super com.tencent.mobileqq.zootopia.download.mod.hotpatch.a, Unit> action) {
            CommonExKt.j(new Function0<Unit>() { // from class: com.tencent.mobileqq.zootopia.download.mod.hotpatch.ipc.ZPlanModHotPatchForModProcess$callbackProxy$1$notifyAllListeners$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
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
                    HashMap hashMap;
                    HashMap hashMap2;
                    ArrayList arrayList = new ArrayList();
                    hashMap = ZPlanModHotPatchForModProcess.downloadListenerMap;
                    ArrayList arrayList2 = (ArrayList) hashMap.get(modId);
                    if (arrayList2 != null) {
                        Iterator it = arrayList2.iterator();
                        while (it.hasNext()) {
                            arrayList.add((com.tencent.mobileqq.zootopia.download.mod.hotpatch.a) it.next());
                        }
                    }
                    if (needRemove) {
                        ZPlanModHotPatchForModProcess.f328100a.i("proxy# " + modId + " removeListener");
                        hashMap2 = ZPlanModHotPatchForModProcess.downloadListenerMap;
                        hashMap2.remove(modId);
                    }
                    Function1<com.tencent.mobileqq.zootopia.download.mod.hotpatch.a, Unit> function1 = action;
                    Iterator it5 = arrayList.iterator();
                    while (it5.hasNext()) {
                        function1.invoke((com.tencent.mobileqq.zootopia.download.mod.hotpatch.a) it5.next());
                    }
                }
            });
        }

        @Override // com.tencent.mobileqq.zootopia.download.mod.hotpatch.a
        public void checkWhenMobileDownload(final String modId, final long needDownloadSize, final vj3.c resultCallback) {
            Intrinsics.checkNotNullParameter(modId, "modId");
            Intrinsics.checkNotNullParameter(resultCallback, "resultCallback");
            b(this, modId, false, new Function1<com.tencent.mobileqq.zootopia.download.mod.hotpatch.a, Unit>() { // from class: com.tencent.mobileqq.zootopia.download.mod.hotpatch.ipc.ZPlanModHotPatchForModProcess$callbackProxy$1$checkWhenMobileDownload$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(com.tencent.mobileqq.zootopia.download.mod.hotpatch.a aVar) {
                    invoke2(aVar);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(com.tencent.mobileqq.zootopia.download.mod.hotpatch.a it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    it.checkWhenMobileDownload(modId, needDownloadSize, resultCallback);
                }
            }, 2, null);
        }

        @Override // com.tencent.mobileqq.zootopia.download.mod.hotpatch.a
        public void onCheckResult(final String modId, final long checkCostTime, final boolean needDownloadHotPatch) {
            Intrinsics.checkNotNullParameter(modId, "modId");
            ZPlanModHotPatchForModProcess.f328100a.i("callbackProxy#onCheckResult - checkCostTime= " + checkCostTime + ", needDownloadHotPatch= " + needDownloadHotPatch);
            b(this, modId, false, new Function1<com.tencent.mobileqq.zootopia.download.mod.hotpatch.a, Unit>() { // from class: com.tencent.mobileqq.zootopia.download.mod.hotpatch.ipc.ZPlanModHotPatchForModProcess$callbackProxy$1$onCheckResult$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(com.tencent.mobileqq.zootopia.download.mod.hotpatch.a aVar) {
                    invoke2(aVar);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(com.tencent.mobileqq.zootopia.download.mod.hotpatch.a it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    it.onCheckResult(modId, checkCostTime, needDownloadHotPatch);
                }
            }, 2, null);
        }

        @Override // com.tencent.mobileqq.zootopia.download.mod.hotpatch.a
        public void onDownloadError(final String modId, final ZPlanSceneResourceErrType errType, final int errorCode, final String errorMessage, final int totalTaskCount, final int failedTaskCount) {
            Intrinsics.checkNotNullParameter(modId, "modId");
            Intrinsics.checkNotNullParameter(errType, "errType");
            ZPlanModHotPatchForModProcess.f328100a.h("callbackProxy#onDownloadError - modId= " + modId + ", errType= " + errType + ", errorCode= " + errorCode + ", " + errorMessage);
            a(modId, true, new Function1<com.tencent.mobileqq.zootopia.download.mod.hotpatch.a, Unit>() { // from class: com.tencent.mobileqq.zootopia.download.mod.hotpatch.ipc.ZPlanModHotPatchForModProcess$callbackProxy$1$onDownloadError$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(com.tencent.mobileqq.zootopia.download.mod.hotpatch.a aVar) {
                    invoke2(aVar);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(com.tencent.mobileqq.zootopia.download.mod.hotpatch.a it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    it.onDownloadError(modId, errType, errorCode, errorMessage, totalTaskCount, failedTaskCount);
                }
            });
        }

        @Override // com.tencent.mobileqq.zootopia.download.mod.hotpatch.a
        public void onDownloadProgress(final String modId, final float progress, final int totalTaskCount, final int completedTaskCount) {
            Intrinsics.checkNotNullParameter(modId, "modId");
            ZPlanModHotPatchForModProcess.f328100a.i("callbackProxy#onDownloadProgress - modId= " + modId + ", progress= " + progress);
            b(this, modId, false, new Function1<com.tencent.mobileqq.zootopia.download.mod.hotpatch.a, Unit>() { // from class: com.tencent.mobileqq.zootopia.download.mod.hotpatch.ipc.ZPlanModHotPatchForModProcess$callbackProxy$1$onDownloadProgress$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(com.tencent.mobileqq.zootopia.download.mod.hotpatch.a aVar) {
                    invoke2(aVar);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(com.tencent.mobileqq.zootopia.download.mod.hotpatch.a it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    it.onDownloadProgress(modId, progress, totalTaskCount, completedTaskCount);
                }
            }, 2, null);
        }

        @Override // com.tencent.mobileqq.zootopia.download.mod.hotpatch.a
        public void onDownloadSuccess(final String modId, final ZPlanResHubResultInfo hotPatchInfo, final boolean hasRealChecked, final boolean hasRealDownloaded) {
            Intrinsics.checkNotNullParameter(modId, "modId");
            ZPlanModHotPatchForModProcess.f328100a.i("callbackProxy#onDownloadSuccess - modId= " + modId + ", hotPatchInfo= " + hotPatchInfo + ", hasRealChecked= " + hasRealChecked + ", hasRealDownloaded= " + hasRealDownloaded);
            a(modId, true, new Function1<com.tencent.mobileqq.zootopia.download.mod.hotpatch.a, Unit>() { // from class: com.tencent.mobileqq.zootopia.download.mod.hotpatch.ipc.ZPlanModHotPatchForModProcess$callbackProxy$1$onDownloadSuccess$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(com.tencent.mobileqq.zootopia.download.mod.hotpatch.a aVar) {
                    invoke2(aVar);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(com.tencent.mobileqq.zootopia.download.mod.hotpatch.a it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    it.onDownloadSuccess(modId, hotPatchInfo, hasRealChecked, hasRealDownloaded);
                }
            });
        }

        @Override // com.tencent.mobileqq.zootopia.download.mod.hotpatch.a
        public void onRealCheckStart(final String modId) {
            Intrinsics.checkNotNullParameter(modId, "modId");
            ZPlanModHotPatchForModProcess.f328100a.i("callbackProxy#onRealCheckStarts");
            b(this, modId, false, new Function1<com.tencent.mobileqq.zootopia.download.mod.hotpatch.a, Unit>() { // from class: com.tencent.mobileqq.zootopia.download.mod.hotpatch.ipc.ZPlanModHotPatchForModProcess$callbackProxy$1$onRealCheckStart$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(com.tencent.mobileqq.zootopia.download.mod.hotpatch.a aVar) {
                    invoke2(aVar);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(com.tencent.mobileqq.zootopia.download.mod.hotpatch.a it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    it.onRealCheckStart(modId);
                }
            }, 2, null);
        }

        static /* synthetic */ void b(ZPlanModHotPatchForModProcess$callbackProxy$1 zPlanModHotPatchForModProcess$callbackProxy$1, String str, boolean z16, Function1 function1, int i3, Object obj) {
            if ((i3 & 2) != 0) {
                z16 = false;
            }
            zPlanModHotPatchForModProcess$callbackProxy$1.a(str, z16, function1);
        }
    };

    ZPlanModHotPatchForModProcess() {
    }

    private final void e(String modId, com.tencent.mobileqq.zootopia.download.mod.hotpatch.a listener) {
        if (TextUtils.isEmpty(modId) || listener == null) {
            return;
        }
        HashMap<String, ArrayList<com.tencent.mobileqq.zootopia.download.mod.hotpatch.a>> hashMap = downloadListenerMap;
        ArrayList<com.tencent.mobileqq.zootopia.download.mod.hotpatch.a> arrayList = hashMap.get(modId);
        if (arrayList == null) {
            arrayList = new ArrayList<>();
            hashMap.put(modId, arrayList);
        }
        if (arrayList.contains(listener)) {
            return;
        }
        arrayList.add(listener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void h(String logMsg) {
        QLog.e("ZPlanModHotPatchForModProcess", 1, logMsg);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void i(String logMsg) {
        QLog.i("ZPlanModHotPatchForModProcess", 1, logMsg);
    }

    private final void j(final Function0<Unit> runner) {
        if (Intrinsics.areEqual(Looper.getMainLooper(), Looper.myLooper())) {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.zootopia.download.mod.hotpatch.ipc.d
                @Override // java.lang.Runnable
                public final void run() {
                    ZPlanModHotPatchForModProcess.k(Function0.this);
                }
            }, 16, null, false);
        } else {
            runner.invoke();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k(Function0 runner) {
        Intrinsics.checkNotNullParameter(runner, "$runner");
        runner.invoke();
    }

    public final void f(final String downloadSrc, final String modId, com.tencent.mobileqq.zootopia.download.mod.hotpatch.a resourceCallback, final boolean fromEnterMod, final boolean needMobileDownloadTips) {
        Intrinsics.checkNotNullParameter(downloadSrc, "downloadSrc");
        Intrinsics.checkNotNullParameter(modId, "modId");
        i(downloadSrc + " downloadModHotPatchResource-" + modId + " withId");
        e(modId, resourceCallback);
        j(new Function0<Unit>() { // from class: com.tencent.mobileqq.zootopia.download.mod.hotpatch.ipc.ZPlanModHotPatchForModProcess$downloadModHotPatchResource$1
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
                ((b) i.INSTANCE.a(b.class)).downloadModHotPatchResource(downloadSrc, modId, fromEnterMod, needMobileDownloadTips);
            }
        });
    }

    public final com.tencent.mobileqq.zootopia.download.mod.hotpatch.a g() {
        return callbackProxy;
    }
}
