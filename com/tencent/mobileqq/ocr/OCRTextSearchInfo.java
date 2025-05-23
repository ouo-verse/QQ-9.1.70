package com.tencent.mobileqq.ocr;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import tencent.im.cs.cmd0x6ff.subcmd0x533$HttpMapItem;

/* compiled from: P */
/* loaded from: classes16.dex */
public class OCRTextSearchInfo {
    static IPatchRedirector $redirector_;

    /* compiled from: P */
    /* loaded from: classes16.dex */
    public static class SougouSearchInfo implements Serializable {
        static IPatchRedirector $redirector_;
        public String abstractStr;
        public List<String> abstractStrKeyWords;
        public String jumpURL;
        public String keyWord;
        public String sourceFrom;
        public String stype;
        public String summaryPic;
        public String title;
        public List<String> titleKeyWords;

        public SougouSearchInfo() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
                return;
            }
            this.title = "";
            this.jumpURL = "";
            this.abstractStr = "";
            this.sourceFrom = "";
            this.stype = "";
            this.keyWord = "";
            this.summaryPic = "";
        }

        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (String) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return "\nSougouSearchInfo\n |-title:" + this.title + "\n |-jumpURL:" + this.jumpURL + "\n |-summaryPic:" + this.summaryPic + "\n |-titleKeyWords:" + this.titleKeyWords + "\n |-abstractStrKeyWords:" + this.abstractStrKeyWords;
        }
    }

    /* compiled from: P */
    /* loaded from: classes16.dex */
    public static class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public String f254547a;

        /* renamed from: b, reason: collision with root package name */
        public int f254548b;

        /* renamed from: c, reason: collision with root package name */
        public String f254549c;

        /* renamed from: d, reason: collision with root package name */
        public String f254550d;

        /* renamed from: e, reason: collision with root package name */
        public List<b> f254551e;

        public a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            } else {
                this.f254551e = new ArrayList();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes16.dex */
    public static class b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public Object f254552a;

        public b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes16.dex */
    public static class c {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public List<a> f254553a;

        /* renamed from: b, reason: collision with root package name */
        public List<f> f254554b;

        /* renamed from: c, reason: collision with root package name */
        public boolean f254555c;

        public c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            } else {
                this.f254555c = false;
            }
        }
    }

    public static SougouSearchInfo a(List<subcmd0x533$HttpMapItem> list) {
        SougouSearchInfo sougouSearchInfo = new SougouSearchInfo();
        for (subcmd0x533$HttpMapItem subcmd0x533_httpmapitem : list) {
            String str = subcmd0x533_httpmapitem.string_key.get();
            String str2 = subcmd0x533_httpmapitem.string_value.get();
            if (str.equalsIgnoreCase("title")) {
                sougouSearchInfo.title = str2;
                sougouSearchInfo.titleKeyWords = subcmd0x533_httpmapitem.rpt_string_key_list.get();
            } else if (str.equalsIgnoreCase("summary")) {
                sougouSearchInfo.abstractStr = str2;
                sougouSearchInfo.abstractStrKeyWords = subcmd0x533_httpmapitem.rpt_string_key_list.get();
            } else if (str.equalsIgnoreCase("url")) {
                sougouSearchInfo.jumpURL = str2;
            } else if (str.equalsIgnoreCase("key")) {
                sougouSearchInfo.keyWord = str2;
            } else if (str.equalsIgnoreCase("category")) {
                sougouSearchInfo.sourceFrom = str2;
            } else if (str.equalsIgnoreCase("stype")) {
                sougouSearchInfo.stype = str2;
            } else if (str.equalsIgnoreCase("summaryPic")) {
                sougouSearchInfo.summaryPic = str2;
            }
        }
        return sougouSearchInfo;
    }
}
