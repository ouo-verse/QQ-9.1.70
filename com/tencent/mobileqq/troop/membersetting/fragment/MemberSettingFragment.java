package com.tencent.mobileqq.troop.membersetting.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.ViewModel;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.pad.d;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.membersetting.ITroopMemberSettingApi;
import com.tencent.mobileqq.troop.membersetting.part.MemberSettingAuthorityManagePart;
import com.tencent.mobileqq.troop.membersetting.part.MemberSettingFriendManagePart;
import com.tencent.mobileqq.troop.membersetting.part.MemberSettingGroupManagePart;
import com.tencent.mobileqq.troop.membersetting.part.MemberSettingMngObserverPart;
import com.tencent.mobileqq.troop.membersetting.part.MemberSettingQuitOrDisbandPart;
import com.tencent.mobileqq.troop.membersetting.part.MemberSettingTitlePart;
import com.tencent.mobileqq.troop.membersetting.part.ag;
import com.tencent.mobileqq.troop.membersetting.part.am;
import com.tencent.mobileqq.troop.membersetting.part.bk;
import com.tencent.mobileqq.troop.membersetting.part.t;
import com.tencent.mobileqq.troop.membersetting.part.w;
import com.tencent.mobileqq.widget.listitem.Group;
import com.tencent.mobileqq.widget.listitem.QUIListItemAdapter;
import com.tencent.mobileqq.widget.listitem.QUISettingsRecyclerView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import zs2.c;

