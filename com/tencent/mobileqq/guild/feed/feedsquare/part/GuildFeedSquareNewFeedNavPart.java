package com.tencent.mobileqq.guild.feed.feedsquare.part;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.ioc.RFWIocAbilityProvider;
import com.tencent.biz.richframework.ioc.callback.OnPromiseResolved;
import com.tencent.biz.richframework.part.PartIOCKt;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.data.IGuildParcelizeSimpleContact;
import com.tencent.mobileqq.guild.feed.feedsquare.part.remake.msgintent.FeedSectionListPartCallerMsgIntent;
import com.tencent.mobileqq.guild.feed.launcher.GuildFeedMainInitBean;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001bB\u000f\u0012\u0006\u0010\u0013\u001a\u00020\u0010\u00a2\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0016J\b\u0010\t\u001a\u00020\bH\u0014J\u001c\u0010\u000e\u001a\u00020\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016J\u0012\u0010\u000f\u001a\u00020\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016R\u0014\u0010\u0013\u001a\u00020\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/feedsquare/part/GuildFeedSquareNewFeedNavPart;", "Lcom/tencent/mobileqq/guild/feed/part/f;", "Landroid/view/View;", "view", "", NodeProps.ON_CLICK, MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "", "getInitRelyViewStubId", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onPartCreate", "onPartResume", "Lcom/tencent/mobileqq/guild/feed/feedsquare/viewmodel/k;", tl.h.F, "Lcom/tencent/mobileqq/guild/feed/feedsquare/viewmodel/k;", "vmApi", "Landroid/widget/FrameLayout;", "i", "Landroid/widget/FrameLayout;", "navBar", "<init>", "(Lcom/tencent/mobileqq/guild/feed/feedsquare/viewmodel/k;)V", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "a", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class GuildFeedSquareNewFeedNavPart extends com.tencent.mobileqq.guild.feed.part.f {

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.guild.feed.feedsquare.viewmodel.k vmApi;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private FrameLayout navBar;

    public GuildFeedSquareNewFeedNavPart(@NotNull com.tencent.mobileqq.guild.feed.feedsquare.viewmodel.k vmApi) {
        Intrinsics.checkNotNullParameter(vmApi, "vmApi");
        this.vmApi = vmApi;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void E9(ak1.a aVar) {
        aVar.g6();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void F9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onClick(View view) {
        com.tencent.mobileqq.guild.feed.feedsquare.part.remake.b<GuildFeedMainInitBean> context;
        com.tencent.mvi.base.route.j messenger;
        IGuildParcelizeSimpleContact iGuildParcelizeSimpleContact;
        com.tencent.mobileqq.guild.feed.feedsquare.part.remake.i<GuildFeedMainInitBean> d16;
        if (com.tencent.mobileqq.guild.util.o.a(view)) {
            return;
        }
        com.tencent.mobileqq.guild.feed.feedsquare.viewmodel.l.a(this.vmApi).o().setValue(Boolean.FALSE);
        RFWIocAbilityProvider.g().getIoc(ak1.a.class).originView(getPartRootView()).done(new OnPromiseResolved() { // from class: com.tencent.mobileqq.guild.feed.feedsquare.part.g
            @Override // com.tencent.biz.richframework.ioc.callback.OnPromiseResolved
            public final void onDone(Object obj) {
                GuildFeedSquareNewFeedNavPart.E9((ak1.a) obj);
            }
        }).run();
        com.tencent.mobileqq.guild.feed.feedsquare.part.remake.g gVar = (com.tencent.mobileqq.guild.feed.feedsquare.part.remake.g) PartIOCKt.getIocInterface(this, com.tencent.mobileqq.guild.feed.feedsquare.part.remake.g.class);
        if (gVar != null && (context = gVar.getContext()) != null && (messenger = context.getMessenger()) != null) {
            com.tencent.mobileqq.guild.feed.feedsquare.part.remake.b<GuildFeedMainInitBean> context2 = gVar.getContext();
            if (context2 != null && (d16 = context2.d()) != null) {
                iGuildParcelizeSimpleContact = d16.a();
            } else {
                iGuildParcelizeSimpleContact = null;
            }
            messenger.h(new FeedSectionListPartCallerMsgIntent.CallRefreshMsgIntent(iGuildParcelizeSimpleContact, false, false, true, null));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.Part
    public int getInitRelyViewStubId() {
        return R.id.weq;
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@NotNull View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        final FrameLayout onInitView$lambda$0 = (FrameLayout) rootView.findViewById(R.id.wep);
        Intrinsics.checkNotNullExpressionValue(onInitView$lambda$0, "onInitView$lambda$0");
        kotlin.b.b(onInitView$lambda$0, new Function0<Unit>() { // from class: com.tencent.mobileqq.guild.feed.feedsquare.part.GuildFeedSquareNewFeedNavPart$onInitView$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                GuildFeedSquareNewFeedNavPart guildFeedSquareNewFeedNavPart = GuildFeedSquareNewFeedNavPart.this;
                FrameLayout frameLayout = onInitView$lambda$0;
                Intrinsics.checkNotNullExpressionValue(frameLayout, "this");
                guildFeedSquareNewFeedNavPart.onClick(frameLayout);
            }
        });
        this.navBar = onInitView$lambda$0;
    }

    @Override // com.tencent.mobileqq.guild.feed.part.f, com.tencent.mobileqq.guild.feed.part.d, com.tencent.biz.richframework.part.Part
    public void onPartCreate(@Nullable Activity activity, @Nullable Bundle savedInstanceState) {
        super.onPartCreate(activity, savedInstanceState);
        MutableLiveData<Boolean> o16 = com.tencent.mobileqq.guild.feed.feedsquare.viewmodel.l.a(this.vmApi).o();
        LifecycleOwner c16 = com.tencent.mobileqq.guild.feed.part.a.c(this);
        final Function1<Boolean, Unit> function1 = new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.guild.feed.feedsquare.part.GuildFeedSquareNewFeedNavPart$onPartCreate$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Boolean bool) {
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke2(bool);
                return Unit.INSTANCE;
            }
        };
        o16.observe(c16, new Observer() { // from class: com.tencent.mobileqq.guild.feed.feedsquare.part.f
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GuildFeedSquareNewFeedNavPart.F9(Function1.this, obj);
            }
        });
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartResume(@Nullable Activity activity) {
        super.onPartResume(activity);
    }
}
