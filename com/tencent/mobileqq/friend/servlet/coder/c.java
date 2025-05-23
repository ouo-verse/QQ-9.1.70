package com.tencent.mobileqq.friend.servlet.coder;

import com.qq.jce.wup.UniPacket;
import com.tencent.component.network.downloader.impl.ipc.Const;
import com.tencent.mobileqq.friend.data.FriendListRequestData;
import com.tencent.mobileqq.friend.data.GroupRequestData;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import friendlist.AddGroup;
import friendlist.DelGroup;
import friendlist.GetFriendListReq;
import friendlist.GetFriendListResp;
import friendlist.ReSortGroup;
import friendlist.RenameGroup;
import friendlist.SetGroupReq;
import friendlist.SetGroupResp;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.Charsets;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tencent.im.oidb.cmd0xd50.Oidb_0xd50$ReqBody;
import tencent.im.oidb.cmd0xd6b.Oidb_0xd6b$ReqBody;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u0007\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u001a\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0002J\u0018\u0010\f\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u001a\u0010\r\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0002J\u0018\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u001a\u0010\u000f\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0016J\u0015\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010H\u0016\u00a2\u0006\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/friend/servlet/coder/c;", "Lcom/tencent/mobileqq/friend/servlet/coder/a;", "Lcom/tencent/qphone/base/remote/ToServiceMsg;", Const.BUNDLE_KEY_REQUEST, "Lcom/qq/jce/wup/UniPacket;", "client", "", h.F, "Lcom/tencent/qphone/base/remote/FromServiceMsg;", "response", "", "f", "i", "g", "c", "a", "", "", "e", "()[Ljava/lang/String;", "<init>", "()V", "IMCore_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class c extends a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u00058\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0007\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/friend/servlet/coder/c$a;", "", "", "FRIEND_REQ_VER", "J", "", "NEW_CMD_VERSION", "Ljava/lang/String;", "TAG", "<init>", "()V", "IMCore_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.friend.servlet.coder.c$a, reason: from kotlin metadata */
    /* loaded from: classes12.dex */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(35210);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final Object f(ToServiceMsg request, FromServiceMsg response) {
        if (QLog.isColorLevel()) {
            QLog.d("IMCore.friend.FriendListJCECoder", 2, "decodeFriendListResponse");
        }
        return b(response.getWupBuffer(), "FLRESP", new GetFriendListResp());
    }

    private final Object g(ToServiceMsg request, FromServiceMsg response) {
        return b(response.getWupBuffer(), "SetGroupResp", new SetGroupResp());
    }

    private final boolean h(ToServiceMsg request, UniPacket client) {
        Serializable serializable = request.extraData.getSerializable(Reflection.getOrCreateKotlinClass(FriendListRequestData.class).getSimpleName());
        if (serializable instanceof FriendListRequestData) {
            Oidb_0xd50$ReqBody oidb_0xd50$ReqBody = new Oidb_0xd50$ReqBody();
            oidb_0xd50$ReqBody.appid.set(10002L);
            oidb_0xd50$ReqBody.req_music_switch.set(1);
            oidb_0xd50$ReqBody.req_ksing_switch.set(1);
            oidb_0xd50$ReqBody.req_mutualmark_lbsshare.set(1);
            oidb_0xd50$ReqBody.req_mutualmark_alienation.set(1);
            oidb_0xd50$ReqBody.req_aio_quick_app.set(1);
            Oidb_0xd6b$ReqBody oidb_0xd6b$ReqBody = new Oidb_0xd6b$ReqBody();
            oidb_0xd6b$ReqBody.cmd_version.set("1");
            GetFriendListReq getFriendListReq = new GetFriendListReq();
            getFriendListReq.reqtype = 3;
            FriendListRequestData friendListRequestData = (FriendListRequestData) serializable;
            getFriendListReq.ifReflush = friendListRequestData.getIfReflushParam();
            String uin = request.getUin();
            Intrinsics.checkNotNullExpressionValue(uin, "request.uin");
            getFriendListReq.uin = Long.parseLong(uin);
            getFriendListReq.startIndex = (short) friendListRequestData.getFriendStartIndex();
            getFriendListReq.getfriendCount = (short) friendListRequestData.getFriendCount();
            getFriendListReq.groupid = (byte) 0;
            getFriendListReq.ifGetGroupInfo = friendListRequestData.getIfGetGroupInfoParam();
            getFriendListReq.groupstartIndex = (byte) friendListRequestData.getGroupStartIndex();
            getFriendListReq.getgroupCount = (byte) friendListRequestData.getGroupCount();
            getFriendListReq.ifGetMSFGroup = (byte) 0;
            getFriendListReq.ifShowTermType = (byte) friendListRequestData.getShowTermType();
            getFriendListReq.version = 41L;
            getFriendListReq.uinList = friendListRequestData.getUinListParam();
            getFriendListReq.eAppType = 0;
            getFriendListReq.ifGetDOVId = (byte) 0;
            getFriendListReq.ifGetBothFlag = (byte) 0;
            getFriendListReq.vec0xd50Req = oidb_0xd50$ReqBody.toByteArray();
            getFriendListReq.vec0xd6bReq = oidb_0xd6b$ReqBody.toByteArray();
            getFriendListReq.vecSnsTypelist = friendListRequestData.getSNSTypeList();
            client.setServantName("mqq.IMService.FriendListServiceServantObj");
            client.setFuncName("GetFriendListReq");
            client.put("FL", getFriendListReq);
            if (QLog.isColorLevel()) {
                QLog.d("IMCore.friend.FriendListJCECoder", 2, "encodeFriendListRequest");
            }
            return true;
        }
        QLog.d("IMCore.friend.FriendListJCECoder", 1, "encodeFriendListRequest| requestData is not FriendListRequestData");
        return false;
    }

    private final boolean i(ToServiceMsg request, UniPacket client) {
        client.setServantName("mqq.IMService.FriendListServiceServantObj");
        client.setFuncName("SetGroupReq");
        SetGroupReq setGroupReq = new SetGroupReq();
        try {
            String uin = request.getUin();
            Intrinsics.checkNotNullExpressionValue(uin, "request.uin");
            setGroupReq.uin = Long.parseLong(uin);
            Serializable serializable = request.extraData.getSerializable(Reflection.getOrCreateKotlinClass(GroupRequestData.class).getSimpleName());
            if (!(serializable instanceof GroupRequestData)) {
                QLog.e("IMCore.friend.FriendListJCECoder", 1, "encodeGroupRequest, requestData is not GroupRequestData");
                return false;
            }
            setGroupReq.reqtype = ((GroupRequestData) serializable).getReqType();
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(10);
            DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
            try {
                int reqType = ((GroupRequestData) serializable).getReqType();
                if (reqType != 0) {
                    if (reqType != 1) {
                        if (reqType != 2) {
                            if (reqType != 3) {
                                return false;
                            }
                            ReSortGroup reSortGroup = new ReSortGroup();
                            reSortGroup.cGroupId = ((GroupRequestData) serializable).getGroupIdList();
                            reSortGroup.cSortId = ((GroupRequestData) serializable).getSortIdList();
                            byte length = (byte) reSortGroup.cGroupId.length;
                            reSortGroup.cNum = length;
                            dataOutputStream.writeByte(length);
                            byte[] bArr = reSortGroup.cGroupId;
                            Intrinsics.checkNotNullExpressionValue(bArr, "resortreq.cGroupId");
                            byte[] bArr2 = reSortGroup.cSortId;
                            Intrinsics.checkNotNullExpressionValue(bArr2, "resortreq.cSortId");
                            for (int i3 = 0; i3 < bArr.length; i3++) {
                                dataOutputStream.writeByte(bArr[i3]);
                                dataOutputStream.writeByte(bArr2[i3]);
                            }
                        } else {
                            DelGroup delGroup = new DelGroup();
                            byte groupId = ((GroupRequestData) serializable).getGroupId();
                            delGroup.cGroupId = groupId;
                            dataOutputStream.writeByte(groupId);
                        }
                    } else {
                        RenameGroup renameGroup = new RenameGroup();
                        renameGroup.cGroupId = ((GroupRequestData) serializable).getGroupId();
                        String name = ((GroupRequestData) serializable).getName();
                        renameGroup.sGroupName = name;
                        Intrinsics.checkNotNullExpressionValue(name, "renamereq.sGroupName");
                        byte[] bytes = name.getBytes(Charsets.UTF_8);
                        Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
                        renameGroup.cLen = (byte) bytes.length;
                        dataOutputStream.write(renameGroup.cGroupId);
                        dataOutputStream.writeByte(renameGroup.cLen);
                        dataOutputStream.write(bytes);
                    }
                } else {
                    AddGroup addGroup = new AddGroup();
                    addGroup.cSortId = ((GroupRequestData) serializable).getSortId();
                    String name2 = ((GroupRequestData) serializable).getName();
                    addGroup.sGroupName = name2;
                    Intrinsics.checkNotNullExpressionValue(name2, "addreq.sGroupName");
                    byte[] bytes2 = name2.getBytes(Charsets.UTF_8);
                    Intrinsics.checkNotNullExpressionValue(bytes2, "this as java.lang.String).getBytes(charset)");
                    addGroup.cLen = (byte) bytes2.length;
                    dataOutputStream.writeByte(addGroup.cSortId);
                    dataOutputStream.writeByte(addGroup.cLen);
                    dataOutputStream.write(bytes2);
                }
                dataOutputStream.close();
                setGroupReq.vecBody = byteArrayOutputStream.toByteArray();
                client.put("SetGroupReq", setGroupReq);
                return true;
            } catch (IOException unused) {
                return false;
            }
        } catch (NumberFormatException e16) {
            QLog.e("IMCore.friend.FriendListJCECoder", 1, "encodeGroupRequest", e16);
            return false;
        }
    }

    @Override // com.tencent.mobileqq.friend.servlet.coder.a
    @Nullable
    public Object a(@NotNull ToServiceMsg request, @NotNull FromServiceMsg response) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return iPatchRedirector.redirect((short) 3, (Object) this, (Object) request, (Object) response);
        }
        Intrinsics.checkNotNullParameter(request, "request");
        Intrinsics.checkNotNullParameter(response, "response");
        String serviceCmd = response.getServiceCmd();
        if (Intrinsics.areEqual(serviceCmd, "friendlist.getFriendGroupList")) {
            return f(request, response);
        }
        if (Intrinsics.areEqual(serviceCmd, "friendlist.SetGroupReq")) {
            return g(request, response);
        }
        return Boolean.FALSE;
    }

    @Override // com.tencent.mobileqq.friend.servlet.coder.a
    public boolean c(@NotNull ToServiceMsg request, @NotNull UniPacket client) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) request, (Object) client)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(request, "request");
        Intrinsics.checkNotNullParameter(client, "client");
        String serviceCmd = request.getServiceCmd();
        if (Intrinsics.areEqual(serviceCmd, "friendlist.getFriendGroupList")) {
            return h(request, client);
        }
        if (Intrinsics.areEqual(serviceCmd, "friendlist.SetGroupReq")) {
            return i(request, client);
        }
        return false;
    }

    @Override // com.tencent.mobileqq.friend.servlet.coder.a
    @NotNull
    public String[] e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String[]) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return new String[]{"friendlist.getFriendGroupList", "friendlist.SetGroupReq"};
    }
}
