package com.google.android.material.internal;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.appcompat.view.menu.ActionMenuItemView;
import androidx.appcompat.widget.ActionMenuView;
import androidx.appcompat.widget.Toolbar;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* compiled from: P */
@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: classes2.dex */
public class p {

    /* renamed from: a, reason: collision with root package name */
    private static final Comparator<View> f33885a = new a();

    /* compiled from: P */
    /* loaded from: classes2.dex */
    class a implements Comparator<View> {
        a() {
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(View view, View view2) {
            return view.getTop() - view2.getTop();
        }
    }

    @Nullable
    public static ActionMenuItemView a(@NonNull Toolbar toolbar, @IdRes int i3) {
        ActionMenuView b16 = b(toolbar);
        if (b16 != null) {
            for (int i16 = 0; i16 < b16.getChildCount(); i16++) {
                View childAt = b16.getChildAt(i16);
                if (childAt instanceof ActionMenuItemView) {
                    ActionMenuItemView actionMenuItemView = (ActionMenuItemView) childAt;
                    if (actionMenuItemView.getItemData().getItemId() == i3) {
                        return actionMenuItemView;
                    }
                }
            }
            return null;
        }
        return null;
    }

    @Nullable
    public static ActionMenuView b(@NonNull Toolbar toolbar) {
        for (int i3 = 0; i3 < toolbar.getChildCount(); i3++) {
            View childAt = toolbar.getChildAt(i3);
            if (childAt instanceof ActionMenuView) {
                return (ActionMenuView) childAt;
            }
        }
        return null;
    }

    @Nullable
    private static ImageView c(@NonNull Toolbar toolbar, @Nullable Drawable drawable) {
        for (int i3 = 0; i3 < toolbar.getChildCount(); i3++) {
            View childAt = toolbar.getChildAt(i3);
            if (childAt instanceof ImageView) {
                ImageView imageView = (ImageView) childAt;
                if (drawable != null && imageView.getDrawable().getConstantState().equals(drawable.getConstantState())) {
                    return imageView;
                }
            }
        }
        return null;
    }

    @Nullable
    public static ImageView d(@NonNull Toolbar toolbar) {
        return c(toolbar, toolbar.getLogo());
    }

    @Nullable
    public static TextView e(@NonNull Toolbar toolbar) {
        List<TextView> f16 = f(toolbar, toolbar.getSubtitle());
        if (f16.isEmpty()) {
            return null;
        }
        return (TextView) Collections.max(f16, f33885a);
    }

    private static List<TextView> f(@NonNull Toolbar toolbar, CharSequence charSequence) {
        ArrayList arrayList = new ArrayList();
        for (int i3 = 0; i3 < toolbar.getChildCount(); i3++) {
            View childAt = toolbar.getChildAt(i3);
            if (childAt instanceof TextView) {
                TextView textView = (TextView) childAt;
                if (TextUtils.equals(textView.getText(), charSequence)) {
                    arrayList.add(textView);
                }
            }
        }
        return arrayList;
    }

    @Nullable
    public static TextView g(@NonNull Toolbar toolbar) {
        List<TextView> f16 = f(toolbar, toolbar.getTitle());
        if (f16.isEmpty()) {
            return null;
        }
        return (TextView) Collections.min(f16, f33885a);
    }
}
