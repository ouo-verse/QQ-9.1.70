package com.tencent.mobileqq.colornote.list;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.colornote.api.impl.ColorNoteControllerImpl;
import com.tencent.mobileqq.colornote.data.ColorNote;
import com.tencent.mobileqq.colornote.data.ColorNoteRecentConfigProcessor;
import com.tencent.mobileqq.colornote.layout.LargeTouchAreaButton;
import com.tencent.mobileqq.colornote.list.ColorNoteListAnimator;
import com.tencent.mobileqq.music.api.IQQPlayer;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vas.api.IVasAudioApi;
import com.tencent.mobileqq.widget.RoundImageView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ScrollView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes5.dex */
public class ColorNoteListLayoutV2 extends LinearLayout {
    private h C;
    private d D;
    private ScrollView E;

    /* renamed from: d, reason: collision with root package name */
    private List<ColorNote> f201445d;

    /* renamed from: e, reason: collision with root package name */
    private List<View> f201446e;

    /* renamed from: f, reason: collision with root package name */
    private List<e> f201447f;

    /* renamed from: h, reason: collision with root package name */
    private int f201448h;

    /* renamed from: i, reason: collision with root package name */
    private ColorNoteListAnimator f201449i;

    /* renamed from: m, reason: collision with root package name */
    private List<f> f201450m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class a implements ColorNoteListAnimator.d {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f201452a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f201453b;

        a(int i3, int i16) {
            this.f201452a = i3;
            this.f201453b = i16;
        }

        @Override // com.tencent.mobileqq.colornote.list.ColorNoteListAnimator.d
        public void onAnimationFinished() {
            if (this.f201452a >= ColorNoteListLayoutV2.this.f201445d.size()) {
                return;
            }
            ColorNoteListLayoutV2.this.f201445d.remove(this.f201452a);
            ColorNoteListLayoutV2.this.A();
            int scrollY = ColorNoteListLayoutV2.this.E.getScrollY() - this.f201453b;
            ScrollView scrollView = ColorNoteListLayoutV2.this.E;
            if (scrollY <= 0) {
                scrollY = 0;
            }
            scrollView.setScrollY(scrollY);
        }
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            ColorNote colorNote = (ColorNote) view.getTag();
            int m3 = ColorNoteListLayoutV2.this.m(colorNote);
            QLog.e("ColorNoteListLayoutV2", 4, "removePosition: " + m3);
            if (colorNote.getServiceType() == 16973824) {
                ((IQQPlayer) QRoute.api(IQQPlayer.class)).stopPlayMusic(view.getContext());
            }
            if (colorNote.getServiceType() == 17367040) {
                ((IVasAudioApi) QRoute.api(IVasAudioApi.class)).pause("");
            }
            boolean z16 = true;
            if (com.tencent.mobileqq.colornote.data.a.w(colorNote)) {
                if (ColorNoteRecentConfigProcessor.a().a() && com.tencent.mobileqq.colornote.e.c()) {
                    ColorNoteListLayoutV2.this.D.a(view);
                    z16 = false;
                }
            } else {
                ReportController.o(null, "dc00898", "", "", "0X800A747", "0X800A747", com.tencent.mobileqq.colornote.a.b(colorNote.getServiceType()), 0, "", "", "", "");
            }
            if (z16) {
                ColorNoteListLayoutV2.this.r(m3);
            }
            ColorNoteListLayoutV2.this.l(view, colorNote);
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            ColorNote colorNote = (ColorNote) view.getTag();
            ColorNoteControllerImpl.launch(view.getContext(), colorNote);
            if (ColorNoteListLayoutV2.this.C != null) {
                ColorNoteListLayoutV2.this.C.a();
            }
            ColorNoteListLayoutV2.this.k(view, colorNote);
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public interface d {
        void a(View view);
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public static class e {

        /* renamed from: a, reason: collision with root package name */
        public View f201457a;

        /* renamed from: b, reason: collision with root package name */
        public RoundImageView f201458b;

        /* renamed from: c, reason: collision with root package name */
        public ImageView f201459c;

        /* renamed from: d, reason: collision with root package name */
        public LargeTouchAreaButton f201460d;

        /* renamed from: e, reason: collision with root package name */
        public ViewGroup f201461e;

        /* renamed from: f, reason: collision with root package name */
        public TextView f201462f;

        /* renamed from: g, reason: collision with root package name */
        public TextView f201463g;

        /* renamed from: h, reason: collision with root package name */
        public Drawable f201464h;

        /* renamed from: i, reason: collision with root package name */
        public ImageView f201465i;

        public e(View view) {
            this.f201457a = view;
            this.f201458b = (RoundImageView) view.findViewById(R.id.lxw);
            this.f201459c = (ImageView) view.findViewById(R.id.zsn);
            this.f201460d = (LargeTouchAreaButton) view.findViewById(R.id.lxx);
            this.f201461e = (ViewGroup) view.findViewById(R.id.lxy);
            this.f201462f = (TextView) view.findViewById(R.id.f166424ly2);
            this.f201463g = (TextView) view.findViewById(R.id.f166423ly1);
            this.f201465i = (ImageView) view.findViewById(R.id.zsl);
        }
    }

    public ColorNoteListLayoutV2(Context context) {
        this(context, null);
    }

    private void B(View view, int i3) {
        if (view == null) {
            return;
        }
        ColorNote colorNote = this.f201445d.get(i3);
        e eVar = new e(view);
        ColorNoteControllerImpl.getItemBuilder(colorNote).a(eVar, i3, colorNote);
        ViewGroup.LayoutParams layoutParams = eVar.f201457a.getLayoutParams();
        layoutParams.height = ViewUtils.dip2px(60.0f);
        eVar.f201457a.setLayoutParams(layoutParams);
        eVar.f201461e.setTag(colorNote);
        eVar.f201461e.setOnClickListener(new c());
        eVar.f201460d.setTag(colorNote);
        eVar.f201460d.setOnClickListener(new b());
        x(eVar, i3);
        u(eVar);
        this.f201447f.add(eVar);
    }

    private View j() {
        return LayoutInflater.from(getContext()).inflate(R.layout.e36, (ViewGroup) null, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k(View view, ColorNote colorNote) {
        Iterator<f> it = this.f201450m.iterator();
        while (it.hasNext()) {
            it.next().c(view, colorNote);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l(View view, ColorNote colorNote) {
        Iterator<f> it = this.f201450m.iterator();
        while (it.hasNext()) {
            it.next().a(view, colorNote);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int m(Object obj) {
        if (obj == null) {
            return -1;
        }
        for (int i3 = 0; i3 < this.f201445d.size(); i3++) {
            if (obj.equals(this.f201445d.get(i3))) {
                return i3;
            }
        }
        return -1;
    }

    private View n(int i3) {
        if (i3 < 0) {
            return null;
        }
        if (i3 < this.f201446e.size()) {
            return this.f201446e.get(i3);
        }
        View j3 = j();
        this.f201446e.add(j3);
        return j3;
    }

    private int o() {
        int i3 = 0;
        for (int i16 = 0; i16 < this.f201446e.size(); i16++) {
            i3 += this.f201446e.get(i16).getHeight();
        }
        return i3 + ((this.f201446e.size() - 1) * this.f201448h);
    }

    private int p(int i3, int i16, boolean z16, int i17) {
        int o16 = o();
        if (i16 >= o16) {
            return i17 / 2;
        }
        int i18 = o16 - i17;
        if (i16 <= i18) {
            int i19 = i17 / 2;
            if (i3 >= i19 && o16 - (i3 + i16) >= i19) {
                return i19;
            }
            if (i3 < i19) {
                if (z16) {
                    return i3;
                }
            } else {
                i3 = o16 - (i3 + i16);
                if (i3 < i19) {
                    if (!z16) {
                        return i3;
                    }
                }
            }
            return i17 - i3;
        }
        if (i16 > i18) {
            int i26 = (i16 - i18) / 2;
            if (z16) {
                return i3 + i26;
            }
            return (o16 - (i3 + i16)) + i26;
        }
        return 0;
    }

    private void q() {
        if (this.E == null) {
            return;
        }
        final int dip2px = ViewUtils.dip2px(60.0f);
        int measuredHeight = this.E.getMeasuredHeight();
        if (measuredHeight == 0) {
            post(new Runnable() { // from class: com.tencent.mobileqq.colornote.list.ColorNoteListLayoutV2.1
                @Override // java.lang.Runnable
                public void run() {
                    ColorNoteListLayoutV2 colorNoteListLayoutV2 = ColorNoteListLayoutV2.this;
                    colorNoteListLayoutV2.w(dip2px, colorNoteListLayoutV2.E.getMeasuredHeight());
                }
            });
        } else {
            w(dip2px, measuredHeight);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r(int i3) {
        ScrollView scrollView;
        if (i3 >= 0 && i3 < this.f201446e.size() && (scrollView = this.E) != null && scrollView.getVisibility() == 0) {
            QLog.e("ColorNoteListLayoutV2", 2, "parentScroll.getMeasuredHeight() : " + this.E.getMeasuredHeight());
            int p16 = p(this.E.getScrollY(), this.E.getMeasuredHeight(), true, this.f201446e.get(i3).getHeight() + this.f201448h);
            int p17 = p(this.E.getScrollY(), this.E.getMeasuredHeight(), false, this.f201446e.get(i3).getHeight() + this.f201448h);
            for (int i16 = 0; i16 < this.f201446e.size(); i16++) {
                View view = this.f201446e.get(i16);
                view.findViewById(R.id.lxx).setClickable(false);
                if (i16 == i3) {
                    this.f201449i.c(view);
                } else if (i16 < i3) {
                    this.f201449i.a(view, (int) view.getX(), (int) view.getY(), (int) view.getX(), (int) (view.getY() + p16));
                } else {
                    this.f201449i.a(view, (int) view.getX(), (int) view.getY(), (int) view.getX(), (int) (view.getY() - p17));
                }
            }
            this.f201449i.k(new a(i3, p16));
            this.f201449i.j();
        }
    }

    private void u(e eVar) {
        if (QQTheme.isNowThemeIsNight()) {
            eVar.f201461e.setBackground(getResources().getDrawable(R.drawable.jh9));
            eVar.f201462f.setTextColor(Color.parseColor("#FFFFFF"));
        } else {
            eVar.f201461e.setBackground(getResources().getDrawable(R.drawable.jh8));
            eVar.f201462f.setTextColor(Color.parseColor("#000000"));
        }
    }

    private void v() {
        for (int i3 = 0; i3 < this.f201447f.size(); i3++) {
            if (this.f201447f.get(i3).f201464h != null && (this.f201447f.get(i3).f201464h instanceof com.tencent.mobileqq.colornote.anim.c)) {
                ((com.tencent.mobileqq.colornote.anim.c) this.f201447f.get(i3).f201464h).stop();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w(int i3, int i16) {
        int size = (this.f201445d.size() * i3) + ((this.f201445d.size() - 1) * this.f201448h);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) getLayoutParams();
        if (size < i16) {
            layoutParams.topMargin = (i16 - size) / 2;
        } else {
            layoutParams.topMargin = 0;
        }
        setLayoutParams(layoutParams);
        if (QLog.isColorLevel()) {
            QLog.i("ColorNoteListLayoutV2", 2, "itemHeight:" + i3 + " parentHeight:" + i16 + " contentHeight:" + size);
        }
    }

    private void x(e eVar, int i3) {
        eVar.f201461e.setContentDescription(String.format(getContext().getString(R.string.zmh), Integer.valueOf(i3 + 1), Integer.valueOf(this.f201445d.size())));
        eVar.f201462f.setFocusable(true);
        eVar.f201462f.setFocusableInTouchMode(true);
        AccessibilityUtil.n(eVar.f201462f, true);
        eVar.f201463g.setFocusable(true);
        eVar.f201463g.setFocusableInTouchMode(true);
        AccessibilityUtil.n(eVar.f201463g, true);
    }

    private void z(View view, int i3) {
        if (i3 != this.f201445d.size() - 1 && view != null) {
            ((LinearLayout.LayoutParams) view.getLayoutParams()).bottomMargin = this.f201448h;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void A() {
        removeAllViews();
        this.f201446e.clear();
        v();
        this.f201447f.clear();
        if (this.f201445d.size() == 0) {
            this.C.a();
        }
        for (int i3 = 0; i3 < this.f201445d.size(); i3++) {
            View n3 = n(i3);
            addView(n3);
            B(n3, i3);
            z(n3, i3);
        }
        q();
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        h hVar;
        if (keyEvent.getKeyCode() == 4) {
            if (keyEvent.getAction() == 1 && (hVar = this.C) != null) {
                hVar.a();
            }
            return true;
        }
        return false;
    }

    public void s(ColorNote colorNote) {
        r(m(colorNote));
    }

    public void setColorNoteListListeners(List<f> list) {
        this.f201450m = list;
    }

    public void setHideListener(h hVar) {
        this.C = hVar;
    }

    public void setMargin(int i3) {
        this.f201448h = i3;
    }

    public void setParentScroll(ScrollView scrollView) {
        this.E = scrollView;
    }

    public void setRecentNoteListener(d dVar) {
        this.D = dVar;
    }

    public void t() {
        QLog.i("ColorNoteListLayoutV2", 1, "onRelease");
        this.f201445d.clear();
        this.f201446e.clear();
        v();
        this.f201447f.clear();
    }

    public void y(List<ColorNote> list) {
        if (list == null) {
            return;
        }
        this.f201445d.clear();
        this.f201445d.addAll(list);
        A();
    }

    public ColorNoteListLayoutV2(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ColorNoteListLayoutV2(Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f201445d = new ArrayList();
        this.f201446e = new ArrayList();
        this.f201447f = new ArrayList();
        this.f201448h = 0;
        this.f201449i = null;
        this.E = null;
        this.f201449i = new ColorNoteListAnimator();
        this.f201448h = ViewUtils.dip2px(12.0f);
    }
}
