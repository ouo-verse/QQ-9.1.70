package com.tencent.shadow.core.runtime.skin.listener;

import android.content.res.Resources;
import com.tencent.shadow.core.runtime.skin.loader.SkinPkgInfo;

/* compiled from: P */
/* loaded from: classes25.dex */
public interface ISkinLoader {
    void attach(ISkinUpdate iSkinUpdate);

    void detach(ISkinUpdate iSkinUpdate);

    String getPackageName();

    SkinPkgInfo getSkinResouceData();

    Resources getSkinResource();

    boolean loadSkinFile(SkinPkgInfo skinPkgInfo);

    void notifySkinUpdate();
}
