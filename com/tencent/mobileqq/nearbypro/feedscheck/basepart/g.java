package com.tencent.mobileqq.nearbypro.feedscheck.basepart;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.nearbypro.avatar.AvatarData;
import com.tencent.mobileqq.nearbypro.base.NearbyNetError;
import com.tencent.mobileqq.nearbypro.base.j;
import com.tencent.mobileqq.nearbypro.base.l;
import com.tencent.mobileqq.nearbypro.utils.s;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import op4.i;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 52\u00020\u0001:\u00016B\u0007\u00a2\u0006\u0004\b3\u00104J(\u0010\t\u001a\u00020\b2\u0016\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0012\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u000b0\nJ\u0018\u0010\u0010\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\r0\nJ\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\nJ \u0010\u0015\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u000f2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006J\u000e\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u0016J\u000e\u0010\u001a\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\u0018R\u001d\u0010!\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001b8\u0006\u00a2\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u0017\u0010'\u001a\u00020\"8\u0006\u00a2\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&R \u0010)\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u000b0\u001b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b(\u0010\u001eR&\u0010+\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\r0\u001b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b*\u0010\u001eR0\u00100\u001a\u001e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0,j\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f`-8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b.\u0010/R\u001c\u00102\u001a\b\u0012\u0004\u0012\u00020\u00110\u001b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b1\u0010\u001e\u00a8\u00067"}, d2 = {"Lcom/tencent/mobileqq/nearbypro/feedscheck/basepart/g;", "Landroidx/lifecycle/ViewModel;", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/nearbypro/feedscheck/basepart/h;", "Lkotlin/collections/ArrayList;", "dstFeedsList", "Lop4/i;", "statusFeed", "", "O1", "Landroidx/lifecycle/LiveData;", "", "Z1", "", "", "", "X1", "Lxp4/h;", ICustomDataEditor.STRING_ARRAY_PARAM_2, "tinyId", "isOnline", "T1", "", "R1", "", "feedPosition", "P1", "Landroidx/lifecycle/MutableLiveData;", "Lcom/tencent/mobileqq/nearbypro/avatar/b;", "i", "Landroidx/lifecycle/MutableLiveData;", "W1", "()Landroidx/lifecycle/MutableLiveData;", "avatarData", "Lcom/tencent/mobileqq/nearbypro/feedscheck/basepart/c;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/nearbypro/feedscheck/basepart/c;", "getRepo", "()Lcom/tencent/mobileqq/nearbypro/feedscheck/basepart/c;", "repo", BdhLogUtil.LogTag.Tag_Conn, "listData", "D", "feedsLikeInfo", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "E", "Ljava/util/HashMap;", "likeInfoMap", UserInfo.SEX_FEMALE, "personInfo", "<init>", "()V", "G", "a", "qq_nearby_pro_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class g extends ViewModel {

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final MutableLiveData<AvatarData> avatarData = new MutableLiveData<>();

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final c repo = new c();

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<List<StatusFeedData>> listData = new MutableLiveData<>();

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<Map<String, Boolean>> feedsLikeInfo = new MutableLiveData<>();

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final HashMap<String, Boolean> likeInfoMap = new HashMap<>();

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private MutableLiveData<xp4.h> personInfo = new MutableLiveData<>();

    private final void O1(ArrayList<StatusFeedData> dstFeedsList, i statusFeed) {
        if (statusFeed.f423354d == null) {
            ga2.a c16 = j.c();
            String str = statusFeed.f423351a;
            if (str == null) {
                str = "";
            }
            c16.d("NBP.FeedsCheckPart.FeedsViewModel", "[addFeedsInfoList]: filament is null: " + str);
            return;
        }
        dstFeedsList.add(new StatusFeedData(2, statusFeed, null, 4, null));
        op4.d dVar = statusFeed.f423359i;
        if (dVar != null) {
            HashMap<String, Boolean> hashMap = this.likeInfoMap;
            String str2 = dVar.f423310a;
            Intrinsics.checkNotNullExpressionValue(str2, "statusFeed.likeInfo.id");
            boolean z16 = true;
            if (statusFeed.f423359i.f423313d != 1) {
                z16 = false;
            }
            hashMap.put(str2, Boolean.valueOf(z16));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Q1(g this$0, String feedId, StatusFeedData curFeedInfo, NearbyNetError error, op4.d dVar) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(curFeedInfo, "$curFeedInfo");
        Intrinsics.checkNotNullParameter(error, "error");
        HashMap<String, Boolean> hashMap = this$0.likeInfoMap;
        Intrinsics.checkNotNullExpressionValue(feedId, "feedId");
        boolean z16 = false;
        if (dVar != null && dVar.f423313d == 1) {
            z16 = true;
        }
        hashMap.put(feedId, Boolean.valueOf(z16));
        this$0.feedsLikeInfo.setValue(this$0.likeInfoMap);
        curFeedInfo.getStatusFeed().f423359i = dVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void S1(g this$0, NearbyNetError error, xp4.h hVar) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(error, "error");
        if (error.getSuccess() && hVar != null) {
            this$0.personInfo.setValue(hVar);
            return;
        }
        String message = error.getMessage();
        if (message != null) {
            s.c(message);
        }
        j.c().e("NBP.FeedsCheckPart.FeedsViewModel", "fetchUserCurrentPos is fail");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0045  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00ca  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00b2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void U1(i iVar, g this$0, boolean z16, NearbyNetError error, up4.b bVar) {
        i[] iVarArr;
        boolean z17;
        boolean z18;
        boolean z19;
        up4.c cVar;
        String str;
        boolean z26;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(error, "error");
        if (error.getCode() == 0) {
            ArrayList<StatusFeedData> arrayList = new ArrayList<>();
            if (iVar != null) {
                this$0.O1(arrayList, iVar);
            }
            if (bVar != null) {
                iVarArr = bVar.f439767a;
            } else {
                iVarArr = null;
            }
            boolean z27 = true;
            if (iVarArr != null) {
                if (iVarArr.length == 0) {
                    z26 = true;
                } else {
                    z26 = false;
                }
                if (!z26) {
                    z17 = false;
                    if (!z17) {
                        this$0.likeInfoMap.clear();
                        for (i it : iVarArr) {
                            j.c().e("NBP.FeedsCheckPart.FeedsViewModel", "fetchUserStatusList add feedID: " + it.f423351a);
                            String str2 = it.f423351a;
                            if (iVar != null) {
                                str = iVar.f423351a;
                            } else {
                                str = null;
                            }
                            if (!Intrinsics.areEqual(str2, str)) {
                                Intrinsics.checkNotNullExpressionValue(it, "it");
                                this$0.O1(arrayList, it);
                            }
                        }
                    }
                    if (bVar == null && (cVar = bVar.f439772f) != null && cVar.f439773a) {
                        z18 = true;
                    } else {
                        z18 = false;
                    }
                    if (z18) {
                        arrayList.add(new StatusFeedData(3, null, bVar.f439772f));
                    }
                    if (!z16) {
                        z19 = false;
                        arrayList.add(0, new StatusFeedData(1, null, null, 4, null));
                    } else {
                        z19 = false;
                    }
                    this$0.listData.setValue(arrayList);
                    this$0.feedsLikeInfo.setValue(this$0.likeInfoMap);
                    ga2.a c16 = j.c();
                    int size = arrayList.size();
                    if (iVar != null) {
                        z27 = z19;
                    }
                    c16.e("NBP.FeedsCheckPart.FeedsViewModel", "fetchUserStatusList size= " + size + ", isOnline= " + z16 + ", statusFeed is null=" + z27);
                }
            }
            z17 = true;
            if (!z17) {
            }
            if (bVar == null) {
            }
            z18 = false;
            if (z18) {
            }
            if (!z16) {
            }
            this$0.listData.setValue(arrayList);
            this$0.feedsLikeInfo.setValue(this$0.likeInfoMap);
            ga2.a c162 = j.c();
            int size2 = arrayList.size();
            if (iVar != null) {
            }
            c162.e("NBP.FeedsCheckPart.FeedsViewModel", "fetchUserStatusList size= " + size2 + ", isOnline= " + z16 + ", statusFeed is null=" + z27);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void P1(int feedPosition) {
        final StatusFeedData statusFeedData;
        byte b16;
        List<StatusFeedData> value = this.listData.getValue();
        if (value != null && (statusFeedData = value.get(feedPosition)) != null) {
            i statusFeed = statusFeedData.getStatusFeed();
            Intrinsics.checkNotNull(statusFeed);
            final String feedId = statusFeed.f423351a;
            Map<String, Boolean> value2 = this.feedsLikeInfo.getValue();
            boolean z16 = false;
            if (value2 != null && !value2.isEmpty()) {
                b16 = false;
            } else {
                b16 = true;
            }
            if (b16 != false) {
                j.c().e("NBP.FeedsCheckPart.FeedsViewModel", "doILikeRequest like info is null, please check");
                return;
            }
            Map<String, Boolean> value3 = this.feedsLikeInfo.getValue();
            Intrinsics.checkNotNull(value3);
            int i3 = !Intrinsics.areEqual(value3.get(feedId), Boolean.TRUE) ? 1 : 0;
            HashMap<String, Boolean> hashMap = this.likeInfoMap;
            Intrinsics.checkNotNullExpressionValue(feedId, "feedId");
            if (i3 == 1) {
                z16 = true;
            }
            hashMap.put(feedId, Boolean.valueOf(z16));
            this.feedsLikeInfo.setValue(this.likeInfoMap);
            qa2.a.f428765a.b(statusFeedData.getStatusFeed(), i3);
            c cVar = this.repo;
            String longToString = StringUtil.longToString(statusFeedData.getStatusFeed().f423352b.f434140a);
            Intrinsics.checkNotNullExpressionValue(longToString, "longToString(curFeedInfo.statusFeed.poster.tid)");
            cVar.p(i3, feedId, longToString, new l() { // from class: com.tencent.mobileqq.nearbypro.feedscheck.basepart.e
                @Override // com.tencent.mobileqq.nearbypro.base.l
                public final void a(NearbyNetError nearbyNetError, Object obj) {
                    g.Q1(g.this, feedId, statusFeedData, nearbyNetError, (op4.d) obj);
                }
            });
        }
    }

    public final void R1(long tinyId) {
        this.repo.l(tinyId, new l() { // from class: com.tencent.mobileqq.nearbypro.feedscheck.basepart.f
            @Override // com.tencent.mobileqq.nearbypro.base.l
            public final void a(NearbyNetError nearbyNetError, Object obj) {
                g.S1(g.this, nearbyNetError, (xp4.h) obj);
            }
        });
    }

    public final void T1(@NotNull String tinyId, final boolean isOnline, @Nullable final i statusFeed) {
        Intrinsics.checkNotNullParameter(tinyId, "tinyId");
        this.repo.n(tinyId, new l() { // from class: com.tencent.mobileqq.nearbypro.feedscheck.basepart.d
            @Override // com.tencent.mobileqq.nearbypro.base.l
            public final void a(NearbyNetError nearbyNetError, Object obj) {
                g.U1(i.this, this, isOnline, nearbyNetError, (up4.b) obj);
            }
        });
    }

    @NotNull
    public final MutableLiveData<AvatarData> W1() {
        return this.avatarData;
    }

    @NotNull
    public final LiveData<Map<String, Boolean>> X1() {
        return this.feedsLikeInfo;
    }

    @NotNull
    public final LiveData<List<StatusFeedData>> Z1() {
        return this.listData;
    }

    @NotNull
    public final LiveData<xp4.h> a2() {
        return this.personInfo;
    }
}
