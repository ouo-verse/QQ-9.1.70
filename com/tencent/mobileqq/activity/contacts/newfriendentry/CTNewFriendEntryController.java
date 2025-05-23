package com.tencent.mobileqq.activity.contacts.newfriendentry;

import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.graphics.drawable.PaintDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RectShape;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.contacts.newfriendentry.a;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.newfriend.api.INewFriendService;
import com.tencent.mobileqq.newfriend.api.INewFriendVerificationService;
import com.tencent.mobileqq.newfriend.msg.b;
import com.tencent.mobileqq.newfriend.msg.c;
import com.tencent.mobileqq.newfriend.msg.i;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qmmkv.v2.MMKVOptionEntityV2;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.quibadge.QUIBadge;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.util.ay;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.SingleLineTextView;
import com.tencent.widget.d;
import java.util.ArrayList;
import java.util.List;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes10.dex */
public class CTNewFriendEntryController {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private RelativeLayout f181628a;

    /* renamed from: b, reason: collision with root package name */
    private SingleLineTextView f181629b;

    /* renamed from: c, reason: collision with root package name */
    private ImageView f181630c;

    /* renamed from: d, reason: collision with root package name */
    private ImageView f181631d;

    /* renamed from: e, reason: collision with root package name */
    private RelativeLayout f181632e;

    /* renamed from: f, reason: collision with root package name */
    private RelativeLayout f181633f;

    /* renamed from: g, reason: collision with root package name */
    private SingleLineTextView f181634g;

    /* renamed from: h, reason: collision with root package name */
    private SingleLineTextView f181635h;

    /* renamed from: i, reason: collision with root package name */
    private RecyclerView f181636i;

    /* renamed from: j, reason: collision with root package name */
    private com.tencent.mobileqq.activity.contacts.newfriendentry.a f181637j;

    /* renamed from: k, reason: collision with root package name */
    private QUIBadge f181638k;

    /* renamed from: l, reason: collision with root package name */
    private TextView f181639l;

    /* renamed from: m, reason: collision with root package name */
    private QQAppInterface f181640m;

    /* renamed from: n, reason: collision with root package name */
    private ViewGroup.LayoutParams f181641n;

    /* renamed from: o, reason: collision with root package name */
    private int f181642o;

