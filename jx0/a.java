package jx0;

import com.tencent.icgame.game.api.live.LiveRoomExtraInfo;
import com.tencent.mobileqq.icgame.api.IQQLiveSDK;
import com.tencent.mobileqq.icgame.api.IQQLiveSDKManager;
import com.tencent.mobileqq.icgame.api.config.QQLiveSDKConfigHelper;
import com.tencent.mobileqq.icgame.data.room.LiveInfo;
import com.tencent.mobileqq.icgame.framework.component.b;
import com.tencent.mobileqq.icgame.framework.interfaceService.InjectService;
import com.tencent.mobileqq.qqlive.callback.gift.OnQueryGiftIconCallback;
import com.tencent.mobileqq.qqlive.data.room.LiveAnchorInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.qphone.base.util.QLog;
import cooperation.vip.tianshu.TianShuMMKVConstant;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \r2\u00020\u0001:\u0002$%B\u000f\u0012\u0006\u0010!\u001a\u00020 \u00a2\u0006\u0004\b\"\u0010#J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0002J\u001a\u0010\u000b\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0002J\b\u0010\f\u001a\u00020\u0005H\u0016J\b\u0010\r\u001a\u00020\u0005H\u0016J\u0018\u0010\u0011\u001a\u00020\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0010\u001a\u00020\u0002R\u0016\u0010\u0013\u001a\u00020\u00128\u0002@\u0002X\u0083.\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010\u001f\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001e\u00a8\u0006&"}, d2 = {"Ljx0/a;", "Lcom/tencent/mobileqq/icgame/framework/component/b;", "", TianShuMMKVConstant.LicenseInfoKey.CAN_SHOW, "isSpecialAnchor", "", "p", "", "code", "", "msg", "o", "k", "i", "Lcom/tencent/mobileqq/qqlive/callback/gift/OnQueryGiftIconCallback;", "callback", "isForce", DomainData.DOMAIN_NAME, "Lh22/a;", "qqLiveRoomService", "Lh22/a;", "", "e", "Ljava/util/List;", "callbackList", "Ljx0/a$b;", "f", "Ljx0/a$b;", "verifyResult", h.F, "Z", "isStartRequest", "Lf32/a;", "componentContext", "<init>", "(Lf32/a;)V", "a", "b", "ic-game-timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes7.dex */
public final class a extends b {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<OnQueryGiftIconCallback> callbackList;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private VerifyResult verifyResult;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private volatile boolean isStartRequest;

    @InjectService(key = h22.a.class)
    private h22.a qqLiveRoomService;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\f\u001a\u00020\u0007\u0012\u0006\u0010\u000e\u001a\u00020\u0007\u00a2\u0006\u0004\b\u000f\u0010\u0010J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\f\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\t\u0010\u000bR\u0017\u0010\u000e\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\n\u001a\u0004\b\r\u0010\u000b\u00a8\u0006\u0011"}, d2 = {"Ljx0/a$b;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Z", "()Z", TianShuMMKVConstant.LicenseInfoKey.CAN_SHOW, "b", "isSpecialAnchor", "<init>", "(ZZ)V", "ic-game-timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: jx0.a$b, reason: from toString */
    /* loaded from: classes7.dex */
    public static final /* data */ class VerifyResult {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        private final boolean canShow;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        private final boolean isSpecialAnchor;

        public VerifyResult(boolean z16, boolean z17) {
            this.canShow = z16;
            this.isSpecialAnchor = z17;
        }

        /* renamed from: a, reason: from getter */
        public final boolean getCanShow() {
            return this.canShow;
        }

        /* renamed from: b, reason: from getter */
        public final boolean getIsSpecialAnchor() {
            return this.isSpecialAnchor;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof VerifyResult)) {
                return false;
            }
            VerifyResult verifyResult = (VerifyResult) other;
            if (this.canShow == verifyResult.canShow && this.isSpecialAnchor == verifyResult.isSpecialAnchor) {
                return true;
            }
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v1, types: [int] */
        /* JADX WARN: Type inference failed for: r0v4 */
        /* JADX WARN: Type inference failed for: r0v5 */
        public int hashCode() {
            boolean z16 = this.canShow;
            int i3 = 1;
            ?? r06 = z16;
            if (z16) {
                r06 = 1;
            }
            int i16 = r06 * 31;
            boolean z17 = this.isSpecialAnchor;
            if (!z17) {
                i3 = z17 ? 1 : 0;
            }
            return i16 + i3;
        }

        @NotNull
        public String toString() {
            return "VerifyResult(canShow=" + this.canShow + ", isSpecialAnchor=" + this.isSpecialAnchor + ")";
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016J\u001a\u0010\u000b\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016\u00a8\u0006\f"}, d2 = {"jx0/a$c", "Lcom/tencent/mobileqq/qqlive/callback/gift/OnQueryGiftIconCallback;", "", TianShuMMKVConstant.LicenseInfoKey.CAN_SHOW, "isSpecialAnchor", "", "onSuccess", "", "code", "", "msg", "onFailed", "ic-game-timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes7.dex */
    public static final class c implements OnQueryGiftIconCallback {
        c() {
        }

        @Override // com.tencent.mobileqq.qqlive.callback.gift.OnQueryGiftIconCallback
        public void onFailed(int code, @Nullable String msg2) {
            a.this.o(code, msg2);
        }

        @Override // com.tencent.mobileqq.qqlive.callback.gift.OnQueryGiftIconCallback
        public void onSuccess(boolean canShow, boolean isSpecialAnchor) {
            a.this.p(canShow, isSpecialAnchor);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(@NotNull f32.a componentContext) {
        super(componentContext);
        Intrinsics.checkNotNullParameter(componentContext, "componentContext");
        this.callbackList = new ArrayList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void o(int code, String msg2) {
        synchronized (this) {
            QLog.e("ICGameVerifyGiftComponent", 1, "OnQueryGiftIconCallback#onFailed: " + code + " " + msg2);
            Iterator<T> it = this.callbackList.iterator();
            while (it.hasNext()) {
                ((OnQueryGiftIconCallback) it.next()).onFailed(code, msg2);
            }
            this.callbackList.clear();
            this.isStartRequest = false;
            Unit unit = Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void p(boolean canShow, boolean isSpecialAnchor) {
        synchronized (this) {
            this.verifyResult = new VerifyResult(canShow, isSpecialAnchor);
            QLog.i("ICGameVerifyGiftComponent", 1, "OnQueryGiftIconCallback#onSuccess: " + canShow);
            Iterator<T> it = this.callbackList.iterator();
            while (it.hasNext()) {
                ((OnQueryGiftIconCallback) it.next()).onSuccess(canShow, isSpecialAnchor);
            }
            this.callbackList.clear();
            this.isStartRequest = false;
            Unit unit = Unit.INSTANCE;
        }
    }

    @Override // com.tencent.mobileqq.icgame.framework.component.e
    public void i() {
        synchronized (this) {
            this.callbackList.clear();
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void n(@Nullable OnQueryGiftIconCallback callback, boolean isForce) {
        long j3;
        LiveAnchorInfo liveAnchorInfo;
        VerifyResult verifyResult;
        if (!isForce && (verifyResult = this.verifyResult) != null) {
            QLog.w("ICGameVerifyGiftComponent", 1, "\u5df2\u8bf7\u6c42\u8fc7\u6570\u636e,\u76f4\u63a5\u8fd4\u56de");
            if (callback != null) {
                callback.onSuccess(verifyResult.getCanShow(), verifyResult.getIsSpecialAnchor());
                return;
            }
            return;
        }
        h22.a aVar = null;
        this.verifyResult = null;
        h22.a aVar2 = this.qqLiveRoomService;
        if (aVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("qqLiveRoomService");
            aVar2 = null;
        }
        LiveRoomExtraInfo extraInfo = aVar2.getExtraInfo();
        h22.a aVar3 = this.qqLiveRoomService;
        if (aVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("qqLiveRoomService");
        } else {
            aVar = aVar3;
        }
        LiveInfo curLiveInfo = aVar.getCurLiveInfo();
        if (curLiveInfo != null && (liveAnchorInfo = curLiveInfo.anchorInfo) != null) {
            j3 = liveAnchorInfo.getAnchorUid();
        } else {
            j3 = 0;
        }
        synchronized (this) {
            if (callback != null) {
                try {
                    this.callbackList.add(callback);
                } catch (Throwable th5) {
                    throw th5;
                }
            }
            if (j3 == 0) {
                QLog.w("ICGameVerifyGiftComponent", 1, "anchorUid == 0");
                return;
            }
            if (extraInfo == null) {
                QLog.w("ICGameVerifyGiftComponent", 1, "roomExtraInfo == null,\u8bf7\u68c0\u67e5\u6570\u636e!");
                return;
            }
            if (this.isStartRequest) {
                return;
            }
            this.isStartRequest = true;
            Unit unit = Unit.INSTANCE;
            IQQLiveSDK sDKImpl = ((IQQLiveSDKManager) QRoute.api(IQQLiveSDKManager.class)).getSDKImpl(QQLiveSDKConfigHelper.getQQLiveAppId());
            if (sDKImpl.isInited() && !sDKImpl.isDestroyed()) {
                sDKImpl.getGiftEntranceService().needShowGiftIcon(extraInfo.f114880d, new c());
            } else {
                o(-1, "SDK\u672a\u521d\u59cb\u5316");
            }
        }
    }

    @Override // com.tencent.mobileqq.icgame.framework.component.e
    public void k() {
    }
}
