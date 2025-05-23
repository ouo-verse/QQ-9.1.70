package com.tencent.mobileqq.vas.social.config;

import com.tencent.state.square.api.SongInfo;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u000e\u0010\u0002\u001a\u0004\u0018\u00010\u0001*\u0004\u0018\u00010\u0000\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/mobileqq/music/SongInfo;", "Lcom/tencent/state/square/api/SongInfo;", "a", "zplan_impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class m {
    public static final SongInfo a(com.tencent.mobileqq.music.SongInfo songInfo) {
        if (songInfo == null) {
            return null;
        }
        return new SongInfo(songInfo.f251868e, songInfo.f251871i, songInfo.F);
    }
}
