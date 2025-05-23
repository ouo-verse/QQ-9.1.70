package com.tencent.biz.qqcircle.share.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.tencent.biz.qqcircle.comment.at.bean.QFSCommentAtEntity;
import com.tencent.biz.qqcircle.immersive.QFSBaseFragment;
import com.tencent.biz.qqcircle.share.bean.QFSShareSelectMemberInitBean;
import com.tencent.biz.qqcircle.share.part.QFSShareSelectMemberHeaderPart;
import com.tencent.biz.qqcircle.share.part.QFSShareSelectMemberListPart;
import com.tencent.biz.qqcircle.share.part.QFSShareSelectMemberSearchPart;
import com.tencent.biz.qqcircle.share.part.QFSShareSelectMemberSenderPart;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.selectmember.ResultRecord;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import zb0.a;

/* compiled from: P */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001fB\u0007\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\u0016\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002J\u001c\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0002H\u0002J\b\u0010\u000b\u001a\u00020\nH\u0002J\u000e\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\fH\u0016J\u001c\u0010\u0013\u001a\u00020\u00052\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0014J\b\u0010\u0015\u001a\u00020\u0014H\u0014J\b\u0010\u0017\u001a\u00020\u0016H\u0016J\b\u0010\u0018\u001a\u00020\u0014H\u0016J\b\u0010\u0019\u001a\u00020\u0016H\u0014J\b\u0010\u001b\u001a\u00020\u001aH\u0014\u00a8\u0006 "}, d2 = {"Lcom/tencent/biz/qqcircle/share/fragment/QFSShareSelectMemberFragment;", "Lcom/tencent/biz/qqcircle/immersive/QFSBaseFragment;", "", "Lcom/tencent/biz/qqcircle/comment/at/bean/QFSCommentAtEntity;", "initSelectedList", "", "th", "Lcom/tencent/mobileqq/selectmember/ResultRecord;", "initList", "rh", "Lcom/tencent/biz/qqcircle/share/bean/QFSShareSelectMemberInitBean;", "sh", "", "Lcom/tencent/biz/richframework/part/Part;", "assembleParts", "Landroid/view/View;", "contentView", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onViewCreatedBeforePartInit", "", "getContentLayoutId", "", "getLogTag", "getPageId", "getDaTongPageId", "", "needSupportFullScreen", "<init>", "()V", "E", "a", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes5.dex */
public final class QFSShareSelectMemberFragment extends QFSBaseFragment {
    private final List<QFSCommentAtEntity> rh(List<? extends ResultRecord> initList) {
        List<QFSCommentAtEntity> list;
        ArrayList arrayList = new ArrayList();
        for (ResultRecord resultRecord : initList) {
            int i3 = resultRecord.uinType;
            if (i3 == 0 || i3 == 1 || i3 == 10008) {
                arrayList.add(new QFSCommentAtEntity(resultRecord.uin, null, resultRecord.name, 0, resultRecord.uinType));
            }
        }
        list = CollectionsKt___CollectionsKt.toList(arrayList);
        return list;
    }

    private final QFSShareSelectMemberInitBean sh() {
        Serializable serializable;
        Intent intent;
        FragmentActivity activity = getActivity();
        QFSShareSelectMemberInitBean qFSShareSelectMemberInitBean = null;
        if (activity != null && (intent = activity.getIntent()) != null) {
            serializable = intent.getSerializableExtra("key_bundle_common_init_bean");
        } else {
            serializable = null;
        }
        if (serializable instanceof QFSShareSelectMemberInitBean) {
            qFSShareSelectMemberInitBean = (QFSShareSelectMemberInitBean) serializable;
        }
        if (qFSShareSelectMemberInitBean == null) {
            return new QFSShareSelectMemberInitBean();
        }
        return qFSShareSelectMemberInitBean;
    }

    private final void th(List<? extends QFSCommentAtEntity> initSelectedList) {
        ((a) getViewModel(a.class)).N1().addAll(initSelectedList);
    }

    @Override // com.tencent.biz.richframework.part.interfaces.IPartHost
    @NotNull
    public List<Part> assembleParts() {
        String selectType = sh().getSelectType();
        ArrayList arrayList = new ArrayList();
        Intrinsics.checkNotNullExpressionValue(selectType, "selectType");
        arrayList.add(new QFSShareSelectMemberSenderPart(selectType));
        if (Intrinsics.areEqual(selectType, "select_type_friends")) {
            arrayList.add(new QFSShareSelectMemberHeaderPart());
        }
        arrayList.add(new QFSShareSelectMemberListPart(selectType));
        arrayList.add(new QFSShareSelectMemberSearchPart(selectType));
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.gsu;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.fragments.QCircleBaseFragment
    @NotNull
    public String getDaTongPageId() {
        String selectType = sh().getSelectType();
        if (Intrinsics.areEqual(selectType, "select_type_mutual_follow")) {
            return QCircleDaTongConstant.PageId.PG_XSJ_MUTUAL_FOLLOW_FRIEND_SELECT_PAGE;
        }
        if (Intrinsics.areEqual(selectType, "select_type_troops")) {
            return QCircleDaTongConstant.PageId.PG_XSJ_GROUP_SELECT_PAGE;
        }
        return QCircleDaTongConstant.PageId.PG_XSJ_FRIEND_SELECT_PAGE;
    }

    @Override // com.tencent.biz.qqcircle.fragments.QCircleBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    @NotNull
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QFSShareSelectMemberFragment";
    }

    @Override // com.tencent.biz.qqcircle.fragments.QCircleBaseFragment
    public int getPageId() {
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.immersive.QFSBaseFragment, com.tencent.biz.richframework.part.ImmersivePartFragment
    public boolean needSupportFullScreen() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.immersive.QFSBaseFragment, com.tencent.biz.qqcircle.fragments.QCircleBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public void onViewCreatedBeforePartInit(@Nullable View contentView, @Nullable Bundle savedInstanceState) {
        ArrayList arrayList;
        boolean z16;
        Intent intent;
        Intent intent2;
        Intent intent3;
        super.onViewCreatedBeforePartInit(contentView, savedInstanceState);
        FragmentActivity activity = getActivity();
        ArrayList arrayList2 = null;
        if (activity != null && (intent3 = activity.getIntent()) != null) {
            arrayList = intent3.getParcelableArrayListExtra("param_selected_item_list_from_panel");
        } else {
            arrayList = null;
        }
        boolean z17 = false;
        if (arrayList != null && !arrayList.isEmpty()) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!z16) {
            List<QFSCommentAtEntity> rh5 = rh(arrayList);
            if (!rh5.isEmpty()) {
                th(rh5);
                FragmentActivity activity2 = getActivity();
                if (activity2 != null && (intent2 = activity2.getIntent()) != null) {
                    intent2.removeExtra("param_selected_item_list_from_panel");
                    return;
                }
                return;
            }
            return;
        }
        FragmentActivity activity3 = getActivity();
        if (activity3 != null && (intent = activity3.getIntent()) != null) {
            arrayList2 = intent.getParcelableArrayListExtra("param_selected_item_list");
        }
        if (arrayList2 == null || arrayList2.isEmpty()) {
            z17 = true;
        }
        if (!z17) {
            th(arrayList2);
        }
    }
}
