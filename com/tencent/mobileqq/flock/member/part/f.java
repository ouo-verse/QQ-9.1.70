package com.tencent.mobileqq.flock.member.part;

import android.graphics.Typeface;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.flock.member.fragment.FlockMemberListFragment;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002B\u0007\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u0012\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016J\u0012\u0010\b\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003H\u0016R\u0016\u0010\f\u001a\u00020\t8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0016\u0010\u0010\u001a\u00020\r8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/flock/member/part/f;", "Lcom/tencent/mobileqq/flock/base/b;", "Landroid/view/View$OnClickListener;", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "", "onInitView", "v", NodeProps.ON_CLICK, "Landroid/widget/ImageView;", "d", "Landroid/widget/ImageView;", "ivBack", "Landroid/widget/TextView;", "e", "Landroid/widget/TextView;", "tvTitle", "<init>", "()V", "qq-flock-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class f extends com.tencent.mobileqq.flock.base.b implements View.OnClickListener {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private ImageView ivBack;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private TextView tvTitle;

    public f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@Nullable View v3) {
        Integer num;
        EventCollector.getInstance().onViewClickedBefore(v3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) v3);
        } else {
            FlockMemberListFragment flockMemberListFragment = null;
            if (v3 != null) {
                num = Integer.valueOf(v3.getId());
            } else {
                num = null;
            }
            if (num != null && num.intValue() == R.id.y8b) {
                Fragment hostFragment = getHostFragment();
                if (hostFragment instanceof FlockMemberListFragment) {
                    flockMemberListFragment = (FlockMemberListFragment) hostFragment;
                }
                if (flockMemberListFragment != null) {
                    flockMemberListFragment.dismiss();
                }
            }
        }
        EventCollector.getInstance().onViewClicked(v3);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@Nullable View rootView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) rootView);
            return;
        }
        super.onInitView(rootView);
        if (rootView != null) {
            View findViewById = rootView.findViewById(R.id.du6);
            ImageView imageView = (ImageView) findViewById;
            imageView.setVisibility(8);
            Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById<ImageView>(\u2026= View.GONE\n            }");
            this.ivBack = imageView;
            View findViewById2 = rootView.findViewById(R.id.kbs);
            TextView textView = (TextView) findViewById2;
            textView.setText("\u53c2\u4e0e\u4eba\u5217\u8868");
            textView.setTypeface(Typeface.DEFAULT_BOLD);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById<TextView?>(\u2026EFAULT_BOLD\n            }");
            this.tvTitle = textView;
            ImageView imageView2 = (ImageView) rootView.findViewById(R.id.y8b);
            imageView2.setOnClickListener(this);
            imageView2.setVisibility(0);
        }
    }
}
