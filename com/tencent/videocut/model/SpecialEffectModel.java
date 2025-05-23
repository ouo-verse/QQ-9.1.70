package com.tencent.videocut.model;

import android.os.Parcelable;
import com.squareup.wire.AndroidMessage;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireField;
import com.squareup.wire.internal.Internal;
import com.tencent.ams.dsdk.core.DKConfiguration;
import com.tencent.hippy.qq.view.pag.HippyQQPagViewController;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qcircle.weseevideo.model.template.movie.AIAbilityModel;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import okio.ByteString;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0006\u0018\u0000 02\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002/0B\u0097\u0002\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0019\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010 \u001a\u00020!\u00a2\u0006\u0002\u0010\"J\u009d\u0002\u0010&\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00192\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010 \u001a\u00020!\u00a2\u0006\u0002\u0010'J\u0013\u0010(\u001a\u00020)2\b\u0010*\u001a\u0004\u0018\u00010+H\u0096\u0002J\b\u0010,\u001a\u00020\u0007H\u0016J\b\u0010-\u001a\u00020\u0002H\u0016J\b\u0010.\u001a\u00020\u0004H\u0016R\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u00128\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u00108\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004\u00a2\u0006\u0004\n\u0002\u0010#R\u0012\u0010\u0015\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004\u00a2\u0006\u0004\n\u0002\u0010$R\u0014\u0010\n\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004\u00a2\u0006\u0004\n\u0002\u0010$R\u0014\u0010\u001f\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004\u00a2\u0006\u0004\n\u0002\u0010#R\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u001b\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u001a\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u0017\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u0014\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u0016\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\u0004\u0018\u00010\r8\u0006X\u0087\u0004\u00a2\u0006\u0004\n\u0002\u0010%R\u0014\u0010\u001c\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004\u00a2\u0006\u0004\n\u0002\u0010#R\u0014\u0010\u001d\u001a\u0004\u0018\u00010\r8\u0006X\u0087\u0004\u00a2\u0006\u0004\n\u0002\u0010%R\u0014\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004\u00a2\u0006\u0004\n\u0002\u0010$R\u0014\u0010\u001e\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004\u00a2\u0006\u0004\n\u0002\u0010#R\u0014\u0010\u0013\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004\u00a2\u0006\u0004\n\u0002\u0010#R\u0012\u0010\u0018\u001a\u0004\u0018\u00010\u00198\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u00061"}, d2 = {"Lcom/tencent/videocut/model/SpecialEffectModel;", "Lcom/squareup/wire/AndroidMessage;", "Lcom/tencent/videocut/model/SpecialEffectModel$Builder;", "id", "", "name", "bgColor", "", "startTimeUs", "", "durationUs", "createTimeMs", "scale", "", "filePath", "animationMode", "Lcom/tencent/videocut/model/AnimationMode;", "actionScope", "Lcom/tencent/videocut/model/ActionScope;", "timeLineIndex", DKConfiguration.PreloadKeys.KEY_MATERIAL_ID, "categoryId", "portraitFilePath", "landscapeFilePath", "type", "Lcom/tencent/videocut/model/SpecialEffectResType;", "jsPath", "jsContentCache", HippyQQPagViewController.PropertyName.SCALE_MODE, "scaleWithCrop", "temporary", AIAbilityModel.AI_KEY, "unknownFields", "Lokio/ByteString;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Float;Ljava/lang/String;Lcom/tencent/videocut/model/AnimationMode;Lcom/tencent/videocut/model/ActionScope;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/videocut/model/SpecialEffectResType;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Float;Ljava/lang/Integer;Ljava/lang/Integer;Lokio/ByteString;)V", "Ljava/lang/Integer;", "Ljava/lang/Long;", "Ljava/lang/Float;", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Float;Ljava/lang/String;Lcom/tencent/videocut/model/AnimationMode;Lcom/tencent/videocut/model/ActionScope;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/videocut/model/SpecialEffectResType;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Float;Ljava/lang/Integer;Ljava/lang/Integer;Lokio/ByteString;)Lcom/tencent/videocut/model/SpecialEffectModel;", "equals", "", "other", "", "hashCode", "newBuilder", "toString", "Builder", "Companion", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes27.dex */
public final class SpecialEffectModel extends AndroidMessage<SpecialEffectModel, Builder> {
    static IPatchRedirector $redirector_ = null;

    @JvmField
    @NotNull
    public static final ProtoAdapter<SpecialEffectModel> ADAPTER;

    @JvmField
    @NotNull
    public static final Parcelable.Creator<SpecialEffectModel> CREATOR;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;
    private static final long serialVersionUID = -1938991180776760004L;

    @WireField(adapter = "com.tencent.videocut.model.ActionScope#ADAPTER", tag = 10)
    @JvmField
    @Nullable
    public final ActionScope actionScope;

