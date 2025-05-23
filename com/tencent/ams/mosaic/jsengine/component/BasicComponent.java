package com.tencent.ams.mosaic.jsengine.component;

import android.animation.Animator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewOutlineProvider;
import androidx.annotation.RequiresApi;
import com.tencent.ams.mosaic.f;
import com.tencent.ams.mosaic.jsengine.animation.Animation;
import com.tencent.ams.mosaic.jsengine.animation.group.GroupAnimationImpl;
import com.tencent.ams.mosaic.jsengine.component.container.Container;
import com.tencent.ams.mosaic.utils.MosaicUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes3.dex */
public abstract class BasicComponent extends ComponentBase {
    static IPatchRedirector $redirector_ = null;
    public static final float NOT_SET = Float.MIN_VALUE;
    protected float mAnchorPointX;
    protected float mAnchorPointY;
    protected Animator mAnimator;
    private String mBackgroundColor;
    private Drawable mBackgroundDrawable;
    private d mBackgroundGradient;
    private String mBackgroundSrc;
    protected String mBorderColor;
    protected float mBorderWidth;
    private c mBoxShadow;
    protected float[] mCornerRadii;
    protected float mCornerRadius;

    /* compiled from: P */
    /* loaded from: classes3.dex */
    class a implements f.c.a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f70908a;

