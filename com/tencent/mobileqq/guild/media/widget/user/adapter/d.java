package com.tencent.mobileqq.guild.media.widget.user.adapter;

import com.tencent.qqnt.kernel.nativeinterface.GProAudioLiveRobotStatusRspInfo;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0016\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H&J\u000e\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H&\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/guild/media/widget/user/adapter/d;", "", "", "Lcom/tencent/qqnt/kernel/nativeinterface/GProAudioLiveRobotStatusRspInfo;", "updateStatusList", "", "Z", "v", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public interface d {
    void Z(@NotNull List<GProAudioLiveRobotStatusRspInfo> updateStatusList);

    @NotNull
    List<GProAudioLiveRobotStatusRspInfo> v();
}
