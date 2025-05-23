package bp0;

import android.app.Activity;
import android.view.View;
import androidx.collection.ArraySet;
import com.tencent.common.app.AppInterface;
import com.tencent.guild.aio.input.at.quickAt.dialogui.framework.a;
import com.tencent.guild.aio.input.at.trooptag.dialogui.bean.HashTagPageType;
import com.tencent.guild.aio.input.at.trooptag.model.ChannelListRepository;
import com.tencent.guild.aio.input.at.trooptag.model.TroopListRepository;
import com.tencent.guild.aio.input.at.utils.j;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qqlive.module.videoreport.PageParams;
import com.tencent.qqlive.module.videoreport.VideoReport;
import cp0.HashTagChannelData;
import cp0.HashTagEmptyPageData;
import cp0.HashTagGroupData;
import dp0.a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Foreground;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 ;2\u00020\u00012\u00020\u0002:\u0001\u001bB\u000f\u0012\u0006\u0010(\u001a\u00020%\u00a2\u0006\u0004\b9\u0010:J(\u0010\n\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u00032\u0016\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007H\u0002J\b\u0010\u000b\u001a\u00020\tH\u0002J\b\u0010\f\u001a\u00020\tH\u0002J\b\u0010\r\u001a\u00020\tH\u0002J\u0010\u0010\u000e\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J\u0012\u0010\u0014\u001a\u00020\t2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0016J\b\u0010\u0015\u001a\u00020\tH\u0016J\u0010\u0010\u0018\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\u0016H\u0016J\b\u0010\u001a\u001a\u00020\u0019H\u0016J\b\u0010\u001b\u001a\u00020\u0016H\u0016J\u0010\u0010\u001d\u001a\u00020\t2\u0006\u0010\u001c\u001a\u00020\u0019H\u0016J\b\u0010\u001e\u001a\u00020\tH\u0016J\b\u0010\u001f\u001a\u00020\tH\u0016J\u001a\u0010#\u001a\u00020\t2\b\u0010!\u001a\u0004\u0018\u00010 2\u0006\u0010\"\u001a\u00020\u0003H\u0016J\u0012\u0010$\u001a\u00020\t2\b\u0010!\u001a\u0004\u0018\u00010 H\u0016R\u0014\u0010(\u001a\u00020%8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b&\u0010'R\u0018\u0010*\u001a\u0004\u0018\u00010 8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010)R\u0018\u0010.\u001a\u0004\u0018\u00010+8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b,\u0010-R\u001a\u00102\u001a\b\u0012\u0004\u0012\u00020\u00120/8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b0\u00101R\u0014\u00105\u001a\u0002038\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b$\u00104R\u0014\u00108\u001a\u0002068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001a\u00107\u00a8\u0006<"}, d2 = {"Lbp0/a;", "Lip0/c;", "Lcom/tencent/guild/aio/input/at/quickAt/dialogui/framework/a$a;", "Lcom/tencent/guild/aio/input/at/trooptag/dialogui/bean/HashTagPageType;", "pageType", "Ljava/util/ArrayList;", "Lcp0/a;", "Lkotlin/collections/ArrayList;", "dataList", "", DomainData.DOMAIN_NAME, QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, ReportConstant.COSTREPORT_PREFIX, "o", "r", "", "event", "p", "Lip0/d;", "listener", "e", "destroy", "", "anim", "l", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "a", "flag", "H0", "c", "b", "Landroid/view/View;", "anchor", "showListType", "g", "i", "Lcom/tencent/guild/aio/input/at/trooptag/dialogui/bean/a;", "d", "Lcom/tencent/guild/aio/input/at/trooptag/dialogui/bean/a;", "panelContext", "Landroid/view/View;", "mAnchor", "Ldp0/a;", "f", "Ldp0/a;", "panelDialog", "Landroidx/collection/ArraySet;", h.F, "Landroidx/collection/ArraySet;", "mLateJoinListeners", "Lcom/tencent/guild/aio/input/at/trooptag/model/TroopListRepository;", "Lcom/tencent/guild/aio/input/at/trooptag/model/TroopListRepository;", "troopListRepository", "Lcom/tencent/guild/aio/input/at/trooptag/model/ChannelListRepository;", "Lcom/tencent/guild/aio/input/at/trooptag/model/ChannelListRepository;", "channelListRepository", "<init>", "(Lcom/tencent/guild/aio/input/at/trooptag/dialogui/bean/a;)V", BdhLogUtil.LogTag.Tag_Conn, "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class a implements ip0.c, a.InterfaceC1190a {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.guild.aio.input.at.trooptag.dialogui.bean.a panelContext;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private View mAnchor;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private dp0.a panelDialog;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ArraySet<ip0.d> mLateJoinListeners;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final TroopListRepository troopListRepository;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ChannelListRepository channelListRepository;

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes6.dex */
    public /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f28746a;

        static {
            int[] iArr = new int[HashTagPageType.values().length];
            try {
                iArr[HashTagPageType.Troop_Page.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            f28746a = iArr;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\u0007\u001a\u00020\u00062\u0016\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u0004H\u0016\u00a8\u0006\b"}, d2 = {"bp0/a$c", "Lcom/tencent/guild/aio/input/at/trooptag/model/b;", "Ljava/util/ArrayList;", "Lcp0/a;", "Lkotlin/collections/ArrayList;", "dataList", "", "a", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class c implements com.tencent.guild.aio.input.at.trooptag.model.b {
        c() {
        }

        @Override // com.tencent.guild.aio.input.at.trooptag.model.b
        public void a(@NotNull ArrayList<cp0.a> dataList) {
            Intrinsics.checkNotNullParameter(dataList, "dataList");
            a.this.n(HashTagPageType.Channel_Page, dataList);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\u0007\u001a\u00020\u00062\u0016\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u0004H\u0016\u00a8\u0006\b"}, d2 = {"bp0/a$d", "Lcom/tencent/guild/aio/input/at/trooptag/model/b;", "Ljava/util/ArrayList;", "Lcp0/a;", "Lkotlin/collections/ArrayList;", "dataList", "", "a", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class d implements com.tencent.guild.aio.input.at.trooptag.model.b {
        d() {
        }

        @Override // com.tencent.guild.aio.input.at.trooptag.model.b
        public void a(@NotNull ArrayList<cp0.a> dataList) {
            Intrinsics.checkNotNullParameter(dataList, "dataList");
            a.this.n(HashTagPageType.Troop_Page, dataList);
        }
    }

    public a(@NotNull com.tencent.guild.aio.input.at.trooptag.dialogui.bean.a panelContext) {
        Intrinsics.checkNotNullParameter(panelContext, "panelContext");
        this.panelContext = panelContext;
        this.mLateJoinListeners = new ArraySet<>();
        this.troopListRepository = new TroopListRepository();
        this.channelListRepository = new ChannelListRepository();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void n(HashTagPageType pageType, ArrayList<cp0.a> dataList) {
        Object first;
        HashTagGroupData hashTagGroupData;
        Object first2;
        boolean z16;
        if (dataList.isEmpty()) {
            r(pageType);
            return;
        }
        if (this.panelContext.j().size() == 1) {
            first = CollectionsKt___CollectionsKt.first((List<? extends Object>) dataList);
            HashTagGroupData hashTagGroupData2 = null;
            if (first instanceof HashTagGroupData) {
                hashTagGroupData = (HashTagGroupData) first;
            } else {
                hashTagGroupData = null;
            }
            if (hashTagGroupData != null) {
                hashTagGroupData.m(pageType.getTitle());
            }
            if (this.panelContext.b() == 1000050) {
                first2 = CollectionsKt___CollectionsKt.first((List<? extends Object>) dataList);
                if (first2 instanceof HashTagGroupData) {
                    hashTagGroupData2 = (HashTagGroupData) first2;
                }
                if (hashTagGroupData2 != null) {
                    hashTagGroupData2.m("\u9891\u9053\u5185\u5730\u5740");
                }
                for (cp0.a aVar : dataList) {
                    if (aVar instanceof HashTagChannelData) {
                        HashTagChannelData hashTagChannelData = (HashTagChannelData) aVar;
                        long channelUin = hashTagChannelData.getChannelUin();
                        String a16 = this.panelContext.a();
                        Intrinsics.checkNotNullExpressionValue(a16, "panelContext.channelId");
                        if (channelUin == Long.parseLong(a16)) {
                            z16 = true;
                        } else {
                            z16 = false;
                        }
                        hashTagChannelData.l(z16);
                    }
                }
            }
        }
        dp0.a aVar2 = this.panelDialog;
        if (aVar2 != null) {
            aVar2.X(pageType, dataList);
        }
    }

    private final void o() {
        fp0.a notifier;
        boolean a16 = so0.d.a();
        dp0.a aVar = this.panelDialog;
        if (aVar == null || a16) {
            if (aVar != null) {
                aVar.H();
            }
            dp0.a a17 = new a.C10196a(this.panelContext).a();
            this.panelDialog = a17;
            if (a17 != null) {
                a17.O(this);
            }
            if (!this.mLateJoinListeners.isEmpty()) {
                dp0.a aVar2 = this.panelDialog;
                if (aVar2 != null && (notifier = aVar2.getNotifier()) != null) {
                    notifier.b(this.mLateJoinListeners);
                }
                this.mLateJoinListeners.clear();
            }
        }
    }

    private final void p(String event) {
        HashMap hashMapOf;
        View contentView;
        Activity topActivity = Foreground.getTopActivity();
        if (topActivity != null) {
            VideoReport.addToDetectionWhitelist(topActivity);
        }
        hashMapOf = MapsKt__MapsKt.hashMapOf(TuplesKt.to("dt_pgid", "pg_sgrp_sub_channel_link"), TuplesKt.to("sgrp_channel_id", this.panelContext.d()), TuplesKt.to("sgrp_sub_channel_id", this.panelContext.a()), TuplesKt.to("sgrp_subchannel_type", Integer.valueOf(this.panelContext.b())));
        dp0.a aVar = this.panelDialog;
        if (aVar != null && (contentView = aVar.getContentView()) != null) {
            VideoReport.setPageId(contentView, "pg_sgrp_sub_channel_link");
            VideoReport.setPageParams(contentView, new PageParams(hashMapOf));
            VideoReport.reportEvent(event, contentView, hashMapOf);
        }
    }

    private final void q() {
        ChannelListRepository channelListRepository = this.channelListRepository;
        AppInterface qqAppInterface = this.panelContext.getQqAppInterface();
        String d16 = this.panelContext.d();
        Intrinsics.checkNotNullExpressionValue(d16, "panelContext.guildId");
        channelListRepository.d(qqAppInterface, d16, this.panelContext.b(), new c());
    }

    private final void r(HashTagPageType pageType) {
        String str;
        List<? extends cp0.a> listOf;
        if (b.f28746a[pageType.ordinal()] == 1) {
            str = "\u6682\u65e0\u7fa4\u804a";
        } else {
            str = "\u6682\u65e0\u7248\u5757/\u5b50\u9891\u9053";
        }
        dp0.a aVar = this.panelDialog;
        if (aVar != null) {
            listOf = CollectionsKt__CollectionsJVMKt.listOf(new HashTagEmptyPageData(16, str));
            aVar.X(pageType, listOf);
        }
    }

    private final void s() {
        this.troopListRepository.d(this.panelContext.getQqAppInterface(), new d());
    }

    @Override // com.tencent.guild.aio.input.at.quickAt.dialogui.framework.a.InterfaceC1190a
    public void H0(int flag) {
        dp0.a aVar = this.panelDialog;
        if (aVar != null) {
            aVar.V();
        }
        j.e(this.panelContext.getScene(), m());
    }

    @Override // ze1.a
    public boolean a() {
        dp0.a aVar = this.panelDialog;
        if (aVar != null) {
            return aVar.B();
        }
        return false;
    }

    @Override // com.tencent.guild.aio.input.at.quickAt.dialogui.framework.a.InterfaceC1190a
    public void c() {
        fp0.a notifier;
        j.c(this.panelContext.getScene(), m());
        dp0.a aVar = this.panelDialog;
        if (aVar != null && (notifier = aVar.getNotifier()) != null) {
            notifier.d();
        }
    }

    @Override // ip0.c
    public void destroy() {
        l(false);
        dp0.a aVar = this.panelDialog;
        if (aVar != null) {
            aVar.H();
        }
        this.mLateJoinListeners.clear();
        this.panelDialog = null;
    }

    @Override // ze1.a
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public void k(@Nullable ip0.d listener) {
        fp0.a notifier;
        if (listener != null) {
            dp0.a aVar = this.panelDialog;
            if (aVar != null && (notifier = aVar.getNotifier()) != null) {
                notifier.a(listener);
            }
            this.mLateJoinListeners.add(listener);
        }
    }

    @Override // ip0.c
    public void g(@Nullable View anchor, @NotNull HashTagPageType showListType) {
        Intrinsics.checkNotNullParameter(showListType, "showListType");
        i(anchor);
        dp0.a aVar = this.panelDialog;
        if (aVar != null) {
            aVar.W(showListType);
        }
    }

    @Override // ze1.a
    public void i(@Nullable View anchor) {
        this.mAnchor = anchor;
        o();
        dp0.a aVar = this.panelDialog;
        if (aVar != null) {
            aVar.Q(anchor);
        }
        if (this.panelContext.j().contains(HashTagPageType.Troop_Page)) {
            s();
        }
        if (this.panelContext.j().contains(HashTagPageType.Channel_Page)) {
            q();
        }
        p("pgin");
    }

    public void l(boolean anim) {
        if (a()) {
            dp0.a aVar = this.panelDialog;
            if (aVar != null) {
                aVar.n(anim);
            }
            p("pgout");
        }
    }

    public int m() {
        return 16;
    }

    @Override // com.tencent.guild.aio.input.at.quickAt.dialogui.framework.a.InterfaceC1190a
    public void b() {
    }
}
