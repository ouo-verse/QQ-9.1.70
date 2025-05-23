package com.tencent.mobileqq.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.contact.addcontact.QzoneSearchResultView;
import com.tencent.mobileqq.activity.contacts.base.c;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.avatar.api.IQQAvatarService;
import com.tencent.mobileqq.avatar.listener.DecodeTaskCompletionListener;
import com.tencent.mobileqq.matchfriend.api.IMatchFriendFaceApi;
import com.tencent.mobileqq.proavatar.e;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.mobileqq.vas.pendant.api.ISpecialShapeAvatarMaskLayer;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AbsListView;
import com.tencent.widget.ListView;
import java.util.Hashtable;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes10.dex */
public abstract class j extends BaseAdapter implements AbsListView.OnScrollListener, DecodeTaskCompletionListener {
    static IPatchRedirector $redirector_;
    private int C;
    private boolean D;
    private Hashtable<String, Bitmap> E;

    /* renamed from: d, reason: collision with root package name */
    private final String f187204d;

    /* renamed from: e, reason: collision with root package name */
    private ListView f187205e;

    /* renamed from: f, reason: collision with root package name */
    protected IFaceDecoder f187206f;

    /* renamed from: h, reason: collision with root package name */
    private boolean f187207h;

    /* renamed from: i, reason: collision with root package name */
    private AbsListView.OnScrollListener f187208i;

    /* renamed from: m, reason: collision with root package name */
    private int f187209m;

