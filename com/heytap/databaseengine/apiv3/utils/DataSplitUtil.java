package com.heytap.databaseengine.apiv3.utils;

import com.heytap.databaseengine.apiv3.DataInsertRequest;
import com.heytap.databaseengine.apiv3.data.DataPoint;
import com.heytap.databaseengine.apiv3.data.DataSet;
import com.heytap.databaseengine.apiv3.data.DataType;
import com.heytap.databaseengine.utils.AlertNullOrEmptyUtil;
import com.heytap.databaseengine.utils.HLog;
import com.tencent.component.network.downloader.impl.ipc.Const;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__MutableCollectionsJVMKt;
import kotlin.comparisons.ComparisonsKt__ComparisonsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0004"}, d2 = {"Lcom/heytap/databaseengine/apiv3/utils/DataSplitUtil;", "", "()V", "Companion", "heytap_health_sdk_v2.1.5_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class DataSplitUtil {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private static final int SPLIT_COUNT = 1000;

    @NotNull
    private static final String TAG = "DataSplitAssembleUtil";

    /* compiled from: P */
    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J$\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0002J$\u0010\u000f\u001a\u00020\b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0002J\u0016\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\r2\u0006\u0010\u0012\u001a\u00020\u000eH\u0002J,\u0010\u0013\u001a\u00020\b2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00110\r2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\u0012\u001a\u00020\u000eH\u0002J\u0016\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u000b0\r2\u0006\u0010\u0016\u001a\u00020\u000bH\u0007J$\u0010\u0017\u001a\u00020\b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0018"}, d2 = {"Lcom/heytap/databaseengine/apiv3/utils/DataSplitUtil$Companion;", "", "()V", "SPLIT_COUNT", "", "TAG", "", "addInsertData", "", "requestList", "", "Lcom/heytap/databaseengine/apiv3/DataInsertRequest;", "dataList", "", "Lcom/heytap/databaseengine/apiv3/data/DataSet;", "divideInsertOther", "processPoints", "Lcom/heytap/databaseengine/apiv3/data/DataPoint;", "dataSet", "rebuildSet", "pointList", "splitInsertRequest", Const.BUNDLE_KEY_REQUEST, "splitInsertSportRecord", "heytap_health_sdk_v2.1.5_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    @SourceDebugExtension({"SMAP\nDataSplitUtil.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DataSplitUtil.kt\ncom/heytap/databaseengine/apiv3/utils/DataSplitUtil$Companion\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,143:1\n1855#2,2:144\n1855#2,2:146\n1855#2,2:148\n1002#2,2:150\n*S KotlinDebug\n*F\n+ 1 DataSplitUtil.kt\ncom/heytap/databaseengine/apiv3/utils/DataSplitUtil$Companion\n*L\n50#1:144,2\n61#1:146,2\n115#1:148,2\n125#1:150,2\n*E\n"})
    /* loaded from: classes2.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final void addInsertData(List<DataInsertRequest> requestList, List<? extends DataSet> dataList) {
            DataInsertRequest requestInsert = new DataInsertRequest.Builder().setData(dataList).build();
            Intrinsics.checkNotNullExpressionValue(requestInsert, "requestInsert");
            requestList.add(requestInsert);
        }

        private final void divideInsertOther(List<? extends DataSet> dataList, List<DataInsertRequest> requestList) {
            for (DataSet dataSet : dataList) {
                HLog.i(DataSplitUtil.TAG, "other data points size:" + dataSet.getDataPoints().size());
                List<DataPoint> dataPoints = dataSet.getDataPoints();
                Intrinsics.checkNotNullExpressionValue(dataPoints, "dataSet.dataPoints");
                DataSplitUtil.INSTANCE.rebuildSet(dataPoints, requestList, dataSet);
            }
        }

        private final List<DataPoint> processPoints(DataSet dataSet) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            ArrayList arrayList3 = new ArrayList();
            List<DataPoint> dataPoints = dataSet.getDataPoints();
            Intrinsics.checkNotNullExpressionValue(dataPoints, "dataSet.dataPoints");
            for (DataPoint it : dataPoints) {
                DataType dataType = it.getDataType();
                if (Intrinsics.areEqual(dataType, DataType.TYPE_GYM_STRENGTH_TRAINING)) {
                    Intrinsics.checkNotNullExpressionValue(it, "it");
                    arrayList.add(it);
                } else if (Intrinsics.areEqual(dataType, DataType.TYPE_TRAINING_ACTION)) {
                    Intrinsics.checkNotNullExpressionValue(it, "it");
                    arrayList2.add(it);
                } else if (Intrinsics.areEqual(dataType, DataType.TYPE_HEART_RATE)) {
                    Intrinsics.checkNotNullExpressionValue(it, "it");
                    arrayList3.add(it);
                }
            }
            if (arrayList3.size() > 1) {
                CollectionsKt__MutableCollectionsJVMKt.sortWith(arrayList3, new Comparator() { // from class: com.heytap.databaseengine.apiv3.utils.DataSplitUtil$Companion$processPoints$$inlined$sortBy$1
                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // java.util.Comparator
                    public final int compare(T t16, T t17) {
                        int compareValues;
                        compareValues = ComparisonsKt__ComparisonsKt.compareValues(Long.valueOf(((DataPoint) t16).getTimeStamp()), Long.valueOf(((DataPoint) t17).getTimeStamp()));
                        return compareValues;
                    }
                });
            }
            ArrayList arrayList4 = new ArrayList();
            arrayList4.addAll(arrayList);
            arrayList4.addAll(arrayList2);
            arrayList4.addAll(arrayList3);
            return arrayList4;
        }

        /* JADX WARN: Multi-variable type inference failed */
        private final void rebuildSet(List<? extends DataPoint> pointList, List<DataInsertRequest> requestList, DataSet dataSet) {
            int size = pointList.size();
            int i3 = 0;
            while (i3 < size) {
                int i16 = i3 + 1000;
                if (i16 >= size) {
                    ArrayList arrayList = new ArrayList();
                    DataSet build = DataSet.builder(dataSet.getDataType()).addAll(pointList.subList(i3, size)).build();
                    build.setNeedSplit(0);
                    Intrinsics.checkNotNullExpressionValue(build, "builder(dataSet.dataType\u2026                        }");
                    arrayList.add(build);
                    Unit unit = Unit.INSTANCE;
                    addInsertData(requestList, arrayList);
                } else {
                    ArrayList arrayList2 = new ArrayList();
                    DataSet build2 = DataSet.builder(dataSet.getDataType()).addAll(pointList.subList(i3, i16)).build();
                    build2.setNeedSplit(1);
                    Intrinsics.checkNotNullExpressionValue(build2, "builder(dataSet.dataType\u2026                        }");
                    arrayList2.add(build2);
                    Unit unit2 = Unit.INSTANCE;
                    addInsertData(requestList, arrayList2);
                }
                i3 = i16;
            }
        }

        private final void splitInsertSportRecord(List<? extends DataSet> dataList, List<DataInsertRequest> requestList) {
            for (DataSet dataSet : dataList) {
                HLog.i(DataSplitUtil.TAG, "gym strength training data points size:" + dataSet.getDataPoints().size());
                Companion companion = DataSplitUtil.INSTANCE;
                companion.rebuildSet(companion.processPoints(dataSet), requestList, dataSet);
            }
        }

        @JvmStatic
        @NotNull
        public final List<DataInsertRequest> splitInsertRequest(@NotNull DataInsertRequest request) {
            Intrinsics.checkNotNullParameter(request, "request");
            List<DataSet> data = request.getData();
            Intrinsics.checkNotNullExpressionValue(data, "request.data");
            ArrayList arrayList = new ArrayList();
            if (AlertNullOrEmptyUtil.isNullOrEmpty(data)) {
                HLog.i(DataSplitUtil.TAG, "dataSet is null");
                arrayList.add(request);
                return arrayList;
            }
            DataType dataType = data.get(0).getDataType();
            HLog.i(DataSplitUtil.TAG, "data type is " + dataType.getName());
            if (Intrinsics.areEqual(dataType, DataType.TYPE_GYM_STRENGTH_TRAINING)) {
                splitInsertSportRecord(data, arrayList);
            } else {
                divideInsertOther(data, arrayList);
            }
            return arrayList;
        }

        Companion() {
        }
    }

    @JvmStatic
    @NotNull
    public static final List<DataInsertRequest> splitInsertRequest(@NotNull DataInsertRequest dataInsertRequest) {
        return INSTANCE.splitInsertRequest(dataInsertRequest);
    }
}
