package com.heytap.databaseengine.utils;

import android.os.RemoteException;
import android.util.SparseArray;
import com.heytap.databaseengine.callback.IDataReadResultListener;
import com.heytap.databaseengine.constant.HealthDataKey;
import com.heytap.databaseengine.model.HealthOriginData;
import com.heytap.databaseengine.model.OneTimeSport;
import com.heytap.databaseengine.model.SportHealthData;
import com.heytap.databaseengine.option.DataInsertOption;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes2.dex */
public class DataDivideUtil {
    public static final int DIVIDE_INSERT_HEALTH_ORIGIN_MAX = 2;
    public static final int DIVIDE_INSERT_MAX = 300;
    public static final int DIVIDE_READ_BIG_DATA_RETURN_MAX = 50;
    public static final int DIVIDE_READ_HR_NEW_CARD_RETURN_MAX = 2;
    public static final int DIVIDE_READ_RETURN_MAX = 300;
    public static final int DIVIDE_READ_RUNNING = 0;
    public static final int DIVIDE_TRACK_LENGTH_INSERT = 262144;
    public static final int DIVIDE_TRACK_LENGTH_READ = 262144;
    public static final int READ_ALL_OVER = 2;
    public static final int READ_PART_OVER = 1;
    public static final int READ_POINT_PART = 3;
    public static final int READ_SET_PART = 4;
    private static final String TAG = "DataDivideUtil";
    private static boolean isParse = false;

    private static void addInsertData(List<DataInsertOption> list, SportHealthData sportHealthData, int i3) {
        OneTimeSport oneTimeSport = (OneTimeSport) sportHealthData;
        HLog.i(TAG, String.format("divideInsertTrack addInsertData is dividing:%s, sportMode:%s, startTime:%s, endTime:%s", Boolean.valueOf(oneTimeSport.getBoolean(HealthDataKey.IS_DIVIDING)), Integer.valueOf(oneTimeSport.getSportMode()), Long.valueOf(sportHealthData.getStartTimestamp()), Long.valueOf(sportHealthData.getEndTimestamp())));
        ArrayList arrayList = new ArrayList();
        arrayList.add(((OneTimeSport) sportHealthData).copyData());
        DataInsertOption dataInsertOption = new DataInsertOption();
        dataInsertOption.setDatas(arrayList);
        dataInsertOption.setDataTable(i3);
        list.add(dataInsertOption);
    }

    private static void addSparseArray(SparseArray<List<SportHealthData>> sparseArray, List<SportHealthData> list, int i3) {
        sparseArray.append(i3, new ArrayList(list));
        list.clear();
    }

    public static void divideBigDataList(int i3, List<?> list, IDataReadResultListener iDataReadResultListener) throws RemoteException {
        if (iDataReadResultListener == null) {
            HLog.w(TAG, "divideBigDataList listener is  null, table is " + i3);
            return;
        }
        if (AlertNullOrEmptyUtil.isNullOrEmpty(list)) {
            HLog.w(TAG, "divideList list is null or empty, table is " + i3);
            iDataReadResultListener.onResult(null, i3, 1);
            return;
        }
        int size = list.size();
        int i16 = 0;
        while (i16 < size) {
            int i17 = i16 + 50;
            if (i17 >= size) {
                if (isParse) {
                    iDataReadResultListener.onResult(DataParseUtil.parseData(list.subList(i16, size), i3), i3, 1);
                } else {
                    iDataReadResultListener.onResult(list.subList(i16, size), i3, 1);
                }
            } else if (isParse) {
                iDataReadResultListener.onResult(DataParseUtil.parseData(list.subList(i16, i17), i3), i3, 0);
            } else {
                iDataReadResultListener.onResult(list.subList(i16, i17), i3, 0);
            }
            i16 = i17;
        }
    }

