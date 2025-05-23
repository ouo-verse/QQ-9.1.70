package com.tencent.mobileqq.vas.group.guide;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.biz.pubaccount.weishi.event.WSComboHomePageChangeEvent;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qmmkv.MMKVOptionEntity;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.api.IVasZplanGroupApi;
import com.tencent.mobileqq.vas.group.cover.a;
import com.tencent.mobileqq.vas.group.guide.SmallHomeCoverEditGuideFragment;
import com.tencent.mobileqq.vas.transit.ExtInfo;
import com.tencent.mobileqq.vas.transit.MasterInfo;
import com.tencent.mobileqq.vas.transit.TransitPageConfig;
import com.tencent.mobileqq.vas.transit.TransitPageInfo;
import com.tencent.mobileqq.vas.transit.VisitorInfo;
import com.tencent.mobileqq.zootopia.Source;
import com.tencent.mobileqq.zootopia.ZootopiaSource;
import com.tencent.mobileqq.zootopia.helper.SmallHomeHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.fragment.ZootopiaBaseFragment;
import fi3.bv;
import i13.GuideData;
import i13.e;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.Constants;
import mqq.app.MobileQQ;

/* compiled from: P */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 62\u00020\u0001:\u00017B\u0007\u00a2\u0006\u0004\b4\u00105J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0002J\u0016\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\u000b\u001a\u00020\u0002H\u0002J&\u0010\u0013\u001a\u0004\u0018\u00010\u00122\u0006\u0010\r\u001a\u00020\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016J\u001a\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016J\b\u0010\u0017\u001a\u00020\u0016H\u0014J\b\u0010\u0019\u001a\u00020\u0018H\u0016J\b\u0010\u001a\u001a\u00020\u0002H\u0016R\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u001b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0016\u0010\"\u001a\u00020\u001f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b \u0010!R\u0016\u0010%\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010'\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b&\u0010$R\u0014\u0010+\u001a\u00020(8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b)\u0010*R\u0014\u0010/\u001a\u00020,8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b-\u0010.R\u0016\u00103\u001a\u0002008\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b1\u00102\u00a8\u00068"}, d2 = {"Lcom/tencent/mobileqq/vas/group/guide/SmallHomeCoverEditGuideFragment;", "Lcom/tencent/sqshow/fragment/ZootopiaBaseFragment;", "", "Sh", "Qh", "Uh", "Landroid/content/Context;", "context", "", "Li13/a;", "Oh", "Ph", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "Landroid/view/View;", "onCreateView", "view", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "", "getSubSource", "", "onBackPressedEvent", "onDestroyView", "Lfi3/bv;", "N", "Lfi3/bv;", "binding", "Li13/e;", "P", "Li13/e;", "vpAdapter", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Z", "needGuide", BdhLogUtil.LogTag.Tag_Req, "isNeedAutoScroll", "Lcom/tencent/mobileqq/qmmkv/MMKVOptionEntity;", ExifInterface.LATITUDE_SOUTH, "Lcom/tencent/mobileqq/qmmkv/MMKVOptionEntity;", "entity", "Lcom/tencent/mobileqq/vas/group/cover/a;", "T", "Lcom/tencent/mobileqq/vas/group/cover/a;", "coverEditReporter", "Ljava/lang/Runnable;", "U", "Ljava/lang/Runnable;", "runnable", "<init>", "()V", "V", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class SmallHomeCoverEditGuideFragment extends ZootopiaBaseFragment {

    /* renamed from: N, reason: from kotlin metadata */
    private bv binding;

    /* renamed from: Q, reason: from kotlin metadata */
    private boolean needGuide;

    /* renamed from: S, reason: from kotlin metadata */
    private final MMKVOptionEntity entity;

    /* renamed from: T, reason: from kotlin metadata */
    private final a coverEditReporter;

    /* renamed from: U, reason: from kotlin metadata */
    private Runnable runnable;

    /* renamed from: P, reason: from kotlin metadata */
    private e vpAdapter = new e();

    /* renamed from: R, reason: from kotlin metadata */
    private boolean isNeedAutoScroll = true;

    public SmallHomeCoverEditGuideFragment() {
        MMKVOptionEntity from = QMMKV.from(MobileQQ.sMobileQQ, "vas_mmkv_configurations");
        Intrinsics.checkNotNullExpressionValue(from, "from(MobileQQ.sMobileQQ, QMMKVFile.FILE_VAS)");
        this.entity = from;
        this.coverEditReporter = new a();
        this.runnable = new Runnable() { // from class: i13.c
            @Override // java.lang.Runnable
            public final void run() {
                SmallHomeCoverEditGuideFragment.Vh(SmallHomeCoverEditGuideFragment.this);
            }
        };
    }

    private final List<GuideData> Oh(Context context) {
        Resources resources = context.getResources();
        ArrayList arrayList = new ArrayList();
        String string = resources.getString(R.string.xv7);
        Intrinsics.checkNotNullExpressionValue(string, "res.getString(R.string.z\u2026me_cover_edit_guide_des1)");
        arrayList.add(new GuideData("http://imgcache.gtimg.cn/mie/act/img/public/202204/m1650786464_smallHomeGuide01.png", string));
        String string2 = resources.getString(R.string.xv8);
        Intrinsics.checkNotNullExpressionValue(string2, "res.getString(R.string.z\u2026me_cover_edit_guide_des2)");
        arrayList.add(new GuideData("http://imgcache.gtimg.cn/mie/act/img/public/202204/m1650786478_smallHomeGuide02.png", string2));
        String string3 = resources.getString(R.string.xv9);
        Intrinsics.checkNotNullExpressionValue(string3, "res.getString(R.string.z\u2026me_cover_edit_guide_des3)");
        arrayList.add(new GuideData("http://imgcache.gtimg.cn/mie/act/img/public/202205/m1651750090_03.png", string3));
        return arrayList;
    }

    private final void Ph() {
        try {
            Fragment parentFragment = getParentFragment();
            DialogFragment dialogFragment = parentFragment instanceof DialogFragment ? (DialogFragment) parentFragment : null;
            if (dialogFragment != null) {
                dialogFragment.dismiss();
            } else {
                getParentFragmentManager().beginTransaction().remove(this).commit();
            }
        } catch (Throwable th5) {
            QLog.e("ZootopiaBaseFragment", 1, "finishSelf err.", th5);
        }
    }

    private final void Qh() {
        CheckBox checkBox;
        bv bvVar = this.binding;
        if (bvVar == null || (checkBox = bvVar.f399167b) == null) {
            return;
        }
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: i13.b
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
                SmallHomeCoverEditGuideFragment.Rh(SmallHomeCoverEditGuideFragment.this, compoundButton, z16);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Rh(SmallHomeCoverEditGuideFragment this$0, CompoundButton compoundButton, boolean z16) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.needGuide = !z16;
    }

    private final void Sh() {
        TextView textView;
        bv bvVar = this.binding;
        if (bvVar == null || (textView = bvVar.f399168c) == null) {
            return;
        }
        textView.setOnClickListener(new View.OnClickListener() { // from class: i13.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SmallHomeCoverEditGuideFragment.Th(SmallHomeCoverEditGuideFragment.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Th(SmallHomeCoverEditGuideFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            return;
        }
        MasterInfo masterInfo = new MasterInfo();
        masterInfo.setUin(peekAppRuntime.getCurrentAccountUin());
        VisitorInfo visitorInfo = new VisitorInfo();
        visitorInfo.setUin(peekAppRuntime.getCurrentAccountUin());
        ZootopiaSource d16 = ZootopiaSource.Companion.d(ZootopiaSource.INSTANCE, Source.SetCover, ZootopiaSource.SUB_SOURCE_SET_COVER, null, 4, null);
        IVasZplanGroupApi iVasZplanGroupApi = (IVasZplanGroupApi) QRoute.api(IVasZplanGroupApi.class);
        Context context = view.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "it.context");
        TransitPageConfig transitPageConfig = new TransitPageConfig();
        ExtInfo extInfo = new ExtInfo();
        extInfo.setUeExtras(SmallHomeHelper.f328312a.b());
        Unit unit = Unit.INSTANCE;
        iVasZplanGroupApi.openSmallHomeTransitPage(context, new TransitPageInfo(masterInfo, visitorInfo, transitPageConfig, extInfo), d16);
        this$0.Ph();
        this$0.coverEditReporter.a();
    }

    private final void Uh() {
        ViewPager viewPager;
        bv bvVar = this.binding;
        if (bvVar == null || (viewPager = bvVar.f399170e) == null) {
            return;
        }
        viewPager.setAdapter(this.vpAdapter);
        viewPager.addOnPageChangeListener(new b());
        e eVar = this.vpAdapter;
        Context context = viewPager.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "it.context");
        eVar.e(Oh(context));
        ThreadManagerV2.getUIHandlerV2().postDelayed(this.runnable, 3000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Vh(SmallHomeCoverEditGuideFragment this$0) {
        ViewPager viewPager;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        bv bvVar = this$0.binding;
        int currentItem = ((bvVar == null || (viewPager = bvVar.f399170e) == null) ? 2 : viewPager.getCurrentItem()) + 1;
        if (currentItem <= 2) {
            bv bvVar2 = this$0.binding;
            ViewPager viewPager2 = bvVar2 != null ? bvVar2.f399170e : null;
            if (viewPager2 == null) {
                return;
            }
            viewPager2.setCurrentItem(currentItem);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.sqshow.fragment.ZootopiaBaseFragment
    public String getSubSource() {
        return "";
    }

    @Override // com.tencent.mobileqq.zootopia.api.b
    public boolean onBackPressedEvent() {
        return false;
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        bv g16 = bv.g(inflater, container, false);
        this.binding = g16;
        if (g16 != null) {
            return g16.getRoot();
        }
        return null;
    }

    @Override // com.tencent.sqshow.fragment.ZootopiaBaseFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.entity.encodeBool("needGuide", this.needGuide).commitAsync();
    }

    @Override // com.tencent.sqshow.fragment.ZootopiaBaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        Uh();
        Qh();
        Sh();
        this.coverEditReporter.b();
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0016J\u0010\u0010\t\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u000b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0002H\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/mobileqq/vas/group/guide/SmallHomeCoverEditGuideFragment$b", "Landroidx/viewpager/widget/ViewPager$OnPageChangeListener;", "", "position", "", "positionOffset", "positionOffsetPixels", "", WSComboHomePageChangeEvent.EVENT_ON_PAGE_SCROLLED, "onPageSelected", "state", "onPageScrollStateChanged", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class b implements ViewPager.OnPageChangeListener {
        b() {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int position) {
            SmallHomeCoverGuideIndicator smallHomeCoverGuideIndicator;
            bv bvVar = SmallHomeCoverEditGuideFragment.this.binding;
            if (bvVar != null && (smallHomeCoverGuideIndicator = bvVar.f399169d) != null) {
                smallHomeCoverGuideIndicator.setSelectItemPosition(position);
            }
            if (position == 2) {
                SmallHomeCoverEditGuideFragment.this.isNeedAutoScroll = false;
            }
            ThreadManagerV2.getUIHandlerV2().removeCallbacks(SmallHomeCoverEditGuideFragment.this.runnable);
            if (SmallHomeCoverEditGuideFragment.this.isNeedAutoScroll) {
                ThreadManagerV2.getUIHandlerV2().postDelayed(SmallHomeCoverEditGuideFragment.this.runnable, 3000L);
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int state) {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        }
    }
}
