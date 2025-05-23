package com.tencent.mobileqq.wink.editor.aielimination;

import android.content.res.Resources;
import android.view.View;
import android.widget.LinearLayout;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.wink.editor.aielimination.model.AIEliminationTabName;
import com.tencent.mobileqq.wink.view.StartPointSeekBar;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\b\u0016\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0016J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bH\u0016J\b\u0010\f\u001a\u00020\u000bH\u0016J\b\u0010\r\u001a\u00020\u0002H\u0016J\b\u0010\u000f\u001a\u00020\u000eH\u0016J\n\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016R\u0016\u0010\u0014\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0018\u001a\u00020\u00158\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001b\u001a\u00020\u00028\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001a\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/aielimination/b;", "Lcom/tencent/mobileqq/wink/editor/aielimination/WinkEliminateOperatorPart;", "Landroid/view/View;", "view", "", "P9", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "", "canClicked", "M9", "Lcom/tencent/mobileqq/wink/editor/aielimination/model/AIEliminationTabName;", "x9", "C9", "", "z9", "", "A9", "i", "Z", "isSeekStopTrack", "Lcom/tencent/mobileqq/wink/view/StartPointSeekBar;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/wink/view/StartPointSeekBar;", "penSeekbar", BdhLogUtil.LogTag.Tag_Conn, "Landroid/view/View;", "operatorView", "<init>", "()V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public class b extends WinkEliminateOperatorPart {

    /* renamed from: C, reason: from kotlin metadata */
    private View operatorView;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private boolean isSeekStopTrack;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private StartPointSeekBar penSeekbar;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\t\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/wink/editor/aielimination/b$a", "Lcom/tencent/mobileqq/wink/view/StartPointSeekBar$a;", "Lcom/tencent/mobileqq/wink/view/StartPointSeekBar;", "seekbar", "", "value", "", "wd", "uc", "Fd", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class a implements StartPointSeekBar.a {
        a() {
        }

        @Override // com.tencent.mobileqq.wink.view.StartPointSeekBar.a
        public void Fd(@NotNull StartPointSeekBar seekbar) {
            Intrinsics.checkNotNullParameter(seekbar, "seekbar");
            b.this.isSeekStopTrack = true;
            WinkAIEliminationFragment D9 = b.this.D9();
            if (D9 != null) {
                D9.Fd(seekbar);
            }
        }

        @Override // com.tencent.mobileqq.wink.view.StartPointSeekBar.a
        public void uc(@NotNull StartPointSeekBar seekbar) {
            Intrinsics.checkNotNullParameter(seekbar, "seekbar");
            b.this.isSeekStopTrack = false;
        }

        @Override // com.tencent.mobileqq.wink.view.StartPointSeekBar.a
        public void wd(@NotNull StartPointSeekBar seekbar, int value) {
            WinkAIEliminationFragment D9;
            Intrinsics.checkNotNullParameter(seekbar, "seekbar");
            if (!b.this.isSeekStopTrack && (D9 = b.this.D9()) != null) {
                D9.wd(seekbar, value);
            }
        }
    }

    private final void P9(View view) {
        View findViewById = view.findViewById(R.id.f87684v1);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.spsAdjustSeekBar)");
        StartPointSeekBar startPointSeekBar = (StartPointSeekBar) findViewById;
        this.penSeekbar = startPointSeekBar;
        StartPointSeekBar startPointSeekBar2 = null;
        if (startPointSeekBar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("penSeekbar");
            startPointSeekBar = null;
        }
        startPointSeekBar.setSectionEnable(true);
        StartPointSeekBar startPointSeekBar3 = this.penSeekbar;
        if (startPointSeekBar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("penSeekbar");
            startPointSeekBar3 = null;
        }
        startPointSeekBar3.setProgress(B9().getCurrentSeekBarValue());
        StartPointSeekBar startPointSeekBar4 = this.penSeekbar;
        if (startPointSeekBar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("penSeekbar");
        } else {
            startPointSeekBar2 = startPointSeekBar4;
        }
        startPointSeekBar2.setOnSeekBarChangeListener(new a());
    }

    @Override // com.tencent.mobileqq.wink.editor.aielimination.WinkEliminateOperatorPart
    @Nullable
    public String A9() {
        Resources resources;
        WinkAIEliminationFragment D9 = D9();
        if (D9 != null && (resources = D9.getResources()) != null) {
            return resources.getString(R.string.f240697pv);
        }
        return null;
    }

    @Override // com.tencent.mobileqq.wink.editor.aielimination.WinkEliminateOperatorPart
    @NotNull
    public View C9() {
        View view = this.operatorView;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("operatorView");
            return null;
        }
        return view;
    }

    @Override // com.tencent.mobileqq.wink.editor.aielimination.WinkEliminateOperatorPart
    public void M9(boolean canClicked) {
        float f16;
        LinearLayout E9 = E9();
        if (canClicked) {
            f16 = 1.0f;
        } else {
            f16 = 0.5f;
        }
        E9.setAlpha(f16);
    }

    @Override // com.tencent.mobileqq.wink.editor.aielimination.WinkEliminateOperatorPart, com.tencent.biz.richframework.part.Part
    public void onInitView(@NotNull View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        View findViewById = rootView.findViewById(R.id.zyi);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.id.op_layout)");
        this.operatorView = findViewById;
        P9(rootView);
    }

    @Override // com.tencent.mobileqq.wink.editor.aielimination.WinkEliminateOperatorPart
    @NotNull
    public AIEliminationTabName x9() {
        return AIEliminationTabName.AI_ELIMINATE;
    }

    @Override // com.tencent.mobileqq.wink.editor.aielimination.WinkEliminateOperatorPart
    public int z9() {
        return R.drawable.qui_ai_cleanup_white;
    }
}
