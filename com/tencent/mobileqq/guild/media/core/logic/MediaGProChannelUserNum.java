package com.tencent.mobileqq.guild.media.core.logic;

import com.qzone.proxy.personalitycomponent.model.WidgetCacheConstellationData;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelUserNum;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\tJ\b\u0010\n\u001a\u00020\u0003H\u0016J\b\u0010\u000b\u001a\u00020\u0005H\u0016J\b\u0010\f\u001a\u00020\u0005H\u0016J\b\u0010\r\u001a\u00020\u0005H\u0016J\b\u0010\u000e\u001a\u00020\u0005H\u0016J\b\u0010\u000f\u001a\u00020\u0005H\u0016J\b\u0010\u0010\u001a\u00020\u0005H\u0016J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0005H\u0016J\u0010\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0005H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/guild/media/core/logic/MediaGProChannelUserNum;", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProChannelUserNum;", "dataVersion", "", "userNum", "", "playersNum", "viewersNum", "showThreshold", "(JIIII)V", "getDataVersion", "getPlayersNum", "getRobotNum", "getShowThreshold", "getSpeakOrderNum", "getUserNum", "getViewersNum", "setPlayersNum", "", WidgetCacheConstellationData.NUM, "setViewersNum", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes14.dex */
public final class MediaGProChannelUserNum implements IGProChannelUserNum {
    private final long dataVersion;
    private final int playersNum;
    private final int showThreshold;
    private final int userNum;
    private final int viewersNum;

    public MediaGProChannelUserNum(long j3, int i3, int i16, int i17, int i18) {
        this.dataVersion = j3;
        this.userNum = i3;
        this.playersNum = i16;
        this.viewersNum = i17;
        this.showThreshold = i18;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProChannelUserNum
    public long getDataVersion() {
        return this.dataVersion;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProChannelUserNum
    public int getPlayersNum() {
        return this.playersNum;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProChannelUserNum
    public int getRobotNum() {
        return 0;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProChannelUserNum
    public int getShowThreshold() {
        return this.showThreshold;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProChannelUserNum
    public int getSpeakOrderNum() {
        return 0;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProChannelUserNum
    public int getUserNum() {
        return this.userNum;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProChannelUserNum
    public int getViewersNum() {
        return this.viewersNum;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProChannelUserNum
    public void setPlayersNum(int num) {
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProChannelUserNum
    public void setViewersNum(int num) {
    }
}
