package com.tencent.mobileqq.highway.config;

import com.tencent.mobileqq.highway.protocol.subcmd0x501;
import com.tencent.mobileqq.highway.utils.EndPoint;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes9.dex */
public class HwConfig implements Serializable, Cloneable {
    static IPatchRedirector $redirector_ = null;
    public static final int NET_TYPE_2G = 2;
    public static final int NET_TYPE_3G = 3;
    public static final int NET_TYPE_4G = 4;
    public static final int NET_TYPE_DEFAULT = 0;
    public static final int NET_TYPE_WIFI = 1;
    private static final long serialVersionUID = 2113693234079222598L;
    public PBUInt32Field bdhIpv6Policy;
    public PBUInt32Field connAttemptDelay;
    public subcmd0x501.SubCmd0x501Rspbody.DynTimeOutConf dtConf;
    public PBUInt32Field fmtIpv6Policy;
    public subcmd0x501.SubCmd0x501Rspbody.IpLearnConf ipConf;
    public ArrayList<EndPoint> ipList;
    public ArrayList<EndPoint> ipv6List;
    public ArrayList<HwNetSegConf> netSegConfList;
    public subcmd0x501.SubCmd0x501Rspbody.OpenUpConf openUpConf;
    public subcmd0x501.SubCmd0x501Rspbody.PTVConf ptvCof;
    public ArrayList<HwNetSegConf> shortVideoSegConfList;
    public subcmd0x501.SubCmd0x501Rspbody.ShortVideoConf videoConf;

    public HwConfig() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.ipConf = null;
        this.dtConf = null;
        this.openUpConf = null;
        this.videoConf = null;
        this.ptvCof = null;
        this.fmtIpv6Policy = null;
        this.bdhIpv6Policy = null;
        this.connAttemptDelay = null;
    }

    public String ipList2String() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append("IP= ");
        ArrayList<EndPoint> arrayList = this.ipList;
        if (arrayList != null && arrayList.size() > 0) {
            Iterator<EndPoint> it = this.ipList.iterator();
            while (it.hasNext()) {
                sb5.append(it.next().toString() + "  ");
            }
        }
        sb5.append("IPv6= ");
        ArrayList<EndPoint> arrayList2 = this.ipv6List;
        if (arrayList2 != null && arrayList2.size() > 0) {
            Iterator<EndPoint> it5 = this.ipv6List.iterator();
            while (it5.hasNext()) {
                sb5.append(it5.next().toString() + "  ");
            }
        }
        sb5.append("   Segment Info= ");
        ArrayList<HwNetSegConf> arrayList3 = this.netSegConfList;
        if (arrayList3 != null && arrayList3.size() > 0) {
            Iterator<HwNetSegConf> it6 = this.netSegConfList.iterator();
            while (it6.hasNext()) {
                HwNetSegConf next = it6.next();
                sb5.append(" NetType= " + next.netType);
                sb5.append(" SegSize= " + next.segSize);
                sb5.append(" SegNum= " + next.segNum);
                sb5.append(" CommNUm= " + next.curConnNum);
            }
        }
        return sb5.toString();
    }

    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public HwConfig m194clone() throws CloneNotSupportedException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (HwConfig) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        HwConfig hwConfig = (HwConfig) super.clone();
        hwConfig.ipList = new ArrayList<>();
        Iterator<EndPoint> it = this.ipList.iterator();
        while (it.hasNext()) {
            hwConfig.ipList.add(it.next().m196clone());
        }
        hwConfig.ipv6List = new ArrayList<>();
        Iterator<EndPoint> it5 = this.ipv6List.iterator();
        while (it5.hasNext()) {
            hwConfig.ipv6List.add(it5.next().m196clone());
        }
        hwConfig.netSegConfList = new ArrayList<>();
        Iterator<HwNetSegConf> it6 = this.netSegConfList.iterator();
        while (it6.hasNext()) {
            hwConfig.netSegConfList.add(it6.next().m195clone());
        }
        hwConfig.shortVideoSegConfList = new ArrayList<>();
        Iterator<HwNetSegConf> it7 = this.shortVideoSegConfList.iterator();
        while (it7.hasNext()) {
            hwConfig.shortVideoSegConfList.add(it7.next().m195clone());
        }
        return hwConfig;
    }
}
