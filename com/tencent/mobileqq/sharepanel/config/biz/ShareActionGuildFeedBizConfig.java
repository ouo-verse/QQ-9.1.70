package com.tencent.mobileqq.sharepanel.config.biz;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00042\u00020\u0001:\u0001\u0004B\u0007\u00a2\u0006\u0004\b\u0005\u0010\u0006J\u000e\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/sharepanel/config/biz/ShareActionGuildFeedBizConfig;", "Lcom/tencent/mobileqq/sharepanel/config/biz/a;", "", "Lcom/tencent/mobileqq/sharepanel/config/biz/c;", "a", "<init>", "()V", "qq-sharepanel-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class ShareActionGuildFeedBizConfig implements a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private static final List<String> f287216b;

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    private static final Lazy<c> f287217c;

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    private static final Lazy<c> f287218d;

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    private static final Lazy<c> f287219e;

    /* renamed from: f, reason: collision with root package name */
    @NotNull
    private static final Lazy<c> f287220f;

    /* renamed from: g, reason: collision with root package name */
    @NotNull
    private static final Lazy<c> f287221g;

    /* renamed from: h, reason: collision with root package name */
    @NotNull
    private static final Lazy<c> f287222h;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001b\u0010\u001cR\u001b\u0010\u0007\u001a\u00020\u00028FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\n\u001a\u00020\u00028FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\b\u0010\u0004\u001a\u0004\b\t\u0010\u0006R\u001b\u0010\r\u001a\u00020\u00028FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006R\u001b\u0010\u0010\u001a\u00020\u00028FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000e\u0010\u0004\u001a\u0004\b\u000f\u0010\u0006R\u001b\u0010\u0013\u001a\u00020\u00028FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0004\u001a\u0004\b\u0012\u0010\u0006R\u001b\u0010\u0016\u001a\u00020\u00028FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0004\u001a\u0004\b\u0015\u0010\u0006R\u001a\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00180\u00178\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001a\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/mobileqq/sharepanel/config/biz/ShareActionGuildFeedBizConfig$a;", "", "Lcom/tencent/mobileqq/sharepanel/config/biz/c;", "guildFeedNativeDetailBizInfo$delegate", "Lkotlin/Lazy;", "d", "()Lcom/tencent/mobileqq/sharepanel/config/biz/c;", "guildFeedNativeDetailBizInfo", "guildFeedListBizInfo$delegate", "c", "guildFeedListBizInfo", "guildFeedImmersionBizInfo$delegate", "b", "guildFeedImmersionBizInfo", "guildFeedGalleryPageBizInfo$delegate", "a", "guildFeedGalleryPageBizInfo", "guildFeedPicViewBizInfo$delegate", "e", "guildFeedPicViewBizInfo", "guildFeedTroopBizInfo$delegate", "f", "guildFeedTroopBizInfo", "", "", "defaultChannels", "Ljava/util/List;", "<init>", "()V", "qq-sharepanel-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.sharepanel.config.biz.ShareActionGuildFeedBizConfig$a, reason: from kotlin metadata */
    /* loaded from: classes18.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 8)) {
                return;
            }
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) defaultConstructorMarker);
        }

        @NotNull
        public final c a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return (c) iPatchRedirector.redirect((short) 5, (Object) this);
            }
            return (c) ShareActionGuildFeedBizConfig.f287220f.getValue();
        }

        @NotNull
        public final c b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (c) iPatchRedirector.redirect((short) 4, (Object) this);
            }
            return (c) ShareActionGuildFeedBizConfig.f287219e.getValue();
        }

        @NotNull
        public final c c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (c) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            return (c) ShareActionGuildFeedBizConfig.f287218d.getValue();
        }

        @NotNull
        public final c d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (c) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return (c) ShareActionGuildFeedBizConfig.f287217c.getValue();
        }

        @NotNull
        public final c e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return (c) iPatchRedirector.redirect((short) 6, (Object) this);
            }
            return (c) ShareActionGuildFeedBizConfig.f287221g.getValue();
        }

        @NotNull
        public final c f() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return (c) iPatchRedirector.redirect((short) 7, (Object) this);
            }
            return (c) ShareActionGuildFeedBizConfig.f287222h.getValue();
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
        List<String> listOf;
        Lazy<c> lazy;
        Lazy<c> lazy2;
        Lazy<c> lazy3;
        Lazy<c> lazy4;
        Lazy<c> lazy5;
        Lazy<c> lazy6;
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(33047);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
            return;
        }
        INSTANCE = new Companion(null);
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{"qqfriend", "qqchannel", "weixin", "weixincircle", "qzoneshuoshuo", "redbook"});
        f287216b = listOf;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<c>() { // from class: com.tencent.mobileqq.sharepanel.config.biz.ShareActionGuildFeedBizConfig$Companion$guildFeedNativeDetailBizInfo$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final c invoke() {
                List listOf2;
                List list;
                listOf2 = CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{"edit", "pin_to_homepage", "uppin_homepage", "pin_to_section", "uppin_section", "move_post", "generate_share_image", WinkDaTongReportConstant.ElementParamValue.XSJ_SHARE_COPY_LINK, "floating_window", "delete", "report_abuse", "debug_admin_delete_feed", "debug_admin_block_user"});
                list = ShareActionGuildFeedBizConfig.f287216b;
                return new c("pindao_feeddetail", list, listOf2, null, listOf2, 8, null);
            }
        });
        f287217c = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<c>() { // from class: com.tencent.mobileqq.sharepanel.config.biz.ShareActionGuildFeedBizConfig$Companion$guildFeedListBizInfo$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final c invoke() {
                List listOf2;
                List list;
                listOf2 = CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{"not_interested", "edit", "pin_to_homepage", "uppin_homepage", "pin_to_section", "uppin_section", "move_post", "batch_manage", "generate_share_image", WinkDaTongReportConstant.ElementParamValue.XSJ_SHARE_COPY_LINK, "delete", "report_abuse", "debug_admin_delete_feed", "debug_admin_block_user"});
                list = ShareActionGuildFeedBizConfig.f287216b;
                return new c("pindao_feed", list, listOf2, null, listOf2, 8, null);
            }
        });
        f287218d = lazy2;
        lazy3 = LazyKt__LazyJVMKt.lazy(new Function0<c>() { // from class: com.tencent.mobileqq.sharepanel.config.biz.ShareActionGuildFeedBizConfig$Companion$guildFeedImmersionBizInfo$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final c invoke() {
                List listOf2;
                List list;
                listOf2 = CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{"pin_to_homepage", "uppin_homepage", "pin_to_section", "uppin_section", "move_post", "save_to_phone", "generate_share_image", WinkDaTongReportConstant.ElementParamValue.XSJ_SHARE_COPY_LINK, "floating_window", "delete", "recognize_qr_code", "report_abuse", "debug_admin_delete_feed", "debug_admin_block_user"});
                list = ShareActionGuildFeedBizConfig.f287216b;
                return new c("pindao_feedimmersion", list, listOf2, null, listOf2, 8, null);
            }
        });
        f287219e = lazy3;
        lazy4 = LazyKt__LazyJVMKt.lazy(new Function0<c>() { // from class: com.tencent.mobileqq.sharepanel.config.biz.ShareActionGuildFeedBizConfig$Companion$guildFeedGalleryPageBizInfo$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final c invoke() {
                List listOf2;
                List list;
                listOf2 = CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{"pin_to_homepage", "uppin_homepage", "pin_to_section", "uppin_section", "move_post", "save_to_phone", "generate_share_image", WinkDaTongReportConstant.ElementParamValue.XSJ_SHARE_COPY_LINK, "floating_window", "delete", "recognize_qr_code", "report_abuse", "debug_admin_delete_feed", "debug_admin_block_user"});
                list = ShareActionGuildFeedBizConfig.f287216b;
                return new c("pindao_feedpicture", list, listOf2, null, listOf2, 8, null);
            }
        });
        f287220f = lazy4;
        lazy5 = LazyKt__LazyJVMKt.lazy(new Function0<c>() { // from class: com.tencent.mobileqq.sharepanel.config.biz.ShareActionGuildFeedBizConfig$Companion$guildFeedPicViewBizInfo$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final c invoke() {
                List listOf2;
                List listOf3;
                listOf2 = CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{"save_to_phone", "recognize_qr_code"});
                listOf3 = CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{"qqfriend", "qqchannel"});
                return new c("pindao_feedcomment", listOf3, listOf2, null, listOf2, 8, null);
            }
        });
        f287221g = lazy5;
        lazy6 = LazyKt__LazyJVMKt.lazy(new Function0<c>() { // from class: com.tencent.mobileqq.sharepanel.config.biz.ShareActionGuildFeedBizConfig$Companion$guildFeedTroopBizInfo$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final c invoke() {
                List listOf2;
                List emptyList;
                listOf2 = CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{"edit", "pin_to_homepage", "uppin_homepage", "save_to_phone", "delete", "recognize_qr_code", "report_abuse"});
                emptyList = CollectionsKt__CollectionsKt.emptyList();
                return new c("group_feedimmersion", emptyList, listOf2, null, listOf2, 8, null);
            }
        });
        f287222h = lazy6;
    }

    public ShareActionGuildFeedBizConfig() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.sharepanel.config.biz.a
    @NotNull
    public List<c> a() {
        List<c> listOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (List) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        Companion companion = INSTANCE;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new c[]{companion.d(), companion.c(), companion.b(), companion.a(), companion.e(), companion.f()});
        return listOf;
    }
}
