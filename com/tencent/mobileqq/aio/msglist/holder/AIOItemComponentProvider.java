package com.tencent.mobileqq.aio.msglist.holder;

import android.content.Context;
import android.util.SparseArray;
import com.tencent.mobileqq.aio.msglist.holder.component.BaseContentComponent;
import com.tencent.mobileqq.aio.msglist.holder.component.avatar.AIOAvatarContentComponent;
import com.tencent.mobileqq.aio.msglist.holder.component.leftswipearea.AIOLeftSwipeAreaComponent;
import com.tencent.mobileqq.aio.msglist.holder.component.mask.AIOContentMaskComponent;
import com.tencent.mobileqq.aio.msglist.holder.component.msgfollow.AIOMsgFollowComponent;
import com.tencent.mobileqq.aio.msglist.holder.component.msgreply.AIOMsgItemReplyComponent;
import com.tencent.mobileqq.aio.msglist.holder.component.msgstatus.AIOMsgStatusComponent;
import com.tencent.mobileqq.aio.msglist.holder.component.msgtail.AIOGeneralMsgTailContentComponent;
import com.tencent.mobileqq.aio.msglist.holder.component.nick.AIONickComponent;
import com.tencent.mobileqq.aio.msglist.holder.component.nick.pit.AIONickComponentV2;
import com.tencent.mobileqq.aio.msglist.holder.component.select.AIOSelectComponent;
import com.tencent.mobileqq.aio.msglist.holder.component.text.AIOTextContentComponent;
import com.tencent.mobileqq.aio.msglist.holder.component.timestamp.AIOTimestampComponent;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b-\u0018\u00002\u00020\u0001B\u00a1\u0002\u0012\u0006\u0010\n\u001a\u00020\u0006\u0012\u0010\b\u0002\u0010\u0010\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u000b\u0012\u0014\b\u0002\u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\u00110\u000b\u0012\u0010\b\u0002\u0010\u0016\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u000b\u0012\u0010\b\u0002\u0010\u0018\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u000b\u0012\u0010\b\u0002\u0010\u001a\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u000b\u0012\u0010\b\u0002\u0010\u001d\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u000b\u0012\u0010\b\u0002\u0010\"\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u000b\u0012\u0010\b\u0002\u0010$\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u000b\u0012\u0010\b\u0002\u0010(\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u000b\u0012\u0010\b\u0002\u0010+\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u000b\u0012\u0010\b\u0002\u0010.\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u000b\u0012\u0010\b\u0002\u00101\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u000b\u0012\u0010\b\u0002\u00103\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u000b\u0012\u0010\b\u0002\u00105\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u000b\u0012\u0010\b\u0002\u00107\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u000b\u00a2\u0006\u0004\b<\u0010=J\u0010\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0002H\u0016J\u0010\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0002H\u0016R\u0017\u0010\n\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0007\u001a\u0004\b\b\u0010\tR\u001f\u0010\u0010\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u000b8\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR#\u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\u00110\u000b8\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\r\u001a\u0004\b\u0012\u0010\u000fR\u001f\u0010\u0016\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u000b8\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\r\u001a\u0004\b\u0015\u0010\u000fR\u001f\u0010\u0018\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u000b8\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\r\u001a\u0004\b\u0017\u0010\u000fR\u001f\u0010\u001a\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u000b8\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\r\u001a\u0004\b\u0019\u0010\u000fR\u001f\u0010\u001d\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u000b8\u0006\u00a2\u0006\f\n\u0004\b\u001b\u0010\r\u001a\u0004\b\u001c\u0010\u000fR*\u0010\"\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u000b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001e\u0010\r\u001a\u0004\b\u001f\u0010\u000f\"\u0004\b \u0010!R\u001f\u0010$\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u000b8\u0006\u00a2\u0006\f\n\u0004\b#\u0010\r\u001a\u0004\b\u001b\u0010\u000fR*\u0010(\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u000b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b%\u0010\r\u001a\u0004\b&\u0010\u000f\"\u0004\b'\u0010!R*\u0010+\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u000b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b)\u0010\r\u001a\u0004\b\u001e\u0010\u000f\"\u0004\b*\u0010!R*\u0010.\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u000b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b,\u0010\r\u001a\u0004\b\f\u0010\u000f\"\u0004\b-\u0010!R*\u00101\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u000b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b/\u0010\r\u001a\u0004\b\u0014\u0010\u000f\"\u0004\b0\u0010!R*\u00103\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u000b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b&\u0010\r\u001a\u0004\b/\u0010\u000f\"\u0004\b2\u0010!R*\u00105\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u000b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0019\u0010\r\u001a\u0004\b,\u0010\u000f\"\u0004\b4\u0010!R*\u00107\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u000b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0017\u0010\r\u001a\u0004\b)\u0010\u000f\"\u0004\b6\u0010!R#\u0010:\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00028BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001f\u00108\u001a\u0004\b#\u00109R#\u0010;\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00028BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001c\u00108\u001a\u0004\b%\u00109\u00a8\u0006>"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/AIOItemComponentProvider;", "Lcom/tencent/mobileqq/aio/msglist/holder/g;", "Landroid/util/SparseArray;", "Lcom/tencent/mobileqq/aio/msglist/holder/component/c;", "get", "a", "Landroid/content/Context;", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "context", "Lkotlin/Function0;", "b", "Lkotlin/jvm/functions/Function0;", "c", "()Lkotlin/jvm/functions/Function0;", "avatarComponentGetter", "Lcom/tencent/mobileqq/aio/msglist/holder/component/BaseContentComponent;", "e", "contentComponentGetter", "d", "f", "contentMaskComponentGetter", "p", "selectComponentGetter", "o", "nickComponentGetter", "g", "r", "timeComponentGetter", tl.h.F, QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, ReportConstant.COSTREPORT_PREFIX, "(Lkotlin/jvm/functions/Function0;)V", "statusComponentGetter", "i", "followComponentGetter", "j", DomainData.DOMAIN_NAME, "setMsgTopTipComponentGetter", "msgTopTipComponentGetter", "k", "setLeftSwipeComponentGetter", "leftSwipeComponentGetter", "l", "setAvatarAtmosphereComponentGetter", "avatarAtmosphereComponentGetter", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "setAvatarEffectComponentGetter", "avatarEffectComponentGetter", "setMsgTailComponentGetter", "msgTailComponentGetter", "setMsgReplyComponentGetter", "msgReplyComponentGetter", "setMsgRecommendComponentGetter", "msgRecommendComponentGetter", "Lkotlin/Lazy;", "()Landroid/util/SparseArray;", "mComponentList", "mLazyComponentList", "<init>", "(Landroid/content/Context;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class AIOItemComponentProvider implements g {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Context context;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Function0<com.tencent.mobileqq.aio.msglist.holder.component.c> avatarComponentGetter;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Function0<BaseContentComponent<?>> contentComponentGetter;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Function0<com.tencent.mobileqq.aio.msglist.holder.component.c> contentMaskComponentGetter;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Function0<com.tencent.mobileqq.aio.msglist.holder.component.c> selectComponentGetter;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Function0<com.tencent.mobileqq.aio.msglist.holder.component.c> nickComponentGetter;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Function0<com.tencent.mobileqq.aio.msglist.holder.component.c> timeComponentGetter;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private Function0<? extends com.tencent.mobileqq.aio.msglist.holder.component.c> statusComponentGetter;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Function0<com.tencent.mobileqq.aio.msglist.holder.component.c> followComponentGetter;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private Function0<? extends com.tencent.mobileqq.aio.msglist.holder.component.c> msgTopTipComponentGetter;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private Function0<? extends com.tencent.mobileqq.aio.msglist.holder.component.c> leftSwipeComponentGetter;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private Function0<? extends com.tencent.mobileqq.aio.msglist.holder.component.c> avatarAtmosphereComponentGetter;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private Function0<? extends com.tencent.mobileqq.aio.msglist.holder.component.c> avatarEffectComponentGetter;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private Function0<? extends com.tencent.mobileqq.aio.msglist.holder.component.c> msgTailComponentGetter;

    /* renamed from: o, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private Function0<? extends com.tencent.mobileqq.aio.msglist.holder.component.c> msgReplyComponentGetter;

    /* renamed from: p, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private Function0<? extends com.tencent.mobileqq.aio.msglist.holder.component.c> msgRecommendComponentGetter;

    /* renamed from: q, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy mComponentList;

    /* renamed from: r, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy mLazyComponentList;

    public AIOItemComponentProvider(@NotNull Context context, @NotNull Function0<? extends com.tencent.mobileqq.aio.msglist.holder.component.c> avatarComponentGetter, @NotNull Function0<? extends BaseContentComponent<?>> contentComponentGetter, @NotNull Function0<? extends com.tencent.mobileqq.aio.msglist.holder.component.c> contentMaskComponentGetter, @NotNull Function0<? extends com.tencent.mobileqq.aio.msglist.holder.component.c> selectComponentGetter, @NotNull Function0<? extends com.tencent.mobileqq.aio.msglist.holder.component.c> nickComponentGetter, @NotNull Function0<? extends com.tencent.mobileqq.aio.msglist.holder.component.c> timeComponentGetter, @NotNull Function0<? extends com.tencent.mobileqq.aio.msglist.holder.component.c> statusComponentGetter, @NotNull Function0<? extends com.tencent.mobileqq.aio.msglist.holder.component.c> followComponentGetter, @NotNull Function0<? extends com.tencent.mobileqq.aio.msglist.holder.component.c> msgTopTipComponentGetter, @NotNull Function0<? extends com.tencent.mobileqq.aio.msglist.holder.component.c> leftSwipeComponentGetter, @NotNull Function0<? extends com.tencent.mobileqq.aio.msglist.holder.component.c> avatarAtmosphereComponentGetter, @NotNull Function0<? extends com.tencent.mobileqq.aio.msglist.holder.component.c> avatarEffectComponentGetter, @NotNull Function0<? extends com.tencent.mobileqq.aio.msglist.holder.component.c> msgTailComponentGetter, @NotNull Function0<? extends com.tencent.mobileqq.aio.msglist.holder.component.c> msgReplyComponentGetter, @NotNull Function0<? extends com.tencent.mobileqq.aio.msglist.holder.component.c> msgRecommendComponentGetter) {
        Lazy lazy;
        Lazy lazy2;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(avatarComponentGetter, "avatarComponentGetter");
        Intrinsics.checkNotNullParameter(contentComponentGetter, "contentComponentGetter");
        Intrinsics.checkNotNullParameter(contentMaskComponentGetter, "contentMaskComponentGetter");
        Intrinsics.checkNotNullParameter(selectComponentGetter, "selectComponentGetter");
        Intrinsics.checkNotNullParameter(nickComponentGetter, "nickComponentGetter");
        Intrinsics.checkNotNullParameter(timeComponentGetter, "timeComponentGetter");
        Intrinsics.checkNotNullParameter(statusComponentGetter, "statusComponentGetter");
        Intrinsics.checkNotNullParameter(followComponentGetter, "followComponentGetter");
        Intrinsics.checkNotNullParameter(msgTopTipComponentGetter, "msgTopTipComponentGetter");
        Intrinsics.checkNotNullParameter(leftSwipeComponentGetter, "leftSwipeComponentGetter");
        Intrinsics.checkNotNullParameter(avatarAtmosphereComponentGetter, "avatarAtmosphereComponentGetter");
        Intrinsics.checkNotNullParameter(avatarEffectComponentGetter, "avatarEffectComponentGetter");
        Intrinsics.checkNotNullParameter(msgTailComponentGetter, "msgTailComponentGetter");
        Intrinsics.checkNotNullParameter(msgReplyComponentGetter, "msgReplyComponentGetter");
        Intrinsics.checkNotNullParameter(msgRecommendComponentGetter, "msgRecommendComponentGetter");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, context, avatarComponentGetter, contentComponentGetter, contentMaskComponentGetter, selectComponentGetter, nickComponentGetter, timeComponentGetter, statusComponentGetter, followComponentGetter, msgTopTipComponentGetter, leftSwipeComponentGetter, avatarAtmosphereComponentGetter, avatarEffectComponentGetter, msgTailComponentGetter, msgReplyComponentGetter, msgRecommendComponentGetter);
            return;
        }
        this.context = context;
        this.avatarComponentGetter = avatarComponentGetter;
        this.contentComponentGetter = contentComponentGetter;
        this.contentMaskComponentGetter = contentMaskComponentGetter;
        this.selectComponentGetter = selectComponentGetter;
        this.nickComponentGetter = nickComponentGetter;
        this.timeComponentGetter = timeComponentGetter;
        this.statusComponentGetter = statusComponentGetter;
        this.followComponentGetter = followComponentGetter;
        this.msgTopTipComponentGetter = msgTopTipComponentGetter;
        this.leftSwipeComponentGetter = leftSwipeComponentGetter;
        this.avatarAtmosphereComponentGetter = avatarAtmosphereComponentGetter;
        this.avatarEffectComponentGetter = avatarEffectComponentGetter;
        this.msgTailComponentGetter = msgTailComponentGetter;
        this.msgReplyComponentGetter = msgReplyComponentGetter;
        this.msgRecommendComponentGetter = msgRecommendComponentGetter;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<SparseArray<com.tencent.mobileqq.aio.msglist.holder.component.c>>() { // from class: com.tencent.mobileqq.aio.msglist.holder.AIOItemComponentProvider$mComponentList$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AIOItemComponentProvider.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final SparseArray<com.tencent.mobileqq.aio.msglist.holder.component.c> invoke() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (SparseArray) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
                SparseArray<com.tencent.mobileqq.aio.msglist.holder.component.c> sparseArray = new SparseArray<>();
                AIOItemComponentProvider aIOItemComponentProvider = AIOItemComponentProvider.this;
                sparseArray.put(2, aIOItemComponentProvider.e().invoke());
                sparseArray.put(0, aIOItemComponentProvider.c().invoke());
                sparseArray.put(1, aIOItemComponentProvider.o().invoke());
                sparseArray.put(4, aIOItemComponentProvider.r().invoke());
                sparseArray.put(5, aIOItemComponentProvider.q().invoke());
                sparseArray.put(7, aIOItemComponentProvider.g().invoke());
                sparseArray.put(6, aIOItemComponentProvider.n().invoke());
                sparseArray.put(3, aIOItemComponentProvider.p().invoke());
                sparseArray.put(11, aIOItemComponentProvider.d().invoke());
                sparseArray.put(10, aIOItemComponentProvider.b().invoke());
                sparseArray.put(12, aIOItemComponentProvider.m().invoke());
                sparseArray.put(13, aIOItemComponentProvider.f().invoke());
                sparseArray.put(14, aIOItemComponentProvider.l().invoke());
                sparseArray.put(15, aIOItemComponentProvider.k().invoke());
                return sparseArray;
            }
        });
        this.mComponentList = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<SparseArray<com.tencent.mobileqq.aio.msglist.holder.component.c>>() { // from class: com.tencent.mobileqq.aio.msglist.holder.AIOItemComponentProvider$mLazyComponentList$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AIOItemComponentProvider.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final SparseArray<com.tencent.mobileqq.aio.msglist.holder.component.c> invoke() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (SparseArray) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
                SparseArray<com.tencent.mobileqq.aio.msglist.holder.component.c> sparseArray = new SparseArray<>();
                sparseArray.put(8, AIOItemComponentProvider.this.h().invoke());
                return sparseArray;
            }
        });
        this.mLazyComponentList = lazy2;
    }

    private final SparseArray<com.tencent.mobileqq.aio.msglist.holder.component.c> i() {
        return (SparseArray) this.mComponentList.getValue();
    }

    private final SparseArray<com.tencent.mobileqq.aio.msglist.holder.component.c> j() {
        return (SparseArray) this.mLazyComponentList.getValue();
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.g
    @NotNull
    public SparseArray<com.tencent.mobileqq.aio.msglist.holder.component.c> a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            return (SparseArray) iPatchRedirector.redirect((short) 28, (Object) this);
        }
        return j();
    }

    @NotNull
    public final Function0<com.tencent.mobileqq.aio.msglist.holder.component.c> b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return (Function0) iPatchRedirector.redirect((short) 17, (Object) this);
        }
        return this.avatarAtmosphereComponentGetter;
    }

    @NotNull
    public final Function0<com.tencent.mobileqq.aio.msglist.holder.component.c> c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (Function0) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.avatarComponentGetter;
    }

    @NotNull
    public final Function0<com.tencent.mobileqq.aio.msglist.holder.component.c> d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return (Function0) iPatchRedirector.redirect((short) 19, (Object) this);
        }
        return this.avatarEffectComponentGetter;
    }

    @NotNull
    public final Function0<BaseContentComponent<?>> e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (Function0) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.contentComponentGetter;
    }

    @NotNull
    public final Function0<com.tencent.mobileqq.aio.msglist.holder.component.c> f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (Function0) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.contentMaskComponentGetter;
    }

    @NotNull
    public final Function0<com.tencent.mobileqq.aio.msglist.holder.component.c> g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (Function0) iPatchRedirector.redirect((short) 12, (Object) this);
        }
        return this.followComponentGetter;
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.g
    @NotNull
    public SparseArray<com.tencent.mobileqq.aio.msglist.holder.component.c> get() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            return (SparseArray) iPatchRedirector.redirect((short) 27, (Object) this);
        }
        return i();
    }

    @NotNull
    public final Function0<com.tencent.mobileqq.aio.msglist.holder.component.c> h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return (Function0) iPatchRedirector.redirect((short) 15, (Object) this);
        }
        return this.leftSwipeComponentGetter;
    }

    @NotNull
    public final Function0<com.tencent.mobileqq.aio.msglist.holder.component.c> k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            return (Function0) iPatchRedirector.redirect((short) 25, (Object) this);
        }
        return this.msgRecommendComponentGetter;
    }

    @NotNull
    public final Function0<com.tencent.mobileqq.aio.msglist.holder.component.c> l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return (Function0) iPatchRedirector.redirect((short) 23, (Object) this);
        }
        return this.msgReplyComponentGetter;
    }

    @NotNull
    public final Function0<com.tencent.mobileqq.aio.msglist.holder.component.c> m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return (Function0) iPatchRedirector.redirect((short) 21, (Object) this);
        }
        return this.msgTailComponentGetter;
    }

    @NotNull
    public final Function0<com.tencent.mobileqq.aio.msglist.holder.component.c> n() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (Function0) iPatchRedirector.redirect((short) 13, (Object) this);
        }
        return this.msgTopTipComponentGetter;
    }

    @NotNull
    public final Function0<com.tencent.mobileqq.aio.msglist.holder.component.c> o() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (Function0) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return this.nickComponentGetter;
    }

    @NotNull
    public final Function0<com.tencent.mobileqq.aio.msglist.holder.component.c> p() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (Function0) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return this.selectComponentGetter;
    }

    @NotNull
    public final Function0<com.tencent.mobileqq.aio.msglist.holder.component.c> q() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (Function0) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        return this.statusComponentGetter;
    }

    @NotNull
    public final Function0<com.tencent.mobileqq.aio.msglist.holder.component.c> r() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (Function0) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return this.timeComponentGetter;
    }

    public final void s(@NotNull Function0<? extends com.tencent.mobileqq.aio.msglist.holder.component.c> function0) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) function0);
        } else {
            Intrinsics.checkNotNullParameter(function0, "<set-?>");
            this.statusComponentGetter = function0;
        }
    }

    public /* synthetic */ AIOItemComponentProvider(Context context, Function0 function0, Function0 function02, Function0 function03, Function0 function04, Function0 function05, Function0 function06, Function0 function07, Function0 function08, Function0 function09, Function0 function010, Function0 function011, Function0 function012, Function0 function013, Function0 function014, Function0 function015, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? new Function0<AIOAvatarContentComponent>(context) { // from class: com.tencent.mobileqq.aio.msglist.holder.AIOItemComponentProvider.1
            static IPatchRedirector $redirector_;
            final /* synthetic */ Context $context;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.$context = context;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final AIOAvatarContentComponent invoke() {
                IPatchRedirector iPatchRedirector = $redirector_;
                return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) ? new AIOAvatarContentComponent(this.$context) : (AIOAvatarContentComponent) iPatchRedirector.redirect((short) 2, (Object) this);
            }
        } : function0, (i3 & 4) != 0 ? new Function0<AIOTextContentComponent>(context) { // from class: com.tencent.mobileqq.aio.msglist.holder.AIOItemComponentProvider.2
            static IPatchRedirector $redirector_;
            final /* synthetic */ Context $context;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.$context = context;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final AIOTextContentComponent invoke() {
                IPatchRedirector iPatchRedirector = $redirector_;
                return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) ? new AIOTextContentComponent(this.$context) : (AIOTextContentComponent) iPatchRedirector.redirect((short) 2, (Object) this);
            }
        } : function02, (i3 & 8) != 0 ? new Function0<AIOContentMaskComponent>(context) { // from class: com.tencent.mobileqq.aio.msglist.holder.AIOItemComponentProvider.3
            static IPatchRedirector $redirector_;
            final /* synthetic */ Context $context;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.$context = context;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final AIOContentMaskComponent invoke() {
                IPatchRedirector iPatchRedirector = $redirector_;
                return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) ? new AIOContentMaskComponent(this.$context) : (AIOContentMaskComponent) iPatchRedirector.redirect((short) 2, (Object) this);
            }
        } : function03, (i3 & 16) != 0 ? new Function0<AIOSelectComponent>(context) { // from class: com.tencent.mobileqq.aio.msglist.holder.AIOItemComponentProvider.4
            static IPatchRedirector $redirector_;
            final /* synthetic */ Context $context;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.$context = context;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final AIOSelectComponent invoke() {
                IPatchRedirector iPatchRedirector = $redirector_;
                return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) ? new AIOSelectComponent(this.$context) : (AIOSelectComponent) iPatchRedirector.redirect((short) 2, (Object) this);
            }
        } : function04, (i3 & 32) != 0 ? new Function0<com.tencent.mobileqq.aio.msglist.holder.component.c>(context) { // from class: com.tencent.mobileqq.aio.msglist.holder.AIOItemComponentProvider.5
            static IPatchRedirector $redirector_;
            final /* synthetic */ Context $context;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.$context = context;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @Nullable
            public final com.tencent.mobileqq.aio.msglist.holder.component.c invoke() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return (com.tencent.mobileqq.aio.msglist.holder.component.c) iPatchRedirector.redirect((short) 2, (Object) this);
                }
                if (com.tencent.mobileqq.aio.msglist.holder.component.nick.blockgroup.a.f191356a.b()) {
                    return new AIONickComponentV2(this.$context);
                }
                return new AIONickComponent(this.$context);
            }
        } : function05, (i3 & 64) != 0 ? new Function0<AIOTimestampComponent>(context) { // from class: com.tencent.mobileqq.aio.msglist.holder.AIOItemComponentProvider.6
            static IPatchRedirector $redirector_;
            final /* synthetic */ Context $context;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.$context = context;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final AIOTimestampComponent invoke() {
                IPatchRedirector iPatchRedirector = $redirector_;
                return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) ? new AIOTimestampComponent(this.$context) : (AIOTimestampComponent) iPatchRedirector.redirect((short) 2, (Object) this);
            }
        } : function06, (i3 & 128) != 0 ? new Function0<AIOMsgStatusComponent>(context) { // from class: com.tencent.mobileqq.aio.msglist.holder.AIOItemComponentProvider.7
            static IPatchRedirector $redirector_;
            final /* synthetic */ Context $context;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.$context = context;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final AIOMsgStatusComponent invoke() {
                IPatchRedirector iPatchRedirector = $redirector_;
                return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) ? new AIOMsgStatusComponent(this.$context, false, false, 6, null) : (AIOMsgStatusComponent) iPatchRedirector.redirect((short) 2, (Object) this);
            }
        } : function07, (i3 & 256) != 0 ? new Function0<AIOMsgFollowComponent>(context) { // from class: com.tencent.mobileqq.aio.msglist.holder.AIOItemComponentProvider.8
            static IPatchRedirector $redirector_;
            final /* synthetic */ Context $context;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.$context = context;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final AIOMsgFollowComponent invoke() {
                IPatchRedirector iPatchRedirector = $redirector_;
                return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) ? new AIOMsgFollowComponent(this.$context) : (AIOMsgFollowComponent) iPatchRedirector.redirect((short) 2, (Object) this);
            }
        } : function08, (i3 & 512) != 0 ? new Function0<com.tencent.mobileqq.aio.msglist.holder.component.msgtoptip.a>(context) { // from class: com.tencent.mobileqq.aio.msglist.holder.AIOItemComponentProvider.9
            static IPatchRedirector $redirector_;
            final /* synthetic */ Context $context;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.$context = context;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final com.tencent.mobileqq.aio.msglist.holder.component.msgtoptip.a invoke() {
                IPatchRedirector iPatchRedirector = $redirector_;
                return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) ? new com.tencent.mobileqq.aio.msglist.holder.component.msgtoptip.a(this.$context) : (com.tencent.mobileqq.aio.msglist.holder.component.msgtoptip.a) iPatchRedirector.redirect((short) 2, (Object) this);
            }
        } : function09, (i3 & 1024) != 0 ? new Function0<AIOLeftSwipeAreaComponent>(context) { // from class: com.tencent.mobileqq.aio.msglist.holder.AIOItemComponentProvider.10
            static IPatchRedirector $redirector_;
            final /* synthetic */ Context $context;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.$context = context;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final AIOLeftSwipeAreaComponent invoke() {
                IPatchRedirector iPatchRedirector = $redirector_;
                return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) ? new AIOLeftSwipeAreaComponent(this.$context) : (AIOLeftSwipeAreaComponent) iPatchRedirector.redirect((short) 2, (Object) this);
            }
        } : function010, (i3 & 2048) != 0 ? AnonymousClass11.INSTANCE : function011, (i3 & 4096) != 0 ? AnonymousClass12.INSTANCE : function012, (i3 & 8192) != 0 ? new Function0<AIOGeneralMsgTailContentComponent>(context) { // from class: com.tencent.mobileqq.aio.msglist.holder.AIOItemComponentProvider.13
            static IPatchRedirector $redirector_;
            final /* synthetic */ Context $context;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.$context = context;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final AIOGeneralMsgTailContentComponent invoke() {
                IPatchRedirector iPatchRedirector = $redirector_;
                return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) ? new AIOGeneralMsgTailContentComponent(this.$context) : (AIOGeneralMsgTailContentComponent) iPatchRedirector.redirect((short) 2, (Object) this);
            }
        } : function013, (i3 & 16384) != 0 ? new Function0<AIOMsgItemReplyComponent>(context) { // from class: com.tencent.mobileqq.aio.msglist.holder.AIOItemComponentProvider.14
            static IPatchRedirector $redirector_;
            final /* synthetic */ Context $context;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.$context = context;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final AIOMsgItemReplyComponent invoke() {
                IPatchRedirector iPatchRedirector = $redirector_;
                return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) ? new AIOMsgItemReplyComponent(this.$context) : (AIOMsgItemReplyComponent) iPatchRedirector.redirect((short) 2, (Object) this);
            }
        } : function014, (32768 & i3) != 0 ? AnonymousClass15.INSTANCE : function015);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, context, function0, function02, function03, function04, function05, function06, function07, function08, function09, function010, function011, function012, function013, function014, function015, Integer.valueOf(i3), defaultConstructorMarker);
    }
}
