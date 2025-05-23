package com.tencent.mobileqq.troop.troopfullmember.part;

import android.app.Activity;
import android.os.Bundle;
import androidx.lifecycle.ViewModel;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.troop.troopfullmember.event.GetSubTroopsInfo;
import com.tencent.mobileqq.troop.troopfullmember.event.UpdateSubTroopsInfo;
import com.tencent.mobileqq.troop.troopshare.tempapi.ITroopShareUtility;
import com.tencent.mobileqq.widget.listitem.Group;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qqnt.kernel.nativeinterface.SubGroupSimpleInfo;
import java.util.ArrayList;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 22\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u00013B\u000f\u0012\u0006\u0010\u001d\u001a\u00020\u0018\u00a2\u0006\u0004\b0\u00101J \u0010\t\u001a\u00020\b2\u0016\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006H\u0002J\u001c\u0010\u000e\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016J\u0012\u0010\u000f\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016J\u0015\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010H\u0016\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u0012\u0010\u0015\u001a\u00020\b2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0003H\u0016J\u0014\u0010\u0017\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00160\u0004H\u0016R\u0017\u0010\u001d\u001a\u00020\u00188\u0006\u00a2\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u0016\u0010!\u001a\u00020\u001e8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R,\u0010%\u001a\u001a\u0012\b\u0012\u0006\u0012\u0002\b\u00030\"0\u0004j\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\"`\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b#\u0010$R&\u0010'\u001a\u0012\u0012\u0004\u0012\u00020\u00110\u0004j\b\u0012\u0004\u0012\u00020\u0011`\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b&\u0010$R\u0016\u0010+\u001a\u00020(8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b)\u0010*R\u0016\u0010/\u001a\u00020,8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b-\u0010.\u00a8\u00064"}, d2 = {"Lcom/tencent/mobileqq/troop/troopfullmember/part/l;", "Lcom/tencent/mobileqq/troop/troopfullmember/part/a;", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "Ljava/util/ArrayList;", "Lcom/tencent/qqnt/kernel/nativeinterface/SubGroupSimpleInfo;", "Lkotlin/collections/ArrayList;", "subTroops", "", "B9", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onPartCreate", "onPartDestroy", "", "Lcom/tencent/mobileqq/widget/listitem/Group;", "A9", "()[Lcom/tencent/mobileqq/widget/listitem/Group;", "event", "onReceiveEvent", "Ljava/lang/Class;", "getEventClass", "", "d", "Ljava/lang/String;", "getTroopUin", "()Ljava/lang/String;", "troopUin", "Lcom/tencent/mobileqq/troop/troopfullmember/c;", "e", "Lcom/tencent/mobileqq/troop/troopfullmember/c;", "viewModel", "Lcom/tencent/mobileqq/widget/listitem/a;", "f", "Ljava/util/ArrayList;", "configList", tl.h.F, "groups", "Lcom/tencent/mobileqq/troop/troopfullmember/config/e;", "i", "Lcom/tencent/mobileqq/troop/troopfullmember/config/e;", "titleConfig", "Lcom/tencent/mobileqq/troop/troopshare/tempapi/ITroopShareUtility;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/troop/troopshare/tempapi/ITroopShareUtility;", "mTroopShareUtility", "<init>", "(Ljava/lang/String;)V", BdhLogUtil.LogTag.Tag_Conn, "a", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class l extends a implements SimpleEventReceiver<SimpleBaseEvent> {
    static IPatchRedirector $redirector_;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String troopUin;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private com.tencent.mobileqq.troop.troopfullmember.c viewModel;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ArrayList<com.tencent.mobileqq.widget.listitem.a<?>> configList;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private ArrayList<Group> groups;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private com.tencent.mobileqq.troop.troopfullmember.config.e titleConfig;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private ITroopShareUtility mTroopShareUtility;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00058\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/troop/troopfullmember/part/l$a;", "", "", "FROM_TROOPSUBINFO", "I", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.troop.troopfullmember.part.l$a, reason: from kotlin metadata */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(57546);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 8)) {
            redirector.redirect((short) 8);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public l(@NotNull String troopUin) {
        Intrinsics.checkNotNullParameter(troopUin, "troopUin");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) troopUin);
            return;
        }
        this.troopUin = troopUin;
        SimpleEventBus.getInstance().registerReceiver(this);
        this.configList = new ArrayList<>();
        this.groups = new ArrayList<>();
        this.titleConfig = new com.tencent.mobileqq.troop.troopfullmember.config.e(1, 0);
    }

    private final void B9(ArrayList<SubGroupSimpleInfo> subTroops) {
        this.configList.clear();
        this.groups.clear();
        this.configList.add(new com.tencent.mobileqq.troop.troopfullmember.config.e(1, subTroops.size()));
        for (SubGroupSimpleInfo subGroupSimpleInfo : subTroops) {
            ArrayList<com.tencent.mobileqq.widget.listitem.a<?>> arrayList = this.configList;
            String valueOf = String.valueOf(subGroupSimpleInfo.groupCode);
            String str = subGroupSimpleInfo.groupName;
            Intrinsics.checkNotNullExpressionValue(str, "it.groupName");
            int i3 = (int) subGroupSimpleInfo.memberNum;
            int i16 = (int) subGroupSimpleInfo.memberMaxNum;
            ITroopShareUtility iTroopShareUtility = this.mTroopShareUtility;
            if (iTroopShareUtility == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mTroopShareUtility");
                iTroopShareUtility = null;
            }
            arrayList.add(new com.tencent.mobileqq.troop.troopfullmember.config.d(valueOf, str, i3, i16, true, iTroopShareUtility));
        }
        ArrayList<Group> arrayList2 = this.groups;
        Object[] array = this.configList.toArray(new com.tencent.mobileqq.widget.listitem.a[0]);
        Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        com.tencent.mobileqq.widget.listitem.a[] aVarArr = (com.tencent.mobileqq.widget.listitem.a[]) array;
        arrayList2.add(new Group((com.tencent.mobileqq.widget.listitem.a[]) Arrays.copyOf(aVarArr, aVarArr.length)));
        SimpleEventBus simpleEventBus = SimpleEventBus.getInstance();
        Object[] array2 = this.groups.toArray(new Group[0]);
        Intrinsics.checkNotNull(array2, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        simpleEventBus.dispatchEvent(new UpdateSubTroopsInfo((Group[]) array2));
    }

    @Override // com.tencent.mobileqq.troop.troopfullmember.part.a
    @NotNull
    public Group[] A9() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (Group[]) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        Object[] array = this.groups.toArray(new Group[0]);
        Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        return (Group[]) array;
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    @NotNull
    public ArrayList<Class<SimpleBaseEvent>> getEventClass() {
        ArrayList<Class<SimpleBaseEvent>> arrayListOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 7)) {
            arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(GetSubTroopsInfo.class);
            Intrinsics.checkNotNull(arrayListOf, "null cannot be cast to non-null type java.util.ArrayList<java.lang.Class<com.tencent.biz.richframework.eventbus.SimpleBaseEvent>>{ kotlin.collections.TypeAliasesKt.ArrayList<java.lang.Class<com.tencent.biz.richframework.eventbus.SimpleBaseEvent>> }");
            return arrayListOf;
        }
        return (ArrayList) iPatchRedirector.redirect((short) 7, (Object) this);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartCreate(@Nullable Activity activity, @Nullable Bundle savedInstanceState) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) activity, (Object) savedInstanceState);
            return;
        }
        super.onPartCreate(activity, savedInstanceState);
        ViewModel viewModel = getViewModel(com.tencent.mobileqq.troop.troopfullmember.c.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "getViewModel(TroopFullMe\u2026ngeViewModel::class.java)");
        this.viewModel = (com.tencent.mobileqq.troop.troopfullmember.c) viewModel;
        QRouteApi api = QRoute.api(ITroopShareUtility.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(ITroopShareUtility::class.java)");
        this.mTroopShareUtility = (ITroopShareUtility) api;
        this.configList.add(this.titleConfig);
        ArrayList<Group> arrayList = this.groups;
        Object[] array = this.configList.toArray(new com.tencent.mobileqq.widget.listitem.a[0]);
        Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        com.tencent.mobileqq.widget.listitem.a[] aVarArr = (com.tencent.mobileqq.widget.listitem.a[]) array;
        arrayList.add(new Group((com.tencent.mobileqq.widget.listitem.a[]) Arrays.copyOf(aVarArr, aVarArr.length)));
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(@Nullable Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) activity);
            return;
        }
        super.onPartDestroy(activity);
        SimpleEventBus.getInstance().unRegisterReceiver(this);
        ITroopShareUtility iTroopShareUtility = this.mTroopShareUtility;
        if (iTroopShareUtility == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTroopShareUtility");
            iTroopShareUtility = null;
        }
        iTroopShareUtility.onDestroy();
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(@Nullable SimpleBaseEvent event) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) event);
        } else if (event instanceof GetSubTroopsInfo) {
            B9(((GetSubTroopsInfo) event).getData());
        }
    }
}
