package com.tencent.state.publicchat.data;

import com.tencent.mobileqq.vas.banner.c;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import zr4.d;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u001c\b\u0086\b\u0018\u00002\u00020\u0001B]\u0012\u0006\u0010\u0014\u001a\u00020\u0004\u0012\u0006\u0010\u0015\u001a\u00020\u0006\u0012\u0006\u0010\u0016\u001a\u00020\b\u0012\u0006\u0010\u0017\u001a\u00020\n\u0012\u0006\u0010\u0018\u001a\u00020\u0006\u0012\u0006\u0010\u0019\u001a\u00020\u0006\u0012\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00060\u000e\u0012\u0006\u0010\u001b\u001a\u00020\u0006\u0012\u0006\u0010\u001c\u001a\u00020\u0006\u0012\u0006\u0010\u001d\u001a\u00020\u0012\u00a2\u0006\u0004\b:\u0010;B\u0013\b\u0016\u0012\b\u0010<\u001a\u0004\u0018\u00010\u0002\u00a2\u0006\u0004\b:\u0010=J\u0006\u0010\u0003\u001a\u00020\u0002J\t\u0010\u0005\u001a\u00020\u0004H\u00c6\u0003J\t\u0010\u0007\u001a\u00020\u0006H\u00c6\u0003J\t\u0010\t\u001a\u00020\bH\u00c6\u0003J\t\u0010\u000b\u001a\u00020\nH\u00c6\u0003J\t\u0010\f\u001a\u00020\u0006H\u00c6\u0003J\t\u0010\r\u001a\u00020\u0006H\u00c6\u0003J\u000f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00060\u000eH\u00c6\u0003J\t\u0010\u0010\u001a\u00020\u0006H\u00c6\u0003J\t\u0010\u0011\u001a\u00020\u0006H\u00c6\u0003J\t\u0010\u0013\u001a\u00020\u0012H\u00c6\u0003Js\u0010\u001e\u001a\u00020\u00002\b\b\u0002\u0010\u0014\u001a\u00020\u00042\b\b\u0002\u0010\u0015\u001a\u00020\u00062\b\b\u0002\u0010\u0016\u001a\u00020\b2\b\b\u0002\u0010\u0017\u001a\u00020\n2\b\b\u0002\u0010\u0018\u001a\u00020\u00062\b\b\u0002\u0010\u0019\u001a\u00020\u00062\u000e\b\u0002\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00060\u000e2\b\b\u0002\u0010\u001b\u001a\u00020\u00062\b\b\u0002\u0010\u001c\u001a\u00020\u00062\b\b\u0002\u0010\u001d\u001a\u00020\u0012H\u00c6\u0001J\t\u0010\u001f\u001a\u00020\u0004H\u00d6\u0001J\t\u0010 \u001a\u00020\u0012H\u00d6\u0001J\u0013\u0010#\u001a\u00020\"2\b\u0010!\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u0014\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010$\u001a\u0004\b%\u0010&R\u0017\u0010\u0015\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010'\u001a\u0004\b(\u0010)R\u0017\u0010\u0016\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\u0016\u0010*\u001a\u0004\b+\u0010,R\u0017\u0010\u0017\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u0017\u0010-\u001a\u0004\b.\u0010/R\u0017\u0010\u0018\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\u0018\u0010'\u001a\u0004\b0\u0010)R\u0017\u0010\u0019\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\u0019\u0010'\u001a\u0004\b1\u0010)R\u001d\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00060\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u001a\u00102\u001a\u0004\b3\u00104R\u0017\u0010\u001b\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\u001b\u0010'\u001a\u0004\b5\u0010)R\u0017\u0010\u001c\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\u001c\u0010'\u001a\u0004\b6\u0010)R\u0017\u0010\u001d\u001a\u00020\u00128\u0006\u00a2\u0006\f\n\u0004\b\u001d\u00107\u001a\u0004\b8\u00109\u00a8\u0006>"}, d2 = {"Lcom/tencent/state/publicchat/data/MsgHeader;", "", "Lzr4/d;", "toPB", "", "component1", "", "component2", "Lcom/tencent/state/publicchat/data/Scene;", "component3", "Lcom/tencent/state/publicchat/data/DisplayType;", "component4", "component5", "component6", "", "component7", "component8", "component9", "", "component10", "templateId", "channelId", "scene", "displayType", "msgId", "sendUin", "atUins", "sendTs", "auditTs", "showTtl", "copy", "toString", "hashCode", "other", "", "equals", "Ljava/lang/String;", "getTemplateId", "()Ljava/lang/String;", "J", "getChannelId", "()J", "Lcom/tencent/state/publicchat/data/Scene;", "getScene", "()Lcom/tencent/state/publicchat/data/Scene;", "Lcom/tencent/state/publicchat/data/DisplayType;", "getDisplayType", "()Lcom/tencent/state/publicchat/data/DisplayType;", "getMsgId", "getSendUin", "Ljava/util/List;", "getAtUins", "()Ljava/util/List;", "getSendTs", "getAuditTs", "I", "getShowTtl", "()I", "<init>", "(Ljava/lang/String;JLcom/tencent/state/publicchat/data/Scene;Lcom/tencent/state/publicchat/data/DisplayType;JJLjava/util/List;JJI)V", "pb", "(Lzr4/d;)V", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final /* data */ class MsgHeader {
    private final List<Long> atUins;
    private final long auditTs;
    private final long channelId;
    private final DisplayType displayType;
    private final long msgId;
    private final Scene scene;
    private final long sendTs;
    private final long sendUin;
    private final int showTtl;
    private final String templateId;

    public MsgHeader(String templateId, long j3, Scene scene, DisplayType displayType, long j16, long j17, List<Long> atUins, long j18, long j19, int i3) {
        Intrinsics.checkNotNullParameter(templateId, "templateId");
        Intrinsics.checkNotNullParameter(scene, "scene");
        Intrinsics.checkNotNullParameter(displayType, "displayType");
        Intrinsics.checkNotNullParameter(atUins, "atUins");
        this.templateId = templateId;
        this.channelId = j3;
        this.scene = scene;
        this.displayType = displayType;
        this.msgId = j16;
        this.sendUin = j17;
        this.atUins = atUins;
        this.sendTs = j18;
        this.auditTs = j19;
        this.showTtl = i3;
    }

    /* renamed from: component1, reason: from getter */
    public final String getTemplateId() {
        return this.templateId;
    }

    /* renamed from: component10, reason: from getter */
    public final int getShowTtl() {
        return this.showTtl;
    }

    /* renamed from: component2, reason: from getter */
    public final long getChannelId() {
        return this.channelId;
    }

    /* renamed from: component3, reason: from getter */
    public final Scene getScene() {
        return this.scene;
    }

    /* renamed from: component4, reason: from getter */
    public final DisplayType getDisplayType() {
        return this.displayType;
    }

    /* renamed from: component5, reason: from getter */
    public final long getMsgId() {
        return this.msgId;
    }

    /* renamed from: component6, reason: from getter */
    public final long getSendUin() {
        return this.sendUin;
    }

    public final List<Long> component7() {
        return this.atUins;
    }

    /* renamed from: component8, reason: from getter */
    public final long getSendTs() {
        return this.sendTs;
    }

    /* renamed from: component9, reason: from getter */
    public final long getAuditTs() {
        return this.auditTs;
    }

    public final MsgHeader copy(String templateId, long channelId, Scene scene, DisplayType displayType, long msgId, long sendUin, List<Long> atUins, long sendTs, long auditTs, int showTtl) {
        Intrinsics.checkNotNullParameter(templateId, "templateId");
        Intrinsics.checkNotNullParameter(scene, "scene");
        Intrinsics.checkNotNullParameter(displayType, "displayType");
        Intrinsics.checkNotNullParameter(atUins, "atUins");
        return new MsgHeader(templateId, channelId, scene, displayType, msgId, sendUin, atUins, sendTs, auditTs, showTtl);
    }

    public final List<Long> getAtUins() {
        return this.atUins;
    }

    public final long getAuditTs() {
        return this.auditTs;
    }

    public final long getChannelId() {
        return this.channelId;
    }

    public final DisplayType getDisplayType() {
        return this.displayType;
    }

    public final long getMsgId() {
        return this.msgId;
    }

    public final Scene getScene() {
        return this.scene;
    }

    public final long getSendTs() {
        return this.sendTs;
    }

    public final long getSendUin() {
        return this.sendUin;
    }

    public final int getShowTtl() {
        return this.showTtl;
    }

    public final String getTemplateId() {
        return this.templateId;
    }

    public int hashCode() {
        String str = this.templateId;
        int hashCode = (((str != null ? str.hashCode() : 0) * 31) + c.a(this.channelId)) * 31;
        Scene scene = this.scene;
        int hashCode2 = (hashCode + (scene != null ? scene.hashCode() : 0)) * 31;
        DisplayType displayType = this.displayType;
        int hashCode3 = (((((hashCode2 + (displayType != null ? displayType.hashCode() : 0)) * 31) + c.a(this.msgId)) * 31) + c.a(this.sendUin)) * 31;
        List<Long> list = this.atUins;
        return ((((((hashCode3 + (list != null ? list.hashCode() : 0)) * 31) + c.a(this.sendTs)) * 31) + c.a(this.auditTs)) * 31) + this.showTtl;
    }

    public final d toPB() {
        long[] longArray;
        d dVar = new d();
        dVar.f453090a = this.templateId;
        dVar.f453091b = this.channelId;
        dVar.f453092c = this.scene.getValue();
        dVar.f453093d = this.displayType.getValue();
        dVar.f453094e = this.msgId;
        dVar.f453095f = this.sendUin;
        longArray = CollectionsKt___CollectionsKt.toLongArray(this.atUins);
        dVar.f453096g = longArray;
        dVar.f453097h = this.sendTs;
        dVar.f453098i = this.auditTs;
        dVar.f453099j = this.showTtl;
        return dVar;
    }

    public String toString() {
        return "MsgHeader(templateId=" + this.templateId + ", channelId=" + this.channelId + ", scene=" + this.scene + ", displayType=" + this.displayType + ", msgId=" + this.msgId + ", sendUin=" + this.sendUin + ", atUins=" + this.atUins + ", sendTs=" + this.sendTs + ", auditTs=" + this.auditTs + ", showTtl=" + this.showTtl + ")";
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public MsgHeader(d dVar) {
        this(r3, r4, r6, r7, r8, r10, r14, dVar != null ? dVar.f453097h : 0L, dVar != null ? dVar.f453098i : 0L, dVar != null ? dVar.f453099j : 0);
        List emptyList;
        List list;
        long[] jArr;
        String str;
        String str2 = (dVar == null || (str = dVar.f453090a) == null) ? "" : str;
        long j3 = dVar != null ? dVar.f453091b : 0L;
        Scene parse = Scene.INSTANCE.parse(dVar != null ? Integer.valueOf(dVar.f453092c) : null);
        DisplayType parse2 = DisplayType.INSTANCE.parse(dVar != null ? Integer.valueOf(dVar.f453093d) : null);
        long j16 = dVar != null ? dVar.f453094e : 0L;
        long j17 = dVar != null ? dVar.f453095f : 0L;
        if (dVar == null || (jArr = dVar.f453096g) == null) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            list = emptyList;
        } else {
            list = new ArrayList(jArr.length);
            for (long j18 : jArr) {
                list.add(Long.valueOf(j18));
            }
        }
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MsgHeader)) {
            return false;
        }
        MsgHeader msgHeader = (MsgHeader) other;
        return Intrinsics.areEqual(this.templateId, msgHeader.templateId) && this.channelId == msgHeader.channelId && Intrinsics.areEqual(this.scene, msgHeader.scene) && Intrinsics.areEqual(this.displayType, msgHeader.displayType) && this.msgId == msgHeader.msgId && this.sendUin == msgHeader.sendUin && Intrinsics.areEqual(this.atUins, msgHeader.atUins) && this.sendTs == msgHeader.sendTs && this.auditTs == msgHeader.auditTs && this.showTtl == msgHeader.showTtl;
    }
}
