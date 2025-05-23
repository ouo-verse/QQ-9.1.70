package com.heytap.databaseengine.utils;

import com.heytap.databaseengine.model.ECGRecord;
import com.heytap.databaseengine.model.HeartRate;
import com.heytap.databaseengine.model.HeartRateDataStat;
import com.heytap.databaseengine.model.OneTimeSportStat;
import com.heytap.databaseengine.model.Sleep;
import com.heytap.databaseengine.model.SportDataDetail;
import com.heytap.databaseengine.model.SportDataStat;
import com.heytap.databaseengine.model.SportHealthData;
import com.heytap.databaseengine.model.SportRecord;
import com.heytap.databaseengine.model.bloodoxygensaturation.BloodOxygenSaturation;
import com.heytap.databaseengine.model.proxy.BloodOxygenSaturationProxy;
import com.heytap.databaseengine.model.proxy.ECGRecordProxy;
import com.heytap.databaseengine.model.proxy.HeartRateDataStatProxy;
import com.heytap.databaseengine.model.proxy.HeartRateProxy;
import com.heytap.databaseengine.model.proxy.OneTimeSportStatProxy;
import com.heytap.databaseengine.model.proxy.SleepProxy;
import com.heytap.databaseengine.model.proxy.SportDataDetailProxy;
import com.heytap.databaseengine.model.proxy.SportDataStatProxy;
import com.heytap.databaseengine.model.proxy.SportDataStatProxyV2;
import com.heytap.databaseengine.model.proxy.SportRecordProxy;
import com.heytap.databaseengine.model.proxy.StressProxy;
import com.heytap.databaseengine.model.proxy.WeightBodyFatProxy;
import com.heytap.databaseengine.model.stress.Stress;
import com.heytap.databaseengine.model.weight.WeightBodyFat;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/* loaded from: classes2.dex */
public class DataParseUtil {
    private static final String TAG = "DataParseUtil";
    public static int version;

    DataParseUtil() {
    }

