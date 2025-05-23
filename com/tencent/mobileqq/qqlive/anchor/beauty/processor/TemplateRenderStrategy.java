package com.tencent.mobileqq.qqlive.anchor.beauty.processor;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* compiled from: P */
/* loaded from: classes17.dex */
public class TemplateRenderStrategy {
    static IPatchRedirector $redirector_;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* compiled from: P */
    /* loaded from: classes17.dex */
    public static final class Strategy {
        private static final /* synthetic */ Strategy[] $VALUES;
        static IPatchRedirector $redirector_;
        public static final Strategy ACTION_DO_NOTHING;
        public static final Strategy ACTION_REPLACE;
        public static final Strategy ACTION_TRY_MERGE;
        public static final Strategy ACTION_TRY_MERGE_DESC;
        public int value;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(54924);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
                return;
            }
            Strategy strategy = new Strategy("ACTION_DO_NOTHING", 0, 0);
            ACTION_DO_NOTHING = strategy;
            Strategy strategy2 = new Strategy("ACTION_REPLACE", 1, 1);
            ACTION_REPLACE = strategy2;
            Strategy strategy3 = new Strategy("ACTION_TRY_MERGE", 2, 2);
            ACTION_TRY_MERGE = strategy3;
            Strategy strategy4 = new Strategy("ACTION_TRY_MERGE_DESC", 3, 3);
            ACTION_TRY_MERGE_DESC = strategy4;
            $VALUES = new Strategy[]{strategy, strategy2, strategy3, strategy4};
        }

        Strategy(String str, int i3, int i16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, str, Integer.valueOf(i3), Integer.valueOf(i16));
            } else {
                this.value = i16;
            }
        }

        public static Strategy valueOf(String str) {
            return (Strategy) Enum.valueOf(Strategy.class, str);
        }

        public static Strategy[] values() {
            return (Strategy[]) $VALUES.clone();
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* compiled from: P */
    /* loaded from: classes17.dex */
    public static final class TemplateType {
        private static final /* synthetic */ TemplateType[] $VALUES;
        static IPatchRedirector $redirector_;
        public static final TemplateType BASE;
        public static final TemplateType GIFT;
        public static final TemplateType MAKEUP;
        public static final TemplateType PROP;
        public int level;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(54927);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
                return;
            }
            TemplateType templateType = new TemplateType("BASE", 0, 0);
            BASE = templateType;
            TemplateType templateType2 = new TemplateType("MAKEUP", 1, 1);
            MAKEUP = templateType2;
            TemplateType templateType3 = new TemplateType("PROP", 2, 2);
            PROP = templateType3;
            TemplateType templateType4 = new TemplateType("GIFT", 3, 3);
            GIFT = templateType4;
            $VALUES = new TemplateType[]{templateType, templateType2, templateType3, templateType4};
        }

        TemplateType(String str, int i3, int i16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, str, Integer.valueOf(i3), Integer.valueOf(i16));
            } else {
                this.level = i16;
            }
        }

        public static TemplateType valueOf(String str) {
            return (TemplateType) Enum.valueOf(TemplateType.class, str);
        }

        public static TemplateType[] values() {
            return (TemplateType[]) $VALUES.clone();
        }
    }

    /* compiled from: P */
    /* loaded from: classes17.dex */
    public static class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public Strategy f270422a;

        /* renamed from: b, reason: collision with root package name */
        public TemplateType f270423b;

        /* renamed from: c, reason: collision with root package name */
        public String f270424c;

        /* renamed from: d, reason: collision with root package name */
        public String f270425d;

        public a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    public static Strategy a(TemplateType templateType, TemplateType templateType2) {
        if (templateType.level > templateType2.level) {
            return Strategy.ACTION_DO_NOTHING;
        }
        return Strategy.ACTION_REPLACE;
    }
}
