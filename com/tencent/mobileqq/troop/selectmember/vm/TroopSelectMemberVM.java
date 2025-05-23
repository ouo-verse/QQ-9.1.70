package com.tencent.mobileqq.troop.selectmember.vm;

import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.bugly.common.constants.Constants;
import com.tencent.common.app.AppInterface;
import com.tencent.intervideo.nowproxy.NowProxyConstants;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.api.observer.e;
import com.tencent.mobileqq.troop.selectmember.bean.c;
import com.tencent.mobileqq.troop.selectmember.bean.d;
import com.tencent.mobileqq.troop.selectmember.config.TroopSelectMemberConfig;
import com.tencent.mobileqq.troop.selectmember.inject.TroopSelectMemberInjectProvider;
import com.tencent.mobileqq.troop.selectmember.vm.a;
import com.tencent.mobileqq.troop.selectmember.vm.b;
import com.tencent.mobileqq.troop.utils.bg;
import com.tencent.mobileqq.vas.vipav.api.VipFunCallConstants;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.troopmemberlist.ITroopMemberListRepoApi;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import com.tencent.state.data.SquareJSConst;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.Dispatchers;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00bc\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010!\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u0011\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0000\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 \u00a5\u00012\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0002\u00a6\u0001B\t\u00a2\u0006\u0006\b\u00a3\u0001\u0010\u00a4\u0001J\b\u0010\u0006\u001a\u00020\u0005H\u0002J\b\u0010\b\u001a\u00020\u0007H\u0002J\b\u0010\t\u001a\u00020\u0005H\u0002J\u0016\u0010\r\u001a\u00020\u00052\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0002J\u001c\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0002J\"\u0010\u0014\u001a\u00020\u00052\u0018\u0010\u0013\u001a\u0014\u0012\u0004\u0012\u00020\u0011\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\u00120\u0010H\u0002J\b\u0010\u0015\u001a\u00020\u0005H\u0002J\b\u0010\u0016\u001a\u00020\u0005H\u0002J\b\u0010\u0017\u001a\u00020\u0005H\u0002J\u0016\u0010\u001a\u001a\u00020\u00052\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00180\nH\u0002J\b\u0010\u001c\u001a\u00020\u001bH\u0016J\b\u0010\u001e\u001a\u00020\u001dH\u0016J\u0014\u0010!\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020 0\n0\u001fH\u0016J\n\u0010#\u001a\u0004\u0018\u00010\"H\u0016J\u0016\u0010%\u001a\u00020\u00052\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00180\nH\u0016J\u0016\u0010'\u001a\u00020\u00052\f\u0010&\u001a\b\u0012\u0004\u0012\u00020 0\nH\u0016J\u0010\u0010)\u001a\u00020\u00052\u0006\u0010(\u001a\u00020\u0018H\u0016J\u0016\u0010+\u001a\u00020\u00052\f\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00110\nH\u0016J\u0018\u0010.\u001a\u0012\u0012\u0004\u0012\u00020\u00110,j\b\u0012\u0004\u0012\u00020\u0011`-H\u0016J\b\u0010/\u001a\u00020\u0005H\u0014J\u0018\u00103\u001a\u00020\u00052\b\u00101\u001a\u0004\u0018\u0001002\u0006\u00102\u001a\u00020\u001bJ\u000e\u00105\u001a\u00020\u00052\u0006\u00104\u001a\u00020\u0007J\u0012\u00107\u001a\u0004\u0018\u00010 2\u0006\u00106\u001a\u00020\u0011H\u0016J\u0010\u00108\u001a\u00020\u00052\u0006\u00106\u001a\u00020\u0011H\u0016J\u0016\u0010:\u001a\u00020\u00052\f\u00109\u001a\b\u0012\u0004\u0012\u00020 0\nH\u0016J\u0016\u0010;\u001a\u00020\u00052\f\u00109\u001a\b\u0012\u0004\u0012\u00020 0\nH\u0016J\u000e\u0010=\u001a\u00020\u00052\u0006\u0010<\u001a\u00020\u0011J\u0016\u0010>\u001a\u00020\u00052\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0016J\"\u0010@\u001a\u00020\u00052\u0018\u0010?\u001a\u0014\u0012\u0004\u0012\u00020\u0011\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\u00120\u0010H\u0016R\u0018\u00101\u001a\u0004\u0018\u0001008\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bA\u0010BR\u0016\u0010E\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bC\u0010DR\u0016\u0010H\u001a\u00020\u001b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bF\u0010GR8\u0010M\u001a&\u0012\f\u0012\n J*\u0004\u0018\u00010I0I J*\u0012\u0012\f\u0012\n J*\u0004\u0018\u00010I0I\u0018\u00010\n0\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bK\u0010LR \u0010Q\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020I0\n0N8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bO\u0010PR#\u0010V\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020I0\n0\u001f8\u0006\u00a2\u0006\f\n\u0004\bR\u0010S\u001a\u0004\bT\u0010UR\u001c\u0010X\u001a\b\u0012\u0004\u0012\u00020\u00180\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bW\u0010LR8\u0010Z\u001a&\u0012\f\u0012\n J*\u0004\u0018\u00010 0  J*\u0012\u0012\f\u0012\n J*\u0004\u0018\u00010 0 \u0018\u00010\n0\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bY\u0010LR \u0010\\\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020 0\n0N8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b[\u0010PR \u0010^\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020 0\n0\u001f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b]\u0010SR\u001b\u0010b\u001a\u00020\u00078BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b;\u0010_\u001a\u0004\b`\u0010aR \u0010e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110c0N8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bd\u0010PR#\u0010h\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110c0\u001f8\u0006\u00a2\u0006\f\n\u0004\bf\u0010S\u001a\u0004\bg\u0010UR0\u0010m\u001a\u001e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00070ij\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u0007`j8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bk\u0010lR\u001a\u0010n\u001a\b\u0012\u0004\u0012\u00020\u00070N8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b!\u0010PR\u001d\u0010p\u001a\b\u0012\u0004\u0012\u00020\u00070\u001f8\u0006\u00a2\u0006\f\n\u0004\b%\u0010S\u001a\u0004\bo\u0010UR\u001a\u0010r\u001a\b\u0012\u0004\u0012\u00020\u00070N8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bq\u0010PR\u001d\u0010u\u001a\b\u0012\u0004\u0012\u00020\u00070\u001f8\u0006\u00a2\u0006\f\n\u0004\bs\u0010S\u001a\u0004\bt\u0010UR\u001a\u0010x\u001a\b\u0012\u0004\u0012\u00020v0N8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bw\u0010PR\u001d\u0010{\u001a\b\u0012\u0004\u0012\u00020v0\u001f8\u0006\u00a2\u0006\f\n\u0004\by\u0010S\u001a\u0004\bz\u0010UR\u001a\u0010}\u001a\b\u0012\u0004\u0012\u00020\u00110N8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b|\u0010PR\u001e\u0010\u0080\u0001\u001a\b\u0012\u0004\u0012\u00020\u00110\u001f8\u0006\u00a2\u0006\f\n\u0004\b~\u0010S\u001a\u0004\b\u007f\u0010UR\u001c\u0010\u0082\u0001\u001a\b\u0012\u0004\u0012\u00020\u00070N8\u0002X\u0082\u0004\u00a2\u0006\u0007\n\u0005\b\u0081\u0001\u0010PR \u0010\u0085\u0001\u001a\b\u0012\u0004\u0012\u00020\u00070\u001f8\u0006\u00a2\u0006\u000e\n\u0005\b\u0083\u0001\u0010S\u001a\u0005\b\u0084\u0001\u0010UR\u0018\u0010\u0087\u0001\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u0086\u0001\u0010[R \u0010\u008c\u0001\u001a\u00030\u0088\u00018BX\u0082\u0084\u0002\u00a2\u0006\u000f\n\u0005\b\u0089\u0001\u0010_\u001a\u0006\b\u008a\u0001\u0010\u008b\u0001R/\u0010\u0090\u0001\u001a\u0012\u0012\u0004\u0012\u00020\u00110,j\b\u0012\u0004\u0012\u00020\u0011`-8BX\u0082\u0084\u0002\u00a2\u0006\u000f\n\u0005\b\u008d\u0001\u0010_\u001a\u0006\b\u008e\u0001\u0010\u008f\u0001R.\u0010\u0092\u0001\u001a\u0012\u0012\u0004\u0012\u00020\u00110,j\b\u0012\u0004\u0012\u00020\u0011`-8BX\u0082\u0084\u0002\u00a2\u0006\u000e\n\u0004\b>\u0010_\u001a\u0006\b\u0091\u0001\u0010\u008f\u0001R\u001f\u0010\u0096\u0001\u001a\u00020\u001d8BX\u0082\u0084\u0002\u00a2\u0006\u000f\n\u0005\b\u0093\u0001\u0010_\u001a\u0006\b\u0094\u0001\u0010\u0095\u0001R\u001a\u0010\u0099\u0001\u001a\u00030\u0097\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u0098\u0001\u0010\u0086\u0001R\u0018\u0010\u009d\u0001\u001a\u00030\u009a\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u009b\u0001\u0010\u009c\u0001R*\u0010\u009f\u0001\u001a\u00030\u0097\u00018\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0018\n\u0006\b\u009e\u0001\u0010\u0086\u0001\u001a\u0006\b\u009f\u0001\u0010\u00a0\u0001\"\u0006\b\u00a1\u0001\u0010\u00a2\u0001\u00a8\u0006\u00a7\u0001"}, d2 = {"Lcom/tencent/mobileqq/troop/selectmember/vm/TroopSelectMemberVM;", "Landroidx/lifecycle/ViewModel;", "Lcom/tencent/mobileqq/troop/selectmember/helper/a;", "Lcom/tencent/mobileqq/troop/selectmember/vm/a;", "Lcom/tencent/mobileqq/troop/selectmember/vm/b$b;", "", "E2", "", "g2", "u2", "", "Lcom/tencent/mobileqq/data/troop/TroopMemberInfo;", "troopMemberInfoList", "c2", "memberList", "b2", "", "", "", "indexedMembers", ICustomDataEditor.STRING_PARAM_2, "x2", "F2", "w2", "Lcom/tencent/mobileqq/troop/selectmember/bean/b;", "tempGroups", "B2", "Lcom/tencent/mobileqq/troop/selectmember/config/TroopSelectMemberConfig;", Constants.APK_CERTIFICATE, "Lcom/tencent/mobileqq/troop/selectmember/inject/b;", "T0", "Landroidx/lifecycle/LiveData;", "Lcom/tencent/mobileqq/troop/selectmember/bean/c;", "P", "Landroidx/lifecycle/LifecycleOwner;", "getLifecycleOwner", "groups", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "needRemoveItems", "A0", VipFunCallConstants.KEY_GROUP, ICustomDataEditor.STRING_ARRAY_PARAM_2, SquareJSConst.Params.PARAMS_UIN_LIST, "q0", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "p2", "onCleared", "Landroidx/fragment/app/FragmentActivity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "launchConfig", "t2", "firstVisiblePos", Constants.BASE_IN_PLUGIN_VERSION, "selectKey", "k2", "z2", "datas", "j1", "K", "c", "v2", "c0", "map", "u", "i", "Landroidx/fragment/app/FragmentActivity;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/lang/String;", "troopUin", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/troop/selectmember/config/TroopSelectMemberConfig;", "innerLaunchConfig", "Lcom/tencent/mobileqq/troop/selectmember/bean/a;", "kotlin.jvm.PlatformType", "D", "Ljava/util/List;", "_showDataList", "Landroidx/lifecycle/MutableLiveData;", "E", "Landroidx/lifecycle/MutableLiveData;", "_showDataListLiveData", UserInfo.SEX_FEMALE, "Landroidx/lifecycle/LiveData;", "r2", "()Landroidx/lifecycle/LiveData;", "showDataListLiveData", "G", "_showDataGroups", "H", "_selectedItemsList", "I", "_selectedInfoListLiveData", "J", "selectedInfoListLiveData", "Lkotlin/Lazy;", ICustomDataEditor.NUMBER_PARAM_2, "()I", "maxSelectSize", "", "L", "_curIndexArray", "M", "e2", "curIndexArrayLiveData", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "N", "Ljava/util/HashMap;", "charIndexPositionMap", "_curIndexPosition", "f2", "curIndexPosition", BdhLogUtil.LogTag.Tag_Req, "_curCharChooseIndex", ExifInterface.LATITUDE_SOUTH, "d2", "curCharChooseIndex", "", "T", "_deleteMemberEvent", "U", SemanticAttributes.DbSystemValues.H2, "deleteMemberEvent", "V", "_loadingText", "W", "m2", "loadingText", "X", "_loadingProgress", "Y", "l2", "loadingProgress", "Z", "loadingShowMemberCount", "Lcom/tencent/mobileqq/troop/selectmember/helper/c;", "a0", "o2", "()Lcom/tencent/mobileqq/troop/selectmember/helper/c;", "pinyinCollector", "b0", "i2", "()Ljava/util/ArrayList;", "filteredUin", "q2", "searchFilteredUinList", "d0", "j2", "()Lcom/tencent/mobileqq/troop/selectmember/inject/b;", "innerInjectProvider", "", "e0", "hadRegisterTroopObserver", "Lcom/tencent/mobileqq/troop/api/observer/e;", "f0", "Lcom/tencent/mobileqq/troop/api/observer/e;", "troopObserver", "g0", "isFirstShow", "()Z", NowProxyConstants.AccountInfoKey.A2, "(Z)V", "<init>", "()V", "h0", "a", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class TroopSelectMemberVM extends ViewModel implements com.tencent.mobileqq.troop.selectmember.helper.a, a, b.InterfaceC8767b {
    static IPatchRedirector $redirector_;

    /* renamed from: h0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: i0, reason: collision with root package name */
    @NotNull
    private static final String[] f298415i0;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private TroopSelectMemberConfig innerLaunchConfig;

    /* renamed from: D, reason: from kotlin metadata */
    private final List<com.tencent.mobileqq.troop.selectmember.bean.a> _showDataList;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<List<com.tencent.mobileqq.troop.selectmember.bean.a>> _showDataListLiveData;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final LiveData<List<com.tencent.mobileqq.troop.selectmember.bean.a>> showDataListLiveData;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private List<? extends com.tencent.mobileqq.troop.selectmember.bean.b> _showDataGroups;

    /* renamed from: H, reason: from kotlin metadata */
    private final List<c> _selectedItemsList;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<List<c>> _selectedInfoListLiveData;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    private final LiveData<List<c>> selectedInfoListLiveData;

    /* renamed from: K, reason: from kotlin metadata */
    @NotNull
    private final Lazy maxSelectSize;

    /* renamed from: L, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<String[]> _curIndexArray;

    /* renamed from: M, reason: from kotlin metadata */
    @NotNull
    private final LiveData<String[]> curIndexArrayLiveData;

    /* renamed from: N, reason: from kotlin metadata */
    @NotNull
    private final HashMap<String, Integer> charIndexPositionMap;

    /* renamed from: P, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<Integer> _curIndexPosition;

    /* renamed from: Q, reason: from kotlin metadata */
    @NotNull
    private final LiveData<Integer> curIndexPosition;

    /* renamed from: R, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<Integer> _curCharChooseIndex;

    /* renamed from: S, reason: from kotlin metadata */
    @NotNull
    private final LiveData<Integer> curCharChooseIndex;

    /* renamed from: T, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<Object> _deleteMemberEvent;

    /* renamed from: U, reason: from kotlin metadata */
    @NotNull
    private final LiveData<Object> deleteMemberEvent;

    /* renamed from: V, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<String> _loadingText;

    /* renamed from: W, reason: from kotlin metadata */
    @NotNull
    private final LiveData<String> loadingText;

    /* renamed from: X, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<Integer> _loadingProgress;

    /* renamed from: Y, reason: from kotlin metadata */
    @NotNull
    private final LiveData<Integer> loadingProgress;

    /* renamed from: Z, reason: from kotlin metadata */
    private int loadingShowMemberCount;

    /* renamed from: a0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy pinyinCollector;

    /* renamed from: b0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy filteredUin;

    /* renamed from: c0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy searchFilteredUinList;

    /* renamed from: d0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy innerInjectProvider;

    /* renamed from: e0, reason: collision with root package name and from kotlin metadata */
    private boolean hadRegisterTroopObserver;

    /* renamed from: f0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final e troopObserver;

    /* renamed from: g0, reason: collision with root package name and from kotlin metadata */
    private boolean isFirstShow;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private FragmentActivity activity;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String troopUin;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0004R\u0014\u0010\u000b\u001a\u00020\n8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR\u001a\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\n0\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/troop/selectmember/vm/TroopSelectMemberVM$a;", "", "", "FAKE_DATA_MAX_PROGRESS", "I", "FAKE_PROGRESS_DELTA", "", "FAKE_PROGRESS_UPDATE_MILLS", "J", "LOADING_FINISH_PROGRESS", "", "TAG", "Ljava/lang/String;", "", "allIndexArray", "[Ljava/lang/String;", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.troop.selectmember.vm.TroopSelectMemberVM$a, reason: from kotlin metadata */
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

    /* compiled from: P */
    @Metadata(d1 = {"\u00007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001e\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0014J>\u0010\u0011\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\u001a\u0010\u000f\u001a\u0016\u0012\u0004\u0012\u00020\u0002\u0018\u00010\rj\n\u0012\u0004\u0012\u00020\u0002\u0018\u0001`\u000e2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0002H\u0014\u00a8\u0006\u0012"}, d2 = {"com/tencent/mobileqq/troop/selectmember/vm/TroopSelectMemberVM$b", "Lcom/tencent/mobileqq/troop/api/observer/e;", "", "troopUin", "", "Lcom/tencent/mobileqq/data/troop/TroopMemberInfo;", "troopMemberInfoList", "", "onTroopMemberListFirstInited", "", "isSuccess", "", "errorCode", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", SquareJSConst.Params.PARAMS_UIN_LIST, "troopuin", "onDeleteTroopMember", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes19.dex */
    public static final class b extends e {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopSelectMemberVM.this);
            }
        }

        @Override // com.tencent.mobileqq.troop.api.observer.e
        protected void onDeleteTroopMember(boolean isSuccess, int errorCode, @Nullable ArrayList<String> uinList, @Nullable String troopuin) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, Boolean.valueOf(isSuccess), Integer.valueOf(errorCode), uinList, troopuin);
            } else if (isSuccess && Intrinsics.areEqual(troopuin, TroopSelectMemberVM.this.G1().q())) {
                TroopSelectMemberVM.this._deleteMemberEvent.postValue(Integer.valueOf(errorCode));
            }
        }

        @Override // com.tencent.mobileqq.troop.api.observer.e
        protected void onTroopMemberListFirstInited(@NotNull String troopUin, @NotNull List<? extends TroopMemberInfo> troopMemberInfoList) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) troopUin, (Object) troopMemberInfoList);
                return;
            }
            Intrinsics.checkNotNullParameter(troopUin, "troopUin");
            Intrinsics.checkNotNullParameter(troopMemberInfoList, "troopMemberInfoList");
            TroopSelectMemberVM troopSelectMemberVM = TroopSelectMemberVM.this;
            if (QLog.isColorLevel()) {
                QLog.i("TroopSelectMemberFrag.VM", 2, "[onTroopMemberListFirstInited] troopUin:" + troopUin + ", curTroopUin:" + troopSelectMemberVM.troopUin);
            }
            if (Intrinsics.areEqual(troopUin, TroopSelectMemberVM.this.troopUin)) {
                TroopSelectMemberVM.this.u2();
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(55009);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 32)) {
            redirector.redirect((short) 32);
        } else {
            INSTANCE = new Companion(null);
            f298415i0 = new String[]{ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "B", BdhLogUtil.LogTag.Tag_Conn, "D", "E", UserInfo.SEX_FEMALE, "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, BdhLogUtil.LogTag.Tag_Req, ExifInterface.LATITUDE_SOUTH, "T", "U", "V", "W", "X", "Y", "Z", "#"};
        }
    }

    public TroopSelectMemberVM() {
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        Lazy lazy4;
        Lazy lazy5;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.troopUin = "";
        this.innerLaunchConfig = new TroopSelectMemberConfig("", 0, 0, 6, null);
        List<com.tencent.mobileqq.troop.selectmember.bean.a> synchronizedList = Collections.synchronizedList(new ArrayList());
        this._showDataList = synchronizedList;
        MutableLiveData<List<com.tencent.mobileqq.troop.selectmember.bean.a>> mutableLiveData = new MutableLiveData<>(synchronizedList);
        this._showDataListLiveData = mutableLiveData;
        this.showDataListLiveData = mutableLiveData;
        this._showDataGroups = new ArrayList();
        List<c> synchronizedList2 = Collections.synchronizedList(new ArrayList());
        this._selectedItemsList = synchronizedList2;
        MutableLiveData<List<c>> mutableLiveData2 = new MutableLiveData<>(synchronizedList2);
        this._selectedInfoListLiveData = mutableLiveData2;
        this.selectedInfoListLiveData = mutableLiveData2;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<Integer>() { // from class: com.tencent.mobileqq.troop.selectmember.vm.TroopSelectMemberVM$maxSelectSize$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) TroopSelectMemberVM.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Integer invoke() {
                TroopSelectMemberConfig troopSelectMemberConfig;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (Integer) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
                troopSelectMemberConfig = TroopSelectMemberVM.this.innerLaunchConfig;
                return Integer.valueOf(troopSelectMemberConfig.f());
            }
        });
        this.maxSelectSize = lazy;
        MutableLiveData<String[]> mutableLiveData3 = new MutableLiveData<>();
        this._curIndexArray = mutableLiveData3;
        this.curIndexArrayLiveData = mutableLiveData3;
        this.charIndexPositionMap = new HashMap<>();
        MutableLiveData<Integer> mutableLiveData4 = new MutableLiveData<>();
        this._curIndexPosition = mutableLiveData4;
        this.curIndexPosition = mutableLiveData4;
        MutableLiveData<Integer> mutableLiveData5 = new MutableLiveData<>();
        this._curCharChooseIndex = mutableLiveData5;
        this.curCharChooseIndex = mutableLiveData5;
        MutableLiveData<Object> mutableLiveData6 = new MutableLiveData<>();
        this._deleteMemberEvent = mutableLiveData6;
        this.deleteMemberEvent = mutableLiveData6;
        MutableLiveData<String> mutableLiveData7 = new MutableLiveData<>();
        this._loadingText = mutableLiveData7;
        this.loadingText = mutableLiveData7;
        MutableLiveData<Integer> mutableLiveData8 = new MutableLiveData<>();
        this._loadingProgress = mutableLiveData8;
        this.loadingProgress = mutableLiveData8;
        lazy2 = LazyKt__LazyJVMKt.lazy(TroopSelectMemberVM$pinyinCollector$2.INSTANCE);
        this.pinyinCollector = lazy2;
        lazy3 = LazyKt__LazyJVMKt.lazy(new Function0<ArrayList<String>>() { // from class: com.tencent.mobileqq.troop.selectmember.vm.TroopSelectMemberVM$filteredUin$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) TroopSelectMemberVM.this);
                }
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final ArrayList<String> invoke() {
                TroopSelectMemberConfig troopSelectMemberConfig;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (ArrayList) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
                ArrayList<String> arrayList = new ArrayList<>();
                troopSelectMemberConfig = TroopSelectMemberVM.this.innerLaunchConfig;
                CollectionsKt__MutableCollectionsKt.addAll(arrayList, troopSelectMemberConfig.b());
                return arrayList;
            }
        });
        this.filteredUin = lazy3;
        lazy4 = LazyKt__LazyJVMKt.lazy(new Function0<ArrayList<String>>() { // from class: com.tencent.mobileqq.troop.selectmember.vm.TroopSelectMemberVM$searchFilteredUinList$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) TroopSelectMemberVM.this);
                }
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final ArrayList<String> invoke() {
                TroopSelectMemberConfig troopSelectMemberConfig;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (ArrayList) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
                ArrayList<String> arrayList = new ArrayList<>();
                troopSelectMemberConfig = TroopSelectMemberVM.this.innerLaunchConfig;
                CollectionsKt__MutableCollectionsKt.addAll(arrayList, troopSelectMemberConfig.b());
                return arrayList;
            }
        });
        this.searchFilteredUinList = lazy4;
        lazy5 = LazyKt__LazyJVMKt.lazy(new Function0<TroopSelectMemberInjectProvider>() { // from class: com.tencent.mobileqq.troop.selectmember.vm.TroopSelectMemberVM$innerInjectProvider$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) TroopSelectMemberVM.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final TroopSelectMemberInjectProvider invoke() {
                TroopSelectMemberConfig troopSelectMemberConfig;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (TroopSelectMemberInjectProvider) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
                troopSelectMemberConfig = TroopSelectMemberVM.this.innerLaunchConfig;
                return new TroopSelectMemberInjectProvider(troopSelectMemberConfig);
            }
        });
        this.innerInjectProvider = lazy5;
        this.troopObserver = new b();
        this.isFirstShow = true;
    }

    private final void B2(List<? extends com.tencent.mobileqq.troop.selectmember.bean.b> tempGroups) {
        boolean z16;
        boolean contains;
        if (!this.isFirstShow) {
            return;
        }
        String[] j3 = this.innerLaunchConfig.j();
        if (QLog.isDebugVersion()) {
            QLog.d("TroopSelectMemberFrag.VM", 4, "[getFirstShowConfigSelectedKey] selectedUinList.size:" + j3.length);
        }
        if (j3.length == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            return;
        }
        Iterator<T> it = tempGroups.iterator();
        while (it.hasNext()) {
            for (c cVar : ((com.tencent.mobileqq.troop.selectmember.bean.b) it.next()).a()) {
                contains = ArraysKt___ArraysKt.contains(j3, cVar.e());
                if (contains && !this._selectedItemsList.contains(cVar)) {
                    this._selectedItemsList.add(cVar);
                }
            }
        }
    }

    private final void E2() {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new TroopSelectMemberVM$updateFakeLoading$1(this, null), 3, null);
    }

    private final void F2() {
        this._showDataListLiveData.postValue(this._showDataList);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final List<TroopMemberInfo> b2(List<? extends TroopMemberInfo> memberList) {
        if (QLog.isColorLevel()) {
            QLog.i("TroopSelectMemberFrag.VM", 2, "[filterConfigData] filteredUin:" + i2());
        }
        if (i2().isEmpty()) {
            return memberList;
        }
        ArrayList arrayList = new ArrayList();
        for (Object obj : memberList) {
            if (!i2().contains(((TroopMemberInfo) obj).memberuin)) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    private final void c2(List<? extends TroopMemberInfo> troopMemberInfoList) {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new TroopSelectMemberVM$filterGroupSortData$1(this, b2(troopMemberInfoList), null), 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int g2() {
        Integer value = this._loadingProgress.getValue();
        if (value == null) {
            value = 0;
        }
        return value.intValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ArrayList<String> i2() {
        return (ArrayList) this.filteredUin.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final com.tencent.mobileqq.troop.selectmember.inject.b j2() {
        return (com.tencent.mobileqq.troop.selectmember.inject.b) this.innerInjectProvider.getValue();
    }

    private final int n2() {
        return ((Number) this.maxSelectSize.getValue()).intValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final com.tencent.mobileqq.troop.selectmember.helper.c o2() {
        return (com.tencent.mobileqq.troop.selectmember.helper.c) this.pinyinCollector.getValue();
    }

    private final ArrayList<String> q2() {
        return (ArrayList) this.searchFilteredUinList.getValue();
    }

    private final void s2(Map<String, ? extends List<TroopMemberInfo>> indexedMembers) {
        int collectionSizeOrDefault;
        ArrayList arrayList = new ArrayList();
        Iterator<String> it = indexedMembers.keySet().iterator();
        while (it.hasNext()) {
            List<TroopMemberInfo> list = indexedMembers.get(it.next());
            if (list != null) {
                Collections.sort(list, new com.tencent.mobileqq.troop.selectmember.comparator.a());
            }
        }
        this.charIndexPositionMap.clear();
        ArrayList arrayList2 = new ArrayList();
        int i3 = 0;
        for (String str : f298415i0) {
            List<TroopMemberInfo> list2 = indexedMembers.get(str);
            if (list2 != null) {
                arrayList2.add(str);
                this.charIndexPositionMap.put(str, Integer.valueOf(i3));
                i3 += list2.size() + 1;
                com.tencent.mobileqq.troop.selectmember.bean.e eVar = new com.tencent.mobileqq.troop.selectmember.bean.e(str);
                List<TroopMemberInfo> list3 = list2;
                collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list3, 10);
                ArrayList arrayList3 = new ArrayList(collectionSizeOrDefault);
                Iterator<T> it5 = list3.iterator();
                while (it5.hasNext()) {
                    arrayList3.add(new d((TroopMemberInfo) it5.next(), eVar, false, 4, null));
                    eVar = eVar;
                }
                com.tencent.mobileqq.troop.selectmember.bean.e eVar2 = eVar;
                eVar2.i(arrayList3);
                arrayList.add(eVar2);
            }
        }
        int size = arrayList2.size();
        String[] strArr = new String[size];
        for (int i16 = 0; i16 < size; i16++) {
            strArr[i16] = "";
        }
        int size2 = arrayList2.size();
        for (int i17 = 0; i17 < size2; i17++) {
            Object obj = arrayList2.get(i17);
            Intrinsics.checkNotNullExpressionValue(obj, "indexList[i]");
            strArr[i17] = (String) obj;
        }
        this._curIndexArray.postValue(strArr);
        Q(arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void u2() {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new TroopSelectMemberVM$loadTroopMember$1(this, null), 3, null);
    }

    private final void w2() {
        List<? extends com.tencent.mobileqq.troop.selectmember.bean.b> list = this._showDataGroups;
        B2(list);
        ArrayList arrayList = new ArrayList();
        for (com.tencent.mobileqq.troop.selectmember.bean.b bVar : list) {
            if (bVar.canShow()) {
                arrayList.add(bVar);
                for (c cVar : bVar.a()) {
                    cVar.h(this._selectedItemsList.contains(cVar));
                }
                if (bVar.isExpanded()) {
                    arrayList.addAll(bVar.a());
                }
            }
        }
        this._showDataList.clear();
        this._showDataList.addAll(arrayList);
        F2();
    }

    private final void x2() {
        this._selectedInfoListLiveData.postValue(this._selectedItemsList);
        F2();
    }

    @Override // com.tencent.mobileqq.troop.selectmember.vm.a
    public void A0(@NotNull List<? extends c> needRemoveItems) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) needRemoveItems);
            return;
        }
        Intrinsics.checkNotNullParameter(needRemoveItems, "needRemoveItems");
        K(needRemoveItems);
        List<? extends com.tencent.mobileqq.troop.selectmember.bean.b> list = this._showDataGroups;
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            ((com.tencent.mobileqq.troop.selectmember.bean.b) it.next()).g(needRemoveItems);
        }
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (!((com.tencent.mobileqq.troop.selectmember.bean.b) obj).a().isEmpty()) {
                arrayList.add(obj);
            }
        }
        this._showDataGroups = arrayList;
        w2();
    }

    public final void A2(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            iPatchRedirector.redirect((short) 29, (Object) this, z16);
        } else {
            this.isFirstShow = z16;
        }
    }

    public void C2(@NotNull c cVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            iPatchRedirector.redirect((short) 31, (Object) this, (Object) cVar);
        } else {
            a.C8766a.b(this, cVar);
        }
    }

    public final void D2(int firstVisiblePos) {
        Object last;
        int intValue;
        int intValue2;
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this, firstVisiblePos);
            return;
        }
        String[] value = this._curIndexArray.getValue();
        if (value == null) {
            return;
        }
        HashMap<String, Integer> hashMap = this.charIndexPositionMap;
        last = ArraysKt___ArraysKt.last(value);
        Integer num = hashMap.get(last);
        if (num != null && firstVisiblePos >= num.intValue()) {
            this._curCharChooseIndex.postValue(Integer.valueOf(value.length - 1));
            return;
        }
        int length = value.length - 1;
        int i3 = 0;
        while (i3 < length) {
            Integer num2 = this.charIndexPositionMap.get(value[i3]);
            if (num2 == null) {
                intValue = 0;
            } else {
                intValue = num2.intValue();
            }
            int i16 = i3 + 1;
            Integer num3 = this.charIndexPositionMap.get(value[i16]);
            if (num3 == null) {
                intValue2 = 0;
            } else {
                intValue2 = num3.intValue();
            }
            if (firstVisiblePos == intValue2 - 1) {
                this._curCharChooseIndex.postValue(Integer.valueOf(i3));
                return;
            }
            if (intValue <= firstVisiblePos && firstVisiblePos < intValue2) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                this._curCharChooseIndex.postValue(Integer.valueOf(i3));
                return;
            }
            i3 = i16;
        }
    }

    @Override // com.tencent.mobileqq.troop.selectmember.vm.a
    @NotNull
    public TroopSelectMemberConfig G1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (TroopSelectMemberConfig) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return this.innerLaunchConfig;
    }

    @Override // com.tencent.mobileqq.troop.selectmember.vm.a
    public void K(@NotNull List<? extends c> datas) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, (Object) this, (Object) datas);
            return;
        }
        Intrinsics.checkNotNullParameter(datas, "datas");
        this._selectedItemsList.removeAll(datas);
        x2();
    }

    @Override // com.tencent.mobileqq.troop.selectmember.vm.a
    @NotNull
    public LiveData<List<c>> P() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (LiveData) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        return this.selectedInfoListLiveData;
    }

    @Override // com.tencent.mobileqq.troop.selectmember.vm.a
    public void Q(@NotNull List<? extends com.tencent.mobileqq.troop.selectmember.bean.b> groups) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) groups);
            return;
        }
        Intrinsics.checkNotNullParameter(groups, "groups");
        this._showDataGroups = groups;
        w2();
        this._loadingProgress.postValue(100);
    }

    @Override // com.tencent.mobileqq.troop.selectmember.vm.a
    @NotNull
    public com.tencent.mobileqq.troop.selectmember.inject.b T0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (com.tencent.mobileqq.troop.selectmember.inject.b) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        return j2();
    }

    public void a2(@NotNull com.tencent.mobileqq.troop.selectmember.bean.b group) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) group);
            return;
        }
        Intrinsics.checkNotNullParameter(group, "group");
        group.c();
        w2();
    }

    @Override // com.tencent.mobileqq.troop.selectmember.vm.b.InterfaceC8767b
    public void c0(@NotNull List<? extends TroopMemberInfo> memberList) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, (Object) this, (Object) memberList);
            return;
        }
        Intrinsics.checkNotNullParameter(memberList, "memberList");
        QLog.i("TroopSelectMemberFrag.VM", 1, "[onLoadTroopMemberList] size:" + memberList.size());
        this.loadingShowMemberCount = memberList.size();
        c2(memberList);
    }

    @NotNull
    public final LiveData<Integer> d2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (LiveData) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.curCharChooseIndex;
    }

    @NotNull
    public final LiveData<String[]> e2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (LiveData) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.curIndexArrayLiveData;
    }

    @NotNull
    public final LiveData<Integer> f2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (LiveData) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.curIndexPosition;
    }

    @Override // com.tencent.mobileqq.troop.selectmember.vm.a
    @Nullable
    public LifecycleOwner getLifecycleOwner() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (LifecycleOwner) iPatchRedirector.redirect((short) 12, (Object) this);
        }
        return this.activity;
    }

    @NotNull
    public final LiveData<Object> h2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (LiveData) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.deleteMemberEvent;
    }

    @Override // com.tencent.mobileqq.troop.selectmember.vm.a
    public void j1(@NotNull List<? extends c> datas) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, (Object) this, (Object) datas);
            return;
        }
        Intrinsics.checkNotNullParameter(datas, "datas");
        boolean z16 = false;
        boolean z17 = false;
        boolean z18 = false;
        for (c cVar : datas) {
            if (!cVar.b()) {
                if (QLog.isColorLevel()) {
                    QLog.i("TroopSelectMemberFrag.VM", 2, "[onSelectMember] data can selected");
                }
            } else if (!this._selectedItemsList.contains(cVar)) {
                if (this._selectedItemsList.size() < n2()) {
                    this._selectedItemsList.add(cVar);
                    z17 = true;
                } else {
                    z18 = true;
                }
            }
        }
        if (z17) {
            x2();
        }
        if (z18) {
            if (G1().p().length() > 0) {
                z16 = true;
            }
            if (z16) {
                com.tencent.qqnt.e.k(this.activity, 1, G1().p(), 0, null, 24, null);
                return;
            }
            com.tencent.qqnt.e.k(this.activity, 1, "\u5f53\u524d\u6700\u591a\u53ea\u80fd\u9009 " + n2() + " \u4eba", 0, null, 24, null);
        }
    }

    @Nullable
    public c k2(@NotNull String selectKey) {
        Object obj;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return (c) iPatchRedirector.redirect((short) 21, (Object) this, (Object) selectKey);
        }
        Intrinsics.checkNotNullParameter(selectKey, "selectKey");
        Iterator<T> it = this._showDataGroups.iterator();
        c cVar = null;
        while (it.hasNext()) {
            Iterator<T> it5 = ((com.tencent.mobileqq.troop.selectmember.bean.b) it.next()).a().iterator();
            while (true) {
                if (it5.hasNext()) {
                    obj = it5.next();
                    if (Intrinsics.areEqual(((c) obj).e(), selectKey)) {
                        break;
                    }
                } else {
                    obj = null;
                    break;
                }
            }
            c cVar2 = (c) obj;
            if (cVar2 != null) {
                cVar = cVar2;
            }
        }
        return cVar;
    }

    @NotNull
    public final LiveData<Integer> l2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (LiveData) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return this.loadingProgress;
    }

    @NotNull
    public final LiveData<String> m2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (LiveData) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return this.loadingText;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        AppInterface e16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this);
            return;
        }
        super.onCleared();
        if (this.hadRegisterTroopObserver && (e16 = bg.e()) != null) {
            e16.removeObserver(this.troopObserver);
        }
    }

    @NotNull
    public ArrayList<String> p2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return (ArrayList) iPatchRedirector.redirect((short) 17, (Object) this);
        }
        return q2();
    }

    @Override // com.tencent.mobileqq.troop.selectmember.vm.a
    public void q0(@NotNull List<String> uinList) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, (Object) uinList);
            return;
        }
        Intrinsics.checkNotNullParameter(uinList, "uinList");
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        linkedHashSet.addAll(q2());
        linkedHashSet.addAll(uinList);
        q2().clear();
        q2().addAll(linkedHashSet);
    }

    @NotNull
    public final LiveData<List<com.tencent.mobileqq.troop.selectmember.bean.a>> r2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (LiveData) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.showDataListLiveData;
    }

    public final void t2(@Nullable FragmentActivity activity, @NotNull TroopSelectMemberConfig launchConfig) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, (Object) activity, (Object) launchConfig);
            return;
        }
        Intrinsics.checkNotNullParameter(launchConfig, "launchConfig");
        this.activity = activity;
        this.innerLaunchConfig = launchConfig;
        this.troopUin = launchConfig.q();
        boolean isTroopMemberInfoDBInited = ((ITroopMemberListRepoApi) QRoute.api(ITroopMemberListRepoApi.class)).isTroopMemberInfoDBInited(launchConfig.q());
        QLog.i("TroopSelectMemberFrag.VM", 1, "[init] troopUin:" + this.troopUin + ", dbInited:" + isTroopMemberInfoDBInited + ", launchConfig:" + launchConfig);
        if (isTroopMemberInfoDBInited) {
            u2();
        }
        if (!this.hadRegisterTroopObserver) {
            this.hadRegisterTroopObserver = true;
            AppInterface e16 = bg.e();
            if (e16 != null) {
                e16.addObserver(this.troopObserver);
            }
        }
        E2();
    }

    @Override // com.tencent.mobileqq.troop.selectmember.helper.a
    public void u(@NotNull Map<String, ? extends List<TroopMemberInfo>> map) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            iPatchRedirector.redirect((short) 27, (Object) this, (Object) map);
            return;
        }
        Intrinsics.checkNotNullParameter(map, "map");
        if (QLog.isColorLevel()) {
            QLog.i("TroopSelectMemberFrag.VM", 2, "[onPinYinCollected]");
        }
        s2(map);
    }

    public final void v2(@NotNull String c16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, (Object) this, (Object) c16);
            return;
        }
        Intrinsics.checkNotNullParameter(c16, "c");
        Integer num = this.charIndexPositionMap.get(c16);
        if (QLog.isColorLevel()) {
            QLog.i("TroopSelectMemberFrag.VM", 2, "[onCharIndexChanged]  c:" + c16 + ", position:" + num);
        }
        if (num != null) {
            this._curIndexPosition.postValue(Integer.valueOf(num.intValue()));
        }
    }

    public void y2(@NotNull c cVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            iPatchRedirector.redirect((short) 30, (Object) this, (Object) cVar);
        } else {
            a.C8766a.a(this, cVar);
        }
    }

    public void z2(@NotNull String selectKey) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this, (Object) selectKey);
            return;
        }
        Intrinsics.checkNotNullParameter(selectKey, "selectKey");
        c k26 = k2(selectKey);
        if (k26 != null) {
            y2(k26);
        }
    }
}
