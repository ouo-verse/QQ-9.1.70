package com.tencent.mobileqq.guild.media.core.logic;

import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H&J \u0010\n\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007H&J\u0018\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H&J\u0010\u0010\f\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\r\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u0002H&\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/guild/media/core/logic/i;", "", "", "id", "errCode", "", "onStart", "", "curPtsMS", "durationMS", "onPlayProgress", "onComplete", "b", MiniSDKConst.NOTIFY_EVENT_ONPAUSE, "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public interface i {
    void b(int id5);

    void onComplete(int id5, int errCode);

    void onPause(int id5);

    void onPlayProgress(int id5, long curPtsMS, long durationMS);

    void onStart(int id5, int errCode);
}
