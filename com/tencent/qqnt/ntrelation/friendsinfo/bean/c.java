package com.tencent.qqnt.ntrelation.friendsinfo.bean;

import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.activity.NotificationActivity;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.vas.vipav.api.VipFunCallConstants;
import java.lang.reflect.Field;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u001b\n\u0002\u0010\u0005\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b*\n\u0002\u0010\u0012\n\u0002\b\u001c\b\u0086\b\u0018\u00002\u00020\u0001B\u00ab\u0002\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010%\u001a\u00020\u0006\u0012\n\b\u0002\u0010,\u001a\u0004\u0018\u00010&\u0012\b\b\u0002\u0010/\u001a\u00020\u0006\u0012\b\b\u0002\u00106\u001a\u000200\u0012\n\b\u0002\u0010:\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010=\u001a\u0004\u0018\u00010&\u0012\b\b\u0002\u0010@\u001a\u00020\u0006\u0012\b\b\u0002\u0010D\u001a\u00020\u0006\u0012\n\b\u0002\u0010F\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010I\u001a\u00020\u0006\u0012\n\b\u0002\u0010L\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010O\u001a\u00020\u0006\u0012\n\b\u0002\u0010T\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010W\u001a\u0004\u0018\u00010\n\u0012\b\b\u0002\u0010Z\u001a\u000200\u0012\n\b\u0002\u0010a\u001a\u0004\u0018\u00010[\u0012\n\b\u0002\u0010d\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010f\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010h\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010k\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010n\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010p\u001a\u0004\u0018\u00010&\u00a2\u0006\u0004\br\u0010sB\t\b\u0016\u00a2\u0006\u0004\br\u0010tBS\b\u0016\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010%\u001a\u00020\u0006\u0012\b\b\u0002\u0010D\u001a\u00020\u0006\u0012\b\b\u0002\u0010u\u001a\u00020\n\u00a2\u0006\u0004\br\u0010vJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\t\u0010\u0007\u001a\u00020\u0006H\u00d6\u0001J\u0013\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u00d6\u0003R\"\u0010\u0012\u001a\u00020\u00028\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\"\u0010\u0016\u001a\u00020\u00028\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\b\u0013\u0010\r\u001a\u0004\b\u0014\u0010\u000f\"\u0004\b\u0015\u0010\u0011R$\u0010\u001a\u001a\u0004\u0018\u00010\u00028\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\b\u0017\u0010\r\u001a\u0004\b\u0018\u0010\u000f\"\u0004\b\u0019\u0010\u0011R$\u0010\u001e\u001a\u0004\u0018\u00010\u00028\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\b\u001b\u0010\r\u001a\u0004\b\u001c\u0010\u000f\"\u0004\b\u001d\u0010\u0011R\"\u0010%\u001a\u00020\u00068\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R$\u0010,\u001a\u0004\u0018\u00010&8\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*\"\u0004\b\u0017\u0010+R\"\u0010/\u001a\u00020\u00068\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\b-\u0010 \u001a\u0004\b.\u0010\"\"\u0004\b\u001b\u0010$R\"\u00106\u001a\u0002008\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\b1\u00102\u001a\u0004\b3\u00104\"\u0004\b-\u00105R$\u0010:\u001a\u0004\u0018\u00010\u00028\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\b7\u0010\r\u001a\u0004\b8\u0010\u000f\"\u0004\b9\u0010\u0011R$\u0010=\u001a\u0004\u0018\u00010&8\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\b;\u0010(\u001a\u0004\b<\u0010*\"\u0004\b1\u0010+R\"\u0010@\u001a\u00020\u00068\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\b\u0019\u0010 \u001a\u0004\b>\u0010\"\"\u0004\b?\u0010$R\"\u0010D\u001a\u00020\u00068\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\bA\u0010 \u001a\u0004\bB\u0010\"\"\u0004\bC\u0010$R$\u0010F\u001a\u0004\u0018\u00010\u00028\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\b\u001d\u0010\r\u001a\u0004\bE\u0010\u000f\"\u0004\bA\u0010\u0011R\"\u0010I\u001a\u00020\u00068\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\bG\u0010 \u001a\u0004\bH\u0010\"\"\u0004\b\u001f\u0010$R$\u0010L\u001a\u0004\u0018\u00010\u00028\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\bJ\u0010\r\u001a\u0004\bK\u0010\u000f\"\u0004\b'\u0010\u0011R\"\u0010O\u001a\u00020\u00068\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\bM\u0010 \u001a\u0004\bN\u0010\"\"\u0004\b;\u0010$R$\u0010T\u001a\u0004\u0018\u00010\n8\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\bC\u0010P\u001a\u0004\bQ\u0010R\"\u0004\b\f\u0010SR$\u0010W\u001a\u0004\u0018\u00010\n8\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\bU\u0010P\u001a\u0004\bV\u0010R\"\u0004\b\u0013\u0010SR\"\u0010Z\u001a\u0002008\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\bX\u00102\u001a\u0004\bY\u00104\"\u0004\bJ\u00105R$\u0010a\u001a\u0004\u0018\u00010[8\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\b\\\u0010]\u001a\u0004\b^\u0010_\"\u0004\bG\u0010`R$\u0010d\u001a\u0004\u0018\u00010\n8\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\b#\u0010P\u001a\u0004\bb\u0010R\"\u0004\bc\u0010SR$\u0010f\u001a\u0004\u0018\u00010\u00028\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\r\u001a\u0004\be\u0010\u000f\"\u0004\bM\u0010\u0011R$\u0010h\u001a\u0004\u0018\u00010\n8\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\b\u0015\u0010P\u001a\u0004\bg\u0010R\"\u0004\b7\u0010SR$\u0010k\u001a\u0004\u0018\u00010\n8\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\bi\u0010P\u001a\u0004\bj\u0010R\"\u0004\b\\\u0010SR$\u0010n\u001a\u0004\u0018\u00010\n8\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\bl\u0010P\u001a\u0004\bm\u0010R\"\u0004\bX\u0010SR$\u0010p\u001a\u0004\u0018\u00010&8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bo\u0010(\u001a\u0004\bp\u0010*\"\u0004\bq\u0010+\u00a8\u0006w"}, d2 = {"Lcom/tencent/qqnt/ntrelation/friendsinfo/bean/c;", "Lcom/tencent/qqnt/ntrelation/friendsinfo/bean/d;", "", "toString", "", "M", "", "hashCode", "", "other", "", "equals", "a0", "Ljava/lang/String;", "a", "()Ljava/lang/String;", "v0", "(Ljava/lang/String;)V", "uid", "b0", HippyTKDListViewAdapter.X, "w0", "uin", "c0", "p", "k0", "nick", "d0", "r", "m0", "remark", "e0", "I", "w", "()I", "u0", "(I)V", "status", "", "f0", "Ljava/lang/Byte;", "e", "()Ljava/lang/Byte;", "(Ljava/lang/Byte;)V", AppConstants.Key.CSPECIAL_FLAG, "g0", "f", "categoryId", "", "h0", "J", "l", "()J", "(J)V", "datetime", "i0", "c", "Z", NotificationActivity.KEY_ALIAS, "j0", DomainData.DOMAIN_NAME, "gathtertype", "b", "V", "age", "l0", "v", "q0", "sex", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "recommendReason", "n0", "j", "comparePartInt", "o0", "k", "compareSpell", "p0", "o", "multiFlags", "Ljava/lang/Boolean;", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "()Ljava/lang/Boolean;", "(Ljava/lang/Boolean;)V", "isBlock", "r0", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "isBlocked", "s0", "t", "richTime", "", "t0", "[B", ReportConstant.COSTREPORT_PREFIX, "()[B", "([B)V", "richBuffer", "y", "N", "isAdded2C2C", "u", VipFunCallConstants.KEY_RING_ID, BdhLogUtil.LogTag.Tag_Conn, "isMsgDisturb", "x0", "G", "isSpecialCareZone", "y0", UserInfo.SEX_FEMALE, "isSpecialCareOpen", "z0", "isRemark", "setRemark", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/Byte;IJLjava/lang/String;Ljava/lang/Byte;IILjava/lang/String;ILjava/lang/String;ILjava/lang/Boolean;Ljava/lang/Boolean;J[BLjava/lang/Boolean;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Byte;)V", "()V", "isBlack", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IIZ)V", "contacts_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes22.dex */
public final /* data */ class c extends d {
    static IPatchRedirector $redirector_;

    /* renamed from: a0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String uid;

    /* renamed from: b0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String uin;

    /* renamed from: c0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String nick;

    /* renamed from: d0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String remark;

    /* renamed from: e0, reason: collision with root package name and from kotlin metadata */
    private int status;

    /* renamed from: f0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Byte cSpecialFlag;

    /* renamed from: g0, reason: collision with root package name and from kotlin metadata */
    private int categoryId;

    /* renamed from: h0, reason: collision with root package name and from kotlin metadata */
    private long datetime;

    /* renamed from: i0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String alias;

    /* renamed from: j0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Byte gathtertype;

    /* renamed from: k0, reason: collision with root package name and from kotlin metadata */
    private int age;

    /* renamed from: l0, reason: collision with root package name and from kotlin metadata */
    private int sex;

    /* renamed from: m0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String recommendReason;

    /* renamed from: n0, reason: collision with root package name and from kotlin metadata */
    private int comparePartInt;

    /* renamed from: o0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String compareSpell;

    /* renamed from: p0, reason: collision with root package name and from kotlin metadata */
    private int multiFlags;

    /* renamed from: q0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Boolean isBlock;

    /* renamed from: r0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Boolean isBlocked;

    /* renamed from: s0, reason: collision with root package name and from kotlin metadata */
    private long richTime;

    /* renamed from: t0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private byte[] richBuffer;

    /* renamed from: u0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Boolean isAdded2C2C;

    /* renamed from: v0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String ringId;

    /* renamed from: w0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Boolean isMsgDisturb;

    /* renamed from: x0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Boolean isSpecialCareZone;

    /* renamed from: y0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Boolean isSpecialCareOpen;

    /* renamed from: z0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Byte isRemark;

    public /* synthetic */ c(String str, String str2, String str3, String str4, int i3, Byte b16, int i16, long j3, String str5, Byte b17, int i17, int i18, String str6, int i19, String str7, int i26, Boolean bool, Boolean bool2, long j16, byte[] bArr, Boolean bool3, String str8, Boolean bool4, Boolean bool5, Boolean bool6, Byte b18, int i27, DefaultConstructorMarker defaultConstructorMarker) {
        this((i27 & 1) != 0 ? "" : str, (i27 & 2) != 0 ? "" : str2, (i27 & 4) != 0 ? "" : str3, (i27 & 8) != 0 ? "" : str4, (i27 & 16) != 0 ? 10 : i3, (i27 & 32) != 0 ? (byte) 0 : b16, (i27 & 64) != 0 ? -1 : i16, (i27 & 128) != 0 ? 0L : j3, (i27 & 256) != 0 ? "" : str5, (i27 & 512) != 0 ? (byte) 0 : b17, (i27 & 1024) != 0 ? 0 : i17, (i27 & 2048) != 0 ? 0 : i18, (i27 & 4096) != 0 ? "" : str6, (i27 & 8192) != 0 ? 0 : i19, (i27 & 16384) != 0 ? "" : str7, (32768 & i27) != 0 ? 0 : i26, (65536 & i27) != 0 ? Boolean.FALSE : bool, (131072 & i27) != 0 ? Boolean.FALSE : bool2, (262144 & i27) != 0 ? 0L : j16, (524288 & i27) != 0 ? null : bArr, (1048576 & i27) != 0 ? Boolean.FALSE : bool3, (2097152 & i27) == 0 ? str8 : "", (4194304 & i27) != 0 ? Boolean.FALSE : bool4, (8388608 & i27) != 0 ? Boolean.FALSE : bool5, (16777216 & i27) != 0 ? Boolean.FALSE : bool6, (33554432 & i27) != 0 ? (byte) 1 : b18);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, str, str2, str3, str4, Integer.valueOf(i3), b16, Integer.valueOf(i16), Long.valueOf(j3), str5, b17, Integer.valueOf(i17), Integer.valueOf(i18), str6, Integer.valueOf(i19), str7, Integer.valueOf(i26), bool, bool2, Long.valueOf(j16), bArr, bool3, str8, bool4, bool5, bool6, b18, Integer.valueOf(i27), defaultConstructorMarker);
    }

    @Override // com.tencent.qqnt.ntrelation.friendsinfo.bean.d
    @Nullable
    public Boolean A() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 37)) {
            return (Boolean) iPatchRedirector.redirect((short) 37, (Object) this);
        }
        return this.isBlocked;
    }

    @Override // com.tencent.qqnt.ntrelation.friendsinfo.bean.d
    @Nullable
    public Boolean C() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 47)) {
            return (Boolean) iPatchRedirector.redirect((short) 47, (Object) this);
        }
        return this.isMsgDisturb;
    }

    @Override // com.tencent.qqnt.ntrelation.friendsinfo.bean.d
    @Nullable
    public Boolean F() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 51)) {
            return (Boolean) iPatchRedirector.redirect((short) 51, (Object) this);
        }
        return this.isSpecialCareOpen;
    }

    @Override // com.tencent.qqnt.ntrelation.friendsinfo.bean.d
    @Nullable
    public Boolean G() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 49)) {
            return (Boolean) iPatchRedirector.redirect((short) 49, (Object) this);
        }
        return this.isSpecialCareZone;
    }

    @Override // com.tencent.qqnt.ntrelation.friendsinfo.bean.d
    public void M() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 59)) {
            iPatchRedirector.redirect((short) 59, (Object) this);
        } else {
            super.M();
            this.isRemark = null;
        }
    }

    @Override // com.tencent.qqnt.ntrelation.friendsinfo.bean.d
    public void N(@Nullable Boolean bool) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 44)) {
            iPatchRedirector.redirect((short) 44, (Object) this, (Object) bool);
        } else {
            this.isAdded2C2C = bool;
        }
    }

    @Override // com.tencent.qqnt.ntrelation.friendsinfo.bean.d
    public void V(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, (Object) this, i3);
        } else {
            this.age = i3;
        }
    }

    @Override // com.tencent.qqnt.ntrelation.friendsinfo.bean.d
    public void Z(@Nullable String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this, (Object) str);
        } else {
            this.alias = str;
        }
    }

    @Override // com.tencent.qqnt.ntrelation.friendsinfo.bean.d, com.tencent.qqnt.ntrelation.baseinfo.bean.a
    @NotNull
    /* renamed from: a */
    public String getUid() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.uid;
    }

    @Override // com.tencent.qqnt.ntrelation.friendsinfo.bean.d
    public void a0(@Nullable Boolean bool) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 36)) {
            iPatchRedirector.redirect((short) 36, (Object) this, (Object) bool);
        } else {
            this.isBlock = bool;
        }
    }

    @Override // com.tencent.qqnt.ntrelation.friendsinfo.bean.d
    public int b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return ((Integer) iPatchRedirector.redirect((short) 23, (Object) this)).intValue();
        }
        return this.age;
    }

    @Override // com.tencent.qqnt.ntrelation.friendsinfo.bean.d
    public void b0(@Nullable Boolean bool) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 38)) {
            iPatchRedirector.redirect((short) 38, (Object) this, (Object) bool);
        } else {
            this.isBlocked = bool;
        }
    }

    @Override // com.tencent.qqnt.ntrelation.friendsinfo.bean.d
    @Nullable
    public String c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return (String) iPatchRedirector.redirect((short) 19, (Object) this);
        }
        return this.alias;
    }

    @Override // com.tencent.qqnt.ntrelation.friendsinfo.bean.d
    public void c0(@Nullable Byte b16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) b16);
        } else {
            this.cSpecialFlag = b16;
        }
    }

    @Override // com.tencent.qqnt.ntrelation.friendsinfo.bean.d
    public void d0(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, i3);
        } else {
            this.categoryId = i3;
        }
    }

    @Override // com.tencent.qqnt.ntrelation.friendsinfo.bean.d
    @Nullable
    public Byte e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (Byte) iPatchRedirector.redirect((short) 13, (Object) this);
        }
        return this.cSpecialFlag;
    }

    @Override // com.tencent.qqnt.ntrelation.friendsinfo.bean.d
    public void e0(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            iPatchRedirector.redirect((short) 30, (Object) this, i3);
        } else {
            this.comparePartInt = i3;
        }
    }

    public boolean equals(@Nullable Object other) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 88)) {
            return ((Boolean) iPatchRedirector.redirect((short) 88, (Object) this, other)).booleanValue();
        }
        if (this == other) {
            return true;
        }
        if (!(other instanceof c)) {
            return false;
        }
        c cVar = (c) other;
        if (Intrinsics.areEqual(getUid(), cVar.getUid()) && Intrinsics.areEqual(x(), cVar.x()) && Intrinsics.areEqual(p(), cVar.p()) && Intrinsics.areEqual(r(), cVar.r()) && w() == cVar.w() && Intrinsics.areEqual(e(), cVar.e()) && f() == cVar.f() && l() == cVar.l() && Intrinsics.areEqual(c(), cVar.c()) && Intrinsics.areEqual(n(), cVar.n()) && b() == cVar.b() && v() == cVar.v() && Intrinsics.areEqual(q(), cVar.q()) && j() == cVar.j() && Intrinsics.areEqual(k(), cVar.k()) && o() == cVar.o() && Intrinsics.areEqual(z(), cVar.z()) && Intrinsics.areEqual(A(), cVar.A()) && t() == cVar.t() && Intrinsics.areEqual(s(), cVar.s()) && Intrinsics.areEqual(y(), cVar.y()) && Intrinsics.areEqual(u(), cVar.u()) && Intrinsics.areEqual(C(), cVar.C()) && Intrinsics.areEqual(G(), cVar.G()) && Intrinsics.areEqual(F(), cVar.F()) && Intrinsics.areEqual(this.isRemark, cVar.isRemark)) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.qqnt.ntrelation.friendsinfo.bean.d
    public int f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Integer) iPatchRedirector.redirect((short) 15, (Object) this)).intValue();
        }
        return this.categoryId;
    }

    @Override // com.tencent.qqnt.ntrelation.friendsinfo.bean.d
    public void f0(@Nullable String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            iPatchRedirector.redirect((short) 32, (Object) this, (Object) str);
        } else {
            this.compareSpell = str;
        }
    }

    @Override // com.tencent.qqnt.ntrelation.friendsinfo.bean.d
    public void g0(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, j3);
        } else {
            this.datetime = j3;
        }
    }

    @Override // com.tencent.qqnt.ntrelation.friendsinfo.bean.d
    public void h0(@Nullable Byte b16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this, (Object) b16);
        } else {
            this.gathtertype = b16;
        }
    }

    public int hashCode() {
        int hashCode;
        int hashCode2;
        int hashCode3;
        int hashCode4;
        int hashCode5;
        int hashCode6;
        int hashCode7;
        int hashCode8;
        int hashCode9;
        int hashCode10;
        int hashCode11;
        int hashCode12;
        int hashCode13;
        int hashCode14;
        int hashCode15;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 87)) {
            return ((Integer) iPatchRedirector.redirect((short) 87, (Object) this)).intValue();
        }
        int hashCode16 = ((getUid().hashCode() * 31) + x().hashCode()) * 31;
        int i3 = 0;
        if (p() == null) {
            hashCode = 0;
        } else {
            hashCode = p().hashCode();
        }
        int i16 = (hashCode16 + hashCode) * 31;
        if (r() == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = r().hashCode();
        }
        int w3 = (((i16 + hashCode2) * 31) + w()) * 31;
        if (e() == null) {
            hashCode3 = 0;
        } else {
            hashCode3 = e().hashCode();
        }
        int f16 = (((((w3 + hashCode3) * 31) + f()) * 31) + androidx.fragment.app.a.a(l())) * 31;
        if (c() == null) {
            hashCode4 = 0;
        } else {
            hashCode4 = c().hashCode();
        }
        int i17 = (f16 + hashCode4) * 31;
        if (n() == null) {
            hashCode5 = 0;
        } else {
            hashCode5 = n().hashCode();
        }
        int b16 = (((((i17 + hashCode5) * 31) + b()) * 31) + v()) * 31;
        if (q() == null) {
            hashCode6 = 0;
        } else {
            hashCode6 = q().hashCode();
        }
        int j3 = (((b16 + hashCode6) * 31) + j()) * 31;
        if (k() == null) {
            hashCode7 = 0;
        } else {
            hashCode7 = k().hashCode();
        }
        int o16 = (((j3 + hashCode7) * 31) + o()) * 31;
        if (z() == null) {
            hashCode8 = 0;
        } else {
            hashCode8 = z().hashCode();
        }
        int i18 = (o16 + hashCode8) * 31;
        if (A() == null) {
            hashCode9 = 0;
        } else {
            hashCode9 = A().hashCode();
        }
        int a16 = (((i18 + hashCode9) * 31) + androidx.fragment.app.a.a(t())) * 31;
        if (s() == null) {
            hashCode10 = 0;
        } else {
            hashCode10 = Arrays.hashCode(s());
        }
        int i19 = (a16 + hashCode10) * 31;
        if (y() == null) {
            hashCode11 = 0;
        } else {
            hashCode11 = y().hashCode();
        }
        int i26 = (i19 + hashCode11) * 31;
        if (u() == null) {
            hashCode12 = 0;
        } else {
            hashCode12 = u().hashCode();
        }
        int i27 = (i26 + hashCode12) * 31;
        if (C() == null) {
            hashCode13 = 0;
        } else {
            hashCode13 = C().hashCode();
        }
        int i28 = (i27 + hashCode13) * 31;
        if (G() == null) {
            hashCode14 = 0;
        } else {
            hashCode14 = G().hashCode();
        }
        int i29 = (i28 + hashCode14) * 31;
        if (F() == null) {
            hashCode15 = 0;
        } else {
            hashCode15 = F().hashCode();
        }
        int i36 = (i29 + hashCode15) * 31;
        Byte b17 = this.isRemark;
        if (b17 != null) {
            i3 = b17.hashCode();
        }
        return i36 + i3;
    }

    @Override // com.tencent.qqnt.ntrelation.friendsinfo.bean.d
    public void i0(@Nullable Boolean bool) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 48)) {
            iPatchRedirector.redirect((short) 48, (Object) this, (Object) bool);
        } else {
            this.isMsgDisturb = bool;
        }
    }

    @Override // com.tencent.qqnt.ntrelation.friendsinfo.bean.d
    public int j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            return ((Integer) iPatchRedirector.redirect((short) 29, (Object) this)).intValue();
        }
        return this.comparePartInt;
    }

    @Override // com.tencent.qqnt.ntrelation.friendsinfo.bean.d
    public void j0(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
            iPatchRedirector.redirect((short) 34, (Object) this, i3);
        } else {
            this.multiFlags = i3;
        }
    }

    @Override // com.tencent.qqnt.ntrelation.friendsinfo.bean.d
    @Nullable
    public String k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            return (String) iPatchRedirector.redirect((short) 31, (Object) this);
        }
        return this.compareSpell;
    }

    @Override // com.tencent.qqnt.ntrelation.friendsinfo.bean.d
    public void k0(@Nullable String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) str);
        } else {
            this.nick = str;
        }
    }

    @Override // com.tencent.qqnt.ntrelation.friendsinfo.bean.d
    public long l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return ((Long) iPatchRedirector.redirect((short) 17, (Object) this)).longValue();
        }
        return this.datetime;
    }

    @Override // com.tencent.qqnt.ntrelation.friendsinfo.bean.d
    public void l0(@Nullable String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            iPatchRedirector.redirect((short) 28, (Object) this, (Object) str);
        } else {
            this.recommendReason = str;
        }
    }

    @Override // com.tencent.qqnt.ntrelation.friendsinfo.bean.d
    public void m0(@Nullable String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) str);
        } else {
            this.remark = str;
        }
    }

    @Override // com.tencent.qqnt.ntrelation.friendsinfo.bean.d
    @Nullable
    public Byte n() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return (Byte) iPatchRedirector.redirect((short) 21, (Object) this);
        }
        return this.gathtertype;
    }

    @Override // com.tencent.qqnt.ntrelation.friendsinfo.bean.d
    public void n0(@Nullable byte[] bArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 42)) {
            iPatchRedirector.redirect((short) 42, (Object) this, (Object) bArr);
        } else {
            this.richBuffer = bArr;
        }
    }

    @Override // com.tencent.qqnt.ntrelation.friendsinfo.bean.d
    public int o() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            return ((Integer) iPatchRedirector.redirect((short) 33, (Object) this)).intValue();
        }
        return this.multiFlags;
    }

    @Override // com.tencent.qqnt.ntrelation.friendsinfo.bean.d
    public void o0(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 40)) {
            iPatchRedirector.redirect((short) 40, (Object) this, j3);
        } else {
            this.richTime = j3;
        }
    }

    @Override // com.tencent.qqnt.ntrelation.friendsinfo.bean.d
    @Nullable
    public String p() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (String) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return this.nick;
    }

    @Override // com.tencent.qqnt.ntrelation.friendsinfo.bean.d
    public void p0(@Nullable String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 46)) {
            iPatchRedirector.redirect((short) 46, (Object) this, (Object) str);
        } else {
            this.ringId = str;
        }
    }

    @Override // com.tencent.qqnt.ntrelation.friendsinfo.bean.d
    @Nullable
    public String q() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            return (String) iPatchRedirector.redirect((short) 27, (Object) this);
        }
        return this.recommendReason;
    }

    @Override // com.tencent.qqnt.ntrelation.friendsinfo.bean.d
    public void q0(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, (Object) this, i3);
        } else {
            this.sex = i3;
        }
    }

    @Override // com.tencent.qqnt.ntrelation.friendsinfo.bean.d
    @Nullable
    public String r() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (String) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return this.remark;
    }

    @Override // com.tencent.qqnt.ntrelation.friendsinfo.bean.d
    @Nullable
    public byte[] s() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 41)) {
            return (byte[]) iPatchRedirector.redirect((short) 41, (Object) this);
        }
        return this.richBuffer;
    }

    @Override // com.tencent.qqnt.ntrelation.friendsinfo.bean.d
    public void s0(@Nullable Boolean bool) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 52)) {
            iPatchRedirector.redirect((short) 52, (Object) this, (Object) bool);
        } else {
            this.isSpecialCareOpen = bool;
        }
    }

    @Override // com.tencent.qqnt.ntrelation.friendsinfo.bean.d
    public long t() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 39)) {
            return ((Long) iPatchRedirector.redirect((short) 39, (Object) this)).longValue();
        }
        return this.richTime;
    }

    @Override // com.tencent.qqnt.ntrelation.friendsinfo.bean.d
    public void t0(@Nullable Boolean bool) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 50)) {
            iPatchRedirector.redirect((short) 50, (Object) this, (Object) bool);
        } else {
            this.isSpecialCareZone = bool;
        }
    }

    @Override // com.tencent.qqnt.ntrelation.friendsinfo.bean.d
    @NotNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 58)) {
            return (String) iPatchRedirector.redirect((short) 58, (Object) this);
        }
        String str = "NTFriendDetailInfo uin " + x() + " uid " + getUid() + "  richbuffer " + Arrays.toString(s()) + " ";
        Field[] allFields = c.class.getDeclaredFields();
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

    @Override // com.tencent.qqnt.ntrelation.friendsinfo.bean.d
    @Nullable
    public String u() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 45)) {
            return (String) iPatchRedirector.redirect((short) 45, (Object) this);
        }
        return this.ringId;
    }

    @Override // com.tencent.qqnt.ntrelation.friendsinfo.bean.d
    public void u0(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, i3);
        } else {
            this.status = i3;
        }
    }

    @Override // com.tencent.qqnt.ntrelation.friendsinfo.bean.d
    public int v() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            return ((Integer) iPatchRedirector.redirect((short) 25, (Object) this)).intValue();
        }
        return this.sex;
    }

    @Override // com.tencent.qqnt.ntrelation.friendsinfo.bean.d
    public void v0(@NotNull String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) str);
        } else {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.uid = str;
        }
    }

    @Override // com.tencent.qqnt.ntrelation.friendsinfo.bean.d
    public int w() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Integer) iPatchRedirector.redirect((short) 11, (Object) this)).intValue();
        }
        return this.status;
    }

    @Override // com.tencent.qqnt.ntrelation.friendsinfo.bean.d
    public void w0(@NotNull String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) str);
        } else {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.uin = str;
        }
    }

    @Override // com.tencent.qqnt.ntrelation.friendsinfo.bean.d
    @NotNull
    public String x() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.uin;
    }

    @Override // com.tencent.qqnt.ntrelation.friendsinfo.bean.d
    @Nullable
    public Boolean y() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 43)) {
            return (Boolean) iPatchRedirector.redirect((short) 43, (Object) this);
        }
        return this.isAdded2C2C;
    }

    @Override // com.tencent.qqnt.ntrelation.friendsinfo.bean.d
    @Nullable
    public Boolean z() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 35)) {
            return (Boolean) iPatchRedirector.redirect((short) 35, (Object) this);
        }
        return this.isBlock;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(@NotNull String uid, @NotNull String uin, @Nullable String str, @Nullable String str2, int i3, @Nullable Byte b16, int i16, long j3, @Nullable String str3, @Nullable Byte b17, int i17, int i18, @Nullable String str4, int i19, @Nullable String str5, int i26, @Nullable Boolean bool, @Nullable Boolean bool2, long j16, @Nullable byte[] bArr, @Nullable Boolean bool3, @Nullable String str6, @Nullable Boolean bool4, @Nullable Boolean bool5, @Nullable Boolean bool6, @Nullable Byte b18) {
        super(null, null, 3, null);
        Intrinsics.checkNotNullParameter(uid, "uid");
        Intrinsics.checkNotNullParameter(uin, "uin");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, uid, uin, str, str2, Integer.valueOf(i3), b16, Integer.valueOf(i16), Long.valueOf(j3), str3, b17, Integer.valueOf(i17), Integer.valueOf(i18), str4, Integer.valueOf(i19), str5, Integer.valueOf(i26), bool, bool2, Long.valueOf(j16), bArr, bool3, str6, bool4, bool5, bool6, b18);
            return;
        }
        this.uid = uid;
        this.uin = uin;
        this.nick = str;
        this.remark = str2;
        this.status = i3;
        this.cSpecialFlag = b16;
        this.categoryId = i16;
        this.datetime = j3;
        this.alias = str3;
        this.gathtertype = b17;
        this.age = i17;
        this.sex = i18;
        this.recommendReason = str4;
        this.comparePartInt = i19;
        this.compareSpell = str5;
        this.multiFlags = i26;
        this.isBlock = bool;
        this.isBlocked = bool2;
        this.richTime = j16;
        this.richBuffer = bArr;
        this.isAdded2C2C = bool3;
        this.ringId = str6;
        this.isMsgDisturb = bool4;
        this.isSpecialCareZone = bool5;
        this.isSpecialCareOpen = bool6;
        this.isRemark = b18;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public c() {
        this("", "", "", "", 10, r6, -1, 0L, "", r6, 0, 0, "", 0, "", 0, r25, r25, 0L, null, r25, "", r25, null, null, null, 58720256, null);
        byte b16 = (byte) 0;
        Boolean bool = Boolean.FALSE;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 55)) {
            return;
        }
        iPatchRedirector.redirect((short) 55, (Object) this);
    }

    public /* synthetic */ c(String str, String str2, String str3, String str4, int i3, int i16, boolean z16, int i17, DefaultConstructorMarker defaultConstructorMarker) {
        this((i17 & 1) != 0 ? "" : str, (i17 & 2) != 0 ? "" : str2, (i17 & 4) != 0 ? "" : str3, (i17 & 8) != 0 ? "" : str4, (i17 & 16) != 0 ? 10 : i3, (i17 & 32) != 0 ? 0 : i16, (i17 & 64) != 0 ? false : z16);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 57)) {
            return;
        }
        iPatchRedirector.redirect((short) 57, this, str, str2, str3, str4, Integer.valueOf(i3), Integer.valueOf(i16), Boolean.valueOf(z16), Integer.valueOf(i17), defaultConstructorMarker);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public c(@NotNull String uid, @NotNull String uin, @Nullable String str, @Nullable String str2, int i3, int i16, boolean z16) {
        this(uid, uin, str, str2, i3, r6, -1, 0L, "", r6, 0, i16, "", 0, "", 0, r18, r25, 0L, null, r25, "", r25, null, null, null, 58720256, null);
        Intrinsics.checkNotNullParameter(uid, "uid");
        Intrinsics.checkNotNullParameter(uin, "uin");
        byte b16 = (byte) 0;
        Boolean valueOf = Boolean.valueOf(z16);
        Boolean bool = Boolean.FALSE;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 56)) {
            return;
        }
        iPatchRedirector.redirect((short) 56, this, uid, uin, str, str2, Integer.valueOf(i3), Integer.valueOf(i16), Boolean.valueOf(z16));
    }
}
