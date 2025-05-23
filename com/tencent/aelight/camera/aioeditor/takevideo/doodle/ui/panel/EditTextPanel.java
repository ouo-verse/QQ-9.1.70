package com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.panel;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import com.tencent.aelight.camera.aioeditor.capture.text.DynamicTextBuilder;
import com.tencent.aelight.camera.aioeditor.capture.text.DynamicTextConfigManager;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.panel.EditTextEffectView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.filemanager.util.FMDialogUtil;
import com.tencent.mobileqq.flashchat.d;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.util.c;
import com.tencent.open.base.ToastUtil;
import com.tencent.qphone.base.util.QLog;
import fr.f;

/* loaded from: classes32.dex */
public class EditTextPanel extends RelativeLayout implements d {
    public static String D = "EditTextPanel";
    private DynamicTextConfigManager.b C;

    /* renamed from: d, reason: collision with root package name */
    EditTextEffectView f68664d;

    /* renamed from: e, reason: collision with root package name */
    int f68665e;

    /* renamed from: f, reason: collision with root package name */
    int f68666f;

    /* renamed from: h, reason: collision with root package name */
    b f68667h;

    /* renamed from: i, reason: collision with root package name */
    EditText f68668i;

    /* renamed from: m, reason: collision with root package name */
    int f68669m;

    /* loaded from: classes32.dex */
    public interface b {
        void F(DynamicTextConfigManager.DynamicTextConfigBean dynamicTextConfigBean, int i3);
    }

