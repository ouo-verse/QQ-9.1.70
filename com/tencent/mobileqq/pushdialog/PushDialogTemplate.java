package com.tencent.mobileqq.pushdialog;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.notColumn;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.wink.storage.kv.MaskType;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import tencent.im.s2c.msgtype0x210.submsgtype0x122.gray_tips_resv$ResvAttr;
import tencent.im.s2c.msgtype0x210.submsgtype0x122.submsgtype0x122$MsgBody;
import tencent.im.s2c.msgtype0x210.submsgtype0x122.submsgtype0x122$TemplParam;

/* loaded from: classes16.dex */
public class PushDialogTemplate extends Entity {
    static IPatchRedirector $redirector_ = null;

    @notColumn
    private static final byte[] KV_SEPARATOR;

    @notColumn
    private static final byte[] PARAM_SEPARATOR;

    @notColumn
    private static final String TAG = "PushDialogTemplate";
    public long busi_id;
    public long busi_type;
    public int c2c_type;
    public int ctrl_flag;
    public int friend_banned_flag;

    @notColumn
    private List<submsgtype0x122$TemplParam> mParamList;
    public long mUin;
    public byte[] reserv;
    public int service_type;
    public byte[] templ_content;
    public long templ_id;
    public byte[] templ_param;
    public long time;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(74308);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 9)) {
            redirector.redirect((short) 9);
        } else {
            PARAM_SEPARATOR = new byte[]{35, 33};
            KV_SEPARATOR = new byte[]{MaskType.MASK_TYPE_EXTERNAL, 33};
        }
    }

    public PushDialogTemplate() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            this.friend_banned_flag = -1;
        } else {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private static byte[] byteMergerAll(byte[]... bArr) {
        int i3 = 0;
        for (byte[] bArr2 : bArr) {
            i3 += bArr2.length;
        }
        byte[] bArr3 = new byte[i3];
        int i16 = 0;
        for (byte[] bArr4 : bArr) {
            System.arraycopy(bArr4, 0, bArr3, i16, bArr4.length);
            i16 += bArr4.length;
        }
        return bArr3;
    }

    private static boolean isBitChecked(int i3, int i16) {
        if ((i3 & (1 << i16)) != 0) {
            return true;
        }
        return false;
    }

    private static boolean isMatch(byte[] bArr, byte[] bArr2, int i3) {
        for (int i16 = 0; i16 < bArr.length; i16++) {
            if (bArr[i16] != bArr2[i3 + i16]) {
                return false;
            }
        }
        return true;
    }

    private static List<byte[]> split(byte[] bArr, byte[] bArr2) {
        LinkedList linkedList = new LinkedList();
        int i3 = 0;
        int i16 = 0;
        while (i3 < bArr2.length) {
            if (isMatch(bArr, bArr2, i3)) {
                linkedList.add(Arrays.copyOfRange(bArr2, i16, i3));
                i3 += bArr.length;
                i16 = i3;
            }
            i3++;
        }
        linkedList.add(Arrays.copyOfRange(bArr2, i16, bArr2.length));
        return linkedList;
    }

    private List<submsgtype0x122$TemplParam> transByteArrayToParamList(byte[] bArr) {
        ArrayList arrayList = new ArrayList();
        List<byte[]> split = split(PARAM_SEPARATOR, bArr);
        for (int i3 = 0; i3 < split.size(); i3++) {
            submsgtype0x122$TemplParam submsgtype0x122_templparam = new submsgtype0x122$TemplParam();
            byte[] bArr2 = split.get(i3);
            int length = bArr2.length;
            byte[] bArr3 = KV_SEPARATOR;
            if (length > bArr3.length) {
                List<byte[]> split2 = split(bArr3, bArr2);
                submsgtype0x122_templparam.bytes_name.set(ByteStringMicro.copyFrom(split2.get(0)));
                submsgtype0x122_templparam.bytes_value.set(ByteStringMicro.copyFrom(split2.get(1)));
                arrayList.add(submsgtype0x122_templparam);
            }
        }
        return arrayList;
    }

    private byte[] transParamListToByteArray(List<submsgtype0x122$TemplParam> list) {
        byte[] bArr = null;
        for (int i3 = 0; i3 < list.size(); i3++) {
            submsgtype0x122$TemplParam submsgtype0x122_templparam = list.get(i3);
            bArr = byteMergerAll(submsgtype0x122_templparam.bytes_name.get().toByteArray(), KV_SEPARATOR, submsgtype0x122_templparam.bytes_value.get().toByteArray(), PARAM_SEPARATOR);
        }
        return bArr;
    }

    public List<submsgtype0x122$TemplParam> getParamList() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (List) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        List<submsgtype0x122$TemplParam> list = this.mParamList;
        if (list != null) {
            return list;
        }
        return transByteArrayToParamList(this.templ_param);
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0059  */
    /* JADX WARN: Removed duplicated region for block: B:27:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean isFriendBanned() {
        gray_tips_resv$ResvAttr gray_tips_resv_resvattr;
        InvalidProtocolBufferMicroException e16;
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        int i16 = this.friend_banned_flag;
        if (i16 >= 0) {
            if (i16 != 1) {
                return false;
            }
            return true;
        }
        if (this.reserv == null) {
            return false;
        }
        try {
            gray_tips_resv_resvattr = new gray_tips_resv$ResvAttr();
        } catch (InvalidProtocolBufferMicroException e17) {
            gray_tips_resv_resvattr = null;
            e16 = e17;
        }
        try {
            gray_tips_resv_resvattr.mergeFrom(this.reserv);
            if (!gray_tips_resv_resvattr.uint32_friend_banned_flag.has()) {
                return false;
            }
        } catch (InvalidProtocolBufferMicroException e18) {
            e16 = e18;
            if (QLog.isColorLevel()) {
                QLog.e(TAG, 2, e16.getMessage());
            }
            i3 = gray_tips_resv_resvattr.uint32_friend_banned_flag.get();
            this.friend_banned_flag = i3;
            if (i3 == 1) {
            }
        }
        i3 = gray_tips_resv_resvattr.uint32_friend_banned_flag.get();
        this.friend_banned_flag = i3;
        if (i3 == 1) {
            return false;
        }
        return true;
    }

    public boolean isShowInGlobal() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this)).booleanValue();
        }
        return isBitChecked(this.ctrl_flag, 3);
    }

    public boolean isShowInMessageHistory() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this)).booleanValue();
        }
        return isBitChecked(this.ctrl_flag, 2);
    }

    public boolean isShowInMessageList() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
        }
        return isBitChecked(this.ctrl_flag, 0);
    }

    public boolean isStoreInDb() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this)).booleanValue();
        }
        return isBitChecked(this.ctrl_flag, 1);
    }

    public PushDialogTemplate(submsgtype0x122$MsgBody submsgtype0x122_msgbody, long j3, long j16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, submsgtype0x122_msgbody, Long.valueOf(j3), Long.valueOf(j16));
            return;
        }
        this.friend_banned_flag = -1;
        this.busi_type = submsgtype0x122_msgbody.uint64_busi_type.get();
        this.busi_id = submsgtype0x122_msgbody.uint64_busi_id.get();
        this.ctrl_flag = submsgtype0x122_msgbody.uint32_ctrl_flag.get();
        this.c2c_type = submsgtype0x122_msgbody.uint32_c2c_type.get();
        this.service_type = submsgtype0x122_msgbody.uint32_service_type.get();
        this.templ_id = submsgtype0x122_msgbody.uint64_templ_id.get();
        this.templ_content = submsgtype0x122_msgbody.bytes_content.get().toByteArray();
        this.reserv = submsgtype0x122_msgbody.bytes_pb_reserv.get().toByteArray();
        this.templ_param = transParamListToByteArray(submsgtype0x122_msgbody.rpt_msg_templ_param.get());
        this.mUin = j3;
        this.time = j16;
    }
}
