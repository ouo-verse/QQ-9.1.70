package com.tencent.sqshow.zootopia.samestyle;

import android.content.Context;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.qphone.base.util.BaseApplication;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0015\n\u0002\u0010\u0007\n\u0002\b\u0010\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b*\u0010+J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\"\u0010\r\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\"\u0010\u0011\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000e\u0010\b\u001a\u0004\b\u000f\u0010\n\"\u0004\b\u0010\u0010\fR\"\u0010\u0014\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\b\u001a\u0004\b\u0012\u0010\n\"\u0004\b\u0013\u0010\fR\"\u0010\u0018\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0015\u0010\b\u001a\u0004\b\u0016\u0010\n\"\u0004\b\u0017\u0010\fR\"\u0010\u001b\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0019\u0010\b\u001a\u0004\b\u0019\u0010\n\"\u0004\b\u001a\u0010\fR\"\u0010\"\u001a\u00020\u001c8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0016\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\"\u0010$\u001a\u00020\u001c8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0012\u0010\u001d\u001a\u0004\b\u0007\u0010\u001f\"\u0004\b#\u0010!R\"\u0010&\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\b\u001a\u0004\b\u000e\u0010\n\"\u0004\b%\u0010\fR\"\u0010)\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b'\u0010\b\u001a\u0004\b\u0015\u0010\n\"\u0004\b(\u0010\f\u00a8\u0006,"}, d2 = {"Lcom/tencent/sqshow/zootopia/samestyle/q;", "", "Landroid/content/Context;", "context", "", tl.h.F, "", "a", "I", "c", "()I", "setMLeftAndRightMarin", "(I)V", "mLeftAndRightMarin", "b", "getMMidGap", "setMMidGap", "mMidGap", "g", "setMSpanCount", "mSpanCount", "d", "f", "setMSingleWidth", "mSingleWidth", "e", "setMSinglePicHeight", "mSinglePicHeight", "", UserInfo.SEX_FEMALE, "getMPicHWRate", "()F", "setMPicHWRate", "(F)V", "mPicHWRate", "setMItemRadius", "mItemRadius", "setMItemTopMargin", "mItemTopMargin", "i", "setMRightItemLeftMargin", "mRightItemLeftMargin", "<init>", "()V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class q {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private int mSingleWidth;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private int mSinglePicHeight;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private int mRightItemLeftMargin;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private int mLeftAndRightMarin = com.tencent.sqshow.zootopia.utils.i.a(16.0f);

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private int mMidGap = com.tencent.sqshow.zootopia.utils.i.a(8.0f);

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private int mSpanCount = 2;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private float mPicHWRate = 1.18f;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private float mItemRadius = com.tencent.sqshow.zootopia.utils.i.d(8.0f);

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private int mItemTopMargin = com.tencent.sqshow.zootopia.utils.i.a(8.0f);

    public q() {
        BaseApplication ctx = BaseApplication.context;
        Intrinsics.checkNotNullExpressionValue(ctx, "ctx");
        h(ctx);
    }

    /* renamed from: a, reason: from getter */
    public final float getMItemRadius() {
        return this.mItemRadius;
    }

    /* renamed from: b, reason: from getter */
    public final int getMItemTopMargin() {
        return this.mItemTopMargin;
    }

    /* renamed from: c, reason: from getter */
    public final int getMLeftAndRightMarin() {
        return this.mLeftAndRightMarin;
    }

    /* renamed from: d, reason: from getter */
    public final int getMRightItemLeftMargin() {
        return this.mRightItemLeftMargin;
    }

    /* renamed from: e, reason: from getter */
    public final int getMSinglePicHeight() {
        return this.mSinglePicHeight;
    }

    /* renamed from: f, reason: from getter */
    public final int getMSingleWidth() {
        return this.mSingleWidth;
    }

    /* renamed from: g, reason: from getter */
    public final int getMSpanCount() {
        return this.mSpanCount;
    }

    public final void h(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        int c16 = t74.u.INSTANCE.c(context);
        int i3 = this.mLeftAndRightMarin;
        int i16 = (c16 - (i3 * 2)) - this.mMidGap;
        int i17 = this.mSpanCount;
        int i18 = i16 / i17;
        this.mSingleWidth = i18;
        this.mSinglePicHeight = (int) (i18 * this.mPicHWRate);
        this.mRightItemLeftMargin = ((c16 / i17) - i18) - i3;
    }
}
