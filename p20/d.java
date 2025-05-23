package p20;

import android.util.Size;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.qqcircle.comment.QFSCommentReportHelper;
import com.tencent.biz.qqcircle.comment.at.QFSCommentAtHelper;
import com.tencent.biz.qqcircle.comment.at.bean.QFSCommentAtEntity;
import com.tencent.biz.qqcircle.immersive.utils.n;
import com.tencent.biz.qqcircle.widgets.QCircleAvatarView;
import com.tencent.biz.richframework.delegate.impl.RFWApplication;
import com.tencent.biz.richframework.ioc.callback.OnPromiseResolved;
import com.tencent.biz.richframework.part.adapter.delegate.AbsListItemAdapterDelegate;
import com.tencent.mobileqq.R;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes4.dex */
public class d extends AbsListItemAdapterDelegate<o20.c, o20.c, c> {

    /* renamed from: d, reason: collision with root package name */
    private static final Size f424940d = n.a(RFWApplication.getApplication(), R.dimen.d0g);

    /* renamed from: e, reason: collision with root package name */
    private static final Size f424941e = n.a(RFWApplication.getApplication(), R.dimen.d0f);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ View f424942d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ o20.c f424943e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ RecyclerView.ViewHolder f424944f;

        /* compiled from: P */
        /* renamed from: p20.d$a$a, reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        class C10978a implements OnPromiseResolved<com.tencent.biz.qqcircle.comment.at.a> {
            C10978a() {
            }

            @Override // com.tencent.biz.richframework.ioc.callback.OnPromiseResolved
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onDone(com.tencent.biz.qqcircle.comment.at.a aVar) {
                aVar.d(a.this.f424943e);
            }
        }

        a(View view, o20.c cVar, RecyclerView.ViewHolder viewHolder) {
            this.f424942d = view;
            this.f424943e = cVar;
            this.f424944f = viewHolder;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            QFSCommentAtHelper.X(this.f424942d, new C10978a());
            d.this.c(this.f424944f, this.f424943e.e(), true);
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class b implements OnPromiseResolved<com.tencent.biz.qqcircle.comment.at.a> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ List f424947a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ boolean f424948b;

        b(List list, boolean z16) {
            this.f424947a = list;
            this.f424948b = z16;
        }

        @Override // com.tencent.biz.richframework.ioc.callback.OnPromiseResolved
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onDone(com.tencent.biz.qqcircle.comment.at.a aVar) {
            String str;
            Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
            buildElementParams.put("xsj_eid", QCircleDaTongConstant.ElementId.EM_XSJ_CMTPANEL_USER_LIST);
            buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_USER_ID, QFSCommentReportHelper.r(new ArrayList(this.f424947a)));
            buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_IF_QQ_GROUP, 1);
            buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_TYPE, aVar.getReportBean().d());
            buildElementParams.put("xsj_custom_pgid", aVar.getReportBean().a());
            if (this.f424948b) {
                str = "ev_xsj_abnormal_clck";
            } else {
                str = "ev_xsj_abnormal_imp";
            }
            VideoReport.reportEvent(str, buildElementParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public static class c extends RecyclerView.ViewHolder {
        QCircleAvatarView E;
        QCircleAvatarView F;
        TextView G;

        public c(@NonNull View view) {
            super(view);
            this.E = (QCircleAvatarView) view.findViewById(R.id.t0m);
            this.F = (QCircleAvatarView) view.findViewById(R.id.t0j);
            this.G = (TextView) view.findViewById(R.id.tv_name);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(@NonNull RecyclerView.ViewHolder viewHolder, List<QFSCommentAtEntity> list, boolean z16) {
        QFSCommentAtHelper.X(viewHolder.itemView, new b(list, z16));
    }

    private void d(@NonNull RecyclerView.ViewHolder viewHolder, o20.c cVar) {
        View view = viewHolder.itemView;
        view.setOnClickListener(new a(view, cVar, viewHolder));
    }

    private void h(QCircleAvatarView qCircleAvatarView, QFSCommentAtEntity qFSCommentAtEntity, Size size) {
        qCircleAvatarView.setAvatar(qFSCommentAtEntity.g(), qFSCommentAtEntity.e(), size);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.delegate.AbsListItemAdapterDelegate
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public boolean isForViewType(@NonNull o20.c cVar, @NonNull List<o20.c> list, int i3) {
        if (cVar.f() == o20.c.f421786g) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.delegate.AbsListItemAdapterDelegate
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder2(@NonNull o20.c cVar, @NonNull c cVar2, int i3, @NonNull List<Object> list) {
        List<QFSCommentAtEntity> e16 = cVar.e();
        int size = e16.size();
        if (size < 2) {
            return;
        }
        h(cVar2.E, e16.get(0), f424940d);
        h(cVar2.F, e16.get(1), f424941e);
        cVar2.G.setText(RFWApplication.getApplication().getString(R.string.f194504c3, Integer.valueOf(size)));
        d(cVar2, cVar);
        if (!QFSCommentAtHelper.L(String.valueOf(cVar.f()))) {
            c(cVar2, e16, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.delegate.AbsListItemAdapterDelegate, com.tencent.biz.richframework.part.adapter.delegate.AdapterDelegate
    @NonNull
    /* renamed from: g, reason: merged with bridge method [inline-methods] */
    public c onCreateViewHolder(@NonNull ViewGroup viewGroup) {
        return new c(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.g98, viewGroup, false));
    }
}
