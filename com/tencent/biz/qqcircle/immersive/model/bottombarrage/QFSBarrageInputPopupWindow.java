package com.tencent.biz.qqcircle.immersive.model.bottombarrage;

import android.app.Activity;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.tencent.biz.qqcircle.comment.QFSBaseInputPopupWindow;
import com.tencent.biz.qqcircle.events.QFSBarrageSwitchEvent;
import com.tencent.biz.qqcircle.immersive.utils.o;
import com.tencent.biz.qqcircle.proxy.delegate.QCircleToast;
import com.tencent.biz.qqcircle.utils.cx;
import com.tencent.biz.qqcircle.utils.h;
import com.tencent.biz.qqcircle.widgets.comment.f;
import com.tencent.biz.richframework.compat.DisplayUtil;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.richframework.text.rich.bean.RichTextPreloadConfig;
import com.tencent.richframework.text.rich.parser.RichTextEmojiParser;
import com.tencent.richframework.thread.RFWThreadManager;
import cooperation.qqcircle.helpers.QCircleSkinHelper;
import feedcloud.FeedCloudMeta$StFeed;

/* loaded from: classes4.dex */
public class QFSBarrageInputPopupWindow extends QFSBaseInputPopupWindow {

    /* renamed from: g0, reason: collision with root package name */
    private static final String f87279g0 = h.a(R.string.f1910843u);
    private LinearLayout W;
    private TextView X;
    private TextView Y;
    private ImageView Z;

    /* renamed from: a0, reason: collision with root package name */
    private boolean f87280a0;

    /* renamed from: b0, reason: collision with root package name */
    private d f87281b0;

    /* renamed from: c0, reason: collision with root package name */
    private View f87282c0;

    /* renamed from: d0, reason: collision with root package name */
    private LinearLayout f87283d0;

    /* renamed from: e0, reason: collision with root package name */
    private FrameLayout f87284e0;

