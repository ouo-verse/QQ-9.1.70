package com.tencent.mobileqq.qqlive.data.anchor.sso;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqlive.data.common.QQLiveErrorMsg;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes17.dex */
public class QQLiveAnchorDataPullInfo extends QQLiveAnchorDataBase {
    static IPatchRedirector $redirector_;
    public int avType;
    public String defaultPlayUrl;
    public int isSwitch;
    public ArrayList<Integer> levelList;
    public int liveStat;
    public int pixelsX;
    public int pixelsY;
    public ArrayList<QQLiveAnchorDataStream> streams;
    public int sugLevel;

    public QQLiveAnchorDataPullInfo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this);
    }

    public QQLiveAnchorDataPullInfo(boolean z16, QQLiveErrorMsg qQLiveErrorMsg) {
        super(z16, qQLiveErrorMsg);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), qQLiveErrorMsg);
    }

    public QQLiveAnchorDataPullInfo(QQLiveAnchorDataPullInfo qQLiveAnchorDataPullInfo) {
        super(qQLiveAnchorDataPullInfo);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) qQLiveAnchorDataPullInfo);
            return;
        }
        if (qQLiveAnchorDataPullInfo == null) {
            return;
        }
        this.isSwitch = qQLiveAnchorDataPullInfo.isSwitch;
        this.liveStat = qQLiveAnchorDataPullInfo.liveStat;
        this.sugLevel = qQLiveAnchorDataPullInfo.sugLevel;
        this.avType = qQLiveAnchorDataPullInfo.avType;
        this.pixelsX = qQLiveAnchorDataPullInfo.pixelsX;
        this.pixelsY = qQLiveAnchorDataPullInfo.pixelsY;
        if (qQLiveAnchorDataPullInfo.streams != null) {
            this.streams = new ArrayList<>();
            Iterator<QQLiveAnchorDataStream> it = qQLiveAnchorDataPullInfo.streams.iterator();
            while (it.hasNext()) {
                this.streams.add(new QQLiveAnchorDataStream(it.next()));
            }
        }
        if (qQLiveAnchorDataPullInfo.levelList != null) {
            this.levelList = new ArrayList<>();
            Iterator<Integer> it5 = qQLiveAnchorDataPullInfo.levelList.iterator();
            while (it5.hasNext()) {
                this.levelList.add(new Integer(it5.next().intValue()));
            }
        }
        this.defaultPlayUrl = qQLiveAnchorDataPullInfo.defaultPlayUrl;
    }
}
