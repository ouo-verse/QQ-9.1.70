package com.tencent.ecommerce.biz.register.refactoring.fragment;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.util.Base64;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import cg0.a;
import com.qzone.proxy.personalitycomponent.model.WidgetCacheLunarData;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.ecommerce.base.QQECChannel;
import com.tencent.ecommerce.base.QQEcommerceSdk;
import com.tencent.ecommerce.base.eventbus.EventObserver;
import com.tencent.ecommerce.base.eventbus.LifecycleEventBus;
import com.tencent.ecommerce.base.eventbus.ThreadMode;
import com.tencent.ecommerce.base.fragment.ECBaseFragment;
import com.tencent.ecommerce.base.list.IStateCenterView;
import com.tencent.ecommerce.base.ui.ECSkin;
import com.tencent.ecommerce.base.ui.api.ECToastIcon;
import com.tencent.ecommerce.base.ui.api.IECCoreSkinApi;
import com.tencent.ecommerce.base.ui.i;
import com.tencent.ecommerce.base.ui.stateview.ECStateCenterView;
import com.tencent.ecommerce.biz.common.ECMsgBoxDialog;
import com.tencent.ecommerce.biz.register.refactoring.dialog.ECRegisterCommonDialog;
import com.tencent.ecommerce.biz.register.refactoring.repo.ECommerceRegisterRepo;
import com.tencent.ecommerce.biz.register.refactoring.repo.IECRegisterConditionCallback;
import com.tencent.ecommerce.biz.register.refactoring.repo.IECRegisterStatusCallback;
import com.tencent.ecommerce.biz.register.refactoring.utils.ECRegisterReportScene;
import com.tencent.ecommerce.biz.register.refactoring.utils.ECRegisterSuccessEvent;
import com.tencent.ecommerce.biz.register.refactoring.viewmodel.ECRegisterIntroViewModel;
import com.tencent.ecommerce.biz.router.ECScheme;
import com.tencent.ecommerce.biz.util.r;
import com.tencent.ecommerce.repo.register.ECMsgBox;
import com.tencent.ecommerce.repo.register.ECMsgBoxBtn;
import com.tencent.ecommerce.repo.register.ECRegisterRespStatus;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.nio.charset.StandardCharsets;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.apache.httpcore.message.TokenParser;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 j2\u00020\u0001:\u0003klmB\u0007\u00a2\u0006\u0004\bh\u0010iJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0012\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\u001a\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\b\u0010\u000b\u001a\u00020\u0006H\u0016J\b\u0010\r\u001a\u00020\fH\u0016J\b\u0010\u000f\u001a\u00020\u000eH\u0016J\b\u0010\u0010\u001a\u00020\fH\u0016J\b\u0010\u0011\u001a\u00020\u0006H\u0002J\b\u0010\u0012\u001a\u00020\u0006H\u0002J\b\u0010\u0013\u001a\u00020\u0006H\u0002J\b\u0010\u0014\u001a\u00020\u0006H\u0002J\b\u0010\u0015\u001a\u00020\u0006H\u0002J\b\u0010\u0016\u001a\u00020\u0006H\u0002J\u001c\u0010\u0019\u001a\u00020\u00062\b\u0010\u0017\u001a\u0004\u0018\u00010\u000e2\b\b\u0002\u0010\u0018\u001a\u00020\fH\u0002J\u0010\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u001aH\u0002J\u0010\u0010\u001e\u001a\u00020\u00062\u0006\u0010\u001d\u001a\u00020\fH\u0002J\b\u0010\u001f\u001a\u00020\u0006H\u0002J\b\u0010 \u001a\u00020\fH\u0002R\u0016\u0010$\u001a\u00020!8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u0016\u0010(\u001a\u00020%8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b&\u0010'R\u0016\u0010,\u001a\u00020)8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b*\u0010+R\u0016\u0010.\u001a\u00020)8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b-\u0010+R\u0016\u00102\u001a\u00020/8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b0\u00101R\u0016\u00104\u001a\u00020/8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b3\u00101R\u0016\u00106\u001a\u00020)8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b5\u0010+R\u0016\u00108\u001a\u00020/8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b7\u00101R\u0016\u0010:\u001a\u00020/8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b9\u00101R\u0016\u0010<\u001a\u00020)8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b;\u0010+R\u0016\u0010>\u001a\u00020/8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b=\u00101R\u0016\u0010@\u001a\u00020/8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b?\u00101R\u0016\u0010D\u001a\u00020A8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bB\u0010CR\u0018\u0010H\u001a\u0004\u0018\u00010E8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bF\u0010GR\u0018\u0010K\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bI\u0010JR\u0016\u0010M\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bL\u0010JR\u0016\u0010O\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bN\u0010=R\u0016\u0010Q\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bP\u0010=R\u0018\u0010\u001d\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bR\u0010SR\u0016\u0010V\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bT\u0010UR\u0016\u0010X\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bW\u0010JR\u0018\u0010\\\u001a\u0004\u0018\u00010Y8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bZ\u0010[R\u001a\u0010a\u001a\b\u0012\u0004\u0012\u00020^0]8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b_\u0010`R\u001b\u0010g\u001a\u00020b8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bc\u0010d\u001a\u0004\be\u0010f\u00a8\u0006n"}, d2 = {"Lcom/tencent/ecommerce/biz/register/refactoring/fragment/ECommerceRegisterIntroFragment;", "Lcom/tencent/ecommerce/base/fragment/ECBaseFragment;", "", "getContentLayoutId", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "", "onCreate", "Landroid/view/View;", "view", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, MosaicConstants$JsFunction.FUNC_ON_DESTROY, "", "onBackPressed", "", "getBusinessDescription", "Eh", "initUI", "ii", "initListener", "ei", "fi", "gi", "url", "isRightBtn", "ci", "Lorg/json/JSONObject;", "jsonObj", "Zh", "isRegistered", "bi", WidgetCacheLunarData.JI, "hi", "Landroid/widget/ImageButton;", "P", "Landroid/widget/ImageButton;", "backBtn", "Landroid/widget/Button;", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Landroid/widget/Button;", "nextStepBtn", "Landroid/widget/LinearLayout;", BdhLogUtil.LogTag.Tag_Req, "Landroid/widget/LinearLayout;", "conditionsView", ExifInterface.LATITUDE_SOUTH, "worksNumContainer", "Landroid/widget/TextView;", "T", "Landroid/widget/TextView;", "worksNumTv", "U", "worksNumStateTv", "V", "preWeekWorksNumContainer", "W", "preWeekWorksNumTv", "X", "preWeekWorksNumStateTv", "Y", "fansNumContainer", "Z", "fansNumTv", "a0", "fansNumStateTv", "Lcom/tencent/ecommerce/base/ui/stateview/ECStateCenterView;", "b0", "Lcom/tencent/ecommerce/base/ui/stateview/ECStateCenterView;", "stateCenterView", "Lcom/tencent/ecommerce/biz/common/ECMsgBoxDialog;", "c0", "Lcom/tencent/ecommerce/biz/common/ECMsgBoxDialog;", "unbindPromoterDialog", "d0", "Ljava/lang/String;", WadlProxyConsts.CHANNEL, "e0", "jumpScheme", "f0", "regConditionPassed", "g0", "needConditionCheck", "h0", "Ljava/lang/Boolean;", "i0", "I", "registerRole", "j0", "deliverProductCallbackId", "Lcom/tencent/ecommerce/repo/register/ECMsgBox;", "k0", "Lcom/tencent/ecommerce/repo/register/ECMsgBox;", "msgBox", "Lcom/tencent/ecommerce/base/eventbus/EventObserver;", "Lcom/tencent/ecommerce/biz/register/refactoring/utils/c;", "l0", "Lcom/tencent/ecommerce/base/eventbus/EventObserver;", "successRegisteredEventObserve", "Lcom/tencent/ecommerce/biz/register/refactoring/viewmodel/ECRegisterIntroViewModel;", "m0", "Lkotlin/Lazy;", "ai", "()Lcom/tencent/ecommerce/biz/register/refactoring/viewmodel/ECRegisterIntroViewModel;", "viewModel", "<init>", "()V", "n0", "a", "RoleType", "WhiteBoxImageType", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class ECommerceRegisterIntroFragment extends ECBaseFragment {

    /* renamed from: P, reason: from kotlin metadata */
    private ImageButton backBtn;

    /* renamed from: Q, reason: from kotlin metadata */
    private Button nextStepBtn;

    /* renamed from: R, reason: from kotlin metadata */
    private LinearLayout conditionsView;

    /* renamed from: S, reason: from kotlin metadata */
    private LinearLayout worksNumContainer;

    /* renamed from: T, reason: from kotlin metadata */
    private TextView worksNumTv;

    /* renamed from: U, reason: from kotlin metadata */
    private TextView worksNumStateTv;

    /* renamed from: V, reason: from kotlin metadata */
    private LinearLayout preWeekWorksNumContainer;

    /* renamed from: W, reason: from kotlin metadata */
    private TextView preWeekWorksNumTv;

    /* renamed from: X, reason: from kotlin metadata */
    private TextView preWeekWorksNumStateTv;

    /* renamed from: Y, reason: from kotlin metadata */
    private LinearLayout fansNumContainer;

    /* renamed from: Z, reason: from kotlin metadata */
    private TextView fansNumTv;

    /* renamed from: a0, reason: collision with root package name and from kotlin metadata */
    private TextView fansNumStateTv;

    /* renamed from: b0, reason: collision with root package name and from kotlin metadata */
    private ECStateCenterView stateCenterView;

    /* renamed from: c0, reason: collision with root package name and from kotlin metadata */
    private ECMsgBoxDialog unbindPromoterDialog;

    /* renamed from: d0, reason: collision with root package name and from kotlin metadata */
    private String channel;

    /* renamed from: h0, reason: collision with root package name and from kotlin metadata */
    private Boolean isRegistered;

    /* renamed from: i0, reason: collision with root package name and from kotlin metadata */
    private int registerRole;

    /* renamed from: k0, reason: collision with root package name and from kotlin metadata */
    private ECMsgBox msgBox;

    /* renamed from: m0, reason: collision with root package name and from kotlin metadata */
    private final Lazy viewModel;

    /* renamed from: e0, reason: collision with root package name and from kotlin metadata */
    private String jumpScheme = "";

    /* renamed from: f0, reason: collision with root package name and from kotlin metadata */
    private boolean regConditionPassed = true;

    /* renamed from: g0, reason: collision with root package name and from kotlin metadata */
    private boolean needConditionCheck = true;

    /* renamed from: j0, reason: collision with root package name and from kotlin metadata */
    private String deliverProductCallbackId = "";

    /* renamed from: l0, reason: collision with root package name and from kotlin metadata */
    private final EventObserver<ECRegisterSuccessEvent> successRegisteredEventObserve = new g();

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t\u00a8\u0006\n"}, d2 = {"Lcom/tencent/ecommerce/biz/register/refactoring/fragment/ECommerceRegisterIntroFragment$RoleType;", "", "type", "", "(Ljava/lang/String;II)V", "ROLE_TYPE_NONE", "ROLE_TYPE_NEW_PERSONA", "ROLE_TYPE_OLD_PERSONA", "ROLE_TYPE_OLD_MCN", "ROLE_TYPE_NEW_MCN", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public enum RoleType {
        ROLE_TYPE_NONE(0),
        ROLE_TYPE_NEW_PERSONA(1),
        ROLE_TYPE_OLD_PERSONA(2),
        ROLE_TYPE_OLD_MCN(3),
        ROLE_TYPE_NEW_MCN(4);

        RoleType(int i3) {
        }
    }

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/ecommerce/biz/register/refactoring/fragment/ECommerceRegisterIntroFragment$WhiteBoxImageType;", "", "(Ljava/lang/String;I)V", "UNKNOWN", "HISTORY_VIDEO", "RECENT_VIDEO", "FANS", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public enum WhiteBoxImageType {
        UNKNOWN,
        HISTORY_VIDEO,
        RECENT_VIDEO,
        FANS
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", NodeProps.ON_CLICK}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            FragmentActivity activity = ECommerceRegisterIntroFragment.this.getActivity();
            if (activity != null) {
                activity.finish();
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", NodeProps.ON_CLICK}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class c implements View.OnClickListener {

        /* compiled from: P */
        @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J*\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/ecommerce/biz/register/refactoring/fragment/ECommerceRegisterIntroFragment$c$a", "Lcom/tencent/ecommerce/biz/register/refactoring/repo/IECRegisterStatusCallback;", "", "isRegistered", "", "mediaID", "", "role", "Lcom/tencent/ecommerce/repo/register/ECMsgBox;", "msgBox", "", "onCheck", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
        /* loaded from: classes31.dex */
        public static final class a implements IECRegisterStatusCallback {
            a() {
            }

            @Override // com.tencent.ecommerce.biz.register.refactoring.repo.IECRegisterStatusCallback
            public void onCheck(boolean isRegistered, String mediaID, int role, ECMsgBox msgBox) {
                ECommerceRegisterIntroFragment.this.gi();
                ECommerceRegisterIntroFragment.this.bi(isRegistered);
            }
        }

        c() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            com.tencent.ecommerce.biz.register.a aVar = com.tencent.ecommerce.biz.register.a.f103962b;
            aVar.j(1, ECRegisterReportScene.INTRO_PAGE_GO_ON_BTN_CLK.sceneType, !ECommerceRegisterIntroFragment.this.regConditionPassed ? 1 : 0);
            if (ECommerceRegisterIntroFragment.this.regConditionPassed) {
                Boolean bool = ECommerceRegisterIntroFragment.this.isRegistered;
                if (bool != null) {
                    ECommerceRegisterIntroFragment.this.bi(bool.booleanValue());
                }
                if (ECommerceRegisterIntroFragment.this.isRegistered == null) {
                    ECommerceRegisterRepo.f104099a.c(new a());
                }
            } else {
                ECRegisterCommonDialog.q(ECRegisterCommonDialog.f104005a, ECRegisterRespStatus.REGISTER_ERROR_CODE_NOT_MEET_CONDITION.status, ECommerceRegisterIntroFragment.this.requireContext(), null, 4, null);
            }
            hg0.a.c(hg0.a.f404850b, "ECRegisterIntroductionNext", null, 2, null);
            aVar.c();
            aVar.f();
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n\u00a2\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "kotlin.jvm.PlatformType", "it", "", "a", "(Ljava/lang/Boolean;)V"}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class d<T> implements Observer<Boolean> {
        d() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void onChanged(Boolean bool) {
            ECommerceRegisterIntroFragment.Qh(ECommerceRegisterIntroFragment.this).setSucceededState();
            if (bool.booleanValue()) {
                ECMsgBoxDialog eCMsgBoxDialog = ECommerceRegisterIntroFragment.this.unbindPromoterDialog;
                if (eCMsgBoxDialog != null) {
                    eCMsgBoxDialog.q0(true);
                }
                i.f101155b.d("\u63a8\u5e7f\u5458\u89e3\u7ed1\u6210\u529f\uff01", ECToastIcon.ICON_SUCCESS, 0);
                return;
            }
            i.f101155b.d("\u89e3\u7ed1\u5931\u8d25\uff0c\u8bf7\u7a0d\u540e\u91cd\u8bd5\uff01", ECToastIcon.ICON_ERROR, 0);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/ecommerce/biz/register/refactoring/fragment/ECommerceRegisterIntroFragment$e", "Lcom/tencent/ecommerce/biz/register/refactoring/repo/IECRegisterConditionCallback;", "Lorg/json/JSONArray;", "conditions", "", "onCheck", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class e implements IECRegisterConditionCallback {
        e() {
        }

        @Override // com.tencent.ecommerce.biz.register.refactoring.repo.IECRegisterConditionCallback
        public void onCheck(JSONArray conditions) {
            a.b("ECommerceRegisterIntroFragment", "[initRegConditionUI] needConditionCheck = " + ECommerceRegisterIntroFragment.this.needConditionCheck + ", conditions=" + conditions);
            if (ECommerceRegisterIntroFragment.this.needConditionCheck) {
                ECommerceRegisterIntroFragment.this.regConditionPassed = conditions.length() > 0;
                ECommerceRegisterIntroFragment.Mh(ECommerceRegisterIntroFragment.this).setVisibility(ECommerceRegisterIntroFragment.this.regConditionPassed ? 0 : 8);
                int length = conditions.length();
                for (int i3 = 0; i3 < length; i3++) {
                    JSONObject jSONObject = conditions.getJSONObject(i3);
                    boolean optBoolean = jSONObject.optBoolean("is_reach_threshold", false);
                    ECommerceRegisterIntroFragment eCommerceRegisterIntroFragment = ECommerceRegisterIntroFragment.this;
                    eCommerceRegisterIntroFragment.regConditionPassed = optBoolean & eCommerceRegisterIntroFragment.regConditionPassed;
                    ECommerceRegisterIntroFragment.this.Zh(jSONObject);
                }
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002#\u0012\u0015\u0012\u0013\u0018\u00010\u0002\u00a2\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\u0004\u0012\u00020\u00060\u0001j\u0002`\u0007J\u0013\u0010\b\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0096\u0002\u00a8\u0006\t"}, d2 = {"com/tencent/ecommerce/biz/register/refactoring/fragment/ECommerceRegisterIntroFragment$f", "Lkotlin/Function1;", "Landroid/graphics/drawable/Drawable;", "Lkotlin/ParameterName;", "name", "drawable", "", "Lcom/tencent/ecommerce/base/imageloader/api/Callback;", "a", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class f implements Function1<Drawable, Unit> {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ ImageView f104069d;

        f(ImageView imageView) {
            this.f104069d = imageView;
        }

        public void a(Drawable drawable) {
            this.f104069d.setImageDrawable(drawable);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Drawable drawable) {
            a(drawable);
            return Unit.INSTANCE;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n\u00a2\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/tencent/ecommerce/biz/register/refactoring/utils/c;", "it", "", "a", "(Lcom/tencent/ecommerce/biz/register/refactoring/utils/c;)V"}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    static final class g<T> implements EventObserver<ECRegisterSuccessEvent> {
        g() {
        }

        @Override // com.tencent.ecommerce.base.eventbus.EventObserver
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void onEvent(ECRegisterSuccessEvent eCRegisterSuccessEvent) {
            FragmentActivity activity = ECommerceRegisterIntroFragment.this.getActivity();
            if (activity != null) {
                activity.finish();
            }
        }
    }

    public ECommerceRegisterIntroFragment() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<ECRegisterIntroViewModel>() { // from class: com.tencent.ecommerce.biz.register.refactoring.fragment.ECommerceRegisterIntroFragment$viewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ECRegisterIntroViewModel invoke() {
                return (ECRegisterIntroViewModel) new ViewModelProvider(ECommerceRegisterIntroFragment.this).get(ECRegisterIntroViewModel.class);
            }
        });
        this.viewModel = lazy;
    }

    public static final /* synthetic */ LinearLayout Mh(ECommerceRegisterIntroFragment eCommerceRegisterIntroFragment) {
        LinearLayout linearLayout = eCommerceRegisterIntroFragment.conditionsView;
        if (linearLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("conditionsView");
        }
        return linearLayout;
    }

    public static final /* synthetic */ ECStateCenterView Qh(ECommerceRegisterIntroFragment eCommerceRegisterIntroFragment) {
        ECStateCenterView eCStateCenterView = eCommerceRegisterIntroFragment.stateCenterView;
        if (eCStateCenterView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("stateCenterView");
        }
        return eCStateCenterView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Zh(JSONObject jsonObj) {
        Resources resources;
        int i3;
        boolean optBoolean = jsonObj.optBoolean("is_reach_threshold", false);
        int optInt = jsonObj.optInt("threshold", 0);
        int optInt2 = jsonObj.optInt("img_type", 0);
        String optString = jsonObj.optString("label");
        if (optString == null) {
            optString = "";
        }
        String str = optString + TokenParser.SP + optInt;
        int i16 = optBoolean ? R.color.f6401g : R.color.f6421i;
        String str2 = null;
        if (optBoolean) {
            Context context = getContext();
            if (context != null && (resources = context.getResources()) != null) {
                i3 = R.string.f169579we3;
                str2 = resources.getString(i3);
            }
        } else {
            Context context2 = getContext();
            if (context2 != null && (resources = context2.getResources()) != null) {
                i3 = R.string.we7;
                str2 = resources.getString(i3);
            }
        }
        if (optInt2 == WhiteBoxImageType.HISTORY_VIDEO.ordinal()) {
            LinearLayout linearLayout = this.worksNumContainer;
            if (linearLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException("worksNumContainer");
            }
            linearLayout.setVisibility(0);
            TextView textView = this.worksNumTv;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("worksNumTv");
            }
            textView.setText(str);
            TextView textView2 = this.worksNumStateTv;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("worksNumStateTv");
            }
            textView2.setTextColor(ContextCompat.getColor(requireContext(), i16));
            textView2.setText(str2);
            return;
        }
        if (optInt2 == WhiteBoxImageType.RECENT_VIDEO.ordinal()) {
            LinearLayout linearLayout2 = this.preWeekWorksNumContainer;
            if (linearLayout2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("preWeekWorksNumContainer");
            }
            linearLayout2.setVisibility(0);
            TextView textView3 = this.preWeekWorksNumTv;
            if (textView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("preWeekWorksNumTv");
            }
            textView3.setText(str);
            TextView textView4 = this.preWeekWorksNumStateTv;
            if (textView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("preWeekWorksNumStateTv");
            }
            textView4.setTextColor(ContextCompat.getColor(requireContext(), i16));
            textView4.setText(str2);
            return;
        }
        if (optInt2 == WhiteBoxImageType.FANS.ordinal()) {
            LinearLayout linearLayout3 = this.fansNumContainer;
            if (linearLayout3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("fansNumContainer");
            }
            linearLayout3.setVisibility(0);
            TextView textView5 = this.fansNumTv;
            if (textView5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("fansNumTv");
            }
            textView5.setText(str);
            TextView textView6 = this.fansNumStateTv;
            if (textView6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("fansNumStateTv");
            }
            textView6.setTextColor(ContextCompat.getColor(requireContext(), i16));
            textView6.setText(str2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ECRegisterIntroViewModel ai() {
        return (ECRegisterIntroViewModel) this.viewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void bi(boolean isRegistered) {
        ECMsgBoxDialog eCMsgBoxDialog = this.unbindPromoterDialog;
        if (eCMsgBoxDialog != null && !eCMsgBoxDialog.getIsDisabled()) {
            eCMsgBoxDialog.show();
        } else if (isRegistered) {
            com.tencent.ecommerce.biz.register.refactoring.utils.b.b(com.tencent.ecommerce.biz.register.refactoring.utils.b.f104104a, this.jumpScheme, this.deliverProductCallbackId, null, 4, null);
        } else {
            com.tencent.ecommerce.biz.register.refactoring.utils.b.f104104a.c(this.registerRole, this.jumpScheme, this.deliverProductCallbackId);
        }
    }

    private final void ei() {
        ai().M1().observe(getViewLifecycleOwner(), new d());
    }

    private final void fi() {
        ECommerceRegisterRepo eCommerceRegisterRepo = ECommerceRegisterRepo.f104099a;
        String str = this.channel;
        if (str == null) {
            str = "";
        }
        eCommerceRegisterRepo.b(str, String.valueOf(QQEcommerceSdk.INSTANCE.getGlobalInternalSdk().getAccountManager().getCurrentAccount()), new e());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void gi() {
        ECMsgBox eCMsgBox = this.msgBox;
        if (eCMsgBox != null) {
            ECMsgBoxDialog eCMsgBoxDialog = new ECMsgBoxDialog(requireContext(), eCMsgBox, requireActivity());
            eCMsgBoxDialog.a0(new Function1<View, Unit>() { // from class: com.tencent.ecommerce.biz.register.refactoring.fragment.ECommerceRegisterIntroFragment$initUnBindPromoterDialogUI$$inlined$let$lambda$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(View view) {
                    invoke2(view);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(View view) {
                    ECMsgBox eCMsgBox2;
                    ECMsgBoxBtn eCMsgBoxBtn;
                    ECommerceRegisterIntroFragment eCommerceRegisterIntroFragment = ECommerceRegisterIntroFragment.this;
                    eCMsgBox2 = eCommerceRegisterIntroFragment.msgBox;
                    ECommerceRegisterIntroFragment.di(eCommerceRegisterIntroFragment, (eCMsgBox2 == null || (eCMsgBoxBtn = eCMsgBox2.leftBtn) == null) ? null : eCMsgBoxBtn.url, false, 2, null);
                }
            });
            eCMsgBoxDialog.e0(new Function1<View, Unit>() { // from class: com.tencent.ecommerce.biz.register.refactoring.fragment.ECommerceRegisterIntroFragment$initUnBindPromoterDialogUI$$inlined$let$lambda$2
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(View view) {
                    invoke2(view);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(View view) {
                    ECMsgBox eCMsgBox2;
                    ECMsgBoxBtn rightBtn;
                    ECommerceRegisterIntroFragment eCommerceRegisterIntroFragment = ECommerceRegisterIntroFragment.this;
                    eCMsgBox2 = eCommerceRegisterIntroFragment.msgBox;
                    eCommerceRegisterIntroFragment.ci((eCMsgBox2 == null || (rightBtn = eCMsgBox2.getRightBtn()) == null) ? null : rightBtn.url, true);
                }
            });
            Window window = eCMsgBoxDialog.getWindow();
            if (window != null) {
                window.setWindowAnimations(R.style.f173269ze);
            }
            Unit unit = Unit.INSTANCE;
            this.unbindPromoterDialog = eCMsgBoxDialog;
        }
    }

    private final boolean hi() {
        return Intrinsics.areEqual(this.channel, String.valueOf(QQECChannel.CHANNEL_QQ_LITTLE_WORLD.ordinal())) || Intrinsics.areEqual(this.channel, String.valueOf(QQECChannel.CHANNEL_QQ_LIVE.ordinal()));
    }

    private final void ii() {
        IECCoreSkinApi.a.a(ECSkin.INSTANCE, "qecommerce_img_register_qqchuangzuo", null, new f((ImageView) yh().findViewById(R.id.nxh)), 2, null);
    }

    private final void initListener() {
        ImageButton imageButton = this.backBtn;
        if (imageButton == null) {
            Intrinsics.throwUninitializedPropertyAccessException("backBtn");
        }
        imageButton.setOnClickListener(new b());
        Button button = this.nextStepBtn;
        if (button == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nextStepBtn");
        }
        button.setOnClickListener(new c());
    }

    private final void initUI() {
        ii();
        this.nextStepBtn = (Button) yh().findViewById(R.id.nxg);
        this.conditionsView = (LinearLayout) yh().findViewById(R.id.nxd);
        this.worksNumContainer = (LinearLayout) yh().findViewById(R.id.f163087o81);
        this.worksNumTv = (TextView) yh().findViewById(R.id.f163089o83);
        this.worksNumStateTv = (TextView) yh().findViewById(R.id.f163088o82);
        this.preWeekWorksNumContainer = (LinearLayout) yh().findViewById(R.id.f163090o84);
        this.preWeekWorksNumTv = (TextView) yh().findViewById(R.id.o86);
        this.preWeekWorksNumStateTv = (TextView) yh().findViewById(R.id.o85);
        this.fansNumContainer = (LinearLayout) yh().findViewById(R.id.o7y);
        this.fansNumTv = (TextView) yh().findViewById(R.id.f163086o80);
        this.fansNumStateTv = (TextView) yh().findViewById(R.id.o7z);
        ImageButton imageButton = (ImageButton) yh().findViewById(R.id.nxa);
        this.backBtn = imageButton;
        if (imageButton == null) {
            Intrinsics.throwUninitializedPropertyAccessException("backBtn");
        }
        ViewGroup.LayoutParams layoutParams = imageButton.getLayoutParams();
        if (layoutParams != null) {
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
            layoutParams2.topMargin += r.f104881b.a(getActivity());
            ImageButton imageButton2 = this.backBtn;
            if (imageButton2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("backBtn");
            }
            imageButton2.setLayoutParams(layoutParams2);
            if (hi()) {
                fi();
            }
            this.stateCenterView = (ECStateCenterView) yh().findViewById(R.id.f163092o91);
            gi();
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void ji() {
        com.tencent.ecommerce.base.ui.g gVar = new com.tencent.ecommerce.base.ui.g(requireContext());
        gVar.setTitle("\u662f\u5426\u786e\u8ba4\u89e3\u7ed1\u63a8\u5e7f\u5458\uff1f");
        gVar.Y("\u89e3\u7ed1\u540e\u53ef\u7533\u8bf7\u5e26\u8d27\u6743\u9650\uff0c\u4f46\u62e5\u6709\u5e26\u8d27\u6743\u9650\u540e\u65e0\u6cd5\u518d\u6210\u4e3a\u63a8\u5e7f\u5458\u3002");
        gVar.b0("\u53d6\u6d88");
        gVar.f0("\u786e\u5b9a");
        gVar.a0(new Function1<View, Unit>() { // from class: com.tencent.ecommerce.biz.register.refactoring.fragment.ECommerceRegisterIntroFragment$showUnBindDialog$$inlined$apply$lambda$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(View view) {
                invoke2(view);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(View view) {
                ECommerceRegisterIntroFragment.Qh(ECommerceRegisterIntroFragment.this).setSucceededState();
            }
        });
        gVar.e0(new Function1<View, Unit>() { // from class: com.tencent.ecommerce.biz.register.refactoring.fragment.ECommerceRegisterIntroFragment$showUnBindDialog$$inlined$apply$lambda$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(View view) {
                invoke2(view);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(View view) {
                ECRegisterIntroViewModel ai5;
                IStateCenterView.a.c(ECommerceRegisterIntroFragment.Qh(ECommerceRegisterIntroFragment.this), null, 1, null);
                ai5 = ECommerceRegisterIntroFragment.this.ai();
                ai5.N1();
            }
        });
        Window window = gVar.getWindow();
        if (window != null) {
            window.setWindowAnimations(R.style.f173269ze);
        }
        gVar.show();
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment
    public boolean Eh() {
        return true;
    }

    @Override // com.tencent.ecommerce.base.fragment.api.IECBaseFragment
    /* renamed from: getBusinessDescription */
    public String getTAG() {
        return "ECommerceRegisterIntroFragment";
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment
    public int getContentLayoutId() {
        return R.layout.cvh;
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment, com.tencent.ecommerce.base.ui.api.IECFragmentApi
    public boolean onBackPressed() {
        ECStateCenterView eCStateCenterView = this.stateCenterView;
        if (eCStateCenterView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("stateCenterView");
        }
        if (eCStateCenterView.getVisibility() == 0) {
            ECStateCenterView eCStateCenterView2 = this.stateCenterView;
            if (eCStateCenterView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("stateCenterView");
            }
            eCStateCenterView2.setVisibility(8);
            return true;
        }
        return super.onBackPressed();
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        Intent intent;
        super.onCreate(savedInstanceState);
        FragmentActivity activity = getActivity();
        if (activity != null && (intent = activity.getIntent()) != null) {
            this.channel = intent.getStringExtra(WadlProxyConsts.CHANNEL);
            this.registerRole = intent.getIntExtra("register_role", 0);
            this.isRegistered = Boolean.valueOf(intent.getBooleanExtra("is_register", false));
            this.needConditionCheck = intent.getBooleanExtra("need_check_condition", true);
            String stringExtra = intent.getStringExtra("jump_scheme");
            if (stringExtra == null) {
                stringExtra = "";
            }
            this.jumpScheme = new String(Base64.decode(stringExtra, 0), StandardCharsets.UTF_8);
            String stringExtra2 = intent.getStringExtra("scheme_callback_id");
            this.deliverProductCallbackId = stringExtra2 != null ? stringExtra2 : "";
            this.msgBox = (ECMsgBox) intent.getSerializableExtra("msg_box");
            a.b("ECommerceRegisterIntroFragment", "[onCreate] Channel= " + this.channel + " jumpScheme = " + this.jumpScheme);
        }
        LifecycleEventBus.f100688b.d(ThreadMode.ORIGIN, ECRegisterSuccessEvent.class, this.successRegisteredEventObserve);
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        LifecycleEventBus.f100688b.e(this.successRegisteredEventObserve);
        super.onDestroy();
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initUI();
        initListener();
        ei();
        com.tencent.ecommerce.biz.register.a aVar = com.tencent.ecommerce.biz.register.a.f103962b;
        aVar.d(this.regConditionPassed);
        aVar.j(1, ECRegisterReportScene.INTRO_PAGE_EXP.sceneType, !this.regConditionPassed ? 1 : 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x0017, code lost:
    
        if (r4.equals("") == false) goto L18;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void ci(String url, boolean isRightBtn) {
        ECMsgBoxDialog eCMsgBoxDialog;
        if (url != null) {
            int hashCode = url.hashCode();
            if (hashCode != -476075936) {
                if (hashCode == 0) {
                }
            } else if (url.equals("jumpToUntiePromoter")) {
                new Handler().postDelayed(new Runnable() { // from class: com.tencent.ecommerce.biz.register.refactoring.fragment.ECommerceRegisterIntroFragment$handleMsgBoxClkEvent$1
                    @Override // java.lang.Runnable
                    public final void run() {
                        ECommerceRegisterIntroFragment.this.ji();
                    }
                }, 200L);
                return;
            }
            ECScheme.g(url, null, 2, null);
            ECMsgBoxDialog eCMsgBoxDialog2 = this.unbindPromoterDialog;
            if (eCMsgBoxDialog2 != null) {
                eCMsgBoxDialog2.q0(true);
                return;
            }
            return;
        }
        if (!isRightBtn || (eCMsgBoxDialog = this.unbindPromoterDialog) == null) {
            return;
        }
        eCMsgBoxDialog.q0(true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void di(ECommerceRegisterIntroFragment eCommerceRegisterIntroFragment, String str, boolean z16, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z16 = false;
        }
        eCommerceRegisterIntroFragment.ci(str, z16);
    }
}
