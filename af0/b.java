package af0;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.TypeEvaluator;
import android.app.ActivityOptions;
import android.content.Intent;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.text.TextUtils;
import android.util.Property;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes5.dex */
public class b {

    /* renamed from: r, reason: collision with root package name */
    private static ActivityOptions f25956r;

    /* renamed from: s, reason: collision with root package name */
    private static Map<String, String> f25957s;

    /* renamed from: a, reason: collision with root package name */
    private FrameLayout f25959a;

    /* renamed from: b, reason: collision with root package name */
    private View f25960b;

    /* renamed from: c, reason: collision with root package name */
    private af0.a f25961c;

    /* renamed from: d, reason: collision with root package name */
    private bf0.a f25962d;

    /* renamed from: e, reason: collision with root package name */
    private Rect f25963e;

    /* renamed from: f, reason: collision with root package name */
    private ImageView f25964f;

    /* renamed from: g, reason: collision with root package name */
    private ImageView f25965g;

    /* renamed from: h, reason: collision with root package name */
    private f f25966h;

    /* renamed from: i, reason: collision with root package name */
    private File f25967i;

    /* renamed from: j, reason: collision with root package name */
    private String f25968j;

    /* renamed from: k, reason: collision with root package name */
    private int f25969k;

    /* renamed from: l, reason: collision with root package name */
    private int f25970l;

    /* renamed from: m, reason: collision with root package name */
    private ImageView.ScaleType f25971m;

    /* renamed from: n, reason: collision with root package name */
    private int f25972n;

    /* renamed from: o, reason: collision with root package name */
    private int f25973o;

    /* renamed from: p, reason: collision with root package name */
    private AnimatorSet f25974p;

    /* renamed from: q, reason: collision with root package name */
    private static final AccelerateDecelerateInterpolator f25955q = new AccelerateDecelerateInterpolator();

