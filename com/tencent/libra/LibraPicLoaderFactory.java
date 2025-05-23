package com.tencent.libra;

import com.tencent.biz.richframework.delegate.impl.RFWApplication;
import com.tencent.libra.strategy.ILibraGlobalStrategy;
import com.tencent.libra.strategy.ILibraLibraryStrategy;
import com.tencent.richframework.thread.RFWThreadManager;
import java.io.File;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes7.dex */
public final class LibraPicLoaderFactory {
    private static volatile ILibraGlobalStrategy sGlobalPicLoadStrategy;
    private static final Map<String, IPicLoader> sPicLoaders = new ConcurrentHashMap();
    private static volatile File sPrivateRootFile;

    static {
        RFWThreadManager.getInstance().execOnFileThread(new Runnable() { // from class: com.tencent.libra.LibraPicLoaderFactory.1
            @Override // java.lang.Runnable
            public void run() {
                File unused = LibraPicLoaderFactory.sPrivateRootFile = LibraPicLoaderFactory.getPrivateFilePath();
            }
        });
    }

    public static ILibraGlobalStrategy getGlobalPicLoadStrategy() {
        return sGlobalPicLoadStrategy;
    }

    public static IPicLoader getPicLoader(ILibraLibraryStrategy iLibraLibraryStrategy) {
        Map<String, IPicLoader> map = sPicLoaders;
        IPicLoader iPicLoader = map.get(iLibraLibraryStrategy.getBusinessName());
        if (iPicLoader == null) {
            synchronized (LibraPicLoaderFactory.class) {
                iPicLoader = map.get(iLibraLibraryStrategy.getBusinessName());
                if (iPicLoader == null) {
                    iPicLoader = new LibraPicLoader(iLibraLibraryStrategy);
                    map.put(iLibraLibraryStrategy.getBusinessName(), iPicLoader);
                }
            }
        }
        return iPicLoader;
    }

    public static File getPrivateFilePath() {
        if (sPrivateRootFile == null) {
            synchronized (LibraPicLoaderFactory.class) {
                if (sPrivateRootFile == null) {
                    sPrivateRootFile = RFWApplication.getApplication().getFilesDir();
                }
            }
        }
        return sPrivateRootFile;
    }

    public static void setGlobalPicLoadStrategy(ILibraGlobalStrategy iLibraGlobalStrategy) {
        sGlobalPicLoadStrategy = iLibraGlobalStrategy;
    }
}
