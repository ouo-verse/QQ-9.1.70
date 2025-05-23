package ef0;

import android.os.Bundle;
import com.tencent.biz.ProtoUtils;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tencent.im.oidb.cmd0x6d8.oidb_0x6d8$GetFileListRspBody;
import tencent.im.oidb.cmd0x6d8.oidb_0x6d8$RspBody;

/* compiled from: P */
/* loaded from: classes5.dex */
public abstract class f extends ProtoUtils.TroopProtocolObserver {
    protected void b(int i3, byte[] bArr, Bundle bundle) {
        boolean z16;
        if (i3 == 0 && bArr != null) {
            oidb_0x6d8$RspBody oidb_0x6d8_rspbody = new oidb_0x6d8$RspBody();
            try {
                oidb_0x6d8_rspbody.mergeFrom(bArr);
                if (!oidb_0x6d8_rspbody.file_list_info_rsp.has()) {
                    if (QLog.isColorLevel()) {
                        QLog.d("TroopFileProtocol", 2, "no FileList rsp.");
                    }
                    c(false, false, 0, 0, 0, null, null, bundle);
                    return;
                }
                oidb_0x6d8$GetFileListRspBody oidb_0x6d8_getfilelistrspbody = oidb_0x6d8_rspbody.file_list_info_rsp.get();
                if (oidb_0x6d8_getfilelistrspbody.int32_ret_code.has()) {
                    int i16 = oidb_0x6d8_getfilelistrspbody.int32_ret_code.get();
                    if (QLog.isColorLevel()) {
                        QLog.i("TroopFileProtocol", 2, "GetFileListObserver, retCode=" + i16);
                    }
                    if (i16 < 0) {
                        if (i16 == -1000) {
                            c(true, false, 0, i16, 0, null, null, bundle);
                            return;
                        } else {
                            c(false, false, 0, 0, 0, null, null, bundle);
                            return;
                        }
                    }
                    int i17 = oidb_0x6d8_getfilelistrspbody.uint32_all_file_count.get();
                    boolean z17 = oidb_0x6d8_getfilelistrspbody.bool_is_end.get();
                    int i18 = oidb_0x6d8_getfilelistrspbody.uint32_next_index.get();
                    ByteStringMicro byteStringMicro = oidb_0x6d8_getfilelistrspbody.bytes_context.get();
                    List<oidb_0x6d8$GetFileListRspBody.Item> list = oidb_0x6d8_getfilelistrspbody.rpt_item_list.get();
                    ArrayList arrayList = new ArrayList();
                    Iterator<oidb_0x6d8$GetFileListRspBody.Item> it = list.iterator();
                    while (it.hasNext()) {
                        arrayList.add(new com.tencent.mobileqq.troop.data.n(it.next()));
                    }
                    c(true, z17, i17, i3, i18, byteStringMicro, arrayList, bundle);
                    return;
                }
                if (QLog.isColorLevel()) {
                    QLog.i("TroopFileProtocol", 2, "GetFileListObserver, has not redCode");
                }
                c(false, false, 0, 0, 0, null, null, bundle);
                return;
            } catch (InvalidProtocolBufferMicroException e16) {
                if (QLog.isColorLevel()) {
                    QLog.i("TroopFileProtocol", 2, "merge data exception," + e16.toString());
                }
                c(false, false, 0, 0, 0, null, null, bundle);
                return;
            }
        }
        if (QLog.isColorLevel()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("GetFileListObserver, errorCode=");
            sb5.append(i3);
            sb5.append(", has data=");
            if (bArr != null) {
                z16 = true;
            } else {
                z16 = false;
            }
            sb5.append(z16);
            QLog.i("TroopFileProtocol", 2, sb5.toString());
        }
        c(false, false, 0, 0, 0, null, null, bundle);
    }

    public abstract void c(boolean z16, boolean z17, int i3, int i16, int i17, ByteStringMicro byteStringMicro, List<com.tencent.mobileqq.troop.data.n> list, Bundle bundle);

    @Override // com.tencent.biz.ProtoUtils.TroopProtocolObserver
    public void onResult(int i3, byte[] bArr, Bundle bundle) {
        b(i3, bArr, bundle);
    }
}
