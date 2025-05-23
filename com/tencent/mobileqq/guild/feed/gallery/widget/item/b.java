package com.tencent.mobileqq.guild.feed.gallery.widget.item;

import android.content.Context;
import android.view.View;
import androidx.annotation.CallSuper;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.richframework.ioc.RFWIocAbilityProvider;
import com.tencent.biz.richframework.ioc.callback.IocPromise;
import com.tencent.biz.richframework.ioc.callback.OnPromiseResolved;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.guild.api.IGuildDTReportApi;
import com.tencent.mobileqq.guild.feed.bean.GuildFeedRichMediaData;
import com.tencent.mobileqq.guild.feed.gallery.part.g;
import com.tencent.mobileqq.guild.feed.gallery.part.t;
import com.tencent.mobileqq.guild.feed.gallery.widget.GuildFeedGalleryGestureView;
import com.tencent.mobileqq.guild.feed.launcher.GuildFeedGalleryInitBean;
import com.tencent.mobileqq.guild.util.o;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStFeed;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u001c\b&\u0018\u0000 :2\u00020\u0001:\u0001;B\u000f\u0012\u0006\u0010)\u001a\u00020 \u00a2\u0006\u0004\b8\u00109J*\u0010\n\u001a\u00020\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0017J\u0010\u0010\r\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000bJ\b\u0010\u000e\u001a\u00020\tH\u0016J\b\u0010\u000f\u001a\u00020\tH\u0016J\u0012\u0010\u0010\u001a\u00020\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0011\u001a\u00020\tH\u0016J\b\u0010\u0012\u001a\u00020\tH\u0016J\b\u0010\u0013\u001a\u00020\tH\u0016J\b\u0010\u0015\u001a\u00020\u0014H\u0016J$\u0010\u001a\u001a\b\u0012\u0004\u0012\u00028\u00000\u0019\"\u0004\b\u0000\u0010\u00162\u000e\u0010\u0018\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0017H\u0016J8\u0010\"\u001a\u00020\t2\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\u001e\u001a\u00020\u001d2\b\b\u0002\u0010\u001f\u001a\u00020\u001d2\n\b\u0002\u0010!\u001a\u0004\u0018\u00010 H\u0004J#\u0010#\u001a\u00020\t2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001d2\b\u0010\u001f\u001a\u0004\u0018\u00010\u001dH\u0004\u00a2\u0006\u0004\b#\u0010$R\u001a\u0010)\u001a\u00020 8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(R$\u00100\u001a\u0004\u0018\u00010\u000b8\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\"\u00107\u001a\u00020\u00068\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b1\u00102\u001a\u0004\b3\u00104\"\u0004\b5\u00106\u00a8\u0006<"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/gallery/widget/item/b;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStFeed;", "feed", "Lcom/tencent/mobileqq/guild/feed/bean/GuildFeedRichMediaData;", "data", "", "position", "verPos", "", "w", "Lcom/tencent/mobileqq/guild/feed/launcher/GuildFeedGalleryInitBean;", "initBean", HippyTKDListViewAdapter.X, "onResume", MiniSDKConst.NOTIFY_EVENT_ONPAUSE, "r", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "onViewAttachedToWindow", "onViewDetachedFromWindow", "", "p", "T", "Ljava/lang/Class;", "iocClass", "Lcom/tencent/biz/richframework/ioc/callback/IocPromise;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/content/Context;", "context", "", "positionX", "positionY", "Landroid/view/View;", "view", "u", ReportConstant.COSTREPORT_PREFIX, "(Ljava/lang/Float;Ljava/lang/Float;)V", "E", "Landroid/view/View;", "o", "()Landroid/view/View;", "rootItemView", UserInfo.SEX_FEMALE, "Lcom/tencent/mobileqq/guild/feed/launcher/GuildFeedGalleryInitBean;", "getMInitBean", "()Lcom/tencent/mobileqq/guild/feed/launcher/GuildFeedGalleryInitBean;", "setMInitBean", "(Lcom/tencent/mobileqq/guild/feed/launcher/GuildFeedGalleryInitBean;)V", "mInitBean", "G", "I", "getMCurVerPos", "()I", "setMCurVerPos", "(I)V", "mCurVerPos", "<init>", "(Landroid/view/View;)V", "H", "a", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public abstract class b extends RecyclerView.ViewHolder {

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final View rootItemView;

    /* renamed from: F, reason: from kotlin metadata */
    @Nullable
    private GuildFeedGalleryInitBean mInitBean;

    /* renamed from: G, reason: from kotlin metadata */
    private int mCurVerPos;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(@NotNull View rootItemView) {
        super(rootItemView);
        Intrinsics.checkNotNullParameter(rootItemView, "rootItemView");
        this.rootItemView = rootItemView;
        this.mCurVerPos = -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void t(b this$0, Float f16, Float f17, t tVar) {
        String str;
        Integer num;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        GuildFeedGalleryInitBean guildFeedGalleryInitBean = this$0.mInitBean;
        Integer num2 = null;
        if (guildFeedGalleryInitBean != null) {
            str = guildFeedGalleryInitBean.getFeedId();
        } else {
            str = null;
        }
        if (f16 != null) {
            num = Integer.valueOf((int) f16.floatValue());
        } else {
            num = null;
        }
        if (f17 != null) {
            num2 = Integer.valueOf((int) f17.floatValue());
        }
        tVar.r0(new g.Companion.ExecuteLikeParam(str, num, num2));
    }

    public static /* synthetic */ void v(b bVar, Context context, int i3, float f16, float f17, View view, int i16, Object obj) {
        float f18;
        float f19;
        if (obj == null) {
            if ((i16 & 4) != 0) {
                f18 = 0.0f;
            } else {
                f18 = f16;
            }
            if ((i16 & 8) != 0) {
                f19 = 0.0f;
            } else {
                f19 = f17;
            }
            if ((i16 & 16) != 0) {
                view = null;
            }
            bVar.u(context, i3, f18, f19, view);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onItemLongClicked");
    }

    @NotNull
    public <T> IocPromise<T> m(@Nullable Class<T> iocClass) {
        IocPromise<T> originView = RFWIocAbilityProvider.g().getIoc(iocClass).originView(getRootItemView());
        Intrinsics.checkNotNullExpressionValue(originView, "g().getIoc<T>(iocClass).originView(rootItemView)");
        return originView;
    }

    @NotNull
    /* renamed from: o, reason: from getter */
    public View getRootItemView() {
        return this.rootItemView;
    }

    public boolean p() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void s(@Nullable final Float positionX, @Nullable final Float positionY) {
        QLog.i("Guild_Feed_GAL_BaseFeedGalleryViewHolder", 1, "[onItemDoubleClicked] start");
        m(t.class).done(new OnPromiseResolved() { // from class: com.tencent.mobileqq.guild.feed.gallery.widget.item.a
            @Override // com.tencent.biz.richframework.ioc.callback.OnPromiseResolved
            public final void onDone(Object obj) {
                b.t(b.this, positionX, positionY, (t) obj);
            }
        }).run();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void u(@NotNull Context context, int position, float positionX, float positionY, @Nullable View view) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (o.d("gallery_long_click", 1000L)) {
            return;
        }
        boolean z16 = false;
        if (view != null && GuildFeedGalleryGestureView.INSTANCE.a(view, positionX, positionY)) {
            z16 = true;
        }
        if (z16) {
            QLog.i("Guild_Feed_GAL_BaseFeedGalleryViewHolder", 1, "[onItemLongClicked] inPlayRateArea ");
            return;
        }
        QLog.i("Guild_Feed_GAL_BaseFeedGalleryViewHolder", 1, "[onItemLongClicked] position: " + position + ", initBean: " + this.mInitBean);
        mk1.e.f416895a.k(this.mInitBean, position, context, this.mCurVerPos);
        ((IGuildDTReportApi) QRoute.api(IGuildDTReportApi.class)).reportDtEventManual(getRootItemView(), "em_sgrp_hold_share", "clck", null);
    }

    @CallSuper
    public void w(@Nullable GProStFeed feed, @NotNull GuildFeedRichMediaData data, int position, int verPos) {
        Intrinsics.checkNotNullParameter(data, "data");
        this.mCurVerPos = verPos;
    }

    public final void x(@Nullable GuildFeedGalleryInitBean initBean) {
        this.mInitBean = initBean;
    }

    public void onPause() {
    }

    public void onResume() {
    }

    public void onViewAttachedToWindow() {
    }

    public void onViewDetachedFromWindow() {
    }

    public void q() {
    }

    public void r(@Nullable GProStFeed feed) {
    }
}
