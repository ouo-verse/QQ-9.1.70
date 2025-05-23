package com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.panel.DoodlePanel;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.panel.EditButtonManager;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes32.dex */
public class DoodleSelectModeView extends FrameLayout {

    /* renamed from: e, reason: collision with root package name */
    private static final int[][] f68080e = {new int[]{R.id.tfv}, new int[]{R.id.tgk}};

    /* renamed from: f, reason: collision with root package name */
    private static final int[][] f68081f = {new int[]{R.id.th5}, new int[]{R.id.td9}, new int[]{R.id.afl}, new int[]{R.id.tf6}};

    /* renamed from: d, reason: collision with root package name */
    protected b f68082d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class a implements EditButtonManager.f {
        a() {
        }

        @Override // com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.panel.EditButtonManager.f
        public void a(View view, int i3) {
            DoodlePanel.PenMode penMode;
            ms.a.f("DoodleSelectModeView", "EditButtonManager--handleFun--index=" + i3);
            if (DoodleSelectModeView.this.f68082d != null) {
                switch (view.getId()) {
                    case R.id.afl /* 2131364460 */:
                        penMode = DoodlePanel.PenMode.ARROW;
                        break;
                    case R.id.f164653td2 /* 2131364474 */:
                    case R.id.tfv /* 2131364664 */:
                        penMode = DoodlePanel.PenMode.FREE_DRAW;
                        break;
                    case R.id.td9 /* 2131364491 */:
                        penMode = DoodlePanel.PenMode.OVAL;
                        break;
                    case R.id.tf6 /* 2131364619 */:
                        penMode = DoodlePanel.PenMode.LINE;
                        break;
                    case R.id.tgk /* 2131364708 */:
                        penMode = DoodlePanel.PenMode.ERASER;
                        break;
                    case R.id.th5 /* 2131364742 */:
                        penMode = DoodlePanel.PenMode.RECT;
                        break;
                    default:
                        penMode = null;
                        break;
                }
                if (penMode != null) {
                    DoodleSelectModeView.this.f68082d.a(penMode);
                }
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes32.dex */
    public interface b {
        void a(DoodlePanel.PenMode penMode);
    }

    public DoodleSelectModeView(Context context) {
        this(context, null);
    }

    protected int b() {
        return R.layout.du6;
    }

    public void setSelectModeListener(b bVar) {
        this.f68082d = bVar;
    }

    public void setUseCase(int i3) {
        new EditButtonManager(this, a(i3)).m(new a());
    }

    public DoodleSelectModeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        LayoutInflater.from(getContext()).inflate(b(), this);
    }

    protected int[][] a(int i3) {
        if (i3 == 1) {
            return f68081f;
        }
        return f68080e;
    }
}
