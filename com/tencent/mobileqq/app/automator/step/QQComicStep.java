package com.tencent.mobileqq.app.automator.step;

import com.tencent.comic.api.IQQComicPluginUtil;
import com.tencent.comic.api.IQQComicService;
import com.tencent.comic.api.IQQDcReporter;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.app.bs;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.StructMsgForImageShare;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes11.dex */
public class QQComicStep extends AsyncStep<Automator> {
    static IPatchRedirector $redirector_;

    /* compiled from: P */
    /* loaded from: classes11.dex */
    class a extends bs {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) QQComicStep.this);
            }
        }

        @Override // com.tencent.mobileqq.app.bs
        public void onMessageRecordAdded(List<MessageRecord> list) {
            StructMsgForImageShare structMsgForImageShare;
            String str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) list);
                return;
            }
            if (list != null && !list.isEmpty()) {
                Iterator it = new ArrayList(list).iterator();
                while (it.hasNext()) {
                    AbsStructMsg d16 = com.tencent.mobileqq.structmsg.i.d(((MessageRecord) it.next()).msgData);
                    if ((d16 instanceof StructMsgForImageShare) && (str = (structMsgForImageShare = (StructMsgForImageShare) d16).mMsgActionData) != null && str.startsWith(IQQComicPluginUtil.COMIC_PLUGIN_ID)) {
                        String str2 = structMsgForImageShare.mMsgActionData;
                        String[] split = str2.substring(str2.indexOf("|") + 1).split("\\|");
                        if (split.length >= 8) {
                            ((IQQDcReporter) QRoute.api(IQQDcReporter.class)).reportDC00145(((Automator) QQComicStep.this.mAutomator).E, "3009", "1", "30014", split[0], split[2], split[4], com.tencent.mobileqq.richmediabrowser.j.b(structMsgForImageShare.mMsgActionData));
                        }
                    }
                }
            }
        }
    }

    public QQComicStep() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.automator.AsyncStep
    public int doStep() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        ((Automator) this.mAutomator).E.addObserver(new a(), true);
        ((IQQComicService) ((Automator) this.mAutomator).E.getRuntimeService(IQQComicService.class)).startUp();
        return 7;
    }
}
