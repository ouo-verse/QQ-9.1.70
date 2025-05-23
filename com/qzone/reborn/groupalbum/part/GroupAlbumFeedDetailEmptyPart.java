package com.qzone.reborn.groupalbum.part;

import android.text.TextUtils;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.reborn.base.QZoneBaseBlockContainer;
import com.qzone.reborn.groupalbum.viewmodel.GroupAlbumFeedDetailViewModel;
import com.qzone.reborn.widget.QZoneBlankStateView;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mtt.hippy.annotation.HippyControllerProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.data.base.UIStateData;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0016\u0010\u0007\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0002J\u0014\u0010\n\u001a\u00020\u00022\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\bH\u0002J\u0010\u0010\r\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000bH\u0016R\u0016\u0010\u0011\u001a\u00020\u000e8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0015\u001a\u00020\u00128\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0018\u001a\u00020\u000b8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001b\u00a8\u0006\u001f"}, d2 = {"Lcom/qzone/reborn/groupalbum/part/GroupAlbumFeedDetailEmptyPart;", "Lcom/qzone/reborn/base/k;", "", "F9", "Lcom/tencent/richframework/data/base/UIStateData;", "Lcom/qzone/proxy/feedcomponent/model/BusinessFeedData;", "businessFeedDataUIStateData", "I9", "", HippyControllerProps.STRING, "G9", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "Lcom/qzone/reborn/widget/QZoneBlankStateView;", "d", "Lcom/qzone/reborn/widget/QZoneBlankStateView;", "blankView", "Lcom/qzone/reborn/base/QZoneBaseBlockContainer;", "e", "Lcom/qzone/reborn/base/QZoneBaseBlockContainer;", "blockContainer", "f", "Landroid/view/View;", "commentContainer", "Lcom/qzone/reborn/groupalbum/viewmodel/GroupAlbumFeedDetailViewModel;", tl.h.F, "Lcom/qzone/reborn/groupalbum/viewmodel/GroupAlbumFeedDetailViewModel;", "mDetailViewModel", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class GroupAlbumFeedDetailEmptyPart extends com.qzone.reborn.base.k {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private QZoneBlankStateView blankView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private QZoneBaseBlockContainer blockContainer;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private View commentContainer;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private GroupAlbumFeedDetailViewModel mDetailViewModel;

    /* JADX INFO: Access modifiers changed from: private */
    public final void F9() {
        QZoneBlankStateView qZoneBlankStateView = this.blankView;
        View view = null;
        if (qZoneBlankStateView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("blankView");
            qZoneBlankStateView = null;
        }
        qZoneBlankStateView.o0();
        QZoneBaseBlockContainer qZoneBaseBlockContainer = this.blockContainer;
        if (qZoneBaseBlockContainer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("blockContainer");
            qZoneBaseBlockContainer = null;
        }
        qZoneBaseBlockContainer.setVisibility(0);
        View view2 = this.commentContainer;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("commentContainer");
        } else {
            view = view2;
        }
        view.setVisibility(0);
    }

    private final void G9(String string) {
        if (TextUtils.isEmpty(string)) {
            if (!NetworkUtil.isNetworkAvailable()) {
                string = com.qzone.util.l.a(R.string.f133596j);
            } else {
                string = com.qzone.util.l.a(R.string.f132964u);
            }
        }
        QZoneBlankStateView qZoneBlankStateView = this.blankView;
        if (qZoneBlankStateView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("blankView");
            qZoneBlankStateView = null;
        }
        qZoneBlankStateView.setData(com.qzone.reborn.feedx.util.k.h(getContext(), string));
        QLog.d(getTAG(), 1, "[initBlankViewData] emptyMsg = " + string);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void H9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void I9(UIStateData<BusinessFeedData> businessFeedDataUIStateData) {
        String str;
        if (((int) businessFeedDataUIStateData.getRetCode()) == 10014) {
            str = com.qzone.util.l.a(R.string.vjq);
            Intrinsics.checkNotNullExpressionValue(str, "qqStr(R.string.qzone_intimate_feed_is_deleted)");
        } else {
            str = "";
        }
        QZoneBaseBlockContainer qZoneBaseBlockContainer = this.blockContainer;
        QZoneBlankStateView qZoneBlankStateView = null;
        if (qZoneBaseBlockContainer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("blockContainer");
            qZoneBaseBlockContainer = null;
        }
        qZoneBaseBlockContainer.setVisibility(8);
        View view = this.commentContainer;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("commentContainer");
            view = null;
        }
        view.setVisibility(8);
        G9(str);
        QZoneBlankStateView qZoneBlankStateView2 = this.blankView;
        if (qZoneBlankStateView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("blankView");
        } else {
            qZoneBlankStateView = qZoneBlankStateView2;
        }
        qZoneBlankStateView.s0();
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View rootView) {
        MutableLiveData<UIStateData<BusinessFeedData>> i26;
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        View findViewById = rootView.findViewById(R.id.mqu);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.id.qzone_blank_view)");
        this.blankView = (QZoneBlankStateView) findViewById;
        View findViewById2 = rootView.findViewById(R.id.mvs);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "rootView.findViewById(R.\u2026one_feed_block_container)");
        this.blockContainer = (QZoneBaseBlockContainer) findViewById2;
        View findViewById3 = rootView.findViewById(R.id.mz8);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "rootView.findViewById(R.\u2026ail_quick_comment_layout)");
        this.commentContainer = findViewById3;
        GroupAlbumFeedDetailViewModel groupAlbumFeedDetailViewModel = (GroupAlbumFeedDetailViewModel) getViewModel(GroupAlbumFeedDetailViewModel.class);
        this.mDetailViewModel = groupAlbumFeedDetailViewModel;
        if (groupAlbumFeedDetailViewModel == null || (i26 = groupAlbumFeedDetailViewModel.i2()) == null) {
            return;
        }
        Fragment hostFragment = getHostFragment();
        final Function1<UIStateData<BusinessFeedData>, Unit> function1 = new Function1<UIStateData<BusinessFeedData>, Unit>() { // from class: com.qzone.reborn.groupalbum.part.GroupAlbumFeedDetailEmptyPart$onInitView$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(UIStateData<BusinessFeedData> uIStateData) {
                invoke2(uIStateData);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(UIStateData<BusinessFeedData> businessFeedDataUIStateData) {
                Intrinsics.checkNotNullParameter(businessFeedDataUIStateData, "businessFeedDataUIStateData");
                int state = businessFeedDataUIStateData.getState();
                if (state != 0) {
                    if (state == 2 || state == 3) {
                        GroupAlbumFeedDetailEmptyPart.this.F9();
                        return;
                    } else if (state != 4) {
                        return;
                    }
                }
                GroupAlbumFeedDetailEmptyPart.this.I9(businessFeedDataUIStateData);
            }
        };
        i26.observe(hostFragment, new Observer() { // from class: com.qzone.reborn.groupalbum.part.h
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GroupAlbumFeedDetailEmptyPart.H9(Function1.this, obj);
            }
        });
    }
}
