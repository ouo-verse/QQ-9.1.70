package com.tencent.av.ui.chatroom;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.text.InputFilter;
import android.text.Spanned;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.n;
import com.tencent.av.ui.AVActivity;
import com.tencent.av.ui.GLVideoView;
import com.tencent.av.ui.VideoLayerUI;
import com.tencent.av.ui.aj;
import com.tencent.av.ui.chatroom.a;
import com.tencent.av.utils.ba;
import com.tencent.avcore.util.AVCoreLog;
import com.tencent.biz.qui.quibutton.QUIButton;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.emoticonview.SystemAndEmojiUniversalPanel;
import com.tencent.mobileqq.emoticonview.api.IEmoticonMainPanelAppService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cw.e;
import java.util.List;

/* compiled from: P */
/* loaded from: classes3.dex */
public class VideoChatRoomContainer extends RelativeLayout implements a.g {
    private ChatRoomAdapter C;
    protected ListView D;
    private int E;
    private boolean F;
    private int G;
    private com.tencent.av.ui.chatroom.a H;

    /* renamed from: d, reason: collision with root package name */
    VideoAppInterface f75469d;

    /* renamed from: e, reason: collision with root package name */
    private LinearLayout f75470e;

    /* renamed from: f, reason: collision with root package name */
    private LinearLayout f75471f;

    /* renamed from: h, reason: collision with root package name */
    protected EditText f75472h;

    /* renamed from: i, reason: collision with root package name */
    private ImageView f75473i;

