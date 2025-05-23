package f60;

import android.app.Activity;
import com.tencent.biz.qqcircle.immersive.manager.e;
import com.tencent.biz.qqcircle.immersive.tab.QFSFolderTabFragment;
import com.tencent.biz.qqcircle.immersive.utils.bk;
import com.tencent.biz.qqcircle.immersive.views.h;
import com.tencent.biz.richframework.order.IOrderElement;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes4.dex */
public class a implements IOrderElement {

    /* renamed from: d, reason: collision with root package name */
    private int f397885d;

    /* renamed from: e, reason: collision with root package name */
    private String f397886e = "QFSMainTabRedPointOrderElement";

    /* renamed from: f, reason: collision with root package name */
    private final QFSFolderTabFragment f397887f;

    /* renamed from: h, reason: collision with root package name */
    private final h f397888h;

    public a(h hVar, QFSFolderTabFragment qFSFolderTabFragment) {
        this.f397885d = 200;
        this.f397887f = qFSFolderTabFragment;
        this.f397888h = hVar;
        if (qFSFolderTabFragment != null) {
            this.f397886e += "-" + qFSFolderTabFragment.getTAG();
            int Dh = qFSFolderTabFragment.Dh();
            this.f397885d = Dh;
            if (Dh != 200) {
                e.a().addElement(this);
            }
        }
    }

    private boolean b() {
        QFSFolderTabFragment qFSFolderTabFragment = this.f397887f;
        if (qFSFolderTabFragment == null || qFSFolderTabFragment.Eh() == null) {
            return false;
        }
        return qFSFolderTabFragment.Kh();
    }

    private boolean c() {
        QFSFolderTabFragment qFSFolderTabFragment = this.f397887f;
        if (qFSFolderTabFragment == null || qFSFolderTabFragment.Eh() == null) {
            return false;
        }
        qFSFolderTabFragment.rh();
        return qFSFolderTabFragment.Mh();
    }

    private void e() {
        if (this.f397888h == null) {
            QLog.e(this.f397886e, 1, "hideRedPointInfo tabView is null");
            return;
        }
        QLog.d(this.f397886e, 1, "realHide");
        this.f397888h.e();
        this.f397888h.c();
    }

    private void f() {
        if (this.f397888h == null) {
            QLog.e(this.f397886e, 1, "realShow tabView is null");
            return;
        }
        if (c()) {
            QLog.d(this.f397886e, 1, "realShow redPoint");
            this.f397888h.m();
        }
        if (b()) {
            QLog.d(this.f397886e, 1, "realShow new tips");
            this.f397888h.k();
        }
    }

    public boolean a() {
        if (this.f397885d != 200) {
            return true;
        }
        return false;
    }

    public void d() {
        QLog.d(this.f397886e, 1, "hideRedPointInfo");
        if (a()) {
            e.a().inactivateElement(this);
        } else {
            e();
        }
    }

    public void g() {
        if (a()) {
            e.a().notifyGroupActivate(this);
        } else {
            f();
        }
    }

    @Override // com.tencent.biz.richframework.order.IOrderElement
    public String getContextHashCode() {
        Activity b16;
        h hVar = this.f397888h;
        if (hVar == null || (b16 = bk.b(hVar.a())) == null) {
            return "";
        }
        return String.valueOf(b16.hashCode());
    }

    @Override // com.tencent.biz.richframework.order.IOrderElement
    public /* synthetic */ String getElementExtraKey() {
        return com.tencent.biz.richframework.order.a.a(this);
    }

    @Override // com.tencent.biz.richframework.order.IOrderElement
    public String getGroup() {
        return "folder_tab";
    }

    @Override // com.tencent.biz.richframework.order.IOrderElement
    public /* synthetic */ String getGroupExtraKey() {
        return com.tencent.biz.richframework.order.a.b(this);
    }

    @Override // com.tencent.biz.richframework.order.IOrderElement
    public int getPriority() {
        return this.f397885d;
    }

    @Override // com.tencent.biz.richframework.order.IOrderElement
    public /* synthetic */ boolean isDataReady() {
        return com.tencent.biz.richframework.order.a.c(this);
    }

    @Override // com.tencent.biz.richframework.order.IOrderElement
    public boolean isElementCanActivate() {
        if (!c() && !b()) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.biz.richframework.order.IOrderElement
    public void onElementActivated() {
        f();
    }

    @Override // com.tencent.biz.richframework.order.IOrderElement
    public void onElementInactivated() {
        e();
    }
}
