package com.tencent.mobileqq.troop.troopidentity;

import android.os.Bundle;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.biz.richframework.part.BaseViewModel;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.api.troopmemberlist.ITroopMemberListActivityApi;
import com.tencent.mobileqq.troop.memberlevel.api.ITroopMemberLevelUtilsApi;
import com.tencent.mobileqq.troop.troopidentity.util.TroopIdentityHonorUtil;
import com.tencent.mobileqq.troop.troopidentity.util.TroopIdentityHonorUtilKt;
import com.tencent.mobileqq.troop.troopidentity.view.c;
import com.tencent.mobileqq.troop.utils.bg;
import com.tencent.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.api.s;
import com.tencent.qqnt.kernel.nativeinterface.GetIdentityListReq;
import com.tencent.qqnt.kernel.nativeinterface.GetIdentityListRsp;
import com.tencent.qqnt.kernel.nativeinterface.GroupIdentityAppTag;
import com.tencent.qqnt.kernel.nativeinterface.GroupIdentityInteractionTag;
import com.tencent.qqnt.kernel.nativeinterface.GroupIdentityTitleInfo;
import com.tencent.qqnt.kernel.nativeinterface.GroupIdentityUserInfo;
import com.tencent.qqnt.kernel.nativeinterface.IGetIdentityListCallback;
import com.tencent.qqnt.kernel.nativeinterface.IOperateCallback;
import com.tencent.qqnt.kernel.nativeinterface.SetIdentityTitleInfoReq;
import com.tencent.qqnt.kernelpublic.nativeinterface.MemberRole;
import com.tencent.qqnt.troop.ITroopInfoRepoApi;
import com.tencent.qqnt.troopmemberlist.ITroopMemberExtInfoRepoApi;
import com.tencent.qqnt.troopmemberlist.ITroopMemberListRepoApi;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b0\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 s2\u00020\u0001:\u0001tB\u0007\u00a2\u0006\u0004\bq\u0010rJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\u001c\u0010\u000b\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0002J\b\u0010\f\u001a\u00020\u0004H\u0002J\u0010\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rH\u0002J\b\u0010\u0010\u001a\u00020\u0004H\u0002J\u0010\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0011H\u0002J\b\u0010\u0014\u001a\u00020\u0004H\u0002J\b\u0010\u0016\u001a\u00020\u0015H\u0016J\u000e\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0018\u001a\u00020\u0004J\u000e\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u0019J\u0010\u0010\u001d\u001a\u00020\u00042\b\u0010\u001c\u001a\u0004\u0018\u00010\u0011J\u0010\u0010\u001f\u001a\u00020\u00192\b\u0010\u001e\u001a\u0004\u0018\u00010\u0015J\u0006\u0010!\u001a\u00020 J\u0010\u0010#\u001a\u00020\u00042\b\u0010\"\u001a\u0004\u0018\u00010\u0015J\b\u0010%\u001a\u0004\u0018\u00010$J\u0010\u0010(\u001a\u00020\u00042\b\u0010'\u001a\u0004\u0018\u00010&J\b\u0010)\u001a\u0004\u0018\u00010&J\u0010\u0010,\u001a\u00020\u00042\b\u0010+\u001a\u0004\u0018\u00010*J\u0006\u0010-\u001a\u00020\u0004J\u0006\u0010.\u001a\u00020\u0004R\"\u00105\u001a\u00020\u00158\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b/\u00100\u001a\u0004\b1\u00102\"\u0004\b3\u00104R$\u0010;\u001a\u00020 2\u0006\u00106\u001a\u00020 8\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b7\u00108\u001a\u0004\b9\u0010:R$\u0010>\u001a\u00020\u00152\u0006\u00106\u001a\u00020\u00158\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b<\u00100\u001a\u0004\b=\u00102R$\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b?\u0010@\u001a\u0004\bA\u0010B\"\u0004\bC\u0010DR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bE\u0010F\u001a\u0004\bG\u0010H\"\u0004\bI\u0010JR$\u0010Q\u001a\u0004\u0018\u00010*8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bK\u0010L\u001a\u0004\bM\u0010N\"\u0004\bO\u0010PR\u0016\u0010T\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bR\u0010SR\u0016\u0010V\u001a\u00020 8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bU\u00108R\"\u0010Z\u001a\u00020 8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bS\u00108\u001a\u0004\bW\u0010:\"\u0004\bX\u0010YR\u001a\u0010^\u001a\b\u0012\u0004\u0012\u00020\r0[8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\\\u0010]R\u001d\u0010d\u001a\b\u0012\u0004\u0012\u00020\r0_8\u0006\u00a2\u0006\f\n\u0004\b`\u0010a\u001a\u0004\bb\u0010cR\u001a\u0010g\u001a\b\u0012\u0004\u0012\u00020e0[8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bf\u0010]R\u001d\u0010j\u001a\b\u0012\u0004\u0012\u00020e0_8\u0006\u00a2\u0006\f\n\u0004\bh\u0010a\u001a\u0004\bi\u0010cR\u001b\u0010p\u001a\u00020k8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\bl\u0010m\u001a\u0004\bn\u0010o\u00a8\u0006u"}, d2 = {"Lcom/tencent/mobileqq/troop/troopidentity/TroopIdentityIconVM;", "Lcom/tencent/biz/richframework/part/BaseViewModel;", "Landroid/os/Bundle;", "bundle", "", "j2", "S1", "Lcom/tencent/mobileqq/data/troop/TroopInfo;", "troopInfo", "Lcom/tencent/mobileqq/data/troop/TroopMemberInfo;", "troopMemberInfo", "b2", "Q1", "Lcom/tencent/qqnt/kernel/nativeinterface/GetIdentityListRsp;", "rsp", "m2", "P1", "Lcom/tencent/qqnt/kernel/nativeinterface/GroupIdentityTitleInfo;", "curSelectedTitle", "u2", ICustomDataEditor.STRING_PARAM_2, "", "getLogTag", "init", "U1", "", "richFlag", "r2", "titleInfo", "p2", "titleId", "e2", "", "l2", "selectedTagId", "v2", "Lcom/tencent/qqnt/kernel/nativeinterface/GroupIdentityInteractionTag;", "d2", "Lcom/tencent/qqnt/kernel/nativeinterface/GroupIdentityAppTag;", "resultAppTag", "o2", "W1", "Lcom/tencent/mobileqq/troop/troopmemberlevel/a;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "i2", "onResume", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "i", "Ljava/lang/String;", "g2", "()Ljava/lang/String;", "setTroopUin", "(Ljava/lang/String;)V", "troopUin", "<set-?>", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Z", "k2", "()Z", "isHost", BdhLogUtil.LogTag.Tag_Conn, "c2", "memberUin", "D", "Lcom/tencent/mobileqq/data/troop/TroopInfo;", "getTroopInfo", "()Lcom/tencent/mobileqq/data/troop/TroopInfo;", "setTroopInfo", "(Lcom/tencent/mobileqq/data/troop/TroopInfo;)V", "E", "Lcom/tencent/mobileqq/data/troop/TroopMemberInfo;", "f2", "()Lcom/tencent/mobileqq/data/troop/TroopMemberInfo;", "setTroopMemberInfo", "(Lcom/tencent/mobileqq/data/troop/TroopMemberInfo;)V", UserInfo.SEX_FEMALE, "Lcom/tencent/mobileqq/troop/troopmemberlevel/a;", ICustomDataEditor.STRING_ARRAY_PARAM_2, "()Lcom/tencent/mobileqq/troop/troopmemberlevel/a;", "setMemberRankItem", "(Lcom/tencent/mobileqq/troop/troopmemberlevel/a;)V", "memberRankItem", "G", "I", "newRichFlag", "H", "needRefreshRankItemUI", "getNeedRefreshPageData", ICustomDataEditor.NUMBER_PARAM_2, "(Z)V", "needRefreshPageData", "Landroidx/lifecycle/MutableLiveData;", "J", "Landroidx/lifecycle/MutableLiveData;", "_identityInfo", "Landroidx/lifecycle/LiveData;", "K", "Landroidx/lifecycle/LiveData;", "Z1", "()Landroidx/lifecycle/LiveData;", "identityInfoLiveData", "Lcom/tencent/mobileqq/troop/troopidentity/view/c;", "L", "_uiState", "M", SemanticAttributes.DbSystemValues.H2, "uiStateLiveData", "Lcom/tencent/mobileqq/troop/troopidentity/util/a;", "N", "Lkotlin/Lazy;", "X1", "()Lcom/tencent/mobileqq/troop/troopidentity/util/a;", "dtReporter", "<init>", "()V", "P", "a", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class TroopIdentityIconVM extends BaseViewModel {
    static IPatchRedirector $redirector_;

    /* renamed from: P, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private String memberUin;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private TroopInfo troopInfo;

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private TroopMemberInfo troopMemberInfo;

    /* renamed from: F, reason: from kotlin metadata */
    @Nullable
    private com.tencent.mobileqq.troop.troopmemberlevel.a memberRankItem;

    /* renamed from: G, reason: from kotlin metadata */
    private int newRichFlag;

    /* renamed from: H, reason: from kotlin metadata */
    private boolean needRefreshRankItemUI;

    /* renamed from: I, reason: from kotlin metadata */
    private boolean needRefreshPageData;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<GetIdentityListRsp> _identityInfo;

    /* renamed from: K, reason: from kotlin metadata */
    @NotNull
    private final LiveData<GetIdentityListRsp> identityInfoLiveData;

    /* renamed from: L, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<com.tencent.mobileqq.troop.troopidentity.view.c> _uiState;

    /* renamed from: M, reason: from kotlin metadata */
    @NotNull
    private final LiveData<com.tencent.mobileqq.troop.troopidentity.view.c> uiStateLiveData;

    /* renamed from: N, reason: from kotlin metadata */
    @NotNull
    private final Lazy dtReporter;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String troopUin;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private boolean isHost;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/troop/troopidentity/TroopIdentityIconVM$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.troop.troopidentity.TroopIdentityIconVM$a, reason: from kotlin metadata */
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
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes19.dex */
    public /* synthetic */ class b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f300323a;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(57707);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 1)) {
                redirector.redirect((short) 1);
                return;
            }
            int[] iArr = new int[MemberRole.values().length];
            try {
                iArr[MemberRole.OWNER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[MemberRole.ADMIN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f300323a = iArr;
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(57715);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 31)) {
            redirector.redirect((short) 31);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public TroopIdentityIconVM() {
        Lazy lazy;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.troopUin = "";
        this.memberUin = "";
        this.newRichFlag = -1;
        MutableLiveData<GetIdentityListRsp> mutableLiveData = new MutableLiveData<>();
        this._identityInfo = mutableLiveData;
        this.identityInfoLiveData = mutableLiveData;
        MutableLiveData<com.tencent.mobileqq.troop.troopidentity.view.c> mutableLiveData2 = new MutableLiveData<>();
        this._uiState = mutableLiveData2;
        this.uiStateLiveData = mutableLiveData2;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<com.tencent.mobileqq.troop.troopidentity.util.a>() { // from class: com.tencent.mobileqq.troop.troopidentity.TroopIdentityIconVM$dtReporter$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) TroopIdentityIconVM.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final com.tencent.mobileqq.troop.troopidentity.util.a invoke() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                return (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) ? new com.tencent.mobileqq.troop.troopidentity.util.a("pg_group_identity_display", com.tencent.mobileqq.troop.troopidentity.util.a.INSTANCE.a(TroopIdentityIconVM.this.g2(), TroopIdentityIconVM.this.k2())) : (com.tencent.mobileqq.troop.troopidentity.util.a) iPatchRedirector2.redirect((short) 2, (Object) this);
            }
        });
        this.dtReporter = lazy;
    }

    private final void P1() {
        if (com.tencent.mobileqq.troop.config.b.f294691a.h("9170_troop_identity_member_fetch_limit", false)) {
            return;
        }
        ((ITroopMemberExtInfoRepoApi) QRoute.api(ITroopMemberExtInfoRepoApi.class)).fetchTroopMemberGameInfo(this.troopUin, this.memberUin, null, new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.troop.troopidentity.TroopIdentityIconVM$fetchAppIconInfo$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopIdentityIconVM.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z16) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, z16);
                    return;
                }
                QLog.i("TroopIdentityIconVM", 1, "[fetchTroopMemberGameInfo] troopUin = " + TroopIdentityIconVM.this.g2() + " memberUin = " + TroopIdentityIconVM.this.c2() + " isSuccess = " + z16);
            }
        });
    }

    private final void Q1() {
        Long longOrNull;
        Long longOrNull2;
        if (TroopIdentityHonorUtil.f300410a.g(false)) {
            this._uiState.postValue(new c.e(true));
            return;
        }
        GetIdentityListReq getIdentityListReq = new GetIdentityListReq();
        longOrNull = StringsKt__StringNumberConversionsKt.toLongOrNull(this.troopUin);
        if (longOrNull != null) {
            getIdentityListReq.groupCode = longOrNull.longValue();
            longOrNull2 = StringsKt__StringNumberConversionsKt.toLongOrNull(this.memberUin);
            if (longOrNull2 != null) {
                getIdentityListReq.memberUin = longOrNull2.longValue();
                s c16 = com.tencent.qqnt.msg.f.c();
                if (c16 != null) {
                    c16.getIdentityList(getIdentityListReq, new IGetIdentityListCallback() { // from class: com.tencent.mobileqq.troop.troopidentity.i
                        @Override // com.tencent.qqnt.kernel.nativeinterface.IGetIdentityListCallback
                        public final void onResult(int i3, String str, GetIdentityListRsp getIdentityListRsp) {
                            TroopIdentityIconVM.R1(TroopIdentityIconVM.this, i3, str, getIdentityListRsp);
                        }
                    });
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void R1(TroopIdentityIconVM this$0, int i3, String str, GetIdentityListRsp getIdentityListRsp) {
        String str2;
        String str3;
        String str4;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        String str5 = this$0.troopUin;
        String str6 = this$0.memberUin;
        GroupIdentityUserInfo groupIdentityUserInfo = getIdentityListRsp.userInfo;
        Object obj = null;
        if (groupIdentityUserInfo != null) {
            str2 = TroopIdentityHonorUtilKt.b(groupIdentityUserInfo);
        } else {
            str2 = null;
        }
        ArrayList<GroupIdentityTitleInfo> arrayList = getIdentityListRsp.titles;
        if (arrayList != null) {
            str3 = TroopIdentityHonorUtilKt.b(arrayList);
        } else {
            str3 = null;
        }
        GroupIdentityAppTag groupIdentityAppTag = getIdentityListRsp.appTag;
        if (groupIdentityAppTag != null) {
            str4 = TroopIdentityHonorUtilKt.b(groupIdentityAppTag);
        } else {
            str4 = null;
        }
        QLog.i("TroopIdentityIconVM", 1, "[fetchIdentityInfo] troopUin = " + str5 + " memberUin = " + str6 + " errCode = " + i3 + " errMsg = " + str + " userInfo = " + str2 + " titles = " + str3 + " appTag = " + str4 + " ");
        if (com.tencent.qqnt.e.d(i3)) {
            this$0.m2(getIdentityListRsp);
            this$0._identityInfo.postValue(getIdentityListRsp);
            com.tencent.mobileqq.troop.troopidentity.util.b.f300417a.a(this$0.troopUin, this$0.memberUin, getIdentityListRsp);
            ArrayList<GroupIdentityTitleInfo> arrayList2 = getIdentityListRsp.titles;
            if (arrayList2 != null) {
                Iterator<T> it = arrayList2.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    Object next = it.next();
                    GroupIdentityTitleInfo groupIdentityTitleInfo = (GroupIdentityTitleInfo) next;
                    boolean z16 = false;
                    if (groupIdentityTitleInfo != null && groupIdentityTitleInfo.isSet) {
                        z16 = true;
                    }
                    if (z16) {
                        obj = next;
                        break;
                    }
                }
                GroupIdentityTitleInfo groupIdentityTitleInfo2 = (GroupIdentityTitleInfo) obj;
                if (groupIdentityTitleInfo2 != null) {
                    this$0.u2(groupIdentityTitleInfo2);
                    this$0.s2();
                }
            }
        }
    }

    private final void S1() {
        this.troopInfo = ((ITroopInfoRepoApi) QRoute.api(ITroopInfoRepoApi.class)).getTroopInfoFromCache(this.troopUin);
        TroopMemberInfo troopMemberWithExtFromCacheOrFetchAsync = ((ITroopMemberListRepoApi) QRoute.api(ITroopMemberListRepoApi.class)).getTroopMemberWithExtFromCacheOrFetchAsync(this.troopUin, this.memberUin, null, "TroopIdentityIconVM", new com.tencent.qqnt.troopmemberlist.g() { // from class: com.tencent.mobileqq.troop.troopidentity.h
            @Override // com.tencent.qqnt.troopmemberlist.g
            public final void a(TroopMemberInfo troopMemberInfo) {
                TroopIdentityIconVM.T1(TroopIdentityIconVM.this, troopMemberInfo);
            }
        });
        this.troopMemberInfo = troopMemberWithExtFromCacheOrFetchAsync;
        b2(this.troopInfo, troopMemberWithExtFromCacheOrFetchAsync);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void T1(TroopIdentityIconVM this$0, TroopMemberInfo troopMemberInfo) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.troopMemberInfo = troopMemberInfo;
        this$0.b2(this$0.troopInfo, troopMemberInfo);
    }

    private final void b2(TroopInfo troopInfo, TroopMemberInfo troopMemberInfo) {
        String str;
        if (troopInfo != null && troopMemberInfo != null) {
            com.tencent.mobileqq.troop.troopmemberlevel.a troopMemberRankItem = ((ITroopMemberLevelUtilsApi) QRoute.api(ITroopMemberLevelUtilsApi.class)).getTroopMemberRankItem(troopInfo, troopMemberInfo);
            this.memberRankItem = troopMemberRankItem;
            if (troopMemberRankItem != null) {
                str = TroopIdentityHonorUtilKt.b(troopMemberRankItem);
            } else {
                str = null;
            }
            QLog.i("TroopIdentityIconVM", 1, "[getMemberRankItem] troopMemberRankItem = " + str);
            com.tencent.mobileqq.troop.troopmemberlevel.a aVar = this.memberRankItem;
            if (aVar == null) {
                return;
            }
            if (aVar != null) {
                aVar.f300596g = true;
            }
            s2();
        }
    }

    private final void j2(Bundle bundle) {
        String string = bundle.getString("troop_uin", "");
        Intrinsics.checkNotNullExpressionValue(string, "bundle.getString(AppConstants.Key.TROOP_UIN, \"\")");
        this.troopUin = string;
        String currentAccountUin = MobileQQ.sMobileQQ.peekAppRuntime().getCurrentAccountUin();
        String string2 = bundle.getString("member_uin", currentAccountUin);
        Intrinsics.checkNotNullExpressionValue(string2, "bundle.getString(TroopId\u2026t.MEMBER_UIN, currentUin)");
        this.memberUin = string2;
        boolean areEqual = Intrinsics.areEqual(string2, currentAccountUin);
        this.isHost = areEqual;
        QLog.i("TroopIdentityIconVM", 1, "[initParams] troopUin = " + this.troopUin + " memberUin = " + this.memberUin + " isHost = " + areEqual);
    }

    private final void m2(GetIdentityListRsp rsp) {
        if (!this.isHost) {
            bg bgVar = bg.f302144a;
            ArrayList<GroupIdentityTitleInfo> arrayList = rsp.titles;
            Intrinsics.checkNotNullExpressionValue(arrayList, "rsp.titles");
            ArrayList arrayList2 = new ArrayList();
            for (Object obj : arrayList) {
                if (((GroupIdentityTitleInfo) obj).isSet) {
                    arrayList2.add(obj);
                }
            }
            rsp.titles = bgVar.n(arrayList2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q2(GroupIdentityTitleInfo groupIdentityTitleInfo, ArrayList arrayList, TroopIdentityIconVM this$0, int i3, String str) {
        Integer intOrNull;
        int i16;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QLog.i("TroopIdentityIconVM", 1, "[updateTitleSwitch] titleInfo = " + TroopIdentityHonorUtilKt.b(groupIdentityTitleInfo) + " result = " + i3 + " errMsg = " + str);
        if (com.tencent.qqnt.e.d(i3)) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                GroupIdentityTitleInfo groupIdentityTitleInfo2 = (GroupIdentityTitleInfo) it.next();
                groupIdentityTitleInfo2.isSet = Intrinsics.areEqual(groupIdentityTitleInfo2.titleId, groupIdentityTitleInfo.titleId);
            }
            this$0.u2(groupIdentityTitleInfo);
            this$0._uiState.postValue(new c.d(arrayList, this$0.memberRankItem));
            ITroopMemberExtInfoRepoApi iTroopMemberExtInfoRepoApi = (ITroopMemberExtInfoRepoApi) QRoute.api(ITroopMemberExtInfoRepoApi.class);
            String str2 = this$0.troopUin;
            String str3 = this$0.memberUin;
            String str4 = groupIdentityTitleInfo.titleId;
            Intrinsics.checkNotNullExpressionValue(str4, "titleInfo.titleId");
            intOrNull = StringsKt__StringNumberConversionsKt.toIntOrNull(str4);
            if (intOrNull != null) {
                i16 = intOrNull.intValue();
            } else {
                i16 = 0;
            }
            iTroopMemberExtInfoRepoApi.updateTroopMemberSpecialTitle(str2, str3, i16);
        }
    }

    private final void s2() {
        bg.k(new Runnable() { // from class: com.tencent.mobileqq.troop.troopidentity.g
            @Override // java.lang.Runnable
            public final void run() {
                TroopIdentityIconVM.t2(TroopIdentityIconVM.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void t2(TroopIdentityIconVM this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.memberRankItem != null && this$0._identityInfo.getValue() != null) {
            this$0._uiState.postValue(new c.C8816c(this$0.memberRankItem));
        }
    }

    private final void u2(GroupIdentityTitleInfo curSelectedTitle) {
        com.tencent.mobileqq.troop.troopmemberlevel.a aVar = this.memberRankItem;
        if (aVar != null) {
            aVar.f300590a = e2(curSelectedTitle.titleId);
            aVar.f300592c = curSelectedTitle.name;
            aVar.f300593d = ((ITroopMemberLevelUtilsApi) QRoute.api(ITroopMemberLevelUtilsApi.class)).getRankGradientColorByRankId(aVar.f300590a);
            aVar.f300597h = ((ITroopMemberLevelUtilsApi) QRoute.api(ITroopMemberLevelUtilsApi.class)).getRankTextColor(aVar.f300590a);
            i2(aVar);
        }
    }

    public final void U1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this);
            return;
        }
        S1();
        Q1();
        P1();
    }

    @Nullable
    public final GroupIdentityAppTag W1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            return (GroupIdentityAppTag) iPatchRedirector.redirect((short) 27, (Object) this);
        }
        GetIdentityListRsp value = this._identityInfo.getValue();
        if (value != null) {
            return value.appTag;
        }
        return null;
    }

    @NotNull
    public final com.tencent.mobileqq.troop.troopidentity.util.a X1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return (com.tencent.mobileqq.troop.troopidentity.util.a) iPatchRedirector.redirect((short) 17, (Object) this);
        }
        return (com.tencent.mobileqq.troop.troopidentity.util.a) this.dtReporter.getValue();
    }

    @NotNull
    public final LiveData<GetIdentityListRsp> Z1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return (LiveData) iPatchRedirector.redirect((short) 15, (Object) this);
        }
        return this.identityInfoLiveData;
    }

    @Nullable
    public final com.tencent.mobileqq.troop.troopmemberlevel.a a2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (com.tencent.mobileqq.troop.troopmemberlevel.a) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        return this.memberRankItem;
    }

    @NotNull
    public final String c2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.memberUin;
    }

    @Nullable
    public final GroupIdentityInteractionTag d2() {
        ArrayList arrayList;
        Object firstOrNull;
        ArrayList<GroupIdentityInteractionTag> arrayList2;
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            return (GroupIdentityInteractionTag) iPatchRedirector.redirect((short) 25, (Object) this);
        }
        GetIdentityListRsp value = this.identityInfoLiveData.getValue();
        if (value != null && (arrayList2 = value.interactionTags) != null) {
            arrayList = new ArrayList();
            for (Object obj : arrayList2) {
                GroupIdentityInteractionTag groupIdentityInteractionTag = (GroupIdentityInteractionTag) obj;
                if (groupIdentityInteractionTag.isObtained && groupIdentityInteractionTag.isSet) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    arrayList.add(obj);
                }
            }
        } else {
            arrayList = null;
        }
        if (arrayList != null) {
            firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) arrayList);
            return (GroupIdentityInteractionTag) firstOrNull;
        }
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x0019, code lost:
    
        r4 = kotlin.text.StringsKt__StringNumberConversionsKt.toIntOrNull(r4);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final int e2(@Nullable String titleId) {
        int i3;
        MemberRole memberRole;
        int i16;
        Integer intOrNull;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return ((Integer) iPatchRedirector.redirect((short) 22, (Object) this, (Object) titleId)).intValue();
        }
        if (titleId != null && intOrNull != null) {
            i3 = intOrNull.intValue();
        } else {
            i3 = 0;
        }
        TroopMemberInfo troopMemberInfo = this.troopMemberInfo;
        if (troopMemberInfo == null) {
            return i3;
        }
        if (troopMemberInfo != null) {
            memberRole = troopMemberInfo.role;
        } else {
            memberRole = null;
        }
        if (memberRole == null) {
            i16 = -1;
        } else {
            i16 = b.f300323a[memberRole.ordinal()];
        }
        if (i16 != 1) {
            if (i16 == 2) {
                return 301;
            }
            return i3;
        }
        return 300;
    }

    @Nullable
    public final TroopMemberInfo f2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (TroopMemberInfo) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return this.troopMemberInfo;
    }

    @NotNull
    public final String g2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.troopUin;
    }

    @Override // com.tencent.biz.richframework.part.BaseViewModel
    @NotNull
    /* renamed from: getLogTag */
    public String getTAG() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return "TroopIdentityIconVM";
    }

    @NotNull
    public final LiveData<com.tencent.mobileqq.troop.troopidentity.view.c> h2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return (LiveData) iPatchRedirector.redirect((short) 16, (Object) this);
        }
        return this.uiStateLiveData;
    }

    public final void i2(@Nullable com.tencent.mobileqq.troop.troopmemberlevel.a item) {
        Unit unit;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            iPatchRedirector.redirect((short) 28, (Object) this, (Object) item);
            return;
        }
        if (item == null) {
            return;
        }
        if (this.newRichFlag == -1) {
            TroopMemberInfo troopMemberInfo = this.troopMemberInfo;
            if (troopMemberInfo != null) {
                this.newRichFlag = com.tencent.mobileqq.troop.honor.util.a.h(4, troopMemberInfo.mHonorRichFlag);
                unit = Unit.INSTANCE;
            } else {
                unit = null;
            }
            if (unit == null) {
                return;
            }
        }
        ((ITroopMemberListActivityApi) QRoute.api(ITroopMemberListActivityApi.class)).handleRichLevelWithParsedTag(item.f300590a, this.newRichFlag, item);
    }

    public final void init(@NotNull Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, (Object) bundle);
            return;
        }
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        j2(bundle);
        U1();
    }

    public final boolean k2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
        }
        return this.isHost;
    }

    public final boolean l2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return ((Boolean) iPatchRedirector.redirect((short) 23, (Object) this)).booleanValue();
        }
        if (this.troopInfo == null) {
            S1();
        }
        TroopInfo troopInfo = this.troopInfo;
        if (troopInfo != null) {
            return troopInfo.isOwnerOrAdmin();
        }
        return false;
    }

    public final void n2(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, z16);
        } else {
            this.needRefreshPageData = z16;
        }
    }

    public final void o2(@Nullable GroupIdentityAppTag resultAppTag) {
        String str;
        String str2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, (Object) this, (Object) resultAppTag);
            return;
        }
        if (resultAppTag != null && (str = resultAppTag.appTagId) != null) {
            GroupIdentityAppTag W1 = W1();
            if (W1 != null) {
                str2 = W1.appTagId;
            } else {
                str2 = null;
            }
            if (Intrinsics.areEqual(str, str2)) {
                GetIdentityListRsp value = this._identityInfo.getValue();
                if (value != null) {
                    value.appTag = resultAppTag;
                }
                this._uiState.postValue(new c.a(resultAppTag.status, resultAppTag));
            }
        }
    }

    public final void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            iPatchRedirector.redirect((short) 30, (Object) this);
        } else {
            com.tencent.mobileqq.troop.troopidentity.util.b.f300417a.c();
        }
    }

    public final void onResume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            iPatchRedirector.redirect((short) 29, (Object) this);
            return;
        }
        if (this.needRefreshRankItemUI) {
            this.needRefreshRankItemUI = false;
            s2();
        }
        if (this.needRefreshPageData) {
            this.needRefreshPageData = false;
            Q1();
            S1();
        }
    }

    public final void p2(@Nullable final GroupIdentityTitleInfo titleInfo) {
        Long longOrNull;
        long j3;
        Integer intOrNull;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this, (Object) titleInfo);
            return;
        }
        int i3 = 0;
        boolean z16 = true;
        final ArrayList<GroupIdentityTitleInfo> arrayList = null;
        if (TroopIdentityHonorUtil.h(TroopIdentityHonorUtil.f300410a, false, 1, null)) {
            return;
        }
        GetIdentityListRsp value = this.identityInfoLiveData.getValue();
        if (value != null) {
            arrayList = value.titles;
        }
        if (titleInfo != null && !titleInfo.isSet) {
            if (arrayList != null && !arrayList.isEmpty()) {
                z16 = false;
            }
            if (!z16) {
                SetIdentityTitleInfoReq setIdentityTitleInfoReq = new SetIdentityTitleInfoReq();
                longOrNull = StringsKt__StringNumberConversionsKt.toLongOrNull(this.troopUin);
                if (longOrNull != null) {
                    j3 = longOrNull.longValue();
                } else {
                    j3 = 0;
                }
                setIdentityTitleInfoReq.groupId = j3;
                String str = titleInfo.titleId;
                Intrinsics.checkNotNullExpressionValue(str, "titleInfo.titleId");
                intOrNull = StringsKt__StringNumberConversionsKt.toIntOrNull(str);
                if (intOrNull != null) {
                    i3 = intOrNull.intValue();
                }
                setIdentityTitleInfoReq.titleId = i3;
                s c16 = com.tencent.qqnt.msg.f.c();
                if (c16 != null) {
                    c16.setIdentityTitleInfo(setIdentityTitleInfoReq, new IOperateCallback() { // from class: com.tencent.mobileqq.troop.troopidentity.j
                        @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
                        public final void onResult(int i16, String str2) {
                            TroopIdentityIconVM.q2(GroupIdentityTitleInfo.this, arrayList, this, i16, str2);
                        }
                    });
                }
            }
        }
    }

    public final void r2(int richFlag) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this, richFlag);
            return;
        }
        this.newRichFlag = richFlag;
        com.tencent.mobileqq.troop.troopidentity.util.b.f300417a.b(richFlag);
        i2(this.memberRankItem);
        this.needRefreshRankItemUI = true;
    }

    public final void v2(@Nullable String selectedTagId) {
        ArrayList<GroupIdentityInteractionTag> arrayList;
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, (Object) this, (Object) selectedTagId);
            return;
        }
        GetIdentityListRsp value = this.identityInfoLiveData.getValue();
        GroupIdentityInteractionTag groupIdentityInteractionTag = null;
        if (value != null && (arrayList = value.interactionTags) != null) {
            for (GroupIdentityInteractionTag groupIdentityInteractionTag2 : arrayList) {
                boolean z17 = false;
                if (selectedTagId != null && selectedTagId.length() != 0) {
                    z16 = false;
                } else {
                    z16 = true;
                }
                if (!z16 && Intrinsics.areEqual(groupIdentityInteractionTag2.interactionTagId, selectedTagId)) {
                    z17 = true;
                }
                groupIdentityInteractionTag2.isSet = z17;
                if (groupIdentityInteractionTag2.isObtained && z17) {
                    groupIdentityInteractionTag = groupIdentityInteractionTag2;
                }
            }
        }
        this._uiState.postValue(new c.b(groupIdentityInteractionTag));
    }
}