    /* renamed from: m, reason: collision with root package name */
    private LinearLayout f75474m;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public class a extends InputFilter.LengthFilter {

        /* renamed from: d, reason: collision with root package name */
        private long f75477d;

        public a(int i3) {
            super(i3);
            this.f75477d = 0L;
        }

        @Override // android.text.InputFilter.LengthFilter, android.text.InputFilter
        public CharSequence filter(CharSequence charSequence, int i3, int i16, Spanned spanned, int i17, int i18) {
            if (getMax() - (spanned.length() - (i18 - i17)) < i16 - i3) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - this.f75477d > 1000) {
                    QQToast.makeText(VideoChatRoomContainer.this.getContext(), VideoChatRoomContainer.this.getResources().getString(R.string.f1780135i, Integer.valueOf(getMax())), 0).show();
                    this.f75477d = currentTimeMillis;
                }
            }
            return super.filter(charSequence, i3, i16, spanned, i17, i18);
        }
    }

    public VideoChatRoomContainer(Context context) {
        this(context, null);
    }

    private void k(Context context) {
        l(context);
        n(context);
    }

    private void l(Context context) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.a5m, this);
        this.f75470e = (LinearLayout) inflate.findViewById(R.id.e2a);
        this.f75471f = (LinearLayout) inflate.findViewById(R.id.b9w);
        this.C = new ChatRoomAdapter(context);
        ListView listView = (ListView) this.f75471f.findViewById(android.R.id.list);
        this.D = listView;
        listView.setAdapter((ListAdapter) this.C);
        EditText editText = (EditText) this.f75471f.findViewById(R.id.dmg);
        this.f75472h = editText;
        editText.setFilters(new InputFilter[]{new a(40)});
        this.f75473i = (ImageView) this.f75471f.findViewById(R.id.a75);
        this.f75474m = (LinearLayout) this.f75470e.findViewById(R.id.bvt);
        setFitsSystemWindows(true);
    }

    private void m() {
        LinearLayout linearLayout = new LinearLayout(getContext());
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.de5);
        linearLayout.setOrientation(0);
        linearLayout.setGravity(21);
        linearLayout.setBackgroundColor(Color.parseColor("#2F3033"));
        linearLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, dimensionPixelSize));
        QUIButton qUIButton = new QUIButton(getContext());
        qUIButton.setThemeId(1002);
        qUIButton.setType(0);
        qUIButton.setSizeType(2);
        qUIButton.setText(R.string.f230266yo);
        ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(-2, -2);
        marginLayoutParams.rightMargin = (int) ba.dp2px(getContext(), 20.0f);
        qUIButton.setLayoutParams(marginLayoutParams);
        qUIButton.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.av.ui.chatroom.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                VideoChatRoomContainer.this.q(view);
            }
        });
        linearLayout.addView(qUIButton);
        this.f75474m.addView(linearLayout);
    }

    private void n(Context context) {
        this.H = com.tencent.av.ui.chatroom.a.z((Activity) context).f(this).j((VideoChatRoomListView) this.D).g(this.f75472h).h(this.f75473i).k();
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, 0, 1.0f);
        SystemAndEmojiUniversalPanel create = new SystemAndEmojiUniversalPanel.Builder(getContext()).setFilterSysFaceBeyond255Enable(true).setEmoticonCallback(this.H).setShowDeleteButton(this.f75472h).setIgnoreUIToken(true).create(((IEmoticonMainPanelAppService) QRoute.api(IEmoticonMainPanelAppService.class)).createEmoticonMainPanelApp(this.f75469d));
        create.setBackgroundColor(Color.parseColor("#1A1C1E"));
        create.setId(R.id.f166565cp3);
        create.setVisibility(0);
        this.f75474m.addView(create, layoutParams);
        m();
        this.H.i(this.f75474m);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void q(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        this.H.send();
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.av.ui.chatroom.a.g
    public void a(int i3, int i16, int i17, long j3) {
        if (i16 == 2 && i17 == 7) {
            i(this.E);
        }
    }

    @Override // com.tencent.av.ui.chatroom.a.g
    public void b(int i3, int i16, int i17, long j3) {
        i(this.E);
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0012, code lost:
    
        if (r3 != 7) goto L18;
     */
    @Override // com.tencent.av.ui.chatroom.a.g
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void c(final int i3, final long j3) {
        if (this.H == null) {
            return;
        }
        if (i3 != 0) {
            if (i3 == 1 || i3 == 2 || i3 == 4) {
                u(0, false);
            }
            post(new Runnable() { // from class: com.tencent.av.ui.chatroom.VideoChatRoomContainer.1
                @Override // java.lang.Runnable
                public void run() {
                    VideoAppInterface videoAppInterface = VideoChatRoomContainer.this.f75469d;
                    if (videoAppInterface != null) {
                        videoAppInterface.k0(new Object[]{9006, Integer.valueOf(i3), Long.valueOf(j3)});
                    }
                }
            });
        }
        u(this.E, false);
        post(new Runnable() { // from class: com.tencent.av.ui.chatroom.VideoChatRoomContainer.1
            @Override // java.lang.Runnable
            public void run() {
                VideoAppInterface videoAppInterface = VideoChatRoomContainer.this.f75469d;
                if (videoAppInterface != null) {
                    videoAppInterface.k0(new Object[]{9006, Integer.valueOf(i3), Long.valueOf(j3)});
                }
            }
        });
    }

    @Override // com.tencent.av.ui.chatroom.a.g
    public void d(String str) {
        VideoChatRoomUIContoller videoChatRoomUIContoller;
        b d16 = b.d();
        d16.j(1);
        d16.g(str);
        d16.h(this.f75469d.getCurrentAccountUin());
        this.C.b(d16);
        this.D.setSelection(this.C.getCount() - 1);
        Context context = getContext();
        if ((context instanceof AVActivity) && (videoChatRoomUIContoller = ((AVActivity) context).f74657h1) != null) {
            videoChatRoomUIContoller.u(str);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        boolean z16;
        boolean z17 = false;
        if (((AVActivity) getContext()).findViewById(R.id.g7u) != null) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            this.H.l();
            if (!QLog.isColorLevel()) {
                return false;
            }
            QLog.w("ChatRoomUtil", 2, "doodle hase show, so not accept dispatchEvent");
            return false;
        }
        if (n.e().f().f73048l0) {
            this.H.l();
            r(119, 2);
            return false;
        }
        if (n.e().f().Y2) {
            e.o(this.f75469d, 1022, R.string.dh9);
            return false;
        }
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        if (!dispatchTouchEvent && this.H.r()) {
            InputMethodManager inputMethodManager = (InputMethodManager) getContext().getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD);
            if (inputMethodManager != null) {
                z17 = inputMethodManager.isActive();
            }
            this.H.o();
            if (QLog.isColorLevel()) {
                QLog.w("ChatRoomUtil", 2, "dispatchTouchEvent, \u62e6\u622a\u4e86touch\u6d88\u606f, isSoftInputActive[" + z17 + "]");
            }
        } else if (!dispatchTouchEvent && this.H.p()) {
            this.H.n();
        }
        return dispatchTouchEvent;
    }

    @Override // com.tencent.av.ui.chatroom.a.g
    public void e(MotionEvent motionEvent) {
        Context context = getContext();
        if (context instanceof AVActivity) {
            ((AVActivity) context).dispatchEvent(motionEvent);
        }
    }

    public void g(List<b> list, boolean z16) {
        this.C.c(list, z16);
        this.D.setSelection(this.C.getCount() - 1);
    }

    public void h(VideoAppInterface videoAppInterface) {
        this.f75469d = videoAppInterface;
    }

    public void i(int i3) {
        boolean z16;
        boolean z17;
        AVActivity aVActivity;
        int i16;
        boolean z18;
        aj ajVar;
        boolean q16 = this.H.q();
        boolean z19 = true;
        int i17 = 0;
        if (this.F != q16) {
            z16 = true;
        } else {
            z16 = false;
        }
        this.F = q16;
        if (this.E != i3) {
            z17 = true;
        } else {
            z17 = false;
        }
        this.E = i3;
        Context context = getContext();
        if (context instanceof AVActivity) {
            aVActivity = (AVActivity) context;
            i16 = aVActivity.g3();
            if (this.G != i16) {
                z18 = true;
            } else {
                z18 = false;
            }
            this.G = i16;
        } else {
            aVActivity = null;
            i16 = 1;
            z18 = false;
        }
        if (!z16 && !z17 && !z18) {
            z19 = false;
        }
        int i18 = this.E;
        int m3 = this.H.m();
        if (m3 != 0 && m3 != 7) {
            if (this.H.I && m3 != 4) {
                i17 = this.E;
            }
        } else {
            i17 = i18;
        }
        u(i17, z19);
        if (aVActivity != null && z18) {
            t(aVActivity.J0, i16);
        }
        if (z19 && aVActivity != null && (ajVar = aVActivity.I0) != null) {
            ajVar.V0();
        }
    }

    public int j() {
        if (this.H.p()) {
            return this.f75474m.getHeight();
        }
        if (this.H.r() && !this.H.I) {
            return com.tencent.av.chatroom.c.f73533c;
        }
        return 0;
    }

    public boolean o() {
        return false;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z16, int i3, int i16, int i17, int i18) {
        super.onLayout(z16, i3, i16, i17, i18);
    }

    public boolean p() {
        com.tencent.av.ui.chatroom.a aVar = this.H;
        if (aVar != null && aVar.r()) {
            return true;
        }
        return false;
    }

    protected void r(int i3, Object obj) {
        AVCoreLog.printColorLog("VideoChatRoomContainer", "notifyEvent :" + i3 + "|" + obj);
        this.f75469d.k0(new Object[]{Integer.valueOf(i3), obj});
    }

    public boolean s() {
        if (this.H.p()) {
            this.H.n();
            return true;
        }
        if (this.H.r()) {
            this.H.o();
            return true;
        }
        return false;
    }

    @Override // android.view.View
    public void setVisibility(int i3) {
        com.tencent.av.ui.chatroom.a aVar;
        super.setVisibility(i3);
        if (getVisibility() == 8 && (aVar = this.H) != null) {
            if (aVar.p()) {
                this.H.n();
            } else {
                this.H.o();
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0020  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0050  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void t(VideoLayerUI videoLayerUI, int i3) {
        int i16;
        int i17;
        ViewGroup.MarginLayoutParams marginLayoutParams;
        boolean z16;
        GLVideoView gLVideoView;
        boolean z17 = false;
        boolean z18 = true;
        if (i3 == 1 && !o()) {
            if (videoLayerUI != null) {
                GLVideoView[] gLVideoViewArr = videoLayerUI.f75271c0;
                if (gLVideoViewArr.length > 1 && (gLVideoView = gLVideoViewArr[1]) != null && gLVideoView.m() == 0) {
                    z16 = true;
                    if (z16) {
                        i17 = videoLayerUI.f75271c0[1].n();
                        int y06 = videoLayerUI.y0();
                        if (y06 != 3) {
                            if (y06 == 4) {
                                i16 = 0;
                            }
                        } else {
                            i16 = i17;
                            i17 = 0;
                        }
                        marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f75471f.getLayoutParams();
                        if (marginLayoutParams.leftMargin != i17) {
                            marginLayoutParams.leftMargin = i17;
                            z17 = true;
                        }
                        if (marginLayoutParams.rightMargin == i16) {
                            marginLayoutParams.rightMargin = i16;
                        } else {
                            z18 = z17;
                        }
                        if (!z18 && getVisibility() == 0) {
                            this.f75471f.setLayoutParams(marginLayoutParams);
                            return;
                        }
                    }
                }
            }
            z16 = false;
            if (z16) {
            }
        }
        i16 = 0;
        i17 = 0;
        marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f75471f.getLayoutParams();
        if (marginLayoutParams.leftMargin != i17) {
        }
        if (marginLayoutParams.rightMargin == i16) {
        }
        if (!z18) {
        }
    }

    public void u(int i3, boolean z16) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f75470e.getLayoutParams();
        if (marginLayoutParams.bottomMargin != i3) {
            marginLayoutParams.bottomMargin = i3;
        }
        if (z16) {
            this.f75470e.setLayoutParams(marginLayoutParams);
        }
        if (QLog.isDevelopLevel()) {
            QLog.i("ChatRoomUtil", 4, "updateContextViewLayoutBottomMargin, bottomMargin[" + i3 + "], forceRequestLayout[" + z16 + "]");
        }
    }

    public VideoChatRoomContainer(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public VideoChatRoomContainer(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.E = 0;
        this.F = false;
        this.G = 0;
        k(context);
    }
}
