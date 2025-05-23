package com.tencent.mobileqq.vas.vipicon.api;

import android.view.View;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\bg\u0018\u0000 \u00122\u00020\u0001:\u0002\u0012\u0013J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H&J \u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0006\u001a\u00020\u0005H&J \u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H&J \u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u0005H\u0016\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/vas/vipicon/api/IVipIconClick;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "newClickListener", "Landroid/view/View$OnClickListener;", "uin", "", "from", NodeProps.ON_CLICK, "", "v", "Landroid/view/View;", "info", "Lcom/tencent/mobileqq/vas/vipicon/api/IVipIconClick$Info;", "report04586", "", "id", "", "isClick", "Companion", "Info", "vas_api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@QAPI(process = {"all"})
/* loaded from: classes20.dex */
public interface IVipIconClick extends QRouteApi {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = Companion.$$INSTANCE;

    @NotNull
    public static final String FROM_AIO_CHATSETTINGS = "VIA_AIO_CHATSETTINGS";

    @NotNull
    public static final String FROM_AIO_TITLE = "VIA_AIO_TITLE";

    @NotNull
    public static final String FROM_PROFILECARD = "VIA_PROFILECARD";

    @NotNull
    public static final String FROM_SETTINGME = "VIA_SETTINGME";

    @NotNull
    public static final String FROM_TROOP_AIO_LIST = "VIA_TROOP_AIO_LIST";

    @NotNull
    public static final String FROM_TROOP_AIO_MSG = "VIA_TROOP_AIO_MSG";

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/vas/vipicon/api/IVipIconClick$Companion;", "", "()V", "FROM_AIO_CHATSETTINGS", "", "FROM_AIO_TITLE", "FROM_PROFILECARD", "FROM_SETTINGME", "FROM_TROOP_AIO_LIST", "FROM_TROOP_AIO_MSG", "vas_api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes20.dex */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        @NotNull
        public static final String FROM_AIO_CHATSETTINGS = "VIA_AIO_CHATSETTINGS";

        @NotNull
        public static final String FROM_AIO_TITLE = "VIA_AIO_TITLE";

        @NotNull
        public static final String FROM_PROFILECARD = "VIA_PROFILECARD";

        @NotNull
        public static final String FROM_SETTINGME = "VIA_SETTINGME";

        @NotNull
        public static final String FROM_TROOP_AIO_LIST = "VIA_TROOP_AIO_LIST";

        @NotNull
        public static final String FROM_TROOP_AIO_MSG = "VIA_TROOP_AIO_MSG";

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes20.dex */
    public static final class DefaultImpls {
        public static void report04586(@NotNull IVipIconClick iVipIconClick, int i3, boolean z16, @NotNull String from) {
            Intrinsics.checkNotNullParameter(from, "from");
        }
    }

    @NotNull
    View.OnClickListener newClickListener(@NotNull String uin, @NotNull String from);

    boolean onClick(@NotNull View v3, @NotNull Info info, @NotNull String from);

    boolean onClick(@NotNull View v3, @NotNull String uin, @NotNull String from);

    void report04586(int id5, boolean isClick, @NotNull String from);

    /* compiled from: P */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0013\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u00a2\u0006\u0002\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0013\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u0014\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u0015\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u0016\u001a\u00020\tH\u00c6\u0003J;\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\tH\u00c6\u0001J\u0013\u0010\u0018\u001a\u00020\t2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u001a\u001a\u00020\u0005H\u00d6\u0001J\t\u0010\u001b\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0007\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\b\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\f\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/mobileqq/vas/vipicon/api/IVipIconClick$Info;", "", "uin", "", "vipType", "", "namePlateId", "grayNameplateFlag", "isStar", "", "(Ljava/lang/String;IIIZ)V", "getGrayNameplateFlag", "()I", "()Z", "getNamePlateId", "getUin", "()Ljava/lang/String;", "getVipType", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "toString", "vas_api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes20.dex */
    public static final /* data */ class Info {
        private final int grayNameplateFlag;
        private final boolean isStar;
        private final int namePlateId;

        @NotNull
        private final String uin;
        private final int vipType;

        public Info(@NotNull String uin, int i3, int i16, int i17, boolean z16) {
            Intrinsics.checkNotNullParameter(uin, "uin");
            this.uin = uin;
            this.vipType = i3;
            this.namePlateId = i16;
            this.grayNameplateFlag = i17;
            this.isStar = z16;
        }

        public static /* synthetic */ Info copy$default(Info info, String str, int i3, int i16, int i17, boolean z16, int i18, Object obj) {
            if ((i18 & 1) != 0) {
                str = info.uin;
            }
            if ((i18 & 2) != 0) {
                i3 = info.vipType;
            }
            int i19 = i3;
            if ((i18 & 4) != 0) {
                i16 = info.namePlateId;
            }
            int i26 = i16;
            if ((i18 & 8) != 0) {
                i17 = info.grayNameplateFlag;
            }
            int i27 = i17;
            if ((i18 & 16) != 0) {
                z16 = info.isStar;
            }
            return info.copy(str, i19, i26, i27, z16);
        }

        @NotNull
        /* renamed from: component1, reason: from getter */
        public final String getUin() {
            return this.uin;
        }

        /* renamed from: component2, reason: from getter */
        public final int getVipType() {
            return this.vipType;
        }

        /* renamed from: component3, reason: from getter */
        public final int getNamePlateId() {
            return this.namePlateId;
        }

        /* renamed from: component4, reason: from getter */
        public final int getGrayNameplateFlag() {
            return this.grayNameplateFlag;
        }

        /* renamed from: component5, reason: from getter */
        public final boolean getIsStar() {
            return this.isStar;
        }

        @NotNull
        public final Info copy(@NotNull String uin, int vipType, int namePlateId, int grayNameplateFlag, boolean isStar) {
            Intrinsics.checkNotNullParameter(uin, "uin");
            return new Info(uin, vipType, namePlateId, grayNameplateFlag, isStar);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Info)) {
                return false;
            }
            Info info = (Info) other;
            if (Intrinsics.areEqual(this.uin, info.uin) && this.vipType == info.vipType && this.namePlateId == info.namePlateId && this.grayNameplateFlag == info.grayNameplateFlag && this.isStar == info.isStar) {
                return true;
            }
            return false;
        }

        public final int getGrayNameplateFlag() {
            return this.grayNameplateFlag;
        }

        public final int getNamePlateId() {
            return this.namePlateId;
        }

        @NotNull
        public final String getUin() {
            return this.uin;
        }

        public final int getVipType() {
            return this.vipType;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            int hashCode = ((((((this.uin.hashCode() * 31) + this.vipType) * 31) + this.namePlateId) * 31) + this.grayNameplateFlag) * 31;
            boolean z16 = this.isStar;
            int i3 = z16;
            if (z16 != 0) {
                i3 = 1;
            }
            return hashCode + i3;
        }

        public final boolean isStar() {
            return this.isStar;
        }

        @NotNull
        public String toString() {
            return "Info(uin=" + this.uin + ", vipType=" + this.vipType + ", namePlateId=" + this.namePlateId + ", grayNameplateFlag=" + this.grayNameplateFlag + ", isStar=" + this.isStar + ")";
        }

        public /* synthetic */ Info(String str, int i3, int i16, int i17, boolean z16, int i18, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, i3, i16, i17, (i18 & 16) != 0 ? false : z16);
        }
    }
}
