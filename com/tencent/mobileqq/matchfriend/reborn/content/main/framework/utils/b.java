package com.tencent.mobileqq.matchfriend.reborn.content.main.framework.utils;

import android.view.View;
import com.qzone.proxy.personalitycomponent.model.WidgetCacheConstellationData;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0002\u0010\t\u001a\u00020\u0006\u0012\u0006\u0010\f\u001a\u00020\u0001\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016R\u0014\u0010\t\u001a\u00020\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0014\u0010\f\u001a\u00020\u00018\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0016\u0010\u0010\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/matchfriend/reborn/content/main/framework/utils/b;", "Landroid/view/View$OnClickListener;", "Landroid/view/View;", "v", "", NodeProps.ON_CLICK, "", "d", "I", WidgetCacheConstellationData.INTERVAL, "e", "Landroid/view/View$OnClickListener;", "clickListener", "", "f", "J", "lastClickTime", "<init>", "(ILandroid/view/View$OnClickListener;)V", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class b implements View.OnClickListener {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final int interval;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final View.OnClickListener clickListener;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private long lastClickTime;

    public b(int i3, View.OnClickListener clickListener) {
        Intrinsics.checkNotNullParameter(clickListener, "clickListener");
        this.interval = i3;
        this.clickListener = clickListener;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v3) {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.lastClickTime > this.interval) {
            this.clickListener.onClick(v3);
            this.lastClickTime = currentTimeMillis;
        }
    }

    public /* synthetic */ b(int i3, View.OnClickListener onClickListener, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this((i16 & 1) != 0 ? 500 : i3, onClickListener);
    }
}
