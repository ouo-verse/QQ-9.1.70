package com.tencent.mobileqq.wink.preview.part.base;

import android.view.View;
import android.widget.CompoundButton;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.qui.quicheckbox.QUICheckBox;
import com.tencent.biz.richframework.part.BasePartFragment;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.wink.preview.viewmodel.WinkBasePreviewShareViewModel;
import com.tencent.mobileqq.wink.utils.ar;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b&\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0005H&J\u0012\u0010\t\u001a\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016R\u0016\u0010\r\u001a\u00020\n8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\f\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/wink/preview/part/base/WinkBaseSharePreviewSyncQZonePart;", "Lp53/a;", "", "initView", "E9", "Lcom/tencent/mobileqq/wink/preview/viewmodel/WinkBasePreviewShareViewModel;", "D9", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "Lcom/tencent/biz/qui/quicheckbox/QUICheckBox;", "d", "Lcom/tencent/biz/qui/quicheckbox/QUICheckBox;", "syncQzone", "<init>", "()V", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public abstract class WinkBaseSharePreviewSyncQZonePart extends p53.a {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private QUICheckBox syncQzone;

    private final void E9() {
        LiveData<Result<WinkBasePreviewShareViewModel.PreviewData>> U1 = D9().U1();
        BasePartFragment hostFragment = getHostFragment();
        final Function1<Result<? extends WinkBasePreviewShareViewModel.PreviewData>, Unit> function1 = new Function1<Result<? extends WinkBasePreviewShareViewModel.PreviewData>, Unit>() { // from class: com.tencent.mobileqq.wink.preview.part.base.WinkBaseSharePreviewSyncQZonePart$initObserve$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Result<? extends WinkBasePreviewShareViewModel.PreviewData> result) {
                invoke2(result);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Result<? extends WinkBasePreviewShareViewModel.PreviewData> it) {
                QUICheckBox qUICheckBox;
                qUICheckBox = WinkBaseSharePreviewSyncQZonePart.this.syncQzone;
                if (qUICheckBox == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("syncQzone");
                    qUICheckBox = null;
                }
                Intrinsics.checkNotNullExpressionValue(it, "it");
                qUICheckBox.setEnabled(Result.m483isSuccessimpl(it.getValue()));
            }
        };
        U1.observe(hostFragment, new Observer() { // from class: com.tencent.mobileqq.wink.preview.part.base.n
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                WinkBaseSharePreviewSyncQZonePart.F9(Function1.this, obj);
            }
        });
        LiveData<t73.a<WinkBasePreviewShareViewModel.c>> W1 = D9().W1();
        BasePartFragment hostFragment2 = getHostFragment();
        final Function1<t73.a<? extends WinkBasePreviewShareViewModel.c>, Unit> function12 = new Function1<t73.a<? extends WinkBasePreviewShareViewModel.c>, Unit>() { // from class: com.tencent.mobileqq.wink.preview.part.base.WinkBaseSharePreviewSyncQZonePart$initObserve$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(t73.a<? extends WinkBasePreviewShareViewModel.c> aVar) {
                invoke2(aVar);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(t73.a<? extends WinkBasePreviewShareViewModel.c> aVar) {
                QUICheckBox qUICheckBox;
                qUICheckBox = WinkBaseSharePreviewSyncQZonePart.this.syncQzone;
                if (qUICheckBox == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("syncQzone");
                    qUICheckBox = null;
                }
                qUICheckBox.setEnabled(Intrinsics.areEqual(aVar.b(), WinkBasePreviewShareViewModel.c.d.f325447a));
            }
        };
        W1.observe(hostFragment2, new Observer() { // from class: com.tencent.mobileqq.wink.preview.part.base.o
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                WinkBaseSharePreviewSyncQZonePart.G9(Function1.this, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void F9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void G9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void H9(WinkBaseSharePreviewSyncQZonePart this$0, CompoundButton compoundButton, boolean z16) {
        EventCollector.getInstance().onCompoundButtonCheckedBefore(compoundButton, z16);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ar.f326685a.m("ae_key_editor_wink_low_level_publish_share_sync", z16);
        this$0.D9().b2().postValue(Boolean.valueOf(z16));
        EventCollector.getInstance().onCompoundButtonChecked(compoundButton, z16);
    }

    private final void initView() {
        View partRootView = getPartRootView();
        Intrinsics.checkNotNull(partRootView);
        View findViewById = partRootView.findViewById(R.id.f9142555);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView!!.findViewById(R.id.sync_qzone)");
        QUICheckBox qUICheckBox = (QUICheckBox) findViewById;
        this.syncQzone = qUICheckBox;
        QUICheckBox qUICheckBox2 = null;
        if (qUICheckBox == null) {
            Intrinsics.throwUninitializedPropertyAccessException("syncQzone");
            qUICheckBox = null;
        }
        qUICheckBox.setEnabled(false);
        boolean c16 = ar.f326685a.c("ae_key_editor_wink_low_level_publish_share_sync", true);
        QUICheckBox qUICheckBox3 = this.syncQzone;
        if (qUICheckBox3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("syncQzone");
            qUICheckBox3 = null;
        }
        qUICheckBox3.setChecked(c16);
        D9().b2().postValue(Boolean.valueOf(c16));
        QUICheckBox qUICheckBox4 = this.syncQzone;
        if (qUICheckBox4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("syncQzone");
        } else {
            qUICheckBox2 = qUICheckBox4;
        }
        qUICheckBox2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.tencent.mobileqq.wink.preview.part.base.m
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
                WinkBaseSharePreviewSyncQZonePart.H9(WinkBaseSharePreviewSyncQZonePart.this, compoundButton, z16);
            }
        });
    }

    @NotNull
    public abstract WinkBasePreviewShareViewModel D9();

    @Override // com.tencent.biz.richframework.part.BlockPart, com.tencent.biz.richframework.part.Part
    public void onInitView(@Nullable View rootView) {
        super.onInitView(rootView);
        initView();
        E9();
    }
}
