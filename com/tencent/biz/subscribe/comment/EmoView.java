package com.tencent.biz.subscribe.comment;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import com.tencent.biz.subscribe.comment.WorkSpaceView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

/* compiled from: P */
/* loaded from: classes5.dex */
public class EmoView extends LinearLayout implements WorkSpaceView.a, j {
    private EditText C;
    private Handler D;
    private boolean E;
    private final int F;
    private d G;
    private boolean[] H;
    private int I;
    private int J;
    private d K;
    private boolean L;

    /* renamed from: d, reason: collision with root package name */
    private int f95924d;

    /* renamed from: e, reason: collision with root package name */
    private int f95925e;

    /* renamed from: f, reason: collision with root package name */
    private WorkSpaceView f95926f;

    /* renamed from: h, reason: collision with root package name */
    private Activity f95927h;

    /* renamed from: i, reason: collision with root package name */
    private LinearLayout f95928i;

    /* renamed from: m, reason: collision with root package name */
    private WorkSpaceView.a f95929m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class a extends Handler {
        a() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i3;
            if (message.what == 0 && (i3 = EmoView.this.I + 1) <= 4 && !EmoView.this.H[EmoView.this.I]) {
                EmoView.this.m(i3);
                EmoView.this.H[EmoView.this.I] = true;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class b implements AdapterView.OnItemClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f95934d;

        b(int i3) {
            this.f95934d = i3;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i3, long j3) {
            EventCollector.getInstance().onItemClickBefore(adapterView, view, i3, j3);
            boolean z16 = false;
            if (i3 == 27) {
                if (EmoView.this.G != null) {
                    z16 = EmoView.this.G.b();
                }
                if (!z16) {
                    EmoView.this.K.b();
                }
            } else {
                int i16 = ((this.f95934d - 1) * 27) + i3;
                if (i16 < 107) {
                    String str = o.f96034e[h.C[i16]];
                    if (EmoView.this.G != null) {
                        z16 = EmoView.this.G.a(str);
                    }
                    if (!z16) {
                        EmoView.this.K.a(str);
                    }
                }
            }
            EventCollector.getInstance().onItemClick(adapterView, view, i3, j3);
        }
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    class c implements d {
        c() {
        }

        @Override // com.tencent.biz.subscribe.comment.EmoView.d
        public boolean a(String str) {
            if (EmoView.this.C == null) {
                return false;
            }
            if (EmoView.this.J > 0 && EmoView.this.C.getText().length() + str.length() > EmoView.this.J) {
                QQToast.makeText(EmoView.this.getContext(), 0, HardCodeUtil.qqStr(R.string.m8u), 0);
                return false;
            }
            EmoView.l(EmoView.this.C, str);
            return true;
        }

        @Override // com.tencent.biz.subscribe.comment.EmoView.d
        public boolean b() {
            if (EmoView.this.C == null) {
                return false;
            }
            EmoView.this.C.dispatchKeyEvent(new KeyEvent(0L, 0L, 0, 67, 0, 0));
            return true;
        }
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public interface d {
        boolean a(String str);

        boolean b();
    }

    public EmoView(Context context) {
        this(context, null);
    }

    private void j() {
        WorkSpaceView workSpaceView = new WorkSpaceView(getContext());
        this.f95926f = workSpaceView;
        workSpaceView.setOnScreenChangeListener(this);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 81;
        this.f95926f.setLayoutParams(layoutParams);
        a aVar = new a();
        this.D = aVar;
        this.f95926f.setHandler(aVar);
        LinearLayout linearLayout = new LinearLayout(getContext());
        this.f95928i = linearLayout;
        linearLayout.setOrientation(0);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 81;
        this.f95928i.setPadding(0, 13, 0, 13);
        this.f95928i.setLayoutParams(layoutParams2);
        super.addView(this.f95926f);
        super.addView(this.f95928i);
    }

    private static void k(EditText editText, int i3, String str) {
        editText.getText().insert(i3, str);
        String obj = editText.getText().toString();
        if (str.length() + i3 > obj.length()) {
            editText.setSelection(obj.length());
        } else {
            editText.setSelection(i3 + str.length());
        }
    }

    public static void l(EditText editText, String str) {
        int selectionStart = editText.getSelectionStart();
        if (selectionStart >= editText.length()) {
            try {
                editText.append(str);
                return;
            } catch (Exception unused) {
                k(editText, selectionStart, str);
                return;
            }
        }
        k(editText, selectionStart, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m(final int i3) {
        int i16 = 27;
        int ceil = (int) Math.ceil(107.0d / (27 * 1.0d));
        final GridView gridView = (GridView) LayoutInflater.from(getContext()).inflate(R.layout.f167710eq, (ViewGroup) null);
        gridView.setNumColumns(7);
        if (i3 == ceil) {
            i16 = 26;
        }
        final h hVar = new h(getContext(), i3, i16, 28, i3, this);
        gridView.setAdapter((ListAdapter) hVar);
        gridView.setColumnWidth(this.f95927h.getWindowManager().getDefaultDisplay().getWidth() / 7);
        gridView.setLayoutParams(new ViewGroup.LayoutParams(-1, ScreenUtil.dip2px(196.0f)));
        this.f95926f.addView(gridView);
        postDelayed(new Runnable() { // from class: com.tencent.biz.subscribe.comment.EmoView.2
            @Override // java.lang.Runnable
            public void run() {
                QLog.d("CommentInputPopupWindow", 1, "GridView initPage:" + i3 + "  currentView size:" + gridView.getWidth() + "  " + gridView.getHeight() + "  dataSize:" + hVar.getCount());
            }
        }, 1000L);
        gridView.setOnItemClickListener(new b(i3));
    }

    private void n(int i3) {
        int childCount = this.f95928i.getChildCount();
        for (int i16 = 0; i16 < childCount; i16++) {
            this.f95928i.getChildAt(i16).setSelected(false);
        }
        View childAt = this.f95928i.getChildAt(i3);
        if (childAt != null) {
            childAt.setSelected(true);
        }
    }

    @Override // com.tencent.biz.subscribe.comment.WorkSpaceView.a
    public void a(int i3) {
        this.I = i3 + 1;
        n(i3);
        WorkSpaceView.a aVar = this.f95929m;
        if (aVar != null) {
            aVar.a(i3);
        }
    }

    @Override // com.tencent.biz.subscribe.comment.j
    public void b(int i3, int i16) {
        if (i3 == 27) {
            this.K.b();
            return;
        }
        int i17 = ((i16 - 1) * 27) + i3;
        if (i17 < 107) {
            this.K.a(o.f96034e[h.C[i17]]);
        }
    }

    public void setNavgationVisible(boolean z16) {
        int i3;
        LinearLayout linearLayout = this.f95928i;
        if (linearLayout != null) {
            if (z16) {
                i3 = 0;
            } else {
                i3 = 8;
            }
            linearLayout.setVisibility(i3);
        }
    }

    public void setOnScreenChangeListener(WorkSpaceView.a aVar) {
        this.f95929m = aVar;
    }

    public EmoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f95924d = R.drawable.f160432h6;
        this.f95925e = R.drawable.f160432h6;
        this.E = false;
        this.F = 28;
        this.H = new boolean[]{true, false, false, false};
        this.I = 1;
        this.J = -1;
        this.K = new c();
        this.L = true;
        setOrientation(1);
        j();
    }
}
