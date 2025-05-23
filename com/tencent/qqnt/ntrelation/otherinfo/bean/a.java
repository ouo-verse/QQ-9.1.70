package com.tencent.qqnt.ntrelation.otherinfo.bean;

import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import java.lang.reflect.Field;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u001e\n\u0002\u0010\t\n\u0002\bT\b\u0086\b\u0018\u0000 ^2\u00020\u0001:\u0001\u0011B\u00a5\u0002\u0012\b\b\u0002\u0010\u0015\u001a\u00020\b\u0012\b\b\u0002\u0010\u0019\u001a\u00020\b\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010&\u001a\u00020\u0004\u0012\b\b\u0002\u0010*\u001a\u00020\u0004\u0012\b\b\u0002\u00101\u001a\u00020+\u0012\b\b\u0002\u00105\u001a\u00020+\u0012\b\b\u0002\u00109\u001a\u00020\u0004\u0012\b\b\u0002\u0010=\u001a\u00020\u0004\u0012\b\b\u0002\u0010A\u001a\u00020\u0004\u0012\b\b\u0002\u0010E\u001a\u00020\u0004\u0012\n\b\u0002\u0010I\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010M\u001a\u00020\u0004\u0012\b\b\u0002\u0010P\u001a\u00020+\u0012\b\b\u0002\u0010T\u001a\u00020+\u0012\b\b\u0002\u0010X\u001a\u00020+\u0012\b\b\u0002\u0010\\\u001a\u00020+\u0012\b\b\u0002\u0010_\u001a\u00020+\u0012\b\b\u0002\u0010c\u001a\u00020+\u0012\b\b\u0002\u0010g\u001a\u00020+\u0012\b\b\u0002\u0010j\u001a\u00020+\u0012\b\b\u0002\u0010m\u001a\u00020+\u0012\b\b\u0002\u0010o\u001a\u00020+\u0012\b\b\u0002\u0010r\u001a\u00020+\u0012\b\b\u0002\u0010u\u001a\u00020\u0004\u0012\b\b\u0002\u0010w\u001a\u00020\u0004\u0012\b\b\u0002\u0010y\u001a\u00020\u0004\u0012\n\b\u0002\u0010{\u001a\u0004\u0018\u00010\b\u00a2\u0006\u0004\b|\u0010}B\u001d\b\u0016\u0012\b\b\u0002\u0010\u0015\u001a\u00020\b\u0012\b\b\u0002\u0010\u0019\u001a\u00020\b\u00a2\u0006\u0004\b|\u0010~J\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\b\u0010\t\u001a\u00020\bH\u0016J\b\u0010\n\u001a\u00020\u0006H\u0016J\t\u0010\u000b\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\u000e\u001a\u00020\u00022\b\u0010\r\u001a\u0004\u0018\u00010\fH\u00d6\u0003R\"\u0010\u0015\u001a\u00020\b8\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\"\u0010\u0019\u001a\u00020\b8\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\b\u0016\u0010\u0010\u001a\u0004\b\u0017\u0010\u0012\"\u0004\b\u0018\u0010\u0014R$\u0010 \u001a\u0004\u0018\u00010\u00028\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\"\u0010&\u001a\u00020\u00048\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\b!\u0010\u0016\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\"\u0010*\u001a\u00020\u00048\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\b'\u0010\u0016\u001a\u0004\b(\u0010#\"\u0004\b)\u0010%R\"\u00101\u001a\u00020+8\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\b,\u0010\u001a\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\"\u00105\u001a\u00020+8\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\b2\u0010\u001a\u001a\u0004\b3\u0010.\"\u0004\b4\u00100R\"\u00109\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b6\u0010\u0016\u001a\u0004\b7\u0010#\"\u0004\b8\u0010%R\"\u0010=\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b:\u0010\u0016\u001a\u0004\b;\u0010#\"\u0004\b<\u0010%R\"\u0010A\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b>\u0010\u0016\u001a\u0004\b?\u0010#\"\u0004\b@\u0010%R\"\u0010E\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bB\u0010\u0016\u001a\u0004\bC\u0010#\"\u0004\bD\u0010%R$\u0010I\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bF\u0010\u001b\u001a\u0004\bG\u0010\u001d\"\u0004\bH\u0010\u001fR\"\u0010M\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bJ\u0010\u0016\u001a\u0004\bK\u0010#\"\u0004\bL\u0010%R\"\u0010P\u001a\u00020+8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b?\u0010\u001a\u001a\u0004\bN\u0010.\"\u0004\bO\u00100R\"\u0010T\u001a\u00020+8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bQ\u0010\u001a\u001a\u0004\bR\u0010.\"\u0004\bS\u00100R\"\u0010X\u001a\u00020+8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bU\u0010\u001a\u001a\u0004\bV\u0010.\"\u0004\bW\u00100R\"\u0010\\\u001a\u00020+8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bY\u0010\u001a\u001a\u0004\bZ\u0010.\"\u0004\b[\u00100R\"\u0010_\u001a\u00020+8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b;\u0010\u001a\u001a\u0004\b]\u0010.\"\u0004\b^\u00100R\"\u0010c\u001a\u00020+8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b`\u0010\u001a\u001a\u0004\ba\u0010.\"\u0004\bb\u00100R\"\u0010g\u001a\u00020+8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bd\u0010\u001a\u001a\u0004\be\u0010.\"\u0004\bf\u00100R\"\u0010j\u001a\u00020+8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bh\u0010\u001a\u001a\u0004\bh\u0010.\"\u0004\bi\u00100R\"\u0010m\u001a\u00020+8\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\be\u0010\u001a\u001a\u0004\bk\u0010.\"\u0004\bl\u00100R\"\u0010o\u001a\u00020+8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bG\u0010\u001a\u001a\u0004\bd\u0010.\"\u0004\bn\u00100R\"\u0010r\u001a\u00020+8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bD\u0010\u001a\u001a\u0004\bp\u0010.\"\u0004\bq\u00100R\"\u0010u\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b8\u0010\u0016\u001a\u0004\bs\u0010#\"\u0004\bt\u0010%R\"\u0010w\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bq\u0010\u0016\u001a\u0004\b,\u0010#\"\u0004\bv\u0010%R\"\u0010y\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bH\u0010\u0016\u001a\u0004\b2\u0010#\"\u0004\bx\u0010%R$\u0010{\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bL\u0010\u0010\u001a\u0004\b`\u0010\u0012\"\u0004\bz\u0010\u0014\u00a8\u0006\u007f"}, d2 = {"Lcom/tencent/qqnt/ntrelation/otherinfo/bean/a;", "Lcom/tencent/qqnt/ntrelation/otherinfo/bean/c;", "", "open", "", "businessType", "", "w0", "", "toString", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "hashCode", "", "other", "equals", "H", "Ljava/lang/String;", "a", "()Ljava/lang/String;", "t", "(Ljava/lang/String;)V", "uid", "I", "j", "u", "uin", "J", "Ljava/lang/Boolean;", "k", "()Ljava/lang/Boolean;", DomainData.DOMAIN_NAME, "(Ljava/lang/Boolean;)V", "isAioShortcutBarOpen", "K", "l", "()I", "r", "(I)V", "isSharingLocation", "L", "e", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "notiRingId", "", "M", "f", "()J", ReportConstant.COSTREPORT_PREFIX, "(J)V", "specialCareDateTime", "N", "c", "p", "messageRingId", "P", "w", "g0", "chatInputType", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Z", "u0", "showC2CPanel", BdhLogUtil.LogTag.Tag_Req, "V", "t0", "pttChangeVoiceType", ExifInterface.LATITUDE_SOUTH, "v", "f0", "audioPanelType", "T", "e0", "i0", "isDataChanged", "U", "y", "j0", "hiddenChatSwitch", "E", "o0", "latestPLUpdateTimestamp", "W", BdhLogUtil.LogTag.Tag_Conn, "n0", "lastPullPLNewsTimestamp", "X", "B", "m0", "lastPLNewsTimestamp", "Y", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "l0", "lastIceBreakCheckTs", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "k0", "lastIceBreakChatTs", "a0", UserInfo.SEX_FEMALE, "p0", "makeFrdsTs", "b0", "d0", "y0", "topPositionTime", "c0", "x0", "togetherBusinessFlag", "b", "o", "colorRingId", "v0", "timestamp", HippyTKDListViewAdapter.X, "h0", "comingRingId", "G", "q0", "messageEnablePreviewNew", "r0", "messageEnableSoundNew", "s0", "messageEnableVibrateNew", "setStrMasterUin", "strMasterUin", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;IIJJIIIILjava/lang/Boolean;IJJJJJJJJJJJIIILjava/lang/String;)V", "(Ljava/lang/String;Ljava/lang/String;)V", "contacts_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes22.dex */
public final /* data */ class a extends c {
    static IPatchRedirector $redirector_;

    /* renamed from: k0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private String uid;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private String uin;

    /* renamed from: J, reason: from kotlin metadata */
    @Nullable
    private Boolean isAioShortcutBarOpen;

    /* renamed from: K, reason: from kotlin metadata */
    private int isSharingLocation;

    /* renamed from: L, reason: from kotlin metadata */
    private int notiRingId;

    /* renamed from: M, reason: from kotlin metadata */
    private long specialCareDateTime;

    /* renamed from: N, reason: from kotlin metadata */
    private long messageRingId;

    /* renamed from: P, reason: from kotlin metadata */
    private int chatInputType;

    /* renamed from: Q, reason: from kotlin metadata */
    private int showC2CPanel;

    /* renamed from: R, reason: from kotlin metadata */
    private int pttChangeVoiceType;

    /* renamed from: S, reason: from kotlin metadata */
    private int audioPanelType;

    /* renamed from: T, reason: from kotlin metadata */
    @Nullable
    private Boolean isDataChanged;

    /* renamed from: U, reason: from kotlin metadata */
    private int hiddenChatSwitch;

    /* renamed from: V, reason: from kotlin metadata */
    private long latestPLUpdateTimestamp;

    /* renamed from: W, reason: from kotlin metadata */
    private long lastPullPLNewsTimestamp;

    /* renamed from: X, reason: from kotlin metadata */
    private long lastPLNewsTimestamp;

    /* renamed from: Y, reason: from kotlin metadata */
    private long lastIceBreakCheckTs;

    /* renamed from: Z, reason: from kotlin metadata */
    private long lastIceBreakChatTs;

    /* renamed from: a0, reason: collision with root package name and from kotlin metadata */
    private long makeFrdsTs;

    /* renamed from: b0, reason: collision with root package name and from kotlin metadata */
    private long topPositionTime;

    /* renamed from: c0, reason: collision with root package name and from kotlin metadata */
    private long togetherBusinessFlag;

    /* renamed from: d0, reason: collision with root package name and from kotlin metadata */
    private long colorRingId;

    /* renamed from: e0, reason: collision with root package name and from kotlin metadata */
    private long timestamp;

    /* renamed from: f0, reason: collision with root package name and from kotlin metadata */
    private long comingRingId;

    /* renamed from: g0, reason: collision with root package name and from kotlin metadata */
    private int messageEnablePreviewNew;

    /* renamed from: h0, reason: collision with root package name and from kotlin metadata */
    private int messageEnableSoundNew;

    /* renamed from: i0, reason: collision with root package name and from kotlin metadata */
    private int messageEnableVibrateNew;

    /* renamed from: j0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String strMasterUin;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/qqnt/ntrelation/otherinfo/bean/a$a;", "", "", "AUDIO_PANEL_TYPE_NONE", "I", "<init>", "()V", "contacts_api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.ntrelation.otherinfo.bean.a$a, reason: collision with other inner class name and from kotlin metadata */
    /* loaded from: classes22.dex */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(37562);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 97)) {
            redirector.redirect((short) 97);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public a() {
        this(null, null, null, 0, 0, 0L, 0L, 0, 0, 0, 0, null, 0, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0, 0, 0, null, 268435455, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 96)) {
            return;
        }
        iPatchRedirector.redirect((short) 96, (Object) this);
    }

    public final long A() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 35)) {
            return ((Long) iPatchRedirector.redirect((short) 35, (Object) this)).longValue();
        }
        return this.lastIceBreakCheckTs;
    }

    public final long B() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            return ((Long) iPatchRedirector.redirect((short) 33, (Object) this)).longValue();
        }
        return this.lastPLNewsTimestamp;
    }

    public final long C() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            return ((Long) iPatchRedirector.redirect((short) 31, (Object) this)).longValue();
        }
        return this.lastPullPLNewsTimestamp;
    }

    public final long E() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            return ((Long) iPatchRedirector.redirect((short) 29, (Object) this)).longValue();
        }
        return this.latestPLUpdateTimestamp;
    }

    public final long F() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 39)) {
            return ((Long) iPatchRedirector.redirect((short) 39, (Object) this)).longValue();
        }
        return this.makeFrdsTs;
    }

    public final int G() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 51)) {
            return ((Integer) iPatchRedirector.redirect((short) 51, (Object) this)).intValue();
        }
        return this.messageEnablePreviewNew;
    }

    public final int M() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 53)) {
            return ((Integer) iPatchRedirector.redirect((short) 53, (Object) this)).intValue();
        }
        return this.messageEnableSoundNew;
    }

    public final int N() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 55)) {
            return ((Integer) iPatchRedirector.redirect((short) 55, (Object) this)).intValue();
        }
        return this.messageEnableVibrateNew;
    }

    public final int V() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return ((Integer) iPatchRedirector.redirect((short) 21, (Object) this)).intValue();
        }
        return this.pttChangeVoiceType;
    }

    public final int Z() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return ((Integer) iPatchRedirector.redirect((short) 19, (Object) this)).intValue();
        }
        return this.showC2CPanel;
    }

    @Override // com.tencent.qqnt.ntrelation.otherinfo.bean.c, com.tencent.qqnt.ntrelation.baseinfo.bean.a
    @NotNull
    /* renamed from: a */
    public String getUid() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.uid;
    }

    @Nullable
    public final String a0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 57)) {
            return (String) iPatchRedirector.redirect((short) 57, (Object) this);
        }
        return this.strMasterUin;
    }

    @Override // com.tencent.qqnt.ntrelation.otherinfo.bean.c
    public long b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 45)) {
            return ((Long) iPatchRedirector.redirect((short) 45, (Object) this)).longValue();
        }
        return this.colorRingId;
    }

    public final long b0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 47)) {
            return ((Long) iPatchRedirector.redirect((short) 47, (Object) this)).longValue();
        }
        return this.timestamp;
    }

    @Override // com.tencent.qqnt.ntrelation.otherinfo.bean.c
    public long c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Long) iPatchRedirector.redirect((short) 15, (Object) this)).longValue();
        }
        return this.messageRingId;
    }

    public final long c0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 43)) {
            return ((Long) iPatchRedirector.redirect((short) 43, (Object) this)).longValue();
        }
        return this.togetherBusinessFlag;
    }

    public final long d0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 41)) {
            return ((Long) iPatchRedirector.redirect((short) 41, (Object) this)).longValue();
        }
        return this.topPositionTime;
    }

    @Override // com.tencent.qqnt.ntrelation.otherinfo.bean.c
    public int e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Integer) iPatchRedirector.redirect((short) 11, (Object) this)).intValue();
        }
        return this.notiRingId;
    }

    @Nullable
    public final Boolean e0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            return (Boolean) iPatchRedirector.redirect((short) 25, (Object) this);
        }
        return this.isDataChanged;
    }

    public boolean equals(@Nullable Object other) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 95)) {
            return ((Boolean) iPatchRedirector.redirect((short) 95, (Object) this, other)).booleanValue();
        }
        if (this == other) {
            return true;
        }
        if (!(other instanceof a)) {
            return false;
        }
        a aVar = (a) other;
        if (Intrinsics.areEqual(getUid(), aVar.getUid()) && Intrinsics.areEqual(j(), aVar.j()) && Intrinsics.areEqual(k(), aVar.k()) && l() == aVar.l() && e() == aVar.e() && f() == aVar.f() && c() == aVar.c() && this.chatInputType == aVar.chatInputType && this.showC2CPanel == aVar.showC2CPanel && this.pttChangeVoiceType == aVar.pttChangeVoiceType && this.audioPanelType == aVar.audioPanelType && Intrinsics.areEqual(this.isDataChanged, aVar.isDataChanged) && this.hiddenChatSwitch == aVar.hiddenChatSwitch && this.latestPLUpdateTimestamp == aVar.latestPLUpdateTimestamp && this.lastPullPLNewsTimestamp == aVar.lastPullPLNewsTimestamp && this.lastPLNewsTimestamp == aVar.lastPLNewsTimestamp && this.lastIceBreakCheckTs == aVar.lastIceBreakCheckTs && this.lastIceBreakChatTs == aVar.lastIceBreakChatTs && this.makeFrdsTs == aVar.makeFrdsTs && this.topPositionTime == aVar.topPositionTime && this.togetherBusinessFlag == aVar.togetherBusinessFlag && b() == aVar.b() && this.timestamp == aVar.timestamp && this.comingRingId == aVar.comingRingId && this.messageEnablePreviewNew == aVar.messageEnablePreviewNew && this.messageEnableSoundNew == aVar.messageEnableSoundNew && this.messageEnableVibrateNew == aVar.messageEnableVibrateNew && Intrinsics.areEqual(this.strMasterUin, aVar.strMasterUin)) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.qqnt.ntrelation.otherinfo.bean.c
    public long f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Long) iPatchRedirector.redirect((short) 13, (Object) this)).longValue();
        }
        return this.specialCareDateTime;
    }

    public final void f0(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, (Object) this, i3);
        } else {
            this.audioPanelType = i3;
        }
    }

    public final void g0(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, i3);
        } else {
            this.chatInputType = i3;
        }
    }

    public final void h0(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 50)) {
            iPatchRedirector.redirect((short) 50, (Object) this, j3);
        } else {
            this.comingRingId = j3;
        }
    }

    public int hashCode() {
        int hashCode;
        int hashCode2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 94)) {
            return ((Integer) iPatchRedirector.redirect((short) 94, (Object) this)).intValue();
        }
        int hashCode3 = ((getUid().hashCode() * 31) + j().hashCode()) * 31;
        int i3 = 0;
        if (k() == null) {
            hashCode = 0;
        } else {
            hashCode = k().hashCode();
        }
        int l3 = (((((((((((((((((hashCode3 + hashCode) * 31) + l()) * 31) + e()) * 31) + androidx.fragment.app.a.a(f())) * 31) + androidx.fragment.app.a.a(c())) * 31) + this.chatInputType) * 31) + this.showC2CPanel) * 31) + this.pttChangeVoiceType) * 31) + this.audioPanelType) * 31;
        Boolean bool = this.isDataChanged;
        if (bool == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = bool.hashCode();
        }
        int a16 = (((((((((((((((((((((((((((((((l3 + hashCode2) * 31) + this.hiddenChatSwitch) * 31) + androidx.fragment.app.a.a(this.latestPLUpdateTimestamp)) * 31) + androidx.fragment.app.a.a(this.lastPullPLNewsTimestamp)) * 31) + androidx.fragment.app.a.a(this.lastPLNewsTimestamp)) * 31) + androidx.fragment.app.a.a(this.lastIceBreakCheckTs)) * 31) + androidx.fragment.app.a.a(this.lastIceBreakChatTs)) * 31) + androidx.fragment.app.a.a(this.makeFrdsTs)) * 31) + androidx.fragment.app.a.a(this.topPositionTime)) * 31) + androidx.fragment.app.a.a(this.togetherBusinessFlag)) * 31) + androidx.fragment.app.a.a(b())) * 31) + androidx.fragment.app.a.a(this.timestamp)) * 31) + androidx.fragment.app.a.a(this.comingRingId)) * 31) + this.messageEnablePreviewNew) * 31) + this.messageEnableSoundNew) * 31) + this.messageEnableVibrateNew) * 31;
        String str = this.strMasterUin;
        if (str != null) {
            i3 = str.hashCode();
        }
        return a16 + i3;
    }

    public final void i0(@Nullable Boolean bool) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, (Object) this, (Object) bool);
        } else {
            this.isDataChanged = bool;
        }
    }

    @Override // com.tencent.qqnt.ntrelation.otherinfo.bean.c
    @NotNull
    public String j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.uin;
    }

    public final void j0(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            iPatchRedirector.redirect((short) 28, (Object) this, i3);
        } else {
            this.hiddenChatSwitch = i3;
        }
    }

    @Override // com.tencent.qqnt.ntrelation.otherinfo.bean.c
    @Nullable
    public Boolean k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (Boolean) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return this.isAioShortcutBarOpen;
    }

    public final void k0(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 38)) {
            iPatchRedirector.redirect((short) 38, (Object) this, j3);
        } else {
            this.lastIceBreakChatTs = j3;
        }
    }

    @Override // com.tencent.qqnt.ntrelation.otherinfo.bean.c
    public int l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Integer) iPatchRedirector.redirect((short) 9, (Object) this)).intValue();
        }
        return this.isSharingLocation;
    }

    public final void l0(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 36)) {
            iPatchRedirector.redirect((short) 36, (Object) this, j3);
        } else {
            this.lastIceBreakCheckTs = j3;
        }
    }

    @Override // com.tencent.qqnt.ntrelation.otherinfo.bean.c
    public void m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 64)) {
            iPatchRedirector.redirect((short) 64, (Object) this);
            return;
        }
        super.m();
        this.chatInputType = Integer.MIN_VALUE;
        this.showC2CPanel = Integer.MIN_VALUE;
        this.pttChangeVoiceType = Integer.MIN_VALUE;
        this.audioPanelType = Integer.MIN_VALUE;
        this.isDataChanged = null;
        this.hiddenChatSwitch = Integer.MIN_VALUE;
        this.latestPLUpdateTimestamp = Long.MIN_VALUE;
        this.lastPullPLNewsTimestamp = Long.MIN_VALUE;
        this.lastPLNewsTimestamp = Long.MIN_VALUE;
        this.lastIceBreakCheckTs = Long.MIN_VALUE;
        this.lastIceBreakChatTs = Long.MIN_VALUE;
        this.makeFrdsTs = Long.MIN_VALUE;
        this.topPositionTime = Long.MIN_VALUE;
        this.togetherBusinessFlag = Long.MIN_VALUE;
        this.timestamp = Long.MIN_VALUE;
        this.comingRingId = Long.MIN_VALUE;
        this.messageEnablePreviewNew = Integer.MIN_VALUE;
        this.messageEnableSoundNew = Integer.MIN_VALUE;
        this.messageEnableVibrateNew = Integer.MIN_VALUE;
        this.strMasterUin = null;
        p(Long.MIN_VALUE);
    }

    public final void m0(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
            iPatchRedirector.redirect((short) 34, (Object) this, j3);
        } else {
            this.lastPLNewsTimestamp = j3;
        }
    }

    @Override // com.tencent.qqnt.ntrelation.otherinfo.bean.c
    public void n(@Nullable Boolean bool) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) bool);
        } else {
            this.isAioShortcutBarOpen = bool;
        }
    }

    public final void n0(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            iPatchRedirector.redirect((short) 32, (Object) this, j3);
        } else {
            this.lastPullPLNewsTimestamp = j3;
        }
    }

    @Override // com.tencent.qqnt.ntrelation.otherinfo.bean.c
    public void o(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 46)) {
            iPatchRedirector.redirect((short) 46, (Object) this, j3);
        } else {
            this.colorRingId = j3;
        }
    }

    public final void o0(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            iPatchRedirector.redirect((short) 30, (Object) this, j3);
        } else {
            this.latestPLUpdateTimestamp = j3;
        }
    }

    @Override // com.tencent.qqnt.ntrelation.otherinfo.bean.c
    public void p(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, j3);
        } else {
            this.messageRingId = j3;
        }
    }

    public final void p0(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 40)) {
            iPatchRedirector.redirect((short) 40, (Object) this, j3);
        } else {
            this.makeFrdsTs = j3;
        }
    }

    @Override // com.tencent.qqnt.ntrelation.otherinfo.bean.c
    public void q(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, i3);
        } else {
            this.notiRingId = i3;
        }
    }

    public final void q0(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 52)) {
            iPatchRedirector.redirect((short) 52, (Object) this, i3);
        } else {
            this.messageEnablePreviewNew = i3;
        }
    }

    @Override // com.tencent.qqnt.ntrelation.otherinfo.bean.c
    public void r(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, i3);
        } else {
            this.isSharingLocation = i3;
        }
    }

    public final void r0(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 54)) {
            iPatchRedirector.redirect((short) 54, (Object) this, i3);
        } else {
            this.messageEnableSoundNew = i3;
        }
    }

    @Override // com.tencent.qqnt.ntrelation.otherinfo.bean.c
    public void s(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, j3);
        } else {
            this.specialCareDateTime = j3;
        }
    }

    public final void s0(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 56)) {
            iPatchRedirector.redirect((short) 56, (Object) this, i3);
        } else {
            this.messageEnableVibrateNew = i3;
        }
    }

    @Override // com.tencent.qqnt.ntrelation.otherinfo.bean.c
    public void t(@NotNull String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) str);
        } else {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.uid = str;
        }
    }

    public final void t0(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this, i3);
        } else {
            this.pttChangeVoiceType = i3;
        }
    }

    @Override // com.tencent.qqnt.ntrelation.otherinfo.bean.c
    @NotNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 63)) {
            return (String) iPatchRedirector.redirect((short) 63, (Object) this);
        }
        String str = "NTOtherDetailInfo uin " + j() + " uid " + getUid();
        Field[] allFields = a.class.getDeclaredFields();
        Intrinsics.checkNotNullExpressionValue(allFields, "allFields");
        for (Field field : allFields) {
            field.setAccessible(true);
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

    @Override // com.tencent.qqnt.ntrelation.otherinfo.bean.c
    public void u(@NotNull String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) str);
        } else {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.uin = str;
        }
    }

    public final void u0(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this, i3);
        } else {
            this.showC2CPanel = i3;
        }
    }

    public final int v() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return ((Integer) iPatchRedirector.redirect((short) 23, (Object) this)).intValue();
        }
        return this.audioPanelType;
    }

    public final void v0(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 48)) {
            iPatchRedirector.redirect((short) 48, (Object) this, j3);
        } else {
            this.timestamp = j3;
        }
    }

    public final int w() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return ((Integer) iPatchRedirector.redirect((short) 17, (Object) this)).intValue();
        }
        return this.chatInputType;
    }

    public final void w0(boolean open, int businessType) {
        long j3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 62)) {
            iPatchRedirector.redirect((short) 62, this, Boolean.valueOf(open), Integer.valueOf(businessType));
            return;
        }
        if (open) {
            j3 = businessType | this.togetherBusinessFlag;
        } else {
            j3 = (~businessType) & this.togetherBusinessFlag;
        }
        this.togetherBusinessFlag = j3;
    }

    public final long x() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 49)) {
            return ((Long) iPatchRedirector.redirect((short) 49, (Object) this)).longValue();
        }
        return this.comingRingId;
    }

    public final void x0(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 44)) {
            iPatchRedirector.redirect((short) 44, (Object) this, j3);
        } else {
            this.togetherBusinessFlag = j3;
        }
    }

    public final int y() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            return ((Integer) iPatchRedirector.redirect((short) 27, (Object) this)).intValue();
        }
        return this.hiddenChatSwitch;
    }

    public final void y0(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 42)) {
            iPatchRedirector.redirect((short) 42, (Object) this, j3);
        } else {
            this.topPositionTime = j3;
        }
    }

    public final long z() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 37)) {
            return ((Long) iPatchRedirector.redirect((short) 37, (Object) this)).longValue();
        }
        return this.lastIceBreakChatTs;
    }

    public /* synthetic */ a(String str, String str2, Boolean bool, int i3, int i16, long j3, long j16, int i17, int i18, int i19, int i26, Boolean bool2, int i27, long j17, long j18, long j19, long j26, long j27, long j28, long j29, long j36, long j37, long j38, long j39, int i28, int i29, int i36, String str3, int i37, DefaultConstructorMarker defaultConstructorMarker) {
        this((i37 & 1) != 0 ? "" : str, (i37 & 2) != 0 ? "" : str2, (i37 & 4) != 0 ? Boolean.TRUE : bool, (i37 & 8) != 0 ? 0 : i3, (i37 & 16) != 0 ? 0 : i16, (i37 & 32) != 0 ? 0L : j3, (i37 & 64) != 0 ? 0L : j16, (i37 & 128) != 0 ? 0 : i17, (i37 & 256) != 0 ? 1 : i18, (i37 & 512) != 0 ? 0 : i19, (i37 & 1024) != 0 ? -1 : i26, (i37 & 2048) != 0 ? Boolean.FALSE : bool2, (i37 & 4096) != 0 ? 0 : i27, (i37 & 8192) != 0 ? 0L : j17, (i37 & 16384) != 0 ? 0L : j18, (32768 & i37) != 0 ? 0L : j19, (65536 & i37) != 0 ? 0L : j26, (131072 & i37) != 0 ? 0L : j27, (262144 & i37) != 0 ? 0L : j28, (524288 & i37) != 0 ? 0L : j29, (1048576 & i37) != 0 ? 0L : j36, (2097152 & i37) != 0 ? 0L : j37, (4194304 & i37) != 0 ? 0L : j38, (8388608 & i37) != 0 ? 0L : j39, (16777216 & i37) != 0 ? 0 : i28, (33554432 & i37) != 0 ? 0 : i29, (67108864 & i37) != 0 ? 0 : i36, (134217728 & i37) == 0 ? str3 : "");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, str, str2, bool, Integer.valueOf(i3), Integer.valueOf(i16), Long.valueOf(j3), Long.valueOf(j16), Integer.valueOf(i17), Integer.valueOf(i18), Integer.valueOf(i19), Integer.valueOf(i26), bool2, Integer.valueOf(i27), Long.valueOf(j17), Long.valueOf(j18), Long.valueOf(j19), Long.valueOf(j26), Long.valueOf(j27), Long.valueOf(j28), Long.valueOf(j29), Long.valueOf(j36), Long.valueOf(j37), Long.valueOf(j38), Long.valueOf(j39), Integer.valueOf(i28), Integer.valueOf(i29), Integer.valueOf(i36), str3, Integer.valueOf(i37), defaultConstructorMarker);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(@NotNull String uid, @NotNull String uin, @Nullable Boolean bool, int i3, int i16, long j3, long j16, int i17, int i18, int i19, int i26, @Nullable Boolean bool2, int i27, long j17, long j18, long j19, long j26, long j27, long j28, long j29, long j36, long j37, long j38, long j39, int i28, int i29, int i36, @Nullable String str) {
        super(null, null, 3, null);
        Intrinsics.checkNotNullParameter(uid, "uid");
        Intrinsics.checkNotNullParameter(uin, "uin");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, uid, uin, bool, Integer.valueOf(i3), Integer.valueOf(i16), Long.valueOf(j3), Long.valueOf(j16), Integer.valueOf(i17), Integer.valueOf(i18), Integer.valueOf(i19), Integer.valueOf(i26), bool2, Integer.valueOf(i27), Long.valueOf(j17), Long.valueOf(j18), Long.valueOf(j19), Long.valueOf(j26), Long.valueOf(j27), Long.valueOf(j28), Long.valueOf(j29), Long.valueOf(j36), Long.valueOf(j37), Long.valueOf(j38), Long.valueOf(j39), Integer.valueOf(i28), Integer.valueOf(i29), Integer.valueOf(i36), str);
            return;
        }
        this.uid = uid;
        this.uin = uin;
        this.isAioShortcutBarOpen = bool;
        this.isSharingLocation = i3;
        this.notiRingId = i16;
        this.specialCareDateTime = j3;
        this.messageRingId = j16;
        this.chatInputType = i17;
        this.showC2CPanel = i18;
        this.pttChangeVoiceType = i19;
        this.audioPanelType = i26;
        this.isDataChanged = bool2;
        this.hiddenChatSwitch = i27;
        this.latestPLUpdateTimestamp = j17;
        this.lastPullPLNewsTimestamp = j18;
        this.lastPLNewsTimestamp = j19;
        this.lastIceBreakCheckTs = j26;
        this.lastIceBreakChatTs = j27;
        this.makeFrdsTs = j28;
        this.topPositionTime = j29;
        this.togetherBusinessFlag = j36;
        this.colorRingId = j37;
        this.timestamp = j38;
        this.comingRingId = j39;
        this.messageEnablePreviewNew = i28;
        this.messageEnableSoundNew = i29;
        this.messageEnableVibrateNew = i36;
        this.strMasterUin = str;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public a(@NotNull String uid, @NotNull String uin) {
        this(uid, uin, Boolean.TRUE, 0, 0, 0L, 0L, 0, 0, 0, 0, null, 0, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0, 0, 0, null, 268435448, null);
        Intrinsics.checkNotNullParameter(uid, "uid");
        Intrinsics.checkNotNullParameter(uin, "uin");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 59)) {
            return;
        }
        iPatchRedirector.redirect((short) 59, (Object) this, (Object) uid, (Object) uin);
    }

    public /* synthetic */ a(String str, String str2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? "" : str, (i3 & 2) == 0 ? str2 : "");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 60)) {
            return;
        }
        iPatchRedirector.redirect((short) 60, this, str, str2, Integer.valueOf(i3), defaultConstructorMarker);
    }
}
