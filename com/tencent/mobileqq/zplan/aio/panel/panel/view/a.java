package com.tencent.mobileqq.zplan.aio.panel.panel.view;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.zplan.api.IZPlanMMKVApi;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;
import t74.i;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0010\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0018\u0010\u0019J\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u000e\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bR\u0016\u0010\u000e\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u0016\u0010\u0010\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u000fR+\u0010\u0017\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\n8B@BX\u0082\u008e\u0002\u00a2\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\f\u0010\u0016\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/mobileqq/zplan/aio/panel/panel/view/a;", "", "Landroid/content/Context;", "context", "Landroid/view/View;", "anchorView", "", "d", "", "position", "", "b", "c", "I", "prePosition", "Z", "isShowed", "<set-?>", "e", "Lkotlin/properties/ReadWriteProperty;", "a", "()Z", "(Z)V", "mmkvShowTip", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class a {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private static boolean isShowed;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private static final ReadWriteProperty mmkvShowTip;

    /* renamed from: b, reason: collision with root package name */
    static final /* synthetic */ KProperty<Object>[] f331308b = {Reflection.mutableProperty1(new MutablePropertyReference1Impl(a.class, "mmkvShowTip", "getMmkvShowTip()Z", 0))};

    /* renamed from: a, reason: collision with root package name */
    public static final a f331307a = new a();

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static int prePosition = -1;

    a() {
    }

    private final boolean a() {
        return ((Boolean) mmkvShowTip.getValue(this, f331308b[0])).booleanValue();
    }

    private final void c(boolean z16) {
        mmkvShowTip.setValue(this, f331308b[0], Boolean.valueOf(z16));
    }

    public final boolean b(int position) {
        if (isShowed) {
            return false;
        }
        if (prePosition == -1) {
            prePosition = position;
            if (position == 2) {
                return false;
            }
        }
        if (position != 2 || !a()) {
            return false;
        }
        isShowed = true;
        c(false);
        return true;
    }

    public final void d(Context context, View anchorView) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(anchorView, "anchorView");
        try {
            com.tencent.mobileqq.widget.tip.a r16 = com.tencent.mobileqq.widget.tip.a.r(context);
            r16.S(anchorView);
            r16.k0(0);
            r16.R(0);
            r16.o0("\u597d\u53cb\u7684\u573a\u666f\u4e5f\u4f1a\u8054\u52a8\u54e6");
            r16.p0(-1);
            r16.q0(14.0f);
            r16.b0(3000L);
            r16.f0(false);
            r16.W(Color.parseColor("#9A000000"));
            r16.j0(10.0f, 8.0f, 10.0f, 8.0f);
            r16.s0();
        } catch (Exception unused) {
        }
    }

    static {
        QRouteApi api = QRoute.api(IZPlanMMKVApi.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IZPlanMMKVApi::class.java)");
        mmkvShowTip = i.b((IZPlanMMKVApi) api, "KEY-AioPanelBubbleTip", true);
    }
}
