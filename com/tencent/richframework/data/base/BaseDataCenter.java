package com.tencent.richframework.data.base;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.tencent.biz.richframework.delegate.impl.RFWApplication;
import com.tencent.biz.richframework.delegate.impl.RFWConfig;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.richframework.data.base.converter.BoolDataConverter;
import com.tencent.richframework.data.base.converter.LongDataConverter;
import com.tencent.richframework.data.base.converter.StringDataConverter;
import com.tencent.richframework.data.idata.IDataConverter;
import com.tencent.richframework.data.idata.IDataDisplaySurface;
import com.tencent.richframework.data.idata.IDataStore;
import com.tencent.richframework.data.idata.IDataWeakSupport;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes25.dex */
public abstract class BaseDataCenter {
    protected static final Map<Class, IDataConverter> COMMON_CONVERTERS;
    protected final Map<String, IDataStore> mAllDataStore = new ConcurrentHashMap();
    private final Map<Class, BaseDataWorker> mAllDataWorkers = new HashMap();
    protected final Map<String, Map<String, WeakReference<IDataDisplaySurface>>> mAllDisplaySurface = new ConcurrentHashMap();
    protected final Map<Class, IDataConverter> mAllDataConverters = new ConcurrentHashMap();
    protected final Map<String, DataObserverWrapper> mObserverWrapperMap = new ConcurrentHashMap();
    protected final Map<DataObserverWrapper, MutableLiveData> mObserverWrapperToLiveData = new ConcurrentHashMap();
    protected final Map<String, MutableLiveData> mAllGlobalStateData = new ConcurrentHashMap();
    protected final Handler mUIHandler = new Handler(Looper.getMainLooper());

    /* compiled from: P */
    /* renamed from: com.tencent.richframework.data.base.BaseDataCenter$6, reason: invalid class name */
    /* loaded from: classes25.dex */
    class AnonymousClass6 implements Runnable {
        final /* synthetic */ BaseDataCenter this$0;
        final /* synthetic */ List val$sources;

