package com.tencent.mobileqq.matchfriend.reborn.register.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModel;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.matchfriend.reborn.register.part.QQStrangerRegisterBottomPart;
import com.tencent.mobileqq.matchfriend.reborn.register.part.QQStrangerRegisterTagContentPart;
import com.tencent.mobileqq.matchfriend.reborn.register.part.ad;
import com.tencent.mobileqq.matchfriend.reborn.register.part.b;
import com.tencent.qqlive.module.videoreport.PageParams;
import com.tencent.trpcprotocol.kuolie.user_info.user_info.userInfo$Birthday;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import v82.c;
import y82.a;

/* compiled from: P */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001cB\u0007\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\b\u001a\u00020\u0006H\u0016J\u000e\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0016J$\u0010\u0013\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016J\u0012\u0010\u0014\u001a\u00020\u00042\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016R\u0016\u0010\u0018\u001a\u00020\u00158\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/mobileqq/matchfriend/reborn/register/fragment/QQStrangerRegisterTagFragment;", "Lcom/tencent/mobileqq/fragment/QPublicBaseFragment;", "Landroid/content/Intent;", "intent", "", "initData", "", "needStatusTrans", "needImmersive", "", "Lcom/tencent/biz/richframework/part/Part;", "assembleParts", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "Landroid/view/View;", "onCreateView", "onCreate", "Lv82/c;", BdhLogUtil.LogTag.Tag_Conn, "Lv82/c;", "viewModel", "<init>", "()V", "D", "a", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class QQStrangerRegisterTagFragment extends QPublicBaseFragment {

    /* renamed from: C, reason: from kotlin metadata */
    private c viewModel;

    private final void initData(Intent intent) {
        c cVar = this.viewModel;
        c cVar2 = null;
        if (cVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            cVar = null;
        }
        cVar.X1(intent.getBooleanExtra("key_is_new_user", true));
        c cVar3 = this.viewModel;
        if (cVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            cVar3 = null;
        }
        cVar3.P1().setValue(Short.valueOf(intent.getShortExtra("key_register_gender", (short) 0)));
        userInfo$Birthday userinfo_birthday = new userInfo$Birthday();
        userinfo_birthday.mergeFrom(intent.getByteArrayExtra("key_register_birthday"));
        c cVar4 = this.viewModel;
        if (cVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            cVar4 = null;
        }
        cVar4.M1().setValue(userinfo_birthday);
        c cVar5 = this.viewModel;
        if (cVar5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            cVar5 = null;
        }
        String stringExtra = intent.getStringExtra("key_register_nickname");
        if (stringExtra == null) {
            stringExtra = "";
        }
        cVar5.Z1(stringExtra);
        c cVar6 = this.viewModel;
        if (cVar6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            cVar6 = null;
        }
        String stringExtra2 = intent.getStringExtra("key_register_avatar_url");
        if (stringExtra2 == null) {
            stringExtra2 = "";
        }
        cVar6.W1(stringExtra2);
        c cVar7 = this.viewModel;
        if (cVar7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            cVar7 = null;
        }
        String stringExtra3 = intent.getStringExtra("key_open_id");
        cVar7.a2(stringExtra3 != null ? stringExtra3 : "");
        c cVar8 = this.viewModel;
        if (cVar8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        } else {
            cVar2 = cVar8;
        }
        cVar2.O1().postValue("\u8fdb\u5165\u7ed3\u4f34");
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public List<Part> assembleParts() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new b());
        arrayList.add(new ad());
        arrayList.add(new QQStrangerRegisterTagContentPart());
        c cVar = this.viewModel;
        if (cVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            cVar = null;
        }
        arrayList.add(new QQStrangerRegisterBottomPart(cVar));
        return arrayList;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean needImmersive() {
        return false;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean needStatusTrans() {
        return true;
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        Intent intent;
        super.onCreate(savedInstanceState);
        ViewModel viewModel = getViewModel(c.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "getViewModel(QQStrangerRegisterTagVM::class.java)");
        this.viewModel = (c) viewModel;
        FragmentActivity activity = getActivity();
        if (activity == null || (intent = activity.getIntent()) == null) {
            return;
        }
        initData(intent);
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Map mutableMapOf;
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        View rootView = inflater.inflate(R.layout.f167368cy2, container, false);
        c cVar = this.viewModel;
        if (cVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            cVar = null;
        }
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("member_type", Integer.valueOf(cVar.getIsNewUser() ? 1 : 2)), TuplesKt.to("select_page_type", 2));
        a.b().c(getActivity(), rootView, "pg_bas_expand_first_registration", new PageParams((Map<String, ?>) mutableMapOf));
        Intrinsics.checkNotNullExpressionValue(rootView, "rootView");
        return rootView;
    }
}
