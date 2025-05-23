package com.tencent.mobileqq.zplan.friend;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.state.data.SquareJSConst;
import cooperation.qzone.gift.QZoneCheckSendGiftServlet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;

/* compiled from: P */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010#\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010.\u001a\u00020-\u00a2\u0006\u0004\b/\u00100J\u0014\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002J\u000e\u0010\b\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0003J\u0016\u0010\r\u001a\u00020\f2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tJ\u000e\u0010\u000e\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\u0003J\u0006\u0010\u000f\u001a\u00020\tJ\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002R\u0014\u0010\u0014\u001a\u00020\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\"\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00160\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u001c\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00030\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR \u0010!\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160\u00020\u001e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R \u0010#\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160\u00020\u001e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\"\u0010 R#\u0010)\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160\u00020$8\u0006\u00a2\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(R#\u0010,\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160\u00020$8\u0006\u00a2\u0006\f\n\u0004\b*\u0010&\u001a\u0004\b+\u0010(\u00a8\u00061"}, d2 = {"Lcom/tencent/mobileqq/zplan/friend/FriendViewModel;", "Landroidx/lifecycle/ViewModel;", "", "", SquareJSConst.Params.PARAMS_UIN_LIST, "", "T1", "uin", "W1", "", "fromIndex", "toIndex", "", "U1", "S1", "R1", "Q1", "Lcom/tencent/mobileqq/zplan/friend/FriendRepository;", "i", "Lcom/tencent/mobileqq/zplan/friend/FriendRepository;", "repository", "", "Lcom/tencent/mobileqq/zplan/friend/c;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/util/Map;", "friendMap", "", BdhLogUtil.LogTag.Tag_Conn, "Ljava/util/Set;", "selectSet", "Landroidx/lifecycle/MutableLiveData;", "D", "Landroidx/lifecycle/MutableLiveData;", "_friendList", "E", "_selectList", "Landroidx/lifecycle/LiveData;", UserInfo.SEX_FEMALE, "Landroidx/lifecycle/LiveData;", "O1", "()Landroidx/lifecycle/LiveData;", QZoneCheckSendGiftServlet.PARAM_FRINED_LIST, "G", "P1", "selectList", "Lcom/tencent/common/app/AppInterface;", "app", "<init>", "(Lcom/tencent/common/app/AppInterface;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class FriendViewModel extends ViewModel {

    /* renamed from: C, reason: from kotlin metadata */
    private Set<String> selectSet;

    /* renamed from: D, reason: from kotlin metadata */
    private final MutableLiveData<List<FriendInfo>> _friendList;

    /* renamed from: E, reason: from kotlin metadata */
    private final MutableLiveData<List<FriendInfo>> _selectList;

    /* renamed from: F, reason: from kotlin metadata */
    private final LiveData<List<FriendInfo>> friendList;

    /* renamed from: G, reason: from kotlin metadata */
    private final LiveData<List<FriendInfo>> selectList;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final FriendRepository repository;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private Map<String, FriendInfo> friendMap;

    public FriendViewModel(AppInterface app) {
        Map<String, FriendInfo> emptyMap;
        Intrinsics.checkNotNullParameter(app, "app");
        FriendRepository friendRepository = new FriendRepository(app);
        this.repository = friendRepository;
        emptyMap = MapsKt__MapsKt.emptyMap();
        this.friendMap = emptyMap;
        this.selectSet = new LinkedHashSet();
        MutableLiveData<List<FriendInfo>> mutableLiveData = new MutableLiveData<>();
        this._friendList = mutableLiveData;
        MutableLiveData<List<FriendInfo>> mutableLiveData2 = new MutableLiveData<>();
        this._selectList = mutableLiveData2;
        Intrinsics.checkNotNull(mutableLiveData, "null cannot be cast to non-null type androidx.lifecycle.LiveData<kotlin.collections.List<com.tencent.mobileqq.zplan.friend.FriendInfo>>");
        this.friendList = mutableLiveData;
        Intrinsics.checkNotNull(mutableLiveData2, "null cannot be cast to non-null type androidx.lifecycle.LiveData<kotlin.collections.List<com.tencent.mobileqq.zplan.friend.FriendInfo>>");
        this.selectList = mutableLiveData2;
        friendRepository.d(new Function1<List<? extends FriendInfo>, Unit>() { // from class: com.tencent.mobileqq.zplan.friend.FriendViewModel.1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(List<? extends FriendInfo> list) {
                invoke2((List<FriendInfo>) list);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(List<FriendInfo> list) {
                int collectionSizeOrDefault;
                int mapCapacity;
                int coerceAtLeast;
                Intrinsics.checkNotNullParameter(list, "list");
                FriendViewModel friendViewModel = FriendViewModel.this;
                List<FriendInfo> list2 = list;
                collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list2, 10);
                mapCapacity = MapsKt__MapsJVMKt.mapCapacity(collectionSizeOrDefault);
                coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(mapCapacity, 16);
                LinkedHashMap linkedHashMap = new LinkedHashMap(coerceAtLeast);
                for (Object obj : list2) {
                    linkedHashMap.put(((FriendInfo) obj).getUin(), obj);
                }
                friendViewModel.friendMap = linkedHashMap;
                FriendViewModel.this.selectSet = new LinkedHashSet();
                FriendViewModel.this._friendList.postValue(list);
            }
        });
    }

    public final LiveData<List<FriendInfo>> O1() {
        return this.friendList;
    }

    public final LiveData<List<FriendInfo>> P1() {
        return this.selectList;
    }

    public final List<String> Q1() {
        List<String> emptyList;
        int collectionSizeOrDefault;
        List<FriendInfo> value = this._selectList.getValue();
        if (value == null) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            return emptyList;
        }
        List<FriendInfo> list = value;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(((FriendInfo) it.next()).getUin());
        }
        return arrayList;
    }

    public final int R1() {
        return this.selectSet.size();
    }

    public final boolean S1(String uin) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        return this.selectSet.contains(uin);
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0046, code lost:
    
        r1 = kotlin.collections.CollectionsKt___CollectionsKt.toMutableList((java.util.Collection) r1);
     */
    /* JADX WARN: Multi-variable type inference failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void T1(List<String> uinList) {
        List mutableList;
        Intrinsics.checkNotNullParameter(uinList, "uinList");
        ArrayList arrayList = new ArrayList();
        for (String str : uinList) {
            FriendInfo friendInfo = this.friendMap.get(str);
            if (friendInfo != null && this.selectSet.add(str)) {
                arrayList.add(friendInfo);
            }
        }
        if (!arrayList.isEmpty()) {
            MutableLiveData<List<FriendInfo>> mutableLiveData = this._selectList;
            List<FriendInfo> value = mutableLiveData.getValue();
            if (value != null && mutableList != 0) {
                mutableList.addAll(arrayList);
                arrayList = mutableList;
            }
            mutableLiveData.postValue(arrayList);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x001f, code lost:
    
        r1 = kotlin.collections.CollectionsKt___CollectionsKt.toMutableList((java.util.Collection) r1);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean U1(int fromIndex, int toIndex) {
        List<FriendInfo> emptyList;
        List<FriendInfo> value = this._selectList.getValue();
        int size = value != null ? value.size() : 0;
        if (size <= fromIndex || size <= toIndex) {
            return false;
        }
        MutableLiveData<List<FriendInfo>> mutableLiveData = this._selectList;
        List<FriendInfo> value2 = mutableLiveData.getValue();
        if (value2 == null || emptyList == null) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
        } else {
            Collections.swap(emptyList, fromIndex, toIndex);
        }
        mutableLiveData.postValue(emptyList);
        return true;
    }

    public final void W1(String uin) {
        Collection emptyList;
        Intrinsics.checkNotNullParameter(uin, "uin");
        if (this.friendMap.containsKey(uin) && this.selectSet.remove(uin)) {
            LiveData liveData = this._selectList;
            List list = (List) liveData.getValue();
            if (list == null) {
                emptyList = CollectionsKt__CollectionsKt.emptyList();
            } else {
                emptyList = new ArrayList();
                for (Object obj : list) {
                    if (this.selectSet.contains(((FriendInfo) obj).getUin())) {
                        emptyList.add(obj);
                    }
                }
            }
            liveData.postValue(emptyList);
        }
    }
}