        @Override // java.lang.Runnable
        public void run() {
            List<Object> asList;
            BaseDataCenter baseDataCenter = this.this$0;
            List list = this.val$sources;
            if (list == null) {
                asList = null;
            } else {
                asList = Arrays.asList(list.toArray());
            }
            baseDataCenter.clearAllGlobalStateDataByKeys(asList);
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.richframework.data.base.BaseDataCenter$7, reason: invalid class name */
    /* loaded from: classes25.dex */
    class AnonymousClass7 implements Runnable {
        final /* synthetic */ BaseDataCenter this$0;
        final /* synthetic */ List val$sources;

        @Override // java.lang.Runnable
        public void run() {
            this.this$0.clearObserverWrapper(this.val$sources);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes25.dex */
    public static class DataObserverWrapperImpl<S> extends DataObserverWrapper<S> {
        private final WeakReference<S> mCurrentDataWeak;
        private final WeakReference<IDataConverter<S>> mDataConverterWeak;

        public DataObserverWrapperImpl(Observer observer, S s16, IDataConverter<S> iDataConverter) {
            super(observer);
            this.mCurrentDataWeak = new WeakReference<>(s16);
            this.mDataConverterWeak = new WeakReference<>(iDataConverter);
        }

        @Override // com.tencent.richframework.data.base.DataObserverWrapper, androidx.lifecycle.Observer
        public void onChanged(S s16) {
            S s17 = this.mCurrentDataWeak.get();
            IDataConverter<S> iDataConverter = this.mDataConverterWeak.get();
            if (s17 != null && iDataConverter != null) {
                iDataConverter.update(s17, s16);
            }
            super.onChanged(s16);
        }
    }

    static {
        HashMap hashMap = new HashMap();
        COMMON_CONVERTERS = hashMap;
        hashMap.put(Boolean.class, new BoolDataConverter());
        hashMap.put(String.class, new StringDataConverter());
        hashMap.put(Long.class, new LongDataConverter());
    }

    protected static boolean checkObserverIsValidClass(Observer observer) {
        if (!observer.getClass().isAnonymousClass()) {
            return true;
        }
        throwRuntimeExceptionIfPossible("observe not support anonymousClass :" + observer.getClass().getName());
        return false;
    }

    private <S> void clearAllGlobalStateDataByKey(S s16) {
        String currentObjKey = getCurrentObjKey(s16);
        if (TextUtils.isEmpty(currentObjKey)) {
            return;
        }
        this.mAllGlobalStateData.remove(getGlobalObjKey(s16.getClass(), currentObjKey));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public <S> void clearObserverWrapper(List<S> list) {
        if (list != null && !list.isEmpty()) {
            Iterator<S> it = list.iterator();
            while (it.hasNext()) {
                clearObserverWrapperByKey(it.next());
            }
        }
    }

    private <S> void clearObserverWrapperByKey(S s16) {
        DataObserverWrapper dataObserverWrapper;
        String currentObjKey = getCurrentObjKey(s16);
        if (!TextUtils.isEmpty(currentObjKey) && (dataObserverWrapper = this.mObserverWrapperMap.get(currentObjKey)) != null) {
            this.mObserverWrapperToLiveData.remove(dataObserverWrapper);
            this.mObserverWrapperMap.remove(currentObjKey);
            this.mAllGlobalStateData.remove(currentObjKey);
        }
    }

    private void executeOnUIHandler(Runnable runnable) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            runnable.run();
        } else {
            this.mUIHandler.post(runnable);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public <S> MutableLiveData<S> generateLiveData(Class cls) {
        IDataConverter<S> dataConverter = getDataConverter(cls);
        if (!isWeakDataConverter(dataConverter)) {
            return new MutableLiveData<>();
        }
        if (((IDataWeakSupport) dataConverter).isSupportWeakData()) {
            return new WeakMutableLiveData();
        }
        return new MutableLiveData<>();
    }

    @NonNull
    private Map<String, WeakReference<IDataDisplaySurface>> getAllDataSurfaceWithType(@NonNull Class cls) {
        return getAllDataSurfaceWithTypeName(cls.getName());
    }

    @NonNull
    private Map<String, WeakReference<IDataDisplaySurface>> getAllDataSurfaceWithTypeName(String str) {
        Map<String, WeakReference<IDataDisplaySurface>> map = this.mAllDisplaySurface.get(str);
        if (map == null) {
            ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
            this.mAllDisplaySurface.put(str, concurrentHashMap);
            return concurrentHashMap;
        }
        return map;
    }

    @Nullable
    private <S> String getCurrentObjKey(S s16) {
        if (s16 == null) {
            return null;
        }
        String observerKey = getDataConverter(s16.getClass()).getObserverKey(s16);
        if (TextUtils.isEmpty(observerKey)) {
            return null;
        }
        return getGlobalObjKey(s16.getClass(), observerKey);
    }

    @NonNull
    private <S> IDataConverter<S> getDataConverter(Class<S> cls) {
        IDataConverter iDataConverter = this.mAllDataConverters.get(cls);
        if (iDataConverter == null) {
            iDataConverter = COMMON_CONVERTERS.get(cls);
        }
        if (iDataConverter == null) {
            throwRuntimeExceptionIfPossible(String.format("can't not find Class implements IDataConverter<%s> register in data center", cls.getName()));
            return null;
        }
        return iDataConverter;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isWeakDataConverter(IDataConverter iDataConverter) {
        return iDataConverter instanceof IDataWeakSupport;
    }

    private static void throwRuntimeExceptionIfPossible(String str) {
        if (!RFWApplication.isDebug()) {
            RFWLog.e("BaseDataCenter", RFWLog.USR, "[throwRuntimeExceptionIfPossible]" + str);
            return;
        }
        throw new BaseDataCenterRuntimeException(str);
    }

    public <D> void addData(String str, D d16) {
        IDataStore iDataStore = this.mAllDataStore.get(str);
        if (iDataStore != null) {
            iDataStore.addData(d16);
        }
    }

    public void addDataConverter(@NonNull IDataConverter iDataConverter) {
        this.mAllDataConverters.put(getDataConverterKey(iDataConverter), iDataConverter);
    }

    public void addDataStore(@NonNull String str, @NonNull IDataStore iDataStore) {
        this.mAllDataStore.put(str, iDataStore);
    }

    public void addDataWorker(BaseDataWorker baseDataWorker) {
        if (baseDataWorker == null) {
            return;
        }
        baseDataWorker.registerWorkDataCenter(this);
        this.mAllDataWorkers.put(baseDataWorker.getClass(), baseDataWorker);
    }

    public void clearAll() {
        this.mAllDataStore.clear();
        this.mAllDataWorkers.clear();
        this.mAllDataConverters.clear();
        clearAllData();
    }

    public void clearAllData() {
        this.mAllDisplaySurface.clear();
        this.mAllGlobalStateData.clear();
        this.mObserverWrapperMap.clear();
        this.mObserverWrapperToLiveData.clear();
    }

    public void clearAllGlobalStateDataByKeys(List<Object> list) {
        if (list != null && !list.isEmpty()) {
            Iterator<Object> it = list.iterator();
            while (it.hasNext()) {
                clearAllGlobalStateDataByKey(it.next());
            }
        }
    }

    public <S> Collection<S> fillDuplicateData(Class<S> cls, Collection<S> collection) {
        IDataConverter<S> dataConverter = getDataConverter(cls);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (S s16 : collection) {
            if (s16 != null) {
                String dataKey = getDataKey(dataConverter, s16);
                if (!linkedHashMap.containsKey(dataKey)) {
                    linkedHashMap.put(dataKey, s16);
                }
            }
        }
        return linkedHashMap.values();
    }

    public Map<String, IDataStore> getAllDataStore() {
        return this.mAllDataStore;
    }

    public <T> Collection<IDataDisplaySurface<T>> getAllDisplaySurface(Class<T> cls) {
        ArrayList arrayList = new ArrayList();
        Iterator<WeakReference<IDataDisplaySurface>> it = getAllDataSurfaceWithType(cls).values().iterator();
        while (it.hasNext()) {
            IDataDisplaySurface iDataDisplaySurface = it.next().get();
            if (iDataDisplaySurface != null) {
                arrayList.add(iDataDisplaySurface);
            }
        }
        return arrayList;
    }

    @Nullable
    public <D> D getData(String str, String str2) {
        IDataStore iDataStore = this.mAllDataStore.get(str);
        if (iDataStore != null) {
            return (D) iDataStore.getData(str2);
        }
        return null;
    }

    public Class getDataConverterKey(@NonNull IDataConverter iDataConverter) {
        Class parameterizedTypeRealClass = DataClassUtil.getParameterizedTypeRealClass(iDataConverter.getClass(), IDataConverter.class);
        if (parameterizedTypeRealClass == null) {
            throwRuntimeExceptionIfPossible("get dataConverter paramClass error");
        }
        return parameterizedTypeRealClass;
    }

    protected <S> String getDataKey(IDataConverter<S> iDataConverter, S s16) {
        String observerKey = iDataConverter.getObserverKey(s16);
        if (TextUtils.isEmpty(observerKey)) {
            return String.valueOf(s16.hashCode());
        }
        return observerKey;
    }

    public <T extends BaseDataWorker> T getDataWorker(Class<T> cls) {
        if (this.mAllDataWorkers.get(cls) != null) {
            return (T) this.mAllDataWorkers.get(cls);
        }
        return null;
    }

    public <T> IDataDisplaySurface<T> getDisplaySurface(Class<T> cls, String str) {
        WeakReference<IDataDisplaySurface> weakReference;
        IDataDisplaySurface<T> iDataDisplaySurface;
        if (TextUtils.isEmpty(str) || (weakReference = getAllDataSurfaceWithType(cls).get(str)) == null || (iDataDisplaySurface = weakReference.get()) == null) {
            return null;
        }
        return iDataDisplaySurface;
    }

    public <S> MutableLiveData<S> getGlobalData(Class<S> cls, String str) {
        MutableLiveData<S> mutableLiveData = this.mAllGlobalStateData.get(getGlobalObjKey(cls, str));
        if (mutableLiveData == null) {
            MutableLiveData<S> generateLiveData = generateLiveData(cls);
            this.mAllGlobalStateData.put(getGlobalObjKey(cls, str), generateLiveData);
            return generateLiveData;
        }
        return mutableLiveData;
    }

    protected String getGlobalObjKey(Class cls, String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        return cls.getName() + str;
    }

    protected <S> String getObserverWrapperKey(@NonNull IDataConverter<S> iDataConverter, @NonNull Observer<S> observer) {
        return getDataConverterKey(iDataConverter).getName() + observer.hashCode();
    }

    public <S> Collection<S> getUniqueData(Class<S> cls, Collection<S> collection, Collection<S> collection2) {
        IDataConverter<S> dataConverter = getDataConverter(cls);
        HashMap hashMap = new HashMap();
        ArrayList arrayList = new ArrayList();
        for (S s16 : collection) {
            if (s16 != null) {
                hashMap.put(getDataKey(dataConverter, s16), s16);
            }
        }
        for (S s17 : collection2) {
            String dataKey = getDataKey(dataConverter, s17);
            if (!hashMap.containsKey(dataKey)) {
                arrayList.add(s17);
                hashMap.put(dataKey, s17);
            }
        }
        return arrayList;
    }

    public <S> void initOrUpdateGlobalState(List<S> list, boolean z16) {
        if (list == null) {
            return;
        }
        Iterator<S> it = list.iterator();
        while (it.hasNext()) {
            initOrUpdateGlobalState((BaseDataCenter) it.next(), z16);
        }
    }

    public <S> void observerGlobalState(Class<S> cls, String str, Observer<S> observer) {
        IDataConverter<S> dataConverter = getDataConverter(cls);
        String globalObjKey = getGlobalObjKey(cls, str);
        MutableLiveData mutableLiveData = this.mAllGlobalStateData.get(globalObjKey);
        if (mutableLiveData == null) {
            mutableLiveData = generateLiveData(cls);
            this.mAllGlobalStateData.put(globalObjKey, mutableLiveData);
        }
        observerGlobalStateInner(dataConverter, mutableLiveData, null, observer);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public <S> void observerGlobalStateInner(final IDataConverter<S> iDataConverter, final MutableLiveData<S> mutableLiveData, final S s16, Observer<S> observer) {
        final DataObserverWrapper dataObserverWrapper;
        if (checkObserverIsValidClass(observer) && iDataConverter != null && mutableLiveData != null) {
            DataObserverWrapper dataObserverWrapper2 = this.mObserverWrapperMap.get(getObserverWrapperKey(iDataConverter, observer));
            if (dataObserverWrapper2 != null) {
                MutableLiveData mutableLiveData2 = this.mObserverWrapperToLiveData.get(dataObserverWrapper2);
                if (mutableLiveData2 == mutableLiveData) {
                    return;
                }
                if (mutableLiveData2 != null) {
                    mutableLiveData2.removeObserver(dataObserverWrapper2);
                    this.mObserverWrapperMap.remove(getObserverWrapperKey(iDataConverter, observer));
                    this.mObserverWrapperToLiveData.remove(dataObserverWrapper2);
                }
            }
            if (RFWConfig.getConfigValue("enable_data_center_observer_weak_reference", true)) {
                dataObserverWrapper = new DataObserverWrapperImpl(observer, s16, iDataConverter);
            } else {
                dataObserverWrapper = new DataObserverWrapper<S>(observer) { // from class: com.tencent.richframework.data.base.BaseDataCenter.4
                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // com.tencent.richframework.data.base.DataObserverWrapper, androidx.lifecycle.Observer
                    public void onChanged(S s17) {
                        Object obj = s16;
                        if (obj != null) {
                            iDataConverter.update(obj, s17);
                        }
                        super.onChanged(s17);
                    }
                };
            }
            this.mObserverWrapperMap.put(getObserverWrapperKey(iDataConverter, observer), dataObserverWrapper);
            this.mObserverWrapperToLiveData.put(dataObserverWrapper, mutableLiveData);
            executeOnUIHandler(new Runnable() { // from class: com.tencent.richframework.data.base.BaseDataCenter.5
                @Override // java.lang.Runnable
                public void run() {
                    mutableLiveData.observeForever(dataObserverWrapper);
                }
            });
        }
    }

    public <T> void registerDisplaySurface(String str, IDataDisplaySurface<T> iDataDisplaySurface) {
        if (!TextUtils.isEmpty(str) && iDataDisplaySurface != null) {
            Class parameterizedTypeRealClass = DataClassUtil.getParameterizedTypeRealClass(iDataDisplaySurface.getClass(), IDataDisplaySurface.class);
            if (parameterizedTypeRealClass == null) {
                throwRuntimeExceptionIfPossible("get displaySurface implement param class error");
                return;
            }
            Map<String, WeakReference<IDataDisplaySurface>> allDataSurfaceWithTypeName = getAllDataSurfaceWithTypeName(parameterizedTypeRealClass.getName());
            allDataSurfaceWithTypeName.put(str, new WeakReference<>(iDataDisplaySurface));
            this.mAllDisplaySurface.put(str, allDataSurfaceWithTypeName);
            return;
        }
        throwRuntimeExceptionIfPossible("can't register displaySurface with empty key or null object");
    }

    public void removeDataByKey(String str, String str2) {
        IDataStore iDataStore = this.mAllDataStore.get(str);
        if (iDataStore != null) {
            iDataStore.removeDataByKey(str2);
        }
    }

    public <S> void removeObserverGlobalState(S s16, Observer<S> observer) {
        MutableLiveData remove;
        if (observer != null && checkObserverIsValidClass(observer) && s16 != null) {
            DataObserverWrapper remove2 = this.mObserverWrapperMap.remove(getObserverWrapperKey(getDataConverter(s16.getClass()), observer));
            if (remove2 != null && (remove = this.mObserverWrapperToLiveData.remove(remove2)) != null) {
                remove.removeObserver(remove2);
            }
        }
    }

    protected <S> void setValueInMainThread(final MutableLiveData<S> mutableLiveData, final S s16) {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            mutableLiveData.setValue(s16);
        } else {
            this.mUIHandler.post(new Runnable() { // from class: com.tencent.richframework.data.base.BaseDataCenter.3
                @Override // java.lang.Runnable
                public void run() {
                    mutableLiveData.setValue(s16);
                }
            });
        }
    }

    public void updateState(String str, final Object obj) {
        if (obj == null) {
            return;
        }
        final String globalObjKey = getGlobalObjKey(obj.getClass(), str);
        this.mUIHandler.post(new Runnable() { // from class: com.tencent.richframework.data.base.BaseDataCenter.2
            @Override // java.lang.Runnable
            public void run() {
                MutableLiveData mutableLiveData = BaseDataCenter.this.mAllGlobalStateData.get(globalObjKey);
                if (mutableLiveData == null) {
                    MutableLiveData generateLiveData = BaseDataCenter.this.generateLiveData(obj.getClass());
                    generateLiveData.setValue(obj);
                    BaseDataCenter.this.mAllGlobalStateData.put(globalObjKey, generateLiveData);
                } else {
                    if (!obj.equals(mutableLiveData.getValue())) {
                        mutableLiveData.setValue(obj);
                    }
                }
            }
        });
    }

    public <S> void initOrUpdateGlobalState(final S s16, final boolean z16) {
        if (s16 == null) {
            return;
        }
        final Class<?> cls = s16.getClass();
        final IDataConverter<S> dataConverter = getDataConverter(cls);
        if (TextUtils.isEmpty(dataConverter.getObserverKey(s16))) {
            throwRuntimeExceptionIfPossible("must define observer key");
        } else {
            final String globalObjKey = getGlobalObjKey(cls, dataConverter.getObserverKey(s16));
            this.mUIHandler.post(new Runnable() { // from class: com.tencent.richframework.data.base.BaseDataCenter.1
                @Override // java.lang.Runnable
                public void run() {
                    MutableLiveData mutableLiveData = BaseDataCenter.this.mAllGlobalStateData.get(globalObjKey);
                    if (mutableLiveData == null) {
                        MutableLiveData generateLiveData = BaseDataCenter.this.generateLiveData(cls);
                        generateLiveData.setValue(dataConverter.cloneConvertData(s16));
                        BaseDataCenter.this.mAllGlobalStateData.put(globalObjKey, generateLiveData);
                        return;
                    }
                    Object value = mutableLiveData.getValue();
                    if (value != null && !BaseDataCenter.this.isWeakDataConverter(dataConverter)) {
                        if (z16) {
                            Object obj = s16;
                            if (value != obj) {
                                dataConverter.update(value, obj);
                            }
                            mutableLiveData.setValue(value);
                            return;
                        }
                        return;
                    }
                    mutableLiveData.setValue(dataConverter.cloneConvertData(s16));
                }
            });
        }
    }

    public <S> void observerGlobalState(S s16, Observer<S> observer) {
        Class<?> cls = s16.getClass();
        IDataConverter<S> dataConverter = getDataConverter(cls);
        if (TextUtils.isEmpty(dataConverter.getObserverKey(s16))) {
            throwRuntimeExceptionIfPossible("must define observer key");
            return;
        }
        String globalObjKey = getGlobalObjKey(cls, dataConverter.getObserverKey(s16));
        MutableLiveData mutableLiveData = this.mAllGlobalStateData.get(globalObjKey);
        if (mutableLiveData == null) {
            mutableLiveData = generateLiveData(cls);
            setValueInMainThread(mutableLiveData, dataConverter.cloneConvertData(s16));
            this.mAllGlobalStateData.put(globalObjKey, mutableLiveData);
        } else if (mutableLiveData.getValue() == null) {
            setValueInMainThread(mutableLiveData, s16);
        }
        if (observer == null) {
            return;
        }
        observerGlobalStateInner(dataConverter, mutableLiveData, s16, observer);
    }
}