    /* renamed from: f0, reason: collision with root package name */
    private FeedCloudMeta$StFeed f87285f0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class b implements TextView.OnEditorActionListener {
        b() {
        }

        @Override // android.widget.TextView.OnEditorActionListener
        public boolean onEditorAction(TextView textView, int i3, KeyEvent keyEvent) {
            boolean z16 = false;
            if (i3 == 4 || i3 == 6) {
                if (!QFSBarrageInputPopupWindow.this.Z0()) {
                    QFSBarrageInputPopupWindow.this.X0();
                    if (((QFSBaseInputPopupWindow) QFSBarrageInputPopupWindow.this).K != null) {
                        ((QFSBaseInputPopupWindow) QFSBarrageInputPopupWindow.this).K.a();
                    }
                } else {
                    QCircleToast.o(QFSBarrageInputPopupWindow.f87279g0, 0);
                }
                z16 = true;
            }
            EventCollector.getInstance().onEditorAction(textView, i3, keyEvent);
            return z16;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class c implements f.b {
        c() {
        }

        @Override // com.tencent.biz.qqcircle.widgets.comment.f.b
        public void onSoftKeyboardClosed() {
            QFSBarrageInputPopupWindow.this.k1();
        }

        @Override // com.tencent.biz.qqcircle.widgets.comment.f.b
        public void onSoftKeyboardOpened(int i3) {
            QFSBarrageInputPopupWindow.this.b1(i3);
        }
    }

    /* loaded from: classes4.dex */
    public interface d {
        void a(View view);
    }

    public QFSBarrageInputPopupWindow(@NonNull Activity activity, boolean z16) {
        super(activity);
        this.f87280a0 = z16;
        j1();
    }

    private void U0() {
        if (this.f87284e0 == null) {
            FrameLayout frameLayout = new FrameLayout(getContext());
            this.f87284e0 = frameLayout;
            frameLayout.setBackgroundColor(QCircleSkinHelper.getInstance().getColor(R.color.qvideo_skin_color_bg_default));
            this.f87284e0.addView(new View(getContext()), new FrameLayout.LayoutParams(-1, -1));
            this.f87283d0.addView(this.f87284e0, new LinearLayout.LayoutParams(-1, -1));
        }
    }

    private void V0(int i3) {
        FrameLayout frameLayout = this.f87284e0;
        if (frameLayout != null && frameLayout.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams = this.f87284e0.getLayoutParams();
            layoutParams.height = i3;
            this.f87284e0.setLayoutParams(layoutParams);
            QLog.d("QDM-QFSBarrageInputPopupWindow", 1, "[adjustBottomPlaceHolderHeight] height: " + i3);
        }
    }

    private void W0() {
        f fVar;
        if (QFSBaseInputPopupWindow.U == 0 && (fVar = this.N) != null) {
            V0(fVar.i());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void X0() {
        if (!com.tencent.biz.qqcircle.manager.d.f91547g.d() && this.Z != null) {
            QLog.d("QDM-QFSBarrageInputPopupWindow", 1, "beforeSendMsg change barrage to open");
            this.Z.performClick();
        }
    }

    private int Y0(CharSequence charSequence) {
        int i3 = 0;
        while (com.tencent.biz.qqcircle.widgets.comment.d.f93568a.matcher(charSequence).find()) {
            i3 += (r0.end() - r0.start()) - 2;
        }
        return charSequence.length() - i3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b1(int i3) {
        boolean z16 = true;
        QLog.d("QDM-QFSBarrageInputPopupWindow", 1, "onSoftKeyboardOpened");
        FrameLayout frameLayout = this.f87284e0;
        if (frameLayout == null || frameLayout.getLayoutParams() == null || this.f87284e0.getLayoutParams().height == i3) {
            z16 = false;
        }
        if (QFSBaseInputPopupWindow.U != i3 || z16) {
            QFSBaseInputPopupWindow.U = i3;
            V0(i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c1(Editable editable, String str) {
        int indexOf = str.indexOf(47);
        if (indexOf >= 0 && indexOf < str.length() - 1 && com.tencent.biz.qqcircle.widgets.comment.d.f93568a.matcher(str).find()) {
            RichTextEmojiParser.asyncParseSmiley(new RichTextPreloadConfig.TextImageSpanConfig().setIconSize(22).setVerticalAlignment(0), editable, null);
        }
    }

    private void d1() {
        f1();
        this.F.addTextChangedListener(new a());
    }

    private void e1() {
        f fVar = new f(this.E);
        this.N = fVar;
        fVar.a(new c());
    }

    private void f1() {
        this.F.setOnEditorActionListener(new b());
    }

    private void h1() {
        e0().postDelayed(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.model.bottombarrage.QFSBarrageInputPopupWindow.1
            @Override // java.lang.Runnable
            public void run() {
                if (((QFSBaseInputPopupWindow) QFSBarrageInputPopupWindow.this).E != null) {
                    ((QFSBaseInputPopupWindow) QFSBarrageInputPopupWindow.this).E.setVisibility(0);
                }
            }
        }, 200L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i1() {
        this.W.setVisibility(8);
        int Y0 = Y0(this.F.getText().toString());
        if (Y0 >= 10) {
            this.W.setVisibility(0);
            this.X.setText(Y0 + "");
            if (Y0 > 20) {
                this.X.setTextColor(getContext().getResources().getColor(R.color.f157727cb3));
            } else {
                this.X.setTextColor(getContext().getResources().getColor(R.color.f157728cb4));
            }
            this.Y.setText("/20");
        }
    }

    private void j1() {
        this.f87283d0 = (LinearLayout) this.E.findViewById(R.id.yrk);
        this.f87282c0 = this.E.findViewById(R.id.t4l);
        this.W = (LinearLayout) this.E.findViewById(R.id.f125037kz);
        this.X = (TextView) this.E.findViewById(R.id.f112576oa);
        this.Y = (TextView) this.E.findViewById(R.id.f112586ob);
        this.Z = (ImageView) this.E.findViewById(R.id.t4m);
        U0();
        this.Z.setOnClickListener(this);
        V0(QFSBaseInputPopupWindow.U);
        this.F.setPadding(cx.a(20.0f), cx.a(16.0f), cx.a(10.0f), cx.a(16.0f));
        if (this.f87280a0) {
            int dip2px = DisplayUtil.dip2px(this.E.getContext(), 54.0f);
            this.f87282c0.setPadding(dip2px, 0, dip2px, 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k1() {
        QLog.d("QDM-QFSBarrageInputPopupWindow", 1, "onSoftKeyboardClosed");
        RFWThreadManager.getUIHandler().postDelayed(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.model.bottombarrage.a
            @Override // java.lang.Runnable
            public final void run() {
                QFSBarrageInputPopupWindow.this.dismiss();
            }
        }, 100L);
    }

    private void n1() {
        int i3;
        int i16;
        int i17;
        int i18;
        if (this.Z == null) {
            QLog.d("QDM-QFSBarrageInputPopupWindow", 1, "[updateShowIcon] current barrage icon should not be null.");
            return;
        }
        boolean c16 = com.tencent.biz.qqcircle.manager.d.f91547g.c(this.f87285f0);
        QLog.d("QDM-QFSBarrageInputPopupWindow", 1, "[updateShowIcon] barrageCanShowAndSwitchOn:" + c16);
        if (c16) {
            if (o.j()) {
                ImageView imageView = this.Z;
                if (g1()) {
                    i18 = R.drawable.qvideo_skin_icon_danmu_switch_on_v2_dark;
                } else {
                    i18 = R.drawable.qvideo_skin_icon_danmu_switch_on_v2;
                }
                imageView.setImageResource(i18);
                return;
            }
            ImageView imageView2 = this.Z;
            if (g1()) {
                i17 = R.drawable.qvideo_skin_icon_switch_bulletcomment_on_dark;
            } else {
                i17 = R.drawable.qvideo_skin_icon_switch_bulletcomment_on;
            }
            imageView2.setImageResource(i17);
            return;
        }
        if (o.j()) {
            ImageView imageView3 = this.Z;
            if (g1()) {
                i16 = R.drawable.qvideo_skin_icon_danmu_switch_off_v2_dark;
            } else {
                i16 = R.drawable.qvideo_skin_icon_danmu_switch_off_v2;
            }
            imageView3.setImageResource(i16);
            return;
        }
        ImageView imageView4 = this.Z;
        if (g1()) {
            i3 = R.drawable.qvideo_skin_icon_switch_bulletcomment_off_dark;
        } else {
            i3 = R.drawable.qvideo_skin_icon_switch_bulletcomment_off;
        }
        imageView4.setImageResource(i3);
    }

    protected boolean Z0() {
        if (this.F.getText().length() < 20 || Y0(this.F.getText()) <= 20) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.biz.qqcircle.comment.QFSBaseInputPopupWindow
    public int d0() {
        return R.layout.f168659g84;
    }

    public boolean g1() {
        View view = this.f87282c0;
        if (view == null) {
            return QCircleSkinHelper.getInstance().isDarkMode();
        }
        Drawable background = view.getBackground();
        if (!(background instanceof ColorDrawable)) {
            return QCircleSkinHelper.getInstance().isDarkMode();
        }
        return QQTheme.isColorDark(((ColorDrawable) background).getColor());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.comment.QFSBaseInputPopupWindow
    public void l0() {
        super.l0();
        d1();
    }

    public void l1(d dVar) {
        this.f87281b0 = dVar;
    }

    public void m1(FeedCloudMeta$StFeed feedCloudMeta$StFeed, boolean z16) {
        int i3;
        super.show();
        ImageView imageView = this.Z;
        if (z16) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        imageView.setVisibility(i3);
        e1();
        e0().post(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.model.bottombarrage.b
            @Override // java.lang.Runnable
            public final void run() {
                QFSBarrageInputPopupWindow.this.s0();
            }
        });
        h1();
        D0(this.F, 200);
        W0();
        this.f87285f0 = feedCloudMeta$StFeed;
        n1();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        int id5 = view.getId();
        if (id5 == R.id.jha) {
            D0(this.F, 0);
        } else if (id5 == R.id.aiz) {
            if (Z0()) {
                QCircleToast.o(f87279g0, 0);
            } else {
                X0();
                QFSBaseInputPopupWindow.b bVar = this.K;
                if (bVar != null) {
                    bVar.a();
                }
            }
        } else if (id5 == R.id.t4m) {
            int i3 = 1;
            boolean z16 = !com.tencent.biz.qqcircle.manager.d.b().d();
            com.tencent.biz.qqcircle.manager.d.b().h(z16);
            n1();
            SimpleEventBus simpleEventBus = SimpleEventBus.getInstance();
            if (!z16) {
                i3 = 2;
            }
            simpleEventBus.dispatchEvent(new QFSBarrageSwitchEvent(i3));
            boolean e16 = o.e(this.f87285f0);
            int i16 = R.string.f1902141h;
            if (e16) {
                if (!z16) {
                    i16 = R.string.f1902241i;
                }
                QCircleToast.h(i16, 0);
            } else {
                if (!z16) {
                    i16 = R.string.f1902041g;
                }
                QCircleToast.h(i16, 0);
            }
            k1();
            d dVar = this.f87281b0;
            if (dVar != null) {
                dVar.a(view);
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.biz.qqcircle.comment.QFSBaseInputPopupWindow
    protected void m0(View view) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class a implements TextWatcher {

        /* renamed from: d, reason: collision with root package name */
        private int f87286d = 0;

        /* renamed from: e, reason: collision with root package name */
        private int f87287e = 0;

        a() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            if (editable == null) {
                return;
            }
            ((QFSBaseInputPopupWindow) QFSBarrageInputPopupWindow.this).F.removeTextChangedListener(this);
            if (QFSBarrageInputPopupWindow.this.Z0()) {
                int i3 = this.f87286d;
                QFSBarrageInputPopupWindow.this.C0(editable.delete(i3, this.f87287e + i3));
                ((QFSBaseInputPopupWindow) QFSBarrageInputPopupWindow.this).F.addTextChangedListener(this);
                QCircleToast.o(QFSBarrageInputPopupWindow.f87279g0, 0);
                return;
            }
            String obj = editable.toString();
            int i16 = this.f87286d;
            QFSBarrageInputPopupWindow.this.c1(editable, obj.substring(i16, this.f87287e + i16));
            QFSBarrageInputPopupWindow.this.i1();
            this.f87286d = 0;
            this.f87287e = 0;
            ((QFSBaseInputPopupWindow) QFSBarrageInputPopupWindow.this).F.addTextChangedListener(this);
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
            if (charSequence == null) {
                return;
            }
            this.f87286d = i3;
            this.f87287e = i17;
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
        }
    }
}
