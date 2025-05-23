package com.tencent.sqshow.zootopia.friendsdressup.widget;

import android.view.animation.Interpolator;
import com.heytap.databaseengine.model.UserInfo;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u000e\b\u0000\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\u0006\u0010\r\u001a\u00020\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R\u0014\u0010\u0007\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0006R\u0014\u0010\t\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0006R\u0014\u0010\u000b\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0006R\u0014\u0010\r\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\u0006\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/sqshow/zootopia/friendsdressup/widget/a;", "Landroid/view/animation/Interpolator;", "", "t", "getInterpolation", "a", UserInfo.SEX_FEMALE, "x1", "b", "y1", "c", "x2", "d", "y2", "<init>", "(FFFF)V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class a implements Interpolator {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final float x1;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final float y1;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final float x2;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final float y2;

    public a(float f16, float f17, float f18, float f19) {
        this.x1 = f16;
        this.y1 = f17;
        this.x2 = f18;
        this.y2 = f19;
    }

    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float t16) {
        double d16 = t16;
        return (float) ((3 * Math.pow(1 - t16, 2.0d) * d16 * this.y1) + (3 * r3 * Math.pow(d16, 2.0d) * this.y2) + Math.pow(d16, 3.0d));
    }
}
