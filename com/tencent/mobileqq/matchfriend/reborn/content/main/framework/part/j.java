package com.tencent.mobileqq.matchfriend.reborn.content.main.framework.part;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Looper;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.biz.richframework.order.IOrderElement;
import com.tencent.biz.richframework.order.RFWOrderElementManager;
import com.tencent.biz.richframework.part.Part;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.common.picload.QQPicLoader;
import com.tencent.mobileqq.matchfriend.reborn.content.main.matching.QQStrangerNearbyEntryCreateEvent;
import com.tencent.mobileqq.matchfriend.reborn.kuikly.QQStrangerKuiklyEvent;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.widget.RoundRelativeLayout;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import mqq.app.Constants;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 *2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0001+B\u0007\u00a2\u0006\u0004\b(\u0010)J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\f\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0018\u0010\r\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0010\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J\u001c\u0010\u0015\u001a\u00020\u00062\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0016J\u0012\u0010\u0016\u001a\u00020\u00062\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016J\u0012\u0010\u0017\u001a\u00020\u00062\b\u0010\u000f\u001a\u0004\u0018\u00010\u0003H\u0016J$\u0010\u001b\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00190\u0018j\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0019`\u001aH\u0016J\u0010\u0010\u001f\u001a\u00020\u001e2\u0006\u0010\u001d\u001a\u00020\u001cH\u0016R\u0014\u0010#\u001a\u00020 8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u0018\u0010'\u001a\u0004\u0018\u00010$8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b%\u0010&\u00a8\u0006,"}, d2 = {"Lcom/tencent/mobileqq/matchfriend/reborn/content/main/framework/part/j;", "Lcom/tencent/biz/richframework/part/Part;", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "", "A9", "Landroid/widget/ImageView;", "iv", "", "url", "D9", "C9", "Lcom/tencent/mobileqq/matchfriend/reborn/kuikly/QQStrangerKuiklyEvent;", "event", "z9", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onPartCreate", "onPartDestroy", "onReceiveEvent", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "Lkotlin/collections/ArrayList;", "getEventClass", "Ljava/lang/Runnable;", "runnable", "", "runOnActivityUiThread", "Ls72/a;", "d", "Ls72/a;", DownloadInfo.spKey_Config, "Ll82/g;", "e", "Ll82/g;", "guideElement", "<init>", "()V", "f", "a", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class j extends Part implements SimpleEventReceiver<SimpleBaseEvent> {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final s72.a config = s72.a.INSTANCE.a();

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private l82.g guideElement;

    private final void A9(View rootView) {
        boolean isBlank;
        super.onInitView(rootView);
        View findViewById = rootView.findViewById(R.id.okq);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.id.iv_fg)");
        ImageView imageView = (ImageView) findViewById;
        View findViewById2 = rootView.findViewById(R.id.oko);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "rootView.findViewById(R.id.iv_bg)");
        ImageView imageView2 = (ImageView) findViewById2;
        View findViewById3 = rootView.findViewById(R.id.osa);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "rootView.findViewById(R.id.tv_title)");
        TextView textView = (TextView) findViewById3;
        View findViewById4 = rootView.findViewById(R.id.orx);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "rootView.findViewById(R.id.tv_desc)");
        TextView textView2 = (TextView) findViewById4;
        RoundRelativeLayout roundRelativeLayout = rootView instanceof RoundRelativeLayout ? (RoundRelativeLayout) rootView : null;
        if (roundRelativeLayout != null) {
            roundRelativeLayout.f316195e = com.tencent.mobileqq.matchfriend.reborn.content.main.framework.utils.o.e(8);
            com.tencent.mobileqq.matchfriend.reborn.utils.r.c(roundRelativeLayout, 0.0f, 1, null);
        }
        textView2.setText(this.config.getDesc());
        textView.setText(this.config.getTitle());
        C9(imageView2, this.config.getBackground());
        isBlank = StringsKt__StringsJVMKt.isBlank(this.config.getCom.tencent.mobileqq.msf.core.net.r.a.o java.lang.String());
        if (!isBlank) {
            D9(imageView, this.config.getCom.tencent.mobileqq.msf.core.net.r.a.o java.lang.String());
        }
        rootView.setOnClickListener(com.tencent.mobileqq.matchfriend.reborn.register.guest.b.a(new com.tencent.mobileqq.matchfriend.reborn.content.main.framework.utils.b(0, new View.OnClickListener() { // from class: com.tencent.mobileqq.matchfriend.reborn.content.main.framework.part.i
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                j.B9(view);
            }
        }, 1, null)));
        Activity activity = getActivity();
        Intrinsics.checkNotNullExpressionValue(activity, "activity");
        l82.g gVar = new l82.g(rootView, activity);
        m82.a aVar = m82.a.f416439a;
        aVar.b().addElement(gVar);
        aVar.b().notifyGroupActivate(gVar, RFWOrderElementManager.OrderMode.WAIT_MODE, 500L);
        this.guideElement = gVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void B9(View view) {
        com.tencent.mobileqq.matchfriend.reborn.utils.k kVar = com.tencent.mobileqq.matchfriend.reborn.utils.k.f245485a;
        Context context = view.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "it.context");
        kVar.h(context);
    }

    private final void C9(ImageView iv5, String url) {
        Option option = Option.obtain().setTargetView(iv5).setUrl(url).setLoadingDrawableId(R.drawable.g1e).setFailedDrawableId(R.drawable.g1e);
        QQPicLoader qQPicLoader = QQPicLoader.f201806a;
        Intrinsics.checkNotNullExpressionValue(option, "option");
        qQPicLoader.e(option, null);
    }

    private final void D9(ImageView iv5, String url) {
        Option option = Option.obtain().setTargetView(iv5).setUrl(url).setLoadingDrawable(new ColorDrawable(0)).setFailDrawable(new ColorDrawable(0));
        QQPicLoader qQPicLoader = QQPicLoader.f201806a;
        Intrinsics.checkNotNullExpressionValue(option, "option");
        qQPicLoader.e(option, null);
    }

    private final void z9(QQStrangerKuiklyEvent event) {
        if (Intrinsics.areEqual(event.getEventName(), "QQ_STRANGER_NEARBY_ENTRY_GUIDE_CLOSE_EVENT")) {
            QLog.i("QQStrangerNearbyEntryPart", 1, "onKuiklyEvent: QQStrangerNearbyEntryGuideCloseEvent " + event.getData());
            JSONObject data = event.getData();
            if (data != null ? data.optBoolean("click_entry", false) : false) {
                com.tencent.mobileqq.matchfriend.reborn.utils.k kVar = com.tencent.mobileqq.matchfriend.reborn.utils.k.f245485a;
                Context context = getContext();
                Intrinsics.checkNotNullExpressionValue(context, "context");
                kVar.h(context);
            }
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartCreate(Activity activity, Bundle savedInstanceState) {
        super.onPartCreate(activity, savedInstanceState);
        SimpleEventBus.getInstance().registerReceiver(this);
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        super.onPartDestroy(activity);
        SimpleEventBus.getInstance().unRegisterReceiver(this);
        l82.g gVar = this.guideElement;
        if (gVar != null) {
            m82.a.f416439a.b().inactivateElement((IOrderElement) gVar, false);
        }
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent event) {
        if (event instanceof QQStrangerNearbyEntryCreateEvent) {
            A9(((QQStrangerNearbyEntryCreateEvent) event).getRootView());
        } else if (event instanceof QQStrangerKuiklyEvent) {
            z9((QQStrangerKuiklyEvent) event);
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public boolean runOnActivityUiThread(Runnable runnable) {
        Intrinsics.checkNotNullParameter(runnable, "runnable");
        if (Intrinsics.areEqual(Looper.getMainLooper(), Looper.myLooper())) {
            runnable.run();
            return true;
        }
        return super.runOnActivityUiThread(runnable);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class<SimpleBaseEvent>> getEventClass() {
        ArrayList<Class<SimpleBaseEvent>> arrayListOf;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(QQStrangerKuiklyEvent.class, QQStrangerNearbyEntryCreateEvent.class);
        return arrayListOf;
    }
}
