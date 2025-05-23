package com.tencent.qqnt.ntrelation.intimateinfo.bean;

import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import java.lang.reflect.Field;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\u0012\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\r\b\u0016\u0018\u0000 O2\u00020\u0001:\u0001\tB\u001b\u0012\b\b\u0002\u0010\r\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0004\u00a2\u0006\u0004\bM\u0010NJ\u0006\u0010\u0003\u001a\u00020\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\u0006\u0010\u0006\u001a\u00020\u0004R\"\u0010\r\u001a\u00020\u00048\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\"\u0010\u0011\u001a\u00020\u00048\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\b\u000e\u0010\b\u001a\u0004\b\u000f\u0010\n\"\u0004\b\u0010\u0010\fR\"\u0010\u0019\u001a\u00020\u00128\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\"\u0010\u001d\u001a\u00020\u00128\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\b\u001a\u0010\u0014\u001a\u0004\b\u001b\u0010\u0016\"\u0004\b\u001c\u0010\u0018R\"\u0010!\u001a\u00020\u00128\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\b\u001e\u0010\u0014\u001a\u0004\b\u001f\u0010\u0016\"\u0004\b \u0010\u0018R\"\u0010)\u001a\u00020\"8\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R.\u00102\u001a\u0004\u0018\u00010*2\b\u0010+\u001a\u0004\u0018\u00010*8\u0016@VX\u0096\u000e\u00a2\u0006\u0012\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R.\u00105\u001a\u0004\u0018\u00010\u00042\b\u0010+\u001a\u0004\u0018\u00010\u00048\u0016@VX\u0096\u000e\u00a2\u0006\u0012\n\u0004\b3\u0010\b\u001a\u0004\b\u0013\u0010\n\"\u0004\b4\u0010\fR.\u0010=\u001a\u0004\u0018\u0001062\b\u0010+\u001a\u0004\u0018\u0001068\u0016@VX\u0096\u000e\u00a2\u0006\u0012\n\u0004\b7\u00108\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<R.\u0010@\u001a\u0004\u0018\u00010*2\b\u0010+\u001a\u0004\u0018\u00010*8\u0016@VX\u0096\u000e\u00a2\u0006\u0012\n\u0004\b\u0014\u0010-\u001a\u0004\b>\u0010/\"\u0004\b?\u00101R6\u0010I\u001a\u0016\u0012\u0004\u0012\u00020B\u0018\u00010Aj\n\u0012\u0004\u0012\u00020B\u0018\u0001`C8\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\b$\u0010D\u001a\u0004\bE\u0010F\"\u0004\bG\u0010HR\u0016\u0010L\u001a\u00020*8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bJ\u0010K\u00a8\u0006P"}, d2 = {"Lcom/tencent/qqnt/ntrelation/intimateinfo/bean/a;", "Lcom/tencent/qqnt/ntrelation/baseinfo/bean/a;", "", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "", "toString", "c", h.F, "Ljava/lang/String;", "a", "()Ljava/lang/String;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "(Ljava/lang/String;)V", "uid", "i", DomainData.DOMAIN_NAME, "B", "uin", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "I", "j", "()I", "v", "(I)V", "intimateType", BdhLogUtil.LogTag.Tag_Conn, "f", "u", "intimateLevel", "D", "e", "t", "intimateChatDays", "", "E", "J", "k", "()J", "w", "(J)V", "lastIntimatChatTime", "", "value", UserInfo.SEX_FEMALE, "Ljava/lang/Boolean;", "o", "()Ljava/lang/Boolean;", "r", "(Ljava/lang/Boolean;)V", "isExtinguish", "G", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "mutualMarkStoreJson", "", "H", "[B", "b", "()[B", ReportConstant.COSTREPORT_PREFIX, "([B)V", "iconFlag", "p", HippyTKDListViewAdapter.X, "isListenTogetherOpen", "Ljava/util/ArrayList;", "Lcom/tencent/qqnt/ntrelation/intimateinfo/bean/NTMutualMarkEntity;", "Lkotlin/collections/ArrayList;", "Ljava/util/ArrayList;", "l", "()Ljava/util/ArrayList;", "y", "(Ljava/util/ArrayList;)V", "mutualMarkList", "K", "Z", "canWriteNull", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "L", "contacts_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes22.dex */
public class a extends com.tencent.qqnt.ntrelation.baseinfo.bean.a {
    static IPatchRedirector $redirector_;

    /* renamed from: L, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    private int intimateLevel;

    /* renamed from: D, reason: from kotlin metadata */
    private int intimateChatDays;

    /* renamed from: E, reason: from kotlin metadata */
    private long lastIntimatChatTime;

    /* renamed from: F, reason: from kotlin metadata */
    @Nullable
    private Boolean isExtinguish;

    /* renamed from: G, reason: from kotlin metadata */
    @Nullable
    private String mutualMarkStoreJson;

    /* renamed from: H, reason: from kotlin metadata */
    @Nullable
    private byte[] iconFlag;

    /* renamed from: I, reason: from kotlin metadata */
    @Nullable
    private Boolean isListenTogetherOpen;

    /* renamed from: J, reason: from kotlin metadata */
    @Nullable
    private ArrayList<NTMutualMarkEntity> mutualMarkList;

    /* renamed from: K, reason: from kotlin metadata */
    private boolean canWriteNull;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String uid;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String uin;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private int intimateType;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004\u00a8\u0006\b"}, d2 = {"Lcom/tencent/qqnt/ntrelation/intimateinfo/bean/a$a;", "", "", "TYPE_FROM_CHAT", "I", "TYPE_FROM_CONTACT", "<init>", "()V", "contacts_api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.ntrelation.intimateinfo.bean.a$a, reason: collision with other inner class name and from kotlin metadata */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(37497);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 29)) {
            redirector.redirect((short) 29);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public a() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 28)) {
            return;
        }
        iPatchRedirector.redirect((short) 28, (Object) this);
    }

    public void A(@NotNull String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) str);
        } else {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.uid = str;
        }
    }

    public void B(@NotNull String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) str);
        } else {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.uin = str;
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

    @Nullable
    public byte[] b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return (byte[]) iPatchRedirector.redirect((short) 19, (Object) this);
        }
        return this.iconFlag;
    }

    @NotNull
    public final String c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            return (String) iPatchRedirector.redirect((short) 27, (Object) this);
        }
        byte[] b16 = b();
        if (b16 != null) {
            StringBuilder sb5 = new StringBuilder();
            for (byte b17 : b16) {
                sb5.append(((int) b17) + " ");
            }
            String sb6 = sb5.toString();
            Intrinsics.checkNotNullExpressionValue(sb6, "sb.toString()");
            return sb6;
        }
        return "0";
    }

    public int e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Integer) iPatchRedirector.redirect((short) 11, (Object) this)).intValue();
        }
        return this.intimateChatDays;
    }

    public int f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Integer) iPatchRedirector.redirect((short) 9, (Object) this)).intValue();
        }
        return this.intimateLevel;
    }

    public int j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this)).intValue();
        }
        return this.intimateType;
    }

    public long k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Long) iPatchRedirector.redirect((short) 13, (Object) this)).longValue();
        }
        return this.lastIntimatChatTime;
    }

    @Nullable
    public ArrayList<NTMutualMarkEntity> l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return (ArrayList) iPatchRedirector.redirect((short) 23, (Object) this);
        }
        return this.mutualMarkList;
    }

    @Nullable
    public String m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return (String) iPatchRedirector.redirect((short) 17, (Object) this);
        }
        return this.mutualMarkStoreJson;
    }

    @NotNull
    public String n() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.uin;
    }

    @Nullable
    public Boolean o() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return (Boolean) iPatchRedirector.redirect((short) 15, (Object) this);
        }
        return this.isExtinguish;
    }

    @Nullable
    public Boolean p() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return (Boolean) iPatchRedirector.redirect((short) 21, (Object) this);
        }
        return this.isListenTogetherOpen;
    }

    public final void q() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, (Object) this);
            return;
        }
        this.canWriteNull = false;
        v(Integer.MIN_VALUE);
        u(Integer.MIN_VALUE);
        t(Integer.MIN_VALUE);
        w(Long.MIN_VALUE);
        r(null);
        z(null);
        s(null);
        x(null);
        this.canWriteNull = true;
        y(null);
    }

    public void r(@Nullable Boolean bool) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, (Object) bool);
            return;
        }
        if (this.canWriteNull) {
            if (bool != null) {
                z16 = bool.booleanValue();
            } else {
                z16 = false;
            }
            bool = Boolean.valueOf(z16);
        }
        this.isExtinguish = bool;
    }

    public void s(@Nullable byte[] bArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this, (Object) bArr);
            return;
        }
        if (this.canWriteNull && bArr == null) {
            bArr = new byte[4];
        }
        this.iconFlag = bArr;
    }

    public void t(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, i3);
        } else {
            this.intimateChatDays = i3;
        }
    }

    @NotNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            return (String) iPatchRedirector.redirect((short) 26, (Object) this);
        }
        String str = "NTIntimateSimpleInfo uin " + n() + " uid " + getUid();
        Field[] allFields = getClass().getDeclaredFields();
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

    public void u(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, i3);
        } else {
            this.intimateLevel = i3;
        }
    }

    public void v(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, i3);
        } else {
            this.intimateType = i3;
        }
    }

    public void w(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, j3);
        } else {
            this.lastIntimatChatTime = j3;
        }
    }

    public void x(@Nullable Boolean bool) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this, (Object) bool);
            return;
        }
        if (this.canWriteNull) {
            if (bool != null) {
                z16 = bool.booleanValue();
            } else {
                z16 = false;
            }
            bool = Boolean.valueOf(z16);
        }
        this.isListenTogetherOpen = bool;
    }

    public void y(@Nullable ArrayList<NTMutualMarkEntity> arrayList) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, (Object) this, (Object) arrayList);
        } else {
            this.mutualMarkList = arrayList;
        }
    }

    public void z(@Nullable String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, (Object) str);
            return;
        }
        if (this.canWriteNull && str == null) {
            str = "";
        }
        this.mutualMarkStoreJson = str;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(@NotNull String uid, @NotNull String uin) {
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
        Boolean bool = Boolean.FALSE;
        this.isExtinguish = bool;
        this.mutualMarkStoreJson = "";
        this.isListenTogetherOpen = bool;
        this.mutualMarkList = new ArrayList<>();
        this.canWriteNull = true;
    }

    public /* synthetic */ a(String str, String str2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? "" : str, (i3 & 2) == 0 ? str2 : "");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, str, str2, Integer.valueOf(i3), defaultConstructorMarker);
    }
}
