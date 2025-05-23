package com.tencent.mobileqq.troop.troopsetting.part;

import android.app.Activity;
import android.view.View;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.profilecard.base.report.ProfileCardBlacklistReportConst;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.api.IChatSettingForTroopApi;
import com.tencent.mobileqq.troop.troopsetting.event.a;
import com.tencent.mobileqq.widget.listitem.Group;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.GroupMsgMask;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 %2\u00020\u0001:\u0001&B\u0007\u00a2\u0006\u0004\b#\u0010$J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0002J\u0012\u0010\b\u001a\u00020\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002J\u0015\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0016\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0012\u0010\u000f\u001a\u00020\u00022\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016J\u0006\u0010\u0010\u001a\u00020\u0002J\u0012\u0010\u0013\u001a\u00020\u00022\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016R&\u0010\u0018\u001a\u0012\u0012\u0004\u0012\u00020\n0\u0014j\b\u0012\u0004\u0012\u00020\n`\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR0\u0010\"\u001a\u001e\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u001e0\u001dj\u000e\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u001e`\u001f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b \u0010!\u00a8\u0006'"}, d2 = {"Lcom/tencent/mobileqq/troop/troopsetting/part/TroopSettingBlockSearchMsgPart;", "Lcom/tencent/mobileqq/troop/troopsetting/part/h;", "", "P9", "N9", "L9", "Lcom/tencent/qqnt/kernel/nativeinterface/GroupMsgMask;", "mask", "R9", "", "Lcom/tencent/mobileqq/widget/listitem/Group;", "G9", "()[Lcom/tencent/mobileqq/widget/listitem/Group;", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "O9", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "onPartDestroy", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "e", "Ljava/util/ArrayList;", "groups", "Lcom/tencent/mobileqq/troop/troopsetting/bizconfig/c;", "f", "Lcom/tencent/mobileqq/troop/troopsetting/bizconfig/c;", "chatHistoryConfigItem", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", tl.h.F, "Ljava/util/HashMap;", "daTongPageParams", "<init>", "()V", "i", "a", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class TroopSettingBlockSearchMsgPart extends h {
    static IPatchRedirector $redirector_;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private ArrayList<Group> groups;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private com.tencent.mobileqq.troop.troopsetting.bizconfig.c chatHistoryConfigItem;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final HashMap<String, String> daTongPageParams;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/troop/troopsetting/part/TroopSettingBlockSearchMsgPart$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.troop.troopsetting.part.TroopSettingBlockSearchMsgPart$a, reason: from kotlin metadata */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(60580);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public TroopSettingBlockSearchMsgPart() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.groups = new ArrayList<>();
            this.daTongPageParams = new HashMap<>();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void L9() {
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.troop.troopsetting.part.j
            @Override // java.lang.Runnable
            public final void run() {
                TroopSettingBlockSearchMsgPart.M9(TroopSettingBlockSearchMsgPart.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void M9(TroopSettingBlockSearchMsgPart this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        String str = this$0.B9().T2().troopUin;
        boolean z16 = true;
        if (!this$0.getPartHost().isAdded()) {
            QLog.i("TroopSettingBlockSearchMsgPart", 1, "fragment not attach activity");
            return;
        }
        String troopUin = this$0.B9().S2().getTroopUin();
        if (troopUin != null && troopUin.length() != 0) {
            z16 = false;
        }
        if (z16) {
            return;
        }
        ((IChatSettingForTroopApi) QRoute.api(IChatSettingForTroopApi.class)).clearTroopAssistTipTime(this$0.z9(), str);
        this$0.B9().b4(a.t.f301133a);
    }

    private final void N9() {
        Activity activity = getActivity();
        Intrinsics.checkNotNullExpressionValue(activity, "activity");
        this.chatHistoryConfigItem = new com.tencent.mobileqq.troop.troopsetting.bizconfig.c(activity, x9(), B9());
        ArrayList arrayList = new ArrayList();
        com.tencent.mobileqq.troop.troopsetting.bizconfig.c cVar = this.chatHistoryConfigItem;
        if (cVar != null) {
            arrayList.add(cVar);
        }
        ArrayList<Group> arrayList2 = new ArrayList<>();
        this.groups = arrayList2;
        Object[] array = arrayList.toArray(new com.tencent.mobileqq.widget.listitem.a[0]);
        Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        com.tencent.mobileqq.widget.listitem.a[] aVarArr = (com.tencent.mobileqq.widget.listitem.a[]) array;
        arrayList2.add(new Group((com.tencent.mobileqq.widget.listitem.a[]) Arrays.copyOf(aVarArr, aVarArr.length)));
    }

    private final void P9() {
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.troop.troopsetting.part.k
            @Override // java.lang.Runnable
            public final void run() {
                TroopSettingBlockSearchMsgPart.Q9(TroopSettingBlockSearchMsgPart.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Q9(TroopSettingBlockSearchMsgPart this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        HashMap<String, String> hashMap = this$0.daTongPageParams;
        String troopUin = this$0.B9().S2().getTroopUin();
        if (troopUin == null) {
            troopUin = "";
        }
        hashMap.put("to_uin", troopUin);
        this$0.daTongPageParams.put("is_qq_fri", "2");
        com.tencent.qqnt.notification.report.h.p(ProfileCardBlacklistReportConst.PAGE_ID_PG_CHAT_SETTING, this$0.daTongPageParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void R9(GroupMsgMask mask) {
        boolean z16;
        String troopUin = B9().S2().getTroopUin();
        if (troopUin != null && troopUin.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            return;
        }
        B9().S2().troopmask = mask;
        L9();
    }

    @Override // com.tencent.mobileqq.troop.troopsetting.part.h
    @NotNull
    public Group[] G9() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Group[]) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        Object[] array = this.groups.toArray(new Group[0]);
        Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        return (Group[]) array;
    }

    public final void O9() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        LifecycleOwner lifecycleOwner = getPartHost().getLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(lifecycleOwner, "partHost.hostLifecycleOwner");
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(lifecycleOwner), null, null, new TroopSettingBlockSearchMsgPart$initObserver$1(this, null), 3, null);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@Nullable View rootView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) rootView);
            return;
        }
        super.onInitView(rootView);
        N9();
        O9();
        L9();
        P9();
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(@Nullable Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) activity);
            return;
        }
        super.onPartDestroy(activity);
        com.tencent.mobileqq.troop.troopsetting.activity.a.f301056a.a();
        com.tencent.qqnt.notification.report.h.t(ProfileCardBlacklistReportConst.PAGE_ID_PG_CHAT_SETTING, this.daTongPageParams);
    }
}
