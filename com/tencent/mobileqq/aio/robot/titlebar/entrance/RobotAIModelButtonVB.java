package com.tencent.mobileqq.aio.robot.titlebar.entrance;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Vibrator;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ad.tangram.statistics.metric.AdMetricTag;
import com.tencent.aio.data.AIOContact;
import com.tencent.aio.data.AIOParam;
import com.tencent.aio.data.AIOSession;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.bugly.common.constants.Constants;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.aio.robot.titlebar.RobotAIOTitleContainerVB;
import com.tencent.mobileqq.aio.robot.titlebar.RobotAIOTitleVB;
import com.tencent.mobileqq.aio.robot.titlebar.entrance.RobotAIModelButtonVB$aiModelListCallback$2;
import com.tencent.mobileqq.aio.robot.titlebar.entrance.RobotAIModelButtonVB$modelListDialogCallback$2;
import com.tencent.mobileqq.aio.robot.titlebar.modellist.RobotAIModelList;
import com.tencent.mobileqq.aio.robot.titlebar.modellist.f;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.mvi.mvvm.BaseVB;
import com.tencent.mvi.mvvm.BaseVM;
import com.tencent.mvi.mvvm.framework.FrameworkVM;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.kernel.nativeinterface.ModelConfig;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import k81.RobotAIModelData;
import k81.RobotModelProfileInfo;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00a2\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\b\u0005\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n*\u0002TY\u0018\u0000 f2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0001:\u0001gB\u0015\u0012\f\u00106\u001a\b\u0012\u0004\u0012\u00020302\u00a2\u0006\u0004\bd\u0010eJ\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0007\u001a\u00020\u0005H\u0002J\b\u0010\b\u001a\u00020\u0005H\u0002J\b\u0010\t\u001a\u00020\u0005H\u0002J*\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u000eH\u0002J\u0012\u0010\u0013\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0011\u001a\u00020\u0003H\u0002J\b\u0010\u0014\u001a\u00020\u0005H\u0002J\u0012\u0010\u0017\u001a\u00020\u00052\b\b\u0002\u0010\u0016\u001a\u00020\u0015H\u0002J\b\u0010\u0018\u001a\u00020\u0005H\u0002J\u001a\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\u0003H\u0002J\u0010\u0010\u001f\u001a\u00020\u00122\u0006\u0010\u001e\u001a\u00020\u001dH\u0016J\b\u0010 \u001a\u00020\u0005H\u0016J\u001c\u0010#\u001a\u0016\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\"\u0018\u00010!H\u0016J\u0016\u0010'\u001a\u00020\u00052\u0006\u0010%\u001a\u00020$2\u0006\u0010&\u001a\u00020\u000eJ\u000e\u0010)\u001a\u00020\u00052\u0006\u0010(\u001a\u00020\u0015J\u000e\u0010+\u001a\u00020\u00052\u0006\u0010*\u001a\u00020\u000eJ\u000e\u0010-\u001a\u00020\u00052\u0006\u0010,\u001a\u00020\u0015J\u0010\u00100\u001a\u00020\u00052\u0006\u0010/\u001a\u00020.H\u0016J\b\u00101\u001a\u00020\u0005H\u0016R\u001a\u00106\u001a\b\u0012\u0004\u0012\u000203028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b4\u00105R\u0018\u0010:\u001a\u0004\u0018\u0001078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b8\u00109R\u001b\u0010@\u001a\u00020;8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b<\u0010=\u001a\u0004\b>\u0010?R\u001b\u0010E\u001a\u00020A8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bB\u0010=\u001a\u0004\bC\u0010DR\u0018\u0010I\u001a\u0004\u0018\u00010F8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bG\u0010HR\u0016\u0010L\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bJ\u0010KR\u0016\u0010O\u001a\u00020$8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bM\u0010NR\u0016\u0010Q\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bP\u0010KR\u0016\u0010S\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bR\u0010KR\u001b\u0010X\u001a\u00020T8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bU\u0010=\u001a\u0004\bV\u0010WR\u001b\u0010]\u001a\u00020Y8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bZ\u0010=\u001a\u0004\b[\u0010\\R\u0014\u0010a\u001a\u00020^8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b_\u0010`R\u0016\u0010c\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bb\u0010b\u00a8\u0006h"}, d2 = {"Lcom/tencent/mobileqq/aio/robot/titlebar/entrance/RobotAIModelButtonVB;", "Lcom/tencent/aio/base/mvvm/a;", "", "", "visibility", "", "B1", "v1", "H1", "C1", "Lk81/a;", "data", "index", AdMetricTag.Report.TYPE, "", "preSelModelId", "y1", "viewId", "Landroid/view/View;", ICustomDataEditor.NUMBER_PARAM_1, "x1", "", "forceUpdateTitle", Constants.BASE_IN_PLUGIN_ID, "l1", "drawableResId", "colorResId", "Landroid/graphics/drawable/Drawable;", "r1", "Lcom/tencent/mvi/api/help/a;", "createViewParams", "onCreateView", "bindViewAndData", "Lcom/tencent/mvi/mvvm/BaseVM;", "Lcom/tencent/aio/api/runtime/a;", "createVM", "Lk81/c;", "modelProfileInfo", "selectModelId", Constants.APK_CERTIFICATE, "showEar", ICustomDataEditor.STRING_PARAM_1, "modelName", "A1", "isSelectModel", "u1", "Lcom/tencent/mvi/api/help/b;", "reuseParam", "onReuseView", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Lmqq/util/WeakReference;", "Lcom/tencent/mobileqq/aio/robot/titlebar/RobotAIOTitleContainerVB;", "d", "Lmqq/util/WeakReference;", "defaultVB", "Lp81/a;", "e", "Lp81/a;", "modelButtonBinding", "Lk81/b;", "f", "Lkotlin/Lazy;", "p1", "()Lk81/b;", "modelDataManager", "Lcom/tencent/mobileqq/aio/robot/titlebar/entrance/d;", h.F, "o1", "()Lcom/tencent/mobileqq/aio/robot/titlebar/entrance/d;", "modelButtonVM", "Lcom/tencent/mobileqq/aio/robot/titlebar/modellist/f;", "i", "Lcom/tencent/mobileqq/aio/robot/titlebar/modellist/f;", "modelListDialog", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Z", "showEarIcon", BdhLogUtil.LogTag.Tag_Conn, "Lk81/c;", "robotModelInfo", "D", "initShowButton", "E", "isMultiSelectMode", "com/tencent/mobileqq/aio/robot/titlebar/entrance/RobotAIModelButtonVB$modelListDialogCallback$2$a", UserInfo.SEX_FEMALE, "q1", "()Lcom/tencent/mobileqq/aio/robot/titlebar/entrance/RobotAIModelButtonVB$modelListDialogCallback$2$a;", "modelListDialogCallback", "com/tencent/mobileqq/aio/robot/titlebar/entrance/RobotAIModelButtonVB$aiModelListCallback$2$a", "G", "m1", "()Lcom/tencent/mobileqq/aio/robot/titlebar/entrance/RobotAIModelButtonVB$aiModelListCallback$2$a;", "aiModelListCallback", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "H", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "updateButtonPositionListener", "I", "titleOriginalWidth", "<init>", "(Lmqq/util/WeakReference;)V", "J", "a", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class RobotAIModelButtonVB extends com.tencent.aio.base.mvvm.a<Object, Object> {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private RobotModelProfileInfo robotModelInfo;

    /* renamed from: D, reason: from kotlin metadata */
    private boolean initShowButton;

    /* renamed from: E, reason: from kotlin metadata */
    private boolean isMultiSelectMode;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final Lazy modelListDialogCallback;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final Lazy aiModelListCallback;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private final ViewTreeObserver.OnGlobalLayoutListener updateButtonPositionListener;

    /* renamed from: I, reason: from kotlin metadata */
    private int titleOriginalWidth;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final WeakReference<RobotAIOTitleContainerVB> defaultVB;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private p81.a modelButtonBinding;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy modelDataManager;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy modelButtonVM;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private f modelListDialog;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private boolean showEarIcon;

    public RobotAIModelButtonVB(@NotNull WeakReference<RobotAIOTitleContainerVB> defaultVB) {
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        Lazy lazy4;
        Intrinsics.checkNotNullParameter(defaultVB, "defaultVB");
        this.defaultVB = defaultVB;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<k81.b>() { // from class: com.tencent.mobileqq.aio.robot.titlebar.entrance.RobotAIModelButtonVB$modelDataManager$2
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final k81.b invoke() {
                return new k81.b();
            }
        });
        this.modelDataManager = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<d>() { // from class: com.tencent.mobileqq.aio.robot.titlebar.entrance.RobotAIModelButtonVB$modelButtonVM$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final d invoke() {
                return new d();
            }
        });
        this.modelButtonVM = lazy2;
        this.robotModelInfo = new RobotModelProfileInfo(0L, null, 0L, null, null, 31, null);
        this.initShowButton = true;
        lazy3 = LazyKt__LazyJVMKt.lazy(new Function0<RobotAIModelButtonVB$modelListDialogCallback$2.a>() { // from class: com.tencent.mobileqq.aio.robot.titlebar.entrance.RobotAIModelButtonVB$modelListDialogCallback$2

            /* compiled from: P */
            @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/mobileqq/aio/robot/titlebar/entrance/RobotAIModelButtonVB$modelListDialogCallback$2$a", "Lcom/tencent/mobileqq/aio/robot/titlebar/modellist/c;", "", "onDismiss", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
            /* loaded from: classes11.dex */
            public static final class a implements com.tencent.mobileqq.aio.robot.titlebar.modellist.c {

                /* renamed from: a, reason: collision with root package name */
                final /* synthetic */ RobotAIModelButtonVB f193642a;

                a(RobotAIModelButtonVB robotAIModelButtonVB) {
                    this.f193642a = robotAIModelButtonVB;
                }

                @Override // com.tencent.mobileqq.aio.robot.titlebar.modellist.c
                public void onDismiss() {
                    this.f193642a.modelListDialog = null;
                }
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final a invoke() {
                return new a(RobotAIModelButtonVB.this);
            }
        });
        this.modelListDialogCallback = lazy3;
        lazy4 = LazyKt__LazyJVMKt.lazy(new Function0<RobotAIModelButtonVB$aiModelListCallback$2.a>() { // from class: com.tencent.mobileqq.aio.robot.titlebar.entrance.RobotAIModelButtonVB$aiModelListCallback$2

            /* compiled from: P */
            @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0018\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/aio/robot/titlebar/entrance/RobotAIModelButtonVB$aiModelListCallback$2$a", "Lcom/tencent/mobileqq/aio/robot/titlebar/modellist/b;", "", "position", "Lk81/a;", "data", "", "b", "a", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
            /* loaded from: classes11.dex */
            public static final class a implements com.tencent.mobileqq.aio.robot.titlebar.modellist.b {

                /* renamed from: a, reason: collision with root package name */
                final /* synthetic */ RobotAIModelButtonVB f193641a;

                a(RobotAIModelButtonVB robotAIModelButtonVB) {
                    this.f193641a = robotAIModelButtonVB;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public static final void d(RobotAIModelButtonVB this$0) {
                    Intrinsics.checkNotNullParameter(this$0, "this$0");
                    this$0.D1(true);
                }

                @Override // com.tencent.mobileqq.aio.robot.titlebar.modellist.b
                public void a(int position, @NotNull RobotAIModelData data) {
                    RobotModelProfileInfo robotModelProfileInfo;
                    f fVar;
                    Intrinsics.checkNotNullParameter(data, "data");
                    robotModelProfileInfo = this.f193641a.robotModelInfo;
                    QLog.i("RobotAIModelButtonVB", 1, "onCancelItem data = " + data + " robotName = " + robotModelProfileInfo.getRobotName());
                    fVar = this.f193641a.modelListDialog;
                    if (fVar != null) {
                        fVar.c();
                    }
                    this.f193641a.H1();
                    RobotAIModelButtonVB.z1(this.f193641a, data, position, 3, null, 8, null);
                }

                @Override // com.tencent.mobileqq.aio.robot.titlebar.modellist.b
                public void b(int position, @NotNull RobotAIModelData data) {
                    RobotModelProfileInfo robotModelProfileInfo;
                    f fVar;
                    k81.b p16;
                    k81.b p17;
                    k81.b p18;
                    d o16;
                    Intrinsics.checkNotNullParameter(data, "data");
                    robotModelProfileInfo = this.f193641a.robotModelInfo;
                    QLog.i("RobotAIModelButtonVB", 1, "onSelectItem data = " + data + " robotName = " + robotModelProfileInfo.getRobotName());
                    fVar = this.f193641a.modelListDialog;
                    if (fVar != null) {
                        fVar.c();
                    }
                    p16 = this.f193641a.p1();
                    String curSelectModelId = p16.getCurSelectModelId();
                    p17 = this.f193641a.p1();
                    String b16 = p17.b();
                    p18 = this.f193641a.p1();
                    p18.i(data.getModelID());
                    this.f193641a.A1(data.getTitle());
                    o16 = this.f193641a.o1();
                    o16.l(data, b16);
                    this.f193641a.H1();
                    this.f193641a.y1(data, position, 3, curSelectModelId);
                    Handler uIHandlerV2 = ThreadManagerV2.getUIHandlerV2();
                    final RobotAIModelButtonVB robotAIModelButtonVB = this.f193641a;
                    uIHandlerV2.postDelayed(
                    /*  JADX ERROR: Method code generation error
                        jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0088: INVOKE 
                          (r5v1 'uIHandlerV2' android.os.Handler)
                          (wrap:java.lang.Runnable:0x0083: CONSTRUCTOR (r6v1 'robotAIModelButtonVB' com.tencent.mobileqq.aio.robot.titlebar.entrance.RobotAIModelButtonVB A[DONT_INLINE]) A[MD:(com.tencent.mobileqq.aio.robot.titlebar.entrance.RobotAIModelButtonVB):void (m), WRAPPED] (LINE:132) call: com.tencent.mobileqq.aio.robot.titlebar.entrance.c.<init>(com.tencent.mobileqq.aio.robot.titlebar.entrance.RobotAIModelButtonVB):void type: CONSTRUCTOR)
                          (5 long)
                         VIRTUAL call: android.os.Handler.postDelayed(java.lang.Runnable, long):boolean A[MD:(java.lang.Runnable, long):boolean (c)] (LINE:137) in method: com.tencent.mobileqq.aio.robot.titlebar.entrance.RobotAIModelButtonVB$aiModelListCallback$2.a.b(int, k81.a):void, file: classes11.dex
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:310)
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:273)
                        	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:94)
                        	at jadx.core.dex.nodes.IBlock.generate(IBlock.java:15)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                        	at jadx.core.dex.regions.Region.generate(Region.java:35)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                        	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:297)
                        	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:276)
                        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:406)
                        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:335)
                        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:301)
                        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
                        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                        	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.tencent.mobileqq.aio.robot.titlebar.entrance.c, state: NOT_LOADED
                        	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:304)
                        	at jadx.core.codegen.InsnGen.inlineAnonymousConstructor(InsnGen.java:781)
                        	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:730)
                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:418)
                        	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:145)
                        	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:121)
                        	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:108)
                        	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:1117)
                        	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:884)
                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:422)
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:303)
                        	... 15 more
                        */
                    /*
                        this = this;
                        java.lang.String r0 = "data"
                        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
                        com.tencent.mobileqq.aio.robot.titlebar.entrance.RobotAIModelButtonVB r0 = r4.f193641a
                        k81.c r0 = com.tencent.mobileqq.aio.robot.titlebar.entrance.RobotAIModelButtonVB.g1(r0)
                        java.lang.String r0 = r0.getRobotName()
                        java.lang.StringBuilder r1 = new java.lang.StringBuilder
                        r1.<init>()
                        java.lang.String r2 = "onSelectItem data = "
                        r1.append(r2)
                        r1.append(r6)
                        java.lang.String r2 = " robotName = "
                        r1.append(r2)
                        r1.append(r0)
                        java.lang.String r0 = r1.toString()
                        java.lang.String r1 = "RobotAIModelButtonVB"
                        r2 = 1
                        com.tencent.qphone.base.util.QLog.i(r1, r2, r0)
                        com.tencent.mobileqq.aio.robot.titlebar.entrance.RobotAIModelButtonVB r0 = r4.f193641a
                        com.tencent.mobileqq.aio.robot.titlebar.modellist.f r0 = com.tencent.mobileqq.aio.robot.titlebar.entrance.RobotAIModelButtonVB.f1(r0)
                        if (r0 == 0) goto L3d
                        r0.c()
                    L3d:
                        com.tencent.mobileqq.aio.robot.titlebar.entrance.RobotAIModelButtonVB r0 = r4.f193641a
                        k81.b r0 = com.tencent.mobileqq.aio.robot.titlebar.entrance.RobotAIModelButtonVB.e1(r0)
                        java.lang.String r0 = r0.getCurSelectModelId()
                        com.tencent.mobileqq.aio.robot.titlebar.entrance.RobotAIModelButtonVB r1 = r4.f193641a
                        k81.b r1 = com.tencent.mobileqq.aio.robot.titlebar.entrance.RobotAIModelButtonVB.e1(r1)
                        java.lang.String r1 = r1.b()
                        com.tencent.mobileqq.aio.robot.titlebar.entrance.RobotAIModelButtonVB r2 = r4.f193641a
                        k81.b r2 = com.tencent.mobileqq.aio.robot.titlebar.entrance.RobotAIModelButtonVB.e1(r2)
                        java.lang.String r3 = r6.getModelID()
                        r2.i(r3)
                        com.tencent.mobileqq.aio.robot.titlebar.entrance.RobotAIModelButtonVB r2 = r4.f193641a
                        java.lang.String r3 = r6.getTitle()
                        r2.A1(r3)
                        com.tencent.mobileqq.aio.robot.titlebar.entrance.RobotAIModelButtonVB r2 = r4.f193641a
                        com.tencent.mobileqq.aio.robot.titlebar.entrance.d r2 = com.tencent.mobileqq.aio.robot.titlebar.entrance.RobotAIModelButtonVB.d1(r2)
                        r2.l(r6, r1)
                        com.tencent.mobileqq.aio.robot.titlebar.entrance.RobotAIModelButtonVB r1 = r4.f193641a
                        com.tencent.mobileqq.aio.robot.titlebar.entrance.RobotAIModelButtonVB.k1(r1)
                        com.tencent.mobileqq.aio.robot.titlebar.entrance.RobotAIModelButtonVB r1 = r4.f193641a
                        r2 = 3
                        com.tencent.mobileqq.aio.robot.titlebar.entrance.RobotAIModelButtonVB.h1(r1, r6, r5, r2, r0)
                        android.os.Handler r5 = com.tencent.mobileqq.app.ThreadManagerV2.getUIHandlerV2()
                        com.tencent.mobileqq.aio.robot.titlebar.entrance.RobotAIModelButtonVB r6 = r4.f193641a
                        com.tencent.mobileqq.aio.robot.titlebar.entrance.c r0 = new com.tencent.mobileqq.aio.robot.titlebar.entrance.c
                        r0.<init>(r6)
                        r1 = 5
                        r5.postDelayed(r0, r1)
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.tencent.mobileqq.aio.robot.titlebar.entrance.RobotAIModelButtonVB$aiModelListCallback$2.a.b(int, k81.a):void");
                }
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final a invoke() {
                return new a(RobotAIModelButtonVB.this);
            }
        });
        this.aiModelListCallback = lazy4;
        this.updateButtonPositionListener = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.tencent.mobileqq.aio.robot.titlebar.entrance.b
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public final void onGlobalLayout() {
                RobotAIModelButtonVB.F1(RobotAIModelButtonVB.this);
            }
        };
    }

    private final void B1(int visibility) {
        LinearLayout linearLayout;
        p81.a aVar = this.modelButtonBinding;
        if (aVar != null) {
            linearLayout = aVar.getRoot();
        } else {
            linearLayout = null;
        }
        if (linearLayout != null) {
            linearLayout.setVisibility(visibility);
        }
    }

    private final void C1() {
        Activity activity;
        View n16;
        Context mContext = getMContext();
        if (mContext instanceof Activity) {
            activity = (Activity) mContext;
        } else {
            activity = null;
        }
        if (activity == null || (n16 = n1(R.id.f98175md)) == null) {
            return;
        }
        View n17 = n1(R.id.ivTitleBtnLeft);
        if (n17 == null) {
            n17 = n16;
        }
        RobotAIModelList robotAIModelList = new RobotAIModelList(getMContext(), null, 0, 6, null);
        robotAIModelList.setData(p1().d());
        robotAIModelList.setupCallback(m1());
        f fVar = new f();
        this.modelListDialog = fVar;
        fVar.h(q1());
        int[] iArr = new int[2];
        n16.getLocationOnScreen(iArr);
        int[] iArr2 = new int[2];
        activity.getWindow().getDecorView().getLocationOnScreen(iArr2);
        int i3 = 0;
        int a16 = (iArr[0] - l81.a.a(16)) - iArr2[0];
        f fVar2 = this.modelListDialog;
        if (fVar2 != null) {
            fVar2.b(activity, robotAIModelList, a16);
        }
        f fVar3 = this.modelListDialog;
        if (fVar3 != null) {
            fVar3.i(n17, a16 + iArr2[0], iArr[1] + n16.getHeight() + l81.a.a(12));
        }
        Iterator<T> it = p1().d().iterator();
        while (true) {
            int i16 = i3;
            if (it.hasNext()) {
                Object next = it.next();
                i3 = i16 + 1;
                if (i16 < 0) {
                    CollectionsKt__CollectionsKt.throwIndexOverflow();
                }
                z1(this, (RobotAIModelData) next, i16, 1, null, 8, null);
            } else {
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void D1(boolean forceUpdateTitle) {
        View n16;
        ImageView imageView;
        boolean z16;
        float f16;
        int coerceAtLeast;
        p81.a aVar = this.modelButtonBinding;
        if (aVar == null || (n16 = n1(R.id.f98175md)) == null) {
            return;
        }
        float x16 = n16.getX() + n16.getWidth() + l81.a.a(8);
        View n17 = n1(R.id.up5);
        if (n17 instanceof ImageView) {
            imageView = (ImageView) n17;
        } else {
            imageView = null;
        }
        boolean z17 = false;
        if (imageView != null && imageView.getVisibility() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (this.showEarIcon || z16) {
            x16 += l81.a.a(8);
        }
        View n18 = n1(R.id.f74353w1);
        if (n18 != null && n18.getVisibility() == 0) {
            z17 = true;
        }
        if (z17) {
            if (this.titleOriginalWidth == 0) {
                this.titleOriginalWidth = n16.getWidth();
            }
            coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(n16.getWidth() - ((int) (((aVar.getRoot().getWidth() + x16) - n18.getX()) + ViewUtils.dip2px(8.0f))), 1);
            int i3 = this.titleOriginalWidth;
            if (coerceAtLeast > i3) {
                coerceAtLeast = i3;
            }
            if (n16.getWidth() != coerceAtLeast) {
                ViewGroup.LayoutParams layoutParams = n16.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.width = coerceAtLeast;
                    n16.setLayoutParams(layoutParams);
                    return;
                }
                throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
            }
        }
        View n19 = n1(R.id.f98705nt);
        if (n19 != null) {
            f16 = n19.getY();
        } else {
            f16 = 0.0f;
        }
        float y16 = (n16.getY() + f16) - ((aVar.getRoot().getHeight() - n16.getHeight()) / 2);
        ViewGroup.LayoutParams layoutParams2 = aVar.getRoot().getLayoutParams();
        Intrinsics.checkNotNull(layoutParams2, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams2;
        int i16 = (int) x16;
        if (marginLayoutParams.leftMargin == i16 && marginLayoutParams.topMargin == ((int) y16)) {
            return;
        }
        marginLayoutParams.leftMargin = i16;
        marginLayoutParams.topMargin = (int) y16;
        aVar.getRoot().setLayoutParams(marginLayoutParams);
    }

    static /* synthetic */ void E1(RobotAIModelButtonVB robotAIModelButtonVB, boolean z16, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z16 = false;
        }
        robotAIModelButtonVB.D1(z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void F1(RobotAIModelButtonVB this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        E1(this$0, false, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void H1() {
        Vibrator vibrator;
        Object systemService = BaseApplication.getContext().getSystemService("vibrator");
        if (systemService instanceof Vibrator) {
            vibrator = (Vibrator) systemService;
        } else {
            vibrator = null;
        }
        if (vibrator != null) {
            vibrator.vibrate(50L);
        }
    }

    private final void l1() {
        ImageView imageView;
        p81.a aVar = this.modelButtonBinding;
        if (aVar != null && (imageView = aVar.f425711b) != null) {
            imageView.setImageDrawable(r1(R.drawable.qui_chevron_down, R.color.qui_common_icon_secondary));
        }
    }

    private final RobotAIModelButtonVB$aiModelListCallback$2.a m1() {
        return (RobotAIModelButtonVB$aiModelListCallback$2.a) this.aiModelListCallback.getValue();
    }

    private final View n1(int viewId) {
        RobotAIOTitleVB robotAIOTitleVB;
        ViewGroup viewGroup;
        RobotAIOTitleContainerVB robotAIOTitleContainerVB = this.defaultVB.get();
        if (robotAIOTitleContainerVB == null) {
            return null;
        }
        Iterator it = robotAIOTitleContainerVB.getMChildren().iterator();
        while (it.hasNext()) {
            BaseVB baseVB = (BaseVB) it.next();
            if (baseVB instanceof RobotAIOTitleVB) {
                robotAIOTitleVB = (RobotAIOTitleVB) baseVB;
            } else {
                robotAIOTitleVB = null;
            }
            if (robotAIOTitleVB != null) {
                View hostView = robotAIOTitleVB.getHostView();
                if (hostView instanceof ViewGroup) {
                    viewGroup = (ViewGroup) hostView;
                } else {
                    viewGroup = null;
                }
                if (viewGroup == null) {
                    return null;
                }
                return viewGroup.findViewById(viewId);
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final d o1() {
        return (d) this.modelButtonVM.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final k81.b p1() {
        return (k81.b) this.modelDataManager.getValue();
    }

    private final RobotAIModelButtonVB$modelListDialogCallback$2.a q1() {
        return (RobotAIModelButtonVB$modelListDialogCallback$2.a) this.modelListDialogCallback.getValue();
    }

    private final Drawable r1(int drawableResId, int colorResId) {
        return ie0.a.f().o(BaseApplication.getContext(), drawableResId, colorResId, 1001);
    }

    private final void v1() {
        LinearLayout root;
        p81.a aVar = this.modelButtonBinding;
        if (aVar != null && (root = aVar.getRoot()) != null) {
            root.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.aio.robot.titlebar.entrance.a
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    RobotAIModelButtonVB.w1(RobotAIModelButtonVB.this, view);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void w1(RobotAIModelButtonVB this$0, View view) {
        Map mapOf;
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!this$0.p1().d().isEmpty()) {
            mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to(WinkDaTongReportConstant.ElementParamKey.MODEL_ID, this$0.p1().getCurSelectModelId()));
            com.tencent.mobileqq.aio.utils.b.l("em_bas_operation_mode_switch", mapOf);
            this$0.C1();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void x1() {
        ViewTreeObserver viewTreeObserver;
        View n16 = n1(R.id.f98175md);
        if (n16 != null && (viewTreeObserver = n16.getViewTreeObserver()) != null) {
            viewTreeObserver.addOnGlobalLayoutListener(this.updateButtonPositionListener);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void y1(RobotAIModelData data, int index, int reportType, String preSelModelId) {
        boolean z16;
        HashMap hashMap = new HashMap();
        hashMap.put(WinkDaTongReportConstant.ElementParamKey.MODEL_ID, data.getModelID());
        hashMap.put("functional_location", String.valueOf(index));
        hashMap.put("model_name", data.getTitle());
        hashMap.put("selection_model", p1().getCurSelectModelId());
        if (reportType == 3) {
            if (preSelModelId.length() > 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                hashMap.put("selection_model", preSelModelId);
            }
        }
        if (reportType != 1) {
            if (reportType == 3) {
                com.tencent.mobileqq.aio.utils.b.l("em_bas_bot_toggles_model_menu", hashMap);
                return;
            }
            return;
        }
        com.tencent.mobileqq.aio.utils.b.q("em_bas_bot_toggles_model_menu", hashMap);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void z1(RobotAIModelButtonVB robotAIModelButtonVB, RobotAIModelData robotAIModelData, int i3, int i16, String str, int i17, Object obj) {
        if ((i17 & 8) != 0) {
            str = "";
        }
        robotAIModelButtonVB.y1(robotAIModelData, i3, i16, str);
    }

    public final void A1(@NotNull String modelName) {
        TextView textView;
        Intrinsics.checkNotNullParameter(modelName, "modelName");
        p81.a aVar = this.modelButtonBinding;
        if (aVar != null) {
            textView = aVar.f425712c;
        } else {
            textView = null;
        }
        if (textView != null) {
            textView.setText(modelName);
        }
    }

    public final void G1(@NotNull RobotModelProfileInfo modelProfileInfo, @NotNull String selectModelId) {
        int i3;
        com.tencent.aio.api.runtime.a aVar;
        AIOParam g16;
        AIOSession r16;
        AIOContact c16;
        Intrinsics.checkNotNullParameter(modelProfileInfo, "modelProfileInfo");
        Intrinsics.checkNotNullParameter(selectModelId, "selectModelId");
        this.robotModelInfo = modelProfileInfo;
        FrameworkVM mUIModel = getMUIModel();
        if (mUIModel != null && (aVar = (com.tencent.aio.api.runtime.a) mUIModel.getMContext()) != null && (g16 = aVar.g()) != null && (r16 = g16.r()) != null && (c16 = r16.c()) != null) {
            i3 = c16.e();
        } else {
            i3 = 1;
        }
        k81.b p16 = p1();
        ArrayList<ModelConfig> arrayList = this.robotModelInfo.getInputBox().modelList;
        Intrinsics.checkNotNullExpressionValue(arrayList, "robotModelInfo.inputBox.modelList");
        p16.h(i3, modelProfileInfo, arrayList, selectModelId);
        B1(0);
        if (!p1().g() && !p1().e()) {
            if (p1().f()) {
                this.initShowButton = false;
                B1(8);
            }
            if (this.isMultiSelectMode) {
                B1(8);
            }
            RobotAIModelData a16 = p1().a();
            if (a16 != null) {
                A1(a16.getTitle());
                o1().l(a16, "");
                return;
            }
            return;
        }
        B1(8);
        this.initShowButton = false;
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    public void bindViewAndData() {
        super.bindViewAndData();
        l1();
        x1();
        v1();
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    @Nullable
    public BaseVM<Object, Object, com.tencent.aio.api.runtime.a> createVM() {
        return o1();
    }

    @Override // com.tencent.mvi.mvvm.b
    @NotNull
    public View onCreateView(@NotNull com.tencent.mvi.api.help.a createViewParams) {
        Intrinsics.checkNotNullParameter(createViewParams, "createViewParams");
        p81.a g16 = p81.a.g(LayoutInflater.from(createViewParams.a()), createViewParams.b(), false);
        Intrinsics.checkNotNullExpressionValue(g16, "inflate(inflater, createViewParams.parent, false)");
        this.modelButtonBinding = g16;
        LinearLayout root = g16.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        return root;
    }

    @Override // com.tencent.mvi.mvvm.BaseVB, com.tencent.mvi.mvvm.framework.FrameworkVB
    public void onDestroy() {
        ViewTreeObserver viewTreeObserver;
        super.onDestroy();
        View n16 = n1(R.id.f98175md);
        if (n16 != null && (viewTreeObserver = n16.getViewTreeObserver()) != null) {
            viewTreeObserver.removeOnGlobalLayoutListener(this.updateButtonPositionListener);
        }
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    public void onReuseView(@NotNull com.tencent.mvi.api.help.b reuseParam) {
        ViewTreeObserver viewTreeObserver;
        Intrinsics.checkNotNullParameter(reuseParam, "reuseParam");
        super.onReuseView(reuseParam);
        this.titleOriginalWidth = 0;
        View n16 = n1(R.id.f98175md);
        if (n16 == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = n16.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.width = -2;
            n16.setLayoutParams(layoutParams);
            View n17 = n1(R.id.f98175md);
            if (n17 != null && (viewTreeObserver = n17.getViewTreeObserver()) != null) {
                viewTreeObserver.removeOnGlobalLayoutListener(this.updateButtonPositionListener);
                return;
            }
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    }

    public final void s1(boolean showEar) {
        this.showEarIcon = showEar;
        E1(this, false, 1, null);
    }

    public final void u1(boolean isSelectModel) {
        LinearLayout linearLayout;
        int i3;
        this.isMultiSelectMode = isSelectModel;
        if (!this.initShowButton) {
            return;
        }
        p81.a aVar = this.modelButtonBinding;
        if (aVar != null) {
            linearLayout = aVar.getRoot();
        } else {
            linearLayout = null;
        }
        if (linearLayout != null) {
            if (isSelectModel) {
                i3 = 8;
            } else {
                i3 = 0;
            }
            linearLayout.setVisibility(i3);
        }
    }
}
