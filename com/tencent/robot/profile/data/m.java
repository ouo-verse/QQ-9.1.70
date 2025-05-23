package com.tencent.robot.profile.data;

import com.heytap.databaseengine.apiv3.data.Element;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0013\u0018\u0000 \u001f2\u00020\u0001:\u0001'BE\u0012\u0006\u0010\r\u001a\u00020\u0007\u0012\u0006\u0010\u0013\u001a\u00020\u000e\u0012\u0006\u0010\u0014\u001a\u00020\u000e\u0012\u0006\u0010\u0019\u001a\u00020\u0015\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u0005\u0012\b\b\u0002\u0010!\u001a\u00020\u0007\u0012\b\b\u0002\u0010$\u001a\u00020\u0007\u00a2\u0006\u0004\b%\u0010&J\u0006\u0010\u0002\u001a\u00020\u0000J\u0013\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0096\u0002J\u0006\u0010\b\u001a\u00020\u0007R\u0017\u0010\r\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\u0013\u001a\u00020\u000e8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0014\u001a\u00020\u000e8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\b\u0010\u0010\u001a\u0004\b\t\u0010\u0012R\u001a\u0010\u0019\u001a\u00020\u00158\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0002\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0017\u0010\u001d\u001a\u00020\u00058\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\"\u0010!\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001b\u0010\n\u001a\u0004\b\u001e\u0010\f\"\u0004\b\u001f\u0010 R\"\u0010$\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\"\u0010\n\u001a\u0004\b#\u0010\f\"\u0004\b\"\u0010 \u00a8\u0006("}, d2 = {"Lcom/tencent/robot/profile/data/m;", "Lcom/tencent/robot/profile/data/g;", "i", "", "other", "", "equals", "", tl.h.F, "f", "I", "j", "()I", Element.ELEMENT_NAME_DISTANCE, "", "g", "Ljava/lang/String;", "e", "()Ljava/lang/String;", "robotUin", "troopUin", "Lcom/tencent/robot/profile/data/h;", "Lcom/tencent/robot/profile/data/h;", "c", "()Lcom/tencent/robot/profile/data/h;", "color", "Z", "k", "()Z", "needReverseEmpty", "getNavBarHeight", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "(I)V", "navBarHeight", "l", "getBottomLayoutHeight", "bottomLayoutHeight", "<init>", "(ILjava/lang/String;Ljava/lang/String;Lcom/tencent/robot/profile/data/h;ZII)V", "a", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class m extends g {

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final int distance;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String robotUin;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String troopUin;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final RobotProfileColor color;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    private final boolean needReverseEmpty;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    private int navBarHeight;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    private int bottomLayoutHeight;

    public /* synthetic */ m(int i3, String str, String str2, RobotProfileColor robotProfileColor, boolean z16, int i16, int i17, int i18, DefaultConstructorMarker defaultConstructorMarker) {
        this(i3, str, str2, robotProfileColor, (i18 & 16) != 0 ? false : z16, (i18 & 32) != 0 ? 0 : i16, (i18 & 64) != 0 ? 0 : i17);
    }

    @Override // com.tencent.robot.profile.data.g
    @NotNull
    /* renamed from: c, reason: from getter */
    public RobotProfileColor getColor() {
        return this.color;
    }

    @Override // com.tencent.robot.profile.data.g
    @NotNull
    /* renamed from: e, reason: from getter */
    public String getRobotUin() {
        return this.robotUin;
    }

    @Override // com.tencent.robot.profile.data.g
    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.robot.profile.data.g
    @NotNull
    /* renamed from: f, reason: from getter */
    public String getTroopUin() {
        return this.troopUin;
    }

    public final int h() {
        int i3 = this.bottomLayoutHeight;
        if (i3 == 0) {
            i3 = this.navBarHeight;
        }
        QLog.i("RobotProfileSpaceData", 2, "[bottomHeight] : bottomHeight: " + i3);
        return i3;
    }

    @NotNull
    public final m i() {
        return new m(this.distance, getRobotUin(), getTroopUin(), getColor(), this.needReverseEmpty, this.navBarHeight, this.bottomLayoutHeight);
    }

    /* renamed from: j, reason: from getter */
    public final int getDistance() {
        return this.distance;
    }

    /* renamed from: k, reason: from getter */
    public final boolean getNeedReverseEmpty() {
        return this.needReverseEmpty;
    }

    public final void l(int i3) {
        this.bottomLayoutHeight = i3;
    }

    public final void m(int i3) {
        this.navBarHeight = i3;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m(int i3, @NotNull String robotUin, @NotNull String troopUin, @NotNull RobotProfileColor color, boolean z16, int i16, int i17) {
        super("Space", robotUin, troopUin, color, null);
        Intrinsics.checkNotNullParameter(robotUin, "robotUin");
        Intrinsics.checkNotNullParameter(troopUin, "troopUin");
        Intrinsics.checkNotNullParameter(color, "color");
        this.distance = i3;
        this.robotUin = robotUin;
        this.troopUin = troopUin;
        this.color = color;
        this.needReverseEmpty = z16;
        this.navBarHeight = i16;
        this.bottomLayoutHeight = i17;
    }
}
