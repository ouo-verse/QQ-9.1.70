package com.tencent.mobileqq.qqnt.videoplay.api.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.heytap.databaseengine.model.UserInfo;
import com.qq.e.comm.managers.plugin.PM;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqnt.videoplay.api.component.BaseVideoView;
import com.tencent.mobileqq.qqnt.videoplay.api.param.a;
import com.tencent.mobileqq.qqnt.videoplay.api.param.c;
import com.tencent.mobileqq.qqnt.videoplay.player.PlayState;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqnt.util.view.b;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0096\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0014\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 S2\u00020\u0001:\u0001\u0003B\u0011\b\u0016\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u00a2\u0006\u0004\bL\u0010MB\u001b\b\u0016\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u0012\b\u0010O\u001a\u0004\u0018\u00010N\u00a2\u0006\u0004\bL\u0010PB#\b\u0016\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u0012\b\u0010O\u001a\u0004\u0018\u00010N\u0012\u0006\u0010Q\u001a\u000209\u00a2\u0006\u0004\bL\u0010RJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\u000e\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006J\u000e\u0010\n\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\tJ\u0016\u0010\u000e\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000bJ0\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u00142\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016J\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019J\u0006\u0010\u001b\u001a\u00020\u0002J\u000e\u0010\u001d\u001a\u00020\u00022\u0006\u0010\u001c\u001a\u00020\u000bJ\u0006\u0010\u001e\u001a\u00020\u0002J\u0006\u0010\u001f\u001a\u00020\u0002J\u000e\u0010\"\u001a\u00020\u00022\u0006\u0010!\u001a\u00020 J\u0016\u0010&\u001a\u00020\u00022\u0006\u0010#\u001a\u00020\u000b2\u0006\u0010%\u001a\u00020$J\u000f\u0010(\u001a\u0004\u0018\u00010'\u00a2\u0006\u0004\b(\u0010)J\u000e\u0010+\u001a\u00020\u00022\u0006\u0010*\u001a\u00020\u000bJ\b\u0010,\u001a\u00020\u0002H\u0014J\u0010\u0010/\u001a\u00020\u00022\u0006\u0010.\u001a\u00020-H\u0014J\u000e\u00100\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0011J\u000e\u00102\u001a\u00020\u00022\u0006\u00101\u001a\u00020\u000bJ\b\u00104\u001a\u0004\u0018\u000103J\u0010\u00106\u001a\u00020\u00022\b\u00105\u001a\u0004\u0018\u00010\u0016J\u000e\u00108\u001a\u00020\u00022\u0006\u00107\u001a\u00020\u000bJ\u000e\u0010;\u001a\u00020\u00022\u0006\u0010:\u001a\u000209R\u0016\u0010=\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b(\u0010<R\u0016\u0010>\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010<R\u0016\u0010@\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010?R\u0016\u0010A\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010?R\u0016\u0010C\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b&\u0010BR\u0018\u0010G\u001a\u0004\u0018\u00010D8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bE\u0010FR\u0018\u0010K\u001a\u0004\u0018\u00010H8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bI\u0010J\u00a8\u0006T"}, d2 = {"Lcom/tencent/mobileqq/qqnt/videoplay/api/view/NTAIOBubbleVideoView;", "Landroid/widget/RelativeLayout;", "", "a", "Landroid/graphics/RectF;", "b", "", "rectRadius", "setRadius", "", "setRadii", "", "drawSharpCorner", "rightSide", "setDrawSharpCorner", "Landroid/content/Context;", "context", "Lcom/tencent/mobileqq/qqnt/videoplay/api/param/c;", "params", "hideErrorPanel", "Lkotlinx/coroutines/CoroutineScope;", "coroutineScope", "Lcom/tencent/mobileqq/qqnt/videoplay/api/param/a;", "muteClickCallback", "f", "Lcom/tencent/mobileqq/qqnt/videoplay/player/PlayState;", "e", "k", "needRecordPosition", "l", "g", h.F, "Landroid/graphics/drawable/Drawable;", "drawable", "setCoverImage", "error", "", "errorMsg", "i", "", "d", "()Ljava/lang/Long;", "show", "j", NodeProps.ON_ATTACHED_TO_WINDOW, "Landroid/graphics/Canvas;", PM.CANVAS, "dispatchDraw", "setVideoParam", "isMute", "setMute", "Landroid/widget/ImageView;", "c", "muteChangedListener", "setMuteChangedListener", "forbid", "setForbidStateCallBack", "", "visibility", "setVideoViewVisibility", "Z", "mSharpCornerDrawn", "mSharpCornerRightSide", UserInfo.SEX_FEMALE, "mSharpCornerWidth", "mRectRadius", "[F", "mRadiusList", "Landroid/graphics/Path;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/graphics/Path;", "mCropPath", "Lcom/tencent/mobileqq/qqnt/videoplay/api/component/BaseVideoView;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/qqnt/videoplay/api/component/BaseVideoView;", "videoView", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "D", "videoplay_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class NTAIOBubbleVideoView extends RelativeLayout {
    static IPatchRedirector $redirector_;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    @NotNull
    private static final float[] E;
    private static final float F;
    private static final float G;
    private static final float H;
    private static final float I;
    private static final float J;
    private static final float K;
    private static final float L;
    private static final float M;
    private static final float N;
    private static final float P;

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private BaseVideoView videoView;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private boolean mSharpCornerDrawn;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private boolean mSharpCornerRightSide;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private float mSharpCornerWidth;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private float mRectRadius;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private float[] mRadiusList;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Path mCropPath;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0014\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u000e\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u00058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0007R\u0014\u0010\t\u001a\u00020\u00058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0007R\u0014\u0010\n\u001a\u00020\u00058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0007R\u0014\u0010\u000b\u001a\u00020\u00058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u0007R\u0014\u0010\f\u001a\u00020\u00058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\u0007R\u0014\u0010\r\u001a\u00020\u00058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u0007R\u0014\u0010\u000e\u001a\u00020\u00058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u0007R\u0014\u0010\u000f\u001a\u00020\u00058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0007R\u0014\u0010\u0010\u001a\u00020\u00058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0007\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/qqnt/videoplay/api/view/NTAIOBubbleVideoView$a;", "", "", "DEFAULT_EDGE_CORDS", "[F", "", "ax", UserInfo.SEX_FEMALE, "ay", "bx", "by", "cx", "cy", "mx", "my", "nx", "ny", "<init>", "()V", "videoplay_kit_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qqnt.videoplay.api.view.NTAIOBubbleVideoView$a, reason: from kotlin metadata */
    /* loaded from: classes17.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(39551);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 26)) {
            redirector.redirect((short) 26);
            return;
        }
        INSTANCE = new Companion(null);
        float[] fArr = {7.0f, 9.0f, 0.0f, 6.0f, 2.5f, 9.0f, 5.5f, 15.0f, 0.5f, 13.0f};
        E = fArr;
        F = fArr[0];
        G = fArr[1];
        H = fArr[2];
        I = fArr[3];
        J = fArr[4];
        K = fArr[5];
        L = fArr[6];
        M = fArr[7];
        N = fArr[8];
        P = fArr[9];
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NTAIOBubbleVideoView(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            return;
        }
        this.mSharpCornerDrawn = true;
        this.mSharpCornerRightSide = true;
        this.mSharpCornerWidth = b.f362999a.c(Math.abs(H - L));
        this.mRectRadius = 15.0f;
        this.mRadiusList = new float[8];
    }

    private final void a() {
        Unit unit;
        Path path = this.mCropPath;
        if (path != null) {
            path.reset();
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            this.mCropPath = new Path();
        }
        RectF b16 = b();
        b bVar = b.f362999a;
        float c16 = bVar.c(I);
        if (this.mSharpCornerRightSide) {
            Path path2 = this.mCropPath;
            Intrinsics.checkNotNull(path2);
            path2.addRoundRect(b16, this.mRadiusList, Path.Direction.CW);
            if (this.mSharpCornerDrawn) {
                float width = getWidth() - bVar.c(F);
                float c17 = bVar.c(G);
                float width2 = getWidth() - bVar.c(H);
                float width3 = getWidth() - bVar.c(J);
                float c18 = bVar.c(K);
                Path path3 = this.mCropPath;
                Intrinsics.checkNotNull(path3);
                path3.moveTo(width, c17);
                Path path4 = this.mCropPath;
                Intrinsics.checkNotNull(path4);
                path4.quadTo(width3, c18, width2, c16);
                float width4 = getWidth() - bVar.c(L);
                float c19 = bVar.c(M);
                float width5 = getWidth() - bVar.c(N);
                float c26 = bVar.c(P);
                Path path5 = this.mCropPath;
                Intrinsics.checkNotNull(path5);
                path5.quadTo(width5, c26, width4, c19);
            }
        } else {
            Path path6 = this.mCropPath;
            Intrinsics.checkNotNull(path6);
            path6.addRoundRect(b16, this.mRadiusList, Path.Direction.CCW);
            if (this.mSharpCornerDrawn) {
                float c27 = bVar.c(F);
                float c28 = bVar.c(G);
                float f16 = H;
                float c29 = bVar.c(J);
                float c36 = bVar.c(K);
                Path path7 = this.mCropPath;
                Intrinsics.checkNotNull(path7);
                path7.moveTo(c27, c28);
                Path path8 = this.mCropPath;
                Intrinsics.checkNotNull(path8);
                path8.quadTo(c29, c36, f16, c16);
                float c37 = bVar.c(L);
                float c38 = bVar.c(M);
                float c39 = bVar.c(N);
                float c46 = bVar.c(P);
                Path path9 = this.mCropPath;
                Intrinsics.checkNotNull(path9);
                path9.quadTo(c39, c46, c37, c38);
            }
        }
        Path path10 = this.mCropPath;
        Intrinsics.checkNotNull(path10);
        path10.close();
    }

    private final RectF b() {
        if (this.mSharpCornerDrawn) {
            if (this.mSharpCornerRightSide) {
                return new RectF(0.0f, 0.0f, getWidth() - this.mSharpCornerWidth, getHeight());
            }
            return new RectF(this.mSharpCornerWidth, 0.0f, getWidth(), getHeight());
        }
        return new RectF(0.0f, 0.0f, getWidth(), getHeight());
    }

    @Nullable
    public final ImageView c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return (ImageView) iPatchRedirector.redirect((short) 22, (Object) this);
        }
        BaseVideoView baseVideoView = this.videoView;
        if (baseVideoView != null) {
            return baseVideoView.p();
        }
        return null;
    }

    @Nullable
    public final Long d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return (Long) iPatchRedirector.redirect((short) 16, (Object) this);
        }
        BaseVideoView baseVideoView = this.videoView;
        if (baseVideoView != null) {
            return Long.valueOf(baseVideoView.q());
        }
        return null;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(@NotNull Canvas canvas) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, (Object) canvas);
            return;
        }
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        a();
        Path path = this.mCropPath;
        Intrinsics.checkNotNull(path);
        canvas.clipPath(path);
        super.dispatchDraw(canvas);
    }

    @Nullable
    public final PlayState e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (PlayState) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        BaseVideoView baseVideoView = this.videoView;
        if (baseVideoView != null) {
            return baseVideoView.s();
        }
        return null;
    }

    public final void f(@NotNull Context context, @NotNull c params, boolean hideErrorPanel, @NotNull CoroutineScope coroutineScope, @Nullable a muteClickCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, context, params, Boolean.valueOf(hideErrorPanel), coroutineScope, muteClickCallback);
            return;
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(params, "params");
        Intrinsics.checkNotNullParameter(coroutineScope, "coroutineScope");
        BaseVideoView baseVideoView = new BaseVideoView(context, params, coroutineScope, true, hideErrorPanel, false, 0.0f, 96, null);
        this.videoView = baseVideoView;
        addView(baseVideoView, new RelativeLayout.LayoutParams(-1, -1));
        BaseVideoView baseVideoView2 = this.videoView;
        if (baseVideoView2 != null) {
            baseVideoView2.setMuteClickCallback(muteClickCallback);
        }
    }

    public final void g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
            return;
        }
        BaseVideoView baseVideoView = this.videoView;
        if (baseVideoView != null) {
            baseVideoView.t();
        }
    }

    public final void h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this);
            return;
        }
        BaseVideoView baseVideoView = this.videoView;
        if (baseVideoView != null) {
            baseVideoView.u();
        }
    }

    public final void i(boolean error, @NotNull String errorMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, this, Boolean.valueOf(error), errorMsg);
            return;
        }
        Intrinsics.checkNotNullParameter(errorMsg, "errorMsg");
        BaseVideoView baseVideoView = this.videoView;
        if (baseVideoView != null) {
            baseVideoView.w(error, errorMsg);
        }
    }

    public final void j(boolean show) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, show);
            return;
        }
        BaseVideoView baseVideoView = this.videoView;
        if (baseVideoView != null) {
            baseVideoView.x(show);
        }
    }

    public final void k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        BaseVideoView baseVideoView = this.videoView;
        if (baseVideoView != null) {
            baseVideoView.y();
        }
    }

    public final void l(boolean needRecordPosition) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, needRecordPosition);
            return;
        }
        BaseVideoView baseVideoView = this.videoView;
        if (baseVideoView != null) {
            baseVideoView.A(needRecordPosition);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this);
        } else {
            super.onAttachedToWindow();
            setLayerType(2, null);
        }
    }

    public final void setCoverImage(@NotNull Drawable drawable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) drawable);
            return;
        }
        Intrinsics.checkNotNullParameter(drawable, "drawable");
        BaseVideoView baseVideoView = this.videoView;
        if (baseVideoView != null) {
            baseVideoView.setCoverImage(drawable);
        }
    }

    public final void setDrawSharpCorner(boolean drawSharpCorner, boolean rightSide) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, Boolean.valueOf(drawSharpCorner), Boolean.valueOf(rightSide));
        } else {
            this.mSharpCornerDrawn = drawSharpCorner;
            this.mSharpCornerRightSide = rightSide;
        }
    }

    public final void setForbidStateCallBack(boolean forbid) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, (Object) this, forbid);
            return;
        }
        BaseVideoView baseVideoView = this.videoView;
        if (baseVideoView != null) {
            baseVideoView.setForbidStateCallBack(forbid);
        }
    }

    public final void setMute(boolean isMute) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this, isMute);
            return;
        }
        BaseVideoView baseVideoView = this.videoView;
        if (baseVideoView != null) {
            baseVideoView.setMute(isMute);
        }
    }

    public final void setMuteChangedListener(@Nullable a muteChangedListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, (Object) this, (Object) muteChangedListener);
            return;
        }
        BaseVideoView baseVideoView = this.videoView;
        if (baseVideoView != null) {
            baseVideoView.setMuteClickCallback(muteChangedListener);
        }
    }

    public final void setRadii(@NotNull float[] rectRadius) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) rectRadius);
        } else {
            Intrinsics.checkNotNullParameter(rectRadius, "rectRadius");
            this.mRadiusList = rectRadius;
        }
    }

    public final void setRadius(float rectRadius) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Float.valueOf(rectRadius));
        } else {
            this.mRectRadius = rectRadius;
            Arrays.fill(this.mRadiusList, b.f362999a.c(rectRadius));
        }
    }

    public final void setVideoParam(@NotNull c params) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this, (Object) params);
            return;
        }
        Intrinsics.checkNotNullParameter(params, "params");
        BaseVideoView baseVideoView = this.videoView;
        if (baseVideoView != null) {
            baseVideoView.setVideoParam(params);
        }
    }

    public final void setVideoViewVisibility(int visibility) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, (Object) this, visibility);
            return;
        }
        BaseVideoView baseVideoView = this.videoView;
        if (baseVideoView != null) {
            baseVideoView.setVideoViewVisibility(visibility);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NTAIOBubbleVideoView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
            return;
        }
        this.mSharpCornerDrawn = true;
        this.mSharpCornerRightSide = true;
        this.mSharpCornerWidth = b.f362999a.c(Math.abs(H - L));
        this.mRectRadius = 15.0f;
        this.mRadiusList = new float[8];
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NTAIOBubbleVideoView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, context, attributeSet, Integer.valueOf(i3));
            return;
        }
        this.mSharpCornerDrawn = true;
        this.mSharpCornerRightSide = true;
        this.mSharpCornerWidth = b.f362999a.c(Math.abs(H - L));
        this.mRectRadius = 15.0f;
        this.mRadiusList = new float[8];
    }
}
