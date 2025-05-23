package com.tencent.mobileqq.fragment.bottomtab;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Point;
import android.view.View;
import android.view.WindowManager;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.activity.framebusiness.controllerinject.TabDataHelper;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* compiled from: P */
/* loaded from: classes12.dex */
public class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private final LinearLayout f211370a;

    /* renamed from: b, reason: collision with root package name */
    private final QQAppInterface f211371b;

    /* renamed from: c, reason: collision with root package name */
    private final ArrayList<PreviewItem> f211372c;

    /* renamed from: d, reason: collision with root package name */
    private int f211373d;

    /* renamed from: e, reason: collision with root package name */
    private long f211374e;

    /* renamed from: f, reason: collision with root package name */
    private final Context f211375f;

    /* renamed from: g, reason: collision with root package name */
    private final String f211376g;

    public b(LinearLayout linearLayout, QQAppInterface qQAppInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) linearLayout, (Object) qQAppInterface);
            return;
        }
        this.f211372c = new ArrayList<>();
        this.f211370a = linearLayout;
        this.f211371b = qQAppInterface;
        this.f211375f = qQAppInterface.getApp();
        this.f211376g = qQAppInterface.getCurrentUin();
        this.f211373d = b();
        a();
    }

    private void a() {
        int i3;
        List asList = Arrays.asList(TabDataHelper.transferConfigStringToArray(TabDataHelper.getTabRuleList(this.f211371b.getApp(), this.f211371b.getCurrentUin(), TabDataHelper.getModelType())));
        c cVar = new c();
        int size = asList.size();
        int i16 = 0;
        for (int i17 = 0; i17 < size; i17++) {
            PreviewItem a16 = cVar.a((String) asList.get(i17));
            if (a16 != null) {
                this.f211372c.add(a16);
                this.f211370a.addView(a16.e());
                String d16 = a16.d();
                if (d(d16) || TabDataHelper.isExtendTabShow(this.f211375f, this.f211376g, d16)) {
                    a16.i(true);
                    i16++;
                }
            }
        }
        int i18 = this.f211373d / i16;
        for (int i19 = 0; i19 < this.f211372c.size(); i19++) {
            PreviewItem previewItem = this.f211372c.get(i19);
            View e16 = previewItem.e();
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) e16.getLayoutParams();
            if (previewItem.g()) {
                i3 = i18;
            } else {
                i3 = 0;
            }
            layoutParams.width = i3;
            layoutParams.height = -1;
            e16.setLayoutParams(layoutParams);
        }
    }

    private int b() {
        WindowManager windowManager = (WindowManager) this.f211371b.getApp().getSystemService("window");
        Point point = new Point();
        windowManager.getDefaultDisplay().getSize(point);
        return point.x;
    }

    public static boolean d(String str) {
        int i3 = 0;
        while (true) {
            String[] strArr = TabDataHelper.TAB_ARRAY_CONSTANT;
            if (i3 >= strArr.length) {
                return false;
            }
            if (strArr[i3].equals(str)) {
                return true;
            }
            i3++;
        }
    }

    public boolean c(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, j3)).booleanValue();
        }
        long abs = Math.abs(this.f211374e - j3);
        this.f211374e = j3;
        if (abs >= 200) {
            return true;
        }
        return false;
    }

    public void e(@NonNull Configuration configuration) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) configuration);
            return;
        }
        int b16 = b();
        if (this.f211373d != b16) {
            this.f211373d = b16;
            f();
        }
    }

    public void f() {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        int i3 = 0;
        for (int i16 = 0; i16 < this.f211372c.size(); i16++) {
            PreviewItem previewItem = this.f211372c.get(i16);
            String d16 = previewItem.d();
            if (!d(d16) && !TabDataHelper.isExtendTabShow(this.f211375f, this.f211376g, d16)) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (z16) {
                i3++;
                previewItem.i(true);
            } else {
                previewItem.i(false);
            }
        }
        int i17 = this.f211373d / i3;
        for (int i18 = 0; i18 < this.f211372c.size(); i18++) {
            PreviewItem previewItem2 = this.f211372c.get(i18);
            if (previewItem2.g()) {
                previewItem2.h(i17);
            } else {
                previewItem2.h(0);
            }
            previewItem2.b();
        }
    }
}
