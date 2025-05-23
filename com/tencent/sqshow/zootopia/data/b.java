package com.tencent.sqshow.zootopia.data;

import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0002\b\n\u0018\u0000  2\u00020\u0001:\u0001\u0004BA\u0012\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u000b\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u000b\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u000b\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u0017\u00a2\u0006\u0004\b\u001e\u0010\u001fR(\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\"\u0010\u0010\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0006\u0010\f\u001a\u0004\b\u0004\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0014\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\f\u001a\u0004\b\u0012\u0010\r\"\u0004\b\u0013\u0010\u000fR\"\u0010\u0016\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0012\u0010\f\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0015\u0010\u000fR$\u0010\u001d\u001a\u0004\u0018\u00010\u00178\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u0018\u0010\u001a\"\u0004\b\u001b\u0010\u001c\u00a8\u0006!"}, d2 = {"Lcom/tencent/sqshow/zootopia/data/b;", "", "", "Lcom/tencent/sqshow/zootopia/data/w;", "a", "Ljava/util/List;", "b", "()Ljava/util/List;", "setReward", "(Ljava/util/List;)V", "reward", "", "I", "()I", "setQuestAmount", "(I)V", "questAmount", "c", "d", "setRewardStatus", "rewardStatus", "setRewardIndex", "rewardIndex", "", "e", "Ljava/lang/String;", "()Ljava/lang/String;", "setStatusIcon", "(Ljava/lang/String;)V", "statusIcon", "<init>", "(Ljava/util/List;IIILjava/lang/String;)V", "f", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class b {

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private List<ZootopiaTaskRewardInfo> reward;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private int questAmount;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private int rewardStatus;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private int rewardIndex;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private String statusIcon;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002\u00a8\u0006\b"}, d2 = {"Lcom/tencent/sqshow/zootopia/data/b$a;", "", "Lxv4/e;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "Lcom/tencent/sqshow/zootopia/data/b;", "a", "<init>", "()V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.sqshow.zootopia.data.b$a, reason: from kotlin metadata */
    /* loaded from: classes34.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final b a(xv4.e item) {
            Intrinsics.checkNotNullParameter(item, "item");
            xv4.z[] zVarArr = item.f448789a;
            Intrinsics.checkNotNullExpressionValue(zVarArr, "item.reward");
            ArrayList arrayList = new ArrayList(zVarArr.length);
            for (xv4.z zVar : zVarArr) {
                arrayList.add(ZootopiaTaskRewardInfo.INSTANCE.a(zVar));
            }
            return new b(arrayList, item.f448790b, item.f448791c, item.f448792d, item.f448793e);
        }

        Companion() {
        }
    }

    public b() {
        this(null, 0, 0, 0, null, 31, null);
    }

    /* renamed from: a, reason: from getter */
    public final int getQuestAmount() {
        return this.questAmount;
    }

    public final List<ZootopiaTaskRewardInfo> b() {
        return this.reward;
    }

    /* renamed from: c, reason: from getter */
    public final int getRewardIndex() {
        return this.rewardIndex;
    }

    /* renamed from: d, reason: from getter */
    public final int getRewardStatus() {
        return this.rewardStatus;
    }

    /* renamed from: e, reason: from getter */
    public final String getStatusIcon() {
        return this.statusIcon;
    }

    public b(List<ZootopiaTaskRewardInfo> reward, int i3, int i16, int i17, String str) {
        Intrinsics.checkNotNullParameter(reward, "reward");
        this.reward = reward;
        this.questAmount = i3;
        this.rewardStatus = i16;
        this.rewardIndex = i17;
        this.statusIcon = str;
    }

    public /* synthetic */ b(List list, int i3, int i16, int i17, String str, int i18, DefaultConstructorMarker defaultConstructorMarker) {
        this((i18 & 1) != 0 ? new ArrayList() : list, (i18 & 2) != 0 ? 0 : i3, (i18 & 4) != 0 ? 0 : i16, (i18 & 8) == 0 ? i17 : 0, (i18 & 16) != 0 ? null : str);
    }
}
