package com.tencent.luggage.wxa.ok;

import android.content.Context;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.tencent.hippy.qq.view.pag.HippyQQPagView;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u0015\u001a\u00020\u0014\u00a2\u0006\u0004\b\u0016\u0010\u0017J\b\u0010\u0004\u001a\u00020\u0003H\u0014J\u001c\u0010\b\u001a\u00020\u00072\b\u0010\u0005\u001a\u0004\u0018\u00010\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003H\u0016J\u0018\u0010\u000b\u001a\u00020\u00072\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\tH\u0016J\b\u0010\r\u001a\u00020\fH\u0016J\u0010\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u000eH\u0016J\u0010\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u0011H\u0016\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/luggage/wxa/ok/f;", "Lcom/tencent/luggage/wxa/ok/h;", "Lcom/tencent/luggage/wxa/ok/j;", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "icon", "name", "", "a", "Lkotlin/Function0;", "listener", "c", "Landroid/view/View;", "getView", "", "progress", HippyQQPagView.FunctionName.SET_PROGRESS, "", "can", "setCanShowHideAnimation", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "luggage-wechat-full-sdk_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes8.dex */
public final class f extends h {

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a implements Runnable {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Function0 f136600b;

        public a(Function0 function0) {
            this.f136600b = function0;
        }

        @Override // java.lang.Runnable
        public final void run() {
            f.this.c(this.f136600b);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        a(true);
        a(0, true ^ com.tencent.luggage.wxa.h6.l.f126905a.c());
        setBackgroundColor(0);
    }

    @Override // com.tencent.luggage.wxa.ok.j
    public void c(Function0 listener) {
        ViewGroup viewGroup;
        if (!Intrinsics.areEqual(Looper.getMainLooper(), Looper.myLooper())) {
            post(new a(listener));
            return;
        }
        setVisibility(8);
        ViewParent parent = getParent();
        if (parent instanceof ViewGroup) {
            viewGroup = (ViewGroup) parent;
        } else {
            viewGroup = null;
        }
        if (viewGroup != null) {
            viewGroup.removeView(this);
        }
        if (listener != null) {
            listener.invoke();
        }
    }

    @Override // com.tencent.luggage.wxa.ok.i
    public String m() {
        return "AppBrandUITransparentLoadingSplash";
    }

    @Override // com.tencent.luggage.wxa.ok.i, com.tencent.luggage.wxa.ok.j
    public /* bridge */ /* synthetic */ void setAppServiceType(int i3) {
        o31.b.a(this, i3);
    }

    @Override // com.tencent.luggage.wxa.ok.i, com.tencent.luggage.wxa.ok.j
    @NotNull
    public View getView() {
        return this;
    }

    @Override // com.tencent.luggage.wxa.ok.i, com.tencent.luggage.wxa.ok.j
    public void setCanShowHideAnimation(boolean can) {
    }

    @Override // com.tencent.luggage.wxa.ok.i, com.tencent.luggage.wxa.ok.j
    public void setProgress(int progress) {
    }

    @Override // com.tencent.luggage.wxa.ok.j
    public void a(String icon, String name) {
    }
}
