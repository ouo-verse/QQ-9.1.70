package com.qzone.reborn.groupalbum.part.myalbum;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.qzone.reborn.base.k;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.R;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0017\u0010\u0018J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016R\"\u0010\u000e\u001a\u00020\u00048\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\"\u0010\u0016\u001a\u00020\u000f8\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015\u00a8\u0006\u0019"}, d2 = {"Lcom/qzone/reborn/groupalbum/part/myalbum/g;", "Lcom/qzone/reborn/base/k;", "", "getLogTag", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "", "onInitView", "d", "Landroid/view/View;", "D9", "()Landroid/view/View;", "G9", "(Landroid/view/View;)V", "backIcon", "Landroid/widget/TextView;", "e", "Landroid/widget/TextView;", "E9", "()Landroid/widget/TextView;", "H9", "(Landroid/widget/TextView;)V", "titleTv", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class g extends k {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public View backIcon;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public TextView titleTv;

    /* JADX INFO: Access modifiers changed from: private */
    public static final void F9(g this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Context context = this$0.getContext();
        Activity activity = context instanceof Activity ? (Activity) context : null;
        if (activity != null) {
            activity.onBackPressed();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    public final View D9() {
        View view = this.backIcon;
        if (view != null) {
            return view;
        }
        Intrinsics.throwUninitializedPropertyAccessException("backIcon");
        return null;
    }

    public final TextView E9() {
        TextView textView = this.titleTv;
        if (textView != null) {
            return textView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("titleTv");
        return null;
    }

    public final void G9(View view) {
        Intrinsics.checkNotNullParameter(view, "<set-?>");
        this.backIcon = view;
    }

    public final void H9(TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "<set-?>");
        this.titleTv = textView;
    }

    @Override // com.tencent.biz.richframework.part.Part
    public String getLogTag() {
        return "GroupAlbumMyAlbumTitlePart";
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        View findViewById = rootView.findViewById(R.id.lck);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.id.iv_message_back)");
        G9(findViewById);
        D9().setOnClickListener(new View.OnClickListener() { // from class: com.qzone.reborn.groupalbum.part.myalbum.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                g.F9(g.this, view);
            }
        });
        View findViewById2 = rootView.findViewById(R.id.nja);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "rootView.findViewById(R.id.tv_message_title)");
        H9((TextView) findViewById2);
        E9().setText(getContext().getString(R.string.f1331159));
    }
}
