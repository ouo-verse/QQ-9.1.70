package af4;

import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.heytap.databaseengine.utils.DateUtil;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.mini.report.MiniAppDesktopDtReportHelper;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;
import vn4.TimiPicInfo;

/* compiled from: P */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b<\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\b\u0018\u0000 N2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001jB\u00e7\u0001\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0012\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u0003\u0012\b\b\u0002\u0010%\u001a\u00020\u001e\u0012\b\b\u0002\u0010*\u001a\u00020\u0005\u0012\b\b\u0002\u0010.\u001a\u00020\u0005\u0012\b\b\u0002\u00102\u001a\u00020\u0005\u0012\b\b\u0002\u00106\u001a\u00020\u0005\u0012\b\b\u0002\u0010:\u001a\u00020\u0003\u0012\b\b\u0002\u0010=\u001a\u00020\u0003\u0012\b\b\u0002\u0010D\u001a\u00020\t\u0012\b\b\u0002\u0010H\u001a\u00020\u0005\u0012\b\b\u0002\u0010J\u001a\u00020\u0005\u0012\b\b\u0002\u0010L\u001a\u00020\u0003\u0012\b\b\u0002\u0010O\u001a\u00020\u0005\u0012\b\b\u0002\u0010P\u001a\u00020\u0012\u0012\b\b\u0002\u0010S\u001a\u00020\u0012\u0012\b\b\u0002\u0010U\u001a\u00020\u0012\u0012\b\b\u0002\u0010X\u001a\u00020\u0003\u0012\b\b\u0002\u0010Z\u001a\u00020\u0012\u0012\n\b\u0002\u0010a\u001a\u0004\u0018\u00010[\u0012\n\b\u0002\u0010g\u001a\u0004\u0018\u00010b\u00a2\u0006\u0004\bh\u0010iJ\u0011\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0000H\u0096\u0002J\t\u0010\u0006\u001a\u00020\u0005H\u00d6\u0001J\t\u0010\u0007\u001a\u00020\u0003H\u00d6\u0001J\u0013\u0010\n\u001a\u00020\t2\b\u0010\u0002\u001a\u0004\u0018\u00010\bH\u00d6\u0003R\"\u0010\u0011\u001a\u00020\u00038\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\"\u0010\u0019\u001a\u00020\u00128\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\"\u0010\u001d\u001a\u00020\u00038\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001a\u0010\f\u001a\u0004\b\u001b\u0010\u000e\"\u0004\b\u001c\u0010\u0010R\"\u0010%\u001a\u00020\u001e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\"\u0010*\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0004\u0010&\u001a\u0004\b'\u0010(\"\u0004\b\u0014\u0010)R\"\u0010.\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b+\u0010&\u001a\u0004\b,\u0010(\"\u0004\b-\u0010)R\"\u00102\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b/\u0010&\u001a\u0004\b0\u0010(\"\u0004\b1\u0010)R\"\u00106\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b3\u0010&\u001a\u0004\b4\u0010(\"\u0004\b5\u0010)R\"\u0010:\u001a\u00020\u00038\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b7\u0010\f\u001a\u0004\b8\u0010\u000e\"\u0004\b9\u0010\u0010R\"\u0010=\u001a\u00020\u00038\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b;\u0010\f\u001a\u0004\b<\u0010\u000e\"\u0004\b\f\u0010\u0010R\"\u0010D\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b>\u0010?\u001a\u0004\b@\u0010A\"\u0004\bB\u0010CR\"\u0010H\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bE\u0010&\u001a\u0004\bF\u0010(\"\u0004\bG\u0010)R\"\u0010J\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010&\u001a\u0004\bI\u0010(\"\u0004\b3\u0010)R\"\u0010L\u001a\u00020\u00038\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0014\u0010\f\u001a\u0004\bK\u0010\u000e\"\u0004\b7\u0010\u0010R\"\u0010O\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b-\u0010&\u001a\u0004\bM\u0010(\"\u0004\bN\u0010)R\"\u0010P\u001a\u00020\u00128\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000f\u0010\u0014\u001a\u0004\b+\u0010\u0016\"\u0004\b>\u0010\u0018R\"\u0010S\u001a\u00020\u00128\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b#\u0010\u0014\u001a\u0004\bQ\u0010\u0016\"\u0004\bR\u0010\u0018R\"\u0010U\u001a\u00020\u00128\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b9\u0010\u0014\u001a\u0004\bT\u0010\u0016\"\u0004\bE\u0010\u0018R\"\u0010X\u001a\u00020\u00038\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b5\u0010\f\u001a\u0004\bV\u0010\u000e\"\u0004\bW\u0010\u0010R\"\u0010Z\u001a\u00020\u00128\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bW\u0010\u0014\u001a\u0004\bY\u0010\u0016\"\u0004\b;\u0010\u0018R$\u0010a\u001a\u0004\u0018\u00010[8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bR\u0010\\\u001a\u0004\b]\u0010^\"\u0004\b_\u0010`R$\u0010g\u001a\u0004\u0018\u00010b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b_\u0010c\u001a\u0004\bd\u0010e\"\u0004\b/\u0010f\u00a8\u0006k"}, d2 = {"Laf4/d;", "", "other", "", "i", "", "toString", "hashCode", "", "", "equals", "d", "I", "r", "()I", "L", "(I)V", "operationType", "", "e", "J", "t", "()J", "O", "(J)V", "roomId", "f", "getAdPosId", "B", "adPosId", "Lvn4/a;", h.F, "Lvn4/a;", ReportConstant.COSTREPORT_PREFIX, "()Lvn4/a;", "M", "(Lvn4/a;)V", "pic", "Ljava/lang/String;", "p", "()Ljava/lang/String;", "(Ljava/lang/String;)V", "jumpType", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "K", WadlProxyConsts.KEY_JUMP_URL, BdhLogUtil.LogTag.Tag_Conn, "y", "U", "view", "D", "getScene", "P", "scene", "E", "getPriority", "N", "priority", UserInfo.SEX_FEMALE, "o", "iAdId", "G", "Z", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "()Z", "setRedPacket", "(Z)V", "isRedPacket", "H", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "V", "wroomid", "k", "broomid", "l", "contentFilter", HippyTKDListViewAdapter.X, "T", MiniAppDesktopDtReportHelper.DT_MINI_TRACE_INFO, "eTimer", "v", BdhLogUtil.LogTag.Tag_Req, "startTime", DomainData.DOMAIN_NAME, "endTime", "u", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, WadlProxyConsts.SCENE_ID, "getDataTimeStamp", "dataTimeStamp", "Laf4/e;", "Laf4/e;", "w", "()Laf4/e;", ExifInterface.LATITUDE_SOUTH, "(Laf4/e;)V", "timiRedPocketData", "Laf4/b;", "Laf4/b;", "j", "()Laf4/b;", "(Laf4/b;)V", "batteryData", "<init>", "(IJILvn4/a;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IIZLjava/lang/String;Ljava/lang/String;ILjava/lang/String;JJJIJLaf4/e;Laf4/b;)V", "a", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: af4.d, reason: from toString */
/* loaded from: classes26.dex */
public final /* data */ class OperationItem implements Comparable<OperationItem> {

    /* renamed from: T, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final SimpleDateFormat U = new SimpleDateFormat(DateUtil.DATE_FORMAT_14, Locale.CHINA);

    /* renamed from: C, reason: from kotlin metadata and from toString */
    @NotNull
    private String view;

    /* renamed from: D, reason: from kotlin metadata and from toString */
    @NotNull
    private String scene;

    /* renamed from: E, reason: from kotlin metadata and from toString */
    private int priority;

    /* renamed from: F, reason: from kotlin metadata and from toString */
    private int iAdId;

    /* renamed from: G, reason: from kotlin metadata and from toString */
    private boolean isRedPacket;

    /* renamed from: H, reason: from kotlin metadata and from toString */
    @NotNull
    private String wroomid;

    /* renamed from: I, reason: from kotlin metadata and from toString */
    @NotNull
    private String broomid;

    /* renamed from: J, reason: from kotlin metadata and from toString */
    private int contentFilter;

    /* renamed from: K, reason: from kotlin metadata and from toString */
    @NotNull
    private String traceInfo;

    /* renamed from: L, reason: from kotlin metadata and from toString */
    private long eTimer;

    /* renamed from: M, reason: from kotlin metadata and from toString */
    private long startTime;

    /* renamed from: N, reason: from kotlin metadata and from toString */
    private long endTime;

    /* renamed from: P, reason: from kotlin metadata and from toString */
    private int sceneId;

    /* renamed from: Q, reason: from kotlin metadata and from toString */
    private long dataTimeStamp;

    /* renamed from: R, reason: from kotlin metadata and from toString */
    @Nullable
    private RedPocketOperationData timiRedPocketData;

    /* renamed from: S, reason: from kotlin metadata and from toString */
    @Nullable
    private BatteryOperationData batteryData;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private int operationType;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    private long roomId;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    private int adPosId;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private TimiPicInfo pic;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private String jumpType;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private String jumpUrl;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\r\u0010\u000eJ\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002R\u0017\u0010\u0007\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\f\u00a8\u0006\u000f"}, d2 = {"Laf4/d$a;", "", "", "a", "sec", "b", "Ljava/text/SimpleDateFormat;", "TIME_FORMATTER", "Ljava/text/SimpleDateFormat;", "c", "()Ljava/text/SimpleDateFormat;", "INVALID_TIME_STAMP", "J", "<init>", "()V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: af4.d$a, reason: from kotlin metadata */
    /* loaded from: classes26.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final long a() {
            String format = c().format(new Date(NetConnInfoCenter.getServerTimeMillis()));
            Intrinsics.checkNotNullExpressionValue(format, "TIME_FORMATTER.format(Date(serverTime))");
            return Long.parseLong(format);
        }

        public final long b(long sec) {
            String format = c().format(new Date(sec * 1000));
            Intrinsics.checkNotNullExpressionValue(format, "TIME_FORMATTER.format(Date(sec * 1000))");
            return Long.parseLong(format);
        }

        @NotNull
        public final SimpleDateFormat c() {
            return OperationItem.U;
        }

        Companion() {
        }
    }

    public OperationItem() {
        this(0, 0L, 0, null, null, null, null, null, 0, 0, false, null, null, 0, null, 0L, 0L, 0L, 0, 0L, null, null, 4194303, null);
    }

    /* renamed from: A, reason: from getter */
    public final boolean getIsRedPacket() {
        return this.isRedPacket;
    }

    public final void B(int i3) {
        this.adPosId = i3;
    }

    public final void C(@Nullable BatteryOperationData batteryOperationData) {
        this.batteryData = batteryOperationData;
    }

    public final void D(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.broomid = str;
    }

    public final void E(int i3) {
        this.contentFilter = i3;
    }

    public final void F(long j3) {
        this.dataTimeStamp = j3;
    }

    public final void G(long j3) {
        this.eTimer = j3;
    }

    public final void H(long j3) {
        this.endTime = j3;
    }

    public final void I(int i3) {
        this.iAdId = i3;
    }

    public final void J(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.jumpType = str;
    }

    public final void K(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.jumpUrl = str;
    }

    public final void L(int i3) {
        this.operationType = i3;
    }

    public final void M(@NotNull TimiPicInfo timiPicInfo) {
        Intrinsics.checkNotNullParameter(timiPicInfo, "<set-?>");
        this.pic = timiPicInfo;
    }

    public final void N(int i3) {
        this.priority = i3;
    }

    public final void O(long j3) {
        this.roomId = j3;
    }

    public final void P(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.scene = str;
    }

    public final void Q(int i3) {
        this.sceneId = i3;
    }

    public final void R(long j3) {
        this.startTime = j3;
    }

    public final void S(@Nullable RedPocketOperationData redPocketOperationData) {
        this.timiRedPocketData = redPocketOperationData;
    }

    public final void T(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.traceInfo = str;
    }

    public final void U(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.view = str;
    }

    public final void V(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.wroomid = str;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof OperationItem)) {
            return false;
        }
        OperationItem operationItem = (OperationItem) other;
        if (this.operationType == operationItem.operationType && this.roomId == operationItem.roomId && this.adPosId == operationItem.adPosId && Intrinsics.areEqual(this.pic, operationItem.pic) && Intrinsics.areEqual(this.jumpType, operationItem.jumpType) && Intrinsics.areEqual(this.jumpUrl, operationItem.jumpUrl) && Intrinsics.areEqual(this.view, operationItem.view) && Intrinsics.areEqual(this.scene, operationItem.scene) && this.priority == operationItem.priority && this.iAdId == operationItem.iAdId && this.isRedPacket == operationItem.isRedPacket && Intrinsics.areEqual(this.wroomid, operationItem.wroomid) && Intrinsics.areEqual(this.broomid, operationItem.broomid) && this.contentFilter == operationItem.contentFilter && Intrinsics.areEqual(this.traceInfo, operationItem.traceInfo) && this.eTimer == operationItem.eTimer && this.startTime == operationItem.startTime && this.endTime == operationItem.endTime && this.sceneId == operationItem.sceneId && this.dataTimeStamp == operationItem.dataTimeStamp && Intrinsics.areEqual(this.timiRedPocketData, operationItem.timiRedPocketData) && Intrinsics.areEqual(this.batteryData, operationItem.batteryData)) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode;
        int a16 = ((((((((((((((((((this.operationType * 31) + androidx.fragment.app.a.a(this.roomId)) * 31) + this.adPosId) * 31) + this.pic.hashCode()) * 31) + this.jumpType.hashCode()) * 31) + this.jumpUrl.hashCode()) * 31) + this.view.hashCode()) * 31) + this.scene.hashCode()) * 31) + this.priority) * 31) + this.iAdId) * 31;
        boolean z16 = this.isRedPacket;
        int i3 = z16;
        if (z16 != 0) {
            i3 = 1;
        }
        int hashCode2 = (((((((((((((((((((a16 + i3) * 31) + this.wroomid.hashCode()) * 31) + this.broomid.hashCode()) * 31) + this.contentFilter) * 31) + this.traceInfo.hashCode()) * 31) + androidx.fragment.app.a.a(this.eTimer)) * 31) + androidx.fragment.app.a.a(this.startTime)) * 31) + androidx.fragment.app.a.a(this.endTime)) * 31) + this.sceneId) * 31) + androidx.fragment.app.a.a(this.dataTimeStamp)) * 31;
        RedPocketOperationData redPocketOperationData = this.timiRedPocketData;
        int i16 = 0;
        if (redPocketOperationData == null) {
            hashCode = 0;
        } else {
            hashCode = redPocketOperationData.hashCode();
        }
        int i17 = (hashCode2 + hashCode) * 31;
        BatteryOperationData batteryOperationData = this.batteryData;
        if (batteryOperationData != null) {
            i16 = batteryOperationData.hashCode();
        }
        return i17 + i16;
    }

    @Override // java.lang.Comparable
    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public int compareTo(@NotNull OperationItem other) {
        Intrinsics.checkNotNullParameter(other, "other");
        int i3 = this.priority - other.priority;
        if (i3 > 0) {
            return 1;
        }
        if (i3 < 0) {
            return -1;
        }
        return 0;
    }

    @Nullable
    /* renamed from: j, reason: from getter */
    public final BatteryOperationData getBatteryData() {
        return this.batteryData;
    }

    @NotNull
    /* renamed from: k, reason: from getter */
    public final String getBroomid() {
        return this.broomid;
    }

    /* renamed from: l, reason: from getter */
    public final int getContentFilter() {
        return this.contentFilter;
    }

    /* renamed from: m, reason: from getter */
    public final long getETimer() {
        return this.eTimer;
    }

    /* renamed from: n, reason: from getter */
    public final long getEndTime() {
        return this.endTime;
    }

    /* renamed from: o, reason: from getter */
    public final int getIAdId() {
        return this.iAdId;
    }

    @NotNull
    /* renamed from: p, reason: from getter */
    public final String getJumpType() {
        return this.jumpType;
    }

    @NotNull
    /* renamed from: q, reason: from getter */
    public final String getJumpUrl() {
        return this.jumpUrl;
    }

    /* renamed from: r, reason: from getter */
    public final int getOperationType() {
        return this.operationType;
    }

    @NotNull
    /* renamed from: s, reason: from getter */
    public final TimiPicInfo getPic() {
        return this.pic;
    }

    /* renamed from: t, reason: from getter */
    public final long getRoomId() {
        return this.roomId;
    }

    @NotNull
    public String toString() {
        return "OperationItem(operationType=" + this.operationType + ", roomId=" + this.roomId + ", adPosId=" + this.adPosId + ", pic=" + this.pic + ", jumpType=" + this.jumpType + ", jumpUrl=" + this.jumpUrl + ", view=" + this.view + ", scene=" + this.scene + ", priority=" + this.priority + ", iAdId=" + this.iAdId + ", isRedPacket=" + this.isRedPacket + ", wroomid=" + this.wroomid + ", broomid=" + this.broomid + ", contentFilter=" + this.contentFilter + ", traceInfo=" + this.traceInfo + ", eTimer=" + this.eTimer + ", startTime=" + this.startTime + ", endTime=" + this.endTime + ", sceneId=" + this.sceneId + ", dataTimeStamp=" + this.dataTimeStamp + ", timiRedPocketData=" + this.timiRedPocketData + ", batteryData=" + this.batteryData + ")";
    }

    /* renamed from: u, reason: from getter */
    public final int getSceneId() {
        return this.sceneId;
    }

    /* renamed from: v, reason: from getter */
    public final long getStartTime() {
        return this.startTime;
    }

    @Nullable
    /* renamed from: w, reason: from getter */
    public final RedPocketOperationData getTimiRedPocketData() {
        return this.timiRedPocketData;
    }

    @NotNull
    /* renamed from: x, reason: from getter */
    public final String getTraceInfo() {
        return this.traceInfo;
    }

    @NotNull
    /* renamed from: y, reason: from getter */
    public final String getView() {
        return this.view;
    }

    @NotNull
    /* renamed from: z, reason: from getter */
    public final String getWroomid() {
        return this.wroomid;
    }

    public OperationItem(int i3, long j3, int i16, @NotNull TimiPicInfo pic, @NotNull String jumpType, @NotNull String jumpUrl, @NotNull String view, @NotNull String scene, int i17, int i18, boolean z16, @NotNull String wroomid, @NotNull String broomid, int i19, @NotNull String traceInfo, long j16, long j17, long j18, int i26, long j19, @Nullable RedPocketOperationData redPocketOperationData, @Nullable BatteryOperationData batteryOperationData) {
        Intrinsics.checkNotNullParameter(pic, "pic");
        Intrinsics.checkNotNullParameter(jumpType, "jumpType");
        Intrinsics.checkNotNullParameter(jumpUrl, "jumpUrl");
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(scene, "scene");
        Intrinsics.checkNotNullParameter(wroomid, "wroomid");
        Intrinsics.checkNotNullParameter(broomid, "broomid");
        Intrinsics.checkNotNullParameter(traceInfo, "traceInfo");
        this.operationType = i3;
        this.roomId = j3;
        this.adPosId = i16;
        this.pic = pic;
        this.jumpType = jumpType;
        this.jumpUrl = jumpUrl;
        this.view = view;
        this.scene = scene;
        this.priority = i17;
        this.iAdId = i18;
        this.isRedPacket = z16;
        this.wroomid = wroomid;
        this.broomid = broomid;
        this.contentFilter = i19;
        this.traceInfo = traceInfo;
        this.eTimer = j16;
        this.startTime = j17;
        this.endTime = j18;
        this.sceneId = i26;
        this.dataTimeStamp = j19;
        this.timiRedPocketData = redPocketOperationData;
        this.batteryData = batteryOperationData;
    }

    public /* synthetic */ OperationItem(int i3, long j3, int i16, TimiPicInfo timiPicInfo, String str, String str2, String str3, String str4, int i17, int i18, boolean z16, String str5, String str6, int i19, String str7, long j16, long j17, long j18, int i26, long j19, RedPocketOperationData redPocketOperationData, BatteryOperationData batteryOperationData, int i27, DefaultConstructorMarker defaultConstructorMarker) {
        this((i27 & 1) != 0 ? 1 : i3, (i27 & 2) != 0 ? 0L : j3, (i27 & 4) != 0 ? 0 : i16, (i27 & 8) != 0 ? new TimiPicInfo("", 0, 2, null) : timiPicInfo, (i27 & 16) != 0 ? "" : str, (i27 & 32) != 0 ? "" : str2, (i27 & 64) != 0 ? "" : str3, (i27 & 128) != 0 ? "" : str4, (i27 & 256) != 0 ? 0 : i17, (i27 & 512) != 0 ? 0 : i18, (i27 & 1024) == 0 ? z16 : false, (i27 & 2048) != 0 ? "" : str5, (i27 & 4096) != 0 ? "" : str6, (i27 & 8192) != 0 ? -1 : i19, (i27 & 16384) != 0 ? "" : str7, (i27 & 32768) != 0 ? -1L : j16, (i27 & 65536) != 0 ? -1L : j17, (i27 & 131072) == 0 ? j18 : -1L, (i27 & 262144) != 0 ? 1 : i26, (i27 & 524288) != 0 ? 0L : j19, (i27 & 1048576) != 0 ? null : redPocketOperationData, (i27 & 2097152) != 0 ? null : batteryOperationData);
    }
}
