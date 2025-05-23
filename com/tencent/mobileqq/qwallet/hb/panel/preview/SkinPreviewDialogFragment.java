package com.tencent.mobileqq.qwallet.hb.panel.preview;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.FragmentKt;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.viewpager2.widget.ViewPager2;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.activity.QPublicTransFragmentActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qwallet.QWalletBottomSheetDialogFragment;
import com.tencent.mobileqq.qwallet.WeakFragmentReceiver;
import com.tencent.mobileqq.qwallet.hb.IQWalletHbApi;
import com.tencent.mobileqq.qwallet.hb.panel.PanelViewModel;
import com.tencent.mobileqq.qwallet.hb.panel.m;
import com.tencent.mobileqq.qwallet.hb.panel.recommend.HbListRecommendSkinViewModel;
import com.tencent.mobileqq.qwallet.hb.panel.recommend.SendHbOpActivitiesViewModel;
import com.tencent.mobileqq.qwallet.hb.panel.recommend.SkinRecommendViewModel;
import com.tencent.mobileqq.qwallet.hb.skin.share.HbSkinShareEntryFragment;
import com.tencent.mobileqq.qwallet.k;
import com.tencent.mobileqq.qwallet.pb.RedPackSkin$Disclosure;
import com.tencent.mobileqq.qwallet.pb.RedPackSkin$RecommendActivity;
import com.tencent.mobileqq.qwallet.pb.RedPackSkin$RecommendSkin;
import com.tencent.mobileqq.qwallet.pb.RedPackSkinExt;
import com.tencent.mobileqq.qwallet.pb.a;
import com.tencent.mobileqq.util.x;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.shadow.core.runtime.skin.loader.SkinResFactory;
import cooperation.qwallet.plugin.QWalletPicHelper;
import cooperation.qzone.QzoneIPCModule;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u00b9\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\b\t*\u0001\u007f\u0018\u0000 \u0085\u00012\u00020\u0001:\u0002\u0086\u0001B\t\u00a2\u0006\u0006\b\u0083\u0001\u0010\u0084\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\b\u0010\b\u001a\u00020\u0002H\u0002J\b\u0010\t\u001a\u00020\u0002H\u0002J\b\u0010\n\u001a\u00020\u0002H\u0002J\u0010\u0010\u000b\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\b\u0010\r\u001a\u00020\fH\u0002J\u0012\u0010\u0010\u001a\u00020\u00022\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016J\u0010\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0011H\u0016J&\u0010\u0019\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0015\u001a\u00020\u00142\b\u0010\u0017\u001a\u0004\u0018\u00010\u00162\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016J\u001a\u0010\u001b\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u00182\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016J\u0010\u0010\u001e\u001a\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u001cH\u0016J\u0010\u0010!\u001a\u00020\u00022\u0006\u0010 \u001a\u00020\u001fH\u0016J\b\u0010\"\u001a\u00020\u0002H\u0016J\u0010\u0010#\u001a\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u001cH\u0016J\u0012\u0010%\u001a\u00020$2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016J\b\u0010&\u001a\u00020\u0002H\u0016J\"\u0010+\u001a\u00020\u00022\u0006\u0010'\u001a\u00020\f2\u0006\u0010(\u001a\u00020\f2\b\u0010*\u001a\u0004\u0018\u00010)H\u0016R$\u00103\u001a\u0004\u0018\u00010,8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b-\u0010.\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\u0018\u00106\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b4\u00105R\u0016\u0010:\u001a\u0002078\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b8\u00109R\u0016\u0010=\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b;\u0010<R\u0016\u0010?\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b>\u0010<R\u0016\u0010A\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b@\u0010<R\u0014\u0010D\u001a\u00020B8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b<\u0010CR\u0016\u0010H\u001a\u00020E8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bF\u0010GR\u0016\u0010J\u001a\u00020E8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bI\u0010GR\u0014\u0010L\u001a\u00020B8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bK\u0010CR\u0016\u0010P\u001a\u00020M8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bN\u0010OR\u0016\u0010T\u001a\u00020Q8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bR\u0010SR\u0016\u0010X\u001a\u00020U8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bV\u0010WR\u0016\u0010\\\u001a\u00020Y8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bZ\u0010[R\u0016\u0010^\u001a\u00020Y8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b]\u0010[R\u0016\u0010b\u001a\u00020_8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b`\u0010aR\u0016\u0010d\u001a\u00020_8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bc\u0010aR\u0016\u0010f\u001a\u00020Y8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\be\u0010[R\u0016\u0010h\u001a\u00020_8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bg\u0010aR\u0016\u0010k\u001a\u00020\u00168\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bi\u0010jR\u0016\u0010m\u001a\u00020Y8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bl\u0010[R\u0016\u0010o\u001a\u00020_8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bn\u0010aR\u0016\u0010p\u001a\u00020Y8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bG\u0010[R\u0016\u0010r\u001a\u00020\u00168\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bq\u0010jR\u0016\u0010t\u001a\u00020Y8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bs\u0010[R\u0016\u0010v\u001a\u00020_8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bu\u0010aR\u0016\u0010x\u001a\u00020_8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bw\u0010aR\u0016\u0010|\u001a\u00020y8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bz\u0010{R\u0016\u0010~\u001a\u00020_8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b}\u0010aR\u0017\u0010\u0082\u0001\u001a\u00020\u007f8\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u0080\u0001\u0010\u0081\u0001\u00a8\u0006\u0087\u0001"}, d2 = {"Lcom/tencent/mobileqq/qwallet/hb/panel/preview/SkinPreviewDialogFragment;", "Lcom/tencent/mobileqq/qwallet/QWalletBottomSheetDialogFragment;", "", "Ih", "Eh", "Lcom/tencent/mobileqq/qwallet/pb/RedPackSkin$RecommendSkin;", SkinResFactory.SKIN_THEME_APK_SAVE_DIR, "Lh", "Kh", "Bh", "Gh", "Mh", "", "Ch", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onCreate", "Landroid/content/Context;", "context", "onAttach", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/view/View;", "onCreateView", "view", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "Landroid/content/DialogInterface;", "dialog", "onDismiss", "Landroid/content/res/Configuration;", "newConfig", "onConfigurationChanged", "onStart", "onCancel", "Landroid/app/Dialog;", "onCreateDialog", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "requestCode", QzoneIPCModule.RESULT_CODE, "Landroid/content/Intent;", "data", "onActivityResult", "Lcom/tencent/mobileqq/qwallet/hb/panel/b;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/qwallet/hb/panel/b;", "Dh", "()Lcom/tencent/mobileqq/qwallet/hb/panel/b;", "Jh", "(Lcom/tencent/mobileqq/qwallet/hb/panel/b;)V", "recommendSkinHost", "D", "Lcom/tencent/mobileqq/qwallet/pb/RedPackSkin$RecommendSkin;", "curSkinInfo", "Lcom/tencent/mobileqq/qwallet/hb/panel/recommend/SkinRecommendViewModel;", "E", "Lcom/tencent/mobileqq/qwallet/hb/panel/recommend/SkinRecommendViewModel;", "skinRecommendViewModel", UserInfo.SEX_FEMALE, "I", "initSkinId", "G", WadlProxyConsts.SCENE_ID, "H", "themeId", "Ljava/util/concurrent/atomic/AtomicBoolean;", "Ljava/util/concurrent/atomic/AtomicBoolean;", "isDataInitialized", "", "J", "Z", "isClickDismissBtn", "K", "isShareClicked", "L", "isRegisterReceiver", "Lcom/tencent/mobileqq/qwallet/hb/panel/preview/e;", "M", "Lcom/tencent/mobileqq/qwallet/hb/panel/preview/e;", "pagerAdapter", "Landroid/view/ContextThemeWrapper;", "N", "Landroid/view/ContextThemeWrapper;", "themeContext", "Landroidx/viewpager2/widget/ViewPager2;", "P", "Landroidx/viewpager2/widget/ViewPager2;", "viewPager", "Landroid/widget/ImageView;", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Landroid/widget/ImageView;", "closeBtn", BdhLogUtil.LogTag.Tag_Req, "shareBtn", "Landroid/widget/TextView;", ExifInterface.LATITUDE_SOUTH, "Landroid/widget/TextView;", "skinTitle", "T", "skinLabel", "U", "skinBadge", "V", "recommendText", "W", "Landroid/view/ViewGroup;", "recommendAuthorContainer", "X", "recommendAuthorLogo", "Y", "recommendAuthorLink", "recommendImg", "a0", "recommendDisclosureContainer", "b0", "recommendDisclosureLogo", "c0", "recommendDisclosureTitle", "d0", "recommendDisclosureDesc", "Landroid/widget/Button;", "e0", "Landroid/widget/Button;", "recommendDisclosureBtn", "f0", "jumpBtn", "com/tencent/mobileqq/qwallet/hb/panel/preview/SkinPreviewDialogFragment$sendHbReceiver$1", "g0", "Lcom/tencent/mobileqq/qwallet/hb/panel/preview/SkinPreviewDialogFragment$sendHbReceiver$1;", "sendHbReceiver", "<init>", "()V", "h0", "a", "qqpay-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class SkinPreviewDialogFragment extends QWalletBottomSheetDialogFragment {

    /* renamed from: h0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private com.tencent.mobileqq.qwallet.hb.panel.b recommendSkinHost;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private RedPackSkin$RecommendSkin curSkinInfo;

    /* renamed from: E, reason: from kotlin metadata */
    private SkinRecommendViewModel skinRecommendViewModel;

    /* renamed from: J, reason: from kotlin metadata */
    private boolean isClickDismissBtn;

    /* renamed from: K, reason: from kotlin metadata */
    private boolean isShareClicked;

    /* renamed from: M, reason: from kotlin metadata */
    private e pagerAdapter;

    /* renamed from: N, reason: from kotlin metadata */
    private ContextThemeWrapper themeContext;

    /* renamed from: P, reason: from kotlin metadata */
    private ViewPager2 viewPager;

    /* renamed from: Q, reason: from kotlin metadata */
    private ImageView closeBtn;

    /* renamed from: R, reason: from kotlin metadata */
    private ImageView shareBtn;

    /* renamed from: S, reason: from kotlin metadata */
    private TextView skinTitle;

    /* renamed from: T, reason: from kotlin metadata */
    private TextView skinLabel;

    /* renamed from: U, reason: from kotlin metadata */
    private ImageView skinBadge;

    /* renamed from: V, reason: from kotlin metadata */
    private TextView recommendText;

    /* renamed from: W, reason: from kotlin metadata */
    private ViewGroup recommendAuthorContainer;

    /* renamed from: X, reason: from kotlin metadata */
    private ImageView recommendAuthorLogo;

    /* renamed from: Y, reason: from kotlin metadata */
    private TextView recommendAuthorLink;

    /* renamed from: Z, reason: from kotlin metadata */
    private ImageView recommendImg;

    /* renamed from: a0, reason: collision with root package name and from kotlin metadata */
    private ViewGroup recommendDisclosureContainer;

    /* renamed from: b0, reason: collision with root package name and from kotlin metadata */
    private ImageView recommendDisclosureLogo;

    /* renamed from: c0, reason: collision with root package name and from kotlin metadata */
    private TextView recommendDisclosureTitle;

    /* renamed from: d0, reason: collision with root package name and from kotlin metadata */
    private TextView recommendDisclosureDesc;

    /* renamed from: e0, reason: collision with root package name and from kotlin metadata */
    private Button recommendDisclosureBtn;

    /* renamed from: f0, reason: collision with root package name and from kotlin metadata */
    private TextView jumpBtn;

    /* renamed from: F, reason: from kotlin metadata */
    private int initSkinId = -1;

    /* renamed from: G, reason: from kotlin metadata */
    private int sceneId = -1;

    /* renamed from: H, reason: from kotlin metadata */
    private int themeId = m.f277567a.a();

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private final AtomicBoolean isDataInitialized = new AtomicBoolean(false);

    /* renamed from: L, reason: from kotlin metadata */
    @NotNull
    private final AtomicBoolean isRegisterReceiver = new AtomicBoolean(false);

    /* renamed from: g0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final SkinPreviewDialogFragment$sendHbReceiver$1 sendHbReceiver = new WeakFragmentReceiver<SkinPreviewDialogFragment>(this) { // from class: com.tencent.mobileqq.qwallet.hb.panel.preview.SkinPreviewDialogFragment$sendHbReceiver$1
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(this);
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(@Nullable Context context, @Nullable Intent intent) {
            String action;
            SkinPreviewDialogFragment skinPreviewDialogFragment;
            if (intent != null && (action = intent.getAction()) != null && Intrinsics.areEqual("com.tencent.mobileqq.qwallet.send.message", action) && (skinPreviewDialogFragment = getFragmentRef().get()) != null) {
                skinPreviewDialogFragment.dismiss();
            }
        }
    };

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000f\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0018\u0010\u0019J \u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0002H\u0007R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\f\u001a\u00020\u000b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u00020\u000b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\rR\u0014\u0010\u000f\u001a\u00020\u000b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\rR\u0014\u0010\u0010\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0011R\u0014\u0010\u0013\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0011R\u0014\u0010\u0014\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0011R\u0014\u0010\u0015\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0011R\u0014\u0010\u0016\u001a\u00020\u000b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\rR\u0014\u0010\u0017\u001a\u00020\u000b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\r\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/mobileqq/qwallet/hb/panel/preview/SkinPreviewDialogFragment$a;", "", "", "previewScene", "selectedSkinId", "themeId", "Lcom/tencent/mobileqq/qwallet/hb/panel/preview/SkinPreviewDialogFragment;", "a", "", "HB_COVER_WIDTH_HEIGHT_RATE", UserInfo.SEX_FEMALE, "", "KEY_INIT_SKIN_ID", "Ljava/lang/String;", "KEY_PREVIEW_SCENE", "KEY_THEME_ID", "REQUEST_CODE_SHARE_SKIN", "I", "SCENE_HB_PANEL", "SCENE_SEND_ENTRY", "SCENE_SEND_HB", "SCENE_SKIN_LIST", "SKIN_PREVIEW_REQUEST_KEY", "TAG", "<init>", "()V", "qqpay-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qwallet.hb.panel.preview.SkinPreviewDialogFragment$a, reason: from kotlin metadata */
    /* loaded from: classes16.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        @NotNull
        public final SkinPreviewDialogFragment a(int previewScene, int selectedSkinId, int themeId) {
            QLog.i("SkinPreviewDialogFragment", 1, "start SkinPreviewDialogFragment, previewScene=" + previewScene + " selectedSkinId=" + selectedSkinId);
            Bundle bundle = new Bundle();
            bundle.putInt("init_skin_id", selectedSkinId);
            bundle.putInt("theme_id", themeId);
            bundle.putInt("preview_scene", previewScene);
            SkinPreviewDialogFragment skinPreviewDialogFragment = new SkinPreviewDialogFragment();
            skinPreviewDialogFragment.setArguments(bundle);
            return skinPreviewDialogFragment;
        }

        Companion() {
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/qwallet/hb/panel/preview/SkinPreviewDialogFragment$b", "Landroidx/viewpager2/widget/ViewPager2$OnPageChangeCallback;", "", "position", "", "onPageSelected", "qqpay-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes16.dex */
    public static final class b extends ViewPager2.OnPageChangeCallback {
        b() {
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageSelected(int position) {
            e eVar = SkinPreviewDialogFragment.this.pagerAdapter;
            e eVar2 = null;
            if (eVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("pagerAdapter");
                eVar = null;
            }
            if (eVar.getListSize() > 0) {
                SkinPreviewDialogFragment skinPreviewDialogFragment = SkinPreviewDialogFragment.this;
                e eVar3 = skinPreviewDialogFragment.pagerAdapter;
                if (eVar3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("pagerAdapter");
                } else {
                    eVar2 = eVar3;
                }
                skinPreviewDialogFragment.Mh(eVar2.getItem(position));
            }
        }
    }

    private final void Bh() {
        int coerceAtLeast;
        int Ch = Ch();
        ViewPager2 viewPager2 = this.viewPager;
        ViewPager2 viewPager22 = null;
        if (viewPager2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewPager");
            viewPager2 = null;
        }
        int dimensionPixelSize = viewPager2.getContext().getResources().getDimensionPixelSize(R.dimen.dcd);
        ViewPager2 viewPager23 = this.viewPager;
        if (viewPager23 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewPager");
            viewPager23 = null;
        }
        int dimensionPixelSize2 = viewPager23.getContext().getResources().getDimensionPixelSize(R.dimen.dcn);
        ViewPager2 viewPager24 = this.viewPager;
        if (viewPager24 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewPager");
            viewPager24 = null;
        }
        int dimensionPixelSize3 = viewPager24.getContext().getResources().getDimensionPixelSize(R.dimen.dcm);
        ViewPager2 viewPager25 = this.viewPager;
        if (viewPager25 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewPager");
            viewPager25 = null;
        }
        int dimensionPixelSize4 = viewPager25.getContext().getResources().getDimensionPixelSize(R.dimen.dck);
        int i3 = ((Ch - dimensionPixelSize) - dimensionPixelSize2) - dimensionPixelSize3;
        if (i3 > dimensionPixelSize4) {
            QLog.i("SkinPreviewDialogFragment", 1, "ignored adjustViewPager, maxPagerHeight=" + i3 + " targetPagerHeight=" + dimensionPixelSize4);
            return;
        }
        ViewPager2 viewPager26 = this.viewPager;
        if (viewPager26 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewPager");
            viewPager26 = null;
        }
        coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(i3, viewPager26.getContext().getResources().getDimensionPixelSize(R.dimen.dcl));
        ViewPager2 viewPager27 = this.viewPager;
        if (viewPager27 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewPager");
            viewPager27 = null;
        }
        viewPager27.getLayoutParams().height = coerceAtLeast;
        float f16 = coerceAtLeast * 0.6666667f;
        int b16 = x.f(getContext()).b();
        int i16 = 0;
        if (b16 > 2 * f16) {
            int i17 = b16 / 4;
            ViewPager2 viewPager28 = this.viewPager;
            if (viewPager28 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewPager");
            } else {
                viewPager22 = viewPager28;
            }
            viewPager22.setPadding(i17, 0, i17, 0);
            i16 = i17;
        }
        QLog.i("SkinPreviewDialogFragment", 1, "adjustViewPager: deviceWidth=" + b16 + " hbHeight=" + coerceAtLeast + " hbWidth=" + f16 + " padding=" + i16);
    }

    private final int Ch() {
        return (int) (x.f(getContext()).a() * 0.9f);
    }

    private final void Eh() {
        Bundle arguments = getArguments();
        int i3 = -1;
        if (arguments != null) {
            i3 = arguments.getInt("preview_scene", -1);
        }
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 != 3) {
                        dismissAllowingStateLoss();
                    } else {
                        this.skinRecommendViewModel = ((SkinPreviewEntryViewModel) new ViewModelProvider(requireActivity()).get(SkinPreviewEntryViewModel.class)).getSkinRecommendVM();
                    }
                } else {
                    this.skinRecommendViewModel = ((SendHbOpActivitiesViewModel) new ViewModelProvider(requireActivity()).get(SendHbOpActivitiesViewModel.class)).R1();
                }
            } else {
                ViewModel viewModel = new ViewModelProvider(requireActivity()).get(HbListRecommendSkinViewModel.class);
                Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProvider(requir\u2026kinViewModel::class.java)");
                this.skinRecommendViewModel = (SkinRecommendViewModel) viewModel;
            }
        } else {
            this.skinRecommendViewModel = ((PanelViewModel) new ViewModelProvider(requireActivity()).get(PanelViewModel.class)).getSkinRecommendVM();
            Ih();
        }
        SkinRecommendViewModel skinRecommendViewModel = this.skinRecommendViewModel;
        if (skinRecommendViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("skinRecommendViewModel");
            skinRecommendViewModel = null;
        }
        QLog.i("SkinPreviewDialogFragment", 1, "initSkinViewModel: " + i3 + " " + skinRecommendViewModel);
    }

    @JvmStatic
    @NotNull
    public static final SkinPreviewDialogFragment Fh(int i3, int i16, int i17) {
        return INSTANCE.a(i3, i16, i17);
    }

    private final void Gh() {
        SkinRecommendViewModel skinRecommendViewModel = this.skinRecommendViewModel;
        if (skinRecommendViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("skinRecommendViewModel");
            skinRecommendViewModel = null;
        }
        MutableLiveData<List<com.tencent.mobileqq.qwallet.pb.a>> Z1 = skinRecommendViewModel.Z1();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        final Function1<List<? extends com.tencent.mobileqq.qwallet.pb.a>, Unit> function1 = new Function1<List<? extends com.tencent.mobileqq.qwallet.pb.a>, Unit>() { // from class: com.tencent.mobileqq.qwallet.hb.panel.preview.SkinPreviewDialogFragment$observeData$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(List<? extends com.tencent.mobileqq.qwallet.pb.a> list) {
                invoke2(list);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(List<? extends com.tencent.mobileqq.qwallet.pb.a> recommendItem) {
                int collectionSizeOrDefault;
                Intrinsics.checkNotNullExpressionValue(recommendItem, "recommendItem");
                ArrayList arrayList = new ArrayList();
                for (Object obj : recommendItem) {
                    if (obj instanceof a.Skin) {
                        arrayList.add(obj);
                    }
                }
                collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10);
                final ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault);
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    arrayList2.add(((a.Skin) it.next()).getValue());
                }
                e eVar = SkinPreviewDialogFragment.this.pagerAdapter;
                if (eVar == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("pagerAdapter");
                    eVar = null;
                }
                final SkinPreviewDialogFragment skinPreviewDialogFragment = SkinPreviewDialogFragment.this;
                eVar.m0(arrayList2, new Function0<Unit>() { // from class: com.tencent.mobileqq.qwallet.hb.panel.preview.SkinPreviewDialogFragment$observeData$1.1
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
                        AtomicBoolean atomicBoolean;
                        ViewPager2 viewPager2;
                        int coerceAtLeast;
                        ViewPager2 viewPager22;
                        int i3;
                        if (arrayList2.isEmpty()) {
                            return;
                        }
                        atomicBoolean = skinPreviewDialogFragment.isDataInitialized;
                        ViewPager2 viewPager23 = null;
                        if (atomicBoolean.compareAndSet(false, true)) {
                            List<RedPackSkin$RecommendSkin> list = arrayList2;
                            SkinPreviewDialogFragment skinPreviewDialogFragment2 = skinPreviewDialogFragment;
                            Iterator<RedPackSkin$RecommendSkin> it5 = list.iterator();
                            int i16 = 0;
                            while (true) {
                                if (!it5.hasNext()) {
                                    i16 = -1;
                                    break;
                                }
                                int f16 = RedPackSkinExt.f(it5.next());
                                i3 = skinPreviewDialogFragment2.initSkinId;
                                if (f16 == i3) {
                                    break;
                                } else {
                                    i16++;
                                }
                            }
                            coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(i16, 0);
                            e eVar2 = skinPreviewDialogFragment.pagerAdapter;
                            if (eVar2 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("pagerAdapter");
                                eVar2 = null;
                            }
                            int o06 = eVar2.o0(coerceAtLeast);
                            viewPager22 = skinPreviewDialogFragment.viewPager;
                            if (viewPager22 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("viewPager");
                                viewPager22 = null;
                            }
                            viewPager22.setCurrentItem(o06, false);
                        }
                        SkinPreviewDialogFragment skinPreviewDialogFragment3 = skinPreviewDialogFragment;
                        e eVar3 = skinPreviewDialogFragment3.pagerAdapter;
                        if (eVar3 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("pagerAdapter");
                            eVar3 = null;
                        }
                        viewPager2 = skinPreviewDialogFragment.viewPager;
                        if (viewPager2 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("viewPager");
                        } else {
                            viewPager23 = viewPager2;
                        }
                        skinPreviewDialogFragment3.Mh(eVar3.getItem(viewPager23.getCurrentItem()));
                    }
                });
            }
        };
        Z1.observe(viewLifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.qwallet.hb.panel.preview.a
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                SkinPreviewDialogFragment.Hh(Function1.this, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Hh(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void Ih() {
        if (this.isRegisterReceiver.compareAndSet(false, true)) {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("com.tencent.mobileqq.qwallet.send.message");
            try {
                Context context = getContext();
                if (context != null) {
                    context.registerReceiver(this.sendHbReceiver, intentFilter);
                }
            } catch (Exception e16) {
                QLog.w("SkinPreviewDialogFragment", 1, "registerBroadcast error:", e16);
            }
        }
    }

    private final void Kh() {
        this.pagerAdapter = new e();
        ViewPager2 viewPager2 = this.viewPager;
        ViewPager2 viewPager22 = null;
        if (viewPager2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewPager");
            viewPager2 = null;
        }
        e eVar = this.pagerAdapter;
        if (eVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pagerAdapter");
            eVar = null;
        }
        viewPager2.setAdapter(eVar);
        ViewPager2 viewPager23 = this.viewPager;
        if (viewPager23 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewPager");
            viewPager23 = null;
        }
        viewPager23.setOffscreenPageLimit(1);
        ViewPager2 viewPager24 = this.viewPager;
        if (viewPager24 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewPager");
            viewPager24 = null;
        }
        viewPager24.setClipChildren(false);
        ViewPager2 viewPager25 = this.viewPager;
        if (viewPager25 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewPager");
            viewPager25 = null;
        }
        viewPager25.setClipToPadding(false);
        ViewPager2 viewPager26 = this.viewPager;
        if (viewPager26 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewPager");
            viewPager26 = null;
        }
        viewPager26.setPageTransformer(new g());
        ViewPager2 viewPager27 = this.viewPager;
        if (viewPager27 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewPager");
            viewPager27 = null;
        }
        e eVar2 = this.pagerAdapter;
        if (eVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pagerAdapter");
            eVar2 = null;
        }
        viewPager27.registerOnPageChangeCallback(eVar2.getPageChangeCallback());
        ViewPager2 viewPager28 = this.viewPager;
        if (viewPager28 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewPager");
        } else {
            viewPager22 = viewPager28;
        }
        viewPager22.registerOnPageChangeCallback(new b());
        Bh();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Lh(RedPackSkin$RecommendSkin skin) {
        this.isShareClicked = true;
        Intent intent = new Intent();
        intent.putExtra("public_fragment_window_feature", 1);
        intent.putExtra("KEY_IN_PARAM_SKIN_ID", RedPackSkinExt.f(skin));
        QPublicFragmentActivity.b.f(getContext(), intent, QPublicTransFragmentActivity.class, HbSkinShareEntryFragment.class, 1001);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:101:0x0349  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x0352  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x037d  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x0390  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x03b0  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x03b4  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x0385  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x0328  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0322  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x033e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void Mh(final RedPackSkin$RecommendSkin skin) {
        boolean z16;
        boolean z17;
        boolean z18;
        boolean z19;
        boolean z26;
        TextView textView;
        boolean z27;
        final boolean z28;
        TextView textView2;
        TextView textView3;
        TextView textView4;
        TextView textView5;
        ImageView imageView;
        ImageView imageView2;
        String str;
        boolean z29;
        boolean z36;
        QLog.d("SkinPreviewDialogFragment", 2, "updateSkinActivityInfo: " + RedPackSkinExt.d(skin));
        this.curSkinInfo = skin;
        final String titleText = skin.skin.title.get();
        final RedPackSkin$RecommendActivity redPackSkin$RecommendActivity = skin.activity.get();
        TextView textView6 = this.skinTitle;
        if (textView6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("skinTitle");
            textView6 = null;
        }
        textView6.setText(titleText);
        String badgeUrl = skin.skin.badge_url.get();
        String c16 = RedPackSkinExt.c(skin);
        TextView textView7 = this.skinLabel;
        if (textView7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("skinLabel");
            textView7 = null;
        }
        int i3 = 8;
        textView7.setVisibility(8);
        ImageView imageView3 = this.skinBadge;
        if (imageView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("skinBadge");
            imageView3 = null;
        }
        imageView3.setVisibility(8);
        Intrinsics.checkNotNullExpressionValue(badgeUrl, "badgeUrl");
        if (badgeUrl.length() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            ImageView imageView4 = this.skinBadge;
            if (imageView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("skinBadge");
                imageView4 = null;
            }
            imageView4.setVisibility(0);
            ImageView imageView5 = this.skinBadge;
            if (imageView5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("skinBadge");
                imageView5 = null;
            }
            imageView5.setImageDrawable(QWalletPicHelper.getNetDrawableForQWallet(badgeUrl));
        } else {
            if (c16.length() > 0) {
                z17 = true;
            } else {
                z17 = false;
            }
            if (z17) {
                TextView textView8 = this.skinLabel;
                if (textView8 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("skinLabel");
                    textView8 = null;
                }
                textView8.setVisibility(0);
                TextView textView9 = this.skinLabel;
                if (textView9 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("skinLabel");
                    textView9 = null;
                }
                textView9.setText(c16);
            }
        }
        String activityText = redPackSkin$RecommendActivity.text.get();
        Intrinsics.checkNotNullExpressionValue(activityText, "activityText");
        if (activityText.length() > 0) {
            z18 = true;
        } else {
            z18 = false;
        }
        if (z18) {
            TextView textView10 = this.recommendText;
            if (textView10 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("recommendText");
                textView10 = null;
            }
            textView10.setVisibility(0);
            TextView textView11 = this.recommendText;
            if (textView11 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("recommendText");
                textView11 = null;
            }
            textView11.setText(redPackSkin$RecommendActivity.text.get());
        } else {
            TextView textView12 = this.recommendText;
            if (textView12 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("recommendText");
                textView12 = null;
            }
            textView12.setVisibility(8);
        }
        String urlDesc = redPackSkin$RecommendActivity.url_desc.get();
        Intrinsics.checkNotNullExpressionValue(urlDesc, "urlDesc");
        if (urlDesc.length() == 0) {
            z19 = true;
        } else {
            z19 = false;
        }
        if (z19) {
            ViewGroup viewGroup = this.recommendAuthorContainer;
            if (viewGroup == null) {
                Intrinsics.throwUninitializedPropertyAccessException("recommendAuthorContainer");
                viewGroup = null;
            }
            viewGroup.setVisibility(8);
        } else {
            ViewGroup viewGroup2 = this.recommendAuthorContainer;
            if (viewGroup2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("recommendAuthorContainer");
                viewGroup2 = null;
            }
            viewGroup2.setVisibility(0);
            String logoUrl = redPackSkin$RecommendActivity.logo.get();
            Intrinsics.checkNotNullExpressionValue(logoUrl, "logoUrl");
            if (logoUrl.length() > 0) {
                z26 = true;
            } else {
                z26 = false;
            }
            if (z26) {
                ImageView imageView6 = this.recommendAuthorLogo;
                if (imageView6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("recommendAuthorLogo");
                    imageView6 = null;
                }
                imageView6.setVisibility(0);
                ImageView imageView7 = this.recommendAuthorLogo;
                if (imageView7 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("recommendAuthorLogo");
                    imageView7 = null;
                }
                imageView7.setImageDrawable(QWalletPicHelper.getNetDrawableForQWallet(logoUrl));
            } else {
                ImageView imageView8 = this.recommendAuthorLogo;
                if (imageView8 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("recommendAuthorLogo");
                    imageView8 = null;
                }
                imageView8.setVisibility(8);
            }
            TextView textView13 = this.recommendAuthorLink;
            if (textView13 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("recommendAuthorLink");
                textView13 = null;
            }
            textView13.setVisibility(0);
            TextView textView14 = this.recommendAuthorLink;
            if (textView14 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("recommendAuthorLink");
                textView14 = null;
            }
            textView14.setText(urlDesc);
            TextView textView15 = this.recommendAuthorLink;
            if (textView15 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("recommendAuthorLink");
                textView = null;
            } else {
                textView = textView15;
            }
            k.d(textView, 0L, new Function0<Unit>() { // from class: com.tencent.mobileqq.qwallet.hb.panel.preview.SkinPreviewDialogFragment$updateSkinActivityInfo$1
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
                    SkinRecommendViewModel skinRecommendViewModel;
                    int i16;
                    String url = RedPackSkin$RecommendActivity.this.url.get();
                    Intrinsics.checkNotNullExpressionValue(url, "url");
                    if (url.length() > 0) {
                        com.tencent.mobileqq.qwallet.utils.k.h(this.getContext(), url);
                    }
                    Integer valueOf = Integer.valueOf(RedPackSkinExt.f(skin));
                    skinRecommendViewModel = this.skinRecommendViewModel;
                    if (skinRecommendViewModel == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("skinRecommendViewModel");
                        skinRecommendViewModel = null;
                    }
                    Integer valueOf2 = Integer.valueOf(skinRecommendViewModel.getDisplayType());
                    String titleText2 = titleText;
                    Intrinsics.checkNotNullExpressionValue(titleText2, "titleText");
                    i16 = this.sceneId;
                    m.g("luckycover.get_gift.click", valueOf, valueOf2, titleText2, Integer.valueOf(i16));
                }
            }, 1, null);
            Integer valueOf = Integer.valueOf(RedPackSkinExt.f(skin));
            SkinRecommendViewModel skinRecommendViewModel = this.skinRecommendViewModel;
            if (skinRecommendViewModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("skinRecommendViewModel");
                skinRecommendViewModel = null;
            }
            Integer valueOf2 = Integer.valueOf(skinRecommendViewModel.getDisplayType());
            Intrinsics.checkNotNullExpressionValue(titleText, "titleText");
            m.g("luckycover.get_gift.expo", valueOf, valueOf2, titleText, Integer.valueOf(this.sceneId));
        }
        String imgUrl = redPackSkin$RecommendActivity.img.get();
        Intrinsics.checkNotNullExpressionValue(imgUrl, "imgUrl");
        if (imgUrl.length() > 0) {
            z27 = true;
        } else {
            z27 = false;
        }
        if (z27) {
            ImageView imageView9 = this.recommendImg;
            if (imageView9 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("recommendImg");
                imageView9 = null;
            }
            imageView9.setVisibility(0);
            ImageView imageView10 = this.recommendImg;
            if (imageView10 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("recommendImg");
                imageView10 = null;
            }
            imageView10.setImageDrawable(QWalletPicHelper.getNetDrawableForQWallet(imgUrl));
        } else {
            ImageView imageView11 = this.recommendImg;
            if (imageView11 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("recommendImg");
                imageView11 = null;
            }
            imageView11.setVisibility(8);
        }
        final RedPackSkin$Disclosure redPackSkin$Disclosure = redPackSkin$RecommendActivity.disclosure.get();
        if (redPackSkin$Disclosure != null) {
            String str2 = redPackSkin$Disclosure.logo.get();
            if (str2 != null && str2.length() != 0) {
                z29 = false;
            } else {
                z29 = true;
            }
            if (!z29) {
                Integer valueOf3 = Integer.valueOf(RedPackSkinExt.f(skin));
                SkinRecommendViewModel skinRecommendViewModel2 = this.skinRecommendViewModel;
                if (skinRecommendViewModel2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("skinRecommendViewModel");
                    skinRecommendViewModel2 = null;
                }
                Integer valueOf4 = Integer.valueOf(skinRecommendViewModel2.getDisplayType());
                String str3 = redPackSkin$Disclosure.title.get();
                Intrinsics.checkNotNullExpressionValue(str3, "disclosure.title.get()");
                m.g("luckycover.sourceinfo.expo", valueOf3, valueOf4, str3, Integer.valueOf(this.sceneId));
                ImageView imageView12 = this.recommendImg;
                if (imageView12 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("recommendImg");
                    imageView12 = null;
                }
                imageView12.setVisibility(8);
                ViewGroup viewGroup3 = this.recommendDisclosureContainer;
                if (viewGroup3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("recommendDisclosureContainer");
                    viewGroup3 = null;
                }
                viewGroup3.setVisibility(0);
                ImageView imageView13 = this.recommendDisclosureLogo;
                if (imageView13 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("recommendDisclosureLogo");
                    imageView13 = null;
                }
                imageView13.setImageDrawable(QWalletPicHelper.getNetDrawableForQWallet(redPackSkin$Disclosure.logo.get()));
                TextView textView16 = this.recommendDisclosureTitle;
                if (textView16 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("recommendDisclosureTitle");
                    textView16 = null;
                }
                textView16.setText(redPackSkin$Disclosure.title.get());
                TextView textView17 = this.recommendDisclosureDesc;
                if (textView17 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("recommendDisclosureDesc");
                    textView17 = null;
                }
                textView17.setText(redPackSkin$Disclosure.sub_title.get());
                String str4 = redPackSkin$Disclosure.button_text.get();
                Intrinsics.checkNotNullExpressionValue(str4, "this");
                if (str4.length() == 0) {
                    z36 = true;
                } else {
                    z36 = false;
                }
                if (z36) {
                    Button button = this.recommendDisclosureBtn;
                    if (button == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("recommendDisclosureBtn");
                        button = null;
                    }
                    button.setVisibility(8);
                } else {
                    Button button2 = this.recommendDisclosureBtn;
                    if (button2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("recommendDisclosureBtn");
                        button2 = null;
                    }
                    button2.setVisibility(0);
                    Button button3 = this.recommendDisclosureBtn;
                    if (button3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("recommendDisclosureBtn");
                        button3 = null;
                    }
                    button3.setText(str4);
                }
                ViewGroup viewGroup4 = this.recommendDisclosureContainer;
                if (viewGroup4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("recommendDisclosureContainer");
                    viewGroup4 = null;
                }
                viewGroup4.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.qwallet.hb.panel.preview.b
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        SkinPreviewDialogFragment.Nh(RedPackSkin$Disclosure.this, skin, this, view);
                    }
                });
                z28 = skin.has_got.get();
                String str5 = skin.btn_text.get();
                textView2 = this.jumpBtn;
                if (textView2 != null) {
                    Intrinsics.throwUninitializedPropertyAccessException("jumpBtn");
                    textView3 = null;
                } else {
                    textView3 = textView2;
                }
                k.d(textView3, 0L, new Function0<Unit>() { // from class: com.tencent.mobileqq.qwallet.hb.panel.preview.SkinPreviewDialogFragment$updateSkinActivityInfo$4
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
                        SkinRecommendViewModel skinRecommendViewModel3;
                        int i16;
                        skinRecommendViewModel3 = SkinPreviewDialogFragment.this.skinRecommendViewModel;
                        if (skinRecommendViewModel3 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("skinRecommendViewModel");
                            skinRecommendViewModel3 = null;
                        }
                        skinRecommendViewModel3.a2(SkinPreviewDialogFragment.this.getContext(), SkinPreviewDialogFragment.this.getRecommendSkinHost(), skin);
                        Integer valueOf5 = Integer.valueOf(RedPackSkinExt.f(skin));
                        String str6 = z28 ? "1" : "0";
                        i16 = SkinPreviewDialogFragment.this.sceneId;
                        m.g("luckycover.recommend_detail.click", valueOf5, "", str6, Integer.valueOf(i16));
                    }
                }, 1, null);
                textView4 = this.jumpBtn;
                if (textView4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("jumpBtn");
                    textView4 = null;
                }
                textView4.setEnabled(true);
                textView5 = this.jumpBtn;
                if (textView5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("jumpBtn");
                    textView5 = null;
                }
                textView5.setText(str5);
                if (z28) {
                    Integer valueOf5 = Integer.valueOf(RedPackSkinExt.f(skin));
                    SkinRecommendViewModel skinRecommendViewModel3 = this.skinRecommendViewModel;
                    if (skinRecommendViewModel3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("skinRecommendViewModel");
                        skinRecommendViewModel3 = null;
                    }
                    Integer valueOf6 = Integer.valueOf(skinRecommendViewModel3.getDisplayType());
                    Intrinsics.checkNotNullExpressionValue(titleText, "titleText");
                    m.g("luckycover.send.expo", valueOf5, valueOf6, titleText, Integer.valueOf(this.sceneId));
                }
                imageView = this.shareBtn;
                if (imageView != null) {
                    Intrinsics.throwUninitializedPropertyAccessException("shareBtn");
                    imageView2 = null;
                } else {
                    imageView2 = imageView;
                }
                if (skin.skin.allow_share.get()) {
                    k.d(imageView2, 0L, new Function0<Unit>() { // from class: com.tencent.mobileqq.qwallet.hb.panel.preview.SkinPreviewDialogFragment$updateSkinActivityInfo$5$1
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
                            int i16;
                            SkinPreviewDialogFragment.this.Lh(skin);
                            Integer valueOf7 = Integer.valueOf(RedPackSkinExt.f(skin));
                            String str6 = z28 ? "1" : "0";
                            i16 = SkinPreviewDialogFragment.this.sceneId;
                            m.g("luckycover.recommend_detail.share", valueOf7, "", str6, Integer.valueOf(i16));
                        }
                    }, 1, null);
                    i3 = 0;
                }
                imageView2.setVisibility(i3);
                Integer valueOf7 = Integer.valueOf(RedPackSkinExt.f(skin));
                if (!z28) {
                    str = "1";
                } else {
                    str = "0";
                }
                m.g("luckycover.recommend_detail.show", valueOf7, "", str, Integer.valueOf(this.sceneId));
            }
        }
        ViewGroup viewGroup5 = this.recommendDisclosureContainer;
        if (viewGroup5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recommendDisclosureContainer");
            viewGroup5 = null;
        }
        viewGroup5.setVisibility(8);
        z28 = skin.has_got.get();
        String str52 = skin.btn_text.get();
        textView2 = this.jumpBtn;
        if (textView2 != null) {
        }
        k.d(textView3, 0L, new Function0<Unit>() { // from class: com.tencent.mobileqq.qwallet.hb.panel.preview.SkinPreviewDialogFragment$updateSkinActivityInfo$4
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
                SkinRecommendViewModel skinRecommendViewModel32;
                int i16;
                skinRecommendViewModel32 = SkinPreviewDialogFragment.this.skinRecommendViewModel;
                if (skinRecommendViewModel32 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("skinRecommendViewModel");
                    skinRecommendViewModel32 = null;
                }
                skinRecommendViewModel32.a2(SkinPreviewDialogFragment.this.getContext(), SkinPreviewDialogFragment.this.getRecommendSkinHost(), skin);
                Integer valueOf52 = Integer.valueOf(RedPackSkinExt.f(skin));
                String str6 = z28 ? "1" : "0";
                i16 = SkinPreviewDialogFragment.this.sceneId;
                m.g("luckycover.recommend_detail.click", valueOf52, "", str6, Integer.valueOf(i16));
            }
        }, 1, null);
        textView4 = this.jumpBtn;
        if (textView4 == null) {
        }
        textView4.setEnabled(true);
        textView5 = this.jumpBtn;
        if (textView5 == null) {
        }
        textView5.setText(str52);
        if (z28) {
        }
        imageView = this.shareBtn;
        if (imageView != null) {
        }
        if (skin.skin.allow_share.get()) {
        }
        imageView2.setVisibility(i3);
        Integer valueOf72 = Integer.valueOf(RedPackSkinExt.f(skin));
        if (!z28) {
        }
        m.g("luckycover.recommend_detail.show", valueOf72, "", str, Integer.valueOf(this.sceneId));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Nh(RedPackSkin$Disclosure redPackSkin$Disclosure, RedPackSkin$RecommendSkin skin, SkinPreviewDialogFragment this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(skin, "$skin");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        com.tencent.mobileqq.qwallet.utils.k.h(view.getContext(), redPackSkin$Disclosure.button_href.get());
        Integer valueOf = Integer.valueOf(RedPackSkinExt.f(skin));
        SkinRecommendViewModel skinRecommendViewModel = this$0.skinRecommendViewModel;
        if (skinRecommendViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("skinRecommendViewModel");
            skinRecommendViewModel = null;
        }
        Integer valueOf2 = Integer.valueOf(skinRecommendViewModel.getDisplayType());
        String str = redPackSkin$Disclosure.title.get();
        Intrinsics.checkNotNullExpressionValue(str, "disclosure.title.get()");
        m.g("luckycover.sourceinfo.click", valueOf, valueOf2, str, Integer.valueOf(this$0.sceneId));
        EventCollector.getInstance().onViewClicked(view);
    }

    @Nullable
    /* renamed from: Dh, reason: from getter */
    public final com.tencent.mobileqq.qwallet.hb.panel.b getRecommendSkinHost() {
        return this.recommendSkinHost;
    }

    public final void Jh(@Nullable com.tencent.mobileqq.qwallet.hb.panel.b bVar) {
        this.recommendSkinHost = bVar;
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        Serializable serializable;
        super.onActivityResult(requestCode, resultCode, data);
        int i3 = -1;
        if (resultCode == -1) {
            HbSkinShareEntryFragment.QQWalletShareSkinState qQWalletShareSkinState = null;
            if (data != null) {
                serializable = data.getSerializableExtra("KEY_OUT_SHARE_CODE");
            } else {
                serializable = null;
            }
            if (serializable instanceof HbSkinShareEntryFragment.QQWalletShareSkinState) {
                qQWalletShareSkinState = (HbSkinShareEntryFragment.QQWalletShareSkinState) serializable;
            }
            if (qQWalletShareSkinState == null) {
                qQWalletShareSkinState = HbSkinShareEntryFragment.QQWalletShareSkinState.Cancel;
            }
            if (data != null) {
                i3 = data.getIntExtra("KEY_OUT_SHARE_SKIN_ID", -1);
            }
            QLog.i("SkinPreviewDialogFragment", 1, "share hb skin result: " + qQWalletShareSkinState + " skinId=" + i3);
            return;
        }
        QLog.i("SkinPreviewDialogFragment", 1, "share hb skin fail");
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onAttach(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        super.onAttach(context);
        Eh();
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnCancelListener
    public void onCancel(@NotNull DialogInterface dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        super.onCancel(dialog);
        Bundle bundle = new Bundle();
        bundle.putBoolean(IQWalletHbApi.KEY_HB_SKIN_PREVIEW_IS_SHARE, this.isShareClicked);
        SkinRecommendViewModel skinRecommendViewModel = this.skinRecommendViewModel;
        if (skinRecommendViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("skinRecommendViewModel");
            skinRecommendViewModel = null;
        }
        bundle.putBoolean(IQWalletHbApi.KEY_HB_SKIN_PREVIEW_IS_GET, skinRecommendViewModel.getIsGotSkin());
        Unit unit = Unit.INSTANCE;
        FragmentKt.setFragmentResult(this, "skin_preview_request", bundle);
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(@NotNull Configuration newConfig) {
        Intrinsics.checkNotNullParameter(newConfig, "newConfig");
        super.onConfigurationChanged(newConfig);
        QLog.i("SkinPreviewDialogFragment", 1, "onConfigurationChanged");
        ViewPager2 viewPager2 = this.viewPager;
        ViewPager2 viewPager22 = null;
        if (viewPager2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewPager");
            viewPager2 = null;
        }
        int currentItem = viewPager2.getCurrentItem();
        Kh();
        ViewPager2 viewPager23 = this.viewPager;
        if (viewPager23 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewPager");
        } else {
            viewPager22 = viewPager23;
        }
        viewPager22.setCurrentItem(currentItem);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.initSkinId = arguments.getInt("init_skin_id", -1);
            this.themeId = arguments.getInt("theme_id", m.f277567a.a());
            this.sceneId = arguments.getInt("preview_scene", -1);
        }
        this.themeContext = new ContextThemeWrapper(getContext(), this.themeId);
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetDialogFragment, androidx.appcompat.app.AppCompatDialogFragment, com.tencent.qqlive.module.videoreport.inject.fragment.ReportAndroidXDialogFragment, androidx.fragment.app.DialogFragment
    @NotNull
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        Dialog onCreateDialog = super.onCreateDialog(savedInstanceState);
        Intrinsics.checkNotNull(onCreateDialog, "null cannot be cast to non-null type com.google.android.material.bottomsheet.BottomSheetDialog");
        com.google.android.material.bottomsheet.a aVar = (com.google.android.material.bottomsheet.a) onCreateDialog;
        BottomSheetBehavior<FrameLayout> behavior = aVar.getBehavior();
        behavior.setSkipCollapsed(true);
        behavior.setHideable(false);
        behavior.setDraggable(false);
        behavior.setState(3);
        behavior.setMaxHeight(Ch());
        return aVar;
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        ContextThemeWrapper contextThemeWrapper = this.themeContext;
        if (contextThemeWrapper == null) {
            Intrinsics.throwUninitializedPropertyAccessException("themeContext");
            contextThemeWrapper = null;
        }
        View inflate = inflater.cloneInContext(contextThemeWrapper).inflate(R.layout.hio, container, false);
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, inflate);
        return inflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.isRegisterReceiver.compareAndSet(true, false)) {
            try {
                Context context = getContext();
                if (context != null) {
                    context.unregisterReceiver(this.sendHbReceiver);
                }
            } catch (Exception e16) {
                QLog.w("SkinPreviewDialogFragment", 1, "unregisterReceiver error:", e16);
            }
        }
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(@NotNull DialogInterface dialog) {
        int i3;
        String str;
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        super.onDismiss(dialog);
        RedPackSkin$RecommendSkin redPackSkin$RecommendSkin = this.curSkinInfo;
        if (redPackSkin$RecommendSkin != null) {
            i3 = RedPackSkinExt.f(redPackSkin$RecommendSkin);
        } else {
            i3 = this.initSkinId;
        }
        Integer valueOf = Integer.valueOf(i3);
        if (this.isClickDismissBtn) {
            str = "1";
        } else {
            str = "0";
        }
        m.g("redpack.recommend_detail.close", valueOf, str, "", Integer.valueOf(this.sceneId));
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        ViewParent viewParent;
        super.onStart();
        View view = getView();
        View view2 = null;
        if (view != null) {
            viewParent = view.getParent();
        } else {
            viewParent = null;
        }
        if (viewParent instanceof View) {
            view2 = (View) viewParent;
        }
        if (view2 != null) {
            view2.setBackgroundResource(17170445);
        }
        m.g("redpack.recommend_detail.show", Integer.valueOf(this.initSkinId), "", "", Integer.valueOf(this.sceneId));
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        View findViewById = view.findViewById(R.id.f86084qp);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.skin_view_pager)");
        this.viewPager = (ViewPager2) findViewById;
        View findViewById2 = view.findViewById(R.id.az7);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "view.findViewById(R.id.close_btn)");
        this.closeBtn = (ImageView) findViewById2;
        View findViewById3 = view.findViewById(R.id.f166866ir0);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "view.findViewById(R.id.share_btn)");
        this.shareBtn = (ImageView) findViewById3;
        ImageView imageView = this.closeBtn;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("closeBtn");
            imageView = null;
        }
        k.d(imageView, 0L, new Function0<Unit>() { // from class: com.tencent.mobileqq.qwallet.hb.panel.preview.SkinPreviewDialogFragment$onViewCreated$1
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
                boolean z16;
                SkinRecommendViewModel skinRecommendViewModel;
                SkinPreviewDialogFragment.this.isClickDismissBtn = true;
                SkinPreviewDialogFragment skinPreviewDialogFragment = SkinPreviewDialogFragment.this;
                Bundle bundle = new Bundle();
                SkinPreviewDialogFragment skinPreviewDialogFragment2 = SkinPreviewDialogFragment.this;
                z16 = skinPreviewDialogFragment2.isShareClicked;
                bundle.putBoolean(IQWalletHbApi.KEY_HB_SKIN_PREVIEW_IS_SHARE, z16);
                skinRecommendViewModel = skinPreviewDialogFragment2.skinRecommendViewModel;
                if (skinRecommendViewModel == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("skinRecommendViewModel");
                    skinRecommendViewModel = null;
                }
                bundle.putBoolean(IQWalletHbApi.KEY_HB_SKIN_PREVIEW_IS_GET, skinRecommendViewModel.getIsGotSkin());
                Unit unit = Unit.INSTANCE;
                FragmentKt.setFragmentResult(skinPreviewDialogFragment, "skin_preview_request", bundle);
                SkinPreviewDialogFragment.this.dismiss();
            }
        }, 1, null);
        View findViewById4 = view.findViewById(R.id.f86074qo);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "view.findViewById(R.id.skin_title)");
        this.skinTitle = (TextView) findViewById4;
        View findViewById5 = view.findViewById(R.id.f85854q3);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "view.findViewById(R.id.skin_badge)");
        this.skinBadge = (ImageView) findViewById5;
        View findViewById6 = view.findViewById(R.id.f85924q_);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "view.findViewById(R.id.skin_label)");
        this.skinLabel = (TextView) findViewById6;
        View findViewById7 = view.findViewById(R.id.f71693ou);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "view.findViewById(R.id.recommendation_text)");
        this.recommendText = (TextView) findViewById7;
        View findViewById8 = view.findViewById(R.id.f71593ok);
        Intrinsics.checkNotNullExpressionValue(findViewById8, "view.findViewById(R.id.r\u2026ndation_author_container)");
        this.recommendAuthorContainer = (ViewGroup) findViewById8;
        View findViewById9 = view.findViewById(R.id.f71603ol);
        Intrinsics.checkNotNullExpressionValue(findViewById9, "view.findViewById(R.id.recommendation_author_logo)");
        this.recommendAuthorLogo = (ImageView) findViewById9;
        View findViewById10 = view.findViewById(R.id.f71613om);
        Intrinsics.checkNotNullExpressionValue(findViewById10, "view.findViewById(R.id.recommendation_author_text)");
        this.recommendAuthorLink = (TextView) findViewById10;
        View findViewById11 = view.findViewById(R.id.f71673os);
        Intrinsics.checkNotNullExpressionValue(findViewById11, "view.findViewById(R.id.recommendation_img)");
        this.recommendImg = (ImageView) findViewById11;
        View findViewById12 = view.findViewById(R.id.f71633oo);
        Intrinsics.checkNotNullExpressionValue(findViewById12, "view.findViewById(R.id.r\u2026ion_disclosure_container)");
        this.recommendDisclosureContainer = (ViewGroup) findViewById12;
        View findViewById13 = view.findViewById(R.id.f71653oq);
        Intrinsics.checkNotNullExpressionValue(findViewById13, "view.findViewById(R.id.r\u2026endation_disclosure_logo)");
        this.recommendDisclosureLogo = (ImageView) findViewById13;
        View findViewById14 = view.findViewById(R.id.f71663or);
        Intrinsics.checkNotNullExpressionValue(findViewById14, "view.findViewById(R.id.r\u2026ndation_disclosure_title)");
        this.recommendDisclosureTitle = (TextView) findViewById14;
        View findViewById15 = view.findViewById(R.id.f71643op);
        Intrinsics.checkNotNullExpressionValue(findViewById15, "view.findViewById(R.id.r\u2026endation_disclosure_desc)");
        this.recommendDisclosureDesc = (TextView) findViewById15;
        View findViewById16 = view.findViewById(R.id.f71623on);
        Intrinsics.checkNotNullExpressionValue(findViewById16, "view.findViewById(R.id.r\u2026mendation_disclosure_btn)");
        this.recommendDisclosureBtn = (Button) findViewById16;
        View findViewById17 = view.findViewById(R.id.dzp);
        Intrinsics.checkNotNullExpressionValue(findViewById17, "view.findViewById(R.id.jump_btn)");
        this.jumpBtn = (TextView) findViewById17;
        Kh();
        Gh();
    }
}
