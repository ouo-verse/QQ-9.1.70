package com.tencent.mobileqq.troop.filemanager.data;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.data.n;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.ntrelation.friendsinfo.api.IFriendsInfoService;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import java.util.ArrayList;
import java.util.List;
import tencent.im.cs.cmd0x383.cmd0x383$ApplyFileSearchRspBody;

/* compiled from: P */
/* loaded from: classes19.dex */
public class d {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public long f295820a;

    /* renamed from: b, reason: collision with root package name */
    public String f295821b;

    /* renamed from: c, reason: collision with root package name */
    public long f295822c;

    /* renamed from: d, reason: collision with root package name */
    public String f295823d;

    /* renamed from: e, reason: collision with root package name */
    public ArrayList<String> f295824e;

    /* renamed from: f, reason: collision with root package name */
    public long f295825f;

    /* renamed from: g, reason: collision with root package name */
    public String f295826g;

    /* renamed from: h, reason: collision with root package name */
    public String f295827h;

    /* renamed from: i, reason: collision with root package name */
    public n f295828i;

    public d(QQAppInterface qQAppInterface, cmd0x383$ApplyFileSearchRspBody.Item item) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) qQAppInterface, (Object) item);
            return;
        }
        this.f295820a = 0L;
        this.f295821b = null;
        this.f295822c = 0L;
        this.f295823d = null;
        this.f295824e = null;
        this.f295825f = 0L;
        this.f295826g = null;
        this.f295827h = null;
        this.f295828i = null;
        if (item == null) {
            return;
        }
        this.f295820a = item.uint64_group_code.get();
        this.f295821b = item.bytes_group_name.get().toStringUtf8();
        this.f295822c = item.uint64_upload_uin.get();
        this.f295823d = item.bytes_uploader_nick_name.get().toStringUtf8();
        this.f295824e = new ArrayList<>();
        List<ByteStringMicro> list = item.bytes_match_word.get();
        if (list != null) {
            for (int i3 = 0; i3 < list.size(); i3++) {
                this.f295824e.add(list.get(i3).toStringUtf8());
            }
        }
        long j3 = item.uint64_match_uin.get();
        this.f295825f = j3;
        if (j3 > 0) {
            String uidFromUin = ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(String.valueOf(this.f295825f));
            this.f295826g = ((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).getNickWithUid(uidFromUin, "TroopFileSearchItemData<QFile>");
            this.f295827h = ((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).getRemarkWithUid(uidFromUin, "TroopFileSearchItemData<QFile>");
            if (QLog.isColorLevel()) {
                QLog.d("TroopFileSearchItemData<QFile>", 2, "TroopFileSearchItemData matchUin:" + this.f295825f + ", name:" + this.f295826g + ", remark = " + this.f295827h);
            }
        }
        this.f295828i = new n(item.file_info.get());
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append("groupCode = " + this.f295820a);
        sb5.append(", groupName = " + this.f295821b);
        sb5.append(", uploaderUin = " + this.f295822c);
        sb5.append(", uploaderNickName = " + this.f295823d);
        sb5.append(", matchUin = " + this.f295825f);
        if (this.f295824e != null) {
            sb5.append(", matchWord: = ");
            int size = this.f295824e.size();
            for (int i3 = 0; i3 < size; i3++) {
                if (i3 == size - 1) {
                    sb5.append(this.f295824e.get(i3) + ", ");
                } else {
                    sb5.append(this.f295824e.get(i3));
                    sb5.append("\u3001 ");
                }
            }
        }
        if (this.f295828i != null) {
            sb5.append(", fileInfo = " + this.f295828i.toString());
        }
        return sb5.toString();
    }
}
