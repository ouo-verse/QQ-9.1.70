package com.tencent.videocut.model;

import android.os.Parcelable;
import com.heytap.databaseengine.apiv3.data.Element;
import com.huawei.hms.support.feature.result.CommonConstant;
import com.squareup.wire.AndroidMessage;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.Syntax;
import com.squareup.wire.WireField;
import com.squareup.wire.internal.Internal;
import com.tencent.mobileqq.mini.servlet.MiniAppSendSmsCodeServlet;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
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

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0006\u0018\u0000 )2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002()B\u00f5\u0001\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0004\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\t\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0004\u0012\b\b\u0002\u0010\f\u001a\u00020\u0004\u0012\b\b\u0002\u0010\r\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0013\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0013\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0013\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0013\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0013\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u0013\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u001e\u00a2\u0006\u0002\u0010\u001fJ\u00f6\u0001\u0010 \u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00042\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\u00042\b\b\u0002\u0010\f\u001a\u00020\u00042\b\b\u0002\u0010\r\u001a\u00020\u00042\b\b\u0002\u0010\u000e\u001a\u00020\u00042\b\b\u0002\u0010\u000f\u001a\u00020\u00042\b\b\u0002\u0010\u0010\u001a\u00020\u00042\b\b\u0002\u0010\u0011\u001a\u00020\u00042\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00042\b\b\u0002\u0010\u0015\u001a\u00020\u00042\b\b\u0002\u0010\u0016\u001a\u00020\u00132\b\b\u0002\u0010\u0017\u001a\u00020\u00132\b\b\u0002\u0010\u0018\u001a\u00020\u00132\b\b\u0002\u0010\u0019\u001a\u00020\u00042\b\b\u0002\u0010\u001a\u001a\u00020\u00132\b\b\u0002\u0010\u001b\u001a\u00020\u00132\b\b\u0002\u0010\u001c\u001a\u00020\u00042\b\b\u0002\u0010\u001d\u001a\u00020\u001eJ\u0013\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010$H\u0096\u0002J\b\u0010%\u001a\u00020\u0013H\u0016J\b\u0010&\u001a\u00020\u0002H\u0016J\b\u0010'\u001a\u00020\u0004H\u0016R\u0010\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u00020\u00138\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u00020\u00138\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u00020\u00138\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u00020\t8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u00020\t8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u00020\u00138\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u00020\u00138\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u00020\u00138\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006*"}, d2 = {"Lcom/tencent/videocut/model/WatermarkPoiModel;", "Lcom/squareup/wire/AndroidMessage;", "Lcom/tencent/videocut/model/WatermarkPoiModel$Builder;", "address", "", "country", "province", "city", "longitude", "", "latitude", "town", "village", "district", "road", CommonConstant.KEY_DISPLAY_NAME, "poiName", "poiId", "poiType", "", "poiTypeName", "poiDefaultName", "districtCode", Element.ELEMENT_NAME_DISTANCE, "hotValue", MiniAppSendSmsCodeServlet.KEY_PHONE_NUMBER, "poiOrderType", "poiNum", "dianPingId", "unknownFields", "Lokio/ByteString;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;FFLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;IIILjava/lang/String;IILjava/lang/String;Lokio/ByteString;)V", "copy", "equals", "", "other", "", "hashCode", "newBuilder", "toString", "Builder", "Companion", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes27.dex */
public final class WatermarkPoiModel extends AndroidMessage<WatermarkPoiModel, Builder> {
    static IPatchRedirector $redirector_;

    @JvmField
    @NotNull
    public static final ProtoAdapter<WatermarkPoiModel> ADAPTER;

