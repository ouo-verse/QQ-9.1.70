package com.tencent.mobileqq.zplan.friend.changerole.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.mvvm.h;
import com.tencent.mobileqq.zootopia.ZootopiaSource;
import com.tencent.mobileqq.zplan.friend.changerole.model.a;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.fragment.ZootopiaBaseFragment;
import fi3.ba;
import java.util.ArrayList;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppActivity;
import mqq.app.AppRuntime;
import mqq.app.Constants;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 '2\u00020\u0001:\u0001(B\u0007\u00a2\u0006\u0004\b%\u0010&J\b\u0010\u0003\u001a\u00020\u0002H\u0014J\u0012\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J&\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\t\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\b\u0010\u000f\u001a\u00020\u000eH\u0016J\b\u0010\u0010\u001a\u00020\u0006H\u0016J\u0006\u0010\u0011\u001a\u00020\u0006R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u001b\u0010\u001f\u001a\u00020\u001a8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u001b\u0010$\u001a\u00020 8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b!\u0010\u001c\u001a\u0004\b\"\u0010#\u00a8\u0006)"}, d2 = {"Lcom/tencent/mobileqq/zplan/friend/changerole/view/ZPlanChangeRoleFragment;", "Lcom/tencent/sqshow/fragment/ZootopiaBaseFragment;", "", "getSubSource", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "", "onCreate", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/view/View;", "onCreateView", "", "onBackPressedEvent", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "initData", "Lcom/tencent/common/app/AppInterface;", "N", "Lcom/tencent/common/app/AppInterface;", "app", "Lfi3/ba;", "P", "Lfi3/ba;", "binding", "Lcom/tencent/mobileqq/zplan/friend/changerole/model/a;", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Lkotlin/Lazy;", "Ih", "()Lcom/tencent/mobileqq/zplan/friend/changerole/model/a;", "friendSelectStateModel", "Lwh3/h;", BdhLogUtil.LogTag.Tag_Req, "Hh", "()Lwh3/h;", "binder", "<init>", "()V", ExifInterface.LATITUDE_SOUTH, "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class ZPlanChangeRoleFragment extends ZootopiaBaseFragment {

    /* renamed from: N, reason: from kotlin metadata */
    private AppInterface app;

    /* renamed from: P, reason: from kotlin metadata */
    private ba binding;

    /* renamed from: Q, reason: from kotlin metadata */
    private final Lazy friendSelectStateModel;

    /* renamed from: R, reason: from kotlin metadata */
    private final Lazy binder;

    public ZPlanChangeRoleFragment() {
        Lazy lazy;
        Lazy lazy2;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<a>() { // from class: com.tencent.mobileqq.zplan.friend.changerole.view.ZPlanChangeRoleFragment$friendSelectStateModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final a invoke() {
                return (a) h.a(ZPlanChangeRoleFragment.this.requireActivity()).get(a.class);
            }
        });
        this.friendSelectStateModel = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<wh3.h>() { // from class: com.tencent.mobileqq.zplan.friend.changerole.view.ZPlanChangeRoleFragment$binder$2
            @Override // kotlin.jvm.functions.Function0
            public final wh3.h invoke() {
                return new wh3.h();
            }
        });
        this.binder = lazy2;
    }

    private final wh3.h Hh() {
        return (wh3.h) this.binder.getValue();
    }

    private final a Ih() {
        return (a) this.friendSelectStateModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.sqshow.fragment.ZootopiaBaseFragment
    public String getSubSource() {
        return ZootopiaSource.SUB_SOURCE_CHANGE_ROLE;
    }

    public final void initData() {
        FragmentActivity requireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
        if (requireActivity instanceof AppActivity) {
            AppRuntime appRuntime = ((AppActivity) requireActivity).getAppRuntime();
            Intrinsics.checkNotNull(appRuntime, "null cannot be cast to non-null type com.tencent.common.app.AppInterface");
            this.app = (AppInterface) appRuntime;
        }
        Bundle arguments = getArguments();
        ArrayList<Integer> integerArrayList = arguments != null ? arguments.getIntegerArrayList("pre_selection_sex") : null;
        Bundle arguments2 = getArguments();
        boolean z16 = arguments2 != null ? arguments2.getBoolean("in_little_world_scene") : false;
        Bundle arguments3 = getArguments();
        ArrayList<String> stringArrayList = arguments3 != null ? arguments3.getStringArrayList("pre_selection") : null;
        Bundle arguments4 = getArguments();
        String string = arguments4 != null ? arguments4.getString("template_id") : null;
        QLog.i("ZootopiaBaseFragment", 1, this + " initData " + integerArrayList + " and " + stringArrayList + " and " + string + " and " + z16);
        Hh().q(z16);
        Ih().d2(this.app);
        Ih().f2(integerArrayList);
        Ih().g2(stringArrayList);
        Ih().i2(string);
    }

    @Override // com.tencent.mobileqq.zootopia.api.b
    public boolean onBackPressedEvent() {
        return false;
    }

    @Override // com.tencent.sqshow.fragment.ZootopiaBaseFragment, com.tencent.sqshow.fragment.ZPlanPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initData();
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        super.onCreateView(inflater, container, savedInstanceState);
        ba g16 = ba.g(inflater, container, false);
        this.binding = g16;
        if (g16 != null) {
            wh3.h Hh = Hh();
            LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
            Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "viewLifecycleOwner");
            FragmentActivity requireActivity = requireActivity();
            Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
            a friendSelectStateModel = Ih();
            Intrinsics.checkNotNullExpressionValue(friendSelectStateModel, "friendSelectStateModel");
            Hh.j(viewLifecycleOwner, requireActivity, g16, friendSelectStateModel);
        }
        ba baVar = this.binding;
        if (baVar != null) {
            return baVar.getRoot();
        }
        return null;
    }

    @Override // com.tencent.sqshow.fragment.ZootopiaBaseFragment, com.tencent.sqshow.fragment.ZPlanPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        this.binding = null;
        super.onDestroy();
    }
}
