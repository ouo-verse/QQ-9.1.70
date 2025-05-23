package com.tencent.mobileqq.panel;

import QC.CommonRsp;
import QC.SetFontBubbleRsp;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.QQTranslucentBrowserActivity;
import com.tencent.mobileqq.activity.aio.l;
import com.tencent.mobileqq.aio.event.AIOMsgSendEvent;
import com.tencent.mobileqq.aio.event.InputEvent;
import com.tencent.mobileqq.aio.input.edit.InputEditTextMsgIntent;
import com.tencent.mobileqq.aio.input.edit.d;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.MessageHandlerConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.SVIPObserver;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.bs;
import com.tencent.mobileqq.mini.out.nativePlugins.SmsPlugin;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.ActivityURIRequest;
import com.tencent.mobileqq.qroute.route.o;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.vas.ao;
import com.tencent.mobileqq.vas.pay.VasH5PayConstants;
import com.tencent.mobileqq.vas.svip.api.ISVIPHandler;
import com.tencent.mobileqq.vas.webview.util.VasWebviewUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.ipc.IPCConst;
import com.tencent.qqnt.ntrelation.vasinfo.api.IVasInfoService;
import com.tencent.qqnt.ntrelation.vasinfo.bean.NTVasSimpleInfo;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import cooperation.qzone.QzoneTranslucentBrowserFragment;
import java.lang.ref.WeakReference;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes16.dex */
public class FontBubbleManager implements Handler.Callback {
    static IPatchRedirector $redirector_;
    private long[] C;
    private String D;
    private c E;
    private d F;
    private bs G;

    /* renamed from: d, reason: collision with root package name */
    private Handler f257111d;

    /* renamed from: e, reason: collision with root package name */
    private QQAppInterface f257112e;

    /* renamed from: f, reason: collision with root package name */
    private WeakReference<com.tencent.aio.api.runtime.a> f257113f;

    /* renamed from: h, reason: collision with root package name */
    private WeakReference<Context> f257114h;

    /* renamed from: i, reason: collision with root package name */
    private i f257115i;

    /* renamed from: m, reason: collision with root package name */
    private i f257116m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes16.dex */
    public class a implements com.tencent.mvi.base.route.a {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ com.tencent.aio.api.runtime.a f257123d;