    @JvmField
    @NotNull
    public static final Parcelable.Creator<WatermarkPoiModel> CREATOR;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", label = WireField.Label.OMIT_IDENTITY, tag = 1)
    @JvmField
    @NotNull
    public final String address;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", label = WireField.Label.OMIT_IDENTITY, tag = 4)
    @JvmField
    @NotNull
    public final String city;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", label = WireField.Label.OMIT_IDENTITY, tag = 2)
    @JvmField
    @NotNull
    public final String country;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", label = WireField.Label.OMIT_IDENTITY, tag = 23)
    @JvmField
    @NotNull
    public final String dianPingId;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", label = WireField.Label.OMIT_IDENTITY, tag = 11)
    @JvmField
    @NotNull
    public final String displayName;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", label = WireField.Label.OMIT_IDENTITY, tag = 18)
    @JvmField
    public final int distance;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", label = WireField.Label.OMIT_IDENTITY, tag = 9)
    @JvmField
    @NotNull
    public final String district;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", label = WireField.Label.OMIT_IDENTITY, tag = 17)
    @JvmField
    public final int districtCode;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", label = WireField.Label.OMIT_IDENTITY, tag = 19)
    @JvmField
    public final int hotValue;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#FLOAT", label = WireField.Label.OMIT_IDENTITY, tag = 6)
    @JvmField
    public final float latitude;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#FLOAT", label = WireField.Label.OMIT_IDENTITY, tag = 5)
    @JvmField
    public final float longitude;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", label = WireField.Label.OMIT_IDENTITY, tag = 20)
    @JvmField
    @NotNull
    public final String phoneNumber;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", label = WireField.Label.OMIT_IDENTITY, tag = 16)
    @JvmField
    @NotNull
    public final String poiDefaultName;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", label = WireField.Label.OMIT_IDENTITY, tag = 13)
    @JvmField
    @NotNull
    public final String poiId;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", label = WireField.Label.OMIT_IDENTITY, tag = 12)
    @JvmField
    @NotNull
    public final String poiName;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", label = WireField.Label.OMIT_IDENTITY, tag = 22)
    @JvmField
    public final int poiNum;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", label = WireField.Label.OMIT_IDENTITY, tag = 21)
    @JvmField
    public final int poiOrderType;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", label = WireField.Label.OMIT_IDENTITY, tag = 14)
    @JvmField
    public final int poiType;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", label = WireField.Label.OMIT_IDENTITY, tag = 15)
    @JvmField
    @NotNull
    public final String poiTypeName;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", label = WireField.Label.OMIT_IDENTITY, tag = 3)
    @JvmField
    @NotNull
    public final String province;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", label = WireField.Label.OMIT_IDENTITY, tag = 10)
    @JvmField
    @NotNull
    public final String road;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", label = WireField.Label.OMIT_IDENTITY, tag = 7)
    @JvmField
    @NotNull
    public final String town;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", label = WireField.Label.OMIT_IDENTITY, tag = 8)
    @JvmField
    @NotNull
    public final String village;

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u000f\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00000\u0001B\u0005\u00a2\u0006\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u0005J\b\u0010\u001e\u001a\u00020\u0002H\u0016J\u000e\u0010\u0006\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0005J\u000e\u0010\u0007\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u0005J\u000e\u0010\b\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\u0005J\u000e\u0010\t\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0005J\u000e\u0010\n\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u000bJ\u000e\u0010\f\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\u0005J\u000e\u0010\r\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\u000bJ\u000e\u0010\u000e\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\u000bJ\u000e\u0010\u000f\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u0010J\u000e\u0010\u0011\u001a\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u0010J\u000e\u0010\u0012\u001a\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u0005J\u000e\u0010\u0013\u001a\u00020\u00002\u0006\u0010\u0013\u001a\u00020\u0005J\u000e\u0010\u0014\u001a\u00020\u00002\u0006\u0010\u0014\u001a\u00020\u0005J\u000e\u0010\u0015\u001a\u00020\u00002\u0006\u0010\u0015\u001a\u00020\u0005J\u000e\u0010\u0016\u001a\u00020\u00002\u0006\u0010\u0016\u001a\u00020\u000bJ\u000e\u0010\u0017\u001a\u00020\u00002\u0006\u0010\u0017\u001a\u00020\u000bJ\u000e\u0010\u0018\u001a\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u000bJ\u000e\u0010\u0019\u001a\u00020\u00002\u0006\u0010\u0019\u001a\u00020\u0005J\u000e\u0010\u001a\u001a\u00020\u00002\u0006\u0010\u001a\u001a\u00020\u0005J\u000e\u0010\u001b\u001a\u00020\u00002\u0006\u0010\u001b\u001a\u00020\u0005J\u000e\u0010\u001c\u001a\u00020\u00002\u0006\u0010\u001c\u001a\u00020\u0005J\u000e\u0010\u001d\u001a\u00020\u00002\u0006\u0010\u001d\u001a\u00020\u0005R\u0012\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010\b\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010\t\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010\n\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010\f\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010\r\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u000e\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u000f\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u0011\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u0012\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u0013\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u0014\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u0015\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u0016\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u0017\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u0018\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u0019\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u001a\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u001b\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u001c\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u001d\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/videocut/model/WatermarkPoiModel$Builder;", "Lcom/squareup/wire/Message$Builder;", "Lcom/tencent/videocut/model/WatermarkPoiModel;", "()V", "address", "", "city", "country", "dianPingId", CommonConstant.KEY_DISPLAY_NAME, Element.ELEMENT_NAME_DISTANCE, "", "district", "districtCode", "hotValue", "latitude", "", "longitude", MiniAppSendSmsCodeServlet.KEY_PHONE_NUMBER, "poiDefaultName", "poiId", "poiName", "poiNum", "poiOrderType", "poiType", "poiTypeName", "province", "road", "town", "village", "build", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes27.dex */
    public static final class Builder extends Message.Builder<WatermarkPoiModel, Builder> {
        static IPatchRedirector $redirector_;

        @JvmField
        @NotNull
        public String address;

        @JvmField
        @NotNull
        public String city;

        @JvmField
        @NotNull
        public String country;

        @JvmField
        @NotNull
        public String dianPingId;

        @JvmField
        @NotNull
        public String displayName;

        @JvmField
        public int distance;

        @JvmField
        @NotNull
        public String district;

        @JvmField
        public int districtCode;

        @JvmField
        public int hotValue;

        @JvmField
        public float latitude;

        @JvmField
        public float longitude;

        @JvmField
        @NotNull
        public String phoneNumber;

        @JvmField
        @NotNull
        public String poiDefaultName;

        @JvmField
        @NotNull
        public String poiId;

        @JvmField
        @NotNull
        public String poiName;

        @JvmField
        public int poiNum;

        @JvmField
        public int poiOrderType;

        @JvmField
        public int poiType;

        @JvmField
        @NotNull
        public String poiTypeName;

        @JvmField
        @NotNull
        public String province;

        @JvmField
        @NotNull
        public String road;

        @JvmField
        @NotNull
        public String town;

        @JvmField
        @NotNull
        public String village;

