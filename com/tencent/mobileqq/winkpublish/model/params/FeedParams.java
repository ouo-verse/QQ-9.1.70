package com.tencent.mobileqq.winkpublish.model.params;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.mini.servlet.MiniAppGetTeenagerConfigServlet;
import com.tencent.mobileqq.wink.model.DailyInfo;
import com.tencent.mobileqq.wink.model.DeclarationParams;
import com.tencent.mobileqq.winkpublish.model.PromotionParams;
import com.tencent.sqshow.zootopia.publish.ZPlanPublishSource;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u008c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\bF\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0086\b\u0018\u0000 ~2\u00020\u0001:\u0002}~B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004B\u00f9\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\t\u0012\b\b\u0002\u0010\u000b\u001a\u00020\t\u0012\b\b\u0002\u0010\f\u001a\u00020\u0006\u0012\b\b\u0002\u0010\r\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u000f\u001a\u00020\t\u0012\u0010\b\u0002\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0011\u0012\u0010\b\u0002\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0011\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0014\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0016\u0012\u0010\b\u0002\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0011\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001a\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001c\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u001e\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010 \u0012(\b\u0002\u0010!\u001a\"\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\"j\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u0001`#\u0012$\b\u0002\u0010$\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\"j\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006`#\u0012\b\b\u0002\u0010%\u001a\u00020\t\u0012\b\b\u0002\u0010&\u001a\u00020\u0006\u0012\n\b\u0002\u0010'\u001a\u0004\u0018\u00010(\u0012\b\b\u0002\u0010)\u001a\u00020\u0006\u0012\n\b\u0002\u0010*\u001a\u0004\u0018\u00010+\u0012\n\b\u0002\u0010,\u001a\u0004\u0018\u00010-\u0012\n\b\u0002\u0010.\u001a\u0004\u0018\u00010/\u00a2\u0006\u0002\u00100J\t\u0010W\u001a\u00020\u0006H\u00c6\u0003J\u0011\u0010X\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0011H\u00c6\u0003J\u0011\u0010Y\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0011H\u00c6\u0003J\u000b\u0010Z\u001a\u0004\u0018\u00010\u0014H\u00c6\u0003J\u000b\u0010[\u001a\u0004\u0018\u00010\u0016H\u00c6\u0003J\u0011\u0010\\\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0011H\u00c6\u0003J\u000b\u0010]\u001a\u0004\u0018\u00010\u001aH\u00c6\u0003J\u000b\u0010^\u001a\u0004\u0018\u00010\u001cH\u00c6\u0003J\t\u0010_\u001a\u00020\u001eH\u00c6\u0003J\u000b\u0010`\u001a\u0004\u0018\u00010 H\u00c6\u0003J)\u0010a\u001a\"\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\"j\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u0001`#H\u00c6\u0003J\t\u0010b\u001a\u00020\u0006H\u00c6\u0003J%\u0010c\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\"j\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006`#H\u00c6\u0003J\t\u0010d\u001a\u00020\tH\u00c6\u0003J\t\u0010e\u001a\u00020\u0006H\u00c6\u0003J\u000b\u0010f\u001a\u0004\u0018\u00010(H\u00c6\u0003J\t\u0010g\u001a\u00020\u0006H\u00c6\u0003J\u000b\u0010h\u001a\u0004\u0018\u00010+H\u00c6\u0003J\u000b\u0010i\u001a\u0004\u0018\u00010-H\u00c6\u0003J\u000b\u0010j\u001a\u0004\u0018\u00010/H\u00c6\u0003J\t\u0010k\u001a\u00020\tH\u00c6\u0003J\t\u0010l\u001a\u00020\tH\u00c6\u0003J\t\u0010m\u001a\u00020\tH\u00c6\u0003J\t\u0010n\u001a\u00020\u0006H\u00c6\u0003J\t\u0010o\u001a\u00020\u0006H\u00c6\u0003J\t\u0010p\u001a\u00020\u0006H\u00c6\u0003J\t\u0010q\u001a\u00020\tH\u00c6\u0003J\u00fd\u0002\u0010r\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\t2\b\b\u0002\u0010\f\u001a\u00020\u00062\b\b\u0002\u0010\r\u001a\u00020\u00062\b\b\u0002\u0010\u000e\u001a\u00020\u00062\b\b\u0002\u0010\u000f\u001a\u00020\t2\u0010\b\u0002\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00112\u0010\b\u0002\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00112\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0010\b\u0002\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u00112\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\b\b\u0002\u0010\u001d\u001a\u00020\u001e2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010 2(\b\u0002\u0010!\u001a\"\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\"j\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u0001`#2$\b\u0002\u0010$\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\"j\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006`#2\b\b\u0002\u0010%\u001a\u00020\t2\b\b\u0002\u0010&\u001a\u00020\u00062\n\b\u0002\u0010'\u001a\u0004\u0018\u00010(2\b\b\u0002\u0010)\u001a\u00020\u00062\n\b\u0002\u0010*\u001a\u0004\u0018\u00010+2\n\b\u0002\u0010,\u001a\u0004\u0018\u00010-2\n\b\u0002\u0010.\u001a\u0004\u0018\u00010/H\u00c6\u0001J\b\u0010s\u001a\u00020\u001eH\u0016J\u0013\u0010t\u001a\u00020\t2\b\u0010u\u001a\u0004\u0018\u00010vH\u00d6\u0003J\u0006\u0010w\u001a\u00020\u0006J\t\u0010x\u001a\u00020\u001eH\u00d6\u0001J\t\u0010y\u001a\u00020\u0006H\u00d6\u0001J\u0018\u0010z\u001a\u00020{2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010|\u001a\u00020\u001eH\u0016R\u0011\u0010\r\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b1\u00102R\u0013\u0010\u001f\u001a\u0004\u0018\u00010 \u00a2\u0006\b\n\u0000\u001a\u0004\b3\u00104R\u0011\u0010\u0007\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b5\u00102R\u0013\u0010.\u001a\u0004\u0018\u00010/\u00a2\u0006\b\n\u0000\u001a\u0004\b6\u00107R\u0011\u0010)\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b8\u00102R\u0013\u0010,\u001a\u0004\u0018\u00010-\u00a2\u0006\b\n\u0000\u001a\u0004\b9\u0010:R1\u0010!\u001a\"\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\"j\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u0001`#\u00a2\u0006\b\n\u0000\u001a\u0004\b;\u0010<R\u0013\u0010*\u001a\u0004\u0018\u00010+\u00a2\u0006\b\n\u0000\u001a\u0004\b=\u0010>R\u0019\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0011\u00a2\u0006\b\n\u0000\u001a\u0004\b?\u0010@R\u0011\u0010\n\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010AR\u0011\u0010\u000f\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010AR\u0011\u0010\b\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010AR\u0013\u0010'\u001a\u0004\u0018\u00010(\u00a2\u0006\b\n\u0000\u001a\u0004\bB\u0010CR\u0013\u0010\u0013\u001a\u0004\u0018\u00010\u0014\u00a2\u0006\b\n\u0000\u001a\u0004\bD\u0010ER\u0011\u0010\u000b\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\bF\u0010AR\u0011\u0010%\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\bG\u0010AR\u0013\u0010\u0015\u001a\u0004\u0018\u00010\u0016\u00a2\u0006\b\n\u0000\u001a\u0004\bH\u0010IR\u0013\u0010\u0019\u001a\u0004\u0018\u00010\u001a\u00a2\u0006\b\n\u0000\u001a\u0004\bJ\u0010KR-\u0010$\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\"j\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006`#\u00a2\u0006\b\n\u0000\u001a\u0004\bL\u0010<R\u0011\u0010\f\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\bM\u00102R\u0013\u0010\u001b\u001a\u0004\u0018\u00010\u001c\u00a2\u0006\b\n\u0000\u001a\u0004\bN\u0010OR\u0019\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0011\u00a2\u0006\b\n\u0000\u001a\u0004\bP\u0010@R\u0011\u0010&\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\bQ\u00102R\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\bR\u00102R\u0011\u0010\u001d\u001a\u00020\u001e\u00a2\u0006\b\n\u0000\u001a\u0004\bS\u0010TR\u0019\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0011\u00a2\u0006\b\n\u0000\u001a\u0004\bU\u0010@R\u0011\u0010\u000e\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\bV\u00102\u00a8\u0006\u007f"}, d2 = {"Lcom/tencent/mobileqq/winkpublish/model/params/FeedParams;", "Landroid/os/Parcelable;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "title", "", "content", "isSyncToQzone", "", "isNearbyRecommend", "needSaveMedia", ZPlanPublishSource.FROM_SCHEME, "advJobId", "videoSourceInfo", "isPublic", "groupId", "", "uinId", "musicParams", "Lcom/tencent/mobileqq/winkpublish/model/params/MusicParams;", "poiParams", "Lcom/tencent/mobileqq/winkpublish/model/params/PoiParams;", "tagParams", "Lcom/tencent/mobileqq/winkpublish/model/params/TagParams;", "promotionParams", "Lcom/tencent/mobileqq/winkpublish/model/params/PromotionPublishParams;", "schoolParams", "Lcom/tencent/mobileqq/winkpublish/model/params/SchoolParams;", "typeParams", "", "businessShareParams", "Lcom/tencent/mobileqq/winkpublish/model/params/BusinessShareParams;", "extInfo", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", MiniAppGetTeenagerConfigServlet.KEY_REQUEST_EXT_INFO, "notAllowDownload", "tianshuActivityItemValue", "liteBanner", "Lcom/tencent/mobileqq/winkpublish/model/params/LiteBanner;", "declarationId", "feedExtraInfo", "Lcom/tencent/mobileqq/winkpublish/model/params/FeedExtraInfo;", "declarationParams", "Lcom/tencent/mobileqq/wink/model/DeclarationParams;", "dailyParams", "Lcom/tencent/mobileqq/wink/model/DailyInfo;", "(Ljava/lang/String;Ljava/lang/String;ZZZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/util/List;Ljava/util/List;Lcom/tencent/mobileqq/winkpublish/model/params/MusicParams;Lcom/tencent/mobileqq/winkpublish/model/params/PoiParams;Ljava/util/List;Lcom/tencent/mobileqq/winkpublish/model/params/PromotionPublishParams;Lcom/tencent/mobileqq/winkpublish/model/params/SchoolParams;ILcom/tencent/mobileqq/winkpublish/model/params/BusinessShareParams;Ljava/util/HashMap;Ljava/util/HashMap;ZLjava/lang/String;Lcom/tencent/mobileqq/winkpublish/model/params/LiteBanner;Ljava/lang/String;Lcom/tencent/mobileqq/winkpublish/model/params/FeedExtraInfo;Lcom/tencent/mobileqq/wink/model/DeclarationParams;Lcom/tencent/mobileqq/wink/model/DailyInfo;)V", "getAdvJobId", "()Ljava/lang/String;", "getBusinessShareParams", "()Lcom/tencent/mobileqq/winkpublish/model/params/BusinessShareParams;", "getContent", "getDailyParams", "()Lcom/tencent/mobileqq/wink/model/DailyInfo;", "getDeclarationId", "getDeclarationParams", "()Lcom/tencent/mobileqq/wink/model/DeclarationParams;", "getExtInfo", "()Ljava/util/HashMap;", "getFeedExtraInfo", "()Lcom/tencent/mobileqq/winkpublish/model/params/FeedExtraInfo;", "getGroupId", "()Ljava/util/List;", "()Z", "getLiteBanner", "()Lcom/tencent/mobileqq/winkpublish/model/params/LiteBanner;", "getMusicParams", "()Lcom/tencent/mobileqq/winkpublish/model/params/MusicParams;", "getNeedSaveMedia", "getNotAllowDownload", "getPoiParams", "()Lcom/tencent/mobileqq/winkpublish/model/params/PoiParams;", "getPromotionParams", "()Lcom/tencent/mobileqq/winkpublish/model/params/PromotionPublishParams;", "getRequestExtInfo", "getScheme", "getSchoolParams", "()Lcom/tencent/mobileqq/winkpublish/model/params/SchoolParams;", "getTagParams", "getTianshuActivityItemValue", "getTitle", "getTypeParams", "()I", "getUinId", "getVideoSourceInfo", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "component27", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "describeContents", "equals", "other", "", "getTagsAsString", "hashCode", "toString", "writeToParcel", "", WadlProxyConsts.FLAGS, "Builder", "Companion", "qq-winkpublish-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes21.dex */
public final /* data */ class FeedParams implements Parcelable {

    @NotNull
    private static final String TAG = "FeedParams";

    @NotNull
    private final String advJobId;

    @Nullable
    private final BusinessShareParams businessShareParams;

    @NotNull
    private final String content;

    @Nullable
    private final DailyInfo dailyParams;

    @NotNull
    private final String declarationId;

    @Nullable
    private final DeclarationParams declarationParams;

    @Nullable
    private final HashMap<String, String> extInfo;

    @Nullable
    private final FeedExtraInfo feedExtraInfo;

    @Nullable
    private final List<String> groupId;
    private final boolean isNearbyRecommend;
    private final boolean isPublic;
    private final boolean isSyncToQzone;

    @Nullable
    private final LiteBanner liteBanner;

    @Nullable
    private final MusicParams musicParams;
    private final boolean needSaveMedia;
    private final boolean notAllowDownload;

    @Nullable
    private final PoiParams poiParams;

    @Nullable
    private final PromotionPublishParams promotionParams;

    @NotNull
    private final HashMap<String, String> requestExtInfo;

    @NotNull
    private final String scheme;

    @Nullable
    private final SchoolParams schoolParams;

    @Nullable
    private final List<TagParams> tagParams;

    @NotNull
    private final String tianshuActivityItemValue;

    @NotNull
    private final String title;
    private final int typeParams;

    @Nullable
    private final List<String> uinId;

    @NotNull
    private final String videoSourceInfo;

    @JvmField
    @NotNull
    public static final Parcelable.Creator<FeedParams> CREATOR = new Parcelable.Creator<FeedParams>() { // from class: com.tencent.mobileqq.winkpublish.model.params.FeedParams$Companion$CREATOR$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public FeedParams createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new FeedParams(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public FeedParams[] newArray(int size) {
            return new FeedParams[size];
        }
    };

    @Metadata(d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u001d\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010.\u001a\u00020/J\u000e\u00100\u001a\u00020\u00002\u0006\u00101\u001a\u00020\u0004J\u000e\u00102\u001a\u00020\u00002\u0006\u00101\u001a\u00020\u0004J\u0010\u00103\u001a\u00020\u00002\b\u00101\u001a\u0004\u0018\u00010\u0006J\u000e\u00104\u001a\u00020\u00002\u0006\u00101\u001a\u00020\u0004J\u0010\u00105\u001a\u00020\u00002\b\u00101\u001a\u0004\u0018\u00010\tJ\u0010\u00106\u001a\u00020\u00002\b\u00101\u001a\u0004\u0018\u00010\u0004J\u0010\u00107\u001a\u00020\u00002\b\u00101\u001a\u0004\u0018\u00010\fJ.\u00108\u001a\u00020\u00002&\u00101\u001a\"\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u000ej\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u000fJ\u0010\u00109\u001a\u00020\u00002\b\u00101\u001a\u0004\u0018\u00010\u0011J\u0016\u0010:\u001a\u00020\u00002\u000e\u00101\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0013J\u0010\u0010;\u001a\u00020\u00002\b\u00101\u001a\u0004\u0018\u00010\u0019J\u0010\u0010<\u001a\u00020\u00002\b\u00101\u001a\u0004\u0018\u00010\u001bJ\u000e\u0010=\u001a\u00020\u00002\u0006\u00101\u001a\u00020\u0015J\u000e\u0010>\u001a\u00020\u00002\u0006\u00101\u001a\u00020\u0015J\u0010\u0010?\u001a\u00020\u00002\b\u00101\u001a\u0004\u0018\u00010\u001fJ\u0010\u0010@\u001a\u00020\u00002\b\u00101\u001a\u0004\u0018\u00010!J\u000e\u0010A\u001a\u00020\u00002\u0006\u00101\u001a\u00020\u0015J.\u0010B\u001a\u00020\u00002&\u00101\u001a\"\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u000ej\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u000fJ\u000e\u0010C\u001a\u00020\u00002\u0006\u00101\u001a\u00020\u0015J\u000e\u0010D\u001a\u00020\u00002\u0006\u00101\u001a\u00020\u0004J\u0010\u0010E\u001a\u00020\u00002\b\u00101\u001a\u0004\u0018\u00010%J\u000e\u0010F\u001a\u00020\u00002\u0006\u00101\u001a\u00020\u0015J\u0016\u0010G\u001a\u00020\u00002\u000e\u00101\u001a\n\u0012\u0004\u0012\u00020'\u0018\u00010\u0013J\u000e\u0010H\u001a\u00020\u00002\u0006\u00101\u001a\u00020\u0004J\u000e\u0010I\u001a\u00020\u00002\u0006\u00101\u001a\u00020+J\u0016\u0010J\u001a\u00020\u00002\u000e\u00101\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0013J\u000e\u0010K\u001a\u00020\u00002\u0006\u00101\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R.\u0010\r\u001a\"\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u000ej\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u000fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0013X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0015X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0015X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0015X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0015X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010 \u001a\u0004\u0018\u00010!X\u0082\u000e\u00a2\u0006\u0002\n\u0000R*\u0010\"\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u000ej\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004`\u000fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010$\u001a\u0004\u0018\u00010%X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0016\u0010&\u001a\n\u0012\u0004\u0012\u00020'\u0018\u00010\u0013X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020+X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0016\u0010,\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0013X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006L"}, d2 = {"Lcom/tencent/mobileqq/winkpublish/model/params/FeedParams$Builder;", "", "()V", "advJobId", "", "businessShareParams", "Lcom/tencent/mobileqq/winkpublish/model/params/BusinessShareParams;", "content", "dailyParams", "Lcom/tencent/mobileqq/wink/model/DailyInfo;", "declarationId", "declarationParams", "Lcom/tencent/mobileqq/wink/model/DeclarationParams;", "extInfo", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "feedExtraInfo", "Lcom/tencent/mobileqq/winkpublish/model/params/FeedExtraInfo;", "groupId", "", "isNearbyRecommend", "", "isPublic", "isSyncToQzone", "liteBanner", "Lcom/tencent/mobileqq/winkpublish/model/params/LiteBanner;", "musicParams", "Lcom/tencent/mobileqq/winkpublish/model/params/MusicParams;", "needSaveMedia", "notAllowDownload", "poiParams", "Lcom/tencent/mobileqq/winkpublish/model/params/PoiParams;", "promotionParams", "Lcom/tencent/mobileqq/winkpublish/model/params/PromotionPublishParams;", MiniAppGetTeenagerConfigServlet.KEY_REQUEST_EXT_INFO, ZPlanPublishSource.FROM_SCHEME, "schoolParams", "Lcom/tencent/mobileqq/winkpublish/model/params/SchoolParams;", "tagParams", "Lcom/tencent/mobileqq/winkpublish/model/params/TagParams;", "tianshuActivityItemValue", "title", "typeParams", "", "uinId", "videoSourceInfo", "build", "Lcom/tencent/mobileqq/winkpublish/model/params/FeedParams;", "withActivityItemValue", "value", "withAdvJobId", "withBusinessShare", "withContent", "withDailyParams", "withDeclaration", "withDeclarationParams", "withExtInfo", "withFeedExtraInfo", "withGroupId", "withLiteBanner", "withMusic", "withNearByRecommend", "withNotAllowDownload", "withPoi", "withPromotion", "withPublic", "withRequestExtInfo", "withSaveMedia", "withScheme", "withSchool", "withSyncToQzone", "withTag", "withTitle", "withType", "withUinId", "withVideoSourceInfo", "qq-winkpublish-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes21.dex */
    public static final class Builder {

        @Nullable
        private BusinessShareParams businessShareParams;

        @Nullable
        private DailyInfo dailyParams;

        @Nullable
        private DeclarationParams declarationParams;

        @Nullable
        private HashMap<String, String> extInfo;

        @Nullable
        private FeedExtraInfo feedExtraInfo;

        @Nullable
        private List<String> groupId;
        private boolean isSyncToQzone;

        @Nullable
        private LiteBanner liteBanner;

        @Nullable
        private MusicParams musicParams;
        private boolean needSaveMedia;
        private boolean notAllowDownload;

        @Nullable
        private PoiParams poiParams;

        @Nullable
        private PromotionPublishParams promotionParams;

        @Nullable
        private SchoolParams schoolParams;

        @Nullable
        private List<TagParams> tagParams;
        private int typeParams;

        @Nullable
        private List<String> uinId;

        @NotNull
        private String title = "";

        @NotNull
        private String content = "";
        private boolean isNearbyRecommend = true;

        @NotNull
        private String scheme = "";

        @NotNull
        private String advJobId = "";

        @NotNull
        private String videoSourceInfo = "";
        private boolean isPublic = true;

        @NotNull
        private HashMap<String, String> requestExtInfo = new HashMap<>();

        @NotNull
        private String tianshuActivityItemValue = "";

        @NotNull
        private String declarationId = "";

        @NotNull
        public final FeedParams build() {
            return new FeedParams(this.title, this.content, this.isSyncToQzone, this.isNearbyRecommend, this.needSaveMedia, this.scheme, this.advJobId, this.videoSourceInfo, this.isPublic, this.groupId, this.uinId, this.musicParams, this.poiParams, this.tagParams, this.promotionParams, this.schoolParams, this.typeParams, this.businessShareParams, this.extInfo, this.requestExtInfo, this.notAllowDownload, this.tianshuActivityItemValue, this.liteBanner, this.declarationId, this.feedExtraInfo, this.declarationParams, this.dailyParams);
        }

        @NotNull
        public final Builder withActivityItemValue(@NotNull String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            this.tianshuActivityItemValue = value;
            return this;
        }

        @NotNull
        public final Builder withAdvJobId(@NotNull String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            this.advJobId = value;
            return this;
        }

        @NotNull
        public final Builder withBusinessShare(@Nullable BusinessShareParams value) {
            this.businessShareParams = value;
            return this;
        }

        @NotNull
        public final Builder withContent(@NotNull String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            this.content = value;
            return this;
        }

        @NotNull
        public final Builder withDailyParams(@Nullable DailyInfo value) {
            if (value != null) {
                this.dailyParams = value;
            }
            return this;
        }

        @NotNull
        public final Builder withDeclaration(@Nullable String value) {
            if (value != null) {
                this.declarationId = value;
            }
            return this;
        }

        @NotNull
        public final Builder withDeclarationParams(@Nullable DeclarationParams value) {
            if (value != null) {
                this.declarationParams = value;
            }
            return this;
        }

        @NotNull
        public final Builder withExtInfo(@Nullable HashMap<String, String> value) {
            this.extInfo = value;
            return this;
        }

        @NotNull
        public final Builder withFeedExtraInfo(@Nullable FeedExtraInfo value) {
            if (value != null) {
                this.feedExtraInfo = value;
            }
            return this;
        }

        @NotNull
        public final Builder withGroupId(@Nullable List<String> value) {
            this.groupId = value;
            return this;
        }

        @NotNull
        public final Builder withLiteBanner(@Nullable LiteBanner value) {
            if (value != null) {
                this.liteBanner = value;
            }
            return this;
        }

        @NotNull
        public final Builder withMusic(@Nullable MusicParams value) {
            this.musicParams = value;
            return this;
        }

        @NotNull
        public final Builder withNearByRecommend(boolean value) {
            this.isNearbyRecommend = value;
            return this;
        }

        @NotNull
        public final Builder withNotAllowDownload(boolean value) {
            this.notAllowDownload = value;
            return this;
        }

        @NotNull
        public final Builder withPoi(@Nullable PoiParams value) {
            this.poiParams = value;
            return this;
        }

        @NotNull
        public final Builder withPromotion(@Nullable PromotionPublishParams value) {
            this.promotionParams = value;
            return this;
        }

        @NotNull
        public final Builder withPublic(boolean value) {
            this.isPublic = value;
            return this;
        }

        @NotNull
        public final Builder withRequestExtInfo(@Nullable HashMap<String, String> value) {
            if (value != null) {
                this.requestExtInfo = value;
            }
            return this;
        }

        @NotNull
        public final Builder withSaveMedia(boolean value) {
            this.needSaveMedia = value;
            return this;
        }

        @NotNull
        public final Builder withScheme(@NotNull String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            this.scheme = value;
            return this;
        }

        @NotNull
        public final Builder withSchool(@Nullable SchoolParams value) {
            this.schoolParams = value;
            return this;
        }

        @NotNull
        public final Builder withSyncToQzone(boolean value) {
            this.isSyncToQzone = value;
            return this;
        }

        @NotNull
        public final Builder withTag(@Nullable List<TagParams> value) {
            this.tagParams = value;
            return this;
        }

        @NotNull
        public final Builder withTitle(@NotNull String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            this.title = value;
            return this;
        }

        @NotNull
        public final Builder withType(int value) {
            this.typeParams = value;
            return this;
        }

        @NotNull
        public final Builder withUinId(@Nullable List<String> value) {
            this.uinId = value;
            return this;
        }

        @NotNull
        public final Builder withVideoSourceInfo(@NotNull String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            this.videoSourceInfo = value;
            return this;
        }
    }

    public FeedParams() {
        this(null, null, false, false, false, null, null, null, false, null, null, null, null, null, null, null, 0, null, null, null, false, null, null, null, null, null, null, 134217727, null);
    }

    @NotNull
    /* renamed from: component1, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    @Nullable
    public final List<String> component10() {
        return this.groupId;
    }

    @Nullable
    public final List<String> component11() {
        return this.uinId;
    }

    @Nullable
    /* renamed from: component12, reason: from getter */
    public final MusicParams getMusicParams() {
        return this.musicParams;
    }

    @Nullable
    /* renamed from: component13, reason: from getter */
    public final PoiParams getPoiParams() {
        return this.poiParams;
    }

    @Nullable
    public final List<TagParams> component14() {
        return this.tagParams;
    }

    @Nullable
    /* renamed from: component15, reason: from getter */
    public final PromotionPublishParams getPromotionParams() {
        return this.promotionParams;
    }

    @Nullable
    /* renamed from: component16, reason: from getter */
    public final SchoolParams getSchoolParams() {
        return this.schoolParams;
    }

    /* renamed from: component17, reason: from getter */
    public final int getTypeParams() {
        return this.typeParams;
    }

    @Nullable
    /* renamed from: component18, reason: from getter */
    public final BusinessShareParams getBusinessShareParams() {
        return this.businessShareParams;
    }

    @Nullable
    public final HashMap<String, String> component19() {
        return this.extInfo;
    }

    @NotNull
    /* renamed from: component2, reason: from getter */
    public final String getContent() {
        return this.content;
    }

    @NotNull
    public final HashMap<String, String> component20() {
        return this.requestExtInfo;
    }

    /* renamed from: component21, reason: from getter */
    public final boolean getNotAllowDownload() {
        return this.notAllowDownload;
    }

    @NotNull
    /* renamed from: component22, reason: from getter */
    public final String getTianshuActivityItemValue() {
        return this.tianshuActivityItemValue;
    }

    @Nullable
    /* renamed from: component23, reason: from getter */
    public final LiteBanner getLiteBanner() {
        return this.liteBanner;
    }

    @NotNull
    /* renamed from: component24, reason: from getter */
    public final String getDeclarationId() {
        return this.declarationId;
    }

    @Nullable
    /* renamed from: component25, reason: from getter */
    public final FeedExtraInfo getFeedExtraInfo() {
        return this.feedExtraInfo;
    }

    @Nullable
    /* renamed from: component26, reason: from getter */
    public final DeclarationParams getDeclarationParams() {
        return this.declarationParams;
    }

    @Nullable
    /* renamed from: component27, reason: from getter */
    public final DailyInfo getDailyParams() {
        return this.dailyParams;
    }

    /* renamed from: component3, reason: from getter */
    public final boolean getIsSyncToQzone() {
        return this.isSyncToQzone;
    }

    /* renamed from: component4, reason: from getter */
    public final boolean getIsNearbyRecommend() {
        return this.isNearbyRecommend;
    }

    /* renamed from: component5, reason: from getter */
    public final boolean getNeedSaveMedia() {
        return this.needSaveMedia;
    }

    @NotNull
    /* renamed from: component6, reason: from getter */
    public final String getScheme() {
        return this.scheme;
    }

    @NotNull
    /* renamed from: component7, reason: from getter */
    public final String getAdvJobId() {
        return this.advJobId;
    }

    @NotNull
    /* renamed from: component8, reason: from getter */
    public final String getVideoSourceInfo() {
        return this.videoSourceInfo;
    }

    /* renamed from: component9, reason: from getter */
    public final boolean getIsPublic() {
        return this.isPublic;
    }

    @NotNull
    public final FeedParams copy(@NotNull String title, @NotNull String content, boolean isSyncToQzone, boolean isNearbyRecommend, boolean needSaveMedia, @NotNull String scheme, @NotNull String advJobId, @NotNull String videoSourceInfo, boolean isPublic, @Nullable List<String> groupId, @Nullable List<String> uinId, @Nullable MusicParams musicParams, @Nullable PoiParams poiParams, @Nullable List<TagParams> tagParams, @Nullable PromotionPublishParams promotionParams, @Nullable SchoolParams schoolParams, int typeParams, @Nullable BusinessShareParams businessShareParams, @Nullable HashMap<String, String> extInfo, @NotNull HashMap<String, String> requestExtInfo, boolean notAllowDownload, @NotNull String tianshuActivityItemValue, @Nullable LiteBanner liteBanner, @NotNull String declarationId, @Nullable FeedExtraInfo feedExtraInfo, @Nullable DeclarationParams declarationParams, @Nullable DailyInfo dailyParams) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(content, "content");
        Intrinsics.checkNotNullParameter(scheme, "scheme");
        Intrinsics.checkNotNullParameter(advJobId, "advJobId");
        Intrinsics.checkNotNullParameter(videoSourceInfo, "videoSourceInfo");
        Intrinsics.checkNotNullParameter(requestExtInfo, "requestExtInfo");
        Intrinsics.checkNotNullParameter(tianshuActivityItemValue, "tianshuActivityItemValue");
        Intrinsics.checkNotNullParameter(declarationId, "declarationId");
        return new FeedParams(title, content, isSyncToQzone, isNearbyRecommend, needSaveMedia, scheme, advJobId, videoSourceInfo, isPublic, groupId, uinId, musicParams, poiParams, tagParams, promotionParams, schoolParams, typeParams, businessShareParams, extInfo, requestExtInfo, notAllowDownload, tianshuActivityItemValue, liteBanner, declarationId, feedExtraInfo, declarationParams, dailyParams);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FeedParams)) {
            return false;
        }
        FeedParams feedParams = (FeedParams) other;
        if (Intrinsics.areEqual(this.title, feedParams.title) && Intrinsics.areEqual(this.content, feedParams.content) && this.isSyncToQzone == feedParams.isSyncToQzone && this.isNearbyRecommend == feedParams.isNearbyRecommend && this.needSaveMedia == feedParams.needSaveMedia && Intrinsics.areEqual(this.scheme, feedParams.scheme) && Intrinsics.areEqual(this.advJobId, feedParams.advJobId) && Intrinsics.areEqual(this.videoSourceInfo, feedParams.videoSourceInfo) && this.isPublic == feedParams.isPublic && Intrinsics.areEqual(this.groupId, feedParams.groupId) && Intrinsics.areEqual(this.uinId, feedParams.uinId) && Intrinsics.areEqual(this.musicParams, feedParams.musicParams) && Intrinsics.areEqual(this.poiParams, feedParams.poiParams) && Intrinsics.areEqual(this.tagParams, feedParams.tagParams) && Intrinsics.areEqual(this.promotionParams, feedParams.promotionParams) && Intrinsics.areEqual(this.schoolParams, feedParams.schoolParams) && this.typeParams == feedParams.typeParams && Intrinsics.areEqual(this.businessShareParams, feedParams.businessShareParams) && Intrinsics.areEqual(this.extInfo, feedParams.extInfo) && Intrinsics.areEqual(this.requestExtInfo, feedParams.requestExtInfo) && this.notAllowDownload == feedParams.notAllowDownload && Intrinsics.areEqual(this.tianshuActivityItemValue, feedParams.tianshuActivityItemValue) && Intrinsics.areEqual(this.liteBanner, feedParams.liteBanner) && Intrinsics.areEqual(this.declarationId, feedParams.declarationId) && Intrinsics.areEqual(this.feedExtraInfo, feedParams.feedExtraInfo) && Intrinsics.areEqual(this.declarationParams, feedParams.declarationParams) && Intrinsics.areEqual(this.dailyParams, feedParams.dailyParams)) {
            return true;
        }
        return false;
    }

    @NotNull
    public final String getAdvJobId() {
        return this.advJobId;
    }

    @Nullable
    public final BusinessShareParams getBusinessShareParams() {
        return this.businessShareParams;
    }

    @NotNull
    public final String getContent() {
        return this.content;
    }

    @Nullable
    public final DailyInfo getDailyParams() {
        return this.dailyParams;
    }

    @NotNull
    public final String getDeclarationId() {
        return this.declarationId;
    }

    @Nullable
    public final DeclarationParams getDeclarationParams() {
        return this.declarationParams;
    }

    @Nullable
    public final HashMap<String, String> getExtInfo() {
        return this.extInfo;
    }

    @Nullable
    public final FeedExtraInfo getFeedExtraInfo() {
        return this.feedExtraInfo;
    }

    @Nullable
    public final List<String> getGroupId() {
        return this.groupId;
    }

    @Nullable
    public final LiteBanner getLiteBanner() {
        return this.liteBanner;
    }

    @Nullable
    public final MusicParams getMusicParams() {
        return this.musicParams;
    }

    public final boolean getNeedSaveMedia() {
        return this.needSaveMedia;
    }

    public final boolean getNotAllowDownload() {
        return this.notAllowDownload;
    }

    @Nullable
    public final PoiParams getPoiParams() {
        return this.poiParams;
    }

    @Nullable
    public final PromotionPublishParams getPromotionParams() {
        return this.promotionParams;
    }

    @NotNull
    public final HashMap<String, String> getRequestExtInfo() {
        return this.requestExtInfo;
    }

    @NotNull
    public final String getScheme() {
        return this.scheme;
    }

    @Nullable
    public final SchoolParams getSchoolParams() {
        return this.schoolParams;
    }

    @Nullable
    public final List<TagParams> getTagParams() {
        return this.tagParams;
    }

    @NotNull
    public final String getTagsAsString() {
        StringBuilder sb5 = new StringBuilder();
        List<TagParams> list = this.tagParams;
        if (list != null) {
            int size = list.size();
            int i3 = 0;
            for (Object obj : list) {
                int i16 = i3 + 1;
                if (i3 < 0) {
                    CollectionsKt__CollectionsKt.throwIndexOverflow();
                }
                TagParams tagParams = (TagParams) obj;
                if (i3 == size - 1) {
                    sb5.append(tagParams.getName());
                } else {
                    sb5.append(tagParams.getName());
                    sb5.append("|");
                }
                i3 = i16;
            }
        }
        String sb6 = sb5.toString();
        Intrinsics.checkNotNullExpressionValue(sb6, "feedTag.toString()");
        return sb6;
    }

    @NotNull
    public final String getTianshuActivityItemValue() {
        return this.tianshuActivityItemValue;
    }

    @NotNull
    public final String getTitle() {
        return this.title;
    }

    public final int getTypeParams() {
        return this.typeParams;
    }

    @Nullable
    public final List<String> getUinId() {
        return this.uinId;
    }

    @NotNull
    public final String getVideoSourceInfo() {
        return this.videoSourceInfo;
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
        int hashCode13 = ((this.title.hashCode() * 31) + this.content.hashCode()) * 31;
        boolean z16 = this.isSyncToQzone;
        int i3 = 1;
        int i16 = z16;
        if (z16 != 0) {
            i16 = 1;
        }
        int i17 = (hashCode13 + i16) * 31;
        boolean z17 = this.isNearbyRecommend;
        int i18 = z17;
        if (z17 != 0) {
            i18 = 1;
        }
        int i19 = (i17 + i18) * 31;
        boolean z18 = this.needSaveMedia;
        int i26 = z18;
        if (z18 != 0) {
            i26 = 1;
        }
        int hashCode14 = (((((((i19 + i26) * 31) + this.scheme.hashCode()) * 31) + this.advJobId.hashCode()) * 31) + this.videoSourceInfo.hashCode()) * 31;
        boolean z19 = this.isPublic;
        int i27 = z19;
        if (z19 != 0) {
            i27 = 1;
        }
        int i28 = (hashCode14 + i27) * 31;
        List<String> list = this.groupId;
        int i29 = 0;
        if (list == null) {
            hashCode = 0;
        } else {
            hashCode = list.hashCode();
        }
        int i36 = (i28 + hashCode) * 31;
        List<String> list2 = this.uinId;
        if (list2 == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = list2.hashCode();
        }
        int i37 = (i36 + hashCode2) * 31;
        MusicParams musicParams = this.musicParams;
        if (musicParams == null) {
            hashCode3 = 0;
        } else {
            hashCode3 = musicParams.hashCode();
        }
        int i38 = (i37 + hashCode3) * 31;
        PoiParams poiParams = this.poiParams;
        if (poiParams == null) {
            hashCode4 = 0;
        } else {
            hashCode4 = poiParams.hashCode();
        }
        int i39 = (i38 + hashCode4) * 31;
        List<TagParams> list3 = this.tagParams;
        if (list3 == null) {
            hashCode5 = 0;
        } else {
            hashCode5 = list3.hashCode();
        }
        int i46 = (i39 + hashCode5) * 31;
        PromotionPublishParams promotionPublishParams = this.promotionParams;
        if (promotionPublishParams == null) {
            hashCode6 = 0;
        } else {
            hashCode6 = promotionPublishParams.hashCode();
        }
        int i47 = (i46 + hashCode6) * 31;
        SchoolParams schoolParams = this.schoolParams;
        if (schoolParams == null) {
            hashCode7 = 0;
        } else {
            hashCode7 = schoolParams.hashCode();
        }
        int i48 = (((i47 + hashCode7) * 31) + this.typeParams) * 31;
        BusinessShareParams businessShareParams = this.businessShareParams;
        if (businessShareParams == null) {
            hashCode8 = 0;
        } else {
            hashCode8 = businessShareParams.hashCode();
        }
        int i49 = (i48 + hashCode8) * 31;
        HashMap<String, String> hashMap = this.extInfo;
        if (hashMap == null) {
            hashCode9 = 0;
        } else {
            hashCode9 = hashMap.hashCode();
        }
        int hashCode15 = (((i49 + hashCode9) * 31) + this.requestExtInfo.hashCode()) * 31;
        boolean z26 = this.notAllowDownload;
        if (!z26) {
            i3 = z26 ? 1 : 0;
        }
        int hashCode16 = (((hashCode15 + i3) * 31) + this.tianshuActivityItemValue.hashCode()) * 31;
        LiteBanner liteBanner = this.liteBanner;
        if (liteBanner == null) {
            hashCode10 = 0;
        } else {
            hashCode10 = liteBanner.hashCode();
        }
        int hashCode17 = (((hashCode16 + hashCode10) * 31) + this.declarationId.hashCode()) * 31;
        FeedExtraInfo feedExtraInfo = this.feedExtraInfo;
        if (feedExtraInfo == null) {
            hashCode11 = 0;
        } else {
            hashCode11 = feedExtraInfo.hashCode();
        }
        int i56 = (hashCode17 + hashCode11) * 31;
        DeclarationParams declarationParams = this.declarationParams;
        if (declarationParams == null) {
            hashCode12 = 0;
        } else {
            hashCode12 = declarationParams.hashCode();
        }
        int i57 = (i56 + hashCode12) * 31;
        DailyInfo dailyInfo = this.dailyParams;
        if (dailyInfo != null) {
            i29 = dailyInfo.hashCode();
        }
        return i57 + i29;
    }

    public final boolean isNearbyRecommend() {
        return this.isNearbyRecommend;
    }

    public final boolean isPublic() {
        return this.isPublic;
    }

    public final boolean isSyncToQzone() {
        return this.isSyncToQzone;
    }

    @NotNull
    public String toString() {
        return "FeedParams(title=" + this.title + ", content=" + this.content + ", isSyncToQzone=" + this.isSyncToQzone + ", isNearbyRecommend=" + this.isNearbyRecommend + ", needSaveMedia=" + this.needSaveMedia + ", scheme=" + this.scheme + ", advJobId=" + this.advJobId + ", videoSourceInfo=" + this.videoSourceInfo + ", isPublic=" + this.isPublic + ", groupId=" + this.groupId + ", uinId=" + this.uinId + ", musicParams=" + this.musicParams + ", poiParams=" + this.poiParams + ", tagParams=" + this.tagParams + ", promotionParams=" + this.promotionParams + ", schoolParams=" + this.schoolParams + ", typeParams=" + this.typeParams + ", businessShareParams=" + this.businessShareParams + ", extInfo=" + this.extInfo + ", requestExtInfo=" + this.requestExtInfo + ", notAllowDownload=" + this.notAllowDownload + ", tianshuActivityItemValue=" + this.tianshuActivityItemValue + ", liteBanner=" + this.liteBanner + ", declarationId=" + this.declarationId + ", feedExtraInfo=" + this.feedExtraInfo + ", declarationParams=" + this.declarationParams + ", dailyParams=" + this.dailyParams + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.title);
        parcel.writeString(this.content);
        parcel.writeByte(this.isSyncToQzone ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.isNearbyRecommend ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.needSaveMedia ? (byte) 1 : (byte) 0);
        parcel.writeString(this.scheme);
        parcel.writeString(this.advJobId);
        parcel.writeString(this.videoSourceInfo);
        parcel.writeByte(this.isPublic ? (byte) 1 : (byte) 0);
        parcel.writeStringList(this.groupId);
        parcel.writeStringList(this.uinId);
        parcel.writeParcelable(this.musicParams, flags);
        parcel.writeParcelable(this.poiParams, flags);
        parcel.writeTypedList(this.tagParams);
        parcel.writeParcelable(this.promotionParams, flags);
        parcel.writeParcelable(this.schoolParams, flags);
        parcel.writeInt(this.typeParams);
        parcel.writeParcelable(this.businessShareParams, flags);
        parcel.writeSerializable(this.extInfo);
        parcel.writeSerializable(this.requestExtInfo);
        parcel.writeByte(this.notAllowDownload ? (byte) 1 : (byte) 0);
        parcel.writeString(this.tianshuActivityItemValue);
        parcel.writeParcelable(this.liteBanner, flags);
        parcel.writeString(this.declarationId);
        parcel.writeParcelable(this.feedExtraInfo, flags);
        parcel.writeParcelable(this.declarationParams, flags);
        parcel.writeParcelable(this.dailyParams, flags);
    }

    public FeedParams(@NotNull String title, @NotNull String content, boolean z16, boolean z17, boolean z18, @NotNull String scheme, @NotNull String advJobId, @NotNull String videoSourceInfo, boolean z19, @Nullable List<String> list, @Nullable List<String> list2, @Nullable MusicParams musicParams, @Nullable PoiParams poiParams, @Nullable List<TagParams> list3, @Nullable PromotionPublishParams promotionPublishParams, @Nullable SchoolParams schoolParams, int i3, @Nullable BusinessShareParams businessShareParams, @Nullable HashMap<String, String> hashMap, @NotNull HashMap<String, String> requestExtInfo, boolean z26, @NotNull String tianshuActivityItemValue, @Nullable LiteBanner liteBanner, @NotNull String declarationId, @Nullable FeedExtraInfo feedExtraInfo, @Nullable DeclarationParams declarationParams, @Nullable DailyInfo dailyInfo) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(content, "content");
        Intrinsics.checkNotNullParameter(scheme, "scheme");
        Intrinsics.checkNotNullParameter(advJobId, "advJobId");
        Intrinsics.checkNotNullParameter(videoSourceInfo, "videoSourceInfo");
        Intrinsics.checkNotNullParameter(requestExtInfo, "requestExtInfo");
        Intrinsics.checkNotNullParameter(tianshuActivityItemValue, "tianshuActivityItemValue");
        Intrinsics.checkNotNullParameter(declarationId, "declarationId");
        this.title = title;
        this.content = content;
        this.isSyncToQzone = z16;
        this.isNearbyRecommend = z17;
        this.needSaveMedia = z18;
        this.scheme = scheme;
        this.advJobId = advJobId;
        this.videoSourceInfo = videoSourceInfo;
        this.isPublic = z19;
        this.groupId = list;
        this.uinId = list2;
        this.musicParams = musicParams;
        this.poiParams = poiParams;
        this.tagParams = list3;
        this.promotionParams = promotionPublishParams;
        this.schoolParams = schoolParams;
        this.typeParams = i3;
        this.businessShareParams = businessShareParams;
        this.extInfo = hashMap;
        this.requestExtInfo = requestExtInfo;
        this.notAllowDownload = z26;
        this.tianshuActivityItemValue = tianshuActivityItemValue;
        this.liteBanner = liteBanner;
        this.declarationId = declarationId;
        this.feedExtraInfo = feedExtraInfo;
        this.declarationParams = declarationParams;
        this.dailyParams = dailyInfo;
    }

    public /* synthetic */ FeedParams(String str, String str2, boolean z16, boolean z17, boolean z18, String str3, String str4, String str5, boolean z19, List list, List list2, MusicParams musicParams, PoiParams poiParams, List list3, PromotionPublishParams promotionPublishParams, SchoolParams schoolParams, int i3, BusinessShareParams businessShareParams, HashMap hashMap, HashMap hashMap2, boolean z26, String str6, LiteBanner liteBanner, String str7, FeedExtraInfo feedExtraInfo, DeclarationParams declarationParams, DailyInfo dailyInfo, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this((i16 & 1) != 0 ? "" : str, (i16 & 2) != 0 ? "" : str2, (i16 & 4) != 0 ? false : z16, (i16 & 8) != 0 ? true : z17, (i16 & 16) != 0 ? false : z18, (i16 & 32) != 0 ? "" : str3, (i16 & 64) != 0 ? "" : str4, (i16 & 128) != 0 ? "" : str5, (i16 & 256) == 0 ? z19 : true, (i16 & 512) != 0 ? null : list, (i16 & 1024) != 0 ? null : list2, (i16 & 2048) != 0 ? null : musicParams, (i16 & 4096) != 0 ? null : poiParams, (i16 & 8192) != 0 ? null : list3, (i16 & 16384) != 0 ? null : promotionPublishParams, (i16 & 32768) != 0 ? null : schoolParams, (i16 & 65536) != 0 ? 0 : i3, (i16 & 131072) != 0 ? null : businessShareParams, (i16 & 262144) != 0 ? null : hashMap, (i16 & 524288) != 0 ? new HashMap() : hashMap2, (i16 & 1048576) != 0 ? false : z26, (i16 & 2097152) != 0 ? "" : str6, (i16 & 4194304) != 0 ? null : liteBanner, (i16 & 8388608) != 0 ? "" : str7, (i16 & 16777216) != 0 ? null : feedExtraInfo, (i16 & 33554432) != 0 ? null : declarationParams, (i16 & 67108864) != 0 ? null : dailyInfo);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public FeedParams(@NotNull Parcel parcel) {
        this(r4, r5, r1, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r18, r19, r20, r21, r22, r24, r25, r26, r27, r31, r3 != null ? r3 : "", (FeedExtraInfo) parcel.readParcelable(FeedExtraInfo.class.getClassLoader()), (DeclarationParams) parcel.readParcelable(DeclarationParams.class.getClassLoader()), (DailyInfo) parcel.readParcelable(DailyInfo.class.getClassLoader()));
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        String readString = parcel.readString();
        String str = readString == null ? "" : readString;
        String readString2 = parcel.readString();
        String str2 = readString2 == null ? "" : readString2;
        boolean z16 = parcel.readByte() != 0;
        boolean z17 = parcel.readByte() != 0;
        boolean z18 = parcel.readByte() != 0;
        String readString3 = parcel.readString();
        readString3 = readString3 == null ? "" : readString3;
        String readString4 = parcel.readString();
        readString4 = readString4 == null ? "" : readString4;
        String readString5 = parcel.readString();
        readString5 = readString5 == null ? "" : readString5;
        boolean z19 = parcel.readByte() != 0;
        ArrayList<String> createStringArrayList = parcel.createStringArrayList();
        ArrayList<String> createStringArrayList2 = parcel.createStringArrayList();
        MusicParams musicParams = (MusicParams) parcel.readParcelable(MusicParams.class.getClassLoader());
        PoiParams poiParams = (PoiParams) parcel.readParcelable(PoiParams.class.getClassLoader());
        ArrayList createTypedArrayList = parcel.createTypedArrayList(TagParams.CREATOR);
        PromotionPublishParams promotionPublishParams = (PromotionPublishParams) parcel.readParcelable(PromotionParams.class.getClassLoader());
        SchoolParams schoolParams = (SchoolParams) parcel.readParcelable(SchoolParams.class.getClassLoader());
        int readInt = parcel.readInt();
        BusinessShareParams businessShareParams = (BusinessShareParams) parcel.readParcelable(BusinessShareParams.class.getClassLoader());
        Serializable readSerializable = parcel.readSerializable();
        HashMap hashMap = readSerializable instanceof HashMap ? (HashMap) readSerializable : null;
        Serializable readSerializable2 = parcel.readSerializable();
        Intrinsics.checkNotNull(readSerializable2, "null cannot be cast to non-null type java.util.HashMap<kotlin.String, kotlin.String>{ kotlin.collections.TypeAliasesKt.HashMap<kotlin.String, kotlin.String> }");
        HashMap hashMap2 = (HashMap) readSerializable2;
        boolean z26 = parcel.readByte() != 0;
        String readString6 = parcel.readString();
        String str3 = readString6 == null ? "" : readString6;
        LiteBanner liteBanner = (LiteBanner) parcel.readParcelable(LiteBanner.class.getClassLoader());
        String readString7 = parcel.readString();
    }
}
