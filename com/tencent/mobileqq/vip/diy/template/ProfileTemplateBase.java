package com.tencent.mobileqq.vip.diy.template;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.qqstory.utils.AssertUtils;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.common.config.pad.DeviceType;
import com.tencent.common.config.pad.PadUtil;
import com.tencent.image.DownloadParams;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pad.m;
import com.tencent.mobileqq.profilecard.base.component.IProfileContentKey;
import com.tencent.mobileqq.profilecard.bussiness.photowall.view.PhotoWallView;
import com.tencent.mobileqq.profilecard.bussiness.photowall.view.ProfileCardFavorShowView;
import com.tencent.mobileqq.profilecard.data.ProfileCardInfo;
import com.tencent.mobileqq.profilecard.vas.misc.VasProfileTemplatePreloadHelper;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.util.co;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.utils.dr;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.SingleLineTextView;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes20.dex */
public class ProfileTemplateBase {
    static IPatchRedirector $redirector_;

    /* renamed from: q, reason: collision with root package name */
    private static ArrayList<String> f312961q;

    /* renamed from: a, reason: collision with root package name */
    protected c f312962a;

    /* renamed from: b, reason: collision with root package name */
    protected String f312963b;

    /* renamed from: c, reason: collision with root package name */
    protected String f312964c;

    /* renamed from: d, reason: collision with root package name */
    protected String f312965d;

    /* renamed from: e, reason: collision with root package name */
    protected int f312966e;

    /* renamed from: f, reason: collision with root package name */
    protected String f312967f;

    /* renamed from: g, reason: collision with root package name */
    protected String f312968g;

    /* renamed from: h, reason: collision with root package name */
    protected int f312969h;

    /* renamed from: i, reason: collision with root package name */
    protected LayoutInflater f312970i;

    /* renamed from: j, reason: collision with root package name */
    protected Activity f312971j;

    /* renamed from: k, reason: collision with root package name */
    protected JSONObject f312972k;

    /* renamed from: l, reason: collision with root package name */
    protected int f312973l;

    /* renamed from: m, reason: collision with root package name */
    protected String f312974m;

    /* renamed from: n, reason: collision with root package name */
    protected int f312975n;

    /* renamed from: o, reason: collision with root package name */
    protected ProfileCardInfo f312976o;

    /* renamed from: p, reason: collision with root package name */
    private Map<String, JSONObject> f312977p;

    /* loaded from: classes20.dex */
    public static class a extends URLDrawableHelper.Adapter {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        private WeakReference<View> f312980d;

