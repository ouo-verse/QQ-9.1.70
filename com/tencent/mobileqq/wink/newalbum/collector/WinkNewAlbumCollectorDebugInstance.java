package com.tencent.mobileqq.wink.newalbum.collector;

import android.os.Handler;
import androidx.exifinterface.media.ExifInterface;
import com.google.gson.Gson;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.wink.newalbum.processor.WinkNewAlbumContext;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.thread.RFWThreadManager;
import cooperation.photoplus.sticker.Sticker;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.io.CloseableKt;
import kotlin.io.FilesKt__FileReadWriteKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0014\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0010%\n\u0002\b\u0003\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\bP\u0010QJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u001e\u0010\f\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00060\nH\u0002J\u0010\u0010\r\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0016\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00060\n2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0006\u0010\u000f\u001a\u00020\bJ\u000e\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0010J\u001e\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u0015J\u001e\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u0015J\u0006\u0010\u0019\u001a\u00020\bJ\u0006\u0010\u001a\u001a\u00020\bJ\u0006\u0010\u001b\u001a\u00020\bJ\u001c\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00060\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u001cJ\u000e\u0010!\u001a\u00020\b2\u0006\u0010 \u001a\u00020\u001fJ\u0016\u0010%\u001a\u00020\b2\u0006\u0010#\u001a\u00020\"2\u0006\u0010$\u001a\u00020\u0004J\u0010\u0010&\u001a\u00020\b2\b\u0010$\u001a\u0004\u0018\u00010\u0004J\u000e\u0010(\u001a\u00020\b2\u0006\u0010'\u001a\u00020\u0010J\u000e\u0010)\u001a\u00020\b2\u0006\u0010'\u001a\u00020\u0010J\u0006\u0010*\u001a\u00020\u0004J\u0006\u0010+\u001a\u00020\bR$\u00101\u001a\u00020\u001c2\u0006\u0010,\u001a\u00020\u001c8\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b-\u0010.\u001a\u0004\b/\u00100R$\u00103\u001a\u00020\u001c2\u0006\u0010,\u001a\u00020\u001c8\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b\u0017\u0010.\u001a\u0004\b2\u00100R\u0014\u00105\u001a\u00020\u001c8\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b4\u0010.R\u0014\u00108\u001a\u0002068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0018\u00107R\"\u0010?\u001a\u0002098\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010:\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>R\"\u0010B\u001a\u0002098\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010:\u001a\u0004\b@\u0010<\"\u0004\bA\u0010>R\"\u0010E\u001a\u0002098\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000f\u0010:\u001a\u0004\bC\u0010<\"\u0004\bD\u0010>R\"\u0010I\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u001c0F8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bG\u0010HR(\u0010K\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060J0F8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b+\u0010HR\u001c\u0010O\u001a\n M*\u0004\u0018\u00010L0L8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010N\u00a8\u0006R"}, d2 = {"Lcom/tencent/mobileqq/wink/newalbum/collector/WinkNewAlbumCollectorDebugInstance;", "", "", "g", "", "storyID", "Lcom/tencent/mobileqq/wink/newalbum/collector/e;", "unStoredContext", "", "f", "", "unStoredContexts", BdhLogUtil.LogTag.Tag_Conn, "p", "r", tl.h.F, "Lcom/tencent/mobileqq/wink/newalbum/collector/WinkNewMemoryAlbumResult;", "searchedResult", "o", "Lcom/tencent/mobileqq/wink/newalbum/processor/d;", "context", "", "textSimilarity", "c", "e", "k", "y", "l", "", "loop", ReportConstant.COSTREPORT_PREFIX, "Lcom/tencent/mobileqq/wink/newalbum/collector/b;", "configInfo", "t", "", "feature", "desc", "v", "u", "memoryAlbumResult", "w", HippyTKDListViewAdapter.X, DomainData.DOMAIN_NAME, "j", "<set-?>", "b", "I", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "()I", "currentLoop", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "totalCount", "d", "writeThreshold", "Ljava/util/concurrent/locks/ReentrantReadWriteLock;", "Ljava/util/concurrent/locks/ReentrantReadWriteLock;", "rwLock", "", "J", "getScanCost", "()J", "B", "(J)V", "scanCost", "getForwardCost", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "forwardCost", "getCollectCost", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "collectCost", "", "i", "Ljava/util/Map;", "selectContextMap", "", "unStoredRecordDict", "Landroid/os/Handler;", "kotlin.jvm.PlatformType", "Landroid/os/Handler;", "debugTaskHandler", "<init>", "()V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class WinkNewAlbumCollectorDebugInstance {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static int currentLoop;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static int totalCount;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private static long scanCost;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private static long forwardCost;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private static long collectCost;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final WinkNewAlbumCollectorDebugInstance f324014a = new WinkNewAlbumCollectorDebugInstance();

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private static final int writeThreshold = 10;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final ReentrantReadWriteLock rwLock = new ReentrantReadWriteLock();

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static Map<String, Integer> selectContextMap = new LinkedHashMap();

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static Map<String, List<WinkNewAlbumCollectorDebugUnStoredContext>> unStoredRecordDict = new LinkedHashMap();

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    private static final Handler debugTaskHandler = RFWThreadManager.createNewThreadHandler("WinkNewAlbumCollectorProcessorThread", 0);

    WinkNewAlbumCollectorDebugInstance() {
    }

    private final void C(String storyID, List<WinkNewAlbumCollectorDebugUnStoredContext> unStoredContexts) {
        rwLock.writeLock().lock();
        File file = new File(p(storyID));
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
            Gson gson = new Gson();
            Iterator<WinkNewAlbumCollectorDebugUnStoredContext> it = unStoredContexts.iterator();
            while (it.hasNext()) {
                String json = gson.toJson(it.next());
                FileWriter fileWriter = new FileWriter(file, true);
                try {
                    fileWriter.append((CharSequence) json);
                    Intrinsics.checkNotNullExpressionValue(fileWriter.append('\n'), "append('\\n')");
                    CloseableKt.closeFinally(fileWriter, null);
                } finally {
                }
            }
        } catch (IOException e16) {
            e16.printStackTrace();
        }
        rwLock.writeLock().unlock();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(String storyID, WinkNewAlbumCollectorDebugUnStoredContext unStoredContext) {
        Intrinsics.checkNotNullParameter(storyID, "$storyID");
        Intrinsics.checkNotNullParameter(unStoredContext, "$unStoredContext");
        f324014a.f(storyID, unStoredContext);
    }

    private final void f(String storyID, WinkNewAlbumCollectorDebugUnStoredContext unStoredContext) {
        List<WinkNewAlbumCollectorDebugUnStoredContext> list = unStoredRecordDict.get(storyID);
        if (list == null) {
            list = CollectionsKt__CollectionsKt.mutableListOf(unStoredContext);
            unStoredRecordDict.put(storyID, list);
        } else {
            list.add(unStoredContext);
        }
        if (list.size() >= writeThreshold) {
            C(storyID, list);
            unStoredRecordDict.put(storyID, new ArrayList());
        }
    }

    private final boolean g() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i() {
        unStoredRecordDict = new LinkedHashMap();
        File file = new File(r83.a.f430945a.a());
        if (file.exists()) {
            File[] files = file.listFiles();
            Intrinsics.checkNotNullExpressionValue(files, "files");
            for (File file2 : files) {
                if (!file2.isDirectory()) {
                    file2.delete();
                }
            }
            return;
        }
        file.mkdirs();
    }

    private final String p(String storyID) {
        r83.a aVar = r83.a.f430945a;
        File file = new File(aVar.a());
        if (!file.exists()) {
            file.mkdirs();
        }
        return aVar.a() + storyID + Sticker.JSON_SUFFIX;
    }

    private final List<WinkNewAlbumCollectorDebugUnStoredContext> r(String storyID) {
        ReentrantReadWriteLock reentrantReadWriteLock = rwLock;
        reentrantReadWriteLock.readLock().lock();
        final ArrayList arrayList = new ArrayList();
        try {
            File file = new File(p(storyID));
            final Gson gson = new Gson();
            FilesKt__FileReadWriteKt.forEachLine$default(file, null, new Function1<String, Unit>() { // from class: com.tencent.mobileqq.wink.newalbum.collector.WinkNewAlbumCollectorDebugInstance$getUnStoredContextInFile$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(String str) {
                    invoke2(str);
                    return Unit.INSTANCE;
                }

                /* JADX WARN: Multi-variable type inference failed */
                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull String line) {
                    Intrinsics.checkNotNullParameter(line, "line");
                    List<WinkNewAlbumCollectorDebugUnStoredContext> list = arrayList;
                    Object fromJson = gson.fromJson(line, (Class<Object>) WinkNewAlbumCollectorDebugUnStoredContext.class);
                    Intrinsics.checkNotNullExpressionValue(fromJson, "gson.fromJson(line, Wink\u2026toredContext::class.java)");
                    list.add(fromJson);
                }
            }, 1, null);
            reentrantReadWriteLock.readLock().unlock();
        } catch (Exception e16) {
            QLog.e("WinkNewAlbumCollectorDebugInstance", 1, "error occurred, read story " + storyID + " exception, exception desc: " + e16);
        }
        return arrayList;
    }

    public final void A(long j3) {
        forwardCost = j3;
    }

    public final void B(long j3) {
        scanCost = j3;
    }

    public final void c(@NotNull WinkNewAlbumContext context, @NotNull final String storyID, float textSimilarity) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(storyID, "storyID");
        if (g()) {
            return;
        }
        z83.a metaData = context.getMetaData();
        QLog.i("WinkNewAlbumCollectorDebugInstance", 1, "album similarity:" + textSimilarity + ", aestheticScore:" + context.getAestheticScore() + ", not confirmed story id:" + storyID + ", image path:" + metaData.getPath());
        final WinkNewAlbumCollectorDebugUnStoredContext winkNewAlbumCollectorDebugUnStoredContext = new WinkNewAlbumCollectorDebugUnStoredContext(metaData.getId(), metaData.getPath(), textSimilarity, metaData.D(), metaData.getMediaType(), metaData.getTimestamp(), currentLoop);
        debugTaskHandler.post(new Runnable() { // from class: com.tencent.mobileqq.wink.newalbum.collector.d
            @Override // java.lang.Runnable
            public final void run() {
                WinkNewAlbumCollectorDebugInstance.d(storyID, winkNewAlbumCollectorDebugUnStoredContext);
            }
        });
    }

    public final void e(@NotNull WinkNewAlbumContext context, @NotNull String storyID, float textSimilarity) {
        int i3;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(storyID, "storyID");
        if (g()) {
            return;
        }
        z83.a metaData = context.getMetaData();
        Integer num = selectContextMap.get(storyID);
        if (num != null) {
            i3 = num.intValue();
        } else {
            i3 = 0;
        }
        selectContextMap.put(storyID, Integer.valueOf(i3 + 1));
        QLog.i("WinkNewAlbumCollectorDebugInstance", 1, "album similarity:" + textSimilarity + ", aestheticScore:" + context.getAestheticScore() + ", confirmed story id:" + storyID + ", image path:" + metaData.getPath());
    }

    public final void h() {
        if (g()) {
            return;
        }
        currentLoop = 0;
        totalCount = 0;
        Handler handler = debugTaskHandler;
        handler.removeCallbacksAndMessages(null);
        handler.post(new Runnable() { // from class: com.tencent.mobileqq.wink.newalbum.collector.c
            @Override // java.lang.Runnable
            public final void run() {
                WinkNewAlbumCollectorDebugInstance.i();
            }
        });
    }

    public final void j() {
        collectCost = 0L;
    }

    public final void k() {
        if (g()) {
            return;
        }
        int i3 = currentLoop + 1;
        currentLoop = i3;
        QLog.d("WinkNewAlbumCollectorDebugInstance", 1, "collect current loop is " + i3);
    }

    public final void l() {
        String joinToString$default;
        if (g()) {
            return;
        }
        try {
            currentLoop++;
            for (Map.Entry<String, List<WinkNewAlbumCollectorDebugUnStoredContext>> entry : unStoredRecordDict.entrySet()) {
                f324014a.C(entry.getKey(), entry.getValue());
            }
        } catch (Exception e16) {
            QLog.e("WinkNewAlbumCollectorDebugInstance", 1, e16, new Object[0]);
        }
        QLog.d("WinkNewAlbumCollectorDebugInstance", 1, "finish all collect loop is " + currentLoop);
        Map<String, Integer> map = selectContextMap;
        ArrayList arrayList = new ArrayList(map.size());
        for (Map.Entry<String, Integer> entry2 : map.entrySet()) {
            arrayList.add(entry2.getKey() + ContainerUtils.KEY_VALUE_DELIMITER + entry2.getValue().intValue());
        }
        joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(arrayList, ", ", null, null, 0, null, null, 62, null);
        QLog.d("WinkNewAlbumCollectorDebugInstance", 1, "selectContext:" + joinToString$default);
        m mVar = m.f324110a;
        QLog.d("WinkNewAlbumCollectorDebugInstance", 1, "finish all collect, highScoreCount:" + mVar.b() + ", lowScoreCount:" + mVar.c());
    }

    public final int m() {
        return currentLoop;
    }

    @NotNull
    public final String n() {
        if (g()) {
            return "";
        }
        long j3 = collectCost;
        if (j3 == 0) {
            return " \u805a\u7c7b\u4e2d";
        }
        return " \u7167\u7247\u6570\u91cf\uff1a" + totalCount + " \n \u626b\u63cf\u8017\u65f6\uff1a" + scanCost + " \n \u63a8\u7406\u8017\u65f6\uff1a" + forwardCost + " \n \u805a\u7c7b\u8017\u65f6\uff1a" + j3;
    }

    @NotNull
    public final WinkNewMemoryAlbumResult o(@NotNull WinkNewMemoryAlbumResult searchedResult) {
        Intrinsics.checkNotNullParameter(searchedResult, "searchedResult");
        if (g()) {
            return searchedResult;
        }
        searchedResult.y(searchedResult.j());
        searchedResult.z(searchedResult.i());
        searchedResult.C(currentLoop);
        return searchedResult;
    }

    public final int q() {
        return totalCount;
    }

    @NotNull
    public final List<WinkNewAlbumCollectorDebugUnStoredContext> s(@NotNull String storyID, int loop) {
        List<WinkNewAlbumCollectorDebugUnStoredContext> emptyList;
        Intrinsics.checkNotNullParameter(storyID, "storyID");
        if (g()) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            return emptyList;
        }
        ArrayList arrayList = new ArrayList();
        for (WinkNewAlbumCollectorDebugUnStoredContext winkNewAlbumCollectorDebugUnStoredContext : r(storyID)) {
            if (winkNewAlbumCollectorDebugUnStoredContext.getCollectorLoop() == loop) {
                arrayList.add(winkNewAlbumCollectorDebugUnStoredContext);
            }
        }
        return arrayList;
    }

    public final void t(@NotNull WinkNewAlbumCollectorConfigInfo configInfo) {
        Intrinsics.checkNotNullParameter(configInfo, "configInfo");
        if (g()) {
            return;
        }
        v(configInfo.getFeatureConfigInfo().getTextFeature(), "config storyID: " + configInfo.getStoryID() + ", priorityIndex: " + configInfo.getPriorityIndex() + ", storyName: " + configInfo.getAlbumConfigInfo().getStoryName() + ", threshold: " + configInfo.getAlbumConfigInfo().getThreshold());
    }

    public final void u(@Nullable String desc) {
        if (g()) {
            return;
        }
        QLog.d("WinkNewAlbumCollectorDebugInstance", 1, desc);
    }

    public final void v(@NotNull float[] feature, @NotNull String desc) {
        Intrinsics.checkNotNullParameter(feature, "feature");
        Intrinsics.checkNotNullParameter(desc, "desc");
        if (g()) {
            return;
        }
        int length = feature.length;
        float f16 = 0.0f;
        float f17 = -100.0f;
        float f18 = 100.0f;
        for (int i3 = 0; i3 < length; i3++) {
            float f19 = feature[i3];
            f16 += f19;
            f17 = (float) Math.max(f19, f17);
            f18 = (float) Math.min(feature[i3], f18);
        }
        QLog.d("WinkNewAlbumCollectorDebugInstance", 1, "feature desc: " + desc + " | Sum: " + f16 + ", Max: " + f17 + ", Min: " + f18);
    }

    public final void w(@NotNull WinkNewMemoryAlbumResult memoryAlbumResult) {
        Intrinsics.checkNotNullParameter(memoryAlbumResult, "memoryAlbumResult");
        if (g()) {
            return;
        }
        x(memoryAlbumResult);
        List<com.tencent.mobileqq.wink.newalbum.database.a> j3 = memoryAlbumResult.j();
        List<z83.a> i3 = memoryAlbumResult.i();
        if (j3.size() != i3.size()) {
            QLog.d("WinkNewAlbumCollectorDebugInstance", 1, "size is not equal, albumDBModelList size: " + j3.size() + ", photoList size: " + i3.size());
            return;
        }
        int size = j3.size();
        for (int i16 = 0; i16 < size; i16++) {
            com.tencent.mobileqq.wink.newalbum.database.a aVar = j3.get(i16);
            z83.a aVar2 = i3.get(i16);
            String str = aVar2.getYear() + " year " + aVar2.getMonth() + " month " + aVar2.getDayOfMonth() + " day";
            QLog.d("WinkNewAlbumCollectorDebugInstance", 1, "id: " + aVar.getPhotoID() + ", simi: " + aVar.getSimilarity() + ", photo time: " + str + ", path: " + aVar2.getPath());
        }
    }

    public final void x(@NotNull WinkNewMemoryAlbumResult memoryAlbumResult) {
        Intrinsics.checkNotNullParameter(memoryAlbumResult, "memoryAlbumResult");
        if (g()) {
            return;
        }
        QLog.d("WinkNewAlbumCollectorDebugInstance", 1, "has searched story: " + memoryAlbumResult.getCom.tencent.aelight.camera.constants.AEEditorConstants.ALBUMNAME java.lang.String() + ", collect size: " + memoryAlbumResult.j().size() + ", album id: " + memoryAlbumResult.getAlbumID());
    }

    public final void y() {
        if (g()) {
            return;
        }
        totalCount++;
    }

    public final void z(long j3) {
        collectCost = j3;
    }
}
