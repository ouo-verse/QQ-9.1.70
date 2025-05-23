package com.tencent.qqnt.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.troop.utils.bg;
import com.tencent.qqnt.kernel.nativeinterface.InviteGroupReq;
import com.tencent.qqnt.kernel.nativeinterface.InviteUidInfo;
import com.tencent.qqnt.kernel.nativeinterface.ShareMsgInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 )2\u00020\u0001:\u0001\u0003B\u0007\u00a2\u0006\u0004\b&\u0010'B\u0011\b\u0016\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u00a2\u0006\u0004\b&\u0010(J\u0006\u0010\u0003\u001a\u00020\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\u0018\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016J\b\u0010\f\u001a\u00020\bH\u0016R\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u000eR\u0016\u0010\u0014\u001a\u00020\b8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u000eR&\u0010\u001c\u001a\u0012\u0012\u0004\u0012\u00020\u00180\u0017j\b\u0012\u0004\u0012\u00020\u0018`\u00198\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u001c\u0010!\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001d8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010#\u001a\u00020\b8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\"\u0010\u0013R\u0016\u0010%\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010\u000e\u00a8\u0006*"}, d2 = {"Lcom/tencent/qqnt/bean/InviteToTroopParam;", "Landroid/os/Parcelable;", "Lcom/tencent/qqnt/kernel/nativeinterface/InviteGroupReq;", "a", "", "toString", "Landroid/os/Parcel;", "parcel", "", WadlProxyConsts.FLAGS, "", "writeToParcel", "describeContents", "d", "Ljava/lang/String;", "troopUin", "e", "msg", "f", "I", "verifyType", h.F, "verifyToken", "Ljava/util/ArrayList;", "Lcom/tencent/qqnt/bean/InviteToTroopUserInfo;", "Lkotlin/collections/ArrayList;", "i", "Ljava/util/ArrayList;", "invitedUserList", "", "Lcom/tencent/qqnt/bean/ShareMessageInfo;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/util/List;", "historyMsgList", BdhLogUtil.LogTag.Tag_Conn, "callbackId", "D", "from", "<init>", "()V", "(Landroid/os/Parcel;)V", "CREATOR", "qqtroop-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class InviteToTroopParam implements Parcelable {
    static IPatchRedirector $redirector_;

    /* renamed from: CREATOR, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    @JvmField
    public int callbackId;

    /* renamed from: D, reason: from kotlin metadata */
    @JvmField
    @NotNull
    public String from;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @JvmField
    @Nullable
    public String troopUin;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @JvmField
    @Nullable
    public String msg;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @JvmField
    public int verifyType;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @JvmField
    @Nullable
    public String verifyToken;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @JvmField
    @NotNull
    public ArrayList<InviteToTroopUserInfo> invitedUserList;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @JvmField
    @NotNull
    public List<ShareMessageInfo> historyMsgList;

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u001f\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a2\u0006\u0004\b\t\u0010\n\u00a8\u0006\r"}, d2 = {"Lcom/tencent/qqnt/bean/InviteToTroopParam$a;", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/qqnt/bean/InviteToTroopParam;", "Landroid/os/Parcel;", "parcel", "a", "", "size", "", "b", "(I)[Lcom/tencent/qqnt/bean/InviteToTroopParam;", "<init>", "()V", "qqtroop-api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.bean.InviteToTroopParam$a, reason: from kotlin metadata */
    /* loaded from: classes23.dex */
    public static final class Companion implements Parcelable.Creator<InviteToTroopParam> {
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
        public InviteToTroopParam createFromParcel(@NotNull Parcel parcel) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (InviteToTroopParam) iPatchRedirector.redirect((short) 2, (Object) this, (Object) parcel);
            }
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new InviteToTroopParam(parcel);
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public InviteToTroopParam[] newArray(int size) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (InviteToTroopParam[]) iPatchRedirector.redirect((short) 3, (Object) this, size);
            }
            return new InviteToTroopParam[size];
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(27416);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 8)) {
            redirector.redirect((short) 8);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public InviteToTroopParam() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.msg = "";
        this.verifyToken = "";
        this.invitedUserList = new ArrayList<>();
        this.historyMsgList = new ArrayList();
        this.from = "";
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x001d, code lost:
    
        r1 = kotlin.text.StringsKt__StringNumberConversionsKt.toLongOrNull(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x00af, code lost:
    
        r10 = kotlin.text.StringsKt__StringNumberConversionsKt.toLongOrNull(r10);
     */
    @NotNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final InviteGroupReq a() {
        long j3;
        int collectionSizeOrDefault;
        int collectionSizeOrDefault2;
        long j16;
        Long longOrNull;
        boolean z16;
        String str;
        Long longOrNull2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (InviteGroupReq) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        InviteGroupReq inviteGroupReq = new InviteGroupReq();
        String str2 = this.troopUin;
        if (str2 != null && longOrNull2 != null) {
            j3 = longOrNull2.longValue();
        } else {
            j3 = 0;
        }
        inviteGroupReq.joinGroupCode = j3;
        inviteGroupReq.stringMsg = this.msg;
        inviteGroupReq.verifyToken = this.verifyToken;
        inviteGroupReq.verifyType = this.verifyType;
        ArrayList<InviteUidInfo> arrayList = inviteGroupReq.beInvitedUidInfo;
        ArrayList<InviteToTroopUserInfo> arrayList2 = this.invitedUserList;
        ArrayList<InviteToTroopUserInfo> arrayList3 = new ArrayList();
        Iterator<T> it = arrayList2.iterator();
        while (true) {
            boolean z17 = true;
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            InviteToTroopUserInfo inviteToTroopUserInfo = (InviteToTroopUserInfo) next;
            String c16 = inviteToTroopUserInfo.c();
            if (c16 != null && c16.length() != 0) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (!z16) {
                String c17 = inviteToTroopUserInfo.c();
                AppRuntime f16 = bg.f();
                if (f16 != null) {
                    str = f16.getCurrentUin();
                } else {
                    str = null;
                }
                if (Intrinsics.areEqual(c17, str)) {
                    z17 = false;
                }
            }
            if (z17) {
                arrayList3.add(next);
            }
        }
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList3, 10);
        ArrayList arrayList4 = new ArrayList(collectionSizeOrDefault);
        for (InviteToTroopUserInfo inviteToTroopUserInfo2 : arrayList3) {
            InviteUidInfo inviteUidInfo = new InviteUidInfo();
            inviteUidInfo.inviteUid = inviteToTroopUserInfo2.b();
            String a16 = inviteToTroopUserInfo2.a();
            if (a16 != null && longOrNull != null) {
                j16 = longOrNull.longValue();
            } else {
                j16 = 0;
            }
            if (j16 > 0) {
                if (inviteToTroopUserInfo2.getType() == 1) {
                    inviteUidInfo.judgeGroupCode = j16;
                } else if (inviteToTroopUserInfo2.getType() == 2) {
                    inviteUidInfo.judgeConfCode = j16;
                }
            }
            arrayList4.add(inviteUidInfo);
        }
        arrayList.addAll(arrayList4);
        inviteGroupReq.hasShareMsgInfo = !this.historyMsgList.isEmpty();
        ArrayList<ShareMsgInfo> arrayList5 = inviteGroupReq.shareMsgInfos;
        List<ShareMessageInfo> list = this.historyMsgList;
        collectionSizeOrDefault2 = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
        ArrayList arrayList6 = new ArrayList(collectionSizeOrDefault2);
        for (ShareMessageInfo shareMessageInfo : list) {
            ShareMsgInfo shareMsgInfo = new ShareMsgInfo();
            shareMsgInfo.msgSeq = shareMessageInfo.a();
            shareMsgInfo.msgTime = shareMessageInfo.b();
            arrayList6.add(shareMsgInfo);
        }
        arrayList5.addAll(arrayList6);
        return inviteGroupReq;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this)).intValue();
        }
        return 0;
    }

    @NotNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return "troopUin:" + this.troopUin + ", msg:" + this.msg + ", vType:" + this.verifyType + ", vToken:" + this.verifyToken + ", user:" + this.invitedUserList + ", msg:" + this.historyMsgList;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) parcel, flags);
            return;
        }
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.troopUin);
        parcel.writeString(this.msg);
        parcel.writeInt(this.verifyType);
        parcel.writeString(this.verifyToken);
        parcel.writeTypedList(this.invitedUserList);
        parcel.writeTypedList(this.historyMsgList);
        parcel.writeInt(this.callbackId);
        parcel.writeString(this.from);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public InviteToTroopParam(@NotNull Parcel parcel) {
        this();
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) parcel);
            return;
        }
        this.troopUin = parcel.readString();
        String readString = parcel.readString();
        this.msg = readString == null ? "" : readString;
        this.verifyType = parcel.readInt();
        String readString2 = parcel.readString();
        this.verifyToken = readString2 == null ? "" : readString2;
        ArrayList<InviteToTroopUserInfo> createTypedArrayList = parcel.createTypedArrayList(InviteToTroopUserInfo.INSTANCE);
        this.invitedUserList = createTypedArrayList == null ? new ArrayList<>() : createTypedArrayList;
        ArrayList createTypedArrayList2 = parcel.createTypedArrayList(ShareMessageInfo.INSTANCE);
        this.historyMsgList = createTypedArrayList2 == null ? new ArrayList() : createTypedArrayList2;
        this.callbackId = parcel.readInt();
        String readString3 = parcel.readString();
        this.from = readString3 != null ? readString3 : "";
    }
}