    public static void divideHRNewCardList(int i3, List<?> list, IDataReadResultListener iDataReadResultListener) throws RemoteException {
        if (iDataReadResultListener == null) {
            HLog.w(TAG, "divideHRNewCardList listener is  null, table is " + i3);
            return;
        }
        if (AlertNullOrEmptyUtil.isNullOrEmpty(list)) {
            HLog.w(TAG, "divideList list is null or empty, table is " + i3);
            iDataReadResultListener.onResult(null, i3, 1);
            return;
        }
        int size = list.size();
        int i16 = 0;
        while (i16 < size) {
            int i17 = i16 + 2;
            if (i17 >= size) {
                iDataReadResultListener.onResult(list.subList(i16, size), i3, 1);
            } else {
                iDataReadResultListener.onResult(list.subList(i16, i17), i3, 0);
            }
            i16 = i17;
        }
    }

    public static void divideHealthOriginList(int i3, List<HealthOriginData> list, IDataReadResultListener iDataReadResultListener) throws RemoteException {
        if (iDataReadResultListener == null) {
            HLog.w(TAG, "divideHealthOriginList listener is  null, table is " + i3);
            return;
        }
        if (AlertNullOrEmptyUtil.isNullOrEmpty(list)) {
            HLog.w(TAG, "divideList list is null or empty, table is " + i3);
            iDataReadResultListener.onResult(null, i3, 1);
            return;
        }
        for (HealthOriginData healthOriginData : list) {
            String data = healthOriginData.getData();
            if (data != null && data.length() > 0) {
                try {
                    healthOriginData.setData(ZipUtil.uncompress(data));
                } catch (Exception e16) {
                    HLog.w(TAG, "divideHealthOriginList uncompress e = " + e16.getMessage() + ", type = " + healthOriginData.getDataType());
                }
            }
        }
        int size = list.size();
        int i16 = 0;
        while (i16 < size) {
            int i17 = i16 + 2;
            if (i17 >= size) {
                iDataReadResultListener.onResult(list.subList(i16, size), i3, 1);
            } else {
                iDataReadResultListener.onResult(list.subList(i16, i17), i3, 0);
            }
            i16 = i17;
        }
    }

    private static void divideInsertHealthOriginData(List<SportHealthData> list, List<DataInsertOption> list2, int i3) {
        int i16;
        Iterator<SportHealthData> it = list.iterator();
        String str = "";
        while (true) {
            i16 = 0;
            if (!it.hasNext()) {
                break;
            }
            SportHealthData next = it.next();
            try {
                HLog.d(TAG, String.format("divideInsertHealthOriginData health original data:%s", ((HealthOriginData) next).getData()));
                HLog.i(TAG, String.format("divideInsertHealthOriginData health original length:%s", Integer.valueOf(((HealthOriginData) next).getData().length())));
                str = ZipUtil.compress(((HealthOriginData) next).getData());
                ((HealthOriginData) next).setData(str);
            } catch (IOException e16) {
                HLog.e(TAG, "divideInsertHealthOriginData e = " + e16.getMessage());
            }
            int length = str.length();
            HLog.d(TAG, String.format("divideInsertHealthOriginData compress data:%s", str));
            HLog.i(TAG, String.format("divideInsertHealthOriginData compress length:%s", Integer.valueOf(length)));
        }
        int size = list.size();
        while (i16 < size) {
            int i17 = i16 + 2;
            if (i17 >= size) {
                addInsertData(list2, list.subList(i16, size), i3);
            } else {
                addInsertData(list2, list.subList(i16, i17), i3);
            }
            i16 = i17;
        }
    }

    public static List<DataInsertOption> divideInsertOption(DataInsertOption dataInsertOption) {
        List<SportHealthData> datas = dataInsertOption.getDatas();
        ArrayList arrayList = new ArrayList();
        int dataTable = dataInsertOption.getDataTable();
        if (AlertNullOrEmptyUtil.isNullOrEmpty(datas)) {
            arrayList.add(dataInsertOption);
            return arrayList;
        }
        SportHealthData sportHealthData = datas.get(0);
        if (sportHealthData instanceof OneTimeSport) {
            if (!AlertNullOrEmptyUtil.isNullOrEmpty(((OneTimeSport) sportHealthData).getData())) {
                divideInsertTrack(datas, arrayList, dataTable);
            } else {
                divideInsertOther(datas, arrayList, dataTable);
            }
        } else if (dataTable == 1016) {
            divideInsertHealthOriginData(datas, arrayList, dataTable);
        } else {
            divideInsertOther(datas, arrayList, dataTable);
        }
        return arrayList;
    }

