package com.tencent.aio.base.tool;

import android.view.View;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.Calendar;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\b\b&\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\f\u001a\u00020\u0007\u00a2\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&R\u0016\u0010\n\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\b\u0010\tR\u0014\u0010\f\u001a\u00020\u00078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\t\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/aio/base/tool/c;", "Landroid/view/View$OnClickListener;", "Landroid/view/View;", "v", "", NodeProps.ON_CLICK, "a", "", "d", "J", "lastClickTime", "e", "delayTime", "<init>", "(J)V", "sdk_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes3.dex */
public abstract class c implements View.OnClickListener {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private long lastClickTime;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final long delayTime;

    public c(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            this.delayTime = j3;
        } else {
            iPatchRedirector.redirect((short) 2, (Object) this, j3);
        }
    }

    public abstract void a(@Nullable View v3);

    @Override // android.view.View.OnClickListener
    public final void onClick(@Nullable View v3) {
        EventCollector.getInstance().onViewClickedBefore(v3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) v3);
        } else {
            Calendar calendar = Calendar.getInstance();
            Intrinsics.checkNotNullExpressionValue(calendar, "Calendar.getInstance()");
            long timeInMillis = calendar.getTimeInMillis();
            if (timeInMillis - this.lastClickTime > this.delayTime) {
                this.lastClickTime = timeInMillis;
                a(v3);
            }
        }
        EventCollector.getInstance().onViewClicked(v3);
    }

    public /* synthetic */ c(long j3, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? 800L : j3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
            return;
        }
        iPatchRedirector.redirect((short) 3, this, Long.valueOf(j3), Integer.valueOf(i3), defaultConstructorMarker);
    }
}
