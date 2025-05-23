package com.tencent.qqnt.emotion.stickerrecommended.mvvm;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.aio.event.InputEvent;
import com.tencent.mobileqq.aio.input.edit.d;
import com.tencent.mobileqq.emoticonview.EmotionReportDtImpl;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.mvi.base.route.k;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.emotion.stickerrecommended.IRecommendEmotionService;
import com.tencent.qqnt.emotion.stickerrecommended.adapter.StickerRecBarAdapter;
import com.tencent.qqnt.emotion.stickerrecommended.event.StickerRecommendEvent;
import com.tencent.qqnt.emotion.stickerrecommended.view.EmotionKeywordHorizonListView;
import com.tencent.qqnt.emotion.stickerrecommended.view.EmotionKeywordLayout;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes24.dex */
public class c extends com.tencent.qqnt.emotion.stickerrecommended.mvvm.base.b implements com.tencent.qqnt.emotion.stickerrecommended.mvvm.a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private ConstraintLayout f356561a;

    /* renamed from: b, reason: collision with root package name */
    public EmotionKeywordLayout f356562b;

    /* renamed from: c, reason: collision with root package name */
    private EmotionKeywordHorizonListView f356563c;

    /* renamed from: d, reason: collision with root package name */
    private StickerRecBarAdapter f356564d;

    /* renamed from: e, reason: collision with root package name */
    private AppInterface f356565e;

    /* renamed from: f, reason: collision with root package name */
    private Context f356566f;

    /* renamed from: g, reason: collision with root package name */
    private com.tencent.aio.api.runtime.a f356567g;

    /* renamed from: h, reason: collision with root package name */
    private g f356568h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f356569i;

    /* renamed from: j, reason: collision with root package name */
    Observer<com.tencent.qqnt.emotion.stickerrecommended.mvvm.data.a> f356570j;

    /* renamed from: k, reason: collision with root package name */
    Observer<String> f356571k;

    /* renamed from: l, reason: collision with root package name */
    Observer<com.tencent.qqnt.emotion.stickerrecommended.mvvm.data.b> f356572l;

    /* compiled from: P */
    /* loaded from: classes24.dex */
    class a implements Observer<com.tencent.qqnt.emotion.stickerrecommended.mvvm.data.a> {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) c.this);
            }
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(com.tencent.qqnt.emotion.stickerrecommended.mvvm.data.a aVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) aVar);
                return;
            }
            if (QLog.isDevelopLevel()) {
                QLog.d("StickerRecViewBinder", 4, "layoutStatus change:", Integer.valueOf(aVar.f356584a), " ,layout:", c.this.f356562b);
            }
            int i3 = aVar.f356584a;
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 != 3) {
                        if (i3 == 4) {
                            c cVar = c.this;
                            if (cVar.f356562b != null && cVar.f356561a != null) {
                                c.this.f356561a.removeView(c.this.f356562b);
                                c cVar2 = c.this;
                                cVar2.f356562b = null;
                                cVar2.f356564d = null;
                                c.this.f356568h.W1(false);
                            }
                            c.this.f356567g.e().h(new StickerRecommendEvent.OnShowOrHideEmotionKeywordLayout(false));
                            return;
                        }
                        return;
                    }
                    EmotionKeywordLayout emotionKeywordLayout = c.this.f356562b;
                    if (emotionKeywordLayout != null) {
                        emotionKeywordLayout.d();
                        c.this.f356568h.W1(false);
                        c.this.f356568h.Q1().setValue(null);
                    }
                    ((IRecommendEmotionService) QRoute.api(IRecommendEmotionService.class)).clearSpecWordType(c.this.f356567g);
                    c.this.f356567g.e().h(new StickerRecommendEvent.OnShowOrHideEmotionKeywordLayout(false));
                    return;
                }
                EmotionKeywordLayout emotionKeywordLayout2 = c.this.f356562b;
                if (emotionKeywordLayout2 != null) {
                    emotionKeywordLayout2.d();
                    c.this.f356568h.W1(false);
                    c.this.f356568h.Q1().setValue(null);
                }
                c.this.f356567g.e().h(new StickerRecommendEvent.OnShowOrHideEmotionKeywordLayout(false));
                return;
            }
            if (c.this.f356561a == null) {
                if (QLog.isColorLevel()) {
                    QLog.e("StickerRecViewBinder", 2, "layoutStatus change STATUS_SHOW error, mContentView is null!");
                    return;
                }
                return;
            }
            if (!c.this.f356569i) {
                ConstraintLayout.LayoutParams layoutParams = new ConstraintLayout.LayoutParams(-1, -2);
                layoutParams.bottomToBottom = 0;
                layoutParams.leftToLeft = 0;
                c.this.f356561a.addView(c.this.f356562b, layoutParams);
                c.this.f356569i = true;
            }
            c.this.f356562b.f(aVar.f356585b);
            c.this.f356568h.W1(true);
            c.this.f356562b.bringToFront();
            c.this.f356561a.setVisibility(0);
            c.this.f356567g.e().h(new StickerRecommendEvent.OnShowOrHideEmotionKeywordLayout(true));
        }
    }

    /* compiled from: P */
    /* loaded from: classes24.dex */
    class b implements Observer<String> {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) c.this);
            }
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
            } else {
                EmotionKeywordLayout emotionKeywordLayout = c.this.f356562b;
            }
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.qqnt.emotion.stickerrecommended.mvvm.c$c, reason: collision with other inner class name */
    /* loaded from: classes24.dex */
    class C9619c implements Observer<com.tencent.qqnt.emotion.stickerrecommended.mvvm.data.b> {
        static IPatchRedirector $redirector_;

        C9619c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) c.this);
            }
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(com.tencent.qqnt.emotion.stickerrecommended.mvvm.data.b bVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) bVar);
                return;
            }
            if (c.this.f356564d != null) {
                c.this.f356564d.d();
                if (bVar == null) {
                    c.this.f356564d.c();
                    c.this.f356564d.notifyDataSetChanged();
                    return;
                }
                c.this.f356564d.l(bVar.f356589d);
                c.this.f356564d.m(bVar.f356590e);
                c.this.f356564d.j(bVar.f356587b);
                c.this.f356564d.k(bVar.f356588c);
                c.this.f356564d.i(bVar.f356591f);
                c.this.f356564d.setData(bVar.f356586a);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes24.dex */
    public class d implements EmotionKeywordLayout.d {
        static IPatchRedirector $redirector_;

        d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) c.this);
            }
        }

        @Override // com.tencent.qqnt.emotion.stickerrecommended.view.EmotionKeywordLayout.d
        public void onVisibilityChanged(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, i3);
                return;
            }
            if (i3 == 0) {
                HashMap hashMap = new HashMap();
                hashMap.put(EmotionReportDtImpl.TEXT_IN_TEXTBOX, c.this.p());
                com.tencent.mobileqq.aio.utils.b.q(EmotionReportDtImpl.EM_AIO_TEXTBOX_STICKERS_RECOMMEND_BAR, hashMap);
            } else {
                HashMap hashMap2 = new HashMap();
                hashMap2.put(EmotionReportDtImpl.TEXT_IN_TEXTBOX, c.this.p());
                com.tencent.mobileqq.aio.utils.b.t(EmotionReportDtImpl.EM_AIO_TEXTBOX_STICKERS_RECOMMEND_BAR, hashMap2);
            }
            if (i3 == 8 && c.this.f356564d != null) {
                c.this.f356564d.h();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes24.dex */
    class e implements EmotionKeywordHorizonListView.a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ EditText f356577a;

        e(EditText editText) {
            this.f356577a = editText;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) c.this, (Object) editText);
            }
        }

        @Override // com.tencent.qqnt.emotion.stickerrecommended.view.EmotionKeywordHorizonListView.a
        public void touchEventActionChanged(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, i3);
                return;
            }
            if (c.this.f356567g == null) {
                return;
            }
            if (i3 != 0) {
                if (i3 == 1 || i3 == 3) {
                    c.this.f356567g.e().h(new StickerRecommendEvent.HideEmotionKeywordLayout(6000L));
                    return;
                }
                return;
            }
            c.this.f356567g.e().h(StickerRecommendEvent.CancelHideEmotionKeywordLayout.f356518d);
            com.tencent.mobileqq.temp.report.a.a(c.this.f356565e, "CliOper", "", "", "ep_mall", WinkDaTongReportConstant.ElementParamValue.BOTTOM_TAB_SWITCH_TYPE_SLIDE, 0, 0, "", "", "", this.f356577a.getText().toString());
        }
    }

    public c(AppInterface appInterface, Context context, com.tencent.aio.api.runtime.a aVar, com.tencent.qqnt.emotion.stickerrecommended.mvvm.b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, appInterface, context, aVar, bVar);
            return;
        }
        this.f356570j = new a();
        this.f356571k = new b();
        this.f356572l = new C9619c();
        this.f356565e = appInterface;
        this.f356566f = context;
        this.f356567g = aVar;
        this.f356568h = (g) bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String p() {
        k k3 = this.f356567g.e().k(new InputEvent.GetInputString());
        if (k3 instanceof d.C7264d) {
            return ((d.C7264d) k3).a().toString();
        }
        return "";
    }

    private EmotionKeywordHorizonListView q(ViewGroup viewGroup, EditText editText) {
        EmotionKeywordLayout emotionKeywordLayout = this.f356562b;
        if (emotionKeywordLayout == null) {
            return null;
        }
        emotionKeywordLayout.setEnableAnim(true);
        LinearLayout linearLayout = (LinearLayout) this.f356562b.findViewById(R.id.uso);
        EmotionKeywordHorizonListView emotionKeywordHorizonListView = (EmotionKeywordHorizonListView) this.f356562b.findViewById(R.id.bvm);
        TextView textView = (TextView) this.f356562b.findViewById(R.id.usn);
        if (QQTheme.isNowThemeIsNight()) {
            linearLayout.setBackgroundColor(Color.parseColor("#1F1F1F"));
            textView.setTextColor(Color.parseColor("#8D8D93"));
        }
        StickerRecBarAdapter stickerRecBarAdapter = new StickerRecBarAdapter(this.f356566f, this.f356565e, this.f356567g, viewGroup, editText, emotionKeywordHorizonListView);
        this.f356564d = stickerRecBarAdapter;
        stickerRecBarAdapter.n(this.f356568h);
        emotionKeywordHorizonListView.setAdapter((ListAdapter) this.f356564d);
        emotionKeywordHorizonListView.setPadding(0, 0, 0, 0);
        this.f356562b.setOnVisibilityListener(new d());
        this.f356568h.d1(true);
        return emotionKeywordHorizonListView;
    }

    @Override // com.tencent.qqnt.emotion.stickerrecommended.mvvm.a
    public void a(LifecycleOwner lifecycleOwner) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) lifecycleOwner);
            return;
        }
        this.f356568h.P1().removeObserver(this.f356570j);
        this.f356568h.O1().removeObserver(this.f356571k);
        this.f356568h.Q1().removeObserver(this.f356572l);
        ConstraintLayout constraintLayout = this.f356561a;
        if (constraintLayout != null) {
            EmotionKeywordLayout emotionKeywordLayout = this.f356562b;
            if (emotionKeywordLayout != null) {
                constraintLayout.removeView(emotionKeywordLayout);
            }
            this.f356561a = null;
        }
    }

    @Override // com.tencent.qqnt.emotion.stickerrecommended.mvvm.a
    public void b(LifecycleOwner lifecycleOwner) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) lifecycleOwner);
            return;
        }
        m(lifecycleOwner, this.f356568h);
        o(lifecycleOwner, this.f356568h);
        n(lifecycleOwner, this.f356568h);
    }

    @Override // com.tencent.qqnt.emotion.stickerrecommended.mvvm.a
    public void c(ConstraintLayout constraintLayout, EditText editText) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) constraintLayout, (Object) editText);
            return;
        }
        if (this.f356562b == null) {
            try {
                EmotionKeywordLayout emotionKeywordLayout = (EmotionKeywordLayout) View.inflate(this.f356566f, R.layout.fpv, null);
                this.f356562b = emotionKeywordLayout;
                emotionKeywordLayout.setBackgroundResource(R.drawable.qui_common_bg_bottom_light_bg);
                EmotionKeywordHorizonListView q16 = q(constraintLayout, editText);
                this.f356563c = q16;
                if (q16 == null) {
                    return;
                }
                q16.setTouchListener(new e(editText));
                this.f356561a = constraintLayout;
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.e("StickerRecViewBinder", 2, "EmotionPreviewLayout InflateException = " + e16);
                }
            }
        }
    }

    protected void m(LifecycleOwner lifecycleOwner, g gVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) lifecycleOwner, (Object) gVar);
        } else {
            gVar.Q1().observe(lifecycleOwner, this.f356572l);
        }
    }

    protected void n(LifecycleOwner lifecycleOwner, g gVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) lifecycleOwner, (Object) gVar);
        } else {
            gVar.O1().observe(lifecycleOwner, this.f356571k);
        }
    }

    protected void o(LifecycleOwner lifecycleOwner, g gVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) lifecycleOwner, (Object) gVar);
        } else {
            gVar.P1().observe(lifecycleOwner, this.f356570j);
        }
    }
}
