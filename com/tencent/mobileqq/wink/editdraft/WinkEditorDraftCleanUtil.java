package com.tencent.mobileqq.wink.editdraft;

import androidx.annotation.WorkerThread;
import com.tencent.mobileqq.app.QMMKVFile;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qmmkv.MMKVOptionEntity;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.predownload.schedule.PreDownloadConstants;
import com.tencent.mobileqq.wink.edit.util.AECameraPrefsUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b*\u0010+J\"\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0010\u0010\u0005\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010\u0004H\u0002J \u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u000e\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0004H\u0003J\u0010\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u000e\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\fH\u0003J\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u000f\u001a\u00020\u0002H\u0002J\u001e\u0010\u0014\u001a\u00020\u00132\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0002H\u0002J\u0010\u0010\u0016\u001a\u00020\u00062\b\u0010\u0015\u001a\u0004\u0018\u00010\u0002J\u0018\u0010\u0017\u001a\u00020\u00062\u0010\u0010\u0015\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010\u0004J\u0006\u0010\u0018\u001a\u00020\u0006J\u0006\u0010\u0019\u001a\u00020\u0006R\u0017\u0010\u001e\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u0017\u0010 \u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u001b\u001a\u0004\b\u001f\u0010\u001dR \u0010#\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\b0!8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\"R \u0010$\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\f0!8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\"R\u001b\u0010)\u001a\u00020%8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0016\u0010&\u001a\u0004\b'\u0010(\u00a8\u0006,"}, d2 = {"Lcom/tencent/mobileqq/wink/editdraft/WinkEditorDraftCleanUtil;", "", "", PreDownloadConstants.RPORT_KEY_BUSINESS_NAME, "", "missionIds", "", "e", "Lcom/tencent/mobileqq/wink/editdraft/WinkEditorDraftDeleteStrategy;", "deleteStrategy", "d", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/wink/editdraft/d;", "batchDeleteStrategy", "c", "input", h.F, "usableMissionIds", "key", "", "l", "missionId", "f", "g", DomainData.DOMAIN_NAME, "o", "b", "Ljava/lang/String;", "j", "()Ljava/lang/String;", "KEY_WINK_COMPRESS_MISSION", "k", "KEY_WINK_EXPORT_MISSION", "", "Ljava/util/Map;", "deleteStrategyMap", "batchDeleteStrategyMap", "Lcom/tencent/mobileqq/qmmkv/MMKVOptionEntity;", "Lkotlin/Lazy;", "i", "()Lcom/tencent/mobileqq/qmmkv/MMKVOptionEntity;", "entity", "<init>", "()V", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class WinkEditorDraftCleanUtil {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final WinkEditorDraftCleanUtil f318495a = new WinkEditorDraftCleanUtil();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final String KEY_WINK_COMPRESS_MISSION = AECameraPrefsUtil.f318476n + "_";

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final String KEY_WINK_EXPORT_MISSION = AECameraPrefsUtil.f318475m + "_";

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Map<String, WinkEditorDraftDeleteStrategy> deleteStrategyMap;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Map<String, d> batchDeleteStrategyMap;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy entity;

    static {
        Map<String, WinkEditorDraftDeleteStrategy> mapOf;
        Map<String, d> mapOf2;
        Lazy lazy;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to("QCIRCLE", new b()), TuplesKt.to("QZONE", new c()));
        deleteStrategyMap = mapOf;
        mapOf2 = MapsKt__MapsKt.mapOf(TuplesKt.to("QCIRCLE", new a()), TuplesKt.to("QZONE", new QZoneWEDBatchDeleteStrategy()));
        batchDeleteStrategyMap = mapOf2;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<MMKVOptionEntity>() { // from class: com.tencent.mobileqq.wink.editdraft.WinkEditorDraftCleanUtil$entity$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final MMKVOptionEntity invoke() {
                return QMMKV.from(MobileQQ.sMobileQQ, QMMKVFile.FILE_QCIRCLE);
            }
        });
        entity = lazy;
    }

    WinkEditorDraftCleanUtil() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:39:0x015c A[Catch: all -> 0x0213, TryCatch #0 {, blocks: (B:3:0x0001, B:5:0x0013, B:9:0x0036, B:11:0x0047, B:14:0x0061, B:15:0x00b6, B:17:0x00bc, B:20:0x00ca, B:25:0x00ce, B:27:0x00f5, B:29:0x00fe, B:31:0x0107, B:35:0x0149, B:39:0x015c, B:41:0x015f, B:44:0x0117, B:45:0x011b, B:47:0x0121, B:55:0x0167, B:56:0x0184, B:58:0x018a, B:60:0x019a), top: B:2:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x015f A[SYNTHETIC] */
    @WorkerThread
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final synchronized void c(d batchDeleteStrategy) {
        List<String> distinct;
        String[] strArr;
        List<String> list;
        boolean z16;
        boolean z17;
        boolean startsWith$default;
        boolean z18;
        long j3 = i().totalSize();
        int i3 = batchDeleteStrategy.i();
        if (j3 < i3) {
            QLog.e("WinkEditorDraftCleanUtil", 1, "batchDeleteDraft, size less than threshold, size:" + j3 + ", threshold:" + i3);
            return;
        }
        long k3 = batchDeleteStrategy.k();
        if (System.currentTimeMillis() - k3 < batchDeleteStrategy.h()) {
            QLog.e("WinkEditorDraftCleanUtil", 1, "batchDeleteDraft, has cleaned, lastTime:" + k3);
            return;
        }
        long actualSize = i().actualSize();
        long count = i().count();
        QLog.d("WinkEditorDraftCleanUtil", 1, "batchDeleteDraft, start, size:" + j3 + ", actualSize:" + actualSize + ", count:" + count);
        String[] allKeyArr = i().allKeyArr();
        List<String> j16 = batchDeleteStrategy.j();
        List<String> m3 = batchDeleteStrategy.m();
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = m3.iterator();
        while (it.hasNext()) {
            String h16 = f318495a.h((String) it.next());
            if (h16 != null) {
                arrayList.add(h16);
            }
        }
        distinct = CollectionsKt___CollectionsKt.distinct(arrayList);
        QLog.d("WinkEditorDraftCleanUtil", 1, "batchDeleteDraft, keyPrefixList:" + j16 + ", usableMissionIds:" + distinct);
        if (allKeyArr != null) {
            ArrayList arrayList2 = new ArrayList();
            int length = allKeyArr.length;
            int i16 = 0;
            while (i16 < length) {
                String key = allKeyArr[i16];
                List<String> list2 = j16;
                if ((list2 instanceof Collection) && list2.isEmpty()) {
                    strArr = allKeyArr;
                    list = j16;
                    z16 = false;
                    z17 = false;
                } else {
                    Iterator<T> it5 = list2.iterator();
                    while (true) {
                        if (it5.hasNext()) {
                            String str = (String) it5.next();
                            Intrinsics.checkNotNullExpressionValue(key, "key");
                            strArr = allKeyArr;
                            list = j16;
                            z16 = false;
                            startsWith$default = StringsKt__StringsJVMKt.startsWith$default(key, str, false, 2, null);
                            if (startsWith$default) {
                                z17 = true;
                                break;
                            } else {
                                allKeyArr = strArr;
                                j16 = list;
                            }
                        } else {
                            strArr = allKeyArr;
                            list = j16;
                            z16 = false;
                            z17 = false;
                            break;
                        }
                    }
                }
                if (z17) {
                    WinkEditorDraftCleanUtil winkEditorDraftCleanUtil = f318495a;
                    Intrinsics.checkNotNullExpressionValue(key, "key");
                    if (!winkEditorDraftCleanUtil.l(distinct, key)) {
                        z18 = true;
                        if (!z18) {
                            arrayList2.add(key);
                        }
                        i16++;
                        allKeyArr = strArr;
                        j16 = list;
                    }
                }
                z18 = z16;
                if (!z18) {
                }
                i16++;
                allKeyArr = strArr;
                j16 = list;
            }
            QLog.d("WinkEditorDraftCleanUtil", 1, "batchDeleteDraft, delete keys:" + arrayList2);
            Iterator it6 = arrayList2.iterator();
            while (it6.hasNext()) {
                f318495a.i().removeKey((String) it6.next());
            }
        }
        i().trim();
        long j17 = i().totalSize();
        long actualSize2 = i().actualSize();
        long count2 = i().count();
        g.f318523a.a(new WinkEditorDraftReportData(0, batchDeleteStrategy.a(), j3, actualSize, count, j17, actualSize2, count2));
        batchDeleteStrategy.n();
        QLog.d("WinkEditorDraftCleanUtil", 1, "batchDeleteDraft, end, size:" + j17 + ", actualSize:" + actualSize2 + ", count:" + count2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @WorkerThread
    public final synchronized void d(WinkEditorDraftDeleteStrategy deleteStrategy, List<String> missionIds) {
        int collectionSizeOrDefault;
        ArrayList<String> arrayList = new ArrayList();
        Iterator<T> it = missionIds.iterator();
        while (true) {
            boolean z16 = false;
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            String str = (String) next;
            if (str == null || str.length() == 0) {
                z16 = true;
            }
            if (!z16) {
                arrayList.add(next);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        for (String str2 : arrayList) {
            List<String> d16 = deleteStrategy.d();
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(d16, 10);
            ArrayList arrayList3 = new ArrayList(collectionSizeOrDefault);
            for (String str3 : d16) {
                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                String format = String.format(str3, Arrays.copyOf(new Object[]{str2}, 1));
                Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
                arrayList3.add(format);
            }
            CollectionsKt__MutableCollectionsKt.addAll(arrayList2, arrayList3);
        }
        QLog.d("WinkEditorDraftCleanUtil", 1, "deleteDraft, delete keys:" + arrayList2);
        g.f318523a.b(deleteStrategy.a(), arrayList2);
        Iterator it5 = arrayList2.iterator();
        while (it5.hasNext()) {
            f318495a.i().removeKey((String) it5.next());
        }
    }

    private final void e(String businessName, List<String> missionIds) {
        boolean z16;
        WinkEditorDraftDeleteStrategy winkEditorDraftDeleteStrategy = deleteStrategyMap.get(businessName);
        if (winkEditorDraftDeleteStrategy == null) {
            QLog.e("WinkEditorDraftCleanUtil", 1, "deleteDraft, deleteStrategy is null, businessName:" + businessName + " ");
            return;
        }
        if (!winkEditorDraftDeleteStrategy.g()) {
            QLog.e("WinkEditorDraftCleanUtil", 1, "deleteDraft, config is not enable, businessName:" + businessName + " ");
            return;
        }
        List<String> list = missionIds;
        if (list != null && !list.isEmpty()) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            QLog.e("WinkEditorDraftCleanUtil", 1, "deleteDraft, missionIds is null or empty, businessName:" + businessName + " ");
            return;
        }
        QLog.d("WinkEditorDraftCleanUtil", 1, "deleteDraft, businessName:" + businessName + ", missionIds: " + missionIds);
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new WinkEditorDraftCleanUtil$deleteDraft$1(winkEditorDraftDeleteStrategy, missionIds, null), 3, null);
    }

    private final String h(String input) {
        MatchResult find$default = Regex.find$default(new Regex("[0-9a-fA-F]{8}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{12}"), input, 0, 2, null);
        if (find$default == null) {
            return null;
        }
        return find$default.getValue();
    }

    private final MMKVOptionEntity i() {
        return (MMKVOptionEntity) entity.getValue();
    }

    private final boolean l(List<String> usableMissionIds, String key) {
        boolean contains$default;
        List<String> list = usableMissionIds;
        if ((list instanceof Collection) && list.isEmpty()) {
            return false;
        }
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            contains$default = StringsKt__StringsKt.contains$default((CharSequence) key, (CharSequence) it.next(), false, 2, (Object) null);
            if (contains$default) {
                return true;
            }
        }
        return false;
    }

    private final void m(String businessName) {
        d dVar = batchDeleteStrategyMap.get(businessName);
        if (dVar == null) {
            QLog.e("WinkEditorDraftCleanUtil", 1, "tryBatchDeleteDraft, batchDeleteStrategy is null, businessName:" + businessName);
            return;
        }
        if (!dVar.g()) {
            QLog.e("WinkEditorDraftCleanUtil", 1, "tryBatchDeleteDraft, config is not enable, businessName:" + businessName);
            return;
        }
        QLog.d("WinkEditorDraftCleanUtil", 1, "tryBatchDeleteDraft, businessName:" + businessName);
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new WinkEditorDraftCleanUtil$tryBatchDeleteDraft$1(dVar, businessName, null), 3, null);
    }

    public final void f(@Nullable String missionId) {
        List<String> listOf;
        listOf = CollectionsKt__CollectionsJVMKt.listOf(missionId);
        e("QCIRCLE", listOf);
    }

    public final void g(@Nullable List<String> missionId) {
        e("QZONE", missionId);
    }

    @NotNull
    public final String j() {
        return KEY_WINK_COMPRESS_MISSION;
    }

    @NotNull
    public final String k() {
        return KEY_WINK_EXPORT_MISSION;
    }

    public final void n() {
        m("QCIRCLE");
    }

    public final void o() {
        m("QZONE");
    }
}
