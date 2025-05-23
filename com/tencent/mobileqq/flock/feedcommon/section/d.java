package com.tencent.mobileqq.flock.feedcommon.section;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.flock.repeat.FlockRepeatType;
import com.tencent.mobileqq.flock.utils.DateTimeUtils;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\b\u0010\u0004\u001a\u00020\u0003H\u0014J\u0012\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0014J*\u0010\u000f\u001a\u00020\u00072\b\u0010\t\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u000b\u001a\u00020\n2\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\fH\u0014R\u0016\u0010\u0012\u001a\u00020\u00058\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0016\u001a\u00020\u00138\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\u001a\u001a\u00020\u00178\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/mobileqq/flock/feedcommon/section/d;", "Lcom/tencent/mobileqq/flock/base/c;", "Lcom/tencent/mobileqq/flock/feeddetail/bean/a;", "", "getViewStubLayoutId", "Landroid/view/View;", "containerView", "", "onInitView", "data", "", "position", "", "", "payload", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "d", "Landroid/view/View;", "repeatLayout", "Landroid/widget/ImageView;", "e", "Landroid/widget/ImageView;", "ivRepeat", "Landroid/widget/TextView;", "f", "Landroid/widget/TextView;", "tvRepeat", "<init>", "()V", "qq-flock-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class d extends com.tencent.mobileqq.flock.base.c<com.tencent.mobileqq.flock.feeddetail.bean.a> {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private View repeatLayout;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private ImageView ivRepeat;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private TextView tvRepeat;

    public d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    @NotNull
    public int[] getViewStubLayoutId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (int[]) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return new int[]{R.id.f1193076h};
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public void onInitView(@Nullable View containerView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) containerView);
            return;
        }
        if (containerView != null) {
            View findViewById = containerView.findViewById(R.id.yfe);
            Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.layout_repeat)");
            this.repeatLayout = findViewById;
            View findViewById2 = containerView.findViewById(R.id.y86);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.iv_repeat)");
            this.ivRepeat = (ImageView) findViewById2;
            View findViewById3 = containerView.findViewById(R.id.f110696j8);
            Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.tv_repeat)");
            this.tvRepeat = (TextView) findViewById3;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v4, types: [android.view.View] */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    /* renamed from: q, reason: merged with bridge method [inline-methods] */
    public void onBindData(@Nullable com.tencent.mobileqq.flock.feeddetail.bean.a data, int position, @Nullable List<Object> payload) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, data, Integer.valueOf(position), payload);
            return;
        }
        if (data != null) {
            FlockRepeatType.Companion companion = FlockRepeatType.INSTANCE;
            TextView textView = null;
            if (TextUtils.isEmpty(companion.c(data.a().f449374i.f449363c))) {
                ?? r112 = this.repeatLayout;
                if (r112 == 0) {
                    Intrinsics.throwUninitializedPropertyAccessException("repeatLayout");
                } else {
                    textView = r112;
                }
                textView.setVisibility(8);
                return;
            }
            View view = this.repeatLayout;
            if (view == null) {
                Intrinsics.throwUninitializedPropertyAccessException("repeatLayout");
                view = null;
            }
            view.setVisibility(0);
            y45.a aVar = data.a().f449374i;
            TextView textView2 = this.tvRepeat;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tvRepeat");
            } else {
                textView = textView2;
            }
            textView.setText(DateTimeUtils.f210478a.f(companion.b(aVar.f449363c), aVar.f449361a, aVar.f449364d, true));
        }
    }
}
