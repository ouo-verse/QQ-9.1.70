package com.tencent.mobileqq.widget;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityEvent;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.ams.dsdk.monitor.metric.event.TagName;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.util.QQUITextToSpeechHelper;
import com.tencent.xweb.FileReaderHelper;
import java.util.ArrayList;
import java.util.Map;
import java.util.Objects;

/* compiled from: P */
/* loaded from: classes20.dex */
public class k extends ReportDialog {
    private LayoutInflater C;
    private View D;
    private RelativeLayout E;
    String F;
    private String G;
    private String H;
    private int I;
    private boolean J;
    private Map<String, Object> K;
    private int L;
    private int M;
    private d N;

    /* compiled from: P */
    /* loaded from: classes20.dex */
    class a implements URLDrawable.URLDrawableListener {
        a() {
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadCanceled(URLDrawable uRLDrawable) {
            QLog.e("DocsOverCapacityDialog", 1, " onLoadCanceled: ");
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadFialed(URLDrawable uRLDrawable, Throwable th5) {
            QLog.e("DocsOverCapacityDialog", 1, " onLoadFialed: ", th5);
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadProgressed(URLDrawable uRLDrawable, int i3) {
            QLog.i("DocsOverCapacityDialog", 1, " onLoadProgressed: " + i3);
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadSuccessed(URLDrawable uRLDrawable) {
            QLog.i("DocsOverCapacityDialog", 1, " onLoadSuccessed");
        }
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    class b implements URLDrawable.DownloadListener {
        b() {
        }

        @Override // com.tencent.image.URLDrawable.DownloadListener
        public void onFileDownloadFailed(int i3) {
            QLog.e("DocsOverCapacityDialog", 1, " onFileDownloadFailed");
        }

        @Override // com.tencent.image.URLDrawable.DownloadListener
        public void onFileDownloadStarted() {
            QLog.i("DocsOverCapacityDialog", 1, " onFileDownloadStarted");
        }

        @Override // com.tencent.image.URLDrawable.DownloadListener
        public void onFileDownloadSucceed(long j3) {
            QLog.i("DocsOverCapacityDialog", 1, " onFileDownloadSucceed");
        }
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    class c implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f316924d;

        c(String str) {
            this.f316924d = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            k.this.N.a("https://docs.qq.com/vip/h5-pay?rights_id=cloud&aid=" + this.f316924d);
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public interface d {
        void a(String str);
    }

    public k(Context context, Map<String, Object> map, String str) {
        this(context, map, str, 40);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Q(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        dismiss();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void R(String str, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        d dVar = this.N;
        if (dVar != null) {
            if (this.J) {
                dVar.a("https://docs.qq.com/vip/capacity-pay?aid=" + str);
            } else {
                dVar.a("https://docs.qq.com/vip/h5-pay?aid=" + str);
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    public void S(d dVar) {
        this.N = dVar;
    }

    @Override // com.tencent.mobileqq.qui.dialog.QUICompatDialog, android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        try {
            try {
                super.dismiss();
            } catch (Exception e16) {
                QLog.e("DocsOverCapacityDialog", 1, "DocsOverCapacityDialog dismiss exception = " + e16);
            }
        } finally {
            sy3.a.a(this);
        }
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        if (TextUtils.isEmpty(this.F)) {
            return super.dispatchPopulateAccessibilityEvent(accessibilityEvent);
        }
        if (az.f316688b) {
            QQUITextToSpeechHelper.speak(this.F);
            return true;
        }
        return true;
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        super.onBackPressed();
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        int i3;
        String str;
        ArrayList arrayList;
        ArrayList arrayList2;
        super.onCreate(bundle);
        Window window = getWindow();
        window.setContentView(this.D);
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.width = -1;
        attributes.height = this.M;
        attributes.gravity = this.L;
        attributes.y += this.I;
        window.setAttributes(attributes);
        int i16 = 1;
        setCanceledOnTouchOutside(true);
        String str2 = "";
        if (!this.K.isEmpty()) {
            Object obj = this.K.get("vipLevel");
            if (obj != null) {
                i3 = ((Integer) obj).intValue();
            } else {
                i3 = 1;
            }
            Object obj2 = this.K.get(TagName.FILE_TYPE);
            if (obj2 != null) {
                this.H = (String) obj2;
            }
            Object obj3 = this.K.get("topIcon");
            if (obj3 != null) {
                str2 = (String) obj3;
            }
        } else {
            i3 = 1;
        }
        if (i3 == 3) {
            this.J = true;
        }
        if (Objects.equals(this.G, "qqscan")) {
            str = "exportdoc";
        } else if (Objects.equals(this.H, FileReaderHelper.PDF_EXT)) {
            str = "pdf2word";
        } else {
            str = "swtichtooldoc";
        }
        final String str3 = "txdocs_an_h5_" + this.G + "_space_" + str + "_" + this.H;
        URLImageView uRLImageView = (URLImageView) window.findViewById(R.id.f1198077u);
        uRLImageView.setVisibility(0);
        if (!str2.isEmpty()) {
            URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
            obtain.mLoadingDrawable = BaseApplication.context.getResources().getDrawable(R.drawable.m1c);
            obtain.mFailedDrawable = BaseApplication.context.getResources().getDrawable(R.drawable.m1c);
            URLDrawable drawable = URLDrawable.getDrawable(str2, obtain);
            drawable.setURLDrawableListener(new a());
            drawable.setDownloadListener(new b());
            uRLImageView.setImageDrawable(drawable);
        }
        ((ImageButton) window.findViewById(R.id.az_)).setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.widget.i
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                k.this.Q(view);
            }
        });
        Button button = (Button) window.findViewById(R.id.zz8);
        button.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.widget.j
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                k.this.R(str3, view);
            }
        });
        TextView textView = (TextView) window.findViewById(R.id.title);
        if (this.K.containsKey("mainTitle") && (arrayList2 = (ArrayList) this.K.get("mainTitle")) != null) {
            Map map = (Map) arrayList2.get(0);
            String str4 = (String) map.get("text");
            Objects.requireNonNull(str4);
            if (!str4.isEmpty()) {
                textView.setText((CharSequence) map.get("text"));
            } else if (this.J) {
                textView.setText(R.string.f170860zt3);
            } else {
                textView.setText(R.string.f170858zt1);
            }
        }
        TextView textView2 = (TextView) window.findViewById(R.id.f900351d);
        TextView textView3 = (TextView) window.findViewById(R.id.f900451e);
        TextView textView4 = (TextView) window.findViewById(R.id.f900551f);
        if (this.K.containsKey("description")) {
            ArrayList arrayList3 = (ArrayList) this.K.get("description");
            int i17 = 0;
            while (true) {
                Objects.requireNonNull(arrayList3);
                if (i17 >= arrayList3.size() || i17 >= 3) {
                    break;
                }
                String str5 = (String) ((Map) arrayList3.get(i17)).get("text");
                if (!str5.isEmpty()) {
                    if (i17 != 0) {
                        if (i17 != 1) {
                            if (i17 == 2) {
                                textView4.setText(str5);
                                textView4.setVisibility(0);
                            }
                        } else {
                            textView3.setText(str5);
                            textView3.setVisibility(0);
                        }
                    } else {
                        textView2.setText(str5);
                        textView2.setVisibility(0);
                    }
                }
                i17++;
            }
        }
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.f97775la);
        LinearLayout linearLayout2 = (LinearLayout) findViewById(R.id.f97785lb);
        LinearLayout linearLayout3 = (LinearLayout) findViewById(R.id.f97795lc);
        TextView textView5 = (TextView) findViewById(R.id.f97685l2);
        TextView textView6 = (TextView) findViewById(R.id.f97695l3);
        TextView textView7 = (TextView) findViewById(R.id.f97705l4);
        if (this.K.containsKey("mainContent")) {
            ArrayList arrayList4 = (ArrayList) this.K.get("mainContent");
            int i18 = 0;
            while (true) {
                Objects.requireNonNull(arrayList4);
                if (i18 >= arrayList4.size() || i18 >= 3) {
                    break;
                }
                String str6 = (String) ((Map) arrayList4.get(i18)).get("text");
                if (!str6.isEmpty()) {
                    if (i18 != 0) {
                        if (i18 != i16) {
                            if (i18 == 2) {
                                textView7.setText(str6);
                                linearLayout3.setVisibility(0);
                            }
                        } else {
                            textView6.setText(str6);
                            linearLayout2.setVisibility(0);
                        }
                    } else {
                        textView5.setText(str6);
                        linearLayout.setVisibility(0);
                    }
                }
                i18++;
                i16 = 1;
            }
        }
        TextView textView8 = (TextView) findViewById(R.id.f165994yc3);
        if (this.K.containsKey("moreInfo") && (arrayList = (ArrayList) this.K.get("moreInfo")) != null) {
            Map map2 = (Map) arrayList.get(0);
            String str7 = (String) map2.get("text");
            Objects.requireNonNull(str7);
            if (!str7.isEmpty()) {
                textView8.setText((CharSequence) map2.get("text"));
            }
        }
        textView8.setOnClickListener(new c(str3));
        if (this.J) {
            button.setText(R.string.zsy);
        }
    }

    @Override // android.app.Dialog
    protected void onStart() {
        super.onStart();
    }

    @Override // com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog, android.app.Dialog
    protected void onStop() {
        super.onStop();
    }

    public k(Context context, Map<String, Object> map, String str, int i3) {
        this(context, map, str, i3, R.layout.e6c);
    }

    public k(Context context, Map<String, Object> map, String str, int i3, int i16) {
        super(context, R.style.qZoneInputDialog);
        this.G = "qqlocalbar";
        this.H = FileReaderHelper.DOC_EXT;
        this.J = false;
        this.L = 81;
        this.M = -2;
        LayoutInflater from = LayoutInflater.from(context);
        this.C = from;
        View inflate = from.inflate(i16, (ViewGroup) null);
        this.D = inflate;
        this.E = (RelativeLayout) inflate.findViewById(R.id.uk8);
        this.K = map;
        this.I = i3;
        this.G = str;
    }
}
