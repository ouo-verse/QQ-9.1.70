package com.tencent.mobileqq.gamecenter.qa.view;

import android.app.Activity;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.Nullable;
import android.text.Editable;
import android.text.Layout;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.GestureDetector;
import android.view.InflateException;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.tencent.aelight.camera.qqstory.api.IAELaunchEditPic;
import com.tencent.aelight.camera.util.api.IQIMShortVideoUtil;
import com.tencent.common.config.pad.DeviceType;
import com.tencent.common.config.pad.PadUtil;
import com.tencent.image.AbstractGifImage;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.activity.photo.album.QAlbumConstants;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.gamecenter.qa.api.IQQGameStrategyApi;
import com.tencent.mobileqq.gamecenter.qa.editor.span.BoldSpan;
import com.tencent.mobileqq.gamecenter.qa.editor.span.UnderlineSpan;
import com.tencent.mobileqq.gamecenter.qa.editor.util.Selection;
import com.tencent.mobileqq.gamecenter.qa.fragment.QQGameStrategyVideoFragment;
import com.tencent.mobileqq.gamecenter.qa.model.GameQALinkCardData;
import com.tencent.mobileqq.gamecenter.qa.model.GameQuestionUserInfo;
import com.tencent.mobileqq.gamecenter.qa.model.GameStrategyPic;
import com.tencent.mobileqq.gamecenter.qa.model.GameStrategyVideo;
import com.tencent.mobileqq.gamecenter.qa.model.LinkType;
import com.tencent.mobileqq.gamecenter.qa.util.GameQAUtil;
import com.tencent.mobileqq.gamecenter.qa.util.k;
import com.tencent.mobileqq.gamecenter.qa.view.GameStrategyEditTextView;
import com.tencent.mobileqq.gamecenter.qa.view.GameStrategyImageSpan;
import com.tencent.mobileqq.gamecenter.qa.view.s;
import com.tencent.mobileqq.qqalbum.IPicToJpg;
import com.tencent.mobileqq.qqgamepub.api.IQQGameTempRelyApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mtt.hippy.views.scroll.HippyScrollViewEventHelper;
import com.tencent.qmethod.pandoraex.monitor.ClipboardMonitor;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.InputMethodUtil;
import com.tencent.util.WeakReferenceHandler;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.calloutpopupwindow.CalloutPopupWindow;
import com.tencent.widget.immersive.ImmersiveUtils;
import cooperation.peak.PeakConstants;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.regex.Pattern;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import wd1.c;

/* compiled from: P */
/* loaded from: classes12.dex */
public abstract class bh implements Handler.Callback {
    private static Pattern M0 = Pattern.compile("\\{\\{pic:.*\\}\\}");
    private static Pattern N0 = Pattern.compile("\\{\\{link:.*\\}\\}");
    private static Pattern O0 = Pattern.compile("\\{\\{video:.*\\}\\}");
    private wd1.b A0;
    private wd1.e B0;
    protected RelativeLayout C;
    private int C0;
    protected View D;
    private boolean D0;
    protected ImageView E;
    private GameStrategyImageSpan E0;
    protected ViewGroup F;
    private boolean F0;
    protected QQProgressDialog G;
    public int G0;
    protected Context I;
    protected int J;
    protected boolean J0;
    protected boolean K;
    protected LinearLayout L;
    protected boolean M;
    private TextView N;
    private GameStrategyNestedScroll P;
    private ImageView Q;
    private ImageView R;
    private ImageView S;
    private ImageView T;
    private ViewGroup U;
    private ImageView V;
    private TextView W;
    private ImageView X;
    private ImageView Y;
    private ViewGroup Z;

    /* renamed from: a0, reason: collision with root package name */
    private ViewGroup f213044a0;

    /* renamed from: b0, reason: collision with root package name */
    private ImageButton f213045b0;

    /* renamed from: c0, reason: collision with root package name */
    private ImageButton f213046c0;

    /* renamed from: d0, reason: collision with root package name */
    private ImageButton f213048d0;

    /* renamed from: e0, reason: collision with root package name */
    private ImageButton f213050e0;

    /* renamed from: f0, reason: collision with root package name */
    private ImageButton f213052f0;

    /* renamed from: g0, reason: collision with root package name */
    private ImageButton f213053g0;

    /* renamed from: h, reason: collision with root package name */
    protected View f213054h;

    /* renamed from: h0, reason: collision with root package name */
    private ImageButton f213055h0;

    /* renamed from: i, reason: collision with root package name */
    protected GameStrategyEditTextView f213056i;

    /* renamed from: i0, reason: collision with root package name */
    private ImageButton f213057i0;

    /* renamed from: j0, reason: collision with root package name */
    private ImageView f213058j0;

    /* renamed from: k0, reason: collision with root package name */
    private Button f213059k0;

    /* renamed from: l0, reason: collision with root package name */
    private Button f213060l0;

    /* renamed from: m, reason: collision with root package name */
    protected Button f213061m;

    /* renamed from: m0, reason: collision with root package name */
    private ViewGroup f213062m0;

    /* renamed from: n0, reason: collision with root package name */
    private ImageView f213063n0;

    /* renamed from: o0, reason: collision with root package name */
    private View f213064o0;

    /* renamed from: p0, reason: collision with root package name */
    private ViewGroup f213065p0;

    /* renamed from: q0, reason: collision with root package name */
    private GameStrategyPanelLayout f213066q0;

    /* renamed from: t0, reason: collision with root package name */
    private GestureDetector f213069t0;

    /* renamed from: u0, reason: collision with root package name */
    private Activity f213070u0;

    /* renamed from: v0, reason: collision with root package name */
    private x f213071v0;

    /* renamed from: w0, reason: collision with root package name */
    private CalloutPopupWindow f213072w0;

    /* renamed from: x0, reason: collision with root package name */
    private boolean f213073x0;

    /* renamed from: y0, reason: collision with root package name */
    protected boolean f213074y0;

    /* renamed from: z0, reason: collision with root package name */
    private boolean f213075z0;

    /* renamed from: d, reason: collision with root package name */
    protected final com.tencent.mobileqq.gamecenter.qa.manager.b f213047d = new com.tencent.mobileqq.gamecenter.qa.manager.b();

    /* renamed from: e, reason: collision with root package name */
    private final CopyOnWriteArraySet<String> f213049e = new CopyOnWriteArraySet<>();

    /* renamed from: f, reason: collision with root package name */
    protected int f213051f = 0;
    protected WeakReferenceHandler H = new WeakReferenceHandler(Looper.getMainLooper(), this);

    /* renamed from: r0, reason: collision with root package name */
    private boolean f213067r0 = true;