    private static void divideInsertOther(List<SportHealthData> list, List<DataInsertOption> list2, int i3) {
        int size = list.size();
        int i16 = 0;
        while (i16 < size) {
            int i17 = i16 + 300;
            if (i17 >= size) {
                addInsertData(list2, list.subList(i16, size), i3);
            } else {
                addInsertData(list2, list.subList(i16, i17), i3);
            }
            i16 = i17;
        }
    }

    private static void divideInsertTrack(List<SportHealthData> list, List<DataInsertOption> list2, int i3) {
        String str = "";
        for (SportHealthData sportHealthData : list) {
            try {
                HLog.d(TAG, String.format("divideInsertTrack track original data:%s", ((OneTimeSport) sportHealthData).getData()));
                HLog.i(TAG, String.format("divideInsertTrack track original length:%s", Integer.valueOf(((OneTimeSport) sportHealthData).getData().length())));
                str = ZipUtil.compress(((OneTimeSport) sportHealthData).getData());
            } catch (IOException e16) {
                HLog.e(TAG, "divideInsertTrack e = " + e16.getMessage());
            }
            int length = str.length();
            HLog.d(TAG, String.format("divideInsertTrack compress data:%s", str));
            HLog.i(TAG, String.format("divideInsertTrack compress length:%s", Integer.valueOf(length)));
            OneTimeSport oneTimeSport = (OneTimeSport) sportHealthData;
            oneTimeSport.putBoolean(HealthDataKey.TRACK_IS_ZIP, true);
            if (length <= 0) {
                addInsertData(list2, sportHealthData, i3);
            } else {
                int i16 = 0;
                while (i16 < length) {
                    int i17 = 262144 + i16;
                    if (i17 >= length) {
                        oneTimeSport.setData(str.substring(i16, length));
                        oneTimeSport.putBoolean(HealthDataKey.IS_DIVIDING, false);
                    } else {
                        oneTimeSport.setData(str.substring(i16, i17));
                        oneTimeSport.putBoolean(HealthDataKey.IS_DIVIDING, true);
                    }
                    addInsertData(list2, sportHealthData, i3);
                    HLog.i(TAG, String.format("divideInsertTrack index:%s", Integer.valueOf(i17)));
                    i16 = i17;
                }
            }
        }
    }

    public static void divideList(int i3, List<?> list, IDataReadResultListener iDataReadResultListener) throws RemoteException {
        if (iDataReadResultListener == null) {
            HLog.w(TAG, "divideList listener is  null, table is " + i3);
            return;
        }
        if (AlertNullOrEmptyUtil.isNullOrEmpty(list)) {
            HLog.w(TAG, "divideList list is null or empty, table is " + i3);
            iDataReadResultListener.onResult(null, i3, 1);
            return;
        }
        int size = list.size();
        int i16 = 0;
        while (i16 < size) {
            int i17 = i16 + 300;
            if (i17 >= size) {
                if (isParse) {
                    iDataReadResultListener.onResult(DataParseUtil.parseData(list.subList(i16, size), i3), i3, 1);
                } else {
                    iDataReadResultListener.onResult(list.subList(i16, size), i3, 1);
                }
            } else if (isParse) {
                iDataReadResultListener.onResult(DataParseUtil.parseData(list.subList(i16, i17), i3), i3, 0);
            } else {
                iDataReadResultListener.onResult(list.subList(i16, i17), i3, 0);
            }
            i16 = i17;
        }
    }

