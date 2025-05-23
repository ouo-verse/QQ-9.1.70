package com.qzone.reborn.part.publish.common.uploadAlbum;

import android.view.View;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import com.qzone.reborn.base.k;
import com.qzone.reborn.part.publish.common.inputarea.d;
import com.qzone.widget.dynamicgridview.DynamicArrayList;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.R;
import com.tencent.widget.ActionSheet;
import java.util.ArrayList;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import tl.h;
import vl.f;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\b&\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b'\u0010(J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\u0012\u0010\u0007\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016J\b\u0010\t\u001a\u00020\bH\u0016J\u001c\u0010\u000e\u001a\u00020\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016J\b\u0010\u000f\u001a\u00020\u0002H&J\b\u0010\u0010\u001a\u00020\u0002H&R#\u0010\u0017\u001a\n \u0012*\u0004\u0018\u00010\u00110\u00118DX\u0084\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R#\u0010\u001c\u001a\n \u0012*\u0004\u0018\u00010\u00180\u00188DX\u0084\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0019\u0010\u0014\u001a\u0004\b\u001a\u0010\u001bR#\u0010!\u001a\n \u0012*\u0004\u0018\u00010\u001d0\u001d8DX\u0084\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001e\u0010\u0014\u001a\u0004\b\u001f\u0010 R#\u0010&\u001a\n \u0012*\u0004\u0018\u00010\"0\"8DX\u0084\u0084\u0002\u00a2\u0006\f\n\u0004\b#\u0010\u0014\u001a\u0004\b$\u0010%\u00a8\u0006)"}, d2 = {"Lcom/qzone/reborn/part/publish/common/uploadAlbum/QZonePublishUploadAlbumPart;", "Lcom/qzone/reborn/base/k;", "", "F9", "N9", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "", "onBackEvent", "", "action", "", "args", "handleBroadcastMessage", "G9", "L9", "Lcom/qzone/reborn/part/publish/common/inputarea/d;", "kotlin.jvm.PlatformType", "d", "Lkotlin/Lazy;", "H9", "()Lcom/qzone/reborn/part/publish/common/inputarea/d;", "inputAreaVm", "Lsl/b;", "e", "I9", "()Lsl/b;", "locationVm", "Ltl/h;", "f", "J9", "()Ltl/h;", "mediaPickerVm", "Lvl/f;", h.F, "K9", "()Lvl/f;", "titleVm", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public abstract class QZonePublishUploadAlbumPart extends k {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final Lazy inputAreaVm;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final Lazy locationVm;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final Lazy mediaPickerVm;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final Lazy titleVm;

    public QZonePublishUploadAlbumPart() {
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        Lazy lazy4;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<d>() { // from class: com.qzone.reborn.part.publish.common.uploadAlbum.QZonePublishUploadAlbumPart$inputAreaVm$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final d invoke() {
                return (d) QZonePublishUploadAlbumPart.this.getViewModel(d.class);
            }
        });
        this.inputAreaVm = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<sl.b>() { // from class: com.qzone.reborn.part.publish.common.uploadAlbum.QZonePublishUploadAlbumPart$locationVm$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final sl.b invoke() {
                return (sl.b) QZonePublishUploadAlbumPart.this.getViewModel(sl.b.class);
            }
        });
        this.locationVm = lazy2;
        lazy3 = LazyKt__LazyJVMKt.lazy(new Function0<h>() { // from class: com.qzone.reborn.part.publish.common.uploadAlbum.QZonePublishUploadAlbumPart$mediaPickerVm$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final h invoke() {
                return (h) QZonePublishUploadAlbumPart.this.getViewModel(h.class);
            }
        });
        this.mediaPickerVm = lazy3;
        lazy4 = LazyKt__LazyJVMKt.lazy(new Function0<f>() { // from class: com.qzone.reborn.part.publish.common.uploadAlbum.QZonePublishUploadAlbumPart$titleVm$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final f invoke() {
                return (f) QZonePublishUploadAlbumPart.this.getViewModel(f.class);
            }
        });
        this.titleVm = lazy4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void F9() {
        K9().O1().postValue(Boolean.valueOf(J9().U1()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void M9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void N9() {
        final ActionSheet create = ActionSheet.create(getActivity());
        create.addButton(R.string.gd6, 3);
        create.addButton(R.string.cancel, 5);
        create.setOnButtonClickListener(new ActionSheet.OnButtonClickListener() { // from class: com.qzone.reborn.part.publish.common.uploadAlbum.a
            @Override // com.tencent.widget.ActionSheet.OnButtonClickListener
            public final void onClick(View view, int i3) {
                QZonePublishUploadAlbumPart.O9(QZonePublishUploadAlbumPart.this, create, view, i3);
            }
        });
        create.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void O9(QZonePublishUploadAlbumPart this$0, ActionSheet actionSheet, View view, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (i3 == 0) {
            this$0.L9();
            this$0.getActivity().finish();
        }
        actionSheet.superDismiss();
    }

    public abstract void G9();

    /* JADX INFO: Access modifiers changed from: protected */
    public final d H9() {
        return (d) this.inputAreaVm.getValue();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final sl.b I9() {
        return (sl.b) this.locationVm.getValue();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final h J9() {
        return (h) this.mediaPickerVm.getValue();
    }

    protected final f K9() {
        return (f) this.titleVm.getValue();
    }

    public abstract void L9();

    @Override // com.tencent.biz.richframework.part.Part
    public void handleBroadcastMessage(String action, Object args) {
        if (Intrinsics.areEqual(action, "publish_btn_clk")) {
            G9();
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public boolean onBackEvent() {
        broadcastMessage("close_input_panel", null);
        if (Intrinsics.areEqual(K9().O1().getValue(), Boolean.TRUE)) {
            N9();
            return true;
        }
        L9();
        return super.onBackEvent();
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View rootView) {
        super.onInitView(rootView);
        DynamicArrayList<String> value = J9().P1().getValue();
        if (value != null) {
            LiveData<ArrayList<String>> liveData = value.getLiveData();
            LifecycleOwner lifecycleOwner = getPartHost().getLifecycleOwner();
            final Function1<ArrayList<String>, Unit> function1 = new Function1<ArrayList<String>, Unit>() { // from class: com.qzone.reborn.part.publish.common.uploadAlbum.QZonePublishUploadAlbumPart$onInitView$1$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(ArrayList<String> arrayList) {
                    invoke2(arrayList);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(ArrayList<String> arrayList) {
                    QZonePublishUploadAlbumPart.this.F9();
                }
            };
            liveData.observe(lifecycleOwner, new Observer() { // from class: com.qzone.reborn.part.publish.common.uploadAlbum.b
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    QZonePublishUploadAlbumPart.M9(Function1.this, obj);
                }
            });
        }
    }
}
