package com.tencent.upload.network.route;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.upload.utils.Const;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes27.dex */
public class DebugRouteStrategy implements IUploadRouteStrategy {
    static IPatchRedirector $redirector_;
    private UploadRoute mDebugUploadRoute;

    public DebugRouteStrategy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.mDebugUploadRoute = RouteFactory.getDebugRoute();
        }
    }

    @Override // com.tencent.upload.network.route.IUploadRouteStrategy
    public ServerRouteTable getServerRouteTable() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (ServerRouteTable) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return new ServerRouteTable(Const.FileType.Photo, Const.BusinessType.DefaultPhoto, Const.ConnectType.Epoll, null) { // from class: com.tencent.upload.network.route.DebugRouteStrategy.1
            static IPatchRedirector $redirector_;

            {
                super(r6, r7, r8, r9);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, DebugRouteStrategy.this, r6, r7, r8, r9);
                }
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // com.tencent.upload.network.route.ServerRouteTable
            public List<UploadRoute> getUploadRoutes() {
                ArrayList arrayList = new ArrayList();
                arrayList.add(DebugRouteStrategy.this.mDebugUploadRoute);
                return arrayList;
            }
        };
    }

    @Override // com.tencent.upload.network.route.IUploadRouteStrategy
    public boolean isApnChanged() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this)).booleanValue();
        }
        return false;
    }

    @Override // com.tencent.upload.network.route.IUploadRouteStrategy
    public boolean isApnChangedForNext() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this)).booleanValue();
        }
        return false;
    }

    @Override // com.tencent.upload.network.route.IUploadRouteStrategy
    public UploadRoute next(UploadRoute uploadRoute, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (UploadRoute) iPatchRedirector.redirect((short) 4, (Object) this, (Object) uploadRoute, i3);
        }
        return null;
    }

    @Override // com.tencent.upload.network.route.IUploadRouteStrategy
    public UploadRoute reset() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (UploadRoute) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.mDebugUploadRoute;
    }

    @Override // com.tencent.upload.network.route.IUploadRouteStrategy
    public boolean save(UploadRoute uploadRoute) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this, (Object) uploadRoute)).booleanValue();
        }
        return false;
    }
}
