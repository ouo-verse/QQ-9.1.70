package com.tencent.mobileqq.qqvideoedit.thirdparty.videocut.model;

import android.os.Parcelable;
import com.squareup.wire.AndroidMessage;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireField;
import com.squareup.wire.internal.Internal;
import com.tencent.autotemplate.utils.JsonUtils;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.luggage.wxa.c8.c;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import okio.ByteString;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0012\u0018\u0000 ;2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002<=B\u00a9\u0002\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u000f\u0012\u000e\b\u0002\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013\u0012\u0014\b\u0002\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00170\u0016\u0012\u0014\b\u0002\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00190\u0016\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001b\u0012\u0014\b\u0002\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u001d0\u0016\u0012\u0014\b\u0002\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u001f0\u0016\u0012\u0014\b\u0002\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020!0\u0016\u0012\n\b\u0002\u0010$\u001a\u0004\u0018\u00010#\u0012\u0014\b\u0002\u0010&\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020%0\u0016\u0012\n\b\u0002\u0010(\u001a\u0004\u0018\u00010'\u0012\n\b\u0002\u0010*\u001a\u0004\u0018\u00010)\u0012\n\b\u0002\u0010+\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010-\u001a\u00020,\u00a2\u0006\u0004\b9\u0010:J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0013\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0096\u0002J\b\u0010\t\u001a\u00020\bH\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016J\u00af\u0002\u0010.\u001a\u00020\u00002\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u000f2\u000e\b\u0002\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u00132\u0014\b\u0002\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00170\u00162\u0014\b\u0002\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00190\u00162\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\u0014\b\u0002\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u001d0\u00162\u0014\b\u0002\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u001f0\u00162\u0014\b\u0002\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020!0\u00162\n\b\u0002\u0010$\u001a\u0004\u0018\u00010#2\u0014\b\u0002\u0010&\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020%0\u00162\n\b\u0002\u0010(\u001a\u0004\u0018\u00010'2\n\b\u0002\u0010*\u001a\u0004\u0018\u00010)2\n\b\u0002\u0010+\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010-\u001a\u00020,\u00a2\u0006\u0004\b.\u0010/R\u0016\u0010\f\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\f\u00100R\u0016\u0010\r\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\r\u00100R\u0016\u0010\u000e\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u00100R\u0016\u0010\u0010\u001a\u0004\u0018\u00010\u000f8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u00101R\u0016\u0010\u0011\u001a\u0004\u0018\u00010\u000f8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u00101R\u0016\u0010\u0012\u001a\u0004\u0018\u00010\u000f8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u00101R\u001a\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u00138\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u00102R \u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00170\u00168\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0018\u00103R \u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00190\u00168\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u001a\u00103R\u0016\u0010\u001c\u001a\u0004\u0018\u00010\u001b8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u001c\u00104R \u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u001d0\u00168\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u001e\u00103R \u0010 \u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u001f0\u00168\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b \u00103R \u0010\"\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020!0\u00168\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\"\u00103R\u0016\u0010$\u001a\u0004\u0018\u00010#8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b$\u00105R \u0010&\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020%0\u00168\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b&\u00103R\u0016\u0010(\u001a\u0004\u0018\u00010'8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b(\u00106R\u0016\u0010*\u001a\u0004\u0018\u00010)8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b*\u00107R\u0016\u0010+\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b+\u00108\u00a8\u0006>"}, d2 = {"Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/MediaModel;", "Lcom/squareup/wire/AndroidMessage;", "Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/MediaModel$a;", "newBuilder", "", "other", "", "equals", "", "hashCode", "", "toString", "id", "name", "version", "", WadlProxyConsts.CREATE_TIME, "updateTime", "duration", "", "Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/MediaClip;", "videos", "", "Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/AudioModel;", "audios", "Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/StickerModel;", c.B, "Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/BackgroundModel;", "backgroundModel", "Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/FilterModel;", "filterModels", "Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/SpecialEffectModel;", "specialEffects", "Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/TransitionModel;", JsonUtils.KEY_TRANSITIONS, "Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/TemplateModel;", "templateModel", "Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/PipModel;", "pips", "Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/CoverInfo;", "coverInfo", "Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/ExportSettingModel;", "exportSetting", "openHDR", "Lokio/ByteString;", "unknownFields", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/util/List;Ljava/util/Map;Ljava/util/Map;Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/BackgroundModel;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/TemplateModel;Ljava/util/Map;Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/CoverInfo;Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/ExportSettingModel;Ljava/lang/Boolean;Lokio/ByteString;)Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/MediaModel;", "Ljava/lang/String;", "Ljava/lang/Long;", "Ljava/util/List;", "Ljava/util/Map;", "Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/BackgroundModel;", "Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/TemplateModel;", "Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/CoverInfo;", "Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/ExportSettingModel;", "Ljava/lang/Boolean;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/util/List;Ljava/util/Map;Ljava/util/Map;Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/BackgroundModel;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/TemplateModel;Ljava/util/Map;Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/CoverInfo;Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/ExportSettingModel;Ljava/lang/Boolean;Lokio/ByteString;)V", "Companion", "a", "c", "qqvideoedit_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class MediaModel extends AndroidMessage<MediaModel, a> {

    @JvmField
    @NotNull
    public static final ProtoAdapter<MediaModel> ADAPTER;

    @JvmField
    @NotNull
    public static final Parcelable.Creator<MediaModel> CREATOR;

    @WireField(adapter = "com.tencent.mobileqq.qqvideoedit.thirdparty.videocut.model.AudioModel#ADAPTER", keyAdapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 1002)
    @JvmField
    @NotNull
    public final Map<String, AudioModel> audios;

    @WireField(adapter = "com.tencent.mobileqq.qqvideoedit.thirdparty.videocut.model.BackgroundModel#ADAPTER", tag = 2002)
    @JvmField
    @Nullable
    public final BackgroundModel backgroundModel;

    @WireField(adapter = "com.tencent.mobileqq.qqvideoedit.thirdparty.videocut.model.CoverInfo#ADAPTER", tag = 3001)
    @JvmField
    @Nullable
    public final CoverInfo coverInfo;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT64", tag = 4)
    @JvmField
    @Nullable
    public final Long createTime;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT64", tag = 6)
    @JvmField
    @Nullable
    public final Long duration;

    @WireField(adapter = "com.tencent.mobileqq.qqvideoedit.thirdparty.videocut.model.ExportSettingModel#ADAPTER", tag = 4001)
    @JvmField
    @Nullable
    public final ExportSettingModel exportSetting;

    @WireField(adapter = "com.tencent.mobileqq.qqvideoedit.thirdparty.videocut.model.FilterModel#ADAPTER", keyAdapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 2003)
    @JvmField
    @NotNull
    public final Map<String, FilterModel> filterModels;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 1)
    @JvmField
    @Nullable
    public final String id;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 2)
    @JvmField
    @Nullable
    public final String name;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BOOL", tag = 4002)
    @JvmField
    @Nullable
    public final Boolean openHDR;

    @WireField(adapter = "com.tencent.mobileqq.qqvideoedit.thirdparty.videocut.model.PipModel#ADAPTER", keyAdapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 2007)
    @JvmField
    @NotNull
    public final Map<String, PipModel> pips;

    @WireField(adapter = "com.tencent.mobileqq.qqvideoedit.thirdparty.videocut.model.SpecialEffectModel#ADAPTER", keyAdapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 2004)
    @JvmField
    @NotNull
    public final Map<String, SpecialEffectModel> specialEffects;

    @WireField(adapter = "com.tencent.mobileqq.qqvideoedit.thirdparty.videocut.model.StickerModel#ADAPTER", keyAdapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 2001)
    @JvmField
    @NotNull
    public final Map<String, StickerModel> stickers;

    @WireField(adapter = "com.tencent.mobileqq.qqvideoedit.thirdparty.videocut.model.TemplateModel#ADAPTER", tag = 2006)
    @JvmField
    @Nullable
    public final TemplateModel templateModel;

    @WireField(adapter = "com.tencent.mobileqq.qqvideoedit.thirdparty.videocut.model.TransitionModel#ADAPTER", keyAdapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 2005)
    @JvmField
    @NotNull
    public final Map<String, TransitionModel> transitions;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT64", tag = 5)
    @JvmField
    @Nullable
    public final Long updateTime;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 3)
    @JvmField
    @Nullable
    public final String version;

    @WireField(adapter = "com.tencent.mobileqq.qqvideoedit.thirdparty.videocut.model.MediaClip#ADAPTER", label = WireField.Label.REPEATED, tag = 1001)
    @JvmField
    @NotNull
    public final List<MediaClip> videos;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\u00a2\u0006\u0004\b@\u0010AJ\b\u0010\u0003\u001a\u00020\u0002H\u0016R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0005R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0005R\u0018\u0010\n\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0005R\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\rR\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\rR\u001c\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00140\u00138\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\"\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00190\u00188\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\"\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u001d0\u00188\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001bR\u0018\u0010#\u001a\u0004\u0018\u00010 8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\"\u0010&\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020$0\u00188\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b%\u0010\u001bR\"\u0010)\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020'0\u00188\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b(\u0010\u001bR\"\u0010,\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020*0\u00188\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b+\u0010\u001bR\u0018\u00100\u001a\u0004\u0018\u00010-8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b.\u0010/R\"\u00103\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u0002010\u00188\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b2\u0010\u001bR\u0018\u00107\u001a\u0004\u0018\u0001048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b5\u00106R\u0018\u0010;\u001a\u0004\u0018\u0001088\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b9\u0010:R\u0018\u0010?\u001a\u0004\u0018\u00010<8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b=\u0010>\u00a8\u0006B"}, d2 = {"Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/MediaModel$a;", "Lcom/squareup/wire/Message$Builder;", "Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/MediaModel;", "a", "", "Ljava/lang/String;", "id", "b", "name", "c", "version", "", "d", "Ljava/lang/Long;", WadlProxyConsts.CREATE_TIME, "e", "updateTime", "f", "duration", "", "Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/MediaClip;", "g", "Ljava/util/List;", "videos", "", "Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/AudioModel;", h.F, "Ljava/util/Map;", "audios", "Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/StickerModel;", "i", c.B, "Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/BackgroundModel;", "j", "Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/BackgroundModel;", "backgroundModel", "Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/FilterModel;", "k", "filterModels", "Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/SpecialEffectModel;", "l", "specialEffects", "Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/TransitionModel;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, JsonUtils.KEY_TRANSITIONS, "Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/TemplateModel;", DomainData.DOMAIN_NAME, "Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/TemplateModel;", "templateModel", "Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/PipModel;", "o", "pips", "Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/CoverInfo;", "p", "Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/CoverInfo;", "coverInfo", "Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/ExportSettingModel;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/ExportSettingModel;", "exportSetting", "", "r", "Ljava/lang/Boolean;", "openHDR", "<init>", "()V", "qqvideoedit_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes17.dex */
    public static final class a extends Message.Builder<MediaModel, a> {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @JvmField
        @Nullable
        public String id;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        @JvmField
        @Nullable
        public String name;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        @JvmField
        @Nullable
        public String version;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @JvmField
        @Nullable
        public Long createTime;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        @JvmField
        @Nullable
        public Long updateTime;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        @JvmField
        @Nullable
        public Long duration;

        /* renamed from: g, reason: collision with root package name and from kotlin metadata */
        @JvmField
        @NotNull
        public List<MediaClip> videos;

        /* renamed from: h, reason: collision with root package name and from kotlin metadata */
        @JvmField
        @NotNull
        public Map<String, AudioModel> audios;

        /* renamed from: i, reason: collision with root package name and from kotlin metadata */
        @JvmField
        @NotNull
        public Map<String, ? extends StickerModel> stickers;

        /* renamed from: j, reason: collision with root package name and from kotlin metadata */
        @JvmField
        @Nullable
        public BackgroundModel backgroundModel;

        /* renamed from: k, reason: collision with root package name and from kotlin metadata */
        @JvmField
        @NotNull
        public Map<String, FilterModel> filterModels;

        /* renamed from: l, reason: collision with root package name and from kotlin metadata */
        @JvmField
        @NotNull
        public Map<String, SpecialEffectModel> specialEffects;

        /* renamed from: m, reason: collision with root package name and from kotlin metadata */
        @JvmField
        @NotNull
        public Map<String, TransitionModel> transitions;

        /* renamed from: n, reason: collision with root package name and from kotlin metadata */
        @JvmField
        @Nullable
        public TemplateModel templateModel;

        /* renamed from: o, reason: collision with root package name and from kotlin metadata */
        @JvmField
        @NotNull
        public Map<String, PipModel> pips;

        /* renamed from: p, reason: collision with root package name and from kotlin metadata */
        @JvmField
        @Nullable
        public CoverInfo coverInfo;

        /* renamed from: q, reason: collision with root package name and from kotlin metadata */
        @JvmField
        @Nullable
        public ExportSettingModel exportSetting;

        /* renamed from: r, reason: collision with root package name and from kotlin metadata */
        @JvmField
        @Nullable
        public Boolean openHDR;

        public a() {
            List<MediaClip> emptyList;
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            this.videos = emptyList;
            this.audios = MapsKt.emptyMap();
            this.stickers = MapsKt.emptyMap();
            this.filterModels = MapsKt.emptyMap();
            this.specialEffects = MapsKt.emptyMap();
            this.transitions = MapsKt.emptyMap();
            this.pips = MapsKt.emptyMap();
            this.openHDR = Boolean.FALSE;
        }

        @Override // com.squareup.wire.Message.Builder
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public MediaModel build() {
            return new MediaModel(this.id, this.name, this.version, this.createTime, this.updateTime, this.duration, this.videos, this.audios, this.stickers, this.backgroundModel, this.filterModels, this.specialEffects, this.transitions, this.templateModel, this.pips, this.coverInfo, this.exportSetting, this.openHDR, buildUnknownFields());
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000[\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\f\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u0010\u0010\r\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R&\u0010\u0012\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00100\u000e0\u00018\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\u0011R&\u0010\u0014\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00130\u000e0\u00018\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0011R&\u0010\u0016\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00150\u000e0\u00018\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0011R&\u0010\u0018\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00170\u000e0\u00018\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u0011R&\u0010\u001b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00190\u000e0\u00018\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u0011R&\u0010\u001e\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u001c0\u000e0\u00018\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u0011\u00a8\u0006\u001f"}, d2 = {"com/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/MediaModel$b", "Lcom/squareup/wire/ProtoAdapter;", "Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/MediaModel;", "value", "", "c", "Lcom/squareup/wire/ProtoWriter;", "writer", "", "b", "Lcom/squareup/wire/ProtoReader;", "reader", "a", "d", "", "", "Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/AudioModel;", "Lcom/squareup/wire/ProtoAdapter;", "audiosAdapter", "Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/StickerModel;", "stickersAdapter", "Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/FilterModel;", "filterModelsAdapter", "Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/SpecialEffectModel;", "specialEffectsAdapter", "Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/TransitionModel;", "e", "transitionsAdapter", "Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/PipModel;", "f", "pipsAdapter", "qqvideoedit_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes17.dex */
    public static final class b extends ProtoAdapter<MediaModel> {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final ProtoAdapter<Map<String, AudioModel>> audiosAdapter;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final ProtoAdapter<Map<String, StickerModel>> stickersAdapter;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final ProtoAdapter<Map<String, FilterModel>> filterModelsAdapter;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final ProtoAdapter<Map<String, SpecialEffectModel>> specialEffectsAdapter;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final ProtoAdapter<Map<String, TransitionModel>> transitionsAdapter;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final ProtoAdapter<Map<String, PipModel>> pipsAdapter;

        b(FieldEncoding fieldEncoding, KClass<MediaModel> kClass) {
            super(fieldEncoding, kClass, "type.googleapis.com/publisher.MediaModel");
            ProtoAdapter.Companion companion = ProtoAdapter.INSTANCE;
            ProtoAdapter<String> protoAdapter = ProtoAdapter.STRING;
            this.audiosAdapter = companion.newMapAdapter(protoAdapter, AudioModel.ADAPTER);
            this.stickersAdapter = companion.newMapAdapter(protoAdapter, StickerModel.ADAPTER);
            this.filterModelsAdapter = companion.newMapAdapter(protoAdapter, FilterModel.ADAPTER);
            this.specialEffectsAdapter = companion.newMapAdapter(protoAdapter, SpecialEffectModel.ADAPTER);
            this.transitionsAdapter = companion.newMapAdapter(protoAdapter, TransitionModel.ADAPTER);
            this.pipsAdapter = companion.newMapAdapter(protoAdapter, PipModel.ADAPTER);
        }

        @Override // com.squareup.wire.ProtoAdapter
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public MediaModel decode(@NotNull ProtoReader reader) {
            Intrinsics.checkNotNullParameter(reader, "reader");
            ArrayList arrayList = new ArrayList();
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            LinkedHashMap linkedHashMap2 = new LinkedHashMap();
            LinkedHashMap linkedHashMap3 = new LinkedHashMap();
            LinkedHashMap linkedHashMap4 = new LinkedHashMap();
            LinkedHashMap linkedHashMap5 = new LinkedHashMap();
            LinkedHashMap linkedHashMap6 = new LinkedHashMap();
            long beginMessage = reader.beginMessage();
            String str = null;
            String str2 = null;
            String str3 = null;
            Long l3 = null;
            Long l16 = null;
            BackgroundModel backgroundModel = null;
            TemplateModel templateModel = null;
            CoverInfo coverInfo = null;
            ExportSettingModel exportSettingModel = null;
            Long l17 = null;
            while (true) {
                int nextTag = reader.nextTag();
                Long l18 = l3;
                if (nextTag != -1) {
                    if (nextTag != 1001) {
                        if (nextTag != 1002) {
                            if (nextTag != 3001) {
                                if (nextTag != 4001) {
                                    switch (nextTag) {
                                        case 1:
                                            str = ProtoAdapter.STRING.decode(reader);
                                            break;
                                        case 2:
                                            str2 = ProtoAdapter.STRING.decode(reader);
                                            break;
                                        case 3:
                                            str3 = ProtoAdapter.STRING.decode(reader);
                                            break;
                                        case 4:
                                            l3 = ProtoAdapter.INT64.decode(reader);
                                            continue;
                                        case 5:
                                            l17 = ProtoAdapter.INT64.decode(reader);
                                            break;
                                        case 6:
                                            l16 = ProtoAdapter.INT64.decode(reader);
                                            break;
                                        default:
                                            switch (nextTag) {
                                                case 2001:
                                                    linkedHashMap2.putAll(this.stickersAdapter.decode(reader));
                                                    break;
                                                case 2002:
                                                    backgroundModel = BackgroundModel.ADAPTER.decode(reader);
                                                    break;
                                                case 2003:
                                                    linkedHashMap3.putAll(this.filterModelsAdapter.decode(reader));
                                                    break;
                                                case 2004:
                                                    linkedHashMap4.putAll(this.specialEffectsAdapter.decode(reader));
                                                    break;
                                                case 2005:
                                                    linkedHashMap5.putAll(this.transitionsAdapter.decode(reader));
                                                    break;
                                                case 2006:
                                                    templateModel = TemplateModel.ADAPTER.decode(reader);
                                                    break;
                                                case 2007:
                                                    linkedHashMap6.putAll(this.pipsAdapter.decode(reader));
                                                    break;
                                                default:
                                                    reader.readUnknownField(nextTag);
                                                    break;
                                            }
                                    }
                                } else {
                                    exportSettingModel = ExportSettingModel.ADAPTER.decode(reader);
                                }
                            } else {
                                coverInfo = CoverInfo.ADAPTER.decode(reader);
                            }
                        } else {
                            linkedHashMap.putAll(this.audiosAdapter.decode(reader));
                        }
                    } else {
                        arrayList.add(MediaClip.ADAPTER.decode(reader));
                    }
                    l3 = l18;
                } else {
                    return new MediaModel(str, str2, str3, l18, l17, l16, arrayList, linkedHashMap, linkedHashMap2, backgroundModel, linkedHashMap3, linkedHashMap4, linkedHashMap5, templateModel, linkedHashMap6, coverInfo, exportSettingModel, null, reader.endMessageAndGetUnknownFields(beginMessage), 131072, null);
                }
            }
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void encode(@NotNull ProtoWriter writer, @NotNull MediaModel value) {
            Intrinsics.checkNotNullParameter(writer, "writer");
            Intrinsics.checkNotNullParameter(value, "value");
            ProtoAdapter<String> protoAdapter = ProtoAdapter.STRING;
            protoAdapter.encodeWithTag(writer, 1, value.id);
            protoAdapter.encodeWithTag(writer, 2, value.name);
            protoAdapter.encodeWithTag(writer, 3, value.version);
            ProtoAdapter<Long> protoAdapter2 = ProtoAdapter.INT64;
            protoAdapter2.encodeWithTag(writer, 4, value.createTime);
            protoAdapter2.encodeWithTag(writer, 5, value.updateTime);
            protoAdapter2.encodeWithTag(writer, 6, value.duration);
            MediaClip.ADAPTER.asRepeated().encodeWithTag(writer, 1001, value.videos);
            this.audiosAdapter.encodeWithTag(writer, 1002, value.audios);
            this.stickersAdapter.encodeWithTag(writer, 2001, value.stickers);
            BackgroundModel.ADAPTER.encodeWithTag(writer, 2002, value.backgroundModel);
            this.filterModelsAdapter.encodeWithTag(writer, 2003, value.filterModels);
            this.specialEffectsAdapter.encodeWithTag(writer, 2004, value.specialEffects);
            this.transitionsAdapter.encodeWithTag(writer, 2005, value.transitions);
            TemplateModel.ADAPTER.encodeWithTag(writer, 2006, value.templateModel);
            this.pipsAdapter.encodeWithTag(writer, 2007, value.pips);
            CoverInfo.ADAPTER.encodeWithTag(writer, 3001, value.coverInfo);
            ExportSettingModel.ADAPTER.encodeWithTag(writer, 4001, value.exportSetting);
            writer.writeBytes(value.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public int encodedSize(@NotNull MediaModel value) {
            Intrinsics.checkNotNullParameter(value, "value");
            ProtoAdapter<String> protoAdapter = ProtoAdapter.STRING;
            int encodedSizeWithTag = protoAdapter.encodedSizeWithTag(1, value.id) + protoAdapter.encodedSizeWithTag(2, value.name) + protoAdapter.encodedSizeWithTag(3, value.version);
            ProtoAdapter<Long> protoAdapter2 = ProtoAdapter.INT64;
            return encodedSizeWithTag + protoAdapter2.encodedSizeWithTag(4, value.createTime) + protoAdapter2.encodedSizeWithTag(5, value.updateTime) + protoAdapter2.encodedSizeWithTag(6, value.duration) + MediaClip.ADAPTER.asRepeated().encodedSizeWithTag(1001, value.videos) + this.audiosAdapter.encodedSizeWithTag(1002, value.audios) + this.stickersAdapter.encodedSizeWithTag(2001, value.stickers) + BackgroundModel.ADAPTER.encodedSizeWithTag(2002, value.backgroundModel) + this.filterModelsAdapter.encodedSizeWithTag(2003, value.filterModels) + this.specialEffectsAdapter.encodedSizeWithTag(2004, value.specialEffects) + this.transitionsAdapter.encodedSizeWithTag(2005, value.transitions) + TemplateModel.ADAPTER.encodedSizeWithTag(2006, value.templateModel) + this.pipsAdapter.encodedSizeWithTag(2007, value.pips) + CoverInfo.ADAPTER.encodedSizeWithTag(3001, value.coverInfo) + ExportSettingModel.ADAPTER.encodedSizeWithTag(4001, value.exportSetting) + value.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        @NotNull
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public MediaModel redact(@NotNull MediaModel value) {
            BackgroundModel backgroundModel;
            TemplateModel templateModel;
            CoverInfo coverInfo;
            ExportSettingModel exportSettingModel;
            Intrinsics.checkNotNullParameter(value, "value");
            List m87redactElements = Internal.m87redactElements(value.videos, MediaClip.ADAPTER);
            Map m88redactElements = Internal.m88redactElements(value.audios, AudioModel.ADAPTER);
            Map m88redactElements2 = Internal.m88redactElements(value.stickers, StickerModel.ADAPTER);
            BackgroundModel backgroundModel2 = value.backgroundModel;
            if (backgroundModel2 != null) {
                backgroundModel = BackgroundModel.ADAPTER.redact(backgroundModel2);
            } else {
                backgroundModel = null;
            }
            Map m88redactElements3 = Internal.m88redactElements(value.filterModels, FilterModel.ADAPTER);
            Map m88redactElements4 = Internal.m88redactElements(value.specialEffects, SpecialEffectModel.ADAPTER);
            Map m88redactElements5 = Internal.m88redactElements(value.transitions, TransitionModel.ADAPTER);
            TemplateModel templateModel2 = value.templateModel;
            if (templateModel2 != null) {
                templateModel = TemplateModel.ADAPTER.redact(templateModel2);
            } else {
                templateModel = null;
            }
            Map m88redactElements6 = Internal.m88redactElements(value.pips, PipModel.ADAPTER);
            CoverInfo coverInfo2 = value.coverInfo;
            if (coverInfo2 != null) {
                coverInfo = CoverInfo.ADAPTER.redact(coverInfo2);
            } else {
                coverInfo = null;
            }
            ExportSettingModel exportSettingModel2 = value.exportSetting;
            if (exportSettingModel2 != null) {
                exportSettingModel = ExportSettingModel.ADAPTER.redact(exportSettingModel2);
            } else {
                exportSettingModel = null;
            }
            return MediaModel.copy$default(value, null, null, null, null, null, null, m87redactElements, m88redactElements, m88redactElements2, backgroundModel, m88redactElements3, m88redactElements4, m88redactElements5, templateModel, m88redactElements6, coverInfo, exportSettingModel, null, ByteString.EMPTY, 131135, null);
        }
    }

    static {
        b bVar = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(MediaModel.class));
        ADAPTER = bVar;
        CREATOR = AndroidMessage.INSTANCE.newCreator(bVar);
    }

    public MediaModel() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 524287, null);
    }

    public static /* synthetic */ MediaModel copy$default(MediaModel mediaModel, String str, String str2, String str3, Long l3, Long l16, Long l17, List list, Map map, Map map2, BackgroundModel backgroundModel, Map map3, Map map4, Map map5, TemplateModel templateModel, Map map6, CoverInfo coverInfo, ExportSettingModel exportSettingModel, Boolean bool, ByteString byteString, int i3, Object obj) {
        return mediaModel.copy((i3 & 1) != 0 ? mediaModel.id : str, (i3 & 2) != 0 ? mediaModel.name : str2, (i3 & 4) != 0 ? mediaModel.version : str3, (i3 & 8) != 0 ? mediaModel.createTime : l3, (i3 & 16) != 0 ? mediaModel.updateTime : l16, (i3 & 32) != 0 ? mediaModel.duration : l17, (i3 & 64) != 0 ? mediaModel.videos : list, (i3 & 128) != 0 ? mediaModel.audios : map, (i3 & 256) != 0 ? mediaModel.stickers : map2, (i3 & 512) != 0 ? mediaModel.backgroundModel : backgroundModel, (i3 & 1024) != 0 ? mediaModel.filterModels : map3, (i3 & 2048) != 0 ? mediaModel.specialEffects : map4, (i3 & 4096) != 0 ? mediaModel.transitions : map5, (i3 & 8192) != 0 ? mediaModel.templateModel : templateModel, (i3 & 16384) != 0 ? mediaModel.pips : map6, (i3 & 32768) != 0 ? mediaModel.coverInfo : coverInfo, (i3 & 65536) != 0 ? mediaModel.exportSetting : exportSettingModel, (i3 & 131072) != 0 ? mediaModel.openHDR : bool, (i3 & 262144) != 0 ? mediaModel.unknownFields() : byteString);
    }

    @NotNull
    public final MediaModel copy(@Nullable String id5, @Nullable String name, @Nullable String version, @Nullable Long createTime, @Nullable Long updateTime, @Nullable Long duration, @NotNull List<MediaClip> videos, @NotNull Map<String, AudioModel> audios, @NotNull Map<String, ? extends StickerModel> stickers, @Nullable BackgroundModel backgroundModel, @NotNull Map<String, FilterModel> filterModels, @NotNull Map<String, SpecialEffectModel> specialEffects, @NotNull Map<String, TransitionModel> transitions, @Nullable TemplateModel templateModel, @NotNull Map<String, PipModel> pips, @Nullable CoverInfo coverInfo, @Nullable ExportSettingModel exportSetting, @Nullable Boolean openHDR, @NotNull ByteString unknownFields) {
        Intrinsics.checkNotNullParameter(videos, "videos");
        Intrinsics.checkNotNullParameter(audios, "audios");
        Intrinsics.checkNotNullParameter(stickers, "stickers");
        Intrinsics.checkNotNullParameter(filterModels, "filterModels");
        Intrinsics.checkNotNullParameter(specialEffects, "specialEffects");
        Intrinsics.checkNotNullParameter(transitions, "transitions");
        Intrinsics.checkNotNullParameter(pips, "pips");
        Intrinsics.checkNotNullParameter(unknownFields, "unknownFields");
        return new MediaModel(id5, name, version, createTime, updateTime, duration, Internal.immutableCopyOf("videos", videos), new LinkedHashMap(audios), new LinkedHashMap(stickers), backgroundModel, new LinkedHashMap(filterModels), new LinkedHashMap(specialEffects), new LinkedHashMap(transitions), templateModel, new LinkedHashMap(pips), coverInfo, exportSetting, openHDR, unknownFields);
    }

    public boolean equals(@Nullable Object other) {
        if (other == this) {
            return true;
        }
        if (!(other instanceof MediaModel)) {
            return false;
        }
        MediaModel mediaModel = (MediaModel) other;
        if (Intrinsics.areEqual(unknownFields(), mediaModel.unknownFields()) && Intrinsics.areEqual(this.id, mediaModel.id) && Intrinsics.areEqual(this.name, mediaModel.name) && Intrinsics.areEqual(this.version, mediaModel.version) && Intrinsics.areEqual(this.createTime, mediaModel.createTime) && Intrinsics.areEqual(this.updateTime, mediaModel.updateTime) && Intrinsics.areEqual(this.duration, mediaModel.duration) && Intrinsics.areEqual(this.videos, mediaModel.videos) && Intrinsics.areEqual(this.audios, mediaModel.audios) && Intrinsics.areEqual(this.stickers, mediaModel.stickers) && Intrinsics.areEqual(this.backgroundModel, mediaModel.backgroundModel) && Intrinsics.areEqual(this.filterModels, mediaModel.filterModels) && Intrinsics.areEqual(this.specialEffects, mediaModel.specialEffects) && Intrinsics.areEqual(this.transitions, mediaModel.transitions) && Intrinsics.areEqual(this.templateModel, mediaModel.templateModel) && Intrinsics.areEqual(this.pips, mediaModel.pips) && Intrinsics.areEqual(this.coverInfo, mediaModel.coverInfo) && Intrinsics.areEqual(this.exportSetting, mediaModel.exportSetting) && Intrinsics.areEqual(this.openHDR, mediaModel.openHDR)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i3;
        int i16;
        int i17;
        int i18;
        int i19;
        int i26;
        int i27;
        int i28;
        int i29;
        int i36;
        int i37 = this.hashCode;
        if (i37 == 0) {
            int hashCode = unknownFields().hashCode() * 37;
            String str = this.id;
            int i38 = 0;
            if (str != null) {
                i3 = str.hashCode();
            } else {
                i3 = 0;
            }
            int i39 = (hashCode + i3) * 37;
            String str2 = this.name;
            if (str2 != null) {
                i16 = str2.hashCode();
            } else {
                i16 = 0;
            }
            int i46 = (i39 + i16) * 37;
            String str3 = this.version;
            if (str3 != null) {
                i17 = str3.hashCode();
            } else {
                i17 = 0;
            }
            int i47 = (i46 + i17) * 37;
            Long l3 = this.createTime;
            if (l3 != null) {
                i18 = l3.hashCode();
            } else {
                i18 = 0;
            }
            int i48 = (i47 + i18) * 37;
            Long l16 = this.updateTime;
            if (l16 != null) {
                i19 = l16.hashCode();
            } else {
                i19 = 0;
            }
            int i49 = (i48 + i19) * 37;
            Long l17 = this.duration;
            if (l17 != null) {
                i26 = l17.hashCode();
            } else {
                i26 = 0;
            }
            int hashCode2 = (((((((i49 + i26) * 37) + this.videos.hashCode()) * 37) + this.audios.hashCode()) * 37) + this.stickers.hashCode()) * 37;
            BackgroundModel backgroundModel = this.backgroundModel;
            if (backgroundModel != null) {
                i27 = backgroundModel.hashCode();
            } else {
                i27 = 0;
            }
            int hashCode3 = (((((((hashCode2 + i27) * 37) + this.filterModels.hashCode()) * 37) + this.specialEffects.hashCode()) * 37) + this.transitions.hashCode()) * 37;
            TemplateModel templateModel = this.templateModel;
            if (templateModel != null) {
                i28 = templateModel.hashCode();
            } else {
                i28 = 0;
            }
            int hashCode4 = (((hashCode3 + i28) * 37) + this.pips.hashCode()) * 37;
            CoverInfo coverInfo = this.coverInfo;
            if (coverInfo != null) {
                i29 = coverInfo.hashCode();
            } else {
                i29 = 0;
            }
            int i56 = (hashCode4 + i29) * 37;
            ExportSettingModel exportSettingModel = this.exportSetting;
            if (exportSettingModel != null) {
                i36 = exportSettingModel.hashCode();
            } else {
                i36 = 0;
            }
            int i57 = (i56 + i36) * 37;
            Boolean bool = this.openHDR;
            if (bool != null) {
                i38 = bool.hashCode();
            }
            int i58 = i57 + i38;
            this.hashCode = i58;
            return i58;
        }
        return i37;
    }

    @Override // com.squareup.wire.Message
    @NotNull
    public String toString() {
        String joinToString$default;
        ArrayList arrayList = new ArrayList();
        String str = this.id;
        if (str != null) {
            arrayList.add("id=" + Internal.sanitize(str));
        }
        String str2 = this.name;
        if (str2 != null) {
            arrayList.add("name=" + Internal.sanitize(str2));
        }
        String str3 = this.version;
        if (str3 != null) {
            arrayList.add("version=" + Internal.sanitize(str3));
        }
        Long l3 = this.createTime;
        if (l3 != null) {
            arrayList.add("createTime=" + l3);
        }
        Long l16 = this.updateTime;
        if (l16 != null) {
            arrayList.add("updateTime=" + l16);
        }
        Long l17 = this.duration;
        if (l17 != null) {
            arrayList.add("duration=" + l17);
        }
        if (!this.videos.isEmpty()) {
            arrayList.add("videos=" + this.videos);
        }
        if (!this.audios.isEmpty()) {
            arrayList.add("audios=" + this.audios);
        }
        if (!this.stickers.isEmpty()) {
            arrayList.add("stickers=" + this.stickers);
        }
        BackgroundModel backgroundModel = this.backgroundModel;
        if (backgroundModel != null) {
            arrayList.add("backgroundModel=" + backgroundModel);
        }
        if (!this.filterModels.isEmpty()) {
            arrayList.add("filterModels=" + this.filterModels);
        }
        if (!this.specialEffects.isEmpty()) {
            arrayList.add("specialEffects=" + this.specialEffects);
        }
        if (!this.transitions.isEmpty()) {
            arrayList.add("transitions=" + this.transitions);
        }
        TemplateModel templateModel = this.templateModel;
        if (templateModel != null) {
            arrayList.add("templateModel=" + templateModel);
        }
        if (!this.pips.isEmpty()) {
            arrayList.add("pips=" + this.pips);
        }
        CoverInfo coverInfo = this.coverInfo;
        if (coverInfo != null) {
            arrayList.add("coverInfo=" + coverInfo);
        }
        ExportSettingModel exportSettingModel = this.exportSetting;
        if (exportSettingModel != null) {
            arrayList.add("exportSetting=" + exportSettingModel);
        }
        Boolean bool = this.openHDR;
        if (bool != null) {
            arrayList.add("openHDR=" + bool);
        }
        joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(arrayList, ", ", "MediaModel{", "}", 0, null, null, 56, null);
        return joinToString$default;
    }

    public /* synthetic */ MediaModel(String str, String str2, String str3, Long l3, Long l16, Long l17, List list, Map map, Map map2, BackgroundModel backgroundModel, Map map3, Map map4, Map map5, TemplateModel templateModel, Map map6, CoverInfo coverInfo, ExportSettingModel exportSettingModel, Boolean bool, ByteString byteString, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? null : str, (i3 & 2) != 0 ? null : str2, (i3 & 4) != 0 ? null : str3, (i3 & 8) != 0 ? null : l3, (i3 & 16) != 0 ? null : l16, (i3 & 32) != 0 ? null : l17, (i3 & 64) != 0 ? CollectionsKt__CollectionsKt.emptyList() : list, (i3 & 128) != 0 ? MapsKt.emptyMap() : map, (i3 & 256) != 0 ? MapsKt.emptyMap() : map2, (i3 & 512) != 0 ? null : backgroundModel, (i3 & 1024) != 0 ? MapsKt.emptyMap() : map3, (i3 & 2048) != 0 ? MapsKt.emptyMap() : map4, (i3 & 4096) != 0 ? MapsKt.emptyMap() : map5, (i3 & 8192) != 0 ? null : templateModel, (i3 & 16384) != 0 ? MapsKt.emptyMap() : map6, (i3 & 32768) != 0 ? null : coverInfo, (i3 & 65536) != 0 ? null : exportSettingModel, (i3 & 131072) != 0 ? Boolean.FALSE : bool, (i3 & 262144) != 0 ? ByteString.EMPTY : byteString);
    }

    @Override // com.squareup.wire.Message
    @NotNull
    public a newBuilder() {
        a aVar = new a();
        aVar.id = this.id;
        aVar.name = this.name;
        aVar.version = this.version;
        aVar.createTime = this.createTime;
        aVar.updateTime = this.updateTime;
        aVar.duration = this.duration;
        aVar.videos = this.videos;
        aVar.audios = this.audios;
        aVar.stickers = this.stickers;
        aVar.backgroundModel = this.backgroundModel;
        aVar.filterModels = this.filterModels;
        aVar.specialEffects = this.specialEffects;
        aVar.transitions = this.transitions;
        aVar.templateModel = this.templateModel;
        aVar.pips = this.pips;
        aVar.coverInfo = this.coverInfo;
        aVar.exportSetting = this.exportSetting;
        aVar.openHDR = this.openHDR;
        aVar.addUnknownFields(unknownFields());
        return aVar;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public MediaModel(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable Long l3, @Nullable Long l16, @Nullable Long l17, @NotNull List<MediaClip> videos, @NotNull Map<String, AudioModel> audios, @NotNull Map<String, ? extends StickerModel> stickers, @Nullable BackgroundModel backgroundModel, @NotNull Map<String, FilterModel> filterModels, @NotNull Map<String, SpecialEffectModel> specialEffects, @NotNull Map<String, TransitionModel> transitions, @Nullable TemplateModel templateModel, @NotNull Map<String, PipModel> pips, @Nullable CoverInfo coverInfo, @Nullable ExportSettingModel exportSettingModel, @Nullable Boolean bool, @NotNull ByteString unknownFields) {
        super(ADAPTER, unknownFields);
        Intrinsics.checkNotNullParameter(videos, "videos");
        Intrinsics.checkNotNullParameter(audios, "audios");
        Intrinsics.checkNotNullParameter(stickers, "stickers");
        Intrinsics.checkNotNullParameter(filterModels, "filterModels");
        Intrinsics.checkNotNullParameter(specialEffects, "specialEffects");
        Intrinsics.checkNotNullParameter(transitions, "transitions");
        Intrinsics.checkNotNullParameter(pips, "pips");
        Intrinsics.checkNotNullParameter(unknownFields, "unknownFields");
        this.id = str;
        this.name = str2;
        this.version = str3;
        this.createTime = l3;
        this.updateTime = l16;
        this.duration = l17;
        this.videos = videos;
        this.audios = audios;
        this.stickers = stickers;
        this.backgroundModel = backgroundModel;
        this.filterModels = filterModels;
        this.specialEffects = specialEffects;
        this.transitions = transitions;
        this.templateModel = templateModel;
        this.pips = pips;
        this.coverInfo = coverInfo;
        this.exportSetting = exportSettingModel;
        this.openHDR = bool;
    }
}
