package com.tencent.mobileqq.vas.adv.debug;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.ad.cardad.views.CardAdView;
import com.tencent.mobileqq.ad.debug.a;
import com.tencent.mobileqq.fragment.QIphoneTitleBarFragment;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vas.adv.api.IVasAdvApi;
import com.tencent.mobileqq.vas.adv.common.callback.VasAdCallback;
import com.tencent.mobileqq.vas.adv.common.data.VasNewAdParams;
import com.tencent.mobileqq.vas.adv.debug.VasAdDebugFragment;
import com.tencent.mobileqq.vas.adv.maskad.MaskAdLoadHelper;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.mobileqq.widget.inputview.QUISingleLineInputView;
import com.tencent.mobileqq.widget.selectorview.QActionSheet;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.UiThreadUtil;
import gz2.i;
import gz2.j;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import sz2.g;
import tencent.gdt.access;
import tencent.gdt.qq_ad_get;

/* compiled from: P */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0007\u0018\u0000 B2\u00020\u0001:\u0001CB\u0007\u00a2\u0006\u0004\b@\u0010AJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0004H\u0002J\b\u0010\b\u001a\u00020\u0004H\u0002J\b\u0010\t\u001a\u00020\u0004H\u0002J\b\u0010\n\u001a\u00020\u0004H\u0002J\b\u0010\u000b\u001a\u00020\u0004H\u0002J\u001a\u0010\u0010\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0002J\u0010\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0011H\u0002J\u0010\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0014H\u0002J\b\u0010\u0017\u001a\u00020\fH\u0014J\u001a\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u00022\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019H\u0016R\u0016\u0010\u001f\u001a\u00020\u001c8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010#\u001a\u00020 8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010%\u001a\u00020 8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b$\u0010\"R\u0016\u0010'\u001a\u00020 8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b&\u0010\"R\u0016\u0010)\u001a\u00020 8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b(\u0010\"R\u0016\u0010+\u001a\u00020 8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b*\u0010\"R\u0016\u0010/\u001a\u00020,8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b-\u0010.R\u0016\u00103\u001a\u0002008\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b1\u00102R\u0016\u00106\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b4\u00105R\u0016\u00108\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b7\u0010-R\u0018\u0010<\u001a\u0004\u0018\u0001098\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b:\u0010;R\u0016\u0010?\u001a\u00020=8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b>\u00101\u00a8\u0006D"}, d2 = {"Lcom/tencent/mobileqq/vas/adv/debug/VasAdDebugFragment;", "Lcom/tencent/mobileqq/fragment/QIphoneTitleBarFragment;", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "", "initViews", "Fh", "Eh", "Dh", "Mh", "Ch", "Nh", "", "retCode", "Ltencent/gdt/access$AdGetRsp;", "rsp", "onAdRsp", "Lcom/tencent/gdtad/aditem/GdtAd;", "gdtAd", "Oh", "", "text", "Qh", "getContentLayoutId", "view", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "Lcom/tencent/mobileqq/widget/inputview/QUISingleLineInputView;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/widget/inputview/QUISingleLineInputView;", "mPosIdInputView", "Landroid/widget/TextView;", "D", "Landroid/widget/TextView;", "mPosIdConfirmView", "E", "mAdStyleConfirmView", UserInfo.SEX_FEMALE, "mShowAdCardBtn", "G", "mCheckVisibilityBtn", "H", "mSetWidthBtn", "Landroid/widget/FrameLayout;", "I", "Landroid/widget/FrameLayout;", "mCardAdContainer", "Lcom/tencent/mobileqq/widget/FormSwitchItem;", "J", "Lcom/tencent/mobileqq/widget/FormSwitchItem;", "mShopMaskAdNoFreqSwitch", "K", "Ljava/lang/String;", "mCardAdPosId", "L", "mCardAdStyle", "Lcom/tencent/mobileqq/ad/cardad/views/CardAdView;", "M", "Lcom/tencent/mobileqq/ad/cardad/views/CardAdView;", "mCardAdView", "", "N", "mCardAdRequestTimeMs", "<init>", "()V", "P", "a", "vas-adv-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class VasAdDebugFragment extends QIphoneTitleBarFragment {

    /* renamed from: P, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final Map<String, Integer> Q;

    /* renamed from: C, reason: from kotlin metadata */
    private QUISingleLineInputView mPosIdInputView;

    /* renamed from: D, reason: from kotlin metadata */
    private TextView mPosIdConfirmView;

    /* renamed from: E, reason: from kotlin metadata */
    private TextView mAdStyleConfirmView;

    /* renamed from: F, reason: from kotlin metadata */
    private TextView mShowAdCardBtn;

    /* renamed from: G, reason: from kotlin metadata */
    private TextView mCheckVisibilityBtn;

    /* renamed from: H, reason: from kotlin metadata */
    private TextView mSetWidthBtn;

    /* renamed from: I, reason: from kotlin metadata */
    private FrameLayout mCardAdContainer;

    /* renamed from: J, reason: from kotlin metadata */
    private FormSwitchItem mShopMaskAdNoFreqSwitch;

    /* renamed from: K, reason: from kotlin metadata */
    @NotNull
    private String mCardAdPosId = "";

    /* renamed from: L, reason: from kotlin metadata */
    private int mCardAdStyle;

    /* renamed from: M, reason: from kotlin metadata */
    @Nullable
    private CardAdView mCardAdView;

    /* renamed from: N, reason: from kotlin metadata */
    private long mCardAdRequestTimeMs;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\t\u0010\bR \u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u000b0\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\r\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/vas/adv/debug/VasAdDebugFragment$a;", "", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "", "a", "", "TAG", "Ljava/lang/String;", "TITLE", "", "", "posIdToBusiType", "Ljava/util/Map;", "<init>", "()V", "vas-adv-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.vas.adv.debug.VasAdDebugFragment$a, reason: from kotlin metadata */
    /* loaded from: classes20.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(@Nullable Activity activity) {
            if (activity == null) {
                QLog.e("VasAdDebugFragment", 1, "start error");
            } else {
                QPublicFragmentActivity.start(activity, VasAdDebugFragment.class);
            }
        }

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\"\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/vas/adv/debug/VasAdDebugFragment$d", "Lcom/tencent/mobileqq/vas/adv/common/callback/VasAdCallback;", "", "retCode", "Ltencent/gdt/access$AdGetRsp;", "rsp", "", "msg", "", "onRsp", "vas-adv-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes20.dex */
    public static final class d implements VasAdCallback {
        d() {
        }

        @Override // com.tencent.mobileqq.vas.adv.common.callback.VasAdCallback
        public void onRsp(int retCode, @Nullable access.AdGetRsp rsp, @NotNull String msg2) {
            Intrinsics.checkNotNullParameter(msg2, "msg");
            VasAdDebugFragment.this.onAdRsp(retCode, rsp);
        }
    }

    static {
        Map<String, Integer> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to("1082214467882419", 13), TuplesKt.to("6011195015998218", 10), TuplesKt.to("5099373422087196", 9), TuplesKt.to("5121394530341950", 79));
        Q = mapOf;
    }

    private final void Ch() {
        CardAdView cardAdView = this.mCardAdView;
        if (cardAdView != null) {
            cardAdView.j();
        }
    }

    private final void Dh() {
        i iVar = new i(getContext());
        iVar.k("\u9009\u62e9adStyle");
        iVar.i(new b(iVar, this));
        iVar.m();
    }

    private final void Eh() {
        QUISingleLineInputView qUISingleLineInputView = this.mPosIdInputView;
        TextView textView = null;
        if (qUISingleLineInputView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPosIdInputView");
            qUISingleLineInputView = null;
        }
        String valueOf = String.valueOf(qUISingleLineInputView.d());
        if (!TextUtils.isEmpty(valueOf)) {
            this.mCardAdPosId = valueOf;
            TextView textView2 = this.mPosIdConfirmView;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mPosIdConfirmView");
            } else {
                textView = textView2;
            }
            textView.setText("\u5df2\u8bbe\u7f6eposId:" + valueOf);
            return;
        }
        j jVar = new j(getContext());
        jVar.k("\u9009\u62e9posId");
        jVar.i(new c(jVar, this));
        jVar.m();
    }

    private final void Fh() {
        g.f435047a.f();
        TextView textView = this.mPosIdConfirmView;
        FormSwitchItem formSwitchItem = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPosIdConfirmView");
            textView = null;
        }
        textView.setOnClickListener(new View.OnClickListener() { // from class: gz2.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                VasAdDebugFragment.Gh(VasAdDebugFragment.this, view);
            }
        });
        TextView textView2 = this.mAdStyleConfirmView;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAdStyleConfirmView");
            textView2 = null;
        }
        textView2.setOnClickListener(new View.OnClickListener() { // from class: gz2.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                VasAdDebugFragment.Hh(VasAdDebugFragment.this, view);
            }
        });
        TextView textView3 = this.mShowAdCardBtn;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mShowAdCardBtn");
            textView3 = null;
        }
        textView3.setOnClickListener(new View.OnClickListener() { // from class: gz2.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                VasAdDebugFragment.Ih(VasAdDebugFragment.this, view);
            }
        });
        TextView textView4 = this.mCheckVisibilityBtn;
        if (textView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCheckVisibilityBtn");
            textView4 = null;
        }
        textView4.setOnClickListener(new View.OnClickListener() { // from class: gz2.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                VasAdDebugFragment.Jh(VasAdDebugFragment.this, view);
            }
        });
        TextView textView5 = this.mSetWidthBtn;
        if (textView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSetWidthBtn");
            textView5 = null;
        }
        textView5.setOnClickListener(new View.OnClickListener() { // from class: gz2.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                VasAdDebugFragment.Kh(VasAdDebugFragment.this, view);
            }
        });
        FormSwitchItem formSwitchItem2 = this.mShopMaskAdNoFreqSwitch;
        if (formSwitchItem2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mShopMaskAdNoFreqSwitch");
            formSwitchItem2 = null;
        }
        formSwitchItem2.setChecked(a.f186830a.k());
        FormSwitchItem formSwitchItem3 = this.mShopMaskAdNoFreqSwitch;
        if (formSwitchItem3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mShopMaskAdNoFreqSwitch");
        } else {
            formSwitchItem = formSwitchItem3;
        }
        formSwitchItem.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: gz2.f
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
                VasAdDebugFragment.Lh(compoundButton, z16);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Gh(VasAdDebugFragment this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.Eh();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Hh(VasAdDebugFragment this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.Dh();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ih(VasAdDebugFragment this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.Mh();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Jh(VasAdDebugFragment this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.Ch();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Kh(VasAdDebugFragment this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.Nh();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Lh(CompoundButton compoundButton, boolean z16) {
        EventCollector.getInstance().onCompoundButtonCheckedBefore(compoundButton, z16);
        a.f186830a.v(z16);
        EventCollector.getInstance().onCompoundButtonChecked(compoundButton, z16);
    }

    private final void Mh() {
        d dVar = new d();
        IVasAdvApi iVasAdvApi = (IVasAdvApi) QRoute.api(IVasAdvApi.class);
        VasNewAdParams build = new VasNewAdParams.Builder().build();
        build.getAdvPos().add(this.mCardAdPosId);
        build.setUin(MaskAdLoadHelper.INSTANCE.getCurrentUin());
        Integer num = Q.get(this.mCardAdPosId);
        if (num == null) {
            num = 15;
        }
        build.setBusiType(num);
        iVasAdvApi.requestAd(build, dVar);
        this.mCardAdRequestTimeMs = System.currentTimeMillis();
    }

    private final void Nh() {
        FrameLayout frameLayout = this.mCardAdContainer;
        if (frameLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCardAdContainer");
            frameLayout = null;
        }
        frameLayout.getLayoutParams().width = ViewUtils.dpToPx(205.0f);
    }

    private final void Oh(final GdtAd gdtAd) {
        Qh("\u5f00\u59cb\u5c55\u793a \u8017\u65f6: " + (System.currentTimeMillis() - this.mCardAdRequestTimeMs) + "ms");
        UiThreadUtil.runOnUiThread(new Runnable() { // from class: gz2.h
            @Override // java.lang.Runnable
            public final void run() {
                VasAdDebugFragment.Ph(VasAdDebugFragment.this, gdtAd);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ph(VasAdDebugFragment this$0, GdtAd gdtAd) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(gdtAd, "$gdtAd");
        com.tencent.mobileqq.ad.cardad.manager.a aVar = com.tencent.mobileqq.ad.cardad.manager.a.f186722a;
        Context context = this$0.getContext();
        FrameLayout frameLayout = this$0.mCardAdContainer;
        if (frameLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCardAdContainer");
            frameLayout = null;
        }
        this$0.mCardAdView = aVar.c(context, frameLayout, gdtAd, this$0.mCardAdPosId, this$0.mCardAdStyle, null);
    }

    private final void Qh(final String text) {
        UiThreadUtil.runOnUiThread(new Runnable() { // from class: gz2.g
            @Override // java.lang.Runnable
            public final void run() {
                VasAdDebugFragment.Rh(VasAdDebugFragment.this, text);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Rh(VasAdDebugFragment this$0, String text) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(text, "$text");
        TextView textView = this$0.mShowAdCardBtn;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mShowAdCardBtn");
            textView = null;
        }
        textView.setText(text);
    }

    private final void initViews(View rootView) {
        View findViewById = rootView.findViewById(R.id.f116376yk);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.\u2026vas_card_ad_pos_id_input)");
        this.mPosIdInputView = (QUISingleLineInputView) findViewById;
        View findViewById2 = rootView.findViewById(R.id.f116366yj);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "rootView.findViewById(R.\u2026s_card_ad_pos_id_confirm)");
        this.mPosIdConfirmView = (TextView) findViewById2;
        View findViewById3 = rootView.findViewById(R.id.f116486yv);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "rootView.findViewById(R.\u2026how_card_ad_style_select)");
        this.mAdStyleConfirmView = (TextView) findViewById3;
        View findViewById4 = rootView.findViewById(R.id.f116476yu);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "rootView.findViewById(R.id.vas_show_card_ad_btn)");
        this.mShowAdCardBtn = (TextView) findViewById4;
        View findViewById5 = rootView.findViewById(R.id.f116346yh);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "rootView.findViewById(R.\u2026_ad_check_visibility_btn)");
        this.mCheckVisibilityBtn = (TextView) findViewById5;
        View findViewById6 = rootView.findViewById(R.id.f116386yl);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "rootView.findViewById(R.\u2026as_card_ad_set_width_btn)");
        this.mSetWidthBtn = (TextView) findViewById6;
        View findViewById7 = rootView.findViewById(R.id.f116356yi);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "rootView.findViewById(R.id.vas_card_ad_container)");
        this.mCardAdContainer = (FrameLayout) findViewById7;
        View findViewById8 = rootView.findViewById(R.id.f84664mv);
        Intrinsics.checkNotNullExpressionValue(findViewById8, "rootView.findViewById(R.id.shop_ad_mask_no_freq)");
        this.mShopMaskAdNoFreqSwitch = (FormSwitchItem) findViewById8;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onAdRsp(int retCode, access.AdGetRsp rsp) {
        String str;
        PBRepeatMessageField<qq_ad_get.QQAdGetRsp.PosAdInfo> pBRepeatMessageField;
        access.RetMsg retMsg;
        PBStringField pBStringField;
        List<qq_ad_get.QQAdGetRsp.PosAdInfo> list = null;
        if (rsp != null && (retMsg = rsp.ret_msg) != null && (pBStringField = retMsg.err_msg) != null) {
            str = pBStringField.get();
        } else {
            str = null;
        }
        QLog.d("VasAdDebugFragment", 1, "onAdRsp retCode:" + retCode + ", retMsg:" + str);
        if (retCode != 0) {
            QLog.e("VasAdDebugFragment", 1, "onAdRsp retCode:" + retCode + ", retMsg:" + str);
            return;
        }
        if (rsp != null) {
            try {
                qq_ad_get.QQAdGetRsp qQAdGetRsp = rsp.qq_ad_get_rsp;
                if (qQAdGetRsp != null && (pBRepeatMessageField = qQAdGetRsp.pos_ads_info) != null) {
                    list = pBRepeatMessageField.get();
                }
            } catch (Throwable th5) {
                QLog.e("VasAdDebugFragment", 1, "onAdRsp parse ad error:", th5);
                return;
            }
        }
        if (list == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (qq_ad_get.QQAdGetRsp.PosAdInfo posAdInfo : list) {
            if (posAdInfo.has() && !posAdInfo.ads_info.get().isEmpty()) {
                arrayList.add(new GdtAd(posAdInfo.ads_info.get().get(0)));
            }
            QLog.d("VasAdDebugFragment", 2, "show maskAd, adInfo inValid\uff0cpos_id is" + posAdInfo.pos_id.get());
        }
        if (arrayList.isEmpty()) {
            Qh("\u5c55\u793a\u5931\u8d25 \u5e7f\u544a\u4e3a\u7a7a");
            return;
        }
        Object obj = arrayList.get(0);
        Intrinsics.checkNotNullExpressionValue(obj, "adList[0]");
        Oh((GdtAd) obj);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.fragment.QIphoneTitleBarFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.f169169i30;
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        setTitle("\u589e\u503c\u5e7f\u544a\u6d4b\u8bd5");
        initViews(view);
        Fh();
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/vas/adv/debug/VasAdDebugFragment$b", "Lcom/tencent/mobileqq/widget/selectorview/QActionSheet$f;", "", "onDismiss", "t", "onConfirm", "vas-adv-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes20.dex */
    public static final class b implements QActionSheet.f {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ i f308021d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ VasAdDebugFragment f308022e;

        b(i iVar, VasAdDebugFragment vasAdDebugFragment) {
            this.f308021d = iVar;
            this.f308022e = vasAdDebugFragment;
        }

        @Override // com.tencent.mobileqq.widget.selectorview.QActionSheet.f
        public void onConfirm() {
            int p16 = this.f308021d.p();
            this.f308022e.mCardAdStyle = p16;
            TextView textView = this.f308022e.mAdStyleConfirmView;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAdStyleConfirmView");
                textView = null;
            }
            textView.setText("\u5df2\u8bbe\u7f6estyle:" + p16);
        }

        @Override // com.tencent.mobileqq.widget.selectorview.QActionSheet.f
        public void onDismiss() {
        }

        @Override // com.tencent.mobileqq.widget.selectorview.QActionSheet.f
        public void t() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/vas/adv/debug/VasAdDebugFragment$c", "Lcom/tencent/mobileqq/widget/selectorview/QActionSheet$f;", "", "onDismiss", "t", "onConfirm", "vas-adv-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes20.dex */
    public static final class c implements QActionSheet.f {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ j f308023d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ VasAdDebugFragment f308024e;

        c(j jVar, VasAdDebugFragment vasAdDebugFragment) {
            this.f308023d = jVar;
            this.f308024e = vasAdDebugFragment;
        }

        @Override // com.tencent.mobileqq.widget.selectorview.QActionSheet.f
        public void onConfirm() {
            String q16 = this.f308023d.q();
            this.f308024e.mCardAdPosId = q16;
            TextView textView = this.f308024e.mPosIdConfirmView;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mPosIdConfirmView");
                textView = null;
            }
            textView.setText("\u5df2\u9009\u62e9posId:" + q16);
        }

        @Override // com.tencent.mobileqq.widget.selectorview.QActionSheet.f
        public void onDismiss() {
        }

        @Override // com.tencent.mobileqq.widget.selectorview.QActionSheet.f
        public void t() {
        }
    }
}
