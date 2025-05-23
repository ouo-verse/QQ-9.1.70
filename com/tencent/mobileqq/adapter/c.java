package com.tencent.mobileqq.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.avatar.api.IQQAvatarService;
import com.tencent.mobileqq.avatar.listener.DecodeTaskCompletionListener;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.widget.AbsListView;
import com.tencent.widget.ExpandableListView;
import com.tencent.widget.PinnedHeaderExpandableListView;

/* compiled from: P */
/* loaded from: classes10.dex */
public abstract class c extends PinnedHeaderExpandableListView.ExpandableListAdapter implements AbsListView.OnScrollListener, DecodeTaskCompletionListener {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private final Context f187151d;

    /* renamed from: e, reason: collision with root package name */
    private final QQAppInterface f187152e;

    /* renamed from: f, reason: collision with root package name */
    protected ExpandableListView f187153f;

    /* renamed from: h, reason: collision with root package name */
    private IFaceDecoder f187154h;

    public c(Context context, QQAppInterface qQAppInterface, ExpandableListView expandableListView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, context, qQAppInterface, expandableListView);
            return;
        }
        this.f187154h = null;
        this.f187151d = context;
        this.f187152e = qQAppInterface;
        this.f187153f = expandableListView;
        IFaceDecoder iQQAvatarService = ((IQQAvatarService) qQAppInterface.getRuntimeService(IQQAvatarService.class, "")).getInstance(qQAppInterface);
        this.f187154h = iQQAvatarService;
        iQQAvatarService.setDecodeTaskCompletionListener(this);
        BaseImageUtil.getDefaultFaceBitmap();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(String str, Bitmap bitmap) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) str, (Object) bitmap);
            return;
        }
        int childCount = this.f187153f.getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            Object tag = this.f187153f.getChildAt(i3).getTag();
            if (tag != null && (tag instanceof k)) {
                k kVar = (k) tag;
                if (str == null) {
                    d(kVar, null, false);
                } else if (str.equals(kVar.f187210d)) {
                    kVar.f187212f.setBackgroundDrawable(new BitmapDrawable(this.f187151d.getResources(), bitmap));
                    return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c(k kVar, Bitmap bitmap) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, (Object) kVar, (Object) bitmap);
        } else {
            d(kVar, bitmap, true);
        }
    }

    protected void d(k kVar, Bitmap bitmap, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, this, kVar, bitmap, Boolean.valueOf(z16));
            return;
        }
        if (kVar.f187212f == null) {
            return;
        }
        if (AppConstants.DATALINE_PC_UIN.equals(kVar.f187210d)) {
            kVar.f187212f.setBackgroundResource(R.drawable.qfile_dataline_pc_recent);
            return;
        }
        if (AppConstants.DATALINE_PHONE_UIN.equals(kVar.f187210d)) {
            kVar.f187212f.setBackgroundResource(R.drawable.qfile_dataline_user_aio);
            return;
        }
        if (AppConstants.DATALINE_IPAD_UIN.equals(kVar.f187210d)) {
            kVar.f187212f.setBackgroundResource(R.drawable.qfile_dataline_ipad_recent);
            return;
        }
        if (AppConstants.DATALINE_PRINTER_UIN.equals(kVar.f187210d)) {
            kVar.f187212f.setBackgroundResource(R.drawable.qfile_dataline_printer_recent);
            return;
        }
        if (AppConstants.SMARTDEVICE_SEARCH_UIN.equals(kVar.f187210d)) {
            kVar.f187212f.setBackgroundResource(R.drawable.device_search_icon);
            return;
        }
        if (bitmap == null) {
            bitmap = this.f187154h.getBitmapFromCache(kVar.f187211e, kVar.f187210d);
        }
        if (bitmap == null) {
            if (z16) {
                bitmap = BaseImageUtil.getDefaultFaceBitmap();
            }
            if (!this.f187154h.isPausing()) {
                this.f187154h.requestDecodeFace(kVar.f187210d, kVar.f187211e, false);
            }
        }
        if (bitmap != null) {
            kVar.f187212f.setBackgroundDrawable(new BitmapDrawable(this.f187151d.getResources(), bitmap));
        }
    }

    public void destroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this);
            return;
        }
        IFaceDecoder iFaceDecoder = this.f187154h;
        if (iFaceDecoder != null) {
            iFaceDecoder.destory();
        }
    }

    @Override // com.tencent.mobileqq.avatar.listener.DecodeTaskCompletionListener
    public void onDecodeTaskCompleted(int i3, int i16, String str, Bitmap bitmap) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, this, Integer.valueOf(i3), Integer.valueOf(i16), str, bitmap);
        } else if (!this.f187154h.isPausing() && bitmap != null) {
            b(str, bitmap);
        }
    }

    @Override // com.tencent.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i3, int i16, int i17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, this, absListView, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
        }
    }

    @Override // com.tencent.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, (Object) absListView, i3);
            return;
        }
        if (i3 != 0) {
            this.f187154h.cancelPendingRequests();
            this.f187154h.pause();
        } else if (this.f187154h.isPausing()) {
            this.f187154h.cancelPendingRequests();
            this.f187154h.resume();
            b(null, null);
        }
    }
}
