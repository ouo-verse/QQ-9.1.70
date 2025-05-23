package com.tencent.qqnt.ntrelation.friendsinfo.bean;

import android.text.TextUtils;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.activity.NotificationActivity;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.vas.vipav.api.VipFunCallConstants;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.ntrelation.api.IFriendsTABService;
import java.lang.reflect.Field;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0017\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0005\n\u0002\b\n\n\u0002\u0010\t\n\u0002\b3\n\u0002\u0010\u0012\n\u0002\b\u001a\b\u0016\u0018\u0000 ;2\u00020\u0001:\u0001\u000eB\u001b\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0006\u00a2\u0006\u0004\b}\u0010~J\u0006\u0010\u0003\u001a\u00020\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006J\u0006\u0010\b\u001a\u00020\u0002J\u000e\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0002J\b\u0010\u000b\u001a\u00020\u0006H\u0016R\"\u0010\u0012\u001a\u00020\u00068\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\"\u0010\u0016\u001a\u00020\u00068\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\b\u0013\u0010\r\u001a\u0004\b\u0014\u0010\u000f\"\u0004\b\u0015\u0010\u0011R$\u0010\u0019\u001a\u0004\u0018\u00010\u00068\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\b\u0007\u0010\r\u001a\u0004\b\u0017\u0010\u000f\"\u0004\b\u0018\u0010\u0011R$\u0010\u001d\u001a\u0004\u0018\u00010\u00068\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\b\u001a\u0010\r\u001a\u0004\b\u001b\u0010\u000f\"\u0004\b\u001c\u0010\u0011R\"\u0010%\u001a\u00020\u001e8\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R$\u0010,\u001a\u0004\u0018\u00010&8\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\b\b\u0010'\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\"\u00100\u001a\u00020\u001e8\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\b-\u0010 \u001a\u0004\b.\u0010\"\"\u0004\b/\u0010$R\"\u00108\u001a\u0002018\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\b2\u00103\u001a\u0004\b4\u00105\"\u0004\b6\u00107R$\u0010<\u001a\u0004\u0018\u00010\u00068\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\b9\u0010\r\u001a\u0004\b:\u0010\u000f\"\u0004\b;\u0010\u0011R$\u0010?\u001a\u0004\u0018\u00010&8\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\b \u0010'\u001a\u0004\b=\u0010)\"\u0004\b>\u0010+R\"\u0010B\u001a\u00020\u001e8\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\b3\u0010 \u001a\u0004\b@\u0010\"\"\u0004\bA\u0010$R\"\u0010F\u001a\u00020\u001e8\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\bC\u0010 \u001a\u0004\bD\u0010\"\"\u0004\bE\u0010$R$\u0010J\u001a\u0004\u0018\u00010\u00068\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\bG\u0010\r\u001a\u0004\bH\u0010\u000f\"\u0004\bI\u0010\u0011R\"\u0010M\u001a\u00020\u001e8\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010 \u001a\u0004\bK\u0010\"\"\u0004\bL\u0010$R$\u0010Q\u001a\u0004\u0018\u00010\u00068\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\bN\u0010\r\u001a\u0004\bO\u0010\u000f\"\u0004\bP\u0010\u0011R\"\u0010U\u001a\u00020\u001e8\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\bR\u0010 \u001a\u0004\bS\u0010\"\"\u0004\bT\u0010$R$\u0010\\\u001a\u0004\u0018\u00010\u00028\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\bV\u0010W\u001a\u0004\bX\u0010Y\"\u0004\bZ\u0010[R$\u0010`\u001a\u0004\u0018\u00010\u00028\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\b]\u0010W\u001a\u0004\b^\u0010Y\"\u0004\b_\u0010[R\"\u0010d\u001a\u0002018\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\ba\u00103\u001a\u0004\bb\u00105\"\u0004\bc\u00107R$\u0010l\u001a\u0004\u0018\u00010e8\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\bf\u0010g\u001a\u0004\bh\u0010i\"\u0004\bj\u0010kR$\u0010o\u001a\u0004\u0018\u00010\u00028\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\bm\u0010W\u001a\u0004\bn\u0010Y\"\u0004\bN\u0010[R.\u0010s\u001a\u0004\u0018\u00010\u00062\b\u0010p\u001a\u0004\u0018\u00010\u00068\u0016@VX\u0096\u000e\u00a2\u0006\u0012\n\u0004\bA\u0010\r\u001a\u0004\bq\u0010\u000f\"\u0004\br\u0010\u0011R$\u0010v\u001a\u0004\u0018\u00010\u00028\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\bt\u0010W\u001a\u0004\b\u001a\u0010Y\"\u0004\bu\u0010[R$\u0010y\u001a\u0004\u0018\u00010\u00028\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\bw\u0010W\u001a\u0004\b2\u0010Y\"\u0004\bx\u0010[R$\u0010|\u001a\u0004\u0018\u00010\u00028\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\bz\u0010W\u001a\u0004\b-\u0010Y\"\u0004\b{\u0010[\u00a8\u0006\u007f"}, d2 = {"Lcom/tencent/qqnt/ntrelation/friendsinfo/bean/d;", "Lcom/tencent/qqnt/ntrelation/baseinfo/bean/a;", "", "B", "", "M", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "E", "isShield", "r0", "toString", h.F, "Ljava/lang/String;", "a", "()Ljava/lang/String;", "v0", "(Ljava/lang/String;)V", "uid", "i", HippyTKDListViewAdapter.X, "w0", "uin", "p", "k0", "nick", BdhLogUtil.LogTag.Tag_Conn, "r", "m0", "remark", "", "D", "I", "w", "()I", "u0", "(I)V", "status", "", "Ljava/lang/Byte;", "e", "()Ljava/lang/Byte;", "c0", "(Ljava/lang/Byte;)V", AppConstants.Key.CSPECIAL_FLAG, UserInfo.SEX_FEMALE, "f", "d0", "categoryId", "", "G", "J", "l", "()J", "g0", "(J)V", "datetime", "H", "c", "Z", NotificationActivity.KEY_ALIAS, DomainData.DOMAIN_NAME, "h0", "gathtertype", "b", "V", "age", "K", "v", "q0", "sex", "L", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "l0", "recommendReason", "j", "e0", "comparePartInt", "N", "k", "f0", "compareSpell", "P", "o", "j0", "multiFlags", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Ljava/lang/Boolean;", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "()Ljava/lang/Boolean;", "a0", "(Ljava/lang/Boolean;)V", "isBlock", BdhLogUtil.LogTag.Tag_Req, ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "b0", "isBlocked", ExifInterface.LATITUDE_SOUTH, "t", "o0", "richTime", "", "T", "[B", ReportConstant.COSTREPORT_PREFIX, "()[B", "n0", "([B)V", "richBuffer", "U", "y", "isAdded2C2C", "value", "u", "p0", VipFunCallConstants.KEY_RING_ID, "W", "i0", "isMsgDisturb", "X", "t0", "isSpecialCareZone", "Y", "s0", "isSpecialCareOpen", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "contacts_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes22.dex */
public class d extends com.tencent.qqnt.ntrelation.baseinfo.bean.a {
    static IPatchRedirector $redirector_;

    /* renamed from: Z, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private String remark;

    /* renamed from: D, reason: from kotlin metadata */
    private int status;

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private Byte cSpecialFlag;

    /* renamed from: F, reason: from kotlin metadata */
    private int categoryId;

    /* renamed from: G, reason: from kotlin metadata */
    private long datetime;

    /* renamed from: H, reason: from kotlin metadata */
    @Nullable
    private String alias;

    /* renamed from: I, reason: from kotlin metadata */
    @Nullable
    private Byte gathtertype;

    /* renamed from: J, reason: from kotlin metadata */
    private int age;

    /* renamed from: K, reason: from kotlin metadata */
    private int sex;

    /* renamed from: L, reason: from kotlin metadata */
    @Nullable
    private String recommendReason;

    /* renamed from: M, reason: from kotlin metadata */
    private int comparePartInt;

    /* renamed from: N, reason: from kotlin metadata */
    @Nullable
    private String compareSpell;

    /* renamed from: P, reason: from kotlin metadata */
    private int multiFlags;

    /* renamed from: Q, reason: from kotlin metadata */
    @Nullable
    private Boolean isBlock;

    /* renamed from: R, reason: from kotlin metadata */
    @Nullable
    private Boolean isBlocked;

    /* renamed from: S, reason: from kotlin metadata */
    private long richTime;

    /* renamed from: T, reason: from kotlin metadata */
    @Nullable
    private byte[] richBuffer;

    /* renamed from: U, reason: from kotlin metadata */
    @Nullable
    private Boolean isAdded2C2C;

    /* renamed from: V, reason: from kotlin metadata */
    @Nullable
    private String ringId;

    /* renamed from: W, reason: from kotlin metadata */
    @Nullable
    private Boolean isMsgDisturb;

    /* renamed from: X, reason: from kotlin metadata */
    @Nullable
    private Boolean isSpecialCareZone;

    /* renamed from: Y, reason: from kotlin metadata */
    @Nullable
    private Boolean isSpecialCareOpen;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String uid;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String uin;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String nick;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fR\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0004R\u0014\u0010\t\u001a\u00020\b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\t\u0010\n\u00a8\u0006\r"}, d2 = {"Lcom/tencent/qqnt/ntrelation/friendsinfo/bean/d$a;", "", "", "GATHER_TYPE_GATHERED", "I", "GATHER_TYPE_NORMAL", "GATHER_TYPE_RECOMMENDED", "MULTI_FLAGS_MASK_SHIELD", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "contacts_api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.ntrelation.friendsinfo.bean.d$a, reason: from kotlin metadata */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(37481);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 60)) {
            redirector.redirect((short) 60);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public d() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 59)) {
            return;
        }
        iPatchRedirector.redirect((short) 59, (Object) this);
    }

    @Nullable
    public Boolean A() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 37)) {
            return (Boolean) iPatchRedirector.redirect((short) 37, (Object) this);
        }
        return this.isBlocked;
    }

    public final boolean B() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 53)) {
            return ((Boolean) iPatchRedirector.redirect((short) 53, (Object) this)).booleanValue();
        }
        if (f() >= 0) {
            return true;
        }
        return false;
    }

    @Nullable
    public Boolean C() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 47)) {
            return (Boolean) iPatchRedirector.redirect((short) 47, (Object) this);
        }
        return this.isMsgDisturb;
    }

    public final boolean E() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 56)) {
            return ((Boolean) iPatchRedirector.redirect((short) 56, (Object) this)).booleanValue();
        }
        if ((o() & 1) > 0) {
            return true;
        }
        return false;
    }

    @Nullable
    public Boolean F() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 51)) {
            return (Boolean) iPatchRedirector.redirect((short) 51, (Object) this);
        }
        return this.isSpecialCareOpen;
    }

    @Nullable
    public Boolean G() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 49)) {
            return (Boolean) iPatchRedirector.redirect((short) 49, (Object) this);
        }
        return this.isSpecialCareZone;
    }

    public void M() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 54)) {
            iPatchRedirector.redirect((short) 54, (Object) this);
            return;
        }
        k0(null);
        m0(null);
        u0(Integer.MIN_VALUE);
        c0(null);
        d0(Integer.MIN_VALUE);
        g0(Long.MIN_VALUE);
        Z(null);
        h0(null);
        V(Integer.MIN_VALUE);
        q0(Integer.MIN_VALUE);
        l0(null);
        e0(Integer.MIN_VALUE);
        f0(null);
        j0(Integer.MIN_VALUE);
        a0(null);
        b0(null);
        o0(Long.MIN_VALUE);
        n0(null);
        N(null);
        p0(null);
        i0(null);
        t0(null);
        s0(null);
    }

    public void N(@Nullable Boolean bool) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 44)) {
            iPatchRedirector.redirect((short) 44, (Object) this, (Object) bool);
        } else {
            this.isAdded2C2C = bool;
        }
    }

    public void V(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, (Object) this, i3);
        } else {
            this.age = i3;
        }
    }

    public void Z(@Nullable String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this, (Object) str);
        } else {
            this.alias = str;
        }
    }

    @Override // com.tencent.qqnt.ntrelation.baseinfo.bean.a
    @NotNull
    /* renamed from: a */
    public String getUid() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.uid;
    }

    public void a0(@Nullable Boolean bool) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 36)) {
            iPatchRedirector.redirect((short) 36, (Object) this, (Object) bool);
        } else {
            this.isBlock = bool;
        }
    }

    public int b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return ((Integer) iPatchRedirector.redirect((short) 23, (Object) this)).intValue();
        }
        return this.age;
    }

    public void b0(@Nullable Boolean bool) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 38)) {
            iPatchRedirector.redirect((short) 38, (Object) this, (Object) bool);
        } else {
            this.isBlocked = bool;
        }
    }

    @Nullable
    public String c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return (String) iPatchRedirector.redirect((short) 19, (Object) this);
        }
        return this.alias;
    }

    public void c0(@Nullable Byte b16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) b16);
        } else {
            this.cSpecialFlag = b16;
        }
    }

    public void d0(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, i3);
        } else {
            this.categoryId = i3;
        }
    }

    @Nullable
    public Byte e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (Byte) iPatchRedirector.redirect((short) 13, (Object) this);
        }
        return this.cSpecialFlag;
    }

    public void e0(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            iPatchRedirector.redirect((short) 30, (Object) this, i3);
        } else {
            this.comparePartInt = i3;
        }
    }

    public int f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Integer) iPatchRedirector.redirect((short) 15, (Object) this)).intValue();
        }
        return this.categoryId;
    }

    public void f0(@Nullable String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            iPatchRedirector.redirect((short) 32, (Object) this, (Object) str);
        } else {
            this.compareSpell = str;
        }
    }

    public void g0(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, j3);
        } else {
            this.datetime = j3;
        }
    }

    public void h0(@Nullable Byte b16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this, (Object) b16);
        } else {
            this.gathtertype = b16;
        }
    }

    public void i0(@Nullable Boolean bool) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 48)) {
            iPatchRedirector.redirect((short) 48, (Object) this, (Object) bool);
        } else {
            this.isMsgDisturb = bool;
        }
    }

    public int j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            return ((Integer) iPatchRedirector.redirect((short) 29, (Object) this)).intValue();
        }
        return this.comparePartInt;
    }

    public void j0(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
            iPatchRedirector.redirect((short) 34, (Object) this, i3);
        } else {
            this.multiFlags = i3;
        }
    }

    @Nullable
    public String k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            return (String) iPatchRedirector.redirect((short) 31, (Object) this);
        }
        return this.compareSpell;
    }

    public void k0(@Nullable String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) str);
        } else {
            this.nick = str;
        }
    }

    public long l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return ((Long) iPatchRedirector.redirect((short) 17, (Object) this)).longValue();
        }
        return this.datetime;
    }

    public void l0(@Nullable String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            iPatchRedirector.redirect((short) 28, (Object) this, (Object) str);
        } else {
            this.recommendReason = str;
        }
    }

    @Nullable
    public final String m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 55)) {
            return (String) iPatchRedirector.redirect((short) 55, (Object) this);
        }
        if (!TextUtils.isEmpty(r())) {
            return r();
        }
        if (!TextUtils.isEmpty(p())) {
            return p();
        }
        return x();
    }

    public void m0(@Nullable String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) str);
        } else {
            this.remark = str;
        }
    }

    @Nullable
    public Byte n() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return (Byte) iPatchRedirector.redirect((short) 21, (Object) this);
        }
        return this.gathtertype;
    }

    public void n0(@Nullable byte[] bArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 42)) {
            iPatchRedirector.redirect((short) 42, (Object) this, (Object) bArr);
        } else {
            this.richBuffer = bArr;
        }
    }

    public int o() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            return ((Integer) iPatchRedirector.redirect((short) 33, (Object) this)).intValue();
        }
        return this.multiFlags;
    }

    public void o0(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 40)) {
            iPatchRedirector.redirect((short) 40, (Object) this, j3);
        } else {
            this.richTime = j3;
        }
    }

    @Nullable
    public String p() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (String) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return this.nick;
    }

    public void p0(@Nullable String str) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 46)) {
            iPatchRedirector.redirect((short) 46, (Object) this, (Object) str);
            return;
        }
        if (str != null && str.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!z16 && !Intrinsics.areEqual(this.ringId, str) && !Intrinsics.areEqual(str, "null") && !Intrinsics.areEqual(str, "0")) {
            QLog.i("RingIdUpdate", 1, "[FriendSimpleInfo] this=" + hashCode() + " ringId=" + this.ringId + "->" + str);
        }
        this.ringId = str;
    }

    @Nullable
    public String q() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            return (String) iPatchRedirector.redirect((short) 27, (Object) this);
        }
        return this.recommendReason;
    }

    public void q0(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, (Object) this, i3);
        } else {
            this.sex = i3;
        }
    }

    @Nullable
    public String r() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (String) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return this.remark;
    }

    public final void r0(boolean isShield) {
        int o16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 57)) {
            iPatchRedirector.redirect((short) 57, (Object) this, isShield);
            return;
        }
        if (((IFriendsTABService) QRoute.api(IFriendsTABService.class)).shieldOptSwitch() && o() == Integer.MIN_VALUE) {
            QLog.i("NTFriendSimpleInfo", 1, "reset multiFlags == 0");
            j0(0);
        }
        QLog.i("NTFriendSimpleInfo", 1, " multiFlags " + o());
        if (isShield) {
            o16 = o() | 1;
        } else {
            o16 = o() & (-2);
        }
        j0(o16);
    }

    @Nullable
    public byte[] s() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 41)) {
            return (byte[]) iPatchRedirector.redirect((short) 41, (Object) this);
        }
        return this.richBuffer;
    }

    public void s0(@Nullable Boolean bool) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 52)) {
            iPatchRedirector.redirect((short) 52, (Object) this, (Object) bool);
        } else {
            this.isSpecialCareOpen = bool;
        }
    }

    public long t() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 39)) {
            return ((Long) iPatchRedirector.redirect((short) 39, (Object) this)).longValue();
        }
        return this.richTime;
    }

    public void t0(@Nullable Boolean bool) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 50)) {
            iPatchRedirector.redirect((short) 50, (Object) this, (Object) bool);
        } else {
            this.isSpecialCareZone = bool;
        }
    }

    @NotNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 58)) {
            return (String) iPatchRedirector.redirect((short) 58, (Object) this);
        }
        String str = "NTFriendSimpleInfo uin " + x() + " uid " + getUid() + " hashcode " + hashCode() + " ";
        Field[] allFields = getClass().getDeclaredFields();
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

    @Nullable
    public String u() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 45)) {
            return (String) iPatchRedirector.redirect((short) 45, (Object) this);
        }
        return this.ringId;
    }

    public void u0(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, i3);
        } else {
            this.status = i3;
        }
    }

    public int v() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            return ((Integer) iPatchRedirector.redirect((short) 25, (Object) this)).intValue();
        }
        return this.sex;
    }

    public void v0(@NotNull String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) str);
        } else {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.uid = str;
        }
    }

    public int w() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Integer) iPatchRedirector.redirect((short) 11, (Object) this)).intValue();
        }
        return this.status;
    }

    public void w0(@NotNull String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) str);
        } else {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.uin = str;
        }
    }

    @NotNull
    public String x() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.uin;
    }

    @Nullable
    public Boolean y() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 43)) {
            return (Boolean) iPatchRedirector.redirect((short) 43, (Object) this);
        }
        return this.isAdded2C2C;
    }

    @Nullable
    public Boolean z() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 35)) {
            return (Boolean) iPatchRedirector.redirect((short) 35, (Object) this);
        }
        return this.isBlock;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(@NotNull String uid, @NotNull String uin) {
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
        this.nick = "";
        this.remark = "";
        this.cSpecialFlag = (byte) 0;
        this.categoryId = -1;
        this.alias = "";
        this.gathtertype = (byte) 0;
        this.recommendReason = "";
        this.compareSpell = "";
        Boolean bool = Boolean.FALSE;
        this.isBlock = bool;
        this.isBlocked = bool;
        this.isAdded2C2C = bool;
        this.ringId = "";
        this.isMsgDisturb = bool;
        this.isSpecialCareZone = bool;
        this.isSpecialCareOpen = bool;
    }

    public /* synthetic */ d(String str, String str2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? "" : str, (i3 & 2) == 0 ? str2 : "");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, str, str2, Integer.valueOf(i3), defaultConstructorMarker);
    }
}
