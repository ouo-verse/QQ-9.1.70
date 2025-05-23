package com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.panel;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.DoodleColorAndModeView;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.panel.AEDoodlePenWidthSeekBar;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.panel.DoodlePanel;
import com.tencent.mobileqq.R;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;

/* loaded from: classes32.dex */
public class DoodleShapePanel extends RelativeLayout {

    /* renamed from: d, reason: collision with root package name */
    protected DoodleColorAndModeView f68596d;

    /* renamed from: e, reason: collision with root package name */
    protected AEDoodlePenWidthSeekBar f68597e;

    /* renamed from: f, reason: collision with root package name */
    private RelativeLayout f68598f;

    /* renamed from: h, reason: collision with root package name */
    private d f68599h;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes32.dex */
    public class b implements AEDoodlePenWidthSeekBar.a {
        b() {
        }

        @Override // com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.panel.AEDoodlePenWidthSeekBar.a
        public void a(float f16) {
            if (DoodleShapePanel.this.f68599h != null) {
                DoodleShapePanel.this.f68599h.c(f16);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes32.dex */
    public class c implements View.OnClickListener {
        c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (DoodleShapePanel.this.f68599h != null) {
                DoodleShapePanel.this.f68599h.b();
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* loaded from: classes32.dex */
    public interface d {
        void a(int i3);

        void b();

        void c(float f16);
    }

    public DoodleShapePanel(Context context) {
        this(context, null);
    }

    protected int b() {
        return R.layout.dtj;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c() {
        LayoutInflater.from(getContext()).inflate(b(), this);
        DoodleColorAndModeView doodleColorAndModeView = (DoodleColorAndModeView) findViewById(R.id.yij);
        this.f68596d = doodleColorAndModeView;
        doodleColorAndModeView.setColorSelectListener(new a());
        AEDoodlePenWidthSeekBar aEDoodlePenWidthSeekBar = (AEDoodlePenWidthSeekBar) findViewById(R.id.ilm);
        this.f68597e = aEDoodlePenWidthSeekBar;
        aEDoodlePenWidthSeekBar.setOnSeekBarChangeListener(new b());
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.f100915ts);
        this.f68598f = relativeLayout;
        relativeLayout.setOnClickListener(new c());
    }

    public void setPanelListener(d dVar) {
        this.f68599h = dVar;
    }

    public void setSelectedColorAndWidth(int i3, float f16) {
        ArrayList arrayList = new ArrayList();
        for (int i16 : DoodlePanel.F) {
            arrayList.add(Integer.valueOf(i16));
        }
        ArrayList arrayList2 = new ArrayList();
        for (String str : DoodlePanel.G) {
            arrayList2.add(str);
        }
        this.f68596d.d(arrayList, arrayList2, true, i3);
        this.f68597e.setProgress(f16);
    }

    public DoodleShapePanel(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        c();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes32.dex */
    public class a implements DoodleColorAndModeView.d {
        a() {
        }

        @Override // com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.DoodleColorAndModeView.d
        public void c(int i3, int i16) {
            if (DoodleShapePanel.this.f68599h == null || i3 != 1) {
                return;
            }
            DoodleShapePanel.this.f68599h.a(i16);
        }

        @Override // com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.DoodleColorAndModeView.d
        public void a(DoodlePanel.PenMode penMode) {
        }
    }
}
