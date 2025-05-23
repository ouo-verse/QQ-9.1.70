package com.tencent.mobileqq.troop.homework.notice.detail.part;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.qui.quiemptystate.QUIEmptyState;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.troop.homework.notice.HWNoticeUtils;
import com.tencent.mobileqq.troop.homework.notice.detail.event.HWNoticeDetailEvent;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import java.util.ArrayList;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B\u0007\u00a2\u0006\u0004\b!\u0010\"J\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\f\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u001c\u0010\u0011\u001a\u00020\b2\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016J\u0012\u0010\u0012\u001a\u00020\b2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016J\u0012\u0010\u0015\u001a\u00020\b2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0016J\u0014\u0010\u0018\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00170\u0016H\u0016R\u0016\u0010\u000b\u001a\u00020\u00198\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u001b\u0010 \u001a\u00020\n8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\u00a8\u0006#"}, d2 = {"Lcom/tencent/mobileqq/troop/homework/notice/detail/part/HWDetailLoadingPart;", "Lcom/tencent/biz/richframework/part/Part;", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/mobileqq/troop/homework/notice/detail/event/HWNoticeDetailEvent;", "", "title", "", "type", "", "B9", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onPartCreate", "onPartDestroy", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "event", "onReceiveEvent", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "getEventClass", "Landroid/widget/RelativeLayout;", "d", "Landroid/widget/RelativeLayout;", "e", "Lkotlin/Lazy;", "z9", "()Landroid/view/View;", "loadingView", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class HWDetailLoadingPart extends Part implements SimpleEventReceiver<HWNoticeDetailEvent> {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private RelativeLayout rootView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy loadingView;

    public HWDetailLoadingPart() {
        Lazy lazy;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            lazy = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new Function0<View>() { // from class: com.tencent.mobileqq.troop.homework.notice.detail.part.HWDetailLoadingPart$loadingView$2
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) HWDetailLoadingPart.this);
                    }
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final View invoke() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (View) iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                    HWNoticeUtils hWNoticeUtils = HWNoticeUtils.f297171a;
                    Context context = HWDetailLoadingPart.this.getContext();
                    Intrinsics.checkNotNullExpressionValue(context, "context");
                    return hWNoticeUtils.c(context);
                }
            });
            this.loadingView = lazy;
            SimpleEventBus.getInstance().registerReceiver(this);
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void A9(SimpleBaseEvent simpleBaseEvent, HWDetailLoadingPart this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (simpleBaseEvent instanceof HWNoticeDetailEvent.NoticeDetailError) {
            if (((HWNoticeDetailEvent.NoticeDetailError) simpleBaseEvent).getErrorCode() == 10009) {
                this$0.B9("\u901a\u77e5\u5df2\u88ab\u5220\u9664\uff0c\u8bf7\u8054\u7cfb\u8001\u5e08\u6216\u7ba1\u7406\u5458", 16);
                return;
            } else {
                this$0.B9("\u6682\u65e0\u5185\u5bb9", 8);
                return;
            }
        }
        if (simpleBaseEvent instanceof HWNoticeDetailEvent.NoticeDetailUpdate) {
            RelativeLayout relativeLayout = this$0.rootView;
            if (relativeLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException(MosaicConstants$JsProperty.PROP_ROOT_VIEW);
                relativeLayout = null;
            }
            relativeLayout.removeView(this$0.z9());
        }
    }

    private final void B9(String title, int type) {
        RelativeLayout relativeLayout = this.rootView;
        RelativeLayout relativeLayout2 = null;
        if (relativeLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException(MosaicConstants$JsProperty.PROP_ROOT_VIEW);
            relativeLayout = null;
        }
        relativeLayout.removeView(z9());
        QUIEmptyState build = new QUIEmptyState.Builder(getContext()).setImageType(type).setBackgroundColorType(1).setTitle(title).build();
        RelativeLayout relativeLayout3 = this.rootView;
        if (relativeLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(MosaicConstants$JsProperty.PROP_ROOT_VIEW);
        } else {
            relativeLayout2 = relativeLayout3;
        }
        relativeLayout2.addView(build, -1, -1);
    }

    private final View z9() {
        return (View) this.loadingView.getValue();
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    @NotNull
    public ArrayList<Class<HWNoticeDetailEvent>> getEventClass() {
        ArrayList<Class<HWNoticeDetailEvent>> arrayListOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 6)) {
            arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(HWNoticeDetailEvent.NoticeDetailError.class, HWNoticeDetailEvent.NoticeDetailUpdate.class);
            return arrayListOf;
        }
        return (ArrayList) iPatchRedirector.redirect((short) 6, (Object) this);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@NotNull View rootView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) rootView);
            return;
        }
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        View findViewById = rootView.findViewById(R.id.root_layout);
        RelativeLayout relativeLayout = (RelativeLayout) findViewById;
        relativeLayout.addView(z9());
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById<Re\u2026ew(loadingView)\n        }");
        this.rootView = relativeLayout;
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartCreate(@Nullable Activity activity, @Nullable Bundle savedInstanceState) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) activity, (Object) savedInstanceState);
        } else {
            super.onPartCreate(activity, savedInstanceState);
        }
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(@Nullable Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) activity);
        } else {
            super.onPartDestroy(activity);
            SimpleEventBus.getInstance().unRegisterReceiver(this);
        }
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(@Nullable final SimpleBaseEvent event) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) event);
        } else {
            runOnActivityUiThread(new Runnable() { // from class: com.tencent.mobileqq.troop.homework.notice.detail.part.e
                @Override // java.lang.Runnable
                public final void run() {
                    HWDetailLoadingPart.A9(SimpleBaseEvent.this, this);
                }
            });
        }
    }
}
