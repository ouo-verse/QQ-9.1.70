package com.tencent.mobileqq.activity.photo.album;

import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.transfile.ProtocolDownloaderConstants;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.richmediabrowser.model.RichMediaBaseData;
import com.tencent.richmediabrowser.model.RichMediaBrowserInfo;
import com.tencent.sharpP.SharpPUtils;
import cooperation.qzone.webviewplugin.QzoneWebViewOfflinePlugin;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes10.dex */
public class f extends BaseAdapter implements AdapterView.OnItemClickListener {
    static IPatchRedirector $redirector_;
    private int C;
    private int D;
    private int E;
    PhotoPreviewCustomizationDefault F;

    /* renamed from: d, reason: collision with root package name */
    private ColorDrawable f184230d;

    /* renamed from: e, reason: collision with root package name */
    private Drawable f184231e;

    /* renamed from: f, reason: collision with root package name */
    private ArrayList<String> f184232f;

    /* renamed from: h, reason: collision with root package name */
    private int f184233h;

    /* renamed from: i, reason: collision with root package name */
    private int f184234i;

    /* renamed from: m, reason: collision with root package name */
    private int f184235m;

    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public URLImageView f184236a;

        /* renamed from: b, reason: collision with root package name */
        public ImageView f184237b;

        /* renamed from: c, reason: collision with root package name */
        public ImageView f184238c;

        /* renamed from: d, reason: collision with root package name */
        public URLDrawable f184239d;

