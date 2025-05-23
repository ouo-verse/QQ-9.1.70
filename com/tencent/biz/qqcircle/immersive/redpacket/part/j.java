package com.tencent.biz.qqcircle.immersive.redpacket.part;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.qqcircle.immersive.redpacket.bean.QFSRedPacketClipBean;
import com.tencent.biz.richframework.part.BasePartFragment;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.wink.api.IWinkAPI;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u00142\u00020\u0001:\u0001\u0015B\u0007\u00a2\u0006\u0004\b\u0012\u0010\u0013J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\u001c\u0010\n\u001a\u00020\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J\u0010\u0010\r\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000bH\u0016R\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/redpacket/part/j;", "Lcom/tencent/biz/qqcircle/bizparts/b;", "", "initData", "Landroidx/fragment/app/Fragment;", "z9", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onPartCreate", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "Lcom/tencent/biz/qqcircle/immersive/redpacket/bean/QFSRedPacketClipBean;", "d", "Lcom/tencent/biz/qqcircle/immersive/redpacket/bean/QFSRedPacketClipBean;", "clipBean", "<init>", "()V", "e", "a", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class j extends com.tencent.biz.qqcircle.bizparts.b {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private QFSRedPacketClipBean clipBean;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/biz/qqcircle/immersive/redpacket/part/j$b", "Landroidx/viewpager2/adapter/FragmentStateAdapter;", "", "getItemCount", "position", "Landroidx/fragment/app/Fragment;", "createFragment", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes4.dex */
    public static final class b extends FragmentStateAdapter {
        b(Fragment fragment) {
            super(fragment);
        }

        @Override // androidx.viewpager2.adapter.FragmentStateAdapter
        @NotNull
        public Fragment createFragment(int position) {
            return j.this.z9();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: getItemCount */
        public int getNUM_BACKGOURND_ICON() {
            return 1;
        }
    }

    private final void initData() {
        QFSRedPacketClipBean qFSRedPacketClipBean;
        if (getActivity() == null) {
            QLog.w("QFSRedPacketClipVpPart", 1, "initData, activity is null ");
            return;
        }
        if (!getActivity().getIntent().hasExtra("key_bundle_common_init_bean")) {
            QLog.w("QFSRedPacketClipVpPart", 1, "initData, data is null ");
            return;
        }
        Serializable serializableExtra = getActivity().getIntent().getSerializableExtra("key_bundle_common_init_bean");
        if (serializableExtra instanceof QFSRedPacketClipBean) {
            qFSRedPacketClipBean = (QFSRedPacketClipBean) serializableExtra;
        } else {
            qFSRedPacketClipBean = null;
        }
        if (qFSRedPacketClipBean == null) {
            QLog.w("QFSRedPacketClipVpPart", 1, "initData, initBean is null ");
        } else {
            this.clipBean = qFSRedPacketClipBean;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Fragment z9() {
        QFSRedPacketClipBean qFSRedPacketClipBean = this.clipBean;
        if (qFSRedPacketClipBean != null) {
            BasePartFragment createWinkEditorSegClipFragment = ((IWinkAPI) QRoute.api(IWinkAPI.class)).createWinkEditorSegClipFragment(qFSRedPacketClipBean.getLocalVideoPath(), qFSRedPacketClipBean.getSelectStartTime(), qFSRedPacketClipBean.getSelectDurationTime(), qFSRedPacketClipBean.getBusinessName(), qFSRedPacketClipBean.getNeedShowSelectStart(), qFSRedPacketClipBean.getNeedShowThumb(), qFSRedPacketClipBean.getReportSessionId());
            if (createWinkEditorSegClipFragment == null) {
                return new Fragment();
            }
            return createWinkEditorSegClipFragment;
        }
        return new Fragment();
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@NotNull View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        ((ViewPager2) rootView.findViewById(R.id.f12028795)).setAdapter(new b(getHostFragment()));
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartCreate(@Nullable Activity activity, @Nullable Bundle savedInstanceState) {
        super.onPartCreate(activity, savedInstanceState);
        initData();
    }
}
