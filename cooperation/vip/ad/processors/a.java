package cooperation.vip.ad.processors;

import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.richframework.delegate.impl.RFWApplication;
import com.tencent.mobileqq.emoticon.CommonUsedSystemEmojiManagerConstants;
import com.tencent.mobileqq.tianshu.data.TianShuAdPosItemData;
import com.tencent.mobileqq.tritonaudio.InnerAudioPlugin;
import com.tencent.qphone.base.util.QLog;
import cooperation.vip.pb.TianShuAccess;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001J\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\b\u001a\u00020\u0007H&J4\u0010\u0012\u001a\u00020\u00112\u0006\u0010\n\u001a\u00020\t2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u0002H&J\b\u0010\u0013\u001a\u00020\u0007H&J\b\u0010\u0014\u001a\u00020\u0011H\u0016J\b\u0010\u0015\u001a\u00020\u0011H\u0016J\u0010\u0010\u0017\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u0002H\u0016J\u0010\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0016\u001a\u00020\u0002H\u0016J\u0010\u0010\u001a\u001a\u00020\u00182\u0006\u0010\u0016\u001a\u00020\u0002H\u0016J\b\u0010\u001b\u001a\u00020\u0002H\u0016J\b\u0010\u001c\u001a\u00020\u000eH\u0002R$\u0010#\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001d8V@VX\u0096\u000e\u00a2\u0006\f\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"\u00a8\u0006$"}, d2 = {"Lcooperation/vip/ad/processors/a;", "", "", "time", "", "Lcom/tencent/mobileqq/tianshu/data/TianShuAdPosItemData;", "d", "", "f", "Lcooperation/vip/pb/TianShuAccess$GetAdsRsp;", "getAdsRsp", "", "Lcooperation/vip/pb/TianShuAccess$RspEntry;", "mapEntries", "", "traceId", InnerAudioPlugin.AUDIO_PROPERTY_CURRENTTIME, "", "i", "e", "onAccountChange", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "nowTime", "b", "", "c", tl.h.F, "a", "getMMKVKey", "", "value", "j", "()J", "g", "(J)V", CommonUsedSystemEmojiManagerConstants.LAST_REQUEST_TIME, "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes28.dex */
public interface a {
    int a();

    void b(int nowTime);

    boolean c(int nowTime);

    @NotNull
    List<TianShuAdPosItemData> d(int time);

    @NotNull
    int[] e();

    @NotNull
    int[] f();

    void g(long j3);

    boolean h(int nowTime);

    void i(@NotNull TianShuAccess.GetAdsRsp getAdsRsp, @NotNull Map<Integer, TianShuAccess.RspEntry> mapEntries, @NotNull String traceId, int currentTime);

    long j();

    void onAccountChange();

    void onDestroy();

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* renamed from: cooperation.vip.ad.processors.a$a, reason: collision with other inner class name */
    /* loaded from: classes28.dex */
    public static final class C10126a {
        public static long b(@NotNull a aVar) {
            return cooperation.vip.ad.i.g().decodeLong(c(aVar), 0L);
        }

        private static String c(a aVar) {
            String joinToString$default;
            String accountId = RFWApplication.getAccountId();
            joinToString$default = ArraysKt___ArraysKt.joinToString$default(aVar.f(), (CharSequence) "_", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null);
            return "AdRequestBasedProcessor_" + accountId + "_" + joinToString$default;
        }

        public static boolean d(@NotNull a aVar, int i3) {
            for (int i16 : aVar.e()) {
                if (i16 == i3) {
                    return true;
                }
            }
            return false;
        }

        public static boolean e(@NotNull a aVar, int i3) {
            String joinToString$default;
            if (System.currentTimeMillis() - aVar.j() < aVar.a()) {
                joinToString$default = ArraysKt___ArraysKt.joinToString$default(aVar.f(), (CharSequence) "_", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null);
                QLog.e("AdRequestBasedProcessor", 1, "adId: " + joinToString$default + ", needRequest time:" + i3 + ", lastRequestTime:" + aVar.j() + ", requestTimes:" + aVar.e());
                return false;
            }
            return aVar.h(i3);
        }

        public static int h(@NotNull a aVar) {
            return cooperation.vip.ad.i.e();
        }

        public static void i(@NotNull a aVar, long j3) {
            cooperation.vip.ad.i.g().encodeLong(c(aVar), j3);
        }

        public static void f(@NotNull a aVar) {
        }

        public static void g(@NotNull a aVar) {
        }

        public static void a(@NotNull a aVar, int i3) {
        }
    }
}
