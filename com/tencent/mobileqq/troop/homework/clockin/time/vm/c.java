package com.tencent.mobileqq.troop.homework.clockin.time.vm;

import android.os.Bundle;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.troop.homework.clockin.time.event.HWClockInTimeEvent;
import com.tencent.mobileqq.troop.homework.clockin.time.vm.a;
import com.tencent.mobileqq.troop.homework.clockin.time.vm.b;
import com.tencent.qqnt.base.mvi.BaseViewModel;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u000f\u0012\u0006\u0010\u0015\u001a\u00020\u0014\u00a2\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016R\u001a\u0010\u000b\u001a\u00020\u00038\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000f\u001a\u00020\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/troop/homework/clockin/time/vm/c;", "Lcom/tencent/qqnt/base/mvi/BaseViewModel;", "Lcom/tencent/mobileqq/troop/homework/clockin/time/vm/a;", "Lcom/tencent/mobileqq/troop/homework/clockin/time/vm/b;", "userIntent", "", "M1", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/troop/homework/clockin/time/vm/b;", "L1", "()Lcom/tencent/mobileqq/troop/homework/clockin/time/vm/b;", "mNoneValueIntent", "", "D", "Ljava/lang/String;", "troopUin", "Lcom/tencent/mobileqq/troop/homework/clockin/time/data/a;", "E", "Lcom/tencent/mobileqq/troop/homework/clockin/time/data/a;", "clockInTimeInfo", "Landroid/os/Bundle;", "bundle", "<init>", "(Landroid/os/Bundle;)V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class c extends BaseViewModel<a, b> {
    static IPatchRedirector $redirector_;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final b mNoneValueIntent;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final String troopUin;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private com.tencent.mobileqq.troop.homework.clockin.time.data.a clockInTimeInfo;

    /* JADX WARN: Code restructure failed: missing block: B:10:0x003f, code lost:
    
        r1 = kotlin.collections.CollectionsKt___CollectionsKt.toList(r1);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public c(@NotNull Bundle bundle) {
        List mutableList;
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) bundle);
            return;
        }
        this.mNoneValueIntent = b.a.f296624a;
        String string = bundle.getString("troop_uin", "");
        Intrinsics.checkNotNullExpressionValue(string, "bundle.getString(HWClockInArgKey.TROOP_UIN, \"\")");
        this.troopUin = string;
        int i3 = bundle.getInt("time_setting_time_days_limit", 0);
        ArrayList<Integer> integerArrayList = bundle.getIntegerArrayList("time_setting_frequency");
        List emptyList = (integerArrayList == null || emptyList == null) ? CollectionsKt__CollectionsKt.emptyList() : emptyList;
        long j3 = bundle.getLong("time_setting_remind_time", 0L);
        mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) emptyList);
        this.clockInTimeInfo = new com.tencent.mobileqq.troop.homework.clockin.time.data.a(i3, mutableList, j3);
    }

    @Override // com.tencent.qqnt.base.mvi.BaseViewModel
    @NotNull
    /* renamed from: L1, reason: merged with bridge method [inline-methods] */
    public b getMNoneValueIntent() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (b) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.mNoneValueIntent;
    }

    @Override // com.tencent.qqnt.base.mvi.BaseViewModel
    /* renamed from: M1, reason: merged with bridge method [inline-methods] */
    public void handleIntent(@NotNull b userIntent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) userIntent);
            return;
        }
        Intrinsics.checkNotNullParameter(userIntent, "userIntent");
        if (userIntent instanceof b.c) {
            obtainUiState().setValue(new a.C8724a(this.clockInTimeInfo));
        } else if (userIntent instanceof b.C8725b) {
            com.tencent.mobileqq.troop.homework.clockin.time.data.a a16 = ((b.C8725b) userIntent).a();
            this.clockInTimeInfo = new com.tencent.mobileqq.troop.homework.clockin.time.data.a(a16.e(), a16.a(), a16.d());
            obtainUiState().setValue(new a.C8724a(this.clockInTimeInfo));
            SimpleEventBus.getInstance().dispatchEvent(new HWClockInTimeEvent.HWClockInTimeInfoUpdate(this.clockInTimeInfo));
        }
    }
}
