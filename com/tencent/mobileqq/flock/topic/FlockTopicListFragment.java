package com.tencent.mobileqq.flock.topic;

import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.flock.base.FlockBaseFragment;
import com.tencent.mobileqq.flock.topic.part.FlockTopicListPart;
import com.tencent.mobileqq.flock.topic.part.f;
import com.tencent.mobileqq.flock.topic.part.h;
import com.tencent.mobileqq.flock.topic.viewmodel.FlockPublishTopicViewModel;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0010\u0010\u0011J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0014R#\u0010\u000f\u001a\n \n*\u0004\u0018\u00010\t0\t8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/flock/topic/FlockTopicListFragment;", "Lcom/tencent/mobileqq/flock/base/FlockBaseFragment;", "", "getPageId", "", "Lcom/tencent/biz/richframework/part/Part;", "assembleParts", "", "getContentLayoutId", "Lcom/tencent/mobileqq/flock/topic/viewmodel/FlockPublishTopicViewModel;", "kotlin.jvm.PlatformType", UserInfo.SEX_FEMALE, "Lkotlin/Lazy;", "rh", "()Lcom/tencent/mobileqq/flock/topic/viewmodel/FlockPublishTopicViewModel;", "publishTopicViewModel", "<init>", "()V", "qq-flock-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class FlockTopicListFragment extends FlockBaseFragment {
    static IPatchRedirector $redirector_;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final Lazy publishTopicViewModel;

    public FlockTopicListFragment() {
        Lazy lazy;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            lazy = LazyKt__LazyJVMKt.lazy(new Function0<FlockPublishTopicViewModel>() { // from class: com.tencent.mobileqq.flock.topic.FlockTopicListFragment$publishTopicViewModel$2
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) FlockTopicListFragment.this);
                    }
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final FlockPublishTopicViewModel invoke() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    return (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) ? (FlockPublishTopicViewModel) FlockTopicListFragment.this.getViewModel(FlockPublishTopicViewModel.class) : (FlockPublishTopicViewModel) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
            });
            this.publishTopicViewModel = lazy;
        } else {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final FlockPublishTopicViewModel rh() {
        return (FlockPublishTopicViewModel) this.publishTopicViewModel.getValue();
    }

    @Override // com.tencent.biz.richframework.part.interfaces.IPartHost
    @Nullable
    public List<Part> assembleParts() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (List) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(new h());
        arrayList.add(new f());
        arrayList.add(new FlockTopicListPart(rh().P1(), rh().R1(), true));
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        return R.layout.e9_;
    }

    @Override // com.tencent.mobileqq.flock.base.FlockBaseFragment
    @NotNull
    public String getPageId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return "pg_bas_publishing_topic_search";
    }
}
