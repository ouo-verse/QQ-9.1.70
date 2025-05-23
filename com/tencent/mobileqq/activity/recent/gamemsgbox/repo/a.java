package com.tencent.mobileqq.activity.recent.gamemsgbox.repo;

import android.text.TextUtils;
import com.tencent.mobileqq.gamecenter.msginfo.GameCenterSessionInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes10.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private volatile Map<String, ConcurrentHashMap<String, GameCenterSessionInfo>> f185558a;

    /* renamed from: b, reason: collision with root package name */
    private volatile GameCenterSessionInfo f185559b;

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f185558a = new ConcurrentHashMap();
            this.f185559b = new GameCenterSessionInfo();
        }
    }

    public void a(String str, GameCenterSessionInfo gameCenterSessionInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) str, (Object) gameCenterSessionInfo);
            return;
        }
        if (!TextUtils.isEmpty(str) && gameCenterSessionInfo != null && !TextUtils.isEmpty(gameCenterSessionInfo.w())) {
            if (this.f185558a.containsKey(str)) {
                this.f185558a.get(str).put(gameCenterSessionInfo.w(), gameCenterSessionInfo);
                return;
            }
            ConcurrentHashMap<String, GameCenterSessionInfo> concurrentHashMap = new ConcurrentHashMap<>();
            concurrentHashMap.put(gameCenterSessionInfo.w(), gameCenterSessionInfo);
            this.f185558a.put(str, concurrentHashMap);
        }
    }

    public void b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
        } else {
            this.f185558a.clear();
        }
    }

    public List<String> c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (List) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return new ArrayList(this.f185558a.keySet());
    }

    public GameCenterSessionInfo d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (GameCenterSessionInfo) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return this.f185559b;
    }

    public GameCenterSessionInfo e(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (GameCenterSessionInfo) iPatchRedirector.redirect((short) 4, (Object) this, (Object) str);
        }
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        for (ConcurrentHashMap<String, GameCenterSessionInfo> concurrentHashMap : this.f185558a.values()) {
            if (concurrentHashMap.containsKey(str)) {
                return concurrentHashMap.get(str);
            }
        }
        return null;
    }

    public ConcurrentHashMap<String, GameCenterSessionInfo> f(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (ConcurrentHashMap) iPatchRedirector.redirect((short) 5, (Object) this, (Object) str);
        }
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return this.f185558a.get(str);
    }

    public void g(GameCenterSessionInfo gameCenterSessionInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) gameCenterSessionInfo);
        } else {
            this.f185559b = gameCenterSessionInfo;
        }
    }
}
