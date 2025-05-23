package com.tencent.trackrecordlib.enums;

import com.tencent.mobileqq.nearbypro.profile.avatar.MyNearbyProBizScene;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.zootopia.ue.PayPluginScene;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* compiled from: P */
/* loaded from: classes26.dex */
public final class UiAction {
    static IPatchRedirector $redirector_;
    public static final UiAction CLICK;
    public static final UiAction EXPOSE;
    public static final UiAction INPUT;
    public static final UiAction KEY;
    public static final UiAction LONG_PRESS;
    public static final UiAction OTHERS;
    public static final UiAction REFRESH;
    public static final UiAction SCREEN_ROTATION;
    public static final UiAction SCROLL;
    public static final UiAction ZOOM;

    /* renamed from: a, reason: collision with root package name */
    private static final /* synthetic */ UiAction[] f381117a;
    private int seq;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(11518);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
            return;
        }
        UiAction uiAction = new UiAction(MyNearbyProBizScene.CLICK, 0, 1);
        CLICK = uiAction;
        UiAction uiAction2 = new UiAction("LONG_PRESS", 1, 2);
        LONG_PRESS = uiAction2;
        UiAction uiAction3 = new UiAction("SCROLL", 2, 3);
        SCROLL = uiAction3;
        UiAction uiAction4 = new UiAction("KEY", 3, 4);
        KEY = uiAction4;
        UiAction uiAction5 = new UiAction("SCREEN_ROTATION", 4, 5);
        SCREEN_ROTATION = uiAction5;
        UiAction uiAction6 = new UiAction("ZOOM", 5, 6);
        ZOOM = uiAction6;
        UiAction uiAction7 = new UiAction("INPUT", 6, 7);
        INPUT = uiAction7;
        UiAction uiAction8 = new UiAction("REFRESH", 7, 8);
        REFRESH = uiAction8;
        UiAction uiAction9 = new UiAction("EXPOSE", 8, 9);
        EXPOSE = uiAction9;
        UiAction uiAction10 = new UiAction(PayPluginScene.OTHERS, 9, 100);
        OTHERS = uiAction10;
        f381117a = new UiAction[]{uiAction, uiAction2, uiAction3, uiAction4, uiAction5, uiAction6, uiAction7, uiAction8, uiAction9, uiAction10};
    }

    UiAction(String str, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, str, Integer.valueOf(i3), Integer.valueOf(i16));
        } else {
            this.seq = i16;
        }
    }

    public static UiAction valueOf(String str) {
        return (UiAction) Enum.valueOf(UiAction.class, str);
    }

    public static UiAction[] values() {
        return (UiAction[]) f381117a.clone();
    }

    public int getSeq() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        return this.seq;
    }

    public void setSeq(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, i3);
        } else {
            this.seq = i3;
        }
    }
}
