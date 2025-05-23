package com.qzone.widget.copyabletextview;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.ClipboardManager;
import android.text.method.MovementMethod;
import android.util.AttributeSet;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.qzone.common.activities.base.BaseActivity;
import com.qzone.util.l;
import com.qzone.widget.copyabletextview.component.SelectableTextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmini.sdk.core.utils.WnsConfig;
import common.config.service.QzoneConfig;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import w6.a;

/* compiled from: P */
/* loaded from: classes37.dex */
public class CopyableTextView extends RelativeLayout implements SelectableTextView.a, View.OnClickListener {
    public static ArrayList<WeakReference<CopyableTextView>> H;
    private View.OnCreateContextMenuListener C;
    private MenuItem.OnMenuItemClickListener D;
    private BaseActivity.b E;
    private boolean F;
    private ClipboardManager G;

    /* renamed from: d, reason: collision with root package name */
    private SelectableTextView f60730d;

    /* renamed from: e, reason: collision with root package name */
    private View f60731e;

    /* renamed from: f, reason: collision with root package name */
    private SelectableTextView.a f60732f;

    /* renamed from: h, reason: collision with root package name */
    private float f60733h;

    /* renamed from: i, reason: collision with root package name */
    private Context f60734i;

    /* renamed from: m, reason: collision with root package name */
    private String f60735m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes37.dex */
    public class a implements View.OnLongClickListener {
        a() {
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            EventCollector.getInstance().onViewLongClickedBefore(view);
            view.showContextMenu();
            EventCollector.getInstance().onViewLongClicked(view);
            return true;
        }
    }

    /* compiled from: P */
    /* loaded from: classes37.dex */
    class b implements View.OnCreateContextMenuListener {
        b() {
        }

