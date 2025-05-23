package com.tencent.aelight.camera.ae.camera.ui.panel;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.aelight.camera.ae.AEPituCameraUnit;
import com.tencent.aelight.camera.ae.camera.ui.panel.AEBottomPanelPart;
import com.tencent.aelight.camera.ae.camera.ui.panel.StartPointSeekBar;
import com.tencent.aelight.camera.ae.camera.ui.panel.daoju.AENewMaterialPanel;
import com.tencent.aelight.camera.ae.data.AEMaterialManager;
import com.tencent.aelight.camera.ae.util.AECameraPrefsUtil;
import com.tencent.aelight.camera.api.IAECameraUnit;
import com.tencent.aelight.camera.download.api.IAEResUtil;
import com.tencent.aelight.camera.struct.camera.material.AEMaterialCategory;
import com.tencent.aelight.camera.struct.camera.material.AEMaterialMetaData;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread;
import com.tencent.ttpic.openapi.model.VideoMaterial;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import mqq.os.MqqHandler;

@Metadata(d1 = {"\u0000\u00b0\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 b2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001cB\u001f\u0012\u0006\u0010\\\u001a\u00020[\u0012\u0006\u0010]\u001a\u00020@\u0012\u0006\u0010_\u001a\u00020^\u00a2\u0006\u0004\b`\u0010aJ\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\u0018\u0010\n\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007H\u0002J\u0010\u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bH\u0002J\b\u0010\u000e\u001a\u00020\u0007H\u0002J\b\u0010\u000f\u001a\u00020\u0004H\u0002J\b\u0010\u0010\u001a\u00020\u0004H\u0002J\u0010\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0011H\u0002J\u0010\u0010\u0014\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bH\u0002J\b\u0010\u0015\u001a\u00020\u0004H\u0002J\b\u0010\u0016\u001a\u00020\u0004H\u0002J\b\u0010\u0017\u001a\u00020\u0004H\u0014J\b\u0010\u0018\u001a\u00020\u0004H\u0016J\b\u0010\u0019\u001a\u00020\u0004H\u0016J\b\u0010\u001a\u001a\u00020\u0004H\u0016J9\u0010 \u001a\u00020\u00042\b\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u001d\u001a\u00020\u00112\u0016\u0010\u001f\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u001b0\u001e\"\u0004\u0018\u00010\u001bH\u0016\u00a2\u0006\u0004\b \u0010!J\u001a\u0010%\u001a\u00020\u00042\b\u0010#\u001a\u0004\u0018\u00010\"2\u0006\u0010$\u001a\u00020\u0011H\u0016J\u0012\u0010'\u001a\u00020\u00042\b\u0010&\u001a\u0004\u0018\u00010\"H\u0016J\u0012\u0010(\u001a\u00020\u00042\b\u0010&\u001a\u0004\u0018\u00010\"H\u0016R\u0014\u0010+\u001a\u00020)8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b(\u0010*R\u0014\u0010/\u001a\u00020,8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b-\u0010.R\u0014\u00103\u001a\u0002008\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b1\u00102R\u0014\u00107\u001a\u0002048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b5\u00106R\u0018\u0010:\u001a\u0004\u0018\u0001088\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u00109R\u0018\u0010&\u001a\u0004\u0018\u00010\"8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b%\u0010;R\u0018\u0010?\u001a\u0004\u0018\u00010<8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b=\u0010>R\u0018\u0010C\u001a\u0004\u0018\u00010@8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bA\u0010BR\u0018\u0010G\u001a\u0004\u0018\u00010D8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bE\u0010FR\u0018\u0010K\u001a\u0004\u0018\u00010H8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bI\u0010JR\u0018\u0010L\u001a\u0004\u0018\u00010H8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u0010JR\u0018\u0010O\u001a\u0004\u0018\u00010M8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010NR\u0016\u0010R\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bP\u0010QR\u0016\u0010S\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0005\u0010QR\u0016\u0010U\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bT\u0010QR\u001b\u0010Z\u001a\u00020V8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bW\u0010X\u001a\u0004\bI\u0010Y\u00a8\u0006d"}, d2 = {"Lcom/tencent/aelight/camera/ae/camera/ui/panel/AEBottomPanelPart;", "Lcom/tencent/aelight/camera/ae/part/b;", "Lyq2/c;", "Lcom/tencent/aelight/camera/ae/camera/ui/panel/StartPointSeekBar$a;", "", "J", "initViewModel", "", "clearPresetInfo", "showNotFoundToast", "G", "Lcom/tencent/aelight/camera/struct/camera/material/AEMaterialMetaData;", WadlProxyConsts.KEY_MATERIAL, "Y", "N", "T", "H", "", "progress", "W", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "P", "V", "initView", "onActivityResume", "onActivityStop", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "", "sender", "eventId", "", "args", "notify", "(Ljava/lang/Object;I[Ljava/lang/Object;)V", "Lcom/tencent/aelight/camera/ae/camera/ui/panel/StartPointSeekBar;", "bar", "value", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "seekbar", "i", "d", "Lcom/tencent/aelight/camera/ae/AEPituCameraUnit;", "Lcom/tencent/aelight/camera/ae/AEPituCameraUnit;", "unit", "Lcom/tencent/aelight/camera/ae/camera/ui/panel/t;", "e", "Lcom/tencent/aelight/camera/ae/camera/ui/panel/t;", "bottomPanelViewModel", "Lcom/tencent/aelight/camera/ae/e;", "f", "Lcom/tencent/aelight/camera/ae/e;", "materialViewModel", "Lcom/tencent/aelight/camera/ae/data/AEMaterialManager;", tl.h.F, "Lcom/tencent/aelight/camera/ae/data/AEMaterialManager;", "templateManager", "Lcom/tencent/aelight/camera/ae/camera/ui/panel/daoju/AENewMaterialPanel;", "Lcom/tencent/aelight/camera/ae/camera/ui/panel/daoju/AENewMaterialPanel;", "daoJuPanel", "Lcom/tencent/aelight/camera/ae/camera/ui/panel/StartPointSeekBar;", "Landroid/widget/RelativeLayout;", BdhLogUtil.LogTag.Tag_Conn, "Landroid/widget/RelativeLayout;", "seekbarContainer", "Landroid/view/View;", "D", "Landroid/view/View;", "panelPart", "Landroid/widget/TextView;", "E", "Landroid/widget/TextView;", "tvAdjustLevel", "", UserInfo.SEX_FEMALE, "Ljava/lang/String;", "mPresetMaterialId", "mPresetMaterialTab", "Lcom/tencent/ttpic/openapi/model/VideoMaterial;", "Lcom/tencent/ttpic/openapi/model/VideoMaterial;", "currentMaterial", "I", "Z", "isShowMakeupSeekBar", "mCancelApplyPresetMaterial", "K", "hasShownNotFindPresetMaterialToast", "Lcom/tencent/aelight/camera/ae/view/a;", "L", "Lkotlin/Lazy;", "()Lcom/tencent/aelight/camera/ae/view/a;", "mHandlePresetMaterialLoading", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, MosaicConstants$JsProperty.PROP_ROOT_VIEW, "Lcom/tencent/aelight/camera/ae/part/c;", "partManager", "<init>", "(Landroid/app/Activity;Landroid/view/View;Lcom/tencent/aelight/camera/ae/part/c;)V", "M", "a", "aelight_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes32.dex */
public final class AEBottomPanelPart extends com.tencent.aelight.camera.ae.part.b implements yq2.c, StartPointSeekBar.a {

    /* renamed from: C, reason: from kotlin metadata */
    private RelativeLayout seekbarContainer;

    /* renamed from: D, reason: from kotlin metadata */
    private View panelPart;

    /* renamed from: E, reason: from kotlin metadata */
    private TextView tvAdjustLevel;

    /* renamed from: F, reason: from kotlin metadata */
    private String mPresetMaterialId;

    /* renamed from: G, reason: from kotlin metadata */
    private String mPresetMaterialTab;

    /* renamed from: H, reason: from kotlin metadata */
    private VideoMaterial currentMaterial;

    /* renamed from: I, reason: from kotlin metadata */
    private boolean isShowMakeupSeekBar;

    /* renamed from: J, reason: from kotlin metadata */
    private boolean mCancelApplyPresetMaterial;

    /* renamed from: K, reason: from kotlin metadata */
    private boolean hasShownNotFindPresetMaterialToast;

    /* renamed from: L, reason: from kotlin metadata */
    private final Lazy mHandlePresetMaterialLoading;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final AEPituCameraUnit unit;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final t bottomPanelViewModel;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final com.tencent.aelight.camera.ae.e materialViewModel;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final AEMaterialManager templateManager;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private AENewMaterialPanel daoJuPanel;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private StartPointSeekBar seekbar;

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\u0005"}, d2 = {"com/tencent/aelight/camera/ae/camera/ui/panel/AEBottomPanelPart$c", "Ldq/a;", "", "a", "b", "aelight_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes32.dex */
    public static final class c implements dq.a {
        c() {
        }

        @Override // dq.a
        public boolean a() {
            return AEMaterialManager.f63518v;
        }

        @Override // dq.a
        public boolean b() {
            return AEMaterialManager.f63519w;
        }
    }

    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\n\u0010\u0006\u001a\u0004\u0018\u00010\u0002H\u0016J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0016J\n\u0010\n\u001a\u0004\u0018\u00010\u0007H\u0016J\u0018\u0010\r\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u000bH\u0016\u00a8\u0006\u000e"}, d2 = {"com/tencent/aelight/camera/ae/camera/ui/panel/AEBottomPanelPart$d", "Ldq/b;", "", "id", "", "c", "d", "Lcom/tencent/aelight/camera/struct/camera/material/AEMaterialMetaData;", WadlProxyConsts.KEY_MATERIAL, "a", "b", "Lcom/tencent/aelight/camera/download/a;", "listener", "e", "aelight_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes32.dex */
    public static final class d implements dq.b {
        d() {
        }

        @Override // dq.b
        public void a(AEMaterialMetaData material) {
            Intrinsics.checkNotNullParameter(material, "material");
            AEBottomPanelPart.this.templateManager.x0(null);
            AEBottomPanelPart.this.templateManager.w0(material, true);
            com.tencent.aelight.camera.ae.e.U1(AEBottomPanelPart.this.materialViewModel, 4, material, false, 4, null);
        }

        @Override // dq.b
        public AEMaterialMetaData b() {
            return AEMaterialManager.H();
        }

        @Override // dq.b
        public void c(String id5) {
            AEBottomPanelPart.this.templateManager.x0(id5);
        }

        @Override // dq.b
        public String d() {
            return AEBottomPanelPart.this.templateManager.I();
        }

        @Override // dq.b
        public void e(AEMaterialMetaData material, com.tencent.aelight.camera.download.a listener) {
            Intrinsics.checkNotNullParameter(material, "material");
            Intrinsics.checkNotNullParameter(listener, "listener");
            AEBottomPanelPart.this.templateManager.E0(AEBottomPanelPart.this.templateManager.getApp(), material, listener);
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/aelight/camera/ae/camera/ui/panel/AEBottomPanelPart$e", "Landroid/os/Handler;", "Landroid/os/Message;", "msg", "", "handleMessage", "aelight_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes32.dex */
    public static final class e extends Handler {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f62876b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ HandlerThread f62877c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ AEMaterialMetaData f62878d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ Ref.IntRef f62879e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ long f62880f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        e(int i3, HandlerThread handlerThread, AEMaterialMetaData aEMaterialMetaData, Ref.IntRef intRef, long j3, Looper looper) {
            super(looper);
            this.f62876b = i3;
            this.f62877c = handlerThread;
            this.f62878d = aEMaterialMetaData;
            this.f62879e = intRef;
            this.f62880f = j3;
        }

        @Override // android.os.Handler
        public void handleMessage(Message msg2) {
            Intrinsics.checkNotNullParameter(msg2, "msg");
            if (!AEBottomPanelPart.this.mCancelApplyPresetMaterial) {
                if (AEBottomPanelPart.this.N()) {
                    removeMessages(this.f62876b);
                    this.f62877c.quit();
                    AEBottomPanelPart.this.H();
                    AEBottomPanelPart.this.Q(this.f62878d);
                    return;
                }
                Ref.IntRef intRef = this.f62879e;
                int i3 = intRef.element;
                if (i3 != 99) {
                    int i16 = i3 + 1;
                    intRef.element = i16;
                    AEBottomPanelPart.this.W(i16);
                }
                sendEmptyMessageDelayed(this.f62876b, this.f62880f);
                return;
            }
            removeMessages(this.f62876b);
            this.f62877c.quit();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AEBottomPanelPart(Activity activity, View rootView, com.tencent.aelight.camera.ae.part.c partManager) {
        super(activity, rootView, partManager);
        Lazy lazy;
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        Intrinsics.checkNotNullParameter(partManager, "partManager");
        Object b16 = this.mPartManager.b(65537, new Object[0]);
        Intrinsics.checkNotNullExpressionValue(b16, "mPartManager.get(VSCaptu\u2026.MANAGER_GET_ACTION_UNIT)");
        AEPituCameraUnit aEPituCameraUnit = (AEPituCameraUnit) b16;
        this.unit = aEPituCameraUnit;
        ViewModel viewModel = com.tencent.aelight.camera.ae.n.a(aEPituCameraUnit).get(t.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "of(unit).get(AEBottomPanelViewModel::class.java)");
        this.bottomPanelViewModel = (t) viewModel;
        ViewModel viewModel2 = com.tencent.aelight.camera.ae.n.a(aEPituCameraUnit).get(com.tencent.aelight.camera.ae.e.class);
        Intrinsics.checkNotNullExpressionValue(viewModel2, "of(unit).get(AEMaterialViewModel::class.java)");
        this.materialViewModel = (com.tencent.aelight.camera.ae.e) viewModel2;
        com.tencent.aelight.camera.ae.control.b d16 = com.tencent.aelight.camera.ae.control.a.c().d(1);
        Intrinsics.checkNotNull(d16, "null cannot be cast to non-null type com.tencent.aelight.camera.ae.data.AEMaterialManager");
        this.templateManager = (AEMaterialManager) d16;
        lazy = LazyKt__LazyJVMKt.lazy(new AEBottomPanelPart$mHandlePresetMaterialLoading$2(this));
        this.mHandlePresetMaterialLoading = lazy;
    }

    private final com.tencent.aelight.camera.ae.view.a F() {
        return (com.tencent.aelight.camera.ae.view.a) this.mHandlePresetMaterialLoading.getValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v7, types: [T, java.lang.Object] */
    private final void G(boolean clearPresetInfo, boolean showNotFoundToast) {
        ms.a.f("AEBottomPanelPart", "start handle preset material");
        String str = this.mPresetMaterialId;
        if (str == null || str.length() == 0) {
            ms.a.f("AEBottomPanelPart", "preset material id is null");
            return;
        }
        if (!"camera".equals(this.mPresetMaterialTab)) {
            ms.a.f("AEBottomPanelPart", "not from camera");
            return;
        }
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        Iterator<AEMaterialCategory> it = this.templateManager.L().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            AEMaterialCategory next = it.next();
            List<AEMaterialMetaData> list = next.f69044d;
            Intrinsics.checkNotNullExpressionValue(list, "cat.materialList");
            Iterator<AEMaterialMetaData> it5 = list.iterator();
            int i3 = 0;
            while (true) {
                if (!it5.hasNext()) {
                    i3 = -1;
                    break;
                } else if (Intrinsics.areEqual(it5.next().f69050id, this.mPresetMaterialId)) {
                    break;
                } else {
                    i3++;
                }
            }
            if (i3 >= 0) {
                objectRef.element = next.f69044d.get(i3);
                break;
            }
        }
        T t16 = objectRef.element;
        if (t16 != 0 || clearPresetInfo) {
            this.mPresetMaterialId = null;
        }
        if (t16 != 0) {
            boolean N = N();
            boolean z16 = ((AEMaterialMetaData) objectRef.element).usable;
            ms.a.f("AEBottomPanelPart", "find target preset material [" + this.mPresetMaterialId + "], usable=" + z16 + ", baseResReady=" + N);
            if (z16 && N) {
                Q((AEMaterialMetaData) objectRef.element);
                return;
            }
            this.mCancelApplyPresetMaterial = false;
            T();
            if (!z16) {
                this.templateManager.E0(fr.b.a(), (AEMaterialMetaData) objectRef.element, new b(N, objectRef));
                return;
            } else {
                Y((AEMaterialMetaData) objectRef.element);
                return;
            }
        }
        if (!showNotFoundToast || this.hasShownNotFindPresetMaterialToast) {
            return;
        }
        this.hasShownNotFindPresetMaterialToast = true;
        QQToast.makeText(this.mActivity, R.string.y0q, 0).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void H() {
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.aelight.camera.ae.camera.ui.panel.j
            @Override // java.lang.Runnable
            public final void run() {
                AEBottomPanelPart.I(AEBottomPanelPart.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void I(AEBottomPanelPart this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.F().dismiss();
    }

    private final void J() {
        ViewStub viewStub = (ViewStub) this.mRootView.findViewById(R.id.s1x);
        View inflate = viewStub != null ? viewStub.inflate() : null;
        this.panelPart = inflate;
        this.daoJuPanel = inflate != null ? (AENewMaterialPanel) inflate.findViewById(R.id.rx5) : null;
        View view = this.panelPart;
        this.seekbarContainer = view != null ? (RelativeLayout) view.findViewById(R.id.rqs) : null;
        View view2 = this.panelPart;
        this.seekbar = view2 != null ? (StartPointSeekBar) view2.findViewById(R.id.rqq) : null;
        View view3 = this.panelPart;
        this.tvAdjustLevel = view3 != null ? (TextView) view3.findViewById(R.id.f163802s31) : null;
        AENewMaterialPanel aENewMaterialPanel = this.daoJuPanel;
        if (aENewMaterialPanel != null) {
            aENewMaterialPanel.setVisibility(8);
        }
        AENewMaterialPanel aENewMaterialPanel2 = this.daoJuPanel;
        ViewGroup.LayoutParams layoutParams = aENewMaterialPanel2 != null ? aENewMaterialPanel2.getLayoutParams() : null;
        if (layoutParams != null) {
            layoutParams.height = com.tencent.aelight.camera.ae.camera.ui.gallery.t.e(this.mActivity);
        }
        c cVar = new c();
        d dVar = new d();
        AENewMaterialPanel aENewMaterialPanel3 = this.daoJuPanel;
        if (aENewMaterialPanel3 != null) {
            aENewMaterialPanel3.r(dVar, cVar);
        }
        AENewMaterialPanel aENewMaterialPanel4 = this.daoJuPanel;
        if (aENewMaterialPanel4 != null) {
            List<AEMaterialCategory> B = this.templateManager.B(true);
            Intrinsics.checkNotNullExpressionValue(B, "templateManager.getMaterialListWithRecent(true)");
            aENewMaterialPanel4.A(B);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void K(final AEBottomPanelPart this$0, bv bvVar) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (bvVar.getShow()) {
            AENewMaterialPanel aENewMaterialPanel = this$0.daoJuPanel;
            if (aENewMaterialPanel != null) {
                AEMaterialMetaData locateMaterial = bvVar.getLocateMaterial();
                String str = locateMaterial != null ? locateMaterial.firstcategoryname : null;
                AEMaterialMetaData locateMaterial2 = bvVar.getLocateMaterial();
                aENewMaterialPanel.s(str, locateMaterial2 != null ? locateMaterial2.f69050id : null, new Runnable() { // from class: com.tencent.aelight.camera.ae.camera.ui.panel.p
                    @Override // java.lang.Runnable
                    public final void run() {
                        AEBottomPanelPart.L(AEBottomPanelPart.this);
                    }
                });
                return;
            }
            return;
        }
        RelativeLayout relativeLayout = this$0.seekbarContainer;
        if (relativeLayout != null) {
            relativeLayout.setVisibility(8);
        }
        AENewMaterialPanel aENewMaterialPanel2 = this$0.daoJuPanel;
        if (aENewMaterialPanel2 != null) {
            aENewMaterialPanel2.p(new Runnable() { // from class: com.tencent.aelight.camera.ae.camera.ui.panel.q
                @Override // java.lang.Runnable
                public final void run() {
                    AEBottomPanelPart.M(AEBottomPanelPart.this);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void L(AEBottomPanelPart this$0) {
        RelativeLayout relativeLayout;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!this$0.isShowMakeupSeekBar || (relativeLayout = this$0.seekbarContainer) == null) {
            return;
        }
        relativeLayout.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void M(AEBottomPanelPart this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.unit.I1().a(false, 150);
        this$0.mPartManager.q(131075, new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean N() {
        return ((IAEResUtil) QRoute.api(IAEResUtil.class)).isLightCameraResExist();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void O(int i3, AEBottomPanelPart this$0, Object[] args) {
        AENewMaterialPanel aENewMaterialPanel;
        AENewMaterialPanel aENewMaterialPanel2;
        AENewMaterialPanel aENewMaterialPanel3;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(args, "$args");
        if (i3 == 111) {
            ms.a.f("AEBottomPanelPart", "receive recent template list update");
            List<AEMaterialCategory> B = this$0.templateManager.B(true);
            if (B.size() < 1 || (aENewMaterialPanel = this$0.daoJuPanel) == null) {
                return;
            }
            AEMaterialCategory aEMaterialCategory = B.get(0);
            Intrinsics.checkNotNullExpressionValue(aEMaterialCategory, "list[0]");
            aENewMaterialPanel.C(aEMaterialCategory, 0);
            return;
        }
        if (i3 != 1024) {
            String str = null;
            switch (i3) {
                case 113:
                    ms.a.f("AEBottomPanelPart", "receive select template update event");
                    AENewMaterialPanel aENewMaterialPanel4 = this$0.daoJuPanel;
                    if (aENewMaterialPanel4 != null) {
                        aENewMaterialPanel4.D();
                        return;
                    }
                    return;
                case 114:
                    if (!(args.length == 0)) {
                        Object obj = args[0];
                        VideoMaterial videoMaterial = obj instanceof VideoMaterial ? (VideoMaterial) obj : null;
                        if (videoMaterial != null) {
                            str = videoMaterial.getId();
                        }
                    }
                    ms.a.f("AEBottomPanelPart", "receive show watermark edit picture event, id = " + str);
                    if (str == null || (aENewMaterialPanel2 = this$0.daoJuPanel) == null) {
                        return;
                    }
                    aENewMaterialPanel2.v(str, true);
                    return;
                case 115:
                    if (!(args.length == 0)) {
                        Object obj2 = args[0];
                        VideoMaterial videoMaterial2 = obj2 instanceof VideoMaterial ? (VideoMaterial) obj2 : null;
                        if (videoMaterial2 != null) {
                            str = videoMaterial2.getId();
                        }
                    }
                    ms.a.f("AEBottomPanelPart", "receive hide watermark edit picture event, id = " + str);
                    if (str == null || (aENewMaterialPanel3 = this$0.daoJuPanel) == null) {
                        return;
                    }
                    aENewMaterialPanel3.v(str, false);
                    return;
                case 116:
                    ms.a.f("AEBottomPanelPart", "receive template info list update event");
                    AENewMaterialPanel aENewMaterialPanel5 = this$0.daoJuPanel;
                    if (aENewMaterialPanel5 != null) {
                        List<AEMaterialCategory> B2 = this$0.templateManager.B(true);
                        Intrinsics.checkNotNullExpressionValue(B2, "templateManager.getMaterialListWithRecent(true)");
                        aENewMaterialPanel5.A(B2);
                    }
                    this$0.G(true, true);
                    return;
                default:
                    return;
            }
        }
        ms.a.f("AEBottomPanelPart", "receive select select watermark use event");
        AENewMaterialPanel aENewMaterialPanel6 = this$0.daoJuPanel;
        if (aENewMaterialPanel6 != null) {
            aENewMaterialPanel6.D();
        }
    }

    private final void P() {
        this.templateManager.g(this, 116);
        this.templateManager.g(this, 111);
        this.templateManager.g(this, 113);
        this.templateManager.g(this, 1024);
        this.templateManager.g(this, 114);
        this.templateManager.g(this, 115);
        this.templateManager.N(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Q(final AEMaterialMetaData material) {
        this.unit.P2(new Runnable() { // from class: com.tencent.aelight.camera.ae.camera.ui.panel.n
            @Override // java.lang.Runnable
            public final void run() {
                AEBottomPanelPart.R(AEBottomPanelPart.this, material);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void R(final AEBottomPanelPart this$0, final AEMaterialMetaData material) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(material, "$material");
        ThreadManager.getUIHandler().postDelayed(new Runnable() { // from class: com.tencent.aelight.camera.ae.camera.ui.panel.o
            @Override // java.lang.Runnable
            public final void run() {
                AEBottomPanelPart.S(AEBottomPanelPart.this, material);
            }
        }, 500L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void S(AEBottomPanelPart this$0, AEMaterialMetaData material) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(material, "$material");
        AENewMaterialPanel aENewMaterialPanel = this$0.daoJuPanel;
        if (aENewMaterialPanel != null) {
            String str = material.f69050id;
            Intrinsics.checkNotNullExpressionValue(str, "material.id");
            aENewMaterialPanel.w(null, str);
        }
    }

    private final void T() {
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.aelight.camera.ae.camera.ui.panel.l
            @Override // java.lang.Runnable
            public final void run() {
                AEBottomPanelPart.U(AEBottomPanelPart.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void U(AEBottomPanelPart this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.F().show();
    }

    private final void V() {
        this.templateManager.n0(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void W(final int progress) {
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.aelight.camera.ae.camera.ui.panel.m
            @Override // java.lang.Runnable
            public final void run() {
                AEBottomPanelPart.X(AEBottomPanelPart.this, progress);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void X(AEBottomPanelPart this$0, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.F().P(i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Y(AEMaterialMetaData material) {
        Ref.IntRef intRef = new Ref.IntRef();
        intRef.element = 50;
        BaseHandlerThread baseHandlerThread = new BaseHandlerThread("waitingResReady");
        baseHandlerThread.start();
        new e(1, baseHandlerThread, material, intRef, 200L, baseHandlerThread.getLooper()).sendEmptyMessageDelayed(1, 200L);
    }

    private final void initViewModel() {
        this.bottomPanelViewModel.N1().observe(this.unit, new Observer() { // from class: com.tencent.aelight.camera.ae.camera.ui.panel.k
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                AEBottomPanelPart.K(AEBottomPanelPart.this, (bv) obj);
            }
        });
    }

    @Override // com.tencent.aelight.camera.ae.camera.ui.panel.StartPointSeekBar.a
    public void d(StartPointSeekBar seekbar) {
        VideoMaterial videoMaterial = this.currentMaterial;
        if (videoMaterial == null || seekbar == null) {
            return;
        }
        Intrinsics.checkNotNull(videoMaterial);
        AECameraPrefsUtil.f().d().edit().putInt("makeup_strength_prefix_" + videoMaterial.getId(), Math.round(seekbar.g())).apply();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.aelight.camera.ae.part.b
    public void initView() {
        ms.a.f("AEBottomPanelPart", "init bottom panel part");
        initViewModel();
        J();
        Intent intent = this.mActivity.getIntent();
        this.mPresetMaterialId = intent != null ? intent.getStringExtra(IAECameraUnit.KEY_CURRENT_SELECT_ID) : null;
        Intent intent2 = this.mActivity.getIntent();
        this.mPresetMaterialTab = intent2 != null ? intent2.getStringExtra(IAECameraUnit.KEY_CURRENT_TAB) : null;
        ms.a.f("AEBottomPanelPart", "AIOTakeSame---present material id = " + this.mPresetMaterialId);
        P();
    }

    @Override // com.tencent.aelight.camera.ae.camera.ui.panel.StartPointSeekBar.a
    public void m(StartPointSeekBar bar, int value) {
        this.unit.s3((value * 1.0d) / 100);
        StartPointSeekBar.t(bar, Math.round(value), this.tvAdjustLevel);
    }

    @Override // yq2.c
    public void notify(Object sender, final int eventId, final Object... args) {
        Intrinsics.checkNotNullParameter(args, "args");
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.aelight.camera.ae.camera.ui.panel.i
            @Override // java.lang.Runnable
            public final void run() {
                AEBottomPanelPart.O(eventId, this, args);
            }
        });
    }

    @Override // com.tencent.aelight.camera.ae.part.b
    public void onActivityResume() {
        super.onActivityResume();
        Intrinsics.checkNotNullExpressionValue(this.templateManager.L(), "templateManager.stickerMaterialListWithoutRecent");
        G(false, !r0.isEmpty());
    }

    @Override // com.tencent.aelight.camera.ae.part.b
    public void onActivityStop() {
        super.onActivityStop();
        this.templateManager.q0();
    }

    @Override // com.tencent.aelight.camera.ae.part.b
    public void onDestroy() {
        super.onDestroy();
        V();
        this.templateManager.l();
    }

    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\"\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u001a\u0010\u000b\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\n\u001a\u00020\u0006H\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/aelight/camera/ae/camera/ui/panel/AEBottomPanelPart$b", "Lcom/tencent/aelight/camera/download/a;", "Lcom/tencent/aelight/camera/struct/camera/material/AEMaterialMetaData;", "info", "", "isSuccess", "", "resCode", "", "onDownloadFinish", "progress", "onProgressUpdate", "aelight_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes32.dex */
    public static final class b implements com.tencent.aelight.camera.download.a {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ boolean f62872e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ Ref.ObjectRef<AEMaterialMetaData> f62873f;

        b(boolean z16, Ref.ObjectRef<AEMaterialMetaData> objectRef) {
            this.f62872e = z16;
            this.f62873f = objectRef;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void b(AEBottomPanelPart this$0) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            QQToast.makeText(((com.tencent.aelight.camera.ae.part.b) this$0).mActivity, HardCodeUtil.qqStr(R.string.qdx), 0).show();
        }

        @Override // com.tencent.aelight.camera.download.a
        public void onProgressUpdate(AEMaterialMetaData info, int progress) {
            if (!this.f62872e) {
                progress >>= 1;
            }
            AEBottomPanelPart.this.W(progress);
        }

        @Override // com.tencent.aelight.camera.download.a
        public void onDownloadFinish(AEMaterialMetaData info, boolean isSuccess, int resCode) {
            String str = info != null ? info.f69050id : null;
            ms.a.f("AEBottomPanelPart", "material [" + str + "] download finish, success = " + isSuccess + ", resCode = " + resCode + ", cancel=" + AEBottomPanelPart.this.mCancelApplyPresetMaterial);
            if (AEBottomPanelPart.this.mCancelApplyPresetMaterial) {
                return;
            }
            if (!isSuccess) {
                MqqHandler uIHandler = ThreadManager.getUIHandler();
                final AEBottomPanelPart aEBottomPanelPart = AEBottomPanelPart.this;
                uIHandler.post(new Runnable() { // from class: com.tencent.aelight.camera.ae.camera.ui.panel.r
                    @Override // java.lang.Runnable
                    public final void run() {
                        AEBottomPanelPart.b.b(AEBottomPanelPart.this);
                    }
                });
                AEBottomPanelPart.this.H();
                return;
            }
            if (this.f62872e) {
                AEBottomPanelPart.this.H();
                AEBottomPanelPart.this.Q(this.f62873f.element);
            } else {
                AEBottomPanelPart.this.Y(this.f62873f.element);
            }
        }
    }

    @Override // com.tencent.aelight.camera.ae.camera.ui.panel.StartPointSeekBar.a
    public void i(StartPointSeekBar seekbar) {
    }
}
