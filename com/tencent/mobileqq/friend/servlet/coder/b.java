package com.tencent.mobileqq.friend.servlet.coder;

import android.os.Bundle;
import android.text.TextUtils;
import com.qq.jce.wup.UniPacket;
import com.tencent.component.network.downloader.impl.ipc.Const;
import com.tencent.mobileqq.fe.e;
import com.tencent.mobileqq.friend.utils.d;
import com.tencent.mobileqq.icgame.api.room.PreloadTRTCPlayerParams;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qsec.qsecurity.QSec;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.util.Utils;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.BuddySource;
import com.tencent.qqprotect.qsec.api.IO3CollectDataApi;
import cooperation.qzone.report.lp.LpReportInfo_dc04586;
import friendlist.AddFriendReq;
import friendlist.AddFriendResp;
import friendlist.GetAutoInfoReq;
import friendlist.GetAutoInfoResp;
import friendlist.GetUserAddFriendSettingReq;
import friendlist.GetUserAddFriendSettingResp;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.Charsets;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tencent.im.s2c.frdsysmsg.FrdSysMsg$DiscussInfo;
import tencent.im.s2c.frdsysmsg.FrdSysMsg$FriendSysMsg;
import tencent.im.s2c.frdsysmsg.FrdSysMsg$GroupInfo;
import tencent.im.s2c.frdsysmsg.FrdSysMsg$GroupInfoExt;
import tencent.im.s2c.frdsysmsg.FrdSysMsg$InviteInfo;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0006\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 %2\u00020\u0001:\u0001%B\u0007\u00a2\u0006\u0004\b)\u0010*J\u001a\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u001a\u0010\n\u001a\u0004\u0018\u00010\u00062\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0004H\u0002J\u0010\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000bH\u0002J\u0012\u0010\u0012\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J\u0012\u0010\u0014\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0013\u001a\u00020\u0011H\u0002J\u001a\u0010\u0016\u001a\u0004\u0018\u00010\u00062\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0004H\u0002J\u0012\u0010\u0019\u001a\u00020\u00182\b\u0010\u0017\u001a\u0004\u0018\u00010\u000bH\u0002J\u0018\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u001aH\u0002J\u0015\u0010 \u001a\b\u0012\u0004\u0012\u00020\u000b0\u001fH\u0016\u00a2\u0006\u0004\b \u0010!J\u0018\u0010$\u001a\u00020\u001d2\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010#\u001a\u00020\"H\u0016J\u001a\u0010%\u001a\u0004\u0018\u00010\u00062\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0004H\u0016J\u0016\u0010&\u001a\u00020\u001d2\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010#\u001a\u00020\"J\u0016\u0010'\u001a\u00020\u001d2\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010#\u001a\u00020\"J\u0016\u0010(\u001a\u00020\u001d2\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010#\u001a\u00020\"\u00a8\u0006+"}, d2 = {"Lcom/tencent/mobileqq/friend/servlet/coder/b;", "Lcom/tencent/mobileqq/friend/servlet/coder/a;", "Lcom/tencent/qphone/base/remote/ToServiceMsg;", "req", "Lcom/tencent/qphone/base/remote/FromServiceMsg;", "resp", "", "i", Const.BUNDLE_KEY_REQUEST, "responseWUP", "j", "", "see", "", "o", "Lfriendlist/AddFriendReq;", "addReq", "", "p", "bytes", "f", "response", h.F, "uin", "", "g", "", "sourceID", "subSourceID", "", DomainData.DOMAIN_NAME, "", "e", "()[Ljava/lang/String;", "Lcom/qq/jce/wup/UniPacket;", "client", "c", "a", "l", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "k", "<init>", "()V", "IMCore_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class b extends a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/friend/servlet/coder/b$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "IMCore_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.friend.servlet.coder.b$a, reason: from kotlin metadata */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(35190);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 9)) {
            redirector.redirect((short) 9);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final String f(byte[] bytes) {
        StringBuilder sb5 = new StringBuilder();
        for (byte b16 : bytes) {
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String format = String.format("0x%02x,", Arrays.copyOf(new Object[]{Byte.valueOf(b16)}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
            sb5.append(format);
        }
        return sb5.toString();
    }

    private final long g(String uin) {
        boolean z16;
        long parseLong;
        if (uin == null) {
            return 0L;
        }
        if (uin.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            try {
                parseLong = Long.parseLong(uin);
                if (parseLong < 10000) {
                    return 0L;
                }
            } catch (NumberFormatException unused) {
                return 0L;
            }
        }
        return parseLong;
    }

    private final Object h(ToServiceMsg request, FromServiceMsg response) {
        if (QLog.isColorLevel()) {
            QLog.d("IMCore.friend.FriendAddJCECoder", 2, "decodeAddFriendResponse");
        }
        return b(response.getWupBuffer(), "AFRESP", new AddFriendResp());
    }

    private final Object i(ToServiceMsg req, FromServiceMsg resp) {
        return b(resp.getWupBuffer(), "GAIRESP", new GetAutoInfoResp());
    }

    private final Object j(ToServiceMsg request, FromServiceMsg responseWUP) {
        return b(responseWUP.getWupBuffer(), "FSRESP", new GetUserAddFriendSettingResp());
    }

    private final boolean n(int sourceID, int subSourceID) {
        if (sourceID != 3007 && sourceID != 3016 && sourceID != 3024 && sourceID != 3090) {
            if (sourceID != 3094) {
                if (sourceID != 3103 && sourceID != 3156 && sourceID != 3177 && sourceID != 3912) {
                    return false;
                }
            } else if (subSourceID != 16) {
                switch (subSourceID) {
                    case 21:
                    case 22:
                    case 23:
                    case 24:
                    case 25:
                    case 26:
                    case 27:
                    case 28:
                    case 29:
                        break;
                    default:
                        return false;
                }
            }
        }
        return true;
    }

    private final void o(String see) {
        ((IO3CollectDataApi) QRoute.api(IO3CollectDataApi.class)).sampling(MobileQQ.sMobileQQ.peekAppRuntime().getApplicationContext(), see, "AddFriend");
    }

    private final byte[] p(AddFriendReq addReq) {
        byte[] bArr = new byte[20];
        d.b(bArr, 0, addReq.uin);
        d.b(bArr, 8, addReq.adduin);
        d.a(bArr, 16, addReq.sourceID);
        if (QLog.isColorLevel()) {
            QLog.d("IMCore.friend.FriendAddJCECoder", 2, "secSalt: " + f(bArr));
        }
        byte[] bArr2 = new byte[1];
        if (e.b().i()) {
            QSec.getInstance().initSign();
            bArr2 = QSec.getInstance().getLiteSign(LpReportInfo_dc04586.ITEM_ID_BTN_ADD_FRIEND, bArr);
            Intrinsics.checkNotNullExpressionValue(bArr2, "getInstance().getLiteSign(\"add_friend\", secSalt)");
        }
        if (QLog.isColorLevel()) {
            QLog.d("IMCore.friend.FriendAddJCECoder", 2, "secSign: " + f(bArr2));
        }
        return bArr2;
    }

    @Override // com.tencent.mobileqq.friend.servlet.coder.a
    @Nullable
    public Object a(@NotNull ToServiceMsg request, @NotNull FromServiceMsg response) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return iPatchRedirector.redirect((short) 4, (Object) this, (Object) request, (Object) response);
        }
        Intrinsics.checkNotNullParameter(request, "request");
        Intrinsics.checkNotNullParameter(response, "response");
        String serviceCmd = request.getServiceCmd();
        if (serviceCmd != null) {
            int hashCode = serviceCmd.hashCode();
            if (hashCode != 78555965) {
                if (hashCode != 843392877) {
                    if (hashCode == 1200127328 && serviceCmd.equals("friendlist.getUserAddFriendSetting")) {
                        return j(request, response);
                    }
                } else if (serviceCmd.equals("friendlist.addFriend")) {
                    return h(request, response);
                }
            } else if (serviceCmd.equals("friendlist.GetAutoInfoReq")) {
                return i(request, response);
            }
        }
        QLog.e("IMCore.friend.FriendAddJCECoder", 1, "can not decode for this cmd");
        return null;
    }

    @Override // com.tencent.mobileqq.friend.servlet.coder.a
    public boolean c(@NotNull ToServiceMsg request, @NotNull UniPacket client) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) request, (Object) client)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(request, "request");
        Intrinsics.checkNotNullParameter(client, "client");
        String serviceCmd = request.getServiceCmd();
        if (serviceCmd != null) {
            int hashCode = serviceCmd.hashCode();
            if (hashCode != 78555965) {
                if (hashCode != 843392877) {
                    if (hashCode == 1200127328 && serviceCmd.equals("friendlist.getUserAddFriendSetting")) {
                        return m(request, client);
                    }
                } else if (serviceCmd.equals("friendlist.addFriend")) {
                    return k(request, client);
                }
            } else if (serviceCmd.equals("friendlist.GetAutoInfoReq")) {
                return l(request, client);
            }
        }
        QLog.e("IMCore.friend.FriendAddJCECoder", 1, "can not encode for this cmd");
        return false;
    }

    @Override // com.tencent.mobileqq.friend.servlet.coder.a
    @NotNull
    public String[] e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String[]) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return new String[]{"friendlist.addFriend", "friendlist.getUserAddFriendSetting", "friendlist.GetAutoInfoReq"};
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x026a  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0342  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0378  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x03a8  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x03c5  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x03d0  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x03db  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0459  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x046a  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0482  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x040e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean k(@NotNull ToServiceMsg request, @NotNull UniPacket client) {
        int i3;
        String str;
        int i16;
        byte[] bArr;
        byte[] bArr2;
        String string;
        byte[] byteArray;
        String str2;
        byte b16;
        String string2;
        byte[] byteArray2;
        String ticket;
        byte[] byteArray3;
        byte[] bytes;
        int length;
        byte[] bArr3;
        byte[] bArr4;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this, (Object) request, (Object) client)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(request, "request");
        Intrinsics.checkNotNullParameter(client, "client");
        o(LpReportInfo_dc04586.ITEM_ID_BTN_ADD_FRIEND);
        long g16 = g(request.getUin());
        if (g16 == 0) {
            return false;
        }
        Bundle bundle = request.extraData;
        String string3 = bundle.getString("uin");
        int i17 = bundle.getInt("source_id", BuddySource.DEFAULT);
        int i18 = bundle.getInt("sub_source_id", 0);
        byte[] byteArray4 = bundle.getByteArray("third_source_id");
        AddFriendReq addFriendReq = new AddFriendReq();
        addFriendReq.uin = g16;
        addFriendReq.sourceID = i17;
        addFriendReq.sourceSubID = i18;
        addFriendReq.permission_info = bundle.getByteArray("friend_permission_byte_array");
        if (byteArray4 != null) {
            addFriendReq.ext_info = byteArray4;
        }
        if (n(i17, i18)) {
            String string4 = bundle.getString("extra");
            if (TextUtils.isEmpty(string3) || TextUtils.isEmpty(string4)) {
                return false;
            }
            if (string3 != null) {
                bArr3 = string3.getBytes(Charsets.UTF_8);
                Intrinsics.checkNotNullExpressionValue(bArr3, "this as java.lang.String).getBytes(charset)");
            } else {
                bArr3 = null;
            }
            addFriendReq.name = bArr3;
            if (string4 != null) {
                bArr4 = string4.getBytes(Charsets.UTF_8);
                Intrinsics.checkNotNullExpressionValue(bArr4, "this as java.lang.String).getBytes(charset)");
            } else {
                bArr4 = null;
            }
            addFriendReq.name1 = bArr4;
        } else if (friendlist.a.a(i17)) {
            if (TextUtils.isEmpty(string3)) {
                return false;
            }
            if (string3 != null) {
                bArr2 = string3.getBytes(Charsets.UTF_8);
                Intrinsics.checkNotNullExpressionValue(bArr2, "this as java.lang.String).getBytes(charset)");
            } else {
                bArr2 = null;
            }
            addFriendReq.name = bArr2;
        } else {
            if (i17 == 3026) {
                if (i18 == 0) {
                    if (TextUtils.isEmpty(string3)) {
                        return false;
                    }
                    if (string3 != null) {
                        bArr = string3.getBytes(Charsets.UTF_8);
                        Intrinsics.checkNotNullExpressionValue(bArr, "this as java.lang.String).getBytes(charset)");
                    } else {
                        bArr = null;
                    }
                    addFriendReq.name = bArr;
                } else {
                    i3 = i17;
                    long g17 = g(string3);
                    if (g17 != 0 && g16 != g17) {
                        addFriendReq.adduin = g17;
                    } else {
                        return false;
                    }
                }
            } else {
                long g18 = g(string3);
                if (g18 == 0) {
                    return false;
                }
                addFriendReq.adduin = g18;
                if (i17 != 3004) {
                    if (i17 != 3005) {
                        if (i17 != 3022) {
                            if (i17 != 3037) {
                                if (i17 != 3042) {
                                    i3 = i17;
                                } else {
                                    String string5 = bundle.getString("troop_uin");
                                    int i19 = bundle.getInt("flc_notify_type");
                                    String string6 = bundle.getString("flc_recommend_uin");
                                    if (!TextUtils.isEmpty(string6) && !TextUtils.isEmpty(string5)) {
                                        FrdSysMsg$FriendSysMsg frdSysMsg$FriendSysMsg = new FrdSysMsg$FriendSysMsg();
                                        FrdSysMsg$GroupInfoExt frdSysMsg$GroupInfoExt = new FrdSysMsg$GroupInfoExt();
                                        str = "this as java.lang.String).getBytes(charset)";
                                        i3 = i17;
                                        frdSysMsg$GroupInfoExt.uint64_group_code.set(g(string5));
                                        frdSysMsg$GroupInfoExt.uint32_notify_type.set(i19);
                                        FrdSysMsg$InviteInfo frdSysMsg$InviteInfo = new FrdSysMsg$InviteInfo();
                                        frdSysMsg$InviteInfo.uint64_recommend_uin.set(g(string6));
                                        frdSysMsg$FriendSysMsg.msg_group_ext.set(frdSysMsg$GroupInfoExt);
                                        frdSysMsg$FriendSysMsg.msg_intite_info.set(frdSysMsg$InviteInfo);
                                        addFriendReq.friend_src_desc = frdSysMsg$FriendSysMsg.toByteArray();
                                    } else {
                                        i3 = i17;
                                        str = "this as java.lang.String).getBytes(charset)";
                                        if (!TextUtils.isEmpty(string5)) {
                                            FrdSysMsg$FriendSysMsg frdSysMsg$FriendSysMsg2 = new FrdSysMsg$FriendSysMsg();
                                            FrdSysMsg$GroupInfoExt frdSysMsg$GroupInfoExt2 = new FrdSysMsg$GroupInfoExt();
                                            i16 = i18;
                                            frdSysMsg$GroupInfoExt2.uint64_group_code.set(g(string5));
                                            frdSysMsg$GroupInfoExt2.uint32_notify_type.set(i19);
                                            frdSysMsg$FriendSysMsg2.msg_group_ext.set(frdSysMsg$GroupInfoExt2);
                                            addFriendReq.friend_src_desc = frdSysMsg$FriendSysMsg2.toByteArray();
                                        }
                                    }
                                    i16 = i18;
                                }
                            } else {
                                i3 = i17;
                                str = "this as java.lang.String).getBytes(charset)";
                                i16 = i18;
                                String string7 = bundle.getString("troop_uin");
                                if (!TextUtils.isEmpty(string7)) {
                                    FrdSysMsg$FriendSysMsg frdSysMsg$FriendSysMsg3 = new FrdSysMsg$FriendSysMsg();
                                    FrdSysMsg$GroupInfoExt frdSysMsg$GroupInfoExt3 = new FrdSysMsg$GroupInfoExt();
                                    frdSysMsg$GroupInfoExt3.uint64_group_code.set(g(string7));
                                    frdSysMsg$FriendSysMsg3.msg_group_ext.set(frdSysMsg$GroupInfoExt3);
                                    addFriendReq.friend_src_desc = frdSysMsg$FriendSysMsg3.toByteArray();
                                }
                            }
                        } else {
                            i3 = i17;
                            str = "this as java.lang.String).getBytes(charset)";
                            i16 = i18;
                            String string8 = bundle.getString("flc_recommend_uin");
                            if (!TextUtils.isEmpty(string8)) {
                                FrdSysMsg$FriendSysMsg frdSysMsg$FriendSysMsg4 = new FrdSysMsg$FriendSysMsg();
                                FrdSysMsg$InviteInfo frdSysMsg$InviteInfo2 = new FrdSysMsg$InviteInfo();
                                frdSysMsg$InviteInfo2.uint64_recommend_uin.set(g(string8));
                                frdSysMsg$FriendSysMsg4.msg_intite_info.set(frdSysMsg$InviteInfo2);
                                addFriendReq.friend_src_desc = frdSysMsg$FriendSysMsg4.toByteArray();
                            }
                        }
                    } else {
                        i3 = i17;
                        str = "this as java.lang.String).getBytes(charset)";
                        i16 = i18;
                        String string9 = bundle.getString("extra");
                        FrdSysMsg$DiscussInfo frdSysMsg$DiscussInfo = new FrdSysMsg$DiscussInfo();
                        frdSysMsg$DiscussInfo.uint64_discuss_uin.set(g(string9));
                        addFriendReq.friend_src_desc = frdSysMsg$DiscussInfo.toByteArray();
                    }
                } else {
                    i3 = i17;
                    str = "this as java.lang.String).getBytes(charset)";
                    i16 = i18;
                    String string10 = bundle.getString("extra");
                    if (string10 != null && string10.length() > 0) {
                        FrdSysMsg$GroupInfo frdSysMsg$GroupInfo = new FrdSysMsg$GroupInfo();
                        frdSysMsg$GroupInfo.uint64_group_uin.set(g(string10));
                        addFriendReq.friend_src_desc = frdSysMsg$GroupInfo.toByteArray();
                    }
                }
                if (QLog.isColorLevel()) {
                    StringBuilder sb5 = new StringBuilder(300);
                    sb5.append("handleAddFriend [uin: ");
                    sb5.append(Utils.U(string3));
                    sb5.append(", source_id: ");
                    int i26 = i3;
                    sb5.append(i26);
                    sb5.append(", sub_source_id: ");
                    sb5.append(i16);
                    if (i26 != 3004) {
                        if (i26 != 3005) {
                            if (i26 != 3022) {
                                if (i26 != 3037) {
                                    if (i26 == 3042) {
                                        sb5.append(", group_code: ");
                                        sb5.append(bundle.getString("troop_uin"));
                                        sb5.append(", notify_type: ");
                                        sb5.append(bundle.getInt("flc_notify_type"));
                                        sb5.append(", recommend_uin: ");
                                        sb5.append(bundle.getString("flc_recommend_uin"));
                                    }
                                } else {
                                    sb5.append(", group_code: ");
                                    sb5.append(bundle.getString("troop_uin"));
                                }
                            } else {
                                sb5.append(", recommend_uin: ");
                                sb5.append(bundle.getString("flc_recommend_uin"));
                            }
                        } else {
                            sb5.append(", discuss_uin: ");
                            sb5.append(bundle.getString("extra"));
                        }
                    } else {
                        sb5.append(", group_uin: ");
                        sb5.append(bundle.getString("extra"));
                    }
                    sb5.append(", friend_src_desc: ");
                    byte[] bArr5 = addFriendReq.friend_src_desc;
                    if (bArr5 == null) {
                        length = 0;
                    } else {
                        length = bArr5.length;
                    }
                    sb5.append(length);
                    sb5.append("]");
                    QLog.i("addFriendTag", 2, sb5.toString());
                }
                int i27 = bundle.getInt("friend_setting");
                byte b17 = bundle.getByte("group_id");
                string = bundle.getString("msg");
                boolean z16 = bundle.getBoolean("auto_send");
                byteArray = bundle.getByteArray(PreloadTRTCPlayerParams.KEY_SIG);
                if (string == null && string.length() > 0) {
                    if (string.length() >= 127) {
                        string = string.substring(0, 126);
                        Intrinsics.checkNotNullExpressionValue(string, "this as java.lang.String\u2026ing(startIndex, endIndex)");
                    }
                    byte[] bytes2 = string.getBytes(Charsets.UTF_8);
                    str2 = str;
                    Intrinsics.checkNotNullExpressionValue(bytes2, str2);
                    b16 = (byte) bytes2.length;
                } else {
                    str2 = str;
                    b16 = 0;
                }
                addFriendReq.adduinsetting = i27;
                addFriendReq.myAllowFlag = (byte) 1;
                addFriendReq.msgLen = b16;
                if (string != null) {
                    addFriendReq.f400383msg = string;
                }
                addFriendReq.myfriendgroupid = b17;
                addFriendReq.contact_bothway_friend = bundle.getBoolean("contact_bothway", false);
                addFriendReq.showMyCard = bundle.getByte("show_my_card");
                addFriendReq.secSign = p(addFriendReq);
                string2 = bundle.getString("remark");
                if (!TextUtils.isEmpty(string2)) {
                    if (string2 != null) {
                        try {
                            Charset forName = Charset.forName("utf-8");
                            Intrinsics.checkNotNullExpressionValue(forName, "forName(charsetName)");
                            bytes = string2.getBytes(forName);
                            Intrinsics.checkNotNullExpressionValue(bytes, str2);
                        } catch (UnsupportedEncodingException e16) {
                            e16.printStackTrace();
                        }
                        addFriendReq.remark = bytes;
                    }
                    bytes = null;
                    addFriendReq.remark = bytes;
                }
                addFriendReq.autoSend = z16 ? (byte) 1 : (byte) 0;
                if (byteArray != null) {
                    addFriendReq.sig = byteArray;
                }
                byteArray2 = bundle.getByteArray("flc_add_frd_token");
                if (byteArray2 != null && byteArray2.length > 0) {
                    addFriendReq.token = byteArray2;
                    if (QLog.isColorLevel()) {
                        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                        String format = String.format("handleAddFriend token: %s", Arrays.copyOf(new Object[]{Integer.valueOf(byteArray2.length)}, 1));
                        Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
                        QLog.i("addFriendTag", 2, format);
                    }
                }
                ticket = bundle.getString("security_ticket", "");
                if (!TextUtils.isEmpty(ticket)) {
                    try {
                        Intrinsics.checkNotNullExpressionValue(ticket, "ticket");
                        Charset forName2 = Charset.forName("utf-8");
                        Intrinsics.checkNotNullExpressionValue(forName2, "forName(charsetName)");
                        byte[] bytes3 = ticket.getBytes(forName2);
                        Intrinsics.checkNotNullExpressionValue(bytes3, str2);
                        addFriendReq.verify = bytes3;
                    } catch (UnsupportedEncodingException e17) {
                        QLog.e("IMCore.friend.FriendAddJCECoder", 1, "handleAddFriend, ", e17);
                    }
                    if (QLog.isColorLevel()) {
                        StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
                        String format2 = String.format("handleAddFriend token: %s", Arrays.copyOf(new Object[]{Integer.valueOf(ticket.length())}, 1));
                        Intrinsics.checkNotNullExpressionValue(format2, "format(format, *args)");
                        QLog.i("IMCore.friend.FriendAddJCECoder", 2, format2);
                    }
                }
                if (addFriendReq.friend_src_desc == null && (byteArray3 = bundle.getByteArray("friend_src_desc")) != null) {
                    addFriendReq.friend_src_desc = byteArray3;
                    if (QLog.isColorLevel()) {
                        QLog.i("IMCore.friend.FriendAddJCECoder", 2, "handleAddFriend has friend_src_desc extra");
                    }
                }
                addFriendReq.bSupportSecureTips = bundle.getBoolean("security_ticket_support", false);
                addFriendReq.bSupportAddRelief = true;
                if (QLog.isColorLevel()) {
                    QLog.i("IMCore.friend.FriendAddJCECoder", 2, "handleAddFriend bSupportSecureTips: " + addFriendReq.bSupportSecureTips);
                }
                client.setServantName("mqq.IMService.FriendListServiceServantObj");
                client.setFuncName("AddFriendReq");
                client.put("AF", addFriendReq);
                return true;
            }
            str = "this as java.lang.String).getBytes(charset)";
            i16 = i18;
            if (QLog.isColorLevel()) {
            }
            int i272 = bundle.getInt("friend_setting");
            byte b172 = bundle.getByte("group_id");
            string = bundle.getString("msg");
            boolean z162 = bundle.getBoolean("auto_send");
            byteArray = bundle.getByteArray(PreloadTRTCPlayerParams.KEY_SIG);
            if (string == null) {
            }
            str2 = str;
            b16 = 0;
            addFriendReq.adduinsetting = i272;
            addFriendReq.myAllowFlag = (byte) 1;
            addFriendReq.msgLen = b16;
            if (string != null) {
            }
            addFriendReq.myfriendgroupid = b172;
            addFriendReq.contact_bothway_friend = bundle.getBoolean("contact_bothway", false);
            addFriendReq.showMyCard = bundle.getByte("show_my_card");
            addFriendReq.secSign = p(addFriendReq);
            string2 = bundle.getString("remark");
            if (!TextUtils.isEmpty(string2)) {
            }
            addFriendReq.autoSend = z162 ? (byte) 1 : (byte) 0;
            if (byteArray != null) {
            }
            byteArray2 = bundle.getByteArray("flc_add_frd_token");
            if (byteArray2 != null) {
                addFriendReq.token = byteArray2;
                if (QLog.isColorLevel()) {
                }
            }
            ticket = bundle.getString("security_ticket", "");
            if (!TextUtils.isEmpty(ticket)) {
            }
            if (addFriendReq.friend_src_desc == null) {
                addFriendReq.friend_src_desc = byteArray3;
                if (QLog.isColorLevel()) {
                }
            }
            addFriendReq.bSupportSecureTips = bundle.getBoolean("security_ticket_support", false);
            addFriendReq.bSupportAddRelief = true;
            if (QLog.isColorLevel()) {
            }
            client.setServantName("mqq.IMService.FriendListServiceServantObj");
            client.setFuncName("AddFriendReq");
            client.put("AF", addFriendReq);
            return true;
        }
        str = "this as java.lang.String).getBytes(charset)";
        i3 = i17;
        i16 = i18;
        if (QLog.isColorLevel()) {
        }
        int i2722 = bundle.getInt("friend_setting");
        byte b1722 = bundle.getByte("group_id");
        string = bundle.getString("msg");
        boolean z1622 = bundle.getBoolean("auto_send");
        byteArray = bundle.getByteArray(PreloadTRTCPlayerParams.KEY_SIG);
        if (string == null) {
        }
        str2 = str;
        b16 = 0;
        addFriendReq.adduinsetting = i2722;
        addFriendReq.myAllowFlag = (byte) 1;
        addFriendReq.msgLen = b16;
        if (string != null) {
        }
        addFriendReq.myfriendgroupid = b1722;
        addFriendReq.contact_bothway_friend = bundle.getBoolean("contact_bothway", false);
        addFriendReq.showMyCard = bundle.getByte("show_my_card");
        addFriendReq.secSign = p(addFriendReq);
        string2 = bundle.getString("remark");
        if (!TextUtils.isEmpty(string2)) {
        }
        addFriendReq.autoSend = z1622 ? (byte) 1 : (byte) 0;
        if (byteArray != null) {
        }
        byteArray2 = bundle.getByteArray("flc_add_frd_token");
        if (byteArray2 != null) {
        }
        ticket = bundle.getString("security_ticket", "");
        if (!TextUtils.isEmpty(ticket)) {
        }
        if (addFriendReq.friend_src_desc == null) {
        }
        addFriendReq.bSupportSecureTips = bundle.getBoolean("security_ticket_support", false);
        addFriendReq.bSupportAddRelief = true;
        if (QLog.isColorLevel()) {
        }
        client.setServantName("mqq.IMService.FriendListServiceServantObj");
        client.setFuncName("AddFriendReq");
        client.put("AF", addFriendReq);
        return true;
    }

    public final boolean l(@NotNull ToServiceMsg request, @NotNull UniPacket client) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this, (Object) request, (Object) client)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(request, "request");
        Intrinsics.checkNotNullParameter(client, "client");
        GetAutoInfoReq getAutoInfoReq = new GetAutoInfoReq();
        getAutoInfoReq.uin = g(request.getUin());
        getAutoInfoReq.dwFriendUin = g(request.extraData.getString("uin"));
        getAutoInfoReq.cType = request.extraData.getByte("cType");
        getAutoInfoReq.sourceID = request.extraData.getInt("source_id", BuddySource.DEFAULT);
        getAutoInfoReq.sourceSubID = request.extraData.getInt("sub_source_id", 0);
        client.setServantName("mqq.IMService.FriendListServiceServantObj");
        client.setFuncName("GetAutoInfoReq");
        client.put("GAIREQ", getAutoInfoReq);
        return true;
    }

    public final boolean m(@NotNull ToServiceMsg request, @NotNull UniPacket client) {
        byte[] bArr;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this, (Object) request, (Object) client)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(request, "request");
        Intrinsics.checkNotNullParameter(client, "client");
        long g16 = g(request.getUin());
        if (g16 == 0) {
            return false;
        }
        Bundle bundle = request.extraData;
        int i3 = bundle.getInt("source_id");
        int i16 = bundle.getInt("sub_source_id");
        String string = bundle.getString("uin");
        String string2 = bundle.getString("extra");
        GetUserAddFriendSettingReq getUserAddFriendSettingReq = new GetUserAddFriendSettingReq();
        getUserAddFriendSettingReq.version = 1L;
        getUserAddFriendSettingReq.uin = g16;
        getUserAddFriendSettingReq.sourceID = i3;
        byte[] bArr2 = null;
        if (friendlist.a.a(i3)) {
            if (string != null) {
                bArr2 = string.getBytes(Charsets.UTF_8);
                Intrinsics.checkNotNullExpressionValue(bArr2, "this as java.lang.String).getBytes(charset)");
            }
            getUserAddFriendSettingReq.name = bArr2;
        } else if (n(i3, i16)) {
            if (TextUtils.isEmpty(string2)) {
                return false;
            }
            if (string != null) {
                bArr = string.getBytes(Charsets.UTF_8);
                Intrinsics.checkNotNullExpressionValue(bArr, "this as java.lang.String).getBytes(charset)");
            } else {
                bArr = null;
            }
            getUserAddFriendSettingReq.name = bArr;
            if (string2 != null) {
                bArr2 = string2.getBytes(Charsets.UTF_8);
                Intrinsics.checkNotNullExpressionValue(bArr2, "this as java.lang.String).getBytes(charset)");
            }
            getUserAddFriendSettingReq.name1 = bArr2;
            getUserAddFriendSettingReq.sourceSubID = i16;
        } else if (i3 == 3026) {
            getUserAddFriendSettingReq.sourceSubID = i16;
            if (i16 == 0) {
                if (string != null) {
                    bArr2 = string.getBytes(Charsets.UTF_8);
                    Intrinsics.checkNotNullExpressionValue(bArr2, "this as java.lang.String).getBytes(charset)");
                }
                getUserAddFriendSettingReq.name = bArr2;
            } else {
                long g17 = g(string);
                if (g17 == 0) {
                    return false;
                }
                getUserAddFriendSettingReq.queryuin = g17;
            }
        } else {
            long g18 = g(string);
            if (g18 == 0) {
                return false;
            }
            getUserAddFriendSettingReq.queryuin = g18;
        }
        client.setServantName("mqq.IMService.FriendListServiceServantObj");
        client.setFuncName("GetUserAddFriendSettingReq");
        client.put("FS", getUserAddFriendSettingReq);
        return true;
    }
}
