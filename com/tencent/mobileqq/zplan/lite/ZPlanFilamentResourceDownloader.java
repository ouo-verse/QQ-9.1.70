package com.tencent.mobileqq.zplan.lite;

import android.os.SystemClock;
import com.tencent.biz.common.util.ZipUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.filament.zplan.engine.js.FilamentFileUtil;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qcoroutine.api.coroutine.CorountineFunKt;
import com.tencent.mobileqq.qcoroutine.api.i;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.z1.download.ZPlanFileCategory;
import com.tencent.mobileqq.zootopia.download.ah;
import com.tencent.mobileqq.zootopia.download.file.ZPlanFileDownloadUtil;
import com.tencent.mobileqq.zootopia.download.x;
import com.tencent.qphone.base.util.QLog;
import com.tencent.zplan.common.utils.d;
import java.io.File;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugProbes;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.Regex;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import kotlinx.coroutines.CoroutineScopeKt;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;
import t74.r;
import tl.h;

@Deprecated(message = "\u5e9f\u5f03\uff0c\u4f7f\u7528com.tencent.filament.zplan.avatar.ZPlanAvatarResourceHelper\u4ee3\u66ff")
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010%\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\b\u00c7\u0002\u0018\u00002\u00020\u0001:\u0001\u001fB\t\b\u0002\u00a2\u0006\u0004\b\u001d\u0010\u001eJS\u0010\u0006\u001a\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0002j\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003`\u00042\"\u0010\u0005\u001a\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0002j\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003`\u0004H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0006\u0010\u0007J#\u0010\u000b\u001a\u00020\n2\u0006\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0003H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u000b\u0010\fJ$\u0010\u0011\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\u00032\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u000eH\u0002J'\u0010\u0014\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0012\u001a\u00020\u00032\b\u0010\u0013\u001a\u0004\u0018\u00010\u0003H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0014\u0010\fJ(\u0010\u0018\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u00032\u000e\u0010\u0017\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0016H\u0002J\u0010\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u0003H\u0002J\u0010\u0010\u001b\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u0003H\u0002JF\u0010\u001c\u001a\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0002j\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003`\u00042\"\u0010\u0005\u001a\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0002j\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003`\u0004\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006 "}, d2 = {"Lcom/tencent/mobileqq/zplan/lite/ZPlanFilamentResourceDownloader;", "", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "avatarUrlMap", h.F, "(Ljava/util/HashMap;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "zip", "targetPath", "", DomainData.DOMAIN_NAME, "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "key", "", "map", "", "j", "url", "savePath", "g", "destPath", "Lkotlin/coroutines/Continuation;", "it", "k", WadlProxyConsts.RES_URL, "l", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "i", "<init>", "()V", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class ZPlanFilamentResourceDownloader {

    /* renamed from: a, reason: collision with root package name */
    public static final ZPlanFilamentResourceDownloader f333782a = new ZPlanFilamentResourceDownloader();

    ZPlanFilamentResourceDownloader() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object g(final String str, final String str2, Continuation<? super String> continuation) {
        Continuation intercepted;
        String str3;
        Object coroutine_suspended;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        final SafeContinuation safeContinuation = new SafeContinuation(intercepted);
        String c16 = d.c(str + Math.random());
        if (str2 == null || str2.length() == 0) {
            str3 = "/sdcard/Android/data/com.tencent.mobileqq/cache/zplan/.filament/tmp/" + c16;
        } else {
            str3 = str2;
        }
        if (!f333782a.k(str, str3, safeContinuation)) {
            QLog.i("ZPlanFilamentResourceDownloader", 1, "download url: " + str + ", savePath: " + str2 + ", download save path : /sdcard/Android/data/com.tencent.mobileqq/cache/zplan/.filament/tmp_" + c16);
            ZPlanFileDownloadUtil.f328039a.f(ZPlanFileCategory.FILAMENT.getValue(), str, "/sdcard/Android/data/com.tencent.mobileqq/cache/zplan/.filament/tmp", c16, "", null, Boxing.boxBoolean(true), new ah(str, str2, safeContinuation) { // from class: com.tencent.mobileqq.zplan.lite.ZPlanFilamentResourceDownloader$download$2$1

                /* renamed from: b, reason: collision with root package name and from kotlin metadata */
                private final Map<String, String> reportMap;

                /* renamed from: c, reason: collision with root package name and from kotlin metadata */
                private final long beginEnqueue;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ String f333787d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ Continuation<String> f333788e;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(null, 1, null);
                    this.f333787d = str2;
                    this.f333788e = safeContinuation;
                    LinkedHashMap linkedHashMap = new LinkedHashMap();
                    linkedHashMap.put("params_download_url", str);
                    this.reportMap = linkedHashMap;
                    this.beginEnqueue = SystemClock.uptimeMillis();
                }

                @Override // com.tencent.mobileqq.zootopia.download.ah, com.tencent.mobileqq.zootopia.download.y
                public void c(final x task) {
                    Intrinsics.checkNotNullParameter(task, "task");
                    super.c(task);
                    long uptimeMillis = SystemClock.uptimeMillis() - this.beginEnqueue;
                    boolean z16 = true;
                    QLog.i("ZPlanFilamentResourceDownloader", 1, "download onComplete " + task.m() + ", [timecost=" + uptimeMillis + "][url=" + task.getUrl() + "]");
                    String str4 = this.f333787d;
                    if (str4 != null && str4.length() != 0) {
                        z16 = false;
                    }
                    if (z16) {
                        Continuation<String> continuation2 = this.f333788e;
                        Result.Companion companion = Result.INSTANCE;
                        continuation2.resumeWith(Result.m476constructorimpl(task.m()));
                    } else {
                        MqqHandler fileThreadHandler = ThreadManager.getFileThreadHandler();
                        final String str5 = this.f333787d;
                        final Continuation<String> continuation3 = this.f333788e;
                        fileThreadHandler.post(new Runnable() { // from class: com.tencent.mobileqq.zplan.lite.ZPlanFilamentResourceDownloader$download$2$1$onComplete$1
                            @Override // java.lang.Runnable
                            public final void run() {
                                boolean copyFile = FileUtils.copyFile(x.this.m(), str5, true);
                                QLog.i("ZPlanFilamentResourceDownloader", 1, "download onComplete copy ret: " + copyFile + ", " + x.this.m() + ", savePath: " + str5);
                                Continuation<String> continuation4 = continuation3;
                                Result.Companion companion2 = Result.INSTANCE;
                                continuation4.resumeWith(Result.m476constructorimpl(copyFile ? str5 : null));
                                FileUtils.deleteFile(x.this.m());
                            }
                        });
                    }
                    this.reportMap.put("params_download_duration", String.valueOf(uptimeMillis));
                    this.reportMap.put("params_download_ret", "1");
                    ZPlanFilamentResourceDownloader.f333782a.j("zplanlite_download_res", this.reportMap);
                }

                @Override // com.tencent.mobileqq.zootopia.download.ah, com.tencent.mobileqq.zootopia.download.y
                public void h(int code, x task) {
                    Intrinsics.checkNotNullParameter(task, "task");
                    super.h(code, task);
                    long uptimeMillis = SystemClock.uptimeMillis() - this.beginEnqueue;
                    QLog.e("ZPlanFilamentResourceDownloader", 1, "download onFailed, url=" + task.getUrl());
                    this.f333788e.resumeWith(Result.m476constructorimpl(null));
                    this.reportMap.put("params_download_duration", String.valueOf(uptimeMillis));
                    this.reportMap.put("params_download_ret", "0");
                    this.reportMap.put("params_download_error_code", String.valueOf(task.getDownloadFailCode()));
                    this.reportMap.put("params_download_error_msg", task.getDownloadFailInfo());
                    ZPlanFilamentResourceDownloader.f333782a.j("zplanlite_download_res", this.reportMap);
                }
            });
        }
        Object orThrow = safeContinuation.getOrThrow();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (orThrow == coroutine_suspended) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return orThrow;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object h(HashMap<String, String> hashMap, Continuation<? super HashMap<String, String>> continuation) {
        return CoroutineScopeKt.coroutineScope(new ZPlanFilamentResourceDownloader$downloadAvatarResource$2(hashMap, null), continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void j(String key, Map<String, String> map) {
        AppRuntime runtime;
        BaseApplicationImpl application = BaseApplicationImpl.getApplication();
        String account = (application == null || (runtime = application.getRuntime()) == null) ? null : runtime.getAccount();
        if (account == null) {
            account = "";
        }
        map.put("params_uin", account);
        map.put("params_timestamp", String.valueOf(System.currentTimeMillis()));
        r.e(null, key, map, 1, null);
    }

    private final boolean k(String url, String destPath, Continuation<? super String> it) {
        Map<String, String> mutableMapOf;
        long uptimeMillis = SystemClock.uptimeMillis();
        String c16 = com.tencent.mobileqq.zplan.utils.h.f335824a.c(url, destPath);
        if (c16 == null || c16.length() == 0) {
            return false;
        }
        it.resumeWith(Result.m476constructorimpl(destPath));
        long uptimeMillis2 = SystemClock.uptimeMillis() - uptimeMillis;
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("params_download_url", url), TuplesKt.to("params_download_duration", String.valueOf(uptimeMillis2)), TuplesKt.to("params_download_ret", "1"), TuplesKt.to("params_copy_asset_ret", "1"));
        j("zplanlite_download_res", mutableMapOf);
        QLog.i("ZPlanFilamentResourceDownloader", 1, "copy asset onComplete " + destPath + ", [timecost=" + uptimeMillis2 + "][url=" + url + "]");
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String l(String resUrl) {
        String replace$default;
        replace$default = StringsKt__StringsJVMKt.replace$default(new Regex(".*resources").replace(resUrl, "/sdcard/Android/data/com.tencent.mobileqq/cache/zplan/.filament"), ".fasset", "/", false, 4, (Object) null);
        return replace$default;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String m(String resUrl) {
        String substringAfterLast$default;
        String substringBefore$default;
        substringAfterLast$default = StringsKt__StringsKt.substringAfterLast$default(resUrl, "/", (String) null, 2, (Object) null);
        substringBefore$default = StringsKt__StringsKt.substringBefore$default(substringAfterLast$default, ".", (String) null, 2, (Object) null);
        return FilamentFileUtil.INSTANCE.pathAppend("/sdcard/Android/data/com.tencent.mobileqq/cache/zplan/.filament", "ugc/" + substringBefore$default + "/");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object n(final String str, final String str2, Continuation<? super Boolean> continuation) {
        Continuation intercepted;
        Object coroutine_suspended;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        final SafeContinuation safeContinuation = new SafeContinuation(intercepted);
        ThreadManager.getFileThreadHandler().post(new Runnable() { // from class: com.tencent.mobileqq.zplan.lite.ZPlanFilamentResourceDownloader$unzip$2$1
            @Override // java.lang.Runnable
            public final void run() {
                FAssetChecker fAssetChecker;
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                linkedHashMap.put("params_unzip_res_target_path", str2);
                try {
                    try {
                        fAssetChecker = FAssetChecker.f333779a;
                    } catch (Exception e16) {
                        QLog.e("ZPlanFilamentResourceDownloader", 1, "unzip fail. zip:" + str + ", target:" + str2 + ", error:" + e16);
                        FileUtils.deleteDirectory(str2);
                        Continuation<Boolean> continuation2 = safeContinuation;
                        Result.Companion companion = Result.INSTANCE;
                        continuation2.resumeWith(Result.m476constructorimpl(Boolean.FALSE));
                        linkedHashMap.put("params_unzip_res_ret", "0");
                        String message = e16.getMessage();
                        if (message == null) {
                            message = "Exception";
                        }
                        linkedHashMap.put("params_unzip_res_error_msg", message);
                    }
                    if (fAssetChecker.c(str2)) {
                        Continuation<Boolean> continuation3 = safeContinuation;
                        Result.Companion companion2 = Result.INSTANCE;
                        continuation3.resumeWith(Result.m476constructorimpl(Boolean.TRUE));
                        return;
                    }
                    File file = new File(str);
                    FileUtils.deleteDirectory(str2);
                    ZipUtils.unZipFile(file, str2, false);
                    String d16 = fAssetChecker.d(str2, "verify");
                    FileUtils.deleteFile(file);
                    if (FileUtils.writeFile(d16, "verify")) {
                        Continuation<Boolean> continuation4 = safeContinuation;
                        Result.Companion companion3 = Result.INSTANCE;
                        continuation4.resumeWith(Result.m476constructorimpl(Boolean.TRUE));
                        linkedHashMap.put("params_unzip_res_ret", "1");
                    } else {
                        QLog.e("ZPlanFilamentResourceDownloader", 1, "unzip fail. zip:" + str + ", write verify failed.");
                        Continuation<Boolean> continuation5 = safeContinuation;
                        Result.Companion companion4 = Result.INSTANCE;
                        continuation5.resumeWith(Result.m476constructorimpl(Boolean.FALSE));
                        linkedHashMap.put("params_unzip_res_ret", "0");
                    }
                } finally {
                    ZPlanFilamentResourceDownloader.f333782a.j("zplanlite_unzip_res", linkedHashMap);
                }
            }
        });
        Object orThrow = safeContinuation.getOrThrow();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (orThrow == coroutine_suspended) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return orThrow;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [T, java.util.HashMap] */
    public final HashMap<String, String> i(HashMap<String, String> avatarUrlMap) {
        Intrinsics.checkNotNullParameter(avatarUrlMap, "avatarUrlMap");
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = new HashMap();
        CorountineFunKt.g(i.d.f261782e, "ZPlanFilamentResourceDownloader_getAvatarResource", null, new ZPlanFilamentResourceDownloader$getAvatarResource$1(objectRef, avatarUrlMap, null), 4, null);
        return (HashMap) objectRef.element;
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\r\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u0012\u0006\u0010\u0011\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0012\u0010\u0013J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\"\u0010\u000e\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\t\u0010\u000b\"\u0004\b\f\u0010\rR\"\u0010\u0011\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000f\u0010\n\u001a\u0004\b\u000f\u0010\u000b\"\u0004\b\u0010\u0010\r\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/zplan/lite/ZPlanFilamentResourceDownloader$a;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "()Ljava/lang/String;", "c", "(Ljava/lang/String;)V", "key", "b", "d", "localPath", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.zplan.lite.ZPlanFilamentResourceDownloader$a, reason: from toString */
    /* loaded from: classes34.dex */
    public static final /* data */ class AvatarResourceResult {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        private String key;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        private String localPath;

        public AvatarResourceResult(String key, String localPath) {
            Intrinsics.checkNotNullParameter(key, "key");
            Intrinsics.checkNotNullParameter(localPath, "localPath");
            this.key = key;
            this.localPath = localPath;
        }

        /* renamed from: a, reason: from getter */
        public final String getKey() {
            return this.key;
        }

        /* renamed from: b, reason: from getter */
        public final String getLocalPath() {
            return this.localPath;
        }

        public final void c(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.key = str;
        }

        public final void d(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.localPath = str;
        }

        public int hashCode() {
            return (this.key.hashCode() * 31) + this.localPath.hashCode();
        }

        public String toString() {
            return "AvatarResourceResult(key=" + this.key + ", localPath=" + this.localPath + ")";
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof AvatarResourceResult)) {
                return false;
            }
            AvatarResourceResult avatarResourceResult = (AvatarResourceResult) other;
            return Intrinsics.areEqual(this.key, avatarResourceResult.key) && Intrinsics.areEqual(this.localPath, avatarResourceResult.localPath);
        }
    }
}
