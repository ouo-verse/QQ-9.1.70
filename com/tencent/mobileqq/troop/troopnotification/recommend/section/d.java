package com.tencent.mobileqq.troop.troopnotification.recommend.section;

import NS_COMM.COMM;
import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.app.AppInterface;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.addfriend.strategy.IAddAcceptBlockStrategy;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.troop.adapter.RecommendTroopAdapter;
import com.tencent.mobileqq.troop.api.ITroopUtilApi;
import com.tencent.mobileqq.troop.recommend.data.RecommendTroopItem;
import com.tencent.mobileqq.troop.troopnotification.recommend.s;
import com.tencent.mobileqq.troop.utils.ad;
import com.tencent.mobileqq.troop.utils.bg;
import com.tencent.mobileqq.troop.utils.h;
import com.tencent.mobileqq.troop.widget.TroopActiveLayout;
import com.tencent.mobileqq.troop.widget.TroopLabelLayout;
import com.tencent.mobileqq.widget.FolderTextView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.SingleLineTextView;
import com.tencent.widget.ThemeImageView;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 !2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\"B\u0007\u00a2\u0006\u0004\b\u001f\u0010 J$\u0010\n\u001a\u00020\t2\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0002J\u0018\u0010\u000e\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\fH\u0002J\b\u0010\u0010\u001a\u00020\u000fH\u0002J\u0012\u0010\u0012\u001a\u00020\t2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0003H\u0014J*\u0010\u0016\u001a\u00020\t2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0013\u001a\u00020\u000f2\u000e\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0014H\u0014R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0014\u0010\u001c\u001a\u00020\u00198\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0014\u0010\u001e\u001a\u00020\u00198\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001b\u00a8\u0006#"}, d2 = {"Lcom/tencent/mobileqq/troop/troopnotification/recommend/section/d;", "Lcom/tencent/mobileqq/troop/troopnotification/recommend/s;", "", "Landroid/view/View;", "convertView", "Lcom/tencent/mobileqq/troop/recommend/data/RecommendTroopItem;", "data", "Lcom/tencent/mobileqq/troop/adapter/RecommendTroopAdapter$e;", "viewHolder", "", HippyTKDListViewAdapter.X, "troopItem", "Landroid/content/Context;", "context", "v", "", ReportConstant.COSTREPORT_PREFIX, "containerView", "onInitView", "position", "", "payload", "onBindData", "d", "Lcom/tencent/mobileqq/troop/adapter/RecommendTroopAdapter$e;", "Landroid/view/View$OnClickListener;", "e", "Landroid/view/View$OnClickListener;", "itemListener", "f", "joinListener", "<init>", "()V", h.F, "a", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class d extends s<Object> {
    static IPatchRedirector $redirector_;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private RecommendTroopAdapter.e viewHolder;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final View.OnClickListener itemListener;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final View.OnClickListener joinListener;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0007\u0010\bR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0004\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/troop/troopnotification/recommend/section/d$a;", "", "", "DT_EM_ID_GROUP_JOIN", "Ljava/lang/String;", "DT_EM_ID_RCMD_RESULT", "DT_PARAM_KEY_GROUP_ID", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.troop.troopnotification.recommend.section.d$a, reason: from kotlin metadata */
    /* loaded from: classes19.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(59184);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.itemListener = new View.OnClickListener() { // from class: com.tencent.mobileqq.troop.troopnotification.recommend.section.a
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    d.t(d.this, view);
                }
            };
            this.joinListener = new View.OnClickListener() { // from class: com.tencent.mobileqq.troop.troopnotification.recommend.section.b
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    d.u(d.this, view);
                }
            };
        }
    }

    private final int s() {
        return COMM.qq_story_config;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void t(d this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Object tag = view.getTag(-1);
        Intrinsics.checkNotNull(tag, "null cannot be cast to non-null type com.tencent.mobileqq.troop.recommend.data.RecommendTroopItem");
        ((ITroopUtilApi) QRoute.api(ITroopUtilApi.class)).openRecommendTroop(view.getContext(), (RecommendTroopItem) tag, 0, this$0.s());
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u(d this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Object tag = view.getTag(-1);
        Intrinsics.checkNotNull(tag, "null cannot be cast to non-null type com.tencent.mobileqq.troop.recommend.data.RecommendTroopItem");
        Context context = view.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "v.context");
        this$0.v((RecommendTroopItem) tag, context);
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void v(final RecommendTroopItem troopItem, final Context context) {
        ((IAddAcceptBlockStrategy) QRoute.api(IAddAcceptBlockStrategy.class)).checkAccountIdentity(bg.f(), 10003, context, new IAddAcceptBlockStrategy.a() { // from class: com.tencent.mobileqq.troop.troopnotification.recommend.section.c
            @Override // com.tencent.mobileqq.addfriend.strategy.IAddAcceptBlockStrategy.a
            public final void onSuccess() {
                d.w(context, troopItem, this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void w(Context context, RecommendTroopItem troopItem, d this$0) {
        Intrinsics.checkNotNullParameter(context, "$context");
        Intrinsics.checkNotNullParameter(troopItem, "$troopItem");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ((ITroopUtilApi) QRoute.api(ITroopUtilApi.class)).joinRecommendTroop(context, troopItem, this$0.s());
    }

    private final void x(View convertView, RecommendTroopItem data, RecommendTroopAdapter.e viewHolder) {
        if (convertView != null && viewHolder != null) {
            HashMap hashMap = new HashMap();
            String str = data.uin;
            Intrinsics.checkNotNullExpressionValue(str, "data.uin");
            hashMap.put("group_id", str);
            ad adVar = ad.f302002a;
            h.a.b(adVar, convertView, "em_group_recom_result", hashMap, null, null, null, 56, null);
            Button button = viewHolder.f293771d;
            Intrinsics.checkNotNullExpressionValue(button, "viewHolder.btnJoin");
            h.a.b(adVar, button, "em_group_join", hashMap, null, null, null, 56, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public void onBindData(@Nullable Object data, int position, @Nullable List<Object> payload) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, data, Integer.valueOf(position), payload);
            return;
        }
        if (!(data instanceof RecommendTroopItem)) {
            return;
        }
        AppInterface e16 = bg.e();
        RecommendTroopItem recommendTroopItem = (RecommendTroopItem) data;
        FaceDrawable faceDrawable = FaceDrawable.getFaceDrawable(e16, 4, recommendTroopItem.uin);
        Intrinsics.checkNotNullExpressionValue(faceDrawable, "getFaceDrawable(app, Fac\u2026EAD_TYPE_GROUP, data.uin)");
        RecommendTroopAdapter.d(this.viewHolder, recommendTroopItem, faceDrawable, e16);
        x(getRootView(), recommendTroopItem, this.viewHolder);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public void onInitView(@Nullable View containerView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) containerView);
            return;
        }
        if (containerView == null) {
            return;
        }
        if (this.viewHolder == null) {
            this.viewHolder = new RecommendTroopAdapter.e();
        }
        RecommendTroopAdapter.e eVar = this.viewHolder;
        if (eVar != null) {
            eVar.f293768a = containerView;
            ImageView imageView = (ImageView) containerView.findViewById(R.id.lol);
            eVar.f293769b = imageView;
            if (imageView instanceof ThemeImageView) {
                Intrinsics.checkNotNull(imageView, "null cannot be cast to non-null type com.tencent.widget.ThemeImageView");
                ((ThemeImageView) imageView).setSupportMaskView(false);
            }
            eVar.f293770c = (SingleLineTextView) containerView.findViewById(R.id.meg);
            eVar.f293771d = (Button) containerView.findViewById(R.id.lax);
            eVar.f293772e = (TroopActiveLayout) containerView.findViewById(R.id.l_v);
            eVar.f293773f = (TroopLabelLayout) containerView.findViewById(R.id.l_w);
            eVar.f293774g = (FolderTextView) containerView.findViewById(R.id.f167042k73);
            eVar.f293775h = (TextView) containerView.findViewById(R.id.mc9);
            eVar.f293776i = (TextView) containerView.findViewById(R.id.vjb);
            eVar.f293771d.setOnClickListener(this.joinListener);
            eVar.f293771d.setPadding(0, 0, 0, 0);
            containerView.setOnClickListener(this.itemListener);
            containerView.setTag(this.viewHolder);
            eVar.f293775h.setOnClickListener(null);
            eVar.f293775h.setVisibility(8);
            containerView.setTag(-3, null);
        }
    }
}
