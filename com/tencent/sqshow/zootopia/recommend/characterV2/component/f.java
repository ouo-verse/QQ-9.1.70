package com.tencent.sqshow.zootopia.recommend.characterV2.component;

import android.content.res.Configuration;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.fragment.app.FragmentActivity;
import b94.e;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QBaseFragment;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import com.tencent.sqshow.zootopia.avatar.mall.AvatarMallViewInitData;
import com.tencent.sqshow.zootopia.avatar.mall.k;
import com.tencent.sqshow.zootopia.nativeui.data.AvatarNativeViewInitData;
import com.tencent.sqshow.zootopia.nativeui.data.CameraKey;
import com.tencent.sqshow.zootopia.nativeui.data.o;
import com.tencent.sqshow.zootopia.nativeui.view.panel.PortalStoreControllerView;
import com.tencent.sqshow.zootopia.recommend.characterV2.component.b;
import com.tencent.sqshow.zootopia.recommend.characterV2.controller.ZPlanRoleControllerV2;
import com.tencent.zplan.world.model.FirstFrameResult;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import uv4.w;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u008a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 \u00112\u00020\u00012\u00020\u0002:\u0001CB\u000f\u0012\u0006\u00107\u001a\u000204\u00a2\u0006\u0004\bA\u0010BJ,\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\n\u001a\u00020\tH\u0016J\u0010\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rH\u0016J\b\u0010\u0010\u001a\u00020\u000bH\u0016J\b\u0010\u0011\u001a\u00020\u000bH\u0016J\u0010\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u0012H\u0016J\b\u0010\u0015\u001a\u00020\u000bH\u0016J\u0010\u0010\u0018\u001a\u00020\u000b2\u0006\u0010\u0017\u001a\u00020\u0016H\u0016J\u0010\u0010\u001b\u001a\u00020\u000b2\u0006\u0010\u001a\u001a\u00020\u0019H\u0016J\u0010\u0010\u001c\u001a\u00020\u000b2\u0006\u0010\u001a\u001a\u00020\u0019H\u0016J \u0010!\u001a\u00020\u000b2\u0006\u0010\u001d\u001a\u00020\u00162\u000e\u0010 \u001a\n\u0012\u0004\u0012\u00020\u001f\u0018\u00010\u001eH\u0016J\u0018\u0010$\u001a\u00020\u000b2\u0006\u0010 \u001a\u00020\"2\u0006\u0010#\u001a\u00020\u0016H\u0016J\u0010\u0010&\u001a\u00020\u000b2\u0006\u0010\u001a\u001a\u00020%H\u0016J\n\u0010(\u001a\u0004\u0018\u00010'H\u0016J \u0010-\u001a\u00020\u000b2\u0006\u0010*\u001a\u00020)2\u0006\u0010+\u001a\u00020\u00162\u0006\u0010,\u001a\u00020\u0016H\u0016J\u0010\u00100\u001a\u00020\u000b2\u0006\u0010/\u001a\u00020.H\u0016J\b\u00101\u001a\u00020\u0016H\u0016J\b\u00102\u001a\u00020\u0016H\u0016J\b\u00103\u001a\u00020\u0016H\u0016R\u0014\u00107\u001a\u0002048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b5\u00106R\u0018\u0010;\u001a\u0004\u0018\u0001088\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b9\u0010:R\u0016\u0010>\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b<\u0010=R\u0018\u0010@\u001a\u0004\u0018\u00010%8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010?\u00a8\u0006D"}, d2 = {"Lcom/tencent/sqshow/zootopia/recommend/characterV2/component/f;", "Lwb4/a;", "Lcom/tencent/sqshow/zootopia/recommend/characterV2/component/b;", "Landroidx/fragment/app/FragmentActivity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Lcom/tencent/mobileqq/app/QBaseFragment;", "fragment", "Lod3/b;", "portal", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "", UserInfo.SEX_FEMALE, "Landroid/content/res/Configuration;", "newConfig", "P", tl.h.F, "G", "Lcom/tencent/sqshow/zootopia/avatar/mall/b;", "data", "N", "L", "", "withAnim", "u", "Lcom/tencent/sqshow/zootopia/nativeui/data/o;", "listener", "qg", ICustomDataEditor.STRING_PARAM_2, "clearDressHistory", "Lcom/tencent/mobileqq/zootopia/api/e;", "Luv4/w;", "callback", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Lm94/h;", "waitingUeCallback", "r1", "Lcom/tencent/sqshow/zootopia/avatar/mall/k;", "K", "Lcom/tencent/sqshow/zootopia/nativeui/data/m;", "getCameraId", "", "from", "withoutBlend", "withDelay", "Ya", "Lcom/tencent/sqshow/zootopia/scene/component/d;", "observer", "q0", "O", "j6", "M", "Lcom/tencent/sqshow/zootopia/recommend/characterV2/controller/ZPlanRoleControllerV2;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/sqshow/zootopia/recommend/characterV2/controller/ZPlanRoleControllerV2;", "roleControllerV2", "Lb94/e;", "D", "Lb94/e;", "nativePanelView", "E", "Z", "afterFirstFrame", "Lcom/tencent/sqshow/zootopia/avatar/mall/k;", "nativeUIListener", "<init>", "(Lcom/tencent/sqshow/zootopia/recommend/characterV2/controller/ZPlanRoleControllerV2;)V", "b", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class f extends wb4.a implements b {

    /* renamed from: C, reason: from kotlin metadata */
    private final ZPlanRoleControllerV2 roleControllerV2;

    /* renamed from: D, reason: from kotlin metadata */
    private b94.e nativePanelView;

    /* renamed from: E, reason: from kotlin metadata */
    private boolean afterFirstFrame;

    /* renamed from: F, reason: from kotlin metadata */
    private k nativeUIListener;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/sqshow/zootopia/recommend/characterV2/component/f$a", "Luk0/e;", "", "type", "eventData", "", "onEvent", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class a implements uk0.e {
        a() {
        }

        @Override // uk0.e
        public void onEvent(String type, String eventData) {
            Intrinsics.checkNotNullParameter(type, "type");
            Intrinsics.checkNotNullParameter(eventData, "eventData");
            if (Intrinsics.areEqual(type, "onFirstFrameRenderEnd")) {
                QLog.i("portal_ZPlanRoleMallComponent", 1, "onEvent " + type);
                f.this.afterFirstFrame = true;
                b94.e eVar = f.this.nativePanelView;
                if (eVar != null) {
                    eVar.onFirstFrame(new FirstFrameResult(1, null));
                }
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/sqshow/zootopia/recommend/characterV2/component/f$c", "Lb94/c;", "", "a", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class c implements b94.c {
        c() {
        }

        @Override // b94.c
        public boolean a() {
            if (f.this.nativePanelView != null) {
                b94.e eVar = f.this.nativePanelView;
                Intrinsics.checkNotNull(eVar);
                if (!eVar.getMMainPanelIsShow()) {
                    return false;
                }
            }
            b.a.a(f.this, false, 1, null);
            return true;
        }
    }

    public f(ZPlanRoleControllerV2 roleControllerV2) {
        Intrinsics.checkNotNullParameter(roleControllerV2, "roleControllerV2");
        this.roleControllerV2 = roleControllerV2;
        roleControllerV2.O0(new a());
    }

    @Override // wb4.a
    public void F(FragmentActivity activity, QBaseFragment fragment, od3.b portal, ViewGroup container) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(container, "container");
        QLog.i("portal_ZPlanRoleMallComponent", 1, "onBindView");
        PortalStoreControllerView portalStoreControllerView = new PortalStoreControllerView(activity, null, 0, 6, null);
        this.nativePanelView = portalStoreControllerView;
        if (this.afterFirstFrame) {
            portalStoreControllerView.onFirstFrame(new FirstFrameResult(1, null));
        }
        b94.e eVar = this.nativePanelView;
        Intrinsics.checkNotNull(eVar);
        container.addView(eVar.getView(), new FrameLayout.LayoutParams(-1, -1));
    }

    public void K(k listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.nativeUIListener = listener;
    }

    public void L() {
        b94.e eVar = this.nativePanelView;
        if (eVar != null) {
            e.a.a(eVar, true, null, null, 6, null);
        }
        k kVar = this.nativeUIListener;
        if (kVar != null) {
            kVar.ma();
        }
    }

    public boolean M() {
        b94.e eVar = this.nativePanelView;
        if (eVar != null) {
            return eVar.getMInitDataReady();
        }
        return false;
    }

    public boolean O() {
        b94.e eVar = this.nativePanelView;
        if (eVar != null) {
            return e.a.c(eVar, false, null, 3, null);
        }
        return false;
    }

    public void P(Configuration newConfig) {
        Intrinsics.checkNotNullParameter(newConfig, "newConfig");
        QLog.i("portal_ZPlanRoleMallComponent", 1, "onConfigurationChanged");
        b94.e eVar = this.nativePanelView;
        if (eVar != null) {
            eVar.onOrientationChanged(newConfig.orientation);
        }
    }

    public void Q(boolean clearDressHistory, com.tencent.mobileqq.zootopia.api.e<w> callback) {
        b94.e eVar = this.nativePanelView;
        if (eVar != null) {
            e.a.g(eVar, false, clearDressHistory, callback, 1, null);
        }
    }

    public void Ya(String from, boolean withoutBlend, boolean withDelay) {
        Intrinsics.checkNotNullParameter(from, "from");
        b94.e eVar = this.nativePanelView;
        if (eVar != null) {
            eVar.Ya(from, withoutBlend, withDelay);
        }
    }

    public CameraKey getCameraId() {
        b94.e eVar = this.nativePanelView;
        if (eVar != null) {
            return eVar.getCameraId();
        }
        return null;
    }

    @Override // wb4.a, od3.d
    public void h() {
        super.h();
        QLog.i("portal_ZPlanRoleMallComponent", 1, "onFragmentDestroy");
        b94.e eVar = this.nativePanelView;
        if (eVar != null) {
            eVar.destroy();
        }
        this.nativePanelView = null;
    }

    public boolean j6() {
        b94.e eVar = this.nativePanelView;
        if (eVar != null) {
            return eVar.getMMainPanelIsShow();
        }
        return false;
    }

    public void q0(com.tencent.sqshow.zootopia.scene.component.d observer) {
        Intrinsics.checkNotNullParameter(observer, "observer");
        b94.e eVar = this.nativePanelView;
        if (eVar != null) {
            eVar.q0(observer);
        }
    }

    public void qg(o listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        b94.e eVar = this.nativePanelView;
        if (eVar != null) {
            eVar.qg(listener);
        }
    }

    @Override // com.tencent.sqshow.zootopia.recommend.characterV2.component.b
    public void r1(m94.h callback, boolean waitingUeCallback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        b94.e eVar = this.nativePanelView;
        if (eVar != null) {
            eVar.r1(callback, waitingUeCallback);
        }
    }

    public void s2(o listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        b94.e eVar = this.nativePanelView;
        if (eVar != null) {
            eVar.s2(listener);
        }
    }

    @Override // com.tencent.sqshow.zootopia.recommend.characterV2.component.b
    public void u(boolean withAnim) {
        b94.e eVar = this.nativePanelView;
        if (eVar != null) {
            e.a.b(eVar, withAnim, null, null, 6, null);
        }
        k kVar = this.nativeUIListener;
        if (kVar != null) {
            kVar.I7();
        }
    }

    @Override // wb4.a
    public void G() {
        QLog.i("portal_ZPlanRoleMallComponent", 1, MosaicConstants$JsFunction.FUNC_ON_DESTROY);
        b94.e eVar = this.nativePanelView;
        if (eVar != null) {
            eVar.destroy();
        }
        this.nativePanelView = null;
    }

    public void N(AvatarMallViewInitData data) {
        Intrinsics.checkNotNullParameter(data, "data");
        QLog.i("portal_ZPlanRoleMallComponent", 1, "initData");
        AvatarNativeViewInitData avatarNativeViewInitData = new AvatarNativeViewInitData(data.getContext(), data.getContext(), null, null, 0, null, null, null, false, 0, null, false, null, null, null, null, null, null, null, 524284, null);
        avatarNativeViewInitData.t(new c());
        avatarNativeViewInitData.A(1);
        avatarNativeViewInitData.C(data.getCurrentSource());
        b94.a d06 = this.roleControllerV2.d0();
        if (d06 != null) {
            avatarNativeViewInitData.v(d06);
        }
        avatarNativeViewInitData.x(this.roleControllerV2.c0());
        b94.e eVar = this.nativePanelView;
        if (eVar != null) {
            eVar.Cf(avatarNativeViewInitData);
        }
    }
}
