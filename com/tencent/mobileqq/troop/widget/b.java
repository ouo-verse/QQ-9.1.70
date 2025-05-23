package com.tencent.mobileqq.troop.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.avatar.api.IQQAvatarService;
import com.tencent.mobileqq.avatar.listener.DecodeTaskCompletionListener;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.widget.AbsListView;
import com.tencent.widget.ExpandableListView;
import com.tencent.widget.PinnedHeaderExpandableListView;

/* compiled from: P */
/* loaded from: classes19.dex */
public abstract class b extends PinnedHeaderExpandableListView.ExpandableListAdapter implements AbsListView.OnScrollListener, DecodeTaskCompletionListener {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private final Context f302504d;

    /* renamed from: e, reason: collision with root package name */
    private final AppInterface f302505e;

    /* renamed from: f, reason: collision with root package name */
    protected ExpandableListView f302506f;

    /* renamed from: h, reason: collision with root package name */
    private IFaceDecoder f302507h;

    public b(Context context, AppInterface appInterface, ExpandableListView expandableListView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, context, appInterface, expandableListView);
            return;
        }
        this.f302507h = null;
        this.f302504d = context;
        this.f302505e = appInterface;
        this.f302506f = expandableListView;
        IFaceDecoder iQQAvatarService = ((IQQAvatarService) appInterface.getRuntimeService(IQQAvatarService.class, "")).getInstance(appInterface);
        this.f302507h = iQQAvatarService;
        iQQAvatarService.setDecodeTaskCompletionListener(this);
        BaseImageUtil.getDefaultFaceBitmap();
    }

    protected void b(String str, Bitmap bitmap) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) str, (Object) bitmap);
            return;
        }
        int childCount = this.f302506f.getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            Object tag = this.f302506f.getChildAt(i3).getTag();
            if (tag != null && (tag instanceof com.tencent.mobileqq.adapter.k)) {
                com.tencent.mobileqq.adapter.k kVar = (com.tencent.mobileqq.adapter.k) tag;
                if (str == null) {
                    d(kVar, null, false);
                } else if (str.equals(kVar.f187210d)) {
                    kVar.f187212f.setBackgroundDrawable(new BitmapDrawable(this.f302504d.getResources(), bitmap));
                    return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c(com.tencent.mobileqq.adapter.k kVar, Bitmap bitmap) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, (Object) kVar, (Object) bitmap);
        } else {
            d(kVar, bitmap, true);
        }
    }

    protected void d(com.tencent.mobileqq.adapter.k kVar, Bitmap bitmap, boolean z16) {
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
            bitmap = this.f302507h.getBitmapFromCache(kVar.f187211e, kVar.f187210d);
        }
        if (bitmap == null) {
            if (z16) {
                bitmap = BaseImageUtil.getDefaultFaceBitmap();
            }
            if (!this.f302507h.isPausing()) {
                this.f302507h.requestDecodeFace(kVar.f187210d, kVar.f187211e, false);
            }
        }
        if (bitmap != null) {
            kVar.f187212f.setBackgroundDrawable(new BitmapDrawable(this.f302504d.getResources(), bitmap));
        }
    }

    @Override // com.tencent.mobileqq.avatar.listener.DecodeTaskCompletionListener
    public void onDecodeTaskCompleted(int i3, int i16, String str, Bitmap bitmap) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, this, Integer.valueOf(i3), Integer.valueOf(i16), str, bitmap);
        } else if (!this.f302507h.isPausing() && bitmap != null) {
            b(str, bitmap);
        }
    }

    public void onScroll(AbsListView absListView, int i3, int i16, int i17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, this, absListView, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
        }
    }

    public void onScrollStateChanged(AbsListView absListView, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, (Object) absListView, i3);
            return;
        }
        if (i3 != 0) {
            this.f302507h.cancelPendingRequests();
            this.f302507h.pause();
        } else if (this.f302507h.isPausing()) {
            this.f302507h.cancelPendingRequests();
            this.f302507h.resume();
            b(null, null);
        }
    }
}
