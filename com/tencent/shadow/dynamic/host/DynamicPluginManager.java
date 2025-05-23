package com.tencent.shadow.dynamic.host;

import android.content.Context;
import android.os.Bundle;
import com.tencent.shadow.core.common.Logger;
import com.tencent.shadow.core.common.LoggerFactory;
import java.io.File;

/* loaded from: classes25.dex */
public final class DynamicPluginManager implements PluginManager {
    private static final Logger mLogger = LoggerFactory.getLogger(ShadowTag.class);
    private long mLastModified;
    private PluginManagerImpl mManagerImpl;
    private final PluginManagerUpdater mUpdater;

    public DynamicPluginManager(PluginManagerUpdater pluginManagerUpdater) {
        if (pluginManagerUpdater.getLatest() != null) {
            this.mUpdater = pluginManagerUpdater;
            return;
        }
        throw new IllegalArgumentException("\u6784\u9020DynamicPluginManager\u65f6\u4f20\u5165\u7684PluginManagerUpdater\u5fc5\u987b\u5df2\u7ecf\u5df2\u6709\u672c\u5730\u6587\u4ef6\uff0c\u5373getLatest()!=null");
    }

    private void updateManagerImpl(Context context) {
        Bundle bundle;
        boolean z16;
        File latest = this.mUpdater.getLatest();
        long lastModified = latest.lastModified();
        Logger logger = mLogger;
        if (logger.isInfoEnabled()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("mLastModified != lastModified : ");
            if (this.mLastModified != lastModified) {
                z16 = true;
            } else {
                z16 = false;
            }
            sb5.append(z16);
            logger.info(sb5.toString());
        }
        if (this.mLastModified != lastModified) {
            PluginManagerImpl load = new ManagerImplLoader(context, latest).load();
            if (this.mManagerImpl != null) {
                bundle = new Bundle();
                this.mManagerImpl.onSaveInstanceState(bundle);
                this.mManagerImpl.onDestroy();
            } else {
                bundle = null;
            }
            load.onCreate(bundle);
            this.mManagerImpl = load;
            this.mLastModified = lastModified;
        }
    }

    @Override // com.tencent.shadow.dynamic.host.PluginManager
    public void enter(Context context, long j3, Bundle bundle, EnterCallback enterCallback) {
        Logger logger = mLogger;
        if (logger.isInfoEnabled()) {
            logger.info("enter fromId:" + j3 + " callback:" + enterCallback);
        }
        updateManagerImpl(context);
        if (logger.isInfoEnabled()) {
            logger.info("realEnter");
        }
        this.mManagerImpl.enter(context, j3, bundle, enterCallback);
        this.mUpdater.update();
    }

    public PluginManager getManagerImpl() {
        return this.mManagerImpl;
    }

    public void release() {
        Logger logger = mLogger;
        if (logger.isInfoEnabled()) {
            logger.info("release");
        }
        PluginManagerImpl pluginManagerImpl = this.mManagerImpl;
        if (pluginManagerImpl != null) {
            pluginManagerImpl.onDestroy();
            this.mManagerImpl = null;
        }
    }
}
