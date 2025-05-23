package com.tencent.mobileqq.troop.troopcard.reborn.vm;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.troopcard.reborn.part.TroopInfoCardEssenceMsgPart;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u0000 22\u00020\u0001:\u00013B\u0007\u00a2\u0006\u0004\b0\u00101J\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0004\u001a\u00020\u0002J\u0006\u0010\u0005\u001a\u00020\u0002J\u0006\u0010\u0006\u001a\u00020\u0002J\u0006\u0010\u0007\u001a\u00020\u0002J\u0006\u0010\b\u001a\u00020\u0002J\u0006\u0010\t\u001a\u00020\u0002J\u0006\u0010\n\u001a\u00020\u0002R.\u0010\u0011\u001a\u001c\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\r \u000e*\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f0\f0\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R#\u0010\u0017\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0\u00128\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\"\u0010\u001a\u001a\u0010\u0012\f\u0012\n \u000e*\u0004\u0018\u00010\u00180\u00180\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u0010R\u001d\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00180\u00128\u0006\u00a2\u0006\f\n\u0004\b\u001b\u0010\u0014\u001a\u0004\b\u001c\u0010\u0016R\"\u0010\u001f\u001a\u0010\u0012\f\u0012\n \u000e*\u0004\u0018\u00010\u00180\u00180\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u0010R\"\u0010!\u001a\u0010\u0012\f\u0012\n \u000e*\u0004\u0018\u00010\u00180\u00180\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b \u0010\u0010R\u001d\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00180\u00128\u0006\u00a2\u0006\f\n\u0004\b\"\u0010\u0014\u001a\u0004\b#\u0010\u0016R\u001d\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00180%8\u0006\u00a2\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)R\u001a\u0010/\u001a\u00020\u00188\u0006X\u0086D\u00a2\u0006\f\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.\u00a8\u00064"}, d2 = {"Lcom/tencent/mobileqq/troop/troopcard/reborn/vm/TroopInfoCardEssenceViewModel;", "Landroidx/lifecycle/ViewModel;", "", "init", "W1", "T1", ICustomDataEditor.STRING_ARRAY_PARAM_2, "b2", "c2", "g2", "U1", "Landroidx/lifecycle/MutableLiveData;", "", "Lcom/tencent/mobileqq/troop/troopcard/reborn/part/TroopInfoCardEssenceMsgPart$TabInfo;", "kotlin.jvm.PlatformType", "i", "Landroidx/lifecycle/MutableLiveData;", "_tabList", "Landroidx/lifecycle/LiveData;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroidx/lifecycle/LiveData;", "S1", "()Landroidx/lifecycle/LiveData;", "tabList", "", BdhLogUtil.LogTag.Tag_Conn, "_showTitle", "D", "R1", "showTitle", "E", "_fileDataAvailable", UserInfo.SEX_FEMALE, "_msgDataAvailable", "G", "Q1", "showTab", "Landroidx/lifecycle/MediatorLiveData;", "H", "Landroidx/lifecycle/MediatorLiveData;", "X1", "()Landroidx/lifecycle/MediatorLiveData;", "isEmptyContent", "I", "Z", "P1", "()Z", "enable", "<init>", "()V", "J", "a", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class TroopInfoCardEssenceViewModel extends ViewModel {
    static IPatchRedirector $redirector_;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<Boolean> _showTitle;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final LiveData<Boolean> showTitle;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<Boolean> _fileDataAvailable;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<Boolean> _msgDataAvailable;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final LiveData<Boolean> showTab;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private final MediatorLiveData<Boolean> isEmptyContent;

    /* renamed from: I, reason: from kotlin metadata */
    private final boolean enable;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final MutableLiveData<List<TroopInfoCardEssenceMsgPart.TabInfo>> _tabList;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final LiveData<List<TroopInfoCardEssenceMsgPart.TabInfo>> tabList;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0004\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/troop/troopcard/reborn/vm/TroopInfoCardEssenceViewModel$a;", "", "", "CONFIG_ID", "Ljava/lang/String;", "KEY_FILE_TAB", "KEY_MSG_TAB", "TAG", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.troop.troopcard.reborn.vm.TroopInfoCardEssenceViewModel$a, reason: from kotlin metadata */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(57397);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 15)) {
            redirector.redirect((short) 15);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public TroopInfoCardEssenceViewModel() {
        List listOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            listOf = CollectionsKt__CollectionsJVMKt.listOf(TroopInfoCardEssenceMsgPart.TabInfo.EMPTY);
            MutableLiveData<List<TroopInfoCardEssenceMsgPart.TabInfo>> mutableLiveData = new MutableLiveData<>(listOf);
            this._tabList = mutableLiveData;
            this.tabList = mutableLiveData;
            Boolean bool = Boolean.FALSE;
            MutableLiveData<Boolean> mutableLiveData2 = new MutableLiveData<>(bool);
            this._showTitle = mutableLiveData2;
            this.showTitle = mutableLiveData2;
            MutableLiveData<Boolean> mutableLiveData3 = new MutableLiveData<>(bool);
            this._fileDataAvailable = mutableLiveData3;
            MutableLiveData<Boolean> mutableLiveData4 = new MutableLiveData<>(bool);
            this._msgDataAvailable = mutableLiveData4;
            final MediatorLiveData mediatorLiveData = new MediatorLiveData();
            final Function1<Boolean, Unit> function1 = new Function1<Boolean, Unit>(mediatorLiveData, this) { // from class: com.tencent.mobileqq.troop.troopcard.reborn.vm.TroopInfoCardEssenceViewModel$showTab$1$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ MediatorLiveData<Boolean> $this_apply;
                final /* synthetic */ TroopInfoCardEssenceViewModel this$0;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                    this.$this_apply = mediatorLiveData;
                    this.this$0 = this;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) mediatorLiveData, (Object) this);
                    }
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Boolean bool2) {
                    invoke2(bool2);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Boolean bool2) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                        TroopInfoCardEssenceViewModel.f2(this.$this_apply, this.this$0);
                    } else {
                        iPatchRedirector2.redirect((short) 2, (Object) this, (Object) bool2);
                    }
                }
            };
            mediatorLiveData.addSource(mutableLiveData3, new Observer() { // from class: com.tencent.mobileqq.troop.troopcard.reborn.vm.r
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    TroopInfoCardEssenceViewModel.d2(Function1.this, obj);
                }
            });
            final Function1<Boolean, Unit> function12 = new Function1<Boolean, Unit>(mediatorLiveData, this) { // from class: com.tencent.mobileqq.troop.troopcard.reborn.vm.TroopInfoCardEssenceViewModel$showTab$1$2
                static IPatchRedirector $redirector_;
                final /* synthetic */ MediatorLiveData<Boolean> $this_apply;
                final /* synthetic */ TroopInfoCardEssenceViewModel this$0;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                    this.$this_apply = mediatorLiveData;
                    this.this$0 = this;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) mediatorLiveData, (Object) this);
                    }
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Boolean bool2) {
                    invoke2(bool2);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Boolean bool2) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                        TroopInfoCardEssenceViewModel.f2(this.$this_apply, this.this$0);
                    } else {
                        iPatchRedirector2.redirect((short) 2, (Object) this, (Object) bool2);
                    }
                }
            };
            mediatorLiveData.addSource(mutableLiveData4, new Observer() { // from class: com.tencent.mobileqq.troop.troopcard.reborn.vm.s
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    TroopInfoCardEssenceViewModel.e2(Function1.this, obj);
                }
            });
            this.showTab = mediatorLiveData;
            final MediatorLiveData<Boolean> mediatorLiveData2 = new MediatorLiveData<>();
            final Function1<List<? extends TroopInfoCardEssenceMsgPart.TabInfo>, Unit> function13 = new Function1<List<? extends TroopInfoCardEssenceMsgPart.TabInfo>, Unit>(mediatorLiveData2) { // from class: com.tencent.mobileqq.troop.troopcard.reborn.vm.TroopInfoCardEssenceViewModel$isEmptyContent$1$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ MediatorLiveData<Boolean> $this_apply;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                    this.$this_apply = mediatorLiveData2;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) mediatorLiveData2);
                    }
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(List<? extends TroopInfoCardEssenceMsgPart.TabInfo> list) {
                    invoke2(list);
                    return Unit.INSTANCE;
                }

                /* JADX WARN: Code restructure failed: missing block: B:13:0x002a, code lost:
                
                    if (r4 == com.tencent.mobileqq.troop.troopcard.reborn.part.TroopInfoCardEssenceMsgPart.TabInfo.EMPTY) goto L16;
                 */
                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public final void invoke2(List<? extends TroopInfoCardEssenceMsgPart.TabInfo> list) {
                    Object first;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this, (Object) list);
                        return;
                    }
                    MediatorLiveData<Boolean> mediatorLiveData3 = this.$this_apply;
                    boolean z16 = true;
                    if (!list.isEmpty()) {
                        if (list.size() == 1) {
                            Intrinsics.checkNotNullExpressionValue(list, "list");
                            first = CollectionsKt___CollectionsKt.first((List<? extends Object>) list);
                        }
                        z16 = false;
                    }
                    mediatorLiveData3.setValue(Boolean.valueOf(z16));
                }
            };
            mediatorLiveData2.addSource(mutableLiveData, new Observer() { // from class: com.tencent.mobileqq.troop.troopcard.reborn.vm.t
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    TroopInfoCardEssenceViewModel.Z1(Function1.this, obj);
                }
            });
            this.isEmptyContent = mediatorLiveData2;
            this.enable = true;
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Z1(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d2(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e2(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f2(MediatorLiveData<Boolean> mediatorLiveData, TroopInfoCardEssenceViewModel troopInfoCardEssenceViewModel) {
        boolean z16;
        Boolean value = troopInfoCardEssenceViewModel._fileDataAvailable.getValue();
        Boolean bool = Boolean.TRUE;
        if (Intrinsics.areEqual(value, bool) && Intrinsics.areEqual(troopInfoCardEssenceViewModel._msgDataAvailable.getValue(), bool)) {
            z16 = true;
        } else {
            z16 = false;
        }
        mediatorLiveData.setValue(Boolean.valueOf(z16));
    }

    public final boolean P1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this)).booleanValue();
        }
        return this.enable;
    }

    @NotNull
    public final LiveData<Boolean> Q1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (LiveData) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.showTab;
    }

    @NotNull
    public final LiveData<Boolean> R1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (LiveData) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.showTitle;
    }

    @NotNull
    public final LiveData<List<TroopInfoCardEssenceMsgPart.TabInfo>> S1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (LiveData) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.tabList;
    }

    public final void T1() {
        boolean z16;
        TroopInfoCardEssenceMsgPart.TabInfo tabInfo;
        Object first;
        List mutableList;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        boolean z17 = true;
        QLog.i("TroopInfoCardEssenceViewModel", 1, "hide file tab");
        List<TroopInfoCardEssenceMsgPart.TabInfo> value = this._tabList.getValue();
        if (value == null) {
            value = CollectionsKt__CollectionsKt.emptyList();
        }
        List<TroopInfoCardEssenceMsgPart.TabInfo> value2 = this._tabList.getValue();
        if (value2 != null && value2.contains(TroopInfoCardEssenceMsgPart.TabInfo.FILE)) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) value);
            mutableList.remove(TroopInfoCardEssenceMsgPart.TabInfo.FILE);
            com.tencent.mobileqq.troop.troopcard.reborn.ktx.c.a(this._tabList, mutableList);
        }
        List<TroopInfoCardEssenceMsgPart.TabInfo> value3 = this._tabList.getValue();
        if (value3 == null || !value3.isEmpty()) {
            z17 = false;
        }
        if (!z17) {
            List<TroopInfoCardEssenceMsgPart.TabInfo> value4 = this._tabList.getValue();
            if (value4 != null) {
                first = CollectionsKt___CollectionsKt.first((List<? extends Object>) value4);
                tabInfo = (TroopInfoCardEssenceMsgPart.TabInfo) first;
            } else {
                tabInfo = null;
            }
            if (tabInfo != TroopInfoCardEssenceMsgPart.TabInfo.EMPTY) {
                return;
            }
        }
        com.tencent.mobileqq.troop.troopcard.reborn.ktx.c.a(this._showTitle, Boolean.FALSE);
    }

    public final void U1() {
        boolean z16;
        TroopInfoCardEssenceMsgPart.TabInfo tabInfo;
        Object first;
        List mutableList;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this);
            return;
        }
        boolean z17 = true;
        QLog.i("TroopInfoCardEssenceViewModel", 1, "hide msg tab");
        List<TroopInfoCardEssenceMsgPart.TabInfo> value = this._tabList.getValue();
        if (value == null) {
            value = CollectionsKt__CollectionsKt.emptyList();
        }
        List<TroopInfoCardEssenceMsgPart.TabInfo> value2 = this._tabList.getValue();
        if (value2 != null && value2.contains(TroopInfoCardEssenceMsgPart.TabInfo.MESSAGE)) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) value);
            mutableList.remove(TroopInfoCardEssenceMsgPart.TabInfo.MESSAGE);
            com.tencent.mobileqq.troop.troopcard.reborn.ktx.c.a(this._tabList, mutableList);
        }
        List<TroopInfoCardEssenceMsgPart.TabInfo> value3 = this._tabList.getValue();
        if (value3 == null || !value3.isEmpty()) {
            z17 = false;
        }
        if (!z17) {
            List<TroopInfoCardEssenceMsgPart.TabInfo> value4 = this._tabList.getValue();
            if (value4 != null) {
                first = CollectionsKt___CollectionsKt.first((List<? extends Object>) value4);
                tabInfo = (TroopInfoCardEssenceMsgPart.TabInfo) first;
            } else {
                tabInfo = null;
            }
            if (tabInfo != TroopInfoCardEssenceMsgPart.TabInfo.EMPTY) {
                return;
            }
        }
        com.tencent.mobileqq.troop.troopcard.reborn.ktx.c.a(this._showTitle, Boolean.FALSE);
    }

    public final void W1() {
        List listOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        QLog.i("TroopInfoCardEssenceViewModel", 1, "hide tab");
        MutableLiveData<List<TroopInfoCardEssenceMsgPart.TabInfo>> mutableLiveData = this._tabList;
        listOf = CollectionsKt__CollectionsJVMKt.listOf(TroopInfoCardEssenceMsgPart.TabInfo.EMPTY);
        com.tencent.mobileqq.troop.troopcard.reborn.ktx.c.a(mutableLiveData, listOf);
        com.tencent.mobileqq.troop.troopcard.reborn.ktx.c.a(this._showTitle, Boolean.FALSE);
    }

    @NotNull
    public final MediatorLiveData<Boolean> X1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (MediatorLiveData) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.isEmptyContent;
    }

    public final void a2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
        } else {
            com.tencent.mobileqq.troop.troopcard.reborn.ktx.c.a(this._fileDataAvailable, Boolean.TRUE);
        }
    }

    public final void b2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
        } else {
            com.tencent.mobileqq.troop.troopcard.reborn.ktx.c.a(this._msgDataAvailable, Boolean.TRUE);
        }
    }

    public final void c2() {
        List listOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
            return;
        }
        QLog.i("TroopInfoCardEssenceViewModel", 1, "showGuideTab tab");
        MutableLiveData<List<TroopInfoCardEssenceMsgPart.TabInfo>> mutableLiveData = this._tabList;
        listOf = CollectionsKt__CollectionsJVMKt.listOf(TroopInfoCardEssenceMsgPart.TabInfo.GUIDE);
        com.tencent.mobileqq.troop.troopcard.reborn.ktx.c.a(mutableLiveData, listOf);
        com.tencent.mobileqq.troop.troopcard.reborn.ktx.c.a(this._showTitle, Boolean.FALSE);
    }

    public final void g2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this);
            return;
        }
        QLog.i("TroopInfoCardEssenceViewModel", 1, "show title");
        if (Intrinsics.areEqual(this._showTitle.getValue(), Boolean.FALSE)) {
            com.tencent.mobileqq.troop.troopcard.reborn.ktx.c.a(this._showTitle, Boolean.TRUE);
        }
    }

    public final void init() {
        boolean z16;
        boolean z17;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        ArrayList arrayList = new ArrayList();
        boolean z18 = false;
        String str = new String(((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadRawConfig("105574", new byte[0]), Charsets.UTF_8);
        boolean z19 = true;
        if (str.length() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.optInt("file_open") != 0) {
                z17 = true;
            } else {
                z17 = false;
            }
            if (jSONObject.optInt("msg_open") == 1) {
                z18 = true;
            }
            z19 = z17;
        }
        if (z19) {
            arrayList.add(TroopInfoCardEssenceMsgPart.TabInfo.FILE);
        }
        if (z18) {
            arrayList.add(TroopInfoCardEssenceMsgPart.TabInfo.MESSAGE);
        }
        com.tencent.mobileqq.troop.troopcard.reborn.ktx.c.a(this._tabList, arrayList);
    }
}
