package com.tencent.mobileqq.troop.homework.clockin.submit.vm;

import android.os.Bundle;
import androidx.lifecycle.ViewModelKt;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.troop.homework.clockin.submit.model.HWSubmitClockInRepo;
import com.tencent.mobileqq.troop.homework.clockin.submit.vm.b;
import com.tencent.mobileqq.troop.homework.common.widget.mediaedit.manager.PublishMediaEditManager;
import com.tencent.mobileqq.troop.homework.common.widget.mediaedit.manager.e;
import com.tencent.mobileqq.troop.homework.common.widget.mediaedit.manager.f;
import com.tencent.mobileqq.troop.homework.common.widget.mediaedit.model.BaseItem;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.base.mvi.BaseViewModel;
import com.tencent.qqnt.kernel.nativeinterface.GroupSchoolNoticeContent;
import com.tencent.util.QQToastUtil;
import java.io.Serializable;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.ExperimentalCoroutinesApi;
import kotlinx.coroutines.flow.FlowKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 62\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u00017B\u000f\u0012\u0006\u00103\u001a\u000202\u00a2\u0006\u0004\b4\u00105J\b\u0010\u0005\u001a\u00020\u0004H\u0003J\b\u0010\u0007\u001a\u00020\u0006H\u0002J\u0006\u0010\t\u001a\u00020\bJ\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0003H\u0017J\b\u0010\f\u001a\u00020\u0004H\u0014R\u0017\u0010\u0012\u001a\u00020\r8\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0015\u001a\n \u0013*\u0004\u0018\u00010\r0\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u000fR\u0014\u0010\u0019\u001a\u00020\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R(\u0010\u001f\u001a\u0016\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u001aj\n\u0012\u0004\u0012\u00020\u001b\u0018\u0001`\u001c8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0014\u0010\"\u001a\u00020\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b \u0010!R\u0014\u0010&\u001a\u00020#8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u0014\u0010*\u001a\u00020'8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b(\u0010)R\u001a\u0010/\u001a\u00020+8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0018\u0010,\u001a\u0004\b-\u0010.R\u0011\u00101\u001a\u00020\r8F\u00a2\u0006\u0006\u001a\u0004\b0\u0010\u0011\u00a8\u00068"}, d2 = {"Lcom/tencent/mobileqq/troop/homework/clockin/submit/vm/HWSubmitClockInViewModel;", "Lcom/tencent/qqnt/base/mvi/BaseViewModel;", "Lcom/tencent/mobileqq/troop/homework/clockin/submit/vm/a;", "Lcom/tencent/mobileqq/troop/homework/clockin/submit/vm/b;", "", "W1", "", "P1", "Lcom/tencent/mobileqq/troop/homework/common/widget/mediaedit/manager/f;", "R1", "userIntent", "U1", "onCleared", "", BdhLogUtil.LogTag.Tag_Conn, "Ljava/lang/String;", "T1", "()Ljava/lang/String;", "troopUin", "kotlin.jvm.PlatformType", "D", "clockInId", "", "E", "J", "date", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/troop/homework/common/widget/mediaedit/model/BaseItem;", "Lkotlin/collections/ArrayList;", UserInfo.SEX_FEMALE, "Ljava/util/ArrayList;", "modifyItems", "G", "Z", "isMakeUp", "Lcom/tencent/mobileqq/troop/homework/clockin/submit/model/HWSubmitClockInRepo;", "H", "Lcom/tencent/mobileqq/troop/homework/clockin/submit/model/HWSubmitClockInRepo;", "repo", "Lcom/tencent/mobileqq/troop/homework/common/widget/mediaedit/manager/e;", "I", "Lcom/tencent/mobileqq/troop/homework/common/widget/mediaedit/manager/e;", "mediaEditManager", "Lcom/tencent/mobileqq/troop/homework/clockin/submit/vm/b$a;", "Lcom/tencent/mobileqq/troop/homework/clockin/submit/vm/b$a;", "Q1", "()Lcom/tencent/mobileqq/troop/homework/clockin/submit/vm/b$a;", "mNoneValueIntent", "S1", "showTitle", "Landroid/os/Bundle;", "bundle", "<init>", "(Landroid/os/Bundle;)V", "K", "a", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class HWSubmitClockInViewModel extends BaseViewModel<a, b> {
    static IPatchRedirector $redirector_;

    /* renamed from: K, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final String troopUin;

    /* renamed from: D, reason: from kotlin metadata */
    private final String clockInId;

    /* renamed from: E, reason: from kotlin metadata */
    private final long date;

    /* renamed from: F, reason: from kotlin metadata */
    @Nullable
    private final ArrayList<BaseItem> modifyItems;

    /* renamed from: G, reason: from kotlin metadata */
    private final boolean isMakeUp;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private final HWSubmitClockInRepo repo;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private final e mediaEditManager;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    private final b.a mNoneValueIntent;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/troop/homework/clockin/submit/vm/HWSubmitClockInViewModel$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.troop.homework.clockin.submit.vm.HWSubmitClockInViewModel$a, reason: from kotlin metadata */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(44592);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 8)) {
            redirector.redirect((short) 8);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public HWSubmitClockInViewModel(@NotNull Bundle bundle) {
        ArrayList<BaseItem> arrayList;
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) bundle);
            return;
        }
        String string = bundle.getString("troop_uin", "");
        Intrinsics.checkNotNullExpressionValue(string, "bundle.getString(HWClockInArgKey.TROOP_UIN, \"\")");
        this.troopUin = string;
        String clockInId = bundle.getString("clock_in_id", "");
        this.clockInId = clockInId;
        long j3 = bundle.getLong("date", 0L);
        this.date = j3;
        Serializable serializable = bundle.getSerializable("media_item_list");
        if (serializable instanceof ArrayList) {
            arrayList = (ArrayList) serializable;
        } else {
            arrayList = null;
        }
        this.modifyItems = arrayList;
        this.isMakeUp = bundle.getBoolean("is_make_up", false);
        Intrinsics.checkNotNullExpressionValue(clockInId, "clockInId");
        this.repo = new HWSubmitClockInRepo(string, clockInId, j3);
        e eVar = new e(string, ViewModelKt.getViewModelScope(this));
        this.mediaEditManager = eVar;
        QLog.i("HW.ClockIn.SUBMIT.HWSubmitClockInViewModel", 1, "troopUin:" + T1() + "-" + this.clockInId + "-" + this.date + "-" + this.isMakeUp + ".");
        PublishMediaEditManager.S(eVar, null, null, null, "\u8bf7\u63d0\u4ea4\u5185\u5bb9", Integer.valueOf(ViewUtils.dip2px(88.0f)), null, 39, null);
        eVar.c0(arrayList);
        this.mNoneValueIntent = b.a.f296551a;
    }

    private final boolean P1() {
        if (this.mediaEditManager.D()) {
            QQToastUtil.showQQToast(1, "\u8bf7\u8f93\u5165\u5185\u5bb9");
            return false;
        }
        if (this.mediaEditManager.A()) {
            return true;
        }
        QQToastUtil.showQQToast(1, "\u6587\u4ef6\u672a\u4e0a\u4f20\u5b8c\u6210");
        return false;
    }

    @ExperimentalCoroutinesApi
    private final void W1() {
        boolean z16;
        if (!P1()) {
            return;
        }
        HWSubmitClockInRepo hWSubmitClockInRepo = this.repo;
        GroupSchoolNoticeContent E = this.mediaEditManager.E();
        long j3 = this.date;
        boolean z17 = this.isMakeUp;
        ArrayList<BaseItem> arrayList = this.modifyItems;
        if (arrayList != null && !arrayList.isEmpty()) {
            z16 = false;
        } else {
            z16 = true;
        }
        FlowKt.launchIn(FlowKt.m2026catch(FlowKt.onCompletion(FlowKt.onEach(hWSubmitClockInRepo.c(E, j3, z17, true ^ z16), new HWSubmitClockInViewModel$submit$1(this, null)), new HWSubmitClockInViewModel$submit$2(null)), new HWSubmitClockInViewModel$submit$3(null)), ViewModelKt.getViewModelScope(this));
    }

    @Override // com.tencent.qqnt.base.mvi.BaseViewModel
    @NotNull
    /* renamed from: Q1, reason: merged with bridge method [inline-methods] */
    public b.a getMNoneValueIntent() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (b.a) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.mNoneValueIntent;
    }

    @NotNull
    public final f R1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (f) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.mediaEditManager;
    }

    @NotNull
    public final String S1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        if (this.isMakeUp) {
            return "\u63d0\u4ea4\u8865\u5361\u6210\u679c";
        }
        return "\u63d0\u4ea4\u6253\u5361\u6210\u679c";
    }

    @NotNull
    public final String T1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.troopUin;
    }

    @Override // com.tencent.qqnt.base.mvi.BaseViewModel
    @ExperimentalCoroutinesApi
    /* renamed from: U1, reason: merged with bridge method [inline-methods] */
    public void handleIntent(@NotNull b userIntent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) userIntent);
            return;
        }
        Intrinsics.checkNotNullParameter(userIntent, "userIntent");
        if (userIntent instanceof b.C8720b) {
            W1();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.qqnt.base.mvi.BaseViewModel, androidx.lifecycle.ViewModel
    public void onCleared() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
        } else {
            super.onCleared();
            this.mediaEditManager.G();
        }
    }
}
