package com.tencent.mobileqq.intervideo.groupvideo.plugininterface;

import java.io.File;

/* compiled from: P */
/* loaded from: classes33.dex */
public interface IGVideoSoMonitorApi {
    boolean isSoFileLegal(File file);

    boolean isSoFileRegistered(File file);

    boolean isSoPathLegal(String str);

    boolean isSoPathRegistered(String str);

    void registerSoFile(File file);

    void registerSoFilePath(String str);
}
