package com.tencent.mobileqq.troop.troopsquare.topic.vm;

import android.os.Bundle;
import androidx.lifecycle.ViewModelKt;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.qqcircle.immersive.request.search.QFSSearchBaseRequest;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.troop.troopsquare.topic.vm.b;
import com.tencent.mobileqq.troop.utils.bg;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.base.mvi.BaseViewModel;
import com.tencent.qqnt.kernel.api.s;
import com.tencent.qqnt.kernel.nativeinterface.GetTopicPageRsp;
import com.tencent.qqnt.kernel.nativeinterface.GroupSquareGroupInfoItem;
import com.tencent.qqnt.kernel.nativeinterface.IGetTopicPageCallback;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import java.util.ArrayList;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.Dispatchers;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 52\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u00016B\u000f\u0012\u0006\u0010\r\u001a\u00020\n\u00a2\u0006\u0004\b3\u00104J\u0012\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\t\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0003H\u0016R\u0014\u0010\r\u001a\u00020\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR\u001a\u0010\u0012\u001a\u00020\u00038\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001b\u0010\u0018\u001a\u00020\u00138FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u001b\u0010\u001b\u001a\u00020\u00138FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0019\u0010\u0015\u001a\u0004\b\u001a\u0010\u0017R\u001b\u0010 \u001a\u00020\u001c8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001d\u0010\u0015\u001a\u0004\b\u001e\u0010\u001fR\u001b\u0010#\u001a\u00020\u001c8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b!\u0010\u0015\u001a\u0004\b\"\u0010\u001fR\u001b\u0010&\u001a\u00020\u001c8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b$\u0010\u0015\u001a\u0004\b%\u0010\u001fR\u0016\u0010)\u001a\u00020\u001c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u0016\u0010,\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b*\u0010+R$\u00102\u001a\u0012\u0012\u0004\u0012\u00020.0-j\b\u0012\u0004\u0012\u00020.`/8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b0\u00101\u00a8\u00067"}, d2 = {"Lcom/tencent/mobileqq/troop/troopsquare/topic/vm/TroopSquareTopicViewModel;", "Lcom/tencent/qqnt/base/mvi/BaseViewModel;", "Lcom/tencent/mobileqq/troop/troopsquare/topic/vm/a;", "Lcom/tencent/mobileqq/troop/troopsquare/topic/vm/b;", "", QFSSearchBaseRequest.EXTRA_KEY_IS_LOAD_MORE, "", "b2", "userIntent", ICustomDataEditor.STRING_ARRAY_PARAM_2, "Landroid/os/Bundle;", BdhLogUtil.LogTag.Tag_Conn, "Landroid/os/Bundle;", "bundle", "D", "Lcom/tencent/mobileqq/troop/troopsquare/topic/vm/b;", "W1", "()Lcom/tencent/mobileqq/troop/troopsquare/topic/vm/b;", "mNoneValueIntent", "", "E", "Lkotlin/Lazy;", "Z1", "()J", "troopUin", UserInfo.SEX_FEMALE, "S1", "bannerId", "", "G", "T1", "()Ljava/lang/String;", "bannerName", "H", "U1", "ext", "I", "X1", "topicSource", "J", "Ljava/lang/String;", "requestCookies", "K", "Z", "isRequesting", "Ljava/util/ArrayList;", "Lcom/tencent/qqnt/kernel/nativeinterface/GroupSquareGroupInfoItem;", "Lkotlin/collections/ArrayList;", "L", "Ljava/util/ArrayList;", "groupList", "<init>", "(Landroid/os/Bundle;)V", "M", "a", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class TroopSquareTopicViewModel extends BaseViewModel<a, b> {
    static IPatchRedirector $redirector_;

    /* renamed from: M, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final Bundle bundle;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final b mNoneValueIntent;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final Lazy troopUin;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final Lazy bannerId;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final Lazy bannerName;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private final Lazy ext;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private final Lazy topicSource;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    private String requestCookies;

    /* renamed from: K, reason: from kotlin metadata */
    private boolean isRequesting;

    /* renamed from: L, reason: from kotlin metadata */
    @NotNull
    private final ArrayList<GroupSquareGroupInfoItem> groupList;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/troop/troopsquare/topic/vm/TroopSquareTopicViewModel$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.troop.troopsquare.topic.vm.TroopSquareTopicViewModel$a, reason: from kotlin metadata */
    /* loaded from: classes19.dex */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(61884);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 9)) {
            redirector.redirect((short) 9);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public TroopSquareTopicViewModel(@NotNull Bundle bundle) {
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        Lazy lazy4;
        Lazy lazy5;
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) bundle);
            return;
        }
        this.bundle = bundle;
        this.mNoneValueIntent = b.C8832b.f301724a;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<Long>() { // from class: com.tencent.mobileqq.troop.troopsquare.topic.vm.TroopSquareTopicViewModel$troopUin$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) TroopSquareTopicViewModel.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Long invoke() {
                Bundle bundle2;
                Long longOrNull;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (Long) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
                bundle2 = TroopSquareTopicViewModel.this.bundle;
                String string = bundle2.getString("troop_uin", "0");
                Intrinsics.checkNotNullExpressionValue(string, "bundle.getString(TroopSq\u2026s.ARG_TROOP_UIN_STR, \"0\")");
                longOrNull = StringsKt__StringNumberConversionsKt.toLongOrNull(string);
                return Long.valueOf(longOrNull != null ? longOrNull.longValue() : 0L);
            }
        });
        this.troopUin = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<Long>() { // from class: com.tencent.mobileqq.troop.troopsquare.topic.vm.TroopSquareTopicViewModel$bannerId$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) TroopSquareTopicViewModel.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Long invoke() {
                Bundle bundle2;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (Long) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
                bundle2 = TroopSquareTopicViewModel.this.bundle;
                return Long.valueOf(bundle2.getLong("banner_id", 0L));
            }
        });
        this.bannerId = lazy2;
        lazy3 = LazyKt__LazyJVMKt.lazy(new Function0<String>() { // from class: com.tencent.mobileqq.troop.troopsquare.topic.vm.TroopSquareTopicViewModel$bannerName$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) TroopSquareTopicViewModel.this);
                }
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final String invoke() {
                Bundle bundle2;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (String) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
                bundle2 = TroopSquareTopicViewModel.this.bundle;
                String string = bundle2.getString("banner_name");
                return string == null ? "" : string;
            }
        });
        this.bannerName = lazy3;
        lazy4 = LazyKt__LazyJVMKt.lazy(new Function0<String>() { // from class: com.tencent.mobileqq.troop.troopsquare.topic.vm.TroopSquareTopicViewModel$ext$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) TroopSquareTopicViewModel.this);
                }
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final String invoke() {
                Bundle bundle2;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (String) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
                bundle2 = TroopSquareTopicViewModel.this.bundle;
                String string = bundle2.getString("ext");
                return string == null ? "" : string;
            }
        });
        this.ext = lazy4;
        lazy5 = LazyKt__LazyJVMKt.lazy(new Function0<String>() { // from class: com.tencent.mobileqq.troop.troopsquare.topic.vm.TroopSquareTopicViewModel$topicSource$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) TroopSquareTopicViewModel.this);
                }
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final String invoke() {
                Bundle bundle2;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (String) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
                bundle2 = TroopSquareTopicViewModel.this.bundle;
                String string = bundle2.getString("topic_source");
                return string == null ? "" : string;
            }
        });
        this.topicSource = lazy5;
        this.requestCookies = "";
        this.groupList = new ArrayList<>();
    }

    private final void b2(final boolean isLoadMore) {
        if (this.isRequesting) {
            QLog.w("TroopSquare.Topic.TroopSquareTopicViewModel", 1, "loadData getTopicPage " + Z1() + "-" + S1() + ", is requesting, ignore.");
            return;
        }
        this.isRequesting = true;
        if (!isLoadMore) {
            this.groupList.clear();
            this.requestCookies = "";
        }
        s i3 = bg.i(null, 1, null);
        if (i3 != null) {
            long Z1 = Z1();
            long S1 = S1();
            String str = this.requestCookies;
            String ext = U1();
            Intrinsics.checkNotNullExpressionValue(ext, "ext");
            i3.getTopicPage(Z1, S1, str, ext, new IGetTopicPageCallback() { // from class: com.tencent.mobileqq.troop.troopsquare.topic.vm.c
                @Override // com.tencent.qqnt.kernel.nativeinterface.IGetTopicPageCallback
                public final void onResult(int i16, String str2, GetTopicPageRsp getTopicPageRsp) {
                    TroopSquareTopicViewModel.c2(TroopSquareTopicViewModel.this, isLoadMore, i16, str2, getTopicPageRsp);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c2(TroopSquareTopicViewModel this$0, boolean z16, int i3, String str, GetTopicPageRsp getTopicPageRsp) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this$0), Dispatchers.getMain(), null, new TroopSquareTopicViewModel$loadData$2$1(this$0, i3, z16, getTopicPageRsp, str, null), 2, null);
    }

    public final long S1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Long) iPatchRedirector.redirect((short) 4, (Object) this)).longValue();
        }
        return ((Number) this.bannerId.getValue()).longValue();
    }

    @NotNull
    public final String T1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return (String) this.bannerName.getValue();
    }

    @NotNull
    public final String U1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return (String) this.ext.getValue();
    }

    @Override // com.tencent.qqnt.base.mvi.BaseViewModel
    @NotNull
    /* renamed from: W1, reason: merged with bridge method [inline-methods] */
    public b getMNoneValueIntent() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (b) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.mNoneValueIntent;
    }

    @NotNull
    public final String X1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (String) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return (String) this.topicSource.getValue();
    }

    public final long Z1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Long) iPatchRedirector.redirect((short) 3, (Object) this)).longValue();
        }
        return ((Number) this.troopUin.getValue()).longValue();
    }

    @Override // com.tencent.qqnt.base.mvi.BaseViewModel
    /* renamed from: a2, reason: merged with bridge method [inline-methods] */
    public void handleIntent(@NotNull b userIntent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) userIntent);
            return;
        }
        Intrinsics.checkNotNullParameter(userIntent, "userIntent");
        if (userIntent instanceof b.a) {
            b2(((b.a) userIntent).a());
        }
    }
}