    public EditTextPanel(Context context) {
        super(context);
        this.f68665e = -1;
        this.f68669m = 0;
        this.C = new DynamicTextConfigManager.b() { // from class: com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.panel.EditTextPanel.2
            @Override // com.tencent.aelight.camera.aioeditor.capture.text.DynamicTextConfigManager.b
            public void a(float f16, final String str, final int i3) {
                EditTextPanel.this.post(new Runnable() { // from class: com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.panel.EditTextPanel.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        LinearLayoutManager linearLayoutManager;
                        EditTextEffectView editTextEffectView = EditTextPanel.this.f68664d;
                        if (editTextEffectView == null || (linearLayoutManager = editTextEffectView.f68648e) == null) {
                            return;
                        }
                        int childCount = linearLayoutManager.getChildCount();
                        for (int i16 = 0; i16 < childCount; i16++) {
                            final EditTextEffectView.c cVar = (EditTextEffectView.c) EditTextPanel.this.f68664d.getChildViewHolder(EditTextPanel.this.f68664d.f68648e.getChildAt(i16));
                            if (cVar.f68659e.isContainsResUrl(str) && cVar.f68659e.text_id == i3) {
                                ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.panel.EditTextPanel.2.1.1
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        cVar.d(r0.f68659e.getProgress());
                                    }
                                });
                            }
                        }
                    }
                });
            }

            @Override // com.tencent.aelight.camera.aioeditor.capture.text.DynamicTextConfigManager.b
            public void v(final boolean z16, String str) {
                LinearLayoutManager linearLayoutManager;
                EditTextEffectView editTextEffectView = EditTextPanel.this.f68664d;
                if (editTextEffectView == null || (linearLayoutManager = editTextEffectView.f68648e) == null) {
                    return;
                }
                int childCount = linearLayoutManager.getChildCount();
                final DynamicTextConfigManager dynamicTextConfigManager = (DynamicTextConfigManager) f.c(7);
                for (int i3 = 0; i3 < childCount; i3++) {
                    final EditTextEffectView.c cVar = (EditTextEffectView.c) EditTextPanel.this.f68664d.getChildViewHolder(EditTextPanel.this.f68664d.f68648e.getChildAt(i3));
                    if (cVar.f68659e.isContainsResUrl(str)) {
                        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.panel.EditTextPanel.2.2
                            @Override // java.lang.Runnable
                            public void run() {
                                boolean z17 = z16;
                                if (!z17) {
                                    cVar.b(z17);
                                    ToastUtil.a().b(R.string.f1l);
                                } else if (dynamicTextConfigManager.q(cVar.f68659e)) {
                                    cVar.b(z16);
                                    int i16 = cVar.F;
                                    EditTextPanel editTextPanel = EditTextPanel.this;
                                    int i17 = editTextPanel.f68669m;
                                    if (i16 == i17) {
                                        editTextPanel.e(-1, i17);
                                    }
                                }
                            }
                        });
                    }
                }
            }
        };
    }

    private void g(DynamicTextConfigManager.DynamicTextConfigBean dynamicTextConfigBean, int i3) {
        b bVar = this.f68667h;
        if (bVar != null) {
            bVar.F(dynamicTextConfigBean, i3);
        }
    }

    public void b(EditText editText) {
        this.f68668i = editText;
    }

    public DynamicTextConfigManager.DynamicTextConfigBean c(int i3, int i16) {
        try {
            return this.f68664d.e(i16);
        } catch (Exception e16) {
            e16.printStackTrace();
            if (!QLog.isColorLevel()) {
                return null;
            }
            QLog.i(D, 2, "getSelectedItem" + i3 + " " + this.f68666f + "itemPosition=" + i16);
            return null;
        }
    }

    public int d(int i3) {
        final int d16 = this.f68664d.d(i3);
        if (d16 >= 0) {
            this.f68664d.h(d16);
            postDelayed(new Runnable() { // from class: com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.panel.EditTextPanel.1
                @Override // java.lang.Runnable
                public void run() {
                    EditTextPanel.this.f68664d.smoothScrollToPosition(d16);
                }
            }, 200L);
            this.f68666f = d16;
            this.f68665e = d16;
        }
        return d16;
    }

    public void f(int i3, int i16, boolean z16) {
        if (QLog.isColorLevel()) {
            QLog.d(D, 2, "selectItem position = " + i16);
        }
        DynamicTextConfigManager.DynamicTextConfigBean c16 = c(i3, i16);
        if (c16 != null) {
            g(c16, i16);
        } else if (QLog.isColorLevel()) {
            QLog.d(D, 2, "cancelChoose");
        }
        this.f68666f = i16;
        this.f68665e = i3;
        this.f68664d.h(i16);
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        return false;
    }

    public void setEditPhoto(boolean z16) {
        EditTextEffectView editTextEffectView = this.f68664d;
        if (editTextEffectView != null) {
            editTextEffectView.setEditPhoto(z16);
            this.f68664d.g();
        }
    }

    public void setOpIn(int i3) {
        EditTextEffectView editTextEffectView = this.f68664d;
        if (editTextEffectView != null) {
            editTextEffectView.setOpIn(i3);
        }
    }

    public void setPanelListener(b bVar) {
        this.f68667h = bVar;
    }

    @Override // com.tencent.mobileqq.flashchat.d
    public void t0(View view, int i3, int i16) {
        if (QLog.isColorLevel()) {
            QLog.d(D, 2, "onItemClick position = " + i3);
        }
        this.f68669m = i3;
        DynamicTextConfigManager.DynamicTextConfigBean c16 = c(i16, i3);
        if (c16 != null) {
            if (AppSetting.f99565y) {
                try {
                    c.a(view, DynamicTextBuilder.d(c16.text_id, 0));
                } catch (Exception e16) {
                    e16.printStackTrace();
                }
            }
            DynamicTextConfigManager dynamicTextConfigManager = (DynamicTextConfigManager) f.c(7);
            if (dynamicTextConfigManager.q(c16)) {
                e(i16, i3);
                return;
            } else if (NetConnInfoCenter.isMobileConn()) {
                FMDialogUtil.a(view.getContext(), R.string.f1n, R.string.f1m, new a(dynamicTextConfigManager, c16));
                return;
            } else {
                dynamicTextConfigManager.s(c16, this.C);
                return;
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d(D, 2, "onItemClick item null");
        }
    }

    public void e(int i3, int i16) {
        f(i3, i16, false);
    }

    public EditTextPanel(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f68665e = -1;
        this.f68669m = 0;
        this.C = new DynamicTextConfigManager.b() { // from class: com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.panel.EditTextPanel.2
            @Override // com.tencent.aelight.camera.aioeditor.capture.text.DynamicTextConfigManager.b
            public void a(float f16, final String str, final int i3) {
                EditTextPanel.this.post(new Runnable() { // from class: com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.panel.EditTextPanel.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        LinearLayoutManager linearLayoutManager;
                        EditTextEffectView editTextEffectView = EditTextPanel.this.f68664d;
                        if (editTextEffectView == null || (linearLayoutManager = editTextEffectView.f68648e) == null) {
                            return;
                        }
                        int childCount = linearLayoutManager.getChildCount();
                        for (int i16 = 0; i16 < childCount; i16++) {
                            final EditTextEffectView.c cVar = (EditTextEffectView.c) EditTextPanel.this.f68664d.getChildViewHolder(EditTextPanel.this.f68664d.f68648e.getChildAt(i16));
                            if (cVar.f68659e.isContainsResUrl(str) && cVar.f68659e.text_id == i3) {
                                ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.panel.EditTextPanel.2.1.1
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        cVar.d(r0.f68659e.getProgress());
                                    }
                                });
                            }
                        }
                    }
                });
            }

            @Override // com.tencent.aelight.camera.aioeditor.capture.text.DynamicTextConfigManager.b
            public void v(final boolean z16, String str) {
                LinearLayoutManager linearLayoutManager;
                EditTextEffectView editTextEffectView = EditTextPanel.this.f68664d;
                if (editTextEffectView == null || (linearLayoutManager = editTextEffectView.f68648e) == null) {
                    return;
                }
                int childCount = linearLayoutManager.getChildCount();
                final DynamicTextConfigManager dynamicTextConfigManager = (DynamicTextConfigManager) f.c(7);
                for (int i3 = 0; i3 < childCount; i3++) {
                    final EditTextEffectView.c cVar = (EditTextEffectView.c) EditTextPanel.this.f68664d.getChildViewHolder(EditTextPanel.this.f68664d.f68648e.getChildAt(i3));
                    if (cVar.f68659e.isContainsResUrl(str)) {
                        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.panel.EditTextPanel.2.2
                            @Override // java.lang.Runnable
                            public void run() {
                                boolean z17 = z16;
                                if (!z17) {
                                    cVar.b(z17);
                                    ToastUtil.a().b(R.string.f1l);
                                } else if (dynamicTextConfigManager.q(cVar.f68659e)) {
                                    cVar.b(z16);
                                    int i16 = cVar.F;
                                    EditTextPanel editTextPanel = EditTextPanel.this;
                                    int i17 = editTextPanel.f68669m;
                                    if (i16 == i17) {
                                        editTextPanel.e(-1, i17);
                                    }
                                }
                            }
                        });
                    }
                }
            }
        };
        EditTextEffectView editTextEffectView = new EditTextEffectView(context, this);
        this.f68664d = editTextEffectView;
        editTextEffectView.setClipToPadding(false);
        this.f68664d.setPadding(0, 0, EditTextEffectView.G, 0);
        addView(this.f68664d, new RelativeLayout.LayoutParams(-1, -1));
    }

    /* loaded from: classes32.dex */
    class a implements FMDialogUtil.c {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ DynamicTextConfigManager f68681a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ DynamicTextConfigManager.DynamicTextConfigBean f68682b;

        a(DynamicTextConfigManager dynamicTextConfigManager, DynamicTextConfigManager.DynamicTextConfigBean dynamicTextConfigBean) {
            this.f68681a = dynamicTextConfigManager;
            this.f68682b = dynamicTextConfigBean;
        }

        @Override // com.tencent.mobileqq.filemanager.util.FMDialogUtil.c
        public void b() {
            this.f68681a.s(this.f68682b, EditTextPanel.this.C);
        }

        @Override // com.tencent.mobileqq.filemanager.util.FMDialogUtil.c
        public void a() {
        }
    }

    @Override // com.tencent.mobileqq.flashchat.d
    public void zb(View view, int i3, int i16) {
    }
}
