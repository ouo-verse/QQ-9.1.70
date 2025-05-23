package com.tencent.mobileqq.qqlive.sail.model;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.exifinterface.media.ExifInterface;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.luggage.wxa.ig.w;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqlive.sail.model.anchor.AvConfig;
import com.tencent.mobileqq.qqlive.sail.model.anchor.SettingInfo;
import com.tencent.mobileqq.qqlive.sail.model.common.BasicInfo;
import com.tencent.mobileqq.qqlive.sail.model.common.LocationInfo;
import com.tencent.mobileqq.qqlive.sail.model.common.RoomCoverInfo;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import cooperation.qzone.QZoneRequestEncoder;
import gr4.aa;
import gr4.k;
import gr4.m;
import gr4.o;
import gr4.s;
import gr4.z;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b@\b\u0086\b\u0018\u0000 q2\u00020\u00012\u00020\u0002:\u0001rB}\u0012\b\b\u0002\u0010 \u001a\u00020\u001f\u0012\b\b\u0002\u0010\"\u001a\u00020!\u0012\b\b\u0002\u0010$\u001a\u00020#\u0012\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010'\u001a\u0004\u0018\u00010&\u0012\n\b\u0002\u0010)\u001a\u0004\u0018\u00010(\u0012\b\b\u0002\u0010*\u001a\u00020\n\u0012\b\b\u0002\u0010+\u001a\u00020\u0007\u0012\b\b\u0002\u0010,\u001a\u00020\n\u0012\b\b\u0002\u0010-\u001a\u00020\u0007\u0012\n\b\u0002\u0010/\u001a\u0004\u0018\u00010.\u00a2\u0006\u0004\bo\u0010pJ\b\u0010\u0004\u001a\u00020\u0003H\u0002J\u0006\u0010\u0005\u001a\u00020\u0003J\b\u0010\u0006\u001a\u00020\u0003H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0016J\b\u0010\t\u001a\u00020\u0007H\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016J\b\u0010\r\u001a\u00020\fH\u0016J\b\u0010\u000e\u001a\u00020\u0007H\u0016J\n\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016J\b\u0010\u0011\u001a\u00020\u0003H\u0016J\b\u0010\u0012\u001a\u00020\nH\u0016J\b\u0010\u0013\u001a\u00020\u0007H\u0016J\b\u0010\u0014\u001a\u00020\u0007H\u0016J\n\u0010\u0015\u001a\u0004\u0018\u00010\u0007H\u0016J\u000e\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0017\u001a\u00020\u0016J\u0018\u0010\u001d\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\fH\u0016J\b\u0010\u001e\u001a\u00020\fH\u0016J\u007f\u00100\u001a\u00020\u00002\b\b\u0002\u0010 \u001a\u00020\u001f2\b\b\u0002\u0010\"\u001a\u00020!2\b\b\u0002\u0010$\u001a\u00020#2\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010'\u001a\u0004\u0018\u00010&2\n\b\u0002\u0010)\u001a\u0004\u0018\u00010(2\b\b\u0002\u0010*\u001a\u00020\n2\b\b\u0002\u0010+\u001a\u00020\u00072\b\b\u0002\u0010,\u001a\u00020\n2\b\b\u0002\u0010-\u001a\u00020\u00072\n\b\u0002\u0010/\u001a\u0004\u0018\u00010.H\u00c6\u0001J\t\u00101\u001a\u00020\u0007H\u00d6\u0001J\t\u00102\u001a\u00020\fH\u00d6\u0001J\u0013\u00105\u001a\u00020\u00032\b\u00104\u001a\u0004\u0018\u000103H\u00d6\u0003R\"\u0010 \u001a\u00020\u001f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b6\u00107\u001a\u0004\b8\u00109\"\u0004\b:\u0010;R\"\u0010\"\u001a\u00020!8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0012\u0010<\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@R\"\u0010$\u001a\u00020#8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0015\u0010A\u001a\u0004\bB\u0010C\"\u0004\bD\u0010ER$\u0010%\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bF\u0010G\u001a\u0004\bH\u0010I\"\u0004\bJ\u0010KR$\u0010'\u001a\u0004\u0018\u00010&8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bL\u0010M\u001a\u0004\bN\u0010O\"\u0004\bP\u0010QR$\u0010)\u001a\u0004\u0018\u00010(8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bR\u0010S\u001a\u0004\bT\u0010U\"\u0004\bV\u0010WR\"\u0010*\u001a\u00020\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bX\u0010Y\u001a\u0004\bZ\u0010[\"\u0004\b\\\u0010]R\"\u0010+\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b^\u0010_\u001a\u0004\bR\u0010`\"\u0004\ba\u0010bR\"\u0010,\u001a\u00020\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bc\u0010Y\u001a\u0004\bd\u0010[\"\u0004\be\u0010]R\"\u0010-\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bf\u0010_\u001a\u0004\bg\u0010`\"\u0004\bh\u0010bR$\u0010/\u001a\u0004\u0018\u00010.8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bi\u0010j\u001a\u0004\bk\u0010l\"\u0004\bm\u0010n\u00a8\u0006s"}, d2 = {"Lcom/tencent/mobileqq/qqlive/sail/model/AnchorRoomInfo;", "Landroid/os/Parcelable;", "Lcom/tencent/mobileqq/qqlive/sail/model/d;", "", "u", "v", "c", "", "l", "getProgramId", "", "getRoomId", "", "getRoomType", "getRoomName", "Lcom/tencent/mobileqq/qqlive/sail/model/common/UserInfo;", "j", "g", "e", QZoneRequestEncoder.KEY_COVER_REQ, ReportConstant.COSTREPORT_PREFIX, "f", "Lgr4/e;", "rsp", "", "w", "Landroid/os/Parcel;", "parcel", WadlProxyConsts.FLAGS, "writeToParcel", "describeContents", "Lcom/tencent/mobileqq/qqlive/sail/model/anchor/AvConfig;", "avConfig", "Lcom/tencent/mobileqq/qqlive/sail/model/common/BasicInfo;", "basicInfo", "Lcom/tencent/mobileqq/qqlive/sail/model/anchor/SettingInfo;", "settingInfo", "anchorInfo", "Lgr4/z;", "trtcInfo", "Lpt3/e;", "thirdPushInfo", "heartBeatTime", "appId", "enterRoomTime", "popupDialogUrl", "Ltq4/a;", "backgroundInfo", "a", "toString", "hashCode", "", "other", "equals", "d", "Lcom/tencent/mobileqq/qqlive/sail/model/anchor/AvConfig;", DomainData.DOMAIN_NAME, "()Lcom/tencent/mobileqq/qqlive/sail/model/anchor/AvConfig;", "y", "(Lcom/tencent/mobileqq/qqlive/sail/model/anchor/AvConfig;)V", "Lcom/tencent/mobileqq/qqlive/sail/model/common/BasicInfo;", "p", "()Lcom/tencent/mobileqq/qqlive/sail/model/common/BasicInfo;", "setBasicInfo", "(Lcom/tencent/mobileqq/qqlive/sail/model/common/BasicInfo;)V", "Lcom/tencent/mobileqq/qqlive/sail/model/anchor/SettingInfo;", "r", "()Lcom/tencent/mobileqq/qqlive/sail/model/anchor/SettingInfo;", "B", "(Lcom/tencent/mobileqq/qqlive/sail/model/anchor/SettingInfo;)V", h.F, "Lcom/tencent/mobileqq/qqlive/sail/model/common/UserInfo;", "k", "()Lcom/tencent/mobileqq/qqlive/sail/model/common/UserInfo;", "setAnchorInfo", "(Lcom/tencent/mobileqq/qqlive/sail/model/common/UserInfo;)V", "i", "Lgr4/z;", "t", "()Lgr4/z;", "setTrtcInfo", "(Lgr4/z;)V", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lpt3/e;", "getThirdPushInfo", "()Lpt3/e;", "setThirdPushInfo", "(Lpt3/e;)V", BdhLogUtil.LogTag.Tag_Conn, "J", "getHeartBeatTime", "()J", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "(J)V", "D", "Ljava/lang/String;", "()Ljava/lang/String;", HippyTKDListViewAdapter.X, "(Ljava/lang/String;)V", "E", "getEnterRoomTime", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, UserInfo.SEX_FEMALE, QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "setPopupDialogUrl", "G", "Ltq4/a;", "o", "()Ltq4/a;", "setBackgroundInfo", "(Ltq4/a;)V", "<init>", "(Lcom/tencent/mobileqq/qqlive/sail/model/anchor/AvConfig;Lcom/tencent/mobileqq/qqlive/sail/model/common/BasicInfo;Lcom/tencent/mobileqq/qqlive/sail/model/anchor/SettingInfo;Lcom/tencent/mobileqq/qqlive/sail/model/common/UserInfo;Lgr4/z;Lpt3/e;JLjava/lang/String;JLjava/lang/String;Ltq4/a;)V", "H", "b", "qq-live-sdk-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final /* data */ class AnchorRoomInfo implements Parcelable, d {
    static IPatchRedirector $redirector_;

    @JvmField
    @NotNull
    public static final Parcelable.Creator<AnchorRoomInfo> CREATOR;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    private long heartBeatTime;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private String appId;

    /* renamed from: E, reason: from kotlin metadata */
    private long enterRoomTime;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private String popupDialogUrl;

    /* renamed from: G, reason: from kotlin metadata */
    @Nullable
    private tq4.a backgroundInfo;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private AvConfig avConfig;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private BasicInfo basicInfo;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private SettingInfo settingInfo;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private com.tencent.mobileqq.qqlive.sail.model.common.UserInfo anchorInfo;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private z trtcInfo;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private pt3.e thirdPushInfo;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u001f\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0016\u00a2\u0006\u0004\b\n\u0010\u000b\u00a8\u0006\f"}, d2 = {"com/tencent/mobileqq/qqlive/sail/model/AnchorRoomInfo$a", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mobileqq/qqlive/sail/model/AnchorRoomInfo;", "Landroid/os/Parcel;", "parcel", "c", "a", "", "size", "", "b", "(I)[Lcom/tencent/mobileqq/qqlive/sail/model/AnchorRoomInfo;", "qq-live-sdk-api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes17.dex */
    public static final class a implements Parcelable.Creator<AnchorRoomInfo> {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        private final AnchorRoomInfo c(Parcel parcel) {
            z zVar;
            pt3.e eVar;
            tq4.a aVar;
            AvConfig avConfig = (AvConfig) parcel.readTypedObject(AvConfig.INSTANCE);
            BasicInfo basicInfo = (BasicInfo) parcel.readTypedObject(BasicInfo.INSTANCE);
            SettingInfo settingInfo = (SettingInfo) parcel.readTypedObject(SettingInfo.INSTANCE);
            com.tencent.mobileqq.qqlive.sail.model.common.UserInfo userInfo = (com.tencent.mobileqq.qqlive.sail.model.common.UserInfo) parcel.readTypedObject(com.tencent.mobileqq.qqlive.sail.model.common.UserInfo.INSTANCE);
            int readInt = parcel.readInt();
            if (readInt > 0) {
                byte[] bArr = new byte[readInt];
                parcel.readByteArray(bArr);
                zVar = z.c(bArr);
            } else {
                zVar = null;
            }
            int readInt2 = parcel.readInt();
            if (readInt2 > 0) {
                byte[] bArr2 = new byte[readInt2];
                parcel.readByteArray(bArr2);
                eVar = pt3.e.c(bArr2);
            } else {
                eVar = null;
            }
            long readLong = parcel.readLong();
            String readString = parcel.readString();
            if (readString == null) {
                readString = "";
            }
            long readLong2 = parcel.readLong();
            String readString2 = parcel.readString();
            if (readString2 == null) {
                readString2 = "";
            }
            int readInt3 = parcel.readInt();
            if (readInt3 > 0) {
                byte[] bArr3 = new byte[readInt3];
                parcel.readByteArray(bArr3);
                aVar = tq4.a.c(bArr3);
            } else {
                aVar = null;
            }
            Intrinsics.checkNotNull(avConfig);
            Intrinsics.checkNotNull(basicInfo);
            Intrinsics.checkNotNull(settingInfo);
            return new AnchorRoomInfo(avConfig, basicInfo, settingInfo, userInfo, zVar, eVar, readLong, readString, readLong2, readString2, aVar);
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public AnchorRoomInfo createFromParcel(@NotNull Parcel parcel) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (AnchorRoomInfo) iPatchRedirector.redirect((short) 2, (Object) this, (Object) parcel);
            }
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return c(parcel);
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public AnchorRoomInfo[] newArray(int size) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (AnchorRoomInfo[]) iPatchRedirector.redirect((short) 3, (Object) this, size);
            }
            return new AnchorRoomInfo[size];
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u001a\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\u00068\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0014\u0010\n\u001a\u00020\t8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000b\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/qqlive/sail/model/AnchorRoomInfo$b;", "", "Lgr4/o;", "rsp", "Lcom/tencent/mobileqq/qqlive/sail/model/AnchorRoomInfo;", "a", "Landroid/os/Parcelable$Creator;", "CREATOR", "Landroid/os/Parcelable$Creator;", "", "DEFAULT_HEART_BEAT_TIMEOUT_MS", "I", "<init>", "()V", "qq-live-sdk-api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qqlive.sail.model.AnchorRoomInfo$b, reason: from kotlin metadata */
    /* loaded from: classes17.dex */
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
        public final AnchorRoomInfo a(@NotNull o rsp) {
            long j3;
            String str;
            String str2;
            String str3;
            String str4;
            ArrayList arrayList;
            long j16;
            int i3;
            long j17;
            String str5;
            String str6;
            String str7;
            String str8;
            int i16;
            String str9;
            String str10;
            long j18;
            String str11;
            String str12;
            String str13;
            String str14;
            String str15;
            String str16;
            String str17;
            String str18;
            String str19;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (AnchorRoomInfo) iPatchRedirector.redirect((short) 2, (Object) this, (Object) rsp);
            }
            Intrinsics.checkNotNullParameter(rsp, "rsp");
            AvConfig avConfig = new AvConfig(false, false, false, 0, false, 0, 63, null);
            s sVar = rsp.f403159c;
            if (sVar != null) {
                j3 = sVar.f403194a;
            } else {
                j3 = 0;
            }
            String str20 = null;
            if (sVar != null) {
                str = sVar.f403197d;
            } else {
                str = null;
            }
            if (str == null) {
                str2 = "";
            } else {
                str2 = str;
            }
            if (sVar != null) {
                str3 = sVar.f403206m;
            } else {
                str3 = null;
            }
            if (str3 == null) {
                str4 = "";
            } else {
                str4 = str3;
            }
            boolean z16 = false;
            if (rsp.f403162f == null) {
                arrayList = null;
            } else {
                ArrayList arrayList2 = new ArrayList();
                k[] kVarArr = rsp.f403162f;
                Intrinsics.checkNotNullExpressionValue(kVarArr, "rsp.labelInfo");
                for (k it : kVarArr) {
                    Intrinsics.checkNotNullExpressionValue(it, "it");
                    arrayList2.add(it);
                }
                arrayList = arrayList2;
            }
            BasicInfo basicInfo = new BasicInfo(j3, str2, str4, arrayList);
            aa aaVar = rsp.f403165i;
            if (aaVar != null) {
                j16 = aaVar.f403092a;
            } else {
                j16 = 0;
            }
            if (aaVar != null) {
                i3 = aaVar.f403099h;
            } else {
                i3 = 0;
            }
            if (aaVar != null) {
                j17 = aaVar.f403093b;
            } else {
                j17 = 0;
            }
            if (aaVar != null) {
                str5 = aaVar.f403094c;
            } else {
                str5 = null;
            }
            if (str5 == null) {
                str6 = "";
            } else {
                str6 = str5;
            }
            if (aaVar != null) {
                str7 = aaVar.f403095d;
            } else {
                str7 = null;
            }
            if (str7 == null) {
                str8 = "";
            } else {
                str8 = str7;
            }
            if (aaVar != null) {
                i16 = aaVar.f403096e;
            } else {
                i16 = 0;
            }
            if (aaVar != null) {
                str9 = aaVar.f403097f;
            } else {
                str9 = null;
            }
            if (str9 == null) {
                str10 = "";
            } else {
                str10 = str9;
            }
            if (aaVar != null) {
                j18 = aaVar.f403098g;
            } else {
                j18 = 0;
            }
            com.tencent.mobileqq.qqlive.sail.model.common.UserInfo userInfo = new com.tencent.mobileqq.qqlive.sail.model.common.UserInfo(j16, i3, j17, str6, str8, i16, str10, j18);
            int i17 = 0;
            s sVar2 = rsp.f403159c;
            if (sVar2 != null) {
                str11 = sVar2.f403195b;
            } else {
                str11 = null;
            }
            if (str11 == null) {
                str12 = "";
            } else {
                str12 = str11;
            }
            LocationInfo locationInfo = null;
            int i18 = rsp.f403161e;
            if (sVar2 != null) {
                str13 = sVar2.f403202i;
            } else {
                str13 = null;
            }
            if (str13 == null) {
                str14 = "";
            } else {
                str14 = str13;
            }
            if (sVar2 != null) {
                str15 = sVar2.f403203j;
            } else {
                str15 = null;
            }
            if (str15 == null) {
                str16 = "";
            } else {
                str16 = str15;
            }
            if (sVar2 != null) {
                str17 = sVar2.f403196c;
            } else {
                str17 = null;
            }
            if (str17 == null) {
                str18 = "";
            } else {
                str18 = str17;
            }
            RoomCoverInfo roomCoverInfo = new RoomCoverInfo(i18, str14, 0L, str18, 0L, str16, 0L, 84, null);
            s sVar3 = rsp.f403159c;
            if (sVar3 != null && sVar3.f403198e == 0) {
                z16 = true;
            }
            SettingInfo settingInfo = new SettingInfo(i17, str12, locationInfo, roomCoverInfo, z16, 0, null, false, null, false, 0, 325, null);
            m mVar = rsp.f403163g;
            if (mVar != null) {
                str20 = mVar.f403149a;
            }
            if (str20 == null) {
                str19 = "";
            } else {
                str19 = str20;
            }
            return new AnchorRoomInfo(avConfig, basicInfo, settingInfo, userInfo, null, null, 0L, null, 0L, str19, rsp.f403168l, w.CTRL_INDEX, null);
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(30739);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 57)) {
            redirector.redirect((short) 57);
        } else {
            INSTANCE = new Companion(null);
            CREATOR = new a();
        }
    }

    public AnchorRoomInfo() {
        this(null, null, null, null, null, null, 0L, null, 0L, null, null, 2047, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 56)) {
            return;
        }
        iPatchRedirector.redirect((short) 56, (Object) this);
    }

    private final boolean u() {
        if (System.currentTimeMillis() - this.heartBeatTime >= ht3.a.b("qqlive_anchor_room_heart_beat_timeout_ms", 120000)) {
            return true;
        }
        return false;
    }

    public final void A(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, j3);
        } else {
            this.heartBeatTime = j3;
        }
    }

    public final void B(@NotNull SettingInfo settingInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) settingInfo);
        } else {
            Intrinsics.checkNotNullParameter(settingInfo, "<set-?>");
            this.settingInfo = settingInfo;
        }
    }

    @NotNull
    public final AnchorRoomInfo a(@NotNull AvConfig avConfig, @NotNull BasicInfo basicInfo, @NotNull SettingInfo settingInfo, @Nullable com.tencent.mobileqq.qqlive.sail.model.common.UserInfo anchorInfo, @Nullable z trtcInfo, @Nullable pt3.e thirdPushInfo, long heartBeatTime, @NotNull String appId, long enterRoomTime, @NotNull String popupDialogUrl, @Nullable tq4.a backgroundInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 52)) {
            return (AnchorRoomInfo) iPatchRedirector.redirect((short) 52, this, avConfig, basicInfo, settingInfo, anchorInfo, trtcInfo, thirdPushInfo, Long.valueOf(heartBeatTime), appId, Long.valueOf(enterRoomTime), popupDialogUrl, backgroundInfo);
        }
        Intrinsics.checkNotNullParameter(avConfig, "avConfig");
        Intrinsics.checkNotNullParameter(basicInfo, "basicInfo");
        Intrinsics.checkNotNullParameter(settingInfo, "settingInfo");
        Intrinsics.checkNotNullParameter(appId, "appId");
        Intrinsics.checkNotNullParameter(popupDialogUrl, "popupDialogUrl");
        return new AnchorRoomInfo(avConfig, basicInfo, settingInfo, anchorInfo, trtcInfo, thirdPushInfo, heartBeatTime, appId, enterRoomTime, popupDialogUrl, backgroundInfo);
    }

    @Override // com.tencent.mobileqq.qqlive.sail.model.d
    public boolean c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            return ((Boolean) iPatchRedirector.redirect((short) 26, (Object) this)).booleanValue();
        }
        return true;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 40)) {
            return ((Integer) iPatchRedirector.redirect((short) 40, (Object) this)).intValue();
        }
        return 0;
    }

    @Override // com.tencent.mobileqq.qqlive.sail.model.d
    public long e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
            return ((Long) iPatchRedirector.redirect((short) 34, (Object) this)).longValue();
        }
        return this.enterRoomTime;
    }

    public boolean equals(@Nullable Object other) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 55)) {
            return ((Boolean) iPatchRedirector.redirect((short) 55, (Object) this, other)).booleanValue();
        }
        if (this == other) {
            return true;
        }
        if (!(other instanceof AnchorRoomInfo)) {
            return false;
        }
        AnchorRoomInfo anchorRoomInfo = (AnchorRoomInfo) other;
        if (Intrinsics.areEqual(this.avConfig, anchorRoomInfo.avConfig) && Intrinsics.areEqual(this.basicInfo, anchorRoomInfo.basicInfo) && Intrinsics.areEqual(this.settingInfo, anchorRoomInfo.settingInfo) && Intrinsics.areEqual(this.anchorInfo, anchorRoomInfo.anchorInfo) && Intrinsics.areEqual(this.trtcInfo, anchorRoomInfo.trtcInfo) && Intrinsics.areEqual(this.thirdPushInfo, anchorRoomInfo.thirdPushInfo) && this.heartBeatTime == anchorRoomInfo.heartBeatTime && Intrinsics.areEqual(this.appId, anchorRoomInfo.appId) && this.enterRoomTime == anchorRoomInfo.enterRoomTime && Intrinsics.areEqual(this.popupDialogUrl, anchorRoomInfo.popupDialogUrl) && Intrinsics.areEqual(this.backgroundInfo, anchorRoomInfo.backgroundInfo)) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.qqlive.sail.model.d
    @Nullable
    public String f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 37)) {
            return (String) iPatchRedirector.redirect((short) 37, (Object) this);
        }
        return null;
    }

    @Override // com.tencent.mobileqq.qqlive.sail.model.d
    public boolean g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            return ((Boolean) iPatchRedirector.redirect((short) 33, (Object) this)).booleanValue();
        }
        return this.settingInfo.o();
    }

    @Override // com.tencent.mobileqq.qqlive.sail.model.d
    @NotNull
    public String getCover() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 35)) {
            return (String) iPatchRedirector.redirect((short) 35, (Object) this);
        }
        return this.settingInfo.c().e();
    }

    @Override // com.tencent.mobileqq.qqlive.sail.model.d
    @NotNull
    public String getProgramId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            return (String) iPatchRedirector.redirect((short) 28, (Object) this);
        }
        return this.basicInfo.f();
    }

    @Override // com.tencent.mobileqq.qqlive.sail.model.d
    public long getRoomId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            return ((Long) iPatchRedirector.redirect((short) 29, (Object) this)).longValue();
        }
        return this.basicInfo.g();
    }

    @Override // com.tencent.mobileqq.qqlive.sail.model.d
    @NotNull
    public String getRoomName() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            return (String) iPatchRedirector.redirect((short) 31, (Object) this);
        }
        return this.settingInfo.j();
    }

    @Override // com.tencent.mobileqq.qqlive.sail.model.d
    public int getRoomType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            return ((Integer) iPatchRedirector.redirect((short) 30, (Object) this)).intValue();
        }
        return this.settingInfo.k();
    }

    public int hashCode() {
        int hashCode;
        int hashCode2;
        int hashCode3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 54)) {
            return ((Integer) iPatchRedirector.redirect((short) 54, (Object) this)).intValue();
        }
        int hashCode4 = ((((this.avConfig.hashCode() * 31) + this.basicInfo.hashCode()) * 31) + this.settingInfo.hashCode()) * 31;
        com.tencent.mobileqq.qqlive.sail.model.common.UserInfo userInfo = this.anchorInfo;
        int i3 = 0;
        if (userInfo == null) {
            hashCode = 0;
        } else {
            hashCode = userInfo.hashCode();
        }
        int i16 = (hashCode4 + hashCode) * 31;
        z zVar = this.trtcInfo;
        if (zVar == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = zVar.hashCode();
        }
        int i17 = (i16 + hashCode2) * 31;
        pt3.e eVar = this.thirdPushInfo;
        if (eVar == null) {
            hashCode3 = 0;
        } else {
            hashCode3 = eVar.hashCode();
        }
        int a16 = (((((((((i17 + hashCode3) * 31) + androidx.fragment.app.a.a(this.heartBeatTime)) * 31) + this.appId.hashCode()) * 31) + androidx.fragment.app.a.a(this.enterRoomTime)) * 31) + this.popupDialogUrl.hashCode()) * 31;
        tq4.a aVar = this.backgroundInfo;
        if (aVar != null) {
            i3 = aVar.hashCode();
        }
        return a16 + i3;
    }

    @Override // com.tencent.mobileqq.qqlive.sail.model.d
    @Nullable
    public com.tencent.mobileqq.qqlive.sail.model.common.UserInfo j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            return (com.tencent.mobileqq.qqlive.sail.model.common.UserInfo) iPatchRedirector.redirect((short) 32, (Object) this);
        }
        return this.anchorInfo;
    }

    @Nullable
    public final com.tencent.mobileqq.qqlive.sail.model.common.UserInfo k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (com.tencent.mobileqq.qqlive.sail.model.common.UserInfo) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return this.anchorInfo;
    }

    @NotNull
    public String l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            return (String) iPatchRedirector.redirect((short) 27, (Object) this);
        }
        return this.appId;
    }

    @NotNull
    public final String m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return (String) iPatchRedirector.redirect((short) 17, (Object) this);
        }
        return this.appId;
    }

    @NotNull
    public final AvConfig n() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (AvConfig) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.avConfig;
    }

    @Nullable
    public final tq4.a o() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return (tq4.a) iPatchRedirector.redirect((short) 23, (Object) this);
        }
        return this.backgroundInfo;
    }

    @NotNull
    public final BasicInfo p() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (BasicInfo) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.basicInfo;
    }

    @NotNull
    public final String q() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return (String) iPatchRedirector.redirect((short) 21, (Object) this);
        }
        return this.popupDialogUrl;
    }

    @NotNull
    public final SettingInfo r() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (SettingInfo) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return this.settingInfo;
    }

    @NotNull
    public String s() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 36)) {
            return (String) iPatchRedirector.redirect((short) 36, (Object) this);
        }
        return this.basicInfo.c();
    }

    @Nullable
    public final z t() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (z) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        return this.trtcInfo;
    }

    @NotNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 53)) {
            return (String) iPatchRedirector.redirect((short) 53, (Object) this);
        }
        return "AnchorRoomInfo(avConfig=" + this.avConfig + ", basicInfo=" + this.basicInfo + ", settingInfo=" + this.settingInfo + ", anchorInfo=" + this.anchorInfo + ", trtcInfo=" + this.trtcInfo + ", thirdPushInfo=" + this.thirdPushInfo + ", heartBeatTime=" + this.heartBeatTime + ", appId=" + this.appId + ", enterRoomTime=" + this.enterRoomTime + ", popupDialogUrl=" + this.popupDialogUrl + ", backgroundInfo=" + this.backgroundInfo + ")";
    }

    public final boolean v() {
        boolean z16;
        boolean isBlank;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            return ((Boolean) iPatchRedirector.redirect((short) 25, (Object) this)).booleanValue();
        }
        if (!this.basicInfo.j()) {
            return false;
        }
        com.tencent.mobileqq.qqlive.sail.model.common.UserInfo userInfo = this.anchorInfo;
        if (userInfo != null && userInfo.g()) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            return false;
        }
        if ((this.trtcInfo != null || this.thirdPushInfo != null) && this.enterRoomTime > 0 && !u()) {
            isBlank = StringsKt__StringsJVMKt.isBlank(this.appId);
            if (!(!isBlank)) {
                return false;
            }
            return true;
        }
        return false;
    }

    public final void w(@NotNull gr4.e rsp) {
        boolean isBlank;
        boolean isBlank2;
        boolean isBlank3;
        boolean isBlank4;
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 38)) {
            iPatchRedirector.redirect((short) 38, (Object) this, (Object) rsp);
            return;
        }
        Intrinsics.checkNotNullParameter(rsp, "rsp");
        String f16 = this.basicInfo.f();
        isBlank = StringsKt__StringsJVMKt.isBlank(f16);
        if (isBlank) {
            f16 = rsp.f403113c.f403197d;
        }
        String programId = f16;
        BasicInfo basicInfo = this.basicInfo;
        long j3 = rsp.f403113c.f403194a;
        Intrinsics.checkNotNullExpressionValue(programId, "programId");
        String str = rsp.f403113c.f403206m;
        Intrinsics.checkNotNullExpressionValue(str, "rsp.room.systemNotice");
        this.basicInfo = BasicInfo.b(basicInfo, j3, programId, str, null, 8, null);
        SettingInfo settingInfo = this.settingInfo;
        String str2 = rsp.f403113c.f403195b;
        Intrinsics.checkNotNullExpressionValue(str2, "rsp.room.name");
        RoomCoverInfo c16 = this.settingInfo.c();
        String str3 = rsp.f403113c.f403196c;
        isBlank2 = StringsKt__StringsJVMKt.isBlank(str3);
        if (isBlank2) {
            str3 = this.settingInfo.c().c();
        }
        String str4 = str3;
        String str5 = rsp.f403113c.f403202i;
        isBlank3 = StringsKt__StringsJVMKt.isBlank(str5);
        if (isBlank3) {
            str5 = this.settingInfo.c().e();
        }
        String str6 = str5;
        String str7 = rsp.f403113c.f403203j;
        isBlank4 = StringsKt__StringsJVMKt.isBlank(str7);
        if (isBlank4) {
            str7 = this.settingInfo.c().f();
        }
        String str8 = str7;
        Intrinsics.checkNotNullExpressionValue(str6, "ifBlank { settingInfo.coverInfo.poster16v9 }");
        Intrinsics.checkNotNullExpressionValue(str4, "ifBlank { settingInfo.coverInfo.poster }");
        Intrinsics.checkNotNullExpressionValue(str8, "ifBlank { settingInfo.coverInfo.poster3v4 }");
        RoomCoverInfo b16 = RoomCoverInfo.b(c16, 0, str6, 0L, str4, 0L, str8, 0L, 85, null);
        if (rsp.f403113c.f403198e == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        this.settingInfo = SettingInfo.b(settingInfo, 0, str2, null, b16, z16, 0, null, false, null, false, 0, 2021, null);
        aa aaVar = rsp.f403114d;
        long j16 = aaVar.f403092a;
        long j17 = aaVar.f403093b;
        String str9 = aaVar.f403094c;
        Intrinsics.checkNotNullExpressionValue(str9, "rsp.user.name");
        String str10 = rsp.f403114d.f403095d;
        Intrinsics.checkNotNullExpressionValue(str10, "rsp.user.head");
        aa aaVar2 = rsp.f403114d;
        int i3 = aaVar2.f403096e;
        String str11 = aaVar2.f403097f;
        Intrinsics.checkNotNullExpressionValue(str11, "rsp.user.businessUid");
        this.anchorInfo = new com.tencent.mobileqq.qqlive.sail.model.common.UserInfo(j16, 0, j17, str9, str10, i3, str11, rsp.f403114d.f403098g, 2, null);
        this.trtcInfo = rsp.f403116f;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        int i3;
        int i16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 39)) {
            iPatchRedirector.redirect((short) 39, (Object) this, (Object) parcel, flags);
            return;
        }
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeTypedObject(this.avConfig, flags);
        parcel.writeTypedObject(this.basicInfo, flags);
        parcel.writeTypedObject(this.settingInfo, flags);
        parcel.writeTypedObject(this.anchorInfo, flags);
        z zVar = this.trtcInfo;
        int i17 = 0;
        if (zVar != null) {
            i3 = zVar.getSerializedSize();
        } else {
            i3 = 0;
        }
        parcel.writeInt(i3);
        if (i3 > 0) {
            byte[] bArr = new byte[i3];
            z zVar2 = this.trtcInfo;
            if (zVar2 != null) {
                zVar2.writeTo(CodedOutputByteBufferNano.newInstance(bArr));
            }
            parcel.writeByteArray(bArr);
        }
        pt3.e eVar = this.thirdPushInfo;
        if (eVar != null) {
            i16 = eVar.getSerializedSize();
        } else {
            i16 = 0;
        }
        parcel.writeInt(i16);
        if (i16 > 0) {
            byte[] bArr2 = new byte[i16];
            pt3.e eVar2 = this.thirdPushInfo;
            if (eVar2 != null) {
                eVar2.writeTo(CodedOutputByteBufferNano.newInstance(bArr2));
            }
            parcel.writeByteArray(bArr2);
        }
        parcel.writeLong(this.heartBeatTime);
        parcel.writeString(this.appId);
        parcel.writeLong(this.enterRoomTime);
        parcel.writeString(this.popupDialogUrl);
        tq4.a aVar = this.backgroundInfo;
        if (aVar != null) {
            i17 = aVar.getSerializedSize();
        }
        parcel.writeInt(i17);
        if (i17 > 0) {
            byte[] bArr3 = new byte[i17];
            tq4.a aVar2 = this.backgroundInfo;
            if (aVar2 != null) {
                aVar2.writeTo(CodedOutputByteBufferNano.newInstance(bArr3));
            }
            parcel.writeByteArray(bArr3);
        }
    }

    public final void x(@NotNull String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, (Object) str);
        } else {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.appId = str;
        }
    }

    public final void y(@NotNull AvConfig avConfig) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) avConfig);
        } else {
            Intrinsics.checkNotNullParameter(avConfig, "<set-?>");
            this.avConfig = avConfig;
        }
    }

    public final void z(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this, j3);
        } else {
            this.enterRoomTime = j3;
        }
    }

    public AnchorRoomInfo(@NotNull AvConfig avConfig, @NotNull BasicInfo basicInfo, @NotNull SettingInfo settingInfo, @Nullable com.tencent.mobileqq.qqlive.sail.model.common.UserInfo userInfo, @Nullable z zVar, @Nullable pt3.e eVar, long j3, @NotNull String appId, long j16, @NotNull String popupDialogUrl, @Nullable tq4.a aVar) {
        Intrinsics.checkNotNullParameter(avConfig, "avConfig");
        Intrinsics.checkNotNullParameter(basicInfo, "basicInfo");
        Intrinsics.checkNotNullParameter(settingInfo, "settingInfo");
        Intrinsics.checkNotNullParameter(appId, "appId");
        Intrinsics.checkNotNullParameter(popupDialogUrl, "popupDialogUrl");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, avConfig, basicInfo, settingInfo, userInfo, zVar, eVar, Long.valueOf(j3), appId, Long.valueOf(j16), popupDialogUrl, aVar);
            return;
        }
        this.avConfig = avConfig;
        this.basicInfo = basicInfo;
        this.settingInfo = settingInfo;
        this.anchorInfo = userInfo;
        this.trtcInfo = zVar;
        this.thirdPushInfo = eVar;
        this.heartBeatTime = j3;
        this.appId = appId;
        this.enterRoomTime = j16;
        this.popupDialogUrl = popupDialogUrl;
        this.backgroundInfo = aVar;
    }

    public /* synthetic */ AnchorRoomInfo(AvConfig avConfig, BasicInfo basicInfo, SettingInfo settingInfo, com.tencent.mobileqq.qqlive.sail.model.common.UserInfo userInfo, z zVar, pt3.e eVar, long j3, String str, long j16, String str2, tq4.a aVar, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? new AvConfig(false, false, false, 0, false, 0, 63, null) : avConfig, (i3 & 2) != 0 ? new BasicInfo(0L, null, null, null, 15, null) : basicInfo, (i3 & 4) != 0 ? new SettingInfo(0, null, null, null, false, 0, null, false, null, false, 0, 2047, null) : settingInfo, (i3 & 8) != 0 ? null : userInfo, (i3 & 16) != 0 ? null : zVar, (i3 & 32) != 0 ? null : eVar, (i3 & 64) != 0 ? 0L : j3, (i3 & 128) != 0 ? "" : str, (i3 & 256) != 0 ? 0L : j16, (i3 & 512) != 0 ? "" : str2, (i3 & 1024) != 0 ? null : aVar);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, avConfig, basicInfo, settingInfo, userInfo, zVar, eVar, Long.valueOf(j3), str, Long.valueOf(j16), str2, aVar, Integer.valueOf(i3), defaultConstructorMarker);
    }
}
