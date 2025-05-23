package com.tencent.mobileqq.aio.title;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.animation.LinearInterpolator;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.content.ContextCompat;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.bugly.common.constants.Constants;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.aio.title.AIOTitleUIState;
import com.tencent.mobileqq.aio.title.center.CenterVB;
import com.tencent.mobileqq.aio.title.n;
import com.tencent.mobileqq.aio.title.right1.Right1VB;
import com.tencent.mobileqq.aio.title.right2.Right2VB;
import com.tencent.mobileqq.aio.title.troopsquare.TroopSquareTitleVB;
import com.tencent.mobileqq.aio.utils.AIOUtil;
import com.tencent.mobileqq.aio.utils.bb;
import com.tencent.mobileqq.aio.widget.AIOTitleRelativeLayout;
import com.tencent.mobileqq.aio.widget.QUIBadgeMosaic;
import com.tencent.mobileqq.aio.widget.RedDotImageView;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.t;
import com.tencent.mvi.base.mvi.MviUIState;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import com.tencent.widget.calloutpopupwindow.CalloutPopupWindow;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00b2\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 ^2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001_B\u0007\u00a2\u0006\u0004\b\\\u0010]J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0004H\u0002J\b\u0010\u000b\u001a\u00020\tH\u0002J\u0010\u0010\u000e\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\fH\u0002J\u0010\u0010\u0010\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u0006H\u0002J\u0010\u0010\u0012\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u0011H\u0002J\u0018\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u0004H\u0002J\u0018\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u0004H\u0002J\b\u0010\u0017\u001a\u00020\tH\u0002J\b\u0010\u0018\u001a\u00020\tH\u0002J\u0018\u0010\u001b\u001a\u00020\t2\u0006\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u0006H\u0002J\u0010\u0010\u001d\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u001cH\u0002J\u0018\u0010\u001f\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u001e\u001a\u00020\u0006H\u0002J\u0018\u0010!\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\u00062\u0006\u0010 \u001a\u00020\u0006H\u0002J(\u0010&\u001a\u00020\t2\u0006\u0010#\u001a\u00020\"2\u0006\u0010\u001e\u001a\u00020\u00062\u0006\u0010$\u001a\u00020\u00062\u0006\u0010%\u001a\u00020\u0006H\u0002J\b\u0010'\u001a\u00020\tH\u0002J\b\u0010(\u001a\u00020\tH\u0002J\u0010\u0010)\u001a\u00020\t2\u0006\u0010 \u001a\u00020\u0006H\u0002J\b\u0010*\u001a\u00020\tH\u0002J\b\u0010+\u001a\u00020\tH\u0002J\u0010\u0010/\u001a\u00020.2\u0006\u0010-\u001a\u00020,H\u0016J\b\u00100\u001a\u00020\tH\u0016J\u0014\u00102\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u000301H\u0016J&\u00107\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0006\b\u0001\u0012\u000205\u0012\u0006\b\u0001\u0012\u0002060\u0001042\u0006\u00103\u001a\u00020.H\u0016J\u0016\u00109\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00030804H\u0016J\u0010\u0010;\u001a\u00020\t2\u0006\u0010:\u001a\u00020\u0003H\u0016J\b\u0010<\u001a\u00020\tH\u0016R\u0016\u0010@\u001a\u00020=8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b>\u0010?R\u0016\u0010D\u001a\u00020A8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bB\u0010CR\u0018\u0010H\u001a\u0004\u0018\u00010E8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bF\u0010GR$\u0010M\u001a\u0012\u0012\u0004\u0012\u00020\u00040Ij\b\u0012\u0004\u0012\u00020\u0004`J8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bK\u0010LR$\u0010R\u001a\u0012\u0012\u0004\u0012\u00020\u00040Nj\b\u0012\u0004\u0012\u00020\u0004`O8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bP\u0010QR0\u0010X\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020T0Sj\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020T`U8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bV\u0010WR\u0018\u0010[\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bY\u0010Z\u00a8\u0006`"}, d2 = {"Lcom/tencent/mobileqq/aio/title/AIOTitleVB;", "Lcom/tencent/aio/base/mvvm/a;", "Lcom/tencent/mobileqq/aio/title/n;", "Lcom/tencent/mobileqq/aio/title/AIOTitleUIState;", "", "vb", "", "F1", "modelName", "", "l1", "u1", "Lcom/tencent/mobileqq/aio/title/ap;", "data", "O1", "isZplan", "y1", "Lcom/tencent/mobileqq/aio/title/ah;", "H1", "visiable", "type", "J1", "B1", "C1", "o1", "isSelectMode", "isScaleChat", "w1", "Lcom/tencent/mobileqq/aio/title/am;", "K1", "isSelectedMode", "M1", "needTransparentBg", "L1", "", "unreadCount", "needAnim", "isUseTextColorCache", "N1", "z1", "m1", Constants.APK_CERTIFICATE, "E1", Constants.BASE_IN_PLUGIN_ID, "Lcom/tencent/mvi/api/help/a;", "createViewParams", "Landroid/view/View;", "onCreateView", "bindViewAndData", "Lcom/tencent/aio/base/mvvm/b;", ICustomDataEditor.STRING_PARAM_1, "hostView", "", "Lol3/b;", "Lcom/tencent/mvi/base/mvi/MviUIState;", "initializeChildVB", "Ljava/lang/Class;", "getObserverStates", "state", "x1", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Lw71/t;", "d", "Lw71/t;", "mTitleBinding", "Lw71/u;", "e", "Lw71/u;", "mRight3IvBinding", "Lcom/tencent/mobileqq/aio/title/center/CenterVB;", "f", "Lcom/tencent/mobileqq/aio/title/center/CenterVB;", "mCenterVB", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", tl.h.F, "Ljava/util/HashSet;", "mChildList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "i", "Ljava/util/ArrayList;", "mChildVBPriority", "Ljava/util/HashMap;", "Ln81/a;", "Lkotlin/collections/HashMap;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/util/HashMap;", "mChildPriorityVBRecord", BdhLogUtil.LogTag.Tag_Conn, "Ljava/lang/String;", "currentChildVBPriority", "<init>", "()V", "D", "a", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class AIOTitleVB extends com.tencent.aio.base.mvvm.a<n, AIOTitleUIState> {
    static IPatchRedirector $redirector_;

    @NotNull
    private static final a D;

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private String currentChildVBPriority;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private w71.t mTitleBinding;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private w71.u mRight3IvBinding;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private CenterVB mCenterVB;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final HashSet<String> mChildList;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ArrayList<String> mChildVBPriority;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final HashMap<String, n81.a> mChildPriorityVBRecord;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0004\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/aio/title/AIOTitleVB$a;", "", "", "NOTIFY_SERVICE_VB", "Ljava/lang/String;", "TAG", "TROOP_GUILD_VB", "TROOP_SQUARE_VB", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes11.dex */
    private static final class a {
        static IPatchRedirector $redirector_;

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(65092);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 9)) {
            redirector.redirect((short) 9);
        } else {
            D = new a(null);
        }
    }

    public AIOTitleVB() {
        ArrayList<String> arrayListOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        HashSet<String> hashSet = new HashSet<>();
        hashSet.add("troop_guild_vb");
        hashSet.add("notify_service_vb");
        hashSet.add("troop_square_vb");
        this.mChildList = hashSet;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf("troop_guild_vb", "troop_square_vb");
        this.mChildVBPriority = arrayListOf;
        this.mChildPriorityVBRecord = new HashMap<>();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void A1(AIOTitleVB this$0) {
        t.a y16;
        t.a F1;
        t.a y17;
        t.a F12;
        t.a F13;
        t.a y18;
        t.a F14;
        t.a y19;
        t.a F15;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        try {
            try {
                if (QQTheme.isVasTheme()) {
                    w71.t tVar = this$0.mTitleBinding;
                    if (tVar == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mTitleBinding");
                        tVar = null;
                    }
                    tVar.f444911l.setBackground(this$0.getMContext().getResources().getDrawable(R.drawable.qui_bg_nav_secondary));
                } else {
                    w71.t tVar2 = this$0.mTitleBinding;
                    if (tVar2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mTitleBinding");
                        tVar2 = null;
                    }
                    tVar2.f444911l.setBackgroundColor(this$0.getMContext().getResources().getColor(R.color.qui_common_bg_nav_aio));
                }
                w71.t tVar3 = this$0.mTitleBinding;
                if (tVar3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mTitleBinding");
                    tVar3 = null;
                }
                tVar3.f444911l.invalidate();
                com.tencent.mobileqq.aio.utils.am amVar = com.tencent.mobileqq.aio.utils.am.f194110a;
                w71.t tVar4 = this$0.mTitleBinding;
                if (tVar4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mTitleBinding");
                    tVar4 = null;
                }
                AIOTitleRelativeLayout aIOTitleRelativeLayout = tVar4.f444911l;
                Intrinsics.checkNotNullExpressionValue(aIOTitleRelativeLayout, "mTitleBinding.titleLl");
                Bitmap e16 = amVar.e(aIOTitleRelativeLayout, true);
                w71.t tVar5 = this$0.mTitleBinding;
                if (tVar5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mTitleBinding");
                    tVar5 = null;
                }
                tVar5.f444914o.setMosaicEffect(new com.tencent.mobileqq.widget.t(10));
                w71.t tVar6 = this$0.mTitleBinding;
                if (tVar6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mTitleBinding");
                    tVar6 = null;
                }
                tVar6.f444916q.setMosaicEffect(new com.tencent.mobileqq.widget.t(10));
                w71.t tVar7 = this$0.mTitleBinding;
                if (tVar7 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mTitleBinding");
                    tVar7 = null;
                }
                tVar7.f444913n.setMosaicEffect(new com.tencent.mobileqq.widget.t(10));
                CenterVB centerVB = this$0.mCenterVB;
                if (centerVB != null && (F15 = centerVB.F1()) != null) {
                    F15.setMosaicEffect(new com.tencent.mobileqq.widget.t(10));
                }
                CenterVB centerVB2 = this$0.mCenterVB;
                if (centerVB2 != null && (y19 = centerVB2.y1()) != null) {
                    y19.setMosaicEffect(new com.tencent.mobileqq.widget.t(10));
                }
                w71.t tVar8 = this$0.mTitleBinding;
                if (tVar8 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mTitleBinding");
                    tVar8 = null;
                }
                AIOTitleRelativeLayout aIOTitleRelativeLayout2 = tVar8.f444911l;
                Intrinsics.checkNotNullExpressionValue(aIOTitleRelativeLayout2, "mTitleBinding.titleLl");
                Bitmap e17 = amVar.e(aIOTitleRelativeLayout2, true);
                w71.t tVar9 = this$0.mTitleBinding;
                if (tVar9 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mTitleBinding");
                    tVar9 = null;
                }
                tVar9.f444911l.setBackground(null);
                w71.t tVar10 = this$0.mTitleBinding;
                if (tVar10 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mTitleBinding");
                    tVar10 = null;
                }
                tVar10.f444911l.invalidate();
                w71.t tVar11 = this$0.mTitleBinding;
                if (tVar11 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mTitleBinding");
                    tVar11 = null;
                }
                tVar11.f444914o.setMosaicEffect(null);
                w71.t tVar12 = this$0.mTitleBinding;
                if (tVar12 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mTitleBinding");
                    tVar12 = null;
                }
                tVar12.f444916q.setMosaicEffect(null);
                w71.t tVar13 = this$0.mTitleBinding;
                if (tVar13 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mTitleBinding");
                    tVar13 = null;
                }
                tVar13.f444913n.setMosaicEffect(null);
                CenterVB centerVB3 = this$0.mCenterVB;
                if (centerVB3 != null && (F14 = centerVB3.F1()) != null) {
                    F14.setMosaicEffect(null);
                }
                CenterVB centerVB4 = this$0.mCenterVB;
                if (centerVB4 != null && (y18 = centerVB4.y1()) != null) {
                    y18.setMosaicEffect(null);
                }
                this$0.sendIntent(new n.k(e16, e17));
                w71.t tVar14 = this$0.mTitleBinding;
                if (tVar14 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mTitleBinding");
                    tVar14 = null;
                }
                tVar14.f444914o.setMosaicEffect(null);
                w71.t tVar15 = this$0.mTitleBinding;
                if (tVar15 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mTitleBinding");
                    tVar15 = null;
                }
                tVar15.f444916q.setMosaicEffect(null);
                w71.t tVar16 = this$0.mTitleBinding;
                if (tVar16 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mTitleBinding");
                    tVar16 = null;
                }
                tVar16.f444913n.setMosaicEffect(null);
                CenterVB centerVB5 = this$0.mCenterVB;
                if (centerVB5 != null && (F13 = centerVB5.F1()) != null) {
                    F13.setMosaicEffect(null);
                }
                CenterVB centerVB6 = this$0.mCenterVB;
                if (centerVB6 == null || (y17 = centerVB6.y1()) == null) {
                    return;
                }
            } catch (Exception e18) {
                QLog.e("AIOTitleVB", 1, "LongShot titleBar bitmap exception: " + e18);
                w71.t tVar17 = this$0.mTitleBinding;
                if (tVar17 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mTitleBinding");
                    tVar17 = null;
                }
                tVar17.f444914o.setMosaicEffect(null);
                w71.t tVar18 = this$0.mTitleBinding;
                if (tVar18 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mTitleBinding");
                    tVar18 = null;
                }
                tVar18.f444916q.setMosaicEffect(null);
                w71.t tVar19 = this$0.mTitleBinding;
                if (tVar19 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mTitleBinding");
                    tVar19 = null;
                }
                tVar19.f444913n.setMosaicEffect(null);
                CenterVB centerVB7 = this$0.mCenterVB;
                if (centerVB7 != null && (F12 = centerVB7.F1()) != null) {
                    F12.setMosaicEffect(null);
                }
                CenterVB centerVB8 = this$0.mCenterVB;
                if (centerVB8 == null || (y17 = centerVB8.y1()) == null) {
                    return;
                }
            }
            y17.setMosaicEffect(null);
        } catch (Throwable th5) {
            w71.t tVar20 = this$0.mTitleBinding;
            if (tVar20 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mTitleBinding");
                tVar20 = null;
            }
            tVar20.f444914o.setMosaicEffect(null);
            w71.t tVar21 = this$0.mTitleBinding;
            if (tVar21 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mTitleBinding");
                tVar21 = null;
            }
            tVar21.f444916q.setMosaicEffect(null);
            w71.t tVar22 = this$0.mTitleBinding;
            if (tVar22 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mTitleBinding");
                tVar22 = null;
            }
            tVar22.f444913n.setMosaicEffect(null);
            CenterVB centerVB9 = this$0.mCenterVB;
            if (centerVB9 != null && (F1 = centerVB9.F1()) != null) {
                F1.setMosaicEffect(null);
            }
            CenterVB centerVB10 = this$0.mCenterVB;
            if (centerVB10 != null && (y16 = centerVB10.y1()) != null) {
                y16.setMosaicEffect(null);
            }
            throw th5;
        }
    }

    private final void B1(boolean visiable, String type) {
        w71.u uVar = this.mRight3IvBinding;
        if (uVar == null) {
            return;
        }
        if (visiable) {
            HashMap hashMap = new HashMap();
            hashMap.put("aio_left_business_type", type);
            com.tencent.mobileqq.aio.utils.b.q("em_bas_aio_top_feature_entry_left", hashMap);
            com.tencent.mobileqq.aio.utils.b.f194119a.c("em_bas_aio_top_feature_entry_left", type);
            return;
        }
        if (uVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRight3IvBinding");
            uVar = null;
        }
        if (uVar.f444920b.getVisibility() == 0) {
            HashMap hashMap2 = new HashMap();
            hashMap2.put("aio_left_business_type", com.tencent.mobileqq.aio.utils.b.f194119a.j("em_bas_aio_top_feature_entry_left", ""));
            com.tencent.mobileqq.aio.utils.b.t("em_bas_aio_top_feature_entry_left", hashMap2);
        }
    }

    private final void C1() {
        HashMap hashMap = new HashMap();
        hashMap.put("aio_left_business_type", com.tencent.mobileqq.aio.utils.b.f194119a.j("em_bas_aio_top_feature_entry_left", ""));
        com.tencent.mobileqq.aio.utils.b.l("em_bas_aio_top_feature_entry_left", hashMap);
    }

    private final void D1() {
        if (com.tencent.qqnt.util.b.f362976b.enableTalkBack()) {
            w71.t tVar = this.mTitleBinding;
            if (tVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mTitleBinding");
                tVar = null;
            }
            tVar.f444905f.performAccessibilityAction(64, new Bundle());
        }
    }

    private final void E1() {
        w71.t tVar = null;
        n.b bVar = new n.b(null, 1, null);
        sendIntent(bVar);
        View.AccessibilityDelegate a16 = bVar.a();
        if (a16 != null) {
            w71.t tVar2 = this.mTitleBinding;
            if (tVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mTitleBinding");
            } else {
                tVar = tVar2;
            }
            tVar.f444911l.setAccessibilityDelegate(a16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0032, code lost:
    
        if (r0 < r3) goto L18;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean F1(String vb5) {
        boolean z16;
        int indexOf;
        boolean z17 = false;
        if (!this.mChildVBPriority.contains(vb5)) {
            return false;
        }
        if (Intrinsics.areEqual(vb5, this.currentChildVBPriority)) {
            return true;
        }
        String str = this.currentChildVBPriority;
        if (str != null && str.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!z16) {
            int indexOf2 = this.mChildVBPriority.indexOf(vb5);
            indexOf = CollectionsKt___CollectionsKt.indexOf((List<? extends String>) ((List<? extends Object>) this.mChildVBPriority), this.currentChildVBPriority);
        }
        z17 = true;
        if (z17) {
            this.currentChildVBPriority = vb5;
            Set<String> keySet = this.mChildPriorityVBRecord.keySet();
            Intrinsics.checkNotNullExpressionValue(keySet, "mChildPriorityVBRecord.keys");
            ArrayList arrayList = new ArrayList();
            for (Object obj : keySet) {
                if (!Intrinsics.areEqual((String) obj, vb5)) {
                    arrayList.add(obj);
                }
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                n81.a aVar = this.mChildPriorityVBRecord.get((String) it.next());
                if (aVar != null) {
                    aVar.x();
                }
            }
        }
        QLog.i("AIOTitleVB", 1, "showChildPriorityVB vb:" + vb5 + ", canShow:" + z17 + ", current:" + this.currentChildVBPriority);
        return z17;
    }

    private final void G1(boolean needTransparentBg) {
        int i3;
        if (!QQTheme.isNowSimpleUI() && !QQTheme.isVasTheme() && !needTransparentBg) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        w71.t tVar = this.mTitleBinding;
        if (tVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTitleBinding");
            tVar = null;
        }
        tVar.f444903d.setVisibility(i3);
    }

    private final void H1(ah data) {
        boolean z16 = false;
        y1(false);
        if (data.e() && !data.f()) {
            z16 = true;
        }
        J1(z16, data.c());
        Function1<View, Unit> d16 = data.d();
        w71.u uVar = null;
        if (d16 != null) {
            w71.u uVar2 = this.mRight3IvBinding;
            if (uVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mRight3IvBinding");
                uVar2 = null;
            }
            RedDotImageView redDotImageView = uVar2.f444920b;
            Intrinsics.checkNotNullExpressionValue(redDotImageView, "mRight3IvBinding.right3Iv");
            d16.invoke(redDotImageView);
        }
        w71.u uVar3 = this.mRight3IvBinding;
        if (uVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRight3IvBinding");
            uVar3 = null;
        }
        uVar3.f444920b.setShowRedDot(data.a());
        w71.u uVar4 = this.mRight3IvBinding;
        if (uVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRight3IvBinding");
            uVar4 = null;
        }
        uVar4.f444920b.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.aio.title.v
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AIOTitleVB.I1(AIOTitleVB.this, view);
            }
        });
        if (data.b() != null) {
            w71.u uVar5 = this.mRight3IvBinding;
            if (uVar5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mRight3IvBinding");
            } else {
                uVar = uVar5;
            }
            uVar.f444920b.setImageDrawable(data.b());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void I1(AIOTitleVB this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.sendIntent(n.m.f193986d);
        this$0.C1();
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void J1(boolean visiable, String type) {
        int i3;
        B1(visiable, type);
        w71.u uVar = this.mRight3IvBinding;
        if (uVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRight3IvBinding");
            uVar = null;
        }
        RedDotImageView redDotImageView = uVar.f444920b;
        if (visiable) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        redDotImageView.setVisibility(i3);
    }

    private final void K1(am data) {
        N1(data.c(), data.d(), false, data.e());
        M1(data.b(), data.d());
        L1(data.b(), data.a());
        G1(data.a());
    }

    private final void L1(boolean isScaleChat, boolean needTransparentBg) {
        w71.t tVar = this.mTitleBinding;
        if (tVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTitleBinding");
            tVar = null;
        }
        RelativeLayout relativeLayout = tVar.f444910k;
        int i3 = 0;
        if (needTransparentBg) {
            relativeLayout.setBackgroundColor(0);
        } else if (QQTheme.isVasTheme()) {
            AIOUtil.f194084a.G(relativeLayout, R.drawable.qui_common_bg_nav_aio_bg);
        } else {
            AIOUtil.f194084a.F(relativeLayout, new ColorDrawable(relativeLayout.getResources().getColor(R.color.qui_common_bg_nav_aio)));
        }
        if (isScaleChat) {
            relativeLayout.setPadding(relativeLayout.getPaddingLeft(), (int) relativeLayout.getResources().getDimension(R.dimen.dbx), relativeLayout.getPaddingRight(), relativeLayout.getPaddingBottom());
        } else {
            if (ImmersiveUtils.isSupporImmersive() == 1) {
                i3 = ImmersiveUtils.getStatusBarHeight(relativeLayout.getContext());
            }
            relativeLayout.setPadding(relativeLayout.getPaddingLeft(), i3, relativeLayout.getPaddingRight(), relativeLayout.getPaddingBottom());
        }
    }

    private final void M1(boolean isScaleChat, boolean isSelectedMode) {
        String str;
        w71.t tVar = null;
        if (!isSelectedMode) {
            if (isScaleChat) {
                w71.t tVar2 = this.mTitleBinding;
                if (tVar2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mTitleBinding");
                    tVar2 = null;
                }
                tVar2.f444905f.setBackgroundResource(R.drawable.qui_close_icon_navigation_01);
            } else {
                Drawable drawable = ContextCompat.getDrawable(getMContext(), R.drawable.qui_chevron_left_icon_navigation_02_selector);
                w71.t tVar3 = this.mTitleBinding;
                if (tVar3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mTitleBinding");
                    tVar3 = null;
                }
                tVar3.f444905f.setBackground(drawable);
            }
            w71.t tVar4 = this.mTitleBinding;
            if (tVar4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mTitleBinding");
                tVar4 = null;
            }
            tVar4.f444905f.setTextColor(getMContext().getColor(R.color.skin_bar_btn));
        }
        w71.t tVar5 = this.mTitleBinding;
        if (tVar5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTitleBinding");
            tVar5 = null;
        }
        if (!TextUtils.isEmpty(tVar5.f444916q.a())) {
            Resources resources = getMContext().getResources();
            Object[] objArr = new Object[1];
            w71.t tVar6 = this.mTitleBinding;
            if (tVar6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mTitleBinding");
                tVar6 = null;
            }
            objArr[0] = tVar6.f444916q.a();
            str = resources.getString(R.string.yt8, objArr);
        } else {
            str = "";
        }
        Intrinsics.checkNotNullExpressionValue(str, "if (!TextUtils.isEmpty(m\u2026\n            \"\"\n        }");
        w71.t tVar7 = this.mTitleBinding;
        if (tVar7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTitleBinding");
        } else {
            tVar = tVar7;
        }
        tVar.f444905f.setContentDescription(HardCodeUtil.qqStr(R.string.yt7) + str);
    }

    private final void N1(int unreadCount, boolean isSelectedMode, boolean needAnim, boolean isUseTextColorCache) {
        boolean z16;
        String str;
        w71.t tVar = this.mTitleBinding;
        w71.t tVar2 = null;
        if (tVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTitleBinding");
            tVar = null;
        }
        tVar.f444916q.setTextColorUseCache(isUseTextColorCache);
        w71.t tVar3 = this.mTitleBinding;
        if (tVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTitleBinding");
            tVar3 = null;
        }
        tVar3.f444916q.setAIOBarNum(unreadCount);
        w71.t tVar4 = this.mTitleBinding;
        if (tVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTitleBinding");
            tVar4 = null;
        }
        ViewGroup.LayoutParams layoutParams = tVar4.f444914o.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
        float f16 = 8.0f;
        int i3 = 8;
        if (isSelectedMode) {
            w71.t tVar5 = this.mTitleBinding;
            if (tVar5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mTitleBinding");
                tVar5 = null;
            }
            QUIBadgeMosaic qUIBadgeMosaic = tVar5.f444916q;
            if (unreadCount > 0) {
                i3 = 0;
            }
            qUIBadgeMosaic.setTag(Integer.valueOf(i3));
            layoutParams2.setMarginStart(com.tencent.mobileqq.utils.x.a(8.0f));
        } else {
            if (needAnim && unreadCount > 0) {
                w71.t tVar6 = this.mTitleBinding;
                if (tVar6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mTitleBinding");
                    tVar6 = null;
                }
                QUIBadgeMosaic qUIBadgeMosaic2 = tVar6.f444916q;
                Intrinsics.checkNotNullExpressionValue(qUIBadgeMosaic2, "mTitleBinding.unreadTv");
                if (qUIBadgeMosaic2.getVisibility() == 8) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    w71.t tVar7 = this.mTitleBinding;
                    if (tVar7 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mTitleBinding");
                        tVar7 = null;
                    }
                    tVar7.f444916q.setVisibility(0);
                    AIOUtil aIOUtil = AIOUtil.f194084a;
                    w71.t tVar8 = this.mTitleBinding;
                    if (tVar8 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mTitleBinding");
                        tVar8 = null;
                    }
                    QUIBadgeMosaic qUIBadgeMosaic3 = tVar8.f444916q;
                    Intrinsics.checkNotNullExpressionValue(qUIBadgeMosaic3, "mTitleBinding.unreadTv");
                    aIOUtil.H(qUIBadgeMosaic3);
                    layoutParams2.setMarginStart(com.tencent.mobileqq.utils.x.a(8.0f));
                }
            }
            w71.t tVar9 = this.mTitleBinding;
            if (tVar9 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mTitleBinding");
                tVar9 = null;
            }
            QUIBadgeMosaic qUIBadgeMosaic4 = tVar9.f444916q;
            if (unreadCount > 0) {
                i3 = 0;
            }
            qUIBadgeMosaic4.setVisibility(i3);
            if (unreadCount <= 0) {
                f16 = 4.0f;
            }
            layoutParams2.setMarginStart(com.tencent.mobileqq.utils.x.a(f16));
        }
        layoutParams2.leftMargin = layoutParams2.getMarginStart();
        w71.t tVar10 = this.mTitleBinding;
        if (tVar10 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTitleBinding");
            tVar10 = null;
        }
        tVar10.f444916q.setImportantForAccessibility(2);
        if (unreadCount > 0) {
            str = getMContext().getResources().getString(R.string.yt8, String.valueOf(unreadCount));
        } else {
            str = "";
        }
        Intrinsics.checkNotNullExpressionValue(str, "if (unreadCount > 0) {\n \u2026\n            \"\"\n        }");
        w71.t tVar11 = this.mTitleBinding;
        if (tVar11 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTitleBinding");
        } else {
            tVar2 = tVar11;
        }
        tVar2.f444905f.setContentDescription(HardCodeUtil.qqStr(R.string.yt7) + str);
    }

    private final void O1(final ap data) {
        boolean z16 = true;
        y1(true);
        int a16 = data.a();
        bb bbVar = bb.f194129a;
        w71.u uVar = null;
        if (a16 == bbVar.d()) {
            w71.u uVar2 = this.mRight3IvBinding;
            if (uVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mRight3IvBinding");
            } else {
                uVar = uVar2;
            }
            uVar.f444920b.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.aio.title.p
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    AIOTitleVB.P1(ap.this, this, view);
                }
            });
            return;
        }
        if (a16 == bbVar.e()) {
            Object b16 = data.b();
            Intrinsics.checkNotNull(b16, "null cannot be cast to non-null type kotlin.Int");
            if (((Integer) b16).intValue() != 0 || data.c()) {
                z16 = false;
            }
            J1(z16, "0");
            return;
        }
        if (a16 == bbVar.g()) {
            w71.u uVar3 = this.mRight3IvBinding;
            if (uVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mRight3IvBinding");
            } else {
                uVar = uVar3;
            }
            RedDotImageView redDotImageView = uVar.f444920b;
            Context mContext = getMContext();
            Object b17 = data.b();
            Intrinsics.checkNotNull(b17, "null cannot be cast to non-null type kotlin.Int");
            redDotImageView.setImageDrawable(mContext.getDrawable(((Integer) b17).intValue()));
            return;
        }
        if (a16 == bbVar.c()) {
            w71.u uVar4 = this.mRight3IvBinding;
            if (uVar4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mRight3IvBinding");
            } else {
                uVar = uVar4;
            }
            uVar.f444920b.setImageDrawable((Drawable) data.b());
            return;
        }
        if (a16 == bbVar.f()) {
            Object b18 = data.b();
            Intrinsics.checkNotNull(b18, "null cannot be cast to non-null type com.tencent.widget.calloutpopupwindow.CalloutPopupWindow");
            CalloutPopupWindow calloutPopupWindow = (CalloutPopupWindow) b18;
            w71.u uVar5 = this.mRight3IvBinding;
            if (uVar5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mRight3IvBinding");
            } else {
                uVar = uVar5;
            }
            calloutPopupWindow.showAsPointer(uVar.f444920b);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void P1(ap data, AIOTitleVB this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(data, "$data");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        View.OnClickListener onClickListener = (View.OnClickListener) data.b();
        if (onClickListener != null) {
            onClickListener.onClick(view);
        }
        this$0.C1();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:30:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r0v14, types: [com.tencent.mobileqq.aio.title.troopsquare.TroopSquareTitleVB] */
    /* JADX WARN: Type inference failed for: r0v17, types: [com.tencent.mobileqq.aio.title.notifyservice.b] */
    /* JADX WARN: Type inference failed for: r0v6, types: [m81.f] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void l1(String modelName) {
        w71.t tVar;
        if (!this.mChildList.contains(modelName)) {
            return;
        }
        this.mChildList.remove(modelName);
        int hashCode = modelName.hashCode();
        w71.t tVar2 = null;
        if (hashCode != 196015301) {
            if (hashCode != 648891489) {
                if (hashCode == 1474083628 && modelName.equals("notify_service_vb")) {
                    w71.t tVar3 = this.mTitleBinding;
                    if (tVar3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mTitleBinding");
                        tVar3 = null;
                    }
                    AIOTitleRelativeLayout aIOTitleRelativeLayout = tVar3.f444911l;
                    Intrinsics.checkNotNullExpressionValue(aIOTitleRelativeLayout, "mTitleBinding.titleLl");
                    w71.t tVar4 = this.mTitleBinding;
                    if (tVar4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mTitleBinding");
                    } else {
                        tVar2 = tVar4;
                    }
                    ViewStub viewStub = tVar2.f444906g;
                    Intrinsics.checkNotNullExpressionValue(viewStub, "mTitleBinding.leftUserInfo");
                    tVar = new com.tencent.mobileqq.aio.title.notifyservice.b(aIOTitleRelativeLayout, viewStub);
                    tVar2 = tVar;
                }
                if (tVar2 != null) {
                    if (this.mChildVBPriority.contains(modelName) && (tVar2 instanceof n81.a)) {
                        this.mChildPriorityVBRecord.put(modelName, tVar2);
                    }
                    addChildVB(tVar2);
                    return;
                }
                return;
            }
            if (modelName.equals("troop_square_vb")) {
                w71.t tVar5 = this.mTitleBinding;
                if (tVar5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mTitleBinding");
                    tVar5 = null;
                }
                AIOTitleRelativeLayout aIOTitleRelativeLayout2 = tVar5.f444911l;
                Intrinsics.checkNotNullExpressionValue(aIOTitleRelativeLayout2, "mTitleBinding.titleLl");
                w71.t tVar6 = this.mTitleBinding;
                if (tVar6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mTitleBinding");
                } else {
                    tVar2 = tVar6;
                }
                ViewStub viewStub2 = tVar2.f444915p;
                Intrinsics.checkNotNullExpressionValue(viewStub2, "mTitleBinding.troopSquare");
                tVar = new TroopSquareTitleVB(aIOTitleRelativeLayout2, viewStub2, modelName, new Function1<String, Boolean>() { // from class: com.tencent.mobileqq.aio.title.AIOTitleVB$addChildByString$vb$2
                    static IPatchRedirector $redirector_;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(1);
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                            iPatchRedirector.redirect((short) 1, (Object) this, (Object) AIOTitleVB.this);
                        }
                    }

                    @Override // kotlin.jvm.functions.Function1
                    @NotNull
                    public final Boolean invoke(@NotNull String it) {
                        boolean F1;
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                            return (Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) it);
                        }
                        Intrinsics.checkNotNullParameter(it, "it");
                        F1 = AIOTitleVB.this.F1(it);
                        return Boolean.valueOf(F1);
                    }
                });
                tVar2 = tVar;
            }
            if (tVar2 != null) {
            }
        } else {
            if (modelName.equals("troop_guild_vb")) {
                w71.t tVar7 = this.mTitleBinding;
                if (tVar7 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mTitleBinding");
                    tVar7 = null;
                }
                AIOTitleRelativeLayout aIOTitleRelativeLayout3 = tVar7.f444911l;
                Intrinsics.checkNotNullExpressionValue(aIOTitleRelativeLayout3, "mTitleBinding.titleLl");
                w71.t tVar8 = this.mTitleBinding;
                if (tVar8 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mTitleBinding");
                } else {
                    tVar2 = tVar8;
                }
                ViewStub viewStub3 = tVar2.f444912m;
                Intrinsics.checkNotNullExpressionValue(viewStub3, "mTitleBinding.titleTab");
                tVar = new m81.f(aIOTitleRelativeLayout3, viewStub3, modelName, new Function1<String, Boolean>() { // from class: com.tencent.mobileqq.aio.title.AIOTitleVB$addChildByString$vb$1
                    static IPatchRedirector $redirector_;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(1);
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                            iPatchRedirector.redirect((short) 1, (Object) this, (Object) AIOTitleVB.this);
                        }
                    }

                    @Override // kotlin.jvm.functions.Function1
                    @NotNull
                    public final Boolean invoke(@NotNull String it) {
                        boolean F1;
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                            return (Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) it);
                        }
                        Intrinsics.checkNotNullParameter(it, "it");
                        F1 = AIOTitleVB.this.F1(it);
                        return Boolean.valueOf(F1);
                    }
                });
                tVar2 = tVar;
            }
            if (tVar2 != null) {
            }
        }
    }

    private final void m1() {
        TextView textView = new TextView(getMContext());
        textView.setText(R.string.qtl);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(11);
        layoutParams.addRule(15);
        layoutParams.setMarginEnd(ViewUtils.dpToPx(8.0f));
        textView.setLayoutParams(layoutParams);
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.aio.title.t
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AIOTitleVB.n1(AIOTitleVB.this, view);
            }
        });
        textView.setTextSize(17.0f);
        textView.setTextColor(getMContext().getResources().getColor(R.color.qui_common_text_nav_secondary));
        w71.t tVar = this.mTitleBinding;
        if (tVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTitleBinding");
            tVar = null;
        }
        tVar.f444911l.addView(textView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n1(AIOTitleVB this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.sendIntent(n.a.f193971d);
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void o1() {
        w71.u uVar = this.mRight3IvBinding;
        w71.t tVar = null;
        if (uVar != null) {
            if (uVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mRight3IvBinding");
                uVar = null;
            }
            uVar.f444920b.setVisibility(8);
        }
        w71.t tVar2 = this.mTitleBinding;
        if (tVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTitleBinding");
        } else {
            tVar = tVar2;
        }
        tVar.f444910k.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.aio.title.q
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AIOTitleVB.r1(view);
            }
        });
        tVar.f444905f.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.aio.title.r
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AIOTitleVB.p1(AIOTitleVB.this, view);
            }
        });
        tVar.f444916q.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.aio.title.s
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AIOTitleVB.q1(AIOTitleVB.this, view);
            }
        });
        int a16 = com.tencent.mobileqq.utils.x.a(5.0f);
        AIOUtil.f194084a.e(tVar.f444905f, a16, a16, a16, a16);
        w1(false, false);
        if (com.tencent.qqnt.util.b.f362976b.enableTalkBack()) {
            E1();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p1(AIOTitleVB this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.sendIntent(n.o.f193988d);
        com.tencent.mobileqq.aio.utils.b.f194119a.k("em_return_button_aio_pg");
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q1(AIOTitleVB this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.sendIntent(n.j.f193982d);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r1(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void u1() {
        int i3;
        if (ImmersiveUtils.isSupporImmersive() == 1) {
            i3 = ImmersiveUtils.getStatusBarHeight(getMContext());
        } else {
            i3 = 0;
        }
        final int dimension = (int) getMContext().getResources().getDimension(R.dimen.f158287c11);
        w71.t tVar = this.mTitleBinding;
        if (tVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTitleBinding");
            tVar = null;
        }
        final int paddingTop = tVar.f444910k.getPaddingTop();
        ValueAnimator ofInt = ValueAnimator.ofInt(paddingTop, i3);
        ofInt.setDuration(300L);
        ofInt.setInterpolator(new LinearInterpolator());
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tencent.mobileqq.aio.title.u
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                AIOTitleVB.v1(AIOTitleVB.this, dimension, paddingTop, valueAnimator);
            }
        });
        ofInt.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void v1(AIOTitleVB this$0, int i3, int i16, ValueAnimator valueAnimator) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Object animatedValue = valueAnimator.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Int");
        int intValue = ((Integer) animatedValue).intValue();
        w71.t tVar = this$0.mTitleBinding;
        if (tVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTitleBinding");
            tVar = null;
        }
        RelativeLayout relativeLayout = tVar.f444910k;
        relativeLayout.setPadding(relativeLayout.getPaddingLeft(), intValue, relativeLayout.getPaddingRight(), relativeLayout.getPaddingBottom());
        this$0.sendIntent(new n.i(i3 + intValue, intValue - i16));
    }

    private final void w1(boolean isSelectMode, boolean isScaleChat) {
        Integer num;
        w71.t tVar = this.mTitleBinding;
        w71.u uVar = null;
        if (tVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTitleBinding");
            tVar = null;
        }
        TextView textView = tVar.f444905f;
        textView.setTextColor(AppCompatResources.getColorStateList(getMContext(), R.color.qui_common_text_nav_secondary));
        if (isSelectMode) {
            textView.setText(getMContext().getText(R.string.f170256ys3));
            textView.setBackground(null);
            textView.setContentDescription(textView.getText());
        } else {
            textView.setText("");
            M1(isScaleChat, isSelectMode);
        }
        w71.t tVar2 = this.mTitleBinding;
        if (tVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTitleBinding");
            tVar2 = null;
        }
        ViewGroup.LayoutParams layoutParams = tVar2.f444914o.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
        boolean z16 = false;
        float f16 = 8.0f;
        if (isSelectMode) {
            w71.t tVar3 = this.mTitleBinding;
            if (tVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mTitleBinding");
                tVar3 = null;
            }
            QUIBadgeMosaic qUIBadgeMosaic = tVar3.f444916q;
            w71.t tVar4 = this.mTitleBinding;
            if (tVar4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mTitleBinding");
                tVar4 = null;
            }
            qUIBadgeMosaic.setTag(Integer.valueOf(tVar4.f444916q.getVisibility()));
            w71.t tVar5 = this.mTitleBinding;
            if (tVar5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mTitleBinding");
                tVar5 = null;
            }
            tVar5.f444916q.setVisibility(8);
            layoutParams2.setMarginStart(com.tencent.mobileqq.utils.x.a(8.0f));
            w71.u uVar2 = this.mRight3IvBinding;
            if (uVar2 != null) {
                if (uVar2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mRight3IvBinding");
                    uVar2 = null;
                }
                RedDotImageView redDotImageView = uVar2.f444920b;
                w71.u uVar3 = this.mRight3IvBinding;
                if (uVar3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mRight3IvBinding");
                } else {
                    uVar = uVar3;
                }
                redDotImageView.setTag(Integer.valueOf(uVar.f444920b.getVisibility()));
                J1(false, "");
                return;
            }
            return;
        }
        w71.t tVar6 = this.mTitleBinding;
        if (tVar6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTitleBinding");
            tVar6 = null;
        }
        Object tag = tVar6.f444916q.getTag();
        if (tag instanceof Integer) {
            num = (Integer) tag;
        } else {
            num = null;
        }
        if (num != null) {
            int intValue = num.intValue();
            w71.t tVar7 = this.mTitleBinding;
            if (tVar7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mTitleBinding");
                tVar7 = null;
            }
            tVar7.f444916q.setVisibility(intValue);
        }
        w71.t tVar8 = this.mTitleBinding;
        if (tVar8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTitleBinding");
            tVar8 = null;
        }
        if (tVar8.f444916q.getVisibility() != 0) {
            f16 = 4.0f;
        }
        layoutParams2.setMarginStart(com.tencent.mobileqq.utils.x.a(f16));
        w71.u uVar4 = this.mRight3IvBinding;
        if (uVar4 != null) {
            if (uVar4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mRight3IvBinding");
                uVar4 = null;
            }
            if (uVar4.f444920b.getTag() != null) {
                Object j3 = com.tencent.mobileqq.aio.utils.b.f194119a.j("em_bas_aio_top_feature_entry_left", "");
                Intrinsics.checkNotNull(j3, "null cannot be cast to non-null type kotlin.String");
                String str = (String) j3;
                w71.u uVar5 = this.mRight3IvBinding;
                if (uVar5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mRight3IvBinding");
                } else {
                    uVar = uVar5;
                }
                Object tag2 = uVar.f444920b.getTag();
                Intrinsics.checkNotNull(tag2, "null cannot be cast to non-null type kotlin.Int");
                if (((Integer) tag2).intValue() == 0) {
                    z16 = true;
                }
                J1(z16, str);
            }
        }
    }

    private final void y1(boolean isZplan) {
        String str;
        w71.u uVar = null;
        if (this.mRight3IvBinding == null) {
            LayoutInflater from = LayoutInflater.from(getMContext());
            w71.t tVar = this.mTitleBinding;
            if (tVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mTitleBinding");
                tVar = null;
            }
            w71.u g16 = w71.u.g(from, tVar.f444911l, true);
            Intrinsics.checkNotNullExpressionValue(g16, "inflate(LayoutInflater.f\u2026tleBinding.titleLl, true)");
            this.mRight3IvBinding = g16;
        }
        w71.u uVar2 = this.mRight3IvBinding;
        if (uVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRight3IvBinding");
        } else {
            uVar = uVar2;
        }
        RedDotImageView redDotImageView = uVar.f444920b;
        if (isZplan) {
            str = HardCodeUtil.qqStr(R.string.f170303yu4);
        } else {
            str = "";
        }
        redDotImageView.setContentDescription(str);
    }

    private final void z1() {
        ThreadManagerV2.getUIHandlerV2().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.aio.title.w
            @Override // java.lang.Runnable
            public final void run() {
                AIOTitleVB.A1(AIOTitleVB.this);
            }
        }, 100L);
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    public void bindViewAndData() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        super.bindViewAndData();
        o1();
        sendIntent(n.d.f193974d);
        n.c cVar = new n.c(0, 1, null);
        sendIntent(cVar);
        if (cVar.a() == 2) {
            l1("troop_guild_vb");
            l1("troop_square_vb");
        } else if (cVar.a() == 118 || cVar.a() == 201) {
            l1("notify_service_vb");
        }
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    @NotNull
    public List<Class<? extends AIOTitleUIState>> getObserverStates() {
        List<Class<? extends AIOTitleUIState>> listOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 6)) {
            listOf = CollectionsKt__CollectionsJVMKt.listOf(AIOTitleUIState.UpdateData.class);
            return listOf;
        }
        return (List) iPatchRedirector.redirect((short) 6, (Object) this);
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    @NotNull
    public List<com.tencent.aio.base.mvvm.a<? extends ol3.b, ? extends MviUIState>> initializeChildVB(@NotNull View hostView) {
        List<com.tencent.aio.base.mvvm.a<? extends ol3.b, ? extends MviUIState>> mutableListOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (List) iPatchRedirector.redirect((short) 5, (Object) this, (Object) hostView);
        }
        Intrinsics.checkNotNullParameter(hostView, "hostView");
        this.mCenterVB = new CenterVB(new Function0<w71.t>() { // from class: com.tencent.mobileqq.aio.title.AIOTitleVB$initializeChildVB$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AIOTitleVB.this);
                }
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final w71.t invoke() {
                w71.t tVar;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (w71.t) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
                tVar = AIOTitleVB.this.mTitleBinding;
                if (tVar != null) {
                    return tVar;
                }
                Intrinsics.throwUninitializedPropertyAccessException("mTitleBinding");
                return null;
            }
        });
        CenterVB centerVB = this.mCenterVB;
        Intrinsics.checkNotNull(centerVB);
        mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(new Right1VB(new Function0<RedDotImageView>() { // from class: com.tencent.mobileqq.aio.title.AIOTitleVB$initializeChildVB$list$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AIOTitleVB.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final RedDotImageView invoke() {
                w71.t tVar;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (RedDotImageView) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
                tVar = AIOTitleVB.this.mTitleBinding;
                if (tVar == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mTitleBinding");
                    tVar = null;
                }
                RedDotImageView redDotImageView = tVar.f444907h;
                Intrinsics.checkNotNullExpressionValue(redDotImageView, "mTitleBinding.right1Iv");
                return redDotImageView;
            }
        }), new Right2VB(new Function0<RedDotImageView>() { // from class: com.tencent.mobileqq.aio.title.AIOTitleVB$initializeChildVB$list$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AIOTitleVB.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final RedDotImageView invoke() {
                w71.t tVar;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (RedDotImageView) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
                tVar = AIOTitleVB.this.mTitleBinding;
                if (tVar == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mTitleBinding");
                    tVar = null;
                }
                RedDotImageView redDotImageView = tVar.f444908i;
                Intrinsics.checkNotNullExpressionValue(redDotImageView, "mTitleBinding.right2Iv");
                return redDotImageView;
            }
        }), centerVB);
        return mutableListOf;
    }

    @Override // com.tencent.mvi.mvvm.b
    @NotNull
    public View onCreateView(@NotNull com.tencent.mvi.api.help.a createViewParams) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (View) iPatchRedirector.redirect((short) 2, (Object) this, (Object) createViewParams);
        }
        Intrinsics.checkNotNullParameter(createViewParams, "createViewParams");
        w71.t g16 = w71.t.g(LayoutInflater.from(createViewParams.a()), createViewParams.b(), false);
        Intrinsics.checkNotNullExpressionValue(g16, "inflate(inflater, createViewParams.parent, false)");
        this.mTitleBinding = g16;
        if (g16 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTitleBinding");
            g16 = null;
        }
        RelativeLayout root = g16.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "mTitleBinding.root");
        return root;
    }

    @Override // com.tencent.mvi.mvvm.BaseVB, com.tencent.mvi.mvvm.framework.FrameworkVB
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        this.currentChildVBPriority = null;
        this.mChildPriorityVBRecord.clear();
        B1(false, "");
        super.onDestroy();
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    @NotNull
    /* renamed from: s1, reason: merged with bridge method [inline-methods] */
    public com.tencent.aio.base.mvvm.b<n, AIOTitleUIState> createVM() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (com.tencent.aio.base.mvvm.b) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return new AIOTitleVM();
    }

    @Override // com.tencent.mvi.mvvm.BaseVB
    /* renamed from: x1, reason: merged with bridge method [inline-methods] */
    public void handleUIState(@NotNull AIOTitleUIState state) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) state);
            return;
        }
        Intrinsics.checkNotNullParameter(state, "state");
        if (state instanceof AIOTitleUIState.UpdateData) {
            K1(((AIOTitleUIState.UpdateData) state).a());
            return;
        }
        if (state instanceof AIOTitleUIState.MultiSelectModeChangeState) {
            AIOTitleUIState.MultiSelectModeChangeState multiSelectModeChangeState = (AIOTitleUIState.MultiSelectModeChangeState) state;
            w1(multiSelectModeChangeState.b(), multiSelectModeChangeState.a());
            return;
        }
        if (state instanceof AIOTitleUIState.PushShotTitleBitmap) {
            z1();
            return;
        }
        if (state instanceof AIOTitleUIState.UpdateUnread) {
            AIOTitleUIState.UpdateUnread updateUnread = (AIOTitleUIState.UpdateUnread) state;
            N1(updateUnread.a(), updateUnread.b(), true, updateUnread.c());
            return;
        }
        if (state instanceof AIOTitleUIState.UpdateRight3IvState) {
            H1(((AIOTitleUIState.UpdateRight3IvState) state).a());
            return;
        }
        if (state instanceof AIOTitleUIState.UpdateZplanState) {
            O1(((AIOTitleUIState.UpdateZplanState) state).a());
            return;
        }
        if (state instanceof AIOTitleUIState.AddFinishBtn) {
            m1();
        } else if (state instanceof AIOTitleUIState.ResetAccessibilityFocus) {
            D1();
        } else if (state instanceof AIOTitleUIState.ExpandFullScreenAnim) {
            u1();
        }
    }
}
