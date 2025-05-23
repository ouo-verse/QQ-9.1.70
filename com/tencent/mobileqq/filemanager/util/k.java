package com.tencent.mobileqq.filemanager.util;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.msg.api.IFeatureSwitch;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import msf.msgcomm.msg_comm$Msg;
import tencent.im.msg.hummer.resv.generalflags$ResvAttr;
import tencent.im.msg.im_msg_body$Elem;

/* compiled from: P */
/* loaded from: classes12.dex */
public class k {
    public static void a(FileManagerEntity fileManagerEntity, Bundle bundle) {
        if (fileManagerEntity != null && bundle != null && bundle.containsKey("key_from_scene")) {
            fileManagerEntity.fromScene = e(bundle);
        }
    }

    public static void b(MessageRecord messageRecord, Bundle bundle) {
        if (bundle != null && messageRecord != null && bundle.containsKey("key_from_scene")) {
            c(messageRecord, e(bundle));
        }
    }

    public static void c(MessageRecord messageRecord, int i3) {
        if (messageRecord == null) {
            return;
        }
        if (i3 == 0) {
            messageRecord.removeExtInfoToExtStr("_m_ForwardFromScene");
        } else {
            messageRecord.saveExtInfoToExtStr("_m_ForwardFromScene", String.valueOf(i3));
        }
    }

    public static void d(MessageRecord messageRecord, msg_comm$Msg msg_comm_msg) {
        if (messageRecord != null && msg_comm_msg != null && msg_comm_msg.msg_body.has() && msg_comm_msg.msg_body.rich_text.has()) {
            for (im_msg_body$Elem im_msg_body_elem : msg_comm_msg.msg_body.rich_text.elems.get()) {
                if (im_msg_body_elem.general_flags.has() && im_msg_body_elem.general_flags.bytes_pb_reserve.has()) {
                    try {
                        generalflags$ResvAttr generalflags_resvattr = new generalflags$ResvAttr();
                        generalflags_resvattr.mergeFrom(im_msg_body_elem.general_flags.bytes_pb_reserve.get().toByteArray());
                        if (generalflags_resvattr.unit32_file_from_scene.has()) {
                            c(messageRecord, generalflags_resvattr.unit32_file_from_scene.get());
                            return;
                        }
                        return;
                    } catch (Exception e16) {
                        QLog.d("<FileAssistant>FileExtOpUtil", 1, e16, new Object[0]);
                    }
                }
            }
        }
    }

    public static int e(Bundle bundle) {
        if (bundle == null) {
            return 0;
        }
        return bundle.getInt("key_from_scene", 0);
    }

    public static int f(MessageRecord messageRecord) {
        if (messageRecord == null) {
            return 0;
        }
        String extInfoFromExtStr = messageRecord.getExtInfoFromExtStr("_m_ForwardFromScene");
        if (!TextUtils.isEmpty(extInfoFromExtStr)) {
            try {
                return Integer.parseInt(extInfoFromExtStr);
            } catch (NumberFormatException e16) {
                QLog.d("<FileAssistant>FileExtOpUtil", 1, e16, new Object[0]);
            }
        }
        return 0;
    }

    public static boolean g(MessageRecord messageRecord) {
        if (!h()) {
            return false;
        }
        int f16 = f(messageRecord);
        if (f16 != 2 && f16 != 1) {
            return false;
        }
        return true;
    }

    public static boolean h() {
        return ((IFeatureSwitch) QRoute.api(IFeatureSwitch.class)).isFeatureSwitchEnable("is_aio_file_from_scene_enable", true);
    }
}
