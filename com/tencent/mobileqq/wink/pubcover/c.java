package com.tencent.mobileqq.wink.pubcover;

import android.graphics.Matrix;
import android.util.Log;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.jsengine.animation.basic.BasicAnimation;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.wink.editor.WinkVideoTavCut;
import com.tencent.mobileqq.wink.editor.clipping.TimelineViewModelV2;
import com.tencent.mobileqq.wink.editor.dr;
import com.tencent.mobileqq.wink.editor.view.BorderCoverView;
import com.tencent.mobileqq.winkreport.datong.WinkDTParamBuilder;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.videocut.model.MediaClip;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b \n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 12\u00020\u0001:\u0001\u001dB+\b\u0016\u0012\u0006\u0010S\u001a\u00020'\u0012\u0006\u0010U\u001a\u00020T\u0012\b\u00105\u001a\u0004\u0018\u00010\u0018\u0012\u0006\u0010,\u001a\u00020*\u00a2\u0006\u0004\bV\u0010WJ\u0012\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0002H\u0002J\b\u0010\b\u001a\u00020\u0004H\u0002J\b\u0010\t\u001a\u00020\u0004H\u0002J\u0018\u0010\r\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\nH\u0002J\u0018\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\nH\u0002J\b\u0010\u0011\u001a\u00020\nH\u0002J\b\u0010\u0012\u001a\u00020\nH\u0002J\u001a\u0010\u0014\u001a\u00020\u00042\b\b\u0002\u0010\u0013\u001a\u00020\u00022\b\b\u0002\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0015\u001a\u00020\u0004J\u0018\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\nH\u0016J\u0010\u0010\u001a\u001a\u00020\u00042\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018J(\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u001c\u001a\u00020\u0002H\u0016J\u0018\u0010\u001f\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0006\u0010!\u001a\u00020 J\u0006\u0010\"\u001a\u00020\nJ\u0006\u0010#\u001a\u00020\nJ\u0006\u0010$\u001a\u00020\nJ\u0006\u0010%\u001a\u00020\nJ\u0006\u0010&\u001a\u00020\u0018R\u0014\u0010)\u001a\u00020'8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001d\u0010(R\u0018\u0010,\u001a\u0004\u0018\u00010*8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010+R\u0016\u0010-\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0010R*\u00105\u001a\u00020\u00182\u0006\u0010.\u001a\u00020\u00188B@BX\u0082\u000e\u00a2\u0006\u0012\n\u0004\b/\u00100\u001a\u0004\b1\u00102\"\u0004\b3\u00104R\u0016\u00107\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b6\u00100R\u0016\u00109\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b8\u0010\u0010R\u0016\u0010:\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0010R\u0016\u0010;\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0010R\u0016\u0010<\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0010R\"\u0010A\u001a\u00020\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b$\u0010\u0010\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@R\"\u0010D\u001a\u00020\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b=\u0010\u0010\u001a\u0004\bB\u0010>\"\u0004\bC\u0010@R\"\u0010J\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bB\u0010E\u001a\u0004\bF\u0010G\"\u0004\bH\u0010IR$\u0010Q\u001a\u0004\u0018\u00010K8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b&\u0010L\u001a\u0004\bM\u0010N\"\u0004\bO\u0010PR\u0014\u0010R\u001a\u00020K8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b!\u0010L\u00a8\u0006X"}, d2 = {"Lcom/tencent/mobileqq/wink/pubcover/c;", "Lcom/tencent/mobileqq/wink/editor/view/a;", "", "refreshPlayer", "", "D", "y", "u", "g", tl.h.F, "", "dx", "dy", "G", BasicAnimation.KeyPath.SCALE_X, BasicAnimation.KeyPath.SCALE_Y, UserInfo.SEX_FEMALE, "r", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "refreshMatrix", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "i", "sx", "c", "Landroid/graphics/Matrix;", "matrix", HippyTKDListViewAdapter.X, "sy", "scaleFromBorderView", "a", "changedOutsize", "b", "", DomainData.DOMAIN_NAME, "t", "p", "j", ReportConstant.COSTREPORT_PREFIX, QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/wink/editor/clipping/TimelineViewModelV2;", "Lcom/tencent/mobileqq/wink/editor/clipping/TimelineViewModelV2;", "timelineViewModel", "Lcom/tencent/mobileqq/wink/pubcover/c$a$a;", "Lcom/tencent/mobileqq/wink/pubcover/c$a$a;", "callback", "maxScale", "value", "d", "Landroid/graphics/Matrix;", "o", "()Landroid/graphics/Matrix;", "B", "(Landroid/graphics/Matrix;)V", "lastMatrix", "e", "legalMatrix", "f", "fullScale", "minScale", NodeProps.BORDER_WIDTH, "borderHeight", "k", "()F", "setClipHeight", "(F)V", "clipHeight", "l", "setClipWidth", "clipWidth", "Z", "v", "()Z", "setChangeEnd", "(Z)V", "isChangeEnd", "Ljava/lang/Runnable;", "Ljava/lang/Runnable;", "getMoveChangeCallBack", "()Ljava/lang/Runnable;", BdhLogUtil.LogTag.Tag_Conn, "(Ljava/lang/Runnable;)V", "moveChangeCallBack", "backgroundShow", "tavCut", "Lcom/tencent/mobileqq/wink/editor/view/BorderCoverView;", "borderView", "<init>", "(Lcom/tencent/mobileqq/wink/editor/clipping/TimelineViewModelV2;Lcom/tencent/mobileqq/wink/editor/view/BorderCoverView;Landroid/graphics/Matrix;Lcom/tencent/mobileqq/wink/pubcover/c$a$a;)V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class c implements com.tencent.mobileqq.wink.editor.view.a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final TimelineViewModelV2 timelineViewModel;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Companion.InterfaceC9078a callback;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private float maxScale;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private Matrix lastMatrix;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private Matrix legalMatrix;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private float fullScale;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private float minScale;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private float borderWidth;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private float borderHeight;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    private float clipHeight;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    private float clipWidth;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    private boolean isChangeEnd;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Runnable moveChangeCallBack;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Runnable backgroundShow;

    public c(@NotNull TimelineViewModelV2 tavCut, @NotNull BorderCoverView borderView, @Nullable Matrix matrix, @NotNull Companion.InterfaceC9078a callback) {
        Object orNull;
        Intrinsics.checkNotNullParameter(tavCut, "tavCut");
        Intrinsics.checkNotNullParameter(borderView, "borderView");
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.maxScale = 3.0f;
        this.lastMatrix = new Matrix();
        this.legalMatrix = new Matrix();
        this.minScale = 0.75f;
        this.isChangeEnd = true;
        this.backgroundShow = new Runnable() { // from class: com.tencent.mobileqq.wink.pubcover.a
            @Override // java.lang.Runnable
            public final void run() {
                c.f(c.this);
            }
        };
        this.timelineViewModel = tavCut;
        borderView.setMovieOperationCallBack(this);
        if (matrix != null) {
            B(matrix);
        }
        orNull = CollectionsKt___CollectionsKt.getOrNull(tavCut.u2(), 0);
        MediaClip mediaClip = (MediaClip) orNull;
        if (mediaClip != null) {
            A(this, matrix == null && com.tencent.videocut.render.extension.e.o(mediaClip).width / com.tencent.videocut.render.extension.e.o(mediaClip).height < 0.75f, false, 2, null);
        }
        this.callback = callback;
        if (callback != null) {
            callback.a(u());
        }
    }

    public static /* synthetic */ void A(c cVar, boolean z16, boolean z17, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z16 = false;
        }
        if ((i3 & 2) != 0) {
            z17 = true;
        }
        cVar.z(z16, z17);
    }

    private final void B(Matrix matrix) {
        this.lastMatrix = matrix;
    }

    private final void D(boolean refreshPlayer) {
        WinkVideoTavCut winkVideoTavCut;
        dr C2 = this.timelineViewModel.C2();
        if (C2 instanceof WinkVideoTavCut) {
            winkVideoTavCut = (WinkVideoTavCut) C2;
        } else {
            winkVideoTavCut = null;
        }
        if (winkVideoTavCut != null) {
            winkVideoTavCut.o3(getLastMatrix(), refreshPlayer);
        }
    }

    static /* synthetic */ void E(c cVar, boolean z16, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z16 = true;
        }
        cVar.D(z16);
    }

    private final void F(float scaleX, float scaleY) {
        float f16 = 2;
        getLastMatrix().preScale(scaleX, scaleY, this.clipWidth / f16, this.clipHeight / f16);
        w53.b.f("MovieOperationImp", "movie scale matrix:" + getLastMatrix().toShortString() + " ");
    }

    private final void G(float dx5, float dy5) {
        boolean z16;
        float f16;
        if (com.tencent.mobileqq.wink.editor.crop.a.c(getLastMatrix()) == 0.0f) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            f16 = com.tencent.mobileqq.wink.editor.crop.a.c(getLastMatrix());
        } else {
            f16 = 1.0f;
        }
        getLastMatrix().preTranslate(dx5 / f16, dy5 / f16);
        w53.b.a("MovieOperationImp", "updateTranslate: dx:" + dx5 + ", dy:" + dy5 + ", " + getLastMatrix().toShortString() + " ");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(c this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Companion.InterfaceC9078a interfaceC9078a = this$0.callback;
        if (interfaceC9078a != null) {
            interfaceC9078a.a(this$0.u());
        }
    }

    private final void g() {
        float f16;
        float min = Math.min(this.borderWidth, r());
        float min2 = Math.min(this.borderHeight, q());
        float f17 = 2;
        float f18 = (-min2) / f17;
        float f19 = min2 / f17;
        float f26 = (-min) / f17;
        float f27 = min / f17;
        float f28 = 0.0f;
        if (j() < f19) {
            f16 = f19 - j();
        } else {
            f16 = 0.0f;
        }
        if (t() > f18) {
            f16 = f18 - t();
        }
        if (p() > f26) {
            f28 = f26 - p();
        }
        if (s() < f27) {
            f28 = f27 - s();
        }
        getLastMatrix().postTranslate(f28, f16);
    }

    private final void h() {
        if (com.tencent.mobileqq.wink.editor.crop.a.c(this.legalMatrix) > com.tencent.mobileqq.wink.editor.crop.a.c(getLastMatrix())) {
            B(new Matrix(this.legalMatrix));
            w53.b.f("MovieOperationImp", "recover scale");
        }
    }

    /* renamed from: o, reason: from getter */
    private final Matrix getLastMatrix() {
        return this.lastMatrix;
    }

    private final float q() {
        return this.clipHeight * com.tencent.mobileqq.wink.editor.crop.a.e(getLastMatrix());
    }

    private final float r() {
        return this.clipWidth * com.tencent.mobileqq.wink.editor.crop.a.d(getLastMatrix());
    }

    private final boolean u() {
        w53.b.f("MovieOperationImp", "hasBackgroundLeaking:" + com.tencent.mobileqq.wink.editor.crop.a.c(getLastMatrix()) + " && " + this.fullScale);
        if (com.tencent.mobileqq.wink.editor.crop.a.c(getLastMatrix()) < this.fullScale - 0.01d) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void w(c this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        E(this$0, false, 1, null);
    }

    private final void y() {
        HashMap hashMap = new HashMap();
        hashMap.putAll(WinkDTParamBuilder.buildElementParams());
        hashMap.put("xsj_custom_pgid", WinkDaTongReportConstant.PageId.PG_XSJ_PUBLISH_COVER_PAGE);
        hashMap.put("xsj_eid", "em_xsj_cover_picture");
        VideoReport.reportEvent("ev_xsj_abnormal_clck", hashMap);
    }

    public final void C(@Nullable Runnable runnable) {
        this.moveChangeCallBack = runnable;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:13:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x00b7  */
    @Override // com.tencent.mobileqq.wink.editor.view.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(float sx5, float sy5, boolean refreshPlayer, boolean scaleFromBorderView) {
        float c16;
        Runnable runnable;
        this.isChangeEnd = false;
        w53.b.f("MovieOperationImp", "movie scale: dx:" + sx5 + "  dy:" + sy5);
        float c17 = com.tencent.mobileqq.wink.editor.crop.a.c(getLastMatrix()) * sx5;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("movie target scale: dx:");
        sb5.append(c17);
        w53.b.f("MovieOperationImp", sb5.toString());
        float c18 = com.tencent.mobileqq.wink.editor.crop.a.c(getLastMatrix()) * sx5;
        float f16 = this.minScale;
        if (c18 < f16) {
            c16 = com.tencent.mobileqq.wink.editor.crop.a.c(getLastMatrix());
        } else {
            float c19 = com.tencent.mobileqq.wink.editor.crop.a.c(getLastMatrix()) * sx5;
            f16 = this.maxScale;
            if (c19 > f16) {
                c16 = com.tencent.mobileqq.wink.editor.crop.a.c(getLastMatrix());
            }
            w53.b.f("MovieOperationImp", "currentScale:" + com.tencent.mobileqq.wink.editor.crop.a.c(getLastMatrix()) + " ");
            Log.e("MovieOperationImp", "scale:" + sx5 + " ");
            F(sx5, sx5);
            D(refreshPlayer);
            if (scaleFromBorderView) {
                y();
            }
            runnable = this.moveChangeCallBack;
            if (runnable == null) {
                runnable.run();
                return;
            }
            return;
        }
        sx5 = f16 / c16;
        w53.b.f("MovieOperationImp", "currentScale:" + com.tencent.mobileqq.wink.editor.crop.a.c(getLastMatrix()) + " ");
        Log.e("MovieOperationImp", "scale:" + sx5 + " ");
        F(sx5, sx5);
        D(refreshPlayer);
        if (scaleFromBorderView) {
        }
        runnable = this.moveChangeCallBack;
        if (runnable == null) {
        }
    }

    @Override // com.tencent.mobileqq.wink.editor.view.a
    public void b(boolean changedOutsize, boolean refreshPlayer) {
        h();
        g();
        D(refreshPlayer);
        ThreadManagerV2.getUIHandlerV2().removeCallbacks(this.backgroundShow);
        ThreadManagerV2.getUIHandlerV2().postDelayed(this.backgroundShow, 300L);
        if (!changedOutsize) {
            this.isChangeEnd = true;
            ThreadManagerV2.getUIHandlerV2().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.wink.pubcover.b
                @Override // java.lang.Runnable
                public final void run() {
                    c.w(c.this);
                }
            }, 50L);
            y();
        }
    }

    @Override // com.tencent.mobileqq.wink.editor.view.a
    public void c(float sx5, float dy5) {
        this.isChangeEnd = false;
        Runnable runnable = this.moveChangeCallBack;
        if (runnable != null) {
            runnable.run();
        }
        G(sx5, dy5);
        E(this, false, 1, null);
    }

    public final void i() {
        Object orNull;
        orNull = CollectionsKt___CollectionsKt.getOrNull(this.timelineViewModel.u2(), 0);
        MediaClip mediaClip = (MediaClip) orNull;
        if (mediaClip != null) {
            this.clipHeight = com.tencent.videocut.render.extension.e.o(mediaClip).height;
            this.clipWidth = com.tencent.videocut.render.extension.e.o(mediaClip).width;
            if (com.tencent.videocut.render.extension.e.o(mediaClip).width / com.tencent.videocut.render.extension.e.o(mediaClip).height > 0.75f) {
                float f16 = this.clipWidth;
                this.borderWidth = f16;
                float f17 = (f16 / 3.0f) * 4.0f;
                this.borderHeight = f17;
                this.fullScale = f17 / this.clipHeight;
            } else {
                float f18 = this.clipHeight;
                this.borderHeight = f18;
                float f19 = (f18 / 4.0f) * 3.0f;
                this.borderWidth = f19;
                this.fullScale = f19 / this.clipWidth;
            }
            this.maxScale = this.fullScale * 3;
        }
    }

    public final float j() {
        return t() + q();
    }

    /* renamed from: k, reason: from getter */
    public final float getClipHeight() {
        return this.clipHeight;
    }

    /* renamed from: l, reason: from getter */
    public final float getClipWidth() {
        return this.clipWidth;
    }

    @NotNull
    public final Matrix m() {
        return getLastMatrix();
    }

    @NotNull
    public final String n() {
        float min = Math.min(this.borderWidth, r());
        return Math.min(this.borderHeight, q()) + ":" + min;
    }

    public final float p() {
        return ((-this.clipWidth) / 2) + com.tencent.mobileqq.wink.editor.crop.a.f(getLastMatrix());
    }

    public final float s() {
        return p() + r();
    }

    public final float t() {
        return ((-this.clipHeight) / 2) + com.tencent.mobileqq.wink.editor.crop.a.g(getLastMatrix());
    }

    /* renamed from: v, reason: from getter */
    public final boolean getIsChangeEnd() {
        return this.isChangeEnd;
    }

    public final void x(@Nullable Matrix matrix) {
        if (matrix != null) {
            B(matrix);
        }
        w53.b.f("MovieOperationImp", "updateMatrix:" + getLastMatrix().toShortString());
        D(false);
    }

    public final void z(boolean refreshMatrix, boolean refreshPlayer) {
        Object orNull;
        float f16;
        i();
        orNull = CollectionsKt___CollectionsKt.getOrNull(this.timelineViewModel.u2(), 0);
        MediaClip mediaClip = (MediaClip) orNull;
        if (mediaClip != null && refreshMatrix) {
            B(new Matrix());
            if (com.tencent.videocut.render.extension.e.o(mediaClip).width / com.tencent.videocut.render.extension.e.o(mediaClip).height > 0.75f) {
                f16 = 1.0f;
            } else {
                f16 = this.fullScale;
            }
            a(f16, f16, refreshPlayer, false);
            this.isChangeEnd = true;
        }
    }
}
