package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.io.Serializable;

/* loaded from: classes24.dex */
public final class GProContentRecommendOneToOne implements Serializable {
    long serialVersionUID = 1;

    /* renamed from: guild, reason: collision with root package name */
    public GProContentRecommendGuild f359286guild = new GProContentRecommendGuild();
    public byte[] stFeed = new byte[0];

    public GProContentRecommendGuild getGuild() {
        return this.f359286guild;
    }

    public byte[] getStFeed() {
        return this.stFeed;
    }

    public String toString() {
        return "GProContentRecommendOneToOne{guild=" + this.f359286guild + ",stFeed=" + this.stFeed + ",}";
    }
}
