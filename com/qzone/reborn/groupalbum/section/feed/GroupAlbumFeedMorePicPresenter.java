package com.qzone.reborn.groupalbum.section.feed;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.model.CellPictureInfo;
import com.qzone.proxy.feedcomponent.model.PictureItem;
import com.qzone.reborn.groupalbum.bean.init.GroupAlbumAlbumDetailInitBean;
import com.qzone.reborn.groupalbum.viewmodel.GroupAlbumFeedDetailViewModel;
import com.qzone.util.ar;
import com.tencent.biz.richframework.part.BasePartFragment;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.data.base.UIStateData;
import java.util.ArrayList;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.SetsKt__SetsJVMKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 \u00132\u00020\u00012\u00020\u0002:\u00018B\u0007\u00a2\u0006\u0004\b6\u00107J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0005\u001a\u00020\u0003H\u0002J\u0018\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\bH\u0002J \u0010\u000b\u001a\u00020\u00032\u0016\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\bH\u0002J\u0010\u0010\u000e\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\fH\u0002J&\u0010\u0011\u001a\u00020\u00032\u001c\u0010\u0010\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\b0\u000fH\u0002J&\u0010\u0013\u001a\u00020\u00032\u001c\u0010\u0012\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\b0\u000fH\u0002J\b\u0010\u0014\u001a\u00020\u0003H\u0002J\b\u0010\u0015\u001a\u00020\u0003H\u0002J\b\u0010\u0017\u001a\u00020\u0016H\u0014J\b\u0010\u0018\u001a\u00020\fH\u0014J\b\u0010\u001a\u001a\u00020\u0019H\u0014J\u0010\u0010\u001d\u001a\u00020\u00032\u0006\u0010\u001c\u001a\u00020\u001bH\u0014J\u0012\u0010 \u001a\u00020\u00032\b\u0010\u001f\u001a\u0004\u0018\u00010\u001eH\u0014J\u0012\u0010\"\u001a\u00020\u00032\b\u0010!\u001a\u0004\u0018\u00010\u001bH\u0016R\u0016\u0010&\u001a\u00020#8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u0016\u0010*\u001a\u00020'8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b(\u0010)R\u0016\u0010.\u001a\u00020+8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b,\u0010-R\u0018\u00102\u001a\u0004\u0018\u00010/8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b0\u00101R*\u00104\u001a\u0016\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006j\n\u0012\u0004\u0012\u00020\u0007\u0018\u0001`\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\t\u00103R\u0016\u00105\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u00100\u00a8\u00069"}, d2 = {"Lcom/qzone/reborn/groupalbum/section/feed/GroupAlbumFeedMorePicPresenter;", "Lvg/a;", "Landroid/view/View$OnClickListener;", "", ExifInterface.LATITUDE_SOUTH, "M", "Ljava/util/ArrayList;", "Lcom/qzone/proxy/feedcomponent/model/PictureItem;", "Lkotlin/collections/ArrayList;", "J", "picItems", BdhLogUtil.LogTag.Tag_Req, "", "state", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Lcom/tencent/richframework/data/base/UIStateData;", "listUIStateData", "K", "uiStateData", "L", "P", "O", "", "k", ReportConstant.COSTREPORT_PREFIX, "", HippyTKDListViewAdapter.X, "Landroid/view/View;", "containerView", BdhLogUtil.LogTag.Tag_Conn, "Lcom/qzone/proxy/feedcomponent/model/BusinessFeedData;", "feedData", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "view", NodeProps.ON_CLICK, "Landroid/widget/LinearLayout;", UserInfo.SEX_FEMALE, "Landroid/widget/LinearLayout;", "mExpandContainerView", "Landroid/widget/ImageView;", "G", "Landroid/widget/ImageView;", "mExpandImageView", "Landroid/widget/TextView;", "H", "Landroid/widget/TextView;", "mExpandTextView", "Lcom/qzone/reborn/groupalbum/viewmodel/GroupAlbumFeedDetailViewModel;", "I", "Lcom/qzone/reborn/groupalbum/viewmodel/GroupAlbumFeedDetailViewModel;", "mAlbumViewModel", "Ljava/util/ArrayList;", "mOtherPictureItems", "mExpandState", "<init>", "()V", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class GroupAlbumFeedMorePicPresenter extends vg.a implements View.OnClickListener {
    private static final int M = -ar.d(60.0f);
    private static final int N = -ar.d(20.0f);

    /* renamed from: F, reason: from kotlin metadata */
    private LinearLayout mExpandContainerView;

    /* renamed from: G, reason: from kotlin metadata */
    private ImageView mExpandImageView;

    /* renamed from: H, reason: from kotlin metadata */
    private TextView mExpandTextView;

    /* renamed from: I, reason: from kotlin metadata */
    private GroupAlbumFeedDetailViewModel mAlbumViewModel;

    /* renamed from: J, reason: from kotlin metadata */
    private ArrayList<PictureItem> mOtherPictureItems;

    /* renamed from: K, reason: from kotlin metadata */
    private int mExpandState = 1;

    private final ArrayList<PictureItem> J() {
        Set of5;
        ArrayList<PictureItem> arrayList = new ArrayList<>();
        BusinessFeedData businessFeedData = this.f441565h;
        if ((businessFeedData != null ? businessFeedData.getPictureInfo() : null) == null || this.f441565h.getPictureInfo().pics == null) {
            return arrayList;
        }
        CellPictureInfo pictureInfo = this.f441565h.getPictureInfo();
        ArrayList<PictureItem> arrayList2 = pictureInfo.pics;
        Intrinsics.checkNotNullExpressionValue(arrayList2, "feedPictureInfos.pics");
        of5 = SetsKt__SetsJVMKt.setOf(null);
        TypeIntrinsics.asMutableCollection(arrayList2).removeAll(of5);
        ArrayList<PictureItem> arrayList3 = pictureInfo.pics;
        Intrinsics.checkNotNullExpressionValue(arrayList3, "feedPictureInfos.pics");
        return arrayList3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:10:0x0038, code lost:
    
        if (r0 != 4) goto L15;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void K(UIStateData<ArrayList<PictureItem>> listUIStateData) {
        QLog.i("GroupAlbumFeedMorePicPresenter", 1, "handleBatchListRsp()  state = " + listUIStateData.getState());
        LinearLayout linearLayout = this.mExpandContainerView;
        if (linearLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mExpandContainerView");
            linearLayout = null;
        }
        linearLayout.setEnabled(true);
        int state = listUIStateData.getState();
        if (state != 0) {
            if (state == 2 || state == 3) {
                L(listUIStateData);
            }
            if (listUIStateData.getIsLoadMore() || !listUIStateData.getIsFinish()) {
            }
            Q(3);
            return;
        }
        P();
        if (listUIStateData.getIsLoadMore()) {
        }
    }

    private final void L(UIStateData<ArrayList<PictureItem>> uiStateData) {
        if (uiStateData.getData() == null) {
            return;
        }
        ArrayList<PictureItem> data = uiStateData.getData();
        Intrinsics.checkNotNull(data);
        R(data);
    }

    private final void M() {
        GroupAlbumFeedDetailViewModel groupAlbumFeedDetailViewModel = (GroupAlbumFeedDetailViewModel) r(GroupAlbumFeedDetailViewModel.class);
        this.mAlbumViewModel = groupAlbumFeedDetailViewModel;
        if (groupAlbumFeedDetailViewModel != null) {
            Intrinsics.checkNotNull(groupAlbumFeedDetailViewModel);
            MutableLiveData<UIStateData<ArrayList<PictureItem>>> j26 = groupAlbumFeedDetailViewModel.j2();
            BasePartFragment p16 = p();
            final Function1<UIStateData<ArrayList<PictureItem>>, Unit> function1 = new Function1<UIStateData<ArrayList<PictureItem>>, Unit>() { // from class: com.qzone.reborn.groupalbum.section.feed.GroupAlbumFeedMorePicPresenter$initViewModel$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(UIStateData<ArrayList<PictureItem>> uIStateData) {
                    invoke2(uIStateData);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(UIStateData<ArrayList<PictureItem>> it) {
                    GroupAlbumFeedMorePicPresenter groupAlbumFeedMorePicPresenter = GroupAlbumFeedMorePicPresenter.this;
                    Intrinsics.checkNotNullExpressionValue(it, "it");
                    groupAlbumFeedMorePicPresenter.K(it);
                }
            };
            j26.observe(p16, new Observer() { // from class: com.qzone.reborn.groupalbum.section.feed.f
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    GroupAlbumFeedMorePicPresenter.N(Function1.this, obj);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void N(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void O() {
        LinearLayout linearLayout = this.mExpandContainerView;
        if (linearLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mExpandContainerView");
            linearLayout = null;
        }
        linearLayout.setEnabled(false);
        GroupAlbumFeedDetailViewModel groupAlbumFeedDetailViewModel = this.mAlbumViewModel;
        if (groupAlbumFeedDetailViewModel != null) {
            groupAlbumFeedDetailViewModel.z2(true);
        }
    }

    private final void Q(int state) {
        this.mExpandState = state;
        LinearLayout linearLayout = this.mExpandContainerView;
        TextView textView = null;
        if (linearLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mExpandContainerView");
            linearLayout = null;
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) linearLayout.getLayoutParams();
        if (state == 1) {
            ImageView imageView = this.mExpandImageView;
            if (imageView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mExpandImageView");
                imageView = null;
            }
            rn.h.a(imageView, "qui_chevron_down", R.color.qui_common_icon_secondary);
            TextView textView2 = this.mExpandTextView;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mExpandTextView");
            } else {
                textView = textView2;
            }
            textView.setText(com.qzone.util.l.a(R.string.rhl));
            if (marginLayoutParams == null) {
                return;
            }
            marginLayoutParams.topMargin = M;
            return;
        }
        if (state != 3) {
            return;
        }
        ImageView imageView2 = this.mExpandImageView;
        if (imageView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mExpandImageView");
            imageView2 = null;
        }
        rn.h.a(imageView2, "qui_chevron_up", R.color.qui_common_icon_secondary);
        TextView textView3 = this.mExpandTextView;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mExpandTextView");
        } else {
            textView = textView3;
        }
        textView.setText(com.qzone.util.l.a(R.string.rhb));
        if (marginLayoutParams == null) {
            return;
        }
        marginLayoutParams.topMargin = N;
    }

    private final void R(ArrayList<PictureItem> picItems) {
        CellPictureInfo pictureInfo;
        ArrayList<PictureItem> arrayList;
        BusinessFeedData businessFeedData = this.f441565h;
        if (businessFeedData != null && (pictureInfo = businessFeedData.getPictureInfo()) != null && (arrayList = pictureInfo.pics) != null) {
            arrayList.addAll(picItems);
        }
        GroupAlbumFeedDetailViewModel groupAlbumFeedDetailViewModel = this.mAlbumViewModel;
        if (groupAlbumFeedDetailViewModel != null) {
            groupAlbumFeedDetailViewModel.J2(this.f441565h, true);
        }
    }

    private final void S() {
        CellPictureInfo pictureInfo;
        ArrayList<PictureItem> arrayList;
        this.mOtherPictureItems = new ArrayList<>();
        ArrayList<PictureItem> arrayList2 = new ArrayList<>();
        int i3 = 0;
        for (Object obj : J()) {
            int i16 = i3 + 1;
            if (i3 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            PictureItem pictureItem = (PictureItem) obj;
            if (i3 < 9) {
                arrayList2.add(pictureItem);
            } else {
                ArrayList<PictureItem> arrayList3 = this.mOtherPictureItems;
                if (arrayList3 != null) {
                    arrayList3.add(pictureItem);
                }
            }
            i3 = i16;
        }
        BusinessFeedData businessFeedData = this.f441565h;
        if (businessFeedData != null && (pictureInfo = businessFeedData.getPictureInfo()) != null && (arrayList = pictureInfo.pics) != null) {
            arrayList.clear();
        }
        R(arrayList2);
    }

    @Override // vg.a
    protected void C(View containerView) {
        Intrinsics.checkNotNullParameter(containerView, "containerView");
        View findViewById = containerView.findViewById(R.id.f162838mw4);
        Intrinsics.checkNotNullExpressionValue(findViewById, "containerView.findViewBy\u2026ore_pic_expand_container)");
        this.mExpandContainerView = (LinearLayout) findViewById;
        View findViewById2 = containerView.findViewById(R.id.mw5);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "containerView.findViewBy\u2026eed_more_pic_expand_icon)");
        this.mExpandImageView = (ImageView) findViewById2;
        View findViewById3 = containerView.findViewById(R.id.mw6);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "containerView.findViewBy\u2026eed_more_pic_expand_text)");
        this.mExpandTextView = (TextView) findViewById3;
        LinearLayout linearLayout = this.mExpandContainerView;
        LinearLayout linearLayout2 = null;
        if (linearLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mExpandContainerView");
            linearLayout = null;
        }
        linearLayout.setOnClickListener(this);
        LinearLayout linearLayout3 = this.mExpandContainerView;
        if (linearLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mExpandContainerView");
        } else {
            linearLayout2 = linearLayout3;
        }
        linearLayout2.setBackgroundResource(com.qzone.reborn.util.k.f59549a.f() ? R.drawable.f153344 : R.drawable.f153243);
        Q(1);
        M();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // vg.a
    /* renamed from: k */
    public String getTAG() {
        return "GroupAlbumFeedMorePicPresenter";
    }

    @Override // vg.a
    protected int s() {
        return R.id.nnu;
    }

    @Override // vg.a
    protected boolean x() {
        return false;
    }

    @Override // vg.a
    protected void A(BusinessFeedData feedData) {
        if (feedData != null && J().size() > 9) {
            LinearLayout linearLayout = this.mExpandContainerView;
            LinearLayout linearLayout2 = null;
            if (linearLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mExpandContainerView");
                linearLayout = null;
            }
            linearLayout.setEnabled(true);
            LinearLayout linearLayout3 = this.mExpandContainerView;
            if (linearLayout3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mExpandContainerView");
            } else {
                linearLayout2 = linearLayout3;
            }
            linearLayout2.setVisibility(0);
            String str = feedData.cellGroupAlbumInfo.groupId;
            Intrinsics.checkNotNullExpressionValue(str, "feedData.cellGroupAlbumInfo.groupId");
            GroupAlbumAlbumDetailInitBean groupAlbumAlbumDetailInitBean = new GroupAlbumAlbumDetailInitBean(str);
            String str2 = feedData.cellPictureInfo.albumid;
            Intrinsics.checkNotNullExpressionValue(str2, "feedData.cellPictureInfo.albumid");
            groupAlbumAlbumDetailInitBean.setAlbumId(str2);
            groupAlbumAlbumDetailInitBean.setBatchId(feedData.cellPictureInfo.batchId);
            GroupAlbumFeedDetailViewModel groupAlbumFeedDetailViewModel = this.mAlbumViewModel;
            if (groupAlbumFeedDetailViewModel != null) {
                groupAlbumFeedDetailViewModel.G2(groupAlbumAlbumDetailInitBean);
            }
            if (this.mExpandState == 1) {
                S();
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        MutableLiveData<UIStateData<ArrayList<PictureItem>>> j26;
        UIStateData<ArrayList<PictureItem>> uIStateData = null;
        Integer valueOf = view != null ? Integer.valueOf(view.getId()) : null;
        if (valueOf == null || valueOf.intValue() != R.id.f162838mw4 || com.qzone.reborn.util.e.a("GroupAlbumFeedMorePicPresenterclickExpand")) {
            return;
        }
        if (this.mExpandState == 3) {
            Q(1);
            R(new ArrayList<>());
            ai.d dVar = (ai.d) j(ai.d.class);
            if (dVar != null) {
                dVar.t1();
                return;
            }
            return;
        }
        Q(3);
        ArrayList<PictureItem> arrayList = this.mOtherPictureItems;
        if (arrayList != null) {
            Intrinsics.checkNotNull(arrayList);
            R(arrayList);
            ArrayList<PictureItem> arrayList2 = this.mOtherPictureItems;
            if (arrayList2 != null) {
                arrayList2.clear();
            }
        }
        GroupAlbumFeedDetailViewModel groupAlbumFeedDetailViewModel = this.mAlbumViewModel;
        if (groupAlbumFeedDetailViewModel != null && (j26 = groupAlbumFeedDetailViewModel.j2()) != null) {
            uIStateData = j26.getValue();
        }
        if (uIStateData != null) {
            O();
        }
    }

    private final void P() {
    }
}
