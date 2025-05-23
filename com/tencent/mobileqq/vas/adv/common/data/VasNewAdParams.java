package com.tencent.mobileqq.vas.adv.common.data;

import androidx.fragment.app.a;
import com.tencent.mobileqq.kandian.base.image.api.IPublicAccountHttpDownloader;
import com.tencent.qqmini.sdk.request.GetAdInfoRequest;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;
import tencent.gdt.access;
import tencent.gdt.qq_ad_get;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\bZ\b\u0086\b\u0018\u00002\u00020\u0001:\u0001xB\u008d\u0002\u0012\u0016\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\t\u0012\u001a\u0010\u000b\u001a\u0016\u0012\u0004\u0012\u00020\f\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\f\u0018\u0001`\u0005\u0012\u001a\u0010\r\u001a\u0016\u0012\u0004\u0012\u00020\f\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\f\u0018\u0001`\u0005\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0004\u0012\u0016\u0010\u0011\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0004\u0012\u000e\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0014\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\t\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\t\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b\u0012\u0006\u0010\u001c\u001a\u00020\u001d\u0012\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f\u0012\u0006\u0010 \u001a\u00020\t\u00a2\u0006\u0002\u0010!J\u0019\u0010^\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005H\u00c6\u0003J\u0019\u0010_\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005H\u00c6\u0003J\u000b\u0010`\u001a\u0004\u0018\u00010\u0004H\u00c6\u0003J\u0011\u0010a\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0014H\u00c6\u0003J\u0010\u0010b\u001a\u0004\u0018\u00010\tH\u00c6\u0003\u00a2\u0006\u0002\u0010#J\u000b\u0010c\u001a\u0004\u0018\u00010\u0004H\u00c6\u0003J\u0010\u0010d\u001a\u0004\u0018\u00010\tH\u00c6\u0003\u00a2\u0006\u0002\u0010#J\u000b\u0010e\u001a\u0004\u0018\u00010\u0019H\u00c6\u0003J\u000b\u0010f\u001a\u0004\u0018\u00010\u001bH\u00c6\u0003J\t\u0010g\u001a\u00020\u001dH\u00c6\u0003J\u000b\u0010h\u001a\u0004\u0018\u00010\u001fH\u00c6\u0003J\t\u0010i\u001a\u00020\u0007H\u00c6\u0003J\t\u0010j\u001a\u00020\tH\u00c6\u0003J\u0010\u0010k\u001a\u0004\u0018\u00010\tH\u00c6\u0003\u00a2\u0006\u0002\u0010#J\u0010\u0010l\u001a\u0004\u0018\u00010\tH\u00c6\u0003\u00a2\u0006\u0002\u0010#J\u001d\u0010m\u001a\u0016\u0012\u0004\u0012\u00020\f\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\f\u0018\u0001`\u0005H\u00c6\u0003J\u001d\u0010n\u001a\u0016\u0012\u0004\u0012\u00020\f\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\f\u0018\u0001`\u0005H\u00c6\u0003J\u000b\u0010o\u001a\u0004\u0018\u00010\u0004H\u00c6\u0003J\u000b\u0010p\u001a\u0004\u0018\u00010\u0004H\u00c6\u0003J\u000b\u0010q\u001a\u0004\u0018\u00010\u0004H\u00c6\u0003J\u00be\u0002\u0010r\u001a\u00020\u00002\u0018\b\u0002\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t2\u001c\b\u0002\u0010\u000b\u001a\u0016\u0012\u0004\u0012\u00020\f\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\f\u0018\u0001`\u00052\u001c\b\u0002\u0010\r\u001a\u0016\u0012\u0004\u0012\u00020\f\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\f\u0018\u0001`\u00052\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00042\u0018\b\u0002\u0010\u0011\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u00052\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00042\u0010\b\u0002\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00142\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00192\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\b\u0002\u0010 \u001a\u00020\tH\u00c6\u0001\u00a2\u0006\u0002\u0010sJ\u0013\u0010t\u001a\u00020\u001d2\b\u0010u\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010v\u001a\u00020\tH\u00d6\u0001J\t\u0010w\u001a\u00020\u0004H\u00d6\u0001R\u001e\u0010\n\u001a\u0004\u0018\u00010\tX\u0086\u000e\u00a2\u0006\u0010\n\u0002\u0010&\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R!\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u001e\u0010\u0015\u001a\u0004\u0018\u00010\tX\u0086\u000e\u00a2\u0006\u0010\n\u0002\u0010&\u001a\u0004\b)\u0010#\"\u0004\b*\u0010%R*\u0010\u0011\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b+\u0010(\"\u0004\b,\u0010-R\u001e\u0010\b\u001a\u0004\u0018\u00010\tX\u0086\u000e\u00a2\u0006\u0010\n\u0002\u0010&\u001a\u0004\b.\u0010#\"\u0004\b/\u0010%R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\u001e\u0010\u0017\u001a\u0004\u0018\u00010\tX\u0086\u000e\u00a2\u0006\u0010\n\u0002\u0010&\u001a\u0004\b4\u0010#\"\u0004\b5\u0010%R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b6\u00107\"\u0004\b8\u00109R\u001a\u0010\u001c\u001a\u00020\u001dX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b:\u0010;\"\u0004\b<\u0010=R\"\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0014X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b>\u0010?\"\u0004\b@\u0010AR\u001a\u0010 \u001a\u00020\tX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bB\u0010C\"\u0004\bD\u0010ER\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bF\u00101\"\u0004\bG\u00103R\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bH\u0010I\"\u0004\bJ\u0010KR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bL\u00101\"\u0004\bM\u00103R.\u0010\u000b\u001a\u0016\u0012\u0004\u0012\u00020\f\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\f\u0018\u0001`\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bN\u0010(\"\u0004\bO\u0010-R.\u0010\r\u001a\u0016\u0012\u0004\u0012\u00020\f\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\f\u0018\u0001`\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bP\u0010(\"\u0004\bQ\u0010-R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bR\u00101\"\u0004\bS\u00103R\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bT\u00101\"\u0004\bU\u00103R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bV\u0010W\"\u0004\bX\u0010YR\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bZ\u0010[\"\u0004\b\\\u0010]\u00a8\u0006y"}, d2 = {"Lcom/tencent/mobileqq/vas/adv/common/data/VasNewAdParams;", "", "advPos", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "uin", "", IPublicAccountHttpDownloader.BUSI_TYPE_PARAM_KEY, "", "adCount", "specifiedAdsJsonList", "Lorg/json/JSONObject;", "specifiedTianShuAdsJsonList", "targetPosId", "tianShuPosId", GetAdInfoRequest.SOURCE_FROM, "bannerAdPush", "lastRequestCookie", "extIds", "", "allowedCategory", "clientMod", "deepLinkVersion", "deviceInfo", "Ltencent/gdt/qq_ad_get$QQAdGet$DeviceInfo;", "videoFeedInfo", "Ltencent/gdt/access$VideoFeedInfo;", "disableMaskReq", "", "qzoneInfo", "Ltencent/gdt/access$QzoneInfo;", "getAdType", "(Ljava/util/ArrayList;JLjava/lang/Integer;Ljava/lang/Integer;Ljava/util/ArrayList;Ljava/util/ArrayList;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/ArrayList;Ljava/lang/String;Ljava/util/List;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ltencent/gdt/qq_ad_get$QQAdGet$DeviceInfo;Ltencent/gdt/access$VideoFeedInfo;ZLtencent/gdt/access$QzoneInfo;I)V", "getAdCount", "()Ljava/lang/Integer;", "setAdCount", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getAdvPos", "()Ljava/util/ArrayList;", "getAllowedCategory", "setAllowedCategory", "getBannerAdPush", "setBannerAdPush", "(Ljava/util/ArrayList;)V", "getBusiType", "setBusiType", "getClientMod", "()Ljava/lang/String;", "setClientMod", "(Ljava/lang/String;)V", "getDeepLinkVersion", "setDeepLinkVersion", "getDeviceInfo", "()Ltencent/gdt/qq_ad_get$QQAdGet$DeviceInfo;", "setDeviceInfo", "(Ltencent/gdt/qq_ad_get$QQAdGet$DeviceInfo;)V", "getDisableMaskReq", "()Z", "setDisableMaskReq", "(Z)V", "getExtIds", "()Ljava/util/List;", "setExtIds", "(Ljava/util/List;)V", "getGetAdType", "()I", "setGetAdType", "(I)V", "getLastRequestCookie", "setLastRequestCookie", "getQzoneInfo", "()Ltencent/gdt/access$QzoneInfo;", "setQzoneInfo", "(Ltencent/gdt/access$QzoneInfo;)V", "getSourceFrom", "setSourceFrom", "getSpecifiedAdsJsonList", "setSpecifiedAdsJsonList", "getSpecifiedTianShuAdsJsonList", "setSpecifiedTianShuAdsJsonList", "getTargetPosId", "setTargetPosId", "getTianShuPosId", "setTianShuPosId", "getUin", "()J", "setUin", "(J)V", "getVideoFeedInfo", "()Ltencent/gdt/access$VideoFeedInfo;", "setVideoFeedInfo", "(Ltencent/gdt/access$VideoFeedInfo;)V", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/util/ArrayList;JLjava/lang/Integer;Ljava/lang/Integer;Ljava/util/ArrayList;Ljava/util/ArrayList;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/ArrayList;Ljava/lang/String;Ljava/util/List;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ltencent/gdt/qq_ad_get$QQAdGet$DeviceInfo;Ltencent/gdt/access$VideoFeedInfo;ZLtencent/gdt/access$QzoneInfo;I)Lcom/tencent/mobileqq/vas/adv/common/data/VasNewAdParams;", "equals", "other", "hashCode", "toString", "Builder", "vas-adv-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes20.dex */
public final /* data */ class VasNewAdParams {

    @Nullable
    private Integer adCount;

    @NotNull
    private final ArrayList<String> advPos;

    @Nullable
    private Integer allowedCategory;

    @NotNull
    private ArrayList<String> bannerAdPush;

    @Nullable
    private Integer busiType;

    @Nullable
    private String clientMod;

    @Nullable
    private Integer deepLinkVersion;

    @Nullable
    private qq_ad_get.QQAdGet.DeviceInfo deviceInfo;
    private boolean disableMaskReq;

    @Nullable
    private List<String> extIds;
    private int getAdType;

    @Nullable
    private String lastRequestCookie;

    @Nullable
    private access.QzoneInfo qzoneInfo;

    @Nullable
    private String sourceFrom;

    @Nullable
    private ArrayList<JSONObject> specifiedAdsJsonList;

    @Nullable
    private ArrayList<JSONObject> specifiedTianShuAdsJsonList;

    @Nullable
    private String targetPosId;

    @Nullable
    private String tianShuPosId;
    private long uin;

    @Nullable
    private access.VideoFeedInfo videoFeedInfo;

    @Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010`\u001a\u00020aR\u001e\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e\u00a2\u0006\u0010\n\u0002\u0010\t\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR*\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\f0\u000bj\b\u0012\u0004\u0012\u00020\f`\rX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001e\u0010\u0012\u001a\u0004\u0018\u00010\u0004X\u0086\u000e\u00a2\u0006\u0010\n\u0002\u0010\t\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\bR*\u0010\u0015\u001a\u0012\u0012\u0004\u0012\u00020\f0\u000bj\b\u0012\u0004\u0012\u00020\f`\rX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u000f\"\u0004\b\u0017\u0010\u0011R\u001e\u0010\u0018\u001a\u0004\u0018\u00010\u0004X\u0086\u000e\u00a2\u0006\u0010\n\u0002\u0010\t\u001a\u0004\b\u0019\u0010\u0006\"\u0004\b\u001a\u0010\bR\u001c\u0010\u001b\u001a\u0004\u0018\u00010\fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001e\u0010 \u001a\u0004\u0018\u00010\u0004X\u0086\u000e\u00a2\u0006\u0010\n\u0002\u0010\t\u001a\u0004\b!\u0010\u0006\"\u0004\b\"\u0010\bR\u001c\u0010#\u001a\u0004\u0018\u00010$X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u001a\u0010)\u001a\u00020*X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R \u0010/\u001a\b\u0012\u0004\u0012\u00020\f00X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b1\u00102\"\u0004\b3\u00104R\u001a\u00105\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b6\u00107\"\u0004\b8\u00109R\u001c\u0010:\u001a\u0004\u0018\u00010\fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b;\u0010\u001d\"\u0004\b<\u0010\u001fR\u001c\u0010=\u001a\u0004\u0018\u00010>X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b?\u0010@\"\u0004\bA\u0010BR\u001c\u0010C\u001a\u0004\u0018\u00010\fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bD\u0010\u001d\"\u0004\bE\u0010\u001fR.\u0010F\u001a\u0016\u0012\u0004\u0012\u00020G\u0018\u00010\u000bj\n\u0012\u0004\u0012\u00020G\u0018\u0001`\rX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bH\u0010\u000f\"\u0004\bI\u0010\u0011R.\u0010J\u001a\u0016\u0012\u0004\u0012\u00020G\u0018\u00010\u000bj\n\u0012\u0004\u0012\u00020G\u0018\u0001`\rX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bK\u0010\u000f\"\u0004\bL\u0010\u0011R\u001c\u0010M\u001a\u0004\u0018\u00010\fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bN\u0010\u001d\"\u0004\bO\u0010\u001fR\u001c\u0010P\u001a\u0004\u0018\u00010\fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bQ\u0010\u001d\"\u0004\bR\u0010\u001fR\u001e\u0010S\u001a\u0004\u0018\u00010TX\u0086\u000e\u00a2\u0006\u0010\n\u0002\u0010Y\u001a\u0004\bU\u0010V\"\u0004\bW\u0010XR\u001c\u0010Z\u001a\u0004\u0018\u00010[X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\\\u0010]\"\u0004\b^\u0010_\u00a8\u0006b"}, d2 = {"Lcom/tencent/mobileqq/vas/adv/common/data/VasNewAdParams$Builder;", "", "()V", "adCount", "", "getAdCount", "()Ljava/lang/Integer;", "setAdCount", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "advPos", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "getAdvPos", "()Ljava/util/ArrayList;", "setAdvPos", "(Ljava/util/ArrayList;)V", "allowedCategory", "getAllowedCategory", "setAllowedCategory", "bannerAdPush", "getBannerAdPush", "setBannerAdPush", IPublicAccountHttpDownloader.BUSI_TYPE_PARAM_KEY, "getBusiType", "setBusiType", "clientMod", "getClientMod", "()Ljava/lang/String;", "setClientMod", "(Ljava/lang/String;)V", "deepLinkVersion", "getDeepLinkVersion", "setDeepLinkVersion", "deviceInfo", "Ltencent/gdt/qq_ad_get$QQAdGet$DeviceInfo;", "getDeviceInfo", "()Ltencent/gdt/qq_ad_get$QQAdGet$DeviceInfo;", "setDeviceInfo", "(Ltencent/gdt/qq_ad_get$QQAdGet$DeviceInfo;)V", "disableMaskReq", "", "getDisableMaskReq", "()Z", "setDisableMaskReq", "(Z)V", "extIds", "", "getExtIds", "()Ljava/util/List;", "setExtIds", "(Ljava/util/List;)V", "getAdType", "getGetAdType", "()I", "setGetAdType", "(I)V", "lastRequestCookie", "getLastRequestCookie", "setLastRequestCookie", "qzoneInfo", "Ltencent/gdt/access$QzoneInfo;", "getQzoneInfo", "()Ltencent/gdt/access$QzoneInfo;", "setQzoneInfo", "(Ltencent/gdt/access$QzoneInfo;)V", GetAdInfoRequest.SOURCE_FROM, "getSourceFrom", "setSourceFrom", "specifiedAdsJsonList", "Lorg/json/JSONObject;", "getSpecifiedAdsJsonList", "setSpecifiedAdsJsonList", "specifiedTianShuAdsJsonList", "getSpecifiedTianShuAdsJsonList", "setSpecifiedTianShuAdsJsonList", "targetPosId", "getTargetPosId", "setTargetPosId", "tianShuPosId", "getTianShuPosId", "setTianShuPosId", "uin", "", "getUin", "()Ljava/lang/Long;", "setUin", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "videoFeedInfo", "Ltencent/gdt/access$VideoFeedInfo;", "getVideoFeedInfo", "()Ltencent/gdt/access$VideoFeedInfo;", "setVideoFeedInfo", "(Ltencent/gdt/access$VideoFeedInfo;)V", "build", "Lcom/tencent/mobileqq/vas/adv/common/data/VasNewAdParams;", "vas-adv-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes20.dex */
    public static final class Builder {

        @Nullable
        private Integer adCount;

        @Nullable
        private Integer allowedCategory;

        @Nullable
        private Integer busiType;

        @Nullable
        private String clientMod;

        @Nullable
        private Integer deepLinkVersion;

        @Nullable
        private qq_ad_get.QQAdGet.DeviceInfo deviceInfo;
        private boolean disableMaskReq;

        @NotNull
        private List<String> extIds;
        private int getAdType;

        @Nullable
        private String lastRequestCookie;

        @Nullable
        private access.QzoneInfo qzoneInfo;

        @Nullable
        private String sourceFrom;

        @Nullable
        private ArrayList<JSONObject> specifiedAdsJsonList;

        @Nullable
        private ArrayList<JSONObject> specifiedTianShuAdsJsonList;

        @Nullable
        private String targetPosId;

        @Nullable
        private String tianShuPosId;

        @Nullable
        private Long uin;

        @Nullable
        private access.VideoFeedInfo videoFeedInfo;

        @NotNull
        private ArrayList<String> advPos = new ArrayList<>();

        @NotNull
        private ArrayList<String> bannerAdPush = new ArrayList<>();

        public Builder() {
            List<String> emptyList;
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            this.extIds = emptyList;
        }

        @NotNull
        public final VasNewAdParams build() {
            long longAccountUin;
            ArrayList<String> arrayList = this.advPos;
            Long l3 = this.uin;
            if (l3 != null) {
                longAccountUin = l3.longValue();
            } else {
                longAccountUin = MobileQQ.sMobileQQ.waitAppRuntime(null).getLongAccountUin();
            }
            return new VasNewAdParams(arrayList, longAccountUin, this.busiType, this.adCount, this.specifiedAdsJsonList, this.specifiedTianShuAdsJsonList, this.targetPosId, this.tianShuPosId, this.sourceFrom, this.bannerAdPush, this.lastRequestCookie, this.extIds, this.allowedCategory, this.clientMod, this.deepLinkVersion, this.deviceInfo, this.videoFeedInfo, this.disableMaskReq, this.qzoneInfo, this.getAdType);
        }

        @Nullable
        public final Integer getAdCount() {
            return this.adCount;
        }

        @NotNull
        public final ArrayList<String> getAdvPos() {
            return this.advPos;
        }

        @Nullable
        public final Integer getAllowedCategory() {
            return this.allowedCategory;
        }

        @NotNull
        public final ArrayList<String> getBannerAdPush() {
            return this.bannerAdPush;
        }

        @Nullable
        public final Integer getBusiType() {
            return this.busiType;
        }

        @Nullable
        public final String getClientMod() {
            return this.clientMod;
        }

        @Nullable
        public final Integer getDeepLinkVersion() {
            return this.deepLinkVersion;
        }

        @Nullable
        public final qq_ad_get.QQAdGet.DeviceInfo getDeviceInfo() {
            return this.deviceInfo;
        }

        public final boolean getDisableMaskReq() {
            return this.disableMaskReq;
        }

        @NotNull
        public final List<String> getExtIds() {
            return this.extIds;
        }

        public final int getGetAdType() {
            return this.getAdType;
        }

        @Nullable
        public final String getLastRequestCookie() {
            return this.lastRequestCookie;
        }

        @Nullable
        public final access.QzoneInfo getQzoneInfo() {
            return this.qzoneInfo;
        }

        @Nullable
        public final String getSourceFrom() {
            return this.sourceFrom;
        }

        @Nullable
        public final ArrayList<JSONObject> getSpecifiedAdsJsonList() {
            return this.specifiedAdsJsonList;
        }

        @Nullable
        public final ArrayList<JSONObject> getSpecifiedTianShuAdsJsonList() {
            return this.specifiedTianShuAdsJsonList;
        }

        @Nullable
        public final String getTargetPosId() {
            return this.targetPosId;
        }

        @Nullable
        public final String getTianShuPosId() {
            return this.tianShuPosId;
        }

        @Nullable
        public final Long getUin() {
            return this.uin;
        }

        @Nullable
        public final access.VideoFeedInfo getVideoFeedInfo() {
            return this.videoFeedInfo;
        }

        public final void setAdCount(@Nullable Integer num) {
            this.adCount = num;
        }

        public final void setAdvPos(@NotNull ArrayList<String> arrayList) {
            Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
            this.advPos = arrayList;
        }

        public final void setAllowedCategory(@Nullable Integer num) {
            this.allowedCategory = num;
        }

        public final void setBannerAdPush(@NotNull ArrayList<String> arrayList) {
            Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
            this.bannerAdPush = arrayList;
        }

        public final void setBusiType(@Nullable Integer num) {
            this.busiType = num;
        }

        public final void setClientMod(@Nullable String str) {
            this.clientMod = str;
        }

        public final void setDeepLinkVersion(@Nullable Integer num) {
            this.deepLinkVersion = num;
        }

        public final void setDeviceInfo(@Nullable qq_ad_get.QQAdGet.DeviceInfo deviceInfo) {
            this.deviceInfo = deviceInfo;
        }

        public final void setDisableMaskReq(boolean z16) {
            this.disableMaskReq = z16;
        }

        public final void setExtIds(@NotNull List<String> list) {
            Intrinsics.checkNotNullParameter(list, "<set-?>");
            this.extIds = list;
        }

        public final void setGetAdType(int i3) {
            this.getAdType = i3;
        }

        public final void setLastRequestCookie(@Nullable String str) {
            this.lastRequestCookie = str;
        }

        public final void setQzoneInfo(@Nullable access.QzoneInfo qzoneInfo) {
            this.qzoneInfo = qzoneInfo;
        }

        public final void setSourceFrom(@Nullable String str) {
            this.sourceFrom = str;
        }

        public final void setSpecifiedAdsJsonList(@Nullable ArrayList<JSONObject> arrayList) {
            this.specifiedAdsJsonList = arrayList;
        }

        public final void setSpecifiedTianShuAdsJsonList(@Nullable ArrayList<JSONObject> arrayList) {
            this.specifiedTianShuAdsJsonList = arrayList;
        }

        public final void setTargetPosId(@Nullable String str) {
            this.targetPosId = str;
        }

        public final void setTianShuPosId(@Nullable String str) {
            this.tianShuPosId = str;
        }

        public final void setUin(@Nullable Long l3) {
            this.uin = l3;
        }

        public final void setVideoFeedInfo(@Nullable access.VideoFeedInfo videoFeedInfo) {
            this.videoFeedInfo = videoFeedInfo;
        }
    }

    public VasNewAdParams(@NotNull ArrayList<String> advPos, long j3, @Nullable Integer num, @Nullable Integer num2, @Nullable ArrayList<JSONObject> arrayList, @Nullable ArrayList<JSONObject> arrayList2, @Nullable String str, @Nullable String str2, @Nullable String str3, @NotNull ArrayList<String> bannerAdPush, @Nullable String str4, @Nullable List<String> list, @Nullable Integer num3, @Nullable String str5, @Nullable Integer num4, @Nullable qq_ad_get.QQAdGet.DeviceInfo deviceInfo, @Nullable access.VideoFeedInfo videoFeedInfo, boolean z16, @Nullable access.QzoneInfo qzoneInfo, int i3) {
        Intrinsics.checkNotNullParameter(advPos, "advPos");
        Intrinsics.checkNotNullParameter(bannerAdPush, "bannerAdPush");
        this.advPos = advPos;
        this.uin = j3;
        this.busiType = num;
        this.adCount = num2;
        this.specifiedAdsJsonList = arrayList;
        this.specifiedTianShuAdsJsonList = arrayList2;
        this.targetPosId = str;
        this.tianShuPosId = str2;
        this.sourceFrom = str3;
        this.bannerAdPush = bannerAdPush;
        this.lastRequestCookie = str4;
        this.extIds = list;
        this.allowedCategory = num3;
        this.clientMod = str5;
        this.deepLinkVersion = num4;
        this.deviceInfo = deviceInfo;
        this.videoFeedInfo = videoFeedInfo;
        this.disableMaskReq = z16;
        this.qzoneInfo = qzoneInfo;
        this.getAdType = i3;
    }

    @NotNull
    public final ArrayList<String> component1() {
        return this.advPos;
    }

    @NotNull
    public final ArrayList<String> component10() {
        return this.bannerAdPush;
    }

    @Nullable
    /* renamed from: component11, reason: from getter */
    public final String getLastRequestCookie() {
        return this.lastRequestCookie;
    }

    @Nullable
    public final List<String> component12() {
        return this.extIds;
    }

    @Nullable
    /* renamed from: component13, reason: from getter */
    public final Integer getAllowedCategory() {
        return this.allowedCategory;
    }

    @Nullable
    /* renamed from: component14, reason: from getter */
    public final String getClientMod() {
        return this.clientMod;
    }

    @Nullable
    /* renamed from: component15, reason: from getter */
    public final Integer getDeepLinkVersion() {
        return this.deepLinkVersion;
    }

    @Nullable
    /* renamed from: component16, reason: from getter */
    public final qq_ad_get.QQAdGet.DeviceInfo getDeviceInfo() {
        return this.deviceInfo;
    }

    @Nullable
    /* renamed from: component17, reason: from getter */
    public final access.VideoFeedInfo getVideoFeedInfo() {
        return this.videoFeedInfo;
    }

    /* renamed from: component18, reason: from getter */
    public final boolean getDisableMaskReq() {
        return this.disableMaskReq;
    }

    @Nullable
    /* renamed from: component19, reason: from getter */
    public final access.QzoneInfo getQzoneInfo() {
        return this.qzoneInfo;
    }

    /* renamed from: component2, reason: from getter */
    public final long getUin() {
        return this.uin;
    }

    /* renamed from: component20, reason: from getter */
    public final int getGetAdType() {
        return this.getAdType;
    }

    @Nullable
    /* renamed from: component3, reason: from getter */
    public final Integer getBusiType() {
        return this.busiType;
    }

    @Nullable
    /* renamed from: component4, reason: from getter */
    public final Integer getAdCount() {
        return this.adCount;
    }

    @Nullable
    public final ArrayList<JSONObject> component5() {
        return this.specifiedAdsJsonList;
    }

    @Nullable
    public final ArrayList<JSONObject> component6() {
        return this.specifiedTianShuAdsJsonList;
    }

    @Nullable
    /* renamed from: component7, reason: from getter */
    public final String getTargetPosId() {
        return this.targetPosId;
    }

    @Nullable
    /* renamed from: component8, reason: from getter */
    public final String getTianShuPosId() {
        return this.tianShuPosId;
    }

    @Nullable
    /* renamed from: component9, reason: from getter */
    public final String getSourceFrom() {
        return this.sourceFrom;
    }

    @NotNull
    public final VasNewAdParams copy(@NotNull ArrayList<String> advPos, long uin, @Nullable Integer busiType, @Nullable Integer adCount, @Nullable ArrayList<JSONObject> specifiedAdsJsonList, @Nullable ArrayList<JSONObject> specifiedTianShuAdsJsonList, @Nullable String targetPosId, @Nullable String tianShuPosId, @Nullable String sourceFrom, @NotNull ArrayList<String> bannerAdPush, @Nullable String lastRequestCookie, @Nullable List<String> extIds, @Nullable Integer allowedCategory, @Nullable String clientMod, @Nullable Integer deepLinkVersion, @Nullable qq_ad_get.QQAdGet.DeviceInfo deviceInfo, @Nullable access.VideoFeedInfo videoFeedInfo, boolean disableMaskReq, @Nullable access.QzoneInfo qzoneInfo, int getAdType) {
        Intrinsics.checkNotNullParameter(advPos, "advPos");
        Intrinsics.checkNotNullParameter(bannerAdPush, "bannerAdPush");
        return new VasNewAdParams(advPos, uin, busiType, adCount, specifiedAdsJsonList, specifiedTianShuAdsJsonList, targetPosId, tianShuPosId, sourceFrom, bannerAdPush, lastRequestCookie, extIds, allowedCategory, clientMod, deepLinkVersion, deviceInfo, videoFeedInfo, disableMaskReq, qzoneInfo, getAdType);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof VasNewAdParams)) {
            return false;
        }
        VasNewAdParams vasNewAdParams = (VasNewAdParams) other;
        if (Intrinsics.areEqual(this.advPos, vasNewAdParams.advPos) && this.uin == vasNewAdParams.uin && Intrinsics.areEqual(this.busiType, vasNewAdParams.busiType) && Intrinsics.areEqual(this.adCount, vasNewAdParams.adCount) && Intrinsics.areEqual(this.specifiedAdsJsonList, vasNewAdParams.specifiedAdsJsonList) && Intrinsics.areEqual(this.specifiedTianShuAdsJsonList, vasNewAdParams.specifiedTianShuAdsJsonList) && Intrinsics.areEqual(this.targetPosId, vasNewAdParams.targetPosId) && Intrinsics.areEqual(this.tianShuPosId, vasNewAdParams.tianShuPosId) && Intrinsics.areEqual(this.sourceFrom, vasNewAdParams.sourceFrom) && Intrinsics.areEqual(this.bannerAdPush, vasNewAdParams.bannerAdPush) && Intrinsics.areEqual(this.lastRequestCookie, vasNewAdParams.lastRequestCookie) && Intrinsics.areEqual(this.extIds, vasNewAdParams.extIds) && Intrinsics.areEqual(this.allowedCategory, vasNewAdParams.allowedCategory) && Intrinsics.areEqual(this.clientMod, vasNewAdParams.clientMod) && Intrinsics.areEqual(this.deepLinkVersion, vasNewAdParams.deepLinkVersion) && Intrinsics.areEqual(this.deviceInfo, vasNewAdParams.deviceInfo) && Intrinsics.areEqual(this.videoFeedInfo, vasNewAdParams.videoFeedInfo) && this.disableMaskReq == vasNewAdParams.disableMaskReq && Intrinsics.areEqual(this.qzoneInfo, vasNewAdParams.qzoneInfo) && this.getAdType == vasNewAdParams.getAdType) {
            return true;
        }
        return false;
    }

    @Nullable
    public final Integer getAdCount() {
        return this.adCount;
    }

    @NotNull
    public final ArrayList<String> getAdvPos() {
        return this.advPos;
    }

    @Nullable
    public final Integer getAllowedCategory() {
        return this.allowedCategory;
    }

    @NotNull
    public final ArrayList<String> getBannerAdPush() {
        return this.bannerAdPush;
    }

    @Nullable
    public final Integer getBusiType() {
        return this.busiType;
    }

    @Nullable
    public final String getClientMod() {
        return this.clientMod;
    }

    @Nullable
    public final Integer getDeepLinkVersion() {
        return this.deepLinkVersion;
    }

    @Nullable
    public final qq_ad_get.QQAdGet.DeviceInfo getDeviceInfo() {
        return this.deviceInfo;
    }

    public final boolean getDisableMaskReq() {
        return this.disableMaskReq;
    }

    @Nullable
    public final List<String> getExtIds() {
        return this.extIds;
    }

    public final int getGetAdType() {
        return this.getAdType;
    }

    @Nullable
    public final String getLastRequestCookie() {
        return this.lastRequestCookie;
    }

    @Nullable
    public final access.QzoneInfo getQzoneInfo() {
        return this.qzoneInfo;
    }

    @Nullable
    public final String getSourceFrom() {
        return this.sourceFrom;
    }

    @Nullable
    public final ArrayList<JSONObject> getSpecifiedAdsJsonList() {
        return this.specifiedAdsJsonList;
    }

    @Nullable
    public final ArrayList<JSONObject> getSpecifiedTianShuAdsJsonList() {
        return this.specifiedTianShuAdsJsonList;
    }

    @Nullable
    public final String getTargetPosId() {
        return this.targetPosId;
    }

    @Nullable
    public final String getTianShuPosId() {
        return this.tianShuPosId;
    }

    public final long getUin() {
        return this.uin;
    }

    @Nullable
    public final access.VideoFeedInfo getVideoFeedInfo() {
        return this.videoFeedInfo;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode;
        int hashCode2;
        int hashCode3;
        int hashCode4;
        int hashCode5;
        int hashCode6;
        int hashCode7;
        int hashCode8;
        int hashCode9;
        int hashCode10;
        int hashCode11;
        int hashCode12;
        int hashCode13;
        int hashCode14;
        int hashCode15 = ((this.advPos.hashCode() * 31) + a.a(this.uin)) * 31;
        Integer num = this.busiType;
        int i3 = 0;
        if (num == null) {
            hashCode = 0;
        } else {
            hashCode = num.hashCode();
        }
        int i16 = (hashCode15 + hashCode) * 31;
        Integer num2 = this.adCount;
        if (num2 == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = num2.hashCode();
        }
        int i17 = (i16 + hashCode2) * 31;
        ArrayList<JSONObject> arrayList = this.specifiedAdsJsonList;
        if (arrayList == null) {
            hashCode3 = 0;
        } else {
            hashCode3 = arrayList.hashCode();
        }
        int i18 = (i17 + hashCode3) * 31;
        ArrayList<JSONObject> arrayList2 = this.specifiedTianShuAdsJsonList;
        if (arrayList2 == null) {
            hashCode4 = 0;
        } else {
            hashCode4 = arrayList2.hashCode();
        }
        int i19 = (i18 + hashCode4) * 31;
        String str = this.targetPosId;
        if (str == null) {
            hashCode5 = 0;
        } else {
            hashCode5 = str.hashCode();
        }
        int i26 = (i19 + hashCode5) * 31;
        String str2 = this.tianShuPosId;
        if (str2 == null) {
            hashCode6 = 0;
        } else {
            hashCode6 = str2.hashCode();
        }
        int i27 = (i26 + hashCode6) * 31;
        String str3 = this.sourceFrom;
        if (str3 == null) {
            hashCode7 = 0;
        } else {
            hashCode7 = str3.hashCode();
        }
        int hashCode16 = (((i27 + hashCode7) * 31) + this.bannerAdPush.hashCode()) * 31;
        String str4 = this.lastRequestCookie;
        if (str4 == null) {
            hashCode8 = 0;
        } else {
            hashCode8 = str4.hashCode();
        }
        int i28 = (hashCode16 + hashCode8) * 31;
        List<String> list = this.extIds;
        if (list == null) {
            hashCode9 = 0;
        } else {
            hashCode9 = list.hashCode();
        }
        int i29 = (i28 + hashCode9) * 31;
        Integer num3 = this.allowedCategory;
        if (num3 == null) {
            hashCode10 = 0;
        } else {
            hashCode10 = num3.hashCode();
        }
        int i36 = (i29 + hashCode10) * 31;
        String str5 = this.clientMod;
        if (str5 == null) {
            hashCode11 = 0;
        } else {
            hashCode11 = str5.hashCode();
        }
        int i37 = (i36 + hashCode11) * 31;
        Integer num4 = this.deepLinkVersion;
        if (num4 == null) {
            hashCode12 = 0;
        } else {
            hashCode12 = num4.hashCode();
        }
        int i38 = (i37 + hashCode12) * 31;
        qq_ad_get.QQAdGet.DeviceInfo deviceInfo = this.deviceInfo;
        if (deviceInfo == null) {
            hashCode13 = 0;
        } else {
            hashCode13 = deviceInfo.hashCode();
        }
        int i39 = (i38 + hashCode13) * 31;
        access.VideoFeedInfo videoFeedInfo = this.videoFeedInfo;
        if (videoFeedInfo == null) {
            hashCode14 = 0;
        } else {
            hashCode14 = videoFeedInfo.hashCode();
        }
        int i46 = (i39 + hashCode14) * 31;
        boolean z16 = this.disableMaskReq;
        int i47 = z16;
        if (z16 != 0) {
            i47 = 1;
        }
        int i48 = (i46 + i47) * 31;
        access.QzoneInfo qzoneInfo = this.qzoneInfo;
        if (qzoneInfo != null) {
            i3 = qzoneInfo.hashCode();
        }
        return ((i48 + i3) * 31) + this.getAdType;
    }

    public final void setAdCount(@Nullable Integer num) {
        this.adCount = num;
    }

    public final void setAllowedCategory(@Nullable Integer num) {
        this.allowedCategory = num;
    }

    public final void setBannerAdPush(@NotNull ArrayList<String> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
        this.bannerAdPush = arrayList;
    }

    public final void setBusiType(@Nullable Integer num) {
        this.busiType = num;
    }

    public final void setClientMod(@Nullable String str) {
        this.clientMod = str;
    }

    public final void setDeepLinkVersion(@Nullable Integer num) {
        this.deepLinkVersion = num;
    }

    public final void setDeviceInfo(@Nullable qq_ad_get.QQAdGet.DeviceInfo deviceInfo) {
        this.deviceInfo = deviceInfo;
    }

    public final void setDisableMaskReq(boolean z16) {
        this.disableMaskReq = z16;
    }

    public final void setExtIds(@Nullable List<String> list) {
        this.extIds = list;
    }

    public final void setGetAdType(int i3) {
        this.getAdType = i3;
    }

    public final void setLastRequestCookie(@Nullable String str) {
        this.lastRequestCookie = str;
    }

    public final void setQzoneInfo(@Nullable access.QzoneInfo qzoneInfo) {
        this.qzoneInfo = qzoneInfo;
    }

    public final void setSourceFrom(@Nullable String str) {
        this.sourceFrom = str;
    }

    public final void setSpecifiedAdsJsonList(@Nullable ArrayList<JSONObject> arrayList) {
        this.specifiedAdsJsonList = arrayList;
    }

    public final void setSpecifiedTianShuAdsJsonList(@Nullable ArrayList<JSONObject> arrayList) {
        this.specifiedTianShuAdsJsonList = arrayList;
    }

    public final void setTargetPosId(@Nullable String str) {
        this.targetPosId = str;
    }

    public final void setTianShuPosId(@Nullable String str) {
        this.tianShuPosId = str;
    }

    public final void setUin(long j3) {
        this.uin = j3;
    }

    public final void setVideoFeedInfo(@Nullable access.VideoFeedInfo videoFeedInfo) {
        this.videoFeedInfo = videoFeedInfo;
    }

    @NotNull
    public String toString() {
        return "VasNewAdParams(advPos=" + this.advPos + ", uin=" + this.uin + ", busiType=" + this.busiType + ", adCount=" + this.adCount + ", specifiedAdsJsonList=" + this.specifiedAdsJsonList + ", specifiedTianShuAdsJsonList=" + this.specifiedTianShuAdsJsonList + ", targetPosId=" + this.targetPosId + ", tianShuPosId=" + this.tianShuPosId + ", sourceFrom=" + this.sourceFrom + ", bannerAdPush=" + this.bannerAdPush + ", lastRequestCookie=" + this.lastRequestCookie + ", extIds=" + this.extIds + ", allowedCategory=" + this.allowedCategory + ", clientMod=" + this.clientMod + ", deepLinkVersion=" + this.deepLinkVersion + ", deviceInfo=" + this.deviceInfo + ", videoFeedInfo=" + this.videoFeedInfo + ", disableMaskReq=" + this.disableMaskReq + ", qzoneInfo=" + this.qzoneInfo + ", getAdType=" + this.getAdType + ')';
    }
}
