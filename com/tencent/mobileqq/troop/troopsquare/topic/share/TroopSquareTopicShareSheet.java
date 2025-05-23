package com.tencent.mobileqq.troop.troopsquare.topic.share;

import android.app.Activity;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.mobileqq.widget.share.ShareActionSheet;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 %2\u00020\u0001:\u0001\fB+\u0012\u0006\u0010\u0010\u001a\u00020\u000b\u0012\u0006\u0010\u0016\u001a\u00020\u0011\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u0017\u0012\b\b\u0002\u0010\"\u001a\u00020\u001d\u00a2\u0006\u0004\b3\u00104J\u0016\u0010\u0005\u001a\u0010\u0012\f\u0012\n \u0004*\u0004\u0018\u00010\u00030\u00030\u0002H\u0002J(\u0010\b\u001a\"\u0012\f\u0012\n \u0004*\u0004\u0018\u00010\u00030\u00030\u0006j\u0010\u0012\f\u0012\n \u0004*\u0004\u0018\u00010\u00030\u0003`\u0007H\u0002J\u0006\u0010\n\u001a\u00020\tR\u0017\u0010\u0010\u001a\u00020\u000b8\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0016\u001a\u00020\u00118\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0017\u0010\u001c\u001a\u00020\u00178\u0006\u00a2\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u0017\u0010\"\u001a\u00020\u001d8\u0006\u00a2\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!R$\u0010)\u001a\u0004\u0018\u00010#8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000e\u0010$\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u001b\u0010.\u001a\u00020*8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b \u0010+\u001a\u0004\b,\u0010-R\u001b\u00102\u001a\u00020/8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0014\u0010+\u001a\u0004\b0\u00101\u00a8\u00065"}, d2 = {"Lcom/tencent/mobileqq/troop/troopsquare/topic/share/TroopSquareTopicShareSheet;", "", "", "Lcom/tencent/mobileqq/utils/ShareActionSheetBuilder$ActionSheetItem;", "kotlin.jvm.PlatformType", "j", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "i", "", "o", "Landroid/app/Activity;", "a", "Landroid/app/Activity;", "e", "()Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Lkotlinx/coroutines/CoroutineScope;", "b", "Lkotlinx/coroutines/CoroutineScope;", "g", "()Lkotlinx/coroutines/CoroutineScope;", "lifecycleScope", "", "c", "J", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "()J", "topicId", "", "d", "Ljava/lang/String;", "f", "()Ljava/lang/String;", "ext", "Lcom/tencent/mobileqq/widget/share/ShareActionSheet$c;", "Lcom/tencent/mobileqq/widget/share/ShareActionSheet$c;", h.F, "()Lcom/tencent/mobileqq/widget/share/ShareActionSheet$c;", DomainData.DOMAIN_NAME, "(Lcom/tencent/mobileqq/widget/share/ShareActionSheet$c;)V", "onClickCallback", "Lcom/tencent/mobileqq/troop/troopsquare/topic/share/TroopSquareTopicShareActionHandler;", "Lkotlin/Lazy;", "k", "()Lcom/tencent/mobileqq/troop/troopsquare/topic/share/TroopSquareTopicShareActionHandler;", "shareActionHandler", "Lcom/tencent/mobileqq/widget/share/ShareActionSheet;", "l", "()Lcom/tencent/mobileqq/widget/share/ShareActionSheet;", "shareActionSheet", "<init>", "(Landroid/app/Activity;Lkotlinx/coroutines/CoroutineScope;JLjava/lang/String;)V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class TroopSquareTopicShareSheet {
    static IPatchRedirector $redirector_;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Activity activity;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final CoroutineScope lifecycleScope;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final long topicId;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String ext;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ShareActionSheet.c onClickCallback;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy shareActionHandler;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy shareActionSheet;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/troop/troopsquare/topic/share/TroopSquareTopicShareSheet$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.troop.troopsquare.topic.share.TroopSquareTopicShareSheet$a, reason: from kotlin metadata */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(61801);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 10)) {
            redirector.redirect((short) 10);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public TroopSquareTopicShareSheet(@NotNull Activity activity, @NotNull CoroutineScope lifecycleScope, long j3, @NotNull String ext) {
        Lazy lazy;
        Lazy lazy2;
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(lifecycleScope, "lifecycleScope");
        Intrinsics.checkNotNullParameter(ext, "ext");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, activity, lifecycleScope, Long.valueOf(j3), ext);
            return;
        }
        this.activity = activity;
        this.lifecycleScope = lifecycleScope;
        this.topicId = j3;
        this.ext = ext;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<TroopSquareTopicShareActionHandler>() { // from class: com.tencent.mobileqq.troop.troopsquare.topic.share.TroopSquareTopicShareSheet$shareActionHandler$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) TroopSquareTopicShareSheet.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final TroopSquareTopicShareActionHandler invoke() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                return (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) ? new TroopSquareTopicShareActionHandler(TroopSquareTopicShareSheet.this.e(), TroopSquareTopicShareSheet.this.g(), TroopSquareTopicShareSheet.this.m(), TroopSquareTopicShareSheet.this.f()) : (TroopSquareTopicShareActionHandler) iPatchRedirector2.redirect((short) 2, (Object) this);
            }
        });
        this.shareActionHandler = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new TroopSquareTopicShareSheet$shareActionSheet$2(this));
        this.shareActionSheet = lazy2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ArrayList<ShareActionSheetBuilder.ActionSheetItem> i() {
        ArrayList<ShareActionSheetBuilder.ActionSheetItem> arrayListOf;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(ShareActionSheetBuilder.ActionSheetItem.build(1));
        return arrayListOf;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List<ShareActionSheetBuilder.ActionSheetItem> j() {
        ArrayList arrayListOf;
        int collectionSizeOrDefault;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(2, 171, 9, 10, 3);
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayListOf, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator it = arrayListOf.iterator();
        while (it.hasNext()) {
            arrayList.add(ShareActionSheetBuilder.ActionSheetItem.build(((Number) it.next()).intValue()));
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final TroopSquareTopicShareActionHandler k() {
        return (TroopSquareTopicShareActionHandler) this.shareActionHandler.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ShareActionSheet l() {
        Object value = this.shareActionSheet.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-shareActionSheet>(...)");
        return (ShareActionSheet) value;
    }

    @NotNull
    public final Activity e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Activity) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.activity;
    }

    @NotNull
    public final String f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.ext;
    }

    @NotNull
    public final CoroutineScope g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (CoroutineScope) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.lifecycleScope;
    }

    @Nullable
    public final ShareActionSheet.c h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (ShareActionSheet.c) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return this.onClickCallback;
    }

    public final long m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Long) iPatchRedirector.redirect((short) 5, (Object) this)).longValue();
        }
        return this.topicId;
    }

    public final void n(@Nullable ShareActionSheet.c cVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) cVar);
        } else {
            this.onClickCallback = cVar;
        }
    }

    public final void o() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
        } else if (!l().isShowing()) {
            l().show();
        }
    }
}
