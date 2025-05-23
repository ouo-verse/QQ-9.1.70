package com.tencent.sqshow.zootopia.nativeui.view.title;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.Observer;
import b94.d;
import com.google.gson.JsonArray;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richmediabrowser.utils.ScreenUtils;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import com.tencent.sqshow.zootopia.avatar.AvatarEngineType;
import com.tencent.sqshow.zootopia.card.report.ZplanViewReportHelper;
import com.tencent.sqshow.zootopia.card.view.widget.CurrencyView;
import com.tencent.sqshow.zootopia.nativeui.data.AvatarNativeViewMode;
import com.tencent.sqshow.zootopia.nativeui.data.repo.AvatarCommonOperateHelper;
import com.tencent.sqshow.zootopia.nativeui.dialog.NativeUiDialogUtils;
import com.tencent.sqshow.zootopia.nativeui.ue.s;
import com.tencent.sqshow.zootopia.nativeui.ue.t;
import com.tencent.sqshow.zootopia.nativeui.view.customerface.MakeFaceExitHelper;
import com.tencent.sqshow.zootopia.utils.aa;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import k94.DialogCustomData;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import uv4.au;
import uv4.az;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u008e\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 M2\u00020\u0001:\u0001NB'\b\u0007\u0012\u0006\u0010G\u001a\u00020F\u0012\n\b\u0002\u0010I\u001a\u0004\u0018\u00010H\u0012\b\b\u0002\u0010J\u001a\u00020\u0007\u00a2\u0006\u0004\bK\u0010LJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u001c\u0010\u000b\u001a\u00020\u00022\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\tH\u0002J\u0010\u0010\f\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tH\u0002J\b\u0010\r\u001a\u00020\u0002H\u0002J(\u0010\u0012\u001a\u00020\u00022\u0016\u0010\u0011\u001a\u0012\u0012\u0004\u0012\u00020\u000f0\u000ej\b\u0012\u0004\u0012\u00020\u000f`\u00102\u0006\u0010\n\u001a\u00020\tH\u0002J\u0010\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0015\u001a\u00020\u0002H\u0002J\u0010\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0017\u001a\u00020\tH\u0002J\b\u0010\u0018\u001a\u00020\tH\u0002J\u0012\u0010\u001a\u001a\u00020\t2\b\b\u0002\u0010\u0019\u001a\u00020\tH\u0002J\b\u0010\u001b\u001a\u00020\u0002H\u0002J\b\u0010\u001c\u001a\u00020\tH\u0002J\u0014\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u001f0\u001dH\u0002J\b\u0010!\u001a\u00020\tH\u0002J\u000e\u0010#\u001a\u00020\u00022\u0006\u0010\"\u001a\u00020\u0007J\u0006\u0010%\u001a\u00020$J\u0010\u0010&\u001a\u00020\u00022\b\b\u0001\u0010\b\u001a\u00020\u0007R\u0014\u0010*\u001a\u00020'8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b(\u0010)R\u0018\u0010.\u001a\u0004\u0018\u00010+8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b,\u0010-R\u0018\u00102\u001a\u0004\u0018\u00010/8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b0\u00101R\u001a\u00107\u001a\b\u0012\u0004\u0012\u000204038\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b5\u00106R\u001a\u0010:\u001a\b\u0012\u0004\u0012\u000208038\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b9\u00106R\u001a\u0010<\u001a\b\u0012\u0004\u0012\u000208038\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b;\u00106R\u001a\u0010?\u001a\b\u0012\u0004\u0012\u00020=038\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b>\u00106R\u0016\u0010B\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b@\u0010AR\u0016\u0010E\u001a\u00020\u001e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bC\u0010D\u00a8\u0006O"}, d2 = {"Lcom/tencent/sqshow/zootopia/nativeui/view/title/AvatarNativeTitleView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "", "M0", "Landroid/view/View;", "view", "L0", "", "style", "", "needReport", "N0", "h1", "i1", "Ljava/util/HashSet;", "Luv4/az;", "Lkotlin/collections/HashSet;", "items", "g1", "c1", ICustomDataEditor.STRING_ARRAY_PARAM_1, "Y0", "b1", "S0", "V0", "showDialog", "T0", "Z0", "W0", "", "", "", "P0", "X0", "isDark", "setMode", "Landroid/widget/TextView;", "R0", "setStyle", "Ln74/o;", "d", "Ln74/o;", "mBinding", "Lcom/tencent/sqshow/zootopia/nativeui/data/j;", "e", "Lcom/tencent/sqshow/zootopia/nativeui/data/j;", "mChannel", "Lb94/c;", "f", "Lb94/c;", "mBackHandler", "Landroidx/lifecycle/Observer;", "Lcom/tencent/sqshow/zootopia/nativeui/data/l;", tl.h.F, "Landroidx/lifecycle/Observer;", "mItemPoolObserver", "Lm94/a;", "i", "mCurrentInfoObserver", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "mSavedInfoObserver", "Lcom/tencent/sqshow/zootopia/data/f;", BdhLogUtil.LogTag.Tag_Conn, "coinUpdateObserver", "D", "I", "mStyle", "E", "Ljava/lang/String;", "mPageId", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", UserInfo.SEX_FEMALE, "Companion", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class AvatarNativeTitleView extends ConstraintLayout {

    /* renamed from: C, reason: from kotlin metadata */
    private final Observer<com.tencent.sqshow.zootopia.data.f> coinUpdateObserver;

    /* renamed from: D, reason: from kotlin metadata */
    private int mStyle;

    /* renamed from: E, reason: from kotlin metadata */
    private String mPageId;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final n74.o mBinding;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private com.tencent.sqshow.zootopia.nativeui.data.j mChannel;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private b94.c mBackHandler;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final Observer<com.tencent.sqshow.zootopia.nativeui.data.l> mItemPoolObserver;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final Observer<m94.a> mCurrentInfoObserver;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final Observer<m94.a> mSavedInfoObserver;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public AvatarNativeTitleView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void G0(AvatarNativeTitleView this$0, View view) {
        Map<String, Object> hashMap;
        y94.a reporter;
        ZplanViewReportHelper mReporter;
        y94.a reporter2;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.S0();
        com.tencent.sqshow.zootopia.nativeui.data.j jVar = this$0.mChannel;
        if (jVar == null || (reporter2 = jVar.getReporter()) == null || (hashMap = reporter2.b()) == null) {
            hashMap = new HashMap<>();
        }
        hashMap.put("zplan_is_loading", "1");
        com.tencent.sqshow.zootopia.nativeui.data.j jVar2 = this$0.mChannel;
        if (jVar2 == null || (reporter = jVar2.getReporter()) == null || (mReporter = reporter.getMReporter()) == null) {
            return;
        }
        ImageView imageView = this$0.mBinding.f419384b;
        Intrinsics.checkNotNullExpressionValue(imageView, "mBinding.backIgv");
        ZplanViewReportHelper.f(mReporter, imageView, "em_zplan_back_btn", null, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void H0(AvatarNativeTitleView this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(view, "view");
        this$0.c1(view);
    }

    private final void L0(View view) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ((ViewGroup.MarginLayoutParams) layoutParams).setMarginEnd(com.tencent.sqshow.zootopia.utils.i.b(10));
            view.setLayoutParams(layoutParams);
        }
    }

    private final void M0() {
        int screenWidth = ScreenUtils.getScreenWidth(getContext());
        int pxToDp = ViewUtils.pxToDp(screenWidth);
        QLog.d("AvatarNativeTitleView_", 1, " get width: " + screenWidth + ", " + pxToDp + " ");
        if (pxToDp < 350) {
            L0(R0());
            ImageView imageView = this.mBinding.f419384b;
            ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = null;
            } else if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ((ViewGroup.MarginLayoutParams) layoutParams).setMarginStart(com.tencent.sqshow.zootopia.utils.i.b(5));
            }
            imageView.setLayoutParams(layoutParams);
        }
    }

    private final Map<String, Object> P0() {
        String str;
        qu4.j jVar;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        com.tencent.sqshow.zootopia.nativeui.data.j jVar2 = this.mChannel;
        qu4.j jVar3 = null;
        qu4.j faceInfoWhenEnterMakeFace = jVar2 != null ? jVar2.getFaceInfoWhenEnterMakeFace() : null;
        qu4.a k3 = com.tencent.sqshow.zootopia.nativeui.data.c.f370920a.k();
        if (k3 != null && (jVar = k3.f429573b) != null) {
            jVar3 = bj3.a.j(jVar);
        }
        if (faceInfoWhenEnterMakeFace != null && !r94.a.i(faceInfoWhenEnterMakeFace, jVar3)) {
            linkedHashMap.put("zplan_is_adjust", "1");
        } else {
            linkedHashMap.put("zplan_is_adjust", "0");
        }
        com.tencent.sqshow.zootopia.nativeui.data.j jVar4 = this.mChannel;
        if (jVar4 == null || (str = jVar4.getZplanFaceId()) == null) {
            str = "";
        }
        linkedHashMap.put("zplan_face_id", str);
        return linkedHashMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Q0(AvatarNativeTitleView this$0, com.tencent.sqshow.zootopia.data.f data) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        CurrencyView currencyView = this$0.mBinding.f419386d;
        Intrinsics.checkNotNullExpressionValue(data, "data");
        currencyView.d(data);
    }

    private final boolean S0() {
        QLog.d("AvatarNativeTitleView_", 1, "handle back btn " + this.mStyle);
        int i3 = this.mStyle;
        if (i3 == 0) {
            return V0();
        }
        if (i3 == 1) {
            return U0(this, false, 1, null);
        }
        if (i3 != 2) {
            return false;
        }
        return W0();
    }

    private final boolean V0() {
        com.tencent.sqshow.zootopia.nativeui.data.c cVar = com.tencent.sqshow.zootopia.nativeui.data.c.f370920a;
        if (!cVar.t(this.mChannel != null ? r1.getStoreItemPool() : null).isEmpty()) {
            com.tencent.sqshow.zootopia.nativeui.data.j jVar = this.mChannel;
            if (jVar != null) {
                NativeUiDialogUtils nativeUiDialogUtils = NativeUiDialogUtils.f371177a;
                Context context = getContext();
                Intrinsics.checkNotNullExpressionValue(context, "context");
                NativeUiDialogUtils.r(nativeUiDialogUtils, null, jVar, context, new Function0<Unit>() { // from class: com.tencent.sqshow.zootopia.nativeui.view.title.AvatarNativeTitleView$handleBackClickOnNormalStyle$1$1
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
                        AvatarNativeTitleView.this.X0();
                    }
                }, 1, null);
            }
            return true;
        }
        if (cVar.B()) {
            com.tencent.sqshow.zootopia.nativeui.data.j jVar2 = this.mChannel;
            if (jVar2 != null) {
                NativeUiDialogUtils nativeUiDialogUtils2 = NativeUiDialogUtils.f371177a;
                Context context2 = getContext();
                Intrinsics.checkNotNullExpressionValue(context2, "context");
                NativeUiDialogUtils.v(nativeUiDialogUtils2, null, jVar2, context2, new Function0<Unit>() { // from class: com.tencent.sqshow.zootopia.nativeui.view.title.AvatarNativeTitleView$handleBackClickOnNormalStyle$2$1
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
                        AvatarNativeTitleView.this.X0();
                    }
                }, 1, null);
            }
            return true;
        }
        return X0();
    }

    private final boolean W0() {
        com.tencent.sqshow.zootopia.nativeui.data.j jVar = this.mChannel;
        if (jVar == null) {
            return false;
        }
        jVar.getAvatarColorController().c(jVar);
        jVar.getDialogController().d();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean X0() {
        Activity attachedActivity;
        b94.d avatarDressController;
        com.tencent.sqshow.zootopia.nativeui.data.j jVar = this.mChannel;
        if (jVar != null && (avatarDressController = jVar.getAvatarDressController()) != null) {
            avatarDressController.j1();
        }
        b94.c cVar = this.mBackHandler;
        if (cVar != null && cVar.a()) {
            return true;
        }
        com.tencent.sqshow.zootopia.nativeui.data.j jVar2 = this.mChannel;
        if (jVar2 != null && (attachedActivity = jVar2.getAttachedActivity()) != null) {
            attachedActivity.finish();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Z0() {
        ga4.f dialogController;
        t avatarFaceController;
        com.tencent.sqshow.zootopia.nativeui.data.j jVar = this.mChannel;
        if (jVar != null && (avatarFaceController = jVar.getAvatarFaceController()) != null) {
            avatarFaceController.j1();
        }
        com.tencent.sqshow.zootopia.nativeui.data.j jVar2 = this.mChannel;
        if (jVar2 != null && (dialogController = jVar2.getDialogController()) != null) {
            dialogController.d();
        }
        this.mStyle = 0;
        N0(0, true);
    }

    private final void a1(View view) {
        com.tencent.sqshow.zootopia.nativeui.data.j jVar;
        b94.d avatarDressController;
        t avatarFaceController;
        y94.a reporter;
        ZplanViewReportHelper mReporter;
        com.tencent.sqshow.zootopia.nativeui.data.j jVar2 = this.mChannel;
        if (jVar2 != null && (reporter = jVar2.getReporter()) != null && (mReporter = reporter.getMReporter()) != null) {
            TextView textView = this.mBinding.f419385c;
            Intrinsics.checkNotNullExpressionValue(textView, "mBinding.bugBtn");
            mReporter.e(textView, "em_zplan_avatar_save", P0());
        }
        com.tencent.sqshow.zootopia.nativeui.data.j jVar3 = this.mChannel;
        qu4.j d16 = (jVar3 == null || (avatarFaceController = jVar3.getAvatarFaceController()) == null) ? null : avatarFaceController.d();
        if (d16 != null && (jVar = this.mChannel) != null && (avatarDressController = jVar.getAvatarDressController()) != null) {
            d.a.g(avatarDressController, d16, false, null, 6, null);
        }
        T0(false);
    }

    private final void b1(View view) {
        y94.a reporter;
        ZplanViewReportHelper mReporter;
        b94.a engineApi;
        y94.a reporter2;
        ZplanViewReportHelper mReporter2;
        ga4.g a16;
        String obj = view.getTag().toString();
        QLog.d("AvatarNativeTitleView_", 1, "click But Button " + obj);
        AvatarEngineType avatarEngineType = null;
        avatarEngineType = null;
        if (Intrinsics.areEqual(obj, "buy")) {
            com.tencent.sqshow.zootopia.nativeui.data.j jVar = this.mChannel;
            if (jVar != null) {
                ga4.f dialogController = jVar.getDialogController();
                ga4.j jVar2 = ga4.j.f401682a;
                Context context = getContext();
                Intrinsics.checkNotNullExpressionValue(context, "context");
                a16 = jVar2.a(2, jVar, context, (r22 & 8) != 0 ? new DialogCustomData(null, null, null, null, null, 0, 63, null) : null, (r22 & 16) != 0 ? false : false);
                dialogController.e(a16);
            }
            com.tencent.sqshow.zootopia.nativeui.data.j jVar3 = this.mChannel;
            if (jVar3 == null || (reporter2 = jVar3.getReporter()) == null || (mReporter2 = reporter2.getMReporter()) == null) {
                return;
            }
            TextView textView = this.mBinding.f419385c;
            Intrinsics.checkNotNullExpressionValue(textView, "mBinding.bugBtn");
            com.tencent.sqshow.zootopia.nativeui.data.cart.c cVar = com.tencent.sqshow.zootopia.nativeui.data.cart.c.f370946a;
            int index = com.tencent.sqshow.zootopia.nativeui.data.c.f370920a.n().getIndex();
            com.tencent.sqshow.zootopia.nativeui.data.j jVar4 = this.mChannel;
            mReporter2.e(textView, "em_zplan_purchase", cVar.b(index, jVar4 != null ? jVar4.getZplanFaceId() : null));
            return;
        }
        if (Intrinsics.areEqual(obj, "save")) {
            com.tencent.sqshow.zootopia.nativeui.data.j jVar5 = this.mChannel;
            if (jVar5 != null && (engineApi = jVar5.getEngineApi()) != null) {
                avatarEngineType = engineApi.getType();
            }
            AvatarCommonOperateHelper.u(AvatarCommonOperateHelper.f371049a, this.mChannel, null, avatarEngineType != AvatarEngineType.UE_SMALL_HOME, 2, null, 18, null);
            com.tencent.sqshow.zootopia.nativeui.data.j jVar6 = this.mChannel;
            if (jVar6 == null || (reporter = jVar6.getReporter()) == null || (mReporter = reporter.getMReporter()) == null) {
                return;
            }
            TextView textView2 = this.mBinding.f419385c;
            Intrinsics.checkNotNullExpressionValue(textView2, "mBinding.bugBtn");
            mReporter.e(textView2, "em_zplan_avatar_save", P0());
        }
    }

    private final void c1(View view) {
        QLog.d("AvatarNativeTitleView_", 1, "handle save btn " + this.mStyle);
        int i3 = this.mStyle;
        if (i3 == 0) {
            b1(view);
        } else if (i3 == 1) {
            a1(view);
        } else {
            if (i3 != 2) {
                return;
            }
            Y0();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d1(AvatarNativeTitleView this$0, m94.a aVar) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        O0(this$0, 0, false, 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e1(AvatarNativeTitleView this$0, com.tencent.sqshow.zootopia.nativeui.data.l lVar) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        O0(this$0, 0, false, 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f1(AvatarNativeTitleView this$0, m94.a aVar) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        O0(this$0, 0, false, 3, null);
    }

    private final void g1(HashSet<az> items, boolean needReport) {
        int collectionSizeOrDefault;
        HashMap hashMapOf;
        y94.a reporter;
        ZplanViewReportHelper mReporter;
        CharSequence text = getContext().getText(R.string.xm8);
        this.mBinding.f419385c.setText(((Object) text) + "\u00b7" + items.size());
        this.mBinding.f419385c.setBackground(ContextCompat.getDrawable(getContext(), R.drawable.i5j));
        if (needReport || !Intrinsics.areEqual(this.mBinding.f419385c.getTag(), "buy")) {
            JsonArray jsonArray = new JsonArray();
            Iterator<T> it = items.iterator();
            while (it.hasNext()) {
                jsonArray.add(r94.b.J((az) it.next()));
            }
            Pair[] pairArr = new Pair[2];
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(items, 10);
            ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
            Iterator<T> it5 = items.iterator();
            while (it5.hasNext()) {
                arrayList.add(r94.b.K((az) it5.next()));
            }
            pairArr[0] = TuplesKt.to("zplan_item_id", arrayList);
            pairArr[1] = TuplesKt.to("zplan_ext_info", jsonArray.toString());
            hashMapOf = MapsKt__MapsKt.hashMapOf(pairArr);
            com.tencent.sqshow.zootopia.nativeui.data.j jVar = this.mChannel;
            if (jVar != null && (reporter = jVar.getReporter()) != null && (mReporter = reporter.getMReporter()) != null) {
                TextView textView = this.mBinding.f419385c;
                Intrinsics.checkNotNullExpressionValue(textView, "mBinding.bugBtn");
                mReporter.g(textView, "em_zplan_purchase", (r16 & 4) != 0 ? null : hashMapOf, (r16 & 8) != 0, (r16 & 16) != 0 ? null : null, (r16 & 32) != 0 ? false : false);
            }
        }
        this.mBinding.f419385c.setTag("buy");
    }

    private final void h1(boolean needReport) {
        Map<String, Object> hashMap;
        y94.a reporter;
        ZplanViewReportHelper mReporter;
        y94.a reporter2;
        this.mBinding.f419385c.setText(R.string.xt8);
        this.mBinding.f419385c.setTag("save");
        this.mBinding.f419385c.setBackground(ContextCompat.getDrawable(getContext(), R.drawable.i5j));
        if (needReport) {
            com.tencent.sqshow.zootopia.nativeui.data.j jVar = this.mChannel;
            if (jVar == null || (reporter2 = jVar.getReporter()) == null || (hashMap = reporter2.b()) == null) {
                hashMap = new HashMap<>();
            }
            Map<String, Object> map = hashMap;
            map.put("zplan_is_adjust", "0");
            com.tencent.sqshow.zootopia.nativeui.data.j jVar2 = this.mChannel;
            if (jVar2 == null || (reporter = jVar2.getReporter()) == null || (mReporter = reporter.getMReporter()) == null) {
                return;
            }
            TextView textView = this.mBinding.f419385c;
            Intrinsics.checkNotNullExpressionValue(textView, "mBinding.bugBtn");
            mReporter.g(textView, "em_zplan_avatar_save", (r16 & 4) != 0 ? null : map, (r16 & 8) != 0, (r16 & 16) != 0 ? null : null, (r16 & 32) != 0 ? false : false);
        }
    }

    private final void i1() {
        this.mBinding.f419385c.setText(R.string.xt8);
        this.mBinding.f419385c.setTag("disable");
        this.mBinding.f419385c.setBackground(ContextCompat.getDrawable(getContext(), R.drawable.i5k));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k1(int i3, AvatarNativeTitleView this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (i3 == 1) {
            this$0.mBinding.f419384b.setImageDrawable(ContextCompat.getDrawable(this$0.getContext(), R.drawable.ilu));
        } else {
            this$0.mBinding.f419384b.setImageDrawable(ContextCompat.getDrawable(this$0.getContext(), R.drawable.ilw));
        }
    }

    public final TextView R0() {
        TextView textView = this.mBinding.f419385c;
        Intrinsics.checkNotNullExpressionValue(textView, "mBinding.bugBtn");
        return textView;
    }

    public final void setMode(final int isDark) {
        post(new Runnable() { // from class: com.tencent.sqshow.zootopia.nativeui.view.title.a
            @Override // java.lang.Runnable
            public final void run() {
                AvatarNativeTitleView.k1(isDark, this);
            }
        });
    }

    public final void setStyle(@Companion.AvatarNativeTitleViewStyle int style) {
        com.tencent.sqshow.zootopia.nativeui.data.j jVar;
        y94.a reporter;
        ZplanViewReportHelper mReporter;
        y94.a reporter2;
        Map<String, Object> hashMap;
        com.tencent.sqshow.zootopia.nativeui.data.j jVar2;
        y94.a reporter3;
        ZplanViewReportHelper mReporter2;
        y94.a reporter4;
        ZplanViewReportHelper mReporter3;
        y94.a reporter5;
        y94.a reporter6;
        ZplanViewReportHelper mReporter4;
        y94.a reporter7;
        y94.a reporter8;
        ZplanViewReportHelper mReporter5;
        y94.a reporter9;
        QLog.i("AvatarNativeTitleView_", 1, "setStyle style:" + style);
        Map<String, Object> map = null;
        if (style == 0) {
            this.mBinding.f419386d.setVisibility(0);
            if (!Intrinsics.areEqual(this.mPageId, "pg_zplan_avatar_mall") && (jVar = this.mChannel) != null && (reporter = jVar.getReporter()) != null && (mReporter = reporter.getMReporter()) != null) {
                Context context = getContext();
                Intrinsics.checkNotNullExpressionValue(context, "context");
                com.tencent.sqshow.zootopia.nativeui.data.j jVar3 = this.mChannel;
                if (jVar3 != null && (reporter2 = jVar3.getReporter()) != null) {
                    map = reporter2.b();
                }
                mReporter.a(context, this, "pg_zplan_avatar_mall", map);
            }
        } else if (style == 1) {
            this.mBinding.f419386d.setVisibility(8);
            com.tencent.sqshow.zootopia.nativeui.data.j jVar4 = this.mChannel;
            if (jVar4 != null && (reporter6 = jVar4.getReporter()) != null && (mReporter4 = reporter6.getMReporter()) != null) {
                Context context2 = getContext();
                Intrinsics.checkNotNullExpressionValue(context2, "context");
                com.tencent.sqshow.zootopia.nativeui.data.j jVar5 = this.mChannel;
                if (jVar5 != null && (reporter7 = jVar5.getReporter()) != null) {
                    map = reporter7.b();
                }
                mReporter4.a(context2, this, "pg_zplan_avatar_sculpt", map);
            }
            this.mPageId = "pg_zplan_avatar_sculpt";
        } else if (style == 2) {
            this.mBinding.f419386d.setVisibility(0);
            com.tencent.sqshow.zootopia.nativeui.data.j jVar6 = this.mChannel;
            if (jVar6 != null && (reporter8 = jVar6.getReporter()) != null && (mReporter5 = reporter8.getMReporter()) != null) {
                Context context3 = getContext();
                Intrinsics.checkNotNullExpressionValue(context3, "context");
                com.tencent.sqshow.zootopia.nativeui.data.j jVar7 = this.mChannel;
                if (jVar7 != null && (reporter9 = jVar7.getReporter()) != null) {
                    map = reporter9.b();
                }
                mReporter5.a(context3, this, "pg_zplan_avatar_dye", map);
            }
            this.mPageId = "pg_zplan_avatar_dye";
        }
        com.tencent.sqshow.zootopia.nativeui.data.j jVar8 = this.mChannel;
        if (jVar8 == null || (reporter5 = jVar8.getReporter()) == null || (hashMap = reporter5.b()) == null) {
            hashMap = new HashMap<>();
        }
        Map<String, Object> map2 = hashMap;
        map2.put("zplan_is_loading", "1");
        com.tencent.sqshow.zootopia.nativeui.data.j jVar9 = this.mChannel;
        if (jVar9 != null && (reporter4 = jVar9.getReporter()) != null && (mReporter3 = reporter4.getMReporter()) != null) {
            ImageView imageView = this.mBinding.f419384b;
            Intrinsics.checkNotNullExpressionValue(imageView, "mBinding.backIgv");
            mReporter3.g(imageView, "em_zplan_back_btn", (r16 & 4) != 0 ? null : map2, (r16 & 8) != 0, (r16 & 16) != 0 ? null : null, (r16 & 32) != 0 ? false : false);
        }
        if (this.mBinding.f419386d.getVisibility() == 0 && (jVar2 = this.mChannel) != null && (reporter3 = jVar2.getReporter()) != null && (mReporter2 = reporter3.getMReporter()) != null) {
            CurrencyView currencyView = this.mBinding.f419386d;
            Intrinsics.checkNotNullExpressionValue(currencyView, "mBinding.coinArea");
            mReporter2.g(currencyView, "em_zplan_recharge", (r16 & 4) != 0 ? null : null, (r16 & 8) != 0, (r16 & 16) != 0 ? null : null, (r16 & 32) != 0 ? false : false);
        }
        N0(style, true);
        this.mStyle = style;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public AvatarNativeTitleView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final void Y0() {
        String str;
        HashMap hashMapOf;
        ga4.f dialogController;
        ga4.g a16;
        qu4.f fVar;
        y94.a reporter;
        ZplanViewReportHelper mReporter;
        String zplanFaceId;
        s avatarColorController;
        Pair[] pairArr = new Pair[2];
        com.tencent.sqshow.zootopia.nativeui.data.j jVar = this.mChannel;
        String str2 = "";
        if (jVar == null || (avatarColorController = jVar.getAvatarColorController()) == null || (str = avatarColorController.getMCurrentHexColor()) == null) {
            str = "";
        }
        pairArr[0] = TuplesKt.to("zplan_color_code", str);
        com.tencent.sqshow.zootopia.nativeui.data.j jVar2 = this.mChannel;
        if (jVar2 != null && (zplanFaceId = jVar2.getZplanFaceId()) != null) {
            str2 = zplanFaceId;
        }
        pairArr[1] = TuplesKt.to("zplan_face_id", str2);
        hashMapOf = MapsKt__MapsKt.hashMapOf(pairArr);
        com.tencent.sqshow.zootopia.nativeui.data.j jVar3 = this.mChannel;
        if (jVar3 != null && (reporter = jVar3.getReporter()) != null && (mReporter = reporter.getMReporter()) != null) {
            TextView textView = this.mBinding.f419385c;
            Intrinsics.checkNotNullExpressionValue(textView, "mBinding.bugBtn");
            mReporter.e(textView, "em_zplan_avatar_save", hashMapOf);
        }
        if (com.tencent.sqshow.zootopia.nativeui.data.c.f370920a.A()) {
            au value = com.tencent.sqshow.zootopia.nativeui.view.experience.m.f371882a.a().getValue();
            if (((value == null || (fVar = value.f440232a) == null) ? 0L : fVar.f429591b * 1000) < NetConnInfoCenter.getServerTimeMillis()) {
                com.tencent.sqshow.zootopia.nativeui.data.j jVar4 = this.mChannel;
                if (jVar4 != null) {
                    ga4.j jVar5 = ga4.j.f401682a;
                    Context context = getContext();
                    Intrinsics.checkNotNullExpressionValue(context, "context");
                    a16 = jVar5.a(8, jVar4, context, (r22 & 8) != 0 ? new DialogCustomData(null, null, null, null, null, 0, 63, null) : null, (r22 & 16) != 0 ? false : false);
                    a16.show();
                    return;
                }
                return;
            }
        }
        com.tencent.sqshow.zootopia.nativeui.data.j jVar6 = this.mChannel;
        if (jVar6 != null && (dialogController = jVar6.getDialogController()) != null) {
            dialogController.d();
        }
        setStyle(0);
    }

    public /* synthetic */ AvatarNativeTitleView(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AvatarNativeTitleView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        n74.o f16 = n74.o.f(LayoutInflater.from(context), this);
        Intrinsics.checkNotNullExpressionValue(f16, "inflate(LayoutInflater.from(context), this)");
        this.mBinding = f16;
        this.mItemPoolObserver = new Observer() { // from class: com.tencent.sqshow.zootopia.nativeui.view.title.b
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                AvatarNativeTitleView.e1(AvatarNativeTitleView.this, (com.tencent.sqshow.zootopia.nativeui.data.l) obj);
            }
        };
        this.mCurrentInfoObserver = new Observer() { // from class: com.tencent.sqshow.zootopia.nativeui.view.title.c
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                AvatarNativeTitleView.d1(AvatarNativeTitleView.this, (m94.a) obj);
            }
        };
        this.mSavedInfoObserver = new Observer() { // from class: com.tencent.sqshow.zootopia.nativeui.view.title.d
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                AvatarNativeTitleView.f1(AvatarNativeTitleView.this, (m94.a) obj);
            }
        };
        this.coinUpdateObserver = new Observer() { // from class: com.tencent.sqshow.zootopia.nativeui.view.title.e
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                AvatarNativeTitleView.Q0(AvatarNativeTitleView.this, (com.tencent.sqshow.zootopia.data.f) obj);
            }
        };
        this.mStyle = -1;
        this.mPageId = "pg_zplan_avatar_mall";
        ImageView imageView = f16.f419384b;
        Intrinsics.checkNotNullExpressionValue(imageView, "mBinding.backIgv");
        aa.d(imageView, new View.OnClickListener() { // from class: com.tencent.sqshow.zootopia.nativeui.view.title.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AvatarNativeTitleView.G0(AvatarNativeTitleView.this, view);
            }
        });
        TextView textView = f16.f419385c;
        Intrinsics.checkNotNullExpressionValue(textView, "mBinding.bugBtn");
        aa.d(textView, new View.OnClickListener() { // from class: com.tencent.sqshow.zootopia.nativeui.view.title.g
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AvatarNativeTitleView.H0(AvatarNativeTitleView.this, view);
            }
        });
        M0();
    }

    static /* synthetic */ void O0(AvatarNativeTitleView avatarNativeTitleView, int i3, boolean z16, int i16, Object obj) {
        if ((i16 & 1) != 0) {
            i3 = avatarNativeTitleView.mStyle;
        }
        if ((i16 & 2) != 0) {
            z16 = false;
        }
        avatarNativeTitleView.N0(i3, z16);
    }

    private final boolean T0(boolean showDialog) {
        Activity attachedActivity;
        ga4.f dialogController;
        t avatarFaceController;
        if (showDialog) {
            com.tencent.sqshow.zootopia.nativeui.data.j jVar = this.mChannel;
            if ((jVar == null || (avatarFaceController = jVar.getAvatarFaceController()) == null || !avatarFaceController.f()) ? false : true) {
                MakeFaceExitHelper makeFaceExitHelper = MakeFaceExitHelper.f371595a;
                com.tencent.sqshow.zootopia.nativeui.data.j jVar2 = this.mChannel;
                Context context = getContext();
                Intrinsics.checkNotNullExpressionValue(context, "context");
                makeFaceExitHelper.c(jVar2, context, new Function1<Boolean, Unit>() { // from class: com.tencent.sqshow.zootopia.nativeui.view.title.AvatarNativeTitleView$handleBackClickOnMakeFaceStyle$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                        invoke(bool.booleanValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(boolean z16) {
                        com.tencent.sqshow.zootopia.nativeui.data.j jVar3;
                        com.tencent.sqshow.zootopia.nativeui.data.j jVar4;
                        com.tencent.sqshow.zootopia.nativeui.data.j jVar5;
                        Activity attachedActivity2;
                        ga4.f dialogController2;
                        jVar3 = AvatarNativeTitleView.this.mChannel;
                        if ((jVar3 != null ? jVar3.getNativeViewMode() : null) == AvatarNativeViewMode.ONLY_MAKE_FACE) {
                            jVar4 = AvatarNativeTitleView.this.mChannel;
                            if (jVar4 != null && (dialogController2 = jVar4.getDialogController()) != null) {
                                dialogController2.d();
                            }
                            jVar5 = AvatarNativeTitleView.this.mChannel;
                            if (jVar5 == null || (attachedActivity2 = jVar5.getAttachedActivity()) == null) {
                                return;
                            }
                            attachedActivity2.finish();
                            return;
                        }
                        AvatarNativeTitleView.this.Z0();
                    }
                });
                return true;
            }
        }
        com.tencent.sqshow.zootopia.nativeui.data.j jVar3 = this.mChannel;
        if (jVar3 != null && (dialogController = jVar3.getDialogController()) != null) {
            dialogController.d();
        }
        com.tencent.sqshow.zootopia.nativeui.data.j jVar4 = this.mChannel;
        if ((jVar4 != null ? jVar4.getNativeViewMode() : null) == AvatarNativeViewMode.ONLY_MAKE_FACE) {
            com.tencent.sqshow.zootopia.nativeui.data.j jVar5 = this.mChannel;
            if (jVar5 != null && (attachedActivity = jVar5.getAttachedActivity()) != null) {
                attachedActivity.finish();
            }
            return true;
        }
        setStyle(0);
        return true;
    }

    static /* synthetic */ boolean U0(AvatarNativeTitleView avatarNativeTitleView, boolean z16, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z16 = true;
        }
        return avatarNativeTitleView.T0(z16);
    }

    private final void N0(int style, boolean needReport) {
        if (style == 1) {
            h1(needReport);
            return;
        }
        if (style != 2) {
            com.tencent.sqshow.zootopia.nativeui.data.c cVar = com.tencent.sqshow.zootopia.nativeui.data.c.f370920a;
            com.tencent.sqshow.zootopia.nativeui.data.j jVar = this.mChannel;
            HashSet<az> t16 = cVar.t(jVar != null ? jVar.getStoreItemPool() : null);
            if (true ^ t16.isEmpty()) {
                g1(t16, needReport);
                return;
            } else if (cVar.B()) {
                h1(needReport);
                return;
            } else {
                i1();
                return;
            }
        }
        h1(needReport);
    }
}
