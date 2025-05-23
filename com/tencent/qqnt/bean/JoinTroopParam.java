package com.tencent.qqnt.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qqnt.kernel.nativeinterface.ReqToGroup;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u001a\n\u0002\u0010\u0012\n\u0002\b\u001b\u0018\u0000 @2\u00020\u0001:\u0001\u0003B\u0011\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u00a2\u0006\u0004\b<\u0010=B\t\b\u0016\u00a2\u0006\u0004\b<\u0010>B/\b\u0016\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u000b\u0012\u0006\u0010\u001d\u001a\u00020\u0006\u0012\b\u0010!\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010%\u001a\u0004\u0018\u00010\u000b\u00a2\u0006\u0004\b<\u0010?J\u0006\u0010\u0003\u001a\u00020\u0002J\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\n\u001a\u00020\u0006H\u0016J\b\u0010\f\u001a\u00020\u000bH\u0016R$\u0010\u0013\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R$\u0010\u0016\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000f\u0010\u000e\u001a\u0004\b\u0014\u0010\u0010\"\u0004\b\u0015\u0010\u0012R\"\u0010\u001d\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR$\u0010!\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001e\u0010\u000e\u001a\u0004\b\u001f\u0010\u0010\"\u0004\b \u0010\u0012R$\u0010%\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\"\u0010\u000e\u001a\u0004\b#\u0010\u0010\"\u0004\b$\u0010\u0012R$\u0010-\u001a\u0004\u0018\u00010&8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\"\u00100\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b.\u0010\u0018\u001a\u0004\b/\u0010\u001a\"\u0004\b'\u0010\u001cR$\u00104\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b1\u0010\u000e\u001a\u0004\b2\u0010\u0010\"\u0004\b3\u0010\u0012R$\u00108\u001a\u0004\u0018\u00010&8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b5\u0010(\u001a\u0004\b6\u0010*\"\u0004\b7\u0010,R\"\u0010;\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b9\u0010\u0018\u001a\u0004\b:\u0010\u001a\"\u0004\b\u0017\u0010\u001c\u00a8\u0006A"}, d2 = {"Lcom/tencent/qqnt/bean/JoinTroopParam;", "Landroid/os/Parcelable;", "Lcom/tencent/qqnt/kernel/nativeinterface/ReqToGroup;", "a", "Landroid/os/Parcel;", "parcel", "", WadlProxyConsts.FLAGS, "", "writeToParcel", "describeContents", "", "toString", "d", "Ljava/lang/String;", "e", "()Ljava/lang/String;", "setTroopUin", "(Ljava/lang/String;)V", "troopUin", "getReason", "k", "reason", "f", "I", "getStatOption", "()I", "setStatOption", "(I)V", "statOption", h.F, "getAuthKey", "setAuthKey", "authKey", "i", "b", "setAuthSig", "authSig", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "[B", "getNewMemberMsg", "()[B", "j", "([B)V", "newMemberMsg", BdhLogUtil.LogTag.Tag_Conn, "getVerifyType", "verifyType", "D", "getVerifyToken", "l", "verifyToken", "E", "getJoinGroupTransInfo", "g", "joinGroupTransInfo", UserInfo.SEX_FEMALE, "c", "callbackId", "<init>", "(Landroid/os/Parcel;)V", "()V", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V", "CREATOR", "qqtroop-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class JoinTroopParam implements Parcelable {
    static IPatchRedirector $redirector_;

    /* renamed from: CREATOR, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    private int verifyType;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private String verifyToken;

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private byte[] joinGroupTransInfo;

    /* renamed from: F, reason: from kotlin metadata */
    private int callbackId;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String troopUin;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String reason;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private int statOption;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String authKey;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String authSig;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private byte[] newMemberMsg;

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u001f\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a2\u0006\u0004\b\t\u0010\n\u00a8\u0006\r"}, d2 = {"Lcom/tencent/qqnt/bean/JoinTroopParam$a;", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/qqnt/bean/JoinTroopParam;", "Landroid/os/Parcel;", "parcel", "a", "", "size", "", "b", "(I)[Lcom/tencent/qqnt/bean/JoinTroopParam;", "<init>", "()V", "qqtroop-api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.bean.JoinTroopParam$a, reason: from kotlin metadata */
    /* loaded from: classes23.dex */
    public static final class Companion implements Parcelable.Creator<JoinTroopParam> {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
                return;
            }
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) defaultConstructorMarker);
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public JoinTroopParam createFromParcel(@NotNull Parcel parcel) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (JoinTroopParam) iPatchRedirector.redirect((short) 2, (Object) this, (Object) parcel);
            }
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new JoinTroopParam(parcel);
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public JoinTroopParam[] newArray(int size) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (JoinTroopParam[]) iPatchRedirector.redirect((short) 3, (Object) this, size);
            }
            return new JoinTroopParam[size];
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(27475);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 28)) {
            redirector.redirect((short) 28);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public JoinTroopParam(@NotNull Parcel parcel) {
        this();
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this, (Object) parcel);
            return;
        }
        this.troopUin = parcel.readString();
        this.reason = parcel.readString();
        this.statOption = parcel.readInt();
        this.authKey = parcel.readString();
        this.authSig = parcel.readString();
        this.newMemberMsg = parcel.createByteArray();
        this.verifyType = parcel.readInt();
        this.verifyToken = parcel.readString();
        this.joinGroupTransInfo = parcel.createByteArray();
        this.callbackId = parcel.readInt();
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x001c, code lost:
    
        r1 = kotlin.text.StringsKt__StringNumberConversionsKt.toLongOrNull(r1);
     */
    @NotNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final ReqToGroup a() {
        long j3;
        Long longOrNull;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            return (ReqToGroup) iPatchRedirector.redirect((short) 24, (Object) this);
        }
        ReqToGroup reqToGroup = new ReqToGroup();
        String str = this.troopUin;
        if (str != null && longOrNull != null) {
            j3 = longOrNull.longValue();
        } else {
            j3 = 0;
        }
        reqToGroup.groupCode = j3;
        reqToGroup.sourceId = 3;
        reqToGroup.sourceSubId = this.statOption;
        reqToGroup.applyMsg = this.reason;
        reqToGroup.token = this.verifyToken;
        reqToGroup.auth = this.authSig;
        reqToGroup.noVerifyAuth = this.authKey;
        byte[] bArr = this.newMemberMsg;
        if (bArr != null) {
            reqToGroup.richMsg = bArr;
        }
        byte[] bArr2 = this.joinGroupTransInfo;
        if (bArr2 != null) {
            reqToGroup.transInfo = bArr2;
        }
        return reqToGroup;
    }

    @Nullable
    public final String b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (String) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return this.authSig;
    }

    public final int c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return ((Integer) iPatchRedirector.redirect((short) 19, (Object) this)).intValue();
        }
        return this.callbackId;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            return ((Integer) iPatchRedirector.redirect((short) 26, (Object) this)).intValue();
        }
        return 0;
    }

    @Nullable
    public final String e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            return (String) iPatchRedirector.redirect((short) 1, (Object) this);
        }
        return this.troopUin;
    }

    public final void f(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this, i3);
        } else {
            this.callbackId = i3;
        }
    }

    public final void g(@Nullable byte[] bArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, (Object) bArr);
        } else {
            this.joinGroupTransInfo = bArr;
        }
    }

    public final void j(@Nullable byte[] bArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) bArr);
        } else {
            this.newMemberMsg = bArr;
        }
    }

    public final void k(@Nullable String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) str);
        } else {
            this.reason = str;
        }
    }

    public final void l(@Nullable String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, (Object) str);
        } else {
            this.verifyToken = str;
        }
    }

    public final void m(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, i3);
        } else {
            this.verifyType = i3;
        }
    }

    @NotNull
    public String toString() {
        Integer num;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            return (String) iPatchRedirector.redirect((short) 27, (Object) this);
        }
        String str = this.troopUin;
        String str2 = this.reason;
        int i3 = this.statOption;
        String str3 = this.authKey;
        byte[] bArr = this.newMemberMsg;
        Integer num2 = null;
        if (bArr != null) {
            num = Integer.valueOf(bArr.length);
        } else {
            num = null;
        }
        int i16 = this.verifyType;
        String str4 = this.verifyToken;
        byte[] bArr2 = this.joinGroupTransInfo;
        if (bArr2 != null) {
            num2 = Integer.valueOf(bArr2.length);
        }
        return "tUin:" + str + ",reason:" + str2 + ",statOption:" + i3 + ",key:" + str3 + ",memMsgSize:" + num + ",type:" + i16 + ",token:" + str4 + ",tranSize:" + num2 + ",cId:" + this.callbackId;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, (Object) this, (Object) parcel, flags);
            return;
        }
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.troopUin);
        parcel.writeString(this.reason);
        parcel.writeInt(this.statOption);
        parcel.writeString(this.authKey);
        parcel.writeString(this.authSig);
        parcel.writeByteArray(this.newMemberMsg);
        parcel.writeInt(this.verifyType);
        parcel.writeString(this.verifyToken);
        parcel.writeByteArray(this.joinGroupTransInfo);
        parcel.writeInt(this.callbackId);
    }

    public JoinTroopParam() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 22)) {
            return;
        }
        iPatchRedirector.redirect((short) 22, (Object) this);
    }

    public JoinTroopParam(@Nullable String str, int i3, @Nullable String str2, @Nullable String str3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, this, str, Integer.valueOf(i3), str2, str3);
            return;
        }
        this.troopUin = str;
        this.statOption = i3;
        this.authKey = str2;
        this.authSig = str3;
    }
}
