package nn3;

import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ln3.a;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0001\u0011B\u0007\u00a2\u0006\u0004\b\u0014\u0010\u0015J\"\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002J\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0016\u0010\u000e\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006R\u001c\u0010\u0013\u001a\n \u0010*\u0004\u0018\u00010\u000f0\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0016"}, d2 = {"Lnn3/b;", "", "", "roomId", "", "needDetail", "Lnn3/b$a;", "callback", "", "d", "Ljr4/b;", "gameInfoRsp", "Lnn3/c;", "c", "e", "Lorg/slf4j/Logger;", "kotlin.jvm.PlatformType", "a", "Lorg/slf4j/Logger;", "logger", "<init>", "()V", "qq-live-od-logic-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes22.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final Logger logger = LoggerFactory.getLogger("GameDataModel");

    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&J\u001a\u0010\f\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH&\u00a8\u0006\r"}, d2 = {"Lnn3/b$a;", "", "", "gameDetail", "Lnn3/c;", "gameExtraInfo", "", "a", "", "errCode", "", "errMsg", "onFailed", "qq-live-od-logic-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes22.dex */
    public interface a {
        void a(@Nullable byte[] gameDetail, @NotNull GameExtraInfo gameExtraInfo);

        void onFailed(int errCode, @Nullable String errMsg);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000b"}, d2 = {"nn3/b$b", "Lln3/a$a;", "", "data", "", "onReceive", "", "errCode", "", "errMsg", "onFail", "qq-live-od-logic-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: nn3.b$b, reason: collision with other inner class name */
    /* loaded from: classes22.dex */
    public static final class C10854b implements a.InterfaceC10739a {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ a f420540b;

        C10854b(a aVar) {
            this.f420540b = aVar;
        }

        @Override // ln3.a.InterfaceC10739a
        public void onFail(int errCode, @Nullable String errMsg) {
            b.this.logger.error("fetchGameData->errCode:" + errCode + ",errMsg:" + errMsg);
            a aVar = this.f420540b;
            if (aVar != null) {
                aVar.onFailed(errCode, errMsg);
            }
        }

        @Override // ln3.a.InterfaceC10739a
        public void onReceive(@Nullable byte[] data) {
            if (data == null) {
                b.this.logger.error("fetchGameData->data is null");
                a aVar = this.f420540b;
                if (aVar != null) {
                    aVar.onFailed(0, "data is null");
                    return;
                }
                return;
            }
            try {
                jr4.b gameInfoRsp = jr4.b.c(data);
                b.this.logger.info("fetchGameData success");
                a aVar2 = this.f420540b;
                if (aVar2 != null) {
                    byte[] bArr = gameInfoRsp.f410882c;
                    b bVar = b.this;
                    Intrinsics.checkNotNullExpressionValue(gameInfoRsp, "gameInfoRsp");
                    aVar2.a(bArr, bVar.c(gameInfoRsp));
                }
            } catch (InvalidProtocolBufferNanoException e16) {
                b.this.logger.error("fetchGameData->parse pb fail ", (Throwable) e16);
                a aVar3 = this.f420540b;
                if (aVar3 != null) {
                    aVar3.onFailed(0, "parse pb fail ");
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final GameExtraInfo c(jr4.b gameInfoRsp) {
        return new GameExtraInfo(gameInfoRsp.f410880a, gameInfoRsp.f410881b, gameInfoRsp.f410884e, gameInfoRsp.f410887h, gameInfoRsp.f410885f, gameInfoRsp.f410886g);
    }

    private final void d(long roomId, boolean needDetail, a callback) {
        this.logger.info("fetchGameData->roomId:" + roomId + ",needDetail:" + needDetail);
        jr4.a aVar = new jr4.a();
        aVar.f410878a = roomId;
        aVar.f410879b = needDetail;
        ln3.a a16 = kn3.a.INSTANCE.a();
        byte[] byteArray = MessageNano.toByteArray(aVar);
        Intrinsics.checkNotNullExpressionValue(byteArray, "toByteArray(req)");
        a16.a(byteArray, new C10854b(callback));
    }

    public final void e(long roomId, @NotNull a callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        d(roomId, true, callback);
    }
}
