package com.tencent.mobileqq.qwallet.home;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.hippy.qq.utils.HippyReporter;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.api.IQWalletHomeApi;
import com.tencent.mobileqq.qwallet.home.QWalletHomeAdvIPCModule;
import com.tencent.mobileqq.studymode.api.IStudyModeManager;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.troop.api.ITroopUtilApi;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.ntrelation.friendsinfo.api.IFriendsInfoService;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import com.tencent.state.data.SquareJSConst;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\b\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0002&'B\t\b\u0002\u00a2\u0006\u0004\b$\u0010%J\u0006\u0010\u0003\u001a\u00020\u0002J,\u0010\n\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u001c\u0010\t\u001a\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0012\u0006\u0012\u0004\u0018\u00010\b\u0012\u0004\u0012\u00020\u00020\u0006J&\u0010\u0012\u001a\u0004\u0018\u00010\u00112\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016J.\u0010\u0016\u001a\u0012\u0012\u0004\u0012\u00020\u000b0\u0013j\b\u0012\u0004\u0012\u00020\u000b`\u00142\u0016\u0010\u0015\u001a\u0012\u0012\u0004\u0012\u00020\u000b0\u0013j\b\u0012\u0004\u0012\u00020\u000b`\u0014J\u0006\u0010\u0017\u001a\u00020\u0002J!\u0010\u001a\u001a\u00020\u00022\b\u0010\u0018\u001a\u0004\u0018\u00010\u00072\b\u0010\u0019\u001a\u0004\u0018\u00010\b\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u001c\u001a\u00020\u00042\b\u0010\u0018\u001a\u0004\u0018\u00010\u0007J\u0010\u0010\u001d\u001a\u00020\u00022\b\u0010\u0018\u001a\u0004\u0018\u00010\u0007J\u0010\u0010\u001e\u001a\u00020\u00042\b\u0010\u0018\u001a\u0004\u0018\u00010\u0007J\u0010\u0010\u001f\u001a\u00020\u00022\b\u0010\u0018\u001a\u0004\u0018\u00010\u0007R\u0014\u0010#\u001a\u00020 8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b!\u0010\"\u00a8\u0006("}, d2 = {"Lcom/tencent/mobileqq/qwallet/home/QWalletHomeAdvIPCModule;", "Lcom/tencent/mobileqq/qipc/QIPCModule;", "", "j", "", "isMainProcess", "Lkotlin/Function2;", "Lcom/tencent/gdtad/aditem/GdtAd;", "", "callback", "d", "", "action", "Landroid/os/Bundle;", "params", "", "callbackId", "Leipc/EIPCResult;", "onCall", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", SquareJSConst.Params.PARAMS_UIN_LIST, "f", HippyReporter.RemoveEngineReason.CLEAR_CACHE, "gdtAd", "exposureTime", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "(Lcom/tencent/gdtad/aditem/GdtAd;Ljava/lang/Long;)V", tl.h.F, "l", "g", "k", "Lcom/tencent/mobileqq/qwallet/home/QWalletHomeAdvIPCModule$QWalletHomeAdvClient;", "e", "Lcom/tencent/mobileqq/qwallet/home/QWalletHomeAdvIPCModule$QWalletHomeAdvClient;", "advClient", "<init>", "()V", "AdExposeInfo", "QWalletHomeAdvClient", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class QWalletHomeAdvIPCModule extends QIPCModule {

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    public static final QWalletHomeAdvIPCModule f277953d = new QWalletHomeAdvIPCModule();

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final QWalletHomeAdvClient advClient = new QWalletHomeAdvClient();

    @Parcelize
    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0011\b\u0087\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0014\u001a\u00020\u0002\u0012\u0006\u0010\u0019\u001a\u00020\u0015\u0012\u0006\u0010 \u001a\u00020\b\u0012\u0006\u0010#\u001a\u00020\b\u00a2\u0006\u0004\b$\u0010%J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003J\t\u0010\n\u001a\u00020\u0004H\u00d6\u0001J\u0019\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u0004H\u00d6\u0001R\u0017\u0010\u0014\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0019\u001a\u00020\u00158\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\"\u0010 \u001a\u00020\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\"\u0010#\u001a\u00020\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b!\u0010\u001b\u001a\u0004\b\"\u0010\u001d\"\u0004\b\u001a\u0010\u001f\u00a8\u0006&"}, d2 = {"Lcom/tencent/mobileqq/qwallet/home/QWalletHomeAdvIPCModule$AdExposeInfo;", "Landroid/os/Parcelable;", "", "toString", "", "hashCode", "", "other", "", "equals", "describeContents", "Landroid/os/Parcel;", "parcel", WadlProxyConsts.FLAGS, "", "writeToParcel", "d", "Ljava/lang/String;", "e", "()Ljava/lang/String;", "traceId", "", "J", "a", "()J", "exposeTime", "f", "Z", "b", "()Z", "setHasOriginExposed", "(Z)V", "hasOriginExposed", tl.h.F, "c", "hasStrictExposed", "<init>", "(Ljava/lang/String;JZZ)V", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes16.dex */
    public static final /* data */ class AdExposeInfo implements Parcelable {

        @NotNull
        public static final Parcelable.Creator<AdExposeInfo> CREATOR = new a();

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final String traceId;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
        private final long exposeTime;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
        private boolean hasOriginExposed;

        /* renamed from: h, reason: collision with root package name and from kotlin metadata and from toString */
        private boolean hasStrictExposed;

        @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
        /* loaded from: classes16.dex */
        public static final class a implements Parcelable.Creator<AdExposeInfo> {
            @Override // android.os.Parcelable.Creator
            @NotNull
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final AdExposeInfo createFromParcel(@NotNull Parcel parcel) {
                boolean z16;
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                String readString = parcel.readString();
                long readLong = parcel.readLong();
                boolean z17 = false;
                if (parcel.readInt() != 0) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (parcel.readInt() != 0) {
                    z17 = true;
                }
                return new AdExposeInfo(readString, readLong, z16, z17);
            }

            @Override // android.os.Parcelable.Creator
            @NotNull
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public final AdExposeInfo[] newArray(int i3) {
                return new AdExposeInfo[i3];
            }
        }

        public AdExposeInfo(@NotNull String traceId, long j3, boolean z16, boolean z17) {
            Intrinsics.checkNotNullParameter(traceId, "traceId");
            this.traceId = traceId;
            this.exposeTime = j3;
            this.hasOriginExposed = z16;
            this.hasStrictExposed = z17;
        }

        /* renamed from: a, reason: from getter */
        public final long getExposeTime() {
            return this.exposeTime;
        }

        /* renamed from: b, reason: from getter */
        public final boolean getHasOriginExposed() {
            return this.hasOriginExposed;
        }

        /* renamed from: c, reason: from getter */
        public final boolean getHasStrictExposed() {
            return this.hasStrictExposed;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @NotNull
        /* renamed from: e, reason: from getter */
        public final String getTraceId() {
            return this.traceId;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof AdExposeInfo)) {
                return false;
            }
            AdExposeInfo adExposeInfo = (AdExposeInfo) other;
            if (Intrinsics.areEqual(this.traceId, adExposeInfo.traceId) && this.exposeTime == adExposeInfo.exposeTime && this.hasOriginExposed == adExposeInfo.hasOriginExposed && this.hasStrictExposed == adExposeInfo.hasStrictExposed) {
                return true;
            }
            return false;
        }

        public final void f(boolean z16) {
            this.hasStrictExposed = z16;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            int hashCode = ((this.traceId.hashCode() * 31) + androidx.fragment.app.a.a(this.exposeTime)) * 31;
            boolean z16 = this.hasOriginExposed;
            int i3 = 1;
            int i16 = z16;
            if (z16 != 0) {
                i16 = 1;
            }
            int i17 = (hashCode + i16) * 31;
            boolean z17 = this.hasStrictExposed;
            if (!z17) {
                i3 = z17 ? 1 : 0;
            }
            return i17 + i3;
        }

        @NotNull
        public String toString() {
            return "AdExposeInfo(traceId=" + this.traceId + ", exposeTime=" + this.exposeTime + ", hasOriginExposed=" + this.hasOriginExposed + ", hasStrictExposed=" + this.hasStrictExposed + ")";
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel parcel, int flags) {
            Intrinsics.checkNotNullParameter(parcel, "out");
            parcel.writeString(this.traceId);
            parcel.writeLong(this.exposeTime);
            parcel.writeInt(this.hasOriginExposed ? 1 : 0);
            parcel.writeInt(this.hasStrictExposed ? 1 : 0);
        }
    }

    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0001\"B\u0007\u00a2\u0006\u0004\b \u0010!J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0012\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\u0012\u0010\b\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\u0012\u0010\u000b\u001a\u00020\u00062\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0002J&\u0010\u000f\u001a\u00020\u00062\u001e\u0010\u000e\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0006\u0012\u0004\u0018\u00010\r\u0012\u0004\u0012\u00020\u0006\u0018\u00010\fJ$\u0010\u0010\u001a\u00020\u00062\u001c\u0010\u000e\u001a\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0006\u0012\u0004\u0018\u00010\r\u0012\u0004\u0012\u00020\u00060\fJ\u0006\u0010\u0011\u001a\u00020\u0006J!\u0010\u0013\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0012\u001a\u0004\u0018\u00010\r\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0015\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004J\u0010\u0010\u0016\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004J\u0012\u0010\u0017\u001a\u0004\u0018\u00010\t2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004R\u0016\u0010\u001b\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR0\u0010\u001f\u001a\u001e\u0012\u001a\u0012\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0006\u0012\u0004\u0018\u00010\r\u0012\u0004\u0012\u00020\u00060\f0\u001c8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001e\u00a8\u0006#"}, d2 = {"Lcom/tencent/mobileqq/qwallet/home/QWalletHomeAdvIPCModule$QWalletHomeAdvClient;", "", "", "g", "Lcom/tencent/gdtad/aditem/GdtAd;", "gdtAd", "", "d", "j", "Lcom/tencent/mobileqq/qwallet/home/QWalletHomeAdvIPCModule$AdExposeInfo;", "adExposeInfo", "k", "Lkotlin/Function2;", "", "callback", "i", "f", tl.h.F, "exposureTime", DomainData.DOMAIN_NAME, "(Lcom/tencent/gdtad/aditem/GdtAd;Ljava/lang/Long;)V", "l", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "e", "Lcom/tencent/mobileqq/qwallet/home/QWalletHomeAdvIPCModule$QWalletHomeAdvClient$State;", "a", "Lcom/tencent/mobileqq/qwallet/home/QWalletHomeAdvIPCModule$QWalletHomeAdvClient$State;", "state", "", "b", "Ljava/util/List;", "callbackList", "<init>", "()V", "State", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes16.dex */
    public static final class QWalletHomeAdvClient {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private State state = State.NONE;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final List<Function2<GdtAd, Long, Unit>> callbackList = new ArrayList();

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/mobileqq/qwallet/home/QWalletHomeAdvIPCModule$QWalletHomeAdvClient$State;", "", "(Ljava/lang/String;I)V", "NONE", "REQUESTING", "RESPONSE", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
        /* loaded from: classes16.dex */
        public enum State {
            NONE,
            REQUESTING,
            RESPONSE
        }

        @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
        /* loaded from: classes16.dex */
        public /* synthetic */ class a {

            /* renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f277961a;

            static {
                int[] iArr = new int[State.values().length];
                try {
                    iArr[State.NONE.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[State.REQUESTING.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[State.RESPONSE.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                f277961a = iArr;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final synchronized void d(GdtAd gdtAd) {
            Long l3;
            int i3 = a.f277961a[this.state.ordinal()];
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 == 3) {
                        Iterator<T> it = this.callbackList.iterator();
                        while (it.hasNext()) {
                            Function2 function2 = (Function2) it.next();
                            AdExposeInfo e16 = e(gdtAd);
                            if (e16 != null) {
                                l3 = Long.valueOf(e16.getExposeTime());
                            } else {
                                l3 = null;
                            }
                            function2.invoke(gdtAd, l3);
                        }
                        this.callbackList.clear();
                    }
                }
            } else {
                Iterator<T> it5 = this.callbackList.iterator();
                while (it5.hasNext()) {
                    ((Function2) it5.next()).invoke(null, null);
                }
                this.callbackList.clear();
            }
        }

        private final boolean g() {
            if (this.state == State.RESPONSE && com.tencent.mobileqq.qwallet.utils.g.a("qwallet_home_gdt_ad")) {
                return true;
            }
            return false;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void j(GdtAd gdtAd) {
            if (gdtAd == null) {
                return;
            }
            com.tencent.mobileqq.qwallet.utils.g.p("qwallet_home_gdt_ad", gdtAd);
        }

        private final void k(AdExposeInfo adExposeInfo) {
            if (adExposeInfo == null) {
                return;
            }
            com.tencent.mobileqq.qwallet.utils.g.p("qwallet_home_gdt_ad_expose_info", adExposeInfo);
        }

        @Nullable
        public final AdExposeInfo e(@Nullable GdtAd gdtAd) {
            AdExposeInfo adExposeInfo;
            if (gdtAd == null || (adExposeInfo = (AdExposeInfo) com.tencent.mobileqq.qwallet.utils.g.h("qwallet_home_gdt_ad_expose_info", AdExposeInfo.class, null)) == null || !Intrinsics.areEqual(adExposeInfo.getTraceId(), gdtAd.getTraceId())) {
                return null;
            }
            return adExposeInfo;
        }

        public final void f(@NotNull Function2<? super GdtAd, ? super Long, Unit> callback) {
            Intrinsics.checkNotNullParameter(callback, "callback");
            this.callbackList.add(callback);
            String str = null;
            GdtAd gdtAd = (GdtAd) com.tencent.mobileqq.qwallet.utils.g.h("qwallet_home_gdt_ad", GdtAd.class, null);
            State state = this.state;
            if (gdtAd != null) {
                str = gdtAd.getTraceId();
            }
            QLog.i(IQWalletHomeApi.QWALLET_HOME_ADV_MODULE_NAME, 1, "getGdtAd, current state=" + state + ", traceId=" + str);
            d(gdtAd);
        }

        public final void h() {
            this.state = State.NONE;
            this.callbackList.clear();
            com.tencent.mobileqq.qwallet.utils.g.s("qwallet_home_gdt_ad");
            com.tencent.mobileqq.qwallet.utils.g.s("qwallet_home_gdt_ad_expose_info");
        }

        public final void i(@Nullable Function2<? super GdtAd, ? super Long, Unit> callback) {
            if (callback != null) {
                this.callbackList.add(callback);
            }
            if (!g()) {
                State state = this.state;
                State state2 = State.REQUESTING;
                if (state != state2) {
                    this.state = state2;
                    com.tencent.mobileqq.qwallet.ad.q.f277085a.a("4091569797816435", new Function1<GdtAd, Unit>() { // from class: com.tencent.mobileqq.qwallet.home.QWalletHomeAdvIPCModule$QWalletHomeAdvClient$requestAd$1
                        /* JADX INFO: Access modifiers changed from: package-private */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(GdtAd gdtAd) {
                            invoke2(gdtAd);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(@Nullable GdtAd gdtAd) {
                            QLog.i(IQWalletHomeApi.QWALLET_HOME_ADV_MODULE_NAME, 1, "request ad finish, traceId=" + (gdtAd != null ? gdtAd.getTraceId() : null));
                            QWalletHomeAdvIPCModule.QWalletHomeAdvClient.this.j(gdtAd);
                            QWalletHomeAdvIPCModule.QWalletHomeAdvClient.this.state = QWalletHomeAdvIPCModule.QWalletHomeAdvClient.State.RESPONSE;
                            QWalletHomeAdvIPCModule.QWalletHomeAdvClient.this.d(gdtAd);
                        }
                    });
                    return;
                }
            }
            QLog.w(IQWalletHomeApi.QWALLET_HOME_ADV_MODULE_NAME, 1, "request ad abort, state=" + this.state);
        }

        public final synchronized void l(@Nullable GdtAd gdtAd) {
            String traceId;
            if (gdtAd != null) {
                try {
                    traceId = gdtAd.getTraceId();
                } finally {
                }
            } else {
                traceId = null;
            }
            String str = traceId;
            if (str != null && g()) {
                QLog.d(IQWalletHomeApi.QWALLET_HOME_ADV_MODULE_NAME, 1, "setHasOriginalExposed: " + str);
                AdExposeInfo e16 = e(gdtAd);
                if (e16 != null && !Intrinsics.areEqual(e16.getTraceId(), gdtAd.getTraceId())) {
                    QLog.w(IQWalletHomeApi.QWALLET_HOME_ADV_MODULE_NAME, 1, "setHasOriginalExposed ignored, cache:" + e16.getTraceId() + " new:" + gdtAd.getTraceId());
                    return;
                }
                if (e16 == null) {
                    e16 = new AdExposeInfo(str, 0L, true, false);
                }
                k(e16);
            }
        }

        public final synchronized void m(@Nullable GdtAd gdtAd) {
            String traceId;
            Boolean bool = null;
            if (gdtAd != null) {
                try {
                    traceId = gdtAd.getTraceId();
                } finally {
                }
            } else {
                traceId = null;
            }
            if (traceId != null && g()) {
                QLog.d(IQWalletHomeApi.QWALLET_HOME_ADV_MODULE_NAME, 1, "setHasStrictExposed: " + traceId);
                AdExposeInfo e16 = e(gdtAd);
                if (e16 != null && (!Intrinsics.areEqual(e16.getTraceId(), gdtAd.getTraceId()) || !e16.getHasStrictExposed())) {
                    e16.f(true);
                    k(e16);
                    return;
                }
                if (e16 != null) {
                    bool = Boolean.valueOf(e16.getHasStrictExposed());
                }
                QLog.w(IQWalletHomeApi.QWALLET_HOME_ADV_MODULE_NAME, 1, "setHasStrictExposed ignored, cache:" + bool);
            }
        }

        public final synchronized void n(@Nullable GdtAd gdtAd, @Nullable Long exposureTime) {
            String traceId;
            String str;
            boolean z16;
            long j3;
            Long l3 = null;
            if (gdtAd != null) {
                try {
                    traceId = gdtAd.getTraceId();
                } finally {
                }
            } else {
                traceId = null;
            }
            if (traceId != null && exposureTime != null && g()) {
                QLog.d(IQWalletHomeApi.QWALLET_HOME_ADV_MODULE_NAME, 1, "updateExposureTime: " + traceId + " " + exposureTime);
                AdExposeInfo e16 = e(gdtAd);
                if (e16 != null) {
                    str = e16.getTraceId();
                } else {
                    str = null;
                }
                if (Intrinsics.areEqual(str, gdtAd.getTraceId())) {
                    if (e16 != null) {
                        j3 = e16.getExposeTime();
                    } else {
                        j3 = 0;
                    }
                    if (j3 > exposureTime.longValue()) {
                        if (e16 != null) {
                            l3 = Long.valueOf(e16.getExposeTime());
                        }
                        QLog.w(IQWalletHomeApi.QWALLET_HOME_ADV_MODULE_NAME, 1, "updateExposureTime ignored, cache:" + l3 + " new:" + exposureTime);
                        return;
                    }
                }
                long longValue = exposureTime.longValue();
                boolean z17 = false;
                if (e16 != null) {
                    z16 = e16.getHasOriginExposed();
                } else {
                    z16 = false;
                }
                if (e16 != null) {
                    z17 = e16.getHasStrictExposed();
                }
                k(new AdExposeInfo(traceId, longValue, z16, z17));
            }
        }
    }

    QWalletHomeAdvIPCModule() {
        super(IQWalletHomeApi.QWALLET_HOME_ADV_MODULE_NAME);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(Function2 callback, GdtAd gdtAd, EIPCResult eIPCResult) {
        GdtAd gdtAd2;
        Intrinsics.checkNotNullParameter(callback, "$callback");
        boolean z16 = false;
        if (eIPCResult != null && eIPCResult.isSuccess()) {
            z16 = true;
        }
        Long l3 = null;
        if (z16 && (gdtAd2 = (GdtAd) eIPCResult.data.getParcelable("ipc_bundle_key_adv_result")) != null) {
            AdExposeInfo e16 = advClient.e(gdtAd);
            if (e16 != null) {
                l3 = Long.valueOf(e16.getExposeTime());
            }
            callback.invoke(gdtAd2, l3);
            return;
        }
        callback.invoke(null, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(ArrayList arrayList, Bundle retBundle, int i3, Boolean bool, List list) {
        Intrinsics.checkNotNullParameter(retBundle, "$retBundle");
        if (list.isEmpty()) {
            QWalletHomeAdvIPCModule qWalletHomeAdvIPCModule = f277953d;
            retBundle.putStringArrayList("key_member_uin_info_list", qWalletHomeAdvIPCModule.f(arrayList));
            qWalletHomeAdvIPCModule.callbackResult(i3, EIPCResult.createSuccessResult(retBundle));
            return;
        }
        ArrayList<String> arrayList2 = new ArrayList<>();
        for (Object obj : list) {
            if (obj instanceof TroopMemberInfo) {
                TroopMemberInfo troopMemberInfo = (TroopMemberInfo) obj;
                arrayList2.add(troopMemberInfo.memberuin);
                arrayList2.add(troopMemberInfo.nickInfo.getHBShowName());
            }
        }
        retBundle.putStringArrayList("key_member_uin_info_list", arrayList2);
        f277953d.callbackResult(i3, EIPCResult.createSuccessResult(retBundle));
    }

    public final void clearCache() {
        QLog.i(IQWalletHomeApi.QWALLET_HOME_ADV_MODULE_NAME, 1, HippyReporter.RemoveEngineReason.CLEAR_CACHE);
        advClient.h();
    }

    public final void d(boolean isMainProcess, @NotNull final Function2<? super GdtAd, ? super Long, Unit> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        Long l3 = null;
        final GdtAd gdtAd = (GdtAd) com.tencent.mobileqq.qwallet.utils.g.h("qwallet_home_gdt_ad", GdtAd.class, null);
        if (gdtAd != null) {
            QLog.i(IQWalletHomeApi.QWALLET_HOME_ADV_MODULE_NAME, 1, "hit pre get adv cache");
            AdExposeInfo e16 = advClient.e(gdtAd);
            if (e16 != null) {
                l3 = Long.valueOf(e16.getExposeTime());
            }
            callback.invoke(gdtAd, l3);
            return;
        }
        if (isMainProcess) {
            advClient.f(callback);
        } else {
            QIPCClientHelper.getInstance().getClient().callServer(IQWalletHomeApi.QWALLET_HOME_ADV_MODULE_NAME, "action_get_adv", null, new EIPCResultCallback() { // from class: com.tencent.mobileqq.qwallet.home.k
                @Override // eipc.EIPCResultCallback
                public final void onCallback(EIPCResult eIPCResult) {
                    QWalletHomeAdvIPCModule.e(Function2.this, gdtAd, eIPCResult);
                }
            });
        }
    }

    @NotNull
    public final ArrayList<String> f(@NotNull ArrayList<String> uinList) {
        boolean z16;
        Intrinsics.checkNotNullParameter(uinList, "uinList");
        ArrayList<String> arrayList = new ArrayList<>();
        Iterator<String> it = uinList.iterator();
        while (it.hasNext()) {
            String uinList2 = it.next();
            Intrinsics.checkNotNullExpressionValue(uinList2, "uinList");
            arrayList.add(((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(uinList2));
        }
        ArrayList<com.tencent.qqnt.ntrelation.friendsinfo.bean.d> friendSimpleInfoWithUid = ((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).getFriendSimpleInfoWithUid(arrayList, "QWalletIPCModule");
        if (friendSimpleInfoWithUid == null) {
            return new ArrayList<>();
        }
        ArrayList<String> arrayList2 = new ArrayList<>();
        Iterator<com.tencent.qqnt.ntrelation.friendsinfo.bean.d> it5 = friendSimpleInfoWithUid.iterator();
        while (it5.hasNext()) {
            com.tencent.qqnt.ntrelation.friendsinfo.bean.d next = it5.next();
            arrayList2.add(next.x());
            String r16 = next.r();
            String p16 = next.p();
            boolean z17 = false;
            if (!Intrinsics.areEqual(next.x(), com.tencent.mobileqq.base.a.c())) {
                if (r16 != null && r16.length() != 0) {
                    z16 = false;
                } else {
                    z16 = true;
                }
                if (!z16) {
                    arrayList2.add(r16);
                }
            }
            if (p16 == null || p16.length() == 0) {
                z17 = true;
            }
            if (!z17) {
                arrayList2.add(p16);
            } else {
                arrayList2.add(next.x());
            }
        }
        return arrayList2;
    }

    public final boolean g(@Nullable GdtAd gdtAd) {
        AdExposeInfo e16;
        if (gdtAd == null || (e16 = advClient.e(gdtAd)) == null) {
            return false;
        }
        return e16.getHasOriginExposed();
    }

    public final boolean h(@Nullable GdtAd gdtAd) {
        AdExposeInfo e16;
        if (gdtAd == null || (e16 = advClient.e(gdtAd)) == null) {
            return false;
        }
        return e16.getHasStrictExposed();
    }

    public final void j() {
        if (((IStudyModeManager) QRoute.api(IStudyModeManager.class)).getStudyModeSwitch()) {
            return;
        }
        QLog.i(IQWalletHomeApi.QWALLET_HOME_ADV_MODULE_NAME, 1, "start pre requestAdv");
        clearCache();
        advClient.i(null);
    }

    public final void k(@Nullable GdtAd gdtAd) {
        advClient.l(gdtAd);
    }

    public final void l(@Nullable GdtAd gdtAd) {
        advClient.m(gdtAd);
    }

    public final void m(@Nullable GdtAd gdtAd, @Nullable Long exposureTime) {
        advClient.n(gdtAd, exposureTime);
    }

    @Override // eipc.EIPCModule
    @Nullable
    public EIPCResult onCall(@Nullable String action, @Nullable Bundle params, final int callbackId) {
        String str;
        final ArrayList<String> arrayList;
        QLog.i(IQWalletHomeApi.QWALLET_HOME_ADV_MODULE_NAME, 1, "action=" + action + ", params=" + params + ", callbackId=" + callbackId);
        if (Intrinsics.areEqual(action, "action_get_adv")) {
            advClient.f(new Function2<GdtAd, Long, Unit>() { // from class: com.tencent.mobileqq.qwallet.home.QWalletHomeAdvIPCModule$onCall$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(GdtAd gdtAd, Long l3) {
                    invoke2(gdtAd, l3);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@Nullable GdtAd gdtAd, @Nullable Long l3) {
                    Bundle bundle = new Bundle();
                    if (gdtAd != null) {
                        bundle.putParcelable("ipc_bundle_key_adv_result", gdtAd);
                        QWalletHomeAdvIPCModule.f277953d.callbackResult(callbackId, EIPCResult.createSuccessResult(bundle));
                    } else {
                        QWalletHomeAdvIPCModule.f277953d.callbackResult(callbackId, EIPCResult.createResult(-102, bundle));
                    }
                }
            });
        } else if (Intrinsics.areEqual(action, "action_get_troop_member_list_info")) {
            if (params != null) {
                str = params.getString("key_troop_uin");
            } else {
                str = null;
            }
            if (params != null) {
                arrayList = params.getStringArrayList("key_member_uin_list");
            } else {
                arrayList = null;
            }
            final Bundle bundle = new Bundle();
            if (arrayList == null) {
                callbackResult(callbackId, EIPCResult.createResult(-102, bundle));
                return null;
            }
            ((ITroopUtilApi) QRoute.api(ITroopUtilApi.class)).fetchTroopMemberInfoByUins(str, arrayList, false, null, IQWalletHomeApi.QWALLET_HOME_ADV_MODULE_NAME, new com.tencent.mobileqq.troop.d() { // from class: com.tencent.mobileqq.qwallet.home.l
                @Override // com.tencent.mobileqq.troop.d
                public final void a(Boolean bool, List list) {
                    QWalletHomeAdvIPCModule.i(arrayList, bundle, callbackId, bool, list);
                }
            });
        }
        return null;
    }
}
