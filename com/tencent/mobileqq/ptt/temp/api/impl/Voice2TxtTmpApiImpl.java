package com.tencent.mobileqq.ptt.temp.api.impl;

import a61.b;
import a61.d;
import android.content.Context;
import android.view.View;
import android.widget.PopupWindow;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.aio.audiopanel.AudioPanelUtils;
import com.tencent.mobileqq.activity.aio.item.m;
import com.tencent.mobileqq.activity.aio.item.n;
import com.tencent.mobileqq.activity.aio.p;
import com.tencent.mobileqq.activity.aio.rebuild.input.shortcutbar.AIOShortcutBarHelper;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.ptt.temp.api.IVoice2TxtTmpApi;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.utils.RecordParams;
import com.tencent.qqnt.aio.audiopanel.k;
import com.tencent.qqnt.aio.audiopanel.o;
import java.util.ArrayList;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes16.dex */
public class Voice2TxtTmpApiImpl implements IVoice2TxtTmpApi {
    static IPatchRedirector $redirector_;

    public Voice2TxtTmpApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.ptt.temp.api.IVoice2TxtTmpApi
    public int getAudioPanelContainerEditStateDeltaHeight(b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Integer) iPatchRedirector.redirect((short) 13, (Object) this, (Object) bVar)).intValue();
        }
        return 0;
    }

    @Override // com.tencent.mobileqq.ptt.temp.api.IVoice2TxtTmpApi
    public int getCustomTitleViewBottom(b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this, (Object) bVar)).intValue();
        }
        return bVar.a();
    }

    @Override // com.tencent.mobileqq.ptt.temp.api.IVoice2TxtTmpApi
    public PopupWindow getTopMask() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (PopupWindow) iPatchRedirector.redirect((short) 12, (Object) this);
        }
        return AudioPanelUtils.b();
    }

    @Override // com.tencent.mobileqq.ptt.temp.api.IVoice2TxtTmpApi
    public int getWaveViewLen(Context context, int i3, float f16, int i16, int i17, boolean z16, boolean z17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, this, context, Integer.valueOf(i3), Float.valueOf(f16), Integer.valueOf(i16), Integer.valueOf(i17), Boolean.valueOf(z16), Boolean.valueOf(z17))).intValue();
        }
        return n.d(context, i3, f16, i16, i17, z16, z17);
    }

    @Override // com.tencent.mobileqq.ptt.temp.api.IVoice2TxtTmpApi
    public void hideChatPieOtherFunction(b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) bVar);
            return;
        }
        AIOShortcutBarHelper aIOShortcutBarHelper = (AIOShortcutBarHelper) bVar.b(52);
        if (aIOShortcutBarHelper != null) {
            aIOShortcutBarHelper.y(11);
        }
    }

    @Override // com.tencent.mobileqq.ptt.temp.api.IVoice2TxtTmpApi
    public void hideSoftInput(b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) bVar);
        } else {
            bVar.f();
        }
    }

    @Override // com.tencent.mobileqq.ptt.temp.api.IVoice2TxtTmpApi
    public void restoreChatPieOtherFunction(b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) bVar);
            return;
        }
        AIOShortcutBarHelper aIOShortcutBarHelper = (AIOShortcutBarHelper) bVar.b(52);
        if (aIOShortcutBarHelper != null) {
            aIOShortcutBarHelper.y(12);
        }
    }

    @Override // com.tencent.mobileqq.ptt.temp.api.IVoice2TxtTmpApi
    public void sendTxt(b bVar, AppRuntime appRuntime, p pVar, String str, Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, bVar, appRuntime, pVar, str, context);
        } else if (bVar instanceof d) {
            ((o) bVar.c().b(36)).j(str);
        } else {
            ChatActivityFacade.M0((QQAppInterface) appRuntime, context, pVar, str, new ArrayList(), new ChatActivityFacade.d());
        }
    }

    @Override // com.tencent.mobileqq.ptt.temp.api.IVoice2TxtTmpApi
    public void sendVoiceAndTxt(b bVar, String str, int i3, int i16, RecordParams.RecorderParam recorderParam, int i17, boolean z16, int i18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z17 = true;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, bVar, str, Integer.valueOf(i3), Integer.valueOf(i16), recorderParam, Integer.valueOf(i17), Boolean.valueOf(z16), Integer.valueOf(i18));
            return;
        }
        if (bVar instanceof d) {
            o oVar = (o) bVar.c().b(36);
            float f16 = i16;
            ArrayList<Byte> c16 = k.c(recorderParam.D, recorderParam.C);
            if (i18 <= 0) {
                z17 = false;
            }
            oVar.k(str, f16, c16, recorderParam, z17);
        }
    }

    @Override // com.tencent.mobileqq.ptt.temp.api.IVoice2TxtTmpApi
    public void setCustomTitleVisiable(b bVar, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) bVar, i3);
        } else {
            bVar.g(i3);
        }
    }

    @Override // com.tencent.mobileqq.ptt.temp.api.IVoice2TxtTmpApi
    public void setIsInVoiceTxt(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, z16);
        } else {
            m.f179513c = z16;
        }
    }

    @Override // com.tencent.mobileqq.ptt.temp.api.IVoice2TxtTmpApi
    public PopupWindow showTopMaskPanel(Context context, int i3, int i16, View view, int i17, int i18, int i19) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (PopupWindow) iPatchRedirector.redirect((short) 11, this, context, Integer.valueOf(i3), Integer.valueOf(i16), view, Integer.valueOf(i17), Integer.valueOf(i18), Integer.valueOf(i19));
        }
        return AudioPanelUtils.d(context, i3, i16, view, i17, i18, i19);
    }
}
