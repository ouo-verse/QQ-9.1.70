package com.tencent.thumbplayer.core.datatransport.util;

import androidx.annotation.NonNull;
import com.tencent.thumbplayer.core.datatransport.api.ITPDataTransportLogListener;

/* loaded from: classes26.dex */
public class TPDataTransportLogFactory {
    private ITPDataTransportLogListener mLogListener;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes26.dex */
    public static class SingletonHolder {
        private static final TPDataTransportLogFactory INSTANCE = new TPDataTransportLogFactory();

        SingletonHolder() {
        }
    }

    public static TPDataTransportLogFactory getInstance() {
        return SingletonHolder.INSTANCE;
    }

    public ITPDataTransportLogListener getLogListener() {
        return this.mLogListener;
    }

    public ITPDataTransportLog getLogger(@NonNull String str) {
        return new TPDataTransportLog(str);
    }

    public void setLogListener(ITPDataTransportLogListener iTPDataTransportLogListener) {
        if (iTPDataTransportLogListener == null) {
            return;
        }
        this.mLogListener = iTPDataTransportLogListener;
    }
}
