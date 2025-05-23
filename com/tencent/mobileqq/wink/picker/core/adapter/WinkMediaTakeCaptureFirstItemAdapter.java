package com.tencent.mobileqq.wink.picker.core.adapter;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.aelight.camera.constants.AECameraConstants;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.wink.picker.core.adapter.WinkMediaTakeCaptureFirstItemAdapter;
import com.tencent.mobileqq.wink.picker.core.part.WinkMediaListPart;
import com.tencent.mobileqq.winkreport.datong.WinkDTParamBuilder;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0014\u001a\u00020\u0011\u0012\u0006\u0010\u0017\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0018\u0010\r\u001a\u00020\f2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u0002H\u0016J\u0018\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u0002H\u0016R\u0014\u0010\u0014\u001a\u00020\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0017\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/mobileqq/wink/picker/core/adapter/WinkMediaTakeCaptureFirstItemAdapter;", "Lcom/tencent/mobileqq/wink/picker/core/adapter/c;", "", "requestCode", "", "l0", "", "eventId", "k0", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "viewType", "Lcom/tencent/mobileqq/wink/picker/core/b;", "n0", "holder", com.tencent.luggage.wxa.c8.c.G, "m0", "Lcom/tencent/mobileqq/wink/picker/core/part/WinkMediaListPart;", "D", "Lcom/tencent/mobileqq/wink/picker/core/part/WinkMediaListPart;", "mediaListPart", "E", "I", "mediaViewHolderSize", "<init>", "(Lcom/tencent/mobileqq/wink/picker/core/part/WinkMediaListPart;I)V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class WinkMediaTakeCaptureFirstItemAdapter extends c {

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final WinkMediaListPart mediaListPart;

    /* renamed from: E, reason: from kotlin metadata */
    private final int mediaViewHolderSize;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001JV\u0010\f\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022!\u0010\n\u001a\u001d\u0012\u0013\u0012\u00110\u0005\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t0\u00042!\u0010\u000b\u001a\u001d\u0012\u0013\u0012\u00110\u0005\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t0\u0004H\u0016\u00a8\u0006\r"}, d2 = {"com/tencent/mobileqq/wink/picker/core/adapter/WinkMediaTakeCaptureFirstItemAdapter$a", "Lcom/tencent/mobileqq/wink/picker/core/b;", "Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;", "localMedia", "Lkotlin/Function1;", "Landroid/view/View;", "Lkotlin/ParameterName;", "name", "v", "", "onItemClick", "onItemSelect", "l", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class a extends com.tencent.mobileqq.wink.picker.core.b {
        final /* synthetic */ View E;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(View itemView) {
            super(itemView);
            this.E = itemView;
            Intrinsics.checkNotNullExpressionValue(itemView, "itemView");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void n(Function1 onItemClick, View it) {
            EventCollector.getInstance().onViewClickedBefore(it);
            Intrinsics.checkNotNullParameter(onItemClick, "$onItemClick");
            Intrinsics.checkNotNullExpressionValue(it, "it");
            onItemClick.invoke(it);
            EventCollector.getInstance().onViewClicked(it);
        }

        @Override // com.tencent.mobileqq.wink.picker.core.b
        public void l(@NotNull LocalMediaInfo localMedia, @NotNull final Function1<? super View, Unit> onItemClick, @NotNull Function1<? super View, Unit> onItemSelect) {
            Intrinsics.checkNotNullParameter(localMedia, "localMedia");
            Intrinsics.checkNotNullParameter(onItemClick, "onItemClick");
            Intrinsics.checkNotNullParameter(onItemSelect, "onItemSelect");
            this.E.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.wink.picker.core.adapter.g
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    WinkMediaTakeCaptureFirstItemAdapter.a.n(Function1.this, view);
                }
            });
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WinkMediaTakeCaptureFirstItemAdapter(@NotNull WinkMediaListPart mediaListPart, int i3) {
        super(mediaListPart, i3);
        Intrinsics.checkNotNullParameter(mediaListPart, "mediaListPart");
        this.mediaListPart = mediaListPart;
        this.mediaViewHolderSize = i3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void k0(String eventId) {
        Map<String, Object> reportMap = WinkDTParamBuilder.buildElementParams();
        Intrinsics.checkNotNullExpressionValue(reportMap, "reportMap");
        reportMap.put("xsj_custom_pgid", "pg_xsj_choose_media_new_page");
        reportMap.put("xsj_eid", "em_xsj_shoot_button");
        reportMap.put("dt_eid", "em_xsj_shoot_button");
        reportMap.put("dt_pgid", "pg_xsj_choose_media_new_page");
        VideoReport.reportEvent(eventId, reportMap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void l0(int requestCode) {
        Bundle bundle;
        Intent intent;
        com.tencent.mobileqq.wink.picker.core.c cVar = com.tencent.mobileqq.wink.picker.core.c.f324480a;
        if (cVar.e().c(requestCode)) {
            return;
        }
        Intent intent2 = new Intent();
        Bundle bundle2 = new Bundle();
        bundle2.putString(AECameraConstants.FRAGMENT_RETURN_ACTION, AECameraConstants.FRAGMENT_ACTION_JUMP_TO_CAMERA);
        bundle2.putString(AECameraConstants.FRAGMENT_RETURN_SECOND_ACTION, cVar.b().getFrom());
        Activity activity = this.mediaListPart.getActivity();
        Bundle bundle3 = null;
        if (activity != null && (intent = activity.getIntent()) != null) {
            bundle = intent.getBundleExtra(AECameraConstants.FRAGMENT_EXTRA_DATA);
        } else {
            bundle = null;
        }
        if (bundle != null) {
            Intent intent3 = this.mediaListPart.getActivity().getIntent();
            if (intent3 != null) {
                bundle3 = intent3.getBundleExtra(AECameraConstants.FRAGMENT_EXTRA_DATA);
            }
            bundle2.putBundle(AECameraConstants.FRAGMENT_EXTRA_DATA, bundle3);
        }
        intent2.putExtras(bundle2);
        Activity activity2 = this.mediaListPart.getActivity();
        if (activity2 != null) {
            activity2.setResult(requestCode, intent2);
        }
        Activity activity3 = this.mediaListPart.getActivity();
        if (activity3 != null) {
            activity3.finish();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: m0, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(@NotNull com.tencent.mobileqq.wink.picker.core.b holder, int pos) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        holder.l(new LocalMediaInfo(), new Function1<View, Unit>() { // from class: com.tencent.mobileqq.wink.picker.core.adapter.WinkMediaTakeCaptureFirstItemAdapter$onBindViewHolder$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(View view) {
                invoke2(view);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull View it) {
                Intrinsics.checkNotNullParameter(it, "it");
                WinkMediaTakeCaptureFirstItemAdapter.this.k0("dt_clck");
                WinkMediaTakeCaptureFirstItemAdapter.this.l0(com.tencent.mobileqq.wink.picker.core.c.f324480a.b().getBusinessRequestCode());
            }
        }, new Function1<View, Unit>() { // from class: com.tencent.mobileqq.wink.picker.core.adapter.WinkMediaTakeCaptureFirstItemAdapter$onBindViewHolder$2
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull View it) {
                Intrinsics.checkNotNullParameter(it, "it");
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(View view) {
                invoke2(view);
                return Unit.INSTANCE;
            }
        });
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    /* renamed from: n0, reason: merged with bridge method [inline-methods] */
    public com.tencent.mobileqq.wink.picker.core.b onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.i6m, parent, false);
        int i3 = this.mediaViewHolderSize;
        inflate.setLayoutParams(new ViewGroup.MarginLayoutParams(i3, i3));
        k0("dt_imp");
        return new a(inflate);
    }
}
