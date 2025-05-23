package com.tencent.timi.game.liveroom.impl.room.anchor;

import android.app.Activity;
import com.tencent.timi.game.liveroom.impl.room.playtogether.presenter.AnchorPlayTogetherPresenter;
import mqq.util.WeakReference;

/* compiled from: P */
/* loaded from: classes26.dex */
public class o {
    public static AnchorPlayTogetherPresenter a(Activity activity, long j3, int i3, long j16) {
        AnchorPlayTogetherPresenter anchorPlayTogetherPresenter = new AnchorPlayTogetherPresenter(new WeakReference(activity), j3, j16, i3);
        anchorPlayTogetherPresenter.l();
        anchorPlayTogetherPresenter.v();
        return anchorPlayTogetherPresenter;
    }

    public static pj4.a b(long j3, int i3, jg4.h hVar) {
        String str;
        if (hVar == null || (str = hVar.f409910d) == null) {
            return null;
        }
        pj4.a aVar = new pj4.a(str, i3, hVar.getAnchorUid(), j3);
        aVar.c(null);
        return aVar;
    }
}
