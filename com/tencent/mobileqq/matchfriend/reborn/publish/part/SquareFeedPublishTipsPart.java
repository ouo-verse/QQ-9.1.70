package com.tencent.mobileqq.matchfriend.reborn.publish.part;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.component.banner.DownToUpViewSwitcher;
import com.tencent.mobileqq.matchfriend.reborn.publish.config.QQStrangerSquarePublishConfigMgr;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 )2\u00020\u0001:\u0001*B\u0007\u00a2\u0006\u0004\b'\u0010(J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u001c\u0010\u000b\u001a\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016J\u0012\u0010\u000e\u001a\u00020\u00022\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016R\u001c\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R#\u0010\u001a\u001a\n \u0015*\u0004\u0018\u00010\u00140\u00148BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u0018\u0010\u001d\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0018\u0010!\u001a\u0004\u0018\u00010\u001e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u001b\u0010&\u001a\u00020\"8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b#\u0010\u0017\u001a\u0004\b$\u0010%\u00a8\u0006+"}, d2 = {"Lcom/tencent/mobileqq/matchfriend/reborn/publish/part/SquareFeedPublishTipsPart;", "Lcom/tencent/biz/richframework/part/Part;", "", "G9", "", NodeProps.VISIBLE, "H9", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onPartCreate", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "", "", "d", "Ljava/util/List;", "tipsDataList", "Ls82/a;", "kotlin.jvm.PlatformType", "e", "Lkotlin/Lazy;", "E9", "()Ls82/a;", "viewModel", "f", "Landroid/view/View;", "tipsContainerView", "Lcom/tencent/mobileqq/guild/component/banner/DownToUpViewSwitcher;", tl.h.F, "Lcom/tencent/mobileqq/guild/component/banner/DownToUpViewSwitcher;", "tipsDownToUpView", "Lr82/a;", "i", "D9", "()Lr82/a;", "tipsAdapter", "<init>", "()V", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "a", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class SquareFeedPublishTipsPart extends Part {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private List<String> tipsDataList = new ArrayList();

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final Lazy viewModel;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private View tipsContainerView;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private DownToUpViewSwitcher tipsDownToUpView;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final Lazy tipsAdapter;

    public SquareFeedPublishTipsPart() {
        Lazy lazy;
        Lazy lazy2;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<s82.a>() { // from class: com.tencent.mobileqq.matchfriend.reborn.publish.part.SquareFeedPublishTipsPart$viewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final s82.a invoke() {
                return (s82.a) SquareFeedPublishTipsPart.this.getViewModel(s82.a.class);
            }
        });
        this.viewModel = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<r82.a>() { // from class: com.tencent.mobileqq.matchfriend.reborn.publish.part.SquareFeedPublishTipsPart$tipsAdapter$2
            @Override // kotlin.jvm.functions.Function0
            public final r82.a invoke() {
                return new r82.a();
            }
        });
        this.tipsAdapter = lazy2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final r82.a D9() {
        return (r82.a) this.tipsAdapter.getValue();
    }

    private final s82.a E9() {
        return (s82.a) this.viewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void F9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void G9() {
        QQStrangerSquarePublishConfigMgr.f245289a.f(new SquareFeedPublishTipsPart$updateTips$1(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void H9(boolean visible) {
        int i3 = 4;
        if (this.tipsDataList.isEmpty()) {
            QLog.i("SquareFeedPublishTipsPart", 1, "updateTipsVisible data list is empty.");
        } else if (visible) {
            i3 = 0;
        }
        View view = this.tipsContainerView;
        if (view == null) {
            return;
        }
        view.setVisibility(i3);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View rootView) {
        super.onInitView(rootView);
        this.tipsContainerView = rootView != null ? rootView.findViewById(R.id.orf) : null;
        DownToUpViewSwitcher downToUpViewSwitcher = rootView != null ? (DownToUpViewSwitcher) rootView.findViewById(R.id.orh) : null;
        this.tipsDownToUpView = downToUpViewSwitcher;
        if (downToUpViewSwitcher != null) {
            downToUpViewSwitcher.setAdapter(D9());
        }
        DownToUpViewSwitcher downToUpViewSwitcher2 = this.tipsDownToUpView;
        if (downToUpViewSwitcher2 != null) {
            downToUpViewSwitcher2.setAutoScrollInterval(2000L);
        }
        G9();
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartCreate(Activity activity, Bundle savedInstanceState) {
        super.onPartCreate(activity, savedInstanceState);
        MutableLiveData<Boolean> L1 = E9().L1();
        LifecycleOwner hostLifecycleOwner = getPartHost().getHostLifecycleOwner();
        final Function1<Boolean, Unit> function1 = new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.matchfriend.reborn.publish.part.SquareFeedPublishTipsPart$onPartCreate$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke2(bool);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Boolean bool) {
                SquareFeedPublishTipsPart.this.H9(!bool.booleanValue());
            }
        };
        L1.observe(hostLifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.matchfriend.reborn.publish.part.h
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                SquareFeedPublishTipsPart.F9(Function1.this, obj);
            }
        });
    }
}
