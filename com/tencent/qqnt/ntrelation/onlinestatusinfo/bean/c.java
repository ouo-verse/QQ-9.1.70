package com.tencent.qqnt.ntrelation.onlinestatusinfo.bean;

import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.gdtad.jsbridge.GdtGetUserInfoHandler;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.onlinestatus.api.IOnlineStatusService;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000)\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010\u0005\n\u0003\b\u0090\u0001\b\u0016\u0018\u00002\u00020\u0001B\u001d\u0012\b\b\u0002\u0010\n\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0002\u00a2\u0006\u0006\b\u00b4\u0001\u0010\u00b5\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016R\"\u0010\n\u001a\u00020\u00028\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\"\u0010\u000e\u001a\u00020\u00028\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\u0005\u001a\u0004\b\f\u0010\u0007\"\u0004\b\r\u0010\tR\"\u0010\u0016\u001a\u00020\u000f8\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\"\u0010\u001e\u001a\u00020\u00178\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\"\u0010!\u001a\u00020\u00178\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\b\u001f\u0010\u0019\u001a\u0004\b\u0018\u0010\u001b\"\u0004\b \u0010\u001dR\"\u0010%\u001a\u00020\u000f8\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\b\"\u0010\u0011\u001a\u0004\b#\u0010\u0013\"\u0004\b$\u0010\u0015R\"\u0010-\u001a\u00020&8\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\"\u00101\u001a\u00020\u00178\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\b.\u0010\u0019\u001a\u0004\b/\u0010\u001b\"\u0004\b0\u0010\u001dR\"\u00104\u001a\u00020\u00178\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\b2\u0010\u0019\u001a\u0004\b\"\u0010\u001b\"\u0004\b3\u0010\u001dR$\u00107\u001a\u0004\u0018\u00010\u00028\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\b\u0019\u0010\u0005\u001a\u0004\b5\u0010\u0007\"\u0004\b6\u0010\tR$\u0010:\u001a\u0004\u0018\u00010\u00028\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\u0005\u001a\u0004\b8\u0010\u0007\"\u0004\b9\u0010\tR$\u0010=\u001a\u0004\u0018\u00010\u00028\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\b;\u0010\u0005\u001a\u0004\b.\u0010\u0007\"\u0004\b<\u0010\tR\"\u0010A\u001a\u00020\u000f8\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\b>\u0010\u0011\u001a\u0004\b?\u0010\u0013\"\u0004\b@\u0010\u0015R\"\u0010E\u001a\u00020\u00178\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\bB\u0010\u0019\u001a\u0004\bC\u0010\u001b\"\u0004\bD\u0010\u001dR\"\u0010H\u001a\u00020\u00178\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\b?\u0010\u0019\u001a\u0004\bF\u0010\u001b\"\u0004\bG\u0010\u001dR\"\u0010K\u001a\u00020\u00178\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\bI\u0010\u0019\u001a\u0004\bB\u0010\u001b\"\u0004\bJ\u0010\u001dR$\u0010O\u001a\u0004\u0018\u00010\u00028\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\bL\u0010\u0005\u001a\u0004\bM\u0010\u0007\"\u0004\bN\u0010\tR$\u0010S\u001a\u0004\u0018\u00010\u00028\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\bP\u0010\u0005\u001a\u0004\bQ\u0010\u0007\"\u0004\bR\u0010\tR$\u0010W\u001a\u0004\u0018\u00010\u00028\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\bT\u0010\u0005\u001a\u0004\bU\u0010\u0007\"\u0004\bV\u0010\tR$\u0010[\u001a\u0004\u0018\u00010\u00028\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\bX\u0010\u0005\u001a\u0004\bY\u0010\u0007\"\u0004\bZ\u0010\tR$\u0010_\u001a\u0004\u0018\u00010\u00028\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\b\\\u0010\u0005\u001a\u0004\b]\u0010\u0007\"\u0004\b^\u0010\tR\"\u0010b\u001a\u00020\u000f8\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\b5\u0010\u0011\u001a\u0004\b`\u0010\u0013\"\u0004\ba\u0010\u0015R$\u0010f\u001a\u0004\u0018\u00010\u00028\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\bc\u0010\u0005\u001a\u0004\bd\u0010\u0007\"\u0004\be\u0010\tR$\u0010j\u001a\u0004\u0018\u00010\u00028\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\bg\u0010\u0005\u001a\u0004\bh\u0010\u0007\"\u0004\bi\u0010\tR\"\u0010n\u001a\u00020\u00178\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\bk\u0010\u0019\u001a\u0004\bl\u0010\u001b\"\u0004\bm\u0010\u001dR$\u0010q\u001a\u0004\u0018\u00010\u00028\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\b8\u0010\u0005\u001a\u0004\bo\u0010\u0007\"\u0004\bp\u0010\tR$\u0010t\u001a\u0004\u0018\u00010\u00028\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\bF\u0010\u0005\u001a\u0004\br\u0010\u0007\"\u0004\bs\u0010\tR$\u0010w\u001a\u0004\u0018\u00010\u00028\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\bC\u0010\u0005\u001a\u0004\bu\u0010\u0007\"\u0004\bv\u0010\tR$\u0010{\u001a\u0004\u0018\u00010\u00028\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\bx\u0010\u0005\u001a\u0004\by\u0010\u0007\"\u0004\bz\u0010\tR$\u0010~\u001a\u0004\u0018\u00010\u00028\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\bM\u0010\u0005\u001a\u0004\b|\u0010\u0007\"\u0004\b}\u0010\tR&\u0010\u0081\u0001\u001a\u0004\u0018\u00010\u00028\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0013\n\u0004\b#\u0010\u0005\u001a\u0004\b\u007f\u0010\u0007\"\u0005\b\u0080\u0001\u0010\tR'\u0010\u0084\u0001\u001a\u0004\u0018\u00010\u00028\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0014\n\u0004\b\f\u0010\u0005\u001a\u0005\b\u0082\u0001\u0010\u0007\"\u0005\b\u0083\u0001\u0010\tR'\u0010\u0087\u0001\u001a\u0004\u0018\u00010\u00028\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0014\n\u0005\b\u0085\u0001\u0010\u0005\u001a\u0004\b\u0010\u0010\u0007\"\u0005\b\u0086\u0001\u0010\tR(\u0010\u008b\u0001\u001a\u0004\u0018\u00010\u00028\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0015\n\u0005\b\u0088\u0001\u0010\u0005\u001a\u0005\b\u0089\u0001\u0010\u0007\"\u0005\b\u008a\u0001\u0010\tR(\u0010\u008f\u0001\u001a\u0004\u0018\u00010\u00028\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0015\n\u0005\b\u008c\u0001\u0010\u0005\u001a\u0005\b\u008d\u0001\u0010\u0007\"\u0005\b\u008e\u0001\u0010\tR'\u0010\u0092\u0001\u001a\u0004\u0018\u00010\u00028\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0014\n\u0004\bh\u0010\u0005\u001a\u0005\b\u0090\u0001\u0010\u0007\"\u0005\b\u0091\u0001\u0010\tR%\u0010\u0095\u0001\u001a\u00020\u00178\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0014\n\u0004\bl\u0010\u0019\u001a\u0005\b\u0093\u0001\u0010\u001b\"\u0005\b\u0094\u0001\u0010\u001dR%\u0010\u0098\u0001\u001a\u00020\u000f8\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0014\n\u0004\br\u0010\u0011\u001a\u0005\b\u0096\u0001\u0010\u0013\"\u0005\b\u0097\u0001\u0010\u0015R'\u0010\u009b\u0001\u001a\u0004\u0018\u00010\u00028\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0014\n\u0004\bu\u0010\u0005\u001a\u0005\b\u0099\u0001\u0010\u0007\"\u0005\b\u009a\u0001\u0010\tR'\u0010\u009d\u0001\u001a\u0004\u0018\u00010\u00028\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0014\n\u0004\bY\u0010\u0005\u001a\u0005\b\u0085\u0001\u0010\u0007\"\u0005\b\u009c\u0001\u0010\tR'\u0010\u009f\u0001\u001a\u0004\u0018\u00010\u00028\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0014\n\u0004\bQ\u0010\u0005\u001a\u0005\b\u0088\u0001\u0010\u0007\"\u0005\b\u009e\u0001\u0010\tR'\u0010\u00a1\u0001\u001a\u0004\u0018\u00010\u00028\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0014\n\u0004\bU\u0010\u0005\u001a\u0005\b\u008c\u0001\u0010\u0007\"\u0005\b\u00a0\u0001\u0010\tR%\u0010\u00a4\u0001\u001a\u00020\u000f8\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0014\n\u0004\b`\u0010\u0011\u001a\u0005\b\u00a2\u0001\u0010\u0013\"\u0005\b\u00a3\u0001\u0010\u0015R$\u0010\u00a6\u0001\u001a\u00020\u000f8\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0013\n\u0004\b\u0014\u0010\u0011\u001a\u0004\b(\u0010\u0013\"\u0005\b\u00a5\u0001\u0010\u0015R%\u0010\u00a9\u0001\u001a\u00020\u000f8\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0014\n\u0004\b^\u0010\u0011\u001a\u0005\b\u00a7\u0001\u0010\u0013\"\u0005\b\u00a8\u0001\u0010\u0015R$\u0010\u00ab\u0001\u001a\u00020\u000f8\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0013\n\u0004\bp\u0010\u0011\u001a\u0004\b'\u0010\u0013\"\u0005\b\u00aa\u0001\u0010\u0015R&\u0010\u00ad\u0001\u001a\u0004\u0018\u00010\u00028\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0013\n\u0004\be\u0010\u0005\u001a\u0004\bx\u0010\u0007\"\u0005\b\u00ac\u0001\u0010\tR(\u0010\u00b0\u0001\u001a\u0004\u0018\u00010\u00028\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0015\n\u0005\b\u0080\u0001\u0010\u0005\u001a\u0005\b\u00ae\u0001\u0010\u0007\"\u0005\b\u00af\u0001\u0010\tR&\u0010\u00b3\u0001\u001a\u00020\u00178\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0015\n\u0005\b\u008a\u0001\u0010\u0019\u001a\u0005\b\u00b1\u0001\u0010\u001b\"\u0005\b\u00b2\u0001\u0010\u001d\u00a8\u0006\u00b6\u0001"}, d2 = {"Lcom/tencent/qqnt/ntrelation/onlinestatusinfo/bean/c;", "Lcom/tencent/qqnt/ntrelation/baseinfo/bean/a;", "", "toString", h.F, "Ljava/lang/String;", "a", "()Ljava/lang/String;", "b1", "(Ljava/lang/String;)V", "uid", "i", "f0", "c1", "uin", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "J", "b", "()J", "r0", "(J)V", "abilityBits", "", BdhLogUtil.LogTag.Tag_Conn, "I", "y", "()I", "K0", "(I)V", "iBatteryStatus", "D", "O0", "netTypeIconId", "E", "e0", ICustomDataEditor.STRING_ARRAY_PARAM_1, "uExtOnlineStatus", "", UserInfo.SEX_FEMALE, "B", "u", "()B", "G0", "(B)V", "detalStatusFlag", "G", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "L0", "iTermType", "H", "P0", "netWork", "V", "U0", IOnlineStatusService.SONG_ID, "Z", "V0", "songName", "K", "R0", "singerName", "L", "N", "T0", "songEndTime", "M", "b0", "X0", "songSourceType", "a0", "W0", "songPauseRemainTime", "P", "S0", "songDuration", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "d0", "Z0", "temper", BdhLogUtil.LogTag.Tag_Req, "o0", "l1", "weatherType", ExifInterface.LATITUDE_SOUTH, "p0", "m1", "weatherTypeId", "T", "n0", "k1", "weatherTip", "U", "c", "s0", "adCode", "q0", ICustomDataEditor.NUMBER_PARAM_1, "weatherUpdateTime", "W", "f", "u0", "city", "X", "j0", "g1", "weatherDecs", "Y", "k0", "h1", "weatherFlag", "e", "t0", GdtGetUserInfoHandler.KEY_AREA, "l0", "i1", "weatherIconKey", "m0", "j1", "weatherPrompt", "c0", "p", "B0", "constellationTodayTrend", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "C0", "constellationTomorrowTrend", "j", "v0", "constellationBgImageUrl", "l", "x0", "constellationIconUrl", "g0", "y0", "constellationJumpUrl", "h0", "k", "w0", "constellationDateStr", "i0", DomainData.DOMAIN_NAME, "z0", "constellationLuckyColor", "o", "A0", "constellationLuckyNumber", HippyTKDListViewAdapter.X, "J0", "diyEmoType", "w", "I0", "diyEmoSeverId", "v", "H0", "diyDesc", "d1", "videoId", "e1", "videoName", "f1", AppConstants.Key.KEY_QZONE_VIDEO_URL, "r", "D0", "curOlympicRank", "N0", "lastLoginType", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "M0", "lastLoginClient", "Q0", "setTime", "Y0", "strTermDesc", ReportConstant.COSTREPORT_PREFIX, "E0", "customOnlineStatus", "t", "F0", "customOnlineStatusType", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "contacts_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes22.dex */
public class c extends com.tencent.qqnt.ntrelation.baseinfo.bean.a {
    static IPatchRedirector $redirector_;

    /* renamed from: C, reason: from kotlin metadata */
    private int iBatteryStatus;

    /* renamed from: D, reason: from kotlin metadata */
    private int netTypeIconId;

    /* renamed from: E, reason: from kotlin metadata */
    private long uExtOnlineStatus;

    /* renamed from: F, reason: from kotlin metadata */
    private byte detalStatusFlag;

    /* renamed from: G, reason: from kotlin metadata */
    private int iTermType;

    /* renamed from: H, reason: from kotlin metadata */
    private int netWork;

    /* renamed from: I, reason: from kotlin metadata */
    @Nullable
    private String songId;

    /* renamed from: J, reason: from kotlin metadata */
    @Nullable
    private String songName;

    /* renamed from: K, reason: from kotlin metadata */
    @Nullable
    private String singerName;

    /* renamed from: L, reason: from kotlin metadata */
    private long songEndTime;

    /* renamed from: M, reason: from kotlin metadata */
    private int songSourceType;

    /* renamed from: N, reason: from kotlin metadata */
    private int songPauseRemainTime;

    /* renamed from: P, reason: from kotlin metadata */
    private int songDuration;

    /* renamed from: Q, reason: from kotlin metadata */
    @Nullable
    private String temper;

    /* renamed from: R, reason: from kotlin metadata */
    @Nullable
    private String weatherType;

    /* renamed from: S, reason: from kotlin metadata */
    @Nullable
    private String weatherTypeId;

    /* renamed from: T, reason: from kotlin metadata */
    @Nullable
    private String weatherTip;

    /* renamed from: U, reason: from kotlin metadata */
    @Nullable
    private String adCode;

    /* renamed from: V, reason: from kotlin metadata */
    private long weatherUpdateTime;

    /* renamed from: W, reason: from kotlin metadata */
    @Nullable
    private String city;

    /* renamed from: X, reason: from kotlin metadata */
    @Nullable
    private String weatherDecs;

    /* renamed from: Y, reason: from kotlin metadata */
    private int weatherFlag;

    /* renamed from: Z, reason: from kotlin metadata */
    @Nullable
    private String area;

    /* renamed from: a0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String weatherIconKey;

    /* renamed from: b0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String weatherPrompt;

    /* renamed from: c0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String constellationTodayTrend;

    /* renamed from: d0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String constellationTomorrowTrend;

    /* renamed from: e0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String constellationBgImageUrl;

    /* renamed from: f0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String constellationIconUrl;

    /* renamed from: g0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String constellationJumpUrl;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String uid;

    /* renamed from: h0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String constellationDateStr;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String uin;

    /* renamed from: i0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String constellationLuckyColor;

    /* renamed from: j0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String constellationLuckyNumber;

    /* renamed from: k0, reason: collision with root package name and from kotlin metadata */
    private int diyEmoType;

    /* renamed from: l0, reason: collision with root package name and from kotlin metadata */
    private long diyEmoSeverId;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private long abilityBits;

    /* renamed from: m0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String diyDesc;

    /* renamed from: n0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String videoId;

    /* renamed from: o0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String videoName;

    /* renamed from: p0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String videoUrl;

    /* renamed from: q0, reason: collision with root package name and from kotlin metadata */
    private long curOlympicRank;

    /* renamed from: r0, reason: collision with root package name and from kotlin metadata */
    private long lastLoginType;

    /* renamed from: s0, reason: collision with root package name and from kotlin metadata */
    private long lastLoginClient;

    /* renamed from: t0, reason: collision with root package name and from kotlin metadata */
    private long setTime;

    /* renamed from: u0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String strTermDesc;

    /* renamed from: v0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String customOnlineStatus;

    /* renamed from: w0, reason: collision with root package name and from kotlin metadata */
    private int customOnlineStatusType;

    public c() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 102)) {
            return;
        }
        iPatchRedirector.redirect((short) 102, (Object) this);
    }

    public long A() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 91)) {
            return ((Long) iPatchRedirector.redirect((short) 91, (Object) this)).longValue();
        }
        return this.lastLoginClient;
    }

    public void A0(@Nullable String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 74)) {
            iPatchRedirector.redirect((short) 74, (Object) this, (Object) str);
        } else {
            this.constellationLuckyNumber = str;
        }
    }

    public long B() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 89)) {
            return ((Long) iPatchRedirector.redirect((short) 89, (Object) this)).longValue();
        }
        return this.lastLoginType;
    }

    public void B0(@Nullable String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 60)) {
            iPatchRedirector.redirect((short) 60, (Object) this, (Object) str);
        } else {
            this.constellationTodayTrend = str;
        }
    }

    public int C() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Integer) iPatchRedirector.redirect((short) 11, (Object) this)).intValue();
        }
        return this.netTypeIconId;
    }

    public void C0(@Nullable String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 62)) {
            iPatchRedirector.redirect((short) 62, (Object) this, (Object) str);
        } else {
            this.constellationTomorrowTrend = str;
        }
    }

    public void D0(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 88)) {
            iPatchRedirector.redirect((short) 88, (Object) this, j3);
        } else {
            this.curOlympicRank = j3;
        }
    }

    public int E() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return ((Integer) iPatchRedirector.redirect((short) 19, (Object) this)).intValue();
        }
        return this.netWork;
    }

    public void E0(@Nullable String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 98)) {
            iPatchRedirector.redirect((short) 98, (Object) this, (Object) str);
        } else {
            this.customOnlineStatus = str;
        }
    }

    public long F() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 93)) {
            return ((Long) iPatchRedirector.redirect((short) 93, (Object) this)).longValue();
        }
        return this.setTime;
    }

    public void F0(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 100)) {
            iPatchRedirector.redirect((short) 100, (Object) this, i3);
        } else {
            this.customOnlineStatusType = i3;
        }
    }

    @Nullable
    public String G() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            return (String) iPatchRedirector.redirect((short) 25, (Object) this);
        }
        return this.singerName;
    }

    public void G0(byte b16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, this, Byte.valueOf(b16));
        } else {
            this.detalStatusFlag = b16;
        }
    }

    public void H0(@Nullable String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 80)) {
            iPatchRedirector.redirect((short) 80, (Object) this, (Object) str);
        } else {
            this.diyDesc = str;
        }
    }

    public void I0(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 78)) {
            iPatchRedirector.redirect((short) 78, (Object) this, j3);
        } else {
            this.diyEmoSeverId = j3;
        }
    }

    public void J0(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 76)) {
            iPatchRedirector.redirect((short) 76, (Object) this, i3);
        } else {
            this.diyEmoType = i3;
        }
    }

    public void K0(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, i3);
        } else {
            this.iBatteryStatus = i3;
        }
    }

    public void L0(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, i3);
        } else {
            this.iTermType = i3;
        }
    }

    public int M() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            return ((Integer) iPatchRedirector.redirect((short) 33, (Object) this)).intValue();
        }
        return this.songDuration;
    }

    public void M0(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 92)) {
            iPatchRedirector.redirect((short) 92, (Object) this, j3);
        } else {
            this.lastLoginClient = j3;
        }
    }

    public long N() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            return ((Long) iPatchRedirector.redirect((short) 27, (Object) this)).longValue();
        }
        return this.songEndTime;
    }

    public void N0(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 90)) {
            iPatchRedirector.redirect((short) 90, (Object) this, j3);
        } else {
            this.lastLoginType = j3;
        }
    }

    public void O0(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, i3);
        } else {
            this.netTypeIconId = i3;
        }
    }

    public void P0(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this, i3);
        } else {
            this.netWork = i3;
        }
    }

    public void Q0(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 94)) {
            iPatchRedirector.redirect((short) 94, (Object) this, j3);
        } else {
            this.setTime = j3;
        }
    }

    public void R0(@Nullable String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, (Object) this, (Object) str);
        } else {
            this.singerName = str;
        }
    }

    public void S0(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
            iPatchRedirector.redirect((short) 34, (Object) this, i3);
        } else {
            this.songDuration = i3;
        }
    }

    public void T0(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            iPatchRedirector.redirect((short) 28, (Object) this, j3);
        } else {
            this.songEndTime = j3;
        }
    }

    public void U0(@Nullable String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this, (Object) str);
        } else {
            this.songId = str;
        }
    }

    @Nullable
    public String V() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return (String) iPatchRedirector.redirect((short) 21, (Object) this);
        }
        return this.songId;
    }

    public void V0(@Nullable String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, (Object) this, (Object) str);
        } else {
            this.songName = str;
        }
    }

    public void W0(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            iPatchRedirector.redirect((short) 32, (Object) this, i3);
        } else {
            this.songPauseRemainTime = i3;
        }
    }

    public void X0(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            iPatchRedirector.redirect((short) 30, (Object) this, i3);
        } else {
            this.songSourceType = i3;
        }
    }

    public void Y0(@Nullable String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 96)) {
            iPatchRedirector.redirect((short) 96, (Object) this, (Object) str);
        } else {
            this.strTermDesc = str;
        }
    }

    @Nullable
    public String Z() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return (String) iPatchRedirector.redirect((short) 23, (Object) this);
        }
        return this.songName;
    }

    public void Z0(@Nullable String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 36)) {
            iPatchRedirector.redirect((short) 36, (Object) this, (Object) str);
        } else {
            this.temper = str;
        }
    }

    @Override // com.tencent.qqnt.ntrelation.baseinfo.bean.a
    @NotNull
    public String a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.uid;
    }

    public int a0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            return ((Integer) iPatchRedirector.redirect((short) 31, (Object) this)).intValue();
        }
        return this.songPauseRemainTime;
    }

    public void a1(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, j3);
        } else {
            this.uExtOnlineStatus = j3;
        }
    }

    public long b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Long) iPatchRedirector.redirect((short) 7, (Object) this)).longValue();
        }
        return this.abilityBits;
    }

    public int b0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            return ((Integer) iPatchRedirector.redirect((short) 29, (Object) this)).intValue();
        }
        return this.songSourceType;
    }

    public void b1(@NotNull String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) str);
        } else {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.uid = str;
        }
    }

    @Nullable
    public String c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 43)) {
            return (String) iPatchRedirector.redirect((short) 43, (Object) this);
        }
        return this.adCode;
    }

    @Nullable
    public String c0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 95)) {
            return (String) iPatchRedirector.redirect((short) 95, (Object) this);
        }
        return this.strTermDesc;
    }

    public void c1(@NotNull String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) str);
        } else {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.uin = str;
        }
    }

    @Nullable
    public String d0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 35)) {
            return (String) iPatchRedirector.redirect((short) 35, (Object) this);
        }
        return this.temper;
    }

    public void d1(@Nullable String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 82)) {
            iPatchRedirector.redirect((short) 82, (Object) this, (Object) str);
        } else {
            this.videoId = str;
        }
    }

    @Nullable
    public String e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 53)) {
            return (String) iPatchRedirector.redirect((short) 53, (Object) this);
        }
        return this.area;
    }

    public long e0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Long) iPatchRedirector.redirect((short) 13, (Object) this)).longValue();
        }
        return this.uExtOnlineStatus;
    }

    public void e1(@Nullable String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 84)) {
            iPatchRedirector.redirect((short) 84, (Object) this, (Object) str);
        } else {
            this.videoName = str;
        }
    }

    @Nullable
    public String f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 47)) {
            return (String) iPatchRedirector.redirect((short) 47, (Object) this);
        }
        return this.city;
    }

    @NotNull
    public String f0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.uin;
    }

    public void f1(@Nullable String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 86)) {
            iPatchRedirector.redirect((short) 86, (Object) this, (Object) str);
        } else {
            this.videoUrl = str;
        }
    }

    @Nullable
    public String g0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 81)) {
            return (String) iPatchRedirector.redirect((short) 81, (Object) this);
        }
        return this.videoId;
    }

    public void g1(@Nullable String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 50)) {
            iPatchRedirector.redirect((short) 50, (Object) this, (Object) str);
        } else {
            this.weatherDecs = str;
        }
    }

    @Nullable
    public String h0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 83)) {
            return (String) iPatchRedirector.redirect((short) 83, (Object) this);
        }
        return this.videoName;
    }

    public void h1(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 52)) {
            iPatchRedirector.redirect((short) 52, (Object) this, i3);
        } else {
            this.weatherFlag = i3;
        }
    }

    @Nullable
    public String i0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 85)) {
            return (String) iPatchRedirector.redirect((short) 85, (Object) this);
        }
        return this.videoUrl;
    }

    public void i1(@Nullable String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 56)) {
            iPatchRedirector.redirect((short) 56, (Object) this, (Object) str);
        } else {
            this.weatherIconKey = str;
        }
    }

    @Nullable
    public String j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 63)) {
            return (String) iPatchRedirector.redirect((short) 63, (Object) this);
        }
        return this.constellationBgImageUrl;
    }

    @Nullable
    public String j0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 49)) {
            return (String) iPatchRedirector.redirect((short) 49, (Object) this);
        }
        return this.weatherDecs;
    }

    public void j1(@Nullable String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 58)) {
            iPatchRedirector.redirect((short) 58, (Object) this, (Object) str);
        } else {
            this.weatherPrompt = str;
        }
    }

    @Nullable
    public String k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 69)) {
            return (String) iPatchRedirector.redirect((short) 69, (Object) this);
        }
        return this.constellationDateStr;
    }

    public int k0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 51)) {
            return ((Integer) iPatchRedirector.redirect((short) 51, (Object) this)).intValue();
        }
        return this.weatherFlag;
    }

    public void k1(@Nullable String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 42)) {
            iPatchRedirector.redirect((short) 42, (Object) this, (Object) str);
        } else {
            this.weatherTip = str;
        }
    }

    @Nullable
    public String l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 65)) {
            return (String) iPatchRedirector.redirect((short) 65, (Object) this);
        }
        return this.constellationIconUrl;
    }

    @Nullable
    public String l0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 55)) {
            return (String) iPatchRedirector.redirect((short) 55, (Object) this);
        }
        return this.weatherIconKey;
    }

    public void l1(@Nullable String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 38)) {
            iPatchRedirector.redirect((short) 38, (Object) this, (Object) str);
        } else {
            this.weatherType = str;
        }
    }

    @Nullable
    public String m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 67)) {
            return (String) iPatchRedirector.redirect((short) 67, (Object) this);
        }
        return this.constellationJumpUrl;
    }

    @Nullable
    public String m0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 57)) {
            return (String) iPatchRedirector.redirect((short) 57, (Object) this);
        }
        return this.weatherPrompt;
    }

    public void m1(@Nullable String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 40)) {
            iPatchRedirector.redirect((short) 40, (Object) this, (Object) str);
        } else {
            this.weatherTypeId = str;
        }
    }

    @Nullable
    public String n() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 71)) {
            return (String) iPatchRedirector.redirect((short) 71, (Object) this);
        }
        return this.constellationLuckyColor;
    }

    @Nullable
    public String n0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 41)) {
            return (String) iPatchRedirector.redirect((short) 41, (Object) this);
        }
        return this.weatherTip;
    }

    public void n1(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 46)) {
            iPatchRedirector.redirect((short) 46, (Object) this, j3);
        } else {
            this.weatherUpdateTime = j3;
        }
    }

    @Nullable
    public String o() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 73)) {
            return (String) iPatchRedirector.redirect((short) 73, (Object) this);
        }
        return this.constellationLuckyNumber;
    }

    @Nullable
    public String o0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 37)) {
            return (String) iPatchRedirector.redirect((short) 37, (Object) this);
        }
        return this.weatherType;
    }

    @Nullable
    public String p() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 59)) {
            return (String) iPatchRedirector.redirect((short) 59, (Object) this);
        }
        return this.constellationTodayTrend;
    }

    @Nullable
    public String p0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 39)) {
            return (String) iPatchRedirector.redirect((short) 39, (Object) this);
        }
        return this.weatherTypeId;
    }

    @Nullable
    public String q() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 61)) {
            return (String) iPatchRedirector.redirect((short) 61, (Object) this);
        }
        return this.constellationTomorrowTrend;
    }

    public long q0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 45)) {
            return ((Long) iPatchRedirector.redirect((short) 45, (Object) this)).longValue();
        }
        return this.weatherUpdateTime;
    }

    public long r() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 87)) {
            return ((Long) iPatchRedirector.redirect((short) 87, (Object) this)).longValue();
        }
        return this.curOlympicRank;
    }

    public void r0(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, j3);
        } else {
            this.abilityBits = j3;
        }
    }

    @Nullable
    public String s() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 97)) {
            return (String) iPatchRedirector.redirect((short) 97, (Object) this);
        }
        return this.customOnlineStatus;
    }

    public void s0(@Nullable String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 44)) {
            iPatchRedirector.redirect((short) 44, (Object) this, (Object) str);
        } else {
            this.adCode = str;
        }
    }

    public int t() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 99)) {
            return ((Integer) iPatchRedirector.redirect((short) 99, (Object) this)).intValue();
        }
        return this.customOnlineStatusType;
    }

    public void t0(@Nullable String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 54)) {
            iPatchRedirector.redirect((short) 54, (Object) this, (Object) str);
        } else {
            this.area = str;
        }
    }

    @NotNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 101)) {
            return (String) iPatchRedirector.redirect((short) 101, (Object) this);
        }
        String a16 = a();
        String f06 = f0();
        long b16 = b();
        int y16 = y();
        int C = C();
        long e06 = e0();
        byte u16 = u();
        return "NTOnlineStatusSimpleInfo(uid='" + a16 + "', uin='" + f06 + "', abilityBits=" + b16 + ", iBatteryStatus=" + y16 + ", netTypeIconId=" + C + ", uExtOnlineStatus=" + e06 + ", detalStatusFlag=" + ((int) u16) + ", iTermType=" + z() + ", netWork=" + E() + ", songId=" + V() + ", songName=" + Z() + ", singerName=" + G() + ", songEndTime=" + N() + ", songSourceType=" + b0() + ", songPauseRemainTime=" + a0() + ", songDuration=" + M() + ", temper=" + d0() + ", weatherType=" + o0() + ", weatherTypeId=" + p0() + ", weatherTip=" + n0() + ", adCode=" + c() + ", weatherUpdateTime=" + q0() + ", city=" + f() + ", weatherDecs=" + j0() + ", weatherFlag=" + k0() + ", area=" + e() + ", weatherIconKey=" + l0() + ", weatherPrompt=" + m0() + ", constellationTodayTrend=" + p() + ", constellationTomorrowTrend=" + q() + ", constellationBgImageUrl=" + j() + ", constellationIconUrl=" + l() + ", constellationJumpUrl=" + m() + ", constellationDateStr=" + k() + ", constellationLuckyColor=" + n() + ", constellationLuckyNumber=" + o() + ", diyEmoType=" + x() + ", diyEmoSeverId=" + w() + ", diyDesc=" + v() + ", videoId=" + g0() + ", videoName=" + h0() + ", videoUrl=" + i0() + ", curOlympicRank=" + r() + ", lastLoginType=" + B() + ", lastLoginClient=" + A() + ", setTime=" + F() + ", strTermDesc=" + c0() + ", customOnlineStatus=" + s() + ", customOnlineStatusType=" + t() + ")";
    }

    public byte u() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Byte) iPatchRedirector.redirect((short) 15, (Object) this)).byteValue();
        }
        return this.detalStatusFlag;
    }

    public void u0(@Nullable String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 48)) {
            iPatchRedirector.redirect((short) 48, (Object) this, (Object) str);
        } else {
            this.city = str;
        }
    }

    @Nullable
    public String v() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 79)) {
            return (String) iPatchRedirector.redirect((short) 79, (Object) this);
        }
        return this.diyDesc;
    }

    public void v0(@Nullable String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 64)) {
            iPatchRedirector.redirect((short) 64, (Object) this, (Object) str);
        } else {
            this.constellationBgImageUrl = str;
        }
    }

    public long w() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 77)) {
            return ((Long) iPatchRedirector.redirect((short) 77, (Object) this)).longValue();
        }
        return this.diyEmoSeverId;
    }

    public void w0(@Nullable String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 70)) {
            iPatchRedirector.redirect((short) 70, (Object) this, (Object) str);
        } else {
            this.constellationDateStr = str;
        }
    }

    public int x() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 75)) {
            return ((Integer) iPatchRedirector.redirect((short) 75, (Object) this)).intValue();
        }
        return this.diyEmoType;
    }

    public void x0(@Nullable String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 66)) {
            iPatchRedirector.redirect((short) 66, (Object) this, (Object) str);
        } else {
            this.constellationIconUrl = str;
        }
    }

    public int y() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Integer) iPatchRedirector.redirect((short) 9, (Object) this)).intValue();
        }
        return this.iBatteryStatus;
    }

    public void y0(@Nullable String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 68)) {
            iPatchRedirector.redirect((short) 68, (Object) this, (Object) str);
        } else {
            this.constellationJumpUrl = str;
        }
    }

    public int z() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return ((Integer) iPatchRedirector.redirect((short) 17, (Object) this)).intValue();
        }
        return this.iTermType;
    }

    public void z0(@Nullable String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 72)) {
            iPatchRedirector.redirect((short) 72, (Object) this, (Object) str);
        } else {
            this.constellationLuckyColor = str;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(@NotNull String uid, @NotNull String uin) {
        super(uid, uin);
        Intrinsics.checkNotNullParameter(uid, "uid");
        Intrinsics.checkNotNullParameter(uin, "uin");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) uid, (Object) uin);
            return;
        }
        this.uid = uid;
        this.uin = uin;
        this.songId = "";
        this.songName = "";
        this.singerName = "";
        this.temper = "";
        this.weatherType = "";
        this.weatherTypeId = "";
        this.weatherTip = "";
        this.adCode = "";
        this.city = "";
        this.weatherDecs = "";
        this.area = "";
        this.weatherIconKey = "";
        this.weatherPrompt = "";
        this.constellationTodayTrend = "";
        this.constellationTomorrowTrend = "";
        this.constellationBgImageUrl = "";
        this.constellationIconUrl = "";
        this.constellationJumpUrl = "";
        this.constellationDateStr = "";
        this.constellationLuckyColor = "";
        this.constellationLuckyNumber = "";
        this.diyDesc = "";
        this.videoId = "";
        this.videoName = "";
        this.videoUrl = "";
        this.curOlympicRank = -1L;
        this.strTermDesc = "";
        this.customOnlineStatus = "";
    }

    public /* synthetic */ c(String str, String str2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? "" : str, (i3 & 2) == 0 ? str2 : "");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, str, str2, Integer.valueOf(i3), defaultConstructorMarker);
    }
}
