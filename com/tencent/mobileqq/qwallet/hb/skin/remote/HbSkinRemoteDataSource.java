package com.tencent.mobileqq.qwallet.hb.skin.remote;

import android.os.Bundle;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.qwallet.IQWalletPreferenceApi;
import com.tencent.mobileqq.qwallet.hb.skin.HbSkinData;
import com.tencent.mobileqq.qwallet.hb.skin.remote.HbSkinRemoteDataSource;
import com.tencent.mobileqq.qwallet.pb.RedPackSkin$GetSkinInfoReq;
import com.tencent.mobileqq.qwallet.pb.RedPackSkin$GetSkinInfoRsp;
import com.tencent.mobileqq.qwallet.pb.RedPackSkin$GetUserSkinReq;
import com.tencent.mobileqq.qwallet.pb.RedPackSkin$GetUserSkinRsp;
import com.tencent.mobileqq.qwallet.pb.RedPackSkin$SetSelectedSkinReq;
import com.tencent.mobileqq.qwallet.pb.RedPackSkin$SetSelectedSkinRsp;
import com.tencent.mobileqq.qwallet.pb.RedPackSkin$SkinInfo;
import com.tencent.mobileqq.qwallet.pb.RedPackSkin$Story;
import com.tencent.mobileqq.qwallet.pb.RedPackSkin$Tail;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.utils.fh;
import com.tencent.qphone.base.util.QLog;
import com.tencent.xweb.FileReaderHelper;
import cooperation.qzone.QzoneIPCModule;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;
import mqq.observer.BusinessObserver;
import org.apache.httpcore.message.TokenParser;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import pl2.o;
import pl2.p;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u008a\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001AB\t\b\u0002\u00a2\u0006\u0004\b?\u0010@J\b\u0010\u0003\u001a\u00020\u0002H\u0002J`\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\b\u001a\u00020\u000428\u0010\u0010\u001a4\u0012\u0013\u0012\u00110\n\u00a2\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0015\u0012\u0013\u0018\u00010\u000e\u00a2\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u00020\tH\u0002J\u0012\u0010\u0015\u001a\u00020\u00142\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0002J*\u0010\u001c\u001a\u0012\u0012\u0004\u0012\u00020\u001a0\u0019j\b\u0012\u0004\u0012\u00020\u001a`\u001b2\u0010\u0010\u0018\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0017\u0018\u00010\u0016H\u0002J\u000e\u0010\u001e\u001a\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u0006J^\u0010\u001f\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\b\u001a\u00020\u000428\u0010\u0010\u001a4\u0012\u0013\u0012\u00110\n\u00a2\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0015\u0012\u0013\u0018\u00010\u000e\u00a2\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u00020\tJ\u001e\u0010$\u001a\u00020\u00022\b\u0010 \u001a\u0004\u0018\u00010\u00062\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\"0!J\u001e\u0010%\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0004Jg\u0010*\u001a\u00020\u00022\b\b\u0002\u0010'\u001a\u00020&2U\u0010\u0010\u001aQ\u0012\u0013\u0012\u00110\n\u00a2\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0015\u0012\u0013\u0018\u00010\u0006\u00a2\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u001d\u0012\u001b\u0012\u0019\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u0016\u00a2\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b()\u0012\u0004\u0012\u00020\u00020(J\u0095\u0001\u0010.\u001a\u00020\u00022\b\b\u0002\u0010+\u001a\u00020\u00062\u0010\b\u0002\u0010,\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00162\u0010\b\u0002\u0010-\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00162\b\b\u0002\u0010\b\u001a\u00020\u00042U\u0010\u0010\u001aQ\u0012\u0013\u0012\u00110\n\u00a2\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0015\u0012\u0013\u0018\u00010\u0006\u00a2\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u001d\u0012\u001b\u0012\u0019\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u0016\u00a2\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b()\u0012\u0004\u0012\u00020\u00020(J\u001e\u00103\u001a\u00020\u000e2\u0006\u00100\u001a\u00020/2\u0006\u0010\u001d\u001a\u00020\u00062\u0006\u00102\u001a\u000201R\u0016\u00106\u001a\u0002048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b3\u00105R\u0014\u00109\u001a\u00020\u00068BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b7\u00108R\u0014\u0010;\u001a\u00020\u00068BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b:\u00108R\u0014\u0010>\u001a\u0002018BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b<\u0010=\u00a8\u0006B"}, d2 = {"Lcom/tencent/mobileqq/qwallet/hb/skin/remote/HbSkinRemoteDataSource;", "", "", "p", "", "skinId", "", "outerSkinId", "skinFrom", "Lkotlin/Function2;", "Lcom/tencent/mobileqq/qwallet/hb/skin/remote/HbSkinRemoteDataSource$ResultCode;", "Lkotlin/ParameterName;", "name", QzoneIPCModule.RESULT_CODE, "Lcom/tencent/mobileqq/qwallet/hb/skin/HbSkinData;", "skinData", "receiver", "k", "Lcom/tencent/mobileqq/qwallet/pb/RedPackSkin$Tail;", "tailInfo", "Lcom/tencent/mobileqq/qwallet/hb/skin/HbSkinData$Tail;", "c", "", "Lcom/tencent/mobileqq/qwallet/pb/RedPackSkin$Story;", "storyInfoList", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/qwallet/hb/skin/HbSkinData$StoryRes;", "Lkotlin/collections/ArrayList;", "d", "remoteVersion", "o", "i", "recvType", "Lpl2/o;", "Lcom/tencent/mobileqq/qwallet/pb/RedPackSkin$GetUserSkinRsp;", "callback", "j", DomainData.DOMAIN_NAME, "", FileReaderHelper.OPEN_FILE_FROM_FORCE, "Lkotlin/Function3;", IQWalletPreferenceApi.KEY_SKIN_LIST, "e", "version", "skinIdList", "outSkinIdList", "l", "Lcom/tencent/mobileqq/qwallet/pb/RedPackSkin$SkinInfo;", "skinInfo", "", "expireTimeMs", "b", "Ljava/util/concurrent/atomic/AtomicInteger;", "Ljava/util/concurrent/atomic/AtomicInteger;", "state", "f", "()Ljava/lang/String;", "localVersion", h.F, "qqVersion", "g", "()J", "nextPeriodTime", "<init>", "()V", "ResultCode", "qqpay-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class HbSkinRemoteDataSource {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final HbSkinRemoteDataSource f277873a = new HbSkinRemoteDataSource();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static AtomicInteger state = new AtomicInteger();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/qwallet/hb/skin/remote/HbSkinRemoteDataSource$ResultCode;", "", "(Ljava/lang/String;I)V", "SUCCESS", "FAILED", "NOT_UPDATE", "UPDATING", "FREQUENCY_LIMIT", "qqpay-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes16.dex */
    public enum ResultCode {
        SUCCESS,
        FAILED,
        NOT_UPDATE,
        UPDATING,
        FREQUENCY_LIMIT
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\r\u001a\u00020\n\"\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000\u0000\"\u0010\b\u0001\u0010\u0002\u0018\u0001*\b\u0012\u0004\u0012\u00028\u00010\u00002\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u000e\u0010\t\u001a\n \b*\u0004\u0018\u00010\u00070\u0007H\n\u00a2\u0006\u0004\b\u000b\u0010\f"}, d2 = {"Lcom/tencent/mobileqq/pb/MessageMicro;", "Req", "Rsp", "", "<anonymous parameter 0>", "", "isSuccess", "Landroid/os/Bundle;", "kotlin.jvm.PlatformType", "bundle", "", "onReceive", "(IZLandroid/os/Bundle;)V", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    /* loaded from: classes16.dex */
    public static final class a implements BusinessObserver {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ o f277875d;

        public a(o oVar) {
            this.f277875d = oVar;
        }

        @Override // mqq.observer.BusinessObserver
        public final void onReceive(int i3, boolean z16, Bundle bundle) {
            int i16;
            String str;
            if (bundle != null) {
                i16 = bundle.getInt("rsp_code");
            } else {
                i16 = 1001;
            }
            if (bundle != null) {
                str = bundle.getString("rsp_msg");
            } else {
                str = null;
            }
            if (z16) {
                try {
                    MessageMicro rsp = ((MessageMicro) RedPackSkin$GetUserSkinRsp.class.newInstance()).mergeFrom(bundle.getByteArray("rsp_bytes"));
                    o oVar = this.f277875d;
                    if (oVar != null) {
                        Intrinsics.checkNotNullExpressionValue(rsp, "rsp");
                        oVar.onSuccess((o) rsp);
                        return;
                    }
                    return;
                } catch (Exception unused) {
                    QLog.e("QWalletHttp-QWalletPbServlet", 1, "mergeFrom bytes array to " + RedPackSkin$GetUserSkinRsp.class + " failed.");
                    o oVar2 = this.f277875d;
                    if (oVar2 != null) {
                        oVar2.onFail(i16, p.INSTANCE.a());
                        return;
                    }
                    return;
                }
            }
            o oVar3 = this.f277875d;
            if (oVar3 != null) {
                if (str == null) {
                    str = "empty bundle";
                }
                oVar3.onFail(i16, str);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\r\u001a\u00020\n\"\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000\u0000\"\u0010\b\u0001\u0010\u0002\u0018\u0001*\b\u0012\u0004\u0012\u00028\u00010\u00002\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u000e\u0010\t\u001a\n \b*\u0004\u0018\u00010\u00070\u0007H\n\u00a2\u0006\u0004\b\u000b\u0010\f"}, d2 = {"Lcom/tencent/mobileqq/pb/MessageMicro;", "Req", "Rsp", "", "<anonymous parameter 0>", "", "isSuccess", "Landroid/os/Bundle;", "kotlin.jvm.PlatformType", "bundle", "", "onReceive", "(IZLandroid/os/Bundle;)V", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    /* loaded from: classes16.dex */
    public static final class b implements BusinessObserver {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ o f277876d;

        public b(o oVar) {
            this.f277876d = oVar;
        }

        @Override // mqq.observer.BusinessObserver
        public final void onReceive(int i3, boolean z16, Bundle bundle) {
            int i16;
            String str;
            if (bundle != null) {
                i16 = bundle.getInt("rsp_code");
            } else {
                i16 = 1001;
            }
            if (bundle != null) {
                str = bundle.getString("rsp_msg");
            } else {
                str = null;
            }
            if (z16) {
                try {
                    MessageMicro rsp = ((MessageMicro) RedPackSkin$GetSkinInfoRsp.class.newInstance()).mergeFrom(bundle.getByteArray("rsp_bytes"));
                    o oVar = this.f277876d;
                    if (oVar != null) {
                        Intrinsics.checkNotNullExpressionValue(rsp, "rsp");
                        oVar.onSuccess((o) rsp);
                        return;
                    }
                    return;
                } catch (Exception unused) {
                    QLog.e("QWalletHttp-QWalletPbServlet", 1, "mergeFrom bytes array to " + RedPackSkin$GetSkinInfoRsp.class + " failed.");
                    o oVar2 = this.f277876d;
                    if (oVar2 != null) {
                        oVar2.onFail(i16, p.INSTANCE.a());
                        return;
                    }
                    return;
                }
            }
            o oVar3 = this.f277876d;
            if (oVar3 != null) {
                if (str == null) {
                    str = "empty bundle";
                }
                oVar3.onFail(i16, str);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/qwallet/hb/skin/remote/HbSkinRemoteDataSource$c", "Lpl2/o;", "Lcom/tencent/mobileqq/qwallet/pb/RedPackSkin$GetSkinInfoRsp;", "rsp", "", "a", "", "errCode", "", "errMsg", "onFail", "qqpay-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes16.dex */
    public static final class c implements o<RedPackSkin$GetSkinInfoRsp> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f277877a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f277878b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f277879c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Function2<ResultCode, HbSkinData, Unit> f277880d;

        /* JADX WARN: Multi-variable type inference failed */
        c(int i3, String str, int i16, Function2<? super ResultCode, ? super HbSkinData, Unit> function2) {
            this.f277877a = i3;
            this.f277878b = str;
            this.f277879c = i16;
            this.f277880d = function2;
        }

        @Override // pl2.k
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onSuccess(@NotNull RedPackSkin$GetSkinInfoRsp rsp) {
            long coerceAtMost;
            Object obj;
            boolean z16;
            Intrinsics.checkNotNullParameter(rsp, "rsp");
            String remoteVersion = rsp.version.get();
            List<RedPackSkin$SkinInfo> skinInfoList = rsp.skins.get();
            coerceAtMost = RangesKt___RangesKt.coerceAtMost(rsp.next_period.get() * 1000, 86400000L);
            long serverTimeMillis = coerceAtMost + NetConnInfoCenter.getServerTimeMillis();
            com.tencent.mobileqq.qwallet.utils.g.o("skin_next_period", serverTimeMillis);
            Intrinsics.checkNotNullExpressionValue(skinInfoList, "skinInfoList");
            int i3 = this.f277877a;
            String str = this.f277878b;
            int i16 = this.f277879c;
            Iterator<T> it = skinInfoList.iterator();
            while (true) {
                if (it.hasNext()) {
                    obj = it.next();
                    RedPackSkin$SkinInfo redPackSkin$SkinInfo = (RedPackSkin$SkinInfo) obj;
                    if (i3 == redPackSkin$SkinInfo.skin_id.get() && Intrinsics.areEqual(str, redPackSkin$SkinInfo.outer_skin_id.get()) && i16 == redPackSkin$SkinInfo.skin_from.get()) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if (z16) {
                        break;
                    }
                } else {
                    obj = null;
                    break;
                }
            }
            RedPackSkin$SkinInfo redPackSkin$SkinInfo2 = (RedPackSkin$SkinInfo) obj;
            if (redPackSkin$SkinInfo2 == null) {
                QLog.e("HbSkinRemoteDataSource", 2, "[requestSkinInfo] skinData with skinId=" + this.f277877a + ", outerSkinId=" + this.f277878b + ", skinFrom=" + this.f277879c + " is not find");
                this.f277880d.invoke(ResultCode.FAILED, null);
                return;
            }
            HbSkinRemoteDataSource hbSkinRemoteDataSource = HbSkinRemoteDataSource.f277873a;
            Intrinsics.checkNotNullExpressionValue(remoteVersion, "remoteVersion");
            HbSkinData b16 = hbSkinRemoteDataSource.b(redPackSkin$SkinInfo2, remoteVersion, serverTimeMillis);
            QLog.i("HbSkinRemoteDataSource", 2, "[requestSkinInfo] resp = " + b16);
            this.f277880d.invoke(ResultCode.SUCCESS, b16);
        }

        @Override // pl2.k
        public void onFail(int errCode, @NotNull String errMsg) {
            Intrinsics.checkNotNullParameter(errMsg, "errMsg");
            QLog.e("HbSkinRemoteDataSource", 1, errMsg);
            this.f277880d.invoke(ResultCode.FAILED, null);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\r\u001a\u00020\n\"\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000\u0000\"\u0010\b\u0001\u0010\u0002\u0018\u0001*\b\u0012\u0004\u0012\u00028\u00010\u00002\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u000e\u0010\t\u001a\n \b*\u0004\u0018\u00010\u00070\u0007H\n\u00a2\u0006\u0004\b\u000b\u0010\f"}, d2 = {"Lcom/tencent/mobileqq/pb/MessageMicro;", "Req", "Rsp", "", "<anonymous parameter 0>", "", "isSuccess", "Landroid/os/Bundle;", "kotlin.jvm.PlatformType", "bundle", "", "onReceive", "(IZLandroid/os/Bundle;)V", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    /* loaded from: classes16.dex */
    public static final class d implements BusinessObserver {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ o f277881d;

        public d(o oVar) {
            this.f277881d = oVar;
        }

        @Override // mqq.observer.BusinessObserver
        public final void onReceive(int i3, boolean z16, Bundle bundle) {
            int i16;
            String str;
            if (bundle != null) {
                i16 = bundle.getInt("rsp_code");
            } else {
                i16 = 1001;
            }
            if (bundle != null) {
                str = bundle.getString("rsp_msg");
            } else {
                str = null;
            }
            if (z16) {
                try {
                    MessageMicro rsp = ((MessageMicro) RedPackSkin$GetSkinInfoRsp.class.newInstance()).mergeFrom(bundle.getByteArray("rsp_bytes"));
                    o oVar = this.f277881d;
                    if (oVar != null) {
                        Intrinsics.checkNotNullExpressionValue(rsp, "rsp");
                        oVar.onSuccess((o) rsp);
                        return;
                    }
                    return;
                } catch (Exception unused) {
                    QLog.e("QWalletHttp-QWalletPbServlet", 1, "mergeFrom bytes array to " + RedPackSkin$GetSkinInfoRsp.class + " failed.");
                    o oVar2 = this.f277881d;
                    if (oVar2 != null) {
                        oVar2.onFail(i16, p.INSTANCE.a());
                        return;
                    }
                    return;
                }
            }
            o oVar3 = this.f277881d;
            if (oVar3 != null) {
                if (str == null) {
                    str = "empty bundle";
                }
                oVar3.onFail(i16, str);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/qwallet/hb/skin/remote/HbSkinRemoteDataSource$e", "Lpl2/o;", "Lcom/tencent/mobileqq/qwallet/pb/RedPackSkin$GetSkinInfoRsp;", "rsp", "", "a", "", "errCode", "", "errMsg", "onFail", "qqpay-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes16.dex */
    public static final class e implements o<RedPackSkin$GetSkinInfoRsp> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f277882a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Function3<ResultCode, String, List<HbSkinData>, Unit> f277883b;

        /* JADX WARN: Multi-variable type inference failed */
        e(String str, Function3<? super ResultCode, ? super String, ? super List<HbSkinData>, Unit> function3) {
            this.f277882a = str;
            this.f277883b = function3;
        }

        @Override // pl2.k
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onSuccess(@NotNull RedPackSkin$GetSkinInfoRsp rsp) {
            Intrinsics.checkNotNullParameter(rsp, "rsp");
            String remoteVersion = rsp.version.get();
            List<RedPackSkin$SkinInfo> skinInfoList = rsp.skins.get();
            long j3 = rsp.next_period.get() * 1000;
            QLog.i("HbSkinRemoteDataSource", 2, "version = " + remoteVersion + ", skin size = " + skinInfoList.size() + ", next period interval = " + j3);
            if (j3 > 86400000) {
                j3 = 86400000;
            }
            com.tencent.mobileqq.qwallet.utils.g.o("skin_next_period", NetConnInfoCenter.getServerTimeMillis() + j3);
            if (Intrinsics.areEqual(this.f277882a, remoteVersion)) {
                this.f277883b.invoke(ResultCode.NOT_UPDATE, null, null);
                return;
            }
            ArrayList arrayList = new ArrayList();
            Intrinsics.checkNotNullExpressionValue(skinInfoList, "skinInfoList");
            for (RedPackSkin$SkinInfo redPackSkin$SkinInfo : skinInfoList) {
                if (redPackSkin$SkinInfo != null) {
                    HbSkinRemoteDataSource hbSkinRemoteDataSource = HbSkinRemoteDataSource.f277873a;
                    Intrinsics.checkNotNullExpressionValue(remoteVersion, "remoteVersion");
                    arrayList.add(hbSkinRemoteDataSource.b(redPackSkin$SkinInfo, remoteVersion, 0L));
                }
            }
            this.f277883b.invoke(ResultCode.SUCCESS, remoteVersion, arrayList);
        }

        @Override // pl2.k
        public void onFail(int errCode, @NotNull String errMsg) {
            Intrinsics.checkNotNullParameter(errMsg, "errMsg");
            QLog.e("HbSkinRemoteDataSource", 1, errMsg);
            this.f277883b.invoke(ResultCode.FAILED, null, null);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\r\u001a\u00020\n\"\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000\u0000\"\u0010\b\u0001\u0010\u0002\u0018\u0001*\b\u0012\u0004\u0012\u00028\u00010\u00002\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u000e\u0010\t\u001a\n \b*\u0004\u0018\u00010\u00070\u0007H\n\u00a2\u0006\u0004\b\u000b\u0010\f"}, d2 = {"Lcom/tencent/mobileqq/pb/MessageMicro;", "Req", "Rsp", "", "<anonymous parameter 0>", "", "isSuccess", "Landroid/os/Bundle;", "kotlin.jvm.PlatformType", "bundle", "", "onReceive", "(IZLandroid/os/Bundle;)V", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    /* loaded from: classes16.dex */
    public static final class f implements BusinessObserver {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ o f277884d;

        public f(o oVar) {
            this.f277884d = oVar;
        }

        @Override // mqq.observer.BusinessObserver
        public final void onReceive(int i3, boolean z16, Bundle bundle) {
            int i16;
            String str;
            if (bundle != null) {
                i16 = bundle.getInt("rsp_code");
            } else {
                i16 = 1001;
            }
            if (bundle != null) {
                str = bundle.getString("rsp_msg");
            } else {
                str = null;
            }
            if (z16) {
                try {
                    MessageMicro rsp = ((MessageMicro) RedPackSkin$SetSelectedSkinRsp.class.newInstance()).mergeFrom(bundle.getByteArray("rsp_bytes"));
                    o oVar = this.f277884d;
                    if (oVar != null) {
                        Intrinsics.checkNotNullExpressionValue(rsp, "rsp");
                        oVar.onSuccess((o) rsp);
                        return;
                    }
                    return;
                } catch (Exception unused) {
                    QLog.e("QWalletHttp-QWalletPbServlet", 1, "mergeFrom bytes array to " + RedPackSkin$SetSelectedSkinRsp.class + " failed.");
                    o oVar2 = this.f277884d;
                    if (oVar2 != null) {
                        oVar2.onFail(i16, p.INSTANCE.a());
                        return;
                    }
                    return;
                }
            }
            o oVar3 = this.f277884d;
            if (oVar3 != null) {
                if (str == null) {
                    str = "empty bundle";
                }
                oVar3.onFail(i16, str);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/qwallet/hb/skin/remote/HbSkinRemoteDataSource$g", "Lpl2/o;", "Lcom/tencent/mobileqq/qwallet/pb/RedPackSkin$SetSelectedSkinRsp;", "rsp", "", "a", "", "errCode", "", "errMsg", "onFail", "qqpay-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes16.dex */
    public static final class g implements o<RedPackSkin$SetSelectedSkinRsp> {
        g() {
        }

        @Override // pl2.k
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onSuccess(@NotNull RedPackSkin$SetSelectedSkinRsp rsp) {
            Intrinsics.checkNotNullParameter(rsp, "rsp");
            QLog.e("HbSkinRemoteDataSource", 1, "setSelectedSkin success code = " + rsp.code.get() + " ,msg = " + rsp.f278706msg.get());
        }

        @Override // pl2.k
        public void onFail(int errCode, @NotNull String errMsg) {
            Intrinsics.checkNotNullParameter(errMsg, "errMsg");
            QLog.e("HbSkinRemoteDataSource", 1, "setSelectedSkin fail errCode = " + errCode + " ,errMsg = " + errMsg);
        }
    }

    HbSkinRemoteDataSource() {
    }

    private final HbSkinData.Tail c(RedPackSkin$Tail tailInfo) {
        if (tailInfo == null) {
            return new HbSkinData.Tail(null, null, null);
        }
        return new HbSkinData.Tail(tailInfo.color.get(), tailInfo.url.get(), tailInfo.word.get());
    }

    private final ArrayList<HbSkinData.StoryRes> d(List<RedPackSkin$Story> storyInfoList) {
        boolean z16;
        List<RedPackSkin$Story> filterNotNull;
        ArrayList<HbSkinData.StoryRes> arrayList = new ArrayList<>();
        List<RedPackSkin$Story> list = storyInfoList;
        if (list != null && !list.isEmpty()) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!z16) {
            filterNotNull = CollectionsKt___CollectionsKt.filterNotNull(storyInfoList);
            for (RedPackSkin$Story redPackSkin$Story : filterNotNull) {
                arrayList.add(new HbSkinData.StoryRes(redPackSkin$Story.type.get(), redPackSkin$Story.img_url.get(), redPackSkin$Story.video_url.get()));
            }
            return arrayList;
        }
        return arrayList;
    }

    private final String f() {
        if (Intrinsics.areEqual(AppSetting.f99551k, h())) {
            return com.tencent.mobileqq.qwallet.utils.g.i("skin_version");
        }
        o("");
        p();
        QLog.i("HbSkinRemoteDataSource", 1, "not match qqVersion,just update");
        return "";
    }

    private final long g() {
        return com.tencent.mobileqq.qwallet.utils.g.f279262a.g("skin_next_period");
    }

    private final String h() {
        return com.tencent.mobileqq.qwallet.utils.g.i("skin_qq_version");
    }

    private final void k(int skinId, String outerSkinId, int skinFrom, Function2<? super ResultCode, ? super HbSkinData, Unit> receiver) {
        boolean z16;
        c cVar = new c(skinId, outerSkinId, skinFrom, receiver);
        RedPackSkin$GetSkinInfoReq redPackSkin$GetSkinInfoReq = new RedPackSkin$GetSkinInfoReq();
        redPackSkin$GetSkinInfoReq.version.set(f277873a.f());
        if (skinId > 0) {
            redPackSkin$GetSkinInfoReq.skin_ids.add(Integer.valueOf(skinId));
        }
        boolean z17 = false;
        if (outerSkinId != null) {
            if (outerSkinId.length() > 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                z17 = true;
            }
        }
        if (z17) {
            redPackSkin$GetSkinInfoReq.outer_skin_ids.add(outerSkinId);
        }
        redPackSkin$GetSkinInfoReq.skin_from.set(skinFrom);
        QLog.i("HbSkinRemoteDataSource", 1, "[requestSkinInfo] req = (skidId=" + skinId + ", outerSkinId=" + outerSkinId + ", skinFrom=" + skinFrom + ", version=" + f() + ")");
        p.Companion companion = p.INSTANCE;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("send req: cmd=");
        sb5.append("trpc.qpay.red_pack_skin.Skin.SsoGetSkinInfo");
        sb5.append(" callback: ");
        sb5.append(cVar);
        sb5.append(TokenParser.SP);
        QLog.i("QWalletHttp-QWalletPbServlet", 1, sb5.toString());
        AppRuntime waitAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
        NewIntent newIntent = new NewIntent(waitAppRuntime.getApplication(), p.class);
        newIntent.putExtra("cmd", "trpc.qpay.red_pack_skin.Skin.SsoGetSkinInfo");
        newIntent.putExtra("data", fh.b(redPackSkin$GetSkinInfoReq.toByteArray()));
        newIntent.putExtra("timeout", 5000L);
        newIntent.setObserver(new b(cVar));
        waitAppRuntime.startServlet(newIntent);
    }

    public static /* synthetic */ void m(HbSkinRemoteDataSource hbSkinRemoteDataSource, String str, List list, List list2, int i3, Function3 function3, int i16, Object obj) {
        List list3;
        List list4;
        if ((i16 & 1) != 0) {
            str = hbSkinRemoteDataSource.f();
        }
        String str2 = str;
        if ((i16 & 2) != 0) {
            list3 = null;
        } else {
            list3 = list;
        }
        if ((i16 & 4) != 0) {
            list4 = null;
        } else {
            list4 = list2;
        }
        if ((i16 & 8) != 0) {
            i3 = 0;
        }
        hbSkinRemoteDataSource.l(str2, list3, list4, i3, function3);
    }

    private final void p() {
        String subVersion = AppSetting.f99551k;
        Intrinsics.checkNotNullExpressionValue(subVersion, "subVersion");
        com.tencent.mobileqq.qwallet.utils.g.q("skin_qq_version", subVersion);
        QLog.i("HbSkinRemoteDataSource", 2, "updateQQVersion:qqVersion");
    }

    @NotNull
    public final HbSkinData b(@NotNull RedPackSkin$SkinInfo skinInfo, @NotNull String remoteVersion, long expireTimeMs) {
        Intrinsics.checkNotNullParameter(skinInfo, "skinInfo");
        Intrinsics.checkNotNullParameter(remoteVersion, "remoteVersion");
        int i3 = skinInfo.skin_id.get();
        String str = skinInfo.outer_skin_id.get();
        Intrinsics.checkNotNullExpressionValue(str, "skinInfo.outer_skin_id.get()");
        return new HbSkinData(i3, str, skinInfo.skin_from.get(), skinInfo.type.get(), skinInfo.price.get(), skinInfo.title.get(), skinInfo.merchant.name.get(), skinInfo.merchant.logo.get(), skinInfo.activity.name.get(), skinInfo.activity.url.get(), skinInfo.activity.icon.get(), skinInfo.default_skin_url.get(), skinInfo.aio_res_url.get(), skinInfo.pop_res_url.get(), skinInfo.pop_open_url.get(), skinInfo.pop_broken_url.get(), c(skinInfo.tail.get()), d(skinInfo.stories.get()), remoteVersion, expireTimeMs);
    }

    public final void e(boolean force, @NotNull final Function3<? super ResultCode, ? super String, ? super List<HbSkinData>, Unit> receiver) {
        boolean z16;
        Intrinsics.checkNotNullParameter(receiver, "receiver");
        long serverTimeMillis = NetConnInfoCenter.getServerTimeMillis();
        if (!force && serverTimeMillis < g()) {
            if (f().length() > 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                receiver.invoke(ResultCode.FREQUENCY_LIMIT, null, null);
                return;
            }
        }
        if (state.compareAndSet(0, 1)) {
            m(this, null, null, null, 0, new Function3<ResultCode, String, List<? extends HbSkinData>, Unit>() { // from class: com.tencent.mobileqq.qwallet.hb.skin.remote.HbSkinRemoteDataSource$getAllSkinData$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(3);
                }

                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(HbSkinRemoteDataSource.ResultCode resultCode, String str, List<? extends HbSkinData> list) {
                    invoke2(resultCode, str, (List<HbSkinData>) list);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull HbSkinRemoteDataSource.ResultCode resultCode, @Nullable String str, @Nullable List<HbSkinData> list) {
                    AtomicInteger atomicInteger;
                    Intrinsics.checkNotNullParameter(resultCode, "resultCode");
                    receiver.invoke(resultCode, str, list);
                    atomicInteger = HbSkinRemoteDataSource.state;
                    atomicInteger.set(0);
                }
            }, 15, null);
        } else {
            receiver.invoke(ResultCode.UPDATING, null, null);
        }
    }

    public final void i(int skinId, @Nullable String outerSkinId, int skinFrom, @NotNull final Function2<? super ResultCode, ? super HbSkinData, Unit> receiver) {
        Intrinsics.checkNotNullParameter(receiver, "receiver");
        k(skinId, outerSkinId, skinFrom, new Function2<ResultCode, HbSkinData, Unit>() { // from class: com.tencent.mobileqq.qwallet.hb.skin.remote.HbSkinRemoteDataSource$getSkinData$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(HbSkinRemoteDataSource.ResultCode resultCode, HbSkinData hbSkinData) {
                invoke2(resultCode, hbSkinData);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull HbSkinRemoteDataSource.ResultCode resultCode, @Nullable HbSkinData hbSkinData) {
                Intrinsics.checkNotNullParameter(resultCode, "resultCode");
                receiver.invoke(resultCode, hbSkinData);
            }
        });
    }

    public final void j(@Nullable String recvType, @NotNull o<RedPackSkin$GetUserSkinRsp> callback) {
        int i3;
        Intrinsics.checkNotNullParameter(callback, "callback");
        RedPackSkin$GetUserSkinReq redPackSkin$GetUserSkinReq = new RedPackSkin$GetUserSkinReq();
        if (recvType == null) {
            recvType = "";
        }
        try {
            i3 = Integer.parseInt(recvType);
        } catch (NumberFormatException e16) {
            QLog.e("HbSkinRemoteDataSource", 1, e16, new Object[0]);
            i3 = 0;
        }
        redPackSkin$GetUserSkinReq.aio_type.set(i3);
        p.Companion companion = p.INSTANCE;
        QLog.i("QWalletHttp-QWalletPbServlet", 1, "send req: cmd=trpc.qpay.red_pack_skin.Skin.SsoGetUserSkin callback: " + callback + TokenParser.SP);
        AppRuntime waitAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
        NewIntent newIntent = new NewIntent(waitAppRuntime.getApplication(), p.class);
        newIntent.putExtra("cmd", "trpc.qpay.red_pack_skin.Skin.SsoGetUserSkin");
        newIntent.putExtra("data", fh.b(redPackSkin$GetUserSkinReq.toByteArray()));
        newIntent.putExtra("timeout", 30000L);
        newIntent.setObserver(new a(callback));
        waitAppRuntime.startServlet(newIntent);
    }

    public final void l(@NotNull String version, @Nullable List<Integer> skinIdList, @Nullable List<String> outSkinIdList, int skinFrom, @NotNull Function3<? super ResultCode, ? super String, ? super List<HbSkinData>, Unit> receiver) {
        Intrinsics.checkNotNullParameter(version, "version");
        Intrinsics.checkNotNullParameter(receiver, "receiver");
        e eVar = new e(version, receiver);
        RedPackSkin$GetSkinInfoReq redPackSkin$GetSkinInfoReq = new RedPackSkin$GetSkinInfoReq();
        redPackSkin$GetSkinInfoReq.version.set(version);
        if (skinIdList != null) {
            redPackSkin$GetSkinInfoReq.skin_ids.set(skinIdList);
        }
        if (outSkinIdList != null) {
            redPackSkin$GetSkinInfoReq.outer_skin_ids.set(outSkinIdList);
        }
        redPackSkin$GetSkinInfoReq.skin_from.set(skinFrom);
        p.Companion companion = p.INSTANCE;
        QLog.i("QWalletHttp-QWalletPbServlet", 1, "send req: cmd=trpc.qpay.red_pack_skin.Skin.SsoGetSkinInfo callback: " + eVar + TokenParser.SP);
        AppRuntime waitAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
        NewIntent newIntent = new NewIntent(waitAppRuntime.getApplication(), p.class);
        newIntent.putExtra("cmd", "trpc.qpay.red_pack_skin.Skin.SsoGetSkinInfo");
        newIntent.putExtra("data", fh.b(redPackSkin$GetSkinInfoReq.toByteArray()));
        newIntent.putExtra("timeout", 30000L);
        newIntent.setObserver(new d(eVar));
        waitAppRuntime.startServlet(newIntent);
    }

    public final void n(int skinId, @NotNull String outerSkinId, int skinFrom) {
        Intrinsics.checkNotNullParameter(outerSkinId, "outerSkinId");
        g gVar = new g();
        RedPackSkin$SetSelectedSkinReq redPackSkin$SetSelectedSkinReq = new RedPackSkin$SetSelectedSkinReq();
        redPackSkin$SetSelectedSkinReq.skin_id.set(skinId);
        redPackSkin$SetSelectedSkinReq.outer_skin_id.set(outerSkinId);
        redPackSkin$SetSelectedSkinReq.skin_from.set(skinFrom);
        p.Companion companion = p.INSTANCE;
        QLog.i("QWalletHttp-QWalletPbServlet", 1, "send req: cmd=trpc.qpay.red_pack_skin.Skin.SsoSetSelectedSkin callback: " + gVar + TokenParser.SP);
        AppRuntime waitAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
        NewIntent newIntent = new NewIntent(waitAppRuntime.getApplication(), p.class);
        newIntent.putExtra("cmd", "trpc.qpay.red_pack_skin.Skin.SsoSetSelectedSkin");
        newIntent.putExtra("data", fh.b(redPackSkin$SetSelectedSkinReq.toByteArray()));
        newIntent.putExtra("timeout", 30000L);
        newIntent.setObserver(new f(gVar));
        waitAppRuntime.startServlet(newIntent);
    }

    public final void o(@NotNull String remoteVersion) {
        Intrinsics.checkNotNullParameter(remoteVersion, "remoteVersion");
        com.tencent.mobileqq.qwallet.utils.g.q("skin_version", remoteVersion);
    }
}
