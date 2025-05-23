package com.tencent.mobileqq.weather.part;

import android.graphics.Camera;
import android.graphics.Matrix;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.utils.ViewUtils;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\"\u0010#J(\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0002H\u0016J\u001a\u0010\r\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0014R\u0014\u0010\u0010\u001a\u00020\t8\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0012\u001a\u00020\t8\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u000fR\u0016\u0010\u0014\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u000fR\u0016\u0010\u0016\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u000fR\u0014\u0010\u001a\u001a\u00020\u00178\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001c\u001a\u00020\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u000fR\u0014\u0010\u001f\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0014\u0010!\u001a\u00020\t8\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b \u0010\u000f\u00a8\u0006$"}, d2 = {"Lcom/tencent/mobileqq/weather/part/ad;", "Landroid/view/animation/Animation;", "", "width", "height", "parentWidth", "parentHeight", "", "initialize", "", "interpolatedTime", "Landroid/view/animation/Transformation;", "transformation", "applyTransformation", "d", UserInfo.SEX_FEMALE, "degree", "e", "cameraDistance", "f", "centerX", tl.h.F, "centerY", "Landroid/graphics/Camera;", "i", "Landroid/graphics/Camera;", "camera", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "xTrans", BdhLogUtil.LogTag.Tag_Conn, "I", "yTrans", "D", "targetScale", "<init>", "()V", "qq-weather-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class ad extends Animation {
    static IPatchRedirector $redirector_;

    /* renamed from: C, reason: from kotlin metadata */
    private final int yTrans;

    /* renamed from: D, reason: from kotlin metadata */
    private final float targetScale;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final float degree;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final float cameraDistance;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private float centerX;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private float centerY;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Camera camera;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final float xTrans;

    public ad() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.degree = 180.0f;
        this.cameraDistance = 60.0f;
        this.camera = new Camera();
        this.xTrans = ViewUtils.getScreenWidth() / 2.0f;
        this.yTrans = ViewUtils.dpToPx(180.0f) * (-1);
        this.targetScale = 0.9f;
    }

    @Override // android.view.animation.Animation
    protected void applyTransformation(float interpolatedTime, @Nullable Transformation transformation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, Float.valueOf(interpolatedTime), transformation);
            return;
        }
        if (transformation == null) {
            return;
        }
        Matrix matrix = transformation.getMatrix();
        this.camera.save();
        this.camera.rotateY(this.degree * interpolatedTime);
        this.camera.getMatrix(matrix);
        float f16 = 1;
        float f17 = this.targetScale;
        matrix.postScale(f16 - (f17 * interpolatedTime), f16 - (f17 * interpolatedTime));
        float f18 = -1;
        matrix.preTranslate(this.centerX * f18, this.centerY * f18);
        matrix.postTranslate(this.centerX + (this.xTrans * interpolatedTime), this.centerY + (this.yTrans * interpolatedTime));
        this.camera.restore();
    }

    @Override // android.view.animation.Animation
    public void initialize(int width, int height, int parentWidth, int parentHeight) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Integer.valueOf(width), Integer.valueOf(height), Integer.valueOf(parentWidth), Integer.valueOf(parentHeight));
            return;
        }
        super.initialize(width, height, parentWidth, parentHeight);
        this.centerX = width / 2.0f;
        this.centerY = height / 2.0f;
        this.camera.setLocation(0.0f, 0.0f, this.cameraDistance);
    }
}