        public Builder() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
                return;
            }
            this.address = "";
            this.country = "";
            this.province = "";
            this.city = "";
            this.town = "";
            this.village = "";
            this.district = "";
            this.road = "";
            this.displayName = "";
            this.poiName = "";
            this.poiId = "";
            this.poiTypeName = "";
            this.poiDefaultName = "";
            this.phoneNumber = "";
            this.dianPingId = "";
        }

        @NotNull
        public final Builder address(@NotNull String address) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (Builder) iPatchRedirector.redirect((short) 2, (Object) this, (Object) address);
            }
            Intrinsics.checkNotNullParameter(address, "address");
            this.address = address;
            return this;
        }

        @NotNull
        public final Builder city(@NotNull String city) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return (Builder) iPatchRedirector.redirect((short) 5, (Object) this, (Object) city);
            }
            Intrinsics.checkNotNullParameter(city, "city");
            this.city = city;
            return this;
        }

        @NotNull
        public final Builder country(@NotNull String country) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (Builder) iPatchRedirector.redirect((short) 3, (Object) this, (Object) country);
            }
            Intrinsics.checkNotNullParameter(country, "country");
            this.country = country;
            return this;
        }

        @NotNull
        public final Builder dianPingId(@NotNull String dianPingId) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
                return (Builder) iPatchRedirector.redirect((short) 24, (Object) this, (Object) dianPingId);
            }
            Intrinsics.checkNotNullParameter(dianPingId, "dianPingId");
            this.dianPingId = dianPingId;
            return this;
        }

        @NotNull
        public final Builder displayName(@NotNull String displayName) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
                return (Builder) iPatchRedirector.redirect((short) 12, (Object) this, (Object) displayName);
            }
            Intrinsics.checkNotNullParameter(displayName, "displayName");
            this.displayName = displayName;
            return this;
        }

        @NotNull
        public final Builder distance(int distance) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
                return (Builder) iPatchRedirector.redirect((short) 19, (Object) this, distance);
            }
            this.distance = distance;
            return this;
        }

        @NotNull
        public final Builder district(@NotNull String district) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
                return (Builder) iPatchRedirector.redirect((short) 10, (Object) this, (Object) district);
            }
            Intrinsics.checkNotNullParameter(district, "district");
            this.district = district;
            return this;
        }

        @NotNull
        public final Builder districtCode(int districtCode) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
                return (Builder) iPatchRedirector.redirect((short) 18, (Object) this, districtCode);
            }
            this.districtCode = districtCode;
            return this;
        }

        @NotNull
        public final Builder hotValue(int hotValue) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
                return (Builder) iPatchRedirector.redirect((short) 20, (Object) this, hotValue);
            }
            this.hotValue = hotValue;
            return this;
        }

        @NotNull
        public final Builder latitude(float latitude) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return (Builder) iPatchRedirector.redirect((short) 7, this, Float.valueOf(latitude));
            }
            this.latitude = latitude;
            return this;
        }

        @NotNull
        public final Builder longitude(float longitude) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return (Builder) iPatchRedirector.redirect((short) 6, this, Float.valueOf(longitude));
            }
            this.longitude = longitude;
            return this;
        }

        @NotNull
        public final Builder phoneNumber(@NotNull String phoneNumber) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
                return (Builder) iPatchRedirector.redirect((short) 21, (Object) this, (Object) phoneNumber);
            }
            Intrinsics.checkNotNullParameter(phoneNumber, "phoneNumber");
            this.phoneNumber = phoneNumber;
            return this;
        }

        @NotNull
        public final Builder poiDefaultName(@NotNull String poiDefaultName) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
                return (Builder) iPatchRedirector.redirect((short) 17, (Object) this, (Object) poiDefaultName);
            }
            Intrinsics.checkNotNullParameter(poiDefaultName, "poiDefaultName");
            this.poiDefaultName = poiDefaultName;
            return this;
        }

        @NotNull
        public final Builder poiId(@NotNull String poiId) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
                return (Builder) iPatchRedirector.redirect((short) 14, (Object) this, (Object) poiId);
            }
            Intrinsics.checkNotNullParameter(poiId, "poiId");
            this.poiId = poiId;
            return this;
        }

        @NotNull
        public final Builder poiName(@NotNull String poiName) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
                return (Builder) iPatchRedirector.redirect((short) 13, (Object) this, (Object) poiName);
            }
            Intrinsics.checkNotNullParameter(poiName, "poiName");
            this.poiName = poiName;
            return this;
        }

        @NotNull
        public final Builder poiNum(int poiNum) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
                return (Builder) iPatchRedirector.redirect((short) 23, (Object) this, poiNum);
            }
            this.poiNum = poiNum;
            return this;
        }

        @NotNull
        public final Builder poiOrderType(int poiOrderType) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
                return (Builder) iPatchRedirector.redirect((short) 22, (Object) this, poiOrderType);
            }
            this.poiOrderType = poiOrderType;
            return this;
        }

        @NotNull
        public final Builder poiType(int poiType) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
                return (Builder) iPatchRedirector.redirect((short) 15, (Object) this, poiType);
            }
            this.poiType = poiType;
            return this;
        }

        @NotNull
        public final Builder poiTypeName(@NotNull String poiTypeName) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
                return (Builder) iPatchRedirector.redirect((short) 16, (Object) this, (Object) poiTypeName);
            }
            Intrinsics.checkNotNullParameter(poiTypeName, "poiTypeName");
            this.poiTypeName = poiTypeName;
            return this;
        }

        @NotNull
        public final Builder province(@NotNull String province) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (Builder) iPatchRedirector.redirect((short) 4, (Object) this, (Object) province);
            }
            Intrinsics.checkNotNullParameter(province, "province");
            this.province = province;
            return this;
        }

        @NotNull
        public final Builder road(@NotNull String road) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
                return (Builder) iPatchRedirector.redirect((short) 11, (Object) this, (Object) road);
            }
            Intrinsics.checkNotNullParameter(road, "road");
            this.road = road;
            return this;
        }

        @NotNull
        public final Builder town(@NotNull String town) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                return (Builder) iPatchRedirector.redirect((short) 8, (Object) this, (Object) town);
            }
            Intrinsics.checkNotNullParameter(town, "town");
            this.town = town;
            return this;
        }

        @NotNull
        public final Builder village(@NotNull String village) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                return (Builder) iPatchRedirector.redirect((short) 9, (Object) this, (Object) village);
            }
            Intrinsics.checkNotNullParameter(village, "village");
            this.village = village;
            return this;
        }

        @Override // com.squareup.wire.Message.Builder
        @NotNull
        public WatermarkPoiModel build() {
            IPatchRedirector iPatchRedirector = $redirector_;
            return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 25)) ? new WatermarkPoiModel(this.address, this.country, this.province, this.city, this.longitude, this.latitude, this.town, this.village, this.district, this.road, this.displayName, this.poiName, this.poiId, this.poiType, this.poiTypeName, this.poiDefaultName, this.districtCode, this.distance, this.hotValue, this.phoneNumber, this.poiOrderType, this.poiNum, this.dianPingId, buildUnknownFields()) : (WatermarkPoiModel) iPatchRedirector.redirect((short) 25, (Object) this);
        }
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00078\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\n"}, d2 = {"Lcom/tencent/videocut/model/WatermarkPoiModel$Companion;", "", "()V", "ADAPTER", "Lcom/squareup/wire/ProtoAdapter;", "Lcom/tencent/videocut/model/WatermarkPoiModel;", "CREATOR", "Landroid/os/Parcelable$Creator;", "serialVersionUID", "", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(59460);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 9)) {
            redirector.redirect((short) 9);
            return;
        }
        INSTANCE = new Companion(null);
        final FieldEncoding fieldEncoding = FieldEncoding.LENGTH_DELIMITED;
        final KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(WatermarkPoiModel.class);
        final Syntax syntax = Syntax.PROTO_3;
        ProtoAdapter<WatermarkPoiModel> protoAdapter = new ProtoAdapter<WatermarkPoiModel>(fieldEncoding, orCreateKotlinClass, syntax) { // from class: com.tencent.videocut.model.WatermarkPoiModel$Companion$ADAPTER$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(fieldEncoding, orCreateKotlinClass, "type.googleapis.com/model.WatermarkPoiModel", syntax, (Object) null);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, fieldEncoding, orCreateKotlinClass, syntax);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            @NotNull
            public WatermarkPoiModel decode(@NotNull ProtoReader reader) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                    return (WatermarkPoiModel) iPatchRedirector.redirect((short) 4, (Object) this, (Object) reader);
                }
                Intrinsics.checkNotNullParameter(reader, "reader");
                long beginMessage = reader.beginMessage();
                String str = "";
                float f16 = 0.0f;
                float f17 = 0.0f;
                int i3 = 0;
                int i16 = 0;
                int i17 = 0;
                int i18 = 0;
                int i19 = 0;
                int i26 = 0;
                String str2 = "";
                String str3 = str2;
                String str4 = str3;
                String str5 = str4;
                String str6 = str5;
                String str7 = str6;
                String str8 = str7;
                String str9 = str8;
                String str10 = str9;
                String str11 = str10;
                String str12 = str11;
                String str13 = str12;
                String str14 = str13;
                String str15 = str14;
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
                                str3 = ProtoAdapter.STRING.decode(reader);
                                break;
                            case 4:
                                str4 = ProtoAdapter.STRING.decode(reader);
                                break;
                            case 5:
                                f16 = ProtoAdapter.FLOAT.decode(reader).floatValue();
                                break;
                            case 6:
                                f17 = ProtoAdapter.FLOAT.decode(reader).floatValue();
                                break;
                            case 7:
                                str5 = ProtoAdapter.STRING.decode(reader);
                                break;
                            case 8:
                                str6 = ProtoAdapter.STRING.decode(reader);
                                break;
                            case 9:
                                str7 = ProtoAdapter.STRING.decode(reader);
                                break;
                            case 10:
                                str8 = ProtoAdapter.STRING.decode(reader);
                                break;
                            case 11:
                                str9 = ProtoAdapter.STRING.decode(reader);
                                break;
                            case 12:
                                str10 = ProtoAdapter.STRING.decode(reader);
                                break;
                            case 13:
                                str11 = ProtoAdapter.STRING.decode(reader);
                                break;
                            case 14:
                                i3 = ProtoAdapter.INT32.decode(reader).intValue();
                                break;
                            case 15:
                                str12 = ProtoAdapter.STRING.decode(reader);
                                break;
                            case 16:
                                str13 = ProtoAdapter.STRING.decode(reader);
                                break;
                            case 17:
                                i16 = ProtoAdapter.INT32.decode(reader).intValue();
                                break;
                            case 18:
                                i17 = ProtoAdapter.INT32.decode(reader).intValue();
                                break;
                            case 19:
                                i18 = ProtoAdapter.INT32.decode(reader).intValue();
                                break;
                            case 20:
                                str14 = ProtoAdapter.STRING.decode(reader);
                                break;
                            case 21:
                                i19 = ProtoAdapter.INT32.decode(reader).intValue();
                                break;
                            case 22:
                                i26 = ProtoAdapter.INT32.decode(reader).intValue();
                                break;
                            case 23:
                                str15 = ProtoAdapter.STRING.decode(reader);
                                break;
                            default:
                                reader.readUnknownField(nextTag);
                                break;
                        }
                    } else {
                        return new WatermarkPoiModel(str, str2, str3, str4, f16, f17, str5, str6, str7, str8, str9, str10, str11, i3, str12, str13, i16, i17, i18, str14, i19, i26, str15, reader.endMessageAndGetUnknownFields(beginMessage));
                    }
                }
            }

            @Override // com.squareup.wire.ProtoAdapter
            public void encode(@NotNull ProtoWriter writer, @NotNull WatermarkPoiModel value) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                    iPatchRedirector.redirect((short) 3, (Object) this, (Object) writer, (Object) value);
                    return;
                }
                Intrinsics.checkNotNullParameter(writer, "writer");
                Intrinsics.checkNotNullParameter(value, "value");
                if (!Intrinsics.areEqual(value.address, "")) {
                    ProtoAdapter.STRING.encodeWithTag(writer, 1, value.address);
                }
                if (!Intrinsics.areEqual(value.country, "")) {
                    ProtoAdapter.STRING.encodeWithTag(writer, 2, value.country);
                }
                if (!Intrinsics.areEqual(value.province, "")) {
                    ProtoAdapter.STRING.encodeWithTag(writer, 3, value.province);
                }
                if (!Intrinsics.areEqual(value.city, "")) {
                    ProtoAdapter.STRING.encodeWithTag(writer, 4, value.city);
                }
                float f16 = value.longitude;
                if (!(f16 == 0.0f)) {
                    ProtoAdapter.FLOAT.encodeWithTag(writer, 5, Float.valueOf(f16));
                }
                float f17 = value.latitude;
                if (!(f17 == 0.0f)) {
                    ProtoAdapter.FLOAT.encodeWithTag(writer, 6, Float.valueOf(f17));
                }
                if (!Intrinsics.areEqual(value.town, "")) {
                    ProtoAdapter.STRING.encodeWithTag(writer, 7, value.town);
                }
                if (!Intrinsics.areEqual(value.village, "")) {
                    ProtoAdapter.STRING.encodeWithTag(writer, 8, value.village);
                }
                if (!Intrinsics.areEqual(value.district, "")) {
                    ProtoAdapter.STRING.encodeWithTag(writer, 9, value.district);
                }
                if (!Intrinsics.areEqual(value.road, "")) {
                    ProtoAdapter.STRING.encodeWithTag(writer, 10, value.road);
                }
                if (!Intrinsics.areEqual(value.displayName, "")) {
                    ProtoAdapter.STRING.encodeWithTag(writer, 11, value.displayName);
                }
                if (!Intrinsics.areEqual(value.poiName, "")) {
                    ProtoAdapter.STRING.encodeWithTag(writer, 12, value.poiName);
                }
                if (!Intrinsics.areEqual(value.poiId, "")) {
                    ProtoAdapter.STRING.encodeWithTag(writer, 13, value.poiId);
                }
                int i3 = value.poiType;
                if (i3 != 0) {
                    ProtoAdapter.INT32.encodeWithTag(writer, 14, Integer.valueOf(i3));
                }
                if (!Intrinsics.areEqual(value.poiTypeName, "")) {
                    ProtoAdapter.STRING.encodeWithTag(writer, 15, value.poiTypeName);
                }
                if (!Intrinsics.areEqual(value.poiDefaultName, "")) {
                    ProtoAdapter.STRING.encodeWithTag(writer, 16, value.poiDefaultName);
                }
                int i16 = value.districtCode;
                if (i16 != 0) {
                    ProtoAdapter.INT32.encodeWithTag(writer, 17, Integer.valueOf(i16));
                }
                int i17 = value.distance;
                if (i17 != 0) {
                    ProtoAdapter.INT32.encodeWithTag(writer, 18, Integer.valueOf(i17));
                }
                int i18 = value.hotValue;
                if (i18 != 0) {
                    ProtoAdapter.INT32.encodeWithTag(writer, 19, Integer.valueOf(i18));
                }
                if (!Intrinsics.areEqual(value.phoneNumber, "")) {
                    ProtoAdapter.STRING.encodeWithTag(writer, 20, value.phoneNumber);
                }
                int i19 = value.poiOrderType;
                if (i19 != 0) {
                    ProtoAdapter.INT32.encodeWithTag(writer, 21, Integer.valueOf(i19));
                }
                int i26 = value.poiNum;
                if (i26 != 0) {
                    ProtoAdapter.INT32.encodeWithTag(writer, 22, Integer.valueOf(i26));
                }
                if (!Intrinsics.areEqual(value.dianPingId, "")) {
                    ProtoAdapter.STRING.encodeWithTag(writer, 23, value.dianPingId);
                }
                writer.writeBytes(value.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public int encodedSize(@NotNull WatermarkPoiModel value) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this, (Object) value)).intValue();
                }
                Intrinsics.checkNotNullParameter(value, "value");
                int size = value.unknownFields().size();
                if (!Intrinsics.areEqual(value.address, "")) {
                    size += ProtoAdapter.STRING.encodedSizeWithTag(1, value.address);
                }
                if (!Intrinsics.areEqual(value.country, "")) {
                    size += ProtoAdapter.STRING.encodedSizeWithTag(2, value.country);
                }
                if (!Intrinsics.areEqual(value.province, "")) {
                    size += ProtoAdapter.STRING.encodedSizeWithTag(3, value.province);
                }
                if (!Intrinsics.areEqual(value.city, "")) {
                    size += ProtoAdapter.STRING.encodedSizeWithTag(4, value.city);
                }
                float f16 = value.longitude;
                if (!(f16 == 0.0f)) {
                    size += ProtoAdapter.FLOAT.encodedSizeWithTag(5, Float.valueOf(f16));
                }
                float f17 = value.latitude;
                if (!(f17 == 0.0f)) {
                    size += ProtoAdapter.FLOAT.encodedSizeWithTag(6, Float.valueOf(f17));
                }
                if (!Intrinsics.areEqual(value.town, "")) {
                    size += ProtoAdapter.STRING.encodedSizeWithTag(7, value.town);
                }
                if (!Intrinsics.areEqual(value.village, "")) {
                    size += ProtoAdapter.STRING.encodedSizeWithTag(8, value.village);
                }
                if (!Intrinsics.areEqual(value.district, "")) {
                    size += ProtoAdapter.STRING.encodedSizeWithTag(9, value.district);
                }
                if (!Intrinsics.areEqual(value.road, "")) {
                    size += ProtoAdapter.STRING.encodedSizeWithTag(10, value.road);
                }
                if (!Intrinsics.areEqual(value.displayName, "")) {
                    size += ProtoAdapter.STRING.encodedSizeWithTag(11, value.displayName);
                }
                if (!Intrinsics.areEqual(value.poiName, "")) {
                    size += ProtoAdapter.STRING.encodedSizeWithTag(12, value.poiName);
                }
                if (!Intrinsics.areEqual(value.poiId, "")) {
                    size += ProtoAdapter.STRING.encodedSizeWithTag(13, value.poiId);
                }
                int i3 = value.poiType;
                if (i3 != 0) {
                    size += ProtoAdapter.INT32.encodedSizeWithTag(14, Integer.valueOf(i3));
                }
                if (!Intrinsics.areEqual(value.poiTypeName, "")) {
                    size += ProtoAdapter.STRING.encodedSizeWithTag(15, value.poiTypeName);
                }
                if (!Intrinsics.areEqual(value.poiDefaultName, "")) {
                    size += ProtoAdapter.STRING.encodedSizeWithTag(16, value.poiDefaultName);
                }
                int i16 = value.districtCode;
                if (i16 != 0) {
                    size += ProtoAdapter.INT32.encodedSizeWithTag(17, Integer.valueOf(i16));
                }
                int i17 = value.distance;
                if (i17 != 0) {
                    size += ProtoAdapter.INT32.encodedSizeWithTag(18, Integer.valueOf(i17));
                }
                int i18 = value.hotValue;
                if (i18 != 0) {
                    size += ProtoAdapter.INT32.encodedSizeWithTag(19, Integer.valueOf(i18));
                }
                if (!Intrinsics.areEqual(value.phoneNumber, "")) {
                    size += ProtoAdapter.STRING.encodedSizeWithTag(20, value.phoneNumber);
                }
                int i19 = value.poiOrderType;
                if (i19 != 0) {
                    size += ProtoAdapter.INT32.encodedSizeWithTag(21, Integer.valueOf(i19));
                }
                int i26 = value.poiNum;
                if (i26 != 0) {
                    size += ProtoAdapter.INT32.encodedSizeWithTag(22, Integer.valueOf(i26));
                }
                return !Intrinsics.areEqual(value.dianPingId, "") ? size + ProtoAdapter.STRING.encodedSizeWithTag(23, value.dianPingId) : size;
            }

            @Override // com.squareup.wire.ProtoAdapter
            @NotNull
            public WatermarkPoiModel redact(@NotNull WatermarkPoiModel value) {
                WatermarkPoiModel copy;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                    return (WatermarkPoiModel) iPatchRedirector.redirect((short) 5, (Object) this, (Object) value);
                }
                Intrinsics.checkNotNullParameter(value, "value");
                copy = value.copy((r42 & 1) != 0 ? value.address : null, (r42 & 2) != 0 ? value.country : null, (r42 & 4) != 0 ? value.province : null, (r42 & 8) != 0 ? value.city : null, (r42 & 16) != 0 ? value.longitude : 0.0f, (r42 & 32) != 0 ? value.latitude : 0.0f, (r42 & 64) != 0 ? value.town : null, (r42 & 128) != 0 ? value.village : null, (r42 & 256) != 0 ? value.district : null, (r42 & 512) != 0 ? value.road : null, (r42 & 1024) != 0 ? value.displayName : null, (r42 & 2048) != 0 ? value.poiName : null, (r42 & 4096) != 0 ? value.poiId : null, (r42 & 8192) != 0 ? value.poiType : 0, (r42 & 16384) != 0 ? value.poiTypeName : null, (r42 & 32768) != 0 ? value.poiDefaultName : null, (r42 & 65536) != 0 ? value.districtCode : 0, (r42 & 131072) != 0 ? value.distance : 0, (r42 & 262144) != 0 ? value.hotValue : 0, (r42 & 524288) != 0 ? value.phoneNumber : null, (r42 & 1048576) != 0 ? value.poiOrderType : 0, (r42 & 2097152) != 0 ? value.poiNum : 0, (r42 & 4194304) != 0 ? value.dianPingId : null, (r42 & 8388608) != 0 ? value.unknownFields() : ByteString.EMPTY);
                return copy;
            }
        };
        ADAPTER = protoAdapter;
        CREATOR = AndroidMessage.INSTANCE.newCreator(protoAdapter);
    }

    public WatermarkPoiModel() {
        this(null, null, null, null, 0.0f, 0.0f, null, null, null, null, null, null, null, 0, null, null, 0, 0, 0, null, 0, 0, null, null, 16777215, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 8)) {
            return;
        }
        iPatchRedirector.redirect((short) 8, (Object) this);
    }

    @NotNull
    public final WatermarkPoiModel copy(@NotNull String address, @NotNull String country, @NotNull String province, @NotNull String city, float longitude, float latitude, @NotNull String town, @NotNull String village, @NotNull String district, @NotNull String road, @NotNull String displayName, @NotNull String poiName, @NotNull String poiId, int poiType, @NotNull String poiTypeName, @NotNull String poiDefaultName, int districtCode, int distance, int hotValue, @NotNull String phoneNumber, int poiOrderType, int poiNum, @NotNull String dianPingId, @NotNull ByteString unknownFields) {
        String dianPingId2 = dianPingId;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null) {
            if (iPatchRedirector.hasPatch((short) 7)) {
                return (WatermarkPoiModel) iPatchRedirector.redirect((short) 7, this, address, country, province, city, Float.valueOf(longitude), Float.valueOf(latitude), town, village, district, road, displayName, poiName, poiId, Integer.valueOf(poiType), poiTypeName, poiDefaultName, Integer.valueOf(districtCode), Integer.valueOf(distance), Integer.valueOf(hotValue), phoneNumber, Integer.valueOf(poiOrderType), Integer.valueOf(poiNum), dianPingId, unknownFields);
            }
            dianPingId2 = dianPingId;
        }
        Intrinsics.checkNotNullParameter(address, "address");
        Intrinsics.checkNotNullParameter(country, "country");
        Intrinsics.checkNotNullParameter(province, "province");
        Intrinsics.checkNotNullParameter(city, "city");
        Intrinsics.checkNotNullParameter(town, "town");
        Intrinsics.checkNotNullParameter(village, "village");
        Intrinsics.checkNotNullParameter(district, "district");
        Intrinsics.checkNotNullParameter(road, "road");
        Intrinsics.checkNotNullParameter(displayName, "displayName");
        Intrinsics.checkNotNullParameter(poiName, "poiName");
        Intrinsics.checkNotNullParameter(poiId, "poiId");
        Intrinsics.checkNotNullParameter(poiTypeName, "poiTypeName");
        Intrinsics.checkNotNullParameter(poiDefaultName, "poiDefaultName");
        Intrinsics.checkNotNullParameter(phoneNumber, "phoneNumber");
        Intrinsics.checkNotNullParameter(dianPingId2, "dianPingId");
        Intrinsics.checkNotNullParameter(unknownFields, "unknownFields");
        return new WatermarkPoiModel(address, country, province, city, longitude, latitude, town, village, district, road, displayName, poiName, poiId, poiType, poiTypeName, poiDefaultName, districtCode, distance, hotValue, phoneNumber, poiOrderType, poiNum, dianPingId, unknownFields);
    }

    public boolean equals(@Nullable Object other) {
        boolean z16;
        boolean z17;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, other)).booleanValue();
        }
        if (other == this) {
            return true;
        }
        if (!(other instanceof WatermarkPoiModel)) {
            return false;
        }
        WatermarkPoiModel watermarkPoiModel = (WatermarkPoiModel) other;
        if (!Intrinsics.areEqual(unknownFields(), watermarkPoiModel.unknownFields()) || !Intrinsics.areEqual(this.address, watermarkPoiModel.address) || !Intrinsics.areEqual(this.country, watermarkPoiModel.country) || !Intrinsics.areEqual(this.province, watermarkPoiModel.province) || !Intrinsics.areEqual(this.city, watermarkPoiModel.city)) {
            return false;
        }
        if (this.longitude == watermarkPoiModel.longitude) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            return false;
        }
        if (this.latitude == watermarkPoiModel.latitude) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (z17 && Intrinsics.areEqual(this.town, watermarkPoiModel.town) && Intrinsics.areEqual(this.village, watermarkPoiModel.village) && Intrinsics.areEqual(this.district, watermarkPoiModel.district) && Intrinsics.areEqual(this.road, watermarkPoiModel.road) && Intrinsics.areEqual(this.displayName, watermarkPoiModel.displayName) && Intrinsics.areEqual(this.poiName, watermarkPoiModel.poiName) && Intrinsics.areEqual(this.poiId, watermarkPoiModel.poiId) && this.poiType == watermarkPoiModel.poiType && Intrinsics.areEqual(this.poiTypeName, watermarkPoiModel.poiTypeName) && Intrinsics.areEqual(this.poiDefaultName, watermarkPoiModel.poiDefaultName) && this.districtCode == watermarkPoiModel.districtCode && this.distance == watermarkPoiModel.distance && this.hotValue == watermarkPoiModel.hotValue && Intrinsics.areEqual(this.phoneNumber, watermarkPoiModel.phoneNumber) && this.poiOrderType == watermarkPoiModel.poiOrderType && this.poiNum == watermarkPoiModel.poiNum && Intrinsics.areEqual(this.dianPingId, watermarkPoiModel.dianPingId)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
        }
        int i3 = this.hashCode;
        if (i3 == 0) {
            int hashCode = (((((((((((((((((((((((((((((((((((((((((((((unknownFields().hashCode() * 37) + this.address.hashCode()) * 37) + this.country.hashCode()) * 37) + this.province.hashCode()) * 37) + this.city.hashCode()) * 37) + Float.floatToIntBits(this.longitude)) * 37) + Float.floatToIntBits(this.latitude)) * 37) + this.town.hashCode()) * 37) + this.village.hashCode()) * 37) + this.district.hashCode()) * 37) + this.road.hashCode()) * 37) + this.displayName.hashCode()) * 37) + this.poiName.hashCode()) * 37) + this.poiId.hashCode()) * 37) + this.poiType) * 37) + this.poiTypeName.hashCode()) * 37) + this.poiDefaultName.hashCode()) * 37) + this.districtCode) * 37) + this.distance) * 37) + this.hotValue) * 37) + this.phoneNumber.hashCode()) * 37) + this.poiOrderType) * 37) + this.poiNum) * 37) + this.dianPingId.hashCode();
            this.hashCode = hashCode;
            return hashCode;
        }
        return i3;
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
        arrayList.add("address=" + Internal.sanitize(this.address));
        arrayList.add("country=" + Internal.sanitize(this.country));
        arrayList.add("province=" + Internal.sanitize(this.province));
        arrayList.add("city=" + Internal.sanitize(this.city));
        arrayList.add("longitude=" + this.longitude);
        arrayList.add("latitude=" + this.latitude);
        arrayList.add("town=" + Internal.sanitize(this.town));
        arrayList.add("village=" + Internal.sanitize(this.village));
        arrayList.add("district=" + Internal.sanitize(this.district));
        arrayList.add("road=" + Internal.sanitize(this.road));
        arrayList.add("displayName=" + Internal.sanitize(this.displayName));
        arrayList.add("poiName=" + Internal.sanitize(this.poiName));
        arrayList.add("poiId=" + Internal.sanitize(this.poiId));
        arrayList.add("poiType=" + this.poiType);
        arrayList.add("poiTypeName=" + Internal.sanitize(this.poiTypeName));
        arrayList.add("poiDefaultName=" + Internal.sanitize(this.poiDefaultName));
        arrayList.add("districtCode=" + this.districtCode);
        arrayList.add("distance=" + this.distance);
        arrayList.add("hotValue=" + this.hotValue);
        arrayList.add("phoneNumber=" + Internal.sanitize(this.phoneNumber));
        arrayList.add("poiOrderType=" + this.poiOrderType);
        arrayList.add("poiNum=" + this.poiNum);
        arrayList.add("dianPingId=" + Internal.sanitize(this.dianPingId));
        joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(arrayList, ", ", "WatermarkPoiModel{", "}", 0, null, null, 56, null);
        return joinToString$default;
    }

    public /* synthetic */ WatermarkPoiModel(String str, String str2, String str3, String str4, float f16, float f17, String str5, String str6, String str7, String str8, String str9, String str10, String str11, int i3, String str12, String str13, int i16, int i17, int i18, String str14, int i19, int i26, String str15, ByteString byteString, int i27, DefaultConstructorMarker defaultConstructorMarker) {
        this((i27 & 1) != 0 ? "" : str, (i27 & 2) != 0 ? "" : str2, (i27 & 4) != 0 ? "" : str3, (i27 & 8) != 0 ? "" : str4, (i27 & 16) != 0 ? 0.0f : f16, (i27 & 32) != 0 ? 0.0f : f17, (i27 & 64) != 0 ? "" : str5, (i27 & 128) != 0 ? "" : str6, (i27 & 256) != 0 ? "" : str7, (i27 & 512) != 0 ? "" : str8, (i27 & 1024) != 0 ? "" : str9, (i27 & 2048) != 0 ? "" : str10, (i27 & 4096) != 0 ? "" : str11, (i27 & 8192) != 0 ? 0 : i3, (i27 & 16384) != 0 ? "" : str12, (32768 & i27) != 0 ? "" : str13, (65536 & i27) != 0 ? 0 : i16, (131072 & i27) != 0 ? 0 : i17, (262144 & i27) != 0 ? 0 : i18, (524288 & i27) != 0 ? "" : str14, (1048576 & i27) != 0 ? 0 : i19, (2097152 & i27) != 0 ? 0 : i26, (4194304 & i27) != 0 ? "" : str15, (8388608 & i27) != 0 ? ByteString.EMPTY : byteString);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, str, str2, str3, str4, Float.valueOf(f16), Float.valueOf(f17), str5, str6, str7, str8, str9, str10, str11, Integer.valueOf(i3), str12, str13, Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18), str14, Integer.valueOf(i19), Integer.valueOf(i26), str15, byteString, Integer.valueOf(i27), defaultConstructorMarker);
    }

    @Override // com.squareup.wire.Message
    @NotNull
    public Builder newBuilder() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Builder) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        Builder builder = new Builder();
        builder.address = this.address;
        builder.country = this.country;
        builder.province = this.province;
        builder.city = this.city;
        builder.longitude = this.longitude;
        builder.latitude = this.latitude;
        builder.town = this.town;
        builder.village = this.village;
        builder.district = this.district;
        builder.road = this.road;
        builder.displayName = this.displayName;
        builder.poiName = this.poiName;
        builder.poiId = this.poiId;
        builder.poiType = this.poiType;
        builder.poiTypeName = this.poiTypeName;
        builder.poiDefaultName = this.poiDefaultName;
        builder.districtCode = this.districtCode;
        builder.distance = this.distance;
        builder.hotValue = this.hotValue;
        builder.phoneNumber = this.phoneNumber;
        builder.poiOrderType = this.poiOrderType;
        builder.poiNum = this.poiNum;
        builder.dianPingId = this.dianPingId;
        builder.addUnknownFields(unknownFields());
        return builder;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WatermarkPoiModel(@NotNull String address, @NotNull String country, @NotNull String province, @NotNull String city, float f16, float f17, @NotNull String town, @NotNull String village, @NotNull String district, @NotNull String road, @NotNull String displayName, @NotNull String poiName, @NotNull String poiId, int i3, @NotNull String poiTypeName, @NotNull String poiDefaultName, int i16, int i17, int i18, @NotNull String phoneNumber, int i19, int i26, @NotNull String dianPingId, @NotNull ByteString unknownFields) {
        super(ADAPTER, unknownFields);
        Intrinsics.checkNotNullParameter(address, "address");
        Intrinsics.checkNotNullParameter(country, "country");
        Intrinsics.checkNotNullParameter(province, "province");
        Intrinsics.checkNotNullParameter(city, "city");
        Intrinsics.checkNotNullParameter(town, "town");
        Intrinsics.checkNotNullParameter(village, "village");
        Intrinsics.checkNotNullParameter(district, "district");
        Intrinsics.checkNotNullParameter(road, "road");
        Intrinsics.checkNotNullParameter(displayName, "displayName");
        Intrinsics.checkNotNullParameter(poiName, "poiName");
        Intrinsics.checkNotNullParameter(poiId, "poiId");
        Intrinsics.checkNotNullParameter(poiTypeName, "poiTypeName");
        Intrinsics.checkNotNullParameter(poiDefaultName, "poiDefaultName");
        Intrinsics.checkNotNullParameter(phoneNumber, "phoneNumber");
        Intrinsics.checkNotNullParameter(dianPingId, "dianPingId");
        Intrinsics.checkNotNullParameter(unknownFields, "unknownFields");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, address, country, province, city, Float.valueOf(f16), Float.valueOf(f17), town, village, district, road, displayName, poiName, poiId, Integer.valueOf(i3), poiTypeName, poiDefaultName, Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18), phoneNumber, Integer.valueOf(i19), Integer.valueOf(i26), dianPingId, unknownFields);
            return;
        }
        this.address = address;
        this.country = country;
        this.province = province;
        this.city = city;
        this.longitude = f16;
        this.latitude = f17;
        this.town = town;
        this.village = village;
        this.district = district;
        this.road = road;
        this.displayName = displayName;
        this.poiName = poiName;
        this.poiId = poiId;
        this.poiType = i3;
        this.poiTypeName = poiTypeName;
        this.poiDefaultName = poiDefaultName;
        this.districtCode = i16;
        this.distance = i17;
        this.hotValue = i18;
        this.phoneNumber = phoneNumber;
        this.poiOrderType = i19;
        this.poiNum = i26;
        this.dianPingId = dianPingId;
    }
}
