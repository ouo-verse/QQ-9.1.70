package com.tencent.mobileqq.vas.troopnick;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.l;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.vas.VasResEngine.VasResDrawable;
import com.tencent.mobileqq.vas.ui.VasNinePathBitmap;
import com.tencent.mobileqq.vas.utils.CacheHelper;
import kotlin.Triple;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes20.dex */
public class TroopNickResDrawable extends VasResDrawable {
    private Rect C;

    /* renamed from: d, reason: collision with root package name */
    int f311052d;

    /* renamed from: e, reason: collision with root package name */
    private PointF f311053e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f311054f;

    /* renamed from: h, reason: collision with root package name */
    private b f311055h;

    /* renamed from: i, reason: collision with root package name */
    private VasNinePathBitmap f311056i;

    /* renamed from: m, reason: collision with root package name */
    private int f311057m;

    /* compiled from: P */
    /* loaded from: classes20.dex */
    private static class a extends CacheHelper.AbsOptions {

        /* renamed from: b, reason: collision with root package name */
        private final String f311059b;

        public a(String str) {
            this.f311059b = str;
        }

        @Override // com.tencent.mobileqq.vas.utils.CacheHelper.AbsOptions
        @NotNull
        public Object a() {
            Bitmap decodeFile = BitmapFactory.decodeFile(this.f311059b);
            if (decodeFile != null) {
                return decodeFile;
            }
            return Bitmap.createBitmap(1, 1, Bitmap.Config.ARGB_8888);
        }

        @Override // com.tencent.mobileqq.vas.utils.CacheHelper.AbsOptions
        @NotNull
        public String b() {
            return "troopnickname" + this.f311059b;
        }
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public interface b {
        void a(Rect rect);
    }

    public TroopNickResDrawable(Context context, int i3) {
        super(context, i3);
        this.f311052d = 0;
        this.f311054f = false;
        this.f311056i = new VasNinePathBitmap();
        this.f311057m = 0;
        this.C = new Rect();
        this.mCurrent = new VasNinePathBitmap();
        this.f311057m = i3;
    }

    @Override // com.tencent.mobileqq.vas.VasResEngine.VasResDrawable, com.tencent.mobileqq.vas.ui.VipPngPlayAnimationDrawable, android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        h(getBounds());
        super.draw(canvas);
    }

    @Override // com.tencent.mobileqq.vas.VasResEngine.VasResDrawable
    protected void drawBg(@NonNull Canvas canvas) {
        if (this.mFinished) {
            this.f311056i.draw(canvas, null, getBounds(), this.mPaint);
        }
    }

    public int e() {
        return this.f311057m;
    }

    public void f(PointF pointF) {
        this.f311053e = pointF;
        this.f311054f = true;
    }

    public void g(b bVar) {
        this.f311055h = bVar;
    }

    @Override // com.tencent.mobileqq.vas.VasResEngine.VasResDrawable
    protected Drawable getDrawable(String str, final String str2) {
        if (!TextUtils.isEmpty(str2) && this.f311056i.isEmpty()) {
            ThreadManagerV2.executeOnSubThread(new Runnable() { // from class: com.tencent.mobileqq.vas.troopnick.TroopNickResDrawable.1
                @Override // java.lang.Runnable
                public void run() {
                    if (TroopNickResDrawable.this.f311056i.isEmpty()) {
                        TroopNickResDrawable.this.f311056i.next((Bitmap) CacheHelper.a(new a(str2)));
                    }
                }
            });
        }
        return null;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean getPadding(@androidx.annotation.NonNull Rect rect) {
        return super.getPadding(rect);
    }

    public void h(Rect rect) {
        VasNinePathBitmap vasNinePathBitmap;
        byte[] ninePatchChunk;
        if (this.f311053e == null || !this.f311054f || (vasNinePathBitmap = (VasNinePathBitmap) this.mCurrent) == null || (ninePatchChunk = vasNinePathBitmap.getNinePatchChunk()) == null) {
            return;
        }
        Rect rect2 = l.b(ninePatchChunk).f78570d;
        Triple<Boolean, Boolean, Float> calculateScale = VasNinePathBitmap.calculateScale(vasNinePathBitmap.getWidth(), vasNinePathBitmap.getHeight(), this.C);
        if (calculateScale.getFirst().booleanValue() || calculateScale.getSecond().booleanValue()) {
            float floatValue = calculateScale.getThird().floatValue();
            rect2.set((int) (rect2.left / floatValue), (int) (rect2.top / floatValue), (int) (rect2.right / floatValue), (int) (rect2.bottom / floatValue));
        }
        int i3 = rect2.left + rect2.right;
        PointF pointF = this.f311053e;
        if (pointF != null) {
            float f16 = pointF.x;
            if (f16 > 0.0f) {
                rect.right = ((int) f16) + i3;
            }
        }
        this.f311054f = false;
        this.f311052d = rect.right;
        b bVar = this.f311055h;
        if (bVar != null) {
            bVar.a(rect2);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setBounds(Rect rect) {
        super.setBounds(rect);
        this.C.set(getBounds());
    }

    @Override // android.graphics.drawable.Drawable
    public void setBounds(int i3, int i16, int i17, int i18) {
        super.setBounds(i3, i16, i17, i18);
        this.C.set(getBounds());
    }

    public TroopNickResDrawable(AppRuntime appRuntime, int i3) {
        super(appRuntime, i3);
        this.f311052d = 0;
        this.f311054f = false;
        this.f311056i = new VasNinePathBitmap();
        this.f311057m = 0;
        this.C = new Rect();
        this.mCurrent = new VasNinePathBitmap();
        this.f311057m = i3;
    }
}
