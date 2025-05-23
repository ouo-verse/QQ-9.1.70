package com.tencent.mobileqq.zootopia.view;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mobileqq.zootopia.ZootopiaSource;
import com.tencent.mobileqq.zootopia.data.ZootopiaEnterParams;
import com.tencent.mobileqq.zplan.smallhome.status.ZPlanModLoadStatus;
import com.tencent.oskplayer.util.SecretUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b&\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010%\u001a\u00020$\u0012\n\b\u0002\u0010'\u001a\u0004\u0018\u00010&\u0012\b\b\u0002\u0010)\u001a\u00020(\u00a2\u0006\u0004\b*\u0010+J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J&\u0010\f\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH&J\u0012\u0010\u000f\u001a\u00020\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\rH&J\u001c\u0010\u0013\u001a\u00020\u00042\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\u0010\u0012\u001a\u0004\u0018\u00010\u0010H&J!\u0010\u0015\u001a\u00020\u00042\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\u0010\u0012\u001a\u0004\u0018\u00010\u0014\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u0017H\u0016J \u0010\u001d\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u00102\u0006\u0010\u001b\u001a\u00020\u00102\u0006\u0010\u001c\u001a\u00020\u0010H\u0016J \u0010 \u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00142\u0006\u0010\u001e\u001a\u00020\u00102\u0006\u0010\u001f\u001a\u00020\u0010H\u0016J\b\u0010!\u001a\u00020\u0004H\u0016J\u0010\u0010\"\u001a\u00020\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\nR\u0018\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010#\u00a8\u0006,"}, d2 = {"Lcom/tencent/mobileqq/zootopia/view/ZPlanBaseSceneLoadingView;", "Landroid/widget/FrameLayout;", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "", "a", "Lid3/d;", "reportHelper", "Lcom/tencent/mobileqq/zootopia/data/ZootopiaEnterParams;", "params", "Lcom/tencent/mobileqq/zootopia/ZootopiaSource;", "source", "c", "Landroid/view/View$OnClickListener;", "listener", "setOnBackArrowClickListener", "", "progressTitle", "progress", "e", "", "d", "(Ljava/lang/String;Ljava/lang/Float;)V", "Lcom/tencent/mobileqq/zplan/smallhome/status/ZPlanModLoadStatus;", "status", tl.h.F, "ver1", "ver2", "ver3", "i", "title", SecretUtils.DES, "g", "f", "b", "Lcom/tencent/mobileqq/zootopia/ZootopiaSource;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public abstract class ZPlanBaseSceneLoadingView extends FrameLayout {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private ZootopiaSource source;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ZPlanBaseSceneLoadingView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public void a(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
    }

    public final void b(ZootopiaSource source) {
        this.source = source;
    }

    public abstract void c(id3.d reportHelper, ZootopiaEnterParams params, ZootopiaSource source);

    public final void d(String progressTitle, Float progress) {
        e(progressTitle, String.valueOf(progress));
    }

    public abstract void e(String progressTitle, String progress);

    public void g(float progress, String title, String des) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(des, "des");
    }

    public void h(ZPlanModLoadStatus status) {
        Intrinsics.checkNotNullParameter(status, "status");
    }

    public void i(String ver1, String ver2, String ver3) {
        Intrinsics.checkNotNullParameter(ver1, "ver1");
        Intrinsics.checkNotNullParameter(ver2, "ver2");
        Intrinsics.checkNotNullParameter(ver3, "ver3");
    }

    public abstract void setOnBackArrowClickListener(View.OnClickListener listener);

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ZPlanBaseSceneLoadingView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ ZPlanBaseSceneLoadingView(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? -1 : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ZPlanBaseSceneLoadingView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public void f() {
    }
}
