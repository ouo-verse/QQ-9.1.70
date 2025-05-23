package com.tencent.mobileqq.flock.feedlist.part;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import androidx.lifecycle.LiveData;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.flock.api.FlockConstants$FlockListScene;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u000e\u001a\u00020\t\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\u0012\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016J\u0012\u0010\b\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003H\u0016R\u0017\u0010\u000e\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0016\u0010\u0012\u001a\u00020\u000f8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R#\u0010\u0019\u001a\n \u0014*\u0004\u0018\u00010\u00130\u00138BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/mobileqq/flock/feedlist/part/FlockFeedListPublishPart;", "Lcom/tencent/mobileqq/flock/base/b;", "Landroid/view/View$OnClickListener;", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "", "onInitView", "v", NodeProps.ON_CLICK, "Lcom/tencent/mobileqq/flock/api/FlockConstants$FlockListScene;", "d", "Lcom/tencent/mobileqq/flock/api/FlockConstants$FlockListScene;", "z9", "()Lcom/tencent/mobileqq/flock/api/FlockConstants$FlockListScene;", "type", "Landroid/widget/ImageView;", "e", "Landroid/widget/ImageView;", "ivPublish", "Lcom/tencent/mobileqq/flock/feedlist/viewmodel/a;", "kotlin.jvm.PlatformType", "f", "Lkotlin/Lazy;", "x9", "()Lcom/tencent/mobileqq/flock/feedlist/viewmodel/a;", "feedListVm", "<init>", "(Lcom/tencent/mobileqq/flock/api/FlockConstants$FlockListScene;)V", "qq-flock-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class FlockFeedListPublishPart extends com.tencent.mobileqq.flock.base.b implements View.OnClickListener {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final FlockConstants$FlockListScene type;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private ImageView ivPublish;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy feedListVm;

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes12.dex */
    public /* synthetic */ class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f210157a;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(38935);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 1)) {
                redirector.redirect((short) 1);
                return;
            }
            int[] iArr = new int[FlockConstants$FlockListScene.values().length];
            try {
                iArr[FlockConstants$FlockListScene.TROOP.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[FlockConstants$FlockListScene.TOPIC_AGGREGATION.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f210157a = iArr;
        }
    }

    public FlockFeedListPublishPart(@NotNull FlockConstants$FlockListScene type) {
        Lazy lazy;
        Intrinsics.checkNotNullParameter(type, "type");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) type);
            return;
        }
        this.type = type;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<com.tencent.mobileqq.flock.feedlist.viewmodel.a>() { // from class: com.tencent.mobileqq.flock.feedlist.part.FlockFeedListPublishPart$feedListVm$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) FlockFeedListPublishPart.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final com.tencent.mobileqq.flock.feedlist.viewmodel.a invoke() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (com.tencent.mobileqq.flock.feedlist.viewmodel.a) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
                FlockFeedListPublishPart flockFeedListPublishPart = FlockFeedListPublishPart.this;
                return (com.tencent.mobileqq.flock.feedlist.viewmodel.a) flockFeedListPublishPart.getViewModel(com.tencent.mobileqq.flock.feedlist.viewmodel.a.INSTANCE.a(flockFeedListPublishPart.z9()));
            }
        });
        this.feedListVm = lazy;
    }

    private final com.tencent.mobileqq.flock.feedlist.viewmodel.a x9() {
        return (com.tencent.mobileqq.flock.feedlist.viewmodel.a) this.feedListVm.getValue();
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0079  */
    @Override // android.view.View.OnClickListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onClick(@Nullable View v3) {
        Integer num;
        Long l3;
        int i3;
        com.tencent.mobileqq.flock.feedlist.viewmodel.a x95;
        com.tencent.mobileqq.topicaggregation.viewmodel.a aVar;
        LiveData<b55.g> d26;
        Intent intent;
        EventCollector.getInstance().onViewClickedBefore(v3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) v3);
        } else {
            b55.g gVar = null;
            if (v3 != null) {
                num = Integer.valueOf(v3.getId());
            } else {
                num = null;
            }
            if (num != null && num.intValue() == R.id.y7b) {
                Activity activity = getActivity();
                if (activity != null && (intent = activity.getIntent()) != null) {
                    l3 = Long.valueOf(intent.getLongExtra("from_group_id", 0L));
                } else {
                    l3 = null;
                }
                int i16 = a.f210157a[this.type.ordinal()];
                int i17 = 1;
                if (i16 != 1) {
                    i17 = 2;
                    if (i16 == 2) {
                        i3 = 4;
                        com.tencent.mobileqq.flock.a aVar2 = com.tencent.mobileqq.flock.a.f209993a;
                        Context context = getContext();
                        Intrinsics.checkNotNullExpressionValue(context, "context");
                        x95 = x9();
                        if (!(x95 instanceof com.tencent.mobileqq.topicaggregation.viewmodel.a)) {
                            aVar = (com.tencent.mobileqq.topicaggregation.viewmodel.a) x95;
                        } else {
                            aVar = null;
                        }
                        if (aVar != null && (d26 = aVar.d2()) != null) {
                            gVar = d26.getValue();
                        }
                        com.tencent.mobileqq.flock.a.e(aVar2, context, i3, l3, null, gVar, 8, null);
                    }
                }
                i3 = i17;
                com.tencent.mobileqq.flock.a aVar22 = com.tencent.mobileqq.flock.a.f209993a;
                Context context2 = getContext();
                Intrinsics.checkNotNullExpressionValue(context2, "context");
                x95 = x9();
                if (!(x95 instanceof com.tencent.mobileqq.topicaggregation.viewmodel.a)) {
                }
                if (aVar != null) {
                    gVar = d26.getValue();
                }
                com.tencent.mobileqq.flock.a.e(aVar22, context2, i3, l3, null, gVar, 8, null);
            }
        }
        EventCollector.getInstance().onViewClicked(v3);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@Nullable View rootView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) rootView);
            return;
        }
        super.onInitView(rootView);
        if (rootView != null) {
            View findViewById = rootView.findViewById(R.id.y7b);
            ImageView imageView = (ImageView) findViewById;
            imageView.setOnClickListener(this);
            if (QQTheme.isNowThemeIsNight()) {
                imageView.setImageResource(R.drawable.jmy);
            } else {
                imageView.setImageResource(R.drawable.jmz);
            }
            com.tencent.mobileqq.flock.datong.c.c(imageView, "em_bas_search_partner_publish");
            Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById<ImageView>(\u2026          )\n            }");
            this.ivPublish = imageView;
        }
    }

    @NotNull
    public final FlockConstants$FlockListScene z9() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (FlockConstants$FlockListScene) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.type;
    }
}
