package com.tencent.mobileqq.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.avatar.api.IQQAvatarService;
import com.tencent.mobileqq.avatar.listener.DecodeTaskCompletionListener;
import com.tencent.mobileqq.proavatar.QQProAvatarView;
import com.tencent.mobileqq.proavatar.e;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.mobileqq.vas.pendant.api.ISpecialShapeAvatarMaskLayer;
import com.tencent.widget.AbsListView;
import com.tencent.widget.ExpandableListView;
import com.tencent.widget.PinnedHeaderExpandableListView;
import com.tencent.widget.SwipRightMenuBuilder;

/* compiled from: P */
/* loaded from: classes10.dex */
public abstract class ai extends PinnedHeaderExpandableListView.ExpandableListAdapter implements AbsListView.OnScrollListener, DecodeTaskCompletionListener {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private final Context f187110d;

    /* renamed from: e, reason: collision with root package name */
    protected final QQAppInterface f187111e;

    /* renamed from: f, reason: collision with root package name */
    protected ExpandableListView f187112f;

    /* renamed from: h, reason: collision with root package name */
    private IFaceDecoder f187113h;

    /* compiled from: P */
    /* loaded from: classes10.dex */
    public static class a extends SwipRightMenuBuilder.SwipItemBaseHolder {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        public String f187114d;

        /* renamed from: e, reason: collision with root package name */
        public int f187115e;

        /* renamed from: f, reason: collision with root package name */
        public QQProAvatarView f187116f;

        public a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            } else {
                this.f187115e = 1;
            }
        }
    }

    public ai(Context context, QQAppInterface qQAppInterface, ExpandableListView expandableListView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, context, qQAppInterface, expandableListView);
            return;
        }
        this.f187113h = null;
        this.f187110d = context;
        this.f187111e = qQAppInterface;
        this.f187112f = expandableListView;
        IFaceDecoder iQQAvatarService = ((IQQAvatarService) qQAppInterface.getRuntimeService(IQQAvatarService.class, "")).getInstance(qQAppInterface);
        this.f187113h = iQQAvatarService;
        iQQAvatarService.setDecodeTaskCompletionListener(this);
        BaseImageUtil.getDefaultFaceBitmap();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(String str, Bitmap bitmap) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) str, (Object) bitmap);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c(a aVar, Bitmap bitmap) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) aVar, (Object) bitmap);
        } else {
            d(aVar, bitmap, true);
        }
    }

    protected void d(a aVar, Bitmap bitmap, boolean z16) {
        com.tencent.mobileqq.proavatar.e eVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, aVar, bitmap, Boolean.valueOf(z16));
            return;
        }
        if (aVar.f187116f == null) {
            return;
        }
        if (AppConstants.DATALINE_PC_UIN.equals(aVar.f187114d)) {
            aVar.f187116f.setImageResource(R.drawable.qfile_dataline_pc_recent);
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
        } else {
            if (TextUtils.isEmpty(aVar.f187114d)) {
                return;
            }
            if (aVar.f187115e == 1) {
                eVar = new e.a().e(!((ISpecialShapeAvatarMaskLayer) QRoute.api(ISpecialShapeAvatarMaskLayer.class)).isSpecialShapeAvatar(aVar.f187114d)).b(true).j(true).p(1).a();
            } else {
                eVar = null;
            }
            aVar.f187116f.x(aVar.f187115e, aVar.f187114d, eVar);
        }
    }

    public void destroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        IFaceDecoder iFaceDecoder = this.f187113h;
        if (iFaceDecoder != null) {
            iFaceDecoder.destory();
        }
    }

    @Override // com.tencent.mobileqq.avatar.listener.DecodeTaskCompletionListener
    public void onDecodeTaskCompleted(int i3, int i16, String str, Bitmap bitmap) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, Integer.valueOf(i3), Integer.valueOf(i16), str, bitmap);
        } else if (!this.f187113h.isPausing() && bitmap != null) {
            b(str, bitmap);
        }
    }

    public void onScroll(AbsListView absListView, int i3, int i16, int i17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, absListView, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
        }
    }

    public void onScrollStateChanged(AbsListView absListView, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) absListView, i3);
            return;
        }
        if (i3 != 0) {
            this.f187113h.cancelPendingRequests();
            this.f187113h.pause();
            com.tencent.mobileqq.app.face.h.h(this.f187111e);
        } else {
            if (this.f187113h.isPausing()) {
                this.f187113h.cancelPendingRequests();
                this.f187113h.resume();
                b(null, null);
            }
            com.tencent.mobileqq.app.face.h.i(this.f187111e);
        }
    }
}
