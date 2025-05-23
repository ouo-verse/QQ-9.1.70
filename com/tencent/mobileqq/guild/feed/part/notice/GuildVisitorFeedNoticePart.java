package com.tencent.mobileqq.guild.feed.part.notice;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.biz.richframework.part.Part;
import com.tencent.biz.richframework.part.block.base.SafeLinearLayoutManager;
import com.tencent.biz.richframework.part.interfaces.IPartHost;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.base.extension.m;
import com.tencent.mobileqq.guild.feed.adapter.GuildVisitorFeedNoticeAdapter;
import com.tencent.mobileqq.guild.feed.event.GuildInboxEmptyPartEvent;
import com.tencent.mobileqq.guild.feed.gallery.widget.GuildFeedGalleryLoadingFooter;
import com.tencent.mobileqq.guild.feed.launcher.GuildFeedBaseInitBean;
import com.tencent.mobileqq.guild.feed.util.GuildFeedNoticeEvent;
import com.tencent.mobileqq.guild.feed.util.bn;
import com.tencent.mobileqq.guild.feed.viewmodel.notice.GuildVisitorNoticeViewModel;
import com.tencent.mobileqq.guild.inbox.centerpanel.notice.x;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.minigame.action.OperateCustomButton;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProTotalLike;
import com.tencent.richframework.data.base.UIStateData;
import com.tencent.richframework.widget.refresh.layout.SmartRefreshLayout;
import com.tencent.richframework.widget.refresh.layout.api.IRefreshLayout;
import com.tencent.richframework.widget.refresh.layout.listener.OnLoadMoreListener;
import com.tencent.richframework.widget.refresh.layout.listener.OnRefreshListener;
import ef1.c;
import ij1.v;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.time.Duration;
import kotlin.time.TimeSource;
import kotlin.time.TimedValue;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

