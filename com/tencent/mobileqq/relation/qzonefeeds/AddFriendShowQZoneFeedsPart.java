package com.tencent.mobileqq.relation.qzonefeeds;

import NS_MOBILE_NEWEST_FEEDS.feed_info;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.data.SysSuspiciousMsg;
import com.tencent.mobileqq.profilecard.api.IProfileProtocolConst;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.utils.abtest.ABTestController;
import com.tencent.mobileqq.utils.abtest.ExpEntityInfo;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.report.lp.QZoneLoginReportHelper;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 &2\u00020\u0001:\u0001'B\u0007\u00a2\u0006\u0004\b$\u0010%J\b\u0010\u0003\u001a\u00020\u0002H\u0002J \u0010\b\u001a\u00020\u00022\u0016\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006H\u0002J\u001c\u0010\r\u001a\u00020\u00022\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016J\b\u0010\u000f\u001a\u00020\u000eH\u0016J\b\u0010\u0011\u001a\u00020\u0010H\u0014J\u0012\u0010\u0014\u001a\u00020\u00022\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0016R\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0018\u0010\u001f\u001a\u0004\u0018\u00010\u001c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0018\u0010#\u001a\u0004\u0018\u00010 8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010\"\u00a8\u0006("}, d2 = {"Lcom/tencent/mobileqq/relation/qzonefeeds/AddFriendShowQZoneFeedsPart;", "Lcom/tencent/biz/richframework/part/Part;", "", "initViewModel", "Ljava/util/ArrayList;", "LNS_MOBILE_NEWEST_FEEDS/feed_info;", "Lkotlin/collections/ArrayList;", "feedList", "E9", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onPartCreate", "", "isPartEnable", "", "getInitRelyViewStubId", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "d", "Landroid/view/View;", "viewContainer", "Landroid/view/ViewGroup;", "e", "Landroid/view/ViewGroup;", "feedsContainer", "", "f", "Ljava/lang/Long;", IProfileProtocolConst.PARAM_TARGET_UIN, "Lcom/tencent/mobileqq/relation/qzonefeeds/d;", h.F, "Lcom/tencent/mobileqq/relation/qzonefeeds/d;", "viewModel", "<init>", "()V", "i", "a", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class AddFriendShowQZoneFeedsPart extends Part {
    static IPatchRedirector $redirector_;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private View viewContainer;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ViewGroup feedsContainer;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Long targetUin;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private d viewModel;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/relation/qzonefeeds/AddFriendShowQZoneFeedsPart$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.relation.qzonefeeds.AddFriendShowQZoneFeedsPart$a, reason: from kotlin metadata */
    /* loaded from: classes17.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(60021);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public AddFriendShowQZoneFeedsPart() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void C9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void D9(AddFriendShowQZoneFeedsPart this$0, View view) {
        String str;
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Context context = this$0.getContext();
        Intrinsics.checkNotNull(context, "null cannot be cast to non-null type android.app.Activity");
        Activity activity = (Activity) context;
        QZoneHelper.UserInfo userInfo = QZoneHelper.UserInfo.getInstance();
        Long l3 = this$0.targetUin;
        String str2 = null;
        if (l3 != null) {
            str = l3.toString();
        } else {
            str = null;
        }
        QZoneHelper.forwardToUserHome(activity, userInfo, str, 0, 0, 0);
        Long l16 = this$0.targetUin;
        if (l16 != null) {
            str2 = l16.toString();
        }
        QZoneLoginReportHelper.reportLoginFromQQAddFriend(str2);
        HashMap hashMap = new HashMap();
        hashMap.put("dt_eid", "em_qz_space_entrance");
        VideoReport.reportEvent("dt_clck", view, hashMap);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void E9(ArrayList<feed_info> feedList) {
        ViewGroup viewGroup;
        if (!feedList.isEmpty() && (viewGroup = this.feedsContainer) != null) {
            c cVar = c.f280652a;
            Intrinsics.checkNotNull(viewGroup);
            cVar.g(viewGroup, feedList);
            VideoReport.setElementId(this.viewContainer, "em_qz_space_entrance");
            VideoReport.setElementExposePolicy(this.viewContainer, ExposurePolicy.REPORT_FIRST);
            return;
        }
        View view = this.viewContainer;
        if (view != null) {
            view.setVisibility(8);
        }
    }

    private final void initViewModel() {
        MutableLiveData<ArrayList<feed_info>> mutableLiveData;
        d dVar = (d) getViewModel(d.class);
        this.viewModel = dVar;
        if (dVar != null) {
            Long l3 = this.targetUin;
            Intrinsics.checkNotNull(l3);
            dVar.M1(l3.longValue());
        }
        d dVar2 = this.viewModel;
        if (dVar2 != null) {
            mutableLiveData = dVar2.L1();
        } else {
            mutableLiveData = null;
        }
        Intrinsics.checkNotNull(mutableLiveData);
        LifecycleOwner lifecycleOwner = getPartHost().getLifecycleOwner();
        final Function1<ArrayList<feed_info>, Unit> function1 = new Function1<ArrayList<feed_info>, Unit>() { // from class: com.tencent.mobileqq.relation.qzonefeeds.AddFriendShowQZoneFeedsPart$initViewModel$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) AddFriendShowQZoneFeedsPart.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ArrayList<feed_info> arrayList) {
                invoke2(arrayList);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(ArrayList<feed_info> arrayList) {
                View view;
                View view2;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) arrayList);
                    return;
                }
                if (arrayList == null) {
                    return;
                }
                if (arrayList.size() <= 0) {
                    view = AddFriendShowQZoneFeedsPart.this.viewContainer;
                    if (view == null) {
                        return;
                    }
                    view.setVisibility(8);
                    return;
                }
                AddFriendShowQZoneFeedsPart.this.startInit();
                view2 = AddFriendShowQZoneFeedsPart.this.viewContainer;
                if (view2 != null) {
                    view2.setVisibility(0);
                }
                AddFriendShowQZoneFeedsPart.this.E9(arrayList);
            }
        };
        mutableLiveData.observe(lifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.relation.qzonefeeds.b
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                AddFriendShowQZoneFeedsPart.C9(Function1.this, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.Part
    public int getInitRelyViewStubId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        return R.id.f58792qz;
    }

    @Override // com.tencent.biz.richframework.part.Part
    public boolean isPartEnable() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        ExpEntityInfo expEntity = ABTestController.getInstance().getExpEntity("exp_add_friend_page_display_friend_updates");
        Intrinsics.checkNotNullExpressionValue(expEntity, "getInstance()\n          \u2026_display_friend_updates\")");
        expEntity.reportExpExposure();
        return expEntity.isExperiment("exp_add_friend_page_display_friend_updates_B");
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@Nullable View rootView) {
        View view;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) rootView);
            return;
        }
        super.onInitView(rootView);
        ViewGroup viewGroup = null;
        if (rootView != null) {
            view = rootView.findViewById(R.id.sd9);
        } else {
            view = null;
        }
        this.viewContainer = view;
        if (rootView != null) {
            viewGroup = (ViewGroup) rootView.findViewById(R.id.f166095yo3);
        }
        this.feedsContainer = viewGroup;
        View view2 = this.viewContainer;
        if (view2 != null) {
            view2.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.relation.qzonefeeds.a
                @Override // android.view.View.OnClickListener
                public final void onClick(View view3) {
                    AddFriendShowQZoneFeedsPart.D9(AddFriendShowQZoneFeedsPart.this, view3);
                }
            });
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartCreate(@Nullable Activity activity, @Nullable Bundle savedInstanceState) {
        String stringExtra;
        Long l3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) activity, (Object) savedInstanceState);
            return;
        }
        super.onPartCreate(activity, savedInstanceState);
        Intent intent = getActivity().getIntent();
        Serializable serializableExtra = intent.getSerializableExtra("msg_extra");
        if (serializableExtra instanceof SysSuspiciousMsg) {
            stringExtra = String.valueOf(Long.valueOf(((SysSuspiciousMsg) serializableExtra).uin));
        } else {
            stringExtra = intent.getStringExtra("infouin");
        }
        if (stringExtra != null) {
            l3 = Long.valueOf(Long.parseLong(stringExtra));
        } else {
            l3 = null;
        }
        this.targetUin = l3;
        if (l3 != null) {
            l3.longValue();
            initViewModel();
        }
    }
}
