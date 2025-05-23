package com.tencent.av.ui.part.mav;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.n;
import com.tencent.av.q;
import com.tencent.av.r;
import com.tencent.av.ui.AVActivity;
import com.tencent.av.ui.VideoLayerUI;
import com.tencent.av.ui.chatroom.VideoChatRoomUIContoller;
import com.tencent.av.ui.m;
import com.tencent.av.utils.AVUtil;
import com.tencent.av.utils.af;
import com.tencent.av.utils.ba;
import com.tencent.av.widget.RotateLayout;
import com.tencent.biz.richframework.ioc.RFWIocAbilityProvider;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qq.minibox.api.data.MiniBoxNoticeInfo;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import mqq.util.LogUtil;
import mw.i;
import mw.j;

/* compiled from: P */
/* loaded from: classes32.dex */
public class a extends Part implements i {

    /* renamed from: m, reason: collision with root package name */
    private static boolean f76575m;

    /* renamed from: d, reason: collision with root package name */
    ArrayList<b> f76576d = new ArrayList<>();

    /* renamed from: e, reason: collision with root package name */
    String f76577e = "";

    /* renamed from: f, reason: collision with root package name */
    ArrayList<b> f76578f = new ArrayList<>();

    /* renamed from: h, reason: collision with root package name */
    boolean f76579h = false;

    /* renamed from: i, reason: collision with root package name */
    int f76580i = 0;

    /* compiled from: P */
    /* renamed from: com.tencent.av.ui.part.mav.a$a, reason: collision with other inner class name */
    /* loaded from: classes32.dex */
    class ViewOnClickListenerC0775a implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ TextView f76581d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ TextView f76582e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ ImageView f76583f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ ImageView f76584h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ TextView f76585i;

        /* renamed from: m, reason: collision with root package name */
        final /* synthetic */ ImageView f76586m;

