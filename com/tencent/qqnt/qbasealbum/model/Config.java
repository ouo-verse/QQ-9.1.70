package com.tencent.qqnt.qbasealbum.model;

import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qqnt.qbasealbum.filter.MediaFilter;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 c2\u00020\u0001:\u0002!ZB\u00cd\u0001\b\u0002\u0012\u0006\u0010\u000e\u001a\u00020\t\u0012\u0006\u0010\u0013\u001a\u00020\u000f\u0012\u0006\u0010\u0016\u001a\u00020\u000f\u0012\u0006\u0010\u001a\u001a\u00020\u0004\u0012\u0006\u0010\u001d\u001a\u00020\u0004\u0012\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001e\u0012\u0006\u0010)\u001a\u00020$\u0012\u0006\u0010.\u001a\u00020$\u0012\u0006\u00101\u001a\u00020\u0004\u0012\u0006\u00104\u001a\u00020\u000f\u0012\u0006\u0010:\u001a\u000205\u0012\u0006\u0010@\u001a\u00020;\u0012\u0006\u0010B\u001a\u00020\u000f\u0012\u0006\u0010E\u001a\u00020\u000f\u0012\u0006\u0010H\u001a\u00020\u000f\u0012\u0006\u0010K\u001a\u00020\u0004\u0012\u0006\u0010N\u001a\u00020\u000f\u0012\"\u0010V\u001a\u001e\u0012\u0004\u0012\u00020P\u0012\u0004\u0012\u00020P0Oj\u000e\u0012\u0004\u0012\u00020P\u0012\u0004\u0012\u00020P`Q\u0012\b\u0010\\\u001a\u0004\u0018\u00010W\u0012\u0006\u0010_\u001a\u00020\u000f\u00a2\u0006\u0004\b`\u0010aB\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b`\u0010bJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\b\u001a\u00020\u0004H\u0016R\u0017\u0010\u000e\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0013\u001a\u00020\u000f8\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0016\u001a\u00020\u000f8\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0010\u001a\u0004\b\u0015\u0010\u0012R\u0017\u0010\u001a\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0014\u0010\u0019R\u0017\u0010\u001d\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u001b\u0010\u0018\u001a\u0004\b\u001c\u0010\u0019R\u001d\u0010#\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001e8\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010 \u001a\u0004\b!\u0010\"R\u0017\u0010)\u001a\u00020$8\u0006\u00a2\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(R \u0010.\u001a\u00020$8\u0006X\u0087\u0004\u00a2\u0006\u0012\n\u0004\b*\u0010&\u0012\u0004\b,\u0010-\u001a\u0004\b+\u0010(R\u0017\u00101\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b/\u0010\u0018\u001a\u0004\b0\u0010\u0019R\u0017\u00104\u001a\u00020\u000f8\u0006\u00a2\u0006\f\n\u0004\b2\u0010\u0010\u001a\u0004\b3\u0010\u0012R\u0017\u0010:\u001a\u0002058\u0006\u00a2\u0006\f\n\u0004\b6\u00107\u001a\u0004\b8\u00109R\u0017\u0010@\u001a\u00020;8\u0006\u00a2\u0006\f\n\u0004\b<\u0010=\u001a\u0004\b>\u0010?R\u0017\u0010B\u001a\u00020\u000f8\u0006\u00a2\u0006\f\n\u0004\b\u0018\u0010\u0010\u001a\u0004\bA\u0010\u0012R\u0017\u0010E\u001a\u00020\u000f8\u0006\u00a2\u0006\f\n\u0004\bC\u0010\u0010\u001a\u0004\bD\u0010\u0012R\u0017\u0010H\u001a\u00020\u000f8\u0006\u00a2\u0006\f\n\u0004\bF\u0010\u0010\u001a\u0004\bG\u0010\u0012R\u0017\u0010K\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\bI\u0010\u0018\u001a\u0004\bJ\u0010\u0019R\u0017\u0010N\u001a\u00020\u000f8\u0006\u00a2\u0006\f\n\u0004\bL\u0010\u0010\u001a\u0004\bM\u0010\u0012R3\u0010V\u001a\u001e\u0012\u0004\u0012\u00020P\u0012\u0004\u0012\u00020P0Oj\u000e\u0012\u0004\u0012\u00020P\u0012\u0004\u0012\u00020P`Q8\u0006\u00a2\u0006\f\n\u0004\bR\u0010S\u001a\u0004\bT\u0010UR\u0019\u0010\\\u001a\u0004\u0018\u00010W8\u0006\u00a2\u0006\f\n\u0004\bX\u0010Y\u001a\u0004\bZ\u0010[R\u0017\u0010_\u001a\u00020\u000f8\u0006\u00a2\u0006\f\n\u0004\b]\u0010\u0010\u001a\u0004\b^\u0010\u0012\u00a8\u0006d"}, d2 = {"Lcom/tencent/qqnt/qbasealbum/model/Config;", "Landroid/os/Parcelable;", "Landroid/os/Parcel;", "parcel", "", WadlProxyConsts.FLAGS, "", "writeToParcel", "describeContents", "Lcom/tencent/qqnt/qbasealbum/model/TabType;", "d", "Lcom/tencent/qqnt/qbasealbum/model/TabType;", "e", "()Lcom/tencent/qqnt/qbasealbum/model/TabType;", "localMediaTabType", "", "Z", "l", "()Z", "needDragSelect", "f", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "needScrollTimeline", h.F, "I", "()I", "maxSelectMediaSize", "i", "j", "minSendMediaSize", "", "Lcom/tencent/qqnt/qbasealbum/model/SelectMediaInfo;", "Ljava/util/List;", "a", "()Ljava/util/List;", "alreadySelectedMedia", "Lcom/tencent/qqnt/qbasealbum/filter/MediaFilter;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/qqnt/qbasealbum/filter/MediaFilter;", "o", "()Lcom/tencent/qqnt/qbasealbum/filter/MediaFilter;", "queryMediaFilter", "D", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "getSelectMediaFilter$annotations", "()V", "selectMediaFilter", "E", "g", "mediaItemSpanCount", UserInfo.SEX_FEMALE, "r", "showSelectionPanel", "Lcom/tencent/qqnt/qbasealbum/model/OnlineInitBean;", "G", "Lcom/tencent/qqnt/qbasealbum/model/OnlineInitBean;", DomainData.DOMAIN_NAME, "()Lcom/tencent/qqnt/qbasealbum/model/OnlineInitBean;", "onlineConfig", "Lcom/tencent/qqnt/qbasealbum/model/QZoneInitBean;", "H", "Lcom/tencent/qqnt/qbasealbum/model/QZoneInitBean;", "getQZoneConfig", "()Lcom/tencent/qqnt/qbasealbum/model/QZoneInitBean;", "qZoneConfig", ReportConstant.COSTREPORT_PREFIX, "isFlashPicEnable", "J", "v", "isSingleMode", "K", "t", "isQualityRaw", "L", "c", "fromChatType", "M", "k", "needActivityResult", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "N", "Ljava/util/HashMap;", "p", "()Ljava/util/HashMap;", "replaceMap", "Landroid/graphics/Rect;", "P", "Landroid/graphics/Rect;", "b", "()Landroid/graphics/Rect;", "entranceRect", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "u", "isQualityRawShow", "<init>", "(Lcom/tencent/qqnt/qbasealbum/model/TabType;ZZIILjava/util/List;Lcom/tencent/qqnt/qbasealbum/filter/MediaFilter;Lcom/tencent/qqnt/qbasealbum/filter/MediaFilter;IZLcom/tencent/qqnt/qbasealbum/model/OnlineInitBean;Lcom/tencent/qqnt/qbasealbum/model/QZoneInitBean;ZZZIZLjava/util/HashMap;Landroid/graphics/Rect;Z)V", "(Landroid/os/Parcel;)V", "CREATOR", "nt_album_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class Config implements Parcelable {
    static IPatchRedirector $redirector_;

    /* renamed from: CREATOR, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final MediaFilter queryMediaFilter;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final MediaFilter selectMediaFilter;

    /* renamed from: E, reason: from kotlin metadata */
    private final int mediaItemSpanCount;

    /* renamed from: F, reason: from kotlin metadata */
    private final boolean showSelectionPanel;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final OnlineInitBean onlineConfig;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private final QZoneInitBean qZoneConfig;

    /* renamed from: I, reason: from kotlin metadata */
    private final boolean isFlashPicEnable;

    /* renamed from: J, reason: from kotlin metadata */
    private final boolean isSingleMode;

    /* renamed from: K, reason: from kotlin metadata */
    private final boolean isQualityRaw;

    /* renamed from: L, reason: from kotlin metadata */
    private final int fromChatType;

    /* renamed from: M, reason: from kotlin metadata */
    private final boolean needActivityResult;

    /* renamed from: N, reason: from kotlin metadata */
    @NotNull
    private final HashMap<String, String> replaceMap;

    /* renamed from: P, reason: from kotlin metadata */
    @Nullable
    private final Rect entranceRect;

    /* renamed from: Q, reason: from kotlin metadata */
    private final boolean isQualityRawShow;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final TabType localMediaTabType;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final boolean needDragSelect;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final boolean needScrollTimeline;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final int maxSelectMediaSize;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final int minSendMediaSize;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<SelectMediaInfo> alreadySelectedMedia;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\bf\u0010gJ\u0006\u0010\u0003\u001a\u00020\u0002R\"\u0010\n\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\"\u0010\u0012\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\"\u0010\u0016\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0013\u0010\r\u001a\u0004\b\u0014\u0010\u000f\"\u0004\b\u0015\u0010\u0011R\"\u0010\u001e\u001a\u00020\u00178\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\"\u0010\"\u001a\u00020\u00178\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001f\u0010\u0019\u001a\u0004\b \u0010\u001b\"\u0004\b!\u0010\u001dR(\u0010)\u001a\b\u0012\u0004\u0012\u00020$0#8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\b\u0010%\u001a\u0004\b&\u0010'\"\u0004\b\f\u0010(R\"\u00100\u001a\u00020*8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001c\u0010+\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\"\u00104\u001a\u00020*8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b1\u0010+\u001a\u0004\b2\u0010-\"\u0004\b3\u0010/R\"\u00106\u001a\u00020\u00178\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b!\u0010\u0019\u001a\u0004\b5\u0010\u001b\"\u0004\b1\u0010\u001dR\"\u0010:\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b7\u0010\r\u001a\u0004\b8\u0010\u000f\"\u0004\b9\u0010\u0011R\"\u0010A\u001a\u00020;8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u0010<\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@R\"\u0010I\u001a\u00020B8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bC\u0010D\u001a\u0004\bE\u0010F\"\u0004\bG\u0010HR\"\u0010K\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bJ\u0010\r\u001a\u0004\bK\u0010\u000f\"\u0004\b\u0018\u0010\u0011R\"\u0010L\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b.\u0010\r\u001a\u0004\bL\u0010\u000f\"\u0004\bM\u0010\u0011R\"\u0010O\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bN\u0010\r\u001a\u0004\bO\u0010\u000f\"\u0004\bC\u0010\u0011R\"\u0010Q\u001a\u00020\u00178\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b3\u0010\u0019\u001a\u0004\bP\u0010\u001b\"\u0004\b\u001f\u0010\u001dR\"\u0010S\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bM\u0010\r\u001a\u0004\bR\u0010\u000f\"\u0004\b7\u0010\u0011R>\u0010\\\u001a\u001e\u0012\u0004\u0012\u00020U\u0012\u0004\u0012\u00020U0Tj\u000e\u0012\u0004\u0012\u00020U\u0012\u0004\u0012\u00020U`V8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bW\u0010X\u001a\u0004\bY\u0010Z\"\u0004\bN\u0010[R$\u0010c\u001a\u0004\u0018\u00010]8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b^\u0010_\u001a\u0004\b`\u0010a\"\u0004\b\u0013\u0010bR\"\u0010e\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bd\u0010\r\u001a\u0004\be\u0010\u000f\"\u0004\bJ\u0010\u0011\u00a8\u0006h"}, d2 = {"Lcom/tencent/qqnt/qbasealbum/model/Config$a;", "", "Lcom/tencent/qqnt/qbasealbum/model/Config;", "a", "Lcom/tencent/qqnt/qbasealbum/model/TabType;", "Lcom/tencent/qqnt/qbasealbum/model/TabType;", "getLocalMediaTabType", "()Lcom/tencent/qqnt/qbasealbum/model/TabType;", "f", "(Lcom/tencent/qqnt/qbasealbum/model/TabType;)V", "localMediaTabType", "", "b", "Z", "getNeedDragSelect", "()Z", "k", "(Z)V", "needDragSelect", "c", "getNeedScrollTimeline", "setNeedScrollTimeline", "needScrollTimeline", "", "d", "I", "getMaxSelectMediaSize", "()I", "g", "(I)V", "maxSelectMediaSize", "e", "getMinSendMediaSize", "i", "minSendMediaSize", "", "Lcom/tencent/qqnt/qbasealbum/model/SelectMediaInfo;", "Ljava/util/List;", "getAlreadySelectedMedia", "()Ljava/util/List;", "(Ljava/util/List;)V", "alreadySelectedMedia", "Lcom/tencent/qqnt/qbasealbum/filter/MediaFilter;", "Lcom/tencent/qqnt/qbasealbum/filter/MediaFilter;", "getQueryMediaFilter", "()Lcom/tencent/qqnt/qbasealbum/filter/MediaFilter;", DomainData.DOMAIN_NAME, "(Lcom/tencent/qqnt/qbasealbum/filter/MediaFilter;)V", "queryMediaFilter", h.F, "getSelectMediaFilter", "p", "selectMediaFilter", "getMediaItemSpanCount", "mediaItemSpanCount", "j", "getShowSelectionPanel", "setShowSelectionPanel", "showSelectionPanel", "Lcom/tencent/qqnt/qbasealbum/model/OnlineInitBean;", "Lcom/tencent/qqnt/qbasealbum/model/OnlineInitBean;", "getOnlineConfig", "()Lcom/tencent/qqnt/qbasealbum/model/OnlineInitBean;", "setOnlineConfig", "(Lcom/tencent/qqnt/qbasealbum/model/OnlineInitBean;)V", "onlineConfig", "Lcom/tencent/qqnt/qbasealbum/model/QZoneInitBean;", "l", "Lcom/tencent/qqnt/qbasealbum/model/QZoneInitBean;", "getQZoneConfig", "()Lcom/tencent/qqnt/qbasealbum/model/QZoneInitBean;", "setQZoneConfig", "(Lcom/tencent/qqnt/qbasealbum/model/QZoneInitBean;)V", "qZoneConfig", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "isFlashPicEnable", "isSingleMode", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "o", "isQualityRaw", "getFromChatType", "fromChatType", "getNeedActivityResult", "needActivityResult", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "r", "Ljava/util/HashMap;", "getReplaceMap", "()Ljava/util/HashMap;", "(Ljava/util/HashMap;)V", "replaceMap", "Landroid/graphics/Rect;", ReportConstant.COSTREPORT_PREFIX, "Landroid/graphics/Rect;", "getEntranceRect", "()Landroid/graphics/Rect;", "(Landroid/graphics/Rect;)V", "entranceRect", "t", "isQualityRawShow", "<init>", "()V", "nt_album_kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private TabType localMediaTabType;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        private boolean needDragSelect;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        private boolean needScrollTimeline;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private int maxSelectMediaSize;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        private int minSendMediaSize;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private List<SelectMediaInfo> alreadySelectedMedia;

        /* renamed from: g, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private MediaFilter queryMediaFilter;

        /* renamed from: h, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private MediaFilter selectMediaFilter;

        /* renamed from: i, reason: collision with root package name and from kotlin metadata */
        private int mediaItemSpanCount;

        /* renamed from: j, reason: collision with root package name and from kotlin metadata */
        private boolean showSelectionPanel;

        /* renamed from: k, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private OnlineInitBean onlineConfig;

        /* renamed from: l, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private QZoneInitBean qZoneConfig;

        /* renamed from: m, reason: collision with root package name and from kotlin metadata */
        private boolean isFlashPicEnable;

        /* renamed from: n, reason: collision with root package name and from kotlin metadata */
        private boolean isSingleMode;

        /* renamed from: o, reason: collision with root package name and from kotlin metadata */
        private boolean isQualityRaw;

        /* renamed from: p, reason: collision with root package name and from kotlin metadata */
        private int fromChatType;

        /* renamed from: q, reason: collision with root package name and from kotlin metadata */
        private boolean needActivityResult;

        /* renamed from: r, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private HashMap<String, String> replaceMap;

        /* renamed from: s, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private Rect entranceRect;

        /* renamed from: t, reason: collision with root package name and from kotlin metadata */
        private boolean isQualityRawShow;

        public a() {
            List<SelectMediaInfo> emptyList;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
                return;
            }
            this.localMediaTabType = TabType.TAB_ALL;
            this.needDragSelect = true;
            this.needScrollTimeline = true;
            this.maxSelectMediaSize = 20;
            this.minSendMediaSize = 1;
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            this.alreadySelectedMedia = emptyList;
            MediaFilter.Companion companion = MediaFilter.INSTANCE;
            this.queryMediaFilter = new MediaFilter.a().a();
            this.selectMediaFilter = new MediaFilter.a().a();
            this.mediaItemSpanCount = 4;
            this.onlineConfig = new OnlineInitBean(false, null, null, null, 15, null);
            this.qZoneConfig = new QZoneInitBean(null, false, 0, 0, false, 0, 0, 0, false, null, null, 2047, null);
            this.fromChatType = -1;
            this.needActivityResult = true;
            this.replaceMap = new HashMap<>();
            this.isQualityRawShow = true;
        }

        @NotNull
        public final Config a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 42)) {
                return (Config) iPatchRedirector.redirect((short) 42, (Object) this);
            }
            return new Config(this.localMediaTabType, this.needDragSelect, this.needScrollTimeline, this.maxSelectMediaSize, this.minSendMediaSize, this.alreadySelectedMedia, this.queryMediaFilter, this.selectMediaFilter, this.mediaItemSpanCount, this.showSelectionPanel, this.onlineConfig, this.qZoneConfig, this.isFlashPicEnable, this.isSingleMode, this.isQualityRaw, this.fromChatType, this.needActivityResult, this.replaceMap, this.entranceRect, this.isQualityRawShow, null);
        }

        public final void b(@NotNull List<SelectMediaInfo> list) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
                iPatchRedirector.redirect((short) 13, (Object) this, (Object) list);
            } else {
                Intrinsics.checkNotNullParameter(list, "<set-?>");
                this.alreadySelectedMedia = list;
            }
        }

        public final void c(@Nullable Rect rect) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 39)) {
                iPatchRedirector.redirect((short) 39, (Object) this, (Object) rect);
            } else {
                this.entranceRect = rect;
            }
        }

        public final void d(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
                iPatchRedirector.redirect((short) 27, (Object) this, z16);
            } else {
                this.isFlashPicEnable = z16;
            }
        }

        public final void e(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
                iPatchRedirector.redirect((short) 33, (Object) this, i3);
            } else {
                this.fromChatType = i3;
            }
        }

        public final void f(@NotNull TabType tabType) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) tabType);
            } else {
                Intrinsics.checkNotNullParameter(tabType, "<set-?>");
                this.localMediaTabType = tabType;
            }
        }

        public final void g(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                iPatchRedirector.redirect((short) 9, (Object) this, i3);
            } else {
                this.maxSelectMediaSize = i3;
            }
        }

        public final void h(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
                iPatchRedirector.redirect((short) 19, (Object) this, i3);
            } else {
                this.mediaItemSpanCount = i3;
            }
        }

        public final void i(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
                iPatchRedirector.redirect((short) 11, (Object) this, i3);
            } else {
                this.minSendMediaSize = i3;
            }
        }

        public final void j(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 35)) {
                iPatchRedirector.redirect((short) 35, (Object) this, z16);
            } else {
                this.needActivityResult = z16;
            }
        }

        public final void k(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, z16);
            } else {
                this.needDragSelect = z16;
            }
        }

        public final void l(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
                iPatchRedirector.redirect((short) 31, (Object) this, z16);
            } else {
                this.isQualityRaw = z16;
            }
        }

        public final void m(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 41)) {
                iPatchRedirector.redirect((short) 41, (Object) this, z16);
            } else {
                this.isQualityRawShow = z16;
            }
        }

        public final void n(@NotNull MediaFilter mediaFilter) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
                iPatchRedirector.redirect((short) 15, (Object) this, (Object) mediaFilter);
            } else {
                Intrinsics.checkNotNullParameter(mediaFilter, "<set-?>");
                this.queryMediaFilter = mediaFilter;
            }
        }

        public final void o(@NotNull HashMap<String, String> hashMap) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 37)) {
                iPatchRedirector.redirect((short) 37, (Object) this, (Object) hashMap);
            } else {
                Intrinsics.checkNotNullParameter(hashMap, "<set-?>");
                this.replaceMap = hashMap;
            }
        }

        public final void p(@NotNull MediaFilter mediaFilter) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
                iPatchRedirector.redirect((short) 17, (Object) this, (Object) mediaFilter);
            } else {
                Intrinsics.checkNotNullParameter(mediaFilter, "<set-?>");
                this.selectMediaFilter = mediaFilter;
            }
        }

        public final void q(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
                iPatchRedirector.redirect((short) 29, (Object) this, z16);
            } else {
                this.isSingleMode = z16;
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u001f\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a2\u0006\u0004\b\t\u0010\n\u00a8\u0006\r"}, d2 = {"Lcom/tencent/qqnt/qbasealbum/model/Config$b;", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/qqnt/qbasealbum/model/Config;", "Landroid/os/Parcel;", "parcel", "a", "", "size", "", "b", "(I)[Lcom/tencent/qqnt/qbasealbum/model/Config;", "<init>", "()V", "nt_album_kit_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.qbasealbum.model.Config$b, reason: from kotlin metadata */
    /* loaded from: classes25.dex */
    public static final class Companion implements Parcelable.Creator<Config> {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) {
                return;
            }
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) defaultConstructorMarker);
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Config createFromParcel(@NotNull Parcel parcel) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (Config) iPatchRedirector.redirect((short) 3, (Object) this, (Object) parcel);
            }
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new Config(parcel);
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public Config[] newArray(int size) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (Config[]) iPatchRedirector.redirect((short) 4, (Object) this, size);
            }
            return new Config[size];
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(41631);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 27)) {
            redirector.redirect((short) 27);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public /* synthetic */ Config(TabType tabType, boolean z16, boolean z17, int i3, int i16, List list, MediaFilter mediaFilter, MediaFilter mediaFilter2, int i17, boolean z18, OnlineInitBean onlineInitBean, QZoneInitBean qZoneInitBean, boolean z19, boolean z26, boolean z27, int i18, boolean z28, HashMap hashMap, Rect rect, boolean z29, DefaultConstructorMarker defaultConstructorMarker) {
        this(tabType, z16, z17, i3, i16, list, mediaFilter, mediaFilter2, i17, z18, onlineInitBean, qZoneInitBean, z19, z26, z27, i18, z28, hashMap, rect, z29);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 26)) {
            return;
        }
        iPatchRedirector.redirect((short) 26, this, tabType, Boolean.valueOf(z16), Boolean.valueOf(z17), Integer.valueOf(i3), Integer.valueOf(i16), list, mediaFilter, mediaFilter2, Integer.valueOf(i17), Boolean.valueOf(z18), onlineInitBean, qZoneInitBean, Boolean.valueOf(z19), Boolean.valueOf(z26), Boolean.valueOf(z27), Integer.valueOf(i18), Boolean.valueOf(z28), hashMap, rect, Boolean.valueOf(z29), defaultConstructorMarker);
    }

    @NotNull
    public final List<SelectMediaInfo> a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (List) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return this.alreadySelectedMedia;
    }

    @Nullable
    public final Rect b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return (Rect) iPatchRedirector.redirect((short) 20, (Object) this);
        }
        return this.entranceRect;
    }

    public final int c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return ((Integer) iPatchRedirector.redirect((short) 17, (Object) this)).intValue();
        }
        return this.fromChatType;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            return ((Integer) iPatchRedirector.redirect((short) 25, (Object) this)).intValue();
        }
        return 0;
    }

    @NotNull
    public final TabType e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (TabType) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.localMediaTabType;
    }

    public final int f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
        }
        return this.maxSelectMediaSize;
    }

    public final int g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Integer) iPatchRedirector.redirect((short) 10, (Object) this)).intValue();
        }
        return this.mediaItemSpanCount;
    }

    public final int j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
        }
        return this.minSendMediaSize;
    }

    public final boolean k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return ((Boolean) iPatchRedirector.redirect((short) 18, (Object) this)).booleanValue();
        }
        return this.needActivityResult;
    }

    public final boolean l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        return this.needDragSelect;
    }

    public final boolean m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        return this.needScrollTimeline;
    }

    @NotNull
    public final OnlineInitBean n() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (OnlineInitBean) iPatchRedirector.redirect((short) 12, (Object) this);
        }
        return this.onlineConfig;
    }

    @NotNull
    public final MediaFilter o() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (MediaFilter) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return this.queryMediaFilter;
    }

    @NotNull
    public final HashMap<String, String> p() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return (HashMap) iPatchRedirector.redirect((short) 19, (Object) this);
        }
        return this.replaceMap;
    }

    @NotNull
    public final MediaFilter q() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (MediaFilter) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return this.selectMediaFilter;
    }

    public final boolean r() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Boolean) iPatchRedirector.redirect((short) 11, (Object) this)).booleanValue();
        }
        return this.showSelectionPanel;
    }

    public final boolean s() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Boolean) iPatchRedirector.redirect((short) 14, (Object) this)).booleanValue();
        }
        return this.isFlashPicEnable;
    }

    public final boolean t() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return ((Boolean) iPatchRedirector.redirect((short) 16, (Object) this)).booleanValue();
        }
        return this.isQualityRaw;
    }

    public final boolean u() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return ((Boolean) iPatchRedirector.redirect((short) 21, (Object) this)).booleanValue();
        }
        return this.isQualityRawShow;
    }

    public final boolean v() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Boolean) iPatchRedirector.redirect((short) 15, (Object) this)).booleanValue();
        }
        return this.isSingleMode;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, (Object) this, (Object) parcel, flags);
            return;
        }
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.localMediaTabType.name());
        parcel.writeByte(this.needDragSelect ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.needScrollTimeline ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.maxSelectMediaSize);
        parcel.writeInt(this.minSendMediaSize);
        parcel.writeTypedList(this.alreadySelectedMedia);
        parcel.writeParcelable(this.queryMediaFilter, flags);
        parcel.writeParcelable(this.selectMediaFilter, flags);
        parcel.writeInt(this.mediaItemSpanCount);
        parcel.writeByte(this.showSelectionPanel ? (byte) 1 : (byte) 0);
        parcel.writeParcelable(this.onlineConfig, flags);
        parcel.writeParcelable(this.qZoneConfig, flags);
        parcel.writeByte(this.isFlashPicEnable ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.isSingleMode ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.isQualityRaw ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.fromChatType);
        parcel.writeInt(this.needActivityResult ? 1 : 0);
        parcel.writeSerializable(this.replaceMap);
        parcel.writeParcelable(this.entranceRect, flags);
        parcel.writeByte(this.isQualityRawShow ? (byte) 1 : (byte) 0);
    }

    Config(TabType tabType, boolean z16, boolean z17, int i3, int i16, List<SelectMediaInfo> list, MediaFilter mediaFilter, MediaFilter mediaFilter2, int i17, boolean z18, OnlineInitBean onlineInitBean, QZoneInitBean qZoneInitBean, boolean z19, boolean z26, boolean z27, int i18, boolean z28, HashMap<String, String> hashMap, Rect rect, boolean z29) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, tabType, Boolean.valueOf(z16), Boolean.valueOf(z17), Integer.valueOf(i3), Integer.valueOf(i16), list, mediaFilter, mediaFilter2, Integer.valueOf(i17), Boolean.valueOf(z18), onlineInitBean, qZoneInitBean, Boolean.valueOf(z19), Boolean.valueOf(z26), Boolean.valueOf(z27), Integer.valueOf(i18), Boolean.valueOf(z28), hashMap, rect, Boolean.valueOf(z29));
            return;
        }
        this.localMediaTabType = tabType;
        this.needDragSelect = z16;
        this.needScrollTimeline = z17;
        this.maxSelectMediaSize = i3;
        this.minSendMediaSize = i16;
        this.alreadySelectedMedia = list;
        this.queryMediaFilter = mediaFilter;
        this.selectMediaFilter = mediaFilter2;
        this.mediaItemSpanCount = i17;
        this.showSelectionPanel = z18;
        this.onlineConfig = onlineInitBean;
        this.qZoneConfig = qZoneInitBean;
        this.isFlashPicEnable = z19;
        this.isSingleMode = z26;
        this.isQualityRaw = z27;
        this.fromChatType = i18;
        this.needActivityResult = z28;
        this.replaceMap = hashMap;
        this.entranceRect = rect;
        this.isQualityRawShow = z29;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Config(@NotNull Parcel parcel) {
        this(r3, r1, r5, r6, r7, r8, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, (HashMap) r9, (Rect) parcel.readParcelable(Rect.class.getClassLoader()), parcel.readByte() != 0);
        List list;
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        String readString = parcel.readString();
        Intrinsics.checkNotNull(readString);
        TabType valueOf = TabType.valueOf(readString);
        boolean z16 = parcel.readByte() != 0;
        boolean z17 = parcel.readByte() != 0;
        int readInt = parcel.readInt();
        int readInt2 = parcel.readInt();
        ArrayList createTypedArrayList = parcel.createTypedArrayList(SelectMediaInfo.CREATOR);
        Intrinsics.checkNotNull(createTypedArrayList);
        list = CollectionsKt___CollectionsKt.toList(createTypedArrayList);
        Parcelable readParcelable = parcel.readParcelable(MediaFilter.class.getClassLoader());
        Intrinsics.checkNotNull(readParcelable);
        MediaFilter mediaFilter = (MediaFilter) readParcelable;
        Parcelable readParcelable2 = parcel.readParcelable(MediaFilter.class.getClassLoader());
        Intrinsics.checkNotNull(readParcelable2);
        MediaFilter mediaFilter2 = (MediaFilter) readParcelable2;
        int readInt3 = parcel.readInt();
        boolean z18 = parcel.readByte() != 0;
        Parcelable readParcelable3 = parcel.readParcelable(OnlineInitBean.class.getClassLoader());
        Intrinsics.checkNotNull(readParcelable3);
        OnlineInitBean onlineInitBean = (OnlineInitBean) readParcelable3;
        Parcelable readParcelable4 = parcel.readParcelable(QZoneInitBean.class.getClassLoader());
        Intrinsics.checkNotNull(readParcelable4);
        QZoneInitBean qZoneInitBean = (QZoneInitBean) readParcelable4;
        boolean z19 = parcel.readByte() != 0;
        boolean z26 = parcel.readByte() != 0;
        boolean z27 = parcel.readByte() != 0;
        int readInt4 = parcel.readInt();
        boolean z28 = parcel.readInt() != 0;
        Serializable readSerializable = parcel.readSerializable();
        Intrinsics.checkNotNull(readSerializable, "null cannot be cast to non-null type java.util.HashMap<kotlin.String, kotlin.String>{ kotlin.collections.TypeAliasesKt.HashMap<kotlin.String, kotlin.String> }");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 22)) {
            return;
        }
        iPatchRedirector.redirect((short) 22, (Object) this, (Object) parcel);
    }
}
