package com.tencent.mobileqq.troop.troopsetting.modules.personalsetting.ui;

import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.style.ImageSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.os.BundleKt;
import androidx.fragment.app.FragmentActivity;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.proxy.personalitycomponent.model.WidgetCacheLunarData;
import com.tencent.ams.xsad.rewarded.dynamic.method.AdCommonMethodHandler;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.common.app.AppInterface;
import com.tencent.hippy.qq.view.scroll.HippyHeaderListViewController;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.aio.utils.au;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.RouterConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.fragment.QIphoneTitleBarFragment;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.route.ActivityURIRequest;
import com.tencent.mobileqq.qroute.route.o;
import com.tencent.mobileqq.studymode.api.IStudyModeManager;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.text.QQTextBuilder;
import com.tencent.mobileqq.troop.api.IChatSettingForTroopApi;
import com.tencent.mobileqq.troop.api.ITroopHandlerNameApi;
import com.tencent.mobileqq.troop.api.ITroopMemberInfoService;
import com.tencent.mobileqq.troop.entereffect.api.ITroopEnterEffectService;
import com.tencent.mobileqq.troop.entereffect.e;
import com.tencent.mobileqq.troop.honor.api.ITroopHonorService;
import com.tencent.mobileqq.troop.k;
import com.tencent.mobileqq.troop.shortcut.repo.TroopShortcutSettingCache;
import com.tencent.mobileqq.troop.troopidentity.api.ITroopIdentityApi;
import com.tencent.mobileqq.troop.trooplink.api.ITroopLinkApi;
import com.tencent.mobileqq.troop.troopsetting.modules.base.j;
import com.tencent.mobileqq.troop.troopsetting.modules.personalsetting.model.TroopPersonalSettingData;
import com.tencent.mobileqq.troop.utils.api.ITroopSPUtilApi;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.utils.eu;
import com.tencent.mobileqq.vas.toggle.VasNormalToggle;
import com.tencent.mobileqq.vas.troop.ITroopNickManager;
import com.tencent.mobileqq.widget.FormItemRelativeLayout;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mobileqq.zplan.scheme.ISchemeApi;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqnt.aio.nick.api.INickNameApi;
import com.tencent.qqnt.aio.nick.i;
import com.tencent.qqnt.kernel.api.s;
import com.tencent.qqnt.kernel.nativeinterface.IOperateCallback;
import com.tencent.qqnt.kernel.nativeinterface.SetCapsuleSwitchReq;
import com.tencent.widget.Switch;
import cooperation.qzone.QzoneIPCModule;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbes;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import mqq.app.Constants;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u00c8\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u0000 \u0083\u00012\u00020\u0001:\u0002\u0084\u0001B\t\u00a2\u0006\u0006\b\u0081\u0001\u0010\u0082\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0014J&\u0010\u000b\u001a\u00020\n2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0014J\b\u0010\f\u001a\u00020\nH\u0016J\b\u0010\r\u001a\u00020\nH\u0016J\"\u0010\u0012\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u00022\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016J\b\u0010\u0013\u001a\u00020\nH\u0002J\b\u0010\u0014\u001a\u00020\nH\u0002J\b\u0010\u0015\u001a\u00020\nH\u0002J\b\u0010\u0016\u001a\u00020\nH\u0002J\b\u0010\u0017\u001a\u00020\nH\u0002J\b\u0010\u0018\u001a\u00020\nH\u0002J\b\u0010\u0019\u001a\u00020\nH\u0002J\b\u0010\u001a\u001a\u00020\nH\u0002J\b\u0010\u001b\u001a\u00020\nH\u0002J\b\u0010\u001c\u001a\u00020\nH\u0002J\b\u0010\u001d\u001a\u00020\nH\u0002J\b\u0010\u001e\u001a\u00020\nH\u0002J\b\u0010\u001f\u001a\u00020\nH\u0002J\b\u0010 \u001a\u00020\nH\u0002J\b\u0010!\u001a\u00020\nH\u0002J\f\u0010#\u001a\u00020\n*\u00020\"H\u0002J\b\u0010$\u001a\u00020\nH\u0002J\b\u0010%\u001a\u00020\nH\u0002J\b\u0010&\u001a\u00020\nH\u0002J\b\u0010'\u001a\u00020\nH\u0002J\b\u0010(\u001a\u00020\nH\u0002J\u0010\u0010,\u001a\u00020+2\u0006\u0010*\u001a\u00020)H\u0002J\u0010\u0010-\u001a\u00020+2\u0006\u0010*\u001a\u00020)H\u0002J!\u00101\u001a\u00020\n2\u0006\u0010/\u001a\u00020.2\b\u00100\u001a\u0004\u0018\u00010+H\u0002\u00a2\u0006\u0004\b1\u00102J\u0018\u00106\u001a\u00020\n2\u0006\u00104\u001a\u0002032\u0006\u00105\u001a\u00020+H\u0002J\u0010\u00107\u001a\u00020\u00022\u0006\u00105\u001a\u00020+H\u0002J\u001d\u0010:\u001a\u0004\u0018\u0001092\u0006\u00108\u001a\u00020)H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b:\u0010;J\b\u0010<\u001a\u00020\nH\u0002J\b\u0010=\u001a\u00020\nH\u0002J\u0018\u0010@\u001a\u00020\n2\u0006\u0010>\u001a\u00020.2\u0006\u0010?\u001a\u00020\u0002H\u0002J8\u0010H\u001a\u00020\n*\u00020A2\u0006\u0010B\u001a\u00020\u00022\u0006\u0010D\u001a\u00020C2\b\b\u0002\u0010E\u001a\u00020.2\u0010\b\u0002\u0010G\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010FH\u0002J>\u0010K\u001a\u00020\n*\u00020A2\u0006\u0010B\u001a\u00020\u00022\u0006\u0010D\u001a\u00020C2\b\b\u0002\u00105\u001a\u00020+2\u0016\b\u0002\u0010J\u001a\u0010\u0012\u0004\u0012\u00020+\u0012\u0004\u0012\u00020\n\u0018\u00010IH\u0002J\u0014\u0010M\u001a\u00020\n*\u00020A2\u0006\u0010L\u001a\u00020+H\u0002J\u0014\u0010N\u001a\u00020\n*\u00020A2\u0006\u0010D\u001a\u00020CH\u0002J\u0014\u0010O\u001a\u00020\n*\u00020A2\u0006\u0010E\u001a\u00020.H\u0002J\f\u0010P\u001a\u00020\n*\u00020AH\u0002R\u0016\u0010T\u001a\u00020Q8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bR\u0010SR0\u0010Y\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020A0Uj\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020A`V8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bW\u0010XR\u001b\u0010_\u001a\u00020Z8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b[\u0010\\\u001a\u0004\b]\u0010^R\u001b\u0010d\u001a\u00020`8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\ba\u0010\\\u001a\u0004\bb\u0010cR\u001b\u0010i\u001a\u00020e8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bf\u0010\\\u001a\u0004\bg\u0010hR\u001b\u0010l\u001a\u00020e8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bj\u0010\\\u001a\u0004\bk\u0010hR\u0016\u0010p\u001a\u00020m8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bn\u0010oR\u001a\u0010t\u001a\b\u0012\u0004\u0012\u00020\u00020q8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\br\u0010sR\u001a\u0010v\u001a\b\u0012\u0004\u0012\u00020\u00020q8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bu\u0010sR\u001a\u0010x\u001a\b\u0012\u0004\u0012\u00020\u00020q8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bw\u0010sR\u0016\u0010|\u001a\u00020y8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bz\u0010{R\u0017\u0010\u0080\u0001\u001a\u00020}8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b~\u0010\u007f\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0085\u0001"}, d2 = {"Lcom/tencent/mobileqq/troop/troopsetting/modules/personalsetting/ui/TroopPersonalSettingFragment;", "Lcom/tencent/mobileqq/fragment/QIphoneTitleBarFragment;", "", "getContentLayoutId", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "", "doOnCreateView", "onResume", "onDestroyView", "requestCode", QzoneIPCModule.RESULT_CODE, "Landroid/content/Intent;", "data", "onActivityResult", "initNavBar", "ci", "Ch", "Dh", "Eh", "initData", "Yh", "li", "Th", "Uh", "ii", "bi", "Fh", "Xh", "ki", "Landroid/widget/TextView;", "mi", "Vh", "Qh", "Wh", WidgetCacheLunarData.JI, "ai", "", "troopUin", "", "gi", "fi", "", "tag", "value", "hi", "(Ljava/lang/String;Ljava/lang/Boolean;)V", "Landroid/view/View;", "v", "isChecked", "Zh", "ni", "switchValue", "Lcom/tencent/qqnt/kernel/nativeinterface/SetCapsuleSwitchReq;", "Gh", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Mh", "Nh", "nickName", "nickId", "qi", "Lcom/tencent/mobileqq/widget/FormItemRelativeLayout;", HippyHeaderListViewController.VIEW_TAG, "", "title", "info", "Lkotlin/Function0;", AdCommonMethodHandler.AdCommonEvent.CLICK_ACTION, "Rh", "Lkotlin/Function1;", "switchAction", "di", "isVisible", "oi", "pi", "si", "Ph", "Landroid/widget/LinearLayout;", BdhLogUtil.LogTag.Tag_Conn, "Landroid/widget/LinearLayout;", "containerView", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "D", "Ljava/util/HashMap;", "viewCaches", "Lcom/tencent/common/app/AppInterface;", "E", "Lkotlin/Lazy;", "Ih", "()Lcom/tencent/common/app/AppInterface;", "app", "Lcom/tencent/mobileqq/troop/api/IChatSettingForTroopApi;", UserInfo.SEX_FEMALE, "Lh", "()Lcom/tencent/mobileqq/troop/api/IChatSettingForTroopApi;", "troopApi", "Lcom/tencent/mobileqq/troop/entereffect/api/ITroopEnterEffectService;", "G", "Jh", "()Lcom/tencent/mobileqq/troop/entereffect/api/ITroopEnterEffectService;", "effectService", "H", "Kh", "enterEffectService", "Lcom/tencent/mobileqq/troop/troopsetting/modules/personalsetting/model/TroopPersonalSettingData;", "I", "Lcom/tencent/mobileqq/troop/troopsetting/modules/personalsetting/model/TroopPersonalSettingData;", ISchemeApi.KEY_PAGE_DATA, "", "J", "Ljava/util/List;", "firstGroupUITags", "K", "secondGroupUITags", "L", "thirdGroupUITags", "Lhs2/a;", "M", "Lhs2/a;", "enterEffectObserver", "Lcom/tencent/mobileqq/troop/luckycharacter/api/b;", "N", "Lcom/tencent/mobileqq/troop/luckycharacter/api/b;", "troopLuckyCharacterObserver", "<init>", "()V", "P", "a", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class TroopPersonalSettingFragment extends QIphoneTitleBarFragment {
    static IPatchRedirector $redirector_;

    /* renamed from: P, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;
    private static final boolean Q;

    /* renamed from: C, reason: from kotlin metadata */
    private LinearLayout containerView;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final HashMap<Integer, FormItemRelativeLayout> viewCaches;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final Lazy app;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final Lazy troopApi;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final Lazy effectService;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private final Lazy enterEffectService;

    /* renamed from: I, reason: from kotlin metadata */
    private TroopPersonalSettingData pageData;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    private final List<Integer> firstGroupUITags;

    /* renamed from: K, reason: from kotlin metadata */
    @NotNull
    private final List<Integer> secondGroupUITags;

    /* renamed from: L, reason: from kotlin metadata */
    @NotNull
    private final List<Integer> thirdGroupUITags;

    /* renamed from: M, reason: from kotlin metadata */
    @NotNull
    private hs2.a enterEffectObserver;

    /* renamed from: N, reason: from kotlin metadata */
    @NotNull
    private com.tencent.mobileqq.troop.luckycharacter.api.b troopLuckyCharacterObserver;

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0013\u0010\u0014J \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0007R\u0014\u0010\u000b\u001a\u00020\n8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\n8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\r\u0010\fR\u0014\u0010\u000e\u001a\u00020\n8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\fR\u0014\u0010\u000f\u001a\u00020\n8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\fR\u0014\u0010\u0011\u001a\u00020\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/troop/troopsetting/modules/personalsetting/ui/TroopPersonalSettingFragment$a;", "", "Lcom/tencent/mobileqq/app/QBaseActivity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Lcom/tencent/mobileqq/troop/troopsetting/modules/personalsetting/model/TroopPersonalSettingData;", ISchemeApi.KEY_PAGE_DATA, "", "requestCode", "", "a", "", "BUNDLE_KEY_PAGE_DATA", "Ljava/lang/String;", "ELEMENT_ID", "KEY_STATE", "TAG", "", "vasTempNickSwitch", "Z", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.troop.troopsetting.modules.personalsetting.ui.TroopPersonalSettingFragment$a, reason: from kotlin metadata */
    /* loaded from: classes19.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                return;
            }
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) defaultConstructorMarker);
        }

        @JvmStatic
        public final void a(@NotNull QBaseActivity activity, @NotNull TroopPersonalSettingData pageData, int requestCode) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, activity, pageData, Integer.valueOf(requestCode));
                return;
            }
            Intrinsics.checkNotNullParameter(activity, "activity");
            Intrinsics.checkNotNullParameter(pageData, "pageData");
            Bundle bundleOf = BundleKt.bundleOf(TuplesKt.to("bundle_key_page_data", pageData));
            Intent intent = new Intent();
            intent.putExtras(bundleOf);
            QPublicFragmentActivity.startForResult(activity, intent, (Class<? extends QPublicBaseFragment>) TroopPersonalSettingFragment.class, requestCode);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u000e\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u0005H\n\u00a2\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", "result", "", "errMsg", "", "kotlin.jvm.PlatformType", "onResult"}, k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes19.dex */
    public static final class b implements IOperateCallback {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Continuation<SetCapsuleSwitchReq> f301212a;

        /* JADX WARN: Multi-variable type inference failed */
        b(Continuation<? super SetCapsuleSwitchReq> continuation) {
            this.f301212a = continuation;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) continuation);
            }
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
        public final void onResult(int i3, String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, i3, (Object) str);
                return;
            }
            QLog.i("TroopPersonalSettingFragment", 1, "SetCapsuleSwitch() get response");
            if (i3 != 0) {
                QLog.e("TroopPersonalSettingFragment", 1, "SetCapsuleSwitch() error: " + str);
            } else {
                QLog.i("TroopPersonalSettingFragment", 1, "SetCapsuleSwitch() success");
            }
            this.f301212a.resumeWith(Result.m476constructorimpl(null));
        }
    }

    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0014\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/troop/troopsetting/modules/personalsetting/ui/TroopPersonalSettingFragment$c", "Lcom/tencent/mobileqq/troop/luckycharacter/api/b;", "", "isSuccess", "", "troopUin", "wording", "", "a", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes19.dex */
    public static final class c extends com.tencent.mobileqq.troop.luckycharacter.api.b {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopPersonalSettingFragment.this);
            }
        }

        @Override // com.tencent.mobileqq.troop.luckycharacter.api.b
        protected void a(boolean isSuccess, @NotNull String troopUin, @NotNull String wording) {
            FormItemRelativeLayout formItemRelativeLayout;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(isSuccess), troopUin, wording);
                return;
            }
            Intrinsics.checkNotNullParameter(troopUin, "troopUin");
            Intrinsics.checkNotNullParameter(wording, "wording");
            if (isSuccess) {
                TroopPersonalSettingData troopPersonalSettingData = TroopPersonalSettingFragment.this.pageData;
                if (troopPersonalSettingData == null) {
                    Intrinsics.throwUninitializedPropertyAccessException(ISchemeApi.KEY_PAGE_DATA);
                    troopPersonalSettingData = null;
                }
                if (Intrinsics.areEqual(troopUin, troopPersonalSettingData.e()) && (formItemRelativeLayout = (FormItemRelativeLayout) TroopPersonalSettingFragment.this.viewCaches.get(12)) != null) {
                    TroopPersonalSettingFragment.this.si(formItemRelativeLayout, wording);
                }
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(60456);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
        } else {
            INSTANCE = new Companion(null);
            Q = VasNormalToggle.VAS_TROOP_NICK_SETTING.isEnable(true);
        }
    }

    public TroopPersonalSettingFragment() {
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        Lazy lazy4;
        List<Integer> listOf;
        List<Integer> listOf2;
        List<Integer> listOf3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.viewCaches = new HashMap<>();
        lazy = LazyKt__LazyJVMKt.lazy(TroopPersonalSettingFragment$app$2.INSTANCE);
        this.app = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(TroopPersonalSettingFragment$troopApi$2.INSTANCE);
        this.troopApi = lazy2;
        lazy3 = LazyKt__LazyJVMKt.lazy(new Function0<ITroopEnterEffectService>() { // from class: com.tencent.mobileqq.troop.troopsetting.modules.personalsetting.ui.TroopPersonalSettingFragment$effectService$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) TroopPersonalSettingFragment.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final ITroopEnterEffectService invoke() {
                AppInterface Ih;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (ITroopEnterEffectService) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
                Ih = TroopPersonalSettingFragment.this.Ih();
                return (ITroopEnterEffectService) Ih.getRuntimeService(ITroopEnterEffectService.class, "all");
            }
        });
        this.effectService = lazy3;
        lazy4 = LazyKt__LazyJVMKt.lazy(new Function0<ITroopEnterEffectService>() { // from class: com.tencent.mobileqq.troop.troopsetting.modules.personalsetting.ui.TroopPersonalSettingFragment$enterEffectService$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) TroopPersonalSettingFragment.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final ITroopEnterEffectService invoke() {
                AppInterface Ih;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (ITroopEnterEffectService) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
                Ih = TroopPersonalSettingFragment.this.Ih();
                return (ITroopEnterEffectService) Ih.getRuntimeService(ITroopEnterEffectService.class, "all");
            }
        });
        this.enterEffectService = lazy4;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new Integer[]{1, 2, 3, 4});
        this.firstGroupUITags = listOf;
        listOf2 = CollectionsKt__CollectionsKt.listOf((Object[]) new Integer[]{11, 26, 12});
        this.secondGroupUITags = listOf2;
        listOf3 = CollectionsKt__CollectionsJVMKt.listOf(31);
        this.thirdGroupUITags = listOf3;
        this.enterEffectObserver = new hs2.a() { // from class: com.tencent.mobileqq.troop.troopsetting.modules.personalsetting.ui.c
            @Override // com.tencent.mobileqq.app.BusinessObserver
            public final void onUpdate(int i3, boolean z16, Object obj) {
                TroopPersonalSettingFragment.Hh(TroopPersonalSettingFragment.this, i3, z16, obj);
            }
        };
        this.troopLuckyCharacterObserver = new c();
    }

    private final void Ch() {
        Th();
        Uh();
        bi();
        Xh();
        com.tencent.mobileqq.troop.troopsetting.activity.d.h(this.viewCaches, this.firstGroupUITags);
    }

    private final void Dh() {
        Vh();
        Qh();
        Wh();
        com.tencent.mobileqq.troop.troopsetting.activity.d.h(this.viewCaches, this.secondGroupUITags);
    }

    private final void Eh() {
        ai();
        com.tencent.mobileqq.troop.troopsetting.activity.d.h(this.viewCaches, this.thirdGroupUITags);
    }

    private final void Fh() {
        FormItemRelativeLayout formItemRelativeLayout = this.viewCaches.get(3);
        if (formItemRelativeLayout == null) {
            return;
        }
        IChatSettingForTroopApi Lh = Lh();
        AppInterface Ih = Ih();
        TroopPersonalSettingData troopPersonalSettingData = this.pageData;
        if (troopPersonalSettingData == null) {
            Intrinsics.throwUninitializedPropertyAccessException(ISchemeApi.KEY_PAGE_DATA);
            troopPersonalSettingData = null;
        }
        Lh.initKeyword(Ih, troopPersonalSettingData.e(), isDetached(), formItemRelativeLayout);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object Gh(long j3, Continuation<? super SetCapsuleSwitchReq> continuation) {
        Long longOrNull;
        long j16;
        Continuation intercepted;
        Unit unit;
        Object coroutine_suspended;
        SetCapsuleSwitchReq setCapsuleSwitchReq = new SetCapsuleSwitchReq();
        TroopPersonalSettingData troopPersonalSettingData = this.pageData;
        if (troopPersonalSettingData == null) {
            Intrinsics.throwUninitializedPropertyAccessException(ISchemeApi.KEY_PAGE_DATA);
            troopPersonalSettingData = null;
        }
        longOrNull = StringsKt__StringNumberConversionsKt.toLongOrNull(troopPersonalSettingData.e());
        if (longOrNull != null) {
            j16 = longOrNull.longValue();
        } else {
            j16 = 0;
        }
        setCapsuleSwitchReq.groupId = j16;
        setCapsuleSwitchReq.switchValue = j3;
        QLog.i("TroopPersonalSettingFragment", 1, "SetCapsuleSwitch() do request: " + setCapsuleSwitchReq);
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        SafeContinuation safeContinuation = new SafeContinuation(intercepted);
        s c16 = com.tencent.qqnt.e.c();
        if (c16 != null) {
            c16.C(setCapsuleSwitchReq, new b(safeContinuation));
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            safeContinuation.resumeWith(Result.m476constructorimpl(null));
        }
        Object orThrow = safeContinuation.getOrThrow();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (orThrow == coroutine_suspended) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return orThrow;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Hh(TroopPersonalSettingFragment this$0, int i3, boolean z16, Object obj) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (i3 == 26) {
            QLog.d("TroopPersonalSettingFragment", 2, "onGetMyTroopEffect result = " + z16);
            if (z16) {
                this$0.ii();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final AppInterface Ih() {
        return (AppInterface) this.app.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ITroopEnterEffectService Jh() {
        return (ITroopEnterEffectService) this.effectService.getValue();
    }

    private final ITroopEnterEffectService Kh() {
        return (ITroopEnterEffectService) this.enterEffectService.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final IChatSettingForTroopApi Lh() {
        return (IChatSettingForTroopApi) this.troopApi.getValue();
    }

    private final void Mh() {
        boolean z16;
        if (this.pageData == null) {
            initData();
        }
        Object businessHandler = Ih().getBusinessHandler(((ITroopHandlerNameApi) QRoute.api(ITroopHandlerNameApi.class)).getTroopLuckyCharacterHandlerName());
        Intrinsics.checkNotNull(businessHandler, "null cannot be cast to non-null type com.tencent.mobileqq.troop.luckycharacter.api.ITroopLuckyCharacterHandler");
        com.tencent.mobileqq.troop.luckycharacter.api.a aVar = (com.tencent.mobileqq.troop.luckycharacter.api.a) businessHandler;
        TroopPersonalSettingData troopPersonalSettingData = this.pageData;
        TroopPersonalSettingData troopPersonalSettingData2 = null;
        if (troopPersonalSettingData == null) {
            Intrinsics.throwUninitializedPropertyAccessException(ISchemeApi.KEY_PAGE_DATA);
            troopPersonalSettingData = null;
        }
        if (troopPersonalSettingData.e().length() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            TroopPersonalSettingData troopPersonalSettingData3 = this.pageData;
            if (troopPersonalSettingData3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(ISchemeApi.KEY_PAGE_DATA);
            } else {
                troopPersonalSettingData2 = troopPersonalSettingData3;
            }
            aVar.r0(troopPersonalSettingData2.e());
        }
    }

    private final void Nh() {
        if (this.viewCaches.get(4) != null) {
            IRuntimeService runtimeService = Ih().getRuntimeService(ITroopMemberInfoService.class, "");
            Intrinsics.checkNotNullExpressionValue(runtimeService, "app.getRuntimeService(IT\u2026va, ProcessConstant.MAIN)");
            ITroopMemberInfoService iTroopMemberInfoService = (ITroopMemberInfoService) runtimeService;
            TroopPersonalSettingData troopPersonalSettingData = this.pageData;
            if (troopPersonalSettingData == null) {
                Intrinsics.throwUninitializedPropertyAccessException(ISchemeApi.KEY_PAGE_DATA);
                troopPersonalSettingData = null;
            }
            iTroopMemberInfoService.getTroopMemberInfoAsync(troopPersonalSettingData.e(), Ih().getCurrentAccountUin(), "TroopPersonalSettingFragment", new ITroopMemberInfoService.a() { // from class: com.tencent.mobileqq.troop.troopsetting.modules.personalsetting.ui.a
                @Override // com.tencent.mobileqq.troop.api.ITroopMemberInfoService.a
                public final void a(TroopMemberInfo troopMemberInfo) {
                    TroopPersonalSettingFragment.Oh(TroopPersonalSettingFragment.this, troopMemberInfo);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Oh(TroopPersonalSettingFragment this$0, TroopMemberInfo troopMemberInfo) {
        String str;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (troopMemberInfo != null) {
            str = troopMemberInfo.troopColorNick;
        } else {
            str = null;
        }
        if (str != null) {
            String str2 = troopMemberInfo.troopColorNick;
            Intrinsics.checkNotNullExpressionValue(str2, "tmi.troopColorNick");
            this$0.qi(str2, troopMemberInfo.troopColorNickId);
        }
    }

    private final void Ph(FormItemRelativeLayout formItemRelativeLayout) {
        View findViewById = formItemRelativeLayout.findViewById(R.id.abv);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(com.tencent\u2026roop.api.R.id.bottomInfo)");
        ((TextView) findViewById).setVisibility(8);
    }

    private final void Qh() {
        TroopPersonalSettingData troopPersonalSettingData = this.pageData;
        LinearLayout linearLayout = null;
        if (troopPersonalSettingData == null) {
            Intrinsics.throwUninitializedPropertyAccessException(ISchemeApi.KEY_PAGE_DATA);
            troopPersonalSettingData = null;
        }
        if (troopPersonalSettingData.f()) {
            return;
        }
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
        FormItemRelativeLayout c16 = com.tencent.mobileqq.troop.troopsetting.activity.d.c(requireContext);
        String string = getString(R.string.f2342579g);
        Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.troop_identify_setting)");
        Rh(c16, 26, string, "", new Function0<Unit>() { // from class: com.tencent.mobileqq.troop.troopsetting.modules.personalsetting.ui.TroopPersonalSettingFragment$iniTroopIdentityItemUI$1$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopPersonalSettingFragment.this);
                }
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                AppInterface Ih;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                Context context = TroopPersonalSettingFragment.this.getContext();
                if (context == null) {
                    return;
                }
                QRouteApi api = QRoute.api(ITroopIdentityApi.class);
                Intrinsics.checkNotNullExpressionValue(api, "api(ITroopIdentityApi::class.java)");
                ITroopIdentityApi iTroopIdentityApi = (ITroopIdentityApi) api;
                TroopPersonalSettingData troopPersonalSettingData2 = TroopPersonalSettingFragment.this.pageData;
                if (troopPersonalSettingData2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException(ISchemeApi.KEY_PAGE_DATA);
                    troopPersonalSettingData2 = null;
                }
                String e16 = troopPersonalSettingData2.e();
                Ih = TroopPersonalSettingFragment.this.Ih();
                String currentAccountUin = Ih.getCurrentAccountUin();
                Intrinsics.checkNotNullExpressionValue(currentAccountUin, "app.currentAccountUin");
                ITroopIdentityApi.a.a(iTroopIdentityApi, context, e16, currentAccountUin, null, 8, null);
            }
        });
        LinearLayout linearLayout2 = this.containerView;
        if (linearLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("containerView");
        } else {
            linearLayout = linearLayout2;
        }
        linearLayout.addView(c16);
        com.tencent.mobileqq.troop.troopsetting.modules.personalsetting.utils.a.f301221a.f(c16);
    }

    private final void Rh(FormItemRelativeLayout formItemRelativeLayout, int i3, CharSequence charSequence, String str, final Function0<Unit> function0) {
        this.viewCaches.put(Integer.valueOf(i3), formItemRelativeLayout);
        if (function0 != null) {
            formItemRelativeLayout.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.troop.troopsetting.modules.personalsetting.ui.b
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    TroopPersonalSettingFragment.Sh(Function0.this, view);
                }
            });
            oi(formItemRelativeLayout, true);
        } else {
            formItemRelativeLayout.setOnClickListener(null);
            oi(formItemRelativeLayout, false);
        }
        pi(formItemRelativeLayout, charSequence);
        si(formItemRelativeLayout, str);
        Ph(formItemRelativeLayout);
        formItemRelativeLayout.setContentDescription(((Object) charSequence) + str);
        formItemRelativeLayout.getBackground().setAlpha(255);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Sh(Function0 function0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        function0.invoke();
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void Th() {
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
        FormItemRelativeLayout c16 = com.tencent.mobileqq.troop.troopsetting.activity.d.c(requireContext);
        String qqStr = HardCodeUtil.qqStr(R.string.khe);
        Intrinsics.checkNotNullExpressionValue(qqStr, "qqStr(R.string.qqstr_chatsett_c0d21f92)");
        Rh(c16, 1, qqStr, "", new Function0<Unit>() { // from class: com.tencent.mobileqq.troop.troopsetting.modules.personalsetting.ui.TroopPersonalSettingFragment$initChatBackgroundItemUI$1$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopPersonalSettingFragment.this);
                }
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                IChatSettingForTroopApi Lh;
                AppInterface Ih;
                AppInterface Ih2;
                AppInterface Ih3;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                Lh = TroopPersonalSettingFragment.this.Lh();
                FragmentActivity activity = TroopPersonalSettingFragment.this.getActivity();
                Ih = TroopPersonalSettingFragment.this.Ih();
                TroopPersonalSettingData troopPersonalSettingData = TroopPersonalSettingFragment.this.pageData;
                TroopPersonalSettingData troopPersonalSettingData2 = null;
                if (troopPersonalSettingData == null) {
                    Intrinsics.throwUninitializedPropertyAccessException(ISchemeApi.KEY_PAGE_DATA);
                    troopPersonalSettingData = null;
                }
                Lh.startChatBackgroundSettingActivity(activity, Ih, troopPersonalSettingData.e(), 6);
                j jVar = j.f301158a;
                Ih2 = TroopPersonalSettingFragment.this.Ih();
                jVar.b(Ih2, "CliOper", "", "", "0X8004E0E", "0X8004E0E", (r29 & 64) != 0 ? 0 : 0, (r29 & 128) != 0 ? 0 : 0, (r29 & 256) != 0 ? "" : null, (r29 & 512) != 0 ? "" : null, (r29 & 1024) != 0 ? "" : null, (r29 & 2048) != 0 ? "" : null);
                Ih3 = TroopPersonalSettingFragment.this.Ih();
                TroopPersonalSettingData troopPersonalSettingData3 = TroopPersonalSettingFragment.this.pageData;
                if (troopPersonalSettingData3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException(ISchemeApi.KEY_PAGE_DATA);
                    troopPersonalSettingData3 = null;
                }
                jVar.b(Ih3, "dc00899", "Grp_set", "", "Grp_data", "Set_chatBG", (r29 & 64) != 0 ? 0 : 0, (r29 & 128) != 0 ? 0 : 0, (r29 & 256) != 0 ? "" : troopPersonalSettingData3.e(), (r29 & 512) != 0 ? "" : null, (r29 & 1024) != 0 ? "" : null, (r29 & 2048) != 0 ? "" : null);
                String[] strArr = new String[2];
                TroopPersonalSettingData troopPersonalSettingData4 = TroopPersonalSettingFragment.this.pageData;
                if (troopPersonalSettingData4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException(ISchemeApi.KEY_PAGE_DATA);
                    troopPersonalSettingData4 = null;
                }
                strArr[0] = troopPersonalSettingData4.e();
                TroopPersonalSettingData troopPersonalSettingData5 = TroopPersonalSettingFragment.this.pageData;
                if (troopPersonalSettingData5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException(ISchemeApi.KEY_PAGE_DATA);
                } else {
                    troopPersonalSettingData2 = troopPersonalSettingData5;
                }
                strArr[1] = troopPersonalSettingData2.a();
                eu.g("Grp_set_new", "grpData_admin", "set_chatBG", 0, 0, strArr);
            }
        });
        LinearLayout linearLayout = this.containerView;
        TroopPersonalSettingData troopPersonalSettingData = null;
        if (linearLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("containerView");
            linearLayout = null;
        }
        linearLayout.addView(c16);
        com.tencent.mobileqq.troop.troopsetting.modules.personalsetting.utils.a.f301221a.a(c16);
        String[] strArr = new String[1];
        TroopPersonalSettingData troopPersonalSettingData2 = this.pageData;
        if (troopPersonalSettingData2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(ISchemeApi.KEY_PAGE_DATA);
        } else {
            troopPersonalSettingData = troopPersonalSettingData2;
        }
        strArr[0] = troopPersonalSettingData.e();
        eu.g("Grp_set_new", "grpData_admin", "chatBG_exp", 0, 0, strArr);
    }

    private final void Uh() {
        boolean isAllTroopShowEnterance = Kh().isAllTroopShowEnterance();
        QLog.d("TroopPersonalSettingFragment", 2, "refreshEnterEffectItem isAllTroopShowEntrance: " + isAllTroopShowEnterance);
        TroopPersonalSettingData troopPersonalSettingData = this.pageData;
        LinearLayout linearLayout = null;
        if (troopPersonalSettingData == null) {
            Intrinsics.throwUninitializedPropertyAccessException(ISchemeApi.KEY_PAGE_DATA);
            troopPersonalSettingData = null;
        }
        if (!troopPersonalSettingData.j() && isAllTroopShowEnterance) {
            Context requireContext = requireContext();
            Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
            FormItemRelativeLayout c16 = com.tencent.mobileqq.troop.troopsetting.activity.d.c(requireContext);
            String string = getString(R.string.i6b);
            Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.troop_enter_effect)");
            String qqStr = HardCodeUtil.qqStr(R.string.khf);
            Intrinsics.checkNotNullExpressionValue(qqStr, "qqStr(com.tencent.mobile\u2026.qqstr_chatsett_c7a8359c)");
            Rh(c16, 2, string, qqStr, new Function0<Unit>() { // from class: com.tencent.mobileqq.troop.troopsetting.modules.personalsetting.ui.TroopPersonalSettingFragment$initEnterEffectItemUI$1$1
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopPersonalSettingFragment.this);
                    }
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    ITroopEnterEffectService effectService;
                    IChatSettingForTroopApi Lh;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this);
                        return;
                    }
                    Context context = TroopPersonalSettingFragment.this.getContext();
                    effectService = TroopPersonalSettingFragment.this.Jh();
                    Intrinsics.checkNotNullExpressionValue(effectService, "effectService");
                    Lh = TroopPersonalSettingFragment.this.Lh();
                    TroopPersonalSettingData troopPersonalSettingData2 = TroopPersonalSettingFragment.this.pageData;
                    if (troopPersonalSettingData2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException(ISchemeApi.KEY_PAGE_DATA);
                        troopPersonalSettingData2 = null;
                    }
                    com.tencent.mobileqq.troop.troopsetting.modules.entereffect.a.a(context, effectService, Lh, troopPersonalSettingData2.e());
                }
            });
            LinearLayout linearLayout2 = this.containerView;
            if (linearLayout2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("containerView");
            } else {
                linearLayout = linearLayout2;
            }
            linearLayout.addView(c16);
            com.tencent.mobileqq.troop.troopsetting.modules.personalsetting.utils.a.f301221a.b(c16);
            ii();
        }
    }

    private final void Vh() {
        int i3;
        IRuntimeService runtimeService = Ih().getRuntimeService(ITroopHonorService.class, "");
        Intrinsics.checkNotNullExpressionValue(runtimeService, "app.getRuntimeService(IT\u2026va, ProcessConstant.MAIN)");
        ITroopHonorService iTroopHonorService = (ITroopHonorService) runtimeService;
        TroopPersonalSettingData troopPersonalSettingData = this.pageData;
        TroopPersonalSettingData troopPersonalSettingData2 = null;
        if (troopPersonalSettingData == null) {
            Intrinsics.throwUninitializedPropertyAccessException(ISchemeApi.KEY_PAGE_DATA);
            troopPersonalSettingData = null;
        }
        if (iTroopHonorService.isGrayTroopHonor(troopPersonalSettingData.e())) {
            TroopPersonalSettingData troopPersonalSettingData3 = this.pageData;
            if (troopPersonalSettingData3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(ISchemeApi.KEY_PAGE_DATA);
                troopPersonalSettingData3 = null;
            }
            if (troopPersonalSettingData3.f()) {
                Context requireContext = requireContext();
                Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
                FormItemRelativeLayout c16 = com.tencent.mobileqq.troop.troopsetting.activity.d.c(requireContext);
                TroopPersonalSettingData troopPersonalSettingData4 = this.pageData;
                if (troopPersonalSettingData4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException(ISchemeApi.KEY_PAGE_DATA);
                    troopPersonalSettingData4 = null;
                }
                if (troopPersonalSettingData4.f()) {
                    i3 = R.string.f20604579;
                } else {
                    i3 = R.string.j09;
                }
                String string = getString(R.string.j0a);
                Intrinsics.checkNotNullExpressionValue(string, "getString(com.tencent.mo\u2026ing.qq_troop_honor_title)");
                String string2 = getString(i3);
                Intrinsics.checkNotNullExpressionValue(string2, "getString(subTitleResID)");
                Rh(c16, 11, string, string2, new Function0<Unit>() { // from class: com.tencent.mobileqq.troop.troopsetting.modules.personalsetting.ui.TroopPersonalSettingFragment$initHonorEntryItemUI$1$1
                    static IPatchRedirector $redirector_;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(0);
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                            iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopPersonalSettingFragment.this);
                        }
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        AppInterface Ih;
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                            iPatchRedirector.redirect((short) 2, (Object) this);
                            return;
                        }
                        ITroopLinkApi iTroopLinkApi = (ITroopLinkApi) QRoute.api(ITroopLinkApi.class);
                        TroopPersonalSettingData troopPersonalSettingData5 = TroopPersonalSettingFragment.this.pageData;
                        TroopPersonalSettingData troopPersonalSettingData6 = null;
                        if (troopPersonalSettingData5 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException(ISchemeApi.KEY_PAGE_DATA);
                            troopPersonalSettingData5 = null;
                        }
                        String troopHonorUrl = iTroopLinkApi.getTroopHonorUrl(troopPersonalSettingData5.e(), 1);
                        ActivityURIRequest activityURIRequest = new ActivityURIRequest(TroopPersonalSettingFragment.this.getContext(), RouterConstants.UI_ROUTE_BROWSER);
                        activityURIRequest.extra().putString("url", troopHonorUrl);
                        QRoute.startUri(activityURIRequest, (o) null);
                        String[] strArr = new String[1];
                        TroopPersonalSettingData troopPersonalSettingData7 = TroopPersonalSettingFragment.this.pageData;
                        if (troopPersonalSettingData7 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException(ISchemeApi.KEY_PAGE_DATA);
                        } else {
                            troopPersonalSettingData6 = troopPersonalSettingData7;
                        }
                        strArr[0] = troopPersonalSettingData6.e();
                        eu.g("Grp_set_new", "grpData_admin", "grpHonour_click", 0, 0, strArr);
                        j jVar = j.f301158a;
                        Ih = TroopPersonalSettingFragment.this.Ih();
                        jVar.b(Ih, "dc00898", "", "", "0X800A6EF", "0X800A6EF", (r29 & 64) != 0 ? 0 : 0, (r29 & 128) != 0 ? 0 : 0, (r29 & 256) != 0 ? "" : null, (r29 & 512) != 0 ? "" : null, (r29 & 1024) != 0 ? "" : null, (r29 & 2048) != 0 ? "" : null);
                    }
                });
                LinearLayout linearLayout = this.containerView;
                if (linearLayout == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("containerView");
                    linearLayout = null;
                }
                linearLayout.addView(c16);
                com.tencent.mobileqq.troop.troopsetting.modules.personalsetting.utils.a.f301221a.e(c16);
                String[] strArr = new String[1];
                TroopPersonalSettingData troopPersonalSettingData5 = this.pageData;
                if (troopPersonalSettingData5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException(ISchemeApi.KEY_PAGE_DATA);
                } else {
                    troopPersonalSettingData2 = troopPersonalSettingData5;
                }
                strArr[0] = troopPersonalSettingData2.e();
                eu.g("Grp_set_new", "grpData_admin", "grpHonour_exp", 0, 0, strArr);
                j.f301158a.b(Ih(), "dc00898", "", "", "0X800A6EE", "0X800A6EE", (r29 & 64) != 0 ? 0 : 0, (r29 & 128) != 0 ? 0 : 0, (r29 & 256) != 0 ? "" : null, (r29 & 512) != 0 ? "" : null, (r29 & 1024) != 0 ? "" : null, (r29 & 2048) != 0 ? "" : null);
            }
        }
    }

    private final void Wh() {
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
        FormItemRelativeLayout c16 = com.tencent.mobileqq.troop.troopsetting.activity.d.c(requireContext);
        String string = getString(R.string.f2060857c);
        Intrinsics.checkNotNullExpressionValue(string, "getString(com.tencent.mo\u2026qq_troop_lucky_character)");
        Rh(c16, 12, string, "", new Function0<Unit>() { // from class: com.tencent.mobileqq.troop.troopsetting.modules.personalsetting.ui.TroopPersonalSettingFragment$initLuckyCharacterItemUI$1$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopPersonalSettingFragment.this);
                }
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                Context context = TroopPersonalSettingFragment.this.getContext();
                TroopPersonalSettingData troopPersonalSettingData = TroopPersonalSettingFragment.this.pageData;
                TroopPersonalSettingData troopPersonalSettingData2 = null;
                if (troopPersonalSettingData == null) {
                    Intrinsics.throwUninitializedPropertyAccessException(ISchemeApi.KEY_PAGE_DATA);
                    troopPersonalSettingData = null;
                }
                com.tencent.mobileqq.troop.troopsetting.modules.luckycharacter.a.a(context, troopPersonalSettingData.e());
                String[] strArr = new String[1];
                TroopPersonalSettingData troopPersonalSettingData3 = TroopPersonalSettingFragment.this.pageData;
                if (troopPersonalSettingData3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException(ISchemeApi.KEY_PAGE_DATA);
                } else {
                    troopPersonalSettingData2 = troopPersonalSettingData3;
                }
                strArr[0] = troopPersonalSettingData2.e();
                eu.g("Grp_set_new", "grpData_admin", "Luckyword_entry_clk", 0, 0, strArr);
            }
        });
        LinearLayout linearLayout = this.containerView;
        if (linearLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("containerView");
            linearLayout = null;
        }
        linearLayout.addView(c16);
        com.tencent.mobileqq.troop.troopsetting.modules.personalsetting.utils.a.f301221a.c(c16);
        ji();
    }

    private final void Xh() {
        TroopPersonalSettingData troopPersonalSettingData = this.pageData;
        LinearLayout linearLayout = null;
        if (troopPersonalSettingData == null) {
            Intrinsics.throwUninitializedPropertyAccessException(ISchemeApi.KEY_PAGE_DATA);
            troopPersonalSettingData = null;
        }
        if (troopPersonalSettingData.f()) {
            return;
        }
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
        FormItemRelativeLayout c16 = com.tencent.mobileqq.troop.troopsetting.activity.d.c(requireContext);
        String string = getString(R.string.f235107ar);
        Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.troop_nickname_decoration_item)");
        String qqStr = HardCodeUtil.qqStr(R.string.khf);
        Intrinsics.checkNotNullExpressionValue(qqStr, "qqStr(com.tencent.mobile\u2026.qqstr_chatsett_c7a8359c)");
        Rh(c16, 4, string, qqStr, new Function0<Unit>() { // from class: com.tencent.mobileqq.troop.troopsetting.modules.personalsetting.ui.TroopPersonalSettingFragment$initNicknameDecorationItemUI$1$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopPersonalSettingFragment.this);
                }
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                IChatSettingForTroopApi Lh;
                AppInterface Ih;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                TroopPersonalSettingData troopPersonalSettingData2 = TroopPersonalSettingFragment.this.pageData;
                TroopPersonalSettingData troopPersonalSettingData3 = null;
                if (troopPersonalSettingData2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException(ISchemeApi.KEY_PAGE_DATA);
                    troopPersonalSettingData2 = null;
                }
                String e16 = troopPersonalSettingData2.e();
                TroopPersonalSettingData troopPersonalSettingData4 = TroopPersonalSettingFragment.this.pageData;
                if (troopPersonalSettingData4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException(ISchemeApi.KEY_PAGE_DATA);
                    troopPersonalSettingData4 = null;
                }
                boolean f16 = troopPersonalSettingData4.f();
                TroopPersonalSettingData troopPersonalSettingData5 = TroopPersonalSettingFragment.this.pageData;
                if (troopPersonalSettingData5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException(ISchemeApi.KEY_PAGE_DATA);
                    troopPersonalSettingData5 = null;
                }
                String b16 = troopPersonalSettingData5.b();
                TroopPersonalSettingData troopPersonalSettingData6 = TroopPersonalSettingFragment.this.pageData;
                if (troopPersonalSettingData6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException(ISchemeApi.KEY_PAGE_DATA);
                    troopPersonalSettingData6 = null;
                }
                int c17 = troopPersonalSettingData6.c();
                TroopPersonalSettingData troopPersonalSettingData7 = TroopPersonalSettingFragment.this.pageData;
                if (troopPersonalSettingData7 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException(ISchemeApi.KEY_PAGE_DATA);
                } else {
                    troopPersonalSettingData3 = troopPersonalSettingData7;
                }
                k kVar = new k(e16, f16, b16, c17, troopPersonalSettingData3.a());
                Lh = TroopPersonalSettingFragment.this.Lh();
                FragmentActivity activity = TroopPersonalSettingFragment.this.getActivity();
                Ih = TroopPersonalSettingFragment.this.Ih();
                Lh.startTroopMemberCard(activity, Ih, kVar, 2);
            }
        });
        com.tencent.mobileqq.troop.troopsetting.activity.d.f(c16);
        LinearLayout linearLayout2 = this.containerView;
        if (linearLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("containerView");
        } else {
            linearLayout = linearLayout2;
        }
        linearLayout.addView(c16);
        com.tencent.mobileqq.troop.troopsetting.modules.personalsetting.utils.a.f301221a.h(c16);
        ki();
    }

    private final void Yh() {
        Ih().addObserver(this.enterEffectObserver);
        Ih().addObserver(this.troopLuckyCharacterObserver);
    }

    private final void Zh(View v3, boolean isChecked) {
        HashMap hashMapOf;
        VideoReport.setElementId(v3, "em_group_app_capsule_show");
        VideoReport.setElementExposePolicy(v3, ExposurePolicy.REPORT_ALL);
        VideoReport.setElementClickPolicy(v3, ClickPolicy.REPORT_NONE);
        hashMapOf = MapsKt__MapsKt.hashMapOf(TuplesKt.to("after_click_state", Integer.valueOf(ni(isChecked))));
        VideoReport.setElementParams(v3, hashMapOf);
    }

    private final void ai() {
        Long longOrNull;
        final long j3;
        Long longOrNull2;
        TroopPersonalSettingData troopPersonalSettingData = this.pageData;
        LinearLayout linearLayout = null;
        if (troopPersonalSettingData == null) {
            Intrinsics.throwUninitializedPropertyAccessException(ISchemeApi.KEY_PAGE_DATA);
            troopPersonalSettingData = null;
        }
        longOrNull = StringsKt__StringNumberConversionsKt.toLongOrNull(troopPersonalSettingData.e());
        long j16 = 0;
        if (longOrNull != null) {
            j3 = longOrNull.longValue();
        } else {
            j3 = 0;
        }
        if (gi(j3)) {
            QLog.d("TroopPersonalSettingFragment", 1, "initShortCutItemUI disallowed:" + j3);
            return;
        }
        TroopShortcutSettingCache a16 = TroopShortcutSettingCache.INSTANCE.a();
        TroopPersonalSettingData troopPersonalSettingData2 = this.pageData;
        if (troopPersonalSettingData2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(ISchemeApi.KEY_PAGE_DATA);
            troopPersonalSettingData2 = null;
        }
        longOrNull2 = StringsKt__StringNumberConversionsKt.toLongOrNull(troopPersonalSettingData2.e());
        if (longOrNull2 != null) {
            j16 = longOrNull2.longValue();
        }
        if (a16.f(j16)) {
            return;
        }
        QLog.d("TroopPersonalSettingFragment", 1, "initShortCutItemUI show:" + j3);
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
        final FormItemRelativeLayout e16 = com.tencent.mobileqq.troop.troopsetting.activity.d.e(requireContext);
        boolean fi5 = fi(j3);
        String string = getString(R.string.f235677ca);
        Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.troop_show_shortcut)");
        di(e16, 31, string, !fi5, new Function1<Boolean, Unit>(j3, this, e16) { // from class: com.tencent.mobileqq.troop.troopsetting.modules.personalsetting.ui.TroopPersonalSettingFragment$initShortCutItemUI$1$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ FormItemRelativeLayout $shortcutItem;
            final /* synthetic */ long $troopUin;
            final /* synthetic */ TroopPersonalSettingFragment this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
            @DebugMetadata(c = "com.tencent.mobileqq.troop.troopsetting.modules.personalsetting.ui.TroopPersonalSettingFragment$initShortCutItemUI$1$1$1", f = "TroopPersonalSettingFragment.kt", i = {}, l = {629}, m = "invokeSuspend", n = {}, s = {})
            /* renamed from: com.tencent.mobileqq.troop.troopsetting.modules.personalsetting.ui.TroopPersonalSettingFragment$initShortCutItemUI$1$1$1, reason: invalid class name */
            /* loaded from: classes19.dex */
            public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                static IPatchRedirector $redirector_;
                final /* synthetic */ boolean $isChecked;
                final /* synthetic */ FormItemRelativeLayout $shortcutItem;
                final /* synthetic */ long $troopUin;
                int label;
                final /* synthetic */ TroopPersonalSettingFragment this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                AnonymousClass1(long j3, boolean z16, TroopPersonalSettingFragment troopPersonalSettingFragment, FormItemRelativeLayout formItemRelativeLayout, Continuation<? super AnonymousClass1> continuation) {
                    super(2, continuation);
                    this.$troopUin = j3;
                    this.$isChecked = z16;
                    this.this$0 = troopPersonalSettingFragment;
                    this.$shortcutItem = formItemRelativeLayout;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, this, Long.valueOf(j3), Boolean.valueOf(z16), troopPersonalSettingFragment, formItemRelativeLayout, continuation);
                    }
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                @NotNull
                public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                        return (Continuation) iPatchRedirector.redirect((short) 3, (Object) this, obj, (Object) continuation);
                    }
                    return new AnonymousClass1(this.$troopUin, this.$isChecked, this.this$0, this.$shortcutItem, continuation);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                @Nullable
                public final Object invokeSuspend(@NotNull Object obj) {
                    Object coroutine_suspended;
                    long j3;
                    Object Gh;
                    int ni5;
                    HashMap hashMapOf;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        int i3 = this.label;
                        if (i3 != 0) {
                            if (i3 == 1) {
                                ResultKt.throwOnFailure(obj);
                            } else {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                        } else {
                            ResultKt.throwOnFailure(obj);
                            TroopShortcutSettingCache.Companion companion = TroopShortcutSettingCache.INSTANCE;
                            companion.a().h(this.$troopUin, !this.$isChecked);
                            companion.a().g(this.$troopUin);
                            TroopPersonalSettingFragment troopPersonalSettingFragment = this.this$0;
                            if (this.$isChecked) {
                                j3 = 1;
                            } else {
                                j3 = 0;
                            }
                            this.label = 1;
                            Gh = troopPersonalSettingFragment.Gh(j3, this);
                            if (Gh == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                        }
                        FormItemRelativeLayout formItemRelativeLayout = this.$shortcutItem;
                        ni5 = this.this$0.ni(true ^ this.$isChecked);
                        hashMapOf = MapsKt__MapsKt.hashMapOf(TuplesKt.to("after_click_state", Boxing.boxInt(ni5)));
                        VideoReport.reportEvent("dt_clck", formItemRelativeLayout, hashMapOf);
                        return Unit.INSTANCE;
                    }
                    return iPatchRedirector.redirect((short) 2, (Object) this, obj);
                }

                @Override // kotlin.jvm.functions.Function2
                @Nullable
                public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) ? ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE) : iPatchRedirector.redirect((short) 4, (Object) this, (Object) coroutineScope, (Object) continuation);
                }
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.$troopUin = j3;
                this.this$0 = this;
                this.$shortcutItem = e16;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, Long.valueOf(j3), this, e16);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z16) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                    BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new AnonymousClass1(this.$troopUin, z16, this.this$0, this.$shortcutItem, null), 3, null);
                } else {
                    iPatchRedirector.redirect((short) 2, (Object) this, z16);
                }
            }
        });
        LinearLayout linearLayout2 = this.containerView;
        if (linearLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("containerView");
        } else {
            linearLayout = linearLayout2;
        }
        linearLayout.addView(e16);
        Zh(e16, !fi5);
    }

    private final void bi() {
        if (!((IStudyModeManager) QRoute.api(IStudyModeManager.class)).getStudyModeSwitch() && Lh().keyWordIsEnable()) {
            String string = getString(R.string.vvt);
            Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.qq_troop_keyword_setting)");
            SpannableString spannableString = new SpannableString(string + " \u5360\u4f4d\u7b26");
            int length = spannableString.length();
            LinearLayout linearLayout = null;
            Drawable drawable = ResourcesCompat.getDrawable(getResources(), R.drawable.num, null);
            if (drawable != null) {
                drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
                spannableString.setSpan(new ImageSpan(drawable, 1), length - 3, length, 34);
            }
            Context requireContext = requireContext();
            Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
            final FormItemRelativeLayout c16 = com.tencent.mobileqq.troop.troopsetting.activity.d.c(requireContext);
            String qqStr = HardCodeUtil.qqStr(R.string.khf);
            Intrinsics.checkNotNullExpressionValue(qqStr, "qqStr(com.tencent.mobile\u2026.qqstr_chatsett_c7a8359c)");
            Rh(c16, 3, spannableString, qqStr, new Function0<Unit>(this) { // from class: com.tencent.mobileqq.troop.troopsetting.modules.personalsetting.ui.TroopPersonalSettingFragment$initTroopKeywordItemUI$2$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ TroopPersonalSettingFragment this$0;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    this.this$0 = this;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) FormItemRelativeLayout.this, (Object) this);
                    }
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    IChatSettingForTroopApi Lh;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this);
                        return;
                    }
                    Object tag = FormItemRelativeLayout.this.getTag(R.id.f166671d25);
                    TroopPersonalSettingData troopPersonalSettingData = null;
                    com.tencent.mobileqq.troop.a aVar = tag instanceof com.tencent.mobileqq.troop.a ? (com.tencent.mobileqq.troop.a) tag : null;
                    Context context = this.this$0.getContext();
                    Lh = this.this$0.Lh();
                    TroopPersonalSettingData troopPersonalSettingData2 = this.this$0.pageData;
                    if (troopPersonalSettingData2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException(ISchemeApi.KEY_PAGE_DATA);
                    } else {
                        troopPersonalSettingData = troopPersonalSettingData2;
                    }
                    com.tencent.mobileqq.troop.troopsetting.modules.keyword.a.a(context, Lh, aVar, troopPersonalSettingData.e());
                }
            });
            c16.setContentDescription(string + " " + HardCodeUtil.qqStr(R.string.f2060757b) + HardCodeUtil.qqStr(R.string.f212075mj));
            LinearLayout linearLayout2 = this.containerView;
            if (linearLayout2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("containerView");
            } else {
                linearLayout = linearLayout2;
            }
            linearLayout.addView(c16);
            com.tencent.mobileqq.troop.troopsetting.modules.personalsetting.utils.a.f301221a.g(c16);
        }
    }

    private final void ci() {
        View findViewById = ((QIphoneTitleBarFragment) this).mContentView.findViewById(R.id.b8q);
        Intrinsics.checkNotNullExpressionValue(findViewById, "mContentView.findViewById(R.id.container)");
        LinearLayout linearLayout = (LinearLayout) findViewById;
        this.containerView = linearLayout;
        com.tencent.mobileqq.troop.troopsetting.activity.d dVar = com.tencent.mobileqq.troop.troopsetting.activity.d.f301060a;
        if (linearLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("containerView");
            linearLayout = null;
        }
        com.tencent.mobileqq.troop.troopsetting.activity.d.b(dVar, linearLayout, 0.0f, 1, null);
        Ch();
        LinearLayout linearLayout2 = this.containerView;
        if (linearLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("containerView");
            linearLayout2 = null;
        }
        com.tencent.mobileqq.troop.troopsetting.activity.d.b(dVar, linearLayout2, 0.0f, 1, null);
        Dh();
        LinearLayout linearLayout3 = this.containerView;
        if (linearLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("containerView");
            linearLayout3 = null;
        }
        com.tencent.mobileqq.troop.troopsetting.activity.d.b(dVar, linearLayout3, 0.0f, 1, null);
        Eh();
    }

    private final void di(FormItemRelativeLayout formItemRelativeLayout, int i3, CharSequence charSequence, boolean z16, final Function1<? super Boolean, Unit> function1) {
        this.viewCaches.put(Integer.valueOf(i3), formItemRelativeLayout);
        View findViewById = formItemRelativeLayout.findViewById(R.id.j9_);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.switch_icon)");
        Switch r36 = (Switch) findViewById;
        r36.setChecked(z16);
        if (function1 != null) {
            r36.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.tencent.mobileqq.troop.troopsetting.modules.personalsetting.ui.e
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public final void onCheckedChanged(CompoundButton compoundButton, boolean z17) {
                    TroopPersonalSettingFragment.ei(Function1.this, compoundButton, z17);
                }
            });
        } else {
            r36.setOnCheckedChangeListener(null);
        }
        pi(formItemRelativeLayout, charSequence);
        Ph(formItemRelativeLayout);
        formItemRelativeLayout.setContentDescription(charSequence.toString());
        formItemRelativeLayout.getBackground().setAlpha(255);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ei(Function1 function1, CompoundButton compoundButton, boolean z16) {
        EventCollector.getInstance().onCompoundButtonCheckedBefore(compoundButton, z16);
        function1.invoke(Boolean.valueOf(z16));
        EventCollector.getInstance().onCompoundButtonChecked(compoundButton, z16);
    }

    private final boolean fi(long troopUin) {
        boolean d16 = TroopShortcutSettingCache.INSTANCE.a().d(troopUin);
        hi("getDisableCapsuleValue", Boolean.valueOf(d16));
        return d16;
    }

    private final boolean gi(long troopUin) {
        boolean e16 = TroopShortcutSettingCache.INSTANCE.a().e(troopUin);
        hi("getDisableCapsuleSwitchValue", Boolean.valueOf(e16));
        return e16;
    }

    private final void hi(String tag, Boolean value) {
        QLog.i("TroopPersonalSettingFragment", 1, tag + "() Value: " + value);
    }

    private final void ii() {
        QLog.d("TroopPersonalSettingFragment", 2, "refreshEnterEffectItem");
        FormItemRelativeLayout formItemRelativeLayout = this.viewCaches.get(2);
        if (formItemRelativeLayout == null) {
            return;
        }
        boolean z16 = true;
        String[] strArr = new String[1];
        TroopPersonalSettingData troopPersonalSettingData = this.pageData;
        TroopPersonalSettingData troopPersonalSettingData2 = null;
        if (troopPersonalSettingData == null) {
            Intrinsics.throwUninitializedPropertyAccessException(ISchemeApi.KEY_PAGE_DATA);
            troopPersonalSettingData = null;
        }
        strArr[0] = troopPersonalSettingData.e();
        eu.g("Grp_set_new", "grpData_admin", "specialEntrance_exp", 0, 0, strArr);
        e.b allEffectInfo = Kh().getAllEffectInfo();
        if (allEffectInfo != null) {
            ITroopEnterEffectService Kh = Kh();
            TroopPersonalSettingData troopPersonalSettingData3 = this.pageData;
            if (troopPersonalSettingData3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(ISchemeApi.KEY_PAGE_DATA);
            } else {
                troopPersonalSettingData2 = troopPersonalSettingData3;
            }
            e.c effectInfo = Kh.getEffectInfo(troopPersonalSettingData2.e());
            if (effectInfo != null && effectInfo.f295237b > 0) {
                String str = effectInfo.f295238c;
                Intrinsics.checkNotNullExpressionValue(str, "infoData.effectName");
                si(formItemRelativeLayout, str);
                String str2 = effectInfo.f295238c;
                Intrinsics.checkNotNullExpressionValue(str2, "infoData.effectName");
                if (str2.length() <= 0) {
                    z16 = false;
                }
                if (z16) {
                    formItemRelativeLayout.setContentDescription(getString(R.string.i6b) + effectInfo.f295238c);
                    return;
                }
                return;
            }
            if (allEffectInfo.f295233b > 0) {
                String str3 = allEffectInfo.f295234c;
                Intrinsics.checkNotNullExpressionValue(str3, "effectInfo.mGlobalEffectName");
                si(formItemRelativeLayout, str3);
                String str4 = allEffectInfo.f295234c;
                Intrinsics.checkNotNullExpressionValue(str4, "effectInfo.mGlobalEffectName");
                if (str4.length() <= 0) {
                    z16 = false;
                }
                if (z16) {
                    formItemRelativeLayout.setContentDescription(getString(R.string.i6b) + allEffectInfo.f295234c);
                    return;
                }
                return;
            }
            String qqStr = HardCodeUtil.qqStr(R.string.kh8);
            Intrinsics.checkNotNullExpressionValue(qqStr, "qqStr(com.tencent.mobile\u2026.qqstr_chatsett_a9639e9d)");
            si(formItemRelativeLayout, qqStr);
            formItemRelativeLayout.setContentDescription(getString(R.string.i6b) + HardCodeUtil.qqStr(R.string.kh8));
            return;
        }
        String qqStr2 = HardCodeUtil.qqStr(R.string.khf);
        Intrinsics.checkNotNullExpressionValue(qqStr2, "qqStr(com.tencent.mobile\u2026.qqstr_chatsett_c7a8359c)");
        si(formItemRelativeLayout, qqStr2);
        formItemRelativeLayout.setContentDescription(getString(R.string.i6b) + HardCodeUtil.qqStr(R.string.kh8));
    }

    private final void initData() {
        TroopPersonalSettingData troopPersonalSettingData;
        Bundle arguments = getArguments();
        TroopPersonalSettingData troopPersonalSettingData2 = null;
        if (arguments != null) {
            troopPersonalSettingData = (TroopPersonalSettingData) arguments.getParcelable("bundle_key_page_data");
        } else {
            troopPersonalSettingData = null;
        }
        if (troopPersonalSettingData instanceof TroopPersonalSettingData) {
            troopPersonalSettingData2 = troopPersonalSettingData;
        }
        if (troopPersonalSettingData2 == null) {
            QLog.e("TroopPersonalSettingFragment", 1, "invalid setting data is null.");
            FragmentActivity activity = getActivity();
            if (activity != null) {
                activity.finish();
                return;
            }
            return;
        }
        this.pageData = troopPersonalSettingData2;
    }

    private final void initNavBar() {
        setTitle(getString(R.string.f235317bb));
    }

    private final void ji() {
        long j3;
        String str;
        FormItemRelativeLayout formItemRelativeLayout = this.viewCaches.get(12);
        if (formItemRelativeLayout == null) {
            return;
        }
        boolean z16 = true;
        String[] strArr = new String[1];
        TroopPersonalSettingData troopPersonalSettingData = this.pageData;
        TroopPersonalSettingData troopPersonalSettingData2 = null;
        if (troopPersonalSettingData == null) {
            Intrinsics.throwUninitializedPropertyAccessException(ISchemeApi.KEY_PAGE_DATA);
            troopPersonalSettingData = null;
        }
        strArr[0] = troopPersonalSettingData.e();
        eu.g("Grp_set_new", "grpData_admin", "Luckyword_entry_exp", 0, 0, strArr);
        TroopPersonalSettingData troopPersonalSettingData3 = this.pageData;
        if (troopPersonalSettingData3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(ISchemeApi.KEY_PAGE_DATA);
            troopPersonalSettingData3 = null;
        }
        if (!troopPersonalSettingData3.g()) {
            String string = getResources().getString(R.string.f180723bu);
            Intrinsics.checkNotNullExpressionValue(string, "resources.getString(com.\u2026op_lucky_character_close)");
            si(formItemRelativeLayout, string);
            return;
        }
        ITroopSPUtilApi iTroopSPUtilApi = (ITroopSPUtilApi) QRoute.api(ITroopSPUtilApi.class);
        String currentAccountUin = Ih().getCurrentAccountUin();
        TroopPersonalSettingData troopPersonalSettingData4 = this.pageData;
        if (troopPersonalSettingData4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(ISchemeApi.KEY_PAGE_DATA);
            troopPersonalSettingData4 = null;
        }
        Object[] keyTroopLuckyCharacterStatus = iTroopSPUtilApi.getKeyTroopLuckyCharacterStatus(currentAccountUin, troopPersonalSettingData4.e(), getString(R.string.f180733bv));
        if (keyTroopLuckyCharacterStatus != null && keyTroopLuckyCharacterStatus.length == 2) {
            Object obj = keyTroopLuckyCharacterStatus[0];
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Long");
            j3 = ((Long) obj).longValue();
            Object obj2 = keyTroopLuckyCharacterStatus[1];
            Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.String");
            str = (String) obj2;
        } else {
            j3 = 0;
            str = "";
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.set(11, 0);
        calendar.set(12, 0);
        calendar.set(13, 0);
        Object businessHandler = Ih().getBusinessHandler(((ITroopHandlerNameApi) QRoute.api(ITroopHandlerNameApi.class)).getTroopLuckyCharacterHandlerName());
        Intrinsics.checkNotNull(businessHandler, "null cannot be cast to non-null type com.tencent.mobileqq.troop.luckycharacter.api.ITroopLuckyCharacterHandler");
        com.tencent.mobileqq.troop.luckycharacter.api.a aVar = (com.tencent.mobileqq.troop.luckycharacter.api.a) businessHandler;
        if (str.length() <= 0) {
            z16 = false;
        }
        if (z16) {
            TroopPersonalSettingData troopPersonalSettingData5 = this.pageData;
            if (troopPersonalSettingData5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(ISchemeApi.KEY_PAGE_DATA);
            } else {
                troopPersonalSettingData2 = troopPersonalSettingData5;
            }
            aVar.r0(troopPersonalSettingData2.e());
            return;
        }
        if (j3 > calendar.getTimeInMillis()) {
            si(formItemRelativeLayout, "");
            return;
        }
        TroopPersonalSettingData troopPersonalSettingData6 = this.pageData;
        if (troopPersonalSettingData6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(ISchemeApi.KEY_PAGE_DATA);
        } else {
            troopPersonalSettingData2 = troopPersonalSettingData6;
        }
        aVar.r0(troopPersonalSettingData2.e());
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0036, code lost:
    
        if (r6 == true) goto L17;
     */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0115  */
    /* JADX WARN: Removed duplicated region for block: B:38:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void ki() {
        boolean z16;
        float measureText;
        int i3;
        com.tencent.qqnt.aio.nick.c customCloth;
        boolean z17;
        FormItemRelativeLayout formItemRelativeLayout = this.viewCaches.get(4);
        if (formItemRelativeLayout == null) {
            return;
        }
        TextView it = (TextView) formItemRelativeLayout.findViewById(R.id.i_f);
        TroopPersonalSettingData troopPersonalSettingData = this.pageData;
        TroopPersonalSettingData troopPersonalSettingData2 = null;
        if (troopPersonalSettingData == null) {
            Intrinsics.throwUninitializedPropertyAccessException(ISchemeApi.KEY_PAGE_DATA);
            troopPersonalSettingData = null;
        }
        String b16 = troopPersonalSettingData.b();
        if (b16 != null) {
            z16 = true;
            if (b16.length() > 0) {
                z17 = true;
            } else {
                z17 = false;
            }
        }
        z16 = false;
        if (z16) {
            TroopPersonalSettingData troopPersonalSettingData3 = this.pageData;
            if (troopPersonalSettingData3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(ISchemeApi.KEY_PAGE_DATA);
            } else {
                troopPersonalSettingData2 = troopPersonalSettingData3;
            }
            int c16 = troopPersonalSettingData2.c();
            if (QLog.isColorLevel()) {
                QLog.i("TroopPersonalSettingFragment", 2, "refreshNickNameDecorationItem nickName = " + b16 + ", nickId = " + c16);
            }
            if (Q) {
                CharSequence emotionNickName = ((INickNameApi) QRoute.api(INickNameApi.class)).getEmotionNickName(b16, 16);
                it.setText(emotionNickName);
                formItemRelativeLayout.setContentDescription(getString(R.string.f235107ar) + ((Object) emotionNickName));
                if (c16 <= 0) {
                    Intrinsics.checkNotNullExpressionValue(it, "it");
                    mi(it);
                    return;
                }
                if (emotionNickName instanceof QQText) {
                    QQText qQText = (QQText) emotionNickName;
                    if (qQText.mSpanCount == 0) {
                        i3 = 0;
                    } else {
                        i3 = com.tencent.mobileqq.troop.troopsetting.activity.d.f301060a.g();
                    }
                    TextPaint paint = it.getPaint();
                    Intrinsics.checkNotNullExpressionValue(paint, "it.paint");
                    measureText = com.tencent.mobileqq.troop.troopsetting.modules.nickname.a.a(qQText, paint);
                    Rect rect = new Rect();
                    it.getPaint().getTextBounds(b16, 0, b16.length(), rect);
                    customCloth = ((ITroopNickManager) QRoute.api(ITroopNickManager.class)).setCustomCloth(c16, new i(measureText, rect), ViewUtils.dip2px(150.0f));
                    if (customCloth == null) {
                        it.setBackground(customCloth.e());
                        it.setPadding(customCloth.f(), 0, customCloth.f(), 0);
                        ViewGroup.LayoutParams layoutParams = it.getLayoutParams();
                        Intrinsics.checkNotNullExpressionValue(layoutParams, "it.layoutParams");
                        layoutParams.width = customCloth.h();
                        layoutParams.height = customCloth.g() + i3;
                        it.setLayoutParams(layoutParams);
                        return;
                    }
                    return;
                }
                measureText = it.getPaint().measureText(b16);
            } else {
                it.setText(b16);
                if (c16 <= 0) {
                    Intrinsics.checkNotNullExpressionValue(it, "it");
                    mi(it);
                    return;
                }
                measureText = it.getPaint().measureText(b16);
            }
            i3 = 0;
            Rect rect2 = new Rect();
            it.getPaint().getTextBounds(b16, 0, b16.length(), rect2);
            customCloth = ((ITroopNickManager) QRoute.api(ITroopNickManager.class)).setCustomCloth(c16, new i(measureText, rect2), ViewUtils.dip2px(150.0f));
            if (customCloth == null) {
            }
        } else {
            it.setText(getString(R.string.eqt));
            Intrinsics.checkNotNullExpressionValue(it, "it");
            mi(it);
            formItemRelativeLayout.setContentDescription(getString(R.string.f235107ar) + getString(R.string.eqt));
        }
    }

    private final void li() {
        Ih().removeObserver(this.enterEffectObserver);
        Ih().removeObserver(this.troopLuckyCharacterObserver);
    }

    private final void mi(TextView textView) {
        textView.setBackground(null);
        textView.setPadding(0, 0, 0, 0);
        ViewGroup.LayoutParams layoutParams = textView.getLayoutParams();
        layoutParams.width = -2;
        layoutParams.height = -2;
        Intrinsics.checkNotNullExpressionValue(layoutParams, "layoutParams.also {\n    \u2026ms.WRAP_CONTENT\n        }");
        textView.setLayoutParams(layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int ni(boolean isChecked) {
        Integer num = (Integer) au.b(Boolean.valueOf(isChecked), TroopPersonalSettingFragment$shortCutItemUIState$1.INSTANCE);
        if (num != null) {
            return num.intValue();
        }
        return 1;
    }

    private final void oi(FormItemRelativeLayout formItemRelativeLayout, boolean z16) {
        int i3;
        View findViewById = formItemRelativeLayout.findViewById(R.id.f164472yw);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.arrow)");
        ImageView imageView = (ImageView) findViewById;
        if (z16) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        imageView.setVisibility(i3);
    }

    private final void pi(FormItemRelativeLayout formItemRelativeLayout, CharSequence charSequence) {
        View findViewById = formItemRelativeLayout.findViewById(R.id.title);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.title)");
        TextView textView = (TextView) findViewById;
        textView.setText(charSequence);
        textView.setTextColor(ResourcesCompat.getColorStateList(formItemRelativeLayout.getResources(), R.color.qui_common_text_primary, null));
        formItemRelativeLayout.setContentDescription(charSequence);
    }

    private final void qi(final String nickName, final int nickId) {
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.troop.troopsetting.modules.personalsetting.ui.d
            @Override // java.lang.Runnable
            public final void run() {
                TroopPersonalSettingFragment.ri(TroopPersonalSettingFragment.this, nickName, nickId);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ri(TroopPersonalSettingFragment this$0, String nickName, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(nickName, "$nickName");
        TroopPersonalSettingData troopPersonalSettingData = this$0.pageData;
        if (troopPersonalSettingData == null) {
            Intrinsics.throwUninitializedPropertyAccessException(ISchemeApi.KEY_PAGE_DATA);
            troopPersonalSettingData = null;
        }
        troopPersonalSettingData.k(nickName, i3);
        this$0.ki();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void si(FormItemRelativeLayout formItemRelativeLayout, String str) {
        boolean z16;
        View findViewById = formItemRelativeLayout.findViewById(R.id.i_f);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.rightInfo)");
        TextView textView = (TextView) findViewById;
        if (str.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            textView.setText("");
            return;
        }
        textView.setCompoundDrawablePadding(ViewUtils.dpToPx(9.0f));
        textView.setEditableFactory(QQTextBuilder.EMOCTATION_FACORY);
        textView.setText(new QQText(str, 3));
        textView.setTextColor(ResourcesCompat.getColorStateList(formItemRelativeLayout.getResources(), R.color.qui_common_text_secondary, null));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.fragment.QIphoneTitleBarFragment
    public void doOnCreateView(@Nullable LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, inflater, container, savedInstanceState);
            return;
        }
        super.doOnCreateView(inflater, container, savedInstanceState);
        initData();
        initNavBar();
        ci();
        Yh();
        com.tencent.mobileqq.troop.troopsetting.modules.personalsetting.utils.a aVar = com.tencent.mobileqq.troop.troopsetting.modules.personalsetting.utils.a.f301221a;
        QBaseActivity qBaseActivity = getQBaseActivity();
        Intrinsics.checkNotNullExpressionValue(qBaseActivity, "qBaseActivity");
        LinearLayout linearLayout = this.containerView;
        TroopPersonalSettingData troopPersonalSettingData = null;
        if (linearLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("containerView");
            linearLayout = null;
        }
        TroopPersonalSettingData troopPersonalSettingData2 = this.pageData;
        if (troopPersonalSettingData2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(ISchemeApi.KEY_PAGE_DATA);
        } else {
            troopPersonalSettingData = troopPersonalSettingData2;
        }
        aVar.d(qBaseActivity, linearLayout, troopPersonalSettingData.e());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.fragment.QIphoneTitleBarFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return R.layout.h6k;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, Integer.valueOf(requestCode), Integer.valueOf(resultCode), data);
            return;
        }
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode != 2) {
            if (requestCode != 15) {
                if (requestCode == 19) {
                    Mh();
                    return;
                }
                return;
            }
            ii();
            return;
        }
        Nh();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        } else {
            li();
            super.onDestroyView();
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            super.onResume();
            Fh();
        }
    }
}
