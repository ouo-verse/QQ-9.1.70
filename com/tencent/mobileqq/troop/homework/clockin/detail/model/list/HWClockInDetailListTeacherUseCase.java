package com.tencent.mobileqq.troop.homework.clockin.detail.model.list;

import androidx.lifecycle.MutableLiveData;
import com.qzone.module.feedcomponent.manage.FeedManager;
import com.tencent.biz.qqcircle.immersive.request.search.QFSSearchBaseRequest;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.troop.homework.clockin.HWClockInRole;
import com.tencent.mobileqq.troop.homework.clockin.detail.model.list.e;
import com.tencent.mobileqq.troop.homework.clockin.detail.vm.a;
import com.tencent.mobileqq.troop.homework.clockin.detail.vm.b;
import com.tencent.mobileqq.troop.homework.clockin.detail.widget.date.data.Status;
import com.tencent.mobileqq.troop.homework.common.widget.mediaedit.manager.HWClockInDetailListMediaEditManager;
import com.tencent.mobileqq.troop.homework.common.widget.mediaedit.model.GroupItem;
import com.tencent.mobileqq.troop.utils.bg;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.GroupSchoolTaskCheckInInfo;
import com.tencent.qqnt.kernel.nativeinterface.GroupSchoolTaskData;
import com.tencent.qqnt.kernel.nativeinterface.GroupSchoolTaskStatisticsRsp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \f2\u00020\u0001:\u0001\u0016B-\u0012\u0006\u0010\u0019\u001a\u00020\u0017\u0012\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001a\u0012\u0006\u0010!\u001a\u00020\u0004\u0012\u0006\u0010%\u001a\u00020\"\u00a2\u0006\u0004\b6\u00107J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\"\u0010\n\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\bH\u0002J\b\u0010\u000b\u001a\u00020\u0002H\u0002J\b\u0010\f\u001a\u00020\bH\u0002J\u0010\u0010\r\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J \u0010\u000e\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bH\u0002J\u0012\u0010\u0010\u001a\u00020\u00022\b\b\u0002\u0010\u000f\u001a\u00020\u0004H\u0002J\b\u0010\u0011\u001a\u00020\u0002H\u0016J!\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0012\u001a\u0004\u0018\u00010\bH\u0016\u00a2\u0006\u0004\b\u0013\u0010\u0014J\b\u0010\u0015\u001a\u00020\u0002H\u0016J\b\u0010\u0016\u001a\u00020\u0004H\u0016R\u0014\u0010\u0019\u001a\u00020\u00178\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0018R\u001a\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001a8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0014\u0010!\u001a\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u0014\u0010%\u001a\u00020\"8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b#\u0010$R\u001c\u0010*\u001a\n '*\u0004\u0018\u00010&0&8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b(\u0010)R\u0014\u0010.\u001a\u00020+8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b,\u0010-R$\u00104\u001a\u0012\u0012\u0004\u0012\u0002000/j\b\u0012\u0004\u0012\u000200`18\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b2\u00103R\u0018\u00105\u001a\u0004\u0018\u00010&8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u0010)\u00a8\u00068"}, d2 = {"Lcom/tencent/mobileqq/troop/homework/clockin/detail/model/list/HWClockInDetailListTeacherUseCase;", "Lcom/tencent/mobileqq/troop/homework/clockin/detail/model/list/e;", "", "k", "", "date", "Lcom/tencent/qqnt/kernel/nativeinterface/GroupSchoolTaskStatisticsRsp;", "rsp", "", QFSSearchBaseRequest.EXTRA_KEY_IS_LOAD_MORE, "i", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "j", "o", "l", "curDate", DomainData.DOMAIN_NAME, "init", "needState", "b", "(JLjava/lang/Boolean;)V", FeedManager.LOAD_MORE, "a", "Lkotlinx/coroutines/CoroutineScope;", "Lkotlinx/coroutines/CoroutineScope;", "scope", "Landroidx/lifecycle/MutableLiveData;", "Lcom/tencent/mobileqq/troop/homework/clockin/detail/vm/a;", "c", "Landroidx/lifecycle/MutableLiveData;", "uiState", "d", "J", "troopUin", "Lcom/tencent/qqnt/kernel/nativeinterface/GroupSchoolTaskData;", "e", "Lcom/tencent/qqnt/kernel/nativeinterface/GroupSchoolTaskData;", "detail", "", "kotlin.jvm.PlatformType", "f", "Ljava/lang/String;", "clockInId", "Lcom/tencent/mobileqq/troop/homework/clockin/detail/model/list/HWClockInDetailListTeacherRepo;", "g", "Lcom/tencent/mobileqq/troop/homework/clockin/detail/model/list/HWClockInDetailListTeacherRepo;", "repo", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/troop/homework/common/widget/mediaedit/model/GroupItem;", "Lkotlin/collections/ArrayList;", h.F, "Ljava/util/ArrayList;", "clockInRecords", "troopName", "<init>", "(Lkotlinx/coroutines/CoroutineScope;Landroidx/lifecycle/MutableLiveData;JLcom/tencent/qqnt/kernel/nativeinterface/GroupSchoolTaskData;)V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class HWClockInDetailListTeacherUseCase implements e {
    static IPatchRedirector $redirector_;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final CoroutineScope scope;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final MutableLiveData<com.tencent.mobileqq.troop.homework.clockin.detail.vm.a> uiState;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final long troopUin;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final GroupSchoolTaskData detail;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final String clockInId;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final HWClockInDetailListTeacherRepo repo;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ArrayList<GroupItem> clockInRecords;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String troopName;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/troop/homework/clockin/detail/model/list/HWClockInDetailListTeacherUseCase$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.troop.homework.clockin.detail.model.list.HWClockInDetailListTeacherUseCase$a, reason: from kotlin metadata */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(42005);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public HWClockInDetailListTeacherUseCase(@NotNull CoroutineScope scope, @NotNull MutableLiveData<com.tencent.mobileqq.troop.homework.clockin.detail.vm.a> uiState, long j3, @NotNull GroupSchoolTaskData detail) {
        Intrinsics.checkNotNullParameter(scope, "scope");
        Intrinsics.checkNotNullParameter(uiState, "uiState");
        Intrinsics.checkNotNullParameter(detail, "detail");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, scope, uiState, Long.valueOf(j3), detail);
            return;
        }
        this.scope = scope;
        this.uiState = uiState;
        this.troopUin = j3;
        this.detail = detail;
        String clockInId = detail.taskId;
        this.clockInId = clockInId;
        Intrinsics.checkNotNullExpressionValue(clockInId, "clockInId");
        this.repo = new HWClockInDetailListTeacherRepo(j3, clockInId);
        this.clockInRecords = new ArrayList<>();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void i(long date, GroupSchoolTaskStatisticsRsp rsp, boolean isLoadMore) {
        if (rsp == null) {
            return;
        }
        l(rsp, date, isLoadMore);
        m();
        k();
        o(rsp);
    }

    private final boolean j() {
        com.tencent.mobileqq.troop.homework.clockin.c cVar = com.tencent.mobileqq.troop.homework.clockin.c.f296281a;
        int a16 = cVar.a(this.detail.publishTime);
        boolean g16 = cVar.g(this.detail.timeSettings.checkinWeekdays);
        if (QLog.isColorLevel()) {
            QLog.i("HW.ClockIn.DETAIL.HWClockInDetailListTeacherUseCase", 2, "todayDateInSettingsCycleAndWeekdays, between:" + a16 + ",contains:" + g16);
        }
        if (a16 <= this.detail.timeSettings.cycle && g16) {
            return true;
        }
        return false;
    }

    private final void k() {
        String str;
        GroupSchoolTaskData groupSchoolTaskData = this.detail;
        boolean z16 = true;
        if (groupSchoolTaskData.status != 1) {
            z16 = false;
        }
        String valueOf = String.valueOf(groupSchoolTaskData.authorUin);
        AppInterface e16 = bg.e();
        if (e16 != null) {
            str = e16.getCurrentAccountUin();
        } else {
            str = null;
        }
        if (Intrinsics.areEqual(valueOf, str) && z16) {
            boolean d16 = com.tencent.mobileqq.troop.homework.clockin.c.f296281a.d(this.repo.g());
            if (d16 && !j()) {
                this.uiState.setValue(new a.l(8, null, 0, 0, null, false, 62, null));
                return;
            } else {
                this.uiState.setValue(new a.l(0, "\u63d0\u9192\u4e00\u4e0b", 1, 0, b.f.f296415a, d16));
                return;
            }
        }
        this.uiState.setValue(new a.l(8, null, 0, 0, null, false, 62, null));
    }

    private final void l(GroupSchoolTaskStatisticsRsp rsp, long date, boolean isLoadMore) {
        int collectionSizeOrDefault;
        ArrayList<GroupSchoolTaskCheckInInfo> arrayList = rsp.records;
        Intrinsics.checkNotNullExpressionValue(arrayList, "rsp.records");
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10);
        ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault);
        for (GroupSchoolTaskCheckInInfo it : arrayList) {
            String valueOf = String.valueOf(this.troopUin);
            CoroutineScope coroutineScope = this.scope;
            String clockInId = this.clockInId;
            Intrinsics.checkNotNullExpressionValue(clockInId, "clockInId");
            HWClockInDetailListMediaEditManager hWClockInDetailListMediaEditManager = new HWClockInDetailListMediaEditManager(valueOf, coroutineScope, clockInId, date);
            GroupSchoolTaskData groupSchoolTaskData = this.detail;
            Intrinsics.checkNotNullExpressionValue(it, "it");
            hWClockInDetailListMediaEditManager.x(new com.tencent.mobileqq.troop.homework.common.widget.mediaedit.manager.a(groupSchoolTaskData, it));
            arrayList2.add(new GroupItem(hWClockInDetailListMediaEditManager));
        }
        if (!isLoadMore) {
            this.clockInRecords.clear();
        }
        this.clockInRecords.addAll(arrayList2);
        ArrayList arrayList3 = new ArrayList();
        arrayList3.addAll(this.clockInRecords);
        this.uiState.setValue(new a.C8707a(arrayList3, rsp.isEnd));
    }

    private final void m() {
        String str;
        if (!this.clockInRecords.isEmpty()) {
            this.uiState.setValue(new a.b("", true));
            return;
        }
        if (this.detail.status == 3) {
            this.uiState.setValue(new a.b("\u6253\u5361\u5df2\u7ed3\u675f", true));
            return;
        }
        com.tencent.mobileqq.troop.homework.clockin.c cVar = com.tencent.mobileqq.troop.homework.clockin.c.f296281a;
        if (cVar.d(a()) && !j()) {
            this.uiState.setValue(new a.b("\u4eca\u65e5\u65e0\u9700\u6253\u5361", true));
        } else if (this.clockInRecords.isEmpty()) {
            if (cVar.d(this.repo.g())) {
                str = "\u4eca\u65e5\u65e0\u4eba\u6253\u5361";
            } else {
                str = "\u5f53\u65e5\u65e0\u4eba\u6253\u5361";
            }
            this.uiState.setValue(new a.b(str, true));
        }
    }

    private final void n(long curDate) {
        ArrayList arrayList = new ArrayList();
        int i3 = this.detail.timeSettings.cycle;
        Calendar calendar = Calendar.getInstance();
        long j3 = 1000;
        calendar.setTime(new Date(this.detail.publishTime * j3));
        for (int i16 = 0; i16 < i3; i16++) {
            long timeInMillis = calendar.getTimeInMillis() / j3;
            arrayList.add(new com.tencent.mobileqq.troop.homework.clockin.detail.widget.date.data.a(HWClockInRole.ROLE_TEACHER, Status.STATUS_UNKNOWN, timeInMillis, com.tencent.mobileqq.troop.homework.clockin.c.f296281a.c(curDate, timeInMillis)));
            calendar.add(6, 1);
        }
        com.tencent.mobileqq.troop.homework.clockin.c.f296281a.e(this.detail.timeSettings.checkinWeekdays, arrayList);
        this.uiState.setValue(new a.d(arrayList));
    }

    private final void o(GroupSchoolTaskStatisticsRsp rsp) {
        boolean z16;
        boolean z17;
        String str;
        int i3;
        boolean d16 = com.tencent.mobileqq.troop.homework.clockin.c.f296281a.d(this.repo.g());
        boolean z18 = true;
        if (this.detail.status == 3 && this.clockInRecords.isEmpty()) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (d16 && !j()) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (!z16 && (i3 = rsp.requiredStudents) != 0 && !z17) {
            str = rsp.checkedInStudents + "/" + i3 + "\u5df2\u6253\u5361";
        } else {
            str = "";
        }
        String str2 = this.troopName;
        if (str2 != null && str2.length() != 0) {
            z18 = false;
        }
        if (z18) {
            BuildersKt__Builders_commonKt.launch$default(this.scope, null, null, new HWClockInDetailListTeacherUseCase$updateStatisticsData$1(this, str, null), 3, null);
        } else {
            this.uiState.setValue(new a.c(new d(String.valueOf(this.troopName), str)));
        }
    }

    @Override // com.tencent.mobileqq.troop.homework.clockin.detail.model.list.e
    public long a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Long) iPatchRedirector.redirect((short) 5, (Object) this)).longValue();
        }
        return this.repo.g();
    }

    @Override // com.tencent.mobileqq.troop.homework.clockin.detail.model.list.e
    public void b(long date, @Nullable Boolean needState) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, Long.valueOf(date), needState);
        } else {
            FlowKt.launchIn(FlowKt.onEach(this.repo.k(date), new HWClockInDetailListTeacherUseCase$switchDate$1(this, date, null)), this.scope);
        }
    }

    @Override // com.tencent.mobileqq.troop.homework.clockin.detail.model.list.e
    public void init() {
        long currentTimeMillis;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        k();
        GroupSchoolTaskData groupSchoolTaskData = this.detail;
        if (groupSchoolTaskData.status == 3) {
            currentTimeMillis = groupSchoolTaskData.publishTime;
        } else {
            currentTimeMillis = System.currentTimeMillis() / 1000;
        }
        e.b.a(this, currentTimeMillis, null, 2, null);
        n(currentTimeMillis);
    }

    @Override // com.tencent.mobileqq.troop.homework.clockin.detail.model.list.e
    public void loadMore() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            FlowKt.launchIn(FlowKt.onEach(this.repo.j(), new HWClockInDetailListTeacherUseCase$loadMore$1(this, null)), this.scope);
        }
    }
}
