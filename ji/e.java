package ji;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.qzone.reborn.base.k;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0018\u0010\u0019J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016R\"\u0010\u000f\u001a\u00020\u00068\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\"\u0010\u0017\u001a\u00020\u00108\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016\u00a8\u0006\u001a"}, d2 = {"Lji/e;", "Lcom/qzone/reborn/base/k;", "", "D9", "", "getLogTag", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "d", "Landroid/view/View;", "E9", "()Landroid/view/View;", "H9", "(Landroid/view/View;)V", "backIcon", "Landroid/widget/TextView;", "e", "Landroid/widget/TextView;", "F9", "()Landroid/widget/TextView;", "I9", "(Landroid/widget/TextView;)V", "titleTv", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class e extends k {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public View backIcon;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public TextView titleTv;

    private final void D9() {
        fo.c.o(E9(), WinkDaTongReportConstant.ElementId.EM_XSJ_QZ_BACK, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void G9(e this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Context context = this$0.getContext();
        Activity activity = context instanceof Activity ? (Activity) context : null;
        if (activity != null) {
            activity.onBackPressed();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    public final View E9() {
        View view = this.backIcon;
        if (view != null) {
            return view;
        }
        Intrinsics.throwUninitializedPropertyAccessException("backIcon");
        return null;
    }

    public final TextView F9() {
        TextView textView = this.titleTv;
        if (textView != null) {
            return textView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("titleTv");
        return null;
    }

    public final void H9(View view) {
        Intrinsics.checkNotNullParameter(view, "<set-?>");
        this.backIcon = view;
    }

    public final void I9(TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "<set-?>");
        this.titleTv = textView;
    }

    @Override // com.tencent.biz.richframework.part.Part
    /* renamed from: getLogTag */
    public String getTAG() {
        return "GroupAlbumNoticeTitlePart";
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        View findViewById = rootView.findViewById(R.id.lck);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.id.iv_message_back)");
        H9(findViewById);
        E9().setOnClickListener(new View.OnClickListener() { // from class: ji.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                e.G9(e.this, view);
            }
        });
        View findViewById2 = rootView.findViewById(R.id.nja);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "rootView.findViewById(R.id.tv_message_title)");
        I9((TextView) findViewById2);
        F9().setText(getContext().getString(R.string.jho));
        D9();
    }
}
