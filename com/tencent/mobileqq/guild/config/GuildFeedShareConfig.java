package com.tencent.mobileqq.guild.config;

import androidx.annotation.Keep;
import com.google.gson.annotations.SerializedName;
import com.tencent.freesia.IConfigData;
import cooperation.qzone.util.WnsError;
import kotlin.Metadata;

/* compiled from: P */
@Keep
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/guild/config/GuildFeedShareConfig;", "Lcom/tencent/freesia/IConfigData;", "()V", "feedSharePicMaxHeight", "", "getFeedSharePicMaxHeight", "()I", "setFeedSharePicMaxHeight", "(I)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes13.dex */
public final class GuildFeedShareConfig implements IConfigData {

    @SerializedName("feed_share_pic_max_height")
    private int feedSharePicMaxHeight = WnsError.WNS_CODE_DIS_STAT_BEGIN;

    public final int getFeedSharePicMaxHeight() {
        return this.feedSharePicMaxHeight;
    }

    public final void setFeedSharePicMaxHeight(int i3) {
        this.feedSharePicMaxHeight = i3;
    }
}
