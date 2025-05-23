package com.tencent.mobileqq.soload.api.impl;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.soload.biz.OnLoadListener;
import com.tencent.mobileqq.soload.biz.entity.LoadExtResult;
import com.tencent.mobileqq.soload.biz.entity.LoadParam;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes18.dex */
public class g implements f {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private LoadExtResult f288585a;

    /* renamed from: b, reason: collision with root package name */
    private r f288586b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class a implements OnLoadListener {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f288587a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ LoadParam f288588b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ OnLoadListener f288589c;

        a(int i3, LoadParam loadParam, OnLoadListener onLoadListener) {
            this.f288587a = i3;
            this.f288588b = loadParam;
            this.f288589c = onLoadListener;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, g.this, Integer.valueOf(i3), loadParam, onLoadListener);
            }
        }

        @Override // com.tencent.mobileqq.soload.biz.OnLoadListener
        public void onLoadResult(int i3, LoadExtResult loadExtResult) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, i3, (Object) loadExtResult);
                return;
            }
            LoadExtResult mergeExtResult = LoadExtResult.mergeExtResult(loadExtResult, g.this.f288585a);
            g.this.f288585a = mergeExtResult;
            if (i3 == 0) {
                if (this.f288587a < this.f288588b.mLoadItems.size() - 1) {
                    g.this.i(this.f288588b, this.f288589c, this.f288587a + 1);
                    return;
                }
                OnLoadListener onLoadListener = this.f288589c;
                if (onLoadListener != null) {
                    onLoadListener.onLoadResult(i3, mergeExtResult);
                    return;
                }
                return;
            }
            if (mergeExtResult != null) {
                mergeExtResult.setFailIndex(this.f288587a + 1);
            }
            if (this.f288589c != null) {
                if (mergeExtResult == null) {
                    mergeExtResult = new LoadExtResult();
                }
                this.f288589c.onLoadResult(i3, mergeExtResult);
            }
        }
    }

    public g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private LoadParam h(LoadParam loadParam, LoadParam.LoadItem loadItem) {
        LoadParam loadParam2 = new LoadParam();
        loadParam2.mLoadItems.add(loadItem);
        loadParam2.mReportSeq = loadParam.mReportSeq;
        loadParam2.mCallType = loadParam.mCallType;
        loadParam2.commonFlag = loadParam.commonFlag;
        return loadParam2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(LoadParam loadParam, OnLoadListener onLoadListener, int i3) {
        LoadParam h16 = h(loadParam, loadParam.mLoadItems.get(i3));
        r rVar = new r();
        this.f288586b = rVar;
        rVar.m(h16, new a(i3, loadParam, onLoadListener));
    }

    @Override // com.tencent.mobileqq.soload.api.impl.f
    public void a(LoadParam loadParam, OnLoadListener onLoadListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) loadParam, (Object) onLoadListener);
        } else {
            i(loadParam, onLoadListener, 0);
        }
    }

    @Override // com.tencent.mobileqq.soload.api.impl.f
    public void b(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) str);
            return;
        }
        r rVar = this.f288586b;
        if (rVar != null) {
            rVar.r(str);
        }
    }

    @Override // com.tencent.mobileqq.soload.api.impl.f
    public LoadExtResult c(LoadParam loadParam) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (LoadExtResult) iPatchRedirector.redirect((short) 5, (Object) this, (Object) loadParam);
        }
        Iterator<LoadParam.LoadItem> it = loadParam.mLoadItems.iterator();
        LoadExtResult loadExtResult = null;
        while (it.hasNext()) {
            LoadParam h16 = h(loadParam, it.next());
            r rVar = new r();
            this.f288586b = rVar;
            loadExtResult = LoadExtResult.mergeExtResult(rVar.q(h16), this.f288585a);
            this.f288585a = loadExtResult;
            if (loadExtResult.getResultCode() != 0) {
                break;
            }
        }
        return loadExtResult;
    }

    @Override // com.tencent.mobileqq.soload.api.impl.f
    public boolean d(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) str)).booleanValue();
        }
        r rVar = this.f288586b;
        if (rVar != null) {
            return rVar.j(str);
        }
        return false;
    }
}
