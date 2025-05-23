package com.tencent.sqshow.zootopia.samestyle.data;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\r\u0018\u0000 \u00122\u00020\u0001:\u0001\u0013B)\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\f\u001a\u00020\u0007\u0012\u0006\u0010\u000e\u001a\u00020\u0007\u00a2\u0006\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0003\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\b\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u0017\u0010\f\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\t\u001a\u0004\b\r\u0010\u000bR\u0017\u0010\u000e\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\t\u001a\u0004\b\u000f\u0010\u000b\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/sqshow/zootopia/samestyle/data/ZPlanTemplateFixedRoleConfig;", "Ljava/io/Serializable;", "", "fixedFlag", "I", "getFixedFlag", "()I", "", "masterUin", "Ljava/lang/String;", "getMasterUin", "()Ljava/lang/String;", "guestUin", "getGuestUin", "masterNickName", "getMasterNickName", "<init>", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "Companion", "a", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class ZPlanTemplateFixedRoleConfig implements Serializable {
    public static final int FIXED_ROLE = 1;
    public static final int UN_FIXED_ROLE = 0;
    private final int fixedFlag;
    private final String guestUin;
    private final String masterNickName;
    private final String masterUin;

    public ZPlanTemplateFixedRoleConfig(int i3, String masterUin, String guestUin, String masterNickName) {
        Intrinsics.checkNotNullParameter(masterUin, "masterUin");
        Intrinsics.checkNotNullParameter(guestUin, "guestUin");
        Intrinsics.checkNotNullParameter(masterNickName, "masterNickName");
        this.fixedFlag = i3;
        this.masterUin = masterUin;
        this.guestUin = guestUin;
        this.masterNickName = masterNickName;
    }

    public final int getFixedFlag() {
        return this.fixedFlag;
    }

    public final String getGuestUin() {
        return this.guestUin;
    }

    public final String getMasterNickName() {
        return this.masterNickName;
    }

    public final String getMasterUin() {
        return this.masterUin;
    }

    public /* synthetic */ ZPlanTemplateFixedRoleConfig(int i3, String str, String str2, String str3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this((i16 & 1) != 0 ? 1 : i3, str, str2, str3);
    }
}
