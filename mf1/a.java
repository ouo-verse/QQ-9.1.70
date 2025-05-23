package mf1;

import android.text.TextUtils;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qqguildsdk.data.cy;
import com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes12.dex */
public class a extends com.tencent.mobileqq.mvvm.a {

    /* renamed from: a, reason: collision with root package name */
    private List<Integer> f416660a = new ArrayList(Collections.singletonList(1));

    /* renamed from: b, reason: collision with root package name */
    private List<Long> f416661b = new ArrayList();

    private boolean l(List<IGProChannelInfo> list) {
        if (list != null && list.size() > 0) {
            Iterator<IGProChannelInfo> it = list.iterator();
            while (it.hasNext()) {
                IGProChannelInfo next = it.next();
                if (t(next.getType())) {
                    it.remove();
                } else if (u(next.getType(), next.getApplicationId())) {
                    it.remove();
                }
            }
            if (list.size() > 0) {
                return true;
            }
            return false;
        }
        return false;
    }

    private void m(List<lf1.a> list, cy cyVar, List<IGProChannelInfo> list2) {
        for (int i3 = 0; list2 != null && i3 < list2.size(); i3++) {
            IGProChannelInfo iGProChannelInfo = list2.get(i3);
            lf1.a aVar = new lf1.a();
            aVar.f414443a = 1;
            aVar.f414445c = iGProChannelInfo;
            aVar.f414444b = cyVar.getCategoryName();
            aVar.f414447e = cyVar.getCategoryId();
            list.add(aVar);
        }
    }

    private void o(List<lf1.a> list, boolean z16) {
        if (z16) {
            lf1.a aVar = new lf1.a();
            aVar.f414443a = 0;
            list.add(0, aVar);
        }
        lf1.a aVar2 = new lf1.a();
        aVar2.f414443a = 0;
        list.add(aVar2);
    }

    private void p(List<cy> list) {
        if (QLog.isColorLevel()) {
            StringBuilder sb5 = new StringBuilder("logCategoryInfo: ");
            if (list == null) {
                sb5.append("categoryInfoList == null");
                QLog.i("Guild.c.picker.QQGuildSelectChannelRepository", 2, sb5.toString());
                return;
            }
            for (cy cyVar : list) {
                sb5.append(cyVar.getCategoryName());
                sb5.append(":[");
                Iterator<IGProChannelInfo> it = cyVar.getChannelList().iterator();
                while (it.hasNext()) {
                    sb5.append(it.next().getChannelUin());
                    sb5.append(",");
                }
                sb5.append("], ");
            }
            QLog.i("Guild.c.picker.QQGuildSelectChannelRepository", 2, sb5.toString());
        }
    }

    private void q(List<lf1.a> list) {
        if (QLog.isColorLevel()) {
            QLog.i("Guild.c.picker.QQGuildSelectChannelRepository", 2, list.toString());
        }
    }

    private boolean t(int i3) {
        return !this.f416660a.contains(Integer.valueOf(i3));
    }

    private boolean u(int i3, long j3) {
        if (i3 == 6 && this.f416661b.contains(Long.valueOf(j3))) {
            return true;
        }
        return false;
    }

    public void j(GPServiceObserver gPServiceObserver) {
        ((IGPSService) MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IGPSService.class, "")).addObserver(gPServiceObserver);
    }

    public void k(GPServiceObserver gPServiceObserver) {
        ((IGPSService) MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IGPSService.class, "")).deleteObserver(gPServiceObserver);
    }

    public List<lf1.a> n(String str) {
        int i3;
        IGProGuildInfo L;
        if (ch.j0(str) && (L = ch.L(str)) != null && !L.isVisibleForVisitor()) {
            QLog.i("Guild.c.picker.QQGuildSelectChannelRepository", 1, "currentGuild is invisible for visitor:" + str);
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        List<cy> channelCategoryList = ((IGPSService) MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IGPSService.class, "")).getChannelCategoryList(str);
        arrayList.clear();
        if (channelCategoryList != null) {
            arrayList.addAll(channelCategoryList);
        }
        p(channelCategoryList);
        ArrayList arrayList2 = new ArrayList();
        boolean z16 = false;
        for (int i16 = 0; i16 < arrayList.size(); i16++) {
            cy cyVar = (cy) arrayList.get(i16);
            List<IGProChannelInfo> channelList = cyVar.getChannelList();
            boolean l3 = l(channelList);
            if (!TextUtils.isEmpty(cyVar.getCategoryName())) {
                if (l3) {
                    lf1.a aVar = new lf1.a();
                    aVar.f414443a = 2;
                    aVar.f414444b = cyVar.getCategoryName();
                    aVar.f414447e = cyVar.getCategoryId();
                    if (channelList != null) {
                        i3 = channelList.size();
                    } else {
                        i3 = 0;
                    }
                    aVar.f414446d = i3;
                    arrayList2.add(aVar);
                }
            } else if (channelList != null && channelList.size() > 1) {
                z16 = true;
            }
            m(arrayList2, cyVar, channelList);
        }
        o(arrayList2, z16);
        q(arrayList2);
        return arrayList2;
    }

    public void r(List<Long> list) {
        this.f416661b = list;
    }

    public void s(List<Integer> list) {
        this.f416660a = list;
    }
}
