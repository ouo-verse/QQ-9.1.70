package com.tencent.mobileqq.flashchat;

import android.view.MotionEvent;
import android.view.View;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.ArkFlashChatMessage;
import com.tencent.mobileqq.flashchat.FlashChatPanel;
import com.tencent.mobileqq.panel.RichTextPanelView;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.QQToast;
import mqq.os.MqqHandler;

/* loaded from: classes12.dex */
public class FlashChatPanelView extends RichTextPanelView implements d {
    static IPatchRedirector $redirector_;

    /* renamed from: i, reason: collision with root package name */
    private static final String f209826i;

    /* renamed from: f, reason: collision with root package name */
    private FlashChatTextEffectView f209827f;

    /* renamed from: h, reason: collision with root package name */
    private a61.c f209828h;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(71960);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 11)) {
            redirector.redirect((short) 11);
        } else {
            f209826i = HardCodeUtil.qqStr(R.string.f171990ml4);
        }
    }

    @Override // com.tencent.mobileqq.panel.RichTextPanelView
    public String a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return f209826i;
    }

    @Override // com.tencent.mobileqq.panel.RichTextPanelView
    public void b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        super.b();
        this.f209827f.C.clear();
        this.f209827f.l();
        this.f209827f.d();
        this.f209827f.c();
        MqqHandler mqqHandler = this.f209827f.f209832i;
        if (mqqHandler != null) {
            mqqHandler.removeCallbacksAndMessages(null);
        }
    }

    @Override // com.tencent.mobileqq.panel.RichTextPanelView
    public void c(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, z16);
            return;
        }
        if (z16) {
            FlashChatManager flashChatManager = (FlashChatManager) this.f209828h.f25577b.getManager(QQManagerFactory.FLASH_CHAT_MANAGER);
            if (flashChatManager.l().size() < 3) {
                flashChatManager.B();
            }
            this.f209827f.m();
            d();
            return;
        }
        this.f209827f.f209832i.removeMessages(0);
        this.f209827f.f209832i.removeMessages(1);
        this.f209827f.f209832i.removeMessages(2);
        this.f209827f.f209832i.removeMessages(3);
        this.f209827f.f209832i.removeMessages(4);
        this.f209827f.C.clear();
        this.f209827f.l();
        this.f209827f.k();
    }

    public void d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
        } else {
            this.f209827f.j();
        }
    }

    public void e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        this.f209827f.f209832i.removeMessages(0);
        this.f209827f.f209832i.removeMessages(1);
        this.f209827f.f209832i.removeMessages(2);
        this.f209827f.f209832i.removeMessages(3);
        this.f209827f.f209832i.removeMessages(4);
        this.f209827f.C.clear();
        this.f209827f.l();
        this.f209827f.k();
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Boolean) iPatchRedirector.redirect((short) 10, (Object) this, (Object) view, (Object) motionEvent)).booleanValue();
        }
        return false;
    }

    @Override // com.tencent.mobileqq.flashchat.d
    public void t0(View view, int i3, int i16) {
        int i17;
        FlashChatItem flashChatItem;
        FlashChatItem flashChatItem2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, view, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        StringBuilder sb5 = new StringBuilder();
        FlashChatPanel.b f16 = this.f209827f.f(i3);
        if (f16 != null && (flashChatItem2 = f16.f209824e) != null) {
            i17 = flashChatItem2.f209775id;
        } else {
            i17 = -1;
        }
        FlashChatManager flashChatManager = (FlashChatManager) this.f209828h.f25577b.getManager(QQManagerFactory.FLASH_CHAT_MANAGER);
        flashChatManager.C(sb5.toString());
        if (this.f209828h.f25587l.getText().toString().isEmpty()) {
            if (f16 != null && (flashChatItem = f16.f209824e) != null) {
                int i18 = flashChatItem.f209775id;
                return;
            }
            return;
        }
        String replaceAll = FlashChatManager.r(this.f209828h.f25587l.getText().toString()).replaceAll("\\s", "");
        if (replaceAll.length() <= 20) {
            ArkFlashChatMessage q16 = flashChatManager.q(replaceAll, 0, i17);
            if (q16 != null) {
                this.f209828h.f25587l.setText("");
                this.f209828h.f25587l.setCompoundDrawables(null, null, null, null);
                this.f209828h.f25587l.setTag(R.id.gja, null);
                this.f209828h.f25587l.setSelection(0);
                ChatActivityFacade.y0((QQAppInterface) BaseApplicationImpl.sApplication.getRuntime(), this.f209828h.m(), q16);
                ReportController.o(this.f209828h.f25577b, "CliOper", "", "", "0X80094D6", "0X80094D6", 0, 0, "", "", "", "");
                this.f209828h.v();
                return;
            }
            return;
        }
        QQToast.makeText(getContext(), HardCodeUtil.qqStr(R.string.f171989ml3), 0).show();
    }

    @Override // com.tencent.mobileqq.flashchat.d
    public void zb(View view, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, view, Integer.valueOf(i3), Integer.valueOf(i16));
        }
    }
}
