package com.tencent.mobileqq.qwallet;

import android.os.SystemClock;
import android.view.View;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\n\b&\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\r\u001a\u00020\b\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002H&R\u0017\u0010\r\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u000f\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\n\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/qwallet/j;", "Landroid/view/View$OnClickListener;", "Landroid/view/View;", "v", "", NodeProps.ON_CLICK, "view", "a", "", "d", "J", "getClickInterval", "()J", "clickInterval", "e", "lastClickTime", "<init>", "(J)V", "qqpay-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public abstract class j implements View.OnClickListener {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final long clickInterval;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private long lastClickTime;

    public j(long j3) {
        this.clickInterval = j3;
    }

    public abstract void a(@Nullable View view);

    @Override // android.view.View.OnClickListener
    public final void onClick(@Nullable View v3) {
        EventCollector.getInstance().onViewClickedBefore(v3);
        long uptimeMillis = SystemClock.uptimeMillis();
        if (uptimeMillis - this.lastClickTime > this.clickInterval) {
            a(v3);
        }
        this.lastClickTime = uptimeMillis;
        EventCollector.getInstance().onViewClicked(v3);
    }
}
