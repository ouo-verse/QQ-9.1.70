package com.qzone.reborn.feedpro.widget.header;

import android.view.View;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.tencent.mobileqq.R;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\r\u001a\u00020\f\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\b\u0010\u0003\u001a\u00020\u0002H\u0014J\b\u0010\u0005\u001a\u00020\u0004H\u0016R\u0019\u0010\u000b\u001a\u0004\u0018\u00010\u00068\u0006\u00a2\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n\u00a8\u0006\u0010"}, d2 = {"Lcom/qzone/reborn/feedpro/widget/header/QzoneFeedProUserHomeHeaderNaviBarElement;", "Lcom/qzone/reborn/feedpro/widget/header/d;", "", "k", "", "onInit", "Lcom/qzone/reborn/feedpro/widget/header/QzoneFeedProUserHomeNaviBar;", "f", "Lcom/qzone/reborn/feedpro/widget/header/QzoneFeedProUserHomeNaviBar;", "p", "()Lcom/qzone/reborn/feedpro/widget/header/QzoneFeedProUserHomeNaviBar;", "navigatorBar", "Landroid/view/View;", "containerView", "<init>", "(Landroid/view/View;)V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class QzoneFeedProUserHomeHeaderNaviBarElement extends d {

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final QzoneFeedProUserHomeNaviBar navigatorBar;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QzoneFeedProUserHomeHeaderNaviBarElement(View containerView) {
        super(containerView);
        Intrinsics.checkNotNullParameter(containerView, "containerView");
        this.navigatorBar = (QzoneFeedProUserHomeNaviBar) containerView.findViewById(R.id.f162834mw0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.reborn.feedpro.widget.header.d
    public String k() {
        return "QzoneFeedProUserHomeHeaderNaviBarElement";
    }

    @Override // com.qzone.reborn.feedpro.widget.header.c
    public void onInit() {
        com.qzone.reborn.feedpro.viewmodel.m mVar = (com.qzone.reborn.feedpro.viewmodel.m) l(com.qzone.reborn.feedpro.viewmodel.m.class);
        MutableLiveData<wd.h> d26 = mVar.d2();
        LifecycleOwner j3 = j();
        final Function1<wd.h, Unit> function1 = new Function1<wd.h, Unit>() { // from class: com.qzone.reborn.feedpro.widget.header.QzoneFeedProUserHomeHeaderNaviBarElement$onInit$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(wd.h hVar) {
                invoke2(hVar);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(wd.h hVar) {
                QzoneFeedProUserHomeNaviBar navigatorBar = QzoneFeedProUserHomeHeaderNaviBarElement.this.getNavigatorBar();
                if (navigatorBar != null) {
                    navigatorBar.H(hVar);
                }
            }
        };
        d26.observe(j3, new Observer() { // from class: com.qzone.reborn.feedpro.widget.header.s
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QzoneFeedProUserHomeHeaderNaviBarElement.q(Function1.this, obj);
            }
        });
        MutableLiveData<Boolean> o26 = mVar.o2();
        LifecycleOwner j16 = j();
        final Function1<Boolean, Unit> function12 = new Function1<Boolean, Unit>() { // from class: com.qzone.reborn.feedpro.widget.header.QzoneFeedProUserHomeHeaderNaviBarElement$onInit$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke2(bool);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Boolean it) {
                QzoneFeedProUserHomeNaviBar navigatorBar = QzoneFeedProUserHomeHeaderNaviBarElement.this.getNavigatorBar();
                if (navigatorBar != null) {
                    Intrinsics.checkNotNullExpressionValue(it, "it");
                    navigatorBar.F(it.booleanValue());
                }
            }
        };
        o26.observe(j16, new Observer() { // from class: com.qzone.reborn.feedpro.widget.header.t
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QzoneFeedProUserHomeHeaderNaviBarElement.r(Function1.this, obj);
            }
        });
        MutableLiveData<Boolean> p26 = mVar.p2();
        LifecycleOwner j17 = j();
        final Function1<Boolean, Unit> function13 = new Function1<Boolean, Unit>() { // from class: com.qzone.reborn.feedpro.widget.header.QzoneFeedProUserHomeHeaderNaviBarElement$onInit$3
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke2(bool);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Boolean it) {
                QzoneFeedProUserHomeNaviBar navigatorBar = QzoneFeedProUserHomeHeaderNaviBarElement.this.getNavigatorBar();
                if (navigatorBar != null) {
                    Intrinsics.checkNotNullExpressionValue(it, "it");
                    navigatorBar.G(it.booleanValue());
                }
            }
        };
        p26.observe(j17, new Observer() { // from class: com.qzone.reborn.feedpro.widget.header.u
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QzoneFeedProUserHomeHeaderNaviBarElement.s(Function1.this, obj);
            }
        });
    }

    /* renamed from: p, reason: from getter */
    public final QzoneFeedProUserHomeNaviBar getNavigatorBar() {
        return this.navigatorBar;
    }
}
