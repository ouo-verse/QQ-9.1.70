package ce0;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableContainer;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RotateDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build;
import android.text.TextUtils;
import android.util.LongSparseArray;
import android.util.TypedValue;
import androidx.annotation.Nullable;
import com.tencent.theme.BaseConstantState;
import com.tencent.theme.SkinData;
import com.tencent.theme.SkinEngine;
import com.tencent.theme.SkinnableBitmapDrawable;
import com.tencent.theme.SkinnableColorStateList;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import td0.g;

/* compiled from: P */
/* loaded from: classes5.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    private final ce0.a f30734a;

    /* renamed from: b, reason: collision with root package name */
    private final ae0.a f30735b;

    /* renamed from: c, reason: collision with root package name */
    private final g f30736c;

    /* renamed from: d, reason: collision with root package name */
    private String f30737d;

    /* renamed from: e, reason: collision with root package name */
    private final LongSparseArray<WeakReference<BaseConstantState>> f30738e = new LongSparseArray<>();

    /* renamed from: f, reason: collision with root package name */
    private final ReentrantReadWriteLock f30739f = new ReentrantReadWriteLock();

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        int[] f30740a;

        /* renamed from: b, reason: collision with root package name */
        Drawable f30741b;
    }

    public e(ce0.a aVar, ae0.a aVar2) {
        this.f30734a = aVar;
        this.f30735b = aVar2;
        g gVar = (g) ud0.c.a(g.class);
        this.f30736c = gVar;
        if (gVar != null) {
            this.f30737d = gVar.a();
        }
    }

    private void a(LayerDrawable layerDrawable, LayerDrawable layerDrawable2) {
        if (layerDrawable.getNumberOfLayers() != layerDrawable2.getNumberOfLayers()) {
            return;
        }
        for (int i3 = 0; i3 < layerDrawable.getNumberOfLayers(); i3++) {
            layerDrawable2.setLayerGravity(i3, layerDrawable.getLayerGravity(i3));
            layerDrawable2.setLayerSize(i3, layerDrawable.getLayerWidth(i3), layerDrawable.getLayerHeight(i3));
            if (layerDrawable.getLayerInsetStart(i3) == Integer.MIN_VALUE && layerDrawable.getLayerInsetEnd(i3) == Integer.MIN_VALUE) {
                layerDrawable2.setLayerInset(i3, layerDrawable.getLayerInsetLeft(i3), layerDrawable.getLayerInsetTop(i3), layerDrawable.getLayerInsetRight(i3), layerDrawable.getLayerInsetBottom(i3));
            } else {
                layerDrawable2.setLayerInsetRelative(i3, layerDrawable.getLayerInsetStart(i3), layerDrawable.getLayerInsetTop(i3), layerDrawable.getLayerInsetEnd(i3), layerDrawable.getLayerInsetBottom(i3));
            }
        }
    }

    private String b(ColorStateList colorStateList) {
        ce0.a aVar = this.f30734a;
        if (aVar != null && (colorStateList instanceof SkinnableColorStateList)) {
            return aVar.b((SkinnableColorStateList) colorStateList);
        }
        return null;
    }

    private BaseConstantState c(Context context, int i3, String str) {
        int i16;
        this.f30739f.readLock().lock();
        try {
            long j3 = i3;
            WeakReference<BaseConstantState> weakReference = this.f30738e.get(j3);
            if (weakReference != null) {
                BaseConstantState baseConstantState = weakReference.get();
                if (baseConstantState != null) {
                    return baseConstantState;
                }
                this.f30739f.writeLock().lock();
                try {
                    this.f30738e.remove(j3);
                } finally {
                }
            }
            Resources resources = context.getApplicationContext().getResources();
            SkinData skinData = new SkinData();
            skinData.mResourcesID = i3;
            skinData.mFileName = str;
            BaseConstantState loadImage = SkinEngine.getInstances().loadImage(i3, resources, skinData, new TypedValue());
            if (loadImage == null) {
                return null;
            }
            SkinData skinData2 = loadImage.skinData;
            if (skinData2 != null && (i16 = skinData2.mTintColorResId) != 0) {
                skinData.mTintColorResId = i16;
            }
            loadImage.skinData = skinData;
            ud0.d.a("QUIProfileSkin_DrawableTint", ud0.d.f438811e, "loadConstantState skinData=" + skinData);
            this.f30739f.writeLock().lock();
            try {
                this.f30738e.put(j3, new WeakReference<>(loadImage));
                return loadImage;
            } finally {
            }
        } finally {
            this.f30739f.readLock().unlock();
        }
    }

    @Nullable
    private Drawable d(Drawable drawable) {
        Drawable drawable2;
        Drawable newDrawable;
        if (drawable == null) {
            return null;
        }
        if (drawable instanceof SkinnableBitmapDrawable) {
            drawable2 = ((SkinnableBitmapDrawable) drawable).mutate2();
        } else if (drawable.getConstantState() != null && (newDrawable = drawable.getConstantState().newDrawable()) != null) {
            drawable2 = newDrawable.mutate();
        } else {
            drawable2 = null;
        }
        if (drawable2 == null) {
            ud0.d.b("QUIProfileSkin_DrawableTint", ud0.d.f438811e, "mutate drawable is null");
            return null;
        }
        if (drawable2 != drawable && drawable2.getConstantState() != drawable.getConstantState()) {
            return drawable2;
        }
        ud0.d.b("QUIProfileSkin_DrawableTint", ud0.d.f438811e, "mutate drawable have not changed, or mutate constant state have not changed");
        return null;
    }

    private boolean e(String str) {
        if (this.f30736c != null && !TextUtils.isEmpty(str) && this.f30736c.b(str)) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0063 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x006c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private List<a> f(StateListDrawable stateListDrawable) {
        DrawableContainer.DrawableContainerState drawableContainerState;
        int[][] iArr;
        int childCount;
        int[] iArr2;
        int stateCount;
        int[] stateSet;
        Drawable stateDrawable;
        ArrayList arrayList = new ArrayList();
        int i3 = 0;
        if (Build.VERSION.SDK_INT >= 29) {
            stateCount = stateListDrawable.getStateCount();
            while (i3 < stateCount) {
                stateSet = stateListDrawable.getStateSet(i3);
                stateDrawable = stateListDrawable.getStateDrawable(i3);
                if (stateSet != null && stateDrawable != null) {
                    a aVar = new a();
                    aVar.f30740a = stateSet;
                    aVar.f30741b = stateDrawable;
                    arrayList.add(aVar);
                }
                i3++;
            }
        } else {
            try {
                drawableContainerState = (DrawableContainer.DrawableContainerState) com.tencent.biz.qui.quicommon.d.b(stateListDrawable, "android.graphics.drawable.StateListDrawable", "mStateListState", null);
            } catch (Throwable th5) {
                th = th5;
                drawableContainerState = null;
            }
            if (drawableContainerState != null) {
                try {
                    iArr = (int[][]) com.tencent.biz.qui.quicommon.d.b(drawableContainerState, "android.graphics.drawable.StateListDrawable$StateListState", "mStateSets", null);
                } catch (Throwable th6) {
                    th = th6;
                    ud0.d.l("QUIProfileSkin_DrawableTint", ud0.d.f438811e, "parseStateListDrawable exception", th);
                    iArr = null;
                    if (drawableContainerState != null) {
                    }
                    return arrayList;
                }
                if (drawableContainerState != null && iArr != null) {
                    childCount = drawableContainerState.getChildCount();
                    while (i3 < childCount) {
                        if (i3 < iArr.length) {
                            iArr2 = iArr[i3];
                        } else {
                            iArr2 = null;
                        }
                        Drawable child = drawableContainerState.getChild(i3);
                        if (iArr2 != null && child != null) {
                            a aVar2 = new a();
                            aVar2.f30740a = iArr2;
                            aVar2.f30741b = child;
                            arrayList.add(aVar2);
                        }
                        i3++;
                    }
                }
            }
            iArr = null;
            if (drawableContainerState != null) {
                childCount = drawableContainerState.getChildCount();
                while (i3 < childCount) {
                }
            }
        }
        return arrayList;
    }

    private ColorStateList h(ColorStateList colorStateList) {
        ce0.a aVar = this.f30734a;
        if (aVar != null) {
            return aVar.d(colorStateList);
        }
        return null;
    }

    private GradientDrawable i(GradientDrawable gradientDrawable) {
        ColorStateList c16;
        boolean z16;
        boolean z17;
        String str;
        Drawable.ConstantState constantState = gradientDrawable.getConstantState();
        if (Build.VERSION.SDK_INT >= 24) {
            c16 = com.tencent.theme.utils.a.a(gradientDrawable);
        } else {
            c16 = com.tencent.theme.utils.a.c(constantState);
        }
        ColorStateList d16 = com.tencent.theme.utils.a.d(constantState);
        if (!(c16 instanceof SkinnableColorStateList) && !(d16 instanceof SkinnableColorStateList)) {
            return gradientDrawable;
        }
        ColorStateList h16 = h(c16);
        ColorStateList h17 = h(d16);
        if (h16 != null && h16 != c16) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (h17 != null && h17 != d16) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (!z16 && !z17) {
            return gradientDrawable;
        }
        String b16 = b(c16);
        String b17 = b(d16);
        GradientDrawable gradientDrawable2 = (GradientDrawable) d(gradientDrawable);
        if (gradientDrawable2 == null) {
            ud0.d.b("QUIProfileSkin_DrawableTint", ud0.d.f438811e, "mutate GradientDrawable error, drawable=" + gradientDrawable + ", solidColorToken=" + b16 + ", strokeColorToken=" + b17);
            return gradientDrawable;
        }
        if (z16) {
            gradientDrawable2.setColor(h16);
        }
        if (z17) {
            int g16 = com.tencent.theme.utils.a.g(constantState);
            float e16 = com.tencent.theme.utils.a.e(constantState);
            float f16 = com.tencent.theme.utils.a.f(constantState);
            if (g16 != -1) {
                gradientDrawable2.setStroke(g16, h17, f16, e16);
            }
        }
        if (e(b16) || e(b17)) {
            String str2 = "";
            if (h16 == null) {
                str = "";
            } else {
                str = n(h16.getDefaultColor());
            }
            if (h17 != null) {
                str2 = n(h17.getDefaultColor());
            }
            ud0.d.g("QUIProfileSkin_DrawableTint", ud0.d.f438811e, "[GradientDrawableTint] solidColorToken=" + b16 + ", solidColor=" + str + ", strokeColorToken=" + b17 + ", strokeColor=" + str2 + ", srcDrawable=" + gradientDrawable + ", tintDrawable=" + gradientDrawable2);
        }
        return gradientDrawable2;
    }

    private LayerDrawable j(Context context, LayerDrawable layerDrawable) {
        int numberOfLayers = layerDrawable.getNumberOfLayers();
        if (numberOfLayers <= 0) {
            return layerDrawable;
        }
        Drawable[] drawableArr = new Drawable[numberOfLayers];
        boolean z16 = false;
        for (int i3 = 0; i3 < numberOfLayers; i3++) {
            Drawable drawable = layerDrawable.getDrawable(i3);
            Drawable g16 = g(context, drawable);
            if (g16 != null && g16 != drawable) {
                drawableArr[i3] = g16;
                z16 = true;
            } else {
                drawableArr[i3] = drawable;
            }
        }
        if (z16) {
            LayerDrawable layerDrawable2 = new LayerDrawable(drawableArr);
            a(layerDrawable, layerDrawable2);
            return layerDrawable2;
        }
        return layerDrawable;
    }

    private RotateDrawable k(Context context, RotateDrawable rotateDrawable) {
        Drawable g16;
        Drawable drawable = rotateDrawable.getDrawable();
        if (drawable != null && (g16 = g(context, drawable)) != null && g16 != drawable) {
            RotateDrawable rotateDrawable2 = (RotateDrawable) rotateDrawable.getConstantState().newDrawable();
            rotateDrawable2.setDrawable(g16);
            return rotateDrawable2;
        }
        return rotateDrawable;
    }

    private SkinnableBitmapDrawable l(Context context, SkinnableBitmapDrawable skinnableBitmapDrawable) {
        String charSequence;
        ae0.a aVar;
        int[] color;
        SkinData skinData;
        Drawable.ConstantState constantState = skinnableBitmapDrawable.getConstantState();
        if (!(constantState instanceof BaseConstantState)) {
            return skinnableBitmapDrawable;
        }
        SkinData skinData2 = ((BaseConstantState) constantState).skinData;
        if (skinData2 == null) {
            return skinnableBitmapDrawable;
        }
        int i3 = skinData2.mOriginalResourcesId;
        if (i3 != 0 && i3 != skinData2.mResourcesID) {
            try {
                ud0.d.a("QUIProfileSkin_DrawableTint", ud0.d.f438811e, "tintSkinnableBitmapDrawable tint origin drawable " + skinData2.mFileName + " -> " + skinData2.mOriginalFileName);
                BaseConstantState c16 = c(context, skinData2.mOriginalResourcesId, skinData2.mOriginalFileName);
                if (c16 != null && (skinData = c16.skinData) != null && skinData.mOriginalResourcesId == 0) {
                    Drawable newDrawable = c16.newDrawable(context.getApplicationContext().getResources());
                    if (newDrawable instanceof SkinnableBitmapDrawable) {
                        return l(context, (SkinnableBitmapDrawable) newDrawable);
                    }
                    ud0.d.k("QUIProfileSkin_DrawableTint", ud0.d.f438811e, "origin drawable " + skinData2.mOriginalFileName + " is not SkinnableBitmapDrawable");
                } else {
                    ud0.d.k("QUIProfileSkin_DrawableTint", ud0.d.f438811e, "load origin constantState fail, resId=" + skinData2.mOriginalResourcesId + ", fileName=" + skinData2.mOriginalFileName);
                }
            } catch (Exception e16) {
                ud0.d.b("QUIProfileSkin_DrawableTint", ud0.d.f438811e, "tintSkinnableBitmapDrawable exception", e16);
            }
            return skinnableBitmapDrawable;
        }
        String str = null;
        if (skinData2.mTintColorResId != 0) {
            try {
                TypedValue typedValue = new TypedValue();
                context.getResources().getValue(skinData2.mTintColorResId, typedValue, true);
                CharSequence charSequence2 = typedValue.string;
                if (charSequence2 != null && (charSequence = charSequence2.toString()) != null) {
                    str = charSequence.substring(charSequence.lastIndexOf("/") + 1);
                }
            } catch (Exception e17) {
                ud0.d.b("QUIProfileSkin_DrawableTint", ud0.d.f438811e, "tintSkinnableBitmapDrawable getResourceEntryName", e17);
            }
        } else {
            String str2 = skinData2.mFileName;
            if (str2 != null && str2.startsWith("qui_") && skinData2.mFileName.endsWith(".png")) {
                str = this.f30737d;
            }
        }
        if (!TextUtils.isEmpty(str) && (aVar = this.f30735b) != null && (color = aVar.getColor(str)) != null && color.length > 0) {
            SkinnableBitmapDrawable skinnableBitmapDrawable2 = (SkinnableBitmapDrawable) d(skinnableBitmapDrawable);
            if (skinnableBitmapDrawable2 == null) {
                ud0.d.b("QUIProfileSkin_DrawableTint", ud0.d.f438811e, "mutate SkinnableBitmapDrawable error, fileName=" + skinData2.mFileName + ", colorToken=" + str);
                return skinnableBitmapDrawable;
            }
            skinnableBitmapDrawable2.setColorFilter(new PorterDuffColorFilter(color[0], PorterDuff.Mode.SRC_IN));
            if (e(str)) {
                ud0.d.g("QUIProfileSkin_DrawableTint", ud0.d.f438811e, "[SkinnableBitmapDrawableTint] colorToken=" + str + ", color=" + n(color[0]) + ", srcDrawable=" + skinnableBitmapDrawable + ", tintDrawable=" + skinnableBitmapDrawable2);
            }
            return skinnableBitmapDrawable2;
        }
        return skinnableBitmapDrawable;
    }

    private StateListDrawable m(Context context, StateListDrawable stateListDrawable) {
        List<a> f16 = f(stateListDrawable);
        boolean z16 = false;
        for (a aVar : f16) {
            Drawable g16 = g(context, aVar.f30741b);
            if (g16 != null && g16 != aVar.f30741b) {
                aVar.f30741b = g16;
                z16 = true;
            }
        }
        if (z16) {
            StateListDrawable stateListDrawable2 = new StateListDrawable();
            for (a aVar2 : f16) {
                stateListDrawable2.addState(aVar2.f30740a, aVar2.f30741b);
            }
            return stateListDrawable2;
        }
        return stateListDrawable;
    }

    private String n(int i3) {
        try {
            return Integer.toHexString(i3);
        } catch (Exception e16) {
            ud0.d.b("QUIProfileSkin_DrawableTint", ud0.d.f438811e, "toColorHexString error:", e16);
            return "";
        }
    }

    public Drawable g(Context context, Drawable drawable) {
        Drawable drawable2;
        if (this.f30735b == null) {
            return drawable;
        }
        if (drawable instanceof StateListDrawable) {
            drawable2 = m(context, (StateListDrawable) drawable);
        } else {
            if (!(drawable instanceof BitmapDrawable)) {
                if (drawable instanceof GradientDrawable) {
                    drawable2 = i((GradientDrawable) drawable);
                } else if (drawable instanceof LayerDrawable) {
                    drawable2 = j(context, (LayerDrawable) drawable);
                } else if (drawable instanceof SkinnableBitmapDrawable) {
                    drawable2 = l(context, (SkinnableBitmapDrawable) drawable);
                } else if (drawable instanceof RotateDrawable) {
                    drawable2 = k(context, (RotateDrawable) drawable);
                }
            }
            drawable2 = drawable;
        }
        if (drawable2 != drawable && drawable.getColorFilter() != null) {
            drawable2.setColorFilter(drawable.getColorFilter());
        }
        return drawable2;
    }
}
