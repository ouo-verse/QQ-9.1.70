package com.qzone.reborn.groupalbum.part.albumdetail;

import android.content.Context;
import android.view.View;
import android.view.ViewStub;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.model.CellFeedCommInfo;
import com.qzone.proxy.feedcomponent.model.CellUserInfo;
import com.qzone.proxy.feedcomponent.model.User;
import com.qzone.reborn.groupalbum.bean.init.GroupAlbumMainPageInitBean;
import com.qzone.reborn.groupalbum.viewmodel.GroupAlbumFeedDetailViewModel;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.R;
import com.tencent.richframework.data.base.UIStateData;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0016\u0010\u0017J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0014\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\bH\u0002J\u0010\u0010\r\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u0004H\u0016R\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0015\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014\u00a8\u0006\u0018"}, d2 = {"Lcom/qzone/reborn/groupalbum/part/albumdetail/GroupAlbumDetailHomeBtnPart;", "Lcom/qzone/reborn/base/k;", "", "I9", "Landroid/view/View;", "view", "G9", "F9", "", "", "", "H9", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "Lcom/qzone/reborn/groupalbum/viewmodel/GroupAlbumFeedDetailViewModel;", "d", "Lcom/qzone/reborn/groupalbum/viewmodel/GroupAlbumFeedDetailViewModel;", "detailViewModel", "", "e", "Z", "hasInit", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class GroupAlbumDetailHomeBtnPart extends com.qzone.reborn.base.k {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private GroupAlbumFeedDetailViewModel detailViewModel;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private boolean hasInit;

    private final void F9(View view) {
        fo.c.l(view, getPartRootView());
        fo.c.e("em_qz_to_see_more_group_dynamics", "pg_qz_group_album_dynamic_details", view, H9());
    }

    private final void G9(View view) {
        fo.c.l(view, getPartRootView());
        fo.c.g("em_qz_to_see_more_group_dynamics", "pg_qz_group_album_dynamic_details", view, H9());
    }

    private final Map<String, Object> H9() {
        BusinessFeedData d26;
        User user;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        GroupAlbumFeedDetailViewModel groupAlbumFeedDetailViewModel = this.detailViewModel;
        if (groupAlbumFeedDetailViewModel != null && (d26 = groupAlbumFeedDetailViewModel.d2()) != null) {
            CellUserInfo cellUserInfo = d26.cellUserInfo;
            String l3 = (cellUserInfo == null || (user = cellUserInfo.user) == null) ? null : Long.valueOf(user.uin).toString();
            if (l3 != null) {
                linkedHashMap.put("framer_uin", l3);
            }
            CellFeedCommInfo feedCommInfo = d26.getFeedCommInfo();
            String str = feedCommInfo != null ? feedCommInfo.feedsid : null;
            if (str != null) {
                linkedHashMap.put("feedid", str);
            }
            GroupAlbumFeedDetailViewModel groupAlbumFeedDetailViewModel2 = this.detailViewModel;
            String groupId = groupAlbumFeedDetailViewModel2 != null ? groupAlbumFeedDetailViewModel2.getGroupId() : null;
            if (groupId != null) {
                linkedHashMap.put("group_uin", groupId);
            }
        }
        return linkedHashMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void I9() {
        if (this.hasInit) {
            return;
        }
        this.hasInit = true;
        ViewStub viewStub = (ViewStub) getPartRootView().findViewById(R.id.nen);
        if (viewStub != null) {
            View inflate = viewStub.inflate();
            Intrinsics.checkNotNullExpressionValue(inflate, "it.inflate()");
            G9(inflate);
            inflate.setOnClickListener(new View.OnClickListener() { // from class: com.qzone.reborn.groupalbum.part.albumdetail.w
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    GroupAlbumDetailHomeBtnPart.J9(GroupAlbumDetailHomeBtnPart.this, view);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void J9(GroupAlbumDetailHomeBtnPart this$0, View it) {
        String str;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(it, "it");
        this$0.F9(it);
        GroupAlbumFeedDetailViewModel groupAlbumFeedDetailViewModel = this$0.detailViewModel;
        if (groupAlbumFeedDetailViewModel == null || (str = groupAlbumFeedDetailViewModel.getGroupId()) == null) {
            str = "";
        }
        GroupAlbumMainPageInitBean groupAlbumMainPageInitBean = new GroupAlbumMainPageInitBean(str);
        oi.c m3 = ho.i.m();
        Context context = this$0.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        m3.i(context, groupAlbumMainPageInitBean);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void K9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        GroupAlbumFeedDetailViewModel groupAlbumFeedDetailViewModel = (GroupAlbumFeedDetailViewModel) getViewModel(GroupAlbumFeedDetailViewModel.class);
        this.detailViewModel = groupAlbumFeedDetailViewModel;
        if (groupAlbumFeedDetailViewModel == null || !groupAlbumFeedDetailViewModel.getFromArk()) {
            return;
        }
        MutableLiveData<UIStateData<BusinessFeedData>> i26 = groupAlbumFeedDetailViewModel.i2();
        Fragment hostFragment = getHostFragment();
        final Function1<UIStateData<BusinessFeedData>, Unit> function1 = new Function1<UIStateData<BusinessFeedData>, Unit>() { // from class: com.qzone.reborn.groupalbum.part.albumdetail.GroupAlbumDetailHomeBtnPart$onInitView$1$1
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
                GroupAlbumDetailHomeBtnPart.this.I9();
            }
        };
        i26.observe(hostFragment, new Observer() { // from class: com.qzone.reborn.groupalbum.part.albumdetail.v
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GroupAlbumDetailHomeBtnPart.K9(Function1.this, obj);
            }
        });
    }
}
