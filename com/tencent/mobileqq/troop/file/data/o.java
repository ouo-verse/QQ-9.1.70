package com.tencent.mobileqq.troop.file.data;

import android.text.TextUtils;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.troop.api.ITroopInfoService;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import tencent.im.cs.cmd0x383.cmd0x383$ApplyFileSearchRspBody;

/* compiled from: P */
/* loaded from: classes35.dex */
public class o {

    /* renamed from: a, reason: collision with root package name */
    public long f295504a;

    /* renamed from: b, reason: collision with root package name */
    public String f295505b;

    /* renamed from: c, reason: collision with root package name */
    public long f295506c;

    /* renamed from: d, reason: collision with root package name */
    public String f295507d;

    /* renamed from: e, reason: collision with root package name */
    public ArrayList<String> f295508e;

    /* renamed from: f, reason: collision with root package name */
    public long f295509f;

    /* renamed from: g, reason: collision with root package name */
    public String f295510g;

    /* renamed from: h, reason: collision with root package name */
    public String f295511h;

    /* renamed from: i, reason: collision with root package name */
    public com.tencent.mobileqq.troop.data.n f295512i;

    public o(QQAppInterface qQAppInterface, cmd0x383$ApplyFileSearchRspBody.Item item) {
        this.f295504a = 0L;
        this.f295505b = null;
        this.f295506c = 0L;
        this.f295507d = null;
        this.f295508e = null;
        this.f295509f = 0L;
        this.f295510g = null;
        this.f295511h = null;
        this.f295512i = null;
        if (item == null) {
            return;
        }
        this.f295504a = item.uint64_group_code.get();
        TroopInfo findTroopInfo = ((ITroopInfoService) qQAppInterface.getRuntimeService(ITroopInfoService.class, "")).findTroopInfo(String.valueOf(this.f295504a));
        if (findTroopInfo != null) {
            this.f295505b = findTroopInfo.getTroopDisplayName();
        }
        if (TextUtils.isEmpty(this.f295505b)) {
            this.f295505b = item.bytes_group_name.get().toStringUtf8();
        }
        this.f295506c = item.uint64_upload_uin.get();
        this.f295507d = item.bytes_uploader_nick_name.get().toStringUtf8();
        this.f295508e = new ArrayList<>();
        List<ByteStringMicro> list = item.bytes_match_word.get();
        if (list != null) {
            for (int i3 = 0; i3 < list.size(); i3++) {
                this.f295508e.add(list.get(i3).toStringUtf8());
            }
        }
        long j3 = item.uint64_match_uin.get();
        this.f295509f = j3;
        if (j3 > 0) {
            Friends v3 = ((FriendsManager) qQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER)).v(String.valueOf(this.f295509f));
            if (v3 != null) {
                this.f295510g = v3.name;
                this.f295511h = v3.remark;
            }
            if (QLog.isColorLevel()) {
                QLog.d("TroopFileSearchDialog", 2, "TroopFileSearchItemData matchUin:" + this.f295509f + ", name:" + this.f295510g + ", remark = " + this.f295511h);
            }
        }
        this.f295512i = new com.tencent.mobileqq.troop.data.n(item.file_info.get());
    }

    public String toString() {
        StringBuilder sb5 = new StringBuilder();
        sb5.append("groupCode = " + this.f295504a);
        sb5.append(", groupName = " + this.f295505b);
        sb5.append(", uploaderUin = " + this.f295506c);
        sb5.append(", uploaderNickName = " + this.f295507d);
        sb5.append(", matchUin = " + this.f295509f);
        if (this.f295508e != null) {
            sb5.append(", matchWord: = ");
            int size = this.f295508e.size();
            for (int i3 = 0; i3 < size; i3++) {
                if (i3 == size - 1) {
                    sb5.append(this.f295508e.get(i3) + ", ");
                } else {
                    sb5.append(this.f295508e.get(i3));
                    sb5.append("\u3001 ");
                }
            }
        }
        if (this.f295512i != null) {
            sb5.append(", fileInfo = " + this.f295512i.toString());
        }
        return sb5.toString();
    }
}
