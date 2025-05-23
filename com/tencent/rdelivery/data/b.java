package com.tencent.rdelivery.data;

import android.text.TextUtils;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.raft.standard.storage.IRStorage;
import com.tencent.raft.standard.task.IRTask;
import com.tencent.rdelivery.RDeliverySetting;
import com.tencent.rdelivery.report.TargetType;
import com.tencent.rdelivery.util.c;
import com.tencent.rdelivery.util.d;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010#\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 62\u00020\u0001:\u00017B+\u0012\u0006\u0010.\u001a\u00020-\u0012\u0006\u00100\u001a\u00020/\u0012\u0006\u00102\u001a\u000201\u0012\n\b\u0002\u00103\u001a\u0004\u0018\u00010-\u00a2\u0006\u0004\b4\u00105J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\"\u0010\n\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016J\u0012\u0010\u000b\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\r\u001a\u00020\fH\u0016J\u001c\u0010\u0010\u001a\u00020\f2\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040\u000eH\u0016J\u0018\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0004H\u0016J\b\u0010\u0013\u001a\u00020\fH\u0016J\b\u0010\u0015\u001a\u00020\u0014H\u0016J\u001c\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00040\u00162\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00040\u0016H\u0016J2\u0010\u001d\u001a\u00020\f2\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00040\u00162\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00040\u00162\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00040\u001bH\u0016J\u001c\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00020\u00162\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00040\u0016H\u0016J\u001c\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040\u001f2\u0006\u0010\t\u001a\u00020\bH\u0016J\u0016\u0010!\u001a\u00020\f2\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00040\u0016H\u0016J\u0011\u0010#\u001a\u0004\u0018\u00010\"H\u0016\u00a2\u0006\u0004\b#\u0010$R\u0016\u0010(\u001a\u00020%8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b&\u0010'R\u001a\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00020)8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b*\u0010+\u00a8\u00068"}, d2 = {"Lcom/tencent/rdelivery/data/b;", "Lcom/tencent/rdelivery/data/DataManager;", "", "key", "Lcom/tencent/rdelivery/data/RDeliveryData;", "V", "Lcom/tencent/rdelivery/report/TargetType;", "targetType", "", "readDiskWhenDataNotInited", "t", "K", "", "J", "Ljava/util/concurrent/ConcurrentHashMap;", "newDataMap", BdhLogUtil.LogTag.Tag_Req, "newData", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "", UserInfo.SEX_FEMALE, "", "datas", ExifInterface.LATITUDE_SOUTH, "remainedDatas", "updatedDatas", "", "deletedDatas", "g", DomainData.DOMAIN_NAME, "", "r", "P", "", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "()Ljava/lang/Long;", "", "o", "I", "localKeyCount", "", "p", "Ljava/util/Set;", "loadedKeySet", "Lcom/tencent/raft/standard/storage/IRStorage;", "dataStorage", "Lcom/tencent/raft/standard/task/IRTask;", "taskInterface", "Lcom/tencent/rdelivery/RDeliverySetting;", "setting", "requestTimeStorage", "<init>", "(Lcom/tencent/raft/standard/storage/IRStorage;Lcom/tencent/raft/standard/task/IRTask;Lcom/tencent/rdelivery/RDeliverySetting;Lcom/tencent/raft/standard/storage/IRStorage;)V", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "a", "rdelivery_nonCommercialRelease"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes25.dex */
public final class b extends DataManager {

    /* renamed from: o, reason: collision with root package name and from kotlin metadata */
    private int localKeyCount;

