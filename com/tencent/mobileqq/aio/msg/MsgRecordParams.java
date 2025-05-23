package com.tencent.mobileqq.aio.msg;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.android.parcel.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Parcelize
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u001b\b\u0087\b\u0018\u00002\u00020\u0001B;\u0012\u0006\u0010\u0015\u001a\u00020\u0010\u0012\u0006\u0010\u001a\u001a\u00020\u0004\u0012\u0006\u0010\u001d\u001a\u00020\u0004\u0012\u0006\u0010!\u001a\u00020\u0002\u0012\u0006\u0010#\u001a\u00020\u0010\u0012\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\u0000\u00a2\u0006\u0004\b)\u0010*J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003J\t\u0010\n\u001a\u00020\u0004H\u00d6\u0001J\u0019\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u0004H\u00d6\u0001R\u0017\u0010\u0015\u001a\u00020\u00108\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u0017\u0010\u001a\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u0017\u0010\u001d\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u001b\u0010\u0017\u001a\u0004\b\u001c\u0010\u0019R\u0017\u0010!\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b\u0016\u0010 R\u0017\u0010#\u001a\u00020\u00108\u0006\u00a2\u0006\f\n\u0004\b\"\u0010\u0012\u001a\u0004\b\u001b\u0010\u0014R\u0019\u0010(\u001a\u0004\u0018\u00010\u00008\u0006\u00a2\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'\u00a8\u0006+"}, d2 = {"Lcom/tencent/mobileqq/aio/msg/MsgRecordParams;", "Landroid/os/Parcelable;", "", "toString", "", "hashCode", "", "other", "", "equals", "describeContents", "Landroid/os/Parcel;", "parcel", WadlProxyConsts.FLAGS, "", "writeToParcel", "", "d", "J", "b", "()J", "msgId", "e", "I", "a", "()I", "chatType", "f", "g", "sendType", tl.h.F, "Ljava/lang/String;", "()Ljava/lang/String;", "peerUid", "i", "peerUin", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/aio/msg/MsgRecordParams;", "c", "()Lcom/tencent/mobileqq/aio/msg/MsgRecordParams;", HippyNestedScrollComponent.PRIORITY_PARENT, "<init>", "(JIILjava/lang/String;JLcom/tencent/mobileqq/aio/msg/MsgRecordParams;)V", "aio_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final /* data */ class MsgRecordParams implements Parcelable {
    static IPatchRedirector $redirector_;

    @NotNull
    public static final Parcelable.Creator<MsgRecordParams> CREATOR;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final long msgId;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final int chatType;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final int sendType;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String peerUid;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final long peerUin;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final MsgRecordParams parent;

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes11.dex */
    public static final class a implements Parcelable.Creator<MsgRecordParams> {
        static IPatchRedirector $redirector_;

        public a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final MsgRecordParams createFromParcel(@NotNull Parcel parcel) {
            MsgRecordParams createFromParcel;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (MsgRecordParams) iPatchRedirector.redirect((short) 3, (Object) this, (Object) parcel);
            }
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            long readLong = parcel.readLong();
            int readInt = parcel.readInt();
            int readInt2 = parcel.readInt();
            String readString = parcel.readString();
            long readLong2 = parcel.readLong();
            if (parcel.readInt() == 0) {
                createFromParcel = null;
            } else {
                createFromParcel = MsgRecordParams.CREATOR.createFromParcel(parcel);
            }
            return new MsgRecordParams(readLong, readInt, readInt2, readString, readLong2, createFromParcel);
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final MsgRecordParams[] newArray(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (MsgRecordParams[]) iPatchRedirector.redirect((short) 2, (Object) this, i3);
            }
            return new MsgRecordParams[i3];
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(48698);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 21)) {
            redirector.redirect((short) 21);
        } else {
            CREATOR = new a();
        }
    }

    public MsgRecordParams(long j3, int i3, int i16, @NotNull String peerUid, long j16, @Nullable MsgRecordParams msgRecordParams) {
        Intrinsics.checkNotNullParameter(peerUid, "peerUid");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Long.valueOf(j3), Integer.valueOf(i3), Integer.valueOf(i16), peerUid, Long.valueOf(j16), msgRecordParams);
            return;
        }
        this.msgId = j3;
        this.chatType = i3;
        this.sendType = i16;
        this.peerUid = peerUid;
        this.peerUin = j16;
        this.parent = msgRecordParams;
    }

    public final int a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        return this.chatType;
    }

    public final long b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Long) iPatchRedirector.redirect((short) 3, (Object) this)).longValue();
        }
        return this.msgId;
    }

    @Nullable
    public final MsgRecordParams c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (MsgRecordParams) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return this.parent;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return ((Integer) iPatchRedirector.redirect((short) 19, (Object) this)).intValue();
        }
        return 0;
    }

    @NotNull
    public final String e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.peerUid;
    }

    public boolean equals(@Nullable Object other) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return ((Boolean) iPatchRedirector.redirect((short) 18, (Object) this, other)).booleanValue();
        }
        if (this == other) {
            return true;
        }
        if (!(other instanceof MsgRecordParams)) {
            return false;
        }
        MsgRecordParams msgRecordParams = (MsgRecordParams) other;
        if (this.msgId == msgRecordParams.msgId && this.chatType == msgRecordParams.chatType && this.sendType == msgRecordParams.sendType && Intrinsics.areEqual(this.peerUid, msgRecordParams.peerUid) && this.peerUin == msgRecordParams.peerUin && Intrinsics.areEqual(this.parent, msgRecordParams.parent)) {
            return true;
        }
        return false;
    }

    public final long f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Long) iPatchRedirector.redirect((short) 7, (Object) this)).longValue();
        }
        return this.peerUin;
    }

    public final int g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
        }
        return this.sendType;
    }

    public int hashCode() {
        int hashCode;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return ((Integer) iPatchRedirector.redirect((short) 17, (Object) this)).intValue();
        }
        int a16 = ((((((((androidx.fragment.app.a.a(this.msgId) * 31) + this.chatType) * 31) + this.sendType) * 31) + this.peerUid.hashCode()) * 31) + androidx.fragment.app.a.a(this.peerUin)) * 31;
        MsgRecordParams msgRecordParams = this.parent;
        if (msgRecordParams == null) {
            hashCode = 0;
        } else {
            hashCode = msgRecordParams.hashCode();
        }
        return a16 + hashCode;
    }

    @NotNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return (String) iPatchRedirector.redirect((short) 16, (Object) this);
        }
        return "MsgRecordParams(msgId=" + this.msgId + ", chatType=" + this.chatType + ", sendType=" + this.sendType + ", peerUid=" + this.peerUid + ", peerUin=" + this.peerUin + ", parent=" + this.parent + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this, (Object) parcel, flags);
            return;
        }
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeLong(this.msgId);
        parcel.writeInt(this.chatType);
        parcel.writeInt(this.sendType);
        parcel.writeString(this.peerUid);
        parcel.writeLong(this.peerUin);
        MsgRecordParams msgRecordParams = this.parent;
        if (msgRecordParams == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            msgRecordParams.writeToParcel(parcel, flags);
        }
    }

    public /* synthetic */ MsgRecordParams(long j3, int i3, int i16, String str, long j16, MsgRecordParams msgRecordParams, int i17, DefaultConstructorMarker defaultConstructorMarker) {
        this(j3, i3, i16, str, j16, (i17 & 32) != 0 ? null : msgRecordParams);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, Long.valueOf(j3), Integer.valueOf(i3), Integer.valueOf(i16), str, Long.valueOf(j16), msgRecordParams, Integer.valueOf(i17), defaultConstructorMarker);
    }
}
