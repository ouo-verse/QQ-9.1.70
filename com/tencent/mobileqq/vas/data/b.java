package com.tencent.mobileqq.vas.data;

import com.tencent.ecommerce.base.report.api.IECDtReport;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.state.square.data.DressKeys;
import com.tencent.state.square.data.FilamentResource;
import com.tencent.state.square.record.RecordIdentifier;
import com.tencent.zplan.meme.EngineType;
import com.tencent.zplan.meme.action.MODE;
import com.tencent.zplan.meme.model.AvatarCharacterInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001By\u0012\u0006\u0010\u000e\u001a\u00020\t\u0012\u0006\u0010\u0014\u001a\u00020\u000f\u0012\u0006\u0010\u0019\u001a\u00020\u0015\u0012\b\b\u0002\u0010\u001f\u001a\u00020\u001a\u0012\b\b\u0002\u0010#\u001a\u00020\u0007\u0012\b\b\u0002\u0010&\u001a\u00020\u0007\u0012\n\b\u0002\u0010+\u001a\u0004\u0018\u00010'\u0012\n\b\u0002\u0010.\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u00103\u001a\u0004\u0018\u00010/\u0012\n\b\u0002\u00108\u001a\u0004\u0018\u000104\u0012\n\b\u0002\u0010:\u001a\u0004\u0018\u000104\u00a2\u0006\u0004\bH\u0010IJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0014\u001a\u00020\u000f8\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0019\u001a\u00020\u00158\u0006\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0010\u0010\u0018R\u0017\u0010\u001f\u001a\u00020\u001a8\u0006\u00a2\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u0017\u0010#\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b \u0010!\u001a\u0004\b \u0010\"R\u0017\u0010&\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b$\u0010!\u001a\u0004\b%\u0010\"R\u0019\u0010+\u001a\u0004\u0018\u00010'8\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010(\u001a\u0004\b)\u0010*R\u0019\u0010.\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u001d\u0010,\u001a\u0004\b\u0016\u0010-R\u0019\u00103\u001a\u0004\u0018\u00010/8\u0006\u00a2\u0006\f\n\u0004\b0\u00101\u001a\u0004\b\u001b\u00102R\u0019\u00108\u001a\u0004\u0018\u0001048\u0006\u00a2\u0006\f\n\u0004\b%\u00105\u001a\u0004\b6\u00107R\u0019\u0010:\u001a\u0004\u0018\u0001048\u0006\u00a2\u0006\f\n\u0004\b\f\u00105\u001a\u0004\b9\u00107R\u0017\u0010=\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b9\u0010;\u001a\u0004\b\n\u0010<R\u0017\u0010?\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b6\u0010;\u001a\u0004\b>\u0010<R\u0017\u0010C\u001a\u00020@8\u0006\u00a2\u0006\f\n\u0004\b)\u0010A\u001a\u0004\b0\u0010BR\u0017\u0010E\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\bD\u0010;\u001a\u0004\bD\u0010<R\u0017\u0010G\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\bF\u0010;\u001a\u0004\b$\u0010<\u00a8\u0006J"}, d2 = {"Lcom/tencent/mobileqq/vas/data/b;", "", "", "toString", "", "hashCode", "other", "", "equals", "Lcom/tencent/mobileqq/vas/data/a;", "a", "Lcom/tencent/mobileqq/vas/data/a;", "k", "()Lcom/tencent/mobileqq/vas/data/a;", "params", "Lcom/tencent/state/square/record/RecordIdentifier;", "b", "Lcom/tencent/state/square/record/RecordIdentifier;", "g", "()Lcom/tencent/state/square/record/RecordIdentifier;", IECDtReport.ACTION_IDENTIFIER, "Lcom/tencent/state/square/data/DressKeys;", "c", "Lcom/tencent/state/square/data/DressKeys;", "()Lcom/tencent/state/square/data/DressKeys;", "dressKeys", "", "d", "J", tl.h.F, "()J", "initTime", "e", "Z", "()Z", "forceCallback", "f", "j", "needAddToHead", "Lcom/tencent/zplan/meme/EngineType;", "Lcom/tencent/zplan/meme/EngineType;", DomainData.DOMAIN_NAME, "()Lcom/tencent/zplan/meme/EngineType;", "targetEngine", "Ljava/lang/String;", "()Ljava/lang/String;", QQBrowserActivity.APP_PARAM, "Lcom/tencent/state/square/data/FilamentResource;", "i", "Lcom/tencent/state/square/data/FilamentResource;", "()Lcom/tencent/state/square/data/FilamentResource;", "filamentResource", "Lcom/tencent/zplan/meme/model/a;", "Lcom/tencent/zplan/meme/model/a;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "()Lcom/tencent/zplan/meme/model/a;", "senderAvatarCharacterInfo", "l", "receiverAvatarCharacterInfo", "I", "()I", "actionId", "getActionStyle", "actionStyle", "Lcom/tencent/zplan/meme/action/MODE;", "Lcom/tencent/zplan/meme/action/MODE;", "()Lcom/tencent/zplan/meme/action/MODE;", "mode", "o", "width", "p", "height", "<init>", "(Lcom/tencent/mobileqq/vas/data/a;Lcom/tencent/state/square/record/RecordIdentifier;Lcom/tencent/state/square/data/DressKeys;JZZLcom/tencent/zplan/meme/EngineType;Ljava/lang/String;Lcom/tencent/state/square/data/FilamentResource;Lcom/tencent/zplan/meme/model/a;Lcom/tencent/zplan/meme/model/a;)V", "zplan_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final /* data */ class b {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final a params;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final RecordIdentifier identifier;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final DressKeys dressKeys;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final long initTime;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final boolean forceCallback;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final boolean needAddToHead;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final EngineType targetEngine;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final String extraParams;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final FilamentResource filamentResource;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final AvatarCharacterInfo senderAvatarCharacterInfo;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final AvatarCharacterInfo receiverAvatarCharacterInfo;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    private final int actionId;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final int actionStyle;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final MODE mode;

    /* renamed from: o, reason: collision with root package name and from kotlin metadata */
    private final int width;

    /* renamed from: p, reason: collision with root package name and from kotlin metadata */
    private final int height;

    public b(@NotNull a params, @NotNull RecordIdentifier identifier, @NotNull DressKeys dressKeys, long j3, boolean z16, boolean z17, @Nullable EngineType engineType, @Nullable String str, @Nullable FilamentResource filamentResource, @Nullable AvatarCharacterInfo avatarCharacterInfo, @Nullable AvatarCharacterInfo avatarCharacterInfo2) {
        Intrinsics.checkNotNullParameter(params, "params");
        Intrinsics.checkNotNullParameter(identifier, "identifier");
        Intrinsics.checkNotNullParameter(dressKeys, "dressKeys");
        this.params = params;
        this.identifier = identifier;
        this.dressKeys = dressKeys;
        this.initTime = j3;
        this.forceCallback = z16;
        this.needAddToHead = z17;
        this.targetEngine = engineType;
        this.extraParams = str;
        this.filamentResource = filamentResource;
        this.senderAvatarCharacterInfo = avatarCharacterInfo;
        this.receiverAvatarCharacterInfo = avatarCharacterInfo2;
        this.actionId = params.getActionId();
        this.actionStyle = params.getActionStyle();
        this.mode = params.getMode();
        this.width = params.getWidth();
        this.height = params.getHeight();
    }

    /* renamed from: a, reason: from getter */
    public final int getActionId() {
        return this.actionId;
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final DressKeys getDressKeys() {
        return this.dressKeys;
    }

    @Nullable
    /* renamed from: c, reason: from getter */
    public final String getExtraParams() {
        return this.extraParams;
    }

    @Nullable
    /* renamed from: d, reason: from getter */
    public final FilamentResource getFilamentResource() {
        return this.filamentResource;
    }

    /* renamed from: e, reason: from getter */
    public final boolean getForceCallback() {
        return this.forceCallback;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof b)) {
            return false;
        }
        b bVar = (b) other;
        if (Intrinsics.areEqual(this.params, bVar.params) && Intrinsics.areEqual(this.identifier, bVar.identifier) && Intrinsics.areEqual(this.dressKeys, bVar.dressKeys) && this.initTime == bVar.initTime && this.forceCallback == bVar.forceCallback && this.needAddToHead == bVar.needAddToHead && Intrinsics.areEqual(this.targetEngine, bVar.targetEngine) && Intrinsics.areEqual(this.extraParams, bVar.extraParams) && Intrinsics.areEqual(this.filamentResource, bVar.filamentResource) && Intrinsics.areEqual(this.senderAvatarCharacterInfo, bVar.senderAvatarCharacterInfo) && Intrinsics.areEqual(this.receiverAvatarCharacterInfo, bVar.receiverAvatarCharacterInfo)) {
            return true;
        }
        return false;
    }

    /* renamed from: f, reason: from getter */
    public final int getHeight() {
        return this.height;
    }

    @NotNull
    /* renamed from: g, reason: from getter */
    public final RecordIdentifier getIdentifier() {
        return this.identifier;
    }

    /* renamed from: h, reason: from getter */
    public final long getInitTime() {
        return this.initTime;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode;
        int hashCode2;
        int hashCode3;
        int hashCode4;
        int hashCode5 = ((((((this.params.hashCode() * 31) + this.identifier.hashCode()) * 31) + this.dressKeys.hashCode()) * 31) + androidx.fragment.app.a.a(this.initTime)) * 31;
        boolean z16 = this.forceCallback;
        int i3 = 1;
        int i16 = z16;
        if (z16 != 0) {
            i16 = 1;
        }
        int i17 = (hashCode5 + i16) * 31;
        boolean z17 = this.needAddToHead;
        if (!z17) {
            i3 = z17 ? 1 : 0;
        }
        int i18 = (i17 + i3) * 31;
        EngineType engineType = this.targetEngine;
        int i19 = 0;
        if (engineType == null) {
            hashCode = 0;
        } else {
            hashCode = engineType.hashCode();
        }
        int i26 = (i18 + hashCode) * 31;
        String str = this.extraParams;
        if (str == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = str.hashCode();
        }
        int i27 = (i26 + hashCode2) * 31;
        FilamentResource filamentResource = this.filamentResource;
        if (filamentResource == null) {
            hashCode3 = 0;
        } else {
            hashCode3 = filamentResource.hashCode();
        }
        int i28 = (i27 + hashCode3) * 31;
        AvatarCharacterInfo avatarCharacterInfo = this.senderAvatarCharacterInfo;
        if (avatarCharacterInfo == null) {
            hashCode4 = 0;
        } else {
            hashCode4 = avatarCharacterInfo.hashCode();
        }
        int i29 = (i28 + hashCode4) * 31;
        AvatarCharacterInfo avatarCharacterInfo2 = this.receiverAvatarCharacterInfo;
        if (avatarCharacterInfo2 != null) {
            i19 = avatarCharacterInfo2.hashCode();
        }
        return i29 + i19;
    }

    @NotNull
    /* renamed from: i, reason: from getter */
    public final MODE getMode() {
        return this.mode;
    }

    /* renamed from: j, reason: from getter */
    public final boolean getNeedAddToHead() {
        return this.needAddToHead;
    }

    @NotNull
    /* renamed from: k, reason: from getter */
    public final a getParams() {
        return this.params;
    }

    @Nullable
    /* renamed from: l, reason: from getter */
    public final AvatarCharacterInfo getReceiverAvatarCharacterInfo() {
        return this.receiverAvatarCharacterInfo;
    }

    @Nullable
    /* renamed from: m, reason: from getter */
    public final AvatarCharacterInfo getSenderAvatarCharacterInfo() {
        return this.senderAvatarCharacterInfo;
    }

    @Nullable
    /* renamed from: n, reason: from getter */
    public final EngineType getTargetEngine() {
        return this.targetEngine;
    }

    /* renamed from: o, reason: from getter */
    public final int getWidth() {
        return this.width;
    }

    @NotNull
    public String toString() {
        return "{p:" + this.params + ", i:" + this.identifier + ", f:" + this.forceCallback + ", n:" + this.needAddToHead + ", iT:" + this.initTime + ", d:" + this.dressKeys + '}';
    }

    public /* synthetic */ b(a aVar, RecordIdentifier recordIdentifier, DressKeys dressKeys, long j3, boolean z16, boolean z17, EngineType engineType, String str, FilamentResource filamentResource, AvatarCharacterInfo avatarCharacterInfo, AvatarCharacterInfo avatarCharacterInfo2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(aVar, recordIdentifier, dressKeys, (i3 & 8) != 0 ? System.nanoTime() : j3, (i3 & 16) != 0 ? false : z16, (i3 & 32) != 0 ? false : z17, (i3 & 64) != 0 ? null : engineType, (i3 & 128) != 0 ? null : str, (i3 & 256) != 0 ? null : filamentResource, (i3 & 512) != 0 ? null : avatarCharacterInfo, (i3 & 1024) != 0 ? null : avatarCharacterInfo2);
    }
}
