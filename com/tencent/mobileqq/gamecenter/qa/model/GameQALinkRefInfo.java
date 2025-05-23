package com.tencent.mobileqq.gamecenter.qa.model;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000f\b\u0086\b\u0018\u0000 \u001f2\u00020\u0001:\u0001 B%\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0006\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\u000b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u00c6\u0003J\u000b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u00c6\u0003J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00c6\u0003J-\u0010\u000b\u001a\u00020\u00002\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0006H\u00c6\u0001J\t\u0010\r\u001a\u00020\fH\u00d6\u0001J\t\u0010\u000f\u001a\u00020\u000eH\u00d6\u0001J\u0013\u0010\u0013\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u00d6\u0003R\u0019\u0010\b\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u0019\u0010\t\u001a\u0004\u0018\u00010\u00048\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u0019\u0010\n\u001a\u0004\u0018\u00010\u00068\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\u00a8\u0006!"}, d2 = {"Lcom/tencent/mobileqq/gamecenter/qa/model/GameQALinkRefInfo;", "Ljava/io/Serializable;", "Lcom/tencent/mobileqq/gamecenter/qa/model/GameQALinkRefQA;", "component1", "Lcom/tencent/mobileqq/gamecenter/qa/model/GameQALinkRefChannel;", "component2", "Lcom/tencent/mobileqq/gamecenter/qa/model/GameQALinkRefXWorld;", "component3", "qaInfo", "channelInfo", "xWorldInfo", "copy", "", "toString", "", "hashCode", "", "other", "", "equals", "Lcom/tencent/mobileqq/gamecenter/qa/model/GameQALinkRefQA;", "getQaInfo", "()Lcom/tencent/mobileqq/gamecenter/qa/model/GameQALinkRefQA;", "Lcom/tencent/mobileqq/gamecenter/qa/model/GameQALinkRefChannel;", "getChannelInfo", "()Lcom/tencent/mobileqq/gamecenter/qa/model/GameQALinkRefChannel;", "Lcom/tencent/mobileqq/gamecenter/qa/model/GameQALinkRefXWorld;", "getXWorldInfo", "()Lcom/tencent/mobileqq/gamecenter/qa/model/GameQALinkRefXWorld;", "<init>", "(Lcom/tencent/mobileqq/gamecenter/qa/model/GameQALinkRefQA;Lcom/tencent/mobileqq/gamecenter/qa/model/GameQALinkRefChannel;Lcom/tencent/mobileqq/gamecenter/qa/model/GameQALinkRefXWorld;)V", "Companion", "a", "qqgamecenter-qa-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final /* data */ class GameQALinkRefInfo implements Serializable {
    private static final long serialVersionUID = 1;

    @Nullable
    private final GameQALinkRefChannel channelInfo;

    @Nullable
    private final GameQALinkRefQA qaInfo;

    @Nullable
    private final GameQALinkRefXWorld xWorldInfo;

    public GameQALinkRefInfo(@Nullable GameQALinkRefQA gameQALinkRefQA, @Nullable GameQALinkRefChannel gameQALinkRefChannel, @Nullable GameQALinkRefXWorld gameQALinkRefXWorld) {
        this.qaInfo = gameQALinkRefQA;
        this.channelInfo = gameQALinkRefChannel;
        this.xWorldInfo = gameQALinkRefXWorld;
    }

    public static /* synthetic */ GameQALinkRefInfo copy$default(GameQALinkRefInfo gameQALinkRefInfo, GameQALinkRefQA gameQALinkRefQA, GameQALinkRefChannel gameQALinkRefChannel, GameQALinkRefXWorld gameQALinkRefXWorld, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            gameQALinkRefQA = gameQALinkRefInfo.qaInfo;
        }
        if ((i3 & 2) != 0) {
            gameQALinkRefChannel = gameQALinkRefInfo.channelInfo;
        }
        if ((i3 & 4) != 0) {
            gameQALinkRefXWorld = gameQALinkRefInfo.xWorldInfo;
        }
        return gameQALinkRefInfo.copy(gameQALinkRefQA, gameQALinkRefChannel, gameQALinkRefXWorld);
    }

    @Nullable
    /* renamed from: component1, reason: from getter */
    public final GameQALinkRefQA getQaInfo() {
        return this.qaInfo;
    }

    @Nullable
    /* renamed from: component2, reason: from getter */
    public final GameQALinkRefChannel getChannelInfo() {
        return this.channelInfo;
    }

    @Nullable
    /* renamed from: component3, reason: from getter */
    public final GameQALinkRefXWorld getXWorldInfo() {
        return this.xWorldInfo;
    }

    @NotNull
    public final GameQALinkRefInfo copy(@Nullable GameQALinkRefQA qaInfo, @Nullable GameQALinkRefChannel channelInfo, @Nullable GameQALinkRefXWorld xWorldInfo) {
        return new GameQALinkRefInfo(qaInfo, channelInfo, xWorldInfo);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GameQALinkRefInfo)) {
            return false;
        }
        GameQALinkRefInfo gameQALinkRefInfo = (GameQALinkRefInfo) other;
        if (Intrinsics.areEqual(this.qaInfo, gameQALinkRefInfo.qaInfo) && Intrinsics.areEqual(this.channelInfo, gameQALinkRefInfo.channelInfo) && Intrinsics.areEqual(this.xWorldInfo, gameQALinkRefInfo.xWorldInfo)) {
            return true;
        }
        return false;
    }

    @Nullable
    public final GameQALinkRefChannel getChannelInfo() {
        return this.channelInfo;
    }

    @Nullable
    public final GameQALinkRefQA getQaInfo() {
        return this.qaInfo;
    }

    @Nullable
    public final GameQALinkRefXWorld getXWorldInfo() {
        return this.xWorldInfo;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2;
        GameQALinkRefQA gameQALinkRefQA = this.qaInfo;
        int i3 = 0;
        if (gameQALinkRefQA == null) {
            hashCode = 0;
        } else {
            hashCode = gameQALinkRefQA.hashCode();
        }
        int i16 = hashCode * 31;
        GameQALinkRefChannel gameQALinkRefChannel = this.channelInfo;
        if (gameQALinkRefChannel == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = gameQALinkRefChannel.hashCode();
        }
        int i17 = (i16 + hashCode2) * 31;
        GameQALinkRefXWorld gameQALinkRefXWorld = this.xWorldInfo;
        if (gameQALinkRefXWorld != null) {
            i3 = gameQALinkRefXWorld.hashCode();
        }
        return i17 + i3;
    }

    @NotNull
    public String toString() {
        return "GameQALinkRefInfo(qaInfo=" + this.qaInfo + ", channelInfo=" + this.channelInfo + ", xWorldInfo=" + this.xWorldInfo + ")";
    }
}