    public static int convertSportMode(int i3) {
        if (1 > i3 || i3 > 3) {
            if ((5 > i3 || i3 > 10) && i3 != 12 && i3 != 19) {
                if (31 > i3 || i3 > 37) {
                    return 0;
                }
                return i3;
            }
            return i3;
        }
        return i3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ SportDataDetailProxy lambda$parseData$0(SportHealthData sportHealthData) {
        return new SportDataDetailProxy((SportDataDetail) sportHealthData);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ SportDataStatProxy lambda$parseData$1(SportHealthData sportHealthData) {
        if (version <= 1000800) {
            return new SportDataStatProxy((SportDataStat) sportHealthData);
        }
        return new SportDataStatProxyV2((SportDataStat) sportHealthData);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ WeightBodyFatProxy lambda$parseData$10(SportHealthData sportHealthData) {
        return new WeightBodyFatProxy((WeightBodyFat) sportHealthData);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ SportRecordProxy lambda$parseData$2(SportHealthData sportHealthData) {
        return new SportRecordProxy((SportRecord) sportHealthData);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ OneTimeSportStatProxy lambda$parseData$3(SportHealthData sportHealthData) {
        return new OneTimeSportStatProxy((OneTimeSportStat) sportHealthData);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ HeartRateProxy lambda$parseData$4(SportHealthData sportHealthData) {
        return new HeartRateProxy((HeartRate) sportHealthData);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ HeartRateDataStatProxy lambda$parseData$5(SportHealthData sportHealthData) {
        return new HeartRateDataStatProxy((HeartRateDataStat) sportHealthData);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ SleepProxy lambda$parseData$6(SportHealthData sportHealthData) {
        return new SleepProxy((Sleep) sportHealthData);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ ECGRecordProxy lambda$parseData$7(SportHealthData sportHealthData) {
        return new ECGRecordProxy((ECGRecord) sportHealthData);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ BloodOxygenSaturationProxy lambda$parseData$8(SportHealthData sportHealthData) {
        return new BloodOxygenSaturationProxy((BloodOxygenSaturation) sportHealthData);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ StressProxy lambda$parseData$9(SportHealthData sportHealthData) {
        return new StressProxy((Stress) sportHealthData);
    }

    public static List<SportHealthData> parseData(List<SportHealthData> list, int i3) {
        Stream stream;
        Stream map;
        Collector list2;
        Object collect;
        Stream stream2;
        Stream map2;
        Collector list3;
        Object collect2;
        Stream stream3;
        Stream map3;
        Collector list4;
        Object collect3;
        Stream stream4;
        Stream map4;
        Collector list5;
        Object collect4;
        Stream stream5;
        Stream map5;
        Collector list6;
        Object collect5;
        Stream stream6;
        Stream map6;
        Collector list7;
        Object collect6;
        Stream stream7;
        Stream map7;
        Collector list8;
        Object collect7;
        Stream stream8;
        Stream map8;
        Collector list9;
        Object collect8;
        Stream stream9;
        Stream map9;
        Collector list10;
        Object collect9;
        Stream stream10;
        Stream map10;
        Collector list11;
        Object collect10;
        Stream stream11;
        Stream map11;
        Collector list12;
        Object collect11;
        HLog.i(TAG, "type:" + i3);
        if (i3 == 1005) {
            stream = list.stream();
            map = stream.map(new Function() { // from class: com.heytap.databaseengine.utils.k
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    OneTimeSportStatProxy lambda$parseData$3;
                    lambda$parseData$3 = DataParseUtil.lambda$parseData$3((SportHealthData) obj);
                    return lambda$parseData$3;
                }
            });
            list2 = Collectors.toList();
            collect = map.collect(list2);
            return (List) collect;
        }
        if (i3 == 1012) {
            stream2 = list.stream();
            map2 = stream2.map(new Function() { // from class: com.heytap.databaseengine.utils.e
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    ECGRecordProxy lambda$parseData$7;
                    lambda$parseData$7 = DataParseUtil.lambda$parseData$7((SportHealthData) obj);
                    return lambda$parseData$7;
                }
            });
            list3 = Collectors.toList();
            collect2 = map2.collect(list3);
            return (List) collect2;
        }
        if (i3 == 1014) {
            stream3 = list.stream();
            map3 = stream3.map(new Function() { // from class: com.heytap.databaseengine.utils.f
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    BloodOxygenSaturationProxy lambda$parseData$8;
                    lambda$parseData$8 = DataParseUtil.lambda$parseData$8((SportHealthData) obj);
                    return lambda$parseData$8;
                }
            });
            list4 = Collectors.toList();
            collect3 = map3.collect(list4);
            return (List) collect3;
        }
        if (i3 == 1017) {
            stream4 = list.stream();
            map4 = stream4.map(new Function() { // from class: com.heytap.databaseengine.utils.g
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    StressProxy lambda$parseData$9;
                    lambda$parseData$9 = DataParseUtil.lambda$parseData$9((SportHealthData) obj);
                    return lambda$parseData$9;
                }
            });
            list5 = Collectors.toList();
            collect4 = map4.collect(list5);
            return (List) collect4;
        }
        if (i3 != 1021) {
            switch (i3) {
                case 1001:
                    stream6 = list.stream();
                    map6 = stream6.map(new Function() { // from class: com.heytap.databaseengine.utils.l
                        @Override // java.util.function.Function
                        public final Object apply(Object obj) {
                            SportDataDetailProxy lambda$parseData$0;
                            lambda$parseData$0 = DataParseUtil.lambda$parseData$0((SportHealthData) obj);
                            return lambda$parseData$0;
                        }
                    });
                    list7 = Collectors.toList();
                    collect6 = map6.collect(list7);
                    return (List) collect6;
                case 1002:
                    stream7 = list.stream();
                    map7 = stream7.map(new Function() { // from class: com.heytap.databaseengine.utils.i
                        @Override // java.util.function.Function
                        public final Object apply(Object obj) {
                            SportDataStatProxy lambda$parseData$1;
                            lambda$parseData$1 = DataParseUtil.lambda$parseData$1((SportHealthData) obj);
                            return lambda$parseData$1;
                        }
                    });
                    list8 = Collectors.toList();
                    collect7 = map7.collect(list8);
                    return (List) collect7;
                case 1003:
                    stream8 = list.stream();
                    map8 = stream8.map(new Function() { // from class: com.heytap.databaseengine.utils.j
                        @Override // java.util.function.Function
                        public final Object apply(Object obj) {
                            SportRecordProxy lambda$parseData$2;
                            lambda$parseData$2 = DataParseUtil.lambda$parseData$2((SportHealthData) obj);
                            return lambda$parseData$2;
                        }
                    });
                    list9 = Collectors.toList();
                    collect8 = map8.collect(list9);
                    return (List) collect8;
                default:
                    switch (i3) {
                        case 1008:
                            stream9 = list.stream();
                            map9 = stream9.map(new Function() { // from class: com.heytap.databaseengine.utils.m
                                @Override // java.util.function.Function
                                public final Object apply(Object obj) {
                                    HeartRateProxy lambda$parseData$4;
                                    lambda$parseData$4 = DataParseUtil.lambda$parseData$4((SportHealthData) obj);
                                    return lambda$parseData$4;
                                }
                            });
                            list10 = Collectors.toList();
                            collect9 = map9.collect(list10);
                            return (List) collect9;
                        case 1009:
                            stream10 = list.stream();
                            map10 = stream10.map(new Function() { // from class: com.heytap.databaseengine.utils.n
                                @Override // java.util.function.Function
                                public final Object apply(Object obj) {
                                    HeartRateDataStatProxy lambda$parseData$5;
                                    lambda$parseData$5 = DataParseUtil.lambda$parseData$5((SportHealthData) obj);
                                    return lambda$parseData$5;
                                }
                            });
                            list11 = Collectors.toList();
                            collect10 = map10.collect(list11);
                            return (List) collect10;
                        case 1010:
                            stream11 = list.stream();
                            map11 = stream11.map(new Function() { // from class: com.heytap.databaseengine.utils.o
                                @Override // java.util.function.Function
                                public final Object apply(Object obj) {
                                    SleepProxy lambda$parseData$6;
                                    lambda$parseData$6 = DataParseUtil.lambda$parseData$6((SportHealthData) obj);
                                    return lambda$parseData$6;
                                }
                            });
                            list12 = Collectors.toList();
                            collect11 = map11.collect(list12);
                            return (List) collect11;
                        default:
                            return new ArrayList();
                    }
            }
        }
        stream5 = list.stream();
        map5 = stream5.map(new Function() { // from class: com.heytap.databaseengine.utils.h
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                WeightBodyFatProxy lambda$parseData$10;
                lambda$parseData$10 = DataParseUtil.lambda$parseData$10((SportHealthData) obj);
                return lambda$parseData$10;
            }
        });
        list6 = Collectors.toList();
        collect5 = map5.collect(list6);
        return (List) collect5;
    }
}
