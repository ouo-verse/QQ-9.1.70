package hl2;

import com.qwallet.protocol.Wallet.pb.pet.PetGlobalConfig$GetReq;
import com.qwallet.protocol.Wallet.pb.pet.PetGlobalConfig$GetRsp;
import com.qwallet.protocol.Wallet.pb.pet.PetRank$GenArkTokenReq;
import com.qwallet.protocol.Wallet.pb.pet.PetRank$GenArkTokenRsp;
import com.qwallet.protocol.Wallet.pb.pet.PetSsoGateway$SsoLcPetReq;
import com.qwallet.protocol.Wallet.pb.pet.PetSsoGateway$SsoLcPetRsp;
import com.qwallet.protocol.Wallet.pb.pet.PetUserState$HomepageReq;
import com.qwallet.protocol.Wallet.pb.pet.PetUserState$HomepageRsp;
import com.tencent.gdtad.json.GdtJsonPbUtil;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qwallet.utils.g;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.rewardad.utils.QAdRewardDefine$VideoParams;
import com.tencent.mobileqq.utils.fh;
import com.tencent.qphone.base.util.QLog;
import hl2.c;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;
import org.apache.httpcore.message.TokenParser;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;
import pl2.o;
import pl2.p;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0014\u0010\u0015J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0002H\u0002J@\u0010\u000e\u001a\u00020\u000528\u0010\r\u001a4\u0012\u0013\u0012\u00110\b\u00a2\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0015\u0012\u0013\u0018\u00010\f\u00a2\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u0004\u0012\u0004\u0012\u00020\u00050\u0007J@\u0010\u0011\u001a\u00020\u000528\u0010\r\u001a4\u0012\u0013\u0012\u00110\u000f\u00a2\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u0010\u0012\u0015\u0012\u0013\u0018\u00010\u0002\u00a2\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u0004\u0012\u0004\u0012\u00020\u00050\u0007J@\u0010\u0013\u001a\u00020\u000528\u0010\r\u001a4\u0012\u0013\u0012\u00110\b\u00a2\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0015\u0012\u0013\u0018\u00010\u0012\u00a2\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u0004\u0012\u0004\u0012\u00020\u00050\u0007\u00a8\u0006\u0016"}, d2 = {"Lhl2/a;", "", "Lcom/qwallet/protocol/Wallet/pb/pet/PetGlobalConfig$GetRsp;", "e", "rsp", "", "f", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "retCode", "Lcom/qwallet/protocol/Wallet/pb/pet/PetUserState$HomepageRsp;", "callback", "d", "", QAdRewardDefine$VideoParams.ISCACHE, "c", "Lcom/qwallet/protocol/Wallet/pb/pet/PetRank$GenArkTokenRsp;", "b", "<init>", "()V", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f405243a = new a();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\u000b"}, d2 = {"hl2/a$a", "Lpl2/o;", "Lcom/qwallet/protocol/Wallet/pb/pet/PetSsoGateway$SsoLcPetRsp;", "rsp", "", "a", "", "errCode", "", "errMsg", "onFail", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: hl2.a$a, reason: collision with other inner class name */
    /* loaded from: classes16.dex */
    public static final class C10450a implements o<PetSsoGateway$SsoLcPetRsp> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ c.b f405244a;

        public C10450a(c.b bVar) {
            this.f405244a = bVar;
        }

        @Override // pl2.k
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onSuccess(@NotNull PetSsoGateway$SsoLcPetRsp rsp) {
            Intrinsics.checkNotNullParameter(rsp, "rsp");
            long j3 = rsp.retcode.get();
            if (j3 == 0) {
                try {
                    MessageMicro realRsp = ((MessageMicro) PetRank$GenArkTokenRsp.class.newInstance()).mergeFrom(rsp.data.get().toByteArray());
                    c.b bVar = this.f405244a;
                    Intrinsics.checkNotNullExpressionValue(realRsp, "realRsp");
                    bVar.onSuccess(realRsp);
                    return;
                } catch (InvalidProtocolBufferMicroException unused) {
                    this.f405244a.onFail(-2, "mergeFrom bytes array to " + PetRank$GenArkTokenRsp.class + " failed.");
                    return;
                }
            }
            String str = rsp.retmsg.get();
            Intrinsics.checkNotNullExpressionValue(str, "rsp.retmsg.get()");
            this.f405244a.onFail((int) j3, str);
        }

        @Override // pl2.k
        public void onFail(int errCode, @NotNull String errMsg) {
            Intrinsics.checkNotNullParameter(errMsg, "errMsg");
            this.f405244a.onFail(-1, errMsg);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\u000b"}, d2 = {"hl2/a$b", "Lhl2/c$b;", "Lcom/qwallet/protocol/Wallet/pb/pet/PetRank$GenArkTokenRsp;", "rsp", "", "a", "", "errCode", "", "errMsg", "onFail", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes16.dex */
    public static final class b implements c.b<PetRank$GenArkTokenRsp> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Function2<Integer, PetRank$GenArkTokenRsp, Unit> f405245a;

        /* JADX WARN: Multi-variable type inference failed */
        b(Function2<? super Integer, ? super PetRank$GenArkTokenRsp, Unit> function2) {
            this.f405245a = function2;
        }

        @Override // hl2.c.b
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onSuccess(@NotNull PetRank$GenArkTokenRsp rsp) {
            String str;
            String str2;
            Intrinsics.checkNotNullParameter(rsp, "rsp");
            PBStringField pBStringField = rsp.sign;
            String str3 = null;
            if (pBStringField != null) {
                str = pBStringField.get();
            } else {
                str = null;
            }
            PBStringField pBStringField2 = rsp.title;
            if (pBStringField2 != null) {
                str2 = pBStringField2.get();
            } else {
                str2 = null;
            }
            PBStringField pBStringField3 = rsp.cover_image;
            if (pBStringField3 != null) {
                str3 = pBStringField3.get();
            }
            QLog.d("QWallet.Pet.NetService", 2, "requestArkToken onSuccess,sign:" + str + ",title:" + str2 + ",cover_image:" + str3 + ",url:" + rsp.url.get());
            this.f405245a.invoke(0, rsp);
        }

        @Override // hl2.c.b
        public void onFail(int errCode, @NotNull String errMsg) {
            Intrinsics.checkNotNullParameter(errMsg, "errMsg");
            QLog.d("QWallet.Pet.NetService", 1, "onFail errCode:" + errCode + ",errMsg:" + errMsg);
            this.f405245a.invoke(Integer.valueOf(errCode), null);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\u000b"}, d2 = {"hl2/a$c", "Lpl2/o;", "Lcom/qwallet/protocol/Wallet/pb/pet/PetSsoGateway$SsoLcPetRsp;", "rsp", "", "a", "", "errCode", "", "errMsg", "onFail", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes16.dex */
    public static final class c implements o<PetSsoGateway$SsoLcPetRsp> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ c.b f405246a;

        public c(c.b bVar) {
            this.f405246a = bVar;
        }

        @Override // pl2.k
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onSuccess(@NotNull PetSsoGateway$SsoLcPetRsp rsp) {
            Intrinsics.checkNotNullParameter(rsp, "rsp");
            long j3 = rsp.retcode.get();
            if (j3 == 0) {
                try {
                    MessageMicro realRsp = ((MessageMicro) PetGlobalConfig$GetRsp.class.newInstance()).mergeFrom(rsp.data.get().toByteArray());
                    c.b bVar = this.f405246a;
                    Intrinsics.checkNotNullExpressionValue(realRsp, "realRsp");
                    bVar.onSuccess(realRsp);
                    return;
                } catch (InvalidProtocolBufferMicroException unused) {
                    this.f405246a.onFail(-2, "mergeFrom bytes array to " + PetGlobalConfig$GetRsp.class + " failed.");
                    return;
                }
            }
            String str = rsp.retmsg.get();
            Intrinsics.checkNotNullExpressionValue(str, "rsp.retmsg.get()");
            this.f405246a.onFail((int) j3, str);
        }

        @Override // pl2.k
        public void onFail(int errCode, @NotNull String errMsg) {
            Intrinsics.checkNotNullParameter(errMsg, "errMsg");
            this.f405246a.onFail(-1, errMsg);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\u000b"}, d2 = {"hl2/a$d", "Lhl2/c$b;", "Lcom/qwallet/protocol/Wallet/pb/pet/PetGlobalConfig$GetRsp;", "rsp", "", "a", "", "errCode", "", "errMsg", "onFail", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes16.dex */
    public static final class d implements c.b<PetGlobalConfig$GetRsp> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f405247a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Function2<Boolean, PetGlobalConfig$GetRsp, Unit> f405248b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ PetGlobalConfig$GetRsp f405249c;

        /* JADX WARN: Multi-variable type inference failed */
        d(String str, Function2<? super Boolean, ? super PetGlobalConfig$GetRsp, Unit> function2, PetGlobalConfig$GetRsp petGlobalConfig$GetRsp) {
            this.f405247a = str;
            this.f405248b = function2;
            this.f405249c = petGlobalConfig$GetRsp;
        }

        @Override // hl2.c.b
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onSuccess(@NotNull PetGlobalConfig$GetRsp rsp) {
            Intrinsics.checkNotNullParameter(rsp, "rsp");
            QLog.d("QWallet.Pet.NetService", 1, "requestPetGlobalConfig onSuccess: " + this.f405247a + " " + rsp.version.get());
            if (!Intrinsics.areEqual(this.f405247a, rsp.version.get())) {
                a.f405243a.f(rsp);
                this.f405248b.invoke(Boolean.FALSE, rsp);
            } else {
                this.f405248b.invoke(Boolean.FALSE, rsp);
            }
        }

        @Override // hl2.c.b
        public void onFail(int errCode, @NotNull String errMsg) {
            Intrinsics.checkNotNullParameter(errMsg, "errMsg");
            QLog.d("QWallet.Pet.NetService", 1, "requestPetGlobalConfig onFail: [" + errCode + ", " + errMsg + "]");
            this.f405248b.invoke(Boolean.TRUE, this.f405249c);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\u000b"}, d2 = {"hl2/a$e", "Lpl2/o;", "Lcom/qwallet/protocol/Wallet/pb/pet/PetSsoGateway$SsoLcPetRsp;", "rsp", "", "a", "", "errCode", "", "errMsg", "onFail", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes16.dex */
    public static final class e implements o<PetSsoGateway$SsoLcPetRsp> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ c.b f405250a;

        public e(c.b bVar) {
            this.f405250a = bVar;
        }

        @Override // pl2.k
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onSuccess(@NotNull PetSsoGateway$SsoLcPetRsp rsp) {
            Intrinsics.checkNotNullParameter(rsp, "rsp");
            long j3 = rsp.retcode.get();
            if (j3 == 0) {
                try {
                    MessageMicro realRsp = ((MessageMicro) PetUserState$HomepageRsp.class.newInstance()).mergeFrom(rsp.data.get().toByteArray());
                    c.b bVar = this.f405250a;
                    Intrinsics.checkNotNullExpressionValue(realRsp, "realRsp");
                    bVar.onSuccess(realRsp);
                    return;
                } catch (InvalidProtocolBufferMicroException unused) {
                    this.f405250a.onFail(-2, "mergeFrom bytes array to " + PetUserState$HomepageRsp.class + " failed.");
                    return;
                }
            }
            String str = rsp.retmsg.get();
            Intrinsics.checkNotNullExpressionValue(str, "rsp.retmsg.get()");
            this.f405250a.onFail((int) j3, str);
        }

        @Override // pl2.k
        public void onFail(int errCode, @NotNull String errMsg) {
            Intrinsics.checkNotNullParameter(errMsg, "errMsg");
            this.f405250a.onFail(-1, errMsg);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\u000b"}, d2 = {"hl2/a$f", "Lhl2/c$b;", "Lcom/qwallet/protocol/Wallet/pb/pet/PetUserState$HomepageRsp;", "rsp", "", "a", "", "errCode", "", "errMsg", "onFail", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes16.dex */
    public static final class f implements c.b<PetUserState$HomepageRsp> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Function2<Integer, PetUserState$HomepageRsp, Unit> f405251a;

        /* JADX WARN: Multi-variable type inference failed */
        f(Function2<? super Integer, ? super PetUserState$HomepageRsp, Unit> function2) {
            this.f405251a = function2;
        }

        @Override // hl2.c.b
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onSuccess(@NotNull PetUserState$HomepageRsp rsp) {
            Integer num;
            Intrinsics.checkNotNullParameter(rsp, "rsp");
            PBEnumField pBEnumField = rsp.user_type;
            String str = null;
            if (pBEnumField != null) {
                num = Integer.valueOf(pBEnumField.get());
            } else {
                num = null;
            }
            PBStringField pBStringField = rsp.pet_name;
            if (pBStringField != null) {
                str = pBStringField.get();
            }
            QLog.d("QWallet.Pet.NetService", 1, "requestPetUserState onSuccess:" + num + " " + str);
            this.f405251a.invoke(0, rsp);
        }

        @Override // hl2.c.b
        public void onFail(int errCode, @NotNull String errMsg) {
            Intrinsics.checkNotNullParameter(errMsg, "errMsg");
            QLog.d("QWallet.Pet.NetService", 1, "requestPetUserState onFail: [" + errCode + ", " + errMsg + "]");
            this.f405251a.invoke(Integer.valueOf(errCode), null);
        }
    }

    a() {
    }

    private final PetGlobalConfig$GetRsp e() {
        boolean z16;
        String i3 = g.i("qwallet_pet_global_config");
        if (i3.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            return null;
        }
        PBField pbFromJson = GdtJsonPbUtil.pbFromJson(new PetGlobalConfig$GetRsp(), new JSONObject(i3));
        if (!(pbFromJson instanceof PetGlobalConfig$GetRsp)) {
            return null;
        }
        return (PetGlobalConfig$GetRsp) pbFromJson;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void f(PetGlobalConfig$GetRsp rsp) {
        JSONObject jSONObject;
        Object pbToJson = GdtJsonPbUtil.pbToJson(rsp);
        if (pbToJson instanceof JSONObject) {
            jSONObject = (JSONObject) pbToJson;
        } else {
            jSONObject = null;
        }
        if (jSONObject == null) {
            QLog.w("QWallet.Pet.NetService", 1, "save fail, rspJSON is null");
            return;
        }
        QLog.d("QWallet.Pet.NetService", 2, "savePetGlobalConfig:\n" + jSONObject);
        String jSONObject2 = jSONObject.toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject2, "rspJson.toString()");
        g.q("qwallet_pet_global_config", jSONObject2);
    }

    public final void b(@NotNull Function2<? super Integer, ? super PetRank$GenArkTokenRsp, Unit> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        MessageMicro<PetRank$GenArkTokenReq> messageMicro = new MessageMicro<PetRank$GenArkTokenReq>() { // from class: com.qwallet.protocol.Wallet.pb.pet.PetRank$GenArkTokenReq
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], PetRank$GenArkTokenReq.class);
        };
        b bVar = new b(callback);
        c.Companion companion = hl2.c.INSTANCE;
        PetSsoGateway$SsoLcPetReq petSsoGateway$SsoLcPetReq = new PetSsoGateway$SsoLcPetReq();
        petSsoGateway$SsoLcPetReq.service.set("trpc.lcpet.rank.Rank");
        petSsoGateway$SsoLcPetReq.method.set("GenArkToken");
        petSsoGateway$SsoLcPetReq.data.set(ByteStringMicro.copyFrom(messageMicro.toByteArray()));
        p.Companion companion2 = p.INSTANCE;
        C10450a c10450a = new C10450a(bVar);
        QLog.i("QWalletHttp-QWalletPbServlet", 1, "send req: cmd=trpc.lcpet.gateway.Gateway.SsoLcPet callback: " + c10450a + TokenParser.SP);
        AppRuntime waitAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
        NewIntent newIntent = new NewIntent(waitAppRuntime.getApplication(), p.class);
        newIntent.putExtra("cmd", "trpc.lcpet.gateway.Gateway.SsoLcPet");
        newIntent.putExtra("data", fh.b(petSsoGateway$SsoLcPetReq.toByteArray()));
        newIntent.putExtra("timeout", 30000L);
        newIntent.setObserver(new hl2.b(c10450a));
        waitAppRuntime.startServlet(newIntent);
    }

    public final void c(@NotNull Function2<? super Boolean, ? super PetGlobalConfig$GetRsp, Unit> callback) {
        String str;
        PBStringField pBStringField;
        Intrinsics.checkNotNullParameter(callback, "callback");
        PetGlobalConfig$GetRsp e16 = e();
        if (e16 != null && (pBStringField = e16.version) != null) {
            str = pBStringField.get();
        } else {
            str = null;
        }
        if (str == null) {
            str = "";
        }
        PetGlobalConfig$GetReq petGlobalConfig$GetReq = new PetGlobalConfig$GetReq();
        petGlobalConfig$GetReq.version.set(str);
        d dVar = new d(str, callback, e16);
        c.Companion companion = hl2.c.INSTANCE;
        PetSsoGateway$SsoLcPetReq petSsoGateway$SsoLcPetReq = new PetSsoGateway$SsoLcPetReq();
        petSsoGateway$SsoLcPetReq.service.set("trpc.lcpet.globalconfig.Globalconfig");
        petSsoGateway$SsoLcPetReq.method.set("Get");
        petSsoGateway$SsoLcPetReq.data.set(ByteStringMicro.copyFrom(petGlobalConfig$GetReq.toByteArray()));
        p.Companion companion2 = p.INSTANCE;
        c cVar = new c(dVar);
        QLog.i("QWalletHttp-QWalletPbServlet", 1, "send req: cmd=trpc.lcpet.gateway.Gateway.SsoLcPet callback: " + cVar + TokenParser.SP);
        AppRuntime waitAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
        NewIntent newIntent = new NewIntent(waitAppRuntime.getApplication(), p.class);
        newIntent.putExtra("cmd", "trpc.lcpet.gateway.Gateway.SsoLcPet");
        newIntent.putExtra("data", fh.b(petSsoGateway$SsoLcPetReq.toByteArray()));
        newIntent.putExtra("timeout", 30000L);
        newIntent.setObserver(new hl2.b(cVar));
        waitAppRuntime.startServlet(newIntent);
    }

    public final void d(@NotNull Function2<? super Integer, ? super PetUserState$HomepageRsp, Unit> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        PetUserState$HomepageReq petUserState$HomepageReq = new PetUserState$HomepageReq();
        petUserState$HomepageReq.device_info.set(il2.a.INSTANCE.a());
        petUserState$HomepageReq.qry_flag.set(1);
        f fVar = new f(callback);
        c.Companion companion = hl2.c.INSTANCE;
        PetSsoGateway$SsoLcPetReq petSsoGateway$SsoLcPetReq = new PetSsoGateway$SsoLcPetReq();
        petSsoGateway$SsoLcPetReq.service.set("trpc.lcpet.middle.Middle");
        petSsoGateway$SsoLcPetReq.method.set("Homepage");
        petSsoGateway$SsoLcPetReq.data.set(ByteStringMicro.copyFrom(petUserState$HomepageReq.toByteArray()));
        p.Companion companion2 = p.INSTANCE;
        e eVar = new e(fVar);
        QLog.i("QWalletHttp-QWalletPbServlet", 1, "send req: cmd=trpc.lcpet.gateway.Gateway.SsoLcPet callback: " + eVar + TokenParser.SP);
        AppRuntime waitAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
        NewIntent newIntent = new NewIntent(waitAppRuntime.getApplication(), p.class);
        newIntent.putExtra("cmd", "trpc.lcpet.gateway.Gateway.SsoLcPet");
        newIntent.putExtra("data", fh.b(petSsoGateway$SsoLcPetReq.toByteArray()));
        newIntent.putExtra("timeout", 30000L);
        newIntent.setObserver(new hl2.b(eVar));
        waitAppRuntime.startServlet(newIntent);
    }
}
