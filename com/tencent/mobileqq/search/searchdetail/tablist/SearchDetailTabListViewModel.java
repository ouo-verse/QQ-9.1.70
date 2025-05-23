package com.tencent.mobileqq.search.searchdetail.tablist;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.lifecycle.MutableLiveData;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.avbiz.Constants;
import com.tencent.biz.qqcircle.immersive.request.search.QFSSearchBaseRequest;
import com.tencent.biz.richframework.part.BaseViewModel;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.search.searchdetail.SearchDetailFragment;
import com.tencent.mobileqq.search.searchdetail.content.SearchGroupFilterManager;
import com.tencent.mobileqq.search.tux.j;
import com.tencent.mobileqq.search.util.af;
import com.tencent.mobileqq.search.util.ag;
import com.tencent.mobileqq.search.util.ah;
import com.tencent.mobileqq.search.util.ap;
import com.tencent.qphone.base.util.QLog;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u001a\u0018\u0000 <2\u00020\u0001:\u0003HIJB\u0007\u00a2\u0006\u0004\bF\u0010GJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0016\u0010\u0007\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0002J\b\u0010\t\u001a\u00020\bH\u0002J\u0012\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\nJ\u0010\u0010\u000e\u001a\u00020\u00022\b\u0010\r\u001a\u0004\u0018\u00010\fJ\b\u0010\u0010\u001a\u00020\u000fH\u0016J\u000e\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u0005J\u000e\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u0012J\b\u0010\u0016\u001a\u00020\u0002H\u0014R \u0010\u0019\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\"\u0010!\u001a\u00020\u001a8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\"\u0010)\u001a\u00020\"8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\"\u00100\u001a\u00020\u000f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\u001b\u00106\u001a\u0002018FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b2\u00103\u001a\u0004\b4\u00105R\u001b\u00109\u001a\u00020\u000f8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b7\u00103\u001a\u0004\b8\u0010-R*\u0010A\u001a\u00020\u00122\u0006\u0010:\u001a\u00020\u00128\u0006@FX\u0086\u000e\u00a2\u0006\u0012\n\u0004\b;\u0010<\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@R*\u0010E\u001a\u00020\u000f2\u0006\u0010:\u001a\u00020\u000f8\u0006@FX\u0086\u000e\u00a2\u0006\u0012\n\u0004\bB\u0010+\u001a\u0004\bC\u0010-\"\u0004\bD\u0010/\u00a8\u0006K"}, d2 = {"Lcom/tencent/mobileqq/search/searchdetail/tablist/SearchDetailTabListViewModel;", "Lcom/tencent/biz/richframework/part/BaseViewModel;", "", "X1", "", "Lcom/tencent/mobileqq/search/searchdetail/tablist/SearchDetailTabListViewModel$TabInfo;", "tabList", "d2", "Lcom/tencent/mobileqq/search/searchdetail/tablist/SearchDetailTabListViewModel$Tabs;", "U1", "Landroidx/lifecycle/MutableLiveData;", "Q1", "Landroid/os/Bundle;", "fragmentArgs", "init", "", "getLogTag", "tabInfo", "", "M1", QFSSearchBaseRequest.EXTRA_KEY_QUERY_SOURCE, "Z1", "onCleared", "i", "Landroidx/lifecycle/MutableLiveData;", "listItemLiveData", "Lcom/tencent/mobileqq/search/searchdetail/SearchDetailFragment$Companion$a;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/search/searchdetail/SearchDetailFragment$Companion$a;", "R1", "()Lcom/tencent/mobileqq/search/searchdetail/SearchDetailFragment$Companion$a;", "setPageParam", "(Lcom/tencent/mobileqq/search/searchdetail/SearchDetailFragment$Companion$a;)V", "pageParam", "", BdhLogUtil.LogTag.Tag_Conn, "Z", "P1", "()Z", "b2", "(Z)V", "disableCorrectionQuery", "D", "Ljava/lang/String;", "N1", "()Ljava/lang/String;", ICustomDataEditor.STRING_ARRAY_PARAM_2, "(Ljava/lang/String;)V", "currentTraceId", "Lcom/tencent/mobileqq/search/tux/b;", "E", "Lkotlin/Lazy;", "T1", "()Lcom/tencent/mobileqq/search/tux/b;", "searchTuxStatisticIoc", UserInfo.SEX_FEMALE, "O1", "detailPageSessionId", "value", "G", "I", "S1", "()I", "c2", "(I)V", "parentType", "H", "W1", "e2", "wxPreSearchId", "<init>", "()V", "a", "TabInfo", "Tabs", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class SearchDetailTabListViewModel extends BaseViewModel {

    /* renamed from: C, reason: from kotlin metadata */
    private boolean disableCorrectionQuery;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final Lazy searchTuxStatisticIoc;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final Lazy detailPageSessionId;

    /* renamed from: G, reason: from kotlin metadata */
    private int parentType;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private String wxPreSearchId;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final MutableLiveData<List<TabInfo>> listItemLiveData = new MutableLiveData<>();

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private SearchDetailFragment.Companion.NetSearchPageParam pageParam = new SearchDetailFragment.Companion.NetSearchPageParam(null, null, 0, 0, false, 0, null, 0, null, null, null, 0, 4095, null);

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private String currentTraceId = "";

    /* compiled from: P */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\n\u0018\u0000 \u00192\u00020\u0001:\u0001\u0013B\u001b\u0012\b\b\u0002\u0010\u000f\u001a\u00020\t\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0010\u00a2\u0006\u0004\b\u0016\u0010\u0017B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0016\u0010\u0018J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\b\u001a\u00020\u0004H\u0016J\b\u0010\n\u001a\u00020\tH\u0016R\u0017\u0010\u000f\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u0015\u001a\u00020\u00108\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/mobileqq/search/searchdetail/tablist/SearchDetailTabListViewModel$TabInfo;", "Landroid/os/Parcelable;", "Landroid/os/Parcel;", "parcel", "", WadlProxyConsts.FLAGS, "", "writeToParcel", "describeContents", "", "toString", "d", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "tabName", "", "e", "J", "a", "()J", "tabMask", "<init>", "(Ljava/lang/String;J)V", "(Landroid/os/Parcel;)V", "CREATOR", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes18.dex */
    public static final class TabInfo implements Parcelable {

        /* renamed from: CREATOR, reason: from kotlin metadata */
        @NotNull
        public static final Companion INSTANCE = new Companion(null);

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final String tabName;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        private final long tabMask;

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u001f\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a2\u0006\u0004\b\t\u0010\n\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/search/searchdetail/tablist/SearchDetailTabListViewModel$TabInfo$a;", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mobileqq/search/searchdetail/tablist/SearchDetailTabListViewModel$TabInfo;", "Landroid/os/Parcel;", "parcel", "a", "", "size", "", "b", "(I)[Lcom/tencent/mobileqq/search/searchdetail/tablist/SearchDetailTabListViewModel$TabInfo;", "<init>", "()V", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: com.tencent.mobileqq.search.searchdetail.tablist.SearchDetailTabListViewModel$TabInfo$a, reason: from kotlin metadata */
        /* loaded from: classes18.dex */
        public static final class Companion implements Parcelable.Creator<TabInfo> {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            @Override // android.os.Parcelable.Creator
            @NotNull
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public TabInfo createFromParcel(@NotNull Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new TabInfo(parcel);
            }

            @Override // android.os.Parcelable.Creator
            @NotNull
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public TabInfo[] newArray(int size) {
                return new TabInfo[size];
            }

            Companion() {
            }
        }

        public TabInfo() {
            this(null, 0L, 3, null);
        }

        /* renamed from: a, reason: from getter */
        public final long getTabMask() {
            return this.tabMask;
        }

        @NotNull
        /* renamed from: b, reason: from getter */
        public final String getTabName() {
            return this.tabName;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @NotNull
        public String toString() {
            if (QLog.isDebugVersion()) {
                return "TabInfo(tabName='" + ag.b(this.tabName, 0, 1, null) + "', tabMask=" + this.tabMask + ")";
            }
            return "TabInfo(tabMask=" + this.tabMask + ")";
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel parcel, int flags) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            parcel.writeString(this.tabName);
            parcel.writeLong(this.tabMask);
        }

        public TabInfo(@NotNull String tabName, long j3) {
            Intrinsics.checkNotNullParameter(tabName, "tabName");
            this.tabName = tabName;
            this.tabMask = j3;
        }

        public /* synthetic */ TabInfo(String str, long j3, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this((i3 & 1) != 0 ? "" : str, (i3 & 2) != 0 ? 0L : j3);
        }

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public TabInfo(@NotNull Parcel parcel) {
            this(r0 == null ? "" : r0, parcel.readLong());
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            String readString = parcel.readString();
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 \u00132\u00020\u0001:\u0001\rB\u0015\u0012\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\n0\t\u00a2\u0006\u0004\b\u0010\u0010\u0011B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0010\u0010\u0012J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\b\u001a\u00020\u0004H\u0016R\u001d\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/search/searchdetail/tablist/SearchDetailTabListViewModel$Tabs;", "Landroid/os/Parcelable;", "Landroid/os/Parcel;", "parcel", "", WadlProxyConsts.FLAGS, "", "writeToParcel", "describeContents", "", "Lcom/tencent/mobileqq/search/searchdetail/tablist/SearchDetailTabListViewModel$TabInfo;", "d", "Ljava/util/List;", "a", "()Ljava/util/List;", "list", "<init>", "(Ljava/util/List;)V", "(Landroid/os/Parcel;)V", "CREATOR", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes18.dex */
    public static final class Tabs implements Parcelable {

        /* renamed from: CREATOR, reason: from kotlin metadata */
        @NotNull
        public static final Companion INSTANCE = new Companion(null);

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final List<TabInfo> list;

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u001f\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a2\u0006\u0004\b\t\u0010\n\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/search/searchdetail/tablist/SearchDetailTabListViewModel$Tabs$a;", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mobileqq/search/searchdetail/tablist/SearchDetailTabListViewModel$Tabs;", "Landroid/os/Parcel;", "parcel", "a", "", "size", "", "b", "(I)[Lcom/tencent/mobileqq/search/searchdetail/tablist/SearchDetailTabListViewModel$Tabs;", "<init>", "()V", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: com.tencent.mobileqq.search.searchdetail.tablist.SearchDetailTabListViewModel$Tabs$a, reason: from kotlin metadata */
        /* loaded from: classes18.dex */
        public static final class Companion implements Parcelable.Creator<Tabs> {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            @Override // android.os.Parcelable.Creator
            @NotNull
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public Tabs createFromParcel(@NotNull Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new Tabs(parcel);
            }

            @Override // android.os.Parcelable.Creator
            @NotNull
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public Tabs[] newArray(int size) {
                return new Tabs[size];
            }

            Companion() {
            }
        }

        public Tabs(@NotNull List<TabInfo> list) {
            Intrinsics.checkNotNullParameter(list, "list");
            this.list = list;
        }

        @NotNull
        public final List<TabInfo> a() {
            return this.list;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel parcel, int flags) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            parcel.writeTypedList(this.list);
        }

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public Tabs(@NotNull Parcel parcel) {
            this((List<TabInfo>) (r2 == null ? CollectionsKt__CollectionsKt.emptyList() : r2));
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            List createTypedArrayList = parcel.createTypedArrayList(TabInfo.INSTANCE);
        }
    }

    public SearchDetailTabListViewModel() {
        Lazy lazy;
        Lazy lazy2;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<j>() { // from class: com.tencent.mobileqq.search.searchdetail.tablist.SearchDetailTabListViewModel$searchTuxStatisticIoc$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final j invoke() {
                return new j(null, 1, null);
            }
        });
        this.searchTuxStatisticIoc = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<String>() { // from class: com.tencent.mobileqq.search.searchdetail.tablist.SearchDetailTabListViewModel$detailPageSessionId$2
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final String invoke() {
                return System.currentTimeMillis() + "_" + ap.f285014a.a();
            }
        });
        this.detailPageSessionId = lazy2;
        this.wxPreSearchId = "";
    }

    private final Tabs U1() {
        Tabs g16 = ah.f284994a.g();
        if (g16 != null && !g16.a().isEmpty()) {
            return g16;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(new TabInfo("\u5168\u90e8", 1L));
        arrayList.add(new TabInfo("\u7528\u6237", 5L));
        arrayList.add(new TabInfo("\u7fa4\u804a", 6L));
        arrayList.add(new TabInfo("\u9891\u9053", 3L));
        arrayList.add(new TabInfo("\u8868\u60c5", 4L));
        arrayList.add(new TabInfo("\u673a\u5668\u4eba", 10L));
        arrayList.add(new TabInfo(Constants.Business.QQCIRCLE, 2L));
        return new Tabs(arrayList);
    }

    private final void X1() {
        d2(U1().a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void d2(List<TabInfo> tabList) {
        boolean z16;
        long tabMask = this.pageParam.getTabMask();
        if (((int) tabMask) == 0) {
            tabMask = 1;
        }
        long j3 = tabMask;
        if (this.pageParam.getHideTab()) {
            ArrayList arrayList = new ArrayList();
            for (Object obj : tabList) {
                if (((TabInfo) obj).getTabMask() == j3) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    arrayList.add(obj);
                }
            }
            if (arrayList.isEmpty()) {
                arrayList = new ArrayList();
                arrayList.add(new TabInfo(null, j3, 1, null));
            }
            this.listItemLiveData.postValue(arrayList);
            return;
        }
        this.listItemLiveData.postValue(tabList);
    }

    public final int M1(@NotNull TabInfo tabInfo) {
        boolean z16;
        Intrinsics.checkNotNullParameter(tabInfo, "tabInfo");
        List<TabInfo> value = this.listItemLiveData.getValue();
        if (value == null) {
            return -1;
        }
        int i3 = 0;
        for (TabInfo tabInfo2 : value) {
            if (!Intrinsics.areEqual(tabInfo2.getTabName(), tabInfo.getTabName()) && tabInfo2.getTabMask() != tabInfo.getTabMask()) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (z16) {
                return i3;
            }
            i3++;
        }
        return -1;
    }

    @NotNull
    /* renamed from: N1, reason: from getter */
    public final String getCurrentTraceId() {
        return this.currentTraceId;
    }

    @NotNull
    public final String O1() {
        return (String) this.detailPageSessionId.getValue();
    }

    /* renamed from: P1, reason: from getter */
    public final boolean getDisableCorrectionQuery() {
        return this.disableCorrectionQuery;
    }

    @NotNull
    public final MutableLiveData<List<TabInfo>> Q1() {
        return this.listItemLiveData;
    }

    @NotNull
    /* renamed from: R1, reason: from getter */
    public final SearchDetailFragment.Companion.NetSearchPageParam getPageParam() {
        return this.pageParam;
    }

    /* renamed from: S1, reason: from getter */
    public final int getParentType() {
        return this.parentType;
    }

    @NotNull
    public final com.tencent.mobileqq.search.tux.b T1() {
        return (com.tencent.mobileqq.search.tux.b) this.searchTuxStatisticIoc.getValue();
    }

    @NotNull
    /* renamed from: W1, reason: from getter */
    public final String getWxPreSearchId() {
        return this.wxPreSearchId;
    }

    public final void Z1(int querySource) {
        X1();
        SearchGroupFilterManager.f283869a.d(new SearchDetailTabListViewModel$loadTabs$1(this, querySource));
    }

    public final void a2(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.currentTraceId = str;
    }

    public final void b2(boolean z16) {
        this.disableCorrectionQuery = z16;
    }

    public final void c2(int i3) {
        af afVar = af.f284993a;
        if (QLog.isDebugVersion()) {
            QLog.d("QS.QQSearch.NetDetail.SearchDetailTabListViewModel", 2, "parentType: " + i3, (Throwable) null);
        }
        this.parentType = i3;
    }

    public final void e2(@NotNull String value) {
        boolean isBlank;
        Intrinsics.checkNotNullParameter(value, "value");
        isBlank = StringsKt__StringsJVMKt.isBlank(value);
        if (!isBlank) {
            af afVar = af.f284993a;
            if (QLog.isDebugVersion()) {
                QLog.d("QS.QQSearch.NetDetail.SearchDetailTabListViewModel", 2, "wxPreSearchId: " + value, (Throwable) null);
            }
            this.wxPreSearchId = value;
            return;
        }
        af afVar2 = af.f284993a;
        if (QLog.isDebugVersion()) {
            QLog.d("QS.QQSearch.NetDetail.SearchDetailTabListViewModel", 2, "new wxPreSearchId is empty", (Throwable) null);
        }
    }

    @Override // com.tencent.biz.richframework.part.BaseViewModel
    @NotNull
    public String getLogTag() {
        return "QQSearch.NetDetail.SearchDetailTabListViewModel";
    }

    public final void init(@Nullable Bundle fragmentArgs) {
        if (fragmentArgs != null) {
            SearchDetailFragment.Companion.NetSearchPageParam a16 = SearchDetailFragment.INSTANCE.a(fragmentArgs);
            this.pageParam = a16;
            c2(com.tencent.mobileqq.search.searchdetail.content.wxminapp.c.b(com.tencent.mobileqq.search.searchdetail.content.wxminapp.c.f284375a, a16.getQuerySource(), null, 2, null));
            e2(this.pageParam.getWxSugSearchId());
            af afVar = af.f284993a;
            QLog.i("QS.QQSearch.NetDetail.SearchDetailTabListViewModel", 1, "init " + this.pageParam + " parentType=" + this.parentType + " wxPreSearchId=" + this.wxPreSearchId, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        super.onCleared();
        SearchGroupFilterManager.f283869a.g();
    }
}
