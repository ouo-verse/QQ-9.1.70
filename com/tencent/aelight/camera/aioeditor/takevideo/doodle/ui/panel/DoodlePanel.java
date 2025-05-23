package com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.panel;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.DoodleColorAndModeView;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.panel.AEDoodlePenWidthSeekBar;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;

/* loaded from: classes32.dex */
public class DoodlePanel extends RelativeLayout implements View.OnClickListener {
    public static final int[] F = {-14079703, -1, -1027508, -1131223, -6038445, -12147713, -7768577, -496479};
    public static final String[] G = {"\u9ed1\u8272", "\u767d\u8272", "\u7ea2\u8272", "\u9ec4\u8272", "\u7eff\u8272", "\u84dd\u8272", "\u7d2b\u8272", "\u7c89\u8272"};
    private static final PenMode[] H = {PenMode.FREE_DRAW, PenMode.ERASER, PenMode.RECT, PenMode.OVAL, PenMode.ARROW, PenMode.LINE, PenMode.SEQUENCE_NUMBER};
    protected AEDoodlePenWidthSeekBar C;
    protected c D;
    private float E;

    /* renamed from: d, reason: collision with root package name */
    protected int f68588d;

    /* renamed from: e, reason: collision with root package name */
    protected DoodleColorAndModeView f68589e;

    /* renamed from: f, reason: collision with root package name */
    protected ImageView f68590f;

    /* renamed from: h, reason: collision with root package name */
    protected FrameLayout f68591h;

    /* renamed from: i, reason: collision with root package name */
    private TextView f68592i;

    /* renamed from: m, reason: collision with root package name */
    private TextView f68593m;

    /* loaded from: classes32.dex */
    public enum PenMode {
        FREE_DRAW,
        RECT,
        OVAL,
        LINE,
        ARROW,
        SEQUENCE_NUMBER,
        ERASER,
        MOSAIC,
        PEN_MODE_SUB_PANEL
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes32.dex */
    public class a implements DoodleColorAndModeView.d {
        a() {
        }

        @Override // com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.DoodleColorAndModeView.d
        public void a(PenMode penMode) {
            c cVar = DoodlePanel.this.D;
            if (cVar != null) {
                cVar.d(penMode);
            }
        }

        @Override // com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.DoodleColorAndModeView.d
        public void c(int i3, int i16) {
            c cVar = DoodlePanel.this.D;
            if (cVar != null) {
                if (i3 == 0) {
                    cVar.d(PenMode.MOSAIC);
                } else if (i3 == 1) {
                    cVar.a(i16);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes32.dex */
    public class b implements AEDoodlePenWidthSeekBar.a {
        b() {
        }

        @Override // com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.panel.AEDoodlePenWidthSeekBar.a
        public void a(float f16) {
            c cVar = DoodlePanel.this.D;
            if (cVar != null) {
                cVar.c(f16);
            }
        }
    }

    /* loaded from: classes32.dex */
    public interface c {
        void a(int i3);

        void b();

        void c(float f16);

        void d(PenMode penMode);

        void onFinish();
    }

    public DoodlePanel(Context context) {
        this(context, null);
    }

    protected int a() {
        return this.f68588d == 1 ? R.layout.dtl : R.layout.dth;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b() {
        LayoutInflater.from(getContext()).inflate(a(), this);
        DoodleColorAndModeView doodleColorAndModeView = (DoodleColorAndModeView) findViewById(R.id.yij);
        this.f68589e = doodleColorAndModeView;
        doodleColorAndModeView.setColorSelectListener(new a());
        this.E = TypedValue.applyDimension(1, 34.0f, getResources().getDisplayMetrics());
        this.f68591h = (FrameLayout) findViewById(R.id.yc6);
        ImageView imageView = (ImageView) findViewById(R.id.dyq);
        this.f68590f = imageView;
        if (imageView != null) {
            imageView.setOnClickListener(this);
        }
        AccessibilityUtil.c(this.f68590f, getResources().getString(R.string.y9s), Button.class.getName());
        this.f68592i = (TextView) findViewById(R.id.f167033k60);
        TextView textView = (TextView) findViewById(R.id.k6q);
        this.f68593m = textView;
        textView.setOnClickListener(this);
        this.f68592i.setOnClickListener(this);
        AEDoodlePenWidthSeekBar aEDoodlePenWidthSeekBar = (AEDoodlePenWidthSeekBar) findViewById(R.id.ilm);
        this.C = aEDoodlePenWidthSeekBar;
        aEDoodlePenWidthSeekBar.setOnSeekBarChangeListener(new b());
    }

    public void c(PenMode penMode, int i3, float f16) {
        ArrayList arrayList = new ArrayList();
        for (int i16 : F) {
            arrayList.add(Integer.valueOf(i16));
        }
        ArrayList arrayList2 = new ArrayList();
        for (String str : G) {
            arrayList2.add(str);
        }
        this.f68589e.d(arrayList, arrayList2, true, i3);
        this.C.setProgress(f16);
    }

    public boolean d() {
        return this.f68589e.f();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        c cVar;
        EventCollector.getInstance().onViewClickedBefore(view);
        int id5 = view.getId();
        if (id5 == R.id.dyq) {
            c cVar2 = this.D;
            if (cVar2 != null) {
                cVar2.b();
            }
        } else if ((id5 == R.id.f167033k60 || id5 == R.id.k6q) && (cVar = this.D) != null) {
            cVar.onFinish();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    public void setPanelListener(c cVar) {
        this.D = cVar;
    }

    public void setUndoEnabled(boolean z16) {
        ImageView imageView = this.f68590f;
        if (imageView != null) {
            imageView.setEnabled(z16);
            this.f68590f.setVisibility(z16 ? 0 : 4);
        }
    }

    public DoodlePanel(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f68588d = 0;
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.DoodleColorAndModeView);
            this.f68588d = obtainStyledAttributes.getInt(2, 0);
            obtainStyledAttributes.recycle();
        }
        b();
    }
}
