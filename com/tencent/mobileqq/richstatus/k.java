package com.tencent.mobileqq.richstatus;

import android.os.Bundle;
import androidx.annotation.Nullable;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.SignatureHandler;
import com.tencent.mobileqq.app.SignatureManager;
import com.tencent.mobileqq.app.da;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.vas.VasResEngine.VasResDrawable;
import com.tencent.mobileqq.vas.adapter.SignatureAdapter;
import com.tencent.mobileqq.vas.inject.ISignatureStatusManager;
import java.util.ArrayList;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes18.dex */
public class k implements ISignatureStatusManager {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public h f282362a;

    /* renamed from: b, reason: collision with root package name */
    public a f282363b;

    /* compiled from: P */
    /* loaded from: classes18.dex */
    class a extends da {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        public ISignatureStatusManager.ISignatureTopicObserver f282364d;

        public a(ISignatureStatusManager.ISignatureTopicObserver iSignatureTopicObserver) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) k.this, (Object) iSignatureTopicObserver);
            } else {
                this.f282364d = iSignatureTopicObserver;
            }
        }

        @Override // com.tencent.mobileqq.app.da
        protected void h(boolean z16, Object obj) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), obj);
                return;
            }
            if (this.f282364d == null) {
                return;
            }
            Bundle bundle = (Bundle) obj;
            int i3 = bundle.getInt("param_searchResult", 0);
            ArrayList arrayList = (ArrayList) bundle.getSerializable("param_topicInfoList");
            ArrayList arrayList2 = new ArrayList();
            for (int i16 = 0; i16 < arrayList.size(); i16++) {
                SignatureManager.TopicInfo topicInfo = (SignatureManager.TopicInfo) arrayList.get(i16);
                ISignatureStatusManager.TopicInfo topicInfo2 = new ISignatureStatusManager.TopicInfo();
                topicInfo2.topicId = topicInfo.topicId;
                topicInfo2.topicStr = topicInfo.topicStr;
                topicInfo2.friendNum = topicInfo.friendNum;
                topicInfo2.totalNum = topicInfo.totalNum;
                arrayList2.add(topicInfo2);
            }
            this.f282364d.onGetRecommendTopic(z16, i3, arrayList2);
        }
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    class b implements h {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public ISignatureStatusManager.ISignatureStatusListener f282366a;

        public b(ISignatureStatusManager.ISignatureStatusListener iSignatureStatusListener) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) k.this, (Object) iSignatureStatusListener);
            } else {
                this.f282366a = iSignatureStatusListener;
            }
        }

        @Override // com.tencent.mobileqq.richstatus.h
        public void onChangeStatus(int i3, RichStatus richStatus, Object obj) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), richStatus, obj);
                return;
            }
            ISignatureStatusManager.ISignatureStatusListener iSignatureStatusListener = this.f282366a;
            if (iSignatureStatusListener == null) {
                return;
            }
            iSignatureStatusListener.onChangeStatus(i3, richStatus, obj);
        }

        @Override // com.tencent.mobileqq.richstatus.h
        public void onGetSyncShuoShuo(int i3, boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, Integer.valueOf(i3), Boolean.valueOf(z16));
                return;
            }
            ISignatureStatusManager.ISignatureStatusListener iSignatureStatusListener = this.f282366a;
            if (iSignatureStatusListener == null) {
                return;
            }
            iSignatureStatusListener.onGetSyncShuoShuo(i3, z16);
        }

        @Override // com.tencent.mobileqq.richstatus.h
        public void onSetSyncShuoShuo(int i3, boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, this, Integer.valueOf(i3), Boolean.valueOf(z16));
                return;
            }
            ISignatureStatusManager.ISignatureStatusListener iSignatureStatusListener = this.f282366a;
            if (iSignatureStatusListener == null) {
                return;
            }
            iSignatureStatusListener.onSetSyncShuoShuo(i3, z16);
        }
    }

    public k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f282362a = null;
            this.f282363b = null;
        }
    }

    @Nullable
    private StatusManager a() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            return null;
        }
        return (StatusManager) peekAppRuntime.getManager(QQManagerFactory.STATUS_MANAGER);
    }

    @Override // com.tencent.mobileqq.vas.inject.ISignatureStatusManager
    public void addRequestRecommendTopicObserver(ISignatureStatusManager.ISignatureTopicObserver iSignatureTopicObserver) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) iSignatureTopicObserver);
            return;
        }
        if (iSignatureTopicObserver == null) {
            return;
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (!(peekAppRuntime instanceof AppInterface)) {
            return;
        }
        a aVar = new a(iSignatureTopicObserver);
        this.f282363b = aVar;
        ((AppInterface) peekAppRuntime).addObserver(aVar);
    }

    @Override // com.tencent.mobileqq.vas.inject.ISignatureStatusManager
    public void addSyncShuoShuoListener(ISignatureStatusManager.ISignatureStatusListener iSignatureStatusListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) iSignatureStatusListener);
        } else {
            if (iSignatureStatusListener == null) {
                return;
            }
            StatusManager a16 = a();
            b bVar = new b(iSignatureStatusListener);
            this.f282362a = bVar;
            a16.C(bVar);
        }
    }

    @Override // com.tencent.mobileqq.vas.inject.ISignatureStatusManager
    public boolean getSyncShuoShuo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        StatusManager a16 = a();
        if (a16 == null) {
            return false;
        }
        return a16.S();
    }

    @Override // com.tencent.mobileqq.vas.inject.ISignatureStatusManager
    public VasResDrawable getVasResDrawable(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (VasResDrawable) iPatchRedirector.redirect((short) 6, (Object) this, i3);
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            return null;
        }
        VasResDrawable vasResDrawable = new VasResDrawable(peekAppRuntime, i3);
        SignatureAdapter signatureAdapter = new SignatureAdapter(vasResDrawable, peekAppRuntime, R.drawable.hv8);
        signatureAdapter.h(true);
        vasResDrawable.setAdapter(signatureAdapter);
        return vasResDrawable;
    }

    @Override // com.tencent.mobileqq.vas.inject.ISignatureStatusManager
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        if (this.f282363b != null) {
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            if (peekAppRuntime instanceof AppInterface) {
                ((AppInterface) peekAppRuntime).removeObserver(this.f282363b);
            }
        }
        if (this.f282362a != null) {
            removeSyncShuoShuoListener();
        }
    }

    @Override // com.tencent.mobileqq.vas.inject.ISignatureStatusManager
    public void removeSyncShuoShuoListener() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        StatusManager a16 = a();
        h hVar = this.f282362a;
        if (hVar != null && a16 != null) {
            a16.b0(hVar);
            this.f282362a = null;
        }
    }

    @Override // com.tencent.mobileqq.vas.inject.ISignatureStatusManager
    public void requestRecommendTopicList() {
        SignatureHandler signatureHandler;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if ((peekAppRuntime instanceof AppInterface) && (signatureHandler = (SignatureHandler) ((AppInterface) peekAppRuntime).getBusinessHandler(BusinessHandlerFactory.SIGNATURE_HANDLER)) != null) {
            signatureHandler.N2();
        }
    }

    @Override // com.tencent.mobileqq.vas.inject.ISignatureStatusManager
    public int setSyncShuoShuo(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this, z16)).intValue();
        }
        StatusManager a16 = a();
        if (a16 == null) {
            return -1;
        }
        return a16.h0(z16);
    }
}