        public a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) f.this);
            }
        }
    }

    public f(PhotoPreviewCustomizationDefault photoPreviewCustomizationDefault) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) photoPreviewCustomizationDefault);
            return;
        }
        this.f184232f = new ArrayList<>();
        this.F = photoPreviewCustomizationDefault;
        this.f184230d = new ColorDrawable(570425344);
        this.f184231e = this.F.f184197m.getResources().getDrawable(R.drawable.asd);
        this.f184233h = Utils.n(53.0f, this.F.f184197m.getResources());
        this.f184234i = Utils.n(53.0f, this.F.f184197m.getResources());
        this.f184235m = Utils.n(26.0f, this.F.f184197m.getResources());
        this.C = Utils.n(19.0f, this.F.f184197m.getResources());
        this.D = Utils.n(8.0f, this.F.f184197m.getResources());
        this.E = Utils.n(1.0f, this.F.f184197m.getResources());
    }

    public static URL a(LocalMediaInfo localMediaInfo, String str) {
        StringBuilder sb5 = new StringBuilder(ProtocolDownloaderConstants.PROTOCOL_ALBUM_THUMB_PREVIEW);
        sb5.append(QzoneWebViewOfflinePlugin.STR_DEVIDER);
        sb5.append(localMediaInfo.path);
        if (str != null) {
            sb5.append("#");
            sb5.append(str);
        }
        try {
            return new URL(sb5.toString());
        } catch (MalformedURLException e16) {
            if (QLog.isColorLevel()) {
                QLog.d("PhotoSelectedThumbAdapter", 2, e16.getMessage(), e16);
                return null;
            }
            return null;
        }
    }

    public LocalMediaInfo b(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (LocalMediaInfo) iPatchRedirector.redirect((short) 8, (Object) this, (Object) str);
        }
        LocalMediaInfo k3 = this.F.f184337i.k(str);
        if (k3 == null) {
            LocalMediaInfo localMediaInfo = new LocalMediaInfo();
            localMediaInfo.mMediaType = 0;
            return localMediaInfo;
        }
        return k3;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return this.f184232f.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return iPatchRedirector.redirect((short) 3, (Object) this, i3);
        }
        ArrayList<String> arrayList = this.f184232f;
        if (arrayList != null && arrayList.size() > i3) {
            return this.f184232f.get(i3);
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

    /* JADX WARN: Removed duplicated region for block: B:38:0x015d  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0192  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x01a8  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x01ae  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0174  */
    @Override // android.widget.Adapter
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public View getView(int i3, View view, ViewGroup viewGroup) {
        View view2;
        a aVar;
        String str;
        boolean z16;
        URL url;
        View view3;
        int i16;
        RichMediaBaseData richMediaBaseData;
        int i17;
        View view4;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            view3 = view;
            view4 = (View) iPatchRedirector.redirect((short) 6, this, Integer.valueOf(i3), view, viewGroup);
        } else {
            if (view == null) {
                aVar = new a();
                RelativeLayout relativeLayout = new RelativeLayout(this.F.f184197m);
                URLImageView uRLImageView = new URLImageView(this.F.f184197m);
                aVar.f184236a = uRLImageView;
                uRLImageView.setPadding(this.D, 0, 0, 0);
                relativeLayout.addView(aVar.f184236a, this.f184233h, this.f184234i);
                ImageView imageView = new ImageView(this.F.f184197m);
                aVar.f184237b = imageView;
                imageView.setPadding(this.D, 0, 0, 0);
                ImageView imageView2 = aVar.f184237b;
                if (QQTheme.isNowSimpleUI()) {
                    i17 = R.drawable.k6k;
                } else {
                    i17 = R.drawable.hdq;
                }
                imageView2.setImageResource(i17);
                int dip2px = ViewUtils.dip2px(2.0f);
                relativeLayout.addView(aVar.f184237b, this.f184233h + dip2px, this.f184234i + dip2px);
                ImageView imageView3 = new ImageView(this.F.f184197m);
                aVar.f184238c = imageView3;
                imageView3.setImageResource(R.drawable.f160524cg1);
                aVar.f184238c.setPadding(this.D, 0, 0, this.E);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.f184235m, this.C);
                layoutParams.addRule(12);
                layoutParams.addRule(9);
                aVar.f184238c.setLayoutParams(layoutParams);
                aVar.f184238c.setVisibility(4);
                relativeLayout.addView(aVar.f184238c);
                relativeLayout.setTag(aVar);
                view2 = relativeLayout;
            } else {
                view2 = view;
                aVar = (a) view.getTag();
            }
            String str2 = (String) getItem(i3);
            if (str2 == null) {
                str2 = "";
            }
            LocalMediaInfo b16 = b(str2);
            b16.path = str2;
            int i18 = this.f184234i;
            b16.thumbWidth = i18;
            b16.thumbHeight = i18;
            RichMediaBrowserInfo item = this.F.v().getItem(this.F.v().i());
            URLDrawable uRLDrawable = null;
            if (item != null && (richMediaBaseData = item.baseData) != null) {
                str = richMediaBaseData.filePath;
            } else {
                str = null;
            }
            if (str != null) {
                ImageView imageView4 = aVar.f184237b;
                if (str.equals(str2)) {
                    i16 = 0;
                } else {
                    i16 = 4;
                }
                imageView4.setVisibility(i16);
            } else {
                aVar.f184237b.setVisibility(4);
            }
            if (this.F.f184337i.l(str2) == 1) {
                if (b16.isSystemMeidaStore) {
                    url = a(b16, "VIDEO");
                } else {
                    url = a(b16, "APP_VIDEO");
                }
            } else if (new File(str2).exists()) {
                url = a(b16, "DEFAULT");
            } else {
                if (QAlbumUtil.isNetUrl(str2)) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                url = null;
                if (url == null || z16) {
                    URLDrawable uRLDrawable2 = aVar.f184239d;
                    if (!z16) {
                        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
                        int i19 = this.f184234i;
                        obtain.mRequestWidth = i19;
                        obtain.mRequestHeight = i19;
                        obtain.mLoadingDrawable = this.f184230d;
                        uRLDrawable = URLDrawable.getDrawable(SharpPUtils.getWebpUrl(str2), obtain);
                    } else if (uRLDrawable2 == null || !uRLDrawable2.getURL().toString().equals(url.toString())) {
                        uRLDrawable = j.c(url, this.f184230d, this.f184231e);
                    }
                    if (uRLDrawable != null) {
                        uRLDrawable.setTag(b16);
                        aVar.f184236a.setImageDrawable(uRLDrawable);
                        aVar.f184239d = uRLDrawable;
                    }
                    if (!this.F.C.f184325c.containsValue(str2)) {
                        aVar.f184238c.setVisibility(0);
                    } else {
                        aVar.f184238c.setVisibility(4);
                    }
                }
                view3 = view2;
                view4 = view2;
            }
            z16 = false;
            if (url == null) {
            }
            URLDrawable uRLDrawable22 = aVar.f184239d;
            if (!z16) {
            }
            if (uRLDrawable != null) {
            }
            if (!this.F.C.f184325c.containsValue(str2)) {
            }
            view3 = view2;
            view4 = view2;
        }
        EventCollector.getInstance().onListGetView(i3, view3, viewGroup, getItemId(i3));
        return view4;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i3, long j3) {
        EventCollector.getInstance().onItemClickBefore(adapterView, view, i3, j3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, adapterView, view, Integer.valueOf(i3), Long.valueOf(j3));
        } else {
            int indexOf = this.F.C.f184324b.indexOf(this.f184232f.get(i3));
            if (indexOf >= 0) {
                this.F.f184337i.browserModel.setSelectedIndex(indexOf);
                this.F.f184337i.f184340d.scrollToCurrentPosition();
                this.F.k(indexOf);
                notifyDataSetChanged();
            }
        }
        EventCollector.getInstance().onItemClick(adapterView, view, i3, j3);
    }

    public void setData(ArrayList<String> arrayList) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) arrayList);
        } else {
            this.f184232f = arrayList;
            notifyDataSetChanged();
        }
    }
}
