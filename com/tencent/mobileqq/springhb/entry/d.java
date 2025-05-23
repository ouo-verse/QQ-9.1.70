package com.tencent.mobileqq.springhb.entry;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.springhb.entry.model.BaseActivityData;
import com.tencent.mobileqq.springhb.entry.model.MsgTabBannerData;
import com.tencent.mobileqq.utils.en;

/* compiled from: P */
/* loaded from: classes18.dex */
public class d {
    static IPatchRedirector $redirector_;

    /* compiled from: P */
    /* loaded from: classes18.dex */
    public static class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public int f289083a;

        /* renamed from: b, reason: collision with root package name */
        public long f289084b;

        /* renamed from: c, reason: collision with root package name */
        public Object f289085c;

        public a(int i3, long j3, Object obj) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), Long.valueOf(j3), obj);
                return;
            }
            this.f289083a = i3;
            this.f289084b = j3;
            this.f289085c = obj;
        }

        public String a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (String) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            Object obj = this.f289085c;
            if (obj != null) {
                if (obj instanceof BaseActivityData) {
                    return ((BaseActivityData) obj).f289093id;
                }
                if (obj instanceof MsgTabBannerData) {
                    return ((MsgTabBannerData) obj).f289095id;
                }
                return "";
            }
            return "";
        }

        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (String) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            return "PartyTask{entryId=" + a() + ", type=" + d.b(this.f289083a) + ", time=" + en.i(this.f289084b) + '}';
        }
    }

    public static String a(int i3) {
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 != 3) {
                        if (i3 != 4) {
                            return "";
                        }
                        return "STATUS_BEYOND_PARTY";
                    }
                    return "STATUS_AFTER_PARTY";
                }
                return "STATUS_IN_PARTY";
            }
            return "STATUS_BEFORE_PARTY";
        }
        return "STATUS_BEFORE_CONFIG_READY";
    }

    public static String b(int i3) {
        if (i3 != 2001) {
            if (i3 != 2002) {
                if (i3 != 3001) {
                    if (i3 != 3002) {
                        if (i3 != 5001) {
                            if (i3 != 5002) {
                                switch (i3) {
                                    case 1001:
                                        return "TASK_TYPE_ACTIVITY_START";
                                    case 1002:
                                        return "TASK_TYPE_ACTIVITY_REAL_START";
                                    case 1003:
                                        return "TASK_TYPE_ACTIVITY_ABOUT_TO_OVER";
                                    case 1004:
                                        return "TASK_TYPE_ACTIVITY_OVER";
                                    default:
                                        switch (i3) {
                                            case 6001:
                                                return "TASK_TYPE_MAIN_PRE_START";
                                            case 6002:
                                                return "TASK_TYPE_MAIN_REAL_START";
                                            case 6003:
                                                return "TASK_TYPE_MAIN_OVER";
                                            default:
                                                return "";
                                        }
                                }
                            }
                            return "TASK_TYPE_MSGTABBANNER_HIDE";
                        }
                        return "TASK_TYPE_MSGTABBANNER_SHOW";
                    }
                    return "TASK_TYPE_BREATHLIGHT_HIDE";
                }
                return "TASK_TYPE_BREATHLIGHT_SHOW";
            }
            return "TASK_TYPE_PENDANT_HIDE";
        }
        return "TASK_TYPE_PENDANT_SHOW";
    }
}
