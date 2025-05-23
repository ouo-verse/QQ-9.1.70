package com.tencent.shadow.dynamic.host;

import java.io.File;
import java.util.concurrent.Future;

/* loaded from: classes25.dex */
public interface PluginManagerUpdater {
    File getLatest();

    Future<Boolean> isAvailable(File file);

    Future<File> update();

    boolean wasUpdating();
}
