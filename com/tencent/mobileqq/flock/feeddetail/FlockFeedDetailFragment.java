package com.tencent.mobileqq.flock.feeddetail;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.flock.base.FlockBaseFragment;
import com.tencent.mobileqq.flock.feedcommon.part.FlockFeedCommonEnterGroupPart;
import com.tencent.mobileqq.flock.feedcommon.part.c;
import com.tencent.mobileqq.flock.feeddetail.part.FlockFeedDetailBodyPart;
import com.tencent.mobileqq.flock.feeddetail.part.FlockFeedDetailMorePart;
import com.tencent.mobileqq.flock.feeddetail.part.FlockFeedDetailOperatePart;
import com.tencent.mobileqq.flock.feeddetail.part.FlockFeedDetailTitlePart;
import com.tencent.mobileqq.flock.feeddetail.part.j;
import com.tencent.mobileqq.flock.ktx.e;
import com.tencent.mobileqq.flock.layer.part.FlockFeedLoadingPart;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.richframework.data.base.UIStateData;
import java.util.HashMap;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import y45.b;
import y45.k;
import y45.l;

/* compiled from: P */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 \"2\u00020\u0001:\u0001#B\u0007\u00a2\u0006\u0004\b \u0010!J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0014J\b\u0010\b\u001a\u00020\u0007H\u0014J\u001a\u0010\r\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016J\u000e\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eH\u0016J\b\u0010\u0012\u001a\u00020\u0011H\u0014J\b\u0010\u0013\u001a\u00020\u0005H\u0016J$\u0010\u0017\u001a\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00150\u0014j\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0015`\u0016H\u0016J\b\u0010\u0018\u001a\u00020\u0007H\u0014R#\u0010\u001f\u001a\n \u001a*\u0004\u0018\u00010\u00190\u00198BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\u00a8\u0006$"}, d2 = {"Lcom/tencent/mobileqq/flock/feeddetail/FlockFeedDetailFragment;", "Lcom/tencent/mobileqq/flock/base/FlockBaseFragment;", "", "initData", "uh", "", "getLogTag", "", "enableRootViewSetFitsSystemWindows", "Landroid/view/View;", "view", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "", "Lcom/tencent/biz/richframework/part/Part;", "assembleParts", "", "getContentLayoutId", "getPageId", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "ph", "qh", "Lcom/tencent/mobileqq/flock/feeddetail/viewmodel/a;", "kotlin.jvm.PlatformType", UserInfo.SEX_FEMALE, "Lkotlin/Lazy;", "th", "()Lcom/tencent/mobileqq/flock/feeddetail/viewmodel/a;", "vm", "<init>", "()V", "G", "a", "qq-flock-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class FlockFeedDetailFragment extends FlockBaseFragment {
    static IPatchRedirector $redirector_;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final Lazy vm;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/flock/feeddetail/FlockFeedDetailFragment$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qq-flock-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.flock.feeddetail.FlockFeedDetailFragment$a, reason: from kotlin metadata */
    /* loaded from: classes12.dex */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(26075);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 10)) {
            redirector.redirect((short) 10);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public FlockFeedDetailFragment() {
        Lazy lazy;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            lazy = LazyKt__LazyJVMKt.lazy(new Function0<com.tencent.mobileqq.flock.feeddetail.viewmodel.a>() { // from class: com.tencent.mobileqq.flock.feeddetail.FlockFeedDetailFragment$vm$2
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) FlockFeedDetailFragment.this);
                    }
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final com.tencent.mobileqq.flock.feeddetail.viewmodel.a invoke() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    return (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) ? (com.tencent.mobileqq.flock.feeddetail.viewmodel.a) FlockFeedDetailFragment.this.getViewModel(com.tencent.mobileqq.flock.feeddetail.viewmodel.a.class) : (com.tencent.mobileqq.flock.feeddetail.viewmodel.a) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
            });
            this.vm = lazy;
        } else {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final void initData() {
        LiveData<UIStateData<com.tencent.mobileqq.flock.feeddetail.bean.a>> R1 = th().R1();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        final Function1<UIStateData<com.tencent.mobileqq.flock.feeddetail.bean.a>, Unit> function1 = new Function1<UIStateData<com.tencent.mobileqq.flock.feeddetail.bean.a>, Unit>() { // from class: com.tencent.mobileqq.flock.feeddetail.FlockFeedDetailFragment$initData$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) FlockFeedDetailFragment.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(UIStateData<com.tencent.mobileqq.flock.feeddetail.bean.a> uIStateData) {
                invoke2(uIStateData);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(UIStateData<com.tencent.mobileqq.flock.feeddetail.bean.a> uIStateData) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) uIStateData);
                    return;
                }
                int state = uIStateData.getState();
                if (state == 2 || state == 3) {
                    FlockFeedDetailFragment.this.uh();
                }
            }
        };
        R1.observe(viewLifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.flock.feeddetail.a
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                FlockFeedDetailFragment.vh(Function1.this, obj);
            }
        });
    }

    private final com.tencent.mobileqq.flock.feeddetail.viewmodel.a th() {
        return (com.tencent.mobileqq.flock.feeddetail.viewmodel.a) this.vm.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void uh() {
        registerDaTongReportPageId();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void vh(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    @Override // com.tencent.biz.richframework.part.interfaces.IPartHost
    @NotNull
    public List<Part> assembleParts() {
        List<Part> mutableListOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) {
            mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(new c(null, null, null, 7, null), new FlockFeedDetailTitlePart(), new FlockFeedDetailBodyPart(), new FlockFeedDetailOperatePart(), new FlockFeedDetailMorePart(), new j(), new FlockFeedLoadingPart(), new FlockFeedCommonEnterGroupPart());
            return mutableListOf;
        }
        return (List) iPatchRedirector.redirect((short) 5, (Object) this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.ImmersivePartFragment
    public boolean enableRootViewSetFitsSystemWindows() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
        }
        return R.layout.e7q;
    }

    @Override // com.tencent.mobileqq.flock.base.FlockBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    @NotNull
    /* renamed from: getLogTag */
    protected String getTAG() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return "FlockFeedDetailFragment";
    }

    @Override // com.tencent.mobileqq.flock.base.FlockBaseFragment
    @NotNull
    public String getPageId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (String) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return "pg_bas_partner_activities_details";
    }

    @Override // com.tencent.biz.richframework.part.ImmersivePartFragment, androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) view, (Object) savedInstanceState);
            return;
        }
        Intrinsics.checkNotNullParameter(view, "view");
        com.tencent.mobileqq.flock.feeddetail.viewmodel.a th5 = th();
        Intent intent = requireActivity().getIntent();
        Intrinsics.checkNotNullExpressionValue(intent, "requireActivity().intent");
        th5.T1(intent);
        super.onViewCreated(view, savedInstanceState);
        initData();
    }

    @Override // com.tencent.mobileqq.flock.base.FlockBaseFragment
    @NotNull
    public HashMap<String, Object> ph() {
        com.tencent.mobileqq.flock.feeddetail.bean.a data;
        b a16;
        String str;
        Integer num;
        Long l3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (HashMap) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        HashMap<String, Object> ph5 = super.ph();
        UIStateData<com.tencent.mobileqq.flock.feeddetail.bean.a> value = th().R1().getValue();
        if (value != null && (data = value.getData()) != null && (a16 = data.a()) != null) {
            ph5.put("activity_name", a16.f449371f);
            l lVar = a16.f449376k;
            Long l16 = null;
            if (lVar != null) {
                str = lVar.f449420b;
            } else {
                str = null;
            }
            String str2 = "";
            if (str == null) {
                str = "";
            } else {
                Intrinsics.checkNotNullExpressionValue(str, "poiInfo?.name ?: \"\"");
            }
            ph5.put("activity_location", str);
            ph5.put("activity_result_id", a16.f449366a);
            k kVar = a16.f449379n;
            if (kVar != null) {
                num = Integer.valueOf(kVar.f449416b);
            } else {
                num = null;
            }
            ph5.put("participants_num", String.valueOf(num));
            ph5.put("publisher_event_results", a16.f449369d.f449450b);
            ph5.put("source_entrance_type", Integer.valueOf(th().S1().getSourceEntranceType()));
            com.tencent.mobileqq.flock.utils.b bVar = com.tencent.mobileqq.flock.utils.b.f210481a;
            String str3 = a16.f449369d.f449449a;
            Intrinsics.checkNotNullExpressionValue(str3, "publisher.id");
            ph5.put("open_visit_state", Integer.valueOf(!bVar.b(str3) ? 1 : 0));
            ph5.put("group_id", Long.valueOf(a16.f449367b));
            y45.a aVar = a16.f449374i;
            if (aVar != null) {
                l3 = Long.valueOf(aVar.f449361a);
            } else {
                l3 = null;
            }
            ph5.put("activity_start_time", String.valueOf(l3));
            y45.a aVar2 = a16.f449374i;
            if (aVar2 != null) {
                l16 = Long.valueOf(aVar2.f449362b);
            }
            ph5.put("activity_end_time", String.valueOf(l16));
            String b16 = e.b(a16);
            if (b16 != null) {
                str2 = b16;
            }
            ph5.put("activity_topic", str2);
        }
        return ph5;
    }

    @Override // com.tencent.mobileqq.flock.base.FlockBaseFragment
    protected boolean qh() {
        b bVar;
        com.tencent.mobileqq.flock.feeddetail.bean.a data;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this)).booleanValue();
        }
        UIStateData<com.tencent.mobileqq.flock.feeddetail.bean.a> value = th().R1().getValue();
        if (value != null && (data = value.getData()) != null) {
            bVar = data.a();
        } else {
            bVar = null;
        }
        if (bVar == null) {
            return true;
        }
        return false;
    }
}
