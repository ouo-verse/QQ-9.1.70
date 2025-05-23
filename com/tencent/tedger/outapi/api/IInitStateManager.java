package com.tencent.tedger.outapi.api;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes26.dex */
public interface IInitStateManager extends ue4.a {

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public static final class TEdgeRSInitStep {
        private static final /* synthetic */ TEdgeRSInitStep[] $VALUES;
        static IPatchRedirector $redirector_;
        public static final TEdgeRSInitStep Begin;
        public static final TEdgeRSInitStep CheckedConfig;
        public static final TEdgeRSInitStep CheckedVersion;
        public static final TEdgeRSInitStep End;
        public static final TEdgeRSInitStep GotConfig;
        public static final TEdgeRSInitStep GotModels;
        public static final TEdgeRSInitStep InitializedSO;
        public static final TEdgeRSInitStep LoadedSO;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(7997);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
                return;
            }
            TEdgeRSInitStep tEdgeRSInitStep = new TEdgeRSInitStep("Begin", 0);
            Begin = tEdgeRSInitStep;
            TEdgeRSInitStep tEdgeRSInitStep2 = new TEdgeRSInitStep("GotConfig", 1);
            GotConfig = tEdgeRSInitStep2;
            TEdgeRSInitStep tEdgeRSInitStep3 = new TEdgeRSInitStep("CheckedConfig", 2);
            CheckedConfig = tEdgeRSInitStep3;
            TEdgeRSInitStep tEdgeRSInitStep4 = new TEdgeRSInitStep("LoadedSO", 3);
            LoadedSO = tEdgeRSInitStep4;
            TEdgeRSInitStep tEdgeRSInitStep5 = new TEdgeRSInitStep("InitializedSO", 4);
            InitializedSO = tEdgeRSInitStep5;
            TEdgeRSInitStep tEdgeRSInitStep6 = new TEdgeRSInitStep("GotModels", 5);
            GotModels = tEdgeRSInitStep6;
            TEdgeRSInitStep tEdgeRSInitStep7 = new TEdgeRSInitStep("CheckedVersion", 6);
            CheckedVersion = tEdgeRSInitStep7;
            TEdgeRSInitStep tEdgeRSInitStep8 = new TEdgeRSInitStep("End", 7);
            End = tEdgeRSInitStep8;
            $VALUES = new TEdgeRSInitStep[]{tEdgeRSInitStep, tEdgeRSInitStep2, tEdgeRSInitStep3, tEdgeRSInitStep4, tEdgeRSInitStep5, tEdgeRSInitStep6, tEdgeRSInitStep7, tEdgeRSInitStep8};
        }

        TEdgeRSInitStep(String str, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, i3);
            }
        }

        public static TEdgeRSInitStep valueOf(String str) {
            return (TEdgeRSInitStep) Enum.valueOf(TEdgeRSInitStep.class, str);
        }

        public static TEdgeRSInitStep[] values() {
            return (TEdgeRSInitStep[]) $VALUES.clone();
        }
    }

    /* compiled from: P */
    /* loaded from: classes26.dex */
    public interface a {

        /* compiled from: P */
        /* renamed from: com.tencent.tedger.outapi.api.IInitStateManager$a$a, reason: collision with other inner class name */
        /* loaded from: classes26.dex */
        public interface InterfaceC9900a {
            void a();
        }

        void a(TEdgeRSInitStep tEdgeRSInitStep, InterfaceC9900a interfaceC9900a);

        boolean b(TEdgeRSInitStep tEdgeRSInitStep, int i3);
    }

    void c(Map<String, Object> map);

    boolean o();

    boolean w();

    TEdgeRSInitStep y();
}
