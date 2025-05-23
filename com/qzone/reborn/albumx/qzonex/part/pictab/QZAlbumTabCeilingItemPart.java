package com.qzone.reborn.albumx.qzonex.part.pictab;

import android.view.View;
import android.widget.TextView;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.mobileqq.R;
import java.util.Calendar;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import nc.bp;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\b\u0016\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u001a\u001a\u00020\u0015\u00a2\u0006\u0004\b\"\u0010#J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0010\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u0007H\u0002J\u001c\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00100\u000f2\u0006\u0010\u000e\u001a\u00020\rH\u0002J\b\u0010\u0012\u001a\u00020\u0004H\u0002J\b\u0010\u0013\u001a\u00020\u000bH\u0016J\u0010\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R\u0017\u0010\u001a\u001a\u00020\u00158\u0006\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001e\u001a\u00020\u001b8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0016\u0010!\u001a\u00020\u00028\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 \u00a8\u0006$"}, d2 = {"Lcom/qzone/reborn/albumx/qzonex/part/pictab/QZAlbumTabCeilingItemPart;", "Lcom/qzone/reborn/base/k;", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "", "K9", "initData", "Lcb/b;", "bean", "L9", "data", "", "H9", "", "titleTime", "Lkotlin/Pair;", "", "G9", "initViewModel", "getLogTag", "onInitView", "Lnc/bp;", "d", "Lnc/bp;", "getMediaViewModel", "()Lnc/bp;", "mediaViewModel", "Landroid/widget/TextView;", "e", "Landroid/widget/TextView;", "tvTitle", "f", "Landroid/view/View;", "titleContainer", "<init>", "(Lnc/bp;)V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public class QZAlbumTabCeilingItemPart extends com.qzone.reborn.base.k {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final bp mediaViewModel;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private TextView tvTitle;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private View titleContainer;

    public QZAlbumTabCeilingItemPart(bp mediaViewModel) {
        Intrinsics.checkNotNullParameter(mediaViewModel, "mediaViewModel");
        this.mediaViewModel = mediaViewModel;
    }

    private final Pair<Integer, Integer> G9(long titleTime) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(titleTime * 1000);
        return new Pair<>(Integer.valueOf(calendar.get(1)), Integer.valueOf(calendar.get(2) + 1));
    }

    private final String H9(cb.b data) {
        Pair<Integer, Integer> G9 = G9(data.getCurTimeStamp());
        return G9.getFirst() + "\u5e74" + G9.getSecond() + "\u6708";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void I9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void J9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void L9(cb.b bean) {
        TextView textView = this.tvTitle;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvTitle");
            textView = null;
        }
        textView.setText(H9(bean));
    }

    private final void initData() {
        MutableLiveData<cb.b> R1 = this.mediaViewModel.R1();
        LifecycleOwner lifecycleOwner = getPartHost().getLifecycleOwner();
        final Function1<cb.b, Unit> function1 = new Function1<cb.b, Unit>() { // from class: com.qzone.reborn.albumx.qzonex.part.pictab.QZAlbumTabCeilingItemPart$initData$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(cb.b bVar) {
                invoke2(bVar);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(cb.b it) {
                RFWLog.i(QZAlbumTabCeilingItemPart.this.getLogTag(), RFWLog.USR, "curTimeStamp is " + it.getCurTimeStamp());
                QZAlbumTabCeilingItemPart qZAlbumTabCeilingItemPart = QZAlbumTabCeilingItemPart.this;
                Intrinsics.checkNotNullExpressionValue(it, "it");
                qZAlbumTabCeilingItemPart.L9(it);
            }
        };
        R1.observe(lifecycleOwner, new Observer() { // from class: com.qzone.reborn.albumx.qzonex.part.pictab.a
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QZAlbumTabCeilingItemPart.I9(Function1.this, obj);
            }
        });
        MutableLiveData<Boolean> T1 = this.mediaViewModel.T1();
        LifecycleOwner lifecycleOwner2 = getPartHost().getLifecycleOwner();
        final Function1<Boolean, Unit> function12 = new Function1<Boolean, Unit>() { // from class: com.qzone.reborn.albumx.qzonex.part.pictab.QZAlbumTabCeilingItemPart$initData$2
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
            public final void invoke2(Boolean it) {
                View view;
                view = QZAlbumTabCeilingItemPart.this.titleContainer;
                if (view == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("titleContainer");
                    view = null;
                }
                Intrinsics.checkNotNullExpressionValue(it, "it");
                view.setVisibility(it.booleanValue() ? 8 : 0);
            }
        };
        T1.observe(lifecycleOwner2, new Observer() { // from class: com.qzone.reborn.albumx.qzonex.part.pictab.b
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QZAlbumTabCeilingItemPart.J9(Function1.this, obj);
            }
        });
    }

    @Override // com.tencent.biz.richframework.part.Part
    public String getLogTag() {
        return "QZAlbumTabCeilingItemPart";
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        initViewModel();
        K9(rootView);
        initData();
    }

    private final void K9(View rootView) {
        View findViewById = rootView.findViewById(R.id.ngc);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.id.tab_media_title)");
        this.tvTitle = (TextView) findViewById;
        View findViewById2 = rootView.findViewById(R.id.ngg);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "rootView.findViewById(R.id.tab_title_container)");
        this.titleContainer = findViewById2;
        if (findViewById2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("titleContainer");
            findViewById2 = null;
        }
        findViewById2.setBackground(getContext().getDrawable(R.drawable.qui_common_bg_bottom_light_bg));
    }

    private final void initViewModel() {
    }
}
