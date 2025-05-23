package com.tencent.mobileqq.filemanager.data.search.troop;

import android.text.TextUtils;
import android.view.View;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.widget.AsyncImageView;
import com.tencent.mobileqq.search.model.y;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import qn2.d;

/* compiled from: P */
/* loaded from: classes12.dex */
public class b implements d<y, sn2.c> {

    /* renamed from: d, reason: collision with root package name */
    public boolean f207960d = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class a implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ y f207961d;

        a(y yVar) {
            this.f207961d = yVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            this.f207961d.v(view);
            if (b.this.f207960d) {
                com.tencent.imcore.message.report.a.h(null, 5, 2);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    @Override // qn2.d
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public void a(y yVar, sn2.c cVar) {
        if (cVar.b() != null && !TextUtils.isEmpty(yVar.getTitleSpans())) {
            cVar.b().setVisibility(0);
            cVar.b().setText(yVar.getTitleSpans());
        }
        if (cVar.c() != null && !TextUtils.isEmpty(yVar.getSubTitleSpans())) {
            cVar.c().setVisibility(0);
            cVar.c().setText(yVar.getSubTitleSpans());
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
        AsyncImageView asyncImageView = (AsyncImageView) cVar.f();
        com.tencent.mobileqq.filemanager.data.search.troop.a aVar = (com.tencent.mobileqq.filemanager.data.search.troop.a) yVar;
        String y16 = aVar.y();
        String x16 = aVar.x();
        if (FileUtils.fileExistsAndNotEmpty(y16)) {
            FileManagerUtil.setFileIcon(asyncImageView, y16, FileManagerUtil.getFileType(x16));
        } else {
            asyncImageView.setDefaultImage(FileManagerUtil.getFileIconResId(x16));
        }
        View view = cVar.getView();
        if (view != null) {
            view.setOnClickListener(new a(yVar));
        }
    }
}
