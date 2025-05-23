package com.tencent.qqnt.chats.biz.main.lightbusiness.interaction;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Trace;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.view.MarginLayoutParamsCompat;
import androidx.viewbinding.ViewBinding;
import com.tencent.aio.view_dsl.dsl.LayoutBuilderKt;
import com.tencent.aio.view_dsl.dsl.b;
import com.tencent.aio.view_dsl.dsl.c;
import com.tencent.aio.view_dsl.dsl.f;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.theme.SkinnableBitmapDrawable;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\f\u001a\u00020\u0007\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u000e\u0010\u0004\u001a\u0004\u0018\u00010\u0003*\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0016R\u0017\u0010\f\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/qqnt/chats/biz/main/lightbusiness/interaction/a;", "Landroidx/viewbinding/ViewBinding;", "Landroid/widget/FrameLayout;", "Landroid/graphics/drawable/StateListDrawable;", "e", "Landroid/view/View;", "getRoot", "Landroid/content/Context;", "a", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "context", "b", "Landroid/widget/FrameLayout;", "root", "Landroid/widget/ImageView;", "c", "Landroid/widget/ImageView;", "icon", "<init>", "(Landroid/content/Context;)V", "chats_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class a implements ViewBinding {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Context context;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private FrameLayout root;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ImageView icon;

    public a(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
        } else {
            this.context = context;
        }
    }

    private final StateListDrawable e(FrameLayout frameLayout) {
        Drawable drawable = ResourcesCompat.getDrawable(frameLayout.getResources(), R.drawable.qui_common_fill_standard_primary_oval, null);
        if (drawable == null) {
            return null;
        }
        if (drawable instanceof SkinnableBitmapDrawable) {
            ((SkinnableBitmapDrawable) drawable).mutate2();
        } else {
            drawable.mutate();
        }
        drawable.setAlpha(128);
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{android.R.attr.state_pressed}, drawable);
        stateListDrawable.addState(new int[0], drawable);
        return stateListDrawable;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v15, types: [android.view.ViewGroup$LayoutParams] */
    /* JADX WARN: Type inference failed for: r7v0, types: [com.tencent.qqnt.chats.biz.main.lightbusiness.interaction.a, java.lang.Object] */
    @Override // androidx.viewbinding.ViewBinding
    @NotNull
    public View getRoot() {
        int i3;
        int i16;
        ViewGroup.MarginLayoutParams marginLayoutParams;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (View) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        FrameLayout frameLayout = this.root;
        if (frameLayout != null) {
            return frameLayout;
        }
        FrameLayout frameLayout2 = new FrameLayout(this.context);
        frameLayout2.setLayoutParams(new ViewGroup.LayoutParams(0, 0));
        int intValue = ((Number) c.e(40)).intValue();
        if (frameLayout2.getLayoutParams() == null) {
            frameLayout2.setLayoutParams(new ViewGroup.LayoutParams(intValue, 0));
        } else {
            frameLayout2.getLayoutParams().width = intValue;
        }
        int intValue2 = ((Number) c.e(40)).intValue();
        if (frameLayout2.getLayoutParams() == null) {
            frameLayout2.setLayoutParams(new ViewGroup.LayoutParams(0, intValue2));
        } else {
            frameLayout2.getLayoutParams().height = intValue2;
        }
        f.p(frameLayout2, b.e());
        frameLayout2.setBackground(e(frameLayout2));
        int intValue3 = ((Number) c.e(8)).intValue();
        ViewGroup.LayoutParams layoutParams = frameLayout2.getLayoutParams();
        if (!(layoutParams instanceof ViewGroup.MarginLayoutParams)) {
            layoutParams = null;
        }
        ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) layoutParams;
        if (marginLayoutParams2 != null) {
            MarginLayoutParamsCompat.setMarginEnd(marginLayoutParams2, intValue3);
            marginLayoutParams = marginLayoutParams2;
        } else {
            ViewGroup.LayoutParams layoutParams2 = frameLayout2.getLayoutParams();
            if (layoutParams2 != null) {
                i3 = layoutParams2.width;
            } else {
                i3 = 0;
            }
            ViewGroup.LayoutParams layoutParams3 = frameLayout2.getLayoutParams();
            if (layoutParams3 != null) {
                i16 = layoutParams3.height;
            } else {
                i16 = 0;
            }
            Object[] objArr = {new ViewGroup.LayoutParams(i3, i16)};
            ArrayList arrayList = new ArrayList(1);
            arrayList.add(objArr[0].getClass());
            Object[] array = arrayList.toArray(new Class[0]);
            if (array != null) {
                Class[] clsArr = (Class[]) array;
                Constructor it = ViewGroup.MarginLayoutParams.class.getDeclaredConstructor((Class[]) Arrays.copyOf(clsArr, clsArr.length));
                Intrinsics.checkNotNullExpressionValue(it, "it");
                it.setAccessible(true);
                Object newInstance = it.newInstance(Arrays.copyOf(objArr, 1));
                MarginLayoutParamsCompat.setMarginEnd((ViewGroup.MarginLayoutParams) newInstance, intValue3);
                marginLayoutParams = (ViewGroup.LayoutParams) newInstance;
            } else {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
            }
        }
        frameLayout2.setLayoutParams(marginLayoutParams);
        Trace.beginSection(ParseCommon.RELATIVE_LAYOUT);
        ImageView imageView = new ImageView(frameLayout2.getContext());
        Object invoke = LayoutBuilderKt.b().invoke(frameLayout2, new Object[0]);
        if (invoke != null) {
            imageView.setLayoutParams((ViewGroup.LayoutParams) invoke);
            int intValue4 = ((Number) c.e(24)).intValue();
            if (imageView.getLayoutParams() == null) {
                imageView.setLayoutParams(new ViewGroup.LayoutParams(intValue4, 0));
            } else {
                imageView.getLayoutParams().width = intValue4;
            }
            int intValue5 = ((Number) c.e(24)).intValue();
            if (imageView.getLayoutParams() == null) {
                imageView.setLayoutParams(new ViewGroup.LayoutParams(0, intValue5));
            } else {
                imageView.getLayoutParams().height = intValue5;
            }
            f.p(imageView, b.e());
            imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            this.icon = imageView;
            frameLayout2.addView(imageView);
            Trace.endSection();
            this.root = frameLayout2;
            return frameLayout2;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    }
}
