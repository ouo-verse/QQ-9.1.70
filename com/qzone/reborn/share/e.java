package com.qzone.reborn.share;

import android.app.Activity;
import android.view.View;
import androidx.lifecycle.LifecycleOwner;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\b\u0016\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\b\u001a\u00020\u0004\u0012\u0006\u0010\u000e\u001a\u00020\t\u0012\u0006\u0010\u0013\u001a\u00020\u000f\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0014\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002R\u0017\u0010\b\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0005\u0010\u0007R\u0017\u0010\u000e\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0013\u001a\u00020\u000f8\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0019\u0010\u0018\u001a\u0004\u0018\u00010\u00148\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R$\u0010\u001d\u001a\u0004\u0018\u00010\u00018\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\n\u0010\u001b\"\u0004\b\u0019\u0010\u001c\u00a8\u0006 "}, d2 = {"Lcom/qzone/reborn/share/e;", "", "Lge/h;", "c", "Landroid/app/Activity;", "a", "Landroid/app/Activity;", "()Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Lcom/qzone/reborn/share/QQShareActionManagerV2;", "b", "Lcom/qzone/reborn/share/QQShareActionManagerV2;", "d", "()Lcom/qzone/reborn/share/QQShareActionManagerV2;", "shareManger", "Landroidx/lifecycle/LifecycleOwner;", "Landroidx/lifecycle/LifecycleOwner;", "getLifecycleOwner", "()Landroidx/lifecycle/LifecycleOwner;", "lifecycleOwner", "Landroid/view/View;", "Landroid/view/View;", "getRootView", "()Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "e", "Ljava/lang/Object;", "()Ljava/lang/Object;", "(Ljava/lang/Object;)V", "data", "<init>", "(Landroid/app/Activity;Lcom/qzone/reborn/share/QQShareActionManagerV2;Landroidx/lifecycle/LifecycleOwner;Landroid/view/View;)V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public class e {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final Activity activity;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final QQShareActionManagerV2 shareManger;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final LifecycleOwner lifecycleOwner;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final View rootView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private Object data;

    public e(Activity activity, QQShareActionManagerV2 shareManger, LifecycleOwner lifecycleOwner, View view) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(shareManger, "shareManger");
        Intrinsics.checkNotNullParameter(lifecycleOwner, "lifecycleOwner");
        this.activity = activity;
        this.shareManger = shareManger;
        this.lifecycleOwner = lifecycleOwner;
        this.rootView = view;
    }

    /* renamed from: a, reason: from getter */
    public final Activity getActivity() {
        return this.activity;
    }

    /* renamed from: b, reason: from getter */
    public final Object getData() {
        return this.data;
    }

    public final ge.h c() {
        Object obj = this.data;
        if (obj instanceof ge.h) {
            return (ge.h) obj;
        }
        return null;
    }

    /* renamed from: d, reason: from getter */
    public final QQShareActionManagerV2 getShareManger() {
        return this.shareManger;
    }

    public final void e(Object obj) {
        this.data = obj;
    }
}
