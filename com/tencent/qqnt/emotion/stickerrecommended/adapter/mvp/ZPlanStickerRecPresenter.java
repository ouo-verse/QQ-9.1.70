package com.tencent.qqnt.emotion.stickerrecommended.adapter.mvp;

import android.widget.EditText;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.emotion.stickerrecommended.impl.StickerRecManagerImpl;
import com.tencent.qqnt.emotion.stickerrecommended.o;
import com.tencent.qqnt.emotion.stickerrecommended.zplan.api.INTZPlanPlayer;
import com.tencent.util.k;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes24.dex */
public class ZPlanStickerRecPresenter extends a {
    static IPatchRedirector $redirector_;

    /* renamed from: o, reason: collision with root package name */
    private static final CopyOnWriteArrayList<INTZPlanPlayer> f356465o;

    /* renamed from: m, reason: collision with root package name */
    private h f356466m;

    /* renamed from: n, reason: collision with root package name */
    private o f356467n;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(45530);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
        } else {
            f356465o = new CopyOnWriteArrayList<>();
        }
    }

    public ZPlanStickerRecPresenter(AppInterface appInterface, com.tencent.aio.api.runtime.a aVar, EditText editText) {
        super(appInterface, aVar, editText);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, appInterface, aVar, editText);
        }
    }

    private void A(INTZPlanPlayer iNTZPlanPlayer) {
        CopyOnWriteArrayList<INTZPlanPlayer> copyOnWriteArrayList = f356465o;
        synchronized (copyOnWriteArrayList) {
            copyOnWriteArrayList.remove(iNTZPlanPlayer);
        }
        if (iNTZPlanPlayer.isReady()) {
            iNTZPlanPlayer.stop();
        }
    }

    public static void B() {
        CopyOnWriteArrayList<INTZPlanPlayer> copyOnWriteArrayList = f356465o;
        synchronized (copyOnWriteArrayList) {
            if (copyOnWriteArrayList.size() == 0) {
                return;
            }
            Iterator<INTZPlanPlayer> it = copyOnWriteArrayList.iterator();
            while (it.hasNext()) {
                it.next().stop();
            }
            f356465o.clear();
        }
    }

    private void C() {
        if (QLog.isColorLevel()) {
            QLog.d("ZPlanStickerRecPresenter", 2, "sendPic");
        }
        h hVar = this.f356466m;
        if (hVar != null && hVar.I != null) {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.qqnt.emotion.stickerrecommended.adapter.mvp.ZPlanStickerRecPresenter.1
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) ZPlanStickerRecPresenter.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this);
                        return;
                    }
                    ZPlanStickerRecPresenter zPlanStickerRecPresenter = ZPlanStickerRecPresenter.this;
                    if (zPlanStickerRecPresenter.f356472c != null && zPlanStickerRecPresenter.f356473d != null) {
                        INTZPlanPlayer iNTZPlanPlayer = zPlanStickerRecPresenter.f356466m.I;
                        ZPlanStickerRecPresenter zPlanStickerRecPresenter2 = ZPlanStickerRecPresenter.this;
                        iNTZPlanPlayer.onSend(zPlanStickerRecPresenter2.f356472c, zPlanStickerRecPresenter2.f356473d);
                        return;
                    }
                    QLog.e("ZPlanStickerRecPresenter", 1, "[sendZPlanMsg] error, mBaseChatPie or mQQApp is null!");
                }
            }, 16, null, false);
        } else if (QLog.isColorLevel()) {
            QLog.d("ZPlanStickerRecPresenter", 2, "sendPic data is null");
        }
    }

    public static void j() {
        B();
    }

    private void y(INTZPlanPlayer iNTZPlanPlayer) {
        CopyOnWriteArrayList<INTZPlanPlayer> copyOnWriteArrayList = f356465o;
        synchronized (copyOnWriteArrayList) {
            if (!copyOnWriteArrayList.contains(iNTZPlanPlayer)) {
                copyOnWriteArrayList.add(iNTZPlanPlayer);
            }
        }
    }

    private void z() {
        boolean z16;
        if (!QLog.isColorLevel()) {
            return;
        }
        StringBuilder sb5 = new StringBuilder();
        CopyOnWriteArrayList<INTZPlanPlayer> copyOnWriteArrayList = f356465o;
        synchronized (copyOnWriteArrayList) {
            int size = copyOnWriteArrayList.size();
            sb5.append("log ZPlanPlayers list info count = ");
            sb5.append(size);
            sb5.append("\n");
            for (int i3 = 0; i3 < size; i3++) {
                INTZPlanPlayer iNTZPlanPlayer = f356465o.get(i3);
                StringBuilder sb6 = new StringBuilder();
                sb6.append("log No.");
                sb6.append(i3);
                sb6.append(" ZPlanPlayers is invisible = ");
                if (iNTZPlanPlayer.getView().getVisibility() == 4) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                sb6.append(z16);
                sb6.append("\n");
                sb5.append(sb6.toString());
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d("ZPlanStickerRecPresenter", 2, sb5.toString());
        }
    }

    @Override // com.tencent.qqnt.emotion.stickerrecommended.adapter.mvp.a, com.tencent.qqnt.emotion.stickerrecommended.adapter.mvp.d
    public void c(e eVar, c cVar) {
        List a16;
        String f16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) eVar, (Object) cVar);
            return;
        }
        if (!i(eVar)) {
            QLog.e("ZPlanStickerRecPresenter", 1, "binding view error!");
            return;
        }
        if (!h(cVar)) {
            QLog.e("ZPlanStickerRecPresenter", 1, "binding model error!");
            this.f356466m.c(false);
            A(this.f356466m.I);
            return;
        }
        String z16 = this.f356467n.z();
        if (QLog.isDevelopLevel()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("updateZPlanView zPlanInfo = ");
            if (z16 != null) {
                a16 = com.tencent.mobileqq.guild.feed.widget.d.a(new Object[]{"zh_name"});
                f16 = k.f(z16, a16);
            } else {
                f16 = "null";
            }
            sb5.append(f16);
            QLog.d("ZPlanStickerRecPresenter", 4, sb5.toString());
        }
        if (StringUtil.isEmpty(z16)) {
            return;
        }
        try {
            this.f356466m.I.setJson(new JSONObject(z16), this.f356473d);
            this.f356466m.c(true);
            y(this.f356466m.I);
            if (StickerRecManagerImpl.isStickerRecFromRemote(this.f356471b)) {
                ((o) this.f356471b).F(true);
            }
        } catch (JSONException e16) {
            e16.printStackTrace();
        }
    }

    @Override // com.tencent.qqnt.emotion.stickerrecommended.adapter.mvp.a, com.tencent.qqnt.emotion.stickerrecommended.adapter.mvp.d
    public c getModel() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (c) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.f356467n;
    }

    @Override // com.tencent.qqnt.emotion.stickerrecommended.adapter.mvp.a
    public boolean h(c cVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) cVar)).booleanValue();
        }
        super.h(cVar);
        if (cVar instanceof o) {
            this.f356467n = (o) cVar;
            return true;
        }
        return false;
    }

    @Override // com.tencent.qqnt.emotion.stickerrecommended.adapter.mvp.a
    public boolean i(e eVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) eVar)).booleanValue();
        }
        super.i(eVar);
        if (eVar instanceof h) {
            this.f356466m = (h) eVar;
            return true;
        }
        return false;
    }

    @Override // com.tencent.qqnt.emotion.stickerrecommended.adapter.mvp.a
    public boolean q() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this)).booleanValue();
        }
        z();
        C();
        com.tencent.qqnt.emotion.stickerrecommended.g gVar = this.f356471b;
        if (gVar != null && StickerRecManagerImpl.isStickerRecFromRemote(gVar)) {
            ((o) this.f356471b).D(true);
        }
        v();
        return true;
    }
}
