package com.qzone.reborn.message.data;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import qzone.QZIntimateSpaceReader$StNotice;
import qzone.QZoneBaseCommon$StCommonExt;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\u0006\u0010\u000f\u001a\u00020\n\u00a2\u0006\u0004\b\u0010\u0010\u0011R\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\u000f\u001a\u00020\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\u000b\u001a\u0004\b\u0003\u0010\f\"\u0004\b\r\u0010\u000e\u00a8\u0006\u0012"}, d2 = {"Lcom/qzone/reborn/message/data/a;", "", "Lqzone/QZIntimateSpaceReader$StNotice;", "a", "Lqzone/QZIntimateSpaceReader$StNotice;", "b", "()Lqzone/QZIntimateSpaceReader$StNotice;", "setStNotice", "(Lqzone/QZIntimateSpaceReader$StNotice;)V", "stNotice", "Lqzone/QZoneBaseCommon$StCommonExt;", "Lqzone/QZoneBaseCommon$StCommonExt;", "()Lqzone/QZoneBaseCommon$StCommonExt;", "setStCommonExt", "(Lqzone/QZoneBaseCommon$StCommonExt;)V", "stCommonExt", "<init>", "(Lqzone/QZIntimateSpaceReader$StNotice;Lqzone/QZoneBaseCommon$StCommonExt;)V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private QZIntimateSpaceReader$StNotice stNotice;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private QZoneBaseCommon$StCommonExt stCommonExt;

    public a(QZIntimateSpaceReader$StNotice stNotice, QZoneBaseCommon$StCommonExt stCommonExt) {
        Intrinsics.checkNotNullParameter(stNotice, "stNotice");
        Intrinsics.checkNotNullParameter(stCommonExt, "stCommonExt");
        this.stNotice = stNotice;
        this.stCommonExt = stCommonExt;
    }

    /* renamed from: a, reason: from getter */
    public final QZoneBaseCommon$StCommonExt getStCommonExt() {
        return this.stCommonExt;
    }

    /* renamed from: b, reason: from getter */
    public final QZIntimateSpaceReader$StNotice getStNotice() {
        return this.stNotice;
    }
}