    /* renamed from: p, reason: collision with root package name and from kotlin metadata */
    private final Set<String> loadedKeySet;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(@NotNull IRStorage dataStorage, @NotNull IRTask taskInterface, @NotNull RDeliverySetting setting, @Nullable IRStorage iRStorage) {
        super(dataStorage, taskInterface, setting, iRStorage);
        Intrinsics.checkParameterIsNotNull(dataStorage, "dataStorage");
        Intrinsics.checkParameterIsNotNull(taskInterface, "taskInterface");
        Intrinsics.checkParameterIsNotNull(setting, "setting");
        this.localKeyCount = -1;
        this.loadedKeySet = new LinkedHashSet();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v3, types: [T, com.tencent.rdelivery.data.RDeliveryData] */
    /* JADX WARN: Type inference failed for: r3v4, types: [T, com.tencent.rdelivery.data.RDeliveryData] */
    /* JADX WARN: Type inference failed for: r3v6, types: [T, com.tencent.rdelivery.data.RDeliveryData] */
    private final RDeliveryData V(String key) {
        RDeliveryData rDeliveryData;
        RDeliveryData rDeliveryData2;
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        synchronized (this) {
            if (this.loadedKeySet.contains(key)) {
                RDeliveryData rDeliveryData3 = w().get(key);
                objectRef.element = rDeliveryData3;
                return rDeliveryData3;
            }
            Unit unit = Unit.INSTANCE;
            objectRef.element = v(key);
            synchronized (this) {
                if (!this.loadedKeySet.contains(key) && (rDeliveryData2 = (RDeliveryData) objectRef.element) != null) {
                    Q(key, rDeliveryData2);
                }
                rDeliveryData = w().get(key);
                objectRef.element = rDeliveryData;
            }
            return rDeliveryData;
        }
    }

    @Override // com.tencent.rdelivery.data.DataManager
    @Nullable
    public Long A() {
        return Long.valueOf(this.localKeyCount);
    }

    @Override // com.tencent.rdelivery.data.DataManager
    public double F() {
        int i3;
        String[] allKeys = getDataStorage().allKeys();
        if (allKeys != null) {
            i3 = allKeys.length;
        } else {
            i3 = 0;
        }
        this.localKeyCount = i3 - 1;
        c logger = getSetting().getLogger();
        if (logger != null) {
            logger.a(d.a("RDelivery_DataManagerLazy", getSetting().getRdInstanceIdentifier()), "loadAllRDeliveryDatasFromDisc localKeyCount = " + this.localKeyCount, getSetting().getEnableDetailLog());
            return -1.0d;
        }
        return -1.0d;
    }

    @Override // com.tencent.rdelivery.data.DataManager
    public void J() {
        String[] allKeys = getDataStorage().allKeys();
        if (allKeys != null) {
            ArrayList arrayList = new ArrayList();
            for (String str : allKeys) {
                if (!Intrinsics.areEqual(str, "mmkv_special_key_for_rdelivery_server_context")) {
                    arrayList.add(str);
                }
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                V((String) it.next());
            }
        }
        super.J();
    }

    @Override // com.tencent.rdelivery.data.DataManager
    @Nullable
    public RDeliveryData K(@NotNull String key) {
        Intrinsics.checkParameterIsNotNull(key, "key");
        V(key);
        return super.K(key);
    }

    @Override // com.tencent.rdelivery.data.DataManager
    public void P(@NotNull List<RDeliveryData> datas) {
        Intrinsics.checkParameterIsNotNull(datas, "datas");
        Iterator<T> it = datas.iterator();
        while (it.hasNext()) {
            V(((RDeliveryData) it.next()).getKey());
        }
        super.P(datas);
    }

    @Override // com.tencent.rdelivery.data.DataManager
    public synchronized void Q(@NotNull String key, @NotNull RDeliveryData newData) {
        Intrinsics.checkParameterIsNotNull(key, "key");
        Intrinsics.checkParameterIsNotNull(newData, "newData");
        w().put(key, newData);
        if (!this.loadedKeySet.contains(key)) {
            this.loadedKeySet.add(key);
        }
    }

    @Override // com.tencent.rdelivery.data.DataManager
    public synchronized void R(@NotNull ConcurrentHashMap<String, RDeliveryData> newDataMap) {
        Set set;
        Intrinsics.checkParameterIsNotNull(newDataMap, "newDataMap");
        this.loadedKeySet.clear();
        N(newDataMap);
        Set<String> set2 = this.loadedKeySet;
        Set<String> keySet = w().keySet();
        Intrinsics.checkExpressionValueIsNotNull(keySet, "dataMap.keys");
        set = CollectionsKt___CollectionsKt.toSet(keySet);
        set2.addAll(set);
    }

    @Override // com.tencent.rdelivery.data.DataManager
    @NotNull
    public List<RDeliveryData> S(@NotNull List<RDeliveryData> datas) {
        int collectionSizeOrDefault;
        boolean z16;
        Intrinsics.checkParameterIsNotNull(datas, "datas");
        boolean X = getSetting().X();
        ArrayList arrayList = new ArrayList();
        for (Object obj : datas) {
            RDeliveryData rDeliveryData = (RDeliveryData) obj;
            if ((X && !TextUtils.isEmpty(rDeliveryData.getHitSubTaskID())) || !X) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                arrayList.add(obj);
            }
        }
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10);
        ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault);
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(((RDeliveryData) it.next()).getKey());
        }
        Iterator it5 = arrayList2.iterator();
        while (it5.hasNext()) {
            V((String) it5.next());
        }
        return super.S(datas);
    }

    @Override // com.tencent.rdelivery.data.DataManager
    public void g(@NotNull List<RDeliveryData> remainedDatas, @NotNull List<RDeliveryData> updatedDatas, @NotNull List<RDeliveryData> deletedDatas) {
        RDeliveryData V;
        Intrinsics.checkParameterIsNotNull(remainedDatas, "remainedDatas");
        Intrinsics.checkParameterIsNotNull(updatedDatas, "updatedDatas");
        Intrinsics.checkParameterIsNotNull(deletedDatas, "deletedDatas");
        if (getSetting().X()) {
            c logger = getSetting().getLogger();
            if (logger != null) {
                logger.a(d.a("RDelivery_DataManagerLazy", getSetting().getRdInstanceIdentifier()), "adjustDeletedDatas start deletedDatas = " + deletedDatas, getSetting().getEnableDetailLog());
            }
            ArrayList arrayList = new ArrayList();
            Iterator<T> it = remainedDatas.iterator();
            while (it.hasNext()) {
                arrayList.add(((RDeliveryData) it.next()).getKey());
            }
            Iterator<T> it5 = updatedDatas.iterator();
            while (it5.hasNext()) {
                arrayList.add(((RDeliveryData) it5.next()).getKey());
            }
            String[] allKeys = getDataStorage().allKeys();
            if (allKeys != null) {
                ArrayList<String> arrayList2 = new ArrayList();
                for (String str : allKeys) {
                    if (!Intrinsics.areEqual(str, "mmkv_special_key_for_rdelivery_server_context")) {
                        arrayList2.add(str);
                    }
                }
                for (String str2 : arrayList2) {
                    if (!arrayList.contains(str2) && (V = V(str2)) != null) {
                        deletedDatas.add(V);
                    }
                }
            }
            c logger2 = getSetting().getLogger();
            if (logger2 != null) {
                logger2.a(d.a("RDelivery_DataManagerLazy", getSetting().getRdInstanceIdentifier()), "adjustDeletedDatas end deletedDatas = " + deletedDatas, getSetting().getEnableDetailLog());
            }
        }
    }

    @Override // com.tencent.rdelivery.data.DataManager
    public synchronized void m() {
        w().clear();
        this.loadedKeySet.clear();
    }

    @Override // com.tencent.rdelivery.data.DataManager
    @NotNull
    public List<String> n(@NotNull List<RDeliveryData> datas) {
        Intrinsics.checkParameterIsNotNull(datas, "datas");
        Iterator<T> it = datas.iterator();
        while (it.hasNext()) {
            V(((RDeliveryData) it.next()).getKey());
        }
        return super.n(datas);
    }

    @Override // com.tencent.rdelivery.data.DataManager
    @NotNull
    public Map<String, RDeliveryData> r(boolean readDiskWhenDataNotInited) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        String[] allKeys = getDataStorage().allKeys();
        if (allKeys != null) {
            ArrayList arrayList = new ArrayList();
            for (String str : allKeys) {
                if (!Intrinsics.areEqual(str, "mmkv_special_key_for_rdelivery_server_context")) {
                    arrayList.add(str);
                }
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                V((String) it.next());
            }
        }
        linkedHashMap.putAll(w());
        return linkedHashMap;
    }

    @Override // com.tencent.rdelivery.data.DataManager
    @Nullable
    public RDeliveryData t(@NotNull String key, @NotNull TargetType targetType, boolean readDiskWhenDataNotInited) {
        Intrinsics.checkParameterIsNotNull(key, "key");
        Intrinsics.checkParameterIsNotNull(targetType, "targetType");
        RDeliveryData B = getSetting().B(key, V(key));
        I(key, B);
        return B;
    }
}
