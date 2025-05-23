package com.tencent.localedit.fakenative.preload;

import androidx.annotation.Keep;
import com.tencent.localedit.LocalEditSDK;
import com.tencent.localedit.fakenative.core.BaseManager;
import com.tencent.localedit.fakenative.meta.CommonConvertResult;
import com.tencent.localedit.fakenative.meta.ConvertPerformanceData;
import com.tencent.localedit.fakenative.meta.FileIORequestData;
import com.tencent.localedit.fakenative.meta.LoadConvertOptions;
import com.tencent.localedit.fakenative.meta.LocalServerResponse;
import com.tencent.localedit.fakenative.resource.LoadSuccessTask;
import com.tencent.localedit.fakenative.resource.ResourceScheduler;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__BuildersKt;
import kotlinx.coroutines.CompletableDeferred;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import w11.a;
import x11.b;

@Keep
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 ,2\u00020\u0001:\u0001-B\u0007\u00a2\u0006\u0004\b*\u0010+J(\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u000e\u0010\f\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nJ\u000e\u0010\r\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0002J\u001d\u0010\u000e\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0002H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u000e\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nJ\u0014\u0010\u0014\u001a\u00020\b2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011J3\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u00062\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u0017\u001a\u00020\u0006\u00a2\u0006\u0004\b\u0018\u0010\u0019R\u0017\u0010\u001b\u001a\u00020\u001a8\u0006\u00a2\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR#\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020 0\u001f8\u0006\u00a2\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$R\u001a\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00120%8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b&\u0010'R \u0010)\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020(0\u001f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b)\u0010\"\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006."}, d2 = {"Lcom/tencent/localedit/fakenative/preload/FilePreloadManager;", "Lcom/tencent/localedit/fakenative/core/BaseManager;", "", "localFilePath", "fileData", "globalPadId", "", "noPassword", "", "handleLoadSuccess", "Lcom/tencent/localedit/fakenative/meta/FileIORequestData;", "info", "addPreloadTask", "removePreloadTask", "getLoadDocsResult", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "loadDocs", "", "", "list", "updateSupportTypeList", "isStart", "isUseCache", "useChunkImport", "trackConvertData", "(Ljava/lang/String;ZLjava/lang/Boolean;Z)V", "Lcom/tencent/localedit/fakenative/resource/ResourceScheduler;", "resourceScheduler", "Lcom/tencent/localedit/fakenative/resource/ResourceScheduler;", "getResourceScheduler", "()Lcom/tencent/localedit/fakenative/resource/ResourceScheduler;", "", "Lcom/tencent/localedit/fakenative/meta/ConvertPerformanceData;", "trackerCache", "Ljava/util/Map;", "getTrackerCache", "()Ljava/util/Map;", "", "supportTypeList", "Ljava/util/List;", "Lcom/tencent/localedit/fakenative/preload/PreloadDocsTask;", "preloadDocsTask", "<init>", "()V", "Companion", "a", "docx_local_edit_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes7.dex */
public final class FilePreloadManager extends BaseManager {

    @NotNull
    private static final String TAG = "FilePreloadManager";

    @NotNull
    private final Map<String, PreloadDocsTask> preloadDocsTask;

    @NotNull
    private final List<Integer> supportTypeList;

    @NotNull
    private final ResourceScheduler resourceScheduler = new ResourceScheduler(null, 1, 0 == true ? 1 : 0);

    @NotNull
    private final Map<String, ConvertPerformanceData> trackerCache = new ConcurrentHashMap();

    public FilePreloadManager() {
        List<Integer> mutableListOf;
        mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(0, 1);
        this.supportTypeList = mutableListOf;
        this.preloadDocsTask = new ConcurrentHashMap();
    }

    private final void handleLoadSuccess(String localFilePath, String fileData, String globalPadId, boolean noPassword) {
        this.resourceScheduler.b(new LoadSuccessTask(localFilePath, fileData, !noPassword, globalPadId));
    }

    public static /* synthetic */ void trackConvertData$default(FilePreloadManager filePreloadManager, String str, boolean z16, Boolean bool, boolean z17, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            bool = null;
        }
        if ((i3 & 8) != 0) {
            z17 = false;
        }
        filePreloadManager.trackConvertData(str, z16, bool, z17);
    }

    public final synchronized void addPreloadTask(@NotNull FileIORequestData info) {
        int intValue;
        Intrinsics.checkNotNullParameter(info, "info");
        b bVar = b.f446855a;
        bVar.a(TAG, Intrinsics.stringPlus("Local_edit_preload addPreloadTask globalPadId=", info.getGlobalPadId()));
        Integer docType = info.getDocType();
        if (docType == null) {
            intValue = 0;
        } else {
            intValue = docType.intValue();
        }
        if (!this.supportTypeList.contains(Integer.valueOf(intValue))) {
            bVar.a(TAG, Intrinsics.stringPlus("Local_edit_preload addPreloadTask unSupportType: ", Integer.valueOf(intValue)));
            return;
        }
        String globalPadId = info.getGlobalPadId();
        CompletableDeferred completableDeferred = null;
        byte b16 = 0;
        if (!(!this.preloadDocsTask.containsKey(globalPadId))) {
            globalPadId = null;
        }
        if (globalPadId != null) {
            PreloadDocsTask preloadDocsTask = new PreloadDocsTask(info, completableDeferred, 2, b16 == true ? 1 : 0);
            this.preloadDocsTask.put(globalPadId, preloadDocsTask);
            getResourceScheduler().b(preloadDocsTask);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0057 A[Catch: all -> 0x0069, TRY_LEAVE, TryCatch #0 {, blocks: (B:3:0x0001, B:5:0x0005, B:7:0x0010, B:8:0x0019, B:11:0x0027, B:12:0x0052, B:18:0x0057, B:20:0x002f, B:21:0x0037, B:22:0x0038, B:25:0x0046, B:29:0x0014), top: B:2:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0038 A[Catch: all -> 0x0069, TryCatch #0 {, blocks: (B:3:0x0001, B:5:0x0005, B:7:0x0010, B:8:0x0019, B:11:0x0027, B:12:0x0052, B:18:0x0057, B:20:0x002f, B:21:0x0037, B:22:0x0038, B:25:0x0046, B:29:0x0014), top: B:2:0x0001 }] */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final synchronized Object getLoadDocsResult(@NotNull String str, @NotNull Continuation<? super String> continuation) {
        FilePreloadManager$getLoadDocsResult$1 filePreloadManager$getLoadDocsResult$1;
        Object coroutine_suspended;
        int i3;
        String str2;
        if (continuation instanceof FilePreloadManager$getLoadDocsResult$1) {
            filePreloadManager$getLoadDocsResult$1 = (FilePreloadManager$getLoadDocsResult$1) continuation;
            int i16 = filePreloadManager$getLoadDocsResult$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                filePreloadManager$getLoadDocsResult$1.label = i16 - Integer.MIN_VALUE;
                Object obj = filePreloadManager$getLoadDocsResult$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = filePreloadManager$getLoadDocsResult$1.label;
                String str3 = null;
                if (i3 == 0) {
                    if (i3 == 1) {
                        str = (String) filePreloadManager$getLoadDocsResult$1.L$0;
                        ResultKt.throwOnFailure(obj);
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    ResultKt.throwOnFailure(obj);
                    PreloadDocsTask remove = this.preloadDocsTask.remove(str);
                    if (remove != null) {
                        filePreloadManager$getLoadDocsResult$1.L$0 = str;
                        filePreloadManager$getLoadDocsResult$1.label = 1;
                        obj = remove.c(filePreloadManager$getLoadDocsResult$1);
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else {
                        return str3;
                    }
                }
                str2 = (String) obj;
                if (str2 == null) {
                    b.f446855a.a(TAG, Intrinsics.stringPlus("Local_edit_preload getResult suc globalPadId=", str));
                    str3 = str2;
                }
                return str3;
            }
        }
        filePreloadManager$getLoadDocsResult$1 = new FilePreloadManager$getLoadDocsResult$1(this, continuation);
        Object obj2 = filePreloadManager$getLoadDocsResult$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = filePreloadManager$getLoadDocsResult$1.label;
        String str32 = null;
        if (i3 == 0) {
        }
        str2 = (String) obj2;
        if (str2 == null) {
        }
        return str32;
    }

    @NotNull
    public final ResourceScheduler getResourceScheduler() {
        return this.resourceScheduler;
    }

    @NotNull
    public final Map<String, ConvertPerformanceData> getTrackerCache() {
        return this.trackerCache;
    }

    @NotNull
    public final String loadDocs(@NotNull FileIORequestData info) {
        boolean z16;
        String str;
        boolean z17;
        String str2;
        int intValue;
        Object runBlocking$default;
        Intrinsics.checkNotNullParameter(info, "info");
        b bVar = b.f446855a;
        bVar.d(TAG, Intrinsics.stringPlus("Local_edit loadDocs info = ", info));
        String localFilePath = info.getLocalFilePath();
        if (localFilePath == null) {
            localFilePath = "";
        }
        LocalEditSDK localEditSDK = LocalEditSDK.INSTANCE;
        String d16 = localEditSDK.getCache().d(localFilePath);
        if (d16 == null) {
            bVar.d(TAG, Intrinsics.stringPlus("Local_edit loadDocs file not exist, originFilePath=", localFilePath));
            return new LocalServerResponse(23004, null, null, 0, 14, null).toJsonString();
        }
        String globalPadId = info.getGlobalPadId();
        trackConvertData$default(this, globalPadId, true, null, false, 12, null);
        String i3 = localEditSDK.getCache().i(d16, globalPadId);
        if (i3.length() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            str = i3;
        } else {
            str = null;
        }
        if (str == null) {
            String password = info.getPassword();
            if (password != null && password.length() != 0) {
                z17 = false;
            } else {
                z17 = true;
            }
            if (z17) {
                str2 = null;
            } else {
                str2 = "pw";
            }
            String b16 = localEditSDK.getCache().b(d16, globalPadId, str2);
            String stringPlus = Intrinsics.stringPlus(localEditSDK.getCache().o(globalPadId), "/");
            Integer docType = info.getDocType();
            if (docType == null) {
                intValue = 0;
            } else {
                intValue = docType.intValue();
            }
            boolean z18 = z17;
            runBlocking$default = BuildersKt__BuildersKt.runBlocking$default(null, new FilePreloadManager$loadDocs$result$1(new LoadConvertOptions(intValue, stringPlus, d16, b16, null, null, info.getPassword(), null, null, 432, null), null), 1, null);
            CommonConvertResult commonConvertResult = (CommonConvertResult) runBlocking$default;
            bVar.d(TAG, Intrinsics.stringPlus("Local_edit loadDocs result = ", commonConvertResult));
            if (commonConvertResult.getCode() != 0) {
                return new LocalServerResponse(commonConvertResult.getCode(), commonConvertResult.getMessage(), null, 0, 12, null).toJsonString();
            }
            String i16 = a.f444159a.i(b16);
            handleLoadSuccess(d16, i16, globalPadId, z18);
            trackConvertData$default(this, globalPadId, false, Boolean.FALSE, false, 8, null);
            return new LocalServerResponse(0, null, i16, 0, 11, null).toJsonString();
        }
        bVar.d(TAG, "Local_edit loadDocs match cache");
        trackConvertData$default(this, globalPadId, false, Boolean.TRUE, false, 8, null);
        return new LocalServerResponse(0, null, str, 0, 11, null).toJsonString();
    }

    public final synchronized void removePreloadTask(@NotNull String globalPadId) {
        Intrinsics.checkNotNullParameter(globalPadId, "globalPadId");
        b.f446855a.a(TAG, Intrinsics.stringPlus("Local_edit_preload removePreloadTask globalPadId=", globalPadId));
        this.preloadDocsTask.remove(globalPadId);
    }

    public final void trackConvertData(@NotNull String globalPadId, boolean isStart, @Nullable Boolean isUseCache, boolean useChunkImport) {
        Intrinsics.checkNotNullParameter(globalPadId, "globalPadId");
        if (isStart) {
            this.trackerCache.put(globalPadId, new ConvertPerformanceData(Long.valueOf(System.currentTimeMillis()), null, null, false, 14, null));
            return;
        }
        ConvertPerformanceData convertPerformanceData = this.trackerCache.get(globalPadId);
        if (convertPerformanceData != null) {
            convertPerformanceData.setUseCache(isUseCache);
            convertPerformanceData.setConvertEnd(Long.valueOf(System.currentTimeMillis()));
            convertPerformanceData.setUseChunkImport(useChunkImport);
        }
    }

    public final void updateSupportTypeList(@NotNull List<Integer> list) {
        Intrinsics.checkNotNullParameter(list, "list");
        if (!(!list.isEmpty())) {
            list = null;
        }
        if (list != null) {
            this.supportTypeList.clear();
            this.supportTypeList.addAll(list);
        }
    }
}
