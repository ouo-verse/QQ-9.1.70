package cooperation.qqfav.globalsearch;

import android.graphics.Color;
import android.view.View;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.search.model.v;
import com.tencent.mobileqq.search.model.x;
import com.tencent.mobileqq.search.util.am;
import com.tencent.mobileqq.search.util.aq;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import qn2.d;
import sn2.g;

/* compiled from: P */
/* loaded from: classes28.dex */
public class a implements d<x, sn2.c>, qn2.b {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: cooperation.qqfav.globalsearch.a$a, reason: collision with other inner class name */
    /* loaded from: classes28.dex */
    public class ViewOnClickListenerC10112a implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ do2.d f390638d;

        ViewOnClickListenerC10112a(do2.d dVar) {
            this.f390638d = dVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            this.f390638d.q(view);
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    @Override // qn2.b
    public void b(v vVar, View view, int i3, int i16) {
        am.n(view, i3, com.tencent.mobileqq.search.util.x.d(vVar), com.tencent.mobileqq.search.util.x.h(vVar), String.valueOf(vVar.hashCode()), vVar.getRecallReason());
    }

    @Override // qn2.d
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public void a(x xVar, sn2.c cVar) {
        int size;
        String str;
        if ((xVar instanceof do2.d) && (cVar instanceof g)) {
            do2.d dVar = (do2.d) xVar;
            g gVar = (g) cVar;
            URLDrawable drawable = URLDrawable.getDrawable("https://pub.idqqimg.com/pc/misc/files/20170310/4c615c46286c40e78851635a63a22dae.png", URLDrawable.URLDrawableOptions.obtain());
            if (drawable != null && drawable.getStatus() == 2) {
                drawable.restartDownload();
            }
            gVar.f().setImageDrawable(drawable);
            gVar.b().setText(do2.d.D);
            if (dVar.o() == null) {
                size = 0;
            } else {
                size = dVar.o().size();
            }
            if (size <= 10) {
                str = String.valueOf(size);
            } else {
                str = "10+";
            }
            View view = gVar.getView();
            ((TextView) view.findViewById(R.id.bgn)).setText(String.format("%s\u6761\u4e0e\"", str));
            TextView textView = (TextView) view.findViewById(R.id.bgf);
            if (ThemeUtil.isInNightMode(BaseApplicationImpl.getApplication().getRuntime())) {
                textView.setTextColor(Color.parseColor("#004080"));
            }
            textView.setText(dVar.getKeyword());
            ((TextView) view.findViewById(R.id.bgo)).setText("\"\u76f8\u5173\u6536\u85cf");
            gVar.g().setVisibility(8);
            view.setOnClickListener(new ViewOnClickListenerC10112a(dVar));
            am.r(view, String.format("%s\u6761\u4e0e\"", str) + "\"\u76f8\u5173\u6536\u85cf", com.tencent.mobileqq.search.util.x.e(xVar), "", 0, xVar.e(), String.valueOf(xVar.hashCode()), xVar.getRecallReason());
            if (aq.a()) {
                textView.setTextColor(textView.getResources().getColor(R.color.qui_common_brand_standard));
            }
        }
    }
}
