package com.tencent.mobileqq.friend.handler.recevier;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.proxy.GroupActionResp;
import com.tencent.mobileqq.data.Groups;
import com.tencent.mobileqq.friend.api.impl.FriendDataServiceImpl;
import com.tencent.mobileqq.friend.data.GroupRequestData;
import com.tencent.mobileqq.friend.handler.FriendHandler;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QzoneIPCModule;
import friendlist.AddGroupResp;
import friendlist.DelGroupResp;
import friendlist.ReSortGroupResp;
import friendlist.RenameGroupResp;
import friendlist.SetGroupResp;
import java.io.Serializable;
import java.nio.ByteBuffer;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.Charsets;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00122\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001fB\u0017\u0012\u0006\u0010\u001b\u001a\u00020\u001a\u0012\u0006\u0010\u001c\u001a\u00020\u0002\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J(\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0002J(\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0002J(\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0002J(\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0002J\b\u0010\u0012\u001a\u00020\bH\u0016J\"\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u00152\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0016\u00a8\u0006 "}, d2 = {"Lcom/tencent/mobileqq/friend/handler/recevier/m;", "Lcom/tencent/mobileqq/friend/handler/recevier/a;", "Lcom/tencent/mobileqq/friend/handler/FriendHandler;", "", "reqType", "", "j", QzoneIPCModule.RESULT_CODE, "", "errorStr", "Ljava/nio/ByteBuffer;", "buffer", "Lcom/tencent/mobileqq/friend/data/GroupRequestData;", WebViewPlugin.KEY_REQUEST, "f", tl.h.F, "g", "i", "c", "Lcom/tencent/qphone/base/remote/ToServiceMsg;", "req", "Lcom/tencent/qphone/base/remote/FromServiceMsg;", "res", "", "data", "e", "Lcom/tencent/common/app/AppInterface;", "appRuntime", "handler", "<init>", "(Lcom/tencent/common/app/AppInterface;Lcom/tencent/mobileqq/friend/handler/FriendHandler;)V", "a", "IMCore_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class m extends a<FriendHandler> {
    static IPatchRedirector $redirector_;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/friend/handler/recevier/m$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "IMCore_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.friend.handler.recevier.m$a, reason: from kotlin metadata */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(34909);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m(@NotNull AppInterface appRuntime, @NotNull FriendHandler handler) {
        super(appRuntime, handler);
        Intrinsics.checkNotNullParameter(appRuntime, "appRuntime");
        Intrinsics.checkNotNullParameter(handler, "handler");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) appRuntime, (Object) handler);
        }
    }

    private final void f(int resultCode, String errorStr, ByteBuffer buffer, GroupRequestData requestData) {
        AddGroupResp addGroupResp = new AddGroupResp();
        boolean z16 = true;
        if (resultCode == 0) {
            FriendDataServiceImpl service = FriendDataServiceImpl.getService(b());
            addGroupResp.dwToUin = buffer.getInt();
            addGroupResp.dwSequence = buffer.getInt();
            addGroupResp.cGroupId = buffer.get();
            addGroupResp.cSortId = buffer.get();
            Groups group = service.getGroup(addGroupResp.cGroupId, true);
            if (group == null) {
                group = new Groups();
            }
            group.group_id = addGroupResp.cGroupId;
            group.seqid = addGroupResp.cSortId;
            group.group_name = requestData.getName();
            service.saveGroup(group);
        }
        GroupActionResp groupActionResp = new GroupActionResp(resultCode, errorStr, addGroupResp);
        FriendHandler d16 = d();
        if (resultCode != 0) {
            z16 = false;
        }
        d16.notifyUI(18, z16, groupActionResp);
        if (QLog.isColorLevel()) {
            QLog.d("IMCore.friend.SetGroupReceiver", 2, "handleAddGroup| resultCode = " + resultCode + ", errorStr = " + errorStr);
        }
    }

    private final void g(int resultCode, String errorStr, ByteBuffer buffer, GroupRequestData requestData) {
        DelGroupResp delGroupResp = new DelGroupResp();
        boolean z16 = false;
        if (resultCode == 0) {
            FriendDataServiceImpl service = FriendDataServiceImpl.getService(b());
            delGroupResp.dwToUin = buffer.getInt();
            delGroupResp.dwSequence = buffer.getInt();
            byte b16 = buffer.get();
            delGroupResp.cGroupid = b16;
            service.moveGroup(b16, 0);
        }
        GroupActionResp groupActionResp = new GroupActionResp(resultCode, errorStr, delGroupResp);
        FriendHandler d16 = d();
        if (resultCode == 0) {
            z16 = true;
        }
        d16.notifyUI(21, z16, groupActionResp);
        if (QLog.isColorLevel()) {
            QLog.d("IMCore.friend.SetGroupReceiver", 2, "handleDelGroup| resultCode = " + resultCode + ", errorStr = " + errorStr);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void h(int resultCode, String errorStr, ByteBuffer buffer, GroupRequestData requestData) {
        RenameGroupResp renameGroupResp = new RenameGroupResp();
        boolean z16 = true;
        if (resultCode == 0) {
            FriendDataServiceImpl service = FriendDataServiceImpl.getService(b());
            renameGroupResp.dwToUin = buffer.getInt();
            renameGroupResp.dwSequence = buffer.getInt();
            byte b16 = buffer.get();
            int i3 = buffer.get();
            renameGroupResp.cLen = i3;
            byte[] bArr = new byte[i3];
            buffer.get(bArr, 0, i3);
            renameGroupResp.sGroupName = new String(bArr, Charsets.UTF_8);
            Groups group = service.getGroup(b16, true);
            if (group == null) {
                group = new Groups();
                group.group_id = (int) renameGroupResp.dwSequence;
            }
            group.group_name = renameGroupResp.sGroupName;
            service.saveGroup(group);
        }
        GroupActionResp groupActionResp = new GroupActionResp(resultCode, errorStr, renameGroupResp);
        FriendHandler d16 = d();
        if (resultCode != 0) {
            z16 = false;
        }
        d16.notifyUI(19, z16, groupActionResp);
        if (QLog.isColorLevel()) {
            QLog.d("IMCore.friend.SetGroupReceiver", 2, "handleRenameGroup| resultCode = " + resultCode + ", errorStr = " + errorStr);
        }
    }

    private final void i(int resultCode, String errorStr, ByteBuffer buffer, GroupRequestData requestData) {
        boolean z16;
        ReSortGroupResp reSortGroupResp = new ReSortGroupResp();
        if (resultCode == 0) {
            FriendDataServiceImpl service = FriendDataServiceImpl.getService(b());
            reSortGroupResp.dwToUin = buffer.getInt();
            reSortGroupResp.dwSequence = buffer.getInt();
            service.updateGroupSortIds(requestData.getGroupIdList(), requestData.getSortIdList());
        }
        GroupActionResp groupActionResp = new GroupActionResp(resultCode, errorStr, reSortGroupResp);
        FriendHandler d16 = d();
        if (resultCode == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        d16.notifyUI(22, z16, groupActionResp);
        if (QLog.isColorLevel()) {
            QLog.d("IMCore.friend.SetGroupReceiver", 2, "handleResortGroup| resultCode = " + resultCode + ", errorStr = " + errorStr);
        }
    }

    private final void j(int reqType) {
        QLog.d("IMCore.friend.SetGroupReceiver", 1, "handleSetGroupRequestFailed| reqType: " + reqType);
        if (reqType != 0) {
            if (reqType != 1) {
                if (reqType != 2) {
                    if (reqType != 3) {
                        QLog.e("IMCore.friend.SetGroupReceiver", 1, "handleSetGroupFail| error reqType: " + reqType);
                        return;
                    }
                    d().notifyUI(22, false, null);
                    return;
                }
                d().notifyUI(21, false, null);
                return;
            }
            d().notifyUI(19, false, null);
            return;
        }
        d().notifyUI(18, false, null);
    }

    @Override // com.tencent.mobileqq.friend.handler.recevier.a
    @NotNull
    public String c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return "friendlist.SetGroupReq";
    }

    @Override // com.tencent.mobileqq.friend.handler.recevier.a
    public void e(@NotNull ToServiceMsg req, @NotNull FromServiceMsg res, @Nullable Object data) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, req, res, data);
            return;
        }
        Intrinsics.checkNotNullParameter(req, "req");
        Intrinsics.checkNotNullParameter(res, "res");
        Serializable serializable = req.extraData.getSerializable(Reflection.getOrCreateKotlinClass(GroupRequestData.class).getSimpleName());
        if (!(serializable instanceof GroupRequestData)) {
            QLog.e("IMCore.friend.SetGroupReceiver", 1, "encodeGroupRequest, requestData is not GroupRequestData");
            return;
        }
        if (res.isSuccess() && (data instanceof SetGroupResp)) {
            SetGroupResp setGroupResp = (SetGroupResp) data;
            ByteBuffer buffer = ByteBuffer.wrap(setGroupResp.vecBody);
            GroupRequestData groupRequestData = (GroupRequestData) serializable;
            int reqType = groupRequestData.getReqType();
            if (reqType != 0) {
                if (reqType != 1) {
                    if (reqType != 2) {
                        if (reqType != 3) {
                            QLog.e("IMCore.friend.SetGroupReceiver", 1, "receiveSetGroupResponse| error reqType: " + groupRequestData.getReqType());
                            return;
                        }
                        byte b16 = setGroupResp.result;
                        String str = setGroupResp.ErrorString;
                        Intrinsics.checkNotNullExpressionValue(str, "data.ErrorString");
                        Intrinsics.checkNotNullExpressionValue(buffer, "buffer");
                        i(b16, str, buffer, groupRequestData);
                        return;
                    }
                    byte b17 = setGroupResp.result;
                    String str2 = setGroupResp.ErrorString;
                    Intrinsics.checkNotNullExpressionValue(str2, "data.ErrorString");
                    Intrinsics.checkNotNullExpressionValue(buffer, "buffer");
                    g(b17, str2, buffer, groupRequestData);
                    return;
                }
                byte b18 = setGroupResp.result;
                String str3 = setGroupResp.ErrorString;
                Intrinsics.checkNotNullExpressionValue(str3, "data.ErrorString");
                Intrinsics.checkNotNullExpressionValue(buffer, "buffer");
                h(b18, str3, buffer, groupRequestData);
                return;
            }
            byte b19 = setGroupResp.result;
            String str4 = setGroupResp.ErrorString;
            Intrinsics.checkNotNullExpressionValue(str4, "data.ErrorString");
            Intrinsics.checkNotNullExpressionValue(buffer, "buffer");
            f(b19, str4, buffer, groupRequestData);
            return;
        }
        QLog.d("IMCore.friend.SetGroupReceiver", 1, "receiveSetGroupResponse| fail " + res.getResultCode());
        j(((GroupRequestData) serializable).getReqType());
    }
}
