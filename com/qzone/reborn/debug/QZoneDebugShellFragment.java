package com.qzone.reborn.debug;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.reborn.base.QZoneBaseFragment;
import com.qzone.reborn.debug.QZoneDebugShellFragment;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.immersive.ImmersiveUtils;
import gd.e;
import hd.b;
import id.c;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;

/* compiled from: P */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b#\u0010$J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\u001a\u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J\b\u0010\u000b\u001a\u00020\nH\u0014J\u000e\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\fH\u0016R\u0016\u0010\u0012\u001a\u00020\u000f8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0015\u001a\u00020\u00028\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0019\u001a\u00020\u00168\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u001c\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001a8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0016\u0010\"\u001a\u00020\u001f8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b \u0010!\u00a8\u0006%"}, d2 = {"Lcom/qzone/reborn/debug/QZoneDebugShellFragment;", "Lcom/qzone/reborn/base/QZoneBaseFragment;", "Landroid/view/View;", "view", "", "initView", "qh", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "", "getContentLayoutId", "", "Lcom/tencent/biz/richframework/part/Part;", "assembleParts", "Landroid/widget/TextView;", BdhLogUtil.LogTag.Tag_Conn, "Landroid/widget/TextView;", "mTitleText", "D", "Landroid/view/View;", "mBackView", "Lgd/e;", "E", "Lgd/e;", "mAdapter", "", "Lhd/b;", UserInfo.SEX_FEMALE, "Ljava/util/List;", "mDebugData", "Landroidx/recyclerview/widget/RecyclerView;", "G", "Landroidx/recyclerview/widget/RecyclerView;", "mRecyclerView", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class QZoneDebugShellFragment extends QZoneBaseFragment {

    /* renamed from: C, reason: from kotlin metadata */
    private TextView mTitleText;

    /* renamed from: D, reason: from kotlin metadata */
    private View mBackView;

    /* renamed from: E, reason: from kotlin metadata */
    private e mAdapter;

    /* renamed from: F, reason: from kotlin metadata */
    private List<? extends b> mDebugData;

    /* renamed from: G, reason: from kotlin metadata */
    private RecyclerView mRecyclerView;

    private final void qh() {
        RecyclerView recyclerView = this.mRecyclerView;
        e eVar = null;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRecyclerView");
            recyclerView = null;
        }
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        this.mAdapter = new e();
        RecyclerView recyclerView2 = this.mRecyclerView;
        if (recyclerView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRecyclerView");
            recyclerView2 = null;
        }
        e eVar2 = this.mAdapter;
        if (eVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAdapter");
        } else {
            eVar = eVar2;
        }
        recyclerView2.setAdapter(eVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void rh(QZoneDebugShellFragment this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        FragmentActivity activity = this$0.getActivity();
        if (activity != null) {
            activity.finish();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.qzone.reborn.base.QZoneBaseFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public List<Part> assembleParts() {
        return new ArrayList();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.chw;
    }

    @Override // com.qzone.reborn.base.QZoneBaseFragment, com.tencent.biz.richframework.part.ImmersivePartFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intent intent;
        Intent intent2;
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        if (getActivity() != null) {
            ImmersiveUtils.setStatusTextColor(true, requireActivity().getWindow());
        }
        initView(view);
        FragmentActivity activity = getActivity();
        List<? extends b> list = null;
        String stringExtra = (activity == null || (intent2 = activity.getIntent()) == null) ? null : intent2.getStringExtra("KEY_DEBUG_DATA_FACTORY");
        FragmentActivity activity2 = getActivity();
        String stringExtra2 = (activity2 == null || (intent = activity2.getIntent()) == null) ? null : intent.getStringExtra("KEY_TITLE");
        TextView textView = this.mTitleText;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTitleText");
            textView = null;
        }
        textView.setText(stringExtra2);
        this.mDebugData = c.f407503a.a(getActivity(), stringExtra);
        e eVar = this.mAdapter;
        if (eVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAdapter");
            eVar = null;
        }
        List<? extends b> list2 = this.mDebugData;
        if (list2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mDebugData");
        } else {
            list = list2;
        }
        eVar.setDatas(list);
    }

    private final void initView(View view) {
        View findViewById = view.findViewById(R.id.mto);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.qzone_debug_rv)");
        this.mRecyclerView = (RecyclerView) findViewById;
        View findViewById2 = view.findViewById(R.id.mtu);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "view.findViewById(R.id.qzone_debug_title)");
        this.mTitleText = (TextView) findViewById2;
        View findViewById3 = view.findViewById(R.id.mtj);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "view.findViewById(R.id.qzone_debug_close)");
        this.mBackView = findViewById3;
        if (findViewById3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBackView");
            findViewById3 = null;
        }
        findViewById3.setOnClickListener(new View.OnClickListener() { // from class: gd.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                QZoneDebugShellFragment.rh(QZoneDebugShellFragment.this, view2);
            }
        });
        qh();
    }
}
