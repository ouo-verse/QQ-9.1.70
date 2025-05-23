package com.tencent.mobileqq.guild.inbox.centerpanel.assistant;

import android.text.TextUtils;
import androidx.lifecycle.MutableLiveData;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.module.feedcomponent.manage.FeedManager;
import com.tencent.mobileqq.guild.mainframe.api.IGuildInboxRedService;
import com.tencent.mobileqq.guild.util.GuildNoticeKtKt;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.co;
import com.tencent.mobileqq.qqguildsdk.data.cq;
import com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver;
import com.tencent.qphone.base.util.QLog;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__MutableCollectionsJVMKt;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import vh2.bo;
import vh2.bu;

/* compiled from: P */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b*\u0002\u0007\n\u0018\u0000 <2\u00020\u0001:\u0001=B\u0007\u00a2\u0006\u0004\b:\u0010;J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\u000f\u0010\b\u001a\u00020\u0007H\u0002\u00a2\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0006\u0010\r\u001a\u00020\u0004J\u0006\u0010\u000e\u001a\u00020\u0004J\u001c\u0010\u0013\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00110\u0010j\b\u0012\u0004\u0012\u00020\u0011`\u00120\u000fJ\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00020\u000fJ\u0006\u0010\u0015\u001a\u00020\u0002J\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\u000fJ\u0006\u0010\u0018\u001a\u00020\u0004J\u0006\u0010\u0019\u001a\u00020\u0004J\b\u0010\u001a\u001a\u00020\u0004H\u0014R*\u0010\u001d\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00110\u0010j\b\u0012\u0004\u0012\u00020\u0011`\u00120\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u001a\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00020\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001cR\u001a\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00020\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b \u0010\u001cR\u0016\u0010$\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u0016\u0010'\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u0014\u0010+\u001a\u00020(8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b)\u0010*R\u0014\u0010.\u001a\u00020,8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b&\u0010-R\"\u00101\u001a\u0010\u0012\f\u0012\n /*\u0004\u0018\u00010\u00160\u00160\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b0\u0010\u001cR\u0014\u00105\u001a\u0002028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b3\u00104R\u0014\u00109\u001a\u0002068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b7\u00108\u00a8\u0006>"}, d2 = {"Lcom/tencent/mobileqq/guild/inbox/centerpanel/assistant/h;", "Lef1/b;", "", "isForce", "", "b2", "g2", "com/tencent/mobileqq/guild/inbox/centerpanel/assistant/h$c", ICustomDataEditor.STRING_ARRAY_PARAM_2, "()Lcom/tencent/mobileqq/guild/inbox/centerpanel/assistant/h$c;", "com/tencent/mobileqq/guild/inbox/centerpanel/assistant/h$b", "Z1", "()Lcom/tencent/mobileqq/guild/inbox/centerpanel/assistant/h$b;", "initData", FeedManager.LOAD_MORE, "Landroidx/lifecycle/MutableLiveData;", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/qqguildsdk/data/co;", "Lkotlin/collections/ArrayList;", "c2", "d2", "f2", "", "e2", "addListener", "removeListener", "onCleared", BdhLogUtil.LogTag.Tag_Conn, "Landroidx/lifecycle/MutableLiveData;", "mGuildNoticesLiveData", "D", "mIsLoadingLiveData", "E", "mIsNoDisturb", UserInfo.SEX_FEMALE, "Z", "mIsEnd", "G", "I", "mNextPullOffset", "Lcom/tencent/mobileqq/guild/mainframe/api/IGuildInboxRedService;", "H", "Lcom/tencent/mobileqq/guild/mainframe/api/IGuildInboxRedService;", "mInboxRedService", "Lcom/tencent/mobileqq/qqguildsdk/api/IGPSService;", "Lcom/tencent/mobileqq/qqguildsdk/api/IGPSService;", "mGproService", "kotlin.jvm.PlatformType", "J", "mUpdateItemIndex", "Lcom/tencent/mobileqq/guild/mainframe/api/IGuildInboxRedService$a;", "K", "Lcom/tencent/mobileqq/guild/mainframe/api/IGuildInboxRedService$a;", "mListener", "Lcom/tencent/mobileqq/qqguildsdk/observer/GPServiceObserver;", "L", "Lcom/tencent/mobileqq/qqguildsdk/observer/GPServiceObserver;", "mObserver", "<init>", "()V", "M", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class h extends ef1.b {

    @NotNull
    private static final Comparator<co> N = new Comparator() { // from class: com.tencent.mobileqq.guild.inbox.centerpanel.assistant.g
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            int h26;
            h26 = h.h2((co) obj, (co) obj2);
            return h26;
        }
    };

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<ArrayList<co>> mGuildNoticesLiveData = new MutableLiveData<>();

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<Boolean> mIsLoadingLiveData;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<Boolean> mIsNoDisturb;

    /* renamed from: F, reason: from kotlin metadata */
    private boolean mIsEnd;

    /* renamed from: G, reason: from kotlin metadata */
    private int mNextPullOffset;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private final IGuildInboxRedService mInboxRedService;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private final IGPSService mGproService;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<Integer> mUpdateItemIndex;

    /* renamed from: K, reason: from kotlin metadata */
    @NotNull
    private final IGuildInboxRedService.a mListener;

    /* renamed from: L, reason: from kotlin metadata */
    @NotNull
    private final GPServiceObserver mObserver;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000/\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J>\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u00062\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0016\u00a8\u0006\u000f"}, d2 = {"com/tencent/mobileqq/guild/inbox/centerpanel/assistant/h$b", "Lvh2/bo;", "", "result", "", "errMsg", "", "needResetList", "listOffset", "isEnd", "", "Lcom/tencent/mobileqq/qqguildsdk/data/co;", "noticeList", "", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class b implements bo {
        b() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // vh2.bo
        public void a(int result, @NotNull String errMsg, boolean needResetList, int listOffset, boolean isEnd, @NotNull List<? extends co> noticeList) {
            ArrayList<co> arrayList;
            Intrinsics.checkNotNullParameter(errMsg, "errMsg");
            Intrinsics.checkNotNullParameter(noticeList, "noticeList");
            boolean z16 = true;
            if (result == 0) {
                h.this.mIsEnd = isEnd;
                h.this.mNextPullOffset = listOffset;
                if (!noticeList.isEmpty() && (noticeList instanceof ArrayList)) {
                    arrayList = (ArrayList) noticeList;
                } else {
                    arrayList = new ArrayList();
                }
                ArrayList arrayList2 = (ArrayList) h.this.mGuildNoticesLiveData.getValue();
                if (!needResetList) {
                    if (arrayList2 != null && !arrayList2.isEmpty()) {
                        z16 = false;
                    }
                    if (!z16) {
                        if (!arrayList2.containsAll(arrayList)) {
                            for (co coVar : arrayList) {
                                if (!arrayList2.contains(coVar)) {
                                    arrayList2.add(coVar);
                                }
                            }
                            CollectionsKt__MutableCollectionsJVMKt.sortWith(arrayList2, h.N);
                            h.this.mGuildNoticesLiveData.setValue(arrayList2);
                        }
                        h.this.mIsLoadingLiveData.setValue(Boolean.FALSE);
                        Logger logger = Logger.f235387a;
                        if (QLog.isColorLevel()) {
                            logger.d().d("Guild.C2C.GuildAssistantViewModel", 2, "onGetMoreGuildNoticeList needResetList=" + needResetList + " listOffset=" + listOffset + " isEnd=" + isEnd + " data size=" + arrayList2.size());
                            return;
                        }
                        return;
                    }
                }
                CollectionsKt__MutableCollectionsJVMKt.sortWith(arrayList, h.N);
                h.this.mGuildNoticesLiveData.setValue(arrayList);
                h.this.mIsLoadingLiveData.setValue(Boolean.FALSE);
                Logger logger2 = Logger.f235387a;
                if (QLog.isColorLevel()) {
                    logger2.d().d("Guild.C2C.GuildAssistantViewModel", 2, "onGetMoreGuildNoticeList needResetList=" + needResetList + " listOffset=" + listOffset + " isEnd=" + isEnd + " data size=" + arrayList.size());
                    return;
                }
                return;
            }
            Logger logger3 = Logger.f235387a;
            Logger.b bVar = new Logger.b();
            String str = "getMoreHelperNoticeList error, nResult" + result + ", errMsg" + errMsg;
            if (str instanceof String) {
                bVar.a().add(str);
            }
            Iterator<T> it = bVar.a().iterator();
            while (it.hasNext()) {
                Logger.f235387a.d().e("Guild.C2C.GuildAssistantViewModel", 1, (String) it.next(), null);
            }
            h.this.mIsLoadingLiveData.setValue(Boolean.FALSE);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u00001\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001JB\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00022\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nH\u0016\u00a8\u0006\u000f"}, d2 = {"com/tencent/mobileqq/guild/inbox/centerpanel/assistant/h$c", "Lvh2/bu;", "", "nRefreshResult", "", "refreshErrMsg", "listOffset", "", "isEnd", "unreadCnt", "", "Lcom/tencent/mobileqq/qqguildsdk/data/co;", "noticeList", "", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class c implements bu {
        c() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // vh2.bu
        public void a(int nRefreshResult, @Nullable String refreshErrMsg, int listOffset, boolean isEnd, int unreadCnt, @Nullable List<co> noticeList) {
            boolean z16;
            ArrayList arrayList;
            if (nRefreshResult != 0) {
                Logger logger = Logger.f235387a;
                if (QLog.isColorLevel()) {
                    logger.d().d("Guild.C2C.GuildAssistantViewModel", 2, "initGetHelperNoticeList error, nRefreshResult" + nRefreshResult + ", refreshErrMsg" + refreshErrMsg);
                }
            }
            h.this.mIsEnd = isEnd;
            h.this.mNextPullOffset = listOffset;
            h.this.g2();
            List<co> list = noticeList;
            boolean z17 = false;
            if (list != null && !list.isEmpty()) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (!z16 && (noticeList instanceof ArrayList)) {
                arrayList = (ArrayList) noticeList;
            } else {
                arrayList = new ArrayList();
            }
            ArrayList arrayList2 = (ArrayList) h.this.mGuildNoticesLiveData.getValue();
            if (arrayList2 == null || arrayList2.isEmpty()) {
                z17 = true;
            }
            if (z17 || !arrayList2.containsAll(arrayList)) {
                CollectionsKt__MutableCollectionsJVMKt.sortWith(arrayList, h.N);
                h.this.mGuildNoticesLiveData.setValue(arrayList);
                Logger logger2 = Logger.f235387a;
                if (QLog.isColorLevel()) {
                    logger2.d().d("Guild.C2C.GuildAssistantViewModel", 2, "onInitGetGuildNoticeList list update");
                }
            }
            h.this.mIsLoadingLiveData.setValue(Boolean.FALSE);
            Logger logger3 = Logger.f235387a;
            if (QLog.isColorLevel()) {
                logger3.d().d("Guild.C2C.GuildAssistantViewModel", 2, "onInitGetGuildNoticeList listOffset=" + listOffset + " isEnd=" + isEnd + " data size=" + arrayList.size() + " unreadCnt=" + unreadCnt);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0016\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/mobileqq/guild/inbox/centerpanel/assistant/h$d", "Lcom/tencent/mobileqq/guild/mainframe/api/IGuildInboxRedService$b;", "", "Lcom/tencent/mobileqq/qqguildsdk/data/cq;", "redPointList", "", "b", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class d extends IGuildInboxRedService.b {
        d() {
        }

        @Override // com.tencent.mobileqq.guild.mainframe.api.IGuildInboxRedService.b, com.tencent.mobileqq.guild.mainframe.api.IGuildInboxRedService.a
        public void b(@NotNull List<? extends cq> redPointList) {
            boolean z16;
            Intrinsics.checkNotNullParameter(redPointList, "redPointList");
            if (QLog.isColorLevel()) {
                QLog.d("Guild.C2C.GuildAssistantViewModel", 1, "onNoticeGroupListUpdate " + redPointList);
            }
            for (cq cqVar : redPointList) {
                if (cqVar.f265931a == 7) {
                    MutableLiveData mutableLiveData = h.this.mIsNoDisturb;
                    if (cqVar.f265934d != 0) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    mutableLiveData.setValue(Boolean.valueOf(z16));
                }
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0006\u001a\u00020\u00052\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0014\u00a8\u0006\u0007"}, d2 = {"com/tencent/mobileqq/guild/inbox/centerpanel/assistant/h$e", "Lcom/tencent/mobileqq/qqguildsdk/observer/GPServiceObserver;", "", "guildId", "tinyId", "", "onGuildUserAvatarUrlUpdate", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class e extends GPServiceObserver {
        e() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onGuildUserAvatarUrlUpdate(@Nullable String guildId, @Nullable String tinyId) {
            boolean z16;
            ArrayList arrayList = (ArrayList) h.this.mGuildNoticesLiveData.getValue();
            if (arrayList != null && !arrayList.isEmpty()) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (z16) {
                return;
            }
            int size = arrayList.size();
            for (int i3 = 0; i3 < size; i3++) {
                Object obj = arrayList.get(i3);
                Intrinsics.checkNotNullExpressionValue(obj, "guildNotices[i]");
                co.b bVar = ((co) obj).f265891g;
                if (bVar != null && bVar.f265908a == 2 && TextUtils.equals(String.valueOf(bVar.f265909b), tinyId)) {
                    h.this.mUpdateItemIndex.setValue(Integer.valueOf(i3));
                }
            }
        }
    }

    public h() {
        Boolean bool = Boolean.FALSE;
        this.mIsLoadingLiveData = new MutableLiveData<>(bool);
        this.mIsNoDisturb = new MutableLiveData<>(bool);
        IRuntimeService S0 = ch.S0(IGuildInboxRedService.class, "");
        Intrinsics.checkNotNullExpressionValue(S0, "runtimeService(java, process)");
        this.mInboxRedService = (IGuildInboxRedService) S0;
        IRuntimeService S02 = ch.S0(IGPSService.class, "");
        Intrinsics.checkNotNullExpressionValue(S02, "runtimeService(java, process)");
        this.mGproService = (IGPSService) S02;
        this.mUpdateItemIndex = new MutableLiveData<>(0);
        this.mListener = new d();
        this.mObserver = new e();
    }

    private final b Z1() {
        return new b();
    }

    private final c a2() {
        return new c();
    }

    private final void b2(boolean isForce) {
        ((IGPSService) ch.R0(IGPSService.class)).initGetNoticeList(7, "", isForce, a2());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void g2() {
        QLog.i("Guild.C2C.GuildAssistantViewModel", 2, "reportRead -- type:9");
        GuildNoticeKtKt.b("", 9, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int h2(co coVar, co coVar2) {
        return (int) (coVar2.f265887c - coVar.f265887c);
    }

    public final void addListener() {
        this.mInboxRedService.addNoticeRedUpdateListener(this.mListener);
        this.mGproService.addObserver(this.mObserver);
    }

    @NotNull
    public final MutableLiveData<ArrayList<co>> c2() {
        return this.mGuildNoticesLiveData;
    }

    @NotNull
    public final MutableLiveData<Boolean> d2() {
        return this.mIsLoadingLiveData;
    }

    @NotNull
    public final MutableLiveData<Integer> e2() {
        return this.mUpdateItemIndex;
    }

    /* renamed from: f2, reason: from getter */
    public final boolean getMIsEnd() {
        return this.mIsEnd;
    }

    public final void initData() {
        boolean z16;
        boolean z17 = false;
        this.mNextPullOffset = 0;
        cq noticeRedPoint = this.mInboxRedService.getNoticeRedPoint(7);
        Intrinsics.checkNotNullExpressionValue(noticeRedPoint, "mInboxRedService.getNoti\u2026nt(INoticeMsgType.HELPER)");
        ArrayList<co> value = this.mGuildNoticesLiveData.getValue();
        if (value != null && !value.isEmpty()) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16 || noticeRedPoint.f265932b > 0) {
            z17 = true;
        }
        b2(z17);
        this.mIsNoDisturb.setValue(Boolean.valueOf(noticeRedPoint.a()));
        Logger logger = Logger.f235387a;
        if (QLog.isColorLevel()) {
            logger.d().d("Guild.C2C.GuildAssistantViewModel", 2, "initData");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void loadMore() {
        Integer num;
        Boolean value = this.mIsLoadingLiveData.getValue();
        Boolean bool = Boolean.TRUE;
        if (Intrinsics.areEqual(value, bool)) {
            return;
        }
        this.mIsLoadingLiveData.setValue(bool);
        ((IGPSService) ch.R0(IGPSService.class)).getMoreNoticeList(7, "", this.mNextPullOffset, Z1());
        Logger logger = Logger.f235387a;
        if (QLog.isColorLevel()) {
            Logger.a d16 = logger.d();
            int i3 = this.mNextPullOffset;
            ArrayList arrayList = (ArrayList) this.mGuildNoticesLiveData.getValue();
            if (arrayList != null) {
                num = Integer.valueOf(arrayList.size());
            } else {
                num = null;
            }
            d16.d("Guild.C2C.GuildAssistantViewModel", 2, "getMoreHelperNoticeList begin Offset=" + i3 + ", size=" + num);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ef1.b, androidx.lifecycle.ViewModel
    public void onCleared() {
        super.onCleared();
        g2();
    }

    public final void removeListener() {
        this.mInboxRedService.removeNoticeRedUpdateListener(this.mListener);
        this.mGproService.deleteObserver(this.mObserver);
    }
}
