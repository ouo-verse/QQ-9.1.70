package com.tencent.mobileqq.auto.engine.skin.listener;

import android.content.Context;
import android.content.res.Resources;
import com.tencent.mobileqq.auto.engine.skin.loader.SkinPkgInfo;
import java.util.List;

/* compiled from: P */
/* loaded from: classes11.dex */
public interface ISkinLoader {
    void attach(ISkinUpdate iSkinUpdate);

    void detach(ISkinUpdate iSkinUpdate);

    String getPackageName(Context context);

    SkinPkgInfo getSkinResouceData();

    Resources getSkinResource();

    boolean loadSkinResource(String str, boolean z16, List<String> list);

    void notifySkinUpdate();
}
