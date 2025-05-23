package k61;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.res.ResourcesCompat;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.qui.quipolarlight.a;
import com.tencent.biz.qui.quipolarlight.render.PolarImageRender;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.data.IntimateInfo;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.intimate.QUIRoundCornerPolarLightView;
import com.tencent.mobileqq.mutualmark.oldlogic.FriendIntimateRelationshipHelper;
import com.tencent.mobileqq.proavatar.QQProAvatarView;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import j61.IntimateBaseModel;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 92\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0001:B\u0007\u00a2\u0006\u0004\b7\u00108J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0012\u0010\t\u001a\u00020\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u0004H\u0014J*\u0010\u0011\u001a\u00020\u00062\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\r\u001a\u00020\f2\u000e\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000eH\u0015J\b\u0010\u0012\u001a\u00020\u0006H\u0016J\b\u0010\u0013\u001a\u00020\u0006H\u0016J\u0012\u0010\u0015\u001a\u00020\u00062\b\u0010\u0014\u001a\u0004\u0018\u00010\u0003H\u0016J$\u0010\u0019\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00170\u0016j\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0017`\u0018H\u0016J\b\u0010\u001a\u001a\u00020\u0006H\u0016R\u0016\u0010\u001e\u001a\u00020\u001b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0016\u0010\"\u001a\u00020\u001f8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b \u0010!R\u0016\u0010$\u001a\u00020\u001f8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b#\u0010!R\u0016\u0010'\u001a\u00020\u00048\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u0018\u0010*\u001a\u0004\u0018\u00010(8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010)R\u0016\u0010.\u001a\u00020+8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b,\u0010-R\u0016\u00100\u001a\u00020+8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b/\u0010-R\u0016\u00104\u001a\u0002018\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b2\u00103R\u0016\u00106\u001a\u00020\u001f8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b5\u0010!\u00a8\u0006;"}, d2 = {"Lk61/w;", "Lk61/d;", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "Landroid/view/View;", "it", "", "r", "containerView", "onInitView", "Lj61/a;", "data", "", "position", "", "", "payload", ReportConstant.COSTREPORT_PREFIX, "k", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "event", "onReceiveEvent", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "Lkotlin/collections/ArrayList;", "getEventClass", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "", "e", "Ljava/lang/String;", "mFriendUin", "Landroid/widget/TextView;", "f", "Landroid/widget/TextView;", "mBecomeFriendDays", tl.h.F, "mScores", "i", "Landroid/view/View;", "mScoresLayout", "Lcom/tencent/mobileqq/intimate/QUIRoundCornerPolarLightView;", "Lcom/tencent/mobileqq/intimate/QUIRoundCornerPolarLightView;", "mPolarLightView", "Lcom/tencent/mobileqq/proavatar/QQProAvatarView;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/proavatar/QQProAvatarView;", "mSelfAvatarView", "D", "mFriendAvatarView", "Landroid/widget/ImageView;", "E", "Landroid/widget/ImageView;", "mElectricWaveView", UserInfo.SEX_FEMALE, "mBindText", "<init>", "()V", "G", "a", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class w extends d implements SimpleEventReceiver<SimpleBaseEvent> {

    /* renamed from: C, reason: from kotlin metadata */
    private QQProAvatarView mSelfAvatarView;

    /* renamed from: D, reason: from kotlin metadata */
    private QQProAvatarView mFriendAvatarView;

    /* renamed from: E, reason: from kotlin metadata */
    private ImageView mElectricWaveView;

    /* renamed from: F, reason: from kotlin metadata */
    private TextView mBindText;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String mFriendUin = "";

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private TextView mBecomeFriendDays;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private TextView mScores;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private View mScoresLayout;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private QUIRoundCornerPolarLightView mPolarLightView;

    private final void r(View it) {
        String b16 = FriendIntimateRelationshipHelper.b(this.mFriendUin);
        Context context = it.getContext();
        if (!TextUtils.isEmpty(b16)) {
            context.startActivity(new Intent(context, (Class<?>) QQBrowserActivity.class).putExtra("url", b16));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void t(w this$0, View it) {
        EventCollector.getInstance().onViewClickedBefore(it);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(it, "it");
        this$0.r(it);
        EventCollector.getInstance().onViewClicked(it);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u(w this$0, View it) {
        EventCollector.getInstance().onViewClickedBefore(it);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(it, "it");
        this$0.r(it);
        EventCollector.getInstance().onViewClicked(it);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    @NotNull
    public ArrayList<Class<SimpleBaseEvent>> getEventClass() {
        return new ArrayList<>();
    }

    @Override // k61.d, h61.a
    public void k() {
        super.k();
        QUIRoundCornerPolarLightView qUIRoundCornerPolarLightView = this.mPolarLightView;
        if (qUIRoundCornerPolarLightView != null) {
            qUIRoundCornerPolarLightView.m();
        }
    }

    @Override // k61.d, h61.a
    public void m() {
        super.m();
        QUIRoundCornerPolarLightView qUIRoundCornerPolarLightView = this.mPolarLightView;
        if (qUIRoundCornerPolarLightView != null) {
            qUIRoundCornerPolarLightView.stopAnimation();
        }
    }

    @Override // k61.d, com.tencent.biz.richframework.part.adapter.section.Section, com.tencent.biz.richframework.part.adapter.VisibleAware
    public void onDestroy() {
        super.onDestroy();
        QUIRoundCornerPolarLightView qUIRoundCornerPolarLightView = this.mPolarLightView;
        if (qUIRoundCornerPolarLightView != null) {
            qUIRoundCornerPolarLightView.stopAnimation();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public void onInitView(@Nullable View containerView) {
        String str;
        List<Integer> listOf;
        if (containerView == null) {
            return;
        }
        View findViewById = containerView.findViewById(R.id.xqz);
        Intrinsics.checkNotNullExpressionValue(findViewById, "containerView.findViewBy\u2026imate_unbind_become_days)");
        this.mBecomeFriendDays = (TextView) findViewById;
        View findViewById2 = containerView.findViewById(R.id.xr_);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "containerView.findViewBy\u2026ate_unbind_scores_layout)");
        this.mScoresLayout = findViewById2;
        View findViewById3 = containerView.findViewById(R.id.xr9);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "containerView.findViewBy\u2026d.intimate_unbind_scores)");
        this.mScores = (TextView) findViewById3;
        QUIRoundCornerPolarLightView qUIRoundCornerPolarLightView = (QUIRoundCornerPolarLightView) containerView.findViewById(R.id.xr8);
        this.mPolarLightView = qUIRoundCornerPolarLightView;
        if (qUIRoundCornerPolarLightView != null) {
            qUIRoundCornerPolarLightView.setRadius(ViewUtils.dpToPx(16.0f));
            PolarImageRender l3 = qUIRoundCornerPolarLightView.l();
            listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new Integer[]{Integer.valueOf(Color.parseColor("#FFF7E4")), Integer.valueOf(Color.parseColor("#FFE7E3")), Integer.valueOf(Color.parseColor("#FFDCFF")), Integer.valueOf(Color.parseColor("#E0E8FF")), Integer.valueOf(Color.parseColor("#F0F4FF")), Integer.valueOf(Color.parseColor("#F3FFF6"))});
            l3.s(listOf);
            qUIRoundCornerPolarLightView.l().r(0.5f);
            qUIRoundCornerPolarLightView.l().p(0.025f);
            qUIRoundCornerPolarLightView.l().q(new a.b(0.0f, 0.0f, 0.0f, 0.9f, 0.0f));
            qUIRoundCornerPolarLightView.m();
        }
        View findViewById4 = containerView.findViewById(R.id.xra);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "containerView.findViewBy\u2026mate_unbind_self_head_iv)");
        QQProAvatarView qQProAvatarView = (QQProAvatarView) findViewById4;
        this.mSelfAvatarView = qQProAvatarView;
        TextView textView = null;
        if (qQProAvatarView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSelfAvatarView");
            qQProAvatarView = null;
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null) {
            str = peekAppRuntime.getCurrentUin();
        } else {
            str = null;
        }
        qQProAvatarView.w(1, str);
        View findViewById5 = containerView.findViewById(R.id.xr5);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "containerView.findViewBy\u2026te_unbind_friend_head_iv)");
        this.mFriendAvatarView = (QQProAvatarView) findViewById5;
        View findViewById6 = containerView.findViewById(R.id.f165838xr3);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "containerView.findViewBy\u2026ate_unbind_electric_wave)");
        this.mElectricWaveView = (ImageView) findViewById6;
        View findViewById7 = containerView.findViewById(R.id.xrc);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "containerView.findViewBy\u2026ate_unbind_set_type_text)");
        this.mBindText = (TextView) findViewById7;
        Drawable drawable = ResourcesCompat.getDrawable(containerView.getResources(), R.drawable.f160468jh1, containerView.getContext().getTheme());
        if (drawable != null) {
            drawable.setBounds(0, ViewUtils.dpToPx(2.0f), ViewUtils.dpToPx(18.0f), ViewUtils.dpToPx(20.0f));
            TextView textView2 = this.mBindText;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBindText");
                textView2 = null;
            }
            textView2.setCompoundDrawables(null, null, drawable, null);
        }
        TextView textView3 = this.mBindText;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBindText");
        } else {
            textView = textView3;
        }
        textView.setOnClickListener(new View.OnClickListener() { // from class: k61.u
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                w.t(w.this, view);
            }
        });
        containerView.setOnClickListener(new View.OnClickListener() { // from class: k61.v
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                w.u(w.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    @SuppressLint({"SetTextI18n"})
    /* renamed from: s, reason: merged with bridge method [inline-methods] */
    public void onBindData(@Nullable IntimateBaseModel data, int position, @Nullable List<Object> payload) {
        int coerceAtLeast;
        if (data == null) {
            return;
        }
        IntimateInfo intimateInfo = data.getIntimateInfo();
        this.mFriendUin = data.getFriendUin();
        TextView textView = this.mBecomeFriendDays;
        QQProAvatarView qQProAvatarView = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBecomeFriendDays");
            textView = null;
        }
        textView.setText(String.valueOf(intimateInfo.beFriendDays + 1));
        int i3 = intimateInfo.scoreCardInfo.score;
        if (i3 == 0) {
            View view = this.mScoresLayout;
            if (view == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mScoresLayout");
                view = null;
            }
            view.setVisibility(4);
        } else {
            View view2 = this.mScoresLayout;
            if (view2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mScoresLayout");
                view2 = null;
            }
            view2.setVisibility(0);
        }
        TextView textView2 = this.mScores;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mScores");
            textView2 = null;
        }
        textView2.setText(i3 + "\u5206");
        QQProAvatarView qQProAvatarView2 = this.mFriendAvatarView;
        if (qQProAvatarView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFriendAvatarView");
        } else {
            qQProAvatarView = qQProAvatarView2;
        }
        qQProAvatarView.w(1, this.mFriendUin);
        int i16 = intimateInfo.maskType;
        int i17 = intimateInfo.maskLevel;
        coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(0, intimateInfo.lastAnimAfterFriendDays);
        com.tencent.mobileqq.activity.aio.intimate.header.g gVar = new com.tencent.mobileqq.activity.aio.intimate.header.g(i16, i17, coerceAtLeast, intimateInfo.beFriendDays + 1, 0L, intimateInfo.scoreCardInfo.score, 0L, "");
        ArrayList arrayList = new ArrayList();
        arrayList.add(gVar);
        com.tencent.mobileqq.activity.aio.intimate.header.a aVar = com.tencent.mobileqq.activity.aio.intimate.header.a.f179009a;
        if (aVar.d().get(intimateInfo.friendUin) != null) {
            aVar.d().remove(intimateInfo.friendUin);
        }
        aVar.d().put(intimateInfo.friendUin, com.tencent.mobileqq.activity.aio.intimate.header.a.g(arrayList));
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(@Nullable SimpleBaseEvent event) {
    }
}
