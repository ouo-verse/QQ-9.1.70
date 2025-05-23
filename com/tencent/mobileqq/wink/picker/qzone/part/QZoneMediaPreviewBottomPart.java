package com.tencent.mobileqq.wink.picker.qzone.part;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.TouchDelegate;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import com.tencent.aelight.camera.entry.api.IAECameraLauncher;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.widget.tip.QUIDefaultBubbleTip;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import com.tencent.mobileqq.wink.context.WinkContext;
import com.tencent.mobileqq.wink.picker.MediaFilteringCode;
import com.tencent.mobileqq.wink.picker.MediaPickerOutput;
import com.tencent.mobileqq.wink.picker.MediaPickerScene;
import com.tencent.mobileqq.wink.picker.TabType;
import com.tencent.mobileqq.wink.picker.core.WinkMediaPickerMainBaseFragment;
import com.tencent.mobileqq.wink.picker.core.fragment.WinkMediaPickerChildFragment;
import com.tencent.mobileqq.wink.picker.core.viewmodel.WinkMediaPreviewViewModel;
import com.tencent.mobileqq.wink.picker.core.viewmodel.WinkSelectedMediaViewModel;
import com.tencent.mobileqq.wink.picker.interceptor.WinkMediaPickerNextStepHelper;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qzonehub.api.IQZoneMMKVApi;
import cooperation.peak.PeakConstants;
import cooperation.qzone.QzoneIPCModule;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 <2\u00020\u0001:\u0001=B\u0019\u0012\u0006\u0010!\u001a\u00020\u001e\u0012\b\b\u0002\u0010$\u001a\u00020\u0004\u00a2\u0006\u0004\b:\u0010;J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u001a\u0010\f\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0002J\u0018\u0010\u0010\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J\b\u0010\u0011\u001a\u00020\u0006H\u0002J\b\u0010\u0013\u001a\u00020\u0012H\u0016J\u0010\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u0002H\u0016J\"\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u0017\u001a\u00020\u000e2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0016J\u0012\u0010\u001d\u001a\u00020\u00062\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bH\u0016R\u0014\u0010!\u001a\u00020\u001e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u0014\u0010$\u001a\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u0018\u0010(\u001a\u0004\u0018\u00010%8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b&\u0010'R\u0018\u0010,\u001a\u0004\u0018\u00010)8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b*\u0010+R\u0018\u00100\u001a\u0004\u0018\u00010-8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b.\u0010/R\u001b\u00105\u001a\u00020\u00048FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b1\u00102\u001a\u0004\b3\u00104R\u0018\u00109\u001a\u0004\u0018\u0001068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b7\u00108\u00a8\u0006>"}, d2 = {"Lcom/tencent/mobileqq/wink/picker/qzone/part/QZoneMediaPreviewBottomPart;", "Lcom/tencent/biz/richframework/part/Part;", "Landroid/view/View;", "v", "", "checkAnySelection", "", "K9", "Landroidx/fragment/app/Fragment;", "context", "Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;", "localMediaInfo", "L9", "view", "", "expandTouchWidth", "Q9", "H9", "", "getLogTag", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "requestCode", QzoneIPCModule.RESULT_CODE, "Landroid/content/Intent;", "data", "onActivityResult", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "onPartResume", "Lcom/tencent/mobileqq/wink/picker/interceptor/WinkMediaPickerNextStepHelper;", "d", "Lcom/tencent/mobileqq/wink/picker/interceptor/WinkMediaPickerNextStepHelper;", "nextStepHelper", "e", "Z", "enableEdit", "Landroid/widget/TextView;", "f", "Landroid/widget/TextView;", "previewEdit", "Landroid/widget/Button;", tl.h.F, "Landroid/widget/Button;", "nextStepBtn", "Lcom/tencent/mobileqq/widget/tip/a;", "i", "Lcom/tencent/mobileqq/widget/tip/a;", "showGuidePopup", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lkotlin/Lazy;", "J9", "()Z", "isCameraResReady", "Lcom/tencent/mobileqq/wink/picker/core/viewmodel/WinkMediaPreviewViewModel;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/wink/picker/core/viewmodel/WinkMediaPreviewViewModel;", "mediaPreviewViewModel", "<init>", "(Lcom/tencent/mobileqq/wink/picker/interceptor/WinkMediaPickerNextStepHelper;Z)V", "D", "a", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class QZoneMediaPreviewBottomPart extends Part {

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private WinkMediaPreviewViewModel mediaPreviewViewModel;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final WinkMediaPickerNextStepHelper nextStepHelper;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final boolean enableEdit;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private TextView previewEdit;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Button nextStepBtn;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private com.tencent.mobileqq.widget.tip.a showGuidePopup;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy isCameraResReady;

    public QZoneMediaPreviewBottomPart(@NotNull WinkMediaPickerNextStepHelper nextStepHelper, boolean z16) {
        Lazy lazy;
        Intrinsics.checkNotNullParameter(nextStepHelper, "nextStepHelper");
        this.nextStepHelper = nextStepHelper;
        this.enableEdit = z16;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<Boolean>() { // from class: com.tencent.mobileqq.wink.picker.qzone.part.QZoneMediaPreviewBottomPart$isCameraResReady$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Boolean invoke() {
                return Boolean.valueOf(((IAECameraLauncher) QRoute.api(IAECameraLauncher.class)).isCameraResReady());
            }
        });
        this.isCameraResReady = lazy;
    }

    private final void H9() {
        LocalMediaInfo localMediaInfo;
        boolean z16;
        WinkMediaPreviewViewModel winkMediaPreviewViewModel = this.mediaPreviewViewModel;
        if (winkMediaPreviewViewModel != null) {
            localMediaInfo = winkMediaPreviewViewModel.getCurPreviewMedia();
        } else {
            localMediaInfo = null;
        }
        if (this.enableEdit) {
            boolean z17 = true;
            if (localMediaInfo != null && e93.i.G(localMediaInfo)) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                int intValue = ((IQZoneMMKVApi) QRoute.api(IQZoneMMKVApi.class)).getIntValue("KEY_SHOW_GUIDE_POPUP_TIMES", 0);
                long longValue = ((IQZoneMMKVApi) QRoute.api(IQZoneMMKVApi.class)).getLongValue("KEY_SHOW_GUIDE_POPUP_TIMESTAMP", 0L);
                long j3 = 604800000 + longValue;
                w53.b.a("QZoneMediaPreviewBottomPart", "lastShowTime: " + longValue + ", nextApplyTime: " + j3 + ", showTimes: " + intValue);
                if (intValue < 3 && (longValue <= 0 || j3 <= System.currentTimeMillis())) {
                    com.tencent.mobileqq.widget.tip.a r16 = QUIDefaultBubbleTip.r(getContext());
                    this.showGuidePopup = r16;
                    if (r16 != null) {
                        r16.n0(12);
                    }
                    com.tencent.mobileqq.widget.tip.a aVar = this.showGuidePopup;
                    Intrinsics.checkNotNull(aVar);
                    aVar.o0("AI\u6d88\u9664\u9080\u4f60\u4f53\u9a8c\uff5e").S(this.previewEdit).k0(0).R(0).m0(4);
                    TextView textView = this.previewEdit;
                    if (textView != null) {
                        textView.post(new Runnable() { // from class: com.tencent.mobileqq.wink.picker.qzone.part.b
                            @Override // java.lang.Runnable
                            public final void run() {
                                QZoneMediaPreviewBottomPart.I9(QZoneMediaPreviewBottomPart.this);
                            }
                        });
                    }
                    ((IQZoneMMKVApi) QRoute.api(IQZoneMMKVApi.class)).saveInt("KEY_SHOW_GUIDE_POPUP_TIMES", intValue + 1);
                    ((IQZoneMMKVApi) QRoute.api(IQZoneMMKVApi.class)).saveLong("KEY_SHOW_GUIDE_POPUP_TIMESTAMP", System.currentTimeMillis());
                } else {
                    z17 = false;
                }
                ((IQZoneMMKVApi) QRoute.api(IQZoneMMKVApi.class)).saveBoolean(QQWinkConstants.KEY_IS_SHOW_ELIMINATE_GUIDE_POPUP_PHOTO_PREVIEW, z17);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void I9(QZoneMediaPreviewBottomPart this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        com.tencent.mobileqq.widget.tip.a aVar = this$0.showGuidePopup;
        if (aVar != null) {
            aVar.s0();
        }
    }

    private final void K9(View v3, boolean checkAnySelection) {
        WinkMediaPickerMainBaseFragment<?> b16;
        WinkMediaPreviewViewModel winkMediaPreviewViewModel = this.mediaPreviewViewModel;
        boolean z16 = false;
        if (winkMediaPreviewViewModel != null && !winkMediaPreviewViewModel.O1(v3, checkAnySelection)) {
            z16 = true;
        }
        if (z16 && (b16 = com.tencent.mobileqq.wink.picker.core.ktx.a.b(this)) != null) {
            WinkMediaPickerMainBaseFragment.ei(b16, true, null, 2, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void L9(Fragment context, LocalMediaInfo localMediaInfo) {
        ArrayList<? extends Parcelable> arrayListOf;
        boolean z16;
        w53.b.f("QZoneMediaPreviewBottomPart", "previewEdit onEditClick, localMediaInfo:" + localMediaInfo);
        if (localMediaInfo == null) {
            return;
        }
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add(localMediaInfo.path);
        Bundle bundle = new Bundle();
        String str = localMediaInfo.missionID;
        if (str != null) {
            if (str.length() > 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                bundle.putString(QQWinkConstants.MISSION_ID, str);
                bundle.putInt(QQWinkConstants.EDITOR_ENTRANCE, 2);
                bundle.putString(QQWinkConstants.ENTRY_BUSINESS_NAME, "QZONE");
                bundle.putString(PeakConstants.QCIRCLE_CLIENT_TRACEID, WinkContext.INSTANCE.d().getTraceId());
                bundle.putBoolean(QQWinkConstants.EDITOR_ENABLE_SWITCH_EDIT_MODE, false);
                bundle.putBoolean(QQWinkConstants.QZONE_EDIT, true);
                com.tencent.mobileqq.wink.f.w(context, bundle);
            }
        }
        bundle.putString(QQWinkConstants.MISSION_ID, WinkContext.INSTANCE.f("QZONE"));
        bundle.putInt(QQWinkConstants.EDITOR_ENTRANCE, 0);
        bundle.putStringArrayList(QQWinkConstants.EDITOR_MEDIA_PATH_ARRAY_LIST, arrayList);
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(localMediaInfo);
        bundle.putParcelableArrayList(QQWinkConstants.INPUT_MEDIA, arrayListOf);
        bundle.putString(QQWinkConstants.ENTRY_BUSINESS_NAME, "QZONE");
        bundle.putString(PeakConstants.QCIRCLE_CLIENT_TRACEID, WinkContext.INSTANCE.d().getTraceId());
        bundle.putBoolean(QQWinkConstants.EDITOR_ENABLE_SWITCH_EDIT_MODE, false);
        bundle.putBoolean(QQWinkConstants.QZONE_EDIT, true);
        com.tencent.mobileqq.wink.f.w(context, bundle);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void M9(final QZoneMediaPreviewBottomPart this$0, View view) {
        final LocalMediaInfo curPreviewMedia;
        boolean z16;
        List listOf;
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        w53.b.f("QZoneMediaPreviewBottomPart", "previewEdit click");
        WinkMediaPreviewViewModel winkMediaPreviewViewModel = this$0.mediaPreviewViewModel;
        if (winkMediaPreviewViewModel != null && (curPreviewMedia = winkMediaPreviewViewModel.getCurPreviewMedia()) != null) {
            String str = curPreviewMedia.missionID;
            if (str != null && str.length() != 0) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (z16) {
                listOf = CollectionsKt__CollectionsJVMKt.listOf(curPreviewMedia);
                WinkMediaPickerNextStepHelper winkMediaPickerNextStepHelper = this$0.nextStepHelper;
                Activity activity = this$0.getActivity();
                Intrinsics.checkNotNullExpressionValue(activity, "activity");
                WinkMediaPickerNextStepHelper.i(winkMediaPickerNextStepHelper, activity, TabType.ALL_MEDIA, listOf, false, MediaPickerScene.STANDARD, null, new Function1<MediaPickerOutput, Unit>() { // from class: com.tencent.mobileqq.wink.picker.qzone.part.QZoneMediaPreviewBottomPart$onInitView$1$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(MediaPickerOutput mediaPickerOutput) {
                        invoke2(mediaPickerOutput);
                        return Unit.INSTANCE;
                    }

                    /* JADX WARN: Code restructure failed: missing block: B:4:0x0015, code lost:
                    
                        if ((!r0.isEmpty()) == true) goto L8;
                     */
                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                    */
                    public final void invoke2(@NotNull MediaPickerOutput it) {
                        boolean z17;
                        LocalMediaInfo localMediaInfo;
                        Object orNull;
                        Intrinsics.checkNotNullParameter(it, "it");
                        if (it.e() != null) {
                            z17 = true;
                        }
                        z17 = false;
                        if (z17) {
                            QZoneMediaPreviewBottomPart qZoneMediaPreviewBottomPart = QZoneMediaPreviewBottomPart.this;
                            Fragment hostFragment = qZoneMediaPreviewBottomPart.getHostFragment();
                            Intrinsics.checkNotNullExpressionValue(hostFragment, "hostFragment");
                            List<LocalMediaInfo> e16 = it.e();
                            if (e16 != null) {
                                orNull = CollectionsKt___CollectionsKt.getOrNull(e16, 0);
                                localMediaInfo = (LocalMediaInfo) orNull;
                            } else {
                                localMediaInfo = null;
                            }
                            qZoneMediaPreviewBottomPart.L9(hostFragment, localMediaInfo);
                            return;
                        }
                        QZoneMediaPreviewBottomPart qZoneMediaPreviewBottomPart2 = QZoneMediaPreviewBottomPart.this;
                        Fragment hostFragment2 = qZoneMediaPreviewBottomPart2.getHostFragment();
                        Intrinsics.checkNotNullExpressionValue(hostFragment2, "hostFragment");
                        qZoneMediaPreviewBottomPart2.L9(hostFragment2, curPreviewMedia);
                    }
                }, 32, null);
            } else {
                Fragment hostFragment = this$0.getHostFragment();
                Intrinsics.checkNotNullExpressionValue(hostFragment, "hostFragment");
                this$0.L9(hostFragment, curPreviewMedia);
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void N9(QZoneMediaPreviewBottomPart this$0, View it) {
        EventCollector.getInstance().onViewClickedBefore(it);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(it, "it");
        this$0.K9(it, true);
        EventCollector.getInstance().onViewClicked(it);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void O9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void P9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void Q9(final View view, final int expandTouchWidth) {
        Object parent = view.getParent();
        Intrinsics.checkNotNull(parent, "null cannot be cast to non-null type android.view.View");
        final View view2 = (View) parent;
        view2.post(new Runnable() { // from class: com.tencent.mobileqq.wink.picker.qzone.part.g
            @Override // java.lang.Runnable
            public final void run() {
                QZoneMediaPreviewBottomPart.R9(view, expandTouchWidth, view2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void R9(View view, int i3, View parentView) {
        Intrinsics.checkNotNullParameter(view, "$view");
        Intrinsics.checkNotNullParameter(parentView, "$parentView");
        Rect rect = new Rect();
        view.getHitRect(rect);
        rect.top -= i3;
        rect.bottom += i3;
        rect.left -= i3;
        rect.right += i3 * 2;
        parentView.setTouchDelegate(new TouchDelegate(rect, view));
    }

    public final boolean J9() {
        return ((Boolean) this.isCameraResReady.getValue()).booleanValue();
    }

    @Override // com.tencent.biz.richframework.part.Part
    @NotNull
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QZoneMediaPreviewBottomPart";
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        String str;
        Bundle extras;
        Intent intent;
        WinkMediaPreviewViewModel winkMediaPreviewViewModel;
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 700 && resultCode == -1 && data != null) {
            ArrayList<String> stringArrayListExtra = data.getStringArrayListExtra("PhotoConst.PHOTO_PATHS");
            Serializable serializableExtra = data.getSerializableExtra("PeakConstants.selectedMediaInfoHashMap");
            Intrinsics.checkNotNull(serializableExtra, "null cannot be cast to non-null type java.util.HashMap<kotlin.String, com.tencent.mobileqq.activity.photo.LocalMediaInfo>{ kotlin.collections.TypeAliasesKt.HashMap<kotlin.String, com.tencent.mobileqq.activity.photo.LocalMediaInfo> }");
            HashMap hashMap = (HashMap) serializableExtra;
            String stringExtra = data.getStringExtra(QQWinkConstants.MISSION_ID);
            if (stringArrayListExtra != null) {
                str = stringArrayListExtra.get(0);
            } else {
                str = null;
            }
            LocalMediaInfo localMediaInfo = (LocalMediaInfo) hashMap.get(str);
            if (localMediaInfo != null) {
                localMediaInfo.missionID = stringExtra;
            }
            if (localMediaInfo != null && (winkMediaPreviewViewModel = this.mediaPreviewViewModel) != null) {
                winkMediaPreviewViewModel.b2(localMediaInfo);
            }
            WinkMediaPickerMainBaseFragment<?> b16 = com.tencent.mobileqq.wink.picker.core.ktx.a.b(this);
            if (b16 != null && (extras = data.getExtras()) != null && (intent = b16.getHostActivity().getIntent()) != null) {
                intent.putExtras(extras);
            }
            w53.b.f("QZoneMediaPreviewBottomPart", String.valueOf(localMediaInfo));
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@NotNull View rootView) {
        TextView textView;
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        TextView textView2 = (TextView) rootView.findViewById(R.id.f27180fj);
        this.previewEdit = textView2;
        if (!this.enableEdit && textView2 != null) {
            textView2.setVisibility(8);
        }
        this.nextStepBtn = (Button) rootView.findViewById(R.id.yze);
        TextView textView3 = this.previewEdit;
        if (textView3 != null) {
            textView3.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.wink.picker.qzone.part.c
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    QZoneMediaPreviewBottomPart.M9(QZoneMediaPreviewBottomPart.this, view);
                }
            });
        }
        TextView textView4 = this.previewEdit;
        if (textView4 != null) {
            Intrinsics.checkNotNull(textView4);
            Q9(textView4, 10);
        }
        Button button = this.nextStepBtn;
        if (button != null) {
            button.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.wink.picker.qzone.part.d
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    QZoneMediaPreviewBottomPart.N9(QZoneMediaPreviewBottomPart.this, view);
                }
            });
        }
        WinkMediaPickerChildFragment a16 = com.tencent.mobileqq.wink.picker.core.ktx.a.a(this);
        if (a16 != null) {
            final WinkMediaPreviewViewModel f16 = com.tencent.mobileqq.wink.picker.core.viewmodel.q.f(a16);
            if (f16 != null) {
                LiveData<WinkMediaPreviewViewModel.SeqNumberTextAttrs> X1 = f16.X1();
                LifecycleOwner lifecycleOwner = getPartHost().getLifecycleOwner();
                final Function1<WinkMediaPreviewViewModel.SeqNumberTextAttrs, Unit> function1 = new Function1<WinkMediaPreviewViewModel.SeqNumberTextAttrs, Unit>() { // from class: com.tencent.mobileqq.wink.picker.qzone.part.QZoneMediaPreviewBottomPart$onInitView$3$1$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(WinkMediaPreviewViewModel.SeqNumberTextAttrs seqNumberTextAttrs) {
                        invoke2(seqNumberTextAttrs);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(WinkMediaPreviewViewModel.SeqNumberTextAttrs seqNumberTextAttrs) {
                        Button button2;
                        List<LocalMediaInfo> selectedMedia;
                        Button button3;
                        List<LocalMediaInfo> selectedMedia2;
                        WinkSelectedMediaViewModel selectedMediaViewModel = WinkMediaPreviewViewModel.this.getSelectedMediaViewModel();
                        int i3 = 0;
                        if (((selectedMediaViewModel == null || (selectedMedia2 = selectedMediaViewModel.getSelectedMedia()) == null) ? 0 : selectedMedia2.size()) == 0) {
                            button3 = this.nextStepBtn;
                            if (button3 == null) {
                                return;
                            }
                            button3.setText("\u4e0b\u4e00\u6b65");
                            return;
                        }
                        button2 = this.nextStepBtn;
                        if (button2 == null) {
                            return;
                        }
                        WinkSelectedMediaViewModel selectedMediaViewModel2 = WinkMediaPreviewViewModel.this.getSelectedMediaViewModel();
                        if (selectedMediaViewModel2 != null && (selectedMedia = selectedMediaViewModel2.getSelectedMedia()) != null) {
                            i3 = selectedMedia.size();
                        }
                        button2.setText("\u4e0b\u4e00\u6b65(" + i3 + ")");
                    }
                };
                X1.observe(lifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.wink.picker.qzone.part.e
                    @Override // androidx.lifecycle.Observer
                    public final void onChanged(Object obj) {
                        QZoneMediaPreviewBottomPart.O9(Function1.this, obj);
                    }
                });
                LiveData<LocalMediaInfo> S1 = f16.S1();
                LifecycleOwner lifecycleOwner2 = getPartHost().getLifecycleOwner();
                final Function1<LocalMediaInfo, Unit> function12 = new Function1<LocalMediaInfo, Unit>() { // from class: com.tencent.mobileqq.wink.picker.qzone.part.QZoneMediaPreviewBottomPart$onInitView$3$1$2
                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(LocalMediaInfo localMediaInfo) {
                        invoke2(localMediaInfo);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(LocalMediaInfo it) {
                        TextView textView5;
                        TextView textView6;
                        TextView textView7;
                        TextView textView8;
                        Intrinsics.checkNotNullExpressionValue(it, "it");
                        if (e93.i.F(it) || d93.b.f393235a.a(it, com.tencent.mobileqq.wink.picker.qcircle.c.f324971a.c()) != MediaFilteringCode.MEDIA_VALID) {
                            textView5 = QZoneMediaPreviewBottomPart.this.previewEdit;
                            if (textView5 != null) {
                                textView5.setClickable(false);
                            }
                            textView6 = QZoneMediaPreviewBottomPart.this.previewEdit;
                            if (textView6 == null) {
                                return;
                            }
                            textView6.setAlpha(0.4f);
                            return;
                        }
                        textView7 = QZoneMediaPreviewBottomPart.this.previewEdit;
                        if (textView7 != null) {
                            textView7.setClickable(true);
                        }
                        textView8 = QZoneMediaPreviewBottomPart.this.previewEdit;
                        if (textView8 == null) {
                            return;
                        }
                        textView8.setAlpha(1.0f);
                    }
                };
                S1.observe(lifecycleOwner2, new Observer() { // from class: com.tencent.mobileqq.wink.picker.qzone.part.f
                    @Override // androidx.lifecycle.Observer
                    public final void onChanged(Object obj) {
                        QZoneMediaPreviewBottomPart.P9(Function1.this, obj);
                    }
                });
            } else {
                f16 = null;
            }
            this.mediaPreviewViewModel = f16;
            if (!J9() && (textView = this.previewEdit) != null) {
                textView.setVisibility(8);
            }
        }
        TextView textView5 = this.previewEdit;
        if (textView5 != null) {
            VideoReport.setElementId(textView5, WinkDaTongReportConstant.ElementId.EM_BAS_EDIT);
            VideoReport.setElementClickPolicy(textView5, ClickPolicy.REPORT_ALL);
            VideoReport.setElementExposePolicy(textView5, ExposurePolicy.REPORT_ALL);
        }
        Button button2 = this.nextStepBtn;
        if (button2 != null) {
            VideoReport.setElementId(button2, WinkDaTongReportConstant.ElementId.EM_XSJ_NEXT_BUTTON);
            VideoReport.setElementClickPolicy(button2, ClickPolicy.REPORT_ALL);
            VideoReport.setElementExposePolicy(button2, ExposurePolicy.REPORT_ALL);
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartResume(@Nullable Activity activity) {
        super.onPartResume(activity);
        H9();
    }
}
