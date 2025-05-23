package com.tencent.thumbplayer.api.snapshot;

import androidx.annotation.Nullable;
import com.tencent.thumbplayer.api.manager.TPMgr;
import com.tencent.thumbplayer.snapshot.TPSelfDevSnapshotor;

/* loaded from: classes26.dex */
public class TPSnapshotorFactory {
    @Nullable
    public static ITPSnapshotor createSnapshotor() {
        if (!TPMgr.isInitialized()) {
            return null;
        }
        return new TPSelfDevSnapshotor();
    }
}
