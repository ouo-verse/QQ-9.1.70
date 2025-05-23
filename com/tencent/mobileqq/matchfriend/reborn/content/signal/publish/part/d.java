package com.tencent.mobileqq.matchfriend.reborn.content.signal.publish.part;

import android.app.Activity;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.biz.richframework.part.Part;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.matchfriend.reborn.content.signal.event.QQStrangerSignalPublishConfigSelectedEvent;
import com.tencent.mobileqq.matchfriend.reborn.content.signal.utils.ModelExtKt;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qqnt.aio.utils.l;
import com.tencent.trpcprotocol.kuolie.common.signal.SignalPB$SignalConfig;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B\u0007\u00a2\u0006\u0004\b*\u0010+J\u001a\u0010\t\u001a\u00020\b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u0004H\u0002J\u0010\u0010\u000f\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\rH\u0016J\u001c\u0010\u0014\u001a\u00020\b2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0016J\u0012\u0010\u0015\u001a\u00020\b2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016J\u0012\u0010\u0017\u001a\u00020\b2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0003H\u0016J\u0014\u0010\u001a\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00190\u0018H\u0016R\u0016\u0010\u001d\u001a\u00020\r8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010\u001f\u001a\u00020\r8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001cR\u0016\u0010#\u001a\u00020 8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010'\u001a\u00020$8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010)\u001a\u00020 8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b(\u0010\"\u00a8\u0006,"}, d2 = {"Lcom/tencent/mobileqq/matchfriend/reborn/content/signal/publish/part/d;", "Lcom/tencent/biz/richframework/part/Part;", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "Lcom/tencent/trpcprotocol/kuolie/common/signal/SignalPB$SignalConfig;", "signalConfig", "", "partnerPosition", "", "z9", DownloadInfo.spKey_Config, "Landroid/graphics/drawable/Drawable;", "x9", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onPartCreate", "onPartDestroy", "event", "onReceiveEvent", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "getEventClass", "d", "Landroid/view/View;", "iconView", "e", "bgView", "Landroid/widget/TextView;", "f", "Landroid/widget/TextView;", "signalAdjView", "Landroid/widget/ImageView;", h.F, "Landroid/widget/ImageView;", "signalIconView", "i", "signalNameView", "<init>", "()V", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class d extends Part implements SimpleEventReceiver<SimpleBaseEvent> {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private View iconView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private View bgView;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private TextView signalAdjView;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private ImageView signalIconView;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private TextView signalNameView;

    private final Drawable x9(SignalPB$SignalConfig config) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        float a16 = l.a(8.0f);
        gradientDrawable.setShape(0);
        gradientDrawable.setColors(ModelExtKt.l(config));
        gradientDrawable.setOrientation(GradientDrawable.Orientation.TOP_BOTTOM);
        gradientDrawable.setGradientType(0);
        gradientDrawable.setCornerRadii(new float[]{a16, a16, a16, a16, 0.0f, 0.0f, 0.0f, 0.0f});
        return gradientDrawable;
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        View findViewById = rootView.findViewById(R.id.opf);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.\u2026nger_signal_publish_icon)");
        this.iconView = findViewById;
        View findViewById2 = rootView.findViewById(R.id.opo);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "rootView.findViewById(R.\u2026er_signal_publish_top_bg)");
        this.bgView = findViewById2;
        View findViewById3 = rootView.findViewById(R.id.opg);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "rootView.findViewById(R.\u2026gnal_publish_partner_adj)");
        this.signalAdjView = (TextView) findViewById3;
        View findViewById4 = rootView.findViewById(R.id.oph);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "rootView.findViewById(R.\u2026nal_publish_partner_icon)");
        this.signalIconView = (ImageView) findViewById4;
        View findViewById5 = rootView.findViewById(R.id.opi);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "rootView.findViewById(R.\u2026nal_publish_partner_name)");
        this.signalNameView = (TextView) findViewById5;
        View view = this.iconView;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("iconView");
            view = null;
        }
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        obtain.mLoadingDrawable = new ColorDrawable(0);
        obtain.mFailedDrawable = new ColorDrawable(0);
        Unit unit = Unit.INSTANCE;
        view.setBackground(URLDrawable.getDrawable("https://downv6.qq.com/extendfriend/kl_publisher_signal_bubble.png", obtain));
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
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent event) {
        if (event instanceof QQStrangerSignalPublishConfigSelectedEvent) {
            QQStrangerSignalPublishConfigSelectedEvent qQStrangerSignalPublishConfigSelectedEvent = (QQStrangerSignalPublishConfigSelectedEvent) event;
            z9(qQStrangerSignalPublishConfigSelectedEvent.getConfig(), qQStrangerSignalPublishConfigSelectedEvent.getPartnerPosition());
        }
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class<SimpleBaseEvent>> getEventClass() {
        ArrayList<Class<SimpleBaseEvent>> arrayListOf;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(QQStrangerSignalPublishConfigSelectedEvent.class);
        return arrayListOf;
    }

    private final void z9(SignalPB$SignalConfig signalConfig, int partnerPosition) {
        String str;
        if (signalConfig != null) {
            View view = this.bgView;
            TextView textView = null;
            if (view == null) {
                Intrinsics.throwUninitializedPropertyAccessException("bgView");
                view = null;
            }
            view.setBackground(x9(signalConfig));
            TextView textView2 = this.signalNameView;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("signalNameView");
                textView2 = null;
            }
            textView2.setText(signalConfig.partner_name.get());
            ImageView imageView = this.signalIconView;
            if (imageView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("signalIconView");
                imageView = null;
            }
            String str2 = signalConfig.icon.get();
            URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
            obtain.mRequestWidth = l.b(32);
            obtain.mRequestHeight = l.b(32);
            obtain.mLoadingDrawable = new ColorDrawable(0);
            obtain.mFailedDrawable = new ColorDrawable(0);
            Unit unit = Unit.INSTANCE;
            imageView.setImageDrawable(URLDrawable.getDrawable(str2, obtain));
            TextView textView3 = this.signalAdjView;
            if (textView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("signalAdjView");
            } else {
                textView = textView3;
            }
            if (signalConfig.partner_adjs.size() > partnerPosition) {
                str = textView.getContext().getString(R.string.f169683x11, signalConfig.partner_adjs.get(partnerPosition).partner_adj_name.get());
            } else {
                str = "";
            }
            textView.setText(str);
        }
    }
}
