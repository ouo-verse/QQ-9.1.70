package com.tencent.biz.pubaccount.weishi.util;

import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.util.AccessibilityUtil;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nJ\u001e\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0007\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/biz/pubaccount/weishi/util/c;", "", "Landroid/view/View;", "view", "Lkotlin/Function0;", "", "obtainSelectStatusFunc", "", "a", "<init>", "()V", "qqweishi_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes32.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public static final c f81758a = new c();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/biz/pubaccount/weishi/util/c$a", "Landroid/view/View$AccessibilityDelegate;", "Landroid/view/View;", "host", "Landroid/view/accessibility/AccessibilityNodeInfo;", "info", "", "onInitializeAccessibilityNodeInfo", "qqweishi_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes32.dex */
    public static final class a extends View.AccessibilityDelegate {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Function0<Boolean> f81759a;

        a(Function0<Boolean> function0) {
            this.f81759a = function0;
        }

        @Override // android.view.View.AccessibilityDelegate
        public void onInitializeAccessibilityNodeInfo(View host, AccessibilityNodeInfo info) {
            super.onInitializeAccessibilityNodeInfo(host, info);
            if (info != null) {
                Function0<Boolean> function0 = this.f81759a;
                info.setCheckable(true);
                info.setChecked(function0.invoke().booleanValue());
            }
        }
    }

    c() {
    }

    @JvmStatic
    public static final void a(View view, Function0<Boolean> obtainSelectStatusFunc) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(obtainSelectStatusFunc, "obtainSelectStatusFunc");
        if (AccessibilityUtil.i(BaseApplicationImpl.getApplication())) {
            view.setAccessibilityDelegate(new a(obtainSelectStatusFunc));
        }
    }
}
