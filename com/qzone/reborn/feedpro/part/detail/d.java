package com.qzone.reborn.feedpro.part.detail;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.qzone.business.tianshu.QZoneCommentQuickInputHelper;
import com.qzone.common.account.LoginData;
import com.qzone.reborn.feedpro.event.QzoneFeedProShowEmptyEvent;
import com.qzone.reborn.feedx.widget.QZoneUserAvatarView;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonFeed;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;

/* compiled from: P */
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\b\u0016\u0018\u0000 62\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u00017B\u0007\u00a2\u0006\u0004\b4\u00105J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0002J\b\u0010\u000b\u001a\u00020\nH\u0016J\u0010\u0010\u000e\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\fH\u0016J\u001c\u0010\u0013\u001a\u00020\u00042\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016J\u0012\u0010\u0015\u001a\u00020\u00042\b\u0010\u0014\u001a\u0004\u0018\u00010\u0003H\u0016J$\u0010\u0019\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00170\u0016j\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0017`\u0018H\u0016J\u0010\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000fH\u0016R\u0018\u0010\u001d\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0018\u0010!\u001a\u0004\u0018\u00010\u001e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u0018\u0010%\u001a\u0004\u0018\u00010\"8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b#\u0010$R\u0018\u0010)\u001a\u0004\u0018\u00010&8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u0018\u0010-\u001a\u0004\u0018\u00010*8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b+\u0010,R\u0018\u0010/\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b.\u0010\u001cR\u0016\u00103\u001a\u0004\u0018\u0001008BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b1\u00102\u00a8\u00068"}, d2 = {"Lcom/qzone/reborn/feedpro/part/detail/d;", "Lcom/qzone/reborn/base/k;", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "", "F9", "L9", "", "showQuickComment", "H9", "", "getLogTag", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onPartCreate", "event", "onReceiveEvent", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "Lkotlin/collections/ArrayList;", "getEventClass", "onPartDestroy", "d", "Landroid/view/View;", "mCommentButton", "Landroid/widget/ImageView;", "e", "Landroid/widget/ImageView;", "mIvCommentQuickInput", "Lde/a;", "f", "Lde/a;", "mCommentIoc", "Landroid/widget/TextView;", tl.h.F, "Landroid/widget/TextView;", "mTvCommentInput", "Lcom/qzone/reborn/feedx/widget/QZoneUserAvatarView;", "i", "Lcom/qzone/reborn/feedx/widget/QZoneUserAvatarView;", "mAvatarView", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "mCommentLayout", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonFeed;", "G9", "()Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonFeed;", "currentFeedData", "<init>", "()V", BdhLogUtil.LogTag.Tag_Conn, "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public class d extends com.qzone.reborn.base.k implements SimpleEventReceiver<SimpleBaseEvent> {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private View mCommentButton;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private ImageView mIvCommentQuickInput;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private de.a mCommentIoc;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private TextView mTvCommentInput;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private QZoneUserAvatarView mAvatarView;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private View mCommentLayout;

    private final void F9() {
        fo.c.b("dt_clck", this.mIvCommentQuickInput, "em_qz_feed_comment_box", null);
    }

    private final CommonFeed G9() {
        com.qzone.reborn.feedpro.viewmodel.i iVar = (com.qzone.reborn.feedpro.viewmodel.i) getViewModel(com.qzone.reborn.feedpro.viewmodel.i.class);
        if (iVar == null) {
            QLog.e("QZoneFeedProDetailQuickCommentPart", 2, "[getCurrentFeedData] detailViewModel is null");
            return null;
        }
        return iVar.d2();
    }

    private final void H9(int showQuickComment) {
        if (this.mCommentIoc == null) {
            this.mCommentIoc = (de.a) getIocInterface(de.a.class);
        }
        CommonFeed G9 = G9();
        if (G9 != null) {
            de.a aVar = this.mCommentIoc;
            if (aVar != null) {
                aVar.y6(G9, 0, 0, 0);
            }
            de.a aVar2 = this.mCommentIoc;
            if (aVar2 != null) {
                aVar2.T8(G9, null, -1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void I9(d this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.H9(2);
        this$0.F9();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void J9(d this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.H9(2);
        this$0.F9();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void K9(d this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.H9(1);
        this$0.F9();
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void L9() {
        TextView textView = this.mTvCommentInput;
        if (textView == null) {
            return;
        }
        textView.setText(com.qzone.util.l.a(R.string.f21933665));
    }

    @Override // com.tencent.biz.richframework.part.Part
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QZoneFeedProDetailQuickCommentPart";
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        View findViewById = rootView.findViewById(R.id.mz8);
        this.mCommentLayout = findViewById;
        if (findViewById != null) {
            findViewById.setVisibility(0);
        }
        QZoneUserAvatarView qZoneUserAvatarView = (QZoneUserAvatarView) rootView.findViewById(R.id.mz5);
        this.mAvatarView = qZoneUserAvatarView;
        if (qZoneUserAvatarView != null) {
            qZoneUserAvatarView.setUser(LoginData.getInstance().getUin());
        }
        QZoneUserAvatarView qZoneUserAvatarView2 = this.mAvatarView;
        if (qZoneUserAvatarView2 != null) {
            qZoneUserAvatarView2.setIsShieldJumpToMainPage(true);
        }
        QZoneUserAvatarView qZoneUserAvatarView3 = this.mAvatarView;
        if (qZoneUserAvatarView3 != null) {
            qZoneUserAvatarView3.setOnClickHookListener(new QZoneUserAvatarView.a() { // from class: com.qzone.reborn.feedpro.part.detail.a
                @Override // com.qzone.reborn.feedx.widget.QZoneUserAvatarView.a
                public final void a(View view) {
                    d.I9(d.this, view);
                }
            });
        }
        this.mCommentButton = rootView.findViewById(R.id.mz6);
        this.mIvCommentQuickInput = (ImageView) rootView.findViewById(R.id.mvw);
        this.mTvCommentInput = (TextView) rootView.findViewById(R.id.mz7);
        ImageView imageView = this.mIvCommentQuickInput;
        if (imageView != null) {
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.qzone.reborn.feedpro.part.detail.b
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    d.J9(d.this, view);
                }
            });
        }
        View view = this.mCommentButton;
        if (view != null) {
            view.setBackgroundResource(R.drawable.f14612m);
        }
        View view2 = this.mCommentButton;
        if (view2 != null) {
            view2.setOnClickListener(new View.OnClickListener() { // from class: com.qzone.reborn.feedpro.part.detail.c
                @Override // android.view.View.OnClickListener
                public final void onClick(View view3) {
                    d.K9(d.this, view3);
                }
            });
        }
        L9();
        AccessibilityUtil.s(this.mAvatarView, com.qzone.util.l.a(R.string.gqm));
        AccessibilityUtil.s(this.mCommentButton, com.qzone.util.l.a(R.string.f21933665));
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartCreate(Activity activity, Bundle savedInstanceState) {
        super.onPartCreate(activity, savedInstanceState);
        SimpleEventBus.getInstance().registerReceiver(this);
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        super.onPartDestroy(activity);
        QZoneCommentQuickInputHelper.n().r();
        SimpleEventBus.getInstance().unRegisterReceiver(this);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent event) {
        View view;
        if (!(event instanceof QzoneFeedProShowEmptyEvent) || (view = this.mCommentLayout) == null) {
            return;
        }
        view.setVisibility(8);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class<SimpleBaseEvent>> getEventClass() {
        ArrayList<Class<SimpleBaseEvent>> arrayListOf;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(QzoneFeedProShowEmptyEvent.class);
        return arrayListOf;
    }
}
