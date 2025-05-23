package kx3;

import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b&\n\u0002\u0010\t\n\u0002\bV\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0012\n\u0002\b\u000e\b\u0086\b\u0018\u0000 O2\u00020\u0001:\u0001\tB\u00bf\u0003\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u0005\u0012\b\b\u0002\u0010!\u001a\u00020\u0005\u0012\b\b\u0002\u0010%\u001a\u00020\u0005\u0012\n\b\u0002\u0010)\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010-\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u00105\u001a\u00020.\u0012\b\b\u0002\u00109\u001a\u00020.\u0012\b\b\u0002\u0010=\u001a\u00020\u0005\u0012\b\b\u0002\u0010D\u001a\u00020\u0003\u0012\b\b\u0002\u0010G\u001a\u00020\u0005\u0012\b\b\u0002\u0010K\u001a\u00020\u0005\u0012\b\b\u0002\u0010N\u001a\u00020\u0005\u0012\b\b\u0002\u0010P\u001a\u00020\u0005\u0012\b\b\u0002\u0010S\u001a\u00020\u0005\u0012\b\b\u0002\u0010W\u001a\u00020\u0005\u0012\n\b\u0002\u0010Z\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\\\u001a\u00020\u0005\u0012\b\b\u0002\u0010]\u001a\u00020\u0005\u0012\b\b\u0002\u0010`\u001a\u00020\u0005\u0012\b\b\u0002\u0010b\u001a\u00020\u0005\u0012\b\b\u0002\u0010d\u001a\u00020\u0005\u0012\b\b\u0002\u0010g\u001a\u00020.\u0012\b\b\u0002\u0010j\u001a\u00020\u0005\u0012\b\b\u0002\u0010l\u001a\u00020\u0005\u0012\b\b\u0002\u0010p\u001a\u00020.\u0012\b\b\u0002\u0010t\u001a\u00020.\u0012\b\b\u0002\u0010w\u001a\u00020.\u0012\b\b\u0002\u0010z\u001a\u00020\u0005\u0012\b\b\u0002\u0010|\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u007f\u001a\u00020.\u0012\t\b\u0002\u0010\u0081\u0001\u001a\u00020\u0005\u0012\t\b\u0002\u0010\u0084\u0001\u001a\u00020.\u0012\u0018\b\u0002\u0010\u008b\u0001\u001a\u0011\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0085\u0001\u0012\f\b\u0002\u0010\u0092\u0001\u001a\u0005\u0018\u00010\u008c\u0001\u0012\u0018\b\u0002\u0010\u0094\u0001\u001a\u0011\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0085\u0001\u0012\f\b\u0002\u0010\u0097\u0001\u001a\u0005\u0018\u00010\u008c\u0001\u00a2\u0006\u0006\b\u0098\u0001\u0010\u0099\u0001J\u0013\u0010\u0004\u001a\u00020\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0016R\"\u0010\u000f\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\"\u0010\u0013\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\n\u001a\u0004\b\u0011\u0010\f\"\u0004\b\u0012\u0010\u000eR\"\u0010\u0019\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0014\u0010\u0011\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\"\u0010\u001d\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001a\u0010\u0011\u001a\u0004\b\u001b\u0010\u0016\"\u0004\b\u001c\u0010\u0018R\"\u0010!\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001e\u0010\u0011\u001a\u0004\b\u001f\u0010\u0016\"\u0004\b \u0010\u0018R\"\u0010%\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\"\u0010\u0011\u001a\u0004\b#\u0010\u0016\"\u0004\b$\u0010\u0018R$\u0010)\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b&\u0010\n\u001a\u0004\b'\u0010\f\"\u0004\b(\u0010\u000eR$\u0010-\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b*\u0010\n\u001a\u0004\b+\u0010\f\"\u0004\b,\u0010\u000eR\"\u00105\u001a\u00020.8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b/\u00100\u001a\u0004\b1\u00102\"\u0004\b3\u00104R\"\u00109\u001a\u00020.8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b6\u00100\u001a\u0004\b7\u00102\"\u0004\b8\u00104R\"\u0010=\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b:\u0010\u0011\u001a\u0004\b;\u0010\u0016\"\u0004\b<\u0010\u0018R\"\u0010D\u001a\u00020\u00038\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b>\u0010?\u001a\u0004\b@\u0010A\"\u0004\bB\u0010CR\"\u0010G\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bE\u0010\u0011\u001a\u0004\b\u0010\u0010\u0016\"\u0004\bF\u0010\u0018R\"\u0010K\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bH\u0010\u0011\u001a\u0004\bI\u0010\u0016\"\u0004\bJ\u0010\u0018R\"\u0010N\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bL\u0010\u0011\u001a\u0004\b\u0014\u0010\u0016\"\u0004\bM\u0010\u0018R\"\u0010P\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b#\u0010\u0011\u001a\u0004\b\t\u0010\u0016\"\u0004\bO\u0010\u0018R\"\u0010S\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bQ\u0010\u0011\u001a\u0004\b&\u0010\u0016\"\u0004\bR\u0010\u0018R\"\u0010W\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bT\u0010\u0011\u001a\u0004\bU\u0010\u0016\"\u0004\bV\u0010\u0018R$\u0010Z\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b'\u0010\n\u001a\u0004\bX\u0010\f\"\u0004\bY\u0010\u000eR\"\u0010\\\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b;\u0010\u0011\u001a\u0004\b0\u0010\u0016\"\u0004\b[\u0010\u0018R\"\u0010]\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b@\u0010\u0011\u001a\u0004\bH\u0010\u0016\"\u0004\b?\u0010\u0018R\"\u0010`\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b1\u0010\u0011\u001a\u0004\b^\u0010\u0016\"\u0004\b_\u0010\u0018R\"\u0010b\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b7\u0010\u0011\u001a\u0004\bL\u0010\u0016\"\u0004\ba\u0010\u0018R\"\u0010d\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b+\u0010\u0011\u001a\u0004\b\u001a\u0010\u0016\"\u0004\bc\u0010\u0018R\"\u0010g\u001a\u00020.8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b^\u00100\u001a\u0004\be\u00102\"\u0004\bf\u00104R\"\u0010j\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bh\u0010\u0011\u001a\u0004\bh\u0010\u0016\"\u0004\bi\u0010\u0018R\"\u0010l\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\be\u0010\u0011\u001a\u0004\b6\u0010\u0016\"\u0004\bk\u0010\u0018R(\u0010p\u001a\u00020.8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0018\n\u0004\b\u0015\u00100\u0012\u0004\bn\u0010o\u001a\u0004\b:\u00102\"\u0004\bm\u00104R(\u0010t\u001a\u00020.8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0018\n\u0004\b\u001b\u00100\u0012\u0004\bs\u0010o\u001a\u0004\bq\u00102\"\u0004\br\u00104R\"\u0010w\u001a\u00020.8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001f\u00100\u001a\u0004\bu\u00102\"\u0004\bv\u00104R\"\u0010z\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bI\u0010\u0011\u001a\u0004\bx\u0010\u0016\"\u0004\by\u0010\u0018R\"\u0010|\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bq\u0010\u0011\u001a\u0004\bT\u0010\u0016\"\u0004\b{\u0010\u0018R(\u0010\u007f\u001a\u00020.8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0018\n\u0004\bu\u00100\u0012\u0004\b~\u0010o\u001a\u0004\bQ\u00102\"\u0004\b}\u00104R$\u0010\u0081\u0001\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0013\n\u0004\b\u000b\u0010\u0011\u001a\u0004\b>\u0010\u0016\"\u0005\b\u0080\u0001\u0010\u0018R+\u0010\u0084\u0001\u001a\u00020.8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u001a\n\u0004\b\u0011\u00100\u0012\u0005\b\u0083\u0001\u0010o\u001a\u0004\bE\u00102\"\u0005\b\u0082\u0001\u00104R=\u0010\u008b\u0001\u001a\u0011\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0085\u00018\u0006@\u0006X\u0087\u000e\u00a2\u0006\u001d\n\u0005\b0\u0010\u0086\u0001\u0012\u0005\b\u008a\u0001\u0010o\u001a\u0005\b/\u0010\u0087\u0001\"\u0006\b\u0088\u0001\u0010\u0089\u0001R1\u0010\u0092\u0001\u001a\u0005\u0018\u00010\u008c\u00018\u0006@\u0006X\u0087\u000e\u00a2\u0006\u001d\n\u0005\bx\u0010\u008d\u0001\u0012\u0005\b\u0091\u0001\u0010o\u001a\u0005\b*\u0010\u008e\u0001\"\u0006\b\u008f\u0001\u0010\u0090\u0001R6\u0010\u0094\u0001\u001a\u0011\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0085\u00018\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0016\n\u0005\bX\u0010\u0086\u0001\u001a\u0005\b\"\u0010\u0087\u0001\"\u0006\b\u0093\u0001\u0010\u0089\u0001R1\u0010\u0097\u0001\u001a\u0005\u0018\u00010\u008c\u00018\u0006@\u0006X\u0087\u000e\u00a2\u0006\u001d\n\u0005\bU\u0010\u008d\u0001\u0012\u0005\b\u0096\u0001\u0010o\u001a\u0005\b\u001e\u0010\u008e\u0001\"\u0006\b\u0095\u0001\u0010\u0090\u0001\u00a8\u0006\u009a\u0001"}, d2 = {"Lkx3/a;", "", "other", "", "equals", "", "hashCode", "", "toString", "a", "Ljava/lang/String;", "H", "()Ljava/lang/String;", "r0", "(Ljava/lang/String;)V", "uid", "b", "I", "s0", "uin", "c", "B", "()I", "l0", "(I)V", "qqVipInfo", "d", BdhLogUtil.LogTag.Tag_Conn, "m0", "superQqInfo", "e", "D", "n0", "superVipInfo", "f", "p", "setHollywoodVipInfo", "hollywoodVipInfo", "g", ReportConstant.COSTREPORT_PREFIX, "c0", "medalsInfo", h.F, HippyTKDListViewAdapter.X, "h0", "nameplateCfgInfo", "", "i", "J", "v", "()J", "f0", "(J)V", "namePlateOfKingGameId", "j", "w", "g0", "namePlateOfKingLoginTime", "k", "t", "d0", "namePlateOfKingDan", "l", "Z", "u", "()Z", "e0", "(Z)V", "namePlateOfKingDanDisplatSwitch", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "O", "bigClubInfo", DomainData.DOMAIN_NAME, "E", "o0", "superVipTemplateId", "o", "P", "bigClubTemplateId", "N", "bigClubExtTemplateId", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, ExifInterface.LATITUDE_SOUTH, "diyFontId", "r", "M", "w0", "vipStartFlag", "L", "v0", "vipIcons", "t0", "vipDataFlag", "gameCardId", "y", "i0", "nameplateVipType", "a0", "grayNameplateFlag", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "cNewLoverDiamondFlag", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "k0", "pendantId", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "j0", "pendantDiyId", "V", "faceId", "W", "getFaceIdUpdateTime$annotations", "()V", "faceIdUpdateTime", UserInfo.SEX_FEMALE, "p0", "getTimestamp$annotations", "timestamp", "G", "q0", "uVipFont", "K", "u0", "vipFontType", "b0", "magicFont", "setLastUpdateTime", "getLastUpdateTime$annotations", WadlProxyConsts.LAST_UPDATE_TIME, "X", "fontEffect", "Y", "getFontEffectLastUpdateTime$annotations", "fontEffectLastUpdateTime", "Ljava/util/concurrent/ConcurrentHashMap;", "Ljava/util/concurrent/ConcurrentHashMap;", "()Ljava/util/concurrent/ConcurrentHashMap;", "U", "(Ljava/util/concurrent/ConcurrentHashMap;)V", "getDiyFontTimestampMap$annotations", "diyFontTimestampMap", "", "[B", "()[B", "T", "([B)V", "getDiyFontTimestampBytes$annotations", "diyFontTimestampBytes", BdhLogUtil.LogTag.Tag_Req, "diyFontConfigMap", "setDiyFontConfigBytes", "getDiyFontConfigBytes$annotations", "diyFontConfigBytes", "<init>", "(Ljava/lang/String;Ljava/lang/String;IIIILjava/lang/String;Ljava/lang/String;JJIZIIIIIILjava/lang/String;IIIIIJIIJJJIIJIJLjava/util/concurrent/ConcurrentHashMap;[BLjava/util/concurrent/ConcurrentHashMap;[B)V", "contacts_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes22.dex */
public final /* data */ class a {

    /* renamed from: A, reason: from kotlin metadata */
    private int faceId;

    /* renamed from: B, reason: from kotlin metadata */
    private long faceIdUpdateTime;

    /* renamed from: C, reason: from kotlin metadata */
    private long timestamp;

    /* renamed from: D, reason: from kotlin metadata */
    private long uVipFont;

    /* renamed from: E, reason: from kotlin metadata */
    private int vipFontType;

    /* renamed from: F, reason: from kotlin metadata */
    private int magicFont;

    /* renamed from: G, reason: from kotlin metadata */
    private long lastUpdateTime;

    /* renamed from: H, reason: from kotlin metadata */
    private int fontEffect;

    /* renamed from: I, reason: from kotlin metadata */
    private long fontEffectLastUpdateTime;

    /* renamed from: J, reason: from kotlin metadata */
    @Nullable
    private ConcurrentHashMap<Integer, Integer> diyFontTimestampMap;

    /* renamed from: K, reason: from kotlin metadata */
    @Nullable
    private byte[] diyFontTimestampBytes;

    /* renamed from: L, reason: from kotlin metadata */
    @Nullable
    private ConcurrentHashMap<Integer, String> diyFontConfigMap;

    /* renamed from: M, reason: from kotlin metadata */
    @Nullable
    private byte[] diyFontConfigBytes;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String uid;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String uin;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private int qqVipInfo;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private int superQqInfo;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private int superVipInfo;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private int hollywoodVipInfo;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String medalsInfo;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String nameplateCfgInfo;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private long namePlateOfKingGameId;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    private long namePlateOfKingLoginTime;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    private int namePlateOfKingDan;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    private boolean namePlateOfKingDanDisplatSwitch;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private int bigClubInfo;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    private int superVipTemplateId;

    /* renamed from: o, reason: collision with root package name and from kotlin metadata */
    private int bigClubTemplateId;

    /* renamed from: p, reason: collision with root package name and from kotlin metadata */
    private int bigClubExtTemplateId;

    /* renamed from: q, reason: collision with root package name and from kotlin metadata */
    private int diyFontId;

    /* renamed from: r, reason: collision with root package name and from kotlin metadata */
    private int vipStartFlag;

    /* renamed from: s, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String vipIcons;

    /* renamed from: t, reason: collision with root package name and from kotlin metadata */
    private int vipDataFlag;

    /* renamed from: u, reason: collision with root package name and from kotlin metadata */
    private int gameCardId;

    /* renamed from: v, reason: collision with root package name and from kotlin metadata */
    private int nameplateVipType;

    /* renamed from: w, reason: collision with root package name and from kotlin metadata */
    private int grayNameplateFlag;

    /* renamed from: x, reason: collision with root package name and from kotlin metadata */
    private int cNewLoverDiamondFlag;

    /* renamed from: y, reason: collision with root package name and from kotlin metadata */
    private long pendantId;

    /* renamed from: z, reason: collision with root package name and from kotlin metadata */
    private int pendantDiyId;

    public a() {
        this(null, null, 0, 0, 0, 0, null, null, 0L, 0L, 0, false, 0, 0, 0, 0, 0, 0, null, 0, 0, 0, 0, 0, 0L, 0, 0, 0L, 0L, 0L, 0, 0, 0L, 0, 0L, null, null, null, null, -1, 127, null);
    }

    /* renamed from: A, reason: from getter */
    public final long getPendantId() {
        return this.pendantId;
    }

    /* renamed from: B, reason: from getter */
    public final int getQqVipInfo() {
        return this.qqVipInfo;
    }

    /* renamed from: C, reason: from getter */
    public final int getSuperQqInfo() {
        return this.superQqInfo;
    }

    /* renamed from: D, reason: from getter */
    public final int getSuperVipInfo() {
        return this.superVipInfo;
    }

    /* renamed from: E, reason: from getter */
    public final int getSuperVipTemplateId() {
        return this.superVipTemplateId;
    }

    /* renamed from: F, reason: from getter */
    public final long getTimestamp() {
        return this.timestamp;
    }

    /* renamed from: G, reason: from getter */
    public final long getUVipFont() {
        return this.uVipFont;
    }

    @NotNull
    /* renamed from: H, reason: from getter */
    public final String getUid() {
        return this.uid;
    }

    @NotNull
    /* renamed from: I, reason: from getter */
    public final String getUin() {
        return this.uin;
    }

    /* renamed from: J, reason: from getter */
    public final int getVipDataFlag() {
        return this.vipDataFlag;
    }

    /* renamed from: K, reason: from getter */
    public final int getVipFontType() {
        return this.vipFontType;
    }

    @Nullable
    /* renamed from: L, reason: from getter */
    public final String getVipIcons() {
        return this.vipIcons;
    }

    /* renamed from: M, reason: from getter */
    public final int getVipStartFlag() {
        return this.vipStartFlag;
    }

    public final void N(int i3) {
        this.bigClubExtTemplateId = i3;
    }

    public final void O(int i3) {
        this.bigClubInfo = i3;
    }

    public final void P(int i3) {
        this.bigClubTemplateId = i3;
    }

    public final void Q(int i3) {
        this.cNewLoverDiamondFlag = i3;
    }

    public final void R(@Nullable ConcurrentHashMap<Integer, String> concurrentHashMap) {
        this.diyFontConfigMap = concurrentHashMap;
    }

    public final void S(int i3) {
        this.diyFontId = i3;
    }

    public final void T(@Nullable byte[] bArr) {
        this.diyFontTimestampBytes = bArr;
    }

    public final void U(@Nullable ConcurrentHashMap<Integer, Integer> concurrentHashMap) {
        this.diyFontTimestampMap = concurrentHashMap;
    }

    public final void V(int i3) {
        this.faceId = i3;
    }

    public final void W(long j3) {
        this.faceIdUpdateTime = j3;
    }

    public final void X(int i3) {
        this.fontEffect = i3;
    }

    public final void Y(long j3) {
        this.fontEffectLastUpdateTime = j3;
    }

    public final void Z(int i3) {
        this.gameCardId = i3;
    }

    /* renamed from: a, reason: from getter */
    public final int getBigClubExtTemplateId() {
        return this.bigClubExtTemplateId;
    }

    public final void a0(int i3) {
        this.grayNameplateFlag = i3;
    }

    /* renamed from: b, reason: from getter */
    public final int getBigClubInfo() {
        return this.bigClubInfo;
    }

    public final void b0(int i3) {
        this.magicFont = i3;
    }

    /* renamed from: c, reason: from getter */
    public final int getBigClubTemplateId() {
        return this.bigClubTemplateId;
    }

    public final void c0(@Nullable String str) {
        this.medalsInfo = str;
    }

    /* renamed from: d, reason: from getter */
    public final int getCNewLoverDiamondFlag() {
        return this.cNewLoverDiamondFlag;
    }

    public final void d0(int i3) {
        this.namePlateOfKingDan = i3;
    }

    @Nullable
    /* renamed from: e, reason: from getter */
    public final byte[] getDiyFontConfigBytes() {
        return this.diyFontConfigBytes;
    }

    public final void e0(boolean z16) {
        this.namePlateOfKingDanDisplatSwitch = z16;
    }

    public boolean equals(@Nullable Object other) {
        Class<?> cls;
        boolean z16;
        if (this == other) {
            return true;
        }
        Boolean bool = null;
        if (other != null) {
            cls = other.getClass();
        } else {
            cls = null;
        }
        if (!Intrinsics.areEqual(a.class, cls)) {
            return false;
        }
        Intrinsics.checkNotNull(other, "null cannot be cast to non-null type com.tencent.qqnt.ntrelation.vasinfo.bean.NTVasDetailInfo");
        a aVar = (a) other;
        if (!Intrinsics.areEqual(this.uid, aVar.uid) || !Intrinsics.areEqual(this.uin, aVar.uin) || this.qqVipInfo != aVar.qqVipInfo || this.superQqInfo != aVar.superQqInfo || this.superVipInfo != aVar.superVipInfo || this.hollywoodVipInfo != aVar.hollywoodVipInfo || !Intrinsics.areEqual(this.medalsInfo, aVar.medalsInfo) || !Intrinsics.areEqual(this.nameplateCfgInfo, aVar.nameplateCfgInfo) || this.namePlateOfKingGameId != aVar.namePlateOfKingGameId || this.namePlateOfKingLoginTime != aVar.namePlateOfKingLoginTime || this.namePlateOfKingDan != aVar.namePlateOfKingDan || this.namePlateOfKingDanDisplatSwitch != aVar.namePlateOfKingDanDisplatSwitch || this.bigClubInfo != aVar.bigClubInfo || this.superVipTemplateId != aVar.superVipTemplateId || this.bigClubTemplateId != aVar.bigClubTemplateId || this.bigClubExtTemplateId != aVar.bigClubExtTemplateId || this.diyFontId != aVar.diyFontId || this.vipStartFlag != aVar.vipStartFlag || !Intrinsics.areEqual(this.vipIcons, aVar.vipIcons) || this.vipDataFlag != aVar.vipDataFlag || this.gameCardId != aVar.gameCardId || this.nameplateVipType != aVar.nameplateVipType || this.grayNameplateFlag != aVar.grayNameplateFlag || this.cNewLoverDiamondFlag != aVar.cNewLoverDiamondFlag || this.pendantId != aVar.pendantId || this.pendantDiyId != aVar.pendantDiyId || this.faceId != aVar.faceId || this.faceIdUpdateTime != aVar.faceIdUpdateTime || this.timestamp != aVar.timestamp || this.uVipFont != aVar.uVipFont || this.vipFontType != aVar.vipFontType || this.magicFont != aVar.magicFont || this.lastUpdateTime != aVar.lastUpdateTime || this.fontEffect != aVar.fontEffect || this.fontEffectLastUpdateTime != aVar.fontEffectLastUpdateTime || !Intrinsics.areEqual(this.diyFontTimestampMap, aVar.diyFontTimestampMap)) {
            return false;
        }
        byte[] bArr = aVar.diyFontTimestampBytes;
        if (bArr != null) {
            byte[] bArr2 = this.diyFontTimestampBytes;
            if (bArr2 != null) {
                bool = Boolean.valueOf(Arrays.equals(bArr2, bArr));
            }
            z16 = Intrinsics.areEqual(bool, Boolean.FALSE);
        } else {
            z16 = false;
        }
        if (!z16 && Intrinsics.areEqual(this.diyFontConfigMap, aVar.diyFontConfigMap) && Intrinsics.areEqual(this.diyFontConfigBytes, aVar.diyFontConfigBytes)) {
            return true;
        }
        return false;
    }

    @Nullable
    public final ConcurrentHashMap<Integer, String> f() {
        return this.diyFontConfigMap;
    }

    public final void f0(long j3) {
        this.namePlateOfKingGameId = j3;
    }

    /* renamed from: g, reason: from getter */
    public final int getDiyFontId() {
        return this.diyFontId;
    }

    public final void g0(long j3) {
        this.namePlateOfKingLoginTime = j3;
    }

    @Nullable
    /* renamed from: h, reason: from getter */
    public final byte[] getDiyFontTimestampBytes() {
        return this.diyFontTimestampBytes;
    }

    public final void h0(@Nullable String str) {
        this.nameplateCfgInfo = str;
    }

    public int hashCode() {
        int i3;
        int i16;
        int i17;
        int i18;
        int i19;
        int i26;
        int hashCode = ((((((((((this.uid.hashCode() * 31) + this.uin.hashCode()) * 31) + this.qqVipInfo) * 31) + this.superQqInfo) * 31) + this.superVipInfo) * 31) + this.hollywoodVipInfo) * 31;
        String str = this.medalsInfo;
        int i27 = 0;
        if (str != null) {
            i3 = str.hashCode();
        } else {
            i3 = 0;
        }
        int i28 = (hashCode + i3) * 31;
        String str2 = this.nameplateCfgInfo;
        if (str2 != null) {
            i16 = str2.hashCode();
        } else {
            i16 = 0;
        }
        int a16 = (((((((((((((((((((((i28 + i16) * 31) + androidx.fragment.app.a.a(this.namePlateOfKingGameId)) * 31) + androidx.fragment.app.a.a(this.namePlateOfKingLoginTime)) * 31) + this.namePlateOfKingDan) * 31) + com.tencent.aio.widget.textView.param.a.a(this.namePlateOfKingDanDisplatSwitch)) * 31) + this.bigClubInfo) * 31) + this.superVipTemplateId) * 31) + this.bigClubTemplateId) * 31) + this.bigClubExtTemplateId) * 31) + this.diyFontId) * 31) + this.vipStartFlag) * 31;
        String str3 = this.vipIcons;
        if (str3 != null) {
            i17 = str3.hashCode();
        } else {
            i17 = 0;
        }
        int a17 = (((((((((((((((((((((((((((((((((a16 + i17) * 31) + this.vipDataFlag) * 31) + this.gameCardId) * 31) + this.nameplateVipType) * 31) + this.grayNameplateFlag) * 31) + this.cNewLoverDiamondFlag) * 31) + androidx.fragment.app.a.a(this.pendantId)) * 31) + this.pendantDiyId) * 31) + this.faceId) * 31) + androidx.fragment.app.a.a(this.faceIdUpdateTime)) * 31) + androidx.fragment.app.a.a(this.timestamp)) * 31) + androidx.fragment.app.a.a(this.uVipFont)) * 31) + this.vipFontType) * 31) + this.magicFont) * 31) + androidx.fragment.app.a.a(this.lastUpdateTime)) * 31) + this.fontEffect) * 31) + androidx.fragment.app.a.a(this.fontEffectLastUpdateTime)) * 31;
        ConcurrentHashMap<Integer, Integer> concurrentHashMap = this.diyFontTimestampMap;
        if (concurrentHashMap != null) {
            i18 = concurrentHashMap.hashCode();
        } else {
            i18 = 0;
        }
        int i29 = (a17 + i18) * 31;
        byte[] bArr = this.diyFontTimestampBytes;
        if (bArr != null) {
            i19 = Arrays.hashCode(bArr);
        } else {
            i19 = 0;
        }
        int i36 = (i29 + i19) * 31;
        ConcurrentHashMap<Integer, String> concurrentHashMap2 = this.diyFontConfigMap;
        if (concurrentHashMap2 != null) {
            i26 = concurrentHashMap2.hashCode();
        } else {
            i26 = 0;
        }
        int i37 = (i36 + i26) * 31;
        byte[] bArr2 = this.diyFontConfigBytes;
        if (bArr2 != null) {
            i27 = bArr2.hashCode();
        }
        return i37 + i27;
    }

    @Nullable
    public final ConcurrentHashMap<Integer, Integer> i() {
        return this.diyFontTimestampMap;
    }

    public final void i0(int i3) {
        this.nameplateVipType = i3;
    }

    /* renamed from: j, reason: from getter */
    public final int getFaceId() {
        return this.faceId;
    }

    public final void j0(int i3) {
        this.pendantDiyId = i3;
    }

    /* renamed from: k, reason: from getter */
    public final long getFaceIdUpdateTime() {
        return this.faceIdUpdateTime;
    }

    public final void k0(long j3) {
        this.pendantId = j3;
    }

    /* renamed from: l, reason: from getter */
    public final int getFontEffect() {
        return this.fontEffect;
    }

    public final void l0(int i3) {
        this.qqVipInfo = i3;
    }

    /* renamed from: m, reason: from getter */
    public final long getFontEffectLastUpdateTime() {
        return this.fontEffectLastUpdateTime;
    }

    public final void m0(int i3) {
        this.superQqInfo = i3;
    }

    /* renamed from: n, reason: from getter */
    public final int getGameCardId() {
        return this.gameCardId;
    }

    public final void n0(int i3) {
        this.superVipInfo = i3;
    }

    /* renamed from: o, reason: from getter */
    public final int getGrayNameplateFlag() {
        return this.grayNameplateFlag;
    }

    public final void o0(int i3) {
        this.superVipTemplateId = i3;
    }

    /* renamed from: p, reason: from getter */
    public final int getHollywoodVipInfo() {
        return this.hollywoodVipInfo;
    }

    public final void p0(long j3) {
        this.timestamp = j3;
    }

    /* renamed from: q, reason: from getter */
    public final long getLastUpdateTime() {
        return this.lastUpdateTime;
    }

    public final void q0(long j3) {
        this.uVipFont = j3;
    }

    /* renamed from: r, reason: from getter */
    public final int getMagicFont() {
        return this.magicFont;
    }

    public final void r0(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.uid = str;
    }

    @Nullable
    /* renamed from: s, reason: from getter */
    public final String getMedalsInfo() {
        return this.medalsInfo;
    }

    public final void s0(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.uin = str;
    }

    /* renamed from: t, reason: from getter */
    public final int getNamePlateOfKingDan() {
        return this.namePlateOfKingDan;
    }

    public final void t0(int i3) {
        this.vipDataFlag = i3;
    }

    @NotNull
    public String toString() {
        String str = "NTVasDetailInfo uin " + this.uin + " uid " + this.uid;
        Field[] allFields = a.class.getDeclaredFields();
        Intrinsics.checkNotNullExpressionValue(allFields, "allFields");
        for (Field field : allFields) {
            try {
                str = str + " " + field.getName() + MsgSummary.STR_COLON + field.get(this);
            } catch (IllegalAccessException e16) {
                e16.printStackTrace();
            } catch (IllegalArgumentException e17) {
                e17.printStackTrace();
            }
        }
        return str;
    }

    /* renamed from: u, reason: from getter */
    public final boolean getNamePlateOfKingDanDisplatSwitch() {
        return this.namePlateOfKingDanDisplatSwitch;
    }

    public final void u0(int i3) {
        this.vipFontType = i3;
    }

    /* renamed from: v, reason: from getter */
    public final long getNamePlateOfKingGameId() {
        return this.namePlateOfKingGameId;
    }

    public final void v0(@Nullable String str) {
        this.vipIcons = str;
    }

    /* renamed from: w, reason: from getter */
    public final long getNamePlateOfKingLoginTime() {
        return this.namePlateOfKingLoginTime;
    }

    public final void w0(int i3) {
        this.vipStartFlag = i3;
    }

    @Nullable
    /* renamed from: x, reason: from getter */
    public final String getNameplateCfgInfo() {
        return this.nameplateCfgInfo;
    }

    /* renamed from: y, reason: from getter */
    public final int getNameplateVipType() {
        return this.nameplateVipType;
    }

    /* renamed from: z, reason: from getter */
    public final int getPendantDiyId() {
        return this.pendantDiyId;
    }

    public a(@NotNull String uid, @NotNull String uin, int i3, int i16, int i17, int i18, @Nullable String str, @Nullable String str2, long j3, long j16, int i19, boolean z16, int i26, int i27, int i28, int i29, int i36, int i37, @Nullable String str3, int i38, int i39, int i46, int i47, int i48, long j17, int i49, int i56, long j18, long j19, long j26, int i57, int i58, long j27, int i59, long j28, @Nullable ConcurrentHashMap<Integer, Integer> concurrentHashMap, @Nullable byte[] bArr, @Nullable ConcurrentHashMap<Integer, String> concurrentHashMap2, @Nullable byte[] bArr2) {
        Intrinsics.checkNotNullParameter(uid, "uid");
        Intrinsics.checkNotNullParameter(uin, "uin");
        this.uid = uid;
        this.uin = uin;
        this.qqVipInfo = i3;
        this.superQqInfo = i16;
        this.superVipInfo = i17;
        this.hollywoodVipInfo = i18;
        this.medalsInfo = str;
        this.nameplateCfgInfo = str2;
        this.namePlateOfKingGameId = j3;
        this.namePlateOfKingLoginTime = j16;
        this.namePlateOfKingDan = i19;
        this.namePlateOfKingDanDisplatSwitch = z16;
        this.bigClubInfo = i26;
        this.superVipTemplateId = i27;
        this.bigClubTemplateId = i28;
        this.bigClubExtTemplateId = i29;
        this.diyFontId = i36;
        this.vipStartFlag = i37;
        this.vipIcons = str3;
        this.vipDataFlag = i38;
        this.gameCardId = i39;
        this.nameplateVipType = i46;
        this.grayNameplateFlag = i47;
        this.cNewLoverDiamondFlag = i48;
        this.pendantId = j17;
        this.pendantDiyId = i49;
        this.faceId = i56;
        this.faceIdUpdateTime = j18;
        this.timestamp = j19;
        this.uVipFont = j26;
        this.vipFontType = i57;
        this.magicFont = i58;
        this.lastUpdateTime = j27;
        this.fontEffect = i59;
        this.fontEffectLastUpdateTime = j28;
        this.diyFontTimestampMap = concurrentHashMap;
        this.diyFontTimestampBytes = bArr;
        this.diyFontConfigMap = concurrentHashMap2;
        this.diyFontConfigBytes = bArr2;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ a(String str, String str2, int i3, int i16, int i17, int i18, String str3, String str4, long j3, long j16, int i19, boolean z16, int i26, int i27, int i28, int i29, int i36, int i37, String str5, int i38, int i39, int i46, int i47, int i48, long j17, int i49, int i56, long j18, long j19, long j26, int i57, int i58, long j27, int i59, long j28, ConcurrentHashMap concurrentHashMap, byte[] bArr, ConcurrentHashMap concurrentHashMap2, byte[] bArr2, int i65, int i66, DefaultConstructorMarker defaultConstructorMarker) {
        this(r1, r3, r4, r6, r7, r8, r9, r10, r14, r16, r11, r12, r13, r5, r44, r19, r20, r21, r18, r22, r23, r24, r25, r26, r27, r29, r30, r31, r33, r35, r37, r95, r38, r40, r41, r43, r2, (i66 & 32) != 0 ? new ConcurrentHashMap() : concurrentHashMap2, (i66 & 64) != 0 ? new byte[]{0} : bArr2);
        int i67;
        byte[] bArr3;
        String str6 = (i65 & 1) != 0 ? "" : str;
        String str7 = (i65 & 2) != 0 ? "" : str2;
        int i68 = (i65 & 4) != 0 ? 0 : i3;
        int i69 = (i65 & 8) != 0 ? 0 : i16;
        int i75 = (i65 & 16) != 0 ? 0 : i17;
        int i76 = (i65 & 32) != 0 ? 0 : i18;
        String str8 = (i65 & 64) != 0 ? "" : str3;
        String str9 = (i65 & 128) != 0 ? "" : str4;
        long j29 = (i65 & 256) != 0 ? 0L : j3;
        long j36 = (i65 & 512) != 0 ? 0L : j16;
        int i77 = (i65 & 1024) != 0 ? 0 : i19;
        boolean z17 = (i65 & 2048) != 0 ? false : z16;
        int i78 = (i65 & 4096) != 0 ? 0 : i26;
        int i79 = (i65 & 8192) != 0 ? 0 : i27;
        int i85 = (i65 & 16384) != 0 ? 0 : i28;
        int i86 = (i65 & 32768) != 0 ? 0 : i29;
        int i87 = (i65 & 65536) != 0 ? 0 : i36;
        int i88 = (i65 & 131072) != 0 ? 0 : i37;
        String str10 = (i65 & 262144) == 0 ? str5 : "";
        int i89 = (i65 & 524288) != 0 ? 0 : i38;
        int i95 = (i65 & 1048576) != 0 ? 0 : i39;
        int i96 = (i65 & 2097152) != 0 ? 0 : i46;
        int i97 = (i65 & 4194304) != 0 ? 0 : i47;
        int i98 = (i65 & 8388608) != 0 ? 0 : i48;
        long j37 = (i65 & 16777216) != 0 ? 0L : j17;
        int i99 = (i65 & 33554432) != 0 ? 0 : i49;
        int i100 = (i65 & 67108864) != 0 ? 0 : i56;
        long j38 = (i65 & 134217728) != 0 ? 0L : j18;
        long j39 = (i65 & 268435456) != 0 ? 0L : j19;
        long j46 = (i65 & 536870912) != 0 ? 0L : j26;
        int i101 = (i65 & 1073741824) != 0 ? 0 : i57;
        int i102 = (i65 & Integer.MIN_VALUE) != 0 ? 0 : i58;
        long j47 = (i66 & 1) != 0 ? 0L : j27;
        int i103 = (i66 & 2) != 0 ? 0 : i59;
        long j48 = (i66 & 4) != 0 ? 0L : j28;
        ConcurrentHashMap concurrentHashMap3 = (i66 & 8) != 0 ? new ConcurrentHashMap() : concurrentHashMap;
        int i104 = i102;
        if ((i66 & 16) != 0) {
            i67 = i85;
            bArr3 = new byte[]{0};
        } else {
            i67 = i85;
            bArr3 = bArr;
        }
    }
}
