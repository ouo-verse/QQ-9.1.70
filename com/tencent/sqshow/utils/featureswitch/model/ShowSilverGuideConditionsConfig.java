package com.tencent.sqshow.utils.featureswitch.model;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\b\b\u0002\u0010\t\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u000e\u001a\u00020\r\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0014\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u001a\u0010\t\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\u000e\u001a\u00020\r8\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u0012\u0010\n\u001a\u0004\b\u0013\u0010\fR\u001a\u0010\u0015\u001a\u00020\u00148\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/sqshow/utils/featureswitch/model/l;", "", "", "toString", "", "hashCode", "other", "", "equals", "maxSilverThreshold", "I", "b", "()I", "Lcom/tencent/sqshow/utils/featureswitch/model/d;", "maxSilverConfig", "Lcom/tencent/sqshow/utils/featureswitch/model/d;", "a", "()Lcom/tencent/sqshow/utils/featureswitch/model/d;", "minSilverThreshold", "d", "Lcom/tencent/sqshow/utils/featureswitch/model/e;", "minSilverConfig", "Lcom/tencent/sqshow/utils/featureswitch/model/e;", "c", "()Lcom/tencent/sqshow/utils/featureswitch/model/e;", "<init>", "(ILcom/tencent/sqshow/utils/featureswitch/model/d;ILcom/tencent/sqshow/utils/featureswitch/model/e;)V", "superqqshow-base-kit_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.sqshow.utils.featureswitch.model.l, reason: from toString */
/* loaded from: classes34.dex */
public final /* data */ class ShowSilverGuideConditionsConfig {

    @SerializedName("maxSilverConfig")
    private final MaxSilverConfig maxSilverConfig;

    @SerializedName("maxSilverThreshold")
    private final int maxSilverThreshold;

    @SerializedName("minSilverConfig")
    private final MinSilverConfig minSilverConfig;

    @SerializedName("minSilverThreshold")
    private final int minSilverThreshold;

    public ShowSilverGuideConditionsConfig() {
        this(0, null, 0, null, 15, null);
    }

    /* renamed from: a, reason: from getter */
    public final MaxSilverConfig getMaxSilverConfig() {
        return this.maxSilverConfig;
    }

    /* renamed from: b, reason: from getter */
    public final int getMaxSilverThreshold() {
        return this.maxSilverThreshold;
    }

    /* renamed from: c, reason: from getter */
    public final MinSilverConfig getMinSilverConfig() {
        return this.minSilverConfig;
    }

    /* renamed from: d, reason: from getter */
    public final int getMinSilverThreshold() {
        return this.minSilverThreshold;
    }

    public int hashCode() {
        return (((((this.maxSilverThreshold * 31) + this.maxSilverConfig.hashCode()) * 31) + this.minSilverThreshold) * 31) + this.minSilverConfig.hashCode();
    }

    public String toString() {
        return "ShowSilverGuideConditionsConfig(maxSilverThreshold=" + this.maxSilverThreshold + ", maxSilverConfig=" + this.maxSilverConfig + ", minSilverThreshold=" + this.minSilverThreshold + ", minSilverConfig=" + this.minSilverConfig + ')';
    }

    public ShowSilverGuideConditionsConfig(int i3, MaxSilverConfig maxSilverConfig, int i16, MinSilverConfig minSilverConfig) {
        Intrinsics.checkNotNullParameter(maxSilverConfig, "maxSilverConfig");
        Intrinsics.checkNotNullParameter(minSilverConfig, "minSilverConfig");
        this.maxSilverThreshold = i3;
        this.maxSilverConfig = maxSilverConfig;
        this.minSilverThreshold = i16;
        this.minSilverConfig = minSilverConfig;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ShowSilverGuideConditionsConfig)) {
            return false;
        }
        ShowSilverGuideConditionsConfig showSilverGuideConditionsConfig = (ShowSilverGuideConditionsConfig) other;
        return this.maxSilverThreshold == showSilverGuideConditionsConfig.maxSilverThreshold && Intrinsics.areEqual(this.maxSilverConfig, showSilverGuideConditionsConfig.maxSilverConfig) && this.minSilverThreshold == showSilverGuideConditionsConfig.minSilverThreshold && Intrinsics.areEqual(this.minSilverConfig, showSilverGuideConditionsConfig.minSilverConfig);
    }

    /*  JADX ERROR: NullPointerException in pass: InitCodeVariables
        java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.SSAVar.getPhiList()" because "resultVar" is null
        	at jadx.core.dex.visitors.InitCodeVariables.collectConnectedVars(InitCodeVariables.java:119)
        	at jadx.core.dex.visitors.InitCodeVariables.setCodeVar(InitCodeVariables.java:82)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVar(InitCodeVariables.java:74)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVars(InitCodeVariables.java:48)
        	at jadx.core.dex.visitors.InitCodeVariables.visit(InitCodeVariables.java:29)
        */
    public /* synthetic */ ShowSilverGuideConditionsConfig(int r17, com.tencent.sqshow.utils.featureswitch.model.MaxSilverConfig r18, int r19, com.tencent.sqshow.utils.featureswitch.model.MinSilverConfig r20, int r21, kotlin.jvm.internal.DefaultConstructorMarker r22) {
        /*
            r16 = this;
            r0 = r21 & 1
            if (r0 == 0) goto L7
            r0 = 600(0x258, float:8.41E-43)
            goto L9
        L7:
            r0 = r17
        L9:
            r1 = r21 & 2
            if (r1 == 0) goto L20
            com.tencent.sqshow.utils.featureswitch.model.d r1 = new com.tencent.sqshow.utils.featureswitch.model.d
            r3 = 0
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 0
            r12 = 511(0x1ff, float:7.16E-43)
            r13 = 0
            r2 = r1
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13)
            goto L22
        L20:
            r1 = r18
        L22:
            r2 = r21 & 4
            if (r2 == 0) goto L29
            r2 = 400(0x190, float:5.6E-43)
            goto L2b
        L29:
            r2 = r19
        L2b:
            r3 = r21 & 8
            if (r3 == 0) goto L44
            com.tencent.sqshow.utils.featureswitch.model.e r3 = new com.tencent.sqshow.utils.featureswitch.model.e
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 0
            r12 = 0
            r13 = 0
            r14 = 511(0x1ff, float:7.16E-43)
            r15 = 0
            r4 = r3
            r4.<init>(r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15)
            r4 = r16
            goto L48
        L44:
            r4 = r16
            r3 = r20
        L48:
            r4.<init>(r0, r1, r2, r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.sqshow.utils.featureswitch.model.ShowSilverGuideConditionsConfig.<init>(int, com.tencent.sqshow.utils.featureswitch.model.d, int, com.tencent.sqshow.utils.featureswitch.model.e, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
