package com.qzone.reborn.groupalbum.part;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.lifecycle.ViewModel;
import com.qzone.common.account.LoginData;
import com.qzone.reborn.groupalbum.event.GroupAlbumBannerEvent;
import com.qzone.reborn.groupalbum.viewmodel.aj;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;

/* compiled from: P */
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u00022\u00020\u0004B\u0007\u00a2\u0006\u0004\b>\u0010?J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\b\u0010\t\u001a\u00020\u0007H\u0002J\u0010\u0010\n\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0010\u0010\u000b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0010\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\b\u0010\u000f\u001a\u00020\u0007H\u0002J\b\u0010\u0011\u001a\u00020\u0010H\u0002J\b\u0010\u0012\u001a\u00020\u0010H\u0002J\b\u0010\u0013\u001a\u00020\u0007H\u0002J\u0010\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u0014H\u0016J\u000e\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005J\u0012\u0010\u0019\u001a\u00020\u00072\b\u0010\u0018\u001a\u0004\u0018\u00010\u0014H\u0016J\u001c\u0010\u001e\u001a\u00020\u00072\b\u0010\u001b\u001a\u0004\u0018\u00010\u001a2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cH\u0016J\u0012\u0010\u001f\u001a\u00020\u00072\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aH\u0016J\u0014\u0010\"\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030!0 H\u0016J\u0012\u0010$\u001a\u00020\u00072\b\u0010#\u001a\u0004\u0018\u00010\u0003H\u0016R\u0014\u0010'\u001a\u00020\u00108\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u0014\u0010)\u001a\u00020\u00108\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b(\u0010&R\u0014\u0010+\u001a\u00020\u00108\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b*\u0010&R\u0016\u0010/\u001a\u00020,8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b-\u0010.R\u0016\u00103\u001a\u0002008\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b1\u00102R\u0016\u00107\u001a\u0002048\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b5\u00106R\u0016\u0010;\u001a\u0002088\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b9\u0010:R\u0016\u0010=\u001a\u0002048\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b<\u00106\u00a8\u0006@"}, d2 = {"Lcom/qzone/reborn/groupalbum/part/a;", "Lcom/qzone/reborn/base/k;", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "Landroid/view/View$OnClickListener;", "Lcom/qzone/reborn/groupalbum/event/GroupAlbumBannerEvent;", "data", "", "J9", "G9", "F9", "M9", "", "C9", "K9", "L9", "", "D9", "E9", "H9", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "I9", "v", NodeProps.ON_CLICK, "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onPartCreate", "onPartDestroy", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "getEventClass", "event", "onReceiveEvent", "d", "Ljava/lang/String;", "TAG", "e", "GROUP_ALBUM_BANNER_INTERVAL_TIME_KEY_PREFIX", "f", "GROUP_ALBUM_BANNER_SHOW_TIME_KEY_PREFIX", "Lcom/qzone/reborn/groupalbum/viewmodel/aj;", tl.h.F, "Lcom/qzone/reborn/groupalbum/viewmodel/aj;", "mTabViewModel", "Landroid/widget/RelativeLayout;", "i", "Landroid/widget/RelativeLayout;", "mBannerLayout", "Landroid/widget/ImageView;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/widget/ImageView;", "mBannerLeftIcon", "Landroid/widget/TextView;", BdhLogUtil.LogTag.Tag_Conn, "Landroid/widget/TextView;", "mBannerText", "D", "mBannerRightIcon", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class a extends com.qzone.reborn.base.k implements SimpleEventReceiver<SimpleBaseEvent>, View.OnClickListener {

    /* renamed from: C, reason: from kotlin metadata */
    private TextView mBannerText;

    /* renamed from: D, reason: from kotlin metadata */
    private ImageView mBannerRightIcon;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final String TAG = "GroupAlbumBannerPart";

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final String GROUP_ALBUM_BANNER_INTERVAL_TIME_KEY_PREFIX = "GroupAlbumBannerIntervalTime";

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final String GROUP_ALBUM_BANNER_SHOW_TIME_KEY_PREFIX = "GroupAlbumBannerShowTime";

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private aj mTabViewModel;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private RelativeLayout mBannerLayout;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private ImageView mBannerLeftIcon;

    private final boolean C9(GroupAlbumBannerEvent data) {
        if (data.getIsHasPermission()) {
            return false;
        }
        return (System.currentTimeMillis() / ((long) 1000)) - com.qzone.reborn.util.i.b().h(E9(), 0L) >= com.qzone.reborn.util.i.b().h(D9(), 2592000L);
    }

    private final String D9() {
        return this.GROUP_ALBUM_BANNER_INTERVAL_TIME_KEY_PREFIX + "_" + LoginData.getInstance().getUin();
    }

    private final String E9() {
        return this.GROUP_ALBUM_BANNER_SHOW_TIME_KEY_PREFIX + "_" + LoginData.getInstance().getUin();
    }

    private final void F9(GroupAlbumBannerEvent data) {
        Drawable drawable;
        if (data.getActionUrl().equals(GroupAlbumBannerEvent.INSTANCE.a())) {
            drawable = getActivity().getDrawable(R.drawable.f13640e);
        } else {
            drawable = getActivity().getDrawable(R.drawable.f13630d);
        }
        ImageView imageView = this.mBannerLeftIcon;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBannerLeftIcon");
            imageView = null;
        }
        imageView.setImageDrawable(drawable);
    }

    private final void G9() {
        ImageView imageView = this.mBannerRightIcon;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBannerRightIcon");
            imageView = null;
        }
        imageView.setOnClickListener(this);
    }

    private final void H9() {
        Intent intent = new Intent();
        intent.putExtra(AppConstants.LeftViewText.LEFTVIEWTEXT, getActivity().getString(R.string.i7o));
        aj ajVar = this.mTabViewModel;
        aj ajVar2 = null;
        if (ajVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTabViewModel");
            ajVar = null;
        }
        intent.putExtra("troop_uin", ajVar.P1().getGroupId());
        intent.putExtra("uin", LoginData.getInstance().getUin());
        aj ajVar3 = this.mTabViewModel;
        if (ajVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTabViewModel");
        } else {
            ajVar2 = ajVar3;
        }
        if (TextUtils.isEmpty(ajVar2.P1().getGroupId())) {
            return;
        }
        QPublicFragmentActivity.start(getActivity(), intent, com.tencent.mobileqq.troopmanage.base.b.c());
    }

    private final void J9(GroupAlbumBannerEvent data) {
        RelativeLayout relativeLayout = null;
        if (data.getIsHasPermission()) {
            RelativeLayout relativeLayout2 = this.mBannerLayout;
            if (relativeLayout2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBannerLayout");
                relativeLayout2 = null;
            }
            relativeLayout2.setVisibility(8);
        } else {
            RelativeLayout relativeLayout3 = this.mBannerLayout;
            if (relativeLayout3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBannerLayout");
                relativeLayout3 = null;
            }
            relativeLayout3.setVisibility(0);
        }
        if (data.getActionUrl().equals(GroupAlbumBannerEvent.INSTANCE.a())) {
            RelativeLayout relativeLayout4 = this.mBannerLayout;
            if (relativeLayout4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBannerLayout");
            } else {
                relativeLayout = relativeLayout4;
            }
            relativeLayout.setOnClickListener(this);
        }
    }

    private final void K9(GroupAlbumBannerEvent data) {
        com.qzone.reborn.util.i.b().p(D9(), data.getIntervalTime());
    }

    private final void L9() {
        com.qzone.reborn.util.i.b().p(D9(), System.currentTimeMillis() / 1000);
    }

    private final void M9(GroupAlbumBannerEvent data) {
        TextView textView = this.mBannerText;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBannerText");
            textView = null;
        }
        textView.setText(data.getText());
    }

    public final void I9(GroupAlbumBannerEvent data) {
        Intrinsics.checkNotNullParameter(data, "data");
        K9(data);
        if (C9(data)) {
            L9();
            J9(data);
            G9();
            F9(data);
            M9(data);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v3) {
        EventCollector.getInstance().onViewClickedBefore(v3);
        RelativeLayout relativeLayout = null;
        Integer valueOf = v3 != null ? Integer.valueOf(v3.getId()) : null;
        if (valueOf != null && valueOf.intValue() == R.id.jt6) {
            RelativeLayout relativeLayout2 = this.mBannerLayout;
            if (relativeLayout2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBannerLayout");
            } else {
                relativeLayout = relativeLayout2;
            }
            relativeLayout.setVisibility(8);
        } else if (valueOf != null && valueOf.intValue() == R.id.jsk) {
            H9();
        }
        EventCollector.getInstance().onViewClicked(v3);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        View findViewById = rootView.findViewById(R.id.jsk);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.\u2026roup_album_banner_layout)");
        RelativeLayout relativeLayout = (RelativeLayout) findViewById;
        this.mBannerLayout = relativeLayout;
        if (relativeLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBannerLayout");
            relativeLayout = null;
        }
        relativeLayout.setVisibility(8);
        View findViewById2 = rootView.findViewById(R.id.jsu);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "rootView.findViewById(R.\u2026p_album_banner_left_icon)");
        this.mBannerLeftIcon = (ImageView) findViewById2;
        View findViewById3 = rootView.findViewById(R.id.jvk);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "rootView.findViewById(R.\u2026.group_album_banner_text)");
        this.mBannerText = (TextView) findViewById3;
        View findViewById4 = rootView.findViewById(R.id.jt6);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "rootView.findViewById(R.\u2026_album_banner_right_icon)");
        this.mBannerRightIcon = (ImageView) findViewById4;
        ViewModel viewModel = getViewModel(aj.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "getViewModel(GroupAlbumM\u2026TabViewModel::class.java)");
        this.mTabViewModel = (aj) viewModel;
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartCreate(Activity activity, Bundle savedInstanceState) {
        super.onPartCreate(activity, savedInstanceState);
        SimpleEventBus.getInstance().registerReceiver(this);
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        super.onPartDestroy(activity);
        SimpleEventBus.getInstance().unRegisterReceiver(this);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent event) {
        if (event instanceof GroupAlbumBannerEvent) {
            I9((GroupAlbumBannerEvent) event);
        }
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class<SimpleBaseEvent>> getEventClass() {
        ArrayList<Class<SimpleBaseEvent>> arrayListOf;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(GroupAlbumBannerEvent.class);
        return arrayListOf;
    }
}
