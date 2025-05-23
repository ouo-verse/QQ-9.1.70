package com.tencent.mobileqq.icgame.room.component;

import com.heytap.databaseengine.model.UserInfo;
import com.tencent.icgame.common.api.IAegisLogApi;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.icgame.framework.interfaceService.InjectService;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqlive.callback.gift.OnQueryGiftIconCallback;
import com.tencent.mobileqq.qroute.QRoute;
import cooperation.vip.tianshu.TianShuMMKVConstant;
import fu0.c;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 .2\u00020\u00012\u00020\u0002:\u0001/B\u000f\u0012\u0006\u0010+\u001a\u00020*\u00a2\u0006\u0004\b,\u0010-J\u001a\u0010\b\u001a\u00020\u00072\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J!\u0010\f\u001a\u00020\u0007\"\b\b\u0000\u0010\n*\u00020\t2\u0006\u0010\u000b\u001a\u00028\u0000H\u0016\u00a2\u0006\u0004\b\f\u0010\rJ\b\u0010\u000e\u001a\u00020\u0007H\u0016R\u0016\u0010\u0010\u001a\u00020\u000f8\u0002@\u0002X\u0083.\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0013\u001a\u00020\u00128\u0002@\u0002X\u0083.\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R#\u0010\u001b\u001a\n \u0016*\u0004\u0018\u00010\u00150\u00158BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR!\u0010!\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001c8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001e\u0010\u0018\u001a\u0004\b\u001f\u0010 R\u0016\u0010%\u001a\u00020\"8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b#\u0010$R$\u0010(\u001a\u00020\u00052\u0006\u0010&\u001a\u00020\u00058\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b\n\u0010'\u001a\u0004\b(\u0010)\u00a8\u00060"}, d2 = {"Lcom/tencent/mobileqq/icgame/room/component/ICGameAudienceViewModel;", "Lk32/a;", "Lpv0/a;", "Lcom/tencent/mobileqq/qqlive/callback/gift/OnQueryGiftIconCallback;", "callback", "", "isForce", "", "P1", "Lg32/b;", "E", "event", "w0", "(Lg32/b;)V", "L1", "Lh22/a;", "qqLiveRoomService", "Lh22/a;", "Lb42/b;", "audienceSupport", "Lb42/b;", "Lfu0/c;", "kotlin.jvm.PlatformType", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lkotlin/Lazy;", "getLiveRoomService", "()Lfu0/c;", "liveRoomService", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Lcom/tencent/icgame/game/liveroom/impl/room/roomconfig/a;", BdhLogUtil.LogTag.Tag_Conn, "O1", "()Ljava/util/concurrent/CopyOnWriteArrayList;", "configChangeList", "", "D", "Ljava/lang/String;", "selfUid", "<set-?>", "Z", "isCanShowGift", "()Z", "Lf32/a;", "componentContext", "<init>", "(Lf32/a;)V", UserInfo.SEX_FEMALE, "a", "ic-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class ICGameAudienceViewModel extends k32.a implements pv0.a {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final Lazy configChangeList;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private String selfUid;

    /* renamed from: E, reason: from kotlin metadata */
    private boolean isCanShowGift;

    @InjectService(key = b42.b.class)
    private b42.b audienceSupport;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy liveRoomService;

    @InjectService(key = h22.a.class)
    private h22.a qqLiveRoomService;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\u0018\u0010\u000b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bH\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/mobileqq/icgame/room/component/ICGameAudienceViewModel$b", "Lcom/tencent/mobileqq/qqlive/callback/gift/OnQueryGiftIconCallback;", "", "code", "", "msg", "", "onFailed", "", TianShuMMKVConstant.LicenseInfoKey.CAN_SHOW, "isSpecialAnchor", "onSuccess", "ic-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes15.dex */
    public static final class b implements OnQueryGiftIconCallback {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ OnQueryGiftIconCallback f237440a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ ICGameAudienceViewModel f237441b;

        b(OnQueryGiftIconCallback onQueryGiftIconCallback, ICGameAudienceViewModel iCGameAudienceViewModel) {
            this.f237440a = onQueryGiftIconCallback;
            this.f237441b = iCGameAudienceViewModel;
        }

        @Override // com.tencent.mobileqq.qqlive.callback.gift.OnQueryGiftIconCallback
        public void onFailed(int code, @Nullable String msg2) {
            OnQueryGiftIconCallback onQueryGiftIconCallback = this.f237440a;
            if (onQueryGiftIconCallback != null) {
                onQueryGiftIconCallback.onFailed(code, msg2);
            }
        }

        @Override // com.tencent.mobileqq.qqlive.callback.gift.OnQueryGiftIconCallback
        public void onSuccess(boolean canShow, boolean isSpecialAnchor) {
            this.f237441b.isCanShowGift = canShow;
            OnQueryGiftIconCallback onQueryGiftIconCallback = this.f237440a;
            if (onQueryGiftIconCallback != null) {
                onQueryGiftIconCallback.onSuccess(canShow, isSpecialAnchor);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ICGameAudienceViewModel(@NotNull f32.a componentContext) {
        super(componentContext);
        Lazy lazy;
        Lazy lazy2;
        Intrinsics.checkNotNullParameter(componentContext, "componentContext");
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<c>() { // from class: com.tencent.mobileqq.icgame.room.component.ICGameAudienceViewModel$liveRoomService$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final c invoke() {
                return (c) qx0.a.b(c.class);
            }
        });
        this.liveRoomService = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<CopyOnWriteArrayList<com.tencent.icgame.game.liveroom.impl.room.roomconfig.a>>() { // from class: com.tencent.mobileqq.icgame.room.component.ICGameAudienceViewModel$configChangeList$2
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final CopyOnWriteArrayList<com.tencent.icgame.game.liveroom.impl.room.roomconfig.a> invoke() {
                return new CopyOnWriteArrayList<>();
            }
        });
        this.configChangeList = lazy2;
        this.selfUid = "";
        this.isCanShowGift = true;
    }

    private final CopyOnWriteArrayList<com.tencent.icgame.game.liveroom.impl.room.roomconfig.a> O1() {
        return (CopyOnWriteArrayList) this.configChangeList.getValue();
    }

    @Override // k32.a
    public void L1() {
        O1().clear();
    }

    public void P1(@Nullable OnQueryGiftIconCallback callback, boolean isForce) {
        b42.b bVar = this.audienceSupport;
        if (bVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("audienceSupport");
            bVar = null;
        }
        bVar.a(new b(callback, this), isForce);
    }

    @Override // k32.a, g32.h
    public <E extends g32.b> void w0(@NotNull E event) {
        Intrinsics.checkNotNullParameter(event, "event");
        ((IAegisLogApi) QRoute.api(IAegisLogApi.class)).i("ICGameAudienceViewModel", "event: " + event);
        super.w0(event);
    }
}
