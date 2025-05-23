package com.tencent.qqnt.qwallet.aio;

import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.qqnt.kernel.nativeinterface.WalletElement;
import com.tencent.qqnt.qwallet.aio.festival.FestivalView;
import com.tencent.qqnt.qwallet.aio.hb.AbstractHbView;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import rx3.g;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001bB1\b\u0007\u0012\u0006\u0010\u0012\u001a\u00020\u0011\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0013\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0015\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0015\u00a2\u0006\u0004\b\u0018\u0010\u0019J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J\b\u0010\n\u001a\u0004\u0018\u00010\tR\u0018\u0010\f\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u000bR\u0018\u0010\u0010\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000f\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/qqnt/qwallet/aio/AIOComponentView;", "Landroid/widget/FrameLayout;", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "msgRecord", "", "d", "Lcom/tencent/aio/api/runtime/a;", "aioContext", "b", "Landroid/view/View;", "c", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "curMsgRecord", "Lcom/tencent/qqnt/kernel/nativeinterface/WalletElement;", "e", "Lcom/tencent/qqnt/kernel/nativeinterface/WalletElement;", "curWalletElement", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "", "defStyleAttr", "defStyleRes", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "f", "a", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class AIOComponentView extends FrameLayout {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private MsgRecord curMsgRecord;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private WalletElement curWalletElement;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public AIOComponentView(@NotNull Context context) {
        this(context, null, 0, 0, 14, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e() {
        MobileQQ.sMobileQQ.sendBroadcast(new Intent("com.tencent.mobileqq.qwallet.send.message"));
    }

    public final void b(@NotNull com.tencent.aio.api.runtime.a aioContext) {
        Intrinsics.checkNotNullParameter(aioContext, "aioContext");
        AIOContextHolder.f361707d.a(aioContext);
    }

    @Nullable
    public final View c() {
        View view;
        if (getChildCount() > 0) {
            view = getChildAt(0);
        } else {
            view = null;
        }
        if (view instanceof AbstractHbView) {
            return ((AbstractHbView) view).z0();
        }
        return view;
    }

    public final void d(@NotNull MsgRecord msgRecord) {
        View view;
        Intrinsics.checkNotNullParameter(msgRecord, "msgRecord");
        QLog.d("WalletNT-AIOParentView", 1, "handleMessage: component " + hashCode() + ", msgRecord " + msgRecord.msgId);
        this.curMsgRecord = msgRecord;
        WalletElement b16 = f81.a.b(msgRecord);
        if (b16 == null) {
            return;
        }
        this.curWalletElement = b16;
        ViewGroup viewGroup = null;
        if (getChildCount() > 0) {
            view = getChildAt(0);
        } else {
            view = null;
        }
        d dVar = d.f361713a;
        int i3 = b16.msgType;
        String str = b16.billNo;
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        AIOContentView a16 = dVar.a(i3, str, view, context);
        if (a16 instanceof FestivalView) {
            ViewParent parent = getParent();
            if (parent instanceof ViewGroup) {
                viewGroup = (ViewGroup) parent;
            }
            if (viewGroup != null) {
                viewGroup.setClipChildren(false);
            }
        }
        removeAllViews();
        a16.W0().L1(new g(msgRecord, b16));
        addView(a16.getView());
        if (f81.a.c(msgRecord)) {
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.qqnt.qwallet.aio.b
                @Override // java.lang.Runnable
                public final void run() {
                    AIOComponentView.e();
                }
            });
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public AIOComponentView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 0, 12, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public AIOComponentView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        this(context, attributeSet, i3, 0, 8, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ AIOComponentView(Context context, AttributeSet attributeSet, int i3, int i16, int i17, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i17 & 2) != 0 ? null : attributeSet, (i17 & 4) != 0 ? 0 : i3, (i17 & 8) != 0 ? 0 : i16);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public AIOComponentView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3, int i16) {
        super(context, attributeSet, i3, i16);
        Intrinsics.checkNotNullParameter(context, "context");
        setClipChildren(false);
    }
}
