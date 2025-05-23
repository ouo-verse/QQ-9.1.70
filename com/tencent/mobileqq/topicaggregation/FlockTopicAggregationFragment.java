package com.tencent.mobileqq.topicaggregation;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.flock.api.FlockConstants$FlockListScene;
import com.tencent.mobileqq.flock.base.FlockBaseFragment;
import com.tencent.mobileqq.flock.feedcommon.part.FlockFeedCommonEnterGroupPart;
import com.tencent.mobileqq.flock.feedlist.part.FlockFeedListBodyPart;
import com.tencent.mobileqq.flock.feedlist.part.FlockFeedListPublishPart;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.topicaggregation.bean.TopicAggregationSource;
import com.tencent.mobileqq.topicaggregation.part.FlockTopicAggregationHeaderPart;
import com.tencent.mobileqq.topicaggregation.viewmodel.a;
import java.util.HashMap;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\b\u0010\t\u001a\u00020\bH\u0016J$\u0010\r\u001a\u001e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u000b0\nj\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u000b`\fH\u0016J\u000e\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eH\u0016J\b\u0010\u0012\u001a\u00020\u0011H\u0014J\u0012\u0010\u0013\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\b\u0010\u0015\u001a\u00020\u0014H\u0014R#\u0010\u001c\u001a\n \u0017*\u0004\u0018\u00010\u00160\u00168BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/mobileqq/topicaggregation/FlockTopicAggregationFragment;", "Lcom/tencent/mobileqq/flock/base/FlockBaseFragment;", "Landroid/view/View;", "view", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "", "getPageId", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "ph", "", "Lcom/tencent/biz/richframework/part/Part;", "assembleParts", "", "getContentLayoutId", "onCreate", "", "enableRootViewSetFitsSystemWindows", "Lcom/tencent/mobileqq/topicaggregation/viewmodel/a;", "kotlin.jvm.PlatformType", UserInfo.SEX_FEMALE, "Lkotlin/Lazy;", "rh", "()Lcom/tencent/mobileqq/topicaggregation/viewmodel/a;", "vm", "<init>", "()V", "qq-flock-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class FlockTopicAggregationFragment extends FlockBaseFragment {
    static IPatchRedirector $redirector_;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final Lazy vm;

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes10.dex */
    public /* synthetic */ class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f293451a;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(50680);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 1)) {
                redirector.redirect((short) 1);
                return;
            }
            int[] iArr = new int[TopicAggregationSource.values().length];
            try {
                iArr[TopicAggregationSource.DEFAULT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[TopicAggregationSource.RECOMMEND_HOT_TOPIC.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[TopicAggregationSource.FEED_LIST.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[TopicAggregationSource.FEED_DETAIL.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            f293451a = iArr;
        }
    }

    public FlockTopicAggregationFragment() {
        Lazy lazy;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            lazy = LazyKt__LazyJVMKt.lazy(new Function0<com.tencent.mobileqq.topicaggregation.viewmodel.a>() { // from class: com.tencent.mobileqq.topicaggregation.FlockTopicAggregationFragment$vm$2
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) FlockTopicAggregationFragment.this);
                    }
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final a invoke() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    return (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) ? (a) FlockTopicAggregationFragment.this.getViewModel(a.class) : (a) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
            });
            this.vm = lazy;
        } else {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final com.tencent.mobileqq.topicaggregation.viewmodel.a rh() {
        return (com.tencent.mobileqq.topicaggregation.viewmodel.a) this.vm.getValue();
    }

    @Override // com.tencent.biz.richframework.part.interfaces.IPartHost
    @NotNull
    public List<Part> assembleParts() {
        List<Part> mutableListOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (List) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        FlockConstants$FlockListScene flockConstants$FlockListScene = FlockConstants$FlockListScene.TOPIC_AGGREGATION;
        mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(new FlockTopicAggregationHeaderPart(), new FlockFeedListBodyPart(flockConstants$FlockListScene), new FlockFeedCommonEnterGroupPart(), new FlockFeedListPublishPart(flockConstants$FlockListScene));
        return mutableListOf;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.ImmersivePartFragment
    public boolean enableRootViewSetFitsSystemWindows() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this)).booleanValue();
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
        return R.layout.e97;
    }

    @Override // com.tencent.mobileqq.flock.base.FlockBaseFragment
    @NotNull
    public String getPageId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return "pg_bas_greate_subtopic_aggregation";
    }

    @Override // com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle savedInstanceState) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) savedInstanceState);
            return;
        }
        super.onCreate(savedInstanceState);
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.setTheme(R.style.ad_);
        }
    }

    @Override // com.tencent.biz.richframework.part.ImmersivePartFragment, androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) view, (Object) savedInstanceState);
            return;
        }
        Intrinsics.checkNotNullParameter(view, "view");
        com.tencent.mobileqq.topicaggregation.viewmodel.a rh5 = rh();
        Intent intent = requireActivity().getIntent();
        Intrinsics.checkNotNullExpressionValue(intent, "requireActivity().intent");
        rh5.f2(intent);
        super.onViewCreated(view, savedInstanceState);
    }

    @Override // com.tencent.mobileqq.flock.base.FlockBaseFragment
    @NotNull
    public HashMap<String, Object> ph() {
        int i3;
        HashMap<String, Object> hashMapOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (HashMap) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        int i16 = a.f293451a[rh().c2().getSourceType().ordinal()];
        if (i16 != 1) {
            i3 = 2;
            if (i16 != 2) {
                if (i16 != 3) {
                    if (i16 == 4) {
                        i3 = 3;
                    } else {
                        throw new NoWhenBranchMatchedException();
                    }
                }
            } else {
                i3 = 1;
            }
        } else {
            i3 = 0;
        }
        hashMapOf = MapsKt__MapsKt.hashMapOf(TuplesKt.to("tuning_source", Integer.valueOf(i3)));
        return hashMapOf;
    }
}
