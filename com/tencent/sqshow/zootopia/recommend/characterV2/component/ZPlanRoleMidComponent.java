package com.tencent.sqshow.zootopia.recommend.characterV2.component;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.FrameLayout;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.FragmentActivity;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QBaseFragment;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mobileqq.zplan.scheme.ISchemeApi;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.plugins.UIJsPlugin;
import com.tencent.sqshow.zootopia.avatar.loading.view.ZPlanPageDataErrorHintView;
import com.tencent.sqshow.zootopia.card.view.floatbanner.ZPlanFloatBannerView;
import com.tencent.sqshow.zootopia.guide.q;
import com.tencent.sqshow.zootopia.nativeui.data.o;
import com.tencent.sqshow.zootopia.recommend.characterV2.controller.ZPlanRoleControllerV2;
import com.tencent.sqshow.zootopia.recommend.characterV2.data.ZPlanRoleData;
import com.tencent.sqshow.zootopia.recommend.characterV2.view.ZPlanRolePendantContainer;
import com.tencent.sqshow.zootopia.scene.component.PageDataType;
import com.tencent.sqshow.zootopia.utils.CommonExKt;
import com.tencent.sqshow.zootopia.utils.aa;
import com.tencent.sqshow.zootopia.utils.i;
import com.tencent.sqshow.zootopia.widget.bubble.ZPlanBubbleView;
import com.tencent.zplan.world.model.FirstFrameResult;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import n74.bm;
import pv4.s;
import qv4.bi;
import uv4.u;
import uv4.w;