    @WireField(adapter = "com.tencent.videocut.model.AnimationMode#ADAPTER", tag = 9)
    @JvmField
    @Nullable
    public final AnimationMode animationMode;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 3)
    @JvmField
    @Nullable
    public final Integer bgColor;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 13)
    @JvmField
    @Nullable
    public final String categoryId;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT64", tag = 6)
    @JvmField
    @Nullable
    public final Long createTimeMs;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT64", tag = 5)
    @JvmField
    @Nullable
    public final Long durationUs;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 22)
    @JvmField
    @Nullable
    public final Integer effectType;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 8)
    @JvmField
    @Nullable
    public final String filePath;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 1)
    @JvmField
    @Nullable
    public final String id;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 18)
    @JvmField
    @Nullable
    public final String jsContentCache;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 17)
    @JvmField
    @Nullable
    public final String jsPath;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 15)
    @JvmField
    @Nullable
    public final String landscapeFilePath;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 12)
    @JvmField
    @Nullable
    public final String materialId;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 2)
    @JvmField
    @Nullable
    public final String name;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 14)
    @JvmField
    @Nullable
    public final String portraitFilePath;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#FLOAT", tag = 7)
    @JvmField
    @Nullable
    public final Float scale;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 19)
    @JvmField
    @Nullable
    public final Integer scaleMode;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#FLOAT", tag = 20)
    @JvmField
    @Nullable
    public final Float scaleWithCrop;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT64", tag = 4)
    @JvmField
    @Nullable
    public final Long startTimeUs;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 21)
    @JvmField
    @Nullable
    public final Integer temporary;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 11)
    @JvmField
    @Nullable
    public final Integer timeLineIndex;

    @WireField(adapter = "com.tencent.videocut.model.SpecialEffectResType#ADAPTER", tag = 16)
    @JvmField
    @Nullable
    public final SpecialEffectResType type;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00000\u0001B\u0005\u00a2\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00002\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005J\u0010\u0010\u0006\u001a\u00020\u00002\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007J\u0015\u0010\b\u001a\u00020\u00002\b\u0010\b\u001a\u0004\u0018\u00010\t\u00a2\u0006\u0002\u0010$J\b\u0010%\u001a\u00020\u0002H\u0016J\u0010\u0010\u000b\u001a\u00020\u00002\b\u0010\u000b\u001a\u0004\u0018\u00010\fJ\u0015\u0010\r\u001a\u00020\u00002\b\u0010\r\u001a\u0004\u0018\u00010\u000e\u00a2\u0006\u0002\u0010&J\u0015\u0010\u0010\u001a\u00020\u00002\b\u0010\u0010\u001a\u0004\u0018\u00010\u000e\u00a2\u0006\u0002\u0010&J\u0015\u0010\u0011\u001a\u00020\u00002\b\u0010\u0011\u001a\u0004\u0018\u00010\t\u00a2\u0006\u0002\u0010$J\u0010\u0010\u0012\u001a\u00020\u00002\b\u0010\u0012\u001a\u0004\u0018\u00010\fJ\u0010\u0010\u0013\u001a\u00020\u00002\b\u0010\u0013\u001a\u0004\u0018\u00010\fJ\u0010\u0010\u0014\u001a\u00020\u00002\b\u0010\u0014\u001a\u0004\u0018\u00010\fJ\u0010\u0010\u0015\u001a\u00020\u00002\b\u0010\u0015\u001a\u0004\u0018\u00010\fJ\u0010\u0010\u0016\u001a\u00020\u00002\b\u0010\u0016\u001a\u0004\u0018\u00010\fJ\u0010\u0010\u0017\u001a\u00020\u00002\b\u0010\u0017\u001a\u0004\u0018\u00010\fJ\u0010\u0010\u0018\u001a\u00020\u00002\b\u0010\u0018\u001a\u0004\u0018\u00010\fJ\u0010\u0010\u0019\u001a\u00020\u00002\b\u0010\u0019\u001a\u0004\u0018\u00010\fJ\u0015\u0010\u001a\u001a\u00020\u00002\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b\u00a2\u0006\u0002\u0010'J\u0015\u0010\u001d\u001a\u00020\u00002\b\u0010\u001d\u001a\u0004\u0018\u00010\t\u00a2\u0006\u0002\u0010$J\u0015\u0010\u001e\u001a\u00020\u00002\b\u0010\u001e\u001a\u0004\u0018\u00010\u001b\u00a2\u0006\u0002\u0010'J\u0015\u0010\u001f\u001a\u00020\u00002\b\u0010\u001f\u001a\u0004\u0018\u00010\u000e\u00a2\u0006\u0002\u0010&J\u0015\u0010 \u001a\u00020\u00002\b\u0010 \u001a\u0004\u0018\u00010\t\u00a2\u0006\u0002\u0010$J\u0015\u0010!\u001a\u00020\u00002\b\u0010!\u001a\u0004\u0018\u00010\t\u00a2\u0006\u0002\u0010$J\u0010\u0010\"\u001a\u00020\u00002\b\u0010\"\u001a\u0004\u0018\u00010#R\u0014\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0004\n\u0002\u0010\nR\u0014\u0010\u000b\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0016\u0010\r\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0004\n\u0002\u0010\u000fR\u0016\u0010\u0010\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0004\n\u0002\u0010\u000fR\u0016\u0010\u0011\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0004\n\u0002\u0010\nR\u0014\u0010\u0012\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0014\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0015\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0016\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0017\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0018\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0019\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u001a\u001a\u0004\u0018\u00010\u001b8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0004\n\u0002\u0010\u001cR\u0016\u0010\u001d\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0004\n\u0002\u0010\nR\u0016\u0010\u001e\u001a\u0004\u0018\u00010\u001b8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0004\n\u0002\u0010\u001cR\u0016\u0010\u001f\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0004\n\u0002\u0010\u000fR\u0016\u0010 \u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0004\n\u0002\u0010\nR\u0016\u0010!\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0004\n\u0002\u0010\nR\u0014\u0010\"\u001a\u0004\u0018\u00010#8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006("}, d2 = {"Lcom/tencent/videocut/model/SpecialEffectModel$Builder;", "Lcom/squareup/wire/Message$Builder;", "Lcom/tencent/videocut/model/SpecialEffectModel;", "()V", "actionScope", "Lcom/tencent/videocut/model/ActionScope;", "animationMode", "Lcom/tencent/videocut/model/AnimationMode;", "bgColor", "", "Ljava/lang/Integer;", "categoryId", "", "createTimeMs", "", "Ljava/lang/Long;", "durationUs", AIAbilityModel.AI_KEY, "filePath", "id", "jsContentCache", "jsPath", "landscapeFilePath", DKConfiguration.PreloadKeys.KEY_MATERIAL_ID, "name", "portraitFilePath", "scale", "", "Ljava/lang/Float;", HippyQQPagViewController.PropertyName.SCALE_MODE, "scaleWithCrop", "startTimeUs", "temporary", "timeLineIndex", "type", "Lcom/tencent/videocut/model/SpecialEffectResType;", "(Ljava/lang/Integer;)Lcom/tencent/videocut/model/SpecialEffectModel$Builder;", "build", "(Ljava/lang/Long;)Lcom/tencent/videocut/model/SpecialEffectModel$Builder;", "(Ljava/lang/Float;)Lcom/tencent/videocut/model/SpecialEffectModel$Builder;", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes27.dex */
    public static final class Builder extends Message.Builder<SpecialEffectModel, Builder> {
        static IPatchRedirector $redirector_;

        @JvmField
        @Nullable
        public ActionScope actionScope;

        @JvmField
        @Nullable
        public AnimationMode animationMode;

        @JvmField
        @Nullable
        public Integer bgColor;

        @JvmField
        @Nullable
        public String categoryId;

        @JvmField
        @Nullable
        public Long createTimeMs;

        @JvmField
        @Nullable
        public Long durationUs;

        @JvmField
        @Nullable
        public Integer effectType;

        @JvmField
        @Nullable
        public String filePath;

        @JvmField
        @Nullable
        public String id;

        @JvmField
        @Nullable
        public String jsContentCache;

        @JvmField
        @Nullable
        public String jsPath;

        @JvmField
        @Nullable
        public String landscapeFilePath;

        @JvmField
        @Nullable
        public String materialId;

        @JvmField
        @Nullable
        public String name;

        @JvmField
        @Nullable
        public String portraitFilePath;

        @JvmField
        @Nullable
        public Float scale;

        @JvmField
        @Nullable
        public Integer scaleMode;

        @JvmField
        @Nullable
        public Float scaleWithCrop;

        @JvmField
        @Nullable
        public Long startTimeUs;

        @JvmField
        @Nullable
        public Integer temporary;

        @JvmField
        @Nullable
        public Integer timeLineIndex;

        @JvmField
        @Nullable
        public SpecialEffectResType type;

        public Builder() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @NotNull
        public final Builder actionScope(@Nullable ActionScope actionScope) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
                return (Builder) iPatchRedirector.redirect((short) 11, (Object) this, (Object) actionScope);
            }
            this.actionScope = actionScope;
            return this;
        }

        @NotNull
        public final Builder animationMode(@Nullable AnimationMode animationMode) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
                return (Builder) iPatchRedirector.redirect((short) 10, (Object) this, (Object) animationMode);
            }
            this.animationMode = animationMode;
            return this;
        }

        @NotNull
        public final Builder bgColor(@Nullable Integer bgColor) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (Builder) iPatchRedirector.redirect((short) 4, (Object) this, (Object) bgColor);
            }
            this.bgColor = bgColor;
            return this;
        }

        @NotNull
        public final Builder categoryId(@Nullable String categoryId) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
                return (Builder) iPatchRedirector.redirect((short) 14, (Object) this, (Object) categoryId);
            }
            this.categoryId = categoryId;
            return this;
        }

        @NotNull
        public final Builder createTimeMs(@Nullable Long createTimeMs) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return (Builder) iPatchRedirector.redirect((short) 7, (Object) this, (Object) createTimeMs);
            }
            this.createTimeMs = createTimeMs;
            return this;
        }

        @NotNull
        public final Builder durationUs(@Nullable Long durationUs) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return (Builder) iPatchRedirector.redirect((short) 6, (Object) this, (Object) durationUs);
            }
            this.durationUs = durationUs;
            return this;
        }

        @NotNull
        public final Builder effectType(@Nullable Integer effectType) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
                return (Builder) iPatchRedirector.redirect((short) 23, (Object) this, (Object) effectType);
            }
            this.effectType = effectType;
            return this;
        }

        @NotNull
        public final Builder filePath(@Nullable String filePath) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                return (Builder) iPatchRedirector.redirect((short) 9, (Object) this, (Object) filePath);
            }
            this.filePath = filePath;
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
        public final Builder jsContentCache(@Nullable String jsContentCache) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
                return (Builder) iPatchRedirector.redirect((short) 19, (Object) this, (Object) jsContentCache);
            }
            this.jsContentCache = jsContentCache;
            return this;
        }

        @NotNull
        public final Builder jsPath(@Nullable String jsPath) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
                return (Builder) iPatchRedirector.redirect((short) 18, (Object) this, (Object) jsPath);
            }
            this.jsPath = jsPath;
            return this;
        }

        @NotNull
        public final Builder landscapeFilePath(@Nullable String landscapeFilePath) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
                return (Builder) iPatchRedirector.redirect((short) 16, (Object) this, (Object) landscapeFilePath);
            }
            this.landscapeFilePath = landscapeFilePath;
            return this;
        }

        @NotNull
        public final Builder materialId(@Nullable String materialId) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
                return (Builder) iPatchRedirector.redirect((short) 13, (Object) this, (Object) materialId);
            }
            this.materialId = materialId;
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
        public final Builder portraitFilePath(@Nullable String portraitFilePath) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
                return (Builder) iPatchRedirector.redirect((short) 15, (Object) this, (Object) portraitFilePath);
            }
            this.portraitFilePath = portraitFilePath;
            return this;
        }

        @NotNull
        public final Builder scale(@Nullable Float scale) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                return (Builder) iPatchRedirector.redirect((short) 8, (Object) this, (Object) scale);
            }
            this.scale = scale;
            return this;
        }

        @NotNull
        public final Builder scaleMode(@Nullable Integer scaleMode) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
                return (Builder) iPatchRedirector.redirect((short) 20, (Object) this, (Object) scaleMode);
            }
            this.scaleMode = scaleMode;
            return this;
        }

        @NotNull
        public final Builder scaleWithCrop(@Nullable Float scaleWithCrop) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
                return (Builder) iPatchRedirector.redirect((short) 21, (Object) this, (Object) scaleWithCrop);
            }
            this.scaleWithCrop = scaleWithCrop;
            return this;
        }

        @NotNull
        public final Builder startTimeUs(@Nullable Long startTimeUs) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return (Builder) iPatchRedirector.redirect((short) 5, (Object) this, (Object) startTimeUs);
            }
            this.startTimeUs = startTimeUs;
            return this;
        }

        @NotNull
        public final Builder temporary(@Nullable Integer temporary) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
                return (Builder) iPatchRedirector.redirect((short) 22, (Object) this, (Object) temporary);
            }
            this.temporary = temporary;
            return this;
        }

        @NotNull
        public final Builder timeLineIndex(@Nullable Integer timeLineIndex) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
                return (Builder) iPatchRedirector.redirect((short) 12, (Object) this, (Object) timeLineIndex);
            }
            this.timeLineIndex = timeLineIndex;
            return this;
        }

        @NotNull
        public final Builder type(@Nullable SpecialEffectResType type) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
                return (Builder) iPatchRedirector.redirect((short) 17, (Object) this, (Object) type);
            }
            this.type = type;
            return this;
        }

        @Override // com.squareup.wire.Message.Builder
        @NotNull
        public SpecialEffectModel build() {
            IPatchRedirector iPatchRedirector = $redirector_;
            return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 24)) ? new SpecialEffectModel(this.id, this.name, this.bgColor, this.startTimeUs, this.durationUs, this.createTimeMs, this.scale, this.filePath, this.animationMode, this.actionScope, this.timeLineIndex, this.materialId, this.categoryId, this.portraitFilePath, this.landscapeFilePath, this.type, this.jsPath, this.jsContentCache, this.scaleMode, this.scaleWithCrop, this.temporary, this.effectType, buildUnknownFields()) : (SpecialEffectModel) iPatchRedirector.redirect((short) 24, (Object) this);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00078\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\n"}, d2 = {"Lcom/tencent/videocut/model/SpecialEffectModel$Companion;", "", "()V", "ADAPTER", "Lcom/squareup/wire/ProtoAdapter;", "Lcom/tencent/videocut/model/SpecialEffectModel;", "CREATOR", "Landroid/os/Parcelable$Creator;", "serialVersionUID", "", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes27.dex */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(59080);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 9)) {
            redirector.redirect((short) 9);
            return;
        }
        INSTANCE = new Companion(null);
        final FieldEncoding fieldEncoding = FieldEncoding.LENGTH_DELIMITED;
        final KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(SpecialEffectModel.class);
        ProtoAdapter<SpecialEffectModel> protoAdapter = new ProtoAdapter<SpecialEffectModel>(fieldEncoding, orCreateKotlinClass) { // from class: com.tencent.videocut.model.SpecialEffectModel$Companion$ADAPTER$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(fieldEncoding, orCreateKotlinClass, "type.googleapis.com/publisher.SpecialEffectModel");
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) fieldEncoding, (Object) orCreateKotlinClass);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            /* JADX WARN: Failed to find 'out' block for switch in B:11:0x004b. Please report as an issue. */
            @Override // com.squareup.wire.ProtoAdapter
            @NotNull
            public SpecialEffectModel decode(@NotNull ProtoReader reader) {
                AnimationMode animationMode;
                ActionScope actionScope;
                Integer num;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                    return (SpecialEffectModel) iPatchRedirector.redirect((short) 4, (Object) this, (Object) reader);
                }
                Intrinsics.checkNotNullParameter(reader, "reader");
                long beginMessage = reader.beginMessage();
                String str = null;
                String str2 = null;
                Integer num2 = null;
                Long l3 = null;
                Long l16 = null;
                Long l17 = null;
                Float f16 = null;
                String str3 = null;
                AnimationMode animationMode2 = null;
                ActionScope actionScope2 = null;
                Integer num3 = null;
                String str4 = null;
                String str5 = null;
                String str6 = null;
                String str7 = null;
                SpecialEffectResType specialEffectResType = null;
                String str8 = null;
                String str9 = null;
                Integer num4 = null;
                Float f17 = null;
                Integer num5 = null;
                Integer num6 = null;
                while (true) {
                    int nextTag = reader.nextTag();
                    if (nextTag != -1) {
                        switch (nextTag) {
                            case 1:
                                str = ProtoAdapter.STRING.decode(reader);
                                break;
                            case 2:
                                str2 = ProtoAdapter.STRING.decode(reader);
                                break;
                            case 3:
                                num2 = ProtoAdapter.INT32.decode(reader);
                                break;
                            case 4:
                                l3 = ProtoAdapter.INT64.decode(reader);
                                break;
                            case 5:
                                l16 = ProtoAdapter.INT64.decode(reader);
                                break;
                            case 6:
                                l17 = ProtoAdapter.INT64.decode(reader);
                                break;
                            case 7:
                                f16 = ProtoAdapter.FLOAT.decode(reader);
                                break;
                            case 8:
                                str3 = ProtoAdapter.STRING.decode(reader);
                                break;
                            case 9:
                                animationMode = animationMode2;
                                actionScope = actionScope2;
                                num = num3;
                                try {
                                    animationMode2 = AnimationMode.ADAPTER.decode(reader);
                                    num3 = num;
                                } catch (ProtoAdapter.EnumConstantNotFoundException e16) {
                                    reader.addUnknownField(nextTag, FieldEncoding.VARINT, Long.valueOf(e16.value));
                                    break;
                                }
                                actionScope2 = actionScope;
                                break;
                            case 10:
                                animationMode = animationMode2;
                                actionScope = actionScope2;
                                num = num3;
                                try {
                                    actionScope2 = ActionScope.ADAPTER.decode(reader);
                                    num3 = num;
                                    animationMode2 = animationMode;
                                    break;
                                } catch (ProtoAdapter.EnumConstantNotFoundException e17) {
                                    reader.addUnknownField(nextTag, FieldEncoding.VARINT, Long.valueOf(e17.value));
                                    break;
                                }
                            case 11:
                                num3 = ProtoAdapter.INT32.decode(reader);
                                break;
                            case 12:
                                str4 = ProtoAdapter.STRING.decode(reader);
                                break;
                            case 13:
                                str5 = ProtoAdapter.STRING.decode(reader);
                                break;
                            case 14:
                                str6 = ProtoAdapter.STRING.decode(reader);
                                break;
                            case 15:
                                str7 = ProtoAdapter.STRING.decode(reader);
                                break;
                            case 16:
                                try {
                                    specialEffectResType = SpecialEffectResType.ADAPTER.decode(reader);
                                    break;
                                } catch (ProtoAdapter.EnumConstantNotFoundException e18) {
                                    num = num3;
                                    animationMode = animationMode2;
                                    actionScope = actionScope2;
                                    reader.addUnknownField(nextTag, FieldEncoding.VARINT, Long.valueOf(e18.value));
                                    break;
                                }
                            case 17:
                                str8 = ProtoAdapter.STRING.decode(reader);
                                break;
                            case 18:
                                str9 = ProtoAdapter.STRING.decode(reader);
                                break;
                            case 19:
                                num4 = ProtoAdapter.INT32.decode(reader);
                                break;
                            case 20:
                                f17 = ProtoAdapter.FLOAT.decode(reader);
                                break;
                            case 21:
                                num5 = ProtoAdapter.INT32.decode(reader);
                                break;
                            case 22:
                                num6 = ProtoAdapter.INT32.decode(reader);
                                break;
                            default:
                                animationMode = animationMode2;
                                actionScope = actionScope2;
                                num = num3;
                                reader.readUnknownField(nextTag);
                                num3 = num;
                                animationMode2 = animationMode;
                                actionScope2 = actionScope;
                                break;
                        }
                    } else {
                        return new SpecialEffectModel(str, str2, num2, l3, l16, l17, f16, str3, animationMode2, actionScope2, num3, str4, str5, str6, str7, specialEffectResType, str8, str9, num4, f17, num5, num6, reader.endMessageAndGetUnknownFields(beginMessage));
                    }
                }
            }

            @Override // com.squareup.wire.ProtoAdapter
            public void encode(@NotNull ProtoWriter writer, @NotNull SpecialEffectModel value) {
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
                ProtoAdapter<Integer> protoAdapter3 = ProtoAdapter.INT32;
                protoAdapter3.encodeWithTag(writer, 3, value.bgColor);
                ProtoAdapter<Long> protoAdapter4 = ProtoAdapter.INT64;
                protoAdapter4.encodeWithTag(writer, 4, value.startTimeUs);
                protoAdapter4.encodeWithTag(writer, 5, value.durationUs);
                protoAdapter4.encodeWithTag(writer, 6, value.createTimeMs);
                ProtoAdapter<Float> protoAdapter5 = ProtoAdapter.FLOAT;
                protoAdapter5.encodeWithTag(writer, 7, value.scale);
                protoAdapter2.encodeWithTag(writer, 8, value.filePath);
                AnimationMode.ADAPTER.encodeWithTag(writer, 9, value.animationMode);
                ActionScope.ADAPTER.encodeWithTag(writer, 10, value.actionScope);
                protoAdapter3.encodeWithTag(writer, 11, value.timeLineIndex);
                protoAdapter2.encodeWithTag(writer, 12, value.materialId);
                protoAdapter2.encodeWithTag(writer, 13, value.categoryId);
                protoAdapter2.encodeWithTag(writer, 14, value.portraitFilePath);
                protoAdapter2.encodeWithTag(writer, 15, value.landscapeFilePath);
                SpecialEffectResType.ADAPTER.encodeWithTag(writer, 16, value.type);
                protoAdapter2.encodeWithTag(writer, 17, value.jsPath);
                protoAdapter2.encodeWithTag(writer, 18, value.jsContentCache);
                protoAdapter3.encodeWithTag(writer, 19, value.scaleMode);
                protoAdapter5.encodeWithTag(writer, 20, value.scaleWithCrop);
                protoAdapter3.encodeWithTag(writer, 21, value.temporary);
                protoAdapter3.encodeWithTag(writer, 22, value.effectType);
                writer.writeBytes(value.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public int encodedSize(@NotNull SpecialEffectModel value) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this, (Object) value)).intValue();
                }
                Intrinsics.checkNotNullParameter(value, "value");
                ProtoAdapter<String> protoAdapter2 = ProtoAdapter.STRING;
                int encodedSizeWithTag = protoAdapter2.encodedSizeWithTag(1, value.id) + protoAdapter2.encodedSizeWithTag(2, value.name);
                ProtoAdapter<Integer> protoAdapter3 = ProtoAdapter.INT32;
                int encodedSizeWithTag2 = encodedSizeWithTag + protoAdapter3.encodedSizeWithTag(3, value.bgColor);
                ProtoAdapter<Long> protoAdapter4 = ProtoAdapter.INT64;
                int encodedSizeWithTag3 = encodedSizeWithTag2 + protoAdapter4.encodedSizeWithTag(4, value.startTimeUs) + protoAdapter4.encodedSizeWithTag(5, value.durationUs) + protoAdapter4.encodedSizeWithTag(6, value.createTimeMs);
                ProtoAdapter<Float> protoAdapter5 = ProtoAdapter.FLOAT;
                return encodedSizeWithTag3 + protoAdapter5.encodedSizeWithTag(7, value.scale) + protoAdapter2.encodedSizeWithTag(8, value.filePath) + AnimationMode.ADAPTER.encodedSizeWithTag(9, value.animationMode) + ActionScope.ADAPTER.encodedSizeWithTag(10, value.actionScope) + protoAdapter3.encodedSizeWithTag(11, value.timeLineIndex) + protoAdapter2.encodedSizeWithTag(12, value.materialId) + protoAdapter2.encodedSizeWithTag(13, value.categoryId) + protoAdapter2.encodedSizeWithTag(14, value.portraitFilePath) + protoAdapter2.encodedSizeWithTag(15, value.landscapeFilePath) + SpecialEffectResType.ADAPTER.encodedSizeWithTag(16, value.type) + protoAdapter2.encodedSizeWithTag(17, value.jsPath) + protoAdapter2.encodedSizeWithTag(18, value.jsContentCache) + protoAdapter3.encodedSizeWithTag(19, value.scaleMode) + protoAdapter5.encodedSizeWithTag(20, value.scaleWithCrop) + protoAdapter3.encodedSizeWithTag(21, value.temporary) + protoAdapter3.encodedSizeWithTag(22, value.effectType) + value.unknownFields().size();
            }

            @Override // com.squareup.wire.ProtoAdapter
            @NotNull
            public SpecialEffectModel redact(@NotNull SpecialEffectModel value) {
                SpecialEffectModel copy;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                    return (SpecialEffectModel) iPatchRedirector.redirect((short) 5, (Object) this, (Object) value);
                }
                Intrinsics.checkNotNullParameter(value, "value");
                copy = value.copy((r41 & 1) != 0 ? value.id : null, (r41 & 2) != 0 ? value.name : null, (r41 & 4) != 0 ? value.bgColor : null, (r41 & 8) != 0 ? value.startTimeUs : null, (r41 & 16) != 0 ? value.durationUs : null, (r41 & 32) != 0 ? value.createTimeMs : null, (r41 & 64) != 0 ? value.scale : null, (r41 & 128) != 0 ? value.filePath : null, (r41 & 256) != 0 ? value.animationMode : null, (r41 & 512) != 0 ? value.actionScope : null, (r41 & 1024) != 0 ? value.timeLineIndex : null, (r41 & 2048) != 0 ? value.materialId : null, (r41 & 4096) != 0 ? value.categoryId : null, (r41 & 8192) != 0 ? value.portraitFilePath : null, (r41 & 16384) != 0 ? value.landscapeFilePath : null, (r41 & 32768) != 0 ? value.type : null, (r41 & 65536) != 0 ? value.jsPath : null, (r41 & 131072) != 0 ? value.jsContentCache : null, (r41 & 262144) != 0 ? value.scaleMode : null, (r41 & 524288) != 0 ? value.scaleWithCrop : null, (r41 & 1048576) != 0 ? value.temporary : null, (r41 & 2097152) != 0 ? value.effectType : null, (r41 & 4194304) != 0 ? value.unknownFields() : ByteString.EMPTY);
                return copy;
            }
        };
        ADAPTER = protoAdapter;
        CREATOR = AndroidMessage.INSTANCE.newCreator(protoAdapter);
    }

    public SpecialEffectModel() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 8388607, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 8)) {
            return;
        }
        iPatchRedirector.redirect((short) 8, (Object) this);
    }

    @NotNull
    public final SpecialEffectModel copy(@Nullable String id5, @Nullable String name, @Nullable Integer bgColor, @Nullable Long startTimeUs, @Nullable Long durationUs, @Nullable Long createTimeMs, @Nullable Float scale, @Nullable String filePath, @Nullable AnimationMode animationMode, @Nullable ActionScope actionScope, @Nullable Integer timeLineIndex, @Nullable String materialId, @Nullable String categoryId, @Nullable String portraitFilePath, @Nullable String landscapeFilePath, @Nullable SpecialEffectResType type, @Nullable String jsPath, @Nullable String jsContentCache, @Nullable Integer scaleMode, @Nullable Float scaleWithCrop, @Nullable Integer temporary, @Nullable Integer effectType, @NotNull ByteString unknownFields) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (SpecialEffectModel) iPatchRedirector.redirect((short) 7, this, id5, name, bgColor, startTimeUs, durationUs, createTimeMs, scale, filePath, animationMode, actionScope, timeLineIndex, materialId, categoryId, portraitFilePath, landscapeFilePath, type, jsPath, jsContentCache, scaleMode, scaleWithCrop, temporary, effectType, unknownFields);
        }
        Intrinsics.checkNotNullParameter(unknownFields, "unknownFields");
        return new SpecialEffectModel(id5, name, bgColor, startTimeUs, durationUs, createTimeMs, scale, filePath, animationMode, actionScope, timeLineIndex, materialId, categoryId, portraitFilePath, landscapeFilePath, type, jsPath, jsContentCache, scaleMode, scaleWithCrop, temporary, effectType, unknownFields);
    }

    public boolean equals(@Nullable Object other) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, other)).booleanValue();
        }
        if (other == this) {
            return true;
        }
        if (!(other instanceof SpecialEffectModel)) {
            return false;
        }
        SpecialEffectModel specialEffectModel = (SpecialEffectModel) other;
        if (Intrinsics.areEqual(unknownFields(), specialEffectModel.unknownFields()) && Intrinsics.areEqual(this.id, specialEffectModel.id) && Intrinsics.areEqual(this.name, specialEffectModel.name) && Intrinsics.areEqual(this.bgColor, specialEffectModel.bgColor) && Intrinsics.areEqual(this.startTimeUs, specialEffectModel.startTimeUs) && Intrinsics.areEqual(this.durationUs, specialEffectModel.durationUs) && Intrinsics.areEqual(this.createTimeMs, specialEffectModel.createTimeMs) && Intrinsics.areEqual(this.scale, specialEffectModel.scale) && Intrinsics.areEqual(this.filePath, specialEffectModel.filePath) && this.animationMode == specialEffectModel.animationMode && this.actionScope == specialEffectModel.actionScope && Intrinsics.areEqual(this.timeLineIndex, specialEffectModel.timeLineIndex) && Intrinsics.areEqual(this.materialId, specialEffectModel.materialId) && Intrinsics.areEqual(this.categoryId, specialEffectModel.categoryId) && Intrinsics.areEqual(this.portraitFilePath, specialEffectModel.portraitFilePath) && Intrinsics.areEqual(this.landscapeFilePath, specialEffectModel.landscapeFilePath) && this.type == specialEffectModel.type && Intrinsics.areEqual(this.jsPath, specialEffectModel.jsPath) && Intrinsics.areEqual(this.jsContentCache, specialEffectModel.jsContentCache) && Intrinsics.areEqual(this.scaleMode, specialEffectModel.scaleMode) && Intrinsics.areEqual(this.scaleWithCrop, specialEffectModel.scaleWithCrop) && Intrinsics.areEqual(this.temporary, specialEffectModel.temporary) && Intrinsics.areEqual(this.effectType, specialEffectModel.effectType)) {
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
        int i38;
        int i39;
        int i46;
        int i47;
        int i48;
        int i49;
        int i56;
        int i57;
        int i58;
        int i59;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
        }
        int i65 = this.hashCode;
        if (i65 == 0) {
            int hashCode = unknownFields().hashCode() * 37;
            String str = this.id;
            int i66 = 0;
            if (str != null) {
                i3 = str.hashCode();
            } else {
                i3 = 0;
            }
            int i67 = (hashCode + i3) * 37;
            String str2 = this.name;
            if (str2 != null) {
                i16 = str2.hashCode();
            } else {
                i16 = 0;
            }
            int i68 = (i67 + i16) * 37;
            Integer num = this.bgColor;
            if (num != null) {
                i17 = num.hashCode();
            } else {
                i17 = 0;
            }
            int i69 = (i68 + i17) * 37;
            Long l3 = this.startTimeUs;
            if (l3 != null) {
                i18 = l3.hashCode();
            } else {
                i18 = 0;
            }
            int i75 = (i69 + i18) * 37;
            Long l16 = this.durationUs;
            if (l16 != null) {
                i19 = l16.hashCode();
            } else {
                i19 = 0;
            }
            int i76 = (i75 + i19) * 37;
            Long l17 = this.createTimeMs;
            if (l17 != null) {
                i26 = l17.hashCode();
            } else {
                i26 = 0;
            }
            int i77 = (i76 + i26) * 37;
            Float f16 = this.scale;
            if (f16 != null) {
                i27 = f16.hashCode();
            } else {
                i27 = 0;
            }
            int i78 = (i77 + i27) * 37;
            String str3 = this.filePath;
            if (str3 != null) {
                i28 = str3.hashCode();
            } else {
                i28 = 0;
            }
            int i79 = (i78 + i28) * 37;
            AnimationMode animationMode = this.animationMode;
            if (animationMode != null) {
                i29 = animationMode.hashCode();
            } else {
                i29 = 0;
            }
            int i85 = (i79 + i29) * 37;
            ActionScope actionScope = this.actionScope;
            if (actionScope != null) {
                i36 = actionScope.hashCode();
            } else {
                i36 = 0;
            }
            int i86 = (i85 + i36) * 37;
            Integer num2 = this.timeLineIndex;
            if (num2 != null) {
                i37 = num2.hashCode();
            } else {
                i37 = 0;
            }
            int i87 = (i86 + i37) * 37;
            String str4 = this.materialId;
            if (str4 != null) {
                i38 = str4.hashCode();
            } else {
                i38 = 0;
            }
            int i88 = (i87 + i38) * 37;
            String str5 = this.categoryId;
            if (str5 != null) {
                i39 = str5.hashCode();
            } else {
                i39 = 0;
            }
            int i89 = (i88 + i39) * 37;
            String str6 = this.portraitFilePath;
            if (str6 != null) {
                i46 = str6.hashCode();
            } else {
                i46 = 0;
            }
            int i95 = (i89 + i46) * 37;
            String str7 = this.landscapeFilePath;
            if (str7 != null) {
                i47 = str7.hashCode();
            } else {
                i47 = 0;
            }
            int i96 = (i95 + i47) * 37;
            SpecialEffectResType specialEffectResType = this.type;
            if (specialEffectResType != null) {
                i48 = specialEffectResType.hashCode();
            } else {
                i48 = 0;
            }
            int i97 = (i96 + i48) * 37;
            String str8 = this.jsPath;
            if (str8 != null) {
                i49 = str8.hashCode();
            } else {
                i49 = 0;
            }
            int i98 = (i97 + i49) * 37;
            String str9 = this.jsContentCache;
            if (str9 != null) {
                i56 = str9.hashCode();
            } else {
                i56 = 0;
            }
            int i99 = (i98 + i56) * 37;
            Integer num3 = this.scaleMode;
            if (num3 != null) {
                i57 = num3.hashCode();
            } else {
                i57 = 0;
            }
            int i100 = (i99 + i57) * 37;
            Float f17 = this.scaleWithCrop;
            if (f17 != null) {
                i58 = f17.hashCode();
            } else {
                i58 = 0;
            }
            int i101 = (i100 + i58) * 37;
            Integer num4 = this.temporary;
            if (num4 != null) {
                i59 = num4.hashCode();
            } else {
                i59 = 0;
            }
            int i102 = (i101 + i59) * 37;
            Integer num5 = this.effectType;
            if (num5 != null) {
                i66 = num5.hashCode();
            }
            int i103 = i102 + i66;
            this.hashCode = i103;
            return i103;
        }
        return i65;
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
        Integer num = this.bgColor;
        if (num != null) {
            arrayList.add("bgColor=" + num);
        }
        Long l3 = this.startTimeUs;
        if (l3 != null) {
            arrayList.add("startTimeUs=" + l3);
        }
        Long l16 = this.durationUs;
        if (l16 != null) {
            arrayList.add("durationUs=" + l16);
        }
        Long l17 = this.createTimeMs;
        if (l17 != null) {
            arrayList.add("createTimeMs=" + l17);
        }
        Float f16 = this.scale;
        if (f16 != null) {
            arrayList.add("scale=" + f16);
        }
        String str3 = this.filePath;
        if (str3 != null) {
            arrayList.add("filePath=" + Internal.sanitize(str3));
        }
        AnimationMode animationMode = this.animationMode;
        if (animationMode != null) {
            arrayList.add("animationMode=" + animationMode);
        }
        ActionScope actionScope = this.actionScope;
        if (actionScope != null) {
            arrayList.add("actionScope=" + actionScope);
        }
        Integer num2 = this.timeLineIndex;
        if (num2 != null) {
            arrayList.add("timeLineIndex=" + num2);
        }
        String str4 = this.materialId;
        if (str4 != null) {
            arrayList.add("materialId=" + Internal.sanitize(str4));
        }
        String str5 = this.categoryId;
        if (str5 != null) {
            arrayList.add("categoryId=" + Internal.sanitize(str5));
        }
        String str6 = this.portraitFilePath;
        if (str6 != null) {
            arrayList.add("portraitFilePath=" + Internal.sanitize(str6));
        }
        String str7 = this.landscapeFilePath;
        if (str7 != null) {
            arrayList.add("landscapeFilePath=" + Internal.sanitize(str7));
        }
        SpecialEffectResType specialEffectResType = this.type;
        if (specialEffectResType != null) {
            arrayList.add("type=" + specialEffectResType);
        }
        String str8 = this.jsPath;
        if (str8 != null) {
            arrayList.add("jsPath=" + Internal.sanitize(str8));
        }
        String str9 = this.jsContentCache;
        if (str9 != null) {
            arrayList.add("jsContentCache=" + Internal.sanitize(str9));
        }
        Integer num3 = this.scaleMode;
        if (num3 != null) {
            arrayList.add("scaleMode=" + num3);
        }
        Float f17 = this.scaleWithCrop;
        if (f17 != null) {
            arrayList.add("scaleWithCrop=" + f17);
        }
        Integer num4 = this.temporary;
        if (num4 != null) {
            arrayList.add("temporary=" + num4);
        }
        Integer num5 = this.effectType;
        if (num5 != null) {
            arrayList.add("effectType=" + num5);
        }
        joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(arrayList, ", ", "SpecialEffectModel{", "}", 0, null, null, 56, null);
        return joinToString$default;
    }

    public /* synthetic */ SpecialEffectModel(String str, String str2, Integer num, Long l3, Long l16, Long l17, Float f16, String str3, AnimationMode animationMode, ActionScope actionScope, Integer num2, String str4, String str5, String str6, String str7, SpecialEffectResType specialEffectResType, String str8, String str9, Integer num3, Float f17, Integer num4, Integer num5, ByteString byteString, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? null : str, (i3 & 2) != 0 ? null : str2, (i3 & 4) != 0 ? null : num, (i3 & 8) != 0 ? null : l3, (i3 & 16) != 0 ? null : l16, (i3 & 32) != 0 ? null : l17, (i3 & 64) != 0 ? null : f16, (i3 & 128) != 0 ? null : str3, (i3 & 256) != 0 ? null : animationMode, (i3 & 512) != 0 ? null : actionScope, (i3 & 1024) != 0 ? null : num2, (i3 & 2048) != 0 ? null : str4, (i3 & 4096) != 0 ? null : str5, (i3 & 8192) != 0 ? null : str6, (i3 & 16384) != 0 ? null : str7, (32768 & i3) != 0 ? null : specialEffectResType, (65536 & i3) != 0 ? null : str8, (131072 & i3) != 0 ? null : str9, (262144 & i3) != 0 ? null : num3, (524288 & i3) != 0 ? null : f17, (1048576 & i3) != 0 ? null : num4, (2097152 & i3) != 0 ? null : num5, (4194304 & i3) != 0 ? ByteString.EMPTY : byteString);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, str, str2, num, l3, l16, l17, f16, str3, animationMode, actionScope, num2, str4, str5, str6, str7, specialEffectResType, str8, str9, num3, f17, num4, num5, byteString, Integer.valueOf(i3), defaultConstructorMarker);
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
        builder.bgColor = this.bgColor;
        builder.startTimeUs = this.startTimeUs;
        builder.durationUs = this.durationUs;
        builder.createTimeMs = this.createTimeMs;
        builder.scale = this.scale;
        builder.filePath = this.filePath;
        builder.animationMode = this.animationMode;
        builder.actionScope = this.actionScope;
        builder.timeLineIndex = this.timeLineIndex;
        builder.materialId = this.materialId;
        builder.categoryId = this.categoryId;
        builder.portraitFilePath = this.portraitFilePath;
        builder.landscapeFilePath = this.landscapeFilePath;
        builder.type = this.type;
        builder.jsPath = this.jsPath;
        builder.jsContentCache = this.jsContentCache;
        builder.scaleMode = this.scaleMode;
        builder.scaleWithCrop = this.scaleWithCrop;
        builder.temporary = this.temporary;
        builder.effectType = this.effectType;
        builder.addUnknownFields(unknownFields());
        return builder;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SpecialEffectModel(@Nullable String str, @Nullable String str2, @Nullable Integer num, @Nullable Long l3, @Nullable Long l16, @Nullable Long l17, @Nullable Float f16, @Nullable String str3, @Nullable AnimationMode animationMode, @Nullable ActionScope actionScope, @Nullable Integer num2, @Nullable String str4, @Nullable String str5, @Nullable String str6, @Nullable String str7, @Nullable SpecialEffectResType specialEffectResType, @Nullable String str8, @Nullable String str9, @Nullable Integer num3, @Nullable Float f17, @Nullable Integer num4, @Nullable Integer num5, @NotNull ByteString unknownFields) {
        super(ADAPTER, unknownFields);
        Intrinsics.checkNotNullParameter(unknownFields, "unknownFields");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, str, str2, num, l3, l16, l17, f16, str3, animationMode, actionScope, num2, str4, str5, str6, str7, specialEffectResType, str8, str9, num3, f17, num4, num5, unknownFields);
            return;
        }
        this.id = str;
        this.name = str2;
        this.bgColor = num;
        this.startTimeUs = l3;
        this.durationUs = l16;
        this.createTimeMs = l17;
        this.scale = f16;
        this.filePath = str3;
        this.animationMode = animationMode;
        this.actionScope = actionScope;
        this.timeLineIndex = num2;
        this.materialId = str4;
        this.categoryId = str5;
        this.portraitFilePath = str6;
        this.landscapeFilePath = str7;
        this.type = specialEffectResType;
        this.jsPath = str8;
        this.jsContentCache = str9;
        this.scaleMode = num3;
        this.scaleWithCrop = f17;
        this.temporary = num4;
        this.effectType = num5;
    }
}
