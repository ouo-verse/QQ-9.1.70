package com.tencent.timi.game.liveroom.impl.room.input;

import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001BQ\u0012\u0006\u0010\u000f\u001a\u00020\u0007\u0012\u0006\u0010\u0011\u001a\u00020\u0007\u0012\u0006\u0010\u0014\u001a\u00020\u0007\u0012\u0006\u0010\u0016\u001a\u00020\u0007\u0012\u0006\u0010\u001a\u001a\u00020\u0007\u0012\u0006\u0010\u001f\u001a\u00020\u001b\u0012\u000e\u0010$\u001a\n\u0012\u0004\u0012\u00020!\u0018\u00010 \u0012\b\b\u0002\u0010)\u001a\u00020\u0005\u00a2\u0006\u0004\b*\u0010+J\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0004\u001a\u00020\u0002J\t\u0010\u0006\u001a\u00020\u0005H\u00d6\u0001J\t\u0010\b\u001a\u00020\u0007H\u00d6\u0001J\u0013\u0010\n\u001a\u00020\u00022\b\u0010\t\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u000f\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u0011\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\f\u001a\u0004\b\u0010\u0010\u000eR\u0017\u0010\u0014\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\f\u001a\u0004\b\u0013\u0010\u000eR\u0017\u0010\u0016\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\f\u001a\u0004\b\u0015\u0010\u000eR\"\u0010\u001a\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0017\u0010\f\u001a\u0004\b\u0012\u0010\u000e\"\u0004\b\u0018\u0010\u0019R\u0017\u0010\u001f\u001a\u00020\u001b8\u0006\u00a2\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u000b\u0010\u001eR\u001f\u0010$\u001a\n\u0012\u0004\u0012\u00020!\u0018\u00010 8\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\"\u001a\u0004\b\u0017\u0010#R\"\u0010)\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010%\u001a\u0004\b\u001c\u0010&\"\u0004\b'\u0010(\u00a8\u0006,"}, d2 = {"Lcom/tencent/timi/game/liveroom/impl/room/input/o;", "", "", tl.h.F, "i", "", "toString", "", "hashCode", "other", "equals", "a", "I", "b", "()I", "id", "getType", "type", "c", "g", "price", "d", "leftDay", "e", "j", "(I)V", "leftCount", "Lcom/tencent/timi/game/liveroom/impl/room/input/n;", "f", "Lcom/tencent/timi/game/liveroom/impl/room/input/n;", "()Lcom/tencent/timi/game/liveroom/impl/room/input/n;", DownloadInfo.spKey_Config, "", "Lcom/tencent/timi/game/liveroom/impl/room/input/q;", "Ljava/util/List;", "()Ljava/util/List;", "limits", "Ljava/lang/String;", "()Ljava/lang/String;", "k", "(Ljava/lang/String;)V", "msgId", "<init>", "(IIIIILcom/tencent/timi/game/liveroom/impl/room/input/n;Ljava/util/List;Ljava/lang/String;)V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.timi.game.liveroom.impl.room.input.o, reason: from toString */
/* loaded from: classes26.dex */
public final /* data */ class BarrageData {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final int id;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final int type;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final int price;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private final int leftDay;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    private int leftCount;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final BarrageConfig config;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final List<BarrageLimit> limits;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private String msgId;

    public BarrageData(int i3, int i16, int i17, int i18, int i19, @NotNull BarrageConfig config, @Nullable List<BarrageLimit> list, @NotNull String msgId) {
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(msgId, "msgId");
        this.id = i3;
        this.type = i16;
        this.price = i17;
        this.leftDay = i18;
        this.leftCount = i19;
        this.config = config;
        this.limits = list;
        this.msgId = msgId;
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final BarrageConfig getConfig() {
        return this.config;
    }

    /* renamed from: b, reason: from getter */
    public final int getId() {
        return this.id;
    }

    /* renamed from: c, reason: from getter */
    public final int getLeftCount() {
        return this.leftCount;
    }

    /* renamed from: d, reason: from getter */
    public final int getLeftDay() {
        return this.leftDay;
    }

    @Nullable
    public final List<BarrageLimit> e() {
        return this.limits;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof BarrageData)) {
            return false;
        }
        BarrageData barrageData = (BarrageData) other;
        if (this.id == barrageData.id && this.type == barrageData.type && this.price == barrageData.price && this.leftDay == barrageData.leftDay && this.leftCount == barrageData.leftCount && Intrinsics.areEqual(this.config, barrageData.config) && Intrinsics.areEqual(this.limits, barrageData.limits) && Intrinsics.areEqual(this.msgId, barrageData.msgId)) {
            return true;
        }
        return false;
    }

    @NotNull
    /* renamed from: f, reason: from getter */
    public final String getMsgId() {
        return this.msgId;
    }

    /* renamed from: g, reason: from getter */
    public final int getPrice() {
        return this.price;
    }

    public final boolean h() {
        if (this.type == 2) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2 = ((((((((((this.id * 31) + this.type) * 31) + this.price) * 31) + this.leftDay) * 31) + this.leftCount) * 31) + this.config.hashCode()) * 31;
        List<BarrageLimit> list = this.limits;
        if (list == null) {
            hashCode = 0;
        } else {
            hashCode = list.hashCode();
        }
        return ((hashCode2 + hashCode) * 31) + this.msgId.hashCode();
    }

    public final boolean i() {
        if (this.type == 1) {
            return true;
        }
        return false;
    }

    public final void j(int i3) {
        this.leftCount = i3;
    }

    public final void k(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.msgId = str;
    }

    @NotNull
    public String toString() {
        return "BarrageData(id=" + this.id + ", type=" + this.type + ", price=" + this.price + ", leftDay=" + this.leftDay + ", leftCount=" + this.leftCount + ", config=" + this.config + ", limits=" + this.limits + ", msgId=" + this.msgId + ")";
    }

    public /* synthetic */ BarrageData(int i3, int i16, int i17, int i18, int i19, BarrageConfig barrageConfig, List list, String str, int i26, DefaultConstructorMarker defaultConstructorMarker) {
        this(i3, i16, i17, i18, i19, barrageConfig, list, (i26 & 128) != 0 ? "" : str);
    }
}
