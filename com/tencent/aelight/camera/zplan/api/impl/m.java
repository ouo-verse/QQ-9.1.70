package com.tencent.aelight.camera.zplan.api.impl;

import android.support.v4.util.LongSparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.aelight.camera.aioeditor.takevideo.EditVideoPartManager;
import com.tencent.aelight.camera.aioeditor.takevideo.r;
import com.tencent.biz.qui.quibutton.QUIButton;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.editor.params.EditVideoParams;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0016\u0018\u0000 \u00142\u00020\u0001:\u0001\u0015B\u0017\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u0012\u0006\u0010\u0011\u001a\u00020\u000b\u00a2\u0006\u0004\b\u0012\u0010\u0013J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\t\u001a\u00020\u0002H\u0016J\b\u0010\n\u001a\u00020\u0002H\u0014J\u0010\u0010\r\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000bH\u0014J\b\u0010\u000e\u001a\u00020\u000bH\u0014\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/aelight/camera/zplan/api/impl/m;", "Lcom/tencent/aelight/camera/aioeditor/takevideo/r;", "", "P0", "N0", "O0", "Landroid/view/View;", "view", "J0", "onCreate", "u0", "", "needButtonMasks", "k0", "l0", "Lcom/tencent/aelight/camera/aioeditor/takevideo/EditVideoPartManager;", "manager", "enableMask", "<init>", "(Lcom/tencent/aelight/camera/aioeditor/takevideo/EditVideoPartManager;I)V", "a0", "a", "aelight_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes32.dex */
public class m extends r {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m(EditVideoPartManager manager, int i3) {
        super(manager, i3);
        Intrinsics.checkNotNullParameter(manager, "manager");
    }

    private final void J0(View view) {
        String qqStr;
        if (view instanceof TextView) {
            this.mParent.C.e();
            EditVideoParams editVideoParams = this.mParent.C;
            if (editVideoParams.f204055d != 16) {
                QLog.e("ZPlanEditPicButton", 1, "setPublishText fail, not ZPlan business.");
                return;
            }
            int k3 = editVideoParams.k();
            if (k3 == 144) {
                qqStr = HardCodeUtil.qqStr(R.string.f207085_2);
            } else if (k3 != 145) {
                QLog.e("ZPlanEditPicButton", 1, "entrance type error, text empty.");
                qqStr = "";
            } else {
                qqStr = HardCodeUtil.qqStr(R.string.f207075_1);
            }
            TextView textView = (TextView) view;
            textView.setText(qqStr);
            textView.setContentDescription(qqStr);
        }
    }

    private final void N0() {
        int size = this.Q.size();
        for (int i3 = 0; i3 < size; i3++) {
            ImageView valueAt = this.Q.valueAt(i3);
            if (valueAt != null) {
                ViewGroup.LayoutParams layoutParams = valueAt.getLayoutParams();
                LinearLayout.LayoutParams layoutParams2 = layoutParams instanceof LinearLayout.LayoutParams ? (LinearLayout.LayoutParams) layoutParams : null;
                if (layoutParams2 != null) {
                    layoutParams2.width = BaseAIOUtils.f(30.0f, getContext().getResources());
                    layoutParams2.height = BaseAIOUtils.f(30.0f, getContext().getResources());
                    valueAt.setLayoutParams(layoutParams2);
                }
            }
        }
    }

    private final void O0() {
        QUIButton mPublish = this.F;
        Intrinsics.checkNotNullExpressionValue(mPublish, "mPublish");
        J0(mPublish);
        this.F.setTextSize(0, getResources().getDimension(R.dimen.f158538ia));
        this.F.setMinimumHeight(getResources().getDimensionPixelSize(R.dimen.i_));
        ViewGroup.LayoutParams layoutParams = this.F.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) layoutParams;
        layoutParams2.width = BaseAIOUtils.f(108.0f, getContext().getResources());
        layoutParams2.height = BaseAIOUtils.f(42.0f, getContext().getResources());
        this.F.setLayoutParams(layoutParams2);
    }

    private final void P0() {
        TextView textView = new TextView(getContext());
        textView.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        int k3 = this.mParent.C.k();
        if (k3 == 144) {
            textView.setText("\u5236\u4f5c\u8868\u60c5");
        } else if (k3 == 145) {
            textView.setText("\u8bbe\u7f6e\u5934\u50cf");
        }
        textView.setTextSize(18.0f);
        textView.setIncludeFontPadding(false);
        textView.setTextColor(-1);
        textView.setGravity(17);
        textView.setSingleLine();
        View findViewSure = findViewSure(R.id.f163733rq0);
        Intrinsics.checkNotNull(findViewSure, "null cannot be cast to non-null type android.widget.RelativeLayout");
        ((RelativeLayout) findViewSure).addView(textView);
    }

    @Override // com.tencent.aelight.camera.aioeditor.takevideo.r
    protected void k0(int needButtonMasks) {
        u0();
        if (this.mParent.C.k() == 144) {
            LongSparseArray<r.d> longSparseArray = r.Z;
            longSparseArray.put(1L, new r.d(1L, R.drawable.f160001iz0, HardCodeUtil.qqStr(R.string.f171938m23)));
            longSparseArray.put(2L, new r.d(8L, R.drawable.f160003iz2, HardCodeUtil.qqStr(R.string.f171936m12)));
        }
    }

    @Override // com.tencent.aelight.camera.aioeditor.takevideo.r
    protected int l0() {
        EditVideoParams editVideoParams = this.mParent.C;
        int i3 = editVideoParams.f204055d;
        int k3 = editVideoParams.k();
        if (i3 != 16) {
            QLog.e("ZPlanEditPicButton", 1, "adjustBottomButtonShown failed, busId invalid.");
            return r.Y;
        }
        if (k3 == 144) {
            return 9;
        }
        QLog.e("ZPlanEditPicButton", 1, "adjustBottomButtonShown failed, entranceType invalid");
        return r.Y;
    }

    @Override // com.tencent.aelight.camera.aioeditor.takevideo.r, com.tencent.aelight.camera.aioeditor.takevideo.u
    public void onCreate() {
        super.onCreate();
        P0();
        N0();
        O0();
    }

    @Override // com.tencent.aelight.camera.aioeditor.takevideo.r
    protected void u0() {
        LongSparseArray<r.d> longSparseArray = r.Z;
        longSparseArray.clear();
        longSparseArray.put(1L, new r.d(1L, R.drawable.f160001iz0, HardCodeUtil.qqStr(R.string.f171938m23)));
        longSparseArray.put(8L, new r.d(8L, R.drawable.f160003iz2, HardCodeUtil.qqStr(R.string.f171936m12)));
    }
}
