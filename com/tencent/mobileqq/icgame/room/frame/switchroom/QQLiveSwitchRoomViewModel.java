package com.tencent.mobileqq.icgame.room.frame.switchroom;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.icgame.base.room.multipage.api.SwitchDirection;
import com.tencent.mobileqq.icgame.base.room.multipage.api.SwitchPageInfo;
import com.tencent.mobileqq.icgame.base.room.multipage.api.c;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u00012\u00020\u0002B\u0007\u00a2\u0006\u0004\b\u001f\u0010 J&\u0010\u000b\u001a\u00020\n2\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016J\u0014\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\fH\u0016J\b\u0010\u000e\u001a\u00020\nH\u0016R \u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u001b\u0010\u0018\u001a\u00020\u00138FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0017\u0010\u001e\u001a\u00020\u00198\u0006\u00a2\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\u00a8\u0006!"}, d2 = {"Lcom/tencent/mobileqq/icgame/room/frame/switchroom/QQLiveSwitchRoomViewModel;", "Landroidx/lifecycle/ViewModel;", "Lcom/tencent/mobileqq/icgame/base/room/multipage/api/c;", "", "Lcom/tencent/mobileqq/icgame/base/room/multipage/api/f;", "pageList", "Lcom/tencent/mobileqq/icgame/base/room/multipage/api/SwitchDirection;", "direction", "", "index", "", "u1", "Landroidx/lifecycle/LiveData;", "Z0", "B0", "Landroidx/lifecycle/MutableLiveData;", "i", "Landroidx/lifecycle/MutableLiveData;", "_switchListLiveData", "Lcom/tencent/mobileqq/icgame/room/frame/switchroom/b;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lkotlin/Lazy;", "M1", "()Lcom/tencent/mobileqq/icgame/room/frame/switchroom/b;", "qqliveRoomSwitchDataModel", "Lcom/tencent/mobileqq/icgame/room/frame/switchroom/a;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/icgame/room/frame/switchroom/a;", "getRoomListUpdateCallback", "()Lcom/tencent/mobileqq/icgame/room/frame/switchroom/a;", "roomListUpdateCallback", "<init>", "()V", "ic-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class QQLiveSwitchRoomViewModel extends ViewModel implements c {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.icgame.room.frame.switchroom.a roomListUpdateCallback;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final MutableLiveData<List<SwitchPageInfo>> _switchListLiveData = new MutableLiveData<>();

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy qqliveRoomSwitchDataModel;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J(\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/icgame/room/frame/switchroom/QQLiveSwitchRoomViewModel$a", "Lcom/tencent/mobileqq/icgame/room/frame/switchroom/a;", "", "result", "index", "", "Lcom/tencent/mobileqq/icgame/base/room/multipage/api/f;", "roomList", "", "a", "ic-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes15.dex */
    public static final class a implements com.tencent.mobileqq.icgame.room.frame.switchroom.a {
        a() {
        }

        @Override // com.tencent.mobileqq.icgame.room.frame.switchroom.a
        public void a(int result, int index, @Nullable List<SwitchPageInfo> roomList) {
            if (result == 0) {
                QQLiveSwitchRoomViewModel.this._switchListLiveData.setValue(roomList);
            }
        }
    }

    public QQLiveSwitchRoomViewModel() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<b>() { // from class: com.tencent.mobileqq.icgame.room.frame.switchroom.QQLiveSwitchRoomViewModel$qqliveRoomSwitchDataModel$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final b invoke() {
                return new b();
            }
        });
        this.qqliveRoomSwitchDataModel = lazy;
        this.roomListUpdateCallback = new a();
    }

    @Override // com.tencent.mobileqq.icgame.base.room.multipage.api.c
    public void B0() {
        M1().a();
    }

    @NotNull
    public final b M1() {
        return (b) this.qqliveRoomSwitchDataModel.getValue();
    }

    @Override // com.tencent.mobileqq.icgame.base.room.multipage.api.c
    @NotNull
    public LiveData<List<SwitchPageInfo>> Z0() {
        return this._switchListLiveData;
    }

    @Override // com.tencent.mobileqq.icgame.base.room.multipage.api.c
    public void u1(@NotNull List<SwitchPageInfo> pageList, @NotNull SwitchDirection direction, int index) {
        Intrinsics.checkNotNullParameter(pageList, "pageList");
        Intrinsics.checkNotNullParameter(direction, "direction");
        M1().b(pageList, direction, index, this.roomListUpdateCallback);
    }
}
