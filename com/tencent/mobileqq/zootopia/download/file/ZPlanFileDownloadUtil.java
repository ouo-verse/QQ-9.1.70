package com.tencent.mobileqq.zootopia.download.file;

import android.text.TextUtils;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.z1.download.FileDownloadParams;
import com.tencent.mobileqq.z1.download.ZPlanFileCategory;
import com.tencent.mobileqq.zootopia.download.ah;
import com.tencent.mobileqq.zootopia.download.normal.FileDownloadManager;
import com.tencent.mobileqq.zootopia.download.normal.f;
import com.tencent.mobileqq.zootopia.download.x;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import tl.h;

@Metadata(d1 = {"\u0000_\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0006*\u0001*\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b-\u0010.J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\u001a\u0010\u000b\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\n\u001a\u00020\tH\u0002J\u001a\u0010\f\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\n\u001a\u00020\tH\u0002J\u001a\u0010\r\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\n\u001a\u00020\tH\u0002J\u0010\u0010\u000e\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0002J]\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00022\u0016\b\u0002\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00112\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0014\u00a2\u0006\u0004\b\u0015\u0010\u0016J2\u0010\u0019\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0014Jq\u0010\u001c\u001a\u00020\t2\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00022\u0016\b\u0002\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00112\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u00a2\u0006\u0004\b\u001c\u0010\u001dJ(\u0010 \u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0003\u001a\u00020\u00022\u0010\b\u0002\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u001eR\u0014\u0010$\u001a\u00020!8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\"\u0010#R(\u0010)\u001a\u0016\u0012\u0004\u0012\u00020\u0002\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010&0%8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u0014\u0010,\u001a\u00020*8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010+\u00a8\u0006/"}, d2 = {"Lcom/tencent/mobileqq/zootopia/download/file/ZPlanFileDownloadUtil;", "", "", "url", "Lcom/tencent/mobileqq/zootopia/download/ah;", "listener", "", "d", "logMsg", "", "isDebugOnly", "k", DomainData.DOMAIN_NAME, "l", h.F, "fullFilePath", "subCategoryName", "", "header", "isHighPriority", "Lnx4/a;", "i", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Ljava/lang/Boolean;Lnx4/a;)Z", "filePath", WadlProxyConsts.PARAM_FILENAME, "e", "", "categoryType", "f", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Ljava/lang/Boolean;Lcom/tencent/mobileqq/zootopia/download/ah;)Z", "Lkotlin/Function0;", "callback", "p", "Ljava/lang/Object;", "b", "Ljava/lang/Object;", "downloadListenerLock", "Ljava/util/concurrent/ConcurrentHashMap;", "Ljava/util/concurrent/CopyOnWriteArrayList;", "c", "Ljava/util/concurrent/ConcurrentHashMap;", "downloadListenerMap", "com/tencent/mobileqq/zootopia/download/file/ZPlanFileDownloadUtil$downloadListenerProxy$1", "Lcom/tencent/mobileqq/zootopia/download/file/ZPlanFileDownloadUtil$downloadListenerProxy$1;", "downloadListenerProxy", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class ZPlanFileDownloadUtil {

    /* renamed from: a, reason: collision with root package name */
    public static final ZPlanFileDownloadUtil f328039a = new ZPlanFileDownloadUtil();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final Object downloadListenerLock = new Object();

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static final ConcurrentHashMap<String, CopyOnWriteArrayList<ah>> downloadListenerMap = new ConcurrentHashMap<>();

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private static final ZPlanFileDownloadUtil$downloadListenerProxy$1 downloadListenerProxy;

    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\b\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0018\u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\f\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\r\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\u000f"}, d2 = {"com/tencent/mobileqq/zootopia/download/file/ZPlanFileDownloadUtil$a", "Lcom/tencent/mobileqq/zootopia/download/ah;", "", "progress", "Lcom/tencent/mobileqq/zootopia/download/x;", "task", "", "f", "c", "", "code", h.F, "d", "b", "e", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class a extends ah {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ nx4.a f328043b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f328044c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ long f328045d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(nx4.a aVar, String str, long j3) {
            super(null, 1, null);
            this.f328043b = aVar;
            this.f328044c = str;
            this.f328045d = j3;
        }

        @Override // com.tencent.mobileqq.zootopia.download.ah, com.tencent.mobileqq.zootopia.download.y
        public void b(x task) {
            Intrinsics.checkNotNullParameter(task, "task");
            ZPlanFileDownloadUtil.o(ZPlanFileDownloadUtil.f328039a, "downloadEmoResource onStartDownload - " + this.f328044c, false, 2, null);
        }

        @Override // com.tencent.mobileqq.zootopia.download.ah, com.tencent.mobileqq.zootopia.download.y
        public void c(x task) {
            Intrinsics.checkNotNullParameter(task, "task");
            ZPlanFileDownloadUtil.o(ZPlanFileDownloadUtil.f328039a, "downloadEmoResource!!! - " + this.f328044c + ", code=" + task.getDownloadFailCode() + ", averSpeed=" + t74.a.a(task.getCurAverageSpeed()) + ", totalCallbackTime=" + (System.currentTimeMillis() - this.f328045d) + "ms, " + task.m() + ", " + this.f328043b, false, 2, null);
            nx4.a aVar = this.f328043b;
            if (aVar != null) {
                int downloadFailCode = task.getDownloadFailCode();
                String m3 = task.m();
                ZPlanFileDownloadResult downloadResultInfo = task.getDownloadResultInfo();
                aVar.a(downloadFailCode, m3, downloadResultInfo != null ? downloadResultInfo.convertToLuaDownloadResult() : null);
            }
        }

        @Override // com.tencent.mobileqq.zootopia.download.ah, com.tencent.mobileqq.zootopia.download.y
        public void d(x task) {
            Intrinsics.checkNotNullParameter(task, "task");
            ZPlanFileDownloadUtil.o(ZPlanFileDownloadUtil.f328039a, "downloadEmoResource onWaitingDownload - " + this.f328044c, false, 2, null);
        }

        @Override // com.tencent.mobileqq.zootopia.download.ah, com.tencent.mobileqq.zootopia.download.y
        public void e(x task) {
            Intrinsics.checkNotNullParameter(task, "task");
            ZPlanFileDownloadUtil.o(ZPlanFileDownloadUtil.f328039a, "downloadEmoResource onPauseDownload - " + this.f328044c, false, 2, null);
        }

        @Override // com.tencent.mobileqq.zootopia.download.ah, com.tencent.mobileqq.zootopia.download.y
        public void f(float progress, x task) {
            Intrinsics.checkNotNullParameter(task, "task");
            nx4.a aVar = this.f328043b;
            if (aVar != null) {
                aVar.onDownloadProgress(progress, task.getCurReceivedLength(), task.getCurTotalLength());
            }
        }

        @Override // com.tencent.mobileqq.zootopia.download.ah, com.tencent.mobileqq.zootopia.download.y
        public void h(int code, x task) {
            Intrinsics.checkNotNullParameter(task, "task");
            ZPlanFileDownloadUtil.m(ZPlanFileDownloadUtil.f328039a, "downloadEmoResource!!! - " + this.f328044c + " --  code=" + code + ", FailCode=" + task.getDownloadFailCode() + ", FailInfo=" + task.getDownloadFailInfo() + ", totalCallbackTime=" + (System.currentTimeMillis() - this.f328045d) + "ms", false, 2, null);
            nx4.a aVar = this.f328043b;
            if (aVar != null) {
                aVar.onDownloadFailed(task.getDownloadFailCode(), task.getDownloadFailInfo());
            }
        }
    }

    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\b\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0018\u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\f\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\r\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\u000f"}, d2 = {"com/tencent/mobileqq/zootopia/download/file/ZPlanFileDownloadUtil$b", "Lcom/tencent/mobileqq/zootopia/download/ah;", "", "progress", "Lcom/tencent/mobileqq/zootopia/download/x;", "task", "", "f", "c", "", "code", h.F, "d", "b", "e", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class b extends ah {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ nx4.a f328046b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f328047c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ long f328048d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(nx4.a aVar, String str, long j3) {
            super(null, 1, null);
            this.f328046b = aVar;
            this.f328047c = str;
            this.f328048d = j3;
        }

        @Override // com.tencent.mobileqq.zootopia.download.ah, com.tencent.mobileqq.zootopia.download.y
        public void b(x task) {
            Intrinsics.checkNotNullParameter(task, "task");
            ZPlanFileDownloadUtil.o(ZPlanFileDownloadUtil.f328039a, "onStartDownload - " + this.f328047c, false, 2, null);
        }

        @Override // com.tencent.mobileqq.zootopia.download.ah, com.tencent.mobileqq.zootopia.download.y
        public void c(x task) {
            Intrinsics.checkNotNullParameter(task, "task");
            ZPlanFileDownloadUtil.o(ZPlanFileDownloadUtil.f328039a, "l2n_onComplete!!! - " + this.f328047c + ", code=" + task.getDownloadFailCode() + ", averSpeed=" + t74.a.a(task.getCurAverageSpeed()) + ", totalCallbackTime=" + (System.currentTimeMillis() - this.f328048d) + "ms, " + task.m() + ", " + this.f328046b, false, 2, null);
            nx4.a aVar = this.f328046b;
            if (aVar != null) {
                int downloadFailCode = task.getDownloadFailCode();
                String m3 = task.m();
                ZPlanFileDownloadResult downloadResultInfo = task.getDownloadResultInfo();
                aVar.a(downloadFailCode, m3, downloadResultInfo != null ? downloadResultInfo.convertToLuaDownloadResult() : null);
            }
        }

        @Override // com.tencent.mobileqq.zootopia.download.ah, com.tencent.mobileqq.zootopia.download.y
        public void d(x task) {
            Intrinsics.checkNotNullParameter(task, "task");
            ZPlanFileDownloadUtil.o(ZPlanFileDownloadUtil.f328039a, "onWaitingDownload - " + this.f328047c, false, 2, null);
        }

        @Override // com.tencent.mobileqq.zootopia.download.ah, com.tencent.mobileqq.zootopia.download.y
        public void e(x task) {
            Intrinsics.checkNotNullParameter(task, "task");
            ZPlanFileDownloadUtil.o(ZPlanFileDownloadUtil.f328039a, "onPauseDownload - " + this.f328047c, false, 2, null);
        }

        @Override // com.tencent.mobileqq.zootopia.download.ah, com.tencent.mobileqq.zootopia.download.y
        public void f(float progress, x task) {
            Intrinsics.checkNotNullParameter(task, "task");
            nx4.a aVar = this.f328046b;
            if (aVar != null) {
                aVar.onDownloadProgress(progress, task.getCurReceivedLength(), task.getCurTotalLength());
            }
        }

        @Override // com.tencent.mobileqq.zootopia.download.ah, com.tencent.mobileqq.zootopia.download.y
        public void h(int code, x task) {
            Intrinsics.checkNotNullParameter(task, "task");
            ZPlanFileDownloadUtil.m(ZPlanFileDownloadUtil.f328039a, "l2n_onFailed!!! - " + this.f328047c + " --  code=" + code + ", FailCode=" + task.getDownloadFailCode() + ", FailInfo=" + task.getDownloadFailInfo() + ", totalCallbackTime=" + (System.currentTimeMillis() - this.f328048d) + "ms", false, 2, null);
            nx4.a aVar = this.f328046b;
            if (aVar != null) {
                aVar.onDownloadFailed(task.getDownloadFailCode(), task.getDownloadFailInfo());
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v3, types: [com.tencent.mobileqq.zootopia.download.file.ZPlanFileDownloadUtil$downloadListenerProxy$1, com.tencent.mobileqq.zootopia.download.ah] */
    static {
        ?? r06 = new ah() { // from class: com.tencent.mobileqq.zootopia.download.file.ZPlanFileDownloadUtil$downloadListenerProxy$1
            private final void k(x xVar, boolean z16, Function1<? super ah, Unit> function1) {
                Object obj;
                ConcurrentHashMap concurrentHashMap;
                ConcurrentHashMap concurrentHashMap2;
                ArrayList arrayList = new ArrayList();
                obj = ZPlanFileDownloadUtil.downloadListenerLock;
                synchronized (obj) {
                    String url = xVar.getUrl();
                    concurrentHashMap = ZPlanFileDownloadUtil.downloadListenerMap;
                    CopyOnWriteArrayList copyOnWriteArrayList = (CopyOnWriteArrayList) concurrentHashMap.get(url);
                    if (copyOnWriteArrayList != null) {
                        Intrinsics.checkNotNullExpressionValue(copyOnWriteArrayList, "downloadListenerMap[url]");
                        Iterator it = copyOnWriteArrayList.iterator();
                        while (it.hasNext()) {
                            arrayList.add((ah) it.next());
                        }
                    }
                    if (z16) {
                        ZPlanFileDownloadUtil.o(ZPlanFileDownloadUtil.f328039a, "proxy# " + xVar.getId() + " removeFileDownloadListener", false, 2, null);
                        concurrentHashMap2 = ZPlanFileDownloadUtil.downloadListenerMap;
                        concurrentHashMap2.remove(url);
                    }
                    Unit unit = Unit.INSTANCE;
                }
                Iterator it5 = arrayList.iterator();
                while (it5.hasNext()) {
                    function1.invoke((ah) it5.next());
                }
            }

            @Override // com.tencent.mobileqq.zootopia.download.ah, com.tencent.mobileqq.zootopia.download.y
            public void a(final x task) {
                Intrinsics.checkNotNullParameter(task, "task");
                ZPlanFileDownloadUtil.o(ZPlanFileDownloadUtil.f328039a, "proxy# " + task.getId() + " -- onDecompress", false, 2, null);
                l(this, task, false, new Function1<ah, Unit>() { // from class: com.tencent.mobileqq.zootopia.download.file.ZPlanFileDownloadUtil$downloadListenerProxy$1$onDecompress$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(ah ahVar) {
                        invoke2(ahVar);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(ah it) {
                        Intrinsics.checkNotNullParameter(it, "it");
                        it.a(x.this);
                    }
                }, 1, null);
            }

            @Override // com.tencent.mobileqq.zootopia.download.ah, com.tencent.mobileqq.zootopia.download.y
            public void b(final x task) {
                Intrinsics.checkNotNullParameter(task, "task");
                ZPlanFileDownloadUtil.o(ZPlanFileDownloadUtil.f328039a, "proxy# " + task.getId() + " -- onStartDownload", false, 2, null);
                l(this, task, false, new Function1<ah, Unit>() { // from class: com.tencent.mobileqq.zootopia.download.file.ZPlanFileDownloadUtil$downloadListenerProxy$1$onStartDownload$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(ah ahVar) {
                        invoke2(ahVar);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(ah it) {
                        Intrinsics.checkNotNullParameter(it, "it");
                        it.b(x.this);
                    }
                }, 1, null);
            }

            @Override // com.tencent.mobileqq.zootopia.download.ah, com.tencent.mobileqq.zootopia.download.y
            public void c(final x task) {
                Intrinsics.checkNotNullParameter(task, "task");
                ZPlanFileDownloadUtil.o(ZPlanFileDownloadUtil.f328039a, "proxy# " + task.getId() + " -- onComplete!!! ", false, 2, null);
                k(task, true, new Function1<ah, Unit>() { // from class: com.tencent.mobileqq.zootopia.download.file.ZPlanFileDownloadUtil$downloadListenerProxy$1$onComplete$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(ah ahVar) {
                        invoke2(ahVar);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(ah it) {
                        Intrinsics.checkNotNullParameter(it, "it");
                        try {
                            it.c(x.this);
                        } catch (Exception e16) {
                            QLog.e("ZPlanFileDownloadUtil_", 1, "proxy# notifyComplete Exception!", e16);
                        }
                    }
                });
            }

            @Override // com.tencent.mobileqq.zootopia.download.ah, com.tencent.mobileqq.zootopia.download.y
            public void d(final x task) {
                Intrinsics.checkNotNullParameter(task, "task");
                ZPlanFileDownloadUtil.o(ZPlanFileDownloadUtil.f328039a, "proxy# " + task.getId() + " -- onWaitingDownload", false, 2, null);
                l(this, task, false, new Function1<ah, Unit>() { // from class: com.tencent.mobileqq.zootopia.download.file.ZPlanFileDownloadUtil$downloadListenerProxy$1$onWaitingDownload$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(ah ahVar) {
                        invoke2(ahVar);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(ah it) {
                        Intrinsics.checkNotNullParameter(it, "it");
                        it.d(x.this);
                    }
                }, 1, null);
            }

            @Override // com.tencent.mobileqq.zootopia.download.ah, com.tencent.mobileqq.zootopia.download.y
            public void e(final x task) {
                Intrinsics.checkNotNullParameter(task, "task");
                ZPlanFileDownloadUtil.m(ZPlanFileDownloadUtil.f328039a, "proxy# " + task.getId() + " -- onPause", false, 2, null);
                l(this, task, false, new Function1<ah, Unit>() { // from class: com.tencent.mobileqq.zootopia.download.file.ZPlanFileDownloadUtil$downloadListenerProxy$1$onPause$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(ah ahVar) {
                        invoke2(ahVar);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(ah it) {
                        Intrinsics.checkNotNullParameter(it, "it");
                        it.e(x.this);
                    }
                }, 1, null);
            }

            @Override // com.tencent.mobileqq.zootopia.download.ah, com.tencent.mobileqq.zootopia.download.y
            public void f(final float progress, final x task) {
                Intrinsics.checkNotNullParameter(task, "task");
                ZPlanFileDownloadUtil.f328039a.k("proxy# " + task.getId() + " -- onProgress:: process == " + progress, true);
                l(this, task, false, new Function1<ah, Unit>() { // from class: com.tencent.mobileqq.zootopia.download.file.ZPlanFileDownloadUtil$downloadListenerProxy$1$onProgress$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(ah ahVar) {
                        invoke2(ahVar);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(ah it) {
                        Intrinsics.checkNotNullParameter(it, "it");
                        it.f(progress, task);
                    }
                }, 1, null);
            }

            @Override // com.tencent.mobileqq.zootopia.download.ah, com.tencent.mobileqq.zootopia.download.y
            public void h(final int code, final x task) {
                Intrinsics.checkNotNullParameter(task, "task");
                ZPlanFileDownloadUtil.m(ZPlanFileDownloadUtil.f328039a, "proxy# " + task.getId() + " -- onFailed = " + code, false, 2, null);
                k(task, true, new Function1<ah, Unit>() { // from class: com.tencent.mobileqq.zootopia.download.file.ZPlanFileDownloadUtil$downloadListenerProxy$1$onFailed$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(ah ahVar) {
                        invoke2(ahVar);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(ah it) {
                        Intrinsics.checkNotNullParameter(it, "it");
                        it.h(code, task);
                    }
                });
            }

            @Override // com.tencent.mobileqq.zootopia.download.ah, com.tencent.mobileqq.zootopia.download.y
            public void i(final long size, final x task) {
                Intrinsics.checkNotNullParameter(task, "task");
                ZPlanFileDownloadUtil.o(ZPlanFileDownloadUtil.f328039a, "proxy# " + task.getId() + " -- onDetectedSize:: size == " + size, false, 2, null);
                l(this, task, false, new Function1<ah, Unit>() { // from class: com.tencent.mobileqq.zootopia.download.file.ZPlanFileDownloadUtil$downloadListenerProxy$1$onDetectedSize$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(ah ahVar) {
                        invoke2(ahVar);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(ah it) {
                        Intrinsics.checkNotNullParameter(it, "it");
                        it.i(size, task);
                    }
                }, 1, null);
            }

            static /* synthetic */ void l(ZPlanFileDownloadUtil$downloadListenerProxy$1 zPlanFileDownloadUtil$downloadListenerProxy$1, x xVar, boolean z16, Function1 function1, int i3, Object obj) {
                if ((i3 & 1) != 0) {
                    z16 = false;
                }
                zPlanFileDownloadUtil$downloadListenerProxy$1.k(xVar, z16, function1);
            }
        };
        downloadListenerProxy = r06;
        FileDownloadManager.f328148a.f(r06);
    }

    ZPlanFileDownloadUtil() {
    }

    private final void d(String url, ah listener) {
        synchronized (downloadListenerLock) {
            if (!TextUtils.isEmpty(url) && listener != null) {
                ConcurrentHashMap<String, CopyOnWriteArrayList<ah>> concurrentHashMap = downloadListenerMap;
                CopyOnWriteArrayList<ah> copyOnWriteArrayList = concurrentHashMap.get(url);
                if (copyOnWriteArrayList == null) {
                    copyOnWriteArrayList = new CopyOnWriteArrayList<>();
                    concurrentHashMap.put(url, copyOnWriteArrayList);
                }
                if (!copyOnWriteArrayList.contains(listener)) {
                    copyOnWriteArrayList.add(listener);
                }
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void k(String logMsg, boolean isDebugOnly) {
        if (h(isDebugOnly)) {
            QLog.d("ZPlanFileDownloadUtil_", 1, logMsg);
        }
    }

    private final void l(String logMsg, boolean isDebugOnly) {
        if (h(isDebugOnly)) {
            QLog.e("ZPlanFileDownloadUtil_", 1, logMsg);
        }
    }

    private final void n(String logMsg, boolean isDebugOnly) {
        if (h(isDebugOnly)) {
            QLog.i("ZPlanFileDownloadUtil_", 1, logMsg);
        }
    }

    private final boolean h(boolean isDebugOnly) {
        return !isDebugOnly || QLog.isColorLevel();
    }

    public final void p(int categoryType, String url, Function0<Unit> callback) {
        Intrinsics.checkNotNullParameter(url, "url");
        o(this, "pauseDownloadFile# " + categoryType + " _ " + url, false, 2, null);
        FileDownloadManager.f328148a.t(new FileDownloadParams(categoryType, url, null, null, null, null, null, null, null, false, 1020, null), callback);
    }

    public final boolean e(String url, String filePath, String fileName, nx4.a listener) {
        Intrinsics.checkNotNullParameter(url, "url");
        String str = "downloadEmoResource# " + url;
        long currentTimeMillis = System.currentTimeMillis();
        o(this, "START - " + str + ", fullFilePath= " + filePath + ", fileName=" + fileName + ", listener=" + listener, false, 2, null);
        return f(ZPlanFileCategory.EMOTICON.getValue(), url, filePath, fileName, "", null, Boolean.TRUE, new a(listener, str, currentTimeMillis));
    }

    public final boolean f(int categoryType, String url, String filePath, String fileName, String subCategoryName, Map<String, String> header, Boolean isHighPriority, ah listener) {
        Intrinsics.checkNotNullParameter(url, "url");
        if (TextUtils.isEmpty(url)) {
            if (listener != null) {
                listener.h(-99901, new f("", 0, "", "", "", header, null, 64, null));
            }
            return false;
        }
        d(url, listener);
        FileDownloadManager.f328148a.y(new FileDownloadParams(categoryType, url, header, filePath, fileName, subCategoryName, null, null, null, false, 960, null));
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean i(String url, String fullFilePath, String subCategoryName, Map<String, String> header, Boolean isHighPriority, nx4.a listener) {
        String str;
        List split$default;
        String str2;
        Intrinsics.checkNotNullParameter(url, "url");
        String str3 = "l2nDownloadFile# " + url;
        long currentTimeMillis = System.currentTimeMillis();
        String str4 = "";
        if (fullFilePath == null) {
            str = "";
        } else {
            String separator = File.separator;
            Intrinsics.checkNotNullExpressionValue(separator, "separator");
            split$default = StringsKt__StringsKt.split$default((CharSequence) fullFilePath, new String[]{separator}, false, 0, 6, (Object) null);
            if (split$default.size() <= 1) {
                str2 = "";
            } else {
                Object obj = split$default.get(split$default.size() - 1);
                str4 = fullFilePath.substring(0, (fullFilePath.length() - ((String) obj).length()) - 1);
                Intrinsics.checkNotNullExpressionValue(str4, "this as java.lang.String\u2026ing(startIndex, endIndex)");
                str2 = obj;
            }
            String str5 = str4;
            str4 = str2;
            str = str5;
        }
        return f(ZPlanFileCategory.LuaDownload.getValue(), url, str, str4, subCategoryName, header, isHighPriority, new b(listener, str3, currentTimeMillis));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void m(ZPlanFileDownloadUtil zPlanFileDownloadUtil, String str, boolean z16, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z16 = false;
        }
        zPlanFileDownloadUtil.l(str, z16);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void o(ZPlanFileDownloadUtil zPlanFileDownloadUtil, String str, boolean z16, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z16 = false;
        }
        zPlanFileDownloadUtil.n(str, z16);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void q(ZPlanFileDownloadUtil zPlanFileDownloadUtil, int i3, String str, Function0 function0, int i16, Object obj) {
        if ((i16 & 4) != 0) {
            function0 = null;
        }
        zPlanFileDownloadUtil.p(i3, str, function0);
    }
}
