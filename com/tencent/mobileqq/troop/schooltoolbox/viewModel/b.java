package com.tencent.mobileqq.troop.schooltoolbox.viewModel;

import android.os.Bundle;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.gdtad.util.j;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.troop.schooltoolbox.data.c;
import com.tencent.mobileqq.troop.schooltoolbox.data.d;
import com.tencent.mobileqq.troop.schooltoolbox.data.e;
import com.tencent.mobileqq.troop.schooltoolbox.data.f;
import com.tencent.mobileqq.troop.utils.bg;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.api.r;
import com.tencent.qqnt.kernel.nativeinterface.GroupAppCategoryInfo;
import com.tencent.qqnt.kernel.nativeinterface.GroupAppItem;
import com.tencent.qqnt.kernel.nativeinterface.GroupSchoolToolboxInfoRsp;
import com.tencent.qqnt.kernel.nativeinterface.IGetGroupSchoolToolboxInfoCallback;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 ,2\u00020\u0001:\u0001-B\u000f\u0012\u0006\u0010\u000b\u001a\u00020\u0006\u00a2\u0006\u0004\b*\u0010+J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0006\u0010\u0004\u001a\u00020\u0002J\u0006\u0010\u0005\u001a\u00020\u0002R\u0017\u0010\u000b\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\nR\u0017\u0010\u0011\u001a\u00020\f8\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R \u0010\u0017\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\u00130\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R#\u0010\u001d\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\u00130\u00188\u0006\u00a2\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u001a\u0010 \u001a\b\u0012\u0004\u0012\u00020\u001e0\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001f\u0010\u0016R\u001d\u0010#\u001a\b\u0012\u0004\u0012\u00020\u001e0\u00188\u0006\u00a2\u0006\f\n\u0004\b!\u0010\u001a\u001a\u0004\b\"\u0010\u001cR*\u0010)\u001a\u0016\u0012\u0004\u0012\u00020%\u0018\u00010$j\n\u0012\u0004\u0012\u00020%\u0018\u0001`&8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010(\u00a8\u0006."}, d2 = {"Lcom/tencent/mobileqq/troop/schooltoolbox/viewModel/b;", "Landroidx/lifecycle/ViewModel;", "", "S1", "R1", "M1", "Landroid/os/Bundle;", "i", "Landroid/os/Bundle;", "getBundle", "()Landroid/os/Bundle;", "bundle", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "J", "O1", "()J", "groupCode", "Landroidx/lifecycle/MutableLiveData;", "", "Lcom/tencent/mobileqq/troop/schooltoolbox/data/c;", BdhLogUtil.LogTag.Tag_Conn, "Landroidx/lifecycle/MutableLiveData;", "_liveDataToolboxItems", "Landroidx/lifecycle/LiveData;", "D", "Landroidx/lifecycle/LiveData;", "Q1", "()Landroidx/lifecycle/LiveData;", "liveDataToolboxItems", "", "E", "_liveDataPageState", UserInfo.SEX_FEMALE, "P1", "liveDataPageState", "Ljava/util/ArrayList;", "Lcom/tencent/qqnt/kernel/nativeinterface/GroupAppCategoryInfo;", "Lkotlin/collections/ArrayList;", "G", "Ljava/util/ArrayList;", "dataItems", "<init>", "(Landroid/os/Bundle;)V", "H", "a", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class b extends ViewModel {
    static IPatchRedirector $redirector_;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<List<c>> _liveDataToolboxItems;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final LiveData<List<c>> liveDataToolboxItems;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<Integer> _liveDataPageState;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final LiveData<Integer> liveDataPageState;

    /* renamed from: G, reason: from kotlin metadata */
    @Nullable
    private ArrayList<GroupAppCategoryInfo> dataItems;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Bundle bundle;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final long groupCode;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/troop/schooltoolbox/viewModel/b$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.troop.schooltoolbox.viewModel.b$a, reason: from kotlin metadata */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(54820);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 8)) {
            redirector.redirect((short) 8);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public b(@NotNull Bundle bundle) {
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) bundle);
            return;
        }
        this.bundle = bundle;
        this.groupCode = bundle.getLong("troop_uin", 0L);
        MutableLiveData<List<c>> mutableLiveData = new MutableLiveData<>();
        this._liveDataToolboxItems = mutableLiveData;
        this.liveDataToolboxItems = mutableLiveData;
        MutableLiveData<Integer> mutableLiveData2 = new MutableLiveData<>();
        this._liveDataPageState = mutableLiveData2;
        this.liveDataPageState = mutableLiveData2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void N1(b this$0, int i3, String str, GroupSchoolToolboxInfoRsp groupSchoolToolboxInfoRsp) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (i3 == 0) {
            if (groupSchoolToolboxInfoRsp.dataItems.isEmpty()) {
                this$0._liveDataPageState.postValue(2);
                return;
            }
            this$0.dataItems = groupSchoolToolboxInfoRsp.dataItems;
            this$0.S1();
            this$0._liveDataPageState.postValue(3);
            return;
        }
        QLog.e("SchoolToolboxViewModel", 1, "errCode=" + i3 + " errMsg=" + str + " result=" + groupSchoolToolboxInfoRsp);
        this$0._liveDataPageState.postValue(4);
    }

    private final void S1() {
        int i3;
        Iterator it;
        float b16 = j.f109555a.b(ScreenUtil.getInstantScreenWidth(BaseApplication.context));
        if (b16 < 538.0f) {
            i3 = 2;
        } else if (b16 < 700.0f) {
            i3 = 3;
        } else {
            i3 = 4;
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList<GroupAppCategoryInfo> arrayList3 = this.dataItems;
        if (arrayList3 != null) {
            Iterator it5 = arrayList3.iterator();
            while (it5.hasNext()) {
                GroupAppCategoryInfo groupAppCategoryInfo = (GroupAppCategoryInfo) it5.next();
                if (groupAppCategoryInfo.appItemList.isEmpty()) {
                    it = it5;
                } else {
                    arrayList2.add(new e());
                    String str = groupAppCategoryInfo.title;
                    Intrinsics.checkNotNullExpressionValue(str, "item.title");
                    arrayList2.add(new f(str));
                    arrayList.clear();
                    ArrayList<GroupAppItem> arrayList4 = groupAppCategoryInfo.appItemList;
                    Intrinsics.checkNotNullExpressionValue(arrayList4, "item.appItemList");
                    Iterator it6 = arrayList4.iterator();
                    int i16 = 0;
                    while (it6.hasNext()) {
                        Object next = it6.next();
                        int i17 = i16 + 1;
                        if (i16 < 0) {
                            CollectionsKt__CollectionsKt.throwIndexOverflow();
                        }
                        GroupAppItem groupAppItem = (GroupAppItem) next;
                        long j3 = groupAppItem.appId;
                        String str2 = groupAppItem.iconUrl;
                        Intrinsics.checkNotNullExpressionValue(str2, "it.iconUrl");
                        String str3 = groupAppItem.title;
                        Intrinsics.checkNotNullExpressionValue(str3, "it.title");
                        String str4 = groupAppItem.desc;
                        Iterator it7 = it5;
                        Intrinsics.checkNotNullExpressionValue(str4, "it.desc");
                        String str5 = groupAppItem.jumpUrl;
                        Intrinsics.checkNotNullExpressionValue(str5, "it.jumpUrl");
                        Iterator it8 = it6;
                        arrayList.add(new com.tencent.mobileqq.troop.schooltoolbox.data.a(j3, str2, str3, str4, str5));
                        if (arrayList.size() == i3 || i16 == groupAppCategoryInfo.appItemList.size() - 1) {
                            ArrayList arrayList5 = new ArrayList();
                            arrayList5.addAll(arrayList);
                            arrayList2.add(new com.tencent.mobileqq.troop.schooltoolbox.data.b(arrayList5, i3));
                            arrayList.clear();
                        }
                        i16 = i17;
                        it5 = it7;
                        it6 = it8;
                    }
                    it = it5;
                    arrayList2.add(new d());
                }
                it5 = it;
            }
        }
        this._liveDataToolboxItems.postValue(arrayList2);
    }

    public final void M1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        if (!NetworkUtil.isNetworkAvailable(BaseApplication.getContext())) {
            this._liveDataPageState.postValue(0);
            return;
        }
        this._liveDataPageState.postValue(1);
        r g16 = bg.f302144a.g();
        if (g16 != null) {
            g16.getGroupSchoolToolboxInfo(this.groupCode, new IGetGroupSchoolToolboxInfoCallback() { // from class: com.tencent.mobileqq.troop.schooltoolbox.viewModel.a
                @Override // com.tencent.qqnt.kernel.nativeinterface.IGetGroupSchoolToolboxInfoCallback
                public final void onResult(int i3, String str, GroupSchoolToolboxInfoRsp groupSchoolToolboxInfoRsp) {
                    b.N1(b.this, i3, str, groupSchoolToolboxInfoRsp);
                }
            });
        }
    }

    public final long O1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Long) iPatchRedirector.redirect((short) 3, (Object) this)).longValue();
        }
        return this.groupCode;
    }

    @NotNull
    public final LiveData<Integer> P1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (LiveData) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.liveDataPageState;
    }

    @NotNull
    public final LiveData<List<c>> Q1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (LiveData) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.liveDataToolboxItems;
    }

    public final void R1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        } else {
            S1();
        }
    }
}
