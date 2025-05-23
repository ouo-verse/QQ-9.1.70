package com.tencent.mobileqq.troop.troopsquare.home.vm;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.troop.utils.bg;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.api.s;
import com.tencent.qqnt.kernel.nativeinterface.GetRecGroupsRsp;
import com.tencent.qqnt.kernel.nativeinterface.GroupSquareGroupInfoItem;
import com.tencent.qqnt.kernel.nativeinterface.GroupSquareTabItem;
import com.tencent.qqnt.kernel.nativeinterface.IGetRecGroupsCallback;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u0000 $2\u00020\u0001:\u0001%B\u0007\u00a2\u0006\u0004\b\"\u0010#J\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004R \u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR#\u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00140\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\fR\u001d\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00140\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u0017\u0010\u0010\u001a\u0004\b\u0018\u0010\u0012R\u001a\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\n0\u001a8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010!\u001a\u00020\u001e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 \u00a8\u0006&"}, d2 = {"Lcom/tencent/mobileqq/troop/troopsquare/home/vm/e;", "Landroidx/lifecycle/ViewModel;", "", "groupCode", "Lcom/tencent/qqnt/kernel/nativeinterface/GroupSquareTabItem;", "tab", "", "O1", "Landroidx/lifecycle/MutableLiveData;", "", "Lcom/tencent/mobileqq/troop/troopsquare/data/a;", "i", "Landroidx/lifecycle/MutableLiveData;", "_groupInfoItemWrappers", "Landroidx/lifecycle/LiveData;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroidx/lifecycle/LiveData;", "M1", "()Landroidx/lifecycle/LiveData;", "liveDataGroupInfoItemWrapper", "", BdhLogUtil.LogTag.Tag_Conn, "_isEnd", "D", "N1", "liveDataIsEnd", "", "E", "Ljava/util/List;", "groupInfoItems", "", UserInfo.SEX_FEMALE, "Ljava/lang/String;", "cookies", "<init>", "()V", "G", "a", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class e extends ViewModel {
    static IPatchRedirector $redirector_;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<Boolean> _isEnd;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final LiveData<Boolean> liveDataIsEnd;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final List<com.tencent.mobileqq.troop.troopsquare.data.a> groupInfoItems;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private String cookies;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final MutableLiveData<List<com.tencent.mobileqq.troop.troopsquare.data.a>> _groupInfoItemWrappers;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final LiveData<List<com.tencent.mobileqq.troop.troopsquare.data.a>> liveDataGroupInfoItemWrapper;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/troop/troopsquare/home/vm/e$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.troop.troopsquare.home.vm.e$a, reason: from kotlin metadata */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(61571);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        MutableLiveData<List<com.tencent.mobileqq.troop.troopsquare.data.a>> mutableLiveData = new MutableLiveData<>();
        this._groupInfoItemWrappers = mutableLiveData;
        this.liveDataGroupInfoItemWrapper = mutableLiveData;
        MutableLiveData<Boolean> mutableLiveData2 = new MutableLiveData<>();
        this._isEnd = mutableLiveData2;
        this.liveDataIsEnd = mutableLiveData2;
        this.groupInfoItems = new ArrayList();
        this.cookies = "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void P1(e this$0, int i3, String str, GetRecGroupsRsp getRecGroupsRsp) {
        List<com.tencent.mobileqq.troop.troopsquare.data.a> list;
        int collectionSizeOrDefault;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (i3 == 0) {
            String str2 = getRecGroupsRsp.cookies;
            Intrinsics.checkNotNullExpressionValue(str2, "result.cookies");
            this$0.cookies = str2;
            ArrayList<GroupSquareGroupInfoItem> arrayList = getRecGroupsRsp.groupList;
            Intrinsics.checkNotNullExpressionValue(arrayList, "result.groupList");
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10);
            ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault);
            for (GroupSquareGroupInfoItem it : arrayList) {
                Intrinsics.checkNotNullExpressionValue(it, "it");
                com.tencent.mobileqq.troop.troopsquare.data.a aVar = new com.tencent.mobileqq.troop.troopsquare.data.a(it);
                if (!this$0.groupInfoItems.contains(aVar)) {
                    this$0.groupInfoItems.add(aVar);
                }
                arrayList2.add(Unit.INSTANCE);
            }
            this$0._isEnd.postValue(Boolean.valueOf(getRecGroupsRsp.isEnd));
        } else {
            QLog.e("TroopSquare.Home.TroopSquareRecommendVie", 1, "errCode=" + i3 + " errMsg=" + str + " result=" + getRecGroupsRsp);
        }
        MutableLiveData<List<com.tencent.mobileqq.troop.troopsquare.data.a>> mutableLiveData = this$0._groupInfoItemWrappers;
        list = CollectionsKt___CollectionsKt.toList(this$0.groupInfoItems);
        mutableLiveData.postValue(list);
    }

    @NotNull
    public final LiveData<List<com.tencent.mobileqq.troop.troopsquare.data.a>> M1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (LiveData) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.liveDataGroupInfoItemWrapper;
    }

    @NotNull
    public final LiveData<Boolean> N1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (LiveData) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.liveDataIsEnd;
    }

    public final void O1(long groupCode, @NotNull GroupSquareTabItem tab) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Long.valueOf(groupCode), tab);
            return;
        }
        Intrinsics.checkNotNullParameter(tab, "tab");
        s i3 = bg.i(null, 1, null);
        if (i3 != null) {
            i3.getRecGroups(groupCode, tab, this.cookies, new IGetRecGroupsCallback() { // from class: com.tencent.mobileqq.troop.troopsquare.home.vm.d
                @Override // com.tencent.qqnt.kernel.nativeinterface.IGetRecGroupsCallback
                public final void onResult(int i16, String str, GetRecGroupsRsp getRecGroupsRsp) {
                    e.P1(e.this, i16, str, getRecGroupsRsp);
                }
            });
        }
    }
}
