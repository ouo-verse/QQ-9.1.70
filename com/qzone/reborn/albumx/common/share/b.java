package com.qzone.reborn.albumx.common.share;

import android.app.Activity;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0016\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\n\u0010\u000b\u001a\u0006\u0012\u0002\b\u00030\u0007\u00a2\u0006\u0004\b\f\u0010\rR\u0017\u0010\u0006\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005R\u001b\u0010\u000b\u001a\u0006\u0012\u0002\b\u00030\u00078\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\b\u0010\n\u00a8\u0006\u000e"}, d2 = {"Lcom/qzone/reborn/albumx/common/share/b;", "", "Landroid/app/Activity;", "a", "Landroid/app/Activity;", "()Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Lcom/qzone/reborn/albumx/common/share/QQShareActionManager;", "b", "Lcom/qzone/reborn/albumx/common/share/QQShareActionManager;", "()Lcom/qzone/reborn/albumx/common/share/QQShareActionManager;", "shareManger", "<init>", "(Landroid/app/Activity;Lcom/qzone/reborn/albumx/common/share/QQShareActionManager;)V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public class b {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final Activity activity;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final QQShareActionManager<?> shareManger;

    public b(Activity activity, QQShareActionManager<?> shareManger) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(shareManger, "shareManger");
        this.activity = activity;
        this.shareManger = shareManger;
    }

    /* renamed from: a, reason: from getter */
    public final Activity getActivity() {
        return this.activity;
    }

    public final QQShareActionManager<?> b() {
        return this.shareManger;
    }
}