@Metadata(d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 82\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u00019B\u0007\u00a2\u0006\u0004\b6\u00107J \u0010\t\u001a\u00020\b2\u0016\u0010\u0007\u001a\u0012\u0012\u000e\u0012\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u00050\u0004H\u0002J\b\u0010\u000b\u001a\u00020\nH\u0002J$\u0010\u0011\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000eH\u0002J\u0010\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u0012H\u0016J\u0006\u0010\u0015\u001a\u00020\bJ\u001a\u0010\u001a\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\u00162\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0016J\u0010\u0010\u001c\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\u0003H\u0016J$\u0010 \u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u001e0\u001dj\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u001e`\u001fH\u0016J\u0010\u0010!\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\u0016H\u0016R\u0016\u0010%\u001a\u00020\"8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010)\u001a\u00020&8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u0016\u0010-\u001a\u00020*8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b+\u0010,R\u0016\u00101\u001a\u00020.8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b/\u00100R\u0016\u00105\u001a\u0002028\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b3\u00104\u00a8\u0006:"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/part/notice/GuildVisitorFeedNoticePart;", "Lcom/tencent/biz/richframework/part/Part;", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "Lcom/tencent/richframework/data/base/UIStateData;", "", "Lij1/v;", "uiStateData", "", "F9", "Lcom/tencent/mobileqq/guild/feed/launcher/GuildFeedBaseInitBean;", "E9", "", "show", "", "errorMsg", "desc", "K9", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "initData", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onPartCreate", "event", "onReceiveEvent", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "Lkotlin/collections/ArrayList;", "getEventClass", "onPartDestroy", "Lcom/tencent/mobileqq/guild/feed/viewmodel/notice/GuildVisitorNoticeViewModel;", "d", "Lcom/tencent/mobileqq/guild/feed/viewmodel/notice/GuildVisitorNoticeViewModel;", "viewModel", "Lcom/tencent/mobileqq/guild/feed/adapter/GuildVisitorFeedNoticeAdapter;", "e", "Lcom/tencent/mobileqq/guild/feed/adapter/GuildVisitorFeedNoticeAdapter;", "feedNoticeAdapter", "Landroidx/recyclerview/widget/RecyclerView;", "f", "Landroidx/recyclerview/widget/RecyclerView;", "visitorFeedRecyclerView", "Lcom/tencent/richframework/widget/refresh/layout/SmartRefreshLayout;", h.F, "Lcom/tencent/richframework/widget/refresh/layout/SmartRefreshLayout;", "refreshLayout", "Lcom/tencent/mobileqq/guild/feed/gallery/widget/GuildFeedGalleryLoadingFooter;", "i", "Lcom/tencent/mobileqq/guild/feed/gallery/widget/GuildFeedGalleryLoadingFooter;", "refreshFooter", "<init>", "()V", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "a", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class GuildVisitorFeedNoticePart extends Part implements SimpleEventReceiver<SimpleBaseEvent> {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private GuildVisitorNoticeViewModel viewModel;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private GuildVisitorFeedNoticeAdapter feedNoticeAdapter;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private RecyclerView visitorFeedRecyclerView;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private SmartRefreshLayout refreshLayout;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private GuildFeedGalleryLoadingFooter refreshFooter;

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J'\u0010\u0006\u001a\u00028\u0000\"\b\b\u0000\u0010\u0003*\u00020\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0016\u00a2\u0006\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/guild/base/mvvm/SingleViewModelProvider$Companion$factory$1", "Landroidx/lifecycle/ViewModelProvider$Factory;", "Landroidx/lifecycle/ViewModel;", "T", "Ljava/lang/Class;", "p0", OperateCustomButton.OPERATE_CREATE, "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class b implements ViewModelProvider.Factory {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ViewModelStoreOwner f222593a;

        public b(ViewModelStoreOwner viewModelStoreOwner) {
            this.f222593a = viewModelStoreOwner;
        }

        @Override // androidx.lifecycle.ViewModelProvider.Factory
        @NotNull
        public <T extends ViewModel> T create(@NotNull Class<T> p06) {
            Intrinsics.checkNotNullParameter(p06, "p0");
            TimedValue timedValue = new TimedValue(new GuildVisitorNoticeViewModel(), TimeSource.Monotonic.ValueTimeMark.m1966elapsedNowUwyO8pc(TimeSource.Monotonic.INSTANCE.m1963markNowz9LOYto()), null);
            Logger logger = Logger.f235387a;
            if (QLog.isColorLevel()) {
                logger.d().d("GuildViewModelProvider", 2, "create " + m.a(timedValue.getValue()) + " cost " + Duration.m1875toStringimpl(timedValue.m1981getDurationUwyO8pc()));
            }
            return (T) timedValue.getValue();
        }
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0018\u0010\t\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0002H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/guild/feed/part/notice/GuildVisitorFeedNoticePart$c", "Lcom/tencent/mobileqq/guild/inbox/centerpanel/notice/x;", "", "c", "", "position", "", "a", "isReceive", "b", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class c implements x {
        c() {
        }

        private final boolean c() {
            if (!NetworkUtil.isNetworkAvailable()) {
                String string = GuildVisitorFeedNoticePart.this.getPartHost().getHostContext().getString(R.string.zxt);
                Intrinsics.checkNotNullExpressionValue(string, "partHost.hostContext.get\u2026feed_load_fail_net_error)");
                bn.k(string);
                return true;
            }
            return false;
        }

        @Override // com.tencent.mobileqq.guild.inbox.centerpanel.notice.x
        public void a(int position) {
            if (!c()) {
                GuildVisitorNoticeViewModel guildVisitorNoticeViewModel = GuildVisitorFeedNoticePart.this.viewModel;
                if (guildVisitorNoticeViewModel == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                    guildVisitorNoticeViewModel = null;
                }
                guildVisitorNoticeViewModel.S1(position);
            }
        }

        @Override // com.tencent.mobileqq.guild.inbox.centerpanel.notice.x
        public void b(int position, boolean isReceive) {
            if (!c()) {
                GuildVisitorNoticeViewModel guildVisitorNoticeViewModel = GuildVisitorFeedNoticePart.this.viewModel;
                if (guildVisitorNoticeViewModel == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                    guildVisitorNoticeViewModel = null;
                }
                guildVisitorNoticeViewModel.k2(position, isReceive);
            }
        }
    }

    private final GuildFeedBaseInitBean E9() {
        GuildFeedBaseInitBean guildFeedBaseInitBean = new GuildFeedBaseInitBean();
        HashMap<String, Serializable> attrs = guildFeedBaseInitBean.getAttrs();
        Intrinsics.checkNotNullExpressionValue(attrs, "bean.attrs");
        attrs.put("service_type", 0);
        guildFeedBaseInitBean.setBusinessType(25);
        guildFeedBaseInitBean.setIsVisitor(Boolean.TRUE);
        return guildFeedBaseInitBean;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void F9(UIStateData<List<v<?>>> uiStateData) {
        List list;
        List list2;
        List list3;
        int state = uiStateData.getState();
        SmartRefreshLayout smartRefreshLayout = null;
        GuildVisitorFeedNoticeAdapter guildVisitorFeedNoticeAdapter = null;
        GuildVisitorFeedNoticeAdapter guildVisitorFeedNoticeAdapter2 = null;
        SmartRefreshLayout smartRefreshLayout2 = null;
        if (state != 0) {
            if (state != 2 && state != 3) {
                if (state != 4) {
                    if (state != 6) {
                        if (state == 7) {
                            GuildVisitorFeedNoticeAdapter guildVisitorFeedNoticeAdapter3 = this.feedNoticeAdapter;
                            if (guildVisitorFeedNoticeAdapter3 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("feedNoticeAdapter");
                            } else {
                                guildVisitorFeedNoticeAdapter = guildVisitorFeedNoticeAdapter3;
                            }
                            List<v<?>> data = uiStateData.getData();
                            Intrinsics.checkNotNullExpressionValue(data, "uiStateData.data");
                            list3 = CollectionsKt___CollectionsKt.toList(data);
                            guildVisitorFeedNoticeAdapter.submitList(list3);
                            return;
                        }
                        return;
                    }
                    final int pos = uiStateData.getPos();
                    GuildVisitorFeedNoticeAdapter guildVisitorFeedNoticeAdapter4 = this.feedNoticeAdapter;
                    if (guildVisitorFeedNoticeAdapter4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("feedNoticeAdapter");
                    } else {
                        guildVisitorFeedNoticeAdapter2 = guildVisitorFeedNoticeAdapter4;
                    }
                    List<v<?>> data2 = uiStateData.getData();
                    Intrinsics.checkNotNullExpressionValue(data2, "uiStateData.data");
                    list2 = CollectionsKt___CollectionsKt.toList(data2);
                    guildVisitorFeedNoticeAdapter2.submitList(list2, new Runnable() { // from class: com.tencent.mobileqq.guild.feed.part.notice.e
                        @Override // java.lang.Runnable
                        public final void run() {
                            GuildVisitorFeedNoticePart.G9(GuildVisitorFeedNoticePart.this, pos);
                        }
                    });
                    return;
                }
                K9(true, uiStateData.getMsg(), null);
                return;
            }
            GuildVisitorFeedNoticeAdapter guildVisitorFeedNoticeAdapter5 = this.feedNoticeAdapter;
            if (guildVisitorFeedNoticeAdapter5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("feedNoticeAdapter");
                guildVisitorFeedNoticeAdapter5 = null;
            }
            List<v<?>> data3 = uiStateData.getData();
            Intrinsics.checkNotNullExpressionValue(data3, "uiStateData.data");
            list = CollectionsKt___CollectionsKt.toList(data3);
            guildVisitorFeedNoticeAdapter5.submitList(list);
            SmartRefreshLayout smartRefreshLayout3 = this.refreshLayout;
            if (smartRefreshLayout3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("refreshLayout");
                smartRefreshLayout3 = null;
            }
            smartRefreshLayout3.setEnableLoadMore(true ^ uiStateData.getIsFinish());
            if (uiStateData.getIsLoadMore()) {
                SmartRefreshLayout smartRefreshLayout4 = this.refreshLayout;
                if (smartRefreshLayout4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("refreshLayout");
                    smartRefreshLayout4 = null;
                }
                smartRefreshLayout4.finishLoadMore();
            } else {
                SmartRefreshLayout smartRefreshLayout5 = this.refreshLayout;
                if (smartRefreshLayout5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("refreshLayout");
                    smartRefreshLayout5 = null;
                }
                smartRefreshLayout5.finishRefresh();
            }
            K9(false, uiStateData.getMsg(), null);
            return;
        }
        GuildVisitorFeedNoticeAdapter guildVisitorFeedNoticeAdapter6 = this.feedNoticeAdapter;
        if (guildVisitorFeedNoticeAdapter6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("feedNoticeAdapter");
            guildVisitorFeedNoticeAdapter6 = null;
        }
        guildVisitorFeedNoticeAdapter6.submitList(uiStateData.getData());
        K9(true, "\u6682\u65e0\u6d88\u606f", "\u4ec5\u663e\u793a\u6765\u81ea\u672a\u52a0\u5165\u9891\u9053\u7684\u4e92\u52a8\u6d88\u606f");
        SmartRefreshLayout smartRefreshLayout6 = this.refreshLayout;
        if (smartRefreshLayout6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("refreshLayout");
            smartRefreshLayout6 = null;
        }
        smartRefreshLayout6.setEnableLoadMore(false);
        if (uiStateData.getIsLoadMore()) {
            SmartRefreshLayout smartRefreshLayout7 = this.refreshLayout;
            if (smartRefreshLayout7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("refreshLayout");
            } else {
                smartRefreshLayout2 = smartRefreshLayout7;
            }
            smartRefreshLayout2.finishLoadMore();
            return;
        }
        SmartRefreshLayout smartRefreshLayout8 = this.refreshLayout;
        if (smartRefreshLayout8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("refreshLayout");
        } else {
            smartRefreshLayout = smartRefreshLayout8;
        }
        smartRefreshLayout.finishRefresh();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void G9(GuildVisitorFeedNoticePart this$0, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        GuildVisitorFeedNoticeAdapter guildVisitorFeedNoticeAdapter = this$0.feedNoticeAdapter;
        GuildVisitorFeedNoticeAdapter guildVisitorFeedNoticeAdapter2 = null;
        if (guildVisitorFeedNoticeAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("feedNoticeAdapter");
            guildVisitorFeedNoticeAdapter = null;
        }
        GuildVisitorFeedNoticeAdapter guildVisitorFeedNoticeAdapter3 = this$0.feedNoticeAdapter;
        if (guildVisitorFeedNoticeAdapter3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("feedNoticeAdapter");
        } else {
            guildVisitorFeedNoticeAdapter2 = guildVisitorFeedNoticeAdapter3;
        }
        guildVisitorFeedNoticeAdapter.notifyItemRangeChanged(i3, guildVisitorFeedNoticeAdapter2.getNUM_BACKGOURND_ICON() - i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void H9(GuildVisitorFeedNoticePart this$0, IRefreshLayout it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(it, "it");
        GuildVisitorNoticeViewModel guildVisitorNoticeViewModel = this$0.viewModel;
        if (guildVisitorNoticeViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            guildVisitorNoticeViewModel = null;
        }
        guildVisitorNoticeViewModel.refresh();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void I9(GuildVisitorFeedNoticePart this$0, IRefreshLayout it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(it, "it");
        GuildVisitorNoticeViewModel guildVisitorNoticeViewModel = this$0.viewModel;
        if (guildVisitorNoticeViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            guildVisitorNoticeViewModel = null;
        }
        guildVisitorNoticeViewModel.loadMore();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void J9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void K9(boolean show, String errorMsg, String desc) {
        GuildInboxEmptyPartEvent guildInboxEmptyPartEvent = new GuildInboxEmptyPartEvent(show);
        if (errorMsg != null) {
            guildInboxEmptyPartEvent.setErrorMsg(errorMsg);
        }
        if (desc != null) {
            guildInboxEmptyPartEvent.setErrorDesc(desc);
        }
        SimpleEventBus.getInstance().dispatchEvent(guildInboxEmptyPartEvent);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    @NotNull
    public ArrayList<Class<SimpleBaseEvent>> getEventClass() {
        ArrayList<Class<SimpleBaseEvent>> arrayListOf;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(GuildFeedNoticeEvent.class);
        return arrayListOf;
    }

    public final void initData() {
        GuildVisitorNoticeViewModel guildVisitorNoticeViewModel;
        c.Companion companion = ef1.c.INSTANCE;
        IPartHost partHost = getPartHost();
        Intrinsics.checkNotNullExpressionValue(partHost, "partHost");
        ViewModel viewModel = new ViewModelProvider(partHost, new b(partHost)).get(GuildVisitorNoticeViewModel.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProvider(this, \u2026k(this) })[T::class.java]");
        this.viewModel = (GuildVisitorNoticeViewModel) viewModel;
        SmartRefreshLayout smartRefreshLayout = this.refreshLayout;
        GuildVisitorNoticeViewModel guildVisitorNoticeViewModel2 = null;
        if (smartRefreshLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("refreshLayout");
            smartRefreshLayout = null;
        }
        smartRefreshLayout.setEnableLoadMore(true).setEnableOverScrollDrag(true);
        SmartRefreshLayout smartRefreshLayout2 = this.refreshLayout;
        if (smartRefreshLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("refreshLayout");
            smartRefreshLayout2 = null;
        }
        smartRefreshLayout2.setOnRefreshListener(new OnRefreshListener() { // from class: com.tencent.mobileqq.guild.feed.part.notice.b
            @Override // com.tencent.richframework.widget.refresh.layout.listener.OnRefreshListener
            public final void onRefresh(IRefreshLayout iRefreshLayout) {
                GuildVisitorFeedNoticePart.H9(GuildVisitorFeedNoticePart.this, iRefreshLayout);
            }
        });
        SmartRefreshLayout smartRefreshLayout3 = this.refreshLayout;
        if (smartRefreshLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("refreshLayout");
            smartRefreshLayout3 = null;
        }
        smartRefreshLayout3.setOnLoadMoreListener(new OnLoadMoreListener() { // from class: com.tencent.mobileqq.guild.feed.part.notice.c
            @Override // com.tencent.richframework.widget.refresh.layout.listener.OnLoadMoreListener
            public final void onLoadMore(IRefreshLayout iRefreshLayout) {
                GuildVisitorFeedNoticePart.I9(GuildVisitorFeedNoticePart.this, iRefreshLayout);
            }
        });
        SmartRefreshLayout smartRefreshLayout4 = this.refreshLayout;
        if (smartRefreshLayout4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("refreshLayout");
            smartRefreshLayout4 = null;
        }
        smartRefreshLayout4.setEnableFooterFollowWhenNoMoreData(true);
        GuildVisitorNoticeViewModel guildVisitorNoticeViewModel3 = this.viewModel;
        if (guildVisitorNoticeViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            guildVisitorNoticeViewModel = null;
        } else {
            guildVisitorNoticeViewModel = guildVisitorNoticeViewModel3;
        }
        GuildVisitorNoticeViewModel.W1(guildVisitorNoticeViewModel, false, true, false, 4, null);
        Fragment hostFragment = getHostFragment();
        Intrinsics.checkNotNullExpressionValue(hostFragment, "hostFragment");
        GuildVisitorFeedNoticeAdapter guildVisitorFeedNoticeAdapter = new GuildVisitorFeedNoticeAdapter(hostFragment, E9());
        guildVisitorFeedNoticeAdapter.s0(new c());
        this.feedNoticeAdapter = guildVisitorFeedNoticeAdapter;
        RecyclerView recyclerView = this.visitorFeedRecyclerView;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("visitorFeedRecyclerView");
            recyclerView = null;
        }
        recyclerView.setLayoutManager(new SafeLinearLayoutManager(getContext(), 1, false));
        RecyclerView recyclerView2 = this.visitorFeedRecyclerView;
        if (recyclerView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("visitorFeedRecyclerView");
            recyclerView2 = null;
        }
        GuildVisitorFeedNoticeAdapter guildVisitorFeedNoticeAdapter2 = this.feedNoticeAdapter;
        if (guildVisitorFeedNoticeAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("feedNoticeAdapter");
            guildVisitorFeedNoticeAdapter2 = null;
        }
        recyclerView2.setAdapter(guildVisitorFeedNoticeAdapter2);
        RecyclerView recyclerView3 = this.visitorFeedRecyclerView;
        if (recyclerView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("visitorFeedRecyclerView");
            recyclerView3 = null;
        }
        recyclerView3.setHasFixedSize(false);
        RecyclerView recyclerView4 = this.visitorFeedRecyclerView;
        if (recyclerView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("visitorFeedRecyclerView");
            recyclerView4 = null;
        }
        DefaultItemAnimator defaultItemAnimator = new DefaultItemAnimator();
        defaultItemAnimator.setRemoveDuration(200L);
        defaultItemAnimator.setMoveDuration(200L);
        defaultItemAnimator.setChangeDuration(200L);
        defaultItemAnimator.setAddDuration(0L);
        recyclerView4.setItemAnimator(defaultItemAnimator);
        GuildVisitorNoticeViewModel guildVisitorNoticeViewModel4 = this.viewModel;
        if (guildVisitorNoticeViewModel4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        } else {
            guildVisitorNoticeViewModel2 = guildVisitorNoticeViewModel4;
        }
        MutableLiveData<UIStateData<List<v<?>>>> b26 = guildVisitorNoticeViewModel2.b2();
        LifecycleOwner lifecycleOwner = getPartHost().getLifecycleOwner();
        final GuildVisitorFeedNoticePart$initData$6 guildVisitorFeedNoticePart$initData$6 = new GuildVisitorFeedNoticePart$initData$6(this);
        b26.observe(lifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.guild.feed.part.notice.d
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GuildVisitorFeedNoticePart.J9(Function1.this, obj);
            }
        });
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@NotNull View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        View findViewById = rootView.findViewById(R.id.f1199978c);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.\u2026sitor_feed_recycler_view)");
        this.visitorFeedRecyclerView = (RecyclerView) findViewById;
        View findViewById2 = rootView.findViewById(R.id.f86434rn);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "rootView.findViewById(R.id.smart_refresh_layout)");
        this.refreshLayout = (SmartRefreshLayout) findViewById2;
        View findViewById3 = rootView.findViewById(R.id.f72283qf);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "rootView.findViewById(R.id.refresh_footer)");
        this.refreshFooter = (GuildFeedGalleryLoadingFooter) findViewById3;
        initData();
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartCreate(@NotNull Activity activity, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        super.onPartCreate(activity, savedInstanceState);
        SimpleEventBus.getInstance().registerReceiver(this);
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        super.onPartDestroy(activity);
        SimpleEventBus.getInstance().unRegisterReceiver(this);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(@NotNull SimpleBaseEvent event) {
        GuildVisitorNoticeViewModel guildVisitorNoticeViewModel;
        Intrinsics.checkNotNullParameter(event, "event");
        if ((event instanceof GuildFeedNoticeEvent) && (guildVisitorNoticeViewModel = this.viewModel) != null) {
            GuildVisitorFeedNoticeAdapter guildVisitorFeedNoticeAdapter = null;
            if (guildVisitorNoticeViewModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                guildVisitorNoticeViewModel = null;
            }
            if (guildVisitorNoticeViewModel.Z1().size() > 0) {
                ArrayList arrayList = new ArrayList();
                GuildVisitorNoticeViewModel guildVisitorNoticeViewModel2 = this.viewModel;
                if (guildVisitorNoticeViewModel2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                    guildVisitorNoticeViewModel2 = null;
                }
                arrayList.addAll(guildVisitorNoticeViewModel2.Z1());
                Iterator it = arrayList.iterator();
                boolean z16 = false;
                int i3 = 0;
                while (it.hasNext()) {
                    int i16 = i3 + 1;
                    v vVar = (v) it.next();
                    if (vVar instanceof ij1.a) {
                        ij1.a aVar = (ij1.a) vVar;
                        Uri parse = Uri.parse(aVar.b().pattonInfo.plainTxt.operation.schema);
                        String queryParameter = parse.getQueryParameter("comment_id");
                        String queryParameter2 = parse.getQueryParameter("reply_id");
                        GuildFeedNoticeEvent guildFeedNoticeEvent = (GuildFeedNoticeEvent) event;
                        if ((TextUtils.isEmpty(guildFeedNoticeEvent.getReplyId()) && Intrinsics.areEqual(queryParameter, guildFeedNoticeEvent.getCommentId()) && TextUtils.isEmpty(queryParameter2)) || (!TextUtils.isEmpty(guildFeedNoticeEvent.getReplyId()) && Intrinsics.areEqual(queryParameter, guildFeedNoticeEvent.getCommentId()) && Intrinsics.areEqual(guildFeedNoticeEvent.getReplyId(), queryParameter2))) {
                            GProTotalLike gProTotalLike = aVar.b().psvFeed.totalLike;
                            if (guildFeedNoticeEvent.getStatus() == 1) {
                                z16 = true;
                            }
                            gProTotalLike.isClicked = z16;
                            GuildVisitorFeedNoticeAdapter guildVisitorFeedNoticeAdapter2 = this.feedNoticeAdapter;
                            if (guildVisitorFeedNoticeAdapter2 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("feedNoticeAdapter");
                                guildVisitorFeedNoticeAdapter2 = null;
                            }
                            guildVisitorFeedNoticeAdapter2.submitList(arrayList);
                            GuildVisitorFeedNoticeAdapter guildVisitorFeedNoticeAdapter3 = this.feedNoticeAdapter;
                            if (guildVisitorFeedNoticeAdapter3 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("feedNoticeAdapter");
                            } else {
                                guildVisitorFeedNoticeAdapter = guildVisitorFeedNoticeAdapter3;
                            }
                            guildVisitorFeedNoticeAdapter.notifyItemChanged(i3);
                            return;
                        }
                    }
                    i3 = i16;
                }
            }
        }
    }
}
