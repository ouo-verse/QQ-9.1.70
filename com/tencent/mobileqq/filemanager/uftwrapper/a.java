package com.tencent.mobileqq.filemanager.uftwrapper;

import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.filemanager.api.IFileUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager;
import com.tencent.mobileqq.troop.utils.api.ITroopBeaconReporter;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.JvmStatic;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0011\u0010\u0012J.\u0010\n\u001a\u00020\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0007J&\u0010\u000b\u001a\u00020\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0006\u001a\u00020\u00042\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0007J0\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00042\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0002R \u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00020\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u000f\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/filemanager/uftwrapper/a;", "", "Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", "ntElemId", "errorCode", "", "errorMsg", "", "c", "b", "", "a", "Ljava/util/concurrent/ConcurrentHashMap;", "Ljava/util/concurrent/ConcurrentHashMap;", "itemMap", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f209110a = new a();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final ConcurrentHashMap<Long, TroopFileTransferManager.Item> itemMap = new ConcurrentHashMap<>();

    a() {
    }

    private final Map<String, String> a(TroopFileTransferManager.Item item, long errorCode, String errorMsg) {
        int i3;
        Map<String, String> mapOf;
        if (item.isFromAIO) {
            i3 = 5;
        } else {
            i3 = 4;
        }
        Pair[] pairArr = new Pair[7];
        boolean z16 = false;
        pairArr[0] = TuplesKt.to("groupCode", String.valueOf(item.troopuin));
        String extension = ((IFileUtil) QRoute.api(IFileUtil.class)).getExtension(item.FileName);
        if (extension == null) {
            extension = "";
        }
        pairArr[1] = TuplesKt.to("fileExtension", extension);
        pairArr[2] = TuplesKt.to("fileSize", String.valueOf(item.ProgressTotal));
        pairArr[3] = TuplesKt.to("fileSource", String.valueOf(i3));
        pairArr[4] = TuplesKt.to("errorCode", String.valueOf(errorCode));
        if (errorCode == 0) {
            z16 = true;
        }
        pairArr[5] = TuplesKt.to("isSucceeded", String.valueOf(z16));
        pairArr[6] = TuplesKt.to("errorMsg", String.valueOf(errorMsg));
        mapOf = MapsKt__MapsKt.mapOf(pairArr);
        return mapOf;
    }

    @JvmStatic
    public static final void b(@Nullable TroopFileTransferManager.Item item, long errorCode, @Nullable String errorMsg) {
        if (item == null) {
            return;
        }
        ((ITroopBeaconReporter) QRoute.api(ITroopBeaconReporter.class)).report("groupFileDownload", f209110a.a(item, errorCode, errorMsg));
    }

    @JvmStatic
    public static final void c(@Nullable TroopFileTransferManager.Item item, long ntElemId, long errorCode, @Nullable String errorMsg) {
        if (errorCode != 0) {
            if (errorCode == -1) {
                if (item != null) {
                    itemMap.put(Long.valueOf(ntElemId), item);
                    return;
                }
                return;
            }
            if (item == null) {
                item = itemMap.get(Long.valueOf(ntElemId));
            }
            itemMap.remove(Long.valueOf(ntElemId));
        }
        if (item == null) {
            return;
        }
        ((ITroopBeaconReporter) QRoute.api(ITroopBeaconReporter.class)).report("groupFileUpload", f209110a.a(item, errorCode, errorMsg));
    }
}
