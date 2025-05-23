package com.tencent.ams.dynamicwidget.data;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.ams.dynamicwidget.report.LinkReportConstant$BizKey;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.luggage.wxa.ig.w;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qqnt.kernel.nativeinterface.MsgConstant;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\"\b\u0086\b\u0018\u0000 C2\u00020\u00012\u00020\u0002:\u0001DBs\b\u0007\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\n\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u0013\u00a2\u0006\u0004\b@\u0010AB\u0011\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\u0004\b@\u0010BJ\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\t\u001a\u00020\u0005H\u0016J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u00c6\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\nH\u00c6\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\nH\u00c6\u0003J\t\u0010\u000e\u001a\u00020\u0005H\u00c6\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\nH\u00c6\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\nH\u00c6\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\nH\u00c6\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\nH\u00c6\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u00c6\u0003Js\u0010\u001e\u001a\u00020\u00002\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010\u0018\u001a\u00020\u00052\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u0013H\u00c6\u0001J\t\u0010\u001f\u001a\u00020\nH\u00d6\u0001J\t\u0010 \u001a\u00020\u0005H\u00d6\u0001J\u0013\u0010$\u001a\u00020#2\b\u0010\"\u001a\u0004\u0018\u00010!H\u00d6\u0003R$\u0010\u0015\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0015\u0010%\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R$\u0010\u0016\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0016\u0010%\u001a\u0004\b*\u0010'\"\u0004\b+\u0010)R$\u0010\u0017\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0017\u0010%\u001a\u0004\b,\u0010'\"\u0004\b-\u0010)R\"\u0010\u0018\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0018\u0010.\u001a\u0004\b/\u00100\"\u0004\b1\u00102R$\u0010\u0019\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0019\u0010%\u001a\u0004\b3\u0010'\"\u0004\b4\u0010)R$\u0010\u001a\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001a\u0010%\u001a\u0004\b5\u0010'\"\u0004\b6\u0010)R$\u0010\u001b\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001b\u0010%\u001a\u0004\b7\u0010'\"\u0004\b8\u0010)R$\u0010\u001c\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001c\u0010%\u001a\u0004\b9\u0010'\"\u0004\b:\u0010)R$\u0010\u001d\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001d\u0010;\u001a\u0004\b<\u0010=\"\u0004\b>\u0010?\u00a8\u0006E"}, d2 = {"Lcom/tencent/ams/dynamicwidget/data/AdInfo;", "Ljava/io/Serializable;", "Landroid/os/Parcelable;", "Landroid/os/Parcel;", "parcel", "", WadlProxyConsts.FLAGS, "", "writeToParcel", "describeContents", "", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "Lcom/tencent/ams/dynamicwidget/data/LandingPageData;", "component9", "aid", "templateId", "orderJson", "clickReqType", "linkEventTraceId", "convViewId", LinkReportConstant$BizKey.UXINFO, "destUrlReflectionId", "landingPageData", "copy", "toString", "hashCode", "", "other", "", "equals", "Ljava/lang/String;", "getAid", "()Ljava/lang/String;", "setAid", "(Ljava/lang/String;)V", "getTemplateId", "setTemplateId", "getOrderJson", "setOrderJson", "I", "getClickReqType", "()I", "setClickReqType", "(I)V", "getLinkEventTraceId", "setLinkEventTraceId", "getConvViewId", "setConvViewId", "getUxinfo", "setUxinfo", "getDestUrlReflectionId", "setDestUrlReflectionId", "Lcom/tencent/ams/dynamicwidget/data/LandingPageData;", "getLandingPageData", "()Lcom/tencent/ams/dynamicwidget/data/LandingPageData;", "setLandingPageData", "(Lcom/tencent/ams/dynamicwidget/data/LandingPageData;)V", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/ams/dynamicwidget/data/LandingPageData;)V", "(Landroid/os/Parcel;)V", "CREATOR", "a", "lib_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes3.dex */
public final /* data */ class AdInfo implements Serializable, Parcelable {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: CREATOR, reason: from kotlin metadata */
    public static final Companion INSTANCE;
    private static final long serialVersionUID = -8620;

    @Nullable
    private String aid;
    private int clickReqType;

    @Nullable
    private String convViewId;

    @Nullable
    private String destUrlReflectionId;

    @Nullable
    private LandingPageData landingPageData;

    @Nullable
    private String linkEventTraceId;

    @Nullable
    private String orderJson;

    @Nullable
    private String templateId;

    @Nullable
    private String uxinfo;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u001f\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a2\u0006\u0004\b\t\u0010\nR\u0014\u0010\f\u001a\u00020\u000b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\f\u0010\r\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/ams/dynamicwidget/data/AdInfo$a;", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/ams/dynamicwidget/data/AdInfo;", "Landroid/os/Parcel;", "parcel", "a", "", "size", "", "b", "(I)[Lcom/tencent/ams/dynamicwidget/data/AdInfo;", "", "serialVersionUID", "J", "<init>", "()V", "lib_release"}, k = 1, mv = {1, 4, 0})
    /* renamed from: com.tencent.ams.dynamicwidget.data.AdInfo$a, reason: from kotlin metadata */
    /* loaded from: classes3.dex */
    public static final class Companion implements Parcelable.Creator<AdInfo> {
        static IPatchRedirector $redirector_;

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                return;
            }
            iPatchRedirector.redirect((short) 3, (Object) this);
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public AdInfo createFromParcel(@NotNull Parcel parcel) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                return (AdInfo) iPatchRedirector.redirect((short) 1, (Object) this, (Object) parcel);
            }
            Intrinsics.checkParameterIsNotNull(parcel, "parcel");
            return new AdInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public AdInfo[] newArray(int size) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (AdInfo[]) iPatchRedirector.redirect((short) 2, (Object) this, size);
            }
            return new AdInfo[size];
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
                return;
            }
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) defaultConstructorMarker);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(16082);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 33)) {
            redirector.redirect((short) 33);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    @JvmOverloads
    public AdInfo() {
        this(null, null, null, 0, null, null, null, null, null, 511, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 31)) {
            return;
        }
        iPatchRedirector.redirect((short) 31, (Object) this);
    }

    public static /* synthetic */ AdInfo copy$default(AdInfo adInfo, String str, String str2, String str3, int i3, String str4, String str5, String str6, String str7, LandingPageData landingPageData, int i16, Object obj) {
        String str8;
        String str9;
        String str10;
        int i17;
        String str11;
        String str12;
        String str13;
        String str14;
        LandingPageData landingPageData2;
        if ((i16 & 1) != 0) {
            str8 = adInfo.aid;
        } else {
            str8 = str;
        }
        if ((i16 & 2) != 0) {
            str9 = adInfo.templateId;
        } else {
            str9 = str2;
        }
        if ((i16 & 4) != 0) {
            str10 = adInfo.orderJson;
        } else {
            str10 = str3;
        }
        if ((i16 & 8) != 0) {
            i17 = adInfo.clickReqType;
        } else {
            i17 = i3;
        }
        if ((i16 & 16) != 0) {
            str11 = adInfo.linkEventTraceId;
        } else {
            str11 = str4;
        }
        if ((i16 & 32) != 0) {
            str12 = adInfo.convViewId;
        } else {
            str12 = str5;
        }
        if ((i16 & 64) != 0) {
            str13 = adInfo.uxinfo;
        } else {
            str13 = str6;
        }
        if ((i16 & 128) != 0) {
            str14 = adInfo.destUrlReflectionId;
        } else {
            str14 = str7;
        }
        if ((i16 & 256) != 0) {
            landingPageData2 = adInfo.landingPageData;
        } else {
            landingPageData2 = landingPageData;
        }
        return adInfo.copy(str8, str9, str10, i17, str11, str12, str13, str14, landingPageData2);
    }

    @Nullable
    public final String component1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
            return (String) iPatchRedirector.redirect((short) 34, (Object) this);
        }
        return this.aid;
    }

    @Nullable
    public final String component2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 35)) {
            return (String) iPatchRedirector.redirect((short) 35, (Object) this);
        }
        return this.templateId;
    }

    @Nullable
    public final String component3() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 36)) {
            return (String) iPatchRedirector.redirect((short) 36, (Object) this);
        }
        return this.orderJson;
    }

    public final int component4() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 37)) {
            return ((Integer) iPatchRedirector.redirect((short) 37, (Object) this)).intValue();
        }
        return this.clickReqType;
    }

    @Nullable
    public final String component5() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 38)) {
            return (String) iPatchRedirector.redirect((short) 38, (Object) this);
        }
        return this.linkEventTraceId;
    }

    @Nullable
    public final String component6() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 39)) {
            return (String) iPatchRedirector.redirect((short) 39, (Object) this);
        }
        return this.convViewId;
    }

    @Nullable
    public final String component7() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 40)) {
            return (String) iPatchRedirector.redirect((short) 40, (Object) this);
        }
        return this.uxinfo;
    }

    @Nullable
    public final String component8() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 41)) {
            return (String) iPatchRedirector.redirect((short) 41, (Object) this);
        }
        return this.destUrlReflectionId;
    }

    @Nullable
    public final LandingPageData component9() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 42)) {
            return (LandingPageData) iPatchRedirector.redirect((short) 42, (Object) this);
        }
        return this.landingPageData;
    }

    @NotNull
    public final AdInfo copy(@Nullable String aid, @Nullable String templateId, @Nullable String orderJson, int clickReqType, @Nullable String linkEventTraceId, @Nullable String convViewId, @Nullable String uxinfo, @Nullable String destUrlReflectionId, @Nullable LandingPageData landingPageData) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 43)) {
            return (AdInfo) iPatchRedirector.redirect((short) 43, this, aid, templateId, orderJson, Integer.valueOf(clickReqType), linkEventTraceId, convViewId, uxinfo, destUrlReflectionId, landingPageData);
        }
        return new AdInfo(aid, templateId, orderJson, clickReqType, linkEventTraceId, convViewId, uxinfo, destUrlReflectionId, landingPageData);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return 0;
    }

    public boolean equals(@Nullable Object other) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 46)) {
            return ((Boolean) iPatchRedirector.redirect((short) 46, (Object) this, other)).booleanValue();
        }
        if (this != other) {
            if (other instanceof AdInfo) {
                AdInfo adInfo = (AdInfo) other;
                if (!Intrinsics.areEqual(this.aid, adInfo.aid) || !Intrinsics.areEqual(this.templateId, adInfo.templateId) || !Intrinsics.areEqual(this.orderJson, adInfo.orderJson) || this.clickReqType != adInfo.clickReqType || !Intrinsics.areEqual(this.linkEventTraceId, adInfo.linkEventTraceId) || !Intrinsics.areEqual(this.convViewId, adInfo.convViewId) || !Intrinsics.areEqual(this.uxinfo, adInfo.uxinfo) || !Intrinsics.areEqual(this.destUrlReflectionId, adInfo.destUrlReflectionId) || !Intrinsics.areEqual(this.landingPageData, adInfo.landingPageData)) {
                    return false;
                }
                return true;
            }
            return false;
        }
        return true;
    }

    @Nullable
    public final String getAid() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.aid;
    }

    public final int getClickReqType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Integer) iPatchRedirector.redirect((short) 9, (Object) this)).intValue();
        }
        return this.clickReqType;
    }

    @Nullable
    public final String getConvViewId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (String) iPatchRedirector.redirect((short) 13, (Object) this);
        }
        return this.convViewId;
    }

    @Nullable
    public final String getDestUrlReflectionId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return (String) iPatchRedirector.redirect((short) 17, (Object) this);
        }
        return this.destUrlReflectionId;
    }

    @Nullable
    public final LandingPageData getLandingPageData() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return (LandingPageData) iPatchRedirector.redirect((short) 19, (Object) this);
        }
        return this.landingPageData;
    }

    @Nullable
    public final String getLinkEventTraceId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (String) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        return this.linkEventTraceId;
    }

    @Nullable
    public final String getOrderJson() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (String) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return this.orderJson;
    }

    @Nullable
    public final String getTemplateId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.templateId;
    }

    @Nullable
    public final String getUxinfo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return (String) iPatchRedirector.redirect((short) 15, (Object) this);
        }
        return this.uxinfo;
    }

    public int hashCode() {
        int i3;
        int i16;
        int i17;
        int i18;
        int i19;
        int i26;
        int i27;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 45)) {
            return ((Integer) iPatchRedirector.redirect((short) 45, (Object) this)).intValue();
        }
        String str = this.aid;
        int i28 = 0;
        if (str != null) {
            i3 = str.hashCode();
        } else {
            i3 = 0;
        }
        int i29 = i3 * 31;
        String str2 = this.templateId;
        if (str2 != null) {
            i16 = str2.hashCode();
        } else {
            i16 = 0;
        }
        int i36 = (i29 + i16) * 31;
        String str3 = this.orderJson;
        if (str3 != null) {
            i17 = str3.hashCode();
        } else {
            i17 = 0;
        }
        int i37 = (((i36 + i17) * 31) + this.clickReqType) * 31;
        String str4 = this.linkEventTraceId;
        if (str4 != null) {
            i18 = str4.hashCode();
        } else {
            i18 = 0;
        }
        int i38 = (i37 + i18) * 31;
        String str5 = this.convViewId;
        if (str5 != null) {
            i19 = str5.hashCode();
        } else {
            i19 = 0;
        }
        int i39 = (i38 + i19) * 31;
        String str6 = this.uxinfo;
        if (str6 != null) {
            i26 = str6.hashCode();
        } else {
            i26 = 0;
        }
        int i46 = (i39 + i26) * 31;
        String str7 = this.destUrlReflectionId;
        if (str7 != null) {
            i27 = str7.hashCode();
        } else {
            i27 = 0;
        }
        int i47 = (i46 + i27) * 31;
        LandingPageData landingPageData = this.landingPageData;
        if (landingPageData != null) {
            i28 = landingPageData.hashCode();
        }
        return i47 + i28;
    }

    public final void setAid(@Nullable String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) str);
        } else {
            this.aid = str;
        }
    }

    public final void setClickReqType(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, i3);
        } else {
            this.clickReqType = i3;
        }
    }

    public final void setConvViewId(@Nullable String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) str);
        } else {
            this.convViewId = str;
        }
    }

    public final void setDestUrlReflectionId(@Nullable String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, (Object) str);
        } else {
            this.destUrlReflectionId = str;
        }
    }

    public final void setLandingPageData(@Nullable LandingPageData landingPageData) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this, (Object) landingPageData);
        } else {
            this.landingPageData = landingPageData;
        }
    }

    public final void setLinkEventTraceId(@Nullable String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) str);
        } else {
            this.linkEventTraceId = str;
        }
    }

    public final void setOrderJson(@Nullable String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) str);
        } else {
            this.orderJson = str;
        }
    }

    public final void setTemplateId(@Nullable String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) str);
        } else {
            this.templateId = str;
        }
    }

    public final void setUxinfo(@Nullable String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, (Object) str);
        } else {
            this.uxinfo = str;
        }
    }

    @NotNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 44)) {
            return (String) iPatchRedirector.redirect((short) 44, (Object) this);
        }
        return "AdInfo(aid=" + this.aid + ", templateId=" + this.templateId + ", orderJson=" + this.orderJson + ", clickReqType=" + this.clickReqType + ", linkEventTraceId=" + this.linkEventTraceId + ", convViewId=" + this.convViewId + ", uxinfo=" + this.uxinfo + ", destUrlReflectionId=" + this.destUrlReflectionId + ", landingPageData=" + this.landingPageData + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) parcel, flags);
            return;
        }
        Intrinsics.checkParameterIsNotNull(parcel, "parcel");
        parcel.writeString(this.aid);
        parcel.writeString(this.templateId);
        parcel.writeString(this.orderJson);
        parcel.writeInt(this.clickReqType);
        parcel.writeString(this.linkEventTraceId);
        parcel.writeString(this.convViewId);
        parcel.writeString(this.uxinfo);
        parcel.writeString(this.destUrlReflectionId);
    }

    @JvmOverloads
    public AdInfo(@Nullable String str) {
        this(str, null, null, 0, null, null, null, null, null, 510, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 30)) {
            return;
        }
        iPatchRedirector.redirect((short) 30, (Object) this, (Object) str);
    }

    @JvmOverloads
    public AdInfo(@Nullable String str, @Nullable String str2) {
        this(str, str2, null, 0, null, null, null, null, null, 508, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 29)) {
            return;
        }
        iPatchRedirector.redirect((short) 29, (Object) this, (Object) str, (Object) str2);
    }

    @JvmOverloads
    public AdInfo(@Nullable String str, @Nullable String str2, @Nullable String str3) {
        this(str, str2, str3, 0, null, null, null, null, null, 504, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 28)) {
            return;
        }
        iPatchRedirector.redirect((short) 28, this, str, str2, str3);
    }

    @JvmOverloads
    public AdInfo(@Nullable String str, @Nullable String str2, @Nullable String str3, int i3) {
        this(str, str2, str3, i3, null, null, null, null, null, w.CTRL_INDEX, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 27)) {
            return;
        }
        iPatchRedirector.redirect((short) 27, this, str, str2, str3, Integer.valueOf(i3));
    }

    @JvmOverloads
    public AdInfo(@Nullable String str, @Nullable String str2, @Nullable String str3, int i3, @Nullable String str4) {
        this(str, str2, str3, i3, str4, null, null, null, null, 480, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 26)) {
            return;
        }
        iPatchRedirector.redirect((short) 26, this, str, str2, str3, Integer.valueOf(i3), str4);
    }

    @JvmOverloads
    public AdInfo(@Nullable String str, @Nullable String str2, @Nullable String str3, int i3, @Nullable String str4, @Nullable String str5) {
        this(str, str2, str3, i3, str4, str5, null, null, null, TroopInfo.PAY_PRIVILEGE_ALL, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 25)) {
            return;
        }
        iPatchRedirector.redirect((short) 25, this, str, str2, str3, Integer.valueOf(i3), str4, str5);
    }

    @JvmOverloads
    public AdInfo(@Nullable String str, @Nullable String str2, @Nullable String str3, int i3, @Nullable String str4, @Nullable String str5, @Nullable String str6) {
        this(str, str2, str3, i3, str4, str5, str6, null, null, MsgConstant.KRMFILETHUMBSIZE384, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 24)) {
            return;
        }
        iPatchRedirector.redirect((short) 24, this, str, str2, str3, Integer.valueOf(i3), str4, str5, str6);
    }

    @JvmOverloads
    public AdInfo(@Nullable String str, @Nullable String str2, @Nullable String str3, int i3, @Nullable String str4, @Nullable String str5, @Nullable String str6, @Nullable String str7) {
        this(str, str2, str3, i3, str4, str5, str6, str7, null, 256, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 23)) {
            return;
        }
        iPatchRedirector.redirect((short) 23, this, str, str2, str3, Integer.valueOf(i3), str4, str5, str6, str7);
    }

    @JvmOverloads
    public AdInfo(@Nullable String str, @Nullable String str2, @Nullable String str3, int i3, @Nullable String str4, @Nullable String str5, @Nullable String str6, @Nullable String str7, @Nullable LandingPageData landingPageData) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, this, str, str2, str3, Integer.valueOf(i3), str4, str5, str6, str7, landingPageData);
            return;
        }
        this.aid = str;
        this.templateId = str2;
        this.orderJson = str3;
        this.clickReqType = i3;
        this.linkEventTraceId = str4;
        this.convViewId = str5;
        this.uxinfo = str6;
        this.destUrlReflectionId = str7;
        this.landingPageData = landingPageData;
    }

    public /* synthetic */ AdInfo(String str, String str2, String str3, int i3, String str4, String str5, String str6, String str7, LandingPageData landingPageData, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this((i16 & 1) != 0 ? null : str, (i16 & 2) != 0 ? null : str2, (i16 & 4) != 0 ? null : str3, (i16 & 8) != 0 ? 0 : i3, (i16 & 16) != 0 ? null : str4, (i16 & 32) != 0 ? null : str5, (i16 & 64) != 0 ? null : str6, (i16 & 128) != 0 ? null : str7, (i16 & 256) != 0 ? null : landingPageData);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 22)) {
            return;
        }
        iPatchRedirector.redirect((short) 22, this, str, str2, str3, Integer.valueOf(i3), str4, str5, str6, str7, landingPageData, Integer.valueOf(i16), defaultConstructorMarker);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public AdInfo(@NotNull Parcel parcel) {
        this(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), null, 256, null);
        Intrinsics.checkParameterIsNotNull(parcel, "parcel");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 32)) {
            return;
        }
        iPatchRedirector.redirect((short) 32, (Object) this, (Object) parcel);
    }
}