        a(com.tencent.aio.api.runtime.a aVar) {
            this.f257123d = aVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) FontBubbleManager.this, (Object) aVar);
            }
        }

        @Override // com.tencent.mvi.base.route.a
        public void call(@NonNull MsgIntent msgIntent) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) msgIntent);
                return;
            }
            if (FontBubbleManager.this.f257115i != null) {
                FontBubbleManager.this.f257115i.c(FontBubbleManager.this.f257112e);
                FontBubbleManager.this.f257115i = null;
            }
            this.f257123d.e().b(AIOMsgSendEvent.OnMsgSendSuccessEvent.class.getCanonicalName(), this);
            this.f257123d.e().b(AIOMsgSendEvent.OnMsgSendFailEvent.class.getCanonicalName(), this);
        }

        @Override // com.tencent.mvi.base.route.a
        public boolean sticky() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
            }
            return false;
        }
    }

    /* compiled from: P */
    /* loaded from: classes16.dex */
    class b extends bs {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) FontBubbleManager.this);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.app.bs
        public void onSendResult(boolean z16, String str, long j3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                FontBubbleManager.this.o(j3);
            } else {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), str, Long.valueOf(j3));
            }
        }

        @Override // com.tencent.mobileqq.app.bs
        protected void onSendResult(boolean z16, String str, long j3, MessageHandlerConstants.MsgSendCostParams msgSendCostParams) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                FontBubbleManager.this.o(j3);
            } else {
                iPatchRedirector.redirect((short) 3, this, Boolean.valueOf(z16), str, Long.valueOf(j3), msgSendCostParams);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes16.dex */
    public static class c extends SVIPObserver {
        static IPatchRedirector $redirector_;

        public c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.mobileqq.app.SVIPObserver
        public void onFontBubblePaySuccess(Bundle bundle) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) bundle);
                return;
            }
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            if (peekAppRuntime instanceof QQAppInterface) {
                FontBubbleManager.j((QQAppInterface) peekAppRuntime).n(bundle);
            }
        }

        @Override // com.tencent.mobileqq.app.SVIPObserver
        public void onSetFontBubble(boolean z16, SetFontBubbleRsp setFontBubbleRsp, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), setFontBubbleRsp, Integer.valueOf(i3));
                return;
            }
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            if (peekAppRuntime instanceof QQAppInterface) {
                FontBubbleManager.j((QQAppInterface) peekAppRuntime).p(z16, setFontBubbleRsp, i3);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes16.dex */
    public interface d {
        void a(boolean z16);
    }

    public FontBubbleManager(QQAppInterface qQAppInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) qQAppInterface);
            return;
        }
        this.E = new c();
        this.G = new b();
        this.f257112e = qQAppInterface;
        this.f257111d = new Handler(Looper.getMainLooper(), this);
        this.f257112e.addObserver(this.G);
        this.f257112e.addObserver(this.E);
    }

    public static FontBubbleManager j(QQAppInterface qQAppInterface) {
        return ((ao) qQAppInterface.getManager(QQManagerFactory.VAS_EXTENSION_MANAGER)).C;
    }

    private boolean l(int i3, int i16) {
        Object obj;
        i iVar = this.f257116m;
        if (iVar != null) {
            if (i3 == 5) {
                if (i16 != iVar.f257181b.fontId) {
                    return false;
                }
                return true;
            }
            if (i16 != iVar.f257181b.bubbleId) {
                return false;
            }
            return true;
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append(i3);
        sb5.append(", ");
        sb5.append(i16);
        sb5.append(" is not currentSelect: ");
        i iVar2 = this.f257116m;
        if (iVar2 == null) {
            obj = "null";
        } else {
            obj = iVar2.f257181b;
        }
        sb5.append(obj);
        QLog.e("AIOFontBubble_FontBubbleManager", 1, sb5.toString());
        return false;
    }

    private void q() {
        String str;
        int i3;
        com.tencent.aio.api.runtime.a aVar = this.f257113f.get();
        if (aVar == null) {
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("AIOFontBubble_FontBubbleManager", 2, SmsPlugin.API_SEND_SMS);
        }
        d.C7264d c7264d = (d.C7264d) aVar.e().k(new InputEvent.GetInputString());
        if (c7264d != null) {
            str = c7264d.a().toString();
        } else {
            str = "";
        }
        if (TextUtils.isEmpty(str)) {
            QLog.e("AIOFontBubble_FontBubbleManager", 1, "sendMsg fail input is empty");
            return;
        }
        a aVar2 = new a(aVar);
        aVar.e().d(AIOMsgSendEvent.OnMsgSendFailEvent.class.getCanonicalName(), aVar2);
        aVar.e().d(AIOMsgSendEvent.OnMsgSendSuccessEvent.class.getCanonicalName(), aVar2);
        aVar.e().h(new AIOMsgSendEvent.TextSendEvent(str));
        aVar.e().h(InputEditTextMsgIntent.ClearEditTextContent.f189408d);
        aVar.e().h(new InputEditTextMsgIntent.ShowKeyboardMsgIntent());
        i iVar = this.f257116m;
        if (iVar != null) {
            FontBubble fontBubble = iVar.f257181b;
            int i16 = fontBubble.panelType;
            if (i16 == 3) {
                i3 = fontBubble.fontId;
            } else {
                i3 = fontBubble.bubbleId;
            }
            VasWebviewUtil.reportCommercialDrainage(MobileQQ.sMobileQQ.peekAppRuntime().getCurrentUin(), "aio_iconA", "Send", "", 1, 0, 0, "", Integer.toString(i3), FontBubblePanelView.o(i16), "0", "", "", "", 0, 0, 0, 0);
            this.f257116m = null;
        }
    }

    private void r(d dVar) {
        String str;
        com.tencent.aio.api.runtime.a aVar = this.f257113f.get();
        if (aVar == null) {
            if (dVar != null) {
                dVar.a(false);
                return;
            }
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("AIOFontBubble_FontBubbleManager", 2, SmsPlugin.API_SEND_SMS);
        }
        d.C7264d c7264d = (d.C7264d) aVar.e().k(new InputEvent.GetInputString());
        if (c7264d != null) {
            str = c7264d.a().toString();
        } else {
            str = "";
        }
        if (TextUtils.isEmpty(str)) {
            QLog.e("AIOFontBubble_FontBubbleManager", 1, "sendMsg fail input is empty");
            if (dVar != null) {
                dVar.a(false);
                return;
            }
            return;
        }
        aVar.e().h(new AIOMsgSendEvent.TextSendEvent(str));
        aVar.e().h(InputEditTextMsgIntent.ClearEditTextContent.f189408d);
        aVar.e().h(new InputEditTextMsgIntent.ShowKeyboardMsgIntent());
        if (dVar != null) {
            dVar.a(true);
        }
        if (this.f257116m != null) {
            this.f257116m = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y(i iVar, ISVIPHandler iSVIPHandler) {
        if (iVar != null && iVar.f257181b != null && iSVIPHandler != null) {
            QLog.d("AIOFontBubble_FontBubbleManager", 1, "setSelfFontBubble data = " + iVar.f257181b.toString());
            if (iVar.f257182c) {
                FontBubble fontBubble = iVar.f257181b;
                iSVIPHandler.setSelfFontInfo(fontBubble.fontId, fontBubble.engine);
                iSVIPHandler.setSelfBubbleId(iVar.f257181b.bubbleId);
            } else {
                FontBubble fontBubble2 = iVar.f257181b;
                if (fontBubble2.panelType == 3) {
                    iSVIPHandler.setSelfFontInfo(fontBubble2.fontId, fontBubble2.engine);
                } else {
                    iSVIPHandler.setSelfBubbleId(fontBubble2.bubbleId);
                }
            }
        }
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Boolean) iPatchRedirector.redirect((short) 11, (Object) this, (Object) message)).booleanValue();
        }
        int i3 = message.what;
        if (i3 != 1000) {
            if (i3 != 1001) {
                if (i3 != 1003) {
                    return false;
                }
                r(this.F);
                this.F = null;
                return true;
            }
            q();
            return true;
        }
        Object[] objArr = (Object[]) message.obj;
        this.f257115i = new i((FontBubble) objArr[0], true);
        i iVar = new i((FontBubble) objArr[1], false);
        this.f257116m = iVar;
        iVar.c(this.f257112e);
        return true;
    }

    public String k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.D;
    }

    public void m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        } else {
            this.f257112e.removeObserver(this.G);
            this.f257112e.removeObserver(this.E);
        }
    }

    public void n(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) bundle);
            return;
        }
        if (bundle != null) {
            int i3 = bundle.getInt("sid");
            int i16 = bundle.getInt("id");
            boolean l3 = l(i3, i16);
            if (QLog.isColorLevel()) {
                QLog.d("AIOFontBubble_FontBubbleManager", 2, "onFontBubblePaySuccess: " + i3 + "," + i16 + "," + l3);
            }
        }
        QLog.i("AIOFontBubble_FontBubbleManager", 1, "onFontBubblePaySuccess");
        i iVar = this.f257116m;
        if (iVar != null) {
            VasWebviewUtil.reportCommercialDrainage(MobileQQ.sMobileQQ.peekAppRuntime().getCurrentUin(), "aio_iconA", "OpenSvip", "", 1, 0, 0, "", "", FontBubblePanelView.o(iVar.f257181b.panelType));
            i iVar2 = new i(this.f257116m.f257181b, false);
            this.f257116m = iVar2;
            iVar2.c(this.f257112e);
        }
    }

    public void o(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, j3);
            return;
        }
        long[] jArr = this.C;
        if (jArr != null) {
            for (long j16 : jArr) {
                if (j16 == j3) {
                    this.C = null;
                    i iVar = this.f257115i;
                    if (iVar != null) {
                        iVar.c(this.f257112e);
                        this.f257115i = null;
                        return;
                    }
                    return;
                }
            }
        }
    }

    public void p(boolean z16, SetFontBubbleRsp setFontBubbleRsp, int i3) {
        CommonRsp commonRsp;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, Boolean.valueOf(z16), setFontBubbleRsp, Integer.valueOf(i3));
            return;
        }
        if (z16 && setFontBubbleRsp != null && (commonRsp = setFontBubbleRsp.stRet) != null && commonRsp.ret == 0) {
            i iVar = this.f257116m;
            if (iVar != null && iVar.f257180a == i3) {
                int i16 = iVar.f257181b.panelType;
                if ((i16 == 3 && setFontBubbleRsp.stFontRsp.authRet == 0) || (i16 == 4 && setFontBubbleRsp.stBubbleRsp.authRet == 0)) {
                    if (QLog.isColorLevel()) {
                        QLog.d("AIOFontBubble_FontBubbleManager", 2, "onSetFontBubble mClick success: " + this.f257116m.f257181b);
                    }
                    ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.panel.FontBubbleManager.2
                        static IPatchRedirector $redirector_;

                        {
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                iPatchRedirector2.redirect((short) 1, (Object) this, (Object) FontBubbleManager.this);
                            }
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                                FontBubbleManager.this.s(FontBubbleManager.this.f257116m);
                            } else {
                                iPatchRedirector2.redirect((short) 2, (Object) this);
                            }
                        }
                    }, 32, null, true);
                    return;
                }
                QLog.e("AIOFontBubble_FontBubbleManager", 1, "onSetFontBubble mClick fail: " + setFontBubbleRsp.stFontRsp.authRet + "," + setFontBubbleRsp.stBubbleRsp.authRet + this.f257116m.f257181b);
                if (setFontBubbleRsp.stFontRsp.authRet >= 0 && setFontBubbleRsp.stBubbleRsp.authRet >= 0) {
                    if (this.f257116m.f257181b.panelType == 3) {
                        z();
                        return;
                    } else {
                        z();
                        return;
                    }
                }
                u(MobileQQ.sMobileQQ);
                return;
            }
            i iVar2 = this.f257115i;
            if (iVar2 != null && iVar2.f257180a == i3) {
                if (setFontBubbleRsp.stFontRsp.authRet == 0 && setFontBubbleRsp.stBubbleRsp.authRet == 0) {
                    if (QLog.isColorLevel()) {
                        QLog.d("AIOFontBubble_FontBubbleManager", 2, "onSetFontBubble mRestore success: " + this.f257115i.f257181b);
                    }
                } else {
                    StringBuilder P = l.P();
                    P.append("onSetFontBubble failed,");
                    P.append(" fontAuth:");
                    P.append(setFontBubbleRsp.stFontRsp.authRet);
                    P.append(" bubbleAuth:");
                    P.append(setFontBubbleRsp.stBubbleRsp.authRet);
                    P.append(this.f257115i.f257181b);
                    QLog.e("AIOFontBubble_FontBubbleManager", 1, P.toString());
                }
                this.f257115i = null;
                return;
            }
            StringBuilder P2 = l.P();
            P2.append("onSetFontBubble seq out of date,");
            P2.append(setFontBubbleRsp.stFontRsp.fontID);
            P2.append(",");
            P2.append(setFontBubbleRsp.stBubbleRsp.bubbleID);
            P2.append(" fontAuth:");
            P2.append(setFontBubbleRsp.stFontRsp.authRet);
            P2.append(" bubbleAuth:");
            P2.append(setFontBubbleRsp.stBubbleRsp.authRet);
            QLog.e("AIOFontBubble_FontBubbleManager", 1, P2.toString());
            return;
        }
        StringBuilder P3 = l.P();
        P3.append("onSetFontBubble failed,");
        if (setFontBubbleRsp != null && setFontBubbleRsp.stRet != null) {
            P3.append(setFontBubbleRsp.stFontRsp.fontID);
            P3.append(",");
            P3.append(setFontBubbleRsp.stBubbleRsp.bubbleID);
            P3.append(" ret:");
            P3.append(setFontBubbleRsp.stRet.ret);
            P3.append("err:");
            P3.append(setFontBubbleRsp.stRet.err);
        }
        QLog.e("AIOFontBubble_FontBubbleManager", 1, P3.toString());
        i iVar3 = this.f257116m;
        if (iVar3 != null && iVar3.f257180a == i3) {
            QLog.e("AIOFontBubble_FontBubbleManager", 1, "click failed: " + this.f257116m.f257181b);
        }
        i iVar4 = this.f257115i;
        if (iVar4 != null && iVar4.f257180a == i3) {
            QLog.e("AIOFontBubble_FontBubbleManager", 1, "restore failed: " + this.f257115i.f257181b);
        }
        u(MobileQQ.sMobileQQ);
    }

    public void s(i iVar) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) iVar);
            return;
        }
        if (iVar != null && iVar.f257181b != null) {
            QLog.i("AIOFontBubble_FontBubbleManager", 1, "start sendMessage fontBubble :  " + iVar.f257181b.toString());
            if (!iVar.f257182c) {
                FontBubble fontBubble = iVar.f257181b;
                int i16 = fontBubble.panelType;
                if (i16 == 3) {
                    i3 = fontBubble.fontId;
                } else {
                    i3 = fontBubble.bubbleId;
                }
                com.tencent.mobileqq.panel.bubble.d.g(i16, i3, this.D);
            }
            y(iVar, (ISVIPHandler) this.f257112e.getBusinessHandler(BusinessHandlerFactory.SVIP_HANDLER));
            this.f257111d.obtainMessage(1001).sendToTarget();
            return;
        }
        QLog.e("AIOFontBubble_FontBubbleManager", 1, "auth ok but mClick is null");
    }

    public void t(d dVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) dVar);
        } else {
            this.F = dVar;
            this.f257111d.obtainMessage(1003).sendToTarget();
        }
    }

    public void u(Context context) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) context);
            return;
        }
        QQToast.makeText(context, 0, HardCodeUtil.qqStr(R.string.mmq), 2000).show();
        if (this.f257116m != null) {
            String account = BaseApplicationImpl.getApplication().getRuntime().getAccount();
            FontBubble fontBubble = this.f257116m.f257181b;
            int i16 = fontBubble.panelType;
            if (i16 == 3) {
                i3 = fontBubble.fontId;
            } else {
                i3 = fontBubble.bubbleId;
            }
            VasWebviewUtil.reportCommercialDrainage(account, "aio_iconA", "Send", "", 1, 0, 0, "", Integer.toString(i3), FontBubblePanelView.o(i16), "1", "", "", "", 0, 0, 0, 0);
        }
        this.f257116m = null;
        this.f257115i = null;
    }

    public void v(com.tencent.aio.api.runtime.a aVar, Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) aVar, (Object) context);
        } else {
            this.f257113f = new WeakReference<>(aVar);
            this.f257114h = new WeakReference<>(context);
        }
    }

    public void w(FontBubble fontBubble, com.tencent.aio.api.runtime.a aVar, Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, fontBubble, aVar, context);
            return;
        }
        this.f257113f = new WeakReference<>(aVar);
        this.f257114h = new WeakReference<>(context);
        ThreadManagerV2.excute(new Runnable(fontBubble) { // from class: com.tencent.mobileqq.panel.FontBubbleManager.1
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ FontBubble f257117d;

            {
                this.f257117d = fontBubble;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) FontBubbleManager.this, (Object) fontBubble);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                    return;
                }
                NTVasSimpleInfo vasSimpleInfoWithUid = ((IVasInfoService) QRoute.api(IVasInfoService.class)).getVasSimpleInfoWithUid(((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(FontBubbleManager.this.f257112e.getAccount()), "AIOFontBubble_FontBubbleManager");
                if (vasSimpleInfoWithUid == null) {
                    QLog.e("AIOFontBubble_FontBubbleManager", 1, "setFontBubble fail no ExtensionInfo");
                    return;
                }
                ISVIPHandler iSVIPHandler = (ISVIPHandler) FontBubbleManager.this.f257112e.getBusinessHandler(BusinessHandlerFactory.SVIP_HANDLER);
                if (FontBubbleManager.this.f257115i != null) {
                    QLog.d("AIOFontBubble_FontBubbleManager", 1, "consume last mRestore bubble");
                    FontBubbleManager fontBubbleManager = FontBubbleManager.this;
                    fontBubbleManager.y(fontBubbleManager.f257115i, iSVIPHandler);
                }
                FontBubble fontBubble2 = new FontBubble();
                fontBubble2.fontId = (int) vasSimpleInfoWithUid.uVipFont;
                fontBubble2.bubbleId = iSVIPHandler.getSelfBubbleId();
                QLog.d("AIOFontBubble_FontBubbleManager", 1, "SEND_AUTH restore = " + fontBubble2.toString());
                FontBubbleManager.this.f257111d.obtainMessage(1000, new Object[]{fontBubble2, this.f257117d}).sendToTarget();
            }
        }, 32, null, true);
    }

    public void x(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) str);
        } else {
            this.D = str;
        }
    }

    public void z() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
            return;
        }
        Context context = this.f257114h.get();
        if (this.f257116m != null && context != null) {
            Runnable runnable = new Runnable(context) { // from class: com.tencent.mobileqq.panel.FontBubbleManager.4
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ Context f257118d;

                /* compiled from: P */
                /* renamed from: com.tencent.mobileqq.panel.FontBubbleManager$4$a */
                /* loaded from: classes16.dex */
                class a implements DialogInterface.OnClickListener {
                    static IPatchRedirector $redirector_;

                    /* renamed from: d, reason: collision with root package name */
                    final /* synthetic */ FontBubble f257119d;

                    /* renamed from: e, reason: collision with root package name */
                    final /* synthetic */ String f257120e;

                    a(FontBubble fontBubble, String str) {
                        this.f257119d = fontBubble;
                        this.f257120e = str;
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                            iPatchRedirector.redirect((short) 1, this, AnonymousClass4.this, fontBubble, str);
                        }
                    }

                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i3) {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                            iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
                            return;
                        }
                        com.tencent.mobileqq.panel.bubble.d.h(this.f257119d, FontBubbleManager.this.D);
                        Context context = (Context) FontBubbleManager.this.f257114h.get();
                        if (context == null) {
                            return;
                        }
                        ActivityURIRequest activityURIRequest = new ActivityURIRequest(context, VasH5PayConstants.ROUTE_NAME);
                        activityURIRequest.extra().putString("url", this.f257120e);
                        activityURIRequest.extra().putBoolean(IPCConst.KEY_HIDE_LEFT_BUTTON, true);
                        activityURIRequest.extra().putBoolean("show_right_close_button", false);
                        activityURIRequest.extra().putBoolean(QQTranslucentBrowserActivity.FLAG_SHOW_LOADING_DIALOG, true);
                        activityURIRequest.extra().putBoolean(QzoneTranslucentBrowserFragment.KEY_SHOW_CLOSE_BTN, false);
                        activityURIRequest.extra().putBoolean(QQBrowserActivity.EXTRA_FINISH_ANIMATION_NONE, true);
                        activityURIRequest.extra().putInt("fragmentStyle", 2);
                        QRoute.startUri(activityURIRequest, (o) null);
                        dialogInterface.dismiss();
                    }
                }

                /* compiled from: P */
                /* renamed from: com.tencent.mobileqq.panel.FontBubbleManager$4$b */
                /* loaded from: classes16.dex */
                class b implements DialogInterface.OnClickListener {
                    static IPatchRedirector $redirector_;

                    b() {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                            iPatchRedirector.redirect((short) 1, (Object) this, (Object) AnonymousClass4.this);
                        }
                    }

                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i3) {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                            FontBubbleManager.this.f257116m = null;
                            FontBubbleManager.this.f257115i = null;
                            dialogInterface.dismiss();
                            return;
                        }
                        iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
                    }
                }

                {
                    this.f257118d = context;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) FontBubbleManager.this, (Object) context);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    FontBubble fontBubble = FontBubbleManager.this.f257116m.f257181b;
                    String str = fontBubble.title;
                    if (TextUtils.isEmpty(str)) {
                        str = HardCodeUtil.qqStr(R.string.mmr);
                    }
                    String str2 = str;
                    String str3 = fontBubble.f257110msg;
                    if (TextUtils.isEmpty(str3)) {
                        str3 = "\u5f00\u901aQQ\u4f1a\u5458\u5373\u53ef\u4f7f\u7528\u8be5\u6c14\u6ce1";
                    }
                    String str4 = str3;
                    String str5 = fontBubble.btn;
                    if (TextUtils.isEmpty(str5)) {
                        str5 = "\u5f00\u901aQQ\u4f1a\u5458";
                    }
                    String str6 = str5;
                    String str7 = fontBubble.payUrl + com.tencent.mobileqq.panel.bubble.d.d(fontBubble.payUrl, fontBubble.panelType, fontBubble.bubbleId, FontBubbleManager.this.D);
                    if (QLog.isColorLevel()) {
                        QLog.d("AIOFontBubble_FontBubbleManager", 2, "url: " + str7);
                    }
                    DialogUtil.createCustomDialog(this.f257118d, 230, str2, str4, HardCodeUtil.qqStr(R.string.j6l), str6, new a(fontBubble, str7), new b()).show();
                }
            };
            if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
                runnable.run();
            } else {
                ThreadManagerV2.getUIHandlerV2().post(runnable);
            }
        }
    }
}
