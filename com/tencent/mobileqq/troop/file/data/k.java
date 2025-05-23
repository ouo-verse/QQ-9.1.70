package com.tencent.mobileqq.troop.file.data;

import android.app.Activity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\n\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0006\u0012\u0006\u0010\r\u001a\u00020\n\u0012\u0006\u0010\u0011\u001a\u00020\u000e\u0012\u0006\u0010\u0013\u001a\u00020\u0006\u0012\u0006\u0010\u0015\u001a\u00020\u000e\u00a2\u0006\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0005\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\t\u001a\u00020\u00068\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0014\u0010\r\u001a\u00020\n8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0014\u0010\u0011\u001a\u00020\u000e8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0013\u001a\u00020\u00068\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\bR\u0014\u0010\u0015\u001a\u00020\u000e8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0010\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/troop/file/data/k;", "", "Landroid/app/Activity;", "a", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "", "b", "I", "viewId", "Lcom/tencent/mobileqq/app/QQAppInterface;", "c", "Lcom/tencent/mobileqq/app/QQAppInterface;", "app", "", "d", "J", "troopUin", "e", "source", "f", "filterUin", "<init>", "(Landroid/app/Activity;ILcom/tencent/mobileqq/app/QQAppInterface;JIJ)V", "base_proj_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class k {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final Activity activity;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final int viewId;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public final QQAppInterface app;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public final long troopUin;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public final int source;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    public final long filterUin;

    public k(Activity activity, int i3, QQAppInterface app, long j3, int i16, long j16) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(app, "app");
        this.activity = activity;
        this.viewId = i3;
        this.app = app;
        this.troopUin = j3;
        this.source = i16;
        this.filterUin = j16;
    }
}
