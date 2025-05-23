package com.tencent.mobileqq.troop.jointype;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.biz.qui.quisecnavbar.BaseAction;
import com.tencent.biz.qui.quisecnavbar.QUISecNavBar;
import com.tencent.biz.richframework.compat.RFWImmersiveUtils;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.ocr.data.OcrConfig;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.troop.jointype.parts.TroopJoinTypeMemberInvitePart;
import com.tencent.mobileqq.troop.jointype.parts.TroopJoinTypeRobotInvitePart;
import com.tencent.mobileqq.troop.jointype.parts.TroopJoinTypeVerifyPart;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.listitem.Group;
import com.tencent.mobileqq.widget.listitem.QUIListItemAdapter;
import com.tencent.mobileqq.widget.listitem.QUISettingsRecyclerView;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.util.UiThreadUtil;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONException;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u008a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 L2\u00020\u0001:\u0001MB\u0007\u00a2\u0006\u0004\bJ\u0010KJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0002J<\u0010\r\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\"\u0010\f\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\n0\tj\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\n`\u000bH\u0002J$\u0010\u000e\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\n0\tj\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\n`\u000bH\u0002J4\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\"\u0010\f\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\n0\tj\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\n`\u000bH\u0002J4\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\"\u0010\f\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\n0\tj\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\n`\u000bH\u0002J$\u0010\u0011\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\n0\tj\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\n`\u000bH\u0002J\u0018\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0006H\u0002J\b\u0010\u0017\u001a\u00020\u0016H\u0016J\b\u0010\u0018\u001a\u00020\u0016H\u0016J$\u0010 \u001a\u00020\u001f2\u0006\u0010\u001a\u001a\u00020\u00192\b\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001dH\u0016J\u001a\u0010\"\u001a\u00020\u00022\u0006\u0010!\u001a\u00020\u001f2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001dH\u0016J\u000e\u0010%\u001a\b\u0012\u0004\u0012\u00020$0#H\u0016J\u001a\u0010'\u001a\u00020\u00022\u0006\u0010&\u001a\u00020\u001f2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001dH\u0014J\u0006\u0010)\u001a\u00020(R#\u00100\u001a\n +*\u0004\u0018\u00010*0*8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/R\u001d\u00104\u001a\u0004\u0018\u00010\u00068BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b1\u0010-\u001a\u0004\b2\u00103R\u001d\u00107\u001a\u0004\u0018\u00010\u00068BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b5\u0010-\u001a\u0004\b6\u00103R\u001d\u0010\u0012\u001a\u0004\u0018\u00010\u00068BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b8\u0010-\u001a\u0004\b9\u00103R\u0016\u0010<\u001a\u00020(8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b:\u0010;R\u0016\u0010@\u001a\u00020=8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b>\u0010?R\u0016\u0010D\u001a\u00020A8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bB\u0010CR&\u0010I\u001a\u0012\u0012\u0004\u0012\u00020$0Ej\b\u0012\u0004\u0012\u00020$`F8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bG\u0010H\u00a8\u0006N"}, d2 = {"Lcom/tencent/mobileqq/troop/jointype/TroopJoinTypeFragment;", "Lcom/tencent/mobileqq/fragment/QPublicBaseFragment;", "", "Ih", "Kh", "Mh", "", "elementId", "eventId", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "params", OcrConfig.CHINESE, "getReportPageParams", "Ah", "yh", "Bh", "troopUinListStr", "", "", "Ch", "", "needStatusTrans", "needImmersive", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "Landroid/view/View;", "onCreateView", "view", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "", "Lcom/tencent/biz/richframework/part/Part;", "assembleParts", "contentView", "onViewCreatedAfterPartInit", "Lcom/tencent/mobileqq/widget/listitem/QUISettingsRecyclerView;", "Dh", "Lcom/tencent/mobileqq/troop/jointype/TroopJoinTypeVM;", "kotlin.jvm.PlatformType", BdhLogUtil.LogTag.Tag_Conn, "Lkotlin/Lazy;", "Hh", "()Lcom/tencent/mobileqq/troop/jointype/TroopJoinTypeVM;", "vm", "D", "Gh", "()Ljava/lang/String;", "userFrom", "E", "Eh", "troopUin", UserInfo.SEX_FEMALE, "Fh", "G", "Lcom/tencent/mobileqq/widget/listitem/QUISettingsRecyclerView;", "recycleView", "Lcom/tencent/mobileqq/widget/listitem/QUIListItemAdapter;", "H", "Lcom/tencent/mobileqq/widget/listitem/QUIListItemAdapter;", "adapter", "Lcom/tencent/biz/qui/quisecnavbar/QUISecNavBar;", "I", "Lcom/tencent/biz/qui/quisecnavbar/QUISecNavBar;", "quiSecNavBar", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "J", "Ljava/util/ArrayList;", "partList", "<init>", "()V", "K", "a", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class TroopJoinTypeFragment extends QPublicBaseFragment {
    static IPatchRedirector $redirector_;

    /* renamed from: K, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final Lazy vm;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final Lazy userFrom;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final Lazy troopUin;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final Lazy troopUinListStr;

    /* renamed from: G, reason: from kotlin metadata */
    private QUISettingsRecyclerView recycleView;

    /* renamed from: H, reason: from kotlin metadata */
    private QUIListItemAdapter adapter;

    /* renamed from: I, reason: from kotlin metadata */
    private QUISecNavBar quiSecNavBar;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    private ArrayList<Part> partList;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0004\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/troop/jointype/TroopJoinTypeFragment$a;", "", "", "PROCESS_NAME", "Ljava/lang/String;", "TAG", "TROOP_UIN_LIST", "WEB_SEQ", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.troop.jointype.TroopJoinTypeFragment$a, reason: from kotlin metadata */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(54311);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 9)) {
            redirector.redirect((short) 9);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public TroopJoinTypeFragment() {
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        Lazy lazy4;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            lazy = LazyKt__LazyJVMKt.lazy(new Function0<TroopJoinTypeVM>() { // from class: com.tencent.mobileqq.troop.jointype.TroopJoinTypeFragment$vm$2
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) TroopJoinTypeFragment.this);
                    }
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final TroopJoinTypeVM invoke() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    return (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) ? (TroopJoinTypeVM) TroopJoinTypeFragment.this.getViewModel(TroopJoinTypeVM.class) : (TroopJoinTypeVM) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
            });
            this.vm = lazy;
            lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<String>() { // from class: com.tencent.mobileqq.troop.jointype.TroopJoinTypeFragment$userFrom$2
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) TroopJoinTypeFragment.this);
                    }
                }

                @Override // kotlin.jvm.functions.Function0
                @Nullable
                public final String invoke() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (String) iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                    Bundle arguments = TroopJoinTypeFragment.this.getArguments();
                    if (arguments != null) {
                        return arguments.getString(WinkDaTongReportConstant.ElementParamKey.XSJ_USER_FROM);
                    }
                    return null;
                }
            });
            this.userFrom = lazy2;
            lazy3 = LazyKt__LazyJVMKt.lazy(new Function0<String>() { // from class: com.tencent.mobileqq.troop.jointype.TroopJoinTypeFragment$troopUin$2
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) TroopJoinTypeFragment.this);
                    }
                }

                @Override // kotlin.jvm.functions.Function0
                @Nullable
                public final String invoke() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (String) iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                    Bundle arguments = TroopJoinTypeFragment.this.getArguments();
                    if (arguments != null) {
                        return arguments.getString("troop_uin");
                    }
                    return null;
                }
            });
            this.troopUin = lazy3;
            lazy4 = LazyKt__LazyJVMKt.lazy(new Function0<String>() { // from class: com.tencent.mobileqq.troop.jointype.TroopJoinTypeFragment$troopUinListStr$2
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) TroopJoinTypeFragment.this);
                    }
                }

                @Override // kotlin.jvm.functions.Function0
                @Nullable
                public final String invoke() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (String) iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                    Bundle arguments = TroopJoinTypeFragment.this.getArguments();
                    if (arguments != null) {
                        return arguments.getString("troopUinList", "");
                    }
                    return null;
                }
            });
            this.troopUinListStr = lazy4;
            this.partList = new ArrayList<>();
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this);
    }

    private final void Ah(String elementId, HashMap<String, Object> params) {
        HashMap hashMap = new HashMap();
        hashMap.putAll(params);
        hashMap.put("dt_eid", elementId);
        hashMap.put("eid", elementId);
        hashMap.put("cur_pg", getReportPageParams());
        VideoReport.reportEvent("dt_imp", hashMap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final HashMap<String, Object> Bh() {
        HashMap<String, Object> hashMap = new HashMap<>();
        Integer value = Hh().d2().getValue();
        Intrinsics.checkNotNull(value);
        hashMap.put("join_way", value);
        hashMap.put("allow_invite_join", Integer.valueOf(Hh().c2() ? 1 : 0));
        int i3 = 2;
        if (Hh().b2() == 67108864) {
            hashMap.put("invite_review_way", 1);
        } else if (Hh().b2() == 1048576) {
            hashMap.put("invite_review_way", 2);
        } else if (Hh().b2() == 0) {
            hashMap.put("invite_review_way", 3);
        }
        hashMap.put("allow_invite_robot_join", Integer.valueOf(Hh().g2() ? 1 : 0));
        if (Hh().f2()) {
            i3 = 1;
        }
        hashMap.put("invite_robot_review_way", Integer.valueOf(i3));
        return hashMap;
    }

    private final List<Long> Ch(String troopUinListStr) {
        long j3;
        ArrayList arrayList = new ArrayList();
        if (TextUtils.isEmpty(troopUinListStr)) {
            return arrayList;
        }
        try {
            JSONArray jSONArray = new JSONArray(troopUinListStr);
            int length = jSONArray.length();
            for (int i3 = 0; i3 < length; i3++) {
                String troopUin = jSONArray.optString(i3);
                try {
                    Intrinsics.checkNotNullExpressionValue(troopUin, "troopUin");
                    j3 = Long.parseLong(troopUin);
                } catch (NumberFormatException unused) {
                    QLog.d("TroopJoinTypeFragment", 1, "parse troop uin exception.");
                    j3 = 0;
                }
                if (j3 > 0) {
                    arrayList.add(Long.valueOf(j3));
                }
            }
        } catch (JSONException unused2) {
            QLog.e("TroopJoinTypeFragment", 1, "getMultiGroupListFromArgument parse json error.");
        }
        return arrayList;
    }

    private final String Eh() {
        return (String) this.troopUin.getValue();
    }

    private final String Fh() {
        return (String) this.troopUinListStr.getValue();
    }

    private final String Gh() {
        return (String) this.userFrom.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final TroopJoinTypeVM Hh() {
        return (TroopJoinTypeVM) this.vm.getValue();
    }

    private final void Ih() {
        LiveData<Boolean> i26 = Hh().i2();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        final Function1<Boolean, Unit> function1 = new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.troop.jointype.TroopJoinTypeFragment$initObserver$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopJoinTypeFragment.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke2(bool);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Boolean it) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) it);
                    return;
                }
                Intrinsics.checkNotNullExpressionValue(it, "it");
                if (it.booleanValue()) {
                    TroopJoinTypeFragment.this.Kh();
                }
            }
        };
        i26.observe(viewLifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.troop.jointype.a
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                TroopJoinTypeFragment.Jh(Function1.this, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Jh(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Kh() {
        Boolean bool;
        Integer num;
        Boolean bool2;
        if (Hh().j2() != 0) {
            return;
        }
        Intent intent = new Intent();
        TroopInfo k26 = Hh().k2();
        Boolean bool3 = null;
        if (k26 != null) {
            bool = Boolean.valueOf(k26.isOnlyTroopMemberInviteOption());
        } else {
            bool = null;
        }
        intent.putExtra("onlyInvite", bool);
        TroopInfo k27 = Hh().k2();
        if (k27 != null) {
            num = Integer.valueOf(k27.cGroupOption);
        } else {
            num = null;
        }
        intent.putExtra("cGroupOption", num);
        intent.putExtra("isSetFee", false);
        intent.putExtra("isSetSuccess", true);
        TroopInfo k28 = Hh().k2();
        if (k28 != null) {
            bool2 = Boolean.valueOf(k28.mCanSearchByTroopUin);
        } else {
            bool2 = null;
        }
        intent.putExtra("isCanSearchByTroopUin", bool2);
        TroopInfo k29 = Hh().k2();
        if (k29 != null) {
            bool3 = Boolean.valueOf(k29.mCanSearchByKeywords);
        }
        intent.putExtra("isCanSearchByKeywords", bool3);
        intent.putExtra("troop_uin", Eh());
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.setResult(-1, intent);
        }
        FragmentActivity activity2 = getActivity();
        if (activity2 != null) {
            activity2.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Lh(TroopJoinTypeFragment this$0, ArrayList groupList) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(groupList, "$groupList");
        QUIListItemAdapter qUIListItemAdapter = this$0.adapter;
        if (qUIListItemAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
            qUIListItemAdapter = null;
        }
        Object[] array = groupList.toArray(new Group[0]);
        Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        Group[] groupArr = (Group[]) array;
        qUIListItemAdapter.t0((Group[]) Arrays.copyOf(groupArr, groupArr.length));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Mh() {
        QQCustomDialog createCustomDialog = DialogUtil.createCustomDialog(getContext(), 230);
        createCustomDialog.setTitle(getString(R.string.f235007ah));
        createCustomDialog.setMessage(getString(R.string.f234997ag));
        final HashMap hashMap = new HashMap();
        createCustomDialog.setPositiveButton("\u786e\u5b9a", new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.troop.jointype.c
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                TroopJoinTypeFragment.Nh(TroopJoinTypeFragment.this, hashMap, dialogInterface, i3);
            }
        });
        createCustomDialog.setNegativeButton("\u53d6\u6d88", new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.troop.jointype.d
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                TroopJoinTypeFragment.Oh(hashMap, this, dialogInterface, i3);
            }
        });
        createCustomDialog.show();
        zh("em_group_set_confirm_pop", "ev_group_set_confirm_pop_imp", new HashMap<>());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Nh(TroopJoinTypeFragment this$0, HashMap reportParams, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(reportParams, "$reportParams");
        this$0.Hh().W2();
        reportParams.put("btn_type", 1);
        this$0.zh("em_group_set_confirm_pop", "ev_group_set_confirm_pop_clck", reportParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Oh(HashMap reportParams, TroopJoinTypeFragment this$0, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(reportParams, "$reportParams");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        reportParams.put("btn_type", 0);
        this$0.zh("em_group_set_confirm_pop", "ev_group_set_confirm_pop_clck", reportParams);
    }

    private final HashMap<String, Object> getReportPageParams() {
        HashMap<String, Object> hashMap = new HashMap<>();
        String Eh = Eh();
        if (Eh != null) {
            hashMap.put("group_id", Eh);
        }
        String Gh = Gh();
        if (Gh != null) {
            hashMap.put(WinkDaTongReportConstant.ElementParamKey.XSJ_USER_FROM, Gh);
        }
        hashMap.put("dt_pgid", "pg_group_set_add_way");
        hashMap.put("pgid", "pg_group_set_add_way");
        return hashMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void yh(String elementId, HashMap<String, Object> params) {
        HashMap hashMap = new HashMap();
        hashMap.putAll(params);
        hashMap.put("dt_eid", elementId);
        hashMap.put("eid", elementId);
        hashMap.put("cur_pg", getReportPageParams());
        VideoReport.reportEvent("dt_clck", hashMap);
    }

    private final void zh(String elementId, String eventId, HashMap<String, Object> params) {
        HashMap hashMap = new HashMap();
        hashMap.putAll(params);
        hashMap.put("dt_eid", elementId);
        hashMap.put("eid", elementId);
        hashMap.put("cur_pg", getReportPageParams());
        VideoReport.reportEvent(eventId, hashMap);
    }

    @NotNull
    public final QUISettingsRecyclerView Dh() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (QUISettingsRecyclerView) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        QUISettingsRecyclerView qUISettingsRecyclerView = this.recycleView;
        if (qUISettingsRecyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recycleView");
            return null;
        }
        return qUISettingsRecyclerView;
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    @NotNull
    public List<Part> assembleParts() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (List) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        this.partList.add(new com.tencent.mobileqq.troop.jointype.parts.g());
        this.partList.add(new TroopJoinTypeVerifyPart());
        this.partList.add(new TroopJoinTypeMemberInvitePart());
        if (!Hh().s2()) {
            this.partList.add(new TroopJoinTypeRobotInvitePart());
        }
        return this.partList;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean needImmersive() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        return false;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean needStatusTrans() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        return false;
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    @NotNull
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            inflate = (View) iPatchRedirector.redirect((short) 4, this, inflater, container, savedInstanceState);
        } else {
            Intrinsics.checkNotNullParameter(inflater, "inflater");
            super.onCreateView(inflater, container, savedInstanceState);
            String Eh = Eh();
            if (Eh != null) {
                TroopJoinTypeVM Hh = Hh();
                List<Long> Ch = Ch(Fh());
                Bundle arguments = getArguments();
                if (arguments == null) {
                    arguments = new Bundle();
                }
                Intrinsics.checkNotNullExpressionValue(arguments, "arguments ?: Bundle()");
                Hh.q2(Eh, Ch, arguments);
            }
            Ih();
            inflate = inflater.inflate(R.layout.g0p, container, false);
            Intrinsics.checkNotNullExpressionValue(inflate, "inflater.inflate(R.layou\u2026layout, container, false)");
        }
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, inflate);
        return inflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        Window window;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) view, (Object) savedInstanceState);
            return;
        }
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        View findViewById = view.findViewById(R.id.jo9);
        QUISecNavBar qUISecNavBar = (QUISecNavBar) findViewById;
        qUISecNavBar.S(this);
        qUISecNavBar.setCenterText("\u9009\u62e9\u52a0\u7fa4\u65b9\u5f0f");
        qUISecNavBar.setRightType(1);
        qUISecNavBar.setRightText("\u786e\u5b9a");
        qUISecNavBar.setOnBaseTitleBarClickListener(new Function2<View, BaseAction, Unit>() { // from class: com.tencent.mobileqq.troop.jointype.TroopJoinTypeFragment$onViewCreated$1$1
            static IPatchRedirector $redirector_;

            /* compiled from: P */
            @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
            /* loaded from: classes19.dex */
            public /* synthetic */ class a {
                static IPatchRedirector $redirector_;

                /* renamed from: a, reason: collision with root package name */
                public static final /* synthetic */ int[] f297562a;

                static {
                    IPatchRedirector redirector = PatchRedirectCenter.getRedirector(54295);
                    $redirector_ = redirector;
                    if (redirector != null && redirector.hasPatch((short) 1)) {
                        redirector.redirect((short) 1);
                        return;
                    }
                    int[] iArr = new int[BaseAction.values().length];
                    try {
                        iArr[BaseAction.ACTION_RIGHT_TEXT.ordinal()] = 1;
                    } catch (NoSuchFieldError unused) {
                    }
                    try {
                        iArr[BaseAction.ACTION_LEFT_BUTTON.ordinal()] = 2;
                    } catch (NoSuchFieldError unused2) {
                    }
                    f297562a = iArr;
                }
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(2);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) TroopJoinTypeFragment.this);
                }
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(View view2, BaseAction baseAction) {
                invoke2(view2, baseAction);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull View view2, @NotNull BaseAction action) {
                HashMap Bh;
                TroopJoinTypeVM Hh;
                TroopJoinTypeVM Hh2;
                FragmentActivity activity;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) view2, (Object) action);
                    return;
                }
                Intrinsics.checkNotNullParameter(view2, "<anonymous parameter 0>");
                Intrinsics.checkNotNullParameter(action, "action");
                int i3 = a.f297562a[action.ordinal()];
                if (i3 != 1) {
                    if (i3 == 2 && (activity = TroopJoinTypeFragment.this.getActivity()) != null) {
                        activity.finish();
                        return;
                    }
                    return;
                }
                TroopJoinTypeFragment troopJoinTypeFragment = TroopJoinTypeFragment.this;
                Bh = troopJoinTypeFragment.Bh();
                troopJoinTypeFragment.yh("em_group_confirm_btn", Bh);
                Hh = TroopJoinTypeFragment.this.Hh();
                if (Hh.s2()) {
                    TroopJoinTypeFragment.this.Mh();
                } else {
                    Hh2 = TroopJoinTypeFragment.this.Hh();
                    Hh2.V2();
                }
            }
        });
        Ah("em_group_confirm_btn", Bh());
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById<QUISec\u2026)\n            )\n        }");
        this.quiSecNavBar = qUISecNavBar;
        FragmentActivity activity = getActivity();
        if (activity != null && (window = activity.getWindow()) != null) {
            RFWImmersiveUtils.setTransparentStatusBar(window);
            RFWImmersiveUtils.setImmersiveLayout(window, false);
        }
        View findViewById2 = view.findViewById(R.id.f102445xx);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "view.findViewById(R.id.t\u2026_join_type_recycler_view)");
        this.recycleView = (QUISettingsRecyclerView) findViewById2;
        this.adapter = new QUIListItemAdapter(null, false, false, 7, null);
        QUISettingsRecyclerView qUISettingsRecyclerView = this.recycleView;
        QUIListItemAdapter qUIListItemAdapter = null;
        if (qUISettingsRecyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recycleView");
            qUISettingsRecyclerView = null;
        }
        QUIListItemAdapter qUIListItemAdapter2 = this.adapter;
        if (qUIListItemAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        } else {
            qUIListItemAdapter = qUIListItemAdapter2;
        }
        qUISettingsRecyclerView.setAdapter(qUIListItemAdapter);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.BasePartFragment
    public void onViewCreatedAfterPartInit(@NotNull View contentView, @Nullable Bundle savedInstanceState) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) contentView, (Object) savedInstanceState);
            return;
        }
        Intrinsics.checkNotNullParameter(contentView, "contentView");
        super.onViewCreatedAfterPartInit(contentView, savedInstanceState);
        final ArrayList arrayList = new ArrayList();
        for (Part part : this.partList) {
            if (part instanceof com.tencent.mobileqq.troop.jointype.parts.a) {
                CollectionsKt__MutableCollectionsKt.addAll(arrayList, ((com.tencent.mobileqq.troop.jointype.parts.a) part).C9());
            }
        }
        UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.troop.jointype.b
            @Override // java.lang.Runnable
            public final void run() {
                TroopJoinTypeFragment.Lh(TroopJoinTypeFragment.this, arrayList);
            }
        });
    }
}
