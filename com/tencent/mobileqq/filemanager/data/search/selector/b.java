package com.tencent.mobileqq.filemanager.data.search.selector;

import android.text.TextUtils;
import android.view.View;
import android.widget.CheckBox;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.widget.AsyncImageView;
import com.tencent.mobileqq.search.model.y;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

/* compiled from: P */
/* loaded from: classes12.dex */
public class b implements qn2.d<y, sn2.c> {

    /* renamed from: d, reason: collision with root package name */
    private e f207932d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class a implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ y f207933d;

        a(y yVar) {
            this.f207933d = yVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            ((com.tencent.mobileqq.filemanager.data.search.selector.a) this.f207933d).v(view);
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.filemanager.data.search.selector.b$b, reason: collision with other inner class name */
    /* loaded from: classes12.dex */
    public class ViewOnClickListenerC7555b implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ y f207935d;

        ViewOnClickListenerC7555b(y yVar) {
            this.f207935d = yVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            com.tencent.mobileqq.filemanager.data.search.selector.a aVar = (com.tencent.mobileqq.filemanager.data.search.selector.a) this.f207935d;
            aVar.v(view);
            CheckBox checkBox = (CheckBox) view.findViewById(R.id.c_i);
            if (checkBox.getVisibility() == 0) {
                checkBox.setChecked(aVar.G());
            }
            if (b.this.f207932d != null) {
                b.this.f207932d.a();
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    @Override // qn2.d
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public void a(y yVar, sn2.c cVar) {
        if (cVar.b() != null && !TextUtils.isEmpty(yVar.getTitle())) {
            cVar.b().setVisibility(0);
            cVar.b().setText(yVar.getTitle());
        }
        if (cVar.c() != null && !TextUtils.isEmpty(yVar.getSubTitle())) {
            cVar.c().setVisibility(0);
            cVar.c().setText(yVar.getSubTitle());
        }
        if (cVar.k() != null && !TextUtils.isEmpty(yVar.getDescription())) {
            cVar.k().setVisibility(0);
            cVar.k().setText(yVar.getDescription());
        }
        if (yVar.o() == null && cVar.d() != null) {
            cVar.d().setVisibility(8);
        }
        if (cVar.d() != null && yVar.o() != null) {
            cVar.d().setVisibility(0);
            cVar.d().setText(yVar.o());
        }
        com.tencent.mobileqq.filemanager.data.search.selector.a aVar = (com.tencent.mobileqq.filemanager.data.search.selector.a) yVar;
        View view = cVar.getView();
        AsyncImageView asyncImageView = (AsyncImageView) cVar.f();
        String J = aVar.J();
        int K = aVar.K();
        if (!TextUtils.isEmpty(J)) {
            FileManagerUtil.setFileIcon(asyncImageView, J, K);
        } else {
            asyncImageView.setDefaultImage(FileManagerUtil.getFileIconResId(K));
        }
        asyncImageView.setContentDescription(aVar.I() + " " + ((Object) yVar.getDescription()));
        asyncImageView.setOnClickListener(new a(yVar));
        CheckBox checkBox = (CheckBox) view.findViewById(R.id.c_i);
        if (aVar.L() > 1) {
            checkBox.setVisibility(8);
        } else {
            checkBox.setVisibility(0);
        }
        checkBox.setChecked(aVar.G());
        view.setOnClickListener(new ViewOnClickListenerC7555b(yVar));
    }

    public void e(e eVar) {
        this.f207932d = eVar;
    }
}
