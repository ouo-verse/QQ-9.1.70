package com.tencent.mobileqq.guild.feed.feedsquare.part;

import android.app.Activity;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.viewpager2.widget.ViewPager2;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.pubaccount.weishi.event.WSComboHomePageChangeEvent;
import com.tencent.biz.qui.quipagetabbar.QUIPageTabBar;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.ioc.RFWIocAbilityProvider;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.guild.event.GuildFeedManagePermissionChangeEvent;
import com.tencent.mobileqq.guild.event.GuildFeedsHomeJumpFeedChannelEvent;
import com.tencent.mobileqq.guild.event.GuildHomeFragmentOnRefreshEvent;
import com.tencent.mobileqq.guild.event.GuildUserCreateFeedChannelEvent;
import com.tencent.mobileqq.guild.feed.event.FeedEditorEvent;
import com.tencent.mobileqq.guild.feed.event.GuildBeKickedEvent;
import com.tencent.mobileqq.guild.feed.event.GuildChannelListUpdatedEvent;
import com.tencent.mobileqq.guild.feed.event.GuildDeleteEvent;
import com.tencent.mobileqq.guild.feed.event.GuildFeedListFirstLoadingEvent;
import com.tencent.mobileqq.guild.feed.event.GuildFeedSquareRefreshEvent;
import com.tencent.mobileqq.guild.feed.feedsquare.data.SectionInfo;
import com.tencent.mobileqq.guild.feed.feedsquare.widget.GuildFeedSquareTabBarCompatRightBtn;
import com.tencent.mobileqq.guild.feed.launcher.GuildFeedBaseInitBean;
import com.tencent.mobileqq.guild.feed.launcher.GuildFeedLauncher;
import com.tencent.mobileqq.guild.feed.square.GuildFeedSquareInitBean;
import com.tencent.mobileqq.guild.feed.util.ax;
import com.tencent.mobileqq.guild.feed.util.bn;
import com.tencent.mobileqq.guild.jump.model.JumpGuildParam;
import com.tencent.mobileqq.guild.util.TraceUtils;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qcircle.weseevideo.model.utils.LocaleUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u00b3\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\b\t*\u0001d\u0018\u0000 j2\u00020\u0001:\u0001kB\u0007\u00a2\u0006\u0004\bh\u0010iJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0002H\u0002J\b\u0010\b\u001a\u00020\u0002H\u0002J\b\u0010\n\u001a\u00020\tH\u0002J\u001e\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0002J\u001e\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u00112\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0002J\u0010\u0010\u0015\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u000eH\u0002J\b\u0010\u0016\u001a\u00020\u0002H\u0002J\u0016\u0010\u0018\u001a\u00020\t2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0017H\u0002J\u0010\u0010\u001a\u001a\u00020\t2\u0006\u0010\u0019\u001a\u00020\u000bH\u0002J\b\u0010\u001b\u001a\u00020\u0002H\u0002J\u0010\u0010\u001c\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u000eH\u0002J\b\u0010\u001d\u001a\u00020\u0002H\u0002J\b\u0010\u001e\u001a\u00020\u0002H\u0002J\u0016\u0010 \u001a\u00020\u00022\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0002J\u0016\u0010!\u001a\u00020\u00022\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0002J\b\u0010\"\u001a\u00020\u0002H\u0002J\u0014\u0010&\u001a\u00020\u00022\n\u0010%\u001a\u00060#j\u0002`$H\u0002J\b\u0010'\u001a\u00020\u0002H\u0002J\u0010\u0010)\u001a\u00020\u00022\u0006\u0010%\u001a\u00020(H\u0002J\u0010\u0010*\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0012\u0010-\u001a\u00020\u00022\b\u0010,\u001a\u0004\u0018\u00010+H\u0016J\u001c\u00100\u001a\u00020\u00022\b\u0010,\u001a\u0004\u0018\u00010+2\b\u0010/\u001a\u0004\u0018\u00010.H\u0016J\u0012\u00101\u001a\u00020\u00022\b\u0010,\u001a\u0004\u0018\u00010+H\u0016J\u0010\u00103\u001a\u00020\u00022\u0006\u0010%\u001a\u000202H\u0016J$\u00108\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u0002060504j\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020605`7H\u0016R\u001c\u0010;\u001a\b\u0012\u0004\u0012\u00020\u000e0\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b9\u0010:R\u0018\u0010?\u001a\u0004\u0018\u00010<8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b=\u0010>R\u0018\u0010B\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b@\u0010AR\u0016\u0010E\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bC\u0010DR\u0016\u0010I\u001a\u00020F8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bG\u0010HR\u0016\u0010L\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bJ\u0010KR\u0018\u0010P\u001a\u0004\u0018\u00010M8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bN\u0010OR\u0018\u0010T\u001a\u0004\u0018\u00010Q8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bR\u0010SR\u0016\u0010X\u001a\u00020U8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bV\u0010WR\u0016\u0010\\\u001a\u00020Y8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bZ\u0010[R\u0016\u0010_\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b]\u0010^R\u0016\u0010a\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b`\u0010^R\u0016\u0010b\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bD\u0010^R\u0016\u0010c\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bH\u0010DR\u0014\u0010g\u001a\u00020d8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\be\u0010f\u00a8\u0006l"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/feedsquare/part/GuildFeedSquareContentPart;", "Lcom/tencent/mobileqq/guild/feed/part/d;", "", "ia", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, LocaleUtils.L_JAPANESE, "pa", "initViewModel", "", "oa", "", "targetTabType", "", "Lcom/tencent/mobileqq/guild/feed/feedsquare/data/l;", "list", "aa", "", "targetChannelId", "Z9", "selectedSectionInfo", "ba", "initPageBean", "", "qa", "position", "ca", "na", "ra", "ua", "ha", "channelList", "ta", "sa", "ga", "Lcom/tencent/mobileqq/guild/feed/event/FeedEditorEvent$OnStartPublishFeedEvent;", "Lcom/tencent/mobileqq/guild/feed/event/GuildOnStartPublishFeedEvent;", "event", "ea", "va", "Lcom/tencent/mobileqq/guild/feed/event/GuildChannelListUpdatedEvent;", "da", "onInitView", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "onPartResume", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onPartCreate", "onPartDestroy", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "onReceiveEvent", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "", "Lkotlin/collections/ArrayList;", "getEventClass", "d", "Ljava/util/List;", "sectionList", "Lcom/tencent/mobileqq/guild/feed/feedsquare/viewmodel/e;", "e", "Lcom/tencent/mobileqq/guild/feed/feedsquare/viewmodel/e;", "viewModel", "f", "Lcom/tencent/mobileqq/guild/feed/feedsquare/data/l;", "curSectionInfo", tl.h.F, "I", "curPos", "", "i", "J", "categoryId", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/lang/String;", "needJumpSectionId", "Lcom/tencent/mobileqq/guild/feed/square/GuildFeedSquareInitBean;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/guild/feed/square/GuildFeedSquareInitBean;", "initBean", "Lcom/tencent/mobileqq/guild/feed/feedsquare/adapter/l;", "D", "Lcom/tencent/mobileqq/guild/feed/feedsquare/adapter/l;", "contentAdapter", "Lcom/tencent/mobileqq/guild/feed/feedsquare/widget/GuildFeedSquareTabBarCompatRightBtn;", "E", "Lcom/tencent/mobileqq/guild/feed/feedsquare/widget/GuildFeedSquareTabBarCompatRightBtn;", "feedCategoryTabBar", "Landroidx/viewpager2/widget/ViewPager2;", UserInfo.SEX_FEMALE, "Landroidx/viewpager2/widget/ViewPager2;", "viewPager", "G", "Z", "firstIn", "H", "needBindViewPager", "isHomePage", "traceCookie", "com/tencent/mobileqq/guild/feed/feedsquare/part/GuildFeedSquareContentPart$b", "K", "Lcom/tencent/mobileqq/guild/feed/feedsquare/part/GuildFeedSquareContentPart$b;", "feedSquareSectionInfoIoc", "<init>", "()V", "L", "a", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class GuildFeedSquareContentPart extends com.tencent.mobileqq.guild.feed.part.d {

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private GuildFeedSquareInitBean initBean;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private com.tencent.mobileqq.guild.feed.feedsquare.adapter.l contentAdapter;

    /* renamed from: E, reason: from kotlin metadata */
    private GuildFeedSquareTabBarCompatRightBtn feedCategoryTabBar;

    /* renamed from: F, reason: from kotlin metadata */
    private ViewPager2 viewPager;

    /* renamed from: G, reason: from kotlin metadata */
    private boolean firstIn;

    /* renamed from: H, reason: from kotlin metadata */
    private boolean needBindViewPager;

    /* renamed from: I, reason: from kotlin metadata */
    private boolean isHomePage;

    /* renamed from: J, reason: from kotlin metadata */
    private int traceCookie;

    /* renamed from: K, reason: from kotlin metadata */
    @NotNull
    private final b feedSquareSectionInfoIoc;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private List<com.tencent.mobileqq.guild.feed.feedsquare.data.l> sectionList;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private com.tencent.mobileqq.guild.feed.feedsquare.viewmodel.e viewModel;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private com.tencent.mobileqq.guild.feed.feedsquare.data.l curSectionInfo;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private int curPos;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private long categoryId;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String needJumpSectionId;

    @Metadata(d1 = {"\u0000\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007*\u0001\u0000\b\n\u0018\u00002\u00020\u0001R\u001c\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0016\u0010\t\u001a\u0004\u0018\u00010\u00038VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0007\u0010\b\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/guild/feed/feedsquare/part/GuildFeedSquareContentPart$b", "Lxj1/e;", "", "Lcom/tencent/mobileqq/guild/feed/feedsquare/data/l;", "b", "()Ljava/util/List;", "sectionInfoList", "a", "()Lcom/tencent/mobileqq/guild/feed/feedsquare/data/l;", "currentSectionInfo", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class b implements xj1.e {
        b() {
        }

        @Override // xj1.e
        @Nullable
        public com.tencent.mobileqq.guild.feed.feedsquare.data.l a() {
            return GuildFeedSquareContentPart.this.curSectionInfo;
        }

        @Override // xj1.e
        @Nullable
        public List<com.tencent.mobileqq.guild.feed.feedsquare.data.l> b() {
            MutableLiveData<List<com.tencent.mobileqq.guild.feed.feedsquare.data.l>> O1;
            com.tencent.mobileqq.guild.feed.feedsquare.viewmodel.e eVar = GuildFeedSquareContentPart.this.viewModel;
            if (eVar != null && (O1 = eVar.O1()) != null) {
                return O1.getValue();
            }
            return null;
        }
    }

    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0016J\u0010\u0010\t\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u000b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0002H\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/mobileqq/guild/feed/feedsquare/part/GuildFeedSquareContentPart$c", "Landroidx/viewpager2/widget/ViewPager2$OnPageChangeCallback;", "", "position", "", "positionOffset", "positionOffsetPixels", "", WSComboHomePageChangeEvent.EVENT_ON_PAGE_SCROLLED, "onPageSelected", "state", "onPageScrollStateChanged", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class c extends ViewPager2.OnPageChangeCallback {
        c() {
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageScrollStateChanged(int state) {
            if (state == 1) {
                GuildFeedSquareContentPart.this.traceCookie = TraceUtils.g("feed_page_switch");
            } else if (state == 0 && GuildFeedSquareContentPart.this.traceCookie != -1) {
                TraceUtils.j("feed_page_switch", GuildFeedSquareContentPart.this.traceCookie);
                GuildFeedSquareContentPart.this.traceCookie = -1;
            }
            super.onPageScrollStateChanged(state);
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            super.onPageScrolled(position, positionOffset, positionOffsetPixels);
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageSelected(int position) {
            List<com.tencent.mobileqq.guild.feed.feedsquare.data.l> list;
            super.onPageSelected(position);
            boolean z16 = true;
            QLog.d("GuildFeedSquareContentPart", 1, "onPageSelected: " + position);
            com.tencent.mobileqq.guild.feed.feedsquare.adapter.l lVar = GuildFeedSquareContentPart.this.contentAdapter;
            if (lVar != null) {
                list = lVar.getItems();
            } else {
                list = null;
            }
            List<com.tencent.mobileqq.guild.feed.feedsquare.data.l> list2 = list;
            if (list2 != null && !list2.isEmpty()) {
                z16 = false;
            }
            if (!z16 && position <= list.size()) {
                GuildFeedSquareContentPart.this.curSectionInfo = list.get(position);
                GuildFeedSquareContentPart.this.curPos = position;
                GuildFeedSquareContentPart.this.ra(list.get(position));
                GuildFeedSquareContentPart.this.ua();
            }
        }
    }

    public GuildFeedSquareContentPart() {
        List<com.tencent.mobileqq.guild.feed.feedsquare.data.l> emptyList;
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        this.sectionList = emptyList;
        this.needJumpSectionId = "";
        this.firstIn = true;
        this.needBindViewPager = true;
        this.traceCookie = -1;
        this.feedSquareSectionInfoIoc = new b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int Z9(String targetChannelId, List<com.tencent.mobileqq.guild.feed.feedsquare.data.l> list) {
        int i3 = 0;
        for (Object obj : list) {
            int i16 = i3 + 1;
            if (i3 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            String ba5 = ba((com.tencent.mobileqq.guild.feed.feedsquare.data.l) obj);
            if (!TextUtils.isEmpty(ba5) && !TextUtils.isEmpty(targetChannelId) && Intrinsics.areEqual(ba5, targetChannelId)) {
                return i3;
            }
            i3 = i16;
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int aa(int targetTabType, List<com.tencent.mobileqq.guild.feed.feedsquare.data.l> list) {
        int i3 = 0;
        for (Object obj : list) {
            int i16 = i3 + 1;
            if (i3 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            if (((com.tencent.mobileqq.guild.feed.feedsquare.data.l) obj).getSectionInfo().getType() == targetTabType) {
                return i3;
            }
            i3 = i16;
        }
        return -1;
    }

    private final String ba(com.tencent.mobileqq.guild.feed.feedsquare.data.l selectedSectionInfo) {
        if (selectedSectionInfo.getSectionInfo().getType() == 4) {
            return "";
        }
        return selectedSectionInfo.getSectionInfo().getChannelId();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean ca(int position) {
        QLog.i(getTAG(), 1, "gotoTargetTab position:" + position);
        if (position == -1) {
            return false;
        }
        ViewPager2 viewPager2 = this.viewPager;
        if (viewPager2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewPager");
            viewPager2 = null;
        }
        viewPager2.setCurrentItem(position, false);
        return true;
    }

    private final void da(GuildChannelListUpdatedEvent event) {
        com.tencent.mobileqq.guild.feed.feedsquare.viewmodel.e eVar;
        GuildFeedSquareInitBean guildFeedSquareInitBean = this.initBean;
        if (guildFeedSquareInitBean != null && Intrinsics.areEqual(guildFeedSquareInitBean.getGuildId(), event.getGuildId()) && (eVar = this.viewModel) != null) {
            eVar.a2();
        }
    }

    private final void ea(FeedEditorEvent.OnStartPublishFeedEvent event) {
        boolean z16;
        String str;
        if (!event.isEdition()) {
            if (event.getContact().getGuildId().length() > 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                String guildId = event.getContact().getGuildId();
                GuildFeedSquareInitBean guildFeedSquareInitBean = this.initBean;
                if (guildFeedSquareInitBean != null) {
                    str = guildFeedSquareInitBean.getGuildId();
                } else {
                    str = null;
                }
                if (Intrinsics.areEqual(guildId, str)) {
                    ca(aa(4, this.sectionList));
                }
            }
        }
    }

    private final void ga() {
        if (!this.sectionList.isEmpty() && this.curPos <= this.sectionList.size() - 1) {
            SectionInfo sectionInfo = this.sectionList.get(this.curPos).getSectionInfo();
            SimpleEventBus.getInstance().dispatchEvent(new GuildFeedSquareRefreshEvent(sectionInfo.getGuildId(), sectionInfo.getChannelId(), sectionInfo.getType(), false, 8, null));
            return;
        }
        QLog.e("GuildFeedSquareContentPart", 1, "handleOnRefresh error, curPos[" + this.curPos + "], listSize[" + this.sectionList.size() + "]");
    }

    private final void ha() {
        Fragment hostFragment = getHostFragment();
        Intrinsics.checkNotNullExpressionValue(hostFragment, "hostFragment");
        this.contentAdapter = new com.tencent.mobileqq.guild.feed.feedsquare.adapter.l(hostFragment);
    }

    private final void ia() {
        Bundle arguments = getHostFragment().getArguments();
        if (arguments == null) {
            return;
        }
        boolean z16 = false;
        if (arguments.getInt("key_page_type", 0) == 4) {
            z16 = true;
        }
        this.isHomePage = z16;
    }

    private final void initPageBean() {
        GuildFeedBaseInitBean o16 = ax.o(getHostFragment());
        if (o16 instanceof GuildFeedSquareInitBean) {
            this.initBean = (GuildFeedSquareInitBean) o16;
        }
        QLog.d(getTAG(), 1, "getInitBeanSuccess:" + this.initBean);
    }

    private final void initViewModel() {
        MutableLiveData<List<com.tencent.mobileqq.guild.feed.feedsquare.data.l>> O1;
        com.tencent.mobileqq.guild.feed.feedsquare.viewmodel.e eVar = (com.tencent.mobileqq.guild.feed.feedsquare.viewmodel.e) getViewModel(com.tencent.mobileqq.guild.feed.feedsquare.viewmodel.e.class);
        this.viewModel = eVar;
        if (eVar != null) {
            eVar.X1(this.initBean, oa());
        }
        com.tencent.mobileqq.guild.feed.feedsquare.viewmodel.e eVar2 = this.viewModel;
        if (eVar2 != null && (O1 = eVar2.O1()) != null) {
            Fragment hostFragment = getHostFragment();
            final Function1<List<? extends com.tencent.mobileqq.guild.feed.feedsquare.data.l>, Unit> function1 = new Function1<List<? extends com.tencent.mobileqq.guild.feed.feedsquare.data.l>, Unit>() { // from class: com.tencent.mobileqq.guild.feed.feedsquare.part.GuildFeedSquareContentPart$initViewModel$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(List<? extends com.tencent.mobileqq.guild.feed.feedsquare.data.l> list) {
                    invoke2((List<com.tencent.mobileqq.guild.feed.feedsquare.data.l>) list);
                    return Unit.INSTANCE;
                }

                /* JADX WARN: Removed duplicated region for block: B:19:0x009a  */
                /* JADX WARN: Removed duplicated region for block: B:22:0x00f3  */
                /* JADX WARN: Removed duplicated region for block: B:33:0x013f  */
                /* JADX WARN: Removed duplicated region for block: B:46:0x009f  */
                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public final void invoke2(List<com.tencent.mobileqq.guild.feed.feedsquare.data.l> it) {
                    int i3;
                    boolean z16;
                    List list;
                    List list2;
                    boolean z17;
                    GuildFeedSquareInitBean guildFeedSquareInitBean;
                    String str;
                    boolean z18;
                    String str2;
                    String str3;
                    List list3;
                    int Z9;
                    int i16;
                    List list4;
                    int aa5;
                    GuildFeedSquareInitBean guildFeedSquareInitBean2;
                    List list5;
                    int aa6;
                    GuildFeedSquareInitBean guildFeedSquareInitBean3;
                    List list6;
                    int Z92;
                    Bundle arguments;
                    List list7;
                    List list8;
                    GuildFeedSquareContentPart guildFeedSquareContentPart = GuildFeedSquareContentPart.this;
                    Intrinsics.checkNotNullExpressionValue(it, "it");
                    guildFeedSquareContentPart.sectionList = it;
                    GuildFeedSquareContentPart guildFeedSquareContentPart2 = GuildFeedSquareContentPart.this;
                    com.tencent.mobileqq.guild.feed.feedsquare.viewmodel.e eVar3 = guildFeedSquareContentPart2.viewModel;
                    guildFeedSquareContentPart2.categoryId = eVar3 != null ? eVar3.getCategoryId() : 0L;
                    com.tencent.mobileqq.guild.feed.feedsquare.data.l lVar = GuildFeedSquareContentPart.this.curSectionInfo;
                    if (lVar != null) {
                        GuildFeedSquareContentPart guildFeedSquareContentPart3 = GuildFeedSquareContentPart.this;
                        int type = lVar.getSectionInfo().getType();
                        if (type != 4 && type != 5) {
                            String channelId = lVar.getSectionInfo().getChannelId();
                            list8 = guildFeedSquareContentPart3.sectionList;
                            i3 = guildFeedSquareContentPart3.Z9(channelId, list8);
                        } else {
                            int type2 = lVar.getSectionInfo().getType();
                            list7 = guildFeedSquareContentPart3.sectionList;
                            i3 = guildFeedSquareContentPart3.aa(type2, list7);
                        }
                        if (i3 == -1) {
                            guildFeedSquareContentPart3.va();
                            z16 = true;
                            GuildFeedSquareContentPart guildFeedSquareContentPart4 = GuildFeedSquareContentPart.this;
                            list = guildFeedSquareContentPart4.sectionList;
                            guildFeedSquareContentPart4.sa(list);
                            GuildFeedSquareContentPart guildFeedSquareContentPart5 = GuildFeedSquareContentPart.this;
                            list2 = guildFeedSquareContentPart5.sectionList;
                            guildFeedSquareContentPart5.ta(list2);
                            Fragment hostFragment2 = GuildFeedSquareContentPart.this.getHostFragment();
                            boolean z19 = (hostFragment2 != null || (arguments = hostFragment2.getArguments()) == null) ? false : arguments.getBoolean(JumpGuildParam.EXTRA_FEED_HOME_SELECTED_HOT_TAB);
                            z17 = GuildFeedSquareContentPart.this.firstIn;
                            guildFeedSquareInitBean = GuildFeedSquareContentPart.this.initBean;
                            String channelId2 = guildFeedSquareInitBean == null ? guildFeedSquareInitBean.getChannelId() : null;
                            str = GuildFeedSquareContentPart.this.needJumpSectionId;
                            QLog.i("GuildFeedSquareContentPart", 1, "initViewModel firstIn=" + z17 + " channelId=" + channelId2 + " needJumpToHot=" + z16 + " needJumpPos=" + i3 + " needJumpSectionId=" + str + " defaultSelectHot=" + z19);
                            z18 = GuildFeedSquareContentPart.this.firstIn;
                            if (!z18) {
                                guildFeedSquareInitBean2 = GuildFeedSquareContentPart.this.initBean;
                                if (!TextUtils.isEmpty(guildFeedSquareInitBean2 != null ? guildFeedSquareInitBean2.getChannelId() : null)) {
                                    GuildFeedSquareContentPart guildFeedSquareContentPart6 = GuildFeedSquareContentPart.this;
                                    guildFeedSquareInitBean3 = guildFeedSquareContentPart6.initBean;
                                    Intrinsics.checkNotNull(guildFeedSquareInitBean3);
                                    String channelId3 = guildFeedSquareInitBean3.getChannelId();
                                    Intrinsics.checkNotNullExpressionValue(channelId3, "initBean!!.channelId");
                                    list6 = GuildFeedSquareContentPart.this.sectionList;
                                    Z92 = guildFeedSquareContentPart6.Z9(channelId3, list6);
                                    GuildFeedSquareContentPart.this.ca(Z92);
                                } else if (z19) {
                                    GuildFeedSquareContentPart guildFeedSquareContentPart7 = GuildFeedSquareContentPart.this;
                                    list5 = guildFeedSquareContentPart7.sectionList;
                                    aa6 = guildFeedSquareContentPart7.aa(5, list5);
                                    GuildFeedSquareContentPart.this.ca(aa6);
                                }
                                GuildFeedSquareContentPart.this.firstIn = false;
                                return;
                            }
                            if (!z16) {
                                if (i3 != -1) {
                                    i16 = GuildFeedSquareContentPart.this.curPos;
                                    if (i16 != i3) {
                                        GuildFeedSquareContentPart.this.ca(i3);
                                        return;
                                    }
                                }
                                str2 = GuildFeedSquareContentPart.this.needJumpSectionId;
                                if (TextUtils.isEmpty(str2)) {
                                    return;
                                }
                                GuildFeedSquareContentPart guildFeedSquareContentPart8 = GuildFeedSquareContentPart.this;
                                str3 = guildFeedSquareContentPart8.needJumpSectionId;
                                list3 = GuildFeedSquareContentPart.this.sectionList;
                                Z9 = guildFeedSquareContentPart8.Z9(str3, list3);
                                GuildFeedSquareContentPart.this.ca(Z9);
                                GuildFeedSquareContentPart.this.needJumpSectionId = "";
                                return;
                            }
                            GuildFeedSquareContentPart guildFeedSquareContentPart9 = GuildFeedSquareContentPart.this;
                            list4 = guildFeedSquareContentPart9.sectionList;
                            aa5 = guildFeedSquareContentPart9.aa(5, list4);
                            GuildFeedSquareContentPart.this.ca(aa5);
                            return;
                        }
                    } else {
                        i3 = -1;
                    }
                    z16 = false;
                    GuildFeedSquareContentPart guildFeedSquareContentPart42 = GuildFeedSquareContentPart.this;
                    list = guildFeedSquareContentPart42.sectionList;
                    guildFeedSquareContentPart42.sa(list);
                    GuildFeedSquareContentPart guildFeedSquareContentPart52 = GuildFeedSquareContentPart.this;
                    list2 = guildFeedSquareContentPart52.sectionList;
                    guildFeedSquareContentPart52.ta(list2);
                    Fragment hostFragment22 = GuildFeedSquareContentPart.this.getHostFragment();
                    if (hostFragment22 != null) {
                    }
                    z17 = GuildFeedSquareContentPart.this.firstIn;
                    guildFeedSquareInitBean = GuildFeedSquareContentPart.this.initBean;
                    if (guildFeedSquareInitBean == null) {
                    }
                    str = GuildFeedSquareContentPart.this.needJumpSectionId;
                    QLog.i("GuildFeedSquareContentPart", 1, "initViewModel firstIn=" + z17 + " channelId=" + channelId2 + " needJumpToHot=" + z16 + " needJumpPos=" + i3 + " needJumpSectionId=" + str + " defaultSelectHot=" + z19);
                    z18 = GuildFeedSquareContentPart.this.firstIn;
                    if (!z18) {
                    }
                }
            };
            O1.observe(hostFragment, new Observer() { // from class: com.tencent.mobileqq.guild.feed.feedsquare.part.b
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    GuildFeedSquareContentPart.ma(Function1.this, obj);
                }
            });
        }
    }

    private final void ja(View rootView) {
        String str;
        boolean z16;
        View findViewById = rootView.findViewById(R.id.wcm);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.\u2026d_page_tab_bar_container)");
        GuildFeedSquareTabBarCompatRightBtn guildFeedSquareTabBarCompatRightBtn = (GuildFeedSquareTabBarCompatRightBtn) findViewById;
        this.feedCategoryTabBar = guildFeedSquareTabBarCompatRightBtn;
        GuildFeedSquareTabBarCompatRightBtn guildFeedSquareTabBarCompatRightBtn2 = null;
        if (guildFeedSquareTabBarCompatRightBtn == null) {
            Intrinsics.throwUninitializedPropertyAccessException("feedCategoryTabBar");
            guildFeedSquareTabBarCompatRightBtn = null;
        }
        GuildFeedSquareInitBean guildFeedSquareInitBean = this.initBean;
        if (guildFeedSquareInitBean != null) {
            str = guildFeedSquareInitBean.getGuildId();
        } else {
            str = null;
        }
        Bundle arguments = getHostFragment().getArguments();
        if (arguments != null) {
            z16 = arguments.getBoolean(JumpGuildParam.EXTRA_SETTING_ENTRANCE_VISIBLE);
        } else {
            z16 = false;
        }
        guildFeedSquareTabBarCompatRightBtn.e(str, z16);
        GuildFeedSquareTabBarCompatRightBtn guildFeedSquareTabBarCompatRightBtn3 = this.feedCategoryTabBar;
        if (guildFeedSquareTabBarCompatRightBtn3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("feedCategoryTabBar");
            guildFeedSquareTabBarCompatRightBtn3 = null;
        }
        guildFeedSquareTabBarCompatRightBtn3.setOnCurrentTabClickListener(new QUIPageTabBar.h() { // from class: com.tencent.mobileqq.guild.feed.feedsquare.part.a
            @Override // com.tencent.biz.qui.quipagetabbar.QUIPageTabBar.h
            public final void k1(int i3) {
                GuildFeedSquareContentPart.la(GuildFeedSquareContentPart.this, i3);
            }
        });
        GuildFeedSquareTabBarCompatRightBtn guildFeedSquareTabBarCompatRightBtn4 = this.feedCategoryTabBar;
        if (guildFeedSquareTabBarCompatRightBtn4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("feedCategoryTabBar");
        } else {
            guildFeedSquareTabBarCompatRightBtn2 = guildFeedSquareTabBarCompatRightBtn4;
        }
        guildFeedSquareTabBarCompatRightBtn2.setVisibility(4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void la(GuildFeedSquareContentPart this$0, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (i3 >= this$0.sectionList.size()) {
            QLog.e("GuildFeedSquareContentPart", 1, "tabBar onClick error, clickPos[" + i3 + "], listSize[" + this$0.sectionList.size() + "]");
            return;
        }
        SectionInfo sectionInfo = this$0.sectionList.get(i3).getSectionInfo();
        int type = this$0.sectionList.get(i3).getSectionInfo().getType();
        if (type != 1) {
            if (type == 4 || type == 5) {
                SimpleEventBus.getInstance().dispatchEvent(new GuildFeedSquareRefreshEvent(sectionInfo.getGuildId(), sectionInfo.getChannelId(), sectionInfo.getType(), true));
                return;
            }
            return;
        }
        if (this$0.isHomePage) {
            SimpleEventBus.getInstance().dispatchEvent(new GuildFeedSquareRefreshEvent(sectionInfo.getGuildId(), sectionInfo.getChannelId(), sectionInfo.getType(), true));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ma(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void na() {
        ha();
        ViewPager2 viewPager2 = this.viewPager;
        ViewPager2 viewPager22 = null;
        if (viewPager2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewPager");
            viewPager2 = null;
        }
        viewPager2.setAdapter(this.contentAdapter);
        ViewPager2 viewPager23 = this.viewPager;
        if (viewPager23 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewPager");
        } else {
            viewPager22 = viewPager23;
        }
        viewPager22.registerOnPageChangeCallback(new c());
    }

    private final boolean oa() {
        Object obj;
        Bundle arguments;
        Fragment hostFragment = getHostFragment();
        if (hostFragment == null || (arguments = hostFragment.getArguments()) == null || (obj = arguments.get(JumpGuildParam.EXTRA_FEED_HOME_CATEGORY_LOCATE_TYPE)) == null) {
            obj = 0;
        }
        return Intrinsics.areEqual(obj, (Object) 1);
    }

    private final void pa() {
        Serializable serializable;
        List emptyList;
        boolean z16;
        HashMap<String, Serializable> attrs;
        GuildFeedSquareInitBean guildFeedSquareInitBean = this.initBean;
        if (guildFeedSquareInitBean != null && (attrs = guildFeedSquareInitBean.getAttrs()) != null) {
            serializable = attrs.get(AppConstants.Key.GUILD_EXTAR_DETAIL_CONTENT_JUMP_ID);
        } else {
            serializable = null;
        }
        if (serializable instanceof String) {
            CharSequence charSequence = (CharSequence) serializable;
            if (!TextUtils.isEmpty(charSequence)) {
                List<String> split = new Regex(",").split(charSequence, 0);
                if (!split.isEmpty()) {
                    ListIterator<String> listIterator = split.listIterator(split.size());
                    while (listIterator.hasPrevious()) {
                        if (listIterator.previous().length() == 0) {
                            z16 = true;
                        } else {
                            z16 = false;
                        }
                        if (!z16) {
                            emptyList = CollectionsKt___CollectionsKt.take(split, listIterator.nextIndex() + 1);
                            break;
                        }
                    }
                }
                emptyList = CollectionsKt__CollectionsKt.emptyList();
                Object[] array = emptyList.toArray(new String[0]);
                Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                String[] strArr = (String[]) array;
                if (strArr.length > 3) {
                    String str = strArr[3];
                    if (!TextUtils.isEmpty(str)) {
                        GuildFeedLauncher.t(str);
                    }
                }
            }
        }
    }

    private final boolean qa(List<com.tencent.mobileqq.guild.feed.feedsquare.data.l> list) {
        boolean z16;
        boolean z17;
        String str;
        List<com.tencent.mobileqq.guild.feed.feedsquare.data.l> list2 = list;
        if (!(list2 instanceof Collection) || !list2.isEmpty()) {
            Iterator<T> it = list2.iterator();
            while (it.hasNext()) {
                z16 = true;
                if (((com.tencent.mobileqq.guild.feed.feedsquare.data.l) it.next()).getSectionInfo().getType() == 1) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                if (z17) {
                    break;
                }
            }
        }
        z16 = false;
        if (z16) {
            return false;
        }
        GuildFeedSquareInitBean guildFeedSquareInitBean = this.initBean;
        if (guildFeedSquareInitBean != null) {
            str = guildFeedSquareInitBean.getGuildId();
        } else {
            str = null;
        }
        return ch.m0(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void sa(List<com.tencent.mobileqq.guild.feed.feedsquare.data.l> channelList) {
        com.tencent.mobileqq.guild.feed.feedsquare.adapter.l lVar;
        if ((!channelList.isEmpty()) && (lVar = this.contentAdapter) != null) {
            Intrinsics.checkNotNull(lVar);
            lVar.setItems(channelList);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void ta(List<com.tencent.mobileqq.guild.feed.feedsquare.data.l> channelList) {
        String str;
        List<com.tencent.mobileqq.guild.feed.feedsquare.data.l> list;
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(channelList);
        if (qa(arrayList)) {
            String string = getContext().getString(R.string.f145660s3);
            Intrinsics.checkNotNullExpressionValue(string, "context.getString(com.te\u2026ild_feed_tab_create_feed)");
            arrayList.add(new com.tencent.mobileqq.guild.feed.feedsquare.data.l(new SectionInfo("", "", string, 3)));
        }
        if (!arrayList.isEmpty()) {
            GuildFeedSquareTabBarCompatRightBtn guildFeedSquareTabBarCompatRightBtn = this.feedCategoryTabBar;
            ViewPager2 viewPager2 = null;
            if (guildFeedSquareTabBarCompatRightBtn == null) {
                Intrinsics.throwUninitializedPropertyAccessException("feedCategoryTabBar");
                guildFeedSquareTabBarCompatRightBtn = null;
            }
            GuildFeedSquareInitBean guildFeedSquareInitBean = this.initBean;
            if (guildFeedSquareInitBean != null) {
                str = guildFeedSquareInitBean.getGuildId();
            } else {
                str = null;
            }
            Fragment hostFragment = getHostFragment();
            Intrinsics.checkNotNullExpressionValue(hostFragment, "hostFragment");
            guildFeedSquareTabBarCompatRightBtn.setParam(str, hostFragment, this.categoryId);
            GuildFeedSquareTabBarCompatRightBtn guildFeedSquareTabBarCompatRightBtn2 = this.feedCategoryTabBar;
            if (guildFeedSquareTabBarCompatRightBtn2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("feedCategoryTabBar");
                guildFeedSquareTabBarCompatRightBtn2 = null;
            }
            list = CollectionsKt___CollectionsKt.toList(arrayList);
            guildFeedSquareTabBarCompatRightBtn2.setData(list);
            if (this.needBindViewPager) {
                GuildFeedSquareTabBarCompatRightBtn guildFeedSquareTabBarCompatRightBtn3 = this.feedCategoryTabBar;
                if (guildFeedSquareTabBarCompatRightBtn3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("feedCategoryTabBar");
                    guildFeedSquareTabBarCompatRightBtn3 = null;
                }
                ViewPager2 viewPager22 = this.viewPager;
                if (viewPager22 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("viewPager");
                } else {
                    viewPager2 = viewPager22;
                }
                guildFeedSquareTabBarCompatRightBtn3.b(viewPager2);
                this.needBindViewPager = false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void ua() {
        if (!NetworkUtil.isNetworkAvailable()) {
            bn.f223895a.b(R.string.f144630pa, new Function0<Unit>() { // from class: com.tencent.mobileqq.guild.feed.feedsquare.part.GuildFeedSquareContentPart$showNetErrorTipIfNeed$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    QQToast.makeText(GuildFeedSquareContentPart.this.getContext(), 1, GuildFeedSquareContentPart.this.getContext().getString(R.string.f144630pa), 0).show();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void va() {
        DialogUtil.createCustomDialog(getContext(), 230, (String) null, HardCodeUtil.qqStr(R.string.f145610ry), (String) null, getContext().getString(R.string.f146610un), new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.guild.feed.feedsquare.part.c
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                GuildFeedSquareContentPart.wa(dialogInterface, i3);
            }
        }, (DialogInterface.OnClickListener) null).show();
    }

    @Override // com.tencent.mobileqq.guild.feed.part.d, com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    @NotNull
    public ArrayList<Class<Object>> getEventClass() {
        ArrayList<Class<Object>> eventClass = super.getEventClass();
        if (eventClass == null) {
            eventClass = new ArrayList<>();
        }
        eventClass.add(GuildDeleteEvent.class);
        eventClass.add(GuildBeKickedEvent.class);
        eventClass.add(FeedEditorEvent.OnStartPublishFeedEvent.class);
        eventClass.add(GuildChannelListUpdatedEvent.class);
        eventClass.add(GuildHomeFragmentOnRefreshEvent.class);
        eventClass.add(GuildFeedsHomeJumpFeedChannelEvent.class);
        eventClass.add(GuildUserCreateFeedChannelEvent.class);
        eventClass.add(GuildFeedManagePermissionChangeEvent.class);
        eventClass.add(GuildFeedListFirstLoadingEvent.class);
        return eventClass;
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@NotNull View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        View findViewById = rootView.findViewById(R.id.wfm);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.id.guild_feed_view_pager)");
        this.viewPager = (ViewPager2) findViewById;
        ia();
        ja(rootView);
        na();
        initViewModel();
        pa();
        RFWIocAbilityProvider.g().registerIoc(rootView, this.feedSquareSectionInfoIoc, xj1.e.class);
    }

    @Override // com.tencent.mobileqq.guild.feed.part.d, com.tencent.biz.richframework.part.Part
    public void onPartCreate(@Nullable Activity activity, @Nullable Bundle savedInstanceState) {
        super.onPartCreate(activity, savedInstanceState);
        initPageBean();
    }

    @Override // com.tencent.mobileqq.guild.feed.part.d, com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(@Nullable Activity activity) {
        super.onPartDestroy(activity);
        RFWIocAbilityProvider.g().unregisterSingleIoc(getPartRootView(), xj1.e.class);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartResume(@Nullable Activity activity) {
        super.onPartResume(activity);
        com.tencent.mobileqq.guild.feed.feedsquare.viewmodel.e eVar = this.viewModel;
        if (eVar != null) {
            eVar.U1();
        }
    }

    @Override // com.tencent.mobileqq.guild.feed.part.d, com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(@NotNull SimpleBaseEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        GuildFeedSquareTabBarCompatRightBtn guildFeedSquareTabBarCompatRightBtn = null;
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        if (event instanceof FeedEditorEvent.OnStartPublishFeedEvent) {
            FeedEditorEvent.OnStartPublishFeedEvent onStartPublishFeedEvent = (FeedEditorEvent.OnStartPublishFeedEvent) event;
            String guildId = onStartPublishFeedEvent.getContact().getGuildId();
            GuildFeedSquareInitBean guildFeedSquareInitBean = this.initBean;
            if (guildFeedSquareInitBean != null) {
                str = guildFeedSquareInitBean.getGuildId();
            }
            if (!Intrinsics.areEqual(guildId, str)) {
                return;
            }
            ea(onStartPublishFeedEvent);
            return;
        }
        if (event instanceof GuildChannelListUpdatedEvent) {
            da((GuildChannelListUpdatedEvent) event);
            return;
        }
        if (event instanceof GuildHomeFragmentOnRefreshEvent) {
            if (this.isHomePage) {
                String guildId2 = ((GuildHomeFragmentOnRefreshEvent) event).getGuildId();
                GuildFeedSquareInitBean guildFeedSquareInitBean2 = this.initBean;
                if (guildFeedSquareInitBean2 != null) {
                    str2 = guildFeedSquareInitBean2.getGuildId();
                }
                if (Intrinsics.areEqual(guildId2, str2)) {
                    ga();
                    return;
                }
                return;
            }
            return;
        }
        if (event instanceof GuildFeedsHomeJumpFeedChannelEvent) {
            GuildFeedsHomeJumpFeedChannelEvent guildFeedsHomeJumpFeedChannelEvent = (GuildFeedsHomeJumpFeedChannelEvent) event;
            String guildId3 = guildFeedsHomeJumpFeedChannelEvent.getGuildId();
            GuildFeedSquareInitBean guildFeedSquareInitBean3 = this.initBean;
            if (guildFeedSquareInitBean3 != null) {
                str3 = guildFeedSquareInitBean3.getGuildId();
            }
            if (Intrinsics.areEqual(guildId3, str3) && !ca(Z9(guildFeedsHomeJumpFeedChannelEvent.getChannelId(), this.sectionList))) {
                this.needJumpSectionId = guildFeedsHomeJumpFeedChannelEvent.getChannelId();
                QLog.i("GuildFeedSquareContentPart", 1, "set needJumpSectionId:" + guildFeedsHomeJumpFeedChannelEvent.getChannelId() + ", from " + event.getClass().getSimpleName());
                return;
            }
            return;
        }
        if (event instanceof GuildUserCreateFeedChannelEvent) {
            GuildUserCreateFeedChannelEvent guildUserCreateFeedChannelEvent = (GuildUserCreateFeedChannelEvent) event;
            String guildId4 = guildUserCreateFeedChannelEvent.getGuildId();
            GuildFeedSquareInitBean guildFeedSquareInitBean4 = this.initBean;
            if (guildFeedSquareInitBean4 != null) {
                str4 = guildFeedSquareInitBean4.getGuildId();
            }
            if (Intrinsics.areEqual(guildId4, str4)) {
                this.needJumpSectionId = guildUserCreateFeedChannelEvent.getChannelId();
                QLog.i("GuildFeedSquareContentPart", 1, "set needJumpSectionId:" + guildUserCreateFeedChannelEvent.getChannelId() + ", from " + event.getClass().getSimpleName());
                return;
            }
            return;
        }
        if (event instanceof GuildFeedManagePermissionChangeEvent) {
            GuildFeedSquareTabBarCompatRightBtn guildFeedSquareTabBarCompatRightBtn2 = this.feedCategoryTabBar;
            if (guildFeedSquareTabBarCompatRightBtn2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("feedCategoryTabBar");
                guildFeedSquareTabBarCompatRightBtn2 = null;
            }
            GuildFeedSquareInitBean guildFeedSquareInitBean5 = this.initBean;
            if (guildFeedSquareInitBean5 != null) {
                str5 = guildFeedSquareInitBean5.getGuildId();
            }
            guildFeedSquareTabBarCompatRightBtn2.e(str5, ((GuildFeedManagePermissionChangeEvent) event).getHasPermission());
            return;
        }
        if (event instanceof GuildFeedListFirstLoadingEvent) {
            GuildFeedSquareTabBarCompatRightBtn guildFeedSquareTabBarCompatRightBtn3 = this.feedCategoryTabBar;
            if (guildFeedSquareTabBarCompatRightBtn3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("feedCategoryTabBar");
            } else {
                guildFeedSquareTabBarCompatRightBtn = guildFeedSquareTabBarCompatRightBtn3;
            }
            guildFeedSquareTabBarCompatRightBtn.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void ra(com.tencent.mobileqq.guild.feed.feedsquare.data.l selectedSectionInfo) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void wa(DialogInterface dialogInterface, int i3) {
    }
}
