package com.tencent.mobileqq.qqlive.sail.model;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.exifinterface.media.ExifInterface;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqlive.huya.QQLiveHuYa;
import com.tencent.mobileqq.qqlive.sail.model.audience.SettingInfo;
import com.tencent.mobileqq.qqlive.sail.model.audience.StreamDefinition;
import com.tencent.mobileqq.qqlive.sail.model.audience.StreamFormat;
import com.tencent.mobileqq.qqlive.sail.model.audience.WindowMode;
import com.tencent.mobileqq.qqlive.sail.model.common.BasicInfo;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.common.api.AegisLogger;
import cooperation.qzone.QZoneRequestEncoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import rt3.aa;
import rt3.ab;
import rt3.ac;
import rt3.ae;
import rt3.ah;
import rt3.j;
import rt3.k;
import rt3.p;
import rt3.q;
import rt3.u;
import rt3.z;
import tl.h;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00a8\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\b<\n\u0002\u0010!\n\u0002\b\u000b\b\u0086\b\u0018\u0000 \u008a\u00012\u00020\u00012\u00020\u0002:\u0001@B\u008d\u0001\u0012\b\b\u0002\u0010/\u001a\u00020.\u0012\b\b\u0002\u00101\u001a\u000200\u0012\n\b\u0002\u00102\u001a\u0004\u0018\u00010\u0014\u0012\n\b\u0002\u00103\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u00105\u001a\u0004\u0018\u000104\u0012\n\b\u0002\u00107\u001a\u0004\u0018\u000106\u0012\b\b\u0002\u00108\u001a\u00020\u000b\u0012\b\b\u0002\u00109\u001a\u00020\r\u0012\b\b\u0002\u0010;\u001a\u00020:\u0012\b\b\u0002\u0010<\u001a\u00020\u000b\u0012\n\b\u0002\u0010>\u001a\u0004\u0018\u00010=\u0012\n\b\u0002\u0010?\u001a\u0004\u0018\u00010\u000b\u00a2\u0006\u0006\b\u0088\u0001\u0010\u0089\u0001J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\b\u001a\u00020\u0007H\u0002J\b\u0010\n\u001a\u00020\tH\u0016J\b\u0010\f\u001a\u00020\u000bH\u0016J\b\u0010\u000e\u001a\u00020\rH\u0016J\b\u0010\u0010\u001a\u00020\u000fH\u0016J\b\u0010\u0011\u001a\u00020\u000bH\u0016J\b\u0010\u0012\u001a\u00020\tH\u0016J\b\u0010\u0013\u001a\u00020\u000bH\u0016J\n\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0016J\b\u0010\u0016\u001a\u00020\rH\u0016J\b\u0010\u0017\u001a\u00020\u000bH\u0016J\u0006\u0010\u0018\u001a\u00020\tJ\u0006\u0010\u0019\u001a\u00020\tJ\u0006\u0010\u001a\u001a\u00020\tJ\u0014\u0010\u001e\u001a\u00020\u00072\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001bJ\u0016\u0010!\u001a\u0012\u0012\u0004\u0012\u00020\u001c0\u001fj\b\u0012\u0004\u0012\u00020\u001c` J\u0010\u0010$\u001a\u0004\u0018\u00010\u001c2\u0006\u0010#\u001a\u00020\"J\u000e\u0010%\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u0003J\u000e\u0010'\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020&J\u0018\u0010+\u001a\u00020\u00072\u0006\u0010)\u001a\u00020(2\u0006\u0010*\u001a\u00020\u000fH\u0016J\b\u0010,\u001a\u00020\u000fH\u0016J\n\u0010-\u001a\u0004\u0018\u00010\u000bH\u0016J\u008d\u0001\u0010@\u001a\u00020\u00002\b\b\u0002\u0010/\u001a\u00020.2\b\b\u0002\u00101\u001a\u0002002\n\b\u0002\u00102\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u00103\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u00105\u001a\u0004\u0018\u0001042\n\b\u0002\u00107\u001a\u0004\u0018\u0001062\b\b\u0002\u00108\u001a\u00020\u000b2\b\b\u0002\u00109\u001a\u00020\r2\b\b\u0002\u0010;\u001a\u00020:2\b\b\u0002\u0010<\u001a\u00020\u000b2\n\b\u0002\u0010>\u001a\u0004\u0018\u00010=2\n\b\u0002\u0010?\u001a\u0004\u0018\u00010\u000bH\u00c6\u0001J\t\u0010A\u001a\u00020\u000bH\u00d6\u0001J\t\u0010B\u001a\u00020\u000fH\u00d6\u0001J\u0013\u0010E\u001a\u00020\t2\b\u0010D\u001a\u0004\u0018\u00010CH\u00d6\u0003R\"\u0010/\u001a\u00020.8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bF\u0010G\u001a\u0004\bH\u0010I\"\u0004\bJ\u0010KR\"\u00101\u001a\u0002008\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0016\u0010L\u001a\u0004\bM\u0010N\"\u0004\bO\u0010PR$\u00102\u001a\u0004\u0018\u00010\u00148\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b-\u0010Q\u001a\u0004\bR\u0010S\"\u0004\bT\u0010UR$\u00103\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bV\u0010W\u001a\u0004\bX\u0010Y\"\u0004\bZ\u0010[R$\u00105\u001a\u0004\u0018\u0001048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\\\u0010]\u001a\u0004\b^\u0010_\"\u0004\b`\u0010aR$\u00107\u001a\u0004\u0018\u0001068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b^\u0010b\u001a\u0004\bc\u0010d\"\u0004\be\u0010fR\"\u00108\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\b\u0010g\u001a\u0004\bh\u0010i\"\u0004\bj\u0010kR\"\u00109\u001a\u00020\r8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bj\u0010l\u001a\u0004\bm\u0010n\"\u0004\bo\u0010pR\"\u0010;\u001a\u00020:8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bo\u0010q\u001a\u0004\br\u0010s\"\u0004\bt\u0010uR\"\u0010<\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bv\u0010g\u001a\u0004\bw\u0010i\"\u0004\bx\u0010kR$\u0010>\u001a\u0004\u0018\u00010=8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bt\u0010y\u001a\u0004\bz\u0010{\"\u0004\b|\u0010}R$\u0010?\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b~\u0010g\u001a\u0004\b\u007f\u0010i\"\u0004\bv\u0010kR\u001e\u0010\u0083\u0001\u001a\t\u0012\u0004\u0012\u00020\u001c0\u0080\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u0081\u0001\u0010\u0082\u0001R\u001a\u0010\u0085\u0001\u001a\u0004\u0018\u00010\u001c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\bl\u0010\u0084\u0001R\u001b\u0010\u0087\u0001\u001a\u0004\u0018\u00010\u001c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u0086\u0001\u0010\u0084\u0001\u00a8\u0006\u008b\u0001"}, d2 = {"Lcom/tencent/mobileqq/qqlive/sail/model/AudienceRoomInfo;", "Landroid/os/Parcelable;", "Lcom/tencent/mobileqq/qqlive/sail/model/d;", "Lrt3/f;", "reply", "Lrt3/a;", "V", "", BdhLogUtil.LogTag.Tag_Conn, "", "c", "", "getProgramId", "", "getRoomId", "", "getRoomType", "getRoomName", "g", QZoneRequestEncoder.KEY_COVER_REQ, "Lcom/tencent/mobileqq/qqlive/sail/model/common/UserInfo;", "j", "e", "u", "y", HippyTKDListViewAdapter.X, QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "", "Lcom/tencent/mobileqq/qqlive/sail/model/audience/a;", IjkMediaMeta.IJKM_KEY_STREAMS, "N", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "t", "Lcom/tencent/mobileqq/qqlive/sail/model/audience/StreamDefinition;", "definition", ReportConstant.COSTREPORT_PREFIX, ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Lrt3/h;", "B", "Landroid/os/Parcel;", "parcel", WadlProxyConsts.FLAGS, "writeToParcel", "describeContents", "f", "Lcom/tencent/mobileqq/qqlive/sail/model/common/BasicInfo;", "basicInfo", "Lcom/tencent/mobileqq/qqlive/sail/model/audience/SettingInfo;", "settingInfo", "anchorInfo", "avInfo", "Lrt3/z;", "ecomInfo", "Lrt3/ab;", "gameTaskInfo", "appId", "enterRoomTime", "Lcom/tencent/mobileqq/qqlive/sail/model/audience/WindowMode;", "windowMode", "windowModeSeq", "Lrt3/aa;", "roomEnterSetting", "platform", "a", "toString", "hashCode", "", "other", "equals", "d", "Lcom/tencent/mobileqq/qqlive/sail/model/common/BasicInfo;", "getBasicInfo", "()Lcom/tencent/mobileqq/qqlive/sail/model/common/BasicInfo;", "setBasicInfo", "(Lcom/tencent/mobileqq/qqlive/sail/model/common/BasicInfo;)V", "Lcom/tencent/mobileqq/qqlive/sail/model/audience/SettingInfo;", "r", "()Lcom/tencent/mobileqq/qqlive/sail/model/audience/SettingInfo;", "setSettingInfo", "(Lcom/tencent/mobileqq/qqlive/sail/model/audience/SettingInfo;)V", "Lcom/tencent/mobileqq/qqlive/sail/model/common/UserInfo;", "k", "()Lcom/tencent/mobileqq/qqlive/sail/model/common/UserInfo;", "setAnchorInfo", "(Lcom/tencent/mobileqq/qqlive/sail/model/common/UserInfo;)V", h.F, "Lrt3/a;", "getAvInfo", "()Lrt3/a;", "setAvInfo", "(Lrt3/a;)V", "i", "Lrt3/z;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "()Lrt3/z;", "setEcomInfo", "(Lrt3/z;)V", "Lrt3/ab;", "o", "()Lrt3/ab;", "setGameTaskInfo", "(Lrt3/ab;)V", "Ljava/lang/String;", "l", "()Ljava/lang/String;", "D", "(Ljava/lang/String;)V", "J", DomainData.DOMAIN_NAME, "()J", "E", "(J)V", "Lcom/tencent/mobileqq/qqlive/sail/model/audience/WindowMode;", "v", "()Lcom/tencent/mobileqq/qqlive/sail/model/audience/WindowMode;", "G", "(Lcom/tencent/mobileqq/qqlive/sail/model/audience/WindowMode;)V", UserInfo.SEX_FEMALE, "w", "M", "Lrt3/aa;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "()Lrt3/aa;", "setRoomEnterSetting", "(Lrt3/aa;)V", "H", "p", "", "I", "Ljava/util/List;", "streamInfos", "Lcom/tencent/mobileqq/qqlive/sail/model/audience/a;", "_suggestStreamInfo", "K", "_originalStreamInfo", "<init>", "(Lcom/tencent/mobileqq/qqlive/sail/model/common/BasicInfo;Lcom/tencent/mobileqq/qqlive/sail/model/audience/SettingInfo;Lcom/tencent/mobileqq/qqlive/sail/model/common/UserInfo;Lrt3/a;Lrt3/z;Lrt3/ab;Ljava/lang/String;JLcom/tencent/mobileqq/qqlive/sail/model/audience/WindowMode;Ljava/lang/String;Lrt3/aa;Ljava/lang/String;)V", "CREATOR", "qq-live-sdk-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final /* data */ class AudienceRoomInfo implements Parcelable, d {
    static IPatchRedirector $redirector_;

    /* renamed from: CREATOR, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private String appId;

    /* renamed from: D, reason: from kotlin metadata */
    private long enterRoomTime;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private WindowMode windowMode;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private String windowModeSeq;

    /* renamed from: G, reason: from kotlin metadata */
    @Nullable
    private aa roomEnterSetting;

    /* renamed from: H, reason: from kotlin metadata */
    @Nullable
    private String platform;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private final List<com.tencent.mobileqq.qqlive.sail.model.audience.a> streamInfos;

    /* renamed from: J, reason: from kotlin metadata */
    @Nullable
    private com.tencent.mobileqq.qqlive.sail.model.audience.a _suggestStreamInfo;

    /* renamed from: K, reason: from kotlin metadata */
    @Nullable
    private com.tencent.mobileqq.qqlive.sail.model.audience.a _originalStreamInfo;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private BasicInfo basicInfo;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private SettingInfo settingInfo;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private com.tencent.mobileqq.qqlive.sail.model.common.UserInfo anchorInfo;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private rt3.a avInfo;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private z ecomInfo;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ab gameTaskInfo;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u001f\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a2\u0006\u0004\b\t\u0010\nJ\u000e\u0010\u000b\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/qqlive/sail/model/AudienceRoomInfo$a;", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mobileqq/qqlive/sail/model/AudienceRoomInfo;", "Landroid/os/Parcel;", "parcel", "a", "", "size", "", "b", "(I)[Lcom/tencent/mobileqq/qqlive/sail/model/AudienceRoomInfo;", "c", "<init>", "()V", "qq-live-sdk-api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qqlive.sail.model.AudienceRoomInfo$a, reason: from kotlin metadata */
    /* loaded from: classes17.dex */
    public static final class Companion implements Parcelable.Creator<AudienceRoomInfo> {
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
        public AudienceRoomInfo createFromParcel(@NotNull Parcel parcel) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (AudienceRoomInfo) iPatchRedirector.redirect((short) 2, (Object) this, (Object) parcel);
            }
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return c(parcel);
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public AudienceRoomInfo[] newArray(int size) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (AudienceRoomInfo[]) iPatchRedirector.redirect((short) 3, (Object) this, size);
            }
            return new AudienceRoomInfo[size];
        }

        @NotNull
        public final AudienceRoomInfo c(@NotNull Parcel parcel) {
            aa aaVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (AudienceRoomInfo) iPatchRedirector.redirect((short) 4, (Object) this, (Object) parcel);
            }
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            BasicInfo basicInfo = (BasicInfo) parcel.readTypedObject(BasicInfo.INSTANCE);
            SettingInfo settingInfo = (SettingInfo) parcel.readTypedObject(SettingInfo.INSTANCE);
            com.tencent.mobileqq.qqlive.sail.model.common.UserInfo userInfo = (com.tencent.mobileqq.qqlive.sail.model.common.UserInfo) parcel.readTypedObject(com.tencent.mobileqq.qqlive.sail.model.common.UserInfo.INSTANCE);
            rt3.a aVar = new rt3.a();
            int readInt = parcel.readInt();
            if (readInt > 0) {
                byte[] bArr = new byte[readInt];
                parcel.readByteArray(bArr);
                aVar = rt3.a.c(bArr);
                Intrinsics.checkNotNullExpressionValue(aVar, "parseFrom(byteArray)");
            }
            rt3.a aVar2 = aVar;
            z zVar = new z();
            int readInt2 = parcel.readInt();
            if (readInt2 > 0) {
                byte[] bArr2 = new byte[readInt2];
                parcel.readByteArray(bArr2);
                zVar = z.c(bArr2);
                Intrinsics.checkNotNullExpressionValue(zVar, "parseFrom(byteArray)");
            }
            z zVar2 = zVar;
            ab abVar = new ab();
            int readInt3 = parcel.readInt();
            if (readInt3 > 0) {
                byte[] bArr3 = new byte[readInt3];
                parcel.readByteArray(bArr3);
                abVar = ab.c(bArr3);
                Intrinsics.checkNotNullExpressionValue(abVar, "parseFrom(byteArray)");
            }
            ab abVar2 = abVar;
            String readString = parcel.readString();
            if (readString == null) {
                readString = "";
            }
            String str = readString;
            long readLong = parcel.readLong();
            WindowMode a16 = WindowMode.INSTANCE.a(parcel.readInt());
            String readString2 = parcel.readString();
            if (readString2 == null) {
                readString2 = String.valueOf(System.currentTimeMillis());
            }
            String str2 = readString2;
            Intrinsics.checkNotNullExpressionValue(str2, "parcel.readString() ?: S\u2026ntTimeMillis().toString()");
            aa aaVar2 = new aa();
            int readInt4 = parcel.readInt();
            if (readInt4 > 0) {
                byte[] bArr4 = new byte[readInt4];
                parcel.readByteArray(bArr4);
                aa c16 = aa.c(bArr4);
                Intrinsics.checkNotNullExpressionValue(c16, "parseFrom(byteArray)");
                aaVar = c16;
            } else {
                aaVar = aaVar2;
            }
            Intrinsics.checkNotNull(basicInfo);
            Intrinsics.checkNotNull(settingInfo);
            return new AudienceRoomInfo(basicInfo, settingInfo, userInfo, aVar2, zVar2, abVar2, str, readLong, a16, str2, aaVar, null, 2048, null);
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(30793);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 67)) {
            redirector.redirect((short) 67);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public AudienceRoomInfo() {
        this(null, null, null, null, null, null, null, 0L, null, null, null, null, 4095, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 66)) {
            return;
        }
        iPatchRedirector.redirect((short) 66, (Object) this);
    }

    private final void C() {
        int i3;
        rt3.e eVar;
        ae[] aeVarArr;
        Object orNull;
        Object orNull2;
        rt3.e eVar2;
        this.streamInfos.clear();
        rt3.a aVar = this.avInfo;
        int i16 = 0;
        if (aVar != null && (eVar2 = aVar.f432215i) != null) {
            i3 = eVar2.f432281d;
        } else {
            i3 = 0;
        }
        if (aVar != null && (eVar = aVar.f432215i) != null && (aeVarArr = eVar.f432278a) != null) {
            orNull = ArraysKt___ArraysKt.getOrNull(aeVarArr, 0);
            ae aeVar = (ae) orNull;
            if (aeVar != null) {
                int i17 = aeVar.f432243c;
                k[] frames = aeVar.f432241a;
                if (frames != null) {
                    Intrinsics.checkNotNullExpressionValue(frames, "frames");
                    int length = frames.length;
                    int i18 = 0;
                    while (i18 < length) {
                        k kVar = frames[i18];
                        String name = kVar.f432319c;
                        int i19 = kVar.f432317a;
                        rt3.b[] bVarArr = kVar.f432318b;
                        Intrinsics.checkNotNullExpressionValue(bVarArr, "frame.addresses");
                        orNull2 = ArraysKt___ArraysKt.getOrNull(bVarArr, i16);
                        rt3.b bVar = (rt3.b) orNull2;
                        if (bVar != null) {
                            Intrinsics.checkNotNullExpressionValue(name, "name");
                            StreamDefinition a16 = StreamDefinition.INSTANCE.a(i19);
                            int i26 = bVar.f432264b;
                            String str = bVar.f432263a;
                            Intrinsics.checkNotNullExpressionValue(str, "it.url");
                            StreamFormat.Companion companion = StreamFormat.INSTANCE;
                            String str2 = bVar.f432265c;
                            Intrinsics.checkNotNullExpressionValue(str2, "it.format");
                            com.tencent.mobileqq.qqlive.sail.model.audience.a aVar2 = new com.tencent.mobileqq.qqlive.sail.model.audience.a(name, a16, i26, str, companion.a(str2), null, 32, null);
                            if (i3 == i19) {
                                this._suggestStreamInfo = aVar2;
                            }
                            if (i17 == i19) {
                                this._originalStreamInfo = aVar2;
                            }
                            this.streamInfos.add(aVar2);
                        }
                        i18++;
                        i16 = 0;
                    }
                }
            }
        }
        if (this.streamInfos.isEmpty()) {
            AegisLogger.INSTANCE.e("Audience|AudienceRoomInfo", "parseStreamInfo", "no streams");
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x001b  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0025  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final rt3.a V(rt3.f reply) {
        j[] jVarArr;
        boolean z16;
        Object firstOrNull;
        boolean z17;
        q qVar = reply.f432283a;
        if (qVar != null) {
            jVarArr = qVar.f432349m;
        } else {
            jVarArr = null;
        }
        int i3 = 1;
        if (jVarArr != null) {
            if (jVarArr.length == 0) {
                z17 = true;
            } else {
                z17 = false;
            }
            if (!z17) {
                z16 = false;
                if (!z16) {
                    QLog.e("Audience|AudienceRoomInfo", 1, "wrapHuYaAVInfo flvMulti invalid");
                    return null;
                }
                rt3.a aVar = new rt3.a();
                rt3.e eVar = new rt3.e();
                ae aeVar = new ae();
                aeVar.f432243c = 0;
                ArrayList arrayList = new ArrayList();
                firstOrNull = ArraysKt___ArraysKt.firstOrNull(jVarArr);
                j jVar = (j) firstOrNull;
                if (jVar != null) {
                    u[] uVarArr = jVar.f432315c;
                    Intrinsics.checkNotNullExpressionValue(uVarArr, "flv.lineDetail");
                    for (u uVar : uVarArr) {
                        k kVar = new k();
                        kVar.f432319c = uVar.f432358a;
                        kVar.f432317a = QQLiveHuYa.f271333a.h(uVar.f432359b);
                        rt3.b bVar = new rt3.b();
                        bVar.f432263a = uVar.f432360c;
                        bVar.f432264b = uVar.f432359b;
                        bVar.f432265c = "flv";
                        kVar.f432318b = new rt3.b[]{bVar};
                        arrayList.add(kVar);
                    }
                }
                Object[] array = arrayList.toArray(new k[0]);
                Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                aeVar.f432241a = (k[]) array;
                eVar.f432278a = new ae[]{aeVar};
                aVar.f432215i = eVar;
                if (!reply.f432283a.f432351o) {
                    i3 = 2;
                }
                aVar.f432207a = i3;
                return aVar;
            }
        }
        z16 = true;
        if (!z16) {
        }
    }

    public final void A(@NotNull rt3.f reply) {
        long j3;
        String str;
        String str2;
        String str3;
        String str4;
        long j16;
        String str5;
        String str6;
        long j17;
        String str7;
        String str8;
        String str9;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 45)) {
            iPatchRedirector.redirect((short) 45, (Object) this, (Object) reply);
            return;
        }
        Intrinsics.checkNotNullParameter(reply, "reply");
        this.enterRoomTime = System.currentTimeMillis();
        q qVar = reply.f432283a;
        long j18 = 0;
        if (qVar != null) {
            j3 = qVar.f432337a;
        } else {
            j3 = 0;
        }
        String str10 = null;
        if (qVar != null) {
            str = qVar.f432343g;
        } else {
            str = null;
        }
        if (str == null) {
            str2 = "";
        } else {
            str2 = str;
        }
        this.basicInfo = new BasicInfo(j3, str2, null, null, 12, null);
        q qVar2 = reply.f432283a;
        if (qVar2 != null) {
            str3 = qVar2.f432340d;
        } else {
            str3 = null;
        }
        if (str3 == null) {
            str4 = "";
        } else {
            str4 = str3;
        }
        int i3 = 0;
        if (qVar2 != null) {
            j16 = qVar2.f432338b;
        } else {
            j16 = 0;
        }
        if (qVar2 != null) {
            str5 = qVar2.f432339c;
        } else {
            str5 = null;
        }
        if (str5 == null) {
            str6 = "";
        } else {
            str6 = str5;
        }
        this.settingInfo = new SettingInfo(str4, i3, j16, str6, 2, null, 32, null);
        p pVar = reply.f432284b;
        if (pVar != null) {
            j17 = pVar.f432333a;
        } else {
            j17 = 0;
        }
        if (pVar != null) {
            str7 = pVar.f432334b;
        } else {
            str7 = null;
        }
        if (str7 == null) {
            str8 = "";
        } else {
            str8 = str7;
        }
        if (pVar != null) {
            str10 = pVar.f432335c;
        }
        if (str10 == null) {
            str9 = "";
        } else {
            str9 = str10;
        }
        if (pVar != null) {
            j18 = pVar.f432336d;
        }
        this.anchorInfo = new com.tencent.mobileqq.qqlive.sail.model.common.UserInfo(j17, 0, 0L, str8, str9, 0, null, j18, 102, null);
        this.avInfo = V(reply);
        this.gameTaskInfo = reply.f432285c;
        C();
    }

    public final void B(@NotNull rt3.h reply) {
        long j3;
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        long j16;
        String str7;
        String str8;
        long j17;
        int i3;
        long j18;
        String str9;
        String str10;
        String str11;
        String str12;
        String str13;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 46)) {
            iPatchRedirector.redirect((short) 46, (Object) this, (Object) reply);
            return;
        }
        Intrinsics.checkNotNullParameter(reply, "reply");
        this.enterRoomTime = System.currentTimeMillis();
        ac acVar = reply.f432290d;
        long j19 = 0;
        if (acVar != null) {
            j3 = acVar.f432229a;
        } else {
            j3 = 0;
        }
        String str14 = null;
        if (acVar != null) {
            str = acVar.f432237i;
        } else {
            str = null;
        }
        if (str == null) {
            str2 = "";
        } else {
            str2 = str;
        }
        if (acVar != null) {
            str3 = acVar.f432238j;
        } else {
            str3 = null;
        }
        if (str3 == null) {
            str4 = "";
        } else {
            str4 = str3;
        }
        this.basicInfo = new BasicInfo(j3, str2, str4, null, 8, null);
        ac acVar2 = reply.f432290d;
        if (acVar2 != null) {
            str5 = acVar2.f432232d;
        } else {
            str5 = null;
        }
        if (str5 == null) {
            str6 = "";
        } else {
            str6 = str5;
        }
        int i16 = 0;
        if (acVar2 != null) {
            j16 = acVar2.f432230b;
        } else {
            j16 = 0;
        }
        if (acVar2 != null) {
            str7 = acVar2.f432231c;
        } else {
            str7 = null;
        }
        if (str7 == null) {
            str8 = "";
        } else {
            str8 = str7;
        }
        this.settingInfo = new SettingInfo(str6, i16, j16, str8, reply.f432300n, null, 32, null);
        ah ahVar = reply.f432291e;
        if (ahVar != null) {
            j17 = ahVar.f432253a;
        } else {
            j17 = 0;
        }
        int i17 = 0;
        if (ahVar != null) {
            i3 = ahVar.f432254b;
        } else {
            i3 = 0;
        }
        if (ahVar != null) {
            j18 = ahVar.f432256d;
        } else {
            j18 = 0;
        }
        if (ahVar != null) {
            str9 = ahVar.f432255c;
        } else {
            str9 = null;
        }
        if (str9 == null) {
            str10 = "";
        } else {
            str10 = str9;
        }
        if (ahVar != null) {
            str11 = ahVar.f432257e;
        } else {
            str11 = null;
        }
        if (str11 == null) {
            str12 = "";
        } else {
            str12 = str11;
        }
        if (ahVar != null) {
            i17 = ahVar.f432259g;
        }
        int i18 = i17;
        if (ahVar != null) {
            str14 = ahVar.f432260h;
        }
        if (str14 == null) {
            str13 = "";
        } else {
            str13 = str14;
        }
        if (ahVar != null) {
            j19 = ahVar.f432258f;
        }
        this.anchorInfo = new com.tencent.mobileqq.qqlive.sail.model.common.UserInfo(j17, i3, j18, str10, str12, i18, str13, j19);
        this.avInfo = reply.f432293g;
        this.ecomInfo = reply.f432297k;
        this.gameTaskInfo = reply.f432301o;
        this.roomEnterSetting = reply.f432302p;
        C();
    }

    public final void D(@NotNull String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, (Object) str);
        } else {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.appId = str;
        }
    }

    public final void E(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, j3);
        } else {
            this.enterRoomTime = j3;
        }
    }

    public final void F(@Nullable String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, (Object) this, (Object) str);
        } else {
            this.platform = str;
        }
    }

    public final void G(@NotNull WindowMode windowMode) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this, (Object) windowMode);
        } else {
            Intrinsics.checkNotNullParameter(windowMode, "<set-?>");
            this.windowMode = windowMode;
        }
    }

    public final void M(@NotNull String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this, (Object) str);
        } else {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.windowModeSeq = str;
        }
    }

    public final void N(@NotNull List<com.tencent.mobileqq.qqlive.sail.model.audience.a> streams) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 41)) {
            iPatchRedirector.redirect((short) 41, (Object) this, (Object) streams);
            return;
        }
        Intrinsics.checkNotNullParameter(streams, "streams");
        this.streamInfos.clear();
        this.streamInfos.addAll(streams);
    }

    @NotNull
    public final AudienceRoomInfo a(@NotNull BasicInfo basicInfo, @NotNull SettingInfo settingInfo, @Nullable com.tencent.mobileqq.qqlive.sail.model.common.UserInfo anchorInfo, @Nullable rt3.a avInfo, @Nullable z ecomInfo, @Nullable ab gameTaskInfo, @NotNull String appId, long enterRoomTime, @NotNull WindowMode windowMode, @NotNull String windowModeSeq, @Nullable aa roomEnterSetting, @Nullable String platform) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 62)) {
            return (AudienceRoomInfo) iPatchRedirector.redirect((short) 62, this, basicInfo, settingInfo, anchorInfo, avInfo, ecomInfo, gameTaskInfo, appId, Long.valueOf(enterRoomTime), windowMode, windowModeSeq, roomEnterSetting, platform);
        }
        Intrinsics.checkNotNullParameter(basicInfo, "basicInfo");
        Intrinsics.checkNotNullParameter(settingInfo, "settingInfo");
        Intrinsics.checkNotNullParameter(appId, "appId");
        Intrinsics.checkNotNullParameter(windowMode, "windowMode");
        Intrinsics.checkNotNullParameter(windowModeSeq, "windowModeSeq");
        return new AudienceRoomInfo(basicInfo, settingInfo, anchorInfo, avInfo, ecomInfo, gameTaskInfo, appId, enterRoomTime, windowMode, windowModeSeq, roomEnterSetting, platform);
    }

    @Override // com.tencent.mobileqq.qqlive.sail.model.d
    public boolean c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            return ((Boolean) iPatchRedirector.redirect((short) 27, (Object) this)).booleanValue();
        }
        return false;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 48)) {
            return ((Integer) iPatchRedirector.redirect((short) 48, (Object) this)).intValue();
        }
        return 0;
    }

    @Override // com.tencent.mobileqq.qqlive.sail.model.d
    public long e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 36)) {
            return ((Long) iPatchRedirector.redirect((short) 36, (Object) this)).longValue();
        }
        return this.enterRoomTime;
    }

    public boolean equals(@Nullable Object other) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 65)) {
            return ((Boolean) iPatchRedirector.redirect((short) 65, (Object) this, other)).booleanValue();
        }
        if (this == other) {
            return true;
        }
        if (!(other instanceof AudienceRoomInfo)) {
            return false;
        }
        AudienceRoomInfo audienceRoomInfo = (AudienceRoomInfo) other;
        if (Intrinsics.areEqual(this.basicInfo, audienceRoomInfo.basicInfo) && Intrinsics.areEqual(this.settingInfo, audienceRoomInfo.settingInfo) && Intrinsics.areEqual(this.anchorInfo, audienceRoomInfo.anchorInfo) && Intrinsics.areEqual(this.avInfo, audienceRoomInfo.avInfo) && Intrinsics.areEqual(this.ecomInfo, audienceRoomInfo.ecomInfo) && Intrinsics.areEqual(this.gameTaskInfo, audienceRoomInfo.gameTaskInfo) && Intrinsics.areEqual(this.appId, audienceRoomInfo.appId) && this.enterRoomTime == audienceRoomInfo.enterRoomTime && this.windowMode == audienceRoomInfo.windowMode && Intrinsics.areEqual(this.windowModeSeq, audienceRoomInfo.windowModeSeq) && Intrinsics.areEqual(this.roomEnterSetting, audienceRoomInfo.roomEnterSetting) && Intrinsics.areEqual(this.platform, audienceRoomInfo.platform)) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.qqlive.sail.model.d
    @Nullable
    public String f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 49)) {
            return (String) iPatchRedirector.redirect((short) 49, (Object) this);
        }
        return this.platform;
    }

    @Override // com.tencent.mobileqq.qqlive.sail.model.d
    public boolean g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            return ((Boolean) iPatchRedirector.redirect((short) 33, (Object) this)).booleanValue();
        }
        z zVar = this.ecomInfo;
        if (zVar == null || !zVar.f432386a) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.mobileqq.qqlive.sail.model.d
    @NotNull
    public String getCover() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
            return (String) iPatchRedirector.redirect((short) 34, (Object) this);
        }
        return this.settingInfo.b();
    }

    @Override // com.tencent.mobileqq.qqlive.sail.model.d
    @NotNull
    public String getProgramId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            return (String) iPatchRedirector.redirect((short) 29, (Object) this);
        }
        return this.basicInfo.f();
    }

    @Override // com.tencent.mobileqq.qqlive.sail.model.d
    public long getRoomId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            return ((Long) iPatchRedirector.redirect((short) 30, (Object) this)).longValue();
        }
        return this.basicInfo.g();
    }

    @Override // com.tencent.mobileqq.qqlive.sail.model.d
    @NotNull
    public String getRoomName() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            return (String) iPatchRedirector.redirect((short) 32, (Object) this);
        }
        return this.settingInfo.c();
    }

    @Override // com.tencent.mobileqq.qqlive.sail.model.d
    public int getRoomType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            return ((Integer) iPatchRedirector.redirect((short) 31, (Object) this)).intValue();
        }
        return this.settingInfo.e();
    }

    public int hashCode() {
        int hashCode;
        int hashCode2;
        int hashCode3;
        int hashCode4;
        int hashCode5;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 64)) {
            return ((Integer) iPatchRedirector.redirect((short) 64, (Object) this)).intValue();
        }
        int hashCode6 = ((this.basicInfo.hashCode() * 31) + this.settingInfo.hashCode()) * 31;
        com.tencent.mobileqq.qqlive.sail.model.common.UserInfo userInfo = this.anchorInfo;
        int i3 = 0;
        if (userInfo == null) {
            hashCode = 0;
        } else {
            hashCode = userInfo.hashCode();
        }
        int i16 = (hashCode6 + hashCode) * 31;
        rt3.a aVar = this.avInfo;
        if (aVar == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = aVar.hashCode();
        }
        int i17 = (i16 + hashCode2) * 31;
        z zVar = this.ecomInfo;
        if (zVar == null) {
            hashCode3 = 0;
        } else {
            hashCode3 = zVar.hashCode();
        }
        int i18 = (i17 + hashCode3) * 31;
        ab abVar = this.gameTaskInfo;
        if (abVar == null) {
            hashCode4 = 0;
        } else {
            hashCode4 = abVar.hashCode();
        }
        int hashCode7 = (((((((((i18 + hashCode4) * 31) + this.appId.hashCode()) * 31) + androidx.fragment.app.a.a(this.enterRoomTime)) * 31) + this.windowMode.hashCode()) * 31) + this.windowModeSeq.hashCode()) * 31;
        aa aaVar = this.roomEnterSetting;
        if (aaVar == null) {
            hashCode5 = 0;
        } else {
            hashCode5 = aaVar.hashCode();
        }
        int i19 = (hashCode7 + hashCode5) * 31;
        String str = this.platform;
        if (str != null) {
            i3 = str.hashCode();
        }
        return i19 + i3;
    }

    @Override // com.tencent.mobileqq.qqlive.sail.model.d
    @Nullable
    public com.tencent.mobileqq.qqlive.sail.model.common.UserInfo j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 35)) {
            return (com.tencent.mobileqq.qqlive.sail.model.common.UserInfo) iPatchRedirector.redirect((short) 35, (Object) this);
        }
        return this.anchorInfo;
    }

    @Nullable
    public final com.tencent.mobileqq.qqlive.sail.model.common.UserInfo k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (com.tencent.mobileqq.qqlive.sail.model.common.UserInfo) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return this.anchorInfo;
    }

    @NotNull
    public final String l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return (String) iPatchRedirector.redirect((short) 15, (Object) this);
        }
        return this.appId;
    }

    @Nullable
    public final z m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (z) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        return this.ecomInfo;
    }

    public final long n() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return ((Long) iPatchRedirector.redirect((short) 17, (Object) this)).longValue();
        }
        return this.enterRoomTime;
    }

    @Nullable
    public final ab o() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (ab) iPatchRedirector.redirect((short) 13, (Object) this);
        }
        return this.gameTaskInfo;
    }

    @Nullable
    public final String p() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            return (String) iPatchRedirector.redirect((short) 25, (Object) this);
        }
        return this.platform;
    }

    @Nullable
    public final aa q() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return (aa) iPatchRedirector.redirect((short) 23, (Object) this);
        }
        return this.roomEnterSetting;
    }

    @NotNull
    public final SettingInfo r() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (SettingInfo) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.settingInfo;
    }

    @Nullable
    public final com.tencent.mobileqq.qqlive.sail.model.audience.a s(@NotNull StreamDefinition definition) {
        Object obj;
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 43)) {
            return (com.tencent.mobileqq.qqlive.sail.model.audience.a) iPatchRedirector.redirect((short) 43, (Object) this, (Object) definition);
        }
        Intrinsics.checkNotNullParameter(definition, "definition");
        if (this.streamInfos.isEmpty()) {
            C();
        }
        Iterator<T> it = this.streamInfos.iterator();
        while (true) {
            if (it.hasNext()) {
                obj = it.next();
                if (((com.tencent.mobileqq.qqlive.sail.model.audience.a) obj).b() == definition) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        return (com.tencent.mobileqq.qqlive.sail.model.audience.a) obj;
    }

    @NotNull
    public final ArrayList<com.tencent.mobileqq.qqlive.sail.model.audience.a> t() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 42)) {
            return (ArrayList) iPatchRedirector.redirect((short) 42, (Object) this);
        }
        if (this.streamInfos.isEmpty()) {
            C();
        }
        return new ArrayList<>(this.streamInfos);
    }

    @NotNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 63)) {
            return (String) iPatchRedirector.redirect((short) 63, (Object) this);
        }
        return "AudienceRoomInfo(basicInfo=" + this.basicInfo + ", settingInfo=" + this.settingInfo + ", anchorInfo=" + this.anchorInfo + ", avInfo=" + this.avInfo + ", ecomInfo=" + this.ecomInfo + ", gameTaskInfo=" + this.gameTaskInfo + ", appId=" + this.appId + ", enterRoomTime=" + this.enterRoomTime + ", windowMode=" + this.windowMode + ", windowModeSeq=" + this.windowModeSeq + ", roomEnterSetting=" + this.roomEnterSetting + ", platform=" + this.platform + ")";
    }

    @NotNull
    public String u() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 37)) {
            return (String) iPatchRedirector.redirect((short) 37, (Object) this);
        }
        return this.basicInfo.c();
    }

    @NotNull
    public final WindowMode v() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return (WindowMode) iPatchRedirector.redirect((short) 19, (Object) this);
        }
        return this.windowMode;
    }

    @NotNull
    public final String w() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return (String) iPatchRedirector.redirect((short) 21, (Object) this);
        }
        return this.windowModeSeq;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        int i3;
        int i16;
        int i17;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 47)) {
            iPatchRedirector.redirect((short) 47, (Object) this, (Object) parcel, flags);
            return;
        }
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeTypedObject(this.basicInfo, flags);
        parcel.writeTypedObject(this.settingInfo, flags);
        parcel.writeTypedObject(this.anchorInfo, flags);
        rt3.a aVar = this.avInfo;
        int i18 = 0;
        if (aVar != null) {
            i3 = aVar.getSerializedSize();
        } else {
            i3 = 0;
        }
        parcel.writeInt(i3);
        if (i3 > 0) {
            byte[] bArr = new byte[i3];
            rt3.a aVar2 = this.avInfo;
            if (aVar2 != null) {
                aVar2.writeTo(CodedOutputByteBufferNano.newInstance(bArr));
            }
            parcel.writeByteArray(bArr);
        }
        z zVar = this.ecomInfo;
        if (zVar != null) {
            i16 = zVar.getSerializedSize();
        } else {
            i16 = 0;
        }
        parcel.writeInt(i16);
        if (i16 > 0) {
            byte[] bArr2 = new byte[i16];
            z zVar2 = this.ecomInfo;
            if (zVar2 != null) {
                zVar2.writeTo(CodedOutputByteBufferNano.newInstance(bArr2));
            }
            parcel.writeByteArray(bArr2);
        }
        ab abVar = this.gameTaskInfo;
        if (abVar != null) {
            i17 = abVar.getSerializedSize();
        } else {
            i17 = 0;
        }
        parcel.writeInt(i17);
        if (i17 > 0) {
            byte[] bArr3 = new byte[i17];
            ab abVar2 = this.gameTaskInfo;
            if (abVar2 != null) {
                abVar2.writeTo(CodedOutputByteBufferNano.newInstance(bArr3));
            }
            parcel.writeByteArray(bArr3);
        }
        parcel.writeString(this.appId);
        parcel.writeLong(this.enterRoomTime);
        parcel.writeInt(this.windowMode.getValue());
        parcel.writeString(this.windowModeSeq);
        aa aaVar = this.roomEnterSetting;
        if (aaVar != null) {
            i18 = aaVar.getSerializedSize();
        }
        parcel.writeInt(i18);
        if (i18 > 0) {
            byte[] bArr4 = new byte[i18];
            aa aaVar2 = this.roomEnterSetting;
            if (aaVar2 != null) {
                aaVar2.writeTo(CodedOutputByteBufferNano.newInstance(bArr4));
            }
            parcel.writeByteArray(bArr4);
        }
    }

    public final boolean x() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 39)) {
            return ((Boolean) iPatchRedirector.redirect((short) 39, (Object) this)).booleanValue();
        }
        return Intrinsics.areEqual(this.platform, "huya");
    }

    public final boolean y() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 38)) {
            return ((Boolean) iPatchRedirector.redirect((short) 38, (Object) this)).booleanValue();
        }
        if ((!x() && this.settingInfo.a() == 1) || x()) {
            return true;
        }
        return false;
    }

    public final boolean z() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 40)) {
            return ((Boolean) iPatchRedirector.redirect((short) 40, (Object) this)).booleanValue();
        }
        rt3.a aVar = this.avInfo;
        if (aVar == null || aVar.f432207a == 2) {
            return true;
        }
        return false;
    }

    public AudienceRoomInfo(@NotNull BasicInfo basicInfo, @NotNull SettingInfo settingInfo, @Nullable com.tencent.mobileqq.qqlive.sail.model.common.UserInfo userInfo, @Nullable rt3.a aVar, @Nullable z zVar, @Nullable ab abVar, @NotNull String appId, long j3, @NotNull WindowMode windowMode, @NotNull String windowModeSeq, @Nullable aa aaVar, @Nullable String str) {
        Intrinsics.checkNotNullParameter(basicInfo, "basicInfo");
        Intrinsics.checkNotNullParameter(settingInfo, "settingInfo");
        Intrinsics.checkNotNullParameter(appId, "appId");
        Intrinsics.checkNotNullParameter(windowMode, "windowMode");
        Intrinsics.checkNotNullParameter(windowModeSeq, "windowModeSeq");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, basicInfo, settingInfo, userInfo, aVar, zVar, abVar, appId, Long.valueOf(j3), windowMode, windowModeSeq, aaVar, str);
            return;
        }
        this.basicInfo = basicInfo;
        this.settingInfo = settingInfo;
        this.anchorInfo = userInfo;
        this.avInfo = aVar;
        this.ecomInfo = zVar;
        this.gameTaskInfo = abVar;
        this.appId = appId;
        this.enterRoomTime = j3;
        this.windowMode = windowMode;
        this.windowModeSeq = windowModeSeq;
        this.roomEnterSetting = aaVar;
        this.platform = str;
        this.streamInfos = new ArrayList();
    }

    public /* synthetic */ AudienceRoomInfo(BasicInfo basicInfo, SettingInfo settingInfo, com.tencent.mobileqq.qqlive.sail.model.common.UserInfo userInfo, rt3.a aVar, z zVar, ab abVar, String str, long j3, WindowMode windowMode, String str2, aa aaVar, String str3, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? new BasicInfo(0L, null, null, null, 15, null) : basicInfo, (i3 & 2) != 0 ? new SettingInfo(null, 0, 0L, null, 0, null, 63, null) : settingInfo, (i3 & 4) != 0 ? null : userInfo, (i3 & 8) != 0 ? null : aVar, (i3 & 16) != 0 ? null : zVar, (i3 & 32) != 0 ? null : abVar, (i3 & 64) != 0 ? "" : str, (i3 & 128) != 0 ? 0L : j3, (i3 & 256) != 0 ? WindowMode.NORMAL : windowMode, (i3 & 512) != 0 ? String.valueOf(System.currentTimeMillis()) : str2, (i3 & 1024) != 0 ? null : aaVar, (i3 & 2048) != 0 ? null : str3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, basicInfo, settingInfo, userInfo, aVar, zVar, abVar, str, Long.valueOf(j3), windowMode, str2, aaVar, str3, Integer.valueOf(i3), defaultConstructorMarker);
    }
}
