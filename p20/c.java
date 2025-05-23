package p20;

import android.util.Size;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.qqcircle.comment.at.QFSCommentAtHelper;
import com.tencent.biz.qqcircle.comment.at.bean.QFSCommentAtEntity;
import com.tencent.biz.qqcircle.immersive.utils.n;
import com.tencent.biz.qqcircle.utils.QFSQUIUtilsKt;
import com.tencent.biz.qqcircle.utils.cx;
import com.tencent.biz.qqcircle.widgets.QCircleAvatarView;
import com.tencent.biz.richframework.delegate.impl.RFWApplication;
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
public class c extends AbsListItemAdapterDelegate<o20.c, o20.c, C10977c> {

    /* renamed from: d, reason: collision with root package name */
    private static final Size f424929d = n.a(RFWApplication.getApplication(), R.dimen.d0e);

    /* renamed from: e, reason: collision with root package name */
    private static final int f424930e = cx.a(0.5f);

    /* renamed from: f, reason: collision with root package name */
    private static final int f424931f = cx.a(1.0f);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ View f424932d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ o20.c f424933e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ RecyclerView.ViewHolder f424934f;

        /* compiled from: P */
        /* renamed from: p20.c$a$a, reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        class C10976a implements OnPromiseResolved<com.tencent.biz.qqcircle.comment.at.a> {
            C10976a() {
            }

            @Override // com.tencent.biz.richframework.ioc.callback.OnPromiseResolved
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onDone(com.tencent.biz.qqcircle.comment.at.a aVar) {
                aVar.c(a.this.f424933e);
            }
        }

        a(View view, o20.c cVar, RecyclerView.ViewHolder viewHolder) {
            this.f424932d = view;
            this.f424933e = cVar;
            this.f424934f = viewHolder;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            QFSCommentAtHelper.X(this.f424932d, new C10976a());
            c.this.c(this.f424934f, this.f424933e.a(), true);
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class b implements OnPromiseResolved<com.tencent.biz.qqcircle.comment.at.a> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ QFSCommentAtEntity f424937a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ boolean f424938b;

        b(QFSCommentAtEntity qFSCommentAtEntity, boolean z16) {
            this.f424937a = qFSCommentAtEntity;
            this.f424938b = z16;
        }

        @Override // com.tencent.biz.richframework.ioc.callback.OnPromiseResolved
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onDone(com.tencent.biz.qqcircle.comment.at.a aVar) {
            String str;
            Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
            buildElementParams.put("xsj_eid", QCircleDaTongConstant.ElementId.EM_XSJ_CMTPANEL_USER_LIST);
            buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_USER_ID, this.f424937a.e());
            buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_IF_QQ_GROUP, 0);
            buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_TYPE, aVar.getReportBean().d());
            buildElementParams.put("xsj_custom_pgid", aVar.getReportBean().a());
            if (this.f424938b) {
                str = "ev_xsj_abnormal_clck";
            } else {
                str = "ev_xsj_abnormal_imp";
            }
            VideoReport.reportEvent(str, buildElementParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: p20.c$c, reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C10977c extends RecyclerView.ViewHolder {
        QCircleAvatarView E;
        TextView F;
        ImageView G;

        public C10977c(@NonNull View view) {
            super(view);
            this.E = (QCircleAvatarView) view.findViewById(R.id.a2o);
            this.F = (TextView) view.findViewById(R.id.tv_name);
            this.G = (ImageView) view.findViewById(R.id.y8w);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(@NonNull RecyclerView.ViewHolder viewHolder, QFSCommentAtEntity qFSCommentAtEntity, boolean z16) {
        QFSCommentAtHelper.X(viewHolder.itemView, new b(qFSCommentAtEntity, z16));
    }

    private void d(@NonNull RecyclerView.ViewHolder viewHolder, o20.c cVar) {
        View view = viewHolder.itemView;
        view.setOnClickListener(new a(view, cVar, viewHolder));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.delegate.AbsListItemAdapterDelegate
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public boolean isForViewType(@NonNull o20.c cVar, @NonNull List<o20.c> list, int i3) {
        if (cVar.f() == o20.c.f421787h) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.delegate.AbsListItemAdapterDelegate
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder2(@NonNull o20.c cVar, @NonNull C10977c c10977c, int i3, @NonNull List<Object> list) {
        QFSCommentAtEntity a16 = cVar.a();
        QCircleAvatarView qCircleAvatarView = c10977c.E;
        qCircleAvatarView.setAvatar(a16.g(), a16.e(), f424929d);
        qCircleAvatarView.setIsAuth(a16.a());
        int i16 = 8;
        if (cVar.b()) {
            c10977c.G.setVisibility(0);
            qCircleAvatarView.setStrokes(f424931f, QFSQUIUtilsKt.d(qCircleAvatarView.getContext(), R.color.qui_button_bg_primary_default), 0, 0);
        } else {
            c10977c.G.setVisibility(8);
            qCircleAvatarView.setStrokes(f424930e, QFSQUIUtilsKt.d(qCircleAvatarView.getContext(), R.color.qui_common_border_light), 0, 0);
        }
        c10977c.F.setText(a16.b());
        ImageView imageView = c10977c.G;
        if (cVar.b()) {
            i16 = 0;
        }
        imageView.setVisibility(i16);
        d(c10977c, cVar);
        if (!QFSCommentAtHelper.L(cVar.a().uin)) {
            c(c10977c, a16, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.delegate.AbsListItemAdapterDelegate, com.tencent.biz.richframework.part.adapter.delegate.AdapterDelegate
    @NonNull
    /* renamed from: g, reason: merged with bridge method [inline-methods] */
    public C10977c onCreateViewHolder(@NonNull ViewGroup viewGroup) {
        return new C10977c(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.g97, viewGroup, false));
    }
}