/* compiled from: P */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u00012\u00020\u0002B\u0007\u00a2\u0006\u0004\b.\u0010/J\u000e\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0002J\u000e\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0002J\u000e\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0002J\b\u0010\t\u001a\u00020\bH\u0002J\u0012\u0010\f\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016J$\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016J\u000e\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0016J\u001a\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u00112\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0014J\u0006\u0010\u0017\u001a\u00020\u0016J\b\u0010\u0018\u001a\u00020\bH\u0016J\b\u0010\u0019\u001a\u00020\bH\u0016J\b\u0010\u001b\u001a\u00020\u001aH\u0016J\b\u0010\u001c\u001a\u00020\u001aH\u0016R\u0016\u0010 \u001a\u00020\u001d8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010#\u001a\u00020\u00118\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010&\u001a\u00020\u00168\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u0018\u0010*\u001a\u0004\u0018\u00010'8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b(\u0010)R\u001c\u0010-\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b+\u0010,\u00a8\u00060"}, d2 = {"Lcom/tencent/mobileqq/troop/membersetting/fragment/MemberSettingFragment;", "Lcom/tencent/mobileqq/fragment/QPublicBaseFragment;", "Lcom/tencent/mobileqq/pad/d;", "", "Lcom/tencent/biz/richframework/part/Part;", "qh", "rh", "sh", "", "ph", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onCreate", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/view/View;", "onCreateView", "assembleParts", "contentView", "onViewCreatedAfterPartInit", "Lcom/tencent/mobileqq/widget/listitem/QUISettingsRecyclerView;", "th", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "onResume", "", "shouldDispatchActivityResult", "shouldDispatchPostThemeChanged", "Lzs2/c;", BdhLogUtil.LogTag.Tag_Conn, "Lzs2/c;", "viewModel", "D", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "E", "Lcom/tencent/mobileqq/widget/listitem/QUISettingsRecyclerView;", "recycleView", "Lcom/tencent/mobileqq/widget/listitem/QUIListItemAdapter;", UserInfo.SEX_FEMALE, "Lcom/tencent/mobileqq/widget/listitem/QUIListItemAdapter;", "adapter", "G", "Ljava/util/List;", "parts", "<init>", "()V", "base_proj_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class MemberSettingFragment extends QPublicBaseFragment implements d {

    /* renamed from: C, reason: from kotlin metadata */
    private c viewModel;

    /* renamed from: D, reason: from kotlin metadata */
    private View rootView;

    /* renamed from: E, reason: from kotlin metadata */
    private QUISettingsRecyclerView recycleView;

    /* renamed from: F, reason: from kotlin metadata */
    private QUIListItemAdapter adapter;

    /* renamed from: G, reason: from kotlin metadata */
    private List<Part> parts = new ArrayList();

    private final void ph() {
        ArrayList arrayList = new ArrayList();
        for (Part part : this.parts) {
            if (part instanceof t) {
                CollectionsKt__MutableCollectionsKt.addAll(arrayList, ((t) part).getGroups());
            }
        }
        QUIListItemAdapter qUIListItemAdapter = this.adapter;
        if (qUIListItemAdapter != null) {
            Object[] array = arrayList.toArray(new Group[0]);
            Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
            Group[] groupArr = (Group[]) array;
            qUIListItemAdapter.t0((Group[]) Arrays.copyOf(groupArr, groupArr.length));
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public List<Part> assembleParts() {
        ArrayList arrayList = new ArrayList();
        c cVar = this.viewModel;
        if (cVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            cVar = null;
        }
        int cardType = cVar.Q1().getCardType();
        if (cardType == 0) {
            arrayList.addAll(qh());
        } else if (cardType == 1) {
            arrayList.addAll(rh());
        } else if (cardType == 2) {
            arrayList.addAll(sh());
        }
        this.parts = arrayList;
        return arrayList;
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ViewModel viewModel = getViewModel(c.class);
        c cVar = (c) viewModel;
        Bundle arguments = getArguments();
        if (arguments == null) {
            arguments = new Bundle();
        }
        Intrinsics.checkNotNullExpressionValue(arguments, "arguments ?: Bundle()");
        cVar.init(arguments);
        cVar.onCreate();
        Intrinsics.checkNotNullExpressionValue(viewModel, "getViewModel(MemberSetti\u2026     onCreate()\n        }");
        this.viewModel = cVar;
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        View inflate = inflater.inflate(R.layout.f1272102, container, false);
        inflate.setBackgroundResource(R.drawable.qui_common_bg_bottom_standard_bg);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflater.inflate(R.layou\u2026om_standard_bg)\n        }");
        this.rootView = inflate;
        View findViewById = inflate.findViewById(R.id.f18222e);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.\u2026op_setting_recycler_view)");
        this.recycleView = (QUISettingsRecyclerView) findViewById;
        this.adapter = new QUIListItemAdapter(null, false, true, 3, null);
        QUISettingsRecyclerView qUISettingsRecyclerView = this.recycleView;
        if (qUISettingsRecyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recycleView");
            qUISettingsRecyclerView = null;
        }
        qUISettingsRecyclerView.setAdapter(this.adapter);
        View view = this.rootView;
        if (view != null) {
            return view;
        }
        Intrinsics.throwUninitializedPropertyAccessException(MosaicConstants$JsProperty.PROP_ROOT_VIEW);
        return null;
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        c cVar = this.viewModel;
        if (cVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            cVar = null;
        }
        cVar.onDestroy();
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        c cVar = this.viewModel;
        c cVar2 = null;
        if (cVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            cVar = null;
        }
        cVar.onResume();
        c cVar3 = this.viewModel;
        if (cVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            cVar3 = null;
        }
        if (cVar3.Q1().getIsFirstEnter()) {
            long currentTimeMillis = System.currentTimeMillis();
            c cVar4 = this.viewModel;
            if (cVar4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                cVar4 = null;
            }
            ((ITroopMemberSettingApi) QRoute.api(ITroopMemberSettingApi.class)).doReport("member_setting_new", String.valueOf(currentTimeMillis - cVar4.Q1().getClickTime()));
            c cVar5 = this.viewModel;
            if (cVar5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            } else {
                cVar2 = cVar5;
            }
            cVar2.Q1().Q(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.BasePartFragment
    public void onViewCreatedAfterPartInit(View contentView, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(contentView, "contentView");
        super.onViewCreatedAfterPartInit(contentView, savedInstanceState);
        ph();
    }

    @Override // com.tencent.mobileqq.pad.d
    public boolean shouldDispatchActivityResult() {
        return true;
    }

    @Override // com.tencent.mobileqq.pad.d
    public boolean shouldDispatchPostThemeChanged() {
        return false;
    }

    public final QUISettingsRecyclerView th() {
        QUISettingsRecyclerView qUISettingsRecyclerView = this.recycleView;
        if (qUISettingsRecyclerView != null) {
            return qUISettingsRecyclerView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("recycleView");
        return null;
    }

    private final List<Part> qh() {
        List<Part> mutableListOf;
        mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(new MemberSettingTitlePart(), new MemberSettingGroupManagePart(), new MemberSettingMngObserverPart());
        return mutableListOf;
    }

    private final List<Part> rh() {
        List<Part> mutableListOf;
        mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(new MemberSettingTitlePart(), new MemberSettingGroupManagePart(), new MemberSettingFriendManagePart(), new am(), new bk(), new MemberSettingAuthorityManagePart(), new MemberSettingQuitOrDisbandPart(), new ag(), new w(), new MemberSettingMngObserverPart());
        return mutableListOf;
    }

    private final List<Part> sh() {
        List<Part> mutableListOf;
        mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(new MemberSettingTitlePart(), new MemberSettingGroupManagePart(), new MemberSettingFriendManagePart(), new am(), new MemberSettingAuthorityManagePart(), new MemberSettingQuitOrDisbandPart(), new w(), new MemberSettingMngObserverPart());
        return mutableListOf;
    }
}
