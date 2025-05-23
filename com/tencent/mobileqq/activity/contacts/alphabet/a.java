package com.tencent.mobileqq.activity.contacts.alphabet;

import android.content.Context;
import android.graphics.Bitmap;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.contacts.friend.BuddyListFriends;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.app.face.h;
import com.tencent.mobileqq.avatar.api.IQQAvatarService;
import com.tencent.mobileqq.avatar.listener.DecodeTaskCompletionListener;
import com.tencent.mobileqq.proavatar.e;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.mobileqq.vas.pendant.api.ISpecialShapeAvatarMaskLayer;
import com.tencent.mobileqq.widget.PinnedDividerListView;
import com.tencent.widget.AbsListView;
import com.tencent.widget.XListView;

/* compiled from: P */
/* loaded from: classes10.dex */
public abstract class a extends PinnedDividerListView.a implements AbsListView.OnScrollListener, DecodeTaskCompletionListener {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private final QQAppInterface f181448d;

    /* renamed from: e, reason: collision with root package name */
    protected XListView f181449e;

    /* renamed from: f, reason: collision with root package name */
    protected IFaceDecoder f181450f;

    /* renamed from: h, reason: collision with root package name */
    protected Context f181451h;

    /* renamed from: i, reason: collision with root package name */
    private int f181452i;

    public a(Context context, QQAppInterface qQAppInterface, XListView xListView, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, context, qQAppInterface, xListView, Boolean.valueOf(z16));
            return;
        }
        this.f181452i = 0;
        this.f181451h = context;
        this.f181448d = qQAppInterface;
        this.f181449e = xListView;
        if (xListView != null) {
            xListView.setOnScrollListener(this);
        }
        IFaceDecoder iQQAvatarService = ((IQQAvatarService) qQAppInterface.getRuntimeService(IQQAvatarService.class, "")).getInstance(qQAppInterface);
        this.f181450f = iQQAvatarService;
        iQQAvatarService.setDecodeTaskCompletionListener(this);
        BaseImageUtil.getDefaultFaceBitmap();
    }

    protected void b(String str, Bitmap bitmap) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) str, (Object) bitmap);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c(BuddyListFriends.a aVar, Bitmap bitmap) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) aVar, (Object) bitmap);
        } else {
            d(aVar, bitmap, true);
        }
    }

    protected void d(BuddyListFriends.a aVar, Bitmap bitmap, boolean z16) {
        e eVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z17 = false;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, aVar, bitmap, Boolean.valueOf(z16));
            return;
        }
        if (AppConstants.DATALINE_PC_UIN.equals(aVar.f187114d)) {
            aVar.f187116f.setImageResource(R.drawable.qfile_dataline_pc_recent);
            return;
        }
        if (AppConstants.DATALINE_PHONE_UIN.equals(aVar.f187114d)) {
            aVar.f187116f.setImageResource(R.drawable.qfile_dataline_user_aio);
            return;
        }
        if (AppConstants.DATALINE_IPAD_UIN.equals(aVar.f187114d)) {
            aVar.f187116f.setImageResource(R.drawable.qfile_dataline_ipad_recent);
            return;
        }
        if (AppConstants.DATALINE_PRINTER_UIN.equals(aVar.f187114d)) {
            aVar.f187116f.setImageResource(R.drawable.qfile_dataline_printer_recent);
            return;
        }
        if (AppConstants.SMARTDEVICE_SEARCH_UIN.equals(aVar.f187114d)) {
            aVar.f187116f.setImageResource(R.drawable.device_search_icon);
            return;
        }
        if (aVar.f187115e == 1) {
            z17 = aVar.N;
        }
        aVar.f187116f.setEnableMask(z17);
        if (aVar.f187115e == 1) {
            eVar = new e.a().e(!((ISpecialShapeAvatarMaskLayer) QRoute.api(ISpecialShapeAvatarMaskLayer.class)).isSpecialShapeAvatar(aVar.f187114d)).b(true).j(true).p(1).a();
        } else {
            eVar = null;
        }
        aVar.f187116f.x(aVar.f187115e, aVar.f187114d, eVar);
    }

    public void destroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
            return;
        }
        IFaceDecoder iFaceDecoder = this.f181450f;
        if (iFaceDecoder != null) {
            iFaceDecoder.destory();
        }
    }

    @Override // com.tencent.mobileqq.avatar.listener.DecodeTaskCompletionListener
    public void onDecodeTaskCompleted(int i3, int i16, String str, Bitmap bitmap) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, Integer.valueOf(i3), Integer.valueOf(i16), str, bitmap);
        } else if (!this.f181450f.isPausing() && bitmap != null) {
            b(str, bitmap);
        }
    }

    @Override // com.tencent.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i3, int i16, int i17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, absListView, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
        }
    }

    public void onScrollStateChanged(AbsListView absListView, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) absListView, i3);
            return;
        }
        this.f181452i = i3;
        if (i3 != 0) {
            this.f181450f.cancelPendingRequests();
            this.f181450f.pause();
            h.h(this.f181448d);
        } else {
            if (this.f181450f.isPausing()) {
                this.f181450f.cancelPendingRequests();
                this.f181450f.resume();
                b(null, null);
            }
            h.i(this.f181448d);
        }
    }
}
