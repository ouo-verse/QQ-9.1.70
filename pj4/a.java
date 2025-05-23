package pj4;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.tencent.gdtad.jsbridge.GdtGetUserInfoHandler;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.transfile.predownload.schedule.PreDownloadConstants;
import com.tencent.qqmini.sdk.launcher.core.proxy.va.VirtualAppProxy;
import com.tencent.timi.game.utils.IResultListener;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import trpc.yes.common.GameDataServerOuterClass$GetAnchorGameRoleListRsp;
import trpc.yes.common.GameDataServerOuterClass$SetAnchorGameEquipRoleRsp;

/* compiled from: P */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0015\u001a\u00020\u0012\u0012\u0006\u0010\u0017\u001a\u00020\u0002\u0012\u0006\u0010\u001a\u001a\u00020\u0018\u0012\u0006\u0010\u001b\u001a\u00020\u0018\u00a2\u0006\u0004\b \u0010!J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\t\u001a\u00020\u00042\u0010\u0010\b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u0006J0\u0010\u000e\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u00022\u0010\u0010\b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\r\u0018\u00010\u0006J\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fR\u0014\u0010\u0015\u001a\u00020\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0017\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0016R\u0014\u0010\u001a\u001a\u00020\u00188\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0019R\u0014\u0010\u001b\u001a\u00020\u00188\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u0019R\u0016\u0010\f\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0016R\u001a\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00100\u001c8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001e\u00a8\u0006\""}, d2 = {"Lpj4/a;", "", "", "status", "", "e", "Lcom/tencent/timi/game/utils/IResultListener;", "Ltrpc/yes/common/GameDataServerOuterClass$GetAnchorGameRoleListRsp;", "cb", "c", GdtGetUserInfoHandler.KEY_AREA, "partition", "equipStatus", "Ltrpc/yes/common/GameDataServerOuterClass$SetAnchorGameEquipRoleRsp;", "d", "Landroidx/lifecycle/LiveData;", "", "b", "", "a", "Ljava/lang/String;", PreDownloadConstants.RPORT_KEY_BUSINESS_ID, "I", VirtualAppProxy.KEY_GAME_ID, "", "J", "userId", "roomId", "Landroidx/lifecycle/MutableLiveData;", "f", "Landroidx/lifecycle/MutableLiveData;", "equipStatusLiveData", "<init>", "(Ljava/lang/String;IJJ)V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String businessID;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final int gameId;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final long userId;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final long roomId;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private int equipStatus;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final MutableLiveData<Boolean> equipStatusLiveData;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000b"}, d2 = {"pj4/a$a", "Lcom/tencent/timi/game/utils/IResultListener;", "Ltrpc/yes/common/GameDataServerOuterClass$GetAnchorGameRoleListRsp;", "result", "", "a", "", "errorCode", "", "errorMessage", "onError", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: pj4.a$a, reason: collision with other inner class name */
    /* loaded from: classes26.dex */
    public static final class C11023a implements IResultListener<GameDataServerOuterClass$GetAnchorGameRoleListRsp> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ IResultListener<GameDataServerOuterClass$GetAnchorGameRoleListRsp> f426347a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ a f426348b;

        C11023a(IResultListener<GameDataServerOuterClass$GetAnchorGameRoleListRsp> iResultListener, a aVar) {
            this.f426347a = iResultListener;
            this.f426348b = aVar;
        }

        @Override // com.tencent.timi.game.utils.IResultListener
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onSuccess(@Nullable GameDataServerOuterClass$GetAnchorGameRoleListRsp result) {
            PBInt32Field pBInt32Field;
            if (result != null && (pBInt32Field = result.equip_status) != null) {
                this.f426348b.e(Integer.valueOf(pBInt32Field.get()).intValue());
            }
            IResultListener<GameDataServerOuterClass$GetAnchorGameRoleListRsp> iResultListener = this.f426347a;
            if (iResultListener != null) {
                iResultListener.onSuccess(result);
            }
        }

        @Override // com.tencent.timi.game.utils.IResultListener
        public void onError(int errorCode, @Nullable String errorMessage) {
            IResultListener<GameDataServerOuterClass$GetAnchorGameRoleListRsp> iResultListener = this.f426347a;
            if (iResultListener != null) {
                iResultListener.onError(errorCode, errorMessage);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000b"}, d2 = {"pj4/a$b", "Lcom/tencent/timi/game/utils/IResultListener;", "Ltrpc/yes/common/GameDataServerOuterClass$SetAnchorGameEquipRoleRsp;", "result", "", "a", "", "errorCode", "", "errorMessage", "onError", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class b implements IResultListener<GameDataServerOuterClass$SetAnchorGameEquipRoleRsp> {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f426350b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ IResultListener<GameDataServerOuterClass$SetAnchorGameEquipRoleRsp> f426351c;

        b(int i3, IResultListener<GameDataServerOuterClass$SetAnchorGameEquipRoleRsp> iResultListener) {
            this.f426350b = i3;
            this.f426351c = iResultListener;
        }

        @Override // com.tencent.timi.game.utils.IResultListener
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onSuccess(@Nullable GameDataServerOuterClass$SetAnchorGameEquipRoleRsp result) {
            a.this.e(this.f426350b);
            IResultListener<GameDataServerOuterClass$SetAnchorGameEquipRoleRsp> iResultListener = this.f426351c;
            if (iResultListener != null) {
                iResultListener.onSuccess(result);
            }
        }

        @Override // com.tencent.timi.game.utils.IResultListener
        public void onError(int errorCode, @Nullable String errorMessage) {
            IResultListener<GameDataServerOuterClass$SetAnchorGameEquipRoleRsp> iResultListener = this.f426351c;
            if (iResultListener != null) {
                iResultListener.onError(errorCode, errorMessage);
            }
        }
    }

    public a(@NotNull String businessID, int i3, long j3, long j16) {
        Intrinsics.checkNotNullParameter(businessID, "businessID");
        this.businessID = businessID;
        this.gameId = i3;
        this.userId = j3;
        this.roomId = j16;
        this.equipStatusLiveData = new MutableLiveData<>(Boolean.FALSE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void e(int status) {
        this.equipStatus = status;
        MutableLiveData<Boolean> mutableLiveData = this.equipStatusLiveData;
        boolean z16 = true;
        if (status != 1) {
            z16 = false;
        }
        mutableLiveData.postValue(Boolean.valueOf(z16));
    }

    @NotNull
    public final LiveData<Boolean> b() {
        return this.equipStatusLiveData;
    }

    public final void c(@Nullable IResultListener<GameDataServerOuterClass$GetAnchorGameRoleListRsp> cb5) {
        com.tencent.timi.game.liveroom.impl.room.inscription.net.a.f377859a.a(this.roomId, this.businessID, this.gameId, this.userId, new C11023a(cb5, this));
    }

    public final void d(int area, int partition, int equipStatus, @Nullable IResultListener<GameDataServerOuterClass$SetAnchorGameEquipRoleRsp> cb5) {
        com.tencent.timi.game.liveroom.impl.room.inscription.net.b.f377861a.a(this.businessID, area, partition, equipStatus, this.userId, this.roomId, new b(equipStatus, cb5));
    }
}
