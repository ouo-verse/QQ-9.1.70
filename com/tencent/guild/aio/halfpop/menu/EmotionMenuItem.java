package com.tencent.guild.aio.halfpop.menu;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.tencent.aio.data.AIOParam;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.common.app.AppInterface;
import com.tencent.guild.aio.halfpop.menu.EmotionMenuItem;
import com.tencent.guild.aio.msglist.holder.component.GuildEmojiSelectEvent;
import com.tencent.guild.aio.util.flowbus.FlowEventReceiver;
import com.tencent.guild.api.data.msglist.GuildMsgItem;
import com.tencent.guild.api.emoji.IGuildEmojiApi;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.api.IGuildInfoUtilsApi;
import com.tencent.mobileqq.guild.emoj.api.IQQGuildEmojiApi;
import com.tencent.mobileqq.guild.util.GuildUIUtils;
import com.tencent.mobileqq.guild.util.IQQGuildUtilApi;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildListSortInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.kernel.nativeinterface.EmojiUseInfo;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import wh2.eh;
import xn0.EmoCommentInfo;

/* compiled from: P */
@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 /2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u00010B\u0007\u00a2\u0006\u0004\b-\u0010.J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0005\u001a\u00020\u0003H\u0002J\u0018\u0010\n\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002J\u0010\u0010\r\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u000bH\u0002J\b\u0010\u000f\u001a\u00020\u000eH\u0002J\u0010\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u0010H\u0002J\u0010\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0002H\u0016J\u0010\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u0016H\u0016J \u0010 \u001a\u00020\u001f2\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001e\u001a\u00020\u001dH\u0016J\b\u0010!\u001a\u00020\u0003H\u0016R\u001c\u0010&\u001a\b\u0012\u0004\u0012\u00020#0\"8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u001a\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00060'8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b(\u0010%R\u0014\u0010,\u001a\u00020*8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b \u0010+\u00a8\u00061"}, d2 = {"Lcom/tencent/guild/aio/halfpop/menu/EmotionMenuItem;", "Lcom/tencent/guild/aio/halfpop/menu/b;", "Lcom/tencent/guild/api/data/msglist/GuildMsgItem;", "", "t", "w", "Lcom/tencent/qqnt/kernel/nativeinterface/EmojiUseInfo;", "info", "", "index", "r", "Lvn0/c;", "binding", "u", "Lcom/tencent/mobileqq/guild/emoj/b;", ReportConstant.COSTREPORT_PREFIX, "", "guildId", "", "v", "data", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Lcom/tencent/guild/aio/halfpop/b;", "menuCtrl", "c", "Landroid/view/LayoutInflater;", "inflater", "Landroid/content/Context;", "context", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/view/View;", "f", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "", "Landroid/widget/ImageView;", "d", "Ljava/util/List;", "emoIvList", "", "e", "emoDataList", "Lcom/tencent/guild/aio/util/flowbus/FlowEventReceiver;", "Lcom/tencent/guild/aio/util/flowbus/FlowEventReceiver;", "flowEventReceiver", "<init>", "()V", "g", "a", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class EmotionMenuItem extends com.tencent.guild.aio.halfpop.menu.b<GuildMsgItem> {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private List<? extends ImageView> emoIvList = new ArrayList();

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<EmojiUseInfo> emoDataList = new ArrayList();

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final FlowEventReceiver flowEventReceiver = new FlowEventReceiver(null, 1, null);

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\b\u001a\u00020\u00072\u0006\u0010\u0001\u001a\u00020\u00002\u000e\u0010\u0004\u001a\n \u0003*\u0004\u0018\u00010\u00020\u00022\u000e\u0010\u0006\u001a\n \u0003*\u0004\u0018\u00010\u00050\u0005H\n\u00a2\u0006\u0004\b\b\u0010\t"}, d2 = {"", "result", "", "kotlin.jvm.PlatformType", "errMsg", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProGuildListSortInfo;", "<anonymous parameter 2>", "", "a", "(ILjava/lang/String;Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProGuildListSortInfo;)V"}, k = 3, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    static final class b implements eh {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f110688a;

        /* JADX INFO: Access modifiers changed from: package-private */
        public b(String str) {
            this.f110688a = str;
        }

        @Override // wh2.eh
        public final void a(int i3, String str, IGProGuildListSortInfo iGProGuildListSortInfo) {
            Logger logger = Logger.f235387a;
            String str2 = this.f110688a;
            logger.d().i("EmotionMenuItem", 1, "setGuildListTop end. with guildId=" + str2 + " code=" + i3 + " errMsg=" + str);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000$\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\f\u001a\u00020\u000b2\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u00002\u000e\u0010\u0003\u001a\n \u0001*\u0004\u0018\u00010\u00000\u00002\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH\n\u00a2\u0006\u0004\b\f\u0010\r"}, d2 = {"", "kotlin.jvm.PlatformType", "<anonymous parameter 0>", "<anonymous parameter 1>", "", "<anonymous parameter 2>", "", "emojiId", "emojiType", "", "<anonymous parameter 5>", "", "a", "(Ljava/lang/String;Ljava/lang/String;JIIZ)V"}, k = 3, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    static final class c implements com.tencent.mobileqq.guild.emoj.f {
        /* JADX INFO: Access modifiers changed from: package-private */
        public c() {
        }

        @Override // com.tencent.mobileqq.guild.emoj.f
        public final void a(String str, String str2, long j3, int i3, int i16, boolean z16) {
            EmotionMenuItem.this.h().e().h(new GuildEmojiSelectEvent(((IGuildEmojiApi) QRoute.api(IGuildEmojiApi.class)).transEmoServerIdToEmoLocalId(i3, i16), i16, EmotionMenuItem.this.i().getMsgRecord()));
        }
    }

    private final void r(EmojiUseInfo info, int index) {
        Object orNull;
        Object orNull2;
        IGuildEmojiApi iGuildEmojiApi = (IGuildEmojiApi) QRoute.api(IGuildEmojiApi.class);
        String str = info.emojiId;
        Intrinsics.checkNotNullExpressionValue(str, "info.emojiId");
        Drawable emojiDrawable = iGuildEmojiApi.getEmojiDrawable(Integer.parseInt(str), info.emojiType, true);
        orNull = CollectionsKt___CollectionsKt.getOrNull(this.emoIvList, index);
        ImageView imageView = (ImageView) orNull;
        if (imageView != null) {
            imageView.setImageDrawable(emojiDrawable);
        }
        MsgRecord msgRecord = i().getMsgRecord();
        String str2 = info.emojiId;
        Intrinsics.checkNotNullExpressionValue(str2, "info.emojiId");
        EmoCommentInfo emoCommentInfo = new EmoCommentInfo(msgRecord, str2, info.emojiType);
        orNull2 = CollectionsKt___CollectionsKt.getOrNull(this.emoIvList, index);
        ImageView imageView2 = (ImageView) orNull2;
        if (imageView2 != null) {
            imageView2.setTag(emoCommentInfo);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final com.tencent.mobileqq.guild.emoj.b s() {
        com.tencent.mobileqq.guild.emoj.b bVar = new com.tencent.mobileqq.guild.emoj.b();
        bVar.f217867a = 2;
        bVar.f217870d = i().getMsgSeq();
        bVar.f217871e = i().getMsgRecord().peerUid;
        bVar.f217874h = ((IQQGuildUtilApi) QRoute.api(IQQGuildUtilApi.class)).appInterface();
        bVar.f217875i = h().c().getActivity();
        AIOParam g16 = h().g();
        Intrinsics.checkNotNullExpressionValue(g16, "aioContext.aioParam");
        bVar.f217873g = com.tencent.guild.aio.util.a.g(g16);
        AIOParam g17 = h().g();
        Intrinsics.checkNotNullExpressionValue(g17, "aioContext.aioParam");
        bVar.f217872f = com.tencent.guild.aio.util.a.b(g17);
        return bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void t() {
        try {
            List<EmojiUseInfo> recentEmojiData = ((IGuildEmojiApi) QRoute.api(IGuildEmojiApi.class)).getRecentEmojiData();
            QLog.i("EmotionMenuItem", 4, "getRecentEmojiData=" + recentEmojiData.size());
            this.emoDataList.clear();
            this.emoDataList.addAll(recentEmojiData);
            w();
        } catch (Exception e16) {
            QLog.e("EmotionMenuItem", 1, "error: " + e16);
        }
    }

    private final void u(vn0.c binding) {
        List<? extends ImageView> listOf;
        ImageView imageView = binding.f441920b;
        Intrinsics.checkNotNullExpressionValue(imageView, "binding.emoItemIv1");
        ImageView imageView2 = binding.f441921c;
        Intrinsics.checkNotNullExpressionValue(imageView2, "binding.emoItemIv2");
        ImageView imageView3 = binding.f441922d;
        Intrinsics.checkNotNullExpressionValue(imageView3, "binding.emoItemIv3");
        ImageView imageView4 = binding.f441923e;
        Intrinsics.checkNotNullExpressionValue(imageView4, "binding.emoItemIv4");
        ImageView imageView5 = binding.f441924f;
        Intrinsics.checkNotNullExpressionValue(imageView5, "binding.emoItemIv5");
        ImageView imageView6 = binding.f441925g;
        Intrinsics.checkNotNullExpressionValue(imageView6, "binding.emoItemIv6");
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new ImageView[]{imageView, imageView2, imageView3, imageView4, imageView5, imageView6});
        this.emoIvList = listOf;
        Iterator<T> it = listOf.iterator();
        while (true) {
            final long j3 = 200;
            if (it.hasNext()) {
                final ImageView imageView7 = (ImageView) it.next();
                imageView7.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.guild.aio.halfpop.menu.EmotionMenuItem$initEmojiView$lambda$5$$inlined$setSingleClickListener$1
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View it5) {
                        AppInterface appInterface;
                        EventCollector.getInstance().onViewClickedBefore(it5);
                        imageView7.setClickable(false);
                        Intrinsics.checkNotNullExpressionValue(it5, "it");
                        this.j().o8();
                        Object tag = it5.getTag();
                        Intrinsics.checkNotNull(tag, "null cannot be cast to non-null type com.tencent.guild.aio.emo.bean.EmoCommentInfo");
                        EmoCommentInfo emoCommentInfo = (EmoCommentInfo) tag;
                        ((IQQGuildEmojiApi) QRoute.api(IQQGuildEmojiApi.class)).updateRecentEmojiData(emoCommentInfo.getEmojiType(), Integer.parseInt(emoCommentInfo.getEmojiId()));
                        this.h().e().h(new GuildEmojiSelectEvent(Integer.parseInt(emoCommentInfo.getEmojiId()), emoCommentInfo.getEmojiType(), this.i().getMsgRecord()));
                        AIOParam g16 = this.h().g();
                        Intrinsics.checkNotNullExpressionValue(g16, "aioContext.aioParam");
                        String g17 = com.tencent.guild.aio.util.a.g(g16);
                        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
                        IRuntimeService iRuntimeService = null;
                        if (peekAppRuntime instanceof AppInterface) {
                            appInterface = (AppInterface) peekAppRuntime;
                        } else {
                            appInterface = null;
                        }
                        if (appInterface != null) {
                            iRuntimeService = appInterface.getRuntimeService(IGPSService.class, "");
                        }
                        IGPSService iGPSService = (IGPSService) iRuntimeService;
                        if (iGPSService != null) {
                            iGPSService.setGuildListTop(g17, 1, 2, new EmotionMenuItem.b(g17));
                        }
                        final View view = imageView7;
                        view.postDelayed(new Runnable() { // from class: com.tencent.guild.aio.halfpop.menu.EmotionMenuItem$initEmojiView$lambda$5$$inlined$setSingleClickListener$1.1
                            @Override // java.lang.Runnable
                            public final void run() {
                                view.setClickable(true);
                            }
                        }, j3);
                        EventCollector.getInstance().onViewClicked(it5);
                    }
                });
            } else {
                final ImageView imageView8 = binding.f441926h;
                Intrinsics.checkNotNullExpressionValue(imageView8, "binding.emoItemMore");
                imageView8.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.guild.aio.halfpop.menu.EmotionMenuItem$initEmojiView$$inlined$setSingleClickListener$1
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View it5) {
                        com.tencent.mobileqq.guild.emoj.b s16;
                        EventCollector.getInstance().onViewClickedBefore(it5);
                        imageView8.setClickable(false);
                        Intrinsics.checkNotNullExpressionValue(it5, "it");
                        QLog.i("EmotionMenuItem", 4, "more emoji click");
                        if (this.i().getMsgRecord().emojiLikesList.size() < 20) {
                            s16 = this.s();
                            ((IGuildEmojiApi) QRoute.api(IGuildEmojiApi.class)).showReactionEmoPanel(s16, com.tencent.mobileqq.utils.x.a(482.0f), new EmotionMenuItem.c());
                        } else {
                            QQToast.makeText(BaseApplication.getContext(), 1, R.string.f143480m7, 0).show();
                        }
                        this.j().o8();
                        final View view = imageView8;
                        view.postDelayed(new Runnable() { // from class: com.tencent.guild.aio.halfpop.menu.EmotionMenuItem$initEmojiView$$inlined$setSingleClickListener$1.1
                            @Override // java.lang.Runnable
                            public final void run() {
                                view.setClickable(true);
                            }
                        }, j3);
                        EventCollector.getInstance().onViewClicked(it5);
                    }
                });
                ImageView imageView9 = binding.f441926h;
                Context context = imageView9.getContext();
                Intrinsics.checkNotNullExpressionValue(context, "binding.emoItemMore.context");
                imageView9.setImageDrawable(GuildUIUtils.w(context, R.drawable.guild_aio_emoji_more, Integer.valueOf(k.f110719a.a())));
                return;
            }
        }
    }

    private final boolean v(String guildId) {
        IGuildInfoUtilsApi iGuildInfoUtilsApi = (IGuildInfoUtilsApi) QRoute.api(IGuildInfoUtilsApi.class);
        AIOParam g16 = h().g();
        Intrinsics.checkNotNullExpressionValue(g16, "aioContext.aioParam");
        return iGuildInfoUtilsApi.isSafetySwitchOpen(com.tencent.guild.aio.util.a.g(g16), 11);
    }

    private final void w() {
        List take;
        List<EmojiUseInfo> list = this.emoDataList;
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            String str = ((EmojiUseInfo) obj).emojiId;
            Intrinsics.checkNotNullExpressionValue(str, "it.emojiId");
            if (TextUtils.isDigitsOnly(str)) {
                arrayList.add(obj);
            }
        }
        take = CollectionsKt___CollectionsKt.take(arrayList, 6);
        int i3 = 0;
        for (Object obj2 : take) {
            int i16 = i3 + 1;
            if (i3 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            r((EmojiUseInfo) obj2, i3);
            i3 = i16;
        }
    }

    @Override // com.tencent.guild.aio.halfpop.menu.b, com.tencent.guild.aio.halfpop.menu.n
    public void c(@NotNull com.tencent.guild.aio.halfpop.b menuCtrl) {
        Intrinsics.checkNotNullParameter(menuCtrl, "menuCtrl");
        super.c(menuCtrl);
        t();
        this.flowEventReceiver.c(oi1.d.class, true, new EmotionMenuItem$onCreate$1(this, null));
        ((IQQGuildEmojiApi) QRoute.api(IQQGuildEmojiApi.class)).requestRecentUseEmo();
    }

    @Override // com.tencent.guild.aio.halfpop.menu.n
    @NotNull
    public View f(@NotNull LayoutInflater inflater, @NotNull Context context, @NotNull ViewGroup container) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(container, "container");
        vn0.c g16 = vn0.c.g(inflater, container, false);
        Intrinsics.checkNotNullExpressionValue(g16, "inflate(inflater, container, false)");
        u(g16);
        w();
        AIOParam g17 = h().g();
        Intrinsics.checkNotNullExpressionValue(g17, "aioContext.aioParam");
        if (!v(com.tencent.guild.aio.util.a.g(g17))) {
            g16.getRoot().setVisibility(8);
        }
        ConstraintLayout root = g16.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        return root;
    }

    @Override // com.tencent.guild.aio.halfpop.menu.b, com.tencent.guild.aio.halfpop.menu.n
    public void onDestroy() {
        super.onDestroy();
        this.flowEventReceiver.d();
    }

    @Override // com.tencent.guild.aio.halfpop.menu.b, com.tencent.guild.aio.halfpop.menu.n
    /* renamed from: q, reason: merged with bridge method [inline-methods] */
    public boolean a(@NotNull GuildMsgItem data) {
        Long l3;
        Intrinsics.checkNotNullParameter(data, "data");
        k kVar = k.f110719a;
        String n3 = h().g().n();
        AIOParam g16 = h().g();
        Intrinsics.checkNotNullExpressionValue(g16, "aioContext.aioParam");
        IGProChannelInfo c16 = com.tencent.guild.aio.util.a.c(g16);
        if (c16 != null) {
            l3 = Long.valueOf(c16.getApplicationId());
        } else {
            l3 = null;
        }
        return kVar.c(data, n3, l3);
    }
}
