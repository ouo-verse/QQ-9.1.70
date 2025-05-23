package p20;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.qqcircle.comment.at.QFSCommentAtHelper;
import com.tencent.biz.richframework.ioc.callback.OnPromiseResolved;
import com.tencent.biz.richframework.part.adapter.delegate.AbsListItemAdapterDelegate;
import com.tencent.mobileqq.R;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes4.dex */
public class b extends AbsListItemAdapterDelegate<o20.c, o20.c, RecyclerView.ViewHolder> {

    /* compiled from: P */
    /* loaded from: classes4.dex */
    class a extends RecyclerView.ViewHolder {
        a(View view) {
            super(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: p20.b$b, reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class ViewOnClickListenerC10975b implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ View f424922d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ o20.c f424923e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ RecyclerView.ViewHolder f424924f;

        /* compiled from: P */
        /* renamed from: p20.b$b$a */
        /* loaded from: classes4.dex */
        class a implements OnPromiseResolved<com.tencent.biz.qqcircle.comment.at.a> {
            a() {
            }

            @Override // com.tencent.biz.richframework.ioc.callback.OnPromiseResolved
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onDone(com.tencent.biz.qqcircle.comment.at.a aVar) {
                aVar.e(ViewOnClickListenerC10975b.this.f424923e);
            }
        }

        ViewOnClickListenerC10975b(View view, o20.c cVar, RecyclerView.ViewHolder viewHolder) {
            this.f424922d = view;
            this.f424923e = cVar;
            this.f424924f = viewHolder;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            QFSCommentAtHelper.X(this.f424922d, new a());
            b.this.c(this.f424924f, true);
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class c implements OnPromiseResolved<com.tencent.biz.qqcircle.comment.at.a> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ boolean f424927a;

        c(boolean z16) {
            this.f424927a = z16;
        }

        @Override // com.tencent.biz.richframework.ioc.callback.OnPromiseResolved
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onDone(com.tencent.biz.qqcircle.comment.at.a aVar) {
            String str;
            Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
            buildElementParams.put("xsj_eid", QCircleDaTongConstant.ElementId.EM_XSJ_CMTPANEL_USER_LIST);
            buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_USER_ID, QCircleDaTongConstant.ElementParamValue.XSJ_QQ_FRIENDS);
            buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_IF_QQ_GROUP, 0);
            buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_TYPE, aVar.getReportBean().d());
            buildElementParams.put("xsj_custom_pgid", aVar.getReportBean().a());
            if (this.f424927a) {
                str = "ev_xsj_abnormal_clck";
            } else {
                str = "ev_xsj_abnormal_imp";
            }
            VideoReport.reportEvent(str, buildElementParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(@NonNull RecyclerView.ViewHolder viewHolder, boolean z16) {
        QFSCommentAtHelper.X(viewHolder.itemView, new c(z16));
    }

    private void d(@NonNull RecyclerView.ViewHolder viewHolder, o20.c cVar) {
        View view = viewHolder.itemView;
        view.setOnClickListener(new ViewOnClickListenerC10975b(view, cVar, viewHolder));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.delegate.AbsListItemAdapterDelegate
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public boolean isForViewType(@NonNull o20.c cVar, @NonNull List<o20.c> list, int i3) {
        if (cVar.f() == o20.c.f421788i) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.delegate.AbsListItemAdapterDelegate
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder2(@NonNull o20.c cVar, @NonNull RecyclerView.ViewHolder viewHolder, int i3, @NonNull List<Object> list) {
        d(viewHolder, cVar);
        if (!QFSCommentAtHelper.L(String.valueOf(cVar.f()))) {
            c(viewHolder, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.delegate.AbsListItemAdapterDelegate, com.tencent.biz.richframework.part.adapter.delegate.AdapterDelegate
    @NonNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup) {
        return new a(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.g96, viewGroup, false));
    }
}
