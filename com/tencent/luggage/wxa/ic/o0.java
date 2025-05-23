package com.tencent.luggage.wxa.ic;

import android.view.View;
import android.view.ViewGroup;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes8.dex */
public enum o0 {
    SnapshotWebView,
    AppBrandPageContainer,
    PipContainer,
    InspectorView,
    LegacyDialogContainer,
    UpperDialogContainer,
    GlobalNativeWidgetContainerView,
    RemoteDebugFloatView,
    AuthorizeDialogContainer,
    LoadingSplash,
    GlobalPromptContainer;


    /* renamed from: l, reason: collision with root package name */
    public static final int f129977l = R.id.ssm;

    public final int a(g gVar) {
        com.tencent.luggage.wxa.il.g gVar2 = gVar.f129771l;
        int i3 = 0;
        if (gVar2.getChildCount() == 0) {
            return 0;
        }
        int childCount = gVar2.getChildCount() - 1;
        while (i3 <= childCount) {
            int i16 = (i3 + childCount) >>> 1;
            int intValue = ((Integer) gVar2.getChildAt(i16).getTag(f129977l)).intValue();
            if (intValue < ordinal()) {
                i3 = i16 + 1;
            } else {
                if (intValue <= ordinal()) {
                    return i16;
                }
                childCount = i16 - 1;
            }
        }
        int i17 = ~i3;
        return i17 >= 0 ? i17 : ~i17;
    }

    public void a(g gVar, View view) {
        int i3 = f129977l;
        Integer num = (Integer) view.getTag(i3);
        if (num != null && ordinal() != num.intValue()) {
            throw new IllegalStateException("Child has already been added with index " + num);
        }
        view.setTag(i3, Integer.valueOf(ordinal()));
        com.tencent.luggage.wxa.il.g gVar2 = gVar.f129771l;
        int a16 = a(gVar);
        if (view.getParent() == gVar2 && a16 >= gVar2.getChildCount() - 1) {
            gVar2.bringChildToFront(view);
            return;
        }
        if (view.getParent() != null) {
            ((ViewGroup) view.getParent()).removeView(view);
        }
        gVar2.addView(view, a16);
    }
}
