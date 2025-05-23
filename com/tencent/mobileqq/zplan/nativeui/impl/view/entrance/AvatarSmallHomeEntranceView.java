package com.tencent.mobileqq.zplan.nativeui.impl.view.entrance;

import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.zplan.nativeui.impl.view.entrance.AvatarSmallHomeEntranceView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.zootopia.utils.PagLoader;
import fi3.an;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u0000 \u00112\u00020\u0001:\u0001\u0012B'\b\u0007\u0012\u0006\u0010\n\u001a\u00020\t\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\b\b\u0002\u0010\u000e\u001a\u00020\r\u00a2\u0006\u0004\b\u000f\u0010\u0010J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002R\u0014\u0010\b\u001a\u00020\u00058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/zplan/nativeui/impl/view/entrance/AvatarSmallHomeEntranceView;", "Landroid/widget/FrameLayout;", "", "c", "b", "Lfi3/an;", "d", "Lfi3/an;", "mBinding", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "e", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class AvatarSmallHomeEntranceView extends FrameLayout {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final an mBinding;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/zplan/nativeui/impl/view/entrance/AvatarSmallHomeEntranceView$b", "Lcom/tencent/sqshow/zootopia/utils/PagLoader$b;", "", "result", "", "onComplete", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class b implements PagLoader.b {
        b() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void b(AvatarSmallHomeEntranceView this$0) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.b();
        }

        @Override // com.tencent.sqshow.zootopia.utils.PagLoader.b
        public void onComplete(boolean result) {
            QLog.i("AvatarSmallHomeEntranceView_", 1, "initSmallHomeIcon loadPag onComplete:" + result);
            if (result) {
                Handler uIHandlerV2 = ThreadManagerV2.getUIHandlerV2();
                final AvatarSmallHomeEntranceView avatarSmallHomeEntranceView = AvatarSmallHomeEntranceView.this;
                uIHandlerV2.post(new Runnable() { // from class: fj3.a
                    @Override // java.lang.Runnable
                    public final void run() {
                        AvatarSmallHomeEntranceView.b.b(AvatarSmallHomeEntranceView.this);
                    }
                });
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public AvatarSmallHomeEntranceView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void b() {
        QLog.i("AvatarSmallHomeEntranceView_", 1, "initSmallHomeIcon width:" + this.mBinding.f398865b.getWidth());
        QLog.e("AvatarSmallHomeEntranceView_", 1, "initSmallHomeIcon pag file is null");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public AvatarSmallHomeEntranceView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final void c() {
        QLog.i("AvatarSmallHomeEntranceView_", 1, "initSmallHomeIcon loadPag begin");
        PagLoader.c().f(getContext(), new b());
    }

    public /* synthetic */ AvatarSmallHomeEntranceView(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AvatarSmallHomeEntranceView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        an f16 = an.f(LayoutInflater.from(context), this);
        Intrinsics.checkNotNullExpressionValue(f16, "inflate(LayoutInflater.from(context), this)");
        this.mBinding = f16;
        c();
    }
}
