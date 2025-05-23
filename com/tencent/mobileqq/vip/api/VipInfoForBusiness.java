package com.tencent.mobileqq.vip.api;

import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.qphone.base.util.QLog;
import com.tencent.trpcprotocol.qqva.vipdata.oidbdata.GxhOidbInfo;
import com.tencent.trpcprotocol.qqva.vipdata.oidbdata.NameplateOidbInfo;
import com.tencent.trpcprotocol.qqva.vipdata.oidbdata.OidbUserData;
import com.tencent.trpcprotocol.qqva.vipdata.userdata.userdata$ColourNickInfo;
import com.tencent.trpcprotocol.qqva.vipdata.userdata.userdata$NameplateInfo;
import com.tencent.trpcprotocol.qqva.vipdata.userdata.userdata$UserData;
import cooperation.qqcircle.report.QCircleAlphaUserReporter;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b1\b\u0086\b\u0018\u00002\u00020\u0001B]\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\u0016\u001a\u00020\n\u0012\b\b\u0002\u0010\u0017\u001a\u00020\n\u0012\b\b\u0002\u0010\u0018\u001a\u00020\n\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u001a\u001a\u00020\n\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0011\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0013\u00a2\u0006\u0004\bA\u0010BB\u0013\b\u0016\u0012\b\u0010C\u001a\u0004\u0018\u00010\b\u00a2\u0006\u0004\bA\u0010&J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0007\u001a\u00020\u0006J\u000b\u0010\t\u001a\u0004\u0018\u00010\bH\u00c6\u0003J\t\u0010\u000b\u001a\u00020\nH\u00c6\u0003J\t\u0010\f\u001a\u00020\nH\u00c6\u0003J\t\u0010\r\u001a\u00020\nH\u00c6\u0003J\t\u0010\u000f\u001a\u00020\u000eH\u00c6\u0003J\t\u0010\u0010\u001a\u00020\nH\u00c6\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u00c6\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u00c6\u0003J_\u0010\u001d\u001a\u00020\u00002\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\u0016\u001a\u00020\n2\b\b\u0002\u0010\u0017\u001a\u00020\n2\b\b\u0002\u0010\u0018\u001a\u00020\n2\b\b\u0002\u0010\u0019\u001a\u00020\u000e2\b\b\u0002\u0010\u001a\u001a\u00020\n2\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0013H\u00c6\u0001J\t\u0010\u001e\u001a\u00020\bH\u00d6\u0001J\t\u0010\u001f\u001a\u00020\nH\u00d6\u0001J\u0013\u0010!\u001a\u00020\u00062\b\u0010 \u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R$\u0010\u0015\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0015\u0010\"\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\"\u0010\u0016\u001a\u00020\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0016\u0010'\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\"\u0010\u0017\u001a\u00020\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0017\u0010'\u001a\u0004\b,\u0010)\"\u0004\b-\u0010+R\"\u0010\u0018\u001a\u00020\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0018\u0010'\u001a\u0004\b.\u0010)\"\u0004\b/\u0010+R\"\u0010\u0019\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0019\u00100\u001a\u0004\b1\u00102\"\u0004\b3\u00104R\"\u0010\u001a\u001a\u00020\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001a\u0010'\u001a\u0004\b5\u0010)\"\u0004\b6\u0010+R$\u0010\u001b\u001a\u0004\u0018\u00010\u00118\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001b\u00107\u001a\u0004\b8\u00109\"\u0004\b:\u0010;R$\u0010\u001c\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001c\u0010<\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@\u00a8\u0006D"}, d2 = {"Lcom/tencent/mobileqq/vip/api/VipInfoForBusiness;", "", "", "byteArray", "", "fromBuffer", "", AppConstants.Key.COLUMN_IS_VALID, "", "component1", "", "component2", "component3", "component4", "", "component5", "component6", "Lcom/tencent/mobileqq/vip/api/g;", "component7", "Lcom/tencent/mobileqq/vip/api/a;", "component8", "uin", "nameplateType", "nameplateId", "level", "diyNameplateIds", "vipDataFlag", "numberIcon", "colorName", "copy", "toString", "hashCode", "other", "equals", "Ljava/lang/String;", "getUin", "()Ljava/lang/String;", "setUin", "(Ljava/lang/String;)V", "I", "getNameplateType", "()I", "setNameplateType", "(I)V", "getNameplateId", "setNameplateId", "getLevel", "setLevel", "[I", "getDiyNameplateIds", "()[I", "setDiyNameplateIds", "([I)V", "getVipDataFlag", "setVipDataFlag", "Lcom/tencent/mobileqq/vip/api/g;", "getNumberIcon", "()Lcom/tencent/mobileqq/vip/api/g;", "setNumberIcon", "(Lcom/tencent/mobileqq/vip/api/g;)V", "Lcom/tencent/mobileqq/vip/api/a;", "getColorName", "()Lcom/tencent/mobileqq/vip/api/a;", "setColorName", "(Lcom/tencent/mobileqq/vip/api/a;)V", "<init>", "(Ljava/lang/String;III[IILcom/tencent/mobileqq/vip/api/g;Lcom/tencent/mobileqq/vip/api/a;)V", QCircleAlphaUserReporter.KEY_USER, "vas-temp-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final /* data */ class VipInfoForBusiness {
    static IPatchRedirector $redirector_;

    @Nullable
    private a colorName;

    @NotNull
    private int[] diyNameplateIds;
    private int level;
    private int nameplateId;
    private int nameplateType;

    @Nullable
    private g numberIcon;

    @Nullable
    private String uin;
    private int vipDataFlag;

    public VipInfoForBusiness() {
        this(null, 0, 0, 0, null, 0, null, null, 255, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 34)) {
            return;
        }
        iPatchRedirector.redirect((short) 34, (Object) this);
    }

    public static /* synthetic */ VipInfoForBusiness copy$default(VipInfoForBusiness vipInfoForBusiness, String str, int i3, int i16, int i17, int[] iArr, int i18, g gVar, a aVar, int i19, Object obj) {
        String str2;
        int i26;
        int i27;
        int i28;
        int[] iArr2;
        int i29;
        g gVar2;
        a aVar2;
        if ((i19 & 1) != 0) {
            str2 = vipInfoForBusiness.uin;
        } else {
            str2 = str;
        }
        if ((i19 & 2) != 0) {
            i26 = vipInfoForBusiness.nameplateType;
        } else {
            i26 = i3;
        }
        if ((i19 & 4) != 0) {
            i27 = vipInfoForBusiness.nameplateId;
        } else {
            i27 = i16;
        }
        if ((i19 & 8) != 0) {
            i28 = vipInfoForBusiness.level;
        } else {
            i28 = i17;
        }
        if ((i19 & 16) != 0) {
            iArr2 = vipInfoForBusiness.diyNameplateIds;
        } else {
            iArr2 = iArr;
        }
        if ((i19 & 32) != 0) {
            i29 = vipInfoForBusiness.vipDataFlag;
        } else {
            i29 = i18;
        }
        if ((i19 & 64) != 0) {
            gVar2 = vipInfoForBusiness.numberIcon;
        } else {
            gVar2 = gVar;
        }
        if ((i19 & 128) != 0) {
            aVar2 = vipInfoForBusiness.colorName;
        } else {
            aVar2 = aVar;
        }
        return vipInfoForBusiness.copy(str2, i26, i27, i28, iArr2, i29, gVar2, aVar2);
    }

    @Nullable
    public final String component1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return (String) iPatchRedirector.redirect((short) 22, (Object) this);
        }
        return this.uin;
    }

    public final int component2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return ((Integer) iPatchRedirector.redirect((short) 23, (Object) this)).intValue();
        }
        return this.nameplateType;
    }

    public final int component3() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            return ((Integer) iPatchRedirector.redirect((short) 24, (Object) this)).intValue();
        }
        return this.nameplateId;
    }

    public final int component4() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            return ((Integer) iPatchRedirector.redirect((short) 25, (Object) this)).intValue();
        }
        return this.level;
    }

    @NotNull
    public final int[] component5() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            return (int[]) iPatchRedirector.redirect((short) 26, (Object) this);
        }
        return this.diyNameplateIds;
    }

    public final int component6() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            return ((Integer) iPatchRedirector.redirect((short) 27, (Object) this)).intValue();
        }
        return this.vipDataFlag;
    }

    @Nullable
    public final g component7() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            return (g) iPatchRedirector.redirect((short) 28, (Object) this);
        }
        return this.numberIcon;
    }

    @Nullable
    public final a component8() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            return (a) iPatchRedirector.redirect((short) 29, (Object) this);
        }
        return this.colorName;
    }

    @NotNull
    public final VipInfoForBusiness copy(@Nullable String uin, int nameplateType, int nameplateId, int level, @NotNull int[] diyNameplateIds, int vipDataFlag, @Nullable g numberIcon, @Nullable a colorName) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            return (VipInfoForBusiness) iPatchRedirector.redirect((short) 30, this, uin, Integer.valueOf(nameplateType), Integer.valueOf(nameplateId), Integer.valueOf(level), diyNameplateIds, Integer.valueOf(vipDataFlag), numberIcon, colorName);
        }
        Intrinsics.checkNotNullParameter(diyNameplateIds, "diyNameplateIds");
        return new VipInfoForBusiness(uin, nameplateType, nameplateId, level, diyNameplateIds, vipDataFlag, numberIcon, colorName);
    }

    public boolean equals(@Nullable Object other) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            return ((Boolean) iPatchRedirector.redirect((short) 33, (Object) this, other)).booleanValue();
        }
        if (this == other) {
            return true;
        }
        if (!(other instanceof VipInfoForBusiness)) {
            return false;
        }
        VipInfoForBusiness vipInfoForBusiness = (VipInfoForBusiness) other;
        if (Intrinsics.areEqual(this.uin, vipInfoForBusiness.uin) && this.nameplateType == vipInfoForBusiness.nameplateType && this.nameplateId == vipInfoForBusiness.nameplateId && this.level == vipInfoForBusiness.level && Intrinsics.areEqual(this.diyNameplateIds, vipInfoForBusiness.diyNameplateIds) && this.vipDataFlag == vipInfoForBusiness.vipDataFlag && Intrinsics.areEqual(this.numberIcon, vipInfoForBusiness.numberIcon) && Intrinsics.areEqual(this.colorName, vipInfoForBusiness.colorName)) {
            return true;
        }
        return false;
    }

    public final void fromBuffer(@NotNull byte[] byteArray) {
        int[] intArray;
        int[] intArray2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this, (Object) byteArray);
            return;
        }
        Intrinsics.checkNotNullParameter(byteArray, "byteArray");
        try {
            OidbUserData mergeFrom = new OidbUserData().mergeFrom(byteArray);
            GxhOidbInfo gxhOidbInfo = mergeFrom.gxh.get();
            this.vipDataFlag = gxhOidbInfo.qqvadata_changerand.get();
            NameplateOidbInfo nameplateOidbInfo = gxhOidbInfo.f381645np.get();
            this.nameplateType = nameplateOidbInfo.nameplate_type.get();
            this.nameplateId = nameplateOidbInfo.nameplate_id.get();
            this.level = nameplateOidbInfo.level.get();
            List<Integer> list = nameplateOidbInfo.diy_nameplate_ids.get();
            Intrinsics.checkNotNullExpressionValue(list, "it.diy_nameplate_ids.get()");
            intArray = CollectionsKt___CollectionsKt.toIntArray(list);
            this.diyNameplateIds = intArray;
            userdata$UserData userdata_userdata = mergeFrom.vipdata.get();
            if (userdata_userdata != null) {
                userdata$NameplateInfo userdata_nameplateinfo = userdata_userdata.nameplate.get();
                if (userdata_nameplateinfo != null) {
                    Intrinsics.checkNotNullExpressionValue(userdata_nameplateinfo, "get()");
                    int i3 = userdata_nameplateinfo.itemid.get();
                    List<Integer> list2 = userdata_nameplateinfo.content.get();
                    Intrinsics.checkNotNullExpressionValue(list2, "it.content.get()");
                    intArray2 = CollectionsKt___CollectionsKt.toIntArray(list2);
                    this.numberIcon = new g(i3, intArray2, userdata_nameplateinfo.fgid.get());
                }
                userdata$ColourNickInfo userdata_colournickinfo = userdata_userdata.colour_nick.get();
                if (userdata_colournickinfo != null) {
                    Intrinsics.checkNotNullExpressionValue(userdata_colournickinfo, "get()");
                    this.colorName = new a(userdata_colournickinfo.itemid.get(), userdata_colournickinfo.is_close.get());
                }
            }
        } catch (Throwable th5) {
            QLog.e("VipInfoForBusiness", 1, th5, new Object[0]);
        }
    }

    @Nullable
    public final a getColorName() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return (a) iPatchRedirector.redirect((short) 17, (Object) this);
        }
        return this.colorName;
    }

    @NotNull
    public final int[] getDiyNameplateIds() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (int[]) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        return this.diyNameplateIds;
    }

    public final int getLevel() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Integer) iPatchRedirector.redirect((short) 9, (Object) this)).intValue();
        }
        return this.level;
    }

    public final int getNameplateId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this)).intValue();
        }
        return this.nameplateId;
    }

    public final int getNameplateType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
        }
        return this.nameplateType;
    }

    @Nullable
    public final g getNumberIcon() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return (g) iPatchRedirector.redirect((short) 15, (Object) this);
        }
        return this.numberIcon;
    }

    @Nullable
    public final String getUin() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.uin;
    }

    public final int getVipDataFlag() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Integer) iPatchRedirector.redirect((short) 13, (Object) this)).intValue();
        }
        return this.vipDataFlag;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            return ((Integer) iPatchRedirector.redirect((short) 32, (Object) this)).intValue();
        }
        String str = this.uin;
        int i3 = 0;
        if (str == null) {
            hashCode = 0;
        } else {
            hashCode = str.hashCode();
        }
        int hashCode3 = ((((((((((hashCode * 31) + this.nameplateType) * 31) + this.nameplateId) * 31) + this.level) * 31) + Arrays.hashCode(this.diyNameplateIds)) * 31) + this.vipDataFlag) * 31;
        g gVar = this.numberIcon;
        if (gVar == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = gVar.hashCode();
        }
        int i16 = (hashCode3 + hashCode2) * 31;
        a aVar = this.colorName;
        if (aVar != null) {
            i3 = aVar.hashCode();
        }
        return i16 + i3;
    }

    public final boolean isValid() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return ((Boolean) iPatchRedirector.redirect((short) 21, (Object) this)).booleanValue();
        }
        return !QQTheme.isNowSimpleUI();
    }

    public final void setColorName(@Nullable a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, (Object) aVar);
        } else {
            this.colorName = aVar;
        }
    }

    public final void setDiyNameplateIds(@NotNull int[] iArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) iArr);
        } else {
            Intrinsics.checkNotNullParameter(iArr, "<set-?>");
            this.diyNameplateIds = iArr;
        }
    }

    public final void setLevel(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, i3);
        } else {
            this.level = i3;
        }
    }

    public final void setNameplateId(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, i3);
        } else {
            this.nameplateId = i3;
        }
    }

    public final void setNameplateType(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, i3);
        } else {
            this.nameplateType = i3;
        }
    }

    public final void setNumberIcon(@Nullable g gVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, (Object) gVar);
        } else {
            this.numberIcon = gVar;
        }
    }

    public final void setUin(@Nullable String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) str);
        } else {
            this.uin = str;
        }
    }

    public final void setVipDataFlag(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, i3);
        } else {
            this.vipDataFlag = i3;
        }
    }

    @NotNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            return (String) iPatchRedirector.redirect((short) 31, (Object) this);
        }
        return "VipInfoForBusiness(uin=" + this.uin + ", nameplateType=" + this.nameplateType + ", nameplateId=" + this.nameplateId + ", level=" + this.level + ", diyNameplateIds=" + Arrays.toString(this.diyNameplateIds) + ", vipDataFlag=" + this.vipDataFlag + ", numberIcon=" + this.numberIcon + ", colorName=" + this.colorName + ")";
    }

    public VipInfoForBusiness(@Nullable String str, int i3, int i16, int i17, @NotNull int[] diyNameplateIds, int i18, @Nullable g gVar, @Nullable a aVar) {
        Intrinsics.checkNotNullParameter(diyNameplateIds, "diyNameplateIds");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, str, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), diyNameplateIds, Integer.valueOf(i18), gVar, aVar);
            return;
        }
        this.uin = str;
        this.nameplateType = i3;
        this.nameplateId = i16;
        this.level = i17;
        this.diyNameplateIds = diyNameplateIds;
        this.vipDataFlag = i18;
        this.numberIcon = gVar;
        this.colorName = aVar;
    }

    public /* synthetic */ VipInfoForBusiness(String str, int i3, int i16, int i17, int[] iArr, int i18, g gVar, a aVar, int i19, DefaultConstructorMarker defaultConstructorMarker) {
        this((i19 & 1) != 0 ? "" : str, (i19 & 2) != 0 ? 0 : i3, (i19 & 4) != 0 ? -1 : i16, (i19 & 8) != 0 ? 0 : i17, (i19 & 16) != 0 ? new int[0] : iArr, (i19 & 32) != 0 ? 0 : i18, (i19 & 64) != 0 ? null : gVar, (i19 & 128) != 0 ? null : aVar);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, str, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), iArr, Integer.valueOf(i18), gVar, aVar, Integer.valueOf(i19), defaultConstructorMarker);
    }

    public VipInfoForBusiness(@Nullable String str) {
        this(str, 0, 0, 0, null, 0, null, null, 254, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 19)) {
            return;
        }
        iPatchRedirector.redirect((short) 19, (Object) this, (Object) str);
    }
}
