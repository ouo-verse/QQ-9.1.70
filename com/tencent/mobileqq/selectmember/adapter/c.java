package com.tencent.mobileqq.selectmember.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.avatar.api.IQQAvatarService;
import com.tencent.mobileqq.avatar.listener.DecodeTaskCompletionListener;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.widget.AbsListView;
import com.tencent.widget.ListView;
import com.tencent.widget.SwipRightMenuBuilder;
import java.util.Hashtable;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes18.dex */
public abstract class c extends BaseAdapter implements AbsListView.OnScrollListener, DecodeTaskCompletionListener {
    static IPatchRedirector $redirector_;
    private boolean C;
    private Hashtable<String, Bitmap> D;

    /* renamed from: d, reason: collision with root package name */
    private ListView f285942d;

    /* renamed from: e, reason: collision with root package name */
    protected IFaceDecoder f285943e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f285944f;

    /* renamed from: h, reason: collision with root package name */
    private AbsListView.OnScrollListener f285945h;

    /* renamed from: i, reason: collision with root package name */
    private int f285946i;

    /* renamed from: m, reason: collision with root package name */
    private int f285947m;

    /* compiled from: P */
    /* loaded from: classes18.dex */
    public static class a extends SwipRightMenuBuilder.SwipItemBaseHolder {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        public String f285948d;

        /* renamed from: e, reason: collision with root package name */
        public int f285949e;

        /* renamed from: f, reason: collision with root package name */
        public ImageView f285950f;

        public a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            } else {
                this.f285949e = 1;
            }
        }
    }

    public c(Context context, AppInterface appInterface, ListView listView, int i3, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, context, appInterface, listView, Integer.valueOf(i3), Boolean.valueOf(z16));
            return;
        }
        this.f285946i = 0;
        this.D = new Hashtable<>();
        this.f285942d = listView;
        this.f285947m = i3;
        this.C = z16;
        listView.setOnScrollListener(this);
        IFaceDecoder iQQAvatarService = ((IQQAvatarService) appInterface.getRuntimeService(IQQAvatarService.class, "")).getInstance(appInterface);
        this.f285943e = iQQAvatarService;
        iQQAvatarService.setDecodeTaskCompletionListener(this);
    }

    public void a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this);
            return;
        }
        ListView listView = this.f285942d;
        if (listView != null && listView.getOnScrollListener() == this) {
            this.f285942d.setOnScrollListener(null);
        }
        IFaceDecoder iFaceDecoder = this.f285943e;
        if (iFaceDecoder != null) {
            iFaceDecoder.destory();
        }
        this.f285942d = null;
    }

    protected Bitmap b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (Bitmap) iPatchRedirector.redirect((short) 13, (Object) this);
        }
        return BaseImageUtil.getDefaultFaceBitmap();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Bitmap c(int i3, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (Bitmap) iPatchRedirector.redirect((short) 11, (Object) this, i3, (Object) str);
        }
        if (AppConstants.SEC_MSG_UIN.equals(str)) {
            try {
                return BitmapFactory.decodeResource(MobileQQ.sMobileQQ.getResources(), R.drawable.f162141ft4);
            } catch (OutOfMemoryError unused) {
                return null;
            }
        }
        return d(str, i3, (byte) 0);
    }

    protected Bitmap d(String str, int i3, byte b16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (Bitmap) iPatchRedirector.redirect((short) 12, this, str, Integer.valueOf(i3), Byte.valueOf(b16));
        }
        Bitmap bitmapFromCache = this.f285943e.getBitmapFromCache(i3, str);
        if (bitmapFromCache != null) {
            return bitmapFromCache;
        }
        if (this.f285944f) {
            this.f285943e.cancelPendingRequests();
            this.f285944f = false;
        }
        if (!this.f285943e.isPausing()) {
            this.f285943e.requestDecodeFace(str, i3, true, b16);
        }
        return b();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void e(String str, Bitmap bitmap) {
        ListView listView;
        String str2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) str, (Object) bitmap);
            return;
        }
        if (this.f285946i == 0 && (listView = this.f285942d) != null) {
            int childCount = listView.getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                a aVar = (a) this.f285942d.getChildAt(i3).getTag();
                if (aVar != null && (str2 = aVar.f285948d) != null && str2.length() > 0 && aVar.f285948d.equals(str)) {
                    aVar.f285950f.setImageBitmap(bitmap);
                    return;
                }
            }
        }
    }

    @Override // com.tencent.mobileqq.avatar.listener.DecodeTaskCompletionListener
    public void onDecodeTaskCompleted(int i3, int i16, String str, Bitmap bitmap) {
        a aVar;
        String str2;
        Bitmap bitmap2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, Integer.valueOf(i3), Integer.valueOf(i16), str, bitmap);
            return;
        }
        if (this.f285944f) {
            if (i3 == 0) {
                this.f285944f = false;
                return;
            }
            return;
        }
        if (!this.f285943e.isPausing()) {
            if (bitmap != null) {
                this.D.put(str, bitmap);
            }
            if (i3 <= 0) {
                int i17 = this.f285946i;
                if (i17 == 0 || i17 == 1) {
                    int childCount = this.f285942d.getChildCount();
                    for (int i18 = 0; i18 < childCount; i18++) {
                        Object tag = this.f285942d.getChildAt(i18).getTag();
                        if (tag != null && (tag instanceof a) && (str2 = (aVar = (a) tag).f285948d) != null && str2.length() > 0 && (bitmap2 = this.D.get(aVar.f285948d)) != null) {
                            aVar.f285950f.setImageBitmap(bitmap2);
                        }
                    }
                }
                this.D.clear();
            }
        }
    }

    @Override // com.tencent.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i3, int i16, int i17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, absListView, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
            return;
        }
        AbsListView.OnScrollListener onScrollListener = this.f285945h;
        if (onScrollListener != null) {
            onScrollListener.onScroll(absListView, i3, i16, i17);
        }
    }

    @Override // com.tencent.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i3) {
        a aVar;
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) absListView, i3);
            return;
        }
        this.f285946i = i3;
        if (i3 != 0 && i3 != 1) {
            this.f285944f = false;
            this.f285943e.cancelPendingRequests();
            this.f285943e.pause();
        } else {
            if (this.f285943e.isPausing()) {
                this.f285943e.resume();
            }
            ListView listView = this.f285942d;
            if (listView != null) {
                int childCount = listView.getChildCount();
                for (int i16 = 0; i16 < childCount; i16++) {
                    Object tag = this.f285942d.getChildAt(i16).getTag();
                    if (tag != null && (tag instanceof a) && (str = (aVar = (a) tag).f285948d) != null && str.length() > 0) {
                        aVar.f285950f.setImageBitmap(c(aVar.f285949e, aVar.f285948d));
                    }
                }
            }
        }
        AbsListView.OnScrollListener onScrollListener = this.f285945h;
        if (onScrollListener != null) {
            onScrollListener.onScrollStateChanged(absListView, i3);
        }
    }
}
