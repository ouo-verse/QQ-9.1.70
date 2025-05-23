package com.tencent.state.library.components.fragments;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.tencent.state.square.Square;
import com.tencent.state.square.SquareBaseKt;
import com.tencent.state.square.SquareLogger;
import com.tencent.state.template.data.CommonDataKt;
import com.tencent.state.template.data.CommonRoomInfo;
import com.tencent.state.template.data.EnterRoomInfo;
import com.tencent.state.template.data.SitDownInfo;
import com.tencent.state.template.data.User;
import cooperation.qqcircle.report.QCircleAlphaUserReporter;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\rH\u0002J\"\u0010\u000e\u001a\f\u0012\u0004\u0012\u00020\t0\bj\u0002`\n2\u0006\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u0006H\u0002J\u0010\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u001a\u0010\u0014\u001a\u00020\t2\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\b\u0010\u0019\u001a\u00020\tH\u0016J\u0010\u0010\u001a\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\rH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\t\u0018\u00010\bj\u0004\u0018\u0001`\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/state/library/components/fragments/LibraryStrangerPrivacyComponent;", "Lcom/tencent/state/library/components/fragments/LibraryBaseComponent;", "()V", "isStartFocus", "Ljava/util/concurrent/atomic/AtomicBoolean;", "showTag", "", "task", "Lkotlin/Function0;", "", "Lcom/tencent/state/square/Task;", "checkAndShowPrivacyDialog", QCircleAlphaUserReporter.KEY_USER, "Lcom/tencent/state/template/data/User;", "getShowDialogTask", "delay", "tag", "onEnterRoom", "info", "Lcom/tencent/state/template/data/EnterRoomInfo;", "onFragmentDestroyed", "fm", "Landroidx/fragment/app/FragmentManager;", "f", "Landroidx/fragment/app/Fragment;", "onMeFocusEnd", "onMeFocusStart", "Companion", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes34.dex */
public final class LibraryStrangerPrivacyComponent extends LibraryBaseComponent {
    private static final String TAG = "LibraryStrangerPrivacyComponent";
    private final AtomicBoolean isStartFocus = new AtomicBoolean(false);
    private long showTag;
    private Function0<Unit> task;

    private final void checkAndShowPrivacyDialog(User user) {
        long serverTime = Square.INSTANCE.getConfig().getCommonUtils().getServerTime();
        SitDownInfo sitDown = user.getSitDown();
        long sitDownStartTime = serverTime - (sitDown != null ? sitDown.getSitDownStartTime() : serverTime);
        SquareBaseKt.getSquareLog().d(TAG, "focusTime: " + sitDownStartTime);
        if (sitDownStartTime <= 15) {
            long max = Math.max(0L, 15 - sitDownStartTime);
            this.showTag = serverTime;
            Function0<Unit> showDialogTask = getShowDialogTask(max, serverTime);
            this.task = showDialogTask;
            SquareBaseKt.getSquareThread().postOnUiDelayed(max * 1000, showDialogTask);
        }
    }

    private final Function0<Unit> getShowDialogTask(long delay, long tag) {
        return new LibraryStrangerPrivacyComponent$getShowDialogTask$1(this, tag, delay);
    }

    @Override // com.tencent.state.template.map.component.TemplateMapBaseComponent, com.tencent.state.template.map.component.ITemplateMapEvent
    public void onEnterRoom(EnterRoomInfo info) {
        Intrinsics.checkNotNullParameter(info, "info");
        SquareLogger squareLog = SquareBaseKt.getSquareLog();
        StringBuilder sb5 = new StringBuilder();
        sb5.append("onEnterRoom seated: ");
        CommonRoomInfo room = info.getRoom();
        Object obj = null;
        sb5.append(room != null ? Boolean.valueOf(CommonDataKt.isMeSeated(room)) : null);
        sb5.append(" isStartFocus:");
        sb5.append(this.isStartFocus.get());
        squareLog.d(TAG, sb5.toString());
        CommonRoomInfo room2 = info.getRoom();
        if (room2 != null && CommonDataKt.isMeSeated(room2) && this.isStartFocus.compareAndSet(false, true)) {
            Iterator<T> it = info.getRoom().getUsers().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Object next = it.next();
                if (Intrinsics.areEqual(Square.INSTANCE.getConfig().getCommonUtils().getCurrentAccountUin(), ((User) next).getUin())) {
                    obj = next;
                    break;
                }
            }
            User user = (User) obj;
            if (user != null) {
                checkAndShowPrivacyDialog(user);
            }
        }
    }

    @Override // com.tencent.state.VasBaseFragmentComponent, com.tencent.state.FragmentComponent
    public void onFragmentDestroyed(FragmentManager fm5, Fragment f16) {
        Intrinsics.checkNotNullParameter(f16, "f");
        Function0<Unit> function0 = this.task;
        if (function0 != null) {
            SquareBaseKt.getSquareThread().removeTaskOnUI(function0);
        }
    }

    @Override // com.tencent.state.template.map.component.TemplateMapBaseComponent, com.tencent.state.template.map.component.ITemplateMapEvent
    public void onMeFocusEnd() {
        SquareBaseKt.getSquareLog().d(TAG, "onMeFocusEnd");
        this.isStartFocus.compareAndSet(true, false);
        this.showTag = 0L;
        Function0<Unit> function0 = this.task;
        if (function0 != null) {
            SquareBaseKt.getSquareThread().removeTaskOnUI(function0);
        }
    }

    @Override // com.tencent.state.template.map.component.TemplateMapBaseComponent, com.tencent.state.template.map.component.ITemplateMapEvent
    public void onMeFocusStart(User user) {
        Intrinsics.checkNotNullParameter(user, "user");
        SquareBaseKt.getSquareLog().d(TAG, "onMeFocusStart isStartFocus: " + this.isStartFocus.get());
        if (this.isStartFocus.compareAndSet(false, true)) {
            checkAndShowPrivacyDialog(user);
        }
    }
}
