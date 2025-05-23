package com.tencent.luggage.wxa.il;

import android.content.Context;
import android.util.SparseArray;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.mm.ui.widget.dialog.MMBottomSheet;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class n {

    /* renamed from: c, reason: collision with root package name */
    public static final a f130726c = new a(null);

    /* renamed from: a, reason: collision with root package name */
    public final SparseArray f130727a = new SparseArray();

    /* renamed from: b, reason: collision with root package name */
    public final SparseArray f130728b = new SparseArray();

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public final MMBottomSheet a(int i3, Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        w.d("Luggage.ActionSheetManager", "createBottomSheet id:" + i3);
        MMBottomSheet mMBottomSheet = new MMBottomSheet(context, 1, false);
        this.f130727a.put(i3, mMBottomSheet);
        return mMBottomSheet;
    }

    public final com.tencent.luggage.wxa.ml.m b(int i3) {
        return (com.tencent.luggage.wxa.ml.m) this.f130728b.get(i3);
    }

    public final void c(int i3) {
        w.d("Luggage.ActionSheetManager", "removeBottomSheet id:" + i3);
        this.f130727a.remove(i3);
    }

    public final void d(int i3) {
        this.f130728b.remove(i3);
    }

    public final MMBottomSheet a(int i3) {
        return (MMBottomSheet) this.f130727a.get(i3);
    }

    public final void a(int i3, com.tencent.luggage.wxa.ml.m dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        this.f130728b.put(i3, dialog);
    }

    public final void a() {
        w.d("Luggage.ActionSheetManager", "clearAll");
        this.f130727a.clear();
        this.f130728b.clear();
    }
}