    /* renamed from: t, reason: collision with root package name */
    private static final Property<ImageView, Matrix> f25958t = new d(Matrix.class, "animatedTransform");

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class a implements ViewTreeObserver.OnPreDrawListener {
        a() {
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            b.this.f25965g.getViewTreeObserver().removeOnPreDrawListener(this);
            b bVar = b.this;
            bVar.v(bVar.f25965g.getLeft(), b.this.f25965g.getTop(), b.this.f25965g.getWidth(), b.this.f25965g.getHeight());
            QLog.d("TransitionAnimHelper", 4, "initImageEnterAnimation left:" + b.this.f25965g.getLeft(), ",top:", Integer.valueOf(b.this.f25965g.getTop()), ",width:", Integer.valueOf(b.this.f25965g.getWidth()), ",height:", Integer.valueOf(b.this.f25965g.getHeight()));
            return true;
        }
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    class d extends Property<ImageView, Matrix> {
        d(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Matrix get(ImageView imageView) {
            return null;
        }

        @Override // android.util.Property
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(ImageView imageView, Matrix matrix) {
            Drawable drawable = imageView.getDrawable();
            if (drawable == null) {
                return;
            }
            if (matrix == null) {
                drawable.setBounds(0, 0, imageView.getWidth(), imageView.getHeight());
            } else {
                drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
                if (imageView.getImageMatrix() == null) {
                    imageView.setImageMatrix(new Matrix());
                }
                imageView.setImageMatrix(matrix);
            }
            imageView.invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public static class e implements TypeEvaluator<Matrix> {

        /* renamed from: d, reason: collision with root package name */
        public static TypeEvaluator<Matrix> f25982d = new a();

        /* renamed from: a, reason: collision with root package name */
        float[] f25983a = new float[9];

        /* renamed from: b, reason: collision with root package name */
        float[] f25984b = new float[9];

        /* renamed from: c, reason: collision with root package name */
        Matrix f25985c = new Matrix();

        /* compiled from: P */
        /* loaded from: classes5.dex */
        class a implements TypeEvaluator<Matrix> {
            a() {
            }

            @Override // android.animation.TypeEvaluator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public Matrix evaluate(float f16, Matrix matrix, Matrix matrix2) {
                return null;
            }
        }

        e() {
        }

        @Override // android.animation.TypeEvaluator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Matrix evaluate(float f16, Matrix matrix, Matrix matrix2) {
            matrix.getValues(this.f25983a);
            matrix2.getValues(this.f25984b);
            for (int i3 = 0; i3 < 9; i3++) {
                float[] fArr = this.f25984b;
                float f17 = fArr[i3];
                float f18 = this.f25983a[i3];
                fArr[i3] = f18 + ((f17 - f18) * f16);
            }
            this.f25985c.setValues(this.f25984b);
            return this.f25985c;
        }
    }

    public b(Bundle bundle, bf0.a aVar) {
        if (bundle != null && aVar != null) {
            this.f25962d = aVar;
            u(bundle);
            p();
            r();
            s();
            q();
        }
    }

    private void h() {
        int[] x16 = this.f25962d.x1(this.f25969k, this.f25970l);
        if (x16 != null && x16.length == 2) {
            this.f25972n = x16[0];
            this.f25973o = x16[1];
        }
    }

    private boolean i() {
        if (this.f25963e == null || TextUtils.isEmpty(this.f25968j) || !this.f25967i.isFile() || !this.f25967i.exists() || this.f25969k == 0 || this.f25970l == 0 || this.f25971m == null || this.f25972n == 0 || this.f25973o == 0) {
            return false;
        }
        return true;
    }

    public static boolean j() {
        if (QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_QQ_SUBSCRIBE_SETTING, QzoneConfig.SECONDARY_ENABLE_JUMP_DETAIL_TRANS_ANIMATE, 1) > 0) {
            return true;
        }
        return false;
    }

    public static Intent k(URLImageView uRLImageView, int i3, int i16) {
        String str;
        Intent intent = new Intent();
        if (j()) {
            Bundle bundle = new Bundle();
            int[] iArr = new int[2];
            uRLImageView.getLocationInWindow(iArr);
            uRLImageView.getLocationOnScreen(iArr);
            int i17 = iArr[0];
            bundle.putParcelable("bundle_key_trans_anim_rect", new Rect(i17, iArr[1], uRLImageView.getWidth() + i17, iArr[1] + uRLImageView.getHeight()));
            try {
                File fileInLocal = ((URLDrawable) uRLImageView.getDrawable()).getFileInLocal();
                if (fileInLocal != null) {
                    str = fileInLocal.getPath();
                    String url = ((URLDrawable) uRLImageView.getDrawable()).getURL().toString();
                    if (f25957s == null) {
                        f25957s = new HashMap();
                    }
                    f25957s.clear();
                    f25957s.put(url, str);
                } else {
                    str = "";
                }
                if (!TextUtils.isEmpty(str)) {
                    f25956r = ActivityOptions.makeScaleUpAnimation(uRLImageView, 0, 0, uRLImageView.getWidth(), uRLImageView.getHeight());
                    bundle.putString("bundle_key_source_image_param", new f(str, i3, i16).a());
                    bundle.putSerializable("bundle_key_image_scale_type", uRLImageView.getScaleType());
                    intent.putExtra("bundle_key_parms_extra", bundle);
                    return intent;
                }
            } catch (Exception e16) {
                e16.printStackTrace();
                QLog.e("TransitionAnimHelper", 1, "generatePrams getImagePath error!" + e16.toString());
                return intent;
            }
        }
        f25956r = null;
        return intent;
    }

    @RequiresApi(api = 16)
    public static Bundle l() {
        Bundle bundle = new Bundle();
        ActivityOptions activityOptions = f25956r;
        if (activityOptions != null) {
            Bundle bundle2 = activityOptions.toBundle();
            f25956r = null;
            return bundle2;
        }
        return bundle;
    }

    public static Matrix n(ImageView imageView) {
        QLog.d("TransitionAnimHelper", 4, "getImageMatrix, imageView " + imageView);
        int left = imageView.getLeft();
        int top = imageView.getTop();
        int right = imageView.getRight();
        int bottom = imageView.getBottom();
        Rect rect = new Rect(left, top, right, bottom);
        QLog.d("TransitionAnimHelper", 4, "getImageMatrix, left" + left + ",top:" + top + ",right:" + right + ",bottom:" + bottom);
        Drawable drawable = imageView.getDrawable();
        ImageView.ScaleType scaleType = imageView.getScaleType();
        StringBuilder sb5 = new StringBuilder();
        sb5.append("getImageMatrix, scaleType ");
        sb5.append(scaleType);
        QLog.d("TransitionAnimHelper", 4, sb5.toString());
        if (scaleType == ImageView.ScaleType.FIT_XY) {
            Matrix imageMatrix = imageView.getImageMatrix();
            if (!imageMatrix.isIdentity()) {
                return new Matrix(imageMatrix);
            }
            int intrinsicWidth = drawable.getIntrinsicWidth();
            int intrinsicHeight = drawable.getIntrinsicHeight();
            if (intrinsicWidth > 0 && intrinsicHeight > 0) {
                float width = rect.width() / intrinsicWidth;
                float height = rect.height() / intrinsicHeight;
                Matrix matrix = new Matrix();
                matrix.setScale(width, height);
                return matrix;
            }
            return null;
        }
        return new Matrix(imageView.getImageMatrix());
    }

    public static String o(String str) {
        Map<String, String> map = f25957s;
        if (map != null && map.containsKey(str)) {
            return f25957s.get(str);
        }
        return "";
    }

    private void p() {
        af0.a aVar = this.f25961c;
        if (aVar != null && aVar.b()) {
            return;
        }
        this.f25959a = new FrameLayout(BaseApplication.getContext());
        this.f25960b = new View(BaseApplication.getContext());
        this.f25959a.addView(this.f25960b, new FrameLayout.LayoutParams(-1, -1));
        this.f25960b.setBackgroundColor(-1);
    }

    private void q() {
        af0.a aVar = this.f25961c;
        if (aVar != null && aVar.c()) {
            ImageView imageView = this.f25965g;
            if (imageView != null) {
                imageView.getViewTreeObserver().addOnPreDrawListener(new a());
                return;
            }
            return;
        }
        QLog.d("TransitionAnimHelper", 1, "initImageEnterAnimation error!");
    }

    private void r() {
        af0.a aVar = this.f25961c;
        if ((aVar == null || !aVar.b()) && this.f25959a != null) {
            ImageView imageView = new ImageView(this.f25959a.getContext());
            this.f25964f = imageView;
            this.f25959a.addView(imageView);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f25964f.getLayoutParams();
            layoutParams.width = this.f25963e.width();
            layoutParams.height = this.f25963e.height();
            Rect rect = this.f25963e;
            layoutParams.setMargins(rect.left, rect.top, 0, 0);
            this.f25964f.setScaleType(this.f25971m);
            this.f25964f.setImageURI(Uri.fromFile(this.f25967i));
        }
    }

    private void s() {
        af0.a aVar = this.f25961c;
        if (aVar != null && aVar.b()) {
            return;
        }
        if (this.f25959a != null) {
            ImageView imageView = new ImageView(this.f25959a.getContext());
            this.f25965g = imageView;
            this.f25959a.addView(imageView);
            this.f25965g.setVisibility(4);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.f25972n, this.f25973o);
            layoutParams.gravity = 1;
            layoutParams.topMargin = this.f25962d.I1();
            this.f25965g.setLayoutParams(layoutParams);
        }
        this.f25965g.setScaleType(this.f25971m);
        this.f25965g.setImageURI(Uri.fromFile(this.f25967i));
        af0.a aVar2 = this.f25961c;
        if (aVar2 != null) {
            aVar2.e(1);
        }
    }

