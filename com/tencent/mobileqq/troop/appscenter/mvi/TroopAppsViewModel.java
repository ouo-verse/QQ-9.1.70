package com.tencent.mobileqq.troop.appscenter.mvi;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import androidx.lifecycle.MutableLiveData;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.bugly.common.constants.Constants;
import com.tencent.common.app.AppInterface;
import com.tencent.common.config.pad.DeviceType;
import com.tencent.common.config.pad.PadUtil;
import com.tencent.intervideo.nowproxy.NowProxyConstants;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.troop.api.IChatSettingForTroopApi;
import com.tencent.mobileqq.troop.appscenter.managers.NavigationManager;
import com.tencent.mobileqq.troop.appscenter.managers.NetworkManager;
import com.tencent.mobileqq.troop.appscenter.mvi.b;
import com.tencent.mobileqq.troop.appscenter.mvi.c;
import com.tencent.mobileqq.troop.shortcut.api.ITroopShortcutApi;
import com.tencent.mobileqq.troop.shortcut.repo.TroopShortcutSettingCache;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.StringUtils;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.base.mvi.BaseViewModel;
import com.tencent.qqnt.kernel.nativeinterface.AppDetail;
import com.tencent.qqnt.kernel.nativeinterface.ClassRankList;
import com.tencent.qqnt.kernel.nativeinterface.GetAppCenterRsp;
import com.tencent.qqnt.kernel.nativeinterface.RankList;
import com.tencent.qqnt.kernelpublic.nativeinterface.MemberRole;
import com.tencent.qqnt.troop.ITroopInfoRepoApi;
import com.tencent.qqnt.troopmemberlist.ITroopMemberListRepoApi;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import com.tencent.util.LoadingUtil;
import com.tencent.util.QQToastUtil;
import com.tencent.util.UiThreadUtil;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00b8\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 \u0080\u00012\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002\u0081\u0001B\u000f\u0012\u0006\u0010J\u001a\u00020\u001b\u00a2\u0006\u0004\b~\u0010\u007fJ\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J4\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\b2\u001a\u0010\r\u001a\u0016\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nj\n\u0012\u0004\u0012\u00020\u000b\u0018\u0001`\fH\u0002JD\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u00062\u001a\u0010\r\u001a\u0016\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nj\n\u0012\u0004\u0012\u00020\u000b\u0018\u0001`\fH\u0002J&\u0010\u0018\u001a\u00020\b2\u000e\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u00152\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0015H\u0002J&\u0010\u001f\u001a\u00020\u000e2\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u001b2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u000e0\u001dH\u0002J8\u0010%\u001a\u00020\u000e2\u0006\u0010\u001a\u001a\u00020 2\u0006\u0010!\u001a\u00020\u000b2\u0016\u0010#\u001a\u0012\u0012\u0004\u0012\u00020\"0\nj\b\u0012\u0004\u0012\u00020\"`\f2\u0006\u0010$\u001a\u00020\u0006H\u0002J0\u0010&\u001a\u00020\u000e2\u0006\u0010!\u001a\u00020\u000b2\u0016\u0010#\u001a\u0012\u0012\u0004\u0012\u00020\"0\nj\b\u0012\u0004\u0012\u00020\"`\f2\u0006\u0010$\u001a\u00020\u0006H\u0002J(\u0010'\u001a\u00020\u000e2\u0006\u0010!\u001a\u00020\u000b2\u0016\u0010#\u001a\u0012\u0012\u0004\u0012\u00020\"0\nj\b\u0012\u0004\u0012\u00020\"`\fH\u0002J \u0010(\u001a\u00020\u000e2\u0016\u0010#\u001a\u0012\u0012\u0004\u0012\u00020\"0\nj\b\u0012\u0004\u0012\u00020\"`\fH\u0002J\u0012\u0010*\u001a\u00020\u000e2\b\u0010)\u001a\u0004\u0018\u00010\u001bH\u0002J\u001f\u0010-\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010+2\u0006\u0010,\u001a\u00028\u0000H\u0002\u00a2\u0006\u0004\b-\u0010.J\b\u0010/\u001a\u00020\u000eH\u0002J\b\u00101\u001a\u000200H\u0002J\u0010\u00103\u001a\u00020\u000e2\u0006\u00102\u001a\u00020\u0003H\u0016J\u000e\u00105\u001a\u00020\u000e2\u0006\u00104\u001a\u00020\bJ(\u00106\u001a\u00020\u000e2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0016\u0010#\u001a\u0012\u0012\u0004\u0012\u00020\"0\nj\b\u0012\u0004\u0012\u00020\"`\fJ&\u00107\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u00042\u0016\u0010#\u001a\u0012\u0012\u0004\u0012\u00020\"0\nj\b\u0012\u0004\u0012\u00020\"`\fJ\u000e\u00108\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u0004J\b\u00109\u001a\u00020\u000eH\u0014J&\u0010:\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u00042\u0016\u0010#\u001a\u0012\u0012\u0004\u0012\u00020\"0\nj\b\u0012\u0004\u0012\u00020\"`\fJ\u0016\u0010;\u001a\u00020\u000e2\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010!\u001a\u00020\u000bJ6\u0010<\u001a\u00020\u000e2\u0006\u0010\u001a\u001a\u00020 2\u0006\u0010!\u001a\u00020\u000b2\u0016\u0010#\u001a\u0012\u0012\u0004\u0012\u00020\"0\nj\b\u0012\u0004\u0012\u00020\"`\f2\u0006\u0010$\u001a\u00020\u0006J6\u0010=\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010!\u001a\u00020\u000b2\u0016\u0010#\u001a\u0012\u0012\u0004\u0012\u00020\"0\nj\b\u0012\u0004\u0012\u00020\"`\f2\u0006\u0010$\u001a\u00020\u0006JF\u0010?\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010!\u001a\u00020\u000b2\u0016\u0010#\u001a\u0012\u0012\u0004\u0012\u00020\"0\nj\b\u0012\u0004\u0012\u00020\"`\f2\u0016\u0010>\u001a\u0012\u0012\u0004\u0012\u00020\u000b0\nj\b\u0012\u0004\u0012\u00020\u000b`\fJ.\u0010A\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010@\u001a\u00020\b2\u0016\u0010#\u001a\u0012\u0012\u0004\u0012\u00020\"0\nj\b\u0012\u0004\u0012\u00020\"`\fJ\u000e\u0010B\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u0004J\"\u0010C\u001a\u00020\u000e2\u001a\u0010#\u001a\u0016\u0012\u0004\u0012\u00020\"\u0018\u00010\nj\n\u0012\u0004\u0012\u00020\"\u0018\u0001`\fJ\u0016\u0010D\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010!\u001a\u00020\u000bJ.\u0010G\u001a\u00020\u000e2\u0006\u0010E\u001a\u00020\u00062\u0006\u0010F\u001a\u00020\u00062\u0016\u0010#\u001a\u0012\u0012\u0004\u0012\u00020\"0\nj\b\u0012\u0004\u0012\u00020\"`\fJ\u0006\u0010H\u001a\u00020\u000eJ \u0010K\u001a\u00020\u000e2\u0006\u0010J\u001a\u00020I2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u001a\u001a\u00020\u0019R\u0017\u0010J\u001a\u00020\u001b8\u0006\u00a2\u0006\f\n\u0004\bL\u0010M\u001a\u0004\bN\u0010OR\u0014\u0010S\u001a\u00020P8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bQ\u0010RR\u0014\u0010W\u001a\u00020T8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bU\u0010VR&\u0010Z\u001a\u0012\u0012\u0004\u0012\u00020\u000b0\nj\b\u0012\u0004\u0012\u00020\u000b`\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bX\u0010YR\u0016\u0010^\u001a\u00020[8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\\\u0010]R\u0016\u0010a\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b_\u0010`R\u0016\u0010c\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bb\u0010bR\u0018\u0010g\u001a\u0004\u0018\u00010d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\be\u0010fR\u0018\u0010k\u001a\u0004\u0018\u00010h8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bi\u0010jR\u0019\u0010q\u001a\u0004\u0018\u00010l8\u0006\u00a2\u0006\f\n\u0004\bm\u0010n\u001a\u0004\bo\u0010pR \u0010u\u001a\u000e\u0012\u0004\u0012\u00020I\u0012\u0004\u0012\u00020\u000e0r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bs\u0010tR\u001a\u0010{\u001a\u00020v8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\bw\u0010x\u001a\u0004\by\u0010zR\u0016\u0010}\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b|\u0010`\u00a8\u0006\u0082\u0001"}, d2 = {"Lcom/tencent/mobileqq/troop/appscenter/mvi/TroopAppsViewModel;", "Lcom/tencent/qqnt/base/mvi/BaseViewModel;", "Lcom/tencent/mobileqq/troop/appscenter/mvi/b;", "Lcom/tencent/mobileqq/troop/appscenter/mvi/c;", "Landroid/content/Context;", "context", "", "k2", "", "isFirst", "Ljava/util/ArrayList;", "Lcom/tencent/qqnt/kernel/nativeinterface/AppDetail;", "Lkotlin/collections/ArrayList;", "shortcutApps", "", "o2", "Lcom/tencent/qqnt/kernel/nativeinterface/GetAppCenterRsp;", "rsp", "isOwnerOrAdmin", "size", Constants.MMCCID, "", "oldList", "newList", "j2", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "", "message", "Lkotlin/Function0;", "onConfirm", "M2", "Lcom/tencent/mobileqq/app/QBaseActivity;", "detail", "Lcom/tencent/mobileqq/troop/appscenter/data/a;", "appInfoList", "source", "K2", "y2", NowProxyConstants.AccountInfoKey.A2, "T2", "errMsg", "P2", "T", "obj", "m2", "(Ljava/lang/Object;)Ljava/lang/Object;", "J2", "Lcom/tencent/common/app/AppInterface;", "p2", "userIntent", "u2", "isChecked", "L2", ICustomDataEditor.NUMBER_PARAM_2, "S2", "v2", "onCleared", "Q2", "C2", SemanticAttributes.DbSystemValues.H2, "x2", "remainApp", "z2", "isEdit", "B2", Constants.BASE_IN_PLUGIN_VERSION, "l2", "F2", "fromPosition", "toPosition", "E2", "w2", "", "troopUin", "t2", BdhLogUtil.LogTag.Tag_Conn, "Ljava/lang/String;", ICustomDataEditor.STRING_PARAM_2, "()Ljava/lang/String;", "Lcom/tencent/mobileqq/troop/appscenter/managers/NetworkManager;", "D", "Lcom/tencent/mobileqq/troop/appscenter/managers/NetworkManager;", "networkManager", "Lcom/tencent/mobileqq/troop/appscenter/managers/NavigationManager;", "E", "Lcom/tencent/mobileqq/troop/appscenter/managers/NavigationManager;", "navigationManager", UserInfo.SEX_FEMALE, "Ljava/util/ArrayList;", "shortCutAppsList", "Lcom/tencent/mobileqq/troop/appscenter/data/e;", "G", "Lcom/tencent/mobileqq/troop/appscenter/data/e;", "rankAppsData", "H", "Z", "isManageFlag", "I", "appLimit", "Landroid/app/Dialog;", "J", "Landroid/app/Dialog;", "loadDialog", "Ldt2/c;", "K", "Ldt2/c;", "aiChatDialog", "Lcom/tencent/mobileqq/data/troop/TroopInfo;", "L", "Lcom/tencent/mobileqq/data/troop/TroopInfo;", "r2", "()Lcom/tencent/mobileqq/data/troop/TroopInfo;", "troopInfo", "Lkotlin/Function1;", "M", "Lkotlin/jvm/functions/Function1;", "switchObserver", "Lcom/tencent/mobileqq/troop/appscenter/mvi/c$a;", "N", "Lcom/tencent/mobileqq/troop/appscenter/mvi/c$a;", "q2", "()Lcom/tencent/mobileqq/troop/appscenter/mvi/c$a;", "mNoneValueIntent", "P", "isDataModified", "<init>", "(Ljava/lang/String;)V", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "a", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class TroopAppsViewModel extends BaseViewModel<b, c> {
    static IPatchRedirector $redirector_;

    /* renamed from: Q, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final String troopUin;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final NetworkManager networkManager;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final NavigationManager navigationManager;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private ArrayList<AppDetail> shortCutAppsList;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private com.tencent.mobileqq.troop.appscenter.data.e rankAppsData;

    /* renamed from: H, reason: from kotlin metadata */
    private boolean isManageFlag;

    /* renamed from: I, reason: from kotlin metadata */
    private int appLimit;

    /* renamed from: J, reason: from kotlin metadata */
    @Nullable
    private Dialog loadDialog;

    /* renamed from: K, reason: from kotlin metadata */
    @Nullable
    private dt2.c aiChatDialog;

    /* renamed from: L, reason: from kotlin metadata */
    @Nullable
    private final TroopInfo troopInfo;

    /* renamed from: M, reason: from kotlin metadata */
    @NotNull
    private final Function1<Long, Unit> switchObserver;

    /* renamed from: N, reason: from kotlin metadata */
    @NotNull
    private final c.a mNoneValueIntent;

    /* renamed from: P, reason: from kotlin metadata */
    private boolean isDataModified;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\b\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/troop/appscenter/mvi/TroopAppsViewModel$a;", "", "", "CONFIG_ID", "Ljava/lang/String;", "TAG", "", "WIDTH_SIZE", "I", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.troop.appscenter.mvi.TroopAppsViewModel$a, reason: from kotlin metadata */
    /* loaded from: classes19.dex */
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

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(26306);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 23)) {
            redirector.redirect((short) 23);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public TroopAppsViewModel(@NotNull String troopUin) {
        Intrinsics.checkNotNullParameter(troopUin, "troopUin");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) troopUin);
            return;
        }
        this.troopUin = troopUin;
        this.networkManager = new NetworkManager();
        this.navigationManager = new NavigationManager();
        this.shortCutAppsList = new ArrayList<>();
        this.rankAppsData = new com.tencent.mobileqq.troop.appscenter.data.e(new ArrayList(), false, false);
        this.appLimit = 16;
        this.troopInfo = ((ITroopInfoRepoApi) QRoute.api(ITroopInfoRepoApi.class)).getTroopInfoFromCache(troopUin);
        this.switchObserver = new Function1<Long, Unit>() { // from class: com.tencent.mobileqq.troop.appscenter.mvi.TroopAppsViewModel$switchObserver$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) TroopAppsViewModel.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Long l3) {
                invoke(l3.longValue());
                return Unit.INSTANCE;
            }

            public final void invoke(long j3) {
                MutableLiveData mUiState;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, j3);
                } else if (Intrinsics.areEqual(TroopAppsViewModel.this.s2(), String.valueOf(j3))) {
                    TroopShortcutSettingCache a16 = TroopShortcutSettingCache.INSTANCE.a();
                    mUiState = TroopAppsViewModel.this.getMUiState();
                    mUiState.postValue(new b.C8674b(a16.d(j3), a16.e(j3)));
                }
            }
        };
        this.mNoneValueIntent = c.a.f294438a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void A2(final AppDetail detail, ArrayList<com.tencent.mobileqq.troop.appscenter.data.a> appInfoList) {
        this.isDataModified = true;
        for (com.tencent.mobileqq.troop.appscenter.data.a aVar : appInfoList) {
            if (aVar instanceof com.tencent.mobileqq.troop.appscenter.data.g) {
                CollectionsKt__MutableCollectionsKt.removeAll((List) ((com.tencent.mobileqq.troop.appscenter.data.g) aVar).d(), (Function1) new Function1<AppDetail, Boolean>() { // from class: com.tencent.mobileqq.troop.appscenter.mvi.TroopAppsViewModel$onDeleteSuccess$1$1
                    static IPatchRedirector $redirector_;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(1);
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                            iPatchRedirector.redirect((short) 1, (Object) this, (Object) AppDetail.this);
                        }
                    }

                    @Override // kotlin.jvm.functions.Function1
                    @NotNull
                    public final Boolean invoke(@NotNull AppDetail app) {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                            return (Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) app);
                        }
                        Intrinsics.checkNotNullParameter(app, "app");
                        return Boolean.valueOf(Intrinsics.areEqual(app.appId, AppDetail.this.appId));
                    }
                });
                CollectionsKt__MutableCollectionsKt.removeAll((List) this.shortCutAppsList, (Function1) new Function1<AppDetail, Boolean>() { // from class: com.tencent.mobileqq.troop.appscenter.mvi.TroopAppsViewModel$onDeleteSuccess$1$2
                    static IPatchRedirector $redirector_;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(1);
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                            iPatchRedirector.redirect((short) 1, (Object) this, (Object) AppDetail.this);
                        }
                    }

                    @Override // kotlin.jvm.functions.Function1
                    @NotNull
                    public final Boolean invoke(@NotNull AppDetail app) {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                            return (Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) app);
                        }
                        Intrinsics.checkNotNullParameter(app, "app");
                        return Boolean.valueOf(Intrinsics.areEqual(app.appId, AppDetail.this.appId));
                    }
                });
            }
            if (aVar instanceof com.tencent.mobileqq.troop.appscenter.data.f) {
                ArrayList<AppDetail> d16 = ((com.tencent.mobileqq.troop.appscenter.data.f) aVar).d();
                ArrayList arrayList = new ArrayList();
                for (Object obj : d16) {
                    if (Intrinsics.areEqual(((AppDetail) obj).appId, detail.appId)) {
                        arrayList.add(obj);
                    }
                }
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    ((AppDetail) it.next()).added = 0;
                }
            }
        }
        Iterator<T> it5 = this.rankAppsData.c().iterator();
        while (it5.hasNext()) {
            ArrayList<ClassRankList> arrayList2 = ((RankList) it5.next()).classRankList;
            Intrinsics.checkNotNullExpressionValue(arrayList2, "rankList.classRankList");
            Iterator<T> it6 = arrayList2.iterator();
            while (it6.hasNext()) {
                ArrayList<AppDetail> classApps = ((ClassRankList) it6.next()).getClassApps();
                Intrinsics.checkNotNullExpressionValue(classApps, "item.getClassApps()");
                ArrayList arrayList3 = new ArrayList();
                for (Object obj2 : classApps) {
                    if (Intrinsics.areEqual(((AppDetail) obj2).appId, detail.appId)) {
                        arrayList3.add(obj2);
                    }
                }
                Iterator it7 = arrayList3.iterator();
                while (it7.hasNext()) {
                    ((AppDetail) it7.next()).added = 0;
                }
            }
        }
        T2(appInfoList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void G2(Context context, GetAppCenterRsp rsp, boolean isOwnerOrAdmin, int size, ArrayList<AppDetail> shortcutApps) {
        Long longOrNull;
        long j3;
        boolean z16;
        final ArrayList arrayList = new ArrayList();
        int i3 = rsp.appLimit;
        if (i3 > 0) {
            this.appLimit = i3;
        }
        ArrayList<AppDetail> apps = rsp.getApps;
        boolean z17 = false;
        if (!((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("102812", true)) {
            Intrinsics.checkNotNullExpressionValue(apps, "apps");
            ArrayList arrayList2 = new ArrayList();
            for (Object obj : apps) {
                if (StringUtils.toLong(((AppDetail) obj).appId) != 10000) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    arrayList2.add(obj);
                }
            }
        }
        Intrinsics.checkNotNullExpressionValue(apps, "apps");
        arrayList.add(new com.tencent.mobileqq.troop.appscenter.data.g(apps, this.troopUin, isOwnerOrAdmin, size, this.isManageFlag, this.troopInfo));
        TroopShortcutSettingCache a16 = TroopShortcutSettingCache.INSTANCE.a();
        longOrNull = StringsKt__StringNumberConversionsKt.toLongOrNull(this.troopUin);
        if (longOrNull != null) {
            j3 = longOrNull.longValue();
        } else {
            j3 = 0;
        }
        if (a16.f(j3)) {
            if (!a16.e(j3) || isOwnerOrAdmin) {
                z17 = true;
            }
            boolean z18 = !a16.d(j3);
            if (z17) {
                arrayList.add(new com.tencent.mobileqq.troop.appscenter.data.b(true, z18, isOwnerOrAdmin, this.isManageFlag));
            } else {
                arrayList.add(new com.tencent.mobileqq.troop.appscenter.data.c("\u60f3\u8981\u5feb\u6377\u4f7f\u7528\u7fa4\u5e94\u7528\uff0c\u53ef\u8054\u7cfb\u7fa4\u4e3b/\u7ba1\u7406\u5458\u5f00\u542f\u5feb\u6377\u680f\u5c55\u793a\u54e6\uff5e", this.isManageFlag));
            }
        } else {
            arrayList.add(new com.tencent.mobileqq.troop.appscenter.data.c("\u5c0f\u63d0\u793a\uff1a\u7fa4\u5feb\u6377\u680f\u8bbe\u7f6e\u5165\u53e3\u8c03\u6574\u81f3\u201c\u7fa4\u804a\u8bbe\u7f6e-\u4e2a\u6027\u8bbe\u7f6e-\u5c55\u793a\u804a\u5929\u5feb\u6377\u680f\u201d", this.isManageFlag));
        }
        ArrayList<AppDetail> arrayList3 = rsp.recommendApps;
        Intrinsics.checkNotNullExpressionValue(arrayList3, "rsp.recommendApps");
        arrayList.add(new com.tencent.mobileqq.troop.appscenter.data.f(arrayList3, isOwnerOrAdmin, size, this.isManageFlag, null, 16, null));
        ArrayList<RankList> arrayList4 = rsp.rankList;
        Intrinsics.checkNotNullExpressionValue(arrayList4, "rsp.rankList");
        this.rankAppsData = new com.tencent.mobileqq.troop.appscenter.data.e(arrayList4, isOwnerOrAdmin, this.isManageFlag);
        if (j2(shortcutApps, apps)) {
            UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.troop.appscenter.mvi.i
                @Override // java.lang.Runnable
                public final void run() {
                    TroopAppsViewModel.H2(TroopAppsViewModel.this);
                }
            });
            return;
        }
        ArrayList<AppDetail> arrayList5 = (ArrayList) m2(apps);
        if (arrayList5 == null) {
            arrayList5 = new ArrayList<>();
        }
        this.shortCutAppsList = arrayList5;
        UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.troop.appscenter.mvi.j
            @Override // java.lang.Runnable
            public final void run() {
                TroopAppsViewModel.I2(TroopAppsViewModel.this, arrayList);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void H2(TroopAppsViewModel this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getMUiState().postValue(new b.d(this$0.rankAppsData));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void I2(TroopAppsViewModel this$0, ArrayList currentInfoList) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(currentInfoList, "$currentInfoList");
        this$0.isDataModified = true;
        this$0.getMUiState().postValue(new b.a(currentInfoList, this$0.rankAppsData));
    }

    private final void J2() {
        TroopInfo troopInfo;
        if (((IChatSettingForTroopApi) QRoute.api(IChatSettingForTroopApi.class)).isShowingAppShortCutBar(p2(), this.troopUin) && (troopInfo = this.troopInfo) != null) {
            ((IChatSettingForTroopApi) QRoute.api(IChatSettingForTroopApi.class)).refreshAppShortCutBarAppList(p2(), this.troopUin, (int) troopInfo.dwGroupClassExt);
        }
    }

    private final void K2(final QBaseActivity activity, final AppDetail detail, final ArrayList<com.tencent.mobileqq.troop.appscenter.data.a> appInfoList, final int source) {
        this.networkManager.e(this.troopUin, StringUtils.toLong(detail.action.associatedId), new Function3<Boolean, Integer, String, Unit>(activity, detail, appInfoList, source) { // from class: com.tencent.mobileqq.troop.appscenter.mvi.TroopAppsViewModel$setAddRobotToGroup$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ QBaseActivity $activity;
            final /* synthetic */ ArrayList<com.tencent.mobileqq.troop.appscenter.data.a> $appInfoList;
            final /* synthetic */ AppDetail $detail;
            final /* synthetic */ int $source;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(3);
                this.$activity = activity;
                this.$detail = detail;
                this.$appInfoList = appInfoList;
                this.$source = source;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, TroopAppsViewModel.this, activity, detail, appInfoList, Integer.valueOf(source));
                }
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool, Integer num, String str) {
                invoke(bool.booleanValue(), num.intValue(), str);
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z16, int i3, @Nullable String str) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), Integer.valueOf(i3), str);
                    return;
                }
                if (z16) {
                    TroopAppsViewModel.this.x2(this.$activity, this.$detail, this.$appInfoList, this.$source);
                    return;
                }
                QLog.e("TroopAppsCenter.TroopAppsViewModel", 1, "AddRobotToGroupReq " + i3 + " " + str + " robotId:" + this.$detail.action.associatedId + " troopUin:" + TroopAppsViewModel.this.s2());
                TroopAppsViewModel.this.P2(str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void M2(Activity activity, String message, final Function0<Unit> onConfirm) {
        DialogUtil.createCustomDialog(activity, 230, (String) null, message, "\u53d6\u6d88", "\u5f00\u542f", new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.troop.appscenter.mvi.g
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                TroopAppsViewModel.N2(Function0.this, dialogInterface, i3);
            }
        }, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.troop.appscenter.mvi.h
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                TroopAppsViewModel.O2(dialogInterface, i3);
            }
        }).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void N2(Function0 onConfirm, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(onConfirm, "$onConfirm");
        onConfirm.invoke();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void O2(DialogInterface dialogInterface, int i3) {
        dialogInterface.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void P2(String errMsg) {
        if (errMsg != null) {
            QQToastUtil.showQQToastInUiThread(1, errMsg);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void R2(TroopAppsViewModel this$0, ArrayList appInfoList) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(appInfoList, "$appInfoList");
        this$0.getMUiState().postValue(new b.e(appInfoList));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void T2(final ArrayList<com.tencent.mobileqq.troop.appscenter.data.a> appInfoList) {
        UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.troop.appscenter.mvi.e
            @Override // java.lang.Runnable
            public final void run() {
                TroopAppsViewModel.U2(TroopAppsViewModel.this, appInfoList);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void U2(TroopAppsViewModel this$0, ArrayList appInfoList) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(appInfoList, "$appInfoList");
        this$0.getMUiState().postValue(new b.c(appInfoList, this$0.rankAppsData));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i2(TroopAppsViewModel this$0, QBaseActivity activity, AppDetail detail, ArrayList appInfoList, int i3, TroopMemberInfo troopMemberInfo) {
        MemberRole memberRole;
        MemberRole memberRole2;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(activity, "$activity");
        Intrinsics.checkNotNullParameter(detail, "$detail");
        Intrinsics.checkNotNullParameter(appInfoList, "$appInfoList");
        MemberRole memberRole3 = null;
        if (troopMemberInfo != null) {
            memberRole = troopMemberInfo.role;
        } else {
            memberRole = null;
        }
        if (memberRole != null) {
            if (troopMemberInfo != null) {
                memberRole2 = troopMemberInfo.role;
            } else {
                memberRole2 = null;
            }
            if (memberRole2 != MemberRole.UNSPECIFIED) {
                if (troopMemberInfo != null) {
                    memberRole3 = troopMemberInfo.role;
                }
                if (memberRole3 != MemberRole.STRANGER) {
                    this$0.x2(activity, detail, appInfoList, i3);
                    return;
                }
            }
        }
        this$0.K2(activity, detail, appInfoList, i3);
    }

    private final boolean j2(List<AppDetail> oldList, List<AppDetail> newList) {
        boolean z16;
        List zip;
        boolean z17;
        List<AppDetail> list = oldList;
        if (list != null && !list.isEmpty()) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!z16 && oldList.size() == newList.size()) {
            zip = CollectionsKt___CollectionsKt.zip(oldList, newList);
            List<Pair> list2 = zip;
            if ((list2 instanceof Collection) && list2.isEmpty()) {
                return true;
            }
            for (Pair pair : list2) {
                AppDetail appDetail = (AppDetail) pair.component1();
                AppDetail appDetail2 = (AppDetail) pair.component2();
                if (Intrinsics.areEqual(appDetail.appId, appDetail2.appId) && Intrinsics.areEqual(appDetail.name, appDetail2.name) && Intrinsics.areEqual(appDetail.icon, appDetail2.icon) && appDetail.type == appDetail2.type && appDetail.removable == appDetail2.removable && Intrinsics.areEqual(appDetail.desc, appDetail2.desc) && appDetail.added == appDetail2.added && appDetail.addTs == appDetail2.addTs) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                if (!z17) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    private final int k2(Context context) {
        int i3;
        com.tencent.gdtad.util.j jVar = com.tencent.gdtad.util.j.f109555a;
        float b16 = jVar.b(ScreenUtil.getInstantScreenWidth(BaseApplication.context));
        if (PadUtil.a(context) == DeviceType.TABLET) {
            b16 = Math.min(jVar.b(com.tencent.mobileqq.aio.utils.e.f194142a.d()), b16);
        }
        if (b16 > 680.0f) {
            i3 = 8;
        } else {
            i3 = 4;
        }
        QLog.i("TroopAppsCenter.TroopAppsViewModel", 1, "calculateColumnsSize windowWidth: " + b16 + " columnsSize: " + i3);
        return i3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final <T> T m2(T obj) {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            try {
                objectOutputStream.writeObject(obj);
                Unit unit = Unit.INSTANCE;
                CloseableKt.closeFinally(objectOutputStream, null);
                ObjectInputStream objectInputStream = new ObjectInputStream(new ByteArrayInputStream(byteArrayOutputStream.toByteArray()));
                try {
                    T t16 = (T) objectInputStream.readObject();
                    CloseableKt.closeFinally(objectInputStream, null);
                    return t16;
                } finally {
                }
            } finally {
            }
        } catch (IOException e16) {
            e16.printStackTrace();
            return null;
        } catch (ClassNotFoundException e17) {
            e17.printStackTrace();
            return null;
        }
    }

    private final void o2(Context context, boolean isFirst, ArrayList<AppDetail> shortcutApps) {
        boolean z16;
        if (isFirst) {
            Dialog showLoadingDialogTipsRight = LoadingUtil.showLoadingDialogTipsRight(context, false, true);
            this.loadDialog = showLoadingDialogTipsRight;
            if (showLoadingDialogTipsRight != null) {
                showLoadingDialogTipsRight.show();
            }
        }
        TroopInfo troopInfoFromCache = ((ITroopInfoRepoApi) QRoute.api(ITroopInfoRepoApi.class)).getTroopInfoFromCache(this.troopUin);
        if (troopInfoFromCache != null && troopInfoFromCache.isOwnerOrAdmin()) {
            z16 = true;
        } else {
            z16 = false;
        }
        this.networkManager.i(this.troopUin, new TroopAppsViewModel$getAppCenter$1(this, context, z16, k2(context), shortcutApps));
    }

    private final AppInterface p2() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        Intrinsics.checkNotNull(peekAppRuntime, "null cannot be cast to non-null type com.tencent.common.app.AppInterface");
        return (AppInterface) peekAppRuntime;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void y2(AppDetail detail, ArrayList<com.tencent.mobileqq.troop.appscenter.data.a> appInfoList, int source) {
        this.isDataModified = true;
        for (com.tencent.mobileqq.troop.appscenter.data.a aVar : appInfoList) {
            if (aVar instanceof com.tencent.mobileqq.troop.appscenter.data.g) {
                ((com.tencent.mobileqq.troop.appscenter.data.g) aVar).d().add(detail);
                this.shortCutAppsList.add(detail);
            }
            if (aVar instanceof com.tencent.mobileqq.troop.appscenter.data.f) {
                ArrayList<AppDetail> d16 = ((com.tencent.mobileqq.troop.appscenter.data.f) aVar).d();
                ArrayList arrayList = new ArrayList();
                for (Object obj : d16) {
                    if (Intrinsics.areEqual(((AppDetail) obj).appId, detail.appId)) {
                        arrayList.add(obj);
                    }
                }
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    ((AppDetail) it.next()).added = 1;
                }
            }
        }
        Iterator<T> it5 = this.rankAppsData.c().iterator();
        while (it5.hasNext()) {
            ArrayList<ClassRankList> arrayList2 = ((RankList) it5.next()).classRankList;
            Intrinsics.checkNotNullExpressionValue(arrayList2, "rankList.classRankList");
            Iterator<T> it6 = arrayList2.iterator();
            while (it6.hasNext()) {
                ArrayList<AppDetail> classApps = ((ClassRankList) it6.next()).getClassApps();
                Intrinsics.checkNotNullExpressionValue(classApps, "item.getClassApps()");
                ArrayList arrayList3 = new ArrayList();
                for (Object obj2 : classApps) {
                    if (Intrinsics.areEqual(((AppDetail) obj2).appId, detail.appId)) {
                        arrayList3.add(obj2);
                    }
                }
                Iterator it7 = arrayList3.iterator();
                while (it7.hasNext()) {
                    ((AppDetail) it7.next()).added = 1;
                }
            }
        }
        T2(appInfoList);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v2 */
    /* JADX WARN: Type inference failed for: r6v3 */
    /* JADX WARN: Type inference failed for: r6v5, types: [java.lang.Object] */
    public final void B2(@NotNull Context context, boolean isEdit, @NotNull final ArrayList<com.tencent.mobileqq.troop.appscenter.data.a> appInfoList) {
        final com.tencent.mobileqq.troop.appscenter.data.g gVar;
        com.tencent.mobileqq.troop.appscenter.data.g gVar2;
        List<AppDetail> emptyList;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, this, context, Boolean.valueOf(isEdit), appInfoList);
            return;
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(appInfoList, "appInfoList");
        this.isManageFlag = isEdit;
        Iterator it = appInfoList.iterator();
        while (it.hasNext()) {
            ((com.tencent.mobileqq.troop.appscenter.data.a) it.next()).b(isEdit);
        }
        this.rankAppsData.b(isEdit);
        if (!isEdit) {
            Iterator it5 = appInfoList.iterator();
            while (true) {
                gVar = null;
                if (it5.hasNext()) {
                    gVar2 = it5.next();
                    if (((com.tencent.mobileqq.troop.appscenter.data.a) gVar2) instanceof com.tencent.mobileqq.troop.appscenter.data.g) {
                        break;
                    }
                } else {
                    gVar2 = 0;
                    break;
                }
            }
            if (gVar2 instanceof com.tencent.mobileqq.troop.appscenter.data.g) {
                gVar = gVar2;
            }
            if (gVar == null || (emptyList = gVar.d()) == null) {
                emptyList = CollectionsKt__CollectionsKt.emptyList();
            }
            this.networkManager.o(this.troopUin, NetworkManager.GroupAppListRequestType.UPDATE_APP_LIST, emptyList, new Function3<Boolean, Integer, String, Unit>(gVar, appInfoList) { // from class: com.tencent.mobileqq.troop.appscenter.mvi.TroopAppsViewModel$onEditManageClick$2
                static IPatchRedirector $redirector_;
                final /* synthetic */ ArrayList<com.tencent.mobileqq.troop.appscenter.data.a> $appInfoList;
                final /* synthetic */ com.tencent.mobileqq.troop.appscenter.data.g $tempList;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(3);
                    this.$tempList = gVar;
                    this.$appInfoList = appInfoList;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, TroopAppsViewModel.this, gVar, appInfoList);
                    }
                }

                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(Boolean bool, Integer num, String str) {
                    invoke(bool.booleanValue(), num.intValue(), str);
                    return Unit.INSTANCE;
                }

                public final void invoke(boolean z16, int i3, @Nullable String str) {
                    Object m26;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, this, Boolean.valueOf(z16), Integer.valueOf(i3), str);
                        return;
                    }
                    if (z16) {
                        TroopAppsViewModel.this.isDataModified = true;
                        com.tencent.mobileqq.troop.appscenter.data.g gVar3 = this.$tempList;
                        if (gVar3 != null) {
                            TroopAppsViewModel troopAppsViewModel = TroopAppsViewModel.this;
                            m26 = troopAppsViewModel.m2(gVar3.d());
                            ArrayList arrayList = (ArrayList) m26;
                            if (arrayList == null) {
                                arrayList = new ArrayList();
                            }
                            troopAppsViewModel.shortCutAppsList = arrayList;
                        }
                        TroopAppsViewModel.this.T2(this.$appInfoList);
                        return;
                    }
                    TroopAppsViewModel.this.P2(str);
                    QLog.e("TroopAppsCenter.TroopAppsViewModel", 1, "onEditManageClick result " + i3 + " err: " + str + " troopUin:" + TroopAppsViewModel.this.s2());
                }
            });
            return;
        }
        T2(appInfoList);
    }

    public final void C2(@NotNull final Activity activity, @NotNull AppDetail detail) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) activity, (Object) detail);
            return;
        }
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(detail, "detail");
        this.navigationManager.f(this.troopUin, activity, detail, new Function1<dt2.c, Unit>() { // from class: com.tencent.mobileqq.troop.appscenter.mvi.TroopAppsViewModel$onItemViewClick$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) TroopAppsViewModel.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(dt2.c cVar) {
                invoke2(cVar);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable dt2.c cVar) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                    TroopAppsViewModel.this.aiChatDialog = cVar;
                } else {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) cVar);
                }
            }
        }, new Function2<String, Function0<? extends Unit>, Unit>(activity) { // from class: com.tencent.mobileqq.troop.appscenter.mvi.TroopAppsViewModel$onItemViewClick$2
            static IPatchRedirector $redirector_;
            final /* synthetic */ Activity $activity;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
                this.$activity = activity;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) TroopAppsViewModel.this, (Object) activity);
                }
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(String str, Function0<? extends Unit> function0) {
                invoke2(str, (Function0<Unit>) function0);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull String message, @NotNull Function0<Unit> onConfirm) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) message, (Object) onConfirm);
                    return;
                }
                Intrinsics.checkNotNullParameter(message, "message");
                Intrinsics.checkNotNullParameter(onConfirm, "onConfirm");
                TroopAppsViewModel.this.M2(this.$activity, message, onConfirm);
            }
        }, new Function1<String, Unit>() { // from class: com.tencent.mobileqq.troop.appscenter.mvi.TroopAppsViewModel$onItemViewClick$3
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) TroopAppsViewModel.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(String str) {
                invoke2(str);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull String errorMsg) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) errorMsg);
                } else {
                    Intrinsics.checkNotNullParameter(errorMsg, "errorMsg");
                    TroopAppsViewModel.this.P2(errorMsg);
                }
            }
        });
    }

    public final void D2(@NotNull Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, (Object) context);
        } else {
            Intrinsics.checkNotNullParameter(context, "context");
            o2(context, true, null);
        }
    }

    public final void E2(int fromPosition, int toPosition, @NotNull ArrayList<com.tencent.mobileqq.troop.appscenter.data.a> appInfoList) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, this, Integer.valueOf(fromPosition), Integer.valueOf(toPosition), appInfoList);
            return;
        }
        Intrinsics.checkNotNullParameter(appInfoList, "appInfoList");
        for (com.tencent.mobileqq.troop.appscenter.data.a aVar : appInfoList) {
            if (aVar instanceof com.tencent.mobileqq.troop.appscenter.data.g) {
                ArrayList<AppDetail> d16 = ((com.tencent.mobileqq.troop.appscenter.data.g) aVar).d();
                d16.add(toPosition, d16.remove(fromPosition));
            }
        }
    }

    public final void F2(@NotNull Context context, @NotNull AppDetail detail) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, (Object) context, (Object) detail);
            return;
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(detail, "detail");
        this.navigationManager.l(this.troopUin, context, detail);
    }

    public final void L2(boolean isChecked) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, isChecked);
            return;
        }
        IChatSettingForTroopApi iChatSettingForTroopApi = (IChatSettingForTroopApi) QRoute.api(IChatSettingForTroopApi.class);
        AppInterface p26 = p2();
        String str = this.troopUin;
        boolean z16 = true;
        int i3 = !isChecked ? 1 : 0;
        TroopInfo troopInfo = this.troopInfo;
        if (troopInfo == null || !troopInfo.isOwnerOrAdmin()) {
            z16 = false;
        }
        iChatSettingForTroopApi.setAppShortCutBarSwitch(p26, str, i3, z16);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v7, types: [java.lang.Object] */
    public final void Q2(@NotNull Context context, @NotNull final ArrayList<com.tencent.mobileqq.troop.appscenter.data.a> appInfoList) {
        com.tencent.mobileqq.troop.appscenter.data.g gVar;
        com.tencent.mobileqq.troop.appscenter.data.g gVar2;
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) context, (Object) appInfoList);
            return;
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(appInfoList, "appInfoList");
        int k26 = k2(context);
        Iterator it = appInfoList.iterator();
        while (true) {
            gVar = null;
            if (it.hasNext()) {
                gVar2 = it.next();
                if (((com.tencent.mobileqq.troop.appscenter.data.a) gVar2) instanceof com.tencent.mobileqq.troop.appscenter.data.g) {
                    break;
                }
            } else {
                gVar2 = 0;
                break;
            }
        }
        if (gVar2 instanceof com.tencent.mobileqq.troop.appscenter.data.g) {
            gVar = gVar2;
        }
        boolean z17 = false;
        if (gVar != null && gVar.c() == k26) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            for (com.tencent.mobileqq.troop.appscenter.data.a aVar : appInfoList) {
                if (aVar instanceof com.tencent.mobileqq.troop.appscenter.data.g) {
                    ((com.tencent.mobileqq.troop.appscenter.data.g) aVar).g(k26);
                }
                if (aVar instanceof com.tencent.mobileqq.troop.appscenter.data.f) {
                    ((com.tencent.mobileqq.troop.appscenter.data.f) aVar).f(k26);
                }
            }
            UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.troop.appscenter.mvi.d
                @Override // java.lang.Runnable
                public final void run() {
                    TroopAppsViewModel.R2(TroopAppsViewModel.this, appInfoList);
                }
            });
        }
        dt2.c cVar = this.aiChatDialog;
        if (cVar != null && cVar.isShow()) {
            z17 = true;
        }
        if (z17) {
            dt2.c cVar2 = this.aiChatDialog;
            if (cVar2 != null) {
                cVar2.onConfigurationChanged();
            }
            QLog.i("TroopAppsCenter.TroopAppsViewModel", 1, "aiChatDialog  is show: " + k26);
        }
    }

    public final void S2(@NotNull Context context, @NotNull ArrayList<com.tencent.mobileqq.troop.appscenter.data.a> appInfoList) {
        ArrayList<AppDetail> arrayList;
        Object obj;
        com.tencent.mobileqq.troop.appscenter.data.g gVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) context, (Object) appInfoList);
            return;
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(appInfoList, "appInfoList");
        Iterator<T> it = appInfoList.iterator();
        while (true) {
            arrayList = null;
            if (it.hasNext()) {
                obj = it.next();
                if (((com.tencent.mobileqq.troop.appscenter.data.a) obj) instanceof com.tencent.mobileqq.troop.appscenter.data.g) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        if (obj instanceof com.tencent.mobileqq.troop.appscenter.data.g) {
            gVar = (com.tencent.mobileqq.troop.appscenter.data.g) obj;
        } else {
            gVar = null;
        }
        if (gVar != null) {
            arrayList = gVar.d();
        }
        o2(context, false, arrayList);
    }

    public final void h2(@NotNull final QBaseActivity activity, @NotNull final AppDetail detail, @NotNull final ArrayList<com.tencent.mobileqq.troop.appscenter.data.a> appInfoList, final int source) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, this, activity, detail, appInfoList, Integer.valueOf(source));
            return;
        }
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(detail, "detail");
        Intrinsics.checkNotNullParameter(appInfoList, "appInfoList");
        if (this.shortCutAppsList.size() >= this.appLimit) {
            P2("\u6dfb\u52a0\u5e94\u7528\u8d85\u8fc7\u4e0a\u9650");
        } else {
            ((ITroopMemberListRepoApi) QRoute.api(ITroopMemberListRepoApi.class)).fetchTroopMemberInfo(this.troopUin, detail.action.associatedId, true, activity, "", new com.tencent.qqnt.troopmemberlist.g() { // from class: com.tencent.mobileqq.troop.appscenter.mvi.f
                @Override // com.tencent.qqnt.troopmemberlist.g
                public final void a(TroopMemberInfo troopMemberInfo) {
                    TroopAppsViewModel.i2(TroopAppsViewModel.this, activity, detail, appInfoList, source, troopMemberInfo);
                }
            });
        }
    }

    public final void l2(@Nullable ArrayList<com.tencent.mobileqq.troop.appscenter.data.a> appInfoList) {
        ArrayList<AppDetail> arrayList;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, (Object) appInfoList);
            return;
        }
        if (appInfoList != null) {
            for (com.tencent.mobileqq.troop.appscenter.data.a aVar : appInfoList) {
                aVar.b(false);
                if (this.isManageFlag && (aVar instanceof com.tencent.mobileqq.troop.appscenter.data.g) && (arrayList = (ArrayList) m2(this.shortCutAppsList)) != null) {
                    ((com.tencent.mobileqq.troop.appscenter.data.g) aVar).h(arrayList);
                }
            }
            if (this.rankAppsData.a()) {
                this.rankAppsData.b(false);
            }
            T2(appInfoList);
        }
        this.isManageFlag = false;
    }

    public final void n2(@Nullable Context context, @NotNull ArrayList<com.tencent.mobileqq.troop.appscenter.data.a> appInfoList) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) context, (Object) appInfoList);
            return;
        }
        Intrinsics.checkNotNullParameter(appInfoList, "appInfoList");
        ArrayList<AppDetail> arrayList = this.shortCutAppsList;
        ArrayList<AppDetail> arrayList2 = new ArrayList();
        for (Object obj : arrayList) {
            if (StringUtils.toLong(((AppDetail) obj).appId) == 10000) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                arrayList2.add(obj);
            }
        }
        ArrayList<AppDetail> arrayList3 = this.shortCutAppsList;
        for (AppDetail appDetail : arrayList2) {
            if (context != null) {
                arrayList3.remove(appDetail);
                z2(context, appDetail, appInfoList, arrayList3);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.qqnt.base.mvi.BaseViewModel, androidx.lifecycle.ViewModel
    public void onCleared() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
        } else {
            TroopShortcutSettingCache.INSTANCE.a().c().remove(this.switchObserver);
        }
    }

    @Override // com.tencent.qqnt.base.mvi.BaseViewModel
    @NotNull
    /* renamed from: q2, reason: merged with bridge method [inline-methods] */
    public c.a getMNoneValueIntent() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (c.a) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.mNoneValueIntent;
    }

    @Nullable
    public final TroopInfo r2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (TroopInfo) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.troopInfo;
    }

    @NotNull
    public final String s2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.troopUin;
    }

    public final void t2(long troopUin, @Nullable Context context, @NotNull Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, this, Long.valueOf(troopUin), context, activity);
        } else {
            Intrinsics.checkNotNullParameter(activity, "activity");
            this.navigationManager.e(troopUin, context, activity);
        }
    }

    @Override // com.tencent.qqnt.base.mvi.BaseViewModel
    /* renamed from: u2, reason: merged with bridge method [inline-methods] */
    public void handleIntent(@NotNull c userIntent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) userIntent);
        } else {
            Intrinsics.checkNotNullParameter(userIntent, "userIntent");
        }
    }

    public final void v2(@NotNull Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) context);
            return;
        }
        Intrinsics.checkNotNullParameter(context, "context");
        TroopInfo troopInfo = this.troopInfo;
        boolean z16 = false;
        if (troopInfo != null && !troopInfo.hadJoinTroop()) {
            z16 = true;
        }
        if (z16) {
            QLog.i("TroopAppsCenter.TroopAppsViewModel", 1, "troopInfo?.hadJoinTroop is false");
            P2("\u60a8\u4e0d\u662f\u7fa4\u6210\u5458\uff0c\u65e0\u6cd5\u67e5\u770b\u7fa4\u5e94\u7528");
            return;
        }
        o2(context, true, null);
        List<Function1<Long, Unit>> c16 = TroopShortcutSettingCache.INSTANCE.a().c();
        if (!c16.contains(this.switchObserver)) {
            c16.add(this.switchObserver);
        }
    }

    public final void w2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this);
            return;
        }
        if (this.isDataModified) {
            this.isDataModified = false;
            QRouteApi api = QRoute.api(ITroopShortcutApi.class);
            Intrinsics.checkNotNullExpressionValue(api, "api(ITroopShortcutApi::class.java)");
            ITroopShortcutApi.a.a((ITroopShortcutApi) api, null, 1, null);
            J2();
        }
    }

    public final void x2(@NotNull Context context, @NotNull final AppDetail detail, @NotNull final ArrayList<com.tencent.mobileqq.troop.appscenter.data.a> appInfoList, final int source) {
        List<AppDetail> listOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, this, context, detail, appInfoList, Integer.valueOf(source));
            return;
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(detail, "detail");
        Intrinsics.checkNotNullParameter(appInfoList, "appInfoList");
        if (this.shortCutAppsList.size() >= this.appLimit) {
            P2("\u6dfb\u52a0\u5e94\u7528\u8d85\u8fc7\u4e0a\u9650");
            return;
        }
        NetworkManager networkManager = this.networkManager;
        String str = this.troopUin;
        NetworkManager.GroupAppListRequestType groupAppListRequestType = NetworkManager.GroupAppListRequestType.ADD_APP;
        listOf = CollectionsKt__CollectionsJVMKt.listOf(detail);
        networkManager.o(str, groupAppListRequestType, listOf, new Function3<Boolean, Integer, String, Unit>(detail, appInfoList, source) { // from class: com.tencent.mobileqq.troop.appscenter.mvi.TroopAppsViewModel$onAddShortcutClick$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ ArrayList<com.tencent.mobileqq.troop.appscenter.data.a> $appInfoList;
            final /* synthetic */ AppDetail $detail;
            final /* synthetic */ int $source;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(3);
                this.$detail = detail;
                this.$appInfoList = appInfoList;
                this.$source = source;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, TroopAppsViewModel.this, detail, appInfoList, Integer.valueOf(source));
                }
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool, Integer num, String str2) {
                invoke(bool.booleanValue(), num.intValue(), str2);
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z16, int i3, @Nullable String str2) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, this, Boolean.valueOf(z16), Integer.valueOf(i3), str2);
                    return;
                }
                if (z16) {
                    TroopAppsViewModel.this.y2(this.$detail, this.$appInfoList, this.$source);
                    return;
                }
                TroopAppsViewModel.this.P2(str2);
                AppDetail appDetail = this.$detail;
                QLog.e("TroopAppsCenter.TroopAppsViewModel", 1, "onAddShortcutClick result " + i3 + " err: " + str2 + " " + appDetail.name + " detail:" + appDetail.appId);
            }
        });
    }

    public final void z2(@NotNull Context context, @NotNull final AppDetail detail, @NotNull final ArrayList<com.tencent.mobileqq.troop.appscenter.data.a> appInfoList, @NotNull ArrayList<AppDetail> remainApp) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, this, context, detail, appInfoList, remainApp);
            return;
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(detail, "detail");
        Intrinsics.checkNotNullParameter(appInfoList, "appInfoList");
        Intrinsics.checkNotNullParameter(remainApp, "remainApp");
        this.networkManager.o(this.troopUin, NetworkManager.GroupAppListRequestType.UPDATE_APP_LIST, remainApp, new Function3<Boolean, Integer, String, Unit>(detail, appInfoList) { // from class: com.tencent.mobileqq.troop.appscenter.mvi.TroopAppsViewModel$onDeleteShortcutClick$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ ArrayList<com.tencent.mobileqq.troop.appscenter.data.a> $appInfoList;
            final /* synthetic */ AppDetail $detail;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(3);
                this.$detail = detail;
                this.$appInfoList = appInfoList;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, TroopAppsViewModel.this, detail, appInfoList);
                }
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool, Integer num, String str) {
                invoke(bool.booleanValue(), num.intValue(), str);
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z16, int i3, @Nullable String str) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, this, Boolean.valueOf(z16), Integer.valueOf(i3), str);
                    return;
                }
                if (z16) {
                    TroopAppsViewModel.this.A2(this.$detail, this.$appInfoList);
                    return;
                }
                TroopAppsViewModel.this.P2(str);
                AppDetail appDetail = this.$detail;
                QLog.e("TroopAppsCenter.TroopAppsViewModel", 1, "onDeleteShortcutClick result " + i3 + " err: " + str + " " + appDetail.name + " detail:" + appDetail.appId);
            }
        });
    }
}
