package com.tencent.mobileqq.aio.panel.richtext;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.EditText;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.panel.EmoticonHotPicSearchPanelView;
import com.tencent.mobileqq.panel.RichTextPanelView;
import com.tencent.mobileqq.panel.f;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* loaded from: classes33.dex */
public class RichEmojiPanel extends RelativeLayout {

    /* renamed from: d, reason: collision with root package name */
    private com.tencent.aio.api.runtime.a f193155d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f193156e;

    /* renamed from: f, reason: collision with root package name */
    private RichTextPanelView f193157f;

    /* renamed from: h, reason: collision with root package name */
    private f f193158h;

    /* renamed from: i, reason: collision with root package name */
    private EditText f193159i;

    public RichEmojiPanel(Context context) {
        super(context);
    }

    private void g(com.tencent.qqnt.aio.api.e eVar) {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            QLog.e("RichEmojiPanel", 1, "setupPanelView Error: appRuntime is null");
            return;
        }
        this.f193157f = new EmoticonHotPicSearchPanelView(getContext(), this.f193155d, peekAppRuntime, this.f193159i, eVar, this.f193158h);
        addView(this.f193157f, new RelativeLayout.LayoutParams(-1, -1));
    }

    public void a(Context context, com.tencent.aio.api.runtime.a aVar, EditText editText, com.tencent.qqnt.aio.api.e eVar) {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            QLog.e("RichEmojiPanel", 1, "initPanel Error: appRuntime is null");
            return;
        }
        this.f193155d = aVar;
        this.f193159i = editText;
        f fVar = new f((QQAppInterface) peekAppRuntime, aVar, this);
        this.f193158h = fVar;
        fVar.o(false);
        g(eVar);
    }

    public void b() {
        RichTextPanelView richTextPanelView = this.f193157f;
        if (richTextPanelView != null) {
            richTextPanelView.b();
        }
    }

    public void d(boolean z16) {
        this.f193158h.m(z16);
        ((EmoticonHotPicSearchPanelView) this.f193157f).e(z16);
    }

    public void e(boolean z16) {
        if (QLog.isColorLevel()) {
            QLog.d("RichEmojiPanel", 2, "onPanelStatusChanged show = " + z16);
        }
        this.f193157f.c(z16);
        this.f193156e = z16;
    }

    public void f() {
        this.f193158h.n();
        ((EmoticonHotPicSearchPanelView) this.f193157f).f();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        f fVar;
        super.onDetachedFromWindow();
        if (this.f193156e && (fVar = this.f193158h) != null) {
            fVar.l();
        }
        this.f193156e = false;
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z16, int i3, int i16, int i17, int i18) {
        super.onLayout(z16, i3, i16, i17, i18);
    }

    public RichEmojiPanel(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public RichEmojiPanel(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
    }

    public void c() {
    }
}
