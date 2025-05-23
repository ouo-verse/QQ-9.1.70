package com.tencent.mobileqq.springhb.pack;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.io.Serializable;

/* loaded from: classes18.dex */
public class PackInfo implements Serializable {
    static IPatchRedirector $redirector_ = null;
    private static final long serialVersionUID = 1;
    public String balanceEntrance;
    public String balanceEntranceString;
    public int balanceEntranceType;
    public String balanceEntranceUrl;
    public String balanceLastEntrance;
    public String balanceLastEntranceString;
    public int balanceLastEntranceType;
    public String balanceLastEntranceUrl;
    public String balanceMiddleEntrance;
    public String balanceMiddleEntranceString;
    public int balanceMiddleEntranceType;
    public String balanceMiddleEntranceUrl;
    public String bizId;
    public String businessCover;
    public String businessLogo;
    public String businessName;
    public String businessNamePic;
    public String businessVideo;
    public String businessVideoCover;
    public boolean canLight;
    public String content;
    public String couponName;
    public int ctime;

    /* renamed from: id, reason: collision with root package name */
    public String f289475id;
    public boolean isH5;
    public int luckyScore;
    public String luckyScoreWording;
    public String merchantJumpHint;
    public String merchantJumpUrl;
    public int money;
    public int mtime;
    public String order;
    public int prizeId;
    public int promotionId;
    public int remainSeconds;
    public String reqId;
    public long sendUin;
    public String signature;
    public int state;
    public String subtitle;
    public int type;
    public long uin;
    public String url;
    public int welfareType;
    public String wishing;
    public boolean zplanReserved;

    public PackInfo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.balanceEntrance = "";
        this.balanceEntranceUrl = "";
        this.balanceEntranceType = 0;
        this.balanceEntranceString = "";
        this.balanceMiddleEntrance = "";
        this.balanceMiddleEntranceUrl = "";
        this.balanceMiddleEntranceType = 0;
        this.balanceMiddleEntranceString = "";
        this.balanceLastEntrance = "";
        this.balanceLastEntranceUrl = "";
        this.balanceLastEntranceType = 0;
        this.balanceLastEntranceString = "";
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return "PackInfo{id='" + this.f289475id + "', state=" + this.state + ", type=" + this.type + ", ctime=" + this.ctime + ", money=" + this.money + ", bizId='" + this.bizId + "', signature='" + this.signature + "', url='" + this.url + "', mtime=" + this.mtime + ", order='" + this.order + "', uin=" + this.uin + ", sendUin=" + this.sendUin + ", wishing='" + this.wishing + "', promotionId=" + this.promotionId + ", reqId='" + this.reqId + "', businessName='" + this.businessName + "', businessLogo='" + this.businessLogo + "', businessCover='" + this.businessCover + "', businessVideoCover='" + this.businessVideoCover + "', businessVideo='" + this.businessVideo + "', businessNamePic='" + this.businessNamePic + "', couponName='" + this.couponName + "', canLight=" + this.canLight + ", zplanReserved=" + this.zplanReserved + ", prizeId=" + this.prizeId + ", subtitle='" + this.subtitle + "', luckyScore=" + this.luckyScore + ", luckyScoreWording='" + this.luckyScoreWording + "', remainSeconds=" + this.remainSeconds + ", isH5=" + this.isH5 + ", content='" + this.content + "', welfareType=" + this.welfareType + ", merchantJumpUrl='" + this.merchantJumpUrl + "', merchantJumpHint='" + this.merchantJumpHint + "', balanceEntrance='" + this.balanceEntrance + "', balanceEntranceUrl='" + this.balanceEntranceUrl + "', balanceMiddleEntrance='" + this.balanceMiddleEntrance + "', balanceMiddleEntranceUrl='" + this.balanceMiddleEntranceUrl + "', balanceLastEntrance='" + this.balanceLastEntrance + "', balanceLastEntranceUrl='" + this.balanceLastEntranceUrl + "'}";
    }
}