    public static void divideTrackData(int i3, List<?> list, IDataReadResultListener iDataReadResultListener) throws RemoteException {
        if (iDataReadResultListener == null) {
            HLog.w(TAG, "divideTrackData listener is  null, table is " + i3);
            return;
        }
        if (AlertNullOrEmptyUtil.isNullOrEmpty(list)) {
            HLog.w(TAG, "divideTrackData list is null or empty");
            iDataReadResultListener.onResult(null, i3, 1);
            return;
        }
        OneTimeSport oneTimeSport = (OneTimeSport) list.get(0);
        if (oneTimeSport == null) {
            HLog.w(TAG, "divideTrackData data is null");
            return;
        }
        String data = oneTimeSport.getData();
        HLog.d(TAG, String.format("divideInsertTrack compress data:%s", data));
        if (AlertNullOrEmptyUtil.isNullOrEmpty(data)) {
            divideList(i3, list, iDataReadResultListener);
            return;
        }
        int length = data.length();
        HLog.i(TAG, String.format("divideInsertTrack compress length:%s", Integer.valueOf(data.length())));
        if (length <= 0) {
            iDataReadResultListener.onResult(null, i3, 1);
            return;
        }
        int i16 = 0;
        while (i16 < length) {
            int i17 = 262144 + i16;
            if (i17 >= length) {
                oneTimeSport.setData(data.substring(i16, length));
                ArrayList arrayList = new ArrayList();
                arrayList.add(oneTimeSport);
                iDataReadResultListener.onResult(arrayList, i3, 1);
            } else {
                oneTimeSport.setData(data.substring(i16, i17));
                ArrayList arrayList2 = new ArrayList();
                arrayList2.add(oneTimeSport);
                iDataReadResultListener.onResult(arrayList2, i3, 0);
            }
            i16 = i17;
        }
    }

    public static boolean isParse() {
        return isParse;
    }

    public static boolean packDivideReadData(List<SportHealthData> list, int i3, int i16, List<SportHealthData> list2, SparseArray<List<SportHealthData>> sparseArray) {
        if (i3 == 1004) {
            packageDivideTrackData(list, i3, i16, list2, sparseArray);
            return false;
        }
        return packageDivideData(list, i3, i16, list2, sparseArray);
    }

    private static boolean packageDivideData(List<SportHealthData> list, int i3, int i16, List<SportHealthData> list2, SparseArray<List<SportHealthData>> sparseArray) {
        if (!AlertNullOrEmptyUtil.isNullOrEmpty(list)) {
            list2.addAll(list);
        }
        if (i16 == 1) {
            if (AlertNullOrEmptyUtil.isNullOrEmpty(list2)) {
                HLog.w(TAG, "packageDivideData() partData is null");
                return false;
            }
            addSparseArray(sparseArray, list2, i3);
            return false;
        }
        if (i16 == 2) {
            return true;
        }
        return false;
    }

    private static void packageDivideTrackData(List<SportHealthData> list, int i3, int i16, List<SportHealthData> list2, SparseArray<List<SportHealthData>> sparseArray) {
        OneTimeSport oneTimeSport;
        String str;
        if (!AlertNullOrEmptyUtil.isNullOrEmpty(list2)) {
            oneTimeSport = (OneTimeSport) list2.get(0);
            str = oneTimeSport.getData();
        } else {
            oneTimeSport = null;
            str = null;
        }
        if (!AlertNullOrEmptyUtil.isNullOrEmpty(list)) {
            if (oneTimeSport == null) {
                oneTimeSport = (OneTimeSport) list.get(0);
                list2.add(oneTimeSport);
            } else {
                str = str + ((OneTimeSport) list.get(0)).getData();
                oneTimeSport.setData(str);
            }
        }
        if (oneTimeSport == null) {
            HLog.w(TAG, "packageTrackDivide data is null");
            return;
        }
        if (i16 != 1 || AlertNullOrEmptyUtil.isNullOrEmpty(list2)) {
            return;
        }
        try {
            str = ZipUtil.uncompress(oneTimeSport.getData());
        } catch (Exception unused) {
            HLog.e(TAG, "packageDivideTrackData zip exception, track_data = " + str);
        }
        oneTimeSport.setData(str);
        addSparseArray(sparseArray, list2, i3);
    }

    public static void setParse(boolean z16) {
        isParse = z16;
    }

    private static void addInsertData(List<DataInsertOption> list, List<SportHealthData> list2, int i3) {
        DataInsertOption dataInsertOption = new DataInsertOption();
        dataInsertOption.setDatas(list2);
        dataInsertOption.setDataTable(i3);
        list.add(dataInsertOption);
    }
}
