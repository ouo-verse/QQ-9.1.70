package com.tencent.mobileqq.matchfriend.reborn.content.main;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.app.QBaseFragment;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.matchfriend.reborn.content.main.framework.part.MainTitleBarPart;
import com.tencent.mobileqq.matchfriend.reborn.content.main.framework.part.QQStrangerSquareListPart;
import com.tencent.mobileqq.matchfriend.reborn.content.main.framework.part.QQStrangerSquareReportPart;
import com.tencent.mobileqq.matchfriend.reborn.content.main.framework.part.h;
import com.tencent.mobileqq.matchfriend.reborn.content.main.framework.part.j;
import com.tencent.mobileqq.matchfriend.reborn.content.main.framework.part.l;
import com.tencent.mobileqq.matchfriend.reborn.content.main.framework.part.s;
import com.tencent.mobileqq.matchfriend.reborn.content.main.framework.widget.MainPageViewBinding;
import com.tencent.mobileqq.matchfriend.reborn.content.main.matching.QQStrangerMatchingPart;
import com.tencent.mobileqq.matchfriend.reborn.content.main.matching.surprise.QQStrangerSurpriseMatchingPart;
import com.tencent.mobileqq.matchfriend.reborn.publish.anim.k;
import com.tencent.mobileqq.matchfriend.reborn.register.guest.QQStrangerGuestCheckPart;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0011\u0010\u0012J$\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\u0010\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nH\u0016R\u0016\u0010\u0010\u001a\u00020\r8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/matchfriend/reborn/content/main/QQStrangerMainFragment;", "Lcom/tencent/mobileqq/app/QBaseFragment;", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "Landroid/view/View;", "onCreateView", "", "Lcom/tencent/biz/richframework/part/Part;", "assembleParts", "Lcom/tencent/mobileqq/matchfriend/reborn/content/main/framework/widget/MainPageViewBinding;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/matchfriend/reborn/content/main/framework/widget/MainPageViewBinding;", "mainViewBinding", "<init>", "()V", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class QQStrangerMainFragment extends QBaseFragment {

    /* renamed from: C, reason: from kotlin metadata */
    private MainPageViewBinding mainViewBinding;

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        Context context = inflater.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "inflater.context");
        MainPageViewBinding mainPageViewBinding = new MainPageViewBinding(context);
        this.mainViewBinding = mainPageViewBinding;
        return mainPageViewBinding.getRoot();
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public List<Part> assembleParts() {
        List<Part> mutableListOf;
        Part[] partArr = new Part[12];
        partArr[0] = new QQStrangerSquareReportPart();
        partArr[1] = new h();
        MainPageViewBinding mainPageViewBinding = this.mainViewBinding;
        MainPageViewBinding mainPageViewBinding2 = null;
        if (mainPageViewBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mainViewBinding");
            mainPageViewBinding = null;
        }
        partArr[2] = new QQStrangerSquareListPart(mainPageViewBinding);
        MainPageViewBinding mainPageViewBinding3 = this.mainViewBinding;
        if (mainPageViewBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mainViewBinding");
        } else {
            mainPageViewBinding2 = mainPageViewBinding3;
        }
        partArr[3] = new MainTitleBarPart(mainPageViewBinding2);
        partArr[4] = new QQStrangerMatchingPart();
        partArr[5] = new j();
        partArr[6] = new s();
        partArr[7] = new QQStrangerSurpriseMatchingPart();
        partArr[8] = new l();
        partArr[9] = new k("qqstranger_feed");
        partArr[10] = new QQStrangerGuestCheckPart();
        partArr[11] = new com.tencent.mobileqq.matchfriend.reborn.content.main.framework.part.k();
        mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(partArr);
        return mutableListOf;
    }
}
