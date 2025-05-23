package com.tencent.gdtad.views.videoceiling;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.gdtad.views.videoceiling.GdtVideoCeilingTitleBar;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

/* compiled from: P */
/* loaded from: classes6.dex */
public class GdtVideoCeilingTitleBar extends RelativeLayout {

    /* renamed from: d, reason: collision with root package name */
    private TextView f109707d;

    /* renamed from: e, reason: collision with root package name */
    private b f109708e;

    /* compiled from: P */
    /* loaded from: classes6.dex */
    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (GdtVideoCeilingTitleBar.this.f109708e != null) {
                GdtVideoCeilingTitleBar.this.f109708e.c(view);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes6.dex */
    public interface b {
        void c(View view);
    }

    public GdtVideoCeilingTitleBar(Context context) {
        super(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void d(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        b bVar = this.f109708e;
        if (bVar != null) {
            bVar.c(view);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    public void c() {
        this.f109707d = (TextView) findViewById(R.id.title);
        View findViewById = findViewById(R.id.f164559a43);
        View findViewById2 = findViewById(R.id.tzs);
        int f16 = BaseAIOUtils.f(5.0f, getResources());
        BaseAIOUtils.h(findViewById, f16, f16, 0, f16);
        findViewById.setOnClickListener(new a());
        if (findViewById2 != null) {
            findViewById2.setOnClickListener(new View.OnClickListener() { // from class: zm0.b
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    GdtVideoCeilingTitleBar.this.d(view);
                }
            });
        }
    }

    public void setOnBtnClickListener(b bVar) {
        this.f109708e = bVar;
    }

    public void setWebBarTitle(String str) {
        if (this.f109707d != null && !TextUtils.isEmpty(str)) {
            this.f109707d.setText(str);
        }
    }

    public GdtVideoCeilingTitleBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public GdtVideoCeilingTitleBar(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
    }
}
