package com.tencent.mobileqq.troop.selectmember.config;

import android.os.Parcel;
import android.os.Parcelable;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0019\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u0011\n\u0002\b\u0010\u0018\u0000 ^2\u00020\u0001:\u0001\u001eB#\u0012\u0006\u0010\u0011\u001a\u00020\t\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u0004\u00a2\u0006\u0004\b[\u0010\\B\t\b\u0012\u00a2\u0006\u0004\b[\u0010!B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b[\u0010]J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\b\u001a\u00020\u0004H\u0016J\b\u0010\n\u001a\u00020\tH\u0016R\"\u0010\u0011\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\"\u0010\u0018\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\"\u0010\u001c\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0019\u0010\u0013\u001a\u0004\b\u001a\u0010\u0015\"\u0004\b\u001b\u0010\u0017R(\u0010\"\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0018\n\u0004\b\u001d\u0010\u0013\u0012\u0004\b \u0010!\u001a\u0004\b\u001e\u0010\u0015\"\u0004\b\u001f\u0010\u0017R\"\u0010*\u001a\u00020#8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\"\u0010-\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b+\u0010\u0013\u001a\u0004\b\u0019\u0010\u0015\"\u0004\b,\u0010\u0017R\"\u00101\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b.\u0010\f\u001a\u0004\b/\u0010\u000e\"\u0004\b0\u0010\u0010R\"\u00109\u001a\u0002028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b3\u00104\u001a\u0004\b5\u00106\"\u0004\b7\u00108R\"\u0010@\u001a\u00020:8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b;\u0010<\u001a\u0004\b\u0012\u0010=\"\u0004\b>\u0010?R\"\u0010C\u001a\u00020#8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bA\u0010%\u001a\u0004\b+\u0010'\"\u0004\bB\u0010)R\"\u0010G\u001a\u00020#8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bD\u0010%\u001a\u0004\bE\u0010'\"\u0004\bF\u0010)R\"\u0010K\u001a\u00020#8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bH\u0010%\u001a\u0004\bI\u0010'\"\u0004\bJ\u0010)R\"\u0010N\u001a\u00020#8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0013\u0010%\u001a\u0004\bL\u0010'\"\u0004\bM\u0010)R(\u0010V\u001a\b\u0012\u0004\u0012\u00020\t0O8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bP\u0010Q\u001a\u0004\bR\u0010S\"\u0004\bT\u0010UR(\u0010Z\u001a\b\u0012\u0004\u0012\u00020\t0O8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bW\u0010Q\u001a\u0004\bX\u0010S\"\u0004\bY\u0010U\u00a8\u0006_"}, d2 = {"Lcom/tencent/mobileqq/troop/selectmember/config/TroopSelectMemberConfig;", "Landroid/os/Parcelable;", "Landroid/os/Parcel;", "parcel", "", WadlProxyConsts.FLAGS, "", "writeToParcel", "describeContents", "", "toString", "d", "Ljava/lang/String;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "()Ljava/lang/String;", "setTroopUin", "(Ljava/lang/String;)V", "troopUin", "e", "I", "c", "()I", "setFrom", "(I)V", "from", "f", "g", "setSearchFromType", "searchFromType", h.F, "a", "setDataFetchType", "getDataFetchType$annotations", "()V", "dataFetchType", "", "i", "Z", "r", "()Z", HippyTKDListViewAdapter.X, "(Z)V", "isSingleChooseMode", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "t", "maxSelectSize", BdhLogUtil.LogTag.Tag_Conn, "p", "y", "toastSelectLimitMsg", "Lcom/tencent/mobileqq/troop/selectmember/config/TroopSelectMemberTitleBarConfig;", "D", "Lcom/tencent/mobileqq/troop/selectmember/config/TroopSelectMemberTitleBarConfig;", "o", "()Lcom/tencent/mobileqq/troop/selectmember/config/TroopSelectMemberTitleBarConfig;", "setTitleBarConfig", "(Lcom/tencent/mobileqq/troop/selectmember/config/TroopSelectMemberTitleBarConfig;)V", "titleBarConfig", "Lcom/tencent/mobileqq/troop/selectmember/config/TroopSelectMemberInjectConfig;", "E", "Lcom/tencent/mobileqq/troop/selectmember/config/TroopSelectMemberInjectConfig;", "()Lcom/tencent/mobileqq/troop/selectmember/config/TroopSelectMemberInjectConfig;", "setInjectClassConfig", "(Lcom/tencent/mobileqq/troop/selectmember/config/TroopSelectMemberInjectConfig;)V", "injectClassConfig", UserInfo.SEX_FEMALE, "setShowSearchBar", "showSearchBar", "G", "k", "setShowIndexBar", "showIndexBar", "H", "l", "v", "showLevelInfo", DomainData.DOMAIN_NAME, "w", "showVipNameColor", "", "J", "[Ljava/lang/String;", "j", "()[Ljava/lang/String;", "u", "([Ljava/lang/String;)V", "selectedUinList", "K", "b", ReportConstant.COSTREPORT_PREFIX, "filterUinList", "<init>", "(Ljava/lang/String;II)V", "(Landroid/os/Parcel;)V", "CREATOR", "qqtroop-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class TroopSelectMemberConfig implements Parcelable {
    static IPatchRedirector $redirector_;

    /* renamed from: CREATOR, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private String toastSelectLimitMsg;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private TroopSelectMemberTitleBarConfig titleBarConfig;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private TroopSelectMemberInjectConfig injectClassConfig;

    /* renamed from: F, reason: from kotlin metadata */
    private boolean showSearchBar;

    /* renamed from: G, reason: from kotlin metadata */
    private boolean showIndexBar;

    /* renamed from: H, reason: from kotlin metadata */
    private boolean showLevelInfo;

    /* renamed from: I, reason: from kotlin metadata */
    private boolean showVipNameColor;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    private String[] selectedUinList;

    /* renamed from: K, reason: from kotlin metadata */
    @NotNull
    private String[] filterUinList;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String troopUin;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private int from;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private int searchFromType;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private int dataFetchType;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private boolean isSingleChooseMode;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private int maxSelectSize;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u001f\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a2\u0006\u0004\b\t\u0010\n\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/troop/selectmember/config/TroopSelectMemberConfig$a;", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mobileqq/troop/selectmember/config/TroopSelectMemberConfig;", "Landroid/os/Parcel;", "parcel", "a", "", "size", "", "b", "(I)[Lcom/tencent/mobileqq/troop/selectmember/config/TroopSelectMemberConfig;", "<init>", "()V", "qqtroop-api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.troop.selectmember.config.TroopSelectMemberConfig$a, reason: from kotlin metadata */
    /* loaded from: classes19.dex */
    public static final class Companion implements Parcelable.Creator<TroopSelectMemberConfig> {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
                return;
            }
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) defaultConstructorMarker);
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public TroopSelectMemberConfig createFromParcel(@NotNull Parcel parcel) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (TroopSelectMemberConfig) iPatchRedirector.redirect((short) 2, (Object) this, (Object) parcel);
            }
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new TroopSelectMemberConfig(parcel);
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public TroopSelectMemberConfig[] newArray(int size) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (TroopSelectMemberConfig[]) iPatchRedirector.redirect((short) 3, (Object) this, size);
            }
            return new TroopSelectMemberConfig[size];
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(24836);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 38)) {
            redirector.redirect((short) 38);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public TroopSelectMemberConfig(@NotNull String troopUin, int i3, int i16) {
        Intrinsics.checkNotNullParameter(troopUin, "troopUin");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, troopUin, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        this.troopUin = troopUin;
        this.from = i3;
        this.searchFromType = i16;
        this.dataFetchType = 1;
        this.maxSelectSize = Integer.MAX_VALUE;
        this.toastSelectLimitMsg = "";
        this.titleBarConfig = new TroopSelectMemberTitleBarConfig(false, null, null, 7, null);
        this.injectClassConfig = new TroopSelectMemberInjectConfig();
        this.showSearchBar = true;
        this.showIndexBar = true;
        this.showLevelInfo = true;
        this.showVipNameColor = true;
        this.selectedUinList = new String[0];
        this.filterUinList = new String[0];
    }

    public final int a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Integer) iPatchRedirector.redirect((short) 10, (Object) this)).intValue();
        }
        return this.dataFetchType;
    }

    @NotNull
    public final String[] b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            return (String[]) iPatchRedirector.redirect((short) 32, (Object) this);
        }
        return this.filterUinList;
    }

    public final int c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
        }
        return this.from;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 36)) {
            return ((Integer) iPatchRedirector.redirect((short) 36, (Object) this)).intValue();
        }
        return 0;
    }

    @NotNull
    public final TroopSelectMemberInjectConfig e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return (TroopSelectMemberInjectConfig) iPatchRedirector.redirect((short) 20, (Object) this);
        }
        return this.injectClassConfig;
    }

    public final int f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Integer) iPatchRedirector.redirect((short) 14, (Object) this)).intValue();
        }
        return this.maxSelectSize;
    }

    public final int g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this)).intValue();
        }
        return this.searchFromType;
    }

    @NotNull
    public final String[] j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            return (String[]) iPatchRedirector.redirect((short) 30, (Object) this);
        }
        return this.selectedUinList;
    }

    public final boolean k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            return ((Boolean) iPatchRedirector.redirect((short) 24, (Object) this)).booleanValue();
        }
        return this.showIndexBar;
    }

    public final boolean l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            return ((Boolean) iPatchRedirector.redirect((short) 26, (Object) this)).booleanValue();
        }
        return this.showLevelInfo;
    }

    public final boolean m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return ((Boolean) iPatchRedirector.redirect((short) 22, (Object) this)).booleanValue();
        }
        return this.showSearchBar;
    }

    public final boolean n() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            return ((Boolean) iPatchRedirector.redirect((short) 28, (Object) this)).booleanValue();
        }
        return this.showVipNameColor;
    }

    @NotNull
    public final TroopSelectMemberTitleBarConfig o() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return (TroopSelectMemberTitleBarConfig) iPatchRedirector.redirect((short) 18, (Object) this);
        }
        return this.titleBarConfig;
    }

    @NotNull
    public final String p() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return (String) iPatchRedirector.redirect((short) 16, (Object) this);
        }
        return this.toastSelectLimitMsg;
    }

    @NotNull
    public final String q() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.troopUin;
    }

    public final boolean r() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Boolean) iPatchRedirector.redirect((short) 12, (Object) this)).booleanValue();
        }
        return this.isSingleChooseMode;
    }

    public final void s(@NotNull String[] strArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            iPatchRedirector.redirect((short) 33, (Object) this, (Object) strArr);
        } else {
            Intrinsics.checkNotNullParameter(strArr, "<set-?>");
            this.filterUinList = strArr;
        }
    }

    public final void t(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, i3);
        } else {
            this.maxSelectSize = i3;
        }
    }

    @NotNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 37)) {
            return (String) iPatchRedirector.redirect((short) 37, (Object) this);
        }
        String str = this.troopUin;
        int i3 = this.from;
        int i16 = this.searchFromType;
        int i17 = this.dataFetchType;
        int i18 = this.maxSelectSize;
        boolean z16 = this.isSingleChooseMode;
        String str2 = this.toastSelectLimitMsg;
        TroopSelectMemberTitleBarConfig troopSelectMemberTitleBarConfig = this.titleBarConfig;
        TroopSelectMemberInjectConfig troopSelectMemberInjectConfig = this.injectClassConfig;
        boolean z17 = this.showSearchBar;
        boolean z18 = this.showIndexBar;
        boolean z19 = this.showLevelInfo;
        boolean z26 = this.showVipNameColor;
        String arrays = Arrays.toString(this.selectedUinList);
        Intrinsics.checkNotNullExpressionValue(arrays, "toString(this)");
        String arrays2 = Arrays.toString(this.filterUinList);
        Intrinsics.checkNotNullExpressionValue(arrays2, "toString(this)");
        return "Config(troopUin='" + str + "', from=" + i3 + ", searchFromType=" + i16 + ", dataFetchType=" + i17 + ", maxSelectSize=" + i18 + ", isSingleChooseMode=" + z16 + ", toastSelectLimitMsg='" + str2 + "', titleBarConfig=" + troopSelectMemberTitleBarConfig + ", injectClassConfig=" + troopSelectMemberInjectConfig + ", showSearchBar=" + z17 + ", showIndexBar=" + z18 + ", showLevelInfo=" + z19 + ", showVipNameColor=" + z26 + ", selectedUinList=" + arrays + ", filterUinList=" + arrays2;
    }

    public final void u(@NotNull String[] strArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            iPatchRedirector.redirect((short) 31, (Object) this, (Object) strArr);
        } else {
            Intrinsics.checkNotNullParameter(strArr, "<set-?>");
            this.selectedUinList = strArr;
        }
    }

    public final void v(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            iPatchRedirector.redirect((short) 27, (Object) this, z16);
        } else {
            this.showLevelInfo = z16;
        }
    }

    public final void w(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            iPatchRedirector.redirect((short) 29, (Object) this, z16);
        } else {
            this.showVipNameColor = z16;
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 35)) {
            iPatchRedirector.redirect((short) 35, (Object) this, (Object) parcel, flags);
            return;
        }
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.troopUin);
        parcel.writeInt(this.from);
        parcel.writeInt(this.searchFromType);
        parcel.writeInt(this.dataFetchType);
        parcel.writeInt(this.maxSelectSize);
        parcel.writeByte(this.isSingleChooseMode ? (byte) 1 : (byte) 0);
        parcel.writeString(this.toastSelectLimitMsg);
        parcel.writeParcelable(this.titleBarConfig, flags);
        parcel.writeParcelable(this.injectClassConfig, flags);
        parcel.writeByte(this.showSearchBar ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.showIndexBar ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.showLevelInfo ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.showVipNameColor ? (byte) 1 : (byte) 0);
        parcel.writeStringArray(this.selectedUinList);
        parcel.writeStringArray(this.filterUinList);
    }

    public final void x(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, z16);
        } else {
            this.isSingleChooseMode = z16;
        }
    }

    public final void y(@NotNull String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, (Object) str);
        } else {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.toastSelectLimitMsg = str;
        }
    }

    public /* synthetic */ TroopSelectMemberConfig(String str, int i3, int i16, int i17, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i17 & 2) != 0 ? 1 : i3, (i17 & 4) != 0 ? -1 : i16);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, str, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), defaultConstructorMarker);
    }

    TroopSelectMemberConfig() {
        this("", 1, 0, 4, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 9)) {
            return;
        }
        iPatchRedirector.redirect((short) 9, (Object) this);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public TroopSelectMemberConfig(@NotNull Parcel parcel) {
        this();
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
            iPatchRedirector.redirect((short) 34, (Object) this, (Object) parcel);
            return;
        }
        String readString = parcel.readString();
        this.troopUin = readString == null ? "" : readString;
        this.from = parcel.readInt();
        this.searchFromType = parcel.readInt();
        this.dataFetchType = parcel.readInt();
        this.maxSelectSize = parcel.readInt();
        this.isSingleChooseMode = parcel.readByte() != 0;
        String readString2 = parcel.readString();
        this.toastSelectLimitMsg = readString2 != null ? readString2 : "";
        TroopSelectMemberTitleBarConfig troopSelectMemberTitleBarConfig = (TroopSelectMemberTitleBarConfig) parcel.readParcelable(TroopSelectMemberTitleBarConfig.class.getClassLoader());
        this.titleBarConfig = troopSelectMemberTitleBarConfig == null ? new TroopSelectMemberTitleBarConfig(false, null, null, 7, null) : troopSelectMemberTitleBarConfig;
        TroopSelectMemberInjectConfig troopSelectMemberInjectConfig = (TroopSelectMemberInjectConfig) parcel.readParcelable(TroopSelectMemberInjectConfig.class.getClassLoader());
        this.injectClassConfig = troopSelectMemberInjectConfig == null ? new TroopSelectMemberInjectConfig() : troopSelectMemberInjectConfig;
        this.showSearchBar = parcel.readByte() != 0;
        this.showIndexBar = parcel.readByte() != 0;
        this.showLevelInfo = parcel.readByte() != 0;
        this.showVipNameColor = parcel.readByte() != 0;
        String[] createStringArray = parcel.createStringArray();
        this.selectedUinList = createStringArray == null ? new String[0] : createStringArray;
        String[] createStringArray2 = parcel.createStringArray();
        this.filterUinList = createStringArray2 == null ? new String[0] : createStringArray2;
    }
}
