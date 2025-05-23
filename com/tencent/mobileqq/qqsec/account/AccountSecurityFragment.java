package com.tencent.mobileqq.qqsec.account;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.proxy.personalitycomponent.model.WidgetCacheLunarData;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.biz.qui.quisecnavbar.BaseAction;
import com.tencent.biz.qui.quisecnavbar.QUISecNavBar;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.AuthDevOpenUgActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.RouterConstants;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.identity.ISafeApi;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.guild.widget.OverScrollRecyclerView;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qmmkv.MMKVOptionEntity;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qqsec.account.AccountSecurityFragment;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.Navigator;
import com.tencent.mobileqq.setting.api.ISettingApi;
import com.tencent.mobileqq.setting.widget.SettingOverScrollRecyclerView;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.listitem.Group;
import com.tencent.mobileqq.widget.listitem.QUIListItemAdapter;
import com.tencent.mobileqq.widget.listitem.c;
import com.tencent.mobileqq.widget.listitem.w;
import com.tencent.mobileqq.widget.listitem.x;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.PageParams;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.qqmini.sdk.plugins.UIJsPlugin;
import cooperation.qzone.QzoneIPCModule;
import face.qqlogin.FaceSecureCheck$SecureCheckResponse;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.Constants;
import mqq.app.MobileQQ;
import oicq.wlogin_sdk.devicelock.DevlockInfo;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tencent.im.oidb.oidb_0x5e1$RspBody;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00b4\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\r\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 q2\u00020\u0001:\u0001rB\u0007\u00a2\u0006\u0004\bo\u0010pJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0015\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\b\u0010\r\u001a\u00020\u0004H\u0002J\f\u0010\u000f\u001a\u0006\u0012\u0002\b\u00030\u000eH\u0002J\b\u0010\u0010\u001a\u00020\u0004H\u0002J\f\u0010\u0011\u001a\u0006\u0012\u0002\b\u00030\u000eH\u0002J\u0018\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u0013H\u0002J\u0012\u0010\u0018\u001a\u00020\u00132\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0002J\u0012\u0010\u001a\u001a\u00020\u00192\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0002J\b\u0010\u001b\u001a\u00020\u0004H\u0002J\f\u0010\u001c\u001a\u0006\u0012\u0002\b\u00030\u000eH\u0002J\b\u0010\u001d\u001a\u00020\u0004H\u0002J\f\u0010\u001e\u001a\u0006\u0012\u0002\b\u00030\u000eH\u0002J\u0010\u0010\u001f\u001a\u00020\u0004*\u0006\u0012\u0002\b\u00030\u000eH\u0002J\b\u0010 \u001a\u00020\u0004H\u0003J\u001e\u0010$\u001a\u0006\u0012\u0002\b\u00030\u000e2\u0006\u0010\"\u001a\u00020!2\b\u0010#\u001a\u0004\u0018\u00010\u0013H\u0002J\u0010\u0010&\u001a\u00020\u00042\u0006\u0010%\u001a\u00020\u0013H\u0002J\b\u0010'\u001a\u00020\u0019H\u0016J\u000e\u0010)\u001a\u00020\u00042\u0006\u0010(\u001a\u00020!J&\u00100\u001a\u0004\u0018\u00010\u00022\u0006\u0010+\u001a\u00020*2\b\u0010-\u001a\u0004\u0018\u00010,2\b\u0010/\u001a\u0004\u0018\u00010.H\u0016J\u001a\u00101\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00022\b\u0010/\u001a\u0004\u0018\u00010.H\u0016J\b\u00102\u001a\u00020\u0004H\u0016J\b\u00103\u001a\u00020\u0004H\u0016J\"\u00108\u001a\u00020\u00042\u0006\u00104\u001a\u00020\u00062\u0006\u00105\u001a\u00020\u00062\b\u00107\u001a\u0004\u0018\u000106H\u0016J\b\u00109\u001a\u00020\u0019H\u0016J\b\u0010:\u001a\u00020\u0004H\u0016R\u0018\u0010>\u001a\u0004\u0018\u00010;8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b<\u0010=R\u001e\u0010A\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b?\u0010@R\"\u0010E\u001a\u000e\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u000e\u0018\u00010B8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bC\u0010DR\u0016\u0010H\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bF\u0010GR\u001a\u0010K\u001a\b\u0012\u0004\u0012\u00020I0B8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bJ\u0010DR\u0018\u0010O\u001a\u0004\u0018\u00010L8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bM\u0010NR\u0016\u0010Q\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bP\u0010PR\u001b\u0010W\u001a\u00020R8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bS\u0010T\u001a\u0004\bU\u0010VR\u001b\u0010[\u001a\u00020\u00068BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bX\u0010T\u001a\u0004\bY\u0010ZR\u0018\u0010_\u001a\u0004\u0018\u00010\\8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b]\u0010^R\u0018\u0010c\u001a\u0004\u0018\u00010`8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\ba\u0010bR\u001b\u0010f\u001a\u00020\u00068BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bd\u0010T\u001a\u0004\be\u0010ZR\u0016\u0010j\u001a\u0004\u0018\u00010g8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\bh\u0010iR\u0016\u0010n\u001a\u0004\u0018\u00010k8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\bl\u0010m\u00a8\u0006s"}, d2 = {"Lcom/tencent/mobileqq/qqsec/account/AccountSecurityFragment;", "Lcom/tencent/mobileqq/fragment/QPublicBaseFragment;", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "", "initUI", "", "offset", "wi", "", "Lcom/tencent/mobileqq/widget/listitem/Group;", "Vh", "()[Lcom/tencent/mobileqq/widget/listitem/Group;", "initData", "Lcom/tencent/mobileqq/widget/listitem/a;", "ri", "pi", "Yh", "view", "", "id", "vi", "Ltencent/im/oidb/oidb_0x5e1$RspBody;", "faceStateInfo", "di", "", "gi", "ni", "Sh", "li", "ti", "hi", WidgetCacheLunarData.JI, "", "leftText", "url", "Wh", "message", UIJsPlugin.EVENT_SHOW_TOAST, "needImmersive", "title", "setTitle", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onCreateView", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "onResume", "onDestroyView", "requestCode", QzoneIPCModule.RESULT_CODE, "Landroid/content/Intent;", "data", "onActivityResult", "onBackEvent", "onFinish", "Lcom/tencent/mobileqq/widget/listitem/QUIListItemAdapter;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/widget/listitem/QUIListItemAdapter;", "adapter", "D", "[Lcom/tencent/mobileqq/widget/listitem/Group;", "groupList", "", "E", "Ljava/util/List;", "secondConfigList", UserInfo.SEX_FEMALE, "Z", "hasUnverifiedPhone", "Lcom/tencent/mobileqq/setting/config/b;", "G", "redTouchConfigs", "Lcom/tencent/mobileqq/qqsec/account/AccountRiskInfoView;", "H", "Lcom/tencent/mobileqq/qqsec/account/AccountRiskInfoView;", "riskInfoView", "I", "verticalScroll", "Lcom/tencent/mobileqq/qqsec/account/AccountSecurityVM;", "J", "Lkotlin/Lazy;", "ci", "()Lcom/tencent/mobileqq/qqsec/account/AccountSecurityVM;", "accountSecurityVM", "K", "fi", "()I", "topPadding", "Lcom/tencent/biz/qui/quisecnavbar/QUISecNavBar;", "L", "Lcom/tencent/biz/qui/quisecnavbar/QUISecNavBar;", "quiSecNavBar", "Lcom/tencent/mobileqq/setting/widget/SettingOverScrollRecyclerView;", "M", "Lcom/tencent/mobileqq/setting/widget/SettingOverScrollRecyclerView;", "recyclerView", "N", "ei", "maxAlphaOffset", "Lmqq/app/AppRuntime;", "getApp", "()Lmqq/app/AppRuntime;", "app", "Landroid/app/Activity;", "getActivity", "()Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "<init>", "()V", "P", "a", "qqsafeblock-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class AccountSecurityFragment extends QPublicBaseFragment {
    static IPatchRedirector $redirector_;

    /* renamed from: P, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private QUIListItemAdapter adapter;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private Group[] groupList;

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private List<com.tencent.mobileqq.widget.listitem.a<?>> secondConfigList;

    /* renamed from: F, reason: from kotlin metadata */
    private boolean hasUnverifiedPhone;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final List<com.tencent.mobileqq.setting.config.b> redTouchConfigs;

    /* renamed from: H, reason: from kotlin metadata */
    @Nullable
    private AccountRiskInfoView riskInfoView;

    /* renamed from: I, reason: from kotlin metadata */
    private int verticalScroll;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    private final Lazy accountSecurityVM;

    /* renamed from: K, reason: from kotlin metadata */
    @NotNull
    private final Lazy topPadding;

    /* renamed from: L, reason: from kotlin metadata */
    @Nullable
    private QUISecNavBar quiSecNavBar;

    /* renamed from: M, reason: from kotlin metadata */
    @Nullable
    private SettingOverScrollRecyclerView recyclerView;

    /* renamed from: N, reason: from kotlin metadata */
    @NotNull
    private final Lazy maxAlphaOffset;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0013\n\u0002\u0010\t\n\u0002\b\u000f\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b'\u0010(R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0004R\u0014\u0010\n\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0004R\u0014\u0010\u000b\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u0004R\u0014\u0010\f\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\f\u0010\u0004R\u0014\u0010\r\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\r\u0010\u0004R\u0014\u0010\u000e\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u0004R\u0014\u0010\u000f\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0004R\u0014\u0010\u0010\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0004R\u0014\u0010\u0011\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0004R\u0014\u0010\u0012\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0004R\u0014\u0010\u0013\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0004R\u0014\u0010\u0014\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0004R\u0014\u0010\u0015\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0004R\u0014\u0010\u0016\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\bR\u0014\u0010\u0017\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\bR\u0014\u0010\u0018\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\bR\u0014\u0010\u0019\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\bR\u0014\u0010\u001b\u001a\u00020\u001a8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0014\u0010\u001d\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u0004R\u0014\u0010\u001e\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u0004R\u0014\u0010\u001f\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u001f\u0010\u0004R\u0014\u0010 \u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b \u0010\u0004R\u0014\u0010!\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b!\u0010\u0004R\u0014\u0010\"\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\"\u0010\u0004R\u0014\u0010#\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b#\u0010\u0004R\u0014\u0010$\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b$\u0010\u0004R\u0014\u0010%\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b%\u0010\u0004R\u0014\u0010&\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b&\u0010\u0004\u00a8\u0006)"}, d2 = {"Lcom/tencent/mobileqq/qqsec/account/AccountSecurityFragment$a;", "", "", "ACCOUNT_RELEASE_URL", "Ljava/lang/String;", "MODIFY_PWD_DEFAULT_URL", "", "PIM_SECURITY_SCAN_SWITCH_ON", "I", "QQ_SAFE_CENTER_URL", "REPORT_T_ACCOUNT_RELEASE_CLICK", "REPORT_T_ACCOUNT_RELEASE_SHOW", "REPORT_T_DEV_MANAGE_CLICK", "REPORT_T_DEV_MANAGE_SHOW", "REPORT_T_FACE_RECOGNIZE_CLICK", "REPORT_T_FACE_RECOGNIZE_SHOW", "REPORT_T_HAND_PASS_CLICK", "REPORT_T_HAND_PASS_SHOW", "REPORT_T_PASSWORD_CHANGE_CLICK", "REPORT_T_PASSWORD_CHANGE_SHOW", "REPORT_T_QQ_SAFE_CENTER_CLICK", "REPORT_T_QQ_SAFE_CENTER_SHOW", "REQUEST_ACCOUNT_RELEASE", "REQUEST_CODE_RISK_DETAILS", "REQUEST_CODE_SET_GESTUREPWD", "REQUEST_DEV_AUTH", "", "SEC_STOPPING_ANIMATION_DURATION", "J", "TAG", "T_DEV_MANAGE_CLICK_TOAST_SHOW", "T_FACE_SET_OUT_ENTRANCE_CLICK", "T_FACE_SET_OUT_ENTRANCE_SHOW", "T_REPORT_DEV_ENTRANCE_CLICK", "T_REPORT_DEV_ENTRANCE_SHOW", "T_SECURITY_MODIFY_PWD_CLICK", "T_SECURITY_MODIFY_PWD_SHOW", "V_REPORT_HAS_SET_FACE", "V_REPORT_NOT_SET_FACE", "<init>", "()V", "qqsafeblock-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qqsec.account.AccountSecurityFragment$a, reason: from kotlin metadata */
    /* loaded from: classes17.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/qqsec/account/AccountSecurityFragment$b", "Lcom/tencent/mobileqq/setting/widget/SettingOverScrollRecyclerView$d;", "", "offsetY", "", "onVerticalScroll", "qqsafeblock-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes17.dex */
    public static final class b implements SettingOverScrollRecyclerView.d {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AccountSecurityFragment.this);
            }
        }

        @Override // com.tencent.mobileqq.setting.widget.SettingOverScrollRecyclerView.d
        public void onVerticalScroll(int offsetY) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                AccountSecurityFragment.this.verticalScroll = offsetY;
                AccountSecurityFragment.this.wi(offsetY);
            } else {
                iPatchRedirector.redirect((short) 2, (Object) this, offsetY);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\"\u0010\b\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016J\u0010\u0010\n\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0004H\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/qqsec/account/AccountSecurityFragment$c", "Lcom/tencent/mobileqq/guild/widget/OverScrollRecyclerView$OnOverScrollListener;", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "", "overScrollX", "overScrollY", "", "a", "state", "b", "qqsafeblock-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes17.dex */
    public static final class c implements OverScrollRecyclerView.OnOverScrollListener {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AccountSecurityFragment.this);
            }
        }

        @Override // com.tencent.mobileqq.guild.widget.OverScrollRecyclerView.OnOverScrollListener
        public void a(@Nullable RecyclerView recyclerView, int overScrollX, int overScrollY) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, recyclerView, Integer.valueOf(overScrollX), Integer.valueOf(overScrollY));
            }
        }

        @Override // com.tencent.mobileqq.guild.widget.OverScrollRecyclerView.OnOverScrollListener
        public void b(int state) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, state);
            } else if (state == 3) {
                if (AccountSecurityFragment.this.verticalScroll <= ViewUtils.dpToPx(100.0f) * (-1)) {
                    AccountSecurityFragment.this.pi();
                }
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0014\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/qqsec/account/AccountSecurityFragment$d", "Lcom/tencent/mobileqq/widget/listitem/w;", "Lcom/tencent/mobileqq/qqsec/account/AccountRiskInfoView;", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "K", "qqsafeblock-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes17.dex */
    public static final class d extends w<AccountRiskInfoView> {
        static IPatchRedirector $redirector_;

        d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AccountSecurityFragment.this);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void L(AccountSecurityFragment this$0, View view) {
            Bundle bundle;
            String str;
            String string;
            EventCollector.getInstance().onViewClickedBefore(view);
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            ArrayList<RiskInfoItem> Z1 = this$0.ci().Z1();
            if (!Z1.isEmpty()) {
                DevlockInfo S1 = this$0.ci().S1();
                if (((ISafeApi) QRoute.api(ISafeApi.class)).needDeleteDevLock()) {
                    S1 = new DevlockInfo();
                    S1.DevSetup = 1;
                    S1.AllowSet = 0;
                    Bundle arguments = this$0.getArguments();
                    if (arguments != null) {
                        bundle = arguments.getBundle("bind_phone_data");
                    } else {
                        bundle = null;
                    }
                    String str2 = "";
                    if (bundle == null || (str = bundle.getString("phone")) == null) {
                        str = "";
                    }
                    if (bundle != null && (string = bundle.getString("country_code")) != null) {
                        str2 = string;
                    }
                    S1.Mobile = str;
                    S1.CountryCode = str2;
                }
                Activity activity = this$0.getActivity();
                if (activity != null) {
                    Navigator createNavigator = QRoute.createNavigator(activity, RouterConstants.UI_ROUTER_RISK_INFO);
                    Intrinsics.checkNotNull(Z1, "null cannot be cast to non-null type java.util.ArrayList<android.os.Parcelable>{ kotlin.collections.TypeAliasesKt.ArrayList<android.os.Parcelable> }");
                    Navigator.withRequestCode$default(createNavigator.withParcelableArrayList("data", Z1).withParcelable(AuthDevOpenUgActivity.KEY_DEVLOCK_INFO, S1), activity, 3, (Bundle) null, 4, (Object) null).request();
                }
                ReportController.o(this$0.getApp(), "dc00899", "Safe_RiskInfo", "", "RiskDetails", "click on risk details", 0, 0, "", "", "", "");
                ReportController.y(this$0.getApp(), "0X800A718");
            }
            EventCollector.getInstance().onViewClicked(view);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.widget.listitem.w
        @NotNull
        /* renamed from: K, reason: merged with bridge method [inline-methods] */
        public AccountRiskInfoView H(@NotNull ViewGroup parent) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (AccountRiskInfoView) iPatchRedirector.redirect((short) 2, (Object) this, (Object) parent);
            }
            Intrinsics.checkNotNullParameter(parent, "parent");
            AccountRiskInfoView accountRiskInfoView = new AccountRiskInfoView(AccountSecurityFragment.this.getContext());
            final AccountSecurityFragment accountSecurityFragment = AccountSecurityFragment.this;
            accountRiskInfoView.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
            accountSecurityFragment.riskInfoView = accountRiskInfoView;
            accountRiskInfoView.setOnRiskClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.qqsec.account.n
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    AccountSecurityFragment.d.L(AccountSecurityFragment.this, view);
                }
            });
            AccountSecurityFragment.this.riskInfoView = accountRiskInfoView;
            AccountSecurityFragment.this.pi();
            return accountRiskInfoView;
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(18174);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 11)) {
            redirector.redirect((short) 11);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public AccountSecurityFragment() {
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.redTouchConfigs = new ArrayList();
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<AccountSecurityVM>() { // from class: com.tencent.mobileqq.qqsec.account.AccountSecurityFragment$accountSecurityVM$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AccountSecurityFragment.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final AccountSecurityVM invoke() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                return (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) ? (AccountSecurityVM) AccountSecurityFragment.this.getViewModel(AccountSecurityVM.class) : (AccountSecurityVM) iPatchRedirector2.redirect((short) 2, (Object) this);
            }
        });
        this.accountSecurityVM = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<Integer>() { // from class: com.tencent.mobileqq.qqsec.account.AccountSecurityFragment$topPadding$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AccountSecurityFragment.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Integer invoke() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (Integer) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
                Context requireContext = AccountSecurityFragment.this.requireContext();
                Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
                return Integer.valueOf(com.tencent.biz.qui.quisecnavbar.e.b(requireContext));
            }
        });
        this.topPadding = lazy2;
        lazy3 = LazyKt__LazyJVMKt.lazy(new Function0<Integer>() { // from class: com.tencent.mobileqq.qqsec.account.AccountSecurityFragment$maxAlphaOffset$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AccountSecurityFragment.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Integer invoke() {
                int fi5;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (Integer) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
                fi5 = AccountSecurityFragment.this.fi();
                return Integer.valueOf(fi5 / 2);
            }
        });
        this.maxAlphaOffset = lazy3;
    }

    private final com.tencent.mobileqq.widget.listitem.a<?> Sh() {
        String str;
        String string = getString(R.string.f196904ik);
        Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.qq_account_release)");
        final String str2 = "";
        x xVar = new x(new x.b.d(string), new x.c.g("", true, false));
        AppRuntime app = getApp();
        if (app != null) {
            str = app.getCurrentAccountUin();
        } else {
            str = null;
        }
        if (str != null) {
            Intrinsics.checkNotNullExpressionValue(str, "app?.currentAccountUin ?: \"\"");
            str2 = str;
        }
        final MMKVOptionEntity from = QMMKV.from(BaseApplication.getContext(), "common_mmkv_configurations");
        Intrinsics.checkNotNullExpressionValue(from, "from(MobileQQ.getContext(), QMMKVFile.FILE_COMMON)");
        xVar.p(from.decodeBool(str2 + AppConstants.Preferences.ACCOUNT_RELEASE_CONFIG_ENTRANCE, true));
        if (xVar.getIsVisible()) {
            ReportController.y(getApp(), "0X800B7DF");
        }
        xVar.x(new View.OnClickListener() { // from class: com.tencent.mobileqq.qqsec.account.i
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AccountSecurityFragment.Th(MMKVOptionEntity.this, str2, this, view);
            }
        });
        xVar.w(new com.tencent.mobileqq.widget.listitem.g() { // from class: com.tencent.mobileqq.qqsec.account.j
            @Override // com.tencent.mobileqq.widget.listitem.g
            public final void M(View view) {
                AccountSecurityFragment.Uh(AccountSecurityFragment.this, view);
            }
        });
        return xVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Th(MMKVOptionEntity mmkv, String uin, AccountSecurityFragment this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(mmkv, "$mmkv");
        Intrinsics.checkNotNullParameter(uin, "$uin");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        String decodeString = mmkv.decodeString(uin + AppConstants.Preferences.ACCOUNT_RELEASE_CONFIG_URL, "");
        if (TextUtils.isEmpty(decodeString)) {
            decodeString = "https://accounts.qq.com/qqcancel/index.html";
        }
        Activity activity = this$0.getActivity();
        if (activity != null) {
            Navigator.withRequestCode$default(QRoute.createNavigator(activity, RouterConstants.UI_ROUTE_BROWSER).withString("url", decodeString).withBoolean("is_release_account", true), activity, 4, (Bundle) null, 4, (Object) null).request();
        }
        ReportController.y(this$0.getApp(), "0X8009899");
        ReportController.y(this$0.getApp(), "0X800B843");
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Uh(AccountSecurityFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(view, "view");
        this$0.vi(view, "em_bas_cancel_account");
    }

    /* JADX WARN: Code restructure failed: missing block: B:4:0x0045, code lost:
    
        if (r4 == null) goto L6;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final Group[] Vh() {
        List<com.tencent.mobileqq.widget.listitem.a<?>> mutableListOf;
        com.tencent.mobileqq.widget.listitem.a[] aVarArr;
        mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(Yh(), Sh(), ti());
        this.secondConfigList = mutableListOf;
        Group[] groupArr = new Group[2];
        groupArr[0] = new Group(ri());
        List<com.tencent.mobileqq.widget.listitem.a<?>> list = this.secondConfigList;
        if (list != null) {
            Object[] array = list.toArray(new com.tencent.mobileqq.widget.listitem.a[0]);
            Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
            aVarArr = (com.tencent.mobileqq.widget.listitem.a[]) array;
        }
        aVarArr = new com.tencent.mobileqq.widget.listitem.a[0];
        groupArr[1] = new Group((com.tencent.mobileqq.widget.listitem.a[]) Arrays.copyOf(aVarArr, aVarArr.length));
        return groupArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final com.tencent.mobileqq.widget.listitem.a<?> Wh(CharSequence leftText, final String url) {
        x xVar = new x(new x.b.d(leftText), new x.c.g("", true, false));
        xVar.x(new View.OnClickListener() { // from class: com.tencent.mobileqq.qqsec.account.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AccountSecurityFragment.Xh(url, this, view);
            }
        });
        return xVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Xh(String str, AccountSecurityFragment this$0, View view) {
        boolean z16;
        Activity activity;
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (str != null && str.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!z16 && (activity = this$0.getActivity()) != null) {
            Intent putExtra = new Intent().putExtra("url", str);
            Intrinsics.checkNotNullExpressionValue(putExtra, "Intent().putExtra(\"url\", url)");
            RouteUtils.startActivity(activity, putExtra, RouterConstants.UI_ROUTE_BROWSER);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    private final com.tencent.mobileqq.widget.listitem.a<?> Yh() {
        String string = getString(R.string.f170895io1);
        Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.eqlock_face_verify)");
        final com.tencent.mobileqq.setting.config.a aVar = new com.tencent.mobileqq.setting.config.a(string, 0);
        ReportController.y(getApp(), "0X800B7DB");
        MutableLiveData<oidb_0x5e1$RspBody> W1 = ci().W1();
        LifecycleOwner lifecycleOwner = getLifecycleOwner();
        final Function1<oidb_0x5e1$RspBody, Unit> function1 = new Function1<oidb_0x5e1$RspBody, Unit>(this) { // from class: com.tencent.mobileqq.qqsec.account.AccountSecurityFragment$faceIdentificationConfig$1$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ AccountSecurityFragment this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.this$0 = this;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) com.tencent.mobileqq.setting.config.a.this, (Object) this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(oidb_0x5e1$RspBody oidb_0x5e1_rspbody) {
                invoke2(oidb_0x5e1_rspbody);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable oidb_0x5e1$RspBody oidb_0x5e1_rspbody) {
                String di5;
                QUIListItemAdapter qUIListItemAdapter;
                boolean gi5;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) oidb_0x5e1_rspbody);
                    return;
                }
                com.tencent.mobileqq.setting.config.a aVar2 = com.tencent.mobileqq.setting.config.a.this;
                di5 = this.this$0.di(oidb_0x5e1_rspbody);
                aVar2.M(di5);
                com.tencent.mobileqq.setting.config.a.this.N(false);
                qUIListItemAdapter = this.this$0.adapter;
                if (qUIListItemAdapter != null) {
                    qUIListItemAdapter.l0(com.tencent.mobileqq.setting.config.a.this);
                }
                gi5 = this.this$0.gi(oidb_0x5e1_rspbody);
                ReportController.o(null, "dc00898", "", "", "0X800AA7A", "0X800AA7A", 0, 0, gi5 ? "1" : "0", "", "", "");
            }
        };
        W1.observe(lifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.qqsec.account.a
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                AccountSecurityFragment.Zh(Function1.this, obj);
            }
        });
        if (ci().g2()) {
            aVar.N(true);
        }
        aVar.x(new View.OnClickListener() { // from class: com.tencent.mobileqq.qqsec.account.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AccountSecurityFragment.ai(AccountSecurityFragment.this, view);
            }
        });
        aVar.w(new com.tencent.mobileqq.widget.listitem.g() { // from class: com.tencent.mobileqq.qqsec.account.f
            @Override // com.tencent.mobileqq.widget.listitem.g
            public final void M(View view) {
                AccountSecurityFragment.bi(AccountSecurityFragment.this, view);
            }
        });
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Zh(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ai(AccountSecurityFragment this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.ni();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void bi(AccountSecurityFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(view, "view");
        this$0.vi(view, "em_bas_face_recognition");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final AccountSecurityVM ci() {
        Object value = this.accountSecurityVM.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-accountSecurityVM>(...)");
        return (AccountSecurityVM) value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String di(oidb_0x5e1$RspBody faceStateInfo) {
        if (faceStateInfo != null && !faceStateInfo.rpt_msg_uin_data.isEmpty()) {
            if (faceStateInfo.rpt_msg_uin_data.get(0).user_login_guard_face.get() == 1) {
                String string = BaseApplication.getContext().getString(R.string.io8);
                Intrinsics.checkNotNullExpressionValue(string, "{\n                    Mo\u2026e_data)\n                }");
                return string;
            }
            String string2 = BaseApplication.getContext().getString(R.string.ioe);
            Intrinsics.checkNotNullExpressionValue(string2, "{\n                    Mo\u2026e_data)\n                }");
            return string2;
        }
        return "";
    }

    private final int ei() {
        return ((Number) this.maxAlphaOffset.getValue()).intValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int fi() {
        return ((Number) this.topPadding.getValue()).intValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Activity getActivity() {
        FragmentActivity activity = getActivity();
        if (activity != null && !activity.isFinishing() && !activity.isDestroyed()) {
            return activity;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final AppRuntime getApp() {
        return MobileQQ.sMobileQQ.peekAppRuntime();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean gi(oidb_0x5e1$RspBody faceStateInfo) {
        if (faceStateInfo == null || faceStateInfo.rpt_msg_uin_data.isEmpty() || faceStateInfo.rpt_msg_uin_data.get(0).user_login_guard_face.get() != 1) {
            return false;
        }
        return true;
    }

    private final void hi(com.tencent.mobileqq.widget.listitem.a<?> aVar) {
        ReportController.y(getApp(), "0X800B7DE");
        aVar.x(new View.OnClickListener() { // from class: com.tencent.mobileqq.qqsec.account.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AccountSecurityFragment.ii(AccountSecurityFragment.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ii(AccountSecurityFragment this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Activity activity = this$0.getActivity();
        if (activity != null) {
            ((IMiniAppService) QRoute.api(IMiniAppService.class)).startMiniApp(activity, "mqqapi://miniapp/open?_atype=0&_mappid=1109907872&_mvid=&_vt=3&via=4010&_sig=1596013484", 4010, null);
        }
        ReportController.o(this$0.getApp(), "dc00899", "QQSafetyCenter", "", "clickQQSafetyCenter", "qq_safety_center_item", 0, 1, "", "", "", "");
        ReportController.y(this$0.getApp(), "0X800A719");
        ReportController.y(this$0.getApp(), "0X800B842");
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void initData() {
        AppRuntime app = getApp();
        if (app != null) {
            app.getCurrentAccountUin();
        }
        Bundle arguments = getArguments();
        boolean z16 = false;
        if (arguments != null) {
            z16 = arguments.getBoolean("has_unverified_phone", false);
        }
        this.hasUnverifiedPhone = z16;
        ci().R1();
        ji();
    }

    private final void initUI(View rootView) {
        QUIListItemAdapter qUIListItemAdapter;
        QUISecNavBar qUISecNavBar = (QUISecNavBar) rootView.findViewById(R.id.jo9);
        this.quiSecNavBar = qUISecNavBar;
        if (qUISecNavBar != null) {
            qUISecNavBar.setOnBaseTitleBarClickListener(new Function2<View, BaseAction, Unit>() { // from class: com.tencent.mobileqq.qqsec.account.AccountSecurityFragment$initUI$1
                static IPatchRedirector $redirector_;

                /* compiled from: P */
                @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
                /* loaded from: classes17.dex */
                public /* synthetic */ class a {
                    static IPatchRedirector $redirector_;

                    /* renamed from: a, reason: collision with root package name */
                    public static final /* synthetic */ int[] f274373a;

                    static {
                        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(18040);
                        $redirector_ = redirector;
                        if (redirector != null && redirector.hasPatch((short) 1)) {
                            redirector.redirect((short) 1);
                            return;
                        }
                        int[] iArr = new int[BaseAction.values().length];
                        try {
                            iArr[BaseAction.ACTION_LEFT_BUTTON.ordinal()] = 1;
                        } catch (NoSuchFieldError unused) {
                        }
                        f274373a = iArr;
                    }
                }

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(2);
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) AccountSecurityFragment.this);
                    }
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(View view, BaseAction baseAction) {
                    invoke2(view, baseAction);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull View v3, @NotNull BaseAction action) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this, (Object) v3, (Object) action);
                        return;
                    }
                    Intrinsics.checkNotNullParameter(v3, "v");
                    Intrinsics.checkNotNullParameter(action, "action");
                    if (a.f274373a[action.ordinal()] == 1) {
                        AccountSecurityFragment.this.onBackEvent();
                    }
                }
            });
        }
        QUISecNavBar qUISecNavBar2 = this.quiSecNavBar;
        if (qUISecNavBar2 != null) {
            qUISecNavBar2.setBaseViewDescription(BaseAction.ACTION_LEFT_BUTTON, "\u8fd4\u56de");
        }
        QUISecNavBar qUISecNavBar3 = this.quiSecNavBar;
        if (qUISecNavBar3 != null) {
            qUISecNavBar3.S(this);
        }
        String string = getString(R.string.frq);
        Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.qq_setting_device_security)");
        setTitle(string);
        this.recyclerView = (SettingOverScrollRecyclerView) rootView.findViewById(R.id.i4m);
        QUIListItemAdapter qUIListItemAdapter2 = new QUIListItemAdapter(null, true, true, 1, null);
        this.adapter = qUIListItemAdapter2;
        SettingOverScrollRecyclerView settingOverScrollRecyclerView = this.recyclerView;
        if (settingOverScrollRecyclerView != null) {
            settingOverScrollRecyclerView.setAdapter(qUIListItemAdapter2);
        }
        Group[] Vh = Vh();
        this.groupList = Vh;
        if (Vh != null && (qUIListItemAdapter = this.adapter) != null) {
            qUIListItemAdapter.t0((Group[]) Arrays.copyOf(Vh, Vh.length));
        }
        SettingOverScrollRecyclerView settingOverScrollRecyclerView2 = this.recyclerView;
        if (settingOverScrollRecyclerView2 != null) {
            settingOverScrollRecyclerView2.setClipToPadding(false);
            settingOverScrollRecyclerView2.setPadding(0, fi(), 0, 0);
            QUISecNavBar qUISecNavBar4 = this.quiSecNavBar;
            if (qUISecNavBar4 != null) {
                QUISecNavBar.setBlur$default(qUISecNavBar4, true, settingOverScrollRecyclerView2, 0, 4, null);
            }
            settingOverScrollRecyclerView2.setOnVerticalScrollListener(new b());
            settingOverScrollRecyclerView2.F(new c());
        }
        initData();
        View findViewById = rootView.findViewById(R.id.f98235mj);
        if (findViewById != null) {
            ViewGroup.LayoutParams layoutParams = findViewById.getLayoutParams();
            if (layoutParams != null) {
                Intrinsics.checkNotNullExpressionValue(layoutParams, "layoutParams");
                layoutParams.height = fi();
                findViewById.setLayoutParams(layoutParams);
            }
            findViewById.setClickable(true);
        }
    }

    @SuppressLint({"NotifyDataSetChanged"})
    private final void ji() {
        MutableLiveData<List<com.tencent.mobileqq.dt.api.g>> d26 = ci().d2();
        LifecycleOwner lifecycleOwner = getLifecycleOwner();
        final Function1<List<? extends com.tencent.mobileqq.dt.api.g>, Unit> function1 = new Function1<List<? extends com.tencent.mobileqq.dt.api.g>, Unit>() { // from class: com.tencent.mobileqq.qqsec.account.AccountSecurityFragment$initSecureEntryConfig$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) AccountSecurityFragment.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(List<? extends com.tencent.mobileqq.dt.api.g> list) {
                invoke2(list);
                return Unit.INSTANCE;
            }

            /* JADX WARN: Code restructure failed: missing block: B:11:0x0019, code lost:
            
                r0 = r7.this$0.secondConfigList;
             */
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final void invoke2(@Nullable List<? extends com.tencent.mobileqq.dt.api.g> list) {
                List list2;
                Group[] groupArr;
                QUIListItemAdapter qUIListItemAdapter;
                com.tencent.mobileqq.widget.listitem.a Wh;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) list);
                    return;
                }
                if (list == null || list.isEmpty() || list2 == null) {
                    return;
                }
                for (com.tencent.mobileqq.dt.api.g gVar : list) {
                    if (!TextUtils.isEmpty(gVar.f203667b)) {
                        AccountSecurityFragment accountSecurityFragment = AccountSecurityFragment.this;
                        String str = gVar.f203667b;
                        Intrinsics.checkNotNullExpressionValue(str, "secureEntryData.name");
                        Wh = accountSecurityFragment.Wh(str, gVar.f203668c);
                        int i3 = gVar.f203666a;
                        if (i3 >= 0 && i3 <= list2.size() - 1) {
                            list2.add(i3, Wh);
                        } else {
                            list2.add(Wh);
                        }
                    }
                }
                groupArr = AccountSecurityFragment.this.groupList;
                if (groupArr != null) {
                    AccountSecurityFragment accountSecurityFragment2 = AccountSecurityFragment.this;
                    if (groupArr.length >= 2) {
                        Object[] array = list2.toArray(new com.tencent.mobileqq.widget.listitem.a[0]);
                        Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                        com.tencent.mobileqq.widget.listitem.a[] aVarArr = (com.tencent.mobileqq.widget.listitem.a[]) array;
                        groupArr[1] = new Group((com.tencent.mobileqq.widget.listitem.a[]) Arrays.copyOf(aVarArr, aVarArr.length));
                    }
                    qUIListItemAdapter = accountSecurityFragment2.adapter;
                    if (qUIListItemAdapter != null) {
                        qUIListItemAdapter.t0((Group[]) Arrays.copyOf(groupArr, groupArr.length));
                    }
                }
            }
        };
        d26.observe(lifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.qqsec.account.h
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                AccountSecurityFragment.ki(Function1.this, obj);
            }
        });
        ci().b2();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ki(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void li() {
        String str;
        ((ISafeApi) QRoute.api(ISafeApi.class)).logoutAfterReleaseAccount();
        AppRuntime app = getApp();
        if (app != null) {
            str = app.getCurrentAccountUin();
        } else {
            str = null;
        }
        if (str == null) {
            str = "";
        }
        MMKVOptionEntity from = QMMKV.from(BaseApplication.getContext(), "common_mmkv_configurations");
        Intrinsics.checkNotNullExpressionValue(from, "from(MobileQQ.getContext(), QMMKVFile.FILE_COMMON)");
        String decodeString = from.decodeString(str + AppConstants.Preferences.ACCOUNT_RELEASE_CONFIG_SUCCESS_TEXT, "");
        String decodeString2 = from.decodeString(str + AppConstants.Preferences.ACCOUNT_RELEASE_CONFIG_BOLD_TEXT, "");
        Intent intent = new Intent();
        intent.putExtra("logout_intent", true);
        intent.putExtra("tab_index", com.tencent.mobileqq.activity.home.impl.a.f183038a);
        intent.putExtra("is_from_account_release", true);
        AppRuntime app2 = getApp();
        Intrinsics.checkNotNull(app2);
        intent.putExtra("release_account_uin", app2.getCurrentAccountUin());
        intent.putExtra("release_success_text", decodeString);
        intent.putExtra("release_bold_text", decodeString2);
        Activity activity = getActivity();
        if (activity != null) {
            RouteUtils.startActivity(activity, intent, RouterConstants.UI_ROUTER_LOGIN);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void mi(AccountSecurityFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.li();
    }

    private final void ni() {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        Bundle bundle;
        oidb_0x5e1$RspBody U1 = ci().U1();
        if (U1 == null) {
            if (!NetworkUtil.isNetworkAvailable()) {
                String string = BaseApplication.getContext().getString(R.string.b3j);
                Intrinsics.checkNotNullExpressionValue(string, "getContext().getString(R.string.failedconnection)");
                showToast(string);
            }
            QLog.e("AccountSecurityFragment", 1, "onFaceIdentificationClick error : faceStateInfo is null");
            return;
        }
        if (U1.rpt_msg_uin_data.isEmpty()) {
            QLog.e("AccountSecurityFragment", 1, "onFaceIdentificationClick error : faceStateInfo rpt_msg_uin_data is empty");
            return;
        }
        FaceSecureCheck$SecureCheckResponse e26 = ci().e2();
        DevlockInfo S1 = ci().S1();
        String str6 = null;
        if (S1 != null) {
            str = S1.Mobile;
        } else {
            str = null;
        }
        String str7 = "";
        if (str == null) {
            str = "";
        }
        DevlockInfo S12 = ci().S1();
        if (S12 != null) {
            str2 = S12.CountryCode;
        } else {
            str2 = null;
        }
        if (str2 == null) {
            str2 = "";
        }
        if (((ISafeApi) QRoute.api(ISafeApi.class)).needDeleteDevLock()) {
            Bundle arguments = getArguments();
            if (arguments != null) {
                bundle = arguments.getBundle("bind_phone_data");
            } else {
                bundle = null;
            }
            if (bundle != null) {
                str4 = bundle.getString("phone");
            } else {
                str4 = null;
            }
            if (str4 == null) {
                str4 = "";
            }
            if (bundle != null) {
                str6 = bundle.getString("country_code");
            }
            if (str6 != null) {
                str7 = str6;
            }
            str3 = str7;
        } else {
            str3 = str2;
            str4 = str;
        }
        ((ISafeApi) QRoute.api(ISafeApi.class)).clickFaceSettingEntry(getApp(), getActivity(), str4, str3, this.hasUnverifiedPhone, U1, e26, new ISafeApi.a() { // from class: com.tencent.mobileqq.qqsec.account.m
            @Override // com.tencent.mobileqq.app.identity.ISafeApi.a
            public final void error(String str8) {
                AccountSecurityFragment.oi(AccountSecurityFragment.this, str8);
            }
        });
        if (gi(U1)) {
            str5 = "1";
        } else {
            str5 = "0";
        }
        ReportController.o(null, "dc00898", "", "", "0X800AA7B", "0X800AA7B", 0, 0, str5, "", "", "");
        ReportController.y(getApp(), "0X800B83F");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void oi(AccountSecurityFragment this$0, String it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!TextUtils.isEmpty(it)) {
            Intrinsics.checkNotNullExpressionValue(it, "it");
            this$0.showToast(it);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void pi() {
        AccountRiskInfoView accountRiskInfoView = this.riskInfoView;
        if (accountRiskInfoView != null) {
            boolean z16 = false;
            if (accountRiskInfoView != null && accountRiskInfoView.k()) {
                z16 = true;
            }
            if (!z16) {
                ThreadManager.getUIHandler().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.qqsec.account.b
                    @Override // java.lang.Runnable
                    public final void run() {
                        AccountSecurityFragment.qi(AccountSecurityFragment.this);
                    }
                }, 200L);
                ci().l2();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void qi(AccountSecurityFragment this$0) {
        AccountRiskInfoView accountRiskInfoView;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.getActivity() != null && (accountRiskInfoView = this$0.riskInfoView) != null) {
            accountRiskInfoView.m();
        }
    }

    private final com.tencent.mobileqq.widget.listitem.a<?> ri() {
        d dVar = new d();
        MutableLiveData<Bundle> a26 = ci().a2();
        LifecycleOwner lifecycleOwner = getLifecycleOwner();
        final AccountSecurityFragment$riskInfoConfig$2$1 accountSecurityFragment$riskInfoConfig$2$1 = new AccountSecurityFragment$riskInfoConfig$2$1(this);
        a26.observe(lifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.qqsec.account.k
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                AccountSecurityFragment.si(Function1.this, obj);
            }
        });
        return dVar;
    }

    private final void showToast(String message) {
        QQToast.makeText(BaseApplication.getContext(), message, 0).show(BaseApplication.getContext().getResources().getDimensionPixelSize(R.dimen.title_bar_height));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void si(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final com.tencent.mobileqq.widget.listitem.a<?> ti() {
        String string = requireContext().getString(R.string.f2039451k);
        Intrinsics.checkNotNullExpressionValue(string, "requireContext().getStri\u2026.string.qq_safety_center)");
        String string2 = requireContext().getString(R.string.f2039551l);
        Intrinsics.checkNotNullExpressionValue(string2, "requireContext().getStri\u2026.qq_safety_center_bottom)");
        com.tencent.mobileqq.widget.listitem.c cVar = new com.tencent.mobileqq.widget.listitem.c(new c.a.g(string, string2), new c.b.C8995c("", true, false));
        hi(cVar);
        cVar.w(new com.tencent.mobileqq.widget.listitem.g() { // from class: com.tencent.mobileqq.qqsec.account.g
            @Override // com.tencent.mobileqq.widget.listitem.g
            public final void M(View view) {
                AccountSecurityFragment.ui(AccountSecurityFragment.this, view);
            }
        });
        return cVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ui(AccountSecurityFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(view, "view");
        this$0.vi(view, "em_bas_qq_security_center");
    }

    private final void vi(View view, String id5) {
        VideoReport.setElementId(view, id5);
        VideoReport.setElementExposePolicy(view, ExposurePolicy.REPORT_ALL);
        VideoReport.setElementClickPolicy(view, ClickPolicy.REPORT_ALL);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void wi(int offset) {
        float f16;
        if (offset <= 0) {
            f16 = 0.0f;
        } else if (offset < ei()) {
            f16 = (offset * 1.0f) / ei();
        } else {
            f16 = 1.0f;
        }
        QUISecNavBar qUISecNavBar = this.quiSecNavBar;
        if (qUISecNavBar != null) {
            qUISecNavBar.setTitleBlurAlpha(f16);
        }
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean needImmersive() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        return false;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, Integer.valueOf(requestCode), Integer.valueOf(resultCode), data);
            return;
        }
        super.onActivityResult(requestCode, resultCode, data);
        if (getActivity() == null) {
            return;
        }
        if (requestCode != 0) {
            if (requestCode != 1) {
                if (requestCode != 3) {
                    if (requestCode != 4) {
                        if (requestCode != 11) {
                            if (requestCode != 12) {
                                if (requestCode != 21) {
                                    return;
                                }
                            } else {
                                if (resultCode == -1 && data != null && data.getBooleanExtra("key_face_scan_result", false)) {
                                    ci().q2(0);
                                    String string = BaseApplication.getContext().getString(R.string.zvj);
                                    Intrinsics.checkNotNullExpressionValue(string, "getContext().getString(R\u2026eqlock_face_date_deleted)");
                                    showToast(string);
                                    return;
                                }
                                return;
                            }
                        }
                        if (resultCode == -1 && data != null && data.getBooleanExtra("key_face_scan_result", false)) {
                            ci().q2(1);
                            return;
                        }
                        return;
                    }
                    if (resultCode == -1) {
                        QLog.i("AccountSecurityFragment", 1, "onActivityResult requestCode:" + requestCode + " resultCode:" + resultCode);
                        ThreadManager.getUIHandler().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.qqsec.account.l
                            @Override // java.lang.Runnable
                            public final void run() {
                                AccountSecurityFragment.mi(AccountSecurityFragment.this);
                            }
                        }, 100L);
                        ReportController.y(getApp(), "0X800989B");
                        return;
                    }
                    ReportController.y(getApp(), "0X800989A");
                    return;
                }
                pi();
                return;
            }
            ci().j2();
            return;
        }
        if (resultCode == -1 || resultCode == 0) {
            if (!((ISafeApi) QRoute.api(ISafeApi.class)).needDeleteDevLock()) {
                ci().t2();
            }
            pi();
        }
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, com.tencent.biz.richframework.compat.IFragmentCallbacks
    public boolean onBackEvent() {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this)).booleanValue();
        }
        boolean z17 = true;
        if (((ISafeApi) QRoute.api(ISafeApi.class)).needDeleteDevLock()) {
            Intent intent = new Intent();
            intent.putExtra(AuthDevOpenUgActivity.KEY_AUTH_DEV_OPEN, true);
            intent.putExtra(AuthDevOpenUgActivity.KEY_ALLOW_SET, false);
            Activity activity = getActivity();
            if (activity != null) {
                activity.setResult(0, intent);
            }
            Activity activity2 = getActivity();
            if (activity2 != null) {
                activity2.finish();
            }
            return false;
        }
        DevlockInfo S1 = ci().S1();
        if (S1 != null) {
            Intent intent2 = new Intent();
            if (S1.DevSetup == 1) {
                z16 = true;
            } else {
                z16 = false;
            }
            intent2.putExtra(AuthDevOpenUgActivity.KEY_AUTH_DEV_OPEN, z16);
            if (S1.AllowSet != 1) {
                z17 = false;
            }
            intent2.putExtra(AuthDevOpenUgActivity.KEY_ALLOW_SET, z17);
            Activity activity3 = getActivity();
            if (activity3 != null) {
                activity3.setResult(0, intent2);
            }
        }
        return false;
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            rootView = (View) iPatchRedirector.redirect((short) 4, this, inflater, container, savedInstanceState);
        } else {
            Intrinsics.checkNotNullParameter(inflater, "inflater");
            rootView = inflater.inflate(R.layout.f168778gv3, container, false);
            Intrinsics.checkNotNullExpressionValue(rootView, "rootView");
            initUI(rootView);
        }
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, rootView);
        return rootView;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        super.onDestroyView();
        AccountRiskInfoView accountRiskInfoView = this.riskInfoView;
        if (accountRiskInfoView != null) {
            accountRiskInfoView.clearAnimation();
        }
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment
    public void onFinish() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
            return;
        }
        super.onFinish();
        Activity activity = getActivity();
        if (activity != null) {
            Intent intent = activity.getIntent();
            boolean z16 = false;
            if (intent != null && intent.getBooleanExtra("from_risk_hint", false)) {
                z16 = true;
            }
            if (z16) {
                intent.removeExtra("from_risk_hint");
                Intent intent2 = new Intent();
                intent2.putExtra("from_risk_hint", true);
                ((ISettingApi) QRoute.api(ISettingApi.class)).startMainSettingPage(activity, intent2);
            }
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        super.onResume();
        ci().j2();
        if (!((ISafeApi) QRoute.api(ISafeApi.class)).needDeleteDevLock()) {
            ci().t2();
        }
        for (com.tencent.mobileqq.setting.config.b bVar : this.redTouchConfigs) {
            QUIListItemAdapter qUIListItemAdapter = this.adapter;
            if (qUIListItemAdapter != null) {
                qUIListItemAdapter.l0(bVar);
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        String str;
        HashMap hashMapOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) view, (Object) savedInstanceState);
            return;
        }
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        VideoReport.addToDetectionWhitelist(getActivity());
        VideoReport.setPageId(view, "pg_bas_more_security_settings");
        Pair[] pairArr = new Pair[1];
        AppRuntime app = getApp();
        if (app != null) {
            str = app.getCurrentAccountUin();
        } else {
            str = null;
        }
        pairArr[0] = TuplesKt.to("uin", str);
        hashMapOf = MapsKt__MapsKt.hashMapOf(pairArr);
        VideoReport.setPageParams(view, new PageParams(hashMapOf));
    }

    public final void setTitle(@NotNull CharSequence title) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) title);
            return;
        }
        Intrinsics.checkNotNullParameter(title, "title");
        QUISecNavBar qUISecNavBar = this.quiSecNavBar;
        if (qUISecNavBar != null) {
            qUISecNavBar.setCenterText(title);
        }
    }
}
