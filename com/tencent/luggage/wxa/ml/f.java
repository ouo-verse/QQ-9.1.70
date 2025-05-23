package com.tencent.luggage.wxa.ml;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.tencent.luggage.wxa.tn.w;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class f {

    /* renamed from: c, reason: collision with root package name */
    public static final a f134677c = new a(null);

    /* renamed from: a, reason: collision with root package name */
    public final String f134678a = "MicroMsg.AppBrandDialogAccessibilityFixer#" + hashCode();

    /* renamed from: b, reason: collision with root package name */
    public final HashMap f134679b = new HashMap();

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a {

        /* compiled from: P */
        /* renamed from: com.tencent.luggage.wxa.ml.f$a$a, reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public static final class C6482a implements s {

            /* renamed from: a, reason: collision with root package name */
            public final f f134680a;

            /* renamed from: b, reason: collision with root package name */
            public final g f134681b;

            /* renamed from: c, reason: collision with root package name */
            public boolean f134682c;

            public C6482a(f accessibilityFixer, g dialogContainer) {
                Intrinsics.checkNotNullParameter(accessibilityFixer, "accessibilityFixer");
                Intrinsics.checkNotNullParameter(dialogContainer, "dialogContainer");
                this.f134680a = accessibilityFixer;
                this.f134681b = dialogContainer;
                dialogContainer.setListener(this);
            }

            public final boolean a() {
                return this.f134682c;
            }

            @Override // com.tencent.luggage.wxa.ml.s
            public void b(boolean z16, m mVar, m mVar2) {
                this.f134680a.a(this.f134681b, z16, mVar, mVar2);
                if (z16) {
                    this.f134682c = false;
                }
            }

            @Override // com.tencent.luggage.wxa.ml.s
            public void a(boolean z16, m mVar, m mVar2) {
                this.f134682c = true;
                this.f134680a.b(this.f134681b, z16, mVar, mVar2);
            }
        }

        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public void a(g dialogContainer) {
        Intrinsics.checkNotNullParameter(dialogContainer, "dialogContainer");
        this.f134679b.put(dialogContainer, new a.C6482a(this, dialogContainer));
    }

    public final void b(g dialogContainer, boolean z16, m mVar, m mVar2) {
        Intrinsics.checkNotNullParameter(dialogContainer, "dialogContainer");
        a(dialogContainer, z16, mVar2);
    }

    public final void a(g dialogContainer, boolean z16, m mVar, m mVar2) {
        int collectionSizeOrDefault;
        Intrinsics.checkNotNullParameter(dialogContainer, "dialogContainer");
        HashMap hashMap = this.f134679b;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry entry : hashMap.entrySet()) {
            if (Intrinsics.areEqual(dialogContainer, entry.getKey()) ? false : ((a.C6482a) entry.getValue()).a()) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        Set keySet = linkedHashMap.keySet();
        if (!keySet.isEmpty()) {
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(keySet, 10);
            ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
            Iterator it = keySet.iterator();
            while (it.hasNext()) {
                List a16 = a((View) it.next());
                if (a16.contains(dialogContainer)) {
                    w.d(this.f134678a, "onDialogDismissed, otherShownContainer cover me");
                    return;
                }
                arrayList.add(a16);
            }
            HashSet hashSet = new HashSet();
            Iterator it5 = arrayList.iterator();
            while (it5.hasNext()) {
                hashSet.addAll((List) it5.next());
            }
            List a17 = a((View) dialogContainer);
            ArrayList arrayList2 = new ArrayList();
            for (Object obj : a17) {
                if (!hashSet.contains((View) obj)) {
                    arrayList2.add(obj);
                }
            }
            a(dialogContainer, z16, mVar2, arrayList2);
            return;
        }
        w.d(this.f134678a, "onDialogDismissed, othersShownContainer is empty");
        a(this, dialogContainer, z16, mVar2, null, 4, null);
    }

    public final boolean b(View view) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        return layoutParams != null && -1 == layoutParams.width && -1 == layoutParams.height;
    }

    public final void a(View view, boolean z16, m mVar) {
        View contentView;
        if (z16 && b(view)) {
            w.d(this.f134678a, "onDialogShown#[" + view + "], isFirstDialog, clear siblings's importantForAccessibility");
            Iterator it = a(view).iterator();
            while (it.hasNext()) {
                ((View) it.next()).setImportantForAccessibility(4);
            }
        }
        if (mVar == null || (contentView = mVar.getContentView()) == null) {
            return;
        }
        contentView.setImportantForAccessibility(4);
    }

    public static /* synthetic */ void a(f fVar, View view, boolean z16, m mVar, List list, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            list = null;
        }
        fVar.a(view, z16, mVar, list);
    }

    public final void a(View view, boolean z16, m mVar, List list) {
        View contentView;
        if (z16) {
            w.d(this.f134678a, "onDialogDismissed[" + view + "], isLastDialog, recover siblings's importantForAccessibility");
            if (list == null) {
                list = a(view);
            }
            Iterator it = list.iterator();
            while (it.hasNext()) {
                ((View) it.next()).setImportantForAccessibility(0);
            }
        }
        if (mVar == null || (contentView = mVar.getContentView()) == null) {
            return;
        }
        contentView.setImportantForAccessibility(0);
    }

    public final List a(View view) {
        List emptyList;
        List emptyList2;
        ViewParent parent = view.getParent();
        if (!(parent instanceof ViewGroup)) {
            w.f(this.f134678a, "findSiblingsBelow[" + view + "], parent is not ViewGroup");
            emptyList2 = CollectionsKt__CollectionsKt.emptyList();
            return emptyList2;
        }
        ViewGroup viewGroup = (ViewGroup) parent;
        int indexOfChild = viewGroup.indexOfChild(view);
        w.d(this.f134678a, "findSiblingsBelow[" + view + "], myIndex: " + indexOfChild);
        if (indexOfChild == 0) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            return emptyList;
        }
        ArrayList arrayList = new ArrayList(indexOfChild);
        for (int i3 = 0; i3 < indexOfChild; i3++) {
            View childAt = viewGroup.getChildAt(i3);
            if (childAt != null) {
                arrayList.add(childAt);
            }
        }
        return arrayList;
    }
}
