package com.tencent.mobileqq.addfriend.api.impl;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.component.network.downloader.impl.ipc.Const;
import com.tencent.mobileqq.icgame.api.room.PreloadTRTCPlayerParams;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qsec.qsecurity.QSec;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.util.Utils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.AccountInfo;
import com.tencent.qqnt.kernel.nativeinterface.AddBuddyReq;
import com.tencent.qqnt.kernel.nativeinterface.BuddySettingReq;
import com.tencent.qqnt.kernel.nativeinterface.BuddySource;
import com.tencent.qqnt.kernel.nativeinterface.OpenidAccInfo;
import com.tencent.qqnt.kernel.nativeinterface.SmartReq;
import com.tencent.qqprotect.qsec.api.IO3CollectDataApi;
import cooperation.qzone.report.lp.LpReportInfo_dc04586;
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

/* compiled from: P */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\u0012\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u0007\u00a2\u0006\u0004\b+\u0010,J\u001c\u0010\u0006\u001a\u00020\u00052\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0002J\u001a\u0010\n\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\u00022\u0006\u0010\t\u001a\u00020\bH\u0002J \u0010\u0012\u001a\u00020\u00112\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J \u0010\u0014\u001a\u00020\u00132\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J\u0018\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J \u0010\u0017\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J2\u0010\u001a\u001a\u00020\u00132\b\u0010\u0018\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J\u0018\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u001b\u001a\u00020\u000fH\u0002J\u0010\u0010\u001f\u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u001cH\u0002J\u0010\u0010!\u001a\u00020\u00132\u0006\u0010 \u001a\u00020\u0002H\u0002J\u0010\u0010%\u001a\u0004\u0018\u00010$2\u0006\u0010#\u001a\u00020\"J\u000e\u0010'\u001a\u00020\u00052\u0006\u0010&\u001a\u00020\"J\u0010\u0010(\u001a\u0004\u0018\u00010\u000f2\u0006\u0010&\u001a\u00020\"J\u000e\u0010*\u001a\u00020)2\u0006\u0010&\u001a\u00020\"\u00a8\u0006-"}, d2 = {"Lcom/tencent/mobileqq/addfriend/api/impl/a;", "Lcom/tencent/qqnt/remote/a;", "", "uid", "uin", "Lcom/tencent/qqnt/kernel/nativeinterface/AccountInfo;", "e", "openID", "", "appID", "d", "", "iUin", "Landroid/os/Bundle;", "bundle", "Lcom/tencent/qqnt/kernel/nativeinterface/AddBuddyReq;", "addBuddyReq", "", "b", "", "a", DomainData.DOMAIN_NAME, "sourceID", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "addUin", "subSourceId", "c", "addReq", "", "l", "bytes", "f", "see", "k", "Lcom/tencent/qqnt/remote/d;", Const.BUNDLE_KEY_REQUEST, "Lcom/tencent/qqnt/kernel/nativeinterface/BuddySettingReq;", "i", "toNTMsg", tl.h.F, "g", "Lcom/tencent/qqnt/kernel/nativeinterface/SmartReq;", "j", "<init>", "()V", "qqaddfriend-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class a extends com.tencent.qqnt.remote.a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/addfriend/api/impl/a$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqaddfriend-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.addfriend.api.impl.a$a, reason: collision with other inner class name and from kotlin metadata */
    /* loaded from: classes10.dex */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(20760);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final void a(long iUin, Bundle bundle, AddBuddyReq addBuddyReq) {
        int i3;
        int i16 = bundle.getInt("friend_setting");
        int i17 = bundle.getInt("group_id");
        String string = bundle.getString("msg");
        boolean z16 = bundle.getBoolean("auto_send");
        byte[] byteArray = bundle.getByteArray(PreloadTRTCPlayerParams.KEY_SIG);
        if (string != null && string.length() > 0) {
            if (string.length() >= 127) {
                string = string.substring(0, 126);
                Intrinsics.checkNotNullExpressionValue(string, "this as java.lang.String\u2026ing(startIndex, endIndex)");
            }
            byte[] bytes = string.getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
            int length = bytes.length;
        }
        addBuddyReq.addFriendSetting = i16;
        addBuddyReq.myAllowFlag = 1;
        if (string != null) {
            addBuddyReq.answer = string;
        }
        addBuddyReq.myFriendGroupId = i17;
        addBuddyReq.isContactFriend = bundle.getBoolean("contact_bothway", false);
        addBuddyReq.showMyCard = bundle.getByte("show_my_card");
        addBuddyReq.secSign = l(iUin, addBuddyReq);
        String string2 = bundle.getString("remark");
        if (!TextUtils.isEmpty(string2)) {
            byte[] bArr = null;
            if (string2 != null) {
                try {
                    Charset forName = Charset.forName("utf-8");
                    Intrinsics.checkNotNullExpressionValue(forName, "forName(charsetName)");
                    byte[] bytes2 = string2.getBytes(forName);
                    Intrinsics.checkNotNullExpressionValue(bytes2, "this as java.lang.String).getBytes(charset)");
                    bArr = bytes2;
                } catch (UnsupportedEncodingException e16) {
                    e16.printStackTrace();
                }
            }
            addBuddyReq.remark = bArr;
        }
        if (z16) {
            i3 = 1;
        } else {
            i3 = 0;
        }
        addBuddyReq.autoSend = i3;
        if (byteArray != null) {
            addBuddyReq.sig = byteArray;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x007d, code lost:
    
        r12 = kotlin.text.StringsKt__StringNumberConversionsKt.toIntOrNull(r12);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final boolean b(long iUin, Bundle bundle, AddBuddyReq addBuddyReq) {
        byte[] bArr;
        byte[] bArr2;
        Integer intOrNull;
        String string = bundle.getString("uin", "");
        String string2 = bundle.getString("uid", "");
        int i3 = bundle.getInt("source_id", BuddySource.DEFAULT);
        int i16 = 0;
        int i17 = bundle.getInt("sub_source_id", 0);
        byte[] byteArray = bundle.getByteArray("third_source_id");
        int i18 = bundle.getInt("type");
        addBuddyReq.sourceId = i3;
        addBuddyReq.sourceSubId = i17;
        addBuddyReq.permissionInfo = bundle.getByteArray("friend_permission_byte_array");
        if (byteArray != null) {
            addBuddyReq.extInfo = byteArray;
        }
        byte[] bArr3 = null;
        if (com.tencent.mobileqq.addfriend.utils.a.m(i3, i17)) {
            String string3 = bundle.getString("extra");
            if (TextUtils.isEmpty(string) || TextUtils.isEmpty(string3)) {
                return false;
            }
            if (string != null) {
                bArr2 = string.getBytes(Charsets.UTF_8);
                Intrinsics.checkNotNullExpressionValue(bArr2, "this as java.lang.String).getBytes(charset)");
            } else {
                bArr2 = null;
            }
            addBuddyReq.name = bArr2;
            if (string3 != null) {
                bArr3 = string3.getBytes(Charsets.UTF_8);
                Intrinsics.checkNotNullExpressionValue(bArr3, "this as java.lang.String).getBytes(charset)");
            }
            addBuddyReq.name1 = bArr3;
            if (string3 != null && intOrNull != null) {
                i16 = intOrNull.intValue();
            }
            addBuddyReq.targetInfo = d(string, i16);
        } else if (!friendlist.a.a(i3) && i18 != 2) {
            if (i3 == 3026) {
                if (i17 == 0) {
                    if (TextUtils.isEmpty(string)) {
                        return false;
                    }
                    if (string != null) {
                        bArr3 = string.getBytes(Charsets.UTF_8);
                        Intrinsics.checkNotNullExpressionValue(bArr3, "this as java.lang.String).getBytes(charset)");
                    }
                    addBuddyReq.name = bArr3;
                } else {
                    long c16 = com.tencent.mobileqq.addfriend.utils.a.c(string);
                    if (c16 == 0 || iUin == c16) {
                        return false;
                    }
                    addBuddyReq.targetInfo = e(string2, String.valueOf(c16));
                }
            } else {
                if (com.tencent.mobileqq.addfriend.utils.a.c(string) == 0) {
                    return false;
                }
                addBuddyReq.targetInfo = e(string2, string);
                m(i3, bundle, addBuddyReq);
            }
        } else {
            if (TextUtils.isEmpty(string)) {
                return false;
            }
            if (string != null) {
                bArr = string.getBytes(Charsets.UTF_8);
                Intrinsics.checkNotNullExpressionValue(bArr, "this as java.lang.String).getBytes(charset)");
            } else {
                bArr = null;
            }
            addBuddyReq.name = bArr;
            addBuddyReq.targetInfo.uin = null;
        }
        c(string, i3, i17, bundle, addBuddyReq);
        return true;
    }

    private final void c(String addUin, int sourceID, int subSourceId, Bundle bundle, AddBuddyReq addBuddyReq) {
        int length;
        if (QLog.isColorLevel()) {
            StringBuilder sb5 = new StringBuilder(300);
            sb5.append("handleAddFriend [uin: ");
            sb5.append(Utils.U(addUin));
            sb5.append(", source_id: ");
            sb5.append(sourceID);
            sb5.append(", sub_source_id: ");
            sb5.append(subSourceId);
            if (sourceID != 3004) {
                if (sourceID != 3005) {
                    if (sourceID != 3022) {
                        if (sourceID != 3037) {
                            if (sourceID == 3042) {
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
            byte[] bArr = addBuddyReq.friendSrcDesc;
            if (bArr == null) {
                length = 0;
            } else {
                length = bArr.length;
            }
            sb5.append(length);
            sb5.append("]");
            QLog.i("AddFriendNTCoder", 2, sb5.toString());
        }
    }

    private final AccountInfo d(String openID, int appID) {
        AccountInfo accountInfo = new AccountInfo();
        OpenidAccInfo openidAccInfo = new OpenidAccInfo();
        accountInfo.openid = openidAccInfo;
        openidAccInfo.openid = openID;
        openidAccInfo.appid = appID;
        return accountInfo;
    }

    /* JADX WARN: Code restructure failed: missing block: B:3:0x0009, code lost:
    
        r2 = kotlin.text.StringsKt__StringNumberConversionsKt.toLongOrNull(r3);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final AccountInfo e(String uid, String uin) {
        long j3;
        AccountInfo accountInfo = new AccountInfo();
        accountInfo.uid = uid;
        if (uin == null || j3 == null) {
            j3 = 0L;
        }
        accountInfo.uin = j3;
        return accountInfo;
    }

    private final String f(byte[] bytes) {
        StringBuilder sb5 = new StringBuilder();
        for (byte b16 : bytes) {
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String format = String.format("0x%02x,", Arrays.copyOf(new Object[]{Byte.valueOf(b16)}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
            sb5.append(format);
        }
        String sb6 = sb5.toString();
        Intrinsics.checkNotNullExpressionValue(sb6, "sbbuf.toString()");
        return sb6;
    }

    private final void k(String see) {
        ((IO3CollectDataApi) QRoute.api(IO3CollectDataApi.class)).sampling(MobileQQ.sMobileQQ.peekAppRuntime().getApplicationContext(), see, "AddFriend");
    }

    private final byte[] l(long iUin, AddBuddyReq addReq) {
        Long l3;
        byte[] bArr = new byte[20];
        com.tencent.mobileqq.friend.utils.d.b(bArr, 0, iUin);
        AccountInfo accountInfo = addReq.targetInfo;
        if (accountInfo != null && (l3 = accountInfo.uin) != null) {
            com.tencent.mobileqq.friend.utils.d.b(bArr, 8, l3.longValue());
        }
        com.tencent.mobileqq.friend.utils.d.a(bArr, 16, addReq.sourceId);
        if (QLog.isColorLevel()) {
            QLog.d("AddFriendNTCoder", 2, "secSalt: " + f(bArr));
        }
        byte[] bArr2 = new byte[1];
        if (com.tencent.mobileqq.fe.e.b().i()) {
            QSec.getInstance().initSign();
            bArr2 = QSec.getInstance().getLiteSign(LpReportInfo_dc04586.ITEM_ID_BTN_ADD_FRIEND, bArr);
            Intrinsics.checkNotNullExpressionValue(bArr2, "getInstance().getLiteSign(\"add_friend\", secSalt)");
        }
        if (QLog.isColorLevel()) {
            QLog.d("AddFriendNTCoder", 2, "secSign: " + f(bArr2));
        }
        return bArr2;
    }

    private final void m(int sourceID, Bundle bundle, AddBuddyReq addBuddyReq) {
        if (sourceID != 3004) {
            if (sourceID != 3005) {
                if (sourceID != 3022) {
                    if (sourceID != 3037) {
                        if (sourceID == 3042) {
                            String string = bundle.getString("troop_uin");
                            int i3 = bundle.getInt("flc_notify_type");
                            String string2 = bundle.getString("flc_recommend_uin");
                            if (!TextUtils.isEmpty(string2) && !TextUtils.isEmpty(string)) {
                                FrdSysMsg$FriendSysMsg frdSysMsg$FriendSysMsg = new FrdSysMsg$FriendSysMsg();
                                FrdSysMsg$GroupInfoExt frdSysMsg$GroupInfoExt = new FrdSysMsg$GroupInfoExt();
                                frdSysMsg$GroupInfoExt.uint64_group_code.set(com.tencent.mobileqq.addfriend.utils.a.c(string));
                                frdSysMsg$GroupInfoExt.uint32_notify_type.set(i3);
                                FrdSysMsg$InviteInfo frdSysMsg$InviteInfo = new FrdSysMsg$InviteInfo();
                                frdSysMsg$InviteInfo.uint64_recommend_uin.set(com.tencent.mobileqq.addfriend.utils.a.c(string2));
                                frdSysMsg$FriendSysMsg.msg_group_ext.set(frdSysMsg$GroupInfoExt);
                                frdSysMsg$FriendSysMsg.msg_intite_info.set(frdSysMsg$InviteInfo);
                                addBuddyReq.friendSrcDesc = frdSysMsg$FriendSysMsg.toByteArray();
                                return;
                            }
                            if (!TextUtils.isEmpty(string)) {
                                FrdSysMsg$FriendSysMsg frdSysMsg$FriendSysMsg2 = new FrdSysMsg$FriendSysMsg();
                                FrdSysMsg$GroupInfoExt frdSysMsg$GroupInfoExt2 = new FrdSysMsg$GroupInfoExt();
                                frdSysMsg$GroupInfoExt2.uint64_group_code.set(com.tencent.mobileqq.addfriend.utils.a.c(string));
                                frdSysMsg$GroupInfoExt2.uint32_notify_type.set(i3);
                                frdSysMsg$FriendSysMsg2.msg_group_ext.set(frdSysMsg$GroupInfoExt2);
                                addBuddyReq.friendSrcDesc = frdSysMsg$FriendSysMsg2.toByteArray();
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    String string3 = bundle.getString("troop_uin");
                    if (!TextUtils.isEmpty(string3)) {
                        FrdSysMsg$FriendSysMsg frdSysMsg$FriendSysMsg3 = new FrdSysMsg$FriendSysMsg();
                        FrdSysMsg$GroupInfoExt frdSysMsg$GroupInfoExt3 = new FrdSysMsg$GroupInfoExt();
                        frdSysMsg$GroupInfoExt3.uint64_group_code.set(com.tencent.mobileqq.addfriend.utils.a.c(string3));
                        frdSysMsg$FriendSysMsg3.msg_group_ext.set(frdSysMsg$GroupInfoExt3);
                        addBuddyReq.friendSrcDesc = frdSysMsg$FriendSysMsg3.toByteArray();
                        return;
                    }
                    return;
                }
                String string4 = bundle.getString("flc_recommend_uin");
                if (!TextUtils.isEmpty(string4)) {
                    FrdSysMsg$FriendSysMsg frdSysMsg$FriendSysMsg4 = new FrdSysMsg$FriendSysMsg();
                    FrdSysMsg$InviteInfo frdSysMsg$InviteInfo2 = new FrdSysMsg$InviteInfo();
                    frdSysMsg$InviteInfo2.uint64_recommend_uin.set(com.tencent.mobileqq.addfriend.utils.a.c(string4));
                    frdSysMsg$FriendSysMsg4.msg_intite_info.set(frdSysMsg$InviteInfo2);
                    addBuddyReq.friendSrcDesc = frdSysMsg$FriendSysMsg4.toByteArray();
                    return;
                }
                return;
            }
            String string5 = bundle.getString("extra");
            FrdSysMsg$DiscussInfo frdSysMsg$DiscussInfo = new FrdSysMsg$DiscussInfo();
            frdSysMsg$DiscussInfo.uint64_discuss_uin.set(com.tencent.mobileqq.addfriend.utils.a.c(string5));
            addBuddyReq.friendSrcDesc = frdSysMsg$DiscussInfo.toByteArray();
            return;
        }
        String string6 = bundle.getString("extra");
        if (string6 != null && string6.length() > 0) {
            FrdSysMsg$GroupInfo frdSysMsg$GroupInfo = new FrdSysMsg$GroupInfo();
            frdSysMsg$GroupInfo.uint64_group_uin.set(com.tencent.mobileqq.addfriend.utils.a.c(string6));
            addBuddyReq.friendSrcDesc = frdSysMsg$GroupInfo.toByteArray();
        }
    }

    private final void n(Bundle bundle, AddBuddyReq addBuddyReq) {
        byte[] byteArray = bundle.getByteArray("flc_add_frd_token");
        if (byteArray != null && byteArray.length > 0) {
            addBuddyReq.token = byteArray;
            if (QLog.isColorLevel()) {
                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                String format = String.format("handleAddFriend token: %s", Arrays.copyOf(new Object[]{Integer.valueOf(byteArray.length)}, 1));
                Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
                QLog.i("addFriendTag", 2, format);
            }
        }
        String ticket = bundle.getString("security_ticket", "");
        if (!TextUtils.isEmpty(ticket)) {
            try {
                Intrinsics.checkNotNullExpressionValue(ticket, "ticket");
                Charset forName = Charset.forName("utf-8");
                Intrinsics.checkNotNullExpressionValue(forName, "forName(charsetName)");
                byte[] bytes = ticket.getBytes(forName);
                Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
                addBuddyReq.verify = bytes;
            } catch (UnsupportedEncodingException e16) {
                QLog.e("AddFriendNTCoder", 1, "handleAddFriend, ", e16);
            }
            if (QLog.isColorLevel()) {
                StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
                String format2 = String.format("handleAddFriend token: %s", Arrays.copyOf(new Object[]{Integer.valueOf(ticket.length())}, 1));
                Intrinsics.checkNotNullExpressionValue(format2, "format(format, *args)");
                QLog.i("AddFriendNTCoder", 2, format2);
            }
        }
    }

    @Nullable
    public final AddBuddyReq g(@NotNull com.tencent.qqnt.remote.d toNTMsg) {
        byte[] byteArray;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (AddBuddyReq) iPatchRedirector.redirect((short) 5, (Object) this, (Object) toNTMsg);
        }
        Intrinsics.checkNotNullParameter(toNTMsg, "toNTMsg");
        k(LpReportInfo_dc04586.ITEM_ID_BTN_ADD_FRIEND);
        long c16 = com.tencent.mobileqq.addfriend.utils.a.c(toNTMsg.d());
        if (c16 == 0) {
            return null;
        }
        Bundle a16 = toNTMsg.a();
        AddBuddyReq addBuddyReq = new AddBuddyReq();
        if (!b(c16, a16, addBuddyReq)) {
            return null;
        }
        a(c16, a16, addBuddyReq);
        n(a16, addBuddyReq);
        if (addBuddyReq.friendSrcDesc == null && (byteArray = a16.getByteArray("friend_src_desc")) != null) {
            addBuddyReq.friendSrcDesc = byteArray;
            if (QLog.isColorLevel()) {
                QLog.i("AddFriendNTCoder", 2, "handleAddFriend has friend_src_desc extra");
            }
        }
        addBuddyReq.bSupportSecureTips = Boolean.valueOf(a16.getBoolean("security_ticket_support", false));
        addBuddyReq.bSupportAddRelief = Boolean.TRUE;
        if (QLog.isColorLevel()) {
            QLog.i("AddFriendNTCoder", 2, "handleAddFriend bSupportSecureTips: " + addBuddyReq.bSupportSecureTips);
        }
        return addBuddyReq;
    }

    @NotNull
    public final AccountInfo h(@NotNull com.tencent.qqnt.remote.d toNTMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (AccountInfo) iPatchRedirector.redirect((short) 4, (Object) this, (Object) toNTMsg);
        }
        Intrinsics.checkNotNullParameter(toNTMsg, "toNTMsg");
        return e("", String.valueOf(toNTMsg.a().getLong("uin")));
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x009b, code lost:
    
        r12 = kotlin.text.StringsKt__StringNumberConversionsKt.toIntOrNull(r7);
     */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final BuddySettingReq i(@NotNull com.tencent.qqnt.remote.d request) {
        byte[] bArr;
        int i3;
        Integer intOrNull;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (BuddySettingReq) iPatchRedirector.redirect((short) 3, (Object) this, (Object) request);
        }
        Intrinsics.checkNotNullParameter(request, "request");
        byte[] bArr2 = null;
        if (com.tencent.mobileqq.addfriend.utils.a.c(request.d()) == 0) {
            return null;
        }
        Bundle a16 = request.a();
        int i16 = a16.getInt("source_id");
        int i17 = a16.getInt("sub_source_id");
        String string = a16.getString("uin");
        String string2 = a16.getString("uid");
        String string3 = a16.getString("extra");
        int i18 = a16.getInt("type");
        BuddySettingReq buddySettingReq = new BuddySettingReq();
        buddySettingReq.version = 1;
        buddySettingReq.sourceId = i16;
        if (!friendlist.a.a(i16) && i18 != 2) {
            if (com.tencent.mobileqq.addfriend.utils.a.m(i16, i17)) {
                if (TextUtils.isEmpty(string3)) {
                    return null;
                }
                if (string != null) {
                    bArr = string.getBytes(Charsets.UTF_8);
                    Intrinsics.checkNotNullExpressionValue(bArr, "this as java.lang.String).getBytes(charset)");
                } else {
                    bArr = null;
                }
                buddySettingReq.name = bArr;
                if (string3 != null) {
                    bArr2 = string3.getBytes(Charsets.UTF_8);
                    Intrinsics.checkNotNullExpressionValue(bArr2, "this as java.lang.String).getBytes(charset)");
                }
                buddySettingReq.name1 = bArr2;
                buddySettingReq.sourceSubId = i17;
                if (string3 != null && intOrNull != null) {
                    i3 = intOrNull.intValue();
                } else {
                    i3 = 0;
                }
                buddySettingReq.targetInfo = d(string, i3);
            } else if (i16 == 3026) {
                buddySettingReq.sourceSubId = i17;
                if (i17 == 0) {
                    if (string != null) {
                        bArr2 = string.getBytes(Charsets.UTF_8);
                        Intrinsics.checkNotNullExpressionValue(bArr2, "this as java.lang.String).getBytes(charset)");
                    }
                    buddySettingReq.name = bArr2;
                } else {
                    long c16 = com.tencent.mobileqq.addfriend.utils.a.c(string);
                    if (c16 == 0) {
                        return null;
                    }
                    buddySettingReq.targetInfo = e(string2, String.valueOf(c16));
                }
            } else {
                long c17 = com.tencent.mobileqq.addfriend.utils.a.c(string);
                if (c17 == 0) {
                    return null;
                }
                buddySettingReq.targetInfo = e(string2, String.valueOf(c17));
            }
        } else {
            if (string != null) {
                bArr2 = string.getBytes(Charsets.UTF_8);
                Intrinsics.checkNotNullExpressionValue(bArr2, "this as java.lang.String).getBytes(charset)");
            }
            buddySettingReq.name = bArr2;
        }
        return buddySettingReq;
    }

    @NotNull
    public final SmartReq j(@NotNull com.tencent.qqnt.remote.d toNTMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (SmartReq) iPatchRedirector.redirect((short) 6, (Object) this, (Object) toNTMsg);
        }
        Intrinsics.checkNotNullParameter(toNTMsg, "toNTMsg");
        SmartReq smartReq = new SmartReq();
        smartReq.targetInfo = e("", String.valueOf(com.tencent.mobileqq.addfriend.utils.a.c(toNTMsg.a().getString("uin"))));
        return smartReq;
    }
}
