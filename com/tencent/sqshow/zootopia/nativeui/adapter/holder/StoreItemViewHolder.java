package com.tencent.sqshow.zootopia.nativeui.adapter.holder;

import android.app.Activity;
import android.content.Context;
import android.content.res.AssetManager;
import android.os.CountDownTimer;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.lifecycle.MutableLiveData;
import com.google.gson.JsonObject;
import com.tencent.ams.xsad.rewarded.dynamic.method.AdCommonMethodHandler;
import com.tencent.bugly.common.constants.Constants;
import com.tencent.filament.zplan.avatar.ZPlanAvatarResourceHelper;
import com.tencent.filament.zplan.engine.js.FilamentFileUtil;
import com.tencent.filament.zplanservice.feature.model.FilamentUrlTemplate;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.adv.web.RewardType;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.zplan.scheme.ISchemeApi;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import com.tencent.sqshow.zootopia.card.report.ZplanViewReportHelper;
import com.tencent.sqshow.zootopia.nativeui.data.CameraKey;
import com.tencent.sqshow.zootopia.nativeui.ue.u;
import com.tencent.sqshow.zootopia.nativeui.view.loading.NativePanelLoadingIgv;
import com.tencent.sqshow.zootopia.nativeui.view.page.ZPlanAvatarPreDownloadManager;
import com.tencent.sqshow.zootopia.utils.CommonExKt;
import com.tencent.sqshow.zootopia.utils.ui.RoundCornerImageView;
import com.tencent.util.QQToastUtil;
import i94.CollectInfo;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import k94.DialogCustomData;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.text.StringsKt__StringsKt;
import org.json.JSONObject;
import org.slf4j.Marker;
import uv4.az;
import uv4.ba;
import uv4.bb;
import uv4.bc;
import uv4.be;
import uv4.bk;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00b0\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u0000 |2\u00020\u0001:\u0001}B'\u0012\u0006\u0010T\u001a\u00020O\u0012\u0006\u0010Z\u001a\u00020U\u0012\u0006\u0010y\u001a\u00020x\u0012\u0006\u0010_\u001a\u00020[\u00a2\u0006\u0004\bz\u0010{J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0004H\u0002J\u0012\u0010\n\u001a\u00020\u00042\b\b\u0001\u0010\t\u001a\u00020\bH\u0002J\b\u0010\u000b\u001a\u00020\u0004H\u0002J\b\u0010\f\u001a\u00020\u0004H\u0002J\b\u0010\r\u001a\u00020\u0004H\u0002J\b\u0010\u000e\u001a\u00020\u0004H\u0002J\b\u0010\u000f\u001a\u00020\u0004H\u0002J\b\u0010\u0010\u001a\u00020\u0004H\u0002J\b\u0010\u0011\u001a\u00020\u0004H\u0002J\b\u0010\u0012\u001a\u00020\u0004H\u0002J\u0010\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u0013H\u0002J\u0010\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u0013H\u0003J\u0010\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u0013H\u0002J\u0010\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0014\u001a\u00020\u0013H\u0002J\u0010\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u001aH\u0002J\b\u0010\u001d\u001a\u00020\u0004H\u0002J\u0010\u0010\u001f\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u001aH\u0002J\u0010\u0010\"\u001a\u00020!2\u0006\u0010 \u001a\u00020\u001aH\u0002J\n\u0010$\u001a\u0004\u0018\u00010#H\u0016J\u0016\u0010'\u001a\u00020\u00042\f\u0010&\u001a\b\u0012\u0004\u0012\u00020!0%H\u0014J\u0010\u0010*\u001a\u00020\u00042\u0006\u0010)\u001a\u00020(H\u0004J\u0010\u0010-\u001a\u00020\u00042\u0006\u0010,\u001a\u00020+H\u0014J\u0012\u0010/\u001a\u00020\u00042\b\u0010.\u001a\u0004\u0018\u00010\u0013H\u0014J\b\u00100\u001a\u00020\u0004H\u0014J\b\u00101\u001a\u00020\u0004H\u0014J2\u00107\u001a\u00020\u00042\b\u0010.\u001a\u0004\u0018\u0001022\u0006\u00103\u001a\u00020\b2\u0016\u00106\u001a\u0012\u0012\u0004\u0012\u00020204j\b\u0012\u0004\u0012\u000202`5H\u0016J\b\u00108\u001a\u00020\u0004H\u0014J\b\u00109\u001a\u00020\u0004H\u0014J\b\u0010:\u001a\u00020\u0004H\u0014J\u0010\u0010<\u001a\u00020\u00042\u0006\u0010;\u001a\u00020\u0018H\u0014J\u0010\u0010=\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u0013H\u0014J\u0010\u0010>\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u0013H\u0014J\u0010\u0010?\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u0013H\u0016J\u001c\u0010B\u001a\u00020\u00042\u0012\u0010A\u001a\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u00130@H\u0014J\u0010\u0010C\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u0013H\u0014J\b\u0010D\u001a\u00020!H\u0016J\b\u0010E\u001a\u00020\u0018H\u0016J\b\u0010F\u001a\u00020\u0018H\u0014J\u0010\u0010H\u001a\u00020\u00042\u0006\u0010G\u001a\u00020\bH\u0016J\b\u0010I\u001a\u00020\u0004H\u0016J\b\u0010J\u001a\u00020\u0004H\u0016J$\u0010N\u001a\u001e\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020L0Kj\u000e\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020L`MH\u0014R\u0017\u0010T\u001a\u00020O8\u0006\u00a2\u0006\f\n\u0004\bP\u0010Q\u001a\u0004\bR\u0010SR\u0017\u0010Z\u001a\u00020U8\u0006\u00a2\u0006\f\n\u0004\bV\u0010W\u001a\u0004\bX\u0010YR\u0017\u0010_\u001a\u00020[8\u0006\u00a2\u0006\f\n\u0004\bE\u0010\\\u001a\u0004\b]\u0010^R\u0014\u0010a\u001a\u00020!8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bF\u0010`R\u0014\u0010e\u001a\u00020b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bc\u0010dR\u0018\u0010i\u001a\u0004\u0018\u00010f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bg\u0010hR\u0016\u0010k\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bj\u0010FR\"\u0010r\u001a\u00020\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bl\u0010m\u001a\u0004\bn\u0010o\"\u0004\bp\u0010qR\u0016\u0010s\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b7\u0010mR6\u0010w\u001a\u001e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00020Kj\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0002`M8\u0004X\u0084\u0004\u00a2\u0006\f\n\u0004\b-\u0010t\u001a\u0004\bu\u0010v\u00a8\u0006~"}, d2 = {"Lcom/tencent/sqshow/zootopia/nativeui/adapter/holder/StoreItemViewHolder;", "Lcom/tencent/sqshow/zootopia/nativeui/adapter/holder/BaseAvatarPanelItemViewHolder;", "Landroid/view/View;", "view", "", "V0", "w1", "z1", "", "from", "x1", "E1", Constants.APK_CERTIFICATE, "K1", "I1", "L1", Constants.BASE_IN_PLUGIN_ID, "F1", "J1", "Luv4/az;", "storeItemData", "v1", "M1", "o1", "", "e1", "", "remainSecond", "O1", "f1", "remainTimeMills", "N1", "durationInSec", "", "i1", "Lcom/tencent/sqshow/zootopia/nativeui/view/loading/NativePanelLoadingIgv;", "O", "", "idList", "i0", "Landroid/view/ViewStub;", "viewStub", "m1", "Li94/a;", "collectInfo", "f0", "data", "u1", "A1", "w", "Luv4/bk;", "posInList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "totalData", "e0", "B1", "reportClick", "C1", "itemDressingOrDressed", "g1", "b1", ICustomDataEditor.STRING_ARRAY_PARAM_1, "Z0", "Ljava/util/concurrent/ConcurrentHashMap;", "adStoreItem", "p0", "W0", "J0", "Y", "Z", "id", "c1", "h1", "q0", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "d1", "Ln74/ad;", "W", "Ln74/ad;", "j1", "()Ln74/ad;", "binding", "Lg94/g;", "X", "Lg94/g;", "l1", "()Lg94/g;", "sizeHelper", "Lcom/tencent/sqshow/zootopia/nativeui/adapter/holder/StoreItemViewHolder$a$a;", "Lcom/tencent/sqshow/zootopia/nativeui/adapter/holder/StoreItemViewHolder$a$a;", "getCategory", "()Lcom/tencent/sqshow/zootopia/nativeui/adapter/holder/StoreItemViewHolder$a$a;", "category", "Ljava/lang/String;", "mGenderInvalidString", "Lcom/tencent/sqshow/zootopia/nativeui/adapter/holder/ai;", "a0", "Lcom/tencent/sqshow/zootopia/nativeui/adapter/holder/ai;", "mAnimHelper", "Landroid/os/CountDownTimer;", "b0", "Landroid/os/CountDownTimer;", "countDownTimer", "c0", "isItemDressed", "d0", "I", "getRedDotId", "()I", "setRedDotId", "(I)V", "redDotId", "itemPosition", "Ljava/util/HashMap;", "k1", "()Ljava/util/HashMap;", "inflatedViews", "Lcom/tencent/sqshow/zootopia/nativeui/data/j;", WadlProxyConsts.CHANNEL, "<init>", "(Ln74/ad;Lg94/g;Lcom/tencent/sqshow/zootopia/nativeui/data/j;Lcom/tencent/sqshow/zootopia/nativeui/adapter/holder/StoreItemViewHolder$a$a;)V", "g0", "a", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public class StoreItemViewHolder extends BaseAvatarPanelItemViewHolder {

    /* renamed from: W, reason: from kotlin metadata */
    private final n74.ad binding;

    /* renamed from: X, reason: from kotlin metadata */
    private final g94.g sizeHelper;

    /* renamed from: Y, reason: from kotlin metadata */
    private final Companion.CategoryData category;

    /* renamed from: Z, reason: from kotlin metadata */
    private final String mGenderInvalidString;

    /* renamed from: a0, reason: collision with root package name and from kotlin metadata */
    private final ai mAnimHelper;

    /* renamed from: b0, reason: collision with root package name and from kotlin metadata */
    private CountDownTimer countDownTimer;

    /* renamed from: c0, reason: collision with root package name and from kotlin metadata */
    private boolean isItemDressed;

    /* renamed from: d0, reason: collision with root package name and from kotlin metadata */
    private int redDotId;

    /* renamed from: e0, reason: collision with root package name and from kotlin metadata */
    private int itemPosition;

    /* renamed from: f0, reason: collision with root package name and from kotlin metadata */
    private final HashMap<Integer, View> inflatedViews;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/sqshow/zootopia/nativeui/adapter/holder/StoreItemViewHolder$b", "Landroid/os/CountDownTimer;", "", "millisUntilFinished", "", AdCommonMethodHandler.AdCommonEvent.ON_TICK, "onFinish", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class b extends CountDownTimer {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ StoreItemViewHolder f370794a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(long j3, StoreItemViewHolder storeItemViewHolder) {
            super(j3, 1000L);
            this.f370794a = storeItemViewHolder;
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            this.f370794a.getBinding().f418597h.f418874j.setText("\u5df2\u8fc7\u671f");
        }

        @Override // android.os.CountDownTimer
        public void onTick(long millisUntilFinished) {
            this.f370794a.O1(millisUntilFinished / 1000);
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public StoreItemViewHolder(n74.ad binding, g94.g sizeHelper, com.tencent.sqshow.zootopia.nativeui.data.j channel, Companion.CategoryData category) {
        super(r0, channel);
        Intrinsics.checkNotNullParameter(binding, "binding");
        Intrinsics.checkNotNullParameter(sizeHelper, "sizeHelper");
        Intrinsics.checkNotNullParameter(channel, "channel");
        Intrinsics.checkNotNullParameter(category, "category");
        FrameLayout root = binding.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        this.binding = binding;
        this.sizeHelper = sizeHelper;
        this.category = category;
        String string = BaseApplication.context.getResources().getString(R.string.xrm);
        Intrinsics.checkNotNullExpressionValue(string, "context.resources.getStr\u2026shop_item_gender_invalid)");
        this.mGenderInvalidString = string;
        this.mAnimHelper = new ai(binding, sizeHelper);
        this.inflatedViews = new HashMap<>();
        TextView textView = binding.f418597h.f418868d;
        t74.m mVar = t74.m.f435564a;
        AssetManager assets = binding.getRoot().getContext().getAssets();
        Intrinsics.checkNotNullExpressionValue(assets, "binding.root.context.assets");
        textView.setTypeface(mVar.b(assets));
        TextView textView2 = binding.f418597h.f418873i;
        AssetManager assets2 = binding.getRoot().getContext().getAssets();
        Intrinsics.checkNotNullExpressionValue(assets2, "binding.root.context.assets");
        textView2.setTypeface(mVar.b(assets2));
        binding.f418598i.setRadius(com.tencent.sqshow.zootopia.utils.i.e(5));
        A1();
    }

    private final void D1() {
        View view = this.inflatedViews.get(Integer.valueOf(R.id.pen));
        ViewGroup.LayoutParams layoutParams = view != null ? view.getLayoutParams() : null;
        if (layoutParams != null) {
            layoutParams.height = this.sizeHelper.a();
        }
        if (view != null) {
            view.setLayoutParams(layoutParams);
        }
        View view2 = this.inflatedViews.get(Integer.valueOf(R.id.peu));
        TextView textView = view2 instanceof TextView ? (TextView) view2 : null;
        if (textView == null) {
            return;
        }
        textView.setTextSize(this.sizeHelper.b());
    }

    private final void E1() {
        int mItemHeight = (int) this.sizeHelper.getMItemHeight();
        int mItemWidth = (int) this.sizeHelper.getMItemWidth();
        ViewGroup.LayoutParams layoutParams = this.binding.f418593d.getLayoutParams();
        layoutParams.width = mItemWidth;
        layoutParams.height = mItemHeight;
        this.binding.f418593d.setLayoutParams(layoutParams);
        ViewGroup.LayoutParams layoutParams2 = this.binding.f418592c.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams2, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        FrameLayout.LayoutParams layoutParams3 = (FrameLayout.LayoutParams) layoutParams2;
        layoutParams3.width = -1;
        layoutParams3.height = -1;
        this.binding.f418592c.setLayoutParams(layoutParams3);
    }

    private final void F1() {
        View view = this.inflatedViews.get(Integer.valueOf(R.id.qns));
        TextView textView = view instanceof TextView ? (TextView) view : null;
        if (textView == null) {
            return;
        }
        textView.setTextSize(this.sizeHelper.c());
    }

    private final void G1() {
        ViewGroup.LayoutParams layoutParams = this.binding.f418598i.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
        layoutParams2.width = this.sizeHelper.g();
        layoutParams2.height = this.sizeHelper.f();
        layoutParams2.bottomMargin = this.sizeHelper.e();
        this.binding.f418598i.setLayoutParams(layoutParams2);
    }

    private final void I1() {
        View view = this.inflatedViews.get(Integer.valueOf(R.id.q4p));
        int o16 = this.sizeHelper.o();
        ViewGroup.LayoutParams layoutParams = view != null ? view.getLayoutParams() : null;
        if (layoutParams != null) {
            layoutParams.width = o16;
        }
        if (layoutParams != null) {
            layoutParams.height = o16;
        }
        if (view == null) {
            return;
        }
        view.setLayoutParams(layoutParams);
    }

    private final void J1() {
        View view = this.inflatedViews.get(Integer.valueOf(R.id.q65));
        ViewGroup.LayoutParams layoutParams = view != null ? view.getLayoutParams() : null;
        if (layoutParams != null) {
            layoutParams.width = this.sizeHelper.i();
        }
        if (layoutParams != null) {
            layoutParams.height = this.sizeHelper.i();
        }
        if (view == null) {
            return;
        }
        view.setLayoutParams(layoutParams);
    }

    private final void K1() {
        ViewGroup.LayoutParams layoutParams = this.binding.f418597h.f418867c.getLayoutParams();
        layoutParams.width = this.sizeHelper.k();
        layoutParams.height = this.sizeHelper.k();
        this.binding.f418597h.f418867c.setLayoutParams(layoutParams);
        ViewGroup.LayoutParams layoutParams2 = this.binding.f418597h.f418872h.getLayoutParams();
        layoutParams2.width = this.sizeHelper.k();
        layoutParams2.height = this.sizeHelper.k();
        this.binding.f418597h.f418872h.setLayoutParams(layoutParams2);
        this.binding.f418597h.f418868d.setTextSize(this.sizeHelper.m());
        this.binding.f418597h.f418873i.setTextSize(this.sizeHelper.m());
        this.binding.f418597h.f418870f.setTextSize(this.sizeHelper.l());
    }

    private final void L1() {
        View view = this.inflatedViews.get(Integer.valueOf(R.id.qhs));
        int o16 = this.sizeHelper.o();
        ViewGroup.LayoutParams layoutParams = view != null ? view.getLayoutParams() : null;
        if (layoutParams != null) {
            layoutParams.width = o16;
        }
        if (layoutParams != null) {
            layoutParams.height = o16;
        }
        if (view == null) {
            return;
        }
        view.setLayoutParams(layoutParams);
    }

    private final void M1(az storeItemData) {
        boolean c16 = j74.b.f409622a.c();
        Integer valueOf = Integer.valueOf(R.id.pog);
        if (c16) {
            ViewStub viewStub = this.binding.f418596g;
            Intrinsics.checkNotNullExpressionValue(viewStub, "binding.debugTxvViewstub");
            m1(viewStub);
            View view = this.inflatedViews.get(valueOf);
            TextView textView = view instanceof TextView ? (TextView) view : null;
            if (textView != null) {
                textView.setVisibility(0);
            }
            if (textView == null) {
                return;
            }
            boolean z16 = storeItemData.N;
            int i3 = storeItemData.f440275b;
            String str = storeItemData.f440277d;
            String str2 = storeItemData.K;
            int i16 = storeItemData.G;
            boolean G = r94.b.G(storeItemData);
            boolean F = r94.b.F(storeItemData);
            int i17 = storeItemData.A;
            boolean y16 = r94.b.y(storeItemData);
            ba baVar = storeItemData.f440288o;
            Integer valueOf2 = baVar != null ? Integer.valueOf(baVar.f440308i) : null;
            ba baVar2 = storeItemData.f440288o;
            textView.setText("isMoreRecom: " + z16 + " \n" + i3 + " \n" + str + " \n" + str2 + " \n" + i16 + ", " + G + ", " + F + " \n" + i17 + " \nad: " + y16 + ", " + valueOf2 + ", " + (baVar2 != null ? Integer.valueOf(baVar2.f440307h) : null));
            return;
        }
        View view2 = this.inflatedViews.get(valueOf);
        if (view2 == null) {
            return;
        }
        view2.setVisibility(8);
    }

    private final void N1(long remainTimeMills) {
        CountDownTimer countDownTimer = this.countDownTimer;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        HashSet<CountDownTimer> I = getCom.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts.CHANNEL java.lang.String().I();
        TypeIntrinsics.asMutableCollection(I).remove(this.countDownTimer);
        this.countDownTimer = new b(remainTimeMills, this);
        HashSet<CountDownTimer> I2 = getCom.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts.CHANNEL java.lang.String().I();
        CountDownTimer countDownTimer2 = this.countDownTimer;
        Intrinsics.checkNotNull(countDownTimer2, "null cannot be cast to non-null type android.os.CountDownTimer");
        I2.add(countDownTimer2);
        CountDownTimer countDownTimer3 = this.countDownTimer;
        if (countDownTimer3 != null) {
            countDownTimer3.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void O1(long remainSecond) {
        String i16 = i1(remainSecond);
        String string = this.binding.getRoot().getContext().getString(R.string.xlj, i16);
        Intrinsics.checkNotNullExpressionValue(string, "binding.root.context.get\u2026ountdownTimeTxt\n        )");
        TextView textView = this.binding.f418597h.f418874j;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.hintArea.specialHintTxv");
        m84.b.i(textView, string, this.binding.getRoot().getContext().getResources().getColor(R.color.qui_common_text_primary), 0, i16.length());
    }

    private final void V0(View view) {
        this.inflatedViews.put(Integer.valueOf(view.getId()), view);
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = viewGroup.getChildAt(i3);
                Intrinsics.checkNotNullExpressionValue(childAt, "view.getChildAt(i)");
                V0(childAt);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void X0(az storeItemData, final StoreItemViewHolder this$0, View it) {
        String str;
        az azVar;
        az azVar2;
        az azVar3;
        ba baVar;
        az azVar4;
        Intrinsics.checkNotNullParameter(storeItemData, "$storeItemData");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (r94.b.y(storeItemData)) {
            this$0.o1(storeItemData);
        } else if (!TextUtils.isEmpty(storeItemData.f440288o.f440302c)) {
            ISchemeApi iSchemeApi = (ISchemeApi) QRoute.api(ISchemeApi.class);
            Context context = this$0.binding.getRoot().getContext();
            Intrinsics.checkNotNullExpressionValue(context, "binding.root.context");
            String str2 = storeItemData.f440288o.f440302c;
            Intrinsics.checkNotNullExpressionValue(str2, "storeItemData.activity.activityUrl");
            iSchemeApi.launchScheme(context, str2);
        } else if (storeItemData.f440288o.f440305f == 3) {
            this$0.binding.getRoot().post(new Runnable() { // from class: com.tencent.sqshow.zootopia.nativeui.adapter.holder.aq
                @Override // java.lang.Runnable
                public final void run() {
                    StoreItemViewHolder.Y0(StoreItemViewHolder.this);
                }
            });
        }
        HashMap hashMap = new HashMap();
        bk bindingData = this$0.getBindingData();
        if (bindingData == null || (azVar4 = bindingData.f440366b) == null || (str = r94.b.K(azVar4)) == null) {
            str = "";
        }
        hashMap.put("zplan_item_id", str);
        bk bindingData2 = this$0.getBindingData();
        JsonObject jsonObject = null;
        String str3 = (bindingData2 == null || (azVar3 = bindingData2.f440366b) == null || (baVar = azVar3.f440288o) == null) ? null : baVar.f440301b;
        hashMap.put("zplan_act_id", str3 != null ? str3 : "");
        bk bindingData3 = this$0.getBindingData();
        boolean z16 = false;
        if (bindingData3 != null && (azVar2 = bindingData3.f440366b) != null && r94.b.y(azVar2)) {
            z16 = true;
        }
        hashMap.put("zplan_btn_type", Integer.valueOf(z16 ? 2 : 1));
        bk bindingData4 = this$0.getBindingData();
        if (bindingData4 != null && (azVar = bindingData4.f440366b) != null) {
            jsonObject = r94.b.J(azVar);
        }
        hashMap.put("zplan_ext_info", String.valueOf(jsonObject));
        ZplanViewReportHelper mReporter = this$0.getCom.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts.CHANNEL java.lang.String().getReporter().getMReporter();
        Intrinsics.checkNotNullExpressionValue(it, "it");
        mReporter.e(it, "em_zplan_activity_entrance", hashMap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Y0(StoreItemViewHolder this$0) {
        ga4.g a16;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ga4.f dialogController = this$0.getCom.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts.CHANNEL java.lang.String().getDialogController();
        ga4.j jVar = ga4.j.f401682a;
        com.tencent.sqshow.zootopia.nativeui.data.j jVar2 = this$0.getCom.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts.CHANNEL java.lang.String();
        Context context = this$0.binding.getRoot().getContext();
        Intrinsics.checkNotNullExpressionValue(context, "binding.root.context");
        a16 = jVar.a(22, jVar2, context, (r22 & 8) != 0 ? new DialogCustomData(null, null, null, null, null, 0, 63, null) : null, (r22 & 16) != 0 ? false : false);
        dialogController.e(a16);
    }

    private final boolean e1(az storeItemData) {
        switch (storeItemData.I) {
            case 7:
                QQToast.makeText(BaseApplication.context, 0, "\u4f5c\u54c1\u751f\u6210\u4e2d\uff0c\u8bf7\u7a0d\u5019", 0).show();
                return false;
            case 8:
            default:
                return true;
            case 9:
            case 10:
            case 11:
                QQToast.makeText(BaseApplication.context, 0, "\u51fa\u9519\u4e86\uff0c\u5df2\u4e3a\u4f60\u9000\u56de\u521b\u4f5c\u5238", 0).show();
                return false;
        }
    }

    private final void f1() {
        CountDownTimer countDownTimer = this.countDownTimer;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n1(StoreItemViewHolder this$0, ViewStub viewStub, View inflated) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(inflated, "inflated");
        this$0.V0(inflated);
    }

    private final void o1(az storeItemData) {
        Activity attachedActivity;
        t74.o oVar = new t74.o();
        oVar.o(new StoreItemViewHolder$launchAd$adHelper$1$1(this, storeItemData));
        ba baVar = storeItemData.f440288o;
        if (baVar.f440308i <= baVar.f440307h || (attachedActivity = getCom.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts.CHANNEL java.lang.String().getAttachedActivity()) == null) {
            return;
        }
        View view = this.inflatedViews.get(Integer.valueOf(R.id.peu));
        if (view != null) {
            view.setEnabled(false);
        }
        int value = RewardType.SUPER_SHOW_FREE_ITEM.getValue();
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("item_id", storeItemData.f440275b);
        Unit unit = Unit.INSTANCE;
        String jSONObject2 = jSONObject.toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject2, "JSONObject().apply {\n   \u2026             }.toString()");
        t74.o.m(oVar, attachedActivity, value, jSONObject2, 0, 8, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean p1(StoreItemViewHolder this$0, az storeItemData, View view) {
        int[] iArr;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(storeItemData, "$storeItemData");
        String str = storeItemData.f440279f;
        String a16 = r94.b.a(storeItemData);
        be beVar = storeItemData.f440290q;
        List list = (beVar == null || (iArr = beVar.f440325b) == null) ? null : ArraysKt___ArraysKt.toList(iArr);
        bb bbVar = storeItemData.f440291r;
        Integer valueOf = bbVar != null ? Integer.valueOf(bbVar.f440310a) : null;
        this$0.b0("onBindViewHolder icon:" + str + ", id:" + a16 + ", slots: " + list + ", tag:" + valueOf + ", mutexTag:" + r94.b.k(storeItemData));
        if (!storeItemData.E) {
            return true;
        }
        com.tencent.sqshow.zootopia.nativeui.menu.a a17 = com.tencent.sqshow.zootopia.nativeui.menu.a.INSTANCE.a();
        FrameLayout root = this$0.binding.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        a17.j(root, this$0.getCom.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts.CHANNEL java.lang.String(), storeItemData, this$0);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r1(StoreItemViewHolder this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.B1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s1(final StoreItemViewHolder this$0, az storeItemData, View view) {
        az azVar;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(storeItemData, "$storeItemData");
        b94.e O = this$0.getCom.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts.CHANNEL java.lang.String().O();
        boolean mMainPanelIsShow = O != null ? O.getMMainPanelIsShow() : false;
        b94.e O2 = this$0.getCom.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts.CHANNEL java.lang.String().O();
        this$0.b0("panelIsShowing:" + mMainPanelIsShow + ", panelHasEnter:" + (O2 != null ? O2.getMPanelHasEnter() : false));
        if (!mMainPanelIsShow) {
            this$0.a0("panelIsHide no click can happened!");
            return;
        }
        this$0.reportClick();
        this$0.h1();
        if (!storeItemData.J || this$0.e1(storeItemData)) {
            if (!storeItemData.E) {
                QQToastUtil.showQQToast(1, storeItemData.J ? R.string.xrs : R.string.xrv);
                return;
            }
            if (r94.b.A(storeItemData)) {
                this$0.getCom.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts.CHANNEL java.lang.String().g0(String.valueOf(storeItemData.f440275b));
            }
            if (u.a.a(this$0.getCom.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts.CHANNEL java.lang.String().getUeStatusController(), false, 1, null)) {
                boolean z16 = this$0.isItemDressed;
                bk bindingData = this$0.getBindingData();
                final CameraKey cameraKey = new CameraKey((bindingData == null || (azVar = bindingData.f440366b) == null) ? 0 : azVar.F, 0, 2, null);
                CameraKey k3 = this$0.getCom.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts.CHANNEL java.lang.String().getCameraController().k();
                QLog.i("StoreItemViewHolder_", 1, "cameraId:" + cameraKey + ", currentCameraId:" + k3 + ", itemDressingOrDressed:" + z16);
                if (!z16 && cameraKey.c() && !Intrinsics.areEqual(cameraKey, k3)) {
                    if (!BaseAvatarPanelItemViewHolder.INSTANCE.a()) {
                        ThreadManagerV2.getUIHandlerV2().postDelayed(new Runnable() { // from class: com.tencent.sqshow.zootopia.nativeui.adapter.holder.ao
                            @Override // java.lang.Runnable
                            public final void run() {
                                StoreItemViewHolder.t1(StoreItemViewHolder.this, cameraKey);
                            }
                        }, 66L);
                    } else {
                        this$0.F0(true);
                    }
                }
                this$0.k0();
                this$0.g1(z16);
                this$0.H(storeItemData);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void t1(StoreItemViewHolder this$0, CameraKey cameraId) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(cameraId, "$cameraId");
        com.tencent.sqshow.zootopia.nativeui.ue.e.q(this$0.getCom.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts.CHANNEL java.lang.String().getCameraController(), cameraId, "item click", false, 4, null);
    }

    private final void v1(az storeItemData) {
        int i3;
        int i16;
        boolean z16 = this.isItemDressed;
        Integer valueOf = Integer.valueOf(R.id.p_8);
        if (z16) {
            ba baVar = storeItemData.f440288o;
            if (baVar != null && baVar.f440306g && (i16 = (i3 = baVar.f440308i) - baVar.f440307h) > 0 && i3 > 1) {
                ViewStub viewStub = this.binding.f418591b;
                Intrinsics.checkNotNullExpressionValue(viewStub, "binding.adCountViewstub");
                m1(viewStub);
                View view = this.inflatedViews.get(valueOf);
                String str = null;
                TextView textView = view instanceof TextView ? (TextView) view : null;
                if (textView != null) {
                    Activity attachedActivity = getCom.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts.CHANNEL java.lang.String().getAttachedActivity();
                    if (attachedActivity != null) {
                        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                        String string = attachedActivity.getResources().getString(R.string.xs8);
                        Intrinsics.checkNotNullExpressionValue(string, "it.resources.getString(R\u2026portal_activity_ad_count)");
                        str = String.format(string, Arrays.copyOf(new Object[]{Integer.valueOf(i16)}, 1));
                        Intrinsics.checkNotNullExpressionValue(str, "format(format, *args)");
                    }
                    textView.setText(str);
                }
                if (textView != null) {
                    textView.setVisibility(0);
                }
            }
        } else {
            View view2 = this.inflatedViews.get(valueOf);
            if (view2 != null) {
                view2.setVisibility(8);
            }
        }
        M1(storeItemData);
    }

    private final void w1() {
        this.isItemDressed = W();
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x002e, code lost:
    
        if (r4 != false) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x003b, code lost:
    
        if ((r0 != null && r0.f440305f == 3) != false) goto L24;
     */
    /* JADX WARN: Removed duplicated region for block: B:19:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00e7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void x1(@ItemBgRefreshSource int from) {
        boolean z16;
        bk bindingData;
        az azVar;
        String str;
        az azVar2;
        az azVar3;
        ba baVar;
        az azVar4;
        boolean z17;
        bk bindingData2 = getBindingData();
        boolean z18 = false;
        if (bindingData2 != null && (azVar4 = bindingData2.f440366b) != null) {
            if (azVar4.f440295v <= 0) {
                if (!r94.b.y(azVar4)) {
                    ba activity = azVar4.f440288o;
                    if (activity != null) {
                        Intrinsics.checkNotNullExpressionValue(activity, "activity");
                        if (com.tencent.mobileqq.zootopia.utils.g.f(activity)) {
                            z17 = true;
                        }
                    }
                    z17 = false;
                }
                z16 = true;
                this.mAnimHelper.u(z16);
                if (!this.isItemDressed) {
                    if (from != 2 && from != 3) {
                        this.mAnimHelper.o(false, this.inflatedViews);
                    } else {
                        this.mAnimHelper.o(true, this.inflatedViews);
                    }
                    if (z16) {
                        final HashMap hashMap = new HashMap();
                        bk bindingData3 = getBindingData();
                        JsonObject jsonObject = null;
                        az azVar5 = bindingData3 != null ? bindingData3.f440366b : null;
                        if (azVar5 == null || (str = r94.b.K(azVar5)) == null) {
                            str = "";
                        }
                        hashMap.put("zplan_item_id", str);
                        String str2 = (azVar5 == null || (baVar = azVar5.f440288o) == null) ? null : baVar.f440301b;
                        hashMap.put("zplan_act_id", str2 != null ? str2 : "");
                        bk bindingData4 = getBindingData();
                        if (bindingData4 != null && (azVar3 = bindingData4.f440366b) != null && r94.b.y(azVar3)) {
                            z18 = true;
                        }
                        hashMap.put("zplan_btn_type", Integer.valueOf(z18 ? 2 : 1));
                        bk bindingData5 = getBindingData();
                        if (bindingData5 != null && (azVar2 = bindingData5.f440366b) != null) {
                            jsonObject = r94.b.J(azVar2);
                        }
                        hashMap.put("zplan_ext_info", String.valueOf(jsonObject));
                        final View view = this.inflatedViews.get(Integer.valueOf(R.id.peu));
                        if (view != null) {
                            this.itemView.post(new Runnable() { // from class: com.tencent.sqshow.zootopia.nativeui.adapter.holder.ap
                                @Override // java.lang.Runnable
                                public final void run() {
                                    StoreItemViewHolder.y1(StoreItemViewHolder.this, view, hashMap);
                                }
                            });
                        }
                    }
                } else if (from != 2 && from != 3) {
                    this.mAnimHelper.j(false, this.inflatedViews);
                } else {
                    this.mAnimHelper.j(true, this.inflatedViews);
                }
                bindingData = getBindingData();
                if (bindingData != null || (azVar = bindingData.f440366b) == null) {
                }
                v1(azVar);
                return;
            }
            ba baVar2 = azVar4.f440288o;
        }
        z16 = false;
        this.mAnimHelper.u(z16);
        if (!this.isItemDressed) {
        }
        bindingData = getBindingData();
        if (bindingData != null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void y1(StoreItemViewHolder this$0, View it, HashMap reportParams) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(it, "$it");
        Intrinsics.checkNotNullParameter(reportParams, "$reportParams");
        this$0.getCom.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts.CHANNEL java.lang.String().getReporter().getMReporter().g(it, "em_zplan_activity_entrance", (r16 & 4) != 0 ? null : reportParams, (r16 & 8) != 0, (r16 & 16) != 0 ? null : null, (r16 & 32) != 0 ? false : false);
    }

    private final void z1() {
        w1();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void A1() {
        E1();
        G1();
        K1();
    }

    protected void B1() {
        az azVar;
        int groupId = this.category.getGroupId();
        String sectionId = this.category.getSectionId();
        String categoryId = this.category.getCategoryId();
        bk bindingData = getBindingData();
        String str = groupId + "_" + sectionId + "_" + categoryId + "_" + ((bindingData == null || (azVar = bindingData.f440366b) == null) ? null : azVar.B);
        ZplanViewReportHelper mReporter = getCom.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts.CHANNEL java.lang.String().getReporter().getMReporter();
        FrameLayout root = this.binding.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        mReporter.g(root, "em_zplan_item", (r16 & 4) != 0 ? null : d1(), (r16 & 8) != 0, (r16 & 16) != 0 ? null : str, (r16 & 32) != 0 ? false : false);
    }

    protected void C1() {
        az azVar;
        int groupId = this.category.getGroupId();
        String sectionId = this.category.getSectionId();
        String categoryId = this.category.getCategoryId();
        bk bindingData = getBindingData();
        String str = groupId + "_" + sectionId + "_" + categoryId + "_" + ((bindingData == null || (azVar = bindingData.f440366b) == null) ? null : azVar.B);
        ZplanViewReportHelper mReporter = getCom.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts.CHANNEL java.lang.String().getReporter().getMReporter();
        FrameLayout root = this.binding.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        ZplanViewReportHelper.j(mReporter, root, "em_zplan_item", d1(), false, str, 8, null);
    }

    @Override // com.tencent.sqshow.zootopia.nativeui.adapter.holder.BaseAvatarPanelItemViewHolder
    public String J0() {
        return "StoreItemViewHolder_";
    }

    @Override // com.tencent.sqshow.zootopia.nativeui.adapter.holder.BaseAvatarPanelItemViewHolder
    public NativePanelLoadingIgv O() {
        ViewStub viewStub = this.binding.f418600k;
        Intrinsics.checkNotNullExpressionValue(viewStub, "binding.loadingCircleViewViewstub");
        m1(viewStub);
        J1();
        View view = this.inflatedViews.get(Integer.valueOf(R.id.q65));
        if (view instanceof NativePanelLoadingIgv) {
            return (NativePanelLoadingIgv) view;
        }
        return null;
    }

    protected void W0(final az storeItemData) {
        String str;
        Intrinsics.checkNotNullParameter(storeItemData, "storeItemData");
        ba baVar = storeItemData.f440288o;
        Integer valueOf = Integer.valueOf(R.id.peu);
        if (baVar != null) {
            ViewStub viewStub = this.binding.f418594e;
            Intrinsics.checkNotNullExpressionValue(viewStub, "binding.bottomActivityContainerViewstub");
            m1(viewStub);
            D1();
            View view = this.inflatedViews.get(valueOf);
            TextView textView = view instanceof TextView ? (TextView) view : null;
            if (textView != null) {
                if (TextUtils.isEmpty(storeItemData.f440288o.f440303d)) {
                    str = "\u524d\u5f80\u6d3b\u52a8";
                } else {
                    str = storeItemData.f440288o.f440303d;
                }
                textView.setText(str);
            }
            if (textView != null) {
                textView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.sqshow.zootopia.nativeui.adapter.holder.an
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view2) {
                        StoreItemViewHolder.X0(az.this, this, view2);
                    }
                });
                return;
            }
            return;
        }
        this.mAnimHelper.u(false);
        View view2 = this.inflatedViews.get(Integer.valueOf(R.id.pep));
        if (view2 != null) {
            view2.setVisibility(8);
        }
        View view3 = this.inflatedViews.get(valueOf);
        if (view3 == null) {
            return;
        }
        view3.setVisibility(8);
    }

    @Override // com.tencent.sqshow.zootopia.nativeui.adapter.holder.BaseAvatarPanelItemViewHolder
    public boolean Y() {
        bk bindingData = getBindingData();
        az azVar = bindingData != null ? bindingData.f440366b : null;
        if (azVar == null || azVar.f440290q == null) {
            return false;
        }
        FilamentUrlTemplate a16 = getCom.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts.CHANNEL java.lang.String().getEngineApi().a();
        ZPlanAvatarResourceHelper zPlanAvatarResourceHelper = ZPlanAvatarResourceHelper.f105660o;
        return FilamentFileUtil.INSTANCE.fileExistsAtPath(zPlanAvatarResourceHelper.N0(zPlanAvatarResourceHelper.p0(r94.b.M(azVar), azVar.f440275b, a16), a16));
    }

    @Override // com.tencent.sqshow.zootopia.nativeui.adapter.holder.BaseAvatarPanelItemViewHolder
    protected boolean Z() {
        boolean contains$default;
        contains$default = StringsKt__StringsKt.contains$default((CharSequence) this.category.getCategoryId(), (CharSequence) "ootd", false, 2, (Object) null);
        return contains$default;
    }

    public void Z0(az storeItemData) {
        Intrinsics.checkNotNullParameter(storeItemData, "storeItemData");
        if (storeItemData.A > 0) {
            this.binding.f418597h.f418871g.setVisibility(8);
            this.binding.f418597h.f418874j.setVisibility(0);
            long serverTimeMillis = storeItemData.A - (NetConnInfoCenter.getServerTimeMillis() / 1000);
            if (serverTimeMillis > 0) {
                O1(serverTimeMillis);
                if (serverTimeMillis < 86400) {
                    N1(serverTimeMillis * 1000);
                    return;
                }
                return;
            }
            this.binding.f418597h.f418874j.setText("\u5df2\u8fc7\u671f");
            return;
        }
        this.binding.f418597h.f418871g.setVisibility(0);
        this.binding.f418597h.f418874j.setVisibility(8);
        this.binding.f418597h.f418874j.setText("");
        f1();
        if (!TextUtils.isEmpty(storeItemData.f440286m)) {
            this.binding.f418597h.f418871g.setVisibility(8);
            this.binding.f418597h.f418874j.setVisibility(0);
            this.binding.f418597h.f418874j.setText(storeItemData.f440286m);
            return;
        }
        bc bcVar = storeItemData.f440287n;
        if (bcVar == null) {
            this.binding.f418597h.f418871g.setVisibility(8);
            return;
        }
        int i3 = bcVar.f440315d;
        if (i3 == 0) {
            i3 = bcVar.f440313b;
        }
        int i16 = bcVar.f440316e;
        if (i16 == 0) {
            i16 = bcVar.f440314c;
        }
        int i17 = bcVar.f440312a;
        if (i17 == 1) {
            this.binding.f418597h.f418871g.setVisibility(0);
            this.binding.f418597h.f418867c.setVisibility(0);
            this.binding.f418597h.f418868d.setVisibility(0);
            this.binding.f418597h.f418870f.setVisibility(8);
            this.binding.f418597h.f418872h.setVisibility(8);
            this.binding.f418597h.f418873i.setVisibility(8);
            this.binding.f418597h.f418874j.setVisibility(8);
            this.binding.f418597h.f418868d.setText(String.valueOf(i3));
            return;
        }
        if (i17 == 2) {
            this.binding.f418597h.f418871g.setVisibility(0);
            this.binding.f418597h.f418867c.setVisibility(8);
            this.binding.f418597h.f418868d.setVisibility(8);
            this.binding.f418597h.f418870f.setVisibility(8);
            this.binding.f418597h.f418872h.setVisibility(0);
            this.binding.f418597h.f418873i.setVisibility(0);
            this.binding.f418597h.f418874j.setVisibility(8);
            this.binding.f418597h.f418873i.setText(String.valueOf(i16));
            return;
        }
        if (i17 == 3) {
            this.binding.f418597h.f418871g.setVisibility(0);
            this.binding.f418597h.f418867c.setVisibility(8);
            this.binding.f418597h.f418868d.setVisibility(8);
            this.binding.f418597h.f418870f.setVisibility(8);
            this.binding.f418597h.f418872h.setVisibility(0);
            this.binding.f418597h.f418873i.setVisibility(0);
            this.binding.f418597h.f418874j.setVisibility(8);
            this.binding.f418597h.f418873i.setText(String.valueOf(i16));
            return;
        }
        if (i17 != 4) {
            this.binding.f418597h.f418871g.setVisibility(8);
            String str = storeItemData.f440286m;
            TextView textView = this.binding.f418597h.f418874j;
            if (TextUtils.isEmpty(str)) {
                str = "\u53bb\u83b7\u53d6";
            }
            textView.setText(str);
            this.binding.f418597h.f418874j.setVisibility(0);
            QLog.i("StoreItemViewHolder_", 1, "priceType is :" + bcVar.f440312a);
            return;
        }
        this.binding.f418597h.f418871g.setVisibility(0);
        this.binding.f418597h.f418867c.setVisibility(0);
        this.binding.f418597h.f418868d.setVisibility(0);
        this.binding.f418597h.f418870f.setVisibility(0);
        this.binding.f418597h.f418872h.setVisibility(0);
        this.binding.f418597h.f418873i.setVisibility(0);
        this.binding.f418597h.f418874j.setVisibility(8);
        this.binding.f418597h.f418870f.setText(Marker.ANY_NON_NULL_MARKER);
        this.binding.f418597h.f418868d.setText(String.valueOf(i3));
        this.binding.f418597h.f418873i.setText(String.valueOf(i16));
    }

    protected void a1(az storeItemData) {
        Intrinsics.checkNotNullParameter(storeItemData, "storeItemData");
        boolean B = r94.b.B(com.tencent.sqshow.zootopia.nativeui.data.c.f370920a.n(), Integer.valueOf(storeItemData.f440296w));
        Integer valueOf = Integer.valueOf(R.id.qns);
        if (B) {
            ViewStub viewStub = this.binding.f418603n;
            Intrinsics.checkNotNullExpressionValue(viewStub, "binding.storeItemHighlightDescViewstub");
            m1(viewStub);
            F1();
            View view = this.inflatedViews.get(valueOf);
            TextView textView = view instanceof TextView ? (TextView) view : null;
            if (textView != null) {
                textView.setVisibility(0);
            }
            if (textView == null) {
                return;
            }
            textView.setText(this.mGenderInvalidString);
            return;
        }
        View view2 = this.inflatedViews.get(valueOf);
        if (view2 == null) {
            return;
        }
        view2.setVisibility(8);
    }

    protected void b1(az storeItemData) {
        Intrinsics.checkNotNullParameter(storeItemData, "storeItemData");
        String str = storeItemData.f440282i;
        boolean z16 = true;
        if (str == null || str.length() == 0) {
            View view = this.inflatedViews.get(Integer.valueOf(R.id.q4p));
            if (view != null) {
                view.setVisibility(8);
            }
        } else {
            ViewStub viewStub = this.binding.f418599j;
            Intrinsics.checkNotNullExpressionValue(viewStub, "binding.leftTopLabelViewstub");
            m1(viewStub);
            I1();
            View view2 = this.inflatedViews.get(Integer.valueOf(R.id.q4p));
            URLImageView uRLImageView = view2 instanceof URLImageView ? (URLImageView) view2 : null;
            if (uRLImageView != null) {
                String str2 = storeItemData.f440282i;
                Intrinsics.checkNotNullExpressionValue(str2, "storeItemData.brandLabel");
                CommonExKt.w(uRLImageView, str2, null, null, 6, null);
            }
            if (uRLImageView != null) {
                uRLImageView.setVisibility(0);
            }
        }
        String str3 = storeItemData.f440283j;
        if (str3 != null && str3.length() != 0) {
            z16 = false;
        }
        if (z16) {
            View view3 = this.inflatedViews.get(Integer.valueOf(R.id.qhs));
            if (view3 == null) {
                return;
            }
            view3.setVisibility(8);
            return;
        }
        ViewStub viewStub2 = this.binding.f418602m;
        Intrinsics.checkNotNullExpressionValue(viewStub2, "binding.rightTopLabelViewstub");
        m1(viewStub2);
        L1();
        View view4 = this.inflatedViews.get(Integer.valueOf(R.id.qhs));
        URLImageView uRLImageView2 = view4 instanceof URLImageView ? (URLImageView) view4 : null;
        if (uRLImageView2 != null) {
            String str4 = storeItemData.f440283j;
            Intrinsics.checkNotNullExpressionValue(str4, "storeItemData.saleLabel");
            CommonExKt.w(uRLImageView2, str4, com.tencent.sqshow.zootopia.utils.q.b(R.drawable.h4a), null, 4, null);
        }
        if (uRLImageView2 == null) {
            return;
        }
        uRLImageView2.setVisibility(0);
    }

    public void c1(int id5) {
        this.binding.f418601l.g(1);
        this.binding.f418601l.h(id5);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    public HashMap<String, Object> d1() {
        String str;
        az azVar;
        az azVar2;
        az azVar3;
        az azVar4;
        az azVar5;
        az azVar6;
        az azVar7;
        az azVar8;
        be beVar;
        bk bindingData = getBindingData();
        int i3 = (bindingData == null || (azVar8 = bindingData.f440366b) == null || (beVar = azVar8.f440290q) == null) ? -1 : beVar.f440324a;
        bk bindingData2 = getBindingData();
        int i16 = (bindingData2 == null || (azVar7 = bindingData2.f440366b) == null) ? -1 : azVar7.f440275b;
        int i17 = 0;
        int k3 = (i3 == -1 || i16 == -1) ? 0 : ZPlanAvatarPreDownloadManager.f371947a.k(i3, i16);
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("zplan_mall_type", Integer.valueOf(this.category.getGroupId()));
        hashMap.put("zplan_tab_id", Integer.valueOf(this.category.getGroupId()));
        bk bindingData3 = getBindingData();
        if (bindingData3 == null || (azVar6 = bindingData3.f440366b) == null || (str = r94.b.K(azVar6)) == null) {
            str = "";
        }
        hashMap.put("zplan_item_id", str);
        bk bindingData4 = getBindingData();
        JsonObject jsonObject = null;
        String str2 = (bindingData4 == null || (azVar5 = bindingData4.f440366b) == null) ? null : azVar5.f440286m;
        if (str2 == null) {
            str2 = "";
        }
        hashMap.put("zplan_bottom_content", str2);
        bk bindingData5 = getBindingData();
        String str3 = (bindingData5 == null || (azVar4 = bindingData5.f440366b) == null) ? null : azVar4.f440283j;
        hashMap.put("zplan_corner_label", str3 != null ? str3 : "");
        hashMap.put("zplan_is_pre_download", Integer.valueOf(k3));
        hashMap.put("zplan_item_pos", String.valueOf(this.itemPosition));
        bk bindingData6 = getBindingData();
        hashMap.put("zplan_item_status_type", Integer.valueOf((bindingData6 == null || (azVar3 = bindingData6.f440366b) == null) ? 0 : azVar3.I));
        hashMap.put("zplan_subtab_id", this.category.getSectionId());
        hashMap.put("zplan_thirtab_id", this.category.getCategoryId());
        hashMap.put("zplan_is_bigcard_show", Integer.valueOf(this.sizeHelper.getIsBigPic() ? 1 : 0));
        bk bindingData7 = getBindingData();
        if (bindingData7 != null && (azVar2 = bindingData7.f440366b) != null && azVar2.N) {
            i17 = 1;
        }
        hashMap.put("zplan_is_more", Integer.valueOf(i17));
        bk bindingData8 = getBindingData();
        if (bindingData8 != null && (azVar = bindingData8.f440366b) != null) {
            jsonObject = r94.b.J(azVar);
        }
        hashMap.put("zplan_ext_info", String.valueOf(jsonObject));
        return hashMap;
    }

    @Override // com.tencent.sqshow.zootopia.nativeui.adapter.holder.BaseAvatarPanelItemViewHolder
    public void e0(bk data, int posInList, ArrayList<bk> totalData) {
        Intrinsics.checkNotNullParameter(totalData, "totalData");
        if (data == null) {
            return;
        }
        this.itemPosition = posInList;
        A1();
        final az azVar = data.f440366b;
        if (azVar == null) {
            azVar = new az();
        }
        D0(data);
        this.mAnimHelper.w(data);
        W0(azVar);
        u1(azVar);
        az azVar2 = data.f440366b;
        int i3 = azVar2 != null ? azVar2.D : 0;
        this.redDotId = i3;
        c1(i3);
        RoundCornerImageView roundCornerImageView = this.binding.f418598i;
        Intrinsics.checkNotNullExpressionValue(roundCornerImageView, "binding.itemIcon");
        String str = azVar.f440279f;
        Intrinsics.checkNotNullExpressionValue(str, "storeItemData.icon");
        CommonExKt.w(roundCornerImageView, str, this.binding.getRoot().getResources().getDrawable(R.drawable.h4b), null, 4, null);
        if (J()) {
            this.binding.getRoot().setOnLongClickListener(new View.OnLongClickListener() { // from class: com.tencent.sqshow.zootopia.nativeui.adapter.holder.aj
                @Override // android.view.View.OnLongClickListener
                public final boolean onLongClick(View view) {
                    boolean p16;
                    p16 = StoreItemViewHolder.p1(StoreItemViewHolder.this, azVar, view);
                    return p16;
                }
            });
        }
        M1(azVar);
        this.itemView.post(new Runnable() { // from class: com.tencent.sqshow.zootopia.nativeui.adapter.holder.ak
            @Override // java.lang.Runnable
            public final void run() {
                StoreItemViewHolder.r1(StoreItemViewHolder.this);
            }
        });
        FrameLayout root = this.binding.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        com.tencent.sqshow.zootopia.utils.aa.e(root, new View.OnClickListener() { // from class: com.tencent.sqshow.zootopia.nativeui.adapter.holder.al
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                StoreItemViewHolder.s1(StoreItemViewHolder.this, azVar, view);
            }
        }, 10L);
        z1();
        x1(1);
        b1(azVar);
        a1(azVar);
        Z0(azVar);
    }

    @Override // com.tencent.sqshow.zootopia.nativeui.adapter.holder.BaseAvatarPanelItemViewHolder
    protected void f0(CollectInfo collectInfo) {
        Intrinsics.checkNotNullParameter(collectInfo, "collectInfo");
        bk bindingData = getBindingData();
        az azVar = bindingData != null ? bindingData.f440366b : null;
        if (Intrinsics.areEqual(azVar != null ? azVar.B : null, collectInfo.getItem().B)) {
            u1(azVar);
        }
    }

    public void h1() {
        g94.f.b(g94.f.f401577a, this.redDotId, this.binding.f418601l.getStoreType(), 0, true, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.sqshow.zootopia.nativeui.adapter.holder.BaseAvatarPanelItemViewHolder
    public void i0(List<String> idList) {
        Intrinsics.checkNotNullParameter(idList, "idList");
        super.i0(idList);
        z1();
        x1(2);
    }

    /* renamed from: j1, reason: from getter */
    public final n74.ad getBinding() {
        return this.binding;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final HashMap<Integer, View> k1() {
        return this.inflatedViews;
    }

    /* renamed from: l1, reason: from getter */
    public final g94.g getSizeHelper() {
        return this.sizeHelper;
    }

    protected final void m1(ViewStub viewStub) {
        Intrinsics.checkNotNullParameter(viewStub, "viewStub");
        if (viewStub.getParent() == null) {
            return;
        }
        viewStub.setOnInflateListener(new ViewStub.OnInflateListener() { // from class: com.tencent.sqshow.zootopia.nativeui.adapter.holder.am
            @Override // android.view.ViewStub.OnInflateListener
            public final void onInflate(ViewStub viewStub2, View view) {
                StoreItemViewHolder.n1(StoreItemViewHolder.this, viewStub2, view);
            }
        });
        viewStub.inflate();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.sqshow.zootopia.nativeui.adapter.holder.BaseAvatarPanelItemViewHolder
    public void p0(ConcurrentHashMap<Long, az> adStoreItem) {
        az azVar;
        az it;
        Intrinsics.checkNotNullParameter(adStoreItem, "adStoreItem");
        super.p0(adStoreItem);
        bk bindingData = getBindingData();
        if (bindingData == null || (azVar = bindingData.f440366b) == null || (it = adStoreItem.get(Long.valueOf(azVar.f440274a))) == null) {
            return;
        }
        Intrinsics.checkNotNullExpressionValue(it, "it");
        v1(it);
    }

    @Override // com.tencent.sqshow.zootopia.nativeui.adapter.holder.BaseAvatarPanelItemViewHolder
    public void q0() {
        super.q0();
        h1();
        C1();
    }

    protected void reportClick() {
        ZplanViewReportHelper mReporter = getCom.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts.CHANNEL java.lang.String().getReporter().getMReporter();
        FrameLayout root = this.binding.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        mReporter.e(root, "em_zplan_item", d1());
    }

    protected void u1(az data) {
        boolean i3 = g94.b.f401562a.i(data);
        Integer valueOf = Integer.valueOf(R.id.pkp);
        if (i3) {
            ViewStub viewStub = this.binding.f418595f;
            Intrinsics.checkNotNullExpressionValue(viewStub, "binding.collectedHintAreaViewstub");
            m1(viewStub);
            View view = this.inflatedViews.get(valueOf);
            if (view == null) {
                return;
            }
            view.setVisibility(0);
            return;
        }
        View view2 = this.inflatedViews.get(valueOf);
        if (view2 == null) {
            return;
        }
        view2.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.sqshow.zootopia.nativeui.adapter.holder.BaseAvatarPanelItemViewHolder
    public void w() {
        super.w();
        if (this.isItemDressed) {
            getCom.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts.CHANNEL java.lang.String().i().setValue(null);
            return;
        }
        MutableLiveData<az> i3 = getCom.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts.CHANNEL java.lang.String().i();
        bk bindingData = getBindingData();
        i3.setValue(bindingData != null ? bindingData.f440366b : null);
    }

    protected void g1(boolean itemDressingOrDressed) {
        if (!itemDressingOrDressed) {
            getCom.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts.CHANNEL java.lang.String().k().setValue(getBindingData());
        } else {
            getCom.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts.CHANNEL java.lang.String().k().setValue(null);
        }
    }

    private final String i1(long durationInSec) {
        long j3 = durationInSec / 86400;
        if (j3 > 0) {
            return j3 + "\u5929";
        }
        long j16 = 3600;
        long j17 = durationInSec / j16;
        long j18 = durationInSec - (j16 * j17);
        long j19 = 60;
        long j26 = j18 / j19;
        long j27 = j18 - (j19 * j26);
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String format = String.format("%02d", Arrays.copyOf(new Object[]{Long.valueOf(j17)}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
        String format2 = String.format("%02d", Arrays.copyOf(new Object[]{Long.valueOf(j26)}, 1));
        Intrinsics.checkNotNullExpressionValue(format2, "format(format, *args)");
        String format3 = String.format("%02d", Arrays.copyOf(new Object[]{Long.valueOf(j27)}, 1));
        Intrinsics.checkNotNullExpressionValue(format3, "format(format, *args)");
        return format + ":" + format2 + ":" + format3;
    }
}
