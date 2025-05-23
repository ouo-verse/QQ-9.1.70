package com.tencent.mobileqq.wink.aigc.utils;

import com.google.gson.Gson;
import com.tencent.ark.ark;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import com.tencent.mobileqq.wink.request.QQWinkAIGCSafeCheckRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.light.aigc.AIGCClient;
import org.light.aigc.bean.AIGCRequest;
import org.light.aigc.bean.ContentInfo;
import org.light.aigc.bean.MediaType;
import org.light.aigc.config.AIGCConfig;
import org.light.aigc.config.EnvConfig;
import qshadow.ShadowAIGCSafe$Media;
import qshadow.ShadowAIGCSafe$SafeCheckRequest;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b \u0010!J&\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0002H\u0002J\b\u0010\t\u001a\u00020\bH\u0002J\b\u0010\u000b\u001a\u0004\u0018\u00010\nJI\u0010\u0016\u001a\u00020\u00152\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u00022\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0014\u001a\u00020\u0013\u00a2\u0006\u0004\b\u0016\u0010\u0017J\u0016\u0010\u001a\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u0002J\u0016\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u0002J\u001e\u0010\u001e\u001a\u00020\u00152\u0006\u0010\u001b\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u0002J\u0016\u0010\u001f\u001a\u00020\u00152\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u0002\u00a8\u0006\""}, d2 = {"Lcom/tencent/mobileqq/wink/aigc/utils/b;", "", "", "appid", "appEntry", "bundleID", "Lorg/light/aigc/config/AIGCConfig;", "a", "Lorg/light/aigc/config/EnvConfig;", "c", "Lorg/light/aigc/AIGCClient;", "i", "bizId", "desc", "styleId", "picPath", "safeId", "", "baseImageIndex", "", "isRetry", "Lorg/light/aigc/bean/AIGCRequest;", "g", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Z)Lorg/light/aigc/bean/AIGCRequest;", "url", ark.ARKMETADATA_JSON, "f", "imageUrl", "Lcom/tencent/mobileqq/wink/request/QQWinkAIGCSafeCheckRequest;", "e", h.F, "d", "<init>", "()V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final b f317941a = new b();

    b() {
    }

    private final AIGCConfig a(String appid, String appEntry, String bundleID) {
        AIGCConfig aIGCConfig = new AIGCConfig();
        aIGCConfig.appID = appid;
        aIGCConfig.appEntry = appEntry;
        aIGCConfig.bundleID = bundleID;
        return aIGCConfig;
    }

    static /* synthetic */ AIGCConfig b(b bVar, String str, String str2, String str3, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = "lightsdk_qq";
        }
        if ((i3 & 2) != 0) {
            str2 = QQWinkConstants.ENTRY_QQ_WORLD;
        }
        if ((i3 & 4) != 0) {
            str3 = "";
        }
        return bVar.a(str, str2, str3);
    }

    private final EnvConfig c() {
        EnvConfig envConfig = new EnvConfig();
        envConfig.ssoProvider = a.f317937a;
        return envConfig;
    }

    @NotNull
    public final AIGCRequest d(@NotNull String bizId, @NotNull String url) {
        ArrayList arrayListOf;
        Intrinsics.checkNotNullParameter(bizId, "bizId");
        Intrinsics.checkNotNullParameter(url, "url");
        AIGCRequest aIGCRequest = new AIGCRequest();
        aIGCRequest.bussId = bizId;
        aIGCRequest.functionId = "image_detect";
        ContentInfo contentInfo = new ContentInfo();
        contentInfo.type = MediaType.TypeImage;
        contentInfo.stringData = url;
        Unit unit = Unit.INSTANCE;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(contentInfo);
        aIGCRequest.contentInfos = arrayListOf;
        aIGCRequest.extra = "";
        return aIGCRequest;
    }

    @NotNull
    public final QQWinkAIGCSafeCheckRequest e(@NotNull String bizId, @NotNull String imageUrl) {
        Intrinsics.checkNotNullParameter(bizId, "bizId");
        Intrinsics.checkNotNullParameter(imageUrl, "imageUrl");
        ShadowAIGCSafe$Media shadowAIGCSafe$Media = new ShadowAIGCSafe$Media();
        shadowAIGCSafe$Media.type.set(1);
        shadowAIGCSafe$Media.string_data.set(imageUrl);
        ArrayList arrayList = new ArrayList();
        arrayList.add(shadowAIGCSafe$Media);
        ShadowAIGCSafe$SafeCheckRequest shadowAIGCSafe$SafeCheckRequest = new ShadowAIGCSafe$SafeCheckRequest();
        shadowAIGCSafe$SafeCheckRequest.busi_id.set(bizId);
        shadowAIGCSafe$SafeCheckRequest.medias.set(arrayList);
        shadowAIGCSafe$SafeCheckRequest.is_sync.set(false);
        return new QQWinkAIGCSafeCheckRequest(shadowAIGCSafe$SafeCheckRequest);
    }

    @NotNull
    public final AIGCRequest f(@NotNull String url, @NotNull String json) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(json, "json");
        AIGCRequest aIGCRequest = new AIGCRequest();
        aIGCRequest.bussId = "qq_aiavatar";
        ArrayList arrayList = new ArrayList();
        aIGCRequest.contentInfos = arrayList;
        ContentInfo contentInfo = new ContentInfo();
        contentInfo.type = MediaType.TypeImage;
        contentInfo.stringData = url;
        contentInfo.extra = json;
        arrayList.add(contentInfo);
        aIGCRequest.extra = "";
        return aIGCRequest;
    }

    @NotNull
    public final AIGCRequest g(@NotNull String bizId, @NotNull String desc, @NotNull String styleId, @NotNull String picPath, @NotNull String safeId, @Nullable Integer baseImageIndex, boolean isRetry) {
        boolean z16;
        Map mutableMapOf;
        boolean z17;
        Map mapOf;
        String str;
        Intrinsics.checkNotNullParameter(bizId, "bizId");
        Intrinsics.checkNotNullParameter(desc, "desc");
        Intrinsics.checkNotNullParameter(styleId, "styleId");
        Intrinsics.checkNotNullParameter(picPath, "picPath");
        Intrinsics.checkNotNullParameter(safeId, "safeId");
        AIGCRequest aIGCRequest = new AIGCRequest();
        aIGCRequest.bussId = bizId;
        aIGCRequest.contentInfos = new ArrayList();
        if (picPath.length() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        String str2 = "";
        if (z16) {
            List<ContentInfo> list = aIGCRequest.contentInfos;
            ContentInfo contentInfo = new ContentInfo();
            contentInfo.type = MediaType.TypeImage;
            contentInfo.stringData = picPath;
            if (safeId.length() > 0) {
                z17 = true;
            } else {
                z17 = false;
            }
            if (z17) {
                mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("msg_id", safeId));
                try {
                    str = new Gson().toJson(mapOf);
                } catch (Exception unused) {
                    str = "";
                }
                contentInfo.extra = str;
            }
            list.add(contentInfo);
        }
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("prompt", desc), TuplesKt.to("style", styleId));
        if (baseImageIndex != null) {
            mutableMapOf.put("index", Integer.valueOf(baseImageIndex.intValue()));
        }
        mutableMapOf.put("is_retry", Boolean.valueOf(isRetry));
        try {
            str2 = new Gson().toJson(mutableMapOf);
        } catch (Exception unused2) {
        }
        aIGCRequest.extra = str2;
        return aIGCRequest;
    }

    @NotNull
    public final AIGCRequest h(@NotNull String imageUrl, @NotNull String styleId, @NotNull String safeId) {
        boolean z16;
        Map mapOf;
        Map mapOf2;
        String str;
        Intrinsics.checkNotNullParameter(imageUrl, "imageUrl");
        Intrinsics.checkNotNullParameter(styleId, "styleId");
        Intrinsics.checkNotNullParameter(safeId, "safeId");
        AIGCRequest aIGCRequest = new AIGCRequest();
        aIGCRequest.bussId = "opening_ending";
        aIGCRequest.functionId = "ai_picture_generate";
        ArrayList arrayList = new ArrayList();
        aIGCRequest.contentInfos = arrayList;
        ContentInfo contentInfo = new ContentInfo();
        contentInfo.type = MediaType.TypeImage;
        contentInfo.stringData = imageUrl;
        if (safeId.length() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        String str2 = "";
        if (z16) {
            mapOf2 = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("msg_id", safeId));
            try {
                str = new Gson().toJson(mapOf2);
            } catch (Exception unused) {
                str = "";
            }
            contentInfo.extra = str;
        }
        arrayList.add(contentInfo);
        mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("style", styleId));
        try {
            str2 = new Gson().toJson(mapOf);
        } catch (Exception unused2) {
        }
        aIGCRequest.extra = str2;
        return aIGCRequest;
    }

    @Nullable
    public final AIGCClient i() {
        return AIGCClient.make(b(this, null, null, null, 7, null), c());
    }
}
