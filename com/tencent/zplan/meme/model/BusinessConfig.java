package com.tencent.zplan.meme.model;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.jsengine.animation.basic.BasicAnimation;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.zplan.encode.IEncoder;
import com.tencent.zplan.meme.EngineType;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.android.parcel.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;
import tl.h;

/* compiled from: P */
@Parcelize
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\bN\b\u0087\b\u0018\u0000 o2\u00020\u0001:\u0006p\u001aqrstB\u00bb\u0001\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0004\u0012\b\b\u0002\u0010\t\u001a\u00020\b\u0012\b\b\u0002\u0010\n\u001a\u00020\u0002\u0012\b\b\u0002\u0010\f\u001a\u00020\u000b\u0012\b\b\u0002\u0010\u000e\u001a\u00020\r\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0011\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0014\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0004\u00a2\u0006\u0004\bm\u0010nJ\u00c4\u0001\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00042\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\u00022\b\b\u0002\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\u000e\u001a\u00020\r2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u0012\u001a\u00020\u00112\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u0015\u001a\u00020\u00142\b\b\u0002\u0010\u0016\u001a\u00020\u00042\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u0018\u001a\u00020\u00022\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0004H\u00c6\u0001\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\t\u0010\u001c\u001a\u00020\u0014H\u00d6\u0001J\t\u0010\u001d\u001a\u00020\u0002H\u00d6\u0001J\u0013\u0010 \u001a\u00020\u00042\b\u0010\u001f\u001a\u0004\u0018\u00010\u001eH\u00d6\u0003J\t\u0010!\u001a\u00020\u0002H\u00d6\u0001J\u0019\u0010&\u001a\u00020%2\u0006\u0010#\u001a\u00020\"2\u0006\u0010$\u001a\u00020\u0002H\u00d6\u0001R$\u0010.\u001a\u0004\u0018\u00010'8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b/\u00100\u001a\u0004\b1\u00102\"\u0004\b3\u00104R\"\u0010\u0005\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b5\u00106\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R\"\u0010\u0006\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b;\u00106\u001a\u0004\b<\u00108\"\u0004\b=\u0010:R\"\u0010\u0007\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b>\u00106\u001a\u0004\b?\u00108\"\u0004\b@\u0010:R\"\u0010\t\u001a\u00020\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b7\u0010A\u001a\u0004\bB\u0010C\"\u0004\bD\u0010ER\"\u0010\n\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bD\u00100\u001a\u0004\bF\u00102\"\u0004\bG\u00104R\u0017\u0010\f\u001a\u00020\u000b8\u0006\u00a2\u0006\f\n\u0004\bG\u0010H\u001a\u0004\bI\u0010JR\u0017\u0010\u000e\u001a\u00020\r8\u0006\u00a2\u0006\f\n\u0004\b=\u0010K\u001a\u0004\bL\u0010MR$\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bN\u0010O\u001a\u0004\b/\u0010P\"\u0004\bQ\u0010RR$\u0010\u0010\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b,\u0010O\u001a\u0004\bS\u0010P\"\u0004\bT\u0010RR\u0017\u0010\u0012\u001a\u00020\u00118\u0006\u00a2\u0006\f\n\u0004\bU\u0010V\u001a\u0004\bW\u0010XR$\u0010\u0013\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b0\u0010Y\u001a\u0004\bZ\u0010[\"\u0004\b\\\u0010]R\"\u0010\u0015\u001a\u00020\u00148\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b^\u0010_\u001a\u0004\b`\u0010a\"\u0004\bN\u0010bR\"\u0010\u0016\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bc\u00106\u001a\u0004\bd\u00108\"\u0004\be\u0010:R$\u0010\u0017\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bf\u0010Y\u001a\u0004\bg\u0010[\"\u0004\bh\u0010]R\"\u0010\u0018\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\be\u00100\u001a\u0004\b5\u00102\"\u0004\bi\u00104R$\u0010\u0019\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bj\u0010Y\u001a\u0004\bk\u0010[\"\u0004\bl\u0010]\u00a8\u0006u"}, d2 = {"Lcom/tencent/zplan/meme/model/BusinessConfig;", "Landroid/os/Parcelable;", "", "backgroundColor", "", "flipVertical", "saveEachFrame2File", "callbackEachFrameData", "Lcom/tencent/zplan/meme/model/BusinessConfig$FrameType;", "frameType", "maxFrameCount", "Lcom/tencent/zplan/meme/model/BusinessConfig$Optimization;", "optimization", "Lcom/tencent/zplan/meme/model/BusinessConfig$Camera;", "camera", "aaType", "aaLevel", "Lcom/tencent/zplan/meme/model/BusinessConfig$Mp4EncodeConfig;", "mp4Config", "skipHotPatch", "", "stickerData", "useRecordV2", "enableUserData", "actionStyle", "disableGlassesMetallic", "a", "(IZZZLcom/tencent/zplan/meme/model/BusinessConfig$FrameType;ILcom/tencent/zplan/meme/model/BusinessConfig$Optimization;Lcom/tencent/zplan/meme/model/BusinessConfig$Camera;Ljava/lang/Integer;Ljava/lang/Integer;Lcom/tencent/zplan/meme/model/BusinessConfig$Mp4EncodeConfig;Ljava/lang/Boolean;Ljava/lang/String;ZLjava/lang/Boolean;ILjava/lang/Boolean;)Lcom/tencent/zplan/meme/model/BusinessConfig;", "toString", "hashCode", "", "other", "equals", "describeContents", "Landroid/os/Parcel;", "parcel", WadlProxyConsts.FLAGS, "", "writeToParcel", "Lcom/tencent/zplan/meme/EngineType;", "d", "Lcom/tencent/zplan/meme/EngineType;", "t", "()Lcom/tencent/zplan/meme/EngineType;", "G", "(Lcom/tencent/zplan/meme/EngineType;)V", "targetEngine", "e", "I", "g", "()I", "y", "(I)V", "f", "Z", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "()Z", "B", "(Z)V", h.F, QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "E", "i", "getCallbackEachFrameData", "setCallbackEachFrameData", "Lcom/tencent/zplan/meme/model/BusinessConfig$FrameType;", DomainData.DOMAIN_NAME, "()Lcom/tencent/zplan/meme/model/BusinessConfig$FrameType;", BdhLogUtil.LogTag.Tag_Conn, "(Lcom/tencent/zplan/meme/model/BusinessConfig$FrameType;)V", "getMaxFrameCount", "D", "Lcom/tencent/zplan/meme/model/BusinessConfig$Optimization;", "p", "()Lcom/tencent/zplan/meme/model/BusinessConfig$Optimization;", "Lcom/tencent/zplan/meme/model/BusinessConfig$Camera;", "j", "()Lcom/tencent/zplan/meme/model/BusinessConfig$Camera;", UserInfo.SEX_FEMALE, "Ljava/lang/Integer;", "()Ljava/lang/Integer;", "w", "(Ljava/lang/Integer;)V", "c", "v", "H", "Lcom/tencent/zplan/meme/model/BusinessConfig$Mp4EncodeConfig;", "o", "()Lcom/tencent/zplan/meme/model/BusinessConfig$Mp4EncodeConfig;", "Ljava/lang/Boolean;", "r", "()Ljava/lang/Boolean;", "setSkipHotPatch", "(Ljava/lang/Boolean;)V", "J", "Ljava/lang/String;", ReportConstant.COSTREPORT_PREFIX, "()Ljava/lang/String;", "(Ljava/lang/String;)V", "K", "u", "M", "L", "l", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, HippyTKDListViewAdapter.X, "N", "k", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "<init>", "(IZZZLcom/tencent/zplan/meme/model/BusinessConfig$FrameType;ILcom/tencent/zplan/meme/model/BusinessConfig$Optimization;Lcom/tencent/zplan/meme/model/BusinessConfig$Camera;Ljava/lang/Integer;Ljava/lang/Integer;Lcom/tencent/zplan/meme/model/BusinessConfig$Mp4EncodeConfig;Ljava/lang/Boolean;Ljava/lang/String;ZLjava/lang/Boolean;ILjava/lang/Boolean;)V", "P", "Camera", "Cover", "FrameType", "Mp4EncodeConfig", "Optimization", "record_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes27.dex */
public final /* data */ class BusinessConfig implements Parcelable {

    /* renamed from: C, reason: from kotlin metadata and from toString */
    private int maxFrameCount;

    /* renamed from: D, reason: from kotlin metadata and from toString */
    @NotNull
    private final Optimization optimization;

    /* renamed from: E, reason: from kotlin metadata and from toString */
    @NotNull
    private final Camera camera;

    /* renamed from: F, reason: from kotlin metadata and from toString */
    @Nullable
    private Integer aaType;

    /* renamed from: G, reason: from kotlin metadata and from toString */
    @Nullable
    private Integer aaLevel;

    /* renamed from: H, reason: from kotlin metadata and from toString */
    @NotNull
    private final Mp4EncodeConfig mp4Config;

    /* renamed from: I, reason: from kotlin metadata and from toString */
    @Nullable
    private Boolean skipHotPatch;

    /* renamed from: J, reason: from kotlin metadata and from toString */
    @NotNull
    private String stickerData;

    /* renamed from: K, reason: from kotlin metadata and from toString */
    private boolean useRecordV2;

    /* renamed from: L, reason: from kotlin metadata and from toString */
    @Nullable
    private Boolean enableUserData;

    /* renamed from: M, reason: from kotlin metadata and from toString */
    private int actionStyle;

    /* renamed from: N, reason: from kotlin metadata and from toString */
    @Nullable
    private Boolean disableGlassesMetallic;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private EngineType targetEngine;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    private int backgroundColor;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    private boolean flipVertical;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata and from toString */
    private boolean saveEachFrame2File;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata and from toString */
    private boolean callbackEachFrameData;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private FrameType frameType;
    public static final Parcelable.Creator<BusinessConfig> CREATOR = new b();

    /* compiled from: P */
    @Parcelize
    @Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\b\u0087\b\u0018\u00002\u00020\u0001BI\u0012\u0010\b\u0002\u0010\u0019\u001a\n\u0018\u00010\u0004j\u0004\u0018\u0001`\u0012\u0012\u0010\b\u0002\u0010\u001d\u001a\n\u0018\u00010\u0004j\u0004\u0018\u0001`\u001a\u0012\u0010\b\u0002\u0010!\u001a\n\u0018\u00010\u0004j\u0004\u0018\u0001`\u001e\u0012\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\u0004\u00a2\u0006\u0004\b&\u0010'J\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\t\u0010\u0007\u001a\u00020\u0006H\u00d6\u0001J\u0013\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u00d6\u0003J\t\u0010\f\u001a\u00020\u0006H\u00d6\u0001J\u0019\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0006H\u00d6\u0001R*\u0010\u0019\u001a\n\u0018\u00010\u0004j\u0004\u0018\u0001`\u00128\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R*\u0010\u001d\u001a\n\u0018\u00010\u0004j\u0004\u0018\u0001`\u001a8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001b\u0010\u0014\u001a\u0004\b\u001c\u0010\u0016\"\u0004\b\u001b\u0010\u0018R*\u0010!\u001a\n\u0018\u00010\u0004j\u0004\u0018\u0001`\u001e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0014\u001a\u0004\b\u001f\u0010\u0016\"\u0004\b \u0010\u0018R$\u0010%\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\"\u0010\u0014\u001a\u0004\b#\u0010\u0016\"\u0004\b$\u0010\u0018\u00a8\u0006("}, d2 = {"Lcom/tencent/zplan/meme/model/BusinessConfig$Camera;", "Landroid/os/Parcelable;", "Lorg/json/JSONObject;", "f", "", "toString", "", "hashCode", "", "other", "", "equals", "describeContents", "Landroid/os/Parcel;", "parcel", WadlProxyConsts.FLAGS, "", "writeToParcel", "Lcom/tencent/zplan/meme/model/Location;", "d", "Ljava/lang/String;", "getLocation", "()Ljava/lang/String;", "a", "(Ljava/lang/String;)V", "location", "Lcom/tencent/zplan/meme/model/Rotation;", "e", "getRotation", BasicAnimation.KeyPath.ROTATION, "Lcom/tencent/zplan/meme/model/Projection;", "getProjection", "b", "projection", h.F, "getRaw", "c", "raw", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "record_debug"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes27.dex */
    public static final /* data */ class Camera implements Parcelable {
        public static final Parcelable.Creator<Camera> CREATOR = new a();

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        @Nullable
        private String location;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
        @Nullable
        private String rotation;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
        @Nullable
        private String projection;

        /* renamed from: h, reason: collision with root package name and from kotlin metadata and from toString */
        @Nullable
        private String raw;

        /* compiled from: P */
        @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 2})
        /* loaded from: classes27.dex */
        public static class a implements Parcelable.Creator<Camera> {
            @Override // android.os.Parcelable.Creator
            @NotNull
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final Camera createFromParcel(@NotNull Parcel in5) {
                Intrinsics.checkNotNullParameter(in5, "in");
                return new Camera(in5.readString(), in5.readString(), in5.readString(), in5.readString());
            }

            @Override // android.os.Parcelable.Creator
            @NotNull
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Camera[] newArray(int i3) {
                return new Camera[i3];
            }
        }

        public Camera() {
            this(null, null, null, null, 15, null);
        }

        public final void a(@Nullable String str) {
            this.location = str;
        }

        public final void b(@Nullable String str) {
            this.projection = str;
        }

        public final void c(@Nullable String str) {
            this.raw = str;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public final void e(@Nullable String str) {
            this.rotation = str;
        }

        public boolean equals(@Nullable Object other) {
            if (this != other) {
                if (other instanceof Camera) {
                    Camera camera2 = (Camera) other;
                    if (!Intrinsics.areEqual(this.location, camera2.location) || !Intrinsics.areEqual(this.rotation, camera2.rotation) || !Intrinsics.areEqual(this.projection, camera2.projection) || !Intrinsics.areEqual(this.raw, camera2.raw)) {
                        return false;
                    }
                    return true;
                }
                return false;
            }
            return true;
        }

        @Nullable
        public final JSONObject f() {
            boolean z16;
            com.tencent.zplan.common.utils.h hVar = com.tencent.zplan.common.utils.h.f385294a;
            JSONObject b16 = hVar.b(this.location);
            JSONObject b17 = hVar.b(this.rotation);
            JSONObject b18 = hVar.b(this.projection);
            String str = this.raw;
            if (b16 == null && b17 == null && b18 == null) {
                if (str != null && str.length() != 0) {
                    z16 = false;
                } else {
                    z16 = true;
                }
                if (z16) {
                    return null;
                }
            }
            JSONObject jSONObject = new JSONObject();
            if (b16 != null) {
                jSONObject.put("location", b16);
            }
            if (b17 != null) {
                jSONObject.put(BasicAnimation.KeyPath.ROTATION, b17);
            }
            if (b18 != null) {
                jSONObject.put("projection", b18);
            }
            if (str != null) {
                jSONObject.put("raw", str);
            }
            return jSONObject;
        }

        public int hashCode() {
            int i3;
            int i16;
            int i17;
            String str = this.location;
            int i18 = 0;
            if (str != null) {
                i3 = str.hashCode();
            } else {
                i3 = 0;
            }
            int i19 = i3 * 31;
            String str2 = this.rotation;
            if (str2 != null) {
                i16 = str2.hashCode();
            } else {
                i16 = 0;
            }
            int i26 = (i19 + i16) * 31;
            String str3 = this.projection;
            if (str3 != null) {
                i17 = str3.hashCode();
            } else {
                i17 = 0;
            }
            int i27 = (i26 + i17) * 31;
            String str4 = this.raw;
            if (str4 != null) {
                i18 = str4.hashCode();
            }
            return i27 + i18;
        }

        @NotNull
        public String toString() {
            return "Camera(location=" + this.location + ", rotation=" + this.rotation + ", projection=" + this.projection + ", raw=" + this.raw + ")";
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel parcel, int flags) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            parcel.writeString(this.location);
            parcel.writeString(this.rotation);
            parcel.writeString(this.projection);
            parcel.writeString(this.raw);
        }

        public Camera(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4) {
            this.location = str;
            this.rotation = str2;
            this.projection = str3;
            this.raw = str4;
        }

        public /* synthetic */ Camera(String str, String str2, String str3, String str4, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this((i3 & 1) != 0 ? null : str, (i3 & 2) != 0 ? null : str2, (i3 & 4) != 0 ? null : str3, (i3 & 8) != 0 ? null : str4);
        }
    }

    /* compiled from: P */
    @Parcelize
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0012\b\u0087\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0016\u001a\u00020\b\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u0004\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003J\t\u0010\n\u001a\u00020\u0004H\u00d6\u0001J\u0019\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u0004H\u00d6\u0001R\"\u0010\u0016\u001a\u00020\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\"\u0010\u001d\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001c\u00a8\u0006 "}, d2 = {"Lcom/tencent/zplan/meme/model/BusinessConfig$Cover;", "Landroid/os/Parcelable;", "", "toString", "", "hashCode", "", "other", "", "equals", "describeContents", "Landroid/os/Parcel;", "parcel", WadlProxyConsts.FLAGS, "", "writeToParcel", "d", "Z", "b", "()Z", "c", "(Z)V", "saveCover", "e", "I", "a", "()I", "setCoverIndex", "(I)V", "coverIndex", "<init>", "(ZI)V", "record_debug"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes27.dex */
    public static final /* data */ class Cover implements Parcelable {
        public static final Parcelable.Creator<Cover> CREATOR = new a();

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        private boolean saveCover;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
        private int coverIndex;

        /* compiled from: P */
        @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 2})
        /* loaded from: classes27.dex */
        public static class a implements Parcelable.Creator<Cover> {
            @Override // android.os.Parcelable.Creator
            @NotNull
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final Cover createFromParcel(@NotNull Parcel in5) {
                boolean z16;
                Intrinsics.checkNotNullParameter(in5, "in");
                if (in5.readInt() != 0) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                return new Cover(z16, in5.readInt());
            }

            @Override // android.os.Parcelable.Creator
            @NotNull
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Cover[] newArray(int i3) {
                return new Cover[i3];
            }
        }

        public Cover() {
            this(false, 0 == true ? 1 : 0, 3, null);
        }

        /* renamed from: a, reason: from getter */
        public final int getCoverIndex() {
            return this.coverIndex;
        }

        /* renamed from: b, reason: from getter */
        public final boolean getSaveCover() {
            return this.saveCover;
        }

        public final void c(boolean z16) {
            this.saveCover = z16;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean equals(@Nullable Object other) {
            if (this != other) {
                if (other instanceof Cover) {
                    Cover cover = (Cover) other;
                    if (this.saveCover != cover.saveCover || this.coverIndex != cover.coverIndex) {
                        return false;
                    }
                    return true;
                }
                return false;
            }
            return true;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v1, types: [int] */
        /* JADX WARN: Type inference failed for: r0v4 */
        /* JADX WARN: Type inference failed for: r0v5 */
        public int hashCode() {
            boolean z16 = this.saveCover;
            ?? r06 = z16;
            if (z16) {
                r06 = 1;
            }
            return (r06 * 31) + this.coverIndex;
        }

        @NotNull
        public String toString() {
            return "Cover(saveCover=" + this.saveCover + ", coverIndex=" + this.coverIndex + ")";
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel parcel, int flags) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            parcel.writeInt(this.saveCover ? 1 : 0);
            parcel.writeInt(this.coverIndex);
        }

        public Cover(boolean z16, int i3) {
            this.saveCover = z16;
            this.coverIndex = i3;
        }

        public /* synthetic */ Cover(boolean z16, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
            this((i16 & 1) != 0 ? false : z16, (i16 & 2) != 0 ? 0 : i3);
        }
    }

    /* compiled from: P */
    @Parcelize
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0003J\t\u0010\u0004\u001a\u00020\u0005H\u00d6\u0001J\u0006\u0010\u0006\u001a\u00020\u0007J\u0019\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0005H\u00d6\u0001j\u0002\b\rj\u0002\b\u000e\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/zplan/meme/model/BusinessConfig$FrameType;", "", "Landroid/os/Parcelable;", "(Ljava/lang/String;I)V", "describeContents", "", "suffix", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", WadlProxyConsts.FLAGS, "PNG", "JPG", "record_debug"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes27.dex */
    public enum FrameType implements Parcelable {
        PNG,
        JPG;

        public static final Parcelable.Creator<FrameType> CREATOR = new a();

        /* compiled from: P */
        @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 2})
        /* loaded from: classes27.dex */
        public static class a implements Parcelable.Creator<FrameType> {
            @Override // android.os.Parcelable.Creator
            @NotNull
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final FrameType createFromParcel(@NotNull Parcel in5) {
                Intrinsics.checkNotNullParameter(in5, "in");
                return (FrameType) Enum.valueOf(FrameType.class, in5.readString());
            }

            @Override // android.os.Parcelable.Creator
            @NotNull
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public final FrameType[] newArray(int i3) {
                return new FrameType[i3];
            }
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @NotNull
        public final String suffix() {
            int i3 = com.tencent.zplan.meme.model.b.f385905a[ordinal()];
            if (i3 != 1) {
                if (i3 == 2) {
                    return ".jpg";
                }
                throw new NoWhenBranchMatchedException();
            }
            return ".png";
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel parcel, int flags) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            parcel.writeString(name());
        }
    }

    /* compiled from: P */
    @Parcelize
    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0019\n\u0002\u0018\u0002\n\u0002\b\r\b\u0087\b\u0018\u00002\u00020\u0001BM\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u0004\u0012\b\b\u0002\u0010$\u001a\u00020\b\u0012\b\b\u0002\u0010'\u001a\u00020\u0004\u0012\b\b\u0002\u0010/\u001a\u00020(\u0012\b\b\u0003\u00102\u001a\u00020\u0004\u00a2\u0006\u0004\b3\u00104J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003J\t\u0010\n\u001a\u00020\u0004H\u00d6\u0001J\u0019\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u0004H\u00d6\u0001R\"\u0010\u0016\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\"\u0010\u001a\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0017\u0010\u0011\u001a\u0004\b\u0018\u0010\u0013\"\u0004\b\u0019\u0010\u0015R\"\u0010\u001e\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001b\u0010\u0011\u001a\u0004\b\u001c\u0010\u0013\"\u0004\b\u001d\u0010\u0015R\"\u0010$\u001a\u00020\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b\u0017\u0010!\"\u0004\b\"\u0010#R\"\u0010'\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b%\u0010\u0011\u001a\u0004\b\u001b\u0010\u0013\"\u0004\b&\u0010\u0015R\"\u0010/\u001a\u00020(8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\"\u00102\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b0\u0010\u0011\u001a\u0004\b1\u0010\u0013\"\u0004\b)\u0010\u0015\u00a8\u00065"}, d2 = {"Lcom/tencent/zplan/meme/model/BusinessConfig$Mp4EncodeConfig;", "Landroid/os/Parcelable;", "", "toString", "", "hashCode", "", "other", "", "equals", "describeContents", "Landroid/os/Parcel;", "parcel", WadlProxyConsts.FLAGS, "", "writeToParcel", "d", "I", "a", "()I", "setBitRate", "(I)V", "bitRate", "e", "b", "setBitRateMode", "bitRateMode", "f", "getMp4Type", "setMp4Type", "mp4Type", h.F, "Z", "()Z", "k", "(Z)V", "debugger", "i", "l", "encodeType", "Lcom/tencent/zplan/meme/model/BusinessConfig$Cover;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/zplan/meme/model/BusinessConfig$Cover;", "c", "()Lcom/tencent/zplan/meme/model/BusinessConfig$Cover;", "j", "(Lcom/tencent/zplan/meme/model/BusinessConfig$Cover;)V", "cover", BdhLogUtil.LogTag.Tag_Conn, "g", "mode", "<init>", "(IIIZILcom/tencent/zplan/meme/model/BusinessConfig$Cover;I)V", "record_debug"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes27.dex */
    public static final /* data */ class Mp4EncodeConfig implements Parcelable {
        public static final Parcelable.Creator<Mp4EncodeConfig> CREATOR = new a();

        /* renamed from: C, reason: from kotlin metadata and from toString */
        private int mode;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        private int bitRate;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
        private int bitRateMode;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
        private int mp4Type;

        /* renamed from: h, reason: collision with root package name and from kotlin metadata and from toString */
        private boolean debugger;

        /* renamed from: i, reason: collision with root package name and from kotlin metadata and from toString */
        private int encodeType;

        /* renamed from: m, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private Cover cover;

        /* compiled from: P */
        @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 2})
        /* loaded from: classes27.dex */
        public static class a implements Parcelable.Creator<Mp4EncodeConfig> {
            @Override // android.os.Parcelable.Creator
            @NotNull
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final Mp4EncodeConfig createFromParcel(@NotNull Parcel in5) {
                boolean z16;
                Intrinsics.checkNotNullParameter(in5, "in");
                int readInt = in5.readInt();
                int readInt2 = in5.readInt();
                int readInt3 = in5.readInt();
                if (in5.readInt() != 0) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                return new Mp4EncodeConfig(readInt, readInt2, readInt3, z16, in5.readInt(), Cover.CREATOR.createFromParcel(in5), in5.readInt());
            }

            @Override // android.os.Parcelable.Creator
            @NotNull
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Mp4EncodeConfig[] newArray(int i3) {
                return new Mp4EncodeConfig[i3];
            }
        }

        public Mp4EncodeConfig() {
            this(0, 0, 0, false, 0, null, 0, 127, null);
        }

        /* renamed from: a, reason: from getter */
        public final int getBitRate() {
            return this.bitRate;
        }

        /* renamed from: b, reason: from getter */
        public final int getBitRateMode() {
            return this.bitRateMode;
        }

        @NotNull
        /* renamed from: c, reason: from getter */
        public final Cover getCover() {
            return this.cover;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        /* renamed from: e, reason: from getter */
        public final boolean getDebugger() {
            return this.debugger;
        }

        public boolean equals(@Nullable Object other) {
            if (this != other) {
                if (other instanceof Mp4EncodeConfig) {
                    Mp4EncodeConfig mp4EncodeConfig = (Mp4EncodeConfig) other;
                    if (this.bitRate != mp4EncodeConfig.bitRate || this.bitRateMode != mp4EncodeConfig.bitRateMode || this.mp4Type != mp4EncodeConfig.mp4Type || this.debugger != mp4EncodeConfig.debugger || this.encodeType != mp4EncodeConfig.encodeType || !Intrinsics.areEqual(this.cover, mp4EncodeConfig.cover) || this.mode != mp4EncodeConfig.mode) {
                        return false;
                    }
                    return true;
                }
                return false;
            }
            return true;
        }

        /* renamed from: f, reason: from getter */
        public final int getEncodeType() {
            return this.encodeType;
        }

        /* renamed from: g, reason: from getter */
        public final int getMode() {
            return this.mode;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            int i3;
            int i16 = ((((this.bitRate * 31) + this.bitRateMode) * 31) + this.mp4Type) * 31;
            boolean z16 = this.debugger;
            int i17 = z16;
            if (z16 != 0) {
                i17 = 1;
            }
            int i18 = (((i16 + i17) * 31) + this.encodeType) * 31;
            Cover cover = this.cover;
            if (cover != null) {
                i3 = cover.hashCode();
            } else {
                i3 = 0;
            }
            return ((i18 + i3) * 31) + this.mode;
        }

        public final void j(@NotNull Cover cover) {
            Intrinsics.checkNotNullParameter(cover, "<set-?>");
            this.cover = cover;
        }

        public final void k(boolean z16) {
            this.debugger = z16;
        }

        public final void l(int i3) {
            this.encodeType = i3;
        }

        public final void m(int i3) {
            this.mode = i3;
        }

        @NotNull
        public String toString() {
            return "Mp4EncodeConfig(bitRate=" + this.bitRate + ", bitRateMode=" + this.bitRateMode + ", mp4Type=" + this.mp4Type + ", debugger=" + this.debugger + ", encodeType=" + this.encodeType + ", cover=" + this.cover + ", mode=" + this.mode + ")";
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel parcel, int flags) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            parcel.writeInt(this.bitRate);
            parcel.writeInt(this.bitRateMode);
            parcel.writeInt(this.mp4Type);
            parcel.writeInt(this.debugger ? 1 : 0);
            parcel.writeInt(this.encodeType);
            this.cover.writeToParcel(parcel, 0);
            parcel.writeInt(this.mode);
        }

        public Mp4EncodeConfig(int i3, int i16, int i17, boolean z16, int i18, @NotNull Cover cover, @IEncoder.EncodeMode int i19) {
            Intrinsics.checkNotNullParameter(cover, "cover");
            this.bitRate = i3;
            this.bitRateMode = i16;
            this.mp4Type = i17;
            this.debugger = z16;
            this.encodeType = i18;
            this.cover = cover;
            this.mode = i19;
        }

        public /* synthetic */ Mp4EncodeConfig(int i3, int i16, int i17, boolean z16, int i18, Cover cover, int i19, int i26, DefaultConstructorMarker defaultConstructorMarker) {
            this((i26 & 1) != 0 ? -1 : i3, (i26 & 2) != 0 ? 1 : i16, (i26 & 4) == 0 ? i17 : 1, (i26 & 8) != 0 ? false : z16, (i26 & 16) != 0 ? 0 : i18, (i26 & 32) != 0 ? new Cover(false, 0 == true ? 1 : 0, 3, null) : cover, (i26 & 64) != 0 ? 0 : i19);
        }
    }

    /* compiled from: P */
    @Parcelize
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u000f\b\u0087\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0016\u001a\u00020\b\u0012\b\b\u0002\u0010\u001a\u001a\u00020\b\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003J\t\u0010\n\u001a\u00020\u0004H\u00d6\u0001J\u0019\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u0004H\u00d6\u0001R\"\u0010\u0016\u001a\u00020\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\"\u0010\u001a\u001a\u00020\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0017\u0010\u0011\u001a\u0004\b\u0018\u0010\u0013\"\u0004\b\u0019\u0010\u0015\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/zplan/meme/model/BusinessConfig$Optimization;", "Landroid/os/Parcelable;", "", "toString", "", "hashCode", "", "other", "", "equals", "describeContents", "Landroid/os/Parcel;", "parcel", WadlProxyConsts.FLAGS, "", "writeToParcel", "d", "Z", "b", "()Z", "setApngFullRectMode", "(Z)V", "apngFullRectMode", "e", "a", "setApngCompressMode", "apngCompressMode", "<init>", "(ZZ)V", "record_debug"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes27.dex */
    public static final /* data */ class Optimization implements Parcelable {
        public static final Parcelable.Creator<Optimization> CREATOR = new a();

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        private boolean apngFullRectMode;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
        private boolean apngCompressMode;

        /* compiled from: P */
        @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 2})
        /* loaded from: classes27.dex */
        public static class a implements Parcelable.Creator<Optimization> {
            @Override // android.os.Parcelable.Creator
            @NotNull
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final Optimization createFromParcel(@NotNull Parcel in5) {
                boolean z16;
                Intrinsics.checkNotNullParameter(in5, "in");
                boolean z17 = true;
                if (in5.readInt() != 0) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (in5.readInt() == 0) {
                    z17 = false;
                }
                return new Optimization(z16, z17);
            }

            @Override // android.os.Parcelable.Creator
            @NotNull
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Optimization[] newArray(int i3) {
                return new Optimization[i3];
            }
        }

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public Optimization() {
            this(r2, r2, 3, null);
            boolean z16 = false;
        }

        /* renamed from: a, reason: from getter */
        public final boolean getApngCompressMode() {
            return this.apngCompressMode;
        }

        /* renamed from: b, reason: from getter */
        public final boolean getApngFullRectMode() {
            return this.apngFullRectMode;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean equals(@Nullable Object other) {
            if (this != other) {
                if (other instanceof Optimization) {
                    Optimization optimization = (Optimization) other;
                    if (this.apngFullRectMode != optimization.apngFullRectMode || this.apngCompressMode != optimization.apngCompressMode) {
                        return false;
                    }
                    return true;
                }
                return false;
            }
            return true;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v1, types: [int] */
        /* JADX WARN: Type inference failed for: r0v4 */
        /* JADX WARN: Type inference failed for: r0v5 */
        public int hashCode() {
            boolean z16 = this.apngFullRectMode;
            int i3 = 1;
            ?? r06 = z16;
            if (z16) {
                r06 = 1;
            }
            int i16 = r06 * 31;
            boolean z17 = this.apngCompressMode;
            if (!z17) {
                i3 = z17 ? 1 : 0;
            }
            return i16 + i3;
        }

        @NotNull
        public String toString() {
            return "Optimization(apngFullRectMode=" + this.apngFullRectMode + ", apngCompressMode=" + this.apngCompressMode + ")";
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel parcel, int flags) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            parcel.writeInt(this.apngFullRectMode ? 1 : 0);
            parcel.writeInt(this.apngCompressMode ? 1 : 0);
        }

        public Optimization(boolean z16, boolean z17) {
            this.apngFullRectMode = z16;
            this.apngCompressMode = z17;
        }

        public /* synthetic */ Optimization(boolean z16, boolean z17, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this((i3 & 1) != 0 ? true : z16, (i3 & 2) != 0 ? true : z17);
        }
    }

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 2})
    /* loaded from: classes27.dex */
    public static class b implements Parcelable.Creator<BusinessConfig> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final BusinessConfig createFromParcel(@NotNull Parcel in5) {
            boolean z16;
            boolean z17;
            boolean z18;
            Integer num;
            Integer num2;
            Boolean bool;
            boolean z19;
            Boolean bool2;
            Boolean bool3;
            boolean z26;
            boolean z27;
            Intrinsics.checkNotNullParameter(in5, "in");
            int readInt = in5.readInt();
            boolean z28 = true;
            if (in5.readInt() != 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (in5.readInt() != 0) {
                z17 = true;
            } else {
                z17 = false;
            }
            if (in5.readInt() != 0) {
                z18 = true;
            } else {
                z18 = false;
            }
            FrameType frameType = (FrameType) Enum.valueOf(FrameType.class, in5.readString());
            int readInt2 = in5.readInt();
            Optimization createFromParcel = Optimization.CREATOR.createFromParcel(in5);
            Camera createFromParcel2 = Camera.CREATOR.createFromParcel(in5);
            if (in5.readInt() != 0) {
                num = Integer.valueOf(in5.readInt());
            } else {
                num = null;
            }
            if (in5.readInt() != 0) {
                num2 = Integer.valueOf(in5.readInt());
            } else {
                num2 = null;
            }
            Mp4EncodeConfig createFromParcel3 = Mp4EncodeConfig.CREATOR.createFromParcel(in5);
            if (in5.readInt() != 0) {
                if (in5.readInt() != 0) {
                    z27 = true;
                } else {
                    z27 = false;
                }
                bool = Boolean.valueOf(z27);
            } else {
                bool = null;
            }
            String readString = in5.readString();
            if (in5.readInt() != 0) {
                z19 = true;
            } else {
                z19 = false;
            }
            if (in5.readInt() != 0) {
                if (in5.readInt() != 0) {
                    z26 = true;
                } else {
                    z26 = false;
                }
                bool2 = Boolean.valueOf(z26);
            } else {
                bool2 = null;
            }
            int readInt3 = in5.readInt();
            if (in5.readInt() != 0) {
                if (in5.readInt() == 0) {
                    z28 = false;
                }
                bool3 = Boolean.valueOf(z28);
            } else {
                bool3 = null;
            }
            return new BusinessConfig(readInt, z16, z17, z18, frameType, readInt2, createFromParcel, createFromParcel2, num, num2, createFromParcel3, bool, readString, z19, bool2, readInt3, bool3);
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final BusinessConfig[] newArray(int i3) {
            return new BusinessConfig[i3];
        }
    }

    public BusinessConfig() {
        this(0, false, false, false, null, 0, null, null, null, null, null, null, null, false, null, 0, null, 131071, null);
    }

    public final void A(@Nullable Boolean bool) {
        this.enableUserData = bool;
    }

    public final void B(boolean z16) {
        this.flipVertical = z16;
    }

    public final void C(@NotNull FrameType frameType) {
        Intrinsics.checkNotNullParameter(frameType, "<set-?>");
        this.frameType = frameType;
    }

    public final void D(int i3) {
        this.maxFrameCount = i3;
    }

    public final void E(boolean z16) {
        this.saveEachFrame2File = z16;
    }

    public final void F(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.stickerData = str;
    }

    public final void G(@Nullable EngineType engineType) {
        this.targetEngine = engineType;
    }

    public final void M(boolean z16) {
        this.useRecordV2 = z16;
    }

    @NotNull
    public final BusinessConfig a(int backgroundColor, boolean flipVertical, boolean saveEachFrame2File, boolean callbackEachFrameData, @NotNull FrameType frameType, int maxFrameCount, @NotNull Optimization optimization, @NotNull Camera camera2, @Nullable Integer aaType, @Nullable Integer aaLevel, @NotNull Mp4EncodeConfig mp4Config, @Nullable Boolean skipHotPatch, @NotNull String stickerData, boolean useRecordV2, @Nullable Boolean enableUserData, int actionStyle, @Nullable Boolean disableGlassesMetallic) {
        Intrinsics.checkNotNullParameter(frameType, "frameType");
        Intrinsics.checkNotNullParameter(optimization, "optimization");
        Intrinsics.checkNotNullParameter(camera2, "camera");
        Intrinsics.checkNotNullParameter(mp4Config, "mp4Config");
        Intrinsics.checkNotNullParameter(stickerData, "stickerData");
        return new BusinessConfig(backgroundColor, flipVertical, saveEachFrame2File, callbackEachFrameData, frameType, maxFrameCount, optimization, camera2, aaType, aaLevel, mp4Config, skipHotPatch, stickerData, useRecordV2, enableUserData, actionStyle, disableGlassesMetallic);
    }

    @Nullable
    /* renamed from: c, reason: from getter */
    public final Integer getAaLevel() {
        return this.aaLevel;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Nullable
    /* renamed from: e, reason: from getter */
    public final Integer getAaType() {
        return this.aaType;
    }

    public boolean equals(@Nullable Object other) {
        if (this != other) {
            if (other instanceof BusinessConfig) {
                BusinessConfig businessConfig = (BusinessConfig) other;
                if (this.backgroundColor != businessConfig.backgroundColor || this.flipVertical != businessConfig.flipVertical || this.saveEachFrame2File != businessConfig.saveEachFrame2File || this.callbackEachFrameData != businessConfig.callbackEachFrameData || !Intrinsics.areEqual(this.frameType, businessConfig.frameType) || this.maxFrameCount != businessConfig.maxFrameCount || !Intrinsics.areEqual(this.optimization, businessConfig.optimization) || !Intrinsics.areEqual(this.camera, businessConfig.camera) || !Intrinsics.areEqual(this.aaType, businessConfig.aaType) || !Intrinsics.areEqual(this.aaLevel, businessConfig.aaLevel) || !Intrinsics.areEqual(this.mp4Config, businessConfig.mp4Config) || !Intrinsics.areEqual(this.skipHotPatch, businessConfig.skipHotPatch) || !Intrinsics.areEqual(this.stickerData, businessConfig.stickerData) || this.useRecordV2 != businessConfig.useRecordV2 || !Intrinsics.areEqual(this.enableUserData, businessConfig.enableUserData) || this.actionStyle != businessConfig.actionStyle || !Intrinsics.areEqual(this.disableGlassesMetallic, businessConfig.disableGlassesMetallic)) {
                    return false;
                }
                return true;
            }
            return false;
        }
        return true;
    }

    /* renamed from: f, reason: from getter */
    public final int getActionStyle() {
        return this.actionStyle;
    }

    /* renamed from: g, reason: from getter */
    public final int getBackgroundColor() {
        return this.backgroundColor;
    }

    /* JADX WARN: Multi-variable type inference failed */
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
        int i36 = this.backgroundColor * 31;
        boolean z16 = this.flipVertical;
        int i37 = 1;
        int i38 = z16;
        if (z16 != 0) {
            i38 = 1;
        }
        int i39 = (i36 + i38) * 31;
        boolean z17 = this.saveEachFrame2File;
        int i46 = z17;
        if (z17 != 0) {
            i46 = 1;
        }
        int i47 = (i39 + i46) * 31;
        boolean z18 = this.callbackEachFrameData;
        int i48 = z18;
        if (z18 != 0) {
            i48 = 1;
        }
        int i49 = (i47 + i48) * 31;
        FrameType frameType = this.frameType;
        int i56 = 0;
        if (frameType != null) {
            i3 = frameType.hashCode();
        } else {
            i3 = 0;
        }
        int i57 = (((i49 + i3) * 31) + this.maxFrameCount) * 31;
        Optimization optimization = this.optimization;
        if (optimization != null) {
            i16 = optimization.hashCode();
        } else {
            i16 = 0;
        }
        int i58 = (i57 + i16) * 31;
        Camera camera2 = this.camera;
        if (camera2 != null) {
            i17 = camera2.hashCode();
        } else {
            i17 = 0;
        }
        int i59 = (i58 + i17) * 31;
        Integer num = this.aaType;
        if (num != null) {
            i18 = num.hashCode();
        } else {
            i18 = 0;
        }
        int i65 = (i59 + i18) * 31;
        Integer num2 = this.aaLevel;
        if (num2 != null) {
            i19 = num2.hashCode();
        } else {
            i19 = 0;
        }
        int i66 = (i65 + i19) * 31;
        Mp4EncodeConfig mp4EncodeConfig = this.mp4Config;
        if (mp4EncodeConfig != null) {
            i26 = mp4EncodeConfig.hashCode();
        } else {
            i26 = 0;
        }
        int i67 = (i66 + i26) * 31;
        Boolean bool = this.skipHotPatch;
        if (bool != null) {
            i27 = bool.hashCode();
        } else {
            i27 = 0;
        }
        int i68 = (i67 + i27) * 31;
        String str = this.stickerData;
        if (str != null) {
            i28 = str.hashCode();
        } else {
            i28 = 0;
        }
        int i69 = (i68 + i28) * 31;
        boolean z19 = this.useRecordV2;
        if (!z19) {
            i37 = z19 ? 1 : 0;
        }
        int i75 = (i69 + i37) * 31;
        Boolean bool2 = this.enableUserData;
        if (bool2 != null) {
            i29 = bool2.hashCode();
        } else {
            i29 = 0;
        }
        int i76 = (((i75 + i29) * 31) + this.actionStyle) * 31;
        Boolean bool3 = this.disableGlassesMetallic;
        if (bool3 != null) {
            i56 = bool3.hashCode();
        }
        return i76 + i56;
    }

    @NotNull
    /* renamed from: j, reason: from getter */
    public final Camera getCamera() {
        return this.camera;
    }

    @Nullable
    /* renamed from: k, reason: from getter */
    public final Boolean getDisableGlassesMetallic() {
        return this.disableGlassesMetallic;
    }

    @Nullable
    /* renamed from: l, reason: from getter */
    public final Boolean getEnableUserData() {
        return this.enableUserData;
    }

    /* renamed from: m, reason: from getter */
    public final boolean getFlipVertical() {
        return this.flipVertical;
    }

    @NotNull
    /* renamed from: n, reason: from getter */
    public final FrameType getFrameType() {
        return this.frameType;
    }

    @NotNull
    /* renamed from: o, reason: from getter */
    public final Mp4EncodeConfig getMp4Config() {
        return this.mp4Config;
    }

    @NotNull
    /* renamed from: p, reason: from getter */
    public final Optimization getOptimization() {
        return this.optimization;
    }

    /* renamed from: q, reason: from getter */
    public final boolean getSaveEachFrame2File() {
        return this.saveEachFrame2File;
    }

    @Nullable
    /* renamed from: r, reason: from getter */
    public final Boolean getSkipHotPatch() {
        return this.skipHotPatch;
    }

    @NotNull
    /* renamed from: s, reason: from getter */
    public final String getStickerData() {
        return this.stickerData;
    }

    @Nullable
    /* renamed from: t, reason: from getter */
    public final EngineType getTargetEngine() {
        return this.targetEngine;
    }

    @NotNull
    public String toString() {
        return "BusinessConfig(backgroundColor=" + this.backgroundColor + ", flipVertical=" + this.flipVertical + ", saveEachFrame2File=" + this.saveEachFrame2File + ", callbackEachFrameData=" + this.callbackEachFrameData + ", frameType=" + this.frameType + ", maxFrameCount=" + this.maxFrameCount + ", optimization=" + this.optimization + ", camera=" + this.camera + ", aaType=" + this.aaType + ", aaLevel=" + this.aaLevel + ", mp4Config=" + this.mp4Config + ", skipHotPatch=" + this.skipHotPatch + ", stickerData=" + this.stickerData + ", useRecordV2=" + this.useRecordV2 + ", enableUserData=" + this.enableUserData + ", actionStyle=" + this.actionStyle + ", disableGlassesMetallic=" + this.disableGlassesMetallic + ")";
    }

    /* renamed from: u, reason: from getter */
    public final boolean getUseRecordV2() {
        return this.useRecordV2;
    }

    public final void v(@Nullable Integer num) {
        this.aaLevel = num;
    }

    public final void w(@Nullable Integer num) {
        this.aaType = num;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeInt(this.backgroundColor);
        parcel.writeInt(this.flipVertical ? 1 : 0);
        parcel.writeInt(this.saveEachFrame2File ? 1 : 0);
        parcel.writeInt(this.callbackEachFrameData ? 1 : 0);
        parcel.writeString(this.frameType.name());
        parcel.writeInt(this.maxFrameCount);
        this.optimization.writeToParcel(parcel, 0);
        this.camera.writeToParcel(parcel, 0);
        Integer num = this.aaType;
        if (num != null) {
            parcel.writeInt(1);
            parcel.writeInt(num.intValue());
        } else {
            parcel.writeInt(0);
        }
        Integer num2 = this.aaLevel;
        if (num2 != null) {
            parcel.writeInt(1);
            parcel.writeInt(num2.intValue());
        } else {
            parcel.writeInt(0);
        }
        this.mp4Config.writeToParcel(parcel, 0);
        Boolean bool = this.skipHotPatch;
        if (bool != null) {
            parcel.writeInt(1);
            parcel.writeInt(bool.booleanValue() ? 1 : 0);
        } else {
            parcel.writeInt(0);
        }
        parcel.writeString(this.stickerData);
        parcel.writeInt(this.useRecordV2 ? 1 : 0);
        Boolean bool2 = this.enableUserData;
        if (bool2 != null) {
            parcel.writeInt(1);
            parcel.writeInt(bool2.booleanValue() ? 1 : 0);
        } else {
            parcel.writeInt(0);
        }
        parcel.writeInt(this.actionStyle);
        Boolean bool3 = this.disableGlassesMetallic;
        if (bool3 != null) {
            parcel.writeInt(1);
            parcel.writeInt(bool3.booleanValue() ? 1 : 0);
        } else {
            parcel.writeInt(0);
        }
    }

    public final void x(int i3) {
        this.actionStyle = i3;
    }

    public final void y(int i3) {
        this.backgroundColor = i3;
    }

    public final void z(@Nullable Boolean bool) {
        this.disableGlassesMetallic = bool;
    }

    public BusinessConfig(int i3, boolean z16, boolean z17, boolean z18, @NotNull FrameType frameType, int i16, @NotNull Optimization optimization, @NotNull Camera camera2, @Nullable Integer num, @Nullable Integer num2, @NotNull Mp4EncodeConfig mp4Config, @Nullable Boolean bool, @NotNull String stickerData, boolean z19, @Nullable Boolean bool2, int i17, @Nullable Boolean bool3) {
        Intrinsics.checkNotNullParameter(frameType, "frameType");
        Intrinsics.checkNotNullParameter(optimization, "optimization");
        Intrinsics.checkNotNullParameter(camera2, "camera");
        Intrinsics.checkNotNullParameter(mp4Config, "mp4Config");
        Intrinsics.checkNotNullParameter(stickerData, "stickerData");
        this.backgroundColor = i3;
        this.flipVertical = z16;
        this.saveEachFrame2File = z17;
        this.callbackEachFrameData = z18;
        this.frameType = frameType;
        this.maxFrameCount = i16;
        this.optimization = optimization;
        this.camera = camera2;
        this.aaType = num;
        this.aaLevel = num2;
        this.mp4Config = mp4Config;
        this.skipHotPatch = bool;
        this.stickerData = stickerData;
        this.useRecordV2 = z19;
        this.enableUserData = bool2;
        this.actionStyle = i17;
        this.disableGlassesMetallic = bool3;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ BusinessConfig(int i3, boolean z16, boolean z17, boolean z18, FrameType frameType, int i16, Optimization optimization, Camera camera2, Integer num, Integer num2, Mp4EncodeConfig mp4EncodeConfig, Boolean bool, String str, boolean z19, Boolean bool2, int i17, Boolean bool3, int i18, DefaultConstructorMarker defaultConstructorMarker) {
        this((i18 & 1) != 0 ? 0 : i3, (i18 & 2) != 0 ? false : z16, (i18 & 4) != 0 ? false : z17, (i18 & 8) != 0 ? false : z18, (i18 & 16) != 0 ? FrameType.PNG : frameType, (i18 & 32) != 0 ? -1 : i16, (i18 & 64) != 0 ? new Optimization(r2, r2, 3, null) : optimization, (i18 & 128) != 0 ? new Camera(null, null, null, null, 15, null) : camera2, (i18 & 256) != 0 ? null : num, (i18 & 512) != 0 ? null : num2, (i18 & 1024) != 0 ? new Mp4EncodeConfig(0, 0, 0, false, 0, null, 0, 127, null) : mp4EncodeConfig, (i18 & 2048) != 0 ? null : bool, (i18 & 4096) != 0 ? "" : str, (i18 & 8192) != 0 ? true : z19, (i18 & 16384) != 0 ? null : bool2, (i18 & 32768) != 0 ? -1 : i17, (i18 & 65536) != 0 ? Boolean.FALSE : bool3);
        boolean z26 = false;
    }
}
