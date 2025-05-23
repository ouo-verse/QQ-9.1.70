package com.tencent.mobileqq.text.processor;

import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.search.api.IHashTagSearchLinkApi;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.text.GrabParams;
import com.tencent.mobileqq.text.d;
import com.tencent.mobileqq.text.m;
import com.tencent.mobileqq.text.n;
import com.tencent.mobileqq.text.style.LinkSpan;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqnt.aio.adapter.api.IMsgConverterUtilsApi;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import java.util.HashMap;
import java.util.List;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes18.dex */
public class c implements ISpanProcessor {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public static String f292708a;

    public c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.text.processor.ISpanProcessor
    public void doGrab(GrabParams grabParams, ISpanCallback iSpanCallback) {
        MsgRecord msgRecord;
        ChatMessage chatMessage;
        m mVar;
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) grabParams, (Object) iSpanCallback);
            return;
        }
        if (grabParams != null && iSpanCallback != null) {
            if (TextUtils.isEmpty(f292708a)) {
                AppRuntime runtime = BaseApplicationImpl.getApplication().getRuntime();
                if (runtime != null) {
                    f292708a = runtime.getAccount();
                }
                String str = f292708a;
                if (str == null) {
                    str = "";
                }
                f292708a = str;
            }
            if (grabParams.text != null) {
                if (f292708a.length() > 3) {
                    String str2 = f292708a;
                    if (str2.charAt(str2.length() - 3) == '0') {
                        if (f292708a.charAt(r2.length() - 2) == '1') {
                            HashMap<String, String> hashMap = new HashMap<>();
                            hashMap.put("length", grabParams.text.length() + "");
                            StatisticCollector statisticCollector = StatisticCollector.getInstance(BaseApplication.getContext());
                            if (grabParams.text.length() < 1000) {
                                z16 = true;
                            } else {
                                z16 = false;
                            }
                            statisticCollector.collectPerformance(null, "qq_url_length_report", z16, 0L, 0L, hashMap, null);
                        }
                    }
                }
                if (grabParams.text.length() < 1000) {
                    Object obj = grabParams.message;
                    if (obj instanceof AIOMsgItem) {
                        MsgRecord msgRecord2 = ((AIOMsgItem) obj).getMsgRecord();
                        chatMessage = ((IMsgConverterUtilsApi) QRoute.api(IMsgConverterUtilsApi.class)).convertToChatMessage(BaseApplicationImpl.sApplication.peekAppRuntime(), msgRecord2);
                        msgRecord = msgRecord2;
                    } else {
                        msgRecord = null;
                        chatMessage = null;
                    }
                    if (32 == (grabParams.flag & 32)) {
                        IHashTagSearchLinkApi iHashTagSearchLinkApi = IHashTagSearchLinkApi.f282735g;
                        Object obj2 = msgRecord;
                        if (msgRecord == null) {
                            obj2 = grabParams.message;
                        }
                        mVar = iHashTagSearchLinkApi.grabHashTagLinkParams(obj2);
                    } else {
                        mVar = m.f292688e;
                    }
                    List<d> c16 = n.c(grabParams.text, mVar.enable, null);
                    if (c16 != null && c16.size() > 0) {
                        for (d dVar : c16) {
                            iSpanCallback.addSpan(new LinkSpan(dVar.f292676a, f292708a, chatMessage).q(mVar), dVar.f292677b, dVar.f292678c, 33);
                        }
                    }
                }
            }
        }
    }

    @Override // com.tencent.mobileqq.text.processor.ISpanProcessor
    public int doPlain(Object obj, int i3, int i16, int i17, StringBuffer stringBuffer) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) {
            return 0;
        }
        return ((Integer) iPatchRedirector.redirect((short) 5, this, obj, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), stringBuffer)).intValue();
    }

    @Override // com.tencent.mobileqq.text.processor.ISpanProcessor
    public boolean matchGrab(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, i3)).booleanValue();
        }
        if ((i3 & 8) == 8) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.text.processor.ISpanProcessor
    public boolean matchPlain(Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, obj)).booleanValue();
        }
        return false;
    }

    @Override // com.tencent.mobileqq.text.processor.ISpanProcessor
    public void setBizSrc(String str, Object[] objArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) str, (Object) objArr);
            return;
        }
        if (objArr == null) {
            return;
        }
        for (Object obj : objArr) {
            if (obj instanceof LinkSpan) {
                ((LinkSpan) obj).o(str);
            }
        }
    }
}
