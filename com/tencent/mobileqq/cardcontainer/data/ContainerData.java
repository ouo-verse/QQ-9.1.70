package com.tencent.mobileqq.cardcontainer.data;

import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\b\u0016\u0018\u0000 \"2\u00020\u0001:\u0001\tBm\u0012\u0006\u0010\u0014\u001a\u00020\u0010\u0012\u0006\u0010\u0018\u001a\u00020\u0004\u0012\u0006\u0010\u001c\u001a\u00020\f\u0012\b\u0010\u001e\u001a\u0004\u0018\u00010\f\u0012\b\u0010!\u001a\u0004\u0018\u00010\f\u0012\b\u0010#\u001a\u0004\u0018\u00010\f\u0012\u001a\u0010*\u001a\u0016\u0012\u0004\u0012\u00020%\u0018\u00010$j\n\u0012\u0004\u0012\u00020%\u0018\u0001`&\u0012\b\u0010,\u001a\u0004\u0018\u00010\f\u0012\b\u0010.\u001a\u0004\u0018\u00010\f\u00a2\u0006\u0004\b3\u00104B\u0011\b\u0016\u0012\u0006\u00105\u001a\u00020\u0000\u00a2\u0006\u0004\b3\u00106J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0001H\u0016J\u0010\u0010\t\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0001H\u0016J\b\u0010\n\u001a\u00020\u0002H\u0016J\b\u0010\u000b\u001a\u00020\u0007H\u0016J\u0006\u0010\r\u001a\u00020\fJ\u0006\u0010\u000e\u001a\u00020\fJ\b\u0010\u000f\u001a\u00020\fH\u0016R\u0017\u0010\u0014\u001a\u00020\u00108\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0018\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0017\u0010\u001c\u001a\u00020\f8\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u0019\u0010\u001e\u001a\u0004\u0018\u00010\f8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u0019\u001a\u0004\b\u001d\u0010\u001bR\u0019\u0010!\u001a\u0004\u0018\u00010\f8\u0006\u00a2\u0006\f\n\u0004\b\u001f\u0010\u0019\u001a\u0004\b \u0010\u001bR\u0019\u0010#\u001a\u0004\u0018\u00010\f8\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0019\u001a\u0004\b\"\u0010\u001bR+\u0010*\u001a\u0016\u0012\u0004\u0012\u00020%\u0018\u00010$j\n\u0012\u0004\u0012\u00020%\u0018\u0001`&8\u0006\u00a2\u0006\f\n\u0004\b\u001a\u0010'\u001a\u0004\b(\u0010)R\u0019\u0010,\u001a\u0004\u0018\u00010\f8\u0006\u00a2\u0006\f\n\u0004\b(\u0010\u0019\u001a\u0004\b+\u0010\u001bR\u0019\u0010.\u001a\u0004\u0018\u00010\f8\u0006\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0019\u001a\u0004\b-\u0010\u001bR\u001b\u00102\u001a\u00020\u00028BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001d\u0010/\u001a\u0004\b0\u00101\u00a8\u00067"}, d2 = {"Lcom/tencent/mobileqq/cardcontainer/data/ContainerData;", "Lcom/tencent/mobileqq/cardcontainer/data/a;", "", "f", "Lcom/tencent/mobileqq/cardcontainer/data/CardType;", "c", "other", "", "b", "a", "d", ReportConstant.COSTREPORT_PREFIX, "", "r", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "toString", "", "I", DomainData.DOMAIN_NAME, "()I", "dataId", "Lcom/tencent/mobileqq/cardcontainer/data/CardType;", "i", "()Lcom/tencent/mobileqq/cardcontainer/data/CardType;", "cardType", "Ljava/lang/String;", "g", "()Ljava/lang/String;", "busiName", "j", "containerBg", "e", "l", "containerTitle", "k", "containerSummary", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/cardcontainer/data/b;", "Lkotlin/collections/ArrayList;", "Ljava/util/ArrayList;", h.F, "()Ljava/util/ArrayList;", "cardItemList", "o", "extraInfo", "p", "reportData", "Lkotlin/Lazy;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "()J", "contentHash", "<init>", "(ILcom/tencent/mobileqq/cardcontainer/data/CardType;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/ArrayList;Ljava/lang/String;Ljava/lang/String;)V", "data", "(Lcom/tencent/mobileqq/cardcontainer/data/ContainerData;)V", "cardcontainer_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public class ContainerData extends a {
    static IPatchRedirector $redirector_;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final int dataId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final CardType cardType;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String busiName;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final String containerBg;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final String containerTitle;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final String containerSummary;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final ArrayList<b> cardItemList;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final String extraInfo;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final String reportData;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy contentHash;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/cardcontainer/data/ContainerData$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "cardcontainer_api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.cardcontainer.data.ContainerData$a, reason: from kotlin metadata */
    /* loaded from: classes11.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(36312);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 20)) {
            redirector.redirect((short) 20);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public ContainerData(int i3, @NotNull CardType cardType, @NotNull String busiName, @Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable ArrayList<b> arrayList, @Nullable String str4, @Nullable String str5) {
        Lazy lazy;
        Intrinsics.checkNotNullParameter(cardType, "cardType");
        Intrinsics.checkNotNullParameter(busiName, "busiName");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), cardType, busiName, str, str2, str3, arrayList, str4, str5);
            return;
        }
        this.dataId = i3;
        this.cardType = cardType;
        this.busiName = busiName;
        this.containerBg = str;
        this.containerTitle = str2;
        this.containerSummary = str3;
        this.cardItemList = arrayList;
        this.extraInfo = str4;
        this.reportData = str5;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<Long>() { // from class: com.tencent.mobileqq.cardcontainer.data.ContainerData$contentHash$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) ContainerData.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Long invoke() {
                long f16;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (Long) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
                f16 = ContainerData.this.f();
                return Long.valueOf(f16);
            }
        });
        this.contentHash = lazy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final long f() {
        int i3;
        int i16;
        int i17;
        int i18;
        int i19;
        int hashCode = ((((this.dataId * 31) + this.cardType.hashCode()) * 31) + this.busiName.hashCode()) * 31;
        String str = this.containerTitle;
        if (str != null) {
            i3 = str.hashCode();
        } else {
            i3 = 0;
        }
        int i26 = (hashCode + i3) * 31;
        String str2 = this.containerSummary;
        if (str2 != null) {
            i16 = str2.hashCode();
        } else {
            i16 = 0;
        }
        int i27 = (i26 + i16) * 31;
        String str3 = this.extraInfo;
        if (str3 != null) {
            i17 = str3.hashCode();
        } else {
            i17 = 0;
        }
        int i28 = (i27 + i17) * 31;
        String str4 = this.reportData;
        if (str4 != null) {
            i18 = str4.hashCode();
        } else {
            i18 = 0;
        }
        int i29 = i28 + i18;
        ArrayList<b> arrayList = this.cardItemList;
        if (arrayList != null) {
            Iterator<b> it = arrayList.iterator();
            while (it.hasNext()) {
                b next = it.next();
                int hashCode2 = ((i29 * 31) + next.c().hashCode()) * 31;
                String e16 = next.e();
                if (e16 != null) {
                    i19 = e16.hashCode();
                } else {
                    i19 = 0;
                }
                i29 = hashCode2 + i19;
            }
        }
        return i29;
    }

    private final long m() {
        return ((Number) this.contentHash.getValue()).longValue();
    }

    @Override // com.tencent.mobileqq.cardcontainer.data.a
    public boolean a(@NotNull a other) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Boolean) iPatchRedirector.redirect((short) 14, (Object) this, (Object) other)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(other, "other");
        if (!(other instanceof ContainerData)) {
            return false;
        }
        ContainerData containerData = (ContainerData) other;
        if (containerData.dataId != this.dataId || containerData.cardType != this.cardType || !Intrinsics.areEqual(containerData.containerBg, this.containerBg) || !Intrinsics.areEqual(containerData.containerTitle, this.containerTitle) || !Intrinsics.areEqual(containerData.containerSummary, this.containerSummary) || !Intrinsics.areEqual(containerData.extraInfo, this.extraInfo) || !Intrinsics.areEqual(containerData.reportData, this.reportData) || !Intrinsics.areEqual(containerData.cardItemList, this.cardItemList)) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.mobileqq.cardcontainer.data.a
    public boolean b(@NotNull a other) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Boolean) iPatchRedirector.redirect((short) 13, (Object) this, (Object) other)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(other, "other");
        if (m() == ((ContainerData) other).m()) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.cardcontainer.data.a
    @NotNull
    public CardType c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (CardType) iPatchRedirector.redirect((short) 12, (Object) this);
        }
        return this.cardType;
    }

    @Override // com.tencent.mobileqq.cardcontainer.data.a
    public long d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Long) iPatchRedirector.redirect((short) 15, (Object) this)).longValue();
        }
        return m();
    }

    @NotNull
    public final String g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.busiName;
    }

    @Nullable
    public final ArrayList<b> h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (ArrayList) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return this.cardItemList;
    }

    @NotNull
    public final CardType i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (CardType) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.cardType;
    }

    @Nullable
    public final String j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.containerBg;
    }

    @Nullable
    public final String k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (String) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return this.containerSummary;
    }

    @Nullable
    public final String l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.containerTitle;
    }

    public final int n() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return this.dataId;
    }

    @Nullable
    public final String o() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (String) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return this.extraInfo;
    }

    @Nullable
    public final String p() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (String) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        return this.reportData;
    }

    @NotNull
    public final String q() {
        Object first;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return (String) iPatchRedirector.redirect((short) 18, (Object) this);
        }
        ArrayList<b> arrayList = this.cardItemList;
        if (arrayList != null && arrayList.size() == 1) {
            first = CollectionsKt___CollectionsKt.first((List<? extends Object>) arrayList);
            return ((b) first).d();
        }
        return "";
    }

    @NotNull
    public final String r() {
        Object first;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return (String) iPatchRedirector.redirect((short) 17, (Object) this);
        }
        ArrayList<b> arrayList = this.cardItemList;
        if (arrayList != null && arrayList.size() == 1) {
            first = CollectionsKt___CollectionsKt.first((List<? extends Object>) arrayList);
            return ((b) first).c();
        }
        return "";
    }

    public boolean s() {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return ((Boolean) iPatchRedirector.redirect((short) 16, (Object) this)).booleanValue();
        }
        ArrayList<b> arrayList = this.cardItemList;
        if (arrayList != null) {
            i3 = arrayList.size();
        } else {
            i3 = 0;
        }
        if (i3 <= 1) {
            return false;
        }
        return true;
    }

    @NotNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return (String) iPatchRedirector.redirect((short) 19, (Object) this);
        }
        return "ContainerData(dataId=" + this.dataId + ", cardType=" + this.cardType + ", busiName='" + this.busiName + "', containerTitle=" + this.containerTitle + ", containerSummary=" + this.containerSummary + ",";
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ContainerData(@NotNull ContainerData data) {
        this(data.dataId, data.cardType, data.busiName, data.containerBg, data.containerTitle, data.containerSummary, data.cardItemList, data.extraInfo, data.reportData);
        Intrinsics.checkNotNullParameter(data, "data");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 11)) {
            return;
        }
        iPatchRedirector.redirect((short) 11, (Object) this, (Object) data);
    }
}
