package com.tencent.mobileqq.troop.data;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqnt.ntrelation.friendsinfo.api.IFriendsInfoService;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import java.util.ArrayList;
import java.util.List;
import tencent.im.cs.cmd0x383.cmd0x383$ApplyFileSearchRspBody;

/* compiled from: P */
/* loaded from: classes19.dex */
public class s {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public long f294958a;

    /* renamed from: b, reason: collision with root package name */
    public String f294959b;

    /* renamed from: c, reason: collision with root package name */
    public long f294960c;

    /* renamed from: d, reason: collision with root package name */
    public String f294961d;

    /* renamed from: e, reason: collision with root package name */
    public ArrayList<String> f294962e;

    /* renamed from: f, reason: collision with root package name */
    public long f294963f;

    /* renamed from: g, reason: collision with root package name */
    public String f294964g;

    /* renamed from: h, reason: collision with root package name */
    public String f294965h;

    /* renamed from: i, reason: collision with root package name */
    public n f294966i;

    public s(QQAppInterface qQAppInterface, cmd0x383$ApplyFileSearchRspBody.Item item) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) qQAppInterface, (Object) item);
            return;
        }
        this.f294958a = 0L;
        this.f294959b = null;
        this.f294960c = 0L;
        this.f294961d = null;
        this.f294962e = null;
        this.f294963f = 0L;
        this.f294964g = null;
        this.f294965h = null;
        this.f294966i = null;
        if (item == null) {
            return;
        }
        this.f294958a = item.uint64_group_code.get();
        this.f294959b = item.bytes_group_name.get().toStringUtf8();
        this.f294960c = item.uint64_upload_uin.get();
        this.f294961d = item.bytes_uploader_nick_name.get().toStringUtf8();
        this.f294962e = new ArrayList<>();
        List<ByteStringMicro> list = item.bytes_match_word.get();
        if (list != null) {
            for (int i3 = 0; i3 < list.size(); i3++) {
                this.f294962e.add(list.get(i3).toStringUtf8());
            }
        }
        long j3 = item.uint64_match_uin.get();
        this.f294963f = j3;
        if (j3 > 0) {
            com.tencent.qqnt.ntrelation.friendsinfo.bean.d friendsSimpleInfoWithUid = ((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).getFriendsSimpleInfoWithUid(((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(String.valueOf(this.f294963f)), "TroopFileSearchByTypeItemData");
            if (friendsSimpleInfoWithUid != null) {
                this.f294964g = friendsSimpleInfoWithUid.p();
                this.f294965h = friendsSimpleInfoWithUid.r();
            }
        }
        this.f294966i = new n(item.file_info.get());
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append("groupCode = " + this.f294958a);
        sb5.append(", groupName = " + this.f294959b);
        sb5.append(", uploaderUin = " + this.f294960c);
        sb5.append(", uploaderNickName = " + this.f294961d);
        sb5.append(", matchUin = " + this.f294963f);
        if (this.f294962e != null) {
            sb5.append(", matchWord: = ");
            int size = this.f294962e.size();
            for (int i3 = 0; i3 < size; i3++) {
                if (i3 == size - 1) {
                    sb5.append(this.f294962e.get(i3) + ", ");
                } else {
                    sb5.append(this.f294962e.get(i3));
                    sb5.append("\u3001 ");
                }
            }
        }
        if (this.f294966i != null) {
            sb5.append(", fileInfo = " + this.f294966i.toString());
        }
        return sb5.toString();
    }
}
