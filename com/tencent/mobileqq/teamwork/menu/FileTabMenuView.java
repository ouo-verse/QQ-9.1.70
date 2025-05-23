package com.tencent.mobileqq.teamwork.menu;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.teamwork.menu.MenuTabViewBase;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import java.util.List;
import mqq.util.WeakReference;

/* compiled from: P */
/* loaded from: classes18.dex */
public class FileTabMenuView extends MenuTabViewBase {

    /* renamed from: h, reason: collision with root package name */
    private ViewGroup f292163h;

    /* renamed from: i, reason: collision with root package name */
    private FilePanelMenuView f292164i;

    /* renamed from: m, reason: collision with root package name */
    private ActionSheet f292165m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class a implements MenuTabViewBase.a {
        a() {
        }

        @Override // com.tencent.mobileqq.teamwork.menu.MenuTabViewBase.a
        public boolean a(au auVar) {
            if (auVar.f292246a == 18) {
                FileTabMenuView.this.h();
                return true;
            }
            MenuTabViewBase.a aVar = FileTabMenuView.this.f292195f;
            if (aVar != null) {
                boolean a16 = aVar.a(auVar);
                if (auVar.f292246a == 2) {
                    FileTabMenuView.this.m(auVar.f292250e);
                }
                if (a16) {
                    FileTabMenuView.this.k();
                }
                return a16;
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class b implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        public WeakReference<FileTabMenuView> f292167d;

        /* renamed from: e, reason: collision with root package name */
        public au f292168e;

        public b(FileTabMenuView fileTabMenuView, au auVar) {
            this.f292167d = new WeakReference<>(fileTabMenuView);
            this.f292168e = auVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            FileTabMenuView fileTabMenuView = this.f292167d.get();
            if (fileTabMenuView != null) {
                au auVar = this.f292168e;
                if (auVar.f292246a == 5) {
                    fileTabMenuView.l();
                } else {
                    MenuTabViewBase.a aVar = fileTabMenuView.f292195f;
                    if (aVar != null) {
                        aVar.a(auVar);
                    }
                }
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    public FileTabMenuView(Context context) {
        this(context, null);
    }

    private View i(au auVar) {
        int i3;
        int i16;
        LinearLayout linearLayout = new LinearLayout(BaseApplication.getContext());
        linearLayout.setOrientation(1);
        linearLayout.setGravity(17);
        ImageView imageView = new ImageView(BaseApplication.getContext());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(j(24), j(24));
        if (auVar.f292250e) {
            i3 = auVar.f292249d;
        } else {
            i3 = auVar.f292248c;
        }
        imageView.setImageResource(i3);
        linearLayout.addView(imageView, layoutParams);
        TextView textView = new TextView(BaseApplication.getContext());
        textView.setText(auVar.f292247b);
        textView.setTextSize(14.0f);
        if (auVar.f292250e) {
            i16 = -15246101;
        } else {
            i16 = -1560281088;
        }
        textView.setTextColor(i16);
        textView.setGravity(17);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.setMargins(0, j(5), 0, 0);
        linearLayout.addView(textView, layoutParams2);
        return linearLayout;
    }

    private int j(int i3) {
        return (int) com.tencent.mobileqq.utils.al.a(getContext(), i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        ActionSheet actionSheet = this.f292165m;
        if (actionSheet != null && actionSheet.isShowing()) {
            this.f292165m.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l() {
        if (this.f292194e == null) {
            QQToast.makeText(getContext(), "\u83dc\u5355\u529f\u80fd\u672a\u914d\u7f6e", 0).show();
            return;
        }
        if (this.f292165m == null) {
            this.f292165m = (ActionSheet) ActionSheetHelper.createDialog(getContext(), null);
            FilePanelMenuView filePanelMenuView = new FilePanelMenuView(getContext());
            this.f292164i = filePanelMenuView;
            filePanelMenuView.setMenuClickListener(new a());
            this.f292165m.addView(this.f292164i);
        }
        this.f292164i.setConfigData(this.f292194e);
        this.f292164i.i();
        try {
            this.f292165m.show();
        } catch (Exception e16) {
            QLog.e("FileTabMenuView", 1, "showActionSheet fail.", e16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m(boolean z16) {
        List<au> list = this.f292193d;
        if (list == null) {
            return;
        }
        for (au auVar : list) {
            if (auVar.f292246a == 2 && auVar.f292250e != z16) {
                auVar.f292250e = z16;
                c();
            }
        }
    }

    @Override // com.tencent.mobileqq.teamwork.menu.MenuTabViewBase
    protected void a() {
        ((LayoutInflater) getContext().getSystemService("layout_inflater")).inflate(R.layout.f168651g72, this);
        this.f292163h = (ViewGroup) findViewById(R.id.f164633ta2);
        setVisibility(8);
    }

    @Override // com.tencent.mobileqq.teamwork.menu.MenuTabViewBase
    public void b() {
        FilePanelMenuView filePanelMenuView = this.f292164i;
        if (filePanelMenuView != null) {
            filePanelMenuView.setMenuClickListener(null);
        }
        this.f292195f = null;
    }

    @Override // com.tencent.mobileqq.teamwork.menu.MenuTabViewBase
    public void c() {
        int i3;
        List<au> list = this.f292193d;
        if (list != null && !list.isEmpty()) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        setVisibility(i3);
        this.f292163h.removeAllViews();
        for (au auVar : this.f292193d) {
            View i16 = i(auVar);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.weight = 1.0f;
            i16.setOnClickListener(new b(this, auVar));
            this.f292163h.addView(i16, layoutParams);
        }
    }

    public void h() {
        ActionSheet actionSheet = this.f292165m;
        if (actionSheet != null && actionSheet.isShowing()) {
            this.f292165m.dismiss();
        }
    }

    public FileTabMenuView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FileTabMenuView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
    }
}
