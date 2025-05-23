package com.tencent.mobileqq.troop.homework.clockin.detail.model.list;

import androidx.lifecycle.MutableLiveData;
import com.qzone.module.feedcomponent.manage.FeedManager;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.troop.homework.clockin.HWClockInDetailEvent;
import com.tencent.mobileqq.troop.homework.clockin.HWClockInRole;
import com.tencent.mobileqq.troop.homework.clockin.detail.model.list.e;
import com.tencent.mobileqq.troop.homework.clockin.detail.vm.a;
import com.tencent.mobileqq.troop.homework.clockin.detail.vm.b;
import com.tencent.mobileqq.troop.homework.clockin.detail.widget.date.data.Status;
import com.tencent.mobileqq.troop.homework.common.widget.mediaedit.manager.HWClockInDetailListMediaEditManager;
import com.tencent.mobileqq.troop.homework.common.widget.mediaedit.model.GroupItem;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.GroupSchoolTaskCheckInInfo;
import com.tencent.qqnt.kernel.nativeinterface.GroupSchoolTaskCheckInStatusInfo;
import com.tencent.qqnt.kernel.nativeinterface.GroupSchoolTaskData;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 52\u00020\u0001:\u0001\u0017B-\u0012\u0006\u0010\u001a\u001a\u00020\u0018\u0012\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001b\u0012\u0006\u0010\"\u001a\u00020\u0011\u0012\u0006\u0010%\u001a\u00020#\u00a2\u0006\u0004\b3\u00104J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0018\u0010\t\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0002J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J$\u0010\u000f\u001a\u00020\u00042\u001a\u0010\u000e\u001a\u0016\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bj\n\u0012\u0004\u0012\u00020\f\u0018\u0001`\rH\u0002J\b\u0010\u0010\u001a\u00020\u0004H\u0016J!\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00112\b\u0010\u0013\u001a\u0004\u0018\u00010\u0006H\u0016\u00a2\u0006\u0004\b\u0014\u0010\u0015J\b\u0010\u0016\u001a\u00020\u0004H\u0016J\b\u0010\u0017\u001a\u00020\u0011H\u0016R\u0014\u0010\u001a\u001a\u00020\u00188\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0019R\u001a\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0014\u0010\"\u001a\u00020\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b \u0010!R\u0014\u0010%\u001a\u00020#8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010$R\u001c\u0010)\u001a\n '*\u0004\u0018\u00010&0&8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010(R\u0016\u0010*\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\t\u0010!R\u0014\u0010-\u001a\u00020+8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010,R\u001a\u00102\u001a\b\u0012\u0004\u0012\u00020/0.8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b0\u00101\u00a8\u00066"}, d2 = {"Lcom/tencent/mobileqq/troop/homework/clockin/detail/model/list/HWClockInDetailListStudentUseCase;", "Lcom/tencent/mobileqq/troop/homework/clockin/detail/model/list/e;", "Lcom/tencent/qqnt/kernel/nativeinterface/GroupSchoolTaskCheckInInfo;", "records", "", "f", "", "isEmptyRecords", "isMakeUp", "g", "e", "Ljava/util/ArrayList;", "Lcom/tencent/qqnt/kernel/nativeinterface/GroupSchoolTaskCheckInStatusInfo;", "Lkotlin/collections/ArrayList;", "states", h.F, "init", "", "date", "needState", "b", "(JLjava/lang/Boolean;)V", FeedManager.LOAD_MORE, "a", "Lkotlinx/coroutines/CoroutineScope;", "Lkotlinx/coroutines/CoroutineScope;", "scope", "Landroidx/lifecycle/MutableLiveData;", "Lcom/tencent/mobileqq/troop/homework/clockin/detail/vm/a;", "c", "Landroidx/lifecycle/MutableLiveData;", "uiState", "d", "J", "troopUin", "Lcom/tencent/qqnt/kernel/nativeinterface/GroupSchoolTaskData;", "Lcom/tencent/qqnt/kernel/nativeinterface/GroupSchoolTaskData;", "detail", "", "kotlin.jvm.PlatformType", "Ljava/lang/String;", "clockInId", "currentDate", "Lcom/tencent/mobileqq/troop/homework/clockin/detail/model/list/HWClockInDetailListStudentRepo;", "Lcom/tencent/mobileqq/troop/homework/clockin/detail/model/list/HWClockInDetailListStudentRepo;", "repo", "", "Lcom/tencent/mobileqq/troop/homework/clockin/detail/widget/date/data/a;", "i", "Ljava/util/List;", "dateList", "<init>", "(Lkotlinx/coroutines/CoroutineScope;Landroidx/lifecycle/MutableLiveData;JLcom/tencent/qqnt/kernel/nativeinterface/GroupSchoolTaskData;)V", "j", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class HWClockInDetailListStudentUseCase implements e {
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
    private long currentDate;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final HWClockInDetailListStudentRepo repo;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<com.tencent.mobileqq.troop.homework.clockin.detail.widget.date.data.a> dateList;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/troop/homework/clockin/detail/model/list/HWClockInDetailListStudentUseCase$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.troop.homework.clockin.detail.model.list.HWClockInDetailListStudentUseCase$a, reason: from kotlin metadata */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(41841);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public HWClockInDetailListStudentUseCase(@NotNull CoroutineScope scope, @NotNull MutableLiveData<com.tencent.mobileqq.troop.homework.clockin.detail.vm.a> uiState, long j3, @NotNull GroupSchoolTaskData detail) {
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
        this.repo = new HWClockInDetailListStudentRepo(j3, clockInId);
        this.dateList = new ArrayList();
    }

    private final void e(boolean isEmptyRecords) {
        Object obj;
        Status e16;
        String str;
        if (isEmptyRecords && this.detail.status != 3) {
            boolean d16 = com.tencent.mobileqq.troop.homework.clockin.c.f296281a.d(this.currentDate);
            Iterator<T> it = this.dateList.iterator();
            while (true) {
                if (it.hasNext()) {
                    obj = it.next();
                    if (((com.tencent.mobileqq.troop.homework.clockin.detail.widget.date.data.a) obj).g()) {
                        break;
                    }
                } else {
                    obj = null;
                    break;
                }
            }
            com.tencent.mobileqq.troop.homework.clockin.detail.widget.date.data.a aVar = (com.tencent.mobileqq.troop.homework.clockin.detail.widget.date.data.a) obj;
            if (aVar != null && (e16 = aVar.e()) != null) {
                if (e16 == Status.STATUS_UN_CLOCK_IN && (this.detail.allowMakeUp || d16)) {
                    MutableLiveData<com.tencent.mobileqq.troop.homework.clockin.detail.vm.a> mutableLiveData = this.uiState;
                    if (d16) {
                        str = "\u7acb\u5373\u6253\u5361";
                    } else {
                        str = "\u7acb\u5373\u8865\u5361";
                    }
                    mutableLiveData.setValue(new a.l(0, str, 0, 1, new b.C8708b(null, 1, null), false, 32, null));
                    return;
                }
                this.uiState.setValue(new a.l(8, null, 0, 0, null, false, 62, null));
                return;
            }
            return;
        }
        this.uiState.setValue(new a.l(8, null, 0, 0, null, false, 62, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void f(GroupSchoolTaskCheckInInfo records) {
        boolean z16;
        if (QLog.isColorLevel()) {
            QLog.i("HW.ClockIn.DETAIL.HWClockInDetailListStudentUseCase", 2, "updateList: " + records);
        }
        ArrayList arrayList = new ArrayList();
        if (records != null && records.uin != 0) {
            String valueOf = String.valueOf(this.troopUin);
            CoroutineScope coroutineScope = this.scope;
            String clockInId = this.clockInId;
            Intrinsics.checkNotNullExpressionValue(clockInId, "clockInId");
            HWClockInDetailListMediaEditManager hWClockInDetailListMediaEditManager = new HWClockInDetailListMediaEditManager(valueOf, coroutineScope, clockInId, this.currentDate);
            hWClockInDetailListMediaEditManager.x(new com.tencent.mobileqq.troop.homework.common.widget.mediaedit.manager.a(this.detail, records));
            arrayList.add(new GroupItem(hWClockInDetailListMediaEditManager));
        }
        this.uiState.setValue(new a.C8707a(arrayList, true));
        boolean isEmpty = arrayList.isEmpty();
        if (records != null) {
            z16 = records.isMakeUp;
        } else {
            z16 = false;
        }
        g(isEmpty, z16);
        e(arrayList.isEmpty());
    }

    private final void g(boolean isEmptyRecords, boolean isMakeUp) {
        Object obj;
        Status e16;
        String str;
        if (!isEmptyRecords) {
            if (isMakeUp) {
                str = "\u606d\u559c\uff0c\u4f60\u5df2\u8865\u5361\u6210\u529f\uff01";
            } else if (com.tencent.mobileqq.troop.homework.clockin.c.f296281a.d(this.currentDate)) {
                str = "\u606d\u559c\uff0c\u4f60\u5df2\u5b8c\u6210\u4eca\u65e5\u6253\u5361\uff01";
            } else {
                str = "\u606d\u559c\uff0c\u4f60\u5df2\u5b8c\u6210\u5f53\u65e5\u6253\u5361\uff01";
            }
            this.uiState.setValue(new a.b(str, false));
            return;
        }
        if (this.detail.status == 3) {
            this.uiState.setValue(new a.b("\u6253\u5361\u5df2\u7ed3\u675f", true));
            return;
        }
        if (!com.tencent.mobileqq.troop.homework.clockin.c.f296281a.d(this.currentDate) && !this.detail.allowMakeUp) {
            this.uiState.setValue(new a.b("\u4e0d\u5141\u8bb8\u8865\u5361", true));
            return;
        }
        Iterator<T> it = this.dateList.iterator();
        while (true) {
            if (it.hasNext()) {
                obj = it.next();
                if (((com.tencent.mobileqq.troop.homework.clockin.detail.widget.date.data.a) obj).g()) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        com.tencent.mobileqq.troop.homework.clockin.detail.widget.date.data.a aVar = (com.tencent.mobileqq.troop.homework.clockin.detail.widget.date.data.a) obj;
        if (aVar != null && (e16 = aVar.e()) != null) {
            if (e16 == Status.STATUS_NEED_NOT_CLOCK_IN) {
                this.uiState.setValue(new a.b("\u4eca\u65e5\u65e0\u9700\u6253\u5361", true));
            } else if (e16 == Status.STATUS_UN_CLOCK_IN) {
                this.uiState.setValue(new a.b("\u6682\u65e0\u6253\u5361\u8bb0\u5f55", true));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void h(ArrayList<GroupSchoolTaskCheckInStatusInfo> states) {
        boolean z16;
        if (states == null || states.isEmpty()) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        HWClockInRole b16 = com.tencent.mobileqq.troop.homework.clockin.c.f296281a.b(String.valueOf(this.troopUin));
        Iterator<GroupSchoolTaskCheckInStatusInfo> it = states.iterator();
        while (it.hasNext()) {
            GroupSchoolTaskCheckInStatusInfo next = it.next();
            Status a16 = Status.INSTANCE.a(next.status);
            long j3 = next.date;
            arrayList.add(new com.tencent.mobileqq.troop.homework.clockin.detail.widget.date.data.a(b16, a16, j3, com.tencent.mobileqq.troop.homework.clockin.c.f296281a.c(this.currentDate, j3)));
        }
        int size = this.detail.timeSettings.cycle - arrayList.size();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date(System.currentTimeMillis()));
        for (int i3 = 0; i3 < size; i3++) {
            calendar.add(6, 1);
            arrayList.add(new com.tencent.mobileqq.troop.homework.clockin.detail.widget.date.data.a(b16, Status.STATUS_UNKNOWN, calendar.getTimeInMillis() / 1000, false));
        }
        com.tencent.mobileqq.troop.homework.clockin.c.f296281a.e(this.detail.timeSettings.checkinWeekdays, arrayList);
        this.uiState.setValue(new a.d(arrayList));
        this.dateList.clear();
        this.dateList.addAll(arrayList);
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : states) {
            GroupSchoolTaskCheckInStatusInfo groupSchoolTaskCheckInStatusInfo = (GroupSchoolTaskCheckInStatusInfo) obj;
            if (groupSchoolTaskCheckInStatusInfo.date < com.tencent.mobileqq.troop.homework.clockin.c.f296281a.f() && groupSchoolTaskCheckInStatusInfo.status == 1) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                arrayList2.add(obj);
            }
        }
        SimpleEventBus.getInstance().dispatchEvent(new HWClockInDetailEvent.UpdateUnClockInCount(arrayList2.size()));
    }

    @Override // com.tencent.mobileqq.troop.homework.clockin.detail.model.list.e
    public long a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Long) iPatchRedirector.redirect((short) 5, (Object) this)).longValue();
        }
        return this.currentDate;
    }

    @Override // com.tencent.mobileqq.troop.homework.clockin.detail.model.list.e
    public void b(long date, @Nullable Boolean needState) {
        boolean isEmpty;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, Long.valueOf(date), needState);
            return;
        }
        this.currentDate = date;
        HWClockInDetailListStudentRepo hWClockInDetailListStudentRepo = this.repo;
        if (needState != null) {
            isEmpty = needState.booleanValue();
        } else {
            isEmpty = this.dateList.isEmpty();
        }
        FlowKt.launchIn(FlowKt.onEach(hWClockInDetailListStudentRepo.c(date, isEmpty), new HWClockInDetailListStudentUseCase$switchDate$1(this, null)), this.scope);
    }

    @Override // com.tencent.mobileqq.troop.homework.clockin.detail.model.list.e
    public void init() {
        long currentTimeMillis;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        if (QLog.isDebugVersion()) {
            QLog.d("HW.ClockIn.DETAIL.HWClockInDetailListStudentUseCase", 4, "init.");
        }
        GroupSchoolTaskData groupSchoolTaskData = this.detail;
        if (groupSchoolTaskData.status == 3) {
            currentTimeMillis = groupSchoolTaskData.publishTime;
        } else {
            currentTimeMillis = System.currentTimeMillis() / 1000;
        }
        e.b.a(this, currentTimeMillis, null, 2, null);
    }

    @Override // com.tencent.mobileqq.troop.homework.clockin.detail.model.list.e
    public void loadMore() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        }
    }
}
