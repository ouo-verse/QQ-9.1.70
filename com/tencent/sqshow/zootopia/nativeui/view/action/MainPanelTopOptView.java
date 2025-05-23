package com.tencent.sqshow.zootopia.nativeui.view.action;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import b94.a;
import b94.d;
import b94.e;
import com.google.protobuf.nano.MessageNano;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.aelight.camera.filament.api.IZShowFilamentPreviewProvider;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.zootopia.ZootopiaSource;
import com.tencent.mobileqq.zootopia.api.UEAvatarGender;
import com.tencent.mobileqq.zplan.scheme.ISchemeApi;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.zootopia.avatar.AvatarEngineType;
import com.tencent.sqshow.zootopia.card.report.ZplanViewReportHelper;
import com.tencent.sqshow.zootopia.nativeui.data.CameraKey;
import com.tencent.sqshow.zootopia.nativeui.data.dress.task.DressTaskExtInfo;
import com.tencent.sqshow.zootopia.nativeui.data.repo.AvatarPanelAllData;
import com.tencent.sqshow.zootopia.nativeui.ue.u;
import com.tencent.sqshow.zootopia.nativeui.view.AvatarPanelViewData;
import com.tencent.sqshow.zootopia.nativeui.view.action.MainPanelTopOptView;
import com.tencent.sqshow.zootopia.nativeui.view.loading.NativePanelLoadingIgv;
import com.tencent.zplan.luabridge.a;
import common.config.service.QzoneConfig;
import h94.FinishAIMakeFaceData;
import java.util.HashMap;
import java.util.List;
import k94.DialogCustomData;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import m94.DressErrorMsg;
import n74.ah;
import s94.FaceInfoSyncData;
import uv4.al;
import uv4.am;
import uv4.az;
import uv4.bk;
import z94.a;

