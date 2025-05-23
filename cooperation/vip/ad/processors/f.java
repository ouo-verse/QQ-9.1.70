package cooperation.vip.ad.processors;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.reminder.api.IQQReminderMsgService;
import com.tencent.mobileqq.reminder.util.QQConstants;
import com.tencent.mobileqq.tianshu.data.TianShuAdPosItemData;
import com.tencent.mobileqq.tritonaudio.InnerAudioPlugin;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.report.datong.QZoneDTLoginReporter;
import cooperation.vip.ad.processors.a;
import cooperation.vip.pb.TianShuAccess;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.api.ProcessConstant;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u0000 \u00102\u00020\u0001:\u0001\u001fB\u0007\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J2\u0010\t\u001a\"\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006j\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0018\u0001`\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J2\u0010\u000b\u001a\u0004\u0018\u00010\u00042&\u0010\n\u001a\"\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006j\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0018\u0001`\bH\u0002J\u0016\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\u0006\u0010\r\u001a\u00020\fH\u0016J\b\u0010\u0012\u001a\u00020\u0011H\u0016J4\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0014\u001a\u00020\u00132\u0012\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00160\u00152\u0006\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\fH\u0016J\b\u0010\u001c\u001a\u00020\u0011H\u0016\u00a8\u0006 "}, d2 = {"Lcooperation/vip/ad/processors/f;", "Lcooperation/vip/ad/processors/a;", "Lcooperation/vip/pb/TianShuAccess$AdItem;", "adItem", "LWallet/a;", "l", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "k", "dataMap", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "", "time", "", "Lcom/tencent/mobileqq/tianshu/data/TianShuAdPosItemData;", "d", "", "f", "Lcooperation/vip/pb/TianShuAccess$GetAdsRsp;", "getAdsRsp", "", "Lcooperation/vip/pb/TianShuAccess$RspEntry;", "mapEntries", "traceId", InnerAudioPlugin.AUDIO_PROPERTY_CURRENTTIME, "", "i", "e", "<init>", "()V", "a", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes28.dex */
public final class f implements a {
    private final HashMap<String, String> k(TianShuAccess.AdItem adItem) {
        if (adItem == null) {
            return null;
        }
        HashMap<String, String> hashMap = new HashMap<>();
        for (TianShuAccess.MapEntry mapEntry : adItem.argList.get()) {
            String str = mapEntry.key.get();
            Intrinsics.checkNotNullExpressionValue(str, "mapEntry.key.get()");
            String str2 = mapEntry.value.get();
            Intrinsics.checkNotNullExpressionValue(str2, "mapEntry.value.get()");
            hashMap.put(str, str2);
        }
        return hashMap;
    }

    private final Wallet.a l(TianShuAccess.AdItem adItem) {
        Wallet.a m3;
        try {
            QLog.i("QQReminderProcessor", 1, "[handleSingleAdItem]");
            HashMap<String, String> k3 = k(adItem);
            if (k3 == null || (m3 = m(k3)) == null) {
                return null;
            }
            m3.f25152k = String.valueOf(adItem.iAdId.get());
            m3.f25153l = adItem.traceinfo.get();
            return m3;
        } catch (Throwable th5) {
            QLog.e("QQReminderProcessor", 1, th5.getMessage());
            return null;
        }
    }

    private final Wallet.a m(HashMap<String, String> dataMap) {
        if (dataMap == null) {
            return null;
        }
        Wallet.a aVar = new Wallet.a();
        aVar.f25142a = dataMap.get("toptext");
        aVar.f25143b = dataMap.get("title");
        aVar.f25146e = dataMap.get("pic");
        aVar.f25144c = dataMap.get("text");
        Integer valueOf = Integer.valueOf(dataMap.get("time"));
        Intrinsics.checkNotNullExpressionValue(valueOf, "valueOf(dataMap[\"time\"])");
        aVar.f25151j = valueOf.intValue();
        aVar.f25149h = dataMap.get("url");
        aVar.f25150i = dataMap.get(QZoneDTLoginReporter.SCHEMA);
        return aVar;
    }

    @Override // cooperation.vip.ad.processors.a
    public int a() {
        return a.C10126a.h(this);
    }

    @Override // cooperation.vip.ad.processors.a
    public void b(int i3) {
        a.C10126a.a(this, i3);
    }

    @Override // cooperation.vip.ad.processors.a
    public boolean c(int i3) {
        return a.C10126a.e(this, i3);
    }

    @Override // cooperation.vip.ad.processors.a
    @NotNull
    public List<TianShuAdPosItemData> d(int time) {
        ArrayList arrayList = new ArrayList();
        TianShuAdPosItemData tianShuAdPosItemData = new TianShuAdPosItemData();
        tianShuAdPosItemData.mPosId = QQConstants.REMINDER_POS_ID;
        tianShuAdPosItemData.mNeedCnt = 1;
        arrayList.add(tianShuAdPosItemData);
        return arrayList;
    }

    @Override // cooperation.vip.ad.processors.a
    @NotNull
    public int[] e() {
        return new int[]{4, 1, 3, 2};
    }

    @Override // cooperation.vip.ad.processors.a
    @NotNull
    public int[] f() {
        return new int[]{QQConstants.REMINDER_POS_ID};
    }

    @Override // cooperation.vip.ad.processors.a
    public void g(long j3) {
        a.C10126a.i(this, j3);
    }

    @Override // cooperation.vip.ad.processors.a
    public boolean h(int i3) {
        return a.C10126a.d(this, i3);
    }

    @Override // cooperation.vip.ad.processors.a
    public void i(@NotNull TianShuAccess.GetAdsRsp getAdsRsp, @NotNull Map<Integer, TianShuAccess.RspEntry> mapEntries, @NotNull String traceId, int currentTime) {
        IQQReminderMsgService iQQReminderMsgService;
        Intrinsics.checkNotNullParameter(getAdsRsp, "getAdsRsp");
        Intrinsics.checkNotNullParameter(mapEntries, "mapEntries");
        Intrinsics.checkNotNullParameter(traceId, "traceId");
        TianShuAccess.RspEntry rspEntry = mapEntries.get(Integer.valueOf(QQConstants.REMINDER_POS_ID));
        if (rspEntry == null) {
            return;
        }
        QQAppInterface b16 = cooperation.vip.ad.i.b();
        if (rspEntry.value.lst.isEmpty()) {
            return;
        }
        TianShuAccess.AdItem adItem = rspEntry.value.lst.get(0);
        Intrinsics.checkNotNullExpressionValue(adItem, "entry.value.lst.get(0)");
        Wallet.a l3 = l(adItem);
        if (b16 != null && (iQQReminderMsgService = (IQQReminderMsgService) b16.getRuntimeService(IQQReminderMsgService.class, ProcessConstant.MULTI)) != null) {
            iQQReminderMsgService.showRemindDialog(l3);
        }
    }

    @Override // cooperation.vip.ad.processors.a
    public long j() {
        return a.C10126a.b(this);
    }

    @Override // cooperation.vip.ad.processors.a
    public void onAccountChange() {
        a.C10126a.f(this);
    }

    @Override // cooperation.vip.ad.processors.a
    public void onDestroy() {
        a.C10126a.g(this);
    }
}
