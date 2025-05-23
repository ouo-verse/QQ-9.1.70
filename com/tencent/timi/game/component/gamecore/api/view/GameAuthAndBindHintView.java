package com.tencent.timi.game.component.gamecore.api.view;

import ag4.c;
import ag4.i;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.timi.game.component.gamecore.api.view.GameAuthAndBindHintView;
import com.tencent.timi.game.utils.o;
import gh4.d;
import gh4.e;
import gh4.f;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mm4.b;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;
import trpc.yes.common.GameAuthOuterClass$GetGameAuthRsp;
import trpc.yes.common.YesGameInfoOuterClass$GetUserGameDefaultRoleRsp;
import trpc.yes.common.YesGameInfoOuterClass$GetUserGameRoleListRsp;

/* compiled from: P */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 !2\u00020\u00012\u00020\u0002:\u0001\u000bB'\b\u0007\u0012\u0006\u0010\u001b\u001a\u00020\u001a\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001c\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u0005\u00a2\u0006\u0004\b\u001f\u0010 J\u0016\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005J\u0010\u0010\u000b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0016J\u001c\u0010\u0010\u001a\u00020\u00072\b\u0010\r\u001a\u0004\u0018\u00010\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016J\u0006\u0010\u0011\u001a\u00020\u0007R\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0015\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0014R\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018\u00a8\u0006\""}, d2 = {"Lcom/tencent/timi/game/component/gamecore/api/view/GameAuthAndBindHintView;", "Landroid/widget/RelativeLayout;", "Lag4/c$a;", "Lcom/tencent/mobileqq/app/QBaseActivity;", "owner", "", "yesGameId", "", "e", "Ltrpc/yes/common/YesGameInfoOuterClass$GetUserGameDefaultRoleRsp;", "defaultAccount", "a", "Ltrpc/yes/common/GameAuthOuterClass$GetGameAuthRsp;", "authInfo", "Ltrpc/yes/common/YesGameInfoOuterClass$GetUserGameRoleListRsp;", "accountList", "b", "d", "Lcom/tencent/mobileqq/app/QBaseActivity;", "mLifecycleContext", "I", "mYesGameId", "Lag4/c;", "f", "Lag4/c;", "mAccountChecker", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", h.F, "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class GameAuthAndBindHintView extends RelativeLayout implements c.a {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private QBaseActivity mLifecycleContext;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private int mYesGameId;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private c mAccountChecker;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GameAuthAndBindHintView(@NotNull Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(GameAuthOuterClass$GetGameAuthRsp gameAuthOuterClass$GetGameAuthRsp, GameAuthAndBindHintView this$0, YesGameInfoOuterClass$GetUserGameRoleListRsp yesGameInfoOuterClass$GetUserGameRoleListRsp, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!o.c("SmobaAuthAndBindHintView_")) {
            if (gameAuthOuterClass$GetGameAuthRsp == null) {
                i iVar = (i) b.b(i.class);
                int i3 = this$0.mYesGameId;
                QBaseActivity qBaseActivity = this$0.mLifecycleContext;
                Intrinsics.checkNotNull(qBaseActivity);
                iVar.F3(i3, qBaseActivity, Boolean.TRUE, null, null);
            } else if (!gameAuthOuterClass$GetGameAuthRsp.is_auth.get()) {
                i iVar2 = (i) b.b(i.class);
                int i16 = this$0.mYesGameId;
                QBaseActivity qBaseActivity2 = this$0.mLifecycleContext;
                Intrinsics.checkNotNull(qBaseActivity2);
                iVar2.o3(i16, qBaseActivity2, gameAuthOuterClass$GetGameAuthRsp.auth_desc.get(), Boolean.TRUE, null, null);
            } else if (yesGameInfoOuterClass$GetUserGameRoleListRsp != null) {
                i iVar3 = (i) b.b(i.class);
                int i17 = this$0.mYesGameId;
                QBaseActivity qBaseActivity3 = this$0.mLifecycleContext;
                Intrinsics.checkNotNull(qBaseActivity3);
                iVar3.I2(i17, qBaseActivity3, yesGameInfoOuterClass$GetUserGameRoleListRsp, null);
            } else {
                i iVar4 = (i) b.b(i.class);
                int i18 = this$0.mYesGameId;
                QBaseActivity qBaseActivity4 = this$0.mLifecycleContext;
                Intrinsics.checkNotNull(qBaseActivity4);
                iVar4.J1(i18, qBaseActivity4, null);
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // ag4.c.a
    public void a(@NotNull YesGameInfoOuterClass$GetUserGameDefaultRoleRsp defaultAccount) {
        Intrinsics.checkNotNullParameter(defaultAccount, "defaultAccount");
        QLog.i("SmobaAuthAndBindHintView_", 2, "hideHintView defaultAccount:" + defaultAccount);
        setVisibility(8);
    }

    @Override // ag4.c.a
    public void b(@Nullable final GameAuthOuterClass$GetGameAuthRsp authInfo, @Nullable final YesGameInfoOuterClass$GetUserGameRoleListRsp accountList) {
        d dVar;
        e I0 = ((f) b.b(f.class)).I0();
        if (I0 != null) {
            dVar = I0.m0();
        } else {
            dVar = null;
        }
        if (dVar != null) {
            dVar.a(this, dVar.H());
        }
        QLog.i("SmobaAuthAndBindHintView_", 2, "showHintView authInfo:" + authInfo + ", accountList:" + accountList);
        setOnClickListener(new View.OnClickListener() { // from class: bg4.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GameAuthAndBindHintView.f(GameAuthOuterClass$GetGameAuthRsp.this, this, accountList, view);
            }
        });
        setVisibility(0);
    }

    public final void d() {
        c cVar = this.mAccountChecker;
        if (cVar != null) {
            cVar.e();
        }
    }

    public final void e(@NotNull QBaseActivity owner, int yesGameId) {
        Intrinsics.checkNotNullParameter(owner, "owner");
        this.mLifecycleContext = owner;
        this.mYesGameId = yesGameId;
        c cVar = new c(yesGameId);
        this.mAccountChecker = cVar;
        cVar.m(this);
        c cVar2 = this.mAccountChecker;
        if (cVar2 != null) {
            cVar2.f();
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GameAuthAndBindHintView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ GameAuthAndBindHintView(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GameAuthAndBindHintView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        View.inflate(context, R.layout.hxs, this);
    }
}
