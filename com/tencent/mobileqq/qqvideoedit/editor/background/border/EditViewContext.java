package com.tencent.mobileqq.qqvideoedit.editor.background.border;

import android.content.Context;
import android.graphics.PointF;
import android.graphics.RectF;
import android.util.Size;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.RequiresApi;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqvideoedit.editor.background.border.EditContainerView;
import com.tencent.mobileqq.qqvideoedit.thirdparty.videocut.model.SizeF;
import com.tencent.mobileqq.qqvideoedit.thirdparty.videocut.render.model.EditViewTransform;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00ae\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010%\n\u0002\b\u0016\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 %2\u00020\u0001:\u0003H\u0083\u0001B\u0011\u0012\u0006\u0010J\u001a\u00020D\u00a2\u0006\u0006\b\u0081\u0001\u0010\u0082\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\n\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0002J\u0018\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0002J\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\r\u001a\u00020\fH\u0002J\b\u0010\u0010\u001a\u00020\u0004H\u0002J\u0010\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u000eH\u0002J\u0012\u0010\u0013\u001a\u00020\u00042\b\u0010\u0011\u001a\u0004\u0018\u00010\u000eH\u0002J\u0018\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0014H\u0002J\u0010\u0010\u0016\u001a\u00020\u00192\u0006\u0010\u0018\u001a\u00020\u0017H\u0002J\u0010\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0018\u001a\u00020\u0017H\u0002J\u0010\u0010\u001b\u001a\u00020\u00192\u0006\u0010\u0018\u001a\u00020\u0017H\u0002J\u0010\u0010\u001e\u001a\u00020\u00192\u0006\u0010\u001d\u001a\u00020\u001cH\u0002J\u0010\u0010 \u001a\u00020\u00142\u0006\u0010\u001f\u001a\u00020\u001cH\u0003J\u0010\u0010!\u001a\u00020\u00142\u0006\u0010\u001f\u001a\u00020\u001cH\u0002J\b\u0010\"\u001a\u00020\u0004H\u0002J\b\u0010$\u001a\u00020#H\u0002J\u0010\u0010%\u001a\u00020\u00192\u0006\u0010\u0018\u001a\u00020\u0017H\u0002J\u0010\u0010&\u001a\u00020\u00192\u0006\u0010\u0018\u001a\u00020\u0017H\u0002J\u0010\u0010'\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u0017H\u0002J\b\u0010(\u001a\u00020\u0019H\u0002J\b\u0010)\u001a\u00020\u0019H\u0002J\u0018\u0010,\u001a\u00020\u00042\u0006\u0010*\u001a\u00020\u00142\u0006\u0010+\u001a\u00020\u0014H\u0002J\u0010\u0010.\u001a\u00020\u00142\u0006\u0010-\u001a\u00020\u0014H\u0002J\b\u0010/\u001a\u00020\u0004H\u0002J\b\u00100\u001a\u00020\u0004H\u0002JB\u00106\u001a\u00020\u00042:\u00105\u001a6\u0012\u0013\u0012\u00110\u0014\u00a2\u0006\f\b2\u0012\b\b3\u0012\u0004\b\b(\u0015\u0012\u0013\u0012\u00110\u0014\u00a2\u0006\f\b2\u0012\b\b3\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020\u000201j\u0002`4J\u000e\u00109\u001a\u00020\u00042\u0006\u00108\u001a\u000207J\u001e\u0010=\u001a\u00020\u00042\u0006\u0010:\u001a\u00020#2\u0006\u0010;\u001a\u00020\u00142\u0006\u0010<\u001a\u00020\u0014J\u000e\u0010>\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\fJ\u0006\u0010?\u001a\u00020\u0019J\u0006\u0010@\u001a\u00020\bJ\u000e\u0010A\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010C\u001a\u00020\u00042\u0006\u0010B\u001a\u00020\u0019J\u0006\u0010E\u001a\u00020DJ\u0006\u0010F\u001a\u00020\u0002J\u0006\u0010G\u001a\u00020\fR\u0014\u0010J\u001a\u00020D8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bH\u0010IR \u0010N\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u000e0K8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bL\u0010MR\u0018\u0010Q\u001a\u0004\u0018\u0001078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bO\u0010PR\u0018\u0010T\u001a\u0004\u0018\u00010#8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bR\u0010SR\u0016\u0010V\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bU\u0010\u0006R\u0016\u0010<\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bW\u0010\u0006R\u0018\u0010Z\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bX\u0010YR\u0016\u0010]\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b[\u0010\\R\u0016\u0010_\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bA\u0010^R\u0016\u0010a\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010`R\u001a\u0010e\u001a\b\u0012\u0004\u0012\u00020c0b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010dR \u0010g\u001a\u000e\u0012\u0004\u0012\u00020c\u0012\u0004\u0012\u00020f0K8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b(\u0010MR \u0010i\u001a\u000e\u0012\u0004\u0012\u00020c\u0012\u0004\u0012\u00020h0K8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b)\u0010MR\u0016\u0010k\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010jR\u0016\u0010l\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b/\u0010jR\u0016\u0010o\u001a\u00020m8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010nR\u0016\u0010q\u001a\u00020\u001c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b \u0010pR\u0014\u0010r\u001a\u00020\u001c8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b!\u0010pR\u0016\u0010s\u001a\u00020f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0007R\u0016\u0010t\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bE\u0010\u0006R\u0016\u0010u\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b@\u0010\u0006R\u0016\u0010v\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bF\u0010\u0006R\u0016\u0010w\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bG\u0010\u0006R\u0016\u0010x\u001a\u00020f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0007R\u0014\u0010{\u001a\u00020y8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010zRJ\u0010}\u001a6\u0012\u0013\u0012\u00110\u0014\u00a2\u0006\f\b2\u0012\b\b3\u0012\u0004\b\b(\u0015\u0012\u0013\u0012\u00110\u0014\u00a2\u0006\f\b2\u0012\b\b3\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020\u000201j\u0002`48\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010|R\u0015\u0010\u0080\u0001\u001a\u00020~8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u007f\u00a8\u0006\u0084\u0001"}, d2 = {"Lcom/tencent/mobileqq/qqvideoedit/editor/background/border/EditViewContext;", "", "", "uuid", "", "G", UserInfo.SEX_FEMALE, "I", "Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/render/model/a;", "editViewTransform", "J", "H", "Lcom/tencent/mobileqq/qqvideoedit/editor/background/border/EditViewContext$EditScene;", "scene", "Lcom/tencent/mobileqq/qqvideoedit/editor/background/border/c;", ReportConstant.COSTREPORT_PREFIX, "P", "bordView", "j", "k", "", HippyTKDListViewAdapter.X, "y", "Landroid/view/MotionEvent;", "event", "", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "Landroid/graphics/PointF;", "point", DomainData.DOMAIN_NAME, "vertex", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "r", "U", "Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/SizeF;", "p", "B", BdhLogUtil.LogTag.Tag_Conn, "M", "l", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "deltaX", "deltaY", "K", "scale", "D", "o", "O", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "Lcom/tencent/mobileqq/qqvideoedit/editor/background/border/AccessTouchedViewId;", "viewId", "N", "Lcom/tencent/mobileqq/qqvideoedit/editor/background/border/EditContainerView;", "view", BdhLogUtil.LogTag.Tag_Req, "size", "ratio", "fixedSizeRatio", "T", ExifInterface.LATITUDE_SOUTH, "E", "u", "i", NodeProps.VISIBLE, AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Landroid/content/Context;", "t", "v", "w", "a", "Landroid/content/Context;", "context", "", "b", "Ljava/util/Map;", "borderViewMap", "c", "Lcom/tencent/mobileqq/qqvideoedit/editor/background/border/EditContainerView;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "d", "Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/SizeF;", "renderSize", "e", "renderRatio", "f", "g", "Lcom/tencent/mobileqq/qqvideoedit/editor/background/border/c;", "curBorderView", h.F, "Ljava/lang/String;", "curUuid", "Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/render/model/a;", "curEditTransform", "Lcom/tencent/mobileqq/qqvideoedit/editor/background/border/EditViewContext$EditScene;", "editScene", "", "Lcom/tencent/mobileqq/qqvideoedit/editor/background/border/d;", "Ljava/util/List;", "observers", "", "filterGapMap", "", "lastUpdateTimeMap", "Z", "isClickEvent", "isTouchInSingleZoomRotateRect", "Lcom/tencent/mobileqq/qqvideoedit/editor/background/border/EditViewOperationMode;", "Lcom/tencent/mobileqq/qqvideoedit/editor/background/border/EditViewOperationMode;", "operationMode", "Landroid/graphics/PointF;", "orgPoint", "downPoint", "actionIndex", "twoPointDownDistance", "twoPointDownRotate", "lastDownRotate", "lastDownScale", "viewFlags", "Ljava/lang/Runnable;", "Ljava/lang/Runnable;", "pendingCheckForLongPress", "Lkotlin/jvm/functions/Function2;", "accessTouchedViewId", "Lcom/tencent/mobileqq/qqvideoedit/editor/background/border/EditContainerView$b;", "Lcom/tencent/mobileqq/qqvideoedit/editor/background/border/EditContainerView$b;", "dispatchTouchEventListener", "<init>", "(Landroid/content/Context;)V", "EditScene", "qqvideoedit_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class EditViewContext {

    /* renamed from: A, reason: from kotlin metadata */
    @NotNull
    private final EditContainerView.b dispatchTouchEventListener;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Context context;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Map<String, c> borderViewMap;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private EditContainerView rootView;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private SizeF renderSize;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private float renderRatio;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private float fixedSizeRatio;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private c curBorderView;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String curUuid;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private EditViewTransform curEditTransform;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private EditScene editScene;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<d> observers;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Map<d, Integer> filterGapMap;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Map<d, Long> lastUpdateTimeMap;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    private boolean isClickEvent;

    /* renamed from: o, reason: collision with root package name and from kotlin metadata */
    private boolean isTouchInSingleZoomRotateRect;

    /* renamed from: p, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private EditViewOperationMode operationMode;

    /* renamed from: q, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private PointF orgPoint;

    /* renamed from: r, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final PointF downPoint;

    /* renamed from: s, reason: collision with root package name and from kotlin metadata */
    private int actionIndex;

    /* renamed from: t, reason: collision with root package name and from kotlin metadata */
    private float twoPointDownDistance;

    /* renamed from: u, reason: collision with root package name and from kotlin metadata */
    private float twoPointDownRotate;

    /* renamed from: v, reason: collision with root package name and from kotlin metadata */
    private float lastDownRotate;

    /* renamed from: w, reason: collision with root package name and from kotlin metadata */
    private float lastDownScale;

    /* renamed from: x, reason: collision with root package name and from kotlin metadata */
    private int viewFlags;

    /* renamed from: y, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Runnable pendingCheckForLongPress;

    /* renamed from: z, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private Function2<? super Float, ? super Float, String> accessTouchedViewId;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/qqvideoedit/editor/background/border/EditViewContext$EditScene;", "", "(Ljava/lang/String;I)V", "MULTIMEDIA", "STICKER", "PIP", "FRAME", "NULL", "qqvideoedit_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes17.dex */
    public enum EditScene {
        MULTIMEDIA,
        STICKER,
        PIP,
        FRAME,
        NULL
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/qqvideoedit/editor/background/border/EditViewContext$b", "Lcom/tencent/mobileqq/qqvideoedit/editor/background/border/EditContainerView$b;", "Landroid/view/MotionEvent;", "event", "", "onDispatchTouchEvent", "qqvideoedit_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes17.dex */
    public static final class b implements EditContainerView.b {
        b() {
        }

        @Override // com.tencent.mobileqq.qqvideoedit.editor.background.border.EditContainerView.b
        public boolean onDispatchTouchEvent(@NotNull MotionEvent event) {
            Intrinsics.checkNotNullParameter(event, "event");
            EditViewContext.this.actionIndex = event.getActionIndex();
            int action = event.getAction() & 255;
            if (action == 0) {
                return EditViewContext.this.y(event);
            }
            if (action != 1) {
                if (action == 2) {
                    return EditViewContext.this.z(event);
                }
                if (action != 3) {
                    if (action == 5) {
                        return EditViewContext.this.A(event);
                    }
                    if (action != 6) {
                        EditContainerView editContainerView = EditViewContext.this.rootView;
                        if (editContainerView != null) {
                            editContainerView.setNeedDrawRefLine(false);
                        }
                        EditContainerView editContainerView2 = EditViewContext.this.rootView;
                        if (editContainerView2 == null) {
                            return false;
                        }
                        editContainerView2.invalidate();
                        return false;
                    }
                    return EditViewContext.this.B(event);
                }
            }
            return EditViewContext.this.C(event);
        }
    }

    public EditViewContext(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
        this.borderViewMap = new LinkedHashMap();
        this.renderRatio = 1.0f;
        this.fixedSizeRatio = 1.0f;
        this.curUuid = "invalidViewId";
        this.curEditTransform = new EditViewTransform(null, null, 0.0f, 0.0f, 0.0f, 0.0f, 63, null);
        this.editScene = EditScene.NULL;
        this.observers = new ArrayList(2);
        this.filterGapMap = new LinkedHashMap();
        this.lastUpdateTimeMap = new LinkedHashMap();
        this.operationMode = EditViewOperationMode.OP_NONE;
        this.orgPoint = new PointF();
        this.downPoint = new PointF();
        this.lastDownScale = 1.0f;
        this.viewFlags = 127;
        this.pendingCheckForLongPress = new Runnable() { // from class: com.tencent.mobileqq.qqvideoedit.editor.background.border.b
            @Override // java.lang.Runnable
            public final void run() {
                EditViewContext.L(EditViewContext.this);
            }
        };
        this.accessTouchedViewId = new Function2<Float, Float, String>() { // from class: com.tencent.mobileqq.qqvideoedit.editor.background.border.EditViewContext$accessTouchedViewId$1
            @NotNull
            public final String invoke(float f16, float f17) {
                return "invalidViewId";
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ String invoke(Float f16, Float f17) {
                return invoke(f16.floatValue(), f17.floatValue());
            }
        };
        this.dispatchTouchEventListener = new b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean A(MotionEvent event) {
        this.operationMode = EditViewOperationMode.OP_NONE;
        this.isClickEvent = false;
        O();
        Object obj = this.curBorderView;
        if (obj != null) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type android.view.View");
            if (((View) obj).getVisibility() != 8) {
                com.tencent.videocut.utils.h hVar = com.tencent.videocut.utils.h.f384240a;
                this.twoPointDownRotate = hVar.d(event);
                this.twoPointDownDistance = hVar.a(new PointF(event.getX(this.actionIndex), event.getY(this.actionIndex)), this.downPoint);
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean B(MotionEvent event) {
        this.operationMode = EditViewOperationMode.OP_NONE;
        if (event.getPointerId(this.actionIndex) == 0) {
            this.downPoint.set(event.getX(1), event.getY(1));
        } else if (1 == event.getPointerId(this.actionIndex)) {
            this.downPoint.set(event.getX(0), event.getY(0));
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean C(MotionEvent event) {
        PointF f16;
        Float h16;
        if (this.isClickEvent) {
            M(event);
        } else {
            H(this.curUuid, this.curEditTransform);
        }
        this.operationMode = EditViewOperationMode.OP_NONE;
        this.isClickEvent = false;
        O();
        c cVar = this.curBorderView;
        if (cVar != null && (h16 = cVar.h()) != null) {
            this.curEditTransform.m(h16.floatValue());
            c cVar2 = this.curBorderView;
            if (cVar2 != null) {
                cVar2.a(this.curEditTransform);
            }
            J(this.curUuid, this.curEditTransform);
        }
        c cVar3 = this.curBorderView;
        if (cVar3 != null && (f16 = cVar3.f()) != null) {
            this.curEditTransform.k(f16);
            this.curEditTransform.i(q(f16));
            this.curEditTransform.j(r(f16));
            c cVar4 = this.curBorderView;
            if (cVar4 != null) {
                cVar4.a(this.curEditTransform);
            }
            J(this.curUuid, this.curEditTransform);
        }
        EditContainerView editContainerView = this.rootView;
        if (editContainerView != null) {
            editContainerView.setNeedDrawRefLine(false);
        }
        EditContainerView editContainerView2 = this.rootView;
        if (editContainerView2 != null) {
            editContainerView2.invalidate();
            return true;
        }
        return true;
    }

    private final float D(float scale) {
        float f16;
        float f17;
        c cVar = this.curBorderView;
        if (cVar != null) {
            f16 = cVar.e();
        } else {
            f16 = 0.1f;
        }
        c cVar2 = this.curBorderView;
        if (cVar2 != null) {
            f17 = cVar2.getMaxScale();
        } else {
            f17 = 2.0f;
        }
        if (f16 <= 0.0f || scale >= f16) {
            f16 = scale;
        }
        if (f17 <= 0.0f || scale <= f17) {
            return f16;
        }
        return f17;
    }

    private final void F(String uuid) {
        Iterator<T> it = this.observers.iterator();
        while (it.hasNext()) {
            ((d) it.next()).e(uuid);
        }
    }

    private final void G(String uuid) {
        Iterator<T> it = this.observers.iterator();
        while (it.hasNext()) {
            ((d) it.next()).d(uuid);
        }
    }

    private final void H(String uuid, EditViewTransform editViewTransform) {
        EditViewTransform b16 = EditViewTransform.b(editViewTransform, null, null, 0.0f, (-1) * editViewTransform.getRotation(), 0.0f, 0.0f, 55, null);
        Iterator<T> it = this.observers.iterator();
        while (it.hasNext()) {
            ((d) it.next()).b(uuid, b16);
        }
    }

    private final void I(String uuid) {
        Iterator<T> it = this.observers.iterator();
        while (it.hasNext()) {
            ((d) it.next()).a(uuid);
        }
    }

    private final void J(String uuid, EditViewTransform editViewTransform) {
        int i3;
        long j3;
        EditViewTransform b16 = EditViewTransform.b(editViewTransform, null, null, 0.0f, (-1) * editViewTransform.getRotation(), 0.0f, 0.0f, 55, null);
        long currentTimeMillis = System.currentTimeMillis();
        for (d dVar : this.observers) {
            Integer num = this.filterGapMap.get(dVar);
            if (num != null) {
                i3 = num.intValue();
            } else {
                i3 = 0;
            }
            Long l3 = this.lastUpdateTimeMap.get(dVar);
            if (l3 != null) {
                j3 = l3.longValue();
            } else {
                j3 = 0;
            }
            if (currentTimeMillis - j3 >= i3) {
                dVar.c(uuid, b16);
                this.lastUpdateTimeMap.put(dVar, Long.valueOf(currentTimeMillis));
            }
        }
    }

    private final void K(float deltaX, float deltaY) {
        Float c16;
        float b16 = (com.tencent.videocut.utils.h.f384240a.b(deltaX, deltaY) - this.twoPointDownRotate) + this.lastDownRotate;
        if (b16 < 0.0f) {
            b16 += 360.0f;
        } else if (b16 >= 360.0f) {
            b16 -= 360.0f;
        }
        c cVar = this.curBorderView;
        if (cVar != null && (c16 = cVar.c(b16)) != null) {
            b16 = c16.floatValue();
        }
        this.curEditTransform.l(b16);
        if (this.twoPointDownDistance > 0.0f) {
            float D = D((((float) Math.sqrt((deltaX * deltaX) + (deltaY * deltaY))) / this.twoPointDownDistance) * this.lastDownScale);
            if (this.curBorderView != null) {
                this.curEditTransform.m(D);
            }
        }
        J(this.curUuid, this.curEditTransform);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void L(EditViewContext this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.isClickEvent = false;
    }

    private final void M(MotionEvent event) {
        String x16 = x(event.getX(), event.getY());
        if (Intrinsics.areEqual(this.curUuid, x16)) {
            i(x16);
            return;
        }
        if (Intrinsics.areEqual(this.curUuid, "invalidViewId")) {
            i(x16);
            Q(true);
            return;
        }
        if (Intrinsics.areEqual(x16, "invalidViewId")) {
            if (l()) {
                i(x16);
            }
        } else if (!Intrinsics.areEqual(this.curUuid, "invalidViewId") && !Intrinsics.areEqual(x16, "invalidViewId") && m()) {
            i(x16);
            Q(true);
        }
    }

    private final void O() {
        EditContainerView editContainerView = this.rootView;
        if (editContainerView != null) {
            editContainerView.removeCallbacks(this.pendingCheckForLongPress);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void P() {
        c cVar = this.curBorderView;
        if (cVar != 0) {
            ((View) cVar).setVisibility(8);
            cVar.setActive(false);
            EditContainerView editContainerView = this.rootView;
            if (editContainerView != null) {
                editContainerView.setCurBorderView(null);
            }
        }
    }

    private final void U() {
        if (this.editScene == EditScene.MULTIMEDIA) {
            this.curEditTransform.n(new Size((int) (this.curEditTransform.getSize().getWidth() * this.renderRatio), (int) (this.curEditTransform.getSize().getHeight() * this.renderRatio)));
        } else {
            this.curEditTransform.n(new Size((int) (this.curEditTransform.getSize().getWidth() * this.renderRatio * this.fixedSizeRatio), (int) (this.curEditTransform.getSize().getHeight() * this.renderRatio * this.fixedSizeRatio)));
        }
        SizeF p16 = p();
        float f16 = 1;
        float f17 = 2;
        this.curEditTransform.getPosition().x = (((this.curEditTransform.getAnchorX() + f16) * p16.width) - this.curEditTransform.getSize().getWidth()) / f17;
        this.curEditTransform.getPosition().y = (((f16 - this.curEditTransform.getAnchorY()) * p16.height) - this.curEditTransform.getSize().getHeight()) / f17;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void j(c bordView) {
        this.curBorderView = bordView;
        if (bordView != 0) {
            ((View) bordView).setVisibility(0);
        }
        c cVar = this.curBorderView;
        if (cVar != null) {
            cVar.setActive(true);
        }
        c cVar2 = this.curBorderView;
        if (cVar2 != null) {
            cVar2.a(this.curEditTransform);
        }
        ms.a.f("EditViewContext", "current transfrom: " + this.curEditTransform);
        EditContainerView editContainerView = this.rootView;
        if (editContainerView != null) {
            editContainerView.setCurBorderView(bordView);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void k(c bordView) {
        if (bordView == 0) {
            return;
        }
        View view = (View) bordView;
        if (view.getParent() == null) {
            ms.a.f("EditViewContext", "real add bord view to root");
            ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -1);
            EditContainerView editContainerView = this.rootView;
            if (editContainerView != null) {
                editContainerView.addView(view, layoutParams);
            }
        }
    }

    private final boolean l() {
        if ((this.viewFlags & 4) == 4) {
            return true;
        }
        return false;
    }

    private final boolean m() {
        if ((this.viewFlags & 2) == 2) {
            return true;
        }
        return false;
    }

    private final boolean n(PointF point) {
        EditContainerView editContainerView = this.rootView;
        if (editContainerView == null) {
            return true;
        }
        int width = editContainerView.getWidth();
        int height = editContainerView.getHeight();
        float f16 = 1;
        float f17 = 2;
        float width2 = point.x - ((this.curEditTransform.getSize().getWidth() * (this.curEditTransform.getScale() - f16)) / f17);
        float height2 = point.y - ((this.curEditTransform.getSize().getHeight() * (this.curEditTransform.getScale() - f16)) / f17);
        float width3 = (this.curEditTransform.getSize().getWidth() * this.curEditTransform.getScale()) + width2;
        float height3 = (this.curEditTransform.getSize().getHeight() * this.curEditTransform.getScale()) + height2;
        if (width3 >= 10.0f && width2 <= width - 10 && height3 >= 10.0f && height2 <= height - 10) {
            return true;
        }
        return false;
    }

    private final void o() {
        EditContainerView editContainerView = this.rootView;
        if (editContainerView != null) {
            editContainerView.postDelayed(this.pendingCheckForLongPress, 500L);
        }
    }

    private final SizeF p() {
        float f16;
        float f17;
        SizeF sizeF = this.renderSize;
        if (sizeF == null) {
            EditContainerView editContainerView = this.rootView;
            if (editContainerView != null) {
                f16 = editContainerView.getWidth();
            } else {
                f16 = 0.0f;
            }
            EditContainerView editContainerView2 = this.rootView;
            if (editContainerView2 != null) {
                f17 = editContainerView2.getHeight();
            } else {
                f17 = 0.0f;
            }
            sizeF = new SizeF(f16, f17, null, 4, null);
        }
        return sizeF;
    }

    @RequiresApi(21)
    private final float q(PointF vertex) {
        float f16;
        SizeF sizeF = this.renderSize;
        if (sizeF != null) {
            f16 = sizeF.width;
        } else {
            EditContainerView editContainerView = this.rootView;
            if (editContainerView != null) {
                f16 = editContainerView.getWidth();
            } else {
                f16 = 0.0f;
            }
        }
        return (((float) Math.ceil(vertex.x + (this.curEditTransform.getSize().getWidth() / 2))) / (f16 / 2)) - 1;
    }

    private final float r(PointF vertex) {
        float f16;
        SizeF sizeF = this.renderSize;
        if (sizeF != null) {
            f16 = sizeF.height;
        } else {
            EditContainerView editContainerView = this.rootView;
            if (editContainerView != null) {
                f16 = editContainerView.getHeight();
            } else {
                f16 = 0.0f;
            }
        }
        return 1 - (((float) Math.ceil(vertex.y + (this.curEditTransform.getSize().getHeight() / 2))) / (f16 / 2));
    }

    private final c s(EditScene scene) {
        c cVar = this.borderViewMap.get(scene.name());
        if (cVar == null) {
            cVar = BorderViewFactory.INSTANCE.a().b(scene, this);
        }
        if (cVar != null) {
            this.borderViewMap.put(scene.name(), cVar);
        }
        return cVar;
    }

    private final String x(float x16, float y16) {
        return this.accessTouchedViewId.invoke(Float.valueOf(x16 / this.renderRatio), Float.valueOf(y16 / this.renderRatio));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final boolean y(MotionEvent event) {
        PointF pointF;
        boolean z16 = false;
        if (!E()) {
            return false;
        }
        c cVar = this.curBorderView;
        if (cVar == null) {
            if (Intrinsics.areEqual(x(event.getX(), event.getY()), "invalidViewId")) {
                return false;
            }
            this.isClickEvent = true;
        } else {
            this.isClickEvent = true;
            if (cVar != null) {
                EditViewTransform editViewTransform = this.curEditTransform;
                this.orgPoint = editViewTransform.getPosition();
                this.lastDownRotate = editViewTransform.getRotation();
                this.lastDownScale = editViewTransform.getScale();
            }
        }
        this.downPoint.set(event.getX(), event.getY());
        o();
        c cVar2 = this.curBorderView;
        if (cVar2 != 0) {
            RectF d16 = cVar2.d();
            if (d16 != null) {
                View view = (View) cVar2;
                z16 = d16.contains(event.getX() - view.getX(), event.getY() - view.getY());
            }
            this.isTouchInSingleZoomRotateRect = z16;
        }
        if (this.isTouchInSingleZoomRotateRect) {
            this.operationMode = EditViewOperationMode.OP_SINGLE_ZOOM_ROTATE;
            com.tencent.videocut.utils.h hVar = com.tencent.videocut.utils.h.f384240a;
            c cVar3 = this.curBorderView;
            PointF pointF2 = null;
            if (cVar3 != null) {
                pointF = cVar3.getCenterPointF();
            } else {
                pointF = null;
            }
            this.twoPointDownRotate = hVar.c(pointF, this.downPoint);
            c cVar4 = this.curBorderView;
            if (cVar4 != null) {
                pointF2 = cVar4.getCenterPointF();
            }
            this.twoPointDownDistance = hVar.a(pointF2, this.downPoint);
        }
        EditContainerView editContainerView = this.rootView;
        if (editContainerView != null) {
            editContainerView.setNeedDrawRefLine(true);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean z(MotionEvent event) {
        PointF pointF;
        float f16;
        PointF centerPointF;
        PointF centerPointF2;
        Object obj = this.curBorderView;
        if (obj != null) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type android.view.View");
            if (((View) obj).getVisibility() != 8) {
                float x16 = event.getX();
                float y16 = event.getY();
                if (2 == event.getPointerCount()) {
                    this.operationMode = EditViewOperationMode.OP_DOUBLE_ZOOM_ROTATE;
                    float x17 = event.getX(1) - event.getX(0);
                    float y17 = event.getY(1) - event.getY(0);
                    EditContainerView editContainerView = this.rootView;
                    if (editContainerView != null) {
                        editContainerView.invalidate();
                    }
                    K(x17, y17);
                } else if (1 == event.getPointerCount()) {
                    if (Math.abs(x16 - this.downPoint.x) > 16.0f || Math.abs(y16 - this.downPoint.y) > 16.0f) {
                        this.isClickEvent = false;
                        O();
                    }
                    c cVar = this.curBorderView;
                    if (cVar == null) {
                        return true;
                    }
                    if (this.operationMode == EditViewOperationMode.OP_SINGLE_ZOOM_ROTATE) {
                        float f17 = 0.0f;
                        if (cVar != null && (centerPointF2 = cVar.getCenterPointF()) != null) {
                            f16 = centerPointF2.x - x16;
                        } else {
                            f16 = 0.0f;
                        }
                        c cVar2 = this.curBorderView;
                        if (cVar2 != null && (centerPointF = cVar2.getCenterPointF()) != null) {
                            f17 = centerPointF.y - y16;
                        }
                        K(f16, f17);
                    } else {
                        if (!this.isClickEvent) {
                            this.operationMode = EditViewOperationMode.OP_DRAG;
                        }
                        PointF pointF2 = this.orgPoint;
                        float f18 = pointF2.x + x16;
                        PointF pointF3 = this.downPoint;
                        float f19 = f18 - pointF3.x;
                        float f26 = (pointF2.y + y16) - pointF3.y;
                        if (cVar == null || (pointF = cVar.g(f19, f26)) == null) {
                            pointF = new PointF(f19, f26);
                        }
                        if (!n(pointF)) {
                            return true;
                        }
                        this.curEditTransform.k(pointF);
                        this.curEditTransform.i(q(pointF));
                        this.curEditTransform.j(r(pointF));
                        EditContainerView editContainerView2 = this.rootView;
                        if (editContainerView2 != null) {
                            editContainerView2.invalidate();
                        }
                        J(this.curUuid, this.curEditTransform);
                    }
                }
                return true;
            }
        }
        return false;
    }

    public final boolean E() {
        if ((this.viewFlags & 1) == 1) {
            return true;
        }
        return false;
    }

    public final void N(@NotNull Function2<? super Float, ? super Float, String> viewId) {
        Intrinsics.checkNotNullParameter(viewId, "viewId");
        this.accessTouchedViewId = viewId;
    }

    public final void Q(boolean visible) {
        Object obj = this.curBorderView;
        if (obj != null) {
            if (visible) {
                ((View) obj).setVisibility(0);
            } else {
                ((View) obj).setVisibility(8);
            }
        }
    }

    public final void R(@NotNull EditContainerView view) {
        Intrinsics.checkNotNullParameter(view, "view");
        ms.a.f("EditViewContext", "set edit container view: " + view);
        this.rootView = view;
        if (view != null) {
            view.setDispatchTouchEventListener(this.dispatchTouchEventListener);
        }
    }

    public final void S(@NotNull EditScene scene) {
        Intrinsics.checkNotNullParameter(scene, "scene");
        this.editScene = scene;
    }

    public final void T(@NotNull SizeF size, float ratio, float fixedSizeRatio) {
        Intrinsics.checkNotNullParameter(size, "size");
        this.renderSize = size;
        this.renderRatio = ratio;
        this.fixedSizeRatio = fixedSizeRatio;
        EditContainerView editContainerView = this.rootView;
        if (editContainerView != null) {
            ViewGroup.LayoutParams layoutParams = editContainerView.getLayoutParams();
            layoutParams.width = (int) size.width;
            layoutParams.height = (int) size.height;
            editContainerView.setLayoutParams(layoutParams);
            U();
            c cVar = this.curBorderView;
            if (cVar != null) {
                cVar.a(this.curEditTransform);
            }
        }
    }

    public final void i(@NotNull String uuid) {
        Intrinsics.checkNotNullParameter(uuid, "uuid");
        ms.a.f("EditViewContext", "active with uuid = " + uuid + ", curUuid = " + this.curUuid + ", editScene = " + this.editScene);
        if (Intrinsics.areEqual(this.curUuid, uuid)) {
            if (!Intrinsics.areEqual(this.curUuid, "invalidViewId")) {
                F(uuid);
                return;
            }
            return;
        }
        if (Intrinsics.areEqual(this.curUuid, "invalidViewId")) {
            c s16 = s(this.editScene);
            if (s16 != null) {
                k(s16);
                j(s16);
            }
            this.curUuid = uuid;
            G(uuid);
            return;
        }
        if (Intrinsics.areEqual(uuid, "invalidViewId")) {
            P();
            this.curBorderView = null;
            String str = this.curUuid;
            this.curUuid = "invalidViewId";
            I(str);
            return;
        }
        if (!Intrinsics.areEqual(this.curUuid, "invalidViewId") && !Intrinsics.areEqual(uuid, "invalidViewId")) {
            c s17 = s(this.editScene);
            if (s17 != null && !Intrinsics.areEqual(s17, this.curBorderView)) {
                P();
                k(s17);
                j(s17);
            }
            String str2 = this.curUuid;
            this.curUuid = "invalidViewId";
            I(str2);
            this.curUuid = uuid;
            c cVar = this.curBorderView;
            if (cVar != null) {
                cVar.a(this.curEditTransform);
            }
            G(this.curUuid);
        }
    }

    @NotNull
    /* renamed from: t, reason: from getter */
    public final Context getContext() {
        return this.context;
    }

    @NotNull
    /* renamed from: u, reason: from getter */
    public final EditViewTransform getCurEditTransform() {
        return this.curEditTransform;
    }

    @NotNull
    /* renamed from: v, reason: from getter */
    public final String getCurUuid() {
        return this.curUuid;
    }

    @NotNull
    /* renamed from: w, reason: from getter */
    public final EditScene getEditScene() {
        return this.editScene;
    }
}
