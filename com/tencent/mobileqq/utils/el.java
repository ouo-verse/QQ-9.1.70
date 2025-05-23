package com.tencent.mobileqq.utils;

import android.content.Context;
import android.view.View;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;

/* compiled from: P */
/* loaded from: classes20.dex */
public class el implements View.OnClickListener {

    /* renamed from: d, reason: collision with root package name */
    protected final ActionSheet f307727d;

    /* renamed from: e, reason: collision with root package name */
    protected View f307728e;

    /* renamed from: f, reason: collision with root package name */
    protected Context f307729f;

    /* renamed from: h, reason: collision with root package name */
    protected a f307730h;

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public interface a {
        void a(int i3);
    }

    public el(Context context) {
        this.f307729f = context;
        this.f307727d = (ActionSheet) ActionSheetHelper.createDialog(context, null);
    }

    protected View a() {
        View inflate = View.inflate(this.f307729f, R.layout.amf, null);
        inflate.setBackgroundResource(R.drawable.qui_common_bg_middle_light_bg);
        View findViewById = inflate.findViewById(R.id.bby);
        View findViewById2 = inflate.findViewById(R.id.bbn);
        View findViewById3 = inflate.findViewById(R.id.bbm);
        findViewById.setOnClickListener(this);
        findViewById2.setOnClickListener(this);
        findViewById3.setOnClickListener(this);
        return inflate;
    }

    public void b() {
        if (isShowing()) {
            try {
                this.f307727d.dismiss();
                this.f307728e = null;
            } catch (RuntimeException e16) {
                QLog.w("TeamWorkCreateActionSheetBuilder", 2, "Exception while dismiss", e16);
            }
        }
    }

    public void c(a aVar) {
        this.f307730h = aVar;
    }

    public void d() {
        if (this.f307728e == null) {
            this.f307728e = a();
        }
        this.f307727d.setActionContentView(this.f307728e, null);
        try {
            if (!isShowing()) {
                this.f307727d.show();
            }
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.d("TeamWorkCreateActionSheetBuilder", 2, "actionSheet.show exception=" + e16);
            }
        }
    }

    public boolean isShowing() {
        return this.f307727d.isShowing();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        int id5 = view.getId();
        int i3 = 1;
        if (id5 != R.id.bby) {
            if (id5 == R.id.bbn) {
                i3 = 2;
            } else if (id5 == R.id.bbm) {
                i3 = 3;
            }
        }
        a aVar = this.f307730h;
        if (aVar != null) {
            aVar.a(i3);
        }
        EventCollector.getInstance().onViewClicked(view);
    }
}
