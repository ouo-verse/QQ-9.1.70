package com.tencent.mobileqq.troop.navigatebar;

import android.support.annotation.Nullable;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.data.BaseMessageNavigateInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.Comparator;
import java.util.List;
import java.util.Observable;
import mqq.manager.Manager;

/* compiled from: P */
/* loaded from: classes19.dex */
public abstract class b extends Observable implements Manager {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    protected AppInterface f297981d;

    /* compiled from: P */
    /* loaded from: classes19.dex */
    protected static class a implements Comparator<BaseMessageNavigateInfo> {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        boolean f297982d;

        public a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            } else {
                this.f297982d = com.tencent.mobileqq.troop.navigatebar.expriment.a.c();
            }
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(BaseMessageNavigateInfo baseMessageNavigateInfo, BaseMessageNavigateInfo baseMessageNavigateInfo2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this, (Object) baseMessageNavigateInfo, (Object) baseMessageNavigateInfo2)).intValue();
            }
            if (baseMessageNavigateInfo.shmsgseq == baseMessageNavigateInfo2.shmsgseq) {
                return 0;
            }
            int i3 = baseMessageNavigateInfo.type;
            if (i3 != baseMessageNavigateInfo2.type && (!b(i3) || !b(baseMessageNavigateInfo2.type))) {
                return -b.a(baseMessageNavigateInfo.type, baseMessageNavigateInfo2.type);
            }
            long j3 = baseMessageNavigateInfo.shmsgseq;
            long j16 = baseMessageNavigateInfo2.shmsgseq;
            if (j3 > j16) {
                return -1;
            }
            if (j3 >= j16) {
                return 0;
            }
            return 1;
        }

        boolean b(int i3) {
            if (!this.f297982d && !h.b(i3)) {
                return false;
            }
            return true;
        }
    }

    public b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this);
    }

    public static int a(int i3, int i16) {
        return NavConstants.a(i3) - NavConstants.a(i16);
    }

    public synchronized void b(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) str, i3);
        }
    }

    public synchronized List<Long> c(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (List) iPatchRedirector.redirect((short) 6, (Object) this, (Object) str, i3);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void d(@Nullable BaseMessageNavigateInfo baseMessageNavigateInfo, BaseMessageNavigateInfo baseMessageNavigateInfo2, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, baseMessageNavigateInfo, baseMessageNavigateInfo2, Integer.valueOf(i3));
            return;
        }
        if (h.a(i3)) {
            baseMessageNavigateInfo2.status = BaseMessageNavigateInfo.STATUS_ADD;
        } else if (baseMessageNavigateInfo != null && baseMessageNavigateInfo.status != BaseMessageNavigateInfo.STATUS_DELETE) {
            baseMessageNavigateInfo2.status = BaseMessageNavigateInfo.STATUS_MODIFY;
        } else {
            baseMessageNavigateInfo2.status = BaseMessageNavigateInfo.STATUS_ADD;
        }
    }

    public b(AppInterface appInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            this.f297981d = appInterface;
        } else {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) appInterface);
        }
    }
}