@Metadata(d1 = {"\u0000\u0096\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u001a2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001)B'\b\u0007\u0012\u0006\u0010B\u001a\u00020A\u0012\n\b\u0002\u0010D\u001a\u0004\u0018\u00010C\u0012\b\b\u0002\u0010E\u001a\u000204\u00a2\u0006\u0004\bF\u0010GJ\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0016\u0010\u000b\u001a\u00020\u00062\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0002J\b\u0010\f\u001a\u00020\u0006H\u0002J \u0010\u0012\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0010H\u0002J\b\u0010\u0014\u001a\u00020\u0013H\u0002J\u0018\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0004H\u0002J\u0010\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u0013H\u0002J\b\u0010\u0018\u001a\u00020\u0006H\u0002J\n\u0010\u001a\u001a\u0004\u0018\u00010\u0019H\u0002J\u0010\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\rH\u0002J\u0018\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rH\u0002J\b\u0010\u001d\u001a\u00020\u0006H\u0002J\u0018\u0010\u001e\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0004H\u0002J\u0018\u0010\u001f\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0004H\u0002J\u0018\u0010\"\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010!\u001a\u00020 H\u0002J\u000e\u0010%\u001a\u00020\u00062\u0006\u0010$\u001a\u00020#J\u0010\u0010(\u001a\u00020\u00062\u0006\u0010'\u001a\u00020&H\u0016J\b\u0010)\u001a\u00020\u0006H\u0016J\b\u0010*\u001a\u00020\u0006H\u0016J\b\u0010+\u001a\u00020\u0006H\u0016J\u0010\u0010-\u001a\u00020\u00062\u0006\u0010$\u001a\u00020,H\u0016J\u000e\u0010.\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u0004R\u0018\u00101\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b/\u00100R\u0016\u00103\u001a\u00020#8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b(\u00102R\u0016\u00106\u001a\u0002048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b5\u0010\u0012R\u0018\u0010:\u001a\u0004\u0018\u0001078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b8\u00109R\u001a\u0010=\u001a\b\u0012\u0004\u0012\u00020\u00130;8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001c\u0010<R\u0014\u0010@\u001a\u00020>8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b.\u0010?\u00a8\u0006H"}, d2 = {"Lcom/tencent/sqshow/zootopia/nativeui/view/action/MainPanelTopOptView;", "Lcom/tencent/sqshow/zootopia/nativeui/view/action/BaseAvatarPanelTopOptView;", "Lcom/tencent/sqshow/zootopia/nativeui/view/history/f;", "Lz94/a;", "Lcom/tencent/sqshow/zootopia/nativeui/data/j;", WadlProxyConsts.CHANNEL, "", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "", "Luv4/az;", "items", UserInfo.SEX_FEMALE, ExifInterface.LATITUDE_SOUTH, "Ln74/ah;", "binding", "panelChannel", "Landroidx/lifecycle/LifecycleOwner;", "owner", "I", "", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, BdhLogUtil.LogTag.Tag_Req, "running", "V", "Z", "Lcom/tencent/sqshow/zootopia/nativeui/view/loading/NativePanelLoadingIgv;", "E", "G", BdhLogUtil.LogTag.Tag_Conn, "Y", "K", "P", "Lcom/tencent/mobileqq/zootopia/api/UEAvatarGender;", "ueAvatarGender", "X", "Lcom/tencent/sqshow/zootopia/nativeui/view/AvatarPanelViewData;", "data", "setSelectedData", "Landroid/widget/FrameLayout;", ParseCommon.CONTAINER, tl.h.F, "a", "b", "e", "Lh94/a;", "d", "D", "f", "Ln74/ah;", "mBinding", "Lcom/tencent/sqshow/zootopia/nativeui/view/AvatarPanelViewData;", "mCurrentPanelViewData", "", "i", "genderRedDotId", "Lqu4/a;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lqu4/a;", "lastAvatarCharacter", "Landroidx/lifecycle/Observer;", "Landroidx/lifecycle/Observer;", "dressTaskRunningStatusChangeObserver", "Ljava/lang/Runnable;", "Ljava/lang/Runnable;", "mShowLoadingTask", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class MainPanelTopOptView extends BaseAvatarPanelTopOptView implements com.tencent.sqshow.zootopia.nativeui.view.history.f, z94.a {

    /* renamed from: C, reason: from kotlin metadata */
    private final Observer<Boolean> dressTaskRunningStatusChangeObserver;

    /* renamed from: D, reason: from kotlin metadata */
    private final Runnable mShowLoadingTask;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private ah mBinding;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private AvatarPanelViewData mCurrentPanelViewData;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private int genderRedDotId;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private qu4.a lastAvatarCharacter;

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes34.dex */
    public /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f371412a;

        static {
            int[] iArr = new int[AvatarEngineType.values().length];
            try {
                iArr[AvatarEngineType.UE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[AvatarEngineType.FILAMENT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f371412a = iArr;
        }
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/sqshow/zootopia/nativeui/view/action/MainPanelTopOptView$c", "Lcom/tencent/zplan/luabridge/a$b;", "", "success", "", "result", "", "onLuaResult", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class c implements a.b {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ CameraKey f371413d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ com.tencent.sqshow.zootopia.nativeui.data.j f371414e;

        c(CameraKey cameraKey, com.tencent.sqshow.zootopia.nativeui.data.j jVar) {
            this.f371413d = cameraKey;
            this.f371414e = jVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void b(com.tencent.sqshow.zootopia.nativeui.data.j channel, CameraKey currentCameraId) {
            Intrinsics.checkNotNullParameter(channel, "$channel");
            Intrinsics.checkNotNullParameter(currentCameraId, "$currentCameraId");
            channel.getCameraController().w(currentCameraId, "enterAiMakeFace");
        }

        @Override // com.tencent.zplan.luabridge.a.b
        public void onExecuteLua() {
            a.b.C10064a.a(this);
        }

        @Override // com.tencent.zplan.luabridge.a.b
        public void onLuaResult(boolean success, String result) {
            a.b.C10064a.b(this, success, result);
            if (success && this.f371413d.c()) {
                Handler uIHandlerV2 = ThreadManagerV2.getUIHandlerV2();
                final com.tencent.sqshow.zootopia.nativeui.data.j jVar = this.f371414e;
                final CameraKey cameraKey = this.f371413d;
                uIHandlerV2.post(new Runnable() { // from class: com.tencent.sqshow.zootopia.nativeui.view.action.m
                    @Override // java.lang.Runnable
                    public final void run() {
                        MainPanelTopOptView.c.b(com.tencent.sqshow.zootopia.nativeui.data.j.this, cameraKey);
                    }
                });
            }
            QLog.i("MainPanelTopOptView_", 1, "enterAiMakeFace onLuaResult, success: " + success + ", result:" + result);
        }
    }

    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/sqshow/zootopia/nativeui/view/action/MainPanelTopOptView$d", "Lcom/tencent/mobileqq/zootopia/api/e;", "Luv4/u;", "result", "", "a", "", "error", "", "message", "onResultFailure", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class d implements com.tencent.mobileqq.zootopia.api.e<uv4.u> {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ com.tencent.sqshow.zootopia.nativeui.data.j f371415d;

        d(com.tencent.sqshow.zootopia.nativeui.data.j jVar) {
            this.f371415d = jVar;
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResultSuccess(uv4.u result) {
            Intrinsics.checkNotNullParameter(result, "result");
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        public void onResultFailure(int error, String message) {
            b94.e O = this.f371415d.O();
            if (O != null) {
                O.S2();
            }
            this.f371415d.getCameraController().i();
        }
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/sqshow/zootopia/nativeui/view/action/MainPanelTopOptView$e", "Lm94/h;", "Lcom/tencent/sqshow/zootopia/nativeui/data/dress/task/b;", "task", "Lm94/e;", "errorMsg", "", "a", "b", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class e implements m94.h {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.tencent.sqshow.zootopia.nativeui.data.j f371416a;

        e(com.tencent.sqshow.zootopia.nativeui.data.j jVar) {
            this.f371416a = jVar;
        }

        @Override // m94.h
        public void a(com.tencent.sqshow.zootopia.nativeui.data.dress.task.b task, DressErrorMsg errorMsg) {
            Intrinsics.checkNotNullParameter(task, "task");
            Intrinsics.checkNotNullParameter(errorMsg, "errorMsg");
            b94.e O = this.f371416a.O();
            if (O != null) {
                O.S2();
            }
            this.f371416a.getCameraController().i();
        }

        @Override // m94.h
        public void b(com.tencent.sqshow.zootopia.nativeui.data.dress.task.b task) {
            Intrinsics.checkNotNullParameter(task, "task");
            b94.e O = this.f371416a.O();
            if (O != null) {
                O.S2();
            }
            this.f371416a.getCameraController().i();
        }
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/sqshow/zootopia/nativeui/view/action/MainPanelTopOptView$f", "Lm94/h;", "Lcom/tencent/sqshow/zootopia/nativeui/data/dress/task/b;", "task", "Lm94/e;", "errorMsg", "", "a", "b", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class f implements m94.h {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ com.tencent.sqshow.zootopia.nativeui.data.j f371418b;

        f(com.tencent.sqshow.zootopia.nativeui.data.j jVar) {
            this.f371418b = jVar;
        }

        @Override // m94.h
        public void a(com.tencent.sqshow.zootopia.nativeui.data.dress.task.b task, DressErrorMsg errorMsg) {
            Intrinsics.checkNotNullParameter(task, "task");
            Intrinsics.checkNotNullParameter(errorMsg, "errorMsg");
        }

        @Override // m94.h
        public void b(com.tencent.sqshow.zootopia.nativeui.data.dress.task.b task) {
            Intrinsics.checkNotNullParameter(task, "task");
            MainPanelTopOptView.this.A(this.f371418b);
        }
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/sqshow/zootopia/nativeui/view/action/MainPanelTopOptView$g", "Lm94/h;", "Lcom/tencent/sqshow/zootopia/nativeui/data/dress/task/b;", "task", "Lm94/e;", "errorMsg", "", "a", "b", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class g implements m94.h {
        g() {
        }

        @Override // m94.h
        public void a(com.tencent.sqshow.zootopia.nativeui.data.dress.task.b task, DressErrorMsg errorMsg) {
            Intrinsics.checkNotNullParameter(task, "task");
            Intrinsics.checkNotNullParameter(errorMsg, "errorMsg");
        }

        @Override // m94.h
        public void b(com.tencent.sqshow.zootopia.nativeui.data.dress.task.b task) {
            Intrinsics.checkNotNullParameter(task, "task");
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public MainPanelTopOptView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void A(com.tencent.sqshow.zootopia.nativeui.data.j channel) {
        channel.k().setValue(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void B(MainPanelTopOptView this$0, Boolean bool) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.V(bool == null ? false : bool.booleanValue());
    }

    private final void C(com.tencent.sqshow.zootopia.nativeui.data.j channel, ah binding) {
        CameraKey cameraKey;
        boolean z16 = channel.getEngineApi().getType() == AvatarEngineType.UE;
        if (z16 && !u.a.a(channel.getUeStatusController(), false, 1, null)) {
            channel.getEngineApi().e(new am(), null, null, channel.getReporter().getMSource());
            return;
        }
        ZplanViewReportHelper mReporter = channel.getReporter().getMReporter();
        ImageView imageView = binding.f418613b;
        Intrinsics.checkNotNullExpressionValue(imageView, "binding.aiMakeFaceIgv");
        ZplanViewReportHelper.f(mReporter, imageView, "em_zplan_ai_sculpt", null, 4, null);
        j94.a aVar = j94.a.f409675a;
        am a16 = aVar.a();
        if (z16 && a16 == null) {
            QLog.e("MainPanelTopOptView_", 1, "AiFaceCameraConfig is null");
            return;
        }
        b94.e O = channel.O();
        if (O == null || (cameraKey = O.getCameraId()) == null) {
            cameraKey = new CameraKey(0, 0, 2, null);
        }
        am b16 = aVar.b(cameraKey);
        c cVar = new c(cameraKey, channel);
        b94.a engineApi = channel.getEngineApi();
        if (a16 == null) {
            a16 = new am();
        }
        a.C0113a.b(engineApi, a16, b16, cVar, null, 8, null);
    }

    private final NativePanelLoadingIgv E() {
        ah ahVar = this.mBinding;
        if (ahVar != null) {
            return ahVar.f418618g;
        }
        return null;
    }

    private final void F(List<az> items) {
        QLog.i("MainPanelTopOptView_", 1, "handleAiMakeFaceDressTask items:" + r94.c.y(items));
        com.tencent.sqshow.zootopia.nativeui.data.j mChannel = getMChannel();
        if (mChannel == null) {
            return;
        }
        b94.e O = mChannel.O();
        if (O != null) {
            O.Ya("handleAiMakeFaceDressTask", true, false);
        }
        mChannel.a().addAll(r94.b.h(items));
        b94.d avatarDressController = mChannel.getAvatarDressController();
        if (avatarDressController != null) {
            d.a.d(avatarDressController, items, null, null, DressTaskExtInfo.AI_MAKE_FACE, 6, null);
        }
    }

    private final void G(final ah binding) {
        final com.tencent.sqshow.zootopia.nativeui.data.j mChannel = getMChannel();
        if (mChannel == null) {
            return;
        }
        z94.c.f452180e.b(this);
        ZplanViewReportHelper mReporter = mChannel.getReporter().getMReporter();
        ImageView imageView = binding.f418613b;
        Intrinsics.checkNotNullExpressionValue(imageView, "binding.aiMakeFaceIgv");
        mReporter.g(imageView, "em_zplan_ai_sculpt", (r16 & 4) != 0 ? null : null, (r16 & 8) != 0, (r16 & 16) != 0 ? null : null, (r16 & 32) != 0 ? false : false);
        ImageView imageView2 = binding.f418613b;
        Intrinsics.checkNotNullExpressionValue(imageView2, "binding.aiMakeFaceIgv");
        com.tencent.sqshow.zootopia.utils.aa.d(imageView2, new View.OnClickListener() { // from class: com.tencent.sqshow.zootopia.nativeui.view.action.g
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MainPanelTopOptView.H(com.tencent.sqshow.zootopia.nativeui.data.j.this, this, binding, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void H(com.tencent.sqshow.zootopia.nativeui.data.j channel, MainPanelTopOptView this$0, ah binding, View view) {
        Intrinsics.checkNotNullParameter(channel, "$channel");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(binding, "$binding");
        a84.a sceneComponentAvatar = channel.getSceneComponentAvatar();
        if (sceneComponentAvatar != null) {
            sceneComponentAvatar.N0();
        }
        com.tencent.sqshow.zootopia.recommend.characterV2.component.a sceneComponentAvatarV2 = channel.getSceneComponentAvatarV2();
        if (sceneComponentAvatarV2 != null) {
            sceneComponentAvatarV2.N0();
        }
        this$0.C(channel, binding);
    }

    private final void I(ah binding, com.tencent.sqshow.zootopia.nativeui.data.j panelChannel, LifecycleOwner owner) {
        if (z()) {
            MutableLiveData<az> i3 = panelChannel.i();
            final MainPanelTopOptView$initDetailOberver$1 mainPanelTopOptView$initDetailOberver$1 = new MainPanelTopOptView$initDetailOberver$1(this, binding, panelChannel);
            i3.observe(owner, new Observer() { // from class: com.tencent.sqshow.zootopia.nativeui.view.action.l
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    MainPanelTopOptView.J(Function1.this, obj);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void J(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void L(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void M(MainPanelTopOptView this$0, final com.tencent.sqshow.zootopia.nativeui.data.j panelChannel, ah binding, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(panelChannel, "$panelChannel");
        Intrinsics.checkNotNullParameter(binding, "$binding");
        com.tencent.sqshow.zootopia.nativeui.data.j mChannel = this$0.getMChannel();
        if (mChannel != null && u.a.a(mChannel.getUeStatusController(), false, 1, null)) {
            UEAvatarGender n3 = com.tencent.sqshow.zootopia.nativeui.data.c.f370920a.n();
            HashMap hashMap = new HashMap();
            hashMap.put("zplan_gender", Integer.valueOf(n3.getIndex()));
            ZplanViewReportHelper mReporter = panelChannel.getReporter().getMReporter();
            RelativeLayout relativeLayout = binding.f418622k;
            Intrinsics.checkNotNullExpressionValue(relativeLayout, "binding.switchGenderRl");
            mReporter.e(relativeLayout, "em_zplan_gender_switch", hashMap);
            g94.f.b(g94.f.f401577a, this$0.genderRedDotId, binding.f418614c.getStoreType(), 0, false, 12, null);
            b94.e O = panelChannel.O();
            if (O != null) {
                e.a.h(O, 0L, 1, null);
            }
            Runnable runnable = new Runnable() { // from class: com.tencent.sqshow.zootopia.nativeui.view.action.c
                @Override // java.lang.Runnable
                public final void run() {
                    MainPanelTopOptView.N(com.tencent.sqshow.zootopia.nativeui.data.j.this);
                }
            };
            panelChannel.getCameraController().h();
            b94.d avatarDressController = panelChannel.getAvatarDressController();
            if (avatarDressController != null) {
                d.a.b(avatarDressController, null, new d(panelChannel), runnable, 1, null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void N(com.tencent.sqshow.zootopia.nativeui.data.j panelChannel) {
        Intrinsics.checkNotNullParameter(panelChannel, "$panelChannel");
        b94.d avatarDressController = panelChannel.getAvatarDressController();
        if (avatarDressController != null) {
            d.a.h(avatarDressController, new e(panelChannel), true, false, 4, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void O(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void P(final ah binding, final com.tencent.sqshow.zootopia.nativeui.data.j panelChannel) {
        ZplanViewReportHelper mReporter = panelChannel.getReporter().getMReporter();
        ImageView imageView = binding.f418619h;
        Intrinsics.checkNotNullExpressionValue(imageView, "binding.makeFaceIgv");
        mReporter.g(imageView, "em_zplan_sculpt", (r16 & 4) != 0 ? null : null, (r16 & 8) != 0, (r16 & 16) != 0 ? null : null, (r16 & 32) != 0 ? false : false);
        ImageView imageView2 = binding.f418619h;
        Intrinsics.checkNotNullExpressionValue(imageView2, "binding.makeFaceIgv");
        com.tencent.sqshow.zootopia.utils.aa.d(imageView2, new View.OnClickListener() { // from class: com.tencent.sqshow.zootopia.nativeui.view.action.h
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MainPanelTopOptView.Q(MainPanelTopOptView.this, panelChannel, binding, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Q(MainPanelTopOptView this$0, com.tencent.sqshow.zootopia.nativeui.data.j panelChannel, ah binding, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(panelChannel, "$panelChannel");
        Intrinsics.checkNotNullParameter(binding, "$binding");
        com.tencent.sqshow.zootopia.nativeui.data.j mChannel = this$0.getMChannel();
        if (mChannel == null) {
            return;
        }
        b94.a engineApi = mChannel.getEngineApi();
        ZplanViewReportHelper mReporter = panelChannel.getReporter().getMReporter();
        ImageView imageView = binding.f418619h;
        Intrinsics.checkNotNullExpressionValue(imageView, "binding.makeFaceIgv");
        ZplanViewReportHelper.f(mReporter, imageView, "em_zplan_sculpt", null, 4, null);
        int i3 = b.f371412a[engineApi.getType().ordinal()];
        if (i3 == 1) {
            if (u.a.a(mChannel.getUeStatusController(), false, 1, null)) {
                this$0.D(panelChannel);
                return;
            }
            return;
        }
        if (i3 != 2) {
            return;
        }
        this$0.lastAvatarCharacter = com.tencent.sqshow.zootopia.nativeui.data.c.f370920a.k();
        Bundle bundle = new Bundle();
        bundle.putBoolean("onlyMakeupMode", true);
        QRouteApi api = QRoute.api(ISchemeApi.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(ISchemeApi::class.java)");
        ISchemeApi iSchemeApi = (ISchemeApi) api;
        ZootopiaSource a16 = com.tencent.sqshow.zootopia.utils.ah.a(panelChannel.getReporter().getMSource());
        if (a16 == null) {
            a16 = ZootopiaSource.INSTANCE.g();
        }
        String buildMakeUpPageScheme = iSchemeApi.buildMakeUpPageScheme(a16, bundle);
        Context context = this$0.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        iSchemeApi.launchScheme(context, buildMakeUpPageScheme);
    }

    private final void R(ah binding, com.tencent.sqshow.zootopia.nativeui.data.j panelChannel) {
        LifecycleOwner lifecycleOwner = panelChannel.getLifecycleOwner();
        if (lifecycleOwner == null) {
            return;
        }
        com.tencent.sqshow.zootopia.nativeui.ue.n.f371383a.f().observe(lifecycleOwner, this.dressTaskRunningStatusChangeObserver);
    }

    private final void S() {
        com.tencent.sqshow.zootopia.nativeui.data.j mChannel;
        LifecycleOwner lifecycleOwner;
        ah ahVar = this.mBinding;
        if (ahVar == null || (mChannel = getMChannel()) == null || (lifecycleOwner = mChannel.getLifecycleOwner()) == null) {
            return;
        }
        ahVar.f418615d.n(mChannel);
        R(ahVar, mChannel);
        K(ahVar, mChannel);
        P(ahVar, mChannel);
        G(ahVar);
        LiveData<Boolean> a16 = mChannel.getUeStatusController().a();
        final Function1<Boolean, Unit> function1 = new Function1<Boolean, Unit>() { // from class: com.tencent.sqshow.zootopia.nativeui.view.action.MainPanelTopOptView$initViews$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke2(bool);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Boolean bool) {
                MainPanelTopOptView.this.Y();
            }
        };
        a16.observe(lifecycleOwner, new Observer() { // from class: com.tencent.sqshow.zootopia.nativeui.view.action.f
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                MainPanelTopOptView.T(Function1.this, obj);
            }
        });
        ahVar.f418615d.setListener(this);
        ahVar.f418615d.j(lifecycleOwner, mChannel.r());
        I(ahVar, mChannel, lifecycleOwner);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void T(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void U(MainPanelTopOptView this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.Z();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void W(MainPanelTopOptView this$0, List items) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(items, "$items");
        this$0.F(items);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void X(ah binding, UEAvatarGender ueAvatarGender) {
        QLog.d("MainPanelTopOptView_", 1, "refreshGenderView ueAvatarGender:" + ueAvatarGender);
        binding.f418621j.setImageResource(ueAvatarGender == UEAvatarGender.FEMALE ? R.drawable.ieg : R.drawable.iel);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Y() {
        com.tencent.sqshow.zootopia.nativeui.data.j mChannel;
        ah ahVar = this.mBinding;
        if (ahVar == null || (mChannel = getMChannel()) == null) {
            return;
        }
        Boolean value = mChannel.getUeStatusController().a().getValue();
        if (value == null) {
            value = Boolean.FALSE;
        }
        boolean booleanValue = value.booleanValue();
        AvatarEngineType type = mChannel.getEngineApi().getType();
        int l3 = r94.b.l(this.mCurrentPanelViewData.getCategoryGroup());
        if (l3 == 1) {
            setVisibility(0);
            ahVar.f418619h.setVisibility(8);
            ahVar.f418613b.setVisibility(8);
            mChannel.getEngineApi().f();
            mChannel.getEngineApi().c(true);
        } else if (l3 != 2) {
            ahVar.f418617f.setVisibility(8);
            ahVar.f418615d.setVisibility(8);
            mChannel.getEngineApi().f();
            mChannel.getEngineApi().c(true);
        } else {
            setVisibility(0);
            ahVar.f418619h.setVisibility(0);
            ahVar.f418613b.setVisibility((AvatarEngineType.FILAMENT != type || (!QzoneConfig.isNotShowFilamentAI() && ((IZShowFilamentPreviewProvider) QRoute.api(IZShowFilamentPreviewProvider.class)).isSupportFilament())) ? 0 : 8);
            mChannel.getEngineApi().i();
            mChannel.getEngineApi().c(false);
        }
        if (booleanValue) {
            ahVar.f418617f.setVisibility(0);
            ahVar.f418615d.setVisibility(0);
        } else {
            ahVar.f418617f.setVisibility(8);
            ahVar.f418615d.setVisibility(8);
        }
    }

    private final void Z() {
        NativePanelLoadingIgv E = E();
        if (E == null) {
            return;
        }
        E.f();
        E.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean z() {
        MutableLiveData<List<bk>> B;
        com.tencent.sqshow.zootopia.nativeui.data.j mChannel = getMChannel();
        List<bk> value = (mChannel == null || (B = mChannel.B()) == null) ? null : B.getValue();
        return value == null || value.isEmpty();
    }

    public final void D(com.tencent.sqshow.zootopia.nativeui.data.j panelChannel) {
        ga4.g a16;
        Intrinsics.checkNotNullParameter(panelChannel, "panelChannel");
        ga4.j jVar = ga4.j.f401682a;
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        a16 = jVar.a(16, panelChannel, context, (r22 & 8) != 0 ? new DialogCustomData(null, null, null, null, null, 0, 63, null) : null, (r22 & 16) != 0 ? false : false);
        a16.show();
    }

    @Override // com.tencent.sqshow.zootopia.nativeui.view.history.f
    public void a() {
        com.tencent.sqshow.zootopia.nativeui.data.j mChannel;
        b94.d avatarDressController;
        com.tencent.sqshow.zootopia.nativeui.data.j mChannel2 = getMChannel();
        if (mChannel2 == null || !u.a.a(mChannel2.getUeStatusController(), false, 1, null) || (mChannel = getMChannel()) == null || (avatarDressController = mChannel.getAvatarDressController()) == null) {
            return;
        }
        avatarDressController.Y6(new f(mChannel2));
    }

    @Override // com.tencent.sqshow.zootopia.nativeui.view.history.f
    public void b() {
        com.tencent.sqshow.zootopia.nativeui.data.j mChannel;
        b94.d avatarDressController;
        com.tencent.sqshow.zootopia.nativeui.data.j mChannel2 = getMChannel();
        if (mChannel2 == null || !u.a.a(mChannel2.getUeStatusController(), false, 1, null) || (mChannel = getMChannel()) == null || (avatarDressController = mChannel.getAvatarDressController()) == null) {
            return;
        }
        avatarDressController.E9(new g());
    }

    @Override // z94.a
    public void c(FaceInfoSyncData faceInfoSyncData) {
        a.C11666a.a(this, faceInfoSyncData);
    }

    @Override // z94.a
    public void d(FinishAIMakeFaceData data) {
        byte[] bArr;
        final List list;
        Intrinsics.checkNotNullParameter(data, "data");
        QLog.i("MainPanelTopOptView_", 1, "onFinishAiMakeFace data:" + data);
        if (data.getResult() == 0) {
            try {
                bArr = Base64.decode(data.getItemsBase64(), 2);
            } catch (Exception e16) {
                QLog.e("MainPanelTopOptView_", 1, "onFinishAiMakeFace Base64 error", e16);
                bArr = null;
            }
            if (bArr == null) {
                return;
            }
            al alVar = new al();
            MessageNano.mergeFrom(alVar, bArr);
            az[] azVarArr = alVar.f440153b;
            Intrinsics.checkNotNullExpressionValue(azVarArr, "storeAvatarInfo.items");
            list = ArraysKt___ArraysKt.toList(azVarArr);
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.sqshow.zootopia.nativeui.view.action.e
                @Override // java.lang.Runnable
                public final void run() {
                    MainPanelTopOptView.W(MainPanelTopOptView.this, list);
                }
            });
        }
    }

    @Override // com.tencent.sqshow.zootopia.nativeui.view.history.f
    public void e() {
        ga4.g a16;
        ga4.g a17;
        com.tencent.sqshow.zootopia.nativeui.data.j mChannel = getMChannel();
        if (mChannel != null && u.a.a(mChannel.getUeStatusController(), false, 1, null)) {
            int l3 = r94.b.l(this.mCurrentPanelViewData.getCategoryGroup());
            QLog.i("MainPanelTopOptView_", 1, "onResetClick operateType:" + l3);
            if (l3 == 1) {
                ga4.j jVar = ga4.j.f401682a;
                Context context = getContext();
                Intrinsics.checkNotNullExpressionValue(context, "context");
                a16 = jVar.a(1, mChannel, context, (r22 & 8) != 0 ? new DialogCustomData(null, null, null, null, null, 0, 63, null) : null, (r22 & 16) != 0 ? false : false);
                a16.show();
                return;
            }
            if (l3 != 2) {
                return;
            }
            ga4.j jVar2 = ga4.j.f401682a;
            Context context2 = getContext();
            Intrinsics.checkNotNullExpressionValue(context2, "context");
            a17 = jVar2.a(9, mChannel, context2, (r22 & 8) != 0 ? new DialogCustomData(null, null, null, null, null, 0, 63, null) : null, (r22 & 16) != 0 ? false : false);
            a17.show();
        }
    }

    @Override // com.tencent.sqshow.zootopia.nativeui.view.action.BaseAvatarPanelTopOptView
    public void h(FrameLayout container) {
        Intrinsics.checkNotNullParameter(container, "container");
        this.mBinding = ah.f(LayoutInflater.from(getContext()), container);
        S();
    }

    public final void setSelectedData(AvatarPanelViewData data) {
        Intrinsics.checkNotNullParameter(data, "data");
        this.mCurrentPanelViewData = data;
        Y();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public MainPanelTopOptView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ MainPanelTopOptView(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MainPanelTopOptView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mCurrentPanelViewData = new AvatarPanelViewData(null, null, null, 0, false, null, 63, null);
        this.genderRedDotId = -1;
        this.dressTaskRunningStatusChangeObserver = new Observer() { // from class: com.tencent.sqshow.zootopia.nativeui.view.action.b
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                MainPanelTopOptView.B(MainPanelTopOptView.this, (Boolean) obj);
            }
        };
        this.mShowLoadingTask = new Runnable() { // from class: com.tencent.sqshow.zootopia.nativeui.view.action.d
            @Override // java.lang.Runnable
            public final void run() {
                MainPanelTopOptView.U(MainPanelTopOptView.this);
            }
        };
    }

    private final void K(final ah binding, final com.tencent.sqshow.zootopia.nativeui.data.j panelChannel) {
        MutableLiveData<AvatarPanelAllData> b16;
        binding.f418614c.g(1);
        com.tencent.sqshow.zootopia.nativeui.data.c cVar = com.tencent.sqshow.zootopia.nativeui.data.c.f370920a;
        UEAvatarGender n3 = cVar.n();
        X(binding, n3);
        LifecycleOwner lifecycleOwner = panelChannel.getLifecycleOwner();
        if (lifecycleOwner == null) {
            return;
        }
        LiveData<m94.a> a16 = cVar.m().a();
        final Function1<m94.a, Unit> function1 = new Function1<m94.a, Unit>() { // from class: com.tencent.sqshow.zootopia.nativeui.view.action.MainPanelTopOptView$initGenderView$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(m94.a aVar) {
                invoke2(aVar);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(m94.a aVar) {
                MainPanelTopOptView.this.X(binding, aVar.getGender());
                HashMap hashMap = new HashMap();
                hashMap.put("zplan_gender", Integer.valueOf(aVar.getGender().getIndex()));
                ZplanViewReportHelper mReporter = panelChannel.getReporter().getMReporter();
                RelativeLayout relativeLayout = binding.f418622k;
                Intrinsics.checkNotNullExpressionValue(relativeLayout, "binding.switchGenderRl");
                mReporter.g(relativeLayout, "em_zplan_gender_switch", (r16 & 4) != 0 ? null : hashMap, (r16 & 8) != 0, (r16 & 16) != 0 ? null : null, (r16 & 32) != 0 ? false : false);
            }
        };
        a16.observe(lifecycleOwner, new Observer() { // from class: com.tencent.sqshow.zootopia.nativeui.view.action.i
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                MainPanelTopOptView.L(Function1.this, obj);
            }
        });
        HashMap hashMap = new HashMap();
        hashMap.put("zplan_gender", Integer.valueOf(n3.getIndex()));
        ZplanViewReportHelper mReporter = panelChannel.getReporter().getMReporter();
        RelativeLayout relativeLayout = binding.f418622k;
        Intrinsics.checkNotNullExpressionValue(relativeLayout, "binding.switchGenderRl");
        mReporter.g(relativeLayout, "em_zplan_gender_switch", (r16 & 4) != 0 ? null : hashMap, (r16 & 8) != 0, (r16 & 16) != 0 ? null : null, (r16 & 32) != 0 ? false : false);
        RelativeLayout relativeLayout2 = binding.f418622k;
        Intrinsics.checkNotNullExpressionValue(relativeLayout2, "binding.switchGenderRl");
        com.tencent.sqshow.zootopia.utils.aa.d(relativeLayout2, new View.OnClickListener() { // from class: com.tencent.sqshow.zootopia.nativeui.view.action.j
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MainPanelTopOptView.M(MainPanelTopOptView.this, panelChannel, binding, view);
            }
        });
        com.tencent.sqshow.zootopia.nativeui.data.repo.i dataController = panelChannel.getDataController();
        if (dataController == null || (b16 = dataController.b()) == null) {
            return;
        }
        final Function1<AvatarPanelAllData, Unit> function12 = new Function1<AvatarPanelAllData, Unit>() { // from class: com.tencent.sqshow.zootopia.nativeui.view.action.MainPanelTopOptView$initGenderView$3
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(AvatarPanelAllData avatarPanelAllData) {
                invoke2(avatarPanelAllData);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(AvatarPanelAllData avatarPanelAllData) {
                Integer genderRedDotId = avatarPanelAllData.getGenderRedDotId();
                if (genderRedDotId != null) {
                    MainPanelTopOptView mainPanelTopOptView = MainPanelTopOptView.this;
                    ah ahVar = binding;
                    int intValue = genderRedDotId.intValue();
                    mainPanelTopOptView.genderRedDotId = intValue;
                    ahVar.f418614c.h(intValue);
                }
            }
        };
        b16.observe(lifecycleOwner, new Observer() { // from class: com.tencent.sqshow.zootopia.nativeui.view.action.k
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                MainPanelTopOptView.O(Function1.this, obj);
            }
        });
    }

    private final void V(boolean running) {
    }
}
