package jk;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RectShape;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.res.ResourcesCompat;
import com.qq.e.comm.managers.plugin.PM;
import com.qzone.common.account.LoginData;
import com.qzone.reborn.util.i;
import com.tencent.ams.mosaic.jsengine.animation.custom.CustomAnimation;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.mutualmark.g;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qq.minibox.api.data.MiniBoxNoticeInfo;
import com.tencent.util.ArrayUtils;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import qzone.QZIntimateProfileReader$IntimateSpaceAbs;
import qzone.QZoneBaseMeta$StUser;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b+\u0010,J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J&\u0010\u000f\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u0002J\u0016\u0010\u0010\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u0002J\u001e\u0010\u0013\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0011J\u0016\u0010\u0016\u001a\u00020\u00152\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u0004J\u000e\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\bJF\u0010#\u001a\u00020\"2\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u00192\u0006\u0010\u001d\u001a\u00020\u00192\u0006\u0010\u001e\u001a\u00020\u00112\u0006\u0010\u001f\u001a\u00020\u00112\u0006\u0010 \u001a\u00020\u00192\u0006\u0010!\u001a\u00020\u0011J\u0006\u0010$\u001a\u00020\u0006J\u0006\u0010%\u001a\u00020\u0015J\u0016\u0010(\u001a\u00020\u00062\u0006\u0010&\u001a\u00020\u00042\u0006\u0010'\u001a\u00020\u0004J\u000e\u0010)\u001a\u00020\u00042\u0006\u0010&\u001a\u00020\u0004J\u000e\u0010*\u001a\u00020\u00062\u0006\u0010&\u001a\u00020\u0004\u00a8\u0006-"}, d2 = {"Ljk/c;", "", "Landroid/widget/ImageView;", "view", "", "picUrl", "", "f", "Lqzone/QZIntimateProfileReader$IntimateSpaceAbs;", "data", "Landroid/view/ViewGroup;", "itemLayout", "Landroid/widget/TextView;", "tvLabelText", "ivLabelIcon", "k", "j", "", "index", "l", "managePageUid", "", "e", "spaceAbs", "a", "", "x0", "y0", "x1", "y1", "startColor", "endColor", "cornerRadius", "viewHeight", "Landroid/graphics/drawable/Drawable;", "c", h.F, "d", "id", "desc", "i", "b", "g", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public static final c f410300a = new c();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0012\u0010\u000b\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016J\b\u0010\f\u001a\u00020\u0006H\u0016\u00a8\u0006\r"}, d2 = {"jk/c$a", "Landroid/graphics/drawable/Drawable;", "Landroid/graphics/Canvas;", PM.CANVAS, "", "draw", "", com.tencent.luggage.wxa.c8.c.f123400v, "setAlpha", "Landroid/graphics/ColorFilter;", CustomAnimation.KeyPath.COLOR_FILTER, "setColorFilter", "getOpacity", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes38.dex */
    public static final class a extends Drawable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ShapeDrawable f410301a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ float f410302b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ Paint f410303c;

        a(ShapeDrawable shapeDrawable, float f16, Paint paint) {
            this.f410301a = shapeDrawable;
            this.f410302b = f16;
            this.f410303c = paint;
        }

        @Override // android.graphics.drawable.Drawable
        public void draw(Canvas canvas) {
            Intrinsics.checkNotNullParameter(canvas, "canvas");
            this.f410301a.draw(canvas);
            RectF rectF = new RectF(0.0f, 0.0f, getBounds().right, getBounds().bottom);
            float f16 = this.f410302b;
            canvas.drawRoundRect(rectF, f16, f16, this.f410303c);
        }

        @Override // android.graphics.drawable.Drawable
        public int getOpacity() {
            return this.f410301a.getOpacity();
        }

        @Override // android.graphics.drawable.Drawable
        public void setAlpha(int alpha) {
            this.f410301a.setAlpha(alpha);
        }

        @Override // android.graphics.drawable.Drawable
        public void setColorFilter(ColorFilter colorFilter) {
            this.f410301a.setColorFilter(colorFilter);
        }
    }

    c() {
    }

    private final void f(ImageView view, String picUrl) {
        Option e16 = com.tencent.mobileqq.qzone.picload.c.e(g.r(picUrl));
        e16.setTargetView(view);
        if (view.getLayoutParams() != null) {
            e16.setRequestWidth(view.getLayoutParams().width);
            e16.setRequestHeight(view.getLayoutParams().height);
        }
        e16.setLoadingDrawable(ResourcesCompat.getDrawable(view.getResources(), R.drawable.qui_common_fill_light_secondary_bg, null));
        e16.setFailedDrawable(ResourcesCompat.getDrawable(view.getResources(), R.drawable.qui_common_fill_light_secondary_bg, null));
        com.tencent.mobileqq.qzone.picload.c.a().h(e16);
    }

    public final String a(QZIntimateProfileReader$IntimateSpaceAbs spaceAbs) {
        Intrinsics.checkNotNullParameter(spaceAbs, "spaceAbs");
        String str = spaceAbs.space_type.get() + spaceAbs.space_id.get();
        if (spaceAbs.user.isEmpty()) {
            return str;
        }
        return str + spaceAbs.user.get(0).uid.get();
    }

    public final String b(String id5) {
        Intrinsics.checkNotNullParameter(id5, "id");
        String j3 = i.b().j("MANAGE_SPACE_DESC_PREFIX" + id5, "");
        Intrinsics.checkNotNullExpressionValue(j3, "g().getString(MANAGE_SPACE_DESC_PREFIX + id, \"\")");
        return j3;
    }

    public final boolean d() {
        long h16 = i.b().h("INTIMATE_MANAGE_DESC_TIME_CHANGE_INTERVAL", 0L);
        long currentTimeMillis = System.currentTimeMillis();
        long j3 = currentTimeMillis - h16;
        QLog.i("QZIntimateManagePageHelper", 4, "last change time is " + h16 + ", current time is " + currentTimeMillis + ", interval is " + j3);
        return j3 >= MiniBoxNoticeInfo.MIN_5;
    }

    public final boolean e(QZIntimateProfileReader$IntimateSpaceAbs data, String managePageUid) {
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(managePageUid, "managePageUid");
        List<QZoneBaseMeta$StUser> list = data.user.get();
        if (TextUtils.equals(managePageUid, LoginData.getInstance().getUid())) {
            return true;
        }
        Iterator<QZoneBaseMeta$StUser> it = list.iterator();
        while (it.hasNext()) {
            if (TextUtils.equals(it.next().uid.get(), LoginData.getInstance().getUid())) {
                return true;
            }
        }
        return false;
    }

    public final void g(String id5) {
        Intrinsics.checkNotNullParameter(id5, "id");
        i.b().t("MANAGE_SPACE_DESC_PREFIX" + id5);
    }

    public final void h() {
        i.b().p("INTIMATE_MANAGE_DESC_TIME_CHANGE_INTERVAL", System.currentTimeMillis());
    }

    public final void i(String id5, String desc) {
        Intrinsics.checkNotNullParameter(id5, "id");
        Intrinsics.checkNotNullParameter(desc, "desc");
        i.b().r("MANAGE_SPACE_DESC_PREFIX" + id5, desc);
    }

    public final void j(QZIntimateProfileReader$IntimateSpaceAbs data, ImageView ivLabelIcon) {
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(ivLabelIcon, "ivLabelIcon");
        String str = data.relation_icon.relation_icon.get();
        Intrinsics.checkNotNullExpressionValue(str, "data.relation_icon.relation_icon.get()");
        if (str.length() == 0) {
            ivLabelIcon.setVisibility(8);
            return;
        }
        ivLabelIcon.setVisibility(0);
        String str2 = data.relation_icon.relation_icon.get();
        Intrinsics.checkNotNullExpressionValue(str2, "data.relation_icon.relation_icon.get()");
        f(ivLabelIcon, str2);
    }

    public final void k(QZIntimateProfileReader$IntimateSpaceAbs data, ViewGroup itemLayout, TextView tvLabelText, ImageView ivLabelIcon) {
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(itemLayout, "itemLayout");
        Intrinsics.checkNotNullParameter(tvLabelText, "tvLabelText");
        Intrinsics.checkNotNullParameter(ivLabelIcon, "ivLabelIcon");
        String str = data.relation_icon.relation_icon.get();
        Intrinsics.checkNotNullExpressionValue(str, "data.relation_icon.relation_icon.get()");
        if (str.length() == 0) {
            ivLabelIcon.setVisibility(8);
        } else {
            ivLabelIcon.setVisibility(0);
            String str2 = data.relation_icon.relation_icon.get();
            Intrinsics.checkNotNullExpressionValue(str2, "data.relation_icon.relation_icon.get()");
            f(ivLabelIcon, str2);
        }
        String str3 = data.relation_icon.icon_description.get();
        Intrinsics.checkNotNullExpressionValue(str3, "data.relation_icon.icon_description.get()");
        if (str3.length() == 0) {
            tvLabelText.setVisibility(8);
        } else {
            tvLabelText.setVisibility(0);
            tvLabelText.setText(data.relation_icon.icon_description.get());
            mk.d dVar = mk.d.f416875a;
            if (dVar.y(Integer.valueOf(data.space_type.get()))) {
                itemLayout.setBackgroundResource(R.drawable.f15844z);
                tvLabelText.setTextColor(Color.parseColor("#FF4591"));
            } else if (dVar.w(Integer.valueOf(data.space_type.get()))) {
                itemLayout.setBackgroundResource(R.drawable.f15834y);
                tvLabelText.setTextColor(Color.parseColor("#0099FF"));
            } else if (dVar.H(Integer.valueOf(data.space_type.get()))) {
                itemLayout.setBackgroundResource(R.drawable.f158550);
                tvLabelText.setTextColor(Color.parseColor("#FF8730"));
            } else if (dVar.t(Integer.valueOf(data.space_type.get()))) {
                itemLayout.setBackgroundResource(R.drawable.f15824x);
                tvLabelText.setTextColor(Color.parseColor("#7B65FF"));
            }
        }
        if (ivLabelIcon.getVisibility() == 8 && tvLabelText.getVisibility() == 8) {
            itemLayout.setVisibility(8);
        } else {
            itemLayout.setVisibility(0);
        }
    }

    public final void l(QZIntimateProfileReader$IntimateSpaceAbs data, ImageView ivLabelIcon, int index) {
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(ivLabelIcon, "ivLabelIcon");
        if (ArrayUtils.isOutOfArrayIndex(index, data.partners.get())) {
            ivLabelIcon.setVisibility(8);
            return;
        }
        ivLabelIcon.setVisibility(0);
        String str = data.partners.get(index).partner_icon.relation_icon.get();
        Intrinsics.checkNotNullExpressionValue(str, "data.partners[index].par\u2026_icon.relation_icon.get()");
        f(ivLabelIcon, str);
    }

    public final Drawable c(float x06, float y06, float x16, float y16, int startColor, int endColor, float cornerRadius, int viewHeight) {
        Bitmap createBitmap = Bitmap.createBitmap(1, viewHeight, Bitmap.Config.ARGB_8888);
        Paint paint = new Paint();
        paint.setShader(new LinearGradient(x06, y06, x16, y16, startColor, endColor, Shader.TileMode.CLAMP));
        new Canvas(createBitmap).drawRect(0.0f, 0.0f, 1.0f, viewHeight, paint);
        ShapeDrawable shapeDrawable = new ShapeDrawable(new RectShape());
        Paint paint2 = shapeDrawable.getPaint();
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        paint2.setShader(new BitmapShader(createBitmap, tileMode, tileMode));
        shapeDrawable.getPaint().setAntiAlias(true);
        shapeDrawable.setIntrinsicHeight(viewHeight);
        shapeDrawable.setPadding(0, 0, 0, 0);
        return new a(shapeDrawable, cornerRadius, paint);
    }
}
