package com.tencent.mobileqq.relationx.icebreaking.bean;

import androidx.annotation.NonNull;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.mobileqq.profilecard.bussiness.anonymous.bean.AnonymousQuestion;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqnt.aio.adapter.api.IMiniCardBeancurd;
import cooperation.qqcircle.report.QCircleLpReportDc05494;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* compiled from: P */
/* loaded from: classes17.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public C8501a f280807a;

    /* renamed from: b, reason: collision with root package name */
    public List<String> f280808b;

    /* renamed from: c, reason: collision with root package name */
    public c f280809c;

    /* renamed from: d, reason: collision with root package name */
    public List<b> f280810d;

    /* renamed from: e, reason: collision with root package name */
    public d f280811e;

    /* renamed from: f, reason: collision with root package name */
    public AnonymousQuestion f280812f;

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.relationx.icebreaking.bean.a$a, reason: collision with other inner class name */
    /* loaded from: classes17.dex */
    public static class C8501a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public int f280813a;

        /* renamed from: b, reason: collision with root package name */
        public int f280814b;

        /* renamed from: c, reason: collision with root package name */
        public String f280815c;

        /* renamed from: d, reason: collision with root package name */
        public String f280816d;

        /* renamed from: e, reason: collision with root package name */
        public int f280817e;

        public C8501a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
                return;
            }
            this.f280813a = -1;
            this.f280814b = -1;
            this.f280815c = "";
            this.f280816d = "";
            this.f280817e = -1;
        }

        @NonNull
        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (String) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            StringBuilder sb5 = new StringBuilder(1024);
            sb5.append("age");
            sb5.append(ContainerUtils.KEY_VALUE_DELIMITER);
            sb5.append(this.f280813a);
            sb5.append("|");
            sb5.append("gender");
            sb5.append(ContainerUtils.KEY_VALUE_DELIMITER);
            sb5.append(this.f280814b);
            sb5.append("|");
            sb5.append(QCircleLpReportDc05494.KEY_PLACE);
            sb5.append(ContainerUtils.KEY_VALUE_DELIMITER);
            sb5.append(this.f280815c);
            sb5.append("|");
            sb5.append("addSrc");
            sb5.append(ContainerUtils.KEY_VALUE_DELIMITER);
            sb5.append(this.f280816d);
            sb5.append("|");
            sb5.append("commFrdCnt");
            sb5.append(ContainerUtils.KEY_VALUE_DELIMITER);
            sb5.append(this.f280817e);
            sb5.append("|");
            return sb5.toString();
        }
    }

    /* compiled from: P */
    /* loaded from: classes17.dex */
    public static class b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public String f280818a;

        /* renamed from: b, reason: collision with root package name */
        public String f280819b;

        public b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            } else {
                this.f280818a = "";
                this.f280819b = "";
            }
        }

        @NonNull
        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (String) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            StringBuilder sb5 = new StringBuilder(1024);
            sb5.append("oriUrl");
            sb5.append(ContainerUtils.KEY_VALUE_DELIMITER);
            sb5.append(this.f280818a);
            sb5.append("|");
            sb5.append("mediumUrl");
            sb5.append(ContainerUtils.KEY_VALUE_DELIMITER);
            sb5.append(this.f280819b);
            sb5.append("|");
            return sb5.toString();
        }
    }

    /* compiled from: P */
    /* loaded from: classes17.dex */
    public static class c {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public String f280820a;

        /* renamed from: b, reason: collision with root package name */
        public String f280821b;

        /* renamed from: c, reason: collision with root package name */
        public List<String> f280822c;

        public c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
                return;
            }
            this.f280820a = "";
            this.f280821b = "";
            this.f280822c = new ArrayList();
        }

        @NonNull
        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (String) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            StringBuilder sb5 = new StringBuilder(1024);
            sb5.append("qzoneName");
            sb5.append(ContainerUtils.KEY_VALUE_DELIMITER);
            sb5.append(this.f280820a);
            sb5.append("|");
            sb5.append("updateContent");
            sb5.append(ContainerUtils.KEY_VALUE_DELIMITER);
            sb5.append(this.f280821b);
            sb5.append("|");
            sb5.append("imgUrls");
            sb5.append(ContainerUtils.KEY_VALUE_DELIMITER);
            sb5.append(Arrays.toString(this.f280822c.toArray()));
            sb5.append("|");
            return sb5.toString();
        }
    }

    /* compiled from: P */
    /* loaded from: classes17.dex */
    public static class d {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public int f280823a;

        /* renamed from: b, reason: collision with root package name */
        public String f280824b;

        /* renamed from: c, reason: collision with root package name */
        public String f280825c;

        public d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
                return;
            }
            this.f280823a = 0;
            this.f280824b = "";
            this.f280825c = "";
        }

        @NonNull
        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (String) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            StringBuilder sb5 = new StringBuilder(1024);
            sb5.append("actionId");
            sb5.append(ContainerUtils.KEY_VALUE_DELIMITER);
            sb5.append(this.f280823a);
            sb5.append("|");
            sb5.append(IMiniCardBeancurd.SIGN_ACTION_DATA);
            sb5.append(ContainerUtils.KEY_VALUE_DELIMITER);
            sb5.append(this.f280824b);
            sb5.append("|");
            sb5.append(IMiniCardBeancurd.SIGN_PLAIN_TEXT);
            sb5.append(ContainerUtils.KEY_VALUE_DELIMITER);
            sb5.append(this.f280825c);
            sb5.append("|");
            return sb5.toString();
        }
    }

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f280808b = new ArrayList();
            this.f280810d = new ArrayList();
        }
    }

    @NonNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        StringBuilder sb5 = new StringBuilder(1024);
        sb5.append("baseProfile");
        sb5.append(ContainerUtils.KEY_VALUE_DELIMITER);
        sb5.append(this.f280807a);
        sb5.append("|\n");
        sb5.append("personalLabels");
        sb5.append(ContainerUtils.KEY_VALUE_DELIMITER);
        sb5.append(Arrays.toString(this.f280808b.toArray()));
        sb5.append("|\n");
        sb5.append("qZoneInfo");
        sb5.append(ContainerUtils.KEY_VALUE_DELIMITER);
        sb5.append(this.f280809c);
        sb5.append("|\n");
        sb5.append("nicePics");
        sb5.append(ContainerUtils.KEY_VALUE_DELIMITER);
        sb5.append(Arrays.toString(this.f280810d.toArray()));
        sb5.append("|\n");
        sb5.append("sign");
        sb5.append(ContainerUtils.KEY_VALUE_DELIMITER);
        sb5.append(this.f280811e);
        sb5.append("|\n");
        sb5.append("askAnonymously");
        sb5.append(ContainerUtils.KEY_VALUE_DELIMITER);
        sb5.append(this.f280812f);
        sb5.append("|\n");
        return sb5.toString();
    }
}
