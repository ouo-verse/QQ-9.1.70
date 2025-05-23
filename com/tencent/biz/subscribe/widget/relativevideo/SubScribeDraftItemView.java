package com.tencent.biz.subscribe.widget.relativevideo;

import NS_CERTIFIED_ACCOUNT_READ.CertifiedAccountRead$StGetMainPageRsp;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.qqstory.storyHome.discover.RoundCornerImageView;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.subscribe.SubscribeUtils;
import com.tencent.biz.subscribe.baseUI.BaseWidgetView;
import com.tencent.biz.subscribe.beans.SubscribeDraftBean;
import com.tencent.biz.subscribe.event.SubDraftChangeEvent;
import com.tencent.biz.subscribe.fragments.SubscribeBaseBottomPersonalFragment;
import com.tencent.biz.subscribe.part.block.a;
import com.tencent.biz.subscribe.utils.SubscribeDraftManager;
import com.tencent.biz.subscribe.utils.j;
import com.tencent.biz.subscribe.widget.textview.AsyncRichTextView;
import com.tencent.biz.videostory.support.VSReporter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.filemanager.util.q;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.immersive.ImmersiveUtils;
import cooperation.qzone.QZoneHelper;

/* compiled from: P */
/* loaded from: classes5.dex */
public class SubScribeDraftItemView extends BaseWidgetView<SubscribeDraftBean> {
    private static String N = "SubScribeDraftItemView";
    private int E;
    private RoundCornerImageView F;
    private AsyncRichTextView G;
    private TextView H;
    private ImageView I;
    private ImageView J;
    private TextView K;
    private String L;
    private com.tencent.biz.subscribe.bizdapters.d M;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ SubscribeDraftBean f96543d;

