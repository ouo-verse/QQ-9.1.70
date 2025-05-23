package com.tencent.mobileqq.aio.animation.config;

import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.jsengine.animation.basic.BasicAnimation;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\bP\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b^\u0010_R\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\"\u0010\u000f\u001a\u00020\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\"\u0010\u0016\u001a\u00020\u00108\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\r\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\"\u0010\u0018\u001a\u00020\u00108\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\r\u001a\u0004\b\u0017\u0010\u0013\"\u0004\b\n\u0010\u0015R\"\u0010\u001c\u001a\u00020\u00108\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0019\u0010\r\u001a\u0004\b\u001a\u0010\u0013\"\u0004\b\u001b\u0010\u0015R\"\u0010\u001e\u001a\u00020\u00108\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0012\u0010\r\u001a\u0004\b\u0019\u0010\u0013\"\u0004\b\u001d\u0010\u0015R\"\u0010 \u001a\u00020\u00108\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0017\u0010\r\u001a\u0004\b\u0011\u0010\u0013\"\u0004\b\u001f\u0010\u0015R\"\u0010#\u001a\u00020\u00108\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001a\u0010\r\u001a\u0004\b!\u0010\u0013\"\u0004\b\"\u0010\u0015R\"\u0010&\u001a\u00020\u00108\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\r\u001a\u0004\b$\u0010\u0013\"\u0004\b%\u0010\u0015R\"\u0010*\u001a\u00020\u00108\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b'\u0010\r\u001a\u0004\b(\u0010\u0013\"\u0004\b)\u0010\u0015R\"\u0010.\u001a\u00020\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b+\u0010\n\u001a\u0004\b,\u0010\f\"\u0004\b-\u0010\u000eR\"\u00101\u001a\u00020\u00108\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b/\u0010\r\u001a\u0004\b\u0003\u0010\u0013\"\u0004\b0\u0010\u0015R\"\u00104\u001a\u00020\u00108\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b2\u0010\r\u001a\u0004\b\t\u0010\u0013\"\u0004\b3\u0010\u0015R\"\u00108\u001a\u00020\u00108\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b5\u0010\r\u001a\u0004\b6\u0010\u0013\"\u0004\b7\u0010\u0015R\"\u0010<\u001a\u00020\u00108\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b9\u0010\r\u001a\u0004\b:\u0010\u0013\"\u0004\b;\u0010\u0015R\"\u0010@\u001a\u00020\u00108\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b=\u0010\r\u001a\u0004\b>\u0010\u0013\"\u0004\b?\u0010\u0015R\"\u0010C\u001a\u00020\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bA\u0010\n\u001a\u0004\b'\u0010\f\"\u0004\bB\u0010\u000eR\"\u0010F\u001a\u00020\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bD\u0010\n\u001a\u0004\b+\u0010\f\"\u0004\bE\u0010\u000eR\"\u0010I\u001a\u00020\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bG\u0010\n\u001a\u0004\b/\u0010\f\"\u0004\bH\u0010\u000eR\"\u0010L\u001a\u00020\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bJ\u0010\n\u001a\u0004\b5\u0010\f\"\u0004\bK\u0010\u000eR\"\u0010O\u001a\u00020\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bM\u0010\n\u001a\u0004\b9\u0010\f\"\u0004\bN\u0010\u000eR\"\u0010Q\u001a\u00020\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b6\u0010\n\u001a\u0004\b=\u0010\f\"\u0004\bP\u0010\u000eR\"\u0010S\u001a\u00020\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b:\u0010\n\u001a\u0004\bD\u0010\f\"\u0004\bR\u0010\u000eR\"\u0010U\u001a\u00020\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b>\u0010\n\u001a\u0004\bG\u0010\f\"\u0004\bT\u0010\u000eR\"\u0010W\u001a\u00020\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b,\u0010\n\u001a\u0004\bJ\u0010\f\"\u0004\bV\u0010\u000eR\"\u0010Y\u001a\u00020\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b(\u0010\n\u001a\u0004\b2\u0010\f\"\u0004\bX\u0010\u000eR\"\u0010[\u001a\u00020\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b!\u0010\n\u001a\u0004\bA\u0010\f\"\u0004\bZ\u0010\u000eR\"\u0010]\u001a\u00020\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b$\u0010\n\u001a\u0004\bM\u0010\f\"\u0004\b\\\u0010\u000e\u00a8\u0006`"}, d2 = {"Lcom/tencent/mobileqq/aio/animation/config/g;", "", "Lcom/tencent/mobileqq/aio/animation/config/d;", "a", "Lcom/tencent/mobileqq/aio/animation/config/d;", "i", "()Lcom/tencent/mobileqq/aio/animation/config/d;", "emitterProperties", "", "b", "I", "d", "()I", UserInfo.SEX_FEMALE, "(I)V", "emitAreaUnit", "", "c", "f", "()F", "H", "(F)V", "emitAreaX", "g", "emitAreaY", "e", h.F, "J", "emitAreaZ", "G", "emitAreaWidth", "E", "emitAreaHeight", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "b0", "speedX", "B", "c0", "speedY", "j", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "a0", "speedRandom", "k", "y", "Z", "speedAngleRandom", "l", BdhLogUtil.LogTag.Tag_Conn, "accelerationX", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "D", "accelerationY", DomainData.DOMAIN_NAME, "v", "W", "scale", "o", "w", "X", "scaleRandom", "p", HippyTKDListViewAdapter.X, "Y", "scaleSpeed", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "K", BasicAnimation.KeyPath.ROTATION_X, "r", "L", "rotationXRandom", ReportConstant.COSTREPORT_PREFIX, "M", "rotationXSpeed", "t", "O", BasicAnimation.KeyPath.ROTATION_Y, "u", "P", "rotationYRandom", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "rotationYSpeed", ExifInterface.LATITUDE_SOUTH, "rotationZ", "T", "rotationZRandom", "U", "rotationZSpeed", "N", "rotationXSpeedRandom", BdhLogUtil.LogTag.Tag_Req, "rotationYSpeedRandom", "V", "rotationZSpeedRandom", "<init>", "()V", "aio_animation_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class g {
    static IPatchRedirector $redirector_;

    /* renamed from: A, reason: from kotlin metadata */
    private int rotationYSpeedRandom;

    /* renamed from: B, reason: from kotlin metadata */
    private int rotationZSpeedRandom;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final d emitterProperties;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private int emitAreaUnit;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private float emitAreaX;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private float emitAreaY;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private float emitAreaZ;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private float emitAreaWidth;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private float emitAreaHeight;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private float speedX;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private float speedY;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    private float speedRandom;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    private int speedAngleRandom;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    private float accelerationX;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private float accelerationY;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    private float scale;

    /* renamed from: o, reason: collision with root package name and from kotlin metadata */
    private float scaleRandom;

    /* renamed from: p, reason: collision with root package name and from kotlin metadata */
    private float scaleSpeed;

    /* renamed from: q, reason: collision with root package name and from kotlin metadata */
    private int rotationX;

    /* renamed from: r, reason: collision with root package name and from kotlin metadata */
    private int rotationXRandom;

    /* renamed from: s, reason: collision with root package name and from kotlin metadata */
    private int rotationXSpeed;

    /* renamed from: t, reason: collision with root package name and from kotlin metadata */
    private int rotationY;

    /* renamed from: u, reason: collision with root package name and from kotlin metadata */
    private int rotationYRandom;

    /* renamed from: v, reason: collision with root package name and from kotlin metadata */
    private int rotationYSpeed;

    /* renamed from: w, reason: collision with root package name and from kotlin metadata */
    private int rotationZ;

    /* renamed from: x, reason: collision with root package name and from kotlin metadata */
    private int rotationZRandom;

    /* renamed from: y, reason: collision with root package name and from kotlin metadata */
    private int rotationZSpeed;

    /* renamed from: z, reason: collision with root package name and from kotlin metadata */
    private int rotationXSpeedRandom;

    public g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.emitterProperties = new d();
            this.scale = 1.0f;
        }
    }

    public final float A() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Float) iPatchRedirector.redirect((short) 15, (Object) this)).floatValue();
        }
        return this.speedX;
    }

    public final float B() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return ((Float) iPatchRedirector.redirect((short) 17, (Object) this)).floatValue();
        }
        return this.speedY;
    }

    public final void C(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, this, Float.valueOf(f16));
        } else {
            this.accelerationX = f16;
        }
    }

    public final void D(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, this, Float.valueOf(f16));
        } else {
            this.accelerationY = f16;
        }
    }

    public final void E(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, this, Float.valueOf(f16));
        } else {
            this.emitAreaHeight = f16;
        }
    }

    public final void F(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, i3);
        } else {
            this.emitAreaUnit = i3;
        }
    }

    public final void G(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, this, Float.valueOf(f16));
        } else {
            this.emitAreaWidth = f16;
        }
    }

    public final void H(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, Float.valueOf(f16));
        } else {
            this.emitAreaX = f16;
        }
    }

    public final void I(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, Float.valueOf(f16));
        } else {
            this.emitAreaY = f16;
        }
    }

    public final void J(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, Float.valueOf(f16));
        } else {
            this.emitAreaZ = f16;
        }
    }

    public final void K(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
            iPatchRedirector.redirect((short) 34, (Object) this, i3);
        } else {
            this.rotationX = i3;
        }
    }

    public final void L(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 36)) {
            iPatchRedirector.redirect((short) 36, (Object) this, i3);
        } else {
            this.rotationXRandom = i3;
        }
    }

    public final void M(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 38)) {
            iPatchRedirector.redirect((short) 38, (Object) this, i3);
        } else {
            this.rotationXSpeed = i3;
        }
    }

    public final void N(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 52)) {
            iPatchRedirector.redirect((short) 52, (Object) this, i3);
        } else {
            this.rotationXSpeedRandom = i3;
        }
    }

    public final void O(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 40)) {
            iPatchRedirector.redirect((short) 40, (Object) this, i3);
        } else {
            this.rotationY = i3;
        }
    }

    public final void P(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 42)) {
            iPatchRedirector.redirect((short) 42, (Object) this, i3);
        } else {
            this.rotationYRandom = i3;
        }
    }

    public final void Q(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 44)) {
            iPatchRedirector.redirect((short) 44, (Object) this, i3);
        } else {
            this.rotationYSpeed = i3;
        }
    }

    public final void R(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 54)) {
            iPatchRedirector.redirect((short) 54, (Object) this, i3);
        } else {
            this.rotationYSpeedRandom = i3;
        }
    }

    public final void S(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 46)) {
            iPatchRedirector.redirect((short) 46, (Object) this, i3);
        } else {
            this.rotationZ = i3;
        }
    }

    public final void T(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 48)) {
            iPatchRedirector.redirect((short) 48, (Object) this, i3);
        } else {
            this.rotationZRandom = i3;
        }
    }

    public final void U(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 50)) {
            iPatchRedirector.redirect((short) 50, (Object) this, i3);
        } else {
            this.rotationZSpeed = i3;
        }
    }

    public final void V(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 56)) {
            iPatchRedirector.redirect((short) 56, (Object) this, i3);
        } else {
            this.rotationZSpeedRandom = i3;
        }
    }

    public final void W(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            iPatchRedirector.redirect((short) 28, this, Float.valueOf(f16));
        } else {
            this.scale = f16;
        }
    }

    public final void X(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            iPatchRedirector.redirect((short) 30, this, Float.valueOf(f16));
        } else {
            this.scaleRandom = f16;
        }
    }

    public final void Y(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            iPatchRedirector.redirect((short) 32, this, Float.valueOf(f16));
        } else {
            this.scaleSpeed = f16;
        }
    }

    public final void Z(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this, i3);
        } else {
            this.speedAngleRandom = i3;
        }
    }

    public final float a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return ((Float) iPatchRedirector.redirect((short) 23, (Object) this)).floatValue();
        }
        return this.accelerationX;
    }

    public final void a0(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, this, Float.valueOf(f16));
        } else {
            this.speedRandom = f16;
        }
    }

    public final float b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            return ((Float) iPatchRedirector.redirect((short) 25, (Object) this)).floatValue();
        }
        return this.accelerationY;
    }

    public final void b0(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, this, Float.valueOf(f16));
        } else {
            this.speedX = f16;
        }
    }

    public final float c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Float) iPatchRedirector.redirect((short) 13, (Object) this)).floatValue();
        }
        return this.emitAreaHeight;
    }

    public final void c0(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, this, Float.valueOf(f16));
        } else {
            this.speedY = f16;
        }
    }

    public final int d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        return this.emitAreaUnit;
    }

    public final float e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Float) iPatchRedirector.redirect((short) 11, (Object) this)).floatValue();
        }
        return this.emitAreaWidth;
    }

    public final float f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Float) iPatchRedirector.redirect((short) 5, (Object) this)).floatValue();
        }
        return this.emitAreaX;
    }

    public final float g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Float) iPatchRedirector.redirect((short) 7, (Object) this)).floatValue();
        }
        return this.emitAreaY;
    }

    public final float h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Float) iPatchRedirector.redirect((short) 9, (Object) this)).floatValue();
        }
        return this.emitAreaZ;
    }

    @NotNull
    public final d i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (d) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.emitterProperties;
    }

    public final int j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            return ((Integer) iPatchRedirector.redirect((short) 33, (Object) this)).intValue();
        }
        return this.rotationX;
    }

    public final int k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 35)) {
            return ((Integer) iPatchRedirector.redirect((short) 35, (Object) this)).intValue();
        }
        return this.rotationXRandom;
    }

    public final int l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 37)) {
            return ((Integer) iPatchRedirector.redirect((short) 37, (Object) this)).intValue();
        }
        return this.rotationXSpeed;
    }

    public final int m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 51)) {
            return ((Integer) iPatchRedirector.redirect((short) 51, (Object) this)).intValue();
        }
        return this.rotationXSpeedRandom;
    }

    public final int n() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 39)) {
            return ((Integer) iPatchRedirector.redirect((short) 39, (Object) this)).intValue();
        }
        return this.rotationY;
    }

    public final int o() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 41)) {
            return ((Integer) iPatchRedirector.redirect((short) 41, (Object) this)).intValue();
        }
        return this.rotationYRandom;
    }

    public final int p() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 43)) {
            return ((Integer) iPatchRedirector.redirect((short) 43, (Object) this)).intValue();
        }
        return this.rotationYSpeed;
    }

    public final int q() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 53)) {
            return ((Integer) iPatchRedirector.redirect((short) 53, (Object) this)).intValue();
        }
        return this.rotationYSpeedRandom;
    }

    public final int r() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 45)) {
            return ((Integer) iPatchRedirector.redirect((short) 45, (Object) this)).intValue();
        }
        return this.rotationZ;
    }

    public final int s() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 47)) {
            return ((Integer) iPatchRedirector.redirect((short) 47, (Object) this)).intValue();
        }
        return this.rotationZRandom;
    }

    public final int t() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 49)) {
            return ((Integer) iPatchRedirector.redirect((short) 49, (Object) this)).intValue();
        }
        return this.rotationZSpeed;
    }

    public final int u() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 55)) {
            return ((Integer) iPatchRedirector.redirect((short) 55, (Object) this)).intValue();
        }
        return this.rotationZSpeedRandom;
    }

    public final float v() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            return ((Float) iPatchRedirector.redirect((short) 27, (Object) this)).floatValue();
        }
        return this.scale;
    }

    public final float w() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            return ((Float) iPatchRedirector.redirect((short) 29, (Object) this)).floatValue();
        }
        return this.scaleRandom;
    }

    public final float x() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            return ((Float) iPatchRedirector.redirect((short) 31, (Object) this)).floatValue();
        }
        return this.scaleSpeed;
    }

    public final int y() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return ((Integer) iPatchRedirector.redirect((short) 21, (Object) this)).intValue();
        }
        return this.speedAngleRandom;
    }

    public final float z() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return ((Float) iPatchRedirector.redirect((short) 19, (Object) this)).floatValue();
        }
        return this.speedRandom;
    }
}
