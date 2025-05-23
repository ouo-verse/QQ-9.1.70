package com.tencent.videocut.model;

import android.os.Parcelable;
import androidx.annotation.Keep;
import com.gcore.abase.utils.PatternUtils;
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
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import okio.ByteString;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Keep
@Metadata(d1 = {"\u0000\u008c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u0007\u0018\u0000 72\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u000267B\u00c9\u0002\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\b\u0012\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f\u0012\u0014\b\u0002\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00100\u000f\u0012\u0014\b\u0002\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00120\u000f\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0014\u0012\u0014\b\u0002\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00160\u000f\u0012\u0014\b\u0002\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00180\u000f\u0012\u0014\b\u0002\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u001a0\u000f\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001c\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001e\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010 \u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\"\u0012\u0014\b\u0002\u0010#\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020$0\u000f\u0012\u0014\b\u0002\u0010%\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020&0\u000f\u0012\n\b\u0002\u0010'\u001a\u0004\u0018\u00010\"\u0012\b\b\u0002\u0010(\u001a\u00020)\u00a2\u0006\u0002\u0010*J\u00cf\u0002\u0010-\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\b2\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0014\b\u0002\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00100\u000f2\u0014\b\u0002\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00120\u000f2\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0014\b\u0002\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00160\u000f2\u0014\b\u0002\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00180\u000f2\u0014\b\u0002\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u001a0\u000f2\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010 2\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\"2\u0014\b\u0002\u0010#\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020$0\u000f2\u0014\b\u0002\u0010%\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020&0\u000f2\n\b\u0002\u0010'\u001a\u0004\u0018\u00010\"2\b\b\u0002\u0010(\u001a\u00020)\u00a2\u0006\u0002\u0010.J\u0013\u0010/\u001a\u00020\"2\b\u00100\u001a\u0004\u0018\u000101H\u0096\u0002J\b\u00102\u001a\u000203H\u0016J\b\u00104\u001a\u00020\u0002H\u0016J\b\u00105\u001a\u00020\u0004H\u0016R\u001c\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00100\u000f8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u0013\u001a\u0004\u0018\u00010\u00148\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u001d\u001a\u0004\u0018\u00010\u001e8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004\u00a2\u0006\u0004\n\u0002\u0010+R\u0014\u0010\n\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004\u00a2\u0006\u0004\n\u0002\u0010+R\u0012\u0010\u001f\u001a\u0004\u0018\u00010 8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00160\u000f8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010#\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020$0\u000f8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010!\u001a\u0004\u0018\u00010\"8\u0006X\u0087\u0004\u00a2\u0006\u0004\n\u0002\u0010,R\u0014\u0010'\u001a\u0004\u0018\u00010\"8\u0006X\u0087\u0004\u00a2\u0006\u0004\n\u0002\u0010,R\u001c\u0010%\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020&0\u000f8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00180\u000f8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00120\u000f8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u001b\u001a\u0004\u0018\u00010\u001c8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u001a0\u000f8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004\u00a2\u0006\u0004\n\u0002\u0010+R\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u00068"}, d2 = {"Lcom/tencent/videocut/model/MediaModel;", "Lcom/squareup/wire/AndroidMessage;", "Lcom/tencent/videocut/model/MediaModel$Builder;", "id", "", "name", "version", WadlProxyConsts.CREATE_TIME, "", "updateTime", "duration", "videos", "", "Lcom/tencent/videocut/model/MediaClip;", "audios", "", "Lcom/tencent/videocut/model/AudioModel;", c.B, "Lcom/tencent/videocut/model/StickerModel;", "backgroundModel", "Lcom/tencent/videocut/model/BackgroundModel;", "filterModels", "Lcom/tencent/videocut/model/FilterModel;", "specialEffects", "Lcom/tencent/videocut/model/SpecialEffectModel;", JsonUtils.KEY_TRANSITIONS, "Lcom/tencent/videocut/model/TransitionModel;", "templateModel", "Lcom/tencent/videocut/model/TemplateModel;", "coverInfo", "Lcom/tencent/videocut/model/CoverInfo;", "exportSetting", "Lcom/tencent/videocut/model/ExportSettingModel;", "openHDR", "", "hdrModels", "Lcom/tencent/videocut/model/HDRModel;", "smoothModels", "Lcom/tencent/videocut/model/SmoothModel;", "openSuperHDR", "unknownFields", "Lokio/ByteString;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/util/List;Ljava/util/Map;Ljava/util/Map;Lcom/tencent/videocut/model/BackgroundModel;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Lcom/tencent/videocut/model/TemplateModel;Lcom/tencent/videocut/model/CoverInfo;Lcom/tencent/videocut/model/ExportSettingModel;Ljava/lang/Boolean;Ljava/util/Map;Ljava/util/Map;Ljava/lang/Boolean;Lokio/ByteString;)V", "Ljava/lang/Long;", "Ljava/lang/Boolean;", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/util/List;Ljava/util/Map;Ljava/util/Map;Lcom/tencent/videocut/model/BackgroundModel;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Lcom/tencent/videocut/model/TemplateModel;Lcom/tencent/videocut/model/CoverInfo;Lcom/tencent/videocut/model/ExportSettingModel;Ljava/lang/Boolean;Ljava/util/Map;Ljava/util/Map;Ljava/lang/Boolean;Lokio/ByteString;)Lcom/tencent/videocut/model/MediaModel;", "equals", "other", "", "hashCode", "", "newBuilder", "toString", "Builder", "Companion", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes27.dex */
public final class MediaModel extends AndroidMessage<MediaModel, Builder> {
    static IPatchRedirector $redirector_ = null;

    @JvmField
    @NotNull
    public static final ProtoAdapter<MediaModel> ADAPTER;

    @JvmField
    @NotNull
    public static final Parcelable.Creator<MediaModel> CREATOR;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    @NotNull
    private static final MediaModel EMPTY;
    private static final long serialVersionUID = 1100201346713943993L;

    @WireField(adapter = "com.tencent.videocut.model.AudioModel#ADAPTER", keyAdapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 1002)
    @JvmField
    @NotNull
    public final Map<String, AudioModel> audios;

    @WireField(adapter = "com.tencent.videocut.model.BackgroundModel#ADAPTER", tag = 2002)
    @JvmField
    @Nullable
    public final BackgroundModel backgroundModel;

    @WireField(adapter = "com.tencent.videocut.model.CoverInfo#ADAPTER", tag = 3001)
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

    @WireField(adapter = "com.tencent.videocut.model.ExportSettingModel#ADAPTER", tag = 4001)
    @JvmField
    @Nullable
    public final ExportSettingModel exportSetting;

    @WireField(adapter = "com.tencent.videocut.model.FilterModel#ADAPTER", keyAdapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 2003)
    @JvmField
    @NotNull
    public final Map<String, FilterModel> filterModels;

    @WireField(adapter = "com.tencent.videocur.model.HDRModel#ADAPTER", keyAdapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 4003)
    @JvmField
    @NotNull
    public final Map<String, HDRModel> hdrModels;

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

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BOOL", tag = 4006)
    @JvmField
    @Nullable
    public final Boolean openSuperHDR;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BOOL", tag = 4004)
    @JvmField
    @NotNull
    public final Map<String, SmoothModel> smoothModels;

    @WireField(adapter = "com.tencent.videocut.model.SpecialEffectModel#ADAPTER", keyAdapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 2004)
    @JvmField
    @NotNull
    public final Map<String, SpecialEffectModel> specialEffects;

    @WireField(adapter = "com.tencent.videocut.model.StickerModel#ADAPTER", keyAdapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 2001)
    @JvmField
    @NotNull
    public final Map<String, StickerModel> stickers;

    @WireField(adapter = "com.tencent.videocut.model.TemplateModel#ADAPTER", tag = 2006)
    @JvmField
    @Nullable
    public final TemplateModel templateModel;

    @WireField(adapter = "com.tencent.videocut.model.TransitionModel#ADAPTER", keyAdapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 2005)
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

    @WireField(adapter = "com.tencent.videocut.model.MediaClip#ADAPTER", label = WireField.Label.REPEATED, tag = 1001)
    @JvmField
    @NotNull
    public final List<MediaClip> videos;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00000\u0001B\u0005\u00a2\u0006\u0002\u0010\u0003J\u001a\u0010\u0004\u001a\u00020\u00002\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005J\u0010\u0010\b\u001a\u00020\u00002\b\u0010\b\u001a\u0004\u0018\u00010\tJ\b\u0010+\u001a\u00020\u0002H\u0016J\u0010\u0010\n\u001a\u00020\u00002\b\u0010\n\u001a\u0004\u0018\u00010\u000bJ\u0015\u0010\f\u001a\u00020\u00002\b\u0010\f\u001a\u0004\u0018\u00010\r\u00a2\u0006\u0002\u0010,J\u0015\u0010\u000f\u001a\u00020\u00002\b\u0010\u000f\u001a\u0004\u0018\u00010\r\u00a2\u0006\u0002\u0010,J\u0010\u0010\u0010\u001a\u00020\u00002\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011J\u001a\u0010\u0012\u001a\u00020\u00002\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00130\u0005J\u001a\u0010\u0014\u001a\u00020\u00002\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00150\u0005J\u0010\u0010\u0016\u001a\u00020\u00002\b\u0010\u0016\u001a\u0004\u0018\u00010\u0006J\u0010\u0010\u0017\u001a\u00020\u00002\b\u0010\u0017\u001a\u0004\u0018\u00010\u0006J\u0015\u0010\u0018\u001a\u00020\u00002\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019\u00a2\u0006\u0002\u0010-J\u000e\u0010\u001b\u001a\u00020\u00002\u0006\u0010\u001b\u001a\u00020\u0019J\u001a\u0010\u001c\u001a\u00020\u00002\u0012\u0010.\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u001d0\u0005J\u001a\u0010\u001e\u001a\u00020\u00002\u0012\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u001f0\u0005J\u001a\u0010 \u001a\u00020\u00002\u0012\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020!0\u0005J\u0010\u0010\"\u001a\u00020\u00002\b\u0010\"\u001a\u0004\u0018\u00010#J\u001a\u0010$\u001a\u00020\u00002\u0012\u0010$\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020%0\u0005J\u0015\u0010&\u001a\u00020\u00002\b\u0010&\u001a\u0004\u0018\u00010\r\u00a2\u0006\u0002\u0010,J\u0010\u0010'\u001a\u00020\u00002\b\u0010'\u001a\u0004\u0018\u00010\u0006J\u0014\u0010(\u001a\u00020\u00002\f\u0010(\u001a\b\u0012\u0004\u0012\u00020*0)R\u001e\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0016\u0010\f\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0004\n\u0002\u0010\u000eR\u0016\u0010\u000f\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0004\n\u0002\u0010\u000eR\u0014\u0010\u0010\u001a\u0004\u0018\u00010\u00118\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u001e\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00130\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u001e\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00150\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0016\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0017\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0018\u001a\u0004\u0018\u00010\u00198\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0004\n\u0002\u0010\u001aR\u0016\u0010\u001b\u001a\u0004\u0018\u00010\u00198\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0004\n\u0002\u0010\u001aR\u001e\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u001d0\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u001e\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u001f0\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u001e\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020!0\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\"\u001a\u0004\u0018\u00010#8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u001e\u0010$\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020%0\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0016\u0010&\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0004\n\u0002\u0010\u000eR\u0014\u0010'\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0018\u0010(\u001a\b\u0012\u0004\u0012\u00020*0)8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006/"}, d2 = {"Lcom/tencent/videocut/model/MediaModel$Builder;", "Lcom/squareup/wire/Message$Builder;", "Lcom/tencent/videocut/model/MediaModel;", "()V", "audios", "", "", "Lcom/tencent/videocut/model/AudioModel;", "backgroundModel", "Lcom/tencent/videocut/model/BackgroundModel;", "coverInfo", "Lcom/tencent/videocut/model/CoverInfo;", WadlProxyConsts.CREATE_TIME, "", "Ljava/lang/Long;", "duration", "exportSetting", "Lcom/tencent/videocut/model/ExportSettingModel;", "filterModels", "Lcom/tencent/videocut/model/FilterModel;", "hdrModels", "Lcom/tencent/videocut/model/HDRModel;", "id", "name", "openHDR", "", "Ljava/lang/Boolean;", "openSuperHDR", "smoothModels", "Lcom/tencent/videocut/model/SmoothModel;", "specialEffects", "Lcom/tencent/videocut/model/SpecialEffectModel;", c.B, "Lcom/tencent/videocut/model/StickerModel;", "templateModel", "Lcom/tencent/videocut/model/TemplateModel;", JsonUtils.KEY_TRANSITIONS, "Lcom/tencent/videocut/model/TransitionModel;", "updateTime", "version", "videos", "", "Lcom/tencent/videocut/model/MediaClip;", "build", "(Ljava/lang/Long;)Lcom/tencent/videocut/model/MediaModel$Builder;", "(Ljava/lang/Boolean;)Lcom/tencent/videocut/model/MediaModel$Builder;", "openSmooth", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes27.dex */
    public static final class Builder extends Message.Builder<MediaModel, Builder> {
        static IPatchRedirector $redirector_;

        @JvmField
        @NotNull
        public Map<String, AudioModel> audios;

        @JvmField
        @Nullable
        public BackgroundModel backgroundModel;

        @JvmField
        @Nullable
        public CoverInfo coverInfo;

        @JvmField
        @Nullable
        public Long createTime;

        @JvmField
        @Nullable
        public Long duration;

        @JvmField
        @Nullable
        public ExportSettingModel exportSetting;

        @JvmField
        @NotNull
        public Map<String, FilterModel> filterModels;

        @JvmField
        @NotNull
        public Map<String, HDRModel> hdrModels;

        @JvmField
        @Nullable
        public String id;

        @JvmField
        @Nullable
        public String name;

        @JvmField
        @Nullable
        public Boolean openHDR;

        @JvmField
        @Nullable
        public Boolean openSuperHDR;

        @JvmField
        @NotNull
        public Map<String, SmoothModel> smoothModels;

        @JvmField
        @NotNull
        public Map<String, SpecialEffectModel> specialEffects;

        @JvmField
        @NotNull
        public Map<String, ? extends StickerModel> stickers;

        @JvmField
        @Nullable
        public TemplateModel templateModel;

        @JvmField
        @NotNull
        public Map<String, TransitionModel> transitions;

        @JvmField
        @Nullable
        public Long updateTime;

        @JvmField
        @Nullable
        public String version;

        @JvmField
        @NotNull
        public List<? extends MediaClip> videos;

        public Builder() {
            List<? extends MediaClip> emptyList;
            Map<String, AudioModel> emptyMap;
            Map<String, ? extends StickerModel> emptyMap2;
            Map<String, FilterModel> emptyMap3;
            Map<String, SpecialEffectModel> emptyMap4;
            Map<String, TransitionModel> emptyMap5;
            Map<String, HDRModel> emptyMap6;
            Map<String, SmoothModel> emptyMap7;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                emptyList = CollectionsKt__CollectionsKt.emptyList();
                this.videos = emptyList;
                emptyMap = MapsKt__MapsKt.emptyMap();
                this.audios = emptyMap;
                emptyMap2 = MapsKt__MapsKt.emptyMap();
                this.stickers = emptyMap2;
                emptyMap3 = MapsKt__MapsKt.emptyMap();
                this.filterModels = emptyMap3;
                emptyMap4 = MapsKt__MapsKt.emptyMap();
                this.specialEffects = emptyMap4;
                emptyMap5 = MapsKt__MapsKt.emptyMap();
                this.transitions = emptyMap5;
                Boolean bool = Boolean.FALSE;
                this.openHDR = bool;
                emptyMap6 = MapsKt__MapsKt.emptyMap();
                this.hdrModels = emptyMap6;
                emptyMap7 = MapsKt__MapsKt.emptyMap();
                this.smoothModels = emptyMap7;
                this.openSuperHDR = bool;
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }

        @NotNull
        public final Builder audios(@NotNull Map<String, AudioModel> audios) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                return (Builder) iPatchRedirector.redirect((short) 9, (Object) this, (Object) audios);
            }
            Intrinsics.checkNotNullParameter(audios, "audios");
            this.audios = audios;
            return this;
        }

        @NotNull
        public final Builder backgroundModel(@Nullable BackgroundModel backgroundModel) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
                return (Builder) iPatchRedirector.redirect((short) 11, (Object) this, (Object) backgroundModel);
            }
            this.backgroundModel = backgroundModel;
            return this;
        }

        @NotNull
        public final Builder coverInfo(@Nullable CoverInfo coverInfo) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
                return (Builder) iPatchRedirector.redirect((short) 16, (Object) this, (Object) coverInfo);
            }
            this.coverInfo = coverInfo;
            return this;
        }

        @NotNull
        public final Builder createTime(@Nullable Long createTime) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return (Builder) iPatchRedirector.redirect((short) 5, (Object) this, (Object) createTime);
            }
            this.createTime = createTime;
            return this;
        }

        @NotNull
        public final Builder duration(@Nullable Long duration) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return (Builder) iPatchRedirector.redirect((short) 7, (Object) this, (Object) duration);
            }
            this.duration = duration;
            return this;
        }

        @NotNull
        public final Builder exportSetting(@Nullable ExportSettingModel exportSetting) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
                return (Builder) iPatchRedirector.redirect((short) 17, (Object) this, (Object) exportSetting);
            }
            this.exportSetting = exportSetting;
            return this;
        }

        @NotNull
        public final Builder filterModels(@NotNull Map<String, FilterModel> filterModels) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
                return (Builder) iPatchRedirector.redirect((short) 12, (Object) this, (Object) filterModels);
            }
            Intrinsics.checkNotNullParameter(filterModels, "filterModels");
            this.filterModels = filterModels;
            return this;
        }

        @NotNull
        public final Builder hdrModels(@NotNull Map<String, HDRModel> hdrModels) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
                return (Builder) iPatchRedirector.redirect((short) 19, (Object) this, (Object) hdrModels);
            }
            Intrinsics.checkNotNullParameter(hdrModels, "hdrModels");
            this.hdrModels = hdrModels;
            return this;
        }

        @NotNull
        public final Builder id(@Nullable String id5) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (Builder) iPatchRedirector.redirect((short) 2, (Object) this, (Object) id5);
            }
            this.id = id5;
            return this;
        }

        @NotNull
        public final Builder name(@Nullable String name) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (Builder) iPatchRedirector.redirect((short) 3, (Object) this, (Object) name);
            }
            this.name = name;
            return this;
        }

        @NotNull
        public final Builder openHDR(@Nullable Boolean openHDR) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
                return (Builder) iPatchRedirector.redirect((short) 18, (Object) this, (Object) openHDR);
            }
            this.openHDR = openHDR;
            return this;
        }

        @NotNull
        public final Builder openSuperHDR(boolean openSuperHDR) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
                return (Builder) iPatchRedirector.redirect((short) 21, (Object) this, openSuperHDR);
            }
            this.openSuperHDR = Boolean.valueOf(openSuperHDR);
            return this;
        }

        @NotNull
        public final Builder smoothModels(@NotNull Map<String, SmoothModel> openSmooth) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
                return (Builder) iPatchRedirector.redirect((short) 20, (Object) this, (Object) openSmooth);
            }
            Intrinsics.checkNotNullParameter(openSmooth, "openSmooth");
            this.smoothModels = openSmooth;
            return this;
        }

        @NotNull
        public final Builder specialEffects(@NotNull Map<String, SpecialEffectModel> specialEffects) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
                return (Builder) iPatchRedirector.redirect((short) 13, (Object) this, (Object) specialEffects);
            }
            Intrinsics.checkNotNullParameter(specialEffects, "specialEffects");
            this.specialEffects = specialEffects;
            return this;
        }

        @NotNull
        public final Builder stickers(@NotNull Map<String, ? extends StickerModel> stickers) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
                return (Builder) iPatchRedirector.redirect((short) 10, (Object) this, (Object) stickers);
            }
            Intrinsics.checkNotNullParameter(stickers, "stickers");
            this.stickers = stickers;
            return this;
        }

        @NotNull
        public final Builder templateModel(@Nullable TemplateModel templateModel) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
                return (Builder) iPatchRedirector.redirect((short) 15, (Object) this, (Object) templateModel);
            }
            this.templateModel = templateModel;
            return this;
        }

        @NotNull
        public final Builder transitions(@NotNull Map<String, TransitionModel> transitions) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
                return (Builder) iPatchRedirector.redirect((short) 14, (Object) this, (Object) transitions);
            }
            Intrinsics.checkNotNullParameter(transitions, "transitions");
            this.transitions = transitions;
            return this;
        }

        @NotNull
        public final Builder updateTime(@Nullable Long updateTime) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return (Builder) iPatchRedirector.redirect((short) 6, (Object) this, (Object) updateTime);
            }
            this.updateTime = updateTime;
            return this;
        }

        @NotNull
        public final Builder version(@Nullable String version) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (Builder) iPatchRedirector.redirect((short) 4, (Object) this, (Object) version);
            }
            this.version = version;
            return this;
        }

        @NotNull
        public final Builder videos(@NotNull List<? extends MediaClip> videos) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                return (Builder) iPatchRedirector.redirect((short) 8, (Object) this, (Object) videos);
            }
            Intrinsics.checkNotNullParameter(videos, "videos");
            Internal.checkElementsNotNull(videos);
            this.videos = videos;
            return this;
        }

        @Override // com.squareup.wire.Message.Builder
        @NotNull
        public MediaModel build() {
            IPatchRedirector iPatchRedirector = $redirector_;
            return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 22)) ? new MediaModel(this.id, this.name, this.version, this.createTime, this.updateTime, this.duration, this.videos, this.audios, this.stickers, this.backgroundModel, this.filterModels, this.specialEffects, this.transitions, this.templateModel, this.coverInfo, this.exportSetting, this.openHDR, this.hdrModels, this.smoothModels, this.openSuperHDR, buildUnknownFields()) : (MediaModel) iPatchRedirector.redirect((short) 22, (Object) this);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00078\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0011\u0010\b\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\r"}, d2 = {"Lcom/tencent/videocut/model/MediaModel$Companion;", "", "()V", "ADAPTER", "Lcom/squareup/wire/ProtoAdapter;", "Lcom/tencent/videocut/model/MediaModel;", "CREATOR", "Landroid/os/Parcelable$Creator;", PatternUtils.NO_MATCH, "getEMPTY", "()Lcom/tencent/videocut/model/MediaModel;", "serialVersionUID", "", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes27.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                return;
            }
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) defaultConstructorMarker);
        }

        @NotNull
        public final MediaModel getEMPTY() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return MediaModel.EMPTY;
            }
            return (MediaModel) iPatchRedirector.redirect((short) 2, (Object) this);
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(58757);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 9)) {
            redirector.redirect((short) 9);
            return;
        }
        INSTANCE = new Companion(null);
        final FieldEncoding fieldEncoding = FieldEncoding.LENGTH_DELIMITED;
        final KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(MediaModel.class);
        ProtoAdapter<MediaModel> protoAdapter = new ProtoAdapter<MediaModel>(fieldEncoding, orCreateKotlinClass) { // from class: com.tencent.videocut.model.MediaModel$Companion$ADAPTER$1
            static IPatchRedirector $redirector_;

            @NotNull
            private final ProtoAdapter<Map<String, AudioModel>> audiosAdapter;

            @NotNull
            private final ProtoAdapter<Map<String, FilterModel>> filterModelsAdapter;

            @NotNull
            private final ProtoAdapter<Map<String, HDRModel>> hdrModelsAdapter;

            @NotNull
            private final ProtoAdapter<Map<String, SmoothModel>> smoothModelsAdapter;

            @NotNull
            private final ProtoAdapter<Map<String, SpecialEffectModel>> specialEffectsAdapter;

            @NotNull
            private final ProtoAdapter<Map<String, StickerModel>> stickersAdapter;

            @NotNull
            private final ProtoAdapter<Map<String, TransitionModel>> transitionsAdapter;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(fieldEncoding, orCreateKotlinClass, "type.googleapis.com/publisher.MediaModel");
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) fieldEncoding, (Object) orCreateKotlinClass);
                    return;
                }
                ProtoAdapter.Companion companion = ProtoAdapter.INSTANCE;
                ProtoAdapter<String> protoAdapter2 = ProtoAdapter.STRING;
                this.audiosAdapter = companion.newMapAdapter(protoAdapter2, AudioModel.ADAPTER);
                this.stickersAdapter = companion.newMapAdapter(protoAdapter2, StickerModel.ADAPTER);
                this.filterModelsAdapter = companion.newMapAdapter(protoAdapter2, FilterModel.ADAPTER);
                this.specialEffectsAdapter = companion.newMapAdapter(protoAdapter2, SpecialEffectModel.ADAPTER);
                this.transitionsAdapter = companion.newMapAdapter(protoAdapter2, TransitionModel.ADAPTER);
                this.hdrModelsAdapter = companion.newMapAdapter(protoAdapter2, HDRModel.ADAPTER);
                this.smoothModelsAdapter = companion.newMapAdapter(protoAdapter2, SmoothModel.ADAPTER);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            @NotNull
            public MediaModel decode(@NotNull ProtoReader reader) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                    return (MediaModel) iPatchRedirector.redirect((short) 4, (Object) this, (Object) reader);
                }
                Intrinsics.checkNotNullParameter(reader, "reader");
                ArrayList arrayList = new ArrayList();
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                LinkedHashMap linkedHashMap2 = new LinkedHashMap();
                LinkedHashMap linkedHashMap3 = new LinkedHashMap();
                LinkedHashMap linkedHashMap4 = new LinkedHashMap();
                LinkedHashMap linkedHashMap5 = new LinkedHashMap();
                LinkedHashMap linkedHashMap6 = new LinkedHashMap();
                LinkedHashMap linkedHashMap7 = new LinkedHashMap();
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
                Boolean bool = null;
                Boolean bool2 = null;
                Long l17 = null;
                while (true) {
                    int nextTag = reader.nextTag();
                    String str4 = str3;
                    if (nextTag == -1) {
                        return new MediaModel(str, str2, str4, l17, l3, l16, arrayList, linkedHashMap, linkedHashMap2, backgroundModel, linkedHashMap3, linkedHashMap4, linkedHashMap5, templateModel, coverInfo, exportSettingModel, bool, linkedHashMap6, linkedHashMap7, bool2, reader.endMessageAndGetUnknownFields(beginMessage));
                    }
                    if (nextTag == 1001) {
                        arrayList.add(MediaClip.ADAPTER.decode(reader));
                    } else if (nextTag == 1002) {
                        linkedHashMap.putAll(this.audiosAdapter.decode(reader));
                    } else if (nextTag == 3001) {
                        coverInfo = CoverInfo.ADAPTER.decode(reader);
                    } else if (nextTag != 4006) {
                        switch (nextTag) {
                            case 1:
                                str = ProtoAdapter.STRING.decode(reader);
                                break;
                            case 2:
                                str2 = ProtoAdapter.STRING.decode(reader);
                                break;
                            case 3:
                                str3 = ProtoAdapter.STRING.decode(reader);
                                continue;
                            case 4:
                                l17 = ProtoAdapter.INT64.decode(reader);
                                break;
                            case 5:
                                l3 = ProtoAdapter.INT64.decode(reader);
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
                                    default:
                                        switch (nextTag) {
                                            case 4001:
                                                exportSettingModel = ExportSettingModel.ADAPTER.decode(reader);
                                                break;
                                            case 4002:
                                                bool = ProtoAdapter.BOOL.decode(reader);
                                                break;
                                            case 4003:
                                                linkedHashMap6.putAll(this.hdrModelsAdapter.decode(reader));
                                                break;
                                            case 4004:
                                                linkedHashMap7.putAll(this.smoothModelsAdapter.decode(reader));
                                                break;
                                            default:
                                                reader.readUnknownField(nextTag);
                                                break;
                                        }
                                }
                        }
                    } else {
                        bool2 = ProtoAdapter.BOOL.decode(reader);
                    }
                    str3 = str4;
                }
            }

            @Override // com.squareup.wire.ProtoAdapter
            public void encode(@NotNull ProtoWriter writer, @NotNull MediaModel value) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                    iPatchRedirector.redirect((short) 3, (Object) this, (Object) writer, (Object) value);
                    return;
                }
                Intrinsics.checkNotNullParameter(writer, "writer");
                Intrinsics.checkNotNullParameter(value, "value");
                ProtoAdapter<String> protoAdapter2 = ProtoAdapter.STRING;
                protoAdapter2.encodeWithTag(writer, 1, value.id);
                protoAdapter2.encodeWithTag(writer, 2, value.name);
                protoAdapter2.encodeWithTag(writer, 3, value.version);
                ProtoAdapter<Long> protoAdapter3 = ProtoAdapter.INT64;
                protoAdapter3.encodeWithTag(writer, 4, value.createTime);
                protoAdapter3.encodeWithTag(writer, 5, value.updateTime);
                protoAdapter3.encodeWithTag(writer, 6, value.duration);
                MediaClip.ADAPTER.asRepeated().encodeWithTag(writer, 1001, value.videos);
                this.audiosAdapter.encodeWithTag(writer, 1002, value.audios);
                this.stickersAdapter.encodeWithTag(writer, 2001, value.stickers);
                BackgroundModel.ADAPTER.encodeWithTag(writer, 2002, value.backgroundModel);
                this.filterModelsAdapter.encodeWithTag(writer, 2003, value.filterModels);
                this.specialEffectsAdapter.encodeWithTag(writer, 2004, value.specialEffects);
                this.transitionsAdapter.encodeWithTag(writer, 2005, value.transitions);
                TemplateModel.ADAPTER.encodeWithTag(writer, 2006, value.templateModel);
                CoverInfo.ADAPTER.encodeWithTag(writer, 3001, value.coverInfo);
                ExportSettingModel.ADAPTER.encodeWithTag(writer, 4001, value.exportSetting);
                ProtoAdapter<Boolean> protoAdapter4 = ProtoAdapter.BOOL;
                protoAdapter4.encodeWithTag(writer, 4002, value.openHDR);
                this.hdrModelsAdapter.encodeWithTag(writer, 4003, value.hdrModels);
                this.smoothModelsAdapter.encodeWithTag(writer, 4004, value.smoothModels);
                protoAdapter4.encodeWithTag(writer, 4006, value.openSuperHDR);
                writer.writeBytes(value.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public int encodedSize(@NotNull MediaModel value) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this, (Object) value)).intValue();
                }
                Intrinsics.checkNotNullParameter(value, "value");
                ProtoAdapter<String> protoAdapter2 = ProtoAdapter.STRING;
                int encodedSizeWithTag = protoAdapter2.encodedSizeWithTag(1, value.id) + protoAdapter2.encodedSizeWithTag(2, value.name) + protoAdapter2.encodedSizeWithTag(3, value.version);
                ProtoAdapter<Long> protoAdapter3 = ProtoAdapter.INT64;
                int encodedSizeWithTag2 = encodedSizeWithTag + protoAdapter3.encodedSizeWithTag(4, value.createTime) + protoAdapter3.encodedSizeWithTag(5, value.updateTime) + protoAdapter3.encodedSizeWithTag(6, value.duration) + MediaClip.ADAPTER.asRepeated().encodedSizeWithTag(1001, value.videos) + this.audiosAdapter.encodedSizeWithTag(1002, value.audios) + this.stickersAdapter.encodedSizeWithTag(2001, value.stickers) + BackgroundModel.ADAPTER.encodedSizeWithTag(2002, value.backgroundModel) + this.filterModelsAdapter.encodedSizeWithTag(2003, value.filterModels) + this.specialEffectsAdapter.encodedSizeWithTag(2004, value.specialEffects) + this.transitionsAdapter.encodedSizeWithTag(2005, value.transitions) + TemplateModel.ADAPTER.encodedSizeWithTag(2006, value.templateModel) + CoverInfo.ADAPTER.encodedSizeWithTag(3001, value.coverInfo) + ExportSettingModel.ADAPTER.encodedSizeWithTag(4001, value.exportSetting);
                ProtoAdapter<Boolean> protoAdapter4 = ProtoAdapter.BOOL;
                return encodedSizeWithTag2 + protoAdapter4.encodedSizeWithTag(4002, value.openHDR) + this.hdrModelsAdapter.encodedSizeWithTag(4003, value.hdrModels) + this.smoothModelsAdapter.encodedSizeWithTag(4004, value.smoothModels) + protoAdapter4.encodedSizeWithTag(4006, value.openSuperHDR) + value.unknownFields().size();
            }

            @Override // com.squareup.wire.ProtoAdapter
            @NotNull
            public MediaModel redact(@NotNull MediaModel value) {
                MediaModel copy;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                    return (MediaModel) iPatchRedirector.redirect((short) 5, (Object) this, (Object) value);
                }
                Intrinsics.checkNotNullParameter(value, "value");
                List m87redactElements = Internal.m87redactElements(value.videos, MediaClip.ADAPTER);
                Map m88redactElements = Internal.m88redactElements(value.audios, AudioModel.ADAPTER);
                Map m88redactElements2 = Internal.m88redactElements(value.stickers, StickerModel.ADAPTER);
                BackgroundModel backgroundModel = value.backgroundModel;
                BackgroundModel redact = backgroundModel != null ? BackgroundModel.ADAPTER.redact(backgroundModel) : null;
                Map m88redactElements3 = Internal.m88redactElements(value.filterModels, FilterModel.ADAPTER);
                Map m88redactElements4 = Internal.m88redactElements(value.specialEffects, SpecialEffectModel.ADAPTER);
                Map m88redactElements5 = Internal.m88redactElements(value.transitions, TransitionModel.ADAPTER);
                TemplateModel templateModel = value.templateModel;
                TemplateModel redact2 = templateModel != null ? TemplateModel.ADAPTER.redact(templateModel) : null;
                CoverInfo coverInfo = value.coverInfo;
                CoverInfo redact3 = coverInfo != null ? CoverInfo.ADAPTER.redact(coverInfo) : null;
                ExportSettingModel exportSettingModel = value.exportSetting;
                copy = value.copy((r39 & 1) != 0 ? value.id : null, (r39 & 2) != 0 ? value.name : null, (r39 & 4) != 0 ? value.version : null, (r39 & 8) != 0 ? value.createTime : null, (r39 & 16) != 0 ? value.updateTime : null, (r39 & 32) != 0 ? value.duration : null, (r39 & 64) != 0 ? value.videos : m87redactElements, (r39 & 128) != 0 ? value.audios : m88redactElements, (r39 & 256) != 0 ? value.stickers : m88redactElements2, (r39 & 512) != 0 ? value.backgroundModel : redact, (r39 & 1024) != 0 ? value.filterModels : m88redactElements3, (r39 & 2048) != 0 ? value.specialEffects : m88redactElements4, (r39 & 4096) != 0 ? value.transitions : m88redactElements5, (r39 & 8192) != 0 ? value.templateModel : redact2, (r39 & 16384) != 0 ? value.coverInfo : redact3, (r39 & 32768) != 0 ? value.exportSetting : exportSettingModel != null ? ExportSettingModel.ADAPTER.redact(exportSettingModel) : null, (r39 & 65536) != 0 ? value.openHDR : null, (r39 & 131072) != 0 ? value.hdrModels : null, (r39 & 262144) != 0 ? value.smoothModels : null, (r39 & 524288) != 0 ? value.openSuperHDR : null, (r39 & 1048576) != 0 ? value.unknownFields() : ByteString.EMPTY);
                return copy;
            }
        };
        ADAPTER = protoAdapter;
        CREATOR = AndroidMessage.INSTANCE.newCreator(protoAdapter);
        EMPTY = new MediaModel(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 2097151, null);
    }

    public MediaModel() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 2097151, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 8)) {
            return;
        }
        iPatchRedirector.redirect((short) 8, (Object) this);
    }

    @NotNull
    public final MediaModel copy(@Nullable String id5, @Nullable String name, @Nullable String version, @Nullable Long createTime, @Nullable Long updateTime, @Nullable Long duration, @NotNull List<? extends MediaClip> videos, @NotNull Map<String, AudioModel> audios, @NotNull Map<String, ? extends StickerModel> stickers, @Nullable BackgroundModel backgroundModel, @NotNull Map<String, FilterModel> filterModels, @NotNull Map<String, SpecialEffectModel> specialEffects, @NotNull Map<String, TransitionModel> transitions, @Nullable TemplateModel templateModel, @Nullable CoverInfo coverInfo, @Nullable ExportSettingModel exportSetting, @Nullable Boolean openHDR, @NotNull Map<String, HDRModel> hdrModels, @NotNull Map<String, SmoothModel> smoothModels, @Nullable Boolean openSuperHDR, @NotNull ByteString unknownFields) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (MediaModel) iPatchRedirector.redirect((short) 7, this, id5, name, version, createTime, updateTime, duration, videos, audios, stickers, backgroundModel, filterModels, specialEffects, transitions, templateModel, coverInfo, exportSetting, openHDR, hdrModels, smoothModels, openSuperHDR, unknownFields);
        }
        Intrinsics.checkNotNullParameter(videos, "videos");
        Intrinsics.checkNotNullParameter(audios, "audios");
        Intrinsics.checkNotNullParameter(stickers, "stickers");
        Intrinsics.checkNotNullParameter(filterModels, "filterModels");
        Intrinsics.checkNotNullParameter(specialEffects, "specialEffects");
        Intrinsics.checkNotNullParameter(transitions, "transitions");
        Intrinsics.checkNotNullParameter(hdrModels, "hdrModels");
        Intrinsics.checkNotNullParameter(smoothModels, "smoothModels");
        Intrinsics.checkNotNullParameter(unknownFields, "unknownFields");
        return new MediaModel(id5, name, version, createTime, updateTime, duration, Internal.immutableCopyOf("videos", videos), new LinkedHashMap(audios), new LinkedHashMap(stickers), backgroundModel, new LinkedHashMap(filterModels), new LinkedHashMap(specialEffects), new LinkedHashMap(transitions), templateModel, coverInfo, exportSetting, openHDR, new LinkedHashMap(hdrModels), new LinkedHashMap(smoothModels), openSuperHDR, unknownFields);
    }

    public boolean equals(@Nullable Object other) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, other)).booleanValue();
        }
        if (other == this) {
            return true;
        }
        if (!(other instanceof MediaModel)) {
            return false;
        }
        MediaModel mediaModel = (MediaModel) other;
        if (Intrinsics.areEqual(unknownFields(), mediaModel.unknownFields()) && Intrinsics.areEqual(this.id, mediaModel.id) && Intrinsics.areEqual(this.name, mediaModel.name) && Intrinsics.areEqual(this.version, mediaModel.version) && Intrinsics.areEqual(this.createTime, mediaModel.createTime) && Intrinsics.areEqual(this.updateTime, mediaModel.updateTime) && Intrinsics.areEqual(this.duration, mediaModel.duration) && Intrinsics.areEqual(this.videos, mediaModel.videos) && Intrinsics.areEqual(this.audios, mediaModel.audios) && Intrinsics.areEqual(this.stickers, mediaModel.stickers) && Intrinsics.areEqual(this.backgroundModel, mediaModel.backgroundModel) && Intrinsics.areEqual(this.filterModels, mediaModel.filterModels) && Intrinsics.areEqual(this.specialEffects, mediaModel.specialEffects) && Intrinsics.areEqual(this.transitions, mediaModel.transitions) && Intrinsics.areEqual(this.templateModel, mediaModel.templateModel) && Intrinsics.areEqual(this.coverInfo, mediaModel.coverInfo) && Intrinsics.areEqual(this.exportSetting, mediaModel.exportSetting) && Intrinsics.areEqual(this.openHDR, mediaModel.openHDR) && Intrinsics.areEqual(this.hdrModels, mediaModel.hdrModels) && Intrinsics.areEqual(this.smoothModels, mediaModel.smoothModels) && Intrinsics.areEqual(this.openSuperHDR, mediaModel.openSuperHDR)) {
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
        int i37;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
        }
        int i38 = this.hashCode;
        if (i38 == 0) {
            int hashCode = unknownFields().hashCode() * 37;
            String str = this.id;
            int i39 = 0;
            if (str != null) {
                i3 = str.hashCode();
            } else {
                i3 = 0;
            }
            int i46 = (hashCode + i3) * 37;
            String str2 = this.name;
            if (str2 != null) {
                i16 = str2.hashCode();
            } else {
                i16 = 0;
            }
            int i47 = (i46 + i16) * 37;
            String str3 = this.version;
            if (str3 != null) {
                i17 = str3.hashCode();
            } else {
                i17 = 0;
            }
            int i48 = (i47 + i17) * 37;
            Long l3 = this.createTime;
            if (l3 != null) {
                i18 = l3.hashCode();
            } else {
                i18 = 0;
            }
            int i49 = (i48 + i18) * 37;
            Long l16 = this.updateTime;
            if (l16 != null) {
                i19 = l16.hashCode();
            } else {
                i19 = 0;
            }
            int i56 = (i49 + i19) * 37;
            Long l17 = this.duration;
            if (l17 != null) {
                i26 = l17.hashCode();
            } else {
                i26 = 0;
            }
            int hashCode2 = (((((((i56 + i26) * 37) + this.videos.hashCode()) * 37) + this.audios.hashCode()) * 37) + this.stickers.hashCode()) * 37;
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
            int i57 = (hashCode3 + i28) * 37;
            CoverInfo coverInfo = this.coverInfo;
            if (coverInfo != null) {
                i29 = coverInfo.hashCode();
            } else {
                i29 = 0;
            }
            int i58 = (i57 + i29) * 37;
            ExportSettingModel exportSettingModel = this.exportSetting;
            if (exportSettingModel != null) {
                i36 = exportSettingModel.hashCode();
            } else {
                i36 = 0;
            }
            int i59 = (i58 + i36) * 37;
            Boolean bool = this.openHDR;
            if (bool != null) {
                i37 = bool.hashCode();
            } else {
                i37 = 0;
            }
            int hashCode4 = (((((i59 + i37) * 37) + this.hdrModels.hashCode()) * 37) + this.smoothModels.hashCode()) * 37;
            Boolean bool2 = this.openSuperHDR;
            if (bool2 != null) {
                i39 = bool2.hashCode();
            }
            int i65 = hashCode4 + i39;
            this.hashCode = i65;
            return i65;
        }
        return i38;
    }

    @Override // com.squareup.wire.Message
    @NotNull
    public String toString() {
        String joinToString$default;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this);
        }
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
        if (!this.hdrModels.isEmpty()) {
            arrayList.add("hdrModels=" + this.hdrModels);
        }
        Map<String, SmoothModel> map = this.smoothModels;
        if (map != null) {
            arrayList.add("smoothModels=" + map);
        }
        Boolean bool2 = this.openSuperHDR;
        if (bool2 != null) {
            arrayList.add("openSuperHDR=" + bool2);
        }
        joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(arrayList, ", ", "MediaModel{", "}", 0, null, null, 56, null);
        return joinToString$default;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ MediaModel(String str, String str2, String str3, Long l3, Long l16, Long l17, List list, Map map, Map map2, BackgroundModel backgroundModel, Map map3, Map map4, Map map5, TemplateModel templateModel, CoverInfo coverInfo, ExportSettingModel exportSettingModel, Boolean bool, Map map6, Map map7, Boolean bool2, ByteString byteString, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, (524288 & i3) != 0 ? Boolean.FALSE : bool2, (1048576 & i3) != 0 ? ByteString.EMPTY : byteString);
        List list2;
        Map map8;
        Map map9;
        Map map10;
        Map map11;
        Map map12;
        Map map13;
        Map map14;
        Map emptyMap;
        Map emptyMap2;
        Map emptyMap3;
        Map emptyMap4;
        Map emptyMap5;
        Map emptyMap6;
        Map emptyMap7;
        List emptyList;
        String str4 = (i3 & 1) != 0 ? null : str;
        String str5 = (i3 & 2) != 0 ? null : str2;
        String str6 = (i3 & 4) != 0 ? null : str3;
        Long l18 = (i3 & 8) != 0 ? null : l3;
        Long l19 = (i3 & 16) != 0 ? null : l16;
        Long l26 = (i3 & 32) != 0 ? null : l17;
        if ((i3 & 64) != 0) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            list2 = emptyList;
        } else {
            list2 = list;
        }
        if ((i3 & 128) != 0) {
            emptyMap7 = MapsKt__MapsKt.emptyMap();
            map8 = emptyMap7;
        } else {
            map8 = map;
        }
        if ((i3 & 256) != 0) {
            emptyMap6 = MapsKt__MapsKt.emptyMap();
            map9 = emptyMap6;
        } else {
            map9 = map2;
        }
        BackgroundModel backgroundModel2 = (i3 & 512) != 0 ? null : backgroundModel;
        if ((i3 & 1024) != 0) {
            emptyMap5 = MapsKt__MapsKt.emptyMap();
            map10 = emptyMap5;
        } else {
            map10 = map3;
        }
        if ((i3 & 2048) != 0) {
            emptyMap4 = MapsKt__MapsKt.emptyMap();
            map11 = emptyMap4;
        } else {
            map11 = map4;
        }
        if ((i3 & 4096) != 0) {
            emptyMap3 = MapsKt__MapsKt.emptyMap();
            map12 = emptyMap3;
        } else {
            map12 = map5;
        }
        TemplateModel templateModel2 = (i3 & 8192) != 0 ? null : templateModel;
        CoverInfo coverInfo2 = (i3 & 16384) != 0 ? null : coverInfo;
        ExportSettingModel exportSettingModel2 = (32768 & i3) != 0 ? null : exportSettingModel;
        Boolean bool3 = (65536 & i3) != 0 ? Boolean.FALSE : bool;
        if ((131072 & i3) != 0) {
            emptyMap2 = MapsKt__MapsKt.emptyMap();
            map13 = emptyMap2;
        } else {
            map13 = map6;
        }
        if ((262144 & i3) != 0) {
            emptyMap = MapsKt__MapsKt.emptyMap();
            map14 = emptyMap;
        } else {
            map14 = map7;
        }
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, str, str2, str3, l3, l16, l17, list, map, map2, backgroundModel, map3, map4, map5, templateModel, coverInfo, exportSettingModel, bool, map6, map7, bool2, byteString, Integer.valueOf(i3), defaultConstructorMarker);
    }

    @Override // com.squareup.wire.Message
    @NotNull
    public Builder newBuilder() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Builder) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        Builder builder = new Builder();
        builder.id = this.id;
        builder.name = this.name;
        builder.version = this.version;
        builder.createTime = this.createTime;
        builder.updateTime = this.updateTime;
        builder.duration = this.duration;
        builder.videos = this.videos;
        builder.audios = this.audios;
        builder.stickers = this.stickers;
        builder.backgroundModel = this.backgroundModel;
        builder.filterModels = this.filterModels;
        builder.specialEffects = this.specialEffects;
        builder.transitions = this.transitions;
        builder.templateModel = this.templateModel;
        builder.coverInfo = this.coverInfo;
        builder.exportSetting = this.exportSetting;
        builder.openHDR = this.openHDR;
        builder.hdrModels = this.hdrModels;
        builder.smoothModels = this.smoothModels;
        builder.openSuperHDR = this.openSuperHDR;
        builder.addUnknownFields(unknownFields());
        return builder;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MediaModel(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable Long l3, @Nullable Long l16, @Nullable Long l17, @NotNull List<? extends MediaClip> videos, @NotNull Map<String, AudioModel> audios, @NotNull Map<String, ? extends StickerModel> stickers, @Nullable BackgroundModel backgroundModel, @NotNull Map<String, FilterModel> filterModels, @NotNull Map<String, SpecialEffectModel> specialEffects, @NotNull Map<String, TransitionModel> transitions, @Nullable TemplateModel templateModel, @Nullable CoverInfo coverInfo, @Nullable ExportSettingModel exportSettingModel, @Nullable Boolean bool, @NotNull Map<String, HDRModel> hdrModels, @NotNull Map<String, SmoothModel> smoothModels, @Nullable Boolean bool2, @NotNull ByteString unknownFields) {
        super(ADAPTER, unknownFields);
        Intrinsics.checkNotNullParameter(videos, "videos");
        Intrinsics.checkNotNullParameter(audios, "audios");
        Intrinsics.checkNotNullParameter(stickers, "stickers");
        Intrinsics.checkNotNullParameter(filterModels, "filterModels");
        Intrinsics.checkNotNullParameter(specialEffects, "specialEffects");
        Intrinsics.checkNotNullParameter(transitions, "transitions");
        Intrinsics.checkNotNullParameter(hdrModels, "hdrModels");
        Intrinsics.checkNotNullParameter(smoothModels, "smoothModels");
        Intrinsics.checkNotNullParameter(unknownFields, "unknownFields");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, str, str2, str3, l3, l16, l17, videos, audios, stickers, backgroundModel, filterModels, specialEffects, transitions, templateModel, coverInfo, exportSettingModel, bool, hdrModels, smoothModels, bool2, unknownFields);
            return;
        }
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
        this.coverInfo = coverInfo;
        this.exportSetting = exportSettingModel;
        this.openHDR = bool;
        this.hdrModels = hdrModels;
        this.smoothModels = smoothModels;
        this.openSuperHDR = bool2;
    }
}