    public static boolean t(Bundle bundle) {
        if (bundle != null) {
            return bundle.containsKey("bundle_key_trans_anim_rect");
        }
        return false;
    }

    private void u(Bundle bundle) {
        this.f25961c = new af0.a();
        this.f25963e = (Rect) bundle.getParcelable("bundle_key_trans_anim_rect");
        String string = bundle.getString("bundle_key_source_image_param");
        f fVar = new f();
        this.f25966h = fVar;
        fVar.b(string);
        this.f25968j = this.f25966h.f25986a;
        this.f25967i = new File(this.f25968j);
        f fVar2 = this.f25966h;
        this.f25969k = fVar2.f25987b;
        this.f25970l = fVar2.f25988c;
        this.f25971m = (ImageView.ScaleType) bundle.getSerializable("bundle_key_image_scale_type");
        h();
        if (!i()) {
            this.f25961c.d();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v(int i3, int i16, int i17, int i18) {
        af0.a aVar = this.f25961c;
        if (aVar != null) {
            aVar.e(2);
        }
        ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this.f25964f, PropertyValuesHolder.ofInt("left", this.f25964f.getLeft(), i3), PropertyValuesHolder.ofInt("top", this.f25964f.getTop(), i16), PropertyValuesHolder.ofInt("right", this.f25964f.getRight(), i3 + i17), PropertyValuesHolder.ofInt("bottom", this.f25964f.getBottom(), i16 + i18));
        ofPropertyValuesHolder.addListener(new C0031b(i18, i17, i3, i16));
        Matrix n3 = n(this.f25964f);
        Matrix n16 = n(this.f25965g);
        this.f25964f.setScaleType(ImageView.ScaleType.MATRIX);
        ObjectAnimator ofObject = ObjectAnimator.ofObject(this.f25964f, (Property<ImageView, V>) f25958t, (TypeEvaluator) new e(), (Object[]) new Matrix[]{n3, n16});
        ObjectAnimator ofInt = ObjectAnimator.ofInt(this.f25960b, "backgroundColor", -1, 16777215);
        ofInt.setEvaluator(new ArgbEvaluator());
        AnimatorSet animatorSet = new AnimatorSet();
        this.f25974p = animatorSet;
        animatorSet.setDuration(200L);
        this.f25974p.setInterpolator(f25955q);
        this.f25974p.addListener(new c());
        this.f25974p.playTogether(ofPropertyValuesHolder, ofObject, ofInt);
        this.f25974p.start();
    }

    public FrameLayout m() {
        return this.f25959a;
    }

    public void w(bf0.b bVar) {
        af0.a aVar = this.f25961c;
        if (aVar != null) {
            aVar.a(bVar);
        }
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public static class f {

        /* renamed from: a, reason: collision with root package name */
        public String f25986a;

        /* renamed from: b, reason: collision with root package name */
        int f25987b;

        /* renamed from: c, reason: collision with root package name */
        int f25988c;

        /* renamed from: d, reason: collision with root package name */
        private final String f25989d = "image_url";

        /* renamed from: e, reason: collision with root package name */
        private final String f25990e = "image_width";

        /* renamed from: f, reason: collision with root package name */
        private final String f25991f = "image_height";

        public f(String str, int i3, int i16) {
            this.f25986a = str;
            this.f25987b = i3;
            this.f25988c = i16;
        }

        public String a() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("image_url", this.f25986a);
                jSONObject.put("image_width", this.f25987b);
                jSONObject.put("image_height", this.f25988c);
            } catch (JSONException e16) {
                e16.printStackTrace();
            }
            return jSONObject.toString();
        }

        public void b(String str) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                this.f25986a = jSONObject.getString("image_url");
                this.f25987b = jSONObject.getInt("image_width");
                this.f25988c = jSONObject.getInt("image_height");
            } catch (JSONException e16) {
                e16.printStackTrace();
            }
        }

        public f() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: af0.b$b, reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C0031b extends com.tencent.mobileqq.widget.f {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f25976d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f25977e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ int f25978f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ int f25979h;

        C0031b(int i3, int i16, int i17, int i18) {
            this.f25976d = i3;
            this.f25977e = i16;
            this.f25978f = i17;
            this.f25979h = i18;
        }

        @Override // com.tencent.mobileqq.widget.f, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) b.this.f25964f.getLayoutParams();
            layoutParams.height = this.f25976d;
            layoutParams.width = this.f25977e;
            layoutParams.setMargins(this.f25978f, this.f25979h, 0, 0);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // com.tencent.mobileqq.widget.f, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class c extends com.tencent.mobileqq.widget.f {
        c() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            b.this.f25974p = null;
        }

        @Override // com.tencent.mobileqq.widget.f, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (b.this.f25961c != null) {
                b.this.f25961c.e(3);
            }
            if (b.this.f25974p != null) {
                b.this.f25959a.setAlpha(0.0f);
                b.this.f25974p = null;
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // com.tencent.mobileqq.widget.f, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }
}