        public a(View view) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) view);
            } else {
                this.f312980d = new WeakReference<>(view);
            }
        }

        public static void a(URLDrawable uRLDrawable, View view) {
            if (uRLDrawable.getStatus() != 1) {
                uRLDrawable.setURLDrawableListener(new a(view));
            }
        }

        @Override // com.tencent.mobileqq.transfile.URLDrawableHelper.Adapter, com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadSuccessed(URLDrawable uRLDrawable) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) uRLDrawable);
                return;
            }
            View view = this.f312980d.get();
            if (view != null) {
                view.invalidate();
            }
        }
    }

    /* loaded from: classes20.dex */
    public static class b implements DownloadParams.DecodeHandler {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        private int f312981a;

        /* renamed from: b, reason: collision with root package name */
        private int f312982b;

        @Deprecated
        public b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }

        @Deprecated
        public void a(int i3, int i16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, Integer.valueOf(i3), Integer.valueOf(i16));
            } else {
                this.f312981a = i3;
                this.f312982b = i16;
            }
        }

        @Override // com.tencent.image.DownloadParams.DecodeHandler
        public Bitmap run(DownloadParams downloadParams, Bitmap bitmap) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (Bitmap) iPatchRedirector.redirect((short) 4, (Object) this, (Object) downloadParams, (Object) bitmap);
            }
            return dr.i(bitmap, this.f312981a, this.f312982b);
        }

        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return (String) iPatchRedirector.redirect((short) 5, (Object) this);
            }
            return "NinePatchDecoderHandler{reqW=" + this.f312981a + ", reqH=" + this.f312982b + '}';
        }

        public b(int i3, int i16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Integer.valueOf(i16));
            } else {
                this.f312981a = i3;
                this.f312982b = i16;
            }
        }
    }

    /* loaded from: classes20.dex */
    public static class c implements DownloadParams.DecodeHandler {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        private Paint f312983a;

        /* renamed from: b, reason: collision with root package name */
        private int f312984b;

        /* renamed from: c, reason: collision with root package name */
        private boolean f312985c;

        public c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.image.DownloadParams.DecodeHandler
        public Bitmap run(DownloadParams downloadParams, Bitmap bitmap) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (Bitmap) iPatchRedirector.redirect((short) 3, (Object) this, (Object) downloadParams, (Object) bitmap);
            }
            if (bitmap == null) {
                return null;
            }
            bitmap.setDensity((int) ViewUtils.getDensityDpi());
            Bitmap c16 = co.c(downloadParams.reqWidth, downloadParams.reqHeight, Bitmap.Config.ARGB_8888);
            this.f312983a.setStrokeWidth(this.f312984b * 2);
            Path path = new Path();
            Canvas canvas = new Canvas(c16);
            canvas.save();
            int i3 = this.f312984b;
            path.moveTo(i3, i3);
            int width = c16.getWidth();
            path.lineTo(width - r3, this.f312984b);
            path.lineTo(c16.getWidth() - this.f312984b, c16.getHeight() - this.f312984b);
            path.lineTo(this.f312984b, c16.getHeight() - this.f312984b);
            path.close();
            path.setFillType(Path.FillType.EVEN_ODD);
            canvas.clipPath(path);
            canvas.drawBitmap(bitmap, new Rect(0, (bitmap.getHeight() - bitmap.getWidth()) / 2, bitmap.getWidth(), (bitmap.getWidth() + bitmap.getHeight()) / 2), new Rect(0, 0, c16.getWidth(), c16.getHeight()), this.f312983a);
            canvas.restore();
            if (!this.f312985c) {
                canvas.drawPath(path, this.f312983a);
            }
            return c16;
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(77243);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 32)) {
            redirector.redirect((short) 32);
            return;
        }
        ArrayList<String> arrayList = new ArrayList<>();
        f312961q = arrayList;
        arrayList.add(IProfileContentKey.MAP_KEY_PERSONAL_SIG);
        f312961q.add(IProfileContentKey.MAP_KEY_ACCOUNT_LEVEL);
        f312961q.add(IProfileContentKey.MAP_KEY_DIAMOND);
        f312961q.add(IProfileContentKey.MAP_KEY_TROOP_MEM_INFO);
        f312961q.add(IProfileContentKey.MAP_KEY_PYMK_REASON_DATA);
        f312961q.add(IProfileContentKey.MAP_KEY_PRESENT);
        f312961q.add(IProfileContentKey.MAP_KEY_QQCARD);
        f312961q.add(IProfileContentKey.MAP_KEY_DRESSUP);
    }

    public ProfileTemplateBase(Activity activity, JSONObject jSONObject, ProfileCardInfo profileCardInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, activity, jSONObject, profileCardInfo);
            return;
        }
        this.f312966e = -1;
        this.f312973l = -1;
        this.f312974m = "";
        this.f312975n = 0;
        this.f312977p = null;
        this.f312971j = activity;
        this.f312972k = jSONObject;
        this.f312976o = profileCardInfo;
        this.f312970i = LayoutInflater.from(activity);
        try {
            this.f312973l = Color.parseColor(jSONObject.optString("c"));
        } catch (IllegalArgumentException unused) {
            AssertUtils.fail("DIYProfileTemplate.ProfileTemplateBase default main color is illegal! " + jSONObject.optString("c"), new Object[0]);
            this.f312973l = -16777216;
        }
        this.f312963b = jSONObject.optString("sbg");
        this.f312964c = jSONObject.optString("t_bg");
        this.f312965d = jSONObject.optString("arr");
        this.f312967f = jSONObject.optString("f");
        this.f312968g = jSONObject.optString("cbg", "");
        this.f312969h = jSONObject.optInt("cpd", 0);
        this.f312962a = new c();
        try {
            this.f312966e = Color.parseColor(jSONObject.optString("line"));
        } catch (Exception unused2) {
            AssertUtils.fail("DIYProfileTemplate.ProfileTemplateBase default line color is illegal! " + jSONObject.optString("c"), new Object[0]);
            this.f312966e = -1;
        }
        n();
    }

    private JSONObject i(Map<String, JSONObject> map, String str) {
        JSONObject jSONObject;
        if (map != null) {
            jSONObject = map.get(str);
        } else {
            jSONObject = null;
        }
        if (jSONObject == null) {
            hd0.c.g("DIYProfileTemplate.ProfileTemplateBase", ":json illegal : it don't have " + str + " module");
            try {
                return new JSONObject("{}");
            } catch (JSONException unused) {
                AssertUtils.fail("DIYProfileTemplate.ProfileTemplateBase:json error : it can not generate default " + str + " module", new Object[0]);
                return null;
            }
        }
        return jSONObject;
    }

    private void n() {
        JSONArray optJSONArray = this.f312972k.optJSONArray("module");
        if (optJSONArray != null && optJSONArray.length() != 0) {
            this.f312977p = new HashMap();
            for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i3);
                if (optJSONObject == null) {
                    hd0.c.g("DIYProfileTemplate.ProfileTemplateBase", "module array[" + i3 + "] is null");
                } else {
                    this.f312977p.put(optJSONObject.optString("type"), optJSONObject);
                }
            }
            return;
        }
        AssertUtils.fail("DIYProfileTemplate.ProfileTemplateBasethere is no module!", new Object[0]);
        this.f312977p = null;
    }

    private void p(View view) {
        int j3;
        int b16;
        if (PadUtil.a(view.getContext()) == DeviceType.FOLD) {
            j3 = m.d();
            b16 = UIUtils.b(this.f312971j, 30.0f);
        } else {
            j3 = UIUtils.j(this.f312971j);
            b16 = UIUtils.b(this.f312971j, 30.0f);
        }
        view.measure(View.MeasureSpec.makeMeasureSpec(j3 - b16, 1073741824), View.MeasureSpec.makeMeasureSpec(0, 0));
    }

    public void A(View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) view);
            return;
        }
        Map<String, JSONObject> map = this.f312977p;
        if (map != null && view != null) {
            B(i(map, "photo"), view);
        }
    }

    public View B(JSONObject jSONObject, View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            return (View) iPatchRedirector.redirect((short) 27, (Object) this, (Object) jSONObject, (Object) view);
        }
        if (!(view instanceof ProfileCardFavorShowView)) {
            return view;
        }
        ProfileCardFavorShowView profileCardFavorShowView = (ProfileCardFavorShowView) view;
        PhotoWallView photoWallView = (PhotoWallView) profileCardFavorShowView.getViewInContainer(0);
        ProfileCardDiyPhotoWallView profileCardDiyPhotoWallView = (ProfileCardDiyPhotoWallView) photoWallView.findViewById(R.id.fqs).findViewById(R.id.fqs);
        profileCardDiyPhotoWallView.setItemViewBorderColor(h(jSONObject));
        profileCardDiyPhotoWallView.setBorderImgUrl(e(jSONObject));
        profileCardDiyPhotoWallView.setBorderWidth(f(jSONObject));
        a(jSONObject, profileCardFavorShowView.findViewById(R.id.icon), (TextView) profileCardFavorShowView.findViewById(R.id.jj7), (ImageView) profileCardFavorShowView.findViewById(R.id.dcv));
        View findViewById = photoWallView.findViewById(R.id.fqk);
        if (findViewById.getVisibility() == 0) {
            findViewById.setPadding(b(10.0f), b(15.0f), b(10.0f), b(10.0f));
            p(photoWallView);
            t(jSONObject, findViewById, photoWallView.getMeasuredWidth(), photoWallView.getMeasuredHeight());
        }
        return view;
    }

    public View C(JSONObject jSONObject, View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            return (View) iPatchRedirector.redirect((short) 26, (Object) this, (Object) jSONObject, (Object) view);
        }
        QZoneLayoutTemplateBase qZoneLayoutTemplateBase = (QZoneLayoutTemplateBase) view.findViewById(R.id.dkt);
        qZoneLayoutTemplateBase.setBorderColor(h(jSONObject));
        qZoneLayoutTemplateBase.setBorderWidth(f(jSONObject));
        qZoneLayoutTemplateBase.setItemBg(d(jSONObject, b(70.0f), b(70.0f)));
        a(jSONObject, view.findViewById(R.id.icon), (TextView) view.findViewById(R.id.jj7), (ImageView) view.findViewById(R.id.dcv));
        return view;
    }

    public void D(View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) view);
            return;
        }
        Map<String, JSONObject> map = this.f312977p;
        if (map == null) {
            return;
        }
        C(i(map, "qz"), view);
    }

    public void E(View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this, (Object) view);
            return;
        }
        JSONObject i3 = i(this.f312977p, "info");
        if (i3 != null && view != null) {
            r(i3, "sign", view.findViewById(R.id.icon));
        }
    }

    public void F(View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, (Object) this, (Object) view);
            return;
        }
        if (this.f312976o.isTroopMemberCard && view != null && view.getParent() == null) {
            int i3 = 0;
            while (true) {
                ViewGroup viewGroup = (ViewGroup) view;
                if (i3 < viewGroup.getChildCount()) {
                    View childAt = viewGroup.getChildAt(i3);
                    TextView textView = (TextView) childAt.findViewById(R.id.dq6);
                    if (textView != null) {
                        textView.setTextColor(this.f312973l);
                    }
                    ImageView imageView = (ImageView) childAt.findViewById(R.id.icon);
                    if (imageView != null) {
                        imageView.clearColorFilter();
                        imageView.setColorFilter(this.f312973l);
                    }
                    i3++;
                } else {
                    return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(JSONObject jSONObject, View view, TextView textView, ImageView imageView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, this, jSONObject, view, textView, imageView);
            return;
        }
        if (view != null) {
            String k3 = k(jSONObject);
            if (!TextUtils.isEmpty(k3)) {
                view.setBackgroundDrawable(l(k3));
            } else {
                if (jSONObject != null) {
                    QLog.e("DIYProfileTemplate.ProfileTemplateBase", 1, jSONObject.optString("type") + " bind title icon is null!");
                }
                view.setVisibility(8);
            }
        }
        if (imageView != null) {
            String c16 = c(jSONObject);
            if (!TextUtils.isEmpty(c16)) {
                try {
                    imageView.setImageDrawable(l(c16));
                } catch (IllegalArgumentException e16) {
                    imageView.setImageResource(R.drawable.common_arrow_right_selector);
                    if (QLog.isColorLevel()) {
                        QLog.d("DIYProfileTemplate.ProfileTemplateBase", 2, "get arrow drawable failed " + e16);
                    }
                }
            } else {
                if (jSONObject != null) {
                    QLog.e("DIYProfileTemplate.ProfileTemplateBase", 1, jSONObject.optString("type") + " bind arrow icon is null!");
                }
                imageView.setVisibility(8);
            }
        }
        if (textView != null) {
            textView.setTextColor(this.f312973l);
        }
    }

    public int b(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Integer) iPatchRedirector.redirect((short) 11, this, Float.valueOf(f16))).intValue();
        }
        return (int) ((f16 * this.f312971j.getResources().getDisplayMetrics().density) + 0.5f);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String c(JSONObject jSONObject) {
        String optString;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return (String) iPatchRedirector.redirect((short) 19, (Object) this, (Object) jSONObject);
        }
        if (jSONObject == null) {
            optString = this.f312965d;
        } else {
            optString = jSONObject.optString("arr");
        }
        if (TextUtils.isEmpty(optString)) {
            return this.f312965d;
        }
        return optString;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public URLDrawable d(JSONObject jSONObject, int i3, int i16) {
        String optString;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return (URLDrawable) iPatchRedirector.redirect((short) 15, this, jSONObject, Integer.valueOf(i3), Integer.valueOf(i16));
        }
        if (jSONObject == null) {
            optString = this.f312968g;
        } else {
            optString = jSONObject.optString("cbg", this.f312968g);
        }
        if (TextUtils.isEmpty(optString)) {
            return null;
        }
        return m(optString, new b(i3, i16));
    }

    protected String e(JSONObject jSONObject) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return (String) iPatchRedirector.redirect((short) 16, (Object) this, (Object) jSONObject);
        }
        if (jSONObject == null) {
            return this.f312968g;
        }
        return jSONObject.optString("cbg", this.f312968g);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int f(JSONObject jSONObject) {
        int optInt;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return ((Integer) iPatchRedirector.redirect((short) 17, (Object) this, (Object) jSONObject)).intValue();
        }
        if (jSONObject == null) {
            optInt = this.f312969h;
        } else {
            optInt = jSONObject.optInt("cpd", this.f312969h);
        }
        if (optInt == 0) {
            return this.f312975n;
        }
        return b(optInt / 2);
    }

    public ProfileCardFavorShowView g(Activity activity) {
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int h(JSONObject jSONObject) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Integer) iPatchRedirector.redirect((short) 12, (Object) this, (Object) jSONObject)).intValue();
        }
        String optString = jSONObject.optString("line");
        int i3 = this.f312966e;
        if (TextUtils.isEmpty(optString)) {
            return i3;
        }
        try {
            return Color.parseColor(optString);
        } catch (Exception unused) {
            AssertUtils.fail("DIYProfileTemplate.ProfileTemplateBase story line color is illegal module=" + jSONObject.optString("type") + " value=" + jSONObject.optString("line"), new Object[0]);
            return i3;
        }
    }

    public <T extends View> T j(QQAppInterface qQAppInterface, ProfileCardInfo profileCardInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (T) iPatchRedirector.redirect((short) 5, (Object) this, (Object) qQAppInterface, (Object) profileCardInfo);
        }
        TemplatePhotoWall templatePhotoWall = new TemplatePhotoWall(this.f312971j, qQAppInterface, profileCardInfo.allInOne.uin);
        ProfileCardDiyPhotoWallView profileCardDiyPhotoWallView = (ProfileCardDiyPhotoWallView) templatePhotoWall.findViewById(R.id.fqs).findViewById(R.id.fqs);
        profileCardDiyPhotoWallView.setMargin(UIUtils.b(this.f312971j, 8.0f));
        profileCardDiyPhotoWallView.setBorderWidth(this.f312975n);
        ProfileCardFavorShowView g16 = g(this.f312971j);
        g16.setTitle(HardCodeUtil.qqStr(R.string.f172323pf4));
        g16.setVisibility(8);
        g16.addView(templatePhotoWall);
        return g16;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String k(JSONObject jSONObject) {
        String optString;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return (String) iPatchRedirector.redirect((short) 18, (Object) this, (Object) jSONObject);
        }
        if (jSONObject == null) {
            optString = this.f312964c;
        } else {
            optString = jSONObject.optString("t_bg");
        }
        if (TextUtils.isEmpty(optString)) {
            return this.f312964c;
        }
        return optString;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public URLDrawable l(String str) throws IllegalArgumentException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (URLDrawable) iPatchRedirector.redirect((short) 8, (Object) this, (Object) str);
        }
        return m(str, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public URLDrawable m(String str, DownloadParams.DecodeHandler decodeHandler) throws IllegalArgumentException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (URLDrawable) iPatchRedirector.redirect((short) 9, (Object) this, (Object) str, (Object) decodeHandler);
        }
        String q16 = q(str);
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        Drawable drawable = com.tencent.mobileqq.urldrawable.b.f306350a;
        obtain.mLoadingDrawable = drawable;
        obtain.mFailedDrawable = drawable;
        obtain.mPlayGifImage = false;
        if (decodeHandler != null) {
            obtain.mMemoryCacheKeySuffix = decodeHandler.toString();
        }
        URLDrawable drawable2 = URLDrawable.getDrawable(q16, obtain);
        drawable2.setDecodeHandler(decodeHandler);
        return drawable2;
    }

    public void o(HashMap<String, View> hashMap) {
        throw null;
    }

    protected String q(@NonNull String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            return (String) iPatchRedirector.redirect((short) 31, (Object) this, (Object) str);
        }
        if (str.startsWith("http")) {
            return str;
        }
        if (!TextUtils.isEmpty(this.f312974m)) {
            if (this.f312974m.startsWith("http")) {
                return this.f312974m + str;
            }
            QLog.e("DIYProfileTemplate.ProfileTemplateBase", 1, "it have the illegal url prefix=" + this.f312974m);
        }
        return str;
    }

    protected void r(JSONObject jSONObject, String str, View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            iPatchRedirector.redirect((short) 30, this, jSONObject, str, view);
            return;
        }
        String optString = jSONObject.optString(str);
        if (TextUtils.isEmpty(optString)) {
            hd0.c.t("DIYProfileTemplate.ProfileTemplateBase", "setBaseInfoIcon " + str + " icon,but it is null.");
            return;
        }
        if (view == null) {
            hd0.c.g("DIYProfileTemplate.ProfileTemplateBase", "setBaseInfoIcon cant find " + str + " view");
            return;
        }
        try {
            URLDrawable l3 = l(optString);
            view.setBackgroundDrawable(l3);
            l3.setURLDrawableListener(new a(view));
        } catch (IllegalArgumentException e16) {
            AssertUtils.fail("setBaseInfoIcon " + str + " url illegal:" + optString + " \ne:" + e16, new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void s(JSONObject jSONObject, View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            iPatchRedirector.redirect((short) 28, (Object) this, (Object) jSONObject, (Object) view);
        } else {
            if (view == null) {
                return;
            }
            p(view);
            view.post(new Runnable(jSONObject, view) { // from class: com.tencent.mobileqq.vip.diy.template.ProfileTemplateBase.1
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ JSONObject f312978d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ View f312979e;

                {
                    this.f312978d = jSONObject;
                    this.f312979e = view;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, ProfileTemplateBase.this, jSONObject, view);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    ProfileTemplateBase profileTemplateBase = ProfileTemplateBase.this;
                    JSONObject jSONObject2 = this.f312978d;
                    View view2 = this.f312979e;
                    profileTemplateBase.t(jSONObject2, view2, view2.getWidth(), this.f312979e.getHeight());
                }
            });
        }
    }

    protected void t(JSONObject jSONObject, View view, int i3, int i16) {
        String optString;
        String optString2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            iPatchRedirector.redirect((short) 29, this, jSONObject, view, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        if (jSONObject == null) {
            optString = this.f312963b;
        } else {
            optString = jSONObject.optString(VasProfileTemplatePreloadHelper.BACKGROUND, this.f312963b);
        }
        if (jSONObject == null) {
            optString2 = "null module";
        } else {
            optString2 = jSONObject.optString("type");
        }
        if (TextUtils.isEmpty(optString)) {
            hd0.c.t("DIYProfileTemplate.ProfileTemplateBase", "setModuleBackground " + optString2 + " ,but it is null.");
            return;
        }
        if (view == null) {
            AssertUtils.fail("setModuleBackground cant find " + optString2 + " view", new Object[0]);
            return;
        }
        try {
            URLDrawable m3 = m(optString, new b(i3, i16));
            view.setBackgroundDrawable(m3);
            m3.setURLDrawableListener(new a(view));
        } catch (IllegalArgumentException e16) {
            AssertUtils.fail("setModuleBackground " + optString2 + " url illegal:" + optString + " \ne:" + e16, new Object[0]);
        }
    }

    public void u(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
        } else {
            this.f312974m = str;
        }
    }

    public void v(View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this, (Object) view);
            return;
        }
        JSONObject i3 = i(this.f312977p, "info");
        if (i3 != null && view != null) {
            ViewGroup viewGroup = (ViewGroup) view.findViewById(R.id.f163853ag);
            if (viewGroup.getChildAt(0) != null) {
                r(i3, "qq", viewGroup.getChildAt(0).findViewById(R.id.icon));
            }
            if (viewGroup.getChildAt(1) != null) {
                r(i3, "p", viewGroup.getChildAt(1).findViewById(R.id.icon));
            }
            TextView textView = (TextView) view.findViewById(R.id.f163857aj);
            if (textView != null) {
                textView.setTextColor(this.f312973l);
            }
            ImageView imageView = (ImageView) view.findViewById(R.id.f164472yw);
            if (imageView != null) {
                imageView.setColorFilter(this.f312973l);
            }
        }
    }

    public void w(View view) {
        View findViewById;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this, (Object) view);
            return;
        }
        JSONObject i3 = i(this.f312977p, "info");
        if (i3 != null && view != null) {
            view.setPadding(b(10.0f), b(12.0f), b(10.0f), b(12.0f));
            s(i3, view);
            if (this.f312976o.isTroopMemberCard && (findViewById = view.findViewById(R.id.f163856ai)) != null) {
                findViewById.setVisibility(8);
            }
        }
    }

    public void x(JSONObject jSONObject, TextView textView, View view, ImageView imageView, View view2, View view3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, this, jSONObject, textView, view, imageView, view2, view3);
            return;
        }
        if (textView != null) {
            textView.setTextColor(this.f312973l);
        }
        if (view instanceof TextView) {
            ((TextView) view).setTextColor(this.f312973l);
        } else if (view instanceof SingleLineTextView) {
            ((SingleLineTextView) view).setTextColor(this.f312973l);
        }
        if (imageView != null) {
            int b16 = b(18.0f);
            ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
            layoutParams.width = b16;
            layoutParams.height = b16;
            imageView.setLayoutParams(layoutParams);
            String c16 = c(jSONObject);
            if (!TextUtils.isEmpty(c16)) {
                imageView.setImageDrawable(l(c16));
            } else {
                imageView.setImageDrawable(null);
            }
        }
        if (view2 != null) {
            String k3 = k(jSONObject);
            if (!TextUtils.isEmpty(k3)) {
                view2.setBackgroundDrawable(l(k3));
                view2.setVisibility(0);
            } else {
                view2.setBackgroundDrawable(null);
                view2.setVisibility(8);
            }
        }
        if (view3 != null) {
            int b17 = b(10.0f);
            view3.setPadding(b17, b17, b17, b17);
            s(jSONObject, view3);
        }
    }

    public void y(View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, (Object) this, (Object) view);
            return;
        }
        JSONObject i3 = i(this.f312977p, "info");
        if (i3 != null && view != null) {
            r(i3, "lv", view.findViewById(R.id.icon));
            if (this.f312976o.isTroopMemberCard) {
                view.setVisibility(8);
            }
        }
    }

    public void z(View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, (Object) this, (Object) view);
            return;
        }
        JSONObject i3 = i(this.f312977p, "info");
        if (i3 != null && view != null) {
            r(i3, "metal", view.findViewById(R.id.icon));
            if (this.f312976o.isTroopMemberCard) {
                view.setVisibility(8);
            }
        }
    }
}
