package com.qzone.business.tianshu;

import androidx.lifecycle.MutableLiveData;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.mobileqq.pb.PBUInt32Field;
import cooperation.vip.pb.TianShuAccess;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.util.WeakReference;
import q5.QZoneFloatPlusBubbleInfo;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0014\u0010\u000b\u001a\u00020\n2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00020\bJ\u000e\u0010\f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\r\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u0002\u00a8\u0006\u0010"}, d2 = {"Lcom/qzone/business/tianshu/d;", "", "Lq5/b;", "bubbleInfo", "", "d", "", "c", "Landroidx/lifecycle/MutableLiveData;", "bubbleLiveData", "", "b", "a", "e", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes39.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public static final d f44862a = new d();

    d() {
    }

    private final String c(QZoneFloatPlusBubbleInfo bubbleInfo) {
        PBUInt32Field pBUInt32Field;
        TianShuAccess.AdItem adItem = bubbleInfo.getAdItem();
        String str = "qzone_float_plus_bubble_is_clicked_" + ((adItem == null || (pBUInt32Field = adItem.iAdId) == null) ? null : Integer.valueOf(pBUInt32Field.get()));
        RFWLog.d("QZoneFloatPlusBubbleController", RFWLog.USR, "bubble clicked mmkvKey " + str + "}");
        return str;
    }

    private final boolean d(QZoneFloatPlusBubbleInfo bubbleInfo) {
        return com.qzone.reborn.util.i.b().d(c(bubbleInfo), false);
    }

    public final boolean a(QZoneFloatPlusBubbleInfo bubbleInfo) {
        Intrinsics.checkNotNullParameter(bubbleInfo, "bubbleInfo");
        return bubbleInfo.getReddot() && !d(bubbleInfo);
    }

    public final void b(MutableLiveData<QZoneFloatPlusBubbleInfo> bubbleLiveData) {
        Intrinsics.checkNotNullParameter(bubbleLiveData, "bubbleLiveData");
        f fVar = f.f44865b;
        fVar.l(new WeakReference<>(bubbleLiveData));
        fVar.a();
    }

    public final void e(QZoneFloatPlusBubbleInfo bubbleInfo) {
        Intrinsics.checkNotNullParameter(bubbleInfo, "bubbleInfo");
        com.qzone.reborn.util.i.b().l(c(bubbleInfo), true);
    }
}
