package com.tencent.qqlive.tvkplayer.api.moduleupdate;

import com.tencent.qqlive.tvkplayer.api.TVKError;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* compiled from: P */
/* loaded from: classes23.dex */
public interface ITVKModuleUpdaterMgr {
    public static final int CORELIB_NEED_UPDATE = 1;
    public static final int CORELIB_NO_NEED_UPDATE = 0;
    public static final int CORELIB_UPDATED = 3;
    public static final int CORELIB_UPDATING = 2;

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes23.dex */
    public @interface CoreLibUpdateState {
    }

    /* compiled from: P */
    /* loaded from: classes23.dex */
    public interface ITVKModuleUpdateListener {
        void onFailure(TVKError tVKError);

        void onSuccess();
    }

    int getPlayerCoreLibUpdateState();

    void updatePlayerCoreLib(ITVKModuleUpdateListener iTVKModuleUpdateListener);
}
