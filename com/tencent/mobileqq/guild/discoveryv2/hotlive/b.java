package com.tencent.mobileqq.guild.discoveryv2.hotlive;

import com.tencent.biz.richframework.delegate.impl.RFWApplication;
import com.tencent.mobileqq.guild.util.cw;
import com.tencent.mobileqq.util.x;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.ranges.RangesKt___RangesKt;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0013\u0018\u0000 \u00072\u00020\u0001:\u0001\tB\u0007\u00a2\u0006\u0004\b\u0015\u0010\u0016J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0006\u0010\u0005\u001a\u00020\u0004J\u000e\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002R$\u0010\r\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00028\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR$\u0010\u0010\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00028\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b\u000e\u0010\n\u001a\u0004\b\u000f\u0010\fR$\u0010\u0012\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00028\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b\u0011\u0010\n\u001a\u0004\b\u0011\u0010\fR$\u0010\u0013\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00028\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b\u0003\u0010\n\u001a\u0004\b\u000e\u0010\fR$\u0010\u0014\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00028\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b\u000b\u0010\n\u001a\u0004\b\t\u0010\f\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/mobileqq/guild/discoveryv2/hotlive/b;", "", "", "d", "", "g", "screenWidth", "f", "<set-?>", "a", "I", "e", "()I", "mostCardCnt", "b", "getCardWidth", "cardWidth", "c", "cardHeight", "avatarSize", "avatarHorizontalSpacing", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private int mostCardCnt;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private int cardWidth;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private int cardHeight;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private int avatarSize;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private int avatarHorizontalSpacing;

    private final int d() {
        return x.f(BaseApplication.getContext()).b();
    }

    /* renamed from: a, reason: from getter */
    public final int getAvatarHorizontalSpacing() {
        return this.avatarHorizontalSpacing;
    }

    /* renamed from: b, reason: from getter */
    public final int getAvatarSize() {
        return this.avatarSize;
    }

    /* renamed from: c, reason: from getter */
    public final int getCardHeight() {
        return this.cardHeight;
    }

    /* renamed from: e, reason: from getter */
    public final int getMostCardCnt() {
        return this.mostCardCnt;
    }

    public final void f(int screenWidth) {
        int coerceIn;
        int coerceAtLeast;
        int coerceAtMost;
        int coerceAtMost2;
        int d16 = (int) cw.d(32);
        int d17 = (int) cw.d(8);
        int i3 = screenWidth - d16;
        coerceIn = RangesKt___RangesKt.coerceIn((i3 + d17) / (((int) cw.d(194)) + d17), 2, 5);
        this.mostCardCnt = coerceIn;
        int i16 = (i3 - (d17 * (coerceIn - 1))) / coerceIn;
        this.cardWidth = i16;
        coerceAtLeast = RangesKt___RangesKt.coerceAtLeast((i16 * 146) / 194, (int) cw.d(146));
        this.cardHeight = coerceAtLeast;
        int d18 = this.cardWidth - ((int) cw.d(11));
        coerceAtMost = RangesKt___RangesKt.coerceAtMost((d18 * 4) / 126, (int) cw.d(4));
        this.avatarHorizontalSpacing = coerceAtMost;
        coerceAtMost2 = RangesKt___RangesKt.coerceAtMost((d18 * 38) / 126, (int) cw.d(38));
        this.avatarSize = coerceAtMost2;
        QLog.e("GridLayoutHelper", 1, "mostCardCnt=" + this.mostCardCnt + " screenWidth:" + screenWidth + "  orientation=" + RFWApplication.getApplication().getResources().getConfiguration().orientation);
    }

    public final void g() {
        f(d());
    }
}
