package p20;

import android.text.TextUtils;
import android.util.Size;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.qqcircle.comment.at.QFSCommentAtHelper;
import com.tencent.biz.qqcircle.comment.at.bean.QFSCommentAtEntity;
import com.tencent.biz.qqcircle.immersive.utils.n;
import com.tencent.biz.qqcircle.utils.h;
import com.tencent.biz.qqcircle.widgets.QCircleAvatarView;
import com.tencent.biz.richframework.delegate.impl.RFWApplication;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.ioc.RFWIocAbilityProvider;
import com.tencent.biz.richframework.ioc.callback.OnPromiseRejected;
import com.tencent.biz.richframework.ioc.callback.OnPromiseResolved;
import com.tencent.biz.richframework.part.adapter.delegate.AbsListItemAdapterDelegate;
import com.tencent.mobileqq.R;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

/* compiled from: P */
/* loaded from: classes4.dex */
public class e extends AbsListItemAdapterDelegate<o20.b, o20.b, b> {

    /* renamed from: e, reason: collision with root package name */
    private static final Size f424950e = n.a(RFWApplication.getApplication(), R.dimen.d0c);

    /* renamed from: d, reason: collision with root package name */
    private int f424951d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ View f424952d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ o20.b f424953e;

        /* compiled from: P */
        /* renamed from: p20.e$a$a, reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        class C10979a implements OnPromiseRejected {
            C10979a() {
            }

            @Override // com.tencent.biz.richframework.ioc.callback.OnPromiseRejected
            public void onFail(String str) {
                RFWLog.e("SearchUserItemAdapterDelegate", RFWLog.USR, new RuntimeException("ICommentAtIoc  error = " + str));
            }
        }

        /* compiled from: P */
        /* loaded from: classes4.dex */
        class b implements OnPromiseResolved<com.tencent.biz.qqcircle.comment.at.dialog.a> {
            b() {
            }

            @Override // com.tencent.biz.richframework.ioc.callback.OnPromiseResolved
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onDone(com.tencent.biz.qqcircle.comment.at.dialog.a aVar) {
                aVar.Z7(a.this.f424953e);
            }
        }

        a(View view, o20.b bVar) {
            this.f424952d = view;
            this.f424953e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            RFWIocAbilityProvider.g().getIoc(com.tencent.biz.qqcircle.comment.at.dialog.a.class).originView(this.f424952d).done(new b()).fail(new C10979a()).run();
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public static class b extends RecyclerView.ViewHolder {
        QCircleAvatarView E;
        TextView F;
        TextView G;

        public b(@NonNull View view) {
            super(view);
            this.E = (QCircleAvatarView) view.findViewById(R.id.a2o);
            this.F = (TextView) view.findViewById(R.id.tv_name);
            this.G = (TextView) view.findViewById(R.id.k8i);
        }
    }

    public e(int i3) {
        this.f424951d = i3;
    }

    private void b(b bVar, o20.b bVar2) {
        View view = bVar.itemView;
        view.setOnClickListener(new a(view, bVar2));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.delegate.AbsListItemAdapterDelegate
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public boolean isForViewType(@NonNull o20.b bVar, @NonNull List<o20.b> list, int i3) {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.delegate.AbsListItemAdapterDelegate
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder2(@NonNull o20.b bVar, @NonNull b bVar2, int i3, @NonNull List<Object> list) {
        QFSCommentAtEntity a16 = bVar.a();
        QCircleAvatarView qCircleAvatarView = bVar2.E;
        String e16 = a16.e();
        if (this.f424951d == 1) {
            QFSCommentAtHelper.t0(e16, a16.f(), qCircleAvatarView);
        } else {
            qCircleAvatarView.setAvatar(a16.g(), e16, f424950e);
        }
        qCircleAvatarView.setIsAuth(a16.a());
        bVar2.F.setText(a16.b());
        if (bVar.b()) {
            bVar2.G.setText(h.a(R.string.f1909143d));
        } else if (!TextUtils.isEmpty(bVar.f())) {
            bVar2.G.setText(bVar.f());
        } else {
            bVar2.G.setText(bVar.e().group_name);
        }
        b(bVar2, bVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.delegate.AbsListItemAdapterDelegate, com.tencent.biz.richframework.part.adapter.delegate.AdapterDelegate
    @NonNull
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public b onCreateViewHolder(@NonNull ViewGroup viewGroup) {
        return new b(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.f168664g94, viewGroup, false));
    }
}