        ViewOnClickListenerC0775a(TextView textView, TextView textView2, ImageView imageView, ImageView imageView2, TextView textView3, ImageView imageView3) {
            this.f76581d = textView;
            this.f76582e = textView2;
            this.f76583f = imageView;
            this.f76584h = imageView2;
            this.f76585i = textView3;
            this.f76586m = imageView3;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TextView textView = this.f76581d;
            if (textView != null) {
                textView.setVisibility(8);
            }
            TextView textView2 = this.f76582e;
            if (textView2 != null) {
                textView2.setVisibility(8);
            }
            ImageView imageView = this.f76583f;
            if (imageView != null) {
                imageView.setVisibility(8);
            }
            ImageView imageView2 = this.f76584h;
            if (imageView2 != null) {
                imageView2.setVisibility(8);
            }
            TextView textView3 = this.f76585i;
            if (textView3 != null) {
                textView3.setVisibility(8);
            }
            ImageView imageView3 = this.f76586m;
            if (imageView3 != null) {
                imageView3.setVisibility(8);
            }
            a.this.f76579h = true;
            ReportController.o(null, "CliOper", "", "", "0X800AEB8", "0X800AEB8", 0, 0, "", "", "", "");
        }
    }

    /* compiled from: P */
    /* loaded from: classes32.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public String f76587a;

        /* renamed from: b, reason: collision with root package name */
        public int f76588b;

        public b(String str, int i3) {
            this.f76587a = str;
            this.f76588b = i3;
        }
    }

    static {
        f76575m = DeviceInfoMonitor.getModel().equalsIgnoreCase("SM-G7106") || DeviceInfoMonitor.getModel().equalsIgnoreCase("MI 2") || DeviceInfoMonitor.getModel().equalsIgnoreCase("GT-B9388") || DeviceInfoMonitor.getModel().equalsIgnoreCase("L39u") || DeviceInfoMonitor.getModel().equalsIgnoreCase("R7007") || DeviceInfoMonitor.getModel().equalsIgnoreCase("VIVO X5S L");
    }

    private boolean A9() {
        if (QLog.isDevelopLevel()) {
            QLog.i("AVSpokesmanPart", 2, "isLandscape, mCurrentRotation[" + this.f76580i + "]");
        }
        int i3 = this.f76580i;
        return (i3 == 0 || i3 == 180) ? false : true;
    }

    public void B9(long j3, boolean z16, int i3) {
        int i16;
        Activity activity = getActivity();
        if (activity == null || r.h0() == null) {
            return;
        }
        boolean z17 = true;
        boolean z18 = n.e().f().N || n.e().f().f73045k1.size() > 0;
        if (z18) {
            i16 = m.h.f76037c;
        } else {
            i16 = m.h.f76035a;
        }
        int i17 = z18 ? m.h.f76039e : 0;
        TextView textView = (TextView) getPartRootView().findViewById(i16);
        TextView textView2 = i17 != 0 ? (TextView) getPartRootView().findViewById(i17) : null;
        String l3 = Long.toString(j3);
        int i18 = 0;
        while (true) {
            if (i18 >= this.f76576d.size()) {
                z17 = false;
                break;
            } else if (!this.f76576d.get(i18).f76587a.equalsIgnoreCase(l3)) {
                i18++;
            } else if (z16) {
                this.f76576d.get(i18).f76588b = i3;
                if (i3 < 10) {
                    this.f76576d.remove(i18);
                }
            } else {
                this.f76576d.remove(i18);
            }
        }
        if (z16 && !z17 && i3 > 10) {
            this.f76576d.add(new b(l3, i3));
        }
        VideoLayerUI videoLayerUI = ((AVActivity) activity).J0;
        if (videoLayerUI != null) {
            videoLayerUI.H2(j3, z16);
        }
        int size = r.h0().i0().size() + r.h0().Y().size();
        if ((size <= 8 && !z18) || (size <= com.tencent.av.ui.n.f76093u3 && z18)) {
            this.f76577e = "";
        } else {
            ArrayList<b> arrayList = new ArrayList<>();
            for (int i19 = 0; i19 < this.f76576d.size(); i19++) {
                arrayList.add(new b(this.f76576d.get(i19).f76587a, this.f76576d.get(i19).f76588b));
            }
            this.f76577e = z9(arrayList);
        }
        textView.setText(this.f76577e);
        if (textView2 != null) {
            textView2.setText(this.f76577e);
        }
        p();
        if (QLog.isDevelopLevel()) {
            QLog.d("AVSpokesmanPart", 2, "refreshSpokesmanInfoContent. uin = " + LogUtil.getSafePrintUin(String.valueOf(j3)) + ", isSpeaking = " + z16 + ", hasVideo = " + z18 + ", member cnt = " + r.h0().Y().size() + ", mSpokesmanNicknameListStr = " + this.f76577e);
        }
    }

    public void C9(int i3) {
        this.f76580i = i3;
        p();
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View view) {
        super.onInitView(view);
        TextView textView = (TextView) view.findViewById(m.h.f76037c);
        TextView textView2 = (TextView) view.findViewById(m.h.f76039e);
        TextView textView3 = (TextView) view.findViewById(m.h.f76035a);
        ImageView imageView = (ImageView) view.findViewById(m.h.f76038d);
        ImageView imageView2 = (ImageView) view.findViewById(m.h.f76040f);
        ImageView imageView3 = (ImageView) view.findViewById(m.h.f76036b);
        ViewOnClickListenerC0775a viewOnClickListenerC0775a = new ViewOnClickListenerC0775a(textView, textView2, imageView, imageView2, textView3, imageView3);
        if (imageView != null) {
            imageView.setOnClickListener(viewOnClickListenerC0775a);
        }
        if (imageView2 != null) {
            imageView2.setOnClickListener(viewOnClickListenerC0775a);
        }
        ba.setAccText(imageView, "\u5173\u95ed\u9ea6\u514b\u98ce\u72b6\u6001\u663e\u793a");
        ba.setAccText(imageView2, "\u5173\u95ed\u9ea6\u514b\u98ce\u72b6\u6001\u663e\u793a");
        if (imageView3 != null) {
            imageView3.setOnClickListener(viewOnClickListenerC0775a);
        }
        RFWIocAbilityProvider.g().registerIoc(view, this, i.class);
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        super.onPartDestroy(activity);
        RFWIocAbilityProvider.g().unregisterSingleIoc(getPartRootView(), i.class);
    }

    @Override // mw.i
    public void p() {
        VideoChatRoomUIContoller videoChatRoomUIContoller;
        if (r.h0() == null) {
            return;
        }
        boolean z16 = n.e().f().N || n.e().f().f73045k1.size() > 0;
        View partRootView = getPartRootView();
        if (partRootView == null) {
            return;
        }
        TextView textView = (TextView) partRootView.findViewById(m.h.f76035a);
        TextView textView2 = (TextView) partRootView.findViewById(m.h.f76037c);
        TextView textView3 = (TextView) partRootView.findViewById(m.h.f76039e);
        ImageView imageView = (ImageView) partRootView.findViewById(m.h.f76038d);
        ImageView imageView2 = (ImageView) partRootView.findViewById(m.h.f76036b);
        LinearLayout linearLayout = (LinearLayout) partRootView.findViewById(m.h.f76041g);
        j jVar = (j) RFWIocAbilityProvider.g().getIocInterface(j.class, getPartRootView(), null);
        if (z16) {
            textView.setVisibility(8);
            imageView2.setVisibility(8);
            if (f76575m || this.f76579h) {
                return;
            }
            if (QLog.isDevelopLevel()) {
                QLog.d("AVSpokesmanPart", 2, "refreshSpokesmanInfoUI video. txt = " + this.f76577e + " isLandScape: " + A9() + "isToolBarDisplay:" + jVar.isToolBarDisplay());
            }
            int i3 = r.h0().Y().size() <= com.tencent.av.ui.n.f76093u3 ? 8 : 0;
            if (A9() && !jVar.isToolBarDisplay() && !af.A()) {
                textView2.setVisibility(8);
                imageView.setVisibility(8);
                textView3.setText(this.f76577e);
                x9(linearLayout);
                linearLayout.setVisibility(i3);
                return;
            }
            linearLayout.setVisibility(8);
            int f16 = BaseAIOUtils.f(q.f74203n + q.f74205p, textView2.getResources());
            if (ImmersiveUtils.isSupporImmersive() == 1) {
                f16 += ImmersiveUtils.getStatusBarHeight(getContext());
            }
            if (q.f74206q) {
                f16 = jVar.isToolBarDisplay() ? f16 + 5 : f16 + 25;
            }
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) textView2.getLayoutParams();
            layoutParams.topMargin = f16;
            textView2.setLayoutParams(layoutParams);
            textView2.setText(this.f76577e);
            textView2.setVisibility(i3);
            imageView.setVisibility(i3);
            return;
        }
        textView2.setVisibility(8);
        imageView.setVisibility(8);
        linearLayout.setVisibility(8);
        if (f76575m || this.f76579h) {
            return;
        }
        textView.setText(this.f76577e);
        AVActivity aVActivity = (AVActivity) getActivity();
        int size = r.h0().i0().size() + r.h0().Y().size();
        if ((aVActivity != null && (videoChatRoomUIContoller = aVActivity.f74657h1) != null && videoChatRoomUIContoller.s()) || size <= 8) {
            if (QLog.isDevelopLevel()) {
                QLog.d("AVSpokesmanPart", 2, "refreshSpokesmanInfoUI audio. txt = " + this.f76577e + ", allDisplayNum = " + size + ", invite cnt = " + r.h0().i0().size() + ", member cnt = " + r.h0().Y().size());
            }
            textView.setVisibility(8);
            imageView2.setVisibility(8);
            return;
        }
        QLog.d("AVSpokesmanPart", 2, "refreshSpokesmanInfoUI audio. txt = " + this.f76577e + " isLandScape: " + A9() + "isToolBarDisplay:" + jVar.isToolBarDisplay());
        textView.setVisibility(0);
        imageView2.setVisibility(0);
    }

    public void x9(ViewGroup viewGroup) {
        int i3 = this.f76580i;
        if (QLog.isColorLevel()) {
            QLog.i("AVSpokesmanPart", 2, "adjustSpokesmanPosAndRotation. rotation[ " + i3 + "]");
        }
        if (viewGroup == null || !(viewGroup.getParent() instanceof RotateLayout)) {
            QLog.e("AVSpokesmanPart", 2, "adjustSpokesmanPosAndRotation. layout invalid ");
            return;
        }
        if (i3 == 90) {
            RotateLayout.LayoutParams layoutParams = (RotateLayout.LayoutParams) viewGroup.getLayoutParams();
            layoutParams.f77225a = -270;
            viewGroup.setLayoutParams(layoutParams);
            RotateLayout rotateLayout = (RotateLayout) viewGroup.getParent();
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) rotateLayout.getLayoutParams();
            layoutParams2.removeRule(11);
            layoutParams2.removeRule(12);
            layoutParams2.addRule(10);
            layoutParams2.addRule(9);
            layoutParams2.leftMargin = ViewUtils.dip2px(16.0f);
            layoutParams2.topMargin = ViewUtils.dip2px(16.0f);
            layoutParams2.rightMargin = 0;
            layoutParams2.bottomMargin = 0;
            rotateLayout.setLayoutParams(layoutParams2);
            return;
        }
        if (i3 == 270) {
            RotateLayout.LayoutParams layoutParams3 = (RotateLayout.LayoutParams) viewGroup.getLayoutParams();
            layoutParams3.f77225a = -90;
            viewGroup.setLayoutParams(layoutParams3);
            RotateLayout rotateLayout2 = (RotateLayout) viewGroup.getParent();
            RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) rotateLayout2.getLayoutParams();
            layoutParams4.removeRule(10);
            layoutParams4.removeRule(9);
            layoutParams4.addRule(11);
            layoutParams4.addRule(12);
            layoutParams4.leftMargin = 0;
            layoutParams4.topMargin = 0;
            layoutParams4.rightMargin = ViewUtils.dip2px(16.0f);
            layoutParams4.bottomMargin = ViewUtils.dip2px(16.0f);
            rotateLayout2.setLayoutParams(layoutParams4);
            return;
        }
        QLog.e("AVSpokesmanPart", 2, "adjustSpokesmanPosAndRotation. rotation invalid");
    }

    private String z9(ArrayList<b> arrayList) {
        StringBuilder sb5;
        boolean z16;
        SessionInfo f16 = n.e().f();
        int g16 = AVUtil.g(f16.f73067q);
        int i3 = 0;
        int i16 = 1;
        if (arrayList.size() > 0) {
            sb5 = new StringBuilder();
            int i17 = 3;
            int[] iArr = {-1, -1, -1};
            for (int i18 = 0; i18 < arrayList.size(); i18++) {
                if (QLog.isDevelopLevel()) {
                    QLog.d("AVSpokesmanPart", 2, "speakingInfoList. idx = " + i18 + ", uin = " + arrayList.get(i18).f76587a + ", audioEnergy = " + arrayList.get(i18).f76588b);
                }
                int i19 = iArr[0];
                if (i19 != -1 && arrayList.get(i19).f76588b >= arrayList.get(i18).f76588b) {
                    int i26 = iArr[1];
                    if (i26 != -1 && arrayList.get(i26).f76588b >= arrayList.get(i18).f76588b) {
                        int i27 = iArr[2];
                        if (i27 == -1 || arrayList.get(i27).f76588b < arrayList.get(i18).f76588b) {
                            iArr[2] = i18;
                        }
                    } else {
                        iArr[2] = iArr[1];
                        iArr[1] = i18;
                    }
                } else {
                    iArr[2] = iArr[1];
                    iArr[1] = iArr[0];
                    iArr[0] = i18;
                }
            }
            int i28 = 0;
            while (i28 < this.f76578f.size()) {
                int i29 = i3;
                while (i29 < 3 && iArr[i29] >= 0) {
                    if (this.f76578f.get(i28).f76587a.equalsIgnoreCase(arrayList.get(iArr[i29]).f76587a)) {
                        z16 = true;
                        break;
                    }
                    i29++;
                }
                z16 = false;
                if (z16) {
                    arrayList.get(iArr[i29]).f76587a = "";
                    this.f76578f.get(i28).f76588b = arrayList.get(iArr[i29]).f76588b;
                } else {
                    this.f76578f.get(i28).f76587a = "";
                }
                i28++;
                i3 = 0;
            }
            int i36 = 0;
            int i37 = 0;
            while (i36 < this.f76578f.size()) {
                if (this.f76578f.get(i36).f76587a.equalsIgnoreCase("")) {
                    while (true) {
                        if (i37 >= 3) {
                            break;
                        }
                        int i38 = iArr[i37];
                        if (i38 < 0) {
                            break;
                        }
                        if (!arrayList.get(i38).f76587a.equalsIgnoreCase("")) {
                            this.f76578f.get(i36).f76587a = arrayList.get(iArr[i37]).f76587a;
                            this.f76578f.get(i36).f76588b = arrayList.get(iArr[i37]).f76588b;
                            arrayList.get(iArr[i37]).f76587a = "";
                            i37++;
                            break;
                        }
                        i37++;
                    }
                    if (i37 < 3 && iArr[i37] < 0) {
                        this.f76578f.remove(i36);
                        i36--;
                    }
                }
                i36++;
            }
            int size = this.f76578f.size();
            while (size < i16) {
                while (true) {
                    if (i37 >= i17) {
                        break;
                    }
                    int i39 = iArr[i37];
                    if (i39 >= 0) {
                        if (!arrayList.get(i39).f76587a.equalsIgnoreCase("")) {
                            this.f76578f.add(new b(arrayList.get(iArr[i37]).f76587a, arrayList.get(iArr[i37]).f76588b));
                            arrayList.get(iArr[i37]).f76587a = "";
                            i37++;
                            break;
                        }
                        i37++;
                        i17 = 3;
                    }
                }
                size++;
                i16 = 1;
                i17 = 3;
            }
            for (int i46 = 0; i46 < this.f76578f.size(); i46++) {
                if (QLog.isDevelopLevel()) {
                    QLog.d("AVSpokesmanPart", 2, "speakingInfoList. uin = " + this.f76578f.get(i46).f76587a + ", audioEnergy = " + this.f76578f.get(i46).f76588b);
                }
                String G = nw.b.b().G(g16, this.f76578f.get(i46).f76587a, String.valueOf(f16.P0));
                if (com.tencent.av.utils.i.e(G) > 6) {
                    G = com.tencent.av.utils.i.h(G, 0, 6) + MiniBoxNoticeInfo.APPNAME_SUFFIX;
                }
                if (i46 < this.f76578f.size() - 1) {
                    sb5.append(G);
                    sb5.append(getContext().getString(R.string.f1784036k));
                } else {
                    sb5.append(G);
                }
            }
        } else {
            sb5 = new StringBuilder();
        }
        if (r.h0().Y().size() == 0 || (r.h0().Y().size() == 1 && r.h0().Y().get(0).f73701a == Long.parseLong(nw.b.b().getCurrentAccountUin()))) {
            sb5 = new StringBuilder();
        }
        return sb5.toString();
    }
}
