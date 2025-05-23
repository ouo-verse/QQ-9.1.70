package com.tencent.bugly.common.cache;

import android.text.TextUtils;
import com.tencent.bugly.common.trace.TraceGenerator;
import java.util.Map;

/* loaded from: classes5.dex */
public class ProcessContextWrapper implements IProcessContextUpdater {
    private IProcessContextStorage storage = null;
    private IProcessContextCache cache = null;
    private boolean hasUpdatedBeforeInitStorage = false;
    private boolean hasClearExpiredData = false;
    private final String currentProcessLaunchID = TraceGenerator.getProcessLaunchId();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static class InstanceHolder {
        private static final ProcessContextWrapper instance = new ProcessContextWrapper();

        InstanceHolder() {
        }
    }

    protected ProcessContextWrapper() {
    }

    public static ProcessContextWrapper getInstance() {
        return InstanceHolder.instance;
    }

    private IProcessContextStorage getStorage() {
        return this.storage;
    }

    public void checkClearExpiredData() {
        if (!this.hasClearExpiredData) {
            clearExpiredDataSync();
            this.hasClearExpiredData = true;
        }
    }

    public void clearExpiredDataSync() {
        IProcessContextStorage storage = getStorage();
        if (storage != null) {
            storage.clearExpiredData();
        }
    }

    public IProcessContextLoader createProcessContextLoader(String str, IProcessContextStorage iProcessContextStorage) {
        if (getStorage() == null) {
            initStorage(iProcessContextStorage);
        }
        return createProcessContextLoader(str);
    }

    public IProcessContextCache getProcessContextCache() {
        if (this.cache == null) {
            synchronized (this) {
                if (this.cache == null) {
                    this.cache = new ProcessContextCacheImpl(this);
                }
            }
        }
        return this.cache;
    }

    public void initStorage(IProcessContextStorage iProcessContextStorage) {
        if (iProcessContextStorage == null) {
            return;
        }
        this.storage = iProcessContextStorage;
        IProcessContextCache iProcessContextCache = this.cache;
        if (iProcessContextCache != null && this.hasUpdatedBeforeInitStorage) {
            iProcessContextCache.commit();
            this.hasUpdatedBeforeInitStorage = false;
        }
    }

    public boolean update(String str, String str2) {
        IProcessContextStorage storage = getStorage();
        if (storage == null) {
            this.hasUpdatedBeforeInitStorage = true;
            return false;
        }
        checkClearExpiredData();
        storage.update(this.currentProcessLaunchID, str, str2);
        return true;
    }

    public IProcessContextLoader createProcessContextLoader(String str) {
        IProcessContextStorage storage;
        if (TextUtils.isEmpty(str) || (storage = getStorage()) == null) {
            return null;
        }
        return new ProcessContextLoaderImpl(storage.load(str));
    }

    @Override // com.tencent.bugly.common.cache.IProcessContextUpdater
    public boolean update(Map<String, String> map) {
        IProcessContextStorage storage = getStorage();
        if (storage == null) {
            this.hasUpdatedBeforeInitStorage = true;
            return false;
        }
        checkClearExpiredData();
        storage.update(this.currentProcessLaunchID, map);
        return true;
    }
}
