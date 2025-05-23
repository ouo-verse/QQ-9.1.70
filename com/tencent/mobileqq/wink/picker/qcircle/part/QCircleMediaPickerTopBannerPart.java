package com.tencent.mobileqq.wink.picker.qcircle.part;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import com.google.android.material.appbar.AppBarLayout;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.wink.event.RemovePickerBannerBarEvent;
import com.tencent.mobileqq.wink.event.UpdateMediaPickerBannerTagEvent;
import com.tencent.mobileqq.wink.picker.core.WinkMediaPickerMainBaseFragment;
import com.tencent.mobileqq.wink.picker.core.ktx.ViewExKt;
import com.tencent.mobileqq.wink.picker.qcircle.QCircleTemplateLibraryMediaPickerFragment;
import com.tencent.mobileqq.wink.picker.qcircle.viewmodel.c;
import com.tencent.mobileqq.wink.utils.aj;
import com.tencent.mobileqq.wink.view.RoundCornerImageView;
import com.tencent.mobileqq.winkreport.datong.WinkDTParamBuilder;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.mobileqq.winkreport.datong.WinkDatongCurrentParams;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\u0018\u0000 &2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0001'B\u0011\u0012\b\b\u0002\u0010#\u001a\u00020\u001f\u00a2\u0006\u0004\b$\u0010%J\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J.\u0010\u0010\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000b2\u0014\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\rH\u0002J\b\u0010\u0011\u001a\u00020\u000bH\u0016J\u0012\u0010\u0013\u001a\u00020\b2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0004H\u0016J\u001c\u0010\u0018\u001a\u00020\b2\b\u0010\u0015\u001a\u0004\u0018\u00010\u00142\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0016J\u0012\u0010\u0019\u001a\u00020\b2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0016J\u0012\u0010\u001b\u001a\u00020\b2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0003H\u0016J\u0014\u0010\u001e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u001d0\u001cH\u0016J\b\u0010 \u001a\u00020\u001fH\u0016R\u0014\u0010#\u001a\u00020\u001f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b!\u0010\"\u00a8\u0006("}, d2 = {"Lcom/tencent/mobileqq/wink/picker/qcircle/part/QCircleMediaPickerTopBannerPart;", "Lcom/tencent/biz/richframework/part/Part;", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "Landroid/view/View;", "topBanner", "Lcom/tencent/mobileqq/wink/picker/qcircle/viewmodel/c$b;", "mediaPickerTopBannerData", "", "D9", "view", "", "elementId", "", "", "extParams", "C9", "getLogTag", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onPartCreate", "onPartDestroy", "event", "onReceiveEvent", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "getEventClass", "", "isPartEnable", "d", "Z", "isUseAiFace", "<init>", "(Z)V", "e", "a", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class QCircleMediaPickerTopBannerPart extends Part implements SimpleEventReceiver<SimpleBaseEvent> {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final boolean isUseAiFace;

    public QCircleMediaPickerTopBannerPart(boolean z16) {
        this.isUseAiFace = z16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void B9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void C9(View view, String elementId, Map<String, ? extends Object> extParams) {
        VideoReport.setElementId(view, elementId);
        Map<String, Object> buildElementParams = WinkDTParamBuilder.buildElementParams();
        buildElementParams.putAll(extParams);
        VideoReport.setElementParams(view, buildElementParams);
        VideoReport.setElementEndExposePolicy(view, EndExposurePolicy.REPORT_ALL);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public final void D9(View topBanner, c.MediaBannerData mediaPickerTopBannerData) {
        ViewGroup.MarginLayoutParams marginLayoutParams;
        boolean isBlank;
        boolean isBlank2;
        View findViewById = topBanner.findViewById(R.id.t3x);
        Intrinsics.checkNotNullExpressionValue(findViewById, "topBanner.findViewById(R.id.banner_icon)");
        RoundCornerImageView roundCornerImageView = (RoundCornerImageView) findViewById;
        roundCornerImageView.setImageDrawable(mediaPickerTopBannerData.getMediaIcon());
        roundCornerImageView.setCorner(ViewUtils.dpToPx(4.0f));
        final TextView textView = (TextView) topBanner.findViewById(R.id.t4a);
        String mediaType = mediaPickerTopBannerData.getMediaType();
        String str = "music";
        switch (mediaType.hashCode()) {
            case 714056:
                if (mediaType.equals("\u5708\u5b50")) {
                    roundCornerImageView.setVisibility(8);
                    ViewGroup.LayoutParams layoutParams = textView.getLayoutParams();
                    if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                        marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                    } else {
                        marginLayoutParams = null;
                    }
                    if (marginLayoutParams != null) {
                        marginLayoutParams.leftMargin = ViewUtils.dpToPx(20.0f);
                    }
                    textView.setText(textView.getResources().getString(R.string.f216175xl));
                    str = WinkDaTongReportConstant.ElementParamValue.XSJ_BANNER_TYPE_CIRCLE;
                    break;
                }
                CharSequence text = textView.getText();
                textView.setText(((Object) text) + mediaPickerTopBannerData.getMediaType() + "\"" + mediaPickerTopBannerData.getMediaName() + "\"");
                textView.post(new Runnable() { // from class: com.tencent.mobileqq.wink.picker.qcircle.part.p
                    @Override // java.lang.Runnable
                    public final void run() {
                        QCircleMediaPickerTopBannerPart.E9(textView);
                    }
                });
                str = "";
                break;
            case 868734:
                if (mediaType.equals("\u6a21\u677f")) {
                    String extendDes = mediaPickerTopBannerData.getExtendDes();
                    isBlank = StringsKt__StringsJVMKt.isBlank(extendDes);
                    if (isBlank) {
                        CharSequence text2 = textView.getText();
                        extendDes = ((Object) text2) + mediaPickerTopBannerData.getMediaType() + "\u201c" + mediaPickerTopBannerData.getMediaName() + "\u201d";
                    }
                    textView.setText(extendDes);
                    str = "template";
                    break;
                }
                CharSequence text3 = textView.getText();
                textView.setText(((Object) text3) + mediaPickerTopBannerData.getMediaType() + "\"" + mediaPickerTopBannerData.getMediaName() + "\"");
                textView.post(new Runnable() { // from class: com.tencent.mobileqq.wink.picker.qcircle.part.p
                    @Override // java.lang.Runnable
                    public final void run() {
                        QCircleMediaPickerTopBannerPart.E9(textView);
                    }
                });
                str = "";
                break;
            case 1149019:
                if (mediaType.equals("\u8bdd\u9898")) {
                    textView.setText(textView.getResources().getString(R.string.f216265xu, mediaPickerTopBannerData.getMediaName()));
                    str = "topic";
                    break;
                }
                CharSequence text32 = textView.getText();
                textView.setText(((Object) text32) + mediaPickerTopBannerData.getMediaType() + "\"" + mediaPickerTopBannerData.getMediaName() + "\"");
                textView.post(new Runnable() { // from class: com.tencent.mobileqq.wink.picker.qcircle.part.p
                    @Override // java.lang.Runnable
                    public final void run() {
                        QCircleMediaPickerTopBannerPart.E9(textView);
                    }
                });
                str = "";
                break;
            case 1225917:
                if (mediaType.equals("\u97f3\u4e50")) {
                    String extendDes2 = mediaPickerTopBannerData.getExtendDes();
                    isBlank2 = StringsKt__StringsJVMKt.isBlank(extendDes2);
                    if (isBlank2) {
                        extendDes2 = "\u9009\u62e9\u5185\u5bb9\u5e94\u7528\u97f3\u4e50\u201c" + mediaPickerTopBannerData.getMediaName() + "\u201d";
                    }
                    textView.setText(extendDes2);
                    break;
                }
                CharSequence text322 = textView.getText();
                textView.setText(((Object) text322) + mediaPickerTopBannerData.getMediaType() + "\"" + mediaPickerTopBannerData.getMediaName() + "\"");
                textView.post(new Runnable() { // from class: com.tencent.mobileqq.wink.picker.qcircle.part.p
                    @Override // java.lang.Runnable
                    public final void run() {
                        QCircleMediaPickerTopBannerPart.E9(textView);
                    }
                });
                str = "";
                break;
            case 873265289:
                if (mediaType.equals("\u6fc0\u52b1\u4fc3\u6d3b")) {
                    textView.setText(mediaPickerTopBannerData.getMediaName());
                    str = WinkDaTongReportConstant.ElementParamValue.XSJ_BANNER_TYPE_PROMOTE;
                    break;
                }
                CharSequence text3222 = textView.getText();
                textView.setText(((Object) text3222) + mediaPickerTopBannerData.getMediaType() + "\"" + mediaPickerTopBannerData.getMediaName() + "\"");
                textView.post(new Runnable() { // from class: com.tencent.mobileqq.wink.picker.qcircle.part.p
                    @Override // java.lang.Runnable
                    public final void run() {
                        QCircleMediaPickerTopBannerPart.E9(textView);
                    }
                });
                str = "";
                break;
            case 1089407297:
                if (mediaType.equals("\u89c6\u9891\u8bc4\u8bba")) {
                    textView.setText(mediaPickerTopBannerData.getMediaName());
                    roundCornerImageView.setVisibility(8);
                    break;
                }
                CharSequence text32222 = textView.getText();
                textView.setText(((Object) text32222) + mediaPickerTopBannerData.getMediaType() + "\"" + mediaPickerTopBannerData.getMediaName() + "\"");
                textView.post(new Runnable() { // from class: com.tencent.mobileqq.wink.picker.qcircle.part.p
                    @Override // java.lang.Runnable
                    public final void run() {
                        QCircleMediaPickerTopBannerPart.E9(textView);
                    }
                });
                str = "";
                break;
            case 1582271431:
                if (mediaType.equals("\u7075\u611f\u5e93\u6a21\u677f")) {
                    textView.setText(textView.getResources().getString(R.string.f216235xr, mediaPickerTopBannerData.getMediaName()));
                    str = "libtemplate";
                    break;
                }
                CharSequence text322222 = textView.getText();
                textView.setText(((Object) text322222) + mediaPickerTopBannerData.getMediaType() + "\"" + mediaPickerTopBannerData.getMediaName() + "\"");
                textView.post(new Runnable() { // from class: com.tencent.mobileqq.wink.picker.qcircle.part.p
                    @Override // java.lang.Runnable
                    public final void run() {
                        QCircleMediaPickerTopBannerPart.E9(textView);
                    }
                });
                str = "";
                break;
            default:
                CharSequence text3222222 = textView.getText();
                textView.setText(((Object) text3222222) + mediaPickerTopBannerData.getMediaType() + "\"" + mediaPickerTopBannerData.getMediaName() + "\"");
                textView.post(new Runnable() { // from class: com.tencent.mobileqq.wink.picker.qcircle.part.p
                    @Override // java.lang.Runnable
                    public final void run() {
                        QCircleMediaPickerTopBannerPart.E9(textView);
                    }
                });
                str = "";
                break;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("xsj_topic_name", mediaPickerTopBannerData.getMediaName());
        hashMap.put("xsj_operation_activity_id", mediaPickerTopBannerData.getUserGuideOperationActivityId());
        hashMap.put("xsj_tianshu_task_id", WinkDatongCurrentParams.get("xsj_tianshu_task_id"));
        hashMap.put(WinkDaTongReportConstant.ElementParamKey.XSJ_CHOOSE_MEDIA_PICTURE_URL, mediaPickerTopBannerData.getMediaIconUrl());
        hashMap.put(WinkDaTongReportConstant.ElementParamKey.XSJ_CHOOSE_MEDIA_CONTENT, mediaPickerTopBannerData.getMediaName());
        hashMap.put("xsj_banner_type", str);
        C9(topBanner, WinkDaTongReportConstant.ElementId.EM_XSJ_CAMERA_TOPIC_BANNER, hashMap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void E9(TextView textView) {
        String a16 = aj.a(textView);
        if (!TextUtils.isEmpty(a16)) {
            textView.setText(a16);
        }
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    @NotNull
    public ArrayList<Class<SimpleBaseEvent>> getEventClass() {
        ArrayList<Class<SimpleBaseEvent>> arrayList = new ArrayList<>();
        arrayList.add(UpdateMediaPickerBannerTagEvent.class);
        arrayList.add(RemovePickerBannerBarEvent.class);
        return arrayList;
    }

    @Override // com.tencent.biz.richframework.part.Part
    @NotNull
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QCircleMediaPickerTopBannerPart";
    }

    @Override // com.tencent.biz.richframework.part.Part
    public boolean isPartEnable() {
        if (this.isUseAiFace && (!uq3.k.a().c("mmkv_key_open_face_detect", false) || QCircleMediaPickerTopDetectFacePart.INSTANCE.a())) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@Nullable View rootView) {
        final WinkMediaPickerMainBaseFragment winkMediaPickerMainBaseFragment;
        super.onInitView(rootView);
        Fragment hostFragment = getHostFragment();
        if (hostFragment instanceof WinkMediaPickerMainBaseFragment) {
            winkMediaPickerMainBaseFragment = (WinkMediaPickerMainBaseFragment) hostFragment;
        } else {
            winkMediaPickerMainBaseFragment = null;
        }
        if (winkMediaPickerMainBaseFragment != null) {
            com.tencent.mobileqq.wink.picker.qcircle.viewmodel.c b16 = com.tencent.mobileqq.wink.picker.qcircle.c.f324971a.b(winkMediaPickerMainBaseFragment);
            Intent intent = winkMediaPickerMainBaseFragment.getHostActivity().getIntent();
            Intrinsics.checkNotNullExpressionValue(intent, "hostActivity.intent");
            b16.U1(intent);
            LiveData<c.MediaBannerData> O1 = b16.O1();
            LifecycleOwner lifecycleOwner = getPartHost().getLifecycleOwner();
            final Function1<c.MediaBannerData, Unit> function1 = new Function1<c.MediaBannerData, Unit>() { // from class: com.tencent.mobileqq.wink.picker.qcircle.part.QCircleMediaPickerTopBannerPart$onInitView$1$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(c.MediaBannerData mediaBannerData) {
                    invoke2(mediaBannerData);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(c.MediaBannerData it) {
                    if (!(QCircleMediaPickerTopBannerPart.this.getHostFragment() instanceof QCircleTemplateLibraryMediaPickerFragment) || Intrinsics.areEqual(it.getMediaType(), "\u6a21\u677f") || Intrinsics.areEqual(it.getMediaType(), "\u7075\u611f\u5e93\u6a21\u677f")) {
                        AppBarLayout Xh = winkMediaPickerMainBaseFragment.Xh();
                        if (Xh != null) {
                            Xh.removeAllViews();
                        }
                        View topBanner = LayoutInflater.from(winkMediaPickerMainBaseFragment.getContext()).inflate(R.layout.g4c, (ViewGroup) null);
                        AppBarLayout.LayoutParams layoutParams = new AppBarLayout.LayoutParams(-1, ViewExKt.d(52));
                        layoutParams.g(1);
                        topBanner.setLayoutParams(layoutParams);
                        AppBarLayout Xh2 = winkMediaPickerMainBaseFragment.Xh();
                        if (Xh2 != null) {
                            Xh2.addView(topBanner);
                        }
                        QCircleMediaPickerTopBannerPart qCircleMediaPickerTopBannerPart = QCircleMediaPickerTopBannerPart.this;
                        Intrinsics.checkNotNullExpressionValue(topBanner, "topBanner");
                        Intrinsics.checkNotNullExpressionValue(it, "it");
                        qCircleMediaPickerTopBannerPart.D9(topBanner, it);
                    }
                }
            };
            O1.observe(lifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.wink.picker.qcircle.part.o
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    QCircleMediaPickerTopBannerPart.B9(Function1.this, obj);
                }
            });
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartCreate(@Nullable Activity activity, @Nullable Bundle savedInstanceState) {
        super.onPartCreate(activity, savedInstanceState);
        SimpleEventBus.getInstance().registerReceiver(this);
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(@Nullable Activity activity) {
        super.onPartDestroy(activity);
        SimpleEventBus.getInstance().unRegisterReceiver(this);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(@Nullable SimpleBaseEvent event) {
        AppBarLayout Xh;
        boolean z16;
        WinkMediaPickerMainBaseFragment winkMediaPickerMainBaseFragment = null;
        if (event instanceof UpdateMediaPickerBannerTagEvent) {
            UpdateMediaPickerBannerTagEvent updateMediaPickerBannerTagEvent = (UpdateMediaPickerBannerTagEvent) event;
            if (updateMediaPickerBannerTagEvent.getTopic().length() > 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                Fragment hostFragment = getHostFragment();
                if (hostFragment instanceof WinkMediaPickerMainBaseFragment) {
                    winkMediaPickerMainBaseFragment = (WinkMediaPickerMainBaseFragment) hostFragment;
                }
                if (winkMediaPickerMainBaseFragment != null) {
                    QLog.i("QCircleMediaPickerTopBannerPart", 1, "rec WinkInspirationTopicEvent, topic:" + updateMediaPickerBannerTagEvent.getTopic());
                    com.tencent.mobileqq.wink.picker.qcircle.viewmodel.c b16 = com.tencent.mobileqq.wink.picker.qcircle.c.f324971a.b(winkMediaPickerMainBaseFragment);
                    Intent intent = winkMediaPickerMainBaseFragment.getHostActivity().getIntent();
                    Intrinsics.checkNotNullExpressionValue(intent, "hostActivity.intent");
                    b16.h2(intent, updateMediaPickerBannerTagEvent.getTaskId());
                    return;
                }
                return;
            }
        }
        if (event instanceof RemovePickerBannerBarEvent) {
            Fragment hostFragment2 = getHostFragment();
            if (hostFragment2 instanceof WinkMediaPickerMainBaseFragment) {
                winkMediaPickerMainBaseFragment = (WinkMediaPickerMainBaseFragment) hostFragment2;
            }
            if (winkMediaPickerMainBaseFragment != null && (Xh = winkMediaPickerMainBaseFragment.Xh()) != null) {
                Xh.removeAllViews();
            }
        }
    }

    public /* synthetic */ QCircleMediaPickerTopBannerPart(boolean z16, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? false : z16);
    }
}
