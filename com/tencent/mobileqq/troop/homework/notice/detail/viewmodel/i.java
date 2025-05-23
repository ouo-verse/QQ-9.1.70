package com.tencent.mobileqq.troop.homework.notice.detail.viewmodel;

import android.content.Intent;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.troop.homework.notice.detail.event.HWNoticeDetailEvent;
import com.tencent.qqnt.kernel.api.IKernelService;
import com.tencent.qqnt.kernel.api.r;
import com.tencent.qqnt.kernel.nativeinterface.GetGroupSchoolNoticeDetailRsp;
import com.tencent.qqnt.kernel.nativeinterface.GroupSchoolNoticeReceiverInfo;
import com.tencent.qqnt.kernel.nativeinterface.GroupSchoolNoticeStatisticsReq;
import com.tencent.qqnt.kernel.nativeinterface.GroupSchoolNoticeStatisticsRsp;
import com.tencent.qqnt.kernel.nativeinterface.IGetGroupSchoolNoticeStatisticCallback;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\f\u0018\u0000 A2\u00020\u00012\u00020\u00022\b\u0012\u0004\u0012\u00020\u00040\u0003:\u0003BCDB\u000f\u0012\u0006\u0010\u001c\u001a\u00020\u0019\u00a2\u0006\u0004\b?\u0010@J\u000e\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0002J\u0006\u0010\t\u001a\u00020\bJ$\u0010\u0010\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\r\u001a\u0004\u0018\u00010\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016J\u0012\u0010\u0013\u001a\u00020\b2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016J$\u0010\u0017\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00150\u0014j\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0015`\u0016H\u0016J\b\u0010\u0018\u001a\u00020\bH\u0014R\u0014\u0010\u001c\u001a\u00020\u00198\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0014\u0010\u001f\u001a\u00020\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0014\u0010!\u001a\u00020\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b \u0010\u001eR\u001a\u0010&\u001a\b\u0012\u0004\u0012\u00020#0\"8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u001d\u0010,\u001a\b\u0012\u0004\u0012\u00020#0'8\u0006\u00a2\u0006\f\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+R\u001a\u0010/\u001a\b\u0012\u0004\u0012\u00020-0\"8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b.\u0010%R\u001d\u00102\u001a\b\u0012\u0004\u0012\u00020-0'8\u0006\u00a2\u0006\f\n\u0004\b0\u0010)\u001a\u0004\b1\u0010+R\u001a\u00106\u001a\b\u0012\u0004\u0012\u00020\u0006038\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b4\u00105R\u0016\u00108\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b7\u00107R\u0016\u0010<\u001a\u0002098\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b:\u0010;R\u0016\u0010>\u001a\u0002098\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b=\u0010;\u00a8\u0006E"}, d2 = {"Lcom/tencent/mobileqq/troop/homework/notice/detail/viewmodel/i;", "Landroidx/lifecycle/ViewModel;", "Lcom/tencent/qqnt/kernel/nativeinterface/IGetGroupSchoolNoticeStatisticCallback;", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/mobileqq/troop/homework/notice/detail/event/HWNoticeDetailEvent;", "", "Lcom/tencent/mobileqq/troop/homework/notice/detail/viewmodel/i$b;", "M1", "", "Q1", "", "errCode", "", "errMsg", "Lcom/tencent/qqnt/kernel/nativeinterface/GroupSchoolNoticeStatisticsRsp;", "rsp", "onResult", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "event", "onReceiveEvent", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "Lkotlin/collections/ArrayList;", "getEventClass", "onCleared", "Landroid/content/Intent;", "i", "Landroid/content/Intent;", "intent", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/lang/String;", "noticeId", BdhLogUtil.LogTag.Tag_Conn, "troopUin", "Landroidx/lifecycle/MutableLiveData;", "Lcom/tencent/qqnt/kernel/nativeinterface/GetGroupSchoolNoticeDetailRsp;", "D", "Landroidx/lifecycle/MutableLiveData;", "_noticeDetail", "Landroidx/lifecycle/LiveData;", "E", "Landroidx/lifecycle/LiveData;", "O1", "()Landroidx/lifecycle/LiveData;", "noticeDetail", "Lcom/tencent/mobileqq/troop/homework/notice/detail/viewmodel/i$c;", UserInfo.SEX_FEMALE, "_confirmedCountData", "G", "N1", "confirmedStatData", "", "H", "Ljava/util/List;", "receiverList", "I", "waitingRequestPageCnt", "", "J", "Z", "isRequesting", "K", "isEnd", "<init>", "(Landroid/content/Intent;)V", "L", "a", "b", "c", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class i extends ViewModel implements IGetGroupSchoolNoticeStatisticCallback, SimpleEventReceiver<HWNoticeDetailEvent> {
    static IPatchRedirector $redirector_;

    /* renamed from: L, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final String troopUin;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<GetGroupSchoolNoticeDetailRsp> _noticeDetail;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final LiveData<GetGroupSchoolNoticeDetailRsp> noticeDetail;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<c> _confirmedCountData;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final LiveData<c> confirmedStatData;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private final List<b> receiverList;

    /* renamed from: I, reason: from kotlin metadata */
    private int waitingRequestPageCnt;

    /* renamed from: J, reason: from kotlin metadata */
    private boolean isRequesting;

    /* renamed from: K, reason: from kotlin metadata */
    private boolean isEnd;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Intent intent;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String noticeId;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/troop/homework/notice/detail/viewmodel/i$a;", "", "", "PAGE_SIZE", "I", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.troop.homework.notice.detail.viewmodel.i$a, reason: from kotlin metadata */
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

    /* compiled from: P */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\r\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u000e\u001a\u00020\t\u0012\u0006\u0010\u0010\u001a\u00020\t\u0012\u0006\u0010\u0013\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0014\u0010\u0015J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0010\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u000b\u001a\u0004\b\n\u0010\rR\u0017\u0010\u0013\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u0011\u001a\u0004\b\u000f\u0010\u0012\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/troop/homework/notice/detail/viewmodel/i$b;", "", "", "toString", "", "hashCode", "other", "", "equals", "", "a", "J", "c", "()J", "uin", "b", "confirmTime", "Ljava/lang/String;", "()Ljava/lang/String;", "name", "<init>", "(JJLjava/lang/String;)V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes19.dex */
    public static final /* data */ class b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final long uin;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        private final long confirmTime;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final String name;

        public b(long j3, long j16, @NotNull String name) {
            Intrinsics.checkNotNullParameter(name, "name");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, Long.valueOf(j3), Long.valueOf(j16), name);
                return;
            }
            this.uin = j3;
            this.confirmTime = j16;
            this.name = name;
        }

        public final long a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Long) iPatchRedirector.redirect((short) 3, (Object) this)).longValue();
            }
            return this.confirmTime;
        }

        @NotNull
        public final String b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (String) iPatchRedirector.redirect((short) 4, (Object) this);
            }
            return this.name;
        }

        public final long c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Long) iPatchRedirector.redirect((short) 2, (Object) this)).longValue();
            }
            return this.uin;
        }

        public boolean equals(@Nullable Object other) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
                return ((Boolean) iPatchRedirector.redirect((short) 11, (Object) this, other)).booleanValue();
            }
            if (this == other) {
                return true;
            }
            if (!(other instanceof b)) {
                return false;
            }
            b bVar = (b) other;
            if (this.uin == bVar.uin && this.confirmTime == bVar.confirmTime && Intrinsics.areEqual(this.name, bVar.name)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
                return ((Integer) iPatchRedirector.redirect((short) 10, (Object) this)).intValue();
            }
            return (((androidx.fragment.app.a.a(this.uin) * 31) + androidx.fragment.app.a.a(this.confirmTime)) * 31) + this.name.hashCode();
        }

        @NotNull
        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                return (String) iPatchRedirector.redirect((short) 9, (Object) this);
            }
            return "ConfirmedReceiverInfo(uin=" + this.uin + ", confirmTime=" + this.confirmTime + ", name=" + this.name + ")";
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0017\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u000e\u001a\u00020\u0004\u0012\u0006\u0010\u0012\u001a\u00020\u0004\u0012\u0006\u0010\u0018\u001a\u00020\u0002\u0012\u0006\u0010\u001e\u001a\u00020\u0007\u0012\f\u0010&\u001a\b\u0012\u0004\u0012\u00020 0\u001f\u00a2\u0006\u0004\b'\u0010(J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\"\u0010\u000e\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\t\u0010\u000b\"\u0004\b\f\u0010\rR\"\u0010\u0012\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000f\u0010\n\u001a\u0004\b\u0010\u0010\u000b\"\u0004\b\u0011\u0010\rR\"\u0010\u0018\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\"\u0010\u001e\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u0019\u0010\u001b\"\u0004\b\u001c\u0010\u001dR(\u0010&\u001a\b\u0012\u0004\u0012\u00020 0\u001f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b!\u0010\"\u001a\u0004\b\u000f\u0010#\"\u0004\b$\u0010%\u00a8\u0006)"}, d2 = {"Lcom/tencent/mobileqq/troop/homework/notice/detail/viewmodel/i$c;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "I", "()I", "setConfirmedCnt", "(I)V", "confirmedCnt", "b", "c", "setTotalCnt", "totalCnt", "Ljava/lang/String;", "getTroopUin", "()Ljava/lang/String;", "setTroopUin", "(Ljava/lang/String;)V", "troopUin", "d", "Z", "()Z", "setEnd", "(Z)V", "isEnd", "", "Lcom/tencent/mobileqq/troop/homework/notice/detail/viewmodel/i$b;", "e", "Ljava/util/List;", "()Ljava/util/List;", "setConfirmedReceiverList", "(Ljava/util/List;)V", "confirmedReceiverList", "<init>", "(IILjava/lang/String;ZLjava/util/List;)V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes19.dex */
    public static final /* data */ class c {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private int confirmedCnt;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        private int totalCnt;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private String troopUin;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private boolean isEnd;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private List<b> confirmedReceiverList;

        public c(int i3, int i16, @NotNull String troopUin, boolean z16, @NotNull List<b> confirmedReceiverList) {
            Intrinsics.checkNotNullParameter(troopUin, "troopUin");
            Intrinsics.checkNotNullParameter(confirmedReceiverList, "confirmedReceiverList");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), Integer.valueOf(i16), troopUin, Boolean.valueOf(z16), confirmedReceiverList);
                return;
            }
            this.confirmedCnt = i3;
            this.totalCnt = i16;
            this.troopUin = troopUin;
            this.isEnd = z16;
            this.confirmedReceiverList = confirmedReceiverList;
        }

        public final int a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
            }
            return this.confirmedCnt;
        }

        @NotNull
        public final List<b> b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
                return (List) iPatchRedirector.redirect((short) 10, (Object) this);
            }
            return this.confirmedReceiverList;
        }

        public final int c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
            }
            return this.totalCnt;
        }

        public final boolean d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this)).booleanValue();
            }
            return this.isEnd;
        }

        public boolean equals(@Nullable Object other) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
                return ((Boolean) iPatchRedirector.redirect((short) 20, (Object) this, other)).booleanValue();
            }
            if (this == other) {
                return true;
            }
            if (!(other instanceof c)) {
                return false;
            }
            c cVar = (c) other;
            if (this.confirmedCnt == cVar.confirmedCnt && this.totalCnt == cVar.totalCnt && Intrinsics.areEqual(this.troopUin, cVar.troopUin) && this.isEnd == cVar.isEnd && Intrinsics.areEqual(this.confirmedReceiverList, cVar.confirmedReceiverList)) {
                return true;
            }
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
                return ((Integer) iPatchRedirector.redirect((short) 19, (Object) this)).intValue();
            }
            int hashCode = ((((this.confirmedCnt * 31) + this.totalCnt) * 31) + this.troopUin.hashCode()) * 31;
            boolean z16 = this.isEnd;
            int i3 = z16;
            if (z16 != 0) {
                i3 = 1;
            }
            return ((hashCode + i3) * 31) + this.confirmedReceiverList.hashCode();
        }

        @NotNull
        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
                return (String) iPatchRedirector.redirect((short) 18, (Object) this);
            }
            return "ConfirmedStatData(confirmedCnt=" + this.confirmedCnt + ", totalCnt=" + this.totalCnt + ", troopUin=" + this.troopUin + ", isEnd=" + this.isEnd + ", confirmedReceiverList=" + this.confirmedReceiverList + ")";
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(53092);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 9)) {
            redirector.redirect((short) 9);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public i(@NotNull Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) intent);
            return;
        }
        this.intent = intent;
        String stringExtra = intent.getStringExtra("NOTICE_ID");
        this.noticeId = stringExtra == null ? "0" : stringExtra;
        String stringExtra2 = intent.getStringExtra("TROOP_UIN");
        this.troopUin = stringExtra2 != null ? stringExtra2 : "0";
        MutableLiveData<GetGroupSchoolNoticeDetailRsp> mutableLiveData = new MutableLiveData<>();
        this._noticeDetail = mutableLiveData;
        this.noticeDetail = mutableLiveData;
        MutableLiveData<c> mutableLiveData2 = new MutableLiveData<>();
        this._confirmedCountData = mutableLiveData2;
        this.confirmedStatData = mutableLiveData2;
        this.receiverList = new ArrayList();
        this.waitingRequestPageCnt = 1;
        SimpleEventBus.getInstance().registerReceiver(this);
    }

    private final List<b> M1() {
        ArrayList arrayList = new ArrayList();
        for (b bVar : this.receiverList) {
            arrayList.add(new b(bVar.c(), bVar.a(), bVar.b()));
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void P1(int i3, GroupSchoolNoticeStatisticsRsp groupSchoolNoticeStatisticsRsp, i this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (i3 == 0 && groupSchoolNoticeStatisticsRsp != null) {
            this$0.waitingRequestPageCnt++;
            Iterator<GroupSchoolNoticeReceiverInfo> it = groupSchoolNoticeStatisticsRsp.receivers.iterator();
            while (it.hasNext()) {
                GroupSchoolNoticeReceiverInfo next = it.next();
                List<b> list = this$0.receiverList;
                long j3 = next.uin;
                long j16 = next.confirmTime;
                String str = next.name;
                Intrinsics.checkNotNullExpressionValue(str, "receiver.name");
                list.add(new b(j3, j16, str));
            }
            boolean z16 = groupSchoolNoticeStatisticsRsp.isEnd;
            this$0.isEnd = z16;
            this$0.isRequesting = false;
            this$0._confirmedCountData.setValue(new c(groupSchoolNoticeStatisticsRsp.confirmedCount, groupSchoolNoticeStatisticsRsp.total, this$0.troopUin, z16, this$0.M1()));
        }
        this$0.isRequesting = false;
    }

    @NotNull
    public final LiveData<c> N1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (LiveData) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.confirmedStatData;
    }

    @NotNull
    public final LiveData<GetGroupSchoolNoticeDetailRsp> O1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (LiveData) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.noticeDetail;
    }

    public final void Q1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        if (!this.isRequesting && !this.isEnd) {
            this.isRequesting = true;
            GroupSchoolNoticeStatisticsReq groupSchoolNoticeStatisticsReq = new GroupSchoolNoticeStatisticsReq(this.noticeId, Long.parseLong(this.troopUin), 1, this.waitingRequestPageCnt, 30);
            r groupSchoolService = ((IKernelService) MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IKernelService.class, "all")).getGroupSchoolService();
            if (groupSchoolService != null) {
                groupSchoolService.getGroupSchoolNoticeStatistic(groupSchoolNoticeStatisticsReq, this);
            }
        }
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    @NotNull
    public ArrayList<Class<HWNoticeDetailEvent>> getEventClass() {
        ArrayList<Class<HWNoticeDetailEvent>> arrayListOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 7)) {
            arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(HWNoticeDetailEvent.NoticeDetailUpdate.class);
            return arrayListOf;
        }
        return (ArrayList) iPatchRedirector.redirect((short) 7, (Object) this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
        } else {
            super.onCleared();
            SimpleEventBus.getInstance().unRegisterReceiver(this);
        }
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(@Nullable SimpleBaseEvent event) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) event);
        } else if (event instanceof HWNoticeDetailEvent.NoticeDetailUpdate) {
            this._noticeDetail.postValue(((HWNoticeDetailEvent.NoticeDetailUpdate) event).getDetail());
        }
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IGetGroupSchoolNoticeStatisticCallback
    public void onResult(final int errCode, @Nullable String errMsg, @Nullable final GroupSchoolNoticeStatisticsRsp rsp) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, Integer.valueOf(errCode), errMsg, rsp);
        } else {
            com.tencent.qav.thread.a.b(new Runnable() { // from class: com.tencent.mobileqq.troop.homework.notice.detail.viewmodel.h
                @Override // java.lang.Runnable
                public final void run() {
                    i.P1(errCode, rsp, this);
                }
            });
        }
    }
}
