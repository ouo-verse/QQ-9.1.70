package com.tencent.mobileqq.weather.data;

import android.text.TextUtils;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.qphone.base.util.QLog;
import cooperation.vip.pb.TianShuAccess;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b4\b\u0086\b\u0018\u0000 ;2\u00020\u0001:\u0001\fB\u001b\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u000b\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0006\u00a2\u0006\u0004\b=\u0010>J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\t\u0010\u0007\u001a\u00020\u0006H\u00d6\u0001J\u0013\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0019\u0010\u0010\u001a\u0004\u0018\u00010\u000b8\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\"\u0010\u0016\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000e\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\"\u0010\u0019\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0017\u0010\u0011\u001a\u0004\b\f\u0010\u0013\"\u0004\b\u0018\u0010\u0015R\"\u0010 \u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\"\u0010$\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b!\u0010\u001b\u001a\u0004\b\"\u0010\u001d\"\u0004\b#\u0010\u001fR\"\u0010(\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b%\u0010\u001b\u001a\u0004\b&\u0010\u001d\"\u0004\b'\u0010\u001fR\"\u0010+\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b)\u0010\u001b\u001a\u0004\b!\u0010\u001d\"\u0004\b*\u0010\u001fR\"\u0010.\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b&\u0010\u001b\u001a\u0004\b,\u0010\u001d\"\u0004\b-\u0010\u001fR\"\u00100\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001c\u0010\u001b\u001a\u0004\b)\u0010\u001d\"\u0004\b/\u0010\u001fR\"\u00103\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b1\u0010\u001b\u001a\u0004\b%\u0010\u001d\"\u0004\b2\u0010\u001fR\"\u00106\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b4\u0010\u001b\u001a\u0004\b4\u0010\u001d\"\u0004\b5\u0010\u001fR\"\u00108\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0012\u0010\u001b\u001a\u0004\b1\u0010\u001d\"\u0004\b7\u0010\u001fR\"\u0010:\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b,\u0010\u001b\u001a\u0004\b\u0017\u0010\u001d\"\u0004\b9\u0010\u001fR\"\u0010<\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\"\u0010\u0011\u001a\u0004\b\u001a\u0010\u0013\"\u0004\b;\u0010\u0015\u00a8\u0006?"}, d2 = {"Lcom/tencent/mobileqq/weather/data/o;", "", "", "p", "", "toString", "", "hashCode", "other", "", "equals", "Lcooperation/vip/pb/TianShuAccess$AdItem;", "a", "Lcooperation/vip/pb/TianShuAccess$AdItem;", "b", "()Lcooperation/vip/pb/TianShuAccess$AdItem;", "adItem", "I", "l", "()I", "setTianShuPosId", "(I)V", "tianShuPosId", "c", "setAdId", "adId", "d", "Ljava/lang/String;", "i", "()Ljava/lang/String;", "setPicUrl", "(Ljava/lang/String;)V", "picUrl", "e", DomainData.DOMAIN_NAME, "setVideoUrl", AppConstants.Key.KEY_QZONE_VIDEO_URL, "f", tl.h.F, "setJumpUrl", WadlProxyConsts.KEY_JUMP_URL, "g", "setDefaultJumpUrl", "defaultJumpUrl", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "setType", "type", "setGraphUrl", "graphUrl", "j", "setGraphJumpUrl", "graphJumpUrl", "k", "setThirdPartyReportURLForExposure", "thirdPartyReportURLForExposure", "setThirdPartyReportURLForClick", "thirdPartyReportURLForClick", "setBannerWeight", "bannerWeight", "o", "bannerWeightValue", "<init>", "(Lcooperation/vip/pb/TianShuAccess$AdItem;I)V", "qq-weather-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final /* data */ class o {
    static IPatchRedirector $redirector_;

    /* renamed from: o, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final TianShuAccess.AdItem adItem;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private int tianShuPosId;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private int adId;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String picUrl;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String videoUrl;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String jumpUrl;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String defaultJumpUrl;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String type;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String graphUrl;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String graphJumpUrl;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String thirdPartyReportURLForExposure;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String thirdPartyReportURLForClick;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String bannerWeight;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    private int bannerWeightValue;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/weather/data/o$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qq-weather-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.weather.data.o$a, reason: from kotlin metadata */
    /* loaded from: classes20.dex */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(20178);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 36)) {
            redirector.redirect((short) 36);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public o(@Nullable TianShuAccess.AdItem adItem, int i3) {
        int i16;
        PBRepeatMessageField<TianShuAccess.MapEntry> pBRepeatMessageField;
        List<TianShuAccess.MapEntry> list;
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        String str9;
        String str10;
        String str11;
        PBStringField pBStringField;
        PBUInt32Field pBUInt32Field;
        String str12;
        String str13;
        String str14;
        String str15;
        String str16;
        PBStringField pBStringField2;
        PBStringField pBStringField3;
        PBStringField pBStringField4;
        PBStringField pBStringField5;
        PBStringField pBStringField6;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) adItem, i3);
            return;
        }
        this.adItem = adItem;
        this.tianShuPosId = i3;
        this.picUrl = "";
        this.videoUrl = "";
        this.jumpUrl = "";
        this.defaultJumpUrl = "";
        this.type = "";
        this.graphUrl = "";
        this.graphJumpUrl = "";
        this.thirdPartyReportURLForExposure = "";
        this.thirdPartyReportURLForClick = "";
        this.bannerWeight = "";
        if (com.tencent.mobileqq.weather.debug.g.f313380a.e()) {
            if (adItem != null && (pBStringField6 = adItem.iconurl) != null) {
                str12 = pBStringField6.get();
            } else {
                str12 = null;
            }
            this.picUrl = String.valueOf(str12);
            if (adItem != null && (pBStringField5 = adItem.jumpurl) != null) {
                str13 = pBStringField5.get();
            } else {
                str13 = null;
            }
            this.jumpUrl = String.valueOf(str13);
            if (adItem != null && (pBStringField4 = adItem.iconurl) != null) {
                str14 = pBStringField4.get();
            } else {
                str14 = null;
            }
            this.graphUrl = String.valueOf(str14);
            if (adItem != null && (pBStringField3 = adItem.jumpurl) != null) {
                str15 = pBStringField3.get();
            } else {
                str15 = null;
            }
            this.graphJumpUrl = String.valueOf(str15);
            if (adItem != null && (pBStringField2 = adItem.desc) != null) {
                str16 = pBStringField2.get();
            } else {
                str16 = null;
            }
            this.bannerWeight = String.valueOf(str16);
        }
        if (adItem != null && (pBUInt32Field = adItem.iAdId) != null) {
            i16 = pBUInt32Field.get();
        } else {
            i16 = 0;
        }
        this.adId = i16;
        if (adItem != null && (pBRepeatMessageField = adItem.argList) != null && (list = pBRepeatMessageField.get()) != null) {
            for (TianShuAccess.MapEntry mapEntry : list) {
                if (mapEntry != null && (pBStringField = mapEntry.key) != null) {
                    str = pBStringField.get();
                } else {
                    str = null;
                }
                if (str != null) {
                    switch (str.hashCode()) {
                        case -848455941:
                            if (str.equals("thirdPartyReportURLForClick")) {
                                PBStringField pBStringField7 = mapEntry.value;
                                if (pBStringField7 != null) {
                                    str2 = pBStringField7.get();
                                } else {
                                    str2 = null;
                                }
                                if (str2 == null) {
                                    str2 = "";
                                } else {
                                    Intrinsics.checkNotNullExpressionValue(str2, "it.value?.get() ?: \"\"");
                                }
                                this.thirdPartyReportURLForClick = str2;
                                break;
                            } else {
                                break;
                            }
                        case -357239268:
                            if (str.equals("default_jump_url")) {
                                PBStringField pBStringField8 = mapEntry.value;
                                if (pBStringField8 != null) {
                                    str3 = pBStringField8.get();
                                } else {
                                    str3 = null;
                                }
                                if (str3 == null) {
                                    str3 = "";
                                } else {
                                    Intrinsics.checkNotNullExpressionValue(str3, "it.value?.get() ?: \"\"");
                                }
                                this.defaultJumpUrl = str3;
                                break;
                            } else {
                                break;
                            }
                        case 110986:
                            if (str.equals("pic")) {
                                PBStringField pBStringField9 = mapEntry.value;
                                if (pBStringField9 != null) {
                                    str4 = pBStringField9.get();
                                } else {
                                    str4 = null;
                                }
                                if (str4 == null) {
                                    str4 = "";
                                } else {
                                    Intrinsics.checkNotNullExpressionValue(str4, "it.value?.get() ?: \"\"");
                                }
                                this.picUrl = str4;
                                break;
                            } else {
                                break;
                            }
                        case 116079:
                            if (str.equals("url")) {
                                PBStringField pBStringField10 = mapEntry.value;
                                if (pBStringField10 != null) {
                                    str5 = pBStringField10.get();
                                } else {
                                    str5 = null;
                                }
                                if (str5 == null) {
                                    str5 = "";
                                } else {
                                    Intrinsics.checkNotNullExpressionValue(str5, "it.value?.get() ?: \"\"");
                                }
                                this.jumpUrl = str5;
                                break;
                            } else {
                                break;
                            }
                        case 3575610:
                            if (str.equals("type")) {
                                PBStringField pBStringField11 = mapEntry.value;
                                if (pBStringField11 != null) {
                                    str6 = pBStringField11.get();
                                } else {
                                    str6 = null;
                                }
                                if (str6 == null) {
                                    str6 = "";
                                } else {
                                    Intrinsics.checkNotNullExpressionValue(str6, "it.value?.get() ?: \"\"");
                                }
                                this.type = str6;
                                break;
                            } else {
                                break;
                            }
                        case 112202875:
                            if (str.equals("video")) {
                                PBStringField pBStringField12 = mapEntry.value;
                                if (pBStringField12 != null) {
                                    str7 = pBStringField12.get();
                                } else {
                                    str7 = null;
                                }
                                if (str7 == null) {
                                    str7 = "";
                                } else {
                                    Intrinsics.checkNotNullExpressionValue(str7, "it.value?.get() ?: \"\"");
                                }
                                this.videoUrl = str7;
                                break;
                            } else {
                                break;
                            }
                        case 740914320:
                            if (str.equals("graph_jumpurl")) {
                                PBStringField pBStringField13 = mapEntry.value;
                                if (pBStringField13 != null) {
                                    str8 = pBStringField13.get();
                                } else {
                                    str8 = null;
                                }
                                if (str8 == null) {
                                    str8 = "";
                                } else {
                                    Intrinsics.checkNotNullExpressionValue(str8, "it.value?.get() ?: \"\"");
                                }
                                this.graphJumpUrl = str8;
                                break;
                            } else {
                                break;
                            }
                        case 994202292:
                            if (str.equals("thirdPartyReportURLForExposure")) {
                                PBStringField pBStringField14 = mapEntry.value;
                                if (pBStringField14 != null) {
                                    str9 = pBStringField14.get();
                                } else {
                                    str9 = null;
                                }
                                if (str9 == null) {
                                    str9 = "";
                                } else {
                                    Intrinsics.checkNotNullExpressionValue(str9, "it.value?.get() ?: \"\"");
                                }
                                this.thirdPartyReportURLForExposure = str9;
                                break;
                            } else {
                                break;
                            }
                        case 1574082283:
                            if (str.equals("banner_weight")) {
                                PBStringField pBStringField15 = mapEntry.value;
                                if (pBStringField15 != null) {
                                    str10 = pBStringField15.get();
                                } else {
                                    str10 = null;
                                }
                                if (str10 == null) {
                                    str10 = "";
                                } else {
                                    Intrinsics.checkNotNullExpressionValue(str10, "it.value?.get() ?: \"\"");
                                }
                                this.bannerWeight = str10;
                                break;
                            } else {
                                break;
                            }
                        case 1848566066:
                            if (str.equals("graph_graphurl")) {
                                PBStringField pBStringField16 = mapEntry.value;
                                if (pBStringField16 != null) {
                                    str11 = pBStringField16.get();
                                } else {
                                    str11 = null;
                                }
                                if (str11 == null) {
                                    str11 = "";
                                } else {
                                    Intrinsics.checkNotNullExpressionValue(str11, "it.value?.get() ?: \"\"");
                                }
                                this.graphUrl = str11;
                                break;
                            } else {
                                break;
                            }
                    }
                }
            }
        }
        p();
    }

    private final void p() {
        if (TextUtils.isEmpty(this.bannerWeight)) {
            this.bannerWeightValue = 0;
            return;
        }
        try {
            this.bannerWeightValue = Integer.parseInt(this.bannerWeight);
        } catch (Exception e16) {
            this.bannerWeightValue = 0;
            QLog.e("WeatherTianShuDataItem", 1, "updateBannerWeightValue error:", e16);
        }
    }

    public final int a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
        }
        return this.adId;
    }

    @Nullable
    public final TianShuAccess.AdItem b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (TianShuAccess.AdItem) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.adItem;
    }

    @NotNull
    public final String c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            return (String) iPatchRedirector.redirect((short) 26, (Object) this);
        }
        return this.bannerWeight;
    }

    public final int d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            return ((Integer) iPatchRedirector.redirect((short) 28, (Object) this)).intValue();
        }
        return this.bannerWeightValue;
    }

    @NotNull
    public final String e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (String) iPatchRedirector.redirect((short) 14, (Object) this);
        }
        return this.defaultJumpUrl;
    }

    public boolean equals(@Nullable Object other) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 35)) {
            return ((Boolean) iPatchRedirector.redirect((short) 35, (Object) this, other)).booleanValue();
        }
        if (this == other) {
            return true;
        }
        if (!(other instanceof o)) {
            return false;
        }
        o oVar = (o) other;
        if (Intrinsics.areEqual(this.adItem, oVar.adItem) && this.tianShuPosId == oVar.tianShuPosId) {
            return true;
        }
        return false;
    }

    @NotNull
    public final String f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return (String) iPatchRedirector.redirect((short) 20, (Object) this);
        }
        return this.graphJumpUrl;
    }

    @NotNull
    public final String g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return (String) iPatchRedirector.redirect((short) 18, (Object) this);
        }
        return this.graphUrl;
    }

    @NotNull
    public final String h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (String) iPatchRedirector.redirect((short) 12, (Object) this);
        }
        return this.jumpUrl;
    }

    public int hashCode() {
        int hashCode;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
            return ((Integer) iPatchRedirector.redirect((short) 34, (Object) this)).intValue();
        }
        TianShuAccess.AdItem adItem = this.adItem;
        if (adItem == null) {
            hashCode = 0;
        } else {
            hashCode = adItem.hashCode();
        }
        return (hashCode * 31) + this.tianShuPosId;
    }

    @NotNull
    public final String i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (String) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return this.picUrl;
    }

    @NotNull
    public final String j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            return (String) iPatchRedirector.redirect((short) 24, (Object) this);
        }
        return this.thirdPartyReportURLForClick;
    }

    @NotNull
    public final String k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return (String) iPatchRedirector.redirect((short) 22, (Object) this);
        }
        return this.thirdPartyReportURLForExposure;
    }

    public final int l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        return this.tianShuPosId;
    }

    @NotNull
    public final String m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return (String) iPatchRedirector.redirect((short) 16, (Object) this);
        }
        return this.type;
    }

    @NotNull
    public final String n() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (String) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        return this.videoUrl;
    }

    public final void o(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            iPatchRedirector.redirect((short) 29, (Object) this, i3);
        } else {
            this.bannerWeightValue = i3;
        }
    }

    @NotNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            return (String) iPatchRedirector.redirect((short) 33, (Object) this);
        }
        return "WeatherTianShuDataItem(adItem=" + this.adItem + ", tianShuPosId=" + this.tianShuPosId + ")";
    }
}
