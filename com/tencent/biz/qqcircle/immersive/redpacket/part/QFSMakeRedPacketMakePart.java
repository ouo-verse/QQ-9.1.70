package com.tencent.biz.qqcircle.immersive.redpacket.part;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.qqcircle.immersive.redpacket.viewmodel.QFSMakeRedPacketViewModel;
import com.tencent.biz.richframework.compat.DisplayUtil;
import com.tencent.biz.richframework.compat.ImmersiveUtils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.vas.qid.QidPagView;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 \u001c2\u00020\u00012\u00020\u0002:\u0001\u001dB\u0007\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\b\u0010\u0004\u001a\u00020\u0003H\u0002J$\u0010\n\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0007H\u0002J\u0010\u0010\r\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u000bH\u0016J\u0010\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000bH\u0016R\u0016\u0010\u0012\u001a\u00020\u00058\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R#\u0010\u0019\u001a\n \u0014*\u0004\u0018\u00010\u00130\u00138BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/redpacket/part/QFSMakeRedPacketMakePart;", "Lcom/tencent/biz/qqcircle/bizparts/b;", "Landroid/view/View$OnClickListener;", "", "C9", "Landroid/widget/TextView;", "tv", "", "remainNum", "checkNum", "E9", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "v", NodeProps.ON_CLICK, "d", "Landroid/widget/TextView;", "tvRemainNumber", "Lcom/tencent/biz/qqcircle/immersive/redpacket/viewmodel/QFSMakeRedPacketViewModel;", "kotlin.jvm.PlatformType", "e", "Lkotlin/Lazy;", "B9", "()Lcom/tencent/biz/qqcircle/immersive/redpacket/viewmodel/QFSMakeRedPacketViewModel;", "viewModel", "<init>", "()V", "f", "a", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class QFSMakeRedPacketMakePart extends com.tencent.biz.qqcircle.bizparts.b implements View.OnClickListener {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private TextView tvRemainNumber;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy viewModel;

    public QFSMakeRedPacketMakePart() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<QFSMakeRedPacketViewModel>() { // from class: com.tencent.biz.qqcircle.immersive.redpacket.part.QFSMakeRedPacketMakePart$viewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final QFSMakeRedPacketViewModel invoke() {
                return (QFSMakeRedPacketViewModel) QFSMakeRedPacketMakePart.this.getViewModel(QFSMakeRedPacketViewModel.class);
            }
        });
        this.viewModel = lazy;
    }

    private final QFSMakeRedPacketViewModel B9() {
        return (QFSMakeRedPacketViewModel) this.viewModel.getValue();
    }

    private final void C9() {
        LiveData<long[]> a26 = B9().a2();
        Fragment hostFragment = getHostFragment();
        final Function1<long[], Unit> function1 = new Function1<long[], Unit>() { // from class: com.tencent.biz.qqcircle.immersive.redpacket.part.QFSMakeRedPacketMakePart$observeData$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(long[] jArr) {
                invoke2(jArr);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(long[] jArr) {
                TextView textView;
                if (jArr.length != 2) {
                    return;
                }
                QFSMakeRedPacketMakePart qFSMakeRedPacketMakePart = QFSMakeRedPacketMakePart.this;
                textView = qFSMakeRedPacketMakePart.tvRemainNumber;
                if (textView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("tvRemainNumber");
                    textView = null;
                }
                String valueOf = String.valueOf(jArr[0]);
                long j3 = jArr[1];
                qFSMakeRedPacketMakePart.E9(textView, valueOf, j3 > 0 ? String.valueOf(j3) : null);
            }
        };
        a26.observe(hostFragment, new Observer() { // from class: com.tencent.biz.qqcircle.immersive.redpacket.part.e
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QFSMakeRedPacketMakePart.D9(Function1.this, obj);
            }
        });
        B9().e2();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void D9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void E9(TextView tv5, String remainNum, String checkNum) {
        String d16;
        String d17;
        if (uq3.c.C0()) {
            if (checkNum == null) {
                d17 = com.dataline.util.j.d(getContext().getString(R.string.f1916645e));
            } else {
                d17 = com.dataline.util.j.d(getContext().getString(R.string.f1916445c, checkNum));
            }
            tv5.setText(d17);
            return;
        }
        if (checkNum == null) {
            d16 = com.dataline.util.j.d(getContext().getString(R.string.f1916545d, remainNum));
        } else {
            d16 = com.dataline.util.j.d(getContext().getString(R.string.f1916345b, remainNum, checkNum));
        }
        tv5.setText(d16);
    }

    static /* synthetic */ void F9(QFSMakeRedPacketMakePart qFSMakeRedPacketMakePart, TextView textView, String str, String str2, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            str2 = null;
        }
        qFSMakeRedPacketMakePart.E9(textView, str, str2);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@NotNull View v3) {
        EventCollector.getInstance().onViewClickedBefore(v3);
        Intrinsics.checkNotNullParameter(v3, "v");
        if (v3.getId() == R.id.f165954y71) {
            QFSMakeRedPacketViewModel B9 = B9();
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            B9.h2(context);
        }
        EventCollector.getInstance().onViewClicked(v3);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@NotNull View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        QFSMakeRedPacketViewModel B9 = B9();
        Intent intent = getActivity().getIntent();
        Intrinsics.checkNotNullExpressionValue(intent, "activity.intent");
        B9.j2(intent);
        View findViewById = rootView.findViewById(R.id.y0r);
        ViewGroup.LayoutParams layoutParams = findViewById.getLayoutParams();
        layoutParams.height = (DisplayUtil.getScreenWidth() * 440) / QidPagView.DESIGN_PAG_WIDTH;
        findViewById.setLayoutParams(layoutParams);
        com.tencent.biz.qqcircle.immersive.redpacket.util.a aVar = com.tencent.biz.qqcircle.immersive.redpacket.util.a.f89583a;
        com.tencent.biz.qqcircle.immersive.redpacket.util.a.b(aVar, findViewById, "qvideo_hongbao_bg", false, false, 12, null);
        View findViewById2 = rootView.findViewById(R.id.f166090ed2);
        findViewById2.setPadding(findViewById2.getPaddingLeft(), findViewById2.getPaddingTop() + ImmersiveUtils.getStatusBarHeight(rootView.getContext()), findViewById2.getPaddingRight(), findViewById2.getPaddingBottom());
        com.tencent.biz.qqcircle.immersive.redpacket.util.a.b(aVar, rootView.findViewById(R.id.v8k), "qvideo_hongbao_icon_hongbao_qietu", false, false, 12, null);
        View findViewById3 = rootView.findViewById(R.id.f110666j5);
        TextView it = (TextView) findViewById3;
        Intrinsics.checkNotNullExpressionValue(it, "it");
        F9(this, it, " ", null, 4, null);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById<TextView>(R\u2026um(it, \" \")\n            }");
        this.tvRemainNumber = it;
        ImageView it5 = (ImageView) rootView.findViewById(R.id.f165954y71);
        com.tencent.biz.qqcircle.immersive.redpacket.util.a.b(aVar, it5, "qvideo_hongbao_icon_fabu", false, false, 12, null);
        it5.setOnClickListener(this);
        com.tencent.biz.qqcircle.immersive.redpacket.util.b bVar = com.tencent.biz.qqcircle.immersive.redpacket.util.b.f89584a;
        Intrinsics.checkNotNullExpressionValue(it5, "it");
        com.tencent.biz.qqcircle.immersive.redpacket.util.b.b(bVar, it5, null, 2, null);
        C9();
    }
}
