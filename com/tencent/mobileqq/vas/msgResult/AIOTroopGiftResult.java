package com.tencent.mobileqq.vas.msgResult;

import com.tencent.mvi.base.route.k;
import com.tencent.trpcprotocol.qqva.va_group_gift.service.GroupGiftBirth$UserBirth;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0001\u0004B\t\b\u0004\u00a2\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0001\u0005\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/mobileqq/vas/msgResult/AIOTroopGiftResult;", "Lcom/tencent/mvi/base/route/k;", "<init>", "()V", "GetBirthDataResult", "Lcom/tencent/mobileqq/vas/msgResult/AIOTroopGiftResult$GetBirthDataResult;", "vas_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public abstract class AIOTroopGiftResult implements k {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u00a2\u0006\u0002\u0010\u0005J\u000f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u00c6\u0003J\u0019\u0010\t\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u00c6\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u00d6\u0003J\t\u0010\u000e\u001a\u00020\u000fH\u00d6\u0001J\t\u0010\u0010\u001a\u00020\u0011H\u00d6\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/vas/msgResult/AIOTroopGiftResult$GetBirthDataResult;", "Lcom/tencent/mobileqq/vas/msgResult/AIOTroopGiftResult;", "birthData", "", "Lcom/tencent/trpcprotocol/qqva/va_group_gift/service/GroupGiftBirth$UserBirth;", "(Ljava/util/List;)V", "getBirthData", "()Ljava/util/List;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "vas_api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes20.dex */
    public static final /* data */ class GetBirthDataResult extends AIOTroopGiftResult {

        @NotNull
        private final List<GroupGiftBirth$UserBirth> birthData;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public GetBirthDataResult(@NotNull List<GroupGiftBirth$UserBirth> birthData) {
            super(null);
            Intrinsics.checkNotNullParameter(birthData, "birthData");
            this.birthData = birthData;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ GetBirthDataResult copy$default(GetBirthDataResult getBirthDataResult, List list, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                list = getBirthDataResult.birthData;
            }
            return getBirthDataResult.copy(list);
        }

        @NotNull
        public final List<GroupGiftBirth$UserBirth> component1() {
            return this.birthData;
        }

        @NotNull
        public final GetBirthDataResult copy(@NotNull List<GroupGiftBirth$UserBirth> birthData) {
            Intrinsics.checkNotNullParameter(birthData, "birthData");
            return new GetBirthDataResult(birthData);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if ((other instanceof GetBirthDataResult) && Intrinsics.areEqual(this.birthData, ((GetBirthDataResult) other).birthData)) {
                return true;
            }
            return false;
        }

        @NotNull
        public final List<GroupGiftBirth$UserBirth> getBirthData() {
            return this.birthData;
        }

        public int hashCode() {
            return this.birthData.hashCode();
        }

        @NotNull
        public String toString() {
            return "GetBirthDataResult(birthData=" + this.birthData + ")";
        }
    }

    public /* synthetic */ AIOTroopGiftResult(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    AIOTroopGiftResult() {
    }
}
