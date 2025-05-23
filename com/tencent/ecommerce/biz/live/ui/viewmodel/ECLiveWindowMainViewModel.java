package com.tencent.ecommerce.biz.live.ui.viewmodel;

import android.app.Application;
import android.content.Intent;
import android.os.Looper;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ecommerce.biz.common.RefreshStatus;
import com.tencent.ecommerce.biz.live.LiveTabId;
import com.tencent.ecommerce.repo.live.ECLiveTabInfoRepo;
import com.tencent.ecommerce.repo.live.TabInfo;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import wg0.a;

/* compiled from: P */
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 `2\u00020\u0001:\u0001aB\u0007\u00a2\u0006\u0004\b_\u00100J\u0016\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0005H\u0002J\u0010\u0010\n\u001a\u00020\u00052\b\u0010\t\u001a\u0004\u0018\u00010\bJ\u000e\u0010\f\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u0003J\u0006\u0010\u000e\u001a\u00020\rJ\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0010\u001a\u00020\u000fJ\u0006\u0010\u0012\u001a\u00020\u000fJ\u0016\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u000fJ\u000e\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u0016J\u000e\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u0016J\u0010\u0010\u001c\u001a\u00020\u00052\b\b\u0001\u0010\u001b\u001a\u00020\u000fJ\u0006\u0010\u001d\u001a\u00020\u0016R\"\u0010\"\u001a\u0010\u0012\f\u0012\n \u001f*\u0004\u0018\u00010\u00160\u00160\u001e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b \u0010!R$\u0010'\u001a\u0012\u0012\u0004\u0012\u00020\u00030#j\b\u0012\u0004\u0012\u00020\u0003`$8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u001a\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00030\u001e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b(\u0010!R\"\u0010+\u001a\u0010\u0012\f\u0012\n \u001f*\u0004\u0018\u00010\u00160\u00160\u001e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b*\u0010!R\u001a\u00101\u001a\u00020,8\u0002X\u0083\u0004\u00a2\u0006\f\n\u0004\b-\u0010.\u0012\u0004\b/\u00100R\u001d\u00107\u001a\b\u0012\u0004\u0012\u00020\u0016028\u0006\u00a2\u0006\f\n\u0004\b3\u00104\u001a\u0004\b5\u00106R#\u0010;\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u001e8\u0006\u00a2\u0006\f\n\u0004\b8\u0010!\u001a\u0004\b9\u0010:R\u001d\u0010>\u001a\b\u0012\u0004\u0012\u00020\u0003028\u0006\u00a2\u0006\f\n\u0004\b<\u00104\u001a\u0004\b=\u00106R\u001d\u0010A\u001a\b\u0012\u0004\u0012\u00020\u0016028\u0006\u00a2\u0006\f\n\u0004\b?\u00104\u001a\u0004\b@\u00106R.\u0010E\u001a\u0010\u0012\f\u0012\n \u001f*\u0004\u0018\u00010\u000f0\u000f0\u001e8\u0006X\u0087\u0004\u00a2\u0006\u0012\n\u0004\bB\u0010!\u0012\u0004\bD\u00100\u001a\u0004\bC\u0010:R\u0016\u0010H\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bF\u0010GR\u0016\u0010J\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bI\u0010GR\u0016\u0010N\u001a\u00020K8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bL\u0010MR\u0016\u0010Q\u001a\u00020O8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bP\u0010BR\u0016\u0010S\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bR\u0010?R\u0016\u0010U\u001a\u00020K8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bT\u0010MR\u0016\u0010X\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bV\u0010WR\u0016\u0010Z\u001a\u00020K8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bY\u0010MR\u0014\u0010^\u001a\u00020[8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\\\u0010]\u00a8\u0006b"}, d2 = {"Lcom/tencent/ecommerce/biz/live/ui/viewmodel/ECLiveWindowMainViewModel;", "Landroidx/lifecycle/ViewModel;", "", "Lcom/tencent/ecommerce/repo/live/TabInfo;", "tabList", "", "d2", "Z1", "Landroid/content/Intent;", "intent", "U1", "tabInfo", ICustomDataEditor.STRING_ARRAY_PARAM_2, "Lcom/tencent/ecommerce/biz/live/LiveTabId;", "Q1", "", "position", "S1", "M1", "tabId", "total", "e2", "", "editable", "b2", "isCouponScene", "X1", "status", "c2", "W1", "Landroidx/lifecycle/MutableLiveData;", "kotlin.jvm.PlatformType", "i", "Landroidx/lifecycle/MutableLiveData;", "_isEditable", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/util/ArrayList;", "_liveTabList", BdhLogUtil.LogTag.Tag_Conn, "_curTab", "D", "_contentSizeChange", "Ljava/util/concurrent/atomic/AtomicInteger;", "E", "Ljava/util/concurrent/atomic/AtomicInteger;", "get_refreshStatus$annotations", "()V", "_refreshStatus", "Landroidx/lifecycle/LiveData;", UserInfo.SEX_FEMALE, "Landroidx/lifecycle/LiveData;", "O1", "()Landroidx/lifecycle/LiveData;", "curTabEditableLiveData", "G", "T1", "()Landroidx/lifecycle/MutableLiveData;", "tabListLiveData", "H", "P1", "curTabLiveData", "I", "N1", "contentSizeChangeLiveData", "J", "R1", "getRefreshStatusLiveData$annotations", "refreshStatusLiveData", "K", "Z", "isLiveOpened", "L", "isMaster", "", "M", "Ljava/lang/String;", "liveUserId", "", "N", "liveRoomId", "P", WadlProxyConsts.CHANNEL, AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "cookie", BdhLogUtil.LogTag.Tag_Req, "Lcom/tencent/ecommerce/biz/live/LiveTabId;", "defaultTabId", ExifInterface.LATITUDE_SOUTH, "couponId", "Landroid/app/Application;", "T", "Landroid/app/Application;", "ctx", "<init>", "U", "a", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class ECLiveWindowMainViewModel extends ViewModel {

    /* renamed from: C, reason: from kotlin metadata */
    private final MutableLiveData<TabInfo> _curTab;

    /* renamed from: D, reason: from kotlin metadata */
    private final MutableLiveData<Boolean> _contentSizeChange;

    /* renamed from: E, reason: from kotlin metadata */
    private final AtomicInteger _refreshStatus;

    /* renamed from: F, reason: from kotlin metadata */
    private final LiveData<Boolean> curTabEditableLiveData;

    /* renamed from: G, reason: from kotlin metadata */
    private final MutableLiveData<List<TabInfo>> tabListLiveData;

    /* renamed from: H, reason: from kotlin metadata */
    private final LiveData<TabInfo> curTabLiveData;

    /* renamed from: I, reason: from kotlin metadata */
    private final LiveData<Boolean> contentSizeChangeLiveData;

    /* renamed from: J, reason: from kotlin metadata */
    private final MutableLiveData<Integer> refreshStatusLiveData;

    /* renamed from: K, reason: from kotlin metadata */
    private boolean isLiveOpened;

    /* renamed from: L, reason: from kotlin metadata */
    private boolean isMaster;

    /* renamed from: M, reason: from kotlin metadata */
    private String liveUserId;

    /* renamed from: N, reason: from kotlin metadata */
    private long liveRoomId;

    /* renamed from: P, reason: from kotlin metadata */
    private int channel;

    /* renamed from: Q, reason: from kotlin metadata */
    private String cookie;

    /* renamed from: R, reason: from kotlin metadata */
    private LiveTabId defaultTabId;

    /* renamed from: S, reason: from kotlin metadata */
    private String couponId;

    /* renamed from: T, reason: from kotlin metadata */
    private final Application ctx;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final MutableLiveData<Boolean> _isEditable;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final ArrayList<TabInfo> _liveTabList;

    public ECLiveWindowMainViewModel() {
        Boolean bool = Boolean.FALSE;
        MutableLiveData<Boolean> mutableLiveData = new MutableLiveData<>(bool);
        this._isEditable = mutableLiveData;
        ArrayList<TabInfo> arrayList = new ArrayList<>();
        this._liveTabList = arrayList;
        MutableLiveData<TabInfo> mutableLiveData2 = new MutableLiveData<>();
        this._curTab = mutableLiveData2;
        MutableLiveData<Boolean> mutableLiveData3 = new MutableLiveData<>(bool);
        this._contentSizeChange = mutableLiveData3;
        AtomicInteger atomicInteger = new AtomicInteger(0);
        this._refreshStatus = atomicInteger;
        this.curTabEditableLiveData = mutableLiveData;
        this.tabListLiveData = new MutableLiveData<>(arrayList);
        this.curTabLiveData = mutableLiveData2;
        this.contentSizeChangeLiveData = mutableLiveData3;
        this.refreshStatusLiveData = new MutableLiveData<>(Integer.valueOf(atomicInteger.get()));
        this.liveUserId = "";
        this.cookie = "";
        this.defaultTabId = LiveTabId.LIVE_TAB_NONE;
        this.couponId = "";
        this.ctx = a.a();
    }

    private final void Z1() {
        cg0.a.f("ECLiveWindowMainViewModel", "setContentSizeChanged");
        this._contentSizeChange.setValue(Boolean.TRUE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void d2(List<TabInfo> tabList) {
        Collection<? extends TabInfo> arrayList;
        if (this.isLiveOpened) {
            arrayList = tabList;
        } else {
            arrayList = new ArrayList<>();
            for (Object obj : tabList) {
                LiveTabId liveTabId = ((TabInfo) obj).id;
                if ((liveTabId == LiveTabId.LIVE_TAB_GOK || liveTabId == LiveTabId.LIVE_TAB_NONE) ? false : true) {
                    arrayList.add(obj);
                }
            }
        }
        cg0.a.b("ECLiveWindowMainViewModel", "setTabList, tabList:" + tabList + ", filteredTabList:" + arrayList);
        this._liveTabList.clear();
        if (arrayList != null) {
            this._liveTabList.addAll(arrayList);
        }
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper())) {
            this.tabListLiveData.setValue(this._liveTabList);
        } else {
            this.tabListLiveData.postValue(this._liveTabList);
        }
    }

    public final int M1() {
        int size = this._liveTabList.size();
        for (int i3 = 0; i3 < size; i3++) {
            if (this._liveTabList.get(i3).isAnchored) {
                return i3;
            }
        }
        return -1;
    }

    public final LiveData<Boolean> N1() {
        return this.contentSizeChangeLiveData;
    }

    public final LiveData<Boolean> O1() {
        return this.curTabEditableLiveData;
    }

    public final LiveData<TabInfo> P1() {
        return this.curTabLiveData;
    }

    public final LiveTabId Q1() {
        LiveTabId liveTabId;
        TabInfo value = this.curTabLiveData.getValue();
        return (value == null || (liveTabId = value.id) == null) ? LiveTabId.LIVE_TAB_PRODUCT : liveTabId;
    }

    public final MutableLiveData<Integer> R1() {
        return this.refreshStatusLiveData;
    }

    public final TabInfo S1(int position) {
        int size = this._liveTabList.size();
        if (position >= 0 && size > position) {
            return this._liveTabList.get(position);
        }
        return null;
    }

    public final MutableLiveData<List<TabInfo>> T1() {
        return this.tabListLiveData;
    }

    public final boolean W1() {
        List<TabInfo> value = this.tabListLiveData.getValue();
        return value != null && value.size() == 0;
    }

    public final void X1(boolean isCouponScene) {
        LiveTabId liveTabId;
        cg0.a.b("ECLiveWindowMainViewModel", "requestTabList start, isMaster:" + this.isMaster + ", liveUserId:" + this.liveUserId + ", liveRoomId:{" + this.liveRoomId + "}, channel:{" + this.channel + '}');
        if (!this.isLiveOpened && (liveTabId = this.defaultTabId) != LiveTabId.LIVE_TAB_NONE) {
            ECLiveTabInfoRepo.f105070b.k(liveTabId, new Function1<List<TabInfo>, Unit>() { // from class: com.tencent.ecommerce.biz.live.ui.viewmodel.ECLiveWindowMainViewModel$requestTabList$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(List<TabInfo> list) {
                    invoke2(list);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(List<TabInfo> list) {
                    cg0.a.b("ECLiveWindowMainViewModel", "requestTabList onSuccess, listSize:" + list.size());
                    ECLiveWindowMainViewModel.this.d2(list);
                }
            });
        } else {
            c2(1);
            ECLiveTabInfoRepo.f105070b.l(this.isMaster, this.channel, this.liveRoomId, isCouponScene, new Function1<List<TabInfo>, Unit>() { // from class: com.tencent.ecommerce.biz.live.ui.viewmodel.ECLiveWindowMainViewModel$requestTabList$2
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(List<TabInfo> list) {
                    invoke2(list);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(List<TabInfo> list) {
                    cg0.a.b("ECLiveWindowMainViewModel", "requestTabList onSuccess, listSize:" + list.size());
                    ECLiveWindowMainViewModel.this.d2(list);
                }
            }, new Function2<Integer, String, Unit>() { // from class: com.tencent.ecommerce.biz.live.ui.viewmodel.ECLiveWindowMainViewModel$requestTabList$3
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Integer num, String str) {
                    invoke(num.intValue(), str);
                    return Unit.INSTANCE;
                }

                public final void invoke(int i3, String str) {
                    ECLiveWindowMainViewModel.this.c2(3);
                    cg0.a.a("ECLiveWindowMainViewModel", "requestTabList", "rsp error, code=" + i3 + ", msg=" + str);
                }
            });
        }
    }

    public final void a2(TabInfo tabInfo) {
        this._curTab.setValue(tabInfo);
    }

    public final void b2(boolean editable) {
        this._isEditable.setValue(Boolean.valueOf(editable));
    }

    public final void c2(@RefreshStatus int status) {
        this._refreshStatus.set(status);
        this.refreshStatusLiveData.postValue(Integer.valueOf(status));
    }

    public final void e2(LiveTabId tabId, int total) {
        cg0.a.b("ECLiveWindowMainViewModel", "updateTabContentCount tabId:" + tabId + " total:" + total);
        Iterator<TabInfo> it = this._liveTabList.iterator();
        while (it.hasNext()) {
            TabInfo next = it.next();
            if (next.id == tabId && total != next.getTotal()) {
                next.c(total);
                Z1();
                return;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x005e, code lost:
    
        r2 = kotlin.text.StringsKt__StringNumberConversionsKt.toIntOrNull(r2);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void U1(Intent intent) {
        int value;
        Integer intOrNull;
        if (intent != null) {
            this.isLiveOpened = Intrinsics.areEqual(intent.getStringExtra("is_live_opened"), "1");
            this.isMaster = Intrinsics.areEqual(intent.getStringExtra("is_master"), "1");
            String stringExtra = intent.getStringExtra("live_user_id");
            if (stringExtra == null) {
                stringExtra = "";
            }
            this.liveUserId = stringExtra;
            String stringExtra2 = intent.getStringExtra("live_room_id");
            if (stringExtra2 == null) {
                stringExtra2 = "0";
            }
            this.liveRoomId = Long.parseLong(stringExtra2);
            String stringExtra3 = intent.getStringExtra(WadlProxyConsts.CHANNEL);
            this.channel = Integer.parseInt(stringExtra3 != null ? stringExtra3 : "0");
            LiveTabId.Companion companion = LiveTabId.INSTANCE;
            String stringExtra4 = intent.getStringExtra("default_tab_id");
            if (stringExtra4 != null && intOrNull != null) {
                value = intOrNull.intValue();
            } else {
                value = LiveTabId.LIVE_TAB_NONE.getValue();
            }
            this.defaultTabId = companion.a(value);
            String stringExtra5 = intent.getStringExtra("coupon_id");
            this.couponId = stringExtra5 != null ? stringExtra5 : "";
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append("initArguments, intent.extras:");
        sb5.append(String.valueOf(intent != null ? intent.getExtras() : null));
        cg0.a.b("ECLiveWindowMainViewModel", sb5.toString());
    }
}