        a(String str) {
            this.f70908a = str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) BasicComponent.this, (Object) str);
            }
        }

        @Override // com.tencent.ams.mosaic.f.c.a
        public void onLoadFinish(Object obj) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, obj);
                return;
            }
            if (!TextUtils.equals(this.f70908a, BasicComponent.this.mBackgroundSrc)) {
                return;
            }
            if (obj instanceof Bitmap) {
                BasicComponent.this.mBackgroundDrawable = new BitmapDrawable((Bitmap) obj);
            } else if (obj instanceof Drawable) {
                BasicComponent.this.mBackgroundDrawable = (Drawable) obj;
            }
            com.tencent.ams.mosaic.utils.f.a(BasicComponent.this.tag(), "setBackgroundDrawable: " + this.f70908a);
            BasicComponent.this.invalidateBackground();
        }

        @Override // com.tencent.ams.mosaic.f.c.a
        public void onLoadStart() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public class b extends ViewOutlineProvider {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ float f70910a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ float[] f70911b;

        b(float f16, float[] fArr) {
            this.f70910a = f16;
            this.f70911b = fArr;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, BasicComponent.this, Float.valueOf(f16), fArr);
            }
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(View view, Outline outline) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view, (Object) outline);
                return;
            }
            if (this.f70910a > 0.0f) {
                outline.setRoundRect(0, 0, view.getWidth(), view.getHeight(), this.f70910a);
                return;
            }
            float[] fArr = this.f70911b;
            if (fArr != null && fArr.length == 8) {
                if (Build.VERSION.SDK_INT >= 30) {
                    Path path = new Path();
                    path.addRoundRect(new RectF(0.0f, 0.0f, view.getWidth(), view.getHeight()), this.f70911b, Path.Direction.CW);
                    outline.setPath(path);
                } else {
                    outline.setRect(new Rect(0, 0, view.getWidth(), view.getHeight()));
                    com.tencent.ams.mosaic.utils.f.h(BasicComponent.this.tag(), "setViewCornerUseClipToOutline: not support set cornerRadii below Android 11, downgraded to no rounded corners");
                }
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public class c {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        float f70913a;

        /* renamed from: b, reason: collision with root package name */
        float f70914b;

        /* renamed from: c, reason: collision with root package name */
        float f70915c;

        /* renamed from: d, reason: collision with root package name */
        String f70916d;

        /* renamed from: e, reason: collision with root package name */
        protected Paint f70917e;

        public c(float f16, float f17, float f18, String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, BasicComponent.this, Float.valueOf(f16), Float.valueOf(f17), Float.valueOf(f18), str);
                return;
            }
            this.f70913a = f16 <= 0.0f ? 10.0f : f16;
            this.f70914b = f17;
            this.f70915c = f18;
            this.f70916d = str;
            b();
        }

        public void a(Canvas canvas, View view, View view2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, canvas, view, view2);
            } else {
                com.tencent.ams.mosaic.utils.k.a(canvas, view2, this.f70917e, BasicComponent.this.mCornerRadius, MosaicUtils.j(this.f70914b), MosaicUtils.j(this.f70915c));
            }
        }

        void b() {
            BlurMaskFilter blurMaskFilter = new BlurMaskFilter(MosaicUtils.j(this.f70913a), BlurMaskFilter.Blur.NORMAL);
            Paint paint = new Paint();
            this.f70917e = paint;
            paint.setColor(MosaicUtils.O(this.f70916d));
            this.f70917e.setMaskFilter(blurMaskFilter);
        }
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static class d {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        private GradientDrawable.Orientation f70919a;

        /* renamed from: b, reason: collision with root package name */
        private int[] f70920b;

        /* renamed from: c, reason: collision with root package name */
        private float[] f70921c;

        public d(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) str);
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                this.f70919a = e(jSONObject.optString("orientation"));
                this.f70920b = d(jSONObject.optJSONArray(NodeProps.COLORS));
                this.f70921c = f(jSONObject.optJSONArray("positions"));
            } catch (JSONException e16) {
                com.tencent.ams.mosaic.utils.f.i("GradientInfo", "GradientInfo create failed", e16);
            }
        }

        private int[] d(JSONArray jSONArray) {
            if (jSONArray == null) {
                return new int[0];
            }
            int length = jSONArray.length();
            int[] iArr = new int[length];
            for (int i3 = 0; i3 < length; i3++) {
                iArr[i3] = MosaicUtils.O(jSONArray.optString(i3));
            }
            return iArr;
        }

        private GradientDrawable.Orientation e(String str) {
            GradientDrawable.Orientation orientation = GradientDrawable.Orientation.LEFT_RIGHT;
            if (!TextUtils.isEmpty(str)) {
                str.hashCode();
                char c16 = '\uffff';
                switch (str.hashCode()) {
                    case -1196165855:
                        if (str.equals("BOTTOM_TOP")) {
                            c16 = 0;
                            break;
                        }
                        break;
                    case -873241494:
                        if (str.equals("RIGHT_LEFT")) {
                            c16 = 1;
                            break;
                        }
                        break;
                    case 63310483:
                        if (str.equals("BL_TR")) {
                            c16 = 2;
                            break;
                        }
                        break;
                    case 63489223:
                        if (str.equals("BR_TL")) {
                            c16 = 3;
                            break;
                        }
                        break;
                    case 79933303:
                        if (str.equals("TL_BR")) {
                            c16 = 4;
                            break;
                        }
                        break;
                    case 80112043:
                        if (str.equals("TR_BL")) {
                            c16 = 5;
                            break;
                        }
                        break;
                    case 1982197877:
                        if (str.equals("TOP_BOTTOM")) {
                            c16 = 6;
                            break;
                        }
                        break;
                }
                switch (c16) {
                    case 0:
                        return GradientDrawable.Orientation.BOTTOM_TOP;
                    case 1:
                        return GradientDrawable.Orientation.RIGHT_LEFT;
                    case 2:
                        return GradientDrawable.Orientation.BL_TR;
                    case 3:
                        return GradientDrawable.Orientation.BR_TL;
                    case 4:
                        return GradientDrawable.Orientation.TL_BR;
                    case 5:
                        return GradientDrawable.Orientation.TR_BL;
                    case 6:
                        return GradientDrawable.Orientation.TOP_BOTTOM;
                    default:
                        return orientation;
                }
            }
            return orientation;
        }

        private float[] f(JSONArray jSONArray) {
            if (jSONArray == null) {
                return null;
            }
            int length = jSONArray.length();
            float[] fArr = new float[length];
            for (int i3 = 0; i3 < length; i3++) {
                fArr[i3] = (float) jSONArray.optDouble(i3);
            }
            return fArr;
        }

        public int[] c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (int[]) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            return this.f70920b;
        }

        public GradientDrawable.Orientation g() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (GradientDrawable.Orientation) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return this.f70919a;
        }

        public float[] h() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (float[]) iPatchRedirector.redirect((short) 4, (Object) this);
            }
            return this.f70921c;
        }
    }

    public BasicComponent(Context context, String str, float f16, float f17) {
        super(context, str, f16, f17);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, context, str, Float.valueOf(f16), Float.valueOf(f17));
        } else {
            this.mAnchorPointX = Float.MIN_VALUE;
            this.mAnchorPointY = Float.MIN_VALUE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$addAnimation$0(Animator animator, Animation animation) {
        animator.start();
        this.mAnimator = animator;
        com.tencent.ams.mosaic.utils.f.a(tag(), "addAnimation: start - CompID=" + getId() + ", AnimID=" + animation.getAnimID());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$addAnimation$1(final Animation animation) {
        final Animator systemAnimator = animation.getSystemAnimator(this);
        if (systemAnimator != null) {
            MosaicUtils.I(new Runnable() { // from class: com.tencent.ams.mosaic.jsengine.component.b
                @Override // java.lang.Runnable
                public final void run() {
                    BasicComponent.this.lambda$addAnimation$0(systemAnimator, animation);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$invalidateBackground$3() {
        getView().setBackgroundDrawable(this.mBackgroundDrawable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$removeAnimation$2(Animator animator) {
        animator.cancel();
        getView().clearAnimation();
        ArrayList<Animator.AnimatorListener> listeners = animator.getListeners();
        if (listeners != null) {
            Iterator<Animator.AnimatorListener> it = listeners.iterator();
            while (it.hasNext()) {
                Animator.AnimatorListener next = it.next();
                if (next instanceof GroupAnimationImpl.a) {
                    ((GroupAnimationImpl.a) next).a();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setViewCornerUseClipToOutline$4(float f16, float[] fArr) {
        getView().setOutlineProvider(new b(f16, fArr));
        getView().setClipToOutline(true);
    }

    @RequiresApi(api = 21)
    private void setViewCornerUseClipToOutline(final float f16, final float[] fArr) {
        com.tencent.ams.mosaic.utils.f.a(tag(), "setViewCornerUseClipToOutline cornerRadius:" + f16 + ", cornerRadii:" + Arrays.toString(fArr));
        MosaicUtils.I(new Runnable() { // from class: com.tencent.ams.mosaic.jsengine.component.a
            @Override // java.lang.Runnable
            public final void run() {
                BasicComponent.this.lambda$setViewCornerUseClipToOutline$4(f16, fArr);
            }
        });
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.Component
    public void addAnimation(final Animation animation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) animation);
            return;
        }
        if (animation == null) {
            return;
        }
        com.tencent.ams.mosaic.utils.f.a(tag(), "addAnimation, CompID=" + getId() + ", AnimID=" + animation.getAnimID());
        getView().post(new Runnable() { // from class: com.tencent.ams.mosaic.jsengine.component.c
            @Override // java.lang.Runnable
            public final void run() {
                BasicComponent.this.lambda$addAnimation$1(animation);
            }
        });
    }

    public c getBoxShadow() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return (c) iPatchRedirector.redirect((short) 20, (Object) this);
        }
        return this.mBoxShadow;
    }

    protected void invalidateBackground() {
        boolean z16;
        boolean z17;
        boolean z18;
        GradientDrawable gradientDrawable;
        float[] fArr;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this);
            return;
        }
        if (this.mBorderWidth == 0.0f && this.mBorderColor == null) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (this.mCornerRadius == 0.0f && ((fArr = this.mCornerRadii) == null || fArr.length < 4)) {
            z17 = false;
        } else {
            z17 = true;
        }
        d dVar = this.mBackgroundGradient;
        if (dVar != null && dVar.f70920b != null && this.mBackgroundGradient.f70919a != null) {
            z18 = true;
        } else {
            z18 = false;
        }
        if (this.mBackgroundDrawable != null) {
            MosaicUtils.I(new Runnable() { // from class: com.tencent.ams.mosaic.jsengine.component.e
                @Override // java.lang.Runnable
                public final void run() {
                    BasicComponent.this.lambda$invalidateBackground$3();
                }
            });
            return;
        }
        if (!z16 && !z17 && !z18) {
            MosaicUtils.I(new Runnable() { // from class: com.tencent.ams.mosaic.jsengine.component.BasicComponent.7
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) BasicComponent.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    } else {
                        BasicComponent.this.getView().setBackgroundColor(MosaicUtils.O(BasicComponent.this.mBackgroundColor));
                    }
                }
            });
            return;
        }
        if (z18) {
            gradientDrawable = new GradientDrawable(this.mBackgroundGradient.f70919a, this.mBackgroundGradient.f70920b);
            gradientDrawable.setGradientType(0);
        } else {
            gradientDrawable = new GradientDrawable();
            gradientDrawable.setColor(MosaicUtils.O(this.mBackgroundColor));
        }
        if (z16) {
            gradientDrawable.setStroke((int) MosaicUtils.j(this.mBorderWidth), MosaicUtils.O(this.mBorderColor));
        }
        if (z17) {
            float f16 = this.mCornerRadius;
            if (f16 != 0.0f) {
                if (!z16) {
                    setViewCornerUseClipToOutline(MosaicUtils.j(f16), null);
                } else {
                    gradientDrawable.setCornerRadius(MosaicUtils.j(f16));
                }
            } else {
                float[] fArr2 = this.mCornerRadii;
                if (fArr2 != null && fArr2.length >= 4) {
                    float j3 = MosaicUtils.j(fArr2[0]);
                    float j16 = MosaicUtils.j(this.mCornerRadii[1]);
                    float j17 = MosaicUtils.j(this.mCornerRadii[2]);
                    float j18 = MosaicUtils.j(this.mCornerRadii[3]);
                    float[] fArr3 = {j3, j3, j16, j16, j17, j17, j18, j18};
                    gradientDrawable.setCornerRadii(fArr3);
                    if (Build.VERSION.SDK_INT >= 30 && !z16) {
                        setViewCornerUseClipToOutline(0.0f, fArr3);
                    }
                }
            }
        }
        MosaicUtils.I(new Runnable(gradientDrawable) { // from class: com.tencent.ams.mosaic.jsengine.component.BasicComponent.8
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ GradientDrawable f70907d;

            {
                this.f70907d = gradientDrawable;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) BasicComponent.this, (Object) gradientDrawable);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                } else {
                    BasicComponent.this.getView().setBackground(this.f70907d);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.ams.mosaic.jsengine.component.ComponentBase
    public void onActivityDestroyed() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
            return;
        }
        com.tencent.ams.mosaic.utils.f.a(tag(), "onActivityDestroyed");
        super.onActivityDestroyed();
        removeAnimation();
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.ComponentBase, com.tencent.ams.mosaic.jsengine.component.Component
    public void onRemovedFromParent() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
            return;
        }
        com.tencent.ams.mosaic.utils.f.a(tag(), "onRemovedFromParent");
        super.onRemovedFromParent();
        removeAnimation();
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.Component
    public void removeAnimation() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        com.tencent.ams.mosaic.utils.f.a(tag(), "removeAnimation");
        final Animator animator = this.mAnimator;
        if (animator != null) {
            MosaicUtils.I(new Runnable() { // from class: com.tencent.ams.mosaic.jsengine.component.d
                @Override // java.lang.Runnable
                public final void run() {
                    BasicComponent.this.lambda$removeAnimation$2(animator);
                }
            });
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.Component
    public void setAnchorPoint(float f16, float f17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, this, Float.valueOf(f16), Float.valueOf(f17));
            return;
        }
        com.tencent.ams.mosaic.utils.f.a(tag(), "setAnchorPoint axisX:" + f16 + ", axisY:" + f17);
        this.mAnchorPointX = f16;
        this.mAnchorPointY = f17;
        MosaicUtils.I(new Runnable(f16, f17) { // from class: com.tencent.ams.mosaic.jsengine.component.BasicComponent.2
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ float f70899d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ float f70900e;

            {
                this.f70899d = f16;
                this.f70900e = f17;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, BasicComponent.this, Float.valueOf(f16), Float.valueOf(f17));
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                } else {
                    BasicComponent.this.getView().setPivotX(MosaicUtils.j(this.f70899d));
                    BasicComponent.this.getView().setPivotY(MosaicUtils.j(this.f70900e));
                }
            }
        });
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.Component
    public void setBackgroundColor(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
        } else {
            this.mBackgroundColor = str;
            invalidateBackground();
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.Component
    public void setBackgroundDrawable(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) str);
            return;
        }
        this.mBackgroundSrc = str;
        if (TextUtils.isEmpty(str)) {
            this.mBackgroundDrawable = null;
            invalidateBackground();
        } else {
            getImageLoader().loadImage(str, new a(str));
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.Component
    public void setBackgroundGradient(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
        } else {
            this.mBackgroundGradient = new d(str);
            invalidateBackground();
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.Component
    public void setBorder(float f16, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, Float.valueOf(f16), str);
            return;
        }
        com.tencent.ams.mosaic.utils.f.a(tag(), "setBorder borderWidth: " + f16 + ", borderColor: " + str);
        this.mBorderWidth = f16;
        this.mBorderColor = str;
        invalidateBackground();
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.Component
    public void setBoxShadow(float f16, float f17, float f18, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, this, Float.valueOf(f16), Float.valueOf(f17), Float.valueOf(f18), str);
            return;
        }
        this.mBoxShadow = new c(f16, f17, f18, str);
        Container rootView = getJSEngine().d().getRootView();
        if (rootView != null) {
            rootView.getView().invalidate();
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.Component
    public void setCornerRadii(float[] fArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) fArr);
            return;
        }
        com.tencent.ams.mosaic.utils.f.a(tag(), "setCornerRadii: " + Arrays.toString(fArr));
        this.mCornerRadii = fArr;
        invalidateBackground();
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.Component
    public void setCornerRadius(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, Float.valueOf(f16));
            return;
        }
        com.tencent.ams.mosaic.utils.f.a(tag(), "setCornerRadius: " + f16);
        this.mCornerRadius = f16;
        invalidateBackground();
    }

    @Override // com.tencent.ams.mosaic.jsengine.animation.AnimationProperty
    public void setOpacity(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, this, Float.valueOf(f16));
        } else {
            setAlpha(f16);
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.animation.AnimationProperty
    public void setPosition(float f16, float f17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, this, Float.valueOf(f16), Float.valueOf(f17));
        } else {
            MosaicUtils.I(new Runnable(f16, f17) { // from class: com.tencent.ams.mosaic.jsengine.component.BasicComponent.3
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ float f70901d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ float f70902e;

                {
                    this.f70901d = f16;
                    this.f70902e = f17;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, BasicComponent.this, Float.valueOf(f16), Float.valueOf(f17));
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    } else {
                        BasicComponent.this.getView().setX(MosaicUtils.j(this.f70901d));
                        BasicComponent.this.getView().setY(MosaicUtils.j(this.f70902e));
                    }
                }
            });
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.animation.AnimationProperty
    public void setPositionOffset(float f16, float f17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, this, Float.valueOf(f16), Float.valueOf(f17));
        } else {
            MosaicUtils.I(new Runnable(f16, f17) { // from class: com.tencent.ams.mosaic.jsengine.component.BasicComponent.4
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ float f70903d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ float f70904e;

                {
                    this.f70903d = f16;
                    this.f70904e = f17;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, BasicComponent.this, Float.valueOf(f16), Float.valueOf(f17));
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    } else {
                        BasicComponent.this.getView().setTranslationX(MosaicUtils.j(this.f70903d));
                        BasicComponent.this.getView().setTranslationY(MosaicUtils.j(this.f70904e));
                    }
                }
            });
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.animation.AnimationProperty
    public void setRotation(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, this, Float.valueOf(f16));
        } else {
            MosaicUtils.I(new Runnable(f16) { // from class: com.tencent.ams.mosaic.jsengine.component.BasicComponent.6
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ float f70906d;

                {
                    this.f70906d = f16;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, BasicComponent.this, Float.valueOf(f16));
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    } else {
                        BasicComponent.this.getView().setRotation(this.f70906d);
                    }
                }
            });
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.animation.AnimationProperty
    public void setScale(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, this, Float.valueOf(f16));
        } else {
            MosaicUtils.I(new Runnable(f16) { // from class: com.tencent.ams.mosaic.jsengine.component.BasicComponent.5
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ float f70905d;

                {
                    this.f70905d = f16;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, BasicComponent.this, Float.valueOf(f16));
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    } else {
                        BasicComponent.this.getView().setScaleX(this.f70905d);
                        BasicComponent.this.getView().setScaleY(this.f70905d);
                    }
                }
            });
        }
    }
}
