package com.nineoldandroids.animation;

import android.view.View;
import com.nineoldandroids.util.FloatProperty;
import com.nineoldandroids.util.IntProperty;
import com.nineoldandroids.util.Property;
import com.nineoldandroids.view.animation.AnimatorProxy;
import com.tencent.ams.mosaic.jsengine.animation.basic.BasicAnimation;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.luggage.wxa.c8.c;

/* loaded from: classes2.dex */
final class PreHoneycombCompat {
    static Property<View, Float> ALPHA = new FloatProperty<View>(c.f123400v) { // from class: com.nineoldandroids.animation.PreHoneycombCompat.1
        @Override // com.nineoldandroids.util.Property
        public Float get(View view) {
            return Float.valueOf(AnimatorProxy.wrap(view).getAlpha());
        }

        @Override // com.nineoldandroids.util.FloatProperty
        public void setValue(View view, float f16) {
            AnimatorProxy.wrap(view).setAlpha(f16);
        }
    };
    static Property<View, Float> PIVOT_X = new FloatProperty<View>("pivotX") { // from class: com.nineoldandroids.animation.PreHoneycombCompat.2
        @Override // com.nineoldandroids.util.Property
        public Float get(View view) {
            return Float.valueOf(AnimatorProxy.wrap(view).getPivotX());
        }

        @Override // com.nineoldandroids.util.FloatProperty
        public void setValue(View view, float f16) {
            AnimatorProxy.wrap(view).setPivotX(f16);
        }
    };
    static Property<View, Float> PIVOT_Y = new FloatProperty<View>("pivotY") { // from class: com.nineoldandroids.animation.PreHoneycombCompat.3
        @Override // com.nineoldandroids.util.Property
        public Float get(View view) {
            return Float.valueOf(AnimatorProxy.wrap(view).getPivotY());
        }

        @Override // com.nineoldandroids.util.FloatProperty
        public void setValue(View view, float f16) {
            AnimatorProxy.wrap(view).setPivotY(f16);
        }
    };
    static Property<View, Float> TRANSLATION_X = new FloatProperty<View>("translationX") { // from class: com.nineoldandroids.animation.PreHoneycombCompat.4
        @Override // com.nineoldandroids.util.Property
        public Float get(View view) {
            return Float.valueOf(AnimatorProxy.wrap(view).getTranslationX());
        }

        @Override // com.nineoldandroids.util.FloatProperty
        public void setValue(View view, float f16) {
            AnimatorProxy.wrap(view).setTranslationX(f16);
        }
    };
    static Property<View, Float> TRANSLATION_Y = new FloatProperty<View>("translationY") { // from class: com.nineoldandroids.animation.PreHoneycombCompat.5
        @Override // com.nineoldandroids.util.Property
        public Float get(View view) {
            return Float.valueOf(AnimatorProxy.wrap(view).getTranslationY());
        }

        @Override // com.nineoldandroids.util.FloatProperty
        public void setValue(View view, float f16) {
            AnimatorProxy.wrap(view).setTranslationY(f16);
        }
    };
    static Property<View, Float> ROTATION = new FloatProperty<View>(BasicAnimation.KeyPath.ROTATION) { // from class: com.nineoldandroids.animation.PreHoneycombCompat.6
        @Override // com.nineoldandroids.util.Property
        public Float get(View view) {
            return Float.valueOf(AnimatorProxy.wrap(view).getRotation());
        }

        @Override // com.nineoldandroids.util.FloatProperty
        public void setValue(View view, float f16) {
            AnimatorProxy.wrap(view).setRotation(f16);
        }
    };
    static Property<View, Float> ROTATION_X = new FloatProperty<View>(BasicAnimation.KeyPath.ROTATION_X) { // from class: com.nineoldandroids.animation.PreHoneycombCompat.7
        @Override // com.nineoldandroids.util.Property
        public Float get(View view) {
            return Float.valueOf(AnimatorProxy.wrap(view).getRotationX());
        }

        @Override // com.nineoldandroids.util.FloatProperty
        public void setValue(View view, float f16) {
            AnimatorProxy.wrap(view).setRotationX(f16);
        }
    };
    static Property<View, Float> ROTATION_Y = new FloatProperty<View>(BasicAnimation.KeyPath.ROTATION_Y) { // from class: com.nineoldandroids.animation.PreHoneycombCompat.8
        @Override // com.nineoldandroids.util.Property
        public Float get(View view) {
            return Float.valueOf(AnimatorProxy.wrap(view).getRotationY());
        }

        @Override // com.nineoldandroids.util.FloatProperty
        public void setValue(View view, float f16) {
            AnimatorProxy.wrap(view).setRotationY(f16);
        }
    };
    static Property<View, Float> SCALE_X = new FloatProperty<View>(BasicAnimation.KeyPath.SCALE_X) { // from class: com.nineoldandroids.animation.PreHoneycombCompat.9
        @Override // com.nineoldandroids.util.Property
        public Float get(View view) {
            return Float.valueOf(AnimatorProxy.wrap(view).getScaleX());
        }

        @Override // com.nineoldandroids.util.FloatProperty
        public void setValue(View view, float f16) {
            AnimatorProxy.wrap(view).setScaleX(f16);
        }
    };
    static Property<View, Float> SCALE_Y = new FloatProperty<View>(BasicAnimation.KeyPath.SCALE_Y) { // from class: com.nineoldandroids.animation.PreHoneycombCompat.10
        @Override // com.nineoldandroids.util.Property
        public Float get(View view) {
            return Float.valueOf(AnimatorProxy.wrap(view).getScaleY());
        }

        @Override // com.nineoldandroids.util.FloatProperty
        public void setValue(View view, float f16) {
            AnimatorProxy.wrap(view).setScaleY(f16);
        }
    };
    static Property<View, Integer> SCROLL_X = new IntProperty<View>("scrollX") { // from class: com.nineoldandroids.animation.PreHoneycombCompat.11
        @Override // com.nineoldandroids.util.Property
        public Integer get(View view) {
            return Integer.valueOf(AnimatorProxy.wrap(view).getScrollX());
        }

        @Override // com.nineoldandroids.util.IntProperty
        public void setValue(View view, int i3) {
            AnimatorProxy.wrap(view).setScrollX(i3);
        }
    };
    static Property<View, Integer> SCROLL_Y = new IntProperty<View>("scrollY") { // from class: com.nineoldandroids.animation.PreHoneycombCompat.12
        @Override // com.nineoldandroids.util.Property
        public Integer get(View view) {
            return Integer.valueOf(AnimatorProxy.wrap(view).getScrollY());
        }

        @Override // com.nineoldandroids.util.IntProperty
        public void setValue(View view, int i3) {
            AnimatorProxy.wrap(view).setScrollY(i3);
        }
    };
    static Property<View, Float> X = new FloatProperty<View>(HippyTKDListViewAdapter.X) { // from class: com.nineoldandroids.animation.PreHoneycombCompat.13
        @Override // com.nineoldandroids.util.Property
        public Float get(View view) {
            return Float.valueOf(AnimatorProxy.wrap(view).getX());
        }

        @Override // com.nineoldandroids.util.FloatProperty
        public void setValue(View view, float f16) {
            AnimatorProxy.wrap(view).setX(f16);
        }
    };
    static Property<View, Float> Y = new FloatProperty<View>("y") { // from class: com.nineoldandroids.animation.PreHoneycombCompat.14
        @Override // com.nineoldandroids.util.Property
        public Float get(View view) {
            return Float.valueOf(AnimatorProxy.wrap(view).getY());
        }

        @Override // com.nineoldandroids.util.FloatProperty
        public void setValue(View view, float f16) {
            AnimatorProxy.wrap(view).setY(f16);
        }
    };

    PreHoneycombCompat() {
    }
}
