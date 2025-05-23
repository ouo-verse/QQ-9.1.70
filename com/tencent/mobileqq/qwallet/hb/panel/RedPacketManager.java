package com.tencent.mobileqq.qwallet.hb.panel;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.activity.aio.p;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.api.IQWalletServletApi;
import com.tencent.mobileqq.qwallet.hb.impl.PanelDataChecker;
import com.tencent.mobileqq.qwallet.hb.panel.RedPacketManager;
import com.tencent.mobileqq.qwallet.hb.send.PanelEntryData;
import com.tencent.mobileqq.qwallet.hb.send.PanelTabData;
import com.tencent.mobileqq.qwallet.pb.Hongbao$GetRedPacketConfigReq;
import com.tencent.mobileqq.qwallet.pb.Hongbao$GetRedPacketConfigRsp;
import com.tencent.mobileqq.qwallet.pb.Hongbao$HbEntry;
import com.tencent.mobileqq.qwallet.pb.Hongbao$HbTab;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.troop.utils.bg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;
import pl2.o;

@Metadata(d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0002=>B\t\b\u0002\u00a2\u0006\u0004\b;\u0010<J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J)\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\t2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002H\u0007\u00a2\u0006\u0004\b\n\u0010\u000bJ+\u0010\u0013\u001a\u00020\u00112!\u0010\u0012\u001a\u001d\u0012\u0013\u0012\u00110\r\u00a2\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u00110\fH\u0007J\u0010\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\u0014H\u0002J\u001e\u0010\u001a\u001a\u00020\r2\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\b0\u00172\u0006\u0010\u0019\u001a\u00020\u0002H\u0002J\u0010\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001c\u001a\u00020\u001bH\u0002J\u0018\u0010\"\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020\u001d2\u0006\u0010!\u001a\u00020 H\u0002J$\u0010%\u001a\u0004\u0018\u00010#2\u0006\u0010!\u001a\u00020 2\b\u0010$\u001a\u0004\u0018\u00010#2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u001a\u0010&\u001a\u0004\u0018\u00010#2\u0006\u0010!\u001a\u00020 2\u0006\u0010$\u001a\u00020#H\u0002J\u0012\u0010'\u001a\u00020\r2\b\u0010\u001f\u001a\u0004\u0018\u00010\u001dH\u0002J\b\u0010(\u001a\u00020\u0011H\u0007J\b\u0010)\u001a\u00020\u0011H\u0002J\u0016\u0010,\u001a\u00020\u00112\u0006\u0010!\u001a\u00020 2\u0006\u0010+\u001a\u00020*J\u000e\u0010/\u001a\u00020\u00112\u0006\u0010.\u001a\u00020-R\u0014\u00102\u001a\u00020\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b0\u00101R\u0014\u00103\u001a\u00020\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001a\u00101R$\u0010:\u001a\u0004\u0018\u0001048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b&\u00105\u001a\u0004\b6\u00107\"\u0004\b8\u00109\u00a8\u0006?"}, d2 = {"Lcom/tencent/mobileqq/qwallet/hb/panel/RedPacketManager;", "", "", "type", "Lorg/json/JSONObject;", "f", "curType", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/qwallet/hb/send/PanelEntryData;", "Lkotlin/collections/ArrayList;", tl.h.F, "(Ljava/lang/Integer;)Ljava/util/ArrayList;", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "isSuccess", "", "receiver", DomainData.DOMAIN_NAME, "Lcom/tencent/mobileqq/qwallet/pb/Hongbao$HbEntry;", "hbEntry", "i", "", "list", "hbType", "c", "Lcom/tencent/mobileqq/qwallet/pb/Hongbao$HbTab;", "hbTab", "Lcom/tencent/mobileqq/qwallet/hb/send/PanelTabData;", "j", "panelTabData", "Lcom/tencent/mobileqq/activity/aio/p;", "sessionInfo", "l", "", "url", "g", "d", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "k", "o", "Lcom/tencent/mobileqq/qwallet/hb/panel/RedPacketManager$a;", "listener", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/qwallet/pb/Hongbao$GetRedPacketConfigRsp;", "rsp", "p", "b", "Lcom/tencent/mobileqq/qwallet/hb/send/PanelEntryData;", "DEFAULT_HB_ENTRY", "LUCK_HB_ENTRY", "Lcom/tencent/mobileqq/qwallet/hb/panel/RedPacketManager$HbPanelConfig;", "Lcom/tencent/mobileqq/qwallet/hb/panel/RedPacketManager$HbPanelConfig;", "e", "()Lcom/tencent/mobileqq/qwallet/hb/panel/RedPacketManager$HbPanelConfig;", "setHbPanelConfig", "(Lcom/tencent/mobileqq/qwallet/hb/panel/RedPacketManager$HbPanelConfig;)V", "hbPanelConfig", "<init>", "()V", "a", "HbPanelConfig", "qqpay-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class RedPacketManager {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final RedPacketManager f277534a = new RedPacketManager();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final PanelEntryData DEFAULT_HB_ENTRY;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final PanelEntryData LUCK_HB_ENTRY;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static HbPanelConfig hbPanelConfig;

    @Parcelize
    @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0087\b\u0018\u00002\u00020\u0001B#\u0012\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010\u0012\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00190\u0010\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003J\t\u0010\n\u001a\u00020\u0004H\u00d6\u0001J\u0019\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u0004H\u00d6\u0001R(\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00110\u00108\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R(\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00190\u00108\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001a\u0010\u0013\u001a\u0004\b\u001b\u0010\u0015\"\u0004\b\u001c\u0010\u0017\u00a8\u0006 "}, d2 = {"Lcom/tencent/mobileqq/qwallet/hb/panel/RedPacketManager$HbPanelConfig;", "Landroid/os/Parcelable;", "", "toString", "", "hashCode", "", "other", "", "equals", "describeContents", "Landroid/os/Parcel;", "parcel", WadlProxyConsts.FLAGS, "", "writeToParcel", "", "Lcom/tencent/mobileqq/qwallet/hb/send/PanelEntryData;", "d", "Ljava/util/List;", "a", "()Ljava/util/List;", "setEntryList", "(Ljava/util/List;)V", "entryList", "Lcom/tencent/mobileqq/qwallet/hb/send/PanelTabData;", "e", "b", "setTabList", "tabList", "<init>", "(Ljava/util/List;Ljava/util/List;)V", "qqpay-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes16.dex */
    public static final /* data */ class HbPanelConfig implements Parcelable {

        @NotNull
        public static final Parcelable.Creator<HbPanelConfig> CREATOR = new a();

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private List<PanelEntryData> entryList;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private List<PanelTabData> tabList;

        @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
        /* loaded from: classes16.dex */
        public static final class a implements Parcelable.Creator<HbPanelConfig> {
            @Override // android.os.Parcelable.Creator
            @NotNull
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final HbPanelConfig createFromParcel(@NotNull Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                int readInt = parcel.readInt();
                ArrayList arrayList = new ArrayList(readInt);
                for (int i3 = 0; i3 != readInt; i3++) {
                    arrayList.add(parcel.readParcelable(HbPanelConfig.class.getClassLoader()));
                }
                int readInt2 = parcel.readInt();
                ArrayList arrayList2 = new ArrayList(readInt2);
                for (int i16 = 0; i16 != readInt2; i16++) {
                    arrayList2.add(parcel.readParcelable(HbPanelConfig.class.getClassLoader()));
                }
                return new HbPanelConfig(arrayList, arrayList2);
            }

            @Override // android.os.Parcelable.Creator
            @NotNull
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public final HbPanelConfig[] newArray(int i3) {
                return new HbPanelConfig[i3];
            }
        }

        public HbPanelConfig(@NotNull List<PanelEntryData> entryList, @NotNull List<PanelTabData> tabList) {
            Intrinsics.checkNotNullParameter(entryList, "entryList");
            Intrinsics.checkNotNullParameter(tabList, "tabList");
            this.entryList = entryList;
            this.tabList = tabList;
        }

        @NotNull
        public final List<PanelEntryData> a() {
            return this.entryList;
        }

        @NotNull
        public final List<PanelTabData> b() {
            return this.tabList;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof HbPanelConfig)) {
                return false;
            }
            HbPanelConfig hbPanelConfig = (HbPanelConfig) other;
            if (Intrinsics.areEqual(this.entryList, hbPanelConfig.entryList) && Intrinsics.areEqual(this.tabList, hbPanelConfig.tabList)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return (this.entryList.hashCode() * 31) + this.tabList.hashCode();
        }

        @NotNull
        public String toString() {
            return "HbPanelConfig(entryList=" + this.entryList + ", tabList=" + this.tabList + ")";
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel parcel, int flags) {
            Intrinsics.checkNotNullParameter(parcel, "out");
            List<PanelEntryData> list = this.entryList;
            parcel.writeInt(list.size());
            Iterator<PanelEntryData> it = list.iterator();
            while (it.hasNext()) {
                parcel.writeParcelable(it.next(), flags);
            }
            List<PanelTabData> list2 = this.tabList;
            parcel.writeInt(list2.size());
            Iterator<PanelTabData> it5 = list2.iterator();
            while (it5.hasNext()) {
                parcel.writeParcelable(it5.next(), flags);
            }
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\bf\u0018\u00002\u00020\u0001J$\u0010\b\u001a\u00020\u00072\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0002H&J$\u0010\u000b\u001a\u00020\u00072\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u0002H&J$\u0010\u000e\u001a\u00020\u00072\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00050\u0002H&\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/qwallet/hb/panel/RedPacketManager$a;", "", "", "Lcom/tencent/mobileqq/qwallet/hb/send/PanelEntryData;", "cacheEntryList", "Lcom/tencent/mobileqq/qwallet/hb/send/PanelTabData;", "cacheTabList", "", "b", "entryList", "panelTabList", "a", "defaultEntryList", "defaultTabList", "c", "qqpay-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes16.dex */
    public interface a {
        void a(@NotNull List<PanelEntryData> entryList, @NotNull List<PanelTabData> panelTabList);

        void b(@NotNull List<PanelEntryData> cacheEntryList, @NotNull List<PanelTabData> cacheTabList);

        void c(@NotNull List<PanelEntryData> defaultEntryList, @NotNull List<PanelTabData> defaultTabList);
    }

    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/qwallet/hb/panel/RedPacketManager$b", "Lpl2/o;", "Lcom/tencent/mobileqq/qwallet/pb/Hongbao$GetRedPacketConfigRsp;", "rsp", "", "a", "", "errCode", "", "errMsg", "onFail", "qqpay-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes16.dex */
    public static final class b implements o<Hongbao$GetRedPacketConfigRsp> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Function1<Boolean, Unit> f277540a;

        /* JADX WARN: Multi-variable type inference failed */
        b(Function1<? super Boolean, Unit> function1) {
            this.f277540a = function1;
        }

        @Override // pl2.k
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onSuccess(@NotNull Hongbao$GetRedPacketConfigRsp rsp) {
            Intrinsics.checkNotNullParameter(rsp, "rsp");
            RedPacketManager.f277534a.p(rsp);
            this.f277540a.invoke(Boolean.TRUE);
        }

        @Override // pl2.k
        public void onFail(int errCode, @NotNull String errMsg) {
            Intrinsics.checkNotNullParameter(errMsg, "errMsg");
            this.f277540a.invoke(Boolean.FALSE);
            QLog.e("RedPacketManager", 1, "requestCheckerData errMsg = " + errMsg);
        }
    }

    static {
        k();
        DEFAULT_HB_ENTRY = new PanelEntryData("", 0, "\u666e\u901a\u7ea2\u5305", "https://moggy-1251316161.file.myqcloud.com/aioTheme/4358/1102.png", 0, null, 48, null);
        LUCK_HB_ENTRY = new PanelEntryData("", 1, "\u62fc\u624b\u6c14\u7ea2\u5305", "https://moggy-1251316161.file.myqcloud.com/aioTheme/4358/1101.png", 0, null, 48, null);
    }

    RedPacketManager() {
    }

    private final boolean c(List<PanelEntryData> list, int hbType) {
        Iterator<PanelEntryData> it = list.iterator();
        while (it.hasNext()) {
            if (it.next().getType() == hbType) {
                return true;
            }
        }
        return false;
    }

    private final String d(p sessionInfo, String url) {
        int i3 = sessionInfo.f179555d;
        int i16 = 1;
        if (i3 != 1) {
            if (i3 != 3000) {
                if (i3 != 10014) {
                    i16 = 0;
                } else {
                    BaseQQAppInterface n3 = com.tencent.mobileqq.qwallet.impl.d.n();
                    if (n3 != null) {
                        IRuntimeService runtimeService = n3.getRuntimeService(IGPSService.class, "");
                        Intrinsics.checkNotNullExpressionValue(runtimeService, "appInterface.getRuntimeS\u2026va, ProcessConstant.MAIN)");
                        url = com.tencent.mobileqq.qwallet.utils.impl.a.a(com.tencent.mobileqq.qwallet.utils.impl.a.a(com.tencent.mobileqq.qwallet.utils.impl.a.a(url, "tinyId", ((IGPSService) runtimeService).getSelfTinyId()), "guildId", sessionInfo.f179559f), "subGuildId", sessionInfo.f179557e);
                        i16 = 3;
                    } else {
                        return null;
                    }
                }
            } else {
                i16 = 2;
            }
        }
        return url + "&type=" + i16 + "&uin=" + sessionInfo.f179557e;
    }

    @JvmStatic
    @Nullable
    public static final JSONObject f(int type) {
        PanelEntryData panelEntryData;
        List<PanelEntryData> a16;
        Object obj;
        boolean z16;
        HbPanelConfig hbPanelConfig2 = hbPanelConfig;
        if (hbPanelConfig2 != null && (a16 = hbPanelConfig2.a()) != null) {
            Iterator<T> it = a16.iterator();
            while (true) {
                if (it.hasNext()) {
                    obj = it.next();
                    if (((PanelEntryData) obj).getType() == type) {
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
            panelEntryData = (PanelEntryData) obj;
        } else {
            panelEntryData = null;
        }
        if (panelEntryData == null) {
            return null;
        }
        return panelEntryData.getParams();
    }

    private final String g(p sessionInfo, String url, int type) {
        if (url == null) {
            return null;
        }
        if (type == 1) {
            return d(sessionInfo, url);
        }
        return url;
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0032, code lost:
    
        if (r0 == null) goto L14;
     */
    @JvmStatic
    @NotNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final ArrayList<PanelEntryData> h(@Nullable Integer curType) {
        ArrayList<PanelEntryData> arrayList;
        List<PanelEntryData> a16;
        HbPanelConfig hbPanelConfig2 = hbPanelConfig;
        if (hbPanelConfig2 != null && (a16 = hbPanelConfig2.a()) != null) {
            ArrayList arrayList2 = new ArrayList();
            for (Object obj : a16) {
                if (PanelDataChecker.m(curType, (PanelEntryData) obj)) {
                    arrayList2.add(obj);
                }
            }
            arrayList = bg.f302144a.n(arrayList2);
        }
        arrayList = new ArrayList<>();
        RedPacketManager redPacketManager = f277534a;
        if (!redPacketManager.c(arrayList, 0)) {
            arrayList.add(0, DEFAULT_HB_ENTRY);
        }
        if (!redPacketManager.c(arrayList, 1) && PanelDataChecker.l(curType, null)) {
            arrayList.add(0, LUCK_HB_ENTRY);
        }
        return arrayList;
    }

    private final PanelEntryData i(Hongbao$HbEntry hbEntry) {
        String str = hbEntry.f278695id.get();
        Intrinsics.checkNotNullExpressionValue(str, "hbEntry.id.get()");
        int i3 = hbEntry.hb_entry_type.get();
        String str2 = hbEntry.title.get();
        Intrinsics.checkNotNullExpressionValue(str2, "hbEntry.title.get()");
        String str3 = hbEntry.icon_url.get();
        Intrinsics.checkNotNullExpressionValue(str3, "hbEntry.icon_url.get()");
        return new PanelEntryData(str, i3, str2, str3, (int) hbEntry.aio_scene.get(), hbEntry.params.get());
    }

    private final PanelTabData j(Hongbao$HbTab hbTab) {
        return new PanelTabData(hbTab.f278696id.get(), hbTab.hb_tab_type.get(), hbTab.title.get(), hbTab.url.get());
    }

    @JvmStatic
    public static final void k() {
        try {
            hbPanelConfig = (HbPanelConfig) com.tencent.mobileqq.qwallet.utils.g.h("hb_panel_config", HbPanelConfig.class, null);
        } catch (Throwable th5) {
            QLog.e("RedPacketManager", 1, "readConfig: error ", th5);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final PanelTabData l(PanelTabData panelTabData, p sessionInfo) {
        String id5 = panelTabData.getId();
        int type = panelTabData.getType();
        return new PanelTabData(id5, type, panelTabData.getName(), g(sessionInfo, panelTabData.getUrl(), type));
    }

    @JvmStatic
    public static final void n(@NotNull Function1<? super Boolean, Unit> receiver) {
        Intrinsics.checkNotNullParameter(receiver, "receiver");
        Hongbao$GetRedPacketConfigReq hongbao$GetRedPacketConfigReq = new Hongbao$GetRedPacketConfigReq();
        b bVar = new b(receiver);
        pl2.n nVar = pl2.n.f426457a;
        IQWalletServletApi iQWalletServletApi = (IQWalletServletApi) QRoute.api(IQWalletServletApi.class);
        Object newInstance = Hongbao$GetRedPacketConfigRsp.class.newInstance();
        Intrinsics.checkNotNullExpressionValue(newInstance, "Rsp::class.java.newInstance()");
        iQWalletServletApi.sendGatewayRequest("trpc.qqhb.hbpanel.Hongbao", "SsoGetRedPacketConfig", hongbao$GetRedPacketConfigReq, (MessageMicro) newInstance, false, true, false, bVar);
    }

    private final void o() {
        HbPanelConfig hbPanelConfig2 = hbPanelConfig;
        if (hbPanelConfig2 != null) {
            com.tencent.mobileqq.qwallet.utils.g.p("hb_panel_config", hbPanelConfig2);
        } else {
            com.tencent.mobileqq.qwallet.utils.g.s("hb_panel_config");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean q(PanelTabData panelTabData) {
        boolean z16;
        if (panelTabData == null) {
            return false;
        }
        if (panelTabData.getType() == 1 || panelTabData.getType() == 3) {
            String url = panelTabData.getUrl();
            if (url != null && url.length() != 0) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (z16) {
                return false;
            }
        }
        return true;
    }

    @Nullable
    public final HbPanelConfig e() {
        return hbPanelConfig;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void m(@NotNull final p sessionInfo, @NotNull final a listener) {
        List emptyList;
        List<PanelTabData> b16;
        int collectionSizeOrDefault;
        Intrinsics.checkNotNullParameter(sessionInfo, "sessionInfo");
        Intrinsics.checkNotNullParameter(listener, "listener");
        ArrayList<PanelEntryData> h16 = h(Integer.valueOf(sessionInfo.f179555d));
        HbPanelConfig hbPanelConfig2 = hbPanelConfig;
        if (hbPanelConfig2 == null || (b16 = hbPanelConfig2.b()) == null) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
        } else {
            List<PanelTabData> list = b16;
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
            ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(f277534a.l((PanelTabData) it.next(), sessionInfo));
            }
            emptyList = new ArrayList();
            for (Object obj : arrayList) {
                if (f277534a.q((PanelTabData) obj)) {
                    emptyList.add(obj);
                }
            }
        }
        listener.b(h16, emptyList);
        n(new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.qwallet.hb.panel.RedPacketManager$requestHbPanelData$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return Unit.INSTANCE;
            }

            /* JADX WARN: Multi-variable type inference failed */
            public final void invoke(boolean z16) {
                List emptyList2;
                List<PanelTabData> b17;
                int collectionSizeOrDefault2;
                boolean q16;
                PanelTabData l3;
                List emptyList3;
                List<PanelTabData> b18;
                int collectionSizeOrDefault3;
                boolean q17;
                PanelTabData l16;
                if (z16) {
                    ArrayList<PanelEntryData> h17 = RedPacketManager.h(Integer.valueOf(p.this.f179555d));
                    RedPacketManager.HbPanelConfig e16 = RedPacketManager.f277534a.e();
                    if (e16 == null || (b18 = e16.b()) == null) {
                        emptyList3 = CollectionsKt__CollectionsKt.emptyList();
                    } else {
                        List<PanelTabData> list2 = b18;
                        p pVar = p.this;
                        collectionSizeOrDefault3 = CollectionsKt__IterablesKt.collectionSizeOrDefault(list2, 10);
                        ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault3);
                        Iterator<T> it5 = list2.iterator();
                        while (it5.hasNext()) {
                            l16 = RedPacketManager.f277534a.l((PanelTabData) it5.next(), pVar);
                            arrayList2.add(l16);
                        }
                        emptyList3 = new ArrayList();
                        for (Object obj2 : arrayList2) {
                            q17 = RedPacketManager.f277534a.q((PanelTabData) obj2);
                            if (q17) {
                                emptyList3.add(obj2);
                            }
                        }
                    }
                    listener.a(h17, emptyList3);
                    return;
                }
                ArrayList<PanelEntryData> h18 = RedPacketManager.h(Integer.valueOf(p.this.f179555d));
                RedPacketManager.HbPanelConfig e17 = RedPacketManager.f277534a.e();
                if (e17 == null || (b17 = e17.b()) == null) {
                    emptyList2 = CollectionsKt__CollectionsKt.emptyList();
                } else {
                    List<PanelTabData> list3 = b17;
                    p pVar2 = p.this;
                    collectionSizeOrDefault2 = CollectionsKt__IterablesKt.collectionSizeOrDefault(list3, 10);
                    ArrayList arrayList3 = new ArrayList(collectionSizeOrDefault2);
                    Iterator<T> it6 = list3.iterator();
                    while (it6.hasNext()) {
                        l3 = RedPacketManager.f277534a.l((PanelTabData) it6.next(), pVar2);
                        arrayList3.add(l3);
                    }
                    emptyList2 = new ArrayList();
                    for (Object obj3 : arrayList3) {
                        q16 = RedPacketManager.f277534a.q((PanelTabData) obj3);
                        if (q16) {
                            emptyList2.add(obj3);
                        }
                    }
                }
                listener.c(h18, emptyList2);
            }
        });
    }

    public final void p(@NotNull Hongbao$GetRedPacketConfigRsp rsp) {
        int collectionSizeOrDefault;
        int collectionSizeOrDefault2;
        Intrinsics.checkNotNullParameter(rsp, "rsp");
        List<Hongbao$HbEntry> list = rsp.hb_entrys.get();
        Intrinsics.checkNotNullExpressionValue(list, "rsp.hb_entrys.get()");
        List<Hongbao$HbEntry> list2 = list;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list2, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        for (Hongbao$HbEntry it : list2) {
            RedPacketManager redPacketManager = f277534a;
            Intrinsics.checkNotNullExpressionValue(it, "it");
            arrayList.add(redPacketManager.i(it));
        }
        List<Hongbao$HbTab> list3 = rsp.hb_tabs.get();
        Intrinsics.checkNotNullExpressionValue(list3, "rsp.hb_tabs.get()");
        List<Hongbao$HbTab> list4 = list3;
        collectionSizeOrDefault2 = CollectionsKt__IterablesKt.collectionSizeOrDefault(list4, 10);
        ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault2);
        for (Hongbao$HbTab it5 : list4) {
            RedPacketManager redPacketManager2 = f277534a;
            Intrinsics.checkNotNullExpressionValue(it5, "it");
            arrayList2.add(redPacketManager2.j(it5));
        }
        hbPanelConfig = new HbPanelConfig(arrayList, arrayList2);
        o();
    }
}
