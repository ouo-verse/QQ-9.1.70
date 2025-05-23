package com.tencent.mobileqq.troop.troopidentity;

import android.os.Bundle;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.richframework.part.BaseViewModel;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.troopidentity.data.ParcelIdentityInteractionTag;
import com.tencent.mobileqq.troop.troopidentity.util.TroopIdentityHonorUtil;
import com.tencent.mobileqq.troop.troopidentity.util.TroopIdentityHonorUtilKt;
import com.tencent.mobileqq.troop.troopidentity.view.c;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.api.s;
import com.tencent.qqnt.kernel.nativeinterface.GroupIdentityInteractionTag;
import com.tencent.qqnt.kernel.nativeinterface.IOperateCallback;
import com.tencent.qqnt.kernel.nativeinterface.SetIdentityInteractionTagReq;
import com.tencent.qqnt.troopmemberlist.ITroopMemberExtInfoRepoApi;
import com.tencent.qqnt.troopmemberlist.ITroopMemberListRepoApi;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import tencent.im.troop.honor.troop_honor$GroupUserCardHonor;

/* compiled from: P */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 82\u00020\u0001:\u00019B\u0007\u00a2\u0006\u0004\b6\u00107J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J \u0010\f\u001a\u00020\u00062\u0016\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\t0\bj\b\u0012\u0004\u0012\u00020\t`\nH\u0002J\u0014\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000e0\rH\u0002J\b\u0010\u0010\u001a\u00020\u0004H\u0016J\u000e\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u0011J\u0016\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0014R\"\u0010\u001d\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u0016\u0010\u001f\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u0018R*\u0010#\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00140\bj\b\u0012\u0004\u0012\u00020\u0014`\n0 8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b!\u0010\"R-\u0010)\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00140\bj\b\u0012\u0004\u0012\u00020\u0014`\n0$8\u0006\u00a2\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(R\u001a\u0010,\u001a\b\u0012\u0004\u0012\u00020*0 8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b+\u0010\"R\u001d\u0010/\u001a\b\u0012\u0004\u0012\u00020*0$8\u0006\u00a2\u0006\f\n\u0004\b-\u0010&\u001a\u0004\b.\u0010(R\u001b\u00105\u001a\u0002008FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b1\u00102\u001a\u0004\b3\u00104\u00a8\u0006:"}, d2 = {"Lcom/tencent/mobileqq/troop/troopidentity/TroopAllInteractiveTagsVM;", "Lcom/tencent/biz/richframework/part/BaseViewModel;", "", "isSet", "", "interactionTagId", "", "U1", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/troop/troopidentity/data/ParcelIdentityInteractionTag;", "Lkotlin/collections/ArrayList;", "parcelTags", "O1", "", "", "Q1", "getLogTag", "Landroid/os/Bundle;", "bundle", "init", "Lcom/tencent/qqnt/kernel/nativeinterface/GroupIdentityInteractionTag;", "iconInfo", "X1", "i", "Ljava/lang/String;", "S1", "()Ljava/lang/String;", "setTroopUin", "(Ljava/lang/String;)V", "troopUin", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "memberUin", "Landroidx/lifecycle/MutableLiveData;", BdhLogUtil.LogTag.Tag_Conn, "Landroidx/lifecycle/MutableLiveData;", "_tagsInfo", "Landroidx/lifecycle/LiveData;", "D", "Landroidx/lifecycle/LiveData;", "R1", "()Landroidx/lifecycle/LiveData;", "tagsInfoLiveData", "Lcom/tencent/mobileqq/troop/troopidentity/view/c;", "E", "_uiState", UserInfo.SEX_FEMALE, "T1", "uiStateLiveData", "Lcom/tencent/mobileqq/troop/troopidentity/util/a;", "G", "Lkotlin/Lazy;", "P1", "()Lcom/tencent/mobileqq/troop/troopidentity/util/a;", "dtReporter", "<init>", "()V", "H", "a", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class TroopAllInteractiveTagsVM extends BaseViewModel {
    static IPatchRedirector $redirector_;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<ArrayList<GroupIdentityInteractionTag>> _tagsInfo;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final LiveData<ArrayList<GroupIdentityInteractionTag>> tagsInfoLiveData;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<com.tencent.mobileqq.troop.troopidentity.view.c> _uiState;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final LiveData<com.tencent.mobileqq.troop.troopidentity.view.c> uiStateLiveData;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final Lazy dtReporter;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String troopUin;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String memberUin;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/troop/troopidentity/TroopAllInteractiveTagsVM$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.troop.troopidentity.TroopAllInteractiveTagsVM$a, reason: from kotlin metadata */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(57667);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 10)) {
            redirector.redirect((short) 10);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public TroopAllInteractiveTagsVM() {
        Lazy lazy;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.troopUin = "";
        this.memberUin = "";
        MutableLiveData<ArrayList<GroupIdentityInteractionTag>> mutableLiveData = new MutableLiveData<>();
        this._tagsInfo = mutableLiveData;
        this.tagsInfoLiveData = mutableLiveData;
        MutableLiveData<com.tencent.mobileqq.troop.troopidentity.view.c> mutableLiveData2 = new MutableLiveData<>();
        this._uiState = mutableLiveData2;
        this.uiStateLiveData = mutableLiveData2;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<com.tencent.mobileqq.troop.troopidentity.util.a>() { // from class: com.tencent.mobileqq.troop.troopidentity.TroopAllInteractiveTagsVM$dtReporter$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) TroopAllInteractiveTagsVM.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final com.tencent.mobileqq.troop.troopidentity.util.a invoke() {
                Map Q1;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (com.tencent.mobileqq.troop.troopidentity.util.a) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
                Q1 = TroopAllInteractiveTagsVM.this.Q1();
                return new com.tencent.mobileqq.troop.troopidentity.util.a("pg_group_interact_signage", Q1);
            }
        });
        this.dtReporter = lazy;
    }

    private final void O1(ArrayList<ParcelIdentityInteractionTag> parcelTags) {
        ArrayList<GroupIdentityInteractionTag> arrayList = new ArrayList<>();
        Iterator<T> it = parcelTags.iterator();
        while (it.hasNext()) {
            arrayList.add(ParcelIdentityInteractionTag.b((ParcelIdentityInteractionTag) it.next()));
        }
        this._tagsInfo.postValue(arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Map<String, Object> Q1() {
        String str;
        AppRuntime peekAppRuntime;
        String str2 = this.memberUin;
        MobileQQ mobileQQ = MobileQQ.sMobileQQ;
        if (mobileQQ != null && (peekAppRuntime = mobileQQ.peekAppRuntime()) != null) {
            str = peekAppRuntime.getCurrentAccountUin();
        } else {
            str = null;
        }
        return com.tencent.mobileqq.troop.troopidentity.util.a.INSTANCE.a(this.troopUin, Intrinsics.areEqual(str2, str));
    }

    private final void U1(boolean isSet, String interactionTagId) {
        final ArrayList arrayList;
        Integer intOrNull;
        if (isSet) {
            intOrNull = StringsKt__StringNumberConversionsKt.toIntOrNull(interactionTagId);
            if (intOrNull != null) {
                arrayList = CollectionsKt__CollectionsKt.arrayListOf(Integer.valueOf(intOrNull.intValue()));
            } else {
                return;
            }
        } else {
            arrayList = new ArrayList();
        }
        ((ITroopMemberListRepoApi) QRoute.api(ITroopMemberListRepoApi.class)).fetchTroopMemberInfoWithExtInfo(this.troopUin, this.memberUin, false, null, "TroopAllInteractiveTagsVM", new com.tencent.qqnt.troopmemberlist.g() { // from class: com.tencent.mobileqq.troop.troopidentity.d
            @Override // com.tencent.qqnt.troopmemberlist.g
            public final void a(TroopMemberInfo troopMemberInfo) {
                TroopAllInteractiveTagsVM.W1(arrayList, this, troopMemberInfo);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void W1(ArrayList honorList, TroopAllInteractiveTagsVM this$0, TroopMemberInfo troopMemberInfo) {
        Intrinsics.checkNotNullParameter(honorList, "$honorList");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (troopMemberInfo == null) {
            return;
        }
        troop_honor$GroupUserCardHonor troop_honor_groupusercardhonor = new troop_honor$GroupUserCardHonor();
        troop_honor_groupusercardhonor.level.set(troopMemberInfo.realLevel);
        troop_honor_groupusercardhonor.f436061id.set(honorList);
        ITroopMemberExtInfoRepoApi iTroopMemberExtInfoRepoApi = (ITroopMemberExtInfoRepoApi) QRoute.api(ITroopMemberExtInfoRepoApi.class);
        String str = this$0.troopUin;
        String str2 = this$0.memberUin;
        byte[] byteArray = troop_honor_groupusercardhonor.toByteArray();
        Intrinsics.checkNotNullExpressionValue(byteArray, "honor.toByteArray()");
        iTroopMemberExtInfoRepoApi.updateTroopMemberHonor(str, str2, byteArray);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Z1(GroupIdentityInteractionTag iconInfo, ArrayList iconList, TroopAllInteractiveTagsVM this$0, boolean z16, int i3, String str) {
        Intrinsics.checkNotNullParameter(iconInfo, "$iconInfo");
        Intrinsics.checkNotNullParameter(iconList, "$iconList");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QLog.i("TroopAllInteractiveTagsVM", 1, "[updateIconSetStatus] iconInfo = " + TroopIdentityHonorUtilKt.b(iconInfo) + " result = " + i3 + " errMsg = " + str);
        if (com.tencent.qqnt.e.d(i3)) {
            Iterator it = iconList.iterator();
            while (it.hasNext()) {
                GroupIdentityInteractionTag groupIdentityInteractionTag = (GroupIdentityInteractionTag) it.next();
                if (Intrinsics.areEqual(groupIdentityInteractionTag.interactionTagId, iconInfo.interactionTagId)) {
                    groupIdentityInteractionTag.isSet = z16;
                } else {
                    groupIdentityInteractionTag.isSet = false;
                }
            }
            this$0._uiState.postValue(new c.b(iconInfo));
            String str2 = iconInfo.interactionTagId;
            Intrinsics.checkNotNullExpressionValue(str2, "iconInfo.interactionTagId");
            this$0.U1(z16, str2);
        }
    }

    @NotNull
    public final com.tencent.mobileqq.troop.troopidentity.util.a P1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (com.tencent.mobileqq.troop.troopidentity.util.a) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return (com.tencent.mobileqq.troop.troopidentity.util.a) this.dtReporter.getValue();
    }

    @NotNull
    public final LiveData<ArrayList<GroupIdentityInteractionTag>> R1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (LiveData) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.tagsInfoLiveData;
    }

    @NotNull
    public final String S1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.troopUin;
    }

    @NotNull
    public final LiveData<com.tencent.mobileqq.troop.troopidentity.view.c> T1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (LiveData) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.uiStateLiveData;
    }

    public final void X1(final boolean isSet, @NotNull final GroupIdentityInteractionTag iconInfo) {
        final ArrayList<GroupIdentityInteractionTag> value;
        Long longOrNull;
        long j3;
        Integer intOrNull;
        IPatchRedirector iPatchRedirector = $redirector_;
        int i3 = 0;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, Boolean.valueOf(isSet), iconInfo);
            return;
        }
        Intrinsics.checkNotNullParameter(iconInfo, "iconInfo");
        if (TroopIdentityHonorUtil.h(TroopIdentityHonorUtil.f300410a, false, 1, null) || (value = this.tagsInfoLiveData.getValue()) == null) {
            return;
        }
        SetIdentityInteractionTagReq setIdentityInteractionTagReq = new SetIdentityInteractionTagReq();
        longOrNull = StringsKt__StringNumberConversionsKt.toLongOrNull(this.troopUin);
        if (longOrNull != null) {
            j3 = longOrNull.longValue();
        } else {
            j3 = 0;
        }
        setIdentityInteractionTagReq.groupId = j3;
        String str = iconInfo.interactionTagId;
        Intrinsics.checkNotNullExpressionValue(str, "iconInfo.interactionTagId");
        intOrNull = StringsKt__StringNumberConversionsKt.toIntOrNull(str);
        if (intOrNull != null) {
            i3 = intOrNull.intValue();
        }
        setIdentityInteractionTagReq.interactionTagId = i3;
        setIdentityInteractionTagReq.wearType = isSet ? 1 : 0;
        s c16 = com.tencent.qqnt.msg.f.c();
        if (c16 != null) {
            c16.setIdentityInteractionTag(setIdentityInteractionTagReq, new IOperateCallback() { // from class: com.tencent.mobileqq.troop.troopidentity.c
                @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
                public final void onResult(int i16, String str2) {
                    TroopAllInteractiveTagsVM.Z1(GroupIdentityInteractionTag.this, value, this, isSet, i16, str2);
                }
            });
        }
    }

    @Override // com.tencent.biz.richframework.part.BaseViewModel
    @NotNull
    /* renamed from: getLogTag */
    public String getTAG() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (String) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return "TroopAllInteractiveTagsVM";
    }

    public final void init(@NotNull Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) bundle);
            return;
        }
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        String string = bundle.getString("troop_uin", "");
        Intrinsics.checkNotNullExpressionValue(string, "bundle.getString(AppConstants.Key.TROOP_UIN, \"\")");
        this.troopUin = string;
        String string2 = bundle.getString("uin", "");
        Intrinsics.checkNotNullExpressionValue(string2, "bundle.getString(AppConstants.Key.UIN, \"\")");
        this.memberUin = string2;
        ArrayList<ParcelIdentityInteractionTag> parcelableArrayList = bundle.getParcelableArrayList("key_identity_interaction_tags");
        if (parcelableArrayList == null) {
            parcelableArrayList = new ArrayList<>();
        }
        O1(parcelableArrayList);
    }
}
