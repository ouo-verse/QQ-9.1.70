package com.tencent.mtt.hippy.modules.nativemodules.storage;

import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.adapter.storage.HippyStorageAdapter;
import com.tencent.mtt.hippy.adapter.storage.HippyStorageKeyValue;
import com.tencent.mtt.hippy.annotation.HippyMethod;
import com.tencent.mtt.hippy.annotation.HippyNativeModule;
import com.tencent.mtt.hippy.common.HippyArray;
import com.tencent.mtt.hippy.modules.Promise;
import com.tencent.mtt.hippy.modules.nativemodules.HippyNativeModuleBase;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
@HippyNativeModule(name = "StorageModule")
/* loaded from: classes20.dex */
public class StorageModule extends HippyNativeModuleBase {

    /* renamed from: a, reason: collision with root package name */
    private final HippyStorageAdapter f337529a;

    public StorageModule(HippyEngineContext hippyEngineContext) {
        super(hippyEngineContext);
        this.f337529a = hippyEngineContext.getGlobalConfigs().getStorageAdapter();
    }

    @HippyMethod(name = "getAllKeys")
    public void getAllKeys(final Promise promise) {
        HippyStorageAdapter hippyStorageAdapter = this.f337529a;
        if (hippyStorageAdapter == null) {
            promise.reject("Database Null");
        } else {
            hippyStorageAdapter.getAllKeys(new HippyStorageAdapter.Callback<HippyArray>() { // from class: com.tencent.mtt.hippy.modules.nativemodules.storage.StorageModule.4
                @Override // com.tencent.mtt.hippy.adapter.storage.HippyStorageAdapter.Callback
                /* renamed from: a, reason: merged with bridge method [inline-methods] */
                public void onSuccess(HippyArray hippyArray) {
                    promise.resolve(hippyArray);
                }

                @Override // com.tencent.mtt.hippy.adapter.storage.HippyStorageAdapter.Callback
                public void onError(String str) {
                    promise.reject(str);
                }
            });
        }
    }

    @HippyMethod(name = "multiGet")
    public void multiGet(HippyArray hippyArray, final Promise promise) {
        if (hippyArray != null && hippyArray.size() > 0) {
            HippyStorageAdapter hippyStorageAdapter = this.f337529a;
            if (hippyStorageAdapter == null) {
                promise.reject("Database Null");
                return;
            } else {
                hippyStorageAdapter.multiGet(hippyArray, new HippyStorageAdapter.Callback<List<HippyStorageKeyValue>>() { // from class: com.tencent.mtt.hippy.modules.nativemodules.storage.StorageModule.1
                    @Override // com.tencent.mtt.hippy.adapter.storage.HippyStorageAdapter.Callback
                    /* renamed from: a, reason: merged with bridge method [inline-methods] */
                    public void onSuccess(List<HippyStorageKeyValue> list) {
                        Promise promise2;
                        HippyArray hippyArray2;
                        if (list != null && list.size() > 0) {
                            hippyArray2 = new HippyArray();
                            for (HippyStorageKeyValue hippyStorageKeyValue : list) {
                                HippyArray hippyArray3 = new HippyArray();
                                hippyArray3.pushString(hippyStorageKeyValue.key);
                                hippyArray3.pushString(hippyStorageKeyValue.value);
                                hippyArray2.pushArray(hippyArray3);
                            }
                            promise2 = promise;
                        } else {
                            promise2 = promise;
                            hippyArray2 = null;
                        }
                        promise2.resolve(hippyArray2);
                    }

                    @Override // com.tencent.mtt.hippy.adapter.storage.HippyStorageAdapter.Callback
                    public void onError(String str) {
                        promise.reject(str);
                    }
                });
                return;
            }
        }
        promise.reject("Invalid Key");
    }

    @HippyMethod(name = "multiRemove")
    public void multiRemove(HippyArray hippyArray, final Promise promise) {
        if (hippyArray != null && hippyArray.size() != 0) {
            HippyStorageAdapter hippyStorageAdapter = this.f337529a;
            if (hippyStorageAdapter == null) {
                promise.reject("Database Null");
                return;
            } else {
                hippyStorageAdapter.multiRemove(hippyArray, new HippyStorageAdapter.Callback<Void>() { // from class: com.tencent.mtt.hippy.modules.nativemodules.storage.StorageModule.3
                    @Override // com.tencent.mtt.hippy.adapter.storage.HippyStorageAdapter.Callback
                    /* renamed from: a, reason: merged with bridge method [inline-methods] */
                    public void onSuccess(Void r26) {
                        promise.resolve("success");
                    }

                    @Override // com.tencent.mtt.hippy.adapter.storage.HippyStorageAdapter.Callback
                    public void onError(String str) {
                        promise.reject(str);
                    }
                });
                return;
            }
        }
        promise.reject("Invalid key");
    }

    @HippyMethod(name = "multiSet")
    public void multiSet(HippyArray hippyArray, final Promise promise) {
        if (hippyArray != null && hippyArray.size() > 0) {
            if (this.f337529a == null) {
                promise.reject("Database Null");
                return;
            }
            try {
                ArrayList arrayList = new ArrayList();
                for (int i3 = 0; i3 < hippyArray.size(); i3++) {
                    HippyArray array = hippyArray.getArray(i3);
                    if (array == null) {
                        promise.reject("Invalid Value");
                        return;
                    }
                    if (array.size() != 2) {
                        promise.reject("Invalid Value");
                        return;
                    }
                    String string = array.getString(0);
                    if (string == null) {
                        promise.reject("Invalid key");
                        return;
                    }
                    String string2 = array.getString(1);
                    if (string2 == null) {
                        promise.reject("Invalid Value");
                        return;
                    }
                    HippyStorageKeyValue hippyStorageKeyValue = new HippyStorageKeyValue();
                    hippyStorageKeyValue.key = string;
                    hippyStorageKeyValue.value = string2;
                    arrayList.add(hippyStorageKeyValue);
                }
                this.f337529a.multiSet(arrayList, new HippyStorageAdapter.Callback<Void>() { // from class: com.tencent.mtt.hippy.modules.nativemodules.storage.StorageModule.2
                    @Override // com.tencent.mtt.hippy.adapter.storage.HippyStorageAdapter.Callback
                    /* renamed from: a, reason: merged with bridge method [inline-methods] */
                    public void onSuccess(Void r26) {
                        promise.resolve("success");
                    }

                    @Override // com.tencent.mtt.hippy.adapter.storage.HippyStorageAdapter.Callback
                    public void onError(String str) {
                        promise.reject(str);
                    }
                });
                return;
            } catch (Throwable th5) {
                promise.reject(th5.getMessage());
                return;
            }
        }
        promise.reject("Invalid Value");
    }
}
