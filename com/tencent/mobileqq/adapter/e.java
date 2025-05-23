package com.tencent.mobileqq.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.avatar.api.IQQAvatarService;
import com.tencent.mobileqq.avatar.listener.DecodeTaskCompletionListener;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.mobileqq.widget.PinnedDividerListView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AbsListView;
import com.tencent.widget.XListView;
import java.util.Hashtable;

/* compiled from: P */
/* loaded from: classes10.dex */
public abstract class e extends PinnedDividerListView.a implements AbsListView.OnScrollListener, DecodeTaskCompletionListener {
    static IPatchRedirector $redirector_;
    private Hashtable<String, Bitmap> C;

    /* renamed from: d, reason: collision with root package name */
    protected Bitmap f187155d;

    /* renamed from: e, reason: collision with root package name */
    private XListView f187156e;

    /* renamed from: f, reason: collision with root package name */
    protected IFaceDecoder f187157f;

    /* renamed from: h, reason: collision with root package name */
    private boolean f187158h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f187159i;

    /* renamed from: m, reason: collision with root package name */
    private int f187160m;

    public e(Context context, AppInterface appInterface, XListView xListView, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, context, appInterface, xListView, Boolean.valueOf(z16));
            return;
        }
        this.f187155d = null;
        this.f187160m = 0;
        this.C = new Hashtable<>();
        this.f187156e = xListView;
        if (xListView != null) {
            xListView.setOnScrollListener(this);
        }
        this.f187159i = z16;
        IFaceDecoder iQQAvatarService = ((IQQAvatarService) appInterface.getRuntimeService(IQQAvatarService.class, "")).getInstance(appInterface);
        this.f187157f = iQQAvatarService;
        iQQAvatarService.setDecodeTaskCompletionListener(this);
        if (this.f187155d == null) {
            this.f187155d = BaseImageUtil.getDefaultFaceBitmap();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Bitmap b(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (Bitmap) iPatchRedirector.redirect((short) 10, (Object) this, (Object) str);
        }
        return d(str, 1, (byte) 0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Bitmap c(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (Bitmap) iPatchRedirector.redirect((short) 11, (Object) this, (Object) str, i3);
        }
        return e(str, 1, (byte) 0, i3);
    }

    public Bitmap d(String str, int i3, byte b16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (Bitmap) iPatchRedirector.redirect((short) 12, this, str, Integer.valueOf(i3), Byte.valueOf(b16));
        }
        return e(str, i3, b16, 0);
    }

    public void destroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        IFaceDecoder iFaceDecoder = this.f187157f;
        if (iFaceDecoder != null) {
            iFaceDecoder.destory();
        }
        this.f187156e = null;
    }

    public Bitmap e(String str, int i3, byte b16, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (Bitmap) iPatchRedirector.redirect((short) 13, this, str, Integer.valueOf(i3), Byte.valueOf(b16), Integer.valueOf(i16));
        }
        Bitmap bitmapFromCacheFrom = this.f187157f.getBitmapFromCacheFrom(i3, str, i16);
        if (bitmapFromCacheFrom != null) {
            return bitmapFromCacheFrom;
        }
        if (this.f187158h) {
            this.f187157f.cancelPendingRequests();
            this.f187158h = false;
        }
        if (!this.f187157f.isPausing()) {
            this.f187157f.requestDecodeFace(str, i3, true, b16);
        }
        return this.f187155d;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean f(k kVar) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Boolean) iPatchRedirector.redirect((short) 14, (Object) this, (Object) kVar)).booleanValue();
        }
        if (kVar != null && (str = kVar.f187210d) != null && str.length() > 0) {
            return true;
        }
        return false;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return iPatchRedirector.redirect((short) 3, (Object) this, i3);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Long) iPatchRedirector.redirect((short) 4, (Object) this, i3)).longValue();
        }
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i3, View view, ViewGroup viewGroup) {
        View view2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            view2 = (View) iPatchRedirector.redirect((short) 5, this, Integer.valueOf(i3), view, viewGroup);
        } else {
            view2 = null;
        }
        EventCollector.getInstance().onListGetView(i3, view, viewGroup, getItemId(i3));
        return view2;
    }

    public void onDecodeTaskCompleted(int i3, int i16, String str, Bitmap bitmap) {
        XListView xListView;
        Bitmap bitmap2;
        ImageView imageView;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, Integer.valueOf(i3), Integer.valueOf(i16), str, bitmap);
            return;
        }
        if (this.f187158h) {
            if (i3 == 0) {
                this.f187158h = false;
                return;
            }
            return;
        }
        if (bitmap != null) {
            this.C.put(str, bitmap);
        }
        if (i3 <= 0) {
            if (this.f187160m == 0 && (xListView = this.f187156e) != null) {
                int childCount = xListView.getChildCount();
                for (int i17 = 0; i17 < childCount; i17++) {
                    Object tag = this.f187156e.getChildAt(i17).getTag();
                    if (tag != null && (tag instanceof k)) {
                        k kVar = (k) tag;
                        if (f(kVar) && kVar.f187212f != null && (bitmap2 = this.C.get(kVar.f187210d)) != null && (imageView = kVar.f187212f) != null) {
                            imageView.setImageBitmap(bitmap2);
                        }
                    }
                }
            }
            this.C.clear();
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
        ImageView imageView;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) absListView, i3);
            return;
        }
        this.f187160m = i3;
        if (i3 != 0) {
            this.f187158h = false;
            this.f187157f.cancelPendingRequests();
            this.f187157f.pause();
            return;
        }
        if (this.f187157f.isPausing()) {
            this.f187157f.resume();
        }
        XListView xListView = this.f187156e;
        if (xListView != null) {
            int childCount = xListView.getChildCount();
            for (int i16 = 0; i16 < childCount; i16++) {
                k kVar = (k) this.f187156e.getChildAt(i16).getTag();
                if (f(kVar) && (imageView = kVar.f187212f) != null) {
                    imageView.setImageBitmap(d(kVar.f187210d, kVar.f187211e, (byte) 0));
                }
            }
        }
    }
}
