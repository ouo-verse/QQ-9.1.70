package com.tencent.mobileqq.troop.homework.clockin.publish.vm;

import android.app.Activity;
import android.content.DialogInterface;
import android.os.Bundle;
import androidx.lifecycle.ViewModelKt;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.troop.homework.clockin.publish.model.HWClockInPublishRepo;
import com.tencent.mobileqq.troop.homework.clockin.publish.vm.a;
import com.tencent.mobileqq.troop.homework.clockin.publish.vm.b;
import com.tencent.mobileqq.troop.homework.clockin.time.HWClockInTimeFragment;
import com.tencent.mobileqq.troop.homework.clockin.time.event.HWClockInTimeEvent;
import com.tencent.mobileqq.troop.homework.common.HWPageType;
import com.tencent.mobileqq.troop.homework.common.trooplist.HWTroopListFragment;
import com.tencent.mobileqq.troop.homework.common.trooplist.event.HWTroopListEvent;
import com.tencent.mobileqq.troop.homework.common.widget.mediaedit.manager.PublishMediaEditManager;
import com.tencent.mobileqq.troop.homework.common.widget.mediaedit.manager.f;
import com.tencent.mobileqq.troop.homework.common.widget.mediaedit.model.TitleItem;
import com.tencent.mobileqq.troop.homework.notice.HWNoticeUtils;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qqnt.base.mvi.BaseViewModel;
import com.tencent.qqnt.kernel.nativeinterface.GroupSchoolNoticeContent;
import com.tencent.qqnt.kernel.nativeinterface.GroupSchoolTaskTimeSettings;
import com.tencent.qqnt.kernel.nativeinterface.PublishGroupSchoolTaskReq;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import com.tencent.util.QQToastUtil;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.ExperimentalCoroutinesApi;
import kotlinx.coroutines.flow.FlowKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0011\u0018\u0000 L2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\b\u0012\u0004\u0012\u00020\u00050\u0004:\u0001MB\u000f\u0012\u0006\u0010&\u001a\u00020!\u00a2\u0006\u0004\bJ\u0010KJ\b\u0010\u0007\u001a\u00020\u0006H\u0002J\u0012\u0010\n\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0003J\b\u0010\u000b\u001a\u00020\u0006H\u0003J\b\u0010\r\u001a\u00020\fH\u0002J\b\u0010\u000f\u001a\u00020\u000eH\u0002J\u0010\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0010H\u0002J\u0010\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0013H\u0002J\u0010\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u0003H\u0017J\u0012\u0010\u0018\u001a\u00020\u00062\b\u0010\u0017\u001a\u0004\u0018\u00010\u0005H\u0016J\u0006\u0010\u001a\u001a\u00020\u0019J\u0006\u0010\u001b\u001a\u00020\u000eJ\b\u0010\u001c\u001a\u00020\u0006H\u0014J$\u0010 \u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u001e0\u001dj\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u001e`\u001fH\u0016R\u0017\u0010&\u001a\u00020!8\u0006\u00a2\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%R\u001a\u0010,\u001a\u00020'8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+R\u0017\u00101\u001a\u00020\f8\u0006\u00a2\u0006\f\n\u0004\b-\u0010.\u001a\u0004\b/\u00100R\u0017\u00104\u001a\u00020\f8\u0006\u00a2\u0006\f\n\u0004\b2\u0010.\u001a\u0004\b3\u00100R\u0014\u00108\u001a\u0002058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b6\u00107R\u0014\u0010<\u001a\u0002098\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b:\u0010;R\u0014\u0010@\u001a\u00020=8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b>\u0010?R\u0016\u0010C\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bA\u0010BR\u0018\u0010F\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bD\u0010ER\u0018\u0010I\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bG\u0010H\u00a8\u0006N"}, d2 = {"Lcom/tencent/mobileqq/troop/homework/clockin/publish/vm/HWClockInPublishViewModel;", "Lcom/tencent/qqnt/base/mvi/BaseViewModel;", "Lcom/tencent/mobileqq/troop/homework/clockin/publish/vm/a;", "Lcom/tencent/mobileqq/troop/homework/clockin/publish/vm/b;", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "", "initData", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "b2", "e2", "", "U1", "", "P1", "Lcom/tencent/mobileqq/troop/homework/common/trooplist/data/b;", "info", ICustomDataEditor.STRING_ARRAY_PARAM_2, "Lcom/tencent/mobileqq/troop/homework/clockin/time/data/a;", "Z1", "userIntent", "X1", "event", "onReceiveEvent", "Lcom/tencent/mobileqq/troop/homework/common/widget/mediaedit/manager/f;", "S1", "Q1", "onCleared", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "Lkotlin/collections/ArrayList;", "getEventClass", "Landroid/os/Bundle;", BdhLogUtil.LogTag.Tag_Conn, "Landroid/os/Bundle;", "getBundle", "()Landroid/os/Bundle;", "bundle", "Lcom/tencent/mobileqq/troop/homework/clockin/publish/vm/b$d;", "D", "Lcom/tencent/mobileqq/troop/homework/clockin/publish/vm/b$d;", "R1", "()Lcom/tencent/mobileqq/troop/homework/clockin/publish/vm/b$d;", "mNoneValueIntent", "E", "Ljava/lang/String;", "W1", "()Ljava/lang/String;", "troopUin", UserInfo.SEX_FEMALE, "T1", "templateId", "Lcom/tencent/mobileqq/troop/homework/common/widget/mediaedit/model/d;", "G", "Lcom/tencent/mobileqq/troop/homework/common/widget/mediaedit/model/d;", "mediaDataModel", "Lcom/tencent/mobileqq/troop/homework/clockin/publish/vm/c;", "H", "Lcom/tencent/mobileqq/troop/homework/clockin/publish/vm/c;", "mediaEditManager", "Lcom/tencent/mobileqq/troop/homework/clockin/publish/model/HWClockInPublishRepo;", "I", "Lcom/tencent/mobileqq/troop/homework/clockin/publish/model/HWClockInPublishRepo;", "repo", "J", "Z", "allowReplenish", "K", "Lcom/tencent/mobileqq/troop/homework/common/trooplist/data/b;", "troopListInfo", "L", "Lcom/tencent/mobileqq/troop/homework/clockin/time/data/a;", "timeRangeInfo", "<init>", "(Landroid/os/Bundle;)V", "M", "a", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class HWClockInPublishViewModel extends BaseViewModel<a, b> implements SimpleEventReceiver<SimpleBaseEvent> {
    static IPatchRedirector $redirector_;

    /* renamed from: M, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final Bundle bundle;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final b.d mNoneValueIntent;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final String troopUin;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final String templateId;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.troop.homework.common.widget.mediaedit.model.d mediaDataModel;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private final c mediaEditManager;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private final HWClockInPublishRepo repo;

    /* renamed from: J, reason: from kotlin metadata */
    private boolean allowReplenish;

    /* renamed from: K, reason: from kotlin metadata */
    @Nullable
    private com.tencent.mobileqq.troop.homework.common.trooplist.data.b troopListInfo;

    /* renamed from: L, reason: from kotlin metadata */
    @Nullable
    private com.tencent.mobileqq.troop.homework.clockin.time.data.a timeRangeInfo;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u00058\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0007R\u0014\u0010\t\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0004\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/troop/homework/clockin/publish/vm/HWClockInPublishViewModel$a;", "", "", "DEFAULT_TEMPLATED_ID", "Ljava/lang/String;", "", "MAX_CONTENT_WORD_COUNT", "I", "MAX_TITLE_WORD_COUNT", "TAG", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.troop.homework.clockin.publish.vm.HWClockInPublishViewModel$a, reason: from kotlin metadata */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(44452);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 12)) {
            redirector.redirect((short) 12);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public HWClockInPublishViewModel(@NotNull Bundle bundle) {
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) bundle);
            return;
        }
        this.bundle = bundle;
        this.mNoneValueIntent = b.d.f296491a;
        String string = bundle.getString("troop_uin", "");
        Intrinsics.checkNotNullExpressionValue(string, "bundle.getString(HWClockInArgKey.TROOP_UIN, \"\")");
        this.troopUin = string;
        String string2 = bundle.getString("template_id", "0");
        Intrinsics.checkNotNullExpressionValue(string2, "bundle.getString(HWClock\u2026ID, DEFAULT_TEMPLATED_ID)");
        this.templateId = string2;
        com.tencent.mobileqq.troop.homework.common.widget.mediaedit.model.d dVar = new com.tencent.mobileqq.troop.homework.common.widget.mediaedit.model.d();
        TitleItem r16 = dVar.r();
        r16.setReqFocus(Intrinsics.areEqual(string2, "0"));
        if (r16.isReqFocus()) {
            r16.setShowInputMethodOnce(true);
        }
        dVar.r().setMaxWordCount(10);
        dVar.k().setReqFocus(!Intrinsics.areEqual(string2, "0"));
        dVar.k().setMaxWordCount(500);
        this.mediaDataModel = dVar;
        this.mediaEditManager = new c(string, ViewModelKt.getViewModelScope(this), dVar);
        this.repo = new HWClockInPublishRepo();
        SimpleEventBus.getInstance().registerReceiver(this);
        initData();
    }

    private final boolean P1() {
        boolean z16;
        if (this.mediaEditManager.W()) {
            QQToastUtil.showQQToast(1, "\u8bf7\u586b\u5199\u6807\u9898\u540e\u53d1\u5e03");
            return false;
        }
        if (this.mediaEditManager.D()) {
            QQToastUtil.showQQToast(1, "\u8bf7\u586b\u5199\u5185\u5bb9\u540e\u53d1\u5e03");
            return false;
        }
        if (!this.mediaEditManager.A()) {
            QQToastUtil.showQQToast(1, "\u6587\u4ef6\u672a\u4e0a\u4f20\u5b8c\u6210");
            return false;
        }
        com.tencent.mobileqq.troop.homework.clockin.time.data.a aVar = this.timeRangeInfo;
        if (aVar != null && aVar.f()) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            return true;
        }
        QQToastUtil.showQQToast(1, "\u8bf7\u5b8c\u6210\u6253\u5361\u65f6\u95f4\u8bbe\u7f6e\u540e\u53d1\u5e03");
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String U1() {
        String str;
        boolean z16;
        String g16 = HWNoticeUtils.f297171a.g(this.troopUin);
        com.tencent.mobileqq.troop.homework.common.trooplist.data.b bVar = this.troopListInfo;
        if (bVar == null || (str = bVar.a()) == null) {
            str = "";
        }
        if (str.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            return g16 + "\u3001" + str;
        }
        return g16;
    }

    private final void Z1(com.tencent.mobileqq.troop.homework.clockin.time.data.a info) {
        this.timeRangeInfo = info;
        if (info.f()) {
            getMUiState().postValue(a.C8714a.f296487a);
        }
    }

    private final void a2(com.tencent.mobileqq.troop.homework.common.trooplist.data.b info) {
        this.troopListInfo = info;
        getMUiState().postValue(new a.c(info.a()));
    }

    @ExperimentalCoroutinesApi
    private final void b2(Activity activity) {
        if (activity == null || activity.isFinishing() || activity.isDestroyed() || !P1()) {
            return;
        }
        DialogUtil.createCustomDialog(activity, 230, (String) null, "\u53d1\u5e03\u540e\u5c06\u65e0\u6cd5\u4fee\u6539\uff0c\u662f\u5426\u53d1\u5e03\uff1f", "\u53d6\u6d88", "\u53d1\u5e03", new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.troop.homework.clockin.publish.vm.d
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                HWClockInPublishViewModel.c2(HWClockInPublishViewModel.this, dialogInterface, i3);
            }
        }, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.troop.homework.clockin.publish.vm.e
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                HWClockInPublishViewModel.d2(dialogInterface, i3);
            }
        }).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c2(HWClockInPublishViewModel this$0, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.e2();
        dialogInterface.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d2(DialogInterface dialogInterface, int i3) {
        dialogInterface.dismiss();
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x001e, code lost:
    
        if (r0 != false) goto L11;
     */
    @ExperimentalCoroutinesApi
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void e2() {
        boolean z16;
        int i3;
        ArrayList<Long> arrayList;
        long j3;
        boolean z17;
        GroupSchoolNoticeContent E = this.mediaEditManager.E();
        int i16 = 0;
        if (!Intrinsics.areEqual(this.templateId, "0")) {
            z16 = true;
            if (this.templateId.length() > 0) {
                z17 = true;
            } else {
                z17 = false;
            }
        }
        z16 = false;
        E.isTemplate = z16;
        com.tencent.mobileqq.troop.homework.clockin.time.data.a aVar = this.timeRangeInfo;
        if (aVar != null) {
            i3 = aVar.e();
        } else {
            i3 = 30;
        }
        com.tencent.mobileqq.troop.homework.clockin.time.data.a aVar2 = this.timeRangeInfo;
        if (aVar2 != null) {
            i16 = aVar2.b();
        }
        GroupSchoolTaskTimeSettings groupSchoolTaskTimeSettings = new GroupSchoolTaskTimeSettings(i3, i16);
        long parseLong = Long.parseLong(this.troopUin);
        com.tencent.mobileqq.troop.homework.common.trooplist.data.b bVar = this.troopListInfo;
        if (bVar == null || (arrayList = bVar.c()) == null) {
            arrayList = new ArrayList<>();
        }
        ArrayList<Long> arrayList2 = arrayList;
        com.tencent.mobileqq.troop.homework.clockin.time.data.a aVar3 = this.timeRangeInfo;
        if (aVar3 != null) {
            j3 = aVar3.c();
        } else {
            j3 = 0;
        }
        PublishGroupSchoolTaskReq publishGroupSchoolTaskReq = new PublishGroupSchoolTaskReq(parseLong, E, arrayList2, groupSchoolTaskTimeSettings, j3, this.allowReplenish);
        FlowKt.launchIn(FlowKt.onCompletion(FlowKt.m2026catch(FlowKt.onEach(this.repo.a(publishGroupSchoolTaskReq), new HWClockInPublishViewModel$requestPublish$1(publishGroupSchoolTaskReq, this, null)), new HWClockInPublishViewModel$requestPublish$2(null)), new HWClockInPublishViewModel$requestPublish$3(null)), ViewModelKt.getViewModelScope(this));
    }

    private final void initData() {
        PublishMediaEditManager.S(this.mediaEditManager, this.bundle.getString("template_title", ""), this.bundle.getString("template_content", ""), null, null, Integer.valueOf(ViewUtils.dpToPx(240.0f)), 10, 12, null);
        this.mediaEditManager.Q();
    }

    public final boolean Q1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this)).booleanValue();
        }
        if (!this.mediaEditManager.W() || !this.mediaEditManager.D() || !this.mediaEditManager.T()) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.qqnt.base.mvi.BaseViewModel
    @NotNull
    /* renamed from: R1, reason: merged with bridge method [inline-methods] */
    public b.d getMNoneValueIntent() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (b.d) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.mNoneValueIntent;
    }

    @NotNull
    public final f S1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (f) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return this.mediaEditManager;
    }

    @NotNull
    public final String T1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.templateId;
    }

    @NotNull
    public final String W1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.troopUin;
    }

    @Override // com.tencent.qqnt.base.mvi.BaseViewModel
    @ExperimentalCoroutinesApi
    /* renamed from: X1, reason: merged with bridge method [inline-methods] */
    public void handleIntent(@NotNull b userIntent) {
        int i3;
        List<Integer> list;
        long j3;
        List<String> emptyList;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) userIntent);
            return;
        }
        Intrinsics.checkNotNullParameter(userIntent, "userIntent");
        if (userIntent instanceof b.e) {
            b2(((b.e) userIntent).a());
            return;
        }
        if (userIntent instanceof b.a) {
            this.allowReplenish = ((b.a) userIntent).a();
            return;
        }
        if (userIntent instanceof b.C8715b) {
            HWTroopListFragment.Companion companion = HWTroopListFragment.INSTANCE;
            HWPageType hWPageType = HWPageType.PAGE_TYPE_CLOCK_IN;
            com.tencent.mobileqq.troop.homework.common.trooplist.data.b bVar = this.troopListInfo;
            if (bVar == null || (emptyList = bVar.b()) == null) {
                emptyList = CollectionsKt__CollectionsKt.emptyList();
            }
            companion.a(hWPageType, emptyList, this.troopUin);
            return;
        }
        if (userIntent instanceof b.c) {
            HWClockInTimeFragment.Companion companion2 = HWClockInTimeFragment.INSTANCE;
            String str = this.troopUin;
            com.tencent.mobileqq.troop.homework.clockin.time.data.a aVar = this.timeRangeInfo;
            if (aVar != null) {
                i3 = aVar.e();
            } else {
                i3 = 0;
            }
            int i16 = i3;
            com.tencent.mobileqq.troop.homework.clockin.time.data.a aVar2 = this.timeRangeInfo;
            ArrayList<Integer> arrayList = null;
            if (aVar2 != null) {
                list = aVar2.a();
            } else {
                list = null;
            }
            if (list instanceof ArrayList) {
                arrayList = (ArrayList) list;
            }
            com.tencent.mobileqq.troop.homework.clockin.time.data.a aVar3 = this.timeRangeInfo;
            if (aVar3 != null) {
                j3 = aVar3.d();
            } else {
                j3 = 0;
            }
            companion2.a(str, i16, arrayList, j3);
        }
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    @NotNull
    public ArrayList<Class<SimpleBaseEvent>> getEventClass() {
        ArrayList<Class<SimpleBaseEvent>> arrayListOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 11)) {
            arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(HWTroopListEvent.TroopRangeChanged.class, HWClockInTimeEvent.HWClockInTimeInfoUpdate.class);
            return arrayListOf;
        }
        return (ArrayList) iPatchRedirector.redirect((short) 11, (Object) this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.qqnt.base.mvi.BaseViewModel, androidx.lifecycle.ViewModel
    public void onCleared() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
            return;
        }
        super.onCleared();
        SimpleEventBus.getInstance().unRegisterReceiver(this);
        this.mediaEditManager.G();
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(@Nullable SimpleBaseEvent event) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) event);
        } else if (event instanceof HWTroopListEvent.TroopRangeChanged) {
            a2(((HWTroopListEvent.TroopRangeChanged) event).getInfo());
        } else if (event instanceof HWClockInTimeEvent.HWClockInTimeInfoUpdate) {
            Z1(((HWClockInTimeEvent.HWClockInTimeInfoUpdate) event).getClockInInfo());
        }
    }
}
