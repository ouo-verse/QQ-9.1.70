package com.tencent.luggage.wxa.nj;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name */
    public final String f135859a;

    /* renamed from: b, reason: collision with root package name */
    public final List f135860b;

    public g(String dialogContent, List sceneInfo) {
        Intrinsics.checkNotNullParameter(dialogContent, "dialogContent");
        Intrinsics.checkNotNullParameter(sceneInfo, "sceneInfo");
        this.f135859a = dialogContent;
        this.f135860b = sceneInfo;
    }

    public final String a() {
        return this.f135859a;
    }

    public /* synthetic */ g(String str, List list, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? "" : str, (i3 & 2) != 0 ? new ArrayList() : list);
    }

    public final boolean a(String scene) {
        Intrinsics.checkNotNullParameter(scene, "scene");
        for (h hVar : this.f135860b) {
            if (TextUtils.equals(hVar.b(), scene) && hVar.a()) {
                return true;
            }
        }
        return false;
    }
}
