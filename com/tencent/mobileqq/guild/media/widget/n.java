package com.tencent.mobileqq.guild.media.widget;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.component.token.AppearDirection;
import com.tencent.mobileqq.guild.component.token.AppearDistance;
import com.tencent.mobileqq.guild.component.token.AppearDuration;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001cB7\u0012\u0006\u0010\u0010\u001a\u00020\f\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0011\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0013\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0015\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0017\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\"\u0010\n\u001a\u00020\t2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0016R\u001e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000e\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/mobileqq/guild/media/widget/n;", "Lcom/tencent/mobileqq/guild/component/token/b;", "", "e", "Landroid/view/View;", "anchor", "", "xoff", "yoff", "", "showAsDropDown", "Ljava/lang/ref/WeakReference;", "Landroid/content/Context;", "c", "Ljava/lang/ref/WeakReference;", "mContext", "context", "Lcom/tencent/mobileqq/guild/component/token/AppearDirection;", "appearDirection", "Lcom/tencent/mobileqq/guild/component/token/AppearDistance;", "appearDistance", "Lcom/tencent/mobileqq/guild/component/token/AppearDuration;", "appearDuration", "", "showTimeMs", "<init>", "(Landroid/content/Context;Lcom/tencent/mobileqq/guild/component/token/AppearDirection;Lcom/tencent/mobileqq/guild/component/token/AppearDistance;Lcom/tencent/mobileqq/guild/component/token/AppearDuration;J)V", "d", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class n extends com.tencent.mobileqq.guild.component.token.b {

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private WeakReference<Context> mContext;

    public /* synthetic */ n(Context context, AppearDirection appearDirection, AppearDistance appearDistance, AppearDuration appearDuration, long j3, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? AppearDirection.BOTTOM_TO_TOP : appearDirection, (i3 & 4) != 0 ? AppearDistance.PX_60 : appearDistance, (i3 & 8) != 0 ? AppearDuration.MS_150 : appearDuration, (i3 & 16) != 0 ? 0L : j3);
    }

    private final boolean e() {
        Object obj;
        WeakReference<Context> weakReference = this.mContext;
        Activity activity = null;
        if (weakReference != null) {
            obj = (Context) weakReference.get();
        } else {
            obj = null;
        }
        if (obj instanceof Activity) {
            activity = (Activity) obj;
        }
        if (activity == null) {
            return false;
        }
        return activity.isFinishing() | activity.isDestroyed();
    }

    @Override // android.widget.PopupWindow
    public void showAsDropDown(@Nullable View anchor, int xoff, int yoff) {
        if (e()) {
            return;
        }
        try {
            super.showAsDropDown(anchor, xoff, yoff);
        } catch (Exception e16) {
            QLog.e("GuildMediaCommonGuidePopupWindow", 1, "showAsDropDown exception", e16);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n(@NotNull Context context, @NotNull AppearDirection appearDirection, @NotNull AppearDistance appearDistance, @NotNull AppearDuration appearDuration, long j3) {
        super(appearDirection, appearDistance, appearDuration, j3);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(appearDirection, "appearDirection");
        Intrinsics.checkNotNullParameter(appearDistance, "appearDistance");
        Intrinsics.checkNotNullParameter(appearDuration, "appearDuration");
        setContentView(LayoutInflater.from(context).inflate(R.layout.eid, (ViewGroup) null));
        setWidth(-2);
        setHeight(-2);
        setFocusable(false);
        setTouchable(true);
        setOutsideTouchable(false);
        setBackgroundDrawable(new ColorDrawable(0));
        this.mContext = new WeakReference<>(context);
    }
}
