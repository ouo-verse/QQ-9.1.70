package com.tencent.mobileqq.gamecenter.qa.model;

import java.io.Serializable;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\r\b\u0086\b\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001cB\u001f\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\b\u001a\u00020\u0004\u0012\u0006\u0010\t\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\t\u0010\u0003\u001a\u00020\u0002H\u00c6\u0003J\t\u0010\u0005\u001a\u00020\u0004H\u00c6\u0003J\t\u0010\u0006\u001a\u00020\u0004H\u00c6\u0003J'\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0007\u001a\u00020\u00022\b\b\u0002\u0010\b\u001a\u00020\u00042\b\b\u0002\u0010\t\u001a\u00020\u0004H\u00c6\u0001J\t\u0010\f\u001a\u00020\u000bH\u00d6\u0001J\t\u0010\r\u001a\u00020\u0002H\u00d6\u0001J\u0013\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u00d6\u0003R\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0007\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u0017\u0010\b\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0017\u0010\t\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\u0015\u001a\u0004\b\u0018\u0010\u0017\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/mobileqq/gamecenter/qa/model/GameQALinkRefQA;", "Ljava/io/Serializable;", "", "component1", "", "component2", "component3", "appid", "qusid", "ansid", "copy", "", "toString", "hashCode", "", "other", "", "equals", "I", "getAppid", "()I", "J", "getQusid", "()J", "getAnsid", "<init>", "(IJJ)V", "Companion", "a", "qqgamecenter-qa-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final /* data */ class GameQALinkRefQA implements Serializable {
    private static final long serialVersionUID = 1;
    private final long ansid;
    private final int appid;
    private final long qusid;

    public GameQALinkRefQA(int i3, long j3, long j16) {
        this.appid = i3;
        this.qusid = j3;
        this.ansid = j16;
    }

    public static /* synthetic */ GameQALinkRefQA copy$default(GameQALinkRefQA gameQALinkRefQA, int i3, long j3, long j16, int i16, Object obj) {
        if ((i16 & 1) != 0) {
            i3 = gameQALinkRefQA.appid;
        }
        if ((i16 & 2) != 0) {
            j3 = gameQALinkRefQA.qusid;
        }
        long j17 = j3;
        if ((i16 & 4) != 0) {
            j16 = gameQALinkRefQA.ansid;
        }
        return gameQALinkRefQA.copy(i3, j17, j16);
    }

    /* renamed from: component1, reason: from getter */
    public final int getAppid() {
        return this.appid;
    }

    /* renamed from: component2, reason: from getter */
    public final long getQusid() {
        return this.qusid;
    }

    /* renamed from: component3, reason: from getter */
    public final long getAnsid() {
        return this.ansid;
    }

    @NotNull
    public final GameQALinkRefQA copy(int appid, long qusid, long ansid) {
        return new GameQALinkRefQA(appid, qusid, ansid);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GameQALinkRefQA)) {
            return false;
        }
        GameQALinkRefQA gameQALinkRefQA = (GameQALinkRefQA) other;
        if (this.appid == gameQALinkRefQA.appid && this.qusid == gameQALinkRefQA.qusid && this.ansid == gameQALinkRefQA.ansid) {
            return true;
        }
        return false;
    }

    public final long getAnsid() {
        return this.ansid;
    }

    public final int getAppid() {
        return this.appid;
    }

    public final long getQusid() {
        return this.qusid;
    }

    public int hashCode() {
        return (((this.appid * 31) + androidx.fragment.app.a.a(this.qusid)) * 31) + androidx.fragment.app.a.a(this.ansid);
    }

    @NotNull
    public String toString() {
        return "GameQALinkRefQA(appid=" + this.appid + ", qusid=" + this.qusid + ", ansid=" + this.ansid + ")";
    }
}