    /* renamed from: p, reason: collision with root package name */
    private int f181643p;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class a extends ShapeDrawable.ShaderFactory {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ float f181650a;

        a(float f16) {
            this.f181650a = f16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, CTNewFriendEntryController.this, Float.valueOf(f16));
            }
        }

        @Override // android.graphics.drawable.ShapeDrawable.ShaderFactory
        public Shader resize(int i3, int i16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (Shader) iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Integer.valueOf(i16));
            }
            return new LinearGradient(0.0f, 0.0f, i3, 0.0f, new int[]{Color.parseColor("#00FFFFFF"), Color.parseColor("#FFFFFFFF"), Color.parseColor("#FFFFFFFF")}, new float[]{0.0f, this.f181650a, 1.0f}, Shader.TileMode.CLAMP);
        }
    }

    public CTNewFriendEntryController(RelativeLayout relativeLayout, QQAppInterface qQAppInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) relativeLayout, (Object) qQAppInterface);
            return;
        }
        this.f181628a = relativeLayout;
        this.f181641n = relativeLayout.getLayoutParams();
        this.f181640m = qQAppInterface;
        this.f181638k = (QUIBadge) relativeLayout.findViewById(R.id.k1t);
        this.f181639l = (TextView) relativeLayout.findViewById(R.id.zsb);
        this.f181629b = (SingleLineTextView) relativeLayout.findViewById(R.id.h0p);
        this.f181630c = (ImageView) relativeLayout.findViewById(R.id.h0q);
        this.f181632e = (RelativeLayout) relativeLayout.findViewById(R.id.h0o);
        this.f181631d = (ImageView) relativeLayout.findViewById(R.id.h0n);
        this.f181633f = (RelativeLayout) relativeLayout.findViewById(R.id.f166454h50);
        this.f181634g = (SingleLineTextView) relativeLayout.findViewById(R.id.nickname);
        this.f181635h = (SingleLineTextView) relativeLayout.findViewById(R.id.i5e);
        f(relativeLayout);
        i();
        if (QLog.isColorLevel()) {
            QLog.d("CTNewFriendEntryController", 2, "CTNewFriendEntryController maxDisplayHeadCount = " + this.f181642o);
        }
    }

    private void e(int i3, boolean z16) {
        int[] iArr = {0};
        INewFriendService iNewFriendService = (INewFriendService) this.f181640m.getRuntimeService(INewFriendService.class, "");
        StringBuilder sb5 = new StringBuilder(32);
        if (i3 == 0) {
            ThreadManagerV2.excute(new Runnable(iNewFriendService, iArr, z16, sb5, i3) { // from class: com.tencent.mobileqq.activity.contacts.newfriendentry.CTNewFriendEntryController.2
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ INewFriendService f181644d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ int[] f181645e;

                /* renamed from: f, reason: collision with root package name */
                final /* synthetic */ boolean f181646f;

                /* renamed from: h, reason: collision with root package name */
                final /* synthetic */ StringBuilder f181647h;

                /* renamed from: i, reason: collision with root package name */
                final /* synthetic */ int f181648i;

                {
                    this.f181644d = iNewFriendService;
                    this.f181645e = iArr;
                    this.f181646f = z16;
                    this.f181647h = sb5;
                    this.f181648i = i3;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, this, CTNewFriendEntryController.this, iNewFriendService, iArr, Boolean.valueOf(z16), sb5, Integer.valueOf(i3));
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this);
                        return;
                    }
                    i lastUnreadNewFriendMessage = this.f181644d.getLastUnreadNewFriendMessage();
                    if (lastUnreadNewFriendMessage != null && lastUnreadNewFriendMessage.c(CTNewFriendEntryController.this.f181640m)) {
                        this.f181645e[0] = 1;
                        if (this.f181646f) {
                            ReportController.o(CTNewFriendEntryController.this.f181640m, "CliOper", "", "", "0X800707A", "0X800707A", 0, 0, "", "", "", "");
                        }
                        StringBuilder sb6 = this.f181647h;
                        sb6.append(CTNewFriendEntryController.this.f181640m.getApp().getResources().getString(R.string.cil));
                        sb6.append(" \u6709\u66f4\u65b0");
                    } else if (((INewFriendVerificationService) CTNewFriendEntryController.this.f181640m.getRuntimeService(INewFriendVerificationService.class)).isShowRedPoint()) {
                        this.f181645e[0] = 1;
                        if (QLog.isColorLevel()) {
                            QLog.d("CTNewFriendEntryController", 2, "contacts updateUnreadCount");
                        }
                    } else {
                        this.f181647h.append(CTNewFriendEntryController.this.f181640m.getApp().getResources().getString(R.string.hwl));
                    }
                    ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.activity.contacts.newfriendentry.CTNewFriendEntryController.2.1
                        static IPatchRedirector $redirector_;

                        {
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AnonymousClass2.this);
                            }
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                                TextView textView = CTNewFriendEntryController.this.f181639l;
                                AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                                d.b(textView, anonymousClass2.f181645e[0], anonymousClass2.f181648i, 0);
                                CTNewFriendEntryController.this.f181638k.setVisibility(4);
                                CTNewFriendEntryController.this.f181639l.setVisibility(0);
                                CTNewFriendEntryController.this.f181628a.setContentDescription(AnonymousClass2.this.f181647h.toString());
                                return;
                            }
                            iPatchRedirector2.redirect((short) 2, (Object) this);
                        }
                    });
                }
            }, 16, null, true);
            return;
        }
        if (i3 > 0) {
            if (z16) {
                ReportController.o(this.f181640m, "CliOper", "", "", "0X800707B", "0X800707B", 0, 0, "", "", "", "");
            }
            iArr[0] = 3;
            sb5.append(this.f181640m.getApp().getResources().getString(R.string.cil));
            sb5.append(" ");
            if (i3 > 99) {
                sb5.append("\u591a\u4e8e99\u6761\u672a\u8bfb");
            } else {
                sb5.append(i3);
                sb5.append("\u6761\u672a\u8bfb");
            }
            this.f181638k.setRedNum(i3);
            this.f181638k.setVisibility(0);
            this.f181639l.setVisibility(4);
            this.f181628a.setContentDescription(sb5.toString());
        }
    }

    private void f(RelativeLayout relativeLayout) {
        PaintDrawable paintDrawable;
        this.f181636i = (RecyclerView) relativeLayout.findViewById(R.id.h0h);
        int screenWidth = ViewUtils.getScreenWidth();
        int dpToPx = ViewUtils.dpToPx(76.0f);
        int dpToPx2 = ViewUtils.dpToPx(48.0f);
        int dpToPx3 = ViewUtils.dpToPx(8.0f);
        int i3 = (screenWidth - dpToPx) + dpToPx3;
        int i16 = i3 / dpToPx2;
        if (i3 % dpToPx2 > dpToPx3) {
            i16++;
            float f16 = ((r7 - dpToPx3) * 1.0f) / (dpToPx2 - dpToPx3);
            a aVar = new a(f16);
            paintDrawable = new PaintDrawable();
            paintDrawable.setShape(new RectShape());
            paintDrawable.setShaderFactory(aVar);
            if (QLog.isColorLevel()) {
                QLog.d("CTNewFriendEntryController", 2, "initHeadsRecyclerView count = " + i16 + ", ratio = " + f16);
            }
        } else {
            paintDrawable = null;
        }
        this.f181642o = i16;
        com.tencent.mobileqq.activity.contacts.newfriendentry.a aVar2 = new com.tencent.mobileqq.activity.contacts.newfriendentry.a(this.f181640m, null, paintDrawable, i16);
        this.f181637j = aVar2;
        this.f181636i.setAdapter(aVar2);
        this.f181636i.setLayoutFrozen(true);
        this.f181636i.addItemDecoration(new a.C7156a(ViewUtils.dpToPx(8.0f)));
        DefaultItemAnimator defaultItemAnimator = new DefaultItemAnimator();
        defaultItemAnimator.setAddDuration(1000L);
        this.f181636i.setItemAnimator(defaultItemAnimator);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.f181640m.getApp());
        linearLayoutManager.setOrientation(0);
        this.f181636i.setLayoutManager(linearLayoutManager);
    }

    private void i() {
        this.f181629b.setVisibility(0);
        this.f181630c.setVisibility(0);
        this.f181632e.setVisibility(4);
        this.f181631d.setVisibility(4);
        this.f181633f.setVisibility(4);
        this.f181636i.setVisibility(4);
        this.f181641n.height = ViewUtils.dpToPx(56.0f);
        this.f181628a.requestLayout();
    }

    private void j(boolean z16, List<Object> list) {
        if (list != null && list.size() > 0) {
            if (QLog.isColorLevel()) {
                QLog.d("CTNewFriendEntryController", 2, "showMultiNewFriendUI doAnimate = " + z16 + ",count = " + list.size());
            }
            this.f181632e.setVisibility(0);
            this.f181631d.setVisibility(0);
            this.f181636i.setVisibility(0);
            this.f181633f.setVisibility(4);
            this.f181629b.setVisibility(4);
            this.f181630c.setVisibility(4);
            this.f181641n.height = ViewUtils.dpToPx(93.0f);
            this.f181628a.requestLayout();
            if (z16) {
                if (list.size() > 0) {
                    this.f181637j.p(list.get(0));
                    return;
                }
                return;
            }
            this.f181637j.t(list);
        }
    }

    private void k(List<Object> list) {
        if (list != null && list.size() >= 0) {
            this.f181632e.setVisibility(0);
            this.f181631d.setVisibility(0);
            this.f181633f.setVisibility(0);
            this.f181629b.setVisibility(4);
            this.f181630c.setVisibility(4);
            this.f181636i.setVisibility(0);
            this.f181641n.height = ViewUtils.dpToPx(93.0f);
            this.f181628a.requestLayout();
            Object obj = list.get(0);
            if (obj instanceof c) {
                c cVar = (c) obj;
                String b16 = ay.b(cVar.e());
                if (!TextUtils.isEmpty(b16)) {
                    this.f181634g.setText(b16);
                } else {
                    this.f181634g.setText(cVar.d());
                }
                String f16 = cVar.f(this.f181633f.getContext());
                if (QLog.isColorLevel()) {
                    QLog.d("CTNewFriendEntryController", 2, "showOneNewFriendUI nickname = " + cVar.d() + "reqContent = " + f16);
                }
                this.f181635h.setText(f16);
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f181634g.getLayoutParams();
                if (TextUtils.isEmpty(f16)) {
                    layoutParams.addRule(15);
                    layoutParams.addRule(10, 0);
                } else {
                    layoutParams.addRule(10);
                    layoutParams.addRule(15, 0);
                }
            } else if (obj instanceof PhoneContact) {
                this.f181634g.setText(((PhoneContact) obj).name);
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.f181634g.getLayoutParams();
                layoutParams2.addRule(15);
                layoutParams2.addRule(10, 0);
            } else if (obj instanceof b) {
                this.f181634g.setText(((b) obj).f254021d.name);
                RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.f181634g.getLayoutParams();
                layoutParams3.addRule(15);
                layoutParams3.addRule(10, 0);
            }
            this.f181637j.t(list.subList(0, 1));
        }
    }

    private void m(int i3, boolean z16) {
        INewFriendService iNewFriendService = (INewFriendService) this.f181640m.getRuntimeService(INewFriendService.class, "");
        StringBuilder sb5 = new StringBuilder(32);
        if (i3 == 0) {
            i lastUnreadNewFriendMessage = iNewFriendService.getLastUnreadNewFriendMessage();
            int i16 = 1;
            if (lastUnreadNewFriendMessage != null && lastUnreadNewFriendMessage.c(this.f181640m)) {
                if (z16) {
                    ReportController.o(this.f181640m, "CliOper", "", "", "0X800707A", "0X800707A", 0, 0, "", "", "", "");
                }
                sb5.append(this.f181640m.getApp().getResources().getString(R.string.cil));
                sb5.append(" \u6709\u66f4\u65b0");
            } else if (((INewFriendVerificationService) this.f181640m.getRuntimeService(INewFriendVerificationService.class)).isShowRedPoint()) {
                if (QLog.isColorLevel()) {
                    QLog.d("CTNewFriendEntryController", 2, "contacts updateUnreadCount");
                }
            } else {
                sb5.append(this.f181640m.getApp().getResources().getString(R.string.hwl));
                i16 = 0;
            }
            d.b(this.f181639l, i16, i3, 0);
            this.f181638k.setVisibility(4);
            this.f181639l.setVisibility(0);
        } else if (i3 > 0) {
            if (z16) {
                ReportController.o(this.f181640m, "CliOper", "", "", "0X800707B", "0X800707B", 0, 0, "", "", "", "");
            }
            sb5.append(this.f181640m.getApp().getResources().getString(R.string.cil));
            sb5.append(" ");
            if (i3 > 99) {
                sb5.append("\u591a\u4e8e99\u6761\u672a\u8bfb");
            } else {
                sb5.append(i3);
                sb5.append("\u6761\u672a\u8bfb");
            }
            this.f181638k.setRedNum(i3);
            this.f181638k.setVisibility(0);
            this.f181639l.setVisibility(4);
        }
        this.f181628a.setContentDescription(sb5.toString());
    }

    public void g(QQAppInterface qQAppInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) qQAppInterface);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("CTNewFriendEntryController", 2, "clearData");
        }
        this.f181640m = qQAppInterface;
        this.f181636i.getRecycledViewPool().clear();
        this.f181637j.s(qQAppInterface);
        this.f181637j.t(new ArrayList());
    }

    public void h() {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        int i16 = this.f181643p;
        if (i16 == 1) {
            i3 = 1;
        } else if (i16 > 1) {
            i3 = 2;
        } else {
            i3 = 0;
        }
        this.f181639l.setVisibility(4);
        MMKVOptionEntityV2 fromV2 = QMMKV.fromV2(MobileQQ.sMobileQQ, "common_mmkv_configurations");
        if (!fromV2.isAccessible()) {
            return;
        }
        fromV2.putBoolean("KEY_HAS_ENTER_NEW_FRIEND_" + this.f181640m.getCurrentAccountUin(), true);
        ReportController.o(this.f181640m, "dc00898", "", "", "0X8007F18", "0X8007F18", 1, 0, String.valueOf(i3), "", "", "");
    }

    public void l(List<Object> list, boolean z16, boolean z17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z18 = false;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, list, Boolean.valueOf(z16), Boolean.valueOf(z17));
            return;
        }
        if (list != null && list.size() >= 0) {
            int size = list.size();
            if (QLog.isColorLevel()) {
                QLog.d("CTNewFriendEntryController", 2, "updateRedDotCount count = " + size + ",doAnimate = " + z16);
            }
            if (size == 0) {
                i();
            } else if (size == 1) {
                k(list);
            } else {
                if (z16 && size - this.f181643p == 1) {
                    z18 = true;
                }
                j(z18, list);
            }
            this.f181643p = size;
            boolean isSwitchOn = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("102326", true);
            if (QLog.isColorLevel()) {
                QLog.d("CTNewFriendEntryController", 2, "asyncSwitch = " + isSwitchOn);
            }
            if (isSwitchOn) {
                e(size, z17);
            } else {
                m(size, z17);
            }
        }
    }
}
