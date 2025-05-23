package com.tencent.timi.game.jump.api.impl.qqlive;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.activity.QPublicTransFragmentActivity;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.qqlive.api.IQQLiveUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.timi.game.ui.widget.f;
import com.tencent.timi.game.utils.l;

/* loaded from: classes26.dex */
public class TgSchemeProxyFragment extends QPublicBaseFragment {
    public static void ph(Context context, String str) {
        Intent intent = new Intent();
        intent.putExtra("mqqScheme", str);
        QPublicFragmentActivity.b.b(context, intent, QPublicTransFragmentActivity.class, TgSchemeProxyFragment.class);
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View view = new View(viewGroup.getContext());
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, view);
        return view;
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NonNull View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        Bundle arguments = getArguments();
        String string = arguments.getString("mqqScheme", "");
        String string2 = arguments.getString("jumpActionName", "");
        if (!TextUtils.isEmpty(string)) {
            l.h("TgSchemeProxyFragment", 1, "mqqScheme - " + string);
            ((IQQLiveUtil) QRoute.api(IQQLiveUtil.class)).enterRoomByUrl(getContext(), string);
        } else if ("startlive".equals(string2)) {
            f.c("STARTLIVE");
        } else if ("main".equals(string2)) {
            f.c("JUMP_ANCHOR_MAIN");
        }
        getActivity().finish();
    }
}
