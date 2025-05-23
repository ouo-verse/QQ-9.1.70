package com.tencent.mobileqq.zplan.model;

import com.tencent.mobileqq.persistence.ConflictClause;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.uniqueConstraints;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.zplan.utils.featureswitch.api.IZPlanFeatureSwitchHelper;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@uniqueConstraints(clause = ConflictClause.REPLACE, columnNames = "uin")
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\r\b\u0007\u0018\u0000 \u00162\u00020\u0001:\u0001\u0017B-\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0004\u0012\b\b\u0002\u0010\t\u001a\u00020\b\u0012\b\b\u0002\u0010\f\u001a\u00020\u000b\u00a2\u0006\u0004\b\u0013\u0010\u0014B\t\b\u0016\u00a2\u0006\u0004\b\u0013\u0010\u0015J\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\u0005\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0006R\u0016\u0010\u0007\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0006R\u0016\u0010\t\u001a\u00020\b8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0016\u0010\f\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR$\u0010\u000e\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000e\u0010\u0006\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/zplan/model/ZPlanUserInfo;", "Lcom/tencent/mobileqq/persistence/Entity;", "", "hasCustomDressUp", "", "uin", "Ljava/lang/String;", "appearanceKey", "", "appearanceTimeStamp", "J", "", "gender", "I", "name", "getName", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "<init>", "(Ljava/lang/String;Ljava/lang/String;JI)V", "()V", "Companion", "a", "zplan_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class ZPlanUserInfo extends Entity {

    @NotNull
    private static final String OFFICIAL_APPEARANCE_KEY = ((IZPlanFeatureSwitchHelper) QRoute.api(IZPlanFeatureSwitchHelper.class)).getOfficialAppearanceKey();
    private static final long OFFICIAL_APPEARANCE_TIMESTAMP = ((IZPlanFeatureSwitchHelper) QRoute.api(IZPlanFeatureSwitchHelper.class)).getOfficialAppearanceKeyTimeStamp();

    @JvmField
    @NotNull
    public String appearanceKey;

    @JvmField
    public long appearanceTimeStamp;

    @JvmField
    public int gender;

    @Nullable
    private String name;

    @JvmField
    @NotNull
    public final String uin;

    public /* synthetic */ ZPlanUserInfo(String str, String str2, long j3, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i16 & 2) != 0 ? OFFICIAL_APPEARANCE_KEY : str2, (i16 & 4) != 0 ? OFFICIAL_APPEARANCE_TIMESTAMP : j3, (i16 & 8) != 0 ? 0 : i3);
    }

    @Nullable
    public final String getName() {
        return this.name;
    }

    public final boolean hasCustomDressUp() {
        boolean z16;
        if (this.appearanceKey.length() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16 && !Intrinsics.areEqual(this.appearanceKey, OFFICIAL_APPEARANCE_KEY)) {
            return true;
        }
        return false;
    }

    public final void setName(@Nullable String str) {
        this.name = str;
    }

    public ZPlanUserInfo(@NotNull String uin, @NotNull String appearanceKey, long j3, int i3) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        Intrinsics.checkNotNullParameter(appearanceKey, "appearanceKey");
        this.uin = uin;
        this.appearanceKey = appearanceKey;
        this.appearanceTimeStamp = j3;
        this.gender = i3;
    }

    public ZPlanUserInfo() {
        this("", null, 0L, 0, 14, null);
    }
}
