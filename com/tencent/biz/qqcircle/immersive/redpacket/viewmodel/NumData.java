package com.tencent.biz.qqcircle.immersive.redpacket.viewmodel;

import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u000f\b\u0086\b\u0018\u0000 \u00032\u00020\u0001:\u0001\u000fB\u001f\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u000b\u00a2\u0006\u0004\b\u0018\u0010\u0019J\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0004\u001a\u00020\u0002J\u0006\u0010\u0005\u001a\u00020\u0002J\u0006\u0010\u0006\u001a\u00020\u0002J\u0006\u0010\u0007\u001a\u00020\u0002J\u0006\u0010\b\u001a\u00020\u0002J\t\u0010\n\u001a\u00020\tH\u00d6\u0001J\t\u0010\f\u001a\u00020\u000bH\u00d6\u0001J\u0013\u0010\u000e\u001a\u00020\u00022\b\u0010\r\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R$\u0010\u0015\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R$\u0010\u0017\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\u0010\u001a\u0004\b\u000f\u0010\u0012\"\u0004\b\u0016\u0010\u0014\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/redpacket/viewmodel/b;", "", "", "c", "d", "g", tl.h.F, "e", "f", "", "toString", "", "hashCode", "other", "equals", "a", "Ljava/lang/Integer;", "b", "()Ljava/lang/Integer;", "j", "(Ljava/lang/Integer;)V", "remainNum", "i", "feedNum", "<init>", "(Ljava/lang/Integer;Ljava/lang/Integer;)V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.biz.qqcircle.immersive.redpacket.viewmodel.b, reason: from toString */
/* loaded from: classes4.dex */
public final /* data */ class NumData {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private volatile Integer remainNum;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private volatile Integer feedNum;

    public NumData() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    @Nullable
    /* renamed from: a, reason: from getter */
    public final Integer getFeedNum() {
        return this.feedNum;
    }

    @Nullable
    /* renamed from: b, reason: from getter */
    public final Integer getRemainNum() {
        return this.remainNum;
    }

    public final boolean c() {
        if (this.remainNum != null && this.feedNum != null) {
            return true;
        }
        return false;
    }

    public final boolean d() {
        if (!g() && !e()) {
            return false;
        }
        return true;
    }

    public final boolean e() {
        Integer num = this.feedNum;
        if (num != null && num.intValue() == -1) {
            return true;
        }
        return false;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof NumData)) {
            return false;
        }
        NumData numData = (NumData) other;
        if (Intrinsics.areEqual(this.remainNum, numData.remainNum) && Intrinsics.areEqual(this.feedNum, numData.feedNum)) {
            return true;
        }
        return false;
    }

    public final boolean f() {
        if (!e() && this.feedNum != null) {
            return false;
        }
        return true;
    }

    public final boolean g() {
        Integer num = this.remainNum;
        if (num != null && num.intValue() == -1) {
            return true;
        }
        return false;
    }

    public final boolean h() {
        if (!g() && this.remainNum != null) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int hashCode;
        int i3 = 0;
        if (this.remainNum == null) {
            hashCode = 0;
        } else {
            hashCode = this.remainNum.hashCode();
        }
        int i16 = hashCode * 31;
        if (this.feedNum != null) {
            i3 = this.feedNum.hashCode();
        }
        return i16 + i3;
    }

    public final void i(@Nullable Integer num) {
        this.feedNum = num;
    }

    public final void j(@Nullable Integer num) {
        this.remainNum = num;
    }

    @NotNull
    public String toString() {
        return "NumData(remainNum=" + this.remainNum + ", feedNum=" + this.feedNum + ")";
    }

    public NumData(@Nullable Integer num, @Nullable Integer num2) {
        this.remainNum = num;
        this.feedNum = num2;
        boolean z16 = QzoneConfig.getInstance().getConfig("qqcircle", "red_packet_not_allow_fetch_feed", 0) == 1;
        QLog.d("NumData", 1, "init, notAllowFetchFeed:" + z16);
        this.feedNum = z16 ? 0 : null;
    }

    public /* synthetic */ NumData(Integer num, Integer num2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? null : num, (i3 & 2) != 0 ? null : num2);
    }
}
