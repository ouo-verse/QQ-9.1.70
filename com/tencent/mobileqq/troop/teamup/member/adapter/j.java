package com.tencent.mobileqq.troop.teamup.member.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.tencent.biz.qui.quiemptystate.QUIEmptyState;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00072\u00020\u0001:\u0001\tB\u000f\u0012\u0006\u0010\u000b\u001a\u00020\b\u00a2\u0006\u0004\b\f\u0010\rJ\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004R\u0014\u0010\u000b\u001a\u00020\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\n\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/troop/teamup/member/adapter/j;", "", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "", "viewType", "Lcom/tencent/mobileqq/troop/teamup/member/adapter/h;", "b", "Lcom/tencent/mobileqq/troop/teamup/member/adapter/a;", "a", "Lcom/tencent/mobileqq/troop/teamup/member/adapter/a;", "eventHandler", "<init>", "(Lcom/tencent/mobileqq/troop/teamup/member/adapter/a;)V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class j {
    static IPatchRedirector $redirector_;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final a eventHandler;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nR\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0004R\u0014\u0010\b\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0004\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/troop/teamup/member/adapter/j$a;", "", "", "TROOP_TEAM_UP_EMPTY_ITEM", "I", "TROOP_TEAM_UP_ERROR", "TROOP_TEAM_UP_MEMBER_ITEM", "TROOP_TEAM_UP_TITLE_ITEM", "TROOP_TEAM_UP_TYPE_ITEM", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.troop.teamup.member.adapter.j$a, reason: from kotlin metadata */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(55925);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public j(@NotNull a eventHandler) {
        Intrinsics.checkNotNullParameter(eventHandler, "eventHandler");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) eventHandler);
        } else {
            this.eventHandler = eventHandler;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(j this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.eventHandler.b().invoke();
        EventCollector.getInstance().onViewClicked(view);
    }

    @NotNull
    public final h b(@NotNull ViewGroup parent, int viewType) {
        h mVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (h) iPatchRedirector.redirect((short) 2, (Object) this, (Object) parent, viewType);
        }
        Intrinsics.checkNotNullParameter(parent, "parent");
        if (viewType != 1) {
            if (viewType != 2) {
                if (viewType != 3) {
                    if (viewType != 5) {
                        FrameLayout frameLayout = new FrameLayout(parent.getContext());
                        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, ViewUtils.getScreenHeight() - ViewUtils.dip2px(206.0f));
                        layoutParams.gravity = 17;
                        frameLayout.setLayoutParams(layoutParams);
                        QUIEmptyState.Builder imageType = new QUIEmptyState.Builder(parent.getContext()).setImageType(16);
                        String qqStr = HardCodeUtil.qqStr(R.string.f236287dy);
                        Intrinsics.checkNotNullExpressionValue(qqStr, "qqStr(R.string.troop_team_up_no_join)");
                        QUIEmptyState build = imageType.setTitle(qqStr).setHalfScreenState(true).setBackgroundColorType(0).build();
                        build.setPadding(0, 0, 0, ViewUtils.dip2px(103.0f));
                        frameLayout.addView(build);
                        return new h(frameLayout);
                    }
                    FrameLayout frameLayout2 = new FrameLayout(parent.getContext());
                    frameLayout2.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
                    QUIEmptyState.Builder backgroundColorType = new QUIEmptyState.Builder(parent.getContext()).setImageType(5).setHalfScreenState(false).setBackgroundColorType(0);
                    String string = parent.getContext().getString(R.string.f235987d5);
                    Intrinsics.checkNotNullExpressionValue(string, "parent.context.getString\u2026eam_up_detail_load_error)");
                    backgroundColorType.setTitle(string);
                    String string2 = parent.getContext().getString(R.string.f236007d7);
                    Intrinsics.checkNotNullExpressionValue(string2, "parent.context.getString\u2026team_up_detail_net_error)");
                    backgroundColorType.setDesc(string2);
                    String string3 = parent.getContext().getString(R.string.f236047da);
                    Intrinsics.checkNotNullExpressionValue(string3, "parent.context.getString\u2026oop_team_up_detail_retry)");
                    backgroundColorType.setButton(string3, new View.OnClickListener() { // from class: com.tencent.mobileqq.troop.teamup.member.adapter.i
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            j.c(j.this, view);
                        }
                    });
                    frameLayout2.addView(backgroundColorType.build());
                    return new h(frameLayout2);
                }
                View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.i1f, parent, false);
                Intrinsics.checkNotNullExpressionValue(view, "view");
                mVar = new f(view, this.eventHandler);
            } else {
                View view2 = LayoutInflater.from(parent.getContext()).inflate(R.layout.i1h, parent, false);
                Intrinsics.checkNotNullExpressionValue(view2, "view");
                mVar = new k(view2);
            }
        } else {
            View view3 = LayoutInflater.from(parent.getContext()).inflate(R.layout.i1i, parent, false);
            Intrinsics.checkNotNullExpressionValue(view3, "view");
            mVar = new m(view3, this.eventHandler);
        }
        return mVar;
    }
}