        @Override // android.view.View.OnCreateContextMenuListener
        public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
            char charAt;
            if (CopyableTextView.this.f60730d == null) {
                return;
            }
            CopyableTextView copyableTextView = CopyableTextView.this;
            copyableTextView.f60735m = copyableTextView.f60730d.getText().toString();
            int length = CopyableTextView.this.f60735m.length();
            int i3 = 0;
            for (int i16 = 0; i16 < CopyableTextView.this.f60735m.length() && ((charAt = CopyableTextView.this.f60735m.charAt(i16)) == ' ' || charAt == '\r' || charAt == '\n'); i16++) {
                i3++;
            }
            for (int length2 = CopyableTextView.this.f60735m.length() - 1; length2 >= 0; length2--) {
                char charAt2 = CopyableTextView.this.f60735m.charAt(length2);
                if (charAt2 != ' ' && charAt2 != '\r' && charAt2 != '\n') {
                    break;
                }
                length--;
            }
            CopyableTextView.this.f60730d.h(i3, length);
            CopyableTextView.this.f60730d.setSelecting(true);
            contextMenu.setHeaderTitle(QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "TextViewCopyContent", "\u590d\u5236\u5185\u5bb9"));
            contextMenu.add(0, 100, 0, l.a(R.string.l4t)).setOnMenuItemClickListener(CopyableTextView.this.D);
            contextMenu.add(0, 101, 0, l.a(R.string.j6l)).setOnMenuItemClickListener(CopyableTextView.this.D);
            if (CopyableTextView.this.E == null) {
                CopyableTextView copyableTextView2 = CopyableTextView.this;
                copyableTextView2.E = new d();
            }
            if (CopyableTextView.this.f60734i instanceof BaseActivity) {
                ((BaseActivity) CopyableTextView.this.f60734i).setOnContextMenuClosedListener(CopyableTextView.this.E);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes37.dex */
    class c implements MenuItem.OnMenuItemClickListener {
        c() {
        }

        @Override // android.view.MenuItem.OnMenuItemClickListener
        public boolean onMenuItemClick(MenuItem menuItem) {
            if (menuItem.getItemId() != 100 || CopyableTextView.this.f60730d == null) {
                return true;
            }
            CopyableTextView copyableTextView = CopyableTextView.this;
            copyableTextView.j(copyableTextView.f60735m);
            return true;
        }
    }

    /* compiled from: P */
    /* loaded from: classes37.dex */
    class d implements BaseActivity.b {
        d() {
        }

        @Override // com.qzone.common.activities.base.BaseActivity.b
        public void onContextMenuClosed(Menu menu) {
            if (CopyableTextView.this.f60730d != null) {
                CopyableTextView.this.f60730d.setSelecting(false);
            }
            if (CopyableTextView.this.f60734i instanceof BaseActivity) {
                ((BaseActivity) CopyableTextView.this.f60734i).setOnContextMenuClosedListener(null);
            }
        }
    }

    public CopyableTextView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f60732f = null;
        this.f60734i = null;
        this.f60735m = null;
        this.C = new b();
        this.D = new c();
        this.E = null;
        this.F = false;
        p(context, attributeSet);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(String str) {
        try {
            if (this.G == null) {
                this.G = (ClipboardManager) getContext().getSystemService("clipboard");
            }
            this.G.setText(str);
            QQToast.makeText(getContext(), QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "ToastCopySuccess", "\u590d\u5236\u6210\u529f"), 0).show();
        } catch (Exception unused) {
            QQToast.makeText(getContext(), QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "ToastCopyFail", "\u590d\u5236\u5931\u8d25"), 0).show();
        }
    }

    private void p(Context context, AttributeSet attributeSet) {
        this.f60733h = getContext().getResources().getDisplayMetrics().density;
        SelectableTextView selectableTextView = new SelectableTextView(context, attributeSet);
        this.f60730d = selectableTextView;
        addView(selectableTextView);
        if (H == null) {
            H = new ArrayList<>();
        }
        H.add(new WeakReference<>(this));
        setOnCreateContextMenuListener(this.C);
        setLongClickable(true);
        this.f60734i = context;
        setOnLongClickListener(new a());
    }

    @Override // com.qzone.widget.copyabletextview.component.SelectableTextView.a
    public void a() {
        SelectableTextView.a aVar = this.f60732f;
        if (aVar == null) {
            View view = this.f60731e;
            if (view != null) {
                view.setVisibility(8);
            }
        } else {
            aVar.a();
        }
        this.f60730d.setSelecting(false);
    }

    public View k() {
        if (this.f60731e == null) {
            Button button = new Button(getContext());
            button.setGravity(17);
            button.setText(l.a(R.string.l4s));
            button.setTextSize(2, 12.0f);
            button.setTextColor(-1);
            button.setBackgroundResource(R.drawable.bup);
            button.setOnClickListener(this);
            float f16 = this.f60733h;
            int i3 = (int) ((15.0f * f16) + 0.5f);
            button.setPadding(i3, i3, i3, (int) ((f16 * 26.0f) + 0.5f));
            LinearLayout linearLayout = new LinearLayout(getContext());
            linearLayout.setOrientation(0);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.bottomMargin = (int) ((this.f60733h * 10.0f) + 0.5d);
            linearLayout.addView(button, layoutParams);
            this.f60731e = linearLayout;
            linearLayout.setVisibility(8);
        }
        return this.f60731e;
    }

    public Drawable l() {
        float f16 = this.f60733h;
        int i3 = (int) ((f16 * 16.0f) + 0.5f);
        int i16 = (int) ((f16 * 16.0f) + 0.5f);
        BitmapDrawable bitmapDrawable = new BitmapDrawable(com.qzone.util.image.c.t(getResources(), R.drawable.buu, i3, i16));
        bitmapDrawable.setBounds(0, 0, i3, i16);
        return bitmapDrawable;
    }

    public Drawable m() {
        float f16 = this.f60733h;
        int i3 = (int) ((f16 * 16.0f) + 0.5f);
        int i16 = (int) ((f16 * 16.0f) + 0.5f);
        BitmapDrawable bitmapDrawable = new BitmapDrawable(com.qzone.util.image.c.t(getResources(), R.drawable.buu, i3, i16));
        bitmapDrawable.setBounds(0, 0, i3, i16);
        return bitmapDrawable;
    }

    public SelectableTextView n() {
        return this.f60730d;
    }

    public int o() {
        return -15031834;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String str;
        EventCollector.getInstance().onViewClickedBefore(view);
        int d16 = this.f60730d.d();
        int c16 = this.f60730d.c();
        if (c16 <= d16 || d16 < 0 || c16 > this.f60730d.getText().length()) {
            str = null;
        } else {
            str = this.f60730d.getText().toString().substring(d16, c16);
            this.f60730d.h(0, 0);
        }
        if (str != null) {
            ((ClipboardManager) getContext().getSystemService("clipboard")).setText(str);
            QQToast.makeText(getContext(), QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "ToastCopySuccess", "\u590d\u5236\u6210\u529f"), 0).show();
        }
        a();
        EventCollector.getInstance().onViewClicked(view);
    }

    public void q() {
        if (this.F) {
            this.F = false;
        } else {
            a();
        }
    }

    public void setAutoLinkMask(int i3) {
        this.f60730d.setAutoLinkMask(i3);
    }

    public void setBg(int i3) {
        this.f60730d.setBackgroundResource(i3);
    }

    public void setDelegateChain(SelectableTextView.a aVar) {
        this.f60732f = aVar;
    }

    @Override // android.view.View
    public void setLayoutParams(ViewGroup.LayoutParams layoutParams) {
        super.setLayoutParams(layoutParams);
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.f60730d.getLayoutParams();
        layoutParams2.width = layoutParams.width;
        layoutParams2.height = layoutParams.height;
        this.f60730d.setLayoutParams(layoutParams2);
    }

    public void setMovementMethod(MovementMethod movementMethod) {
        this.f60730d.setMovementMethod(movementMethod);
    }

    public void setOnCustomUrlClickListener(a.InterfaceC11463a interfaceC11463a) {
        this.f60730d.setOnCustomUrlClickListener(interfaceC11463a);
    }

    public void setParseUrl(boolean z16) {
        this.f60730d.setParseUrl(z16);
    }

    public void setText(CharSequence charSequence) {
        this.f60730d.setText(charSequence);
    }

    public void setTextColor(int i3) {
        this.f60730d.setTextColor(i3);
    }

    public void setTextSize(float f16) {
        this.f60730d.setTextSize(f16);
    }

    public void setTextViewIdForTheme(int i3) {
        this.f60730d.setId(i3);
    }

    public void setUrlColorRes(int i3) {
        this.f60730d.setUrlColorRes(i3);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        this.F = true;
        return super.dispatchTouchEvent(motionEvent);
    }

    public CopyableTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f60732f = null;
        this.f60734i = null;
        this.f60735m = null;
        this.C = new b();
        this.D = new c();
        this.E = null;
        this.F = false;
        p(context, attributeSet);
    }

    public CopyableTextView(Context context) {
        super(context);
        this.f60732f = null;
        this.f60734i = null;
        this.f60735m = null;
        this.C = new b();
        this.D = new c();
        this.E = null;
        this.F = false;
        p(context, null);
    }
}
