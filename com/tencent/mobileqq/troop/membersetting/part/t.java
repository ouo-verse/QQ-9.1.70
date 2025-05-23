package com.tencent.mobileqq.troop.membersetting.part;

import android.app.Activity;
import android.os.Bundle;
import androidx.lifecycle.ViewModel;
import com.tencent.biz.richframework.part.Part;
import com.tencent.biz.richframework.part.interfaces.IPartHost;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.profilecard.base.report.ProfileCardBlacklistReportConst;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.troop.membersetting.fragment.MemberSettingFragment;
import com.tencent.mobileqq.widget.listitem.Group;
import com.tencent.mobileqq.widget.listitem.QUIListItemAdapter;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.Constants;
import mqq.app.MobileQQ;

/* compiled from: P */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b#\u0010$J\u001c\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\b\u0010\t\u001a\u00020\bH\u0016J\u0015\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0016\u00a2\u0006\u0004\b\f\u0010\rJ\u0012\u0010\u0010\u001a\u00020\u00062\n\u0010\u000f\u001a\u0006\u0012\u0002\b\u00030\u000eJ\u001a\u0010\u0013\u001a\u00020\u00062\n\u0010\u000f\u001a\u0006\u0012\u0002\b\u00030\u000e2\u0006\u0010\u0012\u001a\u00020\u0011J\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00150\u0014R\"\u0010\u001e\u001a\u00020\u00178\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u0011\u0010\"\u001a\u00020\u001f8F\u00a2\u0006\u0006\u001a\u0004\b \u0010!\u00a8\u0006%"}, d2 = {"Lcom/tencent/mobileqq/troop/membersetting/part/t;", "Lcom/tencent/biz/richframework/part/Part;", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "", "onPartCreate", "Lcom/tencent/mobileqq/troop/membersetting/fragment/MemberSettingFragment;", "B9", "", "Lcom/tencent/mobileqq/widget/listitem/Group;", "H9", "()[Lcom/tencent/mobileqq/widget/listitem/Group;", "Lcom/tencent/mobileqq/widget/listitem/a;", DownloadInfo.spKey_Config, "D9", "", "isVisible", "F9", "Ljava/util/HashMap;", "", "A9", "Lzs2/c;", "d", "Lzs2/c;", "C9", "()Lzs2/c;", "G9", "(Lzs2/c;)V", "viewModel", "Lcom/tencent/common/app/AppInterface;", "z9", "()Lcom/tencent/common/app/AppInterface;", "app", "<init>", "()V", "base_proj_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public class t extends Part {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public zs2.c viewModel;

    /* JADX INFO: Access modifiers changed from: private */
    public static final void E9(t this$0, com.tencent.mobileqq.widget.listitem.a config) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(config, "$config");
        QUIListItemAdapter adapter = this$0.getPartHost().th().getAdapter();
        if (adapter != null) {
            adapter.l0(config);
        }
    }

    public final HashMap<String, String> A9() {
        HashMap<String, String> hashMap = new HashMap<>();
        AllInOne allInOne = C9().Q1().getAllInOne();
        if (Intrinsics.areEqual(allInOne != null ? allInOne.uin : null, z9().getCurrentAccountUin())) {
            hashMap.put(ProfileCardBlacklistReportConst.PAGE_PARAM_USERPROFILE_SETTING_HOST_GUEST_TYPE, "1");
        } else {
            hashMap.put(ProfileCardBlacklistReportConst.PAGE_PARAM_USERPROFILE_SETTING_HOST_GUEST_TYPE, "2");
            AllInOne allInOne2 = C9().Q1().getAllInOne();
            if (allInOne2 != null) {
                String str = allInOne2.uin;
                Intrinsics.checkNotNullExpressionValue(str, "it.uin");
                hashMap.put("to_uin", str);
            }
        }
        return hashMap;
    }

    @Override // com.tencent.biz.richframework.part.Part
    /* renamed from: B9, reason: merged with bridge method [inline-methods] */
    public MemberSettingFragment getPartHost() {
        IPartHost partHost = super.getPartHost();
        Intrinsics.checkNotNull(partHost, "null cannot be cast to non-null type com.tencent.mobileqq.troop.membersetting.fragment.MemberSettingFragment");
        return (MemberSettingFragment) partHost;
    }

    public final zs2.c C9() {
        zs2.c cVar = this.viewModel;
        if (cVar != null) {
            return cVar;
        }
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        return null;
    }

    public final void D9(final com.tencent.mobileqq.widget.listitem.a<?> config) {
        Intrinsics.checkNotNullParameter(config, "config");
        getPartHost().th().post(new Runnable() { // from class: com.tencent.mobileqq.troop.membersetting.part.s
            @Override // java.lang.Runnable
            public final void run() {
                t.E9(t.this, config);
            }
        });
    }

    public final void F9(com.tencent.mobileqq.widget.listitem.a<?> config, boolean isVisible) {
        Intrinsics.checkNotNullParameter(config, "config");
        QUIListItemAdapter adapter = getPartHost().th().getAdapter();
        if (adapter != null) {
            adapter.m0(config, isVisible);
        }
    }

    public final void G9(zs2.c cVar) {
        Intrinsics.checkNotNullParameter(cVar, "<set-?>");
        this.viewModel = cVar;
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartCreate(Activity activity, Bundle savedInstanceState) {
        super.onPartCreate(activity, savedInstanceState);
        ViewModel viewModel = getViewModel(zs2.c.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "getViewModel(MemberSettingViewModel::class.java)");
        G9((zs2.c) viewModel);
    }

    public final AppInterface z9() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        Intrinsics.checkNotNull(peekAppRuntime, "null cannot be cast to non-null type com.tencent.common.app.AppInterface");
        return (AppInterface) peekAppRuntime;
    }

    public Group[] H9() {
        return new Group[0];
    }
}
