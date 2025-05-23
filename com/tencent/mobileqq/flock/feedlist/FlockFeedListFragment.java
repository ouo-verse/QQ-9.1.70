package com.tencent.mobileqq.flock.feedlist;

import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.flock.api.FlockConstants$FlockListScene;
import com.tencent.mobileqq.flock.base.FlockBaseFragment;
import com.tencent.mobileqq.flock.feedcommon.part.FlockFeedCommonEnterGroupPart;
import com.tencent.mobileqq.flock.feedcommon.part.c;
import com.tencent.mobileqq.flock.feedlist.part.FlockFeedHotTagPart;
import com.tencent.mobileqq.flock.feedlist.part.FlockFeedListBodyPart;
import com.tencent.mobileqq.flock.feedlist.part.FlockFeedListPublishPart;
import com.tencent.mobileqq.flock.feedlist.part.g;
import com.tencent.mobileqq.flock.feedlist.part.h;
import com.tencent.mobileqq.flock.layer.part.FlockFeedLoadingPart;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001eB\u0007\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0012\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\b\u0010\t\u001a\u00020\bH\u0016J$\u0010\r\u001a\u001e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u000b0\nj\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u000b`\fH\u0016J\b\u0010\u000e\u001a\u00020\bH\u0014J\u000e\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fH\u0016J\b\u0010\u0013\u001a\u00020\u0012H\u0014J\b\u0010\u0014\u001a\u00020\u0002H\u0014R\u001b\u0010\u001a\u001a\u00020\u00158FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/mobileqq/flock/feedlist/FlockFeedListFragment;", "Lcom/tencent/mobileqq/flock/base/FlockBaseFragment;", "", "sh", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "", "onCreate", "", "getPageId", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "ph", "getLogTag", "", "Lcom/tencent/mobileqq/flock/base/b;", "assembleParts", "", "getContentLayoutId", "enableRootViewSetFitsSystemWindows", "Lcom/tencent/mobileqq/flock/api/FlockConstants$FlockListScene;", UserInfo.SEX_FEMALE, "Lkotlin/Lazy;", "rh", "()Lcom/tencent/mobileqq/flock/api/FlockConstants$FlockListScene;", "type", "<init>", "()V", "G", "a", "qq-flock-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class FlockFeedListFragment extends FlockBaseFragment {
    static IPatchRedirector $redirector_;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final Lazy type;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/flock/feedlist/FlockFeedListFragment$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qq-flock-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.flock.feedlist.FlockFeedListFragment$a, reason: from kotlin metadata */
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

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes12.dex */
    public /* synthetic */ class b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f210127a;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(35291);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 1)) {
                redirector.redirect((short) 1);
                return;
            }
            int[] iArr = new int[FlockConstants$FlockListScene.values().length];
            try {
                iArr[FlockConstants$FlockListScene.ACTIVITY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[FlockConstants$FlockListScene.RECOM.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[FlockConstants$FlockListScene.TROOP.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f210127a = iArr;
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(35301);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 10)) {
            redirector.redirect((short) 10);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public FlockFeedListFragment() {
        Lazy lazy;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            lazy = LazyKt__LazyJVMKt.lazy(new Function0<FlockConstants$FlockListScene>() { // from class: com.tencent.mobileqq.flock.feedlist.FlockFeedListFragment$type$2
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) FlockFeedListFragment.this);
                    }
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final FlockConstants$FlockListScene invoke() {
                    Intent intent;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (FlockConstants$FlockListScene) iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                    FragmentActivity activity = FlockFeedListFragment.this.getActivity();
                    Serializable serializableExtra = (activity == null || (intent = activity.getIntent()) == null) ? null : intent.getSerializableExtra("flock_feedlist_scene");
                    FlockConstants$FlockListScene flockConstants$FlockListScene = serializableExtra instanceof FlockConstants$FlockListScene ? (FlockConstants$FlockListScene) serializableExtra : null;
                    return flockConstants$FlockListScene == null ? FlockConstants$FlockListScene.ACTIVITY : flockConstants$FlockListScene;
                }
            });
            this.type = lazy;
        } else {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final boolean sh() {
        if (rh() != FlockConstants$FlockListScene.ACTIVITY && rh() != FlockConstants$FlockListScene.RECOM) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.biz.richframework.part.interfaces.IPartHost
    @NotNull
    public List<com.tencent.mobileqq.flock.base.b> assembleParts() {
        c cVar;
        List<com.tencent.mobileqq.flock.base.b> mutableListOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (List) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        if (sh()) {
            cVar = new c("375:320", "https://qq-ecommerce.cdn-go.cn/url/latest/defaultmode/dazi/8980/qecommerce_dazi_list_bg_v2.jpg", "https://qq-ecommerce.cdn-go.cn/url/latest/darkmode/dazi/8980/qecommerce_dazi_list_bg_v2.jpg");
        } else {
            cVar = new c("375:280", "https://qq-ecommerce.cdn-go.cn/url/latest/defaultmode/dazi/8978/qecommerce_dazi_list_bg.jpg", "https://qq-ecommerce.cdn-go.cn/url/latest/darkmode/dazi/8978/qecommerce_dazi_list_bg.jpg");
        }
        mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(cVar, new h(rh()), new g(), new FlockFeedListBodyPart(rh()), new FlockFeedListPublishPart(rh()), new FlockFeedCommonEnterGroupPart(), new FlockFeedLoadingPart());
        if (sh()) {
            mutableListOf.add(new FlockFeedHotTagPart(rh()));
        }
        return mutableListOf;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.ImmersivePartFragment
    public boolean enableRootViewSetFitsSystemWindows() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this)).booleanValue();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Integer) iPatchRedirector.redirect((short) 8, (Object) this)).intValue();
        }
        if (sh()) {
            return R.layout.e8k;
        }
        return R.layout.e8f;
    }

    @Override // com.tencent.mobileqq.flock.base.FlockBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    @NotNull
    /* renamed from: getLogTag */
    protected String getTAG() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return "FlockFeedListFragment";
    }

    @Override // com.tencent.mobileqq.flock.base.FlockBaseFragment
    @NotNull
    public String getPageId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return "pg_bas_search_sub_recommendation";
    }

    @Override // com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle savedInstanceState) {
        FragmentActivity activity;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) savedInstanceState);
            return;
        }
        super.onCreate(savedInstanceState);
        if (sh() && (activity = getActivity()) != null) {
            activity.setTheme(R.style.ad_);
        }
    }

    @Override // com.tencent.mobileqq.flock.base.FlockBaseFragment
    @NotNull
    public HashMap<String, Object> ph() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (HashMap) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        HashMap<String, Object> hashMap = new HashMap<>();
        int i3 = b.f210127a[rh().ordinal()];
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 == 3) {
                    hashMap.put("source_entrance_type", 3);
                }
            } else {
                hashMap.put("source_entrance_type", 2);
            }
        } else {
            hashMap.put("source_entrance_type", 1);
        }
        hashMap.put("trace_id", BaseRequest.generateTraceId());
        return hashMap;
    }

    @NotNull
    public final FlockConstants$FlockListScene rh() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (FlockConstants$FlockListScene) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return (FlockConstants$FlockListScene) this.type.getValue();
    }
}
