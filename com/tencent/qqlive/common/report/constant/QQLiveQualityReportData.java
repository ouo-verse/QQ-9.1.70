package com.tencent.qqlive.common.report.constant;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.qqlive.common.report.constant.QQLiveReportConstants;
import cooperation.qqcircle.report.QCircleWeakNetReporter;
import feedcloud.FeedCloudCommon$Entry;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\bp\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0086\b\u0018\u0000 \u0086\u00012\u00020\u0001:\u0004\u0085\u0001\u0086\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004B\u0093\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\u0006\u0012\b\b\u0002\u0010\t\u001a\u00020\u0006\u0012\b\b\u0002\u0010\n\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0006\u0012\b\b\u0002\u0010\f\u001a\u00020\u0006\u0012\b\b\u0002\u0010\r\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u001f\u001a\u00020\u0006\u0012\b\b\u0002\u0010 \u001a\u00020\u0006\u00a2\u0006\u0002\u0010!J\t\u0010Z\u001a\u00020\u0006H\u00c6\u0003J\t\u0010[\u001a\u00020\u0006H\u00c6\u0003J\t\u0010\\\u001a\u00020\u0006H\u00c6\u0003J\t\u0010]\u001a\u00020\u0006H\u00c6\u0003J\t\u0010^\u001a\u00020\u0006H\u00c6\u0003J\t\u0010_\u001a\u00020\u0006H\u00c6\u0003J\t\u0010`\u001a\u00020\u0006H\u00c6\u0003J\t\u0010a\u001a\u00020\u0006H\u00c6\u0003J\t\u0010b\u001a\u00020\u0006H\u00c6\u0003J\t\u0010c\u001a\u00020\u0006H\u00c6\u0003J\t\u0010d\u001a\u00020\u0006H\u00c6\u0003J\t\u0010e\u001a\u00020\u0006H\u00c6\u0003J\t\u0010f\u001a\u00020\u0006H\u00c6\u0003J\t\u0010g\u001a\u00020\u0006H\u00c6\u0003J\t\u0010h\u001a\u00020\u0006H\u00c6\u0003J\t\u0010i\u001a\u00020\u0006H\u00c6\u0003J\t\u0010j\u001a\u00020\u0006H\u00c6\u0003J\t\u0010k\u001a\u00020\u0006H\u00c6\u0003J\t\u0010l\u001a\u00020\u0006H\u00c6\u0003J\t\u0010m\u001a\u00020\u0006H\u00c6\u0003J\t\u0010n\u001a\u00020\u0006H\u00c6\u0003J\t\u0010o\u001a\u00020\u0006H\u00c6\u0003J\t\u0010p\u001a\u00020\u0006H\u00c6\u0003J\t\u0010q\u001a\u00020\u0006H\u00c6\u0003J\t\u0010r\u001a\u00020\u0006H\u00c6\u0003J\t\u0010s\u001a\u00020\u0006H\u00c6\u0003J\t\u0010t\u001a\u00020\u0006H\u00c6\u0003J\u0097\u0002\u0010u\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\u00062\b\b\u0002\u0010\n\u001a\u00020\u00062\b\b\u0002\u0010\u000b\u001a\u00020\u00062\b\b\u0002\u0010\f\u001a\u00020\u00062\b\b\u0002\u0010\r\u001a\u00020\u00062\b\b\u0002\u0010\u000e\u001a\u00020\u00062\b\b\u0002\u0010\u000f\u001a\u00020\u00062\b\b\u0002\u0010\u0010\u001a\u00020\u00062\b\b\u0002\u0010\u0011\u001a\u00020\u00062\b\b\u0002\u0010\u0012\u001a\u00020\u00062\b\b\u0002\u0010\u0013\u001a\u00020\u00062\b\b\u0002\u0010\u0014\u001a\u00020\u00062\b\b\u0002\u0010\u0015\u001a\u00020\u00062\b\b\u0002\u0010\u0016\u001a\u00020\u00062\b\b\u0002\u0010\u0017\u001a\u00020\u00062\b\b\u0002\u0010\u0018\u001a\u00020\u00062\b\b\u0002\u0010\u0019\u001a\u00020\u00062\b\b\u0002\u0010\u001a\u001a\u00020\u00062\b\b\u0002\u0010\u001b\u001a\u00020\u00062\b\b\u0002\u0010\u001c\u001a\u00020\u00062\b\b\u0002\u0010\u001d\u001a\u00020\u00062\b\b\u0002\u0010\u001e\u001a\u00020\u00062\b\b\u0002\u0010\u001f\u001a\u00020\u00062\b\b\u0002\u0010 \u001a\u00020\u0006H\u00c6\u0001J\b\u0010v\u001a\u00020wH\u0016J\u0013\u0010x\u001a\u00020y2\b\u0010z\u001a\u0004\u0018\u00010{H\u00d6\u0003J\t\u0010|\u001a\u00020wH\u00d6\u0001J\f\u0010}\u001a\b\u0012\u0004\u0012\u00020\u007f0~J\u0007\u0010\u0080\u0001\u001a\u00020\u0006J\t\u0010\u0081\u0001\u001a\u00020\u0006H\u0016J\u001b\u0010\u0082\u0001\u001a\u00030\u0083\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0007\u0010\u0084\u0001\u001a\u00020wH\u0016R\u001a\u0010\n\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u001a\u0010\r\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b&\u0010#\"\u0004\b'\u0010%R\u001a\u0010\t\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b(\u0010#\"\u0004\b)\u0010%R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b*\u0010#\"\u0004\b+\u0010%R\u001a\u0010\u0016\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b,\u0010#\"\u0004\b-\u0010%R\u001a\u0010\u0017\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b.\u0010#\"\u0004\b/\u0010%R\u001a\u0010\u0018\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b0\u0010#\"\u0004\b1\u0010%R\u001a\u0010\u0019\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b2\u0010#\"\u0004\b3\u0010%R\u001a\u0010\u001a\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b4\u0010#\"\u0004\b5\u0010%R\u001a\u0010\u001b\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b6\u0010#\"\u0004\b7\u0010%R\u001a\u0010\u001c\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b8\u0010#\"\u0004\b9\u0010%R\u001a\u0010\u001d\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b:\u0010#\"\u0004\b;\u0010%R\u001a\u0010\u001e\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b<\u0010#\"\u0004\b=\u0010%R\u001a\u0010\u001f\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b>\u0010#\"\u0004\b?\u0010%R\u001a\u0010\u0011\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b@\u0010#\"\u0004\bA\u0010%R\u001a\u0010\u0012\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bB\u0010#\"\u0004\bC\u0010%R\u001a\u0010\u0013\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bD\u0010#\"\u0004\bE\u0010%R\u001a\u0010\u0014\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bF\u0010#\"\u0004\bG\u0010%R\u001a\u0010\u0015\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bH\u0010#\"\u0004\bI\u0010%R\u001a\u0010\u000b\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bJ\u0010#\"\u0004\bK\u0010%R\u001a\u0010 \u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bL\u0010#\"\u0004\bM\u0010%R\u001a\u0010\f\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bN\u0010#\"\u0004\bO\u0010%R\u001a\u0010\b\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bP\u0010#\"\u0004\bQ\u0010%R\u001a\u0010\u000f\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bR\u0010#\"\u0004\bS\u0010%R\u001a\u0010\u0010\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bT\u0010#\"\u0004\bU\u0010%R\u001a\u0010\u0007\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bV\u0010#\"\u0004\bW\u0010%R\u001a\u0010\u000e\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bX\u0010#\"\u0004\bY\u0010%\u00a8\u0006\u0087\u0001"}, d2 = {"Lcom/tencent/qqlive/common/report/constant/QQLiveQualityReportData;", "Landroid/os/Parcelable;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "eventId", "", "traceId", "retCode", "desc", "attachInfo", "index", "liveAppid", QCircleWeakNetReporter.KEY_COST, "uid", "roomId", "roomType", "ext5", "ext6", "ext7", "ext8", "ext9", "ext10", "ext11", "ext12", "ext13", "ext14", "ext15", "ext16", "ext17", "ext18", QQLiveReportConstants.AttaColumn.EXT19, "jsonExt", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAttachInfo", "()Ljava/lang/String;", "setAttachInfo", "(Ljava/lang/String;)V", "getCost", "setCost", "getDesc", "setDesc", "getEventId", "setEventId", "getExt10", "setExt10", "getExt11", "setExt11", "getExt12", "setExt12", "getExt13", "setExt13", "getExt14", "setExt14", "getExt15", "setExt15", "getExt16", "setExt16", "getExt17", "setExt17", "getExt18", "setExt18", "getExt19", "setExt19", "getExt5", "setExt5", "getExt6", "setExt6", "getExt7", "setExt7", "getExt8", "setExt8", "getExt9", "setExt9", "getIndex", "setIndex", "getJsonExt", "setJsonExt", "getLiveAppid", "setLiveAppid", "getRetCode", "setRetCode", "getRoomId", "setRoomId", "getRoomType", "setRoomType", "getTraceId", "setTraceId", "getUid", "setUid", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "component27", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toEntry", "Ljava/util/ArrayList;", "Lfeedcloud/FeedCloudCommon$Entry;", "toPrintString", "toString", "writeToParcel", "", WadlProxyConsts.FLAGS, "Builder", "Companion", "qq-live-common-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes22.dex */
public final /* data */ class QQLiveQualityReportData implements Parcelable {

    @NotNull
    private String attachInfo;

    /* renamed from: cost, reason: from kotlin metadata and from toString */
    @NotNull
    private String ext1;

    @NotNull
    private String desc;

    @NotNull
    private String eventId;

    @NotNull
    private String ext10;

    @NotNull
    private String ext11;

    @NotNull
    private String ext12;

    @NotNull
    private String ext13;

    @NotNull
    private String ext14;

    @NotNull
    private String ext15;

    @NotNull
    private String ext16;

    @NotNull
    private String ext17;

    @NotNull
    private String ext18;

    @NotNull
    private String ext19;

    @NotNull
    private String ext5;

    @NotNull
    private String ext6;

    @NotNull
    private String ext7;

    @NotNull
    private String ext8;

    @NotNull
    private String ext9;

    @NotNull
    private String index;

    @NotNull
    private String jsonExt;

    @NotNull
    private String liveAppid;

    @NotNull
    private String retCode;

    /* renamed from: roomId, reason: from kotlin metadata and from toString */
    @NotNull
    private String ext3;

    /* renamed from: roomType, reason: from kotlin metadata and from toString */
    @NotNull
    private String ext4;

    @NotNull
    private String traceId;

    /* renamed from: uid, reason: from kotlin metadata and from toString */
    @NotNull
    private String ext2;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @JvmField
    @NotNull
    public static final Parcelable.Creator<QQLiveQualityReportData> CREATOR = new a();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\bG\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0089\u0002\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\f\u001a\u00020\u0003\u0012\b\b\u0002\u0010\r\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u001dJ\u0010\u0010\u0007\u001a\u00020\u00002\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003J\u0006\u0010V\u001a\u00020KJ\u0010\u0010\n\u001a\u00020\u00002\b\u0010\n\u001a\u0004\u0018\u00010\u0003J\u0010\u0010\u0006\u001a\u00020\u00002\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003J\u0010\u0010\u0002\u001a\u00020\u00002\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003J\u0010\u0010\u0012\u001a\u00020\u00002\b\u0010\u0012\u001a\u0004\u0018\u00010\u0003J\u0010\u0010\u0013\u001a\u00020\u00002\b\u0010\u0013\u001a\u0004\u0018\u00010\u0003J\u0010\u0010\u0014\u001a\u00020\u00002\b\u0010\u0014\u001a\u0004\u0018\u00010\u0003J\u0010\u0010\u0015\u001a\u00020\u00002\b\u0010\u0015\u001a\u0004\u0018\u00010\u0003J\u0010\u0010\u0016\u001a\u00020\u00002\b\u0010\u0016\u001a\u0004\u0018\u00010\u0003J\u0010\u0010\u0017\u001a\u00020\u00002\b\u0010\u0017\u001a\u0004\u0018\u00010\u0003J\u0010\u0010\u0018\u001a\u00020\u00002\b\u0010\u0018\u001a\u0004\u0018\u00010\u0003J\u0010\u0010\u0019\u001a\u00020\u00002\b\u0010\u0019\u001a\u0004\u0018\u00010\u0003J\u0010\u0010\u001a\u001a\u00020\u00002\b\u0010\u001a\u001a\u0004\u0018\u00010\u0003J\u0010\u0010\u001b\u001a\u00020\u00002\b\u0010\u001b\u001a\u0004\u0018\u00010\u0003J\u0010\u0010\u000e\u001a\u00020\u00002\b\u0010\u000e\u001a\u0004\u0018\u00010\u0003J\u0010\u0010\u000f\u001a\u00020\u00002\b\u0010\u000f\u001a\u0004\u0018\u00010\u0003J\u0010\u0010\u0010\u001a\u00020\u00002\b\u0010\u0010\u001a\u0004\u0018\u00010\u0003J\u0010\u0010\u0011\u001a\u00020\u00002\b\u0010\u0011\u001a\u0004\u0018\u00010\u0003J\u0010\u0010\b\u001a\u00020\u00002\b\u0010\b\u001a\u0004\u0018\u00010\u0003J\u0010\u0010\u001c\u001a\u00020\u00002\b\u0010\u001c\u001a\u0004\u0018\u00010\u0003J\u0010\u0010\t\u001a\u00020\u00002\b\u0010\t\u001a\u0004\u0018\u00010\u0003J\u0010\u0010\u0005\u001a\u00020\u00002\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003J\u0010\u0010\f\u001a\u00020\u00002\b\u0010\f\u001a\u0004\u0018\u00010\u0003J\u0010\u0010\r\u001a\u00020\u00002\b\u0010\r\u001a\u0004\u0018\u00010\u0003J\f\u0010W\u001a\b\u0012\u0004\u0012\u00020Y0XJ\b\u0010Z\u001a\u00020\u0003H\u0016J\u0010\u0010\u0004\u001a\u00020\u00002\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003J\u0010\u0010\u000b\u001a\u00020\u00002\b\u0010\u000b\u001a\u0004\u0018\u00010\u0003R\u001a\u0010\u0007\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001a\u0010\n\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u001f\"\u0004\b#\u0010!R\u001a\u0010\u0006\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u001f\"\u0004\b%\u0010!R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u001f\"\u0004\b'\u0010!R\u001a\u0010\u0012\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u001f\"\u0004\b)\u0010!R\u001a\u0010\u0013\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b*\u0010\u001f\"\u0004\b+\u0010!R\u001a\u0010\u0014\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b,\u0010\u001f\"\u0004\b-\u0010!R\u001a\u0010\u0015\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b.\u0010\u001f\"\u0004\b/\u0010!R\u001a\u0010\u0016\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b0\u0010\u001f\"\u0004\b1\u0010!R\u001a\u0010\u0017\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b2\u0010\u001f\"\u0004\b3\u0010!R\u001a\u0010\u0018\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b4\u0010\u001f\"\u0004\b5\u0010!R\u001a\u0010\u0019\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b6\u0010\u001f\"\u0004\b7\u0010!R\u001a\u0010\u001a\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b8\u0010\u001f\"\u0004\b9\u0010!R\u001a\u0010\u001b\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b:\u0010\u001f\"\u0004\b;\u0010!R\u001a\u0010\u000e\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b<\u0010\u001f\"\u0004\b=\u0010!R\u001a\u0010\u000f\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b>\u0010\u001f\"\u0004\b?\u0010!R\u001a\u0010\u0010\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b@\u0010\u001f\"\u0004\bA\u0010!R\u001a\u0010\u0011\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bB\u0010\u001f\"\u0004\bC\u0010!R\u001a\u0010\b\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bD\u0010\u001f\"\u0004\bE\u0010!R\u001a\u0010\u001c\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bF\u0010\u001f\"\u0004\bG\u0010!R\u001a\u0010\t\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bH\u0010\u001f\"\u0004\bI\u0010!R\u000e\u0010J\u001a\u00020KX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bL\u0010\u001f\"\u0004\bM\u0010!R\u001a\u0010\f\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bN\u0010\u001f\"\u0004\bO\u0010!R\u001a\u0010\r\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bP\u0010\u001f\"\u0004\bQ\u0010!R\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bR\u0010\u001f\"\u0004\bS\u0010!R\u001a\u0010\u000b\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bT\u0010\u001f\"\u0004\bU\u0010!\u00a8\u0006["}, d2 = {"Lcom/tencent/qqlive/common/report/constant/QQLiveQualityReportData$Builder;", "", "eventId", "", "traceId", "retCode", "desc", "attachInfo", "index", "liveAppid", QCircleWeakNetReporter.KEY_COST, "uid", "roomId", "roomType", "ext6", "ext7", "ext8", "ext9", "ext10", "ext11", "ext12", "ext13", "ext14", "ext15", "ext16", "ext17", "ext18", QQLiveReportConstants.AttaColumn.EXT19, "jsonExt", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAttachInfo", "()Ljava/lang/String;", "setAttachInfo", "(Ljava/lang/String;)V", "getCost", "setCost", "getDesc", "setDesc", "getEventId", "setEventId", "getExt10", "setExt10", "getExt11", "setExt11", "getExt12", "setExt12", "getExt13", "setExt13", "getExt14", "setExt14", "getExt15", "setExt15", "getExt16", "setExt16", "getExt17", "setExt17", "getExt18", "setExt18", "getExt19", "setExt19", "getExt6", "setExt6", "getExt7", "setExt7", "getExt8", "setExt8", "getExt9", "setExt9", "getIndex", "setIndex", "getJsonExt", "setJsonExt", "getLiveAppid", "setLiveAppid", "reportData", "Lcom/tencent/qqlive/common/report/constant/QQLiveQualityReportData;", "getRetCode", "setRetCode", "getRoomId", "setRoomId", "getRoomType", "setRoomType", "getTraceId", "setTraceId", "getUid", "setUid", "build", "toEntry", "Ljava/util/ArrayList;", "Lfeedcloud/FeedCloudCommon$Entry;", "toString", "qq-live-common-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes22.dex */
    public static final class Builder {

        @NotNull
        private String attachInfo;

        @NotNull
        private String cost;

        @NotNull
        private String desc;

        @NotNull
        private String eventId;

        @NotNull
        private String ext10;

        @NotNull
        private String ext11;

        @NotNull
        private String ext12;

        @NotNull
        private String ext13;

        @NotNull
        private String ext14;

        @NotNull
        private String ext15;

        @NotNull
        private String ext16;

        @NotNull
        private String ext17;

        @NotNull
        private String ext18;

        @NotNull
        private String ext19;

        @NotNull
        private String ext6;

        @NotNull
        private String ext7;

        @NotNull
        private String ext8;

        @NotNull
        private String ext9;

        @NotNull
        private String index;

        @NotNull
        private String jsonExt;

        @NotNull
        private String liveAppid;

        @NotNull
        private final QQLiveQualityReportData reportData;

        @NotNull
        private String retCode;

        @NotNull
        private String roomId;

        @NotNull
        private String roomType;

        @NotNull
        private String traceId;

        @NotNull
        private String uid;

        public Builder() {
            this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 67108863, null);
        }

        @NotNull
        public final Builder attachInfo(@Nullable String attachInfo) {
            if (attachInfo != null) {
                this.reportData.setAttachInfo(attachInfo);
            }
            return this;
        }

        @NotNull
        /* renamed from: build, reason: from getter */
        public final QQLiveQualityReportData getReportData() {
            return this.reportData;
        }

        @NotNull
        public final Builder cost(@Nullable String cost) {
            if (cost != null) {
                this.reportData.setCost(cost);
            }
            return this;
        }

        @NotNull
        public final Builder desc(@Nullable String desc) {
            if (desc != null) {
                this.reportData.setDesc(desc);
            }
            return this;
        }

        @NotNull
        public final Builder eventId(@Nullable String eventId) {
            if (eventId != null) {
                this.reportData.setEventId(eventId);
            }
            return this;
        }

        @NotNull
        public final Builder ext10(@Nullable String ext10) {
            if (ext10 != null) {
                this.reportData.setExt10(ext10);
            }
            return this;
        }

        @NotNull
        public final Builder ext11(@Nullable String ext11) {
            if (ext11 != null) {
                this.reportData.setExt11(ext11);
            }
            return this;
        }

        @NotNull
        public final Builder ext12(@Nullable String ext12) {
            if (ext12 != null) {
                this.reportData.setExt12(ext12);
            }
            return this;
        }

        @NotNull
        public final Builder ext13(@Nullable String ext13) {
            if (ext13 != null) {
                this.reportData.setExt13(ext13);
            }
            return this;
        }

        @NotNull
        public final Builder ext14(@Nullable String ext14) {
            if (ext14 != null) {
                this.reportData.setExt14(ext14);
            }
            return this;
        }

        @NotNull
        public final Builder ext15(@Nullable String ext15) {
            if (ext15 != null) {
                this.reportData.setExt15(ext15);
            }
            return this;
        }

        @NotNull
        public final Builder ext16(@Nullable String ext16) {
            if (ext16 != null) {
                this.reportData.setExt16(ext16);
            }
            return this;
        }

        @NotNull
        public final Builder ext17(@Nullable String ext17) {
            if (ext17 != null) {
                this.reportData.setExt17(ext17);
            }
            return this;
        }

        @NotNull
        public final Builder ext18(@Nullable String ext18) {
            if (ext18 != null) {
                this.reportData.setExt18(ext18);
            }
            return this;
        }

        @NotNull
        public final Builder ext19(@Nullable String ext19) {
            if (ext19 != null) {
                this.reportData.setExt19(ext19);
            }
            return this;
        }

        @NotNull
        public final Builder ext6(@Nullable String ext6) {
            if (ext6 != null) {
                this.reportData.setExt6(ext6);
            }
            return this;
        }

        @NotNull
        public final Builder ext7(@Nullable String ext7) {
            if (ext7 != null) {
                this.reportData.setExt7(ext7);
            }
            return this;
        }

        @NotNull
        public final Builder ext8(@Nullable String ext8) {
            if (ext8 != null) {
                this.reportData.setExt8(ext8);
            }
            return this;
        }

        @NotNull
        public final Builder ext9(@Nullable String ext9) {
            if (ext9 != null) {
                this.reportData.setExt9(ext9);
            }
            return this;
        }

        @NotNull
        public final String getAttachInfo() {
            return this.attachInfo;
        }

        @NotNull
        public final String getCost() {
            return this.cost;
        }

        @NotNull
        public final String getDesc() {
            return this.desc;
        }

        @NotNull
        public final String getEventId() {
            return this.eventId;
        }

        @NotNull
        public final String getExt10() {
            return this.ext10;
        }

        @NotNull
        public final String getExt11() {
            return this.ext11;
        }

        @NotNull
        public final String getExt12() {
            return this.ext12;
        }

        @NotNull
        public final String getExt13() {
            return this.ext13;
        }

        @NotNull
        public final String getExt14() {
            return this.ext14;
        }

        @NotNull
        public final String getExt15() {
            return this.ext15;
        }

        @NotNull
        public final String getExt16() {
            return this.ext16;
        }

        @NotNull
        public final String getExt17() {
            return this.ext17;
        }

        @NotNull
        public final String getExt18() {
            return this.ext18;
        }

        @NotNull
        public final String getExt19() {
            return this.ext19;
        }

        @NotNull
        public final String getExt6() {
            return this.ext6;
        }

        @NotNull
        public final String getExt7() {
            return this.ext7;
        }

        @NotNull
        public final String getExt8() {
            return this.ext8;
        }

        @NotNull
        public final String getExt9() {
            return this.ext9;
        }

        @NotNull
        public final String getIndex() {
            return this.index;
        }

        @NotNull
        public final String getJsonExt() {
            return this.jsonExt;
        }

        @NotNull
        public final String getLiveAppid() {
            return this.liveAppid;
        }

        @NotNull
        public final String getRetCode() {
            return this.retCode;
        }

        @NotNull
        public final String getRoomId() {
            return this.roomId;
        }

        @NotNull
        public final String getRoomType() {
            return this.roomType;
        }

        @NotNull
        public final String getTraceId() {
            return this.traceId;
        }

        @NotNull
        public final String getUid() {
            return this.uid;
        }

        @NotNull
        public final Builder index(@Nullable String index) {
            if (index != null) {
                this.reportData.setIndex(index);
            }
            return this;
        }

        @NotNull
        public final Builder jsonExt(@Nullable String jsonExt) {
            if (jsonExt != null) {
                this.reportData.setJsonExt(jsonExt);
            }
            return this;
        }

        @NotNull
        public final Builder liveAppid(@Nullable String liveAppid) {
            if (liveAppid != null) {
                this.reportData.setLiveAppid(liveAppid);
            }
            return this;
        }

        @NotNull
        public final Builder retCode(@Nullable String retCode) {
            if (retCode != null) {
                this.reportData.setRetCode(retCode);
            }
            return this;
        }

        @NotNull
        public final Builder roomId(@Nullable String roomId) {
            if (roomId != null) {
                this.reportData.setRoomId(roomId);
            }
            return this;
        }

        @NotNull
        public final Builder roomType(@Nullable String roomType) {
            if (roomType != null) {
                this.reportData.setRoomType(roomType);
            }
            return this;
        }

        public final void setAttachInfo(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.attachInfo = str;
        }

        public final void setCost(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.cost = str;
        }

        public final void setDesc(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.desc = str;
        }

        public final void setEventId(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.eventId = str;
        }

        public final void setExt10(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.ext10 = str;
        }

        public final void setExt11(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.ext11 = str;
        }

        public final void setExt12(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.ext12 = str;
        }

        public final void setExt13(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.ext13 = str;
        }

        public final void setExt14(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.ext14 = str;
        }

        public final void setExt15(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.ext15 = str;
        }

        public final void setExt16(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.ext16 = str;
        }

        public final void setExt17(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.ext17 = str;
        }

        public final void setExt18(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.ext18 = str;
        }

        public final void setExt19(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.ext19 = str;
        }

        public final void setExt6(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.ext6 = str;
        }

        public final void setExt7(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.ext7 = str;
        }

        public final void setExt8(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.ext8 = str;
        }

        public final void setExt9(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.ext9 = str;
        }

        public final void setIndex(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.index = str;
        }

        public final void setJsonExt(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.jsonExt = str;
        }

        public final void setLiveAppid(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.liveAppid = str;
        }

        public final void setRetCode(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.retCode = str;
        }

        public final void setRoomId(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.roomId = str;
        }

        public final void setRoomType(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.roomType = str;
        }

        public final void setTraceId(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.traceId = str;
        }

        public final void setUid(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.uid = str;
        }

        @NotNull
        public final ArrayList<FeedCloudCommon$Entry> toEntry() {
            return this.reportData.toEntry();
        }

        @NotNull
        public String toString() {
            return String.valueOf(this.reportData.toPrintString());
        }

        @NotNull
        public final Builder traceId(@Nullable String traceId) {
            if (traceId != null) {
                this.reportData.setTraceId(traceId);
            }
            return this;
        }

        @NotNull
        public final Builder uid(@Nullable String uid) {
            if (uid != null) {
                this.reportData.setUid(uid);
            }
            return this;
        }

        public Builder(@NotNull String eventId, @NotNull String traceId, @NotNull String retCode, @NotNull String desc, @NotNull String attachInfo, @NotNull String index, @NotNull String liveAppid, @NotNull String cost, @NotNull String uid, @NotNull String roomId, @NotNull String roomType, @NotNull String ext6, @NotNull String ext7, @NotNull String ext8, @NotNull String ext9, @NotNull String ext10, @NotNull String ext11, @NotNull String ext12, @NotNull String ext13, @NotNull String ext14, @NotNull String ext15, @NotNull String ext16, @NotNull String ext17, @NotNull String ext18, @NotNull String ext19, @NotNull String jsonExt) {
            Intrinsics.checkNotNullParameter(eventId, "eventId");
            Intrinsics.checkNotNullParameter(traceId, "traceId");
            Intrinsics.checkNotNullParameter(retCode, "retCode");
            Intrinsics.checkNotNullParameter(desc, "desc");
            Intrinsics.checkNotNullParameter(attachInfo, "attachInfo");
            Intrinsics.checkNotNullParameter(index, "index");
            Intrinsics.checkNotNullParameter(liveAppid, "liveAppid");
            Intrinsics.checkNotNullParameter(cost, "cost");
            Intrinsics.checkNotNullParameter(uid, "uid");
            Intrinsics.checkNotNullParameter(roomId, "roomId");
            Intrinsics.checkNotNullParameter(roomType, "roomType");
            Intrinsics.checkNotNullParameter(ext6, "ext6");
            Intrinsics.checkNotNullParameter(ext7, "ext7");
            Intrinsics.checkNotNullParameter(ext8, "ext8");
            Intrinsics.checkNotNullParameter(ext9, "ext9");
            Intrinsics.checkNotNullParameter(ext10, "ext10");
            Intrinsics.checkNotNullParameter(ext11, "ext11");
            Intrinsics.checkNotNullParameter(ext12, "ext12");
            Intrinsics.checkNotNullParameter(ext13, "ext13");
            Intrinsics.checkNotNullParameter(ext14, "ext14");
            Intrinsics.checkNotNullParameter(ext15, "ext15");
            Intrinsics.checkNotNullParameter(ext16, "ext16");
            Intrinsics.checkNotNullParameter(ext17, "ext17");
            Intrinsics.checkNotNullParameter(ext18, "ext18");
            Intrinsics.checkNotNullParameter(ext19, "ext19");
            Intrinsics.checkNotNullParameter(jsonExt, "jsonExt");
            this.eventId = eventId;
            this.traceId = traceId;
            this.retCode = retCode;
            this.desc = desc;
            this.attachInfo = attachInfo;
            this.index = index;
            this.liveAppid = liveAppid;
            this.cost = cost;
            this.uid = uid;
            this.roomId = roomId;
            this.roomType = roomType;
            this.ext6 = ext6;
            this.ext7 = ext7;
            this.ext8 = ext8;
            this.ext9 = ext9;
            this.ext10 = ext10;
            this.ext11 = ext11;
            this.ext12 = ext12;
            this.ext13 = ext13;
            this.ext14 = ext14;
            this.ext15 = ext15;
            this.ext16 = ext16;
            this.ext17 = ext17;
            this.ext18 = ext18;
            this.ext19 = ext19;
            this.jsonExt = jsonExt;
            String str = null;
            this.reportData = new QQLiveQualityReportData(null, null, null, null, null, null, null, null, null, null, null, null, null, str, str, null, null, null, null, null, null, null, null, null, null, null, null, 134217727, null);
        }

        public /* synthetic */ Builder(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, String str16, String str17, String str18, String str19, String str20, String str21, String str22, String str23, String str24, String str25, String str26, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this((i3 & 1) != 0 ? "" : str, (i3 & 2) != 0 ? "" : str2, (i3 & 4) != 0 ? "" : str3, (i3 & 8) != 0 ? "" : str4, (i3 & 16) != 0 ? "" : str5, (i3 & 32) != 0 ? "" : str6, (i3 & 64) != 0 ? "" : str7, (i3 & 128) != 0 ? "" : str8, (i3 & 256) != 0 ? "" : str9, (i3 & 512) != 0 ? "" : str10, (i3 & 1024) != 0 ? "" : str11, (i3 & 2048) != 0 ? "" : str12, (i3 & 4096) != 0 ? "" : str13, (i3 & 8192) != 0 ? "" : str14, (i3 & 16384) != 0 ? "" : str15, (i3 & 32768) != 0 ? "" : str16, (i3 & 65536) != 0 ? "" : str17, (i3 & 131072) != 0 ? "" : str18, (i3 & 262144) != 0 ? "" : str19, (i3 & 524288) != 0 ? "" : str20, (i3 & 1048576) != 0 ? "" : str21, (i3 & 2097152) != 0 ? "" : str22, (i3 & 4194304) != 0 ? "" : str23, (i3 & 8388608) != 0 ? "" : str24, (i3 & 16777216) != 0 ? "" : str25, (i3 & 33554432) != 0 ? "" : str26);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\tR\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/qqlive/common/report/constant/QQLiveQualityReportData$Companion;", "", "()V", "CREATOR", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/qqlive/common/report/constant/QQLiveQualityReportData;", "newEntry", "Lfeedcloud/FeedCloudCommon$Entry;", "key", "", "value", "qq-live-common-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes22.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final FeedCloudCommon$Entry newEntry(@NotNull String key, @Nullable String value) {
            Intrinsics.checkNotNullParameter(key, "key");
            FeedCloudCommon$Entry feedCloudCommon$Entry = new FeedCloudCommon$Entry();
            feedCloudCommon$Entry.key.set(key);
            if (value != null) {
                feedCloudCommon$Entry.value.set(value);
            }
            return feedCloudCommon$Entry;
        }

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u001f\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a2\u0006\u0004\b\t\u0010\n\u00a8\u0006\u000b"}, d2 = {"com/tencent/qqlive/common/report/constant/QQLiveQualityReportData$a", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/qqlive/common/report/constant/QQLiveQualityReportData;", "Landroid/os/Parcel;", "parcel", "a", "", "size", "", "b", "(I)[Lcom/tencent/qqlive/common/report/constant/QQLiveQualityReportData;", "qq-live-common-api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes22.dex */
    public static final class a implements Parcelable.Creator<QQLiveQualityReportData> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public QQLiveQualityReportData createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new QQLiveQualityReportData(parcel);
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public QQLiveQualityReportData[] newArray(int size) {
            return new QQLiveQualityReportData[size];
        }
    }

    public QQLiveQualityReportData() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 134217727, null);
    }

    @NotNull
    /* renamed from: component1, reason: from getter */
    public final String getEventId() {
        return this.eventId;
    }

    @NotNull
    /* renamed from: component10, reason: from getter */
    public final String getExt3() {
        return this.ext3;
    }

    @NotNull
    /* renamed from: component11, reason: from getter */
    public final String getExt4() {
        return this.ext4;
    }

    @NotNull
    /* renamed from: component12, reason: from getter */
    public final String getExt5() {
        return this.ext5;
    }

    @NotNull
    /* renamed from: component13, reason: from getter */
    public final String getExt6() {
        return this.ext6;
    }

    @NotNull
    /* renamed from: component14, reason: from getter */
    public final String getExt7() {
        return this.ext7;
    }

    @NotNull
    /* renamed from: component15, reason: from getter */
    public final String getExt8() {
        return this.ext8;
    }

    @NotNull
    /* renamed from: component16, reason: from getter */
    public final String getExt9() {
        return this.ext9;
    }

    @NotNull
    /* renamed from: component17, reason: from getter */
    public final String getExt10() {
        return this.ext10;
    }

    @NotNull
    /* renamed from: component18, reason: from getter */
    public final String getExt11() {
        return this.ext11;
    }

    @NotNull
    /* renamed from: component19, reason: from getter */
    public final String getExt12() {
        return this.ext12;
    }

    @NotNull
    /* renamed from: component2, reason: from getter */
    public final String getTraceId() {
        return this.traceId;
    }

    @NotNull
    /* renamed from: component20, reason: from getter */
    public final String getExt13() {
        return this.ext13;
    }

    @NotNull
    /* renamed from: component21, reason: from getter */
    public final String getExt14() {
        return this.ext14;
    }

    @NotNull
    /* renamed from: component22, reason: from getter */
    public final String getExt15() {
        return this.ext15;
    }

    @NotNull
    /* renamed from: component23, reason: from getter */
    public final String getExt16() {
        return this.ext16;
    }

    @NotNull
    /* renamed from: component24, reason: from getter */
    public final String getExt17() {
        return this.ext17;
    }

    @NotNull
    /* renamed from: component25, reason: from getter */
    public final String getExt18() {
        return this.ext18;
    }

    @NotNull
    /* renamed from: component26, reason: from getter */
    public final String getExt19() {
        return this.ext19;
    }

    @NotNull
    /* renamed from: component27, reason: from getter */
    public final String getJsonExt() {
        return this.jsonExt;
    }

    @NotNull
    /* renamed from: component3, reason: from getter */
    public final String getRetCode() {
        return this.retCode;
    }

    @NotNull
    /* renamed from: component4, reason: from getter */
    public final String getDesc() {
        return this.desc;
    }

    @NotNull
    /* renamed from: component5, reason: from getter */
    public final String getAttachInfo() {
        return this.attachInfo;
    }

    @NotNull
    /* renamed from: component6, reason: from getter */
    public final String getIndex() {
        return this.index;
    }

    @NotNull
    /* renamed from: component7, reason: from getter */
    public final String getLiveAppid() {
        return this.liveAppid;
    }

    @NotNull
    /* renamed from: component8, reason: from getter */
    public final String getExt1() {
        return this.ext1;
    }

    @NotNull
    /* renamed from: component9, reason: from getter */
    public final String getExt2() {
        return this.ext2;
    }

    @NotNull
    public final QQLiveQualityReportData copy(@NotNull String eventId, @NotNull String traceId, @NotNull String retCode, @NotNull String desc, @NotNull String attachInfo, @NotNull String index, @NotNull String liveAppid, @NotNull String cost, @NotNull String uid, @NotNull String roomId, @NotNull String roomType, @NotNull String ext5, @NotNull String ext6, @NotNull String ext7, @NotNull String ext8, @NotNull String ext9, @NotNull String ext10, @NotNull String ext11, @NotNull String ext12, @NotNull String ext13, @NotNull String ext14, @NotNull String ext15, @NotNull String ext16, @NotNull String ext17, @NotNull String ext18, @NotNull String ext19, @NotNull String jsonExt) {
        Intrinsics.checkNotNullParameter(eventId, "eventId");
        Intrinsics.checkNotNullParameter(traceId, "traceId");
        Intrinsics.checkNotNullParameter(retCode, "retCode");
        Intrinsics.checkNotNullParameter(desc, "desc");
        Intrinsics.checkNotNullParameter(attachInfo, "attachInfo");
        Intrinsics.checkNotNullParameter(index, "index");
        Intrinsics.checkNotNullParameter(liveAppid, "liveAppid");
        Intrinsics.checkNotNullParameter(cost, "cost");
        Intrinsics.checkNotNullParameter(uid, "uid");
        Intrinsics.checkNotNullParameter(roomId, "roomId");
        Intrinsics.checkNotNullParameter(roomType, "roomType");
        Intrinsics.checkNotNullParameter(ext5, "ext5");
        Intrinsics.checkNotNullParameter(ext6, "ext6");
        Intrinsics.checkNotNullParameter(ext7, "ext7");
        Intrinsics.checkNotNullParameter(ext8, "ext8");
        Intrinsics.checkNotNullParameter(ext9, "ext9");
        Intrinsics.checkNotNullParameter(ext10, "ext10");
        Intrinsics.checkNotNullParameter(ext11, "ext11");
        Intrinsics.checkNotNullParameter(ext12, "ext12");
        Intrinsics.checkNotNullParameter(ext13, "ext13");
        Intrinsics.checkNotNullParameter(ext14, "ext14");
        Intrinsics.checkNotNullParameter(ext15, "ext15");
        Intrinsics.checkNotNullParameter(ext16, "ext16");
        Intrinsics.checkNotNullParameter(ext17, "ext17");
        Intrinsics.checkNotNullParameter(ext18, "ext18");
        Intrinsics.checkNotNullParameter(ext19, "ext19");
        Intrinsics.checkNotNullParameter(jsonExt, "jsonExt");
        return new QQLiveQualityReportData(eventId, traceId, retCode, desc, attachInfo, index, liveAppid, cost, uid, roomId, roomType, ext5, ext6, ext7, ext8, ext9, ext10, ext11, ext12, ext13, ext14, ext15, ext16, ext17, ext18, ext19, jsonExt);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof QQLiveQualityReportData)) {
            return false;
        }
        QQLiveQualityReportData qQLiveQualityReportData = (QQLiveQualityReportData) other;
        if (Intrinsics.areEqual(this.eventId, qQLiveQualityReportData.eventId) && Intrinsics.areEqual(this.traceId, qQLiveQualityReportData.traceId) && Intrinsics.areEqual(this.retCode, qQLiveQualityReportData.retCode) && Intrinsics.areEqual(this.desc, qQLiveQualityReportData.desc) && Intrinsics.areEqual(this.attachInfo, qQLiveQualityReportData.attachInfo) && Intrinsics.areEqual(this.index, qQLiveQualityReportData.index) && Intrinsics.areEqual(this.liveAppid, qQLiveQualityReportData.liveAppid) && Intrinsics.areEqual(this.ext1, qQLiveQualityReportData.ext1) && Intrinsics.areEqual(this.ext2, qQLiveQualityReportData.ext2) && Intrinsics.areEqual(this.ext3, qQLiveQualityReportData.ext3) && Intrinsics.areEqual(this.ext4, qQLiveQualityReportData.ext4) && Intrinsics.areEqual(this.ext5, qQLiveQualityReportData.ext5) && Intrinsics.areEqual(this.ext6, qQLiveQualityReportData.ext6) && Intrinsics.areEqual(this.ext7, qQLiveQualityReportData.ext7) && Intrinsics.areEqual(this.ext8, qQLiveQualityReportData.ext8) && Intrinsics.areEqual(this.ext9, qQLiveQualityReportData.ext9) && Intrinsics.areEqual(this.ext10, qQLiveQualityReportData.ext10) && Intrinsics.areEqual(this.ext11, qQLiveQualityReportData.ext11) && Intrinsics.areEqual(this.ext12, qQLiveQualityReportData.ext12) && Intrinsics.areEqual(this.ext13, qQLiveQualityReportData.ext13) && Intrinsics.areEqual(this.ext14, qQLiveQualityReportData.ext14) && Intrinsics.areEqual(this.ext15, qQLiveQualityReportData.ext15) && Intrinsics.areEqual(this.ext16, qQLiveQualityReportData.ext16) && Intrinsics.areEqual(this.ext17, qQLiveQualityReportData.ext17) && Intrinsics.areEqual(this.ext18, qQLiveQualityReportData.ext18) && Intrinsics.areEqual(this.ext19, qQLiveQualityReportData.ext19) && Intrinsics.areEqual(this.jsonExt, qQLiveQualityReportData.jsonExt)) {
            return true;
        }
        return false;
    }

    @NotNull
    public final String getAttachInfo() {
        return this.attachInfo;
    }

    @NotNull
    public final String getCost() {
        return this.ext1;
    }

    @NotNull
    public final String getDesc() {
        return this.desc;
    }

    @NotNull
    public final String getEventId() {
        return this.eventId;
    }

    @NotNull
    public final String getExt10() {
        return this.ext10;
    }

    @NotNull
    public final String getExt11() {
        return this.ext11;
    }

    @NotNull
    public final String getExt12() {
        return this.ext12;
    }

    @NotNull
    public final String getExt13() {
        return this.ext13;
    }

    @NotNull
    public final String getExt14() {
        return this.ext14;
    }

    @NotNull
    public final String getExt15() {
        return this.ext15;
    }

    @NotNull
    public final String getExt16() {
        return this.ext16;
    }

    @NotNull
    public final String getExt17() {
        return this.ext17;
    }

    @NotNull
    public final String getExt18() {
        return this.ext18;
    }

    @NotNull
    public final String getExt19() {
        return this.ext19;
    }

    @NotNull
    public final String getExt5() {
        return this.ext5;
    }

    @NotNull
    public final String getExt6() {
        return this.ext6;
    }

    @NotNull
    public final String getExt7() {
        return this.ext7;
    }

    @NotNull
    public final String getExt8() {
        return this.ext8;
    }

    @NotNull
    public final String getExt9() {
        return this.ext9;
    }

    @NotNull
    public final String getIndex() {
        return this.index;
    }

    @NotNull
    public final String getJsonExt() {
        return this.jsonExt;
    }

    @NotNull
    public final String getLiveAppid() {
        return this.liveAppid;
    }

    @NotNull
    public final String getRetCode() {
        return this.retCode;
    }

    @NotNull
    public final String getRoomId() {
        return this.ext3;
    }

    @NotNull
    public final String getRoomType() {
        return this.ext4;
    }

    @NotNull
    public final String getTraceId() {
        return this.traceId;
    }

    @NotNull
    public final String getUid() {
        return this.ext2;
    }

    public int hashCode() {
        return (((((((((((((((((((((((((((((((((((((((((((((((((((this.eventId.hashCode() * 31) + this.traceId.hashCode()) * 31) + this.retCode.hashCode()) * 31) + this.desc.hashCode()) * 31) + this.attachInfo.hashCode()) * 31) + this.index.hashCode()) * 31) + this.liveAppid.hashCode()) * 31) + this.ext1.hashCode()) * 31) + this.ext2.hashCode()) * 31) + this.ext3.hashCode()) * 31) + this.ext4.hashCode()) * 31) + this.ext5.hashCode()) * 31) + this.ext6.hashCode()) * 31) + this.ext7.hashCode()) * 31) + this.ext8.hashCode()) * 31) + this.ext9.hashCode()) * 31) + this.ext10.hashCode()) * 31) + this.ext11.hashCode()) * 31) + this.ext12.hashCode()) * 31) + this.ext13.hashCode()) * 31) + this.ext14.hashCode()) * 31) + this.ext15.hashCode()) * 31) + this.ext16.hashCode()) * 31) + this.ext17.hashCode()) * 31) + this.ext18.hashCode()) * 31) + this.ext19.hashCode()) * 31) + this.jsonExt.hashCode();
    }

    public final void setAttachInfo(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.attachInfo = str;
    }

    public final void setCost(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.ext1 = str;
    }

    public final void setDesc(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.desc = str;
    }

    public final void setEventId(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.eventId = str;
    }

    public final void setExt10(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.ext10 = str;
    }

    public final void setExt11(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.ext11 = str;
    }

    public final void setExt12(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.ext12 = str;
    }

    public final void setExt13(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.ext13 = str;
    }

    public final void setExt14(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.ext14 = str;
    }

    public final void setExt15(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.ext15 = str;
    }

    public final void setExt16(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.ext16 = str;
    }

    public final void setExt17(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.ext17 = str;
    }

    public final void setExt18(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.ext18 = str;
    }

    public final void setExt19(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.ext19 = str;
    }

    public final void setExt5(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.ext5 = str;
    }

    public final void setExt6(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.ext6 = str;
    }

    public final void setExt7(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.ext7 = str;
    }

    public final void setExt8(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.ext8 = str;
    }

    public final void setExt9(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.ext9 = str;
    }

    public final void setIndex(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.index = str;
    }

    public final void setJsonExt(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.jsonExt = str;
    }

    public final void setLiveAppid(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.liveAppid = str;
    }

    public final void setRetCode(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.retCode = str;
    }

    public final void setRoomId(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.ext3 = str;
    }

    public final void setRoomType(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.ext4 = str;
    }

    public final void setTraceId(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.traceId = str;
    }

    public final void setUid(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.ext2 = str;
    }

    @NotNull
    public final ArrayList<FeedCloudCommon$Entry> toEntry() {
        ArrayList<FeedCloudCommon$Entry> arrayList = new ArrayList<>();
        Companion companion = INSTANCE;
        arrayList.add(companion.newEntry("event_id", this.eventId));
        arrayList.add(companion.newEntry("traceid", this.traceId));
        arrayList.add(companion.newEntry("ret_code", this.retCode));
        arrayList.add(companion.newEntry("desc_msg", this.desc));
        arrayList.add(companion.newEntry("attach_info", this.attachInfo));
        arrayList.add(companion.newEntry("index", this.index));
        arrayList.add(companion.newEntry(QQLiveReportConstants.AttaColumn.LIVE_APPID, this.liveAppid));
        arrayList.add(companion.newEntry("ext1", this.ext1));
        arrayList.add(companion.newEntry("ext2", this.ext2));
        arrayList.add(companion.newEntry("ext3", this.ext3));
        arrayList.add(companion.newEntry("ext4", this.ext4));
        arrayList.add(companion.newEntry("ext5", this.ext5));
        arrayList.add(companion.newEntry("ext6", this.ext6));
        arrayList.add(companion.newEntry("ext7", this.ext7));
        arrayList.add(companion.newEntry("ext8", this.ext8));
        arrayList.add(companion.newEntry("ext9", this.ext9));
        arrayList.add(companion.newEntry("ext10", this.ext10));
        arrayList.add(companion.newEntry("ext11", this.ext11));
        arrayList.add(companion.newEntry("ext12", this.ext12));
        arrayList.add(companion.newEntry("ext13", this.ext13));
        arrayList.add(companion.newEntry("ext14", this.ext14));
        arrayList.add(companion.newEntry("ext15", this.ext15));
        arrayList.add(companion.newEntry("ext16", this.ext16));
        arrayList.add(companion.newEntry("ext17", this.ext17));
        arrayList.add(companion.newEntry("ext18", this.ext18));
        arrayList.add(companion.newEntry(QQLiveReportConstants.AttaColumn.EXT19, this.ext19));
        arrayList.add(companion.newEntry(QQLiveReportConstants.AttaColumn.JSON_EXT, this.jsonExt));
        return arrayList;
    }

    @NotNull
    public final String toPrintString() {
        return "QQLiveQualityReportData(eventId='" + this.eventId + "', traceId='" + this.traceId + "', retCode='" + this.retCode + "', desc='" + this.desc + "', liveAppid='" + this.liveAppid + '\'';
    }

    @NotNull
    public String toString() {
        return "QQLiveQualityReportData(eventId='" + this.eventId + "', traceId='" + this.traceId + "', retCode='" + this.retCode + "', desc='" + this.desc + "', attachInfo='" + this.attachInfo + "', index='" + this.index + "', liveAppid='" + this.liveAppid + "', ext1='" + this.ext1 + "', ext2='" + this.ext2 + "', ext3='" + this.ext3 + "', ext4='" + this.ext4 + "', ext5='" + this.ext5 + "', ext6='" + this.ext6 + "', ext7='" + this.ext7 + "', ext8='" + this.ext8 + "', ext9='" + this.ext9 + "', ext10='" + this.ext10 + "', ext11='" + this.ext11 + "', ext12='" + this.ext12 + "', ext13='" + this.ext13 + "', ext14='" + this.ext14 + "', ext15='" + this.ext15 + "', ext16='" + this.ext16 + "', ext17='" + this.ext17 + "', ext18='" + this.ext18 + "', ext19='" + this.ext19 + "', jsonExt='" + this.jsonExt + "')";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.eventId);
        parcel.writeString(this.traceId);
        parcel.writeString(this.retCode);
        parcel.writeString(this.desc);
        parcel.writeString(this.attachInfo);
        parcel.writeString(this.index);
        parcel.writeString(this.liveAppid);
        parcel.writeString(this.ext1);
        parcel.writeString(this.ext2);
        parcel.writeString(this.ext3);
        parcel.writeString(this.ext4);
        parcel.writeString(this.ext5);
        parcel.writeString(this.ext6);
        parcel.writeString(this.ext7);
        parcel.writeString(this.ext8);
        parcel.writeString(this.ext9);
        parcel.writeString(this.ext10);
        parcel.writeString(this.ext11);
        parcel.writeString(this.ext12);
        parcel.writeString(this.ext13);
        parcel.writeString(this.ext14);
        parcel.writeString(this.ext15);
        parcel.writeString(this.ext16);
        parcel.writeString(this.ext17);
        parcel.writeString(this.ext18);
        parcel.writeString(this.ext19);
        parcel.writeString(this.jsonExt);
    }

    public QQLiveQualityReportData(@NotNull String eventId, @NotNull String traceId, @NotNull String retCode, @NotNull String desc, @NotNull String attachInfo, @NotNull String index, @NotNull String liveAppid, @NotNull String cost, @NotNull String uid, @NotNull String roomId, @NotNull String roomType, @NotNull String ext5, @NotNull String ext6, @NotNull String ext7, @NotNull String ext8, @NotNull String ext9, @NotNull String ext10, @NotNull String ext11, @NotNull String ext12, @NotNull String ext13, @NotNull String ext14, @NotNull String ext15, @NotNull String ext16, @NotNull String ext17, @NotNull String ext18, @NotNull String ext19, @NotNull String jsonExt) {
        Intrinsics.checkNotNullParameter(eventId, "eventId");
        Intrinsics.checkNotNullParameter(traceId, "traceId");
        Intrinsics.checkNotNullParameter(retCode, "retCode");
        Intrinsics.checkNotNullParameter(desc, "desc");
        Intrinsics.checkNotNullParameter(attachInfo, "attachInfo");
        Intrinsics.checkNotNullParameter(index, "index");
        Intrinsics.checkNotNullParameter(liveAppid, "liveAppid");
        Intrinsics.checkNotNullParameter(cost, "cost");
        Intrinsics.checkNotNullParameter(uid, "uid");
        Intrinsics.checkNotNullParameter(roomId, "roomId");
        Intrinsics.checkNotNullParameter(roomType, "roomType");
        Intrinsics.checkNotNullParameter(ext5, "ext5");
        Intrinsics.checkNotNullParameter(ext6, "ext6");
        Intrinsics.checkNotNullParameter(ext7, "ext7");
        Intrinsics.checkNotNullParameter(ext8, "ext8");
        Intrinsics.checkNotNullParameter(ext9, "ext9");
        Intrinsics.checkNotNullParameter(ext10, "ext10");
        Intrinsics.checkNotNullParameter(ext11, "ext11");
        Intrinsics.checkNotNullParameter(ext12, "ext12");
        Intrinsics.checkNotNullParameter(ext13, "ext13");
        Intrinsics.checkNotNullParameter(ext14, "ext14");
        Intrinsics.checkNotNullParameter(ext15, "ext15");
        Intrinsics.checkNotNullParameter(ext16, "ext16");
        Intrinsics.checkNotNullParameter(ext17, "ext17");
        Intrinsics.checkNotNullParameter(ext18, "ext18");
        Intrinsics.checkNotNullParameter(ext19, "ext19");
        Intrinsics.checkNotNullParameter(jsonExt, "jsonExt");
        this.eventId = eventId;
        this.traceId = traceId;
        this.retCode = retCode;
        this.desc = desc;
        this.attachInfo = attachInfo;
        this.index = index;
        this.liveAppid = liveAppid;
        this.ext1 = cost;
        this.ext2 = uid;
        this.ext3 = roomId;
        this.ext4 = roomType;
        this.ext5 = ext5;
        this.ext6 = ext6;
        this.ext7 = ext7;
        this.ext8 = ext8;
        this.ext9 = ext9;
        this.ext10 = ext10;
        this.ext11 = ext11;
        this.ext12 = ext12;
        this.ext13 = ext13;
        this.ext14 = ext14;
        this.ext15 = ext15;
        this.ext16 = ext16;
        this.ext17 = ext17;
        this.ext18 = ext18;
        this.ext19 = ext19;
        this.jsonExt = jsonExt;
    }

    public /* synthetic */ QQLiveQualityReportData(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, String str16, String str17, String str18, String str19, String str20, String str21, String str22, String str23, String str24, String str25, String str26, String str27, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? "" : str, (i3 & 2) != 0 ? "" : str2, (i3 & 4) != 0 ? "" : str3, (i3 & 8) != 0 ? "" : str4, (i3 & 16) != 0 ? "" : str5, (i3 & 32) != 0 ? "" : str6, (i3 & 64) != 0 ? "" : str7, (i3 & 128) != 0 ? "" : str8, (i3 & 256) != 0 ? "" : str9, (i3 & 512) != 0 ? "" : str10, (i3 & 1024) != 0 ? "" : str11, (i3 & 2048) != 0 ? "" : str12, (i3 & 4096) != 0 ? "" : str13, (i3 & 8192) != 0 ? "" : str14, (i3 & 16384) != 0 ? "" : str15, (i3 & 32768) != 0 ? "" : str16, (i3 & 65536) != 0 ? "" : str17, (i3 & 131072) != 0 ? "" : str18, (i3 & 262144) != 0 ? "" : str19, (i3 & 524288) != 0 ? "" : str20, (i3 & 1048576) != 0 ? "" : str21, (i3 & 2097152) != 0 ? "" : str22, (i3 & 4194304) != 0 ? "" : str23, (i3 & 8388608) != 0 ? "" : str24, (i3 & 16777216) != 0 ? "" : str25, (i3 & 33554432) != 0 ? "" : str26, (i3 & 67108864) != 0 ? "" : str27);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public QQLiveQualityReportData(@NotNull Parcel parcel) {
        this(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r0 == null ? "" : r0);
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        String readString = parcel.readString();
        String str = readString == null ? "" : readString;
        String readString2 = parcel.readString();
        String str2 = readString2 == null ? "" : readString2;
        String readString3 = parcel.readString();
        String str3 = readString3 == null ? "" : readString3;
        String readString4 = parcel.readString();
        String str4 = readString4 == null ? "" : readString4;
        String readString5 = parcel.readString();
        String str5 = readString5 == null ? "" : readString5;
        String readString6 = parcel.readString();
        String str6 = readString6 == null ? "" : readString6;
        String readString7 = parcel.readString();
        String str7 = readString7 == null ? "" : readString7;
        String readString8 = parcel.readString();
        String str8 = readString8 == null ? "" : readString8;
        String readString9 = parcel.readString();
        String str9 = readString9 == null ? "" : readString9;
        String readString10 = parcel.readString();
        String str10 = readString10 == null ? "" : readString10;
        String readString11 = parcel.readString();
        String str11 = readString11 == null ? "" : readString11;
        String readString12 = parcel.readString();
        String str12 = readString12 == null ? "" : readString12;
        String readString13 = parcel.readString();
        String str13 = readString13 == null ? "" : readString13;
        String readString14 = parcel.readString();
        String str14 = readString14 == null ? "" : readString14;
        String readString15 = parcel.readString();
        String str15 = readString15 == null ? "" : readString15;
        String readString16 = parcel.readString();
        String str16 = readString16 == null ? "" : readString16;
        String readString17 = parcel.readString();
        String str17 = readString17 == null ? "" : readString17;
        String readString18 = parcel.readString();
        String str18 = readString18 == null ? "" : readString18;
        String readString19 = parcel.readString();
        String str19 = readString19 == null ? "" : readString19;
        String readString20 = parcel.readString();
        String str20 = readString20 == null ? "" : readString20;
        String readString21 = parcel.readString();
        String str21 = readString21 == null ? "" : readString21;
        String readString22 = parcel.readString();
        String str22 = readString22 == null ? "" : readString22;
        String readString23 = parcel.readString();
        String str23 = readString23 == null ? "" : readString23;
        String readString24 = parcel.readString();
        String str24 = readString24 == null ? "" : readString24;
        String readString25 = parcel.readString();
        String str25 = readString25 == null ? "" : readString25;
        String readString26 = parcel.readString();
        String str26 = readString26 == null ? "" : readString26;
        String readString27 = parcel.readString();
    }
}