    /* renamed from: s0, reason: collision with root package name */
    private boolean f213068s0 = true;
    private TextWatcher H0 = new k();
    private c.b I0 = new o();
    GameStrategyEditTextView.f K0 = new p();
    private wd1.d L0 = new c();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            bh.this.e2();
            bh.this.g0();
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            bh.this.e2();
            ((IQQGameStrategyApi) QRoute.api(IQQGameStrategyApi.class)).openGameQAQuoteArticle(bh.this.A0(), 1001, bh.this.B0(), bh.this.J0());
            bh.this.J1();
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class d extends GestureDetector.SimpleOnGestureListener {
        d() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent motionEvent) {
            bh bhVar = bh.this;
            bhVar.G0 = bhVar.P.getScrollY();
            return super.onDown(motionEvent);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f16, float f17) {
            if (Math.abs(f16) < Math.abs(f17) && Math.abs(f17) > Utils.n(10.0f, bh.this.E0().getResources())) {
                bh.this.f213056i.V();
                bh.this.f213056i.W(motionEvent2.getX(), motionEvent2.getY() + bh.this.P.getScrollY(), true);
            }
            QLog.d("QQGameStrategyBaseControl", 2, HippyScrollViewEventHelper.EVENT_TYPE_SCROLL, " mContentEditSv.getHeight():", Integer.valueOf(bh.this.P.getHeight()), " mContentEditSv top", Integer.valueOf(bh.this.P.getTop()), " mContentEditSv scrollY:", Integer.valueOf(bh.this.P.getScrollY()));
            return super.onScroll(motionEvent, motionEvent2, f16, f17);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onSingleTapUp(MotionEvent motionEvent) {
            if (motionEvent.getY() > bh.this.f213056i.getBottom()) {
                bh.this.e0();
                return true;
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class e implements View.OnScrollChangeListener {
        e() {
        }

        @Override // android.view.View.OnScrollChangeListener
        public void onScrollChange(View view, int i3, int i16, int i17, int i18) {
            if (bh.this.P.getScrollY() - bh.this.f213056i.Q() > ViewUtils.getScreenHeight() * 0.6f || bh.this.P.getScrollY() == 0) {
                InputMethodUtil.hide(bh.this.f213056i);
                QLog.d("QQGameStrategyBaseControl", 2, "onScrollChange hide inputMethod");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class f implements View.OnTouchListener {
        f() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            return bh.this.f213069t0.onTouchEvent(motionEvent);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class g implements View.OnFocusChangeListener {
        g() {
        }

        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z16) {
            bh bhVar = bh.this;
            bhVar.M = z16;
            bhVar.v2(true, bhVar.K);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class h implements GameStrategyEditTextView.e {
        h() {
        }

        @Override // com.tencent.mobileqq.gamecenter.qa.view.GameStrategyEditTextView.e
        public void a() {
            if (bh.this.F0) {
                bh.this.B0.b(com.tencent.mobileqq.gamecenter.qa.editor.effect.h.FONTSIZE, Integer.valueOf((int) bh.this.f213056i.getTextSize()));
                bh.this.B0.b(com.tencent.mobileqq.gamecenter.qa.editor.effect.h.ALIGNMENT, Layout.Alignment.ALIGN_NORMAL);
                wd1.e eVar = bh.this.B0;
                com.tencent.mobileqq.gamecenter.qa.editor.effect.g<Boolean, UnderlineSpan> gVar = com.tencent.mobileqq.gamecenter.qa.editor.effect.h.UNDERLINE;
                Boolean bool = Boolean.FALSE;
                eVar.b(gVar, bool);
                bh.this.B0.b(com.tencent.mobileqq.gamecenter.qa.editor.effect.h.BOLD, bool);
                bh.this.B0.b(com.tencent.mobileqq.gamecenter.qa.editor.effect.h.ITALIC, bool);
                bh.this.B0.b(com.tencent.mobileqq.gamecenter.qa.editor.effect.h.NUMBER, bool);
                bh.this.B0.b(com.tencent.mobileqq.gamecenter.qa.editor.effect.h.BULLET, bool);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class i implements GameStrategyEditTextView.d {
        i() {
        }

        @Override // com.tencent.mobileqq.gamecenter.qa.view.GameStrategyEditTextView.d
        public void a(MenuItem menuItem) {
            if (menuItem.getItemId() == 100002) {
                bh.this.B0.b(com.tencent.mobileqq.gamecenter.qa.editor.effect.h.ITALIC, Boolean.TRUE);
            } else if (menuItem.getItemId() == 100001) {
                bh.this.B0.b(com.tencent.mobileqq.gamecenter.qa.editor.effect.h.BOLD, Boolean.TRUE);
            } else if (menuItem.getItemId() == 100003) {
                bh.this.B0.b(com.tencent.mobileqq.gamecenter.qa.editor.effect.h.UNDERLINE, Boolean.TRUE);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class j implements ActionSheet.OnButtonClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ ActionSheet f213085d;

        j(ActionSheet actionSheet) {
            this.f213085d = actionSheet;
        }

        @Override // com.tencent.widget.ActionSheet.OnButtonClickListener
        public void onClick(View view, int i3) {
            if (view == null) {
                this.f213085d.dismiss();
                return;
            }
            String content = this.f213085d.getContent(i3);
            if (content == null) {
                this.f213085d.dismiss();
                return;
            }
            if (content.equals(view.getResources().getString(R.string.h3s))) {
                bh.this.X1();
            } else if (content.equals(view.getResources().getString(R.string.f171082ms))) {
                bh.this.y0();
            }
            this.f213085d.dismiss();
            bh.this.j0(true);
            GameQAUtil.w(bh.this.A0().getIntent().getIntExtra("miniGameAppId", 0));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class l implements k.b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ GameStrategyImageSpan f213088a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f213089b;

        l(GameStrategyImageSpan gameStrategyImageSpan, String str) {
            this.f213088a = gameStrategyImageSpan;
            this.f213089b = str;
        }

        @Override // com.tencent.mobileqq.gamecenter.qa.util.k.b
        public void onFail(int i3) {
            this.f213088a.J(2);
            QLog.i("QQGameStrategyBaseControl", 1, "[doUploadPic] onFail,filePath:" + this.f213089b + ",errCode:" + i3);
        }

        @Override // com.tencent.mobileqq.gamecenter.qa.util.k.b
        public void onProgress(float f16) {
            this.f213088a.y(f16, null);
        }

        @Override // com.tencent.mobileqq.gamecenter.qa.util.k.b
        public void onSuccess(String str) {
            this.f213088a.E(str);
            this.f213088a.J(1);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class n implements k.b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ GameStrategyImageSpan f213097a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f213098b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f213099c;

        n(GameStrategyImageSpan gameStrategyImageSpan, String str, String str2) {
            this.f213097a = gameStrategyImageSpan;
            this.f213098b = str;
            this.f213099c = str2;
        }

        @Override // com.tencent.mobileqq.gamecenter.qa.util.k.b
        public void onFail(int i3) {
            QLog.i("QQGameStrategyBaseControl", 1, "[doUploadCompressVideo] onFail:" + this.f213098b + ",errorCode:" + i3);
            this.f213097a.J(2);
            bh.this.c0(this.f213098b, this.f213099c);
        }

        @Override // com.tencent.mobileqq.gamecenter.qa.util.k.b
        public void onProgress(float f16) {
            this.f213097a.y(f16, null);
        }

        @Override // com.tencent.mobileqq.gamecenter.qa.util.k.b
        public void onSuccess(String str) {
            long n3 = com.tencent.mobileqq.gamecenter.qa.util.k.n(this.f213098b);
            QLog.i("QQGameStrategyBaseControl", 1, "[doUploadCompressVideo] onSuccess,videoUrl:" + str + ",compressPath:" + this.f213098b + ",videoDuration:" + n3);
            this.f213097a.J(1);
            this.f213097a.I(str);
            this.f213097a.H((long) Math.ceil((((double) n3) * 1.0d) / 1000.0d));
            bh.this.c0(this.f213098b, this.f213099c);
        }
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    class o implements c.b {
        o() {
        }

        @Override // wd1.c.b
        public void a(int i3) {
            boolean z16;
            bh bhVar = bh.this;
            if (i3 > 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            bhVar.w2(z16);
        }

        @Override // wd1.c.b
        public void b(int i3) {
            boolean z16;
            bh bhVar = bh.this;
            if (i3 > 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            bhVar.x2(z16);
        }
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    class p implements GameStrategyEditTextView.f {
        p() {
        }

        @Override // com.tencent.mobileqq.gamecenter.qa.view.GameStrategyEditTextView.f
        public ab a(ab abVar) {
            bh bhVar = bh.this;
            com.tencent.mobileqq.gamecenter.qa.manager.b bVar = bhVar.f213047d;
            Activity A0 = bhVar.A0();
            bh bhVar2 = bh.this;
            return bVar.g(A0, bhVar2.f213056i, abVar, bhVar2.f213074y0, bhVar2.K, bhVar2.H0());
        }

        @Override // com.tencent.mobileqq.gamecenter.qa.view.GameStrategyEditTextView.f
        public com.tencent.mobileqq.gamecenter.qa.view.w b(com.tencent.mobileqq.gamecenter.qa.view.w wVar) {
            return wVar.f();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class q implements View.OnClickListener {
        q() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (!bh.this.k0()) {
                bh.this.j0(true);
                GameQAUtil.w(bh.this.A0().getIntent().getIntExtra("miniGameAppId", 0));
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class r implements View.OnClickListener {
        r() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            bh.this.j0(true);
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class s implements View.OnClickListener {
        s() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            bh.this.j0(true);
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class t implements View.OnClickListener {
        t() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            bh.this.W1();
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class u implements View.OnClickListener {
        u() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            bh.this.e2();
            bh.this.f0();
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class v implements View.OnClickListener {
        v() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            bh.this.e2();
            bh.this.i0();
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    static class w {

        /* renamed from: a, reason: collision with root package name */
        List<GameStrategyPic> f213109a = new ArrayList();

        /* renamed from: b, reason: collision with root package name */
        List<GameStrategyVideo> f213110b = new ArrayList();

        /* renamed from: c, reason: collision with root package name */
        List<GameQALinkCardData> f213111c = new ArrayList();

        /* renamed from: d, reason: collision with root package name */
        String f213112d;

        w() {
        }
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    public interface x {
        void a(boolean z16);
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    static class y implements Comparable<y> {

        /* renamed from: d, reason: collision with root package name */
        Object f213113d;

        /* renamed from: e, reason: collision with root package name */
        int f213114e;

        /* renamed from: f, reason: collision with root package name */
        int f213115f;

        public y(Object obj, int i3, int i16) {
            this.f213113d = obj;
            this.f213114e = i3;
            this.f213115f = i16;
        }

        @Override // java.lang.Comparable
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public int compareTo(y yVar) {
            return yVar.f213114e - this.f213114e;
        }
    }

    public bh(Activity activity, Context context, int i3, boolean z16) {
        boolean z17;
        this.f213070u0 = activity;
        this.I = context;
        this.J = i3;
        this.K = z16;
        if (i3 == 0) {
            z17 = true;
        } else {
            z17 = false;
        }
        this.f213074y0 = z17;
        this.D0 = i3 == 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void A1(String str, String str2, GameStrategyImageSpan gameStrategyImageSpan, int i3) {
        if (i3 == 1) {
            x0(str, str2, gameStrategyImageSpan);
            return;
        }
        if (i3 == 2) {
            u0(gameStrategyImageSpan);
        } else if (i3 == 0 && this.f213049e.contains(str)) {
            ((IQQGameTempRelyApi) QRoute.api(IQQGameTempRelyApi.class)).cancelCompressTask(str);
            this.f213049e.remove(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void B1(final String str, final String str2) {
        if (d1()) {
            t2();
            QLog.i("QQGameStrategyBaseControl", 1, "[showVideoFrameAndUploadVideo] video selected max,just return");
        } else {
            final GameStrategyImageSpan b16 = GameStrategyImageSpan.e("", C0(), str, "", 0, 0).b(this.f213056i);
            b16.C(new GameStrategyImageSpan.a() { // from class: com.tencent.mobileqq.gamecenter.qa.view.aw
                @Override // com.tencent.mobileqq.gamecenter.qa.view.GameStrategyImageSpan.a
                public final void onClick(int i3) {
                    bh.this.A1(str2, str, b16, i3);
                }
            });
            x0(str2, str, b16);
        }
    }

    private int C0() {
        return (this.f213056i.getWidth() - this.f213056i.getPaddingLeft()) - this.f213056i.getPaddingRight();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void C1(View view) {
        Rect rect = new Rect();
        view.getWindowVisibleDisplayFrame(rect);
        int height = rect.height();
        if (this.C0 == 0) {
            this.C0 = height;
        }
        int i3 = this.C0;
        if (height == i3) {
            return;
        }
        if (i3 - height > 200) {
            P1();
        }
        this.C0 = height;
    }

    private void D1() {
        if (S0() || this.f213055h0.isSelected() || this.B0 == null) {
            return;
        }
        this.f213056i.X();
        this.f213056i.f0();
        int selectionStart = this.f213056i.getSelectionStart();
        int selectionEnd = this.f213056i.getSelectionEnd();
        Spannable N = this.f213056i.N();
        this.f213056i.setBackDelete(false);
        boolean z16 = !this.f213055h0.isSelected();
        if (z16) {
            a2(false);
            c2(false);
        }
        Z1(z16);
        this.B0.b(com.tencent.mobileqq.gamecenter.qa.editor.effect.h.ALIGNMENT, Layout.Alignment.ALIGN_CENTER);
        S1(10, z16);
        this.f213056i.Z(N, this.f213056i.N(), selectionStart, selectionEnd, this.f213056i.getSelectionStart(), this.f213056i.getSelectionEnd());
        this.f213056i.K();
        this.f213056i.e0();
    }

    private void E1(boolean z16) {
        if (S0() || this.f213053g0.isSelected() || this.B0 == null) {
            return;
        }
        this.f213056i.X();
        this.f213056i.f0();
        int selectionStart = this.f213056i.getSelectionStart();
        int selectionEnd = this.f213056i.getSelectionEnd();
        Spannable N = this.f213056i.N();
        this.f213056i.setBackDelete(false);
        boolean z17 = !this.f213053g0.isSelected();
        if (z17) {
            Z1(false);
            c2(false);
        }
        a2(z17);
        this.B0.b(com.tencent.mobileqq.gamecenter.qa.editor.effect.h.ALIGNMENT, Layout.Alignment.ALIGN_NORMAL);
        S1(10, z17);
        int selectionStart2 = this.f213056i.getSelectionStart();
        int selectionEnd2 = this.f213056i.getSelectionEnd();
        Spannable N2 = this.f213056i.N();
        if (!z16) {
            this.f213056i.Z(N, N2, selectionStart, selectionEnd, selectionStart2, selectionEnd2);
        }
        this.f213056i.K();
        this.f213056i.e0();
    }

    private void F1() {
        if (S0() || this.f213057i0.isSelected() || this.B0 == null) {
            return;
        }
        this.f213056i.X();
        this.f213056i.f0();
        int selectionStart = this.f213056i.getSelectionStart();
        int selectionEnd = this.f213056i.getSelectionEnd();
        Spannable N = this.f213056i.N();
        this.f213056i.setBackDelete(false);
        boolean z16 = !this.f213057i0.isSelected();
        if (z16) {
            a2(false);
            Z1(false);
        }
        c2(z16);
        this.B0.b(com.tencent.mobileqq.gamecenter.qa.editor.effect.h.ALIGNMENT, Layout.Alignment.ALIGN_OPPOSITE);
        S1(10, z16);
        this.f213056i.Z(N, this.f213056i.N(), selectionStart, selectionEnd, this.f213056i.getSelectionStart(), this.f213056i.getSelectionEnd());
        this.f213056i.K();
        this.f213056i.e0();
    }

    private void G1() {
        if (S0()) {
            return;
        }
        this.f213056i.X();
        this.f213056i.f0();
        int selectionStart = this.f213056i.getSelectionStart();
        int selectionEnd = this.f213056i.getSelectionEnd();
        Spannable N = this.f213056i.N();
        this.f213056i.setBackDelete(false);
        boolean z16 = !this.f213045b0.isSelected();
        d2(z16);
        this.B0.b(com.tencent.mobileqq.gamecenter.qa.editor.effect.h.BOLD, Boolean.valueOf(z16));
        S1(1, z16);
        this.f213056i.Z(N, this.f213056i.N(), selectionStart, selectionEnd, this.f213056i.getSelectionStart(), this.f213056i.getSelectionEnd());
        this.f213056i.K();
        this.f213056i.e0();
    }

    private void H1(boolean z16) {
        if (S0() || this.f213060l0.isSelected() || this.B0 == null) {
            return;
        }
        this.f213056i.X();
        this.f213056i.f0();
        int selectionStart = this.f213056i.getSelectionStart();
        int selectionEnd = this.f213056i.getSelectionEnd();
        Spannable N = this.f213056i.N();
        this.f213056i.setBackDelete(false);
        h2(false);
        g2(true);
        this.B0.b(com.tencent.mobileqq.gamecenter.qa.editor.effect.h.FONTSIZE, Integer.valueOf((int) this.f213056i.getTextSize()));
        S1(8, true);
        int selectionStart2 = this.f213056i.getSelectionStart();
        int selectionEnd2 = this.f213056i.getSelectionEnd();
        Spannable N2 = this.f213056i.N();
        if (!z16) {
            this.f213056i.Z(N, N2, selectionStart, selectionEnd, selectionStart2, selectionEnd2);
        }
        Selection S = this.f213056i.S();
        if (S.getMEnd() > S.getMStart()) {
            BoldSpan[] boldSpanArr = (BoldSpan[]) this.f213056i.getEditableText().getSpans(S.getMStart(), S.getMEnd(), BoldSpan.class);
            if (boldSpanArr != null) {
                for (BoldSpan boldSpan : boldSpanArr) {
                    this.f213056i.getEditableText().removeSpan(boldSpan);
                }
            }
            d2(false);
        }
        this.B0.b(com.tencent.mobileqq.gamecenter.qa.editor.effect.h.BOLD, Boolean.FALSE);
        this.f213056i.K();
        this.f213056i.e0();
    }

    private void I1() {
        if (S0() || this.f213059k0.isSelected() || this.B0 == null) {
            return;
        }
        this.f213056i.X();
        this.f213056i.f0();
        int selectionStart = this.f213056i.getSelectionStart();
        int selectionEnd = this.f213056i.getSelectionEnd();
        Spannable N = this.f213056i.N();
        this.f213056i.setBackDelete(false);
        h2(true);
        g2(false);
        this.B0.b(com.tencent.mobileqq.gamecenter.qa.editor.effect.h.FONTSIZE, Integer.valueOf((int) ((this.f213056i.getTextSize() * 17.0f) / 16.0f)));
        Selection S = this.f213056i.S();
        if (S.getMEnd() > S.getMStart()) {
            this.f213056i.getEditableText().setSpan(new BoldSpan(), S.getMStart(), S.getMEnd(), 34);
            d2(true);
        }
        this.B0.b(com.tencent.mobileqq.gamecenter.qa.editor.effect.h.BOLD, Boolean.TRUE);
        S1(7, true);
        int selectionStart2 = this.f213056i.getSelectionStart();
        int selectionEnd2 = this.f213056i.getSelectionEnd();
        this.f213056i.Z(N, this.f213056i.N(), selectionStart, selectionEnd, selectionStart2, selectionEnd2);
        this.f213056i.K();
        this.f213056i.e0();
    }

    private void L1() {
        if (S0()) {
            return;
        }
        this.f213056i.X();
        this.f213056i.f0();
        int selectionStart = this.f213056i.getSelectionStart();
        int selectionEnd = this.f213056i.getSelectionEnd();
        Spannable N = this.f213056i.N();
        this.f213056i.setBackDelete(false);
        boolean z16 = !this.f213046c0.isSelected();
        i2(z16);
        this.B0.b(com.tencent.mobileqq.gamecenter.qa.editor.effect.h.ITALIC, Boolean.valueOf(z16));
        S1(2, z16);
        this.f213056i.Z(N, this.f213056i.N(), selectionStart, selectionEnd, this.f213056i.getSelectionStart(), this.f213056i.getSelectionEnd());
        this.f213056i.K();
        this.f213056i.e0();
    }

    private void M1() {
        wd1.b bVar = this.A0;
        if (bVar != null) {
            bVar.e();
        }
    }

    private List<String> N0(@NonNull List<String> list) {
        ArrayList arrayList = new ArrayList();
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(u2(it.next()));
        }
        return arrayList;
    }

    private void N1() {
        if (S0() || this.B0 == null) {
            return;
        }
        this.f213056i.X();
        this.f213056i.f0();
        int selectionStart = this.f213056i.getSelectionStart();
        int selectionEnd = this.f213056i.getSelectionEnd();
        Spannable N = this.f213056i.N();
        this.f213056i.setBackDelete(false);
        boolean z16 = !this.f213048d0.isSelected();
        if (z16) {
            l2(false);
        }
        k2(z16);
        this.B0.b(com.tencent.mobileqq.gamecenter.qa.editor.effect.h.BULLET, Boolean.valueOf(z16));
        S1(9, z16);
        this.f213056i.Z(N, this.f213056i.N(), selectionStart, selectionEnd, this.f213056i.getSelectionStart(), this.f213056i.getSelectionEnd());
        this.f213056i.K();
        this.f213056i.e0();
    }

    private void O1() {
        if (S0() || this.B0 == null) {
            return;
        }
        this.f213056i.X();
        this.f213056i.f0();
        int selectionStart = this.f213056i.getSelectionStart();
        int selectionEnd = this.f213056i.getSelectionEnd();
        Spannable N = this.f213056i.N();
        this.f213056i.setBackDelete(false);
        boolean z16 = !this.f213050e0.isSelected();
        if (z16) {
            k2(false);
        }
        l2(z16);
        this.B0.b(com.tencent.mobileqq.gamecenter.qa.editor.effect.h.NUMBER, Boolean.valueOf(z16));
        S1(10, z16);
        this.f213056i.Z(N, this.f213056i.N(), selectionStart, selectionEnd, this.f213056i.getSelectionStart(), this.f213056i.getSelectionEnd());
        this.f213056i.K();
        this.f213056i.e0();
    }

    private void P1() {
        QLog.d("QQGameStrategyBaseControl", 1, "onSoftKeyboardShow");
        ViewGroup viewGroup = this.Z;
        if (viewGroup != null && viewGroup.getVisibility() == 0) {
            this.H.removeMessages(258);
            this.f213065p0.setVisibility(4);
            this.H.removeMessages(259);
            this.H.sendEmptyMessage(259);
            T0();
        }
    }

    private void Q1() {
        if (this.f213075z0) {
            T0();
            InputMethodUtil.show(this.f213056i);
            this.f213056i.requestFocus();
        } else {
            QLog.d("QQGameStrategyBaseControl", 1, "showStylePanel");
            InputMethodUtil.hide(this.f213056i);
            this.H.removeMessages(258);
            this.H.sendEmptyMessageDelayed(258, 200L);
        }
        R1(this.f213075z0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean S0() {
        Selection S = this.f213056i.S();
        if (S.getMEnd() > S.getMStart()) {
            String obj = this.f213056i.getEditableText().toString();
            if (!TextUtils.isEmpty(obj) && obj.length() >= S.getMStart() && obj.length() >= S.getMEnd()) {
                String substring = obj.substring(S.getMStart(), S.getMEnd());
                if (M0.matcher(substring).find() || O0.matcher(substring).find() || N0.matcher(substring).find()) {
                    return true;
                }
                return false;
            }
            return false;
        }
        return false;
    }

    private void T0() {
        QLog.d("QQGameStrategyBaseControl", 1, "hideStylePanel");
        this.V.setImageResource(R.drawable.f160783mw4);
        this.W.setText("\u683c\u5f0f");
        this.Z.setVisibility(8);
        this.f213075z0 = false;
    }

    private void T1() {
        if (S0()) {
            return;
        }
        this.f213056i.X();
        this.f213056i.f0();
        int selectionStart = this.f213056i.getSelectionStart();
        int selectionEnd = this.f213056i.getSelectionEnd();
        Spannable N = this.f213056i.N();
        this.f213056i.setBackDelete(false);
        boolean z16 = !this.f213052f0.isSelected();
        n2(z16);
        this.B0.b(com.tencent.mobileqq.gamecenter.qa.editor.effect.h.UNDERLINE, Boolean.valueOf(z16));
        S1(3, z16);
        this.f213056i.Z(N, this.f213056i.N(), selectionStart, selectionEnd, this.f213056i.getSelectionStart(), this.f213056i.getSelectionEnd());
        this.f213056i.K();
        this.f213056i.e0();
    }

    private void U0(View view) {
        int i3;
        ImageView imageView = (ImageView) view.findViewById(R.id.f88814y3);
        this.R = imageView;
        imageView.setOnClickListener(new u());
        this.f213062m0 = (ViewGroup) view.findViewById(R.id.f88884y_);
        ImageView imageView2 = (ImageView) view.findViewById(R.id.f88904yb);
        this.S = imageView2;
        imageView2.setOnClickListener(new v());
        ImageView imageView3 = (ImageView) view.findViewById(R.id.f88844y6);
        this.T = imageView3;
        imageView3.setOnClickListener(new a());
        this.f213058j0 = (ImageView) view.findViewById(R.id.f88874y9);
        view.findViewById(R.id.f88894ya);
        this.f213058j0.setOnClickListener(new b());
        ViewGroup viewGroup = this.f213062m0;
        if (this.f213074y0) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        viewGroup.setVisibility(i3);
        this.E = (ImageView) view.findViewById(R.id.f88804y2);
        this.F = (ViewGroup) view.findViewById(R.id.f88624xk);
        ViewGroup viewGroup2 = (ViewGroup) view.findViewById(R.id.f89124yx);
        this.U = viewGroup2;
        viewGroup2.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.gamecenter.qa.view.ba
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                bh.this.k1(view2);
            }
        });
        this.V = (ImageView) view.findViewById(R.id.f89114yw);
        this.W = (TextView) view.findViewById(R.id.f89134yy);
        ViewGroup viewGroup3 = (ViewGroup) view.findViewById(R.id.f224303p);
        this.Z = viewGroup3;
        viewGroup3.setVisibility(8);
        this.f213075z0 = false;
        this.f213044a0 = (ViewGroup) view.findViewById(R.id.f224503r);
        ImageButton imageButton = (ImageButton) view.findViewById(R.id.f164652td1);
        this.f213045b0 = imageButton;
        imageButton.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.gamecenter.qa.view.be
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                bh.this.l1(view2);
            }
        });
        ImageButton imageButton2 = (ImageButton) view.findViewById(R.id.tex);
        this.f213046c0 = imageButton2;
        imageButton2.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.gamecenter.qa.view.bf
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                bh.this.p1(view2);
            }
        });
        ImageButton imageButton3 = (ImageButton) view.findViewById(R.id.thl);
        this.f213052f0 = imageButton3;
        imageButton3.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.gamecenter.qa.view.bg
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                bh.this.q1(view2);
            }
        });
        Button button = (Button) view.findViewById(R.id.thk);
        this.f213059k0 = button;
        button.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.gamecenter.qa.view.aj
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                bh.this.r1(view2);
            }
        });
        Button button2 = (Button) view.findViewById(R.id.aks);
        this.f213060l0 = button2;
        button2.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.gamecenter.qa.view.ak
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                bh.this.s1(view2);
            }
        });
        ImageButton imageButton4 = (ImageButton) view.findViewById(R.id.tgq);
        this.f213048d0 = imageButton4;
        imageButton4.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.gamecenter.qa.view.al
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                bh.this.t1(view2);
            }
        });
        ImageButton imageButton5 = (ImageButton) view.findViewById(R.id.tgr);
        this.f213050e0 = imageButton5;
        imageButton5.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.gamecenter.qa.view.am
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                bh.this.u1(view2);
            }
        });
        ImageButton imageButton6 = (ImageButton) view.findViewById(R.id.tco);
        this.f213053g0 = imageButton6;
        imageButton6.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.gamecenter.qa.view.an
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                bh.this.v1(view2);
            }
        });
        ImageButton imageButton7 = (ImageButton) view.findViewById(R.id.tcn);
        this.f213055h0 = imageButton7;
        imageButton7.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.gamecenter.qa.view.ao
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                bh.this.w1(view2);
            }
        });
        ImageButton imageButton8 = (ImageButton) view.findViewById(R.id.tcp);
        this.f213057i0 = imageButton8;
        imageButton8.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.gamecenter.qa.view.bb
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                bh.this.m1(view2);
            }
        });
        d2(false);
        i2(false);
        n2(false);
        this.X = (ImageView) view.findViewById(R.id.thm);
        this.Y = (ImageView) view.findViewById(R.id.tg_);
        this.X.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.gamecenter.qa.view.bc
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                bh.this.n1(view2);
            }
        });
        this.Y.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.gamecenter.qa.view.bd
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                bh.this.o1(view2);
            }
        });
        if (this.D0) {
            this.U.setVisibility(0);
            this.X.setVisibility(0);
            this.Y.setVisibility(0);
        } else {
            this.U.setVisibility(8);
            this.X.setVisibility(8);
            this.Y.setVisibility(8);
        }
        this.f213064o0 = view.findViewById(R.id.f88764xy);
        ViewGroup viewGroup4 = (ViewGroup) view.findViewById(R.id.f88754xx);
        this.f213065p0 = viewGroup4;
        viewGroup4.setBackgroundColor(-1);
        V0(view);
        if (this.D0) {
            wd1.b bVar = new wd1.b();
            this.A0 = bVar;
            bVar.g(this.f213056i);
            this.A0.h(this.Z, this.L0);
            this.A0.i(this.I0);
            y2();
        }
        ((IQIMShortVideoUtil) QRoute.api(IQIMShortVideoUtil.class)).preLoadPeakProcess(E0());
    }

    private void U1() {
        wd1.b bVar = this.A0;
        if (bVar != null) {
            bVar.f();
        }
    }

    private void V0(View view) {
        GameStrategyNestedScroll gameStrategyNestedScroll = (GameStrategyNestedScroll) view.findViewById(R.id.f88794y1);
        this.P = gameStrategyNestedScroll;
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) gameStrategyNestedScroll.getLayoutParams();
        layoutParams.addRule(3, R.id.vke);
        this.P.setLayoutParams(layoutParams);
        this.f213069t0 = new GestureDetector(new d());
        GameStrategyEditTextView gameStrategyEditTextView = (GameStrategyEditTextView) view.findViewById(R.id.f88784y0);
        this.f213056i = gameStrategyEditTextView;
        gameStrategyEditTextView.O(z0());
        this.f213056i.setLetterSpacing(0.05f);
        this.P.setOnScrollChangeListener(new e());
        this.P.setOnTouchListener(new f());
        this.f213056i.setFocusable(true);
        this.f213056i.setFocusableInTouchMode(true);
        this.f213056i.addTextChangedListener(this.H0);
        this.f213056i.setOnFocusChangeListener(new g());
        this.f213056i.setOnNewLineEnterListener(new h());
        this.f213056i.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.tencent.mobileqq.gamecenter.qa.view.aq
            @Override // android.widget.TextView.OnEditorActionListener
            public final boolean onEditorAction(TextView textView, int i3, KeyEvent keyEvent) {
                boolean x16;
                x16 = bh.this.x1(textView, i3, keyEvent);
                return x16;
            }
        });
        this.f213056i.setMenuClickListener(new i());
        this.f213056i.setSpanCreator(this.K0);
    }

    private void V1(final View view) {
        view.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.gamecenter.qa.view.ap
            @Override // java.lang.Runnable
            public final void run() {
                InputMethodUtil.show(view);
            }
        }, 100L);
    }

    private void W0(View view) {
        boolean z16;
        Window window = A0().getWindow();
        if (window != null) {
            window.setSoftInputMode(16);
        }
        GameStrategyPanelLayout gameStrategyPanelLayout = (GameStrategyPanelLayout) view.findViewById(R.id.f98955oh);
        this.f213066q0 = gameStrategyPanelLayout;
        if (this.J == 1) {
            z16 = true;
        } else {
            z16 = false;
        }
        gameStrategyPanelLayout.setViewType(z16, E0().getResources().getDimensionPixelSize(R.dimen.title_bar_height), A0().getWindow());
        if (this.J == 1) {
            this.f213066q0.setBackgroundResource(R.drawable.jql);
        } else {
            this.f213066q0.setBackgroundColor(-1);
        }
        this.f213061m.setOnClickListener(new t());
    }

    private void X0(View view) {
        this.f213063n0 = (ImageView) view.findViewById(R.id.f98945og);
        this.f213061m = (Button) view.findViewById(R.id.f99005om);
        TextView textView = (TextView) view.findViewById(R.id.f98995ol);
        this.N = textView;
        textView.setText(L0());
        this.f213063n0.setOnClickListener(new q());
    }

    private void Y0(View view) {
        View findViewById = view.findViewById(R.id.f98975oj);
        findViewById.setVisibility(0);
        findViewById.setOnClickListener(new r());
        this.f213061m = (Button) view.findViewById(R.id.f99005om);
        TextView textView = (TextView) view.findViewById(R.id.f98995ol);
        this.N = textView;
        textView.setVisibility(8);
        ImageView imageView = (ImageView) view.findViewById(R.id.f98945og);
        this.f213063n0 = imageView;
        imageView.setOnClickListener(new s());
        this.Q = (ImageView) view.findViewById(R.id.f98985ok);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Z1(boolean z16) {
        this.f213055h0.setSelected(z16);
        m2(this.f213055h0, z16);
    }

    private void a0() {
        QLog.d("QQGameStrategyBaseControl", 1, "autoFillLinkCard mEnableLinkCard", Boolean.valueOf(this.f213074y0));
        if (this.f213074y0) {
            String obj = this.f213056i.getEditableText().toString();
            if (!TextUtils.isEmpty(obj) && obj.length() > 1) {
                String substring = obj.substring(0, obj.length());
                List<String> o16 = GameQAUtil.o(substring);
                for (int size = o16.size() - 1; size >= 0; size--) {
                    String str = o16.get(size);
                    if (substring.endsWith(str) && GameQAUtil.q(str)) {
                        QLog.d("QQGameStrategyBaseControl", 1, "autoFillLinkCard url", str);
                        b0(str);
                        return;
                    }
                }
            }
        }
    }

    private void a1(Editable editable) {
        if (editable != null) {
            if (QLog.isColorLevel()) {
                QLog.d("QQGameStrategyBaseControl", 2, "afterTextChanged editable:", editable.toString(), " selection:", Integer.valueOf(this.f213056i.getSelectionStart()));
            }
            this.f213056i.f0();
            String obj = editable.toString();
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(editable);
            int selectionStart = this.f213056i.getSelectionStart();
            GameStrategyImageSpan[] gameStrategyImageSpanArr = (GameStrategyImageSpan[]) editable.getSpans(0, editable.length(), GameStrategyImageSpan.class);
            if (gameStrategyImageSpanArr != null && gameStrategyImageSpanArr.length > 0) {
                for (int length = gameStrategyImageSpanArr.length - 1; length >= 0; length--) {
                    GameStrategyImageSpan gameStrategyImageSpan = gameStrategyImageSpanArr[length];
                    int spanEnd = editable.getSpanEnd(gameStrategyImageSpan);
                    int i3 = spanEnd + 1;
                    if (obj.length() >= i3) {
                        if (!"\n".equals(obj.substring(spanEnd, i3))) {
                            spannableStringBuilder.insert(spanEnd, (CharSequence) "\n");
                            if (selectionStart > spanEnd) {
                                selectionStart++;
                            }
                        }
                    } else {
                        spannableStringBuilder.append((CharSequence) "\n");
                    }
                    int spanStart = editable.getSpanStart(gameStrategyImageSpan);
                    if (spanStart >= 1 && !"\n".equals(obj.substring(spanStart - 1, spanStart))) {
                        spannableStringBuilder.insert(spanStart, (CharSequence) "\n");
                        if (selectionStart > spanStart) {
                            selectionStart++;
                        }
                    }
                }
                if (!spannableStringBuilder.toString().equals(editable.toString())) {
                    this.f213056i.setText(spannableStringBuilder);
                    if (selectionStart > this.f213056i.getText().length()) {
                        GameStrategyEditTextView gameStrategyEditTextView = this.f213056i;
                        gameStrategyEditTextView.setSelection(gameStrategyEditTextView.getText().length());
                    } else {
                        this.f213056i.setSelection(selectionStart);
                    }
                }
            }
            this.f213056i.K();
            this.f213061m.setEnabled(true);
            if (QLog.isColorLevel()) {
                QLog.d("QQGameStrategyBaseControl", 2, "afterTextChanged2 editable:", this.f213056i.getEditableText().toString(), " selection:", Integer.valueOf(this.f213056i.getSelectionStart()));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a2(boolean z16) {
        this.f213053g0.setSelected(z16);
        m2(this.f213053g0, z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c0(final String str, final String str2) {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.gamecenter.qa.view.ax
            @Override // java.lang.Runnable
            public final void run() {
                bh.e1(str, str2);
            }
        }, 64, null, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c2(boolean z16) {
        this.f213057i0.setSelected(z16);
        m2(this.f213057i0, z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d2(boolean z16) {
        this.f213045b0.setSelected(z16);
        m2(this.f213045b0, z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void e1(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !str.equals(str2)) {
            QLog.i("QQGameStrategyBaseControl", 1, "[checkAndDeleteCompressFile]" + FileUtils.deleteFile(str));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e2() {
        if (!this.M) {
            this.f213056i.setFocusableInTouchMode(true);
            this.f213056i.requestFocus();
            if (this.f213056i.getText() != null && this.f213056i.getText().length() > 0) {
                GameStrategyEditTextView gameStrategyEditTextView = this.f213056i;
                gameStrategyEditTextView.setSelection(gameStrategyEditTextView.getText().length());
            } else {
                this.f213056i.setSelection(0);
            }
            this.C.findViewById(R.id.f89034yo).setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void f1(String str) {
        QLog.i("QQGameStrategyBaseControl", 1, "[deleteVideoFrameFile]" + FileUtils.deleteFile(str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void g1(String str, GameStrategyImageSpan gameStrategyImageSpan, int i3) {
        if (i3 == 1) {
            w0(str, gameStrategyImageSpan);
        } else if (i3 == 3) {
            r2(gameStrategyImageSpan);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g2(boolean z16) {
        this.f213060l0.setSelected(z16);
        if (z16) {
            this.f213060l0.setTextColor(this.I.getResources().getColor(R.color.cgo));
        } else {
            this.f213060l0.setTextColor(this.I.getResources().getColor(R.color.cgn));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void h1(List list) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            final String str = (String) it.next();
            final GameStrategyImageSpan b16 = GameStrategyImageSpan.d(E0(), C0(), str, "", 0, 0).b(this.f213056i);
            b16.C(new GameStrategyImageSpan.a() { // from class: com.tencent.mobileqq.gamecenter.qa.view.au
                @Override // com.tencent.mobileqq.gamecenter.qa.view.GameStrategyImageSpan.a
                public final void onClick(int i3) {
                    bh.this.g1(str, b16, i3);
                }
            });
            w0(str, b16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h2(boolean z16) {
        this.f213059k0.setSelected(z16);
        if (z16) {
            this.f213059k0.setTextColor(this.I.getResources().getColor(R.color.cgo));
        } else {
            this.f213059k0.setTextColor(this.I.getResources().getColor(R.color.cgn));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void i1(List list) {
        final List<String> N02 = N0(list);
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.gamecenter.qa.view.az
            @Override // java.lang.Runnable
            public final void run() {
                bh.this.h1(N02);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i2(boolean z16) {
        this.f213046c0.setSelected(z16);
        m2(this.f213046c0, z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void k1(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Q1();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k2(boolean z16) {
        this.f213048d0.setSelected(z16);
        m2(this.f213048d0, z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l0(final String str) {
        if (!TextUtils.isEmpty(str)) {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.gamecenter.qa.view.ay
                @Override // java.lang.Runnable
                public final void run() {
                    bh.f1(str);
                }
            }, 64, null, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void l1(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        G1();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l2(boolean z16) {
        this.f213050e0.setSelected(z16);
        m2(this.f213050e0, z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void m1(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        F1();
        EventCollector.getInstance().onViewClicked(view);
    }

    private void m2(ImageView imageView, boolean z16) {
        int i3;
        if (ThemeUtil.isNowThemeIsNight(null, false, null)) {
            if (z16) {
                i3 = Color.parseColor("#4B90F7");
            } else {
                i3 = Color.parseColor("#CCCCCC");
            }
        } else if (z16) {
            i3 = Color.parseColor("#0099FF");
        } else {
            i3 = -16777216;
        }
        imageView.setColorFilter(i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void n1(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        U1();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n2(boolean z16) {
        this.f213052f0.setSelected(z16);
        m2(this.f213052f0, z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void o1(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        M1();
        EventCollector.getInstance().onViewClicked(view);
    }

    private void o2() {
        if (this.f213058j0.getVisibility() != 0 || this.f213073x0) {
            return;
        }
        this.f213073x0 = true;
        CalloutPopupWindow.Builder lifetime = CalloutPopupWindow.builder(E0()).setText("\u8bd5\u4e00\u8bd5\u5f15\u7528\u6587\u7ae0\u5427\uff5e").setTextSize(14.0f).setTextColor(-1).setLifetime(3);
        lifetime.setPosition(49);
        CalloutPopupWindow build = new CalloutPopupWindow.DrawableBuilder(lifetime).setBackgroundColor(Color.argb(153, 0, 0, 0)).setBackgroundRadius(4).build().build();
        this.f213072w0 = build;
        if (build == null) {
            return;
        }
        build.setAlignMode(82);
        this.f213072w0.showAsPointer(this.f213058j0);
        K1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void p1(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        L1();
        EventCollector.getInstance().onViewClicked(view);
    }

    private void p2() {
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.gamecenter.qa.view.av
            @Override // java.lang.Runnable
            public final void run() {
                bh.this.z1();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void q1(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        T1();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: q2, reason: merged with bridge method [inline-methods] */
    public void j1(final String str) {
        boolean z16;
        Bitmap o16 = com.tencent.mobileqq.gamecenter.qa.util.k.o(str, Integer.MAX_VALUE, 0L);
        if (o16 == null) {
            QLog.i("QQGameStrategyBaseControl", 1, "[handleSelectVideo] getVideoFrame is null");
            p2();
            return;
        }
        final String a16 = vd1.a.a(F0().getAbsolutePath(), str);
        try {
            z16 = BaseImageUtil.saveBitmapFileAsJPEG(o16, 90, new File(a16));
        } catch (IOException e16) {
            QLog.e("QQGameStrategyBaseControl", 1, e16, new Object[0]);
            z16 = false;
        }
        if (!z16) {
            QLog.i("QQGameStrategyBaseControl", 1, "[handleSelectVideo] save video frame error");
            p2();
        } else {
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.gamecenter.qa.view.ar
                @Override // java.lang.Runnable
                public final void run() {
                    bh.this.B1(a16, str);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void r1(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        I1();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void s1(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        H1(false);
        EventCollector.getInstance().onViewClicked(view);
    }

    private void s2() {
        QQToast.makeText(BaseApplication.getContext(), 1, BaseApplication.getContext().getString(R.string.f13677052), 0).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void t1(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        N1();
        EventCollector.getInstance().onViewClicked(view);
    }

    private void t2() {
        QQToast.makeText(BaseApplication.getContext(), 1, String.format(BaseApplication.getContext().getString(R.string.f13678053), 1), 0).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void u1(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        O1();
        EventCollector.getInstance().onViewClicked(view);
    }

    private String u2(String str) {
        if (FileUtils.fileExistsAndNotEmpty(str)) {
            com.tencent.mobileqq.qqalbum.a aVar = new com.tencent.mobileqq.qqalbum.a();
            aVar.f262095a = str;
            aVar.f262096b = vd1.a.a(F0().getAbsolutePath(), str);
            long currentTimeMillis = System.currentTimeMillis();
            if (((IPicToJpg) QRoute.api(IPicToJpg.class)).picToJpg(aVar)) {
                String str2 = aVar.f262096b;
                QLog.i("QQGameStrategyBaseControl", 1, "[transHeifOrWebpToJpg] success,newPath:" + str2 + ",cost:" + (System.currentTimeMillis() - currentTimeMillis));
                return str2;
            }
            return str;
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v0(GameStrategyImageSpan gameStrategyImageSpan, String str, String str2) {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            return;
        }
        com.tencent.mobileqq.gamecenter.qa.util.k.q(peekAppRuntime, str, new n(gameStrategyImageSpan, str, str2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void v1(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        E1(false);
        EventCollector.getInstance().onViewClicked(view);
    }

    private void w0(String str, GameStrategyImageSpan gameStrategyImageSpan) {
        gameStrategyImageSpan.J(0);
        com.tencent.mobileqq.gamecenter.qa.util.k.q(MobileQQ.sMobileQQ.peekAppRuntime(), str, new l(gameStrategyImageSpan, str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void w1(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        D1();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w2(boolean z16) {
        this.Y.setClickable(z16);
        if (z16) {
            this.Y.setImageResource(R.drawable.f160780mw1);
        } else {
            this.Y.setImageResource(R.drawable.f160779mw0);
        }
    }

    private void x0(String str, String str2, GameStrategyImageSpan gameStrategyImageSpan) {
        gameStrategyImageSpan.J(0);
        String b16 = vd1.a.b(F0().getAbsolutePath(), str);
        this.f213049e.add(str);
        gameStrategyImageSpan.G(true);
        ((IQQGameTempRelyApi) QRoute.api(IQQGameTempRelyApi.class)).submitAndExecuteCompress(str, b16, new m(gameStrategyImageSpan, str2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean x1(TextView textView, int i3, KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() == 66) {
            a0();
            this.f213056i.setNewLineKeyDown();
            return false;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x2(boolean z16) {
        this.X.setClickable(z16);
        if (z16) {
            this.X.setImageResource(R.drawable.mw_);
        } else {
            this.X.setImageResource(R.drawable.mw9);
        }
    }

    private void y2() {
        final View decorView = this.f213070u0.getWindow().getDecorView();
        decorView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.tencent.mobileqq.gamecenter.qa.view.as
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public final void onGlobalLayout() {
                bh.this.C1(decorView);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void z1() {
        QQToast.makeText(E0(), "\u64cd\u4f5c\u5931\u8d25\uff0c\u8bf7\u7a0d\u540e\u91cd\u8bd5", 0).show();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Activity A0() {
        return this.f213070u0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int B0() {
        return 0;
    }

    protected abstract int D0();

    /* JADX INFO: Access modifiers changed from: protected */
    public Context E0() {
        return this.I;
    }

    protected abstract File F0();

    protected abstract EditText G0();

    public abstract s.b H0();

    /* JADX INFO: Access modifiers changed from: protected */
    public w I0(Editable editable) {
        int i3;
        String str;
        if (editable != null) {
            String obj = editable.toString();
            w wVar = new w();
            ArrayList arrayList = new ArrayList();
            ab[] abVarArr = (ab[]) editable.getSpans(0, editable.length(), ab.class);
            if (abVarArr != null && abVarArr.length > 0) {
                for (ab abVar : abVarArr) {
                    arrayList.add(new y(abVar, editable.getSpanStart(abVar), editable.getSpanEnd(abVar)));
                }
            }
            com.tencent.mobileqq.gamecenter.qa.view.w[] wVarArr = (com.tencent.mobileqq.gamecenter.qa.view.w[]) editable.getSpans(0, editable.length(), com.tencent.mobileqq.gamecenter.qa.view.w.class);
            if (wVarArr != null && wVarArr.length > 0) {
                for (com.tencent.mobileqq.gamecenter.qa.view.w wVar2 : wVarArr) {
                    arrayList.add(new y(wVar2, editable.getSpanStart(wVar2), editable.getSpanEnd(wVar2)));
                }
            }
            if (arrayList.size() > 0) {
                Collections.sort(arrayList);
                StringBuilder sb5 = new StringBuilder(obj);
                int size = arrayList.size();
                int i16 = 0;
                for (int i17 = 0; i17 < size; i17++) {
                    y yVar = (y) arrayList.get(i17);
                    Object obj2 = yVar.f213113d;
                    if (obj2 instanceof com.tencent.mobileqq.gamecenter.qa.view.w) {
                        com.tencent.mobileqq.gamecenter.qa.view.w wVar3 = (com.tencent.mobileqq.gamecenter.qa.view.w) obj2;
                        int i18 = yVar.f213114e - 1;
                        if (i18 < 0) {
                            i18 = 0;
                        }
                        int i19 = yVar.f213115f + 1;
                        if (i19 > sb5.length()) {
                            i19 = sb5.length();
                        }
                        wVar3.t(i16);
                        i3 = i16 + 1;
                        sb5.replace(i18, i19, wVar3.m(i16));
                        wVar.f213111c.add(wVar3.l());
                    } else if (obj2 instanceof ab) {
                        ab abVar2 = (ab) obj2;
                        i3 = i16 + 1;
                        sb5.replace(yVar.f213114e, yVar.f213115f, abVar2.q(i16));
                        if (!TextUtils.isEmpty(abVar2.getMTitle())) {
                            str = abVar2.getMTitle();
                        } else {
                            str = "";
                        }
                        wVar.f213111c.add(new GameQALinkCardData(LinkType.REFERENCE_TYPE_LINK, null, new GameQuestionUserInfo(), 0L, str, "", new ArrayList(), new ArrayList(), 0, new ArrayList(), abVar2.getMLink(), false));
                    }
                    i16 = i3;
                }
                obj = sb5.toString();
            }
            GameStrategyImageSpan[] gameStrategyImageSpanArr = (GameStrategyImageSpan[]) editable.getSpans(0, editable.length(), GameStrategyImageSpan.class);
            int i26 = 0;
            int i27 = 0;
            for (int i28 = 0; gameStrategyImageSpanArr != null && i28 < gameStrategyImageSpanArr.length; i28++) {
                GameStrategyImageSpan.b q16 = gameStrategyImageSpanArr[i28].q();
                int i29 = q16.f212891a;
                if (i29 == 0) {
                    GameStrategyPic gameStrategyPic = new GameStrategyPic();
                    gameStrategyPic.mUrl = q16.f212893c;
                    gameStrategyPic.mHeight = q16.f212895e;
                    gameStrategyPic.mWidth = q16.f212894d;
                    gameStrategyPic.mLocalPath = q16.f212892b;
                    wVar.f213109a.add(gameStrategyPic);
                    if (!TextUtils.isEmpty(q16.a())) {
                        q16.f212899i = i26;
                        obj = obj.replace(q16.a(), String.valueOf(q16.f212899i));
                        i26++;
                    }
                } else if (i29 == 1) {
                    GameStrategyVideo gameStrategyVideo = new GameStrategyVideo();
                    gameStrategyVideo.mVideoUrl = q16.f212896f;
                    gameStrategyVideo.mDuration = q16.f212898h;
                    if (!TextUtils.isEmpty(q16.f212897g)) {
                        gameStrategyVideo.mCoverUrl = q16.f212897g;
                    } else {
                        gameStrategyVideo.mCoverUrl = q16.f212893c;
                    }
                    gameStrategyVideo.mCoverWidth = q16.f212894d;
                    gameStrategyVideo.mCoverHeight = q16.f212895e;
                    gameStrategyVideo.mLocalPath = q16.f212892b;
                    wVar.f213110b.add(gameStrategyVideo);
                    if (!TextUtils.isEmpty(q16.a())) {
                        q16.f212899i = i27;
                        obj = obj.replace(q16.a(), String.valueOf(q16.f212899i));
                        i27++;
                    }
                } else {
                    QLog.e("QQGameStrategyBaseControl", 1, "[publishStrategy] unsupported type:" + q16.f212891a);
                }
            }
            wVar.f213112d = obj;
            if (QLog.isColorLevel()) {
                QLog.d("QQGameStrategyBaseControl", 2, "publishStrategy content:", obj);
            }
            return wVar;
        }
        return null;
    }

    protected long J0() {
        return 0L;
    }

    protected abstract void J1();

    protected int K0(int i3) {
        Editable editableText = this.f213056i.getEditableText();
        if (editableText == null) {
            return 0;
        }
        GameStrategyImageSpan[] gameStrategyImageSpanArr = (GameStrategyImageSpan[]) editableText.getSpans(0, editableText.length(), GameStrategyImageSpan.class);
        int i16 = 0;
        for (int i17 = 0; gameStrategyImageSpanArr != null && i17 < gameStrategyImageSpanArr.length; i17++) {
            if (gameStrategyImageSpanArr[i17].q().f212891a == i3) {
                i16++;
            }
        }
        return i16;
    }

    protected abstract void K1();

    protected abstract String L0();

    public View M0() {
        return this.C;
    }

    void O0(Intent intent) {
        GameStrategyImageSpan gameStrategyImageSpan = this.E0;
        if (gameStrategyImageSpan != null) {
            gameStrategyImageSpan.r();
            String stringExtra = intent.getStringExtra("PhotoConst.SINGLE_PHOTO_PATH");
            if (TextUtils.isEmpty(stringExtra) && intent.getExtras() != null) {
                stringExtra = intent.getExtras().getString("PhotoConst.SINGLE_PHOTO_PATH");
            }
            QLog.d("QQGameStrategyBaseControl", 2, " photo:" + stringExtra);
            ArrayList arrayList = new ArrayList();
            arrayList.add(stringExtra);
            P0(arrayList);
            this.E0 = null;
        }
    }

    protected void P0(final List<String> list) {
        QLog.i("QQGameStrategyBaseControl", 1, "onActivityResult handle image imagePaths:" + list);
        a1(this.f213056i.getEditableText());
        if (list != null && !list.isEmpty()) {
            if (b1(list.size())) {
                s2();
            } else {
                ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.gamecenter.qa.view.ai
                    @Override // java.lang.Runnable
                    public final void run() {
                        bh.this.i1(list);
                    }
                }, 64, null, false);
            }
        }
    }

    protected abstract void Q0(GameQALinkCardData gameQALinkCardData);

    protected void R0(List<String> list) {
        QLog.i("QQGameStrategyBaseControl", 1, "onActivityResult handle video");
        a1(this.f213056i.getEditableText());
        if (list != null && !list.isEmpty()) {
            final String str = list.get(0);
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.gamecenter.qa.view.at
                @Override // java.lang.Runnable
                public final void run() {
                    bh.this.j1(str);
                }
            }, 64, null, false);
        }
    }

    protected abstract void R1(boolean z16);

    protected abstract void S1(int i3, boolean z16);

    /* JADX INFO: Access modifiers changed from: protected */
    public void Z() {
        int i3;
        int i16 = this.I.getResources().getDisplayMetrics().widthPixels;
        int dip2px = ScreenUtil.dip2px(16.0f);
        int dip2px2 = ScreenUtil.dip2px(23.0f);
        int dip2px3 = ScreenUtil.dip2px(24.0f);
        ViewGroup viewGroup = this.f213062m0;
        if (viewGroup != null && viewGroup.getVisibility() == 0) {
            i3 = 7;
        } else {
            i3 = 6;
        }
        ViewGroup viewGroup2 = this.F;
        if (viewGroup2 != null && viewGroup2.getVisibility() == 0) {
            i3++;
        }
        int i17 = dip2px * 2;
        int i18 = dip2px3 * i3;
        if ((dip2px2 * (i3 - 1)) + i17 + i18 > i16) {
            int i19 = ((i16 - i17) - i18) / i3;
            ((RelativeLayout.LayoutParams) this.D.findViewById(R.id.f88914yc).getLayoutParams()).leftMargin = i19;
            ((RelativeLayout.LayoutParams) this.D.findViewById(R.id.f88854y7).getLayoutParams()).leftMargin = i19;
            ((RelativeLayout.LayoutParams) this.D.findViewById(R.id.f88884y_).getLayoutParams()).leftMargin = i19;
            ((RelativeLayout.LayoutParams) this.D.findViewById(R.id.f89124yx).getLayoutParams()).leftMargin = i19;
            ((RelativeLayout.LayoutParams) this.D.findViewById(R.id.f88624xk).getLayoutParams()).leftMargin = i19;
            ((RelativeLayout.LayoutParams) this.D.findViewById(R.id.thm).getLayoutParams()).leftMargin = i19;
        }
    }

    protected abstract void b0(String str);

    protected boolean b1(int i3) {
        if (K0(0) + i3 <= 30) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean c1() {
        Editable editableText = this.f213056i.getEditableText();
        if (editableText != null) {
            GameStrategyImageSpan[] gameStrategyImageSpanArr = (GameStrategyImageSpan[]) editableText.getSpans(0, editableText.length(), GameStrategyImageSpan.class);
            for (int i3 = 0; gameStrategyImageSpanArr != null && i3 < gameStrategyImageSpanArr.length; i3++) {
                GameStrategyImageSpan.b q16 = gameStrategyImageSpanArr[i3].q();
                if (TextUtils.isEmpty(q16.f212893c)) {
                    this.P.scrollTo(0, gameStrategyImageSpanArr[i3].p());
                    return false;
                }
                if (q16.f212891a == 1 && TextUtils.isEmpty(q16.f212896f)) {
                    this.P.scrollTo(0, gameStrategyImageSpanArr[i3].p());
                    return false;
                }
            }
        }
        return true;
    }

    protected boolean d1() {
        if (K0(1) >= 1) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void e0() {
        this.f213056i.requestFocus();
        GameStrategyEditTextView gameStrategyEditTextView = this.f213056i;
        gameStrategyEditTextView.setSelection(gameStrategyEditTextView.getText().length());
        InputMethodUtil.show(this.f213056i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void f0() {
        InputMethodUtil.hide(this.f213056i);
        com.tencent.mobileqq.gamecenter.qa.util.k.a(A0());
    }

    public void f2(x xVar) {
        this.f213071v0 = xVar;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0056, code lost:
    
        return false;
     */
    @Override // android.os.Handler.Callback
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean handleMessage(@NonNull Message message) {
        switch (message.what) {
            case 255:
                QQProgressDialog qQProgressDialog = this.G;
                if (qQProgressDialog != null) {
                    qQProgressDialog.dismiss();
                    break;
                }
                break;
            case 256:
                if (this.G == null) {
                    QQProgressDialog qQProgressDialog2 = new QQProgressDialog(A0(), 0, R.layout.gza, 17);
                    this.G = qQProgressDialog2;
                    qQProgressDialog2.setMessage(R.string.f13717065);
                }
                this.G.show();
                break;
            case 257:
                o2();
                break;
            case 258:
                this.V.setImageResource(R.drawable.mvx);
                this.W.setText("\u952e\u76d8");
                this.Z.setVisibility(0);
                this.f213075z0 = true;
                this.f213056i.requestFocus();
                break;
            case 259:
                this.f213065p0.setVisibility(0);
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void i0() {
        if (d1()) {
            t2();
        } else {
            InputMethodUtil.hide(this.f213056i);
            com.tencent.mobileqq.gamecenter.qa.util.k.b(A0());
        }
    }

    public void j0(boolean z16) {
        x xVar = this.f213071v0;
        if (xVar != null) {
            xVar.a(z16);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void j2(int i3, boolean z16) {
        this.f213061m.setEnabled(z16);
        this.f213061m.setText(i3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean k0() {
        ActionSheet createMenuSheet = ActionSheet.createMenuSheet(E0());
        createMenuSheet.addButton(R.string.h3s);
        createMenuSheet.addButton(R.string.f171082ms);
        createMenuSheet.setMainTitle(R.string.f1376107b);
        createMenuSheet.addCancelButton(R.string.cancel);
        createMenuSheet.setOnButtonClickListener(new j(createMenuSheet));
        createMenuSheet.show();
        return true;
    }

    public void m0(int i3, int i16, @Nullable Intent intent) {
        if (i16 == -1) {
            if (i3 == 10022 && intent != null) {
                P0(intent.getStringArrayListExtra(PeakConstants.INPULT_FULL_SCREEN_RESULT));
            } else if (i3 == 10023 && intent != null) {
                R0(intent.getStringArrayListExtra(PeakConstants.INPULT_FULL_SCREEN_RESULT));
            } else if (i3 == 1001 && intent != null) {
                Q0((GameQALinkCardData) intent.getSerializableExtra("cardData"));
            } else if (i3 == 10025) {
                O0(intent);
            }
            this.f213068s0 = true;
        }
    }

    public boolean n0() {
        return k0();
    }

    public View o0(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        boolean z16;
        int i3;
        View view;
        if (PadUtil.a(BaseApplication.getContext()) == DeviceType.FOLD && this.J == 1) {
            z16 = true;
        } else {
            z16 = false;
        }
        this.J0 = z16;
        if (z16) {
            i3 = R.layout.f167984eb1;
        } else {
            i3 = R.layout.f167983eb0;
        }
        View inflate = layoutInflater.inflate(i3, viewGroup, false);
        this.D = inflate;
        try {
            view = layoutInflater.inflate(D0(), (ViewGroup) inflate, false);
        } catch (Throwable th5) {
            QLog.e("QQGameStrategyBaseControl", 1, th5, new Object[0]);
            view = null;
        }
        try {
            this.C = (RelativeLayout) inflate.findViewById(R.id.jqh);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(3, R.id.f99015on);
            this.C.addView(view, 0, layoutParams);
            this.f213054h = view;
            view.setId(R.id.vke);
            if (this.J == 1) {
                this.C.findViewById(R.id.f98965oi).setVisibility(0);
                View findViewById = this.C.findViewById(R.id.f99015on);
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) findViewById.getLayoutParams();
                layoutParams2.addRule(3, R.id.f98965oi);
                findViewById.setLayoutParams(layoutParams2);
            }
        } catch (InflateException e16) {
            QLog.e("QQGameStrategyBaseControl", 1, e16, new Object[0]);
        }
        if (this.J == 1) {
            Y0(inflate);
        } else {
            X0(inflate);
        }
        W0(inflate);
        U0(inflate);
        p0(layoutInflater, viewGroup, bundle);
        s0(this.K, false);
        H1(true);
        E1(true);
        w2(false);
        x2(false);
        Z();
        return inflate;
    }

    public void q0() {
        Iterator<String> it = this.f213049e.iterator();
        while (it.hasNext()) {
            ((IQQGameTempRelyApi) QRoute.api(IQQGameTempRelyApi.class)).cancelCompressTask(it.next());
        }
        this.f213049e.clear();
        this.f213047d.o();
        this.H.removeCallbacksAndMessages(null);
        CalloutPopupWindow calloutPopupWindow = this.f213072w0;
        if (calloutPopupWindow != null) {
            calloutPopupWindow.dismiss();
        }
        wd1.b bVar = this.A0;
        if (bVar != null) {
            bVar.d();
        }
        ClipboardManager clipboardManager = (ClipboardManager) E0().getSystemService("clipboard");
        try {
            if (Build.VERSION.SDK_INT >= 28) {
                if (ClipboardMonitor.hasPrimaryClip(clipboardManager)) {
                    ClipboardMonitor.clearPrimaryClip(clipboardManager);
                }
            } else {
                ClipboardMonitor.setText(clipboardManager, null);
            }
        } catch (Exception e16) {
            QLog.e("QQGameStrategyBaseControl", 1, e16, new Object[0]);
        }
    }

    public void r0() {
        AbstractGifImage.pauseAll();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void r2(GameStrategyImageSpan gameStrategyImageSpan) {
        this.E0 = gameStrategyImageSpan;
        String str = gameStrategyImageSpan.q().f212892b;
        if (TextUtils.isEmpty(str) && (gameStrategyImageSpan.getDrawable() instanceof URLDrawable)) {
            str = ((URLDrawable) gameStrategyImageSpan.getDrawable()).getFileInLocal().getAbsolutePath();
        }
        Intent startEditPic = ((IAELaunchEditPic) QRoute.api(IAELaunchEditPic.class)).startEditPic(this.f213070u0, str, true, true, true, true, true, 2, 142, 5, new Bundle());
        startEditPic.putExtra(QAlbumConstants.CURRENT_QUALITY_TYPE, false);
        startEditPic.putExtra(PeakConstants.EANBLE_EDIT_PIC_TITLE_BAR, true);
        startEditPic.putExtra(PeakConstants.IS_INPULT_FULL_SCREEN_MODE, true);
        A0().startActivityForResult(startEditPic, 10025);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void s0(boolean z16, boolean z17) {
        if (this.J == 0 && (this.f213070u0 instanceof QBaseActivity) && ImmersiveUtils.isSupporImmersive() == 1) {
            GameQAUtil.I(M0(), (QBaseActivity) this.f213070u0, z16);
        }
        v2(this.M, z16);
        QLog.i("QQGameStrategyBaseControl", 1, "doOnPostTheme isNightTheme:" + z16);
        if (z16) {
            this.N.setTextColor(this.I.getResources().getColor(R.color.f157842cg4));
            this.f213066q0.setBackgroundResource(R.drawable.jqm);
            this.f213065p0.setBackgroundColor(this.I.getResources().getColor(R.color.cfi));
            this.f213061m.setBackgroundResource(R.drawable.jqr);
            this.f213056i.setHintTextColor(this.I.getResources().getColor(R.color.cgb));
            this.f213056i.setTextColor(this.I.getResources().getColor(R.color.cg8));
            this.f213064o0.setBackgroundResource(R.color.cfk);
            if (this.J == 1) {
                this.Q.setBackgroundResource(R.drawable.f160794jr0);
            }
            this.f213063n0.setImageResource(R.drawable.mww);
            return;
        }
        if (!z17) {
            return;
        }
        this.f213066q0.setBackgroundResource(R.drawable.jql);
        this.f213065p0.setBackgroundColor(-1);
        this.f213061m.setBackgroundResource(R.drawable.jqq);
        this.f213056i.setHintTextColor(this.I.getResources().getColor(R.color.cga));
        this.f213056i.setTextColor(this.I.getResources().getColor(R.color.cg7));
        this.f213064o0.setBackgroundResource(R.color.cfj);
        if (this.J == 1) {
            this.Q.setBackgroundResource(R.drawable.jqz);
        }
        this.f213063n0.setImageResource(R.drawable.mwv);
    }

    public void t0() {
        if (this.f213068s0) {
            V1(G0());
            this.f213068s0 = false;
        }
        AbstractGifImage.resumeAll();
        if (this.J == 0) {
            this.H.sendEmptyMessageDelayed(257, 1000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void u0(GameStrategyImageSpan gameStrategyImageSpan) {
        String str = gameStrategyImageSpan.q().f212896f;
        if (TextUtils.isEmpty(str)) {
            QLog.i("QQGameStrategyBaseControl", 1, "video url is null");
            return;
        }
        Intent intent = new Intent();
        intent.addFlags(268435456);
        intent.putExtra("intent_key_video_url", str);
        intent.putExtra("public_fragment_window_feature", 1);
        QPublicFragmentActivity.start(this.f213070u0, intent, QQGameStrategyVideoFragment.class);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void v2(boolean z16, boolean z17) {
        int i3;
        int i16;
        int i17;
        int i18;
        int color = this.f213070u0.getResources().getColor(R.color.f157842cg4);
        int color2 = this.f213070u0.getResources().getColor(R.color.f157838cg0);
        ImageView imageView = this.R;
        if (z17) {
            i3 = color;
        } else {
            i3 = color2;
        }
        imageView.setColorFilter(i3);
        ImageView imageView2 = this.S;
        if (z17) {
            i16 = color;
        } else {
            i16 = color2;
        }
        imageView2.setColorFilter(i16);
        ImageView imageView3 = this.T;
        if (z17) {
            i17 = color;
        } else {
            i17 = color2;
        }
        imageView3.setColorFilter(i17);
        ImageView imageView4 = this.f213058j0;
        if (z17) {
            i18 = color;
        } else {
            i18 = color2;
        }
        imageView4.setColorFilter(i18);
        ImageView imageView5 = this.V;
        if (!z17) {
            color = color2;
        }
        imageView5.setColorFilter(color);
    }

    protected boolean z0() {
        return false;
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    class c implements wd1.d {
        c() {
        }

        @Override // wd1.d
        public void a(@androidx.annotation.Nullable Layout.Alignment alignment) {
            if (bh.this.S0()) {
                bh.this.a2(false);
                bh.this.Z1(false);
                bh.this.c2(false);
            } else if (alignment == Layout.Alignment.ALIGN_NORMAL) {
                bh.this.a2(true);
                bh.this.Z1(false);
                bh.this.c2(false);
            } else if (alignment == Layout.Alignment.ALIGN_CENTER) {
                bh.this.a2(false);
                bh.this.Z1(true);
                bh.this.c2(false);
            } else {
                bh.this.a2(false);
                bh.this.Z1(false);
                bh.this.c2(true);
            }
        }

        @Override // wd1.d
        public void b(@androidx.annotation.Nullable wd1.e eVar) {
            bh.this.B0 = eVar;
        }

        @Override // wd1.d
        public void c(boolean z16) {
            if (bh.this.S0()) {
                bh.this.n2(false);
            } else {
                bh.this.n2(z16);
            }
        }

        @Override // wd1.d
        public void e(boolean z16) {
            if (bh.this.S0()) {
                bh.this.i2(false);
            } else {
                bh.this.i2(z16);
            }
        }

        @Override // wd1.d
        public void f(boolean z16) {
            if (bh.this.S0()) {
                bh.this.l2(false);
            } else {
                bh.this.l2(z16);
            }
        }

        @Override // wd1.d
        public void g(boolean z16) {
            if (bh.this.S0()) {
                bh.this.k2(false);
            } else {
                bh.this.k2(z16);
            }
        }

        @Override // wd1.d
        public void h(int i3) {
            if (bh.this.S0()) {
                bh.this.g2(false);
                bh.this.h2(false);
            } else if (i3 == 0 || i3 == ((int) bh.this.f213056i.getTextSize())) {
                bh.this.g2(true);
                bh.this.h2(false);
                bh.this.F0 = false;
            } else {
                bh.this.g2(false);
                bh.this.h2(true);
                bh.this.F0 = true;
            }
        }

        @Override // wd1.d
        public void setBold(boolean z16) {
            if (bh.this.S0()) {
                bh.this.d2(false);
            } else {
                bh.this.d2(z16);
            }
        }

        @Override // wd1.d
        public void d() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class m implements jh2.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ GameStrategyImageSpan f213091a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f213092b;

        m(GameStrategyImageSpan gameStrategyImageSpan, String str) {
            this.f213091a = gameStrategyImageSpan;
            this.f213092b = str;
        }

        @Override // jh2.a
        public void a(float f16) {
            this.f213091a.z(f16, BaseApplication.getContext().getString(R.string.f13715063));
        }

        @Override // jh2.a
        public void onFinish(int i3, String str, String str2) {
            this.f213091a.G(false);
            bh.this.f213049e.remove(str);
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            if (peekAppRuntime == null) {
                QLog.i("QQGameStrategyBaseControl", 1, "[onFinish] app is null");
                return;
            }
            if (i3 == 1) {
                com.tencent.mobileqq.gamecenter.qa.util.k.q(peekAppRuntime, this.f213092b, new a(str2, str));
                return;
            }
            QLog.i("QQGameStrategyBaseControl", 1, "[onFail] compress finishCode:" + i3);
            bh.this.c0(str2, str);
            bh.this.l0(this.f213092b);
            this.f213091a.J(2);
        }

        /* compiled from: P */
        /* loaded from: classes12.dex */
        class a implements k.b {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ String f213094a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ String f213095b;

            a(String str, String str2) {
                this.f213094a = str;
                this.f213095b = str2;
            }

            @Override // com.tencent.mobileqq.gamecenter.qa.util.k.b
            public void onFail(int i3) {
                QLog.i("QQGameStrategyBaseControl", 1, "[onFail] videoFramePath:" + m.this.f213092b + ",errCode:" + i3);
                m mVar = m.this;
                bh.this.l0(mVar.f213092b);
                m.this.f213091a.J(2);
            }

            @Override // com.tencent.mobileqq.gamecenter.qa.util.k.b
            public void onSuccess(String str) {
                QLog.i("QQGameStrategyBaseControl", 1, "[onSuccess] frameUrl:" + str + ",videoFramePath:" + m.this.f213092b);
                m.this.f213091a.E(str);
                m mVar = m.this;
                bh.this.v0(mVar.f213091a, this.f213094a, this.f213095b);
            }

            @Override // com.tencent.mobileqq.gamecenter.qa.util.k.b
            public void onProgress(float f16) {
            }
        }

        @Override // jh2.a
        public void b(boolean z16) {
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void W1() {
    }

    public void X1() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Z0() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void d0() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void g0() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void y0() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void p0(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    class k implements TextWatcher {
        k() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            boolean z16;
            bh bhVar = bh.this;
            if (bhVar.f213051f >= 0) {
                Button button = bhVar.f213061m;
                if (editable.toString().trim().length() > bh.this.f213051f) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                button.setEnabled(z16);
            }
            if (bh.this.f213067r0 && editable.toString().trim().length() > 0) {
                bh.this.Z0();
                bh.this.f213067r0 = false;
            }
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
            if (charSequence.length() >= 5000) {
                QQToast.makeText(bh.this.E0(), 0, R.string.f13676051, 1).show();
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
        }
    }
}
