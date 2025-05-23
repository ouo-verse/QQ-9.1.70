package com.tencent.tedger.outapi.api;

import android.app.Application;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.tedger.outapi.beans.EdgeAction;
import com.tencent.tedger.outapi.beans.EdgeStatus;
import com.tencent.tedger.outapi.beans.EdgeUser;

/* compiled from: P */
/* loaded from: classes26.dex */
public interface ITEdgeRSServer extends ue4.a {

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public static final class TEdgeServerScene {
        private static final /* synthetic */ TEdgeServerScene[] $VALUES;
        static IPatchRedirector $redirector_;
        public static final TEdgeServerScene ClientRank;
        public static final TEdgeServerScene CloudAndClientRank;
        public static final TEdgeServerScene CloudRank;
        public static final TEdgeServerScene EdgeInfer;
        public static final TEdgeServerScene EdgeTraining;
        public static final TEdgeServerScene customizeProcess;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(8254);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
                return;
            }
            TEdgeServerScene tEdgeServerScene = new TEdgeServerScene("ClientRank", 0);
            ClientRank = tEdgeServerScene;
            TEdgeServerScene tEdgeServerScene2 = new TEdgeServerScene("CloudRank", 1);
            CloudRank = tEdgeServerScene2;
            TEdgeServerScene tEdgeServerScene3 = new TEdgeServerScene("CloudAndClientRank", 2);
            CloudAndClientRank = tEdgeServerScene3;
            TEdgeServerScene tEdgeServerScene4 = new TEdgeServerScene("EdgeTraining", 3);
            EdgeTraining = tEdgeServerScene4;
            TEdgeServerScene tEdgeServerScene5 = new TEdgeServerScene("EdgeInfer", 4);
            EdgeInfer = tEdgeServerScene5;
            TEdgeServerScene tEdgeServerScene6 = new TEdgeServerScene("customizeProcess", 5);
            customizeProcess = tEdgeServerScene6;
            $VALUES = new TEdgeServerScene[]{tEdgeServerScene, tEdgeServerScene2, tEdgeServerScene3, tEdgeServerScene4, tEdgeServerScene5, tEdgeServerScene6};
        }

        TEdgeServerScene(String str, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, i3);
            }
        }

        public static TEdgeServerScene valueOf(String str) {
            return (TEdgeServerScene) Enum.valueOf(TEdgeServerScene.class, str);
        }

        public static TEdgeServerScene[] values() {
            return (TEdgeServerScene[]) $VALUES.clone();
        }
    }

    /* compiled from: P */
    /* loaded from: classes26.dex */
    public static class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public String f375265a;

        /* renamed from: b, reason: collision with root package name */
        public String f375266b;

        /* renamed from: c, reason: collision with root package name */
        public String f375267c;

        /* renamed from: d, reason: collision with root package name */
        public String f375268d;

        /* renamed from: e, reason: collision with root package name */
        public TEdgeServerScene f375269e;

        /* renamed from: f, reason: collision with root package name */
        public Application f375270f;

        /* renamed from: g, reason: collision with root package name */
        public String f375271g;

        /* renamed from: h, reason: collision with root package name */
        public String f375272h;

        public a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    void addUserAction(EdgeAction edgeAction);

    d getConfigManager();

    void init();

    boolean isSDKReady();

    void onDestroy();

    void reInitAllIfNecessary();

    void setVerboseLogMode();

    void updateUserBaseInfo(EdgeUser edgeUser, EdgeStatus edgeStatus);
}