        a(SubscribeDraftBean subscribeDraftBean) {
            this.f96543d = subscribeDraftBean;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (!hf0.a.a("subscribe_draft_click")) {
                boolean x16 = SubScribeDraftItemView.this.x();
                Intent intent = new Intent();
                intent.putExtra("postUin", SubScribeDraftItemView.this.y());
                intent.putExtra("has_shop", x16);
                intent.putExtra("subscribeDraftID", String.valueOf(this.f96543d.getDraftId()));
                QZoneHelper.forwardToQQPublicAccountPublishPage((Activity) SubScribeDraftItemView.this.getContext(), intent, 0);
                VSReporter.p(SubScribeDraftItemView.this.L, "auth_pubish", "clk_draftclk", 0, 0, new String[0]);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class b implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ SubscribeDraftBean f96545d;

        /* compiled from: P */
        /* loaded from: classes5.dex */
        class a implements j.f {
            a() {
            }

            @Override // com.tencent.biz.subscribe.utils.j.f
            public void a(boolean z16, String str, boolean z17) {
                if (z16) {
                    VSReporter.p(SubScribeDraftItemView.this.L, "auth_pubish", "delete_draft", 0, 0, new String[0]);
                    SubDraftChangeEvent subDraftChangeEvent = new SubDraftChangeEvent();
                    subDraftChangeEvent.setDraftID(String.valueOf(b.this.f96545d.getDraftId()));
                    SimpleEventBus.getInstance().dispatchEvent(subDraftChangeEvent);
                    QLog.d(SubScribeDraftItemView.N, 4, "delete draft success");
                    return;
                }
                QQToast.makeText(SubScribeDraftItemView.this.getContext(), "delete failed", 1).show();
            }
        }

        b(SubscribeDraftBean subscribeDraftBean) {
            this.f96545d = subscribeDraftBean;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            VSReporter.p(SubScribeDraftItemView.this.L, "auth_pubish", "clk_delete_draft", 0, 0, new String[0]);
            SubscribeDraftManager.f().m(SubScribeDraftItemView.this.getContext(), SubScribeDraftItemView.this.L, String.valueOf(this.f96545d.getDraftId()), R.string.vyh, new a());
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    public SubScribeDraftItemView(@NonNull Context context, com.tencent.biz.subscribe.bizdapters.d dVar) {
        super(context);
        this.E = ImmersiveUtils.getScreenWidth() / 2;
        this.M = dVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean x() {
        a.d M;
        SubscribeBaseBottomPersonalFragment.a aVar;
        CertifiedAccountRead$StGetMainPageRsp certifiedAccountRead$StGetMainPageRsp;
        com.tencent.biz.subscribe.bizdapters.d dVar = this.M;
        if (dVar == null || (M = dVar.M("share_key_subscribe_opus")) == null) {
            return false;
        }
        Object obj = M.f96169a;
        if (!(obj instanceof SubscribeBaseBottomPersonalFragment.a) || (certifiedAccountRead$StGetMainPageRsp = (aVar = (SubscribeBaseBottomPersonalFragment.a) obj).f96061h) == null || certifiedAccountRead$StGetMainPageRsp.user.youZhan.size() <= 0 || aVar.f96061h.user.youZhan.get(0).type.get() <= 1) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String y() {
        a.d M;
        com.tencent.biz.subscribe.bizdapters.d dVar = this.M;
        if (dVar != null && (M = dVar.M("share_key_subscribe_opus")) != null) {
            Object obj = M.f96169a;
            if (obj instanceof SubscribeBaseBottomPersonalFragment.a) {
                return ((SubscribeBaseBottomPersonalFragment.a) obj).f96062i;
            }
            return "";
        }
        return "";
    }

    @Override // com.tencent.biz.subscribe.baseUI.BaseWidgetView
    protected int i() {
        return R.layout.f167695ll;
    }

    @Override // com.tencent.biz.subscribe.baseUI.BaseWidgetView
    protected void p(Context context, View view) {
        this.F = (RoundCornerImageView) view.findViewById(R.id.a6y);
        this.G = (AsyncRichTextView) view.findViewById(R.id.f165018a71);
        this.I = (ImageView) view.findViewById(R.id.a6z);
        this.J = (ImageView) view.findViewById(R.id.f165017a70);
        this.L = ((PublicFragmentActivity) context).app.getCurrentUin();
        this.K = (TextView) view.findViewById(R.id.f165019a73);
        this.H = (TextView) view.findViewById(R.id.etb);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.subscribe.baseUI.BaseWidgetView
    /* renamed from: w, reason: merged with bridge method [inline-methods] */
    public void c(SubscribeDraftBean subscribeDraftBean) {
        float f16;
        if (subscribeDraftBean == null) {
            return;
        }
        String title = subscribeDraftBean.getTitle();
        if (TextUtils.isEmpty(title)) {
            title = subscribeDraftBean.getDescirbeSource();
        }
        if (TextUtils.isEmpty(title)) {
            this.G.setVisibility(8);
        } else {
            this.G.setVisibility(0);
            this.G.setText(title);
        }
        if (subscribeDraftBean.getWidth() >= subscribeDraftBean.getHeight()) {
            f16 = 0.75f;
        } else {
            f16 = 1.3333334f;
        }
        this.F.getLayoutParams().height = (int) (this.E * f16);
        this.F.getLayoutParams().width = this.E;
        this.F.requestLayout();
        if (!TextUtils.isEmpty(subscribeDraftBean.getCoverUrl()) && q.p(subscribeDraftBean.getCoverUrl())) {
            String coverUrl = subscribeDraftBean.getCoverUrl();
            RoundCornerImageView roundCornerImageView = this.F;
            com.tencent.biz.subscribe.a.d(coverUrl, roundCornerImageView, com.tencent.biz.subscribe.a.b(roundCornerImageView), true);
        } else {
            this.F.setImageResource(R.drawable.bgq);
        }
        this.H.setText(SubscribeUtils.i(subscribeDraftBean.getDraftId()));
        if (subscribeDraftBean.getDrafTtype() == SubscribeDraftBean.TYPE_VIDEO) {
            int duration = (int) ((subscribeDraftBean.getDuration() / 1000) / 60);
            int duration2 = (int) ((subscribeDraftBean.getDuration() / 1000) % 60);
            if (duration != 0 || duration2 != 0) {
                this.K.setText(String.format("%02d:%02d", Integer.valueOf(duration), Integer.valueOf(duration2)));
                this.K.setVisibility(0);
                this.J.setVisibility(0);
            }
        } else {
            this.K.setVisibility(8);
            this.J.setVisibility(8);
        }
        this.F.setOnClickListener(new a(subscribeDraftBean));
        this.I.setOnClickListener(new b(subscribeDraftBean));
    }
}
