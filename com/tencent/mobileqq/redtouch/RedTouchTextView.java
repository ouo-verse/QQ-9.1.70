package com.tencent.mobileqq.redtouch;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.text.Layout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.qqsettingme.api.IRedTouchTextViewApi;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.tianshu.data.RedTouchConst;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes17.dex */
public class RedTouchTextView extends TextView {
    static IPatchRedirector $redirector_;
    private static final boolean S;
    private int C;
    private boolean D;
    private int E;
    private int F;
    private int G;
    private BusinessInfoCheckUpdate.AppInfo H;
    private List<BusinessInfoCheckUpdate.RedTypeInfo> I;
    private int J;
    public String K;
    private String L;
    private Handler M;
    private boolean N;
    private boolean P;
    private int Q;
    public Boolean R;

    /* renamed from: d, reason: collision with root package name */
    public Drawable f280275d;

    /* renamed from: e, reason: collision with root package name */
    public Drawable f280276e;

    /* renamed from: f, reason: collision with root package name */
    public Drawable f280277f;

    /* renamed from: h, reason: collision with root package name */
    private Rect f280278h;

    /* renamed from: i, reason: collision with root package name */
    private int f280279i;

    /* renamed from: m, reason: collision with root package name */
    private int f280280m;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(50711);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 17)) {
            redirector.redirect((short) 17);
        } else {
            S = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("102329", true);
        }
    }

    public RedTouchTextView(Context context) {
        this(context, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
    }

    private void A(Canvas canvas, int i3, BusinessInfoCheckUpdate.RedTypeInfo redTypeInfo, int i16, JSONObject jSONObject) throws JSONException {
        int i17;
        int i18;
        if (i16 == 4 || i16 == 5) {
            if (i16 == 4 && !this.P) {
                i17 = getResources().getColor(R.color.red_touch_gray_text_color);
            } else if (jSONObject.has("cr")) {
                i17 = j(jSONObject.getString("cr"));
            } else {
                i17 = -1;
            }
            if (jSONObject.has("cn")) {
                i18 = j(jSONObject.getString("cn"));
            } else {
                i18 = 0;
            }
            String str = redTypeInfo.red_content.get();
            Paint paint = new Paint(1);
            paint.setTextSize(f(14));
            paint.setTextAlign(Paint.Align.LEFT);
            int measureText = (int) paint.measureText(str);
            Paint.FontMetrics fontMetrics = paint.getFontMetrics();
            int i19 = (int) (fontMetrics.bottom - fontMetrics.top);
            int width = ((getWidth() - f(0)) - q(this.I, i3)) - f(4);
            int height = ((getHeight() / 2) - (i19 / 2)) - f(2);
            Rect rect = new Rect();
            rect.left = width;
            rect.top = height;
            rect.right = measureText + width;
            if (this.I.size() <= 2) {
                rect.right += f(6) * 2;
            }
            rect.bottom = i19 + height + (f(2) * 2);
            float f16 = (f(2) + height) - fontMetrics.top;
            if (i18 != 0) {
                Drawable drawable = getResources().getDrawable(R.drawable.skin_tips_newmessage);
                drawable.getBounds();
                drawable.setBounds(width, height, rect.right, rect.bottom);
                drawable.draw(canvas);
            }
            paint.setColor(i17);
            if (this.I.size() <= 2) {
                width += f(6);
            }
            canvas.drawText(str, width, f16, paint);
        }
    }

    private static void B(BusinessInfoCheckUpdate.RedTypeInfo redTypeInfo, BusinessInfoCheckUpdate.AppInfo appInfo) {
        JSONObject jSONObject;
        try {
            if (TextUtils.isEmpty(redTypeInfo.red_desc.get())) {
                jSONObject = new JSONObject();
            } else {
                jSONObject = new JSONObject(redTypeInfo.red_desc.get());
            }
            if (jSONObject.has("dot")) {
                jSONObject.put("dot", 0);
            }
            redTypeInfo.red_desc.set(jSONObject.toString());
        } catch (Exception e16) {
            QLog.e("RedTouchTextView", 1, "setImageRedNotShowRedPoint json exception e = " + e16.getMessage());
        }
    }

    private boolean d(List<BusinessInfoCheckUpdate.RedTypeInfo> list, List<BusinessInfoCheckUpdate.RedTypeInfo> list2) {
        if (list == null || list2 == null || list.size() != list2.size() || list.size() == 0) {
            return false;
        }
        for (int i3 = 0; i3 < list.size(); i3++) {
            BusinessInfoCheckUpdate.RedTypeInfo redTypeInfo = list.get(i3);
            BusinessInfoCheckUpdate.RedTypeInfo redTypeInfo2 = list2.get(i3);
            if (redTypeInfo.red_type.get() != redTypeInfo2.red_type.get() || !redTypeInfo.red_content.get().equals(redTypeInfo2.red_content.get()) || !redTypeInfo.red_desc.get().equals(redTypeInfo2.red_desc.get()) || redTypeInfo.red_priority.get() != redTypeInfo2.red_priority.get()) {
                return false;
            }
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:13:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static boolean e(BusinessInfoCheckUpdate.RedTypeInfo redTypeInfo, BusinessInfoCheckUpdate.AppInfo appInfo) {
        int i3;
        JSONObject jSONObject;
        try {
            if (TextUtils.isEmpty(redTypeInfo.red_desc.get())) {
                jSONObject = new JSONObject();
            } else {
                jSONObject = new JSONObject(redTypeInfo.red_desc.get());
            }
        } catch (Exception e16) {
            QLog.e("RedTouchTextView", 1, "isSupportRedTouch json exception e = " + e16.getMessage());
        }
        if (jSONObject.has("dot")) {
            i3 = jSONObject.getInt("dot");
            if (i3 != 1) {
                return true;
            }
            return false;
        }
        i3 = 0;
        if (i3 != 1) {
        }
    }

    private void g(Canvas canvas) {
        JSONObject jSONObject;
        if (w()) {
            List<BusinessInfoCheckUpdate.RedTypeInfo> list = this.I;
            if (list != null && list.size() >= 1) {
                for (int size = this.I.size() - 1; size >= 0; size--) {
                    BusinessInfoCheckUpdate.RedTypeInfo redTypeInfo = this.I.get(size);
                    int i3 = redTypeInfo.red_type.get();
                    try {
                        if (TextUtils.isEmpty(redTypeInfo.red_desc.get())) {
                            jSONObject = new JSONObject();
                        } else {
                            jSONObject = new JSONObject(redTypeInfo.red_desc.get());
                        }
                        JSONObject jSONObject2 = jSONObject;
                        z(canvas, size, i3);
                        A(canvas, size, redTypeInfo, i3, jSONObject2);
                        x(canvas, size, redTypeInfo, i3, jSONObject2);
                        y(canvas, size, redTypeInfo, i3, jSONObject2);
                    } catch (Exception e16) {
                        QLog.e("RedTouchTextView", 1, "drawRed Exception " + e16);
                    }
                }
                return;
            }
            QLog.e("RedTouchTextView", 1, "drawRed showRedInfo = null");
        }
    }

    private URLDrawable.URLDrawableOptions i() {
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        Drawable drawable = getResources().getDrawable(R.drawable.f160830com);
        obtain.mLoadingDrawable = drawable;
        obtain.mFailedDrawable = drawable;
        obtain.mRequestWidth = this.f280280m;
        obtain.mRequestHeight = this.C;
        return obtain;
    }

    private int k() {
        String charSequence = getText().toString();
        TextPaint paint = getPaint();
        paint.getTextBounds(charSequence, 0, charSequence.length(), this.f280278h);
        return (int) ((((getWidth() - Layout.getDesiredWidth(charSequence, paint)) - getPaddingLeft()) - f(0)) - f(0));
    }

    private int l(BusinessInfoCheckUpdate.RedTypeInfo redTypeInfo) {
        int f16 = f(this.f280277f.getIntrinsicWidth() / 2);
        if (u(redTypeInfo, this.H)) {
            return f16 + this.G;
        }
        return f16;
    }

    private int m(BusinessInfoCheckUpdate.RedTypeInfo redTypeInfo) {
        int i3;
        int i16;
        if (u(redTypeInfo, this.H)) {
            if (this.D) {
                i3 = this.f280280m;
                i16 = this.G;
            } else {
                i3 = this.f280279i;
                i16 = this.G;
            }
            return i3 + i16;
        }
        if (this.D) {
            return this.f280280m;
        }
        return this.f280279i;
    }

    public static List<BusinessInfoCheckUpdate.RedTypeInfo> n(BusinessInfoCheckUpdate.AppInfo appInfo) {
        if (appInfo == null) {
            return null;
        }
        BusinessInfoCheckUpdate.RedDisplayInfo redDisplayInfo = appInfo.red_display_info.get();
        if (redDisplayInfo == null) {
            if (QLog.isColorLevel()) {
                QLog.d("RedTouchTextView", 2, "getRedTypeInfoFromAppInfo diplayInfo = null");
            }
            return null;
        }
        List<BusinessInfoCheckUpdate.RedTypeInfo> list = redDisplayInfo.red_type_info.get();
        if (list == null) {
            if (QLog.isColorLevel()) {
                QLog.d("RedTouchTextView", 2, "getRedTypeInfoFromAppInfo redInfos = null");
            }
            return null;
        }
        if (list.size() < 2) {
            return null;
        }
        return list;
    }

    private int o(BusinessInfoCheckUpdate.RedTypeInfo redTypeInfo, boolean z16) {
        int i3;
        if (redTypeInfo == null) {
            return 0;
        }
        int i16 = redTypeInfo.red_type.get();
        if (i16 != 0) {
            if (i16 != 9) {
                if (i16 != 15) {
                    if (i16 != 3) {
                        if (i16 != 4 && i16 != 5) {
                            return 0;
                        }
                        this.L = redTypeInfo.red_content.get();
                        TextPaint textPaint = new TextPaint();
                        textPaint.setTextSize(f(14));
                        int measureText = (int) textPaint.measureText(this.L);
                        if (z16) {
                            return measureText + (f(6) * 2);
                        }
                        return measureText;
                    }
                    return m(redTypeInfo);
                }
                if (S) {
                    return l(redTypeInfo);
                }
                return m(redTypeInfo);
            }
            try {
                i3 = f(Integer.valueOf(redTypeInfo.red_content.get()).intValue());
            } catch (Exception e16) {
                QLog.e("RedTouchTextView", 1, "getRedTypeInfoWidth exception e = ", e16);
                i3 = 0;
            }
            if (i3 < 0) {
                return 0;
            }
            return i3;
        }
        return this.E;
    }

    private int p(List<BusinessInfoCheckUpdate.RedTypeInfo> list) {
        boolean z16;
        if (list != null && list.size() <= 2) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (list == null || list.size() <= 0) {
            return 0;
        }
        int i3 = 0;
        for (int i16 = 0; i16 < list.size(); i16++) {
            i3 += o(list.get(i16), z16);
        }
        return i3;
    }

    private int q(List<BusinessInfoCheckUpdate.RedTypeInfo> list, int i3) {
        boolean z16;
        int i16 = 0;
        if (list != null && list.size() <= 2) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (list != null && (i3 > list.size() - 1 || i3 < 0)) {
            if (QLog.isColorLevel()) {
                QLog.d("RedTouchTextView", 2, "getWidthByRedInfoListByPosition error, size = " + list.size() + " position = " + i3);
            }
            return 0;
        }
        if (list != null && list.size() > 0) {
            for (int size = list.size() - 1; size >= i3; size--) {
                i16 += o(list.get(size), z16);
            }
        }
        return i16;
    }

    private void r() {
        this.f280278h = new Rect();
        int f16 = f(30);
        this.f280279i = f16;
        this.f280280m = f16;
        this.C = f16;
        this.E = f(9);
        this.F = f(9);
        this.G = f(4);
    }

    public static void setDiffImageRedNotShowRedPoint(BusinessInfoCheckUpdate.RedTypeInfo redTypeInfo, BusinessInfoCheckUpdate.AppInfo appInfo) {
        if (redTypeInfo != null && redTypeInfo.red_type.get() == 15) {
            B(redTypeInfo, appInfo);
        }
    }

    public static void setImageRedNotShowRedPoint(BusinessInfoCheckUpdate.RedTypeInfo redTypeInfo, BusinessInfoCheckUpdate.AppInfo appInfo) {
        if (redTypeInfo != null && redTypeInfo.red_type.get() == 3) {
            B(redTypeInfo, appInfo);
        }
    }

    public static boolean t(BusinessInfoCheckUpdate.RedTypeInfo redTypeInfo, BusinessInfoCheckUpdate.AppInfo appInfo) {
        if (redTypeInfo != null && redTypeInfo.red_type.get() == 15) {
            return e(redTypeInfo, appInfo);
        }
        return false;
    }

    public static boolean u(BusinessInfoCheckUpdate.RedTypeInfo redTypeInfo, BusinessInfoCheckUpdate.AppInfo appInfo) {
        if (redTypeInfo != null && redTypeInfo.red_type.get() == 3) {
            return e(redTypeInfo, appInfo);
        }
        return false;
    }

    private boolean v(List<BusinessInfoCheckUpdate.RedTypeInfo> list, int i3, int i16) {
        int k3 = k();
        while (true) {
            int i17 = 0;
            if (i3 <= k3 || i16 <= 1) {
                break;
            }
            int size = list.size();
            int i18 = 0;
            while (true) {
                if (i18 >= size) {
                    break;
                }
                if (list.get(i18).red_type.get() != 9) {
                    list.remove(i18);
                    i16--;
                    size--;
                    break;
                }
                i18++;
            }
            while (true) {
                if (i17 >= size - 1) {
                    break;
                }
                if (list.get(i17).red_type.get() == 9 && list.get(i17 + 1).red_type.get() == 9) {
                    list.remove(i17);
                    break;
                }
                i17++;
            }
            i3 = p(list);
        }
        if (i3 > k3 && i16 == 1) {
            for (int i19 = 0; i19 < list.size(); i19++) {
                BusinessInfoCheckUpdate.RedTypeInfo redTypeInfo = list.get(i19);
                if (redTypeInfo.red_type.get() == 3 && u(redTypeInfo, this.H)) {
                    setImageRedNotShowRedPoint(redTypeInfo, this.H);
                }
            }
        }
        if (p(list) > k3 && i16 == 1) {
            for (int i26 = 0; i26 < list.size(); i26++) {
                BusinessInfoCheckUpdate.RedTypeInfo redTypeInfo2 = list.get(i26);
                if (redTypeInfo2.red_type.get() != 9 && redTypeInfo2.red_type.get() != 0) {
                    BusinessInfoCheckUpdate.RedTypeInfo redTypeInfo3 = new BusinessInfoCheckUpdate.RedTypeInfo();
                    redTypeInfo3.red_type.set(0);
                    list.set(i26, redTypeInfo3);
                }
            }
        }
        if (p(list) <= k3) {
            return false;
        }
        return true;
    }

    private boolean w() {
        BusinessInfoCheckUpdate.AppInfo appInfo = this.H;
        if (appInfo == null || appInfo.iNewFlag.get() != 1) {
            return false;
        }
        BusinessInfoCheckUpdate.RedDisplayInfo redDisplayInfo = this.H.red_display_info.get();
        if (redDisplayInfo == null) {
            if (QLog.isColorLevel()) {
                QLog.d("RedTouchTextView", 2, "getRedTypeInfoFromAppInfo diplayInfo = null, path = " + this.H.path.get());
            }
            return false;
        }
        List<BusinessInfoCheckUpdate.RedTypeInfo> list = redDisplayInfo.red_type_info.get();
        if (list == null) {
            if (QLog.isColorLevel()) {
                QLog.d("RedTouchTextView", 2, "getRedTypeInfoFromAppInfo redInfos = null, path = " + this.H.path.get());
            }
            return false;
        }
        if (list.size() < 2) {
            return false;
        }
        ArrayList arrayList = new ArrayList(list);
        int p16 = p(arrayList);
        Iterator<BusinessInfoCheckUpdate.RedTypeInfo> it = arrayList.iterator();
        int i3 = 0;
        while (it.hasNext()) {
            if (it.next().red_type.get() != 9) {
                i3++;
            }
        }
        if (i3 == 0) {
            QLog.e("RedTouchTextView", 1, "isSupportRedTouch notSpaceInfoCount = 0");
            return false;
        }
        if (v(arrayList, p16, i3)) {
            return false;
        }
        setShowRedInfo(arrayList);
        return true;
    }

    private void x(Canvas canvas, int i3, BusinessInfoCheckUpdate.RedTypeInfo redTypeInfo, int i16, JSONObject jSONObject) throws JSONException {
        int i17;
        int i18;
        int i19;
        if (i16 == 3) {
            int width = (getWidth() - q(this.I, i3)) - f(0);
            int height = (getHeight() / 2) - (this.C / 2);
            if (jSONObject.has("av")) {
                i17 = jSONObject.getInt("av");
            } else {
                i17 = 0;
            }
            if (jSONObject.has("dot")) {
                i18 = jSONObject.getInt("dot");
            } else {
                i18 = 0;
            }
            if (jSONObject.has("st")) {
                i19 = Integer.valueOf(jSONObject.getString("st")).intValue();
            } else {
                i19 = 0;
            }
            String str = redTypeInfo.red_content.get();
            if (i19 == 1) {
                URLDrawable.URLDrawableOptions i26 = i();
                i26.mPlayGifImage = true;
                URLDrawable drawable = URLDrawable.getDrawable(str, i26);
                drawable.setCallback(this);
                drawable.draw(canvas);
                Drawable drawable2 = this.f280276e;
                if (drawable2 != null) {
                    drawable2.setBounds(width, height, this.f280280m + width, this.C + height);
                    this.f280276e.draw(canvas);
                    return;
                }
                return;
            }
            if (i19 == 0) {
                if (this.f280276e == null && !TextUtils.isEmpty(str)) {
                    try {
                        URLDrawable drawable3 = URLDrawable.getDrawable(new URL(RedTouchConst.PicDownload.REDTOUCHPIC_PROTOC, (String) null, str), i());
                        if (drawable3 != null) {
                            drawable3.addHeader(RedTouchConst.PicDownload.ISCIRCLE, String.valueOf(i17));
                            drawable3.setTag(str);
                        }
                        this.f280276e = drawable3;
                    } catch (Exception e16) {
                        QLog.e("RedTouchTextView", 1, "get static image Exception " + e16);
                    }
                }
                Drawable drawable4 = this.f280276e;
                if (drawable4 != null) {
                    drawable4.setCallback(this);
                    this.f280276e.setBounds(width, height, this.f280280m + width, this.C + height);
                    this.f280276e.draw(canvas);
                }
                if (i18 == 1) {
                    Drawable drawable5 = getResources().getDrawable(R.drawable.skin_tips_dot);
                    drawable5.setBounds((getWidth() - f(0)) - f(9), height - f(4), getWidth() - f(0), height + f(5));
                    drawable5.draw(canvas);
                }
            }
        }
    }

    private void y(Canvas canvas, int i3, BusinessInfoCheckUpdate.RedTypeInfo redTypeInfo, int i16, JSONObject jSONObject) throws JSONException {
        int i17;
        if (i16 == 15) {
            int width = ((getWidth() - q(this.I, i3)) - f(0)) - f(4);
            int height = (getHeight() / 2) - (this.C / 2);
            if (jSONObject.has("av")) {
                jSONObject.getInt("av");
            }
            if (jSONObject.has("dot")) {
                i17 = jSONObject.getInt("dot");
            } else {
                i17 = 0;
            }
            Drawable drawable = this.f280277f;
            if (drawable != null) {
                int intrinsicWidth = drawable.getIntrinsicWidth() / 2;
                if (S) {
                    this.f280277f.setBounds(width, height, f(intrinsicWidth) + width, this.C + height);
                } else {
                    this.f280277f.setBounds((this.f280280m + width) - f(intrinsicWidth), height, width + this.f280280m, this.C + height);
                }
                this.f280277f.setCallback(this);
                this.f280277f.draw(canvas);
            }
            if (i17 == 1) {
                Drawable drawable2 = getResources().getDrawable(R.drawable.skin_tips_dot);
                drawable2.setBounds((getWidth() - f(0)) - f(9), height - f(4), getWidth() - f(0), height + f(5));
                drawable2.draw(canvas);
            }
        }
    }

    private void z(Canvas canvas, int i3, int i16) {
        if (i16 == 0) {
            if (QLog.isColorLevel()) {
                QLog.d("RedTouchTextView", 2, "draw redtouchpoint");
            }
            int width = ((getWidth() - q(this.I, i3)) - f(0)) - f(4);
            int height = (getHeight() / 2) - (this.E / 2);
            Drawable drawable = getResources().getDrawable(R.drawable.skin_tips_dot);
            this.f280275d = drawable;
            int i17 = this.E;
            drawable.setBounds(width, height, width + i17, i17 + height);
            this.f280275d.draw(canvas);
        }
    }

    public void c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this);
        } else {
            if (!this.R.booleanValue()) {
                return;
            }
            post(new Runnable() { // from class: com.tencent.mobileqq.redtouch.RedTouchTextView.2
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) RedTouchTextView.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    String charSequence = RedTouchTextView.this.getText().toString();
                    TextPaint paint = RedTouchTextView.this.getPaint();
                    paint.getTextBounds(charSequence, 0, charSequence.length(), RedTouchTextView.this.f280278h);
                    int pxTosp = ViewUtils.pxTosp(Layout.getDesiredWidth(charSequence, paint)) + RedTouchTextView.this.getPaddingLeft() + RedTouchTextView.this.getPaddingRight();
                    ViewGroup.LayoutParams layoutParams = RedTouchTextView.this.getLayoutParams();
                    layoutParams.width = pxTosp;
                    RedTouchTextView.this.setLayoutParams(layoutParams);
                    RedTouchTextView.this.setMaxWidth(pxTosp);
                    RedTouchTextView.this.Q = pxTosp;
                }
            });
        }
    }

    protected int f(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Integer) iPatchRedirector.redirect((short) 14, (Object) this, i3)).intValue();
        }
        return (int) TypedValue.applyDimension(1, i3, getResources().getDisplayMetrics());
    }

    public BusinessInfoCheckUpdate.AppInfo h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (BusinessInfoCheckUpdate.AppInfo) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.H;
    }

    @Override // android.widget.TextView, android.view.View, android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(Drawable drawable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) drawable);
            return;
        }
        super.invalidateDrawable(drawable);
        this.f280276e = drawable;
        s();
    }

    protected int j(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Integer) iPatchRedirector.redirect((short) 15, (Object) this, (Object) str)).intValue();
        }
        if (!TextUtils.isEmpty(str) && !str.equals("#")) {
            return Color.parseColor(str);
        }
        return 0;
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) canvas);
            return;
        }
        super.onDraw(canvas);
        canvas.save();
        g(canvas);
        canvas.restore();
    }

    @Override // android.widget.TextView, android.view.View
    protected void onLayout(boolean z16, int i3, int i16, int i17, int i18) {
        int i19;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, Boolean.valueOf(z16), Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18));
        } else if (this.R.booleanValue() && (i19 = this.Q) != 0) {
            super.onLayout(z16, i3, i16, i3 + i19, i18);
        } else {
            super.onLayout(z16, i3, i16, i17, i18);
        }
    }

    public void s() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        if (this.M == null) {
            this.M = new Handler(Looper.getMainLooper());
        }
        if (this.f280276e != null && this.D) {
            this.f280280m = (int) (this.C * (r0.getIntrinsicWidth() / this.f280276e.getIntrinsicHeight()));
        }
        this.M.post(new Runnable() { // from class: com.tencent.mobileqq.redtouch.RedTouchTextView.1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) RedTouchTextView.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                } else {
                    RedTouchTextView.this.invalidate();
                }
            }
        });
    }

    public void setAppInfo(BusinessInfoCheckUpdate.AppInfo appInfo) {
        PBRepeatMessageField<BusinessInfoCheckUpdate.RedTypeInfo> pBRepeatMessageField;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) appInfo);
            return;
        }
        if (appInfo == null) {
            if (QLog.isColorLevel()) {
                QLog.d("RedTouchTextView", 2, "setAppInfo appInfo is null");
            }
            this.H = null;
            invalidate();
            return;
        }
        if (!d(n(appInfo), this.I)) {
            this.f280275d = null;
            this.f280276e = null;
        }
        this.H = appInfo;
        BusinessInfoCheckUpdate.RedDisplayInfo redDisplayInfo = appInfo.red_display_info;
        if (redDisplayInfo != null && (pBRepeatMessageField = redDisplayInfo.red_type_info) != null) {
            List<BusinessInfoCheckUpdate.RedTypeInfo> list = pBRepeatMessageField.get();
            for (int size = list.size() - 1; size >= 0; size--) {
                BusinessInfoCheckUpdate.RedTypeInfo redTypeInfo = list.get(size);
                if (redTypeInfo.red_type.get() == 15) {
                    this.f280277f = ((IRedTouchTextViewApi) QRoute.api(IRedTouchTextViewApi.class)).getApngURLDrawable(redTypeInfo.red_content.get());
                }
            }
        }
        invalidate();
    }

    public void setIsNeedRedImageAutoFix(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, z16);
        } else {
            this.D = z16;
        }
    }

    public void setShowRedInfo(List<BusinessInfoCheckUpdate.RedTypeInfo> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) list);
        } else {
            this.I = list;
        }
    }

    public void setUseRedTouchTextColorFromConfig(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, z16);
        } else {
            this.P = z16;
        }
    }

    public RedTouchTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) context, (Object) attributeSet);
            return;
        }
        this.f280279i = 0;
        this.f280280m = 0;
        this.C = 0;
        this.D = false;
        this.E = 0;
        this.F = 0;
        this.J = 100;
        this.K = "";
        this.L = "";
        this.N = false;
        this.P = true;
        this.Q = 0;
        this.R = Boolean.FALSE;
        r();
    }
}
