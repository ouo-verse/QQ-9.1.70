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
import com.tencent.ams.dsdk.core.DKConfiguration;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
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
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0010\u0018\u0000 02\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u000212B\u00e9\u0001\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0013\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0016\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0018\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u001f\u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\n\u0012\b\b\u0002\u0010$\u001a\u00020#\u00a2\u0006\u0004\b.\u0010/J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0013\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0096\u0002J\b\u0010\t\u001a\u00020\bH\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016J\u00ef\u0001\u0010%\u001a\u00020\u00002\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00162\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00182\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u001f2\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010$\u001a\u00020#\u00a2\u0006\u0004\b%\u0010&R\u0016\u0010\f\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010'R\u0016\u0010\r\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010'R\u0016\u0010\u000e\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010(R\u0016\u0010\u0010\u001a\u0004\u0018\u00010\u000f8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010)R\u0016\u0010\u0011\u001a\u0004\u0018\u00010\u000f8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010)R\u0016\u0010\u0012\u001a\u0004\u0018\u00010\u000f8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010)R\u0016\u0010\u0014\u001a\u0004\u0018\u00010\u00138\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010*R\u0016\u0010\u0015\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010'R\u0016\u0010\u0017\u001a\u0004\u0018\u00010\u00168\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0017\u0010+R\u0016\u0010\u0019\u001a\u0004\u0018\u00010\u00188\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010,R\u0016\u0010\u001a\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u001a\u0010(R\u0016\u0010\u001b\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u001b\u0010'R\u0016\u0010\u001c\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u001c\u0010'R\u0016\u0010\u001d\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u001d\u0010'R\u0016\u0010\u001e\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u001e\u0010'R\u0016\u0010 \u001a\u0004\u0018\u00010\u001f8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b \u0010-R\u0016\u0010!\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b!\u0010'R\u0016\u0010\"\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\"\u0010'\u00a8\u00063"}, d2 = {"Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/SpecialEffectModel;", "Lcom/squareup/wire/AndroidMessage;", "Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/SpecialEffectModel$a;", "newBuilder", "", "other", "", "equals", "", "hashCode", "", "toString", "id", "name", "bgColor", "", "startTimeUs", "durationUs", "createTimeMs", "", "scale", "filePath", "Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/AnimationMode;", "animationMode", "Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/ActionScope;", "actionScope", "timeLineIndex", DKConfiguration.PreloadKeys.KEY_MATERIAL_ID, "categoryId", "portraitFilePath", "landscapeFilePath", "Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/SpecialEffectResType;", "type", "jsPath", "jsContentCache", "Lokio/ByteString;", "unknownFields", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Float;Ljava/lang/String;Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/AnimationMode;Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/ActionScope;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/SpecialEffectResType;Ljava/lang/String;Ljava/lang/String;Lokio/ByteString;)Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/SpecialEffectModel;", "Ljava/lang/String;", "Ljava/lang/Integer;", "Ljava/lang/Long;", "Ljava/lang/Float;", "Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/AnimationMode;", "Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/ActionScope;", "Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/SpecialEffectResType;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Float;Ljava/lang/String;Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/AnimationMode;Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/ActionScope;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/SpecialEffectResType;Ljava/lang/String;Ljava/lang/String;Lokio/ByteString;)V", "Companion", "a", "c", "qqvideoedit_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class SpecialEffectModel extends AndroidMessage<SpecialEffectModel, a> {

    @JvmField
    @NotNull
    public static final ProtoAdapter<SpecialEffectModel> ADAPTER;

    @JvmField
    @NotNull
    public static final Parcelable.Creator<SpecialEffectModel> CREATOR;

    @WireField(adapter = "com.tencent.mobileqq.qqvideoedit.thirdparty.videocut.model.ActionScope#ADAPTER", tag = 10)
    @JvmField
    @Nullable
    public final ActionScope actionScope;

    @WireField(adapter = "com.tencent.mobileqq.qqvideoedit.thirdparty.videocut.model.AnimationMode#ADAPTER", tag = 9)
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

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT64", tag = 4)
    @JvmField
    @Nullable
    public final Long startTimeUs;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 11)
    @JvmField
    @Nullable
    public final Integer timeLineIndex;

    @WireField(adapter = "com.tencent.mobileqq.qqvideoedit.thirdparty.videocut.model.SpecialEffectResType#ADAPTER", tag = 16)
    @JvmField
    @Nullable
    public final SpecialEffectResType type;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\u00a2\u0006\u0004\b5\u00106J\b\u0010\u0003\u001a\u00020\u0002H\u0016R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0005R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0005R\u0018\u0010\f\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0018\u0010\u0010\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0018\u0010\u0012\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u000fR\u0018\u0010\u0014\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u000fR\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00158\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u0005R\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u001b8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0018\u0010\"\u001a\u0004\u0018\u00010\u001f8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b \u0010!R\u0018\u0010$\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b#\u0010\u000bR\u0018\u0010&\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b%\u0010\u0005R\u0018\u0010(\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010\u0005R\u0018\u0010*\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b)\u0010\u0005R\u0018\u0010,\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b+\u0010\u0005R\u0018\u00100\u001a\u0004\u0018\u00010-8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b.\u0010/R\u0018\u00102\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b1\u0010\u0005R\u0018\u00104\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b3\u0010\u0005\u00a8\u00067"}, d2 = {"Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/SpecialEffectModel$a;", "Lcom/squareup/wire/Message$Builder;", "Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/SpecialEffectModel;", "a", "", "Ljava/lang/String;", "id", "b", "name", "", "c", "Ljava/lang/Integer;", "bgColor", "", "d", "Ljava/lang/Long;", "startTimeUs", "e", "durationUs", "f", "createTimeMs", "", "g", "Ljava/lang/Float;", "scale", h.F, "filePath", "Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/AnimationMode;", "i", "Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/AnimationMode;", "animationMode", "Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/ActionScope;", "j", "Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/ActionScope;", "actionScope", "k", "timeLineIndex", "l", DKConfiguration.PreloadKeys.KEY_MATERIAL_ID, QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "categoryId", DomainData.DOMAIN_NAME, "portraitFilePath", "o", "landscapeFilePath", "Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/SpecialEffectResType;", "p", "Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/SpecialEffectResType;", "type", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "jsPath", "r", "jsContentCache", "<init>", "()V", "qqvideoedit_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes17.dex */
    public static final class a extends Message.Builder<SpecialEffectModel, a> {

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
        public Integer bgColor;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @JvmField
        @Nullable
        public Long startTimeUs;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        @JvmField
        @Nullable
        public Long durationUs;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        @JvmField
        @Nullable
        public Long createTimeMs;

        /* renamed from: g, reason: collision with root package name and from kotlin metadata */
        @JvmField
        @Nullable
        public Float scale;

        /* renamed from: h, reason: collision with root package name and from kotlin metadata */
        @JvmField
        @Nullable
        public String filePath;

        /* renamed from: i, reason: collision with root package name and from kotlin metadata */
        @JvmField
        @Nullable
        public AnimationMode animationMode;

        /* renamed from: j, reason: collision with root package name and from kotlin metadata */
        @JvmField
        @Nullable
        public ActionScope actionScope;

        /* renamed from: k, reason: collision with root package name and from kotlin metadata */
        @JvmField
        @Nullable
        public Integer timeLineIndex;

        /* renamed from: l, reason: collision with root package name and from kotlin metadata */
        @JvmField
        @Nullable
        public String materialId;

        /* renamed from: m, reason: collision with root package name and from kotlin metadata */
        @JvmField
        @Nullable
        public String categoryId;

        /* renamed from: n, reason: collision with root package name and from kotlin metadata */
        @JvmField
        @Nullable
        public String portraitFilePath;

        /* renamed from: o, reason: collision with root package name and from kotlin metadata */
        @JvmField
        @Nullable
        public String landscapeFilePath;

        /* renamed from: p, reason: collision with root package name and from kotlin metadata */
        @JvmField
        @Nullable
        public SpecialEffectResType type;

        /* renamed from: q, reason: collision with root package name and from kotlin metadata */
        @JvmField
        @Nullable
        public String jsPath;

        /* renamed from: r, reason: collision with root package name and from kotlin metadata */
        @JvmField
        @Nullable
        public String jsContentCache;

        @Override // com.squareup.wire.Message.Builder
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public SpecialEffectModel build() {
            return new SpecialEffectModel(this.id, this.name, this.bgColor, this.startTimeUs, this.durationUs, this.createTimeMs, this.scale, this.filePath, this.animationMode, this.actionScope, this.timeLineIndex, this.materialId, this.categoryId, this.portraitFilePath, this.landscapeFilePath, this.type, this.jsPath, this.jsContentCache, buildUnknownFields());
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\f\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u0010\u0010\r\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u000e"}, d2 = {"com/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/SpecialEffectModel$b", "Lcom/squareup/wire/ProtoAdapter;", "Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/SpecialEffectModel;", "value", "", "c", "Lcom/squareup/wire/ProtoWriter;", "writer", "", "b", "Lcom/squareup/wire/ProtoReader;", "reader", "a", "d", "qqvideoedit_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes17.dex */
    public static final class b extends ProtoAdapter<SpecialEffectModel> {
        b(FieldEncoding fieldEncoding, KClass<SpecialEffectModel> kClass) {
            super(fieldEncoding, kClass, "type.googleapis.com/publisher.SpecialEffectModel");
        }

        /* JADX WARN: Failed to find 'out' block for switch in B:4:0x002d. Please report as an issue. */
        @Override // com.squareup.wire.ProtoAdapter
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public SpecialEffectModel decode(@NotNull ProtoReader reader) {
            AnimationMode animationMode;
            ActionScope actionScope;
            Integer num;
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
            SpecialEffectResType specialEffectResType = null;
            String str7 = null;
            String str8 = null;
            String str9 = null;
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
                            str9 = ProtoAdapter.STRING.decode(reader);
                            break;
                        case 13:
                            str4 = ProtoAdapter.STRING.decode(reader);
                            break;
                        case 14:
                            str5 = ProtoAdapter.STRING.decode(reader);
                            break;
                        case 15:
                            str6 = ProtoAdapter.STRING.decode(reader);
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
                            str7 = ProtoAdapter.STRING.decode(reader);
                            break;
                        case 18:
                            str8 = ProtoAdapter.STRING.decode(reader);
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
                    return new SpecialEffectModel(str, str2, num2, l3, l16, l17, f16, str3, animationMode2, actionScope2, num3, str9, str4, str5, str6, specialEffectResType, str7, str8, reader.endMessageAndGetUnknownFields(beginMessage));
                }
            }
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void encode(@NotNull ProtoWriter writer, @NotNull SpecialEffectModel value) {
            Intrinsics.checkNotNullParameter(writer, "writer");
            Intrinsics.checkNotNullParameter(value, "value");
            ProtoAdapter<String> protoAdapter = ProtoAdapter.STRING;
            protoAdapter.encodeWithTag(writer, 1, value.id);
            protoAdapter.encodeWithTag(writer, 2, value.name);
            ProtoAdapter<Integer> protoAdapter2 = ProtoAdapter.INT32;
            protoAdapter2.encodeWithTag(writer, 3, value.bgColor);
            ProtoAdapter<Long> protoAdapter3 = ProtoAdapter.INT64;
            protoAdapter3.encodeWithTag(writer, 4, value.startTimeUs);
            protoAdapter3.encodeWithTag(writer, 5, value.durationUs);
            protoAdapter3.encodeWithTag(writer, 6, value.createTimeMs);
            ProtoAdapter.FLOAT.encodeWithTag(writer, 7, value.scale);
            protoAdapter.encodeWithTag(writer, 8, value.filePath);
            AnimationMode.ADAPTER.encodeWithTag(writer, 9, value.animationMode);
            ActionScope.ADAPTER.encodeWithTag(writer, 10, value.actionScope);
            protoAdapter2.encodeWithTag(writer, 11, value.timeLineIndex);
            protoAdapter.encodeWithTag(writer, 12, value.materialId);
            protoAdapter.encodeWithTag(writer, 13, value.categoryId);
            protoAdapter.encodeWithTag(writer, 14, value.portraitFilePath);
            protoAdapter.encodeWithTag(writer, 15, value.landscapeFilePath);
            SpecialEffectResType.ADAPTER.encodeWithTag(writer, 16, value.type);
            protoAdapter.encodeWithTag(writer, 17, value.jsPath);
            protoAdapter.encodeWithTag(writer, 18, value.jsContentCache);
            writer.writeBytes(value.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public int encodedSize(@NotNull SpecialEffectModel value) {
            Intrinsics.checkNotNullParameter(value, "value");
            ProtoAdapter<String> protoAdapter = ProtoAdapter.STRING;
            int encodedSizeWithTag = protoAdapter.encodedSizeWithTag(1, value.id) + protoAdapter.encodedSizeWithTag(2, value.name);
            ProtoAdapter<Integer> protoAdapter2 = ProtoAdapter.INT32;
            int encodedSizeWithTag2 = encodedSizeWithTag + protoAdapter2.encodedSizeWithTag(3, value.bgColor);
            ProtoAdapter<Long> protoAdapter3 = ProtoAdapter.INT64;
            return encodedSizeWithTag2 + protoAdapter3.encodedSizeWithTag(4, value.startTimeUs) + protoAdapter3.encodedSizeWithTag(5, value.durationUs) + protoAdapter3.encodedSizeWithTag(6, value.createTimeMs) + ProtoAdapter.FLOAT.encodedSizeWithTag(7, value.scale) + protoAdapter.encodedSizeWithTag(8, value.filePath) + AnimationMode.ADAPTER.encodedSizeWithTag(9, value.animationMode) + ActionScope.ADAPTER.encodedSizeWithTag(10, value.actionScope) + protoAdapter2.encodedSizeWithTag(11, value.timeLineIndex) + protoAdapter.encodedSizeWithTag(12, value.materialId) + protoAdapter.encodedSizeWithTag(13, value.categoryId) + protoAdapter.encodedSizeWithTag(14, value.portraitFilePath) + protoAdapter.encodedSizeWithTag(15, value.landscapeFilePath) + SpecialEffectResType.ADAPTER.encodedSizeWithTag(16, value.type) + protoAdapter.encodedSizeWithTag(17, value.jsPath) + protoAdapter.encodedSizeWithTag(18, value.jsContentCache) + value.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        @NotNull
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public SpecialEffectModel redact(@NotNull SpecialEffectModel value) {
            Intrinsics.checkNotNullParameter(value, "value");
            return SpecialEffectModel.copy$default(value, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, ByteString.EMPTY, 262143, null);
        }
    }

    static {
        b bVar = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(SpecialEffectModel.class));
        ADAPTER = bVar;
        CREATOR = AndroidMessage.INSTANCE.newCreator(bVar);
    }

    public SpecialEffectModel() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 524287, null);
    }

    public static /* synthetic */ SpecialEffectModel copy$default(SpecialEffectModel specialEffectModel, String str, String str2, Integer num, Long l3, Long l16, Long l17, Float f16, String str3, AnimationMode animationMode, ActionScope actionScope, Integer num2, String str4, String str5, String str6, String str7, SpecialEffectResType specialEffectResType, String str8, String str9, ByteString byteString, int i3, Object obj) {
        return specialEffectModel.copy((i3 & 1) != 0 ? specialEffectModel.id : str, (i3 & 2) != 0 ? specialEffectModel.name : str2, (i3 & 4) != 0 ? specialEffectModel.bgColor : num, (i3 & 8) != 0 ? specialEffectModel.startTimeUs : l3, (i3 & 16) != 0 ? specialEffectModel.durationUs : l16, (i3 & 32) != 0 ? specialEffectModel.createTimeMs : l17, (i3 & 64) != 0 ? specialEffectModel.scale : f16, (i3 & 128) != 0 ? specialEffectModel.filePath : str3, (i3 & 256) != 0 ? specialEffectModel.animationMode : animationMode, (i3 & 512) != 0 ? specialEffectModel.actionScope : actionScope, (i3 & 1024) != 0 ? specialEffectModel.timeLineIndex : num2, (i3 & 2048) != 0 ? specialEffectModel.materialId : str4, (i3 & 4096) != 0 ? specialEffectModel.categoryId : str5, (i3 & 8192) != 0 ? specialEffectModel.portraitFilePath : str6, (i3 & 16384) != 0 ? specialEffectModel.landscapeFilePath : str7, (i3 & 32768) != 0 ? specialEffectModel.type : specialEffectResType, (i3 & 65536) != 0 ? specialEffectModel.jsPath : str8, (i3 & 131072) != 0 ? specialEffectModel.jsContentCache : str9, (i3 & 262144) != 0 ? specialEffectModel.unknownFields() : byteString);
    }

    @NotNull
    public final SpecialEffectModel copy(@Nullable String id5, @Nullable String name, @Nullable Integer bgColor, @Nullable Long startTimeUs, @Nullable Long durationUs, @Nullable Long createTimeMs, @Nullable Float scale, @Nullable String filePath, @Nullable AnimationMode animationMode, @Nullable ActionScope actionScope, @Nullable Integer timeLineIndex, @Nullable String materialId, @Nullable String categoryId, @Nullable String portraitFilePath, @Nullable String landscapeFilePath, @Nullable SpecialEffectResType type, @Nullable String jsPath, @Nullable String jsContentCache, @NotNull ByteString unknownFields) {
        Intrinsics.checkNotNullParameter(unknownFields, "unknownFields");
        return new SpecialEffectModel(id5, name, bgColor, startTimeUs, durationUs, createTimeMs, scale, filePath, animationMode, actionScope, timeLineIndex, materialId, categoryId, portraitFilePath, landscapeFilePath, type, jsPath, jsContentCache, unknownFields);
    }

    public boolean equals(@Nullable Object other) {
        if (other == this) {
            return true;
        }
        if (!(other instanceof SpecialEffectModel)) {
            return false;
        }
        SpecialEffectModel specialEffectModel = (SpecialEffectModel) other;
        if (Intrinsics.areEqual(unknownFields(), specialEffectModel.unknownFields()) && Intrinsics.areEqual(this.id, specialEffectModel.id) && Intrinsics.areEqual(this.name, specialEffectModel.name) && Intrinsics.areEqual(this.bgColor, specialEffectModel.bgColor) && Intrinsics.areEqual(this.startTimeUs, specialEffectModel.startTimeUs) && Intrinsics.areEqual(this.durationUs, specialEffectModel.durationUs) && Intrinsics.areEqual(this.createTimeMs, specialEffectModel.createTimeMs) && Intrinsics.areEqual(this.scale, specialEffectModel.scale) && Intrinsics.areEqual(this.filePath, specialEffectModel.filePath) && this.animationMode == specialEffectModel.animationMode && this.actionScope == specialEffectModel.actionScope && Intrinsics.areEqual(this.timeLineIndex, specialEffectModel.timeLineIndex) && Intrinsics.areEqual(this.materialId, specialEffectModel.materialId) && Intrinsics.areEqual(this.categoryId, specialEffectModel.categoryId) && Intrinsics.areEqual(this.portraitFilePath, specialEffectModel.portraitFilePath) && Intrinsics.areEqual(this.landscapeFilePath, specialEffectModel.landscapeFilePath) && this.type == specialEffectModel.type && Intrinsics.areEqual(this.jsPath, specialEffectModel.jsPath) && Intrinsics.areEqual(this.jsContentCache, specialEffectModel.jsContentCache)) {
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
        int i56 = this.hashCode;
        if (i56 == 0) {
            int hashCode = unknownFields().hashCode() * 37;
            String str = this.id;
            int i57 = 0;
            if (str != null) {
                i3 = str.hashCode();
            } else {
                i3 = 0;
            }
            int i58 = (hashCode + i3) * 37;
            String str2 = this.name;
            if (str2 != null) {
                i16 = str2.hashCode();
            } else {
                i16 = 0;
            }
            int i59 = (i58 + i16) * 37;
            Integer num = this.bgColor;
            if (num != null) {
                i17 = num.hashCode();
            } else {
                i17 = 0;
            }
            int i65 = (i59 + i17) * 37;
            Long l3 = this.startTimeUs;
            if (l3 != null) {
                i18 = l3.hashCode();
            } else {
                i18 = 0;
            }
            int i66 = (i65 + i18) * 37;
            Long l16 = this.durationUs;
            if (l16 != null) {
                i19 = l16.hashCode();
            } else {
                i19 = 0;
            }
            int i67 = (i66 + i19) * 37;
            Long l17 = this.createTimeMs;
            if (l17 != null) {
                i26 = l17.hashCode();
            } else {
                i26 = 0;
            }
            int i68 = (i67 + i26) * 37;
            Float f16 = this.scale;
            if (f16 != null) {
                i27 = f16.hashCode();
            } else {
                i27 = 0;
            }
            int i69 = (i68 + i27) * 37;
            String str3 = this.filePath;
            if (str3 != null) {
                i28 = str3.hashCode();
            } else {
                i28 = 0;
            }
            int i75 = (i69 + i28) * 37;
            AnimationMode animationMode = this.animationMode;
            if (animationMode != null) {
                i29 = animationMode.hashCode();
            } else {
                i29 = 0;
            }
            int i76 = (i75 + i29) * 37;
            ActionScope actionScope = this.actionScope;
            if (actionScope != null) {
                i36 = actionScope.hashCode();
            } else {
                i36 = 0;
            }
            int i77 = (i76 + i36) * 37;
            Integer num2 = this.timeLineIndex;
            if (num2 != null) {
                i37 = num2.hashCode();
            } else {
                i37 = 0;
            }
            int i78 = (i77 + i37) * 37;
            String str4 = this.materialId;
            if (str4 != null) {
                i38 = str4.hashCode();
            } else {
                i38 = 0;
            }
            int i79 = (i78 + i38) * 37;
            String str5 = this.categoryId;
            if (str5 != null) {
                i39 = str5.hashCode();
            } else {
                i39 = 0;
            }
            int i85 = (i79 + i39) * 37;
            String str6 = this.portraitFilePath;
            if (str6 != null) {
                i46 = str6.hashCode();
            } else {
                i46 = 0;
            }
            int i86 = (i85 + i46) * 37;
            String str7 = this.landscapeFilePath;
            if (str7 != null) {
                i47 = str7.hashCode();
            } else {
                i47 = 0;
            }
            int i87 = (i86 + i47) * 37;
            SpecialEffectResType specialEffectResType = this.type;
            if (specialEffectResType != null) {
                i48 = specialEffectResType.hashCode();
            } else {
                i48 = 0;
            }
            int i88 = (i87 + i48) * 37;
            String str8 = this.jsPath;
            if (str8 != null) {
                i49 = str8.hashCode();
            } else {
                i49 = 0;
            }
            int i89 = (i88 + i49) * 37;
            String str9 = this.jsContentCache;
            if (str9 != null) {
                i57 = str9.hashCode();
            }
            int i95 = i89 + i57;
            this.hashCode = i95;
            return i95;
        }
        return i56;
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
        joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(arrayList, ", ", "SpecialEffectModel{", "}", 0, null, null, 56, null);
        return joinToString$default;
    }

    public /* synthetic */ SpecialEffectModel(String str, String str2, Integer num, Long l3, Long l16, Long l17, Float f16, String str3, AnimationMode animationMode, ActionScope actionScope, Integer num2, String str4, String str5, String str6, String str7, SpecialEffectResType specialEffectResType, String str8, String str9, ByteString byteString, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? null : str, (i3 & 2) != 0 ? null : str2, (i3 & 4) != 0 ? null : num, (i3 & 8) != 0 ? null : l3, (i3 & 16) != 0 ? null : l16, (i3 & 32) != 0 ? null : l17, (i3 & 64) != 0 ? null : f16, (i3 & 128) != 0 ? null : str3, (i3 & 256) != 0 ? null : animationMode, (i3 & 512) != 0 ? null : actionScope, (i3 & 1024) != 0 ? null : num2, (i3 & 2048) != 0 ? null : str4, (i3 & 4096) != 0 ? null : str5, (i3 & 8192) != 0 ? null : str6, (i3 & 16384) != 0 ? null : str7, (i3 & 32768) != 0 ? null : specialEffectResType, (i3 & 65536) != 0 ? null : str8, (i3 & 131072) != 0 ? null : str9, (i3 & 262144) != 0 ? ByteString.EMPTY : byteString);
    }

    @Override // com.squareup.wire.Message
    @NotNull
    public a newBuilder() {
        a aVar = new a();
        aVar.id = this.id;
        aVar.name = this.name;
        aVar.bgColor = this.bgColor;
        aVar.startTimeUs = this.startTimeUs;
        aVar.durationUs = this.durationUs;
        aVar.createTimeMs = this.createTimeMs;
        aVar.scale = this.scale;
        aVar.filePath = this.filePath;
        aVar.animationMode = this.animationMode;
        aVar.actionScope = this.actionScope;
        aVar.timeLineIndex = this.timeLineIndex;
        aVar.materialId = this.materialId;
        aVar.categoryId = this.categoryId;
        aVar.portraitFilePath = this.portraitFilePath;
        aVar.landscapeFilePath = this.landscapeFilePath;
        aVar.type = this.type;
        aVar.jsPath = this.jsPath;
        aVar.jsContentCache = this.jsContentCache;
        aVar.addUnknownFields(unknownFields());
        return aVar;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SpecialEffectModel(@Nullable String str, @Nullable String str2, @Nullable Integer num, @Nullable Long l3, @Nullable Long l16, @Nullable Long l17, @Nullable Float f16, @Nullable String str3, @Nullable AnimationMode animationMode, @Nullable ActionScope actionScope, @Nullable Integer num2, @Nullable String str4, @Nullable String str5, @Nullable String str6, @Nullable String str7, @Nullable SpecialEffectResType specialEffectResType, @Nullable String str8, @Nullable String str9, @NotNull ByteString unknownFields) {
        super(ADAPTER, unknownFields);
        Intrinsics.checkNotNullParameter(unknownFields, "unknownFields");
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
    }
}
