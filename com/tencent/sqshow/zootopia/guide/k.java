package com.tencent.sqshow.zootopia.guide;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.ContextWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.vas.theme.ThemeReporter;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 /2\u00020\u0001:\u0001\u0005B+\u0012\u0006\u0010\u0012\u001a\u00020\u000e\u0012\u0006\u0010\u0017\u001a\u00020\u0013\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u0006\u00a2\u0006\u0004\b-\u0010.J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\n\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\t\u001a\u00020\bH\u0016J\u0006\u0010\n\u001a\u00020\u0006J\u0006\u0010\u000b\u001a\u00020\u0006J\b\u0010\f\u001a\u00020\u0002H\u0016J\b\u0010\r\u001a\u00020\u0006H\u0016R\u0017\u0010\u0012\u001a\u00020\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0017\u001a\u00020\u00138\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u0017\u0010\u001b\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u0017\u0010\u001d\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\u0007\u0010\u0018\u001a\u0004\b\u001c\u0010\u001aR\"\u0010!\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0018\u001a\u0004\b\u001e\u0010\u001a\"\u0004\b\u001f\u0010 R\"\u0010$\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001f\u0010\u0018\u001a\u0004\b\"\u0010\u001a\"\u0004\b#\u0010 R\u0016\u0010&\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b#\u0010%R\u0017\u0010,\u001a\u00020'8\u0006\u00a2\u0006\f\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+\u00a8\u00060"}, d2 = {"Lcom/tencent/sqshow/zootopia/guide/k;", "Lcom/tencent/sqshow/zootopia/guide/h;", "", "e", "Landroid/app/Activity;", "a", "", "d", "", "show", "c", "b", "dismiss", "getId", "Landroid/view/View;", "Landroid/view/View;", "getView", "()Landroid/view/View;", "view", "Lpv4/f;", "Lpv4/f;", ThemeReporter.BUNDLE_KEY_TASK_GET_STATUS, "()Lpv4/f;", "status", "I", "getLayoutResId", "()I", "layoutResId", "getTextResId", "textResId", "getXOffset", "f", "(I)V", "xOffset", "getYOffset", "g", "yOffset", "Z", "measuredView", "Lcom/tencent/sqshow/zootopia/guide/g;", tl.h.F, "Lcom/tencent/sqshow/zootopia/guide/g;", "getPopupWindow", "()Lcom/tencent/sqshow/zootopia/guide/g;", "popupWindow", "<init>", "(Landroid/view/View;Lpv4/f;II)V", "i", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class k implements h {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final View view;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final pv4.f status;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final int layoutResId;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final int textResId;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private int xOffset;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private int yOffset;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private boolean measuredView;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final g popupWindow;

    public k(View view, pv4.f status, int i3, int i16) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(status, "status");
        this.view = view;
        this.status = status;
        this.layoutResId = i3;
        this.textResId = i16;
        g gVar = new g(view.getContext());
        View inflate = LayoutInflater.from(view.getContext()).inflate(i3, (ViewGroup) null);
        ((TextView) inflate.findViewById(R.id.r9a)).setText(i16);
        gVar.setContentView(inflate);
        this.popupWindow = gVar;
    }

    private final Activity a() {
        for (Context context = this.view.getContext(); context instanceof ContextWrapper; context = ((ContextWrapper) context).getBaseContext()) {
            if (context instanceof Activity) {
                return (Activity) context;
            }
        }
        return null;
    }

    private final void e() {
        if (this.measuredView) {
            return;
        }
        this.popupWindow.getContentView().measure(d(), d());
        this.measuredView = true;
    }

    public final int b() {
        e();
        QLog.d("PopupGuideTask", 1, "show popup window height: " + this.popupWindow.getContentView().getMeasuredHeight());
        return this.popupWindow.getContentView().getMeasuredHeight();
    }

    public final int c() {
        e();
        QLog.d("PopupGuideTask", 1, "show popup window with: " + this.popupWindow.getContentView().getMeasuredWidth());
        return this.popupWindow.getContentView().getMeasuredWidth();
    }

    @Override // com.tencent.sqshow.zootopia.guide.h
    public void dismiss() {
        QLog.d("PopupGuideTask", 1, "dismiss popup window " + this.status.f427598b);
        this.popupWindow.dismiss();
    }

    public final void f(int i3) {
        this.xOffset = i3;
    }

    public final void g(int i3) {
        this.yOffset = i3;
    }

    @Override // com.tencent.sqshow.zootopia.guide.h
    public int getId() {
        return this.status.f427598b;
    }

    @Override // com.tencent.sqshow.zootopia.guide.h
    public boolean show() {
        Activity a16 = a();
        if (a16 != null && !a16.isDestroyed() && !a16.isFinishing()) {
            QLog.d("PopupGuideTask", 1, "show popup window " + this.xOffset + " " + this.yOffset);
            try {
                this.popupWindow.showAsDropDown(this.view, this.xOffset, this.yOffset);
                return true;
            } catch (Exception e16) {
                QLog.e("PopupGuideTask", 1, "activity is invalid ", e16);
                return false;
            }
        }
        ComponentName componentName = a16 != null ? a16.getComponentName() : null;
        QLog.e("PopupGuideTask", 1, "activity is invalid " + componentName + " " + this.view.getId());
        return false;
    }

    private final int d() {
        return View.MeasureSpec.makeMeasureSpec(0, 0);
    }
}
