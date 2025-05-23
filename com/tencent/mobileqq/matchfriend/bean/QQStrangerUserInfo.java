package com.tencent.mobileqq.matchfriend.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.persistence.ConflictClause;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.uniqueConstraints;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;
import com.tencent.mobileqq.vaswebviewplugin.MessageRoamJsPlugin;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@KeepClassConstructor
@uniqueConstraints(clause = ConflictClause.REPLACE, columnNames = "chatType,tinyId,openId")
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000f\b\u0007\u0018\u0000 \u001e2\u00020\u00012\u00020\u0002:\u0001\u001fB\u0007\u00a2\u0006\u0004\b\u001b\u0010\u001cB\u0011\b\u0016\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u00a2\u0006\u0004\b\u001b\u0010\u001dJ\u0006\u0010\u0004\u001a\u00020\u0003J\u0018\u0010\n\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016J\b\u0010\u000b\u001a\u00020\u0007H\u0016R\u0016\u0010\f\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u0016\u0010\u000f\u001a\u00020\u000e8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0012\u001a\u00020\u00118\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0014\u001a\u00020\u00118\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0013R\u0016\u0010\u0015\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\rR\u0016\u0010\u0016\u001a\u00020\u00118\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0013R\u0016\u0010\u0017\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\rR\u0016\u0010\u0018\u001a\u00020\u00118\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0013R\u0016\u0010\u0019\u001a\u00020\u00118\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u0013R\u0016\u0010\u001a\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\r\u00a8\u0006 "}, d2 = {"Lcom/tencent/mobileqq/matchfriend/bean/QQStrangerUserInfo;", "Lcom/tencent/mobileqq/persistence/Entity;", "Landroid/os/Parcelable;", "", AppConstants.Key.COLUMN_IS_VALID, "Landroid/os/Parcel;", "parcel", "", WadlProxyConsts.FLAGS, "", "writeToParcel", "describeContents", "chatType", "I", "", "tinyId", "J", "", "openId", "Ljava/lang/String;", "nick", "gender", "avatar", "matchSource", "matchText", "onlineStatus", MessageRoamJsPlugin.USERTYPE, "<init>", "()V", "(Landroid/os/Parcel;)V", "CREATOR", "a", "matchfriend_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class QQStrangerUserInfo extends Entity implements Parcelable {
    static IPatchRedirector $redirector_;

    /* renamed from: CREATOR, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    @JvmField
    @NotNull
    public String avatar;

    @JvmField
    public int chatType;

    @JvmField
    public int gender;

    @JvmField
    public int matchSource;

    @JvmField
    @NotNull
    public String matchText;

    @JvmField
    @NotNull
    public String nick;

    @JvmField
    @NotNull
    public String onlineStatus;

    @JvmField
    @NotNull
    public String openId;

    @JvmField
    public long tinyId;

    @JvmField
    public int userType;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u001f\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a2\u0006\u0004\b\t\u0010\n\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/matchfriend/bean/QQStrangerUserInfo$a;", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mobileqq/matchfriend/bean/QQStrangerUserInfo;", "Landroid/os/Parcel;", "parcel", "a", "", "size", "", "b", "(I)[Lcom/tencent/mobileqq/matchfriend/bean/QQStrangerUserInfo;", "<init>", "()V", "matchfriend_api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.matchfriend.bean.QQStrangerUserInfo$a, reason: from kotlin metadata */
    /* loaded from: classes15.dex */
    public static final class Companion implements Parcelable.Creator<QQStrangerUserInfo> {
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
        public QQStrangerUserInfo createFromParcel(@NotNull Parcel parcel) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (QQStrangerUserInfo) iPatchRedirector.redirect((short) 2, (Object) this, (Object) parcel);
            }
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new QQStrangerUserInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public QQStrangerUserInfo[] newArray(int size) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (QQStrangerUserInfo[]) iPatchRedirector.redirect((short) 3, (Object) this, size);
            }
            return new QQStrangerUserInfo[size];
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(23017);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public QQStrangerUserInfo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.openId = "";
        this.nick = "";
        this.avatar = "";
        this.matchText = "";
        this.onlineStatus = "";
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
        }
        return 0;
    }

    public final boolean isValid() {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        if (this.chatType == 0 || this.tinyId == 0) {
            return false;
        }
        if (this.openId.length() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            return false;
        }
        return true;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) parcel, flags);
            return;
        }
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeInt(this.chatType);
        parcel.writeLong(this.tinyId);
        parcel.writeString(this.openId);
        parcel.writeString(this.nick);
        parcel.writeInt(this.gender);
        parcel.writeString(this.avatar);
        parcel.writeInt(this.matchSource);
        parcel.writeString(this.matchText);
        parcel.writeString(this.onlineStatus);
        parcel.writeInt(this.userType);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public QQStrangerUserInfo(@NotNull Parcel parcel) {
        this();
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) parcel);
            return;
        }
        this.chatType = parcel.readInt();
        this.tinyId = parcel.readLong();
        String readString = parcel.readString();
        this.openId = readString == null ? "" : readString;
        String readString2 = parcel.readString();
        this.nick = readString2 == null ? "" : readString2;
        this.gender = parcel.readInt();
        String readString3 = parcel.readString();
        this.avatar = readString3 == null ? "" : readString3;
        this.matchSource = parcel.readInt();
        String readString4 = parcel.readString();
        this.matchText = readString4 == null ? "" : readString4;
        String readString5 = parcel.readString();
        this.onlineStatus = readString5 != null ? readString5 : "";
        this.userType = parcel.readInt();
    }
}