    public j(Context context, AppInterface appInterface, ListView listView, int i3, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, context, appInterface, listView, Integer.valueOf(i3), Boolean.valueOf(z16));
            return;
        }
        this.f187204d = "FacePreloadBaseAdapter";
        this.f187209m = 0;
        this.E = new Hashtable<>();
        this.f187205e = listView;
        this.C = i3;
        this.D = z16;
        listView.setOnScrollListener(this);
        IFaceDecoder iQQAvatarService = ((IQQAvatarService) appInterface.getRuntimeService(IQQAvatarService.class, "")).getInstance(appInterface);
        this.f187206f = iQQAvatarService;
        iQQAvatarService.setDecodeTaskCompletionListener(this);
    }

    private void f(k kVar) {
        ImageView imageView;
        int i3 = kVar.f187211e;
        if (i3 == 117 || (imageView = kVar.f187212f) == null) {
            return;
        }
        if (i3 != 202) {
            imageView.setImageBitmap(c(i3, kVar.f187210d));
            return;
        }
        QQAppInterface qQAppInterface = (QQAppInterface) MobileQQ.sMobileQQ.peekAppRuntime();
        if (qQAppInterface == null) {
            return;
        }
        kVar.f187212f.setImageDrawable(((IMatchFriendFaceApi) QRoute.api(IMatchFriendFaceApi.class)).getMatchFriendFaceDrawable(qQAppInterface, Long.parseLong(kVar.f187210d)));
    }

    public void a(QQAppInterface qQAppInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) qQAppInterface);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i("FacePreloadBaseAdapter", 2, "checkResetApp, need change app!");
        }
        if (qQAppInterface == null) {
            QLog.w("FacePreloadBaseAdapter", 1, "[changeAppInterface] QQAppInterface is null. return");
            return;
        }
        IFaceDecoder iFaceDecoder = this.f187206f;
        if (iFaceDecoder != null) {
            iFaceDecoder.destory();
            IFaceDecoder iQQAvatarService = ((IQQAvatarService) qQAppInterface.getRuntimeService(IQQAvatarService.class, "")).getInstance(qQAppInterface);
            this.f187206f = iQQAvatarService;
            iQQAvatarService.setDecodeTaskCompletionListener(this);
        }
    }

    protected Bitmap b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (Bitmap) iPatchRedirector.redirect((short) 14, (Object) this);
        }
        return BaseImageUtil.getDefaultFaceBitmap();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Bitmap c(int i3, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (Bitmap) iPatchRedirector.redirect((short) 12, (Object) this, i3, (Object) str);
        }
        if (AppConstants.SEC_MSG_UIN.equals(str)) {
            try {
                return BitmapFactory.decodeResource(BaseApplicationImpl.getApplication().getResources(), R.drawable.f162141ft4);
            } catch (OutOfMemoryError unused) {
                return null;
            }
        }
        return d(str, i3, (byte) 0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Bitmap d(String str, int i3, byte b16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (Bitmap) iPatchRedirector.redirect((short) 13, this, str, Integer.valueOf(i3), Byte.valueOf(b16));
        }
        Bitmap bitmapFromCache = this.f187206f.getBitmapFromCache(i3, str);
        if (bitmapFromCache != null) {
            return bitmapFromCache;
        }
        if (this.f187207h) {
            this.f187206f.cancelPendingRequests();
            this.f187207h = false;
        }
        if (!this.f187206f.isPausing()) {
            this.f187206f.requestDecodeFace(str, i3, true, b16);
        }
        return b();
    }

    public void destroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this);
            return;
        }
        ListView listView = this.f187205e;
        if (listView != null && listView.getOnScrollListener() == this) {
            this.f187205e.setOnScrollListener(null);
        }
        IFaceDecoder iFaceDecoder = this.f187206f;
        if (iFaceDecoder != null) {
            iFaceDecoder.destory();
        }
        this.f187205e = null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void e(c.C7154c c7154c, Bitmap bitmap) {
        com.tencent.mobileqq.proavatar.e eVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) c7154c, (Object) bitmap);
            return;
        }
        if (c7154c.f187116f == null) {
            return;
        }
        if (AppConstants.DATALINE_PC_UIN.equals(c7154c.f187114d)) {
            c7154c.f187116f.setImageResource(R.drawable.qfile_dataline_pc_recent);
            return;
        }
        if (AppConstants.DATALINE_IPAD_UIN.equals(c7154c.f187114d)) {
            c7154c.f187116f.setImageResource(R.drawable.qfile_dataline_ipad_recent);
            return;
        }
        if (AppConstants.DATALINE_PHONE_UIN.equals(c7154c.f187114d)) {
            c7154c.f187116f.setImageResource(R.drawable.qfile_dataline_user_aio);
            return;
        }
        if (AppConstants.DATALINE_PRINTER_UIN.equals(c7154c.f187114d)) {
            c7154c.f187116f.setImageResource(R.drawable.qfile_dataline_printer_recent);
            return;
        }
        if (AppConstants.SMARTDEVICE_SEARCH_UIN.equals(c7154c.f187114d)) {
            c7154c.f187116f.setImageResource(R.drawable.device_search_icon);
            return;
        }
        if (c7154c.f187115e == 1) {
            eVar = new e.a().e(true ^ ((ISpecialShapeAvatarMaskLayer) QRoute.api(ISpecialShapeAvatarMaskLayer.class)).isSpecialShapeAvatar(c7154c.f187114d)).a();
        } else {
            eVar = null;
        }
        c7154c.f187116f.x(c7154c.f187115e, c7154c.f187114d, eVar);
    }

    public void g(AbsListView.OnScrollListener onScrollListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) onScrollListener);
        } else {
            this.f187208i = onScrollListener;
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return iPatchRedirector.redirect((short) 4, (Object) this, i3);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Long) iPatchRedirector.redirect((short) 5, (Object) this, i3)).longValue();
        }
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i3, View view, ViewGroup viewGroup) {
        View view2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            view2 = (View) iPatchRedirector.redirect((short) 6, this, Integer.valueOf(i3), view, viewGroup);
        } else {
            view2 = null;
        }
        EventCollector.getInstance().onListGetView(i3, view, viewGroup, getItemId(i3));
        return view2;
    }

    @Override // com.tencent.mobileqq.avatar.listener.DecodeTaskCompletionListener
    public void onDecodeTaskCompleted(int i3, int i16, String str, Bitmap bitmap) {
        Bitmap bitmap2;
        String str2;
        Bitmap bitmap3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, Integer.valueOf(i3), Integer.valueOf(i16), str, bitmap);
            return;
        }
        if (this.f187207h) {
            if (i3 == 0) {
                this.f187207h = false;
                return;
            }
            return;
        }
        if (!this.f187206f.isPausing()) {
            if (bitmap != null) {
                this.E.put(str, bitmap);
            }
            if (i3 <= 0) {
                int i17 = this.f187209m;
                if (i17 == 0 || i17 == 1) {
                    int childCount = this.f187205e.getChildCount();
                    for (int i18 = 0; i18 < childCount; i18++) {
                        View childAt = this.f187205e.getChildAt(i18);
                        Object tag = childAt.getTag();
                        if (tag != null && (tag instanceof k)) {
                            k kVar = (k) tag;
                            if (kVar.f187212f != null && (str2 = kVar.f187210d) != null && str2.length() > 0 && (bitmap3 = this.E.get(kVar.f187210d)) != null) {
                                kVar.f187212f.setImageBitmap(bitmap3);
                            }
                        } else if (childAt instanceof QzoneSearchResultView) {
                            QzoneSearchResultView qzoneSearchResultView = (QzoneSearchResultView) childAt;
                            if (!TextUtils.isEmpty(qzoneSearchResultView.c()) && (bitmap2 = this.E.get(qzoneSearchResultView.c())) != null) {
                                qzoneSearchResultView.setAvartaView(bitmap2);
                            }
                        } else if (tag != null && (tag instanceof c.C7154c)) {
                            c.C7154c c7154c = (c.C7154c) tag;
                            e(c7154c, this.E.get(c7154c.f187114d));
                        }
                    }
                }
                this.E.clear();
            }
        }
    }

    public void onScroll(AbsListView absListView, int i3, int i16, int i17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, absListView, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
            return;
        }
        AbsListView.OnScrollListener onScrollListener = this.f187208i;
        if (onScrollListener != null) {
            onScrollListener.onScroll(absListView, i3, i16, i17);
        }
    }

    public void onScrollStateChanged(AbsListView absListView, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) absListView, i3);
            return;
        }
        this.f187209m = i3;
        if (i3 != 0 && i3 != 1) {
            this.f187207h = false;
            this.f187206f.cancelPendingRequests();
            this.f187206f.pause();
        } else {
            if (this.f187206f.isPausing()) {
                this.f187206f.resume();
            }
            ListView listView = this.f187205e;
            if (listView != null) {
                int childCount = listView.getChildCount();
                for (int i16 = 0; i16 < childCount; i16++) {
                    Object tag = this.f187205e.getChildAt(i16).getTag();
                    if (tag != null && (tag instanceof k)) {
                        k kVar = (k) tag;
                        String str = kVar.f187210d;
                        if (str != null && str.length() > 0) {
                            f(kVar);
                        }
                    } else if (tag != null && (tag instanceof c.C7154c)) {
                        c.C7154c c7154c = (c.C7154c) tag;
                        e(c7154c, this.E.get(c7154c.f187114d));
                    }
                }
            }
        }
        AbsListView.OnScrollListener onScrollListener = this.f187208i;
        if (onScrollListener != null) {
            onScrollListener.onScrollStateChanged(absListView, i3);
        }
    }
}