@Metadata(d1 = {"\u0000\u00b4\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\"\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 \r2\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0001hB\u000f\u0012\u0006\u0010B\u001a\u00020?\u00a2\u0006\u0004\bf\u0010gJ\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005H\u0002J\u0010\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u0005H\u0002J\b\u0010\r\u001a\u00020\bH\u0002J \u0010\u0011\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u000b2\u000e\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u000fH\u0002J \u0010\u0012\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u000b2\u000e\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u000fH\u0002J\u0010\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u0013H\u0002J\u0010\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\u000bH\u0002J,\u0010 \u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\u00182\b\u0010\u001b\u001a\u0004\u0018\u00010\u001a2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u001f\u001a\u00020\u001eH\u0016J\b\u0010!\u001a\u00020\bH\u0016J\b\u0010\"\u001a\u00020\bH\u0016J\b\u0010#\u001a\u00020\bH\u0016J\b\u0010$\u001a\u00020\bH\u0016J\b\u0010%\u001a\u00020\bH\u0016J\b\u0010&\u001a\u00020\bH\u0016J\u000e\u0010)\u001a\b\u0012\u0004\u0012\u00020(0'H\u0016J \u0010*\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u000b2\u000e\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u000fH\u0016J \u0010+\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u000b2\u000e\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u000fH\u0016J\u0010\u0010.\u001a\u00020\b2\u0006\u0010-\u001a\u00020,H\u0016J$\u00102\u001a\u00020\b2\b\u00100\u001a\u0004\u0018\u00010/2\b\u00101\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0007\u001a\u00020\u0005H\u0016J\b\u00103\u001a\u00020\bH\u0016J\u0018\u00107\u001a\u00020\b2\u0006\u00105\u001a\u0002042\u0006\u00106\u001a\u00020\u000bH\u0016J\u001a\u0010:\u001a\u00020\b2\u0006\u00108\u001a\u00020(2\b\u00109\u001a\u0004\u0018\u00010\u0005H\u0016J\b\u0010;\u001a\u00020\bH\u0016J\u0010\u0010>\u001a\u00020\u000b2\u0006\u0010=\u001a\u00020<H\u0016R\u0014\u0010B\u001a\u00020?8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b@\u0010AR\u0018\u0010F\u001a\u0004\u0018\u00010C8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bD\u0010ER\u0018\u0010I\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bG\u0010HR\u0014\u0010K\u001a\u00020J8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b \u0010 R\u0018\u0010N\u001a\u0004\u0018\u00010L8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b&\u0010MR&\u0010R\u001a\u0012\u0012\u0004\u0012\u00020(0Oj\b\u0012\u0004\u0012\u00020(`P8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010QR\u0016\u0010T\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bS\u00102R\u0016\u0010V\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bU\u00102R\u0016\u0010X\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bW\u00102R&\u0010Z\u001a\u0012\u0012\u0004\u0012\u00020<0Oj\b\u0012\u0004\u0012\u00020<`P8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bY\u0010QR\u0016\u0010\\\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b[\u00102R\u0016\u0010^\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b]\u00102R\u0018\u0010b\u001a\u0004\u0018\u00010_8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b`\u0010aR\u0018\u0010e\u001a\u0004\u0018\u0001048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bc\u0010d\u00a8\u0006i"}, d2 = {"Lcom/tencent/sqshow/zootopia/recommend/characterV2/component/ZPlanRoleMidComponent;", "Lwb4/a;", "Lcom/tencent/sqshow/zootopia/recommend/characterV2/component/c;", "Lcom/tencent/sqshow/zootopia/scene/component/d;", "Lcom/tencent/sqshow/zootopia/nativeui/data/o;", "", "type", "sourceId", "", "c0", "from", "", "W", BdhLogUtil.LogTag.Tag_Req, "withAnim", "Lkotlin/Function0;", "callback", "T", ExifInterface.LATITUDE_SOUTH, "Landroid/animation/AnimatorSet;", "animatorSet", "d0", "isSingle", "e0", "Landroidx/fragment/app/FragmentActivity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Lcom/tencent/mobileqq/app/QBaseFragment;", "fragment", "Lod3/b;", "portal", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, UserInfo.SEX_FEMALE, "y", "r", "i", "H", tl.h.F, "G", "", "", "V", "g", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Lcom/tencent/sqshow/zootopia/recommend/characterV2/data/d;", "roleData", "b0", "Lqv4/bi;", "info", "bubbleText", "Z", "Y", "Luv4/w;", "rsp", "hasCacheData", "B", "errorCode", "errorMsg", "onFailed", "U", "Lcom/tencent/sqshow/zootopia/scene/component/c;", "originHandler", ReportConstant.COSTREPORT_PREFIX, "Lcom/tencent/sqshow/zootopia/recommend/characterV2/controller/ZPlanRoleControllerV2;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/sqshow/zootopia/recommend/characterV2/controller/ZPlanRoleControllerV2;", "roleControllerV2", "Ln74/bm;", "D", "Ln74/bm;", "midBinding", "E", "Landroid/animation/AnimatorSet;", "currentAnim", "", "hideMoveLength", "Lcom/tencent/sqshow/zootopia/recommend/characterV2/controller/a;", "Lcom/tencent/sqshow/zootopia/recommend/characterV2/controller/a;", "bubbleOwner", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "Ljava/util/HashSet;", "bubbleIndexList", "I", "afterRenderComplete", "J", "afterFirstFrame", "K", "isLoading", "L", "pageDataErrorHandler", "M", "roleDataFailed", "N", "nativeUIReqFailed", "Luv4/u;", "P", "Luv4/u;", "nativeUIRsp", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Luv4/w;", "nativeUIV1Rsp", "<init>", "(Lcom/tencent/sqshow/zootopia/recommend/characterV2/controller/ZPlanRoleControllerV2;)V", "d", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class ZPlanRoleMidComponent extends wb4.a implements com.tencent.sqshow.zootopia.recommend.characterV2.component.c, com.tencent.sqshow.zootopia.scene.component.d, o {

    /* renamed from: C, reason: from kotlin metadata */
    private final ZPlanRoleControllerV2 roleControllerV2;

    /* renamed from: D, reason: from kotlin metadata */
    private bm midBinding;

    /* renamed from: E, reason: from kotlin metadata */
    private AnimatorSet currentAnim;

    /* renamed from: F, reason: from kotlin metadata */
    private final float hideMoveLength;

    /* renamed from: G, reason: from kotlin metadata */
    private com.tencent.sqshow.zootopia.recommend.characterV2.controller.a bubbleOwner;

    /* renamed from: H, reason: from kotlin metadata */
    private HashSet<Integer> bubbleIndexList;

    /* renamed from: I, reason: from kotlin metadata */
    private boolean afterRenderComplete;

    /* renamed from: J, reason: from kotlin metadata */
    private boolean afterFirstFrame;

    /* renamed from: K, reason: from kotlin metadata */
    private boolean isLoading;

    /* renamed from: L, reason: from kotlin metadata */
    private HashSet<com.tencent.sqshow.zootopia.scene.component.c> pageDataErrorHandler;

    /* renamed from: M, reason: from kotlin metadata */
    private boolean roleDataFailed;

    /* renamed from: N, reason: from kotlin metadata */
    private boolean nativeUIReqFailed;

    /* renamed from: P, reason: from kotlin metadata */
    private u nativeUIRsp;

    /* renamed from: Q, reason: from kotlin metadata */
    private w nativeUIV1Rsp;

    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/sqshow/zootopia/recommend/characterV2/component/ZPlanRoleMidComponent$a", "Luk0/e;", "", "type", "eventData", "", "onEvent", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class a implements uk0.e {
        a() {
        }

        @Override // uk0.e
        public void onEvent(String type, String eventData) {
            ZPlanRolePendantContainer zPlanRolePendantContainer;
            Intrinsics.checkNotNullParameter(type, "type");
            Intrinsics.checkNotNullParameter(eventData, "eventData");
            if (Intrinsics.areEqual(type, "onFirstFrameRenderEnd")) {
                QLog.i("portal_ZPlanRoleMidComponent", 1, "onEvent " + type);
                ZPlanRoleMidComponent.this.afterFirstFrame = true;
                bm bmVar = ZPlanRoleMidComponent.this.midBinding;
                if (bmVar == null || (zPlanRolePendantContainer = bmVar.f418861f) == null) {
                    return;
                }
                zPlanRolePendantContainer.onFirstFrame(new FirstFrameResult(1, null));
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/sqshow/zootopia/recommend/characterV2/component/ZPlanRoleMidComponent$b", "Lcom/tencent/sqshow/zootopia/avatar/filament/h;", "", "d", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class b implements com.tencent.sqshow.zootopia.avatar.filament.h {
        b() {
        }

        @Override // com.tencent.sqshow.zootopia.avatar.filament.h
        public void d() {
            ZPlanRolePendantContainer zPlanRolePendantContainer;
            QLog.i("portal_ZPlanRoleMidComponent", 1, "onRenderComplete");
            ZPlanRoleMidComponent.this.afterRenderComplete = true;
            ZPlanRoleMidComponent.this.roleControllerV2.qg(ZPlanRoleMidComponent.this);
            bm bmVar = ZPlanRoleMidComponent.this.midBinding;
            if (bmVar == null || (zPlanRolePendantContainer = bmVar.f418861f) == null) {
                return;
            }
            zPlanRolePendantContainer.k();
        }
    }

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\u0005"}, d2 = {"com/tencent/sqshow/zootopia/recommend/characterV2/component/ZPlanRoleMidComponent$c", "Lya4/a;", "", "w0", "U", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class c implements ya4.a {
        c() {
        }

        @Override // ya4.a
        public void w0() {
            QLog.i("portal_ZPlanRoleMidComponent", 1, "onLoadingShow");
            ZPlanRoleMidComponent.this.isLoading = true;
            ZPlanRoleMidComponent.this.W(UIJsPlugin.EVENT_SHOW_LOADING);
        }

        @Override // ya4.a
        public void U() {
            QLog.i("portal_ZPlanRoleMidComponent", 1, "onLoadingHide");
            ZPlanRoleMidComponent.this.isLoading = false;
            ZPlanRoleMidComponent.this.W(UIJsPlugin.EVENT_HIDE_LOADING);
        }
    }

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes34.dex */
    public /* synthetic */ class e {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f372421a;

        static {
            int[] iArr = new int[PageDataType.values().length];
            try {
                iArr[PageDataType.ROLE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[PageDataType.AVATAR_MALL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f372421a = iArr;
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/sqshow/zootopia/recommend/characterV2/component/ZPlanRoleMidComponent$f", "Loc4/a;", "Landroid/animation/Animator;", "animation", "", "onAnimationEnd", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class f extends oc4.a {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Function0<Unit> f372422d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ ZPlanRoleMidComponent f372423e;

        f(Function0<Unit> function0, ZPlanRoleMidComponent zPlanRoleMidComponent) {
            this.f372422d = function0;
            this.f372423e = zPlanRoleMidComponent;
        }

        @Override // com.tencent.mobileqq.widget.f, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animation) {
            Function0<Unit> function0 = this.f372422d;
            if (function0 != null) {
                function0.invoke();
            }
            bm bmVar = this.f372423e.midBinding;
            FrameLayout root = bmVar != null ? bmVar.getRoot() : null;
            if (root == null) {
                return;
            }
            root.setVisibility(8);
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/sqshow/zootopia/recommend/characterV2/component/ZPlanRoleMidComponent$g", "Loc4/a;", "Landroid/animation/Animator;", "animation", "", "onAnimationEnd", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class g extends oc4.a {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Function0<Unit> f372424d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ ZPlanRoleMidComponent f372425e;

        g(Function0<Unit> function0, ZPlanRoleMidComponent zPlanRoleMidComponent) {
            this.f372424d = function0;
            this.f372425e = zPlanRoleMidComponent;
        }

        @Override // com.tencent.mobileqq.widget.f, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animation) {
            Function0<Unit> function0 = this.f372424d;
            if (function0 != null) {
                function0.invoke();
            }
            bm bmVar = this.f372425e.midBinding;
            FrameLayout root = bmVar != null ? bmVar.getRoot() : null;
            if (root == null) {
                return;
            }
            root.setVisibility(0);
        }
    }

    public ZPlanRoleMidComponent(ZPlanRoleControllerV2 roleControllerV2) {
        Intrinsics.checkNotNullParameter(roleControllerV2, "roleControllerV2");
        this.roleControllerV2 = roleControllerV2;
        this.hideMoveLength = i.e(80);
        this.bubbleIndexList = new HashSet<>();
        this.pageDataErrorHandler = new HashSet<>();
        roleControllerV2.O0(new a());
        roleControllerV2.Q0(new b());
        roleControllerV2.P0(new c());
    }

    private final void R() {
        FrameLayout root;
        bm bmVar = this.midBinding;
        if (bmVar == null || (root = bmVar.getRoot()) == null) {
            return;
        }
        aa.h(root, new Function1<FrameLayout.LayoutParams, Unit>() { // from class: com.tencent.sqshow.zootopia.recommend.characterV2.component.ZPlanRoleMidComponent$adjustBottomMargin$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(FrameLayout.LayoutParams layoutParams) {
                invoke2(layoutParams);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(FrameLayout.LayoutParams updateLayoutParams) {
                int b16;
                FrameLayout root2;
                Context context;
                Resources resources;
                Intrinsics.checkNotNullParameter(updateLayoutParams, "$this$updateLayoutParams");
                if (com.tencent.sqshow.zootopia.recommend.main.tab.b.f372639a.d().size() > 1) {
                    bm bmVar2 = ZPlanRoleMidComponent.this.midBinding;
                    b16 = (bmVar2 == null || (root2 = bmVar2.getRoot()) == null || (context = root2.getContext()) == null || (resources = context.getResources()) == null) ? 0 : (int) resources.getDimension(R.dimen.f122670);
                } else {
                    b16 = i.b(35);
                }
                updateLayoutParams.bottomMargin = b16;
                QLog.i("portal_ZPlanRoleMidComponent", 1, "adjustLoadingBottomMargin bottomMargin:" + b16);
            }
        });
    }

    private final void S(boolean withAnim, Function0<Unit> callback) {
        long j3;
        FrameLayout root;
        bm bmVar = this.midBinding;
        float translationY = (bmVar == null || (root = bmVar.getRoot()) == null) ? 0.0f : root.getTranslationY();
        QLog.i("portal_ZPlanRoleMidComponent", 1, "doHideTask currentTranY:" + translationY);
        AnimatorSet animatorSet = new AnimatorSet();
        bm bmVar2 = this.midBinding;
        animatorSet.play(ObjectAnimator.ofFloat(bmVar2 != null ? bmVar2.getRoot() : null, "translationY", translationY, this.hideMoveLength));
        if (withAnim) {
            float f16 = this.hideMoveLength;
            j3 = (150 * (f16 - translationY)) / f16;
        } else {
            j3 = 0;
        }
        animatorSet.setDuration(j3);
        animatorSet.addListener(new f(callback, this));
        animatorSet.setInterpolator(new AccelerateDecelerateInterpolator());
        animatorSet.start();
        d0(animatorSet);
    }

    private final void T(boolean withAnim, Function0<Unit> callback) {
        FrameLayout root;
        bm bmVar = this.midBinding;
        FrameLayout root2 = bmVar != null ? bmVar.getRoot() : null;
        if (root2 != null) {
            root2.setVisibility(0);
        }
        bm bmVar2 = this.midBinding;
        float translationY = (bmVar2 == null || (root = bmVar2.getRoot()) == null) ? 0.0f : root.getTranslationY();
        QLog.i("portal_ZPlanRoleMidComponent", 1, "doShowTask currentTranY:" + translationY);
        AnimatorSet animatorSet = new AnimatorSet();
        bm bmVar3 = this.midBinding;
        animatorSet.play(ObjectAnimator.ofFloat(bmVar3 != null ? bmVar3.getRoot() : null, "translationY", translationY, 0.0f));
        animatorSet.setDuration(withAnim ? (150 * translationY) / this.hideMoveLength : 0L);
        animatorSet.addListener(new g(callback, this));
        animatorSet.setInterpolator(new AccelerateDecelerateInterpolator());
        animatorSet.start();
        d0(animatorSet);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean W(String from) {
        ZPlanPageDataErrorHintView zPlanPageDataErrorHintView;
        ZPlanPageDataErrorHintView zPlanPageDataErrorHintView2;
        boolean isLoading = this.roleControllerV2.getIsLoading();
        boolean z16 = this.nativeUIReqFailed && this.nativeUIRsp == null && this.nativeUIV1Rsp == null;
        boolean z17 = this.roleDataFailed;
        QLog.i("portal_ZPlanRoleMidComponent", 1, "from:" + from + ", rolePageDataError:" + z17 + ", nativeUIPageDataError:" + z16 + ", loadingShowing:" + isLoading);
        if (!isLoading && (z16 || z17)) {
            bm bmVar = this.midBinding;
            FrameLayout frameLayout = bmVar != null ? bmVar.f418860e : null;
            if (frameLayout != null) {
                frameLayout.setVisibility(0);
            }
            bm bmVar2 = this.midBinding;
            zPlanPageDataErrorHintView = bmVar2 != null ? bmVar2.f418859d : null;
            if (zPlanPageDataErrorHintView != null) {
                zPlanPageDataErrorHintView.setVisibility(0);
            }
            bm bmVar3 = this.midBinding;
            if (bmVar3 == null || (zPlanPageDataErrorHintView2 = bmVar3.f418859d) == null) {
                return true;
            }
            aa.d(zPlanPageDataErrorHintView2, new View.OnClickListener() { // from class: com.tencent.sqshow.zootopia.recommend.characterV2.component.g
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ZPlanRoleMidComponent.X(ZPlanRoleMidComponent.this, view);
                }
            });
            return true;
        }
        bm bmVar4 = this.midBinding;
        FrameLayout frameLayout2 = bmVar4 != null ? bmVar4.f418860e : null;
        if (frameLayout2 != null) {
            frameLayout2.setVisibility(8);
        }
        bm bmVar5 = this.midBinding;
        zPlanPageDataErrorHintView = bmVar5 != null ? bmVar5.f418859d : null;
        if (zPlanPageDataErrorHintView != null) {
            zPlanPageDataErrorHintView.setVisibility(8);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void X(ZPlanRoleMidComponent this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.U();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a0(bi biVar, ZPlanRoleMidComponent this$0, String sourceId, View view) {
        ZPlanBubbleView zPlanBubbleView;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(sourceId, "$sourceId");
        Bundle bundle = new Bundle();
        bundle.putString("key_refer_external_entrance", sourceId + "_bubble");
        bundle.putBoolean("key_stay_in_page_when_has_registered", true);
        xb4.b bVar = xb4.b.f447772a;
        String str = biVar.f430066a;
        Intrinsics.checkNotNullExpressionValue(str, "info.jumpUrl");
        String d16 = bVar.d(str, bundle);
        ISchemeApi iSchemeApi = (ISchemeApi) QRoute.api(ISchemeApi.class);
        Context context = view.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "it.context");
        iSchemeApi.launchScheme(context, d16);
        bm bmVar = this$0.midBinding;
        if (bmVar != null && (zPlanBubbleView = bmVar.f418857b) != null) {
            zPlanBubbleView.c();
        }
        bm bmVar2 = this$0.midBinding;
        ZPlanBubbleView zPlanBubbleView2 = bmVar2 != null ? bmVar2.f418857b : null;
        if (zPlanBubbleView2 != null) {
            zPlanBubbleView2.setVisibility(8);
        }
        q.f370741a.l();
        this$0.c0("click", sourceId);
    }

    private final void c0(String type, String sourceId) {
        Map<String, Object> mutableMapOf;
        id3.d dVar = new id3.d(null, 1, null);
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("zplan_action_type", type), TuplesKt.to("zplan_portal_external_entrance", "1"), TuplesKt.to("zplan_refer_external_entrance", sourceId));
        dVar.d("ev_zplan_create_bubble", mutableMapOf);
    }

    private final void d0(AnimatorSet animatorSet) {
        AnimatorSet animatorSet2 = this.currentAnim;
        if (animatorSet2 != null) {
            animatorSet2.cancel();
        }
        this.currentAnim = animatorSet;
    }

    private final void e0(boolean isSingle) {
        bm bmVar = this.midBinding;
        if (bmVar == null) {
            return;
        }
        Intrinsics.checkNotNull(bmVar);
        ViewGroup.LayoutParams layoutParams = bmVar.f418858c.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
        if (isSingle) {
            layoutParams2.bottomMargin = i.b(18);
        } else {
            layoutParams2.bottomMargin = i.b(13);
        }
    }

    @Override // com.tencent.sqshow.zootopia.recommend.characterV2.component.c
    public void A(boolean withAnim, Function0<Unit> callback) {
        ZPlanFloatBannerView zPlanFloatBannerView;
        S(withAnim, callback);
        bm bmVar = this.midBinding;
        if (bmVar == null || (zPlanFloatBannerView = bmVar.f418858c) == null) {
            return;
        }
        zPlanFloatBannerView.t();
    }

    @Override // com.tencent.sqshow.zootopia.nativeui.data.o
    public void B(final w rsp, final boolean hasCacheData) {
        Intrinsics.checkNotNullParameter(rsp, "rsp");
        QLog.i("portal_ZPlanRoleMidComponent", 1, "onSucceed, midBinding:" + this.midBinding);
        this.nativeUIV1Rsp = rsp;
        this.nativeUIReqFailed = false;
        CommonExKt.j(new Function0<Unit>() { // from class: com.tencent.sqshow.zootopia.recommend.characterV2.component.ZPlanRoleMidComponent$onSucceed$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                ZPlanRolePendantContainer zPlanRolePendantContainer;
                bm bmVar = ZPlanRoleMidComponent.this.midBinding;
                if (bmVar != null && (zPlanRolePendantContainer = bmVar.f418861f) != null) {
                    zPlanRolePendantContainer.B(rsp, hasCacheData);
                }
                ZPlanRoleMidComponent.this.W("onSucceed");
            }
        });
    }

    @Override // wb4.a
    public void F(FragmentActivity activity, QBaseFragment fragment, od3.b portal, ViewGroup container) {
        FrameLayout root;
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(container, "container");
        QLog.i("portal_ZPlanRoleMidComponent", 1, "onBindView");
        bm g16 = bm.g(LayoutInflater.from(activity));
        this.midBinding = g16;
        ViewGroup.LayoutParams layoutParams = (g16 == null || (root = g16.getRoot()) == null) ? null : root.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new ViewGroup.LayoutParams(-1, -1);
        }
        bm bmVar = this.midBinding;
        container.addView(bmVar != null ? bmVar.getRoot() : null, layoutParams);
        R();
    }

    @Override // wb4.a
    public void H() {
        ZPlanRolePendantContainer zPlanRolePendantContainer;
        super.H();
        QLog.i("portal_ZPlanRoleMidComponent", 1, "onFragmentPreDestroy");
        bm bmVar = this.midBinding;
        if (bmVar == null || (zPlanRolePendantContainer = bmVar.f418861f) == null) {
            return;
        }
        zPlanRolePendantContainer.j();
    }

    public Set<Integer> V() {
        return this.bubbleIndexList;
    }

    public void Z(final bi info, String bubbleText, final String sourceId) {
        ZPlanBubbleView zPlanBubbleView;
        ZPlanBubbleView zPlanBubbleView2;
        ZPlanBubbleView zPlanBubbleView3;
        ZPlanBubbleView zPlanBubbleView4;
        Intrinsics.checkNotNullParameter(sourceId, "sourceId");
        QLog.i("portal_ZPlanRoleMidComponent", 1, "refreshCreateRoleBubble, info=" + info + ", bubbleText=" + bubbleText);
        if ((info != null ? info.f430067b : null) != null) {
            String str = info.f430066a;
            if (!(str == null || str.length() == 0)) {
                if (!(bubbleText == null || bubbleText.length() == 0)) {
                    if (!q.f370741a.m()) {
                        QLog.w("portal_ZPlanRoleMidComponent", 1, "refreshCreateRoleBubble warning, has been shown");
                        return;
                    }
                    bm bmVar = this.midBinding;
                    if ((bmVar == null || (zPlanBubbleView4 = bmVar.f418857b) == null || !zPlanBubbleView4.a()) ? false : true) {
                        QLog.i("portal_ZPlanRoleMidComponent", 1, "refreshCreateRoleBubble inited");
                        return;
                    }
                    bm bmVar2 = this.midBinding;
                    if (bmVar2 != null && (zPlanBubbleView3 = bmVar2.f418857b) != null) {
                        pu4.g gVar = info.f430067b;
                        Intrinsics.checkNotNullExpressionValue(gVar, "info.material");
                        zPlanBubbleView3.b(gVar, bubbleText);
                    }
                    bm bmVar3 = this.midBinding;
                    if (bmVar3 != null && (zPlanBubbleView2 = bmVar3.f418857b) != null) {
                        Intrinsics.checkNotNull(bmVar3);
                        zPlanBubbleView2.setDefaultIconDrawable(bmVar3.getRoot().getResources().getDrawable(R.drawable.ifa));
                    }
                    bm bmVar4 = this.midBinding;
                    ZPlanBubbleView zPlanBubbleView5 = bmVar4 != null ? bmVar4.f418857b : null;
                    if (zPlanBubbleView5 != null) {
                        zPlanBubbleView5.setVisibility(0);
                    }
                    bm bmVar5 = this.midBinding;
                    if (bmVar5 != null && (zPlanBubbleView = bmVar5.f418857b) != null) {
                        aa.d(zPlanBubbleView, new View.OnClickListener() { // from class: com.tencent.sqshow.zootopia.recommend.characterV2.component.h
                            @Override // android.view.View.OnClickListener
                            public final void onClick(View view) {
                                ZPlanRoleMidComponent.a0(bi.this, this, sourceId, view);
                            }
                        });
                    }
                    c0("imp", sourceId);
                    return;
                }
            }
        }
        QLog.w("portal_ZPlanRoleMidComponent", 1, "refreshCreateRoleBubble warning, no data");
    }

    public void b0(ZPlanRoleData roleData) {
        ZPlanFloatBannerView zPlanFloatBannerView;
        ZPlanFloatBannerView zPlanFloatBannerView2;
        ZPlanRolePendantContainer zPlanRolePendantContainer;
        ZPlanRolePendantContainer zPlanRolePendantContainer2;
        Intrinsics.checkNotNullParameter(roleData, "roleData");
        this.bubbleIndexList.clear();
        Iterator<T> it = roleData.c().iterator();
        while (it.hasNext()) {
            this.bubbleIndexList.add(Integer.valueOf(((s) it.next()).f427693n));
        }
        bm bmVar = this.midBinding;
        if (bmVar != null && (zPlanRolePendantContainer2 = bmVar.f418861f) != null) {
            zPlanRolePendantContainer2.setRoleBubbleOwner(this.bubbleOwner);
        }
        bm bmVar2 = this.midBinding;
        if (bmVar2 != null && (zPlanRolePendantContainer = bmVar2.f418861f) != null) {
            zPlanRolePendantContainer.o(roleData.c());
        }
        if (Intrinsics.areEqual(roleData.getFrom(), "network")) {
            if (roleData.getFloatBannerData().d()) {
                bm bmVar3 = this.midBinding;
                zPlanFloatBannerView = bmVar3 != null ? bmVar3.f418858c : null;
                if (zPlanFloatBannerView != null) {
                    zPlanFloatBannerView.setVisibility(0);
                }
                e0(roleData.getFloatBannerData().b().size() == 1);
                bm bmVar4 = this.midBinding;
                if (bmVar4 == null || (zPlanFloatBannerView2 = bmVar4.f418858c) == null) {
                    return;
                }
                zPlanFloatBannerView2.setData(roleData.getFloatBannerData());
                return;
            }
            bm bmVar5 = this.midBinding;
            zPlanFloatBannerView = bmVar5 != null ? bmVar5.f418858c : null;
            if (zPlanFloatBannerView == null) {
                return;
            }
            zPlanFloatBannerView.setVisibility(8);
        }
    }

    @Override // com.tencent.sqshow.zootopia.recommend.characterV2.component.c
    public void g(boolean withAnim, Function0<Unit> callback) {
        bm bmVar;
        ZPlanFloatBannerView zPlanFloatBannerView;
        T(withAnim, callback);
        if (!this.afterFirstFrame || (bmVar = this.midBinding) == null || (zPlanFloatBannerView = bmVar.f418858c) == null) {
            return;
        }
        zPlanFloatBannerView.s();
    }

    @Override // wb4.a, od3.d
    public void h() {
        ZPlanRolePendantContainer zPlanRolePendantContainer;
        super.h();
        QLog.i("portal_ZPlanRoleMidComponent", 1, "onFragmentDestroy");
        bm bmVar = this.midBinding;
        if (bmVar != null && (zPlanRolePendantContainer = bmVar.f418861f) != null) {
            zPlanRolePendantContainer.h();
        }
        this.roleControllerV2.s2(this);
    }

    @Override // wb4.a, od3.d
    public void i() {
        ZPlanRolePendantContainer zPlanRolePendantContainer;
        super.i();
        bm bmVar = this.midBinding;
        if (bmVar == null || (zPlanRolePendantContainer = bmVar.f418861f) == null) {
            return;
        }
        zPlanRolePendantContainer.n();
    }

    @Override // com.tencent.sqshow.zootopia.nativeui.data.o
    public void onFailed(final int errorCode, final String errorMsg) {
        QLog.i("portal_ZPlanRoleMidComponent", 1, "onFailed");
        this.nativeUIReqFailed = true;
        CommonExKt.j(new Function0<Unit>() { // from class: com.tencent.sqshow.zootopia.recommend.characterV2.component.ZPlanRoleMidComponent$onFailed$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                ZPlanRolePendantContainer zPlanRolePendantContainer;
                bm bmVar = ZPlanRoleMidComponent.this.midBinding;
                if (bmVar != null && (zPlanRolePendantContainer = bmVar.f418861f) != null) {
                    zPlanRolePendantContainer.onFailed(errorCode, errorMsg);
                }
                ZPlanRoleMidComponent.this.W("onFailed");
            }
        });
    }

    @Override // wb4.a, od3.d
    public void r() {
        ZPlanFloatBannerView zPlanFloatBannerView;
        super.r();
        QLog.i("portal_ZPlanRoleMidComponent", 1, "onFragmentPause");
        bm bmVar = this.midBinding;
        if (bmVar == null || (zPlanFloatBannerView = bmVar.f418858c) == null) {
            return;
        }
        zPlanFloatBannerView.t();
    }

    @Override // com.tencent.sqshow.zootopia.scene.component.d
    public boolean s(com.tencent.sqshow.zootopia.scene.component.c originHandler) {
        Intrinsics.checkNotNullParameter(originHandler, "originHandler");
        int i3 = e.f372421a[originHandler.getType().ordinal()];
        if (i3 == 1) {
            this.roleDataFailed = true;
        } else if (i3 == 2) {
            this.nativeUIReqFailed = true;
        }
        this.pageDataErrorHandler.add(originHandler);
        return W("onPageDataError-" + originHandler.getType());
    }

    @Override // wb4.a, od3.d
    public void y() {
        ZPlanRolePendantContainer zPlanRolePendantContainer;
        ZPlanRolePendantContainer zPlanRolePendantContainer2;
        ZPlanFloatBannerView zPlanFloatBannerView;
        ZPlanRolePendantContainer zPlanRolePendantContainer3;
        ZPlanRolePendantContainer zPlanRolePendantContainer4;
        super.y();
        QLog.i("portal_ZPlanRoleMidComponent", 1, "onFragmentResume, afterRenderComplete: " + this.afterRenderComplete + ", afterFirstFrame: " + this.afterFirstFrame);
        this.roleControllerV2.q0(this);
        bm bmVar = this.midBinding;
        if (bmVar != null && (zPlanRolePendantContainer4 = bmVar.f418861f) != null) {
            zPlanRolePendantContainer4.setAvatarComponentInterface(this.roleControllerV2.c0());
        }
        if (this.afterRenderComplete || this.afterFirstFrame) {
            this.roleControllerV2.qg(this);
            bm bmVar2 = this.midBinding;
            if (bmVar2 != null && (zPlanRolePendantContainer = bmVar2.f418861f) != null) {
                zPlanRolePendantContainer.k();
            }
        }
        if (this.afterFirstFrame) {
            bm bmVar3 = this.midBinding;
            if (bmVar3 != null && (zPlanRolePendantContainer3 = bmVar3.f418861f) != null) {
                zPlanRolePendantContainer3.onFirstFrame(new FirstFrameResult(1, null));
            }
            bm bmVar4 = this.midBinding;
            if (bmVar4 != null && (zPlanFloatBannerView = bmVar4.f418858c) != null) {
                zPlanFloatBannerView.s();
            }
        }
        bm bmVar5 = this.midBinding;
        if (bmVar5 == null || (zPlanRolePendantContainer2 = bmVar5.f418861f) == null) {
            return;
        }
        zPlanRolePendantContainer2.m();
    }

    @Override // wb4.a
    public void G() {
        QLog.i("portal_ZPlanRoleMidComponent", 1, MosaicConstants$JsFunction.FUNC_ON_DESTROY);
    }

    public void U() {
        QLog.i("portal_ZPlanRoleMidComponent", 1, "errorRetry");
        CommonExKt.j(new Function0<Unit>() { // from class: com.tencent.sqshow.zootopia.recommend.characterV2.component.ZPlanRoleMidComponent$errorRetry$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                HashSet hashSet;
                HashSet hashSet2;
                bm bmVar = ZPlanRoleMidComponent.this.midBinding;
                FrameLayout frameLayout = bmVar != null ? bmVar.f418860e : null;
                if (frameLayout != null) {
                    frameLayout.setVisibility(8);
                }
                bm bmVar2 = ZPlanRoleMidComponent.this.midBinding;
                ZPlanPageDataErrorHintView zPlanPageDataErrorHintView = bmVar2 != null ? bmVar2.f418859d : null;
                if (zPlanPageDataErrorHintView != null) {
                    zPlanPageDataErrorHintView.setVisibility(8);
                }
                hashSet = ZPlanRoleMidComponent.this.pageDataErrorHandler;
                Iterator it = hashSet.iterator();
                while (it.hasNext()) {
                    ((com.tencent.sqshow.zootopia.scene.component.c) it.next()).yd();
                }
                hashSet2 = ZPlanRoleMidComponent.this.pageDataErrorHandler;
                hashSet2.clear();
            }
        });
    }

    public void Y() {
        this.roleDataFailed = false;
        CommonExKt.j(new Function0<Unit>() { // from class: com.tencent.sqshow.zootopia.recommend.characterV2.component.ZPlanRoleMidComponent$onRoleDataReqSucceed$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                ZPlanRoleMidComponent.this.W("onRoleDataReqSucceed");
            }
        });
    }
}
