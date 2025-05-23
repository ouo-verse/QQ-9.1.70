package com.tencent.mobileqq.profilecard.bussiness.achievement.bean;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes16.dex */
public class LifeAchivementData {
    static IPatchRedirector $redirector_ = null;
    public static final int TYPE_ADD_MORE = 1;
    public static final int TYPE_NORMAL = 0;
    public static final int TYPE_SHOW_ALL = 2;
    public boolean hasPraised;
    public String iconUrl;

    /* renamed from: id, reason: collision with root package name */
    public int f260664id;
    public int moreNum;
    public int praiseNum;
    public String title;
    public int type;

    public LifeAchivementData() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}
