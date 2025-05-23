package cooperation.qqfav;

import ConfigPush.DomainIpChannel;
import ConfigPush.DomainIpInfo;
import ConfigPush.DomainIpList;
import ConfigPush.FileStoragePushFSSvcList;
import android.content.Intent;
import android.content.SharedPreferences;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.utils.NetworkUtil;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes28.dex */
public class f {

    /* renamed from: a, reason: collision with root package name */
    protected String f390612a = null;

    /* renamed from: b, reason: collision with root package name */
    protected String f390613b = null;

    /* renamed from: c, reason: collision with root package name */
    protected String f390614c = null;

    public void a(FileStoragePushFSSvcList fileStoragePushFSSvcList) {
        DomainIpChannel domainIpChannel;
        ArrayList<DomainIpList> arrayList;
        SharedPreferences sharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences("QfavSrvAddrList", 4);
        if (sharedPreferences != null && fileStoragePushFSSvcList != null && (domainIpChannel = fileStoragePushFSSvcList.domainIpChannel) != null && (arrayList = domainIpChannel.vDomain_iplists) != null) {
            Iterator<DomainIpList> it = arrayList.iterator();
            while (true) {
                if (it.hasNext()) {
                    DomainIpList next = it.next();
                    StringBuilder sb5 = new StringBuilder();
                    int i3 = next.uDomain_type;
                    if (i3 == 4 || i3 == 5 || i3 == 6) {
                        ArrayList<DomainIpInfo> arrayList2 = next.vIplist;
                        if (arrayList2 != null && arrayList2.size() != 0) {
                            for (int i16 = 0; i16 < next.vIplist.size(); i16++) {
                                DomainIpInfo domainIpInfo = next.vIplist.get(i16);
                                sb5.append(NetworkUtil.intAddr2Ip(domainIpInfo.uIp));
                                sb5.append(":");
                                sb5.append(domainIpInfo.uPort);
                                if (i16 < next.vIplist.size() - 1) {
                                    sb5.append("|");
                                }
                            }
                        }
                    }
                    int i17 = next.uDomain_type;
                    if (i17 != 4) {
                        if (i17 != 5) {
                            if (i17 == 6) {
                                this.f390613b = sb5.toString();
                                sharedPreferences.edit().putString("QfavSrvAddrList_PicPlatformIp", this.f390613b).commit();
                            }
                        } else {
                            this.f390614c = sb5.toString();
                            sharedPreferences.edit().putString("QfavSrvAddrList_UploadPicIp", this.f390614c).commit();
                        }
                    } else {
                        this.f390612a = sb5.toString();
                        sharedPreferences.edit().putString("QfavSrvAddrList_FavIp", this.f390612a).commit();
                    }
                } else {
                    Intent intent = new Intent("com.tencent.receiver.qfav.srvaddr");
                    intent.putExtra("com.tencent.receiver.qfav.srvaddr.type", 0);
                    BaseApplicationImpl.getApplication().sendBroadcast(intent);
                    return;
                }
            }
        }
    }
}
