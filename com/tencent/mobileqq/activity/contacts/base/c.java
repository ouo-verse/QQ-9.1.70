package com.tencent.mobileqq.activity.contacts.base;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.contacts.friend.BuddyListAdapter;
import com.tencent.mobileqq.adapter.ai;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.widget.SimpleTextView;
import com.tencent.widget.SingleLineTextView;
import com.tencent.widget.SwipRightMenuBuilder;
import com.tencent.widget.SwipTextViewMenuBuilder;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes10.dex */
public abstract class c {
    static IPatchRedirector $redirector_;

    /* renamed from: j, reason: collision with root package name */
    @SuppressLint({"UseSparseArrays"})
    public static Map<Integer, ColorStateList> f181500j;

    /* renamed from: a, reason: collision with root package name */
    protected SwipRightMenuBuilder f181501a;

    /* renamed from: b, reason: collision with root package name */
    protected int f181502b;

    /* renamed from: c, reason: collision with root package name */
    public QQAppInterface f181503c;

    /* renamed from: d, reason: collision with root package name */
    public Context f181504d;

    /* renamed from: e, reason: collision with root package name */
    public Object f181505e;

    /* renamed from: f, reason: collision with root package name */
    protected BuddyListAdapter f181506f;

    /* renamed from: g, reason: collision with root package name */
    protected b f181507g;

    /* renamed from: h, reason: collision with root package name */
    protected Drawable f181508h;

    /* renamed from: i, reason: collision with root package name */
    protected boolean f181509i;

    /* compiled from: P */
    /* loaded from: classes10.dex */
    class a extends SwipTextViewMenuBuilder {
        static IPatchRedirector $redirector_;

        a(int i3, int i16, int[] iArr, int i17, int[] iArr2, int[] iArr3, int[] iArr4) {
            super(i3, i16, iArr, i17, iArr2, iArr3, iArr4);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, c.this, Integer.valueOf(i3), Integer.valueOf(i16), iArr, Integer.valueOf(i17), iArr2, iArr3, iArr4);
            }
        }

        @Override // com.tencent.widget.SwipRightMenuBuilder
        public void getRightMenuItemInfo(int i3, Object obj, SwipRightMenuBuilder.SwipRightMenuItem[] swipRightMenuItemArr) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), obj, swipRightMenuItemArr);
            } else {
                c.this.g(i3, swipRightMenuItemArr);
            }
        }

        @Override // com.tencent.widget.SwipTextViewMenuBuilder, com.tencent.widget.SwipRightMenuBuilder
        public View updateRightMenuItem(int i3, Object obj, SwipRightMenuBuilder.SwipRightMenuItem swipRightMenuItem, View.OnClickListener onClickListener) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (View) iPatchRedirector.redirect((short) 3, this, Integer.valueOf(i3), obj, swipRightMenuItem, onClickListener);
            }
            View updateRightMenuItem = super.updateRightMenuItem(i3, obj, swipRightMenuItem, onClickListener);
            if (updateRightMenuItem instanceof SimpleTextView) {
                updateRightMenuItem.setTag(-10, obj);
            }
            return updateRightMenuItem;
        }
    }

    /* compiled from: P */
    /* loaded from: classes10.dex */
    public interface b {
        int a();
    }

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.activity.contacts.base.c$c, reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public static class C7154c extends ai.a {
        static IPatchRedirector $redirector_;

        /* renamed from: h, reason: collision with root package name */
        public SingleLineTextView f181511h;

        /* renamed from: i, reason: collision with root package name */
        public SingleLineTextView f181512i;

        /* renamed from: m, reason: collision with root package name */
        public Object f181513m;

        public C7154c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(68002);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 16)) {
            redirector.redirect((short) 16);
        } else {
            f181500j = new HashMap(5);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public c(QQAppInterface qQAppInterface, Context context, Entity entity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, qQAppInterface, context, entity);
            return;
        }
        this.f181508h = null;
        this.f181503c = qQAppInterface;
        this.f181504d = context;
        this.f181505e = entity;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static ColorStateList c(Context context, int i3) {
        ColorStateList colorStateList = f181500j.get(Integer.valueOf(i3));
        if (colorStateList == null && context != null) {
            ColorStateList colorStateList2 = context.getResources().getColorStateList(i3);
            f181500j.put(Integer.valueOf(i3), colorStateList2);
            return colorStateList2;
        }
        return colorStateList;
    }

    public abstract View a(int i3, int i16, View view, ViewGroup viewGroup, View.OnClickListener onClickListener);

    /* JADX INFO: Access modifiers changed from: protected */
    public SwipRightMenuBuilder b(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (SwipRightMenuBuilder) iPatchRedirector.redirect((short) 12, (Object) this, (Object) context);
        }
        return new a(d(), i(), new int[]{ViewUtils.dip2px(152.0f)}, -1, f(), h(), e());
    }

    protected int d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
        }
        return 1;
    }

    protected int[] e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (int[]) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return null;
    }

    protected int[] f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (int[]) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return null;
    }

    protected void g(int i3, SwipRightMenuBuilder.SwipRightMenuItem[] swipRightMenuItemArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, i3, (Object) swipRightMenuItemArr);
        }
    }

    protected int[] h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (int[]) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return null;
    }

    protected int i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
        }
        return 1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Drawable j() {
        Context context;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (Drawable) iPatchRedirector.redirect((short) 14, (Object) this);
        }
        boolean simpleUISwitch = SimpleUIUtil.getSimpleUISwitch();
        if (this.f181508h != null && this.f181509i != simpleUISwitch) {
            this.f181508h = null;
        }
        if (this.f181508h == null && (context = this.f181504d) != null) {
            try {
                this.f181508h = context.getResources().getDrawable(R.drawable.abc);
                this.f181509i = simpleUISwitch;
            } catch (Exception | OutOfMemoryError unused) {
            }
        }
        return this.f181508h;
    }

    public int k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Integer) iPatchRedirector.redirect((short) 11, (Object) this)).intValue();
        }
        return this.f181502b;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void l(View view, int i3, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, this, view, Integer.valueOf(i3), str);
            return;
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        VideoReport.setElementId(view, "em_kl_contact_people_unit");
        VideoReport.setElementClickPolicy(view, ClickPolicy.REPORT_ALL);
        VideoReport.setElementExposePolicy(view, ExposurePolicy.REPORT_ALL);
        VideoReport.setElementParam(view, "user_type", Integer.valueOf(i3));
        VideoReport.setElementParam(view, "user_id", str);
    }

    public void m(b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) bVar);
        } else {
            this.f181507g = bVar;
        }
    }

    public void n(View view, int i3, C7154c c7154c, View.OnClickListener onClickListener) {
        int i16;
        int i17;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, this, view, Integer.valueOf(i3), c7154c, onClickListener);
            return;
        }
        SwipRightMenuBuilder swipRightMenuBuilder = this.f181501a;
        if (swipRightMenuBuilder != null) {
            i16 = swipRightMenuBuilder.updateRightMenuView(this.f181504d, view, i3, this.f181505e, c7154c, onClickListener);
        } else {
            i16 = 0;
        }
        BuddyListAdapter buddyListAdapter = this.f181506f;
        if (buddyListAdapter != null && (i17 = buddyListAdapter.K) != -1) {
            if (i3 != i17) {
                view.scrollTo(0, 0);
            } else {
                view.scrollTo(i16, 0);
            }
        }
    }
}
